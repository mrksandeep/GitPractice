package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import io.appium.java_client.MobileElement;

public class TcpHomePageMyAccount {

	@FindBy(xpath = "//*[@placeholder='Enter number'] | //*[@placeholder='Mobile number']")
	public WebElement mobileNoTextBox;
	@FindBy(xpath = "//button[contains(text(),'Confirm')] | //button[contains(text(),'Get OTP')]")
	public WebElement confirmBtn;
	@FindBy(xpath = "//div[@class='sc-gdKWHD gcWamn']/div/div[1]")
	public WebElement enterOtpTextbox;
	@FindBy(xpath = "//*[@alt='hamberger-icon']")
	public WebElement hamburgerMenuBtn;
	@FindBy(xpath = "//*[@data-testid='homenavbar'] | //div[@id='app']/div[2]/div[1]/div[4]/*[1]")
	public WebElement homeNavBar;
	@FindBy(xpath = "(//label[contains(text(),'Offers')])[1]")
	public WebElement offerZoneBtn;
	@FindBy(xpath = "(//label[contains(text(),'NeuMag')])[1]")
	public WebElement uMagBtn;
	@FindBy(xpath = "(//label[contains(text(),'Vault')])[1]")
	public WebElement vaultBtn;
	@FindBy(xpath = "//*[@alt='search-icon']")
	public WebElement searchBtn;

	@FindBy(xpath = "//*[text()='Offers & Bundles']")
	public WebElement offerZonePageTitle;
	@FindBy(xpath = "(//button/div[text()='Offers'])[1]")
	public WebElement offersBtn_insideOfferZone;
	@FindBy(xpath = "(//button/div[text()='Bundles'])[1]")
	public WebElement bundlesBtn_insideOfferZone;
	@FindBy(xpath = "//*[text()='Offers & Bundles']/../following-sibling::img")
	public WebElement bookmarkIcon_insideOfferZone;
	@FindBy(xpath = "(//div[@role='document'])[2]")
	public WebElement carouselSection_insideOZ;
	@FindBy(xpath = "//li[@data-index]")
	public List<WebElement> carouselNavIndexBtn_insideOZ;

	@FindBy(xpath = "//*[text()='Filter by category']/..")
	public WebElement filterByCatgSection_insideOZ;
	@FindBy(xpath = "//*[text()='Filter by category']/following-sibling::*//label")
	public List<WebElement> categories_insideOZ;
	@FindBy(xpath = "//*[text()='Trending offers']/../following-sibling::*")
	public WebElement trendingOffersSection_insideOZ;
	@FindBy(xpath = "//*[text()='Handpicked offers for you']/../following-sibling::*")
	public WebElement handpickedOffrsSection_insideOZ;
	@FindBy(xpath = "//*[text()='Offers disappearing soon']/../following-sibling::*")
	public WebElement offersDisappearingSoonSection_insideOZ;
	@FindBy(xpath = "//*[text()='Explore offers near you']")
	public WebElement exploreOfferNearU_insideOZ;
	@FindBy(xpath = "//*[text()='Explore all Bundles']")
	public WebElement exploreAllBundlesTxt_insideOZ;
	@FindBy(xpath = "//*[text()='Explore all Bundles']/following-sibling::*")
	public WebElement searchBundleIcon_insideOZ;
	@FindBy(xpath = "//*[text()='Explore all Bundles']/../following-sibling::*[2]")
	public WebElement bundlesCarousel_insdieOZ;
	@FindBy(xpath = "(//button[text()='Check it out'])[1]")
	public WebElement checkitOutBtn_insideOZ;

	@FindBy(xpath = "//*[@class='searchhambergiconsection'] | //div[@data-testid='page-header']/*")
	public WebElement backBtn;
	@FindBy(xpath = "//div[text()='Search']")
	public WebElement insideSearchHeaderTxt;
	@FindBy(xpath = "(//*[text()='Shop & Explore'])[2]")
	public WebElement insideSearchShopAndExploreTxt;
	@FindBy(xpath = "(//*[text()='Pick a service'])[2]")
	public WebElement insideSearchSelectService;
	@FindBy(xpath = "//*[contains(text(),'There was an error!')]")
	public WebElement errorTxt;
	@FindBy(xpath = "//*[@id='modal-close-button'] | //*[@id='profile-icon']/../../parent::div/div[1]//*[@fill-rule='evenodd']")
	public WebElement closeBtn;

	@FindBy(xpath = "(//*[text()='U Mag'])[2]")
	public WebElement headerTxt_insideExplore;
	@FindBy(xpath = "//*[text()='Discover']")
	public WebElement discoverBtn_insideExplore;
	@FindBy(xpath = "//*[text()='How-to']")
	public WebElement howToBtn_insideExplore;
	@FindBy(xpath = "//*[text()='Most Popular']")
	public WebElement mostPopularTxt_insideExplore;
	@FindBy(xpath = "//*[text()='Flip the page']/..")
	public WebElement flipThePageSection_insideExplore;
	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchField_insideExplore;
	@FindBy(xpath = "(//img[@alt='bookmarkIcon'])[2]")
	public WebElement bookmarkIcon_insideExplore;
	@FindBy(xpath = "//li/button")
	public List<WebElement> exploreCarouselNavBtn_insideExplore;
	@FindBy(xpath = "//*[text()='Trending now']/..")
	public WebElement trendingNow_insdieExplore;
	@FindBy(xpath = "//*[text()='Handpicked reads for you']/..")
	public WebElement handpickedReadsForYou_insdieExplore;
	@FindBy(xpath = "//*[text()='Follow us on instagram']/..")
	public WebElement followUsInstaSection_insideExplore;
	@FindBy(xpath = "//*[text()='Join us on Instagram']/..")
	public WebElement joinUsBtn_insideExplore;
	@FindBy(xpath = "//div[contains(text(),'found')]")
	public WebElement foundResults_insdieCZ;
	@FindBy(xpath = "//*[contains(text(),'find anything about')]")
	public WebElement noResultTxt_insideCZ;
	@FindBy(xpath = "//*[contains(text(),'Sort by')]/following-sibling::*")
	public WebElement searchResultsSortBy_incideCZ;
	@FindBy(xpath = "//*[contains(text(),'Sort by')]/following-sibling::*/../following-sibling::*")
	public WebElement sortByOptionSelection_insideCZ;

	@FindBy(xpath = "//*[text()='TataPay']")
	public WebElement tPayTxt_insideVault;
	@FindBy(xpath = "//*[contains(text(),'Cards')]")
	public WebElement cardsTxt_insideVault;
	@FindBy(xpath = "//*[contains(text(),'Saved Offers')]")
	public WebElement savedOffersTxt_insideVault;
	@FindBy(xpath = "//*[contains(text(),'Bill payments')]")
	public WebElement payBillsSection_insideVault;
	@FindBy(xpath = "//*[contains(text(),'Secure all')]/..")
	public WebElement cppInsuranceSection_insideVault;
	@FindBy(xpath = "//*[text()='UPI services']/..//*[text()='Download app']")
	public WebElement upiServiceDownloadApp_insideVault;
	@FindBy(xpath = "(//*[contains(text(),'Cards')]/..)[2]/following-sibling::*")
	public WebElement availablecards_insideVault;
	@FindBy(xpath = "//*[text()='Add new']")
	public WebElement addNewcard_insideVault;

	@FindBy(xpath = "//*[contains(text(),'Trending now')]")
	public WebElement trendingNowSection;
	@FindBy(xpath = "(//*[@class='Flex__Box-gYHGmq khHixM sc-eaHRBM eupezl'])[2]")
	public WebElement trendingNowTemplate;
	@FindBy(xpath = "(//*[@class='Flex__Box-gYHGmq khHixM sc-eaHRBM eupezl'])[2]/../div[2]")
	public WebElement trendingNow_horizontalCars;
	@FindBy(xpath = "//*[contains(text(),'Trending now')]/../following-sibling::div//*[text()='See all']")
	public WebElement seeAllTrendingNowBtn;
	@FindBy(xpath = "(//*[contains(text(),'Bundles')])[2]/../../../../..")
	public WebElement bundleBonanzaSection;
	@FindBy(xpath = "(//*[contains(text(),'Bundles')])[2]/../../../div[2]")
	public WebElement bundleBonanza_horizontalCars;
	@FindBy(xpath = "(//*[contains(text(),'Bundles')])[2]/../../../../div[2]")
	public WebElement bundleBonanzaSeeAllBtn;
	@FindBy(xpath = "//*[text()='Pick a service']")
	public WebElement selectServicesSection;
	@FindBy(xpath = "//*[text()='Pick a service']/following-sibling::div/* | (//*[text()='Select Services']/following-sibling::div)[2]/*")
	public List<WebElement> selectServicesElements;
	@FindBy(xpath = "//*[text()='Pick a service']/following-sibling::div/*//p[contains(text(),'')] | (//*[text()='Pick a service']/following-sibling::div)[2]/*//p[contains(text(),'')]")
	public List<WebElement> ssOptionsNameTxt;
	@FindBy(xpath = "//div[text()='Just in']")
	public WebElement justInTxt;
	@FindBy(xpath = "//div[text()='Just in']/../../following::div[1]")
	public WebElement justInSection;

	@FindBy(xpath = "//div[@data-testid='homenavbar']//img[@alt='app-logo'] | //div[@data-testid='homenavbar']/div/div[1]/a/*")
	public WebElement tcpAppLogo;
	@FindBy(xpath = "(//*[text()='Rewards'])")
	public WebElement uRewardsPoints;
	@FindBy(xpath = "//*[@alt='notification-icon']")
	public WebElement alertsIcon;
	@FindBy(xpath = "(//*[text()='Rewards'])[2]")
	public WebElement uRewardsHeaderTxt_insideURewards;
	@FindBy(xpath = "//*[contains(text(),'What your points can buy')]")
	public WebElement pointsCanBuyTxt_insideURewards;
	@FindBy(xpath = "//*[contains(text(),'privileges')]")
	public WebElement privileges_insideURewards;
	@FindBy(xpath = "//*[contains(text(),'Stories')]")
	public WebElement exclusiveStoriesTxt_insideURewards;
	@FindBy(xpath = "//*[text()='U Points']")
	public WebElement uPointsTxt_insideVault;
	@FindBy(xpath = "//*[text()='Points balance']")
	public WebElement pointStatus_insideVault;
	@FindBy(xpath = "//*[text()='points expiring']/preceding-sibling::*")
	public WebElement pointsExpiring_insideVault;
	@FindBy(xpath = "//*[text()='Your badges & privileges']")
	public WebElement myLoyaltyCardTxt_insideVault;
	@FindBy(xpath = "//*[text()='Your badges & privileges']/../following-sibling::div//*[text()='IHCL']")
	public WebElement ihclCard_insideVault;
	@FindBy(xpath = "//*[text()='Your badges & privileges']/../following-sibling::div//*[text()='Croma']")
	public WebElement cromaCard_insideVault;
	@FindBy(xpath = "//*[text()='Your badges & privileges']/../following-sibling::div//*[text()='AirAsia']")
	public WebElement airAsiaCard_insideVault;
	@FindBy(xpath = "//*[text()='Your badges & privileges']/../following-sibling::div//*[text()='Big Basket']")
	public WebElement bigBasketCard_insideVault;
	@FindBy(xpath = "//*[text()='Your badges & privileges']/../following-sibling::div//*[text()='Tata CliQ']")
	public WebElement tCliQCard_insideVault;

	@FindBy(xpath = "//h2[contains(text(),'Tata Pay')]")
	public WebElement tPayBtn_insideAlets;
	@FindBy(xpath = "//*[text()='Welcome to Tata Pay']/following-sibling::*")
	public WebElement tPayTabDtls_insideAlets;
	@FindBy(xpath = "//h2[contains(text(),'Bills')]")
	public WebElement billPayBtn_insideAlets;
	@FindBy(xpath = "//h1[contains(text(),'Bills')]/../../../../div[2]/div[2]")
	public WebElement billPaytabDtls_insideAlets;
	@FindBy(xpath = "//*[text()='Financials']")
	public WebElement financialsBtn_insideAlets;
	@FindBy(xpath = "(//*[contains(text(),'Tata Aig')]/following-sibling::*)[1]")
	public WebElement financialsTabDtls_insideAlets;
	@FindBy(xpath = "//*[text()='Orders']")
	public WebElement othersBtn_insideAlets;
	@FindBy(xpath = "//*[contains(text(),'Welcome')]/following-sibling::*")
	public WebElement othersTabDtls_insideAlets;

	@FindBy(xpath = "//div[@id='sidebar-container']/*")
	public List<WebElement> myAccountSection;

	@FindBy(xpath = "(//div[contains(text(),'Curated for you')])[1]")
	public WebElement dealsTxtParent;
	@FindBy(xpath = "//div[contains(text(),'Deals You Might Like')]")
	public WebElement dealsHeaderTxt;
	@FindBy(xpath = "//div[contains(text(),'Offers & bundles you shouldn’t miss')]")
	public WebElement dealsSubTitleTxt;
	@FindBy(xpath = "//div[contains(text(),'Deals You Might Like')]/../following-sibling::*//*[contains(text(),'See All')]")
	public WebElement dealsSeeAllBtn;
	@FindBy(xpath = "//div[contains(text(),'Deals You Might Like')]/../../following-sibling::*[1]")
	public WebElement dealsCaraousalSection;

	@FindBy(xpath = "(//*[text()='Shop & Explore'])")
	public WebElement shopNowTxt;
	@FindBy(xpath = "//*[contains(text(),'Shop')]/following-sibling::div/* | (//*[contains(text(),'Shop')]/following-sibling::div)[2]/*")
	public List<WebElement> shopNowElements;
	@FindBy(xpath = "//*[contains(text(),'Shop')]/following-sibling::div/*//p[contains(text(),'')] | (//*[contains(text(),'Shop')]/following-sibling::div)[2]/*//p[contains(text(),'')]")
	public List<WebElement> shopNowOptionsNameTxt;
	@FindBy(xpath = "//*[contains(text(),'Grocery')]")
	public WebElement GroceryShopNow;
	@FindBy(xpath = "//*[contains(text(),'Electronics')]")
	public WebElement electronicsShopNow;
	@FindBy(xpath = "//*[contains(text(),'Fashion')]")
	public WebElement fashionShopNow;
	@FindBy(xpath = "//*[contains(text(),'Luxury')]")
	public WebElement luxuryShopNow;
	@FindBy(xpath = "//*[contains(text(),'Beauty')]")
	public WebElement beautyShopNow;
	@FindBy(xpath = "//*[contains(text(),'Fitness')]")
	public WebElement activeLifeShopNow;
	@FindBy(xpath = "//*[contains(text(),'Recipes, tips & more')]")
	public WebElement essentialsPageHdr;
	@FindBy(xpath = "//*[contains(text(),'Top brands')]")
	public WebElement electronicsPageTitle;
	@FindBy(xpath = "//*[contains(text(),'Special price store')]")
	public WebElement fashionPageTitle;
	@FindBy(xpath = "//title[contains(text(),'Luxury')]")
	public WebElement luxuryPageTitle;
	@FindBy(xpath = "//*[contains(text(),'Beauty trends')]")
	public WebElement beautyPageTitle;
	@FindBy(xpath = "//*[contains(text(),'Shoe store')]")
	public WebElement activeLifePageTitle;

	@FindBy(xpath = "//div[@id='mainPage']")
	public WebElement tPayRibbon;
	@FindBy(xpath = "//div[@id='mainPage']/div/div[contains(text(),'')]")
	public List<WebElement> tPayElements;
	@FindBy(xpath = "//div[@id='mainPage']//*[text()='U Mag']/following-sibling::*[text()='Explore']")
	public WebElement Explore_desktop;
	@FindBy(xpath = "//div[@id='mainPage']//*[text()='Offer zone']/following-sibling::*[text()='View offers']")
	public WebElement offerZone_TPay_desktop;
	@FindBy(xpath = "//*[text()='Bill payments']/following-sibling::*[text()='Pay bills']")
	public WebElement payBills_TPay_desktop;
	@FindBy(xpath = "//*[text()='Finance']/following-sibling::*[text()='Know more']")
	public WebElement FinanceKnowMore_TPay_desktop;
	@FindBy(xpath = "//div[text()='Tata Sky']")
	public WebElement tataSkyHdr_dthSer;
	@FindBy(xpath = "//div[text()='Tata Sky']/..//*[contains(text(),'Tata Sky Customer')]")
	public WebElement tataSkySubTitleTxt_dthSer;
	@FindBy(xpath = "//div[text()='Tata Sky']/..//*[text()='Existing Customer']")
	public WebElement existingCust_dthSer;
	@FindBy(xpath = "//div[text()='Tata Sky']/..//*[text()='Get Tata Sky']")
	public WebElement newCust_dthSer;
	@FindBy(xpath = "//button[@id='modal-close-button']")
	public WebElement closeBtn_dthSer;

	@FindBy(xpath = "//div[@id='pay_ribbon_mobile']//*[contains(text(),'Scan & Pay')]")
	public WebElement scanAndPay_TPay_pwaMobile;
	@FindBy(xpath = "//div[@id='pay_ribbon_mobile']//*[contains(text(),'Send Money')]")
	public WebElement sendMoney_TPay_pwaMobile;
	@FindBy(xpath = "//div[@id='pay_ribbon_mobile']//*[contains(text(),'Pay Bills')]")
	public WebElement payBills_TPay_pwaMobile;
	@FindBy(xpath = "//div[@id='pay_ribbon_mobile']//*[contains(text(),'DTH Services')]")
	public WebElement dthServices_TPay_pwaMobile;

	@FindBy(xpath = "//*[contains(text(),'Shop')]/..//*[contains(text(),'Flights')]")
	public WebElement flights_SelectServices;
	@FindBy(xpath = "//*[contains(text(),'Shop')]/..//*[contains(text(),'Hotels')]")
	public WebElement hotels_SelectServices;
	@FindBy(xpath = "//*[contains(text(),'Shop')]/..//*[contains(text(),'Finance')]")
	public WebElement finance_SelectServices;
	@FindBy(xpath = "//*[contains(text(),'Shop')]/..//*[contains(text(),'Food')]")
	public WebElement food_SelectServices;
	@FindBy(xpath = "//title[contains(text(),'Flight')]")
	public WebElement flightPageTitle;
	@FindBy(xpath = "//*[contains(text(),'Most viewed stays')]")
	public WebElement hotelPageTitle;
	@FindBy(xpath = "//h1[contains(text(),'Finance')]")
	public WebElement financePageTitle;
	@FindBy(xpath = "//button[@role='tab']/*[contains(text(),'Loans')]")
	public WebElement loanTab_financeSection;
	@FindBy(xpath = "//button[@role='tab']/*[contains(text(),'Insurance')]")
	public WebElement insuranceTab_financeSection;
	@FindBy(xpath = "(//*[contains(text(),'Food')])[2]")
	public WebElement foodPageTitle;
	@FindBy(xpath = "(//*[contains(text(),'Starbucks')])[2]")
	public WebElement starbucksTxt;
	@FindBy(xpath = "(//*[contains(text(),'Qmin')])[2]")
	public WebElement qminTxt;

	@FindBy(xpath = "//div[@data-testid='homenavbar']/../../following-sibling::div[1]")
	public WebElement heroBannerSection;
	@FindBy(xpath = "//div[@data-testid='homenavbar']/../../following-sibling::div[1]/div[1]/div/div[2]/div[1]/h3")
	public WebElement heroBannerHeaderTxt;
	@FindBy(xpath = "(//*[@id='chevron-right-circle-b']/../..)[1]")
	public WebElement rightNavBtn_herobanner;
	@FindBy(xpath = "(//*[@id='chevron-left-circle-b']/../..)[1]")
	public WebElement leftNavBtn_herobanner;
	@FindBy(xpath = "//*[contains(text(),'Shop now')]")
	public WebElement shopNowOnHerobanner;
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	public WebElement closeBtn_herobannerSpecific;
	@FindBy(xpath = "(//*[text()='Croma'])[1]")
	public WebElement cromaTxt_fromHeroBanner;
	@FindBy(xpath = "//*[@title='Logo-Tata CLiQ']")
	public WebElement tataCliqTxt_fromHeroBanner;

	@FindBy(xpath = "//label[contains(text(),'Profile')]")
	public WebElement profileBtn;
	@FindBy(xpath = "//label[contains(text(),'Addresses')]")
	public WebElement addressesBtn;
	@FindBy(xpath = "//div[contains(text(),'Order history')]")
	public WebElement orderHistoryBtn;
	@FindBy(xpath = "//label[contains(text(),'Refer a friend')]")
	public WebElement referAFriendBtn;
	@FindBy(xpath = "//label[contains(text(),'Manage security')]")
	public WebElement manageSecurityBtn;
	@FindBy(xpath = "//label[contains(text(),'Help')]")
	public WebElement helpBtn;
	@FindBy(xpath = "//label[contains(text(),'Legal')]")
	public WebElement legalBtn;
	@FindBy(xpath = "//label[contains(text(),'Sign out')]")
	public WebElement signOutBtn;
	@FindBy(xpath = "//label[contains(text(),'Manage security')]/../../following-sibling::button[@role='button']")
	public WebElement securityDropdownBtn;
	@FindBy(xpath = "//label[contains(text(),'Change password')]")
	public WebElement changePasswordBtn_manageSecurity;
	@FindBy(xpath = "//label[contains(text(),'Sign out of all devices')]")
	public WebElement signOutOfAllDevicesBtn_manageSecurity;

	@FindBy(xpath = "//*[contains(text(),'Me at a glance')]")
	public WebElement pageHeaderTxt_myProfile;
	@FindBy(xpath = "//*[contains(text(),'Title')]/../following-sibling::div/button[@type='button']")
	public WebElement title_myProfile;
	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement firstNamefield_myProfile;
	@FindBy(xpath = "//input[@id='middleName']")
	public WebElement middleNamefield_myProfile;
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastNamefield_myProfile;
	@FindBy(xpath = "//*[contains(text(),'Gender')]/../following-sibling::div/button[@type='button']")
	public WebElement gender_myProfile;
	@FindBy(xpath = "//*[contains(text(),'Marital status')]/../following-sibling::div/button[@type='button']")
	public WebElement maritalStatus_myProfile;
	@FindBy(xpath = "//input[@id='dob']")
	public WebElement dobField_myProfile;
	@FindBy(xpath = "//input[@id='anniversaryDate']")
	public WebElement anniversaryDateField_myProfile;
	@FindBy(xpath = "//input[@id='phone']")
	public WebElement phone_myProfile;
	@FindBy(xpath = "//input[@id='email']")
	public WebElement email_myProfile;

	@FindBy(xpath = "//button[contains(text(),'Save changes')]")
	public WebElement saveChangesBtn_myProfile;
	@FindBy(xpath = "//span[contains(text(),'Tell us your first name')]")
	public WebElement firstNameErrorTxt_myProfile;
	@FindBy(xpath = "//span[contains(text(),'Tell us your last name')]")
	public WebElement lastNameErrorTxt_myProfile;

	@FindBy(xpath = "(//*[@role='listbox'])[1]/*")
	public List<WebElement> titleValues_myProfile;
	@FindBy(xpath = "(//*[@role='listbox'])[2]/*")
	public List<WebElement> genderValues_myProfile;
	@FindBy(xpath = "(//*[@role='listbox'])[3]/*")
	public List<WebElement> maritalStatusValues_myProfile;

	@FindBy(xpath = "//div[@id='signout-modal']//*[contains(text(),'of all devices')]")
	public WebElement singOutOfAllPopUp;
	@FindBy(xpath = "//div[@id='signout-modal']//*[contains(text(),'Leaving so soon')]")
	public WebElement singOutPopUp;
	@FindBy(xpath = "//button[contains(text(),'Yes')] | //button[contains(text(),'leave')]")
	public WebElement yesBtn;
	@FindBy(xpath = "//button[contains(text(),'No')] | //button[contains(text(),'stay')]")
	public WebElement noBtn;

	@FindBy(xpath = "//button[contains(text(),'Privacy Policy')]")
	public WebElement privacyPolBtn_leagalPage;
	@FindBy(xpath = "//button[contains(text(),'Terms and Conditions')]")
	public WebElement termsConditionsBtn_leagalPage;
	@FindBy(xpath = "//*[contains(text(),'PRIVACY NOTICE')]/../following-sibling::*")
	public WebElement privacyNoticeSection_leagalPage;
	@FindBy(xpath = "//*[contains(text(),'AGREEMENT TO TERMS')]/../following-sibling::*")
	public WebElement agreementToTermsSection_leagalPage;
	@FindBy(xpath = "(//button[contains(text(),'Privacy Policy')]/../preceding-sibling::*/*)[2]")
	public WebElement threeDotBtn_leagalPage;
	@FindBy(xpath = "//div[@id='consentCheckbox']//label[contains(text(),'')]")
	public List<WebElement> consentOptions_leagalPage;

	@FindBy(xpath = "(//*[contains(text(),'Shop & Explore')]/following-sibling::div)[2]/*//p[contains(text(),'')]")
	public List<WebElement> shopNowOptionsNameTxtInSearchOption;
	@FindBy(xpath = "(//*[contains(text(),'Pick a service')]/following-sibling::div)[2]/*//p[contains(text(),'')]")
	public List<WebElement> ssOptionsNameTxtInSearchOption;
	@FindBy(xpath = "//h1[contains(text(),'My orders')]")
	public WebElement orderHistoryPagrHeaderTxt;

	@FindBy(xpath = "//div[contains(text(),'Orders')]")
	public WebElement ordersDetailBtn;
	@FindBy(xpath = "//section[@id='tab-section-1']/div/div/div/label")
	public List<WebElement> noOfBrandOrderDetail;
	@FindBy(xpath = "//label[contains(text(),'Track all your commerce')]/../div//div/label[contains(text(),'')]")
	public List<WebElement> noOfBrandNameTxt;
	@FindBy(xpath = "//label[contains(text(),'Croma')]/../../label")
	public WebElement cromaOrdersDetailBtn;
	@FindBy(xpath = "//img[@alt='Croma Logo']")
	public WebElement cromaPage;
	@FindBy(xpath = "//a[contains(text(),'Orders')]")
	public WebElement cromaPageOrdersDetail;
	@FindBy(xpath = "//*[@id='filter-click'] | //*[contains(text(),'My orders')]/parent::div/div//*[@fill-rule='evenodd']")
	public WebElement suffixIconfilterButton;
	@FindBy(xpath = "//*[contains(text(),'any transactions that match your search')]")
	public WebElement noTransactionPresent;

	@FindBy(xpath = "//div[text()='Handpicked offers for you']")
	public WebElement HandpickedTxt;
	@FindBy(xpath = "//div[text()='Handpicked offers for you']/../../../../following::div[1]")
	public WebElement HandpickedSection;
	@FindBy(xpath = "//label[contains(text(),'Pay utility bills')]/../../*[1]")
	public WebElement PayBillSection;
	@FindBy(xpath = "//*[contains(text(),'Recent bills')]")
	public WebElement RecentBillSection;
	@FindBy(xpath = "//*[contains(text(),'Billers')]")
	public WebElement BillersSection;

	// locators for umag

	@FindBy(xpath = "//*[text()='Celebrations at Taj']")
	public WebElement celebAtTaj_insideUmag;

	@FindBy(xpath = "//*[text()='Join us on Instagram']")
	public WebElement joinInsta_insideUmag;
	@FindBy(xpath = "(//*[text()='Join us on Instagram']/following-sibling::*)[1]")
	public WebElement joinInstaCarousel_insideUmag;
	@FindBy(xpath = "//button[text()='Join']")
	public WebElement joinInstaBtn_insideUmag;
	@FindBy(xpath = "//*[text()='All about smartphones']/following-sibling::div[1]/div/div/div")
	public WebElement smartphone_insideUmag;
	
	@FindBy(xpath = "//*[text()='Travel like a pro']")
	public WebElement travelLikeAPro_insideUmag;
	
	@FindBy(xpath = "//*[text()='Gadgets 101']")
	public WebElement gadgets101;
	
	
	
	@FindBy(xpath="(//*[text()='Tech digest'])[1]")
	public WebElement electronicsButtoninsIdeUmag;
	
	@FindBy(xpath="//*[text()='Tech digest']")
	public WebElement techdigestInsideElectronics;
	
	@FindBy(xpath="//*[text()='Smart living']/following-sibling::div[1]")
	public WebElement smartlivingSectionUnderInsideElectronics;
	
	@FindBy(xpath="//*[text()='Trending now']/following-sibling::div[1]")
	public WebElement trendingnowSectionUnderInsideElectronics;
	
	@FindBy(xpath="//*[text()='Learn more about tech']/following-sibling::div[1]")
	public WebElement learnmoreabouttechSectionUnderInsideElectronics;
	
	@FindBy(xpath="//*[text()='//*[text()='Choose your gadget']/following-sibling::div[1]")
	public WebElement chooseyourgadgetSectionUnderInsideElectronics;
	
	@FindBy(xpath="//*[text()='//*[text()='Better tech']/following-sibling::div[1]")
	public WebElement bettertechSectionUnderInsideElectronics;
	
	
	
	
	
	
	
	
	@FindBy(xpath="(//*[text()='Travelogues'])[1]")
	public WebElement traveloguesInsideUmag;
	
	@FindBy(xpath="//*[text()='Travelogues']")
	public WebElement traveloguesInsideTravel;
	
	@FindBy(xpath="//*[text()='City delights']")
	public WebElement citydelightsInsideTravel;
	
	
	
	@FindBy(xpath="(//*[text()='Food bytes'])[1]")
	public WebElement foodbytesInsideUmag;
	
	@FindBy(xpath="//*[text()='Food bytes']")
	public WebElement foodbytesInsideEssentials;
	
	@FindBy(xpath="//*[text()='Just for kids']")
	public WebElement justforkidsInsideEssentials;
	
	
	
	@FindBy(xpath="(//*[text()='Style files'])[1]")
	public WebElement stylefilesInsideUmag;
	
	@FindBy(xpath="//*[text()='Style files']")
	public WebElement stylefilesInsideEssentials;
	
	@FindBy(xpath="//*[text()='Luxe station']")
	public WebElement luxestationInsideEssentials;
	
	
	@FindBy(xpath="//*[text()='Trending now']/following-sibling::div[1]")
	public WebElement trendingnowsectionundertravel ;
	
	@FindBy(xpath="//*[text()='Next Workation']")
	public WebElement workationtextundertravel;
	
	@FindBy(xpath="//*[text()='Next Workation']/following-sibling::div[1]")
	public WebElement workationsectionundertravel;
	
	@FindBy(xpath="//*[text()='Trending now']/following-sibling::div[1]")
	public WebElement trendingnowsectionunderfashion ;
	
	
	@FindBy(xpath="//*[text()='Beauty secrets']")
	public WebElement beautysecrettextderfashion ;
	
	
	@FindBy(xpath="//*[text()='Beauty secrets']/following-sibling::div[1]")
	public WebElement beautysecretsectionunderfashion ;
	
	@FindBy(xpath="//*[text()='Trend alert']/following-sibling::div[1]")
	public WebElement trendalertsectionunderfashion ;
	
	@FindBy(xpath="//*[text()='Wardrobe essentials']/following-sibling::div[1]")
	public WebElement wardrobesectionunderfashion ;
	
	
	@FindBy(xpath="//*[text()='Trending now']/following-sibling::div[1]")
	public WebElement trendingnowSectionUnderElectronics ;
	
	@FindBy(xpath="//*[text()='Learn more about tech']")
	public WebElement learnmoreabouttechTextUnderElectronics ;
	
	@FindBy(xpath="//*[text()='Learn more about tech']/following-sibling::div[1]")
	public WebElement learnmoreabouttechSectionUnderElectronics ;
	
	@FindBy(xpath="//*[text()='Trending now']/following-sibling::div[1]")
	public WebElement trendingnowSectionUnderEssentials ;
	
	@FindBy(xpath="//*[text()='Cook at home']")
	public WebElement cookathomeTextUnderEssentials ;
	
	@FindBy(xpath="//*[text()='Cook at home']/following-sibling::div[1]")
	public WebElement cookathomeSectionUnderEssentials ;
	
	
	@FindBy(xpath="//*[text()='Know your food']")
	public WebElement knowyourfoodtextUnderEssentials;
	
	
	@FindBy(xpath="//*[text()='Know your food']/following-sibling::div[1]")
	public WebElement knowyourfoodSectionUnderEssentials ;
	
	@FindBy(xpath="//*[contains(text(),'in season')]//following-sibling::div[1]")
	public WebElement whatinseasonSectionUnderEssentials ;
	
	@FindBy(xpath="//*[contains(text(),'Healthy twists')]//following-sibling::div[1]")
	public WebElement healthytwistSectionUnderEssentials ;
	
	
	
	

	//locators for Umag discover page_14/07/21
	
	@FindBy(xpath="//*[text()='Trending now']")
	public WebElement trendingnowTextUnderUmagDiscover ;
	
	@FindBy(xpath="//*[text()='Trending now']//following-sibling::div[1]")
	public WebElement trendingnowSectionUnderUmagDiscover ;
	
	
	
	@FindBy(xpath="//*[text()='Featured stories']")
	public WebElement featuredstoriesTextUnderUmagDiscover ;
	
	@FindBy(xpath="//*[text()='Featured stories']//following-sibling::div[1]")
	public WebElement featuredstoriesSectionUnderUmagDiscover ;
	
	
	
	@FindBy(xpath="//*[text()='Handpicked reads for you']")
	public WebElement handpickedTextUnderUmagDiscover ;
	
	@FindBy(xpath="//*[text()='Handpicked reads for you']//following-sibling::div[1]")
	public WebElement handpickedSectionUnderUmagDiscover ;
	
	
	
	@FindBy(xpath="//*[text()='Self care guide']")
	public WebElement selfcareguideTextUnderUmagDiscover ;
	
	@FindBy(xpath="//*[text()='Self care guide']//following-sibling::div[1]")
	public WebElement selfcareguideSectionUnderUmagDiscover ;
	
	
	@FindBy(xpath="//*[text()='Fitness check']")
	public WebElement fitnesscheckTextUnderUmagDiscover ;
	
	@FindBy(xpath="//*[text()='Fitness check']//following-sibling::div[1]")
	public WebElement fitnesscheckSectionUnderUmagDiscover ;
	
	
	
	@FindBy(xpath="//*[text()='Stay in vogue']")
	public WebElement stayinvogueTextUnderUmagDiscover ;
	
	@FindBy(xpath="//*[text()='Stay in vogue']//following-sibling::div[1]")
	public WebElement stayinvogueSectionUnderUmagDiscover ;
	
	
	
	
	@FindBy(xpath="//*[text()='Know your gadgets']")
	public WebElement knowyourgadgetTextUnderUmagHowto ;
	
	@FindBy(xpath="//*[text()='Know your gadgets']//following-sibling::div[1]")
	public WebElement knowyourgadgetSectionUnderUmagHowTo ;
	
	
	@FindBy(xpath = "//*[text()='Travel like a pro']")
	public WebElement travellikeaproTextUnderUmagHowto;
	
	@FindBy(xpath = "//*[text()='Travel like a pro']//following-sibling::div[1]")
	public WebElement travellikeaproSectionUnderUmagHowto;
	
	
	
	@FindBy(xpath = "//*[text()='Watch and learn']")
	public WebElement watchandlearnTextUnderUmagHowto;
	
	@FindBy(xpath = "//*[text()='Watch and learn']//following-sibling::div[1]")
	public WebElement watchandlearnSectiontUnderUmagHowto;
	
	
	@FindBy(xpath = "//*[text()='TCP basics']")
	public WebElement tcpbasicsTextUnderUmagHowto;
	
	@FindBy(xpath = "//*[text()='TCP basics']//following-sibling::div[1]")
	public WebElement tcpbasicsSectionUnderUmagHowto;
	
	
	
	
	@FindBy(xpath = "//*[@placeholder='Search U Mag']")
	public WebElement searchUmag;
	
	@FindBy(xpath = "//*[text()='Popular searches']")
	public WebElement popularSearchUmag;
	
	@FindBy(xpath = "//*[text()='Recent searches']")
	public WebElement recentSearchUmag;
	
	@FindBy(xpath = "//*[contains(text(),'No result found')]")
	public WebElement noresultfoundSearchUmag;
	
	@FindBy(xpath="//*[contains(text(),'results found for ')]")
	public WebElement resultsFoundForSearch;
	
	//@FindBy(xpath = "//*[@class='jss499']/div[2]/div")
	public WebElement suggestionSearchUmag;
	
	@FindBy(xpath = "//*[contains(text(),'Newest')]")
	public WebElement newestTextUnderUmagSearch;
	
	@FindBy(xpath="//*[contains(text(),'Sort by')]/following-sibling::*/../following-sibling::*/../following-sibling::*/../following-sibling::*")
	public WebElement filterOptionUnderUmagSearch;
	
	@FindBy(xpath="//*[text()='Category']")
	public WebElement categoryUnderFilter ;
	
	@FindBy(xpath="//*[contains(text(),'Content type')]")
	public WebElement contenttypeUnderUmagFilter;
	
	@FindBy(xpath="(//*[@focusable='false'])[4]")
	public WebElement crossButtonUnderUmageFilter;
	
	@FindBy(xpath = "(//label[contains(text(),'NeuMag')])[1]")
	public WebElement NeuMagBtn;
	
	@FindBy(xpath = "//*[@id='SearchInputBox']")
	public WebElement searchInput;
	
	@FindBy(xpath = "//label[contains(text(),'My orders')]")
	public WebElement MyorderBtn;
	
	@FindBy(xpath = "//div[contains(text(),'My transactions')]")
	public WebElement MytransactionsBtn;
	
	@FindBy(xpath = "//*[contains(text(),'Offers & Bundles')]/../div[1]")
	public WebElement OffersBundlesBackbtn;
	
	@FindBy(xpath = "(//*[contains(text(),'NeuMag')])[2]/../*[1]")
	public WebElement NeuMagBackbtn;
	
	@FindBy(xpath = "(//*[contains(text(),'Rewards')])[2]/../*[1]")
	public WebElement RewardsBackbtn;
	
	
	//refer a friend
	
	
		@FindBy(xpath="//*[text()='Refer a friend']") public WebElement referAFrindBannerTxt;
		@FindBy(xpath="//div[text()='Share the joy! Double the happiness!']") public WebElement shareTheJoyText;
		@FindBy(xpath="//*[text()='Your referrals']") public WebElement yourReferrals;
		@FindBy(xpath="//div[@class='Flex__Box-gYjQHV WoPld sc-evQXBP dFBlnr']") public WebElement referralsDashboard;
		@FindBy(xpath="//*[text()='terms and conditions']") public WebElement termsAndCondReferAFriend;
		@FindBy(xpath="//input[@name='firstName']") public WebElement firstNameRefer;
		@FindBy(xpath="//input[@name='lastName']") public WebElement lastNameRefer;
		@FindBy(xpath="//input[@name='phone']") public WebElement phoneNumberRefer;
		@FindBy(xpath="//button[text()='Refer now']") public WebElement referNowButton;
		
		
		@FindBy(xpath="//*[text()='Send your invite']") public WebElement sendYourInvite;
		@FindBy(xpath="//div[text()='WhatsApp']") public WebElement whatsAppUnderInvite;
		@FindBy(xpath="(//div[@class='sc-ehBoZL hYPYAe'])[1]") public WebElement whatsAppIconUnderInvite;
		@FindBy(xpath="//div[text()='Facebook']") public WebElement facebookUnderInvite;
		@FindBy(xpath="(//div[@class='sc-ehBoZL hYPYAe'])[2]") public WebElement facebookIconUnderInvite;
		@FindBy(xpath="//div[text()='Twitter']") public WebElement twitterUnderInvite;
		@FindBy(xpath="(//div[@class='sc-ehBoZL hYPYAe'])[3]") public WebElement twitterIconUnderInvite;
		@FindBy(xpath="//div[text()='Email']") public WebElement emailUnderInvite;
		@FindBy(xpath="(//div[@class='sc-ehBoZL hYPYAe'])[4]") public WebElement mailIconUnderInvite;
		@FindBy(xpath="(//*[local-name()='svg' and @style='cursor: pointer;'])[7]") public WebElement closeUnderInvite;
		@FindBy(xpath="//div[text()='Resend']") public WebElement resendInvite;
		@FindBy(xpath="//div[text()='Cancel']") public WebElement cancelInvite;
		@FindBy(xpath="//button[text()='Yes']") public WebElement yesButton;
		@FindBy(xpath="//button[text()='No']") public WebElement noButton;
		//@FindBy(xpath="//input[@name='phone']") public WebElement phoneNumberRefer;
		//@FindBy(xpath="//button[text()='Refer now']") public WebElement referNowButton;
		
		@FindBy(xpath="//input[@id='emailId']") public WebElement referralCodeField;
		@FindBy(xpath="//button[text()='Submit']") public WebElement submitButton;
		@FindBy(xpath="//input[@id='primaryEmailId']") public WebElement primaryEamilIdField;
		@FindBy(xpath="//button[text()='Lets go']") public WebElement letsGoButton;
		
		
		
		//@FindBy(xpath="//*[text()='Send your invite']") public WebElement sendYourInvite;
		//@FindBy(xpath="//div[text()='WhatsApp']") public WebElement whatsAppUnderInvite;

		//new xpaths homepage
		
		@FindBy(xpath="//label[normalize-space()='Offers']") public WebElement offersInUpperNavBar;
		@FindBy(xpath="//label[normalize-space()='Stories']") public WebElement storiesInUpperNavBar;
		@FindBy(xpath="//label[normalize-space()='Vault']") public WebElement vaultInUpperNavBar;
		@FindBy(xpath="//div[@id='home-u-rewards']//label[1]") public WebElement neupassInUpNavBar;
		@FindBy(xpath="//input[@id='SearchInputBox']") public WebElement searcgBoxinUpNavBar;
		@FindBy(xpath="//img[@id='notification-icon']") public WebElement notificationIconUpNavBar;
		@FindBy(xpath="//img[@id='hamberger-icon']") public WebElement hamburgerIconInUpNavBar;
		
		@FindBy(xpath="//div[contains(text(),'Offers & Bundles')]") public WebElement offersAndBundlesHeader;
		@FindBy(xpath="//div[@type='underlined'][normalize-space()='Offers']") public WebElement offersOption;
		@FindBy(xpath="//div[normalize-space()='Bundles']") public WebElement bundlesOption;
		@FindBy(xpath="(//*[name()='svg'])[2]") public WebElement backButton;
		@FindBy(xpath="//div[normalize-space()='Bill payments']") public WebElement billpayments;
		@FindBy(xpath="//h4[normalize-space()='Cards']") public WebElement cards;
		@FindBy(xpath="//div[@id='elite-card-container-one-section']") public WebElement neupassrewardscard;
		@FindBy(xpath="//div[contains(text(),'Rewards')]") public WebElement rewardsheader;
		@FindBy(xpath="//h2[normalize-space()='Tata Pay']") public WebElement tataPayUnderAlerts;
		@FindBy(xpath="//h2[normalize-space()='Bills']") public WebElement billsUnderAlerts;
        @FindBy(xpath="//h2[normalize-space()='Finance']") public WebElement financeUnderAlerts ;
		@FindBy(xpath="//p[normalize-space()='Grocery']") public WebElement GrocerySLP;
		@FindBy(xpath="//p[normalize-space()='Electronics']") public WebElement ElectronicsSLP;
		@FindBy(xpath="//p[normalize-space()='Fashion']") public WebElement FashionSLP;
		@FindBy(xpath="//p[normalize-space()='Luxury']") public WebElement LuxurySLP;
		@FindBy(xpath="//p[normalize-space()='Beauty']") public WebElement BeautySLP;
		@FindBy(xpath="//p[normalize-space()='Fitness']") public WebElement FitnessSLP;
		@FindBy(xpath="//p[normalize-space()='Flights']") public WebElement FlightsSLP;
		@FindBy(xpath="//p[normalize-space()='Hotels']") public WebElement HotelsSLP;
		@FindBy(xpath="//p[normalize-space()='Entertainment']") public WebElement EntertainmentSLP;
		@FindBy(xpath="//p[normalize-space()='F&B']") public WebElement FnBSLP;
		@FindBy(xpath="//p[normalize-space()='Smartphones']") public WebElement SmartphonesSLP;
		@FindBy(xpath="//p[normalize-space()='Healthcare']") public WebElement HealthcareSLP;
		@FindBy(xpath="//div[contains(text(),'Shop by category')]") public WebElement shopbycategory;
		@FindBy(xpath="//h3[normalize-space()='POPULAR CATEGORIES']") public WebElement popularcategoriesUnderLuxury;
		@FindBy(xpath="//a[@href='/checkin-home']//div[@class='item1']") public WebElement airasiacheckinbutton;
		@FindBy(xpath="//div[@id='One Way']") public WebElement onewayairasia;
		@FindBy(xpath="//*[text()='Book a stay']") public WebElement bookAstay;
		@FindBy(xpath="//*[text()='Manage your DTH connection']") public WebElement managedth;
		@FindBy(xpath="//*[text()='Reserve a table']") public WebElement reserveAtable;
		@FindBy(xpath="//*[text()='Restaurant Page']") public WebElement resturantpage;
		@FindBy(xpath="//*[text()='Festival Menu Page']") public WebElement festivalpagemenu;
		@FindBy(xpath="//h4[normalize-space()='New arrivals']") public WebElement newArrivals;
		
		
		
		
}