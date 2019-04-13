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
import com.tmobile.finance.iam.ResponseIAMUniverseCustomers1;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ResponseIAMUniverseBillingAccountDetails
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T13:48:26.690-05:00")
public class ResponseIAMUniverseBillingAccountDetails {
  @SerializedName("BillingAccountCode")
  private String billingAccountCode = null;

  @SerializedName("BusinessLine")
  private String businessLine = null;

  @SerializedName("FraudLine")
  private String fraudLine = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("StatusDate")
  private String statusDate = null;

  @SerializedName("BillCycleDay")
  private String billCycleDay = null;

  @SerializedName("PaymentOptions")
  private String paymentOptions = null;

  @SerializedName("PrimaryLine")
  private String primaryLine = null;

  @SerializedName("Street")
  private String street = null;

  @SerializedName("City")
  private String city = null;

  @SerializedName("County")
  private String county = null;

  @SerializedName("State")
  private String state = null;

  @SerializedName("Country")
  private String country = null;

  @SerializedName("ZipCode")
  private String zipCode = null;

  @SerializedName("Customers")
  private List<ResponseIAMUniverseCustomers1> customers = null;

  public ResponseIAMUniverseBillingAccountDetails billingAccountCode(String billingAccountCode) {
    this.billingAccountCode = billingAccountCode;
    return this;
  }

   /**
   * Get billingAccountCode
   * @return billingAccountCode
  **/
  @ApiModelProperty(value = "")
  public String getBillingAccountCode() {
    return billingAccountCode;
  }

  public void setBillingAccountCode(String billingAccountCode) {
    this.billingAccountCode = billingAccountCode;
  }

  public ResponseIAMUniverseBillingAccountDetails businessLine(String businessLine) {
    this.businessLine = businessLine;
    return this;
  }

   /**
   * Get businessLine
   * @return businessLine
  **/
  @ApiModelProperty(value = "")
  public String getBusinessLine() {
    return businessLine;
  }

  public void setBusinessLine(String businessLine) {
    this.businessLine = businessLine;
  }

  public ResponseIAMUniverseBillingAccountDetails fraudLine(String fraudLine) {
    this.fraudLine = fraudLine;
    return this;
  }

   /**
   * Get fraudLine
   * @return fraudLine
  **/
  @ApiModelProperty(value = "")
  public String getFraudLine() {
    return fraudLine;
  }

  public void setFraudLine(String fraudLine) {
    this.fraudLine = fraudLine;
  }

  public ResponseIAMUniverseBillingAccountDetails status(String status) {
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

  public ResponseIAMUniverseBillingAccountDetails statusDate(String statusDate) {
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

  public ResponseIAMUniverseBillingAccountDetails billCycleDay(String billCycleDay) {
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   * Get billCycleDay
   * @return billCycleDay
  **/
  @ApiModelProperty(value = "")
  public String getBillCycleDay() {
    return billCycleDay;
  }

  public void setBillCycleDay(String billCycleDay) {
    this.billCycleDay = billCycleDay;
  }

  public ResponseIAMUniverseBillingAccountDetails paymentOptions(String paymentOptions) {
    this.paymentOptions = paymentOptions;
    return this;
  }

   /**
   * Get paymentOptions
   * @return paymentOptions
  **/
  @ApiModelProperty(value = "")
  public String getPaymentOptions() {
    return paymentOptions;
  }

  public void setPaymentOptions(String paymentOptions) {
    this.paymentOptions = paymentOptions;
  }

  public ResponseIAMUniverseBillingAccountDetails primaryLine(String primaryLine) {
    this.primaryLine = primaryLine;
    return this;
  }

   /**
   * Get primaryLine
   * @return primaryLine
  **/
  @ApiModelProperty(value = "")
  public String getPrimaryLine() {
    return primaryLine;
  }

  public void setPrimaryLine(String primaryLine) {
    this.primaryLine = primaryLine;
  }

  public ResponseIAMUniverseBillingAccountDetails street(String street) {
    this.street = street;
    return this;
  }

   /**
   * Get street
   * @return street
  **/
  @ApiModelProperty(value = "")
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public ResponseIAMUniverseBillingAccountDetails city(String city) {
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ResponseIAMUniverseBillingAccountDetails county(String county) {
    this.county = county;
    return this;
  }

   /**
   * Get county
   * @return county
  **/
  @ApiModelProperty(value = "")
  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public ResponseIAMUniverseBillingAccountDetails state(String state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ResponseIAMUniverseBillingAccountDetails country(String country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ResponseIAMUniverseBillingAccountDetails zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

   /**
   * Get zipCode
   * @return zipCode
  **/
  @ApiModelProperty(value = "")
  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public ResponseIAMUniverseBillingAccountDetails customers(List<ResponseIAMUniverseCustomers1> customers) {
    this.customers = customers;
    return this;
  }

  public ResponseIAMUniverseBillingAccountDetails addCustomersItem(ResponseIAMUniverseCustomers1 customersItem) {
    if (this.customers == null) {
      this.customers = new ArrayList<ResponseIAMUniverseCustomers1>();
    }
    this.customers.add(customersItem);
    return this;
  }

   /**
   * Get customers
   * @return customers
  **/
  @ApiModelProperty(value = "")
  public List<ResponseIAMUniverseCustomers1> getCustomers() {
    return customers;
  }

  public void setCustomers(List<ResponseIAMUniverseCustomers1> customers) {
    this.customers = customers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseIAMUniverseBillingAccountDetails responseIAMUniverseBillingAccountDetails = (ResponseIAMUniverseBillingAccountDetails) o;
    return Objects.equals(this.billingAccountCode, responseIAMUniverseBillingAccountDetails.billingAccountCode) &&
        Objects.equals(this.businessLine, responseIAMUniverseBillingAccountDetails.businessLine) &&
        Objects.equals(this.fraudLine, responseIAMUniverseBillingAccountDetails.fraudLine) &&
        Objects.equals(this.status, responseIAMUniverseBillingAccountDetails.status) &&
        Objects.equals(this.statusDate, responseIAMUniverseBillingAccountDetails.statusDate) &&
        Objects.equals(this.billCycleDay, responseIAMUniverseBillingAccountDetails.billCycleDay) &&
        Objects.equals(this.paymentOptions, responseIAMUniverseBillingAccountDetails.paymentOptions) &&
        Objects.equals(this.primaryLine, responseIAMUniverseBillingAccountDetails.primaryLine) &&
        Objects.equals(this.street, responseIAMUniverseBillingAccountDetails.street) &&
        Objects.equals(this.city, responseIAMUniverseBillingAccountDetails.city) &&
        Objects.equals(this.county, responseIAMUniverseBillingAccountDetails.county) &&
        Objects.equals(this.state, responseIAMUniverseBillingAccountDetails.state) &&
        Objects.equals(this.country, responseIAMUniverseBillingAccountDetails.country) &&
        Objects.equals(this.zipCode, responseIAMUniverseBillingAccountDetails.zipCode) &&
        Objects.equals(this.customers, responseIAMUniverseBillingAccountDetails.customers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(billingAccountCode, businessLine, fraudLine, status, statusDate, billCycleDay, paymentOptions, primaryLine, street, city, county, state, country, zipCode, customers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseIAMUniverseBillingAccountDetails {\n");
    
    sb.append("    billingAccountCode: ").append(toIndentedString(billingAccountCode)).append("\n");
    sb.append("    businessLine: ").append(toIndentedString(businessLine)).append("\n");
    sb.append("    fraudLine: ").append(toIndentedString(fraudLine)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusDate: ").append(toIndentedString(statusDate)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    paymentOptions: ").append(toIndentedString(paymentOptions)).append("\n");
    sb.append("    primaryLine: ").append(toIndentedString(primaryLine)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    county: ").append(toIndentedString(county)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    customers: ").append(toIndentedString(customers)).append("\n");
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

