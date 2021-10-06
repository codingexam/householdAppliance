package com.appliance.auth.resource;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = -6846941218584153953L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
