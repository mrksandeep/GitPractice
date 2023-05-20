package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_ManageTransactionLimitPage_Mobile {
	
	public TDL_ManageTransactionLimitPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvSetTransactionLimit") public MobileElement tvSetTransactionLimitText_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/seekBar") public MobileElement seekBar_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnSaveTransactionLimit") public MobileElement btnSaveTransactionLimit_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAlertTitle") public MobileElement tvAlertTitle_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnNegative") public MobileElement btnNegative_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPositive") public MobileElement btnPositive_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivBack")public MobileElement ivBack_android;
	
	/**
	 * Define ios locators
	 * 
	 */
	
	
}
