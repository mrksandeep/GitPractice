package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_SSO {

	@FindBy(xpath = "//*[contains(text(),'your mobile number')]") public WebElement loginPageHdrTxt;
	@FindBy(xpath = "//input[@name='phone']") public WebElement phoneNoField;
	@FindBy(xpath = "//input[@name='phone']/preceding-sibling::div/label") public WebElement countryCode;
	@FindBy(xpath = "//*[contains(text(),'India')]") public WebElement indiaCoutryCodeOption;
	@FindBy(xpath = "//*[contains(text(),'India')]/../following-sibling::*") public WebElement displayedCountryCodesSection;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]") public WebElement confirmBtn;
	@FindBy(xpath = "//button[(text()='Get OTP')]") public WebElement getOTPBtn;
	@FindBy(xpath = "//*[contains(text(),'Click here')] | //*[(text()='click here')]") public WebElement clickHereBtn;
	@FindBy(xpath = "//*[contains(text(),'Are you joining us')]") public WebElement gdprCCPATxt;
	@FindBy(xpath = "//*[contains(text(),'Terms')]") public WebElement termsOfServiceBtn;
	@FindBy(xpath = "//*[contains(text(),'Privacy Policy')]") public WebElement privacyPolicyBtn;
	
	@FindBy(xpath = "//input[@id='privacyPolicy' and @type='checkbox'] | //div[@role='checkbox']") public WebElement privacyPolicyCheckBox;
	@FindBy(xpath = "//*[contains(text(),'Terms')]/../preceding-sibling::*") public WebElement TermsAgreementTxt;

//	@FindBy(xpath = "//*[contains(text(),'Enter the OTP')] | //*[contains(text(),'Enter the OTP we have sent to your Corporate email ID')] | //*[contains(text(),'Exciting things ahead! But first, let’s enter the OTP')]") public WebElement otpPageHdr;


	@FindBy(xpath = "//*[contains(text(),'Enter the OTP we have sent to your Corporate email ID')] | //*[contains(text(),'Enter the OTP you’ve received')] | //*[contains(text(),'Exciting things ahead! But first, let’s enter the OTP')]") public WebElement otpPageHdr;

	//@FindBy(xpath = "//*[contains(text(),'Enter the OTP we have sent to your Corporate email ID')] | //*[contains(text(),'Exciting things ahead! But first, let’s enter the OTP')]") public WebElement otpPageHdr;


	@FindBy(xpath = "//button[contains(text(),'Resend code')] | //button[contains(text(),'Resend OTP')]") public WebElement resendCodeBtn;
	@FindBy(xpath = "//input[@name='otp-input' and @type='number']") public WebElement otpField;
	
	@FindBy(xpath = "//*[text()='Me at a glance']") public WebElement uderDtlsPageSubTitleTxt;
	@FindBy(xpath = "//input[@id='firstName' and @type='text']") public WebElement firstNameField;
	@FindBy(xpath = "//input[@id='lastName' and @type='text']") public WebElement lastNameField;
	@FindBy(xpath = "//button[contains(text(),'Submit')]") public WebElement submitBtn;
	@FindBy(xpath = "//button[contains(text(),'Let’s go')]") public WebElement letsGoBtn;
	@FindBy(xpath = "//*[contains(text(),'Skip')]") public WebElement skipBtn;
	@FindBy(xpath = "//label[contains(text(),'U Rewards')]") public WebElement uRewardsTxt_homePage;
	@FindBy(xpath = "//*[@alt='hamberger-icon']") public WebElement hambergerIcon_homepage;
	
	@FindBy(xpath = "//label[contains(text(),'Profile')]") public WebElement profileBtn_myAccount;
	@FindBy(xpath = "//*[contains(text(),'Me at a glance')]") public WebElement profilePageHdr;
	
	@FindBy(xpath = "//button[contains(text(),'Login with Password')]") public WebElement loginWithPwdLink;
	@FindBy(xpath = "//*[contains(text(),'Login with password')]") public WebElement passwordPageHdr;
	@FindBy(xpath = "//input[@name='password']") public WebElement passwordField;
	@FindBy(xpath = "//input[@name='password']/following-sibling::*") public WebElement showPwdBtn;
	@FindBy(xpath = "//button[@id='modal-close-button']") public WebElement closeBtn;
	
	@FindBy(xpath = "//div[@id='notification-body']") public WebElement notificationBody_loginPage;
	@FindBy(xpath = "//div[@id='notification-body']//*[contains(text(),'show updates!')]") public WebElement notificationDtlsTxt_loginPage;
	@FindBy(xpath = "//button[text()='Allow']") public WebElement allowBtn;
	@FindBy(xpath = "//button[text()='No thanks']") public WebElement noThanksBtn;
	//24jun
	@FindBy(xpath = "//*[contains(text(),'Or login using password')]") public WebElement passwrdOption;
	@FindBy(xpath = "//*[contains(text(),'Password')]/following-sibling::div/input") public WebElement enterPwd;
	@FindBy(xpath = "//*[contains(text(),'Submit')]") public WebElement submit;
	
	@FindBy(xpath="//*[contains(text(),'Let’s start with your mobile number')]") public WebElement textBody;
	@FindBy(xpath="//*[contains(text(),'Welcome to TataNeu')]") public WebElement pilotPageHeader;
	@FindBy(xpath="//input[@id='emailId']") public WebElement corporateEmailId;
	@FindBy(xpath="//*[contains(text(),'I don’t have one')]") public WebElement dontHaveoneLink;
	@FindBy(xpath="//input[@id='pinCode']") public WebElement corporatePinode;
	@FindBy(xpath="//button[contains(text(),'Next')]") public WebElement nextButton;
	
	@FindBy(xpath="//label[contains(text(),'Coming to you soon!')]") public WebElement labelComingToUSoon;
	
}
