package com.supermap.bhpjt.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class MD5Tool {
	/**
	 * md5����
	 * 
	 * @param s
	 * @return
	 */
	public static String encode(String s) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			//System.out.println("result: " + buf.toString());// 32λ�ļ���
			//System.out.println("result: " + buf.toString().substring(8, 24));// 16λ�ļ���
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}
	public static void main(String[] args) {
		System.out.println(MD5Tool.encode("chengjk"));
		System.out.println(MD5Tool.encode("chengjinkai"));
	}

}
