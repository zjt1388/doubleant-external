package com.doubleant.externalws.log.service.impl;

import com.doubleant.externalws.log.dao.ExternalLogExtendDao;
import com.doubleant.externalws.log.dao.ExternalLogDao;
import com.doubleant.externalws.log.dto.AccountExternalWsLogDTO;
import com.doubleant.externalws.log.po.ExternalLogExtendPO;
import com.doubleant.externalws.log.po.ExternalLogPO;
import com.doubleant.externalws.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jiantao_zhou@kingdee.com
 * @create 2017-08-02 14:41
 **/
@Service("externalLogService")
public class ExternalLogServiceImpl implements LogService<AccountExternalWsLogDTO>{

    @Autowired
    private ExternalLogDao externalLogDao;
    @Autowired
    private ExternalLogExtendDao externalLogExtendDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveLog(AccountExternalWsLogDTO accountExternalWsLogDTO) {
        ExternalLogPO logPO = new ExternalLogPO();
        logPO.setSource(accountExternalWsLogDTO.getSource());
        logPO.setReqNo(accountExternalWsLogDTO.getReqNo());
        logPO.setMethodName(accountExternalWsLogDTO.getMethodName());
        logPO.setRequestTime(accountExternalWsLogDTO.getRequestTime());
        logPO.setResponseTime(accountExternalWsLogDTO.getResponseTime());
        logPO.setErrMsg(accountExternalWsLogDTO.getErrMsg());
        logPO.setRstCode(accountExternalWsLogDTO.getRstCode());
        logPO.setRstMsg(accountExternalWsLogDTO.getRstMsg());
        logPO.setUseTime(accountExternalWsLogDTO.getUseTime());
        externalLogDao.insert(logPO);
        ExternalLogExtendPO extendPO = new ExternalLogExtendPO();
        extendPO.setId(logPO.getId());
        extendPO.setRequestMsg(accountExternalWsLogDTO.getReqParam());
        extendPO.setResponseMsg(accountExternalWsLogDTO.getRespParam());
        externalLogExtendDao.insert(extendPO);
    }
}
