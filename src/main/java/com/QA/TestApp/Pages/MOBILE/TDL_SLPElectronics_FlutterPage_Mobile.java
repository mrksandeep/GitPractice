package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_SLPElectronics_FlutterPage_Mobile {
	
	public TDL_SLPElectronics_FlutterPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	//for android element add "and" as prefix and for ios add "ios"
	
	/***** Android Element Locators *****/
	
	/*Electronics*/
	@FindBy(xpath = "//android.view.View[@content-desc='Electronics ']") public MobileElement ElectronicsHome_android;
	@FindBy(xpath = "(//android.view.View[@content-desc='Electronics ']/following::android.widget.Button)[1]") public MobileElement ElectronicsSearch_android;
	@FindBy(xpath = "(//android.view.View[@content-desc='Electronics ']/following::android.widget.Button)[2]") public MobileElement ElectronicsCart_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Earphone & headphones']") public MobileElement earphoneHeadphone_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Earphone & headphones']//android.widget.ImageView")}) public List<MobileElement> earphoneHeadphoneList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Speakers & soundbars']") public MobileElement speakerSoundbars_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Speakers & soundbars']//android.widget.ImageView")}) public List<MobileElement> speakerSoundbarsList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Laptops & Desktops')]") public MobileElement laptopSpeaker_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Laptops & Desktops')]//android.widget.ImageView")}) public List<MobileElement> laptopSpeakerList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Air Conditioners')]") public MobileElement airConditioners_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Air Conditioners')]//android.widget.ImageView")}) public List<MobileElement> airConditionersList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Small home appliances')]") public MobileElement smallHomeApp_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Small home appliances')]//android.widget.ImageView")}) public List<MobileElement> smallHomeAppList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Refrigerators']") public MobileElement referigetor_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Refrigerators']//android.widget.ImageView")}) public List<MobileElement> referigetorList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Tablets & digital pads')]") public MobileElement tabletsDigitalpads_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Tablets & digital pads')]//android.widget.ImageView")}) public List<MobileElement> tabletsDigitalpadsList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Products recommended for you']") public MobileElement productRecomm_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Products recommended for you']//android.widget.ImageView")}) public List<MobileElement> productRecommList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Offers running out soon')]") public MobileElement offerRunningOut_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Offers running out soon')]//android.widget.ImageView")}) public List<MobileElement> offerRunningOutList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Smartwatches')]") public MobileElement smartwatches_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Smartwatches')]//android.widget.ImageView")}) public List<MobileElement> smartwatchesList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'From categories you like')]") public MobileElement categoryUlike_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'From categories you like')]//android.widget.ImageView")}) public List<MobileElement> categoryUlikeList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Computer accessories')]") public MobileElement computerAccessories_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Computer accessories')]//android.widget.ImageView")}) public List<MobileElement> computerAccessoriesList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Still looking for these?')]") public MobileElement stillLooking_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Still looking for these?')]//android.widget.ImageView")}) public List<MobileElement> stillLookingList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'New launches')]") public MobileElement newLaunches_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'New launches')]//android.widget.ImageView")}) public List<MobileElement> newLaunchesList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Kitchen appliances')]") public MobileElement kitchenAppliances_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Kitchen appliances')]//android.widget.ImageView")}) public List<MobileElement> kitchenAppliancesList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Products you love on discount')]") public MobileElement productsOnDiscount_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Products you love on discount')]//android.widget.ImageView")}) public List<MobileElement> productsOnDiscountList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Inspired by products you viewed')]") public MobileElement inspiredProductsViewed_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Inspired by products you viewed')]//android.widget.ImageView")}) public List<MobileElement> inspiredProductsViewedList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Handpicked offers for you')]") public MobileElement handpickedOffers_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Handpicked offers for you')]//android.widget.ImageView")}) public List<MobileElement> handpickedOffersList_android;
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Accessories for you')]") public MobileElement accessoriesYou_android;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Accessories for you')]//android.widget.ImageView")}) public List<MobileElement> accessoriesYouList_android;
	
	/*Smartphones*/
	@FindBy(xpath = "//android.view.View[@content-desc='Smartphones']") public MobileElement SmartphonesHome_android;
	@FindBy(xpath = "(//android.view.View[@content-desc='Smartphones']/following::android.widget.Button)[1]") public MobileElement SmartphonesSearch_android;
	@FindBy(xpath = "(//android.view.View[@content-desc='Smartphones']/following::android.widget.Button)[2]") public MobileElement SmartphonesCart_android;
	
	/*FASHION*/
	@FindBy(xpath = "//android.view.View[@content-desc='Fashion']") public MobileElement FashHome_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Fashion']/following::android.widget.Button") public MobileElement FashSearch_android;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Fashion by Tata CLiQ']") public MobileElement fashionByTataCliq_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Fashion by Tata CLiQ']//android.widget.ImageView")}) public List<MobileElement> fashionByTataCliqList_android;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Exclusive Offers']") public MobileElement ExclusiveOffers_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Exclusive Offers']//android.widget.ImageView")}) public List<MobileElement> ExclusiveOffersList_android;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Your summer accessories fix']") public MobileElement YourSummerAcc_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Your summer accessories fix']//android.widget.ImageView")}) public List<MobileElement> YourSummerAccList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Casual comfort for the stylish man']")}) public MobileElement CasualComfort_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Casual comfort for the stylish man']//android.widget.ImageView")}) public List<MobileElement> CasualComfortList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Ethic wear by Westside']")}) public MobileElement EthicwearbyWestside_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Ethic wear by Westside']//android.widget.ImageView")}) public List<MobileElement> EthicwearbyWestsideList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Handpicked offers for you view all']")}) public MobileElement Handpickedoffers_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Handpicked offers for you view all']//android.widget.ImageView")}) public List<MobileElement> HandpickedoffersList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='The ethnic trend edit']")}) public MobileElement EthicTrendEdit_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='The ethnic trend edit']//android.widget.ImageView")}) public List<MobileElement> EthicTrendEditList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='New Launches']")}) public MobileElement NewLaunches_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='New Launches']//android.widget.ImageView")}) public List<MobileElement> NewLaunchesList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Trending offers View all']")}) public MobileElement Trendingoffers_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Trending offers View all']//android.widget.ImageView")}) public List<MobileElement> TrendingoffersList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Top brands on offer']")}) public MobileElement TopBrandsonOffer_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Top brands on offer']//android.widget.ImageView")}) public List<MobileElement> TopBrandsonOfferList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Comfort footwear for women']")}) public MobileElement ComfortFootwearforWomen_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Comfort footwear for women']//android.widget.ImageView")}) public List<MobileElement> ComfortFootwearforWomenList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Comfort footwear for men']")}) public MobileElement ComfortFootwearforMen_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Comfort footwear for men']//android.widget.ImageView")}) public List<MobileElement> ComfortFootwearforMenList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Sport these epic brands']")}) public MobileElement Sporttheseepicbrands_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Sport these epic brands']//android.widget.ImageView")}) public List<MobileElement> SporttheseepicbrandsList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Ensembles for kids']")}) public MobileElement EnsemblesforKids_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Ensembles for kids']//android.widget.ImageView")}) public List<MobileElement> EnsemblesforKidsList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Athleisure']")}) public MobileElement Athleisure_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Athleisure']//android.widget.ImageView")}) public List<MobileElement> AthleisureList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Your fit kit']")}) public MobileElement YourFitKit_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Your fit kit']//android.widget.ImageView")}) public List<MobileElement> YourFitKitList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Decorate your dream home']")}) public MobileElement DecorateyourdreamHome_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Decorate your dream home']//android.widget.ImageView")}) public List<MobileElement> DecorateyourdreamHomeList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Enjoy the latest stories from us']")}) public MobileElement EnjoyLatestStoriesfromUs_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Enjoy the latest stories from us']//android.widget.ImageView")}) public List<MobileElement> EnjoyLatestStoriesfromUsList_android;
	
	
	/*BEAUTY*/
	@FindBy(xpath = "//android.view.View[@content-desc='Beauty']") public MobileElement BeautyHome_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Beauty']/following::android.widget.Button") public MobileElement BeautySearch_android;
	
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Your Makeup Kit']")}) public MobileElement YourMakeupKit_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Your Makeup Kit']//android.widget.ImageView")}) public List<MobileElement> YourMakeupKitList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Top brands']")}) public MobileElement TopBrands_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Top brands']//android.widget.ImageView")}) public List<MobileElement> TopBrandsList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Best of Luxury Beauty']")}) public MobileElement BestofLuxuryBeauty_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Best of Luxury Beauty']//android.widget.ImageView")}) public List<MobileElement> BestofLuxuryBeautyList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Brands to Covet']")}) public MobileElement BrandstoCovet_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Brands to Covet']//android.widget.ImageView")}) public List<MobileElement> BrandstoCovetList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Pick Your Perfume Notes']")}) public MobileElement PickyourPerfumeNotes_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Pick Your Perfume Notes']//android.widget.ImageView")}) public List<MobileElement> PickyourPerfumeNotesList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='The fragrance boutique']")}) public MobileElement Fragnanceboutique_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='The fragrance boutique']//android.widget.ImageView")}) public List<MobileElement> FragnanceboutiqueList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Men's grooming special']")}) public MobileElement Mensgroomingspecial_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Men's grooming special']//android.widget.ImageView")}) public List<MobileElement> MensgroomingspecialList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='The men's corner']")}) public MobileElement MensCorner_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='The men's corner']//android.widget.ImageView")}) public List<MobileElement> MensCornerList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Summer skincare stars ']")}) public MobileElement Summerskincarestars_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Summer skincare stars ']//android.widget.ImageView")}) public List<MobileElement> SummerskincarestarsList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Browse by skin type']")}) public MobileElement BrowsebySkintype_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Browse by skin type']//android.widget.ImageView")}) public List<MobileElement> BrowsebySkintypeList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Best of skincare']")}) public MobileElement BestofSkincare_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Best of skincare']//android.widget.ImageView")}) public List<MobileElement> BestofSkincareList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Your ultimate haircare routine']")}) public MobileElement Ultimatehaircareroutine_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Your ultimate haircare routine']//android.widget.ImageView")}) public List<MobileElement> UltimatehaircareroutineList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Special price store']")}) public MobileElement SpecialPriceStore_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Special price store']//android.widget.ImageView")}) public List<MobileElement> SpecialPriceStoreList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Haircare heroes']")}) public MobileElement HaircareHeroes_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Haircare heroes']//android.widget.ImageView")}) public List<MobileElement> HaircareHeroesList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Bath and body basics']")}) public MobileElement BathandBodyBasics_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Bath and body basics']//android.widget.ImageView")}) public List<MobileElement> BathandBodyBasicsList_android;
	
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Enjoy the latest stories from us']")}) public MobileElement EnjoyLatestStoriesfromUsBeauty_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Enjoy the latest stories from us']//android.widget.ImageView")}) public List<MobileElement> EnjoyLatestStoriesfromUsBeautyList_android;
	
	
	
	
	//WestSide_Beauty
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Skincare by Westside']//android.widget.ImageView")}) public List<MobileElement> SkincarebyWestside_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Makeup by Westside']//android.widget.ImageView")}) public List<MobileElement> MakeupWestside_android;
	
	
	/*Westside*/
	@FindBy(xpath = "//android.view.View[@content-desc='Fashion by Westside']") public MobileElement fashionByWestside_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Fashion by Westside']//android.widget.ImageView")}) public List<MobileElement> fashionByWestsideList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='New In: Westside']") public MobileElement newInWestside_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='New In: Westside']//android.widget.ImageView")}) public List<MobileElement> newInWestsideList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Western wear by Westside']") public MobileElement westernWearWestside_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Western wear by Westside']//android.widget.ImageView")}) public List<MobileElement> westernWearWestsideList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Westside stories']") public MobileElement westsideStories_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Westside stories']//android.widget.ImageView")}) public List<MobileElement> westsideStoriesList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Brand for him by Westside']") public MobileElement brandForHimWestside_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Brand for him by Westside']//android.widget.ImageView")}) public List<MobileElement> brandForHimWestsideList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Home by Westside']") public MobileElement HomeWestside_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Home by Westside']//android.widget.ImageView")}) public List<MobileElement> HomeWestsideList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Discover brands at Westside']") public MobileElement brandsAtWestside_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Discover brands at Westside']//android.widget.ImageView")}) public List<MobileElement> brandsAtWestsideList_android;
	
	/*Entertainment*/
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='New connection']") public MobileElement newConn_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Manage your DTH connection']") public MobileElement manageDTHConn_android;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Recharge']") public MobileElement recharge_android;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Tata Play Binge']") public MobileElement binge_android;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Manage Pack']") public MobileElement managePack_android;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Box upgrade']") public MobileElement boxUpgrade_android;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Order showcase']") public MobileElement orderShowcse_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Entertainment']") public MobileElement entertainmentHomepage_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Offers unlocked for you']") public MobileElement offerUnlocked_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Offers unlocked for you']//android.widget.ImageView")}) public List<MobileElement> offerUnlockedList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Offers to keep you entertained']") public MobileElement offerEntertained_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Offers to keep you entertained']//android.widget.ImageView")}) public List<MobileElement> offerEntertainedList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Bite-sized videos']") public MobileElement bitSized_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Bite-sized videos']//android.widget.ImageView")}) public List<MobileElement> bitSizedList_android;
	@FindBy(xpath = "//android.view.View[@content-desc='Just in']") public MobileElement justIn_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Just in']//android.widget.ImageView")}) public List<MobileElement> justInList_android;
	
	
	
	
	//Smartphones
	@FindBy(xpath = "//android.view.View[@content-desc=\"Smartphones\"]") public MobileElement smartPhonesHomepageTitle_android;
	@FindBy(xpath = "//android.view.View[@content-desc=\"Smartphones\"]/following-sibling::android.widget.Button[1]") public MobileElement searchSmartPhones_android;
	@FindBy(xpath = "//android.view.View[@content-desc=\"Smartphones\"]/parent::android.view.View/following-sibling::android.view.View/child::android.view.View/descendant::android.view.View[1]") public MobileElement herobannerSmartPhones_android;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Best offers']") public MobileElement bestOffers_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Best offers']//android.widget.ImageView")}) public List<MobileElement> bestOffersList_android;
	
	@FindBy(xpath = "//android.view.View[@content-desc='More deals on top brands']") public MobileElement moreDealsonTopBrands_android;
    @FindAll({@FindBy(xpath = "//android.view.View[@content-desc='More deals on top brands']//android.widget.ImageView")}) public List<MobileElement> moreDealsonTopBrandsList_android;
    
	@FindBy(xpath = "//android.view.View[@content-desc='Just launched']") public MobileElement justLaunched_android;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Just launched']//android.widget.ImageView")}) public List<MobileElement> justLaunchedList_android;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Best smartphones: under Rs15,000']") public MobileElement bestSmartPhonesUnderRs15000;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Best smartphones: under Rs15,000']//android.widget.ImageView")}) public List<MobileElement> bestSmartPhonesUnderRs15000List_android;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Best phones: Rs15,000 - Rs25,000']") public MobileElement BestphonesRs15000ToRs25000;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Best phones: Rs15,000 - Rs25,000']//android.widget.ImageView")}) public List<MobileElement> BestphonesRs15000ToRs25000List_android;
	
	@FindBy(xpath = "//android.view.View[contains(@content-desc,'Best value premium phones: Rs25,000 - Rs40,000')]") public MobileElement bestValuePremiumPhonesRs25000ToRs40000;
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,'Best value premium phones: Rs25,000 - Rs40,000')]//android.widget.ImageView")}) public List<MobileElement> bestValuePremiumPhonesRs25000ToRs40000List_android;
	
	
	@FindBy(xpath = "//android.view.View[@content-desc='Best premium phones: above Rs40,000']") public MobileElement bestPremiumPhonesAboveRs40000;
	@FindAll({@FindBy(xpath = "//android.view.View[@content-desc='Best premium phones: above Rs40,000']//android.widget.ImageView")}) public List<MobileElement> bestPremiumPhonesAboveRs40000List_android;
	
	
	@FindAll({@FindBy(xpath = "//android.view.View[contains(@content-desc,\"Best premium phones\")]/descendant::android.widget.ImageView")}) public List<MobileElement> bestPremiumPhones_android;
	@FindAll({@FindBy(xpath = "//*[contains(@content-desc,'Top smartphones from')]/descendant::android.widget.ImageView")}) public List<MobileElement> topSmartPhones_android;

	
	
	@FindBy(xpath ="//*[@value='Return To the Merchant Site']") public WebElement btnReturntMerchantSite;
	@FindBy(xpath ="//*[@data-testid='message-success']") public WebElement Successmesg;
	@FindBy(xpath="//*[text()='Track status'] | //*[text()='Track booking']") public WebElement trackStatusOrder;
	
	
	
}
