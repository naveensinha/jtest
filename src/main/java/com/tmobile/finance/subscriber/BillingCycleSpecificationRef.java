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
 * BillingCycleSpecificationRef
 */
@ApiModel(description = "BillingCycleSpecificationRef")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-08T11:56:47.701-05:00")
public class BillingCycleSpecificationRef {
  @SerializedName("cycle")
  private String cycle = null;

  @SerializedName("nextCycle")
  private String nextCycle = null;

  public BillingCycleSpecificationRef cycle(String cycle) {
    this.cycle = cycle;
    return this;
  }

   /**
   * cycle
   * @return cycle
  **/
  @ApiModelProperty(value = "cycle")
  public String getCycle() {
    return cycle;
  }

  public void setCycle(String cycle) {
    this.cycle = cycle;
  }

  public BillingCycleSpecificationRef nextCycle(String nextCycle) {
    this.nextCycle = nextCycle;
    return this;
  }

   /**
   * nextCycle
   * @return nextCycle
  **/
  @ApiModelProperty(value = "nextCycle")
  public String getNextCycle() {
    return nextCycle;
  }

  public void setNextCycle(String nextCycle) {
    this.nextCycle = nextCycle;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingCycleSpecificationRef billingCycleSpecificationRef = (BillingCycleSpecificationRef) o;
    return Objects.equals(this.cycle, billingCycleSpecificationRef.cycle) &&
        Objects.equals(this.nextCycle, billingCycleSpecificationRef.nextCycle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cycle, nextCycle);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingCycleSpecificationRef {\n");
    
    sb.append("    cycle: ").append(toIndentedString(cycle)).append("\n");
    sb.append("    nextCycle: ").append(toIndentedString(nextCycle)).append("\n");
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

