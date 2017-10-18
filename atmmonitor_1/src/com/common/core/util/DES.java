package com.common.core.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import sun.misc.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.*;

/**
 * 解密
 */
public class DES {
	private static String Algorithm = "DESede";// 加密算法的名称 //密匙参数长度必须为24个字节
	private static Cipher c;// 密码器
	private static byte[] cipherByte;
	private static SecretKey deskey;// 密钥
	private static String keyString = "A3F2569DESJEIWBCJOTY45DYQWF68H1Y";// 获得密钥的参数

	// 对base64编码的string解码成byte数组
	public byte[] deBase64(String parm) throws IOException {
		BASE64Decoder dec = new BASE64Decoder();
		byte[] dnParm = dec.decodeBuffer(parm);
		// System.out.println(dnParm.length);
		// System.out.println(dnParm);
		return dnParm;
	}

	// 把密钥参数转为byte数组
	public byte[] dBase64(String parm) throws IOException {
		BASE64Decoder dec = new BASE64Decoder();
		byte[] dnParm = dec.decodeBuffer(parm);
		System.out.println("密钥参数字节长度：" + dnParm.length);
		System.out.println("解密后密钥：" + dnParm);
		return dnParm;
	}

	/**
	 * 对 Byte 数组进行解密
	 * 
	 * @param buff
	 *            要解密的数据
	 * @return 返回加密后的 String
	 */
	public  String createDecryptor(byte[] buff)
			throws NoSuchPaddingException, NoSuchAlgorithmException,
			UnsupportedEncodingException {
		try {
			c.init(Cipher.DECRYPT_MODE, deskey);// 初始化密码器，用密钥deskey,进入解密模式
			cipherByte = c.doFinal(buff);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return (new String(cipherByte, "UTF-8"));// 与加密前data.getBytes("UTF-8")对应
	}

	/**
	 * 对 Byte 数组进行加密
	 * 
	 * @param data
	 *            要加密的数据
	 * @return 返回加密后的字节数据，并通过base64编码后返回
	 */
	public static String createEncryptor(byte[] data)
			throws UnsupportedEncodingException {
		BASE64Encoder ec = new BASE64Encoder();// base64编码类
		try {
			c.init(Cipher.ENCRYPT_MODE, deskey);// 初始化密码器，用密钥deskey,进入加密模式
			cipherByte = c.doFinal(data);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return ec.encodeBuffer(cipherByte);// 加密后编码，与BASE64Decoder.decodeBuffer()相对应
	}

	public void getKey(String key) throws IOException, InvalidKeyException,
			InvalidKeySpecException {
		byte[] dKey = dBase64(key);
		try {
			deskey = new javax.crypto.spec.SecretKeySpec(dKey, Algorithm);
			c = Cipher.getInstance(Algorithm);
		} catch (NoSuchPaddingException ex) {
		} catch (NoSuchAlgorithmException ex) {
		}
	}
	
	/**
	 * 解密
	 * @param decryptString
	 * @return
	 */
	public String decrypt(String decryptString) {
		try {

			getKey(keyString);// 获取密钥
			byte[] dBy = deBase64(decryptString);// 获取需要解密的字符串
			String dStr = createDecryptor(dBy);

			System.out.println("解密：" + dStr);
			return dStr;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String args[]) throws IOException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeySpecException, InvalidKeyException, IOException {
		DES des = new DES();
		des.getKey(keyString);// 获取密钥
		

		String str = "aihongda";// 获取需要解密的字符串
		String encodeStr = des.createEncryptor(str.getBytes("UTF-8"));// 先转成utf-8代码字节
		System.out.println("加密：" + encodeStr);
		
		byte[] dBy = des.deBase64(encodeStr);// 获取需要解密的字符串
		String dStr = des.createDecryptor(dBy);
		System.out.println("解密：" + dStr);
	}
}
