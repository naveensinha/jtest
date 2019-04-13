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
 * ResponsePrivacyPreferences
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T13:48:26.690-05:00")
public class ResponsePrivacyPreferences {
  @SerializedName("Prefname")
  private String prefname = null;

  @SerializedName("Default")
  private Boolean _default = null;

  public ResponsePrivacyPreferences prefname(String prefname) {
    this.prefname = prefname;
    return this;
  }

   /**
   * Get prefname
   * @return prefname
  **/
  @ApiModelProperty(value = "")
  public String getPrefname() {
    return prefname;
  }

  public void setPrefname(String prefname) {
    this.prefname = prefname;
  }

  public ResponsePrivacyPreferences _default(Boolean _default) {
    this._default = _default;
    return this;
  }

   /**
   * Get _default
   * @return _default
  **/
  @ApiModelProperty(value = "")
  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsePrivacyPreferences responsePrivacyPreferences = (ResponsePrivacyPreferences) o;
    return Objects.equals(this.prefname, responsePrivacyPreferences.prefname) &&
        Objects.equals(this._default, responsePrivacyPreferences._default);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prefname, _default);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePrivacyPreferences {\n");
    
    sb.append("    prefname: ").append(toIndentedString(prefname)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
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

