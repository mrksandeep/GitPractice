package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_MAChannelsOptionPage_Mobile {
	public TDL_MAChannelsOptionPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
    @FindBy(xpath="//*[contains(@text, 'Channels')]") public WebElement channels_Andriod;
	@FindBy(xpath="//*[contains(@text, 'Tata Sky')]")public WebElement tataskyoption_Andriod;
	@FindBy(xpath="//*[contains(@text, 'Croma')]")public WebElement cromaoption_Andriod;
	@FindBy(xpath="//*[contains(@text, 'IHCL')]")public WebElement ihcloption_Andriod;


}
