package com.QA.TestApp.Pages.MOBILE;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalcPage extends BaseScript {

	public CalcPage() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	//for android element add "and" as prefix and for ios add "ios"
	
	@FindBy(id="com.oneplus.calculator:id/digit_2") public MobileElement digit2;
	@FindBy(id="com.oneplus.calculator:id/op_add") public MobileElement plus;
	@FindBy(id="com.oneplus.calculator:id/digit_6") public MobileElement digit4;
	@FindBy(id="com.oneplus.calculator:id/eq") public MobileElement equal;
	@FindBy(id="com.oneplus.calculator:id/result") public MobileElement result;

}

