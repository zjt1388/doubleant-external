package com.doubleant.externalws.merchant.dao;

/**
 * 商户盐
 * @author jiantao_zhou@kingdee.com
 * @create 2017-08-01 14:44
 **/
public interface MerchantSaltDao {

    /**
     * 查询商户盐
     * @param merchantNo
     * @return
     */
    String getByIdenty(String merchantNo);
}
