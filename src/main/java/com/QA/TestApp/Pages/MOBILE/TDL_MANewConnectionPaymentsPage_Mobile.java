package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MANewConnectionPaymentsPage_Mobile {
	@FindBy(xpath="(//*[@title='Next'])[1]") public WebElement nextbtn;
	@FindBy(xpath="//*[@id='cnumber']") public WebElement entercardnumber;
	@FindBy(xpath="//*[@id='expmon']") public WebElement expirymonth;
	@FindBy(xpath="//*[@id='expyr']") public WebElement expiryyear;
	@FindBy(xpath="//*[@id='cvv2']") public WebElement cvv;
	@FindBy(xpath="//*[@id='cname2']") public WebElement holdername;
	@FindBy(xpath="//*[@id='proceedForm']") public WebElement makepayment;
	@FindBy(xpath="(//*[contains(text(),'Credit Card')])[1]") public WebElement creditcardoption;
    @FindBy(xpath="(//*[contains(text(),'Debit Card')])[1]") public WebElement debitcardoption;
    @FindBy(xpath="(//*[contains(text(),'Internet Banking')])[1]") public WebElement internetbankingoption;
    @FindBy(xpath="//*[@id='ICICINet']") public WebElement icicioption;
    @FindBy(xpath="//*[@id='SBINet]") public WebElement sbioption;

    




	


}
