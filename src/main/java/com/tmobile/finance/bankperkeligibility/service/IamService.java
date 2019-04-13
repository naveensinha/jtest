package com.tmobile.finance.bankperkeligibility.service;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tmobile.finance.bankperkeligibility.exception.CustomException;
import com.tmobile.finance.bankperkeligibility.pojo.IamResponse;
import com.tmobile.finance.bankperkeligibility.rules.EligibilityRulesPredicate;
import com.tmobile.finance.iam.Response;
import com.tmobile.finance.iam.SearchRequest;
import com.tmobile.finance.model.EligibilityRequest;

@Service
public class IamService {
	private static final Logger logger = LoggerFactory.getLogger(IamService.class);
	
	@Value("${iam.url}") 
	private  String iamServiceURL;
	
	@Value("${subscriberType}") 
	private  String subscriberType;
	
	@Autowired
	EligibilityRulesPredicate eligibilityRulesPredicate;
	
	private HttpHeaders createHttpHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      //  headers.add("Authorization", "False");
        return headers;
    }
	
	public List<IamResponse> getIamResponse(EligibilityRequest req) throws CustomException {
		//SSL diable code - remove after adding the certificate.
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
		Response  resp = new Response();
		List<IamResponse> iamResp = new ArrayList<>();
        SSLContext sslContext;
		try {
			sslContext = org.apache.http.ssl.SSLContexts.custom()
			        .loadTrustMaterial(null, acceptingTrustStrategy)
			        //.loadTrustMaterial("", acceptingTrustStrategy)
			        .build();
		

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
		
		CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

		HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        
      //  RestTemplate restTemplate = new RestTemplate();
       RestTemplate restTemplate = new RestTemplate(requestFactory);
      /* String request = "{\n" +
                "    \"searchRequest\": {\n" +
                "        \"objectclass\": \"identityaccessmanagement\",\n" +
                "        \"name\": \"UserId\",\n" +
                "        \"value\": \"U-dc20c182-5e9e-4ac3-9515-d97eb2c6c817\"\n" +
                "    }\n" +
                "}";
        //Response  iamResponse  = restTemplate.postForObject("https://api.nsm.msg.eng.t-mobile.com/cwf/grandCentral-nsmInterface/3/queryiam", request, Response.class);
        String  iamResponse  = restTemplate.postForObject("https://api.nsm.msg.eng.t-mobile.com/cwf/grandCentral-nsmInterface/3/queryiam", request, String.class);
        System.out.println("Iam String rtesponse -->"+iamResponse +"-----");
        
        
		
		System.out.println("Calling IAM service started ..");
		*///Header
		HttpHeaders headers = createHttpHeaders();
		
		//Request
		SearchRequest iamRequest = new SearchRequest();
		iamRequest.setObjectclass("identityaccessmanagement");
		iamRequest.setName("UserId");
		iamRequest.setValue(req.getTmoid());
		
		HttpEntity<SearchRequest> httpEntity =
                new HttpEntity<>(iamRequest, headers);
		
		String  iamResponse = null;
		 iamResponse = restTemplate.exchange
                 (
                 //"http://localhost:8081/cwf/grandCentral-nsmInterface/3/queryiam",
                 iamServiceURL,		 
                 HttpMethod.POST,
                 httpEntity,
                 String.class
                 ).getBody();
		
		 
		 try {
			 logger.info("IAM service response :"+iamResponse);
			 JSONObject jsonObject = new JSONObject(iamResponse);
			 
			 logger.info("Json status "+jsonObject.getJSONObject("Response") .getJSONObject("nsmResponse").getString("status"));
			 if(!jsonObject.getJSONObject("Response") .getJSONObject("nsmResponse").getString("status").equals("Unsuccessful"))
			 {
			 
				 if(jsonObject.getJSONObject("Response").getJSONObject("LinkedLines").has("DefaultLine")) {
						iamResp.add(createIamResponse(
								 jsonObject.getJSONObject("Response").getJSONObject("LinkedLines").getJSONObject("DefaultLine").getString("SubscriberType")
								,jsonObject.getJSONObject("Response").getJSONObject("LinkedLines").getJSONObject("DefaultLine").getString("AccountType")
								,jsonObject.getJSONObject("Response").getJSONObject("LinkedLines").getJSONObject("DefaultLine").getString("msisdn")));
					
				 }
				 
				 if(jsonObject.getJSONObject("Response").getJSONObject("LinkedLines").has("Lines")) {
					 logger.info("Line details ");
					 JSONArray lines =jsonObject.getJSONObject("Response").getJSONObject("LinkedLines").getJSONArray("Lines");
					 for(int index = 0; index < lines.length(); index++) {
							  JSONObject line = lines.getJSONObject(index);
							  iamResp.add(createIamResponse(
									 line.getString("SubscriberType")
									,line.getString("AccountType")
									,line.getString("msisdn")));
						 }
				}
			 }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 //return iamResp;
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("IamService response list --"+iamResp.size());
		return iamResp;
	}
	
	/*@SuppressWarnings("deprecation")
	public  Response jsonToObject(String json, Response respObj ) {
		
		 
		json = "{\r\n" + 
				"        \"nsmResponse\": {\r\n" + 
				"            \"status\": \"successful\",\r\n" + 
				"            \"responseCode\": \"200\",\r\n" + 
				"            \"errormessages\": [\r\n" + 
				"                {\r\n" + 
				"                    \"errorCode\": \"invalid_request\",\r\n" + 
				"                    \"reason\": \"Required parameter user_id is missing.\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"errorCode\": \"invalid_request\",\r\n" + 
				"                    \"reason\": \"Required parameter 'owner_id' is missing.\"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"executionTime\": \"291.0\",\r\n" + 
				"        \"msisdn\": \"4254459515\",\r\n" + 
				"        \"UserId\": \"U-dc20c182-5e9e-4ac3-9515-d97eb2c6c817\",\r\n" + 
				"        \"email\": \"jamesalexanderlatham+2018-11-27@gmail.com\",\r\n" + 
				"        \"TMobileIdentity\": {\r\n" + 
				"            \"AccountDetails\": {\r\n" + 
				"                \"User\": {\r\n" + 
				"                    \"FirstName\": \"TMOIDFirst\",\r\n" + 
				"                    \"LastName\": \"TMOIDLast\",\r\n" + 
				"                    \"AccountCreateDate\": \"02-13-2018 13:39:21\",\r\n" + 
				"                    \"IAMLastEmailUpdate\": \"11-27-2018 18:37:47\"\r\n" + 
				"                },\r\n" + 
				"                \"Authentication\": {\r\n" + 
				"                    \"SuccessCount\": \"10\",\r\n" + 
				"                    \"LastSuccessfulDate\": \"02-05-2019 06:19:08\",\r\n" + 
				"                    \"FailureCount\": \"0\",\r\n" + 
				"                    \"LastfailedDate\": \"02-05-2019 06:19:09\"\r\n" + 
				"                },\r\n" + 
				"                \"Security\": {\r\n" + 
				"                    \"SecurityAnswerCount\": \"3\",\r\n" + 
				"                    \"SecurityAnswerUpdateDate\": \"\"\r\n" + 
				"                },\r\n" + 
				"                \"Passwords\": {\r\n" + 
				"                    \"PasswordResetCount\": \"0\",\r\n" + 
				"                    \"LastPasswordResetDate\": \"02-04-2019 04:51:07\",\r\n" + 
				"                    \"LastPasswordUpdateDate\": \"\"\r\n" + 
				"                },\r\n" + 
				"                \"AccountStatus\": {\r\n" + 
				"                    \"Status\": \"Active\",\r\n" + 
				"                    \"AccountSoftLocked\": false,\r\n" + 
				"                    \"AccountSoftLockedReason\": \"\",\r\n" + 
				"                    \"AccountHardLocked\": false,\r\n" + 
				"                    \"AccountHardLockedReason\": \"\",\r\n" + 
				"                    \"AcccountAdminLocked\": false,\r\n" + 
				"                    \"AcccountAdminLockedReason\": \"\",\r\n" + 
				"                    \"mustChangePasswordFlag\": false,\r\n" + 
				"                    \"mustChangePasswordReason\": \"\"\r\n" + 
				"                },\r\n" + 
				"                \"Access\": {\r\n" + 
				"                    \"access_type\": \"Read-only\"\r\n" + 
				"                },\r\n" + 
				"                \"AvailableLists\": {\r\n" + 
				"                    \"passwordreset\": [\r\n" + 
				"                        \"\"\r\n" + 
				"                    ],\r\n" + 
				"                    \"unlock\": [\r\n" + 
				"                        \"Care\",\r\n" + 
				"                        \"Fraud\"\r\n" + 
				"                    ],\r\n" + 
				"                    \"mustChangePasswordReason\": [\r\n" + 
				"                        \"Care\",\r\n" + 
				"                        \"Fraud\"\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"LinkedLines\": {\r\n" + 
				"            \"DefaultLine\": {\r\n" + 
				"                \"msisdn\": \"4254459515\",\r\n" + 
				"                \"BAN\": \"950608452\",\r\n" + 
				"                \"IMSI\": \"310260408277838\",\r\n" + 
				"                \"Operator\": \"1000\",\r\n" + 
				"                \"CustomerNumber\": \"313145845\",\r\n" + 
				"                \"AccountStatus\": \"Active\",\r\n" + 
				"                \"RegistrationStatus\": \"F\",\r\n" + 
				"                \"LockStatus\": \"ENABLED\",\r\n" + 
				"                \"LockedBy\": \"\",\r\n" + 
				"                \"LockReason\": \"CARE\",\r\n" + 
				"                \"DefaultLine\": true,\r\n" + 
				"                \"FirstName\": \"MOBFirst\",\r\n" + 
				"                \"LastName\": \"MOBLast\",\r\n" + 
				"                \"LineID\": \"Line1\",\r\n" + 
				"                \"AccountType\": \"SY\",\r\n" +
//				"                \"AccountType\": \"BB\",\r\n" +
				"                \"SubscriberType\": \"POSTPAID\",\r\n" +
//				"                \"SubscriberType\": \"prepaid\",\r\n" +
				"                \"GrantMasterPrivileges\": \"true\",\r\n" + 
				"                \"CustomerType\": \"PAH\",\r\n" + 
				"                \"Pincode\": \"\",\r\n" + 
				"                \"SOCList\": \"TRULY-UNLMTD,NACANMEX,B52ROAM,SPP-TETHER-4608MB,CTNBLK\",\r\n" + 
				"                \"ShortCodeBlacklist\": \"\",\r\n" + 
				"                \"ShortCodeBlacklistAll\": \"\",\r\n" + 
				"                \"MDSEnabled\": true,\r\n" + 
				"                \"IBAOptOut\": true,\r\n" + 
				"                \"MWIEnabled\": true,\r\n" + 
				"                \"VoWiFiEnabled\": true,\r\n" + 
				"                \"CommunicationPreference\": \"ES-OPT\"\r\n" + 
				"            },\r\n" + 
				"            \"Access\": {\r\n" + 
				"                \"access_type\": \"Read-only\"\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"BillingAccount\": [\r\n" + 
				"            {\r\n" + 
				"                \"Ban\": \"950608452\",\r\n" + 
				"                \"BillCycleDay\": \"22\",\r\n" + 
				"                \"ZipCode\": \"98052\",\r\n" + 
				"                \"FirstName\": \"JAMES\",\r\n" + 
				"                \"LastName\": \"LATHAM\",\r\n" + 
				"                \"BirthDate\": \"\",\r\n" + 
				"                \"Lines\": [\r\n" + 
				"                    {\r\n" + 
				"                        \"Line\": 1,\r\n" + 
				"                        \"msisdn\": \"2064898965\",\r\n" + 
				"                        \"IMSI\": \"310260399180201\",\r\n" + 
				"                        \"ICCID\": \"8901260393791802015\",\r\n" + 
				"                        \"FirstName\": \"James\",\r\n" + 
				"                        \"CustomerID\": \"322816473\",\r\n" + 
				"                        \"SubscriberType\": \"POSTPAID\",\r\n" + 
				"                        \"CustomerType\": \"NPAH_NP\",\r\n" + 
				"                        \"AccountType\": \"SY\",\r\n" + 
				"                        \"Status\": \"Active\"\r\n" + 
				"                    },\r\n" + 
				"                    {\r\n" + 
				"                        \"Line\": 2,\r\n" + 
				"                        \"msisdn\": \"4254459515\",\r\n" + 
				"                        \"IMSI\": \"310260408277838\",\r\n" + 
				"                        \"ICCID\": \"8901260401782778381\",\r\n" + 
				"                        \"FirstName\": \"MOBFirst\",\r\n" + 
				"                        \"CustomerID\": \"313145845\",\r\n" + 
				"                        \"SubscriberType\": \"POSTPAID\",\r\n" + 
				"                        \"CustomerType\": \"PAH\",\r\n" + 
				"                        \"AccountType\": \"SY\",\r\n" + 
				"                        \"Status\": \"Active\"\r\n" + 
				"                    }\r\n" + 
				"                ],\r\n" + 
				"                \"Access\": {\r\n" + 
				"                    \"access_type\": \"Read-only\"\r\n" + 
				"                }\r\n" + 
				"            }\r\n" + 
				"        ],\r\n" + 
				"        \"Permissions\": {\r\n" + 
				"            \"ImplicitPermissions\": [\r\n" + 
				"                {\r\n" + 
				"                    \"msisdn\": \"4254459515\",\r\n" + 
				"                    \"IMSI\": \"310260408277838\",\r\n" + 
				"                    \"BAN\": \"950608452\",\r\n" + 
				"                    \"IsLineGrantable\": true,\r\n" + 
				"                    \"PermissionType\": \"inherited\",\r\n" + 
				"                    \"IsPrimaryMSISDN\": true,\r\n" + 
				"                    \"AccountStatus\": \"Active\",\r\n" + 
				"                    \"CustomerType\": \"PAH\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"msisdn\": \"4254459515\",\r\n" + 
				"                    \"IMSI\": \"310260408277838\",\r\n" + 
				"                    \"BAN\": \"950608452\",\r\n" + 
				"                    \"IsLineGrantable\": false,\r\n" + 
				"                    \"PermissionType\": \"linked\",\r\n" + 
				"                    \"IsPrimaryMSISDN\": true,\r\n" + 
				"                    \"AccountStatus\": \"Active\",\r\n" + 
				"                    \"CustomerType\": \"PAH\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"msisdn\": \"2064898965\",\r\n" + 
				"                    \"IMSI\": \"310260399180201\",\r\n" + 
				"                    \"BAN\": \"950608452\",\r\n" + 
				"                    \"IsLineGrantable\": true,\r\n" + 
				"                    \"PermissionType\": \"inherited\",\r\n" + 
				"                    \"IsPrimaryMSISDN\": true,\r\n" + 
				"                    \"AccountStatus\": \"Active\",\r\n" + 
				"                    \"CustomerType\": \"NPAH_NP\"\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"Access\": {\r\n" + 
				"                \"access_type\": \"Read-only\"\r\n" + 
				"            },\r\n" + 
				"            \"AvailableLists\": {\r\n" + 
				"                \"permissionset_services\": [\r\n" + 
				"                    \"SMS\",\r\n" + 
				"                    \"VOLTE\"\r\n" + 
				"                ]\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"IAMUniverse\": {\r\n" + 
				"            \"AccountInformation\": [\r\n" + 
				"                {\r\n" + 
				"                    \"AccountDetails\": {\r\n" + 
				"                        \"Language\": \"\",\r\n" + 
				"                        \"FirstName\": \"\",\r\n" + 
				"                        \"LastName\": \"\",\r\n" + 
				"                        \"LastEmailUpdate\": \"\"\r\n" + 
				"                    },\r\n" + 
				"                    \"AccountStatus\": {\r\n" + 
				"                        \"Status\": \"Init\",\r\n" + 
				"                        \"AccountCreateDate\": \"\",\r\n" + 
				"                        \"LockReason\": \"\",\r\n" + 
				"                        \"LockTimestamp\": \"\"\r\n" + 
				"                    },\r\n" + 
				"                    \"PasswordsandSecurity\": {\r\n" + 
				"                        \"LastPasswordUpdateDate\": \"\",\r\n" + 
				"                        \"SecurityAnswerCount\": \"\",\r\n" + 
				"                        \"SecurityAnswerUpdateDate\": \"\"\r\n" + 
				"                    }\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"Customers\": [\r\n" + 
				"                {\r\n" + 
				"                    \"CustomerDetails\": {\r\n" + 
				"                        \"CustomerNumber\": \"C30000708\",\r\n" + 
				"                        \"BusinessUnit\": \"TMO\",\r\n" + 
				"                        \"Status\": \"Active\",\r\n" + 
				"                        \"StatusDate\": \"\",\r\n" + 
				"                        \"AccountCreationDate\": \"\",\r\n" + 
				"                        \"FirstName\": \"MOBFirst\",\r\n" + 
				"                        \"DateofBirth\": \"\",\r\n" + 
				"                        \"Gender\": \"Unknown\"\r\n" + 
				"                    }\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"BillingAccountDetails\": [\r\n" + 
				"                {\r\n" + 
				"                    \"BillingAccountCode\": \"950608452\",\r\n" + 
				"                    \"BusinessLine\": \"TMO\",\r\n" + 
				"                    \"FraudLine\": \"\",\r\n" + 
				"                    \"Status\": \"Active\",\r\n" + 
				"                    \"StatusDate\": \"\",\r\n" + 
				"                    \"BillCycleDay\": \"22\",\r\n" + 
				"                    \"PaymentOptions\": \"POST\",\r\n" + 
				"                    \"PrimaryLine\": \"\",\r\n" + 
				"                    \"Street\": \"\",\r\n" + 
				"                    \"City\": \"\",\r\n" + 
				"                    \"County\": \"\",\r\n" + 
				"                    \"State\": \"\",\r\n" + 
				"                    \"Country\": \"\",\r\n" + 
				"                    \"ZipCode\": \"\",\r\n" + 
				"                    \"Customers\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"Customer\": \"C30000708\",\r\n" + 
				"                            \"Roles\": \"AO\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"Access\": {\r\n" + 
				"                \"access_type\": \"Read-only\"\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"Privacy\": {\r\n" + 
				"            \"OfferDelivery\": [\r\n" + 
				"                {\r\n" + 
				"                    \"MailDelivery\": false,\r\n" + 
				"                    \"SMSDelivery\": false,\r\n" + 
				"                    \"EMailDelivery\": false\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"ContactPreferences\": [\r\n" + 
				"                {\r\n" + 
				"                    \"EmailNewsLetter\": true,\r\n" + 
				"                    \"AnnualEIPDisclosure\": true\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"Offers\": [\r\n" + 
				"                {\r\n" + 
				"                    \"response\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"Offer\": \"Insights\",\r\n" + 
				"                            \"Preferences\": [\r\n" + 
				"                                {\r\n" + 
				"                                    \"Prefname\": \"opt-out\",\r\n" + 
				"                                    \"Default\": false\r\n" + 
				"                                }\r\n" + 
				"                            ]\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"Consents\": {\r\n" + 
				"                \"response\": [\r\n" + 
				"                    {\r\n" + 
				"                        \"Consent\": \"\",\r\n" + 
				"                        \"Description\": \"\",\r\n" + 
				"                        \"IssueTime\": \"\"\r\n" + 
				"                    }\r\n" + 
				"                ]\r\n" + 
				"            },\r\n" + 
				"            \"AssociatedLineAccounts\": {\r\n" + 
				"                \"response\": [\r\n" + 
				"                    {\r\n" + 
				"                        \"LineID\": \"Line1\",\r\n" + 
				"                        \"msisdn\": \"4254459515\",\r\n" + 
				"                        \"InterestBasedAds\": true\r\n" + 
				"                    }\r\n" + 
				"                ]\r\n" + 
				"            },\r\n" + 
				"            \"AvailableLists\": [\r\n" + 
				"                {\r\n" + 
				"                    \"offer_preference\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"offerid\": \"Insights\",\r\n" + 
				"                            \"offer_name\": \"Insights\",\r\n" + 
				"                            \"preference\": [\r\n" + 
				"                                {\r\n" + 
				"                                    \"prefid\": \"29\",\r\n" + 
				"                                    \"prefname\": \"opt-in\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"prefid\": \"30\",\r\n" + 
				"                                    \"prefname\": \"opt-out\"\r\n" + 
				"                                }\r\n" + 
				"                            ]\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"Access\": {\r\n" + 
				"                \"access_type\": \"Read-only\"\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"} \r\n" + 
				"";
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
		 mapper.setPropertyNamingStrategy(new PropertyNamingStrategy.PascalCaseStrategy() {
	            @Override
	            public String nameForGetterMethod(final MapperConfig<?> config, final AnnotatedMethod method, final String defaultName) {
	                final JsonProperty annotation = method.getAnnotation(JsonProperty.class);
	                if (annotation != null) {
	                    return annotation.value();
	                }
	                return super.nameForGetterMethod(config, method, defaultName);
	            }
	        });
		//mapper.setPropertyNamingStrategy(PascalCaseStrategy); 
		
		try {
			respObj = mapper.readValue(json, Response.class);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return respObj;
	}*/
	
	public  boolean isSubscriberTypeValid(IamResponse iamResponse) {
		return (eligibilityRulesPredicate.isSubscriberTypeValid(iamResponse.getSubscriberType().toUpperCase()) );
	}
	
	public  boolean isAccounTypeVaid(IamResponse iamResponse) {
		return (eligibilityRulesPredicate.isAccountTypesubtypesValid(iamResponse.getAccountType().toUpperCase()) );
	
	
	}
	
	public IamResponse createIamResponse(String subscriberType,  String accountType, String msisdn) {
		IamResponse resp = new IamResponse();
		resp.setSubscriberType(subscriberType);
		resp.setAccountType(accountType);
		resp.setMsisdn(msisdn);
		return resp;
	}

	

}
