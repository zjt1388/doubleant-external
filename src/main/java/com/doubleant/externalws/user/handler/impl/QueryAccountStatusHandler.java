package com.doubleant.externalws.user.handler.impl;

import com.doubleant.externalws.common.constant.ResultCommonConstant;
import com.doubleant.externalws.common.dto.ReqBaseDTO;
import com.doubleant.externalws.common.em.OperationEnum;
import com.doubleant.externalws.common.handler.impl.BaseHandler;
import com.doubleant.externalws.user.dto.req.SsjInfoReqDTO;
import com.doubleant.externalws.user.dto.resp.UserAccountInfoDTO;
import com.doubleant.externalws.common.dto.RpcRespDTO;
import org.springframework.stereotype.Service;


/**
 * 查询用户开户状态
 * @author jiantao_zhou@kingdee.com
 * @create 2017-07-31 10:39
 **/
@Service("queryAccountStatusHandler")
public class QueryAccountStatusHandler extends BaseHandler<SsjInfoReqDTO> {


    @Override
    public RpcRespDTO<UserAccountInfoDTO> requestRpc(ReqBaseDTO<SsjInfoReqDTO> rpcReq) throws Exception{
        SsjInfoReqDTO reqDTO = rpcReq.getBody();
        UserAccountInfoDTO infoDTO = new UserAccountInfoDTO();
        infoDTO.setSsjId(reqDTO.getSsjId());
        boolean openFlag = false;
        if(openFlag){
            infoDTO.setIsOpenAccount(UserAccountInfoDTO.IS_OPEN);
        }else {
            infoDTO.setIsOpenAccount(UserAccountInfoDTO.IS_NOT_OPEN);
        }
        return new RpcRespDTO<>(ResultCommonConstant.CODE_SUCCESS,ResultCommonConstant.MSG_SUCCESS,infoDTO);
    }

    @Override
    public String getOperation() {
        return OperationEnum.QUERY_OPEN_ACCOUNT_STATUS.getCode();
    }
}
