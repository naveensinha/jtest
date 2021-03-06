/*
 * BankPerkEligibility
 * This API will be used when the customer signs up for bank account to check their Perk Eligibility
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.tmobile.finance.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.Date;

/**
 * An array of documents objects.
 */
@ApiModel(description = "An array of documents objects.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-09T14:14:34.114-05:00")
public class Perkeligibility {
  @SerializedName("eligibilityIndicator")
  private Boolean eligibilityIndicator = null;

  @SerializedName("msisdn")
  private String msisdn = null;

  @SerializedName("lineActivationDate")
  private Date lineActivationDate = null;

  @SerializedName("eligibilityReasonCode")
  private Integer eligibilityReasonCode = null;

  @SerializedName("eligibilityReasonDescription")
  private String eligibilityReasonDescription = null;

  @SerializedName("otpEligibility")
  private Boolean otpEligibility = null;

  public Perkeligibility eligibilityIndicator(Boolean eligibilityIndicator) {
    this.eligibilityIndicator = eligibilityIndicator;
    return this;
  }

   /**
   * string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477
   * @return eligibilityIndicator
  **/
  @ApiModelProperty(required = true, value = "string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477")
  public Boolean getEligibilityIndicator() {
    return eligibilityIndicator;
  }

  public void setEligibilityIndicator(Boolean eligibilityIndicator) {
    this.eligibilityIndicator = eligibilityIndicator;
  }

  public Perkeligibility msisdn(String msisdn) {
    this.msisdn = msisdn;
    return this;
  }

   /**
   * string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477
   * @return msisdn
  **/
  @ApiModelProperty(value = "string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477")
  public String getMsisdn() {
    return msisdn;
  }

  public void setMsisdn(String msisdn) {
    this.msisdn = msisdn;
  }

  public Perkeligibility lineActivationDate(Date lineActivationDate) {
    this.lineActivationDate = lineActivationDate;
    return this;
  }

   /**
   * string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477
   * @return lineActivationDate
  **/
  @ApiModelProperty(value = "string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477")
  public Date getLineActivationDate() {
    return lineActivationDate;
  }

  public void setLineActivationDate(Date lineActivationDate) {
    this.lineActivationDate = lineActivationDate;
  }

  public Perkeligibility eligibilityReasonCode(Integer eligibilityReasonCode) {
    this.eligibilityReasonCode = eligibilityReasonCode;
    return this;
  }

   /**
   * string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477
   * minimum: -2147483648
   * maximum: 2147483647
   * @return eligibilityReasonCode
  **/
  @ApiModelProperty(value = "string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477")
  public Integer getEligibilityReasonCode() {
    return eligibilityReasonCode;
  }

  public void setEligibilityReasonCode(Integer eligibilityReasonCode) {
    this.eligibilityReasonCode = eligibilityReasonCode;
  }

  public Perkeligibility eligibilityReasonDescription(String eligibilityReasonDescription) {
    this.eligibilityReasonDescription = eligibilityReasonDescription;
    return this;
  }

   /**
   * string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477
   * @return eligibilityReasonDescription
  **/
  @ApiModelProperty(value = "string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477")
  public String getEligibilityReasonDescription() {
    return eligibilityReasonDescription;
  }

  public void setEligibilityReasonDescription(String eligibilityReasonDescription) {
    this.eligibilityReasonDescription = eligibilityReasonDescription;
  }

  public Perkeligibility otpEligibility(Boolean otpEligibility) {
    this.otpEligibility = otpEligibility;
    return this;
  }

   /**
   * Get otpEligibility
   * @return otpEligibility
  **/
  @ApiModelProperty(value = "")
  public Boolean getOtpEligibility() {
    return otpEligibility;
  }

  public void setOtpEligibility(Boolean otpEligibility) {
    this.otpEligibility = otpEligibility;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Perkeligibility perkeligibility = (Perkeligibility) o;
    return Objects.equals(this.eligibilityIndicator, perkeligibility.eligibilityIndicator) &&
        Objects.equals(this.msisdn, perkeligibility.msisdn) &&
        Objects.equals(this.lineActivationDate, perkeligibility.lineActivationDate) &&
        Objects.equals(this.eligibilityReasonCode, perkeligibility.eligibilityReasonCode) &&
        Objects.equals(this.eligibilityReasonDescription, perkeligibility.eligibilityReasonDescription) &&
        Objects.equals(this.otpEligibility, perkeligibility.otpEligibility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eligibilityIndicator, msisdn, lineActivationDate, eligibilityReasonCode, eligibilityReasonDescription, otpEligibility);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Perkeligibility {\n");
    
    sb.append("    eligibilityIndicator: ").append(toIndentedString(eligibilityIndicator)).append("\n");
    sb.append("    msisdn: ").append(toIndentedString(msisdn)).append("\n");
    sb.append("    lineActivationDate: ").append(toIndentedString(lineActivationDate)).append("\n");
    sb.append("    eligibilityReasonCode: ").append(toIndentedString(eligibilityReasonCode)).append("\n");
    sb.append("    eligibilityReasonDescription: ").append(toIndentedString(eligibilityReasonDescription)).append("\n");
    sb.append("    otpEligibility: ").append(toIndentedString(otpEligibility)).append("\n");
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

