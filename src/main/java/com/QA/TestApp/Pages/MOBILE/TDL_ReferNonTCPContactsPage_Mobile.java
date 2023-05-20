package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_ReferNonTCPContactsPage_Mobile {
	
	public TDL_ReferNonTCPContactsPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id="com.tatadigital.tcp.dev:id/toolbarTitleTextView") public MobileElement referNonTcpContactHeader_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/contactSearchEditText") public MobileElement searchTextField_android;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Back']") public MobileElement backBtn_android;
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Refer'])[1]") public MobileElement referBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='tcpApp.referAFriend.searchTextField']") public MobileElement searchTextField_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']") public MobileElement backBtn_ios;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Refer Non TCP Contacts']") public MobileElement referNonTcpContact_ios;	

}

