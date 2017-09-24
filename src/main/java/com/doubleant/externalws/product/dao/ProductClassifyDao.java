package com.doubleant.externalws.product.dao;



import com.doubleant.externalws.product.po.ProductClassifyPO;

import java.util.List;

public interface ProductClassifyDao {
	
    int insert(ProductClassifyPO classifyPO);

    /**
     * 查询所有数据
     * @return
     */
    List<ProductClassifyPO> getAllClassify();
}
