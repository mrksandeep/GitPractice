package com.QA.TestApp.Testcases.API;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.QA.TestApp.Utilities.BaseScript;

import org.testng.Assert;
import org.testng.annotations.Test;



public class TC001_GET_Request extends BaseScript{

	@Test
	 void getweatherDetails() 
	 {
	  try{
		  //Specify base URI
	 
	  RestAssured.baseURI=fUtil.fgetDataNew1("Base_URI");//"http://restapi.demoqa.com/utilities/weather/city";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/"+fUtil.fgetDataNew1("CityName"));
	  
	  //print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  if(statusCode==200) {
		  fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is "+statusCode, 0);
	  }else {
		  fUtil.flogResult("Failed", "Validate the Status Code", "Expected Status Code is 200 but it is "+statusCode, 0);
	  }
	  //Assert.assertEquals(statusCode, 200);
	  
	  //status line verification
	  String statusLine=response.getStatusLine();
	  System.out.println("Status line is:"+statusLine);
	  if(statusLine.equals("HTTP/1.1 200 OK")) {
		  fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is "+statusLine, 0);
	  }else {
		  fUtil.flogResult("Failed", "Validate the Status Line", "Expected Status Line is HTTP/1.1 200 OK but it is "+statusLine, 0);
	  }
	  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	  }catch(Exception ee) {
		  System.out.println(ee.getMessage());
	  }
	 }
}
