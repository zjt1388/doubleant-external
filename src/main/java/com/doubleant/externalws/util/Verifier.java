package com.doubleant.externalws.util;

/**
 * 验签接口
 * 
 * @author xiong.hx
 * @date 2017年7月18日
 */
public interface Verifier {

	/**
	 * 验签
	 * 
	 * @param data
	 * @param sign
	 * @return
	 * @author xiong.hx
	 */
	boolean verify(String data, String sign);

}
