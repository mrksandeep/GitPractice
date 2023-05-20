package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_ReferFriendPage_Mobile {
	
	public TDL_ReferFriendPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id="com.tatadigital.tcp.dev:id/toolbarTitleTextView") public MobileElement referFriendHeader_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/referContactsButton") public MobileElement referContactsButton_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/backImageView") public MobileElement backBtn_android;
	@FindBy(id="com.android.packageinstaller:id/permission_allow_button") public MobileElement allow_button_android;	
	@FindBy(id="com.android.packageinstaller:id/permission_deny_button") public MobileElement deny_button_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/shareImageView") public MobileElement shareImageView_android;
	
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Refer A Friend']") public MobileElement referFriendHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconShare']") public MobileElement iconShare_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Refer Non TCP Contacts']") public MobileElement nonTcpContactsButton_ios;	
	}