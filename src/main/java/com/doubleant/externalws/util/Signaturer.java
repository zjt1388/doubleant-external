package com.doubleant.externalws.util;

import java.security.SignatureException;

/**
 * 加签接口
 * 
 * @author xiong.hx
 * @date 2017年7月18日
 */
public interface Signaturer {

	/**
	 * 生成签名
	 * 
	 * @param data
	 * @return
	 * @throws SignatureException
	 * @author xiong.hx
	 */
	String sign(String data);

}
