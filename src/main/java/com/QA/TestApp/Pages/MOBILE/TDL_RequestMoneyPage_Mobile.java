package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_RequestMoneyPage_Mobile {

	public TDL_RequestMoneyPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators	
com.tatadigital.tcp.dev:id/tvPayerName
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/etSearch") public MobileElement searchtab_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etSearch") public MobileElement searchphonebook_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnViewAllContacts") public MobileElement contactlist_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clRoot") public MobileElement selectContact_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement continueBtn_android;
//	@FindBy(xpath ="//button[contains(text, 'Decline')]") public MobileElement btnPositive_android;
    @FindBy(id ="com.tatadigital.tcp.dev:id/btnPositive") public MobileElement btnPositive_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnNegative") public MobileElement btnNegative_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/referContactsButton") public MobileElement referContactsButton_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/referButton") public MobileElement referButton_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/contactSearchEditText") public MobileElement SearchreferCont_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInitials") public MobileElement selectFav_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvVerify") public MobileElement verify_android;
	@FindBy(id = "") public MobileElement bankTransfer_android;
	@FindBy(id = "") public MobileElement addAccToTransfer_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivDropDown") public MobileElement bankDroupdwn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAddAccount") public MobileElement addAcc_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnProceed") public MobileElement proceedBtn_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvBankName")}) public List<MobileElement> bankNameList_android;

	@FindBy(xpath= "//*[@text='Collect']") public MobileElement collectTab_android;
	@FindBy(xpath= "//*[@text='Mandate']") public MobileElement mandateTab_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvBlockVpa")}) public List<MobileElement> blockTxt_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvRequestOn")}) public List<MobileElement> requestTimeExpired_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvRequestedOn")}) public List<MobileElement> requestTimePending_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvPaidOn")}) public List<MobileElement> payTime_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvValidateUpTo")}) public List<MobileElement> payValidTime_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvRequestedAmount")}) public List<MobileElement> requestAmount_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvPayeeVpa")}) public List<MobileElement> payeeVPA_android;

	@FindBy(id= "com.android.permissioncontroller:id/permission_allow_button") public MobileElement Allow_Button;
	@FindBy(id= "com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button") public MobileElement Deny_button;
	@FindBy(id= "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement OkButton;
	
	@FindBy(xpath= "//*[@text='Pending']") public MobileElement pendingTab_android;
	@FindBy(xpath= "//*[@text='Expired']") public MobileElement expiredTab_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/etSearch") public MobileElement etSearch_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAlertTitle") public MobileElement tvAlertTitle_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvMsg") public MobileElement tvMsg_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvPayerName")}) public List<MobileElement> payeeName_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvPayerName")}) public List<MobileElement> payerName_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvPay")}) public List<MobileElement> approveRequest_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvDecline")}) public List<MobileElement> declineRequest_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvCheckBalance") public MobileElement checkBalance_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvRequestedOn")}) public List<MobileElement> requestedOn_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvValidateUpTo")}) public List<MobileElement> validateUpTo_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/btnViewAllContacts") public MobileElement ViewContactButton;
	@FindBy(id= "com.tatadigital.tcp.dev:id/rvContact") public MobileElement DivTcpContact;
	//Akshya
	@FindBy(id= "com.tatadigital.tcp.dev:id/ivProfile") public MobileElement Contact_Icon;

	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/profileOptionsItemsLayout")}) public List<MobileElement> accountList_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/positiveButton") public MobileElement yesBtn_Icon;
	@FindBy(id= "com.tatadigital.tcp.dev:id/bottom_home") public MobileElement homepage_Icon;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvName")}) public List<MobileElement> contactNameList_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivProfile") public MobileElement profile_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/icTcp") public MobileElement tcpIcon_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvNoFavourite") public MobileElement invalidFormate_android;


	/**
	 * Define ios locators
	 * 
	 */

	@FindBy(xpath = "//XCUIElementTypeButton[@name='searchIcon']//following-sibling::XCUIElementTypeTextField") public MobileElement searchUpiTextBox_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Verify']") public MobileElement verifyUpi_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='CONTACTS']") public MobileElement existingContactHeader_ios;
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='CONTACTS']//following-sibling::XCUIElementTypeCell)[1]") public MobileElement existingUPIContact_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Verification']") public MobileElement verificationPopup_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Verified']") public MobileElement verifiedMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Confirm']") public MobileElement confirmButton_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Amount']") public MobileElement selectAmountLabel_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Select Amount']//following-sibling::XCUIElementTypeTextField)[1]") public MobileElement enterAmountTextBox_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Pay']") public MobileElement payButton_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='ENTER UPI PIN']") public MobileElement enterUpiPinLabel_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='1']") public MobileElement upiPinKeyboardNum1_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='2']") public MobileElement upiPinKeyboardNum2_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='3']") public MobileElement upiPinKeyboardNum3_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='4']") public MobileElement upiPinKeyboardNum4_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='5']") public MobileElement upiPinKeyboardNum5_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='6']") public MobileElement upiPinKeyboardNum6_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='SUBMIT']") public MobileElement upiPinKeyboardSubmit_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Success']") public MobileElement upiTxnSuccessLabel_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Transaction Id:')]") public MobileElement upiTxnId_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'#')]") public MobileElement upiTxnUtrId_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'/')]") public MobileElement upiTxnDateTime_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back to Homepage']") public MobileElement upiTxnBacktoHomePageBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Request']") public MobileElement requestBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Transaction Initiated']") public MobileElement upiRequestMoneyTxnInitiatedLabel_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconStar']") public MobileElement favoriteBtnOnTxnPage_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'icici')])[1]") public MobileElement favoriteUpiId_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Remove']") public MobileElement removeFavorite_ios;
	@FindBy(xpath ="/XCUIElementTypeStaticText[@name='Delete Favourite']") public MobileElement deleteFavoritesPopUpHeade_ios;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='Yes']") public MobileElement yesBtnPopup_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='No Favourite Contacts']") public MobileElement NoFavoriteContactText_ios;




}
