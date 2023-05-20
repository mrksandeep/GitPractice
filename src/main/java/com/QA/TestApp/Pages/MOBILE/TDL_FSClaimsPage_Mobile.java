package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_FSClaimsPage_Mobile {

	public TDL_FSClaimsPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/*
	 * Android Mobile Elements
	 */
	@FindBy(xpath = "//*[contains(@text,'Cancel Policy')]") public MobileElement cancelPolicyBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Download Policy')]") public MobileElement downloadPolicyBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Raise A Claim')]") public MobileElement raiseClaimBtn_android;
	
	//HCI Claim Mobile Elements
	@FindBy(xpath = "//*[contains(@text,'Raise claim')]") public MobileElement claimInitPageHeader_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etFraudAmount") public MobileElement fraudAmnt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etFraudTime") public MobileElement fraudTime_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etFraudDate") public MobileElement fraudDate_android;
	@FindBy(xpath = "//*[contains(@text,'Next')]") public MobileElement nextBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rlAdditionalDetailsTitle") public MobileElement additionalDtls_android;
	//@FindBy(xpath = "//*[@class='android.widget.RadioButton'][1]") public MobileElement yesRadioBtn_android;
	//@FindBy(xpath = "//*[@class='android.widget.RadioButton'][2]") public MobileElement noRadioBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etPoliceReportDate") public MobileElement policeRptDate_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etPoliceReportTime") public MobileElement policeRptTime_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etMerchantNarration") public MobileElement merchantNarration_android;
	
	//CPP Claim Mobile Elements
	@FindBy(xpath = "//*[contains(@text,'Card protection')]") public MobileElement cppClaimHeader_android;
	@FindBy(xpath = "//*[contains(@text,'SELECT CARD')]") public MobileElement changeCardHeader_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rvSavedCards") public List<MobileElement> allSavedCards_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbCard") public List<MobileElement> cardRadioBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbCard") public MobileElement cRadioBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Continue')]") public MobileElement continueBtn_android;
	@FindBy(xpath = "//*[contains(@text,'DETAILS')]") public MobileElement detailsPageHeader_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rgTypeOfTransaction") public List<MobileElement> avlblTransactions_android;
	@FindBy(xpath = "//*[contains(@text,'Online')]") public MobileElement onlineBtn_android;
	@FindBy(xpath = "//*[contains(@text,'ATM')]") public MobileElement atmBtn_android;
	@FindBy(xpath = "//*[contains(@text,'At POS (Store) / offline')]") public MobileElement offlineBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbIndia") public MobileElement indiaLOF_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etFraudLocation") public MobileElement locationAtTimeOfFraud_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvHaveCard") public MobileElement cardInfoHeader_android;
	@FindBy(xpath = "//*[contains(@text,'Yes')]") public MobileElement yesRadioBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvSharedOtp") public MobileElement otpInfoHeader_android;
	@FindBy(xpath = "//*[contains(@text,'PIN or OTP')]/following-sibling::*[1]/*[2]") public MobileElement noRadioBtn_android;
	@FindBy(xpath = "//*[contains(@text,'inform the bank')]/following-sibling::*[1]/*[2]") public MobileElement noRadioBankBtn_android;
	@FindBy(xpath = "//*[contains(@text,'incident to the police')]/following-sibling::*[1]/*[2]") public MobileElement noRadioPoliceBtn_android;
	
	@FindBy(xpath = "//*[contains(@text,'Check your details')]") public MobileElement reviewPageHeader_android;
	@FindBy(xpath = "//*[contains(@text,'Card and type of transaction')]/following-sibling::*") public List<MobileElement> savedDetails_android;
	@FindBy(xpath = "//*[contains(@text,'Terms & Conditions')]") public MobileElement termsAndCondLink_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/cbTermsAndConditions") public MobileElement termsAndCondBox_android;
	@FindBy(xpath = "//*[contains(@text,'Proceed')]") public MobileElement proceedBtn_android;
	
	@FindBy(xpath = "//div[@class='modal-content']//*[contains(@text,'successfully raised')] | //div[@class='modal-content']//*[contains(@text,'successfully registered')] | //*[contains(@text,'successfully registered')]") public MobileElement successText_android;
	
	/*
	 * iOS Mobile Elements
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Cancel Policy']") public MobileElement cancelPolicyBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Change Card' or @name='SELECT CARD']") public MobileElement changeCardHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeCell") public List<MobileElement> allSavedCards_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell)[3]") public MobileElement cardRadioBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeCell")public List<MobileElement> radiobtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]") public MobileElement continueBtn_ios;
	@FindBy(xpath  = "//XCUIElementTypeStaticText[@name='DETAILS']") public MobileElement detailsPageHeader_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='selectedCircle'])[1]") public MobileElement onlineBtn_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='ATM']//preceding-sibling::XCUIElementTypeButton)[2]") public MobileElement atmBtn_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name=\"blankCircle\"])[2]") public MobileElement offlineBtn_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Outside India']//preceding-sibling::XCUIElementTypeButton)[2]") public MobileElement outsideBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Date and time of fraud\"]") public MobileElement dateAndTimeText_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Next']") public MobileElement nextBtn_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='India']//preceding-sibling::XCUIElementTypeButton)[1]") public MobileElement indiaBtn_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Time of fraud ']//following-sibling::XCUIElementTypeTextField)[2]") public MobileElement fraudDate_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Time of fraud ']//following-sibling::XCUIElementTypeTextField)[1]") public MobileElement fraudTime_ios;
	@FindBy(xpath = "//*[@value='₹']") public MobileElement fraudAmnt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Was the card with you when it was used ?']") public MobileElement cardPresent_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Yes']//preceding-sibling::XCUIElementTypeButton)[1]") public MobileElement cardYes_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='No']//preceding-sibling::XCUIElementTypeButton)[1]") public MobileElement cardNo_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Did you share your card’s PIN or OTP with anyone?\"]") public MobileElement pinTxt_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Yes']//preceding-sibling::XCUIElementTypeButton)[2]") public MobileElement pinYes_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='No']//preceding-sibling::XCUIElementTypeButton)[2]") public MobileElement pinNo_ios;
	
	//Additional details
	
	@FindBy(xpath  = "//XCUIElementTypeStaticText[@name=\"When did you inform the bank?\"]") public MobileElement intimatedBankTxt_ios;
	@FindBy(xpath  = "(//XCUIElementTypeButton[@name=\"blankCircle\"])[1]") public MobileElement bankYes_ios;
	@FindBy(xpath  = "(//XCUIElementTypeButton[@name=\"selectedCircle\"])[1]") public MobileElement bankNo_ios;
	@FindBy(xpath  = "//XCUIElementTypeStaticText[@name=\"Did you report this incident to the police?\"]") public MobileElement reportedFraudTxt_ios;
	@FindBy(xpath  = "(//XCUIElementTypeButton[@name=\"blankCircle\"])[2]") public MobileElement policeYes_ios;
	@FindBy(xpath  = "(//XCUIElementTypeButton[@name=\"selectedCircle\"])[2]") public MobileElement policeNo_ios;
	@FindBy(xpath  = "//XCUIElementTypeStaticText[@name='Details of merchant & location']//following-sibling::XCUIElementTypeTextView") public MobileElement merchantDetails_ios;
	@FindBy(xpath  = "//XCUIElementTypeStaticText[@name='Additional Details(Optional)']//following-sibling::XCUIElementTypeTextView") public MobileElement otherDetails_ios;
	@FindBy(xpath  = "//XCUIElementTypeStaticText[@name=\"Additional Details(Optional)\"]") public MobileElement otherDetailsTxt_ios;
	@FindBy(xpath  = "//XCUIElementTypeStaticText[@name='Details of merchant & location']") public MobileElement merchantDetailsTxt_ios;
	//review page
	
	@FindBy(xpath  = "//XCUIElementTypeStaticText[@name='Check Your Details']") public MobileElement reviewPageHeader_ios;
	@FindBy(xpath  = "//XCUIElementTypeButton[@name=\"Proceed\"]") public MobileElement proceedBtn_ios;
	@FindBy(xpath  = "//XCUIElementTypeButton[@name=\"unselectedCheckbox\"]") public MobileElement termsAndCondBox_ios;
	@FindBy(xpath  = "//*[contains(@name,'Terms & Conditions')]//preceding-sibling:: XCUIElementTypeButton") public MobileElement termsAndCondLink_ios;
	@FindBy(xpath  = "//XCUIElementTypeStaticText") public List<MobileElement> savedDetails_ios;
	@FindBy(xpath = "//*[contains(@name,'successfully registered')]")  public MobileElement successText_ios;
	
}
