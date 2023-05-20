package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_AddressPage_Mobile {
	
	public TDL_AddressPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id="com.tatadigital.tcp.dev:id/btnAddNewAddress") public MobileElement addnew_android;
	@FindBy(xpath="//*[contains(@text, 'Edit')]") public MobileElement edit_android;
	@FindBy(xpath="//*[contains(@text, 'Delete')]") public MobileElement delete_android;
	@FindBy(xpath="//*[contains(@text, 'Yes')]") public MobileElement yes_android;	
	@FindBy(xpath="//*[contains(@text, 'No')]") public MobileElement no_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/iVMoreInfo") public MobileElement threedots_android;
	 
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeButton[@name='＋ Add new']") public MobileElement addnew_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='tcpApp.address.edit'])[1]") public MobileElement editTab_ios;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit']") public MobileElement edit_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Delete']") public MobileElement delete_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Yes']") public MobileElement yes_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='No']") public MobileElement no_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='tcpApp.address.edit'])[1]") public MobileElement threedot_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Allow Once']") public MobileElement allowOnceAlert_ios;

	}



