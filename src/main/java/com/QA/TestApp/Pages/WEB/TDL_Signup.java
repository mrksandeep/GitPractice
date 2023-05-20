package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_Signup {
	@FindBy(xpath = "//button[contains(text(),'Sign in with TCP')]") public WebElement signinButton;
	@FindBy(xpath = "//input[@id='countryCodeBox']") public WebElement countryCodeTextBox;
	@FindBy(xpath = "//input[@id='phone'] | //input[@data-testid='phone-number-input']") public WebElement mobileNoTextBox;
	@FindBy(xpath="//button[text()='Get OTP']") public WebElement getOTPbutton;
	@FindBy(xpath = "//*[@class='confirmButton'] | //button[contains(text(),'Confirm')] | //button[contains(text(),'Continue')]") public WebElement confirmButton;
	@FindBy(xpath = "//*[@id='otp-screen']") public WebElement enterOtpScreen;
	@FindBy(xpath = "//input[@id='otp-box'] | //input[@class='otp-box-input']|//input[@type='number']") public WebElement enterOtpTextbox;
	@FindBy(xpath = "//div[contains(text(),'password')]") public WebElement setNewPasswordHeader;
	@FindBy(xpath = "//input[@id='new-password']") public WebElement newPasswordTextbox;
	@FindBy(xpath = "//input[@id='confirm-password']") public WebElement confirmPasswordTextbox;
	@FindBy(xpath = "//div[contains(text(),'Welcome to TCP')]") public WebElement userInformationPageHeader;
	@FindBy(xpath = "//input[@name='firstName']") public WebElement firstNameTextbox;
	@FindBy(xpath = "//input[@name='lastName']") public WebElement lastNameTextbox;
	@FindBy(xpath = "//input[@id='dob']") public WebElement dobTextbox;
	@FindBy(xpath = "//input[@name='email']") public WebElement emailTextbox;
	@FindBy(xpath = "//custom-select[@id='gender']//div[@class='select-box-wrapper']") public WebElement genderDropdown;
	@FindBy(xpath = "//input[@name='tcpConsent']/following-sibling::span[@class='checkmark']") public WebElement termsAndConditionCheckbox;
	@FindBy(xpath = "//input[@name='marketingConsent']/following-sibling::span[@class='checkmark']") public WebElement marketingConsentCheckbox;
	@FindBy(xpath = "//button[contains(text(),'Continue')]") public WebElement continueButton;
	@FindBy(xpath = "//*[contains(text(),'Skip')]") public WebElement skipButton;
	@FindBy(xpath = "//a[@href='/vault']") public WebElement vaultLink;
	@FindBy(xpath = "//*[@id='toast-message']") public WebElement toastMessageError;
	@FindBy(xpath = "//input[@id='password-box'] | //input[@id='password-input']") public WebElement loginPasswordBox;
	@FindBy(xpath = "//span[@id='passwordError']") public WebElement passwordErrorMsg;
	@FindBy(xpath = "//span[@id='phoneError']") public WebElement mobileNumberErrorMsg;
	@FindBy(xpath = "//span[@id='firstNameError']") public WebElement firstNameErrorMsg;
	@FindBy(xpath = "//span[@id='lastNameError']") public WebElement lastNameErrorMsg;
	@FindBy(xpath = "//span[@id='emailError']") public WebElement emailErrorMsg;
	@FindBy(xpath = "//span[@id='dobError']") public WebElement dobErrorMsg;
	@FindBy(xpath = "//span[@id='genderError']") public WebElement genderErrorMsg;
	@FindBy(xpath = "//button[contains(text(),'Next')]") public WebElement nextButton;
	@FindBy(xpath = "//span[@id='countryCodeBoxError']") public WebElement countryCodeErrorMsg;
	@FindBy(xpath = "//div[contains(text(),' Forgot password ')]") public WebElement forgotPasswordlnk;
	@FindBy(xpath = "//span[@id='confirm-passwordError']") public WebElement confirmPasswordErrorMsg;
	@FindBy(xpath = "//span[@id='resendCode']") public WebElement resentOTPlink;
	@FindBy(xpath = "//span[@id='password-boxError']") public WebElement passwordErrorMsg1;

	@FindBy(xpath = "//div[@class='topnav']/span[contains(text(),'Year')]") public WebElement datepickerYearTab;
	@FindBy(xpath = "//div[@class='topnav']/span[contains(text(),'Month')]") public WebElement datepickerMonthTab;
	@FindBy(xpath = "//div[@class='topnav']/span[contains(text(),'Date')]") public WebElement datepickerDateTab;
	@FindBy(xpath = "//*[@id='year-body']/tr[1]/td[1]/span") public WebElement yearTabFirstYear;
	@FindBy(xpath = "//*[@id='leftArrow']") public WebElement previousYearPageBtn;
	@FindBy(xpath = "//span[@id='fullDate']") public WebElement fullDateDatePickerModal;
	@FindBy(xpath = "//*[@id='months-body']/tr[1]/td[1]/span") public WebElement monthTabFirstMonth;
	@FindBy(xpath = "//*[@id='saveDay']") public WebElement saveDate;
	@FindBy(xpath = "//*[@id='nextYear']") public WebElement nextBtnYearTab;
	@FindBy(xpath = "//*[@id='nextMonth']") public WebElement nextBtnMonthTab;	
	@FindBy(xpath = "//custom-select[@name='gender']/div/ul/li[text()='Male']") public WebElement genderMale;
	@FindBy(xpath = "//custom-select[@name='gender']/div/ul/li[text()=' Female']") public WebElement genderFemale;
	@FindBy(xpath = "//*[contains(text(),'There was an error')]") public WebElement ErrorHomePage_pwa;
    @FindBy(xpath = "//span[contains(@class,'error-message')]") public WebElement allErrorElementsInForgotPassPage;
	@FindBy(xpath = "//*[@id='app']/div/app-header/div/img[1]") public WebElement backbutton;
    @FindBy(xpath = "//*[@id='confirm-passwordError']") public WebElement confirmpasswordError;
    @FindBy(xpath = "//custom-select[@id='salutation']//div[@class='select-box-wrapper']") public WebElement salutationDropdown;
	@FindBy(xpath = "//span[@id='salutationError']") public WebElement salutationErrorMsg;
	@FindBy(xpath = "//custom-select[@id='gender']//span[@class='arrow arrow-up']") public WebElement genderDropdownCloseArrow;
	@FindBy(xpath = "//custom-select[@id='salutation']//span[@class='arrow arrow-up']") public WebElement salutationDropdownCloseArrow;
	@FindBy(xpath = "//span[@id='resendCode'][@class='resend-code']") public WebElement resendOtpCodebutton;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]") public WebElement Confirmbutton;
	@FindBy(xpath = "//button[contains(text(),'Continue')]") public WebElement Continuebutton;
}
