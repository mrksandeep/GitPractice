package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_NetbankingPage_Mobile {
	
	public TDL_NetbankingPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeSearchField[@name='Search']") public MobileElement search_ios;
	
}

