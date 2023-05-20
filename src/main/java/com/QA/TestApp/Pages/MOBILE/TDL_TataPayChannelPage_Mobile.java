package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_TataPayChannelPage_Mobile {

	public TDL_TataPayChannelPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/rv_channel_interaction")
	public MobileElement channel_interaction_android;
	@FindAll({
			@FindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.tatadigital.tcp.dev:id/rv_channel_interaction\"]/*)") })
	public List<MobileElement> viewGroup_android;
	@FindAll({ @FindBy(id = "com.tatadigital.tcp.dev:id/tvBankName") })
	public List<MobileElement> bankNameList;
	
	@FindBy(xpath = "(//android.widget.ImageView[@content-desc='image_description'])[3]") public MobileElement ExpiredStstusImage;
	@FindAll({
		@FindBy(xpath = "//*[@class='android.widget.TextView']")})
		public List<MobileElement> utrText;
	
	@FindAll({@FindBy(xpath="//*[contains(@text,'UTR')]")}) public List<MobileElement> txnIdListChannel_android;
	@FindAll({@FindBy(xpath="//*[contains(@text,'Accept')]")}) public List<MobileElement> acceptButton_android;
	@FindAll({@FindBy(xpath="//*[contains(@text,'Decline')]")}) public List<MobileElement> declineButton_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/iv_back") public MobileElement backBtnChannel_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/payment_req_container")}) public List<MobileElement> paymentContainer_android;
	@FindBy(xpath="//*[contains(@text,'MANDATE MODIFIED')]") public MobileElement modifiedWidget_android;
	
	@FindBy(xpath="//*[contains(@text,'MANDATE REQUEST')]") public MobileElement mandateWidget_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnChannelAlert") public MobileElement tataPayChannelBtn_android;
	/**
	 * Define ios locators
	 * 
	 */

}
