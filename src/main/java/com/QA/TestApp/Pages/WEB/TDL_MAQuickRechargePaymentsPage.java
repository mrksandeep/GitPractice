package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MAQuickRechargePaymentsPage {
	
	@FindBy(xpath="//*[contains(text(),'Enter Debit / Credit Card Details')]") public WebElement creditdebitheadercheck;
    @FindBy(xpath="//input[@placeholder='Enter card number here']") public WebElement entercardnumber;
	@FindBy(xpath="//input[@placeholder='MM / YY']") public WebElement expirymonth;
	@FindBy(xpath="//input[@placeholder='CVV']") public WebElement cvv;
	@FindBy(xpath="//*[contains(text(),'Proceed to pay')]") public WebElement proceedtopay;
	@FindBy(xpath="//*[contains(text(),'Netbanking')]") public WebElement netbanking;
	@FindBy(xpath="//*[contains(text(),'Axis')]") public WebElement axisbank;
	@FindBy(xpath="//*[contains(text(),'HDFC')]") public WebElement hdfcbank;
	@FindBy(xpath="//*[contains(text(),'ICICI')]") public WebElement icicibank;
	@FindBy(xpath="//*[contains(text(),'SBI')]") public WebElement sbibank;
	



	
	
    




	


}
