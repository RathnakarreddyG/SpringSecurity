package com.example.RoleBased.exception;

public class NotFoundExceptionH extends RuntimeException {

	public NotFoundExceptionH() {
	}

	public NotFoundExceptionH(String arg0) {
		super(arg0);
	}

	public NotFoundExceptionH(Throwable arg0) {
		super(arg0);
	}

	public NotFoundExceptionH(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NotFoundExceptionH(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
