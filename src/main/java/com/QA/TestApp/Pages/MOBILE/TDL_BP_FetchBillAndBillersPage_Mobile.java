package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_BP_FetchBillAndBillersPage_Mobile {

	public TDL_BP_FetchBillAndBillersPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	// Android locators
	@FindBy(id = "com.tatadigital.tcp.dev:id/tVSelectState")
	public MobileElement stateFieldElectricity_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tVSelectBoard")
	public MobileElement boardFieldElectricity_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/edtSearch")
	public MobileElement searchFieldElectricity_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBottomSheetItem")
	public MobileElement availableSearchItemElec_android;

	@FindBy(xpath = "//*[@text='Search']")
	public MobileElement searchField_android;

	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/biller_name'] | //*[@resource-id='com.tatadigital.tcp.dev:id/operatorNameTv']")
	public MobileElement availableSearchItem_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvBottomSheetItem']")
	public MobileElement availableSearchItem1_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/biller_name")
	public MobileElement selectedBoardOrOperator_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/input_edit_text")
	public MobileElement inputTextField_android;
	@FindBy(xpath = "(//*[@text='View Sample Bill']/following-sibling::*//*[@class='android.widget.EditText'])[1] | //*[@text='Consumer Number'] | //*[@text='CA Number'] | //*[@text='Connection Number'] | //*[@text='Account Number/User Name'] | //*[@text='Telephone Number'] | //*[@text='Registered Mobile Number / Viewing Card Number'] | //*[@resource-id='com.tatadigital.tcp.dev:id/input_edit_text'] ")
	public MobileElement first_inputTxtFld_android;
	@FindBy(xpath = "(//*[@text='View Sample Bill']/following-sibling::*//*[@class='android.widget.EditText'])[2] | //*[@text='Amount']")
	public MobileElement second_inputTxtFld_android;
	@FindBy(xpath = "(//*[@text='View Sample Bill']/following-sibling::*//*[@class='android.widget.EditText'])[3]")
	public MobileElement third_inputTxtFld_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/error_text")
	public MobileElement errorMessage_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBillAlertTitle")
	public MobileElement consentMessage_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnPositive'] | //*[@text='Okay']")
	public MobileElement yesOption_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnNegative'] | //*[@text='No']")
	public MobileElement noOption_android;
	
	@FindBy(xpath = "//*[@text='Fetch Bill' or @text='Proceed'] | //*[@text='PROCEED'] | //*[@text='ACCESS BILL'] | //*[@text='Access Bill'] | //*[contains(@text,'Show')]")
	public MobileElement fetchBillOrQuickPayBtn_android;
	
	@FindBy(xpath = "//*[@text='PROCEED'] | //*[@text='Proceed'] | //*[@text='ACCESS BILL'] | //*[@text='Access Bill'] | //*[@text='Pay Now'] | //*[@text='Pay now']")
	public MobileElement proceedBtn_android;

	@FindBy(xpath = "//*[@text='Amount']/..")
	public MobileElement fetchedBillDetailsContainer_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/rlContainer']/*[@class='android.widget.TextView']")
	public List<MobileElement> billerDtlsOnFetchedBillPg_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/etAmount']")
	public MobileElement amount_android;
	
	@FindBy(xpath = "com.tatadigital.tcp.dev:id/convenience_fee")
	public MobileElement amountMsg_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnAddBill")
	public MobileElement btnAddnow;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnNegative")
	public MobileElement btnAddLater;
	
	
	//(//*[@text='Amount']/following-sibling::*)[4]
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvBillDate']")
	public MobileElement billDate_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvDueDate']")
	public MobileElement dueDate_android;
	
	// this is not consumer Name so change it
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvCustomerName']")
	public MobileElement consumerName_android;

	@FindBy(xpath = "//*[@text='Save As']")
	public MobileElement saveAsTxt_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/etSaveAsAlias'] | //*[@resource-id='com.tatadigital.tcp.dev:id/clSaveAsChipUiMobile']")
	public MobileElement saveAsField_android;
	
	@FindBy(xpath = "//*[@text='Save As']/following::android.widget.TextView")
	public List<MobileElement> saveAsOptions_android;
	
	@FindBy(xpath = "//*[@text='Add Bill'] | //*[@text='Add Now'] | //*[@text='ADD NOW'] | //*[@text='ACCESS BILL'] | //*[@resource-id='com.tatadigital.tcp.dev:id/btnProceed'] | //*[@text='Add bill']")
	public MobileElement addBillBtn_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBillAlertTitle")
	public MobileElement addBillAlertHdr_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/btnNegative")
	public MobileElement notNowBtn_android;

	@FindBy(xpath = "//*[@text='Review'] | //*[@text='Payment Details'] | //*[@text='Payment details']")
	public MobileElement reviewPgHdr_android;
	@FindBy(xpath = "//*[@text='View Details']/.. | //*[@resource-id='com.tatadigital.tcp.dev:id/clReviewBillItemRoot']")
	public List<MobileElement> availableBills_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/billerNameTv']")
	public List<MobileElement> billerDtlsOnReviewPg_android;

	@FindBy(xpath = "//*[@text='Convinence fee'] | //*[@text='convenience fee']")
	public MobileElement convFeeTxt_android;
	
	@FindBy(xpath = "//*[@text='Tax']")
	public MobileElement taxFeeTxt_android;
	@FindBy(xpath = "//*[@text='Total Amount'] | //*[@text='Total amount']")
	public MobileElement totalAmountTxt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/convinenceTv")
	public MobileElement convFeeAmount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/taxTv")
	public MobileElement taxFeeAmount_android;
	@FindBy(xpath = "(//*[@text='Total Amount']/following-sibling::*)[2] | (//*[@text='Total amount']/following-sibling::*)[2]")
	public MobileElement totalAmount_android;

	@FindBy(xpath = "//*[@text='Alert']")
	public MobileElement alertBox_android;
	@FindBy(xpath = "(//*[@text='Alert']/following-sibling::*)[1]")
	public MobileElement alertMessage_android;
	@FindBy(xpath = "//*[@text='OK']")
	public MobileElement okBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Something went wrong.')]")
	public MobileElement errorMsg_android;

	@FindBy(xpath = "//*[@text='Mobile Prepaid'] | //*[@text='Mobile Postpaid']")
	public MobileElement mobilePgHdrTxt_android;
	@FindBy(xpath = "//*[@class='android.widget.EditText']")
	public MobileElement mobileNoField_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/selectFromContactIv")
	public MobileElement contactList_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/errorText")
	public MobileElement errorTxtMobile_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/numberTv")
	public MobileElement displayedNo_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/operatorNameTv")
	public MobileElement operator_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/input_edit_text")
	public MobileElement amtFeild_android;
	@FindBy(xpath = "//*[contains(@text,'Plan does not exist')]")
	public MobileElement amtError_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/changeOperatorTv")
	public MobileElement changeOperator_android;
	@FindBy(xpath = "//*[@text='View Plans']")
	public MobileElement viewPlans_android;
	@FindBy(xpath = "(//*[@text='Select'])[1]/..")
	public MobileElement firstPlan_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/error_text")
	public MobileElement planDetail_android;

	// Due Bill page
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvVewMore")
	public List<MobileElement> viewMoreBtn_android;
	@FindBy(xpath = "//*[contains(@text, 'Hide Details')]")
	public MobileElement btnhideDetails;
	@FindBy(id = "com.tatadigital.tcp.dev:id/cbRecentBill")
	public List<MobileElement> checkBoxDueBill_android;
	@FindBy(xpath = "//*[@text='Bill Date']/following-sibling::*")
	public MobileElement billDateDueBill_android;
	@FindBy(xpath = "//*[@text='Due Date']/following-sibling::*")
	public MobileElement dueDateDueBill_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etRecentBillsAmount")
	public MobileElement amountDueBill_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvLabelAmountDisclaimer")
	public MobileElement amountMsgDueBill_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tvOperatorName'])[1]")
	public MobileElement consumerNameDueBill_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/recyclerViewRecentBills")
	public List<MobileElement> recentBillsItems_android;

	@FindBy(xpath = "//*[@text='View Less']")
	public MobileElement postpaidOperator_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvErrorDialogMsg")
	public MobileElement operatorChangeAlert_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/okayButton")
	public MobileElement okBtnPostpaid_android;
	@FindBy(xpath = "//*[@text='Select Operator']")
	public MobileElement operatorPgHdr_android;

	//prepaid operator
	@FindBy(xpath = "//*[@text='Change Operator']")
	public MobileElement prepaidOperatorHdr_android;
	
	@FindBy(xpath = "//*[@text='Change Operator']")
	public MobileElement prepaidCircleHdr_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/circleName")
	public MobileElement circleoption_android;
	
	@FindBy(xpath = "(//*[@text='Mobile Prepaid'])[1]")
	public MobileElement prepaidHdr_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/numberTv")
	public MobileElement prepaidNo_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/rightTextTv")
	public MobileElement viewplan_android;
	
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/input_edit_text")
	public MobileElement prepaidAmt_android;
	
	@FindBy(xpath = "//*[@text='Plan does not exist']")
	public MobileElement planSelectionoptions_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/error_text")
	public MobileElement plandetail_android;
	
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/recommendedPlanTv")
	public MobileElement recommendedPlans_android;
	@FindBy(xpath = "(//*[@text='Select'])[1]")
	public MobileElement planSelection_android;
	
	
	
	
	
	
	
	

	
	/*
	 *  IOS Locators
	 *  
	 */
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='State']/following-sibling::*)[1]")
	public MobileElement stateField_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Board'] | //XCUIElementTypeButton[@name='Electricity Board']")
	public MobileElement selectBoard_ios;
	@FindBy(id = "")
	public MobileElement boardField_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@value ='Search']")
	public MobileElement searchField_ios;
	@FindBy(xpath = "//XCUIElementTypeCell")
	public MobileElement availableSearchItem_ios;
	@FindBy(id = "com.tatadigital.tcp.dev:id/input_edit_text")
	public MobileElement inputTextField_ios;

	@FindBy(xpath = "//XCUIElementTypeTextField")
	public MobileElement first_inputTxtFld_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@value='Amount']")
	public MobileElement second_inputTxtFld_ios;
	@FindBy(xpath = "(//XCUIElementTypeTextField)[3]")
	public MobileElement third_inputTxtFld_ios;

	@FindBy(id = "com.tatadigital.tcp.dev:id/error_text")
	public MobileElement errorMessage_ios;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBillAlertMsg")
	public MobileElement consentMessage_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")
	public MobileElement yesOption_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Not Now']")
	public MobileElement noOption_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Fetch Bill'] or //XCUIElementTypeStaticText[@name='Proceed']")
	public MobileElement fetchBillOrQuickPayBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Proceed']")
	public MobileElement proceedBtn_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']/..")
	public MobileElement fetchedBillDetailsContainer_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText")
	public List<MobileElement> billerDtlsOnFetchedBillPg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']/following-sibling::XCUIElementTypeTextField")
	public MobileElement amount_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']/following-sibling::XCUIElementTypeStaticText")
	public MobileElement amountMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bill Date']/following-sibling::*[3]")
	public MobileElement billDate_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Due Date']/following-sibling::*[3]")
	public MobileElement dueDate_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Consumer Name']/following-sibling::*[1]")
	public MobileElement consumerName_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Save As']")
	public MobileElement saveAsTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Save As']/following-sibling::*[1]")
	public MobileElement saveAsField_ios;

	@FindBy(xpath = "//*[@text='Review']")
	public MobileElement reviewPgHdr_ios;
	@FindBy(xpath = "//*[@text='View Details']/..")
	public List<MobileElement> availableBills_ios;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/billerNameTv']")
	public List<MobileElement> billerDtlsOnReviewPg_ios;
	@FindBy(xpath = "//*[@text='Convinence fee']")
	public MobileElement convFeeTxt_ios;
	@FindBy(xpath = "//*[@text='Tax']")
	public MobileElement taxFeeTxt_ios;
	@FindBy(xpath = "//*[@text='Total Amount']")
	public MobileElement totalAmountTxt_ios;
	@FindBy(id = "com.tatadigital.tcp.dev:id/convinenceFeeTv")
	public MobileElement convFeeAmount_ios;
	@FindBy(id = "com.tatadigital.tcp.dev:id/taxTv")
	public MobileElement taxFeeAmount_ios;
	@FindBy(id = "com.tatadigital.tcp.dev:id/totalAmountTv")
	public MobileElement totalAmount_ios;

	@FindBy(xpath = "//*[@text='Alert']")
	public MobileElement alertBox_ios;
	@FindBy(xpath = "(//*[@text='Alert']/following-sibling::*)[1]")
	public MobileElement alertMessage_ios;
	@FindBy(xpath = "//*[@text='OK']")
	public MobileElement okBtn_ios;
	@FindBy(xpath = "//*[contains(@text,'Something went wrong.')]")
	public MobileElement errorMsg_ios;

	@FindBy(xpath = "//XCUIElementTypeTextField[contains(@value,'Search')] | //XCUIElementTypeTextField[contains(@value,'Select Provider')]")
	public MobileElement search_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select State']")
	public MobileElement state_header_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Operator']")
	public MobileElement operator_header_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Board']/following-sibling::XCUIElementTypeButton")
	public MobileElement get_board_name_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField")
	public MobileElement consumer_id_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Operator']/following::XCUIElementTypeCell[2]/XCUIElementTypeTextField")
	public MobileElement customer_input2_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='Fetch Bill'])[2] | (//XCUIElementTypeButton[@name='Access Bill'])[2] | //XCUIElementTypeButton[@name='TCPPaymentsKit.DTH.actionFetchBillButton'] | //XCUIElementTypeButton[@name='TCPPaymentsKit.Plans.actionProccedButton']")
	public MobileElement fetch_bill_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Proceed'] | //XCUIElementTypeButton[@name='Access Bill']")
	public MobileElement fetch_bill_prepost_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Number']/following::XCUIElementTypeTextField")
	public MobileElement mobile_number_input_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Postpaid']//following::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
	public MobileElement mobile_number_validation_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Postpaid']//following::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[3]")
	public MobileElement operator_validation_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Postpaid']")
	public MobileElement mobile_post_hdr_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Prepaid']")
	public MobileElement mobile_prep_hdr_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='TCPPaymentsKit.LandlineBroadband.imageCell'] |//XCUIElementTypeStaticText[@name='Select Operator']//following::XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell| //XCUIElementTypeStaticText[@name='Select Board']//following::XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell |//XCUIElementTypeStaticText[@name='Select State']//following::XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell | //XCUIElementTypeStaticText[@name='Select Provider']//following::XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
	public MobileElement search_result_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Fetch Future Bills?'] | //XCUIElementTypeStaticText[@text='Would you like to see your upcoming bills?']")
	public MobileElement future_fetch_bill_hdr_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Not Now'] | //XCUIElementTypeButton[@name='No']")
	public MobileElement not_now_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Yes'] | //XCUIElementTypeButton[@name='Okay']")
	public MobileElement yes_fetch_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Alert!']")
	public MobileElement Alert_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	public MobileElement Ok_button_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Mr')]")//XCUIElementTypeStaticText[@name='Consumer Name']/following::XCUIElementTypeStaticText[1]")
	public MobileElement consumer_name_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bill No']/following::XCUIElementTypeStaticText[1]")//   | //XCUIElementTypeStaticText[@name='Consumer Name']/following::XCUIElementTypeStaticText[2]")
	public MobileElement bill_no_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bill Date']/following::XCUIElementTypeStaticText[1]")
	public MobileElement bill_date_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Due Date']/following::XCUIElementTypeStaticText[1]")
	public MobileElement due_date_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']/following::XCUIElementTypeTextField[1]")
	public MobileElement amount_new_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'convenience')]")
	public MobileElement convenience_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Save As']/following::XCUIElementTypeTextField[1]")
	public MobileElement save_as_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay Bill']")
	public MobileElement pay_bill_fetch_pg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Domain Error']")
	public MobileElement domain_err_new_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Okay']")
	public MobileElement Okay_button_new_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='Access Bill'])[2]")
	public MobileElement access_bill_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPPaymentsKit.BillerDetails.actionProccedButton']")
	public MobileElement addBillBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Clear your headspace']")
	public MobileElement addsec_bill_hdr_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add now'] ")
	public MobileElement add_now_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add later']")
	public MobileElement add_later_new_ios;
	@FindBy(xpath = "//*[@name='ReviewBillViewController']")
	public MobileElement review_pg_hdr_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Convenience fee']")
	public MobileElement review_pg_convenienceFeeTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Total Amount']/following-sibling::XCUIElementTypeStaticText[2]") public MobileElement review_pg_convenienceFeeAmount_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Total Amount']/following-sibling::XCUIElementTypeStaticText[1]")
	public MobileElement review_pg_totalAmount_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPPaymentsKit.Review.actionAddMoreBill']")
	public MobileElement add_more_bill_review_pg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Convenience')]/preceding::XCUIElementTypeStaticText[3]")
	public MobileElement consumer_name_review_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Convenience')]/preceding::XCUIElementTypeStaticText[2]")
	public MobileElement consumer_id_review_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Convenience')]/preceding::XCUIElementTypeStaticText[1]")
	public MobileElement amount_review_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPPaymentsKit.Review.editBill']")
	public MobileElement view_bill_review_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPPaymentsKit.Review.productRemoveTapped']")
	public MobileElement remove_review_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPPaymentsKit.Review.gotoPaymentAction']")
	public MobileElement pay_bill_review_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Total Amount']/preceding::XCUIElementTypeStaticText[1]")
	public MobileElement total_amount_review_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Convenience')]/preceding::XCUIElementTypeCell")
	public List<MobileElement> review_pg_bill_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Save As']")
	public MobileElement save_as_txt_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Total Amount']")
	public MobileElement total_amount_txt_review_ios;
	
	@FindBy(xpath = "//XCUIElementTypeCell[@name='TCPPaymentsKit.Mobile.mobileNumberTableViewCell']/XCUIElementTypeTextField")
	public MobileElement mobileNoField_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Prepaid']")
	public MobileElement prepaidHdr_ios;
	
	@FindBy(xpath = "//XCUIElementTypeCell[@name='TCPPaymentsKit.Mobile.amountDetailsCell']/XCUIElementTypeTextField")
	public MobileElement amtFeild_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Plan does not exist']")
	public MobileElement amtError_ios;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPPaymentsKit.PlanSelection.actionViewPlan']")
	public MobileElement viewPlans_ios;
	
	@FindBy(xpath = "(//XCUIElementTypeTable[@name=\"TCPPaymentsKit.Mobile.rechargePlanTableView\"]/XCUIElementTypeCell)[1]//XCUIElementTypeButton[@name=\"TCPPaymentsKit.Plans.selectPlan\"]")
	public MobileElement firstPlan_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']") public MobileElement amountHeader_ios;

}