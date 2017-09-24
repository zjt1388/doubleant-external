package com.doubleant.externalws.common.vo;

import lombok.Data;

/**
 * ws请求VO
 * 
 * @author xiong.hx
 * @date 2017年7月19日
 */
@Data
public class RequestVo {

	/**
	 * 业务报文头
	 */
	private String head;

	/**
	 * 业务报文体
	 */
	private String body;
}
