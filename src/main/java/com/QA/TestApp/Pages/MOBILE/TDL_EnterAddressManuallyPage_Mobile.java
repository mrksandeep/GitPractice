package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_EnterAddressManuallyPage_Mobile {
	
	public TDL_EnterAddressManuallyPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	
	@FindBy(xpath ="//*[@resource-id='com.tatadigital.tcp.dev:id/edtCustomName']") public MobileElement name_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose") public MobileElement backBtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtCountryCode") public MobileElement countrycode_android;	
	@FindBy(id="com.tatadigital.tcp.dev:id/edtPhoneNumber") public MobileElement phonenumber_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtFlatNo") public MobileElement flatno_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtAddress") public MobileElement address_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtLandmark") public MobileElement landmark_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtCountry") public MobileElement country_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtState") public MobileElement state_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtCity") public MobileElement city_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtPincode") public MobileElement pincode_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvLabelHome") public MobileElement home_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvLabelOffice") public MobileElement work_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvLabelCustom") public MobileElement custom_android;
	@FindBy(xpath="//*[contains(@text, '*Mandatory Fields')]") public MobileElement mandatoryfield_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtCustomLabelName") public MobileElement label_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnSaveChanges") public MobileElement savechangesBtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/textinput_error") public MobileElement allErrorElementsInAddressPage_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/textinput_error") public MobileElement addressError_android;
	@FindBy(xpath="//*[contains(@text, 'Address label is mandatory')]") public MobileElement labelError_android;

	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Addresses']") public MobileElement addressesHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']") public MobileElement backBtn_ios;	
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[1]/XCUIElementTypeTextField") public MobileElement name_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[1]/XCUIElementTypeTextField[2]")	public MobileElement countrycode_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[1]/XCUIElementTypeTextField[1]") public MobileElement phonenum_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[2]/XCUIElementTypeTextField")	public MobileElement flatno_ios;
	@FindBy(xpath =  "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[3]/XCUIElementTypeTextField") public MobileElement address_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Landmark']") public MobileElement landmark_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[2]/XCUIElementTypeTextField[1]") public MobileElement country_ios;
	@FindBy(xpath = "(//XCUIElementTypeTextField[@name='textfield'])[7]")	public MobileElement state_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Pincode*']") public MobileElement pincode_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='City*']")	public MobileElement city_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Home']") public MobileElement home_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Work']")	public MobileElement work_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Custom']") public MobileElement custom_ios;
	@FindBy(id = "tcpApp.formVC.labelCell")	public MobileElement label_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.saveButtonCell']") public MobileElement savechangesBtn_ios;
	@FindBy(name="tcpApp.formVC.invalidTextLabel") public MobileElement allErrorElementsInAddressPage_ios;
	 
	}