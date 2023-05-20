package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MAOPELPaymentsPage {
	
	@FindBy(xpath="//a[contains(@class,'pcdc')]") public WebElement opelpayment;
    @FindBy(xpath="//*[contains(text(),'Enter Debit / Credit Card Details')]") public WebElement creditdebitheadercheck;
    @FindBy(xpath="//input[contains(@placeholder,'Enter card number here')]") public WebElement entercardnumber;
	//@FindBy(xpath="//*[@id='987654321']") public WebElement entercardnumber;

    @FindBy(xpath="//input[@placeholder='MM / YY']") public WebElement expirymonth;
	@FindBy(xpath="//input[@placeholder='CVV'][@class='editText'] | //input[@placeholder='CVV'][@class='editText ']") public WebElement cvv;
	@FindBy(xpath="//*[contains(text(),'Save this card for faster payments')]/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div[2]//*[contains(text(),'Proceed to pay')]") public WebElement proceedtopay;
	@FindBy(name="password") public WebElement otp;
	@FindBy(id="submitBtn") public WebElement submit;
	@FindBy(xpath="//*[contains(text(),'Netbanking')]") public WebElement netbanking;
	@FindBy(xpath="//*[contains(text(),'Axis')]") public WebElement axisbank;
	@FindBy(xpath="//*[contains(text(),'HDFC')]") public WebElement hdfcbank;
	@FindBy(xpath="//*[contains(text(),'ICICI')]") public WebElement icicibank;
	@FindBy(xpath="//*[contains(text(),'SBI')]") public WebElement sbibank;
	@FindBy(xpath="//*[contains(text(),'Credit / Debit Card')]") public WebElement creditDebitCard;
	@FindBy(xpath="//*[contains(text(),'Add new card')]") public WebElement addNewCard;
	@FindBy(xpath="//*[contains(text(),'Save this card for faster payments')]") public WebElement saveThisCard;
	@FindBy(xpath="//*[contains(text(),'Billdesk')]") public WebElement billdeskbank;
	
	@FindBy(xpath="//h1[text()='Payment done!']") public WebElement paymentsuccessfullheader;




	
	
    




	


}
