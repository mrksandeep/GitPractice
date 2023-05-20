package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_UPI_SettingsPage_Mobile {

	public TDL_UPI_SettingsPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivClose") public MobileElement ivClose_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement tvTitle_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivBack") public MobileElement ivBack_android;
	@FindBy(xpath = "//*[@text='My UPI QR']") public MobileElement myUPIQR_android_old;
	@FindBy(xpath = "//*[@text='Manage bank account']") public MobileElement bankAccount_android;
	@FindBy(xpath = "//*[@text='UPI transaction history']") public MobileElement upiPaymentHistory_android;
	@FindBy(xpath = "//*[@text='Edit UPI ID' or 'Default UPI ID']") public MobileElement editUPIID_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUpiID") public MobileElement tvUpiID_android;
	@FindBy(xpath = "//*[@text='Manage blocked contacts']") public MobileElement manageBlockedContacts_android;
	@FindBy(xpath = "//*[@text='Manage favourites']") public MobileElement manageFavorites_android;
	@FindBy(xpath = "//*[@text='Manage transaction limit']") public MobileElement manageTranscLimit_android;
	@FindBy(xpath = "//*[@text='Manage beneficiary']") public MobileElement manageBeneficiary_android;
	@FindBy(xpath = "//*[@text='Deregister UPI']") public MobileElement deregisterUPI_android;

	/** Share QR **/
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivShare") public MobileElement shareQR_android;
	@FindBy(xpath = "//*[contains(@text, 'Gmail')]") public MobileElement sharegmail_android;
	@FindBy(xpath= "//android.widget.TextView[@content-desc='Send']") public MobileElement send_android;
	@FindBy(xpath = "//*[contains(@text, 'OK')]") public MobileElement Ok_android;

	@FindBy(xpath = "//*[contains(@text, 'Edit')]") public MobileElement editUPIID_android_new;
	@FindBy(xpath = "//*[contains(@text, 'Gallery')]") public MobileElement galleryIcon_android;

	/** bank account reset pin 
	 */
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/ivMoreInfo")}) public List<MobileElement> listivMoreInfo_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvResetUpiPin") public MobileElement resetUpiPin_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAlertTitle") public MobileElement alertTitle_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/etCardNumber") public MobileElement cardNumber_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/etExpiryMonthYear") public MobileElement expiryMonthYear_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPerformAction") public MobileElement performAction_android;
	@FindAll({@FindBy(id = "com.tatadigital.tcp.dev:id/form_item_input")}) public List<MobileElement> enterclick_android;
	@FindBy(xpath = "//*[@text='1']") public MobileElement otp_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPositive")public MobileElement btnPositive_android;

	//Added new id
	//change from UPI QR to UPI QR Code
	@FindBy(xpath = "//*[@text='My UPI QR']") public MobileElement myUPIQR_android;
	//Setting and Modifying QR
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvSetAmount") public MobileElement tvSetAmount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAmount") public MobileElement tvAmount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivSelection") public MobileElement ivselection_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvVpa") public MobileElement tvVPA_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnConfirm") public MobileElement confirm_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivQRCode") public MobileElement qr_android;
	
	@FindBy(xpath = "//*[@text='Default UPI ID']") public MobileElement defaultUPIID_android;


	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAmountError") public MobileElement tvAmountError_android;

	@FindAll({@FindBy(id = "com.tatadigital.tcp.dev:id/tvAccountNumber")}) public List<MobileElement> maskedAcctNum_android;

	@FindBy(xpath = "//*[contains(@text, 'Open with')]") public MobileElement openWith_android;
	
	/**
	 * Define ios locators
	 * 
	 */

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI.Settings.MyUPIQR']") public MobileElement myUPIQR_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI.Settings.BankAccount']") public MobileElement bankAccount_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI.Settings.UPIPaymentHistory']") public MobileElement upiPaymentHistory_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI.Settings.EditUPIID']") public MobileElement editUPIID_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI.Settings.ManageBlockedContacts']") public MobileElement manageBlockedContacts_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI.Settings.ManageFavorites']") public MobileElement manageFavorites_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI.Settings.ManageTransactionLimit']") public MobileElement manageTranscLimit_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI.Settings.ManageBeneficiary']") public MobileElement manageBeneficiary_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI.Settings.DeregisterUPI']") public MobileElement deregisterUPI_ios;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.UPITransactionHistoryView']") public MobileElement upiTransactionHistoryHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeImage") public MobileElement progressBar_ios;
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]//XCUIElementTypeStaticText[@name='UPI.TransactionHistory.CellTranIDLabel']") public MobileElement upiTransactionHistoryLastTxnUtrId_ios;
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]//XCUIElementTypeStaticText[@name='UPI.TransactionHistory.CellModDateLabel']") public MobileElement upiTransactionHistoryLastTxnDateTime_ios;
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]//XCUIElementTypeStaticText[@name='UPI.TransactionHistory.CellUPIIDLabel']") public MobileElement upiTransactionHistoryLastTxnUpiId_ios;
	@FindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell[1]//XCUIElementTypeStaticText[@name='UPI.TransactionHistory.CellModDateLabel']//following-sibling::XCUIElementTypeStaticText)[1] ") public MobileElement upiTransactionHistoryLastTxnAmount_ios;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.UPITransactionHistoryView']/XCUIElementTypeButton[1]") public MobileElement upiTransactionHistoryBackBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.UPISettingsView']/XCUIElementTypeButton[1]") public MobileElement upiSettingBackBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.OnBoardingHomeView']") public MobileElement upiOnboardingHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='NUMBER VERIFICATION']") public MobileElement upiOnboardingNumberVerificationHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Proceed to SMS']") public MobileElement upiOnboardingProceedToSms_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Please use mobile data to authenticate']") public MobileElement upiOnboardingMobileDataError_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='sendButton']") public MobileElement sendSmsBtn_ios;
	@FindBy(xpath = "(//XCUIElementTypeNavigationBar[@name='TCPApp.UPIMyUPIQRView']/XCUIElementTypeButton)[2]") public MobileElement shareQR_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='Mail']") public MobileElement shareMail_ios;
	@FindBy(name = "TCPApp.UPIMyUPIQRView") public MobileElement qrCodePage_ios;
	
	@FindBy(name = "//XCUIElementTypeNavigationBar[@name='TCPApp.UPIManageFavouriteContactsView']") public MobileElement manageFovoritesPageHeade_ios;

	@FindBy(name = "TCPApp.UPISettingsAccountView") public MobileElement bankAccountPage_ios;
	@FindBy(xpath="//XCUIElementTypeNavigationBar[@name='TCPApp.UPISettingsAccountView']//following-sibling::XCUIElementTypeOther//XCUIElementTypeTable//XCUIElementTypeButton[@name='moreOption']") public List<MobileElement> noOfBankAccounts_ios;
	@FindBy(xpath="//*[@name='Delete account']") public MobileElement deleteAccountButton_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Your bank account has been deleted']") public MobileElement bankAccountDeletedMsg_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Ok']") public MobileElement okBtn_ios;
	@FindBy(xpath="//XCUIElementTypeNavigationBar[@name='TCPApp.UPISettingsAccountView']/XCUIElementTypeButton") public MobileElement backBtnBankAccountPage_ios;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.UPIManageBlockContactsView']") public MobileElement upiManageBlockedContactHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Remove']") public MobileElement blockedContactRemoveBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Unblock']") public MobileElement blockedContactUnblockBtn_ios;
	@FindBy(xpath = "(//XCUIElementTypeNavigationBar[@name='TCPApp.UPITransactionHistoryView']/XCUIElementTypeButton)[2]") public MobileElement filterBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='This month']") public MobileElement thisMonthdurationBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Apply']") public MobileElement applyBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Excel']") public MobileElement excelFormatBtn_ios;
	@FindBy(xpath = "//*[contains(@name,'Office Spreadsheet')]") public MobileElement officeSpreadsheetText_ios;
	@FindBy(xpath="//XCUIElementTypeNavigationBar[@name='TCPApp.UPISettingsAccountView']//following-sibling::XCUIElementTypeOther//XCUIElementTypeTable//XCUIElementTypeButton[@name='moreOption']/preceding-sibling::XCUIElementTypeButton") public List<MobileElement> selectBankRadioButton_ios;;
	@FindBy(xpath="(//XCUIElementTypeNavigationBar[@name='TCPApp.UPIManageBlockContactsView']/XCUIElementTypeButton)[2]") public MobileElement addBtnManageBlockContacts_ios;
}
