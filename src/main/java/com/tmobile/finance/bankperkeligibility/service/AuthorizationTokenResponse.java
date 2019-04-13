package com.tmobile.finance.bankperkeligibility.service;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "issued_at", "scope", "expires_in", "token_type", "access_token", "refresh_token_expires_in" })
public class AuthorizationTokenResponse {

	@JsonProperty("issued_at")
	private String issuedAt;
	@JsonProperty("scope")
	private String scope;
	@JsonProperty("expires_in")
	private String expiresIn;
	@JsonProperty("token_type")
	private String tokenType;
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("refresh_token_expires_in")
	private String refreshTokenExpiresIn;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("issued_at")
	public String getIssuedAt() {
		return issuedAt;
	}

	@JsonProperty("issued_at")
	public void setIssuedAt(String issuedAt) {
		this.issuedAt = issuedAt;
	}

	@JsonProperty("scope")
	public String getScope() {
		return scope;
	}

	@JsonProperty("scope")
	public void setScope(String scope) {
		this.scope = scope;
	}

	@JsonProperty("expires_in")
	public String getExpiresIn() {
		return expiresIn;
	}

	@JsonProperty("expires_in")
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	@JsonProperty("token_type")
	public String getTokenType() {
		return tokenType;
	}

	@JsonProperty("token_type")
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@JsonProperty("refresh_token_expires_in")
	public String getRefreshTokenExpiresIn() {
		return refreshTokenExpiresIn;
	}

	@JsonProperty("refresh_token_expires_in")
	public void setRefreshTokenExpiresIn(String refreshTokenExpiresIn) {
		this.refreshTokenExpiresIn = refreshTokenExpiresIn;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
