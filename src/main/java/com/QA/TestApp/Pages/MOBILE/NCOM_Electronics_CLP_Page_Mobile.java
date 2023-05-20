package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NCOM_Electronics_CLP_Page_Mobile {
	
	public NCOM_Electronics_CLP_Page_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	/*========================================================
	 *        Android Locators
	 ========================================================*/
	
	//@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu']") public MobileElement hamburgerMenuBtn_android;
	
	
	/*===============================================
	 Address selection, add address, Pincode change
	 ================================================
	 */
	@FindBy(xpath = "") public MobileElement selectShippingAddress_android;
	@FindBy(xpath = "") public MobileElement defaultButton_android;
	@FindBy(xpath = "") public MobileElement editButton_android;
	@FindBy(xpath = "") public MobileElement setAsDefaultButton_android;
	@FindBy(xpath = "") public MobileElement addNewAddressBar_android;
	@FindBy(xpath = "") public MobileElement enterPincodeTextBar_android;
	@FindBy(xpath = "") public MobileElement useMyCurrentLocationBar_android;
	
	/*=======================================
	 Electronics landing(SLP)
	 ========================================
	 */
	@FindBy(xpath = "") public MobileElement backButton_android;
	@FindBy(xpath = "") public MobileElement searchIcon_android;
	@FindBy(xpath = "") public MobileElement locationIcon_android;
	
	// Hero Banners
	@FindBy(xpath = "") public List<MobileElement> heroBanners_android;
	@FindBy(xpath = "") public MobileElement heroBanner2_android;
	@FindBy(xpath = "") public MobileElement heroBanner3_android;
	@FindBy(xpath = "") public MobileElement heroBanner4_android;
	
	// Shop and Explore
	@FindBy(xpath = "") public MobileElement groceryWidget_android;
	@FindBy(xpath = "") public MobileElement electronicsWidget_android;
	@FindBy(xpath = "") public MobileElement fashion_android;
	@FindBy(xpath = "") public MobileElement luxuryWidget_android;
	@FindBy(xpath = "") public MobileElement beautyWidget_android;
	@FindBy(xpath = "") public MobileElement fitnessWidget_android;
	@FindBy(xpath = "") public MobileElement flightsWidget_android;
	@FindBy(xpath = "") public MobileElement hotelsWidget_android;
	@FindBy(xpath = "") public MobileElement entertainmentWidget_android;
	@FindBy(xpath = "") public MobileElement foodAndBeverageWidget_android;
	@FindBy(xpath = "") public MobileElement smartphonesWidget_android;
	@FindBy(xpath = "") public MobileElement healthCareWidget_android;
	
	// Top trending products
	@FindBy(xpath = "") public MobileElement topTrendingProduct1_android;
	@FindBy(xpath = "") public MobileElement topTrendingProduct2_android;
	@FindBy(xpath = "") public MobileElement topTrendingProduct3_android;

	// Recommended offers
	@FindBy(xpath = "") public MobileElement recommendedOffers1_android;
	@FindBy(xpath = "") public MobileElement recommendedOffers2_android;
	@FindBy(xpath = "") public MobileElement recommendedOffers3_android;
	
	// Shop by categories
	@FindBy(xpath = "") public MobileElement mobilePhonesCategory_android;
	@FindBy(xpath = "") public MobileElement laptopsAndTabletsCategory_android;
	@FindBy(xpath = "") public MobileElement televisionsCategory_android;
	@FindBy(xpath = "") public MobileElement audioAndVideoCategory_android;
	@FindBy(xpath = "") public MobileElement homeAppliancesCategory_android;
	@FindBy(xpath = "") public MobileElement CamerasCategory_android;
	
	//Offers
	@FindBy(xpath = "") public MobileElement offer1_android;
	@FindBy(xpath = "") public MobileElement offer2_android;
	@FindBy(xpath = "") public MobileElement offer3_android;
	
	//Shop by Brands
	@FindBy(xpath = "") public MobileElement brand1_android;
	@FindBy(xpath = "") public MobileElement brand2_android;
	@FindBy(xpath = "") public MobileElement brand3_android;
	@FindBy(xpath = "") public MobileElement brand4_android;
	@FindBy(xpath = "") public MobileElement brand5_android;
	@FindBy(xpath = "") public MobileElement brand6_android;
	@FindBy(xpath = "") public MobileElement brand7_android;
	@FindBy(xpath = "") public MobileElement brand8_android;
	@FindBy(xpath = "") public MobileElement brandProducts1_android;
	@FindBy(xpath = "") public MobileElement brandProducts2_android;
	
	//Brand products
	@FindBy(xpath = "") public MobileElement brandProductType1_android;
	@FindBy(xpath = "") public MobileElement brandProductType2_android;
	@FindBy(xpath = "") public MobileElement brandProductType3_android;
	
	//Repairs
	@FindBy(xpath = "") public MobileElement repairLaptopAndMobiles_android;
	@FindBy(xpath = "") public MobileElement repairTelevisions_android;

	//Bundles you can't miss
	@FindBy(xpath = "") public MobileElement bundle1_android;
	@FindBy(xpath = "") public MobileElement bundle2_android;

	//Guided
	@FindBy(xpath = "") public MobileElement guide1_android;
	@FindBy(xpath = "") public MobileElement guide2_android;





	/*========================================================
	 *        Frame 2
	 ========================================================*/
	
	@FindBy(xpath = "") public MobileElement wishlistIcon_android;
	@FindBy(xpath = "") public MobileElement searchProductsIcon_android;
	@FindBy(xpath = "") public MobileElement cartIcon_android;
	@FindBy(xpath = "") public MobileElement deliverToIcon_android;
	@FindBy(xpath = "") public MobileElement heroBanner_android;
	@FindBy(xpath = "") public MobileElement mobilePhonesOption_android;
	@FindBy(xpath = "") public MobileElement kitchenAppliancesOption_android;
	@FindBy(xpath = "") public MobileElement televisionOption_android;
	@FindBy(xpath = "") public MobileElement laptopOption_android;
	@FindBy(xpath = "") public MobileElement allCategoriesBar_android;
	
	//Upcoming launches
	@FindBy(xpath = "") public MobileElement productWithPrice1_android;
	@FindBy(xpath = "") public MobileElement productWithPrice2_android;
	@FindBy(xpath = "") public MobileElement productWithPrice3_android;
	
	//Never Before
	@FindBy(xpath = "") public MobileElement productWithPriceRange1_android;
	@FindBy(xpath = "") public MobileElement productWithPriceRange2_android;
	@FindBy(xpath = "") public MobileElement productWithPriceRange3_android;
	
	//Hot deals
	@FindBy(xpath = "") public MobileElement productWithImage1_android;
	@FindBy(xpath = "") public MobileElement productWithName1_android;
	@FindBy(xpath = "") public MobileElement productRating1_android;
	@FindBy(xpath = "") public MobileElement productPriceWithDiscouunt1_android;
	@FindBy(xpath = "") public MobileElement productPriceWithoutDiscouunt1_android;
	
	@FindBy(xpath = "") public MobileElement productWithImage2_android;
	@FindBy(xpath = "") public MobileElement productWithName2_android;
	@FindBy(xpath = "") public MobileElement productRating2_android;
	@FindBy(xpath = "") public MobileElement productPriceWithDiscouunt2_android;
	@FindBy(xpath = "") public MobileElement productPriceWithoutDiscouunt2_android;
	
	@FindBy(xpath = "") public MobileElement productWithImage3_android;
	@FindBy(xpath = "") public MobileElement productWithName3_android;
	@FindBy(xpath = "") public MobileElement productRating3_android;
	@FindBy(xpath = "") public MobileElement productPriceWithDiscouunt3_android;
	@FindBy(xpath = "") public MobileElement productPriceWithoutDiscouunt3_android;
	
	//Other exciting offers
	@FindBy(xpath = "") public MobileElement offersOption1_android;
	@FindBy(xpath = "") public MobileElement offersOption2_android;
	@FindBy(xpath = "") public MobileElement offersOption3_android;
	@FindBy(xpath = "") public MobileElement offersOption4_android;
	
	// Your favourite electronics brands
	@FindBy(xpath = "") public MobileElement brandIcon1_android;
	@FindBy(xpath = "") public MobileElement brandIcon2_android;
	@FindBy(xpath = "") public MobileElement brandIcon3_android;
	@FindBy(xpath = "") public MobileElement brandIcon4_android;
	@FindBy(xpath = "") public MobileElement brandIcon5_android;
	@FindBy(xpath = "") public MobileElement brandIcon6_android;
	@FindBy(xpath = "") public MobileElement brandIcon7_android;
	@FindBy(xpath = "") public MobileElement brandIcon8_android;
	
	// Buying guides
	@FindBy(xpath = "") public MobileElement buyingGuideOption1_android;
	@FindBy(xpath = "") public MobileElement buyingGuideOption2_android;
	@FindBy(xpath = "") public MobileElement buyingGuideOption3_android;
	
	//Buttons Buy Now, Add to Cart
	@FindBy(xpath = "") public MobileElement buyNowButton_android;
	@FindBy(xpath = "") public MobileElement addToCartButton_android;
	
	
	/*===============================
	  		Frame3
	  ===============================
	 */
	
	// Mobile phones shop by price
	@FindBy(xpath = "") public MobileElement priceRange1_android;
	@FindBy(xpath = "") public MobileElement priceRange2_android;
	@FindBy(xpath = "") public MobileElement priceRange3_android;
	@FindBy(xpath = "") public MobileElement priceRange4_android;
	
	// Shop by brands
	@FindBy(xpath = "") public MobileElement selectBrand1_android;
	@FindBy(xpath = "") public MobileElement selectBrand2_android;
	@FindBy(xpath = "") public MobileElement selectBrand3_android;
	@FindBy(xpath = "") public MobileElement selectBrand4_android;
	
	//











	
	
	

}
