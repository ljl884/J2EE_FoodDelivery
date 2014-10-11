package com.fooddelivery.presentation;

public class InterceptingValidator {
	private SQLValidator sqlValidator;
	private ParamValidator paramValidator;
	
	public InterceptingValidator(){
		sqlValidator = new SQLValidator();
		paramValidator = new ParamValidator();
	}
	
	public String validate(String request){
		return request;
	}
}
