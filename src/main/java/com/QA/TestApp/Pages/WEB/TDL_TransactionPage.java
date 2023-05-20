package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TDL_TransactionPage {
	
		@FindBy(xpath = "//*[contains(text(),'Invoice')]") public WebElement invoiceHdr;
		@FindBy(xpath = "//*[contains(text(),'Croma')]") public WebElement cromaHdr;
		@FindBy(xpath = "//*[contains(text(),'Test item')]") public List<WebElement> items;
		
		@FindBy(xpath = "(//*[contains(text(),'NET CHECKOUT')]/../following::*)/div") public WebElement netAmount;
		@FindBy(xpath = "//button[contains(text(),'Pay')]") public WebElement payBtn;
		
		//payment page
		
		@FindBy(xpath = "(//*[contains(text(),'Payments')])[1]") public WebElement paymentHdr;
		@FindBy(xpath = "(//*[contains(text(),'TOTAL AMOUNT')])[1]/following-sibling::*") public WebElement payAmount;
		@FindBy(xpath = "//*[contains(text(),'Tata Credit Line')]") public WebElement creditLineMode;
		@FindBy(xpath = "//*[contains(text(),'Tata Credit Line')]/../span/div") public WebElement creditlineLimit;
		@FindBy(xpath = "//*[contains(text(),'Tata Credit Line')]/..//[@id='check-button-unchecked-b']/following-sibling::*") public WebElement creditLineCheckbox;

		//credit line page
		@FindBy(xpath = "//*[contains(text(),'Tata Credit Line')]") public WebElement creditLineHdr;
		@FindBy(xpath = "//*[text()='PAYMENT METHODS']") public WebElement paymentmethodHdr;
		@FindBy(xpath = "(//*[@id='check-button-unchecked-a'])[2]") public WebElement Emiclick;
		@FindBy(xpath = "//*[contains(text(),'EMI Option')]") public WebElement emiOptHdr;
		@FindBy(xpath = "//*[contains(text(),'Choose EMI options')]") public WebElement eightEMI;
		@FindBy(xpath = "//*[contains(text(),'Choose EMI options')]") public WebElement nineEMI;
		@FindBy(xpath = "//*[contains(text(),'Choose EMI options')]") public WebElement tenEMI;
		@FindBy(xpath = "//*[contains(text(),'Choose EMI options')]") public WebElement elevenEMI;
		@FindBy(xpath = "//*[contains(text(),'Choose EMI options')]") public WebElement twelveEMI;
		@FindBy(xpath = "//*[contains(text(),'Done')]") public WebElement doneBtn;
		
		//OTP popup
		
		@FindBy(xpath = "//*[contains(text(),'Enter OTP')]") public WebElement otpHdr;
		@FindBy(xpath = "//*[contains(text(),'Choose EMI options')]") public WebElement otpBox;
		@FindBy(xpath = "//*[contains(text(),'Submit')]") public WebElement submitBtn;
		
		
}


