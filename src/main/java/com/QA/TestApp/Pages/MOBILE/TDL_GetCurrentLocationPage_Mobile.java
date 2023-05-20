package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_GetCurrentLocationPage_Mobile {
	
	public TDL_GetCurrentLocationPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(xpath="//*[contains(@text, 'Name*')]") public MobileElement name_android;
	@FindBy(xpath="//*[contains(@text, 'Addresses')]") public MobileElement addressesHeader_android;
	@FindBy(xpath="com.tatadigital.tcp.dev:id/ivClose") public MobileElement backBtn_android;
	@FindBy(xpath="//*[contains(@text, 'Country code*')]") public MobileElement countrycode_android;	
	@FindBy(xpath="//*[contains(@text, 'Phone Number*')]") public MobileElement phonenumber_android;
	@FindBy(xpath="//*[contains(@text, 'Flat/House No.*')]") public MobileElement flatno_android;
	@FindBy(xpath="//*[contains(@text, 'Address*')]") public MobileElement address_android;
	@FindBy(xpath="//*[contains(@text, 'Landmark')]") public MobileElement landmark_android;
	@FindBy(xpath="//*[contains(@text, 'Country*')]") public MobileElement country_android;
	@FindBy(xpath="//*[contains(@text, 'State*')]") public MobileElement state_android;
	@FindBy(xpath="//*[contains(@text, 'City*')]") public MobileElement city_android;
	@FindBy(xpath="//*[contains(@text, 'Pincode*')]") public MobileElement pincode_android;
	@FindBy(xpath="//*[contains(@text, 'Home')]") public MobileElement home_android;
	@FindBy(xpath="//*[contains(@text, 'Work')]") public MobileElement work_android;
	@FindBy(xpath="//*[contains(@text, 'Custom')]") public MobileElement custom_android;
	@FindBy(xpath="//*[contains(@text, '*Mandatory Fields')]") public MobileElement mandatoryfield_android;
	@FindBy(xpath="//*[contains(@text, 'Label*')]") public MobileElement label_android;
	@FindBy(xpath="//*[contains(@text, 'Save Changes')]") public MobileElement savechangesBtn_android;
	@FindBy(xpath="//*[contains(@text, 'ALLOW')]") public MobileElement allow_android;
	
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Addresses']") public MobileElement addressesHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']") public MobileElement backBtn_ios;	
	@FindBy(xpath = "(//XCUIElementTypeTextField[@name='textfield'])[1]") public MobileElement name_ios;
	@FindBy(xpath = "(//XCUIElementTypeTextField[@name='textfield'])[3]")	public MobileElement countrycode_ios;
	@FindBy(xpath = "(//XCUIElementTypeTextField[@name='textfield'])[2]") public MobileElement phonenum_ios;
	@FindBy(xpath = "(//XCUIElementTypeTextField[@name='textfield'])[4]")	public MobileElement flatno_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Home']") public MobileElement home_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Work']")	public MobileElement work_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Custom']") public MobileElement custom_ios;
	@FindBy(id = "tcpApp.formVC.labelCell")	public MobileElement label_ios;
	@FindBy(id = "tcpApp.formVC.saveButtonCell") public MobileElement savechangesBtn_ios;

	}