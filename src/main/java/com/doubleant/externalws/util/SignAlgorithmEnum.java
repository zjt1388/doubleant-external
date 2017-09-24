package com.doubleant.externalws.util;

public enum SignAlgorithmEnum {

	SHA1WithRSA("SHA1WithRSA"), SHA256WithRSA("SHA256WithRSA"), MD5("MD5"), SHA1("SHA1"), SHA256("SHA256");

	String algorithm;

	SignAlgorithmEnum(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getAlgorithm() {
		return algorithm;
	}
}
