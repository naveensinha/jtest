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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tmobile.finance.iam.ResponsePrivacyOfferPreference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ResponsePrivacyAvailableLists
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T13:48:26.690-05:00")
public class ResponsePrivacyAvailableLists {
  @SerializedName("offer_preference")
  @JsonProperty("offer_preference")
  private List<ResponsePrivacyOfferPreference> offerPreference = null;

  public ResponsePrivacyAvailableLists offerPreference(List<ResponsePrivacyOfferPreference> offerPreference) {
    this.offerPreference = offerPreference;
    return this;
  }

  public ResponsePrivacyAvailableLists addOfferPreferenceItem(ResponsePrivacyOfferPreference offerPreferenceItem) {
    if (this.offerPreference == null) {
      this.offerPreference = new ArrayList<ResponsePrivacyOfferPreference>();
    }
    this.offerPreference.add(offerPreferenceItem);
    return this;
  }

   /**
   * Get offerPreference
   * @return offerPreference
  **/
  @ApiModelProperty(value = "")
  public List<ResponsePrivacyOfferPreference> getOfferPreference() {
    return offerPreference;
  }

  public void setOfferPreference(List<ResponsePrivacyOfferPreference> offerPreference) {
    this.offerPreference = offerPreference;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsePrivacyAvailableLists responsePrivacyAvailableLists = (ResponsePrivacyAvailableLists) o;
    return Objects.equals(this.offerPreference, responsePrivacyAvailableLists.offerPreference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offerPreference);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePrivacyAvailableLists {\n");
    
    sb.append("    offerPreference: ").append(toIndentedString(offerPreference)).append("\n");
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

