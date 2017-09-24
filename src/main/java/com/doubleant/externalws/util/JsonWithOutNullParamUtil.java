package com.doubleant.externalws.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chl
 * @version 1.0
 * @calssName JsonWithOutNullParamUtil
 * @description JSON序列化工具类(排除null属性)
 * @date 2017/3/3
 */
public class JsonWithOutNullParamUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonWithOutNullParamUtil.class);

	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
	}

	public static String getJsonString(Object object) {
		if (object == null) {
			return "";
		}
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			LOGGER.error("JSON序列化出现异常！", e);
		}
		return "";
	}
}