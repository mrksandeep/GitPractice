package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NCOM_PLP_Page_Mobile {
	
	public NCOM_PLP_Page_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	/*========================================================
	 *        Android Locators
	 ========================================================*/
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu']") public MobileElement hamburgerMenuBtn_android;
	//For Non Logged In Member
		@FindBy(xpath = "") public MobileElement backButton_android;
		@FindBy(xpath = "") public MobileElement searchButton_android;
		@FindBy(xpath = "") public MobileElement addToCart_android;
		@FindBy(xpath = "") public MobileElement location_android;
		@FindBy(xpath = "") public MobileElement sortByButton_android;
		@FindBy(xpath = "") public MobileElement productName_android;
		@FindBy(xpath = "") public MobileElement readReview_android;
		@FindBy(xpath = "") public MobileElement actaulPrice_android;
		@FindBy(xpath = "") public MobileElement discountedPrice_android;
		@FindBy(xpath = "") public List <MobileElement>  discountRate_android;
		@FindBy(xpath = "") public MobileElement cashBack_android;
		@FindBy(xpath = "") public MobileElement deliverDate_android;
		@FindBy(xpath = "") public MobileElement offers_android;
		@FindBy(xpath = "") public MobileElement image_android;
		
	//For Logged In Member	
		
		@FindBy(xpath = "") public MobileElement offers1_android;
		@FindBy(xpath = "") public MobileElement emiButton_android;
		@FindBy(xpath = "") public MobileElement stockAvailability_android;
		@FindBy(className=" ") public List <MobileElement> brandname_android;
		
		@FindBy(className=" ") public List <MobileElement> MRP_android;
		
		
	//Filters
		@FindBy(xpath = "") public MobileElement filter_android;
		@FindBy(xpath = "") public MobileElement clear_android;
		@FindBy(xpath = "") public MobileElement filterBycategory_android;
		@FindBy(xpath = "") public MobileElement filterByPrice_android;
		@FindBy(xpath = "") public MobileElement filterByBrand_android;
		@FindBy(xpath = "") public MobileElement viewAll_android;
	    @FindBy(xpath = "") public MobileElement filterByDeliveryModes_android;
		@FindBy(xpath = "") public MobileElement ShopWithVideo_android;
		@FindBy(xpath = "") public MobileElement numberOfItemsFound_android;
		@FindBy(className=" ") public List <MobileElement> price_android;
		@FindBy(xpath = "") public MobileElement apply_android;


		
	
	/*========================================================
	 *        iOS Locators
	 ========================================================*/
	
	
	
	
	

}
