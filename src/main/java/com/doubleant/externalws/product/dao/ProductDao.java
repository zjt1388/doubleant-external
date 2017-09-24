package com.doubleant.externalws.product.dao;



import com.doubleant.externalws.product.po.ProductPO;

import java.util.List;

public interface ProductDao {
	
    int add(ProductPO productPO);

    /**
     * 根据产品url查询
     * @param productUrl
     * @return
     */
    ProductPO getByProductUrl(String productUrl);

    /**
     * 更新官网地址信息
     * @param productPO
     * @return
     */
    int updateOfficialWebsite(ProductPO productPO);

    /**
     * 查询所有的产品信息
     * @return
     */
    List<ProductPO> getAllProducts();
}
