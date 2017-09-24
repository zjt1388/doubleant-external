package com.doubleant.externalws.product.handler.impl;

import com.doubleant.externalws.common.constant.ResultCommonConstant;
import com.doubleant.externalws.common.dto.ReqBaseDTO;
import com.doubleant.externalws.common.dto.RpcRespDTO;
import com.doubleant.externalws.common.em.OperationEnum;
import com.doubleant.externalws.common.handler.impl.BaseHandler;
import com.doubleant.externalws.product.dao.ProductClassifyDao;
import com.doubleant.externalws.product.dto.ProductClassifyItemDTO;
import com.doubleant.externalws.product.dto.ProductClassifyReqDTO;
import com.doubleant.externalws.product.dto.ProductClassifyRespDTO;
import com.doubleant.externalws.product.po.ProductClassifyPO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品功效分类
 * @author zhoujt
 * @create 2017-09-24 17:30
 **/
@Service("productClassifyHandler")
public class ProductClassifyHandler extends BaseHandler<ProductClassifyReqDTO> {

    private static final Logger logger = LoggerFactory.getLogger(ProductClassifyHandler.class);

    @Autowired
    private ProductClassifyDao productClassifyDao;

    @Override
    public RpcRespDTO<ProductClassifyRespDTO> requestRpc(ReqBaseDTO<ProductClassifyReqDTO> rpcReq) {
        ProductClassifyRespDTO respDTO = new ProductClassifyRespDTO();
        List<ProductClassifyPO> productClassifyPOS = productClassifyDao.getAllClassify();
        if(CollectionUtils.isNotEmpty(productClassifyPOS)){
            List<ProductClassifyItemDTO> itemDTOList = new ArrayList<>();
            for(ProductClassifyPO classifyPO : productClassifyPOS){
                ProductClassifyItemDTO itemDTO = new ProductClassifyItemDTO();
                itemDTO.setClassifyName(classifyPO.getTypeName());
                itemDTO.setClassifyNameZh(classifyPO.getTypeNameZh());
                itemDTOList.add(itemDTO);
            }
            respDTO.setItems(itemDTOList);
        }else {
            return new RpcRespDTO<>(ResultCommonConstant.CODE_NO_DATA_FOUND,ResultCommonConstant.MSG_NO_DATA_FOUND,respDTO);
        }
        return new RpcRespDTO<>(ResultCommonConstant.CODE_SUCCESS,ResultCommonConstant.MSG_SUCCESS,respDTO);
    }

    @Override
    public String getOperation() {
        return OperationEnum.QUERY_PRODUCT_CLASSIFY.getCode();
    }
}
