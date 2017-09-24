package com.doubleant.externalws.remit.handler.impl;

import com.doubleant.externalws.common.constant.ResultCommonConstant;
import com.doubleant.externalws.common.dto.ReqBaseDTO;
import com.doubleant.externalws.common.dto.RpcRespDTO;
import com.doubleant.externalws.common.em.OperationEnum;
import com.doubleant.externalws.common.handler.impl.BaseHandler;
import com.doubleant.externalws.common.vo.RequestHead;
import com.doubleant.externalws.merchant.dto.req.OrderListReqDTO;
import com.doubleant.externalws.merchant.dto.resp.OrderListRespDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 打款对账状态
 * @author jetman_zhang@suishouji.com
 * @create 2017-07-31 10:39
 **/
@Service("remitCheckReqHandler")
public class RemitCheckReqHandler extends BaseHandler<OrderListReqDTO> {

    private static final Logger logger = LoggerFactory.getLogger(RemitCheckReqHandler.class);

    @Override
    public RpcRespDTO<OrderListRespDTO> requestRpc(ReqBaseDTO<OrderListReqDTO> rpcReq) {
        if (rpcReq == null || rpcReq.getHead() == null || rpcReq.getBody() == null) {
            return new RpcRespDTO<>(ResultCommonConstant.CODE_ERR_PARAM,ResultCommonConstant.MSG_ERR_PARAM);
        }
        RequestHead headDTO = rpcReq.getHead();
        OrderListReqDTO bodyDTO = rpcReq.getBody();

        //组装返回dto
        OrderListRespDTO detailRespDTO = new OrderListRespDTO();

        return new RpcRespDTO<>(ResultCommonConstant.CODE_SUCCESS,ResultCommonConstant.MSG_SUCCESS,detailRespDTO);
    }


    @Override
    public String getOperation() {
        return OperationEnum.MERCHANT_REMIT_CHECK.getCode();
    }
}
