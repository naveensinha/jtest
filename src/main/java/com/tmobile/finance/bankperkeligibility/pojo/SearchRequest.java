package com.tmobile.finance.bankperkeligibility.pojo;

public class SearchRequest {
 
	private String objectclass;
	private String msisdn;
	private String value;
	
	
	public String getObjectclass() {
		return objectclass;
	}

	public void setObjectclass(String objectclass) {
		this.objectclass = objectclass;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	 @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class IAMServiceRequest {\n");
	    sb.append("    objectclass: ").append(toIndentedString(objectclass)).append("\n");
	    sb.append("    msisdn: ").append(toIndentedString(msisdn)).append("\n");
	    sb.append("    value: ").append(toIndentedString(value)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }
	
	 private String toIndentedString(java.lang.Object o) {
		    if (o == null) {
		      return "null";
		    }
		    return o.toString().replace("\n", "\n    ");
		  }
}
