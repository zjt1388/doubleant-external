package com.doubleant.externalws.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * RSA签名类
 *
 * @author xiong.hx
 * @date 2017年7月27日
 */
public class RSASignaturer implements Signaturer {

	private static final Logger logger = LoggerFactory.getLogger(RSASignaturer.class);

	/**
	 * 明文文本私钥
	 */
	private String privateKey;

	/**
	 * 私钥
	 */
	private PrivateKey priKey;

	/**
	 * 签名算法
	 */
	private String signAlgorithm = RSASignAlgorithm.SHA256WithRSA.getAlgorithm();

	/**
	 * 实例Map
	 */
	private static Map<String, RSASignaturer> instanceMap = new ConcurrentHashMap<>();


	public RSASignaturer(String privateKey) {
		this.privateKey = privateKey;
		this.priKey = createKey(privateKey);
	}

	@Override
	public String sign(String data) {
		if (null == data) {
			return null;
		}
		try {
			Signature signature = Signature.getInstance(signAlgorithm);
			signature.initSign(priKey);
			signature.update(data.getBytes(SecurityContants.CHARSET_UTF8));
			byte[] signed = signature.sign();
			return new String(Base64.encodeBase64(signed));
		} catch (Exception e) {
			logger.error("error happened when sign", e);
		}
		return null;

	}

	/**
	 * 获取实例
	 *
	 * @param privateKey
	 * @return
	 * @author xiong.hx
	 */
	public static RSASignaturer getInstance(String privateKey) {
		// 公钥对应加签器为空，则初始化一个
		if (null == instanceMap.get(privateKey)) {
			RSASignaturer signaturer = new RSASignaturer(privateKey);
			instanceMap.put(privateKey, signaturer);
			return signaturer;
		}
		return instanceMap.get(privateKey);
	}

	/**
	 * 初始化密钥
	 *
	 * @param plaintextKey
	 * @return
	 * @author xiong.hx
	 */
	private static PrivateKey createKey(String plaintextKey) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(plaintextKey.getBytes()));
			KeyFactory keyf = KeyFactory.getInstance(SecurityContants.KEY_ALGORITHM_RSA);
			return keyf.generatePrivate(priPKCS8);
		} catch (Exception e) {
			logger.error("error happened when create key", e);
			return null;
		}
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
		this.priKey = createKey(privateKey);
	}

	public void setSignAlgorithm(String signAlgorithm) {
		this.signAlgorithm = signAlgorithm;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public String getSignAlgorithm() {
		return signAlgorithm;
	}

}

