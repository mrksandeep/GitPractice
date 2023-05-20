package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_PaymentMethodPage_Mobile {
	
	public TDL_PaymentMethodPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='More Banks']") public MobileElement moreBanks_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP Dev']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]") public MobileElement netbankingTab_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='AXIS']") public MobileElement axis_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='HDFC']") public MobileElement hdfc_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='ICICI']") public MobileElement icici_ios;
	
}