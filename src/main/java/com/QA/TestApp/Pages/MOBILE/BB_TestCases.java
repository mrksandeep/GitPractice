package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BB_TestCases  {
	
	public BB_TestCases() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	
	@FindBy(xpath = "//*[@text='Mobile number']") public MobileElement mobileno;
	@FindBy(xpath = "//*[@text='Get OTP']") public MobileElement getotp;
	@FindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout") public MobileElement defaultotp;
	@FindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]") public MobileElement hamburgerMenuBtn;
	@FindBy(xpath = "//*[contains(text(), 'Sign out')]") public MobileElement signout;
	
//	signout 
	@FindBy(xpath="//*[@text='Sign out']") public MobileElement signOutOpt_android;
//	i'll leave
	@FindBy(xpath="//*[@text='I’ll leave']") public MobileElement signoutButton_android;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Grocery']") public MobileElement groceryIcon_android;
	@FindBy(xpath = "//*[@content-desc='Shop by category']//android.widget.ImageView[1]") public List<MobileElement> categoryWidgets_android;
	@FindBy(xpath = "(//android.view.View[@resource-id='pwa-header']/android.view.View//android.widget.TextView)[1]") public MobileElement groceryHamburgerMenu_android;
	@FindBy(xpath = "(//android.view.View/android.widget.TextView)[4]") public MobileElement locationIcon_android;
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Default')]") public MobileElement defaultLocationTile_android;
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Other')]") public MobileElement otherLocationTile_android;
	@FindBy(xpath = "//android.view.View[2]/android.view.View[contains(@content-desc, '')]") public List<MobileElement> productCategoriesTiles_android;
}
