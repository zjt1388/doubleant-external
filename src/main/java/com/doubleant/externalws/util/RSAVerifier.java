package com.doubleant.externalws.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * RSA验签器
 *
 * @author xiong.hx
 * @date 2017年7月18日
 */
public class RSAVerifier implements Verifier {

    private static final Logger logger = LoggerFactory.getLogger(RSASignaturer.class);

    /**
     * 明文文本公钥
     */
    private String publicKey;

    /**
     * 公钥
     */
    private PublicKey pubKey;

    /**
     * 签名算法
     */
    private String signAlgorithm = RSASignAlgorithm.SHA256WithRSA.getAlgorithm();

    /**
     * 实例Map
     */
    private static Map<String, RSAVerifier> instanceMap = new ConcurrentHashMap<>();

    public RSAVerifier(String publicKey) {
        this.publicKey = publicKey;
        this.pubKey = createKey(publicKey);
    }

    @Override
    public boolean verify(String data, String sign) {

        if (StringUtils.isEmpty(data) || StringUtils.isEmpty(sign)) {
            return false;
        }
        try {
            Signature signature = Signature.getInstance(signAlgorithm);
            signature.initVerify(pubKey);
            signature.update(data.getBytes(SecurityContants.CHARSET_UTF8));
            return signature.verify(Base64.decode2(sign));
        } catch (Exception e) {
            logger.error("error happened when verify", e);
        }
        return false;

    }

    /**
     * 初始化公钥
     *
     * @param plaintextKey
     * @return
     * @author xiong.hx
     */
    private static PublicKey createKey(String plaintextKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(SecurityContants.KEY_ALGORITHM_RSA);
            byte[] encodedKey = Base64.decode2(plaintextKey);
            return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
        } catch (Exception e) {
            logger.error("error happened when create key", e);
            return null;
        }
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSignAlgorithm() {
        return signAlgorithm;
    }

    public void setSignAlgorithm(String signAlgorithm) {
        this.signAlgorithm = signAlgorithm;
    }

    /**
     * 生成校验器实例
     *
     * @param publicKey
     * @return
     * @author xiong.hx
     */
    public static RSAVerifier getInstance(String publicKey) {
        // 公钥对应验签器为空，则初始化一个
        if (null == instanceMap.get(publicKey)) {
            RSAVerifier verifier = new RSAVerifier(publicKey);
            instanceMap.put(publicKey, verifier);
            return verifier;
        }
        return instanceMap.get(publicKey);
    }

}

