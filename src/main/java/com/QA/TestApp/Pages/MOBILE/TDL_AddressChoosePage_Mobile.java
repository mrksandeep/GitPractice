package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_AddressChoosePage_Mobile {
	
	public TDL_AddressChoosePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(xpath="//*[contains(@text, 'Search for area, street')]") public MobileElement googleSearchBox_android;
	@FindBy(xpath="//*[contains(@text, 'Get current location - Use GPS')]") public MobileElement getcurrentlocation_android;
	@FindBy(xpath="//*[contains(@text, 'Enter Address Manually')]") public MobileElement enteraddressmanually_android;
	@FindBy(xpath="//*[contains(@text, 'Navi Mumbai')]") public MobileElement selectAddress_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/mainView") public MobileElement selectSearchLocation_android;
	@FindBy(id="com.android.packageinstaller:id/permission_allow_button") public MobileElement permission_allow_button_android;
	@FindBy(id ="com.android.packageinstaller:id/permission_deny_button") public MobileElement permission_deny_button_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvAddressHeadLine']") public MobileElement addressHeadline_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvFormattedAddress']") public MobileElement addressDtls_android;
	
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(id = "tcpApp.findAddress.searchTextField") public MobileElement googleSearchBox_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='tcpApp.address.findAddresstitle'])[1]") public MobileElement getcurrentlocation_ios;	
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.address.findAddressCell'])[2]") public MobileElement enteraddressmanually_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.address.findAddressCell'])[1]") public MobileElement selectSearchLocation_ios;

	//ios setting page locators
	@FindBy(xpath = "//*[@name='TataNeu']") public MobileElement tcpAppios;
	@FindBy(xpath = "//*[contains(@name,'Location')]") public MobileElement locationios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='While Using the App']") public MobileElement locationoptionios;
	}

