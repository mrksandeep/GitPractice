package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MASelectChannels {

	@FindBy(xpath="//*[contains(text(),'Entertainment')]")public WebElement entertainment;
	@FindBy(xpath="//*[contains(text(),'News')]")public WebElement news;
	@FindBy(xpath="//*[contains(text(),'Movies')]")public WebElement movies;
	@FindBy(xpath="//*[contains(text(),'kids')]")public WebElement kids;
	@FindBy(xpath="//*[contains(text(),'Sports')]")public WebElement sports;
	@FindBy(xpath="//*[contains(text(),'Music')]")public WebElement music;
	@FindBy(xpath="//*[contains(text(),'Knowledge and Lifestyle')]")public WebElement ktlifestyle;
	@FindBy(xpath="//*[contains(text(),'Spiritual')]")public WebElement spiritual;
	@FindBy(xpath="//*[contains(text(),'Others')]")public WebElement others;
    @FindBy(xpath="//*[contains(text(),'Continue')]")public WebElement continuebtn;


}
