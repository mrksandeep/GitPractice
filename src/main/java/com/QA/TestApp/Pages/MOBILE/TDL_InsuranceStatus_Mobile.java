package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_InsuranceStatus_Mobile {

	public TDL_InsuranceStatus_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/mainLayout") public  List<MobileElement> trackStatusItems_android;
	@FindBy(xpath = "//*[contains(@text,'Protection Plan')]") public List<MobileElement> claimNames_android;
	@FindBy(xpath = "//*[contains(@text,'Protection Plan')]/following-sibling::*[1] | //*[contains(@text,'Secure Plan')]/following-sibling::*[1]") public List<MobileElement> expandClaims_android;
	@FindBy(xpath = "//*[contains(@text,'Protection Plan or Secure Plan')]/following-sibling::*[1]") public MobileElement firstExpandArrow_android;
	@FindBy(xpath = "//*[contains(@text,'Upload')]") public MobileElement uploadLink_android;
	@FindBy(xpath = "//*[contains(@text,'Claim Closed - Approved/ Rejected')]") public MobileElement claimStatus_android;
	
	
	/*
	 * iOS Mobile Elements
	 * 
	 */
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Claim Submitted']") public MobileElement claimSubmitted_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Claim Initiated']") public MobileElement claiminitiated_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Card Protection Plan']") public List<MobileElement> claimNames_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Card Protection Plan' or @name='Home Protection Plan']") public MobileElement claims_ios;
	
	@FindBy(xpath = "///XCUIElementTypeStaticText[@name=\"Home Protection Plan\"]") public List<MobileElement> claimHome_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconChevronDown']") public List<MobileElement> expandClaims_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home Protection Plan\"]/following-sibling::*[4]") public List<MobileElement> expandHomeClaims_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name=\"downArrow\"])[1]") public MobileElement firstExpandArrow_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Upload']") public MobileElement uploadLink_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Claim Closed - Approved/ Rejected\"]") public MobileElement claimStatus_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconChevronUp']") public MobileElement upArrow_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Claim Submitted']/following-sibling::*[5]") public MobileElement submittedArrow_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Document Submitted\"]") public MobileElement docSubmitted_ios;

}
