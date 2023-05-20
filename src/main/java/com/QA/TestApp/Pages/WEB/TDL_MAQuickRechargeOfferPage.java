package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MAQuickRechargeOfferPage {
    @FindBy(xpath="//button[text()='Skip Offer & Continue']")public WebElement skipcontinuebtn;
    @FindBy(xpath="//button[text()='Get This Offer']")public WebElement getthisoffer;
    @FindBy(xpath="//h1[text()='Tata Sky Cashback Offers']")public WebElement offerspageheader;


}
