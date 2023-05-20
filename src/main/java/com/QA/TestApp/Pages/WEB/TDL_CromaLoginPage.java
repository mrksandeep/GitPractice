package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_CromaLoginPage {
	

	
	//Croma
	
	//code fixed to Sign in to proceed need to chk "Sign in to proceed" ,"Login / Sign up"  Use Password Instead Forgot Password xpath//
	
	@FindBy(xpath = "//*[text()='Croma Logo']") public WebElement cromaheader;
	@FindBy(xpath = "//*[text()='Sign in to proceed']") public WebElement cromaPageTitle;
	@FindBy(xpath = "//*[text()='for exclusive offers, rewards, and more']") public WebElement cromaPagesubTitle;
	@FindBy(xpath = "//*[contains(text(),'Login / Sign up')]") public WebElement cromaLogin;
	@FindBy(xpath = "//input[@placeholder='Enter phone number'] | (//input[@placeholder='Enter phone number'])[2]") public WebElement enterNumber;
	@FindBy(xpath = "//*[contains(text(),'Use email ID')]") public WebElement useEmail;
	@FindBy(xpath = "(//span[text()='Continue'])[1] | (//span[text()='Continue'])[2]") public WebElement continuebutton;
	@FindBy(xpath = "//*[text()='We need to verify your phone number before you log in']") public WebElement verifyPhone;
	@FindBy(xpath = "//*[contains(text(),'Enter OTP')]/following::input | //*[contains(text(),'enter the OTP')]/following::input[1] | //*[@id='otp-box']") public WebElement EnterOTP;
	@FindBy(xpath = "//*[text()='Use password instead']") public WebElement USePassword;
	@FindAll({@FindBy(xpath = "//*[contains(text(),'Enter OTP')]/following::div/div/span")}) public List<WebElement> OTP;
	@FindBy(xpath = "//*[@class='hr-close']") public WebElement closeOTPModal;
	@FindBy(xpath = "//*[contains(text(),'Enter password for')]") public WebElement enterPasswordTxt;
	@FindBy(xpath = "//*[contains(text(),'Enter password for')]/following::input") public WebElement enterPasswordvalue;
	@FindBy(xpath = "//*[contains(text(),'Forgot password')]") public WebElement forgotPassword;
	@FindBy(xpath = "//*[contains(text(),' Use OTP instead ')]") public WebElement useOtpinstead;
	@FindBy(xpath = "//*[text()='Login']") public WebElement Login;
	@FindBy(xpath = "//input[@placeholder='Enter email ID']") public WebElement enterEmail;
	@FindBy(xpath = "//*[text()='Create Password']") public WebElement createPAssword;
	@FindBy(xpath = "//*[text()='Create Password']/following::input[1]") public WebElement NewPassword;
	@FindBy(xpath = "//*[text()='Create Password']/following::input[2]") public WebElement ConfirmPAssword;
	@FindBy(xpath = "//*[text()='Submit']") public WebElement submit;
	@FindBy(xpath = "//*[contains(text(),'New Password set Successfully')]") public WebElement passwordResetSuccess;
	//feb 10//new users//
	@FindBy(xpath = "//*[text()='We need to verify your phone number for enrolment']|//*[text()='We need to verify your phone number before you log in']") public WebElement verifyPhoneEnroll;
	@FindBy(xpath = "//*[text()='Sign up using different option']") public WebElement signpDifferentOption;
	@FindBy(xpath = "//*[text()='Welcome to Croma']") public WebElement EnrolPage;
	@FindBy(xpath = "//*[contains(text(),'Skip')]") public WebElement EnrolPageSkip;
	//migratedUsers//
	@FindBy(xpath = "//*[text()='We need to verify your phone number before you log in']") public WebElement verifyPhoneEnrollMigrated;
	//Google//
	@FindBy(xpath = "(//*[contains(text(),'Terms and Conditions')]/following::div/button)[1] | //*[@id='span-g-social-button']") public WebElement GLogin;
	@FindBy(xpath = "//*[@id='identifierId']") public WebElement gmail;
	@FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input") public WebElement gmailpwd;
	@FindBy(xpath = "((//*[contains(text(),'Next')])[2]/following::div)[1]") public WebElement gmailnext;

	@FindBy(xpath = "//*[text()='Welcome to Croma!']") public WebElement welcomeTxt;
	@FindBy(xpath = "//*[text()='We’d like to know you better'] | //*[contains(text(),'like to know you better')]") public WebElement subtitleTxt;
	@FindBy(xpath = "//*[text()='Use another account']") public WebElement anotheraccTxt;
	@FindBy(xpath = "(//*[text()='Continue'])[2] | (//*[text()='Continue'])[3]") public WebElement continueOTPbutton;
	@FindBy(xpath = "//*[@type='submit']") public WebElement submitBtn;
	//Facebook//
	@FindBy(xpath = "//*[@id='span-f-social-button']") public WebElement FLogin;
	@FindBy(xpath = "//*[text()='Log in to Facebook']") public WebElement FLoginHeader;
	@FindBy(xpath = "//*[@id='email']") public WebElement FLoginEmail;
	@FindBy(xpath = "//*[@id='pass']") public WebElement FLoginPasswd;
	@FindBy(xpath = "//*[@id='loginbutton']") public WebElement FLoginbutton;
	@FindBy(xpath = "//*[text()='Continue as Tatadigital']|//*[text()='Continue as Rahul']") public WebElement contAsTDL;
	//cromaHomePage//
	@FindBy(xpath = "//a[@class='logo']") public WebElement cromaheaderhomePage;
    @FindBy(xpath = "//*[@id='search']") public WebElement searchproduct;
    @FindBy(xpath = "//a[@class='logo']/following::div[8]/div/div/span[1]") public WebElement usernameHomePage;
    @FindBy(xpath = "//a[@class='logo']/following::div[8]") public WebElement usernameHomePage_skip;
    @FindBy(id="phoneError-container") public WebElement errorMessageLogin;
	@FindBy(xpath = "//*[text()='back'] | //img[@class='backArrow']") public WebElement backArrow;
	@FindBy(xpath = "//*[text()='Incorrect OTP']") public WebElement incorrectOTP;
	@FindBy(xpath = "//*[text()='OTP has expired']") public WebElement expiredOTP;
	@FindBy(id="tAndCPlaceHolder") public WebElement termConditionLine;
	@FindBy(xpath = "//*[contains(text(),'Use phone number')]") public WebElement usePhoneNumber;
	@FindBy(xpath = "//*[contains(text(),'share')]") public WebElement shareNoOTP;
	@FindBy(xpath = "//*[contains(text(),'Loyalty')]") public WebElement loyalty;
	@FindBy(xpath = "//*[@id='country-data-container']/div[1]/span[2]") public WebElement countryCode;
	@FindBy(xpath = "//*[@id='down-error-phone']") public WebElement countryCodeDropdown;
	@FindBy(xpath = "//*[text()='We need to verify your email ID before you log in']") public WebElement verifyEmailExisting;

	@FindBy(xpath = "//*[text()='We need to verify your email ID for enrolment']|//*[text()='We need to verify your email ID before you login']") public WebElement verifyEmailEnroll;

	@FindBy(xpath = "//*[text()='We need to verify your email ID before you log in']") public WebElement verifyEmailMigrated;
	@FindBy(xpath = "//*[text()='Welcome to Croma']") public WebElement profileHeader;
	@FindBy(xpath = "//*[text()='back'] | //img[@class='backArrow']") public WebElement profileback;
	@FindBy(xpath = "//input[@type='checkbox']") public WebElement NoChkBox;
//	@FindBy(xpath = "//*[text()='We need to verify your phone number before you log in'] | //*[contains(text(),'We need to verify your email ID')]") public WebElement verifyPhone;	
	@FindBy(id="down-error-phone") public WebElement countryCodeArrow;
	@FindBy(xpath = "//div[@class='form-modal-opaque-background-loyalty'] | //*[@id='otp-box']") public WebElement otpBox;
	@FindBy(xpath = "//*[@type='submit']") public WebElement submitBtnNew;
    @FindBy(xpath = "//*[@id='firstNameError']") public WebElement firstNameError;
    @FindBy(xpath = "//*[@id='enterPhoneNUmberPage']") public WebElement phnNumModal;
    @FindBy(xpath = "//*[@id='lastNameError']") public WebElement lastNameError;
    @FindBy(xpath = "//*[@id='dobError']") public WebElement dobError;
    @FindBy(xpath = "//*[@id='emailError']") public WebElement emailError;
    
    //Manoranjan
    @FindBy(xpath = "//span[@id='sec']") public WebElement otpResendInSecs;
	@FindBy(xpath = "(//*[@alt='close-icon'])[1]") public WebElement closeOTPPopup;
	@FindBy(xpath = "//*[contains(text(),' Use OTP instead ')]") public WebElement useOTPButton;
	@FindBy(xpath = "//*[@id='resendCode']") public WebElement otpResendButton;
	@FindBy(xpath = "//*[contains(text(),'OTP has expired')]") public WebElement OTPExpiredText;
	@FindBy(xpath = "//*[contains(text(),'Continue')]/parent::button") public WebElement disableContinueButton;
	@FindBy(xpath = "//*[contains(text(),'You have entered incorrect OTP 3 times, please try again after 5 minutes.')]") public WebElement incorrectOTPErrorPopup;
	@FindBy(xpath = "//*[contains(text(),'You have exausted all resend attempts, please try again after 5 minutes.')]") public WebElement resendAttempts;
	@FindBy(xpath = "//*[contains(text(),'Use password instead')]") public WebElement usePasswordInsteadLink;
	@FindBy(xpath = "//*[@id='otp-box']") public WebElement forgotPasswordOtp;
	@FindBy(xpath = "//*[@id='passwordError']") public WebElement passwordError;
	@FindBy(xpath = "//*[@id='password-boxError']") public WebElement lastInvalidLoginAttempt;
	@FindBy(xpath = "//*[contains(text(),'New Password set Successfully, please login again with your new password')]") public WebElement updatePasswordSuccessText;
	@FindBy(xpath = "//*[@id='passwordButton']/parent::button") public WebElement loginBtn;
	@FindBy(xpath = "//*[text()='You have entered incorrect password 3 times, please try again after 5 minutes.']") public WebElement incorrectLoginAttemptErrorText;
				

	@FindBy(xpath = "//*[@id='wrapper-phone']/div/div/div/div[2]/div/span[1]") public WebElement attributeOTP;

	@FindBy(xpath = "//*[@id='welcomeNewUserPhoneInput-phone']") public WebElement enterNumberSocial;
	@FindBy(xpath = "(//*[text()='Continue'])[3]") public WebElement continueOTPbuttonSocial;
	//lipika//
	@FindBy(xpath="//*[@class='logged-in-user']") public WebElement loggedInUser;
    @FindBy(xpath="//span[text()='Logout']") public WebElement logout;
    @FindBy(xpath = "//*[@class='user-detail-skip-btn']") public WebElement skipBtn;
    @FindBy(xpath = "//*[@class='use-password-instead']") public WebElement usePwdInstead;
    @FindBy(xpath = "//input[@id='password-box']") public WebElement pwdBox;
    @FindBy(xpath = "//*[@id='password-boxError']") public WebElement pwdboxError;
    @FindBy(xpath = "//*[@class='signup-different-option']") public WebElement signUpDiffOpt;
    @FindBy(xpath = "//*[@class='icon-header-small']") public WebElement brandLogo;
    @FindBy(xpath = "//*[@id='timer']") public WebElement timer;
    @FindBy(xpath = "//*[@id='sec']") public WebElement sec;
    @FindBy(xpath="//*[text()='A new OTP has been sent']") public WebElement OTPmsg;

	@FindBy(xpath = "//*[@id='loginActive']/following::div[1]/span[1]") public WebElement usernameHomePageNew;
	@FindBy(xpath = "//*[@id='loginActive']/following::div[1]") public WebElement usernameHomePageNew_skip;

	 @FindBy(xpath="//*[text()='Salutation']") public WebElement salutation;

		@FindBy(xpath = "//*[contains(text(),'Your new password cannot be the same as your previous 3 passwords')]") public WebElement newOldPwdErrText;

		@FindBy(xpath = "(//*[@class='modal-close-icon'])") public WebElement closeOTPModalPWA;
		
//feb17//MyProfile Croma Page//
		 @FindBy(xpath = "(//span[text()='My Profile'])[1]") public WebElement MyProfileCroma;
		 @FindBy(xpath = "//*[text()='First Name']/following::input[1]") public WebElement firstNameTextboxProf;
		 @FindBy(xpath = "//*[text()='Last Name']/following::input[1]") public WebElement lastNameTextboxProf;
		 @FindBy(xpath = "//*[text()='Mobile Number']/following::input[1]") public WebElement MobNumProf;
		 @FindBy(xpath = "//*[text()='Email ID']/following::input[1]") public WebElement EmailProf;
		 @FindBy(xpath = "(//*[@placeholder='DD/MM/YYYY'])[1]") public WebElement DOBTextboxProf;
		 @FindBy(xpath = "//*[contains(text(),'This email id already exists!')]") public WebElement ExistEmail;

		 @FindBy(xpath="//*[text()='This email id already exists! Verify using OTP to add it to your account']") public WebElement verifyExistingEmailMsg;

		 @FindBy(xpath="//*[@id='confirmButtonWelcome']") public WebElement confirmButtonWelcome;


		 @FindBy(xpath = "//*[contains(text(),'Enter OTP')] | //*[contains(text(),'enter the OTP')]") public WebElement HashOTP;
		 @FindBy(xpath = "//*[text()='Mobile no. required']") public WebElement MigratedMobile;

		 @FindBy(xpath = "(//*[text()='Continue'])[3] | (//*[text()='Continue'])[2]") public WebElement MigcontinueOTPbutton;
		 @FindBy(xpath = "(//*[text()='SIGN IN '])[1] | (//button[contains(text(),'Sign In')])[2]") public WebElement SignIn;
		 @FindBy(xpath = "(//*[text()='Continue'])[3]") public WebElement EmalEnrcontinueOTPbutton;
		 @FindBy(xpath = "(//*[text()='Continue'])[3]") public WebElement MigcontinueEmailOTPbutton;
		 
		 @FindBy(xpath = " (//*[contains(text(),'Skip')])[2]") public WebElement EnrolPageSocialSkip;
		 @FindBy(xpath = "//*[@id='tAndCPlaceHolder']") public WebElement TC;
		 
		 
		 
		 // New and Updated xpaths - Croma V2 PWA -->
		 @FindBy(xpath = "//*[@alt='Croma Logo']") public WebElement cromaLogo;
		 @FindBy(xpath = "//*[@class='icon-header-small']") public WebElement cromaLogo_SignInPage;
		 @FindBy(xpath = "//*[contains(text(),'Terms of Use')]") public WebElement termsOfuseBtn;
		 @FindBy(xpath = "//*[contains(text(),'Privacy Policy')]") public WebElement privacyPolicyBtn;
		 @FindBy(xpath = "//*[text()='We need to verify your phone number before you log in']") public WebElement verifyPhoneOtpHdrTxt;
		 @FindBy(xpath = "//*[text()='We need to verify your email ID before you log in']") public WebElement verifyEmailOtpHdrTxt;
		 
		 @FindBy(xpath = "//*[@class='modal-new-subtitle']/following-sibling::*[contains(text(),'and')]") public WebElement otpModalSubTitleTxt;
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
}
