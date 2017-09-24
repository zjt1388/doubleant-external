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
public class WsAccountRespDTO implements Serializable {

	private static final long serialVersionUID = 5353683574922132L;


	/**
	 * 状态码
	 */
	private String code;

	/**
	 * 状态消息
	 */
	private String msg;
	/**
	 * 响应时间
	 */
	private String responseTime;
	/**
	 * 签名
	 */
	private String sign;


	public boolean flagSuccess() {
		return ResultCommonConstant.CODE_SUCCESS.equals(this.code);
	}

	/**
	 * 构造没有body节点的成功响应数据.
	 *
	 * @return
	 */
	public static WsAccountRespDTO builderSuccessRespData() {
		WsAccountRespDTO response = new WsAccountRespDTO();
		response.setCode(ResultCommonConstant.CODE_SUCCESS);
		response.setMsg(ResultCommonConstant.MSG_SUCCESS);
		return response;
	}

	/**
	 * 构造服务器未知异常响应数据.
	 */
	public static WsAccountRespDTO builderFailedRespData() {
		WsAccountRespDTO response = new WsAccountRespDTO();
		response.setCode(ResultCommonConstant.CODE_ERR_UNKNOWN);
		response.setMsg(ResultCommonConstant.MSG_ERR_UNKNOWN);
		return response;
	}

	/**
	 * 构造异常响应数据.
	 */
	public static WsAccountRespDTO builderFailedRespData(String msg) {
		WsAccountRespDTO response = new WsAccountRespDTO();
		response.setCode(ResultCommonConstant.CODE_ERR_UNKNOWN);
		response.setMsg(msg);
		return response;
	}

	/**
	 * 构造异常响应数据.
	 */
	public static WsAccountRespDTO builderFailedRespData(String code, String msg) {
		WsAccountRespDTO response = new WsAccountRespDTO();
		response.setCode(code);
		response.setMsg(msg);
		return response;
	}

	/**
	 * 构造找不到数据响应数据.
	 */
	public static WsAccountRespDTO builderRespNoDataFound() {
		WsAccountRespDTO response = new WsAccountRespDTO();
		response.setCode(ResultCommonConstant.CODE_NO_DATA_FOUND);
		response.setMsg(ResultCommonConstant.MSG_NO_DATA_FOUND);
		return response;
	}

	/**
	 * 构造自定义响应应数据
	 *
	 * @param code
	 * @param msg
	 */
	public static WsAccountRespDTO builderRespData( String code, String msg) {
		WsAccountRespDTO response = new WsAccountRespDTO();
		response.setCode(code);
		response.setMsg(msg);
		return response;
	}
}
