package com.tmobile.finance.bankperkeligibility.exception;

import om.tmobile.finance.bankperkeligibility.util.MessageCode;

public class IgnoreEventException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private final String message;
    private MessageCode messageCode;

    public IgnoreEventException(MessageCode messageCode,final String msg) {
    	super(messageCode.getUserMessage());
		this.messageCode = messageCode;
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
    public MessageCode getMessageCodeEnum() {
		return messageCode;
	}

}