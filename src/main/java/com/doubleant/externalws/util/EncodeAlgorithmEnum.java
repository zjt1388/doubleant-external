package com.doubleant.externalws.util;

public enum EncodeAlgorithmEnum {

	AES("AES"), RSA("RSA");

	String algorithm;

	EncodeAlgorithmEnum(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getAlgorithm() {
		return algorithm;
	}
}
