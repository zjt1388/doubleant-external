package com.doubleant.externalws.remit.handler.impl;

import com.doubleant.externalws.common.constant.ResultCommonConstant;
import com.doubleant.externalws.common.dto.ReqBaseDTO;
import com.doubleant.externalws.common.em.OperationEnum;
import com.doubleant.externalws.common.handler.impl.BaseHandler;
import com.doubleant.externalws.common.dto.RpcRespDTO;
import com.doubleant.externalws.merchant.dao.MerchantSaltDao;
import com.doubleant.externalws.remit.dto.req.RemitReqDTO;
import com.doubleant.externalws.remit.dto.resp.RemitRespDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 批量打款请求
 * @author jetman_zhang@suishouji.com
 * @create 2017-07-31 10:39
 **/
@Service("batchRemitReqHandler")
public class BatchRemitReqHandler extends BaseHandler<RemitReqDTO> {

    private static final Logger logger = LoggerFactory.getLogger(BatchRemitReqHandler.class);

    @Autowired
    private MerchantSaltDao merchantSaltDao;

    @Override
    public RpcRespDTO<RemitRespDTO> requestRpc(ReqBaseDTO<RemitReqDTO> rpcReq) {
        return new RpcRespDTO<>(ResultCommonConstant.CODE_SUCCESS,ResultCommonConstant.MSG_SUCCESS,RemitRespDTO.builder().batchNo("1111").build());
    }

    @Override
    public String getOperation() {
        return OperationEnum.MERCHANT_BATCH_REMIT.getCode();
    }
}
