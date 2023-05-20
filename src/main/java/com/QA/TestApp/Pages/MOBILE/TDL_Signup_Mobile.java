package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_Signup_Mobile {
	
	public TDL_Signup_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators 
	 * 
	 */
	
	@FindBy(xpath = "//*[@text='TCP | Simplifying life']") public MobileElement signUpPageHeader_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnSingIn'] | //*[contains(@text,'Start!')] | //*[@resource-id='com.tatadigital.tcp.dev:id/txtLetsStart']") public MobileElement signinButton_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/countryCodeTextView']") public MobileElement countryCodeTextBox_android;

//	@FindBy(xpath = "//android.widget.EditText[@resource-id='phone'] | //*[@text='Enter mobile number'] | //*[contains(@text,'Mobile number')]") public MobileElement mobileNoTextBox_android;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='phone'] | //*[@text='Enter mobile number'] | //*[@resource-id='com.tatadigital.tcp.dev:id/mobileNumberEditText'] | //*[contains(@text,'Mobile number')]") public MobileElement mobileNoTextBox_android;

	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtPassword']") public MobileElement passwordBox_android;
	@FindBy(xpath = "//android.widget.Button[contains(@text,'Confirm')] | //*[@text='Get OTP'] | //*[@resource-id='com.tatadigital.tcp.dev:id/mobileConfirmButton']") public MobileElement confirmButton_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvLoginWithPassword") public MobileElement btnLoginwithpassword;
	//Akshya
	@FindBy(id = "com.tatadigital.tcp.dev:id/otpLabelView") public MobileElement enterOtpHeader_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/otpPinView") public MobileElement enterOtpTextbox_android;
	//Akshya
	@FindBy(xpath = "//android.view.View[contains(@text, 'password')]") public MobileElement setNewPasswordHeader_android;
	@FindBy(xpath = "(//*[@resource-id='new-password'])[2]") public MobileElement newPasswordTextbox_android;
	@FindBy(xpath = "//input[@name='password']") public MobileElement newPasswordTextbox_androidWebView;
	@FindBy(xpath = "//input[@name='confirm-password']") public MobileElement confirmPasswordTextbox_androidWebView;
	@FindBy(xpath = "(//*[@resource-id='confirm-password'])[2]") public MobileElement confirmPasswordTextbox_android;
	@FindBy(xpath = "//android.view.View[@resource-id='user-detail']") public MobileElement userInformationPageHeader_android;
	@FindBy(xpath = "//android.widget.EditText[@resource-id='firstName'] | //*[@resource-id='com.tatadigital.tcp.dev:id/edtFirstName']") public MobileElement firstNameTextbox_android;
	@FindBy(xpath = "//android.widget.EditText[@resource-id='lastName'] | //*[@resource-id='com.tatadigital.tcp.dev:id/edtLastName']") public MobileElement lastNameTextbox_android;
	@FindBy(xpath = "(//*[@resource-id='dob'])[2]") public MobileElement dobTextbox_android;
	@FindBy(id = "android:id/date_picker_header_year") public MobileElement headerYear_android;
	@FindBy(xpath = "//*[contains(@text,'1999')]") public MobileElement selectedYear_android;
	@FindBy(xpath = "//*[@text='1']") public MobileElement selectedDay_android;
	@FindBy(id = "android:id/button1") public MobileElement setDOB_android;
	@FindBy(xpath = "//android.widget.EditText[@resource-id='email']") public MobileElement emailTextbox_android;
	@FindBy(xpath = "//*[@text='Gender']/parent::android.view.View") public MobileElement genderDropdown_android;
	@FindBy(xpath = "//*[contains(@text,'I have read and understood')]") public MobileElement termsAndConditionCheckbox_android;
	@FindBy(xpath = "//*[contains(@text,'Let')]") public MobileElement letsGoButton_android;
	@FindBy(xpath = "//*[contains(@text,'share your location access')]") public MobileElement locationAccessHomepage_android;
	@FindBy(xpath = "//*[contains(@text,'Allow')]") public MobileElement allowLocationHomepage_android;
	@FindBy(xpath = "//*[contains(@text,'No,thanks')]") public MobileElement denyLocationHomepage_android;
	@FindBy(xpath = "//*[contains(@text,'Skip demo')]") public MobileElement skipDemoHomepage_android;
	
	@FindBy(xpath = "//android.view.View[@resource-id='toast-message'] | //*[contains(@text,'Terms and Conditions')]") public MobileElement toastMessageError;
	@FindBy(xpath = "//*[contains(@text,'marketing and promotional')]") public MobileElement marketingConsentCheckbox_android;
	@FindBy(xpath = "//*[contains(@text,'Submit')]") public MobileElement submitButton_android;
	@FindBy(xpath = "//*[contains(@text,'Forgot password')]") public MobileElement forgotPasswordlnk_android;
	@FindBy(xpath = "//*[contains(@text,'Password must be of minimum 8 digit length and should contain one lower character, one upper character, one number and one special character')]") public MobileElement passwordErrorMsg_android;
	@FindBy(xpath = "//*[contains(@text,'Your password and confirm password did not match')]") public MobileElement confirmPasswordErrorMsg_android;
	@FindBy(xpath = "//android.view.View[contains(@text,'Year')]") public MobileElement calendarYearTab_android;
	@FindBy(xpath = "//android.view.View[contains(@text,'Month']") public MobileElement calendarMonthTab_android;
	@FindBy(xpath = "//android.view.View[contains(@text,'Date']") public MobileElement calendarDateTab_android;
	@FindBy(xpath = "//android.view.View[contains(@text,'<']") public MobileElement previousYearPageBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Save')]") public MobileElement saveDate_android;
	@FindBy(xpath = "//*[contains(@text,'Next')]") public MobileElement datePickerNextBtn_android;
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Continue')] | //*[@resource-id='com.tatadigital.tcp.dev:id/continueButton']") public MobileElement continueInterestButton_android;
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Skip')]") public MobileElement skipInterestButton_android;
	@FindBy(xpath = "//*[contains(@text,'Male')]") public MobileElement genderMale_android;
	@FindBy(xpath = "//*[contains(@text,'Female')]") public MobileElement genderFemale_android;
	@FindBy(xpath = "//*[contains(@text,'This field is required')]") public MobileElement fieldRequiredError_android;
	@FindBy(xpath = "//span[@id='passwordError']") public MobileElement passwordErrorWebView;
	@FindBy(xpath = "//span[@id='confirm-passwordError']") public MobileElement ConfirmPasswordErrorWebView;
	@FindBy(xpath = "//*[contains(@text,'Your password and confirm password did not match')]") public MobileElement oldpassError_android;
	@FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View/android.widget.Image[1]") public MobileElement backBtn1_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/backImageView']") public MobileElement backBtn2_android;
	
	@FindBy(xpath = "//*[@resource-id='firstNameError']") public MobileElement firstNameErrorMsg_android;
	@FindBy(xpath = "//*[@resource-id='lastNameError']") public MobileElement lastNameErrorMsg_android;
	@FindBy(xpath = "//*[@resource-id='emailError']") public MobileElement emailErrorMsg_android;
	@FindBy(xpath = "//*[@resource-id='dobError']") public MobileElement dobErrorMsg_android;
	@FindBy(xpath = "//*[@resource-id='genderError']") public MobileElement genderErrorMsg_android;
	@FindBy(xpath = "//*[@resource-id='countryCodeBoxError']") public MobileElement countryCodeErrorMsg_android;
	@FindBy(xpath = "//*[@resource-id='passwordError']") public MobileElement setPasswordFormatError_android;
	@FindBy(xpath = "//*[@resource-id='password-boxError']") public MobileElement loginPasswordBoxError_android;
	@FindBy(xpath = "//*[@resource-id='phoneError']") public MobileElement mobileNumberErrorMsg_android;
	@FindBy(xpath = "//*[contains(@text,'Welcome to TCP')]") public MobileElement userRegistrationPageHeader_android;
	@FindBy(xpath = "//*[@text='Salutation']/parent::android.view.View") public MobileElement salutationDropdown_android;
	@FindBy(xpath = "//*[@resource-id='salutationError']") public MobileElement salutationErrorMsg_android;
	@FindBy(xpath = "//*[@text='Welcome to Chrome']") public MobileElement chromeHeader_android;
	@FindBy(id = "com.android.chrome:id/terms_accept") public MobileElement acceptChromeTerms_android;
	@FindBy(id = "com.android.chrome:id/next_button") public MobileElement nextbtn_android;
	@FindBy(id = "com.android.chrome:id/signin_title") public MobileElement signInChrome_android;
	@FindBy(id = "com.android.chrome:id/negative_button") public MobileElement negativeBtn_android;
	@FindBy(id = "com.android.chrome:id/positive_button") public MobileElement positiveBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Skip')]") public MobileElement skipBtn_android;
	
	//SIT-Cycle1 sign up locators --
	//Android
	@FindBy(xpath = "//*[@text='TCP | Simplifying life']") public MobileElement welcomePageHeader_android;
	@FindBy(xpath = "//*[contains(@text,'Start!')] | //*[@resource-id='com.tatadigital.tcp.dev:id/txtLetsStart'] | //*[@resource-id='com.tatadigital.tcp:id/mobileConfirmButton']") public MobileElement letsStartBtn_android;
	@FindBy(xpath = "//*[@text='NONE OF THE ABOVE']") public MobileElement autoMobNoSelection_dismiss_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/mobileEnterInfoTextView") public MobileElement mobileNumEntryPgeHdrTxt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTs") public MobileElement termsOfServiceLink_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPrivacyPolicy") public MobileElement privacyPolicyLink_android;
	@FindBy(xpath = "//*[contains(@text,'if you are from GDPR, CCPA region')] | //*[contains(@text,'EU or California?')]") public MobileElement gdprCCPAText_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvGdprCcpaClick") public MobileElement clickHereBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ckPrivacyPolicy") public MobileElement privacyPolicyCheckBox_android;
	@FindBy(xpath = "//*[@text='OTP has expired']") public MobileElement otpExpiredTxt_android;
	@FindBy(xpath = "//*[@text='Resend code'] | //*[@text='Resend OTP']") public MobileElement resendOtpCodeBtn_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button") public MobileElement allowLocationPermission_android;
	@FindBy(xpath = "//*[contains(@text,'Welcome to TCP')]") public MobileElement userDtlsPgHeaderTxt_android;	
	@FindBy(xpath = "//*[contains(@text,'Shop now')]") public MobileElement shopNowText_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu']") public MobileElement hamburgerMenuBtn_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/profileOptionsItemsLayout'])[1]") public MobileElement profileBtn_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtFirstName']") public MobileElement firstNameTxt_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtLastName']") public MobileElement lastNameTxt_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtPhoneNumber']") public MobileElement phoneNumTxt_android;
	@FindBy(xpath = "//*[@text='NONE OF THE ABOVE']") public MobileElement none_of_above_mobile_number_android;
	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button") public MobileElement allow_button_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtOldPassword']") public MobileElement oldPwdBox_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtNewPassword']") public MobileElement newPwdBox_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtConfirmNewPassword']") public MobileElement confirmNewPwdBox_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvUpdatePassword']") public MobileElement updatePwdBtn_android;
	@FindBy(xpath = "//*[@text='Invalid input'] | //*[contains(@text,'missing')] | //*[contains(@text,'cannot be the same')]") public MobileElement pwdErrorTxt_android;
	@FindBy(xpath = "(//android.widget.ImageButton[@content-desc='Show password'])[1]") public MobileElement showOldPwdBtn_android;
	@FindBy(xpath = "(//android.widget.ImageButton[@content-desc='Show password'])[2]") public MobileElement showNewPwdBtn_android;
	@FindBy(xpath = "(//android.widget.ImageButton[@content-desc='Show password'])[3]") public MobileElement showConfirmNewPwdBtn_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/txtHeading']") public List<MobileElement> welcomePageSubTexts;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/contentLayout']") public MobileElement contentLayout_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/contentLayout']/*[@resource-id='com.tatadigital.tcp.dev:id/tvTitle']") public MobileElement contentTitle_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/contentLayout']/*[@resource-id='com.tatadigital.tcp.dev:id/tvDetail']") public MobileElement contentDetails_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/crossIv'] | //*[@resource-id='com.tatadigital.tcp.dev:id/skipTourTextView']") public MobileElement closeContentBtn_android;
	@FindBy(xpath = "//*[@text='//*[@text='Allow']']") public MobileElement allowButton_android;
	
	@FindBy(xpath = "//*[@text='Welcome to Tata Digital']") public MobileElement tataDigitalTextonCorpEmailScreen;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/etCorpEmailIdReferralCode']") public MobileElement corpEmailField_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tIInputPincode']") public MobileElement corpPinField_android;
	@FindBy(xpath = "//*[@text='Next']") public MobileElement NextTxtOnCorpScreen_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvNeither']") public MobileElement iDonntHaveOneCorpScreen_android;
	@FindBy(xpath = "//*[contains(@text,'Coming to you soon')]") public MobileElement coming2usoonTxtAfterCorpScreen_android;
	@FindBy(xpath = "//*[@text='You know our name']") public MobileElement youKnowOurNameTxtAfterCorpScreen_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtFirstNamePilot']") public MobileElement firstNameFieldaterCorpScreen_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtLastNamePilot']") public MobileElement lastNameFieldafterCorpScreen_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtGenderPilot']") public MobileElement genderFieldafterCorpScreen_android;
	@FindBy(xpath = "//*[@text='Male']") public MobileElement maleGenderFieldafterCorpScreen_android;
	@FindBy(xpath = "//*[@text='Female']") public MobileElement femaleGenderFieldafterCorpScreen_android;
	@FindBy(xpath = "//*[@text='Transgender']") public MobileElement transgenGenderFieldafterCorpScreen_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtEmailIdPilot']") public MobileElement emailFieldafterCorpScreen_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/icNativeLoginToolbar']") public MobileElement popupOnCorpScreen_android;
	@FindBy(xpath = "//*[contains(@text,'Enter the OTP we have sent to your Corporate Email ID')]") public MobileElement enterTheOtpScreen_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/otpPinView'] | //*[@resource-id='com.tatadigital.tcp:id/otpPinView']") public MobileElement enterTheOtpField_android;
	
	
	
	//IOS
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Welcome to TCP APP']") public MobileElement welcomePageHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Great!')]/.. | //XCUIElementTypeStaticText[contains(@name,'start')]/..") public MobileElement letsStartBtn_ios;
	@FindBy(xpath = "//*[@name='Please enter your phone number'] | //*[@name='iconMobile']/following-sibling::XCUIElementTypeStaticText") public MobileElement mobileNumEntryPgeHdrTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Terms of Use & Privacy Policy']") public MobileElement termsOfUseAndPrivacyPolicyLink_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='I agree to Privacy Policy']") public MobileElement privacyPolicyLink_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Click here If you are from GDPR, CCPA region']") public MobileElement gdprCCPAText_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Click here If you are from GDPR, CCPA region']") public MobileElement clickHereBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='unselectedCheckbox']") public MobileElement privacyPolicyCheckBox_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='OTP has expired']") public MobileElement otpExpiredTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Resend code']") public MobileElement resendOtpCodeBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Login with Password']") public MobileElement btnLoginwithpassword_ios;
	
	@FindBy(xpath = "//*[@name='Welcome to TCP']") public MobileElement userDtlsPgHeaderTxt_ios;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Shop now')]") public MobileElement shopNowText_ios;
	
	
	
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='your phone number']") public MobileElement mobileNumberHeader;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign in with TCP'] | //XCUIElementTypeStaticText[@name='Great!'] | //XCUIElementTypeStaticText[@name='Great! Let�s Start!']") public MobileElement signinButton_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@value='Enter phone number']/preceding-sibling:: XCUIElementTypeButton/XCUIElementTypeStaticText") public MobileElement countryCodeTextBox_ios;
	//@FindBy(xpath = "//XCUIElementTypeOther[@name='Tata Digital Login']/XCUIElementTypeOther[2]") public MobileElement countryCodeTextBox_ios1;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Tata Digital Login']/XCUIElementTypeOther[3]/XCUIElementTypeTextField | //XCUIElementTypeTextField[@name='Enter your phone number'] | //XCUIElementTypeTextField[@value='Mobile number'] | //XCUIElementTypeTextField[@value='Enter phone number']" ) public MobileElement mobileNoTextBox_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Confirm'] | //XCUIElementTypeButton[@name='Get OTP']") public  MobileElement confirmButton_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name='Login with OTP')]") public MobileElement enterOtpHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Tata Digital Login']/XCUIElementTypeTextField | //XCUIElementTypeImage[@name='iconOtpLocked']/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther//XCUIElementTypeTextField") public MobileElement enterOtpTextbox_ios;
	//XCUIElementTypeStaticText[@name='Set New Password']
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Set New Password']") public MobileElement setNewPasswordHeader_ios;
	
	@FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='Password must be of minimum 8 digit length and should contain one lower character, one upper character, one number and one special character']") public MobileElement newPasswordTextbox_ios;
	@FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='confirm password']") public MobileElement confirmPasswordTextbox_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Welcome to TCP']") public MobileElement userInformationPageHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='First name should be alphabets only'] | //XCUIElementTypeTextField[2]") public   MobileElement firstNameTextbox_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='Last name should be alphabets only'] | //XCUIElementTypeTextField[1]") public  MobileElement lastNameTextbox_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='Please enter your email address']") public  MobileElement emailTextbox_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'I represent and warrant that I have read and understood')]") public MobileElement termsAndConditionCheckbox_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'I agree to receive marketing and promotional emails')]") public MobileElement marketingConsentCheckbox_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Submit']") public MobileElement submitButton_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.interest.continue '] | //XCUIElementTypeStaticText[@name='Continue']") public MobileElement continueInterestButton_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']") public MobileElement skipInterestButton_ios;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Age should be minimum 18 years or above']/XCUIElementTypeOther/XCUIElementTypeTextField") public MobileElement dobTextbox_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Gender']/following-sibling::XCUIElementTypeOther") public MobileElement genderDropdown_ios;
	@FindBy(xpath = "//*[@name='Male']") public MobileElement genderMale_ios;
	@FindBy(xpath = "//*[@name='Female']") public MobileElement genderFemale_ios;

	@FindBy(xpath = "//*[@name='OK']")	public MobileElement okAlert;
	@FindBy(xpath = "//*[@name='Allow'] | //XCUIElementTypeButton[@name='Allow'] | //*[@name='OK']") public MobileElement allowAlert;
	@FindBy(xpath = "//*[@name='Continue']") public MobileElement continueAlert;
	@FindBy(xpath = "//XCUIElementTypePickerWheel[1]") public MobileElement dayPicker;
	@FindBy(xpath = "//XCUIElementTypePickerWheel[2]") public MobileElement monthPicker;
	@FindBy(xpath = "//XCUIElementTypePickerWheel[3]") public MobileElement yearPicker;
	@FindBy(xpath = "//XCUIElementTypePickerWheel[1]") public MobileElement genderPicker;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.home.valutButton']") public MobileElement vaultLink_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Tata Digital Login']/XCUIElementTypeOther[4]//XCUIElementTypeSecureTextField | //XCUIElementTypeSecureTextField[@name='Please enter you password here'] | //XCUIElementTypeSecureTextField[@value='Enter password'] | (//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[2]/XCUIElementTypeSecureTextField") public MobileElement loginPasswordBox_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Tata Digital Login']/XCUIElementTypeOther[3]/XCUIElementTypeStaticText") public MobileElement countryCodeErrorMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Please accept the Terms and Conditions']") public MobileElement termConditionErrorMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm password is not same as new password']") public MobileElement confirmPasswordMismatchError_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Password must be of minimum 8 digit length and should contain one lower character, one upper character, one number and one special character']") public MobileElement setPasswordFormatError_ios;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='First Name']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText") public MobileElement firstNameErrorMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Last Name']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText") public MobileElement lastNameErrorMsg_ios;
	@FindBy(xpath = "//*[@name='Email']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText") public MobileElement emailErrorMsg_ios;
	@FindBy(xpath = "//*[@name='Date of birth']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText") public MobileElement dobErrorMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Gender']/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeStaticText") public MobileElement genderErrorMsg_ios;

	//@FindBy(xpath = "") public MobileElement passwordErrorMsg_ios;
	@FindBy(xpath = "//*[@name='Done'] | //*[@name='OK']") public MobileElement keyboardDone_ios;
	@FindBy(xpath = "//*[@name='OK'] | //*[@name='Return'] | //*[@label='return']") public MobileElement keyboardOk_ios;
	@FindBy(xpath = "//*[@name='Return'] | //*[@label='return']") public MobileElement keyboardReturn_ios;

	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Year']") public MobileElement calendarYearTab_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Month']") public MobileElement calendarMonthTab_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Date']") public MobileElement calendarDateTab_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='<']") public MobileElement previousYearPageBtn_ios;
	@FindBy(xpath = "//*[@name='Save']") public MobileElement saveDate_ios;
	@FindBy(xpath = "//*[@name='Next']") public MobileElement datePickerNextBtn_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Forgot password']") public MobileElement forgotPasswordlnk_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Password must be of minimum 8 digit length and should contain one lower character, one upper character, one number and one special character']") public MobileElement passwordErrorMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@type='XCUIElementTypeStaticText']") public MobileElement allErrorMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']") public MobileElement cancelBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Dismiss']") public MobileElement dismissBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='This field is required']") public MobileElement requiredFieldError_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Your new password cannot be the same as your previous 3 passwords']") public MobileElement oldpassError_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Tata Digital Login']/XCUIElementTypeOther[4]/XCUIElementTypeStaticText") public MobileElement mobileNumberErrorMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Salutation']/following-sibling::XCUIElementTypeOther[1]") public MobileElement salutationDropdown_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Salutation']/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeStaticText") public MobileElement salutationErrorMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.appTour.continue'] | //XCUIElementTypeStaticText[contains(@name,'Great')] | //XCUIElementTypeButton[contains(@label,'start')]") public MobileElement letsStart_ios;	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Confirm'] | //XCUIElementTypeButton[@name='Get OTP']") public MobileElement confirmBtn_IOS;
	@FindBy(xpath = "//*[contains(@value,'Skip')] | //*[contains(@label,'Skip')]") public MobileElement skipTourBtn_IOS;	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Allow Button']") public MobileElement allow_button_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Or login using password']") public MobileElement loginusingpswd_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Password']") public MobileElement pswdtextbox_ios;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
