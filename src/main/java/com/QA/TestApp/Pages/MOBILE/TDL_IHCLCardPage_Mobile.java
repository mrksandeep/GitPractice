package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_IHCLCardPage_Mobile {
	
	public TDL_IHCLCardPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define android locators
	 * 
	 */
	@FindBy(xpath = "//*[@text='IHCL']")
	public MobileElement cardNameText_IHCL_android;

	@FindBy(xpath = "//*[@text='Activity']")
	public MobileElement activityTab_IHCL_android;

	@FindBy(xpath = "//*[@text='My Benefits']")
	public MobileElement myBenefitsTab_IHCL_android;
	
	@FindBy(xpath = "//*[@text='All Tiers']")
	public MobileElement allTiersTab_IHCL_android;

	@FindBy(xpath = "//*[@text='Book Now']")
	public MobileElement shopNowCTA_IHCL_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/cancelButtonImageView")
	public MobileElement closeBtn_IHCL_android;
	
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='IHCL']")
	public MobileElement cardNameText_IHCL_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Activity']")
	public MobileElement activityTab_IHCL_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='My Benefits']")
	public MobileElement myBenefitsTab_IHCL_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='All Tiers']")
	public MobileElement allTiersTab_IHCL_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"loyalty.vault.shopNow\"]")
	public MobileElement shopNowCTA_IHCL_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='loyalty.vault.close']")
	public MobileElement closeBtn_IHCL_ios;

}
