package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_MATataSkyRegisterPage_Mobile {
	
	public TDL_MATataSkyRegisterPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/editFirstName") public MobileElement editFirstName_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/editLastName") public MobileElement editLastName_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/editPhone") public MobileElement editPhone_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/editEmail") public MobileElement editEmail_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvInstallationAddress") public MobileElement tvInstallationAddress_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAddAddress") public MobileElement addNewButton_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/ivClose") public MobileElement closeBtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAddresses") public MobileElement register_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvCustom") public MobileElement custom_android;
	@FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/android.widget.RadioButton") public MobileElement selectAddress_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvSaveChanges") public MobileElement continueBtn_android;
	
	
	
	/*
	 * TATA SKY : TCP PAGE
	 */


	/**
	 * Define ios locators
	 * 
	 */
	
	
}
