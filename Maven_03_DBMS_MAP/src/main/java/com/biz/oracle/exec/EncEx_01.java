package com.biz.oracle.exec;

import java.util.Map;
import java.util.Set;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_01 {

	public static void main(String[] args) {

		
//		// OS의 환경변수 값을 가져와서 Map에 저장하기
//		Map<String,String> systemENV = System.getenv();
//		Set<String> keys = systemENV.keySet();
//		for(String s : keys) {
//			System.out.printf("%s = %s \n", s,systemENV.get(s));
//		}
		
		
		
		
		String user = "USERID";
		String password = "PASSWORD";
		String salt = "com.biz.oracle";
		
		// 문자열을 암호화시키기 위한 클래스
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		// 암호화 타입
		// MD5 또는 DE5형식의 암호화 타입
		// 가장 쉽게 접근할 수 있는 암호화 타입
		// jasypt만으로 암호화 시키는 방법
		String encType = "PBEWithMD5AndDES";
		
		// MD5, DE5방식으로 암호화를 하고 Key값으로 salt 문자열을
		// 사용하라
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(salt);
		
		String encUser = pbEnc.encrypt(user);
		String encPassword = pbEnc.encrypt(password);
		
		System.out.printf("%s -> %s\n", user,encUser);
		System.out.printf("%s -> %s\n", password,encPassword);
		/*
		 * iolist2 -> 50sSCT69uII+rtp4S018zg==
		 * iolist2 -> VeMb0xwQeAuwfQWONO5NHg==
		 */
		/*
		 * iolist2 -> VvsAovJC+C8DKDdOyyR7FQ==
		 * iolist2 -> c/qRvKIHJHLou7o3+Bgh0w==
		 */
		
	}

}
