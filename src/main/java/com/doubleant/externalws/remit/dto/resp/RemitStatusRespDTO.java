package com.doubleant.externalws.remit.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 批量打款状态respDTO
 * @Author 张敏.
 * @Date 2017/7/21 16:20.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemitStatusRespDTO {

    /**
     * 打款详情
     */
    private List<RemitStatusDetailRespDTO> batchList;
}
