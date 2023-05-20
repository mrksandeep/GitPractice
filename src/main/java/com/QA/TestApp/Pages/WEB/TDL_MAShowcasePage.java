package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MAShowcasePage {

	@FindBy(xpath="//h1") public WebElement showcasepageheader;
	@FindBy(xpath="(//span[text()='Order'])[1]") public WebElement ordermovie;
}
