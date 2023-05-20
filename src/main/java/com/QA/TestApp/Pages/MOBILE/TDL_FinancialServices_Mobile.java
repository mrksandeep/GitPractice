package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_FinancialServices_Mobile {
	
	public TDL_FinancialServices_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	/*
	 * Define Android Locators
	 * 
	 */
	@FindBy(xpath = "//*[contains(@text,'Home Insurance')]") public MobileElement hciInsuranceOfferHeader_android;
	@FindBy(xpath = "//*[contains(@text,'Debit/Credit Card')]") public MobileElement cppInsuranceOfferHeader_android;
	@FindBy(xpath = "//*[contains(@text,'Know more')]") public MobileElement knowMoreBtn_android;
	@FindBy(xpath = "//*[contains(@text,'HomeAwaySecure Insurance')] | //*[contains(@text,'Home Protection While You Are Away')]") public MobileElement hciInsuranceDtlsInKnowMore_android;

	//@FindBy(xpath = "//*[contains(@text,'Card Fraud Secure Insurance')]") public MobileElement cppInsuranceDtlsInKnowMore_android;
	@FindBy(xpath = "//*[contains(@text,'Card Cover Insurance') or contains(@text,'Card')]") public MobileElement cppInsuranceDtlsInKnowMore_android;

	@FindBy(xpath = "//*[starts-with(@text,'Tata AIG')]") public MobileElement insuranceDetailsHCI_android;
	@FindBy(xpath = "//*[starts-with(@text,'Protect')]") public MobileElement insuranceDetailsCPP_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnInsuranceBuyNow") public MobileElement buyNowBtn_android;
	
	@FindBy(xpath = "(//*[@class='android.view.ViewGroup'][1]/*[2])[1]") public MobileElement heroBannerContainer_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBrandName") public MobileElement insuranceType_android;
	@FindBy(xpath = "//*[contains(@text,'FS- Card Insurace')]") public MobileElement fsCardIns_android;
	@FindBy(xpath = "//*[contains(@text,'FS Home Insurance')]") public MobileElement fsHomeIns_android;
	@FindBy(xpath = "//*[contains(@text,'Know')]") public MobileElement knowBtnHeroBanner_android; 
	
	
	
	/*
	 * Define iOS Locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Home Insurance against any burglary']") public MobileElement hciInsuranceOfferHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Protect Your all Debit/Credit Card against any forgery']") public MobileElement cppInsuranceOfferHeader_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Know more'])[1]") public MobileElement knowMoreBtnHCI_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Know more'])[2]") public MobileElement knowMoreBtnCPP_ios;
	//@FindBy(xpath = "") public MobileElement cppInsuranceDtlsInKnowMore_ios;
	//@FindBy(xpath = "") public MobileElement insuranceDetails_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Buy Now']") public MobileElement buyNowBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Error']") public MobileElement errorPopUp_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Retry']") public MobileElement retryBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.home.carouselCell']") public MobileElement HomeBannerContainer_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Location']") public MobileElement LocationIos;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='Allow']") public MobileElement AllowIos;
	
	

}
