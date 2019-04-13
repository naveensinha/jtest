/*
 * 
 * 
 *
 * 
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.tmobile.finance.iam;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ResponsePrivacyAssociatedLineAccountsResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T13:48:26.690-05:00")
public class ResponsePrivacyAssociatedLineAccountsResponse {
  @SerializedName("LineID")
  private String lineID = null;

  @SerializedName("msisdn")
  private String msisdn = null;

  @SerializedName("InterestBasedAds")
  private Boolean interestBasedAds = null;

  public ResponsePrivacyAssociatedLineAccountsResponse lineID(String lineID) {
    this.lineID = lineID;
    return this;
  }

   /**
   * Get lineID
   * @return lineID
  **/
  @ApiModelProperty(value = "")
  public String getLineID() {
    return lineID;
  }

  public void setLineID(String lineID) {
    this.lineID = lineID;
  }

  public ResponsePrivacyAssociatedLineAccountsResponse msisdn(String msisdn) {
    this.msisdn = msisdn;
    return this;
  }

   /**
   * Get msisdn
   * @return msisdn
  **/
  @ApiModelProperty(value = "")
  public String getMsisdn() {
    return msisdn;
  }

  public void setMsisdn(String msisdn) {
    this.msisdn = msisdn;
  }

  public ResponsePrivacyAssociatedLineAccountsResponse interestBasedAds(Boolean interestBasedAds) {
    this.interestBasedAds = interestBasedAds;
    return this;
  }

   /**
   * Get interestBasedAds
   * @return interestBasedAds
  **/
  @ApiModelProperty(value = "")
  public Boolean getInterestBasedAds() {
    return interestBasedAds;
  }

  public void setInterestBasedAds(Boolean interestBasedAds) {
    this.interestBasedAds = interestBasedAds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsePrivacyAssociatedLineAccountsResponse responsePrivacyAssociatedLineAccountsResponse = (ResponsePrivacyAssociatedLineAccountsResponse) o;
    return Objects.equals(this.lineID, responsePrivacyAssociatedLineAccountsResponse.lineID) &&
        Objects.equals(this.msisdn, responsePrivacyAssociatedLineAccountsResponse.msisdn) &&
        Objects.equals(this.interestBasedAds, responsePrivacyAssociatedLineAccountsResponse.interestBasedAds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lineID, msisdn, interestBasedAds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePrivacyAssociatedLineAccountsResponse {\n");
    
    sb.append("    lineID: ").append(toIndentedString(lineID)).append("\n");
    sb.append("    msisdn: ").append(toIndentedString(msisdn)).append("\n");
    sb.append("    interestBasedAds: ").append(toIndentedString(interestBasedAds)).append("\n");
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

