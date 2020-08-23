package com.bootcamp.sti.wall.dto;

public class CommonResponse<T> {
	String code;
	String description;
	T data;
	
	public  CommonResponse() {
		this.code = "01";
		this.description = "Success";
	

	}
	public CommonResponse(String code, String description) {
		this.code = code;
		this.description = description;
		
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}

	