package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.MobileElement;

public class TDL_CromaCardPage {

	@FindBy(xpath = "//*[contains(text(),'Croma')]")
	public WebElement cardNameText_Croma;
	@FindBy(how =How.XPATH,using="loca") public WebElement cardNameTex;

	@FindBy(xpath = "//*[contains(text(),'Tata CLiQ')]")
	public WebElement cardNameText_Cliq;
	@FindBy(xpath = "//*[contains(text(),'Westside')]")
	public WebElement cardNameTextWestside;
	
	@FindBy(xpath = "//div[@class='sc-fznYue kyOvTV']/button[contains(text(),'Activity')]")
	public WebElement activityTab_Croma;

	@FindBy(xpath = "//div[@class='sc-fznYue kyOvTV']/button[contains(text(),'My Benefits')]")
	public WebElement myBenefitsTab_Croma;

	@FindBy(xpath = "//button[contains(text(),'Book Now')]")
	public WebElement shopNowCTA_Croma;

	@FindBy(xpath = "//*[@id='modal-close-button'] | //*[contains(text(),'Croma')]/parent::div/parent::div/button")
	public WebElement closeBtn_Croma;
	
	@FindBy(xpath ="//*[contains(text(),'Activity')]/parent::div/parent::div/div[2]/div/div/div/div/div" )
	public List<WebElement> transcActivity_Croma;
	
	@FindBy(xpath = "//*[contains(text(),'Activity')]/parent::div/parent::div/div[2]/div/div/div/div/div/div[1]/div[1]")
	public List<WebElement> transcDesc_Croma;
	
	@FindBy(xpath = "//*[contains(text(),'Activity')]/parent::div/parent::div/div[2]/div/div/div/div/div/div[1]/div[2]")
	public List<WebElement> transcDate_Croma;
	
	@FindBy(xpath = "//*[text()='Add to cart']")
	public WebElement addtocart_Croma;
	@FindBy(xpath = "//button[text()='Continue Shopping']")
	public WebElement continueShopping_Croma;
	
	@FindBy(xpath = "//*[@id='cart_count_notification']")
	public WebElement cartcounter;
	
	
	
	/*
	 * =========================================================================================
	 * SIT R2 REWARDS and Benefits
	 *======================================================================================== 
	 */
	@FindBy(xpath = "//*[contains(text(),'Please enter')]") public WebElement loginPageHdrTxtWeb;
	
	//HomePage
	@FindBy(xpath = "//*[@id='modal-close-button']")
	public WebElement offerCloseaftersignIn;
	
	@FindBy(xpath = "//*[@alt='app-logo']")
	public WebElement uLogo;
	@FindBy(xpath = "//*[@id='home-u-rewards']/div/label")
	public WebElement uRewardsHomePage;
	@FindBy(xpath = "//*[@id='home-u-rewards']/div/label/span")
	public WebElement rewardsTopNavCoins;
	//R & B Page
	@FindBy(xpath = "//*[contains(text(),'points')]//preceding-sibling::span")
	public WebElement pointsRBPage;
	
	//URewardsPage
	@FindBy(xpath = "//*[contains(text(),'Your badges & privileges')]") public WebElement yourPrivileges;
	
	@FindBy(xpath = "//*[contains(text(),'Rewards by TataNeu')]") public WebElement rewardsNudge;
	@FindBy(xpath = "//a[contains(text(),'Know more')]") public WebElement rewardsKnowMoreCTA;
	@FindAll({@FindBy(xpath="//*[@class='component2-regular-text']//li")}) public List<WebElement> rewardsDetails;
	
	@FindBy(xpath = "//div[contains(text(),'NeuPass')]") public WebElement uRewardsHdr;
	@FindBy(xpath = "//*[contains(text(),'Welcome! Privileges Unlocked')]") public WebElement uRewardsWelcomeMsg;
	@FindBy(xpath = "//*[@alt='NeuPass Icon']") public WebElement uPointsTCPCard;
	@FindBy(xpath = "//*[@id='tcp-card-view-details']") public WebElement tcpviewDetailsBtn;
	@FindBy(xpath = "//*[contains(text(),'Total NeuCoins')]/following-sibling::*") public WebElement uPointsBalancePage;
	@FindBy(xpath = "//label[contains(text(),'Available NeuCoins')]/following-sibling::*") public WebElement uPointsUseableBalancePage;
	@FindBy(xpath = "//*[@id='expanded-partner-details-section']/img[@alt='NeuPass Icon']") public WebElement uPointsLabel;
	@FindBy(xpath = "//*[contains(text(),'Activities')]") public WebElement activityTabTCP;
	@FindBy(xpath = "//*[contains(text(),'Expiry Schedule')]") public WebElement pointsScheduleTabTCP;
	@FindBy(xpath = "//*[contains(text(),'EXPIRING')]") public WebElement uPointsCardExpiryLabel;
	@FindBy(xpath = "//*[contains(text(),'expiring')]/following::p[1]") public WebElement uPointsCardExpiryDate;
	@FindBy(xpath = "//*[contains(text(),'EXPIRING')]//following::h4[1]") public WebElement viewDetailsCTA_TCP;
	@FindBy(xpath = "//*[contains(text(),'Croma')]") public WebElement cromaCardNotExpanded;
	
	
	@FindBy(xpath = "(//*[contains(text(),'Total NeuCoins')]/following-sibling::*)[2]") public WebElement uPointsBalance;
	@FindBy(xpath = "(//label[contains(text(),'Available NeuCoins')]/following-sibling::*)[2]") public WebElement uPointsUseableBalance;
	@FindBy(xpath = "//*[text()='Activities']/following::div[8]") public WebElement transaction_desc;
	@FindBy(xpath = "//*[text()='Activities']/following::div[9]") public WebElement transaction_date;
	@FindBy(xpath = "(//*[@id='transactions-tcp-points-earned'])[1]") public WebElement promotionalEarn_points;
	@FindBy(xpath = "(//*[@id='transactions-tcp-points-earned'])[2]") public WebElement earn_points;
	@FindBy(xpath = "//*[text()='Activities']/following::div[12]") public WebElement earn_point_unlock;
	@FindBy(xpath = "(//*[@id='transactions-store-name-tcp'])[1]") public WebElement latestTransaction_desc;
	
	
	
	@FindBy(xpath = "//*[text()='Offers & Bundles']//following::li") public List<WebElement> heroBannerPagesOffers;
	@FindBy(xpath = "(//span[contains(text(),'Buy')])[1]") public WebElement buyNowCTAHeroBanner;
	
	@FindBy(xpath = "(//button[contains(text(),'buy')])[1]") public WebElement buyNowBtnCromaOfferProduct;
	
	//Cromacard page
	@FindBy(xpath = "(//*[contains(text(),'Croma')])[1]") public WebElement cromaCardExpanded;
	@FindBy(xpath = "//*[contains(text(),'Activities')]") public WebElement activityTabCroma;
	@FindBy(xpath = "//*[contains(text(),'My Benefits')]") public WebElement myBenefitsCroma;
	@FindBy(xpath = "//button[contains(text(),'Shop now')]") public WebElement shopNowCromaCTA;
	
	@FindBy(xpath = "//*[contains(text(),'Exclusive offers')]") public WebElement indulgeWidget;
	@FindBy(xpath = "//*[contains(text(),'Offers you')]/following::h5[1]") public WebElement indulgeWidgetOffer1;
	@FindBy(xpath = "//*[contains(text(),'Offers you')]/following::h5[2]") public WebElement indulgeWidgetOffer2;
	@FindBy(xpath = "//*[contains(text(),'Offers you')]/following::h5[3]") public WebElement indulgeWidgetOffer3;
	@FindBy(xpath = "//*[contains(text(),'Offers you')]/following::h5[4]") public WebElement indulgeWidgetOffer4;
	@FindBy(xpath = "//*[contains(text(),'Offers you')]/following::h5[5]") public WebElement indulgeWidgetOffer5;
	@FindBy(xpath = "(//*[@mask='url(#chevron-right-circle-b)'])[1]") public WebElement widgetNavigatorBtn;
	@FindBy(xpath = "//*[contains(text(),'Select stories for you')]") public WebElement exclusiveStoriesWidget;
	@FindBy(xpath = "//*[contains(text(),'Select stories for you')]/following::h5[1]") public WebElement exclusiveStoriesWidgetDesc1;
	@FindBy(xpath = "//*[contains(text(),'Privileges')]") public WebElement mybenefits;
	@FindBy(xpath = "(//*[contains(text(),'Benefits')])[3]") public WebElement mybenefitsPM;
	@FindBy(xpath = "//*[contains(text(),'All badges')]") public WebElement alltiers;
	@FindBy(xpath = "//*[contains(text(),'Chat')]") public WebElement chat_with_us;
	@FindBy(xpath = "//*[contains(text(),'Hi')]") public WebElement customer_name;
	@FindBy(xpath = "//*[contains(text(),'IHCL')]") public WebElement ihclCard;
	@FindBy(xpath = "//*[contains(text(),'Book now')]") public WebElement ihclCardBookNow;
	@FindBy(xpath = "//*[@alt='searchIcon']") public WebElement searchIconHotelSLP;
	@FindBy(xpath = "//*[contains(text(),'Book Now')]") public WebElement BookNowHotelSLP;
	
	@FindBy(xpath = "//*[contains(text(),'AirAsia India')]") public WebElement AirAsiaCard;
	@FindBy(xpath = "//*[contains(text(),'Book now')]") public WebElement airAsiaCardBookNow;
	
	@FindBy(xpath = "//*[contains(text(),'Tata CLiQ')]") public WebElement cardNameText_tataCliqCard;
	@FindBy(xpath = "//*[text()='Activities']/following::div[11]") public WebElement CardTransactAmt;
	@FindBy(xpath = "//*[text()='Activities']/following::div[9]") public WebElement CardTransactDate;
	@FindBy(xpath = "//*[contains(text(),'Activities')]") public WebElement activityTab;

	@FindBy(xpath = "//a[@aria-label='searchIcon'] | //input[@id='search-text-input']") public WebElement searchButtonCliq;

	@FindBy(xpath = "//*[text()='Tata CLiQ Luxury']") public WebElement luxury_cliq;
	@FindBy(xpath = "//span[@class='icons1 headRgtSrchIcon']") public WebElement searchButtonCliqLuxury;
	@FindBy(xpath = "//*[text()='EMI']/following-sibling::div") public WebElement emi_click_cliq;
	@FindBy(xpath = "//*[contains(text(),'UPI')]/following-sibling::div") public WebElement upi_click_cliq;
	@FindBy(xpath = "//*[contains(text(),'Credit Card EMI')]/preceding-sibling::div") public WebElement nocostemi_click_cliq;
	@FindBy(xpath = "(//*[text()='Select this plan'])[1]") public WebElement select_plan_emi_cliq;
	@FindAll({@FindBy(xpath="//*[@class='EachHeroBannerlowersection_left']/p")}) public List<WebElement> heroBannerJourneyDesc;
	@FindAll({@FindBy(xpath="//*[@class='EachHeroBannertitlesection']/h4")}) public List<WebElement> heroBannerJourneyTitle;
	@FindAll({@FindBy(xpath="//*[@class='EachHeroBannerlowersection_right']/button")}) public List<WebElement> heroBannerJourneyCTA;
	@FindBy(xpath = "(//*[@placeholder='Card Number *'])[3]") public WebElement card_number_emi_cliq;
	@FindBy(xpath = "//*[text()='ICICI Bank']") public WebElement icici_bank_emi_cliq;
	@FindBy(xpath = "//*[text()='Axis Bank']") public WebElement axis_bank_emi_cliq;
	@FindBy(xpath = "(//*[@placeholder='Name on card*'])[3]") public WebElement card_name_emi_cliq;
	@FindBy(xpath = "(//*[text()='EMI']/following::select)[1]") public WebElement expirymonth_emi_cliq;
	@FindBy(xpath = "(//*[text()='EMI']/following::select)[2]") public WebElement expiryyear_emi_cliq;
	@FindBy(xpath = "(//*[text()='EMI']/following::input)[3]") public WebElement cvv_emi_cliq;
	@FindBy(xpath = "(//*[text()='Electronics'])[2]") public WebElement electronics_slp_croma;
	@FindBy(xpath = "(//*[text()='Electronics'])[1]") public WebElement electronics_slp_croma_PM;
	@FindBy(xpath = "(//*[text()='Fashion'])[2]") public WebElement fashion_slp_cliq;
	@FindBy(xpath = "(//*[text()='Fashion'])[1]") public WebElement fashion_slp_cliq_PM;
	@FindBy(xpath = "(//*[text()='Hotels'])[2]") public WebElement hotel_slp_ihcl;
	@FindBy(xpath = "(//*[text()='Hotels'])[1]") public WebElement hotel_slp_ihcl_PM;
	@FindBy(xpath = "(//*[text()='Grocery'])[2]") public WebElement essentials_slp_bigbasket;
	@FindBy(xpath = "(//*[text()='Grocery'])[1]") public WebElement essentials_slp_bigbasket_PM;
	@FindBy(xpath = "//*[contains(text(),'bigbasket')]") public WebElement cardNameText_Bigbasket;
	@FindBy(xpath = "//*[@id='dropdown-custom-components']") public WebElement flights_slp_airasia;
	//@FindBy(xpath = "//*[@class='img-logo']") public WebElement flights_slp_bigbasket;
	
	
	
	
	
	
	
	
	//pwa mobile
	@FindBy(xpath = "//*[text()='Your brands']") public WebElement brandsPageBtn;
	
	@FindBy(xpath = "(//*[contains(text(),'U Rewards')])[1]")
	public WebElement uRewardsHomePage_pm;
	@FindBy(xpath = "//*[contains(text(),'U Rewards')]") public WebElement uRewardsHdr_pm;
	@FindBy(xpath = "(//*[text()='U Rewards']/following::img)[2]") public WebElement uPoints_pm;
	@FindBy(xpath = "//*[contains(text(),'No')]") public WebElement nothankscliq_pm;
	@FindBy(xpath = "(//*[contains(text(),'Delivery ')])[2]") public WebElement zip_delivery_pm;
	@FindBy(xpath = "//*[contains(text(),'Track')]") public WebElement track_order_pm;
	@FindBy(xpath = "(//*[contains(text(),'Points')])[1]/following-sibling::*") public WebElement point_used_croma_pm;
	@FindBy(xpath="//*[text()='Total']/following-sibling::*") public WebElement total_paid_amount;
	@FindBy(xpath="(//*[text()='Payment details']/following::h4)[4]") public WebElement amountPaidByEligibleTender;
	@FindBy(xpath="(//*[text()='Payment details']/following::button)[1]") public WebElement payment_icon;
	@FindBy(xpath="//*[text()='Standard Delivery']/preceding::span[2]") public WebElement standardDeliveryCroma;
	
	@FindBy(xpath="//*[text()='LUXURY']") public WebElement LuxuryHomepageTitle;
	@FindBy(xpath="//*[@class='icons1 headRgtSrchIcon']") public WebElement Luxury_searchicon;
	@FindBy(xpath="//*[@class='icons1 headRgtAccntIcon']") public WebElement Luxurymyaccounticon;
	@FindBy(xpath="//*[@class='srchFrm']") public WebElement searchsendCliqLuxury;
	@FindBy(xpath="//*[@class='plpPrdImg']") public WebElement productCliqLuxury;
	@FindBy(xpath="//*[@class='slctOptListItem sizeOpt']/following::a[1]") public WebElement sizeCliqLuxury;
	@FindBy(xpath="//button[text()='Check']") public WebElement pinCodeCheckCliqluxury;//button[text()='Check']
	@FindBy(xpath="//button[text()='Buy Now']") public WebElement buyNowCliqluxury;
	@FindBy(xpath="//*[text()='Proceed to Checkout']") public WebElement checkoutCliqluxury;
	@FindBy(xpath="//*[text()='Add New Address']") public WebElement addAddressluxury;
	@FindBy(xpath="//*[text()='Bag Total']/following-sibling::span") public WebElement BagTotalCliqluxury;
	@FindBy(xpath="//*[text()='Shipping Charge(s)']/following-sibling::span") public WebElement shippingCliqluxury;
	@FindBy(xpath="//*[text()='Product Discount(s)']/following-sibling::span") public WebElement discountCliqluxury;
	@FindBy(xpath="//*[text()='Total Payable']/following-sibling::span") public WebElement totalPayCliqluxury;
	@FindBy(xpath="//*[contains(@placeholder,'card number*')]") public WebElement debittnumberCliqluxury;
	@FindBy(xpath="(//*[@class='dateSelect'])[1]") public WebElement expirymonthdebCliqluxury;
	@FindBy(xpath="(//*[@class='dateSelect'])[2]") public WebElement expiryyeardebCliqluxury;
	@FindBy(xpath="//*[contains(@placeholder,'Name on Card')]") public WebElement cardnamedebCliqluxury;
	@FindBy(xpath="//*[contains(@placeholder,'CVV')]") public WebElement cvvdebCliqluxury;
	@FindBy(xpath="//button[contains(text(),'Place Order')]") public WebElement paydebCliqluxury;
	@FindBy(xpath="//*[text()='Ask Me Later']") public WebElement laterCliqluxury;
	@FindBy(xpath="//div[text()='Delivery Options']") public WebElement featuresluxury;
	@FindBy(xpath="//*[text()='COD']") public WebElement codCliqluxury;
	@FindBy(xpath="//*[text()='ICICI Bank']") public WebElement iciciCliqluxury;
	@FindBy(xpath="//*[contains(text(),'Use my')]/following::span") public WebElement tcpPointsCliq_checkboxluxury;
	@FindBy(xpath="//input[@id='TPM']") public WebElement tataPayCliq_checkboxluxury;
	@FindBy(xpath="//button[text()='Place Order']") public WebElement placeOrderCliq_checkboxluxury;
	@FindBy(xpath="//*[text()='Edit Points']") public WebElement tcpPointsEditCliqluxury;
	@FindBy(xpath="//*[@placeholder='Enter Points']") public WebElement tcpPointsEnterCliqluxury;
	@FindBy(xpath="//*[text()='Redeem']") public WebElement tcpPointsredeemCliqluxury;
	@FindBy(xpath="//*[text()='EMI']") public WebElement emiCliqluxury;
	@FindBy(xpath="//*[@class='emiBankSelect']") public WebElement emi_bank_select_Cliqluxury;
	@FindBy(xpath="//*[text()='Select a plan']/following::span") public WebElement emi_tenure_select_Cliqluxury;
	@FindBy(xpath="//*[@name='quantity']") public WebElement item_quantityluxury;
	@FindBy(xpath="//*[text()='Select Size']/following::label/a") public WebElement size_emi_Cliqluxury;
	
	@FindBy(xpath = "//input[@placeholder='Enter number'] |//input[@placeholder='Mobile number']" ) public WebElement mobileNoTextBox;
	@FindBy(xpath="(//*[contains(text(),'CLiQ Cash')]/following::span)[1]") public WebElement cliq_cash_radioluxury;
	

	
	@FindBy(xpath = "//*[contains(text(),'Enter the OTP')]") public WebElement otpPageHdr;
	@FindBy(xpath = "//*[contains(text(),'No thanks')]") public WebElement WelComePopup;
	@FindBy(xpath = "//input[@name='otp-input' and @type='number']") public WebElement otpField;

	

	
	//Multiple product
	@FindBy(xpath="//*[text()='ADD TO BAG'] | //*[text()='Add to bag']") public WebElement addCartCliq;
	@FindBy(xpath="//*[text()='GO TO BAG']") public WebElement goToBagCliq;
	@FindBy(xpath="//*[@class='DesktopHeader__myBagShow']") public WebElement cartCliq;
	@FindAll({@FindBy(xpath="//*[@class='BagPageItem__informationText']")}) public List<WebElement> lineItemDetailsCliq;
	@FindAll({@FindBy(xpath="//*[@class='CartItemForDesktop__informationText']")}) public List<WebElement> lineItemNameCliq;
	@FindAll({@FindBy(xpath="//*[@class='CartItemForDesktop__informationTextWithBolder CartItemForDesktop__informationText']")}) public List<WebElement> lineItemPriceCliq;
	//@FindBy(xpath="//*[text()='Total Payable']/following::div[1]") public WebElement totalPayableAtCheckOut;
	@FindBy(xpath="//*[@class='DesktopCheckout__price']") public WebElement totalPayableAtCheckOut;
	
	@FindBy(xpath="(//div[@class='HeroBannerComponent_EachHeroBannerlowersection_right__mdALT']//button//span[contains(text(),'Shop now')])[1]") public WebElement heroBannerShopNowBtn;
	
	@FindBy(xpath = "//*[contains(text(),'Product is already in cart')]") public  WebElement productAlreadyInCartPopUp;
	@FindBy(xpath = "//*[contains(text(),'CANCEL')]") public WebElement cancelBtn;
	
	@FindAll({@FindBy(xpath="//*[text()='Activity']/following::div")}) public List<WebElement> lineItemPointEarn;
	@FindBy(xpath="//*[text()='Cash On Delivery']/following-sibling::* |//*[text()='Cash on Delivery']/following-sibling::*") public WebElement cod_payment;
	@FindBy(xpath="//*[text()='ICICI Bank']/preceding-sibling::*") public WebElement icicibank;
	@FindBy(xpath="//*[text()='HDFC Bank']/preceding-sibling::*") public WebElement hdfcbank;
	@FindBy(xpath="(//*[@class='Button__base']/span[text()='Pay now'])[3] | //*[text()='Pay Now']") public WebElement payCliq;
	
//	@FindBy(xpath="//*[@id='check-button-unchecked-a']") public WebElement tcpPoints_checkbox;
	@FindBy(xpath="//*[text()='NeuCoins']//preceding::*[4]") public WebElement tcpPoints_checkbox;
	@FindBy(xpath="(//*[contains(@mask,'radio-unchecked-b')])[1]") public WebElement uncheckedCreditCard;

	@FindBy(xpath="//*[text()='CLiQ Cash Applied']/following-sibling::*") public WebElement cliqcash_applied;
	@FindBy(xpath="//*[text()='Loyalty Applied']/following-sibling::*") public WebElement loyaltypoints_applied;
	@FindBy(xpath="//*[text()='Payment Method']") public WebElement paymentMethodHdr;
	@FindBy(xpath="//*[contains(text(),'Use my NeuCoins')]/following::div[5]") public WebElement tcpPointsCliq_checkbox;
	@FindBy(xpath="//*[contains(text(),'NeuCoins Applied')]/following-sibling::div") public WebElement loyaltyappliedCliq;
	
	
	@FindBy(xpath="//*[text()='Shop now']") public WebElement shop_now_button;
	//article[text()='Tata Pay']
	@FindBy(xpath="//article[contains(text(),'Tata Pay')]") public WebElement TataPayOption;
	//div[@class='linearLayout sidebarItem_object']/following:://article[text()='Tata Pay')]
	@FindBy(xpath="(//article[contains(text(),'Tata Pay')])[3]") public WebElement TataPay;
	@FindBy(xpath="//button[@class='skipButton']") public WebElement skipPaymentOfferBtn;
	@FindBy(xpath="(//*[@class='desc address-break billing-address-font'])[1]") public WebElement deliveryAddressField;
	
	@FindBy(xpath="//input[@type='radio' and @checked]") public WebElement checkedcard;
	
	
	//@FindBy(xpath="//*[text()='Credit card']/following::*[5]") public WebElement creditCardRadioBtn;
	//@FindBy(xpath="//*[text()='Debit card']/following::*[5]") public WebElement debitCardRadioBtn;;
	@FindBy(xpath="(//*[text()='Credit cards']/..//label/*)[1]") public WebElement creditCardRadioBtn;
	@FindBy(xpath="(//*[text()='Debit cards']/..//label/*)[2]") public WebElement debitCardRadioBtn;
	
	
	@FindBy(xpath="//*[text()='Amount']/following::span[1]") public WebElement totalCartAmt;
	@FindBy(xpath="//*[contains(text(),'Tata Pay')]//following::div[1]") public WebElement tataPayRadioBtn;
	@FindBy(xpath="//*[contains(text(),'Continue')]") public WebElement continueBtnTataPay;
	@FindBy(xpath="//*[contains(text(),'Tata Pay')]//following::div[1]") public WebElement tataPayRadioBtnCliqLuxury;
	
	
	
	@FindBy(xpath="//*[@id='video-play-button']") public WebElement videoPlayBtn;
	@FindBy(xpath="//*[@id='over-lay-text-on-video-player']") public WebElement firstNameTextOnVideo;
	//*[@class='welcome-video-react-wrapper-component']/preceding::*[1]
	@FindBy(xpath="//*[text()='Card payments']") public WebElement cardsSelection;
	@FindBy(xpath="//*[text()='Debit cards']") public WebElement debitcard1;
	@FindBy(xpath="//*[text()='Credit cards']") public WebElement creditcard;
	@FindBy(xpath="//input[@placeholder='Enter CVV'] |//input[@placeholder='CVV']") public WebElement enterCVV;
	@FindBy(xpath="//*[@class='security_code_iframe']") public  WebElement enter_CVV;
	@FindBy(xpath="//span[@class='SearchResult_text_label_drop_down__giXl7' and text()='Fitness']") public WebElement fitnessHomepageTitle;
	@FindBy(xpath="//span[@class='SearchResult_text_label_drop_down__giXl7' and text()='Beauty']") public WebElement beutyHomepageTitle;
	@FindBy(xpath="//input[@placeholder='Enter Pincode']") public WebElement pincodeBox;
	@FindBy(xpath="//*[contains(text(),'APPLY')]") public WebElement pincodeApplyBtn;
	@FindBy(xpath="//*[text()='Thank you for shopping with us']") public WebElement orderCompletionCroma;
	@FindBy(xpath="//*[@class='order-id-desc']") public WebElement cromaOrderId;
	@FindBy(xpath="//*[@class='ProductModule__imageAndDescriptionWrapper']") public WebElement productCliq;
	
	@FindBy(xpath="//*[@class='order-id '] | //*[contains(text(), 'Transaction')]") public WebElement success_Transaction;
	@FindBy(xpath="//*[@class='product-info'] | //*[contains(text(), 'Transaction')]/../preceding-sibling::div[1]") public WebElement success_sumary;
	
	@FindBy(xpath="//*[@id='content' and @data-merchantid='TataCliq']") public WebElement tataCliqOrderId;
	@FindBy(xpath="(//*[text()='Payment details']/following::div/h4)[4]") public WebElement amountOfPayTenderOrderId;
	@FindBy(xpath="//*[text()='NeuCoins']") public WebElement neuCoinsUserOrderId;
	@FindBy(xpath="//*[text()='Payment details']") public WebElement paymentDetailsHdrOrderId;
	
	
}