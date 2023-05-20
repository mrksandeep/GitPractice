package com.QA.TestApp.Testcases.WEB;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.QA.TestApp.Pages.WEB.TDL_CromaCardPage;
import com.QA.TestApp.Utilities.BaseScript;
import com.QA.TestApp.Utilities.BrowserFactory;

import io.appium.java_client.MobileElement;

public class LOYALTY_Web extends BaseScript {
	public static String TransactionID="";
	public static String TotalpaidAmount="";
	//public static double TotalpaidAmountCroma=0.0;
	public static double expectedEarnPromotionalPoints=0.0;
	public static double totalCartAmount=0.0;
	public static double totalTransactionAmtCliq=0.0;
	public static String payment_method="";
	public static String payment_subtotal="";
	public static double earn_points=0.0;
	public static double expectedEarnPromisedPoints=0.0;
	public static double pointsUsed=0.0;
	public static String tcpPoints="";
	public static String parentWindow="";
	public static double totalpayableCliq=0.0;
	public static double cliqCashUsed=0.0;
	public static String points_unlock="";
	public static String transaction_date="";
	public static double pointsredeemed=0.0;
	public static String pointexpirydate="";
	static ArrayList<String> productNameList=new ArrayList<String>();
	static ArrayList<Double> productPriceList=new ArrayList<Double>();
	public static double totalpayableCliqMultipleItem=0.0;
	public static double shippingCharge=0.0;
	public static double ineligibleamount=0.0;
	public static double eligibleamount=0.0;
	public static double totalpayableCroma=0.0;
	public static double totalpayableWestSide=0.0;
	
	@Test
	public void naviagteToTCPNewCustomer() throws Exception {
		try {
			logger.info("Entering to method naviagteToTCPNewCustomer");
			//String mobileNumber = fUtil.fgetDataNew1("Mobile_no");
			String mobileNumber = "9989"+gmethods.randomString(6, "Numeric", "");
			System.out.println(mobileNumber);
			Random rand = new Random();
			int upperbound = 8;
			int number3 = rand.nextInt(upperbound); 
			int number4 = rand.nextInt(upperbound);
			int number5 = rand.nextInt(upperbound);
			//			int number6 = rand.nextInt(upperbound);
			//			int number7 = rand.nextInt(upperbound);
			//			int number8 = rand.nextInt(upperbound);
			//			int number9 = rand.nextInt(upperbound);
			//			int number10 = rand.nextInt(upperbound);
			//			String mobileNumber = "9"+"8"+Integer.toString(number3)+Integer.toString(number4)+Integer.toString(number5)+Integer.toString(number6)+Integer.toString(number7)+Integer.toString(number8)+Integer.toString(number9)+Integer.toString(number10);
			String otp = "123456";
			String newPassword=fUtil.fgetDataNew1("Password");
			String firstName=fUtil.fgetDataNew1("F_Name");
			String lastName=fUtil.fgetDataNew1("L_Name");
			String dob=fUtil.fgetDataNew1("DOB");
			String gender=fUtil.fgetDataNew1("Gender");
			//			String email=fUtil.fgetDataNew1("Email");
			String email="test"+Integer.toString(number3)+Integer.toString(number4)+Integer.toString(number5)+"@gmail.com";
			String salutation="Mr";

			if(mobileNumber.startsWith("~"))
				mobileNumber=mobileNumber.substring(1);

			if(dob.startsWith("~"))
				dob=dob.substring(1);

			gmethods.enrollUserPwa(mobileNumber, otp, newPassword, salutation,firstName, lastName, dob, gender, email);

			gmethods.gotovaultPWA();
			gmethods.goto_TCPCard();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validateTCPCardForNewUser() {
		try {
			logger.info("Inside validateTCPCardForNewUser method");
			gmethods.validate_TCPCard();
			boolean actvityTabVisibility = gmethods.isElementVisible(TdlTcpCard.get().activityTab_TCP, 20);
			if (actvityTabVisibility == true) {
				logger.info("Activity tab is present");
				fUtil.flogResult("Passed", "Verify if Activity tab is present", "Activity tab is present", 1);
			} else {
				logger.error("Activity tab is not present");
				fUtil.flogResult("Failed", "Verify if Activity tab is present", "Activity tab is not present", 1);
			}
			try {
				List<WebElement> myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 10)
						.until(ExpectedConditions.visibilityOfAllElements(TdlTcpCard.get().pointsActivity_TCP)));
				boolean pointsEarnedVisibility = gmethods.isElementVisible(myDynamicElement.get(0), 20);
				if (pointsEarnedVisibility == true) {
					logger.error("Points activity showing for a new user!");
					fUtil.flogResult("Failed", "Points activity validation", "Points activity showing for a new user!",
							1);
				}
			} catch (ElementNotVisibleException e) {
				String message = e.getMessage();
				logger.info("No points activity is there for new user : " + message);
				fUtil.flogResult("Passed", "Points activity validation",
						"No points activity is there for new user : " + message, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void naviagteToTCPActiveCustomer() throws Exception {
		try {
			logger.info("Entering to method naviagteToTCPActiveCustomer");
			String mobile_No=fUtil.fgetDataNew1("Mobile_no");
			String password=fUtil.fgetDataNew1("Password");
			gmethods.signInPwa(mobile_No,password);

			gmethods.gotovaultPWA();

			gmethods.goto_TCPCard();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validateEarnPointsTCP() throws Exception {
		try {
			boolean totalPoints = gmethods.isElementVisible(TdlTcpCard.get().totalPoints_TCP, 30);
			if (totalPoints == true) {
				gmethods.highlightElement(TdlTcpCard.get().totalPoints_TCP);
				logger.info(
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText());
				fUtil.flogResult("Passed", "Visibility of total points",
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText(),
						1);
			} else {
				logger.error("Total points are not visible in TCP card");
				fUtil.flogResult("Failed", "Visibility of total points", "Total points are not visible in TCP card", 1);
			}
			gmethods.validate_TCPCard_earnpoints();
			gmethods.navigatebackto_Vault(TdlTcpCard.get().closeBtn_TCP);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void validateBurnPointsTCP() throws Exception {
		try {
			boolean totalPoints = gmethods.isElementVisible(TdlTcpCard.get().totalPoints_TCP, 30);
			if (totalPoints == true) {
				gmethods.highlightElement(TdlTcpCard.get().totalPoints_TCP);
				logger.info(
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText());
				fUtil.flogResult("Passed", "Visibility of total points",
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText(),
						1);
			} else {
				logger.error("Total points are not visible in TCP card");
				fUtil.flogResult("Failed", "Visibility of total points", "Total points are not visible in TCP card", 1);
			}
			gmethods.validate_TCPCard_burnpoints();
			gmethods.navigatebackto_Vault(TdlTcpCard.get().closeBtn_TCP);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void validateEarnAndBurnPointsTCP() throws Exception {
		try {
			boolean totalPoints = gmethods.isElementVisible(TdlTcpCard.get().totalPoints_TCP, 10);
			if (totalPoints == true) {
				gmethods.highlightElement(TdlTcpCard.get().totalPoints_TCP);
				logger.info(
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText());
				fUtil.flogResult("Passed", "Visibility of total points",
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText(),
						1);
			} else {
				logger.error("Total points are not visible in TCP card");
				fUtil.flogResult("Failed", "Visibility of total points", "Total points are not visible in TCP card", 1);
			}
			gmethods.validate_TCPCard_earnpoints();
			gmethods.validate_TCPCard_burnpoints();
			gmethods.navigatebackto_Vault(TdlTcpCard.get().closeBtn_TCP);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void navigateBackToVaultFromTCP() throws Exception {
		try {
			gmethods.navigatebackto_Vault(TdlTcpCard.get().closeBtn_TCP);
			if (gmethods.isElementVisible(TdlVaultPage.get().cardName_TCP, 10)) {
				gmethods.highlightElement(TdlVaultPage.get().cardName_TCP);
				System.out.println("Navigated back to vault successfully");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void naviagteToCroma() throws Exception {
		String mobile_No=fUtil.fgetDataNew1("Mobile_no");
		String password=fUtil.fgetDataNew1("Password");
		gmethods.signInPwa(mobile_No,password);
		gmethods.gotovaultPWA();
		if(gmethods.isElementVisible(TdlVaultPage.get().cardName_Croma, 30)) {
			gmethods.goto_CromaCard();
		}else {
			System.out.println("View Details not clicked");
		}
		gmethods.validate_CromaCard();
	}

	@Test
	public void navigateBackToVaultFromCroma() throws Exception {
		gmethods.validate_CromaCard();
		gmethods.navigatebackto_Vault(TdlCromaCard.get().closeBtn_Croma);
		if(gmethods.isElementVisible(TdlVaultPage.get().cardName_Croma, 10)) {
			System.out.println("Navigated back to vault successfully");
		}
	}
	@Test
	public void userSignUp() throws Exception
	{
		try {
			String mobileNumber = fUtil.fgetDataNew1("Mobile_no");
			Random rand = new Random();
			int upperbound = 8;
			int number3 = rand.nextInt(upperbound); 
			int number4 = rand.nextInt(upperbound);
			int number5 = rand.nextInt(upperbound);
			//			int number6 = rand.nextInt(upperbound);
			//			int number7 = rand.nextInt(upperbound);
			//			int number8 = rand.nextInt(upperbound);
			//			int number9 = rand.nextInt(upperbound);
			//			int number10 = rand.nextInt(upperbound);
			//			String mobileNumber = "9"+"8"+Integer.toString(number3)+Integer.toString(number4)+Integer.toString(number5)+Integer.toString(number6)+Integer.toString(number7)+Integer.toString(number8)+Integer.toString(number9)+Integer.toString(number10);
			String otp = "123456";
			String newPassword=fUtil.fgetDataNew1("Password");
			String firstName=fUtil.fgetDataNew1("F_Name");
			String lastName=fUtil.fgetDataNew1("L_Name");
			String dob=fUtil.fgetDataNew1("DOB");
			String gender=fUtil.fgetDataNew1("Gender");
			//			String email=fUtil.fgetDataNew1("Email");
			String email="test"+Integer.toString(number3)+Integer.toString(number4)+Integer.toString(number5)+"@gmail.com";
			String salutation = "Mr";

			if (mobileNumber.startsWith("~"))
				mobileNumber = mobileNumber.substring(1);

			if(dob.startsWith("~"))
				dob=dob.substring(1);

			gmethods.enrollUserPwa(mobileNumber, otp, newPassword,salutation, firstName, lastName, dob,gender, email);
			gmethods.gotovaultPWA();
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			fUtil.flogResult("Failed", "userSignUp Code is throwing exception", e.getMessage(), 0);
		}
	}
	@Test
	public void validateTCPPoints() throws Exception{

		try {

			//gmethods.gotovaultPWA();
			if(gmethods.isElementVisible(TdlVaultPage.get().cardName_TCP, 30)) {
				gmethods.goto_TCPCard();
			}else {
				System.out.println("View Details not clicked");
			}

			System.out.println("Fetching TCP Points");
			String tcppoints = TdlTcpCard.get().pointStatus_TCP.getText();
			System.out.println("Available points" + tcppoints); 

			for (WebElement elm : TdlTcpCard.get().pointsActivity_TCP) 
			{
				if (elm.getText().contains("+"))
				{
					System.out.println("\nPoints are visible " + elm.getText());

				}
				else
				{
					System.out.println("\nPoints are not visible");
					System.out.println("Sign Up User doesn't have points");
				}

			}	 	
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			fUtil.flogResult("Failed", "validateTCPPoints Code is throwing exception", e.getMessage(), 0);
		}

	}

	@Test
	public void naviagteToCromaActiveCustomer() throws Exception {
		try {
			logger.info("Entering to method naviagteToCromaActiveCustomer");
			String mobile_No=fUtil.fgetDataNew1("Mobile_no");
			String password=fUtil.fgetDataNew1("Password");
			gmethods.signInPwa(mobile_No,password);
			boolean vis = gmethods.isElementVisible(TdlHomePage.get().vaultLink, 20);
			if(vis==true) {
				gmethods.gotovaultPWA();
			}
			if(gmethods.isElementVisible(TdlVaultPage.get().cardName_Croma, 30)) {
				gmethods.goto_CromaCard();
			}else {
				System.out.println("View Details not clicked");
			}
			gmethods.validate_MultiTransaction_CromaCard();
			gmethods.navigatebackto_Vault(TdlCromaCard.get().closeBtn_Croma);
			gmethods.goto_TCPCard();
			gmethods.validate_TCPCard();
			List<WebElement> myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 100)).until(ExpectedConditions.visibilityOfAllElements(TdlTcpCard.get().pointsActivity_TCP));
			WebElement element = myDynamicElement.get(0);
			boolean transactionVisibility = gmethods.isElementVisible(element, 20);
			if (transactionVisibility == true) {
				String noOfTransactions = fUtil.fgetDataNew1("Trans_no");
				if(noOfTransactions.startsWith("~"))
					noOfTransactions=noOfTransactions.substring(1);	
				int itr = Integer.parseInt(noOfTransactions);
				for (int i = 0; i < itr; i++) {
					String transDesc = TdlTcpCard.get().transcDesc_TCP.get(i).getText();
					gmethods.highlightElement(TdlTcpCard.get().transcDesc_TCP.get(i));
					String transDate = TdlTcpCard.get().transcDate_TCP.get(i).getText();
					gmethods.highlightElement(TdlTcpCard.get().transcDate_TCP.get(i));
					String transAmt = TdlTcpCard.get().pointsActivity_TCP.get(i).getText();
					gmethods.highlightElement(TdlTcpCard.get().pointsActivity_TCP.get(i));
					System.out.println("Transaction line item "+i+" is: " + transDesc + " done on " + transDate
							+ " : " + transAmt);
					logger.info(
							"Transaction " + i + " : " + transDesc + " done on " + transDate + " : " + transAmt);
					fUtil.flogResult("Passed", "Trnsaction details",
							"Transaction " + i + " : " + transDesc + " done on " + transDate + " : " + transAmt, 1);
				}
			} else {
				logger.error("Transaction is not visible");
				fUtil.flogResult("Failed", "Trnsaction details", "Transaction is not visible", 1);
			}
			gmethods.navigatebackto_Vault(TdlTcpCard.get().closeBtn_TCP);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void naviagteToCroma_offline() throws Exception {
		try
		{
			logger.info("Entering to method naviagteToCroma");
			System.out.println("Entering to method naviagteToCroma");
			gmethods.goto_CromaCard();

			gmethods.validate_CromaCard();
			gmethods.navigatebackto_Vault(TdlCromaCard.get().closeBtn_Croma);
			if(gmethods.isElementVisible(TdlVaultPage.get().cardName_Croma, 10)) {
				System.out.println("Navigated back to vault successfully");
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validateEarnPointsTCP_offline() throws Exception {
		try {
			if(gmethods.isElementVisible(TdlVaultPage.get().cardName_TCP, 30)) {
				gmethods.goto_TCPCard();
			}else {
				System.out.println("View Details not clicked");
			}
			boolean totalPoints = gmethods.isElementVisible(TdlTcpCard.get().totalPoints_TCP, 10);
			if (totalPoints == true) {
				gmethods.highlightElement(TdlTcpCard.get().totalPoints_TCP);
				System.out.println("tcp earn points"+ TdlTcpCard.get().totalPoints_TCP.getText());
				//Assert.assertEquals(TdlTcpCard.get().totalPoints_TCP.getText(),"34", "passed");
				logger.info(
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText());
				fUtil.flogResult("Passed", "Visibility of total points",
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText(),
						1);
				String totalPoints_test = TdlTcpCard.get().totalPoints_TCP.getText();
				if(totalPoints_test.equalsIgnoreCase("34")){
					logger.info("Total points is 34 for a new customer");
					fUtil.flogResult("Passed", "Verify the total points", "Total points is 34 for a new customer did one transaction offline", 1);
				}else {
					logger.error("Total points is not 34 for a new customer did one transaction offline");
					fUtil.flogResult("Failed", "Verify the total points", "Total points is not 34 for a new customer did one transaction offline", 1);
				}
			} else {
				logger.error("Total points are not visible in TCP card");
				fUtil.flogResult("Failed", "Visibility of total points", "Total points are not visible in TCP card", 1);
			}
			gmethods.validate_TCPCard_earnpoints();
			gmethods.navigatebackto_Vault(TdlTcpCard.get().closeBtn_TCP);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void validateEarnPointsTCP_offline_purchase() throws Exception {
		try {
			if(gmethods.isElementVisible(TdlVaultPage.get().cardName_TCP, 30)) {
				gmethods.goto_TCPCard();
			}else {
				System.out.println("View Details not clicked");
			}
			boolean totalPoints = gmethods.isElementVisible(TdlTcpCard.get().totalPoints_TCP, 10);
			if (totalPoints == true) {
				gmethods.highlightElement(TdlTcpCard.get().totalPoints_TCP);
				System.out.println("tcp earn points"+ TdlTcpCard.get().totalPoints_TCP.getText());
				//Assert.assertEquals(TdlTcpCard.get().totalPoints_TCP.getText(),"68", "passed");
				logger.info(
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText());
				fUtil.flogResult("Passed", "Visibility of total points",
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText(),
						1);
				String totalPoints_test = TdlTcpCard.get().totalPoints_TCP.getText();
				if(totalPoints_test.equalsIgnoreCase("68")){
					logger.info("Total points is 68 for a new customer did few transaction offline");
					fUtil.flogResult("Passed", "Verify the total points", "Total points is 68 for a new customer did few transaction offline", 1);
				}else {
					logger.error("Total points is not 68 for a new customer");
					fUtil.flogResult("Failed", "Verify the total points", "Total points is not 68 for a new customer did few transaction offline", 1);
				}
			
			} else {
				logger.error("Total points are not visible in TCP card");
				fUtil.flogResult("Failed", "Visibility of total points", "Total points are not visible in TCP card", 1);
			}
			gmethods.validate_TCPCard_earnpoints();
			gmethods.navigatebackto_Vault(TdlTcpCard.get().closeBtn_TCP);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ========================================================================================================
	 * SIT-CYCLE 1 Rewards And Benefits
	 * ==========================================================================================================
	 * 
	 */

	/**
	 * Function Name: validate_CromaCard Function will validate if inside Croma Card
	 * page for pwa Input required: none
	 */
	public void validate_CromaCard() {

		try {

			boolean insideCromaCardPage = gmethods.isElementVisible(TdlCromaCard.get().cardNameText_Croma, 20);
			gmethods.highlightElement(TdlCromaCard.get().cardNameText_Croma);
			if (insideCromaCardPage == true) {
				logger.info("Inside Croma Card Page");
				fUtil.flogResult("Passed", "Verify if navigated to Croma Card page", "Inside Croma Card Page", 1);
			} else {
				logger.error("Navigation to Croma Card page failed");
				fUtil.flogResult("Failed", "Verify if navigated to Croma Card page",
						"Navigation to Croma Card page failed", 1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}


	@Test
	public void enrolmentJourney_intimation_SSO () throws Exception {
		try {
			logger.info("Validating TCP APP Welcome Page");

			String userRegion = fUtil.fgetDataNew1("UserRegion").toUpperCase();
			String phoneNumber =fUtil.fgetDataNew1("MobileNumber");

			if(phoneNumber.startsWith("~"))
				phoneNumber = phoneNumber.substring(1);

			boolean loginPageHeader = gmethods.isElementVisible(TdlCromaCard.get().loginPageHdrTxtWeb, 20);
			boolean countryCode = gmethods.isElementVisible(Tdl_SSO.get().countryCode, 5);
			boolean mobileNumberField = gmethods.isElementVisible(Tdl_SSO.get().phoneNoField, 5);
			boolean termsOfServiceBtn = gmethods.isElementVisible(Tdl_SSO.get().termsOfServiceBtn, 5);
			boolean privacyPolicyBtn = gmethods.isElementVisible(Tdl_SSO.get().privacyPolicyBtn, 5);


			if(loginPageHeader==true && countryCode==true && mobileNumberField==true && termsOfServiceBtn==true && privacyPolicyBtn==true) {
				logger.info("TCP WEB Mobile Number Entry Page has been displayed successfully");
				fUtil.flogResult("Passed", "TCP WEB Mobile Number Entry Page", "Displayed successfully", 1);

				if(userRegion.contentEquals("INDIAN")) {
					logger.info("User is intended to Start a Non GDPR/CCPA region journey");

					boolean gdprText = gmethods.isElementVisible(Tdl_SSO.get().gdprCCPATxt, 5);
					boolean clickHereBtn = gmethods.isElementVisible(Tdl_SSO.get().clickHereBtn, 5);
					boolean tandCCheckBox = gmethods.isElementVisible(Tdl_SSO.get().privacyPolicyCheckBox, 5);

					if(gdprText==true && clickHereBtn==true && tandCCheckBox==false) {
						logger.info("User is present on Non GDPR/CCPA journey page");
						fUtil.flogResult("Passed", "Non GDPR/CCPA journey", "User is present on Non GDPR/CCPA journey page", 1);

					} else {
						logger.info("User is not present on Non GDPR/CCPA journey page");
						fUtil.flogResult("Failed", "Non GDPR/CCPA journey", "User is not present on Non GDPR/CCPA journey page", 1);
					}	

				} else if(!userRegion.contentEquals("INDIAN")) {
					logger.info("User is intended to Start a GDPR/CCPA region journey, hence clicking on Click here button");
					Tdl_SSO.get().clickHereBtn.click();

					boolean clickHereBtn = gmethods.isElementVisible(Tdl_SSO.get().clickHereBtn, 5);
					boolean gdprText = gmethods.isElementVisible(Tdl_SSO.get().gdprCCPATxt, 5);
					boolean tandCCheckBox = gmethods.isElementVisible(Tdl_SSO.get().privacyPolicyCheckBox, 5);

					if(gdprText==false && clickHereBtn==false && tandCCheckBox==true) {	
						fUtil.flogResult("Passed", "GDPR/CCPA journey intimation Page", "User redirected to GDPR/CCPA journey page where CheckBox is available", 1);
						Tdl_SSO.get().privacyPolicyCheckBox.click();

					} else {
						fUtil.flogResult("Failed", "GDPR/CCPA journey intimation Page", "User not redirected to GDPR/CCPA journey page where CheckBox is available", 1);	
					}
				}

				logger.info("Validate default country code");
				String displayedCountryCode = Tdl_SSO.get().countryCode.getText().trim();

				if(displayedCountryCode.contentEquals("+91")) {
					fUtil.flogResult("Passed", "Default Country Code validation", "Default country code is of India : "+displayedCountryCode, 1);
				} else {
					fUtil.flogResult("Failed", "Default Country Code validation", "Default country code is not of India : "+displayedCountryCode, 1);	
				}

				logger.info("Enter Mobile Number and Proceed");
				Tdl_SSO.get().phoneNoField.sendKeys(phoneNumber);

				logger.info("Click on Confirm button");
				if(gmethods.isElementEnabled(Tdl_SSO.get().confirmBtn)) {
					fUtil.flogResult("Passed", "Confirm button and Proceed to OTP Page", "Confirm button is Enabled", 1);
					Tdl_SSO.get().confirmBtn.click();	
				} else {
					fUtil.flogResult("Failed", "Confirm button and Proceed to OTP Page", "Confirm button is not enabled", 1);
				}

			} else {
				logger.info("TCP WEB Mobile Number Entry Page has not been displayed properly");
				fUtil.flogResult("Failed", "TCP WEB Mobile Number Entry Page", "Not displayed successfully", 1);
			}		
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}


	/*
	 * This method will validate OTP page details and 
	 * proceed according to the requirement whether Default OTP Journey or
	 * Password Journey
	 * 
	 */
	@Test
	public void otpPage_JourneyType_SSO () throws Exception {
		try {

			String otp = "123456";
			String journeyType = fUtil.fgetDataNew1("JourneyType");
			String password = fUtil.fgetDataNew1("Password");

			boolean otpPageHdr = gmethods.isElementVisible(Tdl_SSO.get().otpPageHdr, 15);
			//boolean otpField = gmethods.isElementVisible(Tdl_SSO.get().otpField, 10);
			boolean resendCode = gmethods.isElementVisible(Tdl_SSO.get().resendCodeBtn, 5);

			if(otpPageHdr==true && resendCode==true) {
				logger.info("OTP Page has been navigated successfully");
				fUtil.flogResult("Passed", "OTP Page Navigation", "OTP Page navigated and displayed successfully", 1);

				if(journeyType.equalsIgnoreCase("otp")) {

					logger.info("User opted for Default OTP Journey");
					fUtil.flogResult("Passed", "Journey Type", "User Opted for Default OTP Journey", 0);

					Actions action = new Actions(browserFactory.get().getDriver());
					action.moveToElement(browserFactory.get().getDriver().findElement(By.xpath("//input[@name='otp' and @type='number']")));

					Thread.sleep(2000);

					Tdl_SSO.get().otpField.sendKeys(otp);
					fUtil.flogResult("Passed", "OTP entry", "User Entered OTP which will navigate user directly further", 1);

				} else if(journeyType.equalsIgnoreCase("password")) {

					logger.info("User opted for Password Journey");
					Tdl_SSO.get().loginWithPwdLink.click();

					boolean pwdPageHdr = gmethods.isElementVisible(Tdl_SSO.get().passwordPageHdr, 10);
					boolean pwdField = gmethods.isElementVisible(Tdl_SSO.get().passwordField, 10);
					boolean phoneNo = gmethods.isElementVisible(Tdl_SSO.get().phoneNoField, 10);

					if(pwdPageHdr==true && pwdField==true && phoneNo==true) {
						logger.info("Password Page navigated successfully");
						fUtil.flogResult("Passed", "Password Page Navigation", "Navigated successfully", 1);

						Tdl_SSO.get().passwordField.sendKeys(password);
						Thread.sleep(2000);
						Tdl_SSO.get().showPwdBtn.click();

						if(gmethods.isElementVisible(Tdl_SSO.get().submitBtn, 10)) {
							fUtil.flogResult("Passed", "Submit button", "Submit button is available to proceed further", 1);
							Tdl_SSO.get().submitBtn.click();

						} else {
							fUtil.flogResult("Failed", "Submit button", "Submit button is not available to proceed further", 1);
						}

					} else {
						logger.info("Password Page not navigated successfully");
						fUtil.flogResult("Failed", "Password Page Navigation", "Not navigated successfully", 1);
					}							
				}		
			} else {
				logger.info("OTP Page has not been navigated successfully");
				fUtil.flogResult("Failed", "OTP Page Navigation", "OTP Page not navigated properly", 1);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/*
	 * This method will validate User Details Page
	 * and Enter user's details as per the requirement
	 * 
	 */
	@Test
	public void userDetailsPage_SSO () throws Exception {
		try {

			String userType = fUtil.fgetDataNew1("UserType").toUpperCase();
			String userDetails = fUtil.fgetDataNew1("UserDetails").toUpperCase();
			String firstName = fUtil.fgetDataNew1("FirstName");
			String lastName = fUtil.fgetDataNew1("LastName");		

			if(userType.contentEquals("NEW") | userType.contentEquals("MIGRATED")) {
				logger.info("User Details page should be available to the user");

				boolean userDtlsPageTxt = gmethods.isElementVisible(Tdl_SSO.get().uderDtlsPageSubTitleTxt, 20);

				if(userDtlsPageTxt==true) {
					logger.info("User Details page has been navigated and present to the user");

					if(userDetails.contentEquals("NOT REQUIRED")) {

						logger.info("User is not intended to add any details. Hence clicking on Skip button");
						if(gmethods.isElementVisible(Tdl_SSO.get().skipBtn, 5)) {

							fUtil.flogResult("Passed", "Skip User Details", "Skip button available, clicking on which user will navigate to HomePage", 1);
							Tdl_SSO.get().skipBtn.click();

						} else {
							fUtil.flogResult("Failed", "Skip User Details", "Skip button not available to proceed further", 1);
						}

					} else {
						logger.info("User is intended to add user Details");

						boolean firstNameField = gmethods.isElementVisible(Tdl_SSO.get().firstNameField, 10);
						boolean lastNameField = gmethods.isElementVisible(Tdl_SSO.get().lastNameField, 10);
						boolean submitBtn = gmethods.isElementVisible(Tdl_SSO.get().submitBtn, 10);

						if(firstNameField==true && lastNameField==true) {
							logger.info("Entering user details");
							Tdl_SSO.get().firstNameField.sendKeys(firstName);
							Tdl_SSO.get().lastNameField.sendKeys(lastName);

							if(gmethods.isElementClickable(Tdl_SSO.get().submitBtn, 10)) {
								fUtil.flogResult("Passed", "Submitting User Details", "Submit button is clickable hence user is Submitting the details", 1);
								Tdl_SSO.get().submitBtn.click();

							} else {
								fUtil.flogResult("Failed", "Submitting User Details", "Submit button is not clickable to proceed further", 1);
							}	
						} else {
							fUtil.flogResult("Failed", "Enter user Details", "First Name & Last Name Entry fields are not available", 1);
						}	
					}	
				} else {
					fUtil.flogResult("Failed", "User Details Page for New/Migrated Users", "User Details page is not available to the user", 1);
				}

			} else if(userType.contentEquals("EXISTING")) {
				logger.info("User is an existing user hence User Details Page wont be avialble");
				boolean userDtlsPageTxt1 = gmethods.isElementVisible(Tdl_SSO.get().uderDtlsPageSubTitleTxt, 10); 

				if(userDtlsPageTxt1==true) {
					fUtil.flogResult("Failed", "User Details Page for Exisitng User", "User details page available for existing user which is not expected ", 1);
				} else {
					fUtil.flogResult("Passed", "User Details Page for Exisitng User", "User details page not available for existing user which is expected ", 1);
				}		
			}	

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * New login Method with OTP for SSO SIT Cycle 1
	 * 
	 */
	@Test
	public void logInByOTP_SSO() throws Exception {
		try {

			String mobileNumber = fUtil.fgetDataNew1("MobileNumber");
			String otp = "123456";

			if (mobileNumber.startsWith("~"))
				mobileNumber = mobileNumber.substring(1);

			if (gmethods.isElementVisible(tcpHomePageMyAccount.get().mobileNoTextBox, 20)) {
				tcpHomePageMyAccount.get().mobileNoTextBox.sendKeys(mobileNumber);

				if (gmethods.isElementVisible(tcpHomePageMyAccount.get().confirmBtn, 10)) {
					tcpHomePageMyAccount.get().confirmBtn.click();

					if (gmethods.isElementVisible(Tdl_SSO.get().otpPageHdr, 10)) {
						Actions action = new Actions(browserFactory.get().getDriver());
						action.moveToElement(browserFactory.get().getDriver()
								.findElement(By.xpath("//input[@name='otp' and @type='number']")));

						Thread.sleep(2000);
						Tdl_SSO.get().otpField.sendKeys(otp);

						if (gmethods.isElementVisible(Tdl_SSO.get().skipBtn, 10)) {
							logger.info("User Details page is present, hence skipping it");
							Tdl_SSO.get().skipBtn.click();
						}

						if (gmethods.isElementVisible(Tdl_SSO.get().closeBtn, 10)) {
							logger.info("Happy Anniversary pop up displayed. Skipping it");
							Tdl_SSO.get().closeBtn.click();
						}

						if (gmethods.isElementVisible(tcpHomePageMyAccount.get().hamburgerMenuBtn, 20)) {
							fUtil.flogResult("Passed", "HomePage Navigation",
									"hamburgerMenuBtn present in Home Page, hence homePage navigated successfully", 1);
							System.out.println("User Logged in successfully");
						} else {
							fUtil.flogResult("Failed", "hamburgerMenuBtn in Home Page",
									"hamburgerMenuBtn present in Home Page", 1);
						}
					} else {
						fUtil.flogResult("Failed", "Enter OTP", "OTP box not visible", 1);
					}
				} else {
					fUtil.flogResult("Failed", "Confirm Button in Mobile No. Page", "Confirm Button Not visible.", 1);
				}
			} else {
				fUtil.flogResult("Failed", "Mobile No. Text Box Visibility", "Mobile No. Text Box is not visible.", 1);
			}

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
		}
	}

	@Test
	public void rewardsAndBenfitsPageNavigation() throws Exception {

		try {
			if(gmethods.isElementVisible(TdlCromaCard.get().offerCloseaftersignIn, 20)) {
				TdlCromaCard.get().offerCloseaftersignIn.click();
				System.out.println("Offers shown after signIn closed");
			}
			Thread.sleep(2000);
			boolean Ulogo = gmethods.isElementVisible(TdlCromaCard.get().uLogo, 20);
			if (Ulogo == true) {
				logger.info("ULogo is visible");

				if(gmethods.isElementVisible(TdlCromaCard.get().uRewardsHomePage, 20)) {
					fUtil.flogResult("Passed", "Visibility of ULogo", "ULogo and points is visible", 1);
					TdlCromaCard.get().uRewardsHomePage.click();
					//User will land on R & B Page
					//Thread.sleep(10000);
					if(gmethods.isElementVisible(TdlCromaCard.get().pointsRBPage, 20)) {
						String userPoints=TdlCromaCard.get().pointsRBPage.getText();
						if(!userPoints.contains("NaN")) {
							fUtil.flogResult("Passed", "R&B page Mass Segment Check", "User is of Mass Segment"+userPoints, 1);

							Thread.sleep(5000);
						}else {
							fUtil.flogResult("Failed", "R&B page Mass Segment Check", "Mass Segment is not visible for the member", 1);
						}	
					}
				}

			}else {
				fUtil.flogResult("Failed", "Visibility of ULogo", "ULogo is not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : rewardsAndBenfitsPageNavigation ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	@Test
	public void rewardsAndBenfitsPageNavigationPM() throws Exception {

		try {
            String membertier=fUtil.fgetDataNew1("Member_Tier");
			
			if(gmethods.isElementVisible(TdlCromaCard.get().offerCloseaftersignIn, 20)) {
				TdlCromaCard.get().offerCloseaftersignIn.click();
				System.out.println("Offers shown after signIn closed");
			}
			Thread.sleep(2000);


			if(gmethods.isElementVisible(TdlCromaCard.get().uRewardsHomePage_pm, 40)) {
				fUtil.flogResult("Passed", "R&B page", "R&B page is opened", 1);
				TdlCromaCard.get().uRewardsHomePage_pm.click();

			}else {
				fUtil.flogResult("Failed", "R&B page", "R&B page is not opened", 1);
			}
			if(gmethods.isElementVisible(TdlCromaCard.get().brandsPageBtn, 40)) {
				fUtil.flogResult("Passed", "URewards Page ", "URewards Page is opened", 1);
				
			}else
				fUtil.flogResult("Passed", "URewards Page ", "URewards Page is not opened", 1);
			/*
 			if(gmethods.isElementVisible(TdlCromaCard.get().pointsRBPage, 40)) {
				String userPoints=TdlCromaCard.get().pointsRBPage.getText();
				if(!userPoints.contains("NaN")) {
					fUtil.flogResult("Passed", "R&B page Mass Segment Check", "User is of Mass Segment"+userPoints, 1);

					Thread.sleep(5000);
				}else {
					fUtil.flogResult("Failed", "R&B page Mass Segment Check", "Mass Segment is not visible for the member", 1);
				}	
			}

	 		if(membertier.equalsIgnoreCase("mass")) {
				String tier[]=browserFactory.get().getDriver().getCurrentUrl().split("/");

				if(tier[5].equalsIgnoreCase("mass")) {
					fUtil.flogResult("Passed", "Member tier validation", "member tier validated to: "+tier[5], 1);
				}
				else {
					fUtil.flogResult("Failed", "Member tier validation", "member tier not validated to: "+tier[5], 1);
				}
			}

			else if(membertier.equalsIgnoreCase("elite")) {
				String tier[]=browserFactory.get().getDriver().getCurrentUrl().split("/");

				if(tier[5].equalsIgnoreCase("elite")) {
					fUtil.flogResult("Passed", "Member tier validation", "member tier validated to: "+tier[5], 1);
				}
				else {
					fUtil.flogResult("Failed", "Member tier validation", "member tier not validated to: "+tier[5], 1);
				}	
			}

			else if(membertier.equalsIgnoreCase("aspiration")) {
				String tier[]=browserFactory.get().getDriver().getCurrentUrl().split("/");

				if(tier[5].equalsIgnoreCase("aspiration")) {
					fUtil.flogResult("Passed", "Member tier validation", "member tier validated to: "+tier[5], 1);
				}
				else {
					fUtil.flogResult("Failed", "Member tier validation", "member tier not validated to: "+tier[5], 1);
				}	
			}
	 		*/
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : rewardsAndBenfitsPageNavigation ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}

	@Test
	public void uRewardsPageNavigation() throws Exception {

		try {
			String membertier=readData("Member_Tier");

			if(gmethods.isElementVisible(TdlCromaCard.get().offerCloseaftersignIn, 2)) {
				TdlCromaCard.get().offerCloseaftersignIn.click();
				System.out.println("Offers shown after signIn closed");
			}
			Thread.sleep(2000);

			if(gmethods.isElementVisible(TdlCromaCard.get().uRewardsHomePage, 20)) {
				fUtil.flogResult("Passed", "R&B page", "R&B page is opened", 1);
				TdlCromaCard.get().uRewardsHomePage.click();

			}else {
				fUtil.flogResult("Failed", "R&B page", "R&B page is not opened", 1);
				BaseScript.taskKill("chromedriver.exe");
				logger.error("Exception Caught ! Killed The Chrome Instance .");
			}
            /*
			if(membertier.contains("mass")) {
				String tier=browserFactory.get().getDriver().getCurrentUrl();

				if(tier.contains("mass")) {
					fUtil.flogResult("Passed", "Member tier validation", "member tier validated to: "+membertier, 1);
				}
				else {
					fUtil.flogResult("Failed", "Member tier validation", "member tier not validated to: "+membertier, 1);
				}
			}

			else if(membertier.contains("elite")) {
				String tier=browserFactory.get().getDriver().getCurrentUrl();

				if(tier.contains("elite")) {
					fUtil.flogResult("Passed", "Member tier validation", "member tier validated to: "+membertier, 1);
				}
				else {
					fUtil.flogResult("Failed", "Member tier validation", "member tier not validated to: "+membertier, 1);
				}	
			}

			else if(membertier.contains("aspiration")) {
				String tier=browserFactory.get().getDriver().getCurrentUrl();

				if(tier.contains("aspiration")) {
					fUtil.flogResult("Passed", "Member tier validation", "member tier validated to: "+membertier, 1);
				}
				else {
					fUtil.flogResult("Failed", "Member tier validation", "member tier not validated to: "+membertier, 1);
				}	
			}
			*/

			boolean UReawardsHdr=gmethods.isElementVisible(TdlCromaCard.get().uRewardsHdr,20);
			boolean uPointsCard=gmethods.isElementVisible(TdlCromaCard.get().uPointsTCPCard,20);
			boolean uPointsCardCurrentPoints=gmethods.isElementVisible(TdlCromaCard.get().uPointsBalancePage,20);
			//boolean uPointsCardExpiry=gmethods.isElementVisible(TdlCromaCard.get().uPointsCardExpiryDate,20);
			//boolean cromaCard = gmethods.isElementVisible(TdlCromaCard.get().cromaCardNotExpanded,20);
			//pointexpirydate=TdlCromaCard.get().uPointsCardExpiryDate.getText().replace("ON", " ").trim();
			if(UReawardsHdr && uPointsCard && uPointsCardCurrentPoints) {

				logger.info("NeuPass Card is visible");
				fUtil.flogResult("Passed", "NeuPass card Check", "Ucard present with proper details", 1);
			}else {
				fUtil.flogResult("Failed", "NeuPass card Check", "Ucard is not present with proper details", 1);
			}
		
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : uRewardsPageNavigation ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}

	@Test
	public void uRewardsPageNavigationPM() throws Exception {

		try {
			//String membertier=fUtil.fgetDataNew1("Member_Tier");
			
			if(gmethods.isElementVisible(TdlCromaCard.get().offerCloseaftersignIn, 20)) {
				TdlCromaCard.get().offerCloseaftersignIn.click();
				System.out.println("Offers shown after signIn closed");
			}
			Thread.sleep(2000);

         
			if(gmethods.isElementVisible(TdlCromaCard.get().uRewardsHomePage_pm, 40)) {
				fUtil.flogResult("Passed", "R&B page", "R&B page is opened", 1);
				TdlCromaCard.get().uRewardsHomePage_pm.click();

			}else {
				fUtil.flogResult("Failed", "R&B page", "R&B page is not opened", 1);
			}

            /*
			if(membertier.contains("mass")) {
				String tier=browserFactory.get().getDriver().getCurrentUrl();

				if(tier.contains("mass")) {
					fUtil.flogResult("Passed", "Member tier validation", "member tier validated to: "+membertier, 1);
				}
				else {
					fUtil.flogResult("Failed", "Member tier validation", "member tier not validated to: "+membertier, 1);
				}
			}

			else if(membertier.contains("elite")) {
				String tier=browserFactory.get().getDriver().getCurrentUrl();

				if(tier.contains("elite")) {
					fUtil.flogResult("Passed", "Member tier validation", "member tier validated to: "+membertier, 1);
				}
				else {
					fUtil.flogResult("Failed", "Member tier validation", "member tier not validated to: "+membertier, 1);
				}	
			}

			else if(membertier.contains("aspiration")) {
				String tier=browserFactory.get().getDriver().getCurrentUrl();

				if(tier.contains("aspiration")) {
					fUtil.flogResult("Passed", "Member tier validation", "member tier validated to: "+membertier, 1);
				}
				else {
					fUtil.flogResult("Failed", "Member tier validation", "member tier not validated to: "+membertier, 1);
				}	
			}
			*/

			if(gmethods.isElementVisible(TdlCromaCard.get().brandsPageBtn, 40)) {
				fUtil.flogResult("Passed", "URewards Page ", "URewards Page opened", 1);
				TdlCromaCard.get().brandsPageBtn.click();
			}
		//	boolean UReawardsHdr=gmethods.isElementVisible(TdlCromaCard.get().uRewardsHdr_pm,20);
			boolean uPointsCard=gmethods.isElementVisible(TdlCromaCard.get().uPointsTCPCard,20);
			boolean uPointsCardCurrentPoints=gmethods.isElementVisible(TdlCromaCard.get().uPointsBalancePage,20);
			boolean uPointsCardExpiry=gmethods.isElementVisible(TdlCromaCard.get().uPointsCardExpiryDate,20);
		//	boolean cromaCard = gmethods.isElementVisible(TdlCromaCard.get().cromaCardNotExpanded,20);
		//	pointexpirydate=TdlCromaCard.get().uPointsCardExpiryDate.getText().replace("ON", " ").trim();
			if(uPointsCard && uPointsCardCurrentPoints && uPointsCardExpiry) {

				logger.info("U Card is visible");
				fUtil.flogResult("Passed", "Ucard Check", "Ucard present with proper details", 1);
			}else {
				fUtil.flogResult("Failed", "Ucard Check", "Ucard is not present with proper details", 1);
			}
			

		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : uRewardsPageNavigation ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	@Test
	public void cromaCardExpandedDetails() throws Exception {

		try {

			boolean cromaCard=gmethods.isElementVisible(TdlCromaCard.get().cromaCardNotExpanded,20);
			if(cromaCard) {
				TdlCromaCard.get().cromaCardNotExpanded.click();
				fUtil.flogResult("Passed", "Is Croma card selected", "Croma card selected", 1);
			}
			Thread.sleep(10000);
			boolean cromaCardPage = gmethods.isElementVisible(TdlCromaCard.get().cromaCardExpanded, 20);
			boolean shopNowCroma = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
			boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTabCroma,20);
			boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().myBenefitsCroma,20);

			if(cromaCardPage && shopNowCroma && activity && myBenefits ) {

				logger.info("Croma Card is visible");
				fUtil.flogResult("Passed", "Croma Card Expanded Check", "Croma Card present with proper details", 1);
			}else {
				fUtil.flogResult("Failed", "Croma Card Expanded Check", "Croma Card is present with improper details", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : cromaCardExpandedDetails ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}

	@Test
	public void tcpCardExpandedDetails() throws Exception {
		String brand=fUtil.fgetDataNew1("SLP");
		if(brand.contains("Electronics")) {
			gotoCromaCardAfterTransaction();
		}else {
			goToTataCliqCardAfterTransaction();
		}
		try {
 			String paymentmethod=fUtil.fgetDataNew1("payment_method");
 			String purchasetype = fUtil.fgetDataNew1("purchase_type").trim();

			boolean tcpCard=gmethods.isElementVisible(TdlCromaCard.get().tcpviewDetailsBtn,20);
			if(tcpCard) {
				TdlCromaCard.get().tcpviewDetailsBtn.click();
				fUtil.flogResult("Passed", "Is TCP card selected", "TCP card selected", 1);
			}
			Thread.sleep(10000);
			boolean tcpCardPage = gmethods.isElementVisible(TdlCromaCard.get().uPointsLabel, 20);
			//boolean upointbalance = gmethods.isElementVisible(TdlCromaCard.get().uPointsBalance, 20);
			boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTabCroma,20);

			if(tcpCardPage  && activity) {

				logger.info("TCP Card is visible");
				fUtil.flogResult("Passed", "TCP Card Expanded Check", "TCP Card present with proper details", 1);
			}else {
				fUtil.flogResult("Failed", "TCP Card Expanded Check", "TCP Card is present with improper details", 1);
			}

			
			if(paymentmethod.equalsIgnoreCase("TcpPoints")) {
				if (gmethods.isElementVisible(TdlCromaCard.get().activityTabCroma, 20)) {
					String transDescCr = TdlCromaCard.get().transaction_desc.getText();
					String transDateCr = TdlCromaCard.get().transaction_date.getText();
					String points = TdlCromaCard.get().earn_points.getText();
					String points1 = points.substring(1).trim();
					double pointsActualBurn = Double.parseDouble(points1);
					if (points.contains("-") && transDescCr.contains("Redemption") && pointsActualBurn==pointsredeemed) {
						fUtil.flogResult(
								"Passed", "Loyalty Points redeem Check", "Points redeemed Correctly" + " as Expected burn Points:"
										+ pointsredeemed + " is equal to Actual Burn Points:" + points,
										1);
					} else {
						fUtil.flogResult("Failed", "Loyalty Points redeem Check",
								"Points redeemed incorrectly" + " as Expected Burn Points:" + pointsredeemed
								+ " is not equal to Actual Burn Points:" + points,
								1);
					}
					
				}
			}else if(purchasetype.equalsIgnoreCase("Gift Card")){
				String earned_points=TdlCromaCard.get().earn_points.getText().replace("+", " ").trim();
				earn_points=Double.parseDouble(earned_points);
				if(earn_points!=1) {
					fUtil.flogResult("Passed", "Earn points validation for GiftCard", "Points not earned for Gift", 1);
				}
				else {
					fUtil.flogResult("Failed", "Earn points validation for GiftCard","Points earned for GiftCard which is "+earned_points, 1);
				}
			}else {
	 			String transaction_desc=TdlCromaCard.get().transaction_desc.getText();
	//			transaction_date=TdlCromaCard.get().transaction_date.getText();
	//			points_unlock=TdlCromaCard.get().earn_point_unlock.getText().replace("Unlocking", " ").trim();
				gmethods.highlightElement(TdlCromaCard.get().promotionalEarn_points);
				String promotionalPoints1=TdlCromaCard.get().promotionalEarn_points.getText();
				String promotionalPoints2=promotionalPoints1.substring(1).trim();
				double promotionalPoints=Double.parseDouble(promotionalPoints2);
				gmethods.highlightElement(TdlCromaCard.get().promotionalEarn_points);
				if(promotionalPoints1.contains("+") && promotionalPoints==expectedEarnPromotionalPoints && transaction_desc.contains("Promotional") ) {
					fUtil.flogResult("Passed", "Promotional Earn points validation", "Points earned correctly as Expected_Earn:"+expectedEarnPromotionalPoints+" is equal to Actual_Earn:"+promotionalPoints, 1);
				}
				else {
					fUtil.flogResult("Failed", "Promotional Earn points validation","Points not earned correctly as Expected_Earn:"+expectedEarnPromotionalPoints+" is not equal to Actual_Earn:"+promotionalPoints, 1);
				}
				
				/*
				 * 
				 */
				gmethods.highlightElement(TdlCromaCard.get().earn_points);
				String earned_points1=TdlCromaCard.get().earn_points.getText();
				String earned_points=earned_points1.substring(1).trim();
				earn_points=Double.parseDouble(earned_points);
				gmethods.highlightElement(TdlCromaCard.get().earn_points);
				if(earned_points1.contains("+") && earn_points==expectedEarnPromisedPoints) {
					fUtil.flogResult("Passed", "Transaction Earn points validation", "Points earned correctly as Expected_Earn:"+expectedEarnPromisedPoints+" is equal to Actual_Earn:"+earned_points1, 1);
				}
				else {
					fUtil.flogResult("Failed", "Transaction Earn points validation","Points not earned correctly as Expected_Earn:"+expectedEarnPromisedPoints+" is not equal to Actual_Earn:"+earned_points1, 1);
				}
				
			}
			

			
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : cromaCardExpandedDetails ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	

	@Test
	public void tcpCardExpandedDetailsPM() throws Exception {
	//	goToTataCliqCardAfterTransaction();
		try {

			boolean tcpCard=gmethods.isElementVisible(TdlCromaCard.get().uPointsTCPCard,20);
			if(tcpCard) {
				TdlCromaCard.get().uPointsTCPCard.click();
				fUtil.flogResult("Passed", "Is Croma card selected", "Croma card selected", 1);
			}
			Thread.sleep(10000);
			boolean tcpCardPage = gmethods.isElementVisible(TdlCromaCard.get().uPointsLabel, 20);
			boolean upointbalance = gmethods.isElementVisible(TdlCromaCard.get().uPointsBalance, 20);
			boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTabCroma,20);

			if(tcpCardPage && upointbalance && activity) {

				logger.info("Croma Card is visible");
				fUtil.flogResult("Passed", "TCP Card Expanded Check", "TCP Card present with proper details", 1);
			}else {
				fUtil.flogResult("Failed", "TCP Card Expanded Check", "TCP Card is present with improper details", 1);
			}

			String transaction_desc=TdlCromaCard.get().transaction_desc.getText();
			transaction_date=TdlCromaCard.get().transaction_date.getText();
			points_unlock=TdlCromaCard.get().earn_point_unlock.getText().replace("Unlocking", " ").trim();
			String earned_points=TdlCromaCard.get().earn_points.getText().replace("+", " ").trim();
			earn_points=Double.parseDouble(earned_points);

			if(earn_points==expectedEarnPromisedPoints) {
				fUtil.flogResult("Passed", "Earn points validation", "earn points validated to: "+earn_points, 1);
			}
			else {
				fUtil.flogResult("Failed", "Earn points validation", "earn points not validated to: "+earn_points, 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : cromaCardExpandedDetails ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}

	@Test
	public void TCPCardsTransactionInEligibleTender() throws Exception {
		try {
			String brand=fUtil.fgetDataNew1("SLP");
			if(brand.contains("Electronics")) {
				gotoCromaCardAfterTransaction();
			}else {
				goToTataCliqCardAfterTransaction();
			}
			boolean tcpCard=gmethods.isElementVisible(TdlCromaCard.get().uPointsTCPCard,20);
			if(tcpCard) {
				TdlCromaCard.get().uPointsTCPCard.click();
				fUtil.flogResult("Passed", "Is Croma card selected", "Croma card selected", 1);
			}
			Thread.sleep(10000);
			boolean tcpCardPage = gmethods.isElementVisible(TdlCromaCard.get().uPointsLabel, 20);
			boolean upointbalance = gmethods.isElementVisible(TdlCromaCard.get().uPointsBalance, 20);
			boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTabCroma,20);

			if(tcpCardPage && upointbalance && activity) {

				logger.info("Croma Card is visible");
				fUtil.flogResult("Passed", "Croma Card Expanded Check", "Croma Card present with proper details", 1);
			}else {
				fUtil.flogResult("Failed", "Croma Card Expanded Check", "Croma Card is present with improper details", 1);
			}
			Thread.sleep(10000);
			String paymentmethod=readData("payment_method");
			String tcpPoints=readData("Tcppoints_cutoff").trim();
			String purchasetype = readData("purchase_type").trim();
			if(paymentmethod.equalsIgnoreCase("TcpPoints")) {
				if (gmethods.isElementVisible(TdlCromaCard.get().activityTabCroma, 20)) {
					String transDescCr = TdlCromaCard.get().transaction_desc.getText();
					String transDateCr = TdlCromaCard.get().transaction_date.getText();
					String points = TdlCromaCard.get().earn_points.getText();
					String points1 = points.substring(1).trim();
					double pointsActualBurn = Double.parseDouble(points1);
					if (points.contains("-") && transDescCr.contains("Redemption") && pointsActualBurn==pointsredeemed) {
						fUtil.flogResult(
								"Passed", "Loyalty Points redeem Check", "Points redeemed Correctly" + " as Expected burn Points:"
										+ pointsredeemed + " is equal to Actual Earn Points:" + pointsActualBurn,
										1);
					} else {
						fUtil.flogResult("Failed", "Loyalty Points redeem Check",
								"Points redeemed incorrectly" + " as Expected Burn Points:" + pointsUsed
								+ " is not equal to Actual Burn Points:" + pointsActualBurn,
								1);
					}

				}
			}else {
				String earned_points=TdlCromaCard.get().earn_points.getText().replace("+", " ").trim();
				double earn_points1=Double.parseDouble(earned_points);
				if(earn_points1!=1) {
					fUtil.flogResult("Passed", "Earn points validation for GiftCard", "Points not earned for Gift", 1);
				}
				else {
					fUtil.flogResult("Failed", "Earn points validation for GiftCard","Points earned for GiftCard which is "+earned_points, 1);
				}
			}
			

		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}
	
	@Test
	public void exclusiveStoriesWidget() throws Exception {

		try {

			gmethods.scrollToViewElement(TdlCromaCard.get().exclusiveStoriesWidget);
			boolean pointsWidget = gmethods.isElementVisible(TdlCromaCard.get().exclusiveStoriesWidget, 20);
			if (pointsWidget == true) {
				logger.info("exclusiveStoriesWidget is visible");

				if(gmethods.isElementVisible(TdlCromaCard.get().exclusiveStoriesWidget, 20)) {
					fUtil.flogResult("Passed", "Visibility of exclusiveStoriesWidget", "Widget is present", 1);
					gmethods.scrollToViewElement(TdlCromaCard.get().exclusiveStoriesWidgetDesc1);
					if(gmethods.isElementVisible(TdlCromaCard.get().exclusiveStoriesWidgetDesc1, 20)) {
						String descofProduct=TdlCromaCard.get().exclusiveStoriesWidgetDesc1.getText();
						fUtil.flogResult("Passed", "exclusiveStoriesWidget widget-Products", "Product in the Widget is present with decrption: "+descofProduct, 1);
					}else {
						fUtil.flogResult("Failed", "exclusiveStoriesWidget widget-Products", "Product in the Widget is not present", 1);
					}
					//TdlCromaCard.get().exclusiveStoriesWidget.click();
					//User will land on Widget details page
					//Thread.sleep(5000);

				}

			}else {
				fUtil.flogResult("Failed", "exclusiveStoriesWidget widget", "exclusiveStoriesWidget is not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : exclusiveStoriesWidget ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}

	@Test
	public void indulgeWidget() throws Exception {

		try {
            
			boolean widgetPresent = gmethods.isElementVisible(TdlCromaCard.get().indulgeWidget, 20);
			if (widgetPresent == true) {
				logger.info("indulgeWidget is visible");

				if(gmethods.isElementVisible(TdlCromaCard.get().indulgeWidget, 20)) {
					fUtil.flogResult("Passed", "Visibility of Offers you'll love Widget", "Widget is present", 1);
					
					for (int i = 0; i < 5; i++) {
						if(i>2) {
							TdlCromaCard.get().widgetNavigatorBtn.click();
						}
						String Xpath="//*[contains(text(),'Offers you')]/following::h5["+(i+1)+"]";
						if(gmethods.isElementVisibleXpath(Xpath,10)) {
							String descofOffer=BrowserFactory.webDriver.get().findElement(By.xpath(Xpath)).getText();
							fUtil.flogResult("Passed", "Offers you'll love-Products", "Product in the Widget is present with decrption: "+descofOffer, 1);
						
						
						}else {
							fUtil.flogResult("Failed", "Offers you'll love-Products", "Product in the Widget is not present with decrption: ", 1);
						}
						BrowserFactory.webDriver.get().findElement(By.xpath(Xpath)).click();
						
						switchTabByTabNumber(i+1);
						if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().laterCliq, 10)) {
							TDL_SLPElectronicsPage.get().laterCliq.click();
							fUtil.flogResult("Passed", "Click ask later in cliq page",
									"Clicked ask later in cliq page successfully", 1);
						}
						if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().LogedCroma,25)||gmethods.isElementVisible(TDL_SLPElectronicsPage.get().Loged,25))
						{
						fUtil.flogResult("Passed", "Validate User Auto Logged in", 
									"Validate USer Auto Logged in",1);
						}else{
							fUtil.flogResult("Failed", "Validate USer Auto Logged in", 
									"Validate USer not Auto Logged in",1);
						}
						
						switchTabByTabNumber(0);
						Thread.sleep(2000);
					}
				}
				else {
					fUtil.flogResult("Failed", "Visibility of indulge Widget", "Widget is not present", 1);
				}
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : indulgeWidget ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	public void switchTabByTabNumber(int number) throws Exception {
		try {
			Thread.sleep(3000);
			Set<String> handles = BrowserFactory.webDriver.get().getWindowHandles();
			if (handles.size() > number) {
				BrowserFactory.webDriver.get().switchTo().window((String) handles.toArray()[number]);
				System.out.println("Switched to Tab " + number);
			}else
				fUtil.flogResult("Failed", "Validate switching to Tab: "+(number+1), "Tab not present", 1);
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Switching Tab", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	
	public void switchToNewTab() throws Exception {
		try {
			Thread.sleep(5000);
			Set<String> handles = BrowserFactory.webDriver.get().getWindowHandles();
			int tabNumber=handles.size()-1;
			if (handles.size() > tabNumber) {
				BrowserFactory.webDriver.get().switchTo().window((String) handles.toArray()[tabNumber]);
				System.out.println("Switched to Tab " + tabNumber);
			}else {
				fUtil.flogResult("Failed", "Validate switching to Tab: "+(tabNumber+1), "Tab not present", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Switching Tab", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Test
	public void indulgeWidgetPM() throws Exception {

		try {
             gmethods.scrollToViewElement(TdlCromaCard.get().indulgeWidget);
			
			boolean widgetPresent = gmethods.isElementVisible(TdlCromaCard.get().indulgeWidget, 20);
			if (widgetPresent == true) {
				logger.info("indulgeWidget is visible");

				if(gmethods.isElementVisible(TdlCromaCard.get().indulgeWidget, 20)) {
					fUtil.flogResult("Passed", "Visibility of Offers you'll love Widget", "Widget is present", 1);
					
		 			gmethods.scrollToViewElement(TdlCromaCard.get().indulgeWidgetOffer1);
					
					if(gmethods.isElementVisible(TdlCromaCard.get().indulgeWidgetOffer1, 20)) {
						
			 			String descofOffer=TdlCromaCard.get().indulgeWidgetOffer1.getText();
						fUtil.flogResult("Passed", "Offers you'll love-Products", "Product in the Widget is present with decrption: "+descofOffer, 1);
					}else {
						fUtil.flogResult("Failed", "Offers you'll love-Products", "Product in the Widget is not present with decrption: ", 1);
					}
					//TdlCromaCard.get().indulgeWidgetOffer1.click();
					//User will land on Widget details page
					//Thread.sleep(10000);

				}
				else {
					fUtil.flogResult("Failed", "Visibility of indulge Widget", "Widget is not present", 1);
				}
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : indulgeWidget ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	@Test
	public void rewardsProgNudge() throws Exception {

		try {

			//gmethods.scrollToViewElement(TdlCromaCard.get().rewardsNudge);
			
			boolean widgetPresent = gmethods.isElementVisible(TdlCromaCard.get().rewardsNudge, 20);
			if (widgetPresent == true) {
					fUtil.flogResult("Passed", "Visibility of Rewards Nudge Widget", "Widget is present", 1);
					
					if (gmethods.isElementVisible(TdlCromaCard.get().rewardsKnowMoreCTA, 20)) {
						fUtil.flogResult("Passed", "Know more CTA",
								"Know more CTA is present", 1);
					} else {
						fUtil.flogResult("Failed", "Know more CTA",
								"Know more CTA is not present", 1);
					}
					TdlCromaCard.get().rewardsKnowMoreCTA.click();
					// User will land on Widget details page
					//switchToNewTab();
					
					if (gmethods.isElementVisible(TdlCromaCard.get().rewardsNudge, 30)) {
					//	List<WebElement> rewards= TdlCromaCard.get().rewardsDetails;
						fUtil.flogResult("Passed", "TCP Rewards program page",
								"TCP Rewards program page opened", 1);
						scrollToBottom();
						for(WebElement rewards:TdlCromaCard.get().rewardsDetails) {
							fUtil.flogResult("Passed", "TataNeu Rewards program deatil",rewards.getText(), 1);
						}
					}
				} else {
					fUtil.flogResult("Failed", "Visibility of Rewards Nudge Widget", "Widget is not present", 1);
				}
			
		} catch (Exception e) {
			fUtil.flogResult("Failed", " Function : rewardsProgNudge ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}



	/*
	 * This Method is used for Existing User to Login to TCP APP
	 * 
	 */

	@Test
	public void loginToApp() throws Exception {
		try {
			String mobileNumber = fUtil.fgetDataNew1("Mobile_no");
			String password = fUtil.fgetDataNew1("Password");

			gmethods.signInPwa(mobileNumber, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void validateElectronicsHomePage() throws Exception{
		try {
			boolean titleHomepage=gmethods.isElementVisible(TdlCromaCard.get().electronics_slp_croma, 50);
			//boolean searchButton=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButton, 10);
			if(titleHomepage ) {
				fUtil.flogResult("Passed","Validate SLP Electronics page loaded", "SLP Electronics homepage loaded with title: "+TDL_SLPElectronicsPage.get().electronicsHomepageTitle.getText()+" and search option present",1);
			}else {
				fUtil.flogResult("Failed","Validate SLP Electronics page loaded", "SLP Electronics homepage not loaded properly",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP Electronics page loaded", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	

	@Test
	public void validateSwitchToNewTab() throws Exception{
		try {
			//updated to check redirection on same tab


			//String url= BrowserFactory.webDriver.get().getCurrentUrl();

			//gmethods.switchToNewTab();
			//				Alert alert = BrowserFactory.webDriver.get().switchTo().alert();
			//				alert.accept();
			String url=BrowserFactory.webDriver.get().getTitle();
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate redirected to new tab", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}finally {
			switchTabByTabNumber(1);
			Thread.sleep(5000);
			String title= BrowserFactory.webDriver.get().getTitle();
			System.out.print("Current Title: "+title);
			if(!title.equals(fUtil.fgetDataNew1("SLP")+" SLP"))
				fUtil.flogResult("Passed", "Validate redirected to new page", "Redirected to new page with title: "+BrowserFactory.webDriver.get().getTitle(), 1);
			else
				fUtil.flogResult("Failed", "Validate redirected to new page", "Didn't redirected to new page", 1);
		}
	}

	//24-2
	//To click on Search Button on Electronics Homepage
	@Test
	public void clickOnSearchButtonHomepage() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButton,20)) {
				if((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().searchButton, 10))){
					TDL_SLPElectronicsPage.get().searchButton.click();
					fUtil.flogResult("Passed", "Validate Click on Search Button Homepage", "Search Button on Homepage clicked",1);
					validateSwitchToNewTab();
				}else
					fUtil.flogResult("Failed", "Validate Click on Search Button Homepage", "Search Button on Homepage not clickable",1);
			}else
				fUtil.flogResult("Failed", "Validate Click on Search Button Homepage", "Search Button on Homepage not found",1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate click on Search Button Homepage", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To scroll to Shop by Category on Electronics Homepage
	@Test
	public void scrollToShopCategoryWidget() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().electronicsShopbyCateogry); 
			fUtil.flogResult("Passed", "Validate Scroll to Shop by Category Widget", "Scrolled to Shop by Category Widget successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to Shop by Category", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To click on Home Appliance Category on Electronics Homepage
	@Test
	public void clickonHomeApplianceCategory() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsHomeApplianceCategory,20)) {
				if((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().electronicsHomeApplianceCategory, 10))){
					TDL_SLPElectronicsPage.get().electronicsHomeApplianceCategory.click();
					fUtil.flogResult("Passed", "Validate Click on Home Appliances Category", "Home Appliances Category clicked",1);
					validateSwitchToNewTab();
				}else
					fUtil.flogResult("Failed", "Validate Click on Home Appliances Category", "Home Appliances Category not clickable",1);
			}else
				fUtil.flogResult("Failed", "Validate Click on Home Appliances Category", "Home Appliances Category not found",1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate click on Home Appliances Category", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To scroll to Limited deal on Electronics Homepage
	@Test
	public void scrollToLimitedDealsWidget() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().electronicsLimitedDeal); 
			fUtil.flogResult("Passed", "Validate Scroll to Limited deal widget", "Scrolled to Limited deal widget successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to Limited deal widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To click on first limited deal available on Electronics Homepage
	@Test
	public void clickonLimitedDealsAvailable() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().limitedDeals_container.get(0),20)) {
				if((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().limitedDeals_container.get(0), 10))){
					String text=TDL_SLPElectronicsPage.get().limitedDeals_container.get(0).getText();
					TDL_SLPElectronicsPage.get().limitedDealsButton_container.get(0).click();
					fUtil.flogResult("Passed", "Validate Click on First limited deals availble", "First availble limited deals clicked with description: "+text,1);
					validateSwitchToNewTab();
				}else
					fUtil.flogResult("Failed", "Validate Click on First limited deals availble", "First availble limited deals not clickable",1);
			}else
				fUtil.flogResult("Failed", "Validate Click on First limited deals availble", "First availble limited deals not found",1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate click on First limited deals availble", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To scroll to Recommended Offers on Electronics Homepage
	@Test
	public void scrollToRecommendedOffersWidget() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().electronicsOffersRecommended) ;
			fUtil.flogResult("Passed", "Validate Scroll to Recommended Offers widget", "Scrolled to Recommended Offers widget successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to Recommended Offers widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To swipe horizontally Recommended offers on Electronics Homepage
	@Test
	public void scrollRecommendedOffers() throws Exception{
		try {
			int i=0;
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsRecOfferNext,20)) {
				while((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().electronicsRecOfferNext,10))){
					TDL_SLPElectronicsPage.get().electronicsRecOfferNext.click();
					i++;
					if(TDL_SLPElectronicsPage.get().electronicsRecOfferNext.getAttribute("class").contains("disabled")) {
						fUtil.flogResult("Passed", "Validate No Infinity Scroll Right for Recommended Offers", "No Infinity Scroll Right for Recommended Offers found", 1);
						break;
					}
					if(i==10) {
						fUtil.flogResult("Failed", "Validate No Infinity Scroll Right for Recommended Offers", "No Infinity Scroll Right for Recommended Offers not found", 1);
						break;
					}
					Thread.sleep(1000);
				}
			}else
				fUtil.flogResult("Failed", "Scroll to Last Offer available", "Scrolling to Last Offer available not found",1);
			i=0;
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsRecOfferPrev,20)) {
				while((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().electronicsRecOfferPrev, 10))){
					TDL_SLPElectronicsPage.get().electronicsRecOfferPrev.click();
					i++;
					if(TDL_SLPElectronicsPage.get().electronicsRecOfferPrev.getAttribute("class").contains("disabled")) {
						fUtil.flogResult("Passed", "Validate No Infinity Scroll Left for Recommended Offers", "No Infinity Scroll Left for Recommended Offers found", 1);
						break;
					}
					if(i==10) {
						fUtil.flogResult("Failed", "Validate No Infinity Scroll Left for Recommended Offers", "No Infinity Scroll Left for Recommended Offers not found", 1);
						break;
					}
					Thread.sleep(1000);
				}
			}else
				fUtil.flogResult("Failed", "Validate Scroll back to first Offer available", "Scrolling back to first Offer available not found",1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Scroll for Recommended Offers available", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}


	//2-3 Sourav
	//To click on CTA of credit line
	@Test
	public void clickonCreditLineCTA() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsCreditLineCTA,20)) {
				if((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().electronicsCreditLineCTA, 10))){
					TDL_SLPElectronicsPage.get().electronicsCreditLineCTA.click();
					fUtil.flogResult("Passed", "Validate Click on Credit Line CTA", "Credit Line CTA clicked",1);
					validateSwitchToNewTab();
				}else
					fUtil.flogResult("Failed", "Validate Click on Credit Line CTA", "Credit Line CTA not clickable",1);
			}else
				fUtil.flogResult("Failed", "Validate Click on Credit Line CTA", "Credit Line CTA not found",1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate click on Credit Line CTA", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void heroBannerSwipe() throws Exception {
		try {
			int listOfElementsDots = TDL_SLPElectronicsPage.get().heroBannerdot.size();
			if(listOfElementsDots==0)
				gmethods.scroll("DOWN",0.2);
			listOfElementsDots = TDL_SLPElectronicsPage.get().heroBannerdot.size();
			System.out.print("Dots: "+listOfElementsDots);
			int listOfElementsDesc = TDL_SLPElectronicsPage.get().heroBannerJourneyDesc.size();
			System.out.print("Desc: "+listOfElementsDesc);
			int listOfElementsCTA = TDL_SLPElectronicsPage.get().heroBannerJourneyCTA.size();
			System.out.print("CTA: "+listOfElementsCTA);
			for(int i=0;i<listOfElementsDesc;i++) {
				System.out.println("Clickable: "+gmethods.isElementClickable(TDL_SLPElectronicsPage.get().heroBannerdot.get(i), 10));
				Thread.sleep(2000);
				TDL_SLPElectronicsPage.get().heroBannerdot.get(i).click();
				fUtil.flogResult("Passed", "Validate Hero Banner Swipe", "Hero Banner brand "+(i+1)+" present with Title: "+TDL_SLPElectronicsPage.get().heroBannerJourneyTitle.get(i).getText()+" Description: "
						+TDL_SLPElectronicsPage.get().heroBannerJourneyDesc.get(i).getText(), 1);
				System.out.print("index "+i+" Title: "+TDL_SLPElectronicsPage.get().heroBannerJourneyTitle.get(i).getText());
				System.out.print("index "+i+" desc: "+TDL_SLPElectronicsPage.get().heroBannerJourneyDesc.get(i).getText());
			}
			//Thread.sleep(2000);
			//TDL_SLPElectronicsPage.get().heroBannerJourneyCTA.get(listOfElementsCTA-1).click();
			//fUtil.flogResult("Passed", "Validate Click on hero banner CTA", "Clicked on hero banner CTA successfully", 1);
			//validateSwitchToNewTab();
		} catch (Exception e) {
			fUtil.flogResult("Failed", "heroBannerSwipePwaMobile ",
					"Exception while swiping in Hero banner page in PWA Mobile" + e.getMessage(), 1);
		}
	}

	//3-3 sourav
	//To click on Video Demo on Electronics page
	@Test
	public void clickonVideoDemo() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().limitedDeals_container.get(1),20)) {
				if((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().limitedDeals_container.get(1), 10))){
					String text=TDL_SLPElectronicsPage.get().limitedDeals_container.get(1).getText();
					TDL_SLPElectronicsPage.get().limitedDealsButton_container.get(1).click();
					fUtil.flogResult("Passed", "Validate Click on Video Demo", "Video Demo clicked with description: "+text,1);
					validateSwitchToNewTab();
				}else
					fUtil.flogResult("Failed", "Validate Click on Video Demo", "Video Demo not clickable",1);
			}else
				fUtil.flogResult("Failed", "Validate Click on Video Demo", "Video Demo not found",1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate click on Video Demo", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To scroll to Credit Line widget on Electronics Homepage
	@Test
	public void scrollToExpertReviewsWidget() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().electronicsExpertReview);
			fUtil.flogResult("Passed", "Validate Scroll to Expert Reviews widget", "Scrolled to Expert Reviews widget successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to Expert Reviews widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To check contents present under Expert reviews
	@Test
	public void checkContentExpertReview() throws Exception{
		try {
			Thread.sleep(5000);
			Thread.sleep(5000);
			int contentNum=TDL_SLPElectronicsPage.get().electronicsExpertReviewContentDesc.size();
			if(contentNum!=0) {
				fUtil.flogResult("Passed", "Validate Content Tiles under Expert Reviews",contentNum+" Content Tiles present under Expert Reviews with play button", 1);
				for(int i=0;i<contentNum;i++) {
					fUtil.flogResult("Passed", "Validate Content Tiles under Expert Reviews", "Content Tiles under Expert Reviews: "+(i+1)+" present with Description: "
							+TDL_SLPElectronicsPage.get().electronicsExpertReviewContentDesc.get(i).getText(), 1);
				}
			}else
				fUtil.flogResult("Failed", "Validate Content Tiles under Expert Reviews", "Content Tiles not present under Expert Reviews", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate contents on Expert Reviews widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To scroll to Guide to Electronics widget on Electronics Homepage
	@Test
	public void scrollToGuidetoElectronicsWidget() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().electronicsGuideToElectronics);
			fUtil.flogResult("Passed", "Validate Scroll to Guide to Electronics widget", "Scrolled to Guide to Electronics widget successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to Guide to Electronics widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	//To check contents present under Expert reviews
	@Test
	public void checkContentGuideElectronics() throws Exception{
		try {
			int contentNum=TDL_SLPElectronicsPage.get().electronicsGuideContentDesc.size();
			if(contentNum==0)
				gmethods.scroll("DOWN",0.2);
			contentNum=TDL_SLPElectronicsPage.get().electronicsGuideContentDesc.size();
			if(contentNum!=0) {
				fUtil.flogResult("Passed", "Validate Content Tiles under Guide to Electronics",contentNum+" Content Tiles present under Guide to Electronics", 1);
				for(int i=0;i<contentNum;i++) {
					fUtil.flogResult("Passed", "Validate Content Tiles under Guide to Electronics","Content Tile "+(i+1)+" present with Description: "+TDL_SLPElectronicsPage.get().electronicsGuideContentDesc.get(i).getText(),1);
				}
				Actions action =new Actions(BrowserFactory.webDriver.get());
				action.moveToElement(TDL_SLPElectronicsPage.get().electronicsGuideContentDesc.get(contentNum-1)).click().build().perform();
				//						TDL_SLPElectronicsPage.get().electronicsGuideContentDesc.get(contentNum-1).click();
				validateSwitchToNewTab();
			}else
				fUtil.flogResult("Failed", "Validate Content Tiles under Expert Reviews", "Content Tiles not present under Expert Reviews", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate contents on Expert Reviews widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	

	@Test
	public void heroBannerSelection(String journey) throws Exception {
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().HeroBannerContainer);

			int BannersSize = TDL_SLPElectronicsPage.get().heroBannerdot.size();
			System.out.print("Dots: "+BannersSize);

			for(int i=0;i<BannersSize;i++) {
				System.out.println("Clickable:"+gmethods.isElementClickable(TDL_SLPElectronicsPage.get().heroBannerdot.get(i), 10));
				Thread.sleep(2000);
				TDL_SLPElectronicsPage.get().heroBannerdot.get(i);
				String Title = TdlCromaCard.get().heroBannerJourneyTitle.get(i).getText();
				String description = TdlCromaCard.get().heroBannerJourneyDesc.get(i).getText();
				System.out.print("index "+i+" title "+Title);
				System.out.print("index "+i+" desc: "+description);
				if(Title.equalsIgnoreCase(journey))
				{
					Thread.sleep(2000);
					TdlCromaCard.get().heroBannerJourneyCTA.get(i).click();
					fUtil.flogResult("Passed","Validate Click on hero banner CTA", "Clicked on hero banner CTA successfully", 1);
					validateSwitchToNewTab();
					break;
				}
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "heroBannerSelectionPwaMobile ",
					"Exception while selecting in Hero banner page in PWA Mobile" + e.getMessage(), 1);
		}
	}


	@Test
	public void validateBeautyHomePage() throws Exception{
		try {
			boolean titleHomepage=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().BeautyHomepageTitle, 30);
			boolean searchButton=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButton, 20);
			if(titleHomepage && searchButton) {
				fUtil.flogResult("Passed","Validate SLP Beauty page loaded and search icon present", "SLP Beauty homepage loaded with title: "+TDL_SLPElectronicsPage.get().BeautyHomepageTitle.getText()+ "and search icon present",1);
			}else {
				fUtil.flogResult("Failed","Validate SLP Beauty page loaded and search icon present", "SLP Beauty homepage not loaded properly",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP Beauty page loaded", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}


	//general method to select any widget any SLP//
	@Test
	public void selectWidget( List<WebElement> widjetList, String widget,String widgetTitle) throws Exception{
		try {

			int size = widjetList.size();
			boolean flag = false;
			for(int i=0;i<size ; i++)
			{
				if(gmethods.isElementVisible(widjetList.get(i),5)) {
					String widgetTitleUI = widjetList.get(i).getText();

					fUtil.flogResult("Passed","validate"+widget+ "contains" +widgetTitle, "validated"+widget+ "contains" +widgetTitleUI ,1);

					if(widgetTitleUI.equalsIgnoreCase(widgetTitle))
					{
						widjetList.get(i).click();
						fUtil.flogResult("Passed","validate"+widget+ "contains" +widgetTitle+ "and click", "validated"+widget+ "contains" +widgetTitleUI+ "and clicked" ,1);
						flag = true;
						break;
					}
				}else {
					fUtil.flogResult("Failed","validate"+widget+ "contains" +widgetTitle, "No widget is visible ",1);
				}

			}
			if(flag == true)
			{fUtil.flogResult("Passed","validate click widget", "clicked Widget successfully" ,1);
			}
			else
			{
				fUtil.flogResult("Failed","validate click widget", "clicked Widget not successful" ,1);
			}
		}catch (Exception e) {
			fUtil.flogResult("Failed", "select widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void selectShopbythemeWidgetUI( ) throws Exception{
		try {
			String widgetEx = fUtil.fgetDataNew1("widget");
			String widgetTitleEx = fUtil.fgetDataNew1("widgetTitle");
			selectWidget(TDL_SLPElectronicsPage.get().ThemeselectTitle,widgetEx,widgetTitleEx);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "RecommendList widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	//general method to navigate to fetch all widget and get title any SLP//

	@Test
	public void fetchWidget( List<WebElement> widjetList, String widget,String widgetTitle) throws Exception{
		try {

			int size = widjetList.size();
			for(int i=0;i<size ; i++)
			{
				if(gmethods.isElementVisible(widjetList.get(i),5)) {
					String widgetTitleUI = widjetList.get(i).getText();

					fUtil.flogResult("Passed","validate"+widget+ "contains" +widgetTitle, "validated"+widget+ "contains" +widgetTitleUI ,1);

					System.out.println(widgetTitleUI);
				}else {
					fUtil.flogResult("Failed","validate"+widget+ "contains" +widgetTitle, "No widget is visible ",1);
				}

			}
			fUtil.flogResult("Passed","Total widget"+widget, "Total widget present for"+widget+ "is" +size ,1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "count widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//general method to navigate to widget and chk if widget present for any SLP//
	@Test
	public void validatewidgetPresent(WebElement widgetsearch,String widget,String SLP) throws Exception{
		try {
			gmethods.scrollToViewElement(widgetsearch);
			if(gmethods.isElementVisible(widgetsearch,5)) {
				fUtil.flogResult("Passed","Validate SLP" +SLP+"page" +widget, "SLP" +SLP+"page" +widget+ "widget present",1);
				//clickFeaturedOfferWidgetHotel();

			}else {
				fUtil.flogResult("Failed","Validate SLP" +SLP+"page" +widget, "SLP"+SLP+" widget not present",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP" +SLP+"page" +widget, "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//general method to click widget without title//
	@Test
	public void clickWidgetNoTitle(List<WebElement> widjetList,String widget,int number) throws Exception{
		try {
			int i = number -1;
			if(gmethods.isElementVisible(widjetList.get(i),5)) {

				widjetList.get(i).click();
				fUtil.flogResult("Passed","click widget"+widget, "clicked"+widget+ "widget",1);

			}else {
				fUtil.flogResult("Failed","click widget"+widget, "widget not clicked ",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "click widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void countShopbythemeWidgetUI( ) throws Exception{
		try {
			String widgetEx = fUtil.fgetDataNew1("widget");
			String widgetTitleEx = fUtil.fgetDataNew1("widgetTitle");
			fetchWidget(TDL_SLPElectronicsPage.get().ThemeselectTitle,widgetEx,widgetTitleEx);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "RecommendList widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void validateShopbythemeWidgetUI( ) throws Exception{
		try {
			String widgetEx = fUtil.fgetDataNew1("widget");
			String widgetTitleEx = fUtil.fgetDataNew1("widgetTitle");
			String SLPjourney = fUtil.fgetDataNew1("SLP");
			validatewidgetPresent(TDL_SLPElectronicsPage.get().ThemeTitle,widgetEx,SLPjourney);
			fetchWidget(TDL_SLPElectronicsPage.get().ThemeselectTitle,widgetEx,widgetTitleEx);
			selectWidget(TDL_SLPElectronicsPage.get().ThemeselectTitle,widgetEx,widgetTitleEx);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "shop by theme widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void validateShopbyCategoryWidgetUI( ) throws Exception{
		try {
			String widgetEx = fUtil.fgetDataNew1("widget");
			String widgetTitleEx = fUtil.fgetDataNew1("widgetTitle");
			String SLPjourney = fUtil.fgetDataNew1("SLP");
			validatewidgetPresent(TDL_SLPElectronicsPage.get().category,widgetEx,SLPjourney);
			fetchWidget(TDL_SLPElectronicsPage.get().shopCategorylist,widgetEx,widgetTitleEx);
			selectWidget(TDL_SLPElectronicsPage.get().shopCategorylist,widgetEx,widgetTitleEx);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Shop by category widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void validateTopBrandsWidgetUI( ) throws Exception{
		try {
			String widgetEx = fUtil.fgetDataNew1("widget");
			String widgetTitleEx = fUtil.fgetDataNew1("widgetTitle");
			String SLPjourney = fUtil.fgetDataNew1("SLP");
			String numberEx = fUtil.fgetDataNew1("Number");
			int val = Integer.parseInt(numberEx); 
			validatewidgetPresent(TDL_SLPElectronicsPage.get().TopBrands,widgetEx,SLPjourney);
			fetchWidget(TDL_SLPElectronicsPage.get().TopBrandslist,widgetEx,widgetTitleEx);
			clickWidgetNoTitle(TDL_SLPElectronicsPage.get().TopBrandslist,widgetEx,val);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "TopBrands widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	@Test
	public void clickSearchButtonCliqPM() throws Exception {
		try {
			Thread.sleep(5000);
			String productName = fUtil.fgetDataNew1("Product_Id");
			ArrayList<String> newTb = new ArrayList<String>(BrowserFactory.webDriver.get().getWindowHandles());
			// switch to new tab
			BrowserFactory.webDriver.get().switchTo().window(newTb.get(1));
			System.out.println("Page title of new tab: " + BrowserFactory.webDriver.get().getTitle());
			Thread.sleep(8000);
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButtonCliqPM, 30)) {
				Thread.sleep(8000);
				TDL_SLPElectronicsPage.get().searchButtonCliqPM.click();
				Thread.sleep(5000);
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().inputSearchCliqPM, 30)) {
					TDL_SLPElectronicsPage.get().inputSearchCliqPM.sendKeys(productName);
					TDL_SLPElectronicsPage.get().inputSearchCliqPM.sendKeys(Keys.ENTER);
					//						TDL_SLPElectronicsPage.get().inputSearchCliqPM.sendKeys(Keys.ENTER);
					//						if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchResultCliq,20)) {
					//							fUtil.flogResult("Passed","Validate Product found", "Product: "+"mp000000006917444"+"found successfully", 1);
					//							TDL_SLPElectronicsPage.get().searchResultCliq.click();
					//						}
				}
			} else {
				fUtil.flogResult("Failed", "Validate Search button on TATA Cliq",
						"Search button on TATA Cliq not found", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectSizeCliqPM() throws Exception {
		try {

			//				switchTabByTabNumber(2);
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().selectSizePM);
			int size = TDL_SLPElectronicsPage.get().sizeListPM.size();
			System.out.println(size);
			Actions action = new Actions(BrowserFactory.webDriver.get());
			Thread.sleep(5000);
			Thread.sleep(5000);
			action.moveToElement(TDL_SLPElectronicsPage.get().sizeListPM.get(0)).click().build().perform();
			//				TDL_SLPElectronicsPage.get().sizeListPM.get(0).click();
			//				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().sizeCliq,20)) {
			//					fUtil.flogResult("Passed","Validate size option", "Size: "+TDL_SLPElectronicsPage.get().sizeCliq.getText()+"selected successfully", 1);
			//					TDL_SLPElectronicsPage.get().sizeCliq.click();
			//				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectProductCliqPM() throws Exception {
		try {

			// BrowserFactory.webDriver.get().switchTo().frame(0);
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().productCliqPM, 30)) {
				Thread.sleep(5000);
				Thread.sleep(5000);
				Actions action = new Actions(BrowserFactory.webDriver.get());
				action.moveToElement(TDL_SLPElectronicsPage.get().productCliqPM).click().build().perform();

				fUtil.flogResult("Passed", "click a popular product in cliq page",
						"clicked a popular product in cliq successfully", 1);
			} else {
				fUtil.flogResult("Failed", "click a popular product in cliq page",
						"Not clicked a popular product in Cliq page", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "click a popular product in cliq",
					"Not click a popular product in cliq failed due to:" + e.getMessage(), 1);
		}
	}
	// To validate Login Success message on PWA Mobile
	@Test
	public void userLoginCliqPM() throws Exception {
		try {
			ArrayList<String> newTb = new ArrayList<String>(BrowserFactory.webDriver.get().getWindowHandles());
			// switch to new tab
			BrowserFactory.webDriver.get().switchTo().window(newTb.get(1));
			System.out.println("Page title of new tab: " + BrowserFactory.webDriver.get().getTitle());

			gmethods.isElementVisible(TDL_SLPElectronicsPage.get().autoLogInCliq_android, 30);
			fUtil.flogResult("Passed", "Validate User Auto Logged In",
					"User auto logged in successfully to Tata Cliq", 1);


		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//4-3 Sourav
	//To scroll to Offers from Other Brands on Electronics Homepage
	@Test
	public void scrollToOffersfromOtherBrandsWidget() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().electronicsCrossBandOffers);
			fUtil.flogResult("Passed", "Validate Scroll to Offers from Other Brands widget", "Scrolled to Offers from Other Brands widget successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to Offers from Other Brands widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To swipe horizontally Next Best offers on Electronics Homepage
	@Test
	public void scrollNextBestOffer() throws Exception{
		try {
			int i=0;
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsNextBestOfferNext,20)) {
				while((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().electronicsNextBestOfferNext,10))){
					TDL_SLPElectronicsPage.get().electronicsNextBestOfferNext.click();
					i++;
					if(TDL_SLPElectronicsPage.get().electronicsNextBestOfferNext.getAttribute("class").contains("disabled")) {
						fUtil.flogResult("Passed", "Validate No Infinity Scroll Right for Next Best offers", "No Infinity Scroll Right for Next Best offers found", 1);
						break;
					}
					if(i==5) {
						fUtil.flogResult("Failed", "Validate No Infinity Scroll Right for Next Best offers", "No Infinity Scroll Right for Next Best offers not found", 1);
						break;
					}
				}
			}else
				fUtil.flogResult("Failed", "Scroll to Last Offer available", "Scrolling to Last Offer available not found",1);
			i=0;
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsNextBestOfferPrev,20)) {
				while((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().electronicsNextBestOfferPrev, 10))){
					TDL_SLPElectronicsPage.get().electronicsNextBestOfferPrev.click();
					i++;
					if(TDL_SLPElectronicsPage.get().electronicsNextBestOfferPrev.getAttribute("class").contains("disabled")) {
						fUtil.flogResult("Passed", "Validate No Infinity Scroll Left for Next Best offers", "No Infinity Scroll Left for Next Best offers found", 1);
						break;
					}
					if(i==5) {
						fUtil.flogResult("Failed", "Validate No Infinity Scroll Left for Next Best offers", "No Infinity Scroll Left for Next Best offers not found", 1);
						break;
					}
				}
			}else
				fUtil.flogResult("Failed", "Validate Scroll back to first Offer available", "Scrolling back to first Offer available not found",1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Scroll for Next Best offers available", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To swipe horizontally Offers from Other Brand on Electronics Homepage
	@Test
	public void scrollOffersfromOtherBrand() throws Exception{
		try {
			int i=0;
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsNext,20)) {
				while((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsNext,10))){
					TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsNext.click();
					i++;
					if(TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsNext.getAttribute("class").contains("disabled")) {
						fUtil.flogResult("Passed", "Validate No Infinity Scroll Right for Offers from Other Brand", "No Infinity Scroll Right for Offers from Other Brand found", 1);
						break;
					}
					if(i==5) {
						fUtil.flogResult("Failed", "Validate No Infinity Scroll Right for Offers from Other Brand", "No Infinity Scroll Right for Offers from Other Brand not found", 1);
						break;
					}
				}
			}else
				fUtil.flogResult("Failed", "Scroll to Last Offer available", "Scrolling to Last Offer available not found",1);
			i=0;
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsPrev,20)) {
				while((gmethods.isElementClickable(TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsPrev, 10))){
					TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsPrev.click();
					i++;
					if(TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsPrev.getAttribute("class").contains("disabled")) {
						fUtil.flogResult("Passed", "Validate No Infinity Scroll Left for Offers from Other Brand", "No Infinity Scroll Left for Offers from Other Brand found", 1);
						break;
					}
					if(i==5) {
						fUtil.flogResult("Failed", "Validate No Infinity Scroll Left for Offers from Other Brand", "No Infinity Scroll Left for Offers from Other Brand not found", 1);
						break;
					}
				}
			}else
				fUtil.flogResult("Failed", "Validate Scroll back to first Offer available", "Scrolling back to first Offer available not found",1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Scroll for Offers from Other Brand available", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To check contents present under Recommended offers for you
	@Test
	public void checkContentRecommendedOffers() throws Exception{
		try {
			Thread.sleep(5000);
			int contentNum=TDL_SLPElectronicsPage.get().electronicsRecOfferDesc.size();
			if(contentNum!=0) {
				fUtil.flogResult("Passed", "Validate Content Tiles under Recommended offers for you",contentNum+" Content Tiles present under Recommended offers for you", 1);
				for(int i=0;i<contentNum;i++) {
					fUtil.flogResult("Passed", "Validate Content Tiles under Recommended offers for you", "Content Tiles under Recommended offers for you: "+(i+1)+" present with Description: "
							+TDL_SLPElectronicsPage.get().electronicsRecOfferDesc.get(i).getText(), 1);
				}
				TDL_SLPElectronicsPage.get().electronicsRecOfferDesc.get(contentNum-1).click();
				fUtil.flogResult("Passed", "Validate Click on Last offer of Recommended offers for you", "Last offer of Recommended offers for you clicked", 1);
				validateSwitchToNewTab();
			}else
				fUtil.flogResult("Failed", "Validate Content Tiles under Recommended offers for you", "Content Tiles not present under Recommended offers for you", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate contents on Recommended offers for you widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To check contents present under Next best offer
	@Test
	public void checkContentNextbestoffer() throws Exception{
		try {
			Thread.sleep(5000);
			int contentNum=TDL_SLPElectronicsPage.get().electronicsNextBestOfferDesc.size();
			if(contentNum!=0) {
				fUtil.flogResult("Passed", "Validate Content Tiles under Next best offer",contentNum+" Content Tiles present under Next best offer", 1);
				for(int i=0;i<contentNum;i++) {
					fUtil.flogResult("Passed", "Validate Content Tiles under Next best offer", "Content Tiles under Next best offer: "+(i+1)+" present with Description: "
							+TDL_SLPElectronicsPage.get().electronicsNextBestOfferDesc.get(i).getText(), 1);
				}
				TDL_SLPElectronicsPage.get().electronicsNextBestOfferDesc.get(contentNum-1).click();
				fUtil.flogResult("Passed", "Validate Click on Last offer of Next best offer", "Last offer of Next best offer clicked", 1);
				validateSwitchToNewTab();
			}else
				fUtil.flogResult("Failed", "Validate Content Tiles under Next best offer", "Content Tiles not present under Next best offer", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate contents on Next best offer widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//To check contents present under Cross brand 2 offers from other brands
	@Test
	public void checkContentOffersOtherBrands() throws Exception{
		try {
			Thread.sleep(5000);
			int contentNum=TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsTiles.size();
			if(contentNum!=0) {
				fUtil.flogResult("Passed", "Validate Content Tiles under offers from other brands",contentNum+" Content Tiles present under offers from other brands", 1);
				//					for(int i=0;i<contentNum;i++) {
				//						fUtil.flogResult("Passed", "Validate Content Tiles under offers from other brands", "Content Tiles under offers from other brands: "+(i+1)+" present with Description: "
				//								+TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsDesc.get(i).getText(), 1);
				//					}
				TDL_SLPElectronicsPage.get().electronicsOfferOtherBrandsTiles.get(contentNum-1).click();
				fUtil.flogResult("Passed", "Validate Click on Last offer of offers from other brands", "Last offer of offers from other brands clicked", 1);
				validateSwitchToNewTab();
			}else
				fUtil.flogResult("Failed", "Validate Content Tiles under offers from other brands", "Content Tiles not present under offers from other brands", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate contents on offers from other brands widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}


	//revathi//Mar 05//

	//method to validate sneakpeak//
	@Test
	public void validateSneakpeakWidgetUI( ) throws Exception{
		try {
			String widgetEx = fUtil.fgetDataNew1("widget");
			String widgetTitleEx = fUtil.fgetDataNew1("widgetTitle");
			String SLPjourney = fUtil.fgetDataNew1("SLP");
			String widgetButton = fUtil.fgetDataNew1("Button");
			String widgetdescUI = fUtil.fgetDataNew1("WidDesc");
			validatewidgetPresent(TDL_SLPElectronicsPage.get().SneekPeakTitle,widgetEx,SLPjourney);
			clickWidget(TDL_SLPElectronicsPage.get().SneekPeakshopNow,TDL_SLPElectronicsPage.get().SneekPeakdesc,widgetEx,widgetButton,widgetdescUI);
			//fetchWidget(TDL_SLPElectronicsPage.get().ThemeselectTitle,widgetEx,widgetTitleEx);
			//selectWidget(TDL_SLPElectronicsPage.get().ThemeselectTitle,widgetEx,widgetTitleEx);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "sneak Peak widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}


	//to click a standalone widget//
	@Test
	public void clickWidget(WebElement widjetxpath,WebElement widjetdescxpath, String widget,String Button,String Widgetdesc) throws Exception{
		try {
			//gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().FeaturedOfferWidget);
			if(gmethods.isElementVisible(widjetxpath,5)) {
				String buttonUI= widjetxpath.getText().trim();
				String descUI = widjetdescxpath.getText().trim();
				if(buttonUI.equalsIgnoreCase(Button) && descUI.equalsIgnoreCase(Widgetdesc))
				{
					fUtil.flogResult("Passed"," validate button is" +Button, "validated button in UI is"+buttonUI+ "and description "+descUI ,1);
				}else
				{
					fUtil.flogResult("Failed"," validate button is" +Button, "validated button in UI is not"+buttonUI,1);
				}
				widjetxpath.click();
				fUtil.flogResult("Passed","click"+widget+"widget", "clicked"+widget+ "widget",1);



			}else {
				fUtil.flogResult("Failed","click"+widget+"widget", "Not clicked"+widget+ "widget",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "click"+widget+"widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}


	/* */

	//SLP electronics//Mar 08//

	@Test
	public void loginToAppTemp() throws Exception {
		try {
			String mobileNumber = fUtil.fgetDataNew1("Mobile_no");
			String password = fUtil.fgetDataNew1("Password");
			mobileNumber = mobileNumber.substring(1);
			gmethods.isElementVisible(TdlSignUp.get().signinButton,10);
			TdlSignUp.get().signinButton.click();
			gmethods.isElementVisible(TdlSignUp.get().mobileNoTextBox,10);
			TdlSignUp.get().mobileNoTextBox.sendKeys(mobileNumber);
			gmethods.isElementVisible(TdlSignUp.get().Confirmbutton,10);
			TdlSignUp.get().Confirmbutton.click();
			gmethods.isElementVisible(TdlSignUp.get().loginPasswordBox,10);
			TdlSignUp.get().loginPasswordBox.sendKeys(password);
			gmethods.isElementVisible(TdlSignUp.get().Continuebutton,10);
			TdlSignUp.get().Continuebutton.click();
			//gmethods.signInPwa(mobileNumber, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void NavigateSLPTemp() throws Exception {
		try {
			gmethods.isElementVisible(TDL_SLPElectronicsPage.get().profileOpt,10);
			TDL_SLPElectronicsPage.get().profileOpt.click();
			gmethods.isElementVisible(TDL_SLPElectronicsPage.get().SLPopt,10);
			//TDL_SLPElectronicsPage.get().profileOpt.click();
			TDL_SLPElectronicsPage.get().SLPopt.click();
			navigateSLPOptions();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void navigateSLPOptions() throws Exception {
		try {
			
			if(gmethods.isElementVisible(TdlCromaCard.get().offerCloseaftersignIn, 2)) {
				TdlCromaCard.get().offerCloseaftersignIn.click();
				System.out.println("Offers shown after signIn closed");
			}
			String SLPPage = fUtil.fgetDataNew1("SLP");
			switch (SLPPage) {
			case "Fitness":
				gmethods.isElementVisible(TDL_SLPElectronicsPage.get().SLPSports,10);
				TDL_SLPElectronicsPage.get().SLPSports.click();
				break;
			case "Beauty":
				gmethods.isElementVisible(TDL_SLPElectronicsPage.get().SLPBeauty,10);
				TDL_SLPElectronicsPage.get().SLPBeauty.click();
				break;
			case "Fashion":
				gmethods.isElementVisible(TDL_SLPElectronicsPage.get().SLPFashion,40);
				TDL_SLPElectronicsPage.get().SLPFashion.click();
				break;
			case "Electronics":
				gmethods.isElementVisible(TDL_SLPElectronicsPage.get().SLPElectronics,10);
				TDL_SLPElectronicsPage.get().SLPElectronics.click();
				break;
			case "Hotel":
				gmethods.isElementVisible(TDL_SLPElectronicsPage.get().SLPHotel,10);
				TDL_SLPElectronicsPage.get().SLPHotel.click();
				break;
			case "Essentials":
				gmethods.isElementVisible(TDL_SLPElectronicsPage.get().SLPEssentials,10);
				TDL_SLPElectronicsPage.get().SLPEssentials.click();
				break;
			case "Luxury":
				gmethods.isElementVisible(TDL_SLPElectronicsPage.get().SLPLuxury,10);
				TDL_SLPElectronicsPage.get().SLPLuxury.click();
				break;
			case "TataSky":
				gmethods.isElementVisible(TDL_SLPElectronicsPage.get().SLPTataSky,10);
				TDL_SLPElectronicsPage.get().SLPTataSky.click();
				break;
			default:
				fUtil.flogResult("Failed", "SLP options are not displayed", "No SLP option is provided", 0);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test

	public void switchcontext() throws Exception {
		try {
			gmethods.switchContextMobile("web");
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test

	public void switchcontextNative() throws Exception {
		try {
			gmethods.switchContextMobile("native");
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Test
	public void selectShopNowInSLP() throws Exception{
		try {
			String platformname=fUtil.fgetDataNew1("platform").trim();
			boolean titleHomepage=gmethods.isElementVisible(TdlCromaCard.get().electronics_slp_croma, 10);
			if(titleHomepage) {
				fUtil.flogResult("Passed","Validate SLP Electronics page loaded", "SLP Electronics homepage loaded with title: "+TDL_SLPElectronicsPage.get().electronics_title.getText()+" and search, cart option present",1);
			}else {
				fUtil.flogResult("Failed","Validate SLP Electronics page loaded", "SLP Electronics homepage not loaded properly",1);
			}

			if(gmethods.isElementVisible(TdlCromaCard.get().shop_now_button,40))
			{
				TdlCromaCard.get().shop_now_button.click();
				gmethods.switchToNewTab();
				fUtil.flogResult("Passed", "click Shop Now in SLP page", 
						"clicked Shop Now in SLP page",1);
			}
			else
			{
				fUtil.flogResult("Failed", "click Shop Now in SLP page", 
						"Shop Now btn not present",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "click a popular product in croma", 
					"Not click a popular product in croma failed due to:"+e.getMessage(), 1);
		}
	}

	/*
	 * //9-3 Sourav //To check contents present under Bundles you may like Widget
	 * 
	 * @Test public void checkContentBundlesWidget() throws Exception{ try {
	 * gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().essentialsBundles);
	 * fUtil.flogResult("Passed", "Validate Scroll to Bundles you may like Widget",
	 * "Scrolled successfully to Bundles you may like Widget", 1);
	 * Thread.sleep(2000); int
	 * contentNum=TDL_SLPElectronicsPage.get().essentialsBundlesDesc.size();
	 * if(contentNum!=0) { fUtil.flogResult("Passed",
	 * "Validate Content Tiles under Bundles you may like Widget"
	 * ,contentNum+" Content Tiles present under Bundles you may like Widget", 1);
	 * for(int i=0;i<contentNum;i++) { fUtil.flogResult("Passed",
	 * "Validate Content Tiles under Bundles you may like Widget",
	 * "Content Tiles under Bundles you may like Widget: "+(i+1)
	 * +" present with Description: "
	 * +TDL_SLPElectronicsPage.get().essentialsBundlesDesc.get(i).getText(), 1); }
	 * String journey=fUtil.fgetDataNew1("Journey"); String
	 * journeyTxt=TDL_SLPElectronicsPage.get().essentialsBundlesDesc.get(Integer.
	 * parseInt(journey)).getText();
	 * TDL_SLPElectronicsPage.get().essentialsBundlesDesc.get(Integer.parseInt(
	 * journey)).click();
	 * fUtil.flogResult("Passed","Validate Click on Journey: "+journeyTxt,
	 * "Clicked successfully Journey: "+journeyTxt,1); validateSwitchToNewTab();
	 * }else fUtil.flogResult("Failed",
	 * "Validate Content Tiles under Bundles you may like Widget",
	 * "Content Tiles not present under Bundles you may like Widget", 1); }catch
	 * (Exception e) { fUtil.flogResult("Failed",
	 * "Validate contents on Bundles you may like Widget",
	 * "Error occured: "+e.getMessage(), 1); e.printStackTrace(); throw e; } }
	 * 
	 * //To check contents present under All Category-1 Widget
	 * 
	 * @Test public void checkAllCategoryOneWidget() throws Exception{ try {
	 * gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().
	 * essentialsShopByCategory); fUtil.flogResult("Passed",
	 * "Validate Scroll to All Category-1 Widget",
	 * "Scrolled successfully to All Category-1 Widget", 1); Thread.sleep(2000); int
	 * contentNum=TDL_SLPElectronicsPage.get().essentialsCategoryOneDesc.size();
	 * if(contentNum!=0) { fUtil.flogResult("Passed",
	 * "Validate Content Tiles under All Category-1 Widget"
	 * ,contentNum+" Content Tiles present under All Category-1 Widget", 1); for(int
	 * i=0;i<contentNum;i++) { fUtil.flogResult("Passed",
	 * "Validate Content Tiles under All Category-1 Widget",
	 * "Content Tiles under All Category-1 Widget: "+(i+1)
	 * +" present with Description: "
	 * +TDL_SLPElectronicsPage.get().essentialsCategoryOneDesc.get(i).getText(), 1);
	 * } String journey=fUtil.fgetDataNew1("Journey"); String
	 * journeyTxt=TDL_SLPElectronicsPage.get().essentialsCategoryOneDesc.get(Integer
	 * .parseInt(journey)).getText();
	 * TDL_SLPElectronicsPage.get().essentialsCategoryOneDesc.get(Integer.parseInt(
	 * journey)).click();
	 * fUtil.flogResult("Passed","Validate Click on Journey: "+journeyTxt,
	 * "Clicked successfully Journey: "+journeyTxt,1); validateSwitchToNewTab();
	 * }else fUtil.flogResult("Failed",
	 * "Validate Content Tiles under  All Category-1 Widget",
	 * "Content Tiles not present under  All Category-1 Widget", 1); }catch
	 * (Exception e) { fUtil.flogResult("Failed",
	 * "Validate contents on All Category-1 Widget",
	 * "Error occured: "+e.getMessage(), 1); e.printStackTrace(); throw e; } }
	 * 
	 * //To check contents present under All Category-2 Widget
	 * 
	 * @Test public void checkAllCategoryTwoWidget() throws Exception{ try {
	 * gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().
	 * essentialsShopByCategory); fUtil.flogResult("Passed",
	 * "Validate Scroll to All Category-2 Widget",
	 * "Scrolled successfully to All Category-2 Widget", 1); Thread.sleep(2000); int
	 * contentNum=TDL_SLPElectronicsPage.get().essentialsCategoryTwoDesc.size();
	 * if(contentNum!=0) { fUtil.flogResult("Passed",
	 * "Validate Content Tiles under All Category-2 Widget"
	 * ,contentNum+" Content Tiles present under All Category-2 Widget", 1); for(int
	 * i=0;i<contentNum;i++) { fUtil.flogResult("Passed",
	 * "Validate Content Tiles under All Category-2 Widget",
	 * "Content Tiles under All Category-2 Widget: "+(i+1)
	 * +" present with Description: "
	 * +TDL_SLPElectronicsPage.get().essentialsCategoryTwoDesc.get(i).getText(), 1);
	 * } String journey=fUtil.fgetDataNew1("Journey"); String
	 * journeyTxt=TDL_SLPElectronicsPage.get().essentialsCategoryTwoDesc.get(Integer
	 * .parseInt(journey)).getText();
	 * TDL_SLPElectronicsPage.get().essentialsCategoryTwoDesc.get(Integer.parseInt(
	 * journey)).click();
	 * fUtil.flogResult("Passed","Validate Click on Journey: "+journeyTxt,
	 * "Clicked successfully Journey: "+journeyTxt,1); validateSwitchToNewTab();
	 * }else fUtil.flogResult("Failed",
	 * "Validate Content Tiles under  All Category-2 Widget",
	 * "Content Tiles not present under  All Category-2 Widget", 1); }catch
	 * (Exception e) { fUtil.flogResult("Failed",
	 * "Validate contents on All Category-1 Widget",
	 * "Error occured: "+e.getMessage(), 1); e.printStackTrace(); throw e; } }
	 * 
	 * 
	 * 
	 * @Test public void validateFeaturedOfferHotelWidgetUI( ) throws Exception{ try
	 * { String widgetEx = fUtil.fgetDataNew1("widget"); String widgetTitleEx =
	 * fUtil.fgetDataNew1("widgetTitle"); String SLPjourney =
	 * fUtil.fgetDataNew1("SLP");
	 * validatewidgetPresent(TDL_SLPElectronicsPage.get().FeaturedOffer,widgetEx,
	 * SLPjourney);
	 * fetchWidget(TDL_SLPElectronicsPage.get().FeaturedOffersList,widgetEx,
	 * widgetTitleEx);
	 * selectWidget(TDL_SLPElectronicsPage.get().FeaturedOffersList,widgetEx,
	 * widgetTitleEx); }catch (Exception e) { fUtil.flogResult("Failed",
	 * "Featured offer widget", "Error occured: "+e.getMessage(), 1);
	 * e.printStackTrace(); throw e; } }
	 * 
	 * 
	 * @Test public void validateInspiredOfferHotelWidgetUI( ) throws Exception{ try
	 * { String widgetEx = fUtil.fgetDataNew1("widget"); String widgetTitleEx =
	 * fUtil.fgetDataNew1("widgetTitle"); String SLPjourney =
	 * fUtil.fgetDataNew1("SLP");
	 * validatewidgetPresent(TDL_SLPElectronicsPage.get().Inspired,widgetEx,
	 * SLPjourney);
	 * fetchWidget(TDL_SLPElectronicsPage.get().InspiredList,widgetEx,widgetTitleEx)
	 * ;
	 * selectWidget(TDL_SLPElectronicsPage.get().InspiredList,widgetEx,widgetTitleEx
	 * ); }catch (Exception e) { fUtil.flogResult("Failed", "Inspired offer widget",
	 * "Error occured: "+e.getMessage(), 1); e.printStackTrace(); throw e; } }
	 * 
	 * 
	 * @Test public void validateHolidayOfferHotelWidgetUI( ) throws Exception{ try
	 * { String widgetEx = fUtil.fgetDataNew1("widget"); String widgetTitleEx =
	 * fUtil.fgetDataNew1("widgetTitle"); String SLPjourney =
	 * fUtil.fgetDataNew1("SLP");
	 * validatewidgetPresent(TDL_SLPElectronicsPage.get().HolidayPack,widgetEx,
	 * SLPjourney);
	 * fetchWidget(TDL_SLPElectronicsPage.get().HolidayList,widgetEx,widgetTitleEx);
	 * selectWidget(TDL_SLPElectronicsPage.get().HolidayList,widgetEx,widgetTitleEx)
	 * ; }catch (Exception e) { fUtil.flogResult("Failed", "Holiday offer widget",
	 * "Error occured: "+e.getMessage(), 1); e.printStackTrace(); throw e; } }
	 * 
	 * @Test public void validateEditorsOfferHotelWidgetUI( ) throws Exception{ try
	 * { String widgetEx = fUtil.fgetDataNew1("widget"); String widgetTitleEx =
	 * fUtil.fgetDataNew1("widgetTitle"); String SLPjourney =
	 * fUtil.fgetDataNew1("SLP");
	 * validatewidgetPresent(TDL_SLPElectronicsPage.get().Editorpicks,widgetEx,
	 * SLPjourney);
	 * fetchWidget(TDL_SLPElectronicsPage.get().editorList,widgetEx,widgetTitleEx);
	 * selectWidget(TDL_SLPElectronicsPage.get().editorList,widgetEx,widgetTitleEx);
	 * }catch (Exception e) { fUtil.flogResult("Failed", "Editor Offer widget",
	 * "Error occured: "+e.getMessage(), 1); e.printStackTrace(); throw e; } }
	 * 
	 * @Test public void validateRecommendOfferHotelWidgetUI( ) throws Exception{
	 * try { String widgetEx = fUtil.fgetDataNew1("widget"); String widgetTitleEx =
	 * fUtil.fgetDataNew1("widgetTitle"); String SLPjourney =
	 * fUtil.fgetDataNew1("SLP");
	 * validatewidgetPresent(TDL_SLPElectronicsPage.get().Recommendedstays,widgetEx,
	 * SLPjourney);
	 * fetchWidget(TDL_SLPElectronicsPage.get().RecommendList,widgetEx,widgetTitleEx
	 * ); selectWidget(TDL_SLPElectronicsPage.get().RecommendList,widgetEx,
	 * widgetTitleEx); }catch (Exception e) { fUtil.flogResult("Failed",
	 * "Recommend Offer widget", "Error occured: "+e.getMessage(), 1);
	 * e.printStackTrace(); throw e; } }
	 * 
	 * //sourav// //To check contents present under Content Widget - Recipes,hacks &
	 * more Widget
	 * 
	 * @Test public void checkContentContentRecipesWidget() throws Exception{ try {
	 * gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().
	 * essentialsContentRecepie); fUtil.flogResult("Passed",
	 * "Validate Scroll to Content Widget - Recipes,hacks & more Widget",
	 * "Scrolled successfully to Content Widget - Recipes,hacks & more Widget", 1);
	 * Thread.sleep(2000); int
	 * contentNum=TDL_SLPElectronicsPage.get().essentialsContentRecepieTitle.size();
	 * if(contentNum!=0) { fUtil.flogResult("Passed",
	 * "Validate Content Tiles under Content Widget - Recipes,hacks & more Widget"
	 * ,contentNum+" Content Tiles present under Content Widget - Recipes,hacks & more Widget"
	 * , 1); for(int i=0;i<contentNum;i++) { fUtil.flogResult("Passed",
	 * "Validate Content Tiles under Content Widget - Recipes,hacks & more Widget",
	 * "Content Tiles under Content Widget - Recipes,hacks & more Widget: "+(i+1)
	 * +" present with Title: "+TDL_SLPElectronicsPage.get().
	 * essentialsContentRecepieTitle.get(i).getText()+" Description: "
	 * +TDL_SLPElectronicsPage.get().essentialsContentRecepieDesc.get(i).getText(),
	 * 1); } String journey=fUtil.fgetDataNew1("Journey"); String
	 * journeyTxt=TDL_SLPElectronicsPage.get().essentialsContentRecepieTitle.get(
	 * Integer.parseInt(journey)).getText();
	 * TDL_SLPElectronicsPage.get().essentialsContentRecepieTitle.get(Integer.
	 * parseInt(journey)).click();
	 * fUtil.flogResult("Passed","Validate Click on Journey: "+journeyTxt,
	 * "Clicked successfully Journey: "+journeyTxt,1); validateSwitchToNewTab();
	 * }else fUtil.flogResult("Failed",
	 * "Validate Content Tiles under Content Widget - Recipes,hacks & more Widget",
	 * "Content Tiles not present under Bundles you may like Widget", 1); }catch
	 * (Exception e) { fUtil.flogResult("Failed",
	 * "Validate contents on Bundles you may like Widget",
	 * "Error occured: "+e.getMessage(), 1); e.printStackTrace(); throw e; } }
	 * 
	 * //10-3 Sourav
	 * 
	 * @Test public void validateElectronicsHeaderBack() throws Exception{ try {
	 * String oldTab = BrowserFactory.webDriver.get().getWindowHandle(); String
	 * oldTabTittle=BrowserFactory.webDriver.get().getTitle(); clickheroBanner();
	 * BrowserFactory.webDriver.get().switchTo().window(oldTab);
	 * if(BrowserFactory.webDriver.get().getTitle().equals(oldTabTittle))
	 * fUtil.flogResult("Passed",
	 * "Validate navigated back to SLP Electronics Page with title: "+oldTabTittle,
	 * "Navigated back to SLP Electronics Page with Title: "+oldTabTittle, 1); else
	 * fUtil.flogResult("Failed",
	 * "Validate navigated back to SLP Electronics Page with title: "+oldTabTittle,
	 * "Navigated back to SLP Electronics Page failed with Title: "+BrowserFactory.
	 * webDriver.get().getTitle(), 1); }catch (Exception e) {
	 * fUtil.flogResult("Failed", "Validate Electronics Header Back",
	 * "Error occured: "+e.getMessage(), 1); e.printStackTrace(); throw e; } }
	 * 
	 * 
	 * 
	 * //April 20 //
	 */
	@Test
	public void searchProduct() throws Exception{
		try{
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cromaSearchBox, 20))
			{
				fUtil.flogResult("Passed", "input search visibility", "input search is visible", 1);
				String productName=fUtil.fgetDataNew1("productName").trim();
				TDL_SLPElectronicsPage.get().cromaSearchBox.sendKeys(productName+Keys.ENTER);
				Thread.sleep(1000);
				//					TDL_SLPElectronicsPage.get().cromaSearchBox.click();
				//					Thread.sleep(1000);
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().firstsearchedoption, 10))
				{
					fUtil.flogResult("Passed", "Searched item:"+productName+" visbility", "Searched item:"+productName+" is visible", 1);
					//TDL_SLPElectronicsPage.get().firstsearchedoption.click();
				}
				else
				{
					fUtil.flogResult("Passed", "Searched item:"+productName+" is not visible", "Searched item:"+productName+" should visible", 1);
				}
			}
			else
			{
				fUtil.flogResult("Failed", "input search is not visible", "input search should visible", 1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	//User Loggedin croma
	@Test
	public void UserLoginCroma() throws Exception{
		try {
			Thread.sleep(8000);
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().LogedCroma,50))
			{
			fUtil.flogResult("Passed", "Validate User Auto Logged in", 
						"Validate USer Auto Logged in",1);
			}else{
				fUtil.flogResult("Failed", "Validate USer Auto Logged in", 
						"Validate USer not Auto Logged in",1);
			}
			clickPincodeCroma();

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Order Summary", 
					"Order Summary in croma failed due to:"+e.getMessage(), 1);
		}
	}

	//April 21
	//			@Test
	//			public void LoginWithPWADesktop() throws Exception {
	//				try {
	//					String Mobile_no=fUtil.fgetDataNew1("Mobile_no").trim();
	//					gmethods.loginPwaDesktop(Mobile_no);
	//				} catch (Exception ee) {
	//					fUtil.flogResult("Failed", "API Response Validation failed",
	//							"API Response failed due to business error" + ee.getMessage(), 0);
	//				}
	//			}

	//Click Buy now Croma page
	@Test
	public void clickBuyNowCroma() throws Exception{
		try {

			Thread.sleep(5000);
			Thread.sleep(5000);
			boolean BuyNow =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().BuyNowCroma,10);
			if(BuyNow == true)
			{
				TDL_SLPElectronicsPage.get().BuyNowCroma.click();
				fUtil.flogResult("Passed", "Click Buy now in croma page", 
						"Clicked Buy now in croma page successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Click Buy now in croma page", 
						"Not Clicked Buy now in croma page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click Buy now in croma page", 
					"Not Clicked Buy now in croma page failed due to:"+e.getMessage(), 1);
		}
	}

	//Click Pincode Croma page
	@Test
	public void clickPincodeCroma() throws Exception{
		try {
			boolean Pincode =gmethods.isElementVisible(TdlCromaCard.get().pincodeBox,10);
			if(Pincode == true)
			{
				String PincodeEx = fUtil.fgetDataNew1("Pincode");
				PincodeEx = PincodeEx.substring(1);
				TdlCromaCard.get().pincodeBox.clear();
				Thread.sleep(1000);
				TdlCromaCard.get().pincodeBox.sendKeys("400096");
				fUtil.flogResult("Passed", "Enter Pincode in croma page", 
						"Entered Pincode successfully",1);
				Thread.sleep(2000);
				TdlCromaCard.get().pincodeApplyBtn.click();
				fUtil.flogResult("Passed", "Apply Pincode in croma page", 
						"Applied Pincode successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Enter Pincode in croma page", 
						"Not Entered Pincode in croma page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Enter Pincode in croma page", 
					"Not Entered Pincode in croma page failed due to:"+e.getMessage(), 1);
		}
	}


	//Click Checkout Croma page
	@Test
	public void clickCheckoutCroma() throws Exception{
		try {
			Thread.sleep(8000);
			boolean checkout =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().checkoutAnd,25);
			if(checkout == true)
			{
			//	gmethods.isElementVisible(TdlCromaCard.get().zip_delivery_pm, 25);
			//	TdlCromaCard.get().zip_delivery_pm.click();

				gmethods.isElementVisible(TdlCromaCard.get().standardDeliveryCroma, 25);
				TdlCromaCard.get().standardDeliveryCroma.click();
				TDL_SLPElectronicsPage.get().checkoutAnd.click();
				fUtil.flogResult("Passed", "Click Checkout in croma page", 
						"Clicked Checkout in croma page successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Click Checkout in croma page", 
						"Not Clicked Checkout in croma page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click Checkout in croma page", 
					"Not Clicked Checkout in croma page failed due to:"+e.getMessage(), 1);
		}
	}

	//To add address for first time user and existing user in croma page
	@Test
	public void ValidateAddressCroma() throws Exception{
		try {


			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().shipAddress,30))						
			{ 
				AddressPageCroma();
				AddEmail();

			}
			else if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().chgAddress,30))
			{

				AddEmail();
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Order Summary", 
					"Order Summary in croma failed due to:"+e.getMessage(), 1);
		}
	}

	//Croma Login Android//
	@Test
	public void AddressPageCroma() throws Exception{
		try {
			String flat=fUtil.fgetDataNew1("Flat");
			String landmark=fUtil.fgetDataNew1("Landmark");
			String fname=fUtil.fgetDataNew1("Fname");
			String state =fUtil.fgetDataNew1("State");
			String city =fUtil.fgetDataNew1("City");

			boolean address =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().shipAddress,10);
			if(address == true)
			{

				TDL_SLPElectronicsPage.get().firstname.sendKeys(fname);
				fUtil.flogResult("Passed", "validate entering first name", 
						"Entered first name successfully",1);


				TDL_SLPElectronicsPage.get().flat.sendKeys(flat);
				fUtil.flogResult("Passed", "validate entering flat", 
						"Entered flat successfully",1);

				TDL_SLPElectronicsPage.get().Landmark.sendKeys(landmark);
				fUtil.flogResult("Passed", "validate entering landmark", 
						"Entered landmark successfully",1);

				TDL_SLPElectronicsPage.get().state.sendKeys(state);
				TDL_SLPElectronicsPage.get().statelist.click();
				fUtil.flogResult("Passed", "validate entering state", 
						"Entered state successfully",1);

				TDL_SLPElectronicsPage.get().city.sendKeys(city);
				TDL_SLPElectronicsPage.get().citylist.click();
				fUtil.flogResult("Passed", "validate entering city", 
						"Entered city successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "adding shipping details", 
						"Not added shipping details",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "adding shipping details", 
					"adding shipping details failed due to:"+e.getMessage(), 1);
		}
	}

	//Method to add Email Croma
	@Test
	public void AddEmail() throws Exception{
		try {
			String Email =fUtil.fgetDataNew1("Email");

			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().EmailAddressEdit,30))
			{ 
				String EmailUI = TDL_SLPElectronicsPage.get().EmailAddress.getText();
				if((EmailUI != null)  && (!EmailUI.isEmpty()) )
				{

					fUtil.flogResult("Passed", "Add Email", 
							"Added Email already",1);
				}

				else
				{
					TDL_SLPElectronicsPage.get().EmailAddress.clear();
					TDL_SLPElectronicsPage.get().EmailAddress.sendKeys(Email);
					fUtil.flogResult("Passed", "Add Email", 
							"Added Email",1);

				}
			}
			else
			{
				fUtil.flogResult("Failed", "Add Email in croma page", 
						"Not Added Emailin croma page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Add Email", 
					"Add Email in croma failed due to:"+e.getMessage(), 1);
		}
	}

	//Click select payment Croma page
	@Test
	public void clickselectPaymentCroma() throws Exception{
		try {
			Thread.sleep(8000);
			int i=1;
			
			while(!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().selectPayment,5)&&i<4) {
				gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().selectPayment);
				i++;	
			}
			boolean addressPresent =gmethods.isElementVisible(TdlCromaCard.get().deliveryAddressField,20);
			boolean btnPresent =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().selectPayment,20);
			if(btnPresent && addressPresent)
			{
				//TDL_SLPElectronicsPage.get().selectPayment.click();
				Actions action = new Actions(BrowserFactory.webDriver.get());
				action.moveToElement(TDL_SLPElectronicsPage.get().selectPayment).click().build().perform();
				fUtil.flogResult("Passed", "Click selectPayment in croma page", 
						"Clicked selectPayment in croma page successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Click selectPayment in croma page", 
						"Not Clicked selectPayment in croma page",1);
			}
			//Skip the payment offers in Croma Payments
			if (gmethods.isElementVisible(TdlCromaCard.get().skipPaymentOfferBtn,10)) {
				TdlCromaCard.get().skipPaymentOfferBtn.click();
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click selectPayment in croma page", 
					"Not Clicked selectPayment in croma page failed due to:"+e.getMessage(), 1);
		}
	}


	@Test
	public void clickTataPay() throws Exception{
		try {
		//	String Email =fUtil.fgetDataNew1("Email");
			//Thread.sleep(10000);
			switchToJuspayFrame();
			

			int i=1;
			while(!gmethods.isElementVisible(TdlCromaCard.get().TataPayOption,5)&&i<2) {
				gmethods.scrollToViewElement(TdlCromaCard.get().TataPayOption);
				i++;	
			}
			TdlCromaCard.get().TataPayOption.click();
			if(gmethods.isElementVisible(TdlCromaCard.get().TataPay,50))
			{ 
				TdlCromaCard.get().TataPay.click();
				fUtil.flogResult("Passed", "validate click ", 
						"Added Email",1);
				//BrowserFactory.webDriver.get().switchTo().defaultContent();
			}
			else
			{
				fUtil.flogResult("Failed", "Add Email in croma page", 
						"Not Added Emailin croma page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Add Email", 
					"Add Email in croma failed due to:"+e.getMessage(), 1);
		}
	}
	
	//To switch to Juspay frame
		@Test
		public void switchToJuspayFrame() throws Exception{
			try {
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().juspayIframe, 20)) {
					BrowserFactory.webDriver.get().switchTo().frame("juspay_iframe");
					System.out.println("Switched to Juspay Frame");
				}else
					System.out.println("No Juspay Frame present");
			}catch (Exception e) {
				fUtil.flogResult("Failed", "Validate Switch to Juspay frame", "Error occured: "+e.getMessage(), 1);
				e.printStackTrace();
				throw e;
			}
		}

	//Click payment//
	@Test
	public void ClickPaymentCroma() throws Exception{
		try {


			boolean pay =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().ProceedPay,10);
			if(pay == true)
			{
				TDL_SLPElectronicsPage.get().ProceedPay.click();
				fUtil.flogResult("Passed", "click pay in croma page", 
						"clicked pay in croma page successfully",1);
				BrowserFactory.webDriver.get().switchTo().defaultContent();
			}

			else
			{
				fUtil.flogResult("Failed", "click pay in croma page", 
						"Not clicked pay in croma page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "click pay in croma page", 
					"Not clicked pay in croma page failed due to:"+e.getMessage(), 1);
		}
	}

	//Method for TPM page Payments//
	@Test
	public void TPMpaymentmethod() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String LoyaltyPoints=fUtil.fgetDataNew1("Tcppoints_cutoff");

			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().PAymentMethod_TPM, 15)) {

				
                    if(gmethods.isElementVisible(TdlCromaCard.get().totalCartAmt,30)) {
					
					String totalTransactionAmount= TdlCromaCard.get().totalCartAmt.getText().replace("\u20B9","").trim();
					 totalCartAmount = DecimalFormat.getNumberInstance().parse(totalTransactionAmount).doubleValue();
					System.out.println(totalCartAmount);
					fUtil.flogResult("Passed", "Enter Payment Page Details in TPM  ", "Payment Page loaded in TPM successfully and Total Cart Amount is "+totalCartAmount, 1);

				}
                    
				
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().PAymentchangeTPM, 15)) {
					TDL_SLPElectronicsPage.get().PAymentchangeTPM.click();
					Thread.sleep(8000);
				}
				/*
				 * else if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().view_TPM,
				 * 15)) { TDL_SLPElectronicsPage.get().view_TPM.click(); }
				 */
				switch(paymentmethod.trim().toLowerCase()) {
				case "creditcard" :

					validateCreditCardPayment();
					break;

				case "debitcard" :
					validateDebitCardPayment();
					
					break;

				case "internetbanking" :
					validateInternetBanking();
					break;
				case "UPI" :

					validateUPI();

					break;

				case "Multitender" :
					validateLoyalty();
					clicKchange();
					validateInternetBanking();
					break;
				case "TCPPoints" :
					validateLoyalty();

					clickPay();
					break;

				default:

				{
					logger.info("Payment not selected in TPM");
					fUtil.flogResult("Failed", "Validate TPM payment ", "TPM payment not successful", 1);

				}

				}
			}
		}catch(Exception e){
			//e.printStackTrace();
			fUtil.flogResult("Failed", "Open Payment Page",
					"Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}

	// Method for Creditcard//
		@Test
		public void validateCreditCardPayment() throws Exception {
			try {
	 			String paymentType = fUtil.fgetDataNew1("payment_type");
	 			String brand=fUtil.fgetDataNew1("SLP");
	 			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cardsSelection, 10)) {
	 				TDL_SLPElectronicsPage.get().cardsSelection.click();
	 				Thread.sleep(5000);
	 				}
				if (gmethods.isElementVisible(TdlCromaCard.get().creditcard, 20)) {

					if (gmethods.isElementVisible(TdlCromaCard.get().creditCardRadioBtn, 20)) {
						 TdlCromaCard.get().creditCardRadioBtn.click();
						if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cvvCode, 10)) {
						//	BrowserFactory.webDriver.get().switchTo().frame(BrowserFactory.webDriver.get().findElement(By.xpath("//iframe[contains(@name,'security_code_iframe')]")));
						//	Thread.sleep(10000);
	//						
							//tdlPayBill.get().enter_CVV.click();
							TDL_SLPElectronicsPage.get().cvvCode.click();
							TDL_SLPElectronicsPage.get().cvvCode.sendKeys("123");
						//	BrowserFactory.webDriver.get().switchTo().defaultContent();
							Thread.sleep(5000);
							Thread.sleep(5000);
						}
					}

					if (paymentType.equalsIgnoreCase("Success")) {
						TDL_SLPElectronicsPage.get().payBtnnew.click();
						Thread.sleep(3000);
						//ClickRazorpayCroma();
						ClickAxisPasswordCroma();
						// TdlBPPayments_Mobile.get().successBtn_android.click();
						//Thread.sleep(10000);
						if(brand.contains("Electronics")) {
							orderCompletionCroma();
						}
						fUtil.flogResult("Passed", "Successfully completed payment using credit card",
								"Successfully completed payment using credit card ", 1);
					} else {
						TDL_SLPElectronicsPage.get().payBtnnew.click();
						TDL_SLPElectronicsPage.get().failPayment.click();
						Thread.sleep(3000);
						fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
								"Successfully completed payment on failure case using credit card", 1);
					}
				} else {
					fUtil.flogResult("Failed", "Validate Credit card payment", "Credit card payment failed", 1);
				}
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}

		// Method for Debitcard//
		@Test
		public void validateDebitCardPayment() throws Exception {
			try {
				String paymentType = fUtil.fgetDataNew1("payment_type");
				String brand=fUtil.fgetDataNew1("SLP");
				
				//scroll(300);
				if(!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cardsSelection,5)) {
 					scrollToBottom();
 				}
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cardsSelection, 20)) {
					TDL_SLPElectronicsPage.get().cardsSelection.click();
					Thread.sleep(5000);
					}
				if (gmethods.isElementVisible(TdlCromaCard.get().debitcard1, 20)) {
					if (gmethods.isElementVisible(TdlCromaCard.get().debitCardRadioBtn, 20)) {
						TdlCromaCard.get().debitCardRadioBtn.click();
						if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cvvCode, 10)) {
							//TDL_SLPElectronicsPage.get().cvvCode.click();
							//TDL_SLPElectronicsPage.get().cvvCode.sendKeys("123");
							//BrowserFactory.webDriver.get().switchTo().frame(0);
					//		BrowserFactory.webDriver.get().switchTo().frame(BrowserFactory.webDriver.get().findElement(By.xpath("//iframe[contains(@name,'security_code_iframe')]")));
					//		Thread.sleep(10000);
					         TDL_SLPElectronicsPage.get().cvvCode.click();
//								TDL_SLPElectronicsPage.get().cvvCode.click();
							TDL_SLPElectronicsPage.get().cvvCode.sendKeys("123");
					//		BrowserFactory.webDriver.get().switchTo().defaultContent();
							Thread.sleep(5000);
							Thread.sleep(5000);
						}
					}
					// TDL_SLPElectronicsPage.get().debitcard.click();

					if (paymentType.equalsIgnoreCase("Success")) {
						int i=1;
		 				while(!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().payBtnnew,5)&&i<3) {
		 					gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().payBtnnew);
		 					i++;	
		 				}
						TDL_SLPElectronicsPage.get().payBtnnew.click();
						Thread.sleep(3000);
						ClickRazorpayCroma();
						
						if(brand.contains("Electronics")) {
							orderCompletionCroma();
						}
						
						//ClickAxisPasswordCroma();
						//Thread.sleep(3000);
						fUtil.flogResult("Passed", "Successfully completed payment using Debit card",
								"Successfully completed payment using Debit card ", 1);
					}else {
						TDL_SLPElectronicsPage.get().payBtnnew.click();
						TDL_SLPElectronicsPage.get().failPayment.click();
						Thread.sleep(3000);
						fUtil.flogResult("Passed", "Successfully completed Failure payment Debit card using credit card",
								"Successfully completed payment on failure case using Debit card", 1);
					}
				} else {
					fUtil.flogResult("Failed", "Validate Debit card payment", "Debit card payment failed", 1);
				}
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}

		// Method for InternetBanking//
		@Test
		public void validateInternetBanking() throws Exception {
			try {
 				String paymentType = fUtil.fgetDataNew1("payment_type");
 				String brand=fUtil.fgetDataNew1("SLP");
 				int i=1;
 				while(!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().NetBanking_TPM,5)&&i<3) {
 					gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().NetBanking_TPM);
 					i++;	
 				}

				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().NetBanking_TPM, 15)) {
					TDL_SLPElectronicsPage.get().NetBanking_TPM.click();
					if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().netbanking_first_bank, 10)) {
						JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.webDriver.get();
						js.executeScript("arguments[0].click();", TDL_SLPElectronicsPage.get().netbanking_first_bank);
//							TDL_SLPElectronicsPage.get().netbanking_first_bank.click();
						Thread.sleep(3000);
						if (paymentType.equalsIgnoreCase("Success")) {
							if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().NetBankingSucces_TPM, 40)) {
								TDL_SLPElectronicsPage.get().NetBankingSucces_TPM.click();
								Thread.sleep(10000);
								if(brand.contains("Electronics")) {
									orderCompletionCroma();
								}
								fUtil.flogResult("Passed", "Successfully completed payment", "Successfully completed payment",
										1);
							}
							
						} else if (paymentType.equalsIgnoreCase("Abort")) {
							// String url = fUtil.fgetDataNew1("URL").trim();
							browserFactory.get().getDriver()
									.get("https://aem-sit-r2.tatadigital.com/payment/order-history");

							if (gmethods.isElementVisible(TdlOrderHistoryPage.get().order_tab, 20)) {
								logger.info("Navigated to Order History Page");
								fUtil.flogResult("Passed", "Navigate to Order History Page", "Navigated Succesfully", 1);
							}

							else {
								logger.info(
										"Order tab is not available as not navigation to Order History page is unsuccessfull");
								fUtil.flogResult("Failed", "Navigate to Order History Page", "Order tab is not identified",
										1);
							}
						} else {
							TDL_SLPElectronicsPage.get().failPayment.click();
							Thread.sleep(3000);
							fUtil.flogResult("Passed", "Successfully completed Failure payment",
									"Successfully completed payment on failure case", 1);
						}
					} else
						fUtil.flogResult("Failed", "Validate Internet Banking",
								"No banks available under Internet Banking failed", 1);
				} else
					fUtil.flogResult("Failed", "Validate Internet Banking", "Internet Banking failed", 1);
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}

		//Method for UPI payment//
		@Test
		public void validateUPI() throws Exception {
			try {
				String paymentType=fUtil.fgetDataNew1("payment_type");

				JavascriptExecutor jse1=(JavascriptExecutor)browserFactory.get().getDriver();
				WebElement shadowRoot=(WebElement)jse1.executeScript("return document.querySelector('#app > div.Flex__Box-gYjQok.hsKFna > div > section.sc-bxDcbH.jvTPEt > div:nth-child(2) > label > svg > g > g > g > path')");

				if(gmethods.isElementVisible(shadowRoot,20))
				{
					shadowRoot.click();
					if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().payBtn, 20)) {
						logger.info("upi pay btn is actvated");
						fUtil.flogResult("Passed", "pay btn",
								"activated, which is : "
										+ TDL_SLPElectronicsPage.get().payBtn.getText().trim(),
										1);
						TDL_SLPElectronicsPage.get().payBtn.click();
						fUtil.flogResult("Passed", "Validate payment successs in UPI",
								"Successfully completed payment  using UPI", 1);
					}
				}
				else
					fUtil.flogResult("Failed", "Validate UPI payment",
							"UPI payment failed", 1);
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}

		// Method for Loyalty//
		@Test
		public void validateLoyalty() throws Exception {
			try {
 	 			String LoyaltyPoints = fUtil.fgetDataNew1("Tcppoints_cutoff");
//					String paymentType=fUtil.fgetDataNew1("payment_type");
				Thread.sleep(10000);
				Thread.sleep(10000);
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().PAymentMethod_TPM, 15)) {

					
                    if(gmethods.isElementVisible(TdlCromaCard.get().totalCartAmt,30)) {
					
					String totalTransactionAmount= TdlCromaCard.get().totalCartAmt.getText().replace("\u20B9","").trim();
					 totalCartAmount = DecimalFormat.getNumberInstance().parse(totalTransactionAmount).doubleValue();
					System.out.println(totalCartAmount);
					fUtil.flogResult("Passed", "Enter Payment Page Details in TPM  ", "Payment Page loaded in TPM successfully and Total Cart Amount is "+totalCartAmount, 1);

				}
				} 
				if (gmethods.isElementVisible(TdlCromaCard.get().tcpPoints_checkbox, 30)) {
						clickUsingActionsClass(TdlCromaCard.get().tcpPoints_checkbox);
//						TDL_SLPElectronicsPage.get().tcpPoints_checkbox.click();
						Thread.sleep(1000);
						if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().edit_tcpPoints, 30)) {
						TDL_SLPElectronicsPage.get().edit_tcpPoints.click();
						fUtil.flogResult("Passed", "Edit Tcp Points page is present", "Edit Tcp Points page is present", 1);
						}
						Thread.sleep(4000);
						TDL_SLPElectronicsPage.get().tcpLoyalityAmount.click();
						Thread.sleep(4000);
						TDL_SLPElectronicsPage.get().tcpLoyalityAmount.clear();
						Thread.sleep(4000);
						TDL_SLPElectronicsPage.get().tcpLoyalityAmount.sendKeys(LoyaltyPoints);
						Thread.sleep(4000);
						TDL_SLPElectronicsPage.get().tcpLoyalitybutton.click();
						Thread.sleep(4000);
					} else
						fUtil.flogResult("Failed", "Validate TCP Point payment", "TCP Point payment failed", 1);
				
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}
		
		public void clickUsingJS(WebElement e) throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.webDriver.get();
			js.executeScript("arguments[0].click();", e);
		}

		public void clickUsingActionsClass(WebElement e) throws Exception {
			Actions action = new Actions(BrowserFactory.webDriver.get());
			action.moveToElement(e).click().build().perform();
		}
	@Test
	public void clickPay() throws Exception {
		try {

			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().payBtn,20))
			{
				TDL_SLPElectronicsPage.get().payBtn.click();
				fUtil.flogResult("Passed", "click pay in TPM page",
						"clicked pay in TPM page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "click pay in TPM page",
						"Not clicked pay in TPM page", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	//click change in TPM page//
	@Test
	public void clicKchange() throws Exception {
		try {

			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().PAymentchangeTPM,5))
			{
				TDL_SLPElectronicsPage.get().PAymentchangeTPM.click();
				fUtil.flogResult("Passed", "click pay in TPM page",
						"clicked pay in TPM page", 1);
			}
			/*
			 * else { fUtil.flogResult("Failed", "click pay in TPM page",
			 * "Not clicked pay in TPM page", 1); }
			 */
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}
	@Test
	public void orderCompletionCroma() throws Exception {
		try {
			if (gmethods.isElementVisible(TdlCromaCard.get().orderCompletionCroma, 40)) {
				String orderId=TdlCromaCard.get().cromaOrderId.getText();
				fUtil.flogResult("Passed", "Validate order completion page croma", "Navigated to order completion page in croma with Order ID: "+orderId, 1);
				
				if (orderId.startsWith("TC")) {
					fUtil.flogResult("Passed", "Validate Croma OrderId for Pilot customer", "OrderId:"+orderId+" is correct", 1);
				}else {
					fUtil.flogResult("Failed", "Validate Croma OrderId for Pilot customer", "OrderId:"+orderId+" is not correct", 1);
				}
			
			} else {
				fUtil.flogResult("Failed", "Validate order completion page croma", "Not Navigated to order completion page in croma", 1);
			}
			
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Croma page", "croma payment failed due to:" + e.getMessage(), 1);
		}
	}

	// Payment Success/Failure
	@Test
	public void ClickRazorpayCroma() throws Exception{

		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");
			if (paymentType.equalsIgnoreCase("Success")) {
				logger.info("Expected Payment Status is Success");
				if (gmethods.isElementVisible(tdlPayBill.get().pay_success, 30)) {
					logger.info(
							"RazorPay dummy page has been navigated successfully, Success button is also available for selection");
					fUtil.flogResult("Passed",
							"validating RazorPay dummy Page is displayed, Success Button :",
							"Available for Selection", 1);
					logger.info("Clicking on Success button for successful Payment");
					tdlPayBill.get().pay_success.click();
					Thread.sleep(10000);
					
					
				} else {
					logger.info(
							"RazorPay dummy page has not been navigated successfully, and Success button is alno not available for selection ");
					fUtil.flogResult("Failed", "RazorPay dummy Page, Success Button :",
							"Not available for Selection", 1);
				}

				//				gmethods.WaitForObject(tdlPayBill.get().payment_status_text);
				//				Thread.sleep(30000);
				//				if (gmethods.isElementVisible(tdlPayBill.get().payment_status, 20)) {
				//					logger.info("Payment Status page navigated successfully");
				//					fUtil.flogResult("Passed", "validating Payment Status Page is navigated",
				//							"navigated successfully", 1);
				//
				//					String payStatus = tdlPayBill.get().payment_status_text.getText().trim();
				//					System.out.println(payStatus);
				//					if (payStatus.equalsIgnoreCase("Payment Paid")) {
				//						logger.info(
				//								"Payment has been done successfully, Status message also displayed as expected");
				//						fUtil.flogResult("Passed", "validating Payment Status : ", payStatus, 1);
				//
				//					} else {
				//						logger.info("Payment has not been done successfully");
				//						fUtil.flogResult("Failed", "validating Payment Status : ", payStatus, 1);
				//					}
				//				} else {
				//					logger.info("Payment Status page not navigated successfully");
				//					fUtil.flogResult("Failed", "validating Payment Status Page is navigated or not",
				//							"not navigated successfully", 1);
				//				}

			} else if (paymentType.equalsIgnoreCase("Failure")) {
				logger.info("Expected Payment Status is Failure");
				if (gmethods.isElementVisible(tdlPayBill.get().pay_failure, 20)) {
					logger.info(
							"RazorPay dummy page has been navigated successfully, Failure button is also available for selection");
					fUtil.flogResult("Passed", "validating RazorPay dummy Page, Failure Button displayed :",
							"Available for Selection", 1);
					logger.info("Clicking on Failure button for Failed Payment");
					tdlPayBill.get().pay_failure.click();
				} else {
					logger.info(
							"RazorPay dummy page has not been navigated successfully, and Failure button is alno not available for selection ");
					fUtil.flogResult("Failed",
							"validating RazorPay dummy Page, Failure Button is displayed or not :",
							"Not available for Selection", 1);
				}
				Thread.sleep(3000);
				//				if (gmethods.isElementVisible(tdlPayBill.get().payment_status, 20)) {
				//					logger.info("Payment Status page navigated successfully");
				//					fUtil.flogResult("Passed", "validating Payment Status Page is navigated",
				//							"Navigated successfully", 1);
				//
				//					String payStatus = tdlPayBill.get().payment_status_text.getText().trim();
				//
				//					if (payStatus.equalsIgnoreCase("Payment Failed")) {
				//						logger.info("Payment Failure validated successfully");
				//						fUtil.flogResult("Passed", "validating Payment Status displayed as : ", payStatus,
				//								1);
				//					} else {
				//						logger.info("Payment Failure has not been done properly");
				//						fUtil.flogResult("Failed", "vlidating Payment Status : ", payStatus, 1);
				//					}
				//				} else {
				//					logger.info("Payment Status page not navigated successfully");
				//					fUtil.flogResult("Failed", "validating Payment Status Page",
				//							"Not navigated successfully", 1);
				//			}
			}
		}
		catch (Exception exe) {
			exe.printStackTrace();
		}
	}
	//Send password in Axis simulator page croma//
	@Test
	public void ClickAxisPasswordCromaOld() throws Exception{
		try {

		//	String Axis=fUtil.fgetDataNew1("Axis");
		//	Axis  = Axis.substring(1);
			boolean pay =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().Password,30);
			if(pay == true)
			{
				TDL_SLPElectronicsPage.get().Password.sendKeys("123456");
				fUtil.flogResult("Passed", "click pay in Axis simulator croma page", 
						"clicked pay in Axis simulator croma page successfully",1);
				TDL_SLPElectronicsPage.get().Pay.click();
			}
			else
			{
				//fUtil.flogResult("Failed", "click pay in Axis simulator croma page", 
				//		"Not clicked pay Axis simulator in croma page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "click pay in Axis simulator croma page", 
					"Not clicked pay in Axis simulator croma page failed due to:"+e.getMessage(), 1);
		}
	}
	
	@Test
	public void ClickAxisPasswordCroma() throws Exception {
		try {

			boolean pay = gmethods.isElementVisible(TDL_SLPElectronicsPage.get().Password, 20);
			if (pay == true) {
				TDL_SLPElectronicsPage.get().Password.sendKeys("123456");
				Thread.sleep(2000);
				TDL_SLPElectronicsPage.get().Pay.click();
				fUtil.flogResult("Passed", "click pay in Axis simulator croma page",
						"clicked pay in Axis simulator croma page successfully", 1);
				Thread.sleep(10000);
			} else if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().successPayment, 40)) {
				TDL_SLPElectronicsPage.get().successPayment.click();
				fUtil.flogResult("Passed", "click pay in Axis simulator croma page",
						"clicked pay in Axis simulator croma page successfully", 1);
			} else {
				fUtil.flogResult("Failed", "click pay in Axis simulator croma page",
						"Not clicked pay Axis simulator in croma page", 1);
			}
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			DateFormat dateformat = new SimpleDateFormat("dd/MM/yy | hh:mm aa");
			String currentTimeStamp = dateformat.format(timestamp);
			System.out.println("TimeStamp in Axis Simulator: " + currentTimeStamp);

		} catch (Exception e) {
			fUtil.flogResult("Failed", "click pay in Axis simulator croma page",
					"Not clicked pay in Axis simulator croma page failed due to:" + e.getMessage(), 1);
		}
	}


	//validate selecting product in croma
	@Test
	public void selectProduct() throws Exception{
		try {


			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().productCroma,30))
			{

				TDL_SLPElectronicsPage.get().productCroma.click();
				fUtil.flogResult("Passed", "click a popular product in croma page", 
						"clicked a popular product in cromae successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "click a popular product in croma page", 
						"Not clicked a popular product in croma page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "click a popular product in croma", 
					"Not click a popular product in croma failed due to:"+e.getMessage(), 1);
		}
	}

	@Test
	public void validateCreditlineWidgetUI( ) throws Exception{
		try {
			String widgetEx = fUtil.fgetDataNew1("widget");
			String widgetTitleEx = fUtil.fgetDataNew1("widgetTitle");
			String SLPjourney = fUtil.fgetDataNew1("SLP");
			validatewidgetPresent(TDL_SLPElectronicsPage.get().CrediLineWidget,widgetEx,SLPjourney);

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Recommend Offer widget", "Error occured: "+e.getMessage(), 1);
		}
	}

	@Test
	public void validateBirthdayWidgetInvisibility() throws Exception {
		try {
			if(!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().birthdaywidget, 10)) {
				fUtil.flogResult("Passed", "Validate Birthday Widget Invisibility", 
						"Birthday widget is not visible",1);
			}
			else {
				fUtil.flogResult("Failed", "Validate Birthday Widget Invisibility", 
						"Birthday widget is visible",1);
			}
		} catch (Exception ee) {
			fUtil.flogResult("Failed", "API Response Validation failed",
					"API Response failed due to business error" + ee.getMessage(), 0);
		}
	}

	//To scroll to Bundle Bonanza widget on Electronics homepage
	@Test
	public void scrollToBundleBonanazaWidget() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().bundleBonanza);
			fUtil.flogResult("Passed", "Validate Scroll to Bundle bonanza widget", "Scrolled to Bundle bonanza widget successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to Bundle bonanza widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void navigatetoBundlePage() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().bundletech, 10)) {
				TDL_SLPElectronicsPage.get().bundletechImage.click();
				fUtil.flogResult("Passed", "Validate bundle click",
						"Clicked on the available bundle successfully", 1);
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().bundlePage, 18)) {
					fUtil.flogResult("Passed", "Validate bundle page navigation",
							"Navigated to bundle page successfully", 1);	
				}
				else {
					fUtil.flogResult("Failed", "Validate bundle page navigation",
							"Didn't navigate to bundle page", 1);
				}
			}
			else {
				fUtil.flogResult("Failed", "Validate bundle click",
						"Bundle not visible", 1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate bundle page navigation", "Error occured: "+e.getMessage(), 1);

			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void LoginWithPWADesktopProd() throws Exception {
		try {
			

			BrowserFactory.webDriver.get().navigate().refresh();
			Thread.sleep(5000);
			String Mobile_no=fUtil.fgetDataNew1("Mobile_no").trim();
			loginPwaDesktop(Mobile_no);
			
		} catch (Exception ee) {
			fUtil.flogResult("Failed", "Login Validation failed",
					"Login failed due to error" + ee.getMessage(), 0);
		}
	}
	
	@Test
	public void LoginWithPWADesktop() throws Exception {
		try {
			

			BrowserFactory.webDriver.get().navigate().refresh();
			Thread.sleep(5000);
			String Mobile_no=fUtil.fgetDataNew1("Mobile_no").trim();
			gmethods.loginPwaDesktop(Mobile_no);
			
		} catch (Exception ee) {
			fUtil.flogResult("Failed", "API Response Validation failed",
					"API Response failed due to business error" + ee.getMessage(), 0);
		}
	}
	
	//Login With PWA Desktop 
	public void loginPwaDesktop(String mobileno) throws Exception {
		try {
 	 		String otp = "189723";
 	 		String loginToProd = fUtil.readInput("LoginToProd");

			if (mobileno.startsWith("~"))
				mobileno = mobileno.substring(1);

			if (gmethods.isElementVisible(TdlCromaCard.get().mobileNoTextBox, 20)) {
				TdlCromaCard.get().mobileNoTextBox.sendKeys(mobileno);
				
				//if (gmethods.isElementVisible(TdlCromaCard.get().WelComePopup, 10)) {
				//	TdlCromaCard.get().WelComePopup.click();;
				//}

				if (gmethods.isElementVisible(tcpHomePageMyAccount.get().confirmBtn, 10)) {
					tcpHomePageMyAccount.get().confirmBtn.click();

					if (gmethods.isElementVisible(TdlCromaCard.get().otpPageHdr, 10)) {
						Actions action = new Actions(browserFactory.get().getDriver());
						action.moveToElement(browserFactory.get().getDriver()
								.findElement(By.xpath("//input[@name='otp-input' and @type='number']")));

						System.out.println("=============================Enter Otp=========================");
						if(loginToProd.equalsIgnoreCase("Yes")) {
							System.out.println("=============================Enter Otp Manually=========================");
							Thread.sleep(20000);
						}else {
							TdlCromaCard.get().otpField.sendKeys(otp);
						}
                        if (gmethods.isElementVisible(Tdl_SSO.get().skipBtn, 10)) {
							logger.info("User Details page is present, hence skipping it");
							Tdl_SSO.get().skipBtn.click();
						}
                        if (gmethods.isElementVisible(tcpHomePageMyAccount.get().hamburgerMenuBtn, 20)) {
    						fUtil.flogResult("Passed", "HomePage Navigation",
    								"hamburgerMenuBtn present in Home Page, hence homePage navigated successfully", 1);
    						System.out.println("User Logged in successfully");
    					} else {
    						fUtil.flogResult("Failed", "hamburgerMenuBtn in Home Page",
    								"hamburgerMenuBtn present in Home Page", 1);
    					}					
                        } else {
						fUtil.flogResult("Failed", "Enter OTP", "OTP box not visible", 1);
					}
				} else {
					fUtil.flogResult("Failed", "Confirm Button in Mobile No. Page", "Confirm Button Not visible.", 1);
				}
			} else {
				fUtil.flogResult("Failed", "Mobile No. Text Box Visibility", "Mobile No. Text Box is not visible.", 1);
			}

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
		}
	}


	//April 22
	/*
	 * This method will perform Selecting Invoice data and navigate to payment page
	 * Invoice page
	 * 
	 */
	@Test
	public void validate_Invoice_page() throws Exception {
		try {

			if (gmethods.isElementVisible(tdlPayBill.get().Invoice_pg, 20)) {
				logger.info("navigated to Invoice page");

				if (gmethods.isElementVisible(tdlPayBill.get().Invoice_pg_order, 3)) {
					logger.info("Invoice page order is displayed");
					fUtil.flogResult("Passed", "validating Invoice page order displayed",
							tdlPayBill.get().Invoice_pg_order.getText().trim(), 1);

				} else {
					logger.info("Invoice page order is displayed");
					fUtil.flogResult("Failed", "Invoice page order displayed ", "Invoice page order not displayed", 1);

				}
				if (gmethods.isElementVisible(tdlPayBill.get().Invoice_pg_time, 3)) {
					logger.info("Invoice page time is displayed");
					fUtil.flogResult("Passed", "validating Invoice page time displayed",
							tdlPayBill.get().Invoice_pg_time.getText().trim(), 1);

				} else {
					logger.info("Invoice page time is displayed");
					fUtil.flogResult("Failed", "Invoice page time displayed ", "Invoice page time not displayed", 1);

				}
				int invoice_list_no = tdlPayBill.get().Invoice_list.size();
				for (int j = 0; j < invoice_list_no; j++)
					// int j=1;
				{
					logger.info("Invoice list");
					fUtil.flogResult("Passed", "Invoice list", "Available, Count : " + invoice_list_no, 1);

					if (gmethods.isElementVisible(tdlPayBill.get().Invoice_list.get(j), 20)) {
						logger.info("Invoice list is avialble");
						fUtil.flogResult("Passed", "validating Invoice list displayed",
								tdlPayBill.get().Invoice_list.get(j).getText().trim(), 1);

					} else {
						logger.info("Invoice details not  displayed");
						fUtil.flogResult("Failed", "Invoice details", "Invoice details not clicked", 1);
					}
				}

				if (gmethods.isElementVisible(tdlPayBill.get().net_check_amount, 3)) {

					String netchckAmount = tdlPayBill.get().net_check_amount.getText();

					netchckAmount = netchckAmount.substring(1);
					logger.info("Invoice page amount is displayed");
					fUtil.flogResult("Passed", "validating Invoice page amount is displayed", netchckAmount, 1);

				} else {
					logger.info("Invoice page amount  is displayed");
					fUtil.flogResult("Failed", "Invoice page amount is displayed or not ",
							"Invoice page amount  not displayed", 1);

				}
				if (gmethods.isElementVisible(tdlPayBill.get().invoice_pay_button, 3)) {
					logger.info("clicked pay button");
					tdlPayBill.get().invoice_pay_button.click();
					fUtil.flogResult("Passed", "validating pay button is clicked or not", "clicked pay button", 1);

				} else {
					logger.info("click pay button");
					fUtil.flogResult("Failed", "click pay button ", "Not clicked pay button", 1);

				}

			}
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}


	@Test
	public void connectTowebfromWeb() throws Exception {
		try {
			String url=fUtil.fgetDataNew1("URL1").trim();
			//browserFactory.get().getDriver().close();
			//Thread.sleep(6000);
			browserFactory.get().getDriver().get(url);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	/*
	 * validation of payment status
	 * 
	 */
	@Test
	public void payment_status() throws Exception {
		try {
			Thread.sleep(10000);
			String paymentType=readData("payment_type");
			String paymentmode=readData("Multitender");
			String paymentmethod=readData("payment_method").trim();
			switch (paymentType) {
			case "Success":

				String[] Transaction = TDL_SLPElectronicsPage.get().success_Transaction.getText().trim().split(":");
				TransactionID = Transaction[1];
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().success_sumary, 10))
				{
					logger.info("Transaction id is displayed");
					fUtil.flogResult("Passed","validate transaction details", "Transaction id : "+TransactionID + TDL_SLPElectronicsPage.get().success_sumary.getText() , 1);
				} else {
					logger.info("Transaction id is displayed");
					fUtil.flogResult("Failed", "Transaction id ", "transaction id not displayed", 1);
				}

				//				while(!gmethods.isElementVisible(TdlCromaCard.get().track_order_pm,5)) {
				//					gmethods.scrollToViewElement(TdlCromaCard.get().track_order_pm);
				//				}
				gmethods.scroll_web(TdlCromaCard.get().track_order_pm);

				gmethods.isElementVisible(TdlCromaCard.get().payment_icon,25);
				TdlCromaCard.get().payment_icon.click();

	 			if(paymentmode.equalsIgnoreCase("Multitender_loyaltypoints") | paymentmethod.equalsIgnoreCase("TcpPoints")) {
					gmethods.isElementVisible(TdlCromaCard.get().point_used_croma_pm,30);
					tcpPoints=TdlCromaCard.get().point_used_croma_pm.getText();
					pointsUsed=Double.parseDouble(tcpPoints);
					
					gmethods.isElementVisible(TdlCromaCard.get().amountPaidByEligibleTender,20);
					TotalpaidAmount=TdlCromaCard.get().amountPaidByEligibleTender.getText().replace("\u20B9", "").trim().replace(",", "").trim();
					
					gmethods.isElementVisible(TdlCromaCard.get().total_paid_amount,20);
					String TotalpaidAmount1=TdlCromaCard.get().total_paid_amount.getText().replace("\u20B9", "").trim().replace(",", "").trim();
					totalCartAmount=Double.parseDouble(TotalpaidAmount1);
					
				}
				else {
					gmethods.isElementVisible(TdlCromaCard.get().total_paid_amount,20);
					String TotalpaidAmount1=TdlCromaCard.get().total_paid_amount.getText().replace("\u20B9", "").trim().replace(",", "").trim();
					totalCartAmount=Double.parseDouble(TotalpaidAmount1);
					}
				break;

			case "Failure":
				String[] Transaction1 = TDL_SLPElectronicsPage.get().success_Transaction.getText().trim().split(":");
				TransactionID = Transaction1[1];
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().success_sumary, 10))
				{
					logger.info("Transaction id is displayed");
					fUtil.flogResult("Passed","validate transaction details", "Transaction id : "+TransactionID + "Transaction time" +TDL_SLPElectronicsPage.get().success_sumary.getText(), 1);
					//TDL_SLPElectronicsPage.get().GoToHomePAge.click();
				} else {
					logger.info("Transaction id is displayed");
					fUtil.flogResult("Failed", "Transaction id ", "transaction id not displayed", 1);

				}
				while(!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().payment_icon,5)) {
					gmethods.scroll_web(TDL_SLPElectronicsPage.get().payment_icon);
				}
				TDL_SLPElectronicsPage.get().payment_icon.click();
				gmethods.isElementVisible(TDL_SLPElectronicsPage.get().total_paid_amount,20);
				String TotalpaidAmount1=TdlCromaCard.get().total_paid_amount.getText().replace("\u20B9", "").trim();
				totalCartAmount=Double.parseDouble(TotalpaidAmount1);
				logger.info("status not fetched");
				fUtil.flogResult("Passed", "status not fetched ", "status not fetched", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void expectedPointsEarnCromaSingleMultiEligibleTender() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method").trim();
			String purchasetype = readData("purchase_type").trim();
			String paymentmode=readData("Multitender").trim();

			double amount=0.0;
			switch(paymentmethod.toLowerCase()) {
			case "debitcard":
				double cardAmt = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(cardAmt);
				amount = cardAmt;
				break;

			case "creditcard":
				double cardAmt1 = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(cardAmt1);
				amount = cardAmt1;
				break;

			case "internetbanking":
				double netBankAmt = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(netBankAmt);
				amount =netBankAmt;
				break;
			}

			if(purchasetype.equalsIgnoreCase("Gift Card") | paymentmethod.equalsIgnoreCase("TcpPoints")) {
				expectedEarnPromisedPoints=0.0;
				fUtil.flogResult("Passed", "Calculated Earn Points for Tender as "+paymentmethod, "Expected earn points is:" + expectedEarnPromisedPoints,
						1);
			}

			else if(paymentmode.equalsIgnoreCase("Multitender_loyaltypoints")){
				pointsUsed = Double.parseDouble(tcpPoints);
				double expectedPoints = (amount)*0.0033;
				expectedEarnPromisedPoints = Math.round(expectedPoints);
				fUtil.flogResult("Passed", "Calculated Earn Points for Tender as "+paymentmethod, "Expected earn points is:" + expectedEarnPromisedPoints,
						1);
			}

			else{
				double expectedPoints = amount*0.0033;
				expectedEarnPromisedPoints = Math.round(expectedPoints);
				fUtil.flogResult("Passed", "Calculated Earn Points for Tender as "+paymentmethod, "Expected earn points is:" + expectedEarnPromisedPoints,
						1);	
			}

		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	

	//To click on search button and search product and click on product
	@Test
	public void clickSearchButtonCliq() throws Exception{
		try {
			String productid=fUtil.fgetDataNew1("Product_Id");
			if(gmethods.isElementVisible(TdlCromaCard.get().searchButtonCliq, 30)) {
				TdlCromaCard.get().searchButtonCliq.click();
				Thread.sleep(5000);
				if(gmethods.isElementVisible(TdlCromaCard.get().searchButtonCliq, 30)) {
					TdlCromaCard.get().searchButtonCliq.sendKeys(productid);
					TdlCromaCard.get().searchButtonCliq.sendKeys(Keys.ENTER);
					//									if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchResultCliq,20)) {
					//										fUtil.flogResult("Passed","Validate Product found", "Product: "+"mp000000006917444"+"found successfully", 1);
					//										TDL_SLPElectronicsPage.get().searchResultCliq.click();
					//									}
				}
			}else {
				fUtil.flogResult("Failed", "Validate Search button on TATA Cliq", "Search button on TATA Cliq not found", 1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	//validate selecting product in TataCliq
	@Test
	public void selectProductCliq() throws Exception{
		try {

			//BrowserFactory.webDriver.get().switchTo().frame(0);
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().productCliq,30))
			{
				Thread.sleep(5000);
				Thread.sleep(5000);
				Actions action =new Actions(BrowserFactory.webDriver.get());
				action.moveToElement(TDL_SLPElectronicsPage.get().productCliq).click().build().perform();

				fUtil.flogResult("Passed", "click a popular product in cliq page", 
						"clicked a popular product in cliq successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "click a popular product in cliq page", 
						"Not clicked a popular product in Cliq page",1);
			}
			parentWindow = BrowserFactory.webDriver.get().getWindowHandle();
		}catch(Exception e) {
			fUtil.flogResult("Failed", "click a popular product in cliq", 
					"Not click a popular product in cliq failed due to:"+e.getMessage(), 1);
		}
	}


	//Click Buy now TataCliq page
	@Test
	public void clickBuyNowCliq() throws Exception{
		try {

			Thread.sleep(5000);
			Thread.sleep(5000);
			boolean BuyNow =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().buyNowCliq,10);
			if(BuyNow == true)
			{
				TDL_SLPElectronicsPage.get().buyNowCliq.click();
				fUtil.flogResult("Passed", "Click Buy now in cliq page", 
						"Clicked Buy now in cliq page successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Click Buy now in cliq page", 
						"Not Clicked Buy now in cliq page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click Buy now in croma page", 
					"Not Clicked Buy now in croma page failed due to:"+e.getMessage(), 1);
		}
	}



	//Cliq Address page//
	@Test
	public void AddressPageCliq() throws Exception{
		try {
			String flat=fUtil.fgetDataNew1("Flat");
			String landmark=fUtil.fgetDataNew1("Landmark");
			String fname=fUtil.fgetDataNew1("Fname");
			String state =fUtil.fgetDataNew1("State");
			String city =fUtil.fgetDataNew1("City");
			String address =fUtil.fgetDataNew1("address");
			String number =fUtil.fgetDataNew1("number");

			boolean address1 =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().fnameCliq,10);
			if(address1 == true)
			{

				TDL_SLPElectronicsPage.get().fnameCliq.sendKeys(fname);
				fUtil.flogResult("Passed", "validate entering first name", 
						"Entered first name successfully",1);


				TDL_SLPElectronicsPage.get().LnameCliq.sendKeys(flat);
				fUtil.flogResult("Passed", "validate entering flat", 
						"Entered flat successfully",1);

				TDL_SLPElectronicsPage.get().pincodeCliq.sendKeys(landmark);
				fUtil.flogResult("Passed", "validate entering landmark", 
						"Entered landmark successfully",1);

				TDL_SLPElectronicsPage.get().addressCliq.sendKeys(address);
				//TDL_SLPElectronicsPage.get().statelist.click();
				fUtil.flogResult("Passed", "validate entering address", 
						"Entered address successfully",1);

				TDL_SLPElectronicsPage.get().phoneNumberCliq.sendKeys(number);
				//TDL_SLPElectronicsPage.get().citylist.click();
				fUtil.flogResult("Passed", "validate entering number", 
						"Entered number successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "adding shipping details", 
						"Not added shipping details",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "adding shipping details", 
					"adding shipping details failed due to:"+e.getMessage(), 1);
		}
	}


	//Click ask me later Cliq page
	@Test
	public void askMeLaterCliq_pm() throws Exception{
		try {
			Thread.sleep(5000);
			Thread.sleep(5000);
			gmethods.switchToNewTab();
			boolean checkout =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().laterCliq,10);
			if(checkout == true)
			{
				TDL_SLPElectronicsPage.get().laterCliq.click();
				fUtil.flogResult("Passed", "Click ask later in cliq page", 
						"Clicked ask later in cliq page successfully",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click ask latert in cliq page", 
					"Not Clicked ask latert in cliqa page failed due to:"+e.getMessage(), 1);
		}
	}

	//Click Checkout Cliq page
	@Test
	public void clickSaveContnueCliq() throws Exception{
		try {
			Thread.sleep(5000);
			Thread.sleep(5000);

			boolean checkout =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().savecontCliq,10);
			if(checkout == true)
			{
				TDL_SLPElectronicsPage.get().savecontCliq.click();
				fUtil.flogResult("Passed", "Click save and continue Cliq in cliq page", 
						"Clicked save and continue in cliq page successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Click save and continue in cliq page", 
						"Not Clicked save and continue in cliq page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click save and continue in cliq page", 
					"Not Clicked save and continue in cliqa page failed due to:"+e.getMessage(), 1);
		}
	}

	//Click Checkout Cliq page
	@Test
	public void clickContnueCliq() throws Exception{
		try {
			//Thread.sleep(5000);
			//Thread.sleep(5000);

			boolean cont =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().contCliq,20);
			if(cont == true)
			{
				TDL_SLPElectronicsPage.get().contCliq.click();
				fUtil.flogResult("Passed", "Click  continue Cliq in cliq page", 
						"Clicked  continue in cliq page successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Click  continue in cliq page", 
						"Not Clicked continue in cliq page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click  continue in cliq page", 
					"Not Clicked continue in cliqa page failed due to:"+e.getMessage(), 1);
		}
	}

	@Test
	public void TPMCliq() throws Exception {
		try {

			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String LoyaltyPoints=fUtil.fgetDataNew1("Tcppoints_cutoff");
			
			if(gmethods.isElementVisible(TdlCromaCard.get().paymentMethodHdr, 40)) {
				fUtil.flogResult("Passed", "Payment Method Page Details in Tata cliq  ", "Payment Method Page loaded in tatacliq", 1);
				try {
					String shipCharge=TDL_SLPElectronicsPage.get().shippingCliq.getText().replace("\u20B9" , " ").trim();
					shippingCharge=Double.parseDouble(shipCharge);
				} catch (Exception e) {
					System.out.println("Shipping Charge not present or failed to get shipping amount due to:"+e);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().tataPayRadioBtn, 15)) {
					TdlCromaCard.get().tataPayRadioBtn.click();
					Thread.sleep(1000);
					TdlCromaCard.get().continueBtnTataPay.click();
					
				} 
			}else {
				fUtil.flogResult("Failed", "Payment Method Page Details in Tata cliq  ", "Payment Method Page is not loaded in tatacliq", 1);
			}
		}catch(Exception e){
			//e.printStackTrace();
			fUtil.flogResult("Failed", "Open Payment Page",
					"Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}
	
	@Test
	public void TPMCliqLuxury() throws Exception {
		try {

			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String LoyaltyPoints=fUtil.fgetDataNew1("Tcppoints_cutoff");
			
			if(gmethods.isElementVisible(TdlCromaCard.get().paymentMethodHdr, 40)) {
				fUtil.flogResult("Passed", "Payment Method Page Details in Tata cliq  ", "Payment Method Page loaded in tatacliq", 1);
				try {
					String shipCharge=TDL_SLPElectronicsPage.get().shippingCliq.getText().replace("\u20B9" , " ").trim();
					shippingCharge=Double.parseDouble(shipCharge);
				} catch (Exception e) {
					System.out.println("Shipping Charge not present or failed to get shipping amount due to:"+e);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().tataPayRadioBtnCliqLuxury, 15)) {
					TdlCromaCard.get().tataPayRadioBtnCliqLuxury.click();
					Thread.sleep(1000);
					TdlCromaCard.get().paydebCliqluxury.click();
					
				} 
			}else {
				fUtil.flogResult("Failed", "Payment Method Page Details in Tata cliq  ", "Payment Method Page is not loaded in tatacliq", 1);
			}
		}catch(Exception e){
			//e.printStackTrace();
			fUtil.flogResult("Failed", "Open Payment Page",
					"Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}

	//Method for Tata cliq page Payments//
	@Test
	public void TPMpaymentmethodCliq() throws Exception {
		try {

			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String LoyaltyPoints=fUtil.fgetDataNew1("Tcppoints_cutoff");
			
			if(gmethods.isElementVisible(TdlCromaCard.get().paymentMethodHdr, 15)) {

				fUtil.flogResult("Passed", "Payment Method Page Details in Tata cliq  ", "Payment Method Page loaded in tatacliq successfully", 1);

				//								if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().PAymentchangeTPM, 15)) {
				//									TDL_SLPElectronicsPage.get().PAymentchangeTPM.click();
				//								}
				//								else if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().view_TPM, 15))
				//								{
				//									TDL_SLPElectronicsPage.get().view_TPM.click();
				//								}
				
				switch(paymentmethod.trim().toLowerCase()) {
				case "creditcard" :

					validateCreditCardPaymentCliq();
					break;

				case "debitcard" :
					validateDebitCardPaymentCliq();
					break;

				case "internetbanking" :
					validateInternetBankingCliq();
					break;
				case "upi" :
					validateUPI();
					break;
				case "multitender" :
					validateLoyaltycliq();
					//clicKchange();
					validateInternetBankingCliq();
					break;
				case "tcppoints" :
					validateLoyaltycliq();
					break;

				case "emi" :
					validateEMIPaymentCliq();
					break;

				default:

				{
					logger.info("Payment not selected in TPM");
					fUtil.flogResult("Failed", "Validate TPM payment ", "TPM payment not successful", 1);

				}

				}
			}else {
				fUtil.flogResult("Failed", "Payment Method Page Details in Tata cliq  ", "Payment Method Page is not loaded in tatacliq", 1);
			}
		}catch(Exception e){
			//e.printStackTrace();
			fUtil.flogResult("Failed", "Open Payment Page",
					"Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}

	//Method for Creditcard//
	@Test
	public void validateCreditCardPaymentCliq() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String cardNumber=fUtil.fgetDataNew1("cardNumber");
			cardNumber = cardNumber.substring(1);
			String cardName=fUtil.fgetDataNew1("cardName");
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().creditCliq,20))
			{
				Thread.sleep(5000);
				Thread.sleep(5000);
				TDL_SLPElectronicsPage.get().creditarrowCliq.click();
				Thread.sleep(5000);
				TDL_SLPElectronicsPage.get().creditnumberCliq.sendKeys(cardNumber);
				TDL_SLPElectronicsPage.get().expirymonthCliq.click();
				TDL_SLPElectronicsPage.get().expirymonthCliq.sendKeys(Keys.ARROW_DOWN);
				TDL_SLPElectronicsPage.get().expirymonthCliq.sendKeys(Keys.ENTER);
				TDL_SLPElectronicsPage.get().expiryyearCliq.click();
				TDL_SLPElectronicsPage.get().expiryyearCliq.sendKeys(Keys.ARROW_DOWN);
				TDL_SLPElectronicsPage.get().expiryyearCliq.sendKeys(Keys.ARROW_DOWN);
				TDL_SLPElectronicsPage.get().expiryyearCliq.sendKeys(Keys.ENTER);
				TDL_SLPElectronicsPage.get().cardnameCliq.sendKeys(cardName);
				TDL_SLPElectronicsPage.get().cvvCliq.sendKeys("123");
				Thread.sleep(5000);
				Thread.sleep(5000);
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().payCliq,20))
				{
					Actions action =new Actions(BrowserFactory.webDriver.get());
					action.moveToElement(TDL_SLPElectronicsPage.get().payCliq).click().build().perform();
					//TDL_SLPElectronicsPage.get().payCliq.click();
					Thread.sleep(5000);
					Thread.sleep(5000);
				}
				if(paymentType.equalsIgnoreCase("Success"))
				{
					ClickAxisPasswordCroma();
					//TdlBPPayments_Mobile.get().successBtn_android.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed payment using credit card",
							"Successfully completed payment using credit card ", 1);
				}
				else
				{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
						"Successfully completed payment on failure case using credit card", 1);
				}
			}
			else
			{
				fUtil.flogResult("Failed", "Validate Credit card payment",
						"Credit card payment failed", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	//Method for Creditcard//
	@Test
	public void validateCreditCardPaymentCliqPM() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String cardNumber=fUtil.fgetDataNew1("cardNumber");
			cardNumber = cardNumber.substring(1);
			String cardName=fUtil.fgetDataNew1("cardName");
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().creditCliq,40))
			{
				TDL_SLPElectronicsPage.get().creditCliq.click();
				Thread.sleep(5000);
				TDL_SLPElectronicsPage.get().creditnumberCliq.sendKeys(cardNumber);

				Thread.sleep(5000);
				Select sel = new Select(TDL_SLPElectronicsPage.get().expirymonthCliq);
				Thread.sleep(5000);
				sel.selectByValue("5");


				Thread.sleep(5000);
				Select sel1 = new Select(TDL_SLPElectronicsPage.get().expiryyearCliq);
				Thread.sleep(5000);
				sel1.selectByValue("2025");

				TDL_SLPElectronicsPage.get().cardnameCliq.sendKeys(cardName);
				TDL_SLPElectronicsPage.get().cvvCliq.sendKeys("123");
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().paydebCliq,40))
				{
					TDL_SLPElectronicsPage.get().paydebCliq.click();
				}
				if(paymentType.equalsIgnoreCase("Success"))
				{
					ClickAxisPasswordCroma();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed payment using credit card",
							"Successfully completed payment using credit card ", 1);
				}
				else
				{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
						"Successfully completed payment on failure case using credit card", 1);
				}
			}
			else
			{
				fUtil.flogResult("Failed", "Validate Credit card payment",
						"Credit card payment failed", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void validateDebitCardPaymentCliq() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String cardNumber=fUtil.fgetDataNew1("cardNumber");
			String cardName=fUtil.fgetDataNew1("cardName");
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().debitCliq,20))
			{
				TDL_SLPElectronicsPage.get().debitarrowCliq.click();
				TDL_SLPElectronicsPage.get().debittnumberCliq.sendKeys(cardNumber);
				TDL_SLPElectronicsPage.get().expirymonthdebCliq.click();
				TDL_SLPElectronicsPage.get().expirymonthdebCliq.sendKeys(Keys.ARROW_DOWN);
				TDL_SLPElectronicsPage.get().expirymonthdebCliq.sendKeys(Keys.ENTER);
				TDL_SLPElectronicsPage.get().expiryyeardebCliq.click();
				TDL_SLPElectronicsPage.get().expiryyeardebCliq.sendKeys(Keys.ARROW_DOWN);
				TDL_SLPElectronicsPage.get().expiryyeardebCliq.sendKeys(Keys.ENTER);
				TDL_SLPElectronicsPage.get().cardnamedebCliq.sendKeys(cardName);
				TDL_SLPElectronicsPage.get().cvvdebCliq.sendKeys("123");
				TDL_SLPElectronicsPage.get().paydebCliq.click();
 				if(paymentType.equalsIgnoreCase("Success"))
				{
					if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().carddetailsCliq, 20)) {
						TDL_SLPElectronicsPage.get().cardnumberCliq.sendKeys(cardNumber);
						TDL_SLPElectronicsPage.get().expiryCliq.sendKeys("0525");
						TDL_SLPElectronicsPage.get().cardmembernameCliq.sendKeys(cardName);
						TDL_SLPElectronicsPage.get().cvvnumberCliq.sendKeys("123");
						TDL_SLPElectronicsPage.get().proceedCLiq.click();
						
						boolean pay =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().Password,30);
						if(pay == true)
						{
							TDL_SLPElectronicsPage.get().Password.sendKeys("123456");
							fUtil.flogResult("Passed", "click pay in Axis simulator croma page", 
									"clicked pay in Axis simulator croma page successfully",1);
							TDL_SLPElectronicsPage.get().Pay.click();
						}
						
					}
					else {
						ClickAxisPasswordCroma();
					}
				//	ClickAxisPasswordCroma();
					//TdlBPPayments_Mobile.get().successBtn_android.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed payment using credit card",
							"Successfully completed payment using credit card ", 1);
				}
				else
				{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
						"Successfully completed payment on failure case using credit card", 1);
				}
			}
			else
			{
				fUtil.flogResult("Failed", "Validate Credit card payment",
						"Credit card payment failed", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void validateDebitCardPaymentCliqPM() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String cardNumber=fUtil.fgetDataNew1("cardNumber");
			String cardName=fUtil.fgetDataNew1("cardName");
			Thread.sleep(5000);

			JavascriptExecutor jse = (JavascriptExecutor)browserFactory.get().getDriver();
			jse.executeScript("window.scrollBy(0,-350)");

			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().debitCliq,20))
			{
				TDL_SLPElectronicsPage.get().debitCliq.click();
				TDL_SLPElectronicsPage.get().debittnumberCliq.sendKeys(cardNumber);

				Thread.sleep(5000);
				Select sel = new Select(TDL_SLPElectronicsPage.get().expirymonthdebCliq);
				Thread.sleep(5000);
				sel.selectByValue("5");


				Thread.sleep(5000);
				Select sel1 = new Select(TDL_SLPElectronicsPage.get().expiryyeardebCliq);
				Thread.sleep(5000);
				sel1.selectByValue("2025");

				TDL_SLPElectronicsPage.get().cardnamedebCliq.sendKeys(cardName);
				TDL_SLPElectronicsPage.get().cvvdebCliq.sendKeys("123");
				TDL_SLPElectronicsPage.get().paydebCliq.click();

				if(paymentType.equalsIgnoreCase("Success"))
				{
					if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().carddetailsCliq, 20)) {
						TDL_SLPElectronicsPage.get().cardnumberCliq.sendKeys(cardNumber);
						TDL_SLPElectronicsPage.get().expiryCliq.sendKeys("0525");
						TDL_SLPElectronicsPage.get().cardmembernameCliq.sendKeys(cardName);
						TDL_SLPElectronicsPage.get().cvvnumberCliq.sendKeys("123");
						TDL_SLPElectronicsPage.get().proceedCLiq.click();
						
					}
					else {
						ClickAxisPasswordCroma();
					}
					ClickAxisPasswordCroma();
					//TdlBPPayments_Mobile.get().successBtn_android.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed payment using credit card",
							"Successfully completed payment using credit card ", 1);
				}
				else
				{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
						"Successfully completed payment on failure case using credit card", 1);
				}
			}
			else
			{
				fUtil.flogResult("Failed", "Validate Credit card payment",
						"Credit card payment failed", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}
	//Method for InternetBanking//
	@Test
	public void validateInternetBankingCliq() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");

			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().netBbCliq,15))
			{
				gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().netBbCliqarrow);

				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().netBbCliqarrow, 10)) {
					//gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().netBbCliqarrow);
					TDL_SLPElectronicsPage.get().netBbCliqarrow.click();
					Thread.sleep(1000);
				//	gmethods.scrollToViewElement(TdlCromaCard.get().cod_payment);
				//	Thread.sleep(2000);
				    if(!(gmethods.isElementVisible(TdlCromaCard.get().hdfcbank,3))) {
				    	scrollToBottom();
				    	TdlCromaCard.get().hdfcbank.click();
						TDL_SLPElectronicsPage.get().paynetank.click();
						Thread.sleep(3000);	
					}else {
						 TdlCromaCard.get().hdfcbank.click();
						 TDL_SLPElectronicsPage.get().paynetank.click();
						 Thread.sleep(3000);	 
					}
					
					if(paymentType.equalsIgnoreCase("Success"))
					{
						TDL_SLPElectronicsPage.get().NetBankingSucces_TPM.click();
						Thread.sleep(3000);
						fUtil.flogResult("Passed", "Successfully completed payment",
								"Successfully completed payment", 1);
					}
					else
					{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed Failure payment",
							"Successfully completed payment on failure case", 1);
					}
				}else
					fUtil.flogResult("Failed", "Validate Internet Banking",
							"No banks available under Internet Banking failed", 1);
			}
			else
				fUtil.flogResult("Failed", "Validate Internet Banking",
						"Internet Banking failed", 1);
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}
	
	@Test
	public void clickContinueShoppingTataCliq() throws Exception {
		try {
			Thread.sleep(5000);
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().orderCompleteCliq, 50)) {
				fUtil.flogResult("Passed", "Validate Order complete message Cliq",
						"Order complete message on cliq succesfull", 1);
			} else
				fUtil.flogResult("Failed", "Validate Order complete message Cliq",
						"Order complete message not available", 1);

			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().continueshopping, 50)) {
				TDL_SLPElectronicsPage.get().continueshopping.click();
				fUtil.flogResult("Passed", "Validate  Click Continue Shopping button Cliq",
						"Click Continue Shopping button on Cliq succesfull", 1);
			} else
				fUtil.flogResult("Failed", "Validate Click Continue Shopping Cliq",
						"Continue Shopping button not available", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Method for InternetBanking//
	@Test
	public void validateInternetBankingCliqPM() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");

			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().netBbCliq);

			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().netBbCliq,15))
			{

				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().netBbCliq, 10)) {
					TDL_SLPElectronicsPage.get().netBbCliq.click();



					gmethods.isElementVisible(TDL_SLPElectronicsPage.get().icicibank, 10);
					TDL_SLPElectronicsPage.get().icicibank.click();
					TDL_SLPElectronicsPage.get().paynetank.click();
					Thread.sleep(3000);
					if(paymentType.equalsIgnoreCase("Success"))
					{
						TDL_SLPElectronicsPage.get().NetBankingSucces_TPM.click();
						Thread.sleep(3000);
						fUtil.flogResult("Passed", "Successfully completed payment",
								"Successfully completed payment", 1);
					}
					else
					{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed Failure payment",
							"Successfully completed payment on failure case", 1);
					}
				}else
					fUtil.flogResult("Failed", "Validate Internet Banking",
							"No banks available under Internet Banking failed", 1);
			}
			else
				fUtil.flogResult("Failed", "Validate Internet Banking",
						"Internet Banking failed", 1);
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}
	@Test
	public void checkVideoWidget() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().expertReviewVideo, 10)) {
				//							TDL_SLPElectronicsPage.get().expertReviewVideo.click();
				Actions action =new Actions(BrowserFactory.webDriver.get());
				action.moveToElement(TDL_SLPElectronicsPage.get().expertReviewVideo).click().build().perform();
				fUtil.flogResult("Passed", "Validate video click",
						"Clicked on the video widget successfully", 1);
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().videoWidgetoverlay, 10)) {
					fUtil.flogResult("Passed", "Validate video page navigation",
							"Navigated to video page successfully", 1);	

				}
				else {
					fUtil.flogResult("Failed", "Validate video page navigation",
							"Didn't navigate to video page", 1);
				}
			}
			else {
				fUtil.flogResult("Failed", "Validate video click",
						"Video not visible", 1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate video page navigation", "Error occured: "+e.getMessage(), 1);

			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void navigateBackToTCP() throws Exception {
		try {
			BrowserFactory.webDriver.get().navigate().back();
			boolean titleHomepage=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsHomepageTitle, 30);
			if(titleHomepage) {
				fUtil.flogResult("Passed", "Validate SLP navigation",
						"Navigated back to SLP page successfully", 1);
			}
			else {
				fUtil.flogResult("Failed", "Validate SLP navigation",
						"Didn't navigate to SLP page", 1);
			}
		} catch (Exception ee) {
			fUtil.flogResult("Failed", "Validate SLP navigation",
					"Error" + ee.getMessage(), 0);
		}
	}

	@Test
	public void demoPageLanding() throws Exception {
		try {
			boolean demoPage=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().demoVideoPage, 30);
			if(demoPage) {
				fUtil.flogResult("Passed", "Validate demo video page landing",
						"Landed on demo page successfully", 1);
			}
			else {
				fUtil.flogResult("Failed", "Validate demo video page landing",
						"Didn't land on demo page", 1);
			}
		} catch (Exception ee) {
			fUtil.flogResult("Failed", "Validate demo video page landing",
					"Demo page landing error" + ee.getMessage(), 0);
		}
	}

	//To scroll to Video Demo widget on Electronics homepage
	@Test
	public void scrollTovideoDemoWidget() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().TDL_SLPElectronicsPage.get().limitedDeals_container.get(1));
			fUtil.flogResult("Passed", "Validate Scroll to video Demo widget", "Scrolled to video demo widget successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to video demo widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}



	//To check contents present under Shop By Category
	@Test
	public void validateDiffFashion() throws Exception{
		try {
			List <WebElement> widg;
			String SLP=fUtil.fgetDataNew1("SLP");

			String journey=fUtil.fgetDataNew1("Journey");
			String widgetEX=fUtil.fgetDataNew1("widget");
			String widgetEXTitle=fUtil.fgetDataNew1("widgetTitle");
			WebElement element;


			switch(journey) {
			case "Womenfashion":
				element=TDL_SLPElectronicsPage.get().womensFashion;
				widg=TDL_SLPElectronicsPage.get().Womenslist;
				break;
			case "Menfashion":
				element=TDL_SLPElectronicsPage.get().MensFashion;
				widg=TDL_SLPElectronicsPage.get().Menslist;
				break;
			case "Kidfashion":
				element=TDL_SLPElectronicsPage.get().kidsFashion;
				widg=TDL_SLPElectronicsPage.get().Kidslist;
				break;
			case "Footwear":
				element=TDL_SLPElectronicsPage.get().footwear;
				widg=TDL_SLPElectronicsPage.get().footwearlist;
				break;

			default:
				element=null;
				widg=null;
			}
			if(element!=null  ) {
				validatewidgetPresent(element,widgetEX,SLP);
				fetchWidget(widg,widgetEX,widgetEXTitle);
				selectWidget(widg,widgetEX,widgetEXTitle);

			}else
				fUtil.flogResult("Failed", "Validate" +journey + " widget", "No Matching journey passed as argument", 0);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate  widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void validateWestSideStoreWidgetUI() throws Exception {
		try {
			String widgetEx = fUtil.fgetDataNew1("widget");
			String widgetTitleEx = fUtil.fgetDataNew1("widgetTitle");
			String SLPjourney = fUtil.fgetDataNew1("SLP");
			String numberEx = fUtil.fgetDataNew1("Number");
			int val = Integer.parseInt(numberEx);
			validatewidgetPresent(TDL_SLPElectronicsPage.get().WestSideDiscoverFromTileTitle, widgetEx, SLPjourney);
			fetchWidget(TDL_SLPElectronicsPage.get().WestSideDiscoverFromlist, widgetEx, widgetTitleEx);
			clickWidgetNoTitle(TDL_SLPElectronicsPage.get().WestSideDiscoverFromlist, widgetEx, val);
		} catch (Exception e) {
			fUtil.flogResult("Failed", "PriceStore widget", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	//to select size
	@Test
	public void selectSizeCliq() throws Exception{
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			Set<String> handles=BrowserFactory.webDriver.get().getWindowHandles();
			for(String windowHandle  : handles)
			{
				if(!windowHandle.equals(parentWindow))
				{
					BrowserFactory.webDriver.get().switchTo().window(windowHandle);
				}
			}
			if(paymentmethod.equalsIgnoreCase("Cliqcash")) {
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().sizeCliqcash,20)) {
					fUtil.flogResult("Passed","Validate size option", "Size: "+TDL_SLPElectronicsPage.get().sizeCliq.getText()+"selected successfully", 1);
					TDL_SLPElectronicsPage.get().sizeCliqcash.click();
				}
			}
				else {
					if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().sizeCliq,30)) {
						fUtil.flogResult("Passed","Validate size option", "Size: "+TDL_SLPElectronicsPage.get().sizeCliq.getText()+"selected successfully", 1);
						TDL_SLPElectronicsPage.get().sizeCliq.click();
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void clickViewOrdersCliq() throws Exception{
		try {
			Thread.sleep(5000);
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().orderCompleteCliq,20)) {
				fUtil.flogResult("Passed", "Validate Order complete message Cliq","Order complete message on cliq succesfull", 1);
			}else
				fUtil.flogResult("Failed","Validate Order complete message Cliq", "Order complete message not available", 1);
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().viewOrdersCliq,20)) {
				TDL_SLPElectronicsPage.get().viewOrdersCliq.click();
				fUtil.flogResult("Passed", "Validate  Click View orders button Cliq","Click View orders button on Cliq succesfull", 1);
			}else
				fUtil.flogResult("Failed","Validate Click View orders Cliq", "View orders button not available", 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//To click on track first orders on TATA Cliq page
	@Test
	public void clickTrackFirstOrdersCliq() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().trackOrderCliq,20)) {
				TDL_SLPElectronicsPage.get().trackOrderCliq.click();
				fUtil.flogResult("Passed", "Validate  Click track first orders button Cliq","Click track first orders button on Cliq succesfull", 1);
			}else
				fUtil.flogResult("Failed","Validate Click track first orders Cliq", "track first orders button not available", 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	//To click on Fashion search button and search product
	@Test
	public void clickFashionSearchButtonAndValidateSearchString() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButton, 30)) {
				TDL_SLPElectronicsPage.get().searchButton.click();
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButtonCliq, 30)) {
					TDL_SLPElectronicsPage.get().searchButtonCliq.click();
					Thread.sleep(5000);
					if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButtonCliq, 30)) {
						TDL_SLPElectronicsPage.get().searchButtonCliq.sendKeys("Women Kurta");
						TDL_SLPElectronicsPage.get().searchButtonCliq.sendKeys(Keys.ENTER);
						if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchResultCliq,20)) {
							fUtil.flogResult("Passed","Validate Product found", "Product: "+"Women Kurta"+"found successfully", 1);
							TDL_SLPElectronicsPage.get().searchResultCliq.click();
						}
					}
				}else {
					fUtil.flogResult("Failed", "Validate Search button on TATA Cliq", "Search button on TATA Cliq not found", 1);
				}
			}else {
				fUtil.flogResult("Failed", "Validate fashion Search button on TCP App", "Fashion Search button on TCP App not found", 1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validateDiffSports() throws Exception{
		try {
			List <WebElement> widg;
			String SLP=fUtil.fgetDataNew1("SLP");

			String journey=fUtil.fgetDataNew1("Journey");
			String widgetEX=fUtil.fgetDataNew1("widget");
			String widgetEXTitle=fUtil.fgetDataNew1("widgetTitle");
			WebElement element;


			switch(journey) {
			case "ShopBySubCategory":
				element=TDL_SLPElectronicsPage.get().Sportswear;
				widg=TDL_SLPElectronicsPage.get().SportswearList;
				break;
			case "MensportsTheme":
				element=TDL_SLPElectronicsPage.get().ShopByActivity;
				widg=TDL_SLPElectronicsPage.get().ShopByActivityList;
				break;

			default:
				element=null;
				widg=null;
			}
			if(element!=null  ) {
				validatewidgetPresent(element,widgetEX,SLP);
				fetchWidget(widg,widgetEX,widgetEXTitle);
				selectWidget(widg,widgetEX,widgetEXTitle);

			}else
				fUtil.flogResult("Failed", "Validate" +journey + " widget", "No Matching journey passed as argument", 0);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate  widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void searchFashionSLP() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchFashion,20)) {
				TDL_SLPElectronicsPage.get().searchFashion.click();
				fUtil.flogResult("Passed", "Validate  Click search icon",
						"Search icon clicked successfully", 1);
			}else
				fUtil.flogResult("Failed", "Validate  Click search icon",
						"Search icon is not clicked", 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void scrollToTrendingSearch() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().trendingOffers);
			fUtil.flogResult("Passed", "Validate Scroll to Trending Offers", "Scrolled to Trending Offers successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to Trending Offers", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void clickTrendingSearch() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().trendingOffersImage,20)) {
				TDL_SLPElectronicsPage.get().trendingOffersImage.click();
				fUtil.flogResult("Passed", "Validate  Click Offer Image",
						"Offer Image clicked successfully", 1);
			}else
				fUtil.flogResult("Failed", "Validate  Offer Image click",
						"Offer Image is not clicked", 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validateFashionHomePagePWAMobile() throws Exception{
		try {
			boolean titleHomepage=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().FashionHomepageTitlePM, 30);
			//boolean searchButton=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButton, 20);
			if(titleHomepage) {
				fUtil.flogResult("Passed","Validate SLP Fashion page loaded and search icon present", "SLP Fashion homepage loaded with title: "+TDL_SLPElectronicsPage.get().FashionHomepageTitle.getText()+ "and search icon present",1);
			}else {
				fUtil.flogResult("Failed","Validate SLP Fashion page loaded and search icon present", "SLP Fashion homepage not loaded properly",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP Fashion page loaded", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void scrollToPriceStore() throws Exception{
		try {
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().specialPriceStore);
			fUtil.flogResult("Passed", "Validate Scroll to Special Price Store", "Scrolled to Special Price Store successfully", 1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate scroll to Special Price Store", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void clickSpecialPriceStore() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().specialPriceStoreImage,20)) {
				TDL_SLPElectronicsPage.get().specialPriceStoreImage.click();
				fUtil.flogResult("Passed", "Validate  Click Special Price Store Image",
						"Special Price Store Image clicked successfully", 1);
			}else
				fUtil.flogResult("Failed", "Validate  Special Price Store Image click",
						"Special Price Store Image is not clicked", 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void backtoPDPPageCroma() throws Exception{
		try {
			BrowserFactory.webDriver.get().navigate().back();
			System.out.println(BrowserFactory.webDriver.get().getCurrentUrl());
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().pdpPage,20)) {
				fUtil.flogResult("Passed", "Validate Landing back to PDP page",
						"landed back to PDP page successfully", 1);	
			}
			else {
				fUtil.flogResult("Failed", "Validate Landing back to PDP page",
						"Didn't land back to PDP page", 1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate landing back to PDP page", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void backtoPLPPageCroma() throws Exception{
		try {
			BrowserFactory.webDriver.get().navigate().back();
			Thread.sleep(5000);
			String url = BrowserFactory.webDriver.get().getCurrentUrl();
			System.out.println(url);
			if(url.contains("&source=tcp?state=null")) {
				fUtil.flogResult("Passed", "Validate Landing back to PLP page",
						"landed back to PLP page successfully", 1);	
			}
			else {
				fUtil.flogResult("Failed", "Validate Landing back to PLP page",
						"Didn't land back to PLP page", 1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate landing back to PLP page", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void backtoSLPelectronics() throws Exception{
		try {
			BrowserFactory.webDriver.get().navigate().back();
			Thread.sleep(5000);
			String url = BrowserFactory.webDriver.get().getCurrentUrl();

			System.out.println(url);
			if(url.contains("slp/electronics")) {
				fUtil.flogResult("Passed", "Validate Landing back to SLP page",
						"landed back to SLP page successfully", 1);	
			}
			else {
				fUtil.flogResult("Failed", "Validate Landing back to SLP page",
						"Didn't land back to SLP page", 1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate landing back to SLP page", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void validateElectronicsHPPD() throws Exception{
		try {
			boolean titleHomepage=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().electronicsHomepageTitlePD, 50);
			boolean searchButton=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButton, 10);
			if(titleHomepage && searchButton) {
				fUtil.flogResult("Passed","Validate SLP Electronics page loaded", "SLP Electronics homepage loaded with title: "+TDL_SLPElectronicsPage.get().electronicsHomepageTitle.getText()+" and search option present",1);
			}else {
				fUtil.flogResult("Failed","Validate SLP Electronics page loaded", "SLP Electronics homepage not loaded properly",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP Electronics page loaded", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void enterPincodeCroma() throws Exception{
		try {
			boolean editPin=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().editPincode, 10);
			if(editPin) {
				TDL_SLPElectronicsPage.get().editPincode.click();
				Thread.sleep(1500);
				gmethods.scroll_web(TDL_SLPElectronicsPage.get().inputPincode);
				TDL_SLPElectronicsPage.get().inputPincode.sendKeys("400096");
				Thread.sleep(1500);
				TDL_SLPElectronicsPage.get().applyPIN.click();
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().verifyPIN, 10)) {
					fUtil.flogResult("Failed","Validate PIN setup", 
							"PIN set successfully",1);	
				}
				else {
					fUtil.flogResult("Failed","Validate PIN setup", 
							"PIN is not set",1);
				}
			}else {
				fUtil.flogResult("Failed","Validate PIN edit option", 
						"Edit pin option not visible",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate PIN edit option", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void emptyCart() throws Exception{
		try {
			boolean cartcounter=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cartCounter, 10);
			if(cartcounter) {
				String value = TDL_SLPElectronicsPage.get().cartCounter.getText();
				if(!value.contains("0")) {
					TDL_SLPElectronicsPage.get().cart.click();
					Thread.sleep(5000);
					TDL_SLPElectronicsPage.get().deleteproduct.click();
					Thread.sleep(2000);
					TDL_SLPElectronicsPage.get().confirmDelete.click();
					if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().emptyCartMsg, 10)) {
						fUtil.flogResult("Passed","Validate empty cart", 
								"Cart is now empty",1);	
						BrowserFactory.webDriver.get().navigate().back();
						Thread.sleep(3000);
					}
					fUtil.flogResult("Failed","Validate empty cart", 
							"Cart is not empty",1);	
				}
				else {
					logger.info("No items in cart");
				}
			}else {
				fUtil.flogResult("Failed","Validate cart counter", 
						"cart counter not visible",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate cart counter", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}



	//Method for Loyalty//
	@Test
	public void validateLoyaltycliq() throws Exception {
		try {
			String LoyaltyPoints=fUtil.fgetDataNew1("Tcppoints_cutoff");
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String paymentmode=readData("Multitender").trim();
			if (gmethods.isElementVisible(TdlCromaCard.get().tcpPointsCliq_checkbox,30))
			{
				Thread.sleep(8000);
				TdlCromaCard.get().tcpPointsCliq_checkbox.click();
				Thread.sleep(8000);

				if(paymentmode.equalsIgnoreCase("Multitender_loyaltypoints")) {
					Thread.sleep(5000);
					TDL_SLPElectronicsPage.get().tcpPointsEditCliq.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Edit Tcp Points page is present",
							"Edit Tcp Points page is present", 1);

					TDL_SLPElectronicsPage.get().tcpPointsInputCliq.click();
					Thread.sleep(3000);
					TDL_SLPElectronicsPage.get().tcpPointsInputCliq.clear();
					Thread.sleep(3000);
					TDL_SLPElectronicsPage.get().tcpPointsInputCliq.sendKeys(LoyaltyPoints);
					Thread.sleep(3000);
					TDL_SLPElectronicsPage.get().tcpPointsApplyCliq.click();
				}

			}
			else
				fUtil.flogResult("Failed", "Validate TCP Point payment",
						"TCP Point payment failed", 1);
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}



	//Order details page
	@Test
	public void orderdetailsCliqBeauty() throws Exception{
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String paymentmode=fUtil.fgetDataNew1("Multitender");

			Thread.sleep(5000);
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().BagTotalCliq,20)) {
				fUtil.flogResult("Passed", "Validate Order details, Bag Total","Bag Total: "+TDL_SLPElectronicsPage.get().BagTotalCliq.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Shipping","Shipping: "+TDL_SLPElectronicsPage.get().shippingCliq.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Bag SubTotal","Bag SubTotal: "+TDL_SLPElectronicsPage.get().bagSubtotalCliq.getText(), 1);
				//fUtil.flogResult("Passed", "Validate Order details, Discount","Discount: "+TDL_SLPElectronicsPage.get().discountCliq.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Bag Total Pay","Bag Total Pay: "+TDL_SLPElectronicsPage.get().totalPayCliq.getText(), 1);

				String shipCharge=TDL_SLPElectronicsPage.get().shippingCliq.getText().replace("\u20B9" , " ").trim();
				shippingCharge=Double.parseDouble(shipCharge);
				
				if(paymentmethod.equalsIgnoreCase("TcpPoints")) {
					String points=TDL_SLPElectronicsPage.get().loyaltyappliedCliq.getText().replace("\u20B9" , " ").replace("-", " ").trim();
					pointsredeemed=Double.parseDouble(points);
				}
				else if(paymentmethod.equalsIgnoreCase("Cliqcash")){
					String cash=TDL_SLPElectronicsPage.get().cliq_cash_applied.getText().replace("\u20B9" , " ").replace("-", " ").trim();
					totalpayableCliq=Double.parseDouble(cash);
				}

				else if(paymentmode.equalsIgnoreCase("Multitender_loyaltypoints")){
					String points=TDL_SLPElectronicsPage.get().loyaltyappliedCliq.getText().replace("\u20B9" , " ").replace("-", " ").trim();
					pointsredeemed=Double.parseDouble(points);
					String totalpayable=TDL_SLPElectronicsPage.get().totalPayCliq.getText().replace("\u20B9" , " ").trim();
					totalpayableCliq=Double.parseDouble(totalpayable);
					fUtil.flogResult("Passed", "loyalty points validation", "points used: "+points, 1);
					//totalpayableCliq=Double.parseDouble(cash);
				}

				else if(paymentmode.equalsIgnoreCase("Multitender_Cliqcash")){
					String cash=TDL_SLPElectronicsPage.get().cliq_cash_applied.getText().replace("\u20B9" , " ").replace("-", " ").trim();
					String totalpayable=TDL_SLPElectronicsPage.get().totalPayCliq.getText().replace("\u20B9" , " ").trim();
					totalpayableCliq=Double.parseDouble(totalpayable);
					fUtil.flogResult("passed", "cliq cash validation", "cliq cash used: "+cash, 1);
					//totalpayableCliq=Double.parseDouble(cash);
				}
				else {
					String totalpayable=TDL_SLPElectronicsPage.get().totalPayCliq.getText().replace("\u20B9" , " ").trim();
					totalpayableCliq=Double.parseDouble(totalpayable);
				}
			}else {
				fUtil.flogResult("Failed","Validate Order details page Cliq", "order details page not available", 1);
		}
			}
			catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void expectedPointsEarnCliqSingleEligibleTender() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}else {
			amount=totalpayableCliq;
			pointsUsed = Double.parseDouble(tcpPoints);
			double expectedPoints = (amount-pointsUsed)*0.01;
			expectedEarnPromisedPoints = Math.round(expectedPoints);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points is:" + expectedEarnPromisedPoints,
					1);
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}	

	@Test
	public void expectedPointsEarnCliqSportsSingleEligibleTender() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}
			else {
				amount=totalpayableCliq;
				//pointsUsed = Double.parseDouble(tcpPoints);
				double expectedPoints = (amount)*0.01;
				expectedEarnPromisedPoints = Math.round(expectedPoints);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points is:" + expectedEarnPromisedPoints,
						1);
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	@Test
	public void expectedPointsEarnCliqBeautySingleEligibleTender() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}
			else {
				amount=totalpayableCliq;
				//pointsUsed = Double.parseDouble(tcpPoints);
				double expectedPoints = (amount)*0.04;
				expectedEarnPromisedPoints = Math.round(expectedPoints);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points is:" + expectedEarnPromisedPoints,
						1);
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	@Test
	public void validateThankyoupageCliq() throws Exception {
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().orderCompleteCliq, 50)) {
				fUtil.flogResult("Passed", "Order complete validation", "Order completed successfully", 1);	
			}
			else {
				paymentInvoice_page_Cliq();
				//fUtil.flogResult("Failed", "Order complete validation", "Order not completed successfully", 1);
			}
			//gmethods.isElementVisible(TDL_SLPElectronicsPage.get().continueshopping, 45);
			//TDL_SLPElectronicsPage.get().continueshopping.click();

			Thread.sleep(5000);
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	@Test
	public  void heroBannerSwipePwa() throws Exception {

		try {
			List<WebElement> listOfElements = TdlCromaCard.get().heroBannerPagesOffers;
			if (!gmethods.isElementVisible(TdlCromaCard.get().buyNowCTAHeroBanner, 5)) {
				for (WebElement e : listOfElements) {
					e.click();

					if (gmethods.isElementVisible(TdlCromaCard.get().buyNowCTAHeroBanner, 5)) {

						fUtil.flogResult("Passed", "Hero Banner In Offer Zone Page",
								"Swiped Clicked Buy Now successfully in Hero Banner", 1);
						TdlCromaCard.get().buyNowCTAHeroBanner.click();
						break;
					} else {
						continue;
					}
				}
			} else {
				TdlCromaCard.get().buyNowCTAHeroBanner.click();
				fUtil.flogResult("Passed", "Hero Banner In Offer Zone Page",
						"Swiped and Clicked Buy Now successfully in Hero Banner", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : heroBannerSwipePwaMobile ",
					"Exception while swiping in Hero banner page" + e.getMessage(), 1);
		}

	}

	@Test
	public  void clickBuynowofferzone() throws Exception {

		try {
			if (gmethods.isElementVisible(TdlCromaCard.get().buyNowBtnCromaOfferProduct, 25)) {
				gmethods.scroll_web(TdlCromaCard.get().buyNowBtnCromaOfferProduct);
				TdlCromaCard.get().buyNowBtnCromaOfferProduct.click();
				fUtil.flogResult("Passed", "Hero Banner In Offer Zone Page",
						"Swiped Clicked Buy Now successfully in Hero Banner", 1);
				TdlCromaCard.get().buyNowBtnCromaOfferProduct.click();
				fUtil.flogResult("Passed", "buy now button click","Clicked Buy Now successfully", 1);
			} else {
				fUtil.flogResult("Failed", "buy now button click","not clicked Buy Now successfully", 1);
			}


		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : heroBannerSwipePwaMobile ",
					"Exception while swiping in Hero banner page" + e.getMessage(), 1);
		}

	}

	@Test
	public void navigateToOfferZone() throws Exception {
		try {
			if(gmethods.isElementVisible(MyOffersPage.get().btnOfferZone, 20))
			{
				fUtil.flogResult("Passed", "Offer Zone button is visible", "Offer Zone button is visible in homepage", 1);
				MyOffersPage.get().btnOfferZone.click();			
			}
			else
			{
				fUtil.flogResult("Failed", "Offer Zone button is visible", "Offer Zone button is visible in homepage", 1);
			}

			if(gmethods.isElementVisible(MyOffersPage.get().TxtOffersAndBundles, 40))
			{
				fUtil.flogResult("Passed", "Text Offers and Bundles is visible", "Text Offers and Bundles is visible", 1);			
			}
			else
			{
				fUtil.flogResult("Failed", "Text Offers and Bundles is not visible", "Text Offers and Bundles should visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Save offer validation",e.getMessage(), 0);
		}
	}

	@Test
	public void pointUnlockDatedifference() throws Exception {
		try {
			LocalDate date=java.time.LocalDate.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
			String formattedDate = date.format(dtf);
			System.out.println(formattedDate);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
			Date firstDate = sdf.parse(transaction_date);
			Date secondDate = sdf.parse(points_unlock);

			long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

			if(diff<=2) {
				fUtil.flogResult("Passed", "unlock date duration validation", "unlock date duration validated to :"+diff,0);
			}
			else {
				fUtil.flogResult("Failed", "unlock date duration validation", "unlock date duration validated to :"+diff,0);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void validateCODPaymentLuxury() throws Exception {
		try {

			gmethods.scroll_web(TdlCromaCard.get().codCliqluxury);
			gmethods.isElementVisible(TdlCromaCard.get().codCliqluxury, 25);
			TdlCromaCard.get().codCliqluxury.click();

			if(gmethods.isElementVisible(TdlCromaCard.get().paydebCliqluxury, 25)) {
				fUtil.flogResult("Passed", "cod payment button validation", "cod payment validated successfully", 1);
				TdlCromaCard.get().paydebCliqluxury.click();
			}
			else {
				fUtil.flogResult("Failed", "cod payment button validation", "cod payment not validated successfully", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void validateEMIPaymentCliq() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String cardNumber=fUtil.fgetDataNew1("cardNumber");
			String cardName=fUtil.fgetDataNew1("cardName");

			//gmethods.scrollToViewElement(TdlCromaCard.get().upi_click_cliq);

			if(gmethods.isElementVisible(TdlCromaCard.get().emi_click_cliq, 35)){
				TdlCromaCard.get().emi_click_cliq.click();	
			}else {
				fUtil.flogResult("Failed", "emi payment button validation", "emi payment not displayed", 1);
			}
			

			if(gmethods.isElementVisible(TdlCromaCard.get().nocostemi_click_cliq, 25)) {
				fUtil.flogResult("Passed", "no cost emi payment button validation", "no cost emi payment validated successfully", 1);
				TdlCromaCard.get().nocostemi_click_cliq.click();
			}
			else {
				fUtil.flogResult("Failed", "no cost emi payment button validation", "no cost emi payment not validated successfully", 1);
			}
			if(gmethods.isElementVisible(TdlCromaCard.get().axis_bank_emi_cliq,25)) {
				TdlCromaCard.get().axis_bank_emi_cliq.click();	
			}
			

			gmethods.isElementVisible(TdlCromaCard.get().select_plan_emi_cliq, 25);
			TdlCromaCard.get().select_plan_emi_cliq.click();
			Thread.sleep(3000);
			TdlCromaCard.get().card_number_emi_cliq.sendKeys("5123456789012346");
			TdlCromaCard.get().expirymonth_emi_cliq.click();
			TdlCromaCard.get().expirymonth_emi_cliq.sendKeys(Keys.ARROW_DOWN);
			TdlCromaCard.get().expirymonth_emi_cliq.sendKeys(Keys.ENTER);
			TdlCromaCard.get().expiryyear_emi_cliq.click();
			TdlCromaCard.get().expiryyear_emi_cliq.sendKeys(Keys.ARROW_DOWN);
			TdlCromaCard.get().expiryyear_emi_cliq.sendKeys(Keys.ARROW_DOWN);
			TdlCromaCard.get().expiryyear_emi_cliq.sendKeys(Keys.ENTER);
			TdlCromaCard.get().card_name_emi_cliq.sendKeys("Testt");
			TdlCromaCard.get().cvv_emi_cliq.sendKeys("123");
			//Thread.sleep(2000);
			//Thread.sleep(5000);
			if(gmethods.isElementVisible(TdlCromaCard.get().payCliq,20))
			{
				Actions action =new Actions(BrowserFactory.webDriver.get());
				action.moveToElement(TdlCromaCard.get().payCliq).click().build().perform();
				//TDL_SLPElectronicsPage.get().payCliq.click();
				Thread.sleep(5000);
				Thread.sleep(5000);
			}
			if(paymentType.equalsIgnoreCase("Success"))
			{
				ClickAxisPasswordCroma();
				//TdlBPPayments_Mobile.get().successBtn_android.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed", "Successfully completed payment using credit card",
						"Successfully completed payment using credit card ", 1);
			}
			else
			{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
			Thread.sleep(3000);
			fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
					"Successfully completed payment on failure case using credit card", 1);
			}
		}

		catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void validateCustomerTier() throws Exception {
		try {

			gmethods.isElementVisible(TDL_SLPElectronicsPage.get().profile_dropdown, 35);
			Thread.sleep(10000);
			Actions act = new Actions(BrowserFactory.webDriver.get());
			act.moveToElement(TDL_SLPElectronicsPage.get().profile_dropdown);
			Thread.sleep(1000);
			TDL_SLPElectronicsPage.get().profile_dropdown.click();

			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().my_account_cliq, 25)) {
				fUtil.flogResult("Passed", "my account validation", "my account validated successfully", 1);
				TDL_SLPElectronicsPage.get().my_account_cliq.click();
			}
			else {
				fUtil.flogResult("Failed", "my account validation", "my account not validated successfully", 1);
			}

			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().user_profile_cliq,25)) {
				fUtil.flogResult("Passed", "user profile validation", "user profile validated successfully", 1);
			}
			else {
				fUtil.flogResult("Failed", "user profile validation", "user profile not validated successfully", 1);	
			}

			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().member_tier,25)) {
				String currenttier=TDL_SLPElectronicsPage.get().member_tier.getText();
				fUtil.flogResult("Passed", "member tier validation", "member tier validated successfully to: "+currenttier, 1);
			}
			else {
				fUtil.flogResult("Failed", "member tier validation", "member tier not validated successfully", 1);
			}

		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void validateCliqCashPayment() throws Exception{
		try {

			gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cliq_cash_switch_inactive, 30);
			TDL_SLPElectronicsPage.get().cliq_cash_switch_inactive.click();

			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cliq_cash_switch_active, 25)) {
				fUtil.flogResult("Passed", "cliq cash switch validation", "cliq cash switched", 1);	
			}
			else {
				fUtil.flogResult("Failed", "cliq cash switch validation", "cliq cash not switched", 1);
			}

		}catch(Exception e) {

		}
	}
	@Test
	public void validateDifferentloyaltyCard() throws Exception{
		try {
			String[]cardname=fUtil.fgetDataNew1("card_name").trim().split(",");
			for(int i=0;i<cardname.length;i++) {
				WebElement e=BrowserFactory.webDriver.get().findElement(By.xpath("//*[text()='"+cardname[i]+"']"));
				while(!gmethods.isElementVisible(e, 5)) {
					gmethods.scroll_web(e);
				}
				e.click();

				if(gmethods.isElementVisible(e, 25)) {
					String card_name=e.getText();
					fUtil.flogResult("Passed", "loyalty card validation", "loyalty card validated to: "+card_name, 1);
				}
				else {
					fUtil.flogResult("Failed", "loyalty card validation", "loyalty card not validated to", 1);
				}
				if(cardname[i].equalsIgnoreCase("IHCL") | cardname[i].equalsIgnoreCase("AirAsia") | cardname[i].equalsIgnoreCase("Big Basket")) {
					gmethods.isElementVisible(TdlCromaCard.get().mybenefits, 10);
					TdlCromaCard.get().mybenefits.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "My benefits section validation", "My benefits section validated successfully", 1);

					gmethods.isElementVisible(TdlCromaCard.get().alltiers, 10);
					TdlCromaCard.get().alltiers.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "all tiers section validation", "all tiers section validated successfully", 1);

					TdlCromaCard.get().offerCloseaftersignIn.click();
				}
				else {
					gmethods.isElementVisible(TdlCromaCard.get().mybenefits, 10);
					TdlCromaCard.get().mybenefits.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "My benefits section validation", "My benefits section validated successfully", 1);

					TdlCromaCard.get().offerCloseaftersignIn.click();
				}
			}
		}
		catch(Exception e) {
		}
	}

	@Test
	public void validateDifferentloyaltyCardCollapsed() throws Exception{
		try {
			String[]cardname=fUtil.fgetDataNew1("card_name").trim().split(",");
			for(int i=0;i<cardname.length;i++) {
				WebElement e=BrowserFactory.webDriver.get().findElement(By.xpath("//*[text()='"+cardname[i]+"']"));
				while(!gmethods.isElementVisible(e, 5)) {
					gmethods.scroll_web(e);
				}
				if(gmethods.isElementVisible(e, 25)) {
					String card_name=e.getText();
					fUtil.flogResult("Passed", "loyalty card validation", "loyalty card validated to: "+card_name, 1);
				}
				else {
					fUtil.flogResult("Failed", "loyalty card validation", "loyalty card not validated to", 1);
				}	
			}
		}
		catch(Exception e) {
		}
	}

	@Test
	public void basePointExpiry() throws Exception{
		try {
			LocalDate date=java.time.LocalDate.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
			String formattedDate = date.format(dtf);
			System.out.println(formattedDate);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
			Date firstDate = sdf.parse(pointexpirydate);
			Date secondDate = sdf.parse(formattedDate);

			long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

			if(diff<365) {
				fUtil.flogResult("Passed", "expiry date validation","expiry date is less than 365", 1);
			}
			else {
				fUtil.flogResult("Failed", "expiry date validation","expiry date is not less than 365", 1);	
			}
		}
		catch(Exception e) {
		}
	}

	@Test
	public void goto_CromaCard() throws Exception {

		try {
			uRewardsPageNavigation();
			//gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_Croma);	
			
			if(gmethods.isElementVisible(TdlCromaCard.get().cardNameText_Croma,20)){

				logger.info("Croma card is visible");
				TdlCromaCard.get().cardNameText_Croma.click();
				fUtil.flogResult("Passed", "Is Croma card selected", "Croma card selected", 1);
				
				Thread.sleep(10000);
				boolean bookNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefits,20);
		        
				if(bookNow && activity && myBenefits ) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "Croma Card is present with proper details", 1);
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Card is present with improper details", 1);
				}
				
				boolean shopNowCroma = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				if (shopNowCroma == true) {

					TdlCromaCard.get().shopNowCromaCTA.click();
					logger.info("Clicked on Shop Now");
					fUtil.flogResult("Passed", "Click Shop Now on Croma Card",
							"Successfully clicked on Shop Now on Croma Card", 1);
				}
				else {
					logger.error("Croma card not visible");
					fUtil.flogResult("Failed", "Visibility of Card", "Croma card is not visible", 1);
				}
				if(gmethods.isElementVisible(TdlCromaCard.get().electronics_slp_croma,40)) {
					
					fUtil.flogResult("Passed", "slp electronics page visibility check",
							"slp electronics page visible", 1);
				}
				else {
					fUtil.flogResult("Failed", "slp electronics page visibility check", "slp electronics page not visible", 1);
				}
				}
			}
		
			catch (Exception e) {
				fUtil.flogResult("Failed", "General Function : goto_CromaCard ", "Exception Caught : "+e.getMessage(), 1);		
			}
	}

	@Test
	public void goto_CromaCardPM() throws Exception {

		try {
			uRewardsPageNavigationPM();
			
			gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_Croma);	
			
			
			if(gmethods.isElementVisible(TdlCromaCard.get().cardNameText_Croma,20)){

				logger.info("Croma card is visible");
				TdlCromaCard.get().cardNameText_Croma.click();
				fUtil.flogResult("Passed", "Is Croma card selected", "Croma card selected", 1);
				
				Thread.sleep(10000);
				boolean shopNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
			//	boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefitsPM,20);
		        
				if(shopNow && activity  ) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "Croma Card is present with proper details", 1);
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Card is present with proper details", 1);
				}
				//boolean shopNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				if (shopNow == true) {

					TdlCromaCard.get().shopNowCromaCTA.click();
					logger.info("Clicked on Shop Now");
					fUtil.flogResult("Passed", "Click Shop Now on Croma Card",
							"Successfully clicked on Shop Now on Croma Card", 1);
				}
				else {
					logger.error("Croma card not visible");
					fUtil.flogResult("Failed", "Visibility of Card", "Croma card is not visible", 1);
				}
                if(gmethods.isElementVisible(TdlCromaCard.get().electronics_slp_croma_PM,25)) {
					
					fUtil.flogResult("Passed", "slp electronics page visibility check",
							"slp electronics page visible", 1);
				}
				else {
					fUtil.flogResult("Failed", "slp electronics page visibility check", "slp electronics page not visible", 1);
				}
			}
				}
		catch (Exception e) {
				fUtil.flogResult("Failed", "General Function : goto_CromaCard ", "Exception Caught : "+e.getMessage(), 1);		
			}
	}

	@Test
	public void goto_CliQCard() throws Exception {

		try {
			uRewardsPageNavigation();
			
			//gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_Cliq);	
			
			
			if(gmethods.isElementVisible(TdlCromaCard.get().cardNameText_Cliq,20)){

				logger.info("Croma card is visible");
				TdlCromaCard.get().cardNameText_Cliq.click();
				fUtil.flogResult("Passed", "Is Croma card selected", "Croma card selected", 1);
				
				Thread.sleep(10000);
				boolean shopNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefits,20);
		        
				if(shopNow && activity && myBenefits ) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "Cliq Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Card is present with proper details", 1);
				}
				//boolean shopNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				if (shopNow == true) {

					TdlCromaCard.get().shopNowCromaCTA.click();
					logger.info("Clicked on Shop Now");
					fUtil.flogResult("Passed", "Click Shop Now on Cliq Card",
							"Successfully clicked on Shop Now on Cliq Card", 1);
				}
				else {
					logger.error("Cliq card not visible");
					fUtil.flogResult("Failed", "Visibility of Card", "Cliq card is not visible", 1);
				}
				
				if (gmethods.isElementVisible(TdlCromaCard.get().fashion_slp_cliq,40)) {
					fUtil.flogResult("Passed", "fashion slp page visibility check",
							"fashion slp page visible", 1);
				}
				else {
					fUtil.flogResult("Failed", "fashion slp page visibility check","fashion slp page visible", 1);
				}
				
			}} catch (Exception e) {
				fUtil.flogResult("Failed", "General Function : goto_CromaCard ", "Exception Caught : "+e.getMessage(), 1);		
			}
	}
	
	@Test
	public void goto_CliQCardPM() throws Exception {

		try {
			uRewardsPageNavigationPM();
			gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_Cliq);	
			

			if(gmethods.isElementVisible(TdlCromaCard.get().cardNameText_Cliq,20)){

				logger.info("Croma card is visible");
				TdlCromaCard.get().cardNameText_Cliq.click();
				fUtil.flogResult("Passed", "Is Cliq card selected", "Cliq card selected", 1);
				
				Thread.sleep(10000);
				boolean bookNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				//boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefitsPM,20);
		        
				if(bookNow && activity  ) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "Cliq Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Card is present with proper details", 1);
				}
				
				
				boolean shopNowCroma = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				if (shopNowCroma == true) {

					TdlCromaCard.get().shopNowCromaCTA.click();
					logger.info("Clicked on Shop Now");
					fUtil.flogResult("Passed", "Click Shop Now on Cliq Card",
							"Successfully clicked on Shop Now on Cliq Card", 1);
				}
				else {
					logger.error("Croma card not visible");
					fUtil.flogResult("Failed", "Visibility of Card", "Croma card is not visible", 1);
				}
				
				if (gmethods.isElementVisible(TdlCromaCard.get().fashion_slp_cliq_PM,40)) {
					fUtil.flogResult("Passed", "fashion slp page visibility check",
							"fashion slp page visible", 1);
				}
				else {
					fUtil.flogResult("Failed", "fashion slp page visibility check","fashion slp page not visible", 1);
				}
				
			}} catch (Exception e) {
				fUtil.flogResult("Failed", "General Function : goto_CliqCard ", "Exception Caught : "+e.getMessage(), 1);		
			}
	}
	
	
	@Test
	public void goto_Westside() throws Exception {

		try {
			uRewardsPageNavigation();
			
			//gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_Cliq);	
			
			
			if(gmethods.isElementVisible(TdlCromaCard.get().cardNameTextWestside,20)){

				logger.info("Croma card is visible");
				TdlCromaCard.get().cardNameTextWestside.click();
				fUtil.flogResult("Passed", "Is Westside card selected", "Westside card selected", 1);
				
				Thread.sleep(10000);
				boolean shopNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				//boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefits,20);
		        
				if(shopNow && activity ) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "Westside Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Westside is present with proper details", 1);
				}
				//boolean shopNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				if (shopNow == true) {

					TdlCromaCard.get().shopNowCromaCTA.click();
					logger.info("Clicked on Shop Now");
					fUtil.flogResult("Passed", "Click Shop Now on Cliq Card",
							"Successfully clicked on Shop Now on Cliq Card", 1);
				}
				else {
					logger.error("Cliq card not visible");
					fUtil.flogResult("Failed", "Visibility of Card", "Westside card is not visible", 1);
				}
				
				if (gmethods.isElementVisible(TdlCromaCard.get().fashion_slp_cliq,40)) {
					fUtil.flogResult("Passed", "fashion slp page visibility check",
							"fashion slp page visible", 1);
				}
				else {
					fUtil.flogResult("Failed", "fashion slp page visibility check","fashion slp page visible", 1);
				}
				
			}} catch (Exception e) {
				fUtil.flogResult("Failed", "Function : Westside ", "Exception Caught : "+e.getMessage(), 1);		
			}
	}
	
	@Test
	public void westsideCardValidation() throws Exception {

		try {
			uRewardsPageNavigation();
			
			//gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_Cliq);	
			
			
			if(gmethods.isElementVisible(TdlCromaCard.get().cardNameTextWestside,20)){

				logger.info("Croma card is visible");
				TdlCromaCard.get().cardNameTextWestside.click();
				fUtil.flogResult("Passed", "Is Westside card selected", "Westside card selected", 1);
				
				Thread.sleep(10000);
				boolean shopNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				//boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefits,20);
		        
				if(shopNow && activity ) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "Westside Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Westside is present with proper details", 1);
				}
				//boolean shopNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				if (shopNow == true) {

					TdlCromaCard.get().shopNowCromaCTA.click();
					logger.info("Clicked on Shop Now");
					fUtil.flogResult("Passed", "Click Shop Now on Cliq Card",
							"Successfully clicked on Shop Now on Cliq Card", 1);
				}
				else {
					logger.error("Cliq card not visible");
					fUtil.flogResult("Failed", "Visibility of Card", "Westside card is not visible", 1);
				}
				
				if (gmethods.isElementVisible(TdlCromaCard.get().fashion_slp_cliq,40)) {
					fUtil.flogResult("Passed", "fashion slp page visibility check",
							"fashion slp page visible", 1);
				}
				else {
					fUtil.flogResult("Failed", "fashion slp page visibility check","fashion slp page visible", 1);
				}
				
			}} catch (Exception e) {
				fUtil.flogResult("Failed", "Function : Westside ", "Exception Caught : "+e.getMessage(), 1);		
			}
	}
	
	
	
	
	@Test
	public void goto_BigBasketCard() throws Exception {

		try {
			uRewardsPageNavigation();
			if(gmethods.isElementVisible(TdlCromaCard.get().cardNameText_Bigbasket,20)){

				logger.info("big basket card is visible");
				TdlCromaCard.get().cardNameText_Bigbasket.click();
				fUtil.flogResult("Passed", "Is big basket card selected", "big basket card selected", 1);
				
				Thread.sleep(10000);
				boolean bookNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefits,20);
				boolean allTiers=gmethods.isElementVisible(TdlCromaCard.get().alltiers,20);
				if(bookNow && activity && myBenefits && allTiers){
					
					fUtil.flogResult("Passed", "Card Expanded Check", "big basket Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "big basket Card is present with proper details", 1);
				}
				
				boolean shopNowCroma = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				if (shopNowCroma == true) {

					TdlCromaCard.get().shopNowCromaCTA.click();
					logger.info("Clicked on Shop Now");
					fUtil.flogResult("Passed", "Click Shop Now on big basket Card",
							"Successfully clicked on Shop Now on big basket Card", 1);
				}
				else {
					logger.error("big basket card not visible");
					fUtil.flogResult("Failed", "Visibility of Card", "big basket card is not visible", 1);
				}
				
				if (gmethods.isElementVisible(TdlCromaCard.get().essentials_slp_bigbasket,40)) {
					fUtil.flogResult("Passed", "essentials slp page visibility check",
							"essentials slp page visible", 1);
				}
				else {
					fUtil.flogResult("Failed", "essentials slp page visibility check","essentials slp page visible", 1);
				}
				
			}} catch (Exception e) {
				fUtil.flogResult("Failed", "General Function : goto_bigbasketCard ", "Exception Caught : "+e.getMessage(), 1);		
			}
	}
	
	@Test
	public void goto_BigBasketCardPM() throws Exception {

		try {
			uRewardsPageNavigationPM();
			
			gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_Bigbasket);	
			

			if(gmethods.isElementVisible(TdlCromaCard.get().cardNameText_Bigbasket,20)){

				logger.info("big basket card is visible");
				TdlCromaCard.get().cardNameText_Bigbasket.click();
				fUtil.flogResult("Passed", "Is big basket card selected", "big basket card selected", 1);
				
				Thread.sleep(10000);
				boolean bookNow = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefitsPM,20);
				boolean allTiers=gmethods.isElementVisible(TdlCromaCard.get().alltiers,20);
				if(bookNow && activity  && allTiers) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "big basket Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Card is present with proper details", 1);
				}
				
				boolean shopNowCroma = gmethods.isElementVisible(TdlCromaCard.get().shopNowCromaCTA, 20);
				if (shopNowCroma == true) {

					TdlCromaCard.get().shopNowCromaCTA.click();
					logger.info("Clicked on Shop Now");
					fUtil.flogResult("Passed", "Click Shop Now on big basket Card",
							"Successfully clicked on Shop Now on big basket Card", 1);
				}
				else {
					logger.error("big basket card not visible");
					fUtil.flogResult("Failed", "Visibility of Card", "big basket card is not visible", 1);
				}
				
				if (gmethods.isElementVisible(TdlCromaCard.get().essentials_slp_bigbasket_PM,40)) {
					fUtil.flogResult("Passed", "essentials slp page visibility check",
							"essentials slp page visible", 1);
				}
				else {
					fUtil.flogResult("Failed", "essentials slp page visibility check","essentials slp page not visible", 1);
				}
				
			}} catch (Exception e) {
				fUtil.flogResult("Failed", "General Function : goto_CliqCard ", "Exception Caught : "+e.getMessage(), 1);		
			}
	}
	
	//To click on IHCL Card
	@Test
	public void GoToIHCLCard() throws Exception{
		try {
			uRewardsPageNavigation();
			Thread.sleep(1000);
			//gmethods.scrollToViewElement(TdlCromaCard.get().ihclCard);	
			
			if(gmethods.isElementVisible(TdlCromaCard.get().ihclCard, 30)) {
				TdlCromaCard.get().ihclCard.click();
				
				Thread.sleep(10000);
				boolean bookNow = gmethods.isElementVisible(TdlCromaCard.get().ihclCardBookNow, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefits,20);
				boolean allTiers=gmethods.isElementVisible(TdlCromaCard.get().alltiers,20);
				if(bookNow && activity && myBenefits && allTiers){
					
					fUtil.flogResult("Passed", "Card Expanded Check", "IHCL Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Card is present with proper details", 1);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().ihclCardBookNow, 30)) {
					fUtil.flogResult("Passed", "Validate Book Now button on IHCL card pop-up", "Book Now button on IHCL card pop-up found", 1);
					TdlCromaCard.get().ihclCardBookNow.click();
					Thread.sleep(5000);

				}
				else {
					fUtil.flogResult("Failed", "Validate Book Now button on IHCL card pop-up", "Book Now button on IHCL card pop-up not found", 1);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().hotel_slp_ihcl, 30)) {
					fUtil.flogResult("Passed", "Validate hotel slp page", "hotel slp validated successfully", 1);
				}
				else {
					fUtil.flogResult("Failed", "Validate hotel slp page", "hotel slp not validated successfully", 1);
				}
			}
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "IHCL Card validation",e.getMessage(), 0);
		}
	}
	
	@Test
	public void GoToIHCLCardPM() throws Exception{
		try {
			uRewardsPageNavigationPM();
			Thread.sleep(1000);
			
			if(gmethods.isElementVisible(TdlCromaCard.get().ihclCard, 30)) {
				TdlCromaCard.get().ihclCard.click();
				
				Thread.sleep(10000);
				boolean bookNow = gmethods.isElementVisible(TdlCromaCard.get().ihclCardBookNow, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefits,20);
		        
				if(bookNow && activity  ) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "IHCL Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Card is present with proper details", 1);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().ihclCardBookNow, 30)) {
					fUtil.flogResult("Passed", "Validate Book Now button on IHCL card pop-up", "Book Now button on IHCL card pop-up found", 1);
					TdlCromaCard.get().ihclCardBookNow.click();
					Thread.sleep(5000);

				}
				else {
					fUtil.flogResult("Failed", "Validate Book Now button on IHCL card pop-up", "Book Now button on IHCL card pop-up not found", 1);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().hotel_slp_ihcl_PM, 30)) {
					fUtil.flogResult("Passed", "Validate hotel slp page", "hotel slp validated successfully", 1);
				}
				else {
					fUtil.flogResult("Failed", "Validate hotel slp page", "hotel slp not validated successfully", 1);
				}
				
			}
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "IHCL Card validation",e.getMessage(), 0);
		}
	}
	
	//To click on book now on hotel SLP
	@Test
	public void GoToIHCLCard_HotelSLP() throws Exception{
		try {
			if(gmethods.isElementVisible(TdlCromaCard.get().searchIconHotelSLP, 30)) {
				fUtil.flogResult("Passed", "Validate Hotel SLP Page", "Hotel SLP Page found", 1);
				TdlCromaCard.get().BookNowHotelSLP.click();
			}
			else {
				fUtil.flogResult("Failed", "Validate Hotel SLP Page", "Hotel SLP Page not found", 1);
			}
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "Hotel SLP via IHCL validation ",e.getMessage(), 0);
		}
	}

	//To click on airasia Crad and click on book now on pop-up
	@Test
	public void GoToAirAsiaCard() throws Exception{
		try {
			uRewardsPageNavigation();
			
			if(gmethods.isElementVisible(TdlCromaCard.get().AirAsiaCard, 30)) {
				TdlCromaCard.get().AirAsiaCard.click();
				
				Thread.sleep(10000);
				boolean bookNow = gmethods.isElementVisible(TdlCromaCard.get().airAsiaCardBookNow, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefits,20);
				boolean allTiers=gmethods.isElementVisible(TdlCromaCard.get().alltiers,20);
				
				if(bookNow && activity && myBenefits && allTiers) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "AirAsia Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Card is present with proper details", 1);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().airAsiaCardBookNow, 30)) {
					fUtil.flogResult("Passed", "Validate Book Now button on AirAsia card pop-up", "Book Now button on Air Asia card pop-up found", 1);
					TdlCromaCard.get().airAsiaCardBookNow.click();
					switchToNewTab();
				}
				else {
					fUtil.flogResult("Failed", "Validate Book Now button on AirAsia card pop-up", "Book Now button on Air Asia card pop-up not found", 1);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().flights_slp_airasia, 40)) {
					fUtil.flogResult("Passed", "air asia page validation", "air asia page validated successfully", 1);
				}
				else {
					fUtil.flogResult("Failed", "air asia page validation", "air asia page not validated successfully", 1);
				}
				
			}
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "Air Asia Card validation",e.getMessage(), 0);
		}
	}
	
	@Test
	public void GoToAirAsiaCardPM() throws Exception{
		try {
			uRewardsPageNavigationPM();
			
			gmethods.scrollToViewElement(TdlCromaCard.get().AirAsiaCard); 
			if(gmethods.isElementVisible(TdlCromaCard.get().AirAsiaCard, 30)) {
				TdlCromaCard.get().AirAsiaCard.click();
				
				Thread.sleep(10000);
				boolean bookNow = gmethods.isElementVisible(TdlCromaCard.get().airAsiaCardBookNow, 20);
				boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTab,20);
				boolean myBenefits=gmethods.isElementVisible(TdlCromaCard.get().mybenefitsPM,20);
		        
				if(bookNow && activity && myBenefits ) {
					
					fUtil.flogResult("Passed", "Card Expanded Check", "AirAsia Card is present with proper details", 1);
				
				}else {
					fUtil.flogResult("Failed", "Card Expanded Check", "Card is present with proper details", 1);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().airAsiaCardBookNow, 30)) {
					fUtil.flogResult("Passed", "Validate Book Now button on AirAsia card pop-up", "Book Now button on Air Asia card pop-up found", 1);
					TdlCromaCard.get().airAsiaCardBookNow.click();
				}
				else {
					fUtil.flogResult("Failed", "Validate Book Now button on AirAsia card pop-up", "Book Now button on Air Asia card pop-up not found", 1);
				}
				
				if(gmethods.isElementVisible(TdlCromaCard.get().flights_slp_airasia, 40)) {
					fUtil.flogResult("Passed", "air asia page validation", "air asia page validated successfully", 1);
				}
				else {
					fUtil.flogResult("Failed", "air asia page validation", "air asia page not validated successfully", 1);
				}
				
			}
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "Air Asia Card validation",e.getMessage(), 0);
		}
	}
	
	@Test
	public void TCPCardDetails() throws Exception {
    try {
    	boolean tcpCard=gmethods.isElementVisible(TdlCromaCard.get().uPointsTCPCard,20);
		if(tcpCard) {
			TdlCromaCard.get().tcpviewDetailsBtn.click();
			fUtil.flogResult("Passed", "Is TCP card selected", "TCP card selected", 1);
		}
		
		//Validation After Expanding TCP Card
		boolean topNavRewardsCoinspresnt=gmethods.isElementVisible(TdlCromaCard.get().rewardsTopNavCoins, 20);
		boolean tcpCardPage = gmethods.isElementVisible(TdlCromaCard.get().uPointsLabel, 20);
		boolean upointTotalbalance = gmethods.isElementVisible(TdlCromaCard.get().uPointsBalance, 5);
		boolean upointUseablebalance = gmethods.isElementVisible(TdlCromaCard.get().uPointsUseableBalance, 5);
		boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTabTCP,5);
		boolean pointsSchedule=gmethods.isElementVisible(TdlCromaCard.get().pointsScheduleTabTCP,5);
		

		if(upointTotalbalance && activity && pointsSchedule &&upointUseablebalance) {

			logger.info("NeuPass Card is visible");
			fUtil.flogResult("Passed", "NeuPass Card Expanded Check", "NeuPass Card present with proper details", 1);
			String topNavRewardsCoins=TdlCromaCard.get().rewardsTopNavCoins.getAttribute("innerText");
			String totalCoin=TdlCromaCard.get().uPointsBalance.getAttribute("innerText");
			if (topNavRewardsCoins.contains(totalCoin)) {
				fUtil.flogResult("Passed", "Available NeuCoins check at Top Navigator Bar", "Available NeuCoins is displayed at TopNavigator", 1);
			}else {
				fUtil.flogResult("Failed", "Available NeuCoins check at Top Navigator Bar", "Available NeuCoins is not displayed at TopNavigator", 1);	
			}
		}else {
			fUtil.flogResult("Failed", "NeuPass Card Expanded Check", "NeuPass Card is present with improper details", 1);
		}
		
		 } catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : TCPCardDetails ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	@Test
	public void tCPCardPoints() throws Exception {
    try {
    	String totalPoints1=TdlCromaCard.get().uPointsBalance.getText();
    	double totalpoints=Double.parseDouble(totalPoints1);
    	String useablePoints1=TdlCromaCard.get().uPointsUseableBalance.getText();
    	double useablePoints=Double.parseDouble(useablePoints1);
    	if(totalpoints>=useablePoints) {

			logger.info("TCP Card points are correct");
			fUtil.flogResult("Passed", "TCP Card points Check", "TCP Card points are correct", 1);
		}else {
			fUtil.flogResult("Failed", "TCP Card points Check", "TCP Card points are correct", 1);
		}
		
		 } catch (Exception e) {
			fUtil.flogResult("Failed", "tCPCardPoints", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	@Test
	public void TCPCardDetailsPM() throws Exception {
    try {
    	//uRewardsPageNavigationPM();
    	boolean tcpCard=gmethods.isElementVisible(TdlCromaCard.get().uPointsTCPCard,20);
		if(tcpCard) {
			TdlCromaCard.get().uPointsTCPCard.click();
			fUtil.flogResult("Passed", "Is TCP card selected", "TCP card selected", 1);
		}
		Thread.sleep(10000);
		//boolean tcpCardPage = gmethods.isElementVisible(TdlCromaCard.get().uPointsLabel, 20);
		boolean upointbalance = gmethods.isElementVisible(TdlCromaCard.get().uPointsBalance, 20);
		boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTabTCP,20);
		boolean pointsSchedule=gmethods.isElementVisible(TdlCromaCard.get().pointsScheduleTabTCP,20);

		if(upointbalance && activity && pointsSchedule) {

			logger.info("TCP Card is visible");
			fUtil.flogResult("Passed", "TCP Card Expanded Check", "TCP Card present with proper details", 1);
		}else {
			fUtil.flogResult("Failed", "TCP Card Expanded Check", "TCP Card is present with improper details", 1);
		}
		
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : TCPCardDetails ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	@Test
	public void chatBotInvoke() throws Exception{
		try {
	//		gmethods.isElementVisible(TdlCromaCard.get().viewDetailsCTA_TCP, 25);
	//		TdlCromaCard.get().viewDetailsCTA_TCP.click();

			if(gmethods.isElementVisible(TdlCromaCard.get().chat_with_us, 25)) {
				TdlCromaCard.get().chat_with_us.click();
				Thread.sleep(2000);
				fUtil.flogResult("Passed", "Chat with us btn validation","Chat with us validated", 1);
				//TdlCromaCard.get().chat_with_us.click();
			}
			else {
				fUtil.flogResult("Failed", "chat with us validation","chat with us not validated", 1);
			}

			
			
			  if(gmethods.isElementVisible(TdlCromaCard.get().customer_name, 25)) {
			  fUtil.flogResult("Passed",
			  "chat with us window validation","chat with us window validated", 1); } else
			  { fUtil.flogResult("Failed",
			  "chat with us window validation","chat with us window not validated", 1); }
			 
			 
		}
		catch(Exception e) {
		}
	}
	
	//To click on Sports search button and search product
	@Test
	public void clickSportsSearchButtonAndValidateSearchString() throws Exception{
		try {
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButton, 30)) {
				TDL_SLPElectronicsPage.get().searchButton.click();
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButtonCliq, 30)) {
					TDL_SLPElectronicsPage.get().searchButtonCliq.click();
					Thread.sleep(5000);
					if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButtonCliq, 30)) {
						TDL_SLPElectronicsPage.get().searchButtonCliq.sendKeys("mp000000006917518");
						TDL_SLPElectronicsPage.get().searchButtonCliq.sendKeys(Keys.ENTER);
						if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchResultCliq,20)) {
							fUtil.flogResult("Passed","Validate Product found", "Product: "+"mp000000006917518"+"found successfully", 1);
							TDL_SLPElectronicsPage.get().searchResultCliq.click();
						}
					}
				}else {
					fUtil.flogResult("Failed", "Validate Search button on TATA Cliq", "Search button on TATA Cliq not found", 1);
				}
			}else {
				fUtil.flogResult("Failed", "Validate sports Search button on TCP App", "Sports Search button on TCP App not found", 1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void goToTataCliqCardAfterTransaction() throws Exception{
		try {
			
			//gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_tataCliqCard);
            if(gmethods.isElementVisible(TdlCromaCard.get().cardNameText_tataCliqCard, 30)) {
				TdlCromaCard.get().cardNameText_tataCliqCard.click();
				Thread.sleep(8000);
				if(gmethods.isElementVisible(TdlCromaCard.get().activityTab, 30)) {
					fUtil.flogResult("Passed", "Card Open", "Tata Cliq Card Opened", 1);
					
					if(gmethods.isElementVisible(TdlCromaCard.get().CardTransactAmt, 20)) {
				    	String transactionAmt1= TdlCromaCard.get().CardTransactAmt.getText().replace("\u20B9","").trim();
				    	double transactionAmt=DecimalFormat.getNumberInstance().parse(transactionAmt1).doubleValue();
				    	if(transactionAmt==Math.round(totalCartAmount)) {
				    		fUtil.flogResult("Passed", "TataCliq Transaction Amount Check", "Transaction amount is correct"+" as Expected:"+totalCartAmount+" is equal to Actual:"+transactionAmt, 1);
				    	}else
				    		fUtil.flogResult("Failed", "TataCliq Transaction Amount Check", "Transaction amount is not correct"+" as Expected:"+totalCartAmount+" is equal not to Actual:"+transactionAmt, 1);
				    	
				    }
					
					
				/*String todaysDate=currentdate();
					Thread.sleep(10000);
					String transactionDateXpath="//*[contains(text()='"+todaysDate+"']";
					boolean dateVisible=gmethods.isElementVisibleXpath(transactionDateXpath,20);
					if(dateVisible) {
				    	if(gmethods.isElementVisible(TdlCromaCard.get().CardTransactAmt, 30)) {
				    		String trasactedAmt=TdlCromaCard.get().CardTransactAmt.getText();
				    		fUtil.flogResult("Passed", "Transaction Details", "Tata Cliq transaction is visible on card", 1);


				    	}else {
				    		fUtil.flogResult("Failed", "Transaction Details", "Tata Cliq transaction is not visible on card", 1);
				    	}
				    }
				    */

					//Close Tata Cliq Card
					TdlCromaCard.get().offerCloseaftersignIn.click();
					Thread.sleep(2000);

				}
				else {
					fUtil.flogResult("Failed", "Card Open", "Tata Cliq Card not Opened", 1);
				}
			}
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "Card validation",e.getMessage(), 0);
		}
	}
	
	@Test
	public void gotoCromaCardAfterTransaction() throws Exception{
		try {
			
			//gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_Croma);
			Thread.sleep(3000);
            if(gmethods.isElementVisible(TdlCromaCard.get().cardNameText_Croma, 30)) {
				TdlCromaCard.get().cardNameText_Croma.click();
				Thread.sleep(8000);
				if(gmethods.isElementVisible(TdlCromaCard.get().activityTab, 30)) {
					fUtil.flogResult("Passed", "Card Open", "Croma Card Opened", 1);
					
					if(gmethods.isElementVisible(TdlCromaCard.get().CardTransactAmt, 20)) {
				    	String transactionAmt1= TdlCromaCard.get().CardTransactAmt.getText().replace("\u20B9","").trim();
				    	double transactionAmt=DecimalFormat.getNumberInstance().parse(transactionAmt1).doubleValue();
				    	if(transactionAmt==Math.round(totalCartAmount)) {
				    		fUtil.flogResult("Passed", "Croma Transaction Amount Check", "Transaction amount is correct"+" as Expected:"+totalCartAmount+" is equal to Actual:"+transactionAmt, 1);
				    	}else
				    		fUtil.flogResult("Failed", "Croma Transaction Amount Check",  "Transaction amount is correct"+" as Expected:"+totalCartAmount+" is equal not to Actual:"+transactionAmt, 1);
				    	
				    }
					
					
				/*String todaysDate=currentdate();
					Thread.sleep(10000);
					String transactionDateXpath="//*[contains(text()='"+todaysDate+"']";
					boolean dateVisible=gmethods.isElementVisibleXpath(transactionDateXpath,20);
					if(dateVisible) {
				    	if(gmethods.isElementVisible(TdlCromaCard.get().CardTransactAmt, 30)) {
				    		String trasactedAmt=TdlCromaCard.get().CardTransactAmt.getText();
				    		fUtil.flogResult("Passed", "Transaction Details", "Tata Cliq transaction is visible on card", 1);


				    	}else {
				    		fUtil.flogResult("Failed", "Transaction Details", "Tata Cliq transaction is not visible on card", 1);
				    	}
				    }
				    */

					//Close Tata Cliq Card
					TdlCromaCard.get().offerCloseaftersignIn.click();
					Thread.sleep(2000);

				}
				else {
					fUtil.flogResult("Failed", "Card Open", "Croma Card not Opened", 1);
				}
			}
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "Card validation",e.getMessage(), 0);
		}
	}

	@Test
	public void validateLuxuryHomePage() throws Exception{
		try {
			boolean titleHomepage=gmethods.isElementVisible(TdlCromaCard.get().LuxuryHomepageTitle, 40);
			boolean searchButton=gmethods.isElementVisible(TdlCromaCard.get().Luxury_searchicon, 20);
			if(titleHomepage && searchButton) {
				fUtil.flogResult("Passed","Validate SLP Fashion page loaded and search icon present", "SLP Fashion homepage loaded with title",1);
			}else {
				fUtil.flogResult("Failed","Validate SLP Fashion page loaded and search icon present", "SLP Fashion homepage not loaded properly",1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP Fashion page loaded", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void UserLoginTataCliqLuxury() throws Exception{
		try {

			Thread.sleep(5000);
			if(gmethods.isElementVisible(TdlCromaCard.get().Luxurymyaccounticon,50))
			{

				fUtil.flogResult("Passed", "Validate User Auto Logged in","Validate USer Auto Logged in",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate USer Auto Logged in", 
						"Validate USer not Auto Logged in",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Order Summary", 
					"Order Summary in croma failed due to:"+e.getMessage(), 1);
		}
	}

	@Test
	public void clickSearchButtonCliqLuxury() throws Exception{
		try {
			String productid=fUtil.fgetDataNew1("Product_Id");
			if(gmethods.isElementVisible(TdlCromaCard.get().Luxury_searchicon, 30)) {
				TdlCromaCard.get().Luxury_searchicon.click();
				Thread.sleep(5000);
				if(gmethods.isElementVisible(TdlCromaCard.get().searchsendCliqLuxury, 30)) {
					TdlCromaCard.get().searchsendCliqLuxury.sendKeys(productid);
					TdlCromaCard.get().searchsendCliqLuxury.sendKeys(Keys.ENTER);
				}
			}else {
				fUtil.flogResult("Failed", "Validate Search button on TATA Cliq", "Search button on TATA Cliq not found", 1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectProductCliqLuxury() throws Exception{
		try {

			//BrowserFactory.webDriver.get().switchTo().frame(0);
			if(gmethods.isElementVisible(TdlCromaCard.get().productCliqLuxury,30))
			{
				Thread.sleep(5000);
				Thread.sleep(5000);
				Actions action =new Actions(BrowserFactory.webDriver.get());
				action.moveToElement(TdlCromaCard.get().productCliqLuxury).click().build().perform();

				fUtil.flogResult("Passed", "click a popular product in cliq page", 
						"clicked a popular product in cliq successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "click a popular product in cliq page", 
						"Not clicked a popular product in Cliq page",1);
			}
			parentWindow = BrowserFactory.webDriver.get().getWindowHandle();
		}catch(Exception e) {
			fUtil.flogResult("Failed", "click a popular product in cliq", 
					"Not click a popular product in cliq failed due to:"+e.getMessage(), 1);
		}
	}


	@Test
	public void selectSizeCliqLuxury() throws Exception{
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			Set<String> handles=BrowserFactory.webDriver.get().getWindowHandles();
			for(String windowHandle  : handles)
			{
				if(!windowHandle.equals(parentWindow))
				{
					BrowserFactory.webDriver.get().switchTo().window(windowHandle);
				}
			}
			if(paymentmethod.equalsIgnoreCase("Cliqcash")) {

				if(gmethods.isElementVisible(TdlCromaCard.get().sizeCliqLuxury,20)) {
					fUtil.flogResult("Passed","Validate size option", "Size: "+TDL_SLPElectronicsPage.get().sizeCliqLuxury.getText()+"selected successfully", 1);
					TdlCromaCard.get().sizeCliqLuxury.click();
					gmethods.scrollToViewElement(TdlCromaCard.get().featuresluxury);
				}
			}
			
           else if(paymentmethod.equalsIgnoreCase("emi")) {
        	   
        	   if(gmethods.isElementVisible(TdlCromaCard.get().sizeCliqLuxury,30)) {
					fUtil.flogResult("Passed","Validate size option", "Size: "+TDL_SLPElectronicsPage.get().sizeCliqLuxury.getText()+"selected successfully", 1);
					TdlCromaCard.get().sizeCliqLuxury.click();
					gmethods.scrollToViewElement(TdlCromaCard.get().featuresluxury);
				}
			}
			
			else {

				if(gmethods.isElementVisible(TdlCromaCard.get().sizeCliqLuxury,30)) {
					fUtil.flogResult("Passed","Validate size option", "Size: "+TDL_SLPElectronicsPage.get().sizeCliqLuxury.getText()+"selected successfully", 1);
					TdlCromaCard.get().sizeCliqLuxury.click();
					gmethods.scrollToViewElement(TdlCromaCard.get().featuresluxury);
				}
			}
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void clickBuyNowCliqLuxury() throws Exception{
		try {

			Thread.sleep(5000);
			Thread.sleep(5000);
			gmethods.scrollTillElmVisible_Web(TdlCromaCard.get().buyNowCliqluxury, "down");
			boolean BuyNow =gmethods.isElementVisible(TdlCromaCard.get().buyNowCliqluxury,10);
			if(BuyNow == true)
			{
				TdlCromaCard.get().buyNowCliqluxury.click();
				fUtil.flogResult("Passed", "Click Buy now in cliq page", 
						"Clicked Buy now in cliq page successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Click Buy now in cliq page", 
						"Not Clicked Buy now in cliq page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click Buy now in croma page", 
					"Not Clicked Buy now in croma page failed due to:"+e.getMessage(), 1);
		}
	}

	@Test
	public void clickCheckoutCliqLuxury() throws Exception{
		try {
			Thread.sleep(5000);
			Thread.sleep(5000);

			//Select sel=new Select(TdlCromaCard.get().item_quantityluxury);
			//sel.selectByVisibleText("5");
			
			boolean checkout =gmethods.isElementVisible(TdlCromaCard.get().checkoutCliqluxury,10);
			if(checkout == true)
			{
				TdlCromaCard.get().checkoutCliqluxury.click();
				fUtil.flogResult("Passed", "Click Checkout in cliq page", 
						"Clicked Checkout in cliq page successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Click Checkout in cliq page", 
						"Not Clicked Checkout in cliq page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click Checkout in cliq page", 
					"Not Clicked Checkout in cliqa page failed due to:"+e.getMessage(), 1);
		}
	}

	@Test
	public void ValidateAddressCliqLuxury() throws Exception{
		try {


			if(gmethods.isElementVisible(TdlCromaCard.get().addAddressluxury,30))						
			{ 

				clickContnueCliq();

			}
			else if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().fnameCliq,30))
			{
				AddressPageCliq();
				clickSaveContnueCliq();
				clickContnueCliq();

			}
			else if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().shippingAddressCliqLuxury,30))
			{
				fUtil.flogResult("Passed", "Validate  Address","Address : "+ TDL_SLPElectronicsPage.get().shippingAddressTextCliqLuxury.getText() +" Validated Successfully", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate  Address",
						"Not validated address", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Address validation cliq", 
					"Address validation cliq failed due to:"+e.getMessage(), 1);
		}
	}

	@Test
	public void orderdetailsCliqLuxury() throws Exception{
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String paymentmode=fUtil.fgetDataNew1("Multitender");
			Thread.sleep(5000);
			//gmethods.scrollToViewElement(TdlCromaCard.get().BagTotalCliqluxury);
			if(gmethods.isElementVisible(TdlCromaCard.get().BagTotalCliqluxury,20)) {
				fUtil.flogResult("Passed", "Validate Order details, Bag Total","Bag Total: "+TdlCromaCard.get().BagTotalCliqluxury.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Shipping","Shipping: "+TdlCromaCard.get().shippingCliqluxury.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Discount","Discount: "+TdlCromaCard.get().discountCliqluxury.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Bag Total Pay","Bag Total Pay: "+TdlCromaCard.get().totalPayCliqluxury.getText(), 1);

				String shipping=TdlCromaCard.get().shippingCliqluxury.getText().replace("\u20B9" , " ").trim();
				double shippingtotal=Double.parseDouble(shipping);
						
				if(paymentmethod.equalsIgnoreCase("TcpPoints")) {
					String points=TDL_SLPElectronicsPage.get().loyaltyappliedCliq.getText().replace("\u20B9" , " ").replace("-", " ").trim();
					pointsredeemed=Double.parseDouble(points);
				}
				else if(paymentmethod.equalsIgnoreCase("Cliqcash")){
					String cash=TDL_SLPElectronicsPage.get().cliq_cash_applied.getText().replace("\u20B9" , " ").replace("-", " ").trim();
					double totalpayable1=Double.parseDouble(cash);
					totalpayableCliq=totalpayable1-shippingtotal;
				}
				else if(paymentmode.equalsIgnoreCase("Multitender_loyaltypoints")){
					String points=TDL_SLPElectronicsPage.get().loyaltyappliedCliq.getText().replace("\u20B9" , " ").replace("-", " ").trim();
					pointsredeemed=Double.parseDouble(points);
					String totalpayable=TdlCromaCard.get().totalPayCliqluxury.getText().replace("\u20B9" , " ").trim();
					double totalpayable1=Double.parseDouble(totalpayable);
					totalpayableCliq=totalpayable1-shippingtotal;
					fUtil.flogResult("Passed", "loyalty points validation", "points used: "+points, 1);
					//totalpayableCliq=Double.parseDouble(cash);
				}

				else if(paymentmode.equalsIgnoreCase("Multitender_Cliqcash")){
					String cash=TDL_SLPElectronicsPage_Mobile.get().cliqcash_applied.getText().replace("\u20B9" , " ").replace("-", " ").trim();

					String totalpayable=TdlCromaCard.get().totalPayCliqluxury.getText().replace("\u20B9" , " ").trim();
					double totalpayable1=Double.parseDouble(totalpayable);
					totalpayableCliq=totalpayable1-shippingtotal;
					fUtil.flogResult("passed", "cliq cash validation", "cliq cash used: "+cash, 1);
					//totalpayableCliq=Double.parseDouble(cash);
				}
				else {
					String totalpayable=TdlCromaCard.get().totalPayCliqluxury.getText().replace("\u20B9" , " ").trim();
					double totalpayable1=Double.parseDouble(totalpayable);
					totalpayableCliq=(totalpayable1)-(shippingtotal);
				}
			}else
				fUtil.flogResult("Failed","Validate Order details page Cliq", "order details page not available", 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validateDebitCardPaymentCliqLuxury() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String cardNumber=fUtil.fgetDataNew1("cardNumber");
			String cardName=fUtil.fgetDataNew1("cardName");
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().debitCliq,20))
			{
				TDL_SLPElectronicsPage.get().debitCliq.click();
				TdlCromaCard.get().debittnumberCliqluxury.sendKeys("5123456789012346");
				TdlCromaCard.get().expirymonthdebCliqluxury.click();


				Select sel = new Select(TdlCromaCard.get().expirymonthdebCliqluxury);
				Thread.sleep(8000);
				sel.selectByVisibleText("05");
				Thread.sleep(000);

				TdlCromaCard.get().expiryyeardebCliqluxury.click();

				Select sel1 = new Select(TdlCromaCard.get().expiryyeardebCliqluxury);
				Thread.sleep(8000);
				sel1.selectByVisibleText("2025");
				Thread.sleep(8000);

				TdlCromaCard.get().cardnamedebCliqluxury.sendKeys(cardName);
				TdlCromaCard.get().cvvdebCliqluxury.sendKeys("123");
				TdlCromaCard.get().paydebCliqluxury.click();
				if(paymentType.equalsIgnoreCase("Success"))
				{
					//					if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().carddetailsCliq, 20)) {
					//					TDL_SLPElectronicsPage.get().cardnumberCliq.sendKeys(cardNumber);
					//					TDL_SLPElectronicsPage.get().expiryCliq.sendKeys("0525");
					//					TDL_SLPElectronicsPage.get().cardmembernameCliq.sendKeys(cardName);
					//					TDL_SLPElectronicsPage.get().cvvnumberCliq.sendKeys("123");
					//					TDL_SLPElectronicsPage.get().proceedCLiq.click();
					ClickAxisPasswordCroma();

					//TdlBPPayments_Mobile.get().successBtn_android.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed payment using credit card",
							"Successfully completed payment using credit card ", 1);
				}
				else
				{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
						"Successfully completed payment on failure case using credit card", 1);
				}
			}
			else
			{
				fUtil.flogResult("Failed", "Validate Credit card payment",
						"Credit card payment failed", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void validateCreditCardPaymentCliqLuxury() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String cardNumber=fUtil.fgetDataNew1("cardNumber");
			String cardName=fUtil.fgetDataNew1("cardName");
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().creditCliq,20))
			{
				TDL_SLPElectronicsPage.get().creditCliq.click();
				TdlCromaCard.get().debittnumberCliqluxury.sendKeys("5123456789012346");
				TdlCromaCard.get().expirymonthdebCliqluxury.click();


				Select sel = new Select(TdlCromaCard.get().expirymonthdebCliqluxury);
				Thread.sleep(8000);
				sel.selectByVisibleText("05");
				Thread.sleep(000);

				TdlCromaCard.get().expiryyeardebCliqluxury.click();

				Select sel1 = new Select(TdlCromaCard.get().expiryyeardebCliqluxury);
				Thread.sleep(8000);
				sel1.selectByVisibleText("2025");
				Thread.sleep(8000);

				TdlCromaCard.get().cardnamedebCliqluxury.sendKeys(cardName);
				TdlCromaCard.get().cvvdebCliqluxury.sendKeys("123");
				TdlCromaCard.get().paydebCliqluxury.click();
				if(paymentType.equalsIgnoreCase("Success"))
				{
					//					if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().carddetailsCliq, 20)) {
					//					TDL_SLPElectronicsPage.get().cardnumberCliq.sendKeys(cardNumber);
					//					TDL_SLPElectronicsPage.get().expiryCliq.sendKeys("0525");
					//					TDL_SLPElectronicsPage.get().cardmembernameCliq.sendKeys(cardName);
					//					TDL_SLPElectronicsPage.get().cvvnumberCliq.sendKeys("123");
					//					TDL_SLPElectronicsPage.get().proceedCLiq.click();
					ClickAxisPasswordCroma();

					//TdlBPPayments_Mobile.get().successBtn_android.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed payment using credit card",
							"Successfully completed payment using credit card ", 1);
				}
				else
				{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
						"Successfully completed payment on failure case using credit card", 1);
				}
			}
			else
			{
				fUtil.flogResult("Failed", "Validate Credit card payment",
						"Credit card payment failed", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}
	@Test
	public void expectedPointsEarnCliqLuxurySingleEligibleTender() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}
			else {
				//amount=totalpayableCliq;
				amount=totalCartAmount;
				//pointsUsed = Double.parseDouble(tcpPoints);
				double expectedPoints = amount*0.03;
				expectedEarnPromotionalPoints=amount*0.03;
				expectedEarnPromisedPoints = Math.round(expectedPoints);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points is:" + expectedEarnPromisedPoints,
						1);
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	@Test
	public void askMeLaterCliqLuxury() throws Exception{
		try {
			Thread.sleep(5000);
			Thread.sleep(5000);
			ArrayList<String> newTb = new ArrayList<String>(BrowserFactory.webDriver.get().getWindowHandles());
			// switch to new tab
			BrowserFactory.webDriver.get().switchTo().window(newTb.get(1));
			System.out.println("Page title of new tab: " + BrowserFactory.webDriver.get().getTitle());
			//				      //switch to parent window
			//				      BrowserFactory.webDriver.get().switchTo().window(newTb.get(0));
			boolean checkout =gmethods.isElementVisible(TdlCromaCard.get().laterCliqluxury,10);
			if(checkout == true)
			{
				TdlCromaCard.get().laterCliqluxury.click();
				fUtil.flogResult("Passed", "Click ask later in cliq page", 
						"Clicked ask later in cliq page successfully",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click ask latert in cliq page", 
					"Not Clicked ask latert in cliqa page failed due to:"+e.getMessage(), 1);
		}
	}

	@Test
	public void validateInternetBankingCliqLuxury() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");

			gmethods.scrollToViewElement(TdlCromaCard.get().codCliqluxury);
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().netBbCliq,15))
			{
				TDL_SLPElectronicsPage.get().netBbCliq.click();
			}
			gmethods.isElementVisible(TdlCromaCard.get().iciciCliqluxury, 10);
			TdlCromaCard.get().iciciCliqluxury.click();
			TdlCromaCard.get().paydebCliqluxury.click();
			Thread.sleep(8000);
			if(paymentType.equalsIgnoreCase("Success"))
			{
				TDL_SLPElectronicsPage.get().NetBankingSucces_TPM.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed", "Successfully completed payment",
						"Successfully completed payment", 1);
			}
			else
			{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
			Thread.sleep(3000);
			fUtil.flogResult("Passed", "Successfully completed Failure payment",
					"Successfully completed payment on failure case", 1);
			}

		}
		catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void validateLoyaltycliqLuxury() throws Exception {
		try {
			String LoyaltyPoints=fUtil.fgetDataNew1("Tcppoints_cutoff");
			//String paymentType=fUtil.fgetDataNew1("payment_type");
			String paymentmode=fUtil.fgetDataNew1("Multitender");
			TdlCromaCard.get().tataPayCliq_checkboxluxury.click();
			if(gmethods.isElementVisible(TdlCromaCard.get().placeOrderCliq_checkboxluxury,20))
			{
				TdlCromaCard.get().placeOrderCliq_checkboxluxury.click();
			}
			if (gmethods.isElementVisible(TdlCromaCard.get().tcpPointsCliq_checkboxluxury,20))
			{
				TdlCromaCard.get().tcpPointsCliq_checkboxluxury.click();
				Thread.sleep(3000);

				if(paymentmode.equalsIgnoreCase("Multitender_loyaltypoints")) {
					TdlCromaCard.get().tcpPointsEditCliqluxury.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Edit Tcp Points page is present",
							"Edit Tcp Points page is present", 1);

					TdlCromaCard.get().tcpPointsEnterCliqluxury.click();
					Thread.sleep(3000);
					TdlCromaCard.get().tcpPointsEnterCliqluxury.clear();
					Thread.sleep(3000);
					TdlCromaCard.get().tcpPointsEnterCliqluxury.sendKeys(LoyaltyPoints);
					Thread.sleep(3000);
					TdlCromaCard.get().tcpPointsredeemCliqluxury.click();
				}

			}
			else
				fUtil.flogResult("Failed", "Validate TCP Point payment",
						"TCP Point payment failed", 1);
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void validateEMIPaymentCliqLuxury() throws Exception {
		try {
			String paymentType=fUtil.fgetDataNew1("payment_type");
			String cardNumber=fUtil.fgetDataNew1("cardNumber");
			String cardName=fUtil.fgetDataNew1("cardName");

			gmethods.scrollToViewElement(TdlCromaCard.get().codCliqluxury);

			gmethods.isElementVisible(TdlCromaCard.get().emiCliqluxury, 35);
			TdlCromaCard.get().emiCliqluxury.click();

			Select sel = new Select(TdlCromaCard.get().emi_bank_select_Cliqluxury);
			sel.selectByVisibleText("ICICI Bank");

			gmethods.isElementVisible(TdlCromaCard.get().emi_tenure_select_Cliqluxury,25);
			TdlCromaCard.get().emi_tenure_select_Cliqluxury.click();
			Thread.sleep(5000);

			TdlCromaCard.get().debittnumberCliqluxury.sendKeys("5123456789012346");
			TdlCromaCard.get().expirymonthdebCliqluxury.click();


			Select sel1 = new Select(TdlCromaCard.get().expirymonthdebCliqluxury);
			Thread.sleep(5000);
			sel1.selectByVisibleText("05");
			Thread.sleep(5000);

			TdlCromaCard.get().expiryyeardebCliqluxury.click();

			Select sel2 = new Select(TdlCromaCard.get().expiryyeardebCliqluxury);
			Thread.sleep(5000);
			sel2.selectByVisibleText("2025");
			Thread.sleep(5000);

			TdlCromaCard.get().cardnamedebCliqluxury.sendKeys(cardName);
			TdlCromaCard.get().cvvdebCliqluxury.sendKeys("123");
			
			gmethods.scrollToViewElement(TdlCromaCard.get().codCliqluxury);
			TdlCromaCard.get().paydebCliqluxury.click();

			if(paymentType.equalsIgnoreCase("Success"))
			{
				ClickAxisPasswordCroma();
				//TdlBPPayments_Mobile.get().successBtn_android.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed", "Successfully completed payment using credit card",
						"Successfully completed payment using credit card ", 1);
			}
			else
			{	TDL_SLPElectronicsPage.get().failure_button_razopay.click();
			Thread.sleep(3000);
			fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
					"Successfully completed payment on failure case using credit card", 1);
			}
		}

		catch (Exception exe) {
			exe.printStackTrace();
		}
	}


	public String currentdate() throws Exception{

		String formattedDate ="";
		try {
			LocalDate date=java.time.LocalDate.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yy");
			formattedDate = date.format(myFormatObj);
			System.out.println(formattedDate);
		} catch (Exception e) {

		}


		return formattedDate;

	}

	@Test
	public void validateFitnessHomePage() throws Exception{
		try {
			switchToNewTab();
			boolean titleHomepage=gmethods.isElementVisible(TdlCromaCard.get().fitnessHomepageTitle, 20);
			//boolean searchButton=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButton, 20);
			if(titleHomepage) {
				fUtil.flogResult("Passed","Validate SLP Fashion page loaded and search icon present", "SLP Fashion homepage loaded with title: "+TdlCromaCard.get().fitnessHomepageTitle.getText(),1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP Fashion page loaded", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	@Test
	public void validateBeutyHomePage() throws Exception{
		try {
			//switchToNewTab();
			boolean titleHomepage=gmethods.isElementVisible(TdlCromaCard.get().beutyHomepageTitle, 20);
			//boolean searchButton=gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButton, 20);
			if(titleHomepage) {
				fUtil.flogResult("Passed","Validate SLP Fashion page loaded and search icon present", "SLP Fashion homepage loaded with title: "+TdlCromaCard.get().beutyHomepageTitle.getText(),1);
			}

		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP Fashion page loaded", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void clickheroBanner() throws Exception {
		try {
			//String Bannerjourney = fUtil.fgetDataNew1("Journey");

			if(gmethods.isElementVisible(TdlCromaCard.get().heroBannerShopNowBtn,20)) {
				TdlCromaCard.get().heroBannerShopNowBtn.click();
			}
			//

		} catch (Exception e) {
			fUtil.flogResult("Failed", "heroBannerSelectionSLP ",
					"Exception while selecting in Hero banner page in SLP" + e.getMessage(), 1);
		}
	}


	@Test
	public void askMeLaterCliq() throws Exception {
		try {
			Thread.sleep(5000);
			Thread.sleep(5000);
			//ArrayList<String> newTb = new ArrayList<String>(BrowserFactory.webDriver.get().getWindowHandles());
			// switch to new tab
			//BrowserFactory.webDriver.get().switchTo().window(newTb.get(1));
			switchToNewTab();
			System.out.println("Page title of new tab: " + BrowserFactory.webDriver.get().getTitle());
			//				      //switch to parent window
			//				      BrowserFactory.webDriver.get().switchTo().window(newTb.get(0));
			boolean checkout = gmethods.isElementVisible(TDL_SLPElectronicsPage.get().laterCliq, 10);
			if (checkout == true) {
				TDL_SLPElectronicsPage.get().laterCliq.click();
				fUtil.flogResult("Passed", "Click ask later in cliq page",
						"Clicked ask later in cliq page successfully", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Click ask latert in cliq page",
					"Not Clicked ask latert in cliqa page failed due to:" + e.getMessage(), 1);
		}
	}

	//To check User Loggedin Tatacliq
	@Test
	public void UserLoginTataCliq() throws Exception{
		try {

			Thread.sleep(5000);
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().Loged,50))
			{
				String log = TDL_SLPElectronicsPage.get().Loged.getText();
				if(!log.equalsIgnoreCase("SignIn/SignUp"))
				{
					fUtil.flogResult("Passed", "Validate User Auto Logged in", 
							"Validate USer Auto Logged in",1);
				}
				else
				{
					fUtil.flogResult("Failed", "Validate USer Auto Logged in", 
							"Validate USer not Auto Logged in",1);
				} 
			}
			else
			{
				fUtil.flogResult("Failed", "Validate USer Auto Logged in", 
						"Validate USer not Auto Logged in",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Order Summary", 
					"Order Summary in croma failed due to:"+e.getMessage(), 1);
		}
	}
	/*===================================================================================================
	 * Loyalty Points Calculation for Multiple Line items Checkout	
	 *
	 * ==================================================================================================
	 */


	@Test
	public void clickSearchButtonCliqMultiple(int i,String[] productName) throws Exception{
		try {

			if(gmethods.isElementVisible(TdlCromaCard.get().searchButtonCliq, 30)) {
				TdlCromaCard.get().searchButtonCliq.click();
				Thread.sleep(1000);
				if(gmethods.isElementVisible(TdlCromaCard.get().searchButtonCliq, 30)) {
					TdlCromaCard.get().searchButtonCliq.sendKeys(productName[i]);
					TdlCromaCard.get().searchButtonCliq.sendKeys(Keys.ENTER);

				}
			}else {
				fUtil.flogResult("Failed", "Validate Search button on TATA Cliq", "Search button on TATA Cliq not found", 1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectProductCliqMultiple() throws Exception{
		try {

			//BrowserFactory.webDriver.get().switchTo().frame(0);
			if(gmethods.isElementVisible(TdlCromaCard.get().productCliq,30))
			{
				//Thread.sleep(5000);
				Thread.sleep(3000);
				Actions action =new Actions(BrowserFactory.webDriver.get());
				action.moveToElement(TdlCromaCard.get().productCliq).click().build().perform();

				fUtil.flogResult("Passed", "click a popular product in cliq page", 
						"clicked a popular product in cliq successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "click a popular product in cliq page", 
						"Not clicked a popular product in Cliq page",1);
			}
			//				parentWindow = BrowserFactory.webDriver.get().getWindowHandle();
		}catch(Exception e) {
			fUtil.flogResult("Failed", "click a popular product in cliq", 
					"Not click a popular product in cliq failed due to:"+e.getMessage(), 1);
		}
	}

	@Test
	public void selectSizeCliqMultiple(int i) throws Exception{
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			Set<String> handles = BrowserFactory.webDriver.get().getWindowHandles();
			int tabNumber=handles.size()-1;
			if (handles.size() > tabNumber) {
				BrowserFactory.webDriver.get().switchTo().window((String) handles.toArray()[tabNumber]);
				System.out.println("Switched to Tab " + tabNumber);
			}else {
				fUtil.flogResult("Failed", "Validate switching to Tab: "+(tabNumber+1), "Tab not present", 1);
			}
			if(paymentmethod.equalsIgnoreCase("Cliqcash")) {
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().sizeCliqcash,20)) {
					fUtil.flogResult("Passed","Validate size option", "Size: "+TDL_SLPElectronicsPage.get().sizeCliq.getText()+"selected successfully", 1);
					TDL_SLPElectronicsPage.get().sizeCliqcash.click();
				}
			}else if(i>1) {
				System.out.println("Sixe selection Not required");
				}
			else {
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().sizeCliq,20)) {
					fUtil.flogResult("Passed","Validate size option", "Size: "+TDL_SLPElectronicsPage.get().sizeCliq.getText()+"selected successfully", 1);
					TDL_SLPElectronicsPage.get().sizeCliq.click();
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void clickAddCartCliqMultiple(int i) throws Exception{
		try {

			//Thread.sleep(5000);
			Thread.sleep(3000);
			boolean BuyNow =gmethods.isElementVisible(TdlCromaCard.get().addCartCliq,10);
			if(BuyNow == true)
			{
				TdlCromaCard.get().addCartCliq.click();
				fUtil.flogResult("Passed", "Click Add to Bag in cliq page", 
						"Clicked Add to Bag in cliq page successfully",1);
				if(gmethods.isElementVisible(TdlCromaCard.get().goToBagCliq,10) && (i!=2 |i!=3)) {
					fUtil.flogResult("Passed", "Add to Cart Check", 
							"Item added to the bag successfully",1);
				}
				else if(i!=2 |i!=3){
					fUtil.flogResult("Passed", "Add to Cart Check", 
								"Item added to the bag successfully",1);
					}
				else if(gmethods.isElementVisible(TdlCromaCard.get().productAlreadyInCartPopUp,10)) {
					TdlCromaCard.get().cancelBtn.click();
				}else {
					fUtil.flogResult("Failed", "Add to Cart Check", 
							"Item not added to the bag",1);
				}
			}
			else
			{
				fUtil.flogResult("Failed", "Click Add to Bag in cliq page", 
						"Not Clicked Add to Bag in cliq page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click Add to Bag in croma page", 
					"Not Clicked Add to Bag in croma page failed due to:"+e.getMessage(), 1);
		}
	}


	//Click Checkout Cliq page
	@Test
	public void clickCheckoutCliq() throws Exception{
		try {
			Thread.sleep(5000);
			Thread.sleep(5000);

			boolean checkout =gmethods.isElementVisible(TDL_SLPElectronicsPage.get().checkouCliq,10);
			if(checkout == true)
			{
				TDL_SLPElectronicsPage.get().checkouCliq.click();
				fUtil.flogResult("Passed", "Click Checkout in cliq page", 
						"Clicked Checkout in cliq page successfully",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Click Checkout in cliq page", 
						"Not Clicked Checkout in cliq page",1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Click Checkout in cliq page", 
					"Not Clicked Checkout in cliqa page failed due to:"+e.getMessage(), 1);
		}
	}

	//To add address for first time user and existing user in cliq page
	@Test
	public void ValidateAddressCliq() throws Exception{
		try {


			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().addAddress,30))						
			{ 

				clickContnueCliq();

			}
			else if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().fnameCliq,30))
			{
				AddressPageCliq();
				clickSaveContnueCliq();
				clickContnueCliq();

			}
			else
			{
				fUtil.flogResult("Failed", "Validate  Address",
						"Not validated address", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Address validation cliq", 
					"Address validation cliq failed due to:"+e.getMessage(), 1);
		}
	}
    //(dependsOnMethods= {"UserLoginTataCliq"})
	/**
	 * @throws Exception
	 */
	@Test
	public void addingMultipleProductsCliq() throws Exception {
		try {
			double priceSumOfItems = 0.0;
			double totalPriceAtCheckOutMultiple = 0.0;
			String[] productName = fUtil.fgetDataNew1("Product_Id_list").trim().split(",");

			// For loop to add multiple products
			for (int i = 0; i < productName.length; i++) {
				clickSearchButtonCliqMultiple(i, productName);
				selectProductCliqMultiple();
				selectSizeCliqMultiple(i);
				clickAddCartCliqMultiple(i);
				if (i == productName.length - 1) {
					System.out.println("Added all the products to cart");
				}
			}

			// Go to Cart Page
			if (gmethods.isElementVisible(TdlCromaCard.get().cartCliq, 10)) {
				TdlCromaCard.get().cartCliq.click();
			}

			// CheckOut Final Page before payment
			try {
				Thread.sleep(5000);
				Thread.sleep(5000);
				if (gmethods.isElementVisible(TdlCromaCard.get().totalPayableAtCheckOut, 10)) {
					String totalPriceAtCheckOutMultiple1 = TdlCromaCard.get().totalPayableAtCheckOut.getText()
							.replace("\u20B9", " ").trim();
					totalPriceAtCheckOutMultiple = Double.parseDouble(totalPriceAtCheckOutMultiple1);
				}

				boolean checkout = gmethods.isElementVisible(TDL_SLPElectronicsPage.get().checkouCliq, 10);
				if (checkout == true) {
					String productname = null;
					String productPrice1;
					String productPrice2;
					double productPrice = 0;
					for (int j = 0; j < productName.length; j++) {
						if (gmethods.isElementVisible(TdlCromaCard.get().lineItemNameCliq.get(j), 10)) {
							gmethods.scrollToViewElement(TdlCromaCard.get().lineItemNameCliq.get(j));
						}
						Thread.sleep(2000);

						productname = TdlCromaCard.get().lineItemNameCliq.get(j).getText().trim();
						productPrice1 = TdlCromaCard.get().lineItemPriceCliq.get(j).getText().replace("\u20B9", " ")
								.trim();
						// productPrice2=productPrice1[0];
						productPrice = Double.parseDouble(productPrice1);
						productNameList.add(productname);
						productPriceList.add(productPrice);
						totalpayableCliqMultipleItem = totalpayableCliqMultipleItem + productPrice;

						if (totalpayableCliqMultipleItem == totalPriceAtCheckOutMultiple) {
							fUtil.flogResult("Passed", "cliq page",
									"Total Payable price of Items =" + totalpayableCliqMultipleItem, 1);
						}

					}
					// Click CheckOut
					clickCheckoutCliq();
					// Click Comtinue in Address Page
					ValidateAddressCliq();

				} else {
					fUtil.flogResult("Failed", "CheckOut page", "Not landed on checkout page", 1);
				}

			} catch (Exception e) {
				fUtil.flogResult("Failed", "Click  continue in cliq page",
						"Not Clicked continue in cliqa page failed due to:" + e.getMessage(), 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "addingMultipleProductsClicq method",
					"addingMultipleProductsClicq failed due to:" + e.getMessage(), 1);
		}

	}

	/*
	@Test
	public void addingMultipleProductsCliq() throws Exception {
		try {
			double priceSumOfItems=0.0;
			double totalPriceAtCheckOutMultiple=0.0;
			String[] productName = fUtil.fgetDataNew1("Product_Id_list").trim().split(",");

			//For loop to add multiple products
			for (int i = 0; i < productName.length; i++) {
				clickSearchButtonCliqMultiple(i, productName);
				selectProductCliqMultiple();
				selectSizeCliqMultiple(i);
				clickAddCartCliqMultiple(i);
				if (i == productName.length-1) {
					System.out.println("Added all the products to cart");
				}
			}

			//Go to Cart Page 
			if (gmethods.isElementVisible(TdlCromaCard.get().cartCliq, 10)) {
				TdlCromaCard.get().cartCliq.click();
			}

			

			// CheckOut Final Page before payment
			try {
				Thread.sleep(5000);
				Thread.sleep(5000);
				if( gmethods.isElementVisible(TdlCromaCard.get().totalPayableAtCheckOut, 10)) {
					String totalPriceAtCheckOutMultiple1=TdlCromaCard.get().totalPayableAtCheckOut.getText().replace("\u20B9" , " ").trim();
					totalPriceAtCheckOutMultiple =Double.parseDouble(totalPriceAtCheckOutMultiple1);
				}

				boolean checkout = gmethods.isElementVisible(TDL_SLPElectronicsPage.get().checkouCliq, 10);
				if (checkout == true) {
					String productname = null;
					String[] productPrice1;
					String productPrice2;
					double productPrice = 0;
					for(int j=0;j<productName.length;j++) {
						if(gmethods.isElementVisible(TdlCromaCard.get().lineItemDetailsCliq.get(5*j), 10)) {
							gmethods.scrollToViewElement(TdlCromaCard.get().lineItemDetailsCliq.get(5*j));
						}
						Thread.sleep(2000);
						if(productName.length<=3) {
						productname=TdlCromaCard.get().lineItemDetailsCliq.get(5*j).getText().trim();
						productPrice1=TdlCromaCard.get().lineItemDetailsCliq.get(5*j+1).getText().replace("\u20B9" , " ").trim().split(" ");
						productPrice2=productPrice1[0];
						productPrice=Double.parseDouble(productPrice2);
						System.out.println( productname+" = "+productPrice);
						}
						
						if(productName.length>3){
							if(j<3) {
							productname=TdlCromaCard.get().lineItemDetailsCliq.get(5*j).getText().trim();
							productPrice1=TdlCromaCard.get().lineItemDetailsCliq.get(5*j+1).getText().replace("\u20B9" , " ").trim().split(" ");
							productPrice2=productPrice1[0];
							productPrice=Double.parseDouble(productPrice2);
							System.out.println( productname+" = "+productPrice);
							}else {
								productname=TdlCromaCard.get().lineItemDetailsCliq.get(5*j-1).getText().trim();
								productPrice1=TdlCromaCard.get().lineItemDetailsCliq.get(5*j).getText().replace("\u20B9" , " ").trim().split(" ");
								productPrice2=productPrice1[0];
								productPrice=Double.parseDouble(productPrice2);
								System.out.println( productname+" = "+productPrice);
							}
						}
						productNameList.add(productname);
						productPriceList.add(productPrice);
						totalpayableCliqMultipleItem=totalpayableCliqMultipleItem+productPrice;
					}
					if( totalpayableCliqMultipleItem==totalPriceAtCheckOutMultiple) {
						fUtil.flogResult("Passed", "cliq page", "Total Payable price of Items =", 1);
						 }
					

					
					  if( totalpayableCliqMultipleItem==totalPriceAtCheckOutMultiple) {
					  fUtil.flogResult("Passed", "cliq page", "Total Payable price of Items =", 1);
					  } gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().contCliq);
					  Thread.sleep(2000); TDL_SLPElectronicsPage.get().contCliq.click();
					 fUtil.flogResult("Passed", "Click  continue Cliq in cliq page",
					  "Clicked  continue in cliq page successfully", 1);
					 
				} else {
					fUtil.flogResult("Failed", "Click  continue in cliq page", "Not Clicked continue in cliq page", 1);
				}

			} catch (Exception e) {
				fUtil.flogResult("Failed", "Click  continue in cliq page",
						"Not Clicked continue in cliqa page failed due to:" + e.getMessage(), 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "addingMultipleProductsClicq method",
					"addingMultipleProductsClicq failed due to:" + e.getMessage(), 1);
		}

	}
	*/
	
	@Test
	public void orderdetailsCliq() throws Exception{
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String paymentmode=readData("Multitender");
			Thread.sleep(5000);
			gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().BagTotalCliq);
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().BagTotalCliq,20)) {
				fUtil.flogResult("Passed", "Validate Order details, Bag Total","Bag Total: "+TDL_SLPElectronicsPage.get().BagTotalCliq.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Shipping","Shipping: "+TDL_SLPElectronicsPage.get().shippingCliq.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Bag SubTotal","Bag SubTotal: "+TDL_SLPElectronicsPage.get().bagSubtotalCliq.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Discount","Discount: "+TDL_SLPElectronicsPage.get().discountCliq.getText(), 1);
				fUtil.flogResult("Passed", "Validate Order details, Bag Total Pay","Bag Total Pay: "+TDL_SLPElectronicsPage.get().totalPayCliq.getText(), 1);

				String shipCharge=TDL_SLPElectronicsPage.get().shippingCliq.getText().replace("\u20B9" , " ").trim();
				shippingCharge=Double.parseDouble(shipCharge);
				
				if(paymentmethod.equalsIgnoreCase("TcpPoints")) {
					String points=TdlCromaCard.get().loyaltyappliedCliq.getText().replace("-", " ").replace("\u20B9" , " ").trim();
					pointsredeemed=Double.parseDouble(points);
					totalTransactionAmtCliq=pointsredeemed;
				}
				else if(paymentmethod.equalsIgnoreCase("Cliqcash")){
					String cash=TDL_SLPElectronicsPage.get().cliq_cash_applied.getText().replace("\u20B9" , " ").replace("-", " ").trim();
					totalpayableCliq=Double.parseDouble(cash);
					totalTransactionAmtCliq=Double.parseDouble(cash);
				}
				else if(paymentmode.equalsIgnoreCase("Multitender_loyaltypoints")){
					String points=TdlCromaCard.get().loyaltyappliedCliq.getText().replace("\u20B9" , " ").replace("-", " ").trim();
					pointsredeemed=Double.parseDouble(points);
					String totalpayable=TDL_SLPElectronicsPage.get().totalPayCliq.getText().replace("\u20B9" , " ").trim();
					totalpayableCliq=Double.parseDouble(totalpayable);
					fUtil.flogResult("Passed", "loyalty points validation", "points used: "+points, 1);
					totalTransactionAmtCliq=pointsredeemed+totalpayableCliq;
				}

				else if(paymentmode.equalsIgnoreCase("Multitender_Cliqcash")){
					String cash=TdlCromaCard.get().cliqcash_applied.getText().replace("\u20B9" , " ").replace("-", " ").trim();

					String totalpayable=TDL_SLPElectronicsPage.get().totalPayCliq.getText().replace("\u20B9" , " ").trim();
					totalpayableCliq=Double.parseDouble(totalpayable);
					fUtil.flogResult("Passed", "Cliq cash validation", "cliq cash used: "+cash, 1);
					cliqCashUsed=Double.parseDouble(cash);
					totalTransactionAmtCliq=cliqCashUsed+totalpayableCliq;
				}
				else {
					String totalpayable=TDL_SLPElectronicsPage.get().totalPayCliq.getText().replace("\u20B9" , " ").trim();
					totalTransactionAmtCliq=Double.parseDouble(totalpayable);
				}
			}else
				fUtil.flogResult("Failed","Validate Order details page Cliq", "order details page not available", 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static String readData(String input) {
		try {
			return fUtil.fgetDataNew1(input);
		} catch (Exception e) {
			return "";
		}
	}

	@Test
	public void expectedEarnCliqSingleTenderMultiProduct() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;
			String[] productName = fUtil.fgetDataNew1("Product_Id_list").trim().split(",");

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}
			else {
			if(productName.length<3) {	
					double sportsPointsEarn=productPriceList.get(0)*0.01;
					double fashionPointsEarn=productPriceList.get(1)*0.01;
					
					amount=totalpayableCliq;
					
					//pointsUsed = Double.parseDouble(tcpPoints);
					expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn)) ;
					
					fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarn),
							0);
					fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarn),
							0);
					
					fUtil.flogResult("Passed", "Calculated Earn Points", "Expected Total earn points is:" + expectedEarnPromisedPoints,
								0);
			
			}else if(productName.length==3) {
			double sportsPointsEarn=productPriceList.get(0)*0.01;
			double fashionPointsEarn=productPriceList.get(1)*0.01;
			double beautyPointsEarn=productPriceList.get(2)*0.04;
			amount=totalpayableCliq;
			
			//pointsUsed = Double.parseDouble(tcpPoints);
			expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn));
			
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(2)+"="+Math.round(beautyPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected Total earn points is:" + expectedEarnPromisedPoints,
						0);
			}else {
				double sportsPointsEarn=productPriceList.get(0)*0.01;
				double fashionPointsEarn=productPriceList.get(1)*0.01;
				double jewelleryPointsEarn=productPriceList.get(2)*0.0;
				double beautyPointsEarn=productPriceList.get(3)*0.04;
				amount=totalpayableCliq;
				
				//pointsUsed = Double.parseDouble(tcpPoints);
				expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn));
				
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarn),
						0);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarn),
						0);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for jewelleryItem:"+productNameList.get(2)+"="+Math.round(jewelleryPointsEarn),
						0);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(3)+"="+Math.round(beautyPointsEarn),
						0);
				fUtil.flogResult("Passed", "Calculated Total Earn Points", "Expected Total earn points is:" + expectedEarnPromisedPoints,
							0);
				
			}
		}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	/*
	 * 
	 */
	@Test
	public void expectedEarnCliqSingleTenderMultiProductPromo() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;
			String[] productName = fUtil.fgetDataNew1("Product_Id_list").trim().split(",");

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}
			else {
			if(productName.length<3) {	
					double sportsPointsEarn=productPriceList.get(0)*0.01;
					double fashionPointsEarn=productPriceList.get(1)*0.01;
					
					amount=totalpayableCliq;
					
					//pointsUsed = Double.parseDouble(tcpPoints);
					expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn)) ;
					expectedEarnPromotionalPoints = (Math.round(productPriceList.get(0)*0.05) + Math.round(productPriceList.get(1)*0.05) + Math.round(shippingCharge)*0.05) ;
					
					fUtil.flogResult("Passed", "Calculated Earn Coins", "Expected earn Coins for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarn),
							0);
					fUtil.flogResult("Passed", "Calculated Earn Coins", "Expected earn Coins for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarn),
							0);
					
					fUtil.flogResult("Passed", "Calculated Earn Coins", "Expected Total earn Coins is:" + expectedEarnPromisedPoints,
								0);
					fUtil.flogResult("Passed", "Calculated Promotional Earn Coins", "Expected Total Promotional earn Coins is:" + expectedEarnPromotionalPoints,
							0);
			
			}else if(productName.length==3) {
			double sportsPointsEarn=productPriceList.get(0)*0.01;
			double fashionPointsEarn=productPriceList.get(1)*0.01;
			double beautyPointsEarn=productPriceList.get(2)*0.04;
			amount=totalpayableCliq;
			
			//pointsUsed = Double.parseDouble(tcpPoints);
			expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn));
			
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(2)+"="+Math.round(beautyPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected Total earn points is:" + expectedEarnPromisedPoints,
						0);
			}else {
				double sportsPointsEarn=productPriceList.get(0)*0.01;
				double fashionPointsEarn=productPriceList.get(1)*0.01;
				double jewelleryPointsEarn=productPriceList.get(2)*0.0;
				double beautyPointsEarn=productPriceList.get(3)*0.04;
				amount=totalpayableCliq;
				
				//pointsUsed = Double.parseDouble(tcpPoints);
				expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn));
				expectedEarnPromotionalPoints = Math.round(productPriceList.get(0)*0.05) + Math.round(productPriceList.get(1)*0.05) + Math.round(productPriceList.get(2)*0.05) + Math.round(productPriceList.get(3)*0.05)+ Math.round(shippingCharge)*0.05 ;
				
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarn),
						0);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarn),
						0);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for jewelleryItem:"+productNameList.get(2)+"="+Math.round(jewelleryPointsEarn),
						0);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(3)+"="+Math.round(beautyPointsEarn),
						0);
				fUtil.flogResult("Passed", "Calculated Total Earn Points", "Expected Total earn points is:" + expectedEarnPromisedPoints,
							0);
				fUtil.flogResult("Passed", "Calculated Promotional Earn Coins", "Expected Total Promotional earn Coins is:" + expectedEarnPromotionalPoints,
						0);
				
			}
		}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	
	
	@Test
	public void expectedEarnCliqMultiTenderMultiProduct() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;
			pointsUsed = Double.parseDouble(tcpPoints);
			double totalpayableAmt=totalpayableCliqMultipleItem +shippingCharge;
			double eligibleAmt = (totalpayableAmt -pointsUsed);

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}else {
			double itemPointsports=(productPriceList.get(0)/totalpayableAmt)*pointsUsed;
			double itemPointfashion=(productPriceList.get(1)/totalpayableAmt)*pointsUsed;
			double itemPointBeauty=(productPriceList.get(2)/totalpayableAmt)*pointsUsed;
			
			double itemamountsports=(productPriceList.get(0)/totalpayableAmt)*eligibleAmt;
			double itemamountfashion=(productPriceList.get(1)/totalpayableAmt)*eligibleAmt;
			double itemamountBeauty=(productPriceList.get(2)/totalpayableAmt)*eligibleAmt;
			
			double sportsPointsEarn=(productPriceList.get(0)/totalpayableAmt)*eligibleAmt*0.01;
			double fashionPointsEarn=(productPriceList.get(1)/totalpayableAmt)*eligibleAmt*0.01;
			double beautyPointsEarn=(productPriceList.get(2)/totalpayableAmt)*eligibleAmt*0.04;
			
			
			expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn));
			
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(2)+"="+Math.round(beautyPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Total Earn Points", "Expected Total earn points is:" + expectedEarnPromisedPoints,
					0);
		
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedEarnCliqMultiTenderMultiProduct ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	@Test
	public void expectedEarnCliqCashMTMP() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			//String cliqCash=fUtil.fgetDataNew1("CliqCashUsed").trim();
			//double amount=0.0;
			//cliqCashUsed = Double.parseDouble(cliqCash);
			double totalpayableAmt=totalpayableCliqMultipleItem +shippingCharge;
			double eligibleAmt = (totalpayableAmt -cliqCashUsed);

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}else {
			double itemCliqCashsports=(productPriceList.get(0)/totalpayableAmt)*cliqCashUsed;
			double itemCliqCashfashion=(productPriceList.get(1)/totalpayableAmt)*cliqCashUsed;
			double itemCliqCashBeauty=(productPriceList.get(2)/totalpayableAmt)*cliqCashUsed;
			
			double itemamountsports=(productPriceList.get(0)/totalpayableAmt)*eligibleAmt;
			double itemamountfashion=(productPriceList.get(1)/totalpayableAmt)*eligibleAmt;
			double itemamountBeauty=(productPriceList.get(2)/totalpayableAmt)*eligibleAmt;
			
			//CliqCash Earn
			double sportsPointsEarnCliqCash=itemCliqCashsports*0.01;
			double fashionPointsEarnCliqCash=itemCliqCashfashion*0.01;
			double beautyPointsEarnCliqCash=itemCliqCashBeauty*0.04;
			//Amount Earn
			double sportsPointsEarn=itemamountsports*0.01;
			double fashionPointsEarn=itemamountfashion*0.01;
			double beautyPointsEarn=itemamountBeauty*0.04;
		
			fUtil.flogResult("Passed", "CLiqCash Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarnCliqCash),
					0);
			fUtil.flogResult("Passed", "CLiqCash Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarnCliqCash),
					0);
			fUtil.flogResult("Passed", "CLiqCash Earn Points", "Expected earn points for beautyItem:"+productNameList.get(2)+"="+Math.round(beautyPointsEarnCliqCash),
					0);
			
		//	double pointEarnCliqCash=Math.round(sportsPointsEarnCliqCash) + Math.round(fashionPointsEarnCliqCash) + Math.round(beautyPointsEarnCliqCash);

		//	fUtil.flogResult("Passed", "Calculated TotalEarn Points from CliqCash", "Expected Total earn points is:" +pointEarnCliqCash,
		//			0);expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn) +Math.round(sportsPointsEarnCliqCash) + Math.round(fashionPointsEarnCliqCash) + Math.round(beautyPointsEarnCliqCash) );
			
			fUtil.flogResult("Passed",paymentmethod +" Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+(Math.round(sportsPointsEarn)),
					0);
			fUtil.flogResult("Passed",paymentmethod+ " Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+(Math.round(fashionPointsEarn)),
					0);
			fUtil.flogResult("Passed",paymentmethod+ " Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(2)+"="+(Math.round(beautyPointsEarn)),
					0);
			
			
			
			expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn) +Math.round(sportsPointsEarnCliqCash) + Math.round(fashionPointsEarnCliqCash) + Math.round(beautyPointsEarnCliqCash) );
			
			fUtil.flogResult("Passed",paymentmethod + " and CliqCash Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+(Math.round(sportsPointsEarn)+Math.round(sportsPointsEarnCliqCash)),
					0);
			fUtil.flogResult("Passed",paymentmethod + " and CliqCash Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+(Math.round(fashionPointsEarn)+Math.round(fashionPointsEarnCliqCash)),
					0);
			fUtil.flogResult("Passed",paymentmethod + " and CliqCash Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(2)+"="+(Math.round(beautyPointsEarn)+Math.round(beautyPointsEarnCliqCash)),
					0);
			
			fUtil.flogResult("Passed",paymentmethod + " Calculated Total Earn Points", "Expected Total earn points is:" +expectedEarnPromisedPoints,
					0);
		
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedEarnCliqCashMTMP ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	@Test
	public void expectedEarnCliqCashIneligibleMTMP() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String cliqCash=fUtil.fgetDataNew1("CliqCashUsed").trim();
			double amount=0.0;
			cliqCashUsed = Double.parseDouble(cliqCash);
			double totalpayableAmt=totalpayableCliqMultipleItem +shippingCharge;
			double eligibleAmt = (totalpayableAmt -cliqCashUsed);

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}else {
			double itemCliqCashsports=(productPriceList.get(0)/totalpayableAmt)*cliqCashUsed;
			double itemCliqCashfashion=(productPriceList.get(1)/totalpayableAmt)*cliqCashUsed;
			double itemPointJewellery=(productPriceList.get(2)/totalpayableAmt)*cliqCashUsed;
			double itemCliqCashBeauty=(productPriceList.get(3)/totalpayableAmt)*cliqCashUsed;
			
			double itemamountsports=(productPriceList.get(0)/totalpayableAmt)*eligibleAmt;
			double itemamountfashion=(productPriceList.get(1)/totalpayableAmt)*eligibleAmt;
			double itemamountJewellery=(productPriceList.get(2)/totalpayableAmt)*eligibleAmt;
			double itemamountBeauty=(productPriceList.get(3)/totalpayableAmt)*eligibleAmt;
			
			//CliqCash Earn
			double sportsPointsEarnCliqCash=itemCliqCashsports*0.01;
			double fashionPointsEarnCliqCash=itemCliqCashfashion*0.01;
			double jewelleryPointsEarnCliqCash=itemamountJewellery*0.0;
			double beautyPointsEarnCliqCash=itemCliqCashBeauty*0.04;
			//Amount Earn
			double sportsPointsEarn=itemamountsports*0.01;
			double fashionPointsEarn=itemamountfashion*0.01;
			double jewelleryPointsEarn=itemamountfashion*0.0;
			double beautyPointsEarn=itemamountBeauty*0.04;
			
			fUtil.flogResult("Passed", "CLiqCash Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarnCliqCash),
					0);
			fUtil.flogResult("Passed", "CLiqCash Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarnCliqCash),
					0);
			fUtil.flogResult("Passed", "CLiqCash Earn Points", "Expected earn points for beautyItem:"+productNameList.get(3)+"="+Math.round(beautyPointsEarnCliqCash),
					0);
			fUtil.flogResult("Passed", "CLiqCash Earn Points", "Expected earn points for jewelleryItem:"+productNameList.get(2)+"="+Math.round(jewelleryPointsEarnCliqCash),
					0);
			//double pointEarnCliqCash=Math.round(sportsPointsEarnCliqCash) + Math.round(fashionPointsEarnCliqCash) + Math.round(beautyPointsEarnCliqCash);

			//fUtil.flogResult("Passed", "Calculated TotalEarn Points from CliqCash", "Expected Total earn points is:" +pointEarnCliqCash,
			//		0);
			
			fUtil.flogResult("Passed",paymentmethod +" Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+(Math.round(sportsPointsEarn)),
					0);
			fUtil.flogResult("Passed",paymentmethod+ " Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+(Math.round(fashionPointsEarn)),
					0);
			fUtil.flogResult("Passed",paymentmethod+ " Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(3)+"="+(Math.round(beautyPointsEarn)),
					0);
			fUtil.flogResult("Passed",paymentmethod +" Calculated Earn Points", "Expected earn points for jewelleryItem(Ineligible for earn):"+productNameList.get(2)+"="+(jewelleryPointsEarn),
					0);
			
			expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn) +Math.round(sportsPointsEarnCliqCash) + Math.round(fashionPointsEarnCliqCash) + Math.round(beautyPointsEarnCliqCash) );
			
			fUtil.flogResult("Passed",paymentmethod +" and CliqCash Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+(Math.round(sportsPointsEarn)+Math.round(sportsPointsEarnCliqCash)),
					0);
			fUtil.flogResult("Passed",paymentmethod+ " and CliqCash Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+(Math.round(fashionPointsEarn)+Math.round(fashionPointsEarnCliqCash)),
					0);
			fUtil.flogResult("Passed",paymentmethod+ " and CliqCash Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(3)+"="+(Math.round(beautyPointsEarn)+Math.round(beautyPointsEarnCliqCash)),
					0);
			fUtil.flogResult("Passed",paymentmethod +" and CliqCash Calculated Earn Points", "Expected earn points for jewelleryItem(Ineligible for earn):"+productNameList.get(2)+"="+(jewelleryPointsEarn +jewelleryPointsEarnCliqCash),
					0);
			
			fUtil.flogResult("Passed", "Calculated Total Earn Points", "Expected Total earn points is:" + expectedEarnPromisedPoints,
					0);
		
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedEarnCliqCashIneligibleMTMP ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	/*
	 *MultiTenderIneligibleMultiProduct Without Promortional Earn Method
	 */
	@Test
	public void expectedEarnCliqMultiTenderIneligibleMultiProduct() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;
			pointsUsed = Double.parseDouble(tcpPoints);
			double totalpayableAmt=totalpayableCliqMultipleItem +shippingCharge;
			double eligibleAmt = (totalpayableAmt -pointsUsed);

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}else {
			double itemPointsports=(productPriceList.get(0)/totalpayableAmt)*pointsUsed;
			double itemPointfashion=(productPriceList.get(1)/totalpayableAmt)*pointsUsed;
			double itemPointBeauty=(productPriceList.get(2)/totalpayableAmt)*pointsUsed;
			double itemPointJewellery=(productPriceList.get(3)/totalpayableAmt)*pointsUsed;
			
			double itemamountsports=(productPriceList.get(0)/totalpayableAmt)*eligibleAmt;
			double itemamountfashion=(productPriceList.get(1)/totalpayableAmt)*eligibleAmt;
			double itemamountJewellery=(productPriceList.get(2)/totalpayableAmt)*eligibleAmt;
			double itemamountBeauty=(productPriceList.get(3)/totalpayableAmt)*eligibleAmt;
			
			double sportsPointsEarn=(productPriceList.get(0)/totalpayableAmt)*eligibleAmt*0.01;
			double fashionPointsEarn=(productPriceList.get(1)/totalpayableAmt)*eligibleAmt*0.01;
			double jewelleryPointsEarn=(productPriceList.get(2)/totalpayableAmt)*eligibleAmt*0.0;
			double beautyPointsEarn=(productPriceList.get(3)/totalpayableAmt)*eligibleAmt*0.04;
			expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn) + Math.round(jewelleryPointsEarn));
			
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for beautyItem:"+productNameList.get(3)+"="+Math.round(beautyPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points for jewelleryItem(Ineligible for earn):"+productNameList.get(2)+"="+jewelleryPointsEarn,
					0);
			fUtil.flogResult("Passed", "Calculated Total Earn Points", "Expected Total earn points is:" + expectedEarnPromisedPoints,
					0);
		
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedEarnCliqMultiTenderIneligibleMultiProduct ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	/*
	 *MultiTenderIneligibleMultiProduct Promortional Earn Method
	 */
	@Test
	public void expectedEarnCliqMultiTenderIneligibleMultiProductPromo() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;
			pointsUsed = Double.parseDouble(tcpPoints);
			//for Cliq Payment
			//double totalpayableAmt=totalpayableCliqMultipleItem +shippingCharge;
			//For TPM Payment in Cliq
			double totalpayableAmt=totalCartAmount;
			double eligibleAmt = (totalpayableAmt -pointsUsed);
			double countofItemsChargedforShipping=Math.round(shippingCharge/49);

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}else {
			double itemPointsports=(productPriceList.get(0)/totalpayableAmt)*pointsUsed;
			double itemPointfashion=(productPriceList.get(1)/totalpayableAmt)*pointsUsed;
			double itemPointBeauty=(productPriceList.get(2)/totalpayableAmt)*pointsUsed;
			double itemPointJewellery=(productPriceList.get(3)/totalpayableAmt)*pointsUsed;
			
			double itemamountsports=(productPriceList.get(0)/totalpayableAmt)*eligibleAmt;
			double itemamountfashion=(productPriceList.get(1)/totalpayableAmt)*eligibleAmt;
			double itemamountJewellery=(productPriceList.get(2)/totalpayableAmt)*eligibleAmt;
			double itemamountBeauty=(productPriceList.get(3)/totalpayableAmt)*eligibleAmt;
			
			double sportsPointsEarn=(productPriceList.get(0)/totalpayableAmt)*eligibleAmt*0.01;
			double fashionPointsEarn=(productPriceList.get(1)/totalpayableAmt)*eligibleAmt*0.01;
			double jewelleryPointsEarn=(productPriceList.get(2)/totalpayableAmt)*eligibleAmt*0.0;
			double beautyPointsEarn=(productPriceList.get(3)/totalpayableAmt)*eligibleAmt*0.04;
			expectedEarnPromisedPoints = (Math.round(sportsPointsEarn) + Math.round(fashionPointsEarn) + Math.round(beautyPointsEarn) + Math.round(jewelleryPointsEarn));
			
			double sportsPromotionalEarn=itemamountsports*0.05;
			double fashionPromotionalEarn=itemamountfashion*0.05;
			double jewelleryPromotionalEarn=itemamountJewellery*0.05;
			double beautyPromotionalEarn=itemamountBeauty*0.05;
			double shippingChargePromotionalEarn=countofItemsChargedforShipping*(Math.round((49.0/totalpayableAmt)*eligibleAmt*0.05));
			expectedEarnPromotionalPoints = (Math.round(sportsPromotionalEarn) + Math.round(fashionPromotionalEarn) + Math.round(beautyPromotionalEarn) + Math.round(jewelleryPromotionalEarn)) + Math.round(shippingChargePromotionalEarn);
			
			fUtil.flogResult("Passed", "Calculated Earn Coins", "Expected earn Coins for sportsItem:"+productNameList.get(0)+"="+Math.round(sportsPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Coins", "Expected earn Coins for fashionItem:"+productNameList.get(1)+"="+Math.round(fashionPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Coins", "Expected earn Coins for beautyItem:"+productNameList.get(3)+"="+Math.round(beautyPointsEarn),
					0);
			fUtil.flogResult("Passed", "Calculated Earn Coins", "Expected earn Coins for jewelleryItem(Ineligible for earn):"+productNameList.get(2)+"="+jewelleryPointsEarn,
					0);
			fUtil.flogResult("Passed", "Calculated Total Earn Coins", "Expected Total earn Coins is:" + expectedEarnPromisedPoints,
					0);
			fUtil.flogResult("Passed", "Calculated Total Promortional Earn Coins", "Expected Total Promotional earn Coins is:" + expectedEarnPromotionalPoints,
					0);
		
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedEarnCliqMultiTenderIneligibleMultiProduct ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	@Test
	public void tcpCardExpandedDetailsMultiple() throws Exception {
		//	 goToTataCliqCardAfterTransaction();
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String purchasetype = fUtil.fgetDataNew1("purchase_type").trim();
			String[] productName = fUtil.fgetDataNew1("Product_Id_list").trim().split(",");
			double totalPriceEarn=0.0;

			boolean tcpCard=gmethods.isElementVisible(TdlCromaCard.get().uPointsTCPCard,20);
			if(tcpCard) {
				TdlCromaCard.get().uPointsTCPCard.click();
				fUtil.flogResult("Passed", "Is TCP card selected", "TCP card selected", 1);
			}
			Thread.sleep(10000);
			boolean tcpCardPage = gmethods.isElementVisible(TdlCromaCard.get().uPointsLabel, 20);
			boolean upointbalance = gmethods.isElementVisible(TdlCromaCard.get().uPointsBalance, 20);
			boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTabCroma,20);

			if(tcpCardPage && upointbalance && activity) {

				logger.info("TCP Card is visible");
				fUtil.flogResult("Passed", "TCP Card Expanded Check", "TCP Card present with proper details", 1);
			}else {
				fUtil.flogResult("Failed", "TCP Card Expanded Check", "TCP Card is present with improper details", 1);
			}

			
			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				if (gmethods.isElementVisible(TdlCromaCard.get().activityTabCroma, 20)) {
					String transDescCr = TdlCromaCard.get().transaction_desc.getText();
					String transDateCr = TdlCromaCard.get().transaction_date.getText();
					String points = TdlCromaCard.get().earn_points.getText();
					String points1 = points.substring(1).trim();
					double pointsActualBurn = Double.parseDouble(points1);
					if (points.contains("-") && transDescCr.contains("Redemption") && pointsActualBurn==pointsredeemed) {
						fUtil.flogResult(
								"Passed", "Loyalty Points redeem Check", "Points redeemed Correctly" + " as Expected burn Points:"
										+ pointsredeemed + " is equal to Actual Earn Points:" + pointsActualBurn,
										1);
					} else {
						fUtil.flogResult("Failed", "Loyalty Points redeem Check",
								"Points redeemed incorrectly" + " as Expected Burn Points:" + pointsredeemed
								+ " is not equal to Actual Burn Points:" + pointsActualBurn,
								1);
					}
					if(expectedEarnPromisedPoints==0) {
						fUtil.flogResult("Passed", "Earn points validation", "earn points validated to: "+earn_points, 1);
					}
					else {
						fUtil.flogResult("Failed", "Earn points validation", "earn points not validated to: "+earn_points, 1);
					}

				}
			}else {
				/*String transaction_desc=TdlCromaCard.get().transaction_desc.getText();
				transaction_date=TdlCromaCard.get().transaction_date.getText();
				points_unlock=TdlCromaCard.get().earn_point_unlock.getText().replace("Unlocking", " ").trim();
				*/
				expectedEarnCliqMultiTenderMultiProduct();
				String earned_points=TdlCromaCard.get().earn_points.getText().replace("+", " ").trim();
				earn_points=Double.parseDouble(earned_points);
				if(earn_points==expectedEarnPromisedPoints) {
					fUtil.flogResult("Passed", "Earn points validation", "Expected Earn:"+expectedEarnPromisedPoints+" is equal to Actual Earn:"+earn_points, 1);
				}else {
					for (int i = 10; i < productName.length+24; i=i+8) {
						if(gmethods.isElementVisible(TdlCromaCard.get().lineItemPointEarn.get(i), 10)) {
						String earnedPoints1=TdlCromaCard.get().lineItemPointEarn.get(i).getText().replace("+", " ").trim();
						double earnedPoints=Double.parseDouble(earnedPoints1);
						System.out.println(earnedPoints);
						totalPriceEarn=totalPriceEarn+earnedPoints;
						}else {
							fUtil.flogResult("Failed", "Earn points validation", "Activity Data not loaded", 1);
						}
						
					}
					if(totalPriceEarn==expectedEarnPromisedPoints) {
						fUtil.flogResult("Passed", "Earn points validation", "Expected Earn:"+expectedEarnPromisedPoints+" is equal to Actual Earn:"+totalPriceEarn, 1);
					}
					else {
						fUtil.flogResult("Failed", "Earn points validation", "Expected Earn:"+expectedEarnPromisedPoints+" is not equal to Actual Earn:"+totalPriceEarn, 1);
					}	
				}
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : tcpCardExpandedDetailsMultiple ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	@Test
	public void multipleEligibleIneligibleProductAdd() throws Exception{
		try {
			String[] productName = fUtil.fgetDataNew1("productName").trim().split(",");
			
 			for(int i=0;i<productName.length;i++) {
				
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cromaSearchBox, 40))
				{
					fUtil.flogResult("Passed", "input search visibility", "input search is visible", 1);
					
					TDL_SLPElectronicsPage.get().cromaSearchBox.sendKeys(productName[i]+Keys.ENTER);
					Thread.sleep(5000);
				}
					gmethods.isElementVisible(TdlCromaCard.get().addtocart_Croma,35);
					TdlCromaCard.get().addtocart_Croma.click();
					Thread.sleep(5000);
					if(gmethods.isElementVisible(TdlCromaCard.get().continueShopping_Croma,10)) {
						TdlCromaCard.get().continueShopping_Croma.click();
					}
					gmethods.isElementVisible(TdlCromaCard.get().cartcounter,40);
					String counter=TdlCromaCard.get().cartcounter.getText();
					int productcounter=Integer.parseInt(counter);
					
					if(productcounter==(i+1)) {
						fUtil.flogResult("Passed", "cart addtion validation", "product added successfully", 1);
					}
					/*
					 * else { fUtil.flogResult("Failed", "cart addtion validation",
					 * "product not added successfully", 1); }
					 */	
				}
			Thread.sleep(8000);
			gmethods.isElementVisible(TdlCromaCard.get().cartcounter,40);
			TdlCromaCard.get().cartcounter.click();
			
			
			Thread.sleep(8000);
			for(int j=0;j<productName.length;j++) {
				
					//*[text()='200236']/following::span[@class='new-price']
				WebElement wb=browserFactory.get().getDriver().findElement(By.xpath("//h4[text()='"+productName[j]+"']/following::span[@class='new-price']"));
				gmethods.isElementVisible(wb, 25);
				Thread.sleep(5000);
				String amount=wb.getText().replace(",", "").trim().replace("\u20B9","").trim();
				//ineligibleamount=Double.parseDouble(amount);
				productPriceList.add(Double.parseDouble(amount));
				
			}
		}
		catch(Exception e) {
		}
	}
	
	@Test
	public void expectedEarnCromaSingleTenderMultiProduct() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method").trim();
			String purchasetype = fUtil.fgetDataNew1("purchase_type").trim();
			String paymentmode=fUtil.fgetDataNew1("Multitender").trim();
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;
			double expectedPoints=0.0;
			switch(paymentmethod.toLowerCase()) {
			case "debitcard":
				double cardAmt = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(cardAmt);
				amount = cardAmt;
				break;

			case "creditcard":
				double cardAmt1 = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(cardAmt1);
				amount = cardAmt1;
				break;

			case "internetbanking":
				double netBankAmt = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(netBankAmt);
				amount =netBankAmt;
				break;
			}

			if(purchasetype.equalsIgnoreCase("Gift Card") | paymentmethod.equalsIgnoreCase("TcpPoints")) {
				expectedEarnPromisedPoints=0.0;
			}

			else if(paymentmode.equalsIgnoreCase("Multitender_loyaltypoints")){
				pointsUsed = Double.parseDouble(tcpPoints);
				expectedPoints = (amount-pointsUsed)*0.0033;
				expectedEarnPromisedPoints = Math.round(expectedPoints);
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points is:" + expectedEarnPromisedPoints,
						1);
			}
			else {
				totalpayableCroma=amount-ineligibleamount;
				expectedEarnPromisedPoints = (Math.round(totalpayableCroma*0.0033));
				
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points is:" + expectedEarnPromisedPoints,
						1);

		}
			
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	@Test
	public void expectedEarnCromaMultiTenderMultiProductWithoutPromo() throws Exception {
		try {
			String[] productName = fUtil.fgetDataNew1("productName").trim().split(",");
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			String paymentmode=fUtil.fgetDataNew1("Multitender").trim();
			double amount=0.0;
			String purchasetype = fUtil.fgetDataNew1("purchase_type").trim();
			double expectedPoints=0.0;
			pointsUsed=Double.parseDouble(tcpPoints);
			//expectedEarnPromotionalPoints=Math.round((totalCartAmount-pointsUsed)*0.05);
			/*
			switch(paymentmethod.toLowerCase()) {
			case "debitcard":
				double cardAmt = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
		 		System.out.println(cardAmt);
				amount = cardAmt;
				break;

			case "creditcard":
				double cardAmt1 = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(cardAmt1);
				amount = cardAmt1;
				break;

			case "internetbanking":
				double netBankAmt = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(netBankAmt);
				amount =netBankAmt;
				break;
			}
			*/

			if(purchasetype.equalsIgnoreCase("Gift Card") | paymentmethod.equalsIgnoreCase("TcpPoints")) {
				expectedEarnPromisedPoints=0.0;
				fUtil.flogResult("Passed", "Calculated Total Earn Points",
						"Expected earn points is:" + expectedEarnPromisedPoints, 1);
			}
			else if (paymentmode.equalsIgnoreCase("Multitender_loyaltypoints")) {
				double totaleligibleamount = totalCartAmount - pointsUsed;
				for (int i = 0; i < productName.length; i++) {
					if (productName[0].contains("200236")) {
						if(i==0) {
							fUtil.flogResult("Passed", "Calculated Earn Points for InEligible item code:"+ productName[i],
									"Expected earn points is:0.0" , 0);
							double eligibleproductamount2 = (productPriceList.get(0) / totalCartAmount)* totaleligibleamount;
							
						}else {
							double eligibleproductamount1 = (productPriceList.get(i) / totalCartAmount)* totaleligibleamount;
							expectedEarnPromisedPoints = expectedEarnPromisedPoints
									+ (Math.round(eligibleproductamount1 * 0.0033));
							fUtil.flogResult("Passed", "Calculated Earn Points for Eligible item code:" + productName[i],
									"Expected earn points is:" + (Math.round(eligibleproductamount1 * 0.0033)), 0);
							if (i == productName.length - 1) {
								fUtil.flogResult("Passed", "Calculated Total Earn Points",
										"Expected earn points is:" + expectedEarnPromisedPoints, 0);
							}
						}
						 
						}else
						{
							double	eligibleproductamount1 = (productPriceList.get(i) / totalCartAmount)* totaleligibleamount;
							expectedEarnPromisedPoints = expectedEarnPromisedPoints
									+ (Math.round(eligibleproductamount1 * 0.0033));
							fUtil.flogResult("Passed", "Calculated Earn Points for Eligible item code:" + productName[i],
									"Expected earn points is:" + (Math.round(eligibleproductamount1 * 0.0033)), 0);
							if (i == productName.length - 1) {
								fUtil.flogResult("Passed", "Calculated Total Earn Points",
										"Expected earn points is:" + expectedEarnPromisedPoints, 0);
							}

						}
					}

				}
			
			else { 
				double totaleligibleamount = totalCartAmount;
				for (int i = 0; i < productName.length; i++) {
					if (productName[0].contains("200326")) {
						if(i==0) {
							fUtil.flogResult("Passed", "Calculated Earn Points for InEligible item code:"+ productName[i],
									"Expected earn points is:0.0" , 0);
							expectedEarnPromisedPoints = expectedEarnPromisedPoints + (Math.round(productPriceList.get(0) * 0.05));
						}else {
							expectedEarnPromisedPoints = expectedEarnPromisedPoints + (Math.round(productPriceList.get(i) * 0.0033));
							fUtil.flogResult("Passed", "Calculated Earn Points for Eligible item code:"+ productName[i],
									"Expected earn points is:" + (Math.round(productPriceList.get(i) * 0.0033)), 0);
							if (i == productName.length - 1) {
								fUtil.flogResult("Passed", "Calculated Total Earn Points",
										"Expected earn points is:" + expectedEarnPromisedPoints, 0);
							
						}
						}
						} else {
						     expectedEarnPromisedPoints = expectedEarnPromisedPoints + (Math.round(productPriceList.get(i) * 0.0033));
							fUtil.flogResult("Passed", "Calculated Earn Points for Eligible item code:"+ productName[i],
									"Expected earn points is:" + (Math.round(productPriceList.get(i) * 0.0033)), 0);
							if (i == productName.length - 1) {
								fUtil.flogResult("Passed", "Calculated Total Earn Points",
										"Expected earn points is:" + expectedEarnPromisedPoints, 0);
							}

						}
					}

				}
		
			}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	@Test
	public void expectedEarnCromaMultiTenderMultiProduct() throws Exception {
		try {
			String[] productName = fUtil.fgetDataNew1("productName").trim().split(",");
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			String paymentmode=fUtil.fgetDataNew1("Multitender").trim();
			double amount=0.0;
			String purchasetype = fUtil.fgetDataNew1("purchase_type").trim();
			double expectedPoints=0.0;
			pointsUsed=Double.parseDouble(tcpPoints);
			//expectedEarnPromotionalPoints=Math.round((totalCartAmount-pointsUsed)*0.05);
			/*
			switch(paymentmethod.toLowerCase()) {
			case "debitcard":
				double cardAmt = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
		 		System.out.println(cardAmt);
				amount = cardAmt;
				break;

			case "creditcard":
				double cardAmt1 = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(cardAmt1);
				amount = cardAmt1;
				break;

			case "internetbanking":
				double netBankAmt = DecimalFormat.getNumberInstance().parse(TotalpaidAmount).doubleValue();
				System.out.println(netBankAmt);
				amount =netBankAmt;
				break;
			}
			*/

			if(purchasetype.equalsIgnoreCase("Gift Card") | paymentmethod.equalsIgnoreCase("TcpPoints")) {
				expectedEarnPromisedPoints=0.0;
				fUtil.flogResult("Passed", "Calculated Total Earn Points",
						"Expected earn points is:" + expectedEarnPromisedPoints, 1);
			}
			else if (paymentmode.equalsIgnoreCase("Multitender_loyaltypoints")) {
				double totaleligibleamount = totalCartAmount - pointsUsed;
				for (int i = 0; i < productName.length; i++) {
					if (productName[0].contains("200236")) {
						if(i==0) {
							fUtil.flogResult("Passed", "Calculated Earn Points for InEligible item code:"+ productName[i],
									"Expected earn points is:0.0" , 0);
							double eligibleproductamount2 = (productPriceList.get(0) / totalCartAmount)* totaleligibleamount;
							expectedEarnPromotionalPoints= expectedEarnPromotionalPoints
									+ (Math.round(eligibleproductamount2 * 0.05));
						}else {
							double eligibleproductamount1 = (productPriceList.get(i) / totalCartAmount)* totaleligibleamount;
							expectedEarnPromisedPoints = expectedEarnPromisedPoints
									+ (Math.round(eligibleproductamount1 * 0.0033));
							expectedEarnPromotionalPoints= expectedEarnPromotionalPoints
									+ (Math.round(eligibleproductamount1 * 0.05));
							fUtil.flogResult("Passed", "Calculated Earn Points for Eligible item code:" + productName[i],
									"Expected earn points is:" + (Math.round(eligibleproductamount1 * 0.0033)), 0);
							if (i == productName.length - 1) {
								fUtil.flogResult("Passed", "Calculated Total Earn Points",
										"Expected earn points is:" + expectedEarnPromisedPoints, 0);
							}
						}
						 
						}else
						{
							double	eligibleproductamount1 = (productPriceList.get(i) / totalCartAmount)* totaleligibleamount;
							expectedEarnPromisedPoints = expectedEarnPromisedPoints
									+ (Math.round(eligibleproductamount1 * 0.0033));
							fUtil.flogResult("Passed", "Calculated Earn Points for Eligible item code:" + productName[i],
									"Expected earn points is:" + (Math.round(eligibleproductamount1 * 0.0033)), 0);
							expectedEarnPromotionalPoints = expectedEarnPromotionalPoints
									+ (Math.round(eligibleproductamount1 * 0.05));
							if (i == productName.length - 1) {
								fUtil.flogResult("Passed", "Calculated Total Earn Points",
										"Expected earn points is:" + expectedEarnPromisedPoints, 0);
							}

						}
					}

				}
			
			else {
				double totaleligibleamount = totalCartAmount;
				for (int i = 0; i < productName.length; i++) {
					if (productName[0].contains("200326")) {
						if(i==0) {
							fUtil.flogResult("Passed", "Calculated Earn Points for InEligible item code:"+ productName[i],
									"Expected earn points is:0.0" , 0);
							expectedEarnPromisedPoints = expectedEarnPromisedPoints + (Math.round(productPriceList.get(0) * 0.05));
						}else {
							expectedEarnPromisedPoints = expectedEarnPromisedPoints + (Math.round(productPriceList.get(i) * 0.0033));
							fUtil.flogResult("Passed", "Calculated Earn Points for Eligible item code:"+ productName[i],
									"Expected earn points is:" + (Math.round(productPriceList.get(i) * 0.0033)), 0);
							expectedEarnPromotionalPoints = expectedEarnPromotionalPoints + (Math.round(productPriceList.get(i) * 0.05));
							if (i == productName.length - 1) {
								fUtil.flogResult("Passed", "Calculated Total Earn Points",
										"Expected earn points is:" + expectedEarnPromisedPoints, 0);
							
						}
						}
						} else {
						     expectedEarnPromisedPoints = expectedEarnPromisedPoints + (Math.round(productPriceList.get(i) * 0.0033));
							fUtil.flogResult("Passed", "Calculated Earn Points for Eligible item code:"+ productName[i],
									"Expected earn points is:" + (Math.round(productPriceList.get(i) * 0.0033)), 0);
							expectedEarnPromotionalPoints = expectedEarnPromotionalPoints + (Math.round(productPriceList.get(i) * 0.05));
							if (i == productName.length - 1) {
								fUtil.flogResult("Passed", "Calculated Total Earn Points",
										"Expected earn points is:" + expectedEarnPromisedPoints, 0);
							}

						}
					}

				}
		
			}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	@Test 
	public void validateCliqCashPaymentLuxury() throws Exception{
		try {

			gmethods.isElementVisible(TdlCromaCard.get().cliq_cash_radioluxury, 30);
			TdlCromaCard.get().cliq_cash_radioluxury.click();

			if(gmethods.isElementVisible(TdlCromaCard.get().paydebCliqluxury, 25)) {
				fUtil.flogResult("Passed", "cliq cash switch validation", "cliq cash switched", 1);
				TdlCromaCard.get().paydebCliqluxury.click();
			}
			else {
				fUtil.flogResult("Failed", "cliq cash switch validation", "cliq cash not switched", 1);
			}

		}catch(Exception e) {

		}
	}
	
	
	public boolean scrollToBottom() throws Exception {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.webDriver.get();
			executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean scroll(long height) throws Exception {
		boolean flag = false;
		try {
			WebDriver driver=BrowserFactory.webDriver.get();
			long totalHeight = Long.parseLong(((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight;").toString());
			height =totalHeight/800;
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window.scrollTo(arguments[0], arguments[1]);", 0, height);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Test
	public void validateWelcomeVideo() throws Exception{
		try {

		 	if(gmethods.isElementVisible(TdlCromaCard.get().videoPlayBtn, 25)) {
				fUtil.flogResult("Passed", "Welcome Video play button", "Welcome Video play button is present", 1);
				TdlCromaCard.get().videoPlayBtn.click();
				try {
					if(gmethods.isElementVisible(TdlCromaCard.get().firstNameTextOnVideo,3)) {
						String fName=TdlCromaCard.get().firstNameTextOnVideo.getText();
						TdlCromaCard.get().firstNameTextOnVideo.click();
						
						fUtil.flogResult("Passed", "User first name in the Video", "User is greeted correctlly as:"+fName, 1);
						
				}else {
					fUtil.flogResult("Passed", "User first name in the Video", "User first name is not displayed correctly", 1);
				}
					}
				
					catch (Exception e) {
					// TODO: handle exception
						e.printStackTrace();
				}
			}
			else {
				fUtil.flogResult("Failed",  "Welcome Video play button", "Welcome Video play button is not present", 1);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void rewardsHomePageLinkValidation() throws Exception {

		try {
			gmethods.performanceTiming("Homepage");
			if(gmethods.isElementVisible(TdlCromaCard.get().uRewardsHomePage, 20)) {
				logger.info("Rewards homepage link is visible");
				fUtil.flogResult("Passed", "Rewards homepage link", "Rewards homepage link is present", 1);
				TdlCromaCard.get().uRewardsHomePage.click();

			}else {
				fUtil.flogResult("Failed", "Rewards homepage link", "Rewards homepage link is not present", 1);
			}
		
		} catch (Exception e) {
			fUtil.flogResult("Failed", "rewardsHomePageLinkValidation ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	@Test
	public void rewardsPageValidation() throws Exception {

		try {

            boolean UReawardsHdr=gmethods.isElementVisible(TdlCromaCard.get().uRewardsHdr,20);
			boolean uPointsCard=gmethods.isElementVisible(TdlCromaCard.get().uPointsTCPCard,20);
			if(UReawardsHdr && uPointsCard) {

				logger.info("TataNeu Card is visible");
				fUtil.flogResult("Passed", "Rewards page", "Rewards page is opened successfully", 1);
			}else {
				fUtil.flogResult("Failed", "Rewards page", "Rewards page is not opened", 1);
			}
			gmethods.performanceTiming("Rewards Page");
		
		} catch (Exception e) {
			fUtil.flogResult("Failed", "rewardsPageValidation ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	@Test
	public void NeuCardDetails() throws Exception {
    try {
    	boolean tcpCard=gmethods.isElementVisible(TdlCromaCard.get().uPointsTCPCard,20);
		if(tcpCard) {
			TdlCromaCard.get().uPointsTCPCard.click();
		}
		boolean tcpCardPage = gmethods.isElementVisible(TdlCromaCard.get().uPointsLabel, 20);
		//boolean upointbalance = gmethods.isElementVisible(TdlCromaCard.get().uPointsBalance, 20);
		boolean activity=gmethods.isElementVisible(TdlCromaCard.get().activityTabTCP,20);
		boolean pointsSchedule=gmethods.isElementVisible(TdlCromaCard.get().pointsScheduleTabTCP,20);
		boolean latestTransactionDetail=gmethods.isElementVisible(TdlCromaCard.get().latestTransaction_desc, 30);

		if(tcpCardPage && activity && pointsSchedule && latestTransactionDetail) {

			logger.info("TCP Card is visible");
			fUtil.flogResult("Passed", "NeuCard Expanded Check", "NeuCard present with proper details", 1);
		}else {
			fUtil.flogResult("Failed", "NeuCard Expanded Check", "NeuCard is present with incorrect details", 1);
		}
		gmethods.performanceTiming("Rewards_NeuCard_Deatils popup window");
		
		 } catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : TCPCardDetails ", "Exception Caught : "+e.getMessage(), 1);		
		}
	}
	
	@Test
	public void expectedNeuCoinsEarnEligibleTender() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			String tcpPoints=fUtil.fgetDataNew1("Tcppoints_cutoff").trim();
			double amount=0.0;

			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}else {
				totalCartAmount=totalpayableWestSide;
			pointsUsed = Double.parseDouble(tcpPoints);
			double expectedPoints = (amount-pointsUsed)*0.01;
			expectedEarnPromisedPoints = Math.round(expectedPoints);
			fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points is:" + expectedEarnPromisedPoints,
					1);
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	@Test
	public void gotoWestsideCardAfterTransaction() throws Exception{
		try {
			
			//gmethods.scrollToViewElement(TdlCromaCard.get().cardNameText_Croma);
			Thread.sleep(3000);
            if(gmethods.isElementVisible(TdlCromaCard.get().cardNameTextWestside, 30)) {
				TdlCromaCard.get().cardNameTextWestside.click();
				Thread.sleep(8000);
				if(gmethods.isElementVisible(TdlCromaCard.get().activityTab, 30)) {
					fUtil.flogResult("Passed", "Card Open", "Croma Card Opened", 1);
					
					if(gmethods.isElementVisible(TdlCromaCard.get().CardTransactAmt, 20)) {
				    	String transactionAmt1= TdlCromaCard.get().CardTransactAmt.getText().replace("\u20B9","").trim();
				    	double transactionAmt=DecimalFormat.getNumberInstance().parse(transactionAmt1).doubleValue();
				    	if(transactionAmt==Math.round(totalCartAmount)) {
				    		fUtil.flogResult("Passed", "WestSide Transaction Amount Check", "Transaction amount is correct"+" as Expected:"+totalCartAmount+" is equal to Actual:"+transactionAmt, 1);
				    	}else
				    		fUtil.flogResult("Failed", "WestSide Transaction Amount Check",  "Transaction amount is correct"+" as Expected:"+totalCartAmount+" is equal not to Actual:"+transactionAmt, 1);
				    	
				    }
					
					
				/*String todaysDate=currentdate();
					Thread.sleep(10000);
					String transactionDateXpath="//*[contains(text()='"+todaysDate+"']";
					boolean dateVisible=gmethods.isElementVisibleXpath(transactionDateXpath,20);
					if(dateVisible) {
				    	if(gmethods.isElementVisible(TdlCromaCard.get().CardTransactAmt, 30)) {
				    		String trasactedAmt=TdlCromaCard.get().CardTransactAmt.getText();
				    		fUtil.flogResult("Passed", "Transaction Details", "Tata Cliq transaction is visible on card", 1);


				    	}else {
				    		fUtil.flogResult("Failed", "Transaction Details", "Tata Cliq transaction is not visible on card", 1);
				    	}
				    }
				    */

					//Close Westside Card
					TdlCromaCard.get().offerCloseaftersignIn.click();
					Thread.sleep(2000);

				}
				else {
					fUtil.flogResult("Failed", "Card Open", "Croma Card not Opened", 1);
				}
			}
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "Card validation",e.getMessage(), 0);
		}
	}
	
	@Test
	public void paymentInvoice_page_Cliq() throws Exception {
		try {

			if (gmethods.isElementVisible(TdlCromaCard.get().success_Transaction, 20)) {
				String[] Transaction = TdlCromaCard.get().success_Transaction.getText().trim().split(":");
				TransactionID = Transaction[1];
				if (gmethods.isElementVisible(TdlCromaCard.get().success_sumary, 10))
				{
					logger.info("Transaction id is displayed");
					fUtil.flogResult("Passed","validate transaction details", "Transaction id : "+TransactionID + TdlCromaCard.get().success_sumary.getText() , 1);
				} else {
					logger.info("Transaction id is displayed");
					fUtil.flogResult("Failed", "Transaction id ", "transaction id not displayed", 1);
				}
			}
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			fUtil.flogResult("Failed", "payment_Invoice_page_Cliq check", "transaction id not displayed  due to: "+e, 1);
		}
	}
	
	@Test
	public void expectedCoinsEarn() throws Exception {
		try {
			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			pointsUsed = Double.parseDouble(fUtil.fgetDataNew1("Tcppoints_cutoff").trim());
			float baseEarnRate=Float.parseFloat(fUtil.fgetDataNew1("BaseEarnRate").trim());
			float brandPromoEarnRate=Float.parseFloat(fUtil.fgetDataNew1("BrandPromoEarnRate").trim());
			float nueEarnRate=Float.parseFloat(fUtil.fgetDataNew1("NueEarnRate").trim());
			float eligibleAmount=(float) (totalpayableCliq-pointsUsed);
			if(paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints=0.0;
			}
			else {
			     int baseEarn = Math.round((eligibleAmount)*baseEarnRate);
			     int brandPromoEarn = Math.round((eligibleAmount)*brandPromoEarnRate);
			     int nueEarn = Math.round((eligibleAmount)*nueEarnRate);
				expectedEarnPromisedPoints = baseEarn+brandPromoEarn+nueEarn;
				fUtil.flogResult("Passed", "Calculated Earn Points", "Expected earn points is:" + expectedEarnPromisedPoints,
						1);
			}
		}
		catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}
	
	
}


