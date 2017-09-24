package com.doubleant.externalws.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 业务报文头
 * 
 * @author xiong.hx
 * @date 2017年7月19日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestHead implements Serializable{

	private static final long serialVersionUID = 2580798829894014363L;
	/**
	 * 来源
	 */
	public String source;

	/**
	 * 签名
	 */
	public String sign;

	/**
	 * 请求号
	 */
	public String reqNo;

	/**
	 * 版本号
	 */
	public String version;
	
	/**
	 * 设备号
	 */
	public String deviceNo;
	
	/**
	 * mac地址
	 */
	public String macAddress;
	
	/**
	 * 客户端请求时间
	 * yyyy-MM-dd HH:mm:ss格式
	 */
	public String requestTime;
	
	/**
	 * 客户端其他信息
	 */
	public String clientInfo;
	/**
	 * 商户编码
	 */
	private String merchantNo;
}
