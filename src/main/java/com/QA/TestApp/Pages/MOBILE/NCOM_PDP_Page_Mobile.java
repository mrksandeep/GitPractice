package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NCOM_PDP_Page_Mobile {
	
	public NCOM_PDP_Page_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	/*========================================================
	 *        Android Locators
	 ========================================================*/
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu']") public MobileElement hamburgerMenuBtn_android;
	
	
	@FindBy(xpath = "") public MobileElement searchBtn_android;
	@FindBy(xpath = "") public MobileElement addtocart_android;
	@FindBy(xpath = "") public MobileElement location_android;
	@FindBy(xpath = "") public MobileElement share_android;
	@FindBy(xpath = "") public MobileElement locationchangebtn_android;
	@FindBy(xpath = "") public MobileElement productName_android;
	@FindBy(xpath = "") public MobileElement SKUName_android;
	@FindBy(xpath = "") public MobileElement SKUImage_android;
	@FindBy(xpath = "") public MobileElement SKUtitle_android;
	@FindBy(xpath = "") public MobileElement Strikethrough_Price_android;
	@FindBy(xpath = "") public MobileElement MRP_Price_android;
	@FindBy(xpath = "") public MobileElement DiscountPercentage_android;
	@FindBy(xpath = "") public MobileElement DeliveryDateTime_android;
	@FindBy(xpath = "") public MobileElement FreeDelivery_android;
	@FindBy(xpath = "") public MobileElement AddressBar_android;
	@FindBy(xpath = "") public MobileElement overview_android;

	
	@FindBy(xpath = "") public MobileElement rate_android;
	@FindBy(xpath = "") public MobileElement price_android;
	@FindBy(xpath = "") public MobileElement extrasaving_android;
	@FindBy(xpath = "") public MobileElement buynow_android;
	@FindBy(xpath = "") public MobileElement addbtn_android;
	@FindBy(xpath = "") public MobileElement seeAllbtn_android;
	@FindBy(xpath = "") public MobileElement readAllreviewbtn_android;
	@FindBy(xpath = "") public MobileElement colour_android;
	@FindBy(xpath = "") public MobileElement sizename_android;
	@FindBy(xpath = "") public MobileElement moblieProtectionPlan_android;
	@FindBy(xpath = "") public MobileElement EMIbtn_android;
	@FindBy(xpath = "") public MobileElement EMIoffer_android;
	@FindBy(xpath = "") public MobileElement cashbackbtn_android;//rewards
	@FindBy(xpath = "") public MobileElement getItbyBtn_android;
	@FindBy(xpath = "") public MobileElement offerbtn_android;
	@FindBy(xpath = "") public MobileElement choosePhntoExchangebtn_android;
	
	@FindBy(xpath = "") public MobileElement review_android;
	@FindBy(xpath = "") public MobileElement exportReview_android;
	@FindBy(xpath = "") public MobileElement customerReview_android;
	@FindBy(xpath = "") public MobileElement ExternalUserReview_android;
	@FindBy(xpath = "") public MobileElement rateReview_android;
	@FindBy(xpath = "") public MobileElement usernameRate_android;
	@FindBy(xpath = "") public MobileElement dateOfRating_android;
	@FindBy(xpath = "") public MobileElement viewAllbtn_android;
	@FindBy(xpath = "") public MobileElement writeReview_android;
	
	@FindBy(xpath = "") public MobileElement keyfeatures_android;
	@FindBy(xpath = "") public MobileElement exchangePricing_android;
	@FindBy(xpath = "") public MobileElement imageGallery_android;
	
	
	
	//Shipping Addresses
	@FindBy(xpath = "") public MobileElement defaultAddressWidget_android;
	@FindBy(xpath = "") public MobileElement addressWidget2_android;

	//Checkout and Proceed to payment
	@FindBy(xpath = "") public MobileElement checkOutButton_android;
	@FindBy(xpath = "") public MobileElement proceedToPaymentButton_android;
	
	/*========================================================
	 *        iOS Locators
	 ========================================================*/
	
	
	
	
	

}
