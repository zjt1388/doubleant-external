package com.doubleant.externalws.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 产品分类返回
 * Created by zhoujt
 * on 2017/9/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductClassifyItemDTO implements Serializable{

    private static final long serialVersionUID = 9003488887438930616L;

    private String classifyName;
    /**
     * 中文分类名称
     */
    private String classifyNameZh;
}
