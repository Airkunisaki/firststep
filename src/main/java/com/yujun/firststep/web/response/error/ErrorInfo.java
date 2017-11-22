package com.yujun.firststep.web.response.error;

public class ErrorInfo<T> {
	
	public static final String ERROR_CODE="100";
	
	private String code;
	private String message;
	private T data;
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public T getData() {
		return data;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
