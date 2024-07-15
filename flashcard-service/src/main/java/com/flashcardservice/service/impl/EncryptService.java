//package com.flashcardservice.service.impl;
//
//import java.security.MessageDigest;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class EncryptService {
//
//	public String encryptPasswordSha(String password) {
//		StringBuffer message = new StringBuffer();
//
//		try {
//			MessageDigest md = MessageDigest.getInstance("SHA-1");
//			byte[] hash = md.digest(password.getBytes("UTF-8"));
//
//			for (byte w : hash) {
//				message.append(String.format("%02x", w));
//			}
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		return message.toString();
//
//	}
//
//	public String bCryptPassword(String password) {
//		String encodedPassword = new String();
//
//		try {
//			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//			encodedPassword = encoder.encode(password);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		return encodedPassword;
//
//	}
//
//}
