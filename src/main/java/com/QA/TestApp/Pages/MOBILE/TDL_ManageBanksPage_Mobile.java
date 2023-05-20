package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_ManageBanksPage_Mobile {
	
	public TDL_ManageBanksPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvRequestBalance") public MobileElement tvRequestBalance_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnAddAccount") public MobileElement addAccount_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvBankName")}) public List<MobileElement> selectBank_android;
	@FindBy(xpath = "com.tatadigital.tcp.dev:id/ivLogo") public MobileElement ivLogo_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvChangeUpiPin") public MobileElement changeUpiPin_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvDeleteAccount") public MobileElement deleteAccount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvResetUpiPin") public MobileElement resetUpiPin_android;
	@FindBy(xpath = "//*[@text='Set UPI PIN']") public MobileElement setUpiPin_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement yes_android;
	@FindBy(xpath = "") public MobileElement no_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/form_item_input")}) public List<MobileElement> enterPin_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/ivMoreInfo")}) public List<MobileElement> ivMoreInfo_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvTitle") public MobileElement tvTitle_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvMsg") public MobileElement tvMsg_alreadylinked;

	//reset pin
	@FindBy(id = "com.tatadigital.tcp.dev:id/etCardNumber") public MobileElement etCardNumber_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etExpiryMonthYear") public MobileElement etExpiryMonthYear_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPerformAction") public MobileElement btnPerformAction_android;
	@FindBy(xpath = "//*[@text='Next']") public MobileElement nextBtn_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/ivClose") public MobileElement ivClose_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/ivSelection")}) public List<MobileElement> primaryAcc_android;
	@FindBy(xpath = "//*[@text='1']") public MobileElement otp_android1;
	@FindBy(xpath = "//*[@text='2']") public MobileElement otp_android2;
	@FindBy(xpath = "//*[@text='3']") public MobileElement otp_android3;
	@FindBy(xpath = "//*[@text='4']") public MobileElement otp_android4;
	@FindBy(xpath = "//*[@text='5']") public MobileElement otp_android5;
	@FindBy(xpath = "//*[@text='6']") public MobileElement otp_android6;
    @FindBy(id = "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement btnPositive_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/form_item_input")}) public List<MobileElement> enterclick_android;
	
	//oct27
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBankName") public MobileElement bank_name_android ;
//oct28
	@FindBy(xpath ="//*[contains(@text, 'Transfer to Bank')]") public MobileElement transfer_android;
	
	//oct29
	@FindBy(xpath ="//*[contains(@text, 'Create your own')]") public MobileElement create_upi_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/etUpiId") public MobileElement edit_upi_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/btnVerify") public MobileElement verify_upi_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnProceed") public MobileElement update_upi_android;
	@FindBy(xpath="//*[contains(@text, '@tapicici')]") public List<MobileElement> upi_suggestion_android;
	
	//19-11
		@FindBy(id ="com.tatadigital.tcp.dev:id/tvDesc") public MobileElement tvMobileVerified_android;
		@FindBy(id ="com.tatadigital.tcp.dev:id/cbMarkDefault") public MobileElement defaultUPICheckbox_android;
		@FindBy(id ="com.tatadigital.tcp.dev:id/tvUpiInputError") public MobileElement upiInputError_android;
		
		@FindBy(id ="com.tatadigital.tcp.dev:id/tvMsg") public MobileElement deleteErrorMsg_android;

		@FindBy(id ="com.tatadigital.tcp.dev:id/btnPositive") public MobileElement deleteErrorMsgOk_android;
		@FindBy(id ="com.tatadigital.tcp.dev:id/ivMoreInfo") public MobileElement threedots_android;
		@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvRequestBalance")}) public List<MobileElement> requestbalance_android;
		
	//@FindBy(id = "com.tatadigital.tcp.dev:id/etExpiryMonthYear") public MobileElement etExpiryMonthYear_android;
	/**
	 * Define ios locators
	 * 
	 */
		
		@FindBy(xpath="(//XCUIElementTypeStaticText[contains(@name,'XX - XX')])[1]") public MobileElement firstBankAccountNo_ios;
		@FindBy(xpath="(//XCUIElementTypeStaticText[contains(@name,'XX - XX')])") public List<MobileElement> bankAccountNo_ios;

		@FindBy(xpath="(//XCUIElementTypeButton[@name='moreOption'])[1]") public MobileElement bankAccountMoreOption_ios;
		@FindBy(xpath="//XCUIElementTypeStaticText[@name='Delete account']") public MobileElement bankAccountMoreOptionDeleteBtn_ios;
		@FindBy(xpath="//XCUIElementTypeStaticText[@name='Are you sure you want to delete this account?']") public MobileElement deleteAccountPopup_ios;;
		@FindBy(xpath="//XCUIElementTypeButton[@name='Yes']") public MobileElement yesBtn_ios;;
		@FindBy(xpath="//XCUIElementTypeStaticText[@name='Your bank account has been deleted']") public MobileElement bankAccountDeletedPopUpMsg_ios;
		@FindBy(xpath="//XCUIElementTypeButton[@name='Ok']") public MobileElement okBtn_ios;
		@FindBy(xpath="//XCUIElementTypeButton[@name='Add Account']") public MobileElement addAccountBtn_ios;
		@FindBy(xpath="(//XCUIElementTypeNavigationBar[@name='TCPApp.OnBoardingBankListView'])[2]//following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[@name='ICICI BANK LIMITED']") public MobileElement iciciBank_ios; 
		@FindBy(xpath="//XCUIElementTypeStaticText[@name='Please select bank account']") public MobileElement selectBankAccountHeader_ios;
		@FindBy(xpath="//XCUIElementTypeButton[@name='Proceed']") public MobileElement proceedBtn_ios;

		@FindBy(xpath="//XCUIElementTypeStaticText[@name='Reset UPI Pin']") public MobileElement bankAccountMoreOptionResetUpiPinBtn_ios;
		@FindBy(xpath="//XCUIElementTypeStaticText[@name='Change UPI Pin']") public MobileElement bankAccountMoreOptionChangeUpiPinBtn_ios;
		@FindBy(xpath="//XCUIElementTypeStaticText[@name='ENTER CARD DETAILS']") public MobileElement enterCardDetailsPopupHeader_ios;
		@FindBy(xpath="//XCUIElementTypeTextField[@value='XX-XXXX']") public MobileElement last6DigitCardTextBox_ios;
		@FindBy(xpath="//XCUIElementTypeTextField[@value='MM/YY']") public MobileElement cardValidUptoTextBox_ios;
		
		@FindBy(xpath="//XCUIElementTypeStaticText[@name='You have successfully reset your pin']") public MobileElement pinResetSuccessMsg_ios;;
		@FindBy(xpath="//XCUIElementTypeStaticText[@name='Your UPI Pin has been successfully changed']") public MobileElement pinChangeSuccessMsg_ios;;
		@FindBy(xpath="(//XCUIElementTypeButton[@name='Request Balance'])[1]") public MobileElement bankAccountRequestBalance_ios;
		@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Balance:')]") public MobileElement bankAccountBalance_ios;

}
