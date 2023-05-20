package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class PaymentCards {
	@FindBy(xpath = "//button[contains(text(),'Excel')]") public WebElement exelBtn;
	@FindBy(xpath="//button[contains(text(),'PDF')]") public WebElement pdfBtn;
	@FindAll({@FindBy(xpath="//*[contains(@class,'sc-pRSgm gCfQr')]")}) public List<WebElement> statementDownloadCondition;
	@FindBy(xpath = "//input[@name='fromDate']") public WebElement startDate;
	@FindBy(xpath="//input[@name='toDate']") public WebElement endDate;
	@FindBy(xpath="//span[contains(text(),'Please enter')]") public WebElement dateErrormsg;
	@FindAll({@FindBy(xpath="//*[contains(text(),'Please enter')]")}) public List<WebElement> allError;
	@FindBy(xpath="//*[contains(text(),'Start Date ')]") public WebElement dateErrormsg2;
	@FindBy(xpath="//*[contains(text(),'Selected date ')]") public WebElement dateErrormsg3;
	@FindBy(xpath="//*[@data-testid='close-icon']") public WebElement closepage;
	@FindBy(xpath="//*[contains(@data-testid,'delete-card-icon')]") public WebElement deleteCard;
	@FindBy(xpath="//button[contains(text(),'Confirm')]") public WebElement deleteConfirmBtn;
	@FindAll({@FindBy(xpath="//*[contains(@d,'M-2-2h24v24H-2z')]")}) public List<WebElement> statementDownloadConditionPWA;
	@FindBy(xpath = "//div[contains(text(),'Year')]") public WebElement datepickerYearTab;
	@FindBy(xpath = "//div[contains(text(),'Month')]") public WebElement datepickerMonthTab;
	@FindBy(xpath = "//div[contains(text(),'Date')]") public WebElement datepickerDateTab;
	@FindAll({@FindBy(xpath="//div[contains(@aria-label,'year')]")}) public List<WebElement> allYearlist;
	@FindBy(xpath = "//html/body/div[4]/div/div/div/div[2]/div[2]/section/section[1]/div/div[1]") public WebElement yearTabFirstYear;
	@FindBy(xpath = "//html/body/div[4]/div/div/div/div[2]/div[2]/section/section[1]/div/div[12]") public WebElement yearTabLastYear;
	@FindBy(xpath = "//*[@id='date-left-icon']") public WebElement previousYearPageBtn;
	@FindBy(xpath = "//button[@id='date-right-icon']") public WebElement nextYearPageBtn;
	@FindBy(xpath = "//html/body/div[4]/div/div/div/div[1]/label") public WebElement fullDateDatePickerModal;
	@FindBy(xpath = "//*[@id='Jan']/span") public WebElement monthTabFirstMonth;
	
	
	

	@FindBy(xpath = "//*[contains(text(),'Order history')]") public WebElement OrderHistory;
	@FindBy(xpath = "(//*[contains(text(),'Description')]/../following::span/div)[2]") public WebElement P2P;
	@FindBy(xpath = "//*[contains(text(),'Talk to us')]") public WebElement Talk_to_us;
	@FindBy(xpath = "//*[@class='chat-container shadow-box']") public WebElement chatbox;
	

	@FindBy(xpath = "(//*[contains(text(),'Order ID')]/following::span)[1]") public WebElement OrderID;
	@FindBy(xpath = "//*[contains(text(),'Purchase Date & Time')]/following::div[2]/span") public WebElement Purchase_Date_time;
	@FindBy(xpath = "(//*[contains(text(),'Payment Details')]/following::p)[1]") public WebElement Payment_details;
	@FindBy(xpath = "(//*[contains(text(),'ITEM DESCRIPTION')]/following::div/p)[1]") public WebElement Item_description;
	@FindBy(xpath = "//*[contains(text(),'QUANTITY')]/following::div/p[2]") public WebElement Item_Quantity;
	@FindBy(xpath = "(//*[contains(text(),'AMOUNT')]/following::div/span)[1]") public WebElement Item_Amount;
	@FindBy(xpath = "//*[contains(text(),'TXN ID: ')]") public WebElement TXN_ID ;
	@FindBy(xpath = "(//*[contains(text(),'TXN ID: ')]/following::div)[1]") public WebElement credit_card;
	@FindBy(xpath = "//*[contains(text(),'Order Details')]") public WebElement Order_details;
	
	@FindBy(xpath = "(//*[contains(text(),'Failed')])[1]") public WebElement Failure_transaction_text;
	@FindBy(xpath = "//*[contains(text(),'Change')]") public WebElement change_button;
	@FindBy(xpath = "//*[contains(text(),'Use Other UPI')]") public WebElement other_upi_option;
	@FindBy(xpath = "//*[@for='defaultVPA']") public WebElement upi_option;
	@FindBy(xpath = "//*[@data-event='TataPay : Payment : OnPay']") public WebElement pay_button;
	@FindBy(xpath = "(//*[contains(text(),'Pending - transaction initiated')])[1]") public WebElement aborted_pending_transaction_text;
	@FindBy(xpath = "(//*[contains(text(),'Failure - Timeout')])[2]") public WebElement aborted_failed_transaction_text;
	@FindBy(xpath = "//*[@mask='url(#check-button-unchecked-b)']") public WebElement loyalty_check_box;
	@FindBy(xpath = "//*[contains(text(),'Edit')]") public WebElement loyalty_edit_box;
	@FindBy(xpath = "//*[@id='loyaltyPointstxt']") public WebElement loyalty_Point_text_box;
	@FindBy(xpath = "(//*[contains(text(),'Confirm')])[1]") public WebElement loyalty_Point_confirm_button;
	@FindBy(xpath = "//*[@class='style__BackIcon-gbyLkD hQPvPJ']") public WebElement back_button_order_history_page;
	@FindBy(xpath = "//*[@for='defaultVPA']") public WebElement retry_button_for_Failed_transaction;
	@FindBy(xpath = "//*[contains(text(),'Back to homepage')]") public WebElement gotoHomepage;
	@FindBy(xpath = "//*[@data-testid='data-div-container']/div[1]/div/div[1]") public WebElement first_order_message_payment_page;
	@FindBy(xpath = "(//*[contains(text(),'Failure - Reversed')])[1]") public WebElement aborted_failed_reversed_transaction_text;
	
}
