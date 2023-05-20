package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_SecurePage_Mobile {
	
	public TDL_SecurePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 * 
	 */
	@FindBy(xpath="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[13]/android.view.View[2]/android.widget.EditText") public MobileElement txtPassword_android;
	@FindBy(xpath="//*[contains(@text, 'Submit')]") public MobileElement cmdSubmit_android;
	
	/**
	 * Define ios locators
	 * 
	 * 
	 */
	@FindBy(xpath="//XCUIElementTypeOther[@name='MasterCard SecureCode - Payer Authentication']/XCUIElementTypeOther[21]/XCUIElementTypeSecureTextField") public MobileElement txtPassword_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Submit']") public MobileElement cmdSubmit_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Cancel']") public MobileElement cmdCancel_ios;
	}
