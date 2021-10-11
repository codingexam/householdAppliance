package com.appliance.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

public class APIError {
	private HttpStatus status;
	private List<String> errors;
	private LocalDateTime timeStamp;
	private String pathUri;
	public APIError() {
		super();
	}
	public APIError(HttpStatus status, List<String> errors, LocalDateTime timeStamp, String pathUri) {
		super();
		this.status = status;
		this.errors = errors;
		this.timeStamp = timeStamp;
		this.pathUri = pathUri;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getPathUri() {
		return pathUri;
	}
	public void setPathUri(String pathUri) {
		this.pathUri = pathUri;
	}
	
	
	

}
