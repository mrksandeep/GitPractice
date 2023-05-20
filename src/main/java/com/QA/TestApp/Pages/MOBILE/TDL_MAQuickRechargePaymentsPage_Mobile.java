package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MAQuickRechargePaymentsPage_Mobile {
	
	@FindBy(xpath="//input[@placeholder='Enter card number here']") public WebElement entercardnumber;
	@FindBy(xpath="//input[@placeholder='MM / YY']") public WebElement expirymonth;
	@FindBy(xpath="//input[@placeholder='CVV']") public WebElement cvv;
	@FindBy(xpath="//*[contains(text(),'Proceed to pay')]") public WebElement proceedtopay;
	@FindBy(xpath="//*[contains(text(),'Netbanking')]") public WebElement netbanking;

	
	
    




	


}
