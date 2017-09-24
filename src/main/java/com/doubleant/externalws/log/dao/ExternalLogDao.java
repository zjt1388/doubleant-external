package com.doubleant.externalws.log.dao;

import com.doubleant.externalws.log.po.ExternalLogPO;

/**
 * 日志
 * @author jiantao_zhou@kingdee.com
 * @create 2017-08-02 15:04
 **/
public interface ExternalLogDao {

    int insert(ExternalLogPO logPO);
}
