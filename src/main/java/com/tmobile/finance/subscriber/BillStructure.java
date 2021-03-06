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
import com.tmobile.finance.subscriber.BillingCycleSpecificationRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * BillStructure
 */
@ApiModel(description = "BillStructure")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-08T11:56:47.701-05:00")
public class BillStructure {
  @SerializedName("cycleSpecification")
  private BillingCycleSpecificationRef cycleSpecification = null;

  public BillStructure cycleSpecification(BillingCycleSpecificationRef cycleSpecification) {
    this.cycleSpecification = cycleSpecification;
    return this;
  }

   /**
   * Get cycleSpecification
   * @return cycleSpecification
  **/
  @ApiModelProperty(value = "")
  public BillingCycleSpecificationRef getCycleSpecification() {
    return cycleSpecification;
  }

  public void setCycleSpecification(BillingCycleSpecificationRef cycleSpecification) {
    this.cycleSpecification = cycleSpecification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillStructure billStructure = (BillStructure) o;
    return Objects.equals(this.cycleSpecification, billStructure.cycleSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cycleSpecification);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillStructure {\n");
    
    sb.append("    cycleSpecification: ").append(toIndentedString(cycleSpecification)).append("\n");
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

