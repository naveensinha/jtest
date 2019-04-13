package com.tmobile.finance.bankperkeligibility.service;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.tmobile.finance.bankperkeligibility.pojo.SamsonResponse;
import com.tmobile.finance.bankperkeligibility.rules.EligibilityRulesPredicate;
import com.tmobile.finance.subscriber.ServicesRef;
import com.tmobile.finance.subscriber.SubscriberProfileResponse;

@Service
public class SamsonService {
	private static final Logger logger = LoggerFactory.getLogger(SamsonService.class);
	
	@Value("${samson.service.host}") 
	private  String host;
	
	@Value("${auth.url}")
	private String tokenUrl;
	
	@Value("${samson.service.url}") 
	private  String url;
	
	@Autowired
	EligibilityRulesPredicate eligibilityRulesPredicate;
	
	
	
	public SamsonResponse  getSamsonResponse(String msisdn) {
		
		logger.info("tokenUrl"+tokenUrl);
		RestTemplate restTemplate = new RestTemplate();
		SamsonResponse response = new SamsonResponse();
		SubscriberProfileResponse responseObj= new SubscriberProfileResponse();
		// Get Oauth token pass the token to samson service header as authentication. 
		
		/*OAuthTokenService oAuthTokenService = new OAuthTokenService(new RestTemplate());
		AuthorizationTokenResponse authTokenResponse = oAuthTokenService.getAuthorizationToken();
		String tokenType = authTokenResponse.getTokenType();
		logger.info("tokenType:"+tokenType);*/
		
		// end the Otuath token response. 
		
		
		 HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.APPLICATION_JSON);
	      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	      headers.add("Content-Type", "application/json");
	      headers.add("activityid", "123");
	      //headers.add("Authorization", authorizationHeader);
	      String msisdnEncy = "NTYxNDAzOTg5Mg==";
	      logger.info("Base 64 misisdn:"+Base64.getEncoder().encodeToString(msisdn.getBytes()));
	      try {
			String msisdnEncy1 = URLEncoder.encode(Base64.getEncoder().encodeToString(msisdn.getBytes()), "UTF-8")
			  	.replaceAll("%3D", "=");
			  
			  logger.info("MSISDN: "+msisdn+ ", --, AFTER CONVERSION --"+msisdnEncy1);
		logger.info("URL+MisisDN :"+ url+msisdnEncy1);
	      
	      
	      HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
	      String url1 = "http://pcfqat02-promotion-ban-attributes-sa-v1.apps.px-npe01b.cf.t-mobile.com/billing-experience/v1/subscriber-fan-services?msisdn=";
	      logger.info("url form properties file -->"+url);
	      UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
	                .queryParam("msisdn",msisdnEncy);
	               // .queryParam("financialAccountId", financialAccountId);
	      
			String urlEncoded =URLEncoder.encode("http://pcfqat02-promotion-ban-attributes-sa-v1.apps.px-npe01b.cf.t-mobile.com/billing-experience/v1/subscriber-fan-services?msisdn="
					  + ""+(Base64.getEncoder().encodeToString(msisdn.getBytes())),  "UTF-8")
					.replaceAll("%3D", "=");
			  
			  
			  StringBuilder  builder = new StringBuilder(url);
			  builder.append(msisdnEncy1);
			  URI uri = URI.create(builder.toString());
			
			  logger.info("URI-->"+uri);
			
			  
		      ResponseEntity<SubscriberProfileResponse> reponseStr = restTemplate.exchange(
		    		url + ""+(msisdnEncy),
		    		//  url+""+Base64.getEncoder().encodeToString(msisdn.getBytes()),
	                HttpMethod.GET,
	                requestEntity,
	                SubscriberProfileResponse.class
	        );
		      responseObj = reponseStr.getBody();
		     if(!reponseStr.getStatusCode().equals(HttpStatus.OK))
		     {
		    	 	response.setEligibilityIndicator(false);
					response.setEligibilityReasonCode(1002);
					response.setEligibilityReasonDescription("BAN is not TMO customer");
					return response;
		     }
	     logger.info("Samson Response -->"+reponseStr.toString());
	     
	      } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	      
	      
	   
	        List<ServicesRef> customerRatePlanType = responseObj.getSubscriber().getServices().stream()    // converting the list to stream
	                .filter(x -> (x.getType().equals("R") || x.getType().equals("V") ))   // filter the stream to create a new stream
	                .collect(Collectors.toList());  // collect the final stream and convert it to a List

	        //longnames.forEach(System.out::println);
	        
	        List<ServicesRef> customerRatePlan = responseObj.getSubscriber().getServices().stream()    // converting the list to stream
	                .filter(x -> (x.getCode().equals("ZTM1TI9") ))   // filter the stream to create a new stream
	                .collect(Collectors.toList());  // collect the final stream and convert it to a List
	        
	        //longnames1.forEach(System.out::println);
	        
	        List<ServicesRef> oTPEligibility = responseObj.getSubscriber().getServices().stream()    // converting the list to stream
	                .filter(x -> (!(x.getType().equals("D") )))   // filter the stream to create a new stream
	                .collect(Collectors.toList());  // collect the final stream and convert it to a List

		
		
		// verifying the rules 
		if(responseObj.getSubscriber().getStatus().equals("A") ) {
			response.setEligibilityIndicator(true);
			
			
			if(customerRatePlanType.size() > 0 ) {
				response.setEligibilityIndicator(true);
				 if(customerRatePlan.size() >0) {
					 response.setEligibilityIndicator(true);
				 } else 
				 {
					 	response.setEligibilityIndicator(false);
						response.setEligibilityReasonCode(1003);
						response.setEligibilityReasonDescription("Wireless service status is not eligible for perk,");
				 }
			}
			else {
				response.setEligibilityIndicator(false);
				response.setEligibilityReasonCode(1004);
				response.setEligibilityReasonDescription("Rate Plan is not eligiable");
			}
				
		}else
		{
			response.setEligibilityIndicator(false);
			response.setEligibilityReasonCode(1002);
			response.setEligibilityReasonDescription("Wireless service status is not eligible for perk,");
			
		}
		
		if(oTPEligibility.size() >0)  {
			response.setOtpEligibility(true);
			logger.info("ActivationDate from samson DB -->"+responseObj.getSubscriber().getActivationDate());
			response.setActivationDate(responseObj.getSubscriber().getActivationDate());
		}
		
		response.setLineStatus(responseObj.getSubscriber().getStatus());
		logger.info("Samson Service response --"+response.getLineStatus());
		return response;
	}
	
	private HttpHeaders createHttpHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      //  headers.add("Authorization", "False");
        return headers;
    }
	
	/*public boolean validateSamsonResponse(SamsonResponse resp) {
		return ((eligibilityRulesPredicate.isCustomerRatePlanValid(resp.getCustomerRatePlan())) &&  
			 eligibilityRulesPredicate.isLineEligibleValid(resp.getLineStatus(), resp.getServiceLineType()));
	
	}*/

}
