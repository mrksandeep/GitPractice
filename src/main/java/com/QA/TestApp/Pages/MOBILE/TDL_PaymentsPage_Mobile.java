package com.QA.TestApp.Pages.MOBILE;
import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_PaymentsPage_Mobile {
	
	public TDL_PaymentsPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnSingIn") public MobileElement signin_android;
	@FindBy(xpath = "//android.view.View[2]/android.widget.EditText") public MobileElement phonNumber_android;
	@FindBy(xpath = "//android.view.View[3]/android.widget.Button") public MobileElement confirmbutton_android;
	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.EditText ") public MobileElement password_android;
	// @FindBy(xpath="//android.view.View[2]/android.view.View/android.view.View/android.widget.Image]")
	@FindBy(xpath = "//android.view.View[1]/android.view.View/android.view.View[4]") public MobileElement forgetpassword_android;
	@FindBy(xpath = "//android.view.View[3]/android.widget.Button") public MobileElement confrimforgetpasswd_android;
	@FindBy(xpath = "xpath=//android.widget.RelativeLayout[9]") public MobileElement others_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etorderId") public MobileElement orderId_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/et_merchant_name") public MobileElement merchant_name_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etmerchantId") public MobileElement merchantId_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/et_terminal_id") public MobileElement terminalID_android;
	@FindBy(id = "android:id/text1") public MobileElement droupdown_android;
	@FindBy(xpath = "//*[contains(@text, 'App')]") public MobileElement app_android;
	@FindBy(xpath = "//*[contains(@text, 'Web')]") public MobileElement web_android;
	@FindBy(xpath = "//*[contains(@text, 'Store')]") public MobileElement store_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/et_tcp_id")public MobileElement tcpHash_android;
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView")public List<MobileElement> DropdwonList_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/et_consumer") public MobileElement consumer_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etAmount") public MobileElement amount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/et_card_id") public MobileElement cardID_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btn_continue") public MobileElement continueBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etAmount") public MobileElement selectAmount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etPayAmount") public MobileElement qrAmount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnConfirm") public MobileElement qrconfirm_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/etMessage") public MobileElement message_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPaytovpa") public MobileElement payBtn_android;
	@FindBy(xpath = "//*[@text='1']") public MobileElement pin_android;
	@FindBy(xpath = "//*[@text='4']") public MobileElement pin2_android;
	@FindBy(xpath ="//*[@class='android.widget.TableRow'][4]//*[@class='android.widget.ImageView'][2]") public MobileElement DoneBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionStatus") public MobileElement tvTransactionStatus_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnBackToHome") public MobileElement btnBackToHome_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPayeeName") public MobileElement addFav_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPayeeName") public MobileElement payeename_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvMsg") public MobileElement errorMsg_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUpiId") public MobileElement tvUpiId_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAmount") public MobileElement tvAmount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionID") public MobileElement tvTransactionID_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivShare") public MobileElement ivShare_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvDownload") public MobileElement ivDownload_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTDateTime") public MobileElement tvTDateTime_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBankName") public MobileElement tvBankName_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTxnId") public MobileElement tvTxnId_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvCheckBalance") public MobileElement checkBalance_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/form_item_input") public MobileElement enterclick_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivFavourite") public MobileElement favorite_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/form_item_input") public List<MobileElement> pinselect_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose") public MobileElement ivClose_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivArrow") public MobileElement arrow_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPayeeId") public MobileElement payeeId_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etMessage") public MobileElement remarks_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPayeeName") public MobileElement payeeName_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAccountNumber") public MobileElement accountNumber_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUtrNumber") public MobileElement utrNumber_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/clTransactionContainer")}) public List<MobileElement> transactionContainer_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/ivDownload") public MobileElement downloadinvoice_android;
	@FindBy(id="com.android.packageinstaller:id/permission_allow_button") public MobileElement allowBtn_android;
	@FindBy(id="android:id/button2") public MobileElement cancelbtn_android;
	
	@FindBy(xpath = "//*[@text='Others']") public MobileElement click_other_option;
	@FindBy(xpath = "//*[@text='Payment']") public MobileElement click_payment_option;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etorderId") public MobileElement enter_order_id_android;
	@FindBy(xpath = "//*[@text='CONTINUE']") public MobileElement click_continue_button_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clUpiLayout") public MobileElement upi_layout_android;
	@FindBy(xpath = "//*[@text='Sixt Voucher']") public MobileElement click_sixt_voucher_option;
	@FindBy(xpath = "//*[@text='Bill payment']") public MobileElement click_bill_payment_option;
	@FindBy(xpath = "//*[@text='Change']") public MobileElement change_paymentOption;
	@FindBy(xpath = "//*[@text='Set UPI PIN']") public MobileElement set_upi_pin_option;
	@FindBy(xpath = "//*[@text='Check balance']") public MobileElement checkbalance_option;

	@FindBy(xpath = "//*[@text='Add New']") public MobileElement add_card_option;
//	@FindBy(xpath = "//*[@text='UPI']") public MobileElement upi_option;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbUpiOption") public MobileElement upi_option;
	@FindBy(xpath = "//*[@text='Name on the card']") public MobileElement Name_onThe_card_text;
	@FindBy(xpath = "//*[@text='Card number']") public MobileElement card_number_text;
	@FindBy(xpath = "//*[@text='MM']") public MobileElement month_ofCard_text;
	@FindBy(xpath = "//*[@text='YY']") public MobileElement year_ofCard_text;
	@FindBy(xpath = "//*[@text='Continue']") public MobileElement continue_button_text;
	@FindBy(id = "com.tatadigital.tcp.dev:id/bottom_tata_pay") public MobileElement vault_android;
	@FindBy(xpath = "//*[@text='Tata Pay']") public MobileElement tataPay_button_vault_page_text;
	@FindBy(xpath = "//*[@text='Primary']") public MobileElement primary_button_vault_page_text;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvCardClick") public MobileElement first_debit_card_option;
	@FindBy(id = "com.tatadigital.tcp.dev:id/edCvv") public MobileElement enter_cvv_field;
//	@FindBy(xpath = "//*[@text='Enter CVV']") public MobileElement enter_cvv_field;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPayMultitender") public MobileElement pay_amount_button;
	@FindBy(xpath = "//*[@text='Success']") public MobileElement success_button_razopay;
	@FindBy(xpath = "//*[@text='Download Invoice']") public MobileElement download_invoice_text;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionId") public MobileElement transaction_id;
	@FindBy(xpath = "//*[@text='TCP Points']") public MobileElement tcp_points_text;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvEditTataOnePoint") public MobileElement tcp_points_edit_opion;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etLoyalityAmount") public MobileElement tcp_loyalty_point_edit_field;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clOfferDetail") public MobileElement tcp_loyalty_point_confirm_button;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTotalCartAmount") public MobileElement tcp_total_amount_paymennt_page;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPayMultitender") public MobileElement tcp_to_pay_amount_paymennt_page;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUserName") public MobileElement payeeUserName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvVpa") public MobileElement payeeVpa_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPayeeBankName") public MobileElement payeeBankName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvInitials") public MobileElement payeeInitials_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivDropDown") public MobileElement bankDroupdown_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvBankNameAccountNumber")}) public List<MobileElement> bankNameAccountNumber_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAddAccount") public MobileElement addaccountOpt_android;
	
	@FindBy(xpath = "//*[@text='Bill payment']") public MobileElement bill_payment_option;
	@FindBy(xpath = "//*[@text='Add New Bill']") public MobileElement add_new_bill_option;
	@FindBy(xpath = "//*[@text='Broadband']") public MobileElement Broadband_option;
	@FindBy(xpath = "//*[@text='ACT Fibernet']") public MobileElement Act_fibernet_option;
	@FindBy(xpath = "//*[@text='Account Number/User Name']") public MobileElement account_number_option;
	@FindBy(id = "com.tatadigital.tcp.dev:id/input_edit_text") public MobileElement account_number_edit_text_field;
	@FindBy(xpath = "//*[@text='Fetch Bill']") public MobileElement fetch_bill_button;
	@FindBy(xpath = "//*[@text='No']") public MobileElement no_button_android;
	@FindBy(xpath = "//*[@text='Add Now']") public MobileElement add_now_button_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/imgBack") public MobileElement back_button_field;
	@FindBy(xpath = "//*[@text='View']") public MobileElement view_option;
	@FindBy(xpath = "//*[@text='Proceed']") public MobileElement proceed_option;
	@FindBy(xpath = "//*[@text='Share']") public MobileElement share_field;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvItemPaymentStatus") public MobileElement payment_status_field;
	@FindBy(xpath = "//*[@text='Use Other UPI']") public MobileElement useOtherUPI_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement paymentTextInHeader;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPaytovpa") public MobileElement payButton;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPay") public MobileElement confirmButtonAndroid;
	
	
	
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tvUPIClick'])[1]") public MobileElement upi_radio_button1_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPayCard") public MobileElement upipayButton_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/form_item_input") public MobileElement upipinpage_android;
	
	@FindBy(xpath = "//*[@text='1']") public MobileElement upi_one_pin_android;
	@FindBy(xpath = "//*[@text='2']") public MobileElement upi_two_pin_android;
	@FindBy(xpath = "//*[@text='3']") public MobileElement upi_three_pin_android;
	@FindBy(xpath = "//*[@text='4']") public MobileElement upi_four_pin_android;
	@FindBy(xpath ="(//*[@class='android.widget.ImageView'])[4]") public MobileElement upi_pin_ok_button_android;
	@FindBy(xpath = "//*[@text='Done! Payment Complete']") public MobileElement transaction_status_done_field;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivExpandView") public MobileElement payment_expand_view_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivPaymentUPI") public MobileElement bank_logo_view_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPaymentsUPI") public MobileElement masked_bank_account_number_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUPIAmount") public MobileElement utr_view_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUPIDetails") public MobileElement amount_paid_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/icOrderFilter") public MobileElement orderFilter_android;
	@FindBy(xpath = "//*[@text='Success']") public MobileElement orderFilter_Success_android;
	@FindBy(xpath = "//*[@text='Failed']") public MobileElement orderFilter_Failed_android;
	@FindBy(xpath = "//*[@text='Pending']") public MobileElement orderFilter_Pending_android;
	@FindBy(xpath = "//*[@text='Refund']") public MobileElement orderFilter_Refund_android;
	@FindBy(xpath = "//*[@text='Apply']") public MobileElement orderFilter_Apply_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/clOrderHistoryItem'])[1]") public MobileElement filtered_first_transation_android;
	@FindBy(xpath = "//*[@text='UPI']") public MobileElement orderFilter_upi_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivExpandView") public MobileElement orderFilter_payment_expandView_android;
	
	@FindBy(xpath = "//*[@text='Talk to us']") public MobileElement orderHistory_upi_Talk_to_us_android;
	@FindBy(xpath = "//*[@text='Powered By']") public MobileElement orderHistory_upi_Powered_By_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/icShare]") public MobileElement filtered_share_option_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvOrderDetailTxnID]") public MobileElement filtered_order_Detail_Transaction_Id_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivPaymentDetailsUPICard]") public MobileElement filtered_Payment_Details_UPI_Card_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvPaymentsUPI]") public MobileElement filtered_Payments_UPI_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvUPIAmount]") public MobileElement filtered_UPI_Amount_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvUPIDetails]") public MobileElement filtered_UPI_Details_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_message") public MobileElement call_permission_popup_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button") public MobileElement allow_call_permission_popup_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbUpiOption") public MobileElement switch_to_UPI_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/inc_upi_link_registration_layout") public MobileElement UPI_regn_page_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvDesc") public MobileElement UPI_regn_page_desc_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/multitenderParentLayout") public MobileElement multitender_landing_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvViewAll") public MobileElement view_All_Offers_android;
	@FindBy(xpath = "//*[contains(@text,'CASH BACK') or contains(@text,'cashback') or contains(@text, 'Cashback')]") public MobileElement cashback_Offers_android;
	@FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Debit']") public MobileElement debit_tab_android;
	@FindBy(xpath = "//*[contains(@text,'off') or contains(@text,'discount') or contains(@text,'Discount')]") public MobileElement discount_offers_android;
	@FindBy(xpath = "//*[@text='Pending - transaction initiated'] | //*[@text='Pending - Transaction Initiated']") public MobileElement aborted_pending_transaction_text_android;
	@FindBy(xpath = "//*[@text='Failure - Timeout']") public MobileElement aborted_failed_transaction_text_android;
	@FindBy(xpath = "//*[@text='Failure - Reversed']") public MobileElement aborted_failed_reversed_transaction_text_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUserPoints") public MobileElement tcpPointsHomePage_android;
	@FindBy(xpath = "//*[@text='Failure - Reversed']") public MobileElement failed_reversed_transaction_text_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/cbTcpPoints']") public MobileElement tcpPoints_checkbox_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/cbTcpPoints' and @checked='true']") public MobileElement tcpPoints_checkbox_true_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/cbTcpPoints' and @checked='false']") public MobileElement tcpPoints_checkbox_false_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvEditTataOnePoint']") public MobileElement edit_tcpPoints_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/etLoyalityAmount']") public MobileElement tcpLoyalityAmount_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/buttonLoyalityModel']") public MobileElement tcpLoyalitybutton_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvTotalPoints']") public MobileElement tcpTotalPoints_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivOrderBack']") public MobileElement backbuttonOrderHistory_page_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/backPressIv']") public MobileElement backbuttonOrder_page_android;
	@FindBy(xpath="//*[contains(@text, 'Order history')]") public MobileElement orderHistoryOptn_android;
	@FindBy(xpath = "//*[@resource-id='otpForm']") public MobileElement otpForm;
	@FindBy(xpath = "//*[@resource-id='submit-action']") public MobileElement submit_action;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvItemTransactionIdValue']") public MobileElement TransactionId;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnBackToHomePage']") public MobileElement BackToHompageButton;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/billerNameTv']") public MobileElement BillerName;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/transactionId']") public MobileElement transactionIdFromOrderHistory;
	
	@FindBy(xpath = "//*[@text='Invalid MPIN']") public MobileElement invalid_mpin_option;
	@FindBy(xpath = "//*[@text='Cancel']") public MobileElement cancel_option;
	@FindBy(xpath = "//*[@text='Retry']") public MobileElement retry_option;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionIdHeader") public MobileElement utrno;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/ivBankLogo'])[1]") public MobileElement netbanking_first_bank_android;
	@FindBy(xpath = "//*[contains(@text,'Failure')]") public MobileElement failure_button_razopay;
	@FindBy(xpath = "//*[@text='Payment failed']") public MobileElement payment_failed_text;
	@FindBy(xpath = "//*[@text='Close']") public MobileElement close_button_text;
	@FindBy(xpath = "//*[@text='Sorry! Payment Failed']") public MobileElement payment_failed_description_text;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvFailureMessage") public MobileElement failure_message;
	@FindBy(id = "(com.tatadigital.tcp.dev:id/edCvv)[1]") public MobileElement first_card_enter_cvv_field;
	@FindBy(xpath = "//*[@text='TCP']") public MobileElement selectTCP;
    @FindBy(id = "com.villevalta.intentlauncher:id/edit_uri") public MobileElement edit_URL;
    @FindBy(id = "com.villevalta.intentlauncher:id/action_launch") public MobileElement action_launch;
    @FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvCardPayment']") public MobileElement cardpayment;
    @FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvLastPaymentHeader']") public MobileElement lastPaymentHeaderTpmPage;
    @FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvOtherPaymentHeader']") public MobileElement otherPaymentHeaderTpmPage;
    @FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvEmi']") public MobileElement otherPaymentEmiTpmPage;
    @FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tataPayUPI']") public MobileElement otherPaymentTataPayUpiTpmPage;
    @FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvNetBanking']") public MobileElement otherPaymentNetbankingTpmPage;
    @FindBy(id = "com.tatadigital.tcp.dev:id/bottom_tata_pay") public MobileElement TataNeu_Bottom_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvAddNew") public MobileElement AddNewCard_android;
    @FindBy(xpath = "//*[@text='Cards']") public MobileElement CardsText_android;
    @FindBy(xpath = "//*[@text='Add new card']") public MobileElement AddNewCardModalText_android;
    @FindBy(xpath = "//*[@text='Offers']") public MobileElement Offers_android;
    @FindBy(xpath = "//*[@text='Offers applied']") public MobileElement OffersAppliedText_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/netBankingMainLayout") public MobileElement bankMainLayout_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvPopularBank") public MobileElement popularBank_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvAllBanks") public MobileElement AllBanks_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvAmountHead") public MobileElement amountHead_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvTotalCartAmount") public MobileElement TotalCartAmount_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvHeaderRefID") public MobileElement HeaderRefID_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvRefId") public MobileElement RefId_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvPointLoyaltyError") public MobileElement Loyalty_Error_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvUpiName") public MobileElement Upi_name_android;
    
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvUpi") public MobileElement Upi_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/ivUpiIcon") public MobileElement Upi_icon_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvUpiBankName") public MobileElement Upi_bankName_android;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvAdd") public MobileElement Upi_add_android;
    
    
    
    
    
    
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='GO TO PAYMENT']") public MobileElement gotopayment_ios;
	@FindBy(id = "//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextField") public MobileElement orderId_ios;
	@FindBy(id = "//XCUIElementTypeTable/XCUIElementTypeCell[16]/XCUIElementTypeTextField") public MobileElement merchant_name_ios;
	@FindBy(xpath ="//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField") public MobileElement merchantId_ios;
	@FindBy(xpath ="//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField") public MobileElement terminalID_ios;
	@FindBy(id = "//XCUIElementTypeImage[@name=\"arrowtriangle.down.circle\"]") public MobileElement droupdown_ios;
	@FindBy(xpath = "//XCUIElementTypeImage[@name='arrowtriangle.down.circle']") public MobileElement app_ios;
	@FindBy(xpath ="//*[contains(@text, 'Web')]") public MobileElement web_ios;
	@FindBy(id ="com.tatadigital.tcp.dev:id/et_consumer") public MobileElement consumer_ios;
	@FindBy(id ="com.tatadigital.tcp.dev:id/et_amount") public MobileElement amount_ios;
	@FindBy(id ="com.tatadigital.tcp.dev:id/et_card_id") public MobileElement cardID_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Pay']") public MobileElement nextBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='tcpApp.home.myAccountView']") public MobileElement myaccountview_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='tcpApp.AccountList.sectionTitle']") public MobileElement other_button_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='Others']") public MobileElement otherOpt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Payments']") public MobileElement payment_button_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='GO TO PAYMENT']") public MobileElement go_to_payment_button_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Next']") public MobileElement Next_button_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Change']") public MobileElement change_button_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='radioButtonUnselected']") public MobileElement unselected_radio_button_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Check Balance']") public MobileElement check_balance_option_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Set UPI PIN']") public MobileElement set_upi_pin_option_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.AmountCell.addNewButton']") public MobileElement add_new_button_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.cardHolderNameTextField']") public MobileElement card_holder_name_text_field_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.cardNumberTextField']") public MobileElement card_number_text_field_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.monthTextField']") public MobileElement card_expiry_month_text_field_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.yearTextField']") public MobileElement card_expiry_year_text_field_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.AddCardPageViewController.continueButton']") public MobileElement continue_button_add_bankAccount_page_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.AddCardPageViewController.continueButton']") public MobileElement upi_option_add_bankAccount_page_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='unselectedCheckbox']") public MobileElement unselected_tcp_points_box_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Utilities']") public MobileElement Utilities_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='BILLS']") public MobileElement BILLS_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='ACTFIBER']") public MobileElement ACTFIBER_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='View Detail']") public MobileElement View_Detail_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Use Other UPI']") public MobileElement useOtherUPI_ios;
	

	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField") public MobileElement terminalId_ios;
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeButton") public MobileElement requestType_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='App']") public MobileElement requestTypeselectApp_ios;
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[6]/XCUIElementTypeTextField") public MobileElement amountValue_ios;
	@FindBy(xpath = "//*[contains(@value,'Sorry! Payment Failed')]") public MobileElement payment_failed_ios;
	@FindBy(xpath = "//*[contains(@value,'Transaction ID')]") public MobileElement tran_ID_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Back to')]") public MobileElement backToHomepage_ios;
	@FindBy(name = "TCPApp.OrderDetailDefault") public MobileElement orderDetail_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconChevronDown']") public MobileElement paymentDetailIcon_ios;
	@FindBy(xpath = "//*[contains(@value,'TXN ID')]") public MobileElement orderTranId_ios;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.UPIOtherCell.upiRadioButton']") public MobileElement useOtherCellRadioButton_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='TCPApp.UPIOtherCell.vpaTextField']") public MobileElement vpaTextField_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.UPIOtherCell.verifyButton']") public MobileElement verifyButton_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.PaymentSelectionController.payButton']]") public MobileElement payButton_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='otherUPI']") public MobileElement otherUPITransacrionText_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Pending']") public MobileElement PendingTransaction_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconFilter']") public MobileElement OrderFilter_ios;
	@FindBy(xpath = "//*[@name='Success']") public MobileElement orderFilter_Success_ios;
	@FindBy(xpath = "//*[@name='Failed']") public MobileElement orderFilter_Failed_ios;
	@FindBy(xpath = "//*[@name='Pending']") public MobileElement orderFilter_Pending_ios;
	@FindBy(xpath = "//*[@name='Refund']") public MobileElement orderFilter_Refund_ios;
	@FindBy(xpath = "//*[@name='tcpApp.filter.applyButton']") public MobileElement orderFilter_Apply_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='unselectedCheckbox']") public MobileElement TcpPointsCheckbox_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Bill Payments']") public MobileElement orderFilter_Bill_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Store']") public MobileElement requestTypeselectStore_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add New']") public MobileElement addNewPaymentDetail_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Transaction timed out']") public MobileElement TransactionTimeOut_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Go Back']") public MobileElement GoBackToHomepage_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Failure-timeout']") public MobileElement FailureTimout_ios;
	@FindBy(xpath = "//*[@name = 'Merchant Acquiring']") public MobileElement merchacquiring_ios;
	@FindBy(xpath = "(//XCUIElementTypeTextField)[1]") public MobileElement orderIdtextbox_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Accept']") public MobileElement payBtn_ios;
	@FindBy(name = "Multitender") public MobileElement multitender_landing_ios;
	@FindBy(name = "TCPApp.OfferCell.viewAllButton") public MobileElement view_All_Offers_ios;
	@FindBy(name = "Debit") public MobileElement debit_tab_ios;
	@FindBy(xpath = "//*[contains(@label, 'CASHBACK') or contains(@label, 'Cashback') or contains(@label, 'cashback')]") public MobileElement cashback_Offers_ios;
	@FindBy(xpath = "//*[contains(@label, 'Discount') or contains(@label, 'INSTANT') or contains(@label, 'off') or contains(@label, 'discount')]") public MobileElement discount_offers_ios;
	
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='unselectedCheckbox']") public MobileElement unselectedLoyaltyCheckbox_ios;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit']") public MobileElement EditLoyaltyBoxButton_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField") public MobileElement EditLoyaltyBox_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Confirm']") public MobileElement LoyaltyconfirmButton_ios;
	@FindBy(xpath = "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton") public MobileElement multiTenderPayButton_ios;
	@FindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Enter CVV']") public MobileElement enterCVVBox_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Done! Payment Complete']") public MobileElement successfull_Transaction_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Success']") public MobileElement success_button_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Failure']") public MobileElement failure_button_ios;
	@FindBy(xpath = "//*[contains(@name,'Retry')]") public MobileElement retry_option_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Close']") public MobileElement close_option_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sorry! Payment Failed']") public MobileElement failure_Transaction_ios;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAmountError") public MobileElement amounterrorMsg_android;	
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvFailureMsg") public MobileElement failureMsg_android;

}
