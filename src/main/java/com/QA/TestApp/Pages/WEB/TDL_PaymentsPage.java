package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_PaymentsPage {
	/*------------invoke-payments page--------------*/
	@FindBy(xpath = "//*[contains(@class,'style__PageTitle-hPcZJK hHIFnR') and contains(text(),'Payments')]") public WebElement paymentHeader;
	@FindBy(xpath = "//input[@placeholder='ORDER ID']") public WebElement orderID;
	@FindBy(xpath = "//input[@placeholder='TCP #']") public WebElement tcp;
	@FindBy(xpath = "//input[@placeholder='CONSUMER']") public WebElement consumer;
	@FindBy(xpath = "//input[@placeholder='AMOUNT']") public WebElement amount;
	@FindBy(xpath = "//input[@placeholder='MERCHANT ID']") public WebElement merchantID;
	@FindBy(xpath = "//input[@placeholder='MERCHANT NAME']") public WebElement merchantName;
	@FindBy(xpath = "//input[@placeholder='TERMINAL ID']") public WebElement terminalID;
	@FindBy(xpath = "//*[contains(text(),'Store')]/parent::select") public WebElement channelSelect;
	@FindBy(xpath = "//*[contains(text(),'Next')]") public WebElement next;
	@FindBy(xpath = "//*[contains(text(), 'CREDIT CARD')]") public WebElement Payment_method;
	@FindBy(xpath="//*[contains(text(), 'Back To Homepage')]") public WebElement Back_To_Homepage;
	@FindBy(xpath="(//*[@href='#'])[3]") public WebElement Complete_Payment_Bank_Page;
	@FindBy(xpath="(//*[contains(text(), 'Change')])[1]") public WebElement Change_Button;
	@FindBy(xpath = "//*[text()='Invoice']") public WebElement invoicePage;
	@FindBy(xpath = "//button[text()='Pay']") public WebElement payBtn;
	@FindBy(xpath = "//p[text()='View All']") public WebElement viewAll;
	@FindBy(xpath ="//h1[text()='Payments']") public WebElement multitender;
	@FindBy(xpath = "(//*[contains(text(), 'Change')])[1]") public WebElement changeBtn;
	@FindBy(xpath="//input[@id='security_code'] | //input[@placeholder='CVV']") public WebElement enter_CVV;
	@FindBy(xpath = "//button[contains(text(), 'Pay')]") public WebElement payfinalBtn;
	@FindBy(xpath = "//*[text()='Sign in with TCP']") public WebElement signInBtn;
	/*---------------order history page--------------------*/
	@FindBy(xpath="(//*[contains(text(),'Description')]/../following::span/div)[1]") public WebElement First_Order;
	@FindBy(xpath="//*[@class='Flex__Box-gYzJRu gaUazz']/div[2]/label[2]") public WebElement Bill_Payment_Trn_ID;
	@FindBy(xpath = "//h1[contains(text(),'My Orders')]") public WebElement myOrderHeader;
	@FindBy(xpath="//*[@id='filter-click'] | //*[contains(text(),'My Orders')]/parent::div/div//*[@fill-rule='evenodd']") public WebElement filterButton;
	@FindBy(xpath="//*[contains(text(),'BY INSTRUMENT')]/following-sibling::div/button[3]") public WebElement byInstrumnentUPIBtns;
	@FindBy(xpath="//*[contains(text(),'TRANSACTION STATUS')]/following-sibling::div/button[1]") public WebElement TransactionStatus_Success;
	@FindBy(xpath="//*[contains(text(),'TRANSACTION STATUS')]/following-sibling::div/button[2]") public WebElement TransactionStatus_Pending;
	@FindBy(xpath="//*[contains(text(),'TRANSACTION STATUS')]/following-sibling::div/button[3]") public WebElement TransactionStatus_Failed;
	@FindBy(xpath="//*[contains(text(),'Apply')]") public WebElement apply;
	@FindBy(xpath = "//*[contains(text(),'Success')]") public List<WebElement> SuccessStatus;
	@FindBy(xpath="//*[@class='sc-jtHMlw jaQVoM']") public WebElement Loyalty_Checkbox;
	@FindBy(xpath="//*[@data-testid='edit-loyalty']") public WebElement Edit_Loyalty_Button;
	@FindBy(xpath="//*[@id='loyaltyPointstxt']") public WebElement Edit_Loyalty_Points_TextBox;
	@FindBy(xpath="//*[@data-testid='Confirm-container']") public WebElement Edit_Loyalty_Confirm_Button;
//	@FindBy(xpath="//*[@class='sc-jlIkXa cUdUkR hide-scroll-bar']/div[3]/div[1]/label[2]") public WebElement Change_Button;
	@FindBy(xpath="//*[@class='sc-dacFzL fIUiIW']/div[4]/div[2]/div[1]/div/div/div/div[1]") public WebElement NetBanking_First_Bank_Button;
	@FindBy(xpath="//*[@onclick='submitSuccessForm()']") public WebElement Success_Message_Button;
	@FindBy(xpath="//*[@onclick='submitFailureForm()']") public WebElement Failure_Message_Button;
	@FindBy(xpath="//*[@data-testid='Total-View-section']/div[2]/span") public WebElement order_status_text;
	@FindBy(xpath="//*[@class='style__AccordianContainer-eUmGds dWoFWD']/div/button") public WebElement payment_dropdown_button;
	@FindBy(xpath="//*[@class='style__AccordianContainer-eUmGds dWoFWD']/div[2]/div/div[1]/h4[1]") public WebElement Payment_Option1_Text;
	@FindBy(xpath="//*[@class='style__AccordianContainer-eUmGds dWoFWD']/div[2]/div/div[2]/span/div/div/h4") public WebElement Payment_Option2_Text;
	
//	@FindBy(xpath="//*[@data-testid='Total-View-section']/div[2]/span") public WebElement retry_option_pwa;
	@FindBy(xpath="//button[contains(text(), 'Close')]") public WebElement close_option_pwa;
	@FindBy(xpath="//div[contains(text(), 'Retry')]") public WebElement retry_option_pwa;
//	@FindBy(xpath="//button[contains(text(), 'Success')]") public WebElement Success_Message_Button;
//	@FindBy(xpath="//button[contains(text(), 'Failure')]") public WebElement Failure_Message_Button;
	
	
	/*---------------payment-first page--------------------*/
	@FindBy(xpath = "//h1[@class='style__PageTitle-hPcZJK hHIFnR']") public WebElement pageHeader;
	@FindBy(xpath = "//span[contains(text(),'New Transaction Request')]/..") public WebElement newTransactionRequest;
	@FindBy(xpath = "//span[contains(text(),'Saved Cards')]/..") public WebElement savedCards;
	@FindBy(xpath = "//span[contains(text(),'Transaction status')]/..") public WebElement transactionStatus;
	@FindBy(xpath = "//div[text()='Other UPI']") public WebElement otherUPI;
	@FindBy(xpath = "//input[@name='otherUPI']") public WebElement otherUPI_InputText;
	@FindBy(xpath = "//label[text()='Verify']") public WebElement verifyButton;
	@FindBy(xpath = "//label[@for='otherUPI']/../span") public WebElement errorTextInvalidUpi;
	@FindBy(xpath = "//*[@id='modal-close-button']") public WebElement modalCloseButton;
	@FindBy(xpath = "//*[contains(text(),'UPI ID verified')]/..//*[@data-testid='handle-submit']") public WebElement upiSubmitButton;
	@FindBy(xpath = "//*[contains(text(),'Quick, approve the payment request before the timer runs out!')]") public WebElement initiate_Upi_collectRequestMessage;
	@FindBy(xpath="(//input[@type='radio'])[1]") public WebElement radioButtonList1;
	@FindBy(xpath="(//input[@type='radio'])[2]") public WebElement radioButtonList2;
	@FindBy(xpath="//div[text()='Tata Pay UPI']") public WebElement TataPayUPI;
	@FindBy(xpath="//div[text()='Tata Pay UPI ID verified!']/../div[2]/div[1]") public WebElement UpiId;
	@FindBy(xpath="//div[text()='Preferred payment mode']/../div[2]/div") public WebElement LastPayment;
	@FindBy(xpath="//button[@id='modal-close-button']") public WebElement cancelbtn;
	@FindBy(xpath="//*[text()='NETBANKING'] | //*[text()='Netbanking']") public WebElement NetBanking_TPM;
	@FindBy(xpath="//div[text()='Preferred payment mode']/../div[2]") public WebElement Paymentmode;
	@FindBy(xpath="//*[normalize-space(text())= 'Payments'] | //*[normalize-space(text())= 'Payment']") public WebElement PAymentMethod_TPM;
	@FindBy(xpath="//div[text()='Preferred payment mode']") public WebElement PreferredPaymentMode;
	@FindBy(xpath="//div[text()='Other modes']") public WebElement OtherPayment;
	@FindBy(xpath="//div[text()='Payment modes']") public WebElement PaymentModes;
	@FindBy(xpath="//input[@placeholder='Enter CVV '] | //input[@name='security_code']") public WebElement Enter_CVV;
	@FindBy(xpath="//button[contains(text(), 'Pay')]") public WebElement invoice_pay_button;
	@FindBy(xpath="//button[text()='Success']") public WebElement Successbtn;
	@FindBy(xpath="//span[text()='NeuCoins']/div") public WebElement loyltypointcalculate_text;
	@FindBy(xpath="//*[contains(text(),'Amount')]/parent::div/following::span[1]") public WebElement paymentPageTotal;
	@FindBy(xpath="//div[contains(text(),'Reference ID: ')]") public WebElement ReferenceID;
	@FindBy(xpath="//p[contains(text(),'Total')]/following-sibling::p") public WebElement TotalAmount;
	@FindBy(xpath="//*[text()='Transaction ID']/following-sibling::span") public WebElement txnID_MTP;
	@FindBy(xpath="//*[text()='Credit and debit cards']") public WebElement cardsSelection;
	@FindBy(xpath="(//*[text()='Debit cards']//following-sibling::div//label/*)[2]") public WebElement HDFCdebitcardRadio;
	@FindBy(xpath="//*[@id='modal-close-button']/following-sibling::div//button[contains(text(), 'Pay')]") public WebElement payBtnnew;
	@FindBy(xpath="//*[text()='Failure']") public WebElement failPayment;
	@FindBy(xpath="//div[@data-testid='Timer-section']/div") public WebElement retrybtn;
	
	
	@FindBy(xpath="//button[text()='Pay ']") public WebElement Loyalty_Points_Pay_Button;
	@FindBy(xpath="(//div[contains(text(),'payment mode')])[1]/../../div[1]/label") public WebElement paymentMode_RadioButton;
	@FindBy(xpath="//*[@id='otherTender']/../label") public WebElement otherModes_RadioButton;
	@FindBy(xpath="//button[contains(text(),'Pay')]") public WebElement payButtonTPM;
	@FindBy(xpath="//input[@id='defaultCard']/following-sibling::label") public WebElement Radiobtnprefferedpayment;
	@FindBy(xpath="//label[text()='Offers applied']") public WebElement OffersApplied;
			
}