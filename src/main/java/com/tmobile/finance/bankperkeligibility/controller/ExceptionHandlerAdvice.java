package com.tmobile.finance.bankperkeligibility.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tmobile.finance.bankperkeligibility.exception.CustomException;
import com.tmobile.finance.model.ErrorResponse;
import com.tmobile.finance.model.ErrorResponseErrors;



@ControllerAdvice
public class ExceptionHandlerAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

	
	 @ExceptionHandler(CustomException.class)
	    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
	      logger.info("Came to ExceptionHandlerAdvice class ");
	        
	        ErrorResponse errResponse = new ErrorResponse();
			List<ErrorResponseErrors> errorList = new ArrayList<>();
			ErrorResponseErrors errorResponseErrors = new ErrorResponseErrors();
				errorResponseErrors.setCode("404");
				errorResponseErrors.setSystemMessage("NotFound");
				errorResponseErrors.setUserMessage("NotFound");
				errResponse.addErrorsItem(errorResponseErrors);
			
				errorList.add(errorResponseErrors);
				
				errResponse.setErrors(errorList);
	        
	        return new ResponseEntity<>(errResponse, null, ex.getHttpStatus() );
	    }
	
}
