package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MABoxgradeHomePage {
      @FindBy(xpath="//*[@id='modal-close-button']") public WebElement closebtn;
      @FindBy(xpath="//*[contains(text(),'Go to Homepage')]") public WebElement gotohomepage;
      @FindBy(xpath="(//input[@type='radio'])[1]") public WebElement selectsubscriber;
      @FindBy(xpath="//*[contains(text(),'Continue')]") public WebElement continuebtn;

      @FindBy(xpath="//span[text()='Subscriber ID:']") public WebElement subscriberidheader;
      @FindBy(xpath="(//a[text()='Get'])[2]") public WebElement getbox;

}
