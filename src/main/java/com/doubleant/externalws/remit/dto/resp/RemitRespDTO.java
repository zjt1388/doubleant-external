package com.doubleant.externalws.remit.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量打款respDTO
 * @Author 张敏.
 * @Date 2017/7/21 16:20.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemitRespDTO {
    /**
     * 批次号
     */
    private String batchNo;
}
