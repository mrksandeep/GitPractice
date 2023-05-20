package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_InsuranceCancellation_Mobile {
	
	public TDL_InsuranceCancellation_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	@FindBy(xpath = "(//*[contains(@text,'Cancel')])[1]") public MobileElement cancelPopUp_android;
	@FindBy(xpath = "(//*[contains(@text,'Cancel')])[2]") public MobileElement cancelConfirmTxt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/negativeButton") public MobileElement yesBtn_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceCancelStatement") public MobileElement cancelStmnt_android;
	@FindBy(xpath = "//*[contains(@text,'Once again')]/following-sibling::*[1]/*") public List<MobileElement> cancelReasons_android;
	@FindBy(xpath = "//*[contains(@text,'Submit')]") public MobileElement submitBtn_android;
	
	
	
	//ios
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'concerned with you cancelling')]") public MobileElement cancelPopUp_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Yes'] | //XCUIElementTypeButton[@name='Cancel']") public MobileElement yesBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Cancel My Card')] | //XCUIElementTypeStaticText[contains(@name,'Cancel My Home')]") public MobileElement cancelStmnt_ios;
	@FindBy(xpath = "(//XCUIElementTypeImage[@name='radioButtonUnselectedAddress'])[1]") public MobileElement cancelReasons_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Submit']") public MobileElement submitBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back To Home']") public MobileElement backHomeBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Go To My Plans']") public MobileElement goToMyPlans_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'sorry to see you')]") public MobileElement cancelRequestTxt_ios;
	
	
	
	
	
	
	
	
}
