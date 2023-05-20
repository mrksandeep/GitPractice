package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_IHCLLoginPage {
	
@FindBy(xpath = "//button[text()='BOOK A STAY']") public WebElement bookAstaybutton;
@FindBy(xpath = "//*[text()='Sign in']") public WebElement signInButton;
@FindBy(xpath = "//*[text()='Sign in to proceed']") public WebElement signInText;
@FindBy(xpath = "//input[@class='phone-input']") public WebElement inputPhoneField;
@FindBy(xpath = "//input[@id='tic-data-input']") public WebElement inputTICField;
@FindBy(xpath = "//*[contains(text(),'Use email')]") public WebElement useEmailId;
@FindBy(xpath = "//*[contains(text(),'Use TIC')]") public WebElement useTIC;
@FindBy(xpath = "//input[@class='email-data-input']") public WebElement inputEmailField;
@FindBy(xpath = "(//span[@class='checkmark'])[1]") public WebElement checkBox;
@FindBy(xpath = "//span[@id='confirmButton']") public WebElement continueButton;
@FindBy(xpath = "//*[contains(text(),'Enter password for')]") public WebElement enterPasswordText;
@FindBy(xpath = "//*[contains(text(),' Forgot password ')]") public WebElement forgotPasswordText;
@FindBy(xpath = "//input[@type='password']") public WebElement passwordField;
@FindBy(xpath = "//button[@type='submit']") public WebElement submitButton;
@FindBy(xpath = "//*[contains(text(),' Use OTP instead ')]") public WebElement useOTPForLogin;
@FindBy(xpath = "//*[contains(text(),'Enter OTP')]/following::input | //*[contains(text(),'enter the OTP')]/following::input[1] | //*[@id='otp-box']") public WebElement otpfield;
@FindBy(xpath = "//*[contains(text(),'We need to verify your')]") public WebElement verifytextinOTPmodal;
@FindBy(xpath = "//*[text()='Continue']") public WebElement continueButtoninOTPModal;
@FindBy(xpath = "//*[contains(text(),' Forgot password ')]") public WebElement forgotPassword;

@FindBy(xpath = "//*[text()='Create Password']") public WebElement createPassword;
@FindBy(xpath = "//*[text()='Create Password']/following::input[1]") public WebElement newPassword;
@FindBy(xpath = "//*[text()='Create Password']/following::input[2]") public WebElement confirmPassword;

@FindBy(xpath = "//*[contains(text(),'We’ll tell you all about us. But you go first.')]") public WebElement enrollmentPageText;

@FindBy(xpath = "//custom-select[@id='gender']//div[@class='select-box-wrapper']") public WebElement genderDropdown;
@FindBy(xpath = "//input[@name='marketingConsent']/following-sibling::span[@class='checkmark']") public WebElement termsAndConditionCheckbox;
@FindBy(xpath = "//input[@name='email']") public WebElement emailTextbox;
@FindBy(xpath = "//input[@id='dob']") public WebElement dobTextbox;
@FindBy(xpath = "//input[@name='firstName']") public WebElement firstNameTextbox;
@FindBy(xpath = "//input[@name='lastName']") public WebElement lastNameTextbox;

@FindBy(xpath="//*[text()=' Salutation ']") public WebElement salutation;
@FindBy(xpath = "//button[@class='confirmButton']") public WebElement continueButtonEnrollmentPage;
@FindBy(xpath = "//custom-select[@name='gender']/div/ul/li[text()='Male']") public WebElement genderMale;
@FindBy(xpath = "//custom-select[@name='gender']/div/ul/li[text()=' Female']") public WebElement genderFemale;

@FindBy(xpath = "//*[contains(text(),' BEST RATE GUARANTEE')]") public WebElement bestratetextinhomepage;

@FindBy(xpath = "//*[contains(text(),'We’ll tell you all about us. But you go first.')]") public WebElement enrollUserText;


}