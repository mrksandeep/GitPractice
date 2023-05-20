package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_SLPCultFit_Mobile{
	public TDL_SLPCultFit_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/txtLetsStart']") public MobileElement letsStartBtn_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/otpPinView']") public MobileElement enterTheOtpField_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/imCloseIcon']") public MobileElement crossBtn_android;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Fitness']") public MobileElement fitnessIcon_android;
	@FindBy(xpath = "//android.view.View[@content-desc='cult-brand-logo-white']") public MobileElement cultIcon_android;
	@FindBy(xpath = "(//*[@index='2'])[2]") public MobileElement actionButtonCult;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/bottom_offers']") public MobileElement offers_android;
	@FindBy(xpath = "(//*[@resource-id='OZ_Categories_CategoryIcon'])[4]") public MobileElement FitnessFromoffers_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/offerCardImageView'])[1]") public MobileElement offerCard_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/icon']") public MobileElement neupass_android;
	//fitnessUnderNeupass_android
	//cultIconNeupass_android

	
	@FindBy(xpath = "//*[@text='//*[@text='Allow']']") public MobileElement allowButton_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button") public MobileElement allowLocationPermission_android;

	@FindBy(xpath = "(//*[@index='2'])[2]") public MobileElement cultmenu_android;
	@FindBy(xpath = "//android.view.View[@text='Fitness']") public MobileElement Fitness_android;
	@FindBy(xpath = "(//*[@index='2'])[1]") public MobileElement hamburgericon_android;
	@FindBy(xpath = "//android.widget.TextView[@text='My orders']") public MobileElement myorders_android;
	@FindBy(xpath = "//android.widget.TextView[@text='Fitness']") public MobileElement fitnesswidget_android;
	@FindBy(xpath = "//android.widget.TextView[@text='ALL ORDERS']") public MobileElement allOrders_android;
	@FindBy(xpath = "(//*[@index='2'])[2]") public MobileElement Cultmenu_android;
	@FindBy(xpath = "//android.view.View[@content-desc='cultsport']") public MobileElement cultsport_android;
	@FindBy(xpath = "//android.widget.TextView[@text='Add to Cart']") public MobileElement addtocart_android;
	@FindBy(xpath = "//android.widget.TextView[@text='View Cart (1)']") public MobileElement Viewcart_android;
	@FindBy(xpath = "//android.widget.Button[@text='BUY NOW']") public MobileElement Buynow_android;
	@FindBy(xpath = "//android.widget.Button[@text='Select Address']") public MobileElement Selectaddress_android;
	@FindBy(xpath = "//*[@text='ALL ORDERS']") public MobileElement pickaddress_android;
	@FindBy(xpath = "//android.widget.Button[@text='Pay with Tata Pay']") public MobileElement paywithtatapay_android;
	@FindBy(xpath = "//android.widget.TextView[@text='Netbanking']") public MobileElement Netbanking_android;
	@FindBy(xpath = "(//android.widget.TextView[@text='Axis Bank'])[1]") public MobileElement selectbank_android;
	@FindBy(xpath = "//android.widget.TextView[@text='credit']") public MobileElement Successpayment_android;
	@FindBy(xpath = "//android.widget.TextView[@text='Awesome! Payment Complete']") public MobileElement Validatingpayment_android;
	@FindBy(xpath = "//android.widget.Image[@text='Men Blue Code Street Tee']") public MobileElement OncultSports_android;
	@FindBy(xpath = "(//*[@index='0'])[17]") public MobileElement Validatinglocation_android;

}