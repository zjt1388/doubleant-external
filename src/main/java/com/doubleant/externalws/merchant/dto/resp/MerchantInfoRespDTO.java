package com.doubleant.externalws.merchant.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商户信息
 * @Author 张敏.
 * @Date 2017/7/21 14:40.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantInfoRespDTO implements Serializable{

    private static final long serialVersionUID = -2471609361765497113L;
    /**
     * 商户编号
     */
    private String merchantNo;
    /**
     * 余额
     */
    private Long balance;
    /**
     * 可用余额
     */
    private Long availableBalance;
    /**
     * 冻结余额
     */
    private Long frost;
}
