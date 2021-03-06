/*
 * Promotions - Ban and Subscriber Level Attributes
 * This document describes Promotion APIs that retrieve information about a subscriber and its ban (services - SOCs/Rate Plans, activation date etc)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.tmobile.finance.subscriber;

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
 * ErrorResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-08T15:53:35.582-05:00")
public class ErrorResponse {
  @SerializedName("code")
  private String code = null;

  @SerializedName("userMessage")
  private String userMessage = null;

  @SerializedName("systemMessage")
  private String systemMessage = null;

  @SerializedName("requestURI")
  private String requestURI = null;

  public ErrorResponse code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(value = "")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorResponse userMessage(String userMessage) {
    this.userMessage = userMessage;
    return this;
  }

   /**
   * Get userMessage
   * @return userMessage
  **/
  @ApiModelProperty(value = "")
  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }

  public ErrorResponse systemMessage(String systemMessage) {
    this.systemMessage = systemMessage;
    return this;
  }

   /**
   * Get systemMessage
   * @return systemMessage
  **/
  @ApiModelProperty(value = "")
  public String getSystemMessage() {
    return systemMessage;
  }

  public void setSystemMessage(String systemMessage) {
    this.systemMessage = systemMessage;
  }

  public ErrorResponse requestURI(String requestURI) {
    this.requestURI = requestURI;
    return this;
  }

   /**
   * Get requestURI
   * @return requestURI
  **/
  @ApiModelProperty(value = "")
  public String getRequestURI() {
    return requestURI;
  }

  public void setRequestURI(String requestURI) {
    this.requestURI = requestURI;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.code, errorResponse.code) &&
        Objects.equals(this.userMessage, errorResponse.userMessage) &&
        Objects.equals(this.systemMessage, errorResponse.systemMessage) &&
        Objects.equals(this.requestURI, errorResponse.requestURI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, userMessage, systemMessage, requestURI);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    userMessage: ").append(toIndentedString(userMessage)).append("\n");
    sb.append("    systemMessage: ").append(toIndentedString(systemMessage)).append("\n");
    sb.append("    requestURI: ").append(toIndentedString(requestURI)).append("\n");
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

