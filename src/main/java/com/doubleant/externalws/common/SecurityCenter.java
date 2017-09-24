package com.doubleant.externalws.common;

import com.doubleant.externalws.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 安全中心,负责加签，验签 , 加密 , 解密等
 * 
 * @author xiong.hx
 * @date 2017年7月19日
 */
@Component(value = "securityCenter")
public class SecurityCenter {

	private static final Logger logger = LoggerFactory.getLogger(SecurityCenter.class);

    /**
	 * 验证签名
	 *
	 * @param input
	 * @param source
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	public boolean verify(String input, String sign, String source) {
		if (StringUtils.isEmpty(source)) {
			return false;
		}

        try {
			Verifier verifier = getVerifier(source);
            if (verifier == null) {
				logger.info("source {} 没有配置验签器，不需要验签！", source);
                return true;
            }
			return verifier.verify(input, sign);
        } catch (Exception e) {
			logger.error("验签异常", e);
            return false;
        }
    }
    
	/**
	 * 加签
	 *
	 * @param data
	 * @param source
	 *            接入系统来源
	 * @return
	 */
	public String sign(String data, String source) {
		Signaturer signer = getSigner(source);
		if (signer == null) {
			return null;
		}
		return signer.sign(data);
	}

	private Verifier getVerifier(String source) {
		return RSAVerifier.getInstance(getVerifyKey(source));
	}

	private Signaturer getSigner(String source) {
		return RSASignaturer.getInstance(getSignKey(source));
	}

	private String getSignKey(String source) {
		return "";
	}

	private String getVerifyKey(String source) {
		return "";
	}

	private String getEncodeKey(String source) {
		return "";
	}

	/**
	 * 加密
	 * 
	 * @param data
	 * @param source
	 * @return
	 * @author xiong.hx
	 */
	public String decode(String data, String source) {
		Decoder decoder = getDecoder(source);
		if (decoder == null) {
			return data;
		}
		return decoder.decode(data);
	}

	/**
	 * 解密
	 * 
	 * @param data
	 * @param source
	 * @return
	 * @author xiong.hx
	 */
	public String encode(String data, String source) {
		Encoder encoder = getEncoder(source);
		if (encoder == null) {
			return data;
		}
		return encoder.encode(data);
	}

    /**
     * 获取解码器
     *
     * @param source
     * @return
     */
	public Decoder getDecoder(String source) {
		return AESDecoder.getInstance(getEncodeKey(source));
    }

    /**
     * 获取加密器
     *
     * @param source
     * @return
     */
	public Encoder getEncoder(String source) {
		return AESEncoder.getInstance(getEncodeKey(source));
    }

	public static void main(String[] args) {

		String data = "{\"idNo\":\"240058199905052545\",\"name\":\"张三\"}";
		String ssjId = "13387954554";
		data = AESEncoder.getInstance(new SecurityCenter().getEncodeKey("card")).encode(data);
		ssjId = AESEncoder.getInstance(new SecurityCenter().getEncodeKey("card")).encode(ssjId);

		System.out.println("data=" + data);
		System.out.println("ssjId=" + ssjId);
		String sign = RSASignaturer.getInstance(new SecurityCenter().getSignKey("card")).sign(data);
		System.out.println("sign=" + sign);
		System.out.println(RSAVerifier.getInstance(new SecurityCenter().getVerifyKey("card")).verify(data, sign));

	}
    
}
