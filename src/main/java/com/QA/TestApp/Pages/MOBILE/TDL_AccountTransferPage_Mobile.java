package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_AccountTransferPage_Mobile {
	
	public TDL_AccountTransferPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button") public MobileElement permission_allow_button_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_deny_button") public MobileElement permission_deny_button_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/clRoot") public MobileElement selectAccount_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/btnProceed") public MobileElement btnProceed_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/ivBack") public MobileElement backBtn_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/btnBackToHome") public MobileElement btnBackToHome_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnAddAccount") public MobileElement btnAddAccount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etAccountHolderNumber") public MobileElement etAccountHolderNumber_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/etConfirmAccountHolderNumber") public MobileElement etConfirmAccountHolderNumber_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/etIfscCode") public MobileElement etIfscCode_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etAccountHolderName") public MobileElement etAccountHolderName_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etMobileNumber") public MobileElement etMobileNumber_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvTitle") public MobileElement tvTitle_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etBank") public MobileElement etBank_android;
	@FindBy(xpath ="//*[contains(@text, 'HDFC BANK')]") public MobileElement hdfcBank_android;
	@FindBy(xpath ="//*[contains(@text, 'ICICI')]") public MobileElement iciciBank_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/clRoot")}) public List<MobileElement> contactList_android;

//oct21//revathi
	@FindBy(xpath ="//*[contains(@text, 'Next')]") public MobileElement Linkaccount_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/clRoot") public List<MobileElement> contactList__new_android;
	
	
	@FindBy(id ="com.tatadigital.tcp.dev:id/etSearch") public MobileElement searchAccount_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/etBranch") public MobileElement searchbranch_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/etBank") public MobileElement searchbank_android;
	@FindBy(id ="//*[contains(@text, 'ADONI')]") public MobileElement selectBranch_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/rvPopularBank") public MobileElement popularbanks_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvFindIfsc") public MobileElement findIFSC_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvBankName")}) public List<MobileElement> bankList_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvBranchName")}) public List<MobileElement> branchList_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivAdd") public MobileElement addbutton_in_ManageBeneficiarypage;
	
	
	/**
	 * Define ios locators
	 * 
	 */
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='UPI.PayViaAccount.AddAccountButton']") public MobileElement addAnAccounBtn_iOS;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='UPI.BankTransfer.EnterBankAccountTextField']") public MobileElement bankAccountTextBox_iOS;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='UPI.BankTransfer.ConfirmBankAccountTextField']") public MobileElement confirmBankAccountTextBox_iOS;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='UPI.BankTransfer.IFSCCodeTextField']") public MobileElement ifscTextBox_iOS;
	@FindBy(xpath = "//XCUIElementTypeTextField[contains(@name,'UPI.BankTransfer.Accountholder')]") public MobileElement accountHolderName_iOS;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='UPI.BankTransfer.ProceedButton']") public MobileElement accountTransferProceedBtn_iOS;
	@FindBy(xpath="(//XCUIElementTypeNavigationBar[@name='TCPApp.UPIManageBenificiaryView']/XCUIElementTypeButton)[2]") public MobileElement addbuttonInManageBeneficiarypage_ios;
	@FindBy(xpath="//XCUIElementTypeNavigationBar[@name='TCPApp.UPIBankTransferView']") public MobileElement accountTransferHeader_ios;
	@FindBy(xpath="//XCUIElementTypeTextField[@name='UPI.BankTransfer.Mobilenumber(Optional)TextField']") public MobileElement mobileNumberField_ios;

	
		
}
