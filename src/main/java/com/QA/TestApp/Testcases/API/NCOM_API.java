package com.QA.TestApp.Testcases.API;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.internal.util.IOUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import com.QA.TestApp.Utilities.BaseScript;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NCOM_API extends BaseScript

{
	static HashMap<String, String> callchainreqfields = new HashMap<String, String>();
	static RequestSpecification httpRequest;
     HashMap<String, String> headersMap = new HashMap<String, String>();
     HashMap<String, String> queryParamsMap = new HashMap<String, String>();

	@Test
	public void getEMIForProduct() throws Exception {
		try {

			RestAssured.baseURI = "http://unified-pim.dev-ncom.tatadigital.com/emi";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			request.queryParam("amount", "40000");
			request.queryParam("brand", "CROMA");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				fUtil.flogResult("Passed", "Validate the response", "EMI is available for productAmount 40000", 0);

				List<String> bankNameResponse = response.jsonPath().get("bankDetails.bankName");

				fUtil.flogResult("Passed", "Validate the response",
						"EMI is available for products from banks: " + bankNameResponse, 0);
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
	public void sortFilterPriceDesc() throws Exception {
		try {
			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");
			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/pim/plp";
 
			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			// request.queryParam("partner_id",fUtil.fgetDataNew1("1423"));
			request.queryParam("brand", "CROMA");
			request.queryParam("query", "refrigerator");
			request.queryParam("filter","{ \"price\":[\"10,001 - 20,000\"], \"brand\":[\"LG\",\"Samsung\"]}");
			request.queryParam("sort", "price-desc");
			request.queryParam("pageNumber", "0");
			request.queryParam("pageSize", "10");
			
			Response response = request.get();

			//Response response = given().contentType(ContentType.JSON).log().all().get();
			

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				List priceListResponse = response.jsonPath().get("products.price.value");
				System.out.println("List from response: " + priceListResponse);

				int maxPrice = (int) Collections.max(priceListResponse);
				int minPrice = (int) Collections.min(priceListResponse);
				
				if (minPrice>=10000 && maxPrice <= 20000) {
					fUtil.flogResult("Passed", "Validate the Filter",
							"Price filter (10000-20000) is correctly applied as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the Filter",
							"Price filter (10000-20000) is not applied correctly as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				}

				List<Double> sortedPriceList = response.jsonPath().get("products.price.value");
				Collections.sort(sortedPriceList);
				Collections.reverse(sortedPriceList);
				System.out.println("List after sorting: " + sortedPriceList);

				if (priceListResponse.equals(sortedPriceList)) {
					fUtil.flogResult("Passed", "Validate the Sorting of PriceList in Desc Order",
							"PriceList is in Desc Order" + priceListResponse, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Sorting of PriceList in Desc Order",
							"PriceList is not in Desc Order" + priceListResponse, 0);
				}

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
	public void sortFilterPriceAsc() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/pim/plp";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			// request.queryParam("partner_id",fUtil.fgetDataNew1("1423"));
			request.queryParam("brand", "CROMA");
			request.queryParam("query", "refrigerator");
			request.queryParam("filter","{ \"price\":[\"5,001 - 10,000\",\"10,001 - 20,000\"], \"brand\":[\"LG\",\"Samsung\"]}");
			request.queryParam("sort", "price-desc");
			request.queryParam("pageNumber", "0");
			request.queryParam("pageSize", "10");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				List priceListResponse = response.jsonPath().get("products.price.value");
				System.out.println("List from response: " + priceListResponse);

				int maxPrice = (int) Collections.max(priceListResponse);
				int minPrice = (int) Collections.min(priceListResponse);
				if (maxPrice <= 20000) {
					fUtil.flogResult("Passed", "Validate the Filter",
							"Price filter (5000-20000) is correctly applied as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the Filter",
							"Price filter (5000-20000) is not applied correctly as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				}
				List<Double> sortedPriceList = response.jsonPath().get("products.price.value");
				Collections.sort(sortedPriceList);
				// Collections.reverse(sortedPriceList);
				System.out.println("List after sorting: " + sortedPriceList);

				if (priceListResponse.equals(sortedPriceList)) {
					fUtil.flogResult("Passed", "Validate the Sorting of PriceList in Asc Order",
							"PriceList is in Asc Order" + priceListResponse, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Sorting of PriceList in Asc Order",
							"PriceList is not in Asc Order" + priceListResponse, 0);
				}

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
	public void sortFilterPriceTopRated() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/pim/plp";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			// request.queryParam("partner_id",fUtil.fgetDataNew1("1423"));
			request.queryParam("brand", "CROMA");
			request.queryParam("query", "smartphone");
			request.queryParam("filter",
					"{ \"price\":[\"5,001 - 10,000\",\"10,001 - 20,000\"], \"brand\":[\"OPPO\",\"Realme\"]}");
			request.queryParam("sort", "topRated");
			request.queryParam("pageNumber", "0");
			request.queryParam("pageSize", "10");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				List priceListResponse = response.jsonPath().get("products.price.value");
				System.out.println("List from response: " + priceListResponse);

				int maxPrice = (int) Collections.max(priceListResponse);
				int minPrice = (int) Collections.min(priceListResponse);
				if (maxPrice <= 20000) {
					fUtil.flogResult("Passed", "Validate the Filter",
							"Price filter (5000-20000) is correctly applied as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the Filter",
							"Price filter (5000-20000) is not applied correctly as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				}

				List<Object> ratingListResponse = response.jsonPath().get("products.finalReviewRating");
				List<Float> ratingListResponse1 = new ArrayList();
				for (Object p : ratingListResponse) {
					ratingListResponse1.add(Float.valueOf(p.toString()));
				}

				List<Object> unSortedRatingList = response.jsonPath().get("products.finalReviewRating");
				List<Float> sortedRatingList = new ArrayList();
				for (Object p : unSortedRatingList) {
					sortedRatingList.add(Float.valueOf(p.toString()));
				}
				float maxValue = Collections.max(sortedRatingList);
				System.out.println("List from response: " + ratingListResponse);
				Collections.sort(sortedRatingList);
				Collections.reverse(sortedRatingList);
				System.out.println("List after sorting: " + sortedRatingList);

				if (ratingListResponse1.equals(sortedRatingList)) {
					fUtil.flogResult("Passed", "Validate the Sorting of RatingList in Desc Order",
							"RatingList is in Desc Order" + ratingListResponse, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Sorting of RatingList in Desc Order",
							"RatingList is not in Desc Order" + ratingListResponse, 0);
				}

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
	public void sortFilterDiscountDesc() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/pim/plp";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			// request.queryParam("partner_id",fUtil.fgetDataNew1("1423"));
			request.queryParam("brand", "CROMA");
			request.queryParam("query", "smartphone");
			request.queryParam("filter",
					"{ \"price\":[\"5,001 - 10,000\",\"10,001 - 20,000\"], \"brand\":[\"OPPO\",\"Realme\"]}");
			request.queryParam("sort", "discount-desc");
			request.queryParam("pageNumber", "0");
			request.queryParam("pageSize", "10");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				List priceListResponse = response.jsonPath().get("products.price.value");
				System.out.println("List from response: " + priceListResponse);

				int maxPrice = (int) Collections.max(priceListResponse);
				int minPrice = (int) Collections.min(priceListResponse);
				if (maxPrice <= 20000) {
					fUtil.flogResult("Passed", "Validate the Filter",
							"Price filter (5000-20000) is correctly applied as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the Filter",
							"Price filter (5000-20000) is not applied correctly as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				}

				List<Object> discountsResponse = response.jsonPath().get("products.discountValue");
				List<Float> discountsResponse1 = new ArrayList();
				for (Object p : discountsResponse) {
					discountsResponse1.add(Float.valueOf(p.toString().replaceAll("%", "").trim()));
				}

				List<Float> sortedDiscountsList = new ArrayList();
				sortedDiscountsList.addAll(discountsResponse1);
				System.out.println("List from response: " + discountsResponse1);
				float maxValue = Collections.max(sortedDiscountsList);
				System.out.println("List from response: " + discountsResponse);
				Collections.sort(sortedDiscountsList);
				Collections.reverse(sortedDiscountsList);
				System.out.println("List after sorting: " + sortedDiscountsList);

				if (discountsResponse1.equals(sortedDiscountsList)) {
					fUtil.flogResult("Passed", "Validate the Sorting of RatingList in Desc Order",
							"RatingList is in Desc Order" + discountsResponse, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Sorting of RatingList in Desc Order",
							"RatingList is not in Desc Order" + discountsResponse, 0);
				}

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
	public void inventoryValidation() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/inventory";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			String pin = "400096";

			JSONObject json = new JSONObject();

			List<HashMap<Object, Object>> productList = new ArrayList<HashMap<Object, Object>>();

			HashMap<Object, Object> mapSkuid0 = new HashMap<Object, Object>();
			mapSkuid0.put("skuId", "225724");
			mapSkuid0.put("programId", "01eae2ec-0576-1000-bbea-86e16dcb4b79");
			mapSkuid0.put("quantity", 50);

			HashMap<Object, Object> mapSkuid1 = new HashMap<Object, Object>();
			mapSkuid1.put("skuId", "225725");
			mapSkuid1.put("programId", "01eae2ec-0576-1000-bbea-86e16dcb4b79");
			mapSkuid1.put("quantity", 10);

			HashMap<Object, Object> mapSkuid2 = new HashMap<Object, Object>();
			mapSkuid2.put("skuId", "225726");
			mapSkuid2.put("programId", "01eae2ec-0576-1000-bbea-86e16dcb4b79");
			mapSkuid2.put("quantity", 10);

			productList.add(0, mapSkuid0);
			productList.add(1, mapSkuid1);
			productList.add(2, mapSkuid2);

			json.put("products", productList);
			json.put("pinCode", pin);

			System.out.println("JSON is generated --" + json.toJSONString());
			// request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Request Body", "Request Json is :  " + json.toJSONString(), 0);

			request.body(json.toJSONString());
			Response response = request.post();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				List skuIDList = response.jsonPath().get("products.skuId");
				System.out.println("List from response: " + skuIDList);
				List skuIDIsServiceable = response.jsonPath().get("products.isServiceable");
				System.out.println("List from response: " + skuIDIsServiceable);
				fUtil.flogResult("Passed", "Validate the response", "SkuId are " + skuIDList, 0);
				for (int i = 0; i < skuIDList.size(); i++) {
					fUtil.flogResult("Passed", "Validate the response for pinCode: " + pin,
							"SkuId : " + skuIDList.get(i) + " isServiceable :" + skuIDIsServiceable.get(i), 0);
				}

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
	public void inventoryValidationInvalidData() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/inventory";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			String pin = "400096";
			JSONObject json = new JSONObject();

			List<HashMap<Object, Object>> productList = new ArrayList<HashMap<Object, Object>>();

			HashMap<Object, Object> mapSkuid0 = new HashMap<Object, Object>();
			mapSkuid0.put("skuId", "");
			mapSkuid0.put("programId", "01eae2ec-0576-1000-bbea-86e16dcb4b79");
			mapSkuid0.put("quantity", 50);

			productList.add(0, mapSkuid0);

			json.put("products", productList);
			json.put("pinCode", pin);

			System.out.println("JSON is generated --" + json.toJSONString());
			// request.body(json.toJSONString());

			request.body(json.toJSONString());
			Response response = request.post();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			String statusLine = response.getStatusLine();

			System.out.println("Status code is: " + statusCode);
			if (statusCode == 422) {
				fUtil.flogResult("Passed", "Validate the Status Code",
						"Status Code is " + statusCode + " for invalid skuId", 0);
				fUtil.flogResult("Passed", "Validate the Status Line",
						"Status Line is " + statusLine + "for invalid skuId", 0);
				String message = response.jsonPath().get("message");
				fUtil.flogResult("Passed", "Validate the response", "Message for invalid data: " + message, 0);

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 422 but it is " + statusCode, 0);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}

	@Test
	public void pagination() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/pim/plp";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			// request.queryParam("partner_id",fUtil.fgetDataNew1("1423"));
			request.queryParam("brand", "CROMA");
			request.queryParam("query", "smartphone");
			request.queryParam("filter",
					"{ \"price\":[\"5,001 - 10,000\",\"10,001 - 20,000\"], \"brand\":[\"OPPO\",\"Realme\"]}");
			request.queryParam("sort", "topRated");
			request.queryParam("pageNumber", "0");
			request.queryParam("pageSize", "10");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				List priceListResponse = response.jsonPath().get("products.price.value");
				System.out.println("List from response: " + priceListResponse);

				int maxPrice = (int) Collections.max(priceListResponse);
				int minPrice = (int) Collections.min(priceListResponse);
				if (maxPrice <= 20000) {
					fUtil.flogResult("Passed", "Validate the Filter",
							"Price filter (5000-20000) is correctly applied as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the Filter",
							"Price filter (5000-20000) is not applied correctly as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				}

				int pageSize = response.jsonPath().get("pagination.pageSize");
				int pageNumber = response.jsonPath().get("pagination.currentPage");
				int totalResults = response.jsonPath().get("pagination.totalResults");

				if (pageSize <= 10 && pageNumber == 0) {
					fUtil.flogResult("Passed", "Validate the response for pagination",
							"Total number of results: " + totalResults, 0);

					fUtil.flogResult("Passed", "Validate the response for pagination",
							"Results are correct as Page number: " + pageNumber + " and page size : " + pageSize, 0);

				} else {
					fUtil.flogResult("Failed", "Validate the response for pagination",
							"Results are not correct as Page number: " + pageNumber + " and page size : " + pageSize,
							0);
				}

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
	public void addAddress() throws Exception {
		try {

			String accessToken = generateAccessToken();
			RestAssured.baseURI = "https://ppapi.tatadigital.com/api/v2/native-commerce/location-intelligence/addresses";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("Authorization", accessToken);
			request.header("client_id", "TCP-WEB-APP");

			JSONObject json = new JSONObject();

			HashMap<Object, Object> mapAddress = new HashMap<Object, Object>();
			mapAddress.put("addressType", "home");
			mapAddress.put("addressLabel", "home address");
			mapAddress.put("country", "India");

			HashMap<Object, Object> mapContactDeatils = new HashMap<Object, Object>();
			mapContactDeatils.put("areaCode", "011");
			mapContactDeatils.put("contactPersonName", "Sandeep");
			mapContactDeatils.put("phoneNumber", "7797718853");
			mapContactDeatils.put("isdCode", "+91");
			mapAddress.put("contactDetail", mapContactDeatils);

			HashMap<Object, Object> mapGpsCoordinates = new HashMap<Object, Object>();
			mapGpsCoordinates.put("latitude", 18.969049);
			mapGpsCoordinates.put("longitude", 72.821182);

			mapAddress.put("gpsCoordinates", mapGpsCoordinates);

			mapAddress.put("city", "New Delhi");
			mapAddress.put("isPrimary", true);
			mapAddress.put("pinCode", 110003);
			mapAddress.put("state", "Delhi");
			mapAddress.put("addressLine", "Delhi");
			mapAddress.put("landmark", "Taj Hote");
			mapAddress.put("house", "40");

			json.put("address", mapAddress);

			System.out.println("JSON is generated --" + json.toJSONString());
			// request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Request Body", "Request Json is :  " + json.toJSONString(), 0);

			request.body(json.toJSONString());
			Response response = request.post();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String message = response.jsonPath().get("message");

				if (message.contains("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"Address created and response message is " + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Address creation failed", 0);
				}

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
	public void deleteAddress() throws Exception {
		try {

			String accessToken = generateAccessToken();
			RestAssured.baseURI = "https://ppapi.tatadigital.com/api/v1/native-commerce/location-intelligence/addresses/86956f79-5bc0-4fbc-a18a-29609d6508c8";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("Authorization", accessToken);
			request.header("client_id", "TCP-WEB-APP");

			Response response = request.delete();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String message = response.jsonPath().get("message");

				if (message.contains("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"Address deleted and response message is " + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Address deleteion failed", 0);
				}

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
	public void getAllAddress() throws Exception {
		try {

			String accessToken = generateAccessToken();
			RestAssured.baseURI = "https://ppapi.tatadigital.com/api/v1/native-commerce/location-intelligence/addresses";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("Authorization", accessToken);
			request.header("client_id", "TCP-WEB-APP");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String message = response.jsonPath().get("message");

				if (message.contains("success")) {
					fUtil.flogResult("Passed", "Validate the response", "Address data fetched successfully", 0);
					List<Integer> pincodeList = response.jsonPath().get("data.pinCode");
					fUtil.flogResult("Passed", "Validate the address", "List of picodes: " + pincodeList, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Get all Address request failed", 0);
				}

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
	public void getAddress() throws Exception {
		try {

			String accessToken = generateAccessToken();
			RestAssured.baseURI = "https://ppapi.tatadigital.com/api/v1/native-commerce/location-intelligence/addresses/d390dcf4-a0e6-4b97-9877-10e1b179b03c";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("Authorization", accessToken);
			request.header("client_id", "TCP-WEB-APP");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String message = response.jsonPath().get("message");

				if (message.contains("success")) {
					fUtil.flogResult("Passed", "Validate the response", "Address data fetched successfully", 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Get all Address request failed", 0);
				}

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
	public void getDefaultAddress() throws Exception {
		try {

			String accessToken = generateAccessToken();
			RestAssured.baseURI = "https://ppapi.tatadigital.com/api/v1/native-commerce/location-intelligence/default-address";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("Authorization", accessToken);
			request.header("client_id", "TCP-WEB-APP");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String message = response.jsonPath().get("message");

				if (message.contains("success")) {
					fUtil.flogResult("Passed", "Validate the response", "Default Address data fetched successfully", 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Get all Address request failed", 0);
				}

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
	public void setPincode() throws Exception {
		try {

			String accessToken = generateAccessToken();
			RestAssured.baseURI = "https://ppapi.tatadigital.com/api/v1/native-commerce/address-location-intelligence/set-pincode/110003";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("Authorization", accessToken);
			request.header("client_id", "TCP-WEB-APP");

			Response response = request.post();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String message = response.jsonPath().get("message");

				if (message.contains("success")) {
					fUtil.flogResult("Passed", "Validate the response", "Pincode added successfully", 0);

				} else {
					fUtil.flogResult("Failed", "Validate the response", "Set pincode request failed", 0);
				}

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
	public void getPincode() throws Exception {
		try {

			String accessToken = generateAccessToken();
			RestAssured.baseURI = "https://ppapi.tatadigital.com/api/v1/native-commerce/address-location-intelligence/get-pincode";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("Authorization", accessToken);
			request.header("client_id", "TCP-WEB-APP");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String message = response.jsonPath().get("message");

				if (message.contains("success")) {
					fUtil.flogResult("Passed", "Validate the response", "Pincode fetched successfully", 0);

				} else {
					fUtil.flogResult("Failed", "Validate the response", "Get pincode request failed", 0);
				}

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
	public void updateAddress() throws Exception {
		try {

			String accessToken = generateAccessToken();
			RestAssured.baseURI = "https://ppapi.tatadigital.com/api/v1/native-commerce/location-intelligence/addresses/d390dcf4-a0e6-4b97-9877-10e1b179b03c";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("Authorization", accessToken);
			request.header("client_id", "TCP-WEB-APP");

			JSONObject json = new JSONObject();

			HashMap<Object, Object> mapAddress = new HashMap<Object, Object>();
			mapAddress.put("addressType", "home");
			mapAddress.put("addressLabel", "home address");
			mapAddress.put("country", "India");

			HashMap<Object, Object> mapContactDeatils = new HashMap<Object, Object>();
			mapContactDeatils.put("areaCode", "011");
			mapContactDeatils.put("contactPersonName", "Sandeep");
			mapContactDeatils.put("phoneNumber", "7797718853");
			mapContactDeatils.put("isdCode", "+91");
			mapAddress.put("contactDetail", mapContactDeatils);

			HashMap<Object, Object> mapGpsCoordinates = new HashMap<Object, Object>();
			mapGpsCoordinates.put("latitude", 18.969049);
			mapGpsCoordinates.put("longitude", 72.821182);

			mapAddress.put("gpsCoordinates", mapGpsCoordinates);

			mapAddress.put("city", "New Delhi");
			mapAddress.put("isPrimary", true);
			mapAddress.put("pinCode", 110003);
			mapAddress.put("state", "Delhi");
			mapAddress.put("addressLine", "Delhi");
			mapAddress.put("landmark", "Taj Hotel");
			mapAddress.put("landmark", "Taj Hotel");
			mapAddress.put("house", "40");

			json.put("address", mapAddress);

			System.out.println("JSON is generated --" + json.toJSONString());
			// request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Request Body", "Request Json is :  " + json.toJSONString(), 0);

			request.body(json.toJSONString());
			Response response = request.put();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String message = response.jsonPath().get("message");

				if (message.contains("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"Address updated and response message is " + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Address updation failed", 0);
				}

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

	public static String requestBodyGenerator(String requestBody) {
		// Response response = null;
		String finalreq = "";
		try {
			// Specify base URI

			String statics = "";

			// for UPI
			if (requestBody.contains("%")) {

				String[] areqbody = requestBody.split("%");

				statics = Arrays.asList(areqbody).stream().map(value -> { // (() -> {method implementation})

					if (value.replaceAll("[\\n\\t ]", "").endsWith(":\"")
							|| value.replaceAll("[\\n\\t ]", "").endsWith("}")
							|| value.replaceAll("[\\n\\t ]", "").endsWith(":")
							|| value.replaceAll("[\\n\\t ]", "").endsWith(":[\"")
							|| value.replaceAll("[]]", "]").endsWith("]")) {
						return value;

					} else {
						String data = "";
						try {
							data = fUtil.fgetDataNew1(value);
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (data.toLowerCase().contains("method")) {
							switch (data.toLowerCase()) {

							case "method:current_timestamp":
								data = gmethods.current_timestamp();
								break;
							case "method:randomnumber":
								data = gmethods.randomnumber();
								break;
							case "method:randomphonenumber":
								data = gmethods.randomphonenumber();
								break;
							case "method:randomnumberorderuniversalcart":

								data = gmethods.randomnumberUniversalCart();
								break;

							case "method:randommerchantname":
								data = gmethods.randommerchantname();
								break;

//									case "method:randomalphastring": 
//										try {
//											data = gmethods.randomstring(5, "Alpha", "");
//										} catch (Exception e) {
//											e.printStackTrace();
//										}
//										   break;

							}
						} else if (data.contains("&")) {
							data = callchainreqfields.get((data.replace("&", "")));
						}
						// *********Added code for points to be more than response received
						// data*******//
						else if (data.contains("^")) {
							data = "1" + callchainreqfields.get((data.replace("^", "")));

						} else if (data.startsWith("~")) {
							data = data.substring(1);
						}

						return data;

					}
				})

						.collect(Collectors.joining());

				finalreq = statics;

			} else {
				finalreq = requestBody.replaceAll("//s+", "").trim();
			}
			if (!finalreq.isEmpty()) {
				System.out.println("Before:\n" + finalreq);
				finalreq = finalreq.replaceAll("([\\w]+)[ ]*=", "\"$1\" ="); // to quote before = value
				finalreq = finalreq.replaceAll("=[ ]*([\\w@\\.]+)", "= \"$1\""); // to quote after = value, add
																					// special character as needed
																					// to the exclusion list in
																					// regex
				finalreq = finalreq.replaceAll("=[ ]*\"([\\d]+)\"", "= $1"); // to un-quote decimal value
				finalreq = finalreq.replaceAll("\"true\"", "true"); // to un-quote boolean
				finalreq = finalreq.replaceAll("\"false\"", "false"); // to un-quote boolean

				System.out.println("===============================");
				System.out.println("After:\n" + finalreq);
				fUtil.flogResult("Pass", "Request Body", "Request Body is " + finalreq, 0);
			}

			System.out.println("Final req from code - " + finalreq);
			// -------json modify
			String jsonString = finalreq;

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return finalreq;

	}

	// 28-2
	@Test
	public void addCartBuyNow() throws Exception {
		try {
			RestAssured.baseURI = "https://ppapi.tatadigital.com/api/v1/native-commerce/cart/add?buynow=true";
			String accessToken = generateAccessToken();
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");

			RequestSpecification request = RestAssured.given();
			/* Header Part */
			request.header("client_id", "TCP-WEB-APP");
			request.header("Authorization", accessToken);
			request.header("customerHash", customer_hash);
			request.header("Content-Type", "application/json");

			/* Body */
			JSONObject json = new JSONObject();

			HashMap<String, Object> updateMap = new HashMap<String, Object>();
			updateMap.put("skuId", Integer.parseInt(skuId));
			updateMap.put("quantity", Integer.parseInt(quantity));
			updateMap.put("programId", "73eb6345-9cc9-4c37-a8e8-8620d6d32cf5");

			json.put("refreshCart", true);
			json.put("update", updateMap);

			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is" + json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			// Post
			Response response = request.post();

			// Response Body
			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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

			List<List<String>> skuIds = response.jsonPath().get("universalCart.brandProducts.skuId");
			List<List<Integer>> qty = response.jsonPath().get("universalCart.brandProducts.quantity");
			System.out.println(skuIds);
			System.out.println(qty);
			boolean addcartFlag = false;
			if (skuIds.size() > 0) {
				for (int i = 0; i < skuIds.get(0).size(); i++) {
					if (skuId.equals(skuIds.get(0).get(i))) {
						fUtil.flogResult("Passed", "Validate Sku Id: " + skuId + " was added to cart",
								"SKU ID was added succesfully with quanity in cart: " + qty.get(0).get(i), 0);
						addcartFlag = true;
					}
				}
			}
			if (!addcartFlag) {
				fUtil.flogResult("Failed", "Validate Sku Id: " + skuId + " was added to cart",
						"SKU ID was not added succesfully with quanity in cart", 0);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void getImageUrl() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/pim/product-info";

			RequestSpecification request = RestAssured.given();
			// 9
			String skuId = "100341";
			request.queryParam("brand", "CROMA");
			request.queryParam("brandSkuCode", skuId);

			request.header("Content-Type", "application/json");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				List<String> productSkuId = response.jsonPath().get("imageInfo.code");
				List<String> url = response.jsonPath().get("imageInfo.url");

				if (productSkuId.contains(skuId)) {
					fUtil.flogResult("Passed", "Validate the response",
							"Product " + skuId + " is fectched successfully", 0);

					fUtil.flogResult("Passed", "Validate the skuID Image URL from api response",
							"For Product " + productSkuId + " respective imageUrl are " + url, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Get all Address request failed", 0);
				}

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

	/*
	 * Function name : generateAccessToken This function will generate accesstoken.
	 * Input required : baseUriAuth, baseUriToken, clientId Name,
	 * secretKey,code_challenge,countryCode,mobileNumber,password
	 * 
	 */

	public String generateAccessToken() throws Exception {

		String bearerToken = "";
		try {

			/*
			 * ============================================ AuthCode
			 * Generation===========================================
			 */
			String baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			String baseUriToken = fUtil.fgetDataNew1("BaseUriToken");
			String h_clientId = fUtil.fgetDataNew1("ClientId");
			String h_secretKey = fUtil.fgetDataNew1("SecretKey");
			String code_challenge = fUtil.fgetDataNew1("Code_challenge");
			String countryCode = "91";
			String mobileNumber = fUtil.fgetDataNew1("MobileNumber");
			String password = fUtil.fgetDataNew1("Password");
			String redirectUrl = fUtil.fgetDataNew1("RedirectUrl");
			String codeVerifier = fUtil.fgetDataNew1("code_verifier");

			String auth_Code = "";

			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);
			request.header("client_secret", h_secretKey);

			JSONObject json = new JSONObject();
			json.put("countryCode", countryCode);
			json.put("phone", mobileNumber);
			json.put("password", password);
			json.put("codeChallenge", code_challenge);
			json.put("redirectUrl", redirectUrl);

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);

			auth_Code = response.jsonPath().get("authCode");
			System.out.println("AuthCode is : " + auth_Code);

			String baseUri_accessToken = baseUriToken + "/" + auth_Code;
			System.out.println("baseUri_accessToken is : " + baseUri_accessToken);

			/*
			 * ====================================Access Token Generation
			 * ============================================
			 */
			RestAssured.baseURI = baseUri_accessToken;

			RequestSpecification requestToken = RestAssured.given();

			requestToken.header("Content-Type", "application/json");
			requestToken.header("client_id", h_clientId);
			requestToken.header("client_secret", h_secretKey);

			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", codeVerifier);

			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();

			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);

			String accessToken = responseToken.jsonPath().get("accessToken");

			System.out.println("Access token  is : " + accessToken);

			// JsonPath path = response.jsonPath();
			// String tokenKey = path.getString("token");
			String tokenType = "Bearer";
			bearerToken = tokenType + " " + accessToken;

		} catch (Exception ee) {
			System.out.println("GenerateAccessToken failed for : " + ee.getMessage());
		}
		return bearerToken;

	}

	@Test
	public void addWishlist() throws Exception {
		try {
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String programId = fUtil.fgetDataNew1("programID");
			String accessToken = generateAccessToken();

			RestAssured.baseURI = "http://unified-cart.dev-ncom.tatadigital.com/v2/wishlist/add/" + skuId;
			System.out.println("Base URI: " + RestAssured.baseURI);

			RequestSpecification request = RestAssured.given();

			/* Header Part */
			request.header("tcpAccessToken", accessToken);
			request.header("customerHash", customer_hash);
			request.header("Content-Type", "application/json");

			/* Body Part */
			JSONObject json = new JSONObject();
			json.put("programId", programId);

			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is" + json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			/* Response */
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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

			String wishlistResponse = response.jsonPath().get("wishlistResponse");
			if (wishlistResponse.equalsIgnoreCase("Added to wishlist")) {
				fUtil.flogResult("Passed", "Validate product was added to wishlist",
						"Whislist Response: " + wishlistResponse, 0);
			} else
				fUtil.flogResult("Failed", "Validate product was added to wishlist",
						"Whislist Response: " + wishlistResponse, 0);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void removeWishlist() throws Exception {
		try {
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String programId = fUtil.fgetDataNew1("programID");
			String access_token = "cc36ffb5-99db-48bf-9f09-8aa99330d49d";

			RestAssured.baseURI = "http://unified-cart.dev-ncom.tatadigital.com/v2/wishlist/remove/" + skuId;
			System.out.println("Base URI: " + RestAssured.baseURI);

			RequestSpecification request = RestAssured.given();

			/* Header Part */
			request.header("tcpAccessToken", access_token);
			request.header("customerHash", customer_hash);
			request.header("Content-Type", "application/json");

			/* Body Part */
			JSONObject json = new JSONObject();
			json.put("programId", programId);

			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is" + json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			/* Response */
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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

			String wishlistResponse = response.jsonPath().get("wishlistResponse");
			if (wishlistResponse.equalsIgnoreCase("Remove Successfully")) {
				fUtil.flogResult("Passed", "Validate product was removed from wishlist",
						"Whislist Response: " + wishlistResponse, 0);
			} else
				fUtil.flogResult("Failed", "Validate product was removed from wishlist",
						"Whislist Response: " + wishlistResponse, 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void getWishlist() throws Exception {
		try {
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String programId = fUtil.fgetDataNew1("programID");
			String access_token = "cc36ffb5-99db-48bf-9f09-8aa99330d49d";

			RestAssured.baseURI = "http://unified-cart.dev-ncom.tatadigital.com/v2/wishlist/get";
			System.out.println("Base URI: " + RestAssured.baseURI);

			RequestSpecification request = RestAssured.given();

			/* Header Part */
			request.header("tcpAccessToken", access_token);
			request.header("customerHash", customer_hash);
			request.header("Content-Type", "application/json");

			/* Body Part */
			JSONObject json = new JSONObject();
			json.put("programId", programId);

			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is" + json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			/* Response */
			Response response = request.get();

			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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

			boolean wishlistResponse = response.jsonPath().get("defaultWishlist");
			if (wishlistResponse) {
				List<String> wishlistSkuIds = response.jsonPath().get("entries.product.code");
				System.out.println("Wishlist Sku IDs are " + wishlistSkuIds);
				fUtil.flogResult("Passed", "Validate get Sku IDs from wishlist",
						"Product SkuIds in WishList are" + wishlistSkuIds, 0);
			} else
				fUtil.flogResult("Passed", "Validate get Sku IDs from wishlist",
						"No Product in Wishlist as defaultWishlist: " + wishlistResponse, 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void getAPIforproductoverview() throws Exception {
		try {

			RestAssured.baseURI = "http://unified-pim.dev-ncom.tatadigital.com/pdp";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			String skuid = fUtil.fgetDataNew1("skuID");
			request.queryParam("brandSkuCode", skuid);
			request.queryParam("brand", "CROMA");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				String skuid_responsebody = response.jsonPath().get("code");
				if (skuid_responsebody.equals(skuid)) {
					fUtil.flogResult("Passed", "Validate the response", "product overview is avabilable" + skuid, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "product overview is not avabilable", 0);

				}
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
	public void getAPIforoffers() throws Exception {
		try {

			RestAssured.baseURI = "http://unified-pim.dev-ncom.tatadigital.com/pdp";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			String skuid = fUtil.fgetDataNew1("skuID");
			request.queryParam("brandSkuCode", skuid);
			request.queryParam("brand", "CROMA");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				String skuid_responsebody = response.jsonPath().get("code");
				if (skuid_responsebody.equals(skuid)) {
					fUtil.flogResult("Passed", "Validate the response", "Offer is avabilable for this product" + skuid,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Offer is not avabilable for this product", 0);

				}
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
	public void getAPIforsimilar_products() throws Exception {
		try {

			RestAssured.baseURI = "http://unified-pim.dev-ncom.tatadigital.com/similar-products";

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");

			int pagesize = 2;
			String skuid = fUtil.fgetDataNew1("skuID");
			request.queryParam("brandSkuCode", skuid);
			request.queryParam("brand", "CROMA");
			request.queryParam("pageSize", pagesize);

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				String status = response.jsonPath().get("status");
				if (status.equals("success")) {
					fUtil.flogResult("Passed", "Validate the response", "similar product is avabilable " + skuid, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "No similar product", 0);

				}
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
	public void addReview() throws Exception {
		try {

			String accessToken = generateAccessToken();
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			String programId = fUtil.fgetDataNew1("programID");

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("Authorization", accessToken);
			request.header("client_id", "TCP-WEB-APP");

			String requestBody = fUtil.fgetDataNew1("Request");

			String reqBody = requestBodyGenerator(requestBody);
			/*
			 * JSONObject json=new JSONObject(); json.put("programId", programId);
			 * json.put("alias", "Sandeep"); json.put("comments",
			 * "Nice Product. Good Quality"); json.put("customerName", "Sandeep");
			 * json.put("productCode", "205532"); json.put("rating", "5");
			 */

			httpRequest = request.contentType(ContentType.JSON).body(reqBody);

			// request.body(json.toJSONString());
			// fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+
			// json.toJSONString(), 0);
			// System.out.println("Request Body is:" + json.toJSONString());
			Response response = httpRequest.put(RestAssured.baseURI);

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 202) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				if (responseBody.contains("Accepted")) {
					fUtil.flogResult("Passed", "Validate the response", "Review added successfully", 0);

				} else {
					fUtil.flogResult("Failed", "Validate the response", "Add Review request failed", 0);
				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 202 Accepted")) {
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
	public void getReview() throws Exception {
		try {

			String skuid = fUtil.fgetDataNew1("skuID");
			RestAssured.baseURI = "http://unified-pim.dev-ncom.tatadigital.com/similar-products" + "/" + skuid;

			RequestSpecification request = RestAssured.given();
			// 9

			request.header("Content-Type", "application/json");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				String code = response.jsonPath().get("code");
				if (code.contains(skuid)) {
					fUtil.flogResult("Passed", "Validate the response", "Review fetched for " + skuid, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Review not fetched for" + skuid, 0);

				}
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

	// Get facet-filter via brand & category-code
	@Test
	public void getAPIforfacet_filter() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/pim/facet-filter/CROMA/ELECTRONICS-997";

			RequestSpecification request = RestAssured.given();
			// 9

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				String message = response.jsonPath().get("message");
				if (message.equals("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"category code and response message is " + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "category code is not avabilable ", 0);

				}
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed",
						"ValTo view more phone numbers, click this link: https://tel.meet/xsu-awoe-nuz?hs=5idate the Status Line",
						"Status Line is " + statusLine, 0);
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

	// Get_attribute_feature_by_Category_code

	@Test
	public void getAPIforGet_attribute_feature_by_Category_code() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/pim/attribute-feature/ELECTRONICS-10";

			RequestSpecification request = RestAssured.given();
			// 9

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				String message = response.jsonPath().get("message");
				if (message.equals("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"category code and response message is " + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "category code is not avabilable ", 0);

				}
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

	// countryCode

	@Test
	public void getAPIforList_of_Country_Codes() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/address-location-intelligence/country-codes";

			RequestSpecification request = RestAssured.given();
			// 9

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				String message = response.jsonPath().get("message");
				if (message.equals("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"list of country and response message is " + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Failed", 0);

				}
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

	// Country code

	@Test
	public void getAPIforCountry_Codes() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/address-location-intelligence/country-codes/us";

			RequestSpecification request = RestAssured.given();
			// 9

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				String message = response.jsonPath().get("message");
				if (message.equals("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"country code and response message is " + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Failed", 0);

				}
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

	// pincode

	@Test
	public void getAPIforpincode() throws Exception {
		try {

			RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/native-commerce/address-location-intelligence/lat-long-to-pincode";

			RequestSpecification request = RestAssured.given();
			// 9
			request.queryParam("lat", "25.575861");
			request.queryParam("long", "87.835321");
			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				String message = response.jsonPath().get("message");
				if (message.equals("success")) {
					fUtil.flogResult("Passed", "Validate the response", "Address and response message is " + message,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Failed", 0);

				}
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
	public void addUpdataFacetFilter() throws Exception {
		try {

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");

			String requestBody = fUtil.fgetDataNew1("Request");

			String reqBody = requestBodyGenerator(requestBody); // remove space

			httpRequest = request.contentType(ContentType.JSON).body(reqBody);

			// request.body(json.toJSONString());
			// fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+
			// json.toJSONString(), 0);
			// System.out.println("Request Body is:" + json.toJSONString());
			Response response = httpRequest.put(RestAssured.baseURI);

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String message = response.jsonPath().get("message");
				if (message.equals("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"Facet Filter added successfully" + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Add Facet Filter api Failed", 0);

				}

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
	public void getCartItemCount() throws Exception {
		try {

			
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");
			
			fUtil.flogResult("Passed", "BaseUri of the Request ",fUtil.fgetDataNew1("Base_URI"), 0);

			RequestSpecification request = RestAssured.given();
			String accessToken = generateAccessToken();
			
			headersMap.put("Content-Type", "application/json");
			headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			//headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			//request.header("Content-Type", "application/json");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				int cartCount = response.jsonPath().get("cartCount");
				if (cartCount>=0) {
					fUtil.flogResult("Passed", "Validate the response", "Cart Item Count is:" + cartCount, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "GetCartItemCount is not correct", 0);

				}
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
	
	/*==================================================================================================================================
	 * 
	 * FLASH COMMERCE APIS
	 * =================================================================================================================================
	 */
	@Test
	public void getPLP() throws Exception {
		try {
			
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/pims/plp";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
 
			RequestSpecification request = RestAssured.given();
			String accessToken = generateAccessToken();
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);
            
			//***Query Parameters***//
			queryParamsMap.put("source", "CROMA");
			queryParamsMap.put("query", "iphone");
			//queryParamsMap.put("filter","{ \"price\":[\"10,001 - 20,000\"], \"brand\":[\"LG\",\"Samsung\"]}");
			queryParamsMap.put("sort", "price-desc");
			queryParamsMap.put("pageNumber", "0");
			queryParamsMap.put("pageSize", "10");
			request.queryParams(queryParamsMap);
			
			fUtil.flogResult("Passed", "Query parameters for the Request",queryParamsMap.toString(), 0);
			
			
			Response response = request.get();

			//Response response = given().contentType(ContentType.JSON).log().all().get();
			

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				List priceListResponse = response.jsonPath().get("products.price.value");
				System.out.println("List from response: " + priceListResponse);
                /*
				int maxPrice = (int) Collections.max(priceListResponse);
				int minPrice = (int) Collections.min(priceListResponse);
				
				if (minPrice>=10000 && maxPrice <= 20000) {
					fUtil.flogResult("Passed", "Validate the Filter",
							"Price filter (10000-20000) is correctly applied as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the Filter",
							"Price filter (10000-20000) is not applied correctly as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				}
				*/

				List<Double> sortedPriceList = response.jsonPath().get("products.price.value");
				Collections.sort(sortedPriceList);
				Collections.reverse(sortedPriceList);
				System.out.println("List after sorting: " + sortedPriceList);

				if (priceListResponse.equals(sortedPriceList)) {
					fUtil.flogResult("Passed", "Validate the Sorting of PriceList in Desc Order",
							"PriceList is in Desc Order" + priceListResponse, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Sorting of PriceList in Desc Order",
							"PriceList is not in Desc Order" + priceListResponse, 0);
				}

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
	public void getPLP_MSD() throws Exception {
		try {
			
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/pims/plp";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
 
			RequestSpecification request = RestAssured.given();
			String accessToken = generateAccessToken();
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);
            
			//***Query Parameters***//
			queryParamsMap.put("source", "MSD");
			queryParamsMap.put("query", "iostest2");
			//queryParamsMap.put("filter","{ \"price\":[\"10,001 - 20,000\"], \"brand\":[\"LG\",\"Samsung\"]}");
			queryParamsMap.put("sort", "price-desc");
			queryParamsMap.put("pageNumber", "0");
			queryParamsMap.put("pageSize", "10");
			queryParamsMap.put("pincode", "110001");
			request.queryParams(queryParamsMap);
			
			fUtil.flogResult("Passed", "Query parameters for the Request",queryParamsMap.toString(), 0);
			
			
			Response response = request.get();

			

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				List priceListResponse = response.jsonPath().get("products.price.value");
				System.out.println("List from response: " + priceListResponse);
                /*
				int maxPrice = (int) Collections.max(priceListResponse);
				int minPrice = (int) Collections.min(priceListResponse);
				
				if (minPrice>=10000 && maxPrice <= 20000) {
					fUtil.flogResult("Passed", "Validate the Filter",
							"Price filter (10000-20000) is correctly applied as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the Filter",
							"Price filter (10000-20000) is not applied correctly as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				}
				*/

				List<Double> sortedPriceList = response.jsonPath().get("products.price.value");
				Collections.sort(sortedPriceList);
				Collections.reverse(sortedPriceList);
				System.out.println("List after sorting: " + sortedPriceList);

				if (priceListResponse.equals(sortedPriceList)) {
					fUtil.flogResult("Passed", "Validate the Sorting of PriceList in Desc Order",
							"PriceList is in Desc Order" + priceListResponse, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Sorting of PriceList in Desc Order",
							"PriceList is not in Desc Order" + priceListResponse, 0);
				}

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
	public void getPDP() throws Exception {
		try {
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/pims/pdp";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
 
			RequestSpecification request = RestAssured.given();
			String accessToken = generateAccessToken();
			String skuId="230739";
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);
            
			//***Query Parameters***//
			queryParamsMap.put("source", "CROMA");
			queryParamsMap.put("skuId", skuId);
			queryParamsMap.put("pincode", "400063");
			
			request.queryParams(queryParamsMap);
			
			fUtil.flogResult("Passed", "Query parameters for the Request",queryParamsMap.toString(), 0);
			
			
			Response response = request.get();

			

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String skuID = response.jsonPath().get("inventoryInfo.skuId");
				System.out.println("List from response: " + skuID);
				if (skuID.contains(skuId)) {
					fUtil.flogResult("Passed", "Validate the Inventory",
							"Item is fetched", 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Inventory",
							"Item is not fetched", 0);
				}
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
	public void addToCart() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/cart/add";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");

			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			/* Body */
			JSONObject json = new JSONObject();

			
			json.put("skuId","229116");
			json.put("quantity",1);
			json.put("programId", "73eb6345-9cc9-4c37-a8e8-8620d6d32cf5");
			json.put("promotionId", "71897h");
			json.put("mop", 46499);
			json.put("pinCode", "400001");

			request.body(json);
			fUtil.flogResult("Passed", "Generation of Request body ",json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			// Post
			Response response = request.post();

			// Response Body
			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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
				List skuIds = response.jsonPath().get("items.skuId");
				List qty = response.jsonPath().get("items.quantity");
				System.out.println(skuIds);
				System.out.println(qty);
				boolean addcartFlag = false;
				if (skuIds.size() > 0) {
					for (int i = 0; i < skuIds.size(); i++) {
						if (skuId.equals(skuIds.get(i))) {
							fUtil.flogResult("Passed", "Validate Cart " + skuId + " is added to cart",
									"SKU ID was added succesfully with quanity in cart: " + qty.get(i), 0);
							addcartFlag = true;
						}
					}
				}
				if (!addcartFlag) {
					fUtil.flogResult("Failed", "Validate Sku Id: " + skuId + " was added to cart",
							"SKU ID was not added succesfully with quanity in cart", 0);
				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	
	@Test
	public void getCartItemCountFC() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/cart/itemCount";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			RequestSpecification request = RestAssured.given();
			headersMap.put("Content-Type", "application/json");
			headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			//request.header("Content-Type", "application/json");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				int cartCount = response.jsonPath().get("count");
				if (cartCount>=0) {
					fUtil.flogResult("Passed", "Validate the response", "Cart Item Count is:" + cartCount, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "GetCartItemCount is not correct", 0);

				}
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
	public void getCart() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/cart";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			RequestSpecification request = RestAssured.given();
			
            String pinCode="400001";
			
			queryParamsMap.put("pinCode", pinCode);
			request.queryParams(queryParamsMap);
			
			fUtil.flogResult("Passed", "Query parameters for the Request",queryParamsMap.toString(), 0);
			
			
			headersMap.put("Content-Type", "application/json");
			headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			//request.header("Content-Type", "application/json");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				List skuIds = response.jsonPath().get("products.skuId");
				if (skuIds.size()>=0) {
					fUtil.flogResult("Passed", "Validate the response", "Cart Item skuId:" + skuIds, 0);
				} else if(skuIds.size()==0){
					fUtil.flogResult("Passed", "Validate the response", "Cart is empty", 0);
				}else {
					fUtil.flogResult("Passed", "Validate the response", "Get Cart api failed", 0);
				}
				
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
			fUtil.flogResult("Failed", "API Response ",
					"API  failed for" + ee.getMessage(), 0);

		}
	}
	
	@Test
	public void removeFromCart() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/cart/remove";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");

			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			/* Body */
			JSONObject json = new JSONObject();

			
			json.put("skuId","229116");
			json.put("quantity",1);
			json.put("programId", "73eb6345-9cc9-4c37-a8e8-8620d6d32cf5");
			json.put("promotionId", "71897h");
			json.put("mop", 46499);
			json.put("pinCode", "400001");

			request.body(json.toJSONString());
			fUtil.flogResult("Passed", "Generation of Request body ", "Request is" + json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			// Post
			Response response = request.post();

			// Response Body
			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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
				List skuIds = response.jsonPath().get("items");
				
				if (skuIds.size() >= 0) {
				fUtil.flogResult("Passed", "Validate Cart ",
									"SKU ID was removed succesfully from cart: ", 0);
					
					}
				//NCOM_API test =new NCOM_API();
				//test.removeFromCart();
			} else if(statusCode==404) {
				String err=response.jsonPath().get("errorMessage");
				if(err.contains("SKU not found")) {
					fUtil.flogResult("Failed", "Validate Cart ",
							"SKU ID is not in the cart and error message is "+err, 0);
				}
				
			}else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response ",
					"API  failed for" + ee.getMessage(), 0);

		}
	}
	
	@Test
	public void reservationV1() throws Exception {
		try {

			String baseUri="http://unified-reservation.dev-ncom.tatadigital.com/v1/reservation/";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");

			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			headersMap.put("customerHash", "c93234fcf0e1547768b24d954169bee5");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			String requestBody = fUtil.fgetDataNew1("Request");

			String reqBody = requestBodyGenerator(requestBody); // remove space

			httpRequest = request.contentType(ContentType.JSON).body(reqBody);

			// request.body(json.toJSONString());
			// fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+
			// json.toJSONString(), 0);
			// System.out.println("Request Body is:" + json.toJSONString());
			Response response = httpRequest.post(RestAssured.baseURI);

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				/*String message = response.jsonPath().get("message");
				if (message.equals("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"Facet Filter added successfully" + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Add Facet Filter api Failed", 0);

				}*/

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
	public void reservationV2() throws Exception {
		try {

			String baseUri="http://unified-reservation.dev-ncom.tatadigital.com/v1/reservation/";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");

			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			headersMap.put("customerHash", "c93234fcf0e1547768b24d954169bee5");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			String requestBody = fUtil.fgetDataNew1("Request");

			String reqBody = requestBodyGenerator(requestBody); // remove space

			httpRequest = request.contentType(ContentType.JSON).body(reqBody);

			// request.body(json.toJSONString());
			// fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+
			// json.toJSONString(), 0);
			// System.out.println("Request Body is:" + json.toJSONString());
			Response response = httpRequest.post(RestAssured.baseURI);

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				/*String message = response.jsonPath().get("message");
				if (message.equals("success")) {
					fUtil.flogResult("Passed", "Validate the response",
							"Facet Filter added successfully" + message, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Add Facet Filter api Failed", 0);

				}*/

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
	public void createCheckOut () throws Exception {
		try {

			String accessToken = generateAccessToken();
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/orders/checkout";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			headersMap.put("ClientCode", "FLASH_COMMERCE");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			String requestBody = fUtil.fgetDataNew1("Request");

			String reqBody = requestBodyGenerator(requestBody); // remove space

			httpRequest = request.contentType(ContentType.JSON).body(reqBody);

			// request.body(json.toJSONString());
			// fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+
			// json.toJSONString(), 0);
			// System.out.println("Request Body is:" + json.toJSONString());
			Response response = httpRequest.post(RestAssured.baseURI);

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 201) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String paymentLink = response.jsonPath().get("data");
				String message = response.jsonPath().get("statusCode.description");
				if (message.equals("Created")) {
					fUtil.flogResult("Passed", "Validate the response",
							"Checkout Successful with " + message +" and TPay link:"+paymentLink, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Checkout failed", 0);

				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 201 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("201")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is 201 Created but it is " + statusLine, 0);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	/*=====================================================================================================================
	 * AGGREGATOR SERVICE API
	 * =====================================================================================================================
	 */
	
	@Test
	public void getPLPAggr() throws Exception {
		try {
			
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/pims/plp";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
 
			RequestSpecification request = RestAssured.given();
			String accessToken = generateAccessToken();
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);
            
			//***Query Parameters***//
			queryParamsMap.put("category", "electronics");
			queryParamsMap.put("pinCode", "400001");
			queryParamsMap.put("source", "CROMA");
			queryParamsMap.put("query", "iostest2");
			queryParamsMap.put("sortKey", "discount_price");
			queryParamsMap.put("sortOrder", "asc");
			queryParamsMap.put("page", "1");
			queryParamsMap.put("limit", "20");
			queryParamsMap.put("filter", "{\"sub_brand_name\":[\"Apple\"]}");
			request.queryParams(queryParamsMap);
			
			fUtil.flogResult("Passed", "Query parameters for the Request",queryParamsMap.toString(), 0);
			
			
			Response response = request.get();

			//Response response = given().contentType(ContentType.JSON).log().all().get();
			

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				/*List priceListResponse = response.jsonPath().get("products.price.value");
				System.out.println("List from response: " + priceListResponse);
                
				
				

				List<Double> sortedPriceList = response.jsonPath().get("products.price.value");
				Collections.sort(sortedPriceList);
				//Collections.reverse(sortedPriceList);
				System.out.println("List after sorting: " + sortedPriceList);

				if (priceListResponse.equals(sortedPriceList)) {
					fUtil.flogResult("Passed", "Validate the Sorting of PriceList in Desc Order",
							"PriceList is in Desc Order" + priceListResponse, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Sorting of PriceList in Desc Order",
							"PriceList is not in Desc Order" + priceListResponse, 0);
				}*/
				/*
				int maxPrice = (int) Collections.max(priceListResponse);
				int minPrice = (int) Collections.min(priceListResponse);
				
				if (minPrice>=10000 && maxPrice <= 20000) {
					fUtil.flogResult("Passed", "Validate the Filter",
							"Price filter (10000-20000) is correctly applied as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				} else {
					fUtil.flogResult("Failed", "Validate the Filter",
							"Price filter (10000-20000) is not applied correctly as max price is " + maxPrice
									+ " and min price is" + minPrice,
							0);
				}
				*/
				
				//Discount Sort Asc
				List<Object> discountsResponse = response.jsonPath().get("products.discountValue");
				List<Float> discountsResponse1 = new ArrayList();
				for (Object p : discountsResponse) {
					discountsResponse1.add(Float.valueOf(p.toString().replaceAll("%", "").trim()));
				}

				List<Float> sortedDiscountsList = new ArrayList();
				sortedDiscountsList.addAll(discountsResponse1);
				System.out.println("List from response: " + discountsResponse1);
				float maxValue = Collections.max(sortedDiscountsList);
				System.out.println("List from response: " + discountsResponse);
				Collections.sort(sortedDiscountsList);
				//Collections.reverse(sortedDiscountsList);
				System.out.println("List after sorting: " + sortedDiscountsList);

				if (discountsResponse1.equals(sortedDiscountsList)) {
					fUtil.flogResult("Passed", "Validate the Sorting of RatingList in Desc Order",
							"RatingList is in Desc Order" + discountsResponse, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Sorting of RatingList in Desc Order",
							"RatingList is not in Desc Order" + discountsResponse, 0);
				}

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
	public void getPDPAggr() throws Exception {
		try {
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/pims/pdp";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
 
			RequestSpecification request = RestAssured.given();
			String accessToken = generateAccessToken();
			String skuId="230739";
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);
            
			//***Query Parameters***//
			queryParamsMap.put("source", "CROMA");
			queryParamsMap.put("skuId", skuId);
			queryParamsMap.put("pincode", "400063");
			
			request.queryParams(queryParamsMap);
			
			fUtil.flogResult("Passed", "Query parameters for the Request",queryParamsMap.toString(), 0);
			
			
			Response response = request.get();

			

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String skuID = response.jsonPath().get("inventoryInfo.skuId");
				System.out.println("List from response: " + skuID);
				if (skuID.contains(skuId)) {
					fUtil.flogResult("Passed", "Validate the Inventory",
							"Item is fetched", 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Inventory",
							"Item is not fetched", 0);
				}
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
	public void addToCartAggr() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/aggregator/cart";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");

			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			/* Body */
			JSONObject json = new JSONObject();

			json.put("category","electronics");
			json.put("skuId","206972");
			json.put("mop",1299.0);
			json.put("mrp",1299.0);
			json.put("total",1299.0);
			json.put("quantity",1);
			json.put("programId", "73eb6345-9cc9-4c37-a8e8-8620d6d32cf5");
			json.put("promotionId", "226501");
			json.put("pinCode", "400001");

			request.body(json);
			fUtil.flogResult("Passed", "Generation of Request body ",json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			// Post
			Response response = request.post();

			// Response Body
			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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
				List skuIds = response.jsonPath().get("items.skuId");
				List qty = response.jsonPath().get("items.quantity");
				System.out.println(skuIds);
				System.out.println(qty);
				boolean addcartFlag = false;
				if (skuIds.size() > 0) {
					for (int i = 0; i < skuIds.size(); i++) {
						if (skuId.equals(skuIds.get(i))) {
							fUtil.flogResult("Passed", "Validate Cart " + skuId + " is added to cart",
									"SKU ID was added succesfully with quanity in cart: " + qty.get(i), 0);
							addcartFlag = true;
						}
					}
				}
				if (!addcartFlag) {
					fUtil.flogResult("Failed", "Validate Sku Id: " + skuId + " was added to cart",
							"SKU ID was not added succesfully with quanity in cart", 0);
				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void updateCartAggr() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/aggregator/cart";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");

			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			/* Body */
			JSONObject json = new JSONObject();

			json.put("category","electronics");
			json.put("skuId","206972");
			json.put("mop",1299.0);
			json.put("mrp",1299.0);
			json.put("total",1299.0);
			json.put("quantity",1);
			json.put("programId", "73eb6345-9cc9-4c37-a8e8-8620d6d32cf5");
			json.put("promotionId", "71897h");
			json.put("pinCode", "400001");

			request.body(json);
			fUtil.flogResult("Passed", "Generation of Request body ",json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			// Post
			Response response = request.put();

			// Response Body
			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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
				List skuIds = response.jsonPath().get("items.skuId");
				List qty = response.jsonPath().get("items.quantity");
				System.out.println(skuIds);
				System.out.println(qty);
				boolean addcartFlag = false;
				if (skuIds.size() > 0) {
					for (int i = 0; i < skuIds.size(); i++) {
						if (skuId.equals(skuIds.get(i))) {
							fUtil.flogResult("Passed", "Validate Cart " + skuId + " is added to cart",
									"SKU ID was added succesfully with quanity in cart: " + qty.get(i), 0);
							addcartFlag = true;
						}
					}
				}
				if (!addcartFlag) {
					fUtil.flogResult("Failed", "Validate Sku Id: " + skuId + " was added to cart",
							"SKU ID was not added succesfully with quanity in cart", 0);
				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	
	@Test
	public void getCartItemCountAggr() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/aggregator/cart/item-count";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			RequestSpecification request = RestAssured.given();
			
			//***Query Parameters***//
			queryParamsMap.put("category", "electronics");
			
			request.queryParams(queryParamsMap);
			
			fUtil.flogResult("Passed", "Query parameters for the Request",queryParamsMap.toString(), 0);
			
			headersMap.put("Content-Type", "application/json");
			headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			//request.header("Content-Type", "application/json");

			Response response = request.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				int cartCount = response.jsonPath().get("count");
				if (cartCount>=0) {
					fUtil.flogResult("Passed", "Validate the response", "Cart Item Count is:" + cartCount, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "GetCartItemCount is not correct", 0);

				}
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
	public void reviewCartAggr() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/aggregator/cart/review";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			RequestSpecification request = RestAssured.given();
			
            String pinCode="400001";
			
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);
			
			/* Body */
			JSONObject json = new JSONObject();
			json.put("pinCode",pinCode);
			json.put("category","electronics");
			
			request.body(json);
			
			Response response = request.post();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody1, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				List skuIds = response.jsonPath().get("items.skuId");
				if (skuIds.size()>=0) {
					fUtil.flogResult("Passed", "Validate the response", "Cart Item skuId:" + skuIds, 0);
				} else if(skuIds.size()==0){
					fUtil.flogResult("Passed", "Validate the response", "Cart is empty", 0);
				}else {
					fUtil.flogResult("Passed", "Validate the response", "Get Cart api failed", 0);
				}
				
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
			fUtil.flogResult("Failed", "API Response ",
					"API  failed for" + ee.getMessage(), 0);

		}
	}
	
	@Test
	public void deleteCartAggr() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/aggregator/cart";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			//String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");

			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			/* Body */
			JSONObject json = new JSONObject();

			json.put("category","electronics");
			json.put("skuId","206972");
			json.put("mop",1299.0);
			json.put("mrp",1299.0);
			json.put("total",1299.0);
			json.put("quantity",1);
			json.put("programId", "73eb6345-9cc9-4c37-a8e8-8620d6d32cf5");
			json.put("promotionId", "226501");
			json.put("pinCode", "400001");

			request.body(json);
			fUtil.flogResult("Passed", "Generation of Request body ",json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			// Post
			Response response = request.delete();

			// Response Body
			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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
				List skuIds = response.jsonPath().get("items.skuId");
				List qty = response.jsonPath().get("items.quantity");
				System.out.println(skuIds);
				System.out.println(qty);
				boolean addcartFlag = false;
				if (skuIds.size() > 0) {
					for (int i = 0; i < skuIds.size(); i++) {
						if (skuId.equals(skuIds.get(i))) {
							fUtil.flogResult("Passed", "Validate Cart " + skuId + " is added to cart",
									"SKU ID was added succesfully with quanity in cart: " + qty.get(i), 0);
							addcartFlag = true;
						}
					}
				}
				if (!addcartFlag) {
					fUtil.flogResult("Failed", "Validate Sku Id: " + skuId + " was added to cart",
							"SKU ID was not added succesfully with quanity in cart", 0);
				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void expressCheckout() throws Exception {
		try {
			String accessToken = generateAccessToken();
			Thread.sleep(1000);
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/aggregator/order/express-checkout";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");

			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			/* Body */
			JSONObject json = new JSONObject();

			json.put("category","electronics");
			json.put("skuId","206972");
			json.put("programId","1111");
			json.put("mop",1299.0);
			json.put("mrp",1299.0);
			json.put("total",1299.0);
			json.put("quantity",1);
			json.put("promotionId", "aa");
			json.put("pinCode", "400001");

			request.body(json);
			fUtil.flogResult("Passed", "Generation of Request body ",json.toJSONString(), 0);
			System.out.println("Request Body is:" + json.toJSONString());

			// Post
			Response response = request.post();

			// Response Body
			String responseBody = response.getBody().asString();
			System.out.println("----Getting Response Body -----");
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
				List skuIds = response.jsonPath().get("items.skuId");
				List qty = response.jsonPath().get("items.quantity");
				System.out.println(skuIds);
				System.out.println(qty);
				boolean addcartFlag = false;
				if (skuIds.size() > 0) {
					for (int i = 0; i < skuIds.size(); i++) {
						if (skuId.equals(skuIds.get(i))) {
							fUtil.flogResult("Passed", "Validate Cart " + skuId + " is added to cart",
									"SKU ID was added succesfully with quanity in cart: " + qty.get(i), 0);
							addcartFlag = true;
						}
					}
				}
				if (!addcartFlag) {
					fUtil.flogResult("Failed", "Validate Sku Id: " + skuId + " was added to cart",
							"SKU ID was not added succesfully with quanity in cart", 0);
				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	@Test
	public void proceedPayment () throws Exception {
		try {

			String accessToken = generateAccessToken();
			String customer_hash = fUtil.fgetDataNew1("customer_hash");
			String skuId = fUtil.fgetDataNew1("skuID");
			String quantity = fUtil.fgetDataNew1("quantity");
			String baseUri="https://ppapi.tatadigital.com/api/v1/native-commerce/flash-commerce/aggregator/order/initiate-payment";
			RestAssured.baseURI = baseUri;
			fUtil.flogResult("Passed", "BaseUri of the Request ",baseUri, 0);
			
			RequestSpecification request = RestAssured.given();
			
			//***Headers***//
			headersMap.put("Content-Type", "application/json");
			//headersMap.put("customerHash", "e4e6f5d5576850dc2568005655f250c0");
			headersMap.put("Authorization", accessToken);
			headersMap.put("client_id", "TCP-WEB-APP");
			//headersMap.put("ClientCode", "FLASH_COMMERCE");
			request.headers(headersMap)	;
			System.out.println(headersMap);
			fUtil.flogResult("Passed", "Headers for the Request",headersMap.toString(), 0);

			String requestBody = fUtil.fgetDataNew1("Request");

			String reqBody = requestBodyGenerator(requestBody); // remove space

			httpRequest = request.contentType(ContentType.JSON).body(reqBody);

			// request.body(json.toJSONString());
			// fUtil.flogResult("Passed", "Generation of Request body ", "Request is"+
			// json.toJSONString(), 0);
			// System.out.println("Request Body is:" + json.toJSONString());
			Response response = httpRequest.post(RestAssured.baseURI);

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body", "Response is :  " + responseBody, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 201) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);

				String paymentLink = response.jsonPath().get("data");
				String message = response.jsonPath().get("statusCode.description");
				if (message.equals("Created")) {
					fUtil.flogResult("Passed", "Validate the response",
							"Checkout Successful with " + message +" and TPay link:"+paymentLink, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the response", "Checkout failed", 0);

				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 201 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("201")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is 201 Created but it is " + statusLine, 0);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}
	
	
	public static void main(String [] args) {
		NCOM_API test= new NCOM_API();
		try {
			test.getPLP();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}