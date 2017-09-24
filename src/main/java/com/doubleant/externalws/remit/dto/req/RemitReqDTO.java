package com.doubleant.externalws.remit.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 打款请求dto
 * @Author 张敏.
 * @Date 2017/7/21 15:56.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitReqDTO {
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 批次大小
     */
    private Integer batchSize;
    /**
     * 总金额
     */
    private Long totalAmount;
    /**
     * 产品名称
     */
    private String pname;
    /**
     * 还款详情
     */
    private List<RemitDetailReqDTO> batchDetail;
}
