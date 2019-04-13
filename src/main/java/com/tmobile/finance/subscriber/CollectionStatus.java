/*
 * BillingAccountsSearch
 * This service returns an account used for billing purposes.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: shay.soifer@amdocs.com
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
 * CollectionStatus
 */
@ApiModel(description = "CollectionStatus")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-08T11:56:47.701-05:00")
public class CollectionStatus {
  @SerializedName("code")
  private String code = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("involuntarySuspension")
  private String involuntarySuspension = null;

  public CollectionStatus code(String code) {
    this.code = code;
    return this;
  }

   /**
   * code
   * @return code
  **/
  @ApiModelProperty(value = "code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public CollectionStatus description(String description) {
    this.description = description;
    return this;
  }

   /**
   * description
   * @return description
  **/
  @ApiModelProperty(value = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CollectionStatus name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name
   * @return name
  **/
  @ApiModelProperty(value = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CollectionStatus involuntarySuspension(String involuntarySuspension) {
    this.involuntarySuspension = involuntarySuspension;
    return this;
  }

   /**
   * indicates whether the ban is on suspend status because of collection, valid values: Y/N
   * @return involuntarySuspension
  **/
  @ApiModelProperty(value = "indicates whether the ban is on suspend status because of collection, valid values: Y/N")
  public String getInvoluntarySuspension() {
    return involuntarySuspension;
  }

  public void setInvoluntarySuspension(String involuntarySuspension) {
    this.involuntarySuspension = involuntarySuspension;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollectionStatus collectionStatus = (CollectionStatus) o;
    return Objects.equals(this.code, collectionStatus.code) &&
        Objects.equals(this.description, collectionStatus.description) &&
        Objects.equals(this.name, collectionStatus.name) &&
        Objects.equals(this.involuntarySuspension, collectionStatus.involuntarySuspension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description, name, involuntarySuspension);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollectionStatus {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    involuntarySuspension: ").append(toIndentedString(involuntarySuspension)).append("\n");
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

