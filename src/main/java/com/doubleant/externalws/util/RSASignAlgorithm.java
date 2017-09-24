package com.doubleant.externalws.util;

/**
 * RSA签名算法枚举
 */
public enum RSASignAlgorithm {

	SHA1WithRSA("SHA1WithRSA"),
	SHA256WithRSA("SHA256WithRSA");

	String algorithm;

	RSASignAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	String getAlgorithm() {
		return algorithm;
	}

}
