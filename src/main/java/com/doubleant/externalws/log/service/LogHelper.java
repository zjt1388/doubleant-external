package com.doubleant.externalws.log.service;

import com.alibaba.fastjson.JSON;
import com.doubleant.externalws.common.vo.RequestHead;
import com.doubleant.externalws.common.vo.RequestVo;
import com.doubleant.externalws.common.vo.ResponseVo;
import com.doubleant.externalws.log.dto.AccountExternalWsLogDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 账户对外接口调用日志
 * @author jiantao_zhou@kingdee.com
 */
@Aspect
@Component
public class LogHelper {

    @Resource(name = "externalLogService")
    private LogService<AccountExternalWsLogDTO> externalLogService;

    private static final String QUERY_SIGH_OTHER = "other";

    /**
     * 账户对外接口调用日志
     * @param pjp
     * @return
     * @throws Throwable
     */
    @SuppressWarnings("unchecked")
	//@Around("execution(* com.doubleant.externalws.common.AcceptSupport.acceptIn(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 获取方法
        String method = pjp.getSignature().getName();
        // 获取参数
        String reqArgs = JSON.toJSONString(pjp.getArgs());
        Object[] args = pjp.getArgs();
        Date reqTime = new Date();
        Object returnValue = new Object();
        AccountExternalWsLogDTO logDTO = new AccountExternalWsLogDTO();
        if (args.length > 0) {
            try {
                Object requestParam = args[0];
                Object operationParam = args[1];
                RequestVo requestVo = JSON.parseObject(requestParam.toString(), RequestVo.class);
                RequestHead head = JSON.parseObject(requestVo.getHead(), RequestHead.class);
                logDTO.setReqNo(head.getReqNo());
                logDTO.setMethodName(operationParam.toString());
                logDTO.setSource(head.getSource());
            } catch (Exception e) {
                logDTO.setReqNo(QUERY_SIGH_OTHER);
                logDTO.setMethodName(QUERY_SIGH_OTHER);
                logDTO.setSource(QUERY_SIGH_OTHER);
            }
        }else{
            logDTO.setReqNo(QUERY_SIGH_OTHER);
            logDTO.setMethodName(QUERY_SIGH_OTHER);
            logDTO.setSource(QUERY_SIGH_OTHER);
        }
        logDTO.setRequestTime(reqTime);
        logDTO.setReqParam(reqArgs);
        try {
            returnValue = pjp.proceed();
        } catch (Exception e) {
            logDTO.setResponseTime(new Date());
            logDTO.setErrMsg(e.getMessage());
            externalLogService.saveLog(logDTO);
            throw e;
        }
        //保存日志
        ResponseVo responseVo = JSON.parseObject(returnValue.toString(), ResponseVo.class);
        Date rspTime = new Date();
        logDTO.setResponseTime(rspTime);
        logDTO.setRespParam(returnValue.toString());
        logDTO.setUseTime(rspTime.getTime() - reqTime.getTime());
        logDTO.setRstCode(responseVo.getHead().getCode());
        logDTO.setRstMsg(responseVo.getHead().getMsg());
        externalLogService.saveLog(logDTO);
        return returnValue;
    }
}
