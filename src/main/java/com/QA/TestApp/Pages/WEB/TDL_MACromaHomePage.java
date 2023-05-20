package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MACromaHomePage {
	@FindBy(xpath = "//*[contains(text(),'Shop Now')]") public WebElement shopnowbtn;
}
