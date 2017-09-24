package com.doubleant.externalws.log.service;

/**
 * @author jiantao_zhou@kingdee.com
 * @Date 2017-03-15 14:37
 * @Title 日志接口
 */
public interface LogService<T> {

    /**
     * 保存日志
     */
    void saveLog(T t);
}
