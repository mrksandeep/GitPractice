package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MAQuickRechargeHomePage_Mobile {

    @FindBy(xpath="//*[@id='back_button1']") public WebElement backbtn;
    @FindBy(xpath="//input[@id='subscriberId']") public WebElement subscriberId;
    @FindBy(xpath="(//*[@id=\"amount\"])[1]") public WebElement amount;
    @FindBy(xpath="//*[@id=\"submitRecharge\"]") public WebElement rechargenow;

    @FindBy(xpath="//*[contains(@class,'radio-button connection-selection')]") public WebElement listsubscriberids;
    @FindBy(xpath="(//*[contains(@class,'card-body')])[1]") public WebElement selectsubscriberid;
    @FindBy(xpath="//button[@type='submit']") public WebElement proceedtopaybtn;
    
    
    // Showcase elements //
    
    @FindBy(xpath="//div[@role='radiogroup']") public WebElement lstsubscriberids;
    @FindBy(xpath="//input[@type='radio']") public WebElement selectid;
    @FindBy(xpath="//*[contains(text(),'Continue')]")public WebElement continuebtn;


    
    


}
