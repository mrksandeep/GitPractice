package com.QA.TestApp.Pages.MOBILE;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_SLPElectronicsPage_Mobile extends BaseScript {


	public TDL_SLPElectronicsPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	//for android element add "and" as prefix and for ios add "ios"


	// ios Only 
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Used']") public MobileElement andUsedOffersTab_IOS;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Great! Let�s Start!']") public MobileElement startTab_IOS;	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Submit']") public MobileElement submit_IOS;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Shop With Tata']") public MobileElement SWT_IOS;	
	@FindBy(xpath = "//*[contains(@value,'Skip Tour')]") public MobileElement tour_IOS;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Electronics']") public MobileElement SLPElec_IOS;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Hotels']") public MobileElement SLPHotel_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Essentials']") public MobileElement SLPEssentials_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Active Life']") public MobileElement SLPSports_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Beauty']") public MobileElement SLPBeauty_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Fashion']") public MobileElement SLPFashion_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TataSky']") public MobileElement SLPTataSky_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Find a store near you']") public MobileElement Store_IOS;	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Hotel']") public MobileElement SLPHotelHdr;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Electronics SLP']") public MobileElement SLPElectHdr;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Beauty\"]") public MobileElement SLPBeautyHdr;
	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"Beauty SLP\"]/XCUIElementTypeImage[2]") public MobileElement SLPsearchr;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Fashion']") public MobileElement SLPFashionHdr;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Sports']") public MobileElement SLPSportsHdr;
	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"Sports SLP\"]/XCUIElementTypeImage[2]") public MobileElement SLPsportssearchr;
	@FindBy(xpath = "//*[@value='DTH Services']") public MobileElement btnDthServicesIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"circleBlank\"]") public MobileElement UncheckedRadioIOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit\"]") public MobileElement btnSubmitIos;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"TCPApp.TataSkyUserDetailsView\"]") public MobileElement hdrRegisterIos;
	
	
	
	//SLP HOtel//
	@FindAll({@FindBy(xpath="//XCUIElementTypeButton[@name='Explore']/following::XCUIElementTypeOther[1]//XCUIElementTypeButton")}) public List <MobileElement> HeroBannDotIOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Explore']/preceding::XCUIElementTypeStaticText[2]") public MobileElement HeroBanTitle;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Explore']/preceding::XCUIElementTypeStaticText[1]") public MobileElement HeroBanDesc;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Explore']") public MobileElement HotelExp;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Featured offers']") public MobileElement FeaturedOffers;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Featured offers']/following::XCUIElementTypeOther[1]//XCUIElementTypeStaticText") public MobileElement FeaturedOfferWidget;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Editor�s picks']") public MobileElement EditorPick;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Editor�s picks']/following::XCUIElementTypeOther//XCUIElementTypeStaticText)[1]") public MobileElement EditorPickWidget;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Inspired by your recent stays']") public MobileElement Inspired;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Inspired by your recent stays']/following::XCUIElementTypeOther[1]//XCUIElementTypeStaticText") public MobileElement InspiredWidget;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Most viewed']") public MobileElement popular;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Most viewed']/following::XCUIElementTypeOther[1]//XCUIElementTypeStaticText") public MobileElement PopularWidget;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Holiday packages and more']") public MobileElement Holiday;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Holiday packages and more']/following::XCUIElementTypeOther[1]//XCUIElementTypeStaticText") public MobileElement HolidayWidget;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Recommended stays']") public MobileElement Recommend;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Recommended stays']/following::XCUIElementTypeOther[1]//XCUIElementTypeStaticText") public MobileElement RecommendWidget;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Reserve a table']") public MobileElement ReserveHotel;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Book a room']") public MobileElement BookHotel;

	
	
	//SLPGrocery
			@FindBy(xpath="//android.widget.ImageView[@content-desc='Grocery']") public MobileElement SLPGrocery;
			@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/edtFirstName']") public MobileElement fname;
			@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/edtLastName']") public MobileElement lname;
			@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/edtEmail']") public MobileElement email;
			@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/btnSubmit']") public MobileElement letsgo;
			@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Search\"]/following-sibling::android.widget.ImageView") public MobileElement location1;
			@FindBy(xpath="//*[@resource-id='com.android.permissioncontroller:id/permission_deny_button']") public MobileElement denyButton;
			@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Tata Neu\"]/following-sibling::android.widget.ImageView") public MobileElement hamburger;
			@FindBy(xpath="//android.view.View[@content-desc=\"Shipping Address\"]/following-sibling::android.widget.EditText") public MobileElement location2;
			@FindBy(xpath="//android.widget.Button[@content-desc=\"Add New\"]") public MobileElement addnew;
			@FindBy(xpath="//android.view.View[@content-desc=\"Use My Current Location\"]/following::android.widget.EditText[3]") public MobileElement pin;
			@FindBy(xpath="//*[@text='411023, Pincode']") public MobileElement pincode1;
			@FindBy(xpath="//*[@text='House No.']") public MobileElement houseNo;
			@FindBy(xpath="//*[@text='Building name, block No.']") public MobileElement blockno;
			@FindBy(xpath="//*[@text='Landmark']") public MobileElement landmark;
			@FindBy(xpath="//android.widget.EditText[@text='Enter label']") public MobileElement label;
			@FindBy(xpath="//android.widget.Button[@content-desc='Save']") public MobileElement save;
			@FindBy(xpath = "//*[contains(@text,'Card payments')]") public MobileElement cardPayment;
			@FindBy(xpath="//*[contains(@text,'Retry payment')]") public MobileElement retryPaymentBtn;
			@FindBy(xpath = "//*[contains(@text,'Enter CVV')]") public MobileElement cvvCodeCredit_android;
			@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnPayMultitender'] | (//android.widget.Button[contains(@text,'Pay')])[1]") public MobileElement payBtn_android;
			@FindBy(xpath = "//*[@resource-id='password'] | //*[@resource-id='otpForm']//android.widget.EditText") public MobileElement Password;
			@FindBy(xpath="//android.view.View[@resource-id=\"footerWrapperHome\"]/child::android.view.View[2]") public MobileElement basketBtn1;
			@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/right_arrow_logo']") public MobileElement right_arrow;
			@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/txtLocationSearch']") public MobileElement locSearch;
		    @FindBy(xpath="(//*[@resource-id='com.tatadigital.tcp.dev:id/text1'])[1]") public MobileElement loc1;
			@FindBy(xpath="//*[@text='REQUEST FOR DELIVERY']") public MobileElement req_for_Del;
		    @FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Navigate up\"]") public MobileElement navBack;
		    @FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id='com.tatadigital.tcp.dev:id/addressListRecyclerView']/descendant::android.widget.RadioButton[4]") public MobileElement addres1;
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/iv_drawer']") public MobileElement drawer;
		    @FindBy(xpath="//*[@text='USE THIS LOCATION']") public MobileElement useThisLoc;
		    @FindBy(xpath="//*[@text='bigbasket']/preceding-sibling::android.view.View") public MobileElement drawer1;
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/txtCityName']") public MobileElement addreText;
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivClose']") public MobileElement close;
		    @FindBy(xpath="//*[@content-desc='Shop by category']/descendant::android.widget.ImageView[2]") public MobileElement widget2;
		    @FindBy(xpath="//*[@text='Foodgrains, Oil & Masala']/preceding-sibling::android.view.View[1]") public MobileElement drawer2;
		    @FindBy(xpath="//android.view.View [@resource-id='modal']/descendant::android.view.View[3]/child::android.view.View") public MobileElement addreText1;

		    @FindBy(xpath="//android.view.View [@content-desc='search-location']") public MobileElement search;
		    @FindBy(xpath="//*[@resource-id='root']/descendant::android.widget.EditText") public MobileElement search1;
		    @FindBy(xpath="//*[@resource-id='root']/child::android.view.View[8]") public MobileElement address3;
		    @FindBy(xpath="//android.view.View [@resource-id='modal']/descendant::android.view.View[3]/child::android.view.View[1]") public MobileElement addreText2;


		    /* shubham - NCBB */
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvPaymentStatus']") public MobileElement paymentSuccesful;
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvOtherUPI']") public MobileElement trackOrder;
		    @FindBy(xpath="//*[@content-desc='TataNeu'] | //*[@text='TATANEU']") public MobileElement tataNeuMyorder;
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/cbTcpPoints']") public MobileElement neucoinsCheckbox;
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvEditTataOnePoint'] |//*[@text='Edit']") public MobileElement editNeucoins;
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/clPaymentModes']") public MobileElement editNeucoins2;
		    @FindBy(xpath="//*[@text='Confirm']") public MobileElement confirmButtoNC;
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/btnPayMultitender']") public MobileElement payBuuttonNC;
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivExpandView']") public MobileElement downArrowBB;
		    @FindBy(xpath="(//*[@text='NeuCoins'])[1]") public MobileElement neuCoinsText;  
		    
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/iv_drawer']") public MobileElement hamburgerBB;  
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivLogo']") public MobileElement helloTextBB;  
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivClose']") public MobileElement crossBtnBB;  
		    @FindBy(xpath="(//*[@content-desc='Tata Neu']/following::android.widget.ImageView)[1]") public MobileElement hamburgerHP;  
		    @FindBy(xpath="//*[@text='Sign out']") public MobileElement SignOutHP;  
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/positiveButton']") public MobileElement iWillText;  
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/positiveButton']") public MobileElement okBtnHP;  
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/mobileNumberEditText']") public MobileElement mobiletextbox;  
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/mobileConfirmButton'] | //*[@text='Get OTP']") public MobileElement getOtpBtnBB;  
		    @FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/otpPinView']") public MobileElement otpTextBoxBB;  
		    
		    
		    
		    
		    
		  
		    
		    
		    
		    
		    
			//@FindBy(className="android.widget.EditText") public MobileElement location2;
			@FindBy(xpath="//android.view.View[@content-desc=\"Shipping Address\"]/following-sibling::android.widget.EditText/child::android.widget.ImageView") public MobileElement arrow;
			@FindBy(xpath="//android.widget.Button[@resource-id=\"com.tatadigital.tcp.dev:id/positiveButtonBb\"]") public MobileElement continueBtn;
			@FindBy(xpath="(//android.widget.TextView[@resource-id=\"com.tatadigital.tcp.dev:id/btnAddToBasket\"])[1]") public MobileElement addBtn1;
			@FindBy(xpath="(//android.widget.TextView[@resource-id=\"com.tatadigital.tcp.dev:id/btnAddToBasket\"])[2]") public MobileElement addBtn2;
			@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.tatadigital.tcp.dev:id/bbBottomNavItemIcon\"])[4]") public MobileElement basketBtn;

			//handle error popup after click on basketBtn
			@FindBy(xpath="//android.widget.Button[@resource-id=\"com.tatadigital.tcp.dev:id/positiveButtonBb\"]") public MobileElement okBtn;

			
			@FindBy(xpath="//android.widget.Button[@resource-id=\"com.tatadigital.tcp.dev:id/checkoutButton\"]") public MobileElement addAddressToCheckOut;
			@FindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.tatadigital.tcp.dev:id/radioButton\"]") public MobileElement address1;

			@FindBy(xpath="//*[@text='chetan']") public MobileElement address2;

			
			//handle pop up after click on address radio button
			@FindBy(xpath="//*[@text='CONFIRM']") public MobileElement confirm;
			
			
			@FindBy(xpath="//*[@text='CHECKOUT']") public MobileElement checkOut;

            //handle popup after click on checkout
			@FindBy(xpath="//*[@text='OK']") public MobileElement ok;

			@FindBy(xpath="//*[@text='PROCEED TO PAY']") public MobileElement proceedToPay;
			
			@FindBy(xpath="//*[@resource-id='157']") public MobileElement tataNeuRadioBtn;

			@FindBy(xpath="//*[@resource-id='180']") public MobileElement placeOrderAndPay;

			
			//handle popup after clicking on place order and pay
			@FindBy(xpath="//*[@resource-id='proceedPlaceOrder']") public MobileElement continueBTn;

			@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/edCvv']") public MobileElement enterCVV;

			@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/btnPayMultitender']") public MobileElement pay;

			@FindBy(xpath="//*[@resource-id='cancelButton']") public MobileElement cancle;


			@FindBy(xpath="//*[@resource-id='RetryButton']") public MobileElement retryBtn;

			//handle pop up comes after click on cancel transaction
			@FindBy(xpath="//*[@resource-id='android:id/button1']") public MobileElement ok1;
			
			@FindBy(xpath="//*[@text='Debit Card']") public MobileElement debitCard;


			
			
	
	//Login//

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Login with Password']") public MobileElement LogPas_IOS;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentTextFieldCell'])[2]/XCUIElementTypeSecureTextField") public MobileElement passwordBox_IOS;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='tcpApp.home.scanButton'])[2]") public MobileElement Hamburger_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Confirm']") public MobileElement confirm_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Electronics']") public MobileElement SLPElectroniccc_IOS;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Shop Now']") public MobileElement offer_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='closeODPScreen']") public MobileElement Closeoffer_ios;

	//SLP Fashion//
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='End of season sneak peek']") public MobileElement Sneakpeak_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='End of season sneak peek']/following::XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]") public MobileElement Sneakpeakdesc_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='End of season sneak peek']/following::XCUIElementTypeOther[2]/XCUIElementTypeButton[1]") public MobileElement SneakpeakButton_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Que magazine']") public MobileElement QueMagazine_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Que magazine']/following::XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]") public MobileElement QueMagazinedesc_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Que magazine']/following::XCUIElementTypeOther[2]/XCUIElementTypeButton[1]") public MobileElement QueMagazineButton_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='New on Tata CLiQ']") public MobileElement NewLaunch_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='New on Tata CLiQ']/following::XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]") public MobileElement NewLaunchdesc_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='New on Tata CLiQ']/following::XCUIElementTypeOther[2]/XCUIElementTypeButton[1]") public MobileElement NewLaunchButton_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='10% Instant Cashback on ICICI Debit & Credit Cards']") public MobileElement Creditline_IOS;


	//19-3 Sourav
	//SLP Electronics
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Electronics']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[1]") public MobileElement searchElectronics_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Electronics']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[2]") public MobileElement cartElectronics_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Happy Birthday!']") public MobileElement birthdayBannerTitle_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Popular product']") public MobileElement electronicsPopularProduct_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='Limited time deals']") public MobileElement electronicsLimitedDeal_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Top brands']") public MobileElement electronicsCrossBrandOffers_ios;
	//Hero Banner
	@FindAll({@FindBy(xpath="(//XCUIElementTypeButton)[1]/following::XCUIElementTypeOther[1]//XCUIElementTypeButton")}) public List <MobileElement> HeroBannDot_IOS;
	@FindBy(xpath = "(//XCUIElementTypeButton)[1]/preceding::XCUIElementTypeStaticText[2]") public MobileElement HeroBanTitle_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton)[1]/preceding::XCUIElementTypeStaticText[1]") public MobileElement HeroBanDesc_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton)[1]") public MobileElement HeroBanCTA_ios;
	//Shop by Category
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Shop by category']") public MobileElement electronicsShopbyCateogry_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Home Appliances']") public MobileElement electronicsHomeApplianceCategory_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Laptops and Tablets']") public MobileElement electronicsLaptopCategory_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Mobile Phones']") public MobileElement electronicsPhoneCategory_ios;

	//Exchange and Video Demo
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Swap your old phone for a shiny new one!']") public MobileElement exchangeWidget_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Exchange Now']") public MobileElement exchangeWidgetCTA_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Microsoft Surface GO']") public MobileElement videoDemoWidget_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Schedule store demo']") public MobileElement videoDemoWidgetCTA_ios;
	//Recommended Offer,Offer from Other Brand,More great offers xpath
	@FindBy(xpath="//XCUIElementTypeOther[@name='Recommended offers for you']/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText") public MobileElement electronicsRecOfferDesc_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Offers from other brands']/following-sibling::XCUIElementTypeOther[1]") public MobileElement electronicsOffOtherBrandDesc_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='More great offers']/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText") public MobileElement electronicsNextOfferDesc_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Recommended offers for you']") public MobileElement electronicsOffersRecommended_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Offers from other brands']") public MobileElement electronicsCrossBandOffers_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='More great offers']") public MobileElement electronicsNextBestOffers_ios;
	//Expert reviews and guide to electronics xpath
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Expert reviews']") public MobileElement electronicsExpertReview_ios;
	@FindAll({@FindBy(xpath="(//XCUIElementTypeOther[@name='Expert reviews']/following-sibling::XCUIElementTypeOther)[3]//XCUIElementTypeButton")}) public List <MobileElement> electronicsExpertReviewDot_ios;
	@FindBy(xpath="((//XCUIElementTypeOther[@name='Expert reviews']/following-sibling::XCUIElementTypeOther)[2]//XCUIElementTypeStaticText)[2]") public MobileElement electronicsExpertReviewDesc_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='YouTube Video Player']") public MobileElement electronicsExpertReviewVideoPlayer_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Your guide to electronics']") public MobileElement electronicsGuideToElectronics_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='Your guide to electronics']/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText") public MobileElement electronicsGuideContentDesc_ios;

	/* SLP Essentials XPATH */
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Essentials']") public MobileElement essentialsHomepageTitle_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='Essentials SLP']/XCUIElementTypeOther/XCUIElementTypeImage[1]") public MobileElement searchEssentials_ios;	
	//BB Star Membership Widget
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Save 30% extra on products']") public MobileElement essentialsBBStarTitle_ios;
	@FindAll({@FindBy(xpath="//XCUIElementTypeStaticText[@name='Save 30% extra on products']/following::XCUIElementTypeOther[1]//XCUIElementTypeStaticText")}) public List<MobileElement> essentialsBBStarDesc_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Join Now']") public MobileElement essentialsBBStarCTA_ios;
	//Offers for you
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Offers for you']") public MobileElement essentialsOffersForU_ios;
	@FindBy(xpath="(//XCUIElementTypeOther[@name='Offers for you']/following-sibling::XCUIElementTypeOther)[2]//XCUIElementTypeStaticText") public MobileElement essentialsOffersForUDesc_ios;

	//Bundles you may like
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Bundles you may like']") public MobileElement essentialsBundles_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Home chef’s collection']") public MobileElement essentialsBundlesHomeChef_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Work from home']") public MobileElement essentialsBundlesWorkHome_ios;

	//Content Widget - Recipes,hacks & more
	@FindBy(xpath="//XCUIElementTypeOther[@name='Recipes, hacks & more']") public MobileElement essentialsContentRecepie_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='Recipes, hacks & more']/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText") public MobileElement essentialsContentRecepieDesc_ios;

	//All Categories Widget
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Fruits & Vegetables']") public MobileElement essentialsFruitsCategory_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Cleaning & Household']") public MobileElement essentialsCleaningCategory_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Foodgrains, Oil & Masala']") public MobileElement essentialsFoodCategory_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Foodgrains, Oil & Masala']/../../following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeStaticText") public MobileElement essentialsCategoryTwoDesc_ios;
	//SLP fashion
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Shop by theme']") public MobileElement ShopByTheme_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Shop by theme']/following::XCUIElementTypeOther[2]//XCUIElementTypeStaticText") public MobileElement ShopByThemeWidget_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Shop by category']") public MobileElement ShopByCategory_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Shop by category']/following::XCUIElementTypeOther[1]//XCUIElementTypeOther[2]/XCUIElementTypeStaticText") public MobileElement ShopByCategoryWidget_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Top brands']") public MobileElement TopBrands_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Top brands']/following::XCUIElementTypeOther[1]") public MobileElement TopBrandsWidget_ios;

	//Editor box
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'From the editor’s desk')]/following::XCUIElementTypeOther[3]") public MobileElement textEditorDeskIos;

	//April 19
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Bundle bonanza']") public MobileElement BundlesElectronicsIos;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='The Westside store']") public MobileElement WestSide_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Special price store']") public MobileElement SPlPrice_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Top brands']") public MobileElement TopBrands_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Lifestyle store']") public MobileElement Lifestyle_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Shoe store']") public MobileElement ShoeStore_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Men's fashion']") public MobileElement mensFashion_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Womens fashion']") public MobileElement WomensFashion_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='kid's fashion']") public MobileElement kidsFashion_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Footwear']") public MobileElement Footwear_IOS;
	//Smart Basket
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Smart Basket']") public MobileElement SmartBasket_IOS;
	//Speciality Store
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Speciality Store']") public MobileElement SpecialityStore_IOS;
	//Brands you love
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Brands you love']") public MobileElement essentailsTopBrands_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Brands you love']") public MobileElement ShopByCategory2_ios;
	//April 20//
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Televisions'] | //XCUIElementTypeStaticText[@name='Audio and Video'] | //XCUIElementTypeStaticText[@name='Kitchen Appliances']") public MobileElement electronicsShopbyCateogry2_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Limited time deals']") public MobileElement limitedDeals_IOS;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Essentials']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[1]") public MobileElement searchEssential_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Essentials']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[2]") public MobileElement cartEssentials_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Fashion']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[1]") public MobileElement searchfas_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Fashion']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[2]") public MobileElement cartFas_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beauty']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[1]") public MobileElement searchBeauty_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beauty']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[2]") public MobileElement cartBeauty_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Hotel']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[1]") public MobileElement searchHotel_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Hotel']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[2]") public MobileElement cartHotel_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Sports']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[1]") public MobileElement searchSports_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Sports']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeImage)[2]") public MobileElement cartSports_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Inspired by your recent')]") public MobileElement CrossBrand_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Offers for you')]") public MobileElement offersEssentials;
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Offers you may like')]") public MobileElement offersfashion;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='End of season sneak peek']") public MobileElement SneakPeek_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Trending offers']") public MobileElement TrendingOff_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Shop by theme']") public MobileElement shopTheme_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Popular products']") public MobileElement popularprod_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Recently viewed']") public MobileElement RecentlyViewdEled_IOS;

	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'upcoming')]") public MobileElement CrossBrnd1Elec_IOS;



	//Android Only


	@FindBy(id="com.tatadigital.tcp.dev:id/tvSharesLeft")public MobileElement andShareCount;
	//25-2 Sourav
	@FindBy(xpath = "//*[@text='webview']") public MobileElement webview_android;
	@FindBy(xpath = "//*[@text='SLP Electronics']") public MobileElement slpElectronicsTxt_android;
	@FindBy(xpath="//*[@class='sprivilegeclose']") public MobileElement birthdayBannerCloseButton_android;
	@FindBy(xpath="//*[@text='Happy Birthday!']") public MobileElement birthdayBannerTitle_android;
	@FindBy(xpath="//*[contains(@text,'Treat yourself with a 40% discount')]") public MobileElement birthdayBannerSubtitle_android;
	@FindBy(xpath="//*[@text='Find a store near you']") public MobileElement birthdayBannerSearchStoreCTA_android;
	@FindBy(xpath="//*[@text='Recommended offers for you']") public MobileElement electronicsOffersRecommended_android;
	@FindBy(xpath="//*[@text='Offers from other brands']") public MobileElement electronicsCrossBandOffers_android;
	@FindBy(xpath="//*[@text='Popular product']") public MobileElement electronicsPopularProduct_android;
	@FindBy(xpath="//*[@text='Shop by category']") public MobileElement electronicsShopbyCateogry_android;	
	@FindBy(xpath="//*[@text='Home Appliances'] | //*[@text='Home appliances']") public MobileElement electronicsHomeApplianceCategory_android;
	@FindBy(xpath="//*[@text='Laptops and Tablets']") public MobileElement electronicsLaptopCategory_android;
	@FindBy(xpath="//*[contains(@text,'Mobile Phones')]") public MobileElement electronicsPhoneCategory_android;
	@FindBy(xpath="//*[@text='Limited time deals']") public MobileElement electronicsLimitedDeal_android;
	@FindBy(xpath="//*[@text='More great offers']") public MobileElement electronicsNextBestOffers_android;
	@FindBy(xpath="//*[@text='Top brands']") public MobileElement electronicsCrossBrandOffers_android;
	@FindBy(xpath="//*[@text='Apple']") public MobileElement electronicsAppleBrand_android;
	@FindBy(xpath="//*[@text='Samsung']") public MobileElement electronicsSamsungBrand_android;
	@FindBy(xpath="//*[@text='Credit line widget']") public MobileElement electronicsCreditLine_android;
	@FindBy(xpath="(//button[text()='SIGN IN '])[1]") public WebElement signinBtn;
	//Web element
	@FindBy(xpath="//*[text()='Electronics']") public WebElement electronicsHomepageTitle;
	@FindBy(xpath="//*[text()='Electronics']/following::div[1] | //*[@id='search-b'] | //*[text()='Essentials']/following::div[1]") public WebElement searchButton;



	//SLPHotel//
	@FindBy(xpath="//*[text()='Hotels']") public WebElement HotelHomepageTitle;
	@FindBy(xpath="//*[text()='Book a room']") public WebElement BookAroom;
	@FindBy(xpath="//*[text()='Featured offers']") public WebElement FeaturedOffer;
	@FindBy(xpath="(//*[text()='Featured offers']/following::div/h5)[1]") public WebElement FeaturedOfferWidgetAnd;
	@FindBy(xpath="//*[text()='Most viewed']") public WebElement Mostviewed;
	@FindBy(xpath="(//*[text()='Most viewed']/following::div/h5)[1]") public WebElement MostviewedWidget;
	@FindBy(xpath="//*[text()='Editor�s picks']") public WebElement Editorpicks;
	@FindBy(xpath="(//*[text()='Editor�s picks']/following::div/h5)[1]") public WebElement EditorpicksWidget;
	@FindBy(xpath="//*[text()='Inspired by your recent stays']") public WebElement InspiredAnd;
	@FindBy(xpath="(//*[text()='Inspired by your recent stays']/following::div/h5)[1]") public WebElement InspiredWidgetAnd;
	@FindBy(xpath="//*[text()='Holiday packages and more']") public WebElement HolidayPack;
	@FindBy(xpath="(//*[text()='Holiday packages and more']/following::div/h5)[1]") public WebElement HolidayPackWidget;
	@FindBy(xpath="//*[text()='Recommended stays']") public WebElement Recommendedstays;
	@FindBy(xpath="(//*[text()='Holiday packages and more']/following::div/h5)[1]") public WebElement RecommendedstaysWidget;
	@FindBy(xpath="//*[text()='Reserve a table']") public WebElement ReserveATable;
	@FindAll({@FindBy(xpath="//*[text()='Featured offers']/../../following-sibling::div//h5")}) public List<WebElement> FeaturedOffersList;
	@FindAll({@FindBy(xpath="//*[text()='Most viewed']/../../following-sibling::div//h5")}) public List<WebElement> MostViewedList;
	@FindAll({@FindBy(xpath="//*[text()='Inspired by your recent stays']/../../following-sibling::div//h5")}) public List<WebElement> InspiredList;
	@FindAll({@FindBy(xpath="//*[text()='Holiday packages and more']/../../following-sibling::div//h5")}) public List<WebElement> HolidayList;
	@FindAll({@FindBy(xpath="//*[text()='Recommended stays']/../following-sibling::div//h3")}) public List<WebElement> RecommendList;
	@FindAll({@FindBy(xpath="//*[text()='Editor�s picks']/following-sibling::div//h3")}) public List<WebElement> editorList;
	@FindBy(xpath="//*[@text='Hotels'] | //android.widget.ImageView[@content-desc='Hotels']") public MobileElement SLPHotel;
	@FindBy(xpath="//*[@content-desc='Grocery']") public MobileElement SLPEssen;
	@FindBy(xpath="//*[@text='Fitness']") public MobileElement SLPsport;
	@FindBy(xpath="//*[@text='Beauty'] | //android.widget.ImageView[@content-desc='Beauty']") public MobileElement SLPBeauty;
	@FindBy(xpath="//*[@text='Electronics'] | //android.widget.ImageView[@content-desc='Electronics']") public MobileElement SLPelect;
	@FindBy(xpath="//*[@content-desc='Fashion']") public MobileElement SLPFashion;
	@FindBy(xpath="//*[@text='Luxury'] | //android.widget.ImageView[@content-desc='Luxury']") public MobileElement SLPLuxury;
	@FindBy(xpath="//*[@content-desc='Flights']") public MobileElement SLPFlight;
	@FindBy(xpath="//*[@text='Food'] | //*[@text='F&B']") public MobileElement SLPFood;
	//login//
	@FindBy(id="com.tatadigital.tcp.dev:id/txtLetsStart") public MobileElement starttcp;
	@FindBy(id="com.tatadigital.tcp.dev:id/mobileNumberEditText") public MobileElement phone;
	@FindBy(id="com.tatadigital.tcp.dev:id/mobileConfirmButton") public MobileElement conf;
	@FindBy(id="com.tatadigital.tcp.dev:id/passwordEditText") public MobileElement passwrd;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnSubmit") public MobileElement submit;
	//Mar10//
	@FindBy(id="com.tatadigital.tcp.dev:id/otpPinView") public MobileElement OTP;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivHamburgerMenu") public MobileElement HamburgerMenu;
	@FindAll({@FindBy(xpath="//*[@text='Explore']/following::android.widget.ListView//android.widget.Button")}) public List<MobileElement> HotelBanlistAnd;
	@FindBy(xpath="//*[@text='Explore']/preceding::android.view.View[1]") public MobileElement HotelBannDesc;
	@FindBy(xpath="//*[@text='Explore']/preceding::android.view.View[2]") public MobileElement HotelBannTitle;
	@FindBy(xpath="//*[@text='Explore']") public MobileElement ExploreCTA;
	@FindBy(xpath="//*[@text='Book a room'] | //*[@text='Book a stay']") public MobileElement BookHotelCTA;
	@FindBy(xpath="//*[@text='Reserve a table']") public MobileElement ReserveTableCTA;
	@FindBy(xpath="//*[@text='Featured offers']") public MobileElement FeaturedOffAnd;
	@FindBy(xpath="//*[@text='Featured offers']/following::android.view.View[1]//android.view.View[2]") public MobileElement FeaturedOffWidgetAnd;
	@FindBy(xpath="//*[@text='Inspired by your recent stays']") public MobileElement InspiredOffAnd;
	@FindBy(xpath="//*[@text='Inspired by your recent stays']/following::android.view.View[@index='1'][1]") public MobileElement InspiredOffWidgetAnd;
	@FindBy(xpath="//*[@text='Holiday packages and more']") public MobileElement HolidayOffAnd;
	@FindBy(xpath="//*[@text='Holiday packages and more']/following::android.view.View[1]//android.view.View[2]") public MobileElement HolidayOffWidgetAnd;
	@FindBy(xpath="//*[@text='Recommended stays']") public MobileElement RecommendOffAnd;
	@FindBy(xpath="//*[@text='Recommended stays']/following::android.view.View[1]//android.view.View[2]") public MobileElement RecommendOffWidgetAnd;
	@FindBy(xpath="//*[@text='Editor�s picks']") public MobileElement EditorOffAnd;
	@FindBy(xpath="//*[@text='Editor�s picks']/following::android.view.View[1]//android.view.View[2]") public MobileElement EditorOffWidgetAnd;
	@FindBy(xpath="//*[@text='Most viewed']") public MobileElement MostViewedAnd;
	@FindBy(xpath="//*[@text='Most viewed']/following::android.view.View[1]//android.view.View[2]") public MobileElement MostViewedWidgetAnd;
	//11-3 Sourav
	//Login
	@FindBy(id="com.tatadigital.tcp.dev:id/otpPinView") public MobileElement otpBoxLogin_android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu'] | //android.view.View[@content-desc='Tata Neu']/following-sibling::android.widget.ImageView") public MobileElement hamburgerMenu_android;

	//HomePage
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Electronics')]") public MobileElement ElectronicsTitle_android;
	@FindBy(xpath = "//*[@text='Electronics']") public MobileElement search_android;
	@FindBy(xpath = "(//*[contains(@text,'Electronics')])[2]//following::android.widget.Image[1] | //*[contains(@text,'Electronics')]/following-sibling::android.widget.Image[1]") public MobileElement searchElectronics_android;
	@FindBy(xpath = "(//*[contains(@text,'Electronics')])[2]//following::android.widget.Image[2] | //*[contains(@text,'Electronics')]/following-sibling::android.widget.Image[2]") public MobileElement CartElectronics_android;
	//android.widget.Image
	//Hero Banner
	@FindAll({@FindBy(xpath="//*[@resource-id='spa-root']//android.widget.ListView//android.widget.Button")}) public List <MobileElement> HeroBannDotAndroid;
	@FindBy(xpath = "((//*[@resource-id='spa-root']//android.widget.ListView//preceding-sibling::android.view.View)[1]//android.view.View)[6] | //*[@resource-id='heroBannerHeading']") public MobileElement HeroBanTitle_android;
	@FindBy(xpath = "((//*[@resource-id='spa-root']//android.widget.ListView//preceding-sibling::android.view.View)[1]//android.view.View)[7]") public MobileElement HeroBanDesc_android;
	@FindBy(xpath = "(//*[@resource-id='spa-root']//android.widget.ListView//preceding-sibling::android.view.View)[1]//android.widget.Button") public MobileElement HeroBanCTA_android;
	//Croma Page
	@FindBy(xpath = "(//*[@resource-id='container']//android.view.View)[5]") public MobileElement cromaIcon;
	@FindBy(xpath = "//*[contains(@text,'SIGN IN')]") public MobileElement cromaSignInTxt;
	@FindBy(xpath = "//*[@resource-id='search']") public MobileElement cromaSearchBox;

	//Exchange and Video Demo
	@FindBy(xpath = "//*[@text='Exchange your old phone for a shiny new one!']") public MobileElement exchangeWidget_android;
	@FindBy(xpath = "//*[@text='Exchange Now'] | //*[@text='Exchange now']") public MobileElement exchangeWidgetCTA_android;
	@FindBy(xpath = "//*[contains(@text,'Shop on video')] | //*[contains(@text,'Connect on video for a live demo')]") public MobileElement videoDemoWidget_android;
	@FindBy(xpath = "//*[@text='Book a slot']") public MobileElement videoDemoWidgetCTA_android;


	//Mar12//IHCL homepage
	@FindBy(xpath = "//*[contains(@text,'BOOK A STAY')]") public MobileElement BookStay_android;
	@FindBy(xpath = "//*[contains(@text,'BOOK A STAY')]/preceding-sibling::android.view.View[1]") public MobileElement IHCL_Logo;
	//Tatacliq HomePage
	@FindBy(xpath = "//android.view.View[@content-desc='goBackIcon']/android.widget.TextView | //*[@text='downloadIcon']") public MobileElement TataCLiq_android;
	@FindBy(xpath = "//*[@content-desc='searchIcon'] | //android.view.View[@content-desc='searchIcon']") public MobileElement Search;
	//SLP Fashion//
	@FindBy(xpath="//*[@text='Shop now']/preceding::android.view.View[1][@index='1']") public MobileElement FashBannDesc;
	@FindBy(xpath="//*[@text='Shop now']/preceding::android.view.View[2][@index='0']") public MobileElement FashBannTitle;
	@FindBy(xpath="//*[@text='Shop now']") public MobileElement shonnowCTA;
	@FindAll({@FindBy(xpath="//*[@text='Shop now']/following::android.widget.ListView//android.widget.Button")}) public List<MobileElement> fashBanlistAnd;
	@FindBy(xpath = "//*[@text='Fashion']") public MobileElement FashHome_android;
	@FindBy(xpath = "//*[@text='Fashion']/following::android.widget.Image[1]") public MobileElement FashSearch_android;
	@FindBy(xpath = "//*[@text='Shop by theme']") public MobileElement shopTheme_android;
	@FindAll({@FindBy(xpath="//*[@text='Shop by theme']//following-sibling::android.view.View[1]/android.view.View")}) public List<MobileElement> shopThemelistAnd;
	@FindAll({@FindBy(xpath="//*[@text='Shop by theme']//following-sibling::android.view.View[1]/android.view.View//android.view.View[@index='2'] | //*[@text='Shop by theme']//following-sibling::android.view.View[1]/android.view.View//android.view.View")}) public List<MobileElement> shopThemeTitleAnd;
	@FindBy(xpath = "//*[@text='Shop by category']") public MobileElement shopCategory_android;
	@FindAll({@FindBy(xpath="//*[@text='Shop by category']//following-sibling::android.view.View[1]/android.view.View | //*[@text='Shop by category']//following-sibling::android.view.View//android.widget.Image")}) public List<MobileElement> shopCategorylistAnd;
	@FindAll({@FindBy(xpath="//*[@text='Shop by category']//following-sibling::android.view.View[1]/android.view.View//android.view.View[@index='1'] | //*[@text='Shop by category']//following-sibling::android.view.View//android.widget.Image/following-sibling::android.view.View")}) public List<MobileElement> shopCategoryTitleAnd;

	//Expert reviews and guide to electronics xpath
	@FindBy(xpath="//*[@text='Expert reviews'] | //*[@text='Expert speak']") public MobileElement electronicsExpertReview_android;
	@FindBy(xpath="//*[@text='Expert speak']/following::android.view.View[1]") public MobileElement electronicsExpertReviewTile_android;
	@FindBy(xpath="//*[@text='Your guide to electronics'] | //*[@text='World of gaming']") public MobileElement electronicsGuideToElectronics_android;
	@FindBy(xpath="//*[@text='World of gaming']/../following-sibling::android.view.View[1]//android.view.View[@index='1'] | //*[@text='World of gaming']/../following-sibling::android.view.View[1]//android.view.View[@index='0' and @focusable='true']") public MobileElement electronicsGuideContentDesc;
	//Recommended Offer,Offer from Other Brand,More great offers xpath
	@FindBy(xpath="//*[@text='Recommended for you']//following-sibling::android.view.View[2]//android.view.View[2]") public MobileElement electronicsRecOfferDesc_android;
	@FindBy(xpath="(//*[@text='Offers from other brands']//following-sibling::android.view.View[1]//android.view.View[2])[1]") public MobileElement electronicsOffOtherBrandDesc_android;
	@FindBy(xpath="//*[@text='More great offers']//following-sibling::android.view.View[1]//android.view.View[2]") public MobileElement electronicsNextOfferDesc_android;
	/* SLP Essentials XPATH */
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/toolbarMain']//android.widget.ImageButton") public MobileElement brandHeaderBack_android;
	@FindBy(xpath="//*[@text='Grocery']") public MobileElement essentialsHomepageTitle_android;
	@FindBy(xpath = "//*[@text='Grocery']//following::android.widget.Image[1]") public MobileElement searchEssentials_android;
	//BB Star Membership Widget
	@FindBy(xpath="(//*[@resource-id='spa-root']//android.widget.ListView)[2]") public MobileElement essentialsBBStar_android;
	@FindBy(xpath="(//*[@resource-id='spa-root']//android.widget.ListView)[2]/preceding-sibling::android.view.View[1]") public MobileElement essentialsBBStarTitle_android;
	@FindAll({@FindBy(xpath="(//*[@resource-id='spa-root']//android.widget.ListView)[2]//android.widget.TextView")}) public List<MobileElement> essentialsBBStarDesc_android;
	@FindBy(xpath="((//*[@resource-id='spa-root']//android.widget.ListView)[2]/following-sibling::android.view.View)[1]") public MobileElement essentialsBBStarCTA_android;
	//Offers for you
	@FindBy(xpath="//*[@text='Offers for you']") public MobileElement essentialsOffersForU;
	@FindBy(xpath="//*[@text='Offers for you']//following-sibling::android.view.View[2]//android.view.View[2]") public MobileElement essentialsOffersForUDesc;

	//Bundles you may like
	@FindBy(xpath="//*[@text='Bundles you may like']") public MobileElement essentialsBundles;
	@FindBy(xpath="//*[@text='Home chef�s collection']") public MobileElement essentialsBundlesHomeChef;
	@FindBy(xpath="//*[@text='Work from home']") public MobileElement essentialsBundlesWorkHome;

	//Content Widget - Recipes,hacks & more
	@FindBy(xpath="//*[@text='Recipes, hacks & more']") public MobileElement essentialsContentRecepie;
	@FindBy(xpath="//*[@text='Recipes, hacks & more']//following-sibling::android.view.View[1]//android.view.View[2]") public MobileElement essentialsContentRecepieDesc;

	//All Categories Widget
	@FindBy(xpath="//*[@text='Fruits & Vegetables']") public MobileElement essentialsFruitsCategory_android;
	@FindBy(xpath="//*[@text='Cleaning & Household']") public MobileElement essentialsCleaningCategory_android;
	@FindBy(xpath="//*[@text='Foodgrains, Oil & Masala']") public MobileElement essentialsFoodCategory_android;
	@FindBy(xpath="//*[@text='Foodgrains, Oil & Masala']/../..//following-sibling::android.view.View[1]//android.view.View[2]") public MobileElement essentialsCategoryTwoDesc_android;

	//Big Basket HomePage
	@FindBy(xpath = "(//*[@resource-id='navbar-main']//android.view.View[2])[2]") public MobileElement BigBasketIcon;
	@FindBy(xpath = "//*[@resource-id='input']") public MobileElement BigBasketSearch;
	@FindBy(xpath = "//*[@resource-id='promo_message']") public MobileElement BigBasketPromo;
	@FindBy(xpath = "//*[@resource-id='pwa-header']") public MobileElement BigBasketHeader;

	//Smart Basket
	@FindBy(xpath="//*[contains(@text,'Smart Basket')]") public MobileElement smartBasket_android;

	//Speciality Store
	@FindBy(xpath="//*[contains(@text,'Speciality Store')]") public MobileElement specializedStore_android;

	//Brands you love
	@FindBy(xpath="//*[contains(@text,'Brands you love')]") public MobileElement essentailsTopBrands_android;

	//Mar15//
	//SLP Fashion//
	@FindBy(xpath = "//*[@text=\"Women's fashion\"]") public MobileElement WomensFashion_android;
	@FindBy(xpath="//*[@text=\"Women's fashion\"]//following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement WomensFashion_androidAnd;
	@FindBy(xpath = "//*[@text='Kids fashion']") public MobileElement kidsFashion_android;
	@FindBy(xpath="//*[@text='Kids fashion']//following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement kidsFashion_androidAnd;
	@FindBy(xpath = "//*[@text='Footwear']") public MobileElement footwear_android;
	@FindBy(xpath="//*[@text='Footwear']//following::android.view.View[2]//android.view.View[@index='1']") public MobileElement footwear_androidAnd;
	@FindBy(xpath = "//*[@text=\"Men's fashion\"]") public MobileElement mensFashion_android;
	@FindBy(xpath="//*[@text=\"Men's fashion\"]//following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement mensFashion_androidAnd;
	@FindBy(xpath = "//*[@text='Que magazine'] | //*[contains(@text,'Que')]") public MobileElement QueMagazine_android;
	@FindBy(xpath="//*[@text='Que magazine']//following-sibling::android.view.View[1] | //*[contains(@text,'Que')]//following-sibling::android.view.View[1]") public MobileElement QueMagazineDesc_androidAnd;
	@FindBy(xpath="//*[@text='Que magazine']//following-sibling::android.widget.Button | //*[contains(@text,'Que')]//following-sibling::android.widget.Button") public MobileElement QueMagazineButton_androidAnd;
	@FindBy(xpath = "//*[@text='End of season sneak peek']") public MobileElement SneakPeek_android;
	@FindBy(xpath="//*[@text='End of season sneak peek']//following-sibling::android.view.View[1]") public MobileElement SneakPeekDesc_androidAnd;
	@FindBy(xpath="//*[@text='End of season sneak peek']//following-sibling::android.widget.Button[1]") public MobileElement SneakPeekButton_androidAnd;
	@FindBy(xpath="//*[contains(@text,'ICICI Debit & Credit Cards')]") public MobileElement CreditLine_android;
	@FindBy(xpath="//*[@text='Special price store']") public MobileElement SPlPrice_android;
	@FindBy(xpath="//*[@text='Special price store']/..//following-sibling::android.view.View[1]/android.view.View") public MobileElement SPlPriceWidget_android;
	@FindBy(xpath="//*[@text='Top brands'] | //*[@text='Smartphones by brand']") public MobileElement TopBrands_android;
	@FindBy(xpath="//*[@text='Top brands']//following-sibling::android.view.View[1] | //*[@text='Smartphones by brand']//following-sibling::android.view.View[1]") public MobileElement TopBrandsWidget_android;
	@FindBy(xpath = "//*[@text='New arrivals']") public MobileElement NewLaunch_android;
	@FindBy(xpath="//*[@text='New arrivals']//following-sibling::android.view.View[1]") public MobileElement NewLaunchDesc_androidAnd;
	@FindBy(xpath="//*[@text='New arrivals']//following-sibling::android.widget.Button") public MobileElement NewLaunchButton_androidAnd;
	@FindBy(xpath="//*[@text='Offers you may like']") public MobileElement Offers_androidAnd;
	@FindBy(xpath="//*[@text='Offers you may like']//following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement OffersList_androidAnd;
	@FindBy(xpath="//*[@text='Discover brands from Westside']") public MobileElement WestSide_androidAnd;
	@FindAll({@FindBy(xpath="//*[@text='Discover brands from Westside']/following::android.view.View[1]/android.view.View/android.view.View")}) public List<MobileElement> WestsideWidget_androidAnd;
	@FindBy(xpath="//*[@text='Shoe store']") public MobileElement ShoeStore_androidAnd;
	@FindBy(xpath="//*[@text='Shoe store']//following-sibling::android.view.View[1]//android.view.View[2] | //*[@text='Shoe store']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement ShoeStoreWidget_androidAnd;
	@FindBy(xpath="//*[@text='Trending offers'] | //*[@text='Offers in spotlight']") public MobileElement TrendingOff_androidAnd;
	@FindBy(xpath="//*[@text='Trending offers']//following-sibling::android.view.View[1]//android.view.View[@index='1'] | "
			+ "//*[@text='Offers in spotlight']//following-sibling::android.view.View[2]//android.view.View[@index='1'] | "
			+ "//*[@text='Offers in spotlight']/../following-sibling::android.view.View[1]//android.view.View[@index='1'] | //*[@text='Trending offers']//ancestor::android.view.View[1]/following-sibling::android.view.View/android.view.View/android.view.View/android.view.View") public MobileElement TrendingOffWidget_androidAnd;
	@FindAll({@FindBy(xpath="//*[@text='Lifestyle store']/following::android.widget.ListView//android.widget.Button")}) public List<MobileElement> LifeStyleStoreList;
	@FindBy(xpath="//*[@text='Lifestyle store']") public MobileElement Lifestyle_android;
	@FindBy(xpath="//*[@text='Lifestyle store']//following-sibling::android.view.View[1]//android.view.View[2][@index='1'] | "
			+ "//*[contains(@text,'Lifestyle')]//ancestor::android.view.View[1]/following-sibling::android.view.View[1]/android.view.View/android.view.View/android.view.View") public MobileElement LfestyleTile_android;


	//Mar 16 //
	@FindBy(xpath = "//*[@text='Fitness']") public MobileElement SportsHome_android;
	@FindBy(xpath = "//*[@text='Fitness']/following::android.widget.Image[@text='searchIcon'] | //*[@text='Fitness']//following-sibling::android.widget.Image") public MobileElement SportsSearch_android;
	@FindBy(xpath = "//*[@text='Fitness']/following::android.widget.Image[2]") public MobileElement Sportscart_android;
	@FindBy(xpath = "//*[@text='Beauty']") public MobileElement BeautyHome_android;
	@FindBy(xpath = "//*[@text='Beauty']/following::android.widget.Image[1]") public MobileElement BeautySearch_android;

	@FindBy(xpath="//*[text()='Sports']") public MobileElement SportsHomepageTitleWeb;
	@FindBy(xpath = "//*[text()='Shop by theme']") public MobileElement shopTheme_androidWeb;

	//April 6//

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']") public MobileElement Back_android;
	@FindBy(xpath = "//*[@text='TCP'] | //android.widget.TextView[@text='Tata Neu']") public MobileElement TCPBack_android;
	@FindBy(xpath = "//*[@text='Mobile phones']") public MobileElement Croma_Mobile_phones_android;



	@FindBy(xpath = "//*[@text='Popular Products']/following::android.view.View[1]") public MobileElement productCroma_android;
	@FindBy(xpath = "//*[@text='Order Summary']") public MobileElement ordSum_android;
	@FindBy(xpath = "//*[@text='Order Summary']/following::android.view.View[1]") public MobileElement ordSumText_android;
	@FindBy(xpath = "//*[@text='CHANGE ADDRESS'] | (//*[text()='CHANGE ADDRESS'])[1]") public MobileElement chgAddress_android;
	@FindBy(xpath = "//*[@text='Email Address'] | //*[text()='Email Address']") public MobileElement EmailAddress_android;
	@FindBy(xpath = "//*[@text='Email Address']/following::android.widget.EditText[1] | //*[text()='Email Address']/following::input[1]") public MobileElement EmailAddressEdit_android;
	@FindBy(xpath = "//*[@resource-id='loginActive']/following::android.widget.TextView[1] | //*[@resource-id='loginActive']//following::android.view.View[1]/android.view.View[1]") public MobileElement Loged_android;

	@FindBy(xpath = "//*[@text='More Categories']") public MobileElement moreCategories;
	@FindBy(xpath = "//*[@text='Televisions']") public MobileElement moreCategoriesTV;
	@FindBy(xpath = "//*[@text='Kitchen Appliances']") public MobileElement moreCategoriesKitApp;
	@FindBy(xpath = "//*[@text='Audio and Video']") public MobileElement moreCategoriesAandV;
	@FindBy(xpath = "//*[@text='Grooming and Wellness']") public MobileElement moreCategoriesGandW;
	@FindBy(xpath = "//*[@content-desc='Croma Logo']") public MobileElement cromaLanding;
	@FindBy(xpath = "//*[@content-desc='Navigate up']") public MobileElement cromaSLPBackBtn;
	@FindBy(xpath = "(//*[text()='Shipping Information'])[1] | //*[text()='SHIPPING ADDRESS'] | (//*[@text='Shipping Information'])[1]") public MobileElement Address;
	@FindBy(xpath = "(//*[contains(@text,'Tata Pay')])[2] | //*[@text='Pay with Tata Pay'] | //*[contains(@text,'Pay with')]") public MobileElement TataPay;

	//Editor box

	@FindBy(xpath="//*[contains(@text ,'From the editor')]/following-sibling::android.view.View[2]//android.view.View[2]") public MobileElement textEditorDeskAndroid;
	@FindBy(xpath="(//*[contains(@text ,'Ultimate buying guide')]) | //*[contains(@text ,'Editor')]") public MobileElement EditorDeskAndroid;
	@FindBy(xpath="//*[contains(@text ,'Ultimate buying guide')]/following-sibling::android.view.View[1]") public MobileElement EditorDeskAndroidHeroBanner;
	@FindBy(xpath="//*[contains(@text ,'Ultimate buying guide')]/following-sibling::android.view.View[2]") public MobileElement EditorDeskAndroidSmallThump;

	//TPM page
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvPaymentsMethods'] | //*[@text='Payments']") public MobileElement PAymentMethod_TPM;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvAddPaymentOption'] | //*[@text='Change']") public MobileElement PAymentchangeTPM;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUPIAmountHeader") public MobileElement UPI_TPM;

	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAddCardPaymentOption") public MobileElement AddNEw_TPM;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvViewMultiTender'] | //*[@resource-id='com.tatadigital.tcp.dev:id/tvViewOther']") public MobileElement view_TPM;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvNetBanking'] | //*[contains(lower-case(@text),'netbanking')]") public MobileElement NetBanking_TPM;
	@FindBy(xpath = "//*[contains(@text,'Successful')] | //*[contains(@text,'Success')]") public MobileElement NetBankingSucces_TPM;
	@FindBy(xpath = "//*[contains(@text,'Return')]") public MobileElement btnReturntomercahntsite;
	@FindBy(xpath = "//*[contains(@text,'Others')]") public MobileElement btnMorebanks;
	@FindBy(xpath = "//*[contains(@text,'Avenue Test')]") public MobileElement btnAvenueTestBank;
	@FindBy(xpath = "(//*[contains(@text,'Y')])[2]") public MobileElement btnYes;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPaymentStatus") public MobileElement hdrpaymentstatus;
	@FindAll({@FindBy(xpath="//*[@resource-id='android:id/text1']")}) public List<MobileElement> OptionsYesorNo;
	@FindBy(id = "com.tatadigital.tcp.dev:id/negativeButton") public MobileElement btnCancel;
	@FindBy(id = "com.tatadigital.tcp.dev:id/positiveButton") public MobileElement btnGoback;
	@FindBy(id = "com.tatadigital.tcp.dev:id/messageTextView") public MobileElement msgCanceled;

	
	
	//payent Summary
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPaymentStatus") public MobileElement success_sumary;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionId") public MobileElement success_Transaction;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionDateTime") public MobileElement date_Transaction;
	//@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/rvCreditCard']//android.widget.RadioButton | "
	//		+ "//*[@text='Credit card']/following-sibling::androidx.recyclerview.widget.RecyclerView//android.widget.RadioButton") public MobileElement creditcard;
	@FindBy(xpath = "(//*[contains(@text,'Credit cards')]/following-sibling::androidx.recyclerview.widget.RecyclerView/descendant::android.widget.RadioButton)[1]") public MobileElement creditcard;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/rvDebitCard']//android.widget.RadioButton") public MobileElement debitcard;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnHomePage") public MobileElement GoToHomePAge;

	//shop by category
	@FindBy(xpath="//*[@text='Air Conditioners']") public MobileElement airConditioner_android;
	@FindBy(xpath="//*[@text='Refrigerators']") public MobileElement refrigirator_android;	
	@FindBy(xpath="//*[@text='Water Purifiers']") public MobileElement waterPurifier_android;	

	//14-4 Sourav 
	//Juspay frame
	@FindBy(xpath="//*[@id='juspay_iframe']") public MobileElement juspayIframe;
	//16-4
	@FindBy(xpath="//*[@resource-id='search-option-0']") public MobileElement firstsearchedoption;
	//19-4
	@FindBy(id="com.tatadigital.tcp.dev:id/crossIv") public MobileElement offer_close_android;
	//TATA Cliq
	@FindBy(xpath="//android.widget.Button[@text='searchIcon'] | //android.view.View[@content-desc='searchIcon']") public MobileElement searchButtonCliq_android;
	@FindBy(xpath="//*[@text='Browse Category']/preceding::android.widget.EditText | //*[@text='Trending Now']/preceding::android.widget.EditText | //*[@resource-id='app']//following::android.widget.EditText") public MobileElement searchEditBoxCliq_android;
	@FindBy(xpath="((//*[@resource-id='app']/android.view.View)[2]/android.view.View)[3] | //*[contains(@content-desc,'')]/android.widget.Image") public MobileElement productCliq_android;
	@FindBy(xpath="(//android.widget.Button[@text='size'])[1]") public MobileElement sizeCliq_android;
	@FindBy(xpath="//*[@text='Bag Total']/following-sibling::android.widget.TextView") public MobileElement BagTotalCliq_android;
	@FindBy(xpath="//*[@text='Shipping Charge']/following-sibling::android.widget.TextView") public MobileElement shippingCliq_android;
	@FindBy(xpath="//*[@text='Bag Subtotal']/following-sibling::android.widget.TextView") public MobileElement bagSubtotalCliq_android;
	@FindBy(xpath="//*[@text='Product Discount(s)']/following-sibling::android.widget.TextView") public MobileElement discountCliq_android;
	@FindBy(xpath="//*[@text='Total Payable']/following-sibling::android.widget.TextView") public MobileElement totalPayCliq_android;
	@FindBy(xpath="//*[@text='Continue']") public MobileElement continueCliq_android;
	@FindBy(xpath="//*[@text='Checkout']") public MobileElement checkoutCliq_android;
	@FindAll({@FindBy(xpath="//*[@resource-id='android:id/text1']")}) public List<MobileElement> cardMonthYearCliq_android;
	@FindBy(xpath="//android.view.View[@content-desc='goBackIcon']/android.widget.TextView") public MobileElement logoCliq_android;
	@FindBy(xpath="//android.view.View[@content-desc='My Account']") public MobileElement myaccount_android;
	@FindBy(xpath="//*[@text='My Account']") public MobileElement myaccountdetails_android;
	@FindBy(xpath="//*[@text='CLiQ Points']") public MobileElement cliqpoints_android;
	@FindBy(xpath="//*[contains(@text,'CLiQPoints')]") public MobileElement cliqpointsdetails_android;
	@FindBy(xpath="(//*[contains(@text,'MEMBERSHIP')]/preceding-sibling::*)[2]") public MobileElement membertier_android;



	//TATA Cliq payment page
	@FindBy(xpath="//*[@text='Make Payment']") public MobileElement paymentPageCliq_android;
	@FindBy(xpath="//*[@text='Credit Card']") public MobileElement creditCardCliq_android;
	@FindBy(xpath="(//*[@text='Credit Card']/following::android.widget.EditText)[1]") public MobileElement creditCardNumberCliq_android;
	@FindBy(xpath="(//*[@text='Credit Card']/following::android.widget.EditText)[2]") public MobileElement creditCardNameCliq_android;
	@FindBy(xpath="(//*[@text='Credit Card']/following::android.widget.EditText)[3]") public MobileElement creditCardCVVCliq_android;
	@FindBy(xpath="//*[@text='Credit Card']/following::*[@text='Expiry Month']") public MobileElement creditCardExpiryMonthCliq_android;
	@FindBy(xpath="//*[@text='Credit Card']/following::*[@text='Expiry year']") public MobileElement creditCardExpiryYearCliq_android;
	@FindBy(xpath="//*[@text='Debit Card']") public MobileElement debitcardCliq_android;
	@FindBy(xpath="(//*[@text='Debit Card']/following::android.widget.EditText)[1]") public MobileElement debitCardNumberCliq_android;
	@FindBy(xpath="(//*[@text='Debit Card']/following::android.widget.EditText)[2]") public MobileElement debitCardNameCliq_android;
	@FindBy(xpath="(//*[@text='Debit Card']/following::android.widget.EditText)[3]") public MobileElement debitCardCVVCliq_android;
	@FindBy(xpath="//*[@text='Debit Card']/following::*[@text='Expiry Month']") public MobileElement debitCardExpiryMonthCliq_android;
	@FindBy(xpath="//*[@text='Debit Card']/following::*[@text='Expiry year']") public MobileElement debitCardExpiryYearCliq_android;
	@FindBy(xpath="//*[@text='Netbanking']") public MobileElement netBankingCliq_android;
	@FindBy(xpath="((//*[@text='Netbanking']/../../following-sibling::android.view.View)[1])/android.view.View/android.view.View[5] | //*[@text='Netbanking']/following::*[@text='ICICI Bank']/preceding-sibling::android.view.View[1]") public MobileElement netBankingICICICliq_android;
	@FindBy(xpath="//android.widget.Button[@text='Success']") public MobileElement successCliq_android;
	@FindBy(xpath="//android.widget.Button[@text='Failure']") public MobileElement failureCliq_android;
	@FindBy(xpath="//*[@text='VIEW ORDERS']") public MobileElement viewOrdersCliq_android;
	@FindBy(xpath="//*[@text='Track Order']") public MobileElement trackOrderCliq_android;
	@FindBy(xpath="//*[@text='Pay Now']") public MobileElement payNowCliq_android;
	@FindBy(xpath="//*[contains(@text,'Thank you for shopping with us')]") public MobileElement orderCompleteCliq_android;
	@FindBy(xpath="//*[contains(@text,'CONTINUE SHOPPING')]") public MobileElement continueShoppingCliq_android;
	@FindBy(xpath="//*[contains(@text,'Please enter')]") public MobileElement autoLogInCliq_android;
	
	//April 20//
	@FindBy(xpath="//*[contains(@text,'Trending offers')]") public MobileElement TrendingOff_android;
	@FindBy(xpath="//*[contains(@text,'Offers you may like')]") public MobileElement offers_android;
	@FindBy(xpath="//*[contains(@text,'Inspired by your recent')]") public MobileElement CrossBrand_android;
	@FindBy(xpath="//*[contains(@text,'Television')]") public MobileElement electronicsShopbyCateogry2_android;
	@FindBy(xpath="//*[contains(@text,'Offers for you')]") public MobileElement offersEssentials_android;
	@FindBy(xpath="//*[contains(@text,'Limited time deals')]") public MobileElement limitedDeals_android;
	@FindBy(xpath="//*[contains(@text,'Enhance your TV experience')]") public MobileElement upSell_android;
	@FindBy(xpath="//*[contains(@text,'upcoming')]") public MobileElement CrossBrnd1Elec_android;
	@FindBy(xpath="//*[contains(@text,'Recently viewed')]") public MobileElement RecentlyViewdElec_android;
	@FindBy(xpath="//*[contains(@text,'Offers from other brands')]") public MobileElement CrossBrnd2Elec_android;
	@FindBy(xpath="//*[contains(@text,'Popular products')]") public MobileElement popularprod_android;
	@FindBy(xpath="//*[contains(@text,'Credit Line')]") public MobileElement creditLineElec_android;
	@FindBy(xpath="//*[contains(@text,'Bundle')]") public MobileElement BundleElec_android;


	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/edtSearch']") public MobileElement searchEditBoxFashion_android;
	@FindBy(xpath="//*[@text='Fashion']/following-sibling::androidx.recyclerview.widget.RecyclerView/android.widget.TextView[@resource-id='com.tatadigital.tcp.dev:id/tvSuggestion']") public MobileElement searchEditBoxFashionProduct_android;


	//23-4
	@FindBy(xpath="//*[contains(@text,'Bundle')]/../following-sibling::android.view.View[1]/android.view.View[1]") public MobileElement BundleDescElec_android;
	@FindBy(xpath="(//*[contains(@text,'Bundle')]/following::*)[2]") public MobileElement BundleElecSeeAll_android;
	@FindBy(xpath="") public MobileElement shopbyOffers_android;

	//2-5
	//Invoice Page
	@FindBy(id="com.tatadigital.tcp.dev:id/merchantName") public MobileElement merchantNameInvoice_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/orderId") public MobileElement orderIdInvoice_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDate") public MobileElement dateTimeInvoice_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnApprove") public MobileElement payButtonInvoice_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnReject") public MobileElement cancelButtonInvoice_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/invoiceAmount") public MobileElement totalPayableInvoice_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/txtItemDesc")}) public List<MobileElement> itemsInvoice_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/txtQuantity")}) public List<MobileElement> itemsQtyInvoice_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/itemTotalAmount")}) public List<MobileElement> itemsPayablePriceInvoice_android;



	//Sports Android -->
	@FindBy(xpath = "//*[contains(@text,'Tata CLiQ')]") public MobileElement tataCliqHdrTxt_Sports_android;
	@FindBy(xpath = "//*[@class='android.widget.ImageButton']") public MobileElement tataCliqbackBtn_Sports_android;
	@FindBy(xpath ="//*[@class='android.widget.ListView']/*") public List<MobileElement> herobannerNavBtn_Sports_android;    
	@FindBy(xpath = "//*[@text='Shop Now']") public MobileElement heroBannerShopNowBtn_Sports_android;
	@FindBy(xpath ="//*[@text='Shop Now']/../*[1]") public List<MobileElement> herobannerHeaderTxt_Sports_android;    
	@FindBy(xpath = "//*[@text='Shop Now']/../*[2]") public MobileElement heroBannerDtlsTxt_Sports_android;
	@FindBy(xpath = "//*[contains(@text,'Products')]/..") public MobileElement productsTataClq_Sports_android;
	@FindBy(xpath = "//*[contains(@text,'Instant Cashback')]") public MobileElement bankOffer_Sports_android;
	@FindBy(xpath = "//*[@text='Offers in spotlight']/following-sibling::*[1]") public MobileElement offerinSpotSection_Sports_android;


	//3-5
	//Fashion Update
	@FindBy(xpath="//*[contains(@text,'Fashion Update')] | //*[contains(@text,'Fashion update')]") public MobileElement fashionUpdate_android;
	@FindBy(xpath="//*[contains(@text,'Fashion Update')]/following::android.view.View[1] | //*[contains(@text,'Fashion update')]/following::android.view.View[1]") public MobileElement fashionUpdateTile_android;
	@FindBy(xpath="//android.widget.Button[@text='Play'] | //android.widget.Button[@text='play']") public MobileElement youtubePlayButton_android;
	@FindBy(xpath="(//*[contains(@text,'close video')])[2]") public MobileElement youtubeClose_android;
	@FindBy(xpath="//*[@resource-id='ytp-caption-window-container']") public MobileElement youtubeCaptionWindow_android;
	@FindBy(xpath="//*[contains(@text,'Payment failed')]") public MobileElement paymentFailedHeader;
	@FindBy(xpath="//*[contains(@text,'Close')]") public MobileElement paymentFailedPopupCloseBtn;


	//5*5*21
	@FindBy(xpath="(//*[contains(@text,'My CLiQ Cash')]/following::android.view.View)[4]") public MobileElement cliqcash_switch;
	@FindBy(xpath="//*[@text='CLiQ Cash Applied']/following-sibling::*") public MobileElement cliqcash_applied;
	@FindBy(xpath="//*[@text='Loyalty Applied']/following-sibling::*") public MobileElement loyaltypoints_applied;
	//Payment Page
	@FindBy(id="com.tatadigital.tcp.dev:id/imCloseIcon") public MobileElement paymentCloseIcon;
	//May-05
	//BigBasket
	@FindBy(xpath="//*[@resource-id='pwa-header']/android.view.View/android.view.View[4]") public MobileElement searchBB_android;
	//@FindBy(xpath="//*[@resource-id='productSearch']") public MobileElement searchInputBB_android;
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.tatadigital.tcp.dev:id/searchView\"]") public MobileElement searchInputBB_android;
	@FindBy(xpath="(//*[contains(@text,'Add')])[1]") public MobileElement ADDBB_android;
	@FindBy(xpath = "//*[contains(@text,'CHECKOUT')]") public MobileElement checkoutAndBB;
	@FindBy(xpath = "//*[contains(@text,'PROCEED TO PAY')]") public MobileElement proceedPayAndBB;
	@FindBy(xpath = "//*[contains(@text,'Payment')]") public MobileElement PaymentPgAndBB;
	//@FindBy(xpath = "//*[contains(@text,'Tatapay')] | //*[contains(@text,'Pay with Tata')]") public MobileElement TataPayBB;
	@FindBy(xpath = "//*[@text='Tata Pay']") public MobileElement TataPayBB;
	@FindBy(xpath = "//*[@text='Place order & Pay']") public MobileElement placeOrderBB;
	@FindBy(xpath = "//*[contains(@text,'Continue')]") public MobileElement continueBB;
	@FindBy(xpath = "//*[@text='Basket']") public MobileElement BasketBB;
	//@FindBy(xpath = "//*[contains(@text,'Basket')]") public MobileElement BasketBB;
	@FindBy(xpath = "//*[contains(@text,'Review Basket')]") public MobileElement ReviewBasketPgBB;
	@FindBy(xpath = "") public MobileElement shipAddressBB;
	@FindBy(xpath = "//*[contains(@text,'Default Address')]") public MobileElement defaultAddressBB;
	@FindBy(xpath = "//*[contains(@text,'summer')]/following-sibling::android.widget.Button") public MobileElement clickHerobannerAndroid;
	@FindBy(xpath = "//*[@text='Essentials']/following-sibling::android.widget.Image") public MobileElement searchEssentials;
	@FindBy(xpath="//*[@text='Fruits & vegetables']") public MobileElement fandv_android;
	@FindBy(xpath="//*[@text='Speciality stores']") public MobileElement splstores_android;
	@FindBy(xpath="//*[@text='Meat store']") public MobileElement meatStores_android;
	//Shop by category fashion
	@FindBy(xpath="//*[@text='Casual']") public MobileElement casualCategory_android;
	@FindBy(xpath="//*[@text='Ethnic']") public MobileElement ethnicCategory_android;
	@FindBy(xpath="//*[@text='Footwear']") public MobileElement FootwearCategory_android;
	@FindBy(xpath="//*[@text='Watches']") public MobileElement watchesCategory_android;
	@FindBy(xpath="//*[@text='Makeup']") public MobileElement makeupCategory_android;
	@FindBy(xpath="(//*[@resource-id='pwa-header']/android.view.View/android.widget.TextView)[1]") public MobileElement bbMenu_android;
	@FindBy(xpath="//*[@text='My Account']") public MobileElement bbMyAcc_android;
	@FindBy(xpath="//*[@text='back']") public MobileElement backfromBB_android;
	
	//Sub-category Shortcuts Beauty
	@FindBy(xpath = "//*[@text='Skincare']") public MobileElement skincare_android;
	@FindBy(xpath="//*[@text='Skincare']//following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement skincare_androidAnd;
	@FindBy(xpath = "//*[@text='Fragrances']") public MobileElement fragrances_android;
	@FindBy(xpath="//*[@text='Fragrances']//following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement fragrances_androidAnd;
	@FindBy(xpath = "//*[@text='Makeup']") public MobileElement makeup_android;
	@FindBy(xpath="//*[@text='Makeup']//following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement makeup_androidAnd;
	@FindBy(xpath = "//*[@text='Mens grooming']") public MobileElement mensGrooming_android;
	@FindBy(xpath="//*[@text='Mens grooming']//following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement mensGrooming_androidAnd;
	@FindBy(xpath = "//*[@text='Hair']") public MobileElement hair_android;
	@FindBy(xpath="//*[@text='Hair']//following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement hair_androidAnd;
	//Tata cliq saved address
	@FindBy(xpath = "(//*[contains(lower-case(@text),'confirm address')]/../following-sibling::*//android.widget.TextView)[2]") public MobileElement savedAddressCliq_android;

	@FindBy(xpath="//*[@text='Login']") public MobileElement bbMylogin_android;
	@FindBy(xpath="//*[contains(@text, 'Sign')]") public MobileElement bbsignUp_android;
	@FindBy(xpath="//*[contains(@content-desc, 'My Wallet')]") public MobileElement bbWallet_android;
	@FindBy(xpath="//*[contains(@content-desc, 'profile-update')]") public MobileElement bbMyAccPage_android;
	@FindBy(xpath="//*[contains(@text, 'Wallet Summary')]") public MobileElement Wallet_Page_android;
	@FindBy(xpath="//*[contains(@text, 'Fund Wallet')] | //*[contains(@text, 'Fund wallet')]") public MobileElement addMoneyWallet_android;
	@FindBy(xpath="//*[contains(@text, 'Fund your wallet')]") public MobileElement FundWalletPage_android;
	@FindBy(xpath="//*[contains(@resource-id, 'id_amount_to_fund')]") public MobileElement enterAmountBB_android;
	@FindBy(xpath="//*[contains(@text,'Submit')]") public MobileElement submitBB_android;
	@FindBy(xpath="//*[contains(@text,'Choose a payment')]") public MobileElement paymentPageBB_android;
	@FindBy(xpath="//*[contains(@text,'Net banking')]") public MobileElement typeNB_BB_android;
	@FindBy(xpath="//*[contains(@text,'Choose or search')]") public MobileElement NBpage_BB_android;
	@FindBy(xpath="//*[contains(@text,'AXIS Bank')]") public MobileElement AxisNB_BB_android;
	@FindBy(xpath="//*[contains(@text,'PROCEED')]") public MobileElement pROCEED_BB_android;
	@FindBy(xpath="//*[contains(@text,'Cards')]") public MobileElement typeCards_BB_android;
	@FindBy(xpath="//*[@resource-id='cardNumber']") public MobileElement cardNo_BB_android;
	@FindBy(xpath="//*[@resource-id='cardExpiry']") public MobileElement expiry_BB_android;
	@FindBy(xpath="//*[@resource-id='cardCvv']") public MobileElement cvv_BB_android;
	@FindBy(xpath="//*[@resource-id='cardOwnerName']") public MobileElement nameOnCard_BB_android;
	@FindBy(xpath="//*[contains(@text,'thankyou')]") public MobileElement add_success_android;
	@FindBy(xpath="//*[@resource-id='popup_content']/android.view.View[@content-desc='#']") public MobileElement closeSuccessPopup_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/changePaymentParentLayout']//android.widget.EditText[@resource-id='com.tatadigital.tcp.dev:id/edCvv']") public MobileElement cvvCode_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvViewMultiTender") public MobileElement view_Change_android;
	
	@FindBy(xpath="//*[@text='Speciality stores']") public MobileElement specialityStores_android;
	@FindAll({@FindBy(xpath="//*[@text='Speciality stores']//following-sibling::android.view.View[1]//android.view.View[2]")}) public List<MobileElement> listspecialityStores_android;
	
	@FindAll({@FindBy(xpath="//*[@text='Shop by category']//following-sibling::android.view.View[1]//android.view.View")}) public List<MobileElement> shopCategorySportslistAnd;
	@FindAll({@FindBy(xpath="//*[@text='Shop by category']//following-sibling::android.view.View[1]//android.view.View//android.view.View[@index='0'")}) public List<MobileElement> shopCategorySportsTitleAnd;
	@FindAll({@FindBy(xpath="//*[@text='Shop by activity']//following-sibling::android.view.View[1]//android.view.View")}) public List<MobileElement> shopActivitylistAnd;
	@FindBy(xpath="//*[@text='Shop by activity']") public MobileElement shopbyActivity_android;
	@FindBy(xpath="//android.view.View[@content-desc='searchIcon']") public MobileElement searchIconSports_android;
	
	@FindBy(xpath="//*[contains(@text,'Availability Check')]") public MobileElement avalcheckPage_android;
	@FindBy(xpath="//*[contains(@text,'CONFIRM')]") public MobileElement confirm_android;
	@FindBy(xpath="//*[@text='Use bbwallet balance']") public MobileElement bbwalletUse_android;
	@FindBy(xpath="//*[contains(@text,'Cash On')]") public MobileElement COD_android;
	@FindBy(xpath="//*[contains(@text,'Delivery Options')]") public MobileElement delOptions_android;
	@FindBy(xpath="(//*[@text='Shop now'])[1]/preceding-sibling::android.view.View") public MobileElement bbherobannertitle_android;
	@FindBy(xpath="//*[contains(@text,'Your basket is empty')]") public MobileElement emptyBasket_android;
	//@FindBy(xpath="//*[@text='more']") public MobileElement threedotBB_android;
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"More options\"]") public MobileElement threedotBB_android;
	//@FindBy(xpath="//*[@resource-id='emptyBasket']") public MobileElement emptyBasketCTA_android;
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.tatadigital.tcp.dev:id/title\"]") public MobileElement emptyBasketCTA_android;
	@FindBy(xpath="//*[contains(@text,'Do you want to')]") public MobileElement emptyBasketpopUp_android;
	//@FindBy(xpath="//android.widget.Button[contains(@text,'YES')]") public MobileElement bbaccept_android;
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.tatadigital.tcp.dev:id/positiveButtonBb\"]") public MobileElement bbaccept_android;
	//@FindBy(xpath="//*[@resource-id='pwa-header']/android.view.View/android.view.View[3]") public MobileElement searchBBcart_android;
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Search\"]") public MobileElement searchBBcart_android;
	@FindBy(xpath="//*[contains(@text,'Your order is placed')]") public MobileElement bborderSuccess_android;
	@FindBy(xpath="//*[contains(@text,'Smart')]") public MobileElement bbSmartbasket;
	@FindBy(xpath="//*[contains(@text,'Smart')]/following-sibling::android.widget.Button") public MobileElement bbSmartbasket_CTA;
	@FindBy(xpath="//*[@resource-id='searchIcon']") public MobileElement bbsearchIcon;
	@FindBy(xpath="//*[contains(@text,'like these')]") public MobileElement bbCrossBrand;
	@FindBy(xpath="//*[contains(@text,'Handpicked')]") public MobileElement bbhandPicked;
	@FindBy(xpath="//*[contains(@text,'Dettol')]") public MobileElement bbhandpickedProduct;
	@FindBy(xpath="//*[contains(@text,'bbstar')]") public MobileElement bbStar;
	@FindBy(xpath="//*[contains(@content-desc,'Explore')]") public MobileElement bbstar_CTA;
	@FindBy(xpath="//android.widget.TextView[contains(@text,'bbstar Membership')]") public MobileElement bbStarPageLanding;
	@FindBy(xpath="//android.widget.Button[contains(@text,'Join Now')]") public MobileElement bbStarJoinCTA;
	@FindBy(xpath="//android.widget.TextView[contains(@text,'Pay for bbstar member')]") public MobileElement bbStarPaymentPage;
	@FindBy(xpath="//android.widget.Button[contains(@text,'Pay with bbwallet')]") public MobileElement bbStarPaywithBB;
	@FindBy(xpath="//android.view.View[contains(@text,'Start using your bbstar benefits')]") public MobileElement bbStarSuccess;
	@FindBy(xpath="//*[@class='android.widget.EditText']") public MobileElement inputpincode;
	
	//17-5 Sourav
	@FindBy(id="com.tatadigital.tcp.dev:id/messageTextView") public MobileElement cancelMessageTPM_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/positiveButton") public MobileElement cancelPostiveTPM_android;
	@FindBy(xpath="//android.widget.Image[@text='empty cart']") public MobileElement emptyCartCroma_android;
	@FindBy(xpath="//*[contains(@text,'Your Cart')]") public MobileElement CartItemsCroma_android;

	
	//May21 rev
	@FindBy(xpath="//*[@text='Skincare']//following::android.view.View[2]//android.view.View[@index='1']") public MobileElement skinCareBeauty_android;
	@FindBy(xpath="//*[@text='Fragrances']//following::android.view.View[2]//android.view.View[@index='1']") public MobileElement FragrancesBeauty_android;
	@FindBy(xpath="//*[@text='Makeup']//followi//*[@text='DTH Services']:-btnDthServicesAndroidng::android.view.View[2]//android.view.View[@index='1']") public MobileElement MakeupBeauty_android;
	@FindBy(xpath="//*[@text='Mens grooming']//following::android.view.View[2]//android.view.View[@index='1']") public MobileElement MensgroomingBeauty_android;
	@FindBy(xpath="//*[@text='Hair']//following::android.view.View[2]//android.view.View[@index='1']") public MobileElement HairBeauty_android;
	
	//Akshya
	@FindBy(xpath="//*[@text='Entertainment'] | //*[contains(@text,'Manage DTH')] | //*[contains(@text,'DTH')] | //android.widget.ImageView[@content-desc='Entertainment']") public MobileElement btnDthServicesAndroid;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/rbGetTataSky'] | //*[@resource-id='com.tatadigital.tcp:id/rbGetTataSky']") public MobileElement btnGetTataSkyAndroid;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/rbExistingCustomer'] | //*[@resource-id='com.tatadigital.tcp.dev:id/rbExistingCustomer']") public MobileElement btnExistingCustomerAndroid;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/btnPositive'] | //*[@resource-id='com.tatadigital.tcp.dev:id/btnPositive']") public MobileElement btnSubmitAndroid;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/tvAddresses'] | //*[@resource-id='com.tatadigital.tcp.dev:id/tvAddresses']") public MobileElement hdrRegisterAndroid;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/tvAddAddress'] | //*[@resource-id='com.tatadigital.tcp.dev:id/tvAddAddress']") public MobileElement addressAddAndroid;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/btn_radio'] | //*[@resource-id='com.tatadigital.tcp.dev:id/btn_radio']") public MobileElement addressCheckboxAndroid;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/tvSaveChanges'] | //*[@resource-id='com.tatadigital.tcp.dev:id/tvSaveChanges']") public MobileElement btnContinueAndroid;
	@FindAll({@FindBy(xpath="//*[@resource-id='selectShows']/android.view.View")}) public List<MobileElement> showsDTHAndroid;
	@FindBy(xpath="//*[@text='What do you like to watch?']") public MobileElement showsPageDTHAndroid;
	@FindBy(xpath="//*[@text='Which languages do you watch your shows in?']") public MobileElement languagesDTHAndroid;
	@FindBy(xpath="//*[@text='Hindi']") public MobileElement languageHindiDTHAndroid;
	@FindBy(xpath="//android.widget.Button[@text='Continue']") public MobileElement btnContinueSelPageAndroid;
	@FindBy(xpath="//*[contains(@text,'Do you want to watch your shows in HD')]") public MobileElement HDPageAndroid;
	@FindBy(xpath="//android.widget.Button[@text='Yes']") public MobileElement HDYesAndroid;
	@FindBy(xpath="//android.widget.Button[@text='No']") public MobileElement HDNoAndroid;
	@FindBy(xpath="//*[contains(@text,'Minimum one selection required')]") public MobileElement noSelecteionErrorDTHAndroid;
	
	//Hotel
	@FindBy(xpath="//*[@text='Hotels']") public MobileElement HotelHomepageTitle_android;
	@FindBy(xpath="//*[@text='Hotels']//following::android.widget.Image[1]") public MobileElement HotelSearch_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOffer") public MobileElement hotelHerobannerOfferTitle_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSomeoneElse") public MobileElement hotelBookSomeoneElse_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMe") public MobileElement HotelBookMe_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTitle") public MobileElement hotelHerobannerOfferDetails_android;
	
	@FindBy(xpath="//*[contains(@text,'Welcome to Adobe')]") public MobileElement hotelAdobePage_android;
	@FindBy(xpath="//android.widget.EditText[@resource-id='username']") public MobileElement hotelAdobeUserID_android;
	@FindBy(xpath="//android.widget.EditText[@resource-id='password']") public MobileElement hotelAdobePassword_android;
	@FindBy(xpath="//*[@resource-id='submit-button']") public MobileElement hotelAdobeBtnSignIn_android;
	@FindBy(xpath="//android.widget.Button[@text='BOOK A STAY']") public MobileElement IHCLbookAStay_android;
	@FindBy(xpath="//*[@resource-id='ym-notification']/android.view.View[@text='x']") public MobileElement IHCLcloseChatBox_android;
	@FindBy(xpath="//*[@resource-id='booking-search']//android.widget.EditText") public MobileElement IHCLSearchBox_android;
	@FindBy(xpath="//*[@resource-id='input-box1']") public MobileElement IHCLFromCalendar_android;
	@FindBy(xpath="(//android.widget.Button[@text='+'])[1]") public MobileElement IHCLaddRoom_android;
	@FindBy(xpath="//*[@resource-id='global-re-direct']") public MobileElement IHCLcheckAvail_android;
	@FindBy(xpath="//android.view.View[@content-desc='Navigate to Home Page']/android.view.View/android.widget.Image") public MobileElement IHCLIcon_android;
	@FindBy(xpath="//android.widget.Button[@text='Toggle navigation'] | (//*[@resource-id='menu_area']//android.widget.Button)[1]") public MobileElement IHCLmenu_android;
	@FindBy(xpath="(//android.view.View[@resource-id='navbarSupportedContent']//android.view.View/android.widget.TextView)[1] | (//*[@resource-id='menu_area']//android.widget.TextView)[1]") public MobileElement IHCLMenuBackBtn_android;
	@FindBy(xpath="//*[contains(@text,'Hi, ')]") public MobileElement IHCLUserLogin_android;
	@FindBy(xpath="//*[@resource-id='dest-result']/android.view.View") public MobileElement IHCLDestSuggestion_android;
	@FindBy(xpath="//*[contains(@text,'We have these options for you')] | //*[contains(@text,'got some great options')]") public MobileElement SetUpBoxPageAndroid;
	@FindBy(xpath="//android.widget.Button[contains(@text,'Get this')]") public MobileElement getThisAndroid;
	@FindBy(xpath="//*[contains(@text,'Pick your packs as you like')]") public MobileElement PackPageAndroid;
	@FindBy(xpath="//android.widget.Button[contains(@text,'Get This Pack')]") public MobileElement getThisPackAndroid;
	@FindBy(xpath="//*[contains(@text,'Here is your summary')]") public MobileElement SummaryPageAndroid;
	@FindBy(xpath="//*[@text='Total Amount']/following-sibling::android.widget.TextView[2]") public MobileElement SummaryAmountAndroid;
	@FindBy(xpath="//*[@text='Continue']") public MobileElement btnContinueSummaryAndroid;
	@FindBy(xpath="//*[contains(@text,'Where do you want us to install your connection?')]") public MobileElement AddressPageAndroid;
	@FindBy(xpath="//*[@resource-id='react-select-2-input']") public MobileElement choseAreaAndroid;
	@FindBy(xpath="//*[@resource-id='react-select-2-option-0']") public MobileElement choseAreaoption1Android;
	@FindBy(xpath="//*[@text='Address']/following-sibling::android.widget.EditText[1]") public MobileElement addressEditboxAndroid;
	@FindBy(xpath="//*[@text='Landmark']/following-sibling::android.widget.EditText[1]") public MobileElement landmarkEditboxAndroid;
	@FindBy(xpath="//*[contains(@text,'Choose your payment mode')]") public MobileElement paymentPageDTHAndroid;
	@FindBy(xpath="//*[@text='Pay Online']") public MobileElement payOnlineAndroid;
	@FindBy(xpath="//*[contains(@text,'Select an online payment option')]") public MobileElement onlinePaymentPageDTHAndroid;
	@FindBy(xpath="//*[@content-desc='Opel Payment']") public MobileElement opelAndroid;
	@FindBy(xpath="//*[@text='Reserve a table']") public MobileElement btnReserveatable;
	@FindBy(xpath="(//*[contains(@text, 'Error')]/preceding-sibling::*[@class='android.view.View'])[1]") public MobileElement btnClose;
	@FindBy(xpath="//android.view.View[@content-desc='RESERVE A TABLE']/android.widget.Button") public MobileElement btnReserveATableInIHCL;
	@FindBy(xpath="//*[contains(@text, 'Please call')]") public MobileElement ImgCall;
	
	@FindBy(xpath="//*[@resource-id='container']/android.view.View[2]//android.widget.EditText") public MobileElement cromaSearchBoxFromTCPSearch;
	@FindBy(xpath="//*[@text='Shoes']") public MobileElement shoesCategory_android;
	@FindBy(xpath="//*[@text='T-shirts']") public MobileElement tshirtsCategory_android;
	@FindBy(xpath="//*[@text='Track pants']") public MobileElement trackPantsCategory_android;
	@FindBy(xpath="//*[@text='Beauty trends'] | //*[@text='Expert speak']") public MobileElement beautyTrends_android;
	@FindBy(xpath="//*[@text='Beauty trends']/following::android.view.View[1]") public MobileElement beautyTrendsTile_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMe") public MobileElement btnMe;
	
	@FindBy(xpath="//*[@text=\"Men's edit\"]//following::android.view.View[2]//android.view.View[@index='1']") public MobileElement menWearSports_android;
	@FindBy(xpath="//*[@text=\"Women's edit\"]//following::android.view.View[2]//android.view.View[@index='1']") public MobileElement womenWearSports_android;
	@FindBy(xpath="//*[@text=\"Kids' edit\"]//following::android.view.View[2]//android.view.View[@index='1']") public MobileElement kidWearSports_android;
	
	//7-6
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/btnNegative'] | //*[@resource-id='com.tatadigital.tcp.dev:id/btnNegative']") public MobileElement btnNegative_android;
	@FindBy(xpath="//*[@text='TataSky'] | //*[@text='DTH'] | //*[@text='Entertainment']") public MobileElement DTHHomepage_android;
	@FindBy(xpath="//*[contains(@text,'New connection')]") public MobileElement newOptionDTH_android;
	@FindBy(xpath="//*[contains(@text,'Box upgrade')]") public MobileElement upgradeOptionDTH_android;
	@FindBy(xpath="//*[@text='Recharge']") public MobileElement rechargeOptionDTH_android;
	@FindBy(xpath="//*[contains(@text,'Order showcase')]") public MobileElement rentOptionDTH_android;
	//Tata Sky offers unlocked
	@FindBy(xpath="//*[@text=\"Offers you've unlocked\"]") public MobileElement offerUnlockDTH_android;
	@FindBy(xpath="//*[@text=\"Offers you've unlocked\"]//following-sibling::android.view.View[1]//android.view.View[2]") public MobileElement offerUnlockDTHTile_android;
	//Offers in Spotlight
	@FindBy(xpath="//*[@text='Offers in spotlight']") public MobileElement offerSpotDTH_android;
	@FindBy(xpath="//*[@text='Offers in spotlight']//following-sibling::android.view.View[1]//android.view.View[2]") public MobileElement offerSpotDTHTile_android;
	//Offers on new connection
	@FindBy(xpath="//*[@text='Offers on new connections']") public MobileElement offerNewConnDTH_android;
	@FindBy(xpath="//*[@text='Offers on new connections']//following-sibling::android.view.View[1]//android.view.View[2]") public MobileElement offerNewConnDTHTile_android;
	//Subscriber-id radio buuton
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/tvSelectSubscription'] | //*[@resource-id='com.tatadigital.tcp.dev:id/tvSelectSubscription']") public MobileElement selectSubIdpageDTH_android;
	@FindAll({@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tv_title_subscriptionID']")}) public List<MobileElement> SubIdDTH_android;
	@FindAll({@FindBy(xpath="//*[@resource-id='upgrade']/android.view.View/android.view.View")}) public List<MobileElement> setTopBoxNoDTHAndroid;
	@FindBy(xpath="//*[@text=\"Choose the Set Top Box you�d like to upgrade\"]") public MobileElement setTopBoxPageDTHAndroid;
	@FindBy(xpath="//*[@text='Upgrade to a new Set Top Box']") public MobileElement upgardeSetUpBoxPageDTHAndroid;
	@FindBy(xpath="//*[@text='Cash on Delivery']") public MobileElement CODDTHAndroid;
	@FindBy(xpath="//*[contains(@text,'Upgrade Charges')]") public MobileElement upgardeAmountAndroid;
	@FindBy(xpath="//*[@text='reserve_a_table_1']") public MobileElement imgReserveaTable;
	
	//june10
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAddNewCard") public MobileElement addNew;
	@FindBy(id="com.tatadigital.tcp.dev:id/etCardName") public MobileElement addNewCardName;
	@FindBy(id="com.tatadigital.tcp.dev:id/etCardNumber") public MobileElement addNewCardNumber;
	@FindBy(id="com.tatadigital.tcp.dev:id/etExpMonth") public MobileElement addNewExpiryMonth;
	@FindBy(id="com.tatadigital.tcp.dev:id/etExpYear") public MobileElement addNewExpiryYear;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvTitleName")}) public List<MobileElement> addNewdateSelection;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnAddCardContinue") public MobileElement addNewContinue;
	
	//June11
	@FindBy(xpath="//*[@text='Handpicked offers for you']") public MobileElement handpickedOffer_android;
	@FindBy(xpath="//*[@text='Handpicked offers for you']//following-sibling::android.view.View[2]//android.view.View[2] | "
			+ "//*[contains(@text,'Handpicked offers')]//ancestor::android.view.View[1]/following-sibling::android.view.View[2]/android.view.View/android.view.View/android.view.View") public MobileElement handpickedOfferWidget_android;
	@FindBy(xpath="//*[@text=\"You'll like these too\"]") public MobileElement youLikeThese_android;
	@FindBy(xpath="//*[@text=\"You'll like these too\"]//following-sibling::android.view.View[1]//android.view.View[2]") public MobileElement youLikeTheseWidget_android;
	@FindBy(xpath="//*[@text='Offers running out soon']") public MobileElement limitedOffer_android;
	@FindBy(xpath="//*[@text='Offers running out soon']/../following-sibling::android.view.View[1]//android.view.View[@index='1'] | //*[@text='Offers running out soon']/../following-sibling::android.view.View[1]//android.view.View[@index='0' and @focusable='true']") public MobileElement limitedOfferWidget_android;
	@FindBy(xpath="//*[@text='Still looking for these?']") public MobileElement stillLooking_android;
	@FindBy(xpath="//*[@text='Still looking for these?']//following-sibling::android.view.View[1]//android.view.View[2] | //*[@text='Still looking for these?']/following-sibling::android.view.View[1]//android.view.View[@index='0' and @focusable='true']") public MobileElement stillLookingWidget_android;
	@FindBy(xpath="//*[@text='Trending products']") public MobileElement trendingProd_android;
	@FindBy(xpath="//*[@text='Trending products']//following-sibling::android.view.View[1]//android.view.View[2] | //*[@text='Trending products']/following-sibling::android.view.View[1]//android.view.View[@index='0' and @focusable='true']") public MobileElement trendingProdWidget_android;
	@FindBy(xpath="//*[@text='From the Que magazine'] | //*[@text='Que magazine'] | //*[@text='Que']") public MobileElement QueMagzineFrom_android;
	@FindBy(xpath="//*[@text='From the Que magazine']//following-sibling::android.view.View[1]//android.view.View[2] |  //*[@text='Que magazine']//following-sibling::android.widget.Button[1] | //*[@text='From the Que magazine']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement QueMagzineFromWidget_android;
	@FindBy(xpath="//*[contains(@text,'Buy')] | //*[contains(@text,'Shop')]") public MobileElement buyCDP_android;
	
	//June 18
	@FindBy(xpath="//*[@text='Recharge offers']") public MobileElement rechargeOffer_androidAnd;
	@FindBy(xpath="//*[@text='Recharge offers']//following-sibling::android.view.View[1]//android.view.View[2]") public MobileElement rechargeOfferWidget_androidAnd;
	@FindBy(xpath="//*[@text='Book Now'] | //*[@text='Book now']") public MobileElement btnBookNow;
	@FindBy(xpath="//*[@text='Book a stay'] | //*[@text='BOOK A STAY']") public MobileElement btnBookaStay;
	@FindBy(xpath="//*[@resource-id='booking-search']//android.widget.EditText") public MobileElement Hotelsearchinputfield;
	@FindBy(xpath="//*[@text='Mumbai']/following::android.view.View[@content-desc=\"VIEW DETAILS\"]/android.widget.Button | //android.view.View[@content-desc=\"VIEW HOTEL\"]/android.widget.Button") public MobileElement btnViewDetails;
	@FindBy(xpath="//android.view.View[@content-desc=\"Guest Rooms\"]/android.widget.TextView") public MobileElement btnGuestroom;
	@FindBy(xpath="//*[contains(@text,'STANDARD RATES')]") public MobileElement btnstandardrates;
	
	@FindBy(xpath="//*[contains(@text,'VIEW RATES')]") public MobileElement btnviewrates;
	@FindBy(xpath="//*[contains(@text,'SELECT')]") public MobileElement btnSelect;
	@FindBy(xpath="//*[contains(@text,'CONFIRM')]") public MobileElement btnConfirm;
	@FindBy(xpath="//*[@resource-id='bookingGuestTitleSelectBoxItText']") public MobileElement btnBookingtitleselectboxtxt;
	@FindBy(xpath="//*[contains(@text,'VIEW RATES')]") public MobileElement btntitledropdown;
	@FindBy(xpath="(//*[contains(@text,'Mr')])[1]") public MobileElement btnMr;
	@FindBy(xpath="//*[contains(@text,'Special Requests')]/following::*[@class='android.widget.CheckBox']") public MobileElement chbxTermsandCondition;
	@FindAll({@FindBy(xpath="//*[@class='android.widget.CheckBox']")}) public List<MobileElement> chbxsTermsandCondition;
	@FindBy(xpath="//*[contains(@text,'PROCEED')]") public MobileElement btnProcced;
	@FindBy(xpath="//*[contains(@text,'Mumbai')]") public MobileElement hdrtextMumbai;
	@FindBy(xpath="//*[contains(@text,'App')]") public MobileElement chbxProceedtopay;
	@FindBy(xpath="//*[contains(@text,'Proceed to pay')]") public MobileElement btnProceedtopay;
	@FindBy(xpath="//*[contains(@text,'IHCL')]") public MobileElement hdrihcl;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferChannel") public MobileElement txtdineinonly;
	@FindBy(xpath="//*[contains(@text,'Tata CLiQ')]") public MobileElement hdrTatacliq;
	
	
	//23-6
	@FindBy(xpath="(//*[contains(@text,'Choose film, select date, and get your Showcase movies now')])[2]") public MobileElement rentMovieDTHAndroid;
	@FindBy(xpath="//android.widget.Button[contains(@text,'Order')]") public MobileElement orderRentDTHAndroid;
	@FindBy(xpath="//*[@resource-id='react-select-2-input']/preceding-sibling::android.view.View") public MobileElement showDateRentDTHAndroid;
	@FindBy(xpath="(//*[@text='Select Show Date']/preceding-sibling::android.view.View)[4]") public MobileElement showPriceRentDTHAndroid;
	@FindBy(xpath="(//*[@text='Select Show Date']/preceding-sibling::android.view.View)[2]") public MobileElement showNameRentDTHAndroid;	
	@FindBy(xpath="(//*[contains(@text,'Your movie is just one click away!')])[2]") public MobileElement rentMovieDTHConfirmPageAndroid;
	@FindBy(xpath="//android.widget.Button[contains(@text,'Confirm')]") public MobileElement confirmRentDTHAndroid;
	@FindBy(xpath="//*[contains(@text,'Order Charges')]/following-sibling::android.widget.TextView[2]") public MobileElement orderPriceRentDTHAndroid;
	@FindBy(xpath="//*[contains(@text,'Order successful')] | //*[contains(@text,'Happy Watching')]") public MobileElement rentMovieDTHOrderStatusPageAndroid;
	@FindBy(xpath="//*[contains(@text,'Transaction Id')]") public MobileElement txnIdRentDTHAndroid;
	@FindBy(xpath="//*[contains(@text,'Transaction Date')]") public MobileElement txnDateRentDTHAndroid;
	@FindBy(xpath="//*[contains(@text,\"You don't seem to have enough balance\")]") public MobileElement insufficentBalRentDTHAndroid;

	//june 24
	@FindBy(xpath="//*[contains(@resource-id,'bookmarkHeader')]") public MobileElement bookMarkCDPAnd;
	@FindBy(xpath="//android.widget.Image[@text='shareIcon'] | //android.widget.Image[@text='shareicon']") public MobileElement shareCDPAnd;
	@FindBy(xpath="//*[contains(@resource-id,'bookmarkHeader')]/../../following-sibling::android.view.View[1] | //*[contains(@resource-id,'bookmarkHeader')]/following-sibling::android.view.View[2]") public MobileElement titleCDPAnd;

	
	//24-6
	@FindBy(xpath="//*[@text='bookmarkIcon']") public MobileElement bookmarkIconVideo_android;
	@FindBy(xpath="//*[@text='Share']") public MobileElement shareIconVideo_android;

	@FindBy(xpath="//android.view.View[@content-desc=\"Book now\"]") public MobileElement btnBooknow;
    @FindBy(xpath = "//*[@text='Order history'] | (//*[@resourceid='com.tatadigital.tcp.dev:id/profileOptionsItemsLayout'])[3]")
	public MobileElement orderHistoryTxt_android;

	
	// 25-6
	@FindBy(xpath = "//*[@text='The Westside Store']")
	public MobileElement WestsideStore_android;
	@FindBy(xpath = "//*[@text='The Westside Store']//following-sibling::android.view.View[1]")
	public MobileElement WestsideStoreDesc_androidAnd;
	@FindBy(xpath = "//*[@text='The Westside Store']//following-sibling::android.widget.Button")
	public MobileElement WestsideButton_androidAnd;
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public MobileElement Back_androidAnd;
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]/following::android.widget.TextView[1]")
	public MobileElement TcpHeadandroidAnd;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivHamburgerMenu']")
	public MobileElement hamBurgerMenuBtn_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/viewPagerOrderHistory")
	public MobileElement divorderhistory;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/clOrderHistoryItem'])[1]//*[contains(@text,'Pending')]")
	public MobileElement txtPending;
	@FindBy(xpath = "//*[@text='Home']")
	public MobileElement btnHome;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvAddNewCard'] | //*[@resource-id='com.tatadigital.tcp.dev:id/tvAddNew']") public MobileElement btnAddnew;
	@FindBy(id="com.tatadigital.tcp.dev:id/etCardName")public MobileElement inputcardname;
	@FindBy(id="com.tatadigital.tcp.dev:id/etCardNumber")public MobileElement inputcardno;
	@FindBy(id="com.tatadigital.tcp.dev:id/etExpMonth")public MobileElement btnExpmonth;
	@FindBy(id="com.tatadigital.tcp.dev:id/etExpYear")public MobileElement btnExpyear;
	@FindBy(xpath="(//*[@resource-id='com.tatadigital.tcp.dev:id/tvTitleName'])[1]") public MobileElement btnfirstdate;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRowTitle")public MobileElement txtcard;
	@FindBy(xpath="//*[contains(@text,'HDFC')]") public MobileElement txthdfcCard;
	@FindBy(xpath = "//*[@text='Vault']") public MobileElement vaultBtn_navBar_android;	
	@FindBy(xpath = "//*[contains(@text,'Yes')]") public MobileElement btnYesforcancel;	


	//14-7
	@FindBy(xpath="//*[contains(@text,'Payment done')]") public MobileElement paymentDoneUpgradeDTH;
	@FindBy(xpath="//*[contains(@text,'Transaction Id')] | //*[contains(@text,'transaction ID')]") public MobileElement txnIdUpgradeDTH;
	@FindBy(xpath="//*[contains(@text,'Order Date')]") public MobileElement txnDateUpgradeDTH;
	@FindBy(xpath="//*[contains(@text,'View details')] | //*[contains(@text,'Avail now')]") public MobileElement viewDetailsCTA;

	@FindBy(xpath="//*[@text='BOOK A HOLIDAY']") public MobileElement btnBookAholiday;

	

	@FindBy(xpath="//*[@class='android.widget.EditText']") public MobileElement searchButtonHotel;
	@FindBy(xpath="(//*[contains(@text,'Couldn�t found any content for �Lipstick�. Try another search term or explore.')])[2]") public WebElement searchNoItemHotel;
	
	//19-7
	@FindBy(xpath="//*[@text='My Orders']") public MobileElement ordersPageCroma;
	@FindBy(xpath="//*[@text='Cancel']") public MobileElement retryPopUp;

	@FindBy(xpath="//*[@text='Kolkata�s calling']") public WebElement suggestedItemKolkataHotel;
	@FindBy(xpath="//*[@text='Popular searches']") public WebElement popularHotelSearch;
	@FindBy(xpath="//*[@text='Taj']") public WebElement popularHotelSearchTaj;
	
	@FindBy(xpath="//android.widget.TextView[@text='Flights']") public MobileElement flights;
	@FindBy(xpath="//android.webkit.WebView[contains(@text,'AirAsia')]") public MobileElement flightPage;
	@FindBy(xpath="//*[contains(@text,'Fly to')]") public MobileElement destination;
	@FindBy(xpath="//*[@resource-id='basic-url']") public MobileElement destinationTextbox;
	@FindBy(xpath="//android.widget.Button[@resource-id='list-item']") public MobileElement autoSuggesteddest;
	@FindBy(xpath="//android.widget.Image[@text='select']") public MobileElement goArrow;
	@FindBy(xpath="//*[@text='Login']") public MobileElement autoLogin;
	@FindBy(xpath="//*[@resource-id='flight_data']/android.view.View[1]/android.view.View[4]/android.view.View/android.view.View | //*[@resource-id='flight_data']/android.view.View[1]/android.view.View[6]") public MobileElement selectFlight;
	@FindBy(xpath="//android.widget.Button[@text='Continue']") public MobileElement continueflight;
	@FindBy(xpath="//*[contains(@text,'Guest Details')]") public MobileElement guestDetailsBlock;
	@FindBy(xpath="//android.widget.Button[contains(@text,'Save')]") public MobileElement saveDetails;
	@FindBy(xpath="//*[contains(@text,'Edit')]") public MobileElement saved;
	@FindBy(xpath="//*[contains(@text,'Primary Contact')]") public MobileElement primaryContactBlock;
	@FindBy(xpath="//*[contains(@text,'Add-ons')]") public MobileElement addOnsBlock;
	@FindBy(xpath="//*[contains(@text,'Select Seat')]") public MobileElement seatSelectBlock;
	@FindBy(xpath="//android.widget.Button[contains(@text,'Continue To Pay')]") public MobileElement continuetoPay;
	@FindBy(xpath="//*[contains(@text,'Are you sure')]") public MobileElement seatPopup;
	@FindBy(xpath="//*[contains(@text,'Payment')]") public MobileElement paymentBlock;
	@FindBy(xpath="//*[@resource-id='Round Trip']") public MobileElement roundTrip;
	@FindBy(xpath="//*[@resource-id='source']/following-sibling::android.view.View/android.widget.TextView[2] | //*[@resource-id='flight-search-widget-super-div']/android.view.View[5]//android.view.View[3]") public MobileElement locadd;
	@FindBy(xpath="//*[@resource-id='source']/following-sibling::android.view.View/android.widget.TextView[1] | //*[@resource-id='flight-search-widget-super-div']/android.view.View[5]//android.view.View[2]") public MobileElement location;
	@FindAll({@FindBy(xpath="//androidx.viewpager.widget.ViewPager//android.view.ViewGroup/android.view.ViewGroup")}) public List <MobileElement> orderDetail;
	@FindBy(xpath="//*[@text='Pending - transaction initiated']") public MobileElement pendingTxnStatus;
	@FindBy(xpath="//*[@text='My orders']") public MobileElement ordersPageTCP;
	@FindBy(xpath="//*[@text='Payments']/preceding-sibling::android.widget.ImageView") public MobileElement backTPM;
	@FindBy(xpath="//*[contains(lower-case(@text),'cancel this transaction')]") public MobileElement paymentPopup;
	
	//11-8
	//Rainy Day
	@FindBy(xpath="//*[@text='Rainy day offers']") public MobileElement rainyDay_android;
	@FindBy(xpath="//*[@text='Rainy day offers']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement rainyDayWidget_android;
	//Products for healthy living
	@FindBy(xpath="//*[@text='Products for healthy living']") public MobileElement healthyLiving_android;
	@FindBy(xpath="//*[@text='Products for healthy living']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement healthyLivingWidget_android;
	//Grab these Croma exclusives
	@FindBy(xpath="//*[@text='Grab these Croma exclusives']") public MobileElement cromaExclusives_android;
	@FindBy(xpath="//*[@text='Grab these Croma exclusives']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement cromaExclusivesWidget_android;
	//Offers on limited stocks
	@FindBy(xpath="//*[@text='Offers on limited stocks']") public MobileElement limitedStock_android;
	@FindBy(xpath="//*[@text='Offers on limited stocks']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement limitedStockWidget_android;
	//All about smartphones
	@FindBy(xpath="//*[@text='All about smartphones']") public MobileElement aboutSmartphones_android;
	@FindBy(xpath="//*[@text='All about smartphones']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement aboutSmartphonesWidget_android;
	//Monsoon must haves
	@FindBy(xpath="//*[@text='Monsoon must-haves']") public MobileElement Monsoonhaves_android;
	@FindBy(xpath="//*[@text='Monsoon must-haves']/../following-sibling::android.view.View[1]/android.view.View/android.view.View/android.view.View") public MobileElement MonsoonhavesWidget_android;
	//Shoes by sport
	@FindBy(xpath="//*[@text='Shoes by sport']") public MobileElement ShoesSport_android;
	@FindBy(xpath="//*[@text='Shoes by sport']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement shoesSportWidget_android;
	//Fitness gears
	@FindBy(xpath="//*[@text='Fitness gear']") public MobileElement fitnessGear_android;
	@FindBy(xpath="//*[@text='Fitness gear']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement fitnessGearWidget_android;
	//Budget buys
	@FindBy(xpath="//*[@text='Budget buys']") public MobileElement BudgetBuys_android;
	@FindBy(xpath="//*[@text='Budget buys']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement BudgetBuysWidget_android;
	
	@FindBy(xpath="//*[contains(@text,'Guest')]") public MobileElement noOfPassengers;
	@FindBy(xpath="//*[lower-case(@resource-id)='child' and lower-case(@text)='plus']") public MobileElement childIncrease;
	@FindBy(xpath="//*[lower-case(@resource-id)='child' and lower-case(@text)='minus']") public MobileElement childDecrease;
	@FindBy(xpath="//*[lower-case(@resource-id)='infant' and lower-case(@text)='plus']") public MobileElement infantIncrease;
	@FindBy(xpath="//*[lower-case(@resource-id)='infant' and lower-case(@text)='minus']") public MobileElement infantDecrease;
	@FindBy(xpath="//*[lower-case(@resource-id)='child' and lower-case(@text)='minus']/following-sibling::android.view.View/android.view.View") public MobileElement noOfChild;
	@FindBy(xpath="//*[lower-case(@resource-id)='infant' and lower-case(@text)='minus']/following-sibling::android.view.View/android.view.View") public MobileElement noOfInfant;
	@FindBy(xpath="//android.widget.RadioButton[lower-case(@text)='mr']") public MobileElement childSalutation;
	@FindBy(xpath="(//android.widget.EditText)[1]") public MobileElement aaiFirstNameorCliqPin;
	@FindBy(xpath="(//android.widget.EditText)[2]") public MobileElement aaiLastNameorFnameCliq;
	@FindBy(xpath="(//android.widget.EditText)[3]") public MobileElement aaiDOBorLnameCliq;
	@FindBy(xpath="//android.widget.RadioButton[lower-case(@text)='male']") public MobileElement infantGender;
	@FindBy(xpath="//*[lower-case(@text)='done']") public MobileElement donePassenger;
	@FindBy(xpath="//*[contains(lower-case(@text),'add address')]") public MobileElement newAddresscliq;
	@FindBy(xpath="(//android.widget.EditText)[4]") public MobileElement addresscliq;
	@FindBy(xpath="(//android.widget.EditText)[7]") public MobileElement phoneNumCliq;
	
	//16-8
	@FindBy(xpath = "//*[contains(@text,'404 Error page not found')]") public MobileElement ErrorPage_android;
	@FindBy(xpath="//*[@text=\"The page you are looking for can't be found\"] | //*[contains(@text,'Server Error')] | //*[contains(@text,'404 This page does not exist')]") public MobileElement ErrorPDPCliq;
	@FindBy(xpath="(//*[@text='Men�s clothing'])[1]") public MobileElement mensClothing_android;
	
	//19-8
	@FindBy(xpath="//*[contains(@text,'Enrol your Tata Sky')]") public MobileElement enrollPageDTH;
	@FindBy(xpath="//*[contains(@text,'Proceed')]") public MobileElement enrollProccedDTH;
	@FindBy(xpath="//*[contains(@text,'Cancel')] | //*[contains(@text,'CANCEL')]") public MobileElement cancelBtnAxis;
	@FindBy(xpath="//*[contains(@text,'Yes, Cancel')] | //*[contains(@text,'OK')]") public MobileElement cancelBtnConfirmAxis;
	@FindBy(xpath="//*[contains(@text,'Payment unsuccessful')]") public MobileElement paymentFailedStatusDTH;
	

	@FindBy(xpath="//*[@resource-id='Round Trip']/following-sibling::android.view.View[1]//android.view.View[2]") public MobileElement source;
	@FindBy(xpath="//*[@resource-id='start-date-input-button']") public MobileElement dateofTravel;
	@FindBy(xpath="//android.widget.Button[@text='Back']") public MobileElement backtoFlight;


	//25-8
	@FindBy(xpath="//*[@text='Offers from Qmin']/../following-sibling::android.view.View[1]//android.view.View[@index='1']") public MobileElement qminoffers;
	@FindBy(xpath="//*[contains(@text,'ORDER')]") public MobileElement qminOrderNow;
	@FindBy(id="com.tatadigital.qmin:id/tvLocality") public MobileElement qminLocality;
	@FindBy(id="com.tatadigital.qmin:id/etSearchAddress") public MobileElement qminSearchAdd;
	@FindBy(xpath="(//*[@resource-id='com.tatadigital.qmin:id/tvAddressHeadLine'])[4]") public MobileElement qminSerchResult;
	@FindBy(xpath="//*[contains(@text,'Q-Kids')]") public MobileElement qminQkids;
	@FindBy(xpath="(//*[contains(@text,'Q-Kids')])[2]") public MobileElement qminQkids1;
	@FindBy(xpath="(//*[contains(@text,'ADD')])[1]") public MobileElement qminQkidsAdd;
	
	@FindBy(xpath="//*[@class='radio-button']") public WebElement AddressRadioButton;
	@FindBy(xpath="//*[contains(text(),'I Understood')]") public WebElement IUnderstand;
	@FindBy(xpath="//*[contains(@text,'PAY NOW')]") public MobileElement PayNow;
	
	
	
	@FindBy(xpath="//*[contains(lower-case(@text),'aviator') and contains(@text,'100')]") public MobileElement avaitorBanner;
	@FindBy(xpath="//*[contains(lower-case(@text),'total fare')]/following-sibling::android.widget.Image") public MobileElement upArrowTFDetails;
	@FindBy(xpath="//*[contains(lower-case(@text),'aviator')]/following-sibling::android.widget.TextView"
			+ "[contains(lower-case(@text),'discount')]") public MobileElement aviatorDiscountText;
	@FindBy(xpath="//*[contains(lower-case(@text),'down-arrow-icon')]") public MobileElement downArrowTFDetails;
	@FindAll({@FindBy(xpath="//android.widget.RadioButton")}) public List <MobileElement> selectBookedFlight;
	@FindBy(xpath="//android.widget.Button[contains(lower-case(@text),'manage')]") public MobileElement manageCTA;
	@FindBy(xpath="//android.widget.Button[contains(lower-case(@text),'check-in')]") public MobileElement checkInCTA;
	@FindBy(xpath="//android.widget.Button[contains(lower-case(@text),'change')]") public MobileElement changeCTA;
	@FindBy(xpath="//android.widget.Button[contains(lower-case(@text),'add-ons add-ons')]") public MobileElement addOnsCTA;
	@FindBy(xpath="//*[contains(lower-case(@text),'flight details')]") public MobileElement flightDetails;
	@FindBy(xpath="//*[contains(lower-case(@text),'guest details')]") public MobileElement guestDetails;
	@FindBy(xpath="//*[contains(lower-case(@text),'change flight')]") public MobileElement changeFlight;
	@FindBy(xpath="//*[contains(lower-case(@text),'update guests')]") public MobileElement updateGuest;
	@FindBy(xpath="//*[contains(lower-case(@text),'cancel booking')]") public MobileElement cancelBooking;
	@FindBy(xpath="//*[contains(lower-case(@text),'continue to add-ons')]") public MobileElement continuetoAddOns;
	@FindBy(xpath="//*[contains(lower-case(@text),'fare difference')]") public MobileElement fareDiff;
	@FindBy(xpath="//*[contains(lower-case(@text),'add pack')]") public MobileElement addValuePack;
	@FindBy(xpath="//*[contains(@text,'My transactions')]") public MobileElement mytxn_android;
	
	@FindBy(xpath="//*[contains(lower-case(@text),'select passengers')]") public MobileElement selectPassengerSection;
	@FindBy(xpath="(//android.widget.CheckBox)[1]") public MobileElement checkbox;
	@FindBy(xpath="//*[contains(lower-case(@text),'health & contact')]") public MobileElement handddeclarationSection;
	@FindBy(xpath="//*[@resource-id='nationality']") public MobileElement nationality;
	@FindBy(xpath="//*[contains(lower-case(@text),'india')]") public MobileElement valueIndia;
	@FindBy(xpath="//*[@resource-id='address_1']") public MobileElement DestAddress;
	@FindBy(xpath="//*[@resource-id='pincode']") public MobileElement pincode;
	@FindBy(xpath="//*[@resource-id='state']") public MobileElement state;
	@FindBy(xpath="//*[@resource-id='city']") public MobileElement city;
	@FindBy(xpath="//*[contains(lower-case(@text),'3dangerous goods notice')]") public MobileElement dgnsection;
	@FindBy(id="//*[@text='Rainy day offers']") public MobileElement Hmabergermenu;
	@FindBy(xpath="//*[contains(@text,'transactions')]") public MobileElement bynMytransactions;
	@FindBy(xpath="((//*[@resource-id='com.tatadigital.tcp.dev:id/clOrderHistoryItem'])[1]//following::*)[6]") public MobileElement transactionstaustext;
	@FindBy(xpath="//*[@resource-id='spa-root']/android.view.View[2]/android.view.View[2]") public MobileElement roundTripflight;
	
	//Global Search
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/edtSearch']") public MobileElement searchEditBox_android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvSearch'] | //android.widget.ImageView[@content-desc='Search']") public MobileElement searchButtonHomepage_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSectionHeader") public MobileElement searchSectionHeader_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSuggestion") public MobileElement searchItemOptions_android;
	
	
	//1Mg xpaths Android
	
	@FindBy(xpath="//*[contains(@text,'Healthcare')]") public MobileElement healthcare;
	@FindBy(xpath="(//*[contains(@text,'Shop now')])[2]") public MobileElement shopNowButton;
	@FindBy(xpath="//*[contains(lower-case(@text),'order now')]") public MobileElement orderNowButton;
	@FindBy(xpath="//*[contains(@text,'Latest on COVID')]") public MobileElement latestOnCovid;
	@FindBy(xpath="//*[contains(@text,'Offers in Spotlight')]") public MobileElement offersInSpotlight;
	@FindBy(xpath="//*[contains(@text,'101 to good health')]") public MobileElement goodHealth;
	@FindBy(xpath="//*[contains(@text,'Health and immunity')]") public MobileElement healthAndImmunity;
	@FindBy(xpath="//*[contains(lower-case(@text),'good health guide')]") public MobileElement goodHealthGuide;
	@FindBy(xpath="//*[contains(lower-case(@text),'good health guide')]/../following-sibling::android.view.View[1]/"
			+ "android.view.View/android.view.View/android.view.View") public MobileElement goodHealthGuideWidget;
	@FindBy(xpath="//*[contains(lower-case(@text),'latest news')]") public MobileElement latestNews;
	@FindBy(xpath="//*[contains(lower-case(@text),'latest news')]/../following-sibling::android.view.View[1]/"
			+ "android.view.View/android.view.View/android.view.View") public MobileElement latestNewsWidget;
	@FindBy(xpath="//*[contains(lower-case(@text),'holistic wellbeing')]") public MobileElement holisticWellBeing;
	@FindBy(xpath="//*[contains(lower-case(@text),'holistic wellbeing')]/../following-sibling::android.view.View[1]/"
			+ "android.view.View/android.view.View/android.view.View") public MobileElement holisticWellBeingWidget;
	@FindBy(xpath="//android.widget.Button[contains(lower-case(@text),'consult now')]") public MobileElement consultNowCTA;
	@FindBy(xpath="//*[contains(text(),'Order medicines')]") public MobileElement orderMedicines;
	@FindBy(xpath="//*[contains(text(),'Consult a doctor')]") public MobileElement consultADoctor;
	@FindBy(xpath="//*[contains(text(),'Book lab tests')]") public MobileElement bookLabTest;
	@FindBy(xpath="//android.view.View[contains(@content-desc,'1mg')]") public MobileElement oneMgBanner;
	@FindBy(xpath="//android.widget.TextView[contains(lower-case(@text),"
			+ "'consult doctor in 1 click')]") public MobileElement consultDoctor;
	@FindBy(xpath="//android.widget.TextView[contains(lower-case(@text),'fever')]") public MobileElement aliment;
	@FindBy(xpath="//android.widget.TextView[contains(lower-case(@text),'order summary')]") public MobileElement orderSummary;
	@FindBy(xpath="//android.widget.TextView[contains(lower-case(@text),'select a payment method')]") public MobileElement oneMgPaymentPage;
	@FindBy(xpath="//android.widget.TextView[contains(lower-case(@text),'tata pay')] | "
			+ "//android.widget.TextView[contains(lower-case(@text),'tata neu')]") public MobileElement tPayselect;
	@FindBy(xpath="//android.widget.TextView[contains(lower-case(@text),'make payment')]") public MobileElement makePayment;
	@FindBy(xpath="//*[contains(lower-case(@text),'spotlight')]") public MobileElement spotlightOffer;
	@FindBy(xpath="(//*[@text='Offers in spotlight']/ancestor::android.view.View/following-sibling::"
			+ "android.view.View[2]//android.view.View)[3]") public MobileElement spotlightOfferWidget;
	@FindBy(xpath="//*[contains(lower-case(@text),'offer of the day')]") public MobileElement offerDay;
	@FindBy(xpath="//*[contains(lower-case(@text),'offer of the day')]/following-sibling::android.view.View[2]"
			+ "/android.view.View/android.view.View/android.view.View") public MobileElement offerDayWidget;
	@FindBy(xpath="//*[contains(lower-case(@text),'buy again')]") public MobileElement buyAgain;
	@FindBy(xpath="//*[contains(lower-case(@text),'buy again')]/following-sibling::android.view.View[2]"
			+ "/android.view.View/android.view.View/android.view.View") public MobileElement buyAgainWidget;
	@FindBy(xpath="//*[contains(lower-case(@text),'order medicines')]") public MobileElement orderMeds;
	@FindBy(xpath="//*[contains(lower-case(@text),'consult a doctor')]") public MobileElement consultDoc;
	@FindBy(xpath="//*[contains(lower-case(@text),'book lab tests')]") public MobileElement labTest;
	@FindBy(xpath="//*[@resource-id='update-city-modal']") public MobileElement updateCity;
	@FindBy(xpath="//*[lower-case(@text)='cancel']") public MobileElement cancel;
	@FindBy(xpath="//*[@resource-id='srchBarShwInfo']") public MobileElement searchBar;
	@FindAll({@FindBy(xpath="//*[lower-case(@text)='add'] | //*[lower-case(@text)='add to cart']")}) public List <MobileElement> addproduct;
	@FindBy(xpath="//*[contains(lower-case(@text),'my cart')]") public MobileElement myCartPage;
	@FindAll({@FindBy(xpath="//*[contains(lower-case(@content-desc),'menu')]")}) public List <MobileElement> chooseAddress;
	@FindBy(xpath="//*[contains(lower-case(@content-desc),'add new address')]") public MobileElement addressPage;
	@FindBy(xpath="//*[contains(lower-case(@content-desc),'continue')]") public MobileElement continueto;
	@FindBy(xpath="//*[contains(lower-case(@text),'choose delivery')]") public MobileElement deliveryPage;
	//btnProceedtopay
	
	
	
	
	
	//MTP 2.0
	@FindBy(id="com.tatadigital.tcp.dev:id/tvCardPayment") public MobileElement creditdebitCardOption;
	@FindBy(id="com.tatadigital.tcp.dev:id/tataPayUPI") public MobileElement upiOption;
	@FindBy(id="com.tatadigital.tcp.dev:id/rbOtherPaymentModes") public MobileElement Othermodes;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/edPCvv']") public MobileElement cvvCode;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRefId") public MobileElement txnID;
	
	@FindBy(xpath="//*[@id='loginsignup-address-change-button']") public MobileElement bbUnservicableOK;
	@FindAll({@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/imgBackground']")}) public List <MobileElement> homepageHeroBanner;
	@FindBy(xpath="//*[@text='Shop now'] | //*[@text='Book now'] | //*[@text='Order now']") public MobileElement herobannerStoriesCTA;
	@FindBy(xpath="//android.widget.TextView[@text='Smartphones'] | //android.widget.ImageView[@content-desc='Smartphones']") public MobileElement smartphones;
	@FindBy(xpath="//android.widget.TextView[@text='Smartphones']/following-sibling::android.widget.Image[1]") public MobileElement smartphonesSearch;
	@FindBy(xpath="//android.widget.TextView[@text='Smartphones']/following-sibling::android.widget.Image[2]") public MobileElement smartphonesCart;
	@FindBy(xpath="//android.view.View[@content-desc='Westside']") public MobileElement WestsideIcon_android;
	@FindBy(xpath="//android.view.View[@content-desc='Menu Mobile Icon']") public MobileElement Westsidemenu_android;
	@FindBy(xpath="//*[contains(@text,'Hi ')]") public MobileElement WestsideUserLogin_android;
	@FindBy(xpath="//*[contains(@text,'Login')]") public MobileElement bbUserNotLogin_android;
	@FindBy(xpath="//android.widget.TextView[@text='Payment']") public MobileElement mtp_android;
	
	//Smartphones
	@FindBy(xpath = "//*[@text='Shop by price']") public MobileElement shopPrice_android;
	@FindAll({@FindBy(xpath="//*[@text='Shop by price']//following-sibling::android.view.View[1]/android.view.View/android.view.View/android.view.View")}) public List<MobileElement> shopPricelistAnd;
	@FindAll({@FindBy(xpath="//*[@text='Shop by category']//following-sibling::android.view.View[1]/android.view.View/android.view.View/android.view.View")}) public List<MobileElement> shopCatlistAnd;
	@FindAll({@FindBy(xpath="//android.widget.Button[@text='size']")}) public List<MobileElement> sizeListCliq;
	
	@FindBy(xpath = "//*[@text='Exclusive offers']") public MobileElement exclusiveOffer_android;
	@FindAll({@FindBy(xpath="//android.widget.ImageView[@content-desc='Description']")}) public List<MobileElement> exclusiveOfferList;
	@FindBy(xpath = "//*[@text='Unlimited deals on grocery + 15% NeuCoins']") public MobileElement unlimitedDeals_android;
	@FindAll({@FindBy(xpath="//*[@text='Unlimited deals on grocery + 15% NeuCoins']/..//*[@resource-id='com.tatadigital.tcp:id/iv_newLaunchesImage']")}) public List<MobileElement> unlimitedDealsList;
	@FindBy(xpath="//*[@text='Skip offer']") public MobileElement offerSkip;
	
	//All widget redirection
	@FindAll({@FindBy(xpath="//*[@resource-id='spa-root']/android.view.View/android.view.View/android.view.View//android.widget.Image/following-sibling::android.widget.TextView | //*[@resource-id='spa-root']/android.view.View/android.view.View/android.view.View//android.widget.Image/../following-sibling::android.widget.TextView")}) public List<MobileElement> textViewHeaderWidget1;
	@FindAll({@FindBy(xpath="//*[@resource-id='spa-root']/android.view.View/android.widget.TextView/following-sibling::android.view.View/android.view.View/android.view.View/android.view.View")}) public List<MobileElement> textViewHeaderWidget2;
	@FindAll({@FindBy(xpath="//*[contains(@resource-id,'componentSix')]/following-sibling::android.view.View//android.view.View[contains(@text,'card')]")}) public List<MobileElement> componentContainer;
	@FindAll({@FindBy(xpath="//*[@resource-id='spa-root']/android.view.View/android.view.View/android.view.View//android.widget.Image")}) public List<MobileElement> imgViewHeaderWidget1;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/bottomNav']") public MobileElement bottomNavBar;
	@FindBy(xpath="//*[@resource-id='urlID']/../android.widget.Image") public MobileElement videoCloseButton;
	@FindAll({@FindBy(xpath="//*[contains(@resource-id,'Title')]")}) public List<MobileElement> titleHomepage;
	@FindBy(xpath="//android.widget.ImageView[@resource-id='com.tatadigital.tcp:id/imgBackground']") public MobileElement CDPHeroBannerImage;
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.tatadigital.tcp:id/txtTitle']") public MobileElement CDPHeroBannerText;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/ivClose']") public MobileElement closeButton;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/negativeButton'] | //*[@resource-id='com.tatadigital.tcp.dev:id/negativeButton']") public MobileElement negativeButton_android;
	@FindAll({@FindBy(xpath="(//*[contains(@resource-id,'componentSix')]/following-sibling::android.view.View)[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")}) public List<MobileElement> componentContainerView;
	@FindBy(xpath="//*[@resource-id='spa-root']/android.view.View/android.widget.TextView/following-sibling::android.widget.Button") public MobileElement nudgeCTA;
	@FindBy(xpath="//*[@resource-id='spa-root']/android.view.View/android.widget.Button/preceding-sibling::android.widget.TextView") public MobileElement nudgeTextView;
	@FindAll({@FindBy(xpath="//*[@resource-id='spa-root']/android.view.View/android.view.View/android.widget.TextView/following-sibling::android.view.View/android.view.View/android.view.View/android.view.View")}) public List<MobileElement> textView2;

	@FindBy(xpath = "//*[@text='F&B']") public MobileElement FandBHome_android;
	@FindAll({@FindBy(xpath="//*[contains(@resource-id,'componentSix')]/following-sibling::android.view.View//android.view.View/android.view.View/android.view.View")}) public List<MobileElement> component2Container;
	@FindBy(xpath = "//android.widget.EditText[@resource-id='urlID']") public MobileElement videoWidgetIdentifier;
	@FindBy(xpath = "(//android.widget.Image)[1]") public MobileElement closeVideo;
	@FindBy(xpath="//android.widget.TextView[@text='Trending Now']//following-sibling::android.widget.ListView//android.view.View") public MobileElement searchTrendingProduct;
	@FindBy(xpath = "//android.view.View[@content-desc='searchIcon']/following-sibling::android.widget.Button|//android.view.View[@content-desc='Basket']/android.widget.TextView|//*[@resource-id='loginActive']//following::android.view.View[1]/android.view.View[1] | //android.view.View[@content-desc='searchIcon']")
	public MobileElement brandPageIcon;
	@FindBy(xpath="//*[contains(@text,'Qmin')]") public MobileElement qminPage;
	@FindBy(xpath="//*[contains(@text,'Hello')]//following-sibling::android.widget.TextView") public MobileElement qminAutoLogin;
	@FindBy(xpath="//*[contains(@text,'Basket')]/preceding-sibling::android.widget.TextView[1]") public MobileElement basketPageMenu;
	@FindAll({@FindBy(xpath="//*[contains(@resource-id,'componentSix')]/android.widget.TextView")}) public List<MobileElement> componentContainerTitle;
	@FindAll({@FindBy(xpath="//*[@resource-id='spa-root']/android.view.View/android.widget.TextView/following-sibling::android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")}) public List<MobileElement> textViewHeaderWidget3;
	@FindBy(xpath="//*[@text='NeuMag'] | //*[@resource-id='com.tatadigital.tcp:id/toolbarTitleTextView'] | //*[@resource-id='com.tatadigital.tcp:id/tvOfferZoneTitle'] | //*[@resource-id='com.tatadigital.tcp:id/tvProductName'] | //*[contains(@resource-id,'backdirectionMob')]") public MobileElement tcpPages;
	@FindBy(xpath="//*[@resource-id='search-option-0']") public MobileElement searchOption;
	
	//Westside
	@FindBy(xpath="//*[@text='Shop Westside by category']") public MobileElement westsideCategory;
	@FindBy(xpath="//*[@text='Shop Westside by category']/following-sibling::*//*[@resource-id='0']") public MobileElement westsideCategoryTile;
	@FindBy(xpath="//android.widget.EditText[contains(@resource-id,'search')]") public MobileElement searchEditBoxWestside_android;
	@FindBy(xpath="//*[@text='Products']") public MobileElement productWS_android;
	@FindBy(xpath="//android.view.View[@content-desc='X']") public MobileElement crossX_android;
	@FindBy(xpath="//*[@resource-id='pincode_input']") public MobileElement pincodeWS_android;
	@FindBy(xpath="//*[@resource-id='check-delivery-submit']") public MobileElement pincodeCheckWS_android;
	@FindBy(xpath="//*[@resource-id='product-add-to-cart']") public MobileElement addCartWS_android;
	@FindBy(xpath="//*[contains(@resource-id,'ProductSection')]/preceding-sibling::*") public MobileElement cartWS_android;
	@FindBy(xpath="//*[@resource-id='checkout_button_custom']") public MobileElement proceedCheckout_android;
	@FindBy(xpath="//*[@resource-id='continue_to_shipping_button_custom']") public MobileElement continueShipping_android;
	@FindBy(xpath="//*[@resource-id='continue_button']") public MobileElement continuePayment_android;
	@FindBy(xpath="//*[@text='Complete Order']") public MobileElement completeOrder_android;
	
	@FindAll({@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/rvCircleIndicator']/android.view.View")}) public List <MobileElement> homepageHeroBannerDots;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp:id/scl2MainLayout']/android.widget.ImageView") public MobileElement homeHeroBannerImage;
	@FindBy(xpath="//*[@resource-id='header']/android.widget.Button") public MobileElement luxuryProfileIcon;
	@FindBy(xpath="//*[@text='MY ACCOUNT']") public MobileElement luxuryMyAccount;
	
	//SLP IPL
	@FindBy(xpath="//android.widget.ImageView[@content-desc='TATA IPL']") public MobileElement iplIconHomepage;
	@FindBy(xpath="//android.view.View[@content-desc='TATA IPL']") public MobileElement iplHeader;
	@FindBy(xpath="//android.widget.Button[@content-desc='Back']") public MobileElement iplBack;
	@FindBy(xpath="(//android.view.View[@content-desc='TATA IPL']/../following-sibling::android.view.View//android.widget.ImageView)[1]") public MobileElement iplBanner;
	
	@FindBy(xpath="(//android.view.View[@content-desc='TATA IPL']/../following-sibling::android.view.View//android.widget.ImageView)[3]") public MobileElement iplInstagramCard;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"India's most iconic stadiums\"]") public MobileElement iplCities;
	@FindAll({@FindBy(xpath="(//android.view.View[@content-desc=\"India's most iconic stadiums\"]/following-sibling::android.widget.HorizontalScrollView)[1]//android.widget.ImageView")}) public List <MobileElement> iplCitiesWidgets;
	
	@FindBy(xpath="//android.view.View[@content-desc='Did you know?']") public MobileElement didYouKnow;
	@FindBy(xpath="(//android.view.View[@content-desc='Did you know?']/following-sibling::android.view.View)[1]") public MobileElement didYouKnowContent;
	@FindBy(xpath="(//android.view.View[@content-desc='Did you know?']/following-sibling::android.widget.ImageView)[2]") public MobileElement didYouKnowShareCTA;
	@FindBy(xpath="//*[@text='SHARE'] | //*[@text='Share']") public MobileElement shareOption;
	
	@FindBy(xpath="//android.view.View[@content-desc='Ultimate guide to TATA IPL']") public MobileElement ultimateGuide;
	@FindBy(xpath="(//android.view.View[@content-desc='Ultimate guide to TATA IPL']/following-sibling::android.widget.ImageView)[1]") public MobileElement ultimateGuideNavArrow;
	@FindAll({@FindBy(xpath="(//android.view.View[@content-desc='Ultimate guide to TATA IPL']/following-sibling::android.widget.HorizontalScrollView)[1]//android.widget.ImageView")}) public List <MobileElement> ultimateGuideWidgets;
	
	@FindBy(xpath="//android.view.View[@content-desc='Electronics Flash sale']") public MobileElement electronicsFlashSale;
	@FindBy(xpath="(//android.view.View[@content-desc='Electronics Flash sale']/following-sibling::android.widget.ImageView)[1]") public MobileElement electronicsFlashSaleNavArrow;
	@FindAll({@FindBy(xpath="((//android.view.View[@content-desc='Electronics Flash sale']/following-sibling::android.view.View)[1])/android.view.View//android.view.View")}) public List <MobileElement> electronicsFlashSaleWidgets;
	
	@FindBy(xpath = "(//android.widget.TextView)[2]") public MobileElement offerDPTitle_android;
	@FindBy(xpath = "//*[@resource-id='backdirectionMob2']//android.widget.Image") public MobileElement offerDPBackButton_android;
}
