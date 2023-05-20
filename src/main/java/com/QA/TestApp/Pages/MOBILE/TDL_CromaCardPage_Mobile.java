package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_CromaCardPage_Mobile {

	public TDL_CromaCardPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define android locators
	 * 
	 */
	@FindBy(xpath = "//*[@text='Croma']")
	public MobileElement cardNameText_Croma_android;

	@FindBy(xpath = "//*[@text='Activities']")
	public MobileElement activityTab_Croma_android;

	@FindBy(xpath = "//*[@text='My benefits']")
	public MobileElement myBenefitsTab_Croma_android;

	@FindBy(xpath = "//*[@text='Shop Now']")
	public MobileElement shopNowCTA_Croma_android;

	@FindBy(xpath = "//*[@id='com.tatadigital.tcp.dev:id/cancelButtonImageView'] | //*[@resource-id='modal-close-button']")
	public MobileElement closeBtn_Croma_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/transactionInfoViewPager")
	public MobileElement scrollableSectionUnderTabId_Croma_android;
	
	@FindBy(className = "androidx.viewpager.widget.ViewPager")
	public MobileElement scrollableSectionUnderTabClass_Croma_android;

	   @FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionTotalAmount")
	    public List<MobileElement> pointsActivity_Croma_android;
	   
	    @FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionPartnerName")
	    public List<MobileElement> transcDesc_Croma_android;
	    
	    @FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionDate")
	    public List<MobileElement> transcDate_Croma_android;


	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Croma']")
	public MobileElement cardNameText_Croma_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Activity']")
	public MobileElement activityTab_Croma_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='My Benefits']")
	public MobileElement myBenefitsTab_Croma_ios;

	@FindBy(xpath = "//*[@label='Shop Now']")
	public MobileElement shopNowCTA_Croma_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='loyalty.vault.close']")
	public MobileElement closeBtn_Croma_ios;
	
	@FindBy(xpath = "//*[@label='Croma']")
	public MobileElement cardNameText_ios;

	@FindBy(xpath = "//*[@label='Activity']")
	public MobileElement activityTab_ios;

	@FindBy(xpath = "//*[@label='My Benefits']")
	public MobileElement myBenefitsTab_ios;

	@FindBy(xpath = "//*[@label='Shop Now']")
	public MobileElement shopNowCTA_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='loyalty.vault.close']")
	public MobileElement closeBtn_ios;
	
	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"TCP Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView")
	public MobileElement scrollableSectionUnderTab_Croma_ios;

	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"TCP SIT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[2]")
	public List<MobileElement> pointsActivity_Croma_ios;

	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"TCP SIT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
	public List<MobileElement> transcDesc_Croma_ios;
	
	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"TCP SIT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[3]")
	public List<MobileElement> transcDate_Croma_ios;

	/*
	 * =================================================================================================================================================
	 * SIT-R2 CYCLE-1 
	 * ===========================================================================================================================================
	 */
	//07 Apr R & B Croma
	@FindBy(xpath = "//*[@text='Croma']")
	public MobileElement cardName_Croma_android;

	@FindBy(xpath = "//*[@text='IHCL']")
	public MobileElement cardName_IHCL_android;
	
	@FindBy(xpath="//*[@text='TataNeu']")public MobileElement uLogo;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUserRewards")public MobileElement uRewards;
	//*[@resource-id='com.tatadigital.tcp.dev:id/tvUserPoints']
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUserPoints")public MobileElement uPoints;
	
	@FindBy(xpath="//*[@text='Rewards']/preceding-sibling::*")public MobileElement back_button;
	
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/crossIv']")public MobileElement offerCloseaftersignIn;
	@FindBy(xpath="//*[@text='Allow']")public MobileElement allowBtn;
	
	@FindBy(xpath = "//*[@resource-id='modal-close-button']")
	public MobileElement closeBtnCardPage;
	
	@FindBy(xpath = "//android.widget.Button[@text='Shop now']")
	public MobileElement shopNowBtn;
	
	@FindBy(xpath = "//*[@resource-id='loginActive']/following::android.widget.TextView[1] | //*[@resource-id='loginActive']") public MobileElement Loged_android;
	
	@FindBy(xpath = "//*[@resource-id='search']")
	public MobileElement searchField;
	
	@FindBy(xpath = "//*[@resource-id='search']/preceding::android.view.View[1]")
	public MobileElement searchBtn;
	@FindBy(xpath = "//*[@resource-id='search-option-0']")
	public MobileElement searchOptionFirst;
	
	@FindBy(xpath = "//*[contains(@text,'BUY NOW')]") 
	public MobileElement buyNowBtn;
	
	@FindBy(xpath = "//*[contains(@text,'CHECKOUT')]") 
	public MobileElement checkoutAnd;
	
	@FindBy(xpath = "//*[contains(@text,'Total price')]//following::android.view.View[1]") 
	public MobileElement totalPrice;
	
	@FindBy(xpath = "//*[contains(@text,'SELECT PAYMENT')] | //*[@text='SELECT PAYMENT'] | //*[contains(text(),'select payment')]") 
	public MobileElement selectPaymentBtn;
	
	//R&B Page android
	@FindBy(xpath = "//*[contains(@text,'Mass')]") 
	public MobileElement massSegment;
	
	@FindBy(xpath = "//*[@text='U Rewards']/following::android.widget.Image") 
	public MobileElement pointsRBpage;
	//*[@text='//android.view.View[@content-desc='Your brands']/android.widget.TextView'] 
	//android.widget.TabWidget/child::android.view.View[2]
	@FindBy(xpath = "//android.view.View[contains(@text,'Your Brands')] | //android.widget.TabWidget/child::android.view.View[2]") 
	public MobileElement yourBrandsTab;
	
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'For you')]") 
	public MobileElement forYouBtn;
	
	//*[@text='U Rewards']/following::android.widget.TextView[1]
	
	@FindBy(xpath = "//*[contains(@text,'What your points can buy')]") 
	public MobileElement pointsProductWidget;
	
	@FindBy(xpath = "//*[contains(@text,'What your points can buy')]//following::android.view.View[10]") 
	public MobileElement priceOfProductByPoints;
	
	@FindBy(xpath = "//*[contains(@text,'What your points can buy')]//following::android.view.View[9] | //*[@text='Exclusive Stories']/following::android.view.View[5]") 
	public MobileElement descProductByPoints;
	
	@FindBy(xpath = "//*[contains(@text,'By Invitation')]") 
	public MobileElement byInvitationOnlyWidget;
	
	@FindBy(xpath = "//*[contains(@text,'By Invitation')]//following::android.view.View[5]") 
	public MobileElement descOfProductbyInvitationOnlyWidget;
	
	@FindBy(xpath = "//*[contains(@text,'Offers you')]") 
	public MobileElement indulgeWidget;
	//*[@text='TCP Rewards Program']
	
	//=====================================================
	//R&B Page Validation
	
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Rewards']/android.widget.ImageView") 
	public MobileElement rewardsBottomNavigator;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']") 
	public MobileElement navigateUp;
	
	@FindBy(xpath = "//*[@text='TCP Rewards Program']") 
	public MobileElement rewardsNudge;
	
	//android.widget.Button[@text='Know more']
	@FindBy(xpath = "//android.widget.Button[@text='Know more']") 
	public MobileElement rewardsNudgeCTA;
	
	@FindBy(xpath = "//*[contains(@text,'Welcome to a')]") 
	public MobileElement rewardsNudgePage;
	
	@FindBy(xpath = "//*[contains(@text,'Welcome')]") 
	public MobileElement welcomeMsg;
	
	//*[contains(@text,'Welcome')]/following-sibling::android.widget.TextView[1]
	@FindBy(xpath = "(//*[@resource-id='vault-container']//child::android.view.View)[2]") 
	public MobileElement userFirstName;
	
	@FindBy(xpath = "//*[@text='Your badges']") 
	public MobileElement yourBrandsSection;
	
	
	@FindBy(xpath = "//*[contains(@text,'Stories for you')]") 
	public MobileElement exclusiveStoriesWidget;
	@FindBy(xpath = "//*[contains(@text,'Explore your privileges')]") 
	public MobileElement exploreYourPrivilegesHdr;
	@FindBy(xpath = "//*[contains(@text,'Explore your privileges')]/following::android.view.View[3]") 
	public MobileElement exploreYourPrivileges_desc1;
	
	@FindBy(xpath = "//*[contains(@text,'Member exclusives')]") 
	public MobileElement memberExclusivesHdr;
	@FindBy(xpath = "//*[contains(@text,'Member exclusives')]/following-sibling::android.view.View[1]") 
	public MobileElement memberExclusivesSubHdr;
	@FindBy(xpath = "(//android.widget.Button[contains(@text,'Shop now')])[1]") 
	public MobileElement memberExclusivesShopNowBtn;
	@FindBy(xpath = "(//android.widget.Button[@text='Shop now']/preceding::android.widget.TextView[1])[1]") 
	public MobileElement memberExclusivesOffer1;
	
	@FindBy(xpath = "//*[contains(@text,'Get rewarded in many ways')]") 
	public MobileElement getRewardedInManyWaysHdr;
	@FindBy(xpath = "//*[contains(@text,'Get rewarded in many ways')]/following-sibling::android.view.View[1]") 
	public MobileElement getRewardedInManyWaysSubHdr;
	@FindBy(xpath = "(//android.widget.Button[contains(@text,'now')])[1]") 
	public MobileElement getRewardedInManyWaysShopNowBtn;
	@FindBy(xpath = "(//android.widget.Button[contains(@text,'now')])[1]/preceding::android.view.View[1]") 
	public MobileElement getRewardedInManyWaysOffer1;
	
	
	//android.widget.Button[@text='Shop now']/preceding::android.widget.TextView[1]
	
	@FindBy(xpath = "//*[@resource-id='spa-root']//following::android.view.View[contains(@text,'Brands and More')]") 
	public MobileElement brandsAndMoreWidget;
	
	@FindBy(xpath = "//*[contains(@text,'Offers you')]/following::android.view.View[6]") 
	public MobileElement indulge_desc1;
	
	@FindBy(xpath = "//*[@text='Croma Logo']") 
	public MobileElement indulge_Opened;
	@FindBy(xpath = "//*[contains(@text,'Select stories for you')]/following::android.view.View[3]") 
	public MobileElement exclusiveStoriesWidget_desc1;
	@FindBy(xpath = "//*[@text='bookmarkIcon']") 
	public MobileElement exclusiveStories_Opened;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Croma Logo']") 
	public MobileElement croma_logo;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.tatadigital.tcp.dev:id/tvUserPoints']") 
	public MobileElement init_points;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.tatadigital.tcp.dev:id/tvTcppointBalance']") 
	public MobileElement paymentpage_points;
	
	
	
	
	
	//TCP HomePage points ios
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.home.valutButton']//following::XCUIElementTypeButton[1]") 
	public MobileElement upoints_ios;
	
	//R&B Page Ios
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Mass']") 
	public MobileElement massSegment_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='points']//preceding::XCUIElementTypeStaticText[1]") 
	public MobileElement pointsRBpage_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='What your points can buy']") 
	public MobileElement pointsProductWidget_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Exclusive Stories']/following::	\r\n"
			+ "XCUIElementTypeStaticText[1]") 
	public MobileElement descProductByPoints_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='By Invitation Only']") 
	public MobileElement byInvitationOnlyWidget_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='By Invitation Only']//following::XCUIElementTypeStaticText[4]") 
	public MobileElement descOfProductbyInvitationOnlyWidget_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Indulge']") 
	public MobileElement indulgeWidget_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Exclusive Stories']") 
	public MobileElement exclusiveStoriesWidget_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Brands and More']") 
	public MobileElement brandsAndMore_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Most Viewed']") 
	public MobileElement mostViewedWidget_ios;
	
	
	
	//U Rewards Page android
	@FindBy(xpath = "//*[contains(@text,'Your brands')]") 
	public MobileElement URewardsPageHeader;
	@FindBy(xpath = "//*[contains(@text,'U Rewards')]//preceding::android.view.View[1]") 
	public MobileElement URewardsPageBackBtn;
	@FindBy(xpath = "//*[contains(@text,'NeuCoins')]") 
	public MobileElement uPointsCardLabel;
	@FindBy(xpath = "//*[contains(@text,'NeuCoins Balance')]//following::android.view.View[1]") 
	public MobileElement uPointsCardCurrentPoints;
	@FindBy(xpath = "//*[contains(@text,'expiring')]//following::android.view.View[1]") 
	public MobileElement uPointsCardExpiry;
	
	
	//SLP Electronics TCP Page
	@FindBy(xpath = "//*[@resource-id='spa-root']//following::android.widget.Button[contains(@text,'Shop')]") 
	public MobileElement shopNowBtnSLPElectronics;
	
	//U Rewards Page ios
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='U Rewards']") 
	public MobileElement URewardsPageHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='U Points']") 
	public MobileElement uPointsCardLabel_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='POINT STATUS']//following::XCUIElementTypeStaticText[1]") 
	public MobileElement uPointsCardCurrentPoints_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='POINTS EXPIRING']//following::XCUIElementTypeStaticText[1]") 
	public MobileElement uPointsCardExpiry_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Croma']")
	public MobileElement cardName_Croma_ios;
	
	//TCP Payment Details Page
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvTransactionId']") 
	public MobileElement transactionID;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvHeader']") 
	public MobileElement payMmentDetailsHdr;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvUPICardAmount']") 
	public MobileElement cardAmtPaidTxt;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvUPIAmount") 
	public MobileElement upiAmtPaidTxt;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvNetBankingAmount']") 
	public MobileElement trannetBankingAmtPaidTxt;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvTcpPoints']") 
	public MobileElement tcpPointsPaidTxt;
	
	@FindBy(xpath = "//*[@text='TOTAL']/following-sibling::*']") 
	public MobileElement totalAmtPaidTxt;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/imCloseIcon']") 
	public MobileElement paymentDetailsPageCloseBtn;
	
	//TCP Card Trasaction Details
	@FindBy(xpath = "//*[@text='U Points']") 
	public MobileElement tcpCardPointsHdrExpanded;
	
	@FindBy(xpath = "//*[@text='Schedule']") 
	public MobileElement tcppointsScheduleTab;
	
	@FindBy(xpath = "//*[@text='Activities']") 
	public MobileElement tcpActivityTab;
	@FindBy(xpath = "//*[@text='Points schedule']") 
	public MobileElement pointsScheduleTab;
	
	@FindBy(xpath = "//*[@resource-id='modal-close-button']") 
	public MobileElement tcpCardCloseBtn;
	
//	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tvTransactionPartnerName'])[1]") 
//	public MobileElement preprodCromaOnlineStoreLbl;
//	
//	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tvTransactionTotalAmount'])[1]") 
//	public MobileElement pointsEarned;
//	
//	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tvTransactionDate'])[1]") 
//	public MobileElement transactionDate;
//	
//	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tvTransactionStatus'])[1]") 
//	public MobileElement transactionStatus;
	@FindBy(xpath = "(//android.widget.RadioButton[@resource-id='com.tatadigital.tcp.dev:id/rbCardSelect'])[1]") public MobileElement creditcard;
	@FindBy(xpath = "(//android.widget.RadioButton[@resource-id='com.tatadigital.tcp.dev:id/rbCardSelect'])[2]") public MobileElement debitcard;
	@FindBy(id = "com.tatadigital.tcp.dev:id/positiveButton")
    public MobileElement changePaymentYesBtn;
	
	@FindBy(xpath= "(//*[@text='Enter CVV'])[2]") public MobileElement cvvCode_android;
	
	@FindBy(xpath = "//*[@text='Activities']")
	public MobileElement pointsActivity_android;
    // TCP Card 
	@FindBy(xpath = "//*[@text='Activities']/following::android.widget.TextView[2] | //*[@text='Activities']/following::android.view.View[6]")
	public MobileElement transcDesc_android;
	
	@FindBy(xpath = "//*[@text='Activities']/following::android.widget.TextView[4] | //*[@text='Activities']/following::android.view.View[7]")
	public MobileElement transcDate_android;
	
	@FindBy(xpath = "//*[@text='Activities']/following::android.widget.TextView[3] | //*[@text='Activities']/following::android.view.View[13]")
	public MobileElement pointsearned_Croma_android;
	@FindBy(xpath = "//*[@text='Activities']/following::android.view.View[8]")
	public MobileElement promotionalPointsearned_android;
	
	// Brand Card
	@FindBy(xpath = "//*[@text='Activities']/following::android.view.View[6]")
	public MobileElement transcDescBrandCard;
	
	@FindBy(xpath = "//*[@text='Activities']/following::android.view.View[7]")
	public MobileElement transcDateBrandCard;
	
	@FindBy(xpath = "//*[@text='Activities']/following::android.view.View[8]")
	public MobileElement transactionAmountBrandCard;
	
	@FindBy(xpath = "//*[@text='Activities']/following::android.view.View[8]")
	public MobileElement transstatus_Croma_android;
	
	@FindBy(xpath = "//*[contains(@text,'CHECKOUT')]/following::android.widget.TextView[2]")
	public MobileElement checkout_invoice_amount_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/orderId")
	public MobileElement orderid_invoice_android;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnApprove")
	public MobileElement paybtn_invoice_android;

	@FindBy(xpath = "//*[@text='Tata CLiQ']")
	public MobileElement cardName_Cliq_android;
	
	@FindBy(xpath = "//*[@text='All badges']")
	public MobileElement alltiers_android;
	@FindBy(xpath = "//*[@text='Membership']")
	public MobileElement membershipBBCardTab_android;
	
	@FindBy(xpath = "//*[@text='Privileges']")
	public MobileElement mybenefits_android;
	
	@FindBy(xpath = "//*[@resource-id='continueShopping'] | //*[@text='CONTINUE SHOPPING']")
	public MobileElement continue_shopping_cliq_android;
	
	@FindBy(xpath = "(//*[contains(@text,'TCP Points')]/following::android.view.View[5])[2]")
	public MobileElement points_switch_cliq_android;
	
	@FindBy(xpath = "//*[contains(@text,'Edit Points')]")
	public MobileElement tcp_points_edit_cliq_android;
	
	@FindBy(xpath = "//*[contains(@text,'Edit Points')] | //input[@class='LpPartialRedemption__materialFieldInput ']")
	public MobileElement tcp_points_amount_cliq_android;
	
	@FindBy(xpath = "//*[@text='Offers']/following::android.view.View[13]")
	public MobileElement HeroBanCTA_android;
	
	@FindBy(xpath="(//android.widget.Button[@text='size'])[4]") public MobileElement sizeCliq_android;
	
	@FindAll({@FindBy(xpath="(//*[@text='Offers']/following::android.view.View[13])/following::android.view.View")}) public List <MobileElement> HeroBannDotAndroid;
	@FindBy(xpath = "((//*[@resource-id='spa-root']//android.widget.ListView//preceding-sibling::android.view.View)[1]//android.view.View)[6]") public MobileElement HeroBanTitle_android;
	@FindBy(xpath = "((//*[@resource-id='spa-root']//android.widget.ListView//preceding-sibling::android.view.View)[1]//android.view.View)[7]") public MobileElement HeroBanDesc_android;

	
	@FindBy(xpath = "(//*[contains(@text,'EXPIRING')]/following::*)[2]")
	public MobileElement viewDetailsCTA_TCP;
	
	@FindBy(xpath = "//android.widget.Button[contains(@text,'Chat')]")
	public MobileElement chat_with_us;
	
	@FindBy(xpath = "//*[contains(@text,'Hi')]")
	public MobileElement customer_name;
	
	@FindBy(xpath = "(//*[@text='Make Payment']/following::android.widget.EditText)[6]")
	public MobileElement upi_icon_cliq;
	
	@FindBy(xpath = "//*[contains(@content-desc,'How')]/following::android.widget.EditText")
	public MobileElement upi_id_enter_cliq;
	
	@FindBy(xpath = "//*[@text='Verify']")
	public MobileElement verify_upi_cliq;
	
	@FindBy(xpath = "(//*[contains(@text,'UPI ID')])[1]")
	public MobileElement upi_click_cliq;
	
	@FindBy(xpath = "(//*[contains(@text,'EMI')])[1]")
	public MobileElement emi_click_cliq;
	
	@FindBy(xpath = "(//*[contains(@text,'EMI')])[2]")
	public MobileElement nocostemi_click_cliq;
	
	@FindBy(xpath = "//*[contains(@text,'ICICI Bank')]")
	public MobileElement icici_click_cliq;
	
	@FindBy(xpath = "//*[contains(@text,'Select this plan')]")
	public MobileElement select_plan_emi_cliq;
	
	@FindBy(xpath = "//*[@text='IHCL']")
	public MobileElement cardName_Ihcl_android;
	
	@FindBy(xpath = "//*[@text='Electronics']")
	public MobileElement SLPCroma_android;
	@FindBy(xpath = "//*[@text='Hotel']")
	public MobileElement SLPIhcl_android;
	
	@FindBy(xpath = "//*[@text='AirAsia']")
	public MobileElement cardName_airasia_android;
	
	@FindBy(xpath = "//*[@text='Flights']")
	public MobileElement SLPAirasia_android;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Logo']/android.widget.Image")
	public MobileElement AirasiaPage_android;
	
	@FindBy(xpath = "//*[@text='Big Basket']")
	public MobileElement cardName_bigbasket_android;
	
	@FindBy(xpath = "//*[@text='Grocery']")
	public MobileElement SLPBigbasket_android;
	
	@FindBy(xpath = "//*[@text='Tata CliQ']")
	public MobileElement cardName_tatacliq_android;
	
	@FindBy(xpath = "//*[@text='Fashion'] | //*[@text='Beauty'] |//*[@text='Sports']")
	public MobileElement SLPTatacliq_android;
	
	@FindBy(xpath = "//android.widget.Button[@text='Book now']")
	public MobileElement bookNowCTA_android;
	
	@FindBy(xpath = "//*[@text='Activities']")
	public MobileElement activityTab_android;

	@FindBy(xpath = "//*[contains(@text,'My benefits')]")
	public MobileElement myBenefitsTab_android;

	
	
	@FindBy(xpath = "//*[@text='ADD TO CART']")
	public MobileElement addtocart_android;
	
	@FindBy(xpath = "//android.widget.Button[@text='Continue Shopping']")
	public MobileElement continueShopping_Croma;
	
	
	@FindBy(xpath = "//*[@resource-id='footerref']//following::android.view.View[6]")
	public MobileElement offerCloseBtnCroma;
	
	@FindBy(xpath = "//*[@resource-id='cart_count_notification']")
	public MobileElement cartcounter_android;
	
	@FindBy(xpath = "//*[@resource-id='search-option-0']")
	public MobileElement product_select_Croma_android;
	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/btnPayCard']")
	public MobileElement upiPayBtn_android;
	
	
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='IHCL']")
	public MobileElement cardName_Ihcl_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Hotel']")
	public MobileElement SLPIhcl_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='AirAsia']")
	public MobileElement cardName_airasia_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Flights']")
	public MobileElement SLPAirasia_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Big Basket']")
	public MobileElement cardName_bigbasket_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Essentials']")
	public MobileElement SLPBigbasket_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Tata CliQ']")
	public MobileElement cardName_tatacliq_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Fashion'] | //XCUIElementTypeStaticText[@label='Beauty'] |//XCUIElementTypeStaticText[@label='Sports']")
	public MobileElement SLPTatacliq_ios;
	
	@FindBy(xpath = "//*[@label='Skip demo']") 
	public MobileElement demoSkip;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='closeODPScreen']") 
	public MobileElement closeODPBtn;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Tata Digital']/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton") 
	public MobileElement closeCardBtn_ios;
	@FindBy(xpath = "//*[@label='All Tiers']")
	public MobileElement alltiers_ios;
	
	@FindBy(xpath = "//*[@label='Book Now']")
	public MobileElement bookNowCTA_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Electronics']")
	public MobileElement SLPCroma_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Chat with us']")
	public MobileElement chatWithUsBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Chat']")
	public MobileElement chatWindowHdr;
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='POINT STATUS'])[2]")
	public MobileElement pointStatus_tcp_ios;
    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='POINTS EXPIRING'])[2]")
	public MobileElement pointExpiring_tcp_ios;
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Activity']")
	public MobileElement activity_tcp_ios;
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Points Schedule']")
	public MobileElement pointSchedule_tcp_ios;
    
    //Android luxury
    @FindBy(xpath = "//android.view.View[@content-desc=\"Luxury Tata CLiQ\"]/android.view.View")
	public MobileElement LuxuryHomepageTitle;
    
    @FindBy(xpath = "//*[@text='Search']")
	public MobileElement Luxury_searchicon;
    
    @FindBy(xpath = "//*[@text='user']")
	public MobileElement Luxurymyaccounticon;
    
    @FindBy(xpath = "//*[@id='search-input']")
	public MobileElement searchsendCliqLuxury;
    
    @FindBy(xpath="//*[@text='TCP Points Applied']/following-sibling::*") public MobileElement loyaltypoints_applied;
    
    @FindBy(xpath = "(//*[@text='Tata Pay'])[2]") public MobileElement TataPay;
    @FindBy(id = "com.tatadigital.tcp.dev:id/tvTotalCartAmount") public MobileElement totalCartAmt;
    @FindBy(xpath = "//*[@resource-id='otpForm']/android.widget.EditText") public MobileElement hdfcPay;
    @FindBy(xpath = "//*[@text='Submit']") public MobileElement hdfcPaySubmit;
    
    @FindBy(xpath = "//*[contains(@text,'Choose a payment method')]") 
	public MobileElement Paymentdetails;
    
    
    
    


}
