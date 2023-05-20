package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_MAHDselectionPage_Mobile {
	public TDL_MAHDselectionPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	@FindBy(xpath="//*[contains(@text,'Yes')]") public MobileElement yesbtn_Andriod;
	@FindBy(xpath="//*[contains(@text,'No')]") public MobileElement nobtn_Andriod;
	@FindBy(xpath="//*[contains(@text, 'Get this')]") public MobileElement getthisbtn_Andriod;
	@FindBy(xpath="//android.view.View/android.view.View[2]/android.view.View[4]") public MobileElement getthispackbtn_Andriod;
	@FindBy(xpath="//*[contains(@text, 'Pay Online')]") public MobileElement payonlinebtn_Andriod;
	@FindBy(xpath="//*[contains(@text, 'Select the set top box and proceed')]") public MobileElement selectsettopboxheader_Andriod;
	@FindBy(xpath="//*[contains(@text, 'View your selections & total cost')]") public MobileElement selectpaymentoptionheader_Andriod;

	
}

