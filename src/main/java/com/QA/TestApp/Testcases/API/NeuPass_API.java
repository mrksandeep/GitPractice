package com.QA.TestApp.Testcases.API;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.QA.TestApp.Utilities.BaseScript;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NeuPass_API extends BaseScript{

	@Test
	public void fetchBenefits() throws Exception{
		try {
			RestAssured.baseURI="http://tdl-benefits-service.dev-2-tms.tatadigital.com/benefits/v1/fetch-benefit";
			
			RequestSpecification request=RestAssured.given();
			//Header
			request.header("Content-Type", "application/json");
			request.header("limit", "20");
			request.header("pageNo", "0");
			
			//Body
			JSONObject json=new JSONObject();
			ArrayList<String> cusTier = new ArrayList<String>();
			cusTier.add("gold");
			json.put("customerTierName", cusTier);
			ArrayList<String> sub = new ArrayList<String>();
			sub.add("bbStar");
			json.put("customerSubscriptionName", sub);
			ArrayList<String> brand = new ArrayList<String>();
			brand.add("bb");
			json.put("brand", brand);
			ArrayList<String> tier = new ArrayList<String>();
			json.put("tierName", tier);
			json.put("subscriptionName", tier);
			json.put("type", tier);
			json.put("category", tier);
			json.put("unavailableBenefits", false);
			json.put("neupassExclusive", true);
			json.put("sort", "ExpiringSoon");
			
			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+ json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());
			
			//Response
			Response response=request.post();
			String responseBody=response.getBody().asString();
			System.out.println("----Getting Response Body -----" );
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);
			
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
							
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void addMembership() throws Exception{
		try {
			RestAssured.baseURI= fUtil.fgetDataNew1("Base_URI");
			
			RequestSpecification request= RestAssured.given();
			
			/*Header*/
			request.header(fUtil.fgetDataNew1("Header1").split(":")[0], fUtil.fgetDataNew1("Header1").split(":")[1]);
			request.header(fUtil.fgetDataNew1("Header2").split(":")[0], fUtil.fgetDataNew1("Header2").split(":")[1]);
			
			/*Body*/
			String req_body = fUtil.fgetDataNew1("Request");
			JSONParser parser = new JSONParser();  
			JSONObject json = (JSONObject) parser.parse(req_body);  
			
			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+ json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());
			
			/*Response*/
			Response response = request.post();
			
			String responseBody=response.getBody().asString();
			System.out.println("----Getting Response Body -----" );
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);
			
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			int expected_status_code = Integer.parseInt(fUtil.fgetDataNew1("ExpectedCode"));
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == expected_status_code) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
							
			}			
			else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is "+expected_status_code+" but it is " + statusCode, 0);
			}
			
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			
			String resp_error_code = response.jsonPath().get("status.npErrorCode");
			String exp_error_code = fUtil.fgetDataNew1("ExpectedErrorCode");
			if(resp_error_code.contains(exp_error_code))
			{
				fUtil.flogResult("Passed", "Validate the Error Code", "Error Code is " + resp_error_code, 0);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate the Error Code", "Expected Error Code is "+exp_error_code+" but it is " + resp_error_code, 0);
			}
			
			String resp_display_message = response.jsonPath().get("status.displayMessage");
			String exp_display_message = fUtil.fgetDataNew1("ExpectedDisplayMessage");
			if(resp_display_message.contains(exp_display_message))
			{
				fUtil.flogResult("Passed", "Validate the Display Message", "Display Message is " + resp_display_message, 0);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate the Display Message", "Expected Display Message is "+exp_display_message+" but it is " + resp_display_message, 0);
			}
			
			String message=response.jsonPath().get("message");
			System.out.println("Message: "+message);
			
			int value= response.jsonPath().get("statusCode.value");
			String desc= response.jsonPath().get("statusCode.description");
			
			System.out.println("Value: "+value+" Desc: "+desc);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void neuPlanCreate() throws Exception{
		try {
			RestAssured.baseURI="http://tdl-membership-service-new.dev-2-tms.tatadigital.com/membership/v1/neuplan";
			
			RequestSpecification request=RestAssured.given();
			
			/*Header*/
			request.header("Content-Type", "application/json");
			
			/*Body*/
			JSONObject json = new JSONObject();
			json.put("neuPlanId", "5");
			json.put("name", "NeuPass_Affluent");
			json.put("desc", "NeuPass Affluent");
			json.put("price", "100.00");
			json.put("duration", "6");
			ArrayList<String> data = new ArrayList<String>();
			data.add("2");
			data.add("3");
			json.put("membership", data);
			
			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+ json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());
			
			/*Response*/
			Response response= request.post();
			String responseBody=response.getBody().asString();
			System.out.println("----Getting Response Body -----" );
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);
			
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			
			String message=response.jsonPath().get("message");
			System.out.println("Message: "+message);
			
			int value= response.jsonPath().get("statusCode.value");
			String desc= response.jsonPath().get("statusCode.description");
			
			System.out.println("Value: "+value+" Desc: "+desc);
			
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				if(value==200 && desc.equals("OK"))	{
					fUtil.flogResult("Passed", "Validate Neu Plan added", "NeuPlan added successfully with message: "+message, 0);
				}
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void brandPlanCreate() throws Exception{
		try {
			RestAssured.baseURI="http://tdl-membership-service-new.dev-2-tms.tatadigital.com/membership/v1/brandplan";
			
			RequestSpecification request=RestAssured.given();
			/*Header*/
			request.header("Content-Type", "application/json");
			
			/*Body*/
			JSONObject json = new JSONObject();
			json.put("brandPlanId", "41");
			json.put("name", "IHCL");
			json.put("desc", "ihcl");
			json.put("duration", "1");
			json.put("expiryType", "Auto Expire");
			json.put("programId", "234werwer432432BB");
			json.put("programName", "IHCL");
			json.put("tier", "NA");
			json.put("price", 1000);
			json.put("addOnPrice", 100);
			json.put("takeOutPrice", 1000);
			HashMap<String, Object> brandInfo=new HashMap<String, Object>();
			brandInfo.put("subscriptionId", "103");
			brandInfo.put("identificationFlag", true);
			json.put("brandInfo", brandInfo);
			
			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+ json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());
			
			/*Response*/
			Response response=request.post();
			String responseBody=response.getBody().asString();
			System.out.println("----Getting Response Body -----" );
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);
			
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			
			String message=response.jsonPath().get("message");
			System.out.println("Message: "+message);
			
			int value= response.jsonPath().get("statusCode.value");
			String desc= response.jsonPath().get("statusCode.description");
			
			System.out.println("Value: "+value+" Desc: "+desc);
			
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				if(value==200 && desc.equals("OK"))	{
					fUtil.flogResult("Passed", "Validate Neu Plan added", "BrandPlan added successfully with message: "+message, 0);
				}
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void fetchMembeship() throws Exception{
		
		try {
			RestAssured.baseURI= fUtil.fgetDataNew1("Base_URI");
			
			RequestSpecification request= RestAssured.given();
			
			/*Header*/
			request.header(fUtil.fgetDataNew1("Header1").split(":")[0], fUtil.fgetDataNew1("Header1").split(":")[1]);
			
			
			
			/*Body*/
			String req_body = fUtil.fgetDataNew1("Request");
			JSONParser parser = new JSONParser();  
			JSONObject json = (JSONObject) parser.parse(req_body);  
			
			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+ json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());
			
			/*Response*/
			Response response = request.post();
			
			String responseBody=response.getBody().asString();
			System.out.println("----Getting Response Body -----" );
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);
			
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			int expected_status_code = Integer.parseInt(fUtil.fgetDataNew1("ExpectedCode"));
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == expected_status_code) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
							
			}			
			else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is "+expected_status_code+" but it is " + statusCode, 0);
			}
			
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			
			String resp_error_code = response.jsonPath().get("status.npErrorCode");
			String exp_error_code = fUtil.fgetDataNew1("ExpectedErrorCode");
			if(resp_error_code.contains(exp_error_code))
			{
				fUtil.flogResult("Passed", "Validate the Error Code", "Error Code is " + resp_error_code, 0);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate the Error Code", "Expected Error Code is "+exp_error_code+" but it is " + resp_error_code, 0);
			}
			
			String resp_display_message = response.jsonPath().get("status.displayMessage");
			String exp_display_message = fUtil.fgetDataNew1("ExpectedDisplayMessage");
			if(resp_display_message.contains(exp_display_message))
			{
				fUtil.flogResult("Passed", "Validate the Display Message", "Display Message is " + resp_display_message, 0);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate the Display Message", "Expected Display Message is "+exp_display_message+" but it is " + resp_display_message, 0);
			}
			
			String message=response.jsonPath().get("message");
			System.out.println("Message: "+message);
			
			int value= response.jsonPath().get("statusCode.value");
			String desc= response.jsonPath().get("statusCode.description");
			
			System.out.println("Value: "+value+" Desc: "+desc);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void addBenefit() throws Exception{
		try {
			RestAssured.baseURI="http://tdl-benefits-service.dev-2-tms.tatadigital.com/benefits/v1/add-benefit";
			
			RequestSpecification request=RestAssured.given();
			//Header
			request.header("Content-Type", "application/json");
			request.header("client", "ADMIN");
			
			
			//Body
			JSONObject json=new JSONObject();
			json.put("benefitId", "110");
			json.put("programId", "234werwer4324324bb");
			json.put("brand", "brand");
			json.put("category", "Grocery");
			json.put("header", "BB benefit header");
			json.put("title", "voucher");
			json.put("desc", "A milestone offer on every 10th flight within a year - A voucher for ₹5000 off on the base fare");
			json.put("type", "Privileges");
			json.put("maxAllowed", "3");
			json.put("source", "NeuPass");
			json.put("status", "Active");
			json.put("offerLink", "offer.com");
			json.put("subscriptionLink", "bbsubscription.com");
			json.put("subscriptionName", "bbStar");
			json.put("tierLink", "null");
			json.put("tierName", "null");
			json.put("logoUrl", "www.bblogo.com");
			json.put("bgUrl", "www.bbbg.com");
			json.put("benefitDetailBgMobileUrl", "www.bbdetailbg.com");
			json.put("benefitDetailBgDesktopUrl", "www.bbdetailbg.com");
			json.put("bgTheme", "dark");
			json.put("cta", "N");
			json.put("ctaName", "ctaName");
			json.put("ctaUrl", "ctaUrl.com");
			ArrayList<HashMap> kpoint = new ArrayList<HashMap>();
			HashMap<String, String> keyp1=new HashMap<String, String>();
			keyp1.put("keyLogo", "www.keylogo1.com");
			keyp1.put("keyDesc", "desc1");
			HashMap<String, String> keyp2=new HashMap<String, String>();
			keyp2.put("keyLogo", "www.keylogo2.com");
			keyp2.put("keyDesc", "desc2");
			kpoint.add(keyp1);
			kpoint.add(keyp2);
			json.put("keyPoints", kpoint);
						
			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+ json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());
			
			//Response
			Response response=request.post();
			String responseBody=response.getBody().asString();
			System.out.println("----Getting Response Body -----" );
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);
			
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
							
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
			
			JsonPath jsonPathEvaluator = response.jsonPath();
			String resp_msg = jsonPathEvaluator.get("message");
			if (resp_msg.contains("BenefitId: 110 Successfully Updated")) {
				fUtil.flogResult("Passed", "Validate the Message", "Message is " + resp_msg, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Message",
						"Expected Message is BenefitId: 110 Successfully Updated but it is " + resp_msg, 0);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void addBrandMembership() throws Exception{
		try {
			RestAssured.baseURI= fUtil.fgetDataNew1("Base_URI");
			
			RequestSpecification request= RestAssured.given();
			
			/*Header*/
			request.header(fUtil.fgetDataNew1("Header1").split(":")[0], fUtil.fgetDataNew1("Header1").split(":")[1]);
			request.header(fUtil.fgetDataNew1("Header2").split(":")[0], fUtil.fgetDataNew1("Header2").split(":")[1]);
			request.header(fUtil.fgetDataNew1("Header3").split(":")[0], fUtil.fgetDataNew1("Header3").split(":")[1]);
			request.header(fUtil.fgetDataNew1("Header4").split(":")[0], fUtil.fgetDataNew1("Header4").split(":")[1]);
			request.header(fUtil.fgetDataNew1("Header5").split(":")[0], fUtil.fgetDataNew1("Header5").split(":")[1]);
			request.header(fUtil.fgetDataNew1("Header6").split(":")[0], fUtil.fgetDataNew1("Header6").split(":")[1]);
			
			
			/*Body*/
			String req_body = fUtil.fgetDataNew1("Request");
			JSONParser parser = new JSONParser();  
			JSONObject json = (JSONObject) parser.parse(req_body);  
			
			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+ json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());
			
			/*Response*/
			Response response = request.post();
			
			String responseBody=response.getBody().asString();
			System.out.println("----Getting Response Body -----" );
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);
			
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			int expected_status_code = Integer.parseInt(fUtil.fgetDataNew1("ExpectedCode"));
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == expected_status_code) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
							
			}			
			else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is "+expected_status_code+" but it is " + statusCode, 0);
			}
			
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	
	@Test
	public void fetchNeuPassMembership() throws Exception{
		try {
			RestAssured.baseURI= fUtil.fgetDataNew1("Base_URI");
			
			RequestSpecification request= RestAssured.given();
			
			/*Header*/
			request.header(fUtil.fgetDataNew1("Header1").split(":")[0], fUtil.fgetDataNew1("Header1").split(":")[1]);
			
			
			
			/*Body*/
			String req_body = fUtil.fgetDataNew1("Request");
			JSONParser parser = new JSONParser();  
			JSONObject json = (JSONObject) parser.parse(req_body);  
			
			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+ json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());
			
			/*Response*/
			Response response = request.post();
			
			String responseBody=response.getBody().asString();
			System.out.println("----Getting Response Body -----" );
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);
			
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			int expected_status_code = Integer.parseInt(fUtil.fgetDataNew1("ExpectedCode"));
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == expected_status_code) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
							
			}			
			else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is "+expected_status_code+" but it is " + statusCode, 0);
			}
			
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			
			String resp_error_code = response.jsonPath().get("status.npErrorCode");
			String exp_error_code = fUtil.fgetDataNew1("ExpectedErrorCode");
			if(resp_error_code.contains(exp_error_code))
			{
				fUtil.flogResult("Passed", "Validate the Error Code", "Error Code is " + resp_error_code, 0);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate the Error Code", "Expected Error Code is "+exp_error_code+" but it is " + resp_error_code, 0);
			}
			
			String resp_display_message = response.jsonPath().get("status.displayMessage");
			String exp_display_message = fUtil.fgetDataNew1("ExpectedDisplayMessage");
			if(resp_display_message.contains(exp_display_message))
			{
				fUtil.flogResult("Passed", "Validate the Display Message", "Display Message is " + resp_display_message, 0);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate the Display Message", "Expected Display Message is "+exp_display_message+" but it is " + resp_display_message, 0);
			}
			
			String message=response.jsonPath().get("message");
			System.out.println("Message: "+message);
			
			int value= response.jsonPath().get("statusCode.value");
			String desc= response.jsonPath().get("statusCode.description");
			
			System.out.println("Value: "+value+" Desc: "+desc);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	
	@Test
	public void fetchBenefitDetails() throws Exception{
		try {
			RestAssured.baseURI= fUtil.fgetDataNew1("Base_URI");
			
			RequestSpecification request= RestAssured.given().param(fUtil.fgetDataNew1("Parameter1").split(":")[0], fUtil.fgetDataNew1("Parameter1").split(":")[1]);
	
			
			/*Header*/
			
			
			
			/*Body*/
			
			
			/*Response*/
			Response response = request.get();
			
			String responseBody=response.getBody().asString();
			System.out.println("----Getting Response Body -----" );
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);
			
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			int expected_status_code = Integer.parseInt(fUtil.fgetDataNew1("ExpectedCode"));
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == expected_status_code) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
							
			}			
			else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is "+expected_status_code+" but it is " + statusCode, 0);
			}
			
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	
}
