 package com.isitcom.gestionProduit.response;

public class LoginResponse {
	String message;
	
	

	public LoginResponse(String message, Boolean status) {
		super();
		this.message = message;
		
	}
	public LoginResponse() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "LoginResponse [message=" + message+ "]";
	}
	

    
	
}
