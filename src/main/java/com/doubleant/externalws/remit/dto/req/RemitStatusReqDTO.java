package com.doubleant.externalws.remit.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 打款状态请求dto
 * @Author 张敏.
 * @Date 2017/7/21 15:56.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitStatusReqDTO {
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 订单号(多个用逗号隔开)
     */
    private String orderNos;

}
