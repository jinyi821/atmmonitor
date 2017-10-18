package com.usermanager.manager;


public class RetVO {

	Boolean success; 
	String message;
	
	public RetVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RetVO(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "RetVO [success=" + success + ", message=" + message + "]";
	}
	
	
	
}
