package com.doubleant.externalws.common.vo;

import com.doubleant.externalws.util.DateUtils;
import lombok.Data;

/**
 * 业务报文头
 * 
 * @author xiong.hx
 * @date 2017年7月19日
 */
@Data
public class ResponseHead {

	/**
	 * 返回码
	 */
	public String code;

	/**
	 * 返回描述
	 */
	public String msg;

	/**
	 * 响应时间
	 */
	public String responseTime;

	/**
	 * 签名
	 */
	public String sign;

	public ResponseHead() {
		super();
		this.responseTime = DateUtils.toString(DateUtils.now());
	}

	public ResponseHead(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
