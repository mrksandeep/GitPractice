package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_SecurePage {
	@FindBy(xpath = "//input[@name='txtPassword']") public WebElement txtPassword;
	@FindBy(xpath = "//input[@id='cmdSubmit']") public WebElement cmdSubmit;
	@FindBy(xpath = "//input[@id='cmdCancel']") public WebElement cmdCancel;
}


