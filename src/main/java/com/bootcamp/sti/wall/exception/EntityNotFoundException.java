package com.bootcamp.sti.wall.exception;

@SuppressWarnings("serial")
public class EntityNotFoundException extends BaseCommonException{
	
	public EntityNotFoundException(String code, String description) {
		this.code = code;
		this.description = description;
	}
	public EntityNotFoundException() {

	}

}
