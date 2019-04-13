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
import com.tmobile.finance.iam.ResponsePrivacyPreferences;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ResponsePrivacyResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T13:48:26.690-05:00")
public class ResponsePrivacyResponse {
  @SerializedName("Offer")
  private String offer = null;

  @SerializedName("Preferences")
  private List<ResponsePrivacyPreferences> preferences = null;

  public ResponsePrivacyResponse offer(String offer) {
    this.offer = offer;
    return this;
  }

   /**
   * Get offer
   * @return offer
  **/
  @ApiModelProperty(value = "")
  public String getOffer() {
    return offer;
  }

  public void setOffer(String offer) {
    this.offer = offer;
  }

  public ResponsePrivacyResponse preferences(List<ResponsePrivacyPreferences> preferences) {
    this.preferences = preferences;
    return this;
  }

  public ResponsePrivacyResponse addPreferencesItem(ResponsePrivacyPreferences preferencesItem) {
    if (this.preferences == null) {
      this.preferences = new ArrayList<ResponsePrivacyPreferences>();
    }
    this.preferences.add(preferencesItem);
    return this;
  }

   /**
   * Get preferences
   * @return preferences
  **/
  @ApiModelProperty(value = "")
  public List<ResponsePrivacyPreferences> getPreferences() {
    return preferences;
  }

  public void setPreferences(List<ResponsePrivacyPreferences> preferences) {
    this.preferences = preferences;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsePrivacyResponse responsePrivacyResponse = (ResponsePrivacyResponse) o;
    return Objects.equals(this.offer, responsePrivacyResponse.offer) &&
        Objects.equals(this.preferences, responsePrivacyResponse.preferences);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offer, preferences);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePrivacyResponse {\n");
    
    sb.append("    offer: ").append(toIndentedString(offer)).append("\n");
    sb.append("    preferences: ").append(toIndentedString(preferences)).append("\n");
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

