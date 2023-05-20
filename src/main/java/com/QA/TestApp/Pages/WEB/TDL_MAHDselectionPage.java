package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MAHDselectionPage {
	@FindBy(xpath="//*[contains(text(),'Yes')]") public WebElement yesbtn;
	@FindBy(xpath="//*[contains(text(),'No')]") public WebElement nobtn;
	@FindBy(xpath="(//*[contains(text(),'Get this')])[2]") public WebElement getthisbtn;
	@FindBy(xpath="(//*[contains(text(),'Get This Pack')])[2]") public WebElement getthispackbtn;
	@FindBy(xpath="//*[contains(text(),'Pay Online')]") public WebElement payonlinebtn;
	@FindBy(xpath="//h2[contains(text(),'Select the set top box and proceed')]") public WebElement selectsettopboxheader;
	@FindBy(xpath="//h2[contains(text(),'View your selections & total cost')]") public WebElement selectpaymentoptionheader;


}
