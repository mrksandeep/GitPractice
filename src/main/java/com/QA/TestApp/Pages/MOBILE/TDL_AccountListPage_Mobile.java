package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_AccountListPage_Mobile {
	
	public TDL_AccountListPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(xpath="//*[contains(@text, 'Profile')]") public MobileElement profileOpt_android;
	@FindBy(xpath="//android.widget.TextView[@text='Addresses']") public MobileElement addressesOpt_android;
	@FindBy(xpath="//*[contains(@text, 'Manage Security')]") public MobileElement securityOpt_android;
	@FindBy(xpath="//*[contains(@text, 'Sign Out')]") public MobileElement signOutOpt_android;	
	@FindBy(xpath="//*[contains(@text, 'Sign out of all devices & linked apps')] ") public MobileElement SignOutOfAllDevicesLinkedAppsOpt_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/positiveButton") public MobileElement signoutButton_android;
	@FindBy(xpath="//*[contains(@text, 'Yes')] ") public MobileElement yesButton_android;
	@FindBy(xpath="//*[contains(@text, 'Others')]") public MobileElement otherOpt_android;
	@FindBy(xpath="//*[contains(@text, 'Refer a friend')]") public MobileElement referfriendOpt_android;
	@FindBy(xpath="//*[@text='Refer Non TCP Contacts']") public MobileElement refereNonTCPInsideReferaFriend_android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/shareImageView']") public MobileElement shareIconInsideReferaFriend_android;
	
	@FindBy(xpath="//*[contains(@text, 'Legal')]") public MobileElement legalOpt_android;
	@FindBy(xpath="//*[contains(@text, 'Change Password')]") public MobileElement changePassword_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose") public MobileElement addressBackbtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/imgClose") public MobileElement acclistBackbtn_android;
	@FindBy(xpath="//*[contains(@text, 'Order history')]") public MobileElement orderHistoryOptn_android;
	@FindBy(xpath="//androidx.appcompat.app.ActionBar.Tab[@content-desc='Orders']/android.widget.TextView") public MobileElement orderTabOrderHistory_android;
	
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile']") public MobileElement profileOpt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Addresses']") public MobileElement addressesOpt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Manage Security']") public MobileElement securityOpt_ios;	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Sign Out']") public MobileElement signOutOpt_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.AccountList.tableviewCell'])[2]")	public MobileElement signOutOfAllDevicesLinkedAppsOpt_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Sign out']") public MobileElement signOutButton_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")	public MobileElement yesButton_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='Others']") public MobileElement otherOpt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Refer a friend']") public MobileElement referfriendOpt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Legal']")	public MobileElement legalOpt_ios;
	@FindBy(xpath="(//XCUIElementTypeCell[@name='tcpApp.AccountList.tableviewCell'])[1]") public MobileElement changePassword_ios;	
	@FindBy(xpath="//XCUIElementTypeOther[@name='Order History'] | //XCUIElementTypeOther[@name='Order history']") public MobileElement orderHistoryOptn_ios;	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Orders']") public MobileElement orderTabOrderHistory_ios;
	

}