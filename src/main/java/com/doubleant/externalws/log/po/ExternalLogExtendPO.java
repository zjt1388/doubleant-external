package com.doubleant.externalws.log.po;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 日志扩展表
 * @author jiantao_zhou@kingdee.com
 * @create 2017-08-02 15:08
 **/
@Data
@NoArgsConstructor
public class ExternalLogExtendPO {

    private Long id;
    /**
     * 请求参数
     */
    private String requestMsg;
    /**
     * 返回参数
     */
    private String responseMsg;

    private String createTime;
}
