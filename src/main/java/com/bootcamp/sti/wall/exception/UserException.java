package com.bootcamp.sti.wall.exception;

public class UserException extends BaseCommonException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1581423046733637198L;

	public UserException(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public UserException() {

	}

}
