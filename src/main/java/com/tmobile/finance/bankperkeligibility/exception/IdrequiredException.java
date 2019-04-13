package com.tmobile.finance.bankperkeligibility.exception;

import org.springframework.http.HttpStatus;

public class IdrequiredException extends RuntimeException {
	 private static final long serialVersionUID = 1L;

	    private String error;
	    private HttpStatus httpStatus;

	    public IdrequiredException(String error, HttpStatus status) {
	        super("Error occurred");
	        this.error = error;
	        this.httpStatus = status;
	    }

	    public String getError() {
	        return error;
	    }

	    public HttpStatus getHttpStatus() {
	        return httpStatus;
	    }

	    @Override
	    public String toString() {
	        return "Error: " + error.toString() + "with http status: " + httpStatus.toString();
	    }
}

