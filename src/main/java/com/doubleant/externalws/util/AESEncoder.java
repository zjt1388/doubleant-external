package com.doubleant.externalws.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AES加密器
 *
 * @author xiong.hx
 * @date 2017年7月19日
 */
public class AESEncoder implements Encoder {

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
    private static Map<String, AESEncoder> instanceMap = new ConcurrentHashMap<>();

    public AESEncoder(String key) {
        this.key = key;
        this.secretkey = createKey(key);
    }

    @Override
    public String encode(String data) {
        if (null == data) {
            return null;
        }
        try {
            byte[] dataBytes = data.toString().getBytes(SecurityContants.CHARSET_UTF8);
            Cipher cipher = Cipher.getInstance(SecurityContants.AES_ALGORITHM_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretkey);
            byte[] result = cipher.doFinal(dataBytes);
            return new String(Base64.encode(result));
        } catch (Exception e) {
            throw new RuntimeException("encrypt fail!", e);
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
    public static AESEncoder getInstance(String key) {
        // 密钥对应加密器为空，则初始化一个
        if (null == instanceMap.get(key)) {
            AESEncoder encoder = new AESEncoder(key);
            instanceMap.put(key, encoder);
            return encoder;
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

