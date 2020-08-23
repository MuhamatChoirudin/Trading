package com.bootcamp.sti.wall.exception;
@SuppressWarnings("serial")
public class SuccessException extends BaseCommonException{

	public SuccessException(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public SuccessException() {

	}
}
