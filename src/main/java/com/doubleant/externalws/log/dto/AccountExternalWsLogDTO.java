package com.doubleant.externalws.log.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author jiantao_zhou@kingdee.com
 * @create 2017-08-02 14:39
 **/
@Data
@NoArgsConstructor
public class AccountExternalWsLogDTO {
    /**
     * 查询标志
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
     * 请求参数
     */
    private String reqParam;
    /**
     * 请求时间
     */
    private Date requestTime;
    /**
     * 返回参数
     */
    private String respParam;
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
}
