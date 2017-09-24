package com.doubleant.externalws.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.doubleant.externalws.common.em.ResultCode;
import com.doubleant.externalws.common.vo.RequestHead;
import com.doubleant.externalws.common.vo.RequestVo;
import com.doubleant.externalws.common.vo.ResponseHead;
import com.doubleant.externalws.common.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * ws请求路由处理器
 * 
 * @author xiong.hx
 * @date 2017年7月19日
 */
@Component
public class AcceptSupport {

	private static final Logger logger = LoggerFactory.getLogger(AcceptSupport.class);

	@Autowired
	private SecurityCenter securityCenter;
	@Autowired
	private RequestRoute requestRoute;

	/**
	 * 公共入口
	 *
	 * @param request
	 * @return
	 */
	public String acceptIn(String request, String operation) {
		logger.info("accept request => {}", request);
		if (StringUtils.isEmpty(request)) {
			logger.error("AcceptSupport, 收到请求为空");
			return buildErrorResponse(ResultCode.ERR_EMPTY_REQUST);
		}

		RequestVo requestVo = JSON.parseObject(request, RequestVo.class);
		RequestHead head = JSON.parseObject(requestVo.getHead(), RequestHead.class);
		//校验head参数
		if(!this.validateHeadParam(head)){
			logger.error("请求head参数校验失败:{}", head == null ? null : JSON.toJSONString(head));
			return buildErrorResponse(ResultCode.ERR_EMPTY_PARAM);
		}
		String reqNo = head.getReqNo();
		String source = head.getSource();
		String body = requestVo.getBody();
		// 验签
		//boolean verifierResult = securityCenter.verify(body, head.getSign(), source);
		boolean verifierResult = true;
		if (!verifierResult) {
			// 验签失败，直接返回
			logger.error("验签失败:{}", head.getSign());
			return buildErrorResponse(ResultCode.ERR_WRONG_SIGN);
		}

		// 解密
		//body = securityCenter.decode(body, source);
		requestVo.setBody(body);

		// 请求路由
		ResponseVo responseVo = requestRoute.route(operation, requestVo);

		// 对响应报文进行加密
		String respBody = responseVo.getBody();
		//respBody = securityCenter.encode(sortJson(respBody), source);
		responseVo.setBody(respBody);

		try {
			// 设置响应报文中的签名
			//String sign = securityCenter.sign(respBody, source);
			String sign = "sign";
			ResponseHead respHead = responseVo.getHead();
			respHead.setSign(sign);
			responseVo.setHead(respHead);
		} catch (Exception e) {
			logger.error("reqNo {} 加签失败 => ", reqNo);
		}

		String res = JSON.toJSONString(responseVo);
		logger.info("reqNo {} accept response => {}", reqNo, res);
		return res;
	}

	/**
	 * 校验head参数
	 * @param headParam
	 * @return
	 */
	private boolean validateHeadParam(RequestHead headParam){
		boolean validateFlag = true;
		if(StringUtils.isEmpty(headParam.getReqNo()) ||
				StringUtils.isEmpty(headParam.getMerchantNo()) ||
				StringUtils.isEmpty(headParam.getSource()) ||
				StringUtils.isEmpty(headParam.getSign())){
			validateFlag = false;
		}
		return validateFlag;
	}

	/**
	 * 组装错误报文
	 * @param resultCode
	 */
	private String buildErrorResponse(ResultCode resultCode) {
		return JSON.toJSONString(new ResponseVo(resultCode.getCode(), resultCode.getDescription()));
	}

	/**
	 * 对JSON字符串进行排序
	 */
	private String sortJson(String oriJson) {
		JSONObject jsonObj = JSON.parseObject(oriJson);
		return JSON.toJSONString(jsonObj);
	}

}
