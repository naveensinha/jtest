package com.tmobile.finance.bankperkeligibility.pojo;

import java.util.Date;

public class SamsonResponse {
	public String serviceLineType;
	public int eligibilityReasonCode;
	public String eligibilityReasonDescription;
	public String lineStatus;
	public String activationDate;
	public boolean eligibilityIndicator = false ;
	public boolean otpEligibility = false;
	
	
	public String getServiceLineType() {
		return serviceLineType;
	}
	public void setServiceLineType(String serviceLineType) {
		this.serviceLineType = serviceLineType;
	}
	
	public String getLineStatus() {
		return lineStatus;
	}
	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}
	
	
	public String getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}
	public boolean isEligibilityIndicator() {
		return eligibilityIndicator;
	}
	public void setEligibilityIndicator(boolean eligibilityIndicator) {
		this.eligibilityIndicator = eligibilityIndicator;
	}
	public boolean isOtpEligibility() {
		return otpEligibility;
	}
	public void setOtpEligibility(boolean otpEligibility) {
		this.otpEligibility = otpEligibility;
	}
	
	public String getEligibilityReasonDescription() {
		return eligibilityReasonDescription;
	}
	public void setEligibilityReasonDescription(String eligibilityReasonDescription) {
		this.eligibilityReasonDescription = eligibilityReasonDescription;
	}
	public int getEligibilityReasonCode() {
		return eligibilityReasonCode;
	}
	public void setEligibilityReasonCode(int eligibilityReasonCode) {
		this.eligibilityReasonCode = eligibilityReasonCode;
	}
	
	@Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class SamsonResponse {\n");
	    
	    sb.append("    serviceLineType: ").append(toIndentedString(serviceLineType)).append("\n");
	    sb.append("    eligibilityReasonCode: ").append(toIndentedString(eligibilityReasonCode)).append("\n");
	    sb.append("    eligibilityReasonDescription;: ").append(toIndentedString(eligibilityReasonDescription)).append("\n");
	    sb.append("    lineStatus: ").append(toIndentedString(lineStatus)).append("\n");
	    sb.append("    activationDate: ").append(toIndentedString(activationDate)).append("\n");
	    sb.append("    eligibilityIndicator : ").append(toIndentedString(eligibilityIndicator)).append("\n");
	    sb.append("    otpEligibility  : ").append(toIndentedString(otpEligibility)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
	
	

}
