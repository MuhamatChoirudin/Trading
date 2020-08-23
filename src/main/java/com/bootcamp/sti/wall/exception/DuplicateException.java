package com.bootcamp.sti.wall.exception;

@SuppressWarnings("serial")
public class DuplicateException extends BaseCommonException{
 
	public DuplicateException (String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public DuplicateException () {

	}
}
