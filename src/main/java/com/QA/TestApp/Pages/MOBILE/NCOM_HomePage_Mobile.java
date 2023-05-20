package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NCOM_HomePage_Mobile {
	
	public NCOM_HomePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	/*========================================================
	 *        Android Locators
	 ========================================================*/
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu']") public MobileElement hamburgerMenuBtn_android;
	@FindBy(xpath = "") public MobileElement CLPBtn_android;
	@FindBy(xpath = "") public MobileElement PLPBtn_android;
	@FindBy(xpath= "//android.widget.ImageView[@content-desc='Search']") public MobileElement searchBox_android;
	@FindBy(xpath="//*[@resource-id='search-option-0']") public MobileElement searchOption;
	@FindBy(xpath="//android.widget.Button[@text='searchIcon'] | //android.view.View[@content-desc='searchIcon']") public MobileElement searchButton_android;
	@FindBy(xpath="//*[@resource-id='search-option-0']") public MobileElement buyNowBtn;
	@FindBy(xpath = "") public MobileElement budgetBuy_android;
	
	/*========================================================
	 *        iOS Locators
	 ========================================================*/
	
	// Entry Point
		@FindBy(xpath = "//*[@content-desc='Search']") public MobileElement tapToSearch_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/edtSearch") public MobileElement searchBar_android;
		@FindBy(xpath = "//*[@class = 'android.widget.TextView']") public List<MobileElement> suggestionOptions_android ;
		@FindBy(xpath = "//*[@text= 'ADD']") public List<MobileElement> addButtons_android;
		@FindBy(xpath = "//*[contains(@content-desc, 'Basket')]") public MobileElement basketIcon_android;
		@FindBy(xpath = "//*[@text= 'CHECKOUT']") public MobileElement checkOutButton_android;
		@FindBy(xpath = "//*[@text= 'OUT OF STOCK']") public MobileElement outOfStockStatus_android;
		@FindBy(xpath = "//*[@text='CONFIRM']") public MobileElement confirmButton_android;
		@FindBy(xpath = "//*[@text='PROCEED TO PAY']") public MobileElement proceedToPayButton_android;
		@FindBy(xpath = "//*[@text = 'Tata Pay']") public MobileElement tataPayButton_android;
		@FindBy(xpath = "//*[@text = 'Cash on Delivery']") public MobileElement cashOnDeliveryButton_android;
		@FindBy(xpath = "//*[@text = 'Place order & Pay']") public MobileElement placeOrderAndPayButton_android;
		@FindBy(xpath = "//*[@text = 'Continue']") public MobileElement paymentContinueButton_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/edCvv") public MobileElement enterCardcvv_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/btnPayMultitender") public MobileElement payAmountButton_android;
		@FindBy(xpath = "//*[contains(@text,'Card payments')]") public MobileElement cardPayment;
//		@FindBy(xpath = "//*[@text= 'Retry payment']") public MobileElement retryPaymentButton_android;
//		@FindBy(xpath = "//*[@text= 'Net Banking']") public MobileElement netBanking_android;
//		@FindBy(xpath = "//*[@text= 'Select your bank']") public MobileElement selectYourBank_android;
//		@FindBy(xpath = "(//android.widget.CheckedTextView)[2]") public MobileElement selectFirstBank_android;
//		@FindBy(xpath = "//*[@text= 'Pay Now']") public MobileElement payNowButton_android;
		
		@FindBy(xpath = "//*[@resource-id='password'] | //*[@resource-id='otpForm']//android.widget.EditText") public MobileElement enterOTP_android;
		@FindBy(xpath = "//*[@text = 'PAY']") public MobileElement payButton_android;
		@FindBy(xpath = "//*[@resource-id= 'com.tatadigital.tcp.dev:id/tvPaymentStatus']") public MobileElement afterPaymentMsg_android;
		@FindBy(xpath = "//*[@text = 'Track order']") public MobileElement trackOrderButton_android;
		@FindBy(xpath = "//*[@text= 'My Orders']") public MobileElement trackOrderPage_android;
		
		// App Switch 
		@FindBy(xpath = "//android.widget.ImageView[@content-desc='Grocery']") public MobileElement groceryIcon_android;
		//@FindBy(xpath = "//*[@content-desc='Shop by category']//android.widget.ImageView[1]") public List<MobileElement> categoryWidgets_android;
		@FindBy(xpath = "//*[@text= 'icon']") public List<MobileElement> categoryWidgets_android;
		//@FindBy(xpath = "(//android.view.View[@resource-id='pwa-header']/android.view.View//android.widget.TextView)[1]") public MobileElement groceryHamburgerMenu_android;
		@FindBy(xpath = "//android.view.View[@resource-id='pwa-header']//android.view.View[2]") public MobileElement groceryHamburgerMenu_android;
		//@FindBy(xpath = "(//android.view.View/android.widget.TextView)[4]") public MobileElement locationIcon_android;
		@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/txtCityName']") public MobileElement locationIcon_android;
		@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Default')]") public MobileElement defaultLocationTile_android;
		@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Other')]") public MobileElement otherLocationTile_android;
		@FindBy(xpath = "//android.view.View[2]/android.view.View[contains(@content-desc, '')]") public List<MobileElement> productCategoriesTiles_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/homePageSearchBox") public MobileElement searchBarBB_android;
		@FindBy(xpath = "//android.widget.TextView[@resource-id = 'com.tatadigital.tcp.dev:id/txtTerm']") public List<MobileElement> searchResults_android;
		
		//Verify BB star membership
		@FindBy(xpath = "//android.view.View[contains(@content-desc, 'Neu')]") public MobileElement neuCoinsRewardsWidget_android;
		@FindBy(xpath = "") public MobileElement bbRewardsBar_android;
		@FindBy(xpath = "//android.widget.TextView[@resource-id = 'elite-card-container-section-two-label']") public MobileElement allBadges_android;
		@FindBy(xpath = "") public MobileElement bbStarMembershipFeatures_android;
		@FindBy(xpath = "") public MobileElement membershipValidity_android;
		@FindBy(id = "modal-close-button") public MobileElement closePopUp_android;
		@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']") public MobileElement homepageIcon_android;
		
		
		//other locators
		@FindBy(id = "com.tatadigital.tcp.dev:id/negativeButtonBb") public MobileElement usePreviousLocationButton_android;
		
		

	
	
	
	
	

}
