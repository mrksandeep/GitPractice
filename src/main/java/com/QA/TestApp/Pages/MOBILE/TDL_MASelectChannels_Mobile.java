package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_MASelectChannels_Mobile {
	public TDL_MASelectChannels_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	@FindBy(xpath="//*[contains(@text,'Entertainment')]")public MobileElement entertainment_Andriod;
	@FindBy(xpath="//*[contains(@text,'News')]")public MobileElement news_Andriod;
	@FindBy(xpath="//*[contains(@text,'Movies')]")public MobileElement movies_Andriod;
	@FindBy(xpath="//*[contains(@text,'Kids')]")public MobileElement kids_Andriod;
	@FindBy(xpath="//*[contains(@text,'Sports')]")public MobileElement sports_Andriod;
	@FindBy(xpath="//*[contains(@text,'Music')]")public MobileElement music_Andriod;
	@FindBy(xpath="//*[contains(@text,'Knowledge and Lifestyle')]")public MobileElement ktlifestyle_Andriod;
	@FindBy(xpath="//*[contains(@text,'Spiritual')]")public MobileElement spiritual_Andriod;
	@FindBy(xpath="//*[contains(@text,'Others')]")public MobileElement others_Andriod;
    @FindBy(xpath="//*[contains(@text,'Continue')]")public MobileElement continuebtn_Andriod;
    
  //OTP Validation
  	@FindBy(xpath="//*[contains(@text,'BK-IHCLHT')]") public List<MobileElement> smsSender;
  	@FindBy(xpath="//android.widget.ListView[@resource-id='android:id/list']//android.view.ViewGroup[1]")public MobileElement firstSMS;
  	@FindBy(xpath="//android.widget.ListView[@resource-id='android:id/list']//android.view.ViewGroup[1]//android.widget.TextView[@resource-id='com.android.mms:id/from']")public MobileElement smsSource;
  	@FindBy(xpath="//android.widget.ListView[@resource-id='android:id/list']//android.view.ViewGroup[1]//android.widget.TextView[@resource-id='com.android.mms:id/date']")public MobileElement smsTime;
  	@FindBy(xpath="//android.widget.TextView[@resource-id='miui:id/action_bar_title']")public MobileElement msgHeader;
  	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.mms:id/action_value']")public List<MobileElement> otpCode;
  	@FindAll({@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.mms:id/message_body']")})public List<MobileElement> msgBody;
  	@FindAll({@FindBy(xpath = "//*[contains(@text,'Dear Guest')]")}) public List<MobileElement> msgbody2;


}
