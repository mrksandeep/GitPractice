package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MASelectlanguagesPage {
	@FindBy(xpath="//*[contains(text(),'English')]") public WebElement english;
    @FindBy(xpath="//*[contains(text(),'Hindi')]") public WebElement hindi;
    @FindBy(xpath="//*[contains(text(),'Marathi')]") public WebElement marathi;
    @FindBy(xpath="//*[contains(text(),'Punjabi')]") public WebElement punjabi;
    @FindBy(xpath="//*[contains(text(),'Gujarati')]") public WebElement gujarati;
    @FindBy(xpath="//*[contains(text(),'Bengali')]") public WebElement bengali;
    @FindBy(xpath="//*[contains(text(),'Odia')]") public WebElement odia;
    @FindBy(xpath="//*[contains(text(),'Tamil')]") public WebElement tamil;
    @FindBy(xpath="//*[contains(text(),'Telugu')]") public WebElement telugu;
    @FindBy(xpath="//*[contains(text(),'Kannada')]") public WebElement kannada;
    @FindBy(xpath="//*[contains(text(),'Malayalam')]") public WebElement malayalam;
    @FindBy(xpath="//*[contains(text(),'Others')]") public WebElement others;
    @FindBy(xpath="//*[contains(text(),'Continue')]") public WebElement continuebtn;


}
