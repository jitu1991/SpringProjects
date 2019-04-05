package com.jdbc.auth.spring_security_jdbc_authentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String encoded = new BCryptPasswordEncoder().encode("admin");
		System.out.println(encoded);
	}
}
