package com.doubleant.externalws.log.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 调用日志表
 * @author jiantao_zhou@kingdee.com
 * @create 2017-08-02 15:08
 **/
@Data
@NoArgsConstructor
public class ExternalLogPO {

    private Long id;
    /**
     * 请求编号
     */
    private String reqNo;
    /**
     * 来源
     */
    private String source;
    /**
     * 接口名称
     */
    private String methodName;
    /**
     * 请求时间
     */
    private Date requestTime;
    /**
     * 响应时间
     */
    private Date responseTime;
    /**
     * 方法用时（毫秒）
     */
    private Long useTime;
    /**
     * 返回码
     */
    private String rstCode;
    /**
     * 返回信息
     */
    private String rstMsg;
    /**
     * 异常错误信息
     */
    private String errMsg;

    private Date createTime;
}
