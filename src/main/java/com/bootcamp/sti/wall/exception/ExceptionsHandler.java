package com.bootcamp.sti.wall.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bootcamp.sti.wall.dto.CommonResponse;




@ControllerAdvice
public class ExceptionsHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserException.class);
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=EntityNotFoundException.class)
	public ResponseEntity<CommonResponse>resp(EntityNotFoundException e){
		LOGGER.error("Entity not found");
		LOGGER.warn(e.getMessage());
		LOGGER.info(e.getMessage());
		LOGGER.debug(e.getMessage());
		return new ResponseEntity<>(new CommonResponse("66", "Entity Not Found"), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=SuccessException.class)
	public ResponseEntity<CommonResponse>resp(SuccessException e){
		LOGGER.error("Success");
		LOGGER.warn(e.getMessage());
		LOGGER.info(e.getMessage());
		LOGGER.debug(e.getMessage());
		return new ResponseEntity<>(new CommonResponse("01", "Success"), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=BalanceNotEnoughException.class)
	public ResponseEntity<CommonResponse>resp(BalanceNotEnoughException e){
		LOGGER.error("Balance not enough");
		LOGGER.warn(e.getMessage());
		LOGGER.info(e.getMessage());
		LOGGER.debug(e.getMessage());
		return new ResponseEntity<>(new CommonResponse("22", "Balance not enough"), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=EntitySameException.class)
	public ResponseEntity<CommonResponse>resp(EntitySameException e){
		LOGGER.error("not permitted because of your own data");
		LOGGER.warn(e.getMessage());
		LOGGER.info(e.getMessage());
		LOGGER.debug(e.getMessage());
		return new ResponseEntity<>(new CommonResponse("44", "not permitted because of your own data"), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=RegisteredException.class)
	public ResponseEntity<CommonResponse>resp(RegisteredException e){
		LOGGER.error("Data is already registered");
		LOGGER.warn(e.getMessage());
		LOGGER.info(e.getMessage());
		LOGGER.debug(e.getMessage());
		return new ResponseEntity<>(new CommonResponse("33", "Data is already registered"), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<CommonResponse>resp(HttpRequestMethodNotSupportedException e){
		LOGGER.error("Metod not support");
		LOGGER.warn(e.getMessage());
		LOGGER.info(e.getMessage());
		LOGGER.debug(e.getMessage());
		return new ResponseEntity<>(new CommonResponse("405", e.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
	}
	
//	@SuppressWarnings("rawtypes")
//	@ExceptionHandler(value=Exception.class)
//	public ResponseEntity<CommonResponse>resp(Exception e){
//		LOGGER.error("Failed");
//		LOGGER.warn(e.getMessage());
//		LOGGER.info(e.getMessage());
//		LOGGER.debug(e.getMessage());
//		return new ResponseEntity<>(new CommonResponse("99", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=UserException.class)
	public ResponseEntity<CommonResponse>resp(UserException e){
		LOGGER.error(" erorr");
		LOGGER.warn(e.getMessage());
		LOGGER.info(e.getMessage());
		LOGGER.debug(e.getMessage());
		return new ResponseEntity<>(new CommonResponse(e.getCode(), e.getMessage()), HttpStatus.OK);
	}
	
}
