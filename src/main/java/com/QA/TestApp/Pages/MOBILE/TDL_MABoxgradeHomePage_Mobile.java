package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MABoxgradeHomePage_Mobile {
      @FindBy(xpath="//*[@id='modal-close-button']") public WebElement closebtn;
      @FindBy(xpath="//*[contains(text(),'Go to Homepage')]") public WebElement gotohomepage;
      @FindBy(xpath="//div[@role='radiogroup']") public WebElement selectsubscriber;
      @FindBy(xpath="//*[contains(text(),'Continue')]") public WebElement continuebtn;

      // xpaths remaining after continue btn on subscriber id//
}
