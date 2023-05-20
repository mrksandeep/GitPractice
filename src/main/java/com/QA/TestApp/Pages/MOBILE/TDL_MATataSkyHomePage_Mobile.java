package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_MATataSkyHomePage_Mobile {
	
	public TDL_MATataSkyHomePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/iv_menu") public MobileElement menuButton_android;
	@FindBy(xpath = "//*[contains(@text, 'New Connection')]") public MobileElement newConnection_android;
	@FindBy(xpath = "//*[contains(@text, 'Box Upgrade')]") public MobileElement boxUpgrade_android;
	@FindBy(xpath ="//*[contains(@text, 'Quick Recharge')]") public MobileElement quickRecharge_android;
	@FindBy(xpath ="//*[contains(@text, 'Showcase')]") public MobileElement showcase_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btn_close_dailog") public MobileElement closeButton_android;
	@FindAll({@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout")})public List<MobileElement> ListOftataSkyOptions_andriod;
	

	/**
	 * Define ios locators
	 * 
	 */
	
	
}
