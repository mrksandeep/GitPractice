package com.QA.TestApp.Testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.http.Method;
import io.restassured.internal.util.IOUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.QA.TestApp.Utilities.BaseScript;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public  class SSO_Smoke_API extends BaseScript

{
	String baseUriAuth = null;
	String baseUriToken =null;
	String h_clientId = null;
	String h_secretKey = null;
	String code_challenge = null;
	String countryCode = null;
	String mobileNumber = null;
	String password = null;
	String refId = null;
	
	

	@Test
	public void checkPhone() throws Exception  {
		try {
			
			 
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();
			//9
			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			JSONObject json = new JSONObject();
			
			json.put("countryCode","91" );
			json.put("phone",fUtil.fgetDataNew1("MobileNumber"));
			
			request.body(json.toJSONString());
			Response response = request.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody1, 0);
			
			
			
			refId = response.jsonPath().get("refId");
			System.out.println("RefId is: " + refId);
			

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void verifySignupOtp() throws Exception  {
		try {
			
			/*----rfID code -------*/
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_rfId = RestAssured.given();
			//9
			request_rfId.header("Content-Type", "application/json");
			request_rfId.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_rfId.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			
			
            JSONObject json_rfID = new JSONObject();
			
            json_rfID.put("countryCode","91" );
            json_rfID.put("phone",fUtil.fgetDataNew1("MobileNumber"));
			
            request_rfId.body(json_rfID.toJSONString());
			Response response_rfID = request_rfId.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response_rfID.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody1, 0);
			
			
			
			refId = response_rfID.jsonPath().get("refId");
			System.out.println("RefId is: " + refId);
			
			
			
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");

			RequestSpecification request_signupOtp = RestAssured.given();
			//9
			request_signupOtp.header("Content-Type", "application/json");
			request_signupOtp.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_signupOtp.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			JSONObject json = new JSONObject();
			
			json.put("countryCode","91" );
			json.put("mobileNumber",fUtil.fgetDataNew1("MobileNumber"));
			json.put("otp","123456");
			json.put("refId",refId);
			
			request_signupOtp.body(json.toJSONString());
			System.out.println("Request Body is: " + json.toJSONString());
			
			Response response = request_signupOtp.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody, 0);
			
			
			
			String enrolment_Stage = response.jsonPath().get("enrolmentStage");
			System.out.println("CustomerHash:" + enrolment_Stage);
			
			if (enrolment_Stage.contains("OTP_VERIFIED")) {
				fUtil.flogResult("Passed", "OTP Validation", "OTP validation successful with msg  " + enrolment_Stage, 0);
			}else {
				
				fUtil.flogResult("Failed", "OTP Validation", "OTP validation failed with msg  ", 0);
			}

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}

	@Test
	public void userEnrollment() throws Exception  {
		try {
			
			//CHECK PHONE
			RestAssured.baseURI = fUtil.fgetDataNew1("BaseUriAuth");

			RequestSpecification request_rfId = RestAssured.given();
			//9
			request_rfId.header("Content-Type", "application/json");
			request_rfId.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_rfId.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			
			
            JSONObject json_rfID = new JSONObject();
			
            json_rfID.put("countryCode","91" );
            json_rfID.put("phone",fUtil.fgetDataNew1("MobileNumber"));
			
            request_rfId.body(json_rfID.toJSONString());
			Response response_rfID = request_rfId.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response_rfID.getBody().asString();
			System.out.println("Response Body for Check Phone is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body Check Phone ",
					"Response is :  " + responseBody1, 0);
			
			
			
			refId = response_rfID.jsonPath().get("refId");
			System.out.println("RefId is: " + refId);
			
			
			//Verify SignUp OTP
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");

			RequestSpecification request_signupOtp = RestAssured.given();
			
			request_signupOtp.header("Content-Type", "application/json");
			request_signupOtp.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_signupOtp.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			JSONObject json = new JSONObject();
			
			json.put("countryCode","91" );
			json.put("mobileNumber",fUtil.fgetDataNew1("MobileNumber"));
			json.put("otp","123456");
			json.put("refId",refId);
			
			request_signupOtp.body(json.toJSONString());
			System.out.println("Request Body is: " + json.toJSONString());
			
			Response response = request_signupOtp.post();
			
			
            Cookies cookie_verifyOtp = response.detailedCookies();
            
            String cookie = cookie_verifyOtp.toString();
            
            System.out.println("Cokies value is : "+cookie);
            
            //String s1="java string; split method by javatpoint";
            String[] cookieSession=cookie.split(";");
            System.out.println(cookieSession[0]);
            
            
			
		
			System.out.println("----Getting Response Body -----" );
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body for Verify SignUp OTP",
					"Response is :  " + responseBody, 0);
			
			
			
			String enrolment_Stage = response.jsonPath().get("enrolmentStage");
			System.out.println("CustomerHash:" + enrolment_Stage);
			
			if (enrolment_Stage.contains("OTP_VERIFIED")) {
				fUtil.flogResult("Passed", "OTP Validation", "OTP validation successful with msg  " + enrolment_Stage, 0);
			}else {
				
				fUtil.flogResult("Failed", "OTP Validation", "OTP validation failed with msg  ", 0);
			}
			
			


			//SET Password
			
			 
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_pswd = RestAssured.given();
			
			request_pswd.header("Content-Type", "application/json");
			//request_pswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
		//	request_pswd.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request_pswd.header("client_id", "TCP-WEB-APP");
			request_pswd.header("client_secret", "c2632ea1-27be-44ac-a6c8-5f6335048003");
			request_pswd.header("Cookie",cookieSession[0]);
			
			JSONObject json_pswd = new JSONObject();
			
			json_pswd.put("password",fUtil.fgetDataNew1("Password"));
			json_pswd.put("confirmPassword",fUtil.fgetDataNew1("Password"));
			
			System.out.println("Request Body is: " + json_pswd.toJSONString());
			
			request_pswd.body(json_pswd.toJSONString());
			
			
			Response response_pswd = request_pswd.post();
			
			Cookies cookie_value3 = response_pswd.detailedCookies();
			
			
			
		
			
			System.out.println("Cokies"+cookie_value3);
			
			System.out.println("----Getting Response Body -----" );
			
			String responseBody_pswd = response_pswd.getBody().asString();
			
			System.out.println("Response Body is:" + responseBody_pswd);
			fUtil.flogResult("Passed", "Generation of response body SET Password",
					"Response is :  " + responseBody_pswd, 0);
			
			

			int statusCode_setPswd = response_pswd.getStatusCode();
			System.out.println("Status code is: " + statusCode_setPswd);
			if (statusCode_setPswd == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for SET Password", "Status Code is " + statusCode_setPswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for SET Password",
						"Expected Status Code is 200 but it is " + statusCode_setPswd, 0);
			}

			String statusLine_setPswd = response_pswd.getStatusLine();
			System.out.println("Status line for SET Password is:" + statusLine_setPswd);
			if (statusLine_setPswd.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for SET Password", "Status Line is " + statusLine_setPswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for SET Password",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_setPswd, 0);
			}
			
			
			//Update Password
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI3");

			RequestSpecification request_Updatepswd = RestAssured.given();
			//9
			request_Updatepswd.header("Content-Type", "application/json");
			request_Updatepswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_Updatepswd.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request_Updatepswd.header("Cookie",cookieSession[0]);
			 
			
			JSONObject json_Updatepswd = new JSONObject();
			
			json_Updatepswd.put("oldPassword",fUtil.fgetDataNew1("Password"));
			json_Updatepswd.put("newPassword",fUtil.fgetDataNew1("Password2"));
			json_Updatepswd.put("confirmNewPassword",fUtil.fgetDataNew1("Password2"));
			
			System.out.println("Request Body is: " + json_Updatepswd.toJSONString());
			
			request_Updatepswd.body(json_Updatepswd.toJSONString());
			
			Response response_Updatepswd = request_Updatepswd.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody_Updatepswd = response_Updatepswd.getBody().asString();
			System.out.println("Response Body is:" + responseBody_Updatepswd);
			fUtil.flogResult("Passed", "Generation of response body for Update Password ",
					"Response is :  " + responseBody_Updatepswd, 0);
			
			

			int statusCode_Updatepswd = response_Updatepswd.getStatusCode();
			System.out.println("Status code is: " + statusCode_Updatepswd);
			if (statusCode_Updatepswd == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for Update Password", "Status Code is " + statusCode_Updatepswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for Update Password",
						"Expected Status Code is 200 but it is " + statusCode_Updatepswd, 0);
			}

			String statusLine_Updatepswd = response_Updatepswd.getStatusLine();
			System.out.println("Status line is:" + statusLine_Updatepswd);
			if (statusLine_Updatepswd.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for Upadte Password", "Status Line is " + statusLine_Updatepswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for Upadte Password",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_Updatepswd, 0);
			}

			
			
			
			//User Profile
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI4");

			RequestSpecification request_user = RestAssured.given();
			//9
			request_user.header("Content-Type", "application/json");
			request_user.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_user.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request_user.header("Cookie",cookieSession[0]);
			 
			
			JSONObject json_user = new JSONObject();
			/*
			json.put("creationType","LocalAccount");
			json.put("firstName",fUtil.fgetDataNew1("FirstName"));
			json.put("lastName",fUtil.fgetDataNew1("LastName"));
			json.put("dob",fUtil.fgetDataNew1("DOB"));
			json.put("gender",fUtil.fgetDataNew1("Gender"));
			json.put("email",fUtil.fgetDataNew1("Email"));
			json.put("tcpConsent","true");
			json.put("marketingConsent","true");
			json.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			
			*/
			
			json_user.put("creationType","LocalAccount");
			json_user.put("firstName",fUtil.fgetDataNew1("FirstName"));
			json_user.put("lastName",fUtil.fgetDataNew1("LastName"));
			json_user.put("dob",fUtil.fgetDataNew1("DOB"));
			json_user.put("gender",fUtil.fgetDataNew1("Gender"));
			json_user.put("email",fUtil.fgetDataNew1("Email"));
			json_user.put("tcpConsent","true");
			json_user.put("marketingConsent","true");
			//json_user.put("referralCode",null);
			json_user.put("redirectUrl","https%3A%2F%2Fsit.tatadigital.com%2Flogin-callback%3F");
			json_user.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			
			request_user.body(json_user.toJSONString());
			Response response_user = request_user.put();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody_user = response_user.getBody().asString();
			System.out.println("Response Body is:" + responseBody_user);
			fUtil.flogResult("Passed", "Generation of response body for User Profile",
					"Response is :  " + responseBody_user, 0);
			
			

			int statusCode_user = response_user.getStatusCode();
			System.out.println("Status code is: " + statusCode_user);
			if (statusCode_user == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for User Profile", "Status Code is " + statusCode_user, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for User Profile",
						"Expected Status Code is 200 but it is " + statusCode_user, 0);
			}

			String statusLine_user = response_user.getStatusLine();
			System.out.println("Status line is:" + statusLine_user);
			if (statusLine_user.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for User Profile", "Status Line is " + statusLine_user, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for User Profile",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_user, 0);
			}

			
			

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	@Test
	public void user() throws Exception  {
		try {
			
			 
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_user = RestAssured.given();
			//9
			request_user.header("Content-Type", "application/json");
			request_user.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_user.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			 
			
			JSONObject json_user = new JSONObject();
			/*
			json.put("creationType","LocalAccount");
			json.put("firstName",fUtil.fgetDataNew1("FirstName"));
			json.put("lastName",fUtil.fgetDataNew1("LastName"));
			json.put("dob",fUtil.fgetDataNew1("DOB"));
			json.put("gender",fUtil.fgetDataNew1("Gender"));
			json.put("email",fUtil.fgetDataNew1("Email"));
			json.put("tcpConsent","true");
			json.put("marketingConsent","true");
			json.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			*/
			
			
			json_user.put("creationType","LocalAccount");
			json_user.put("firstName","FirstName");
			json_user.put("lastName","LastName");
			json_user.put("dob","1990-07-14");
			json_user.put("gender","male");
			json_user.put("email","test012@sso.com");
			json_user.put("tcpConsent","true");
			json_user.put("marketingConsent","true");
			json_user.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			
			request_user.body(json_user.toJSONString());
			Response response = request_user.put();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody1, 0);
			
			

			int statusCode_user = response.getStatusCode();
			System.out.println("Status code is: " + statusCode_user);
			if (statusCode_user == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode_user, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode_user, 0);
			}

			String statusLine_user = response.getStatusLine();
			System.out.println("Status line is:" + statusLine_user);
			if (statusLine_user.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine_user, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_user, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void loginAndAccessToken() throws Exception {
		try {
			
			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
            String auth_Code="";
            
			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();
			
			request.header("Content-Type", "application/json");
			//request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			//request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request.header("client_id", "TCP-WEB-APP");
			request.header("client_secret","c2632ea1-27be-44ac-a6c8-5f6335048003");
			
			JSONObject json = new JSONObject();
			json.put("countryCode","91");
			json.put("phone",fUtil.fgetDataNew1("MobileNumber"));
			json.put("password",fUtil.fgetDataNew1("Password"));
			json.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			
			System.out.println("Response Body is:" + json.toJSONString());
			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			
			fUtil.flogResult("Passed", "Generation of response body for Authcode Generation",
					"Response is :  " + responseBody, 0);
			
			auth_Code = response.jsonPath().get("authCode");
			System.out.println("AuthCode is : "+auth_Code);
			
			
			
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code Authcode Generation", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line Authcode Generation", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line Authcode Generation",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}


			
			
			String baseUri_accessToken = baseUriToken+"/"+auth_Code;
			System.out.println("baseUri_accessToken is : "+baseUri_accessToken);
			
			/*====================================Access Token Generation ============================================*/
			RestAssured.baseURI = baseUri_accessToken ;
			
            RequestSpecification requestToken = RestAssured.given();
			
            requestToken.header("Content-Type", "application/json");
            requestToken.header("client_id", fUtil.fgetDataNew1("ClientId"));
            requestToken.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", "Superman");
			
			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();

			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);
			fUtil.flogResult("Passed", "Generation of response body for Access Token Generation",
					"Response is :  " + responseBodyToken, 0);
			
			String accessToken = responseToken.jsonPath().get("accessToken");
			
			System.out.println("Access token  is : " + accessToken);

			int statusCodeAccessToken = responseToken.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCodeAccessToken == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for Access Token Generation ", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code Access Token Generation",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLineAccessToken = responseToken.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLineAccessToken.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for Access Token Generation", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for Access Token Generation",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Access Token Generation",
					"API Response for Access Token Generation Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void refresToken() throws Exception  {
		try {
			
			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			 baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
			 h_clientId= fUtil.fgetDataNew1("ClientId");
			 h_secretKey= fUtil.fgetDataNew1("Clientsecret");
			 code_challenge= fUtil.fgetDataNew1("Code_challenge");
			 countryCode ="91";
			 mobileNumber= fUtil.fgetDataNew1("MobileNumber");
			 password= fUtil.fgetDataNew1("Password");
			
			String refreshToken1 = gmethods.generateRefreshToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey, code_challenge, countryCode, mobileNumber, password);
           
			
			
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();
			//9
			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request.header("Authorization", "Basic dGNwYXBwOnRjcDEyMw==");
			
			 
			
			JSONObject json = new JSONObject();
			
			json.put("refreshToken",refreshToken1);
			
			request.body(json.toJSONString());
			Response response = request.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody, 0);
			
			

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			
			
            // Response Body Validation
			String token_type = response.jsonPath().getString("token_type");
			
			System.out.println("Status:" + token_type);

			if (token_type.contains("bearer")) {
				fUtil.flogResult("Passed", "Validate Response ", "Validated successfully with token as " + token_type, 0);
			} else {
				fUtil.flogResult("Failed", "Validation failed ", "Expected token type bearer but it is " + token_type, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void validateToken() throws Exception  {
		try {
			
			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			 baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
			 h_clientId= fUtil.fgetDataNew1("ClientId");
			 h_secretKey= fUtil.fgetDataNew1("Clientsecret");
			 code_challenge= fUtil.fgetDataNew1("Code_challenge");
			 countryCode ="91";
			 mobileNumber= fUtil.fgetDataNew1("MobileNumber");
			 password= fUtil.fgetDataNew1("Password");
			
			//String refreshToken1 = gmethods.generateRefreshToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey, code_challenge, countryCode, mobileNumber, password);
			String bearerToken = gmethods.generateAccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey, code_challenge, countryCode, mobileNumber, password);
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");

			RequestSpecification request = RestAssured.given();
			//9
			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			//request.header("Authorization", "Basic dGNwYXBwOnRjcDEyMw==");
			request.header("Authorization", bearerToken);
			
			 
			/*
			 * JSONObject json = new JSONObject();
			 * 
			 * json.put("refreshToken",refreshToken1);
			 */
			
			//request.body(json.toJSONString());
			Response response = request.get();
			
			
			System.out.println("----Getting Response Body -----" );
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody, 0);
			
			

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			
			
			// Response Body Validation
            String status_token = response.jsonPath().getString("success");
			
			System.out.println("Status:" + status_token);

			if (status_token.contains("Valid access token")) {
				fUtil.flogResult("Passed", "Validate Response ", "Validated successfully  " + status_token, 0);
			} else {
				fUtil.flogResult("Failed", "Validation failed ", "Expected Status code is \"Valid access token\" but it is " + status_token, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}	
	
	@Test
	public void checkSession() throws Exception  {
		try {
			
			 
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();
			//9
			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			JSONObject json = new JSONObject();
			
			json.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			
			
			request.body(json.toJSONString());
			Response response = request.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody1, 0);
			
			
			
			refId = response.jsonPath().get("refId");
			System.out.println("RefId is: " + refId);
			

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	@Test
	public void updatePassword() throws Exception  {
		try {
		
			 
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_Updatepswd = RestAssured.given();
			//9
			request_Updatepswd.header("Content-Type", "application/json");
			request_Updatepswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_Updatepswd.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			 
			
			JSONObject json_Updatepswd = new JSONObject();
			
			json_Updatepswd.put("oldPassword",fUtil.fgetDataNew1("Password"));
			json_Updatepswd.put("newPassword",fUtil.fgetDataNew1("Password2"));
			json_Updatepswd.put("confirmNewPassword",fUtil.fgetDataNew1("Password2"));
			
			request_Updatepswd.body(json_Updatepswd.toJSONString());
			
			Response response_Updatepswd = request_Updatepswd.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody_Updatepswd = response_Updatepswd.getBody().asString();
			System.out.println("Response Body is:" + responseBody_Updatepswd);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody_Updatepswd, 0);
			
			

			int statusCode_Updatepswd = response_Updatepswd.getStatusCode();
			System.out.println("Status code is: " + statusCode_Updatepswd);
			if (statusCode_Updatepswd == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode_Updatepswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode_Updatepswd, 0);
			}

			String statusLine_Updatepswd = response_Updatepswd.getStatusLine();
			System.out.println("Status line is:" + statusLine_Updatepswd);
			if (statusLine_Updatepswd.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine_Updatepswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_Updatepswd, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void sendAndVerifyForgotPswdOtp() throws Exception  {
		try {
			
			/*----rfID code -------*/
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_rfId = RestAssured.given();
			//9
			request_rfId.header("Content-Type", "application/json");
			request_rfId.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_rfId.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			
			
            JSONObject json_rfID = new JSONObject();
			
            json_rfID.put("countryCode","91" );
            json_rfID.put("phone",fUtil.fgetDataNew1("MobileNumber"));
			
            request_rfId.body(json_rfID.toJSONString());
			Response response_rfID = request_rfId.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response_rfID.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody1, 0);
			
			
			
			refId = response_rfID.jsonPath().get("refId");
			System.out.println("RefId is: " + refId);
			
			
			
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");

			RequestSpecification request_signupOtp = RestAssured.given();
			//9
			request_signupOtp.header("Content-Type", "application/json");
			request_signupOtp.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_signupOtp.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			JSONObject json = new JSONObject();
			
			json.put("countryCode","91" );
			json.put("mobileNumber",fUtil.fgetDataNew1("MobileNumber"));
			json.put("otp","123456");
			json.put("refId",refId);
			
			request_signupOtp.body(json.toJSONString());
			System.out.println("Request Body is: " + json.toJSONString());
			
			Response response = request_signupOtp.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody, 0);
			
			
			
			String success = response.jsonPath().get("Success");
			System.out.println("CustomerHash:" + success);
			
			if (success.contains("OTP verfication successful")) {
				fUtil.flogResult("Passed", "OTP Validation", "OTP validation successful with msg  " + success, 0);
			}else {
				
				fUtil.flogResult("Failed", "OTP Validation", "OTP validation failed with msg  ", 0);
			}

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void loginPhoneOtp() throws Exception  {
		try {
			
			 
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();
			//9
			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			JSONObject json = new JSONObject();
			
			json.put("countryCode","91" );
			json.put("phone",fUtil.fgetDataNew1("MobileNumber"));
			
			request.body(json.toJSONString());
			Response response = request.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody1, 0);
			
			
			
			refId = response.jsonPath().get("refId");
			System.out.println("RefId is: " + refId);
			

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void fetchCustomer() throws Exception  {
		try {
			
			 
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();
			//9
			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			JSONObject json = new JSONObject();
			
			json.put("countryCode","91" );
			json.put("mobileNumber",fUtil.fgetDataNew1("MobileNumber"));
			
			request.body(json.toJSONString());
			Response response = request.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body  ",
					"Response is :  " + responseBody1, 0);
			
			
			

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void getClient() throws Exception  {
		try {
			
			 
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();
			
			request.header("Content-Type", "application/json");
			//request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			//request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			JSONObject json = new JSONObject();
			
			request.body(json.toJSONString());
			Response response = request.get();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body  ",
					"Response is :  " + responseBody1, 0);
			
			
			

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void generateAndVerifyTempToken() throws Exception  {
		try {
			
			/*----rfID code -------*/
			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			 baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
			 h_clientId= fUtil.fgetDataNew1("ClientId");
			 h_secretKey= fUtil.fgetDataNew1("Clientsecret");
			 code_challenge= fUtil.fgetDataNew1("Code_challenge");
			 countryCode ="91";
			 mobileNumber= fUtil.fgetDataNew1("MobileNumber");
			 password= fUtil.fgetDataNew1("Password");
			
			String bearerToken = gmethods.generateAccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey, code_challenge, countryCode, mobileNumber, password);

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_rfId = RestAssured.given();
			//9
			request_rfId.header("Content-Type", "application/json");
			request_rfId.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_rfId.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request_rfId.header("Authorization", bearerToken);
			
			
			
			
            JSONObject json_rfID = new JSONObject();
			
            json_rfID.put("redirectClientId",fUtil.fgetDataNew1("ClientId"));
            json_rfID.put("redirectClientUrl","http://google.com");
			
            request_rfId.body(json_rfID.toJSONString());
			Response response_rfID = request_rfId.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody1 = response_rfID.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody1, 0);
			
			
			
			String tempToken = response_rfID.jsonPath().get("tempToken");
			System.out.println("TempToken is: " + tempToken);
			
			
			
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");

			RequestSpecification request_verifyToken = RestAssured.given();
			//9
			request_verifyToken.header("Content-Type", "application/json");
			request_verifyToken.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_verifyToken.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			JSONObject json = new JSONObject();
			
			json.put("tempToken",tempToken );
			json.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			
			
			request_verifyToken.body(json.toJSONString());
			System.out.println("Request Body is: " + json.toJSONString());
			
			Response response = request_verifyToken.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody, 0);
			
			
			
			String success = response.jsonPath().get("success");
			System.out.println("Success message is:" + success);
			
			if (success.contains("Token validation successful")) {
				fUtil.flogResult("Passed", "Token Validation", "Token validation successful with msg  " + success, 0);
			}else {
				
				fUtil.flogResult("Failed", "Token Validation", "Token validation failed with msg  ", 0);
			}

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void createSession() throws Exception  {
		try {
			
			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
            String auth_Code="";
            
			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();
			
			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			JSONObject json = new JSONObject();
			json.put("countryCode","91");
			json.put("phone",fUtil.fgetDataNew1("MobileNumber"));
			json.put("password",fUtil.fgetDataNew1("Password"));
			json.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			
			
			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			
			auth_Code = response.jsonPath().get("authCode");
			System.out.println("AuthCode is : "+auth_Code);
			
			
			
			String baseUri_accessToken = baseUriToken+"/"+auth_Code;
			System.out.println("baseUri_accessToken is : "+baseUri_accessToken);
			
			/*====================================Access Token Generation ============================================*/
			RestAssured.baseURI = baseUri_accessToken ;
			
            RequestSpecification requestToken = RestAssured.given();
			
            requestToken.header("Content-Type", "application/json");
            requestToken.header("client_id", fUtil.fgetDataNew1("ClientId"));
            requestToken.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", "Superman");
			
			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();

			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);
			
			String accessTokn = responseToken.jsonPath().get("accessToken");
			String refreshTokn = responseToken.jsonPath().get("refreshToken");
			
			System.out.println("Access token  is : " + accessTokn);
			System.out.println("Refresh token  is : " + refreshTokn);

			
			
			/* Create Session  */
			
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_s = RestAssured.given();
			//9
			request_s.header("Content-Type", "application/json");
			request_s.header("client_id", fUtil.fgetDataNew1("ClientId"));
			//request_s.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			
			
			
			
            JSONObject json_s= new JSONObject();
			
            json_s.put("accessToken",accessTokn);
            json_s.put("refreshToken",refreshTokn);
            json_s.put("clientId", fUtil.fgetDataNew1("ClientId"));
            
            System.out.println("JSON is generated --" +json_s.toJSONString());
			
            request_s.body(json_s.toJSONString());
			Response response_s = request_s.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody2 = response_s.getBody().asString();
			System.out.println("Response Body is:" + responseBody2);
			fUtil.flogResult("Passed", "Generation of response body ",
					"Response is :  " + responseBody2, 0);
			
			
			
			
		    String success = response_s.jsonPath().get("success");
			System.out.println("Success message is:" + success);
			
			if (success.contains("Token Generated")) {
				fUtil.flogResult("Passed", "Token Validation", "Token validation successful with msg  " + success, 0);
			}else {
				
				fUtil.flogResult("Failed", "Token Validation", "Token validation failed ", 0);
			}

			int statusCode = response_s.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response_s.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	@Test
	public void signOut() throws Exception  {
		try {
		    //SignIn
			
			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
            String auth_Code="";
            
			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();
			
			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			JSONObject json = new JSONObject();
			json.put("countryCode","91");
			json.put("phone",fUtil.fgetDataNew1("MobileNumber"));
			json.put("password",fUtil.fgetDataNew1("Password"));
			json.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			
			
			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			
			fUtil.flogResult("Passed", "Generation of response body for SignIn",
					"Response is :  " + responseBody, 0);
			
			auth_Code = response.jsonPath().get("authCode");
			System.out.println("AuthCode is : "+auth_Code);
			
			
			
			
            String baseUri_accessToken = baseUriToken+"/"+auth_Code;
			System.out.println("baseUri_accessToken is : "+baseUri_accessToken);
			
			/*====================================Access Token Generation ============================================*/
			RestAssured.baseURI = baseUri_accessToken ;
			
            RequestSpecification requestToken = RestAssured.given();
			
            requestToken.header("Content-Type", "application/json");
            requestToken.header("client_id", fUtil.fgetDataNew1("ClientId"));
            requestToken.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			
			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", "Superman");
			
			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();
			
			

            Cookies cookie_Login = response.detailedCookies();
            
            String cookie = cookie_Login.toString();
            
            System.out.println("Cokies value is : "+cookie);
            
            String[] cookieSession=cookie.split(";");
            System.out.println(cookieSession[0]);

			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);
			fUtil.flogResult("Passed", "Generation of response body for Access Token Generation",
					"Response is :  " + responseBodyToken, 0);
			
			String accessToken = responseToken.jsonPath().get("accessToken");
			
			System.out.println("Access token  is : " + accessToken);
			
			String tokenType = "Bearer";
			String bearerToken = tokenType + " " + accessToken;
			
			
			//SignOut
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_SignOut = RestAssured.given();
			//9
			request_SignOut.header("Content-Type", "application/json");
			request_SignOut.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_SignOut.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request_SignOut.header("Authorization", bearerToken);
			request_SignOut.header("Cookie",cookieSession[0]);
			 
			
			//JSONObject json_SignOut = new JSONObject();
			
			
			//request_SignOut.body(json_SignOut.toJSONString());
			
			Response response_SignOut = request_SignOut.post();
			
			System.out.println("----Getting Response Body -----" );
			String responseBody_SignOut = response_SignOut.getBody().asString();
			System.out.println("Response Body is:" + responseBody_SignOut);
			fUtil.flogResult("Passed", "Generation of response body for SignOut",
					"Response is :  " + responseBody_SignOut, 0);
			
			

			int statusCode_SignOut= response_SignOut.getStatusCode();
			System.out.println("Status code is: " + statusCode_SignOut);
			if (statusCode_SignOut == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for SignOut", "Status Code for SignOut is " + statusCode_SignOut, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for SignOut",
						"Expected Status Code for SignOut is 200 but it is " + statusCode_SignOut, 0);
			}

			String statusLine_SignOut = response_SignOut.getStatusLine();
			System.out.println("Status line is:" + statusLine_SignOut);
			if (statusLine_SignOut.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for SignOut", "Status Line is " + statusLine_SignOut, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for SignOut",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_SignOut, 0);
			}

			
					
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
public  List<String> generateAccessTokenRefreshToken(String baseUriAuth,String baseUriToken,String h_clientId,String h_secretKey, String code_challenge,String countryCode,String mobileNumber,String password) throws Exception {
		
		String bearerToken="";
		String accessToken="";
		String refreshToken="";
	
		try {
			
			/*============================================ AuthCode Generation=========================================== */			
			String auth_Code="";
            
			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();
			
			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);
			request.header("client_secret", h_secretKey);
			
			JSONObject json = new JSONObject();
			json.put("countryCode", countryCode);
			json.put("phone", mobileNumber);
			json.put("password",password);
			json.put("codeChallenge",code_challenge);
			
			
			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			
			auth_Code = response.jsonPath().get("authCode");
			System.out.println("AuthCode is : "+auth_Code);
			
			String baseUri_accessToken = baseUriToken+"/"+auth_Code;
			System.out.println("baseUri_accessToken is : "+baseUri_accessToken);
			
			/*====================================Access Token Generation ============================================*/
			RestAssured.baseURI = baseUri_accessToken ;
			
            RequestSpecification requestToken = RestAssured.given();
			
            requestToken.header("Content-Type", "application/json");
            requestToken.header("client_id", h_clientId);
            requestToken.header("client_secret", h_secretKey);
			
			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", "Superman");
			
			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();

			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);
			
			 accessToken = responseToken.jsonPath().get("accessToken");
			
			System.out.println("Access token  is : " + accessToken);
			
			 refreshToken = responseToken.jsonPath().get("refreshToken");
			System.out.println("Access token  is : " + refreshToken);
			
			
			//JsonPath path = response.jsonPath();
			//String tokenKey = path.getString("token");
			String tokenType = "Bearer";
			bearerToken = tokenType + " " + accessToken;
			
			
		} catch (Exception ee) {
			System.out.println("Failed and the message is : "+ee.getMessage());
			}
		return Arrays.asList(bearerToken,accessToken,refreshToken);
		
	}





	

} 