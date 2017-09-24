package com.doubleant.externalws.util;

import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AES解密器
 *
 * @author xiong.hx
 * @date 2017年7月19日
 */
public class AESDecoder implements Decoder {

	/**
	 * 明文密钥
	 */
	private String key;

	/**
	 * 密钥
	 */
	private SecretKeySpec secretkey;

	/**
	 * 实例Map
	 */
	private static Map<String, AESDecoder> instanceMap = new ConcurrentHashMap<>();

	public AESDecoder(String key) {
		this.key = key;
		this.secretkey = createKey(key);
	}

	@Override
	public String decode(String data) {
		if (StringUtils.isEmpty(data)) {
			return null;
		}

		try {
			byte[] dataBytes = Base64.decode(data.getBytes(SecurityContants.CHARSET_UTF8));
			Cipher cipher = Cipher.getInstance(SecurityContants.AES_ALGORITHM_MODE);
			cipher.init(Cipher.DECRYPT_MODE, secretkey);
			byte[] result = cipher.doFinal(dataBytes);
			return new String(result, SecurityContants.CHARSET_UTF8);
		} catch (Exception e) {
			throw new RuntimeException("decrypt fail!", e);
		}

	}

	/**
	 * 初始化密钥
	 *
	 * @param plaintextKey
	 * @return
	 * @throws UnsupportedEncodingException
	 * @author xiong.hx
	 */
	private static SecretKeySpec createKey(String plaintextKey) {
		try {
			byte[] keyBytes = plaintextKey.getBytes(SecurityContants.CHARSET_UTF8);
			SecretKeySpec secretKey = new SecretKeySpec(keyBytes, SecurityContants.KEY_ALGORITHM_AES);
			byte[] enCodeFormat = secretKey.getEncoded();
			return new SecretKeySpec(enCodeFormat, SecurityContants.KEY_ALGORITHM_AES);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("create key fail!", e);
		}
	}

	/**
	 * 获取实例
	 *
	 * @param key
	 * @return
	 * @author xiong.hx
	 */
	public static AESDecoder getInstance(String key) {
		// 密钥对应解密器为空，则初始化一个
		if (null == instanceMap.get(key)) {
			AESDecoder decoder = new AESDecoder(key);
			instanceMap.put(key, decoder);
			return decoder;
		}
		return instanceMap.get(key);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}

