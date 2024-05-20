package com.dao;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encode {

	public static String[] encode(String str, String key) {
		Base64.Encoder base64Encoder = Base64.getEncoder();
		// encoding byte array into base 64
		byte[] byteArray = null;
		String [] ek = new String[2];
		try {
			byteArray = base64Encoder.encode(str.getBytes("UTF-8"));
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			// encrypt the text
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(byteArray);
			ek[0] = new String(byteArray);
			 ek[1] = new String(encrypted);
			return ek;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String decode(String str, String key) {
		byte[] byteArray = str.getBytes();
		try {
			System.out.println(key);
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			String decrypted = new String(cipher.doFinal(byteArray));///
			// decoding byte array into base64
			Base64.Decoder base64Decoder = Base64.getDecoder();
			byte[] strdec = base64Decoder.decode(decrypted.getBytes());
			return new String(strdec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
