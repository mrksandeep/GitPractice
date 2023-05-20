package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.QA.TestApp.Utilities.BaseScript;



//import io.appium.java_client.MobileElement;

public class TDL_PayBillPage extends BaseScript {

	//Biller
	@FindBy(xpath="//*[text()='Your bills']") public WebElement yourBills;
	
	//RecentBills
	@FindBy(xpath="//*[text()='Recent Bills'] | //*[text()='Pay a new bill']") public WebElement tabRecentBills;
	@FindBy(xpath="//*[text()='Add New Bill'] | //*[text()='Pay a new bill']") public WebElement lnkAddNewBill;
	
	//Utilities
	@FindBy(xpath="//*[text()='Utilities']") public WebElement headerUtilities;
	
	//SelectOperator
	@FindBy(xpath="//*[text()='Select Operator']") public WebElement headerSelectOperator;
	
	//SelectState
	@FindBy(xpath="//*[text()='Select Sate']") public WebElement headerSelectState;
	
	//ErrorMessage
	@FindBy(xpath="//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') , 'enter a valid')] | //*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') , 'is invalid')] | //*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') , 'invalid')]") public WebElement msgError;
	
	//No Bills Addeded text
	@FindBy(xpath="//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') , 'you haven’t added any bills yet')]") public WebElement msgNoBillsAdded;
	
	//Fetch Bill Button
	@FindBy(xpath="//*[contains(text(),'View bill')] | //button[text()='View bill'] | //button[contains(text(),'Proceed')] | //button[contains(text(),'Proceed to pay')]") public WebElement btnFetchBill;



//nov 10//revathi//
	@FindBy(xpath="//*[contains(text(),'Bill Payments')] | (//*[contains(text(),'Pay bills')]) | //*[contains(text(),'Pay Bills')]") public WebElement utility_pop;
	@FindBy(xpath="//div[@id='root']//*[contains(text(),'All Bills')]") public WebElement allBills_btn;
	@FindBy(xpath="//div[@id='root']//*[contains(text(),'Due Bills')] | //div[contains(text(),'Due Bills')]") public WebElement dueBills_btn;
	@FindBy(xpath="//div[@id='root']//*[contains(text(),'Paid Bills')] | //div[contains(text(),'Paid Bills')]") public WebElement paidBills_btn;
	
	@FindBy(xpath="//*[contains(text(),'All bills')]/following::section[contains(@*,'#')]") public List<WebElement> all_bills;
	@FindBy(xpath="//*[contains(text(),'Overdue')] | //*[contains(text(),'Due on')]") public List<WebElement> due_bills;
	@FindBy(xpath="//*[contains(text(),'Paid on')]") public List<WebElement> paid_bills;
	@FindBy(xpath="//*[contains(text(),'Overdue')]/preceding-sibling::label") public List<WebElement> due_bills_amount;
	@FindBy(xpath="//img[@alt='Broadband'] | //*[@data-category-name='Broadband']") public WebElement Broadband;
	@FindBy(xpath="//img[@alt='DTH'] | //*[@data-category-name='DTH']") public WebElement DTH;
	@FindBy(xpath="//img[@alt='Electricity'] | //*[@data-category-name='Electricity']") public WebElement Electricity;
	@FindBy(xpath="//img[@alt='Piped gas'] | //*[@data-category-name='Gas'] | //*[contains(text(),'Piped gas')]") public WebElement Gas;
	@FindBy(xpath="//img[@alt='Landline'] | //*[@data-category-name='Landline']") public WebElement Landline;
	@FindBy(xpath="//img[@alt='Mobile Postpaid'] | //*[@data-category-name='Mobile Postpaid'] | //*[contains(text(),'Mobile postpaid')]") public WebElement Mobile_Postpaid;
	@FindBy(xpath="//img[@alt='Mobile Prepaid'] | //*[@data-category-name='Mobile prepaid']") public WebElement Mobile_Prepaid;
	@FindBy(xpath="//img[@alt='Water'] | //*[@data-category-name='Water']") public WebElement Water;
	@FindBy(xpath="(//*[contains(text(),'State')]/following::div/button)[1] | (//*[contains(text(),'Select')])[2] | //*[contains(text(),'State')]") public WebElement state_electricity;
	////*[contains(text(), 'Operator')])/..//following::div/button)[1] | //*[contains(text(),'Board')]/following::div/span | (//*[text()='Mahanagar Gas Limited'])[2] | (//*[contains(text(),'Board')])[2] | 
	@FindBy(xpath="//input[@class='sc-cRKLkh cnWyym']") public WebElement Operator;
	//((//span[text()='Board'])/../following-sibling::div//span)[1] | ((//span[text()='Operator'])/../following-sibling::div//span)[1] | 
	@FindBy(xpath="//input[@id='billpay-customer-number-input-0'] | //input[@id='billpay-mobile-prepaid-number-input']") public WebElement consumer_id;
	@FindBy(xpath="//input[@name='billpay-customer-number-input-0']") public WebElement consumer_id_input;
	@FindBy(xpath="(//*[contains(text(), 'Operator')]/following::div/div/input)[2] | (//*[contains(text(), 'Operator')]/following::input)[2] | //*[@id='billpay-customer-number-input-0']") public WebElement addres_am_id;
	@FindBy(xpath="(//*[contains(text(), 'View Sample')]/following::div/div/div/input)[2] | //*[@id='billpay-customer-number-input-1']") public WebElement telephone_id;
	@FindBy(xpath="(//*[contains(text(),'Future')])[1] | //*[contains(text(),'Shall we fetch your upcoming bills every month?')] | //*[contains(text(),'Yes,I'm in')] | //*[contains(text(),'Uh-oh! Something went wrong. Retry later')]") public WebElement consent;
	@FindBy(xpath="//button[contains(text(),'No')] | //button[text()='No, thanks']") public WebElement No_option;
	@FindBy(xpath="//button[text()='Add bill to cart']") public WebElement addbilltocartbtn;
	@FindBy(xpath="//button[text()='Proceed']") public WebElement proceedbtn;
	@FindBy(xpath="//*[text()='Total amount']") public WebElement total_amount;
	@FindBy(xpath="//button[contains(text(),'Ok')] | //*[@class='style__PopUpContainer-kQLSpS kxlHuK']/div[4]/button[2] | //*[contains(text(),'Yes,I'm in')] | //*[contains(text(),'Okay')]") public WebElement yes_option;
	@FindBy(xpath="//*[@id='billpay-bill-amount-input'] | //*[@id='billpay-mobile-prepaid-number-input']") public WebElement bill_amount;
	@FindBy(xpath="//*[@id='billpay-bill-amount-input']/following::*") public WebElement convenience_fee_msg;
	@FindBy(xpath="//label[text()='Label this bill']/following::div/input") public WebElement labelField;
	@FindBy(xpath="//button[text()='Add bill to cart']") public WebElement addbilltocart;
	@FindBy(xpath="(//*[contains(text(),'Bill No')]/following::div)[1]") public WebElement consumer_bill_no;
	@FindBy(xpath="(//*[contains(text(),'Bill Date')]/following::div)[1]") public WebElement bill_date;
	@FindBy(xpath="(//*[contains(text(),'Due Date')]/following::div)[1]") public WebElement due_date;
	@FindBy(xpath="//button[contains(text(),'Add more bills')]") public WebElement add_bill;
	@FindBy(xpath="//*[contains(text(),'Amount')]/following::div/input") public WebElement save_text_bill;
	@FindBy(xpath="//*[contains(text(),'All Bills')] | //*[contains(text(),'Struggling')] | //*[contains(text(),'pending bills')]") public WebElement all_bill_one_go;
	@FindBy(xpath="//button[contains(text(),'Not Now')] | //button[contains(text(),'Add Later')] | //*[contains(text(),'Pay later')] | //button[contains(text(),'Cancel')]") public WebElement not_now;

	@FindBy(xpath="//span[text()='View']") public WebElement review_pg;
	@FindBy(xpath="//*[contains(@data-testid,'cart-item')]") public List<WebElement> no_of_bills_review;
	@FindBy(xpath="//*[contains(text(), 'Convenience')]/following-sibling::label") public WebElement convenience_fee_amount;
	@FindBy(xpath="//*[contains(text(), 'Convenience')]") public WebElement convenience;
	@FindBy(xpath="//*[contains(text(), 'Tax')]") public WebElement Tax;
	@FindBy(xpath="//*[contains(text(), 'Total')]") public WebElement total_amo_text;
	@FindBy(xpath="(//*[contains(text(), 'Total amount')]/following::label)[1]") public WebElement total_Amount;
	
	@FindBy(xpath="//*[contains(text(), 'Proceed')]") public WebElement proceed;

	//11 nov//
	@FindBy(xpath="	//*[contains(text(), 'Alert')]") public WebElement Alert_box;
	@FindBy(xpath="	//*[contains(text(), 'Alert')]/following-sibling::*)[1]") public WebElement Alert_box_msg;
	@FindBy(xpath=" //*[contains(text(),'Something went wrong.')] | //*[contains(text(),'Uh-oh! Something went wrong')]") public WebElement errorMsg;

	@FindBy(xpath="//*[normalize-space(text())= 'Payment']") public WebElement Payment_hdr;

	@FindBy(xpath="(//*[contains(text(), 'Amount')]/following::span)[1]") public WebElement Amount;
	@FindBy(xpath="//*[contains(text(), 'Change')]/preceding-sibling::label") public WebElement Payment_method;
	@FindBy(xpath="(//*[contains(text(), 'Change')])[1]") public WebElement changeMethod;
	
	@FindBy(xpath="//input[@placeholder='Enter CVV']") public WebElement enter_CVV;
	@FindBy(xpath="//button[contains(text(),'Pay')]") public WebElement pay;
	@FindBy(xpath="//button[contains(text(),'Success')]") public WebElement pay_success;
	@FindBy(xpath="//button[contains(text(),'Failure')]") public WebElement pay_failure;
	@FindBy(xpath="//*[contains(text(),'Payment status')]") public WebElement payment_status;
	@FindBy(xpath="(//*[contains(text(),'Payment status')]/following::div/div/label)[1]") public WebElement payment_status_text;
	@FindBy(xpath="//*[contains(text(),'AMOUNT')]/following::div[2]") public WebElement bill_amount_paid;
	@FindBy(xpath="(//*[contains(text(),'Consumer Name')]/following-sibling::*)[1]") public WebElement consumer_name;
	@FindBy(xpath="(//*[contains(text(), 'Mobile Prepaid')])") public WebElement mob_pr_header;
	@FindBy(xpath="//*[contains(text(), 'Mobile Number')]") public WebElement mobile_number;
	@FindBy(xpath="//*[contains(text(), 'Mobile Number')]/following::input") public WebElement mobile_number_input;
	@FindBy(xpath="(//*[contains(text(), 'Mobile Prepaid')])") public WebElement mob_pr_header_plan_pg;
	@FindBy(xpath="(//*[contains(text(), 'Mobile Prepaid')]/following::div/p)[1]") public WebElement mobile_num_plan_pg;
	@FindBy(xpath="(//*[contains(text(), 'Mobile Prepaid')]/following::div/p)[2]") public WebElement mobile_num_operator_pg;
	@FindBy(xpath="//*[contains(text(), 'Change Operator')]/../../..//*[contains(text(), 'Amount')]") public WebElement prepaid_Amount;
	@FindBy(xpath="//*[contains(text(), 'Change Operator')]/../../..//*[contains(text(), 'Amount')]/following::input") public WebElement mobile_num_inp_plan_pg;
	@FindBy(xpath="(//*[contains(text(), 'RECOMMENDED')]/following::div)[1]") public WebElement mobile_numplan_detail_pg;
	@FindBy(xpath = "//*[contains(text(),'Plan does not exist')]") public WebElement amtError;
	@FindBy(xpath="(//*[contains(text(),'Close')])[2]") public WebElement close_button_payment_page;
	
	//17nov//
	@FindBy(xpath="//*[contains(text(),'Due') and @color]/../ancestor::section") public List<WebElement> due_bills_list;
	@FindBy(xpath="//div[text()='View']") public List<WebElement> view_details_list;
	@FindBy(xpath="//*[contains(text(),'Due on')]/following-sibling::label") public List<WebElement> due_on_list;
	@FindBy(xpath="//*[contains(text(),'Hide')]") public WebElement hide_list;
	@FindBy(xpath="//*[contains(text(),'Due')]/../ancestor::section//*[@id='amount-div']") public List<WebElement> due_amount_list;
	@FindBy(xpath="//*[contains(text(),'Due') and @color='#fcd177']/../ancestor::section//*[@id='filter']") public List<WebElement> checkbox_list1;
	@FindBy(xpath="//*[contains(text(),'Due')]/../ancestor::section//*[@id='check-button-unchecked-b'] | //*[contains(text(),'Overdue')]/../ancestor::section//*[@id='check-button-unchecked-b']") public List<WebElement> checkbox_list;
	@FindBy(xpath="//*[text()='Consumer Name']/following-sibling::label[contains(text(),*)]") public List<WebElement> consumerName_txt;
	@FindBy(xpath="//*[text()='Bill No']/following-sibling::*[contains(text(),*)]") public List<WebElement> billNo_txt;
	@FindBy(xpath="//*[text()='Bill Date']/following-sibling::*[contains(text(),*)]") public List<WebElement> billDate_txt;
	@FindBy(xpath="//*[text()='Due on']/following-sibling::*[contains(text(),*)]") public List<WebElement> billDueOn_txt;
	@FindBy(xpath="//input[@type='text'][@id='amount-div']") public List<WebElement> amount_onBillDtlsTab_txt;
	@FindBy(xpath="//*[contains(text(),'convenience fee')]") public List<WebElement> convenienceFee_onBillDtlsTab_txt;
	@FindBy(xpath="//*[contains(text(),'Bill No')]/following-sibling::label") public List<WebElement> consumer_bill_no_overdue;
	@FindBy(xpath="//*[contains(text(),'Bill Date')]/following-sibling::label") public List<WebElement> bill_date_overdue;
	@FindBy(xpath="//*[contains(text(),'convenience')]") public List<WebElement> convenience_fee_msg_overdue;
	
	/*
	 * due bill
	 * allias:- //*[contains(text(),'Due')]/../../div/label[contains(text(),*)][1]/../
	 * preceding-sibling::div/div/label[1]
	 */
	
	/*
	 * customer
	 * no:-//*[contains(text(),'Due')]/../../div/label[contains(text(),*)][1]/../
	 * preceding-sibling::div/div/label[2]
	 */	
	
	@FindBy(xpath = "//*[contains(text(),'Paid on')]/../../div/label[contains(text(),*)][1]/../preceding-sibling::div/div/label[1] | //*[contains(text(),'Due')]/../following-sibling::*/div[1]/div[1]/div[3]/label[1]") public List<WebElement> aliasName_onBillDtls_txt;
	@FindBy(xpath = "//*[contains(text(),'Paid on')]/../../div/label[contains(text(),*)][1]/../preceding-sibling::div/div/label[2] | //*[contains(text(),'Due')]/../following-sibling::*/div[1]/div[1]/div[3]/label[2]") public List<WebElement> customerAuthNo_onBillDtls_txt;

  //19nov//
	@FindBy(xpath="//*[contains(text(), 'Payment Paid')]") public List<WebElement> paid_success_list;
	@FindBy(xpath="//*[contains(text(), 'Payment Failed')]") public List<WebElement> paid_failure_list;
	@FindBy(xpath="//*[contains(text(), 'Payment Paid')]/following::div[6]/div/label[(text()= 'Transaction ID')]/following-sibling::label") public List<WebElement> transaction_id_list;
	@FindBy(xpath="//*[contains(text(), 'Payment Paid')]/following::div[6]/div/label[(text()= 'BBPS Transaction ID')]/following-sibling::label") public List<WebElement> BBPS_transaction_id_list;
	@FindBy(xpath="//*[contains(text(), 'Payment Failed')]/following::div[6]/div/label[(text()= 'Transaction ID')]/following-sibling::label") public List<WebElement> transaction_id_list_failure;
	@FindBy(xpath="//*[contains(text(), 'Payment Failed')]/following::div[6]/div/label[(text()= 'BBPS Transaction ID')]/following-sibling::label") public WebElement BBPS_transaction_id_failure;

	
	
	//23nov//
	@FindBy(xpath="//*[contains(text(),'Operator Not Selected')]") public WebElement operator_sel_prepaid;
	@FindBy(xpath="//*[contains(text(),'Operator Not Selected')]/following::p") public WebElement change_operator_prepaid;
	@FindBy(xpath="//*[contains(text(), 'Mobile Prepaid')]/following::input") public WebElement select_operator_prepaid;
	@FindBy(xpath="(//*[contains(text(), 'RECOMMENDED')]/following::div/label[(text()= 'SELECT')])[1]") public WebElement select_plan_first_prepaid;
	@FindBy(xpath="//*[contains(text(), 'Change Operator')]") public WebElement change_operator_plan_pg_prepaid;
	@FindBy(xpath="//*[contains(text(), 'Invoice')]") public WebElement Invoice_pg;
	@FindBy(xpath="//*[contains(text(), 'Invoice')]/following::div/div/div/span[contains(text(), 'Order')]") public WebElement Invoice_pg_order;
	@FindBy(xpath="//*[contains(text(), 'Invoice')]/following::div/div/div/span[2] | //*[contains(text(), 'Invoice')]/following::div/div/div/span[1]/following-sibling::*") public WebElement Invoice_pg_time;
	@FindBy(xpath="//*[contains(text(), 'Invoice')]/../following::div/span/div[2]/div") public List<WebElement> Invoice_list;
	@FindBy(xpath="//*[contains(text(), 'Net Checkout Amount')]/following::span/div | //*[contains(text(), 'NET CHECKOUT AMOUNT')]/following::span/div | //*[contains(text(), 'amount')]/following::span/div") public WebElement net_check_amount;
	@FindBy(xpath="//button[contains(text(), 'Pay')]") public WebElement invoice_pay_button;

	//24nov//
	@FindBy(xpath="(//*[contains(text(), 'Mobile postpaid')])") public WebElement Postpaid_hdr;
	@FindBy(xpath="//*[contains(text(), 'Mobile number')] | //label[contains(text(),'Mobile number')]") public WebElement mobile_number_post;
	@FindBy(xpath="//*[contains(text(), 'Mobile number')]/following::input | //label[contains(text(),'Mobile number')]/following::input") public WebElement mobile_number_input_post;
	@FindBy(xpath="//*[contains(text(), 'Technical processing error at the biller')] |  //*[contains(text(), 'There was an error')]") public WebElement error_post;
	@FindBy(xpath=" //*[contains(text(), 'Change Operator')]") public WebElement change_Operator_post;
	
	@FindBy(xpath=" //*[contains(text(),'Amount')]/following::div[2]/div[2]") public List<WebElement> saveas_options;

	@FindBy(xpath="(//*[contains(text(),'Amount')]/following::div/div)[1]") public WebElement saveas_field;
	@FindBy(xpath="//*[contains(text(), 'Close')]") public WebElement closeBtn_Android;
	
	
	
	//Recent tab validation
	@FindBy(xpath="//*[contains(text(),'Add New Bill')]/../following-sibling::section/div[3]") public List<WebElement> billsDueTab;
	@FindBy(xpath="//*[contains(text(),'Add New Bill')]/../following-sibling::section/div[3]") public List<WebElement> viewDetail_link;
	
	@FindBy(xpath="//*[contains(text(),'Paid')]/../ancestor::section//*[@id='amount-div']") public List<WebElement> paid_Amount;
	@FindBy(xpath="//*[contains(text(),'Paid')]/../ancestor::section") public List<WebElement> paid_bill_list;
	@FindBy(xpath="//*[contains(text(),'Paid')]/../ancestor::section/div[3]") public List<WebElement> view_detail_Paid;
	@FindBy(xpath="//*[contains(text(),'Paid')]/../ancestor::section/div/div[2]/label[2]") public List<WebElement> paidOnDate;
	@FindBy(xpath="//*[contains(text(),'Paid')]/../ancestor::section/div/div[1]/div/label[1]") public List<WebElement> paidConsumer;
	@FindBy(xpath="//*[contains(text(),'Paid')]/../ancestor::section/div/div[1]/div/label[2]") public List<WebElement> paidConsumerNumber;
	
	//Billers Tab
	@FindBy(xpath="//*[contains(text(),'Billers')]") public WebElement billersTab;
	@FindBy(xpath="//*[contains(text(),'Billers')]/../../section") public List<WebElement> bills_BillersTab;
	@FindBy(xpath="//*[contains(text(),'Billers')]/../../section[1]") public WebElement biller_firstsection;
	@FindBy(xpath="//*[contains(text(),'Billers')]/../../section[1]/div//label[1]") public WebElement biller_ConsumerName;
	@FindBy(xpath="//*[contains(text(),'Bills History')]") public WebElement billersTab_billhistory;
	@FindBy(xpath="//*[contains(text(),'Bills History')]/../../preceding-sibling::div[1]/div[2]/label[1]") public WebElement billername_firstsection;
	@FindBy(xpath="//*[contains(text(),'Bills History')]/../../preceding-sibling::div[1]/div[2]/label[2]") public WebElement billerNumber_firstsection;
	@FindBy(xpath="//*[contains(text(),'Bills History')]/..//*[contains(text(),'View')]") public List<WebElement> biller_ViewDetails;
	@FindBy(xpath="//*[contains(text(),'Bills History')]/following-sibling::section/div/label[1]") public WebElement biller_AmountPaid;
	@FindBy(xpath="//*[contains(text(),'Bills History')]/following-sibling::section/div/label[1]/label") public WebElement biller_PaidDate;
	@FindBy(xpath="//*[contains(text(),'Hide')]") public WebElement HideDetails;

	//prepaid opertor and circle
	@FindBy(xpath="(//*[contains(text(), 'Operator')])[1]") public WebElement prepaidOperator;
	@FindBy(xpath="//*[contains(text(), 'Circle')]") public WebElement prepaidCircle;


	//Retry popup for transaction failed
	@FindBy(xpath="(//*[contains(text(),'Payment failed')])[2]") public WebElement paymentfailed_popup;
	@FindBy(xpath="(//*[contains(text(),'Close')])") public WebElement close_pwa;
	@FindBy(xpath="(//*[contains(text(),'Retry')])") public WebElement retry_pwa;
	
	//homepage paybill navigation
	
	@FindBy(xpath="(//*[@id='homepage_tour_step_6'])[1]") public WebElement Vault_pwa;
	@FindBy(xpath="//*[contains(text(),'Pay Bills')]") public WebElement paybill_Vault;
	@FindBy(xpath="//*[@id='homepage_tour_step_8']/div/div[3]/div") public WebElement paybill_home;
	@FindBy(xpath="//*[contains(text(),'Pay bills')] | //*[contains(text(),'Pay Bills')]") public WebElement btnpaybill;
	@FindBy(xpath="//label[text()='Tata Pay'] | (//label[text()='Tata Pay'])[2]") public WebElement TataPaybtn;
	@FindBy(xpath="//h4[text()='Cards']") public WebElement cardsection;
	@FindBy(xpath="//div[text()='Pay all your bills in one shot']") public WebElement vaulttopaybill;
	
	//Pwa Mobile
	@FindBy(xpath="//*[@id='modal-close-button']/following::input") public WebElement SearchFieldBillers;
	@FindBy(xpath="(//*[@id='billpay-topbar-back']//following::label)[1]") public WebElement selectStateHdr;
	
	@FindBy(xpath="//*[contains(text(),'Board')] | //*[contains(text(),'Operator')] | //*[contains(text(),'State')]") public WebElement selectBoardHdr;
	
	@FindBy(xpath="//*[@id='billpay-bill-amount-input']/preceding::*[text()='Bill Date']") public WebElement bill_dateMobile;
	@FindBy(xpath="//*[@id='billpay-bill-amount-input']/preceding::*[text()='Due Date']") public WebElement due_dateMobile;
	@FindBy(xpath="//*[@id='billpay-bill-amount-input']/preceding::*[text()='Bill No']") public WebElement bill_NoMobile;
	@FindBy(xpath="//*[@id='billpay-bill-amount-input']/preceding::*[text()='Consumer Name']") public WebElement consumer_NameMobile;

	//tata sky
	
			@FindBy(xpath="//*[contains(text(), 'View More')]") public WebElement tataSkyViewMore_pwa;
			@FindBy(xpath="(//*[contains(text(), 'Tata Sky Classic Cinema')]//following::*[text()='Add'])[1]") public WebElement tataSkypackAdd_pwa;
			@FindBy(xpath="(//*[contains(text(), 'Tata Sky Classic Cinema')])[1]") public WebElement tataSkyPack_pwa;
			@FindBy(xpath="(//*[contains(text(), 'Share the OTP')]//following::*)[2]") public WebElement tataSkyOtp;
			@FindBy(xpath="//*[contains(text(), 'SUCCESS')]") public WebElement tataSkypurchaseSuccess;
			@FindBy(xpath="(//*[contains(text(), 'Share the OTP')]//following::*)[2]/input[1]") public WebElement inputOtp_first;
			@FindBy(xpath="(//*[contains(text(), 'Share the OTP')]//following::*)[2]/input[2]") public WebElement inputOtp_second;
			@FindBy(xpath="(//*[contains(text(), 'Share the OTP')]//following::*)[2]/input[3]") public WebElement inputOtp_third;
			@FindBy(xpath="(//*[contains(text(), 'Share the OTP')]//following::*)[2]/input[4]") public WebElement inputOtp_fourth;
			@FindBy(xpath="(//*[contains(text(), 'Share the OTP')]//following::*)[2]/input[5]") public WebElement inputOtp_fifth;
			@FindBy(xpath="(//*[contains(text(), 'Share the OTP')]//following::*)[2]/input[6]") public WebElement inputOtp_six;
			
			@FindBy(xpath="//*[contains(text(), 'Submit')]") public WebElement submitOTP;
			@FindBy(xpath="//*[contains(text(),'utility bills')]") public WebElement hdrbillPayment;
			@FindBy(xpath="//*[contains(text(),'Upi')]") public WebElement txtUpi;
			@FindBy(xpath="//*[@data-testid='handle-payments']") public WebElement btnChange;
			@FindBy(xpath="//*[text()='Cancel']") public WebElement btnCancel;
			
	//Souvik	
			@FindBy(xpath="(//*[contains(text(),'All bills')])[1]") public WebElement tabAllBills;
			@FindBy(xpath="//*[contains(text(),'Due bills')]") public WebElement tabDueBills;
			@FindBy(xpath="(//*[@id='filter'])[1]") public WebElement clickcheckbox;
			@FindBy(xpath="(//button[text()='Next'])[2]") public WebElement Nextbtn;
			@FindBy(xpath="//*[@id='otpForm'] | //input[@placeholder='CVV']") public WebElement enter_OTP;
			@FindBy(xpath="//*[contains(text(),'Submit')]") public WebElement Submitbtn;
			@FindBy(xpath="//*[contains(text(),'Proceed')] | //*[contains(text(),'Proceed to pay')]") public WebElement Proceedbtn;
			@FindBy(xpath="(//*[contains(text(),'Self')])[8]") public WebElement addlabel;
			
			@FindBy(xpath="//*[@id='billpay-mobile-prepaid-number-input']") public WebElement mobNumber;
			@FindBy(xpath="//*[contains(text(),'Add bill to cart')]") public WebElement addtocartbtn;
			@FindBy(xpath="//*[text()='Debit card'] | //*[text()='Credit card']") public WebElement debitcreditcardname;
			@FindBy(xpath="//*[@id='billpay-bill-amount-input']") public WebElement billAmount;
			@FindBy(xpath="//label[contains(text(),'Change')]") public WebElement changebtn;
			
			@FindBy(xpath="//label[text()='Bills in your cart']") public WebElement cart_header;
			@FindBy(xpath="//button[text()='Add more bills']") public WebElement add_more_bills;
			@FindBy(xpath="//label[text()='Pay utility bills']") public WebElement paybills_header;
			@FindBy(xpath="//label[text()='DTH']") public WebElement DTH_option;
			@FindBy(xpath="//div[text()='Dish TV']") public WebElement Dish_TV;
			@FindBy(xpath="//label[text()='Amount']") public WebElement Amount_field;
			@FindBy(xpath="//input[@name='billpay-customer-number-input-1']") public WebElement Amount_field_amount;
			@FindBy(xpath="//button[text()='Add bill to cart']") public WebElement Add_bill_cart;
			@FindBy(xpath="(//*[local-name()='svg'])[39]") public WebElement crossbtn;
			@FindBy(xpath="//label[contains(text(),'Mobile prepaid')] | //label[contains(text(),'Mobile postpaid')]") public WebElement MobilePrePostpaid;
			@FindBy(xpath="//div[@data-category-name='FASTag']") public WebElement FASTag;
			@FindBy(xpath="//label[text()='FASTag bank']/following::input") public WebElement FASTagBnak;
			
			
			
}
