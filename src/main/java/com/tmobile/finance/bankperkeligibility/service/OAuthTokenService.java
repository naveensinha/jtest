package com.tmobile.finance.bankperkeligibility.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tmobile.finance.bankperkeligibility.exception.IgnoreEventException;

import om.tmobile.finance.bankperkeligibility.util.MessageCode;



public class OAuthTokenService {
	private static final Logger logger = LoggerFactory.getLogger(OAuthTokenService.class);
	private AuthorizationTokenResponse authorizationToken;
	private RestTemplate restTemplate;
	private long tokenExpiryTime;
	
	static long current = System.currentTimeMillis();
	
	@Value("${auth.url}")
	private String tokenUrl;
	
	@Value("${oauth.userName}")
	private String userName;
	
	@Value("${oauth.password}")
	private String password;

	public OAuthTokenService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	
	}

	
	public AuthorizationTokenResponse getAuthorizationToken() {
		

		if (this.authorizationToken == null) {
			synchronized (this) {
				if (this.authorizationToken == null)
					this.authorizationToken = getAuthorizationTokenFromApigee();
			}

			
		}

		if (isTokenExpired()) {
			this.authorizationToken = getAuthorizationTokenFromApigee();
			this.tokenExpiryTime = calculateTokenExpiryTime();
		
		}

		return this.authorizationToken;
	}
	
	private String getBase64Credentials() {
		String authString = userName + ":" + password;
		byte[] bytesEncoded = Base64.encodeBase64(authString.getBytes());
		logger.info("Token url credentials  -->"+new String(bytesEncoded));
		return new String(bytesEncoded);
	}

	private AuthorizationTokenResponse getAuthorizationTokenFromApigee() {
		ResponseEntity<AuthorizationTokenResponse> response = null;
		HttpEntity entity = new HttpEntity(prepareHeaders());
		try {
			logger.info("Token url  -->"+tokenUrl);
			response = restTemplate.exchange(tokenUrl, HttpMethod.GET, entity, AuthorizationTokenResponse.class);
			HttpStatus statusCode = response.getStatusCode();
			
			if (statusCode.is2xxSuccessful()) {
				AuthorizationTokenResponse authToken = response.getBody();
			
				return authToken;
			} else {
				String reasonPhrase = statusCode.getReasonPhrase();
				String message = "Unable to retrieve the token, from Authorization Server: Response status code: "
						+ statusCode + " reasonPhrase: " + reasonPhrase + " url: " + tokenUrl;
			
				throw new IgnoreEventException(MessageCode.PROCESSING_FAILED,message);
			}

		} catch (Exception e) {
			String message = "Unable to retrieve the token, from Authorization Server: ";
			message = (e != null) ? message + " Message: " + e.getMessage() : message;
			
			throw new IgnoreEventException(MessageCode.PROCESSING_FAILED, message);
		}
	}

	private HttpHeaders prepareHeaders() {
		String authStringEnc = getBase64Credentials(); 
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "Basic " + authStringEnc);
		List<MediaType> mediaType = new ArrayList<>();
		mediaType.add(MediaType.APPLICATION_JSON);
		httpHeaders.setAccept(mediaType);
		return httpHeaders;
	}

	private boolean isTokenExpired() {
		if (System.currentTimeMillis() >= this.tokenExpiryTime)
			return true;
		
		return false;
	}

	private long calculateTokenExpiryTime() {
		return (Long.parseLong(this.authorizationToken.getIssuedAt())
				+ (Long.parseLong(this.authorizationToken.getExpiresIn()) * 1000) - (300 * 1000));
	}
}
