package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_HomeInsurancePage_Mobile {
	
	public TDL_HomeInsurancePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/*
	 * Define Android Locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnInsuranceNext") public MobileElement nextBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Proceed')] | //*[contains(@text,'Continue')]") public MobileElement proceedBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Continue')]") public MobileElement continueBtn_android;
	//Add Address locators 
	@FindBy(xpath = "//*[contains(@text,'SELECT AN ADDRESS')]") public MobileElement selectAddressTxt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivAddNewAddress") public MobileElement addnew_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserFlatNo") public MobileElement flatNo_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInputInsuranceUserAddress") public MobileElement address_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserLandmark") public MobileElement landmark_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserPinCode") public MobileElement pincode_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserCity") public MobileElement insuranceUserCity;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserState") public MobileElement insuranceUserState;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivAddressHomeTag") public MobileElement home_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivAddressWorkTag]") public MobileElement work_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivAddressCustomTag") public MobileElement custom_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvInsuranceUserCustomLabel") public MobileElement label_android;
	//Author:-Akshya
	@FindBy(id="com.android.packageinstaller:id/permission_allow_button:-Allow_Button") public MobileElement Allow_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtSearchAddress") public MobileElement Search_Addres_android;
	@FindBy(xpath="(//android.view.ViewGroup[@resource-id='com.tatadigital.tcp.dev:id/mainView'])[1]") public MobileElement First_Addres_text;
	
	
	//Akshya
	
	//Basic Details Locators
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceBasicDetails") public MobileElement basicDetails_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserTitle") public MobileElement title_android;
	@FindBy(xpath = "//*[contains(@text,'Mr')]") public MobileElement titleMr_android;
	@FindBy(xpath = "//*[contains(@text,'Mrs')]") public MobileElement titleMrs_android;
	@FindBy(xpath = "//*[contains(@text,'Ms')]") public MobileElement titleMs_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserFirstName") public MobileElement firstName_android;	
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserMiddleName") public MobileElement middleName_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserLastName") public MobileElement lastName_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserGender") public MobileElement gender_android;
	@FindBy(xpath = "//*[contains(@text,'Male')]") public MobileElement genderMale_android;
	@FindBy(xpath = "//*[contains(@text,'Female')]") public MobileElement genderFemale_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserDateOfBirth") public MobileElement dateOfBirth_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserPhoneNumber") public MobileElement phoneNumber_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserEmailId") public MobileElement emailId_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceUserAddress") public MobileElement insuredAddress_android;
	
	//Insurance Details Confirmation Locators
	@FindBy(xpath = "//*[contains(@text,'Check your details')]") public MobileElement confirmPageHeader_android;
	@FindBy(xpath = "//*[contains(@text,'BASIC DETAILS')]") public MobileElement basicDetailsTabHeader_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/cbTermsAndConditions") public MobileElement tAndCondCheckBox_android;
	@FindBy(xpath = "//*[contains(@text,'Terms')]") public MobileElement tAndCondLink_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnInsurancePayNow") public MobileElement payNowBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Payments')]") public MobileElement paymentPageHeader_android;
		
	//final Page
	@FindBy(xpath = "//*[contains(@text,'Success')]") public MobileElement successBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Done! Payment Complete')]") public MobileElement paymentSuccess_android;
	@FindBy(xpath = "//*[contains(@text,'Failure')]") public MobileElement failureBtn_android;

	@FindBy(xpath = "//*[@text='Finance']") public MobileElement finance_android;
	@FindBy(xpath = "//*[contains(@text, 'Home Away')]/following-sibling::*[@text='Know More']") public MobileElement KnowMoreHomeInsurance;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnInsuranceBuyNow") public MobileElement btnBuyNow;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnNext") public MobileElement btnProceed;
	//Akshya
	@FindBy(id = "com.tatadigital.tcp.dev:id/messageTextView") public MobileElement ErrormesgText;
	@FindBy(id = "com.tatadigital.tcp.dev:id/positiveButton") public MobileElement btnAddcard;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button") public MobileElement btnAllow;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etCardName") public MobileElement inputfieldCardname;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etCardNumber") public MobileElement inputfieldCardno;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etExpMonth") public MobileElement btnexpirymonth;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etExpYear") public MobileElement btnexpiryYear;
	@FindBy(xpath = "//*[contains(@text ,'05')]") public MobileElement selectdate;
	@FindBy(xpath = "//*[contains(@text ,'25')]") public MobileElement selectYear;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnAddCardContinue") public MobileElement btnContinue;
	@FindBy(id = "com.tatadigital.tcp.dev:id/positiveButton") public MobileElement btnOkay;
	@FindBy(id = "com.tatadigital.tcp.dev:id/positiveButton") public MobileElement btnseemyplans;
	@FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Plans']") public MobileElement btnplans;
	@FindBy(xpath = "//*[@text='Manage Plans']") public MobileElement btnManagePlans;
	
	
	/*   
	 * Define ios Locators
	 * 
	 */
	
@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Next']") public MobileElement nextBtn_ios;
@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Proceed'] | //XCUIElementTypeStaticText[@name='Continue'] | //XCUIElementTypeButton[@name='tcpApp.formVC.saveChanges']") public MobileElement proceedBtn_ios;

//Add Address locators
@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Activate Home Protection'] | //XCUIElementTypeStaticText[contains(@name,'Safeguard Your Home')]") public MobileElement selectAddressTxt_ios;
@FindBy(id="com.tatadigital.tcp.dev:id/edtSearchAddress") public MobileElement Search_Addres_ios;
@FindBy(xpath = "//XCUIElementTypeStaticText[@name='add_address_label'] | //XCUIElementTypeStaticText[@name='Add New Address']") public MobileElement addnew_ios;
@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[1]/XCUIElementTypeTextField") public MobileElement flatNo_ios;
@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[2]/XCUIElementTypeTextField") public MobileElement address_ios;
@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[3]/XCUIElementTypeTextField") public MobileElement landmark_ios;
@FindBy(xpath = "(//XCUIElementTypeCell[@name=\"tcpApp.formVC.enrollmentTextFieldCell\"])[4]/XCUIElementTypeTextField") public MobileElement pincode_ios;
@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell']/XCUIElementTypeTextField[2]") public MobileElement insuranceUserCity_ios;
@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell']/XCUIElementTypeTextField[1]") public MobileElement insuranceUserState_ios;
@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Home']") public MobileElement home_ios;
@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Work']") public MobileElement work_ios;
@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Custom']") public MobileElement custom_ios;
@FindBy(xpath="//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'][5]/XCUIElementTypeTextField") public MobileElement label_ios;
@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SELECT AN ADDRESS\"]") public MobileElement selectAddress_ios;
//Basic Details Locators
@FindBy(xpath = "//XCUIElementTypeStaticText[@name='BASIC DETAILS'][1]") public MobileElement basicDetails_ios;
@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'][1]/XCUIElementTypeTextField[2]") public MobileElement title_ios;
@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'][1]/XCUIElementTypeTextField[1]") public MobileElement firstName_ios;	
@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'][2]/XCUIElementTypeTextField[2]") public MobileElement middleName_ios;
@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'][2]/XCUIElementTypeTextField[1]") public MobileElement lastName_ios;
@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'][3]/XCUIElementTypeTextField[2]") public MobileElement gender_ios;
@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'][3]/XCUIElementTypeTextField[1]") public MobileElement dateOfBirth_ios;
@FindBy(xpath = "//XCUIElementTypeTextField[@name='tcpApp.formVC.phoneNumber']") public MobileElement phoneNumber_ios;
@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'][1]/XCUIElementTypeTextField") public MobileElement emailId_ios;

//Insurance Details Confirmation Locators
	//@FindBy(xpath = "//*[contains(@text,'Review & Confirm')]") public MobileElement confirmPageHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='BASIC DETAILS']") public MobileElement basicDetailsTabHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='unselectedCheckbox']") public MobileElement tAndCondCheckBox_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Terms and Conditions']") public MobileElement tAndCondLink_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay Now']") public MobileElement payNowBtn_ios;
	@FindBy(xpath = "////XCUIElementTypeStaticText[@name='Payments']") public MobileElement paymentPageHeader_ios;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"Razorpay | OTP Page\"]/XCUIElementTypeOther[7]/XCUIElementTypeTextField") public MobileElement otpFeild_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit\"]") public MobileElement submitbtnBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Success']") public MobileElement successBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Done! Payment Complete']") public MobileElement paymentSuccess_ios;
	
	//R2
	
	@FindBy(xpath = "//*[contains(@text,'Review & Confirm')]") public MobileElement allowLocationTxt_ios;
	@FindBy(xpath = "//*[contains(@text,'BASIC DETAILS')]") public MobileElement allowUsingApp_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='unselectedCheckbox']") public MobileElement addressTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='insurance.findAddress.searchTextField']") public MobileElement addressBox_ios;
	@FindBy(xpath = "(//XCUIElementTypeImage[@name=\"insurance.findAddress.searchIcon\"])[2]") public MobileElement firstAddress_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"tcpApp.formVC.invalidTextLabel\"]") public MobileElement pincode_error_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"insurance.findAddress.findAddresstitle\"]") public MobileElement address_error_ios;
	//R2 Android sk
		@FindBy(id = "com.tatadigital.tcp.dev:id/ivHamburgerMenu") public MobileElement profilebuttonclick;
		@FindBy(xpath = "//*[@text='Money']") public MobileElement money_android;
		@FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Insurance\"]/android.widget.TextView") public MobileElement insuranceclick_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/btn_buyNow") public MobileElement Cardfraudsecureplan_buynow_android;
		@FindBy(xpath = "(//*[contains(@text,'Home Away Secure Plan')]/following-sibling::*)[2]") public MobileElement homefraudsecureplan_buynow_android;
		@FindBy(xpath = "//*[contains(@text,'Active Plans')]") public MobileElement activePlanHdr_android;
		@FindBy(xpath = "//*[contains(@text,'Manage Plans')]") public MobileElement myplantabnavigation_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/tvPaymentStatus") public MobileElement payment_status;
		@FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionId") public MobileElement transaction_id;
		@FindBy(xpath = "//*[contains(@text,'enter more accurate address')]") public MobileElement address_error_android;
		@FindBy(xpath = "//*[contains(@text,'Can you check')]") public MobileElement pincode_error_android;
		//ios
		@FindBy(xpath = "//XCUIElementTypeButton[@name='unselectedCheckbox']") public MobileElement tCondCheckBox_ios;
		@FindBy(xpath = "//*[@label='Finance']") public MobileElement finance_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Card Fraud')]/following-sibling::XCUIElementTypeButton[@name='Buy Now']") public MobileElement Cardfraudsecureplan_buynow_ios;
		@FindBy(xpath = "//XCUIElementTypeButton[@name='Insurance']") public MobileElement insuranceclick_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Home Away Secure Plan')]/following-sibling::XCUIElementTypeButton[@name='Buy Now']") public MobileElement homefraudsecureplan_buynow_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Home Away Secure Plan')]/following-sibling::XCUIElementTypeButton[@name='Know More']") public MobileElement KnowMoreHomeInsurance_ios;
		@FindBy(xpath = "//XCUIElementTypeButton[@name='Buy Now']") public MobileElement btnBuyNow_ios;
		@FindBy(xpath = "//XCUIElementTypeButton[@name='Proceed']") public MobileElement btnProceed_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='INR 100 | Coverage INR 2,50,000/-']") public MobileElement plan100_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='INR 199 | Coverage INR 5,00,000/-']") public MobileElement plan199_ios;
		
		@FindBy(xpath = "//XCUIElementTypeButton[@name='Add Card']") public MobileElement addCard_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Tata AIG Card Protection Plan']") public MobileElement addCardPopup_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Tata AIG Card Protection Plan']/following-sibling::XCUIElementTypeStaticText[1]") public MobileElement addCardPopupDesc_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Terms and Conditions']") public MobileElement TermsCond_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Ok']") public MobileElement TermsCondyes_ios;
		@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.cardHolderNameTextField']") public MobileElement CardName_ios;
		@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.cardNumberTextField']") public MobileElement CardNumber_ios;
		@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.monthTextField']") public MobileElement CardNumbermonth_ios;
		@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.yearTextField']") public MobileElement CardNumberyear_ios;
		@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.aliasNameTextField']") public MobileElement CardAlias_ios;
		@FindBy(xpath = "//XCUIElementTypeButton[@name='Add Account']") public MobileElement addCardnew_ios;
		@FindBy(xpath = "//XCUIElementTypeButton[@name='Done']") public MobileElement addCardDone_ios;
		@FindBy(xpath = "//XCUIElementTypeButton[@name='Activate Now']") public MobileElement Activate_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Plan Already Exists']") public MobileElement planExist_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Go To My Plans']") public MobileElement plan_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='You have already enrolled for this plan. Visit 'My Plans' section to manage your insurance plans']") public MobileElement plandesc_ios;
		@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[1]/XCUIElementTypeTextField[2]") public MobileElement titile_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mr']") public MobileElement titileSelect_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Manage Plans']") public MobileElement btnManageplansIos;
		
}
