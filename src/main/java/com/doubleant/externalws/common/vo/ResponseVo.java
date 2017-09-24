package com.doubleant.externalws.common.vo;

import com.doubleant.externalws.common.em.ResultCode;
import lombok.Data;

/**
 * WS响应VO对象
 * 
 * @author xiong.hx
 * @date 2017年7月19日
 */
@Data
public class ResponseVo {

	/**
	 * 业务报文头
	 */
	private ResponseHead head;

	/**
	 * 业务报文体
	 */
	private String body;

	public ResponseVo() {
		super();
	}

	public ResponseVo(String code, String msg) {
		this.head = new ResponseHead(code, msg);
	}

	public ResponseVo(ResultCode resultCode) {
		this.head = new ResponseHead(resultCode.getCode(), resultCode.getDescription());
	}
}
