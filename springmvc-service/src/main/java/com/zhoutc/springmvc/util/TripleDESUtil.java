/**
 * 环境：oracle10g，oracle11g中加密包为DBMS_CRYPTO的3DES加密测试
 * ORACLE加密模式为：ECB+3DES+PKCs5
 * JAVA加密模式为：DESede/ECB/PKCS7Padding
 * 如果需要在其他语言或者环境下使用请重新测试
 * 本类的密钥可以为任意的长度，被加密的字符串也可以为任意的长度
 * ORACLE中密钥必须为24位，并且不能含有&字符，被加密的字符串可以为任意的长度
 * 
 * 所以约定加密的密钥长度必须为24位
 * 被加密的字符串可以为任意长度
 */
package com.zhoutc.springmvc.util;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * @author：Administrator
 * @since：2012-8-29 下午04:28:45
 * @version:
 */
public class TripleDESUtil {

	private final String algorithm = "DESede/ECB/PKCS7Padding";

	private static TripleDESUtil instance;

	public static TripleDESUtil getInstance() {
		if (null == instance) {
			synchronized (TripleDESUtil.class) {
				if (null == instance) {
					////////////////////////////
					//Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());// 添加PKCS7Padding支持
					instance = new TripleDESUtil();
				}
			}
		}
		return instance;
	}

	/**
	 * 获取密钥
	 * 
	 * @param keyString
	 *            字符串key
	 * @return
	 */
	private Key getKey(String keyString) {
		Key key = new SecretKeySpec(keyString.getBytes(), algorithm);
		return key;
	}

	/**
	 * 获取密钥
	 * 
	 * @param keyByte
	 *            字节数组key
	 * @return
	 */
	private Key getKey(byte[] keyByte) {
		Key key = new SecretKeySpec(keyByte, algorithm);
		return key;
	}

	/**
	 * 3DES加密
	 * 
	 * @param sourceString
	 *            加密前的原字符串
	 * @param keyString
	 *            3des加密的key
	 * @return String 加密之后的16进制密文
	 * @throws Exception
	 */
	public String encrypt(String sourceString, String keyString) {
		try {
			Cipher encryptCipher = Cipher.getInstance(algorithm);
			Key key = getKey(keyString);
			encryptCipher.init(Cipher.ENCRYPT_MODE, key);
			return toHexString(encrypt(sourceString.getBytes(), keyString.getBytes()));
		}catch (Exception e){

		}
		return "";
	}

	/**
	 * 3DES加密
	 * 
	 * @param sourceByte
	 *            加密前的原字符串字节数组
	 * @param keyByte
	 *            3des加密的key字节数组
	 * @return byte 加密之后的密文字节数组
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] sourceByte, byte[] keyByte) throws Exception {
		Cipher encryptCipher = Cipher.getInstance(algorithm);
		Key key = getKey(keyByte);
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);
		return encryptCipher.doFinal(sourceByte);
	}

	/**
	 * 3DES解密
	 * 
	 * @param sourceByte
	 *            需解密的字节数组
	 * @param keyByte
	 *            解密的密钥字节数组
	 * @return byte 解密后的字节数组
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] sourceByte, byte[] keyByte) throws Exception {
		Cipher decryptCipher = Cipher.getInstance(algorithm);
		Key key = getKey(keyByte);
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
		return decryptCipher.doFinal(sourceByte);
	}

	/**
	 * 3DES解密
	 * 
	 * @param sourceString
	 *            需解密的密文字符串
	 * @param keyString
	 *            解密的密钥
	 * @return byte 解密后的字符串
	 */
	public String decrypt(String sourceString, String keyString) throws Exception {
		return new String(decrypt(fromHexString(sourceString), keyString.getBytes()));
	}

	/**
	 * 字节数组转16进制数组
	 * 
	 * @param digestByte
	 * @return
	 */
	private byte[] toHex(byte[] digestByte) {
		byte[] rtChar = new byte[digestByte.length * 2];
		for (int i = 0; i < digestByte.length; i++) {
			byte b1 = (byte) (digestByte[i] >> 4 & 0x0f);
			byte b2 = (byte) (digestByte[i] & 0x0f);
			rtChar[i * 2] = (byte) (b1 < 10 ? b1 + 48 : b1 + 55);
			rtChar[i * 2 + 1] = (byte) (b2 < 10 ? b2 + 48 : b2 + 55);
		}
		return rtChar;
	}

	/**
	 * 
	 * 字节数组转16进制字符串
	 * 
	 * @param digestByte
	 * @return
	 */
	private String toHexString(byte[] digestByte) {
		return new String(toHex(digestByte));
	}

	private static byte[] fromHex(byte[] sc) {
		byte[] res = new byte[sc.length / 2];
		for (int i = 0; i < sc.length; i++) {
			byte c1 = (byte) (sc[i] - 48 < 17 ? sc[i] - 48 : sc[i] - 55);
			i++;
			byte c2 = (byte) (sc[i] - 48 < 17 ? sc[i] - 48 : sc[i] - 55);
			res[i / 2] = (byte) (c1 * 16 + c2);
		}
		return res;
	}

	private static byte[] fromHexString(String hex) {
		return fromHex(hex.getBytes());
	}

	public static void main(String[] args) throws Exception {
		TripleDESUtil pk7 = TripleDESUtil.getInstance();
		String key = "FD0762380D980D52";
		String string = "88888888";
		String miwenString = pk7.encrypt(string, key);
		System.out.println("加密之后密文:" + miwenString);

		String mingwenString = pk7.decrypt(miwenString, key);
		System.out.println("解密之后明文:" + mingwenString);
	}
}
