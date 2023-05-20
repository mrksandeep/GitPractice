package com.QA.TestApp.Pages.MOBILE;
import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_ProfilePage_Mobile {
	
	public TDL_ProfilePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators 
	 * 
	 */
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvProfile']") public MobileElement profileHeader_android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvBasicDetails']") public MobileElement basicDetails_android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/edtTitle']") public MobileElement title_android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/edtFirstName']") public MobileElement firstName_android;	
	@FindBy(id="com.tatadigital.tcp.dev:id/edtMiddleName") public MobileElement middleName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtLastName") public MobileElement lastName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtGender") public MobileElement gender_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtDateOfBirth") public MobileElement dateOfBirth_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtMartialStatus") public MobileElement martialStatus_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtDateOfAnniversary") public MobileElement dateOfAnniversary_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtPhoneNumber") public MobileElement phoneNumber_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtEmailId") public MobileElement emailId_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMandatory") public MobileElement mandatory_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose") public MobileElement closeBtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSaveChanges") public MobileElement saveChanges_android;
	@FindBy(xpath="//*[@text='First name is mandatory']") public MobileElement firstnameError_android;
	@FindBy(xpath="//*[@text='Last name is mandatory']") public MobileElement lastNameError_android;
	@FindBy(xpath="//*[@text='Email id is mandatory']") public MobileElement emailIDError_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/textinput_error") public MobileElement allErrorElementsInProfilePage_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDefaultProfile") public MobileElement profilepic_android;
	@FindBy(xpath="//*[@text='Choose from Gallery']") public MobileElement choosefromgallery_android;
	@FindBy(xpath="//*[@text='Open Camera']") public MobileElement openCamera_android;
	@FindBy(id="com.android.packageinstaller:id/permission_allow_button") public MobileElement permission_allow_button_android;
	@FindBy(id="com.android.packageinstaller:id/permission_deny_button") public MobileElement permission_deny_button_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnEdit") public MobileElement edit_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnCancel") public MobileElement cancel_android;
	@FindBy(id="android:id/date_picker_header") public MobileElement date_picker_header_android;
	@FindBy(id="android:id/button2") public MobileElement cancelBtn_android;
	@FindBy(id="android:id/button1") public MobileElement okBtn_android;
	@FindBy(xpath="//android.view.View[@content-desc='01 August 2002']") public MobileElement selectYear_android;
	@FindBy(xpath="//android.widget.ImageButton[@content-desc='Previous month']") public MobileElement previousMonth_android;
	@FindBy(xpath="//android.widget.ImageButton[@content-desc='Next month']") public MobileElement nextMonth_android;
	@FindBy(id="android:id/date_picker_header_year") public MobileElement date_picker_header_year_android;
	@FindBy(xpath="//*[contains(@text, '1998')]") public MobileElement firstYearTab_android;
	@FindAll({@FindBy(id="android:id/text1")}) public List<MobileElement> yearList_andriod;
	@FindBy(id="android:id/date_picker_year_picker") public MobileElement date_picker_yearscroll_android;
	@FindBy(id="android:id/month_view") public MobileElement monthHeader_android;
	@FindAll({@FindBy(id = "android:id/month_view")}) public List<MobileElement> dayList_andriod;
	@FindBy(id="android:id/button1") public MobileElement okBtnCalender_android;

	   

	/**
	 * Define ios locators  
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Profile']") public MobileElement profileHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='BASIC DETAILS']") public MobileElement basicDetails_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[1]/XCUIElementTypeTextField[2]") public MobileElement title_ios;	
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[1]/XCUIElementTypeTextField[1]") public MobileElement firstname_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[2]/XCUIElementTypeTextField[1]")	public MobileElement lastname_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[2]/XCUIElementTypeTextField[2]") public MobileElement middlename_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[3]/XCUIElementTypeTextField[1]")	public MobileElement dob_ios;
	@FindBy(xpath="(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[3]/XCUIElementTypeTextField[2]") public MobileElement gender_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[4]/XCUIElementTypeTextField[2]")	public MobileElement marritalStatus_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[4]/XCUIElementTypeTextField[1]") public MobileElement doa_ios;
	@FindBy(id = "tcpApp.formVC.phoneNumber") public MobileElement phoneNumber_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.formVC.saveChanges']") public MobileElement saveChanges_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Email*']") public MobileElement emailID_ios;
	@FindBy(name="tcpApp.formVC.invalidTextLabel") public MobileElement allErrorElementsInAddressPage_ios;
	@FindAll({@FindBy(xpath="//XCUIElementTypePickerWheel")}) public List<MobileElement> datepickerwheel_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Done']") public MobileElement dateDone_ios;
	
}