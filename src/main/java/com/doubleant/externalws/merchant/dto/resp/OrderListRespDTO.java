package com.doubleant.externalws.merchant.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 订单历史信息
 * @Author 张敏.
 * @Date 2017/7/21 14:40.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderListRespDTO {
    /**
     * 总条数
     */
    private Long totalCount;
    /**
     * 订单详情
     */
    private List<OrderListDetailRespDTO> orderList;
}
