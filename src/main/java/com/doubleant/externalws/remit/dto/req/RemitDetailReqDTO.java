package com.doubleant.externalws.remit.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 还款详情
 * @Author 张敏.
 * @Date 2017/7/21 16:09.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemitDetailReqDTO {
    /**
     * 随手记id
     */
    private String ssjId;
    /**
     * 金额
     */
    private Long amount;
    /**
     * 随手记订单号
     */
    private String orderNo;


}
