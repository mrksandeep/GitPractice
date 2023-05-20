package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_HomePage_Mobile {

	public TDL_HomePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(xpath ="//*[@resource-id='com.tatadigital.tcp.dev:id/ivDefaultProfilePic'] | //*[@resource-id='com.tatadigital.tcp.dev:id/ivProfilePic'] | //*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu'] | //*[@resource-id='com.tatadigital.tcp:id/ivHamburgerMenu'] | //*[@content-desc='Tata Neu']/following-sibling::android.widget.ImageView") public MobileElement profileButton_android;

	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu'] | //android.widget.LinearLayout[@index='1']/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView[2]") public MobileElement profileButtonnew_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivProfilePic") public MobileElement profileButton2_android;
	@FindBy(xpath = "//*[contains(@text,'Sign Out')]") public MobileElement signOutLink_android;
	//Akshya
	@FindBy(id = "com.tatadigital.tcp.dev:id/otpPinView") public MobileElement otp_field_android;
	@FindBy(xpath ="//android.widget.FrameLayout[@content-desc='Tata Pay']/android.widget.ImageView") public MobileElement vaultButton_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/ivSearch") public MobileElement searchButton_android;
	@FindBy(xpath = "//*[@text='CHANNELS']") public MobileElement channelsHeader_android;
	@FindBy(xpath = "//*[((@resource-id='com.tatadigital.tcp.dev:id/tv_name') and (@text='Tata Pay'))]") public MobileElement tataPayChannelBtn_android_old;
	@FindBy(className= "android.widget.Button") public MobileElement tataPayChannelBtn_android;
	@FindBy(xpath = "//*[((@resource-id='com.tatadigital.tcp.dev:id/tv_name') and (@text='Croma'))]") public MobileElement cromaChannelBtn_android;
	@FindBy(xpath = "//*[((@resource-id='com.tatadigital.tcp.dev:id/tv_name') and (@text='IHCL'))]") public MobileElement ihclChannelBtn_android;
	@FindBy(xpath = "//*[((@resource-id='com.tatadigital.tcp.dev:id/tv_name') and (@text='Tata Sky'))]") public MobileElement tataSkyChannelBtn_android;
	@FindBy(xpath = "//*[@text='Skip Tour'] | //*[contains(@text,'Skip')] | //*[@text='Skip demo']") public MobileElement skipTourTextView_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/ivBanner") public MobileElement heroBannerImage_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tv_viewAll']") public MobileElement view_all_btn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/bottom_home") public MobileElement home_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvErrorTextHeader") public MobileElement internet_connection_error_message1_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvErrorTextDetail") public MobileElement internet_connection_error_message2_android;

	//11-11
	@FindBy(xpath = "//*[@text='Request']") public MobileElement requestMoney_android;
	@FindBy(xpath = "//*[@text='Send money']") public MobileElement sendMoney_android;
	@FindBy(xpath = "//*[@text='Scan & pay']") public MobileElement scanBuy_android;
	@FindBy(xpath = "//*[@text='Self Transfer']") public MobileElement selfTransfer_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/txtLetsStart") public MobileElement lets_Start_button_android;

	//10-03
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUserRewards") public MobileElement userRewards_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivTcpLogo") public MobileElement tcpRewards_icon_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivHamburgerMenu") public MobileElement myLogo_Menu_android;
	@FindBy(xpath = "//*[@text='Sign out']") public MobileElement sign_out_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/positiveButton") public MobileElement positive_button_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUserPoints") public MobileElement loyaltyPointsInHomePage_android;

	
	//june24//
	@FindBy(id="com.tatadigital.tcp.dev:id/tvLoginWithPassword") public MobileElement pwd_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtPassword") public MobileElement pwdedt_android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/mobileConfirmButton'] | //*[contains(@text,'Submit')]") public MobileElement pwdeconfirm_android;
	
	
	/**
	 * Define ios locators
	 * 
	 */	
	@FindBy(xpath = "//XCUIElementTypeButton[@label='homeBurgerMenu']") public MobileElement myAccountIcon_ios_;
	//@FindBy(name = "tcpApp.home.valutButton") public MobileElement vaultIcon_ios;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='Vault']") public MobileElement vaultBtn_ios;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='Home']") public MobileElement homeBtn_ios;
	@FindBy(id = "tcpApp.home.scanButton") public MobileElement searchIcon_ios;
	@FindBy(xpath = "//*[contains(@name,'There was an error')] | //*[contains(@resource-id,'com.tatadigital.tcp.dev:id/tvErrorTextHeader')]") public MobileElement ErrorHomePage_ios_android;
	@FindBy(xpath = "//*[contains(@name,'Retry')] | //*[contains(@resource-id,'com.tatadigital.tcp.dev:id/btnRetryClick')]") public MobileElement ErrorPageRetryBtn_ios_android;
	@FindBy(xpath = "//*[@name='FOR YOU'] | //*[@resource-id='com.tatadigital.tcp.dev:id/forYouText']|//*[contains(@text,'APPS')]") public MobileElement forYouLabel_ios_android;
	@FindBy(xpath = "//*[@name='CHANNELS'] | //*[@name='tcpApp.home.feedChannelCell']") public MobileElement channelsHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip Tour']") public MobileElement skipTourTextView_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[2]/..") public MobileElement homepageContainer_ios;
	@FindBy(name = "channels.ribbon.imageView.Tata Pay") public MobileElement tataPayChannelBtn_ios;
	@FindBy(name = "channels.ribbon.imageView.Croma") public MobileElement cromaChannelBtn_ios;
	@FindBy(name = "channels.ribbon.imageView.IHCL") public MobileElement ihclChannelBtn_ios;
	@FindBy(name = "channels.ribbon.imageView.Tata Sky") public MobileElement tataSkyChannelBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Dismiss']") public MobileElement appNotificationDismiss_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@label='homeAlerts']") public MobileElement alertstIcon_ios_;


}
