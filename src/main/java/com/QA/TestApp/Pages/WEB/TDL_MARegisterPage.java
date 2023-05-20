package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MARegisterPage {
	@FindBy(xpath="(//input[@type='radio'])[1]")public WebElement select_address;
	@FindBy(xpath="//*[contains(text(),'Edit')]")public WebElement editbtn;
    @FindBy(xpath="//*[contains(text(),'Continue')]")public WebElement continuebtn;
    @FindBy(xpath="//h1[contains(text(),'Register')]")public WebElement registerheader;//*[contains(text(),'Register')]
}
