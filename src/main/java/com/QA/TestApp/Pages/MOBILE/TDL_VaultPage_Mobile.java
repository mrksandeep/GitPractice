package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_VaultPage_Mobile {

	public TDL_VaultPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define android locators
	 * 
	 */
	@FindBy(xpath = "//*[@text='U Points']")
	public MobileElement cardName_TCP_android;

	@FindBy(xpath = "//*[@text='Croma']")
	public MobileElement cardName_Croma_android;

	@FindBy(xpath = "//*[@text='IHCL']")
	public MobileElement cardName_IHCL_android;

//	@FindBy(id = "com.tatadigital.tcp.dev:id/btnViewDetails")
//	public MobileElement viewDetailsCTA_android;
	
	@FindBy(xpath = "//*[@text='View Details'][1]")
	public MobileElement viewDetailsCTA_android;

	@FindBy(xpath = "//*[@text='My Cards']")
	public MobileElement cardTab_android;

	@FindBy(xpath="//androidx.appcompat.app.ActionBar.Tab[@content-desc='Tata Pay']") public MobileElement tataPayTab_android;
	@FindBy(xpath="//androidx.appcompat.app.ActionBar.Tab[@content-desc='My Cards']") public MobileElement cardsTab_android;
	@FindBy(xpath="//androidx.appcompat.app.ActionBar.Tab[@content-desc='Saved Offers']") public MobileElement offersTab_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAddNew") public MobileElement addNew_android;	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRowTitle") public MobileElement paymentMethod_android;
	@FindBy(xpath="//*[@text='CARD NUMBER']") public MobileElement cardNumber_android;
	@FindBy(xpath="//*[@text='EXPIRY DATE']") public MobileElement expirtDate_android;
	@FindBy(xpath="//*[@text='4001-XXXXXXXX-7193']") public MobileElement CardNumValue_android;
	@FindBy(xpath="//*[@text='ICICI BANK']") public MobileElement cardNameICICI_android;	
	@FindBy(xpath="//*[@text='BANCODOBRASIL.S.A.']") public MobileElement cardNameBANCODOBRASIL_android;
	@FindBy(xpath="//*[@text='BARCLAYS BANK']") public MobileElement cardNameBARCLAYS_android;
	@FindBy(xpath="//*[@text='ALLIEDIRISHBANKSPLC']") public MobileElement cardNameALLIEDIRISHBANKSPLC_android;
	@FindBy(xpath="//*[@text='05/2023']") public MobileElement expiryDateValue_android;	
	@FindBy(xpath="//*[contains(@text, 'Transfer to account')]") public MobileElement accountTransfer_android;	
	@FindBy(xpath="//*[@text='Approve requests']") public MobileElement approve_android;
	@FindBy(xpath="//*[@text='Check balance']") public MobileElement checkBalance_android;
	@FindBy(xpath="//*[@text='Transfer to self']") public MobileElement payToSelf_android;	
	@FindBy(xpath="//*[@text='Request money']") public MobileElement request_android;
	@FindBy(xpath="//*[@text='Send money']") public MobileElement sendMoney_android;
	@FindBy(xpath="//*[@text='Scan & pay']") public MobileElement scanAndPay_android;
	@FindBy(xpath="//*[@text='UPI settings']") public MobileElement upiSettings_android;
	@FindBy(xpath="//*[@text='Manage mandates']") public MobileElement manageMandate_android;
	@FindBy(xpath="//*[@text='My QR']") public MobileElement myQR_android;
	@FindBy(xpath="//*[@text='Send money']") public MobileElement send_android;
	@FindBy(xpath="//*[@text='Transfer to account']") public MobileElement account_transfer_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/upiServiceTitle") public MobileElement Upi_Services_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/nb5PrimaryCtaButton") public MobileElement primary_cta_button_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/nb5SecondaryCtaButton") public MobileElement secondary_cta_button_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/btnInsuranceBuyNow") public MobileElement Buy_Now_Insurance_button_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnClose") public MobileElement Button_Close_primary_cta_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvBasicDetails") public MobileElement cta_basic_details_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvInsuranceUserFirstName") public MobileElement cta_Insurance_User_First_Name_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvInsuranceUserLastName") public MobileElement cta_Insurance_User_Last_Name_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose") public MobileElement Button_Close_secondary_cta_android;


	@FindBy(xpath="//*[@text='Pay bills']") public MobileElement pay_bills_text_android;
	@FindBy(xpath="//*[@text='With just one tap']") public MobileElement pay_bills_description_android;
	@FindBy(xpath="//*[@text='UPI services']") public MobileElement Upi_Services_text_android;
	@FindBy(xpath="//*[@text='Cards']") public MobileElement cards_text_android;
	@FindBy(xpath="//*[@text='Add new']") public MobileElement add_new_android;

	@FindBy(id="com.tatadigital.tcp.dev:id/messageTextView") public MobileElement register_upi_description_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnRegister") public MobileElement register_upi_button_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvViewMore") public MobileElement view_more_button_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/upi_account_holder_name") public MobileElement vpa_id_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/right_arrow")}) public List<MobileElement> primaryaccountrightarrow_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/top_container") public MobileElement upi_account_android;
	@FindBy(xpath="//*[@text='Okay']") public MobileElement okay_button_upi_android;
	@FindBy(xpath="//*[@text='Add Account']") public MobileElement add_account_upi_android;
	@FindBy(xpath="//*[@text='(//*[@text='4 Digit UPI Pin Exists'])[1]']") public MobileElement pin_exists_text_upi_android;
	@FindBy(xpath="//*[@text='Recent Bills']") public MobileElement recent_bills_text_android;
	@FindBy(xpath="//*[@text='Billers']") public MobileElement Billers_text_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/recyclerViewRecentBills") public MobileElement first_recent_bills_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/payNewBill") public MobileElement Add_new_Bill_text_android;
	@FindBy(xpath="//*[@text='Bill Payment']") public MobileElement bill_payment_text_android;
	@FindBy(xpath="//*[@text='Recharges']") public MobileElement recharges_text_android;
	@FindBy(xpath="//*[@text='Broadband']") public MobileElement bill_payment_Broadband_text_android;
	@FindBy(xpath="//*[@text='Electricity']") public MobileElement bill_payment_Electricity_text_android;
	@FindBy(xpath="//*[@text='Gas']") public MobileElement bill_payment_Gas_text_android;
	@FindBy(xpath="//*[@text='Landline']") public MobileElement bill_payment_Landline_text_android;
	@FindBy(xpath="//*[@text='Mobile Postpaid']") public MobileElement bill_payment_Mobile_Postpaid_text_android;
	@FindBy(xpath="//*[@text='Water']") public MobileElement bill_payment_water_text_android;
	@FindBy(xpath="//*[@text='DTH']") public MobileElement recharges_DTH_text_android;
	@FindBy(xpath="//*[@text='Mobile Prepaid']") public MobileElement recharges_Mobile_Prepaid_text_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivCloseToolbarModal") public MobileElement round_close_button_android;
	
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/lblPartnerName'])[1]") public MobileElement first_card_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvBankName']") public MobileElement bank_name_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivTxnClose']") public MobileElement close_card_button_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvCardNumber']") public MobileElement card_number_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvExpiry']") public MobileElement expiry_card_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvCardHolderName']") public MobileElement card_holder_name_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivCardIcon']") public MobileElement card_icon_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivTrash']") public MobileElement Trash_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/rvTransactionHistoryVault']") public MobileElement Transaction_History_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvMore']") public MobileElement More_button_modal_android;
	@FindBy(xpath="//*[@text='Download Statement']") public MobileElement Download_statement_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnPdf']") public MobileElement pdf_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnExcel']") public MobileElement excel_modal_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/rbThisMonth']") public MobileElement thisMonth_Card_modal_android;
	
	

	
	
	@FindBy(xpath="(//*[@resource-id='com.tatadigital.tcp.dev:id/recyclerViewPaymentMethod'])") public MobileElement existing_user_already_added_card_android;
	@FindBy(xpath="(//*[@resource-id='com.tatadigital.tcp.dev:id/paymentMethodsAddLayout'])") public MobileElement new_user_no_card_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/imgCard") public MobileElement addNew_Plus_symbol_android;	
	@FindBy(id="com.tatadigital.tcp.dev:id/etCardName") public MobileElement card_name_add_card_android;	
	@FindBy(id="com.tatadigital.tcp.dev:id/etCardNumber") public MobileElement card_number_add_card_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/etExpMonth") public MobileElement Month_add_card_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/etExpYear") public MobileElement Year_add_card_android;
	@FindBy(xpath = "//*[@text='02']") public MobileElement Second_Month_add_card_android;
	@FindBy(xpath = "//*[@text='25']") public MobileElement Twenty_Fifth_Month_add_card_android;
	@FindBy(xpath = "//*[@text='We ran into a technical glitch while adding your card. Try again?']") public MobileElement Technical_glitch_error_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/btnAddCardContinue") public MobileElement continue_button_add_card_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/textinput_error") public MobileElement error_card_number_add_card_android;
	
	@FindBy(xpath = "//*[@text='XXXX 1111'][1]") public MobileElement added_card_number_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/ivTrash") public MobileElement trash_button_card_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/positiveButton") public MobileElement ok_button_delete_card_android;
	@FindBy(xpath = "//*[@text='Alert!']") public MobileElement alert_button_android;
	
	@FindBy(xpath = "//*[@text='XXXX 1111'][1]") public MobileElement added_first_card_number_android;
	@FindBy(xpath = "//*[@text='XXXX 2943'][1]") public MobileElement added_Second_card_number_android;
	@FindBy(xpath = "//*[@text='XXXX 1881'][1]") public MobileElement added_third_card_number_android;
	
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/aliasName'])[1]") public MobileElement first_card_number_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/aliasName'])[2]") public MobileElement second_card_number_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/aliasName'])[3]") public MobileElement third_card_number_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/aliasName'])[4]") public MobileElement fourth_card_number_android;
	
	
	
	

	//lipika//
//	@FindBy(xpath="//*[contains(@text, 'Primary')]") public MobileElement primaryText_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/incCreateVpa") public MobileElement primaryAccountNumber_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/upi_account_no") public MobileElement primaryAccountMaskedNumber_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvToolbar") public MobileElement toolbar_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvBankName") public MobileElement bankName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivBankLogo")public MobileElement bankLogo_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvViewMore") public MobileElement toggleViewMore_android;
	@FindBy(xpath="//*[@text='Allow' or @text='While using the app']") public MobileElement allow_android;
	
	
	//Primary account available on Tata Pay Vault page 16-11
		@FindBy(id="com.tatadigital.tcp.dev:id/tvDelete") public MobileElement primaryText_android;

	
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='U Points']")
	public MobileElement cardName_TCP_ios;

	@FindBy(xpath = "//*[@value='Croma']")
	public MobileElement cardName_Croma_ios;
	
	@FindBy(xpath = "//*[@value='IHCL']")
	public MobileElement cardName_IHCL_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.userVault.loyaltyViewDetails']")
	public MobileElement viewDetailsCTA_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='My Cards']")
	public MobileElement cardTab_ios;

	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Pay']") public MobileElement tataPayTab_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='My Cards']") public MobileElement cardsTab_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Saved Offers']") public MobileElement offersTab_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Add New']") public MobileElement addNew_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='PAYMENT METHODS']") public MobileElement paymentMethod_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='Vault'])[1]") public MobileElement vaultHeader_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='View details'])[1]") public MobileElement viewDetails_ios;
	@FindBy(id="tcpApp.userVault.loyaltyCardName") public MobileElement loyaltyCardName_ios;	
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='tcpApp.userVault.bankCardName'])[1]") public MobileElement cardNameBANCODOBRASIL_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='tcpApp.userVault.bankCardName'])[2]") public MobileElement cardNameBARCLAYS_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='tcpApp.userVault.bankCardName'])[3]") public MobileElement cardNameALLIEDIRISHBANKSPLC_ios;
	@FindBy(id="tcpApp.userVault.loyaltyCardPointStatus") public MobileElement loyaltyCardPointStatus_ios;	
	
	

	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Send Money'] | //XCUIElementTypeStaticText[@name='Send']") public MobileElement sendMoney_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='TCPApp.OptionViewCell.maximizeButton']") public MobileElement maximiseUpiServices_ios;

	
	@FindBy(xpath="//XCUIElementTypeStaticText[@value='Pay Bills']") public MobileElement bill_payment_description1_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@value='With just one tap']") public MobileElement bill_payment_description2_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@value='UPI services']") public MobileElement upi_services_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@value='Register Now']") public MobileElement register_now_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@value='Register with Tata Pay UPI to make payments fast and easy ']") public MobileElement upi_register_description_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Scan & Pay']") public MobileElement scanAndPay_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Request']") public MobileElement request_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Send']") public MobileElement send_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Approve']") public MobileElement approve_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Check Balance']") public MobileElement checkBalance_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Manage Mandate']") public MobileElement manageMandate_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Account Transfer']") public MobileElement accountTransfer_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Pay to Self']") public MobileElement payToSelf_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@label='MinimizedArrow']") public MobileElement view_more_button_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='UPI Settings']") public MobileElement upiSettings_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='My QR']") public MobileElement myQR_ios;
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='tcpApp.userVault.bankCardName'])[1]") public MobileElement first_card_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='HDFC Bank'])[1]") public MobileElement bank_name_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconCircleCross']") public MobileElement close_card_button_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='4012 XXXX XXXX 1112']") public MobileElement card_number_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Expiry date']") public MobileElement expiry_card_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='CARD HOLDER ']") public MobileElement card_holder_name_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeImage[3]") public MobileElement card_icon_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='trash']") public MobileElement Trash_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable") public MobileElement Transaction_History_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='More']") public MobileElement More_button_modal_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Download Statement']") public MobileElement Download_statement_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.moreView.button.pdfButton']") public MobileElement pdf_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Excel']") public MobileElement excel_modal_ios;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/rbThisMonth']") public MobileElement thisMonth_Card_modal_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='ActivityListView']/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther") public MobileElement downloaded_file_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Close']") public MobileElement download_close_button_ios;
	
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@value='Pay Bills']") public MobileElement pay_bills_text_ios;
	
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Bill Payment']") public MobileElement bill_payment_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Recharges']") public MobileElement recharges_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Broadband']") public MobileElement bill_payment_Broadband_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Electricity']") public MobileElement bill_payment_Electricity_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Gas']") public MobileElement bill_payment_Gas_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Landline']") public MobileElement bill_payment_Landline_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Mobile Postpaid']") public MobileElement bill_payment_Mobile_Postpaid_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Water']") public MobileElement bill_payment_water_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='DTH']") public MobileElement recharges_DTH_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Mobile Prepaid']") public MobileElement recharges_Mobile_Prepaid_text_ios;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivCloseToolbarModal") public MobileElement round_close_button_ios;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='paymentKit.repeatUser.recentBill']") public MobileElement recent_bills_text_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='paymentKit.repeatUser.billers']") public MobileElement Billers_text_ios;
	@FindBy(xpath="//XCUIElementTypeTable[@name='paymentKit.recentBill.table']/XCUIElementTypeCell[1]") public MobileElement first_recent_bills_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='paymentKit.recentBill.addNewUpper']") public MobileElement Add_new_Bill_text_ios;
	@FindBy(xpath="//XCUIElementTypeTable[@name='paymentKit.biller.table']/XCUIElementTypeCell[1]") public MobileElement first_billers_detail_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Cards']") public MobileElement cards_text_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Add new']") public MobileElement addNewCard_ios;
	@FindBy(xpath="//XCUIElementTypeImage[@name='tcpApp.userVault.bankCardBackground']") public MobileElement card_background_ios;
	
	
	
	@FindBy(xpath="//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.cardHolderNameTextField']") public MobileElement card_name_add_card_ios;	
	@FindBy(xpath="//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.cardNumberTextField']") public MobileElement card_number_add_card_ios;
	@FindBy(xpath="//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.monthTextField']") public MobileElement Month_add_card_ios;
	@FindBy(xpath="//XCUIElementTypeTextField[@name='TCPApp.AddCardPageViewController.yearTextField']") public MobileElement Year_add_card_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Done']") public MobileElement done_button_ios;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='TCPApp.AddCardPageViewController.continueButton']") public MobileElement continue_button_add_card_ios;
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='tcpApp.userVault.bankCardName'])[2]") public MobileElement added_card_name_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='PARTHA KAYAL']") public MobileElement added_card_holder_name_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='trash']") public MobileElement trash_button_card_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Confirm']") public MobileElement ok_button_delete_card_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='We ran into a technical glitch while adding your card. Try again?']") public MobileElement Technical_glitch_error_ios;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='UPI services']") public MobileElement Upi_Services_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='View Details']") public MobileElement primary_cta_button_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Buy Now']") public MobileElement secondary_cta_button_ios;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Buy Now']") public MobileElement Buy_Now_Insurance_button_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='iconCircleCross']") public MobileElement Button_Close_primary_cta_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='BASIC DETAILS'])[1]") public MobileElement cta_basic_details_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@label='First Name*']") public MobileElement cta_Insurance_User_First_Name_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@label='Last Name*']") public MobileElement cta_Insurance_User_Last_Name_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Back']") public MobileElement Button_Close_secondary_cta_ios;
//  //XCUIElementTypeButton[@name='closeODPScreen']
}