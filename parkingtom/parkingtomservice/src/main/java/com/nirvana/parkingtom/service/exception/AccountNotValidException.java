package com.nirvana.parkingtom.service.exception;

public class AccountNotValidException extends RuntimeException {

	private String message;
	public AccountNotValidException(){
		super();
	}
	
	public AccountNotValidException(String message){
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "AccountNotValidException [message=" + message + "]";
	}
}
