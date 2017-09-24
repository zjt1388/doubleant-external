package com.doubleant.externalws.merchant.handler.impl;

import com.doubleant.externalws.common.constant.ResultCommonConstant;
import com.doubleant.externalws.common.dto.ReqBaseDTO;
import com.doubleant.externalws.common.dto.RpcRespDTO;
import com.doubleant.externalws.common.em.OperationEnum;
import com.doubleant.externalws.common.handler.impl.BaseHandler;
import com.doubleant.externalws.merchant.dao.MerchantSaltDao;
import com.doubleant.externalws.merchant.dto.resp.MerchantInfoRespDTO;
import com.doubleant.externalws.user.dto.req.SsjInfoReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询商户余额
 * @author jiantao_zhou@kingdee.com
 * @create 2017-07-31 19:40
 **/
@Service("queryMerchantBalanceHandler")
public class QueryMerchantBalanceHandler extends BaseHandler<SsjInfoReqDTO> {

    @Autowired
    private MerchantSaltDao merchantSaltDao;

    @Override
    public RpcRespDTO<?> requestRpc(ReqBaseDTO<SsjInfoReqDTO> rpcReq) throws Exception{
        MerchantInfoRespDTO infoRespDTO = new MerchantInfoRespDTO();
        infoRespDTO.setMerchantNo(rpcReq.getHead().getMerchantNo());
        return new RpcRespDTO<>(ResultCommonConstant.CODE_MERCHANT_NOT_EXIST,ResultCommonConstant.MSG_MERCHANT_NOT_EXIST,infoRespDTO);
    }

    @Override
    public String getOperation() {
        return OperationEnum.MERCHANT_BALANCE.getCode();
    }
}
