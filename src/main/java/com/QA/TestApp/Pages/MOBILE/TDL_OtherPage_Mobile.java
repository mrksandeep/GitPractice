package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_OtherPage_Mobile {
	
	public TDL_OtherPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(xpath = "//*[contains(@text, 'Payment')]") public MobileElement paymentsOpt_android;
	@FindBy(xpath = "//*[contains(@text,'Financial services')]") public MobileElement financialService_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/recyclerViewContainer") public MobileElement othersTabParent_android;
	@FindBy(xpath = "//*[contains(@text,'Bill payment')]") public MobileElement billPayment_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button") public MobileElement allowBtn_android;
	@FindBy(xpath = "//*[@text='Pay Bills']") public MobileElement bpLandingPgHeader_android;
	
	/*
	 * Define iOS locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Payments']") public MobileElement paymentsOpt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Insurance']") public MobileElement insurance_ios;
	@FindBy(xpath = "//XCUIElementTypeCollectionView") public MobileElement othersTabParent_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Utilities']") public MobileElement utilitiese_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Share']") public MobileElement share_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='ALLOW']") public MobileElement allowBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay Bills']") public MobileElement bpLandingPgHeader_ios;
	
}