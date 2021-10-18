package com.appliance;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode("admin123");
		System.out.println(encodedPassword);
		
//		for(int i=0; i<=10; i++) {
//			String encodedPassword = encoder.encode("user123");
//			System.out.println(encodedPassword);
//		}
	}
}
