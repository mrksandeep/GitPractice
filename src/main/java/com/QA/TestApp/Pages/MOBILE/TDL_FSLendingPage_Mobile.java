package com.QA.TestApp.Pages.MOBILE;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_FSLendingPage_Mobile {

	public TDL_FSLendingPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);

	}
	
	// Android
	@FindBy(xpath = "//*[contains(@text,'Tata Capital Credit Line')]") public MobileElement tataCapitalBanner_android;
	@FindBy(xpath = "//*[contains(@text,'Avail Now')]") public MobileElement availnow_android;
	@FindBy(xpath = "//*[contains(@text,'Buy it')]") public MobileElement activatePageTxt_android;
	@FindBy(xpath = "//*[contains(@text,'Activate Now')]") public MobileElement activateNowBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Vault')]") public MobileElement vaultOth_android;
	@FindBy(xpath = "//*[contains(@text,'Skip Tour')]") public MobileElement skipTour_android;
	@FindBy(xpath = "//*[contains(@text,'My Cards')]") public MobileElement myCardTab_android;
	@FindBy(xpath = "//*[contains(@text,'Tata capital Credit Line')]") public MobileElement tataCapitalCard_android;
	@FindBy(xpath = "//*[contains(@text,'Tata capital Credit Line')]/following-sibling::*") public MobileElement tataCardOptions_android;
	@FindBy(xpath = "//*[contains(@text,'View Details')]") public MobileElement viewDetails_android;
	@FindBy(xpath = "//*[contains(@text,'Check Status')]") public MobileElement checkStatus_android;
	@FindBy(id = "com.android.packageinstaller:id/permission_message") public MobileElement locPopup_android;
	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button") public MobileElement locAllow_android;
	@FindBy(id = "com.android.packageinstaller:id/permission_deny_button") public MobileElement locDeny_android;
	
	//Pan Form
	@FindBy(xpath = "//*[contains(text(),'Congratulations')]") public MobileElement congratstxt_android;
	@FindBy(xpath = "//*[contains(text(),'Remind')]") public MobileElement remindbtn_android;
	
	@FindBy(xpath = "//*[contains(@text,'Tata Credit Line')]") public MobileElement panForm_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etPanNumber") public MobileElement panNumber_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etGender") public MobileElement gender_android;
	@FindBy(xpath = "//*[contains(@text,'Male')]") public MobileElement genderMale_android;
	@FindBy(xpath = "//*[contains(@text,'Female')]") public MobileElement genderFemale_android;
	@FindBy(xpath = "//*[contains(@text,'Other')]") public MobileElement genderOther_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etPinCode") public MobileElement pincode_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/cbTerms") public MobileElement tnc_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btVerify") public MobileElement verify_android;
	
	
	//ios
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Tata Capital Credit Line']") public MobileElement tataCapitalBanner_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Avail Now']") public MobileElement availnow_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Buy it']") public MobileElement activatePageTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Activate Now']") public MobileElement activateNowBtn_ios;
	
	@FindBy(id = "com.android.packageinstaller:id/permission_message") public MobileElement locPopup_ios;
	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button") public MobileElement locAllow_ios;
	@FindBy(id = "com.android.packageinstaller:id/permission_deny_button") public MobileElement locDeny_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Congratulations']") public MobileElement congratstxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Remind']") public MobileElement remindbtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Tata Credit Line']") public MobileElement panForm_ios;
	
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Vault']") public MobileElement vaultOth_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='My Cards']") public MobileElement myCardTab_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='tcpApp.userVault.creditLineCardName']") public MobileElement tataCapitalCard_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"tcpApp.userVault.creditLineCardName\"]//following-sibling::*") public MobileElement tataCardOptions_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='View Details']") public MobileElement viewDetails_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Check Status']") public MobileElement checkStatus_ios;
	
	
	
}
