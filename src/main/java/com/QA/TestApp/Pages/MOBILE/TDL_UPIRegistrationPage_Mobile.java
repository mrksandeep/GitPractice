package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_UPIRegistrationPage_Mobile {
	
	public TDL_UPIRegistrationPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/etUpiId") public MobileElement etUpiId_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnVerify") public MobileElement btnVerify_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/btnProceed") public MobileElement btnProceed_android;
	@FindBy(id ="") public MobileElement editUpiIDHeader_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/cbMarkDefault") public MobileElement cbMarkDefault_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/rbSuggestion")}) public List<MobileElement> selectSuggestion_android;

	//lipika//
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvVerifyMob") public MobileElement verifyMobNum_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDesc") public MobileElement mobDesc_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rb_01") public MobileElement selectSim1_android;

	@FindBy(id = "com.android.permissioncontroller:id/permission_message") public MobileElement permissionmsg_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button") public MobileElement allowBtn_android;

	@FindBy(xpath="//*[contains(@text, 'VERIFY MOBILE NUMBER')]") public MobileElement verifyMobNum1_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/progressBar") public MobileElement progressBar_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/loyalty_progress_bar") public MobileElement loader_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvVerifyMob")public MobileElement verifyMob_android;//CONGRATULATIONS!
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDesc") public MobileElement descMessage_android;//Your mobile has been verified.
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMessage")public MobileElement message_android;//	
	//Looks like you are already registered with us, please enter below details to fetch your existing profile.
	@FindBy(id="com.tatadigital.tcp.dev:id/editFirstName") public MobileElement firstName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/editLastName") public MobileElement lastLame_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvNameInputInstruction")public MobileElement nameInputInst_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnSkip")public MobileElement skipBtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnSubmit") public MobileElement submitBtn_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/rbSuggestion")})public List<MobileElement> upiIdSuggestions_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/etUpiId")public MobileElement enterUPIID_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnVerify")public MobileElement verifyBtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUpiInputError")public MobileElement upiInputErr_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/cbMarkDefault")public MobileElement checkDefault_android_old;//checked=true
	@FindBy(id="com.tatadigital.tcp.dev:id/btnProceed")public MobileElement createUPIIdbtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/etBank")public MobileElement searchBank_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvBankName")}) public List<MobileElement> bankNameList;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/cbMarkDefault") public MobileElement checkDefault_android;  //Set this as my default UPI ID on Tata Pay
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSetVpaDefaultMessage") public MobileElement vpaDefaultMessage_android; //This will allow Tata Pay as your primary UPI ID in this app and you won't be able to select Other UPI ID for payment.
	@FindBy(id="com.tatadigital.tcp.dev:id/tvVpa") public MobileElement vpa_android_onboard;//9748167511-3@tapicici
	@FindBy(id="com.tatadigital.tcp.dev:id/tvVerifyMob") public MobileElement msgverifyMobile_android; //Congratulations!
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDesc") public MobileElement msgDescMobile_android; //Your mobile has been verified
	
	//Multitender Page
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAddPaymentOption") public MobileElement changeMultiTenderPageUPI_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/clUPIAmtLayout") public MobileElement clUPIAmtLayout_android;
	@FindAll({@FindBy(id = "com.tatadigital.tcp.dev:id/tvUpi")}) public List<MobileElement> tvUPI_android;
	@FindAll({@FindBy(id = "com.tatadigital.tcp.dev:id/cbRecentBill")}) public List<MobileElement> recentBill_android;
	@FindBy(xpath="//*[@text='Use other UPI']") public MobileElement useOtherUPI;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMsg") public MobileElement popUpMsg_android;//Are you sure you want to change your default UPI ID selection on Tata Pay?
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPositive") public MobileElement btnPositive_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnNegative") public MobileElement bynNegative_android;
	@FindBy(id ="com.android.packageinstaller:id/permission_allow_button") public MobileElement smsAllow_android;

	
	/**
	 * Define ios locators
	 * 
	 */
	
	@FindBy(xpath="//XCUIElementTypeActivityIndicator[@name='In progress']") public MobileElement inProgressWheel_ios;

	
}
