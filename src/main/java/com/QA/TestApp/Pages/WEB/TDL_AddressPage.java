package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_AddressPage {
	@FindBy(xpath = "//span[@data-index='0']") public WebElement threedotsBtn;
	@FindBy(xpath = "//*[contains(text(),'Edit')]") public WebElement editBtn;
	@FindBy(xpath="//*[contains(text(),'Delete')]") public WebElement deleteBtn;
	@FindBy(xpath="//button[contains(text(),'Yes')]") public WebElement yesBtn;
	@FindBy(xpath="//button[contains(text(),'No')]") public WebElement noBtn;
	@FindBy(xpath="//*[contains(text(),'Add New')] | //*[contains(text(),'Add new')]") public WebElement addnewBtn;
	@FindBy(xpath="//span[contains(@class,'style__BackIcon')] | //h1[contains(text(),'Addresses')]/..//*[@fill-rule='nonzero']") public WebElement backbutton;
}