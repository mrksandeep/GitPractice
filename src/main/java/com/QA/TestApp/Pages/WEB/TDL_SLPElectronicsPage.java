package com.QA.TestApp.Pages.WEB;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_SLPElectronicsPage extends BaseScript {
	

//23-2 Sourav
@FindBy(xpath="//*[text()='Electronics']") public WebElement electronicsHomepageTitle;
@FindBy(xpath="//input[@id='SearchInputBox']") public WebElement searchButton;
@FindBy(xpath="//*[@class='sprivilegeclose']") public WebElement birthdayBannerCloseButton;
@FindBy(xpath="//*[@class='sprivilegehead']") public WebElement birthdayBannerTitle;
@FindBy(xpath="//*[@class='sprivilegediscreption']") public WebElement birthdayBannerSubtitle;
@FindBy(xpath="//*[@class='specialprvshop']") public WebElement birthdayBannerSearchStoreCTA;
@FindBy(xpath="//*[text()='Recommended offers for you']") public WebElement electronicsOffersRecommended;
@FindBy(xpath="//*[text()='Offers from other brands']") public WebElement electronicsCrossBandOffers;
@FindBy(xpath="//*[text()='Popular product']") public WebElement electronicsPopularProduct;
//24-2 Sourav
@FindBy(xpath="//*[text()='Shop by category']") public WebElement electronicsShopbyCateogry;	
@FindBy(xpath="//*[text()='Home Appliances'] | //*[text()='Home appliances']") public WebElement electronicsHomeApplianceCategory;
@FindBy(xpath="//*[text()='Laptops']") public WebElement electronicsLaptopCategory;
@FindBy(xpath="//*[contains(text(),'Mobile Phones')]") public WebElement electronicsPhoneCategory;
@FindBy(xpath="//*[text()='Limited time deals']") public WebElement electronicsLimitedDeal;
@FindAll({@FindBy(xpath="//*[@class='Exchange_container']")}) public List<WebElement> limitedDeals_container;
@FindAll({@FindBy(xpath="//*[@class='Exchange_button']")}) public List<WebElement> limitedDealsButton_container;
@FindBy(xpath="//*[@class='slick-arrow slick-next']") public WebElement electronicsOffersReNext;
@FindBy(xpath="//*[@class='slick-arrow slick-prev']") public WebElement electronicsOffersRePrev;
@FindBy(xpath="//*[text()='More great offers']") public WebElement electronicsNextBestOffers;
@FindBy(xpath="//*[text()='Top brands']") public WebElement electronicsCrossBrandOffers;
@FindBy(xpath="//*[text()='Apple']") public WebElement electronicsAppleBrand;
@FindBy(xpath="//*[text()='Samsung']") public WebElement electronicsSamsungBrand;
@FindBy(xpath="//*[text()='Credit line widget']") public WebElement electronicsCreditLine;
@FindBy(xpath="//*[contains(text(),'Happy Birthday')]") public WebElement birthdaywidget;

//2-3 Sourav
@FindBy(xpath="//*[text()='Credit line widget']/following::div[1]//*[@class='Exchange_button']") public WebElement electronicsCreditLineCTA;

//Hero banner xpath
@FindAll({@FindBy(xpath="(//*[@class='slick-dots'])[1]/li/button")}) public List<WebElement> heroBannerdot;
@FindAll({@FindBy(xpath="//*[@class='EachHeroBannerlowersection']//div[@class='EachHeroBannerlowersection_left']//p")}) public List<WebElement> heroBannerJourneyDesc;
//@FindAll({@FindBy(xpath="//*[@class='EachHeroBannerlowersection']//div[@class='EachHeroBannerlowersection_left']//h4 | //*[@class='EachHeroBannertitlesection']//h4")}) public List<WebElement> heroBannerJourneyTitle;
@FindAll({@FindBy(xpath="//div[@class='slick-slide' or @class='slick-slide slick-active slick-current']//div//div//h4[@id='heroBannerHeading']")}) public List<WebElement> heroBannerJourneyTitle;
//@FindAll({@FindBy(xpath="//*[@class='EachHeroBannerlowersection']//div[@class='EachHeroBannerlowersection_right']//button")}) public List<WebElement> heroBannerJourneyCTA;
@FindAll({@FindBy(xpath="//div[@class='HeroBannerComponent_EachHeroBannerlowersection_right__mdALT']//button//span[contains(text(),'Shop now')]")}) public List<WebElement> heroBannerJourneyCTA;
////div[@class='slick-slide' or @class='slick-slide slick-active slick-current']//div//div//div//div//button//span[@class='herboBannerSpan' and text()='Shop now']
@FindBy(xpath="//*[@class='HeroBanner_Container']") public WebElement HeroBannerContainer;

//Expert reviews and guide to electronics xpath
@FindBy(xpath="//*[text()='Expert speak']") public WebElement electronicsExpertReview;
@FindBy(xpath="//*[text()='101 to buying gadgets'] | //*[text()='World of gaming']") public WebElement electronicsGuideToElectronics;
@FindAll({@FindBy(xpath="//*[@class='EachExpertReview_footer']")}) public List<WebElement> electronicsExpertReviewContentDesc;
@FindAll({@FindBy(xpath="//*[text()='World of gaming']/../../following-sibling::div//h5")}) public List<WebElement> electronicsGuideContentDesc;

//4-3 Sourav
//Recommended offers for you xpath
@FindBy(xpath="//*[text()='Recommended offers for you']/../../following::div[1]/div[3]") public WebElement electronicsRecOfferNext;
@FindBy(xpath="//*[text()='Recommended offers for you']/../../following::div[1]/div[1]") public WebElement electronicsRecOfferPrev;
@FindAll({@FindBy(xpath="//*[text()='Recommended offers for you']/../../following-sibling::div//h5")}) public List<WebElement> electronicsRecOfferDesc;
//Next best offer xpath
@FindBy(xpath="//*[text()='More great offers']/../../following::div[1]/div[3]") public WebElement electronicsNextBestOfferNext;
@FindBy(xpath="//*[text()='More great offers']/../../following::div[1]/div[1]") public WebElement electronicsNextBestOfferPrev;
@FindAll({@FindBy(xpath="//*[text()='More great offers']/../../following-sibling::div//h5")}) public List<WebElement> electronicsNextBestOfferDesc;
//Cross brand 2 offers from other brands xpath
@FindBy(xpath="//*[text()='Offers from other brands']/../../following::div[1]/div[1]") public WebElement electronicsOfferOtherBrandsNext;
@FindBy(xpath="//*[text()='Offers from other brands']/../../following::div[1]/div[3]") public WebElement electronicsOfferOtherBrandsPrev;
@FindAll({@FindBy(xpath="//*[text()='Offers from other brands']/../../following-sibling::div//h5")}) public List<WebElement> electronicsOfferOtherBrandsDesc;
@FindAll({@FindBy(xpath="//*[text()='Offers from other brands']/../../following::div[1]/div[2]/div/div")}) public List<WebElement> electronicsOfferOtherBrandsTiles;

//Mar02// SLP Hotel XPATH //
@FindBy(xpath="//*[text()='Book a room'] | //*[text()='Book a stay']") public WebElement BookAroom;
@FindBy(xpath="//div[@class='dropdown__text' and text()='Hotels'] | //span[contains(@class,'SearchResult_text_label_drop') and text()='Hotels']") public WebElement HotelHomepageTitle;
@FindBy(xpath="//*[text()='Hotel']") public WebElement HotelHomepageTitle_mobile;
@FindBy(xpath="//*[text()='Featured holidays & dining']") public WebElement FeaturedOffer;
@FindBy(xpath="(//*[text()=Featured holidays & dining']/following::div/h5)[1]") public WebElement FeaturedOfferWidget;
@FindBy(xpath="//*[text()='Stays recommended for you']") public WebElement StaysRecommendation;
@FindBy(xpath="(//*[text()=Stays recommended for you']/following::div/h5)[1]") public WebElement StaysRecommendationWidget;
@FindBy(xpath="//*[text()='Most viewed']") public WebElement Mostviewed;
@FindBy(xpath="(//*[text()='Most viewed']/following::div/h5)[1]") public WebElement MostviewedWidget;
//@FindBy(xpath="//*[text()='Editorï¿½s picks']") public WebElement Editorpicks;
@FindBy(xpath="//*[@class='cardwithcarousalheader']") public WebElement Editorpicks;
@FindBy(xpath="(//*[text()='Editorï¿½s picks']/following::div/h5)[1]") public WebElement EditorpicksWidget;
@FindBy(xpath="//*[text()='Inspired by your recent stays']") public WebElement Inspired;
@FindBy(xpath="(//*[text()='Inspired by your recent stays']/following::div/h5)[1]") public WebElement InspiredWidget;
@FindBy(xpath="//*[text()='Holiday packages and more']") public WebElement HolidayPack;
@FindBy(xpath="(//*[text()='Holiday packages and more']/following::div/h5)[1]") public WebElement HolidayPackWidget;
@FindBy(xpath="//*[text()='Stays recommended for you']") public WebElement Recommendedstays;
@FindBy(xpath="(//*[text()='Holiday packages and more']/following::div/h5)[1]") public WebElement RecommendedstaysWidget;
@FindBy(xpath="//*[text()='Reserve a table']") public WebElement ReserveATable;
@FindAll({@FindBy(xpath="//*[text()='Featured holidays & dining']/../../following-sibling::div//h5")}) public List<WebElement> FeaturedOffersList;
@FindAll({@FindBy(xpath="//*[text()='Stays recommended for you']/../../following-sibling::div//h5")}) public List<WebElement> StaysRecommendationList;
@FindAll({@FindBy(xpath="//*[text()='Most viewed']/../../following-sibling::div//h5")}) public List<WebElement> MostViewedList;
@FindAll({@FindBy(xpath="//*[text()='Inspired by your recent stays']/../../following-sibling::div//h5")}) public List<WebElement> InspiredList;
@FindAll({@FindBy(xpath="//*[text()='Holiday packages and more']/../../following-sibling::div//h5")}) public List<WebElement> HolidayList;
@FindAll({@FindBy(xpath="//*[text()='Recommended stays']/../following-sibling::div//h3")}) public List<WebElement> RecommendList;
//@FindAll({@FindBy(xpath="//*[text()='Editorï¿½s picks']/following-sibling::div//h3")}) public List<WebElement> editorList;
@FindAll({@FindBy(xpath="//*[@class='cardwithcarousalheader']/following-sibling::div//h3")}) public List<WebElement> editorList;
@FindBy(xpath="//*[text()='Book now']") public WebElement BookNow;
@FindBy(xpath="//*[text()=' Save']") public WebElement Save;

//Akshya
@FindBy(xpath="//*[contains(text(),'Book a Stay')] | //*[contains(text(),'Book a stay')]") public WebElement BookAstay;
//Akshya
@FindBy(xpath="//*[@value='Me']") public WebElement BookAstay_MeOption;
@FindBy(xpath="//*[text()='Reserve a Table']") public WebElement reserveATablePalatoPage;
@FindBy(xpath="(//*[contains(text(),'Palato')])[3]") public WebElement validatePalatoPage;

@FindBy(xpath="(//*[@class='col-12 mobile-styling-dining-details-card-contents'])[3]") public WebElement validatePalatoPage1;
@FindBy(xpath="//*[contains(text(),'Offers in spotlight'] | (//*[@class='componentsixtitle'])[3]") public WebElement SpotLightOffer;
//@FindAll({@FindBy(xpath="//*[text()='Offers in spotlight']/../../following-sibling::div/div[2]/div/div")}) public List<WebElement> SpotLightOfferList;
@FindAll({@FindBy(xpath="//*[contains(text(),'Offers in spotlight')]/../../following-sibling::div//h5 | //*[contains(text(),'Offers in spotlight')]/../../following-sibling::div//h6")}) public List<WebElement> SpotLightOfferList;

//Akshya
@FindBy(xpath="//*[@id='page-scope']/following::*[@id='header-profile']//span") public WebElement LogedIHCL;
@FindBy(xpath="(//*[@id='header-profile'])[1]/div[1]/div") public WebElement LogedIHCL_mobile;
@FindBy(xpath="//*[@class='navbar-toggler-icon']") public WebElement LogedIHCL_toggler;
@FindBy(xpath="//*[@class='header-mobile-back-btn icon-prev-arrow']") public WebElement LogedIHCL_toggler_backButton;

//Akshya
@FindBy(xpath="//*[@class='dining-list-fitered-wrapper']/ul/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/a/button") public WebElement reserveFirstTableRestaurantPage;

@FindBy(xpath="//*[contains(text(),'Average Price for 2 people')]") public WebElement TablePriceText;
@FindBy(xpath="//*[contains(text(),'Please call')]") public WebElement ReserveTableText1;
@FindBy(xpath="(//*[contains(text(),'+91-562-2335555')])[4]") public WebElement ReserveTableText2;


//SLP Beauty XPATH//

@FindBy(xpath="//span[@class='SearchResult_text_label_drop_down__giXl7' and text()='Beauty']") public WebElement BeautyHomepageTitle;

@FindBy(xpath="//*[text()='Shop by theme'] | //*[text()='Shop by activity']") public WebElement ThemeTitle;
@FindAll({@FindBy(xpath="//*[text()='Shop by theme']/following-sibling::div/div  | //*[text()='Shop by activity']/following-sibling::div/div")}) public List<WebElement> ThemeselectTitle;
@FindBy(xpath="//*[contains(text(),'Shop by category')]") public WebElement category;
@FindAll({@FindBy(xpath="//*[contains(text(),'Shop by category')]/following-sibling::div//p | //*[contains(text(),'Shop by category')]/following-sibling::div//div[@class='categoriecard_imgtext']")}) public List<WebElement> shopCategorylist;
@FindBy(xpath="//*[text()='Top brands']") public WebElement TopBrands;
@FindAll({@FindBy(xpath="//*[text()='Top brands']//../following-sibling::div/div")}) public List<WebElement> TopBrandslist;
@FindAll({@FindBy(xpath="//*[@class='Top_Sub_Title']/preceding-sibling::div | //*[@class='sc-gRYtL eOHpA-d Topbrands_block']")}) public List<WebElement> TopBrandsImglist;

@FindBy(xpath="//div[@class='dropdown__text' and text()='Fashion'] | //span[contains(@class,'text_label_drop_down') and text()='Fashion']") public WebElement FashionHomepageTitle;
@FindBy(xpath="//span[text()='Fashion']") public WebElement FashionHomepageTitlePM;


//MAr 04//

@FindBy(xpath="//*[text()='End of season sneak peek ']") public WebElement SneekPeakTitle;
@FindBy(xpath="//*[text()='End of season sneak peek ']/../following-sibling::button") public WebElement SneekPeakshopNow;
@FindBy(xpath="//*[text()='Que magazine'] | //*[contains(text(),'Que')]") public WebElement QueMagazineTitle;
@FindBy(xpath="//*[text()='Que magazine']/../following-sibling::button | //*[contains(text(),'Que')]/../following-sibling::button") public WebElement QueMagazineReadNow;

@FindBy(xpath="//*[contains(text(),'New arrivals')]") public WebElement NewLaunchTitle;
@FindBy(xpath="//*[contains(text(),'New arrivals')]/../following-sibling::button | //*[text()='Explore Now'] | //*[text()='Explore now']") public WebElement NewLaunchExpNow;

@FindBy(xpath="//*[text()='Special price store']") public WebElement PriceStoreTitle;
@FindAll({@FindBy(xpath="//*[text()='Special price store']/../../following-sibling::div//h5")}) public List<WebElement> PriceStorelist;
@FindBy(xpath="//*[text()=\"Women's edit\"]") public WebElement womensFashion;
@FindAll({@FindBy(xpath="//*[text()=\"Women's edit\"]/following-sibling::div//h5[1]")}) public List<WebElement> Womenslist; 
@FindBy(xpath="//*[text()=\"Men's edit\"]") public WebElement MensFashion;
@FindAll({@FindBy(xpath="//*[text()=\"Men's edit\"]/following-sibling::div//h5[1]")}) public List<WebElement> Menslist;
@FindBy(xpath="//*[text()=\"Kids' edit \"]") public WebElement kidsFashion;
@FindAll({@FindBy(xpath="//*[text()=\"Kids' edit \"]/following-sibling::div//p")}) public List<WebElement> Kidslist;
@FindBy(xpath="//*[text()='Footwear']") public WebElement footwear;
@FindAll({@FindBy(xpath="//*[text()='Footwear']/following-sibling::div//h5[2]")}) public List<WebElement> footwearlist;

@FindBy(xpath="//*[text()='10% Instant Cashback on ICICI Debit & Credit Cards'] | //*[text()='10% instant cashback on ICICI Debit & Credit Cards']") public WebElement creditlineWidget;



//@FindBy(xpath="//*[text()='Sports']") public WebElement SportsHomepageTitle;
@FindBy(xpath="//*[text()='End of season sneak peek ']/following-sibling::div") public WebElement SneekPeakdesc;
@FindBy(xpath="//*[text()='New on Tata CLiQ ']/following-sibling::div | //*[contains(text(),'New on')]/following-sibling::div | //*[contains(text(),'New')]/following-sibling::div") public WebElement NewLaunchdesc;
@FindBy(xpath="//*[text()='Que magazine']/following-sibling::div | //*[contains(text(),'Que')]/following-sibling::div") public WebElement QueMagazinedesc;
	
/* SLP Essentials XPATH */

@FindBy(xpath="//*[text()='Essentials']") public WebElement essentialsHomepageTitle;
//BB Star Membership Widget
@FindBy(xpath="//*[text()='Essentials']") public WebElement essentialsBBStar;
@FindBy(xpath="(//*[@class='bbstarleft']//div)[1]") public WebElement essentialsBBStarTitle;
@FindAll({@FindBy(xpath="(//*[@class='bbstarleft']//div)[2]//div")}) public List<WebElement> essentialsBBStarDesc;
@FindBy(xpath="//*[@class='bbstarright']//div") public WebElement essentialsBBStarCTA;
//Offers for you
@FindBy(xpath="//*[text()='Offers for you']") public WebElement essentialsOffersForU;
@FindAll({@FindBy(xpath="//*[text()='Offers for you']/../../following-sibling::div//h5")}) public List<WebElement> essentialsOffersForUDesc;
//Bundles you may like
@FindBy(xpath="//*[text()='Bundles you may like']") public WebElement essentialsBundles;
@FindAll({@FindBy(xpath="//*[text()='Bundles you may like']/following-sibling::div/div//child::div[2]")}) public List<WebElement> essentialsBundlesDesc;
//Content Widget - Recipes,hacks & more
@FindBy(xpath="//*[text()='Recipes, tips & more']") public WebElement essentialsContentRecepie;
@FindAll({@FindBy(xpath="//*[text()='Recipes, tips & more']/../../following-sibling::div//h6")}) public List<WebElement> essentialsContentRecepieDesc;
@FindAll({@FindBy(xpath="//*[text()='Recipes, tips & more']/../../following-sibling::div//h5")}) public List<WebElement> essentialsContentRecepieTitle;
//All Categories Widget
@FindBy(xpath="//*[text()='Shop by category']") public WebElement essentialsShopByCategory;
@FindAll({@FindBy(xpath="//*[text()='Shop by category']/following::div[1]/div//child::div/div")}) public List<WebElement> essentialsCategoryOneDesc;
@FindAll({@FindBy(xpath="(//*[text()='Shop by category']/../../following-sibling::div//child::div)[6]/div//child::h5[2]")}) public List<WebElement> essentialsCategoryTwoDesc;

//SLP Login//
@FindBy(xpath="//div[@data-testid='homenavbar']/div/div[2]/div/div") public WebElement profileOpt;	
@FindBy(xpath="//a[@href='/slp']") public WebElement SLPopt;
//@FindBy(xpath="//*[text()='Electronics']") public WebElement SLPElectronics;
@FindBy(xpath="//*[text()='Electronics'] | (//div[@class='component11']//p)[2]") public WebElement SLPElectronics;
@FindBy(xpath="//*[text()='Hotels'] | (//div[@class='component11']//p)[8]") public WebElement SLPHotel;
@FindBy(xpath="//*[text()='Grocery'] | //*[text()='Groceries'] | (//div[@class='component11']//p)[1]") public WebElement SLPEssentials;
@FindBy(xpath="//*[text()='Fitness'] | (//div[@class='component11']//p)[6]") public WebElement SLPSports;
@FindBy(xpath="//*[text()='Beauty'] | //p[text()='Beauty'] | (//div[@class='component11']//p)[5]") public WebElement SLPBeauty;
@FindBy(xpath="//*[text()='Fashion'] | (//div[@class='component11']//p)[3]") public WebElement SLPFashion;
@FindBy(xpath="//*[text()='Entertainment'] | (//div[@class='component11']//p)[9]") public WebElement SLPTataSky;
@FindBy(xpath="//*[text()='Luxury'] | (//div[@class='component11']//p)[4]") public WebElement SLPLuxury;
//Croma
@FindBy(xpath="//*[@id='search']") public WebElement cromaSearchBox;
@FindBy(xpath="//*[@class='cat-title']") public WebElement firstsearchedoption;

@FindBy(xpath="//*[@class='logged-in-user'] | //*[@class='DesktopHeader__nameSpan'] | //*[text()='MY ACCOUNT']") public WebElement LogedCroma;
@FindBy(xpath="(//*[contains(text(),'buy now')])[1]") public WebElement BuyNowCroma;
@FindBy(xpath="//*[contains(text(),'Enter a Pincode')]/following::input") public WebElement PincodeEditAnd;
@FindBy(xpath="//*[contains(text(),'Enter a Pincode')]") public WebElement PincodeAnd;
@FindBy(xpath="//*[contains(text(),'APPLY')]") public WebElement PincodeApplyAnd;
@FindBy(xpath="//*[contains(text(),'Total')]/following::button[1]") public WebElement checkoutAnd;
@FindBy(xpath="//*[text()='SHIPPING ADDRESS']") public WebElement shipAddress;
@FindBy(xpath="(//*[text()='CHANGE ADDRESS'])[1]") public WebElement chgAddress;
@FindBy(xpath="(//*[contains(text(),'Full name')])[1]/following-sibling::input") public WebElement firstname;
@FindBy(xpath="//*[@placeholder='Flat no./Building Name/Society/Road']") public WebElement flat;
@FindBy(xpath="(//*[@placeholder='Landmark/Locality/Area'])[1]") public WebElement Landmark;
@FindBy(xpath="(//*[@placeholder='Select your state'])[1]") public WebElement state;
@FindBy(xpath="//*[@id='state_id-option-0']") public WebElement statelist;
@FindBy(xpath="//*[@id='city_id']") public WebElement city;

@FindBy(xpath="//*[@id='city_id-option-0']") public WebElement citylist;
@FindBy(xpath="//*[text()='Email Address']") public WebElement EmailAddressEdit;
@FindBy(xpath="//*[text()='Email Address']/following::input[1]") public WebElement EmailAddress;
@FindBy(xpath="//*[text()='select payment'] | //*[text()='SELECT PAYMENT'] | //button[@id='checkout-payment-button']") public WebElement selectPayment;
@FindBy(xpath="//*[text()='Choose a payment method'] | //*[contains(text(), 'Payments')] | //*[text()='Payment'] | //*[contains(text(),'Payment Details')]") public WebElement PaymentmethodSel;
@FindBy(xpath="//*[text()='Pay with Tata Pay App'] | (//*[text()='Tata Pay'])[3]") public WebElement TataPay;
//@FindBy(xpath="//article[contains(text(),'Tata Pay')]") public WebElement TataPayOption;
@FindBy(xpath="(//article[text()='Tata Pay '])") public WebElement TataPayOption;
@FindBy(xpath="(//*[text()='Proceed to pay'])[1]") public WebElement ProceedPay;
@FindBy(xpath="//*[normalize-space(text())= 'Payments'] | //*[normalize-space(text())= 'Payment']") public WebElement PAymentMethod_TPM;
@FindBy(xpath="//*[@id='otherTender']/../label") public WebElement PAymentchangeTPM;
@FindBy(xpath="//p[text()='View All']") public WebElement view_TPM;
@FindBy(xpath="//div[text()='Tata Pay UPI']") public WebElement TataPayUPI;
@FindBy(xpath="//div[text()='Tata Pay UPI ID verified!']") public WebElement TataPayUPIVerified;
@FindBy(xpath="//label[text()='GET IT ON' and 'Google Play']") public WebElement TataPayUPINotLinked;
@FindBy(xpath="//label[text()='Add new']") public WebElement addnewbtn;
@FindBy(xpath="//div[text()='Other UPI']") public WebElement otherUPI;
@FindBy(xpath="//button[contains(text(), 'Pay')] | //span[contains(text(), 'Pay')]") public WebElement payBtn;
@FindBy(xpath="//*[@mask='url(#check-button-unchecked-b)']") public WebElement tcpPoints_checkbox;
@FindBy(xpath="(//*[@mask='url(#check-button-unchecked-b)'])[2]") public WebElement QuickEMI_Checkbox;
@FindBy(xpath="//div[contains(text(),'Available credit balance:')]") public WebElement CreditLimitText;
@FindBy(xpath="//p[text()='Choose EMI Option']") public WebElement ChooseEMI;
@FindBy(xpath="//span[contains(text(), 'Amount')]/following::span[1]") public WebElement Totalamount;
@FindBy(xpath="//input[@name='loyaltyPointstxt']") public WebElement LoyaltyPoint;
@FindBy(xpath="//span[contains(text(),'You can use upto')]") public WebElement ErrorMsg;
@FindBy(xpath="//*[@data-testid='edit-loyalty']") public WebElement edit_tcpPoints;
@FindBy(xpath="//*[@id='loyaltyPointstxt']") public WebElement tcpLoyalityAmount;
@FindBy(xpath="//*[@data-testid='Confirm-container']") public WebElement tcpLoyalitybutton;
@FindBy(xpath="//*[text()='CREDIT CARD']/following::input[1] | (//*[local-name()='svg'])[2]") public WebElement creditcard;
@FindBy(xpath="//input[@placeholder='CVV'] | //input[@name='CVV']") public WebElement cvvCode;
@FindBy(xpath="//iframe[@class='security_code_iframe']") public WebElement cvv_frame;
@FindBy(xpath="//*[@id='modal-close-button']/following-sibling::div//button[contains(text(), 'Pay')]") public WebElement payBtnnew;
@FindBy(xpath="//*[text()='Failure']") public WebElement failure_button_razopay;
@FindBy(xpath="//*[text()='DEBIT CARD']/following::input[1] | (//*[local-name()='svg'])[3]") public WebElement debitcard;
@FindBy(xpath="//*[text()='NETBANKING'] | //*[text()='Netbanking']") public WebElement NetBanking_TPM;
//@FindBy(xpath="(//*[text()='NETBANKING']/following::div/div[contains(text(),'Axis')][1]) | //img[@alt='Axis Bank'] | (//*[text()='Netbanking']/following::div/div[contains(text(),'SBI')][1])") public WebElement netbanking_first_bank;
@FindBy(xpath="(//*[text()='Netbanking']/following::div/div[contains(text(),'Axis Bank')][1])") public WebElement netbanking_first_bank;
@FindBy(xpath="//div[text()='Popular banks ']") public WebElement PopularBanks;
@FindBy(xpath="//div[text()='All banks ']") public WebElement AllBanks;
@FindBy(xpath="//div[text()='Central Bank Of India']") public WebElement Central_Bank;
@FindBy(xpath="//input[@placeholder='Search'] | //input[@data-testid='search-box-morebanks']") public WebElement SearchBanks;
@FindBy(xpath="") public WebElement UPI_TPM;
@FindBy(xpath="") public WebElement upiRadioBtn;
@FindBy(xpath="") public WebElement upiPayBtn;
@FindBy(xpath="//*[text()='Please enter the Otp']/following::input[1] | //*[@placeholder='OTP']") public WebElement Password;
@FindBy(xpath="//*[@id='submitBtn'] | //*[@id='submit-action'] | //*[contains(text(),'SUMBIT')] | (//*[contains(text(),'Pay now')])[2]") public WebElement Pay;
@FindBy(xpath="(//*[@class='product-info'])[1]") public WebElement productCroma;
@FindBy(xpath="//*[text()='Successful'] | //*[text()='Success']") public WebElement NetBankingSucces_TPM;
//@FindBy(xpath="//*[text()='Success']") public WebElement NetBankingSucces_TPM;

@FindBy(xpath="//*[text()='Failure']") public WebElement NetBankingfailure_TPM;
@FindBy(xpath="(//*[text()='Credit Line']") public WebElement CrediLineWidget;

@FindBy(xpath="") public WebElement Loged_android;

@FindBy(xpath="//*[contains(text(),'Bundle bonanza')]") public WebElement bundleBonanza;
@FindBy(xpath="//*[contains(text(),'Everyday Tech')]") public WebElement bundletech;

@FindBy(xpath="//h1[text()='Bundles']") public WebElement bundlePage;
@FindBy(xpath="//*[@data-testid='id-view']/div") public WebElement success_Transaction;
@FindBy(xpath="//span[@data-testid='message-success'] | //span[@data-testid='message-fail']") public WebElement success_sumary;
@FindBy(xpath="(//*[text()='PAYMENT DETAILS']/following::button)[1]") public WebElement payment_icon;
@FindBy(xpath="(//*[text()='Item Subtotal']/following::dd)[1]") public WebElement payment_subtotal;
@FindBy(xpath="(//*[text()='Payment method']/following::span)[1]") public WebElement payment_method;

@FindBy(xpath="//*[text()='TOTAL']/following-sibling::*") public WebElement total_paid_amount;
@FindBy(xpath="(//*[text()='PAYMENT DETAILS']/following::h4)[4]") public WebElement total_paid_amount_multitender;

@FindBy(xpath="//*[contains(text(), 'Back To Homepage')]") public WebElement GoToHomePAge;
@FindBy(xpath="(//*[text()='Shop now'])[1]") public WebElement shop_now_button;
@FindBy(xpath="(//*[text()='Electronics'])[1]") public WebElement electronics_title;
//tatacliq 
@FindBy(xpath="//*[@class='DesktopHeader__nameSpan']") public WebElement LogedTatacliq;
@FindBy(xpath="//*[@class='SearchHeader__searchRedHolder']/following::input[1] | //*[@class='acc-links acc-title custom']/following::input[1] | //input[@id='search-text-input']") public WebElement searchButtonCliq;
//@FindBy(xpath="(//*[@class='SearchResultItem__base'])[1]") public WebElement searchResultCliq;
@FindBy(xpath="//*[contains(text(),'Showing')]") public WebElement showingCliq;
@FindBy(xpath="//*[@class='DesktopHeader__logoHolder']") public WebElement productCliq;
@FindBy(xpath="//*[text()='BUY NOW']") public WebElement buyNowCliq;
@FindBy(xpath="//*[text()='Checkout']") public WebElement checkouCliq;
@FindBy(xpath="//*[@placeholder='First Name*']") public WebElement fnameCliq;
@FindBy(xpath="//div/h4[text()='Shipping Address']") public WebElement shippingAddressCliqLuxury;
@FindBy(xpath="//p[@class='addressDetailsText wrap_content']") public WebElement shippingAddressTextCliqLuxury;
@FindBy(xpath="//*[@placeholder='Last Name*']") public WebElement LnameCliq;
@FindBy(xpath="//*[@placeholder='Enter your PIN code*']") public WebElement pincodeCliq;
@FindBy(xpath="//*[@placeholder='Address*'] | //*[contains(@placeholder,'Address*')]") public WebElement addressCliq;
@FindBy(xpath="//*[@placeholder='Phone number*'] | //*[contains(@placeholder,'Contact Number*')]") public WebElement phoneNumberCliq;
@FindBy(xpath="//*[text()='Ask me later']") public WebElement laterCliq;
@FindBy(xpath="//*[text()='Save & Continue']") public WebElement savecontCliq;
@FindBy(xpath="//span[text()='Continue']") public WebElement contCliq;
@FindBy(xpath="//*[text()='Payment Method'] | //*[text()='Make Payment']") public WebElement paymentCliq;
@FindBy(xpath="//*[text()='Credit Card']") public WebElement creditCliq;
@FindBy(xpath="(//*[text()='Credit Card']//following::div)[1]") public WebElement creditarrowCliq;
@FindBy(xpath="(//*[@placeholder='Card Number *'])[1] | (//*[@placeholder='Card Number'])[1]") public WebElement creditnumberCliq;
@FindBy(xpath="(//*[@class='SelectBoxMobile__hideSelect'])[1]") public WebElement expirymonthCliq;
@FindBy(xpath="(//*[@class='SelectBoxMobile__hideSelect'])[2]") public WebElement expiryyearCliq;
@FindBy(xpath="(//*[@placeholder='Name on card*']/following::input[1])[1]") public WebElement cvvCliq;
@FindBy(xpath="(//*[@placeholder='Name on card*'])[1]") public WebElement cardnameCliq;
@FindBy(xpath="//div[@class='Button__base'] | (//*[contains(text(),'Pay now')])[2]") public WebElement payCliq;

@FindBy(xpath="//*[text()='Debit Card']") public WebElement debitCliq;

@FindBy(xpath="(//*[text()='Debit Card']/following::div)[1]") public WebElement debitarrowCliq;


@FindBy(xpath="(//*[@placeholder='Card Number *'])[2] | (//*[@placeholder='Card Number'])[2]") public WebElement debittnumberCliq;
@FindBy(xpath="(//*[@class='SelectBoxMobile__hideSelect'])[3]") public WebElement expirymonthdebCliq;
@FindBy(xpath="(//*[@class='SelectBoxMobile__hideSelect'])[4]") public WebElement expiryyeardebCliq;
@FindBy(xpath="(//*[@placeholder='Name on card*']/following::input[1])[2]") public WebElement cvvdebCliq;
@FindBy(xpath="(//*[@placeholder='Name on card*'])[2]") public WebElement cardnamedebCliq;

@FindBy(xpath="//*[contains(text(),'Enter')]") public WebElement carddetailsCliq;
@FindBy(xpath="//*[@id='cardNumber']") public WebElement cardnumberCliq;
@FindBy(xpath="//*[@id='cardExpiry']") public WebElement expiryCliq;
@FindBy(xpath="//*[@id='cardCvv']") public WebElement cvvnumberCliq;
@FindBy(xpath="//*[@id='cardOwnerName']") public WebElement cardmembernameCliq;
@FindBy(xpath="//*[text()='PROCEED']") public WebElement proceedCLiq;

@FindBy(xpath="//*[@class='searchboxinput']") public WebElement searchButtonHotel;
@FindBy(xpath="//*[text()='Couldn’t found any content for ‘']") public WebElement searchNoItemHotel;
@FindBy(xpath="(//*[@class='Allsearchresults'])") public WebElement searchResultHotel; 
@FindBy(xpath="(//*[@class='Allsearchresults'])/div[1]/div[1]") public WebElement clickFirstResultHotel; 
@FindBy(xpath="(//*[@class='searchresult_popularsearch'])") public WebElement popularHotelSearch; 
@FindBy(xpath="//*[@class='MuiSvgIcon-root']") public WebElement closeRootsearchHotel; 
@FindBy(xpath="(//*[@class='searchresult_search'])/div[1]/span") public WebElement FirstAutoSuggestedHotel; 



@FindBy(xpath="(//*[@class='Button__base']/span[text()='Pay now'])[2] | //*[text()='Pay Now']") public WebElement paydebCliq;

@FindBy(xpath="//*[text()='Netbanking']") public WebElement netBbCliq;
@FindBy(xpath="//*[text()='Netbanking']") public WebElement netBbCliqarrow;
@FindBy(xpath="(//*[@class='BankSelect__image'])[2]") public WebElement bank;

@FindBy(xpath="//*[text()='Axis Bank']") public WebElement axisbank;
@FindBy(xpath="//*[text()='ICICI Bank']/preceding-sibling::*") public WebElement icicibank;

@FindBy(xpath="(//*[@class='Button__base']/span[text()='Pay now'])[3]") public WebElement paynetank;

@FindBy(xpath="//*[contains(text(),'Everyday Tech')]/preceding::div[contains(@class,'BackgroundImage')]") public WebElement bundletechImage;
//@FindBy(xpath="//h1[text()='Bundles']") public WebElement bundlePage;
@FindBy(xpath="(//*[@class='expertreviewimage'])[1]") public WebElement expertReviewVideo;
@FindBy(xpath="//*[@title='YouTube video player'] | //video") public WebElement videoWidgetoverlay;

@FindBy(xpath="//*[text()='The Westside Store']") public WebElement WestSideStoreTitle;
@FindBy(xpath="//*[contains(text(),'Westside Store')]/following-sibling::div") public WebElement WestSideNudgeDesc;
@FindBy(xpath="//*[contains(text(),'The Westside Store')]/../following-sibling::button") public WebElement WestSideNudgeButton;
@FindBy(xpath="//*[text()='Discover brands from Westside']") public WebElement WestSideDiscoverFromTileTitle;
@FindAll({@FindBy(xpath="//*[text()='Discover brands from Westside']/following-sibling::div/div")}) public List<WebElement> WestSideDiscoverFromlist;
@FindBy(xpath="(//*[@class='SizeSelector__header']/following::div/div)[3]/h4") public WebElement sizeCliq;
@FindBy(xpath="//*[@class='slctOptListItem sizeOpt']/following::a[1]/div") public WebElement sizeCliqLuxury;
@FindBy(xpath="(//*[text()='Select']/following::h4)[15]") public WebElement sizeCliqcash;
@FindBy(xpath="//*[contains(text(),'Thank you for shopping with us!')] | //*[contains(text(),', Thank You for shopping with us!')]") public WebElement orderCompleteCliq;
@FindBy(xpath="//*[text()='VIEW ORDERS'] | //*[text()='View Orders']") public WebElement viewOrdersCliq;
@FindBy(xpath="(//*[text()='Track Order'])[1]") public WebElement trackOrderCliq;

@FindBy(xpath="(//*[@class='SearchResultItem__base'])[1] | (//*[@class='ProductModule__base'])[1]") public WebElement searchResultCliq; 
@FindBy(xpath="(//*[text()='Sports'])[2]") public WebElement SportsHomepageTitle;

@FindBy(xpath="//h2[contains(text(),'Shop With Video')]") public WebElement demoVideoPage;
@FindBy(xpath="//div[@class='searchandcart']") public WebElement searchFashion;
@FindBy(xpath="//h4[contains(text(),'Handpicked offers')]") public WebElement trendingOffers;
@FindBy(xpath="//*[contains(text(),'on Nike')]/preceding::div[contains(@alt,'card background') and contains(@style,'Nike')]") public WebElement trendingOffersImage;
@FindBy(xpath="//h4[contains(text(),'Special price')]") public WebElement specialPriceStore;
@FindBy(xpath="//*[contains(text(),'Starting at') and contains(text(),'699')]/preceding::div[contains(@alt,'card background') and contains(@style,'Kurtis')]") public WebElement specialPriceStoreImage;


//SLP_Sports X-path 
@FindBy(xpath="(//*[contains(text(),'sportswear')])[1]") public WebElement Sportswear;
@FindAll({@FindBy(xpath="(//*[contains(text(),'sportswear')])[1]/following-sibling::div/div/div/div")}) public List<WebElement> SportswearList;
@FindBy(xpath="//*[text()='Shop by activity']") public WebElement ShopByActivity;
@FindAll({@FindBy(xpath="//*[text()='Shop by activity']/following-sibling::div/div")}) public List<WebElement> ShopByActivityList;


@FindBy(xpath="//*[@class='logged-in-user'] | //*[@class='DesktopHeader__nameSpan'] | //*[@class='acc-links acc-title custom']") public WebElement Loged;
@FindBy(xpath="//*[text()='Add new address'] | //*[text()='Add a new address']") public WebElement addAddress;
@FindBy(xpath="(//*[contains(text(),'Tata Loyalty Points')]/following::div)[5]") public WebElement tcpPointsCliq_checkbox;
@FindBy(xpath="//*[@class='LoyaltyPoint__editButton'] | //*[@class='LoyaltyPoint__actionButton']") public WebElement tcpPointsEditCliq;
@FindBy(xpath="//*[@class='LpPartialRedemption__materialField']/input | //*[@class='LpPartialRedemption__materialField']/input") public WebElement tcpPointsInputCliq;
@FindBy(xpath="//*[@class='LpPartialRedemption__divApplyBtn'] | //*[text()='Apply']") public WebElement tcpPointsApplyCliq;

@FindBy(xpath="//*[text()='Explore Now']") public WebElement exploreNow;

@FindBy(xpath="//*[contains(@id,'pdp')]") public WebElement pdpPage;
@FindBy(xpath="//div[@class='dropdown__text' and text()='Electronics'] | //span[contains(@class,'text_label_drop_down') and text()='Electronics']") public WebElement electronicsHomepageTitlePD;
@FindBy(xpath="//span[contains(@class,'pincode-edit')] | //a[@href='/cart']/../preceding-sibling::div//i") public WebElement editPincode;
@FindBy(xpath="//input[contains(@placeholder,'Enter Pincode')]") public WebElement inputPincode;
@FindBy(xpath="//*[contains(text(),'APPLY')]") public WebElement applyPIN;
@FindBy(xpath="//span[contains(text(),'400096')]") public WebElement verifyPIN;
@FindBy(xpath="//span[@id='cart_count_notification']") public WebElement cartCounter;
@FindBy(xpath="//a[@href='/cart']") public WebElement cart;
@FindBy(xpath="//a[@title='Delete'] | //button[text()='Remove']") public WebElement deleteproduct;
@FindBy(xpath="//button[text()='Yes']") public WebElement confirmDelete;
@FindBy(xpath="//*[contains(text(),'Your Cart is empty')]") public WebElement emptyCartMsg;

@FindBy(xpath="//div[text()='Debit cards']") public WebElement debitcard1;
@FindBy(xpath="//input[@type='radio' and @name='payment']") public WebElement checkedcard;
@FindBy(xpath="//div[text()='Preferred payment mode']") public WebElement prefferedpayment;
@FindBy(xpath="//*[text()='Success']") public WebElement successPayment;
@FindBy(xpath="//*[text()='Failure']") public WebElement failPayment;
@FindBy(xpath="//button[contains(text(),'Cancel')]") public WebElement cancelbtn;
@FindBy(xpath="//div[@data-testid='Timer-section']/div") public WebElement retrybtn;


@FindBy(xpath="//*[text()='Bag Total']/following-sibling::div") public WebElement BagTotalCliq;
@FindBy(xpath="//*[text()='Shipping Charge']/following-sibling::div") public WebElement shippingCliq;
@FindBy(xpath="//*[text()='Bag Subtotal']/following-sibling::div") public WebElement bagSubtotalCliq;
@FindBy(xpath="//*[text()='Product Discount(s)']/following-sibling::div") public WebElement discountCliq;
@FindBy(xpath="//*[text()='Total Payable']/following-sibling::div") public WebElement totalPayCliq;
@FindBy(xpath="//*[text()='Loyalty Applied']/following-sibling::div") public WebElement loyaltyappliedCliq;
@FindBy(xpath="//*[text()='Cash on Delivery']/following-sibling::*") public WebElement cod_payment;
@FindBy(xpath="//*[text()='Place order']") public WebElement place_order;
@FindBy(xpath="//*[@class='DesktopHeader__dropDownArrow']") public WebElement profile_dropdown;
@FindBy(xpath="//*[text()='My account'] | //*[text()='MY ACCOUNT']") public WebElement my_account_cliq;
@FindBy(xpath="//*[@class='UserProfile__memberTypeName']") public WebElement member_tier;
@FindBy(xpath="//*[@class='UserProfile__headingText']") public WebElement user_profile_cliq;
@FindBy(xpath="(//*[@class='Toggle__toggleInActive Toggle__toggleActive'])[1]") public WebElement cliq_cash_switch_inactive;
@FindBy(xpath="(//*[@class='Toggle__toggleActive'])[1]") public WebElement cliq_cash_switch_active;
@FindBy(xpath="//*[contains(text(),'CLiQ Cash Applied')]/following-sibling::*") public WebElement cliq_cash_applied;



//april-29
@FindBy(xpath="//*[@class='style__CloseButtonSVGWithProps-ghbJrv bSRkig'] | //*[@id='modal-close-button']") public WebElement closeOffer;
@FindBy(xpath="//*[@id='search']") public WebElement SearchCroma;
@FindBy(xpath=" //*[@id='search-a']") public WebElement searchButtonElec;
@FindBy(xpath="(//*[text()='Credit card'])[2] | //*[text()='Credit cards']") public WebElement creditcardName;

@FindBy(xpath="//*[contains(text(),'ICICI Debit & Credit Cards')]") public WebElement bankOfferCliq;
@FindBy(xpath="//span[text()='Fitness']") public WebElement SportsHomepageTitlePM;
@FindBy(xpath="//*[@class='icon searchIco'] | (//*[@class='Input2__inputBox'])[1]") public WebElement searchButtonCliqPM;
@FindBy(xpath="//input[@placeholder]") public WebElement inputSearchCliqPM;
@FindBy(xpath="//div[contains(@class,'prdInfoDesc')] | //div[contains(@class,'ProductModule__base')] | (//div[contains(@class,'icon itemOffer discount-tag')]//following::*/img)[1]") public WebElement productCliqPM;
@FindBy(xpath="//*[contains(text(),'SELECT')]") public WebElement selectSizePM;
@FindAll({@FindBy(xpath="//*[contains(@class,'sizeVariation_block')]/div/button")}) public List<WebElement> sizeListPM;
@FindBy(xpath="//*[contains(text(),'Continue Shopping')]") public WebElement continueshopping;

//@FindBy(xpath="//*[contains(text(),'ICICI Debit & Credit Cards')]") public WebElement ExpertReviewFirst;
@FindAll({@FindBy(xpath="//*[contains(text(),'Editor')]/following-sibling::div//h3 | //*[contains(text(),'Ultimate buying guide')]/following-sibling::div//h3")}) public List<WebElement> editorElect;
@FindBy(xpath="//*[contains(text(),'Editor')] | //*[contains(text(),'Ultimate buying guide')]") public WebElement Editorelect;
@FindBy(xpath="//*[contains(text(),'Top brands')]") public WebElement topBrand;
@FindBy(xpath="//*[contains(text(),'101 to buying gadgets')]") public WebElement guideToElectronics;
@FindBy(xpath="//*[contains(text(),'Exchange now')]") public WebElement ExchangeElectronics;
@FindBy(xpath="(//*[contains(text(),'Shop With Video')])[2]") public WebElement videoElect;
@FindAll({@FindBy(xpath="//*[contains(text(),'Fashion update')]/../following-sibling::div//h3")}) public List<WebElement> videoFashionlist;
@FindBy(xpath="//*[contains(text(),'Fashion update')]") public WebElement videoFashion;
@FindBy(xpath="//*[contains(text(),'close video')]") public WebElement ClosevideoFashion;
@FindAll({@FindBy(xpath="//*[contains(text(),'Trending offers')]/../../following-sibling::div//h5")}) public List<WebElement> TrendOffFashlist;
@FindBy(xpath="//*[contains(text(),'Fashion update')] | //*[contains(text(),'Trending offers')] | //*[contains(text(),'Trending products')]") public WebElement TrendOffFashion;


@FindBy(xpath="//*[contains(text(),'No thanks')] | //*[contains(text(),'Block')]") public WebElement noThanks;
@FindBy(xpath ="(//*[contains(text(),'Failure - Reversed')])[1]") public WebElement aborted_failed_reversed_transaction_text;
@FindBy(xpath ="(//*[@data-testid='data-div-container']//following::div/div[1])[1]") public WebElement firstOrder;
@FindBy(xpath="//label[text()='View']") public WebElement viewChange;

@FindBy(xpath="//*[@alt='cancel_icon']") public WebElement closePaymentsum;
@FindBy(xpath="//*[@alt='hamberger-icon']") public WebElement hamburger;
// @FindBy(xpath="//*[contains(text(),'Order history')]") public WebElement OrderHistory;
@FindBy(xpath="//*[contains(text(),'My transactions')]") public WebElement OrderHistory;

@FindBy(xpath="//*[contains(text(),'Beauty trends')]") public WebElement BeautySubCat;
@FindBy(xpath="//div[@class='videocontainer']//div//div") public WebElement BeautySubCatlist;

@FindBy(xpath="//*[contains(text(),'Please enter')]") public WebElement autoLogInCliq_android;
@FindBy(xpath="//*[contains(text(),'Make Payment')] | //*[contains(text(),'Payment Method')]") public WebElement paymentPageCliq;

@FindBy(xpath="//*[text()='Shop & Explore'] | //*[text()='Shop & explore']") public WebElement shopNow;
@FindBy(xpath="//*[text()='Cash on Delivery']") public WebElement CodCliq;


@FindBy(xpath="//*[@class='MuiSvgIcon-root jss70 MuiSvgIcon-fontSizeLarge'] | //*[contains(@class,'MuiSvgIcon-root jss')]") public WebElement CloseVideo;
@FindBy(xpath="(//*[text()='Beauty'])[1]") public WebElement BeautyHomepageTitleMob;
@FindBy(xpath="//*[text()='Cancel']") public WebElement cancelButton;

//17-5
@FindBy(xpath="//*[contains(@class,'cartcontainer')]/*") public WebElement cartSLP;
@FindBy(xpath="//span[contains(@class,'style__BackIcon')]/*") public WebElement backTPM;
@FindBy(xpath="//div[contains(@class,'style__Description')]//h4 | //div[contains(@class,'style__Description')]/div/label[1]") public WebElement cancelMessageTPM_android;


//MAy-18
@FindBy(xpath="(//*[contains(text(),'Skincare')])[2]") public WebElement skincareBeauty;
@FindAll({@FindBy(xpath="(//*[contains(text(),'Skincare')])[2]/following-sibling::div//p")}) public List<WebElement> skincareBeautylist;
@FindBy(xpath="//*[contains(text(),'Fragrances')]") public WebElement fragrancesBeauty;
@FindAll({@FindBy(xpath="//*[contains(text(),'Fragrances')]/following-sibling::div//p")}) public List<WebElement> fragranceslist;
@FindBy(xpath="(//*[contains(text(),'Makeup')])[3]") public WebElement MakeupBeauty;
@FindAll({@FindBy(xpath="//*[contains(text(),'Makeup')]/following-sibling::div//p")}) public List<WebElement> makeuplist;
@FindBy(xpath="//*[text()='Hair']") public WebElement HairBeauty;
@FindAll({@FindBy(xpath="//*[text()='Hair']//../following-sibling::div//p")}) public List<WebElement> HairBeautylist;
@FindBy(xpath="//*[text()='Mens grooming ']") public WebElement MenBeauty;
@FindAll({@FindBy(xpath="//*[text()='Mens grooming ']/following-sibling::div//p")}) public List<WebElement> MenBeautylist;
@FindBy(xpath="//*[text()='Payment']") public WebElement paymentArrow;

@FindBy(xpath="//*[text()='Netbanking']") public WebElement netBbCliqarrowMob;


//DTH Service_TATA SKY
@FindBy(xpath="(//*[text()='DTH Services'])[1] | //*[text()='DTH'] | //*[text()='Entertainment']") public WebElement dthService;
@FindBy(xpath="//*[text()='DTH Services']//following::*[text()='Explore']") public WebElement dthService_ExploreBtn;
@FindBy(xpath="//*[text()='Tata Sky'] | //*[text()='Link your Tata Sky account']") public WebElement tataSky;
@FindBy(xpath="//*[text()='Existing Customer']") public WebElement existingCust_Radiobtn;
@FindBy(xpath="//*[text()='Get Tata Sky'] | //input[contains(@value,'New to Tata Sky')]") public WebElement getTatSky_Radiobtn;

@FindBy(xpath="//*[text()='Submit'] | //button[text()='Next']") public WebElement submitbtn;
@FindBy(xpath="//button[text()='Cancel'] | //button[text()='Skip']") public WebElement skipbtn;

@FindBy(xpath="//div[@class='dropdown__text' and text()='TataSky'] | //div[@class='dropdown__text' and text()='DTH'] | //*[contains(@class,'text_label_drop_down') and text()='Entertainment']") public WebElement tataSkyHomepageTitle;

@FindBy(xpath="//*[text()='Recharge']") public WebElement rechargebtn;
@FindBy(xpath="//*[text()='Rent'] | //*[text()='Order showcase']") public WebElement btnRent;
@FindBy(xpath="//*[text()='TATA SKY']") public WebElement hdrTatasky;
@FindBy(xpath="//*[@value='3001375454']") public WebElement subscritionId;

@FindBy(xpath="//*[text()='Continue']") public WebElement btnContinue;

@FindBy(xpath="//*[contains(text(),'subscriber ID')]") public WebElement idLinked;
@FindBy(xpath="//*[text()='Continue'] | //*[text()='Next']") public WebElement continueBtn;


@FindBy(xpath="//*[contains(@class,'slick-arrow slick-next')]/*") public WebElement arrowNext;

@FindBy(xpath="//*[contains(text(),'Pay Now')]") public WebElement paynetank_mobile;

//Juspay frame
@FindBy(xpath="//*[@id='juspay_iframe'] | //iframe[@id='juspay_iframe']") public WebElement juspayIframe;
@FindBy(xpath="//div[@id='containercheck']") public WebElement shareOptionYouTube;
@FindBy(xpath="//img[@alt='bookmarkIcon']") public WebElement bookmarkYouTube;
@FindBy(xpath="//*[contains(text(),'Buy')]  | (//*[contains(text(),'Buy now')])[1]") public WebElement buyNowCDP;


//20-5
@FindAll({@FindBy(xpath="//*[contains(text(),'Expert speak')]/../following-sibling::div//ul/li")}) public List<WebElement> expertSpeakDot;

//Big Basket PWA
@FindBy(xpath="//*[contains(text(),'Buy')]") public WebElement bbMenuOptionsPWA;
@FindBy(xpath="//*[contains(@class,'text_label_drop_down') and text()='Grocery']") public WebElement bbhompagePD;
@FindBy(xpath="//a[text()='Login' and @ng-show]") public WebElement bbloginCTAPD;
@FindBy(xpath="//ul[@class='list-unstyled list-inline login-section']") public WebElement bbloginSecPD;
@FindBy(xpath="//*[text()='Aakash'] | //*[text()='TechOps'] | //*[text()='Sourav'] | //*[text()='SyntheticMonitoringThirty']") public WebElement bbloginThirdPD;
@FindBy(xpath="//li[@ng-if]//span[contains(@ng-bind,'memberinfo')]") public WebElement bbloggedinPD;
@FindBy(xpath="//span[contains(@ng-bind,'memberinfo')] | //div[contains(@class,'MemberDropdown')]") public WebElement bbloggedin1PD;
@FindBy(xpath="(//input[@placeholder='Search for Products..'])[1]") public WebElement bbsearchPD;
@FindBy(xpath="//button[@qa='searchBtn'] | //button[@value='Search']") public WebElement bbSearchCTAPD;
@FindBy(xpath="//span[@id='totalNumberOfCartItems']") public WebElement bbcartCountPD; //to hover
//@FindBy(xpath="//*[@class='item-remove']") public WebElement bbremoveItemPD;
@FindBy(xpath="//div[@class='slick-slide slick-active slick-current']//div//button[@class='herboBannerButton']") public WebElement ShopNowBtn;
@FindAll({@FindBy(xpath="//*[contains(@class,'item-remove')]")}) public List<WebElement> bbremoveItemPD;
//@FindBy(xpath="//button[@qa='add']") public WebElement bbaddproductPD;
@FindAll({@FindBy(xpath="//button[@qa='add']")}) public List<WebElement> bbaddproductPD;
@FindBy(xpath="//*[@qa='myBasket']") public WebElement bbBasketIconPD; //to hover
@FindBy(xpath="//*[@qa='viewBasketMB']") public WebElement bbcheckoutIconPD; 
@FindBy(xpath="//h4[contains(text(),'Your Basket')]") public WebElement bbBasketPagePD;
@FindBy(xpath="//*[@id='checkout']") public WebElement bbcheckoutCTAPD;
@FindBy(xpath="//*[contains(text(),'Availablity check')] | //*[contains(text(),' Availability Check')]") public WebElement bbAvalCheckPD;
@FindBy(xpath="//*[contains(text(),'CONFIRM')] | (//*[contains(text(),'Confirm')])[2]") public WebElement bbconfirmPD;
@FindBy(xpath="//*[contains(text(),'Use bbwallet')]") public WebElement bbuseWalletPD;
@FindBy(xpath="//*[contains(text(),'Default Address') and @class='badge text-primary']") public WebElement bbDeliveryPagePD;
//@FindBy(xpath="//*[contains(text(),'Deliver Here')]") public WebElement bbDeliverCTAPD;
@FindAll({@FindBy(xpath="//*[contains(text(),'Deliver Here')]")}) public List<WebElement> bbDeliverCTAPD;
@FindBy(xpath="//span[contains(text(),'Availability Check')]") public WebElement bbAvalChecksecondPD;
@FindBy(xpath="//*[contains(text(),'Confirm')]") public WebElement bbconfirmsecondPD;
@FindBy(xpath="//*[@qa='changeAddressCKO']") public WebElement bbchangeAddressCTAPD;
@FindBy(xpath="//*[contains(text(),'Delivery Options')]") public WebElement bbdelOptionSectionPD;
@FindBy(xpath="//button[contains(text(),'PROCEED TO PAYMENT')]") public WebElement bbproceedPayCTAPD;
//@FindBy(xpath="//article[contains(text(),'Cash On Delivery')]") public WebElement bbCODoptPD;
@FindAll({@FindBy(xpath="//article[contains(text(),'Cash On Delivery')]")}) public List<WebElement> bbCODoptPD;
//@FindBy(xpath="//*[contains(text(),'Place order')]") public WebElement bbplaceOrderCODPD;
@FindBy(xpath="//article[contains(text(),'Payment Options With Offer')]") public WebElement bbOfferPaySecPD;
@FindAll({@FindBy(xpath="(//article[contains(text(),'Tata Pay')])[1]")}) public List<WebElement> bbTataPayPD;
@FindAll({@FindBy(xpath="(//article[contains(text(),'Place order & Pay')])[3]")}) public List<WebElement> bbplaceOrderPD;
@FindBy(xpath="//*[@ng-click='restartCheckout()']") public WebElement restartCheckoutPD;
@FindBy(xpath="//div[contains(text(),'PAY NOW')]") public WebElement PayNowBtn;
@FindBy(xpath="//button[text()='PAY NOW']") public WebElement PayNowClick;
@FindBy(xpath="(//article[contains(text(),'Tata Pay')])[5]") public WebElement TataPayBtn;
@FindBy(xpath="(//article[contains(text(),'Pay')])[13]") public WebElement PayBtn;
@FindBy(xpath="//*[@title='Close chat']") public WebElement closeChatPD;
//@FindBy(xpath="//*[@title='Close chat']") public WebElement closeChatPD;
@FindBy(xpath="//button[text()='Yes']") public WebElement closeChatconfirmPD;
@FindAll({@FindBy(xpath="//*[text()='Shop by category']/following-sibling::div/div")}) public List<WebElement> categoryselectTitlePD;
@FindBy(xpath="//*[text()='Speciality stores']") public WebElement spltStoresPD;
@FindAll({@FindBy(xpath="//*[text()='Speciality stores']/following-sibling::div/div")}) public List<WebElement> spltStoreselectTitlePD;
@FindBy(xpath="//*[@qa='userAccount'] | //*[contains(@class,'uiv2-loggedin-user-link')]") public WebElement bbuserAccPD;
@FindBy(xpath="//*[@qa='walletLink']") public WebElement bbwalletLinkPD;
@FindBy(xpath="//*[text()='MY WALLET']") public WebElement bbmyWalletPagePD;
@FindBy(xpath="//*[text()='FUND WALLET']") public WebElement bbfundWalletCTAPD;
@FindBy(xpath="//*[text()='FUND THE WALLET']") public WebElement bbfundWalletpagePD;
@FindBy(id="id_amount_to_fund") public WebElement bbinputAmtPD;
@FindBy(xpath="//*[@qa='submitMW']") public WebElement bbsubmitPD;
@FindBy(xpath="//*[text()='Choose a payment option']") public WebElement bbpaymentPagePD;
@FindBy(xpath="//*[text()='Cards (Credit/Debit)']") public WebElement bbcardsPD;
@FindBy(xpath="//*[@id='cardNumber']") public WebElement bbinputCardNoPD;
@FindBy(xpath="//*[@id='cardExpiry']") public WebElement bbcardExpiryPD;
@FindBy(xpath="//*[@id='cardCvv']") public WebElement bbcvvPD;
@FindBy(xpath="//*[@id='cardOwnerName']") public WebElement bbOwnernamePD;
@FindBy(xpath="//*[text()='PROCEED']") public WebElement bbproceedCTAPD;
@FindBy(xpath="//*[contains(text(),'You have successfully added')]") public WebElement bbmoneySuccessPD;
@FindAll({@FindBy(xpath="//article[contains(text(),'Full payment will be made through')]")}) public List<WebElement> onlybbConfirmPD;
@FindBy(xpath="//*[contains(text(),'Yaay')]") public WebElement orderPlacedPD;
@FindBy(xpath="//*[@class='Smartbasketcontainer']") public WebElement smartbasketPD;
@FindBy(xpath="//*[@class='Smartbasketcontainer']//button") public WebElement smartbasketCTAPD;
@FindBy(xpath="//*[text()='Handpicked offers for you']") public WebElement bbHandpickedPD;
@FindBy(xpath="//*[text()='Products recommended for you']") public WebElement bbRecommendedPD;
@FindBy(xpath="//*[text()='Super saver offers']") public WebElement bbSuperSaverPD;
@FindBy(xpath="//*[text()='Eat healthy']") public WebElement bbEatHealthyPD;
@FindAll({@FindBy(xpath="//*[contains(text(),'recommended')]/../following-sibling::div/div/div/div")}) public List<WebElement> bbrecommendedPD;
@FindAll({@FindBy(xpath="//*[contains(text(),'Super')]/../../following-sibling::div/div/div/div")}) public List<WebElement> bbSuperSaverListPD;
@FindAll({@FindBy(xpath="//*[contains(text(),'Eat healthy')]/../../following-sibling::div/div/div/div")}) public List<WebElement> bbEatHealthyListPD;
@FindAll({@FindBy(xpath="//*[contains(text(),'recommended')]/../../following-sibling::div//h5")}) public List<WebElement> bbhandPickedListPD;
@FindBy(xpath="//*[contains(text(),'bbstar')]") public WebElement bbstarPD;
@FindBy(xpath="//*[@class='joinbtntext']//*[contains(text(),'Explore')]") public WebElement bbStarCTAPD;
@FindAll({@FindBy(xpath="//button[contains(text(),'JOIN NOW')]")}) public List<WebElement> bbstarJoinNowPD;
@FindBy(xpath="//*[@class='payment-details']") public WebElement paymentPopupPD;
@FindBy(xpath="//button[contains(text(),'Pay with bbwallet')]") public WebElement paywithBBCTAPD;
@FindAll({@FindBy(xpath="//*[contains(text(),'You are a bbstar member')]")}) public List<WebElement> bbstarsuccessPD;
@FindBy(xpath="//h4[text()='Trending products']") public WebElement bbtrendingOffersPD;
@FindBy(xpath="//h4[contains(text(),'like these')]") public WebElement bbCrossBrandPD;
@FindBy(xpath="//h4[contains(text(),'Recipes')]") public WebElement bbrecipesPD;
@FindBy(xpath="//h3[contains(text(),'Top brands')]") public WebElement bbtopBrandsPD;
@FindAll({@FindBy(xpath="//*[contains(text(),'Trending')]/../../following-sibling::div//h5 | //*[contains(text(),'Trending')]/../following-sibling::div/div/div/div")}) public List<WebElement> trendingofferProdPD;

//MAy20
//Akshya
@FindBy(xpath="//*[text()='New'] | //*[text()='New connection']") public WebElement btnNew;
@FindBy(xpath="//*[text()='Register']") public WebElement textRegister;
@FindBy(xpath="(//*[@id='radio-unchecked-a'])[1] | (//*[text()='Home']/..//preceding-sibling::input[@type='radio'])[1] | (//*[text()='home']/..//preceding-sibling::input[@type='radio'])[1]") public WebElement RadiobtnHome;
@FindBy(xpath="//*[contains(text(),'Pay Online')]") public WebElement payonlinebtn;
@FindBy(xpath="//*[contains(text(),'Opel')]") public WebElement btnOpelPayment;
@FindBy(xpath="(//*[text()='Pay with TCP']//following::*[contains(@class,'radioButtoView')])[1]") public WebElement btnPaywithTataPayApp;

@FindBy(xpath="(//*[text()='Proceed to pay'])[1]") public WebElement btnProceedtoPay;
@FindBy(xpath="//*[text()='Change']") public WebElement btnChange;
@FindBy(xpath="//*[text()='More Banks']") public WebElement btnMoreBanks;
@FindBy(xpath="//*[text()='Billdesk Test Bank']") public WebElement btnBilldeskTestBank;
@FindBy(xpath="//*[@id='BankStatus']") public WebElement dropdownBankstatus;
@FindBy(xpath="//*[@id='SubmitForm']") public WebElement btnSubmit;
@FindBy(xpath="//*[contains(text(),'Payment done')]") public WebElement hdrpaymentdone;
@FindBy(xpath="//*[contains(text(),'Your transaction ID')]") public WebElement TxttansactionID;


@FindAll({@FindBy(xpath="//*[contains(text(),'Speciality stores')]/following-sibling::div/div")}) public List<WebElement> specialStoreEssentList;
@FindBy(xpath="//*[contains(text(),'Speciality stores')]")public WebElement specialStoreEssent;
@FindAll({@FindBy(xpath="//*[contains(text(),'Top brands')]/../following-sibling::div/div")}) public List<WebElement> topBrandsEssentList;
@FindBy(xpath="//*[contains(text(),'Top brands')]")public WebElement topBrandsEssent;
@FindAll({@FindBy(xpath="//*[contains(text(),'Recipes, tips & more')]/../../following-sibling::div//h5")}) public List<WebElement> ReceipeEssentList;
@FindBy(xpath="//*[contains(text(),'Recipes, tips & more')]")public WebElement ReceipeEssent;

@FindAll({@FindBy(xpath="//*[contains(text(),'Shop by category')]/following-sibling::div/div")}) public List<WebElement> shopCategEssentList;
@FindBy(xpath="//*[contains(text(),'Shop by category')]")public WebElement shopCategEssent;
@FindBy(xpath="//*[@name='PAID']") public WebElement paymentoption;
//May24
@FindBy(xpath="(//*[@alt='hamburger-menu'])[1]") public WebElement bbMenu_PM;
@FindBy(xpath="//*[text()='Login']") public WebElement bbMylogin_PM;
@FindBy(xpath="(//*[text()='My Account'])[3]") public WebElement bbMyAcc_PM;
@FindBy(xpath="(//*[text()='My Account'])[2]") public WebElement bbMyAccPage_PM;
@FindBy(xpath="//*[contains(text(), 'My Wallet')]") public WebElement bbWallet_PM;
@FindBy(xpath="//*[contains(text(), 'Wallet Summary')]") public WebElement Wallet_Page_PM;
@FindBy(xpath="//*[contains(text(), 'Fund Wallet')] | //*[contains(text(), 'Fund wallet')]") public WebElement addMoneyWallet_PM;
@FindBy(xpath="//*[contains(text(), 'Fund your wallet')] | //*[contains(text(), 'Fund the wallet')]") public WebElement FundWalletPage_PM;
@FindBy(xpath="//*[contains(@id, 'id_amount_to_fund')]") public WebElement enterAmountBB_PM;
@FindBy(xpath="//input[contains(@type,'submit')]") public WebElement submitBB_PM;
@FindBy(xpath="//*[contains(text(),'Choose a payment')]") public WebElement paymentPageBB_PM;
@FindBy(xpath="//*[contains(text(),'Cards')]") public WebElement typeCards_BB_PM;
@FindBy(xpath="//*[@id='cardNumber']") public WebElement cardNo_BB_PM;
@FindBy(xpath="//*[@id='cardExpiry']") public WebElement expiry_BB_PM;
@FindBy(xpath="//*[@id='cardCvv']") public WebElement cvv_BB_PM;
@FindBy(xpath="//*[@id='cardOwnerName']") public WebElement nameOnCard_BB_PM;
@FindBy(xpath="//*[contains(text(),'thankyou')]") public WebElement add_success_PM;
@FindBy(xpath="//*[contains(text(),'PROCEED')]") public WebElement pROCEED_BB_PM;
@FindBy(xpath="//*[@id='popup_content']//a[@href='#']") public WebElement closeSuccessPopup_PM;
@FindBy(xpath = "//*[@alt='back']") public WebElement Back_PM;
@FindBy(xpath = "//*[@qa='basketFooter']") public WebElement BasketBB;
@FindBy(xpath = "(//*[contains(text(),'Review Basket')])[2] | (//*[contains(text(),'Basket')])[2]") public WebElement ReviewBasketPgBB;
@FindBy(xpath="//*[contains(text(),'Your basket is empty')]") public WebElement emptyBasket_PM;
@FindBy(xpath="//*[@alt='more']") public WebElement threedotBB_PM;
@FindBy(xpath="//*[@id='emptyBasket']") public WebElement emptyBasketCTA_PM;
@FindBy(xpath="//*[contains(text(),'Do you want to')]") public WebElement emptyBasketpopUp_PM;
@FindBy(xpath="//*[contains(text(),'YES')]") public WebElement bbaccept_PM;

@FindBy(xpath="(//*[text()='Order'])[1]") public WebElement btnOder;
@FindBy(xpath="//*[text()='Confirm']//parent::button") public WebElement btnconfirm;
@FindBy(xpath="//*[contains(text(),'Payment Complete')]") public WebElement sucessmesg;
@FindBy(xpath="//*[contains(text(),'Payment Failed')]") public WebElement failuremesg;


@FindBy(xpath="(//*[@alt='hamburger-menu'])[2]") public WebElement searchBB_PM;
@FindBy(xpath="(//*[@alt='hamburger-menu'])[2]") public WebElement searchBBcart_PM;
@FindBy(xpath="//*[@id='productSearch']") public WebElement searchInputBB_PM;
@FindBy(xpath="(//*[contains(text(),'ADD')])[1]") public WebElement ADDBB_PM;
@FindBy(xpath="//*[@qa='addMoreItems']") public WebElement plusIconBB_PM;
@FindBy(xpath = "//*[contains(text(),'CHECKOUT')]") public WebElement checkoutAndBB;
@FindBy(xpath = "//*[contains(text(),'PROCEED TO PAY')]") public WebElement proceedPayAndBB;
@FindBy(xpath = "//*[contains(text(),'Payment')]") public WebElement PaymentPgAndBB;
@FindBy(xpath = "//*[contains(text(),'Tatapay')] | //*[contains(text(),'Pay with Tata')]") public WebElement TataPayBB;
@FindBy(xpath = "(//*[contains(text(),'Place order & Pay')])[3]") public WebElement placeOrderTPBB;
@FindBy(xpath = "(//*[contains(text(),'Place order & Pay')])[1]") public WebElement placeOrderWalletBB;
@FindBy(xpath = "(//*[contains(text(),'Place order & Pay')])[6]") public WebElement placeOrderCODBB;
@FindBy(xpath = "//*[contains(text(),'Continue')]") public WebElement continueBB;
@FindBy(xpath="//*[contains(text(),'Availability Check')]") public WebElement avalcheckPage_PM;
@FindBy(xpath="//*[contains(text(),'CONFIRM')]") public WebElement confirm_PM;
@FindBy(xpath="//*[text()='Use bbwallet balance']") public WebElement bbwalletUse_PM;
@FindBy(xpath="(//*[contains(text(),'Cash On')])[5]") public WebElement COD_PM;
@FindBy(xpath="//*[contains(text(),'Delivery Options')]") public WebElement delOptions_PM;
@FindBy(xpath = "//*[contains(text(),'Default Address')]") public WebElement defaultAddressBB;
@FindBy(xpath = "//*[contains(@class,'EachHeroBannerlowersection_right')]//button") public WebElement clickHerobannerPM;
@FindBy(xpath="//*[text()='Meat store']") public WebElement meatStores_PM;
@FindBy(xpath="//*[text()='Fruits & vegetables']") public WebElement fandv_PM;
@FindBy(xpath="//*[contains(text(),'Search 18000')]//parent::div") public WebElement searchBoxBB_PM;
@FindBy(xpath="//input[@id='SearchInputBox']") public WebElement searchBtnBB_PM;

//May31
//Book Flight
@FindBy(xpath="//*[text()='Flights'] | (//div[@class='component11']//p)[7]") public WebElement SLPflight;
@FindBy(xpath="(//a[@href='/home'])[1]") public WebElement SLPflightHome;
@FindBy(xpath="//*[contains(text(),'Login')]") public WebElement SLPflightUserLoged;
@FindBy(xpath="//*[contains(text(),'Fly to')]") public WebElement SLPflightDestDropdown;
@FindBy(xpath="//*[@placeholder='Search City'] | //*[@id='basic-url']") public WebElement SLPflightDestInput;
@FindBy(xpath="(//*[@placeholder='Search City']/following::div)[1]/div//button | (//*[@id='list-item'])[1]") public WebElement SLPflightDestResultInput;
@FindBy(xpath="//*[contains(text(),'1 Guest')]/following::img[1]") public WebElement SLPflightpassDrop;


//AEM sign up hotls SLP
@FindBy(xpath="//*[@id='username']") public WebElement usernameAEM_signIn;
@FindBy(xpath="//*[@id='password']") public WebElement passwordAEM_signIn;
@FindBy(xpath="//*[@id='submit-button']") public WebElement SignUpButtonAEM_signIn;

@FindBy(xpath="//*[contains(text(),'Adult')]/following::img[2]") public WebElement SLPflightaddAdult;
@FindBy(xpath="(//*[contains(text(),'Child')]/following::div/img[2])[1]") public WebElement SLPflightaddChild;
@FindBy(xpath="(//*[contains(text(),'Infant')]/following::div/img[2])[1]") public WebElement SLPflightaddInfant;
@FindBy(xpath="//*[contains(text(),'Done')]") public WebElement SLPflightpassDone;
@FindBy(xpath="//*[@id='flight-tab']/div[3]/img | //img[@class='flight-search-icon']") public WebElement SLPflightGOArrow;
@FindBy(xpath="(//input[@type='radio'])[1]") public WebElement SLPDirectFlightPrice;
@FindBy(xpath="((//*[@alt='stop-icon'])[1]/../following::div//input)[1]") public WebElement SLPInDirectFlightPrice;
@FindBy(xpath="//*[contains(text(),'Continue')]") public WebElement SLPflightContinue;
@FindBy(xpath="(//*[contains(text(),'First Name')]/preceding-sibling::input)[1]") public WebElement SLPflightfirstName;
@FindBy(xpath="(//*[contains(text(),'Last Name')]/preceding-sibling::input)[1]") public WebElement SLPflightlastName;
@FindBy(xpath="(//*[contains(text(),'DoB')]/preceding-sibling::input)[1]") public WebElement SLPflightDoB;

//June 02
@FindBy(xpath="//*[text()='Shoe store']") public WebElement shoeStore;
@FindAll({@FindBy(xpath="//*[text()='Shoe store']/../../following-sibling::div//h5")}) public List<WebElement> shoeStoreTitle;
@FindBy(xpath="//*[text()='Offers in spotlight']") public WebElement offSports;
@FindAll({@FindBy(xpath="//*[text()='Offers in spotlight']/../../following-sibling::div//h5")}) public List<WebElement> offSportsTitle;
@FindBy(xpath="//*[text()='From the QUE Magazine'] | //*[contains(text(),'From the Que')]") public WebElement QueMagContent;
@FindAll({@FindBy(xpath="//*[text()='From the QUE Magazine']/../../following-sibling::div//h5 | //*[contains(text(),'From the Que')]/../../following-sibling::div//h5")}) public List<WebElement> QueMagContentTitle;
@FindBy(xpath="//*[text()='Trending offers']") public WebElement TrendOffBeauty;
@FindAll({@FindBy(xpath="//*[text()='Trending offers']/../../following-sibling::div//h5")}) public List<WebElement> TrendOffBeautyTitle;
@FindBy(xpath="//*[text()='Handpicked offers for you']") public WebElement RecomOffFas;
@FindAll({@FindBy(xpath="//*[text()='Handpicked offers for you']/../../following-sibling::div//h5")}) public List<WebElement> RecomOffFasTitle;
@FindBy(xpath="//*[contains(text(),'like these too')]") public WebElement CrossBrandFash;
@FindAll({@FindBy(xpath="//*[contains(text(),'like these too')]/following-sibling::div[1]//div[@class='recentDeals']")}) public List<WebElement> CrossBrandFashlist;
@FindBy(xpath="//*[text()='404 Error page not found'] | //*[contsins(text(),'ERROR 500']") public WebElement ErrorPDP;
@FindBy(xpath="//*[contains(text(),'Trending products')]") public WebElement TrendingOffElect;
@FindAll({@FindBy(xpath="//*[contains(text(),'Trending products')]/following-sibling::div//div[@class='recentDealsTitle'] | //*[contains(text(),'Trending products')]/../following-sibling::div//div[@class='recentDealsTitle']")}) public List<WebElement> TrendingOffElectlist;
@FindBy(xpath="//*[contains(text(),'Curated for you')] | //*[contains(text(),'Recommended for you')]") public WebElement CuratedOffElect;
@FindAll({@FindBy(xpath="//*[contains(text(),'Curated for you')]/../../following-sibling::div//h5 | //*[contains(text(),'Recommended for you')]/../../following-sibling::div//h5")}) public List<WebElement> CuratedOffElectlist;
@FindBy(xpath="//*[contains(text(),'Handpicked offers for you')]") public WebElement HandPickOffElect;
@FindAll({@FindBy(xpath="//*[contains(text(),'Handpicked offers for you')]/../../following-sibling::div//h5")}) public List<WebElement> HandPickOffElectlist;
@FindBy(xpath="//*[contains(text(),'Still looking for these')]") public WebElement RecommenStillOffElect;
@FindAll({@FindBy(xpath="//*[contains(text(),'Still looking for these')]/following-sibling::div//div[@class='recentDealsTitle'] | //*[contains(text(),'Still looking for these')]/../following-sibling::div//div[@class='recentDealsTitle']")}) public List<WebElement> RecommenStillElectlist;
@FindBy(xpath="//*[contains(text(),'Offers running out soon')]") public WebElement LimitedOffElect;
@FindAll({@FindBy(xpath="//*[contains(text(),'Offers running out soon')]/following-sibling::div//div[@class='recentDeals'] | //*[contains(text(),'Offers running out soon')]/../../following-sibling::div//h5")}) public List<WebElement> LimitedOffElectElectlist;

//june 03
@FindBy(xpath="//*[contains(text(),'Your Cart')]") public WebElement cartPage;
@FindBy(xpath="//*[contains(text(),'PAYMENT METHODS')] | //*[contains(text(),'Payment methods')]") public WebElement paymentMethod;
@FindBy(xpath="//*[contains(text(),'Exchange now')]/../preceding-sibling::div") public WebElement Exchangetext;
@FindBy(xpath="//*[contains(text(),'Book a slot ')]") public WebElement videoshopElectronics;
@FindBy(xpath="//*[contains(text(),'Book a slot ')]/../preceding-sibling::div") public WebElement videoshopElectronicsTxt;
@FindBy(xpath="//*[contains(text(),'Your Cart is empty')]") public WebElement cartEmpty;
@FindBy(xpath="//*[contains(text(),'Exchange')] | (//*[contains(text(),'Exchange')])[2]") public WebElement Exchange;

//june04
@FindBy(xpath="(//*[contains(text(),'No, thanks')])[2]") public WebElement NoThanksCliq;
@FindBy(xpath="//*[contains(text(),'Lifestyle store')]") public WebElement Lifestore;
@FindAll({@FindBy(xpath="//*[contains(text(),'Lifestyle store')]/../../following-sibling::div//h5")}) public List<WebElement> Lifestorelist;

//june 07
@FindBy(xpath = "(//*[ text()='Electronics'])[1]") public WebElement ElectronicsTitle_PM;
@FindBy(xpath="//*[text()='Allow'] | //*[contains(text(),'Allow')]") public WebElement allowPwaMob;
@FindBy(xpath ="(//*[contains(text(),'Transactions')]/../../following::div//span)[1]") public WebElement firstOrderPM;
@FindBy(xpath ="//*[contains(text(),'Success')]") public WebElement successPM;


//June 08
@FindBy(xpath="//*[text()=\"Women's edit\"]") public WebElement womensSports;
@FindAll({@FindBy(xpath="//*[text()=\"Women's edit\"]/following-sibling::div//p")}) public List<WebElement> WomenslistSports; 
@FindBy(xpath="//*[text()=\"Men's edit\"]") public WebElement MensSports;
@FindAll({@FindBy(xpath="//*[text()=\"Men's edit\"]/following-sibling::div//p")}) public List<WebElement> MenslistSports;
@FindBy(xpath="//*[text()=\"Kids' edit\"]") public WebElement kidsSports;
@FindAll({@FindBy(xpath="//*[text()=\"Kids' edit\"]/following-sibling::div//p")}) public List<WebElement> KidslistSports;

//Akshya
@FindBy(xpath ="(//*[text()='VIEW HOTEL'])[1]") public WebElement btnViewhotel;
@FindBy(xpath ="//*[@id='Guest Rooms']") public WebElement btnGuestRooms;
@FindBy(xpath ="(//*[contains(text(),'Oops')]/following::div)[1]") public WebElement btnClose;
@FindBy(xpath ="//*[text()='STANDARD RATES']") public WebElement btnStandardrates;
@FindBy(xpath ="//*[text()='ROOM REDEMPTION RATES']") public WebElement btnroomRedemptionrates;
@FindBy(xpath ="(//*[contains(text(),'VIEW RATES')])[1]") public WebElement btnviewRates;
@FindBy(xpath ="//*[@value='Return To the Merchant Site']") public WebElement btnReturntMerchantSite;
@FindBy(xpath ="//*[@data-testid='message-success']") public WebElement Successmesg;


@FindBy(xpath ="(//*[@data-testid='details-container'])/div[1]/div[1]/div[3]/label[2]") public WebElement order_status;

//17-6
@FindBy(xpath ="//a[contains(text(),'Shop')] | //a[contains(text(),'Buy')] | (//a[contains(text(),'Shop')])[1]") public WebElement CTA_CDP;
//21-6
@FindBy(xpath="//*[text()=\"The page you are looking for can't be found\"] | //*[contains(text(),'Server Error')] | //*[contains(text(),'404 This page does not exist')] | //*[contains(text(),'Please try searching for something else')]") public WebElement ErrorPDPCliq;
@FindBy(xpath ="(//*[contains(@class,'Title-of-the-article')])[1]") public WebElement Title_CDP;
@FindBy(xpath ="(//*[@alt='bookmark'])[1]") public WebElement Bookmark_CDP;
@FindBy(xpath ="(//*[contains(@class,'popup')])[1]") public WebElement share_CDP;
@FindBy(xpath="//div[contains(@id,'backdirection')]/img") public WebElement back_CDP;
@FindBy(xpath="//div[@class='searchandcart']/*[1] | //*[@alt='searchIcon'] | //input[@id='SearchInputBox']") public WebElement SearchCromaFromSLP;

//23jun
@FindBy(xpath="//*[contains(text(),'Travel inspiration for you')]") public WebElement TravelInspirationTitle;
@FindAll({@FindBy(xpath="//*[contains(text(),'Travel inspiration for you')]/../../following-sibling::div//h5")}) public List<WebElement> TravelInspirationTitlelist;
@FindBy(xpath ="(//img[@alt='bookmark'])[1]") public WebElement Bookmark_TravelCDP;
@FindBy(xpath ="//*[contains(text(),'Book now')] ") public WebElement Booknow_IHCL_CDP;
@FindBy(xpath="(//*[contains(text(),'Exchange')])[2]") public WebElement ExchangeCroma;

@FindBy(xpath="//*[contains(text(),'Most booked stays')]") public WebElement MostViewedStaysTitle;
@FindAll({@FindBy(xpath="//*[contains(text(),'Most booked stays')]/../following-sibling::div//h5")}) public List<WebElement> MostViewedStayslist;

@FindBy(xpath="//*[contains(text(),'Trending Stays')]") public WebElement TrendingStaysTitle;
@FindAll({@FindBy(xpath="//*[contains(text(),'Most booked stays')]/../following-sibling::div//h5")}) public List<WebElement> TrendingStaysTitleList;


//1-July
@FindBy(xpath="//*[contains(text(),'Sign in to Croma.com')]") public WebElement signInBoxCroma;
//5-July
@FindBy(xpath="//div[contains(@class,'style__Description')]") public WebElement maxLimitPopUpMsg_DTH;
@FindBy(xpath="//*[text()='Maximum Limit Reached']") public WebElement maxLimitPopUp_DTH;
@FindBy(xpath="//button[text()='OK']") public WebElement btnOk_DTH;
@FindBy(xpath="//*[text()='TataSky'] | //*[text()='DTH']") public WebElement tataSkyHomepageTitlePM;
@FindAll({@FindBy(xpath="//*[contains(text(),'subscriber ID')]/following::label/label")}) public List<WebElement> subIdLinked;
@FindBy(xpath="//*[text()='Upgrade'] | //*[text()='Box upgrade']") public WebElement btnUpgrade;
@FindAll({@FindBy(xpath="//label[contains(@class,'form-check-label')]/span")}) public List<WebElement> setTopBoxNoDTH;
@FindBy(xpath="//*[text()='Select the box you�d like to upgrade']") public WebElement setTopBoxPageDTH;
@FindBy(xpath="//*[text()='Upgrade to a new Set Top Box']") public WebElement upgardeSetUpBoxPageDTH;
@FindBy(xpath="//*[text()='Cash on Delivery']") public WebElement CODDTH;
@FindBy(xpath="//*[contains(text(),'Upgrade Charges')]/span/span") public WebElement upgardeAmount;
@FindBy(xpath="//*[contains(text(),'Get this')] | //*[contains(text(),'Get This')]") public WebElement getThisBtn;
@FindBy(xpath="//*[contains(text(),'Here is your summary')]") public WebElement SummaryPage;
@FindBy(xpath="//*[text()='Avail now']/.. | //*[text()='View details']/..") public WebElement viewDetailsCTA;
//Recharge Offers
@FindBy(xpath="//*[text()='Recharge offers']") public WebElement rechargeOffer_DTH;
@FindAll({@FindBy(xpath="//*[text()='Recharge offers']/../../following-sibling::div//h5")}) public List<WebElement> rechargeOfferWidget_DTH;
//Tata Sky offers unlocked
@FindBy(xpath="//*[text()=\"Offers you've unlocked\"]") public WebElement offerUnlockDTH;
@FindAll({@FindBy(xpath="//*[text()=\"Offers you've unlocked\"]/../../following-sibling::div//h5")}) public List<WebElement> offerUnlockDTHTile;
//Offers in Spotlight
@FindBy(xpath="//*[text()='Offers in spotlight']") public WebElement offerSpotDTH;
@FindAll({@FindBy(xpath="//*[text()='Offers in spotlight']/../../following-sibling::div//h5")}) public List<WebElement> offerSpotDTHTile;
//Offers on new connection
@FindBy(xpath="//*[text()='Offers on new connections']") public WebElement offerNewConnDTH;
@FindAll({@FindBy(xpath="//*[text()='Offers on new connections']/../../following-sibling::div//h5")}) public List<WebElement> offerNewConnDTHTile;

@FindBy(xpath="Oops!We don't have any events available on Showcase now.") public WebElement noMovieRentDTH;
@FindBy(xpath="(//*[contains(text(),'Choose film, select date')])[2]") public WebElement rentMoviePageDTH;
@FindBy(xpath="//*[contains(text(),\"You don't seem to have enough balance\")]") public WebElement insufficentBalRentDTH;
@FindBy(xpath="//*[contains(text(),'Order Charges')]/following-sibling::span[2]") public WebElement orderPriceRentDTH;
@FindBy(xpath="//*[contains(text(),'Payment Complete')] | //*[contains(text(),'Happy Watching')] | //*[contains(text(),'Order successful')]") public WebElement orderSuccessRentDTH;
@FindBy(xpath="//*[contains(text(),'Transaction Id')]") public WebElement txnIdRentDTH;
@FindBy(xpath="//*[contains(text(),'Transaction Date')]") public WebElement txnDateRentDTH;
@FindBy(xpath="//*[contains(text(),'Enrol your Tata Sky')]") public WebElement enrollPageDTH;
@FindBy(xpath="//*[contains(text(),'Proceed')]") public WebElement enrollProccedDTH;
@FindBy(xpath="//*[contains(text(),'Payment done')] | //*[contains(text(),'Payment Successful')]") public WebElement paymentDoneUpgradeDTH;
@FindBy(xpath="//*[contains(text(),'Transaction Id')]") public WebElement txnIdUpgradeDTH;
@FindBy(xpath="//*[contains(text(),'Order Date')]") public WebElement txnDateUpgradeDTH;
@FindBy(xpath="(//*[contains(text(),'INSTALLATION ADDRESS')]/following::input[@type='radio'])[1] | (//*[@id='spa-root']//input[@type='radio'])[1]") public WebElement addressRadiobuttonDTH;

@FindBy(xpath="//div[@class='dropdown__text' and text()='Fitness'] | //span[@class='text_label_drop_down' and text()='Fitness']") public WebElement sportsHomepageTitle;
@FindBy(xpath="//*[text()='Cancel']") public WebElement retryPopUp;

//AirAsia clickContinue
@FindBy(xpath = "//*[contains(text(),'Continue')]") public WebElement clickContinue;
@FindBy(id="Round Trip") public WebElement roundTrip;
@FindBy(xpath="(//span[@class='round-trip-input-box']/input[@type='radio'])[1]") public WebElement roundTripPrice;
@FindBy(xpath="//div[contains(@class,'source-destination-round')]") public WebElement roundTriptab;

//21-7
@FindBy(xpath="//*[text()='My Orders']") public WebElement ordersPageCroma;
@FindBy(xpath="//*[text()='Track your orders']") public WebElement trackOrderTPM;
@FindBy(xpath="//*[contains(text(),'Select an online payment option')]") public WebElement onlinePaymentPageDTH;

@FindBy(id="payment-dialog") public WebElement paymentPopup;
@FindBy(xpath="//button[text()='Yes']") public WebElement accept;
@FindBy(xpath="//button[text()='No']") public WebElement decline;
@FindBy(xpath="//*[@id='content'][1]") public WebElement orderHistoryfirstRow;
@FindAll({@FindBy(xpath="//label[contains(text(),'Pending')]")}) public List<WebElement> statusPend;
@FindBy(xpath="//*[text()='Failure - timeout']") public WebElement orderHistoryFailureTimeout;
@FindBy(xpath="//*[contains(text(),'Pending')]") public WebElement orderHistoryPending;
@FindBy(xpath="//*[contains(text(),'Failed')]") public WebElement orderHistoryFailed;
@FindBy(xpath="//*[contains(text(),'Failure - Reversed')]") public WebElement orderHistoryFailureRev;

@FindBy(xpath="//*[contains(text(),'Rainy day offers')]") public WebElement rainyday;
@FindAll({@FindBy(xpath="//*[contains(text(),'Rainy day offers')]/../../following-sibling::div//h5")}) public List<WebElement> rainydaylist;

@FindBy(xpath="(//*[contains(text(),'From store to door in 3 hours')])[2]") public WebElement storetodoor;
//@FindAll({@FindBy(xpath="//*[contains(text(),'From store to door in 3 hours')]/../../following-sibling::div//img")}) public List<WebElement> storetodoorlist;
@FindBy(xpath="//*[text()='Smartphones'] | (//div[@class='component11']//p)[11]") public WebElement smartphone;
@FindBy(xpath="//*[contains(text(),'Get these with ZIP delivery')]") public WebElement zipdelivery;
@FindAll({@FindBy(xpath="(//*[@class='EachExpertReview_image'])[6] | (//*[@class='EachExpertReview_image'])[7]")}) public List<WebElement> zipdeliverylist;

@FindBy(xpath="//*[contains(text(),'Products for healthy living')]") public WebElement healthyliving;
@FindAll({@FindBy(xpath="//*[contains(text(),'Products for healthy living')]/../../following-sibling::div//h5")}) public List<WebElement> healthylivinglist;

@FindBy(xpath="//*[contains(text(),'All about smartphones')]") public WebElement smartphones;
@FindAll({@FindBy(xpath="//*[contains(text(),'All about smartphones')]/../../following-sibling::div//h5")}) public List<WebElement> smartphoneslist;

@FindBy(xpath="//*[contains(text(),'Grab these Croma exclusives')]") public WebElement chromaexclusive;
@FindAll({@FindBy(xpath="//*[contains(text(),'Grab these Croma exclusives')]/../../following-sibling::div//h5")}) public List<WebElement> chromaexclusivelist;

@FindBy(xpath="//*[contains(text(),'Offers on limited stocks')]") public WebElement limitedstocks;
@FindAll({@FindBy(xpath="//*[contains(text(),'Offers on limited stocks')]/../../following-sibling::div//h5")}) public List<WebElement> limitedstockslist;

@FindBy(xpath="//*[text()='More banks'] | //*[text()='Netbanking']") public WebElement netbanking_more_bank;
@FindBy(xpath="//*[text()='Avenue Test']") public WebElement netbanking_bank;
@FindBy(xpath="//*[text()='Track status'] | //*[text()='Track booking']") public WebElement trackStatusOrder;
@FindBy(xpath="//*[text()='Find Your Reservations']") public WebElement ihclConfirmationText1;
@FindBy(xpath="//*[text()='Confirmation or Itinerary Number']") public WebElement ihclConfirmationText2;
@FindBy(xpath="//*[text()='Email Address']") public WebElement ihclConfirmationText3;
@FindBy(xpath="//*[@class='user-bar_logo'] | //img[@alt='Taj Hotels logo'] | //span[contains(text(),'Follow Taj Hotels Palaces Resorts Safaris')]") public WebElement ihclLogo;


//3-8
@FindBy(xpath ="(//*[contains(@class,'Title-of-the-article')])[2]") public WebElement Title_CDPPM;
@FindBy(xpath ="(//*[@alt='bookmark'])[3]") public WebElement Bookmark_CDPPM;
@FindBy(xpath ="(//*[contains(@class,'popup')])[3]") public WebElement share_CDPPM;
@FindBy(xpath="//*[text()='Credit cards']//following-sibling::div//label/*") public WebElement creditcardRadio;
@FindBy(xpath="//input[@id='cardCVV'] | //*[@placeholder='Enter CVV ']") public WebElement enter_CVV;
@FindBy(xpath="//*[text()='Debit cards']//following-sibling::div//label/*") public WebElement debitcardRadio;
@FindBy(xpath="(//*[text()='Debit cards']//following-sibling::div//label/*)[2]") public WebElement HDFCdebitcardRadio;

// 03-08
@FindBy(xpath="//*[contains(text(),'Add Address')]") public WebElement add_address;
@FindBy(xpath="//*[@placeholder='Enter your PIN code*']") public WebElement pincode;
@FindBy(xpath="//*[@placeholder='First Name*']") public WebElement FirstName;
@FindBy(xpath="//*[@placeholder='Last Name*']") public WebElement LastName;
@FindBy(xpath="//*[@placeholder='Address*']") public WebElement Address;
@FindBy(xpath="(//*[@label='Landmark'])[1]") public WebElement LandMark;
@FindBy(xpath="//*[@placeholder='Phone number*']") public WebElement PhoneNumber;

@FindBy(xpath="//*[contains(text(),'Save & Continue')]") public WebElement savecontinue;

//06-08_Souvik
@FindBy(xpath="//*[contains(text(),'Lifestyle store')]") public WebElement lifestyle;
@FindAll({@FindBy(xpath="//*[contains(text(),'Lifestyle store')]/../../following-sibling::div//h5")}) public List<WebElement> lifestylelist;

@FindBy(xpath="//*[contains(text(),'Ethnic collections')]") public WebElement ethnic;
@FindAll({@FindBy(xpath="//*[contains(text(),'Ethnic collections')]/../../following-sibling::div//h5")}) public List<WebElement> ethniclist;

@FindBy(xpath="//*[contains(text(),'Women's night & inner wear')] | (//*[@class='componentsixtitle'])[6]") public WebElement womensnight;
@FindAll({@FindBy(xpath="(//*[@class='componentsixtitle'])[6]/../../following-sibling::div//h5")}) public List<WebElement> womensnightlist;

@FindBy(xpath="//*[contains(text(),'Men's night & inner wear')] | (//*[@class='componentsixtitle'])[7]") public WebElement mensnight;
@FindAll({@FindBy(xpath="(//*[@class='componentsixtitle'])[7]/../../following-sibling::div//h5")}) public List<WebElement> mensnightlist;

@FindBy(xpath="//*[contains(text(),'Best Selling Products')]") public WebElement bestselling;
@FindAll({@FindBy(xpath="//*[contains(text(),'Best Selling Products')]//following-sibling::div//div[@class='recentDealsTitle']")}) public List<WebElement> bestsellinglist;

@FindBy(xpath="//*[contains(text(),'Monsoon must-haves')]") public WebElement monsoonmust;
@FindAll({@FindBy(xpath="//*[contains(text(),'Monsoon must-haves')]/../../following-sibling::div//h5")}) public List<WebElement> monsoonmustlist;


@FindBy(xpath="//div[@class='flight-seach-passanger-select']") public WebElement noOfPassengers;
@FindBy(xpath="//img[@alt='plus' and @id='child']") public WebElement childIncrease;
@FindBy(xpath="//img[@alt='minus' and @id='child']") public WebElement childDecrease;
@FindBy(xpath="//img[@alt='plus' and @id='infant']") public WebElement infantIncrease;
@FindBy(xpath="//img[@alt='minus' and @id='infant']") public WebElement infantDecrease;
@FindBy(xpath="//img[@alt='plus' and @id='child']/preceding-sibling::div/div") public WebElement noOfChild;
@FindBy(xpath="//img[@alt='plus' and @id='infant']/preceding-sibling::div/div") public WebElement noOfInfant;
@FindBy(xpath="//div[text()='Child']/ancestor::div[2]//input[@value='Mr']") public WebElement childSalutation;
@FindBy(xpath="//div[text()='Child']/ancestor::div[2]//input[@name='firstname']") public WebElement childFirstName;
@FindBy(xpath="//div[text()='Child']/ancestor::div[2]//input[@name='lastname']") public WebElement childLastName;
@FindBy(xpath="//div[text()='Child']/ancestor::div[2]//input[contains(@placeholder,'DD/MM/YYYY')]") public WebElement childDOB;
@FindBy(xpath="//div[text()='Infant']/ancestor::div[2]//input[@value='Male']") public WebElement infantGender;
@FindBy(xpath="//div[text()='Infant']/ancestor::div[2]//input[@name='firstname']") public WebElement infantFirstName;
@FindBy(xpath="//div[text()='Infant']/ancestor::div[2]//input[@name='lastname']") public WebElement infantLastName;
@FindBy(xpath="//div[text()='Infant']/ancestor::div[2]//input[contains(@placeholder,'DD/MM/YYYY')]") public WebElement infantDOB;

//10-8
@FindBy(xpath="//*[@id='cancel-action']") public WebElement cancelBtnAxis;
@FindBy(xpath="//button[text()='Yes, Cancel']") public WebElement cancelBtnConfirmAxis;
@FindBy(xpath="//*[contains(text(),'Payment unsuccessful')]") public WebElement paymentFailedStatusDTH;


//10-08_Souvik

@FindBy(xpath="//*[contains(text(),'Best-selling products')]") public WebElement bestsellingproduct;
@FindAll({@FindBy(xpath="//*[contains(text(),'Best-selling products')]//following-sibling::div//div[@class='recentDealsTitle']")}) public List<WebElement> bestsellingproductlist;

@FindBy(xpath="//*[contains(text(),'Budget buys')]") public WebElement budgetbuy;
@FindAll({@FindBy(xpath="//*[contains(text(),'Budget buys')]/../../following-sibling::div//h5")}) public List<WebElement> budgetbuylist;

@FindBy(xpath="//*[contains(text(),'Offers on fitness brands')]") public WebElement fitnessoffers;
@FindAll({@FindBy(xpath="//*[contains(text(),'Offers on fitness brands')]/../../following-sibling::div//h5")}) public List<WebElement> fitnessofferslist;

@FindBy(xpath="//*[contains(text(),'Fitness gear')]") public WebElement fitnessgear;
@FindAll({@FindBy(xpath="//*[contains(text(),'Fitness gear')]/../../following-sibling::div//h5")}) public List<WebElement> fitnessgearlist;

@FindBy(xpath="//*[contains(text(),'Shoes by sport')]") public WebElement sportsshoes;
@FindAll({@FindBy(xpath="//*[contains(text(),'Shoes by sport')]/../../following-sibling::div//h5")}) public List<WebElement> sportsshoeslist;


@FindBy(xpath="//*[contains(text(),'Laptops for every need')]") public WebElement laptopsneed;
@FindAll({@FindBy(xpath="//*[contains(text(),'Laptops for every need')]/../../following-sibling::div//h5")}) public List<WebElement> laptopsneedlist;

@FindBy(xpath="//*[contains(text(),'Laptops to suit your budget')]") public WebElement laptopsuit;
@FindAll({@FindBy(xpath="//*[contains(text(),'Laptops to suit your budget')]/../../following-sibling::div//h5")}) public List<WebElement> laptopsuitlist;

@FindBy(xpath="//*[contains(text(),'The TV store')]") public WebElement tvstore;
@FindAll({@FindBy(xpath="//*[contains(text(),'The TV store')]/../../following-sibling::div//h5")}) public List<WebElement> tvstorelist;

@FindBy(xpath="//*[contains(text(),'TVs for every budget')]") public WebElement budgettv;
@FindAll({@FindBy(xpath="//*[contains(text(),'TVs for every budget')]/../../following-sibling::div//h5")}) public List<WebElement> budgettvlist;

//12th august
@FindBy(xpath ="//*[text()='MEMBER RATES']") public WebElement btnmemberrates;



@FindBy(xpath="//*[contains(text(),'Just in - the latest launches')]") public WebElement latestlaunches;
@FindAll({@FindBy(xpath="//*[contains(text(),'Just in - the latest launches')]/../../following-sibling::div//h5")}) public List<WebElement> latestlauncheslist;

@FindBy(xpath="//*[contains(text(),'WFH made easy')]") public WebElement wfhmadeeasy;
@FindAll({@FindBy(xpath="//*[contains(text(),'WFH made easy')]/../../following-sibling::div//h5")}) public List<WebElement> wfhmadeeasylist;

@FindBy(xpath="//*[contains(text(),'Home entertainment zone')]") public WebElement homeentertainment;
@FindAll({@FindBy(xpath="//*[contains(text(),'Home entertainment zone')]/../../following-sibling::div//h5")}) public List<WebElement> homeentertainmentlist;

@FindBy(xpath="//*[contains(text(),'Styling for her')]") public WebElement stylingforher;
@FindAll({@FindBy(xpath="//*[contains(text(),'Styling for her')]/../../following-sibling::div//h5")}) public List<WebElement> stylingforherlist;

@FindBy(xpath="//*[contains(text(),'The WFH edit')]") public WebElement wfhedit;
@FindAll({@FindBy(xpath="//*[contains(text(),'The WFH edit')]/../../following-sibling::div//h5")}) public List<WebElement> wfheditlist;

@FindBy(xpath="//*[contains(text(),'Hair styling made easy')]") public WebElement hairstyling;
@FindAll({@FindBy(xpath="//*[contains(text(),'Hair styling made easy')]/../../following-sibling::div//h5")}) public List<WebElement> hairstylinglist;

//27-08

@FindBy(xpath="//*[contains(text(),'New arrivals')]") public WebElement newarrivals;
@FindAll({@FindBy(xpath="//*[contains(text(),'New arrivals')]/../../following-sibling::div//h5")}) public List<WebElement> newarrivalslist;

@FindBy(xpath="//*[contains(text(),'Handpicked offers for you')]") public WebElement handpickedoffer;
@FindAll({@FindBy(xpath="//*[contains(text(),'Handpicked offers for you')]/../../following-sibling::div//h5")}) public List<WebElement> handpickedofferlist;

@FindBy(xpath="//*[contains(text(),'Hot deals by category')]") public WebElement hotdeals;
@FindAll({@FindBy(xpath="//*[contains(text(),'Hot deals by category')]/../../following-sibling::div//h5")}) public List<WebElement> hotdealslist;

@FindBy(xpath="//*[contains(text(),'Tech talk')]") public WebElement techtalk;
@FindAll({@FindBy(xpath="//*[contains(text(),'Tech talk')]/../../following-sibling::div//h5")}) public List<WebElement> techtalklist;

@FindBy(xpath="//*[contains(text(),'Shop by price')]") public WebElement shopbyprice;
@FindAll({@FindBy(xpath="//*[contains(text(),'Shop by price')]//following-sibling::div//h3 | //*[contains(text(),'Shop by price')]/..//following-sibling::div//p")}) public List<WebElement> shopbypricelist;

@FindBy(xpath="//*[contains(text(),'Still Looking for these')]") public WebElement stilllooking;
@FindAll({@FindBy(xpath="//*[contains(text(),'Still Looking for these')]//following-sibling::div//h3")}) public List<WebElement> stilllookinglist;

@FindBy(xpath="//*[contains(text(),'Offers running out soon')]") public WebElement offersrunningout;
@FindAll({@FindBy(xpath="//*[contains(text(),'Offers running out soon')]/../../following-sibling::div//h5")}) public List<WebElement> offersrunningoutlist;

@FindBy(xpath="//*[contains(text(),'Shop by Features')]") public WebElement shopbyfeature;
@FindAll({@FindBy(xpath="//*[contains(text(),'Shop by Features')]//following-sibling::div//h3")}) public List<WebElement> shopbyfeaturelist;

@FindBy(xpath="//*[contains(text(),'Shop accessories by type')]") public WebElement shopbyaccessories;
@FindAll({@FindBy(xpath="//*[contains(text(),'Shop accessories by type')]/../../following-sibling::div//h5")}) public List<WebElement> shopbyaccessorieslist;

@FindBy(xpath="//*[contains(text(),'Fitness & VR accessories')]") public WebElement fitnessvr;
@FindAll({@FindBy(xpath="//*[contains(text(),'Fitness & VR accessories')]/../../following-sibling::div//h5")}) public List<WebElement> fitnessvrlist;

@FindBy(xpath="//*[contains(text(),'Smartphones by brand')]") public WebElement topbrands;
@FindAll({@FindBy(xpath="//*[@class='Top_Sub_Title']")}) public List<WebElement> topbrandslist;

@FindBy(xpath="//div[@class='dropdown__text' and text()='Mobiles'] | //span[contains(@class,'SearchResult_text_label_drop') and text()='Mobiles']") public WebElement SmartphoneHomepageTitle;
@FindBy(xpath="//span[text()='Smartphones']") public WebElement SmartphoneHomepageTitlePM;








@FindBy(xpath="//*[text()='F&B']") public WebElement SLPFood;
@FindBy(xpath="//div[@class='dropdown__text' and text()='F&B']") public WebElement FoodHomepageTitle;
@FindBy(xpath="//div[@data-testid='card-item-0']") public WebElement QminBanner;
@FindBy(xpath="//*[@class='signature-name']") public WebElement QminLogin;
@FindBy(xpath="//*[@class='bold profile gold']") public WebElement Switched;
@FindBy(xpath="(//*[text()='ADD'])[1]") public WebElement Add;
@FindBy(xpath="(//*[text()='ORDER'])[1]") public WebElement clickonorder;
@FindBy(xpath="(//*[text()='400012'] |  //*[text()='400008']") public WebElement SelectAddress;
@FindBy(xpath="//*[text()='Select time slot']") public WebElement Selecttimeslot;
@FindBy(xpath="(//*[@class='radio-button'])[1]") public WebElement Selecttime;
@FindBy(xpath="//*[text()='PAY NOW']") public WebElement Paynow;


//WestSide
@FindBy(xpath="//*[contains(text(),'Shop Westside by category')]") public WebElement categoryWestside;
@FindAll({@FindBy(xpath="//*[contains(text(),'Shop Westside by category')]/../following-sibling::div//p | //*[contains(text(),'Shop Westside by category')]/following-sibling::div//div[@class='categoriecard_imgtext']")}) public List<WebElement> shopWestsideCategorylist;
@FindBy(xpath="(//a[contains(@class,'acc-title')])[2]") public WebElement LogedWestside;
@FindBy(xpath="//a[contains(@class,'product-title')]") public WebElement productWestside;
@FindBy(xpath="//input[@placeholder='Search']") public WebElement searchButtonWestside;
@FindBy(xpath="//input[@id='pincode_input']") public WebElement pinCodeWestside;
@FindBy(xpath="//*[@id='check-delivery-submit']") public WebElement checkPinWestside;
@FindBy(xpath="//*[@id='product-add-to-cart']") public WebElement addCartWestside;
@FindBy(xpath="(//*[@title='Cart Icon'])[2]") public WebElement cartIconWestside;
@FindBy(xpath="//*[@id='checkout_button_custom'] | //*[@id='checkout_button']") public WebElement checkOutWestside;
@FindBy(xpath="//*[@placeholder='Address']") public WebElement addressWestside;
@FindBy(xpath="//*[@id='checkout_shipping_address_phone_custom']") public WebElement phoneAddressWestside;
@FindBy(xpath="//*[@id='continue_button']") public WebElement continePaymentWestside;
@FindBy(xpath="(//*[text()='Complete Order'])[1]/..") public WebElement completeOrderWestside;
@FindBy(xpath="(//*[@data-testid='biller-header'])[1]") public WebElement BillerName_TxnHitsory;
@FindBy(xpath="(//*[@class='combo-box__content'])[1]") public WebElement addressSuggestion_Westside;
@FindBy(xpath="//*[@id='continue_to_shipping_button_custom']") public WebElement contineShippingWestside;
@FindBy(xpath="//*[contains(text(),'Westside stories')]") public WebElement storiesWestside;
@FindAll({@FindBy(xpath="//*[contains(text(),'Westside stories')]/../../following-sibling::div//h5")}) public List<WebElement> westsideStorieslist;
@FindBy(xpath="//*[text()='Discover brands at Westside']") public WebElement WestSideDiscoverAtTileTitle;
@FindAll({@FindBy(xpath="//*[text()='Discover brands at Westside']/../following-sibling::div//div[contains(@class,'top_Brand_Main_Div_Wrapper')]")}) public List<WebElement> WestSideDiscoverAtlist;
@FindBy(xpath="//*[text()='Just in']") public WebElement justInTitle;
@FindAll({@FindBy(xpath="//*[text()='Just in']/following-sibling::div//div[contains(@class,'BundlesYouMayLike_bundle_img')]")}) public List<WebElement> justInlist;

//Global Search
@FindBy(xpath="//*[@id='search-list-container']") public WebElement globalSearchList;
@FindBy(xpath="//*[@id='search-history-trending-list-container']") public WebElement globalSearchHistoryList;
@FindAll({@FindBy(xpath="//*[@id='search-list-container']/div[not(child::div)]")}) public List<WebElement> globalSearchHeaderList;
@FindAll({@FindBy(xpath="//*[@id='search-history-trending-list-container']/div[not(child::div)]")}) public List<WebElement> globalSearchHistoryHeaderList;
@FindAll({@FindBy(xpath="//*[@id='search-list-container']/div/div")}) public List<WebElement> globalSearchCategoriesList;
@FindAll({@FindBy(xpath="//*[@id='search-history-trending-list-container']/div/div")}) public List<WebElement> globalSearchHistoryCategoriesList;
@FindAll({@FindBy(xpath="(//*[@id='search-list-container']/div/div)[1]//following-sibling::ul/li")}) public List<WebElement> globalSearchFirstCategoryItemList;
@FindAll({@FindBy(xpath="(//*[@id='search-history-trending-list-container']/div/div)[1]//following-sibling::ul/li")}) public List<WebElement> globalSearchHistoryFirstCategoryItemList;
@FindBy(xpath="//*[text()='Your transaction could not be completed.']") public WebElement transactionNotComp;
@FindBy(xpath="//*[text()='Thank you for shopping with us']") public WebElement orderCompletionCroma;
@FindBy(xpath="//*[contains(text(),'Order ID')]/following::dd[1]") public WebElement orderIDCompletionCroma;

@FindBy(xpath="//*[@id='check-button-checked-a']/../..") public WebElement tcpPoints_CheckedCheckbox;
@FindBy(xpath ="(//*[@data-testid='biller-header'])[1]/following-sibling::span") public WebElement firstOrderDateTime;


//Pay with TataPay
@FindBy(xpath="//*[contains(text(),'Pay with Tata Pay')]") public WebElement paywithtatapay;
@FindBy(xpath="//*[contains(text(),'Continue')]") public WebElement continuebtn;

@FindBy(xpath="//*[text()='Credit and debit cards'] | //*[text()='Card payments']") public WebElement cardsSelection;
@FindBy(xpath="//div[text()='Credit cards' and 'Save your card for quicker checkouts' and 'Debit cards']") public WebElement Creditcards;



//1mg xpaths
@FindBy(xpath="(//div[@class='dropdown__text'])[1]") public WebElement OnemgHomepageTitlePD;
@FindBy(xpath="//button[text()='Order now']") public WebElement orderNowButton;
@FindBy(xpath="//*[text()='Latest on COVID']") public WebElement latestOnCovid;
@FindBy(xpath="//*[text()='Latest on COVID']/../../following::div[1]") public WebElement latestOnCovidSection;
@FindBy(xpath="//*[text()='Offers in Spotlight']") public WebElement offersInSpotLight;
@FindBy(xpath="//*[text()='Offers in Spotlight']/../../following::div[1]") public WebElement offersInSpotLightSection;
@FindBy(xpath="//*[text()='101 to holistic wellbeing']") public WebElement holisticwellbeing;
@FindBy(xpath="//*[text()='101 to holistic wellbeing']/../../following::div[1]") public WebElement holisticwellbeingSection;
@FindBy(xpath="//*[text()='101 to good health']") public WebElement goodhealth;
@FindBy(xpath="//*[text()='101 to good health']/../../following::div[1]") public WebElement goodhealthSection;
@FindBy(xpath="//*[text()='Health and immunity']") public WebElement healthAndImmunity;
@FindBy(xpath="//*[text()='Health and immunity']/../../following::div[1]") public WebElement healthAndImmunitySection;
@FindBy(xpath="(//button[@class='herboBannerButton'])[1]") public WebElement shopNowButton;

@FindBy(xpath="//*[text()='Shop & Explore']") public WebElement shopAndExplore;
@FindBy(xpath="//*[text()='Healthcare']") public WebElement healthcare;
@FindBy(xpath="//*[contains(text(),'Order medicines')]") public WebElement orderMedicines;
@FindBy(xpath="(//*[contains(text(),'Lab Tests')])[1]") public WebElement bookALabTest;
@FindBy(xpath="Ask Doctor") public WebElement consultADoctor;
@FindBy(xpath="//*[contains(text(),'Book Test from Prescription')]") public WebElement bookTestFromPrescription;
@FindBy(xpath="//*[contains(text(),'Chat with our specialist doctors')]") public WebElement chatWithSpecialistDoctor;
@FindBy(xpath="//*[text()='Start a new chat']") public WebElement startANewChat;
@FindBy(xpath="(//*[text()='Myself'])[1]") public WebElement myself;
@FindBy(xpath="(//*[text()='Fever'])[1]") public WebElement fever;
@FindBy(xpath="(//*[text()='DONE'])[1]") public WebElement doneButtonOfFever;
@FindBy(xpath="(//*[") public WebElement ayurvedaSelection;
@FindBy(xpath="(//*[text()='0-2 days'])[2]") public WebElement feverDaySelection;
@FindBy(xpath="(//*[text()='Low(99-100�F)'])[2]") public WebElement feverIntensitySelection;
@FindBy(xpath="(//*[text()='Diabetes'])[2]") public WebElement diabetes;
@FindBy(xpath="(//*[text()='DONE'])[8]") public WebElement doneButtonOfDiabetes;
@FindBy(xpath="(//*[text()='Skip'])[2]") public WebElement skipButton;
@FindBy(xpath="(//*[text()='Consult Now'])[3]") public WebElement audioaConsultNowBtn;
@FindBy(xpath="//span[contains(text(),'All Medicines')]") public WebElement allMedicinesText;
@FindBy(xpath="//span[@title='Close']//*[name()='svg']//*[name()='path' and contains(@fill,'#ffffff')]") public WebElement closeWeGotAllYourNeedCovered;
@FindBy(xpath="//span[@title='Close']//*[name()='svg']") public WebElement labTestCloseButton;
@FindBy(xpath="(//*[name()='svg'])[8]") public WebElement tSHTestButton;
@FindBy(xpath="(//*[text()='SELECT LAB'])[1]") public WebElement selectLab;
@FindBy(xpath="//*[text()='SCHEDULE']") public WebElement scheduleLab;
@FindBy(xpath="//*[text()='Select Patient']") public WebElement selectPatient;
@FindBy(xpath="//*[text()='Select Address']") public WebElement selectAddress;
@FindBy(xpath="//*[@class='fa fa-chevron-right']") public WebElement rightArrow;
@FindBy(xpath="//div[contains(text(),'10:00 AM - 11:00 AM')]") public WebElement selectTimeSlot;
@FindBy(xpath="//*[text()='Select Time Slot']") public WebElement selectTimeSlotButton;
@FindBy(xpath="//*[text()='NET BANKING']") public WebElement netBanking;
@FindBy(xpath="//*[text()='AXIS']") public WebElement axisNetBanking;
@FindBy(xpath="//*[text()='MAKE PAYMENT']") public WebElement makePayment;
@FindBy(xpath="//*[text()='WALLETS']") public WebElement walletPaymentMethod;
@FindBy(xpath="//*[text()='Tata Pay']") public WebElement tataPayUnderWallets;
@FindBy(xpath="//*[name()='path' and contains(@d,'M-2-2h24v2')]") public WebElement neuCoinSelectionOnPaymentPage;
@FindBy(xpath="//*[text()='Edit']") public WebElement editNeuCoins;
@FindBy(xpath="//input[@name='loyaltyPointstxt']") public WebElement neuCoinsInputBox;
@FindBy(xpath="//*[text()='Confirm']") public WebElement confirmButton;
@FindBy(xpath="//button[contains(text(),'Pay')]") public WebElement payButtonOnemg;
@FindBy(xpath="(//button[@type='light'][contains(text(),'Pay ₹')])[2]") public WebElement payButtonInCreditCardPage;
@FindBy(xpath="//input[@id='cardCVV']") public WebElement cardCvvInput;
@FindBy(xpath="//div[text()='Cancel']") public WebElement cancelCityModal;




@FindBy(xpath="//*[contains(text(),'Multivitamins | Supplement of the week')]") public WebElement multivitaminsText;
@FindBy(xpath="//div[contains(text(),'Book lab tests')]") public WebElement bookLabTest;
@FindBy(xpath="//div[contains(text(),'Add To Cart')]") public WebElement addToCartOneMg;
@FindBy(xpath="//span[@title='Close']//*[name()='svg']") public WebElement allYourNeedsCoveredCloseButton;
@FindBy(xpath="//img[contains(@src,'/images/header/cart-icon-rebrand.svg')]") public WebElement cartIconInOneMgProductPage;
@FindBy(xpath="//*[text()='CHECKOUT']") public WebElement checkoutOneMg;
@FindBy(xpath="//textarea[@placeholder='Flat Number, Building Name, Street/Locality']") public WebElement flatDetailsAddress;
@FindBy(xpath="//input[@placeholder='Landmark (optional)']") public WebElement landmarkAddress;
@FindBy(xpath="//input[@placeholder='Pincode']") public WebElement pinCoderAddress;
@FindBy(xpath="//input[@placeholder='Locality']") public WebElement localityAddress;
@FindBy(xpath="//input[@placeholder='Customer Name']") public WebElement customerNameAddress;
@FindBy(xpath="//input[@placeholder='10 Digit Mobile Number']") public WebElement mobileNumberAddress;
@FindBy(xpath="(//*[name()='path'])[6]") public WebElement addressTypeOther;
@FindBy(xpath="(//*[name()='path'])[4]") public WebElement addressTypeHome;
@FindBy(xpath="(//*[name()='path'])[5]") public WebElement addressTypeOffice;
@FindBy(xpath="//span[text()='SAVE']") public WebElement saveAddressButton;
@FindBy(xpath="//*[text()='CONTINUE']") public WebElement continueButtonAddressPage;
@FindBy(xpath="//*[text()='PROCEED TO PAYMENT']") public WebElement proceedToPaymentOneMg;
@FindBy(xpath="//*[text()='Netbanking']") public WebElement netBankingPaymentmethodOneMg;
@FindBy(xpath="//*[text()='Popular banks ']") public WebElement popularBanksOneMg;
@FindBy(xpath="//div[normalize-space()='Payment modes']") public WebElement paymentmodes;

@FindBy(xpath="(//*[text()='Netbanking']/following::div/div[contains(text(),'Axis Bank')])[1]") public WebElement axisNetBankingOneMg;
@FindBy(xpath="//*[text()='MAKE PAYMENT']") public WebElement makePaymentButtonOneMg;
@FindBy(xpath="//*[text()='Awesome! Payment Complete']") public WebElement orderSuccessVerificationTextOneMg;
@FindBy(xpath="//div[text()='Revital H Woman Tablet']") public WebElement revitalProduct;
@FindBy(xpath="//*[contains(text(),'Total Payable')]/parent::div/div[2]") public WebElement totalPayableCliq;











//Brand page validation
@FindBy(xpath="//img[@alt='Croma Logo'] | //img[@alt='Logo'] | //a[@class='logo custom-s-logo croma-desktop-logo']") public WebElement cromaLogo;
@FindBy(xpath="//div[contains(@class,'logoHolder')]") public WebElement cliqLogo;
@FindBy(xpath="//*[contains(@class,'icon downIco')]") public WebElement cliqLogoPM;
@FindBy(xpath="(//*[@title='Bigbasket'])[1]") public WebElement bbLogo;
@FindBy(xpath="(//*[@title='Bigbasket'])[2]") public WebElement bbLogoPM;
@FindBy(xpath="//img[@class='img-logo']") public WebElement airAsiaLogo;
@FindBy(xpath="//img[@alt='Logo']/../..") public WebElement tataSkyLogo;

//Content Zone
@FindBy(xpath="//span[text()='NeuMag']/preceding-sibling::*") public WebElement backButton_ContentZone;
@FindBy(xpath = "(//*[text()='NeuMag'])[2]")public WebElement headerTxt_insideExplore;
@FindAll({@FindBy(xpath="//div[text()='Featured stories']/following-sibling::div//div[contains(@class,'contentItemsClass')]/div/div/div[1]")}) public List<WebElement> heroBannerTitle_ContentZone;
@FindAll({@FindBy(xpath="//div[text()='Featured stories']/following-sibling::div//div[contains(@class,'contentItemsClass')]//*[text()='Read now']")}) public List<WebElement> heroBannerCTA_ContentZone;
@FindBy(xpath="//img[@alt='rightarrowcircle']") public WebElement heroBannerRight_ContentZone;
@FindBy(xpath="//img[@alt='leftarrowcircle']") public WebElement heroBannerLeft_ContentZone;

//Curated
@FindBy(xpath = "(//*[contains(text(),'Curated for you')])[1]") public WebElement CuratedForYouSection;
@FindBy(xpath = "(//*[contains(text(),'Curated for you')])[2]/../../../../../div[2]") public WebElement CuratedForYouTemplate;
@FindBy(xpath = "(//*[contains(text(),'Curated for you')])[2]/../../../../div[2]/div") public WebElement seeAllCuratedForYouBtn;
@FindAll({@FindBy(xpath = "(//*[contains(text(),'Curated for you')])/../../../following-sibling::div//h5")}) public List<WebElement> CuratedForYou_ContentTiles;
@FindBy(xpath = "//input[@placeholder='Search NeuMag']/../../../following-sibling::*") public WebElement bookmarkIcon_insideExplore;
@FindAll({@FindBy(xpath = "//*[text()='Shop by category']/../../div[@class='slick-slider slick-initialized']//div[contains(@class,'slick-slide slick-active')]")}) public List<WebElement> shopCategoryElec_FirstRow;
@FindAll({@FindBy(xpath = "(//*[text()='Shop by category']/../../../../following-sibling::div)[1]//p")}) public List<WebElement> shopCategoryElec_SecondRow;
@FindBy(xpath = "(//*[text()='Shop by category']/../../..//following-sibling::div)[1]//div[@class='slick-arrow slick-next']") public WebElement shopCategoryElecNext_SecondRow;


//Ama Stays
@FindBy(xpath="(//*[@id='header-profile'])[2]//span[@class='profile-username']") public WebElement LogedIHCLAma;

@FindBy(xpath="(//video/../../preceding-sibling::div//*)[1]") public WebElement videoWidgetCloseButton;

//Container
@FindBy(xpath = "//div[contains(@class,'componentsixcontainer')]") public WebElement compSixConatiner;
@FindAll({@FindBy(xpath = "//div[contains(@class,'componentsixcontainer')]")}) public List<WebElement> compSixConatinerList;
@FindBy(xpath = "//div[@class='booking-container-hotels']") public WebElement hotelbookConatiner;
@FindAll({@FindBy(xpath = "//div[@class='booking-container-hotels']")}) public List<WebElement> hotelbookConatinerList;
@FindBy(xpath = "//div[@class='CardWithCarousel_container']") public WebElement hotelCrousalConatiner;
@FindAll({@FindBy(xpath = "//div[@class='CardWithCarousel_container']")}) public List<WebElement> hotelCrousalConatinerList;

@FindBy(xpath = "//div[contains(@class,'Expertreview_container')]") public WebElement expertViewConatiner;
@FindAll({@FindBy(xpath = "//div[contains(@class,'Expertreview_container')]")}) public List<WebElement> expertViewConatinerList;
@FindBy(xpath = "//div[contains(@class,'component13_container')]") public WebElement comp13Conatiner;
@FindAll({@FindBy(xpath = "//div[contains(@class,'component13_container')]")}) public List<WebElement> comp13ConatinerList;
@FindBy(xpath = "//div[@class='specialpreviewcontainer']") public WebElement specialPreviewConatiner;
@FindAll({@FindBy(xpath = "//div[@class='specialpreviewcontainer']")}) public List<WebElement> specialPreviewConatinerList;
@FindBy(xpath = "//div[contains(@class,'categoriecard_bundle-container')]") public WebElement categoryCardConatiner;
@FindAll({@FindBy(xpath = "//div[contains(@class,'categoriecard_bundle-container')]")}) public List<WebElement> categoryCardConatinerList;
@FindBy(xpath = "//div[@class='bundle-container']") public WebElement bundleConatiner;
@FindAll({@FindBy(xpath = "//div[@class='bundle-container']")}) public List<WebElement> bundleConatinerList;
@FindBy(xpath = "//div[@class='highlevelcategory_container']") public WebElement highLevelConatiner;
@FindAll({@FindBy(xpath = "//div[@class='highlevelcategory_container']")}) public List<WebElement> highLevelConatinerList;
@FindBy(xpath = "//div[@class='SubCategoriesWidget_container']") public WebElement subCatConatiner;
@FindAll({@FindBy(xpath = "//div[@class='SubCategoriesWidget_container']")}) public List<WebElement> subCatConatinerList;
@FindBy(xpath = "//div[@id='header-container']") public WebElement headerConatiner;

@FindBy(xpath="/html/body/div[3]/div[contains(@class,'Overlay')]") public WebElement tataSkyOverlay;

@FindBy(xpath="//div[@class='SecondaryLoader__loader'] | //div[@class='loading-spinner']") public WebElement pageLoader;
@FindBy(xpath = "(//*[@id='dropdown-custom-components']//span)") public WebElement airAsisAutoLogin;
@FindBy(xpath="//*[@id='loginsignup-address-change-button']") public WebElement bbUnservicableOK;
@FindBy(xpath="//*[text()='Skip offer']") public WebElement offerSkip;
@FindBy(xpath="//*[text()='SmartAlerts']/..//following-sibling::button") public WebElement flightPopUp;
@FindBy(xpath = "//*[@qa='deliverHereCKO']") public WebElement bbSelectAddr;

@FindBy(xpath = "//input[@id='checkout_shipping_address_first_name']") public WebElement westsideAddrFname;
@FindBy(xpath = "//input[@id='checkout_shipping_address_last_name']") public WebElement westsideAddrLname;
@FindBy(xpath = "//*[@class='SmallButton__SmallButtonStyled-cyqBac hiTIwg sc-lbhJGD fYyclM']") public WebElement clickCopyCouponCliq;
@FindBy(xpath = "//*[@class='SmallButton__SmallButtonStyled-cyqBac bHZYIa sc-lbhJGD fYyclM']") public WebElement clickShopNowCliq;

@FindBy(xpath="(//a[@class='logo-title'])[1]") public WebElement westside;
@FindBy(xpath="(//*[@class='ProductModule__imageAndDescriptionWrapper'])[1]") public WebElement clickproduct;
@FindBy(xpath="(//*[contains(text(),'Change')])[1]") public WebElement changebtn;

@FindBy(xpath="//input[@class='Input2__inputBoxNoPadding Input2__inputBox']") public WebElement changePincode;

@FindAll({@FindBy(xpath="//*[@class='slick-slide' or contains(@class,'slick-active')]//*[@id='heroBannerHeading']")}) public List<WebElement> heroBannerJourneyTitleRotate;
@FindAll({@FindBy(xpath="//*[@class='slick-slide' or contains(@class,'slick-active')]//*[contains(@class,'HeroBannerComponent_')]//button/span")}) public List<WebElement> heroBannerJourneyCTARotate;
@FindBy(xpath="//*[text()='F&B'] | (//div[@class='component11']//p)[10]") public WebElement SLPFnB;
@FindBy(xpath="//button[text()='Get Tata Sky Binge +']") public WebElement bingePopUp;
@FindBy(xpath="(//*[text()='Proceed to Pay'])[1]") public WebElement addProceedtoPay;

@FindBy(xpath="//iframe[@name='HyperServices']") public WebElement hyperIframe;
@FindBy(xpath="(//button[text()='Change'])[2]") public WebElement chnagePayment;
@FindAll({@FindBy(xpath="//div[@id='content']/div[1]")}) public List<WebElement> myTxnIDList;
@FindAll({@FindBy(xpath="//*[@data-testid='flex-status']//div[1]")}) public List<WebElement> myTxnStatusList;
@FindAll({@FindBy(xpath="//*[@data-testid='biller-header']/following-sibling::span")}) public List<WebElement> myTxnDateTimeList;

@FindBy(xpath="//*[text()='Transaction ID']/following-sibling::span") public WebElement txnID_MTP;
@FindBy(xpath="//*[contains(text(), 'Review')] | //*[contains(text(), 'Bills in your cart')]") public WebElement review_pg;
@FindBy(xpath="(//*[contains(text(), 'Convenience')]/following::*)[1]") public WebElement convenience_fee_amount;
@FindBy(xpath="//*[contains(text(), 'Payment done')] | //*[contains(text(), 'Payment successful')]") public WebElement paymentDone_BillPay;
@FindBy(xpath="//*[contains(text(), 'Payment failed')]") public WebElement paymentFailed_BillPay;
@FindBy(xpath="//*[contains(text(), 'Bill payment status')]") public WebElement paymentstausHeader_BillPay;
@FindBy(xpath="//button[contains(text(), 'Back to homepage')]") public WebElement backToHome_BillPay;
@FindBy(xpath="//*[contains(text(), 'Multi TV')]") public WebElement multiTv;
@FindBy(xpath="//*[text()='Add a box to your existing connection']") public WebElement addMultiBoxPageDTH;

@FindBy(xpath="//p[contains(text(), 'Manage packs')]") public WebElement managePackDTH;
@FindBy(xpath="//button[contains(text(), 'Modify Packs')]") public WebElement modifyPackBtn;
@FindBy(xpath="//*[text()='Manage your packs and channels by choosing from the below options']") public WebElement managePackOptionsDTH;
@FindBy(xpath="//span[contains(text(), 'QUICK ADD')]") public WebElement modifyAddBtn;
@FindBy(xpath="//span[contains(text(), 'DROP')]") public WebElement modifyDropBtn;
@FindBy(xpath="//*[contains(@id,'coach-btn')]") public WebElement gotItBtn;
@FindBy(xpath="//*[@id='search-value']") public WebElement searchChannel;
@FindBy(xpath="//div[@class='cha-name']") public WebElement channelName;
@FindBy(xpath="//*[contains(text(), 'Confirm')]") public WebElement cartConfirmBtn;
@FindBy(xpath="//*[contains(text(), 'Here are some great options for you')]") public WebElement cartModifyPackPage;
@FindBy(xpath="//*[contains(text(), 'Confirm & Proceed')]") public WebElement cartConfirmProceedBtn;
@FindBy(xpath="//*[contains(text(),'Pack changes done!')]") public WebElement changePackSuccessDTH;

@FindAll({@FindBy(xpath="//*[@id='search-list-container']/div/div/div")}) public List<WebElement> searchHeaderList;
@FindBy(xpath="//*[text()='See all results']") public WebElement seeAllResultsButton;
@FindAll({@FindBy(xpath="//img[@alt='Product']/../../..")}) public List<WebElement> searchProductsListing;
@FindBy(xpath="//*[@id='search-list-container']//div[contains(text(),'Recent')]") public WebElement recentSearchList;

@FindBy(xpath="//*[contains(text(),'My orders')]") public WebElement myOrders;
@FindBy(xpath="(//*[contains(text(),'Order ID')]/../following-sibling::div)[1]/div[2]/div") public WebElement myOrdersFirstOrderID;
@FindBy(xpath="(//*[contains(text(),'Order ID')]/../following-sibling::div)[1]/div[1]/div[1]") public WebElement myOrdersFirstOrderName;
@FindBy(xpath="(//*[contains(text(),'Order ID')]/../following-sibling::div)[1]/div[3]/div[1]") public WebElement myOrdersFirstOrderPrice;
@FindBy(xpath="//*[text()='Total payable amount']/following::span[1]") public WebElement totalPayableAmount;

@FindBy(xpath="(//*[@id='search-list-container']/div/div/div)[1]") public WebElement firstCategorySearch;
@FindBy(xpath="//table[@class='full_online_orders']") public WebElement ordersPageWestside;
}





