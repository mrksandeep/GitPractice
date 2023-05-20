package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MAPaymentConnectionPage {
	@FindBy(xpath="//h2[contains(text(),'Enter your address')]") public WebElement addressheader;
    @FindBy(xpath="//div[@class='css-10nd86i']") public WebElement areadropdown;
    @FindBy(xpath="(//input[@class='form-control'])[1]") public WebElement address;
    @FindBy(xpath="(//input[@class='form-control'])[2]") public WebElement landmark;
    @FindBy(xpath="//*[contains(text(),'Continue')]") public WebElement continuebtn;



}
