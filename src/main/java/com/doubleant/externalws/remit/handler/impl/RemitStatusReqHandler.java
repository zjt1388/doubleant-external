package com.doubleant.externalws.remit.handler.impl;

import com.doubleant.externalws.common.constant.ResultCommonConstant;
import com.doubleant.externalws.common.dto.ReqBaseDTO;
import com.doubleant.externalws.common.dto.RpcRespDTO;
import com.doubleant.externalws.common.em.OperationEnum;
import com.doubleant.externalws.common.handler.impl.BaseHandler;
import com.doubleant.externalws.common.vo.RequestHead;
import com.doubleant.externalws.remit.dto.req.RemitStatusReqDTO;
import com.doubleant.externalws.remit.dto.resp.RemitStatusRespDTO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 查询打款状态
 * @author jetman_zhang@suishouji.com
 * @create 2017-07-31 10:39
 **/
@Service("remitStatusReqHandler")
public class RemitStatusReqHandler extends BaseHandler<RemitStatusReqDTO>{

    private static final Logger logger = LoggerFactory.getLogger(RemitStatusReqHandler.class);


    @Override
    public RpcRespDTO<RemitStatusRespDTO> requestRpc(ReqBaseDTO<RemitStatusReqDTO> rpcReq) {
        if (rpcReq == null || rpcReq.getHead() == null || rpcReq.getBody() == null || StringUtils.isBlank(rpcReq.getBody().getBatchNo())) {
            return new RpcRespDTO<>(ResultCommonConstant.CODE_ERR_PARAM,ResultCommonConstant.MSG_ERR_PARAM);
        }
        RequestHead headDTO = rpcReq.getHead();
        RemitStatusReqDTO remitReqDTO = rpcReq.getBody();

        return new RpcRespDTO<>(ResultCommonConstant.CODE_SUCCESS,ResultCommonConstant.MSG_SUCCESS,null);
    }


    @Override
    public String getOperation() {
        return OperationEnum.MERCHANT_REMIT_STATUS.getCode();
    }
}
