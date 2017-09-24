package com.doubleant.externalws.util;

/**
 * @author chl
 * @version 1.0
 * @calssName ParamsCheckUtil
 * @description 参数校验工具类
 * @date 2017/4/18
 */
public class ParamsCheckUtil {

	/**
	 * Long值无效
	 *
	 * @param longValue
	 * @return
	 */
	public static boolean isInvalidLongValue(Long longValue) {
		return longValue == null || longValue == 0L;
	}

}