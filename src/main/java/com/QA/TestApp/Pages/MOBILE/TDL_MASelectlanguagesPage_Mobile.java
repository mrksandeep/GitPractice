package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_MASelectlanguagesPage_Mobile {
	public TDL_MASelectlanguagesPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	@FindBy(xpath="//*[contains(@text,'English')]") public MobileElement english_Andriod;
    @FindBy(xpath="//*[contains(@text,'Hindi')]") public MobileElement hindi_Andriod;
    @FindBy(xpath="//*[contains(@text,'Marathi')]") public MobileElement marathi_Andriod;
    @FindBy(xpath="//*[contains(@text,'Punjabi')]") public MobileElement punjabi_Andriod;
    @FindBy(xpath="//*[contains(@text,'Gujarati')]") public MobileElement gujarati_Andriod;
    @FindBy(xpath="//*[contains(@text,'Bengali')]") public MobileElement bengali_Andriod;
    @FindBy(xpath="//*[contains(@text,'Odia')]") public MobileElement odia_Andriod;
    @FindBy(xpath="//*[contains(@text,'Tamil')]") public MobileElement tamil_Andriod;
    @FindBy(xpath="//*[contains(@text,'Telugu')]") public MobileElement telugu_Andriod;
    @FindBy(xpath="//*[contains(@text,'Kannada')]") public MobileElement kannada_Andriod;
    @FindBy(xpath="//*[contains(@text,'Malayalam')]") public MobileElement malayalam_Andriod;
    @FindBy(xpath="//*[contains(@text,'Others')]") public MobileElement others_Andriod;
    @FindBy(xpath="//*[contains(@text,'Continue')]") public MobileElement continuebtn_Andriod;


}
