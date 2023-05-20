package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_Transaction_Mobile {

	public TDL_Transaction_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	// Android
		@FindBy(xpath = "//*[contains(@text,'Merchant Acquiring')]") public MobileElement merchant_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/etOrderId") public MobileElement orderID_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/etMerchantId") public MobileElement merchantID_android;
		@FindBy(xpath = "(//*[contains(@text,'Invoice')])[1]") public MobileElement invoice_android;
		@FindBy(xpath = "//*[contains(@text,'Croma')]") public MobileElement cromaHdr_android;
		@FindBy(xpath = "//*[contains(@text,'Test item')]") public List<MobileElement>  items_android;
		@FindBy(xpath = "//*[contains(@text,'PAY')]") public MobileElement paybtn_android;
		@FindBy(xpath = "") public MobileElement netAmount_android;
		
		@FindBy(xpath = "//*[contains(@text,'Payment')]") public MobileElement paymentHdr_Android;	
		@FindBy(xpath = "(//*[contains(@text,'TOTAL AMOUNT')])[1]/following-sibling::*") public MobileElement payAmount_Android;
		@FindBy(xpath = "//*[contains(@text,'Tata Credit Line')]") public MobileElement creditLineMode_Android;
		@FindBy(xpath = "//*[contains(@text,'Tata Credit Line')]/../span/div") public MobileElement creditlineLimit_android;
		@FindBy(xpath = "//*[contains(@text,'Tata Credit Line')]/..//[@id='check-button-unchecked-b']/following-sibling::*") public MobileElement creditLineCheckbox_android;
		
		//credit line page
		@FindBy(xpath = "//*[contains(@text,'Tata Credit Line')]") public MobileElement creditLineHdr_android;
		@FindBy(xpath = "//*[contains(@text,'Choose EMI options')]") public MobileElement emiOptHdr_android;
		@FindBy(xpath = "//*[contains(@text,'Done')]") public MobileElement doneBtn_android;
		
		//OTP popup
		
		@FindBy(xpath = "//*[contains(@text,'Enter OTP')]") public WebElement otpHdr_android;
		@FindBy(xpath = "") public WebElement otpBox_android;
		@FindBy(xpath = "//*[contains(@text,'Submit')]") public WebElement submitBtn_android;
		
		// ios
				@FindBy(xpath = "//XCUIElementTypeOther[@text='Merchant Acquiring']") public MobileElement merchant_ios;
				@FindBy(id = "com.tatadigital.tcp.dev:id/etOrderId") public MobileElement orderID_ios;
				@FindBy(id = "com.tatadigital.tcp.dev:id/etMerchantId") public MobileElement merchantID_ios;
				@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Invoice'])[1]") public MobileElement invoice_ios;
				@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Croma']") public MobileElement cromaHdr_ios;
				@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Test item']") public List<MobileElement>  items_ios;
				@FindBy(xpath = "//XCUIElementTypeStaticText[@name='PAY']") public MobileElement paybtn_ios;
				@FindBy(xpath = "") public MobileElement netAmount_ios;
				
				@FindBy(xpath = "//*[contains(@text,'Payment')]") public MobileElement paymentHdr_ios;	
				@FindBy(xpath = "(//*[contains(@text,'TOTAL AMOUNT')])[1]/following-sibling::*") public MobileElement payAmount_ios;
				@FindBy(xpath = "//*[contains(@text,'Tata Credit Line')]") public MobileElement creditLineMode_ios;
				@FindBy(xpath = "//*[contains(@text,'Tata Credit Line')]/../span/div") public MobileElement creditlineLimit_ios;
				@FindBy(xpath = "//*[contains(@text,'Tata Credit Line')]/..//[@id='check-button-unchecked-b']/following-sibling::*") public MobileElement creditLineCheckbox_ios;
				
				//credit line page
				@FindBy(xpath = "//*[contains(@text,'Tata Credit Line')]") public MobileElement creditLineHdr_ios;
				@FindBy(xpath = "//*[contains(@text,'Choose EMI options')]") public MobileElement emiOptHdr_ios;
				@FindBy(xpath = "//*[contains(@text,'Done')]") public MobileElement doneBtn_ios;
				
				//OTP popup
				
				@FindBy(xpath = "//*[contains(@text,'Enter OTP')]") public WebElement otpHdr_ios;
				@FindBy(xpath = "") public WebElement otpBox_ios;
				@FindBy(xpath = "//*[contains(@text,'Submit')]") public WebElement submitBtn_ios;
				
		
}