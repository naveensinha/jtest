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
 * ResponseTMobileIdentityAccountDetailsPasswords
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T13:48:26.690-05:00")
public class ResponseTMobileIdentityAccountDetailsPasswords {
  @SerializedName("PasswordResetCount")
  private String passwordResetCount = null;

  @SerializedName("LastPasswordResetDate")
  private String lastPasswordResetDate = null;

  @SerializedName("LastPasswordUpdateDate")
  private String lastPasswordUpdateDate = null;

  public ResponseTMobileIdentityAccountDetailsPasswords passwordResetCount(String passwordResetCount) {
    this.passwordResetCount = passwordResetCount;
    return this;
  }

   /**
   * Get passwordResetCount
   * @return passwordResetCount
  **/
  @ApiModelProperty(value = "")
  public String getPasswordResetCount() {
    return passwordResetCount;
  }

  public void setPasswordResetCount(String passwordResetCount) {
    this.passwordResetCount = passwordResetCount;
  }

  public ResponseTMobileIdentityAccountDetailsPasswords lastPasswordResetDate(String lastPasswordResetDate) {
    this.lastPasswordResetDate = lastPasswordResetDate;
    return this;
  }

   /**
   * Get lastPasswordResetDate
   * @return lastPasswordResetDate
  **/
  @ApiModelProperty(value = "")
  public String getLastPasswordResetDate() {
    return lastPasswordResetDate;
  }

  public void setLastPasswordResetDate(String lastPasswordResetDate) {
    this.lastPasswordResetDate = lastPasswordResetDate;
  }

  public ResponseTMobileIdentityAccountDetailsPasswords lastPasswordUpdateDate(String lastPasswordUpdateDate) {
    this.lastPasswordUpdateDate = lastPasswordUpdateDate;
    return this;
  }

   /**
   * Get lastPasswordUpdateDate
   * @return lastPasswordUpdateDate
  **/
  @ApiModelProperty(value = "")
  public String getLastPasswordUpdateDate() {
    return lastPasswordUpdateDate;
  }

  public void setLastPasswordUpdateDate(String lastPasswordUpdateDate) {
    this.lastPasswordUpdateDate = lastPasswordUpdateDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseTMobileIdentityAccountDetailsPasswords responseTMobileIdentityAccountDetailsPasswords = (ResponseTMobileIdentityAccountDetailsPasswords) o;
    return Objects.equals(this.passwordResetCount, responseTMobileIdentityAccountDetailsPasswords.passwordResetCount) &&
        Objects.equals(this.lastPasswordResetDate, responseTMobileIdentityAccountDetailsPasswords.lastPasswordResetDate) &&
        Objects.equals(this.lastPasswordUpdateDate, responseTMobileIdentityAccountDetailsPasswords.lastPasswordUpdateDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passwordResetCount, lastPasswordResetDate, lastPasswordUpdateDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseTMobileIdentityAccountDetailsPasswords {\n");
    
    sb.append("    passwordResetCount: ").append(toIndentedString(passwordResetCount)).append("\n");
    sb.append("    lastPasswordResetDate: ").append(toIndentedString(lastPasswordResetDate)).append("\n");
    sb.append("    lastPasswordUpdateDate: ").append(toIndentedString(lastPasswordUpdateDate)).append("\n");
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

