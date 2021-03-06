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
import com.tmobile.finance.model.Perkeligibility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * EligibilityResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-09T14:14:34.114-05:00")
public class EligibilityResponse {
  @SerializedName("tmoid")
  private String tmoid = null;

  @SerializedName("perkeligibility")
  private List<Perkeligibility> perkeligibility = null;

  public EligibilityResponse tmoid(String tmoid) {
    this.tmoid = tmoid;
    return this;
  }

   /**
   * string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477
   * @return tmoid
  **/
  @ApiModelProperty(required = true, value = "string is a predefined object from an igniteXml model - cabinet 1001760002 build 1001760247 key 1001760477")
  public String getTmoid() {
    return tmoid;
  }

  public void setTmoid(String tmoid) {
    this.tmoid = tmoid;
  }

  public EligibilityResponse perkeligibility(List<Perkeligibility> perkeligibility) {
    this.perkeligibility = perkeligibility;
    return this;
  }

  public EligibilityResponse addPerkeligibilityItem(Perkeligibility perkeligibilityItem) {
    if (this.perkeligibility == null) {
      this.perkeligibility = new ArrayList<Perkeligibility>();
    }
    this.perkeligibility.add(perkeligibilityItem);
    return this;
  }

   /**
   * An array of perkeligibility objects.
   * @return perkeligibility
  **/
  @ApiModelProperty(value = "An array of perkeligibility objects.")
  public List<Perkeligibility> getPerkeligibility() {
    return perkeligibility;
  }

  public void setPerkeligibility(List<Perkeligibility> perkeligibility) {
    this.perkeligibility = perkeligibility;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EligibilityResponse eligibilityResponse = (EligibilityResponse) o;
    return Objects.equals(this.tmoid, eligibilityResponse.tmoid) &&
        Objects.equals(this.perkeligibility, eligibilityResponse.perkeligibility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tmoid, perkeligibility);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EligibilityResponse {\n");
    
    sb.append("    tmoid: ").append(toIndentedString(tmoid)).append("\n");
    sb.append("    perkeligibility: ").append(toIndentedString(perkeligibility)).append("\n");
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

