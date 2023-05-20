package com.QA.TestApp.Testcases.API;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.QA.TestApp.Utilities.BaseScript;
import com.QA.TestApp.Utilities.BrowserFactory;
import com.QA.TestApp.Utilities.DBConnection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class ExecuteAPI extends BaseScript {
	private static final HashMap Header1 = null;
	static RequestSpecification httpRequest;
	static String svalidation = "";
	static String svalidationCase = "";
	static String header1 = "", header2 = "", header3 = "", header4 = "", responseBody = "";
	static HashMap<String, String> callchainreqfields = new HashMap<String, String>();
	static String baseUriAuth = null;
	static String baseUriToken = null;
	static String h_clientId = null;
	static String h_secretKey = null;
	static String code_challenge = null;
	static String countryCode = null;
	static String mobileNumber = null;
	static String password = null;
	static String code_verifier = null;
	static String bearerToken = "";
	String aurl = "";

	@Test
	void mpostAPI() {
		String aurl = "";
		try {
			logger.info("Executing testcase " + strScenarioName);
			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
			// String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mpostAPI : Base_URI : " + aurl);
			Response response = postapi(aurl, requestBody);
			checkAPIResponse(response, "");
			checkAPIResponseInDetail(response);
			System.out.println("mpostAPI : check and call validation method");
			// check if any validation
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}
				// ExecuteAPI.class.getMethod(smethod, null);
				// This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}

		} catch (Exception ee) {
			logger.error("mpostAPI has failed for " + strScenarioName + " due to " + ee.getClass().getName());
			Arrays.asList(ee.getStackTrace()).forEach(x -> logger.error(x.toString()));
		}

	}

	@Test
	void mputAPI() {
		String aurl = "";
		try {
			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
			// String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mpostAPI : Base_URI : " + aurl);
			Response response = putapi(aurl, requestBody);
			checkAPIResponse(response, "");
			checkAPIResponseInDetail(response);
			System.out.println("mpostAPI : check and call validation method");
			// check if any validation
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}

				// ExecuteAPI.class.getMethod(smethod, null);
				// This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}

	}

	@Test
	public void mgetAPI() {
		String aurl = "";
		try {
			logger.info("Executing testcase " + strScenarioName);
			aurl = fUtil.fgetDataNew1("Base_URI");
			// String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mgetAPI : Base_URI : " + aurl);
			Response response = getapi(aurl);
			checkAPIResponse(response, "");
			checkAPIResponseInDetail(response);
			System.out.println("mgetAPI : check and call validation method");
			// check if any validation
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}
				System.out.println("svalidationCase : " + svalidationCase);
				// ExecuteAPI.class.getMethod(smethod, null);
				// This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
	}

	@Test
	public void mcallChain() {
		String surl = "", requestBody = "", respvalues = "";
		Response lastResponse = null;
		try {
			logger.info("Executing testcase " + strScenarioName);
			String scallchain = fUtil.fgetDataNew1("CallChainSeq");
			System.out.println("mcallChain : call chain sequence : " + scallchain);
			String[] acallchainseq = scallchain.split(",");

			// for loop to execute call chain
			for (int c = 0; c < acallchainseq.length; c++) {
				Response response = null;
				if (c == 0) {
					surl = fUtil.fgetDataNew1("Base_URI");
					requestBody = fUtil.fgetDataNew1("Request");
					// respvalues=fUtil.fgetDataNew1("Responsefields");
					respvalues = readData("Responsefields");
				} else {
					surl = fUtil.fgetDataNew1("Base_URI" + (c + 1));
					// requestBody = fUtil.fgetDataNew1("Request"+(c+1));
					requestBody = readData("Request" + (c + 1));
					// respvalues=fUtil.fgetDataNew1("Responsefields"+(c+1));
					respvalues = readData("Responsefields" + (c + 1));

				}
				System.out.println("mcallchain : url" + c + " " + surl);

				if (acallchainseq[c].equalsIgnoreCase("get")) {
					response = getapi(surl);

				} else if (acallchainseq[c].equalsIgnoreCase("post")) {
					response = postapi(surl, requestBody);

				} else if (acallchainseq[c].equalsIgnoreCase("put")) {
					response = putapi(surl, requestBody);
				} else if (acallchainseq[c].equalsIgnoreCase("delete")) {
					response = deleteapi(surl, requestBody);

				} else {
					System.err.println("mcallchain : Sequence not given properly in data");
					break;
				}
				System.out.println("mcallchain : Call API response check method");
				lastResponse = response;
				checkAPIResponse(response, respvalues);
				surl = "";
			}

			checkAPIResponseInDetail(lastResponse);

			// check if any validation
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllBlank(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}

			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	// writing post method for API which will return response as it is..
	public static Response postapi(String apiurl, String requestBody) {
		Response response = null;
		String dynamic_value1;
		try {
			// Specify base URI
			
			if (apiurl.contains("dynamic_value1")) {
				dynamic_value1 = fUtil.fgetDataNew1("dynamic_value1");
				if (dynamic_value1.contains("&")) {
					dynamic_value1 = callchainreqfields.get(dynamic_value1.replace("&", ""));
					apiurl = apiurl.replace("dynamic_value1", dynamic_value1);

				} else if (dynamic_value1.contains("token")) {
					apiurl = apiurl.replace("dynamic_value1", bearerToken);

				} else {
					apiurl = apiurl.replace("dynamic_value1", fUtil.fgetDataNew1("dynamic_value1"));
				}

			}

			RestAssured.baseURI = apiurl;
			System.out.println("API url : " + apiurl + "API Req - " + requestBody);
			String statics = "", finalreq = "";

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
							case "method:randombundleiduniversalcart":
								
								data = randomBundleIDUniversalCart();
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
			} else {
				finalreq = callchainreqfields.get(requestBody.toLowerCase());
			}

			System.out.println("Final req from code - " + finalreq);
			// -------json modify
			String jsonString = finalreq;

//-------------------------------------------Authorization--------------------------------

//			} 
			// if(!StringUtils.trimToEmpty(fUtil.fgetDataNew1("username")).isEmpty())
			// {
			// String auth0=fUtil.fgetDataNew1("username");
			// String auth1=fUtil.fgetDataNew1("password");
			// System.out.println(auth0);
			// System.out.println(auth1);
			//
			// httpRequest=RestAssured.given().contentType(ContentType.JSON).auth().basic(auth0,auth1).body(jsonString);
			// }

			// baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriAuth = readData("BaseUriAuth");
			header1 = "";
			if (!StringUtils.trimToEmpty(baseUriAuth).isEmpty()) {
				tokengeneration();
				header1 = "Authorization:" + bearerToken;
				System.out.println("Header1 : " + header1);
			} else {
				header1 = fUtil.fgetDataNew1("Header1");
				// header1 = readData("Header1");
			}

			// header1=fUtil.fgetDataNew1("Header1");
			if (!StringUtils.trimToEmpty(header1).isEmpty()) {
				System.out.println("Header1 : " + header1);

				header2 = fUtil.fgetDataNew1("Header2");
				header2 = readData("Header2");

				if (!StringUtils.trimToEmpty(header2).isEmpty()) {
					System.out.println("Header2 : " + header2);

					if (header2.contains("&")) {
						String temp = header2.split("&")[0] + callchainreqfields.get(header2.split("&")[1]);
						header2 = temp;
					}

					// header3 = fUtil.fgetDataNew1("Header3");
					header3 = readData("Header3");

					if (!StringUtils.trimToEmpty(header3).isEmpty()) {
						System.out.println("Header3 : " + header3);

						if (header3.contains("&")) {
							String temp = header3.split("&")[0] + callchainreqfields.get(header3.split("&")[1]);
							header3 = temp;
						}

						// header4 = fUtil.fgetDataNew1("Header4");
						header4 = readData("Header4");

						if (!StringUtils.trimToEmpty(header4).isEmpty()) {
							System.out.println("Header4 : " + header4);

							if (header4.contains("&")) {
								String temp = header4.split("&")[0] + callchainreqfields.get(header4.split("&")[1]);
								header4 = temp;
							}
							// req with 4 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON)
									.headers(header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
											header2.split(":")[1], header3.split(":")[0], header3.split(":")[1],
											header4.split(":")[0], header4.split(":")[1])
									.body(jsonString);

						} else {
							// req with 3 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON)
									.headers(header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
											header2.split(":")[1], header3.split(":")[0], header3.split(":")[1])
									.body(jsonString);
						}
					} else {
						// req with 2 headers data
						httpRequest = RestAssured
								.given().contentType(ContentType.JSON).headers(header1.split(":")[0],
										header1.split(":")[1], header2.split(":")[0], header2.split(":")[1])
								.body(jsonString);
					}

				} else {
					// req with single header
					httpRequest = RestAssured.given().contentType(ContentType.JSON)
							.headers(header1.split(":")[0], header1.split(":")[1]).body(jsonString);

				}
			} else {
				httpRequest = RestAssured.given().contentType(ContentType.JSON).body(jsonString);
			}
			response = httpRequest.post(RestAssured.baseURI);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return response;

	}

	public static Response putapi(String apiurl, String requestBody) {
		Response response = null;
		String dynamic_value1;
		try {
			
			if (apiurl.contains("dynamic_value1")) {
				dynamic_value1 = fUtil.fgetDataNew1("dynamic_value1");
				if (dynamic_value1.contains("&")) {
					System.out.println("aaa"+dynamic_value1);
					dynamic_value1 = dynamic_value1.substring(1);
					//String[] areqbody = dynamic_value1.split("&");
					dynamic_value1 = dynamic_value1.replace("&", "");
					//System.out.println(areqbody[1]);
					dynamic_value1 = callchainreqfields.get(dynamic_value1);
					System.out.println(dynamic_value1);
					apiurl = apiurl.replace("dynamic_value1", dynamic_value1);

				} else if (dynamic_value1.contains("token")) {
					apiurl = apiurl.replace("dynamic_value1", bearerToken);

				} else {
					apiurl = apiurl.replace("dynamic_value1", fUtil.fgetDataNew1("dynamic_value1"));
				}

			}
			// Specify base URI
			RestAssured.baseURI = apiurl;
			System.out.println("API url : " + apiurl + "API Req - " + requestBody);
			String statics = "", finalreq = "";

			// for UPI
			if (requestBody.contains("%")) {
				String[] areqbody = requestBody.split("%");

				statics = Arrays.asList(areqbody).stream().map(value -> { // (() -> {method implementation})

					if (value.replace(" ", "").endsWith(":\"") || value.replace(" ", "").endsWith("}")
							|| value.replaceAll("[\\n\\t ]", "").endsWith(":")) {
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
							case "method:randomMobileNumber":
								data = gmethods.randomMobileNumber(9, "Numeric", "");
								break;
							case "method:randomnumberOrderUniversalCart":
								data = randomnumberOrderUniversalCart();
								break;

//							case "method:randomalphastring": 
//								try {
//									data = gmethods.randomstring(5, "Alpha", "");
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
//								   break;

							}
						} else if (data.contains("&")) {
							data = callchainreqfields.get((data.replace("&", "")));
						}
						// *********Added code for points to be more than response received
						// data*******//
						else if (data.contains("^")) {
							data = callchainreqfields.get((data.replace("^", ""))) + "1";
						} else if (data.startsWith("~")) {
							data = data.substring(1);
						}
						return data;

					}
				})

						.collect(Collectors.joining());

				finalreq = statics;
			} else {
				finalreq = callchainreqfields.get(requestBody.toLowerCase());
			}
			System.out.println("Final req from code - " + finalreq);
			// -------json modify
			String jsonString = finalreq;
			if (!jsonString.isEmpty()) {
				System.out.println("Before:\n" + jsonString);
				jsonString = jsonString.replaceAll("([\\w]+)[ ]*=", "\"$1\" ="); // to quote before = value
				jsonString = jsonString.replaceAll("=[ ]*([\\w@\\.]+)", "= \"$1\""); // to quote after = value, add
				// special character as needed
				// to the exclusion list in
				// regex
				jsonString = jsonString.replaceAll("=[ ]*\"([\\d]+)\"", "= $1"); // to un-quote decimal value
				jsonString = jsonString.replaceAll("\"true\"", "true"); // to un-quote boolean
				jsonString = jsonString.replaceAll("\"false\"", "false"); // to un-quote boolean

				System.out.println("===============================");
				System.out.println("After:\n" + jsonString);
				fUtil.flogResult("Pass", "Request Body", "Request Body is " + jsonString, 0);
			}

			// baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriAuth = readData("BaseUriAuth");
			header1 = "";
			if (!StringUtils.trimToEmpty(baseUriAuth).isEmpty()) {
				tokengeneration();
				header1 = "Authorization:" + bearerToken;
				System.out.println("Header1 : " + header1);
			} else {
				// header1 = fUtil.fgetDataNew1("Header1");
				header1 = readData("Header1");
			}

			if (!StringUtils.trimToEmpty(header1).isEmpty()) {
				System.out.println("Header1 : " + header1);

				// header2=fUtil.fgetDataNew1("Header2");
				header2 = readData("Header2");

				if (!StringUtils.trimToEmpty(header2).isEmpty()) {
					System.out.println("Header2 : " + header2);

					if (header2.contains("&")) {
						String temp = header2.split("&")[0] + callchainreqfields.get(header2.split("&")[1]);
						header2 = temp;
					}

					// header3 = fUtil.fgetDataNew1("Header3");
					header3 = readData("Header3");

					if (!StringUtils.trimToEmpty(header3).isEmpty()) {
						System.out.println("Header3 : " + header3);

						if (header3.contains("&")) {
							String temp = header3.split("&")[0] + callchainreqfields.get(header3.split("&")[1]);
							header3 = temp;
						}

						// header4 = fUtil.fgetDataNew1("Header4");
						header4 = readData("Header4");

						if (!StringUtils.trimToEmpty(header4).isEmpty()) {
							System.out.println("Header4 : " + header4);

							if (header4.contains("&")) {
								String temp = header4.split("&")[0] + callchainreqfields.get(header4.split("&")[1]);
								header4 = temp;
							}

							// req with 4 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON)
									.headers(header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
											header2.split(":")[1], header3.split(":")[0], header3.split(":")[1],
											header4.split(":")[0], header4.split(":")[1])
									.body(jsonString);

						} else {
							// req with 3 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON)
									.headers(header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
											header2.split(":")[1], header3.split(":")[0], header3.split(":")[1])
									.body(jsonString);
						}
					} else {
						// req with 2 headers data
						httpRequest = RestAssured
								.given().contentType(ContentType.JSON).headers(header1.split(":")[0],
										header1.split(":")[1], header2.split(":")[0], header2.split(":")[1])
								.body(jsonString);
					}

				} else {
					// req with single header
					httpRequest = RestAssured.given().contentType(ContentType.JSON)
							.headers(header1.split(":")[0], header1.split(":")[1]).body(jsonString);
				}
			} else {
				httpRequest = RestAssured.given().contentType(ContentType.JSON).body(jsonString);
			}
			response = httpRequest.put(RestAssured.baseURI);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return response;

	}

	public static Response getapi(String apiurl) {
		Response response = null;
		String dynamic_value1;
		String dynamic_value2 = "";
		String dynamic_value3 = "";
		try {
			System.out.println("API url : " + apiurl);

			if (apiurl.contains("dynamic_value1")) {
				dynamic_value1 = fUtil.fgetDataNew1("dynamic_value1");
				if (dynamic_value1.contains("&")) {
					dynamic_value1 = callchainreqfields.get(dynamic_value1.replace("&", ""));
					System.out.println(dynamic_value1);
					apiurl = apiurl.replace("dynamic_value1", dynamic_value1);
					System.out.println(apiurl);

				} else if (dynamic_value1.contains("token")) {
					apiurl = apiurl.replace("dynamic_value1", bearerToken);

				} else {
					apiurl = apiurl.replace("dynamic_value1", fUtil.fgetDataNew1("dynamic_value1"));
				}

			}

			if (apiurl.contains("dynamic_value2")) {
				dynamic_value2 = fUtil.fgetDataNew1("dynamic_value2");
				if (dynamic_value2.contains("&")) {
					dynamic_value2 = callchainreqfields.get(dynamic_value2.replace("&", ""));
					apiurl = apiurl.replace("dynamic_value2", dynamic_value2);

				} else {
					apiurl = apiurl.replace("dynamic_value2", fUtil.fgetDataNew1("dynamic_value2"));
				}
			}
			// System.out.println(fUtil.fgetDataNew1("dynamic_value2"));
			// apiurl=apiurl.replace("dynamic_value2",
			// fUtil.fgetDataNew1("dynamic_value2"));
			// }else if(dynamic_value2.contains("&")) {
			// dynamic_value2=callchainreqfields.get(dynamic_value2.replace("&", ""));
			// }

			if (apiurl.contains("dynamic_value3")) {
				dynamic_value3 = fUtil.fgetDataNew1("dynamic_value3");
				if (dynamic_value3.contains("&")) {
					dynamic_value3 = callchainreqfields.get(dynamic_value3.replace("&", ""));
					apiurl = apiurl.replace("dynamic_value3", dynamic_value3);

				} else {
					apiurl = apiurl.replace("dynamic_value3", fUtil.fgetDataNew1("dynamic_value3"));
				}
			}
			System.out.println("Final URL is : " + apiurl);
			RestAssured.baseURI = apiurl;

			// baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriAuth = readData("BaseUriAuth");
			header1 = "";
			if (!StringUtils.trimToEmpty(baseUriAuth).isEmpty()) {
				tokengeneration();
				header1 = "Authorization:" + bearerToken;
				System.out.println("Header1 : " + header1);
			} else {
				// header1 = fUtil.fgetDataNew1("Header1");
				header1 = readData("Header1");
			}

			if (!StringUtils.trimToEmpty(header1).isEmpty()) {
				System.out.println("Header1 : " + header1);

				// header2=fUtil.fgetDataNew1("Header2");
				header2 = readData("Header2");

				if (!StringUtils.trimToEmpty(header2).isEmpty()) {
					System.out.println("Header2 : " + header2);

					if (header2.contains("&")) {
						String temp = header2.split("&")[0] + callchainreqfields.get(header2.split("&")[1]);
						header2 = temp;
					}

					// header3 = fUtil.fgetDataNew1("Header3");
					header3 = readData("Header3");

					if (!StringUtils.trimToEmpty(header3).isEmpty()) {
						System.out.println("Header3 : " + header3);

						if (header3.contains("&")) {
							String temp = header3.split("&")[0] + callchainreqfields.get(header3.split("&")[1]);
							header3 = temp;
						}

						// header4 = fUtil.fgetDataNew1("Header4");
						header4 = readData("Header4");

						if (!StringUtils.trimToEmpty(header4).isEmpty()) {
							System.out.println("Header4 : " + header4);

							if (header4.contains("&")) {
								String temp = header4.split("&")[0] + callchainreqfields.get(header4.split("&")[1]);
								header4 = temp;
							}

							// req with 4 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON).headers(
									header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
									header2.split(":")[1], header3.split(":")[0], header3.split(":")[1],
									header4.split(":")[0], header4.split(":")[1]);

						} else {
							// req with 3 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON).headers(
									header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
									header2.split(":")[1], header3.split(":")[0], header3.split(":")[1]);
						}
					} else {
						// req with 2 headers data
						httpRequest = RestAssured.given().contentType(ContentType.JSON).headers(header1.split(":")[0],
								header1.split(":")[1], header2.split(":")[0], header2.split(":")[1]);
					}

				} else {
					// req with single header
					httpRequest = RestAssured.given().contentType(ContentType.JSON).headers(header1.split(":")[0],
							header1.split(":")[1]);
				}
			} else {
				httpRequest = RestAssured.given().contentType(ContentType.JSON);
			}
			response = httpRequest.get(RestAssured.baseURI);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return response;

	}

	public static void checkAPIResponse(Response response, String reqvalues) throws Exception {
		try {
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is : " + responseBody);
			fUtil.flogResult("Pass", "Check API response", "Response Received is" + responseBody, 0);

			long rsTime = response.timeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time is : " + rsTime);
			fUtil.flogResult("Pass", "Check for the Response time", "Response time is: " + rsTime, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is : " + statusCode);
			if (statusCode == 200 || statusCode == 201) {
				fUtil.flogResult("Pass", "Validate the Status Code", "Status Code is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.toUpperCase().contains("HTTP/1.1 20")) {
				fUtil.flogResult("Pass", "Validate the Status Line", "Status Line is " + statusLine, 0);
				if (responseBody.contains("success")) {
					String sactres = responseBody.split("success")[1].split(",")[0];
					// check if message word present if yes then extract message and append in
					// report
					// String smsg = responseBody.split("message")[1].split(",")[0];
					if (sactres.equalsIgnoreCase("false")) {
						fUtil.flogResult("Failed", "API response status is fail", "Status " + sactres, 0);
					} else {
						fUtil.flogResult("Pass", "API response status is pass", "Status " + sactres, 0);
					}
				}
				
				String respreceived = responseBody;
				// if req field is having data and same will be used in call chain only
				if (!StringUtils.isAllEmpty(reqvalues)) {
					// for UPI
					String[] responsekeys = reqvalues.split(",");
					if (responsekeys[0].toLowerCase().contains("&request")) {
						callchainreqfields.put(responsekeys[0].toLowerCase(), responseBody);
					} 
					else if (responsekeys[0].equals(" ")) {
						System.out.println("Last Decline Message");
					}
					else {
						for (int i = 0; i < responsekeys.length; i++) {// for(String Tempkey:responseKeys) {

							String Tempkey = responsekeys[i];
							String key = "";
							int count = 1;
							if (Tempkey.contains(":")) {
								key = Arrays.asList(Tempkey.split(":")).get(0);
								count = Integer.valueOf(Arrays.asList(Tempkey.split(":")).get(1));
							} else {
								key = Tempkey;
							}
							String splitresp = Arrays.asList(respreceived.split(key + "\":")).get(count);
							String commaSubString = Arrays.asList(splitresp.split(",")).get(0).trim();
							String curlySub = Arrays.asList(splitresp.split("}")).get(0);

							// to check if intermediate column name to be input is diffent from response
							// param
							if (Tempkey.split(":").length == 3) {
								key = Tempkey.split(":")[2].trim();
							}
							if (commaSubString.length() < curlySub.length()) {
								callchainreqfields.put(key,
										(commaSubString.startsWith("\"") && commaSubString.endsWith("\""))
												? commaSubString.substring(1, commaSubString.length() - 1)
												: commaSubString);
							} else {
								callchainreqfields.put(key,
										(curlySub.startsWith("\"") && curlySub.endsWith("\""))
												? curlySub.substring(1, curlySub.length() - 1)
												: curlySub);
							}
							
						}
					}
					System.out.println("Done");
				}
				
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			fUtil.flogResult("Failed", "Exception in checkAPIResponse", "Exception is " +e.getMessage(), 0);
		}
	}

	public void checkAPIResponseInDetail(Response response) {
		try {
			// check if expectedError given

			String sExpectedMessage = readData("ExpectedMessage");
			int sExpectedCode = Integer.parseInt(readData("ExpectedCode"));
			String sExpectedParam = readData("ExpectedParam");
			String sBrand = readData("BrandField");
			String customerHash = readData("customerHash");
			String Operation = readData("Operation");
			String ExpectedParamJsonData = readData("ExpectedParamJsonData");

			if (!StringUtils.isAllBlank(String.valueOf(sBrand))) {
				if (sBrand.equalsIgnoreCase("Add_cart"))
				{
					validateUC_cart(response);
				}
				if (sBrand.equalsIgnoreCase("WIP_bundle"))
				{
					validateWIP(response);
				}
				
				
				if (!StringUtils.isAllBlank(String.valueOf(sExpectedCode))) {
					int statusCode = response.getStatusCode();
					if (statusCode == sExpectedCode) {
						fUtil.flogResult("Passed", "API Status code check",
								"Expected " + sExpectedCode + " Actual " + statusCode, 0);
					} else {
						fUtil.flogResult("Failed", "API Status code check",
								"Expected " + sExpectedCode + " Actual " + statusCode, 0);
					}
					if (!StringUtils.isAllBlank(sExpectedMessage) && !StringUtils.isAllBlank(sExpectedParam)) {
						// String smessage1 = response.getBody().asString();
						String smessage = response.jsonPath().get(sExpectedParam);
						if (smessage.trim().equalsIgnoreCase(sExpectedMessage.trim())) {
							fUtil.flogResult("Passed",
									"API Response check ",
									"Actual message matches with expected message and message : " + smessage, 0);
						} else {
							fUtil.flogResult("Failed",
									"API Response check : Actual message not matches with expected message",
									"Expected message : " + sExpectedMessage + " Actual message : " + smessage, 0);
						}
					}
				}
			}
			else if (!StringUtils.isAllBlank(String.valueOf(sExpectedCode))) {
				int statusCode = response.getStatusCode();
				if (statusCode == sExpectedCode) {

					fUtil.flogResult("Passed", "API Status code check",
							"Expected " + sExpectedCode + " Actual " + statusCode, 0);
				} else {
					fUtil.flogResult("Failed", "API Status code check",
							"Expected " + sExpectedCode + " Actual " + statusCode, 0);
				}

				if (!StringUtils.isAllBlank(sExpectedMessage) && !StringUtils.isAllBlank(sExpectedParam)) {
					String smessage = response.jsonPath().get(sExpectedParam).toString();
					if (smessage.trim().equalsIgnoreCase(sExpectedMessage.trim())) {
						fUtil.flogResult("Passed", "API Response check : Actual error matches with expected error",
								"API response " + smessage, 0);
					} else {
						fUtil.flogResult("Failed", "API Response check : Actual error not matches with expected error",
								"Expected Error : " + sExpectedMessage + " Actual Error : " + smessage, 0);
					}
				}
			}
			System.out.println("Outside Database validation");
			if (!StringUtils.isAllBlank(String.valueOf(Operation))) {
				System.out.println("Inside Database validation");
				if (Operation.equalsIgnoreCase("deviceInitiation")) {
					 ExpectedParamJsonData = readData("ExpectedParamJsonData");
					int DeviceInfoId = response.jsonPath().get(ExpectedParamJsonData);
					String InfoIdFromApi= String.valueOf(DeviceInfoId);
					System.out.println("DeviceInfoId from Api is"+InfoIdFromApi);
					String InfoIdFromDB = getDeviceInfoIdFromDB(customerHash);
					if (InfoIdFromApi.equals(InfoIdFromDB)) {

						fUtil.flogResult("Passed", "Defice Info Id ",
								"is Matched with database info id" + InfoIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Defice Info Id ",
								"is not Matched with database info id" + InfoIdFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("CashbackApi")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					String messageFromDB = getmessageForCashbackFromDB(orderNo);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Cashback Api",
								"is Matched with database Message :-" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Cashback Api",
								"is not Matched with database Message :-" + messageFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("AddBeneficiary")) {
					String beneficiaryVpa = readData("beneficiaryvpa");
					String ActiveStatusFromDB = getBenfeciaryActiveDataFromDB(customerHash,beneficiaryVpa);
					if (ActiveStatusFromDB.equals("Y")) {

						fUtil.flogResult("Passed", "Benefiaciary ",
								"Added successfully in DB :-" + ActiveStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Benefiaciary",
								"is not Added successfully in DB :-" + ActiveStatusFromDB, 0);
					}

				}
				else if (Operation.equalsIgnoreCase("AddBeneficiaryFavourite")) {
					String beneficiaryVpa = readData("beneficiaryvpa");
					String FavouriteStatusFromDB = getBenfeciaryFavouriteStatusDataFromDB(customerHash,beneficiaryVpa);
					if (FavouriteStatusFromDB.equals("Y")) {

						fUtil.flogResult("Passed", "Benefiaciary isfavourite",
								"Added successfully in DB :-" + FavouriteStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Benefiaciary isfavourite",
								"is not Added successfully in DB :-" + FavouriteStatusFromDB, 0);
					}

				}
				else if (Operation.equalsIgnoreCase("DeleteBeneficiary")) {
					String beneficiaryVpa = readData("beneficiaryvpa");
					String ActiveStatusFromDB = getBenfeciaryActiveDataFromDB(customerHash,beneficiaryVpa);
					if (ActiveStatusFromDB.equals("N")) {

						fUtil.flogResult("Passed", "Benefiaciary ",
								"Deleted successfully in DB :-" + ActiveStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Benefiaciary",
								"is not Deleted successfully in DB :-" + ActiveStatusFromDB, 0);
					}

				}
				else if (Operation.equalsIgnoreCase("DeleteBeneficiaryFavourite")) {
					String beneficiaryVpa = readData("beneficiaryvpa");
					String FavouriteStatusFromDB = getBenfeciaryFavouriteStatusDataFromDB(customerHash,beneficiaryVpa);
					if (FavouriteStatusFromDB.equals("N")) {

						fUtil.flogResult("Passed", "Benefiaciary isfavourite",
								"Deleted successfully in DB :-" + FavouriteStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Benefiaciary isfavourite",
								"is not Deleted successfully in DB :-" + FavouriteStatusFromDB, 0);
					}

				}
				else if (Operation.equalsIgnoreCase("UpdateTransactionLimit")) {
					String customerVpa = readData("customerVpa");
					String TransactionAmount = readData("transactionLimit");
					System.out.println("TransactionAmount"+TransactionAmount);
					String TransactionAmountFromDB = getUpdatedTransactionAmountFromDB(customerVpa);
					if (TransactionAmount.equals(TransactionAmountFromDB)) {

						fUtil.flogResult("Passed", "Transaction Limit",
								"successfully matched with DB :-" + TransactionAmountFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Transaction Limit",
								"is not matched successfully in DB :-" + TransactionAmountFromDB, 0);
					}

				}
				else if (Operation.equalsIgnoreCase("DeregisterVpa")) {
					String deviceinfoid = readData("deviceInfoId");
					String vpa = readData("vpa");
					String DeregisterStatusFromDB = getDeregisterStausFromDB(vpa,deviceinfoid);
					if (DeregisterStatusFromDB.equals("Y")) {

						fUtil.flogResult("Passed", "Deregister status",
								"successfully matched with DB :-" + DeregisterStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Deregister status",
								"is not matched successfully in DB :-" + DeregisterStatusFromDB, 0);
					}

				}
				else if (Operation.equalsIgnoreCase("AuditInitiation")) {
					 ExpectedParamJsonData = readData("ExpectedParamJsonData");
					String upitranlogid = readData("upiTranLogId");
					int auditId = response.jsonPath().get(ExpectedParamJsonData);
					String auditIdFromApi= String.valueOf(auditId);
					System.out.println("AuditId from Api is"+auditIdFromApi);
					String auditIdFromDB = getAuditIdFromDB(customerHash,upitranlogid);
					if (auditIdFromApi.equals(auditIdFromDB)) {

						fUtil.flogResult("Passed", "Audit Id",
								"is Matched with database audit id :-" + auditIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Audit Id",
								"is not Matched with database audit id :-" + auditIdFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("AuditCompletion")) {
					String auditCompletionDateFromDB = getAuditCompletionDateFromDB(customerHash);
					if (!auditCompletionDateFromDB.equals("NULL")) {

						fUtil.flogResult("Passed", "Audit Completion Date",
								"is Matched with database audit id :-" + auditCompletionDateFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Audit Completion Date",
								"is not Matched with database audit id :-" + auditCompletionDateFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("BlockedVpa")) {
					String blockedBy = readData("customerVpa");
					String blockedVpaStatusFromDB = getBlockedVpaStatusFromDB(blockedBy);
					if (blockedVpaStatusFromDB.equals("ACTIVE")) {

						fUtil.flogResult("Passed", "Blocked Vpa Status",
								"is Matched with database :-" + blockedVpaStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Blocked Vpa Status",
								"is not Matched with database :-" + blockedVpaStatusFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("CheckTransactionStatus")) {
					String messagedata = readData("ExpectedMessage");
					String terminalIddata = readData("terminalId");
					String storeIddata = readData("storeId");
					String channelIddata = readData("channelId");
					String channelTypedata = readData("channelType");
					String subMerchantIddata = readData("subMerchantId");
					String orderIddata = readData("orderId");
					
					String messageFromDB = getmessageForCheckTransactionStatusFromDB(orderIddata);
					if (messagedata.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status",
								"is not Matched with database Message" + messageFromDB,0);
					}
					String terminalIddataFromDB = getterminalIdForCheckTransactionStatusFromDB(orderIddata);
					if (terminalIddata.equals(terminalIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status",
								"is Matched with database Message" + terminalIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status",
								"is not Matched with database Message" + terminalIddataFromDB,0);
					}			
					String storeIddataFromDB = getstoreIdForCheckTransactionStatusFromDB(orderIddata);
					if (storeIddata.equals(storeIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status",
								"is Matched with database Message" + storeIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status",
								"is not Matched with database Message" + storeIddataFromDB,0);
					}
					String channelIddataFromDB = getchannelIdForCheckTransactionStatusFromDB(orderIddata);
					if (channelIddata.equals(channelIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status",
								"is Matched with database Message" + channelIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status",
								"is not Matched with database Message" + channelIddataFromDB,0);
					}
					String channelTypedataFromDB = getchannelTypeForCheckTransactionStatusFromDB(orderIddata);
					if (channelTypedata.equals(channelTypedataFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status",
								"is Matched with database Message" + channelTypedataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status",
								"is not Matched with database Message" + channelTypedataFromDB,0);
					}
					String subMerchantIddataromDB = getsubMerchantIdForCheckTransactionStatusFromDB(orderIddata);
					if (subMerchantIddata.equals(subMerchantIddataromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status",
								"is Matched with database Message" + subMerchantIddataromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status",
								"is not Matched with database Message" + subMerchantIddataromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("CheckTransactionStatusMerchant")) {
					String messagedata = readData("ExpectedMessage");
					String terminalIddata = readData("terminalId");
					String storeIddata = readData("storeId");
					String channelIddata = readData("channelId");
					String channelTypedata = readData("channelType");
					String subMerchantIddata = readData("subMerchantId");
					String orderIddata = readData("orderId");
					
					String messageFromDB = getmessageForCheckTransactionStatusFromDB(orderIddata);
					if (messagedata.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status Merchant",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status Merchant",
								"is not Matched with database Message" + messageFromDB,0);
					}
					String terminalIddataFromDB = getterminalIdForCheckTransactionStatusFromDB(orderIddata);
					if (terminalIddata.equals(terminalIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status Merchant",
								"is Matched with database Message" + terminalIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status Merchant",
								"is not Matched with database Message" + terminalIddataFromDB,0);
					}			
					String storeIddataFromDB = getstoreIdForCheckTransactionStatusFromDB(orderIddata);
					if (storeIddata.equals(storeIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status Merchant",
								"is Matched with database Message" + storeIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status Merchant",
								"is not Matched with database Message" + storeIddataFromDB,0);
					}
					String channelIddataFromDB = getchannelIdForCheckTransactionStatusFromDB(orderIddata);
					if (channelIddata.equals(channelIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status Merchant",
								"is Matched with database Message" + channelIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status Merchant",
								"is not Matched with database Message" + channelIddataFromDB,0);
					}
					String channelTypedataFromDB = getchannelTypeForCheckTransactionStatusFromDB(orderIddata);
					if (channelTypedata.equals(channelTypedataFromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status Merchant",
								"is Matched with database Message" + channelTypedataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status Merchant",
								"is not Matched with database Message" + channelTypedataFromDB,0);
					}
					String subMerchantIddataromDB = getsubMerchantIdForCheckTransactionStatusFromDB(orderIddata);
					if (subMerchantIddata.equals(subMerchantIddataromDB)) {

						fUtil.flogResult("Passed", "Message for Check Transaction Status Merchant",
								"is Matched with database Message" + subMerchantIddataromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Check Transaction Status Merchant",
								"is not Matched with database Message" + subMerchantIddataromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("CollectRequestMerchant")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					String messageFromDB = getmessageForCashbackFromDB(orderNo);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Collect Request Merchant Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Collect Request Merchant Api",
								"is not Matched with database Message" + messageFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("RegisterQRPayments")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					String messageFromDB = getmessageForCashbackFromDB(orderNo);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Register QR Payments Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Register QR Payments Api",
								"is not Matched with database Message" + messageFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("TCPCollectInvoice")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					String messageFromDB = getmessageFromDB(orderNo);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Collect Invoice Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Collect Invoice Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				
					String terminalIddata = readData("terminalId");
					String storeIddata = readData("storeId");
					String subMerchantIddata = readData("subMerchantId");
					
					String terminalIddataFromDB = getterminalIdFromDB(orderNo);
					if (terminalIddata.equals(terminalIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Collect Invoice",
								"is Matched with database Message" + terminalIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Collect Invoice",
								"is not Matched with database Message" + terminalIddataFromDB,0);
					}			
					String storeIddataFromDB = getstoreIdFromDB(orderNo);
					if (storeIddata.equals(storeIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Collect Invoice",
								"is Matched with database Message" + storeIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Collect Invoice",
								"is not Matched with database Message" + storeIddataFromDB,0);
					}
				
					
					String subMerchantIddataromDB = getsubMerchantIdFromDB(orderNo);
					if (subMerchantIddata.equals(subMerchantIddataromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Collect Invoice",
								"is Matched with database Message" + subMerchantIddataromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Collect Invoice",
								"is not Matched with database Message" + subMerchantIddataromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("InvoiceCollect")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					String messageFromDB = getmessageFromDB(orderNo);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Collect Invoice Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Collect Invoice Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				
					String terminalIddata = readData("terminalId");
					String storeIddata = readData("storeId");
					String subMerchantIddata = readData("subMerchantId");
					
					String terminalIddataFromDB = getterminalIdFromDB(orderNo);
					if (terminalIddata.equals(terminalIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Collect Invoice",
								"is Matched with database Message" + terminalIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Collect Invoice",
								"is not Matched with database Message" + terminalIddataFromDB,0);
					}			
					String storeIddataFromDB = getstoreIdFromDB(orderNo);
					if (storeIddata.equals(storeIddataFromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Collect Invoice",
								"is Matched with database Message" + storeIddataFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Collect Invoice",
								"is not Matched with database Message" + storeIddataFromDB,0);
					}
					
					String subMerchantIddataromDB = getsubMerchantIdFromDB(orderNo);
					if (subMerchantIddata.equals(subMerchantIddataromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Collect Invoice",
								"is Matched with database Message" + subMerchantIddataromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Collect Invoice",
								"is not Matched with database Message" + subMerchantIddataromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("ValidateVPARequest")) {
					String orderNo = readData("orderId");
					String ValidateRemarks = readData("ValidateResponse");
					
				
					String remarksFromDB = getremarksFromDB(orderNo);
					if (ValidateRemarks.equals(remarksFromDB)) {

						fUtil.flogResult("Passed", "Message for Validate VPA Request",
								"is Matched with database Message" + remarksFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Validate VPA Request",
								"is not Matched with database Message" + remarksFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("TCPCollectRequest")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					String messageFromDB = getmessageFromDB(orderNo);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Collect Request Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Collect Request Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("TCPCheckCollectTransactionStatus")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					String messageFromDB = getmessageFromDB(orderNo);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for TCP Check Collect Transaction Status Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for TCP Check Collect Transaction Status Api",
								"is not Matched with database Message" + messageFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("StaticQRTcp")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					String messageFromDB = getmessageFromDB(orderNo);
					if (messageFromDB.equals(null)) {

						fUtil.flogResult("Failed", "Order Id fetched",
								"from Database unsuccessfully" + messageFromDB,0);
					} else {
						fUtil.flogResult("Passed", "Order Id fetched",
								"from Database successfully" + messageFromDB, 0);
					}
					if (messageFromApi.contains(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Static QR Tcp Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Static QR Tcp Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("SignedFlagYes")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					
					if (messageFromApi.contains(orderNo)) {

						fUtil.flogResult("Passed", "Signed Data",
								"is present in the Database : " + messageFromApi, 0);
					} else {
						fUtil.flogResult("Failed", "Signed Data",
								"is not present in the Database : " + messageFromApi,0);
					}
				}
				else if (Operation.equalsIgnoreCase("SignedFlagNo")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					
					if (messageFromApi.contains(orderNo)) {
						fUtil.flogResult("Passed", "Unsigned Data",
								"is present in the Database : " + messageFromApi, 0);
					} else {
						fUtil.flogResult("Failed", "Unsigned Data",
								"is not present in the Database : " + messageFromApi,0);
					}
				}
				else if (Operation.equalsIgnoreCase("DynamicQRTcp")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String orderNo = response.jsonPath().get(ValidateResponse1);
					System.out.println("Order Number from Api is:"+ orderNo);
					String messageFromDB = getmessageFromDB(orderNo);
					if (messageFromDB.equals(null)) {

						fUtil.flogResult("Failed", "Order Id fetched",
								"from Database unsuccessfully" + messageFromDB,0);
					} else {
						fUtil.flogResult("Passed", "Order Id fetched",
								"from Database successfully" + messageFromDB, 0);
					}
					if (messageFromApi.contains(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Static QR Tcp Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Static QR Tcp Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("CreatedVpa")) {
					String ValidateResponse = readData("ExpectedParam");
					String vpa = readData("vpa");
					String resMsgFromDB = getCreatedVpaFromDB(customerHash,vpa);
					if (resMsgFromDB.equals(ValidateResponse)) {

						fUtil.flogResult("Passed", "Created vpa Api message",
								"is Matched with database :-" + resMsgFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Created vpa Api message",
								"is not Matched with database :-" + resMsgFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("UnblockedVpa")) {
					String blockedBy = readData("customerVpa");
					String blockedVpaStatusFromDB = getBlockedVpaStatusFromDB(blockedBy);
					if (blockedVpaStatusFromDB.equals("INACTIVE")) {

						fUtil.flogResult("Passed", "Blocked Vpa Status",
								"is Matched with database :-" + blockedVpaStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Blocked Vpa Status",
								"is not Matched with database :-" + blockedVpaStatusFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("StoreAccount")) {
					String accmasteridFromApi = readData("ExpectedParamJsonData");
					String accountNumber = readData("accountNo");
					String accmasteridFromDB = getaccountFromDB(customerHash,accountNumber);
					if (accmasteridFromDB.equals(accmasteridFromApi)) {

						fUtil.flogResult("Passed", "Account master from Api",
								"is Matched with database accMasterId :-" + accmasteridFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Account master from Api",
								"is not Matched with database accMasterId :-" + accmasteridFromDB,0);
					}

				}
				else if (Operation.equalsIgnoreCase("DeleteAccount")) {
					String accmasterid = readData("accmasterId");
					String isActiveStatusFromDB = getDeleteAccountStausFromDB(customerHash,accmasterid);
					if (isActiveStatusFromDB.equals("N")) {
						fUtil.flogResult("Passed", "Active status for specific accmasterid",
								"successfully matched with DB :-" + isActiveStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Active status for specific accmasterid",
								"is not matched successfully in DB :-" + isActiveStatusFromDB, 0);
					}

				}
				else if (Operation.equalsIgnoreCase("PaymentInitiation")) {
					String accmasterid = readData("accmasterId");
					String txnAmount = readData("txnamt");
					String TransactionIdFromApi =response.jsonPath().get(ExpectedParamJsonData);
					System.out.println("TransactionIdFromApi is"+TransactionIdFromApi);
					String TransactionIdFromDB = getTransactionIdFromDB(txnAmount,accmasterid);
					if (TransactionIdFromDB.equals(TransactionIdFromApi)) {
						fUtil.flogResult("Passed", "Transaction Id from Api is",
								"successfully matched with DB :-" + TransactionIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Transaction Id from Api is",
								"is not matched successfully in DB :-" + TransactionIdFromDB, 0);
					}

				}
				else if (Operation.equalsIgnoreCase("PaymentCompletion")) {
					String accmasterid = readData("accmasterId");
					String txnAmount = readData("txnamt");
					String resMsg = readData("resMessage");
					String TransactionIdFromApi =response.jsonPath().get(ExpectedParamJsonData);
					System.out.println("TransactionIdFromApi is"+TransactionIdFromApi);
					String TransactionIdFromDB = getCompleteTrnIdFromDB(txnAmount,accmasterid,resMsg);
					if (TransactionIdFromDB.equals(TransactionIdFromApi)) {
						fUtil.flogResult("Passed", "Transaction Id from Api is",
								"successfully matched with DB :-" + TransactionIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Transaction Id from Api is",
								"is not matched successfully in DB :-" + TransactionIdFromDB, 0);
					}

				}
				else if (Operation.equalsIgnoreCase("deviceBindingCompletion")) {
					
					String resMsg = readData("resMessage");
					String deviceBindingCompletionStatusFromDb = getdeviceBindingCompletionStatusFromDB(customerHash);
					if (deviceBindingCompletionStatusFromDb.equals(resMsg)) {
						fUtil.flogResult("Passed", "deviceBindingCompletion res message",
								"is successfully matched with DB :-" + deviceBindingCompletionStatusFromDb, 0);
					} else {
						fUtil.flogResult("Failed", "deviceBindingCompletion res message",
								"is not matched successfully in DB :-" + deviceBindingCompletionStatusFromDb, 0);
					}
					

				}
                else if (Operation.equalsIgnoreCase("LinkAccount")) {
                	String accmasterid = readData("accmasterId");
                	String CustomerVpa = readData("customerVpa");
                	String LinkAccountUpiFromDB = getLinkAccountStausFromDB(customerHash,accmasterid);
					if (LinkAccountUpiFromDB.equals(CustomerVpa)) {
						fUtil.flogResult("Passed", "Link upi account detail",
								"is successfully matched with DB :-" + LinkAccountUpiFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Link upi account detail",
								"is not matched successfully in DB :-" + LinkAccountUpiFromDB, 0);
					}
					

				}
                else if (Operation.equalsIgnoreCase("ModifyVpa")) {
                	String CustomerVpa = readData("customerVpa");
                	String ModifiedVpaFromDB = getModifiedVpaFromDB(customerHash);
					if (ModifiedVpaFromDB.equals(CustomerVpa)) {
						fUtil.flogResult("Passed", "Modified Vpa",
								"is successfully matched with DB :-" + ModifiedVpaFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Modified Vpa",
								"is not matched successfully in DB :-" + ModifiedVpaFromDB, 0);
					}
					

				}
                else if (Operation.equalsIgnoreCase("AuthoriseMandate")) {
                	String TransactionIdFromApi =response.jsonPath().get(ExpectedParamJsonData);
					System.out.println("TransactionIdFromApi is"+TransactionIdFromApi);
					String authoriseMadateFromDB = getauthoriseMadateFromDB(customerHash);
					if (authoriseMadateFromDB.contains(TransactionIdFromApi)) {
						fUtil.flogResult("Passed", "Authorise mandate Trasaction id ",
								"is successfully matched with DB transaction id :-" + authoriseMadateFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Authorise mandate Trasaction id ",
								"is not matched successfully in DB transaction id :-" + authoriseMadateFromDB, 0);
					}
				}
                else if (Operation.equalsIgnoreCase("RefundTransactionStatus")) {
					String ValidateResponse = readData("ValidateResponse");
					String orderID = readData("orderId");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String messageFromDB = getmessageFromDB(orderID);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Refund Transaction Status Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Refund Transaction Status Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("RefundTransactionMerchant_Api")) {
					String ValidateResponse = readData("ValidateResponse");
					String orderID = readData("orderId");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String messageFromDB = getmessageFromDB(orderID);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for RefundTransactionMerchant Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Refund Transaction Merchant Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("RefundTransactionMerchant_Api")) {
					String ValidateResponse = readData("ValidateResponse");
					String orderID = readData("orderId");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String messageFromDB = getmessageFromDB(orderID);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for RefundTransactionMerchant Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Refund Transaction Merchant Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("MandateRequestStatus")) {
					String ValidateResponse = readData("ValidateResponse");
					String orderID = readData("orderId");
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Message from Api is"+messageFromApi);
					String messageFromDB = getMandatemessageFromDB(orderID);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Mandate Request Status Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Mandate Request Status Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("MandateRequest")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					
					String messageFromApi = response.jsonPath().get(ValidateResponse);
					String orderID = response.jsonPath().get(ValidateResponse1);
					
					System.out.println("Message from Api is"+messageFromApi);
					String messageFromDB = getMandatemessageFromDB(orderID);
					if (messageFromApi.equals(messageFromDB)) {

						fUtil.flogResult("Passed", "Message for Mandate Request Status Api",
								"is Matched with database Message" + messageFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Mandate Request Status Api",
								"is not Matched with database Message" + messageFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("ReversalStatus")) {
					String ValidateResponse = readData("ValidateResponse");
					String orderID = readData("orderId");
					String reversalIdFromApi = response.jsonPath().get(ValidateResponse);
					System.out.println("Reversal Id from Api is"+reversalIdFromApi);
					String reversalIdFromDB = getreversalIdFromDB(orderID);
					if (reversalIdFromApi.equals(reversalIdFromDB)) {

						fUtil.flogResult("Passed", "Message for Reversal Status Api",
								"is Matched with database Message" + reversalIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Reversal Status Api",
								"is not Matched with database Message" + reversalIdFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("GetLiftOfCards")) {
					String ValidateResponse = readData("ValidateResponse");
					String MaskedNumber = readData("ValidateResponse1");
			//		String tokenIdFromApi = response.jsonPath().get(ValidateResponse);
			//		System.out.println("Token Id from Api is"+tokenIdFromApi);
					String maskCardNumberFromDB = getmaskCardNumberFromDB(ValidateResponse);
					
					if (MaskedNumber.equals(maskCardNumberFromDB)) {

						fUtil.flogResult("Passed", "Message for Get List Of Cards Api",
								"is Matched with database Message" + maskCardNumberFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Get List Of Cards Api",
								"is not Matched with database Message" + maskCardNumberFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("AddCard")) {
					String ValidateResponse = readData("custId");
					
					String AddCardNumberFromDB = getaddCardNumberFromDB();
					
					if (ValidateResponse.equals(AddCardNumberFromDB)) {

						fUtil.flogResult("Passed", "Message for Addition of Cards Api",
								"is Matched with database Message" + AddCardNumberFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Addition of Cards Api",
								"is not Matched with database Message" + AddCardNumberFromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("AddCard_CardPayment")) {

					String ValidateResponse = readData("ValidateResponse");
					String TokenIdFromAPI = response.jsonPath().get(ValidateResponse);
					System.out.println("Token Id from Api is"+TokenIdFromAPI);
					
					String ValidateResponse1 = readData("ValidateResponse1");
					String CardNumberFromAPI = response.jsonPath().get(ValidateResponse1);
					System.out.println("Card Number from Api is"+CardNumberFromAPI);
					
					String ValidateResponse2 = readData("ValidateResponse2");
					String CustomerIdFromAPI = response.jsonPath().get(ValidateResponse2);
					System.out.println("Customer Id from Api is"+CustomerIdFromAPI);
					
					String maskedNumberFromDB = getMaskedNumberFromDB(TokenIdFromAPI, CustomerIdFromAPI);

					if (CardNumberFromAPI.equals(maskedNumberFromDB)) {

						fUtil.flogResult("Passed", "Masked Card Number for Addition of Card Payments Api",
								"is Matched with database Message" + maskedNumberFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Masked Card Number for Addition of Card Payments Api",
								"is not Matched with database Message" + maskedNumberFromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("OrderUpdateLoyalRetry")) {
					String TransactionLoyalId = readData("tdPyTransactId");
					String ValidateResponse1 = readData("externalRefNo");
					
					String TransactionLoyalIdFromDB = getTransactionLoyalIdFromDB(ValidateResponse1);
					
					if (TransactionLoyalId.equals(TransactionLoyalIdFromDB)) {

						fUtil.flogResult("Passed", "Message for Order Update Loyal Retry Api",
								"is Matched with database Message" + TransactionLoyalIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Message for Order Update Loyal Retry Api",
								"is not Matched with database Message" + TransactionLoyalIdFromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("PaymentTimeout")) {
					String ValidateResponse = readData("ValidateResponse");
					String ValidateResponse1 = readData("ValidateResponse1");
					String OrderIdFromAPI = response.jsonPath().get(ValidateResponse);
					System.out.println("Order Id from Api is"+OrderIdFromAPI);
					String StatusFromAPI = response.jsonPath().get(ValidateResponse1);
					System.out.println("Status from Api is"+StatusFromAPI);
					
					String PaymentStatusTransactionFromDB = getPaymentStatusTransactionFromDB(OrderIdFromAPI);
					
					if (StatusFromAPI.equals(PaymentStatusTransactionFromDB)) {

						fUtil.flogResult("Passed", "Status For Payment Timeout Api",
								"is Matched with database Message" + PaymentStatusTransactionFromDB, 0);
						String OrderStatusTransactionFromDB = getOrderStatusTransactionFromDB(OrderIdFromAPI);
						
						if (StatusFromAPI.equals(OrderStatusTransactionFromDB)) {

							fUtil.flogResult("Passed", "Order Status For Payment Timeout Api",
									"is Matched with database Message" + PaymentStatusTransactionFromDB, 0);
							
							
						} else {
							fUtil.flogResult("Failed", "Order Status For Payment Timeout Api",
									"is not Matched with database Message" + PaymentStatusTransactionFromDB,0);
						}
						
					} else {
						fUtil.flogResult("Failed", "Status For Payment Timeout Api",
								"is not Matched with database Message" + PaymentStatusTransactionFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("CheckRefundOrderStatus")) {
					String RefundOrderId = readData("ValidateResponse1");
					String Original_Id = readData("ValidateResponse");
					String Original_IdFromAPI = response.jsonPath().get(Original_Id);
					System.out.println("Original Order Id from Api is"+Original_IdFromAPI);
					
					String OriginalOrderIdFromDB = getOriginalOrderIdFromDB(RefundOrderId);
					
					if (Original_IdFromAPI.equals(OriginalOrderIdFromDB)) {

						fUtil.flogResult("Passed", "Check Refund Order Status Api",
								"is Matched with database Message" + OriginalOrderIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Check Refund Order Status Api",
								"is not Matched with database Message" + OriginalOrderIdFromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("CheckUpiStatus")) {
					String Order_Id = readData("ValidateResponse");
					String OrderIdFromAPI = response.jsonPath().get(Order_Id);
					System.out.println("Order Id from Api is"+OrderIdFromAPI);
					String Transaction_Status = readData("ValidateResponse1");
					String TransactionStatusFromAPI = response.jsonPath().get(Transaction_Status);
					System.out.println("Transaction Status from Api is"+TransactionStatusFromAPI);
					
					String PaymentStatusFromDB = getPaymentStatusTransactionFromDB(OrderIdFromAPI);
					
					if (PaymentStatusFromDB.equals(TransactionStatusFromAPI)) {

						fUtil.flogResult("Passed", "Check Upi Status Api",
								"is Matched with database Message" + PaymentStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Check Upi Status Api",
								"is not Matched with database Message" + PaymentStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("CheckUpiStatus1")) {
					String Order_Id = readData("ValidateResponse");
					String OrderIdFromAPI = response.jsonPath().get(Order_Id);
					System.out.println("Order Id from Api is"+OrderIdFromAPI);
					String Transaction_Status = readData("ValidateResponse1");
					String TransactionStatusFromAPI = response.jsonPath().get(Transaction_Status);
					System.out.println("Transaction Status from Api is"+TransactionStatusFromAPI);
					
					String PaymentStatusFromDB = getPaymentStatusTransactionFromDB(OrderIdFromAPI);
					String Updated_status = PaymentStatusFromDB.replaceAll(" - Transaction Initiated", "");
					
					if (Updated_status.equals(TransactionStatusFromAPI)) {

						fUtil.flogResult("Passed", "Check Upi Status Api",
								"is Matched with database Message" + PaymentStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Check Upi Status Api",
								"is not Matched with database Message" + PaymentStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("PaymentApiStatus")) {
					String Order_Id = readData("ValidateResponse");
					String OrderIdFromAPI = response.jsonPath().get(Order_Id);
					System.out.println("Order Id from Api is"+OrderIdFromAPI);
					String Transaction_Status = readData("ValidateResponse1");
					String TransactionStatusFromAPI = response.jsonPath().get(Transaction_Status);
					System.out.println("Transaction Status from Api is"+TransactionStatusFromAPI);
					
					String PaymentStatusFromDB = getPaymentStatusTransactionFromDB(OrderIdFromAPI);
					
					if (PaymentStatusFromDB.contains(TransactionStatusFromAPI)) {

						fUtil.flogResult("Passed", "Check Upi Status Api",
								"is Matched with database Message" + TransactionStatusFromAPI, 0);
						
						String DateAndTime = readData("ValidateResponse2");
						String DateAndTimeFromAPI = response.jsonPath().get(DateAndTime);
						System.out.println("Date And Time from Api is"+DateAndTimeFromAPI);
						String str1 = DateAndTimeFromAPI.replace("T", " ");
				        String DateAndTimeUpdated = str1.replace("Z", "");
						String UpiTransactionId = readData("ValidateResponse3");
						String UpiTransactionIdFromAPI = response.jsonPath().get(UpiTransactionId);
						System.out.println("Upi Transaction Id from Api is"+UpiTransactionIdFromAPI);
	
						String dateTimeFromDB = getdateTimeFromDB(UpiTransactionIdFromAPI);

						if (dateTimeFromDB.contains(DateAndTimeUpdated)) {

							fUtil.flogResult("Passed", "Date and Time for creation of an order",
									"is Matched with database Message" + DateAndTimeUpdated, 0);
						} else {
							fUtil.flogResult("Failed", "Date and Time for creation of an order",
									"is not Matched with database Message" + DateAndTimeUpdated,0);
						}
						
						
					} else {
						fUtil.flogResult("Failed", "Check Upi Status Api",
								"is not Matched with database Message" + TransactionStatusFromAPI,0);
					}
				}
				else if (Operation.equalsIgnoreCase("PaymentSatusMerchantTransaction")) {
					String Order_Id = readData("ValidateResponse");
					String OrderIdFromAPI = response.jsonPath().get(Order_Id);
					System.out.println("Order Id from Api is"+OrderIdFromAPI);
					String Tdl_Order_Transaction_Id = readData("ValidateResponse1");
					String TdlOrderTransactionIdFromAPI = response.jsonPath().get(Tdl_Order_Transaction_Id);
					System.out.println("TDL order transaction id from Api is"+TdlOrderTransactionIdFromAPI);
					
					String TdlOrderTransactionIdFromDB = getTdlOrderTransactionIdFromDB(OrderIdFromAPI);
					
					if (TdlOrderTransactionIdFromAPI.equals(TdlOrderTransactionIdFromDB)) {

						fUtil.flogResult("Passed", "Payment Satus Merchant Transaction Api",
								"is Matched with database Message" + TdlOrderTransactionIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Payment Satus Merchant Transaction Api",
								"is not Matched with database Message" + TdlOrderTransactionIdFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("OrderPaymentBounceOFF")) {
					String Order_Id = readData("ValidateResponse");
					String OrderIdFromAPI = response.jsonPath().get(Order_Id);
					System.out.println("Order Id from Api is"+OrderIdFromAPI);
					
					String Merchant_Id = readData("ValidateResponse1");
					String Merchant_IdFromAPI = response.jsonPath().get(Merchant_Id);
					System.out.println("Merchant id from Api is"+Merchant_IdFromAPI);
					
					String Merchant_IdFromDB = getMerchantIdFromDB(OrderIdFromAPI);
					
					if (Merchant_IdFromAPI.equals(Merchant_IdFromDB)) {

						fUtil.flogResult("Passed", "Merchant Id for Order Payment Bounce Off Api",
								"is Matched with database Message" + Merchant_IdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Merchant Id for Order Payment Bounce Off Api",
								"is not Matched with database Message" + Merchant_IdFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("GetLoyaltyAPI")) {
					String Loyalty_value = readData("ValidateResponse");
					String Loyalty_valueFromAPI = response.jsonPath().get(Loyalty_value);
					System.out.println("Loyalty Value from Api is"+Loyalty_valueFromAPI);
					
					String customer_hash = readData("dynamic_value1");
					System.out.println("Customer Hash is"+customer_hash);
					
					String LoyaltyValueFromDB = geLoyaltyValueFromDB(customer_hash);
					String LoyaltyValueFromDBUpdated = LoyaltyValueFromDB.replace(",", " ");
					System.out.println("Current Loyalty Balance Is"+ LoyaltyValueFromDBUpdated);
					
					if (LoyaltyValueFromDBUpdated.contains(Loyalty_valueFromAPI)) {

						fUtil.flogResult("Passed", "Loyalty Points for Get Loyalty API Api",
								"is Matched with database Message" + LoyaltyValueFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Loyalty Points for Get Loyalty API Api",
								"is not Matched with database Message" + LoyaltyValueFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("UpdatePayableAmount")) {
					String Order_Id = readData("ValidateResponse");
					String OrderIdFromAPI = response.jsonPath().get(Order_Id);
					System.out.println("Order Id from Api is"+OrderIdFromAPI);
					
					String finalPayableamount = readData("ValidateResponse1");
					float finalPayableAmountFromAPI = response.jsonPath().get(finalPayableamount);
					System.out.println("Final payable amount is"+ finalPayableAmountFromAPI);
					String FinalPayableAmountFromAPI =Float. toString(finalPayableAmountFromAPI);
					String finalPayableAmountFromDB = gefinalPayableAmountFromDB(OrderIdFromAPI);
					System.out.println("Final Payable Amount From DB Is"+ finalPayableAmountFromDB);
					
					if (finalPayableAmountFromDB.contains(FinalPayableAmountFromAPI)) {

						fUtil.flogResult("Passed", "Final Payable Amount for Update Payable Amount Api",
								"is Matched with database Message" + finalPayableAmountFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Final Payable Amount for Update Payable Amount Api",
								"is not Matched with database Message" + finalPayableAmountFromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("OrderDetailsOrderAPI")) {
					String Order_Id = readData("ValidateResponse");
					String OrderIdFromAPI = response.jsonPath().get(Order_Id);
					System.out.println("Order Id from Api is"+OrderIdFromAPI);
					
					String Tdl_Order_Transaction_Id = readData("ValidateResponse1");
					String TdlOrderTransactionIdFromApi = response.jsonPath().get(Tdl_Order_Transaction_Id);
					System.out.println("Tdl Order Transaction Id from Api is"+TdlOrderTransactionIdFromApi);
					
					String TdlOrderTransactionIdFromDB = getTdlOrderTransactionIdFromDB(OrderIdFromAPI);
					System.out.println("Tdl Order Transaction Id From DB Is"+ TdlOrderTransactionIdFromDB);
					
					if (TdlOrderTransactionIdFromApi.equals(TdlOrderTransactionIdFromDB)) {

						fUtil.flogResult("Passed", "TDL transaction id for Order Details Order API",
								"is Matched with database Message" + TdlOrderTransactionIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "TDL transaction id for Order Details Order API",
								"is not Matched with database Message" + TdlOrderTransactionIdFromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("TransactCategory")) {
					String transaction_category = readData("ValidateResponse");
					System.out.println("First Transaction Category is"+transaction_category);
					
                 for(int i=1;i<=10;i++) {
					String TransactionCategoryFromDB = getTransactionCategoryFromDB(i);
					System.out.println("Transaction Category From DB is"+ TransactionCategoryFromDB);
					
					if (transaction_category.contains(TransactionCategoryFromDB)) {

						fUtil.flogResult("Passed", "Transact category",
								"is Matched with database Message" + TransactionCategoryFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Transact category",
								"is not Matched with database Message" + TransactionCategoryFromDB,0);
					}
}
				}
				else if (Operation.equalsIgnoreCase("DeleteAccountsOrchestration")) {
					String CustomerHash = readData("ValidateResponse");
					String CustomerHashFromAPI = response.jsonPath().get(CustomerHash);
					System.out.println("Customer Hash From Api is"+CustomerHashFromAPI);
					
					String customerVpaId = readData("ValidateResponse1");
					String customerVpaIdFromApi = response.jsonPath().get(customerVpaId);
					System.out.println("Customer Vpa Id from Api is"+customerVpaIdFromApi);
					
					String customerVPA = getcustomerVPAFromDB(CustomerHashFromAPI);
					System.out.println("Customer VPA From DB Is"+ customerVPA);
					
					if (customerVpaIdFromApi.equals(customerVPA)) {

						fUtil.flogResult("Passed", "Delete Accounts Orchestration API details",
								"is Matched with database Message" + customerVPA, 0);
					} else {
						fUtil.flogResult("Failed", "Delete Accounts Orchestration API details",
								"is not Matched with database Message" + customerVPA,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("RefundOrder")) {
					String Refund_Transaction_Ref = readData("ValidateResponse");
					String Refund_TransactionRefFromAPI = response.jsonPath().get(Refund_Transaction_Ref);
					System.out.println("Refund Transaction Reference from Api is"+ Refund_TransactionRefFromAPI);
					
					String Merchant_Order_Ref = readData("merchantOrderRef");
					String MerchantOrderRefFromApi = response.jsonPath().get(Merchant_Order_Ref);
					System.out.println("Merchant Order RefFromApi from Api is"+MerchantOrderRefFromApi);
					
					String merhcantOrderRefFromDB = getmerhcantOrderRefFromDB(Refund_TransactionRefFromAPI);
					System.out.println("Merchant Order Ref from DB is"+ merhcantOrderRefFromDB);
					
					if (MerchantOrderRefFromApi.equals(merhcantOrderRefFromDB)) {

						fUtil.flogResult("Passed", "Merchant Order Ref from Refund Order",
								"is Matched with database Message" + merhcantOrderRefFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Merchant Order Ref from Refund Order",
								"is not Matched with database Message" + merhcantOrderRefFromDB,0);
					}
					
				}
				else if (Operation.equalsIgnoreCase("CreateOrderAPI")) {
					String Order_Id = readData("ValidateResponse");
					String OrderIdFromAPI = response.jsonPath().get(Order_Id);
					System.out.println("Order Id from Api is"+ OrderIdFromAPI);
					
					String TdlOrderTransactionID = readData("ValidateResponse1");
					String TdlOrderTransactionIDFromApi = response.jsonPath().get(TdlOrderTransactionID);
					System.out.println("Tdl Order Transaction ID from Api is"+TdlOrderTransactionIDFromApi);
					
					String TdlOrderTransactionIDfFromDB = getTdlOrderTransactionIdFromDB(OrderIdFromAPI);
					System.out.println("Tdl Order Transaction ID from DB is"+ TdlOrderTransactionIDfFromDB);
					
					if (TdlOrderTransactionIDFromApi.equals(TdlOrderTransactionIDfFromDB)) {

						fUtil.flogResult("Passed", "Tdl Order Transaction ID For Create Order API",
								"is Matched with database Message" + TdlOrderTransactionIDfFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Tdl Order Transaction ID For Create Order API",
								"is not Matched with database Message" + TdlOrderTransactionIDfFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("SavedCardsDetails")) {
					String custHash = readData("ValidateResponse");
					String custHashFromAPI = response.jsonPath().get(custHash);
					System.out.println("Customer Hash from Api is"+ custHashFromAPI);
					
					String MobileNumber = readData("ValidateResponse1");
					String MobileNumberFromApi = response.jsonPath().get(MobileNumber);
					System.out.println("Mobile Number from Api is"+MobileNumberFromApi);
					
					String MobileNumberfFromDB = getMobileNumberFromDB(custHashFromAPI);
					System.out.println("Tdl Order Transaction ID from DB is"+ MobileNumberfFromDB);
					
					if (MobileNumberFromApi.equals(MobileNumberfFromDB)) {

						fUtil.flogResult("Passed", "Mobile Number of customer For Saved Cards Details API",
								"is Matched with database Message" + MobileNumberfFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Mobile Number of customer For Saved Cards Details API",
								"is not Matched with database Message" + MobileNumberfFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("PaymentStatus")) {
					String orderId = readData("ValidateResponse");
					String orderIdFromAPI = response.jsonPath().get(orderId);
					System.out.println("Order Id from Api is"+ orderIdFromAPI);
					
					String orderStatus = readData("ValidateResponse1");
					String orderStatusFromApi = response.jsonPath().get(orderStatus);
					System.out.println("Order Status from Api is"+orderStatusFromApi);
					
					String OrderStatusFromDB = getorderStatusFromDB(orderIdFromAPI);
					System.out.println("Tdl Order Transaction ID from DB is"+ OrderStatusFromDB);
					
					if (orderStatusFromApi.equals(OrderStatusFromDB)) {

						fUtil.flogResult("Passed", "Order Status For Payment API",
								"is Matched with database Message" + OrderStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Order Status For Payment API",
								"is not Matched with database Message" + OrderStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("InstrumentUsedRuleEngine")) {
					String custHash = readData("ValidateResponse2");
					String custHashFromAPI = response.jsonPath().get(custHash);
					System.out.println("Customer Hash from Api is"+ custHashFromAPI);
					
					String vpa = readData("ValidateResponse");
					String vpaFromAPI = response.jsonPath().get(vpa);
					System.out.println("VPA from Api is"+ vpaFromAPI);
					
					String instrumentName = readData("ValidateResponse1");
					String instrumentNameFromApi = response.jsonPath().get(instrumentName);
					System.out.println("Instrument Name from Api is"+instrumentNameFromApi);
					
					String instrumentNameFromDB = getinstrumentNameFromDB(custHashFromAPI);
					System.out.println("Instrument Name from DB is"+ instrumentNameFromDB);
					
					String vpaFromDB = getvpaFromDB(custHashFromAPI);
					System.out.println("VPA from DB is"+ vpaFromDB);
					
					if (instrumentNameFromApi.equals(instrumentNameFromDB)) {

						fUtil.flogResult("Passed", "Instrument Name For Rule Engine API",
								"is Matched with database Message" + instrumentNameFromDB, 0);
						if (vpaFromAPI.equals(vpaFromDB)) {

							fUtil.flogResult("Passed", "VPA For Rule Engine API",
									"is Matched with database Message" + vpaFromDB, 0);
						} else {
							fUtil.flogResult("Failed", "VPA For Rule Engine API",
									"is not Matched with database Message" + vpaFromDB,0);
						}
					} else {
						fUtil.flogResult("Failed", "Instrument Name For Rule Engine API",
								"is not Matched with database Message" + instrumentNameFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("InactiveMerchantRuleEngine")) {
					String merchantId = readData("ValidateResponse");
					String merchantIdFromAPI = response.jsonPath().get(merchantId);
					System.out.println("Merchant Id from Api is"+ merchantIdFromAPI);
					
					String activeStatus = readData("ValidateResponse1");
					System.out.println("Active Status from Api is"+activeStatus);
					
					String activeStatusFromDB = getactiveStatusFromDB(merchantIdFromAPI);
					System.out.println("Active Status from DB is"+ activeStatusFromDB);
					
					if (activeStatus.equals(activeStatusFromDB)) {

						fUtil.flogResult("Passed", "Status For Inactive Merchant Rule Engine API",
								"is Matched with database Message" + activeStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Status For Inactive Merchant Rule Engine API",
								"is not Matched with database Message" + activeStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("mtRetrieveOrderOrchestration")) {
					String OrderId = readData("ValidateResponse");
					String OrderIdFromAPI = response.jsonPath().get(OrderId);
					System.out.println("Order Id from Api is"+ OrderIdFromAPI);
					
					String custId = readData("ValidateResponse1");
					String custIdFromAPI = response.jsonPath().get(custId);
					System.out.println("Customer Id from Api is"+ custIdFromAPI);
					
					String billCategory = readData("ValidateResponse2");
					String billCategoryFromAPI = response.jsonPath().get(billCategory);
					System.out.println("Bill Category from Api is"+ billCategoryFromAPI);
					
					String status = readData("ValidateResponse3");
					String statusFromAPI = response.jsonPath().get(status);
					System.out.println("Status from Api is"+ statusFromAPI);
					
					String RequestType = readData("ValidateResponse4");
					String RequestTypeFromAPI = response.jsonPath().get(RequestType);
					System.out.println("Request Type from Api is"+ RequestTypeFromAPI);
					
					String source = readData("ValidateResponse5");
					String sourceFromAPI = response.jsonPath().get(source);
					System.out.println("Source from Api is"+ sourceFromAPI);
					
					String tdlTransactionId = readData("ValidateResponse6");
					String tdlTransactionIdFromAPI = response.jsonPath().get(tdlTransactionId);
					System.out.println("Tdl Transaction Id from Api is"+ tdlTransactionIdFromAPI);
					
					String retrialId = readData("ValidateResponse7");
					String retrialIdFromAPI = response.jsonPath().get(retrialId);
					System.out.println("retrial Id from Api is"+ retrialIdFromAPI);
					
					String customerSegmentId = readData("ValidateResponse8");
					String customerSegmentIdFromAPI = response.jsonPath().get(customerSegmentId);
					System.out.println("customer Segment Id from Api is"+ customerSegmentIdFromAPI);
					
					
					String customerIdFromDB = getcustomerIdFromDB(OrderIdFromAPI);
					System.out.println("Customer Id from DB is"+ customerIdFromDB);
					
					String billCategoryFromDB = getbillCategoryFromDB(OrderIdFromAPI);
					System.out.println("Bill Category from DB is"+ billCategoryFromDB);
					
					String orderStatusFromDB = getorderStatusFromDB(OrderIdFromAPI);
					System.out.println("Order Status from DB is"+ orderStatusFromDB);
					
					String requestTypeFromDB = getrequestTypeFromDB(OrderIdFromAPI);
					System.out.println("RequestType from DB is"+ requestTypeFromDB);
					
					String SourceFromDB = getsourceFromDB(OrderIdFromAPI);
					System.out.println("Source from DB is"+ SourceFromDB);
					
					String tdlOrderTransactionIdFromDB = getTdlOrderTransactionIdFromDB(OrderIdFromAPI);
					System.out.println("tdl Order Transaction Id From DB is"+ tdlOrderTransactionIdFromDB);
					
					String retrialOrderIdFromDB = getretrialOrderIdFromDB(OrderIdFromAPI);
					System.out.println("Retrial Order Id From DB is"+ retrialOrderIdFromDB);
					
					String customerSegmentIdFromDB = getcustomerSegmentIdFromDB(OrderIdFromAPI);
					System.out.println("Customer Segment Id From DB is"+ customerSegmentIdFromDB);
					
					if (custIdFromAPI.equals(customerIdFromDB)) {

						fUtil.flogResult("Passed", "Customer Id For Order",
								"is Matched with database Message" + customerIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Customer Id For Order",
								"is not Matched with database Message" + customerIdFromDB,0);
					}
					if (billCategoryFromAPI.equals(billCategoryFromDB)) {

						fUtil.flogResult("Passed", "Bill Category For Order",
								"is Matched with database Message" + billCategoryFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Bill Category For Order",
								"is not Matched with database Message" + billCategoryFromDB,0);
					}
					if (statusFromAPI.equals(orderStatusFromDB)) {

						fUtil.flogResult("Passed", "Status For Order",
								"is Matched with database Message" + orderStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Status For Order",
								"is not Matched with database Message" + orderStatusFromDB,0);
					}
					if (RequestTypeFromAPI.equals(requestTypeFromDB)) {

						fUtil.flogResult("Passed", "Request Type For Order",
								"is Matched with database Message" + requestTypeFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Request Type For Order",
								"is not Matched with database Message" + requestTypeFromDB,0);
					}
					if (sourceFromAPI.equals(SourceFromDB)) {

						fUtil.flogResult("Passed", "Source For Order",
								"is Matched with database Message" + SourceFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Source For Order",
								"is not Matched with database Message" + SourceFromDB,0);
					}
					if (tdlTransactionIdFromAPI.equals(tdlOrderTransactionIdFromDB)) {

						fUtil.flogResult("Passed", "Tdl Transaction Id For Order",
								"is Matched with database Message" + tdlOrderTransactionIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Tdl Transaction Id For Order",
								"is not Matched with database Message" + tdlOrderTransactionIdFromDB,0);
					}
					if (retrialIdFromAPI.equals(retrialOrderIdFromDB)) {

						fUtil.flogResult("Passed", "Retrial Id For Order",
								"is Matched with database Message" + retrialOrderIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Retrial Id For Order",
								"is not Matched with database Message" + retrialOrderIdFromDB,0);
					}
					if (customerSegmentIdFromAPI.equals(customerSegmentIdFromDB)) {

						fUtil.flogResult("Passed", "Customer Segment Id For Order",
								"is Matched with database Message" + customerSegmentIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Customer Segment Id For Order",
								"is not Matched with database Message" + customerSegmentIdFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("UpdateorderAPI")) {
					String orderId = readData("ValidateResponse");
					String orderIdFromAPI = response.jsonPath().get(orderId);
					System.out.println("Order Id from Api is"+ orderIdFromAPI);
					
					String TdlorderTransactionId = readData("ValidateResponse1");
					String TdlorderTransactionIdFromAPI = response.jsonPath().get(TdlorderTransactionId);
					System.out.println("Tdl Order Transaction Id from Api is"+ TdlorderTransactionIdFromAPI);

					String CustomerId = readData("custId");
					System.out.println("Customer Id from Api is"+ CustomerId);

					String TDLorderIdFromDB = getTdlOrderTransactionIdFromDB(orderIdFromAPI);
					System.out.println("TDL Order Id from DB is"+ TDLorderIdFromDB);
					
					String customerIdFromDB = getcustomerIdFromMerhcantDB(orderIdFromAPI);
					System.out.println("Customer Id from DB is"+ customerIdFromDB);
					
					if (TdlorderTransactionIdFromAPI.equals(TDLorderIdFromDB)) {

						fUtil.flogResult("Passed", "Tdl Order transaction Id For Update Order API",
								"is Matched with database Message" + TDLorderIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Tdl Order transaction Id For Update Order API",
								"is not Matched with database Message" + TDLorderIdFromDB,0);
					}
					if (CustomerId.equals(customerIdFromDB)) {

						fUtil.flogResult("Passed", "Customer Id For Update Order API",
								"is Matched with database Message" + customerIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Customer Id For Update Order API",
								"is not Matched with database Message" + customerIdFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("CreateOrderPOSMerchantTransactionAPI")) {
					String orderId = readData("ValidateResponse");
					String orderIdFromAPI = response.jsonPath().get(orderId);
					System.out.println("Order Id from Api is"+ orderIdFromAPI);
					
					String TdlorderTransactionId = readData("ValidateResponse1");
					String TdlorderTransactionIdFromAPI = response.jsonPath().get(TdlorderTransactionId);
					System.out.println("Tdl Order Transaction Id from Api is"+ TdlorderTransactionIdFromAPI);

					String CustomerId = readData("custId");
					System.out.println("Customer Id from Api is"+ CustomerId);

					String TDLorderIdFromDB = getTdlOrderTransactionIdFromDB(orderIdFromAPI);
					System.out.println("TDL Order Id from DB is"+ TDLorderIdFromDB);
					
					String customerIdFromDB = getcustomerIdFromMerhcantDB(orderIdFromAPI);
					System.out.println("Customer Id from DB is"+ customerIdFromDB);
					
					if (TdlorderTransactionIdFromAPI.equals(TDLorderIdFromDB)) {

						fUtil.flogResult("Passed", "Tdl Order transaction Id For Create Order API",
								"is Matched with database Message" + TDLorderIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Tdl Order transaction Id For Create Order API",
								"is not Matched with database Message" + TDLorderIdFromDB,0);
					}
					if (CustomerId.equals(customerIdFromDB)) {

						fUtil.flogResult("Passed", "Customer Id For Create Order API",
								"is Matched with database Message" + customerIdFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Customer Id For Create Order API",
								"is not Matched with database Message" + customerIdFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("OrderDeclineTCPOrderAPI")) {
					String orderId = readData("ValidateResponse");
					String orderIdFromAPI = response.jsonPath().get(orderId);
					System.out.println("Order Id from Api is"+ orderIdFromAPI);
					
					String status = readData("ValidateResponse1");
					String statusFromAPI = response.jsonPath().get(status);
					System.out.println("Status from Api is"+ statusFromAPI);

					
					String orderStatusFromDB = getorderStatusFromDB(orderIdFromAPI);
					System.out.println("Order Status from DB is"+ orderStatusFromDB);
					
					if (statusFromAPI.equals(orderStatusFromDB)) {

						fUtil.flogResult("Passed", "Order Status From DB For Order Decline TCP Order API",
								"is Matched with database Message" + orderStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Order Status From DB For Order Decline TCP Order API",
								"is not Matched with database Message" + orderStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("CreateMerchantRuleEngine")) {
					String merchantId = readData("ValidateResponse");
					String merchantIdFromAPI = response.jsonPath().get(merchantId);
					System.out.println("Merchant Id from Api is"+ merchantIdFromAPI);
					
					String activeStatus = readData("ValidateResponse1");
					System.out.println("Active Status is"+activeStatus);
					
					String activeStatusFromDB = getactiveStatusFromDB(merchantIdFromAPI);
					System.out.println("Active Status from DB is"+ activeStatusFromDB);
					
					if (activeStatus.equals(activeStatusFromDB)) {

						fUtil.flogResult("Passed", "Status For Create Merchant Rule Engine API",
								"is Matched with database Message" + activeStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Status For Create Merchant Rule Engine API",
								"is not Matched with database Message" + activeStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("UpdateMerchantRuleEngine")) {
					String merchantId = readData("ValidateResponse");
					String merchantIdFromAPI = response.jsonPath().get(merchantId);
					System.out.println("Merchant Id from Api is"+ merchantIdFromAPI);
					
					String activeStatus = readData("ValidateResponse1");
					String activeStatusFromAPI = response.jsonPath().get(activeStatus);
					System.out.println("Active Status is"+activeStatusFromAPI);
					
					String activeStatusFromDB = getactiveStatusFromDB(merchantIdFromAPI);
					System.out.println("Active Status from DB is"+ activeStatusFromDB);
					
					if (activeStatusFromAPI.equals(activeStatusFromDB)) {

						fUtil.flogResult("Passed", "Status For Update Merchant Rule Engine API",
								"is Matched with database Message" + activeStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Status For Update Merchant Rule Engine API",
								"is not Matched with database Message" + activeStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("FetchMerchantRuleEngine")) {
					String merchantId = readData("ValidateResponse");
					String merchantIdFromAPI = response.jsonPath().get(merchantId);
					System.out.println("Merchant Id from Api is"+ merchantIdFromAPI);
					
					String activeStatus = readData("ValidateResponse1");
					System.out.println("Active Status is"+activeStatus);
					
					String activeStatusFromDB = getactiveStatusFromDB(merchantIdFromAPI);
					System.out.println("Active Status from DB is"+ activeStatusFromDB);
					
					if (activeStatus.equals(activeStatusFromDB)) {

						fUtil.flogResult("Passed", "Status For Fetch Merchant Rule Engine API",
								"is Matched with database Message" + activeStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Status For Fetch Merchant Rule Engine API",
								"is not Matched with database Message" + activeStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("GetInvoiceDetails")) {
					String orderId = readData("ValidateResponse");
					String orderIdFromAPI = response.jsonPath().get(orderId);
					System.out.println("Order Id from Api is"+ orderIdFromAPI);
					
					String orderStatus = readData("ValidateResponse1");
					String orderStatusFromApi = response.jsonPath().get(orderStatus);
					System.out.println("Order Status from Api is"+orderStatusFromApi);
					
					String OrderStatusFromDB = getorderStatusFromDB(orderIdFromAPI);
					System.out.println("Tdl Order Transaction ID from DB is"+ OrderStatusFromDB);
					
					if (orderStatusFromApi.equals(OrderStatusFromDB)) {

						fUtil.flogResult("Passed", "Order Status For Payment API",
								"is Matched with database Message" + OrderStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Order Status For Payment API",
								"is not Matched with database Message" + OrderStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("ApplicableBanks")) {
					String bankName = readData("ValidateResponse");
					String bankNameFromAPI = response.jsonPath().get(bankName);
					System.out.println("Bank Name from Api is"+ bankNameFromAPI);
					
					String BankName = readData("ValidateResponse1");
					
					if (bankNameFromAPI.equals(BankName)) {

						fUtil.flogResult("Passed", "Bank Name For Applicable Banks",
								"is Matched with Axis Bank" + BankName, 0);
					} else {
						fUtil.flogResult("Failed", "Bank Name For Applicable Banks",
								"is not Matched with Axis Bank" + BankName,0);
					}
				}
				else if (Operation.equalsIgnoreCase("OrderDeclineTCPOrderAPI")) {
					String orderId = readData("ValidateResponse");
					String orderIdFromAPI = response.jsonPath().get(orderId);
					System.out.println("Order Id from Api is"+ orderIdFromAPI);
					
					String status = readData("ValidateResponse1");
					String statusFromAPI = response.jsonPath().get(status);
					System.out.println("Status from Api is"+ statusFromAPI);

					
					String orderStatusFromDB = getorderStatusFromDB(orderIdFromAPI);
					System.out.println("Order Status from DB is"+ orderStatusFromDB);
					
					if (statusFromAPI.equals(orderStatusFromDB)) {

						fUtil.flogResult("Passed", "Order Status From DB For Order Decline POS Order API",
								"is Matched with database Message" + orderStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Order Status From DB For Order Decline POS Order API",
								"is not Matched with database Message" + orderStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("CardTransactionHistory")) {
					String tokenNumber = readData("ValidateResponse");
					String tokenNumberFromAPI = response.jsonPath().get(tokenNumber);
					System.out.println("Token from Api is"+ tokenNumberFromAPI);
					
					String customerhash = readData("ValidateResponse1");
					String customerHashFromAPI = response.jsonPath().get(customerhash);
					System.out.println("Customer Hash from Api is"+ customerHashFromAPI);

					
					String customerHashFromDB = getcustomerHashFromDB(tokenNumberFromAPI);
					System.out.println("Order Status from DB is"+ customerHashFromDB);
					
					if (customerHashFromAPI.equals(customerHashFromDB)) {

						fUtil.flogResult("Passed", "Customer Hash For Card Transaction History API",
								"is Matched with database Message" + customerHashFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Customer Hash For Card Transaction History API",
								"is not Matched with database Message" + customerHashFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("OrderDeclineEDCOrderAPI")) {
					String orderId = readData("ValidateResponse");
					String orderIdFromAPI = response.jsonPath().get(orderId);
					System.out.println("Order Id from Api is"+ orderIdFromAPI);
					
					String status = readData("ValidateResponse1");
					String statusFromAPI = response.jsonPath().get(status);
					System.out.println("Status from Api is"+ statusFromAPI);

					
					String orderStatusFromDB = getorderStatusFromDB(orderIdFromAPI);
					System.out.println("Order Status from DB is"+ orderStatusFromDB);
					
					if (statusFromAPI.equals(orderStatusFromDB)) {

						fUtil.flogResult("Passed", "Order Status From DB For Order Decline TCP Order API",
								"is Matched with database Message" + orderStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Order Status From DB For Order Decline TCP Order API",
								"is not Matched with database Message" + orderStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("OrderDeclinePOSOrderAPI")) {
					String orderId = readData("ValidateResponse");
					String orderIdFromAPI = response.jsonPath().get(orderId);
					System.out.println("Order Id from Api is"+ orderIdFromAPI);
					
					String status = readData("ValidateResponse1");
					String statusFromAPI = response.jsonPath().get(status);
					System.out.println("Status from Api is"+ statusFromAPI);

				//	String Updated_status = statusFromAPI.replace("Transaction ", "");
					
				//	String strInUpperCase = Updated_status.toUpperCase();
					String orderStatusFromDB = getorderStatusFromDB(orderIdFromAPI);
					System.out.println("Order Status from DB is"+ orderStatusFromDB);
					
					if (orderStatusFromDB.contains(statusFromAPI)) {

						fUtil.flogResult("Passed", "Order Status From DB For Order Decline TCP Order API",
								"is Matched with database Message" + orderStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Order Status From DB For Order Decline TCP Order API",
								"is not Matched with database Message" + orderStatusFromDB,0);
					}
				}
				else if (Operation.equalsIgnoreCase("OrderDeclinePOSOrderAPI2")) {
					String orderId = readData("ValidateResponse");
					String orderIdFromAPI = response.jsonPath().get(orderId);
					System.out.println("Order Id from Api is"+ orderIdFromAPI);
					
					String status = readData("ValidateResponse1");
					String statusFromAPI = response.jsonPath().get(status);
					System.out.println("Status from Api is"+ statusFromAPI);

					String Updated_status = statusFromAPI.replace("Transaction ", "");
					
					String strInUpperCase = Updated_status.toUpperCase();
					String orderStatusFromDB = getorderStatusFromDB(orderIdFromAPI);
					System.out.println("Order Status from DB is"+ orderStatusFromDB);
					
					if (orderStatusFromDB.contains(strInUpperCase)) {

						fUtil.flogResult("Passed", "Order Status From DB For Order Decline TCP Order API",
								"is Matched with database Message" + orderStatusFromDB, 0);
					} else {
						fUtil.flogResult("Failed", "Order Status From DB For Order Decline TCP Order API",
								"is not Matched with database Message" + orderStatusFromDB,0);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public  String getcustomerHashFromDB(String tokenNumberFromAPI) throws Throwable {
		String tokenNumber = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_card_transaction_history_view where token_number = '" + tokenNumberFromAPI + "'" + "order by last_updated_datetime desc limit 1";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "customer_hash");
				System.out.println("Message from db is"+message);				
				tokenNumber = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return tokenNumber;
	}
	@Test
	public  String getcustomerIdFromMerhcantDB(String orderIdFromAPI) throws Throwable {
		String customerId = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_merchant_order where merchant_order_ref = '" + orderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "cust_id");
				System.out.println("Message from db is"+message);				
				customerId = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return customerId;
	}
	@Test
	public  String getcustomerSegmentIdFromDB(String orderIdFromAPI) throws Throwable {
		String customerSegmentId = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + orderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "customer_segment_id");
				System.out.println("Message from db is"+message);				
				customerSegmentId = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return customerSegmentId;
	}
	@Test
	public  String getretrialOrderIdFromDB(String orderIdFromAPI) throws Throwable {
		String retrialOrderId = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + orderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "retrial_order_id");
				System.out.println("Message from db is"+message);				
				retrialOrderId = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return retrialOrderId;
	}
	@Test
	public  String getsourceFromDB(String orderIdFromAPI) throws Throwable {
		String source = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + orderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "source");
				System.out.println("Message from db is"+message);				
				source = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return source;
	}
	@Test
	public  String getrequestTypeFromDB(String orderIdFromAPI) throws Throwable {
		String requestType = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + orderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "request_type");
				System.out.println("Message from db is"+message);				
				requestType = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return requestType;
	}
	@Test
	public  String getcustomerIdFromDB(String orderIdFromAPI) throws Throwable {
		String customerId = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + orderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "cust_id");
				System.out.println("Message from db is"+message);				
				customerId = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return customerId;
	}
	@Test
	public  String getbillCategoryFromDB(String orderIdFromAPI) throws Throwable {
		String billCategory = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + orderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "bill_category");
				System.out.println("Message from db is"+message);				
				billCategory = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return billCategory;
	}
	@Test
	public  String getactiveStatusFromDB(String merchantIdFromAPI) throws Throwable {
		String activeStatus = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_merchant where merchant_identifier = '" + merchantIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "is_active");
				System.out.println("Message from db is"+message);				
				activeStatus = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return activeStatus;
	}
	@Test
	public  String getinstrumentNameFromDB(String custHashFromAPI) throws Throwable {
		String instrumentName = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_payment_instruments where cust_id = '" + custHashFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "instrument_name");
				System.out.println("Message from db is"+message);				
				instrumentName = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return instrumentName;
	}
	@Test
	public  String getvpaFromDB(String custHashFromAPI) throws Throwable {
		String vpa = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_payment_instruments where cust_id = '" + custHashFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "upi_vpa");
				System.out.println("Message from db is"+message);				
				vpa = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return vpa;
	}
	@Test
	public  String getorderStatusFromDB(String orderIdFromAPI) throws Throwable {
		String orderStatus = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + orderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "payment_status");
				System.out.println("Message from db is"+message);				
				orderStatus = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return orderStatus;
	}
	@Test
	public  String getMobileNumberFromDB(String custHashFromAPI) throws Throwable {
		String customerHash = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_card_cust_dtls where cust_hash = '" + custHashFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "mobile_number");
				System.out.println("Message from db is"+message);				
				customerHash = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return customerHash;
	}
	@Test
	public  String getmerhcantOrderRefFromDB(String Refund_TransactionRefFromAPI) throws Throwable {
		String merchantOrderRef = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_refund_order where td_py_refund_order_tran_ref = '" + Refund_TransactionRefFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "merchant_order_ref");
				System.out.println("Message from db is"+message);				
				merchantOrderRef = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return merchantOrderRef;
	}
	@Test
	public  String getcustomerVPAFromDB(String CustomerHashFromAPI) throws Throwable {
		String customerVPA = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_transact_upi where cust_id = '" + CustomerHashFromAPI + "' order by td_py_transact_id desc limit 1";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "vpa");
				System.out.println("Message from db is"+message);				
				customerVPA = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return customerVPA;
	}
	@Test
	public  String getTransactionCategoryFromDB(int i) throws Throwable {
		String TransactionCategory = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_transact_category where id = '" + i + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "transaction_category");
				System.out.println("Message from db is"+message);				
				TransactionCategory = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return TransactionCategory;
	}
	@Test
	public  String gefinalPayableAmountFromDB(String OrderIdFromAPI) throws Throwable {
		String finalPayableAmount = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + OrderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "final_payable_amount");
				System.out.println("Message from db is"+message);				
				finalPayableAmount = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return finalPayableAmount;
	}
	@Test
	public  String geLoyaltyValueFromDB(String customer_hash) throws Throwable {
		String LoyaltyValue = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_transact_loyal where cust_id = '" + customer_hash + "' order by last_updated_datetime desc limit 1";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "current_balance");
				System.out.println("Message from db is"+message);				
				LoyaltyValue = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return LoyaltyValue;
	}
	@Test
	public  String getMerchantIdFromDB(String OrderIdFromAPI) throws Throwable {
		String MerchantId = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + OrderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "merchant_id");
				System.out.println("Message from db is"+message);				
				MerchantId = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return MerchantId;
	}
	@Test
	public  String getTdlOrderTransactionIdFromDB(String OrderIdFromAPI) throws Throwable {
		String tdlOrderTransactionId = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_pay_order where merchant_order_ref = '" + OrderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "tdl_transaction_id");
				System.out.println("Message from db is"+message);				
				tdlOrderTransactionId = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return tdlOrderTransactionId;
	}
	@Test
	public  String getdateTimeFromDB(String UpiTransactionIdFromAPI) throws Throwable {
		String UpiTransactionId = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_transact_upi where tdl_transaction_id = '" + UpiTransactionIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "creation_datetime");
				System.out.println("Message from db is"+message);				
				UpiTransactionId = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return UpiTransactionId;
	}
	@Test
	public  String getOriginalOrderIdFromDB(String RefundOrderId) throws Throwable {
		String OriginalOrderID = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select td_py_merchant_order_id from payment_r2.td_py_refund_order where merchant_order_ref = '" + RefundOrderId + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "td_py_merchant_order_id");
				System.out.println("Message from db is"+message);				
				OriginalOrderID = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return OriginalOrderID;
	}
	@Test
	public  String getOrderStatusTransactionFromDB(String OrderIdFromAPI) throws Throwable {
		String PaymentStatus = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select order_status from payment_r2.td_py_merchant_order where merchant_order_ref='" + OrderIdFromAPI + "'"+ "order by creation_datetime desc limit 1";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "order_status");
				System.out.println("Message from db is"+message);				
				PaymentStatus = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return PaymentStatus;
	}
	@Test
	public  String getPaymentStatusTransactionFromDB(String OrderIdFromAPI) throws Throwable {
		String PaymentStatus = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select payment_status from payment_r2.td_py_pay_order where merchant_order_ref='" + OrderIdFromAPI + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "payment_status");
				System.out.println("Message from db is"+message);				
				PaymentStatus = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return PaymentStatus;
	}
	@Test
	public  String getTransactionLoyalIdFromDB(String ValidateResponse1) throws Throwable {
		String TransactionLoyalId = "";
		try {
			
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_loyalty_retry where external_ref_no ='" + ValidateResponse1 + "'" + "order by creation_datetime desc limit 1";
			System.out.println("");
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "td_py_transact_loyal_id");
				System.out.println("Message from db is"+message);				
				TransactionLoyalId = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return TransactionLoyalId;
	}
	@Test
	public  String getMaskedNumberFromDB(String TokenIdFromAPI, String CustomerIdFromAPI) throws Throwable {
		String MaskedNumberForaddCardNumber = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select masked_card_number from payment_r2.td_py_card where card_token= '" + TokenIdFromAPI + "'" + " and cust_hash = '" + CustomerIdFromAPI + "'";
			System.out.println("");
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "masked_card_number");
				System.out.println("Message from db is"+message);				
				MaskedNumberForaddCardNumber = message;
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return MaskedNumberForaddCardNumber;
	}
	@Test
	public  String getaddCardNumberFromDB() throws Throwable {
		String addCardNumber = "";
		try {
			
			DBConnection conn = new DBConnection();
			String query = "select * from payment_r2.td_py_card where card_token = 'pgti9a4tdltkuesvlngh2mc7h'";
			System.out.println("");
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "cust_hash");
				System.out.println("Message from db is"+message);				
				addCardNumber = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return addCardNumber;
	}
	@Test
	public  String getmaskCardNumberFromDB(String tokenIdFromApi) throws Throwable {
		String maskCardNumber = "";
		try {
			
			DBConnection conn = new DBConnection();
			String query = "select masked_card_number from payment_r2.td_py_card where card_token='" + tokenIdFromApi + "'";
			System.out.println("");
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "masked_card_number");
				System.out.println("Message from db is"+message);				
				maskCardNumber = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return maskCardNumber;
	}
	@Test
	public  String getreversalIdFromDB(String orderNo) throws Throwable {
		String reversalId = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select reversal_id from payment_r2.td_py_pay_order where merchant_order_ref='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "reversal_id");
				System.out.println("Message from db is"+message);				
				reversalId = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return reversalId;
	}
	
	public static String loyalty() {
		String sResult = "";
		try {
			String scond = svalidationCase.split(":")[1];
			System.out.println("scond : " + scond);
			double formerLoyaltyPoints;
			double laterLoyaltyPoints;
			double formerRedeemPoints;
			double laterRedeemPoints;
			double formerReturnPoints;
			double laterReturnPoints;
			double formerDelayedPoints;
			double laterDelayedPoints;
			double amount;

			switch (scond.toLowerCase()) {

			case "partialpointspayment":

				formerLoyaltyPoints = Double
						.parseDouble(callchainreqfields.get("loyaltyPoints" + svalidationCase.split(":")[2]));
				formerRedeemPoints = Double
						.parseDouble(callchainreqfields.get("redeemed" + svalidationCase.split(":")[2]));
				laterLoyaltyPoints = Double
						.parseDouble(callchainreqfields.get("loyaltyPoints" + svalidationCase.split(":")[3]));
				laterRedeemPoints = Double
						.parseDouble(callchainreqfields.get("redeemed" + svalidationCase.split(":")[3]));
				amount = Double.parseDouble(fUtil.fgetDataNew1("value1_add"));
				amount = Math.floor(amount * 0.0033);

				if ((formerRedeemPoints == laterRedeemPoints)
						&& (laterLoyaltyPoints == (formerLoyaltyPoints + amount))) {
					logger.info("Partial  Points Validation Success");
					fUtil.flogResult("Pass", "Partial  Points Validation Success", " " + "", 0);

				} else {
					logger.info("Partial Points Validation Fail");
					fUtil.flogResult("Fail", "Partial Points Validation Fail", " " + "", 0);

				}
				break;

			case "returnedpoints":

				formerLoyaltyPoints = Double
						.parseDouble(callchainreqfields.get("loyaltyPoints" + svalidationCase.split(":")[2]));
				formerReturnPoints = Double
						.parseDouble(callchainreqfields.get("returned" + svalidationCase.split(":")[2]));
				laterLoyaltyPoints = Double
						.parseDouble(callchainreqfields.get("loyaltyPoints" + svalidationCase.split(":")[3]));
				laterReturnPoints = Double
						.parseDouble(callchainreqfields.get("returned" + svalidationCase.split(":")[3]));
				amount = Double.parseDouble(fUtil.fgetDataNew1("amount1"));

				if (formerLoyaltyPoints + amount + formerReturnPoints == laterLoyaltyPoints + laterReturnPoints) {
					System.out.println("Returned Points Validation Success");
					fUtil.flogResult("Pass", "Returned Points Validation Success", " " + "", 0);

				} else {
					logger.info("Returned Points Validation Fail");
					fUtil.flogResult("Fail", "Returned Points Validation Fail", " " + "", 0);

				}
				break;

			case "redeempoints":
				formerLoyaltyPoints = Double
						.parseDouble(callchainreqfields.get("loyaltyPoints" + svalidationCase.split(":")[2]));
				formerRedeemPoints = Double
						.parseDouble(callchainreqfields.get("redeemed" + svalidationCase.split(":")[2]));
				laterLoyaltyPoints = Double
						.parseDouble(callchainreqfields.get("loyaltyPoints" + svalidationCase.split(":")[3]));
				laterRedeemPoints = Double
						.parseDouble(callchainreqfields.get("redeemed" + svalidationCase.split(":")[3]));

				if (formerLoyaltyPoints + formerRedeemPoints == laterLoyaltyPoints + laterRedeemPoints) {
					logger.info("Redeemed Points Validation Success");
					fUtil.flogResult("Pass", "Redeemed Points Validation Success", " " + "", 0);

				} else {
					logger.info("Redeemed Points Validation Failure");
					fUtil.flogResult("Fail", "Redeemed Points Validation Fail", " " + "", 0);
				}
				break;

			case "loyaltypoints":

				formerLoyaltyPoints = Double
						.parseDouble(callchainreqfields.get("loyaltyPoints" + svalidationCase.split(":")[2]));
				laterLoyaltyPoints = Double
						.parseDouble(callchainreqfields.get("loyaltyPoints" + svalidationCase.split(":")[3]));

				amount = Double.parseDouble(fUtil.fgetDataNew1("amount"));
				amount = Math.floor(amount * 0.0033);
				if (laterLoyaltyPoints == (formerLoyaltyPoints + amount)) {
					logger.info("Loyalty Points Validation Success");
					fUtil.flogResult("Pass", "Loyalty Points Validation Success", " " + "", 0);

				} else {
					logger.info("Loyalty Points Validation Failure");
					fUtil.flogResult("Fail", "Loyalty Points Validation Fail", " " + "", 0);

				}
				break;

			case "delayedpoints_nochange":

				formerDelayedPoints = Double
						.parseDouble(callchainreqfields.get("delayedPoints" + svalidationCase.split(":")[2]));
				laterDelayedPoints = Double
						.parseDouble(callchainreqfields.get("delayedPoints" + svalidationCase.split(":")[3]));

				if (formerDelayedPoints == laterDelayedPoints) {
					logger.info("Delayed Points No Change Validation Success");
					fUtil.flogResult("Pass", "Delayed Points No Change Validation Success", " " + "", 0);

				} else {
					logger.info("Delayed Points No Change Validation Failure");
					fUtil.flogResult("Fail", "Delayed Points No Change Validation Fail", " " + "", 0);

				}
				break;

			case "delayedpoints_changes":

				formerDelayedPoints = Double
						.parseDouble(callchainreqfields.get("delayedPoints" + svalidationCase.split(":")[2]));
				laterDelayedPoints = Double
						.parseDouble(callchainreqfields.get("delayedPoints" + svalidationCase.split(":")[3]));
				amount = Double.parseDouble(fUtil.fgetDataNew1("amount"));
				amount = Math.floor(amount * 0.0033);
				if (laterDelayedPoints == (formerDelayedPoints + amount)) {
					logger.info("Delayed Points Change Validation Success");
					fUtil.flogResult("Pass", "Delayed Points Change Validation Success", " " + "", 0);

				} else {
					logger.info("Delayed Points Change Validation Failure");
					fUtil.flogResult("Fail", "Delayed Points Change Validation Fail", " " + "", 0);

				}
				break;

			default:
				break;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());

		}
		return sResult;

	}

	private static String readData(String input) {
		try {
			return fUtil.fgetDataNew1(input);
		} catch (Exception e) {
			return "";
		}
	}

	public static String generateaccessToken(String baseUriAuth, String baseUriToken, String h_clientId,
			String h_secretKey, String code_challenge, String countryCode, String mobileNumber, String password,
			String code_verifier) throws Exception {

		try {

			/*
			 * ============================================ AuthCode
			 * Generation===========================================
			 */
			String auth_Code = "";
			String temp = RestAssured.baseURI;
			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);

			if (!StringUtils.trimToEmpty(h_secretKey).isEmpty()) {
				request.header("client_secret", h_secretKey);
			} else {
				System.out.println("Secret key is empty");
			}

			JSONObject json = new JSONObject();
			json.put("countryCode", "91");
			json.put("phone", mobileNumber);
			json.put("password", password);
			json.put("codeChallenge", code_challenge);
		//For v2 change
			json.put("redirectUrl", "https://cug.tatadigital.com");
			
			
			request.body(json.toJSONString());

			Response response = request.post(RestAssured.baseURI);
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

			if (!StringUtils.trimToEmpty(h_secretKey).isEmpty()) {
				requestToken.header("client_secret", h_secretKey);
			} else {
				System.out.println("Secret key is empty");
			}

			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", code_verifier);

			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();
			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);
			String accessToken = responseToken.jsonPath().get("accessToken");

			System.out.println("Access token  is : " + accessToken);

			String tokenType = "Bearer";
			bearerToken = tokenType + " " + accessToken;
			RestAssured.baseURI = temp;

		} catch (Exception ee) {
			System.out.println("Failed and the message is : " + ee.getMessage());
		}
		return bearerToken;

	}

	public static void tokengeneration() throws Exception {
		try {

			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken = fUtil.fgetDataNew1("BaseUriToken");
			h_clientId = fUtil.fgetDataNew1("ClientId");
			h_secretKey = fUtil.fgetDataNew1("SecretKey");
			code_challenge = fUtil.fgetDataNew1("Code_challenge");
			countryCode = "+91";
			mobileNumber = fUtil.fgetDataNew1("MobileNumber");
			password = fUtil.fgetDataNew1("Password");
			code_verifier = fUtil.fgetDataNew1("code_verifier");

			bearerToken = generateaccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey, code_challenge,
					countryCode, mobileNumber, password, code_verifier);

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
	}

	@Test
	void mdeleteAPI() {
		String aurl = "";
		try {
			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
//			String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mdeleteAPI : Base_URI : " + aurl);
			Response response = deleteapi(aurl, requestBody);
			checkAPIResponse(response, "");
			checkAPIResponseInDetail(response);
			System.out.println("mputAPI : check and call validation method");
//			check if any validation 
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}

//				ExecuteAPI.class.getMethod(smethod, null);
//				This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}

	}

//writing put method for API which will return response as it is..
	public static Response deleteapi(String apiurl, String requestBody) {

		Response response = null;
		try {
			// Specify base URI
			RestAssured.baseURI = apiurl;
			System.out.println("API url : " + apiurl + "API Req - " + requestBody);
			String statics = "", finalreq = "";

			// for UPI
			if (requestBody.contains("%")) {

				String[] areqbody = requestBody.split("%");

				statics = Arrays.asList(areqbody).stream().map(value -> { // (() -> {method implementation})

					if (value.replaceAll("[\\n\\t ]", "").endsWith(":\"")
							|| value.replaceAll("[\\n\\t ]", "").endsWith("}")
							|| value.replaceAll("[\\n\\t ]", "").endsWith(":")) {
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
							case "method:randommerchantname":
								data = gmethods.randommerchantname();
								break;
								
//								case "method:randomalphastring": 
//									try {
//										data = gmethods.randomstring(5, "Alpha", "");
//									} catch (Exception e) {
//										e.printStackTrace();
//									}
//									   break;

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
			} else {
				finalreq = callchainreqfields.get(requestBody.toLowerCase());
			}

			System.out.println("Final req from code - " + finalreq);
			// -------json modify
			String jsonString = finalreq;

//-------------------------------------------Authorization--------------------------------

//		} 
			// if(!StringUtils.trimToEmpty(fUtil.fgetDataNew1("username")).isEmpty())
			// {
			// String auth0=fUtil.fgetDataNew1("username");
			// String auth1=fUtil.fgetDataNew1("password");
			// System.out.println(auth0);
			// System.out.println(auth1);
			//
			// httpRequest=RestAssured.given().contentType(ContentType.JSON).auth().basic(auth0,auth1).body(jsonString);
			// }

			// baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriAuth = readData("BaseUriAuth");
			header1 = "";
			if (!StringUtils.trimToEmpty(baseUriAuth).isEmpty()) {
				tokengeneration();
				header1 = "Authorization:" + bearerToken;
				System.out.println("Header1 : " + header1);
			} else {
				header1 = fUtil.fgetDataNew1("Header1");
				// header1 = readData("Header1");
			}

			// header1=fUtil.fgetDataNew1("Header1");
			if (!StringUtils.trimToEmpty(header1).isEmpty()) {
				System.out.println("Header1 : " + header1);

				header2 = fUtil.fgetDataNew1("Header2");
				header2 = readData("Header2");

				if (!StringUtils.trimToEmpty(header2).isEmpty()) {
					System.out.println("Header2 : " + header2);

					if (header2.contains("&")) {
						String temp = header2.split("&")[0] + callchainreqfields.get(header2.split("&")[1]);
						header2 = temp;
					}

					// header3 = fUtil.fgetDataNew1("Header3");
					header3 = readData("Header3");

					if (!StringUtils.trimToEmpty(header3).isEmpty()) {
						System.out.println("Header3 : " + header3);

						if (header3.contains("&")) {
							String temp = header3.split("&")[0] + callchainreqfields.get(header3.split("&")[1]);
							header3 = temp;
						}

						// header4 = fUtil.fgetDataNew1("Header4");
						header4 = readData("Header4");

						if (!StringUtils.trimToEmpty(header4).isEmpty()) {
							System.out.println("Header4 : " + header4);

							if (header4.contains("&")) {
								String temp = header4.split("&")[0] + callchainreqfields.get(header4.split("&")[1]);
								header4 = temp;
							}
							// req with 4 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON)
									.headers(header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
											header2.split(":")[1], header3.split(":")[0], header3.split(":")[1],
											header4.split(":")[0], header4.split(":")[1])
									.body(jsonString);

						} else {
							// req with 3 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON)
									.headers(header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
											header2.split(":")[1], header3.split(":")[0], header3.split(":")[1])
									.body(jsonString);
						}
					} else {
						// req with 2 headers data
						httpRequest = RestAssured
								.given().contentType(ContentType.JSON).headers(header1.split(":")[0],
										header1.split(":")[1], header2.split(":")[0], header2.split(":")[1])
								.body(jsonString);
					}

				} else {
					// req with single header
					httpRequest = RestAssured.given().contentType(ContentType.JSON)
							.headers(header1.split(":")[0], header1.split(":")[1]).body(jsonString);

				}
			} else {
				httpRequest = RestAssured.given().contentType(ContentType.JSON).body(jsonString);
			}
			response = httpRequest.delete(RestAssured.baseURI);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return response;

	}

	@Test
	void mdeleteAPINegative() {
		String aurl = "";
		try {
			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
//			String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mdeleteAPI : Base_URI : " + aurl);
			Response response = deleteapi(aurl, requestBody);
			checkAPIResponseNegative(response, "");
			System.out.println("mputAPI : check and call validation method");
//			check if any validation 
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}

//				ExecuteAPI.class.getMethod(smethod, null);
//				This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}

	}

	@Test
	void mputAPINegative() {
		String aurl = "";
		try {
			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
//			String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mputAPI : Base_URI : " + aurl);
			Response response = putapi(aurl, requestBody);
			checkAPIResponseNegative(response, "");
			System.out.println("mputAPI : check and call validation method");
//			check if any validation 
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}

//				ExecuteAPI.class.getMethod(smethod, null);
//				This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}

	}

	@Test
	void mpostAPINegative() {
		String aurl = "";
		try {
			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
//			String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mpostAPI : Base_URI : " + aurl);
			Response response = postapi(aurl, requestBody);
			checkAPIResponseNegative(response, "");
			System.out.println("mpostAPI : check and call validation method");
//			check if any validation 
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}

//				ExecuteAPI.class.getMethod(smethod, null);
//				This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}

	}

	@Test
	void mpostAPINegativeAuth() {
		String aurl = "";
		try {
			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
//			String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mpostAPI : Base_URI : " + aurl);
			Response response = postapi(aurl, requestBody);
			checkAPIResponseNegativeAuthorization(response, "");
			System.out.println("mpostAPI : check and call validation method");
//			check if any validation 
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}

//				ExecuteAPI.class.getMethod(smethod, null);
//				This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}

	}

	@Test
	void mgetAPINegative() {
		String aurl = "";
		try {
			aurl = fUtil.fgetDataNew1("Base_URI");
//			String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mgetAPI : Base_URI : " + aurl);
			Response response = getapi(aurl);
			checkAPIResponseNegativeAuthorization(response, "");
			System.out.println("mgetAPI : check and call validation method");
//			check if any validation 
			System.out.println("1--");

			svalidation = fUtil.fgetDataNew1("Validation");
			System.out.println("validations : " + svalidation);

			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}
				System.out.println("svalidationCase : " + svalidationCase);

//				ExecuteAPI.class.getMethod(smethod, null);
//				This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
	}

	@Test
	void mcallChainNegative() {
		String surl = "", requestBody = "", respvalues = "";
		try {
			String scallchain = fUtil.fgetDataNew1("CallChainSeq");
			System.out.println("mcallChain : call chain sequence : " + scallchain);
			String[] acallchainseq = scallchain.split(",");

			// for loop to execute call chain
			for (int c = 0; c < acallchainseq.length; c++) {
				Response response = null;
				if (c == 0) {
					surl = fUtil.fgetDataNew1("Base_URI");
					requestBody = fUtil.fgetDataNew1("Request");
					respvalues = fUtil.fgetDataNew1("Responsefields");
				} else {
					surl = fUtil.fgetDataNew1("Base_URI" + (c + 1));
					requestBody = fUtil.fgetDataNew1("Request" + (c + 1));
					respvalues = fUtil.fgetDataNew1("Responsefields" + (c + 1));
				}
				System.out.println("mcallchain : url" + c + " " + surl);

				if (acallchainseq[c].equalsIgnoreCase("get")) {
					response = getapi(surl);

				} else if (acallchainseq[c].equalsIgnoreCase("post")) {
					response = postapi(surl, requestBody);

				} else if (acallchainseq[c].equalsIgnoreCase("delete")) {
					response = deleteapi(surl, requestBody);

				} else if (acallchainseq[c].equalsIgnoreCase("put")) {
					response = putapi(surl, requestBody);

				} else {
					System.err.println("mcallchain : Sequence not given properly in data");
					break;
				}
				System.out.println("mcallchain : Call API response check method");
				checkAPIResponseNegative(response, respvalues);
				surl = "";
			}

//			check if any validation 
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}

//				ExecuteAPI.class.getMethod(smethod, null);
//				This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}

		} catch (Exception e) {
//		System.err.println(e.getMessage());
		}
	}

	public static void checkAPIResponseNegative(Response response, String reqvalues) {
		try {
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Pass", "Validate the Response", "Response Received is" + responseBody, 0);

			long rsTime = response.timeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time is : " + rsTime);
			fUtil.flogResult("Pass", "Check for the Response time", "Response time is: " + rsTime, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 400 || statusCode == 500 || statusCode == 404) {
				// if (statusCode == 200 || statusCode == 201) {
				fUtil.flogResult("Pass", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code 400 or 500 or 404 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			// if (statusLine.equals("HTTP/1.1 200 OK") || statusLine.equals("HTTP/1.1 201
			// Created") || statusLine.trim().equals("HTTP/1.1 200")) {
			if (statusLine.equals("HTTP/1.1 400 Bad Request") || statusLine.equals("HTTP/1.1 500 Internal Server Error")
					|| statusLine.equals("HTTP/1.1 404 Not Found")) {
				fUtil.flogResult("Pass", "Validate the Status Line", "Status Line is " + statusLine, 0);

				if (responseBody.contains("DATA_VALIDATION_ERROR")) {
					System.out.println("Status line is pass");
				} else {
					System.out.println("Status line is fail");
				}
				/*
				 * if (responseBody.contains("success")) { String sactres =
				 * responseBody.split("success")[1].split(",")[0]; String smsg =
				 * responseBody.split("message")[1].split(",")[0]; if
				 * (sactres.equalsIgnoreCase("false")) { fUtil.flogResult("Failed",
				 * "API response status is fail", "Status " + sactres + " | Message " + smsg,
				 * 0); } else { fUtil.flogResult("Pass", "API response status is pass",
				 * "Status " + sactres + " | Message " + smsg, 0); } }
				 */
//		    	svalidation = fUtil.fgetDataNew1("Validation");
//				if(!StringUtils.isAllEmpty(svalidation)) {
//					String smethod = svalidation.split(":")[0].trim().toLowerCase();
//					This.class.getMethod(smethod, null);
//				}

				String respreceived = responseBody;
				// if req field is having data and same will be used in call chain only
				if (!StringUtils.isAllEmpty(reqvalues)) {
					// for UPI
					String[] responsekeys = reqvalues.split(",");

					if (responsekeys[0].toLowerCase().contains("&request")) {
						callchainreqfields.put(responsekeys[0].toLowerCase(), responseBody);
					} else {
						for (int i = 0; i < responsekeys.length; i++) {
							// for(String Tempkey:responseKeys) {
							String Tempkey = responsekeys[i];
							String key = "";
							int count = 1;
							if (Tempkey.contains(":")) {
								key = Arrays.asList(Tempkey.split(":")).get(0);
								count = Integer.valueOf(Arrays.asList(Tempkey.split(":")).get(1));

							} else {
								key = Tempkey;
							}
							String splitresp = Arrays.asList(respreceived.split(key + "\":")).get(count);
							String commaSubString = Arrays.asList(splitresp.split(",")).get(0).trim();
							String curlySub = Arrays.asList(splitresp.split("}")).get(0);

							// to check if intermediate column name to be input is diffent from response
							// param
							if (Tempkey.split(":").length == 3) {
								key = Tempkey.split(":")[2].trim();
							}

							if (commaSubString.length() < curlySub.length()) {
//								fUtil.fWriteData(key, commaSubString);
								callchainreqfields.put(key,
										(commaSubString.startsWith("\"") && commaSubString.endsWith("\""))
												? commaSubString.substring(1, commaSubString.length() - 1)
												: commaSubString);
							} else {
//								fUtil.fWriteData(key, curlySub);
								callchainreqfields.put(key,
										(curlySub.startsWith("\"") && curlySub.endsWith("\""))
												? curlySub.substring(1, curlySub.length() - 1)
												: curlySub);
							}
						}
					}

					System.out.println("Done");
				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 400 Bad Request but it is " + statusLine, 0);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void checkAPIResponseNegativeAuthorization(Response response, String reqvalues) {
		try {
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Pass", "Validate the Response", "Response Received is" + responseBody, 0);

			long rsTime = response.timeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time is : " + rsTime);
			fUtil.flogResult("Pass", "Check for the Response time", "Response time is: " + rsTime, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 401) {
				// if (statusCode == 200 || statusCode == 201) {
				fUtil.flogResult("Pass", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code 401 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			// if (statusLine.equals("HTTP/1.1 200 OK") || statusLine.equals("HTTP/1.1 201
			// Created") || statusLine.trim().equals("HTTP/1.1 200")) {
			if (statusLine.equals("HTTP/1.1 401 Unauthorized")) {
				fUtil.flogResult("Pass", "Validate the Status Line", "Status Line is " + statusLine, 0);

				if (responseBody.contains("Invalid or Missing Access-Token")) {
					System.out.println("Status line is pass");
				} else {
					System.out.println("Status line is fail");
				}
				/*
				 * if (responseBody.contains("success")) { String sactres =
				 * responseBody.split("success")[1].split(",")[0]; String smsg =
				 * responseBody.split("message")[1].split(",")[0]; if
				 * (sactres.equalsIgnoreCase("false")) { fUtil.flogResult("Failed",
				 * "API response status is fail", "Status " + sactres + " | Message " + smsg,
				 * 0); } else { fUtil.flogResult("Pass", "API response status is pass",
				 * "Status " + sactres + " | Message " + smsg, 0); } }
				 */
//		    	svalidation = fUtil.fgetDataNew1("Validation");
//				if(!StringUtils.isAllEmpty(svalidation)) {
//					String smethod = svalidation.split(":")[0].trim().toLowerCase();
//					This.class.getMethod(smethod, null);
//				}

				String respreceived = responseBody;
				// if req field is having data and same will be used in call chain only
				if (!StringUtils.isAllEmpty(reqvalues)) {
					// for UPI
					String[] responsekeys = reqvalues.split(",");

					if (responsekeys[0].toLowerCase().contains("&request")) {
						callchainreqfields.put(responsekeys[0].toLowerCase(), responseBody);
					} else {
						for (int i = 0; i < responsekeys.length; i++) {
							// for(String Tempkey:responseKeys) {
							String Tempkey = responsekeys[i];
							String key = "";
							int count = 1;
							if (Tempkey.contains(":")) {
								key = Arrays.asList(Tempkey.split(":")).get(0);
								count = Integer.valueOf(Arrays.asList(Tempkey.split(":")).get(1));

							} else {
								key = Tempkey;
							}
							String splitresp = Arrays.asList(respreceived.split(key + "\":")).get(count);
							String commaSubString = Arrays.asList(splitresp.split(",")).get(0).trim();
							String curlySub = Arrays.asList(splitresp.split("}")).get(0);

							// to check if intermediate column name to be input is diffent from response
							// param
							if (Tempkey.split(":").length == 3) {
								key = Tempkey.split(":")[2].trim();
							}

							if (commaSubString.length() < curlySub.length()) {
//								fUtil.fWriteData(key, commaSubString);
								callchainreqfields.put(key,
										(commaSubString.startsWith("\"") && commaSubString.endsWith("\""))
												? commaSubString.substring(1, commaSubString.length() - 1)
												: commaSubString);
							} else {
//								fUtil.fWriteData(key, curlySub);
								callchainreqfields.put(key,
										(curlySub.startsWith("\"") && curlySub.endsWith("\""))
												? curlySub.substring(1, curlySub.length() - 1)
												: curlySub);
							}
						}
					}

					System.out.println("Done");
				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 401 Unauthorized but it is " + statusLine, 0);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	void mpostAPIforLoyaltyRedeem() {
		String aurl = "";
		try {
			logger.info("Executing testcase " + strScenarioName);
			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
			// String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mpostAPI : Base_URI : " + aurl);
			Response response = postapiforLoyaltyRedeem(aurl, requestBody);
			checkAPIResponse(response, "");
			System.out.println("mpostAPI : check and call validation method");
			// check if any validation
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}
				// ExecuteAPI.class.getMethod(smethod, null);
				// This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}

		} catch (Exception ee) {
			logger.error("mpostAPI has failed for " + strScenarioName + " due to " + ee.getClass().getName());
			Arrays.asList(ee.getStackTrace()).forEach(x -> logger.error(x.toString()));
		}

	}

	public static Response postapiforLoyaltyRedeem(String apiurl, String requestBody) {
		Response response = null;
		try {
			// Specify base URI
			RestAssured.baseURI = apiurl;
			System.out.println("API url : " + apiurl + "API Req - " + requestBody);
			String statics = "", finalreq = "";

			// for UPI
			if (requestBody.contains("%")) {

				String[] areqbody = requestBody.split("%");

				statics = Arrays.asList(areqbody).stream().map(value -> { // (() -> {method implementation})

					if (value.replaceAll("[\\n\\t ]", "").endsWith(":\"")
							|| value.replaceAll("[\\n\\t ]", "").endsWith("}")
							|| value.replaceAll("[\\n\\t ]", "").endsWith(":")) {
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
//								case "method:randomalphastring": 
//									try {
//										data = gmethods.randomstring(5, "Alpha", "");
//									} catch (Exception e) {
//										e.printStackTrace();
//									}
//									   break;

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
						} else if (data.contains("Card")) {
							data = data.replace("Card",
									"301014100001^VINAY SHARMA ^1910^101079000010?;101015306900=1910E?");
						}
						return data;

					}
				})

						.collect(Collectors.joining());

				finalreq = statics;
				if (!finalreq.isEmpty()) {
					System.out.println("Before:\n" + finalreq);
					// finalreq = finalreq.replaceAll("([\\w]+)[ ]*=", "\"$1\" ="); // to quote
					// before = value
					// finalreq = finalreq.replaceAll("=[ ]*([\\w@\\.]+)", "= \"$1\""); // to quote
					// after = value, add special character as needed to the exclusion list in regex
					// finalreq = finalreq.replaceAll("=[ ]*\"([\\d]+)\"", "= $1"); // to un-quote
					// decimal value
					// finalreq = finalreq.replaceAll("\"true\"", "true"); // to un-quote boolean
					// finalreq = finalreq.replaceAll("\"false\"", "false"); // to un-quote boolean

					System.out.println("===============================");
					System.out.println("After:\n" + finalreq);
					fUtil.flogResult("Pass", "Request Body", "Request Body is " + finalreq, 0);
				}
			} else {
				finalreq = callchainreqfields.get(requestBody.toLowerCase());
			}

			System.out.println("Final req from code - " + finalreq);
			// -------json modify
			String jsonString = finalreq;

//-------------------------------------------Authorization--------------------------------

//		} 
			// if(!StringUtils.trimToEmpty(fUtil.fgetDataNew1("username")).isEmpty())
			// {
			// String auth0=fUtil.fgetDataNew1("username");
			// String auth1=fUtil.fgetDataNew1("password");
			// System.out.println(auth0);
			// System.out.println(auth1);
			//
			// httpRequest=RestAssured.given().contentType(ContentType.JSON).auth().basic(auth0,auth1).body(jsonString);
			// }

			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriAuth = readData("BaseUriAuth");
			header1 = "";
			if (!StringUtils.trimToEmpty(baseUriAuth).isEmpty()) {
				tokengeneration();
				header1 = "Authorization:" + bearerToken;
				System.out.println("Header1 : " + header1);
			} else {
				header1 = fUtil.fgetDataNew1("Header1");
				// header1 = readData("Header1");
			}

			// header1=fUtil.fgetDataNew1("Header1");
			if (!StringUtils.trimToEmpty(header1).isEmpty()) {
				System.out.println("Header1 : " + header1);

				header2 = fUtil.fgetDataNew1("Header2");
				header2 = readData("Header2");

				if (!StringUtils.trimToEmpty(header2).isEmpty()) {
					System.out.println("Header2 : " + header2);

					if (header2.contains("&")) {
						String temp = header2.split("&")[0] + callchainreqfields.get(header2.split("&")[1]);
						header2 = temp;
					}

					// header3 = fUtil.fgetDataNew1("Header3");
					header3 = readData("Header3");

					if (!StringUtils.trimToEmpty(header3).isEmpty()) {
						System.out.println("Header3 : " + header3);

						if (header3.contains("&")) {
							String temp = header3.split("&")[0] + callchainreqfields.get(header3.split("&")[1]);
							header3 = temp;
						}

						// header4 = fUtil.fgetDataNew1("Header4");
						header4 = readData("Header4");

						if (!StringUtils.trimToEmpty(header4).isEmpty()) {
							System.out.println("Header4 : " + header4);

							if (header4.contains("&")) {
								String temp = header4.split("&")[0] + callchainreqfields.get(header4.split("&")[1]);
								header4 = temp;
							}
							// req with 4 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON)
									.headers(header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
											header2.split(":")[1], header3.split(":")[0], header3.split(":")[1],
											header4.split(":")[0], header4.split(":")[1])
									.body(jsonString);

						} else {
							// req with 3 headers data
							httpRequest = RestAssured.given().contentType(ContentType.JSON)
									.headers(header1.split(":")[0], header1.split(":")[1], header2.split(":")[0],
											header2.split(":")[1], header3.split(":")[0], header3.split(":")[1])
									.body(jsonString);
						}
					} else {
						// req with 2 headers data
						httpRequest = RestAssured
								.given().contentType(ContentType.JSON).headers(header1.split(":")[0],
										header1.split(":")[1], header2.split(":")[0], header2.split(":")[1])
								.body(jsonString);
					}

				} else {
					// req with single header
					httpRequest = RestAssured.given().contentType(ContentType.JSON)
							.headers(header1.split(":")[0], header1.split(":")[1]).body(jsonString);
				}
			} else {
				httpRequest = RestAssured.given().contentType(ContentType.JSON).body(jsonString);
			}
			response = httpRequest.post(RestAssured.baseURI);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return response;

	}

	@Test
	void mpostAPIforChecksum() {
		String aurl = "";
		try {
			logger.info("Executing testcase " + strScenarioName);
			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
			// String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mpostAPI : Base_URI : " + aurl);
			Response response = postapi(aurl, requestBody);
			checkAPIResponseChecksum(response, "");
			System.out.println("mpostAPI : check and call validation method");
			// check if any validation
			svalidation = fUtil.fgetDataNew1("Validation");
			if (!StringUtils.isAllEmpty(svalidation)) {
				for (String val : Arrays.asList(svalidation.split(","))) {
					System.out.println("mcallchain : call validation method");
					String smethod = svalidation.split(":")[0].trim().toLowerCase();
					// Method[] abc = ExecuteAPI.class.getMethods();
					svalidationCase = val;
					Method m = ExecuteAPI.class.getDeclaredMethod(smethod, null);
					m.invoke(null);

				}
				// ExecuteAPI.class.getMethod(smethod, null);
				// This.class.getMethod(svalidation.split(":")[0].trim().toLowerCase(), null);
			}

		} catch (Exception ee) {
			logger.error("mpostAPI has failed for " + strScenarioName + " due to " + ee.getClass().getName());
			Arrays.asList(ee.getStackTrace()).forEach(x -> logger.error(x.toString()));
		}

	}

	public static void checkAPIResponseChecksum(Response response, String reqvalues) {
		try {
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Pass", "Validate the Response", "Response Received is" + responseBody, 0);

			long rsTime = response.timeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time is : " + rsTime);
			fUtil.flogResult("Pass", "Check for the Response time", "Response time is: " + rsTime, 0);

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200 || statusCode == 201 || statusCode == 404 || statusCode == 500) {
				fUtil.flogResult("Pass", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code 200 or 201 or 404 or 500 but it is " + statusCode, 0);
			}
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.toUpperCase().contains("HTTP/1.1 20") || statusLine.equals("HTTP/1.1 404 Resource Not Found")
					|| statusLine.equals("HTTP/1.1 500 Resource Not Found")) {
				fUtil.flogResult("Pass", "Validate the Status Line", "Status Line is " + statusLine, 0);
				// if(responseBody.contains("success")) {
				// String sactres = responseBody.split("success")[1].split(",")[0];
				// String smsg = responseBody.split("message")[1].split(",")[0];
				// if(sactres.equalsIgnoreCase("false")) {
				// fUtil.flogResult("Failed","API response status is fail", "Status "+sactres,
				// 0);
				// }else{
				// fUtil.flogResult("Pass","API response status is pass", "Status "+sactres, 0);
				// }
				// }
				// if(sactres.equalsIgnoreCase("false")) {
				// fUtil.flogResult("Failed","API response status is fail", "Status "+sactres+"
				// | Message "+smsg, 0);
				// }else{
				// fUtil.flogResult("Pass","API response status is pass", "Status "+sactres+" |
				// Message "+smsg, 0);
				// }

				// svalidation = fUtil.fgetDataNew1("Validation");
				// if(!StringUtils.isAllEmpty(svalidation)) {
				// String smethod = svalidation.split(":")[0].trim().toLowerCase();
				// This.class.getMethod(smethod, null);
				// }
				if (responseBody.contains("message")) {
					String sactres = responseBody.split("message")[1].split(",")[0];
					// String smsg = responseBody.split("message")[1].split(",")[0];
					if (sactres.contains("CHECKSUM_WRONG")) {
						fUtil.flogResult("Pass", "API response status is Pass", "Status " + sactres, 0);
					} else {
						fUtil.flogResult("Failed", "API response status is fail", "Status " + sactres, 0);
					}
				}
				String respreceived = responseBody;
				// if req field is having data and same will be used in call chain only
				if (!StringUtils.isAllEmpty(reqvalues)) {
					// for UPI
					String[] responsekeys = reqvalues.split(",");

					if (responsekeys[0].toLowerCase().contains("&request")) {
						callchainreqfields.put(responsekeys[0].toLowerCase(), responseBody);
					} else {
						for (int i = 0; i < responsekeys.length; i++) {// for(String Tempkey:responseKeys) {
							String Tempkey = responsekeys[i];
							String key = "";
							int count = 1;
							if (Tempkey.contains(":")) {
								key = Arrays.asList(Tempkey.split(":")).get(0);
								count = Integer.valueOf(Arrays.asList(Tempkey.split(":")).get(1));

							} else {
								key = Tempkey;
							}
							String splitresp = Arrays.asList(respreceived.split(key + "\":")).get(count);
							String commaSubString = Arrays.asList(splitresp.split(",")).get(0).trim();
							String curlySub = Arrays.asList(splitresp.split("}")).get(0);

							// to check if intermediate column name to be input is diffent from response
							// param
							if (Tempkey.split(":").length == 3) {
								key = Tempkey.split(":")[2].trim();
							}

							if (commaSubString.length() < curlySub.length()) {
								// fUtil.fWriteData(key, commaSubString);
								callchainreqfields.put(key,
										(commaSubString.startsWith("\"") && commaSubString.endsWith("\""))
												? commaSubString.substring(1, commaSubString.length() - 1)
												: commaSubString);
							} else {
								// fUtil.fWriteData(key, curlySub);
								callchainreqfields.put(key,
										(curlySub.startsWith("\"") && curlySub.endsWith("\""))
												? curlySub.substring(1, curlySub.length() - 1)
												: curlySub);
							}
						}
					}
					System.out.println("Done");
				}

			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void subscriberProfile() throws Exception {
		try {

			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken = fUtil.fgetDataNew1("BaseUriToken");
			h_clientId = fUtil.fgetDataNew1("ClientId");
			h_secretKey = fUtil.fgetDataNew1("SecretKey");
			code_challenge = fUtil.fgetDataNew1("Code_challenge");
			countryCode = "91";
			mobileNumber = fUtil.fgetDataNew1("MobileNumber");
			password = fUtil.fgetDataNew1("Password");
			code_verifier = fUtil.fgetDataNew1("code_verifier");
			bearerToken = generateaccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey, code_challenge,
					countryCode, mobileNumber, password, code_verifier);

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("Authorization", bearerToken);
			request.header("client_id", fUtil.fgetDataNew1("Header2"));
			request.header("client_secret", fUtil.fgetDataNew1("Header3"));
			request.header("store_id", fUtil.fgetDataNew1("Header1"));
			// request.header("client_id", fUtil.fgetDataNew1("SecretKey"));

			JSONObject json = new JSONObject();
			json.put("source", fUtil.fgetDataNew1("source"));
			json.put("rmn", fUtil.fgetDataNew1("rmn"));
			System.out.println("JSON is generated --" + json.toJSONString());

			fUtil.flogResult("Passed", "Generation of Request Body", "Request Body is :  " + json.toJSONString(), 0);

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body  ", "Response is :  " + responseBody, 0);

			String transMessage = response.jsonPath().getString("transMessage");

			System.out.println("Trans Message :" + transMessage);

			/* Scenarios */
			if (transMessage.contains("NO_SUBID_TAGGED")) {
				fUtil.flogResult("Passed", "Validate Response Body",
						"Validated successfully and message is : " + transMessage, 0);
			} else if (transMessage.contains("SUCCESS")) {
				fUtil.flogResult("Passed", "Validate Response Body",
						"Validated successfully and message is : " + transMessage, 0);
			} else if (transMessage.contains("MULTIPLE_RMN")) {
				fUtil.flogResult("Passed", "Validate Response Body",
						"Validated successfully and message is : " + transMessage, 0);
			} else if (transMessage.contains("INVALID_SOURCE")) {
				fUtil.flogResult("Passed", "Validate Response Body",
						"Validated successfully and message is : " + transMessage, 0);
			} else if (transMessage.contains("BOTH_SUBID_AND_RMN_NULL")) {
				fUtil.flogResult("Passed", "Validate Response Body",
						"Validated successfully and message is : " + transMessage, 0);
			} else if (transMessage.contains("SOURCE_IS_NULL")) {
				fUtil.flogResult("Passed", "Validate Response Body",
						"Validated successfully and message is : " + transMessage, 0);
			} else if (transMessage.contains("INPUT_IS_NULL")) {
				fUtil.flogResult("Passed", "Validate Response Body",
						"Validated successfully and message is : " + transMessage, 0);
			} else {
				fUtil.flogResult("Failed", "Validate Response Body", "Trans Messsage is :" + transMessage, 0);
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fUtil.flogResult("Failed", "API Response for checkGR", "API Response forcheckGR failed-" + e.getMessage(),
					0);
		}
	}

//random mobile number
	/*
	 * public String randommobilenumber() { String random5Digts =
	 * UUID.randomUUID().toString().substring(0, 5); String
	 * randomNumber="ORDERSSRSS"+random5Digts; StringBuilder sb = new
	 * StringBuilder(randomNumber);
	 * 
	 * for (int index = 0; index < sb.length(); index++) { char c =
	 * sb.charAt(index); if (Character.isLowerCase(c)) { sb.setCharAt(index,
	 * Character.toUpperCase(c)); } }
	 * 
	 * System.out.println("Random number is " + sb.toString()); String number =
	 * sb.toString(); System.out.println(number);
	 * 
	 * return number; }
	 */
	@Test
	public void userEnrollment() throws Exception {
		try {
			/*
			 * baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth"); baseUriToken=
			 * fUtil.fgetDataNew1("BaseUriToken"); h_clientId=
			 * fUtil.fgetDataNew1("ClientId"); h_secretKey= fUtil.fgetDataNew1("SecretKey");
			 * code_challenge= fUtil.fgetDataNew1("Code_challenge"); countryCode ="91";
			 * mobileNumber= fUtil.fgetDataNew1("MobileNumber"); password=
			 * fUtil.fgetDataNew1("Password");
			 * code_verifier=fUtil.fgetDataNew1("code_verifier"); bearerToken =
			 * generateaccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey,
			 * code_challenge, countryCode, mobileNumber, password, code_verifier);
			 */
			// CHECK PHONE
			RestAssured.baseURI = fUtil.fgetDataNew1("BaseUriAuth");

			RequestSpecification request_rfId = RestAssured.given();
			// 9
			request_rfId.header("Content-Type", "application/json");
			request_rfId.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_rfId.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			// String data = gmethods.randommobilenumber();
			String data = gmethods.randomMobileNumber(9, "Numeric", "");
			System.out.println("Mobile no is:" + data);
			JSONObject json_rfID = new JSONObject();

			json_rfID.put("countryCode", "91");
			json_rfID.put("phone", data);

			request_rfId.body(json_rfID.toJSONString());
			Response response_rfID = request_rfId.post();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response_rfID.getBody().asString();
			System.out.println("Response Body for Check Phone is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body Check Phone ", "Response is :  " + responseBody1,
					0);

			String refId = response_rfID.jsonPath().get("refId");
			System.out.println("RefId is: " + refId);

			// Verify SignUp OTP

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");

			RequestSpecification request_signupOtp = RestAssured.given();

			request_signupOtp.header("Content-Type", "application/json");
			request_signupOtp.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_signupOtp.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			JSONObject json = new JSONObject();

			json.put("countryCode", "91");
			json.put("mobileNumber", data);
			json.put("otp", "123456");
			json.put("refId", refId);

			request_signupOtp.body(json.toJSONString());
			System.out.println("Request Body is: " + json.toJSONString());

			Response response = request_signupOtp.post();

			Cookies cookie_verifyOtp = response.detailedCookies();

			String cookie = cookie_verifyOtp.toString();

			System.out.println("Cokies value is : " + cookie);

			// String s1="java string; split method by javatpoint";
			String[] cookieSession = cookie.split(";");
			System.out.println(cookieSession[0]);

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body for Verify SignUp OTP",
					"Response is :  " + responseBody, 0);

			String enrolment_Stage = response.jsonPath().get("enrolmentStage");
			System.out.println("CustomerHash:" + enrolment_Stage);

			if (enrolment_Stage.contains("OTP_VERIFIED")) {
				fUtil.flogResult("Passed", "OTP Validation", "OTP validation successful with msg  " + enrolment_Stage,
						0);
			} else {

				fUtil.flogResult("Failed", "OTP Validation", "OTP validation failed with msg  ", 0);
			}

			// SET Password

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_pswd = RestAssured.given();

			request_pswd.header("Content-Type", "application/json");
			// request_pswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
			// request_pswd.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request_pswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_pswd.header("client_secret", fUtil.fgetDataNew1("SecretKey"));
			request_pswd.header("Cookie", cookieSession[0]);

			JSONObject json_pswd = new JSONObject();

			json_pswd.put("password", fUtil.fgetDataNew1("Password"));
			json_pswd.put("confirmPassword", fUtil.fgetDataNew1("Password"));

			System.out.println("Request Body is: " + json_pswd.toJSONString());

			request_pswd.body(json_pswd.toJSONString());

			Response response_pswd = request_pswd.post();

			Cookies cookie_value3 = response_pswd.detailedCookies();

			System.out.println("Cokies" + cookie_value3);

			System.out.println("----Getting Response Body -----");

			String responseBody_pswd = response_pswd.getBody().asString();

			System.out.println("Response Body is:" + responseBody_pswd);
			fUtil.flogResult("Passed", "Generation of response body SET Password",
					"Response is :  " + responseBody_pswd, 0);

			int statusCode_setPswd = response_pswd.getStatusCode();
			System.out.println("Status code is: " + statusCode_setPswd);
			if (statusCode_setPswd == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for SET Password",
						"Status Code is " + statusCode_setPswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for SET Password",
						"Expected Status Code is 200 but it is " + statusCode_setPswd, 0);
			}

			String statusLine_setPswd = response_pswd.getStatusLine();
			System.out.println("Status line for SET Password is:" + statusLine_setPswd);
			if (statusLine_setPswd.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for SET Password",
						"Status Line is " + statusLine_setPswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for SET Password",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_setPswd, 0);
			}

			// User Profile

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI4");

			RequestSpecification request_user = RestAssured.given();
			// 9
			request_user.header("Content-Type", "application/json");
			request_user.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_user.header("client_secret", fUtil.fgetDataNew1("SecretKey"));
			request_user.header("Cookie", cookieSession[0]);

			JSONObject json_user = new JSONObject();
			/*
			 * json.put("creationType","LocalAccount");
			 * json.put("firstName",fUtil.fgetDataNew1("FirstName"));
			 * json.put("lastName",fUtil.fgetDataNew1("LastName"));
			 * json.put("dob",fUtil.fgetDataNew1("DOB"));
			 * json.put("gender",fUtil.fgetDataNew1("Gender"));
			 * json.put("email",fUtil.fgetDataNew1("Email")); json.put("tcpConsent","true");
			 * json.put("marketingConsent","true");
			 * json.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			 * 
			 */
			// String lastname = gmethods.randomString(5, "Alpha", "");
			json_user.put("creationType", "LocalAccount");
			json_user.put("firstName", fUtil.fgetDataNew1("firstName"));
			json_user.put("lastName", fUtil.fgetDataNew1("lastname"));
			json_user.put("dob", fUtil.fgetDataNew1("dob"));
			json_user.put("gender", fUtil.fgetDataNew1("gender"));
			String email = gmethods.randomemail();
			json_user.put("email", email);
			json_user.put("tcpConsent", "true");
			json_user.put("MarketingConsent", "true");
		//	json_user.put("referralCode", null);
			json_user.put("redirectUrl","https%3A%2F%2Fsit.tatadigital.com%2Flogin-callback%3F");
			json_user.put("codeChallenge", fUtil.fgetDataNew1("Code_challenge"));

			request_user.body(json_user.toJSONString());
			Response response_user = request_user.put();

			System.out.println("----Getting Response Body -----");
			String responseBody_user = response_user.getBody().asString();
			System.out.println("Response Body is:" + responseBody_user);
			fUtil.flogResult("Passed", "Generation of response body for User Profile",
					"Response is :  " + responseBody_user, 0);

			int statusCode_user = response_user.getStatusCode();
			System.out.println("Status code is: " + statusCode_user);
			if (statusCode_user == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for User Profile",
						"Status Code is " + statusCode_user, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for User Profile",
						"Expected Status Code is 200 but it is " + statusCode_user, 0);
			}

			String statusLine_user = response_user.getStatusLine();
			System.out.println("Status line is:" + statusLine_user);
			if (statusLine_user.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for User Profile",
						"Status Line is " + statusLine_user, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for User Profile",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_user, 0);
			}
//Login using new Number registration

			baseUriAuth = fUtil.fgetDataNew1("BaseUriToken");
			// baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
			String auth_Code = "";

			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			// request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			// request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("SecretKey"));
			JSONObject json_login = new JSONObject();
			json_login.put("countryCode", "91");
			json_login.put("phone", data);
			json_login.put("password", fUtil.fgetDataNew1("Password"));
			json_login.put("codeChallenge", fUtil.fgetDataNew1("Code_challenge"));

			System.out.println("Request Body is:" + json_login.toJSONString());
			request.body(json_login.toJSONString());
			Response response_login = request.post();

			String responseBody_login = response_login.getBody().asString();
			System.out.println("Response Body is:" + responseBody_login);

			fUtil.flogResult("Passed", "Generation of response body for Authcode Generation",
					"Response is :  " + responseBody_login, 0);

			auth_Code = response_login.jsonPath().get("authCode");
			System.out.println("AuthCode is : " + auth_Code);
			if (!(auth_Code.contains("Invalid credentials"))) {
				fUtil.flogResult("Passed", "Validate the Status Line Authcode Generation",
						"Status Line is " + auth_Code, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line Authcode Generation",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + auth_Code, 0);
			}

			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code Authcode Generation",
						"Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line Authcode Generation",
						"Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line Authcode Generation",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}

	@Test
	public void refresToken() throws Exception {
		try {

			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken = fUtil.fgetDataNew1("BaseUriToken");
			h_clientId = fUtil.fgetDataNew1("ClientId");
			h_secretKey = fUtil.fgetDataNew1("SecretKey");
			code_challenge = fUtil.fgetDataNew1("Code_challenge");
			countryCode = "91";
			mobileNumber = fUtil.fgetDataNew1("MobileNumber");
			password = fUtil.fgetDataNew1("Password");

			String refreshToken1 = generateRefreshToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey,
					code_challenge, countryCode, mobileNumber, password);

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("SecretKey"));
			// request.header("Authorization", "Basic dGNwYXBwOnRjcDEyMw==");

			JSONObject json = new JSONObject();

			json.put("refreshToken", refreshToken1);

			request.body(json.toJSONString());
			Response response = request.post();

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody, 0);

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
				fUtil.flogResult("Passed", "Validate Response ", "Validated successfully with token as " + token_type,
						0);
			} else {
				fUtil.flogResult("Failed", "Validation failed ", "Expected token type bearer but it is " + token_type,
						0);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}

	public String generateRefreshToken(String baseUriAuth, String baseUriToken, String h_clientId, String h_secretKey,
			String code_challenge, String countryCode, String mobileNumber, String password) throws Exception {

		String refreshToken = "";
		try {

			/*
			 * ============================================ AuthCode
			 * Generation===========================================
			 */
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
			jsonToken.put("codeVerifier", "codeVerifier");

			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();

			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);

			refreshToken = responseToken.jsonPath().get("refreshToken");

			System.out.println("Refresh token  is : " + refreshToken);

		} catch (Exception ee) {
			System.out.println("Failed and the message is : " + ee.getMessage());
		}
		return refreshToken;

	}

	@Test
	public void createSession() throws Exception {
		try {

			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken = fUtil.fgetDataNew1("BaseUriToken");
			String auth_Code = "";

			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			JSONObject json = new JSONObject();
			json.put("countryCode", "91");
			json.put("phone", fUtil.fgetDataNew1("MobileNumber"));
			json.put("password", fUtil.fgetDataNew1("Password"));
			json.put("codeChallenge", fUtil.fgetDataNew1("Code_challenge"));

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
			requestToken.header("client_id", fUtil.fgetDataNew1("ClientId"));
			requestToken.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", "codeVerifier");

			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();

			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);

			String accessTokn = responseToken.jsonPath().get("accessToken");
			String refreshTokn = responseToken.jsonPath().get("refreshToken");

			System.out.println("Access token  is : " + accessTokn);
			System.out.println("Refresh token  is : " + refreshTokn);

			/* Create Session */

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_s = RestAssured.given();
			// 9
			request_s.header("Content-Type", "application/json");
			request_s.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_s.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			JSONObject json_s = new JSONObject();

			json_s.put("accessToken", accessTokn);
			json_s.put("refreshToken", refreshTokn);
			json_s.put("clientId", fUtil.fgetDataNew1("ClientId"));

			System.out.println("JSON is generated --" + json_s.toJSONString());

			request_s.body(json_s.toJSONString());
			Response response_s = request_s.post();

			System.out.println("----Getting Response Body -----");
			String responseBody2 = response_s.getBody().asString();
			System.out.println("Response Body is:" + responseBody2);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody2, 0);

			String success = response_s.jsonPath().get("success");
			System.out.println("Success message is:" + success);

			if (success.contains("Token Generated")) {
				fUtil.flogResult("Passed", "Token Validation", "Token validation successful with msg  " + success, 0);
			} else {

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
	public void updatePassword() throws Exception {
		try {
			/*
			 * baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth"); baseUriToken=
			 * fUtil.fgetDataNew1("BaseUriToken"); h_clientId=
			 * fUtil.fgetDataNew1("ClientId"); h_secretKey= fUtil.fgetDataNew1("SecretKey");
			 * code_challenge= fUtil.fgetDataNew1("Code_challenge"); countryCode ="91";
			 * mobileNumber= fUtil.fgetDataNew1("MobileNumber"); password=
			 * fUtil.fgetDataNew1("Password");
			 * code_verifier=fUtil.fgetDataNew1("code_verifier"); bearerToken =
			 * generateaccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey,
			 * code_challenge, countryCode, mobileNumber, password, code_verifier);
			 */

			// CHECK PHONE
			RestAssured.baseURI = fUtil.fgetDataNew1("BaseUriAuth");

			RequestSpecification request_rfId = RestAssured.given();
			// 9
			request_rfId.header("Content-Type", "application/json");
			request_rfId.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_rfId.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			// String data = gmethods.randommobilenumber();
			String data = gmethods.randomMobileNumber(9, "Numeric", "");
			System.out.println("Mobile no is:" + data);
			JSONObject json_rfID = new JSONObject();

			json_rfID.put("countryCode", "91");
			json_rfID.put("phone", data);

			request_rfId.body(json_rfID.toJSONString());
			Response response_rfID = request_rfId.post();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response_rfID.getBody().asString();
			System.out.println("Response Body for Check Phone is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body Check Phone ", "Response is :  " + responseBody1,
					0);

			String refId = response_rfID.jsonPath().get("refId");
			System.out.println("RefId is: " + refId);

			// Verify SignUp OTP

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");

			RequestSpecification request_signupOtp = RestAssured.given();

			request_signupOtp.header("Content-Type", "application/json");
			request_signupOtp.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_signupOtp.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			JSONObject json = new JSONObject();

			json.put("countryCode", "91");
			json.put("mobileNumber", data);
			json.put("otp", "123456");
			json.put("refId", refId);

			request_signupOtp.body(json.toJSONString());
			System.out.println("Request Body is: " + json.toJSONString());

			Response response = request_signupOtp.post();

			Cookies cookie_verifyOtp = response.detailedCookies();

			String cookie = cookie_verifyOtp.toString();

			System.out.println("Cokies value is : " + cookie);

			// String s1="java string; split method by javatpoint";
			String[] cookieSession = cookie.split(";");
			System.out.println(cookieSession[0]);

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body for Verify SignUp OTP",
					"Response is :  " + responseBody, 0);

			String enrolment_Stage = response.jsonPath().get("enrolmentStage");
			System.out.println("CustomerHash:" + enrolment_Stage);

			if (enrolment_Stage.contains("OTP_VERIFIED")) {
				fUtil.flogResult("Passed", "OTP Validation", "OTP validation successful with msg  " + enrolment_Stage,
						0);
			} else {

				fUtil.flogResult("Failed", "OTP Validation", "OTP validation failed with msg  ", 0);
			}

			// SET Password

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_pswd = RestAssured.given();

			request_pswd.header("Content-Type", "application/json");
			// request_pswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
			// request_pswd.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request_pswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_pswd.header("client_secret", fUtil.fgetDataNew1("SecretKey"));
			request_pswd.header("Cookie", cookieSession[0]);

			JSONObject json_pswd = new JSONObject();

			json_pswd.put("password", fUtil.fgetDataNew1("Password"));
			json_pswd.put("confirmPassword", fUtil.fgetDataNew1("Password"));

			System.out.println("Request Body is: " + json_pswd.toJSONString());

			request_pswd.body(json_pswd.toJSONString());

			Response response_pswd = request_pswd.post();

			Cookies cookie_value3 = response_pswd.detailedCookies();

			System.out.println("Cokies" + cookie_value3);

			System.out.println("----Getting Response Body -----");

			String responseBody_pswd = response_pswd.getBody().asString();

			System.out.println("Response Body is:" + responseBody_pswd);
			fUtil.flogResult("Passed", "Generation of response body SET Password",
					"Response is :  " + responseBody_pswd, 0);

			int statusCode_setPswd = response_pswd.getStatusCode();
			System.out.println("Status code is: " + statusCode_setPswd);
			if (statusCode_setPswd == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for SET Password",
						"Status Code is " + statusCode_setPswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for SET Password",
						"Expected Status Code is 200 but it is " + statusCode_setPswd, 0);
			}

			String statusLine_setPswd = response_pswd.getStatusLine();
			System.out.println("Status line for SET Password is:" + statusLine_setPswd);
			if (statusLine_setPswd.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for SET Password",
						"Status Line is " + statusLine_setPswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for SET Password",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_setPswd, 0);
			}

			// Update Password

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI3");

			RequestSpecification request_Updatepswd = RestAssured.given();
			// 9
			request_Updatepswd.header("Content-Type", "application/json");
			request_Updatepswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_Updatepswd.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			request_Updatepswd.header("Cookie", cookieSession[0]);

			JSONObject json_Updatepswd = new JSONObject();

			json_Updatepswd.put("oldPassword", fUtil.fgetDataNew1("Password"));
			json_Updatepswd.put("newPassword", fUtil.fgetDataNew1("newPassword"));
			json_Updatepswd.put("confirmNewPassword", fUtil.fgetDataNew1("newPassword"));

			System.out.println("Request Body is: " + json_Updatepswd.toJSONString());

			request_Updatepswd.body(json_Updatepswd.toJSONString());

			Response response_Updatepswd = request_Updatepswd.post();

			System.out.println("----Getting Response Body -----");
			String responseBody_Updatepswd = response_Updatepswd.getBody().asString();
			System.out.println("Response Body is:" + responseBody_Updatepswd);
			fUtil.flogResult("Passed", "Generation of response body for Update Password ",
					"Response is :  " + responseBody_Updatepswd, 0);

			int statusCode_Updatepswd = response_Updatepswd.getStatusCode();
			System.out.println("Status code is: " + statusCode_Updatepswd);
			if (statusCode_Updatepswd == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for Update Password",
						"Status Code is " + statusCode_Updatepswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for Update Password",
						"Expected Status Code is 200 but it is " + statusCode_Updatepswd, 0);
			}

			String statusLine_Updatepswd = response_Updatepswd.getStatusLine();
			System.out.println("Status line is:" + statusLine_Updatepswd);
			if (statusLine_Updatepswd.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for Upadte Password",
						"Status Line is " + statusLine_Updatepswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for Upadte Password",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_Updatepswd, 0);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}

	@Test
	public void userEnrollmentTcpLoginBrand() throws Exception {
		try {
			/*
			 * baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth"); baseUriToken=
			 * fUtil.fgetDataNew1("BaseUriToken"); h_clientId=
			 * fUtil.fgetDataNew1("ClientId"); h_secretKey= fUtil.fgetDataNew1("SecretKey");
			 * code_challenge= fUtil.fgetDataNew1("Code_challenge"); countryCode ="91";
			 * mobileNumber= fUtil.fgetDataNew1("MobileNumber"); password=
			 * fUtil.fgetDataNew1("Password");
			 * code_verifier=fUtil.fgetDataNew1("code_verifier"); bearerToken =
			 * generateaccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey,
			 * code_challenge, countryCode, mobileNumber, password, code_verifier);
			 */
			// CHECK PHONE
			RestAssured.baseURI = fUtil.fgetDataNew1("BaseUriAuth");

			RequestSpecification request_rfId = RestAssured.given();
			// 9
			request_rfId.header("Content-Type", "application/json");
			request_rfId.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_rfId.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			// String data = gmethods.randommobilenumber();
			String data = gmethods.randomMobileNumber(9, "Numeric", "");
			System.out.println("Mobile no is:" + data);
			JSONObject json_rfID = new JSONObject();

			json_rfID.put("countryCode", "91");
			json_rfID.put("phone", data);

			request_rfId.body(json_rfID.toJSONString());
			Response response_rfID = request_rfId.post();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response_rfID.getBody().asString();
			System.out.println("Response Body for Check Phone is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body Check Phone ", "Response is :  " + responseBody1,
					0);

			String refId = response_rfID.jsonPath().get("refId");
			System.out.println("RefId is: " + refId);

			// Verify SignUp OTP

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");

			RequestSpecification request_signupOtp = RestAssured.given();

			request_signupOtp.header("Content-Type", "application/json");
			request_signupOtp.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_signupOtp.header("client_secret", fUtil.fgetDataNew1("SecretKey"));

			JSONObject json = new JSONObject();

			json.put("countryCode", "91");
			json.put("mobileNumber", data);
			json.put("otp", "123456");
			json.put("refId", refId);

			request_signupOtp.body(json.toJSONString());
			System.out.println("Request Body is: " + json.toJSONString());

			Response response = request_signupOtp.post();

			Cookies cookie_verifyOtp = response.detailedCookies();

			String cookie = cookie_verifyOtp.toString();

			System.out.println("Cokies value is : " + cookie);

			// String s1="java string; split method by javatpoint";
			String[] cookieSession = cookie.split(";");
			System.out.println(cookieSession[0]);

			System.out.println("----Getting Response Body -----");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body for Verify SignUp OTP",
					"Response is :  " + responseBody, 0);

			String enrolment_Stage = response.jsonPath().get("enrolmentStage");
			System.out.println("CustomerHash:" + enrolment_Stage);

			if (enrolment_Stage.contains("OTP_VERIFIED")) {
				fUtil.flogResult("Passed", "OTP Validation", "OTP validation successful with msg  " + enrolment_Stage,
						0);
			} else {

				fUtil.flogResult("Failed", "OTP Validation", "OTP validation failed with msg  ", 0);
			}

			// SET Password

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request_pswd = RestAssured.given();

			request_pswd.header("Content-Type", "application/json");
			// request_pswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
			// request_pswd.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request_pswd.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_pswd.header("client_secret", fUtil.fgetDataNew1("SecretKey"));
			request_pswd.header("Cookie", cookieSession[0]);

			JSONObject json_pswd = new JSONObject();

			json_pswd.put("password", fUtil.fgetDataNew1("Password"));
			json_pswd.put("confirmPassword", fUtil.fgetDataNew1("Password"));

			System.out.println("Request Body is: " + json_pswd.toJSONString());

			request_pswd.body(json_pswd.toJSONString());

			Response response_pswd = request_pswd.post();

			Cookies cookie_value3 = response_pswd.detailedCookies();

			System.out.println("Cokies" + cookie_value3);

			System.out.println("----Getting Response Body -----");

			String responseBody_pswd = response_pswd.getBody().asString();

			System.out.println("Response Body is:" + responseBody_pswd);
			fUtil.flogResult("Passed", "Generation of response body SET Password",
					"Response is :  " + responseBody_pswd, 0);

			int statusCode_setPswd = response_pswd.getStatusCode();
			System.out.println("Status code is: " + statusCode_setPswd);
			if (statusCode_setPswd == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for SET Password",
						"Status Code is " + statusCode_setPswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for SET Password",
						"Expected Status Code is 200 but it is " + statusCode_setPswd, 0);
			}

			String statusLine_setPswd = response_pswd.getStatusLine();
			System.out.println("Status line for SET Password is:" + statusLine_setPswd);
			if (statusLine_setPswd.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for SET Password",
						"Status Line is " + statusLine_setPswd, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for SET Password",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_setPswd, 0);
			}

			// User Profile

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI4");

			RequestSpecification request_user = RestAssured.given();
			// 9
			request_user.header("Content-Type", "application/json");
			request_user.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_user.header("client_secret", fUtil.fgetDataNew1("SecretKey"));
			request_user.header("Cookie", cookieSession[0]);

			JSONObject json_user = new JSONObject();
			/*
			 * json.put("creationType","LocalAccount");
			 * json.put("firstName",fUtil.fgetDataNew1("FirstName"));
			 * json.put("lastName",fUtil.fgetDataNew1("LastName"));
			 * json.put("dob",fUtil.fgetDataNew1("DOB"));
			 * json.put("gender",fUtil.fgetDataNew1("Gender"));
			 * json.put("email",fUtil.fgetDataNew1("Email")); json.put("tcpConsent","true");
			 * json.put("marketingConsent","true");
			 * json.put("codeChallenge",fUtil.fgetDataNew1("Code_challenge"));
			 * 
			 */
			// String lastname = gmethods.randomString(5, "Alpha", "");
			json_user.put("creationType", "LocalAccount");
			json_user.put("firstName", fUtil.fgetDataNew1("firstName"));
			json_user.put("lastName", fUtil.fgetDataNew1("lastname"));
			json_user.put("dob", fUtil.fgetDataNew1("dob"));
			json_user.put("gender", fUtil.fgetDataNew1("gender"));
			String email = gmethods.randomemail();
			json_user.put("email", email);
			json_user.put("tcpConsent", "true");
			json_user.put("MarketingConsent", "true");
		
			json_user.put("redirectUrl","https%3A%2F%2Fsit.tatadigital.com%2Flogin-callback%3F");
			json_user.put("codeChallenge", fUtil.fgetDataNew1("Code_challenge"));

			request_user.body(json_user.toJSONString());
			Response response_user = request_user.put();

			System.out.println("----Getting Response Body -----");
			String responseBody_user = response_user.getBody().asString();
			System.out.println("Response Body is:" + responseBody_user);
			fUtil.flogResult("Passed", "Generation of response body for User Profile",
					"Response is :  " + responseBody_user, 0);

			int statusCode_user = response_user.getStatusCode();
			System.out.println("Status code is: " + statusCode_user);
			if (statusCode_user == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code for User Profile",
						"Status Code is " + statusCode_user, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code for User Profile",
						"Expected Status Code is 200 but it is " + statusCode_user, 0);
			}

			String statusLine_user = response_user.getStatusLine();
			System.out.println("Status line is:" + statusLine_user);
			if (statusLine_user.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line for User Profile",
						"Status Line is " + statusLine_user, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line for User Profile",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine_user, 0);
			}
//Login using new Number registration

			baseUriAuth = fUtil.fgetDataNew1("BaseUriToken");
			// baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
			String auth_Code = "";

			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			// request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			// request.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request.header("client_secret", fUtil.fgetDataNew1("SecretKey"));
			JSONObject json_login = new JSONObject();
			json_login.put("countryCode", "91");
			json_login.put("phone", data);
			json_login.put("password", fUtil.fgetDataNew1("Password"));
			json_login.put("codeChallenge", fUtil.fgetDataNew1("Code_challenge"));

			System.out.println("Request Body is:" + json_login.toJSONString());
			request.body(json_login.toJSONString());
			Response response_login = request.post();

			String responseBody_login = response_login.getBody().asString();
			System.out.println("Response Body is:" + responseBody_login);

			fUtil.flogResult("Passed", "Generation of response body for Authcode Generation",
					"Response is :  " + responseBody_login, 0);

			auth_Code = response_login.jsonPath().get("authCode");
			System.out.println("AuthCode is : " + auth_Code);
			if (!(auth_Code.contains("Invalid credentials"))) {
				fUtil.flogResult("Passed", "Validate the Status Line Authcode Generation",
						"Status Line is " + auth_Code, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line Authcode Generation",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + auth_Code, 0);
			}

			int statusCode = response_login.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code Authcode Generation",
						"Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

			String statusLine = response_login.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line Authcode Generation",
						"Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line Authcode Generation",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

			// Login using new Number registration in Croma

			baseUriAuth = fUtil.fgetDataNew1("BaseUriToken");
			// baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
			String auth_Code2 = "";

			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request2 = RestAssured.given();

			request2.header("Content-Type", "application/json");
			// request2.header("client_id", fUtil.fgetDataNew1("ClientId"));
			// request2.header("client_secret", fUtil.fgetDataNew1("Clientsecret"));
			request2.header("client_id", fUtil.fgetDataNew1("ClientId2"));
			request2.header("client_secret", fUtil.fgetDataNew1("SecretKey2"));
			JSONObject json_login2 = new JSONObject();
			json_login2.put("countryCode", "91");
			json_login2.put("phone", data);
			json_login2.put("password", fUtil.fgetDataNew1("Password"));
			json_login2.put("codeChallenge", fUtil.fgetDataNew1("Code_challenge2"));

			System.out.println("request2 Body is:" + json_login2.toJSONString());
			request2.body(json_login2.toJSONString());
			Response response_login2 = request2.post();

			String responseBody_login2 = response_login2.getBody().asString();
			System.out.println("Response Body is:" + responseBody_login2);

			fUtil.flogResult("Passed", "Generation of response body for Authcode Generation",
					"Response is :  " + responseBody_login2, 0);

			auth_Code2 = response_login2.jsonPath().get("authCode");
			System.out.println("AuthCode is : " + auth_Code2);
			if (!(auth_Code2.contains("Invalid credentials"))) {
				fUtil.flogResult("Passed", "Validate the Status Line Authcode Generation",
						"Status Line is " + auth_Code2, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line Authcode Generation",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + auth_Code2, 0);
			}

			int statusCode2 = response_login2.getStatusCode();
			System.out.println("Status code is: " + statusCode2);
			if (statusCode2 == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code Authcode Generation",
						"Status Code is " + statusCode2, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode2, 0);
			}

			String statusLine2 = response_login2.getStatusLine();
			System.out.println("Status line is:" + statusLine2);
			if (statusLine2.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line Authcode Generation",
						"Status Line is " + statusLine2, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line Authcode Generation",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine2, 0);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get Address Info",
					"API Response for Get Address Info failed-" + ee.getMessage(), 0);

		}
	}

	@Test
	public void redemptionHistory() throws Exception {
		try {

			aurl = fUtil.fgetDataNew1("Base_URI");
			String requestBody = fUtil.fgetDataNew1("Request");
			// String respvalues=fUtil.fgetDataNew1("Responsefields");
			System.out.println("mpostAPI : Base_URI : " + aurl);
			Response response = postapi(aurl, requestBody);
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is : " + responseBody);
			// String access_Token = response.jsonPath().getString("accessToken");
			String access_Token = response.jsonPath().get("data.accessToken");

			System.out.println("Access token  is : " + access_Token);

			System.out.println("----Getting Response Body -----");
			String responseBody2 = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody2);
			fUtil.flogResult("Passed", "Generation of response body ", "Response is :  " + responseBody2, 0);

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
			if (statusLine.contains("HTTP/1.1 200")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Redemption History Api",
					"API Response for Redemption History Api failed-" + ee.getMessage(), 0);

		}
	}

	@Test
	public void loginwithEmail() throws Exception {
		try {
			Response response1 = null;
			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken = fUtil.fgetDataNew1("BaseUriToken");
			h_clientId = fUtil.fgetDataNew1("ClientId");
			h_secretKey = fUtil.fgetDataNew1("SecretKey");
			code_challenge = fUtil.fgetDataNew1("Code_challenge");
			countryCode = "91";
			mobileNumber = fUtil.fgetDataNew1("MobileNumber");
			password = fUtil.fgetDataNew1("Password");
			code_verifier = fUtil.fgetDataNew1("code_verifier");

			String auth_Code = "";
			String temp = RestAssured.baseURI;
			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);

			if (!StringUtils.trimToEmpty(h_secretKey).isEmpty()) {
				request.header("client_secret", h_secretKey);
			} else {
				System.out.println("Secret key is empty");
			}

			JSONObject json = new JSONObject();

			json.put("email", mobileNumber);
			json.put("password", password);
			json.put("redirectUrl","https%3A%2F%2Fsit.tatadigital.com%2Flogin-callback%3F");
			json.put("codeChallenge", code_challenge);

			request.body(json.toJSONString());

			Response response = request.post(RestAssured.baseURI);
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

			if (!StringUtils.trimToEmpty(h_secretKey).isEmpty()) {
				requestToken.header("client_secret", h_secretKey);
			} else {
				System.out.println("Secret key is empty");
			}

			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", code_verifier);

			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();
			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);
			String accessToken = responseToken.jsonPath().get("accessToken");

			System.out.println("Access token  is : " + accessToken);

			String tokenType = "Bearer";
			bearerToken = tokenType + " " + accessToken;
			RestAssured.baseURI = temp;

			Cookies cookie_verifyOtp = response.detailedCookies();

			String cookie = cookie_verifyOtp.toString();

			System.out.println("Cokies value is : " + cookie);

			String[] cookieSession = cookie.split(";");
			System.out.println(cookieSession[0]);

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");
			RequestSpecification request_rfId = RestAssured.given();
			request_rfId.header("Content-Type", "application/json");
			request_rfId.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_rfId.header("Authorization", bearerToken);

			response1 = request_rfId.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response1.getBody().asString();
			System.out.println("Response Body for Fetch Customer is:" + responseBody1);

			fUtil.flogResult("Pass", "Check API response", "Response Received is" + responseBody1, 0);

			int statusCode = response1.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
			String statusLine = response1.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			checkAPIResponseInDetail(response1);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			fUtil.flogResult("Failed", "API Response for checkGR", "API Response forcheckGR failed-" + e.getMessage(),
					0);
		}

	}

	@Test
	public void loginwithTic() throws Exception {
		try {
			Response response1 = null;
			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken = fUtil.fgetDataNew1("BaseUriToken");
			h_clientId = fUtil.fgetDataNew1("ClientId");
			h_secretKey = fUtil.fgetDataNew1("SecretKey");
			code_challenge = fUtil.fgetDataNew1("Code_challenge");
			countryCode = "91";
			mobileNumber = fUtil.fgetDataNew1("MobileNumber");
			password = fUtil.fgetDataNew1("Password");
			code_verifier = fUtil.fgetDataNew1("code_verifier");

			String auth_Code = "";
			String temp = RestAssured.baseURI;
			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);

			if (!StringUtils.trimToEmpty(h_secretKey).isEmpty()) {
				request.header("client_secret", h_secretKey);
			} else {
				System.out.println("Secret key is empty");
			}

			JSONObject json = new JSONObject();

			json.put("ticNumber", mobileNumber);
			json.put("password", password);
			json.put("redirectUrl","https%3A%2F%2Fsit.tatadigital.com%2Flogin-callback%3F");
			json.put("codeChallenge", code_challenge);

			request.body(json.toJSONString());

			Response response = request.post(RestAssured.baseURI);
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

			if (!StringUtils.trimToEmpty(h_secretKey).isEmpty()) {
				requestToken.header("client_secret", h_secretKey);
			} else {
				System.out.println("Secret key is empty");
			}

			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", code_verifier);

			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();
			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);
			String accessToken = responseToken.jsonPath().get("accessToken");

			System.out.println("Access token  is : " + accessToken);

			String tokenType = "Bearer";
			bearerToken = tokenType + " " + accessToken;
			RestAssured.baseURI = temp;

			Cookies cookie_verifyOtp = response.detailedCookies();

			String cookie = cookie_verifyOtp.toString();

			System.out.println("Cokies value is : " + cookie);

			String[] cookieSession = cookie.split(";");
			System.out.println(cookieSession[0]);

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");
			RequestSpecification request_rfId = RestAssured.given();
			request_rfId.header("Content-Type", "application/json");
			request_rfId.header("client_id", fUtil.fgetDataNew1("ClientId"));
			request_rfId.header("Authorization", bearerToken);

			response1 = request_rfId.get();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response1.getBody().asString();
			System.out.println("Response Body for Fetch Customer is:" + responseBody1);

			fUtil.flogResult("Pass", "Check API response", "Response Received is" + responseBody1, 0);

			int statusCode = response1.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
			String statusLine = response1.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}
			checkAPIResponseInDetail(response1);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			fUtil.flogResult("Failed", "API Response for checkGR", "API Response forcheckGR failed-" + e.getMessage(),
					0);
		}

	}
	@Test
	public  String getDeviceInfoIdFromDB(String customerHash) throws Throwable {
		String DeviceInfoIdFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select deviceinfoid from upi.deviceinfo where customerhash='" + customerHash + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				String currentInfoId = conn.executeQuery(query, "deviceinfoid");
				System.out.println("Current InfoId from db is"+currentInfoId);				
				DeviceInfoIdFromDB = currentInfoId;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return DeviceInfoIdFromDB;
	}
	@Test
	public  String getmessageForCashbackFromDB(String orderNo) throws Throwable {
		String getmessageForCashbackFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select res_message from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "res_message");
				System.out.println("Message from db is"+message);				
				getmessageForCashbackFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getmessageForCashbackFromDB;
	}
	@Test
	public  String getBenfeciaryActiveDataFromDB(String customerHash,String beneficiaryVpa) throws Throwable {
		String isActiveFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.beneficiarymaster where customerhash='" + customerHash + "' order by createddate desc limit 1";
			System.out.println(query);
			if (!query.isEmpty()) {
				String vpaFromDb = conn.executeQuery(query, "vpa" );
				System.out.println("vpaFromDb is"+vpaFromDb);	
				String beneficiaryvpaFromDb = decryptVpa(vpaFromDb);
				System.out.println("beneficiaryvpaFromDb after decrypted is"+beneficiaryvpaFromDb);
				if (beneficiaryVpa.equalsIgnoreCase(beneficiaryvpaFromDb)) {
					fUtil.flogResult("Passed", "Beneficiary vpa name", "Matched Successfully in DB :-" + beneficiaryVpa, 0);
				} else {
					fUtil.flogResult("Failed", "Beneficiary vpa name",
							"Not Matched in DB :-" + beneficiaryVpa, 0);
				}
				DBConnection conn2 = new DBConnection();
				String query2 = "select * from upi.beneficiarymaster where customerhash='" + customerHash + "' order by createddate desc limit 1";
			
				String ActiveStausFromDb = conn2.executeQuery(query2, "isactive");
				System.out.println("ActiveStausFromDb is"+ActiveStausFromDb);
				isActiveFromDB = ActiveStausFromDb;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return isActiveFromDB;
	}
	@Test
	public  String getBenfeciaryFavouriteStatusDataFromDB(String customerHash,String beneficiaryVpa) throws Throwable {
		String isFavouriteFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.beneficiarymaster where customerhash='" + customerHash + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				String vpaFromDb = conn.executeQuery(query, "vpa" );
				System.out.println("vpaFromDb is"+vpaFromDb);	
				String beneficiaryvpaFromDb = decryptVpa(vpaFromDb);
				System.out.println("beneficiaryvpaFromDb after decrypted is"+beneficiaryvpaFromDb);
				if (beneficiaryVpa.equalsIgnoreCase(beneficiaryvpaFromDb)) {
					fUtil.flogResult("Passed", "Beneficiary vpa name", "matched Successfully in DB :-" + beneficiaryVpa, 0);
				} else {
					fUtil.flogResult("Failed", "Beneficiary vpa name",
							"Not matched in DB :-" + beneficiaryVpa, 0);
				}
				DBConnection conn2 = new DBConnection();
				String query2 = "select * from upi.beneficiarymaster where customerhash='" + customerHash + "' order by createddate desc limit 1";
				System.out.println(query2);
				String FavouriteStausFromDb = conn2.executeQuery(query2, "isfavourite");
				System.out.println("FavouriteStausFromDb is"+FavouriteStausFromDb);
				isFavouriteFromDB = FavouriteStausFromDb;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return isFavouriteFromDB;
	}
	@Test
	public  String getUpdatedTransactionAmountFromDB(String customerVpa) throws Throwable {
		String txnAmountFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.customervpa where vpa='" + customerVpa + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				 txnAmountFromDB = conn.executeQuery(query, "transactionlimit" );
				//txnAmountFromDB=String.valueOf(txnAmount);
				System.out.println("txnlimit from db is"+txnAmountFromDB);
			
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return txnAmountFromDB;
	}
	@Test
	public  String getDeregisterStausFromDB(String vpa,String deviceinfoid) throws Throwable {
		String DeregisterStatusFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.customervpa where vpa='" + vpa + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				DeregisterStatusFromDB = conn.executeQuery(query, "dregister");
				System.out.println("DeregisterStatusFromDB is"+DeregisterStatusFromDB);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return DeregisterStatusFromDB;
	}
	@Test
	public  String getAuditIdFromDB(String customerHash,String upitranlogid) throws Throwable {
		String AuditIdFromDb = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.auditlog where customerhash='" + customerHash + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				String upitranlogidFromDb = conn.executeQuery(query, "upitranlogid" );
				System.out.println("upitranlogidFromDb is"+upitranlogidFromDb);					
				if (upitranlogid.equalsIgnoreCase(upitranlogidFromDb)) {
					fUtil.flogResult("Passed", "upitranlogid", "matched Successfully in DB :-" + upitranlogidFromDb, 0);
				} else {
					fUtil.flogResult("Failed", "upitranlogid",
							"Not matched in DB :-" + upitranlogidFromDb, 0);
				}
				DBConnection conn2 = new DBConnection();
				String query2 = "select * from upi.auditlog where customerhash='" + customerHash + "' order by createddate desc limit 1";
			
				AuditIdFromDb = conn2.executeQuery(query2, "auditid");
				System.out.println("AuditIdFromDb is"+AuditIdFromDb);							
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return AuditIdFromDb;
	}
	@Test
	public  String getAuditCompletionDateFromDB(String customerHash) throws Throwable {
		String AuditModifiedDateFromDb = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.auditlog where customerhash='" + customerHash + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				AuditModifiedDateFromDb = conn.executeQuery(query, "modifieddate");
				System.out.println("AuditModifiedDateFromDb is"+AuditModifiedDateFromDb);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return AuditModifiedDateFromDb;
	}
	@Test
	public  String getBlockedVpaStatusFromDB(String blockedBy) throws Throwable {
		String BlockedVpaStatusFromDb = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.blockedvpa where blockedby='" + blockedBy + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				BlockedVpaStatusFromDb = conn.executeQuery(query, "status");
				System.out.println("BlockedVpaStatusFromDb is"+BlockedVpaStatusFromDb);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return BlockedVpaStatusFromDb;
	}
	@Test
	public  String getCreatedVpaFromDB(String customerHash,String vpa) throws Throwable {
		String resmessagefromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.customervpa where customerhash='" + customerHash + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				String vpaFromDb = conn.executeQuery(query, "vpa" );
				System.out.println("upitranlogidFromDb is"+vpaFromDb);					
				if (vpaFromDb.equalsIgnoreCase(vpa)) {
					fUtil.flogResult("Passed", "Created vpa", "matched Successfully in DB :-" + vpaFromDb, 0);
				} else {
					fUtil.flogResult("Failed", "Created vpa",
							"Not matched in DB :-" + vpaFromDb, 0);
				}
				DBConnection conn2 = new DBConnection();
				String query2 = "select * from upi.customervpa where customerhash='" + customerHash + "' order by createddate desc limit 1";
			
				resmessagefromDB = conn2.executeQuery(query2, "resmsg");
				System.out.println("resmessagefromDB is"+resmessagefromDB);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return resmessagefromDB;
	}
	@Test
	public  String getaccountFromDB(String customerHash,String accountNumber) throws Throwable {
		String accmasterIDfromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.accountmaster where customerhash='" + customerHash + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				String accountNumberFromDb = conn.executeQuery(query, "accountno" );
				System.out.println("accountnoFromDb is"+accountNumberFromDb);					
				if (accountNumberFromDb.equalsIgnoreCase(accountNumber)) {
					fUtil.flogResult("Passed", "Account Number", "matched Successfully in DB :-" + accountNumberFromDb, 0);
				} else {
					fUtil.flogResult("Failed", "Account Number",
							"Not matched in DB :-" + accountNumberFromDb, 0);
				}
				DBConnection conn2 = new DBConnection();
				String query2 = "select * from upi.accountmaster where customerhash='" + customerHash + "' order by createddate desc limit 1";
			
				accmasterIDfromDB = conn2.executeQuery(query2, "accmasterid");
				System.out.println("accmasterIDfromDB is"+accmasterIDfromDB);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return accmasterIDfromDB;
	}
	@Test
	public  String getDeleteAccountStausFromDB(String customerHash,String accmasterid) throws Throwable {
		String DeleteAccountStatusfromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.accountmaster where customerhash='" + customerHash + "' and accmasterid='" + accmasterid + "'";
			if (!query.isEmpty()) {
				 DeleteAccountStatusfromDB = conn.executeQuery(query, "isactive" );
				System.out.println("DeleteAccountStatusfromDB is"+DeleteAccountStatusfromDB);					
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return DeleteAccountStatusfromDB;
	}
	@Test
	public  String getTransactionIdFromDB(String txnAmount,String accmasterid) throws Throwable {
		String TransactionIdfromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.transactions where accmasterid='" + accmasterid + "' and txnamt='" + txnAmount + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				 String txnidfromDB = conn.executeQuery(query, "txnid" );
				System.out.println("Encrypted txnidfromDB is"+txnidfromDB);					
				TransactionIdfromDB = decryptTxnid(txnidfromDB);
				System.out.println("TransactionIdfromDB after decrypted is"+TransactionIdfromDB);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return TransactionIdfromDB;
	}
	@Test
	public  String getCompleteTrnIdFromDB(String txnAmount,String accmasterid,String resMsg) throws Throwable {
		String CompleteTrnIdfromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.transactions where accmasterid='" + accmasterid + "' and txnamt='" + txnAmount + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				 String txnidfromDB = conn.executeQuery(query, "txnid" );
				System.out.println("Encrypted txnidfromDB is"+txnidfromDB);					
				CompleteTrnIdfromDB = decryptTxnid(txnidfromDB);
				System.out.println("CompleteTrnIdfromDB after decrypted is"+CompleteTrnIdfromDB);
				DBConnection conn2 = new DBConnection();
				String query2 = "select * from upi.transactions where accmasterid='" + accmasterid + "' and txnamt='" + txnAmount + "' order by createddate desc limit 1";		
				 String resMsgfromDB = conn2.executeQuery(query2, "resmsg" );
					System.out.println("resMsgfromDB is"+resMsgfromDB);	
				if (resMsgfromDB.equalsIgnoreCase(resMsg)) {
					fUtil.flogResult("Passed", "resMsg", "matched Successfully in DB :-" + resMsgfromDB, 0);
				} else {
					fUtil.flogResult("Failed", "resMsg",
							"Not matched in DB :-" + resMsgfromDB, 0);
				}
					
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return CompleteTrnIdfromDB;
	}
	@Test
	public  String getdeviceBindingCompletionStatusFromDB(String customerHash) throws Throwable {
		String deviceBindingCompletionStatusfromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.deviceinfo where customerhash='" + customerHash + "' order by createddate desc limit 1";
			if (!query.isEmpty()) {
				deviceBindingCompletionStatusfromDB = conn.executeQuery(query, "resmsg" );
				System.out.println("deviceBindingCompletionStatusfromDB is"+deviceBindingCompletionStatusfromDB);					
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return deviceBindingCompletionStatusfromDB;
	}
	@Test
	public  String getLinkAccountStausFromDB(String customerHash,String accmasterid) throws Throwable {
		String LinkAccountUpiFromDb = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.accountmaster where customerhash='" + customerHash + "' and accmasterid='" + accmasterid + "' order by modifieddate desc limit 1";
			if (!query.isEmpty()) {
				LinkAccountUpiFromDb = conn.executeQuery(query, "vpa" );
				System.out.println("LinkAccountUpiFromDb is"+LinkAccountUpiFromDb);					
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return LinkAccountUpiFromDb;
	}
	@Test
	public  String getModifiedVpaFromDB(String customerHash) throws Throwable {
		String modifiedVpaFromDb = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.customervpa where customerhash='" + customerHash + "' order by modifieddate desc limit 1";
			if (!query.isEmpty()) {
				modifiedVpaFromDb = conn.executeQuery(query, "vpa" );
				System.out.println("modifiedVpaFromDb is"+modifiedVpaFromDb);					
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return modifiedVpaFromDb;
	}
	@Test
	public  String getauthoriseMadateFromDB(String customerHash) throws Throwable {
		String authoriseMadateStatusfromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from upi.mandatemaster where customerhash='" + customerHash + "' order by modifieddate desc limit 1";
			if (!query.isEmpty()) {
				 String txnidfromDB = conn.executeQuery(query, "txnid" );
				System.out.println("Encrypted txnidfromDB is"+txnidfromDB);					
				String DecryptedTrntId = decryptTxnid(txnidfromDB);
				System.out.println("DecryptedTrntId after decrypted is"+DecryptedTrntId);
			   	DBConnection conn2 = new DBConnection();
				String query2 = "select * from upi.mandatemaster where customerhash='" + customerHash + "' order by modifieddate desc limit 1";		
				String mandateidfromDB = conn2.executeQuery(query2, "mandateid" );
				authoriseMadateStatusfromDB=DecryptedTrntId+" which is pair with this mandate id:-"+mandateidfromDB;
					
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return authoriseMadateStatusfromDB;
	}
	@Test
	public String decryptVpa(String beneficiaryvpaFromDb) throws Exception {
		String responseBody = "";
		try {
			RestAssured.baseURI = "http://upi-issuing.sit-upi-release2.tpl.com/tatapay/onboarding/myaccount/decrypt";
			RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).header("encryptedText",
					beneficiaryvpaFromDb);

			responseBody = request.get().getBody().asString();
			int statusCode = request.get().statusCode();
			System.out.println(statusCode);
			System.out.println(responseBody);

		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return responseBody;
	}
	@Test
	public String decryptTxnid(String txnidfromDB) throws Exception {
		String responseBody = "";
		try {
			RestAssured.baseURI = "http://upi-issuing.sit-upi.tatadigital.com/tatapay/onboarding/myaccount/decrypt";
			RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).header("encryptedText",
					txnidfromDB);

			responseBody = request.get().getBody().asString();
			int statusCode = request.get().statusCode();
			System.out.println(statusCode);
			System.out.println(responseBody);

		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return responseBody;
	}
	@Test
	public  String getmessageForCheckTransactionStatusFromDB(String orderNo) throws Throwable {
		String getmessageForCheckTransactionStatusFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "res_message");
				System.out.println("Message from db is"+message);				
				getmessageForCheckTransactionStatusFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getmessageForCheckTransactionStatusFromDB;
	}
	@Test
	public  String getterminalIdForCheckTransactionStatusFromDB(String orderNo) throws Throwable {
		String getterminalIdForCheckTransactionStatusFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "terminal_id");
				System.out.println("Message from db is"+message);				
				getterminalIdForCheckTransactionStatusFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getterminalIdForCheckTransactionStatusFromDB;
	}
	@Test
	public  String getstoreIdForCheckTransactionStatusFromDB(String orderNo) throws Throwable {
		String getstoreIdForCheckTransactionStatusFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "store_id");
				System.out.println("Message from db is"+message);				
				getstoreIdForCheckTransactionStatusFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getstoreIdForCheckTransactionStatusFromDB;
	}
	@Test
	public  String getchannelIdForCheckTransactionStatusFromDB(String orderNo) throws Throwable {
		String getchannelIdForCheckTransactionStatusFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "channel_id");
				System.out.println("Message from db is"+message);				
				getchannelIdForCheckTransactionStatusFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getchannelIdForCheckTransactionStatusFromDB;
	}
	@Test
	public  String getchannelTypeForCheckTransactionStatusFromDB(String orderNo) throws Throwable {
		String getchannelTypeForCheckTransactionStatusFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "channel_type");
				System.out.println("Message from db is"+message);				
				getchannelTypeForCheckTransactionStatusFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getchannelTypeForCheckTransactionStatusFromDB;
	}
	@Test
	public  String getsubMerchantIdForCheckTransactionStatusFromDB(String orderNo) throws Throwable {
		String getsubMerchantIdForCheckTransactionStatusFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "merchant_id");
				System.out.println("Message from db is"+message);				
				getsubMerchantIdForCheckTransactionStatusFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getsubMerchantIdForCheckTransactionStatusFromDB;
	}
	@Test
	public  String getmessageFromDB(String orderNo) throws Throwable {
		String getmessageFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select res_message from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "res_message");
				System.out.println("Message from db is"+message);				
				getmessageFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getmessageFromDB;
	}
	@Test
	public  String getMandatemessageFromDB(String orderNo) throws Throwable {
		String getmessageFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select res_message from public.tbl_mandate_request where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "res_message");
				System.out.println("Message from db is"+message);				
				getmessageFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getmessageFromDB;
	}
	
	@Test
	public  String getterminalIdFromDB(String orderNo) throws Throwable {
		String getterminalIdFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "terminal_id");
				System.out.println("Message from db is"+message);				
				getterminalIdFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getterminalIdFromDB;
	}
	@Test
	public  String getstoreIdFromDB(String orderNo) throws Throwable {
		String getstoreIdFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "store_id");
				System.out.println("Message from db is"+message);				
				getstoreIdFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getstoreIdFromDB;
	}
	@Test
	public  String getchannelIdFromDB(String orderNo) throws Throwable {
		String getchannelIdFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "channel_id");
				System.out.println("Message from db is"+message);				
				getchannelIdFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getchannelIdFromDB;
	}
	@Test
	public  String getchannelTypeFromDB(String orderNo) throws Throwable {
		String getchannelTypeFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "channel_type");
				System.out.println("Message from db is"+message);				
				getchannelTypeFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getchannelTypeFromDB;
	}
	@Test
	public  String getsubMerchantIdFromDB(String orderNo) throws Throwable {
		String getsubMerchantIdFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_transaction where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "merchant_id");
				System.out.println("Message from db is"+message);				
				getsubMerchantIdFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getsubMerchantIdFromDB;
	}
	@Test
	public  String getremarksFromDB(String orderNo) throws Throwable {
		String getremarksFromDB = "";
		try {
			DBConnection conn = new DBConnection();
			String query = "select * from public.tbl_mandate_request where order_id='" + orderNo + "'";
			if (!query.isEmpty()) {
				String message = conn.executeQuery(query, "remarks");
				System.out.println("Message from db is"+message);				
				getremarksFromDB = message;
				
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return getremarksFromDB;
	}
	//Jan 04//revathi//
	public static void validateUC_cart(Response response) {
		try {
			String responseBody = response.getBody().asString();
			String sExpectedtotalPrice = readData("ExpectedtotalPrice");
			String sExpectedsubTotal = readData("ExpectedsubTotal");
			String sExpectedtotalDiscounts = readData("ExpectedtotalDiscounts");
	                if (responseBody.contains("bundleTitle")) {
						String bundleTitle=responseBody.split("bundleTitle")[1].split("\"")[2];
						fUtil.flogResult("Passed", "API response status contains bundleTitle ", "passed" +bundleTitle , 0);
					
					} 
						else {
							fUtil.flogResult("Failed", "API response status does not contains bundleTitle", "Status " , 0);
						}
					
					if (responseBody.contains("bundleDesc")) {
						String bundleDesc=responseBody.split("bundleDesc")[1].split("\"")[2];
						fUtil.flogResult("Passed", "API response status contains bundleDesc ", "passed" +bundleDesc , 0);
					
					} 
						else {
							fUtil.flogResult("Failed", "API response status does not contains bundleDesc", "Status " , 0);
						}
					
					if (responseBody.contains("bundleExpiryDate")) {
						String bundleExpiryDate=responseBody.split("bundleExpiryDate")[1].split("\"")[2];
						fUtil.flogResult("Passed", "API response status contains bundleExpiryDate ", "passed" +bundleExpiryDate , 0);
					
					} 
						else {
							fUtil.flogResult("Failed", "API response status does not contains bundleExpiryDate", "Status " , 0);
						}
					
					
					if (responseBody.contains("thumbnail")) {
						String thumbnail=responseBody.split("thumbnail")[1].split("\"")[2];
						fUtil.flogResult("Passed", "API response status contains thumbnail", "passed" +thumbnail , 0);
					
					} 
						else {
							fUtil.flogResult("Failed", "API response status does not contains thumbnail", "Status" , 0);
						}
					if (responseBody.contains("channelId")) {
						String channelId=responseBody.split("channelId")[1].split("\"")[2];
						fUtil.flogResult("Passed", "API response status contains channelId", "passed" +channelId , 0);
					
					} 
						else {
							fUtil.flogResult("Failed", "API response status does not contains channelId", "Status" , 0);
						}
					if (responseBody.contains("orderEntries")) {
						
						fUtil.flogResult("Passed", "API response status contains orderEntries", "passed" , 0);
					
					} 
						else {
							fUtil.flogResult("Failed", "API response status does not contains orderEntries", "Status" , 0);
						}
if (responseBody.contains("name")) {
	String name=responseBody.split("name")[1].split("\"")[2];
						fUtil.flogResult("Passed", "API response status contains orderEntries", "passed"+name , 0);
					
					} 
						else {
							fUtil.flogResult("Failed", "API response status does not contains orderEntries", "Status" , 0);
						}
	
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void publishCreateOrderData() throws Exception {
		try {
			// Specify base URI
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			// Request object
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");
			request.header("X-programID", "tcp");
			//request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			//request.header("Authorization",fUtil.fgetDataNew1("SecretKey"));
			//request.header("Authorization", "Q4JbWEgU9TIEVabghjY29xrty");
			
			

			FileInputStream fileInputStream = new FileInputStream (new File(".\\src\\main\\resources\\Input Sheets\\Data\\API\\Create_order.json"));
			//FileInputStream fileInputStream = new FileInputStream (new File(fUtil.fgetDataNew1("File_Path")));
			request.body(fileInputStream);
			
			
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body for myoffers ",
					"Response body:" + responseBody, 0);
			
            //Response Body Validation
			
			String status_resBody = response.jsonPath().get("status");
			System.out.println(" status code:" + status_resBody);
			
			if (status_resBody.equals("CREATED") || status_resBody.equals("success")) {
				fUtil.flogResult("Passed", "Validate Response ", "Validated successfully with status as " + status_resBody, 0);
			}else {
				fUtil.flogResult("Failed", "Validation failed ",
						"Expected Status code is success or warning but it is " + status_resBody, 0);
			}

			// status code validation
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
			// status line verification
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine, 0);
			}
			
			if (responseBody.contains("eddFrom")) {
				String eddFrom=responseBody.split("eddFrom")[1].split("\"")[2];
				fUtil.flogResult("Passed", "API response status contains eddFrom ", "passed API response status contains eddFrom" +eddFrom , 0);
			
			} 
				else {
					fUtil.flogResult("Failed", "API response status does not contains bundleTitle", "API response do not contains eddFrom " , 0);
				}
			
			if (responseBody.contains("eddTo")) {
				String eddTo=responseBody.split("eddTo")[1].split("\"")[2];
				fUtil.flogResult("Passed", "API response status contains eddTo ", "passed API response status contains eddTo " +eddTo , 0);
			
			} 
				else {
					fUtil.flogResult("Failed", "API response status does not contains bundleDesc", "API response status do not contains eddTo  " , 0);
				}

			String entry_id = response.jsonPath().get("bundles[0].orderEntries[0]._id");
			int length_entry =entry_id.length();
			System.out.println("Entry ID:" + entry_id);
			System.out.println("Entry ID Length" + length_entry);
			
			if (length_entry== 15) {
				fUtil.flogResult("Passed", "Validate Response ", "Validated successfully with length ", 0);
			}else {
				fUtil.flogResult("Failed", "Validation failed ",
						"entry id length is not matching ", 0);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "Get Cart Information", "Get Cart Information" + ee.getMessage(), 0);

		}
		
  }
	
	
	@Test
	public void publishFindOrderData() throws Exception {
		try {
			String customerHash_ex = readData("customerHash");
			// Specify base URI
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			// Request object
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");
			request.header("X-programID", "tcp");
			//request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			//request.header("Authorization",fUtil.fgetDataNew1("SecretKey"));
			//request.header("Authorization", "Q4JbWEgU9TIEVabghjY29xrty");
			
			

			FileInputStream fileInputStream = new FileInputStream (new File(".\\src\\main\\resources\\Input Sheets\\Data\\API\\Create_order.json"));
			//FileInputStream fileInputStream = new FileInputStream (new File(fUtil.fgetDataNew1("File_Path")));
			request.body(fileInputStream);
			
			
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body for myoffers ",
					"Response body:" + responseBody, 0);
			
            //Response Body Validation
			
			String status_resBody = response.jsonPath().get("status");
			System.out.println(" status code:" + status_resBody);
			
			if (status_resBody.equals("CREATED") || status_resBody.equals("success")) {
				fUtil.flogResult("Passed", "Validate Response ", "Validated successfully with status as " + status_resBody, 0);
			}else {
				fUtil.flogResult("Failed", "Validation failed ",
						"Expected Status code is success or warning but it is " + status_resBody, 0);
			}

			// status code validation
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
			// status line verification
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine, 0);
			}
			
			String purchaseOrder = response.jsonPath().get("purchaseOrderNumber");
			System.out.println("Status line is:" + purchaseOrder);
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");
		//	RestAssured.baseURI=apiurl;
			// Request object
			RequestSpecification request2 = RestAssured.given();
			request2.header("Content-Type", "application/json");
			request2.header("X-programID", "tcp");
			request2.header("CustomerHash", customerHash_ex);
		//String URL =	(RestAssured.baseURI,"/"+purchaseOrder);
			//Response response2 = request2.get();
			Response response2=request2.get("/"+purchaseOrder);
			String responseBody2 = response2.getBody().asString();
			System.out.println("response: " + responseBody2);
			int statusCode2 = response2.getStatusCode();
			System.out.println("Status code is: " + statusCode2);
			if (statusCode2 == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode2, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode2, 0);
			}
			// status line verification
			String statusLine2 = response2.getStatusLine();
			System.out.println("Status line is:" + statusLine2);
			if (statusLine2.contains("HTTP/1.1 200")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine2, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine2, 0);
			}
			  if (responseBody2.contains("bundleTitle")) {
					String bundleTitle=responseBody2.split("bundleTitle")[1].split("\"")[2];
					fUtil.flogResult("Passed", "API response status contains bundleTitle ", "passed API response status contains bundleTitle" +bundleTitle , 0);
				
				} 
					else {
						fUtil.flogResult("Failed", "API response status does not contains bundleTitle", "Status API response status do not contains bundleTitle " , 0);
					}
				
				if (responseBody2.contains("addressType")) {
					String addressType=responseBody2.split("addressType")[1].split("\"")[2];
					fUtil.flogResult("Passed", "API response status contains addressType ", "passed API response status contains addressType" +addressType , 0);
				
				} 
					else {
						fUtil.flogResult("Failed", "API response status does not contains addressType", "Status API response status do not contains addressType " , 0);
					}
				if (responseBody2.contains("bundleId")) {
					String bundleId=responseBody2.split("bundleId")[1].split("\"")[2];
					fUtil.flogResult("Passed", "API response status contains bundleId ", "passed API response status contains bundleId" +bundleId , 0);
				
				} 
					else {
						fUtil.flogResult("Failed", "API response status does not contains bundleId", "Status API response status do not contains bundleId " , 0);
					}
				if (responseBody2.contains("code")) {
					String code=responseBody2.split("code")[1].split("\"")[2];
					fUtil.flogResult("Passed", "API response status contains code ", "passed API response status contains code" +code , 0);
				
				} 
					else {
						fUtil.flogResult("Failed", "API response status does not contains code", "Status API response status do not contains code " , 0);
					}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "Get order Information", "Get order Information" + ee.getMessage(), 0);

		}
		
  }
	
	public static String randomnumberOrderUniversalCart() {

		String randomNumber = "TCP_"+gmethods.randomString(6, "Numeric", "");
		return randomNumber;

	}
	
	public static String randomBundleIDUniversalCart() {
		

			int leftLimit = 0; // numeral '0'
			int rightLimit = 0;
			int targetStringLength = 0;
			Random random = new Random();
			String generatedString = "";

			leftLimit = 48; // numeral '0'
			rightLimit = 57;
			targetStringLength = 5;
			// String generatedString ="";
			generatedString = random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

			String randomNumber = "BUN" + generatedString;
			return randomNumber;

		}
	
	
	//jan12//
	public static void validateWIP(Response response) {
		try {
			String responseBody = response.getBody().asString();
			String sExpectedtotalPrice = readData("ExpectedtotalPrice");
			String bundle = readData("bundleId_UC_4");
			String sExpectedtotalDiscounts = readData("ExpectedtotalDiscounts");
	                if (responseBody.contains(bundle)) {
						String bundleTitle=responseBody.split("bundleTitle")[1].split("\"")[2];
						fUtil.flogResult("Failed", "API response status contains bundleID ", "failed API response status contains bundleID", 0);
					
					} 
						else {
							fUtil.flogResult("Passed", "API response status does not contains bundleID", "Passed API response status does not contains bundleID" , 0);
						}
					
					

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void publishCancelOrderData() throws Exception {
		try {
			String customerHash_ex = readData("customerHash");
			// Specify base URI
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			// Request object
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");
			request.header("X-programID", "tcp");
			//request.header("client_id", fUtil.fgetDataNew1("ClientId"));
			//request.header("Authorization",fUtil.fgetDataNew1("SecretKey"));
			//request.header("Authorization", "Q4JbWEgU9TIEVabghjY29xrty");
			
			

			FileInputStream fileInputStream = new FileInputStream (new File(".\\src\\main\\resources\\Input Sheets\\Data\\API\\Create_order.json"));
			//FileInputStream fileInputStream = new FileInputStream (new File(fUtil.fgetDataNew1("File_Path")));
			request.body(fileInputStream);
			
			
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body for myoffers ",
					"Response body:" + responseBody, 0);
			
            //Response Body Validation
			
			String status_resBody = response.jsonPath().get("status");
			System.out.println(" status code:" + status_resBody);
			
			if (status_resBody.equals("CREATED") || status_resBody.equals("success")) {
				fUtil.flogResult("Passed", "Validate Response ", "Validated successfully with status as " + status_resBody, 0);
			}else {
				fUtil.flogResult("Failed", "Validation failed ",
						"Expected Status code is success or warning but it is " + status_resBody, 0);
			}

			// status code validation
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
			// status line verification
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine, 0);
			}
			
			String purchaseOrder = response.jsonPath().get("purchaseOrderNumber");
			System.out.println("Status line is:" + purchaseOrder);
			String bundleId = response.jsonPath().get("bundles[0].bundleId");
			System.out.println("Status line is:" + bundleId);
			String Id = response.jsonPath().get("_id");
			System.out.println("Status line is:" +Id);
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");
		//	RestAssured.baseURI=apiurl;
			// Request object
			RequestSpecification request2 = RestAssured.given();
			request2.header("Content-Type", "application/json");
			request2.header("X-programID", "tcp");
			request2.header("CustomerHash", customerHash_ex);
		//String URL =	(RestAssured.baseURI,"/"+purchaseOrder);
			//Response response2 = request2.get();
			
			JSONObject json = new JSONObject();

			json.put("bundleId", bundleId);
			json.put("orderId", Id);
			json.put("customerOrderNum", purchaseOrder);
			request2.body(json.toJSONString());
			Response response2 = request2.put();
			//Response response2=request2.get("/"+purchaseOrder);
			String responseBody2 = response2.getBody().asString();
			System.out.println("response: " + responseBody2);
			int statusCode2 = response2.getStatusCode();
			System.out.println("Status code is: " + statusCode2);
			if (statusCode2 == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode2, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode2, 0);
			}
			// status line verification
			String statusLine2 = response2.getStatusLine();
			System.out.println("Status line is:" + statusLine2);
			if (statusLine2.contains("HTTP/1.1 200")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine2, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine2, 0);
			}
			  

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "Get order Information", "Get order Information" + ee.getMessage(), 0);

		}
		
  }
	
//jan 28//
	@Test
	public void publishJuspayAddCard() throws Exception {
		try {
			
			

				String cardNumber = "4111-"+gmethods.randomString(8, "Numeric", "")+"-1111";
				System.out.println("cardNumber"+cardNumber);
						//"TCP_"+gmethods.randomString(6, "Numeric", "");
				

			
			
			String customerHash_ex = readData("customerHash");
			// Specify base URI
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			// Request object
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/x-www-form-urlencoded");
			//request.header("X-programID", "tcp");
			request.header("client_id", "TCP-WEB-APP");
			//request.header("Authorization",fUtil.fgetDataNew1("SecretKey"));
			request.header("Authorization", "RUZCQkUwQzY3M0M0RTkwODYyNkE0MzYyNzJFNjM4Og==");
		
			request.formParam("merchant_id", "tatadigital");
			request.formParam("customer_id", "406a6bd61792e0436bb06ff799328cd4");
			request.formParam("card_number", cardNumber);

			//FileInputStream fileInputStream = new FileInputStream (new File(".\\src\\main\\resources\\Input Sheets\\Data\\API\\Create_order.json"));
			//FileInputStream fileInputStream = new FileInputStream (new File(fUtil.fgetDataNew1("File_Path")));
			//request.body(fileInputStream);
			
			
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body for myoffers ",
					"Response body:" + responseBody, 0);
			
            //Response Body Validation
			
			
			String card_token = response.jsonPath().get("card_token");
			System.out.println("card_token is:" + card_token);
			String card_reference = response.jsonPath().get("card_reference");
			System.out.println("card_reference is:" + card_reference);
			String card_fingerprint = response.jsonPath().get("card_fingerprint");
			System.out.println("card_fingerprint is:" +card_fingerprint);

			// status code validation
			int statusCode = response.statusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
			// status line verification
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine, 0);
			}
			

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "Get order Information", "Get order Information" + ee.getMessage(), 0);

		}
		
  }
	
	@Test
	public void publishAddCard() throws Exception {
		try {
			String cardNumber = "4111-"+gmethods.randomString(8, "Numeric", "")+"-1111";
				System.out.println("cardNumber"+cardNumber);
						//"TCP_"+gmethods.randomString(6, "Numeric", "");
				
			String customerHash_ex = readData("customerHash");
			// Specify base URI
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			// Request object
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/x-www-form-urlencoded");
			//request.header("X-programID", "tcp");
			request.header("client_id", "TCP-WEB-APP");
			//request.header("Authorization",fUtil.fgetDataNew1("SecretKey"));
			//request.header("Authorization", "RUZCQkUwQzY3M0M0RTkwODYyNkE0MzYyNzJFNjM4Og==");
		
			//request.formParam("merchant_id", "tatadigital");
			request.formParam("customer_id", "7d451fe12c48b495c8dd439c74750305");
			request.formParam("card_number", cardNumber);

			//FileInputStream fileInputStream = new FileInputStream (new File(".\\src\\main\\resources\\Input Sheets\\Data\\API\\Create_order.json"));
			//FileInputStream fileInputStream = new FileInputStream (new File(fUtil.fgetDataNew1("File_Path")));
			//request.body(fileInputStream);
			
			
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of Response Body for myoffers ",
					"Response body:" + responseBody, 0);
			
            //Response Body Validation
			
			
			String card_token = response.jsonPath().get("card_token");
			System.out.println("card_token is:" + card_token);
			String card_reference = response.jsonPath().get("card_reference");
			System.out.println("card_reference is:" + card_reference);
			String card_fingerprint = response.jsonPath().get("card_fingerprint");
			System.out.println("card_fingerprint is:" +card_fingerprint);

			// status code validation
			int statusCode = response.statusCode();
			System.out.println("Status code is: " + statusCode);
			if (statusCode == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}
			// status line verification
			String statusLine = response.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine, 0);
			}
			
			tokengeneration();
	/*		header1 = "Authorization:" + bearerToken;
			
			
			//	RestAssured.baseURI=apiurl;
				// Request object
			baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
			baseUriToken = fUtil.fgetDataNew1("BaseUriToken");
			h_clientId = fUtil.fgetDataNew1("ClientId");
			h_secretKey = fUtil.fgetDataNew1("SecretKey");
			code_challenge = fUtil.fgetDataNew1("Code_challenge");
			countryCode = "91";
			mobileNumber = fUtil.fgetDataNew1("MobileNumber");
			password = fUtil.fgetDataNew1("Password");
*/
		//	String bearerToken = gmethods.generateAccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey,
	//				code_challenge, countryCode, mobileNumber, password);
			//RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

//			RequestSpecification request = RestAssured.given();
//
//			request.header("Content-Type", "application/json");
//			request.header("Authorization", bearerToken);
			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI2");
				RequestSpecification request2 = RestAssured.given();
				request2.header("Content-Type", "application/json");
				//request2.header("X-programID", "tcp");
				//request2.header("CustomerHash", customerHash_ex);
				request2.header("Authorization", bearerToken);
				request2.header("client_id",fUtil.fgetDataNew1("ClientId"));
			//String URL =	(RestAssured.baseURI,"/"+purchaseOrder);
				//Response response2 = request2.get();
				
				JSONObject json = new JSONObject();
				json.put("customerHash",fUtil.fgetDataNew1("custId"));
				json.put("cardToken", card_token);
				json.put("cardReference", card_reference);
				json.put("cardFingerprint", card_fingerprint);
				request2.body(json.toJSONString());
				Response response2 = request2.post();
				//Response response2=request2.get("/"+purchaseOrder);
				String responseBody2 = response2.getBody().asString();
				System.out.println("response: " + responseBody2);
				
				
				fUtil.flogResult("Passed", "Generation of Response Body for myoffers ",
						"Response body:" + responseBody2, 0);
				
				int statusCode2 = response2.getStatusCode();
				System.out.println("Status code is: " + statusCode2);
				if (statusCode2 == 200) {
					fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode2, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Status Code",
							"Expected Status Code is 200 but it is " + statusCode2, 0);
				}
				// status line verification
				String statusLine2 = response2.getStatusLine();
				System.out.println("Status line is:" + statusLine2);
				if (statusLine2.contains("HTTP/1.1 200")) {
					fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine2, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Status Line",
							"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine2, 0);
				}
				String statusmessage = response2.jsonPath().get("statusInfo.status");
				System.out.println("Status message:" + statusmessage);
			/*	if (statusmessage.contains("ADDED")) {
					fUtil.flogResult("Passed", "Validate the Status message", "Status message is " + statusmessage, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Status message",
							"Expected Status message is added " + statusmessage, 0);
				}
				*/
				checkAPIResponseInDetail(response);
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "Get order Information", "Get order Information" + ee.getMessage(), 0);

		}
	}
		@Test
		public void publishDeleteCard() throws Exception {
			try {
				
				

					String cardNumber = "4111-"+gmethods.randomString(8, "Numeric", "")+"-1111";
					System.out.println("cardNumber"+cardNumber);
							//"TCP_"+gmethods.randomString(6, "Numeric", "");
					

				
				
				String customerHash_ex = readData("customerHash");
				// Specify base URI
				RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

				// Request object
				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/x-www-form-urlencoded");
				//request.header("X-programID", "tcp");
				request.header("client_id", "TCP-WEB-APP");
				//request.header("Authorization",fUtil.fgetDataNew1("SecretKey"));
				request.header("Authorization", "RUZCQkUwQzY3M0M0RTkwODYyNkE0MzYyNzJFNjM4Og==");
			
				request.formParam("merchant_id", "tatadigital");
				request.formParam("customer_id", "406a6bd61792e0436bb06ff799328cd4");
				request.formParam("card_number", cardNumber);

				//FileInputStream fileInputStream = new FileInputStream (new File(".\\src\\main\\resources\\Input Sheets\\Data\\API\\Create_order.json"));
				//FileInputStream fileInputStream = new FileInputStream (new File(fUtil.fgetDataNew1("File_Path")));
				//request.body(fileInputStream);
				
				
				Response response = request.post();

				String responseBody = response.getBody().asString();
				System.out.println("Response Body is:" + responseBody);
				fUtil.flogResult("Passed", "Generation of Response Body for myoffers ",
						"Response body:" + responseBody, 0);
				
	            //Response Body Validation
				
				
				String card_token = response.jsonPath().get("card_token");
				System.out.println("card_token is:" + card_token);
				String card_reference = response.jsonPath().get("card_reference");
				System.out.println("card_reference is:" + card_reference);
				String card_fingerprint = response.jsonPath().get("card_fingerprint");
				System.out.println("card_fingerprint is:" +card_fingerprint);

				// status code validation
				int statusCode = response.statusCode();
				System.out.println("Status code is: " + statusCode);
				if (statusCode == 200) {
					fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Status Code",
							"Expected Status Code is 200 but it is " + statusCode, 0);
				}
				// status line verification
				String statusLine = response.getStatusLine();
				System.out.println("Status line is:" + statusLine);
				if (statusLine.contains("HTTP/1.1 200")) {
					fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Status Line",
							"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine, 0);
				}
				
				

			} catch (Exception ee) {
				System.out.println(ee.getMessage());
				fUtil.flogResult("Failed", "Get order Information", "Get order Information" + ee.getMessage(), 0);

			}
			
	  }	
		@Test
		public void MSDRecommendation() throws Exception {
			try {


				RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

				RequestSpecification request = RestAssured.given();

				request.header("Content-Type", "application/json");
				request.header("Authorization", "c2632ea1-27be-44ac-a6c8-5f6335048003");
				request.header("client_id", "TCP-WEB-APP");
				request.header("program-id", "73eb6345-9cc9-4c37-a8e8-8620d6d32cf5");
				
				// request.header("client_id", fUtil.fgetDataNew1("SecretKey"));

				JSONObject json = new JSONObject();
				json.put("correlation_id", "Abc");
				json.put("client", "CROMA");
				json.put("catalog", "tcp_content");
				json.put("rec_name", "content_recommended_for_you");
				json.put("num_results",2);
				json.put("user_id",2222);
				json.put("org_user_id",1111);
				json.put("mad_uuid", "234jkh2k3j4h");
				
				System.out.println("JSON is generated --" + json.toJSONString());

				fUtil.flogResult("Passed", "Generation of Request Body", "Request Body is :  " + json.toJSONString(), 0);

				request.body(json);
				Response response = request.post();

				String responseBody = response.getBody().asString();
				System.out.println("Response Body is:" + responseBody);
				fUtil.flogResult("Passed", "Generation of response body  ", "Response is :  " + responseBody, 0);



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
			} catch (Exception e) {
				System.out.println(e.getMessage());
				fUtil.flogResult("Failed", "API Response for checkGR", "API Response forcheckGR failed-" + e.getMessage(),
						0);
			}
		}
		@Test
		public void MSDData() throws Exception {
			try {


				RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

				RequestSpecification request = RestAssured.given();

				request.header("Content-Type", "application/json");
				request.header("Authorization", "c2632ea1-27be-44ac-a6c8-5f6335048003");
				request.header("client_id", "TCP-WEB-APP");
				request.header("program-id", "73eb6345-9cc9-4c37-a8e8-8620d6d32cf5");
				
				// request.header("client_id", fUtil.fgetDataNew1("SecretKey"));

				JSONObject json = new JSONObject();
				json.put("correlation_id", "Abc");
				json.put("client", "CROMA");
				json.put("catalog", "tcp_content");
				json.put("org_user_id","1111");
				json.put("user_id","abcd");
				
				HashMap<Object, Object> mapdataparams = new HashMap<Object, Object>();
				mapdataparams.put("catalog_item_id", "1234");
				json.put("data_params",mapdataparams);
				
				System.out.println("JSON is generated --" + json.toJSONString());

				fUtil.flogResult("Passed", "Generation of Request Body", "Request Body is :  " + json.toJSONString(), 0);

				request.body(json.toJSONString());
				Response response = request.post();

				String responseBody = response.getBody().asString();
				System.out.println("Response Body is:" + responseBody);
				fUtil.flogResult("Passed", "Generation of response body  ", "Response is :  " + responseBody, 0);



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
			} catch (Exception e) {
				System.out.println(e.getMessage());
				fUtil.flogResult("Failed", "API Response for checkGR", "API Response forcheckGR failed-" + e.getMessage(),
						0);
			}
		}
		@Test
		public void BillCatalogueServices_DeleteBill() throws Exception  {
			try {
				
				 baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
				 baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
				 h_clientId= fUtil.fgetDataNew1("ClientId");
				 h_secretKey= fUtil.fgetDataNew1("SecretKey");
				 code_challenge= fUtil.fgetDataNew1("Code_challenge");
				 countryCode ="91";
				 mobileNumber= fUtil.fgetDataNew1("MobileNumber");
				 password= fUtil.fgetDataNew1("Password");
				 String expectedmessage=fUtil.fgetDataNew1("ExpectedMessage").trim();
				
				String bearerToken = gmethods.generateAccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey, code_challenge, countryCode, mobileNumber, password);

				
				
				RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json");
				request.header("Authorization", bearerToken);
				request.header("client_id", fUtil.fgetDataNew1("ClientId"));
				request.queryParams("customerHash","7e6001f7ccbcd42ca63f7f0644e70a4d","tcpBlrAccId","BPAN000000000000123545"); 
				
				Response response = request.delete();
				
				System.out.println("----Getting Response Body -----" );
				String responseBody1 = response.getBody().asString();
				System.out.println("Response Body is:" + responseBody1);
				fUtil.flogResult("Passed", "Generation of response body for Get Address Info ",
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
				if(!StringUtils.isAllEmpty(expectedmessage)) {
				String expectedparam=response.jsonPath().get("billerAccount.status").toString().replaceAll("[\\[\\]]", " ");
               if(expectedparam.trim().equalsIgnoreCase(expectedmessage)) {
	         fUtil.flogResult("Passed", "Delete bill verify", "Bill deleted successfully",0);
               }
				}
			} catch (Exception ee) {
				System.out.println(ee.getMessage());
				fUtil.flogResult("Failed", "API Response for Get Address Info",
						"API Response for Get Address Info failed-" + ee.getMessage(), 0);

			}
		}
		@Test
		public void BillCartServices_KogitoDeleteEvent() throws Exception  {
			try {
				
				 baseUriAuth = fUtil.fgetDataNew1("BaseUriAuth");
				 baseUriToken= fUtil.fgetDataNew1("BaseUriToken");
				 h_clientId= fUtil.fgetDataNew1("ClientId");
				 h_secretKey= fUtil.fgetDataNew1("SecretKey");
				 code_challenge= fUtil.fgetDataNew1("Code_challenge");
				 countryCode ="91";
				 mobileNumber= fUtil.fgetDataNew1("MobileNumber");
				 password= fUtil.fgetDataNew1("Password");
				 String expectedmessage=fUtil.fgetDataNew1("ExpectedMessage").trim();
				
				String bearerToken = gmethods.generateAccessToken(baseUriAuth, baseUriToken, h_clientId, h_secretKey, code_challenge, countryCode, mobileNumber, password);

				
				
				RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json");
				request.header("Authorization", bearerToken);
				request.header("client_id", fUtil.fgetDataNew1("ClientId"));
				request.queryParams("customerHash","1ec67f92e81836dae4874cbdd541001b","tcpBillId","BPBI000000000000135139"); 
				
				Response response = request.delete();
				
				System.out.println("----Getting Response Body -----" );
				String responseBody1 = response.getBody().asString();
				System.out.println("Response Body is:" + responseBody1);
				fUtil.flogResult("Passed", "Generation of response body for Get Address Info ",
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
				if(!StringUtils.isAllEmpty(expectedmessage)) {
				String expectedparam=response.jsonPath().get("tcpBillId").toString().replaceAll("[\\[\\]]", " ");
               if(expectedparam.trim().equalsIgnoreCase(expectedmessage)) {
	         fUtil.flogResult("Passed", "Kogito delete event verify", "Kogito event deleted successfully",0);
               }
				}
			} catch (Exception ee) {
				System.out.println(ee.getMessage());
				fUtil.flogResult("Failed", "API Response for Get Address Info",
						"API Response for Get Address Info failed-" + ee.getMessage(), 0);

			}
		}

		@Test
		public void getOTP() throws Exception {
			try {
				
				RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

				RequestSpecification request = RestAssured.given();
				// 9
				request.header("Content-Type", "application/json");
				request.header("client_id", fUtil.fgetDataNew1("ClientId"));
				request.header("Authorization", fUtil.fgetDataNew1("SecretKey"));

				String MobNum=fUtil.fgetDataNew1("mobileNumber").replace("`", "");
				JSONObject json_rfID = new JSONObject();

				json_rfID.put("countryCode", "91");
				json_rfID.put("phone", MobNum);
				json_rfID.put("sendOtp", "true");


				request.body(json_rfID.toJSONString());
				Response response_Otp = request.post();

				System.out.println("----Getting Response Body -----");
				String responseBody1 = response_Otp.getBody().asString();
				System.out.println("Response Body for Check Phone is:" + responseBody1);
				fUtil.flogResult("Passed", "Generation of response body Check Phone ", "Response is :  " + responseBody1,
						0);

				String otp = response_Otp.jsonPath().get("OTP");
				System.out.println("OTP is: " + otp);

				
				String statusLine = response_Otp.getStatusLine();
				System.out.println("Status line is:" + statusLine);
				if (statusLine.contains("HTTP/1.1 200 OK")) {
					fUtil.flogResult("Passed", "Validate the Status Line Authcode Generation",
							"Status Line is " + statusLine, 0);
				} else {
					fUtil.flogResult("Failed", "Validate the Status Line Authcode Generation",
							"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
				}

			} catch (Exception ee) {
				System.out.println(ee.getMessage());
				fUtil.flogResult("Failed", "API Response for Get OTP",
						"API Response for Get OTP failed-" + ee.getMessage(), 0);

			}
		}
}
