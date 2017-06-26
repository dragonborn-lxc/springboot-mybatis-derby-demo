package com.endnesswaltz.demo.entity.json;

public class Response {
	private String code;
	private String message;
	private Object data;

	public Response success() {
		this.code = "1";
		return this;
	}
	
	public Response success(String message) {
		this.code = "1";
		this.message = message;
		return this;
	}

	public Response success(Object data) {
		this.code = "1";
		this.data = data;
		return this;
	}
	
	public Response success(String message, Object data) {
		this.code = "1";
		this.message = message;
		this.data = data;
		return this;
	}

	public Response failure() {
		this.code = "0";
		return this;
	}

	public Response failure(String message) {
		this.code = "0";
		this.message = message;
		return this;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
