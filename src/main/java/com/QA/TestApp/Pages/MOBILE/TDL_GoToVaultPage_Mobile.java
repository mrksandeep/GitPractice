package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_GoToVaultPage_Mobile {
	
	public TDL_GoToVaultPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='CP Dev']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField") public MobileElement _ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='ADD CARD']") public MobileElement addCard_ios;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='VIEW CARD']") public MobileElement viewCard_ios;
}



