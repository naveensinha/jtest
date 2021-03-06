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
 * ResponseIAMUniverseCustomerDetails
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T13:48:26.690-05:00")
public class ResponseIAMUniverseCustomerDetails {
  @SerializedName("CustomerNumber")
  private String customerNumber = null;

  @SerializedName("BusinessUnit")
  private String businessUnit = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("StatusDate")
  private String statusDate = null;

  @SerializedName("AccountCreationDate")
  private String accountCreationDate = null;

  @SerializedName("FirstName")
  private String firstName = null;

  @SerializedName("DateofBirth")
  private String dateofBirth = null;

  @SerializedName("Gender")
  private String gender = null;

  public ResponseIAMUniverseCustomerDetails customerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
    return this;
  }

   /**
   * Get customerNumber
   * @return customerNumber
  **/
  @ApiModelProperty(value = "")
  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public ResponseIAMUniverseCustomerDetails businessUnit(String businessUnit) {
    this.businessUnit = businessUnit;
    return this;
  }

   /**
   * Get businessUnit
   * @return businessUnit
  **/
  @ApiModelProperty(value = "")
  public String getBusinessUnit() {
    return businessUnit;
  }

  public void setBusinessUnit(String businessUnit) {
    this.businessUnit = businessUnit;
  }

  public ResponseIAMUniverseCustomerDetails status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ResponseIAMUniverseCustomerDetails statusDate(String statusDate) {
    this.statusDate = statusDate;
    return this;
  }

   /**
   * Get statusDate
   * @return statusDate
  **/
  @ApiModelProperty(value = "")
  public String getStatusDate() {
    return statusDate;
  }

  public void setStatusDate(String statusDate) {
    this.statusDate = statusDate;
  }

  public ResponseIAMUniverseCustomerDetails accountCreationDate(String accountCreationDate) {
    this.accountCreationDate = accountCreationDate;
    return this;
  }

   /**
   * Get accountCreationDate
   * @return accountCreationDate
  **/
  @ApiModelProperty(value = "")
  public String getAccountCreationDate() {
    return accountCreationDate;
  }

  public void setAccountCreationDate(String accountCreationDate) {
    this.accountCreationDate = accountCreationDate;
  }

  public ResponseIAMUniverseCustomerDetails firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public ResponseIAMUniverseCustomerDetails dateofBirth(String dateofBirth) {
    this.dateofBirth = dateofBirth;
    return this;
  }

   /**
   * Get dateofBirth
   * @return dateofBirth
  **/
  @ApiModelProperty(value = "")
  public String getDateofBirth() {
    return dateofBirth;
  }

  public void setDateofBirth(String dateofBirth) {
    this.dateofBirth = dateofBirth;
  }

  public ResponseIAMUniverseCustomerDetails gender(String gender) {
    this.gender = gender;
    return this;
  }

   /**
   * Get gender
   * @return gender
  **/
  @ApiModelProperty(value = "")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseIAMUniverseCustomerDetails responseIAMUniverseCustomerDetails = (ResponseIAMUniverseCustomerDetails) o;
    return Objects.equals(this.customerNumber, responseIAMUniverseCustomerDetails.customerNumber) &&
        Objects.equals(this.businessUnit, responseIAMUniverseCustomerDetails.businessUnit) &&
        Objects.equals(this.status, responseIAMUniverseCustomerDetails.status) &&
        Objects.equals(this.statusDate, responseIAMUniverseCustomerDetails.statusDate) &&
        Objects.equals(this.accountCreationDate, responseIAMUniverseCustomerDetails.accountCreationDate) &&
        Objects.equals(this.firstName, responseIAMUniverseCustomerDetails.firstName) &&
        Objects.equals(this.dateofBirth, responseIAMUniverseCustomerDetails.dateofBirth) &&
        Objects.equals(this.gender, responseIAMUniverseCustomerDetails.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNumber, businessUnit, status, statusDate, accountCreationDate, firstName, dateofBirth, gender);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseIAMUniverseCustomerDetails {\n");
    
    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    businessUnit: ").append(toIndentedString(businessUnit)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusDate: ").append(toIndentedString(statusDate)).append("\n");
    sb.append("    accountCreationDate: ").append(toIndentedString(accountCreationDate)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    dateofBirth: ").append(toIndentedString(dateofBirth)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
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

