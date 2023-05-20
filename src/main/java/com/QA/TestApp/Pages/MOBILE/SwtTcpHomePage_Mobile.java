package com.QA.TestApp.Pages.MOBILE;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SwtTcpHomePage_Mobile extends BaseScript {

	public SwtTcpHomePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	//for android element add "and" as prefix and for ios add "ios"
	
	@FindBy(xpath = "//*[@text='Croma']")
	public MobileElement cardName_Croma_android;

	@FindBy(xpath = "//*[@text='IHCL']")
	public MobileElement cardName_IHCL_android;

	
	@FindBy(xpath = "//*[@text='View Details'][1]")
	public MobileElement viewDetailsCTA_android;

	@FindBy(xpath = "//*[@text='My Cards']")
	public MobileElement cardTab_android;
	
	@FindBy(xpath = "//*[@text='Shop Now']")
	public MobileElement cromaShopNow_android;
	
	@FindBy(xpath = "//*[@text='Book Now']")
	public MobileElement ihclBookNow_android;
	
	@FindBy(xpath = "//*[@text='Me']")
	public MobileElement selfBooking_android;
	
	//Croma Page
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"PWA Logo\"]/android.widget.Image") public MobileElement cromaHomePage_android;
	
	//IHCL Page
	@FindBy(xpath = "//*[@text='BOOK A STAY']") public MobileElement bookAStay_android;
	
	//Manoranjan
	@FindBy(xpath="//*[@text='View Details']") public MobileElement offerViewDetails_Android;
	@FindBy(xpath="//*[@text='Croma']") public MobileElement offerBrand_Android;
	@FindBy(xpath="//*[@text='Buy Now']") public MobileElement offerBuyNow_Android;
	@FindBy(xpath="//*[@text='TCP']") public MobileElement tcpHeader_Android;
	@FindBy(xpath="//*[@content-desc='PWA Logo']") public MobileElement cromaLogo_Android;
	@FindBy(xpath="//*[@content-desc='HELP']") public MobileElement cromaHelp_Android;
	@FindBy(xpath="//*[@text='STORE :']") public MobileElement cromaStore_Android;
	@FindBy(xpath="//*[@text='Payment Details']") public MobileElement paymentDetails_Android;
	@FindBy(xpath="//*[@text='Item total']") public MobileElement itemTotal_Android;
	@FindBy(xpath="//*[@text='Delivery cost at']") public MobileElement deliveryCost_Android;
	@FindBy(xpath="//*[@text='Today's savings']") public MobileElement todaysSavings_Android;
	@FindBy(xpath="//*[@text='Total price']") public MobileElement totalPrice_Android;
	@FindBy(xpath="//*[@text='CHECKOUT']") public MobileElement checkOut_Android;
	@FindBy(xpath="//*[@text='BUY NOW']") public MobileElement offerBuyNowCroma_Android;
	@FindBy(xpath="//android.view.View[@resource-id='loginActive']") public MobileElement loginActiveAndroid;
	@FindBy(xpath="/android.widget.ImageButton[@content-desc='Navigate up']") public MobileElement backButton_Android;
	@FindBy(xpath="//*[@data-testid='product-details']/div/div[2]/div/ul/li/h1") public MobileElement productDesc_Android;
	
	//revathi
	@FindBy(xpath="//*[@text='Croma']") public MobileElement channel_Croma_Android;

	@FindBy(id="com.tatadigital.tcp.dev:id/iv_menu") public MobileElement Croma_three_dots_Android;
	@FindBy(xpath="//*[contains(@text,'Shop Now')]") public MobileElement Croma_shop_now_Android;
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.EditText") public MobileElement Croma_search_prod_Android;
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.EditText") public MobileElement Croma_search_res_Android;
	@FindBy(xpath="//*[contains(@text,'BUY NOW')]") public MobileElement Croma_buynow_Android;
	@FindBy(xpath="//*[contains(@text,'CHECKOUT')]") public MobileElement Croma_checkout_Android;
	//IOS
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Croma']") public MobileElement croma_Via_channel_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='more']") public MobileElement croma_more_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Shop Now']") public MobileElement croma_shop_now_ios;
	
	
	
	//oct13 revathi
	//android
	@FindBy(xpath="//*[@text='Browse Products']") public MobileElement Browse_products_Android;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Browse Products']") public MobileElement browse_product_ios;
}

