package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_MenuPage_Mobile {
	
	public TDL_MenuPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='GO TO WALLET/VAULT']") public MobileElement gotowallet_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='GO TO PAYMENT']") public MobileElement gotoPayment_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='READ OTP']") public MobileElement readOTP_ios;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='Menu']") public MobileElement menu_ios;
}




