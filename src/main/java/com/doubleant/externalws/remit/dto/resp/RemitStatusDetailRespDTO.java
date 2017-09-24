package com.doubleant.externalws.remit.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量打款状态详情respDTO
 * @Author 张敏.
 * @Date 2017/7/21 16:20.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemitStatusDetailRespDTO {
    /**
     * 状态
     */
    private Integer status;
    /**
     * 金额
     */
    private Long amount;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 交易流水号
     */
    private String transNo;
    /**
     * 交易完成时间
     */
    private String tradeFinishTime;
    /**
     * 状态描述
     */
    private String statusDesc;

}
