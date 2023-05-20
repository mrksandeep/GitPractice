package com.QA.TestApp.Pages.MOBILE;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_ChangePasswordPage_Mobile {
	
	public TDL_ChangePasswordPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id="com.tatadigital.tcp.dev:id/edtOldPassword") public MobileElement oldPassword_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtNewPassword") public MobileElement newPassword_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtConfirmNewPassword") public MobileElement confirmNewPassword_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUpdatePassword") public MobileElement updatePassword_android;	
	@FindBy(id="com.tatadigital.tcp.dev:id/textinput_error") public MobileElement input_error_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvChangePasswordHeader") public MobileElement changePasswordHeader_android;	
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose") public MobileElement backBtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/textinput_error") public MobileElement allErrorElementsInProfilePage_android;
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Change Password']") public MobileElement changepasswordHeader_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[1]/XCUIElementTypeSecureTextField") public MobileElement oldPassword_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[2]/XCUIElementTypeSecureTextField") public MobileElement newPassword_ios;	
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[3]/XCUIElementTypeSecureTextField") public MobileElement confirmNewPassword_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Update password']")	public MobileElement updatePassword_ios;
	@FindBy(name="tcpApp.formVC.invalidTextLabel") public MobileElement allErrorElementsInProfilePage_ios;
	//@FindBy(xpath="//XCUIElementTypeStaticText[@name='New password does not match with the confirm new password']") public MobileElement confirmpasswordError_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Ok']") public MobileElement okBtn_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Back']") public MobileElement backBtn_ios;
	@FindBy(id="tcpApp.formVC.invalidTextLabel") public MobileElement allerror_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Ok']") public MobileElement okBtnchangepass_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Password updated']") public MobileElement passwordUpdated_ios;


	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Incorrect old password']") public MobileElement incorrectOldPassword_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Ok']") public MobileElement okBtnOldPass_ios;
//	@FindBy(id="tcpApp.formVC.invalidTextLabel") public MobileElement allErrorchangepass_ios;
	@FindAll({@FindBy(xpath="//XCUIElementTypeStaticText[@name='tcpApp.formVC.invalidTextLabel']")}) public List<WebElement> allErrorchangepass_ios;
	@FindBy(xpath="(//XCUIElementTypeButton[@name='showPasswordIcon'])[1]") public MobileElement showPasswordIcon1_ios;
	@FindBy(xpath="(//XCUIElementTypeButton[@name='showPasswordIcon'])[2]") public MobileElement showPasswordIcon2_ios;
	@FindBy(xpath="(//XCUIElementTypeButton[@name='showPasswordIcon'])[3]") public MobileElement showPasswordIcon3_ios;

	@FindBy(id="tcpApp.formVC.invalidTextLabel") public MobileElement erroronchangepass_ios;
    
	}






