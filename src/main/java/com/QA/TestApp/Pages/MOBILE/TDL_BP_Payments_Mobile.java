package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_BP_Payments_Mobile {
	
	public TDL_BP_Payments_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	//android locators
	@FindBy(xpath = "//*[@text='Payments']") public MobileElement paymentsPgHdr_android;
	@FindBy(xpath = "(//*[@text='TOTAL AMOUNT']/following-sibling::*)[1]") public MobileElement totalAmnt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clPaymentMethod") public MobileElement PaymentMthd_android;
	@FindBy(xpath = "//*[@text='UPI']") public MobileElement upiMethod_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/rbCardSelect'])[2] |	//*[@resource-id='com.tatadigital.tcp.dev:id/rbCardSelect']") public MobileElement selectCard_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPayCard") public MobileElement cardPay_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTotalAmountHeaderDebit") public MobileElement debitCardHdr_android;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI'] | //XCUIElementTypeStaticText[@name='DEBIT CARD'] | //XCUIElementTypeStaticText[@name='CREDIT CARDS']|//*[@text='UPI']|//*[@text='DEBIT CARD'] | //*[@text='CREDIT CARD']") public MobileElement availablePayMthd_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/messageTextView") public MobileElement PaymentMthdErrorTxt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/edCvv") public MobileElement cvvCode_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/rvCreditCard']//*[@resource-id='com.tatadigital.tcp.dev:id/edPCvv'] | "
			+ "//*[@text='Credit card']/following-sibling::androidx.recyclerview.widget.RecyclerView//android.widget.EditText[@text='Enter CVV']") public MobileElement cvvCodeCredit_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/rvDebitCard']//*[@resource-id='com.tatadigital.tcp.dev:id/edPCvv']") public MobileElement cvvCodeDebit_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnPayMultitender'] | (//android.widget.Button[contains(@text,'Pay')])[1]") public MobileElement payBtn_android;
	@FindBy(xpath = "//*[@text='Success'] | //*[@text='Successful']") public MobileElement successBtn_android;
	@FindBy(xpath = "//*[@text='Failure']") public MobileElement failureBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPaymentStatusHeaderTxt") public MobileElement paymentStatusHdrTxt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvItemPaymentStatus") public MobileElement paymentStatus_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvItemBillerName") public List<MobileElement> billersName_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPaymentTotalAmountValue") public MobileElement totalAmntOnPayStatusPg_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvItemTransactionIdValue") public List<MobileElement> transactionId_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvItemBbpsTxnIdValue") public List<MobileElement> bbpsTransactionId_android;
	
	//UPI
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAddPaymentOption") public MobileElement paymentMethodChange_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUPIAmountHeader") public MobileElement upiHdr_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbUpiSelect") public MobileElement upiRadioBtn_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnPayMultitender'] | //*[@resource-id='com.tatadigital.tcp.dev:id/btnPayCard']") public MobileElement upiPayBtn_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button") public MobileElement allowPopup_android;
     @FindBy(id = "com.tatadigital.tcp.dev:id/form_item_input") public MobileElement enterclick_android;
     @FindBy(xpath = "//*[@text='1']") public MobileElement pin_upi_android;
     @FindBy(xpath = "//*[@text='2']") public MobileElement wrong_pin_upi_android;
     @FindBy(xpath ="//*[@class='android.widget.TableRow'][4]//*[@class='android.widget.ImageView'][2]") public MobileElement DoneBtn_android;
 
	//xpath validate
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPayCard") public MobileElement pin_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button") public MobileElement payPinPg_android;
	@FindBy(xpath = "(//*[contains(@text,'Return')])[2]") public MobileElement btnReturn;
	
	
	
	// iOS Locators
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.MultiTender']") public MobileElement payment_pg_hdr_review_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Pay')]") public MobileElement pay_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Change']/following::XCUIElementTypeSecureTextField |//XCUIElementTypeSecureTextField[@name='TCPApp.CardCell.cvvTextField']") public MobileElement enter_cvv_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Change']") public MobileElement pay_change_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='TCPApp.CardCell.radioButton'])[1]") public MobileElement cardRadioBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Failure']") public MobileElement pay_failure_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Success']") public MobileElement pay_success_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Status']") public MobileElement pay_status_hdr_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Status']/following::XCUIElementTypeCell/XCUIElementTypeStaticText[10] ") public MobileElement pay_status_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Status']/following::XCUIElementTypeCell/XCUIElementTypeStaticText[2]") public MobileElement pay_consumer_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Status']/following::XCUIElementTypeCell/XCUIElementTypeStaticText[3]") public MobileElement pay_consumer_id_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Status']/following::XCUIElementTypeCell/XCUIElementTypeStaticText[11]") public MobileElement pay_date_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TOTAL AMOUNT']/preceding-sibling::*") public MobileElement pay_tot_amount_ios;

	//nov25//
	@FindBy(xpath = "") public List<MobileElement> paid_success_list_ios;
	@FindBy(xpath = "") public List<MobileElement> transaction_id_list_ios;
	@FindBy(xpath = "") public List<MobileElement> BBPS_transaction_id_list_ios;
	@FindBy(xpath = "") public List<MobileElement> paid_failure_list_ios;
	@FindBy(xpath = "") public List<MobileElement> transaction_id_list_failure_ios;
	@FindBy(xpath = "") public MobileElement BBPS_transaction_id_list_failure_ios;
}
