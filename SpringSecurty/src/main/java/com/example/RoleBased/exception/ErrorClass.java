package com.example.RoleBased.exception;

public class ErrorClass {
	
	private int status;
	
	private String message;
	
	private Long timestamp;

	public ErrorClass() {
		super();
	}
	

	public ErrorClass(int status, String message, Long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}
