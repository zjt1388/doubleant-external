package com.doubleant.externalws.merchant.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询订单请求dto
 * @Author 张敏.
 * @Date 2017/7/21 15:56.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderListReqDTO {
    /**
     * 交易日期
     */
    private String tradeDate;
    /**
     * 页码
     */
    private Integer pageNo;

}
