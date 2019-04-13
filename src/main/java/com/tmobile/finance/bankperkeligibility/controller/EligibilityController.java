package com.tmobile.finance.bankperkeligibility.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.finance.bankperkeligibility.exception.CustomException;
import com.tmobile.finance.bankperkeligibility.exception.IdrequiredException;
import com.tmobile.finance.bankperkeligibility.service.EligibilityService;
import com.tmobile.finance.model.ErrorResponse;
import com.tmobile.finance.model.ErrorResponseErrors;
import com.tmobile.finance.model.EligibilityRequest;
import com.tmobile.finance.model.EligibilityResponse;;


@RestController
@RequestMapping("/customer/v1/tmoney")
public class EligibilityController {
	private static final Logger logger = LoggerFactory.getLogger(EligibilityController.class);
	
	@Autowired
	private EligibilityService eligibilityService;
	
	
	//@PostMapping
	//@LogExecutionTime
	@PostMapping("/bankPerkEligibility")
	 //@ExceptionHandler(ErrorResponse.class)
	//@ResponseStatus(HttpStatus.CREATED)
	public EligibilityResponse  verifyEligibility(@RequestHeader HttpHeaders requestHeader,            
									 @RequestBody EligibilityRequest request) throws Exception {
	
		//logger.info("Eligibility service request:"+request.toString());
		
		/*loggerService.logRestServiceRequest("verifyEligibility", "verifyEligibility",
				request, requestHeader.toSingleValueMap(), null);*/
		
		EligibilityResponse response = new EligibilityResponse();
		ErrorResponse erroRespons = new ErrorResponse();
		
		try {
			if(!request.getTmoid().isEmpty() ||  !request.getTmoid().equals(""))  {
					response = eligibilityService.isBankPerkEligible(request);
					
					
					if(response.getPerkeligibility().size()<1 )
					{
						throw new  CustomException( "User id not found ", HttpStatus.NOT_FOUND);
					}
					
				}else {
					throw new IdrequiredException("User id required", HttpStatus.BAD_REQUEST);
					
				}
		}catch(CustomException e) {
			
			
			throw new CustomException("User id not found", HttpStatus.NOT_FOUND);
			
		}
		return response;
	
	}
	
	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<ErrorResponse> exceptionHandler(CustomException ex) {
		ErrorResponse errResposne = new ErrorResponse();
		List<ErrorResponseErrors> errorList = new ArrayList<>();
		ErrorResponseErrors errorResponseErrors = new ErrorResponseErrors();
			errorResponseErrors.setCode("404");
			errorResponseErrors.setSystemMessage(ex.getMessage());
			errorResponseErrors.setUserMessage("User id not Found ..");
			errResposne.addErrorsItem(errorResponseErrors);
		
			errorList.add(errorResponseErrors);
			
		errResposne.setErrors(errorList);
		
	
      /*  ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());*/
        return new ResponseEntity<ErrorResponse>(errResposne, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
	@ExceptionHandler(IdrequiredException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> exceptionHandler(IdrequiredException ex) {
		ErrorResponse errResposne = new ErrorResponse();
		List<ErrorResponseErrors> errorList = new ArrayList<>();
		ErrorResponseErrors errorResponseErrors = new ErrorResponseErrors();
			errorResponseErrors.setCode("404");
			errorResponseErrors.setSystemMessage(ex.getMessage());
			errorResponseErrors.setUserMessage("User id required");
			errResposne.addErrorsItem(errorResponseErrors);
		
			errorList.add(errorResponseErrors);
			
		errResposne.setErrors(errorList);
		
	
      /*  ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());*/
        return new ResponseEntity<ErrorResponse>(errResposne, HttpStatus.BAD_REQUEST);
    }

}
