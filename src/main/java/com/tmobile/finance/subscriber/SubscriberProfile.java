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
import com.tmobile.finance.subscriber.ServicesRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SubscriberProfile
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-08T15:53:35.582-05:00")
public class SubscriberProfile {
  @SerializedName("status")
  private String status = null;

  @SerializedName("services")
  private List<ServicesRef> services = null;

  @SerializedName("activationDate")
  private String activationDate = null;

  @SerializedName("paperWorkDate")
  private String paperWorkDate = null;

  public SubscriberProfile status(String status) {
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

  public SubscriberProfile services(List<ServicesRef> services) {
    this.services = services;
    return this;
  }

  public SubscriberProfile addServicesItem(ServicesRef servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<ServicesRef>();
    }
    this.services.add(servicesItem);
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @ApiModelProperty(value = "")
  public List<ServicesRef> getServices() {
    return services;
  }

  public void setServices(List<ServicesRef> services) {
    this.services = services;
  }

  public SubscriberProfile activationDate(String activationDate) {
    this.activationDate = activationDate;
    return this;
  }

   /**
   * Get activationDate
   * @return activationDate
  **/
  @ApiModelProperty(value = "")
  public String getActivationDate() {
    return activationDate;
  }

  public void setActivationDate(String activationDate) {
    this.activationDate = activationDate;
  }

  public SubscriberProfile paperWorkDate(String paperWorkDate) {
    this.paperWorkDate = paperWorkDate;
    return this;
  }

   /**
   * Get paperWorkDate
   * @return paperWorkDate
  **/
  @ApiModelProperty(value = "")
  public String getPaperWorkDate() {
    return paperWorkDate;
  }

  public void setPaperWorkDate(String paperWorkDate) {
    this.paperWorkDate = paperWorkDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriberProfile subscriberProfile = (SubscriberProfile) o;
    return Objects.equals(this.status, subscriberProfile.status) &&
        Objects.equals(this.services, subscriberProfile.services) &&
        Objects.equals(this.activationDate, subscriberProfile.activationDate) &&
        Objects.equals(this.paperWorkDate, subscriberProfile.paperWorkDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, services, activationDate, paperWorkDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriberProfile {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    activationDate: ").append(toIndentedString(activationDate)).append("\n");
    sb.append("    paperWorkDate: ").append(toIndentedString(paperWorkDate)).append("\n");
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

