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
import java.util.ArrayList;
import java.util.List;

/**
 * only one of the following attributes is allowed in the request, sending more than one array will result in a 400 bad request.
 */
@ApiModel(description = "only one of the following attributes is allowed in the request, sending more than one array will result in a 400 bad request.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-08T11:56:47.701-05:00")
public class BillingAccountLookupRequest {
  @SerializedName("financialAccountNumbersList")
  private List<String> financialAccountNumbersList = null;

  @SerializedName("hierarchyIds")
  private List<String> hierarchyIds = null;

  public BillingAccountLookupRequest financialAccountNumbersList(List<String> financialAccountNumbersList) {
    this.financialAccountNumbersList = financialAccountNumbersList;
    return this;
  }

  public BillingAccountLookupRequest addFinancialAccountNumbersListItem(String financialAccountNumbersListItem) {
    if (this.financialAccountNumbersList == null) {
      this.financialAccountNumbersList = new ArrayList<String>();
    }
    this.financialAccountNumbersList.add(financialAccountNumbersListItem);
    return this;
  }

   /**
   * array of financial account numbers.
   * @return financialAccountNumbersList
  **/
  @ApiModelProperty(value = "array of financial account numbers.")
  public List<String> getFinancialAccountNumbersList() {
    return financialAccountNumbersList;
  }

  public void setFinancialAccountNumbersList(List<String> financialAccountNumbersList) {
    this.financialAccountNumbersList = financialAccountNumbersList;
  }

  public BillingAccountLookupRequest hierarchyIds(List<String> hierarchyIds) {
    this.hierarchyIds = hierarchyIds;
    return this;
  }

  public BillingAccountLookupRequest addHierarchyIdsItem(String hierarchyIdsItem) {
    if (this.hierarchyIds == null) {
      this.hierarchyIds = new ArrayList<String>();
    }
    this.hierarchyIds.add(hierarchyIdsItem);
    return this;
  }

   /**
   * array of hierarchyId.
   * @return hierarchyIds
  **/
  @ApiModelProperty(value = "array of hierarchyId.")
  public List<String> getHierarchyIds() {
    return hierarchyIds;
  }

  public void setHierarchyIds(List<String> hierarchyIds) {
    this.hierarchyIds = hierarchyIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingAccountLookupRequest billingAccountLookupRequest = (BillingAccountLookupRequest) o;
    return Objects.equals(this.financialAccountNumbersList, billingAccountLookupRequest.financialAccountNumbersList) &&
        Objects.equals(this.hierarchyIds, billingAccountLookupRequest.hierarchyIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(financialAccountNumbersList, hierarchyIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingAccountLookupRequest {\n");
    
    sb.append("    financialAccountNumbersList: ").append(toIndentedString(financialAccountNumbersList)).append("\n");
    sb.append("    hierarchyIds: ").append(toIndentedString(hierarchyIds)).append("\n");
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

