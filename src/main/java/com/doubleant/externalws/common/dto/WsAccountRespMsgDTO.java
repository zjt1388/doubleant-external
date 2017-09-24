package com.doubleant.externalws.common.dto;

import com.doubleant.externalws.common.constant.ResultCommonConstant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * web service 公共参数返回VO
 *
 * @author chl
 * @date 2016/6/2
 */
@Data
@NoArgsConstructor
public class WsAccountRespMsgDTO<T> extends WsAccountRespDTO implements Serializable {

	private static final long serialVersionUID = -6940735963292571240L;

	private T body;


	/**
	 * 构造成功响应数据.
	 *
	 * @param body
	 * @return
	 */
	public static <T> WsAccountRespMsgDTO<T> builderSuccessRespData(T body) {
		WsAccountRespMsgDTO<T> response = new WsAccountRespMsgDTO<T>();
		response.setCode(ResultCommonConstant.CODE_SUCCESS);
		response.setMsg(ResultCommonConstant.MSG_SUCCESS);
		response.setBody(body);
		response.setSign("");
		return response;
	}

	/**
	 * 构造断路器注解异常响应数据.
	 *
	 * @return
	 */
	public static <T> WsAccountRespMsgDTO<T> builderHystrixAnnotationErrRespData() {
		WsAccountRespMsgDTO<T> response = new WsAccountRespMsgDTO<T>();
		response.setCode(ResultCommonConstant.CODE_HYSTRIX_ANNOTATION_ERR_BIZCODE);
		response.setMsg(ResultCommonConstant.MSG_HYSTRIX_ANNOTATION_ERR_BIZCODE);
		response.setBody(null);
		return response;
	}

	/**
	 * 构造断路器降级响应数据.
	 *
	 * @return
	 */
	public static <T> WsAccountRespMsgDTO<T> builderHystrixFallBackRespData() {
		WsAccountRespMsgDTO<T> response = new WsAccountRespMsgDTO<T>();
		response.setCode(ResultCommonConstant.CODE_HYSTRIX_FALL_BACK_BIZCODE);
		response.setMsg(ResultCommonConstant.MSG_HYSTRIX_FALL_BACK_BIZCODE);
		response.setBody(null);
		return response;
	}

	/**
	 * 构造相应数据
	 *
	 * @param code
	 * @param msg
	 * @param body
	 */
	public static <T> WsAccountRespMsgDTO<T> builderRespData(String code, String msg, T body) {
		WsAccountRespMsgDTO<T> response = new WsAccountRespMsgDTO<T>();
		response.setCode(code);
		response.setMsg(msg);
		if (body != null) {
			response.setBody(body);
		}
		return response;
	}
}
