package com.tmobile.finance.bankperkeligibility.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tmobile.finance.bankperkeligibility.pojo.IamResponse;
import com.tmobile.finance.bankperkeligibility.pojo.SamsonResponse;
import com.tmobile.finance.bankperkeligibility.rules.EligibilityRulesPredicate;
import com.tmobile.finance.model.EligibilityRequest;
import com.tmobile.finance.model.EligibilityResponse;
import com.tmobile.finance.model.Perkeligibility;



@Service
public class EligibilityService {
	private static final Logger logger = LoggerFactory.getLogger(EligibilityService.class);
	
	@Value("${iam.url}") 
	private  String iamServiceURL;
	
	@Value("${subscriberType}") 
	private  String subscriberType;
	
	@Autowired
	EligibilityRulesPredicate eligibilityRulesPredicate;
	
	@Autowired
	IamService iamService;
	
	@Autowired
	SamsonService samsonService;
	
	
	public EligibilityResponse  isBankPerkEligible(EligibilityRequest request) throws Exception {
		
		System.out.println("Respons building started  ....");
		boolean isIamRuleValid = false;
		
		List<Perkeligibility> perkPerkeligibilityList = new ArrayList<>();
		EligibilityResponse response = new EligibilityResponse();
		List<IamResponse>  iamResponseList= new ArrayList<>();
		iamResponseList = iamService.getIamResponse(request);
		logger.info("iamResponseList  size :" + iamResponseList.size());
		
		for(IamResponse iamResponse: iamResponseList) {
      	if( (!request.getMsisdn().equals("") && request.getMsisdn().equals(iamResponse.getMsisdn())) ||
      			request.getMsisdn().equals("")) {
      		  	
		      	if(iamService.isSubscriberTypeValid(iamResponse)) {
		      		if(iamService.isAccounTypeVaid(iamResponse)) {
							 SamsonResponse samsonResponse = new SamsonResponse();
							 logger.info("samsonResponse :"+samsonResponse.toString());
							 samsonResponse = samsonService.getSamsonResponse(iamResponse.getMsisdn());
							 if(samsonResponse.getActivationDate() != null )
								 perkPerkeligibilityList.add(buildPerkeligibility(samsonResponse.eligibilityIndicator, iamResponse.getMsisdn(),
										 DateUtils.parseDate(samsonResponse.getActivationDate(), 
												 new String[] { "yyyy-MM-dd HH:mm:ss", "dd/MM-yyyy" }),samsonResponse.getEligibilityReasonCode(), samsonResponse.getEligibilityReasonDescription(), samsonResponse.otpEligibility));
							 		else
							 			perkPerkeligibilityList.add(buildPerkeligibility(samsonResponse.eligibilityIndicator, iamResponse.getMsisdn(),
												 null ,samsonResponse.getEligibilityReasonCode(), samsonResponse.getEligibilityReasonDescription(), samsonResponse.otpEligibility));
				    }
		      		else {
		      			logger.info("Iam validator - isAccounTypeVaid :"+ iamService.isAccounTypeVaid(iamResponse));
		      			perkPerkeligibilityList.add(buildPerkeligibility(false, iamResponse.getMsisdn(), null, 1001,"Non-eligible Account Type", false));
		      		}
		      	} else {
		      		logger.info("Iam validator - isSubscriberTypeValid :"+ iamService.isSubscriberTypeValid(iamResponse));
		      		
		      		perkPerkeligibilityList.add(buildPerkeligibility(false, iamResponse.getMsisdn(), null, 1000,"Non-eligible Billing Type", false));
		      	}
		      		
		      	
	      		
      		}
      	}
		
		response.setTmoid(request.getTmoid());
		response.setPerkeligibility(perkPerkeligibilityList);
		
		System.out.println("Respons processed ....");
      	
		return response;
		
	}
	
		private  Perkeligibility buildPerkeligibility(boolean perkIndicator, String msisdn, Date lineActivationDate, int reasonCode, String reasonDescription , boolean otpEligibility  ) {
		
		Perkeligibility perkeligibility = new Perkeligibility();
		perkeligibility.setEligibilityIndicator(perkIndicator);
		perkeligibility.setMsisdn(msisdn);
		perkeligibility.lineActivationDate(lineActivationDate);
		perkeligibility.setEligibilityReasonCode(reasonCode);
		perkeligibility.setEligibilityReasonDescription(reasonDescription);
		perkeligibility.setOtpEligibility(otpEligibility);
	
		return perkeligibility;
		}
		
	
	
	

}
