package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.QA.TestApp.Utilities.BaseScript;

public class NCOM_Electronics_CLP_Web extends BaseScript {

@FindBy(xpath="//button[contains(text(),'Checkout')]") public WebElement checkOutBtn;
@FindBy(xpath="//button[contains(text(),'Proceed to payment')]") public WebElement proceedToPayBtn;



}