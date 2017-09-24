package com.doubleant.externalws.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @calssName VersionCompareUtils
 * @description 客户端版本号比较工具类
 * @author chl
 * @version 1.0
 * @date 2016/8/22
 */
public class VersionCompareUtils {

	private static Logger logger = LoggerFactory.getLogger(VersionCompareUtils.class);

	/**
	 * 安卓
	 */
	public static final String ANDROID = "android";
	/**
	 * IOS
	 */
	public static final String IOS = "ios";
	/**
	 * Android特性版本：钱包改造(累计收益\昨日收益,总持仓弹窗提示)
	 */
	private static final String NTV_XR_ANDROID_VER = "10.3.7.0";
	/**
	 * IOS特性版本：钱包改造(累计收益\昨日收益,总持仓弹窗提示)
	 */
	private static final String NTV_XR_IOS_VER = "10.7.0";

	/**
	 * 当前版本与特性号做比较
	 *
	 * @param platform
	 * @param appVersion
	 * @return
	 */
	public static Boolean isAfterFeatureVersion(String platform, String appVersion) {
		if (StringUtils.isBlank(platform) || StringUtils.isBlank(appVersion)) {
			return false;
		}

		String featureVersion = "";
		// 安卓
		if (ANDROID.equalsIgnoreCase(platform)) {
			featureVersion = NTV_XR_ANDROID_VER;
			// IOS
		} else if (IOS.equalsIgnoreCase(platform)) {
			featureVersion = NTV_XR_IOS_VER;
		} else {
			return false;
		}
		return versionCompare(appVersion, featureVersion);
	}

	/**
	 * 判断当前App版本是否符合某个特性版本
	 * @param appVersion 当前App版本
	 * @param featureVersion 特性版本
     * @return
     */
	private static Boolean versionCompare(String appVersion, String featureVersion) {
		if (StringUtils.isBlank(featureVersion)) {
			return false;
		}

		// 版本号一致
		if (appVersion.equals(featureVersion)) {
			return true;
		}

		String[] requestVerArr = appVersion.split("\\.");
		String[] featureVerArr = featureVersion.split("\\.");
		try {
			int index = 0;
			// 获取最小长度值
			int minLen = Math.min(requestVerArr.length, featureVerArr.length);
			int diff = 0;
			// 循环判断每位的大小
			while (index < minLen
					&& (diff = Integer.parseInt(requestVerArr[index]) - Integer.parseInt(featureVerArr[index])) == 0) {
				index++;
			}

			if (diff == 0) {
				// 如果位数不一致，比较多余位数
				for (int i = index; i < requestVerArr.length; i++) {
					if (Integer.parseInt(requestVerArr[i]) > 0) {
						return true;
					}
				}

				for (int i = index; i < featureVerArr.length; i++) {
					if (Integer.parseInt(featureVerArr[i]) > 0) {
						return false;
					}
				}
				return true;
			} else {
				return diff > 0 ? true : false;
			}
		} catch (Exception e) {
			logger.error("当前版本与特性号做比较出现异常！！！", e);
		}
		return false;
	}

}