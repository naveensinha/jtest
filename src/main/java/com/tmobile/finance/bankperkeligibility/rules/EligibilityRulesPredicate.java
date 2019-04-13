package com.tmobile.finance.bankperkeligibility.rules;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class EligibilityRulesPredicate {
	
	@Value("#{'${accountTypeSubTypes}'.split(',')}")
	private  List<String> accountTypeSubTypesList;
	
	@Value("#{'${customerPlanRate}'.split(',')}") 
	private   List<String> customerRatePlanlist;
	
	@Value("#{'${billingMethod}'.split(',')}") 
	private   List<String> billingMethodList;
	
	
	@Value("${lineStatus}") 
	private   String lineStatus;
	
	@Value("${mbbStatus}") 
	private  String mbbStatus;
	
	@Value("${subscriberType}") 
	private  String subscriberType;
	
	
	public boolean isAccountTypesubtypesValid(String accountTypeSubtypes) {
		return accountTypeSubTypesList.contains(accountTypeSubtypes);
		
	}
	 
	 public  boolean isCustomerRatePlanValid(String customerRatePlan ) {
		 return customerRatePlanlist.contains(customerRatePlan);
	 }
	 
	 public  boolean isLineEligibleValid(String samsonLineStatus , String mbb ) {
		 return (samsonLineStatus.equals(lineStatus)  && mbb.equals(mbbStatus));
	 }
	 
	 public boolean isSubscriberTypeValid(String  iamSubscriberType) { 		
			return 	iamSubscriberType.equals(subscriberType);
		
		}
	 public boolean eligibilityIndicator(String accountType_subtypes, String customerRatePlan, String lineStatus , String billingMethod, String mbb  )
	 {
		 return (isAccountTypesubtypesValid(accountType_subtypes) && isCustomerRatePlanValid(customerRatePlan) && isLineEligibleValid(lineStatus,mbb));
	 }
	 
	 
}
