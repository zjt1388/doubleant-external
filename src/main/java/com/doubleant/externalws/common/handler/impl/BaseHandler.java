package com.doubleant.externalws.common.handler.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.doubleant.externalws.common.dto.ReqBaseDTO;
import com.doubleant.externalws.common.em.ResultCode;
import com.doubleant.externalws.common.vo.RequestHead;
import com.doubleant.externalws.common.vo.RequestVo;
import com.doubleant.externalws.common.vo.ResponseHead;
import com.doubleant.externalws.common.vo.ResponseVo;
import com.doubleant.externalws.common.dto.RpcRespDTO;
import com.doubleant.externalws.common.handler.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 接口实现基础处理类
 * 
 * @param <T>
 * @author xiong.hx
 * @date 2017年7月24日
 */
public abstract class BaseHandler<T> implements Handler {

	protected static final Logger logger = LoggerFactory.getLogger(BaseHandler.class);

	@Override
	public ResponseVo execute(RequestVo requestVo) {

		ReqBaseDTO<T> rpcReq = new ReqBaseDTO<>();
		RequestHead headDTO = JSON.parseObject(requestVo.getHead(), RequestHead.class);
		T body = parseObject(requestVo.getBody());
		logger.info("class====={}",getClazz());

		rpcReq.setHead(headDTO);
		rpcReq.setBody(body);

		/**
		 * 各个接口自由调用RPC接口
		 */
		logger.info("rpcReq:{}", JSON.toJSONString(rpcReq));
		RpcRespDTO<?> rpcRespDTO = null;
		try {
			rpcRespDTO = requestRpc(rpcReq);
		} catch (Exception e) {
			logger.error("remote service call error:", e);
			return new ResponseVo(ResultCode.ERR_RPC_FAIL);
		}
		logger.info("rpcResp:{}", JSON.toJSONString(rpcRespDTO));
		
		ResponseVo responseVo = new ResponseVo();
		ResponseHead respHead = new ResponseHead();
		BeanUtils.copyProperties(rpcRespDTO, respHead);
		responseVo.setHead(respHead);
		responseVo.setBody(JSON.toJSONString(rpcRespDTO.getData()));
		
		return responseVo;
	}

	/**
	 * 解析mqText
	 *
	 * @param mqText
	 * @return
	 */
	private T parseObject(String mqText) {
		return JSONObject.parseObject(mqText, getClazz());
	}

	private Class<T> getClazz() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType p = (ParameterizedType) t;
		Class<T> c = (Class<T>) p.getActualTypeArguments()[0];
		return c;
	}


	@Override
	public boolean support(String operation) {
		if (getOperation().equals(operation)) {
			return true;
		}
		return false;
	}

	/**
	 * 调用不同的rpc接口，可个性化扩展
	 * 
	 * @param rpcReq
	 * @return
	 * @author xiong.hx
	 */
	public abstract RpcRespDTO<?> requestRpc(ReqBaseDTO<T> rpcReq) throws Exception;

	/**
	 * 获取接口操作方法
	 */
	@Override
	public abstract String getOperation();

}
