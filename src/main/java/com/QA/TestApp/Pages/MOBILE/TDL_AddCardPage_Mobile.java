package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_AddCardPage_Mobile {

	public TDL_AddCardPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivBack")
	public MobileElement backBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etCardName")
	public MobileElement nameOnCard_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etCardNumber")
	public MobileElement cardNumber_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etExpYear")
	public MobileElement cardExpYear_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etTagName")
	public MobileElement alias_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etExpMonth")
	public MobileElement cardExpMonth_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnAddCardContinue")
	public MobileElement continueBtn_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivCardIcon")
	public MobileElement newcardlogo_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/textinput_error")
	public MobileElement allErrorAddCard_android;
	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView")
	public List<MobileElement> monthandyearListAddnewcard_andriod;
	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.TextView")
	public List<MobileElement> yearsList_andriod;
	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.TextView")
	public List<MobileElement> monthList_andriod;
	@FindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.TextView")
	public List<MobileElement>dayList_andriod;
	@FindBy(id ="com.tatadigital.tcp.dev:id/nextButton")
	public MobileElement calenderNext_andriod;
	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
	public MobileElement Month_andriod;
	@FindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView")
	public MobileElement year_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvMore")
	public MobileElement morebtn_VISA_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvActivities")
	public MobileElement activitiesbtn_VISA_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivTrash")
	public MobileElement deletebtn_VISA_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbToday")
	public MobileElement todaysRbtn_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbLast7Days")
	public MobileElement last7DaysRbtn_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbThisMonth")
	public MobileElement thisMonthRbtn_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbCustom")
	public MobileElement customRbtn_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPdf")
	public MobileElement pdfbtn_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnExcel")
	public MobileElement excelbtn_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivTxnClose ")
	public MobileElement closebtn_VISA_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tv")
	public MobileElement cardNumber_VISA_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvExpiry")
	public MobileElement expirydate_VISA_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvCardHolderName")
	public MobileElement cardholderName_VISA_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/closeImageView")
	public MobileElement closeCalender_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etEndDate")
	public MobileElement enddate_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etStartDate")
	public MobileElement startdate_andriod;
	
	
	@FindBy(id="com.tatadigital.tcp.dev:id/positiveButton")
	public MobileElement deleteConfirmBtn_android;
	@FindBy(id="//*[contains(@text,'AMEX')]")
	public  MobileElement AMEX_Card_andriod;
	@FindBy(id="//*[contains(@text,'BANKOFHAWAII')]")
	public MobileElement BANKOFHAWAII_andriod;
	@FindBy(xpath = "//*[contains(@text,'JP MORGAN')]")
	public MobileElement JP_MorganCard_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/txnDownloadState")
	public MobileElement error_anroid;
	@FindBy(xpath = "//*[contains(@text, 'TATA Pay UPI')]")public MobileElement tataPayUPI_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivClose")public MobileElement ivClose_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTitle")public MobileElement tvTitle_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUpiId")public MobileElement tvUpiId_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement btnPositive_android;

	@FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Activity']/android.widget.TextView")public MobileElement activity_andriod;
	@FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Filter']/android.widget.TextView")public MobileElement filter_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUpiSettings")public MobileElement tvUpiSettings_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivDropDown")public MobileElement ivDropDown_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBankName")public MobileElement tvBankName_andriod;	
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbCurrentDay")public MobileElement rbCurrentDay_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbCurrentWeek")public MobileElement rbCurrentWeek_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbCurrentMonth")public MobileElement rbCurrentMonth_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbCustom")public MobileElement rbCustom_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etStartDate")public MobileElement etStartDate_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etEndDate")public MobileElement etEndDate_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPdf")public MobileElement tvPdf_andriod;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvExcel")public MobileElement tvExcel_andriod;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")public MobileElement permission_allow_button_andriod;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/rbAccount")}) public List<MobileElement> rbAccount_android;

	/**
	 * Define ios locators
	 * 
	 */
	
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
	public MobileElement nameOnCard_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
	public MobileElement cardNumber_ios;
	@FindBy(xpath = "//*[contains(@value,'yyyy')]")
	public MobileElement cardExpYear_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[5]")
	public MobileElement alias_ios;
	@FindBy(xpath = "//*[contains(@value,'mm')]") public MobileElement cardExpMonth_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Continue']") public MobileElement continueBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']") public MobileElement backBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Card Expired']") public MobileElement errorExpiryDate_ios;
}
