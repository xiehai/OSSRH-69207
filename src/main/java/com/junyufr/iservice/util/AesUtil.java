package com.junyufr.iservice.util;

import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @ClassName AesUtil
 * @Description AES对称加密工具
 * @Author luzhiyu
 * @Date 2019/5/21 10:57
 * @Version 1.0
 */
public class AesUtil {


	private static final String KEY_ALGORITHM = "AES";
	// 默认的加密算法
	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

//	public static void main(String[] args) {
//        String encrypt = encrypt("123456", "1");
//        System.out.println("AES加密:----->"+encrypt);
//    }
	/**
	 * AES 加密操作
	 *
	 * @param content
	 *            待加密内容
	 * @param key
	 *            加密密钥
	 * @return 返回Base64转码后的加密数据
	 */
	public static String encrypt(String content, String key) {
		if (StringUtils.isEmpty(content) || StringUtils.isEmpty(key)) {
			return null;
		}
		try {
			// 创建密码器
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
			byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
			// 初始化为加密模式的密码器
			cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));
			// 加密
			byte[] result = cipher.doFinal(byteContent);
			// 通过Base64转码返回
			return new String(Base64.getEncoder().encode(result));
		} catch (Exception ex) {

		}
		return null;
	}

	/**
	 * AES 解密操作
	 *
	 * @param content
	 * @param key
	 * @return
	 */
	public static String decrypt(String content, String key) {
		if (StringUtils.isEmpty(content) || StringUtils.isEmpty(key)) {
			return null;
		}
		try {
			// 实例化
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
			// 使用密钥初始化，设置为解密模式
			cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
			// 执行操作
			byte[] result = cipher.doFinal(Base64.getDecoder().decode(content.getBytes()));
			return new String(result, StandardCharsets.UTF_8);
		} catch (Exception ex) {

		}
		return null;
	}

	/**
	 * 生成加密秘钥
	 *
	 * @return
	 */
	private static SecretKeySpec getSecretKey(final String key) {
		// 返回生成指定算法密钥生成器的 KeyGenerator 对象
		KeyGenerator kg = null;
		try {
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(key.getBytes());
			kg = KeyGenerator.getInstance(KEY_ALGORITHM);
			// AES 要求密钥长度为 128
			kg.init(128, secureRandom);
			// 生成一个密钥
			SecretKey secretKey = kg.generateKey();
            //System.out.println("Key"+secretKey);
            // 转换为AES专用密钥
			return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
		} catch (NoSuchAlgorithmException ex) {

		}
		return null;
	}


	public static void main(String[] args) {
		//aLhShoSFRlj5ZyV9p1eBdAV+0afxp5XwYwXuPErJ8e0=
		//09C67eY1cgnu0bKe7721gaA7ctyp0w/jGuRRsXjjCVpj2NH/wMhTQgWKl6e6tk9FTpMcBRT55rfOxfgcjy5TEw==
		//
		String data = "M6Z2jQ8H5FGW/4gJ7sMdL8JjWuTl5IuMitf5ihWfG4I=";
		String key = "b9f00cf9c7108880d4fc507d7fcd22fd";
		System.out.println(decrypt(data, key));

	}

}
