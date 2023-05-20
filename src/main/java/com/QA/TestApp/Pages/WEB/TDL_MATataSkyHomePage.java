package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MATataSkyHomePage {
    @FindBy(xpath="//*[contains(text(),'New Connection')]") public WebElement newconnection;
	@FindBy(xpath="//*[contains(text(),'Box Upgrade')]")public WebElement boxupgrade;
	@FindBy(xpath="//*[contains(text(),'Quick Recharge')]")public WebElement quickrecharge;
	@FindBy(xpath="//*[contains(text(),'Showcase')]")public WebElement showcase;
	@FindBy(xpath="//*[@title='Logo']")public WebElement tataSkyLogo;
	@FindBy(xpath="//*[@id='firstName']") public WebElement firstNameTextBox;
	@FindBy(xpath="//*[@id='lastName']") public WebElement lastNameTextBox;

}
