package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyAccount_TCPHomePage_Mobile extends BaseScript{

	public MyAccount_TCPHomePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	
	//Android Locators	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivTcpLogo']") public MobileElement tcpAppLogo_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvUserRewards']") public MobileElement uRewardsTxt_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvUserPoints']") public MobileElement uRewardsPoints_android;	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnChannelAlert']") public MobileElement channelsBtn_android;
	@FindBy(xpath = "//*[@text='Alerts']") public MobileElement alertsTxt_android;
	@FindBy(xpath = "//*[@text='Tata Pay']") public MobileElement tPayBtn_android;
	@FindBy(xpath = "//*[@text='Bills']") public MobileElement billPayBtn_android;
	@FindBy(xpath = "//*[@text='Finance']") public MobileElement financialsBtn_android;
	@FindBy(xpath = "//*[@text='Orders']") public MobileElement othersBtn_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/iv_back'] | //*[@resource-id='com.tatadigital.tcp.dev:id/imgBack'] | //*[@resource-id='com.tatadigital.tcp.dev:id/btnBackOfferZone'] | //*[@resource-id='com.tatadigital.tcp.dev:id/ivOrderBack'] | //*[@resource-id='com.tatadigital.tcp.dev:id/ivBack']") public MobileElement backBtn_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnClose'] | //*[@resource-id='com.tatadigital.tcp.dev:id/ivCloseToolbarModal'] | //*[@resource-id='com.tatadigital.tcp.dev:id/ivClose']") public MobileElement closeBtn_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu']|//*[@resource-id='com.tatadigital.tcp:id/ivHamburgerMenu']") public MobileElement hamBurgerMenuBtn_android;	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/carouselRecyclerView']") public MobileElement heroBannerSection_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/carouselRecyclerView']/*)[1]/*/*[3]") public MobileElement firstHerobannerNameTxt_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/carouselRecyclerView']/*)[2]/*/*[3]") public MobileElement secondHerobannerNameTxt_android;	
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/carouselRecyclerView']/*)[1]/*/*[4]") public MobileElement firstHerobannerDescrpTxt_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/carouselRecyclerView']/*)[1]/*/*[4]") public MobileElement secondHerobannerDescrpTxt_android;	
	@FindBy(xpath = "//*[contains(@text,'Insurance')]") public List<MobileElement> insuarnceHeroBannerTabs_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvNameOfOffering']") public MobileElement bannerOfferNameTxt_android;	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvTataPayRibbon']/../..") public MobileElement tataPayRibbon_android;
	@FindBy(xpath = "//*[@text='Scan & pay']/..") public MobileElement scanAndPayIcon_android;	
	@FindBy(xpath = "//*[@text='Send Money']/..") public MobileElement requestIcon_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvTitle']") public MobileElement requestPageHeaderTxt_android;	
	@FindBy(xpath = "//*[@text='Pay bills']/..") public MobileElement payBillsIcon_android;
	@FindBy(xpath = "//*[@text='Bill Payment'] | //*[@text='Pay Bills']") public MobileElement billPaymentTxt_android;
	@FindBy(xpath = "//*[@text='Recharges']") public MobileElement rechargesTxt_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/rvCategoryItems']") public MobileElement billPayCategoryIconSection_android;
	@FindBy(xpath = "//*[@text='Recent Bills']") public MobileElement recentBillsBtn_android;
	@FindBy(xpath = "//*[@text='Billers']") public MobileElement billersBtn_android;
	@FindBy(xpath = "//*[@text='Add New Bill']") public MobileElement addNewBillBtn_android;		
	@FindBy(xpath = "//*[@text='DTH Services']/..") public MobileElement dthServicesIcon_android;
	@FindBy(xpath = "//*[@text='Finance']") public MobileElement financeIcon_android;
	@FindBy(xpath = "//*[@text='Send money']/..") public MobileElement sendMoneyIcon_android;
	@FindBy(xpath = "//*[@text='Shop now']") public MobileElement shopNowTxt_android;
	@FindBy(xpath = "//*[@text='Shop & explore']/following-sibling::*") public MobileElement shopAndExploreSection_android;
	@FindBy(xpath = "//*[@text='Shop now']/following-sibling::*/*") public List<MobileElement> shopNowElements_android;	
	@FindBy(xpath = "//*[@text='Select Services']") public MobileElement selectServicesTxt_android;
	@FindBy(xpath = "//*[@text='Select Services']/following-sibling::*") public MobileElement selectServicesSection_android;
	@FindBy(xpath = "//*[@text='Select Services']/following-sibling::*/*") public List<MobileElement> selectServicesElements_android;	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/bottomNav']") public MobileElement btmNavBar_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivBack']") public MobileElement backButtoninsideSearch;
	@FindBy(xpath = "//*[@text='Home']") public MobileElement homeBtn_navBar_android;
	@FindBy(xpath = "//*[@text='Offers']") public MobileElement offerZoneBtn_navBar_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivSearchMenu']") public MobileElement searchBtn_navBar_android;
	@FindBy(xpath = "//*[@text='Rewards']") public MobileElement rewardsBtn_navBar_android;
	@FindBy(xpath = "//*[@text='NeuMag'] | //*[@text='Explore']") public MobileElement UMagBtn_navBar_android;
	@FindBy(xpath = "//*[@text='Vault']") public MobileElement vaultBtn_navBar_android;	
	@FindBy(xpath = "//*[@text='Flip the page']") public MobileElement flipThePage_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvOfferZoneTitle']") public MobileElement offerZoneTitle_android;
	@FindBy(xpath = "//*[@text='View Details']") public MobileElement offerViewDtlsBtn_android;
	@FindBy(xpath = "//*[@text='Filter by categories']") public MobileElement filterByCategoriesTxt_android;
	@FindBy(xpath = "//*[@text='Explore Offers near you']") public MobileElement exploreOffersTxt_android;
	@FindBy(xpath = "(//*[@text='Bundles'])[1]") public MobileElement bundlesBtn_android;
	@FindBy(xpath = "//*[@text='Explore all bundles']") public MobileElement exploreAllBundlesTxt_android;
	
	@FindBy(xpath = "//*[contains(@text,'I am looking for')]") public MobileElement insideSearchHeaderTxt_android;
	@FindBy(xpath = "//*[contains(@text,'error!')] | //*[@text='Retry']") public MobileElement errorTxt_android;
	
	@FindBy(xpath = "//*[@text='NeuMag']") public MobileElement UMagInsideHeaderTxt_android;
	@FindBy(xpath = "//*[@text='Discover']") public MobileElement UMagInsideDiscoverBtn_android;
	@FindBy(xpath = "//*[@text='How To']") public MobileElement UMagInsideHowToBtn_android;
	@FindBy(xpath = "//*[@text='Most Popular']") public MobileElement UMagInsideMostPopularTxt_android;
	@FindBy(xpath = "//*[@text='Flip the page']") public MobileElement Txt_android;
	@FindBy(xpath = "//*[@text='Buying Guidence']") public MobileElement howToInsideBuyingGuideTxt_android;	
	@FindBy(xpath = "//*[@text='Fashion Basics']") public MobileElement fashionBasicsInsideHowTo_android;
	@FindBy(xpath = "//*[@text='Click. Pay. Go']") public MobileElement clickPayGoInsideHowTo_android;
	@FindBy(xpath = "//*[@text='Tatapay']") public MobileElement vaultInsideTataPayTxt_android;
	
	@FindBy(xpath = "//*[@text='Scan & pay']") public MobileElement scannpayTxt_android;
	@FindBy(xpath = "//*[@text='Request money']") public MobileElement requestMoneyTxt_android;
	@FindBy(xpath = "//*[@text='Send money']") public MobileElement sendMoneyTxt_android;
	@FindBy(xpath = "//*[@text='Approve requests']") public MobileElement approveRequestsTxt_android;
	@FindBy(xpath = "//*[@text='Check balance']") public MobileElement checkBalanceTxt_android;
	@FindBy(xpath = "//*[@text='Cards']") public MobileElement cardsTxt_android;
	//@FindBy(xpath = "//*[@text='Approve requests']") public MobileElement approveRequestsTxt_android;
	
	@FindBy(xpath = "//*[@text='UPI services']") public MobileElement vaultInsideupiServicesTxt_android;
	@FindBy(xpath = "//*[@text='Cards']") public MobileElement vaultInsideCardsTxt_android;	
	@FindBy(xpath = "//*[@text='Register Now']") public MobileElement registerNowInideVault_android;
	@FindBy(xpath = "//*[@text='Pay bills']") public MobileElement payBillsInideVault_android;
	@FindBy(xpath = "//*[@text='Pay bills']/following-sibling::*") public MobileElement payBillsSubTitleInideVault_android;
	@FindBy(xpath = "//*[@text='Tatapay Offers']") public MobileElement tatapayOffersInideVault_android;
	@FindBy(xpath = "//*[@text='Tatapay Offers']/following-sibling::*[1]") public MobileElement tPayOffersSubTitleInideVault_android;
	
	@FindBy(xpath = "//*[@text='Welcome to Tata Digita']") public MobileElement tataDigitalTextonCorpEmailScreen;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/etCorpEmailIdReferralCode']") public MobileElement corpEmailField_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tIInputPincode']") public MobileElement corpPinField_android;
	@FindBy(xpath = "//*[@text='Next']") public MobileElement NextTxtOnCorpScreen_android;
	@FindBy(xpath = "//*[@text='Coming to you soon']") public MobileElement coming2usoonTxtAfterCorpScreen_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtFirstNamePilot']") public MobileElement firstNameFieldaterCorpScreen_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/edtLastNamePilo']") public MobileElement lastNameFieldaterCorpScreen_android;
	
	
	
	@FindBy(xpath = "//*[@text='Curated for you']") public MobileElement curatedForYouTxt_android;
	//@FindBy(xpath = "//*[@text='Curated for you']/..") public MobileElement curatedForYouSection_android;
	@FindBy(xpath = "//*[@text='Just Out']") public MobileElement justOutTxt_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvJustOutSubtitle']") public MobileElement justOutSubtitleTxt_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvJustOutSubtitle']/following-sibling::*") public MobileElement justOutSection_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tvJustOutSubtitle']/following-sibling::*/*)[1]/*/*") public List<MobileElement> justOutOffersDtls_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tvJustOutSubtitle']/following-sibling::*/*)[1]") public MobileElement justOutFirstOfferTemplate_android;	
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tvJustOutSubtitle']/following-sibling::*/*)[1]/*/*[2]") public MobileElement justOutOfferName_android;
	@FindBy(xpath = "//*[@text='Trending Now']") public MobileElement trendingNowTxt_android;
	@FindBy(xpath = "//*[@text='Most popular reads & videos']") public MobileElement trendingNowSubtitleTxt_android;
	@FindBy(xpath = "//*[@text='Trending Now']/..") public MobileElement trendingNowSection_android;
	@FindBy(xpath = "//*[@text='Trending Now']/following-sibling::*[@text='See All']") public MobileElement seeAllTrendingNowBtn_android;
	@FindBy(xpath = "//*[@text='Bundles for every need']") public MobileElement bundleForEveryNeedTxt_android;
	@FindBy(xpath = "//*[@text='Bundles for every need']/..") public MobileElement bundleForEveryNeedSection_android;
	@FindBy(xpath = "//*[@text='Buy together,save more']") public MobileElement bundleForEveryNeedSubtitle_android;
	@FindBy(xpath = "//*[@text='Bundle bonanza']/following-sibling::*[@text='See All']") public MobileElement bundleBonanzaSeeAllBtn_android;	
	@FindBy(xpath = "//*[@resource-id ='com.android.permissioncontroller:id/permission_allow_button'] | //*[@text='ALLOW']") public MobileElement allowBtn_android;	
	@FindBy(xpath = "//*[@text='Profile']") public MobileElement profileTxt_android;
	@FindBy(xpath = "//*[@text='Addresses']") public MobileElement addressesTxt_android;
	@FindBy(xpath = "//*[@text='Refer a friend']") public MobileElement referAFriendTxt_android;
	@FindBy(xpath = "//*[@text='Order History'] | (//*[@resource-id='com.tatadigital.tcp.dev:id/profileOptionsItemsLayout'])[3]") public MobileElement orderHistoryTxt_android;
	@FindBy(xpath = "//*[@text='Manage security']") public MobileElement manageSecurityTxt_android;
	@FindBy(xpath = "//*[@text='Help']") public MobileElement helpTxt_android;
	@FindBy(xpath = "//*[@text='Legal']") public MobileElement legalTxt_android;
	@FindBy(xpath = "//*[@text='Rate our app']") public MobileElement rateOurAppTxt_android;
	@FindBy(xpath = "//*[@text='Sign out']") public MobileElement signOutTxt_android;	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/itemProfileOptionsImgClose']") public MobileElement manageSecurityDownArrow_android;
	@FindBy(xpath = "//*[@text='Change password']") public MobileElement changePwd_android;
	@FindBy(xpath = "//*[@text='Sign out of all devices & linked apps']") public MobileElement signOutAllDevicesBtn_android;
	@FindBy(xpath = "//*[contains(@text,'all devices & linked apps?')]") public MobileElement signOutAllDevicesPopUpTxt_android;
	@FindBy(xpath = "//*[@text='No']") public MobileElement signOutAllDevicesPopUpNoBtn_android;	
	@FindBy(xpath = "//*[@text='Orders']") public MobileElement ordersSection_android;
	@FindBy(xpath = "//*[@text='Transactions']") public MobileElement TransactionSection_android;
	@FindBy(xpath = "//*[@text='Track all your commerce, across brands in one place']/..") public MobileElement allBrandsOrders_android;	
	@FindBy(xpath = "//*[@text='Enjoy the freedom of cashless life']") public MobileElement alertsTpayInsideTxt_android;
	@FindBy(xpath = "//*[@text='We are making Bill Payments fun!']") public MobileElement alertsBillpayInsideTxt_android;
	@FindBy(xpath = "//*[@text='Let�s uncomplicate finance']") public MobileElement alertsFinancialsInsideTxt_android;
	@FindBy(xpath = "//*[@text='Welcome to Croma!']") public MobileElement alertsOthersInsideTxt_android;
	@FindBy(xpath = "//*[@text='Know more'] | //*[@text='Shop now']") public MobileElement textInsideHerBanner_android;
	@FindBy(xpath = "//*[@text='Number Verification']") public MobileElement numberVerifiTxtInsideRequest_android;
	
	@FindBy(xpath = "//*[@text='Essentials']") public MobileElement essentials_shopNow_android;
	@FindBy(xpath = "//*[@text='Grocery']") public MobileElement grocery_shopNow_android;
	@FindBy(xpath = "//*[@text='Electronics']") public MobileElement electronics_shopNow_android;
	@FindBy(xpath = "//*[@text='Fashion']") public MobileElement fashion_shopNow_android;
	@FindBy(xpath = "//*[@text='Luxury']") public MobileElement luxury_shopNow_android;
	@FindBy(xpath = "//*[@text='Beauty']") public MobileElement beauty_shopNow_android;
	@FindBy(xpath = "//*[@text='Fitness']") public MobileElement fitness_shopNow_android;
	@FindBy(xpath = "//*[@text='Grocery']") public MobileElement grocery_insideGrocery_android;
	@FindBy(xpath = "//*[@text='Shop Now']") public MobileElement shopNowBtn_insideEssentials_android;
	@FindBy(xpath = "//*[@text='Fashion']") public MobileElement fashionSLP_insideFashion_android;
	@FindBy(xpath = "//*[@text='Beauty']") public MobileElement beautySLP_insideBeauty_android;
	@FindBy(xpath = "//*[@text='Fitness']") public MobileElement fitnessSLP_insideActiveLife_android;
	@FindBy(xpath = "//*[@text='Flights']") public MobileElement flights_SS_android;
	@FindBy(xpath = "//*[@text='Hotels']") public MobileElement hotels_SS_android;
	@FindBy(xpath = "//*[@text='Entertainment']") public MobileElement entertainment_shopNow_android;
	@FindBy(xpath = "//*[@text='F&B']") public MobileElement fnb_shopNow_android;
	@FindBy(xpath = "//*[@text='Smartphones']") public MobileElement smartphones_shopNow_android;
	@FindBy(xpath = "//*[@text='Finance']") public MobileElement finance_SS_android;
	@FindBy(xpath = "//*[@text='Food']") public MobileElement food_SS_android;
	@FindBy(xpath = "//*[@text='Hotel SLP']") public MobileElement hotelSLP_insideHotels_android;
	@FindBy(xpath = "//*[@text='Book Now']") public MobileElement bookNowBtn_insideHotels_android;
	@FindBy(xpath = "//*[@text='Book a Stay']") public MobileElement bookStay_insideHotels_android;
	@FindBy(xpath = "//*[@text='Reserve a table']") public MobileElement reserverTable_insideHotels_android;
	@FindBy(xpath = "//*[@text='Loans']") public MobileElement loans_insideFinance_android;
	@FindBy(xpath = "//*[@text='Money']") public MobileElement moneyHdr_insideFinance_android;
	@FindBy(xpath = "//*[@text='Insurance']") public MobileElement insurance_insideFinance_android;
	@FindBy(xpath = "//*[@text='Food & Beverage']") public MobileElement foodHdr_insideFood_android;
	@FindBy(xpath = "//*[@text='Starbucks Offers']") public MobileElement starbucksOffer_insideFood_android;
	@FindBy(xpath = "//*[@text='Offers from Qmin']") public MobileElement qminOffer_insideFood_android;
	@FindBy(xpath = "//*[@text='Handpicked for you']") public MobileElement handpickedForYourTxt_android;
	@FindBy(xpath = "//*[@text='Curated for you']/..") public MobileElement curatedForYouSection_android;
	
	@FindBy(xpath = "//*[@text='Just in']/..") public MobileElement justInSection_android;
	@FindBy(xpath = "//*[@text='Curated for you']/following-sibling::*[@text='See All']") public MobileElement seeAllBtn_curatedForYou_android;
	
	@FindBy(xpath = "//*[@text='Exclusive offers']") public MobileElement exclusiveOffersTxt_android;
	@FindBy(xpath = "//*[@text='Exclusive offers']/..") public MobileElement exclusiveOffersForYouSection_android;
	
	@FindBy(xpath = "//*[@text=\"Offers & bundles you shouldn't miss\"]") public MobileElement dealsULikeSubtitleTxt_android;
	
	
	
	

	
	//** iOS Locators **
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@value='Enter phone number']") public MobileElement EnterPhoneNumber_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm']") public MobileElement ConfirmBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile']") public MobileElement profileTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Addresses']") public MobileElement addressesTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Refer a friend']") public MobileElement referAFriendTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Order History']") public MobileElement orderHistoryTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Manage security']") public MobileElement manageSecurityTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Help']") public MobileElement helpTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Legal']") public MobileElement legalTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Rate our app']") public MobileElement rateOurAppTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Sign out']") public MobileElement signOutTxt_ios;
	
	@FindBy(xpath = "(//XCUIElementTypeImage[@name='tcpApp.AccountList.sectionAccessoryImage'])[5]") public MobileElement manageSecurityDownArrow_ios; 
	@FindBy(xpath = "//XCUIElementTypeCell[@label='Sign out of all devices & linked apps']") public MobileElement signOutAllDevicesBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Are you sure you want to sign out of all devices & linked apps?']") public MobileElement signOutAllDevicesPopUpTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='No']") public MobileElement signOutAllDevicesPopUpNoBtn_ios;
	

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Orders']") public MobileElement ordersSection_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Transactions']") public MobileElement TransactionSection_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Track all your commerce, across brands in one place']/../..") public MobileElement allBrandsOrders_ios;	

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back'] | //XCUIElementTypeButton[@name='chevronLeft']") public MobileElement backBtn_ios;			
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.home.valutButton']") public MobileElement tcpAppLogo_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'U Rewards')]") public MobileElement uRewardsTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@label='homeBurgerMenu']") public MobileElement hamBurgerMenuBtn_ios;  //XCUIElementTypeButton[@name="tcpApp.home.scanButton"])[2]

	@FindBy(xpath = "//XCUIElementTypeButton[@label ='homeAlerts']") public MobileElement channelsBtn_ios;  //XCUIElementTypeButton[@name="tcpApp.home.scanButton"])[1]
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Tpay']") public MobileElement tPayBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bill Pay']") public MobileElement billPayBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Financials']") public MobileElement financialsBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Others']") public MobileElement othersBtn_ios;
	
	@FindBy(xpath = "//XCUIElementTypeImage[@name='tcpApp.home.StoryCarouselTypeCollectionCell.backGroundImageView'][3]/..") public MobileElement heroBannerSection_ios;
	
     @FindBy(xpath = "//XCUIElementTypeStaticText[@label='Scan & Pay']") public MobileElement scanAndPayIcon_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Request']") public MobileElement requestIcon_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Pay Bills']") public MobileElement payBillsIcon_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bill Payment']") public MobileElement billPaymentTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Recharges']") public MobileElement rechargesTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPPaymentsKit.CategoryView'] | //XCUIElementTypeButton[@name='crossWhite']") public MobileElement closeBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='paymentKit.repeatUser.recentBill']") public MobileElement recentBillsBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='paymentKit.repeatUser.billers']") public MobileElement billersBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='paymentKit.recentBill.addNewMiddle']") public MobileElement addNewBillBtn_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='DTH Services']") public MobileElement dthServicesIcon_ios;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Home']") public MobileElement homeBtn_navBar_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Offer Zone']") public MobileElement offerZoneBtn_navBar_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Search']") public MobileElement searchBtn_navBar_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='UMag']") public MobileElement UMagBtn_navBar_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Vault']") public MobileElement vaultBtn_navBar_ios;					
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.PaymentsVault']") public MobileElement vaultInsideTataPayTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI services']") public MobileElement vaultInsideupiServicesTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Cards']") public MobileElement vaultInsideCardsTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Home']/..") public MobileElement btmNavBar_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Offers & Bundles']") public MobileElement offerZoneTitle_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Filter by categories']") public MobileElement filterByCategoriesTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Offers']") public MobileElement offersBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bundles']") public MobileElement bundlesBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='There was an error!']") public MobileElement errorTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Search']") public MobileElement insideSearchHeaderTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Shop now']") public MobileElement insideSearchShopNowTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Services']") public MobileElement insideSearchSelectService_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='U Mag']") public MobileElement UMagInsideHeaderTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Discover']") public MobileElement UMagInsideDiscoverBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='How To']") public MobileElement UMagInsideHowToBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Most Popular']") public MobileElement UMagInsideMostPopularTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeImage[@name='bookmarkIcon']") public MobileElement bookmarkIconImg_ios;
	@FindBy(xpath = "//XCUIElementTypeImage[@name='searchIcon']") public MobileElement searcIconImg_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='tcpApp.home.GridTypeTableViewCell.headerTitle'])[1]") public MobileElement shopNowSection_ios;
	@FindBy(xpath = "(//XCUIElementTypeImage[@name='tcpApp.home.GridTypeCollectionViewCell.mainImageView'])[1]/..") public List<MobileElement> shopNowElements_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'points')]") public MobileElement uRewardsPoints_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.home.StoryCarouselTypeTableViewCell']") public MobileElement herobannerSection_ios;
	@FindBy(xpath = "//XCUIElementTypeImage[@name='tcpApp.home.StoryCarouselTypeCollectionCell.backGroundImageView'][3]") public MobileElement firstHeroBanner_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Select Services']") public MobileElement selectServicesSection_ios;
	@FindBy(xpath = "(//XCUIElementTypeImage[@name='tcpApp.home.GridTypeCollectionViewCell.mainImageView'])[10]") public List<MobileElement> selectServicesElements_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Just out']/..") public MobileElement justOutSection_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Trending Now']/following-sibling::XCUIElementTypeCell[1]") public MobileElement trendingNowSection_ios;
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='tcpApp.home.HandPickedSectionHeader'])[1]/following-sibling::*[1]") public MobileElement trendingNowTemplate_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.home.HorizontalCarouselTypeThreeTableCell']") public MobileElement trendingNow_horizontalCars_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Bundle bonanza']/..") public MobileElement bundleBonanzaSection_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Bundle bonanza']/../XCUIElementTypeImage") public MobileElement bundleBonanza_horizontalCars_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Handpicked for you']/following-sibling::*[1]") public MobileElement handPickedSection_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@label='Profile'])[1]") public MobileElement profileBtn_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[1]/XCUIElementTypeTextField[1]") public MobileElement firstNameTxtField_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[2]/XCUIElementTypeTextField[1]") public MobileElement lastNameTxtField_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='tcpApp.formVC.phoneNumber']") public MobileElement phoneNumberFirld_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Me at a glance'])[1]") public MobileElement myProfilePgHdrTxt_ios;
	@FindBy(xpath = "//*[@label='Allow Once'] | //*[@label='ALLOW']") public MobileElement allowBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Scan & Pay']/..") public MobileElement tataPayRibbon_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='close']") public MobileElement popUPCloseBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Tata Sky']") public MobileElement tataSkyTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Are you a Tata Sky Customer?']") public MobileElement tataSkyCustomerTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Existing Customer']") public MobileElement exsitingCustomerTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Get Tata Sky']") public MobileElement getTataSkyTxt_ios;

	@FindBy(xpath ="//*[@label='Essentials']") public MobileElement essentials_shopNow_ios;
	@FindBy(xpath ="//*[@label='Electronics']") public MobileElement electronics_shopNow_ios;
	@FindBy(xpath ="//*[@label='Fashion']") public MobileElement fashion_shopNow_ios;
	@FindBy(xpath ="//*[@label='Luxury']") public MobileElement luxury_shopNow_ios;
	@FindBy(xpath ="//*[@label='Beauty']") public MobileElement beauty_shopNow_ios;
	@FindBy(xpath ="//*[@label='Active Life']") public MobileElement activeLife_shopNow_ios;
	
	@FindBy(xpath ="//*[@label='Flights']") public MobileElement flights_SS_ios;
	@FindBy(xpath ="//*[@label='Hotels']") public MobileElement hotels_SS_ios;
	@FindBy(xpath ="//*[@label='Finance']") public MobileElement finance_SS_ios;
	@FindBy(xpath ="//*[@label='Food']") public MobileElement food_SS_ios;
	
	@FindBy(xpath ="//XCUIElementTypeStaticText[@label='Deals You Might Like']/..") public MobileElement dealsULikeSection_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Send Money']") public MobileElement sendMoneyIcon_ios;

	
	//UMag
	@FindBy(xpath ="//*[contains(@text,'U Mag')]") public MobileElement UMag_navigation;
	@FindBy(xpath ="//*[contains(@text,'Discover')]") public MobileElement Discover_tab;
	
	//Tech digest
	@FindBy(xpath ="//*[contains(@text,'Tech digest')]") public MobileElement techdigest_icon;
	@FindBy(xpath ="//*[contains(@text,'Smart living')]") public MobileElement smartliving_text;
	@FindBy(xpath ="//*[contains(@text,'Smart living')]/following::android.view.View") public MobileElement smartliving_widget;
	@FindBy(xpath ="//*[contains(@text,'Trending now')]") public MobileElement trendingnow_text;
	@FindBy(xpath ="//*[contains(@text,'Trending now')]/following::android.view.View[2]") public MobileElement trendingnow_widget;
	@FindBy(xpath ="//*[contains(@text,'Learn more about tech')]") public MobileElement learnmoreabouttech_text;
	@FindBy(xpath ="//*[contains(@text,'Learn more about tech')]/following::android.view.View[2]") public MobileElement learnmoreabouttech_widget;
	@FindBy(xpath ="//*[contains(@text,'Choose your gadget')]") public MobileElement chooseyourgadget_text;
	@FindBy(xpath ="//*[contains(@text,'Choose your gadget')]/following::android.view.View[2]") public MobileElement chooseyourgadget_widget;
	
	//Travelogues
	@FindBy(xpath ="//*[contains(@text,'Travelogues')]") public MobileElement travelogues_icon;
	@FindBy(xpath ="//*[contains(@text,'City delights')]") public MobileElement citydelights_text;
	@FindBy(xpath ="//*[contains(@text,'City delights')]/following::android.view.View") public MobileElement citydelights_widget;
	@FindBy(xpath ="//*[contains(@text,'Trending now')]") public MobileElement trendingnow_travel_text;
	@FindBy(xpath ="//*[contains(@text,'Trending now')]/following::android.view.View[2]") public MobileElement trendingnow_travel_widget;
	@FindBy(xpath ="//*[contains(@text,'Next Workation')]") public MobileElement nextworkstation_text;
	@FindBy(xpath ="//*[contains(@text,'Next Workation')]/following::android.view.View[2]") public MobileElement nextworkstation_widget;
	@FindBy(xpath ="//*[contains(@text,'Experience culture')]") public MobileElement experienceculture;
	@FindBy(xpath ="//*[contains(@text,'Experience culture')]/following::android.view.View[2]") public MobileElement experienceculture_widget;
	
	//Food bytes
	@FindBy(xpath ="//*[contains(@text,'Food bytes')]") public MobileElement foodbytes_icon;
	@FindBy(xpath ="//*[contains(@text,'Just for kids')]") public MobileElement justforkids_text;
	@FindBy(xpath ="//*[contains(@text,'Just for kids')]/following::android.view.View") public MobileElement justforkids_widget;
	@FindBy(xpath ="//*[contains(@text,'Trending now')]") public MobileElement trendingnow_food_text;
	@FindBy(xpath ="//*[contains(@text,'Trending now')]/following::android.view.View[2]") public MobileElement trendingnow_food_widget;
	@FindBy(xpath ="//*[contains(@text,'Cook at home')]") public MobileElement cookathome_text;
	@FindBy(xpath ="//*[contains(@text,'Cook at home')]/following::android.view.View[2]") public MobileElement cookathome_widget;
	@FindBy(xpath ="//*[contains(@text,'Know your food')]") public MobileElement knowyourfood;
	@FindBy(xpath ="//*[contains(@text,'Know your food')]/following::android.view.View[2]") public MobileElement knowyourfood_widget;
	@FindBy(xpath ="//*[contains(@text,'in season')]") public MobileElement whatisinseason;
	@FindBy(xpath ="//*[contains(@text,'in season')]/following::android.view.View[2]") public MobileElement whatisinseason_widget;
	
	//Style files
	@FindBy(xpath ="//*[contains(@text,'Style files')]") public MobileElement stylefiles_icon;
	@FindBy(xpath ="//*[contains(@text,'Luxe station')]") public MobileElement luxestation_text;
	@FindBy(xpath ="//*[contains(@text,'Luxe station')]/following::android.view.View") public MobileElement luxestation_widget;
	@FindBy(xpath ="//*[contains(@text,'Trending now')]") public MobileElement trendingnow_style_text;
	@FindBy(xpath ="//*[contains(@text,'Trending now')]/following::android.view.View[2]") public MobileElement trendingnow_style_widget;
	@FindBy(xpath ="//*[contains(@text,'Beauty secrets')]") public MobileElement beautysecret_text;
	@FindBy(xpath ="//*[contains(@text,'Beauty secrets')]/following::android.view.View[2]") public MobileElement beautysecret_widget;
	@FindBy(xpath ="//*[contains(@text,'Trend alert')]") public MobileElement trendalert;
	@FindBy(xpath ="//*[contains(@text,'Trend alert')]/following::android.view.View[2]") public MobileElement trendalert_widget;
	
	@FindBy(xpath ="//*[contains(@text,'searchIcon')]") public MobileElement UMag_search;
	@FindBy(xpath ="//*[@text='search icon']/following::android.widget.EditText") public MobileElement UMag_searchbox;
	@FindBy(xpath ="//*[contains(@text,'results found')]/following::android.view.View[2]") public MobileElement trending_search;
	@FindBy(xpath ="//*[contains(@text,'No result found')]") public MobileElement noresultfound_search;
	@FindBy(xpath ="//*[@resource-id='suggestion0']") public MobileElement autosuggestion_search;
	@FindBy(xpath ="//*[@text='Recent searches']/following::android.view.View[1]") public MobileElement recent_search;
	
	
	@FindBy(xpath ="//*[contains(@text,'Featured stories')]") public MobileElement featuredstories;
	@FindBy(xpath ="//*[contains(@text,'Featured stories')]/following::android.view.View[2]") public MobileElement featuredstories_widget;
	@FindBy(xpath ="//*[contains(@text,'Handpicked reads for you')]") public MobileElement handpicksreads;
	@FindBy(xpath ="//*[contains(@text,'Handpicked reads for you')]/following::android.view.View[2]") public MobileElement handpicksreads_widget;
	@FindBy(xpath ="//*[contains(@text,'Self care guide')]") public MobileElement selfcareguide;
	@FindBy(xpath ="//*[contains(@text,'Self care guide')]/following::android.view.View[2]") public MobileElement selfcareguide_widget;
	@FindBy(xpath ="//*[contains(@text,'Fitness check')]") public MobileElement fitnesscheck;
	@FindBy(xpath ="//*[contains(@text,'Fitness check')]/following::android.view.View[2]") public MobileElement fitnesscheck_widget;
	@FindBy(xpath ="//*[contains(@text,'Stay in vogue')]") public MobileElement stayinvouge;
	@FindBy(xpath ="//*[contains(@text,'Stay in vogue')]/following::android.view.View[2]") public MobileElement stayinvouge_widget;
	
	@FindBy(xpath ="//*[contains(@text,'How')]") public MobileElement howToButton;
	@FindBy(xpath ="//*[contains(@text,'Know your gadgets')]/following::android.view.View[2]") public MobileElement knowYourGadgetsSection;
	@FindBy(xpath ="//*[contains(@text,'Watch and learn')]/following::android.view.View[2]") public MobileElement watchAndLearnSection;
	@FindBy(xpath ="//*[contains(@text,'TCP basics')]/following::android.view.View[2]") public MobileElement tcpBasicsSection;
	@FindBy(xpath ="//*[contains(@text,'Fashion basics')]/following::android.view.View[2]") public MobileElement fashionBasicsSection;
	@FindBy(xpath ="//*[contains(@text,'Travel like a pro')]/following::android.view.View[2]") public MobileElement travelLikeAProSection;
	
	@FindBy(xpath ="//*[contains(@text,'Sort by')]") public MobileElement sortby_button;
	@FindBy(xpath ="//*[contains(@text,'Relevance')]") public MobileElement relevance_button;
	@FindBy(xpath ="//*[contains(@text,'Newest')]") public MobileElement newest_button;
	
	@FindBy(xpath ="//*[contains(@text,'Filter')]") public MobileElement filter_button;
	@FindBy(xpath ="//*[contains(@text,'Category')]") public MobileElement category_button;
	@FindBy(xpath ="//*[contains(@text,'Content type')]") public MobileElement content_type_button;
	
	@FindBy(xpath ="(//*[contains(@text,'Filters')])[2]/following::android.view.View[1]") public MobileElement close_button;
	
	
	//@FindBy(xpath ="//*[contains(@text,'Know your gadgets')]/following::android.view.View[2]") public MobileElement knowYourGadgetsSection;
	
	
	@FindBy(xpath = "com.tatadigital.qmin:id/imgDismiss") public MobileElement dismissMessage_android;
	@FindBy(xpath = "//*[contains(@text,'Hello')]") public MobileElement qminName_android;
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.widget.TextView") public MobileElement Offer_android;
	
	
	
	
	
}
