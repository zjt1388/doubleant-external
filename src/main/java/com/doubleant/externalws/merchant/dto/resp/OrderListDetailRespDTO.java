package com.doubleant.externalws.merchant.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详情
 * @Author 张敏.
 * @Date 2017/7/24 13:56.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderListDetailRespDTO {
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 交易流水号
     */
    private String transNo;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 状态  0：待确认 1：成功 2：失败
     */
    private Integer status;
    /**
     * 金额
     */
    private Long amount;
    /**
     * 交易完成时间（yyyy-MM-dd HH:mm:ss）
     */
    private String tradeFinishTime;
    /**
     * 状态描述
     */
    private String statusDesc;
}
