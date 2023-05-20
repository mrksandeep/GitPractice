package com.QA.TestApp.Pages.WEB;

import com.QA.TestApp.Utilities.BaseScript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyOffersPage extends BaseScript {
	
	
	@FindBy(xpath = "//*[contains(text(),'OFFER')]")
	public WebElement countOffers;
	@FindBy(xpath="//*[contains(@*,'viewdetails')]")
	public List<WebElement> transactionCTA;
	@FindBy(xpath="//label[contains(text(),'Savings:')]")
	public WebElement totalSavings;
	@FindBy(xpath="//div[@class='Flex__Box-kdyZDI beBEsA sc-pQSRh kUecYO']")
	public WebElement individualSavings;
	@FindBy(xpath="//*[@*='redemptionok']")
	public WebElement okBtnRedeemtion;
	@FindBy(xpath="//div[@id='main-content']//div[@class='Flex__Box-kdyZDI jOCifj styles__ItemsContainer-eWuMQj ObfO']//div[@class='Flex__Box-kdyZDI frpiKJ'][1]")
	public List<WebElement> expiringSoon;
	
	@FindBy(xpath="//*[contains(text(),'Redemption Details')]")
	public WebElement redemption_details;
		
	@FindBy(xpath="//*[@id='reedem-details']//label")
	public WebElement redemption_offerbrand;
	
	@FindBy(xpath="//*[@id='reedem-details']//section[2]")
	public WebElement redemption_offertitle;
	
	@FindBy(xpath="//*[normalize-space(text())='SAVINGS']/following::div[3]")
	public WebElement redemption_date_savingamt;
		
	/*
	 * @FindBy(xpath="//*[@id='reedem-details']/div/div/label[2]/span") public
	 * WebElement redemption_total_savingamt;
	 */
	
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI beBEsA sc-qWQHW hfApKq']//button[@name='Used']")
	public WebElement usedTab;
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI beBEsA sc-pTWqp gdBFSQ']//section[@class='sc-oVpqz gmldoY']")
	public List<WebElement> offerShortDesc;
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI beBEsA sc-pDbHj iBtvlG']//a[@path='images/sample-offer.png']")
	public List<WebElement> offerImageUsed;
	
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI beBEsA sc-pDbHj iBtvlG']//a[@path='images/sample-offer.png']")
	public List<WebElement> offerImageCollected;
	
	@FindBy(xpath ="//div[@class='Flex__Box-kdyZDI beBEsA sc-pTWqp gdBFSQ']//section[@class='sc-qcrrk esLljD']")
			
			public List<WebElement> offerImageTitle;

	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI kNVuVA sc-pRFHb hGgJws']//button[@class='SmallButton__SmallButtonStyled-enCeDd bWHuKv sc-pZCuu eFxMdv']")
	public List<WebElement> viewDetails;
	
	
	@FindBy(xpath="//div[@class='Flex__Box-kdyZDI kNVuVA sc-pKMan jkgDDv']//button[@class='SmallButton__SmallButtonStyled-enCeDd bWHuKv sc-pcZJD jhVZNe']")
	public WebElement addToVault;
	
	@FindBy(xpath="//section[@class='sc-pQsrT jBANHB']")
	public WebElement expiryDetails;
	

	@FindBy(xpath="//section[@class='sc-pdjNk dcpbrj']")
	public WebElement howToAvail;
	//*Manoranjan*//
		@FindBy(xpath = "(//*[contains(@class,'indicator')])[1]")
		public WebElement OfferBannerdot;
		@FindBy(xpath = "(//*[@id='OZ_Banner_CtaLink'])[2]")
		public WebElement OfferBannerShopNow;
		@FindBy(xpath = "//div[contains(text(),'Saved offers')]") public WebElement offersTab;
		@FindBy(xpath = "//*[contains(text(),'Add to Vault')]")
		public WebElement addToVaoult;
		@FindBy(xpath = "//*[contains(text(),'Buy 1 Stuffcool Soft Case K20/K20 pro Bk/Grey and get 1 free - on reward only')")
		public WebElement offerDescription;
		@FindBy(xpath = "(//*[contains(@viewBox,'0 0 25 25')])[1]")
		public WebElement clickFBIcon;
		@FindBy(xpath = "(//*[contains(@viewBox,'0 0 25 25')])[2]")
		public WebElement clickTwiterIcon;
		@FindBy(xpath = "(//*[contains(@viewBox,'0 0 25 25')])[3]")
		public WebElement clickEmailIcon;
		@FindBy(xpath = "(//*[contains(@viewBox,'0 0 25 25')])[4]")
		public WebElement clickWhatsAppIcon;
		@FindBy(xpath = "//*[@id='email'] | //*[@name='email']")
		public WebElement fbUserName;
		@FindBy(xpath = "//*[@id='pass'] | //*[@name='pass']")
		public WebElement fbPassword;
		@FindBy(xpath = "//*[@name='login']")
		public WebElement fbLogin;
		@FindBy(xpath = "//button[@data-testid='offers']")
		public WebElement offerTabClick;
		@FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/div[2]/a[1]")
		public WebElement clickOnVault;
		@FindBy(xpath = "//button[@name='Used'] | //button[@data-testid='usedtab']")
		public WebElement clickUsedTab;
		@FindBy(xpath = "//button[@name='Active'] | //button[@data-testid='activetab']")
		public WebElement clickActiveButton;
		
		@FindBy(xpath = "//*[contains(text(),'Change location')] | //*[contains(text(),'Change Location')]")
		public WebElement storeResults;
		@FindBy(xpath = "//a[@href='/discovery']")
		public WebElement searchOffer;
		@FindBy(xpath = "(//div[@class='Flex__Box-kdyZDI beBEsA Carousel__ControlPanel-eihPqL gQnbC']//*[@fill-rule='evenodd'])[2]")
		public WebElement heroBannerofferClick;
		@FindBy(xpath = "//*[@id='app']/div[1]/div[1]/div/input")
		public WebElement searchOfferTextBox;
		@FindBy(xpath = "//*[@class='Carousel__Item-ebKQpf jfsEXy']")
		public List<WebElement> herobannerOffers;
		@FindBy(xpath = "//*[@mask='url(#chevron-bottom-b)']")
		public WebElement filterByBrand;
		@FindBy(xpath = "(//*[@mask='url(#chevron-bottom-b)'])[2]")
		public WebElement filterByCatagory;
		@FindBy(xpath = "//*[@mask='url(#direction-b)']")
		public WebElement directionCTA;
		@FindBy(xpath = "//*[@id='directions-searchbox-0'] | //*[contains(@class, 'ml-directions-unibox__source')]")
		public WebElement directionStartingPoint;
		@FindBy(xpath = "//*[@id='directions-searchbox-1'] | //*[contains(@class, 'ml-directions-unibox__destination')]")
		public WebElement directionEndingPoint;
		@FindBy(xpath = "//*[@class='styles__T6Price-ccAJdt jtjZYG']")
		public WebElement forYouOffer;
		@FindBy(xpath = "//*[@id='brand_name']/div[2]/div[1]/label/input")
		public List<WebElement> brandNames;
		@FindBy(xpath = "//*[@id='brand_name']/div[2]/div[1]/label/input")
		public WebElement BrandName;
		@FindBy(xpath = "//*[contains(text(),'Apply')]")
		public WebElement applyButton;
		@FindBy(xpath = "//*[@data-parent='category_name']")
		public List<WebElement> catagoryNames;
		@FindBy(xpath = "//*[@data-parent='category_name']")
		public WebElement childCatagoryNames;
		@FindBy(xpath = "(//*[contains(text(),'View')])[2]")
		public WebElement viewStoreCTA;
		@FindBy(xpath = "//a[@data-testid='direction-0']")
		public WebElement viewStoreDirectionCTA;
		@FindBy(xpath = "//*[contains(text(),'More filters')]|//*[contains(text(),'Filter')]")
		public WebElement moreFilters;
		@FindBy(xpath = "(//*[@data-toggle='dropdown'])[1]")
		public WebElement moreFiltersBrands;
		@FindBy(xpath = "(//*[@data-toggle='dropdown'])[4]")
		public WebElement moreFiltersChildBrandsArw;
		@FindBy(xpath = "//*[@id='sub_brand_name']/div[2]/div[1]/label/input")
		public WebElement moreFiltersChildBrands;
		@FindBy(xpath = "(//*[@data-toggle='dropdown'])[2]")
		public WebElement moreFiltersCatagoryArw;
		@FindBy(xpath = "(//*[@data-toggle='dropdown'])[5]")
		public WebElement moreFiltersChildCatagoryArw;
		@FindBy(xpath = "//*[@id='category_name']/div[2]/div[1]/label/input")
		public WebElement FiltersByCatagory;
		@FindBy(xpath = "(//*[@data-toggle='dropdown'])[3]")
		public WebElement moreFiltersOfferTypeArwClick;
		@FindBy(xpath = "//*[@id='offer_type']/div[2]/div[1]/label/input")
		public WebElement moreFiltersOfferType;
		@FindBy(xpath = "//*[@id='app']/div[4]/div[1]")
		public WebElement offerResults;
		@FindBy(xpath = "//*[contains(text(),'Expiring')]//preceding-sibling::div")
		public WebElement ExpiringOffer;
		@FindBy(xpath = "//*[contains(text(),'Ok')]")
		public WebElement OffError;
		@FindBy(xpath = "//*[contains(text(),'Found')]")
		public WebElement multiStoreResults;
		@FindBy(xpath = "//*[@class='sc-qQMSE bgoLuJ']")
		public List<WebElement> storeNames;
		@FindBy(xpath = "//*[@mask='url(#direction-b)']")
		public WebElement storeDirections;
		@FindBy(xpath = "//*[@data-testid='offers-right-chevron']")
		public List<WebElement> rightDirections;
		@FindBy(xpath = "//*[contains(text(),'View All Offers')]")
		public List<WebElement> viewAllOffers;
		@FindBy(xpath = "//*[contains(text(),'View Details')]")
		public List<WebElement> viewOfferDetails;
		@FindBy(xpath = "//*[contains(text(),' OFFERS')]")
		public WebElement offerCount;
		@FindBy(xpath = "//*[@mask='url(#chevron-left-b)']")
		public WebElement backToStoreResult;
		@FindBy(xpath = "//*[@class='loading-overlay ']")
		public WebElement loader;
		@FindBy(xpath = "//*[contains(text(),'Profile Page')]")
		public WebElement profilePage;
		@FindBy(xpath = "//*[contains(text(),'We found')]")
		public WebElement showingOffers;
		@FindBy(xpath = "//*[contains(text(),'Recommended Offers')]")
		public WebElement widgetRecommendedOffers;
		@FindBy(xpath = "//*[@id='template6_5_item0']")
		public WebElement recommendedOffers;
		@FindBy(xpath = "//*[contains(text(),'Recommended Category Offers')]")
		public WebElement widgetRecommendedCatagoryOffers;
		@FindBy(xpath = "//*[contains(text(),'Recommended Category Offers')]/following::div[2]")
		public WebElement recommendedCatagoryOffers;
		@FindBy(xpath = "//*[contains(text(),'Recommended Brand Offers')]")
		public WebElement widgetRecommendedBrandOffers;
		@FindBy(xpath = "//*[contains(text(),'Recommended Brand Offers')]/following::div[2]")
		public WebElement recommendedBrandOffers;
		@FindBy(xpath = "//*[contains(text(),'Offers Expiring Soon')]")
		public WebElement widgetExpiringSoon;
		@FindBy(xpath = "//*[contains(text(),'Offers Expiring Soon')]/following::div[27]")
		public WebElement expiringSoonOffers;
		@FindBy(xpath = "//*[contains(text(),'Trending Today')]")
		public WebElement widgetTrendingToday;
		@FindBy(xpath = "//*[contains(text(),'Trending Today')]/following::div[3]")
		public WebElement trendingOffers;
		@FindBy(xpath = "//*[@class='styles__Title-fMTgIO dkDoZP']")
		public List<WebElement> widgetsOnHomePage ;
		@FindBy(xpath = "//*[contains(text(),'Ok')]")
		public WebElement acknowledgeError;
		@FindBy(xpath = "//*[@data-tag='Facebook']/parent::section//parent::div//parent::section//parent::section")
		public WebElement acknoTEst;
		@FindBy(xpath = "//button[contains(text(),'View Details')]")
		public WebElement showingSegmentOffers;
		@FindBy(xpath = "//*[@style='cursor: pointer;']")
		public WebElement backFromODP;
		@FindBy(xpath = "//*[contains(text(),'We found')]")
		public WebElement showingSegmentOffersSecondUser;
		@FindBy(xpath = "//*[@id='sub_category_name']/div[2]/div[1]/label/input")
		public WebElement FiltersBySubCatagory;
		@FindBy(xpath = "(//*[name()='circle'])[14]")
		public WebElement rightNavigation;
		@FindBy(xpath = "//*[contains(text(),'Reset')]")
		public WebElement resetButton;
		@FindBy(xpath = "//*[contains(text(),'Continue')]")
		public WebElement sessionContinueButton;
		@FindBy(xpath = "//*[@mask='url(#trash-b)']")
		public WebElement removeVaultIcon;
		@FindBy(xpath = "//*[contains(text(),'Search')]")
		public WebElement discoveryPageSearchHeader;
		@FindBy(xpath = "//*[@*='search']")
		public WebElement discoveryPageSearchBar;
		@FindBy(xpath = "(//*[@style='cursor: pointer;'])[3]")
		public WebElement locationIcon;
		@FindBy(xpath = "//*[contains(text(),'IHCL')]//following::button | //*[contains(text(),'Croma')]//following::button") 
		public WebElement searchOfferViewDetailsButton;
		@FindBy(xpath = "//*[contains(text(),'Sorry')]")
		public WebElement noNearbyStore;
		@FindBy(xpath = "//button[contains(text(),'View Details')]")
		public List<WebElement> OfferViewDetails;
		
		
/*End Of My code*/
	
		
	@FindBy(xpath="//section[@class='sc-pdjNk sc-pkIrX ggMFFE']")
	public WebElement terms;
	
	//revathi //sep30
	@FindBy(xpath = "//*[contains(text(),'Offers You May Like')]")
	public WebElement widgetOffersYouMayLike;
	@FindBy(xpath = "//*[contains(text(),'Offers You May Like')]/following::div[2]/div")
	public WebElement OffersYouMayLike;
	
	//akshya	
	
	@FindBy(xpath="//*[contains(text(),'Saved Card Offers')]")
	public WebElement Saved_Card_Offers;
	@FindBy(xpath="//*[normalize-space(text())='More filters']")
	public WebElement More_Filter_Button;
	@FindBy(xpath="//*[normalize-space(text())='Trending Today']")
	public WebElement Popular_offers_Text;
	@FindBy(xpath="//*[text()='Change location']/preceding-sibling::div")
	public WebElement Error_Message_After_clicking_On_nea_By_Button;
	@FindBy(xpath="//*[contains(text(),'Change location')]")
	public WebElement btn_change_location;
	@FindBy(xpath="//*[normalize-space(text())='My location']")
	public WebElement btn_My_Loaction;
	@FindBy(xpath="//*[normalize-space(text())='Brands']")
	public WebElement Brand_Filter;
	
	@FindBy(xpath="//*[normalize-space(text())='Recommended Offers']")
	public WebElement Recomended_Offers;
	@FindBy(xpath="//*[contains(text(),'More information')]")
	public WebElement btn_More_Information;
	@FindBy(xpath="//*[@*='logo']")
	public WebElement img_logo;
	@FindBy(xpath="(//*[contains(@*,'M-4')])[2]")
	public WebElement btn_Img_Icon;
	@FindBy(xpath="//*[normalize-space(text())='Offers Expiring Soon']")
	public WebElement Offers_Expiring_Soon_Txt;
	@FindBy(xpath="//*[normalize-space(text())='Brands']")
	public WebElement Brands_filter;
	@FindBy(xpath="//*[normalize-space(text())='Category']")
	public WebElement filter;
	@FindBy(xpath="(//*[normalize-space(text())='View Details'])[1]")
	public WebElement btn_View_details;
	
	@FindBy(xpath="//*[normalize-space(text())='Change location']")
	public WebElement btn_change_loaction;
	@FindBy(xpath="//*[@id='googleSearchBox']")
	public WebElement Search_input_txt_In_change_Location_Popup;
	
	@FindBy(xpath="//*[@data-placeid='ChIJa-UgYi2e-DkRZFGaSVSypl8']")
    public WebElement devarc_mall_In_change_Location_PopUp;
    @FindBy(xpath="//*[contains(text(),'Open')]/parent::div/preceding-sibling::div/div[2]/div/div[1]")
    public WebElement Near_By_Store_Address_txt;
    @FindBy(xpath="//*[contains(text(),'Open')]/parent::div/preceding-sibling::div/div[2]/p/span")
    public WebElement Near_By_Store_Name;
    @FindBy(xpath="//*[contains(text(),'Your location')]/following-sibling::div")
    public WebElement Store_Count_txt;
    
    @FindBy(xpath = "//*[contains(text(),'Explore Offers near you')] | //*[contains(text(),'Explore offers near you')]")
    public WebElement clickNearByOption;
	@FindBy(xpath = "//a[@href='/discovery']") public WebElement searchIcon;
	@FindBy(xpath="//*[@*='search']")
	public WebElement input_search_in_discovery_page;
	@FindBy(xpath="((//*[contains(@*,'Flex__Box')])[4]//span)[1]")
	public WebElement txt_Showed_Offer_After_Seaching;
	@FindBy(xpath="//*[@data-testid='offers-right-chevron']//*[contains(@d,'M-')]")
	public WebElement cursor_button;
	@FindBy(xpath="//*[@data-testid='offers-left-chevron']//*[contains(@d,'M-')]")
	public WebElement leftcursor_button;
	@FindBy(xpath="//*[contains(text(),'View All Offers')] |  //*[contains(text(),'See all')]")
	public WebElement btn_View_All_Offers;
	@FindBy(xpath="(//*[@id='all-offer-parent-container']//preceding-sibling::div)[1]")
	public WebElement offers_txt;
	@FindBy(xpath="//*[contains(text(),'plan')]")
	public WebElement Text_Related_Features_Of_MY_Plan;
	@FindBy(xpath="//*[normalize-space(text())='My Plans']")
	public WebElement My_Plan_Button_in_header;
	
	@FindBy(xpath="(//*[@*='outlineLight'])[2]| //*[contains(text(),'Vault - My Cards Tab')]")
	public WebElement Vault_My_Card_Button;
	@FindBy(xpath="//*[normalize-space(text())='Clear']")
	public WebElement Clear_CTA_Link;
	
	//Author:-Akshya
	@FindBy(xpath="//input[@labelname='User Name']")
	public WebElement User_Name_input;
	@FindBy(xpath="//*[@*='Password']")
	public WebElement Password;
	@FindBy(xpath="//*[contains(text(),'Sign In')]/parent::button")
	public WebElement Sign_In_Button;
	@FindBy(xpath="//*[@href='/MainPage/offerconfigurator']/img")
	public WebElement Offer_Configurator_In_sideBar;
	@FindBy(xpath="//*[contains(text(),'Create New')]")
	public WebElement Create_new_Button;
	@FindBy(xpath="//*[contains(text(),'Add Eligibility')]")
	public WebElement AddEligibility;
	@FindBy(xpath="//*[@*='brandNameForPromoId']")
	public WebElement promoid;
	@FindBy(xpath="//iframe[@id='oCUiFrame']")
	public WebElement FrameID;
	@FindBy(xpath="//*[@id='ifrm']")
	public WebElement OfferCreation_Frame2_In_Form1_Page;
	@FindBy(xpath="//iframe[@class='iframe']")
	public WebElement OfferCreation_Frame1_In_form1_Page;
	@FindBy(xpath="//*[contains(@id,'item-5-instance')]")
	public WebElement promotion_ID_Input_field;
	@FindBy(xpath="//*[@name='promotionPolicy.promotionType']")
	public WebElement promotion_Type_dropDown;
	@FindBy(xpath="//*[contains(@id,'repeating-enclosing-6-instance')]")
	public WebElement Promotion_Type_Div;
	@FindBy(xpath="//*[contains(@onclick,'DP_jQuery')]//a[text()='27']")
	public WebElement Start_date_In_Calender;
	@FindBy(xpath="//*[caption]")
	public WebElement End_date_In_Calender;
	@FindBy(xpath="//*[text()='Done']")
	public WebElement Done_Button;
	
	@FindBy(xpath="(//*[@placeholder='DD-MM-YYYY HH:mm'])[1]")
	public WebElement Start_date_button;
	@FindBy(xpath="(//*[@placeholder='DD-MM-YYYY HH:mm'])[2]")
	public WebElement End_date_button;
	@FindBy(xpath="(//*[@placeholder='DD-MM-YYYY HH:mm'])[2]/following::div[2]/table /thead/tr/th[2]")
	public WebElement End_date_month;
	@FindBy(xpath="((//*[@placeholder='DD-MM-YYYY HH:mm'])[2]/following::div[2]/table /thead/tr/th[3])[1]")
	public WebElement End_date_nextmonth;
	@FindBy(xpath="(//*[@placeholder='DD-MM-YYYY HH:mm'])[2]/following::div[2]/table //*[contains(text(),'25')]")
	public WebElement endDate;
	
	@FindBy(xpath="//*[@name='promotionPolicy.operatorDisplayText']")
	public WebElement Operator_display_text_input;
	
	@FindBy(xpath="//*[@name='promotionPolicy.customerDisplayText']")
	public WebElement Customer_display_text_input;
	
	@FindBy(xpath="//*[@name='promotionPolicy.receiptPrintText']")
	public WebElement Receipt_Print_text_input;
	
	@FindBy(xpath="//*[@name='promotionPolicy.priority']")
	public WebElement Priority_input_Field;
	
	@FindBy(xpath="(//*[@name='promotionPolicy.sharability.isPromotionSharable'])[1]")
	public WebElement Yes_button;
	@FindBy(xpath="(//*[@name='promotionPolicy.sharability.isPromotionSharable'])[2]")
	public WebElement No_button;
	@FindBy(xpath="(//*[@name='promotionPolicy.sharability.isPromotionSharable'])[2]")
	public WebElement limitedShareButton;
	
	@FindBy(xpath="//*[@value='UNLIMITED']")
	public WebElement Unlimited_button;
	
	@FindBy(xpath="//*[@name='promotionPolicy.promotionRedemptionLimit']")
	public WebElement Redemption_Limit_Across_Transaction;
	
	@FindBy(xpath="//*[@name='promotionPolicy.redeemptionLimitPerUser']")
	public WebElement Redemption_Limit_Per_Transaction;
	
	@FindBy(xpath="//*[@name='promotionPolicy.maximumTrigger']")
	public WebElement Maximum_triggers_Per_Transaction;
	
	@FindBy(xpath="//*[@name='promotionPolicy.rewardLimit']")
	public WebElement Reward_Limit_Amount;
	@FindBy(xpath="//*[@name='promotionPolicy.limitedUse']")
	public WebElement limitedUse;
	@FindBy(xpath="//*[@name='promotionPolicy.sharability.totalShares']")
	public WebElement totalShares;
	
	@FindBy(xpath="//*[@name='promotionPolicy.redirectionUrl']")
	public WebElement Redirection_URL;
	
	@FindBy(xpath="//*[@name='promotionPolicy.termsAndConditions.0']")
	public WebElement Terms_And_Condition;
	
	@FindBy(xpath="//*[@name='promotionPolicy.offerImageUrl.0']")
	public WebElement Offer_Img_URL;
	
	@FindBy(xpath="//*[@name='promotionPolicy.offerGenre']")
	public WebElement Offer_Genre;
	
	@FindBy(xpath="//*[@name='promotionPolicy.supplementaryDetails']")
	public WebElement Supplementary_Details;
	
	
	//revathi
	
	@FindBy(xpath="//*[@name='multibuyEligbility.thresholdTypeCode']")
	public WebElement OfferCreation_Threshold_type;
	@FindBy(xpath="//*[@name='earnBurnEligibility.thresholdTypeCode']")
	public WebElement earnBurnThreshold;
	@FindBy(xpath="//*[@name='mtmbEligibility.packageMultibuyEligibility.0.thresholdTypeCode']")
	public WebElement mtmbThreshold;
	@FindBy(xpath="//*[contains(text(),'Threshold Type Code')]/following::div[1]/div[1]/div[1]/select")
	public WebElement thresholdSelectionAllPromo;
	@FindBy(xpath="//*[contains(text(),'Benefit Type')]/following::div[1]/div[1]//div[1]/select[1]")
	public WebElement OfferCreation_Benefit_type;
	@FindBy(xpath="//*[@name='earnBurnEligibility.benefit.benefitType']")
	public WebElement earnBurnBenefit_type;
	@FindBy(xpath="//*[contains(text(),'Benefit Type')]/following::div[1]/div[1]/div[1]/select")
	public WebElement allPromoBenefitType;
	@FindBy(xpath="//*[contains(text(),'Applicable on')]/following::div[1]/div[1]/select[1]")
	public WebElement allPromoPaymentSetting;
	@FindBy(xpath="//*[contains(text(),'Payment Threshold Amount')]/following::div[1]/div[1]/input")
	public WebElement allPromoPaymentThresholdAmountInput;
	@FindBy(xpath="//*[contains(text(),'Payment Mode')]/following::div[1]/div[1]/input")
	public WebElement allPromoPaymentMode;
	@FindBy(xpath="//*[contains(text(),'Provider')]/following::div[1]/div[1]/input")
	public WebElement allPromoPaymenBankProvider;
	@FindBy(xpath="//*[contains(text(),'Payment Type')]/following::div[1]/div[1]/input")
	public WebElement allPromoPaymentType;
	@FindBy(xpath="//*[contains(text(),'Inclusion Type')]/following::div[1]/div[1]/select[1]")
	public WebElement inclusionTypeSelection;
	
	@FindBy(xpath="//*[contains(text(),'Coupon Type')]/following::div[1]/div[1]/select[1]")
	public WebElement allPromoCouponSetting;
	@FindBy(xpath="//*[contains(text(),'Coupon Threshold Quantity')]/following::div[1]/div[1]/input")
	public WebElement allPromoCouponThresholdQty;
	@FindBy(xpath="//*[contains(text(),'Coupon ID')]/following::div[1]/div[1]/input")
	public WebElement allPromoCouponId;
	
	@FindBy(xpath="//div[text()='PriceModificationMethodCode']//preceding-sibling::select")
	public WebElement OfferCreation_price_Modification_Method_Loyalty_code;	
	@FindBy(xpath="//*[@id='item-555-instance-1_1_1_1_1_1_1_1_1_1']")
	public WebElement OfferCreation_expire_on;	
	@FindBy(xpath="//*[@id='item-556-instance-1_1_1_1_1_1_1_1_1_1']")
	public WebElement OfferCreation_expire_months;	
	@FindBy(xpath="//*[@id='item-557-instance-1_1_1_1_1_1_1_1_1_1']")
	public WebElement OfferCreation_expire_days;	
	@FindBy(xpath="//*[@id='item-558-instance-1_1_1_1_1_1_1_1_1_1']")
	public WebElement OfferCreation_expire_hours;	
	@FindBy(xpath="//*[@id='previousButtonId']")
	public WebElement OfferCreation_go_to_previous_detail;
	@FindBy(xpath="//*[contains(text(),'Submit')]")
	public WebElement OfferCreation_submit;
	@FindBy(xpath="(//*[@type='text'])[3]")
	public WebElement OfferCreation_product_id;
	@FindBy(xpath="//*[@id='sequence-68-instance-1']/div[1]/input")
	public WebElement OfferCreation_product_id_checkbox;
	
	@FindBy(xpath="//*[@name='multibuyEligbility.benefit.priceModificationMethodCode'] | //*[@name='groupMultibuyEligbility.benefit.priceModificationMethodCode'] | //*[@name='mtmbEligibility.packageMultibuyEligibility.0.benefit.priceModificationMethodCode'] | //*[@name='simplePromotionEligibility.benefit.priceModificationMethodCode']")
	public WebElement OfferCreation_price_Modification_Method_instant_discount_code;
	@FindBy(xpath="//*[@name='earnBurnEligibility.benefit.priceModificationMethodCode']")
	public WebElement earnBurnpriceModification;
	@FindBy(xpath="//*[contains(text(),'Price Modification Method Code')]/following::div[1]/div[1]/div[1]/select")
	public WebElement allPromopriceModification;
	
	@FindBy(xpath="//*[contains(text(),'is saved successfully')]")
	public WebElement offers_created_promo;
	@FindBy(xpath="//*[contains(text(),'is modified successfully.')]")
	public WebElement editConfirmation;
	
	@FindBy(xpath="//*[contains(text(),'Confirmation')]")
	public WebElement deleteConfirmationText;
	@FindBy(xpath="//*[contains(text(),'Yes')]")
	public WebElement deleteConfirmationYesButton;
	@FindBy(xpath="//*[@title='Delete offer']")
	public WebElement deleteOfferIcon;
	@FindBy(xpath="//*[@id='contained-modal-title-vcenter']")
	public WebElement deleteConfInfo;
	@FindBy(xpath="//*[@id='contained-modal-title-vcenter']/following::p[2]")
	public WebElement deletedPromoId;
	@FindBy(xpath="//*[contains(text(),'Ok')]")
	public WebElement OkAcknowledge;
	
	@FindBy(xpath="//*[contains(text(),'No promotions found')]")
	public WebElement noPromotionFoundResult;
	@FindBy(xpath="//*[contains(text(),'Promotion Found')]")
	public WebElement PromotionFoundResult;
	@FindBy(xpath="//*[@title='Edit offer']")
	public WebElement editOffer;
	@FindBy(xpath="//*[contains(text(),'Modify Offer')]")
	public WebElement mpdifyOffer;
	
	@FindBy(xpath="//*[contains(text(),'Advanced Search')]")
	public WebElement advanceSearch;
	@FindBy(xpath="//*[contains(text(),'Created By')]/parent::div/select")
	public WebElement createdBY;
	@FindBy(xpath="(//button[contains(text(),'Search')])[2]")
	public WebElement search;
	@FindBy(xpath="//*[@id='myTable']/tbody/tr/td[2]")
	public WebElement promotionId;
	@FindBy(xpath="//*[@id='offerSearchInput']")
	public WebElement offers_created_search;
	@FindBy(xpath="//*[contains(text(),'Configure Channel')]")
	public WebElement offerscreation_configure_channel;
	@FindBy(xpath="//span[contains(text(),'Croma')]/parent::li/span[2] | //span[contains(text(),'IHCL')]/parent::li/span[2]")
	public WebElement selectAllChannel;
	@FindBy(xpath="//*[@id='modalDivFrm']")
	public WebElement offerscreation_frame;
	@FindBy(xpath="//*[@id='search']")
	public WebElement offerscreation_search_channel;
	@FindBy(xpath="//*[contains(text(),'Online')]")
	public WebElement offerscreation_search_channel_online;
	@FindBy(xpath="//*[@id='buttonAddStorePopup']")
	public WebElement offerscreation_add_button_channel;
	@FindBy(xpath="//*[@name='promotionPolicy.promotionApplicableEligibility.promotionActivationEligibility.customerActivationRequired']")
	public WebElement offerscreation_collection;
	@FindBy(xpath="//*[@name='promotionPolicy.promotionApplicableEligibility.promotionActivationEligibility.activationValidity.promotionCollectionValidityData']")
	public WebElement offerscreation_collection_time;
	@FindBy(xpath="//*[@name='promotionPolicy.promotionApplicableEligibility.promotionActivationEligibility.activationValidity.months']")
	public WebElement offerscreation_collection_time_month;
	@FindBy(xpath="//*[contains(text(),'Add Eligibility')]")
	public WebElement offerscreation_add_beneficiary;

	@FindBy(xpath="(//label[text()='Merchandize Group Id']//following-sibling::div/input)[1] | (//*[contains(text(),'Selling Hierarchy Group Id')]/following::input)[1]")
	public WebElement OfferCreation_Merchant_id;
	@FindBy(xpath="//*[@id='plusAddImgPackageMerch-0']")
	public WebElement OfferCreation_Merchant_id_plus_icon;
	
	@FindBy(xpath="//*[@id='sequence-26-instance-1']/div[1]")
	public WebElement OfferCreation_merchant_id_checkbox;
	@FindBy(xpath="(//*[text()='Product ID']/following::input)[1]")
	public WebElement OfferCreation_promotionid;
	@FindBy(xpath="//*[contains(text(),'AutoOffer')]")
	public WebElement OfferCreated_success_promotionid;
	
	@FindBy(xpath="//*[contains(text(),'AutoOffer')]")
	public WebElement OfferCreation_product_id_IHCL;
	
	
	//6oct//revathi
	//croma
	@FindBy(xpath="(//*[contains(text(),'Hello')])[1]")
	public WebElement croma_hello;
	@FindBy(xpath="//*[contains(text(),'Login')]")
	public WebElement croma_Login;
	@FindBy(xpath="(//*[contains(text(),'Please enter')]/following::input)[2]")
	public WebElement croma_username;
	@FindBy(xpath="//*[contains(text(),'please enter')]/following::input")
	public WebElement croma_password;
	@FindBy(xpath="//*[@id='loginPhonePassword']")
	public WebElement croma_Login_phone;
	@FindBy(xpath="//*[contains(text(),'Confirm')]")
	public WebElement croma_Login_confirm;
	@FindBy(xpath="//*[contains(text(),'Product Id:')]//preceding-sibling::h2")
	public WebElement croma_prod_select;
	@FindBy(xpath="//*[contains(text(),'offers for you')]")
	public WebElement croma_offers_for_you;
	@FindBy(xpath = "//*[contains(text(),'offers for you')]//following-sibling::div/p")
	public List<WebElement> croma_offers;
	@FindBy(xpath="//*[contains(text(),'offers for you')]//preceding::button[@class='icon icon-close'][1]")
	public WebElement croma_close_offer;
	@FindBy(xpath="//*[contains(text(),'Add to cart')]")
	public WebElement croma_Add_to_cart;
	@FindBy(xpath="//*[@id='cart_count_notification']")
	public WebElement croma_cart_icon;
	@FindBy(xpath="//*[contains(text(),'CHECKOUT')]")
	public WebElement croma_click_checkout;
	@FindBy(xpath="//input[@name='shipFName']")
	public WebElement croma_address_firstname;
	@FindBy(xpath="(//*[contains(text(),'Last Name')]/following::input)[1]")
	public WebElement croma_address_lastname;
	@FindBy(xpath="(//*[contains(text(),'Address Type')]//following-sibling::div//textarea)[1]")
	public WebElement croma_flatno;
	@FindBy(xpath="(//*[contains(text(),'Address Type')]//following-sibling::div//textarea)[2]")
	public WebElement croma_landmark;
	@FindBy(xpath="(//*[contains(text(),'State')]/following::input)[1]")
	public WebElement croma_state;
	@FindBy(xpath="(//*[contains(text(),'City')]/following::input)[1]")
	public WebElement croma_city;
	@FindBy(xpath="//*[contains(text(),'select payment')]")
	public WebElement croma_payment;
	@FindBy(xpath="//*[contains(text(),'View all offers')]")
	public WebElement croma_view_all_offers;
	@FindBy(xpath = "//*[contains(text(),'OFFERS')]//following-sibling::div/div/div/label/span/span")
	public List<WebElement> croma_view_all_offers_payment;
	@FindBy(xpath="//*[contains(text(),'OFFERS')]//preceding::button[@class='icon icon-close'][1]")
	public WebElement croma_view_all_offer_close_offer;
	@FindBy(xpath="//*[contains(text(),'offer applied')]")
	public WebElement croma_offer_applied;
	@FindBy(xpath="//*[contains(text(),'offer applied')]/following::div")
	public WebElement croma_offer_applied_offer_name;
	@FindBy(xpath="//*[@id='offer-details']") public WebElement offerPageModalBox;
	@FindBy(xpath="//*[contains(text(),'Offers')]/following-sibling::div//*[contains(text(),'Shop Now')]") public WebElement heroBannerFirstOffer;	
	
	
	
	//Manoranjan
	@FindBy(xpath="//input[@name='contactemail']")
	public WebElement cromaAddressEmail;
	@FindBy(xpath="//input[@name='contactMobileNo']")
	public WebElement cromaAddressMobileNo;
	@FindBy(xpath="//input[@name='shipPinCode']")
	public WebElement cromaAddressPincode;
	@FindBy(xpath="//*[@alt='offer-img']") public WebElement aggregateBanner;
	@FindBy(xpath="//*[contains(text(),'Clear')]/preceding::span[1]") public WebElement aggregateOfferCount;
	
	@FindBy(xpath="(//*[contains(text(),'Selling Hierarchy Group Id')]/following::input)[1]")
	public WebElement OfferCreation_selling_id;
	@FindBy(xpath="(//*[contains(text(),'Free Text Type')]/following::input)[1]")
	public WebElement OfferCreation_freeText;
	@FindBy(xpath="//*[contains(text(),'Free Text Message')]/following::tbody/tr/td[3]/input")
	public WebElement OfferCreation_freeText_table_input;
	@FindBy(xpath="//*[contains(text(),'Free Text Message')]/following::tbody/tr/td[3]")
	public WebElement OfferCreation_freeText_table;
	
	@FindBy(xpath="//*[normalize-space(text())='Offers']/parent::a")
	public WebElement btnOfferZone;
	@FindBy(xpath="//*[normalize-space(text())='Offers & Bundles']| //*[normalize-space(text())='Offers & Super Savers']")
	public WebElement TxtOffersAndBundles;
	@FindBy(xpath="//*[normalize-space(text())='Filter by category']")
	public WebElement TxtFilterbyCtaegory;
	@FindBy(xpath="//*[contains(text(),'Sort by')]")
	public WebElement btnSortby;
	@FindBy(xpath="//*[text()='Buy Now']")
	public WebElement btnBuynow;
	@FindBy(xpath="//*[contains(text(),'ICICI payments')]/following::*[text()='View Details']")
	public WebElement btnViewDetails;
	@FindBy(xpath="//*[text()='Croma']")
	public WebElement TxtCroma;
	@FindBy(xpath="//*[text()='Stores Only']")
	public WebElement TxtStoresonly;
	@FindBy(xpath="//*[@data-testid='addtovault']")
	public WebElement btnSave;
	@FindBy(xpath="//*[contains(text(),'Promotion saved successfully')]")
	public WebElement savebuttonVAlidationText;
	@FindBy(xpath="(//*[@alt='offer-img']/following::div)[2]")
	public WebElement saveoffers;
	@FindBy(xpath="(//*[@alt='offer-img']/following::div)[4]")
	public WebElement saveoffersdesc;
	@FindBy(xpath="//*[contains(text(),'Sort')]//following::img")
	public WebElement savedoffers;
	@FindBy(xpath="(//*[contains(text(),'Sort by')]/following::*)[1]")
	public WebElement sortbyDropdown;
	@FindBy(xpath="//*[normalize-space(text())='Expiring soon']")
	public WebElement btnExpiringSoon;
	@FindBy(xpath="//*[normalize-space(text())='Popularity']")
	public WebElement btnPopularity;
	@FindBy(xpath="//*[@id='filter__b']/../..")
	public WebElement categoryFilter;

	
	@FindBy(xpath="//*[contains(text(),'Back to Offers Zone')]")
	public WebElement backtoOfferZoneCTA;
	@FindBy(xpath="//*[contains(text(),'CHANGE LOCATION')]")
	public WebElement changeLocationLable;
	@FindBy(xpath="//*[@id='googleSearchBox']")
	public WebElement locationSearchBox;
	@FindBy(xpath="//*[contains(text(),'Here’s what we found')]/parent::div/ul/li[1]")
	public WebElement locationREsults;
	@FindBy(xpath="//*[contains(text(),'Open')]")
	public WebElement storeOpenTime;
	@FindBy(xpath="//*[contains(text(),'Your location')]/following-sibling::div")
	public WebElement yourLocation;
	
	@FindBy(xpath="//*[text()='Used']")
	public WebElement usedtab;
	@FindBy(xpath="(//*[text()='Active']/following::button)[3]")
	public WebElement offerstab;
	@FindBy(xpath="//*[text()='Undo']")
	public WebElement undobutton;
	
	@FindBy(xpath="//*[@alt='offer-img']")
	public WebElement offerimage;
	
	@FindBy(xpath="//*[text()='Active']")
	public WebElement activetab;
	
	@FindBy(xpath="//*[contains(text(),'Categories')] | //*[contains(text(),'categories')] | //*[contains(text(),'category')]")
	public WebElement categories;
	
	@FindBy(xpath="//*[contains(text(),'Trending offers')] | //*[contains(text(),'Popular offers')] | //*[contains(text(),'Get rewarded in many ways')]")
	public WebElement popularheader;
	
	@FindBy(xpath="//*[contains(text(),'Recommended offers')] | //*[contains(text(),'Handpicked offers for you')]")
	public WebElement recommendedheader;
	
	@FindBy(xpath="//*[contains(text(),'Expiring soon')] | //*[contains(text(),'Offers Disappearing soon')] | //*[contains(text(),'Offers disappearing soon')] ")
	public WebElement expiringsoonheader;
	
	@FindBy(xpath="//*[contains(text(),'Explore Offers near you')] | //*[contains(text(),'Explore offers near you')]")
	public WebElement explorenearby;
	
	@FindBy(xpath="//*[@alt='hamberger-icon']")
	public WebElement menubutton;
	
	@FindBy(xpath="//*[text()='Sign out']")
	public WebElement signouttext;
	
	@FindBy(xpath="//*[text()='I’ll leave']")
	public WebElement iwillleavetext;
	
	//
	@FindBy(xpath="//*[contains(text(),'F&B')]/parent::div") public WebElement SelectServiceFnB;
	@FindBy(xpath="//*[contains(text(),'Offers on coffee & more')]") public WebElement starbuckOfferWidget;
	@FindBy(xpath="//*[contains(text(),'Offers on coffee & more')]/parent::div/following-sibling::div") public WebElement starbuckOfferSeeAll;
	@FindBy(xpath="//*[@id='offer-details']/div/div/section/section[3]/section[1]/div/label") public WebElement offerBrand;
	@FindBy(xpath="//*[@id='offer-details']/div/div/section/section[3]/section[2]/div/label") public WebElement offerDesc;
	@FindBy(xpath="//*[@id='offer-details']/div/div/section/section[3]/section[3]/div/span") public WebElement offerChannel;
	@FindBy(xpath="//*[@id='offer-details']/div/div/section/section[3]/section[4]") public WebElement offerExpiring;
	@FindBy(xpath="//*[@id='coupon-text']") public WebElement couponText;
	@FindBy(xpath="//*[contains(text(),'Copy')]") public WebElement copyCoupon;
	@FindBy(xpath="//*[@id='OZ_Offercard_CtaButton']| //*[@id='OZ_OZBanner_CtaButton']") public WebElement shopNowButton;
	@FindBy(xpath="//*[@id='offer-details']") public WebElement offerDetails;
	@FindBy(xpath="//button[@name='Offers']")public WebElement offerTab;
	@FindBy(xpath="//button[@name='All']")public WebElement AllTab;
	@FindBy(xpath="//button[@name='Bundle']")public WebElement BundleTab;
	
	@FindBy(xpath="//*[contains(text(),'Offer zone')]")public WebElement offerZoneWidgetHomepage;
	@FindBy(xpath="//*[contains(text(),'Offer zone')]/following::p[2]")public WebElement viewAllCTA;
	
	
	@FindBy(xpath="//*[contains(text(),'Brand')]/parent::div")
	public WebElement brandFilter;
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement checkboxfilter;
	@FindBy(xpath="//*[contains(text(),'Apply')]") public WebElement applyFilter;
	@FindBy(xpath="//*[contains(text(),'Ok')]") public WebElement OkButton;
	@FindBy(xpath="(//*[contains(text(),'Sort')]/preceding::input)[2] | //input[@class='sc-dHxeTU dBa-Dhb']") public WebElement serachOfferInputfiled;
	
	@FindBy(xpath="//*[@id='offers-parent-container']/div[1]/div/div[1]/label") public WebElement offerExpiry;
	@FindBy(xpath="//*[@id='offers-parent-container']/div[2]/div/div/div/div[2]") public WebElement bookmarkIcon;
	@FindBy(xpath="//*[@id='offers-parent-container']/div[2]/div/div/div/div[1]") public WebElement shareIcon;
	@FindBy(xpath="//*[@id='offers-parent-container']/div[1]/div/div[3]") public WebElement offerCTA;
	@FindBy(xpath="(//*[text()='Offers'])[2]")
	public WebElement activeOfferstab;
	@FindBy(xpath="//*[contains(text(),'Recent')]")
	public WebElement recent;
	@FindBy(xpath="//*[contains(text(),'Trending')]")
	public WebElement Trending;
	@FindBy(xpath="//*[contains(text(),'please try other sections')]")
	public WebElement noResult;
	@FindBy(xpath="//*[@id='homepage_tour_step_3']")
	public WebElement btnOfferZonePWaM;
	@FindBy(xpath="(//*[@style='cursor: pointer;'])[2]")
	public WebElement searchIconPWAM;
	@FindBy(xpath="//*[contains(text(),'Sort')]")
	public WebElement sortByPWAM;
	@FindBy(xpath="//*[@placeholder='Search']")
	public WebElement inutSearchBar;
	
	@FindBy(xpath="//*[contains(text(),'OFFER APPLIED')]")
	public WebElement offerApplied;
	@FindBy(xpath="//*[contains(text(),'OFFER APPLIED')]/following::button")
	public WebElement offerAppliedButton;
	@FindBy(xpath="//*[contains(text(),'OFFER APPLIED')]/parent::div/parent::div/following-sibling::div")
	public WebElement offerAppliedText;
	@FindBy(xpath="//*[contains(text(),'Download')]")
	public WebElement downloadInvoice;
	@FindBy(xpath="//*[contains(text(),'Balance amount payable')]/following::span[1]/div")
	public WebElement amountPayble_InvoicePage;
	@FindBy(xpath="//*[text()='Debit cards'] |( //*[text()='Debit card'])[2]")
	public WebElement DebitCardName;
	@FindBy(xpath="(//*[text()='Offers']/following::img[2])[2]")
	public WebElement removeOfferIcon;
	@FindBy(xpath="//*[text()='Clear']")
	public WebElement clearButton;
	@FindBy(xpath="//*[@data-testid='cross-icon-view']")
	public WebElement closeConfirmationPage;
	
	@FindBy(xpath="//*[contains(text(),'Valid')]") public WebElement offerValid;
	@FindBy(xpath="(//*[contains(text(),'Valid')]/parent::div[1])[1]/div/div[1]") public WebElement OfferbookmarkIcon;
	@FindBy(xpath="(//*[contains(text(),'Valid')]/parent::div[1])[1]/div/div[2]") public WebElement OffershareIcon;
	@FindBy(xpath="//*[@id='offers-parent-container']/div[1]/div/div[3]") public WebElement offerLink;
	@FindBy(xpath="//*[contains(text(),'Offers & Bundles')]/following::img[1]") public WebElement bookMarkIconOfferAndBundlePage;
	@FindBy(xpath="//*[contains(text(), 'Invoice')]") public WebElement Invoice_pg;
	@FindBy(xpath="//*[contains(text(), 'Invoice')]/following::div/div/div/span[contains(text(), 'Order')]") public WebElement Invoice_pg_order;
	@FindBy(xpath="//*[contains(text(), 'Invoice')]/following::div/div/div/span[2] | //*[contains(text(), 'Invoice')]/following::div/div/div/span[1]/following-sibling::*") public WebElement Invoice_pg_time;
	@FindBy(xpath="//*[contains(text(), 'Invoice')]/../following::div/span/div[2]/div") public List<WebElement> Invoice_list;
	@FindBy(xpath="//*[@data-testid='message-success']") public WebElement orderRecievedMessage;
	
	@FindBy(xpath="//button[@name='Offers']")
	public WebElement activeOfferstabpwam;
	@FindBy(xpath="(//*[@name='Offers']/following::img[2])[1]")
	public WebElement removeOfferIconPWAM;
	
	@FindBy(xpath="//*[@src='/etc.clientlibs/tcp-pwa/clientlibs/clientlib-react/resources/assets/share.svg']")
	public WebElement shareIconPWA;
	
    @FindBy(xpath="(//*[contains(text(),'Address')]/following::div[2])[1]")
    public WebElement Near_By_Store_Address_txtPWAM;
    @FindBy(xpath="//*[contains(text(),'View all offers')]")
	public WebElement btn_View_All_offersPWAM;
    @FindBy(xpath="//*[contains(text(),'Allow')]")
	public WebElement allowPopupPwaMobile;
    
    @FindBy(xpath="//*[contains(text(),'Login')]")
	public WebElement loginAirAssia;
    @FindBy(xpath="//*[contains(text(),'Done')]/parent::div/following::img[1]")
	public WebElement arrowIcon;
    @FindBy(xpath="(//input[@type='radio'])[last()-1]")
   	public WebElement selectPrice;
    @FindBy(xpath="//*[contains(text(),'Continue')]")
   	public WebElement btnContinue;
    
    @FindBy(xpath="//*[@data-testid='destination-field']")
   	public WebElement destinationField;
    @FindBy(xpath="//*[@data-testid='source-field']")
   	public WebElement sourceField;
    @FindBy(xpath="//*[contains(text(),'BOM')]")
   	public WebElement selectDestination;
    
    @FindBy(xpath="//*[@data-test='button-main-div')]")
   	public WebElement viewOrderDetails;
    @FindBy(xpath="//*[contains(text(),'Continue Shopping')]")
   	public WebElement continueShop;
    @FindBy(xpath="(//*[contains(text(),'Order History')])[2]")
   	public WebElement orderHis;

    @FindBy(xpath="//*[contains(text(),'Recent')]")
   	public WebElement RecentOrders;
    @FindBy(xpath="//*[contains(text(),'Order ID')]/parent::div/div[2]")
   	public WebElement orderid;
    @FindBy(xpath="(//*[contains(text(),'Board')])[2]")
   	public WebElement boardClick;
    
    @FindBy(xpath="(//*[@id='OZ_Filters_Title'])[1]")
   	public WebElement fliterByBrand;
    @FindBy(xpath="(//*[@id='OZ_Filters_Title'])[2]")
   	public WebElement fliterByCategory;
    @FindBy(xpath="(//*[@id='OZ_Filters_Title'])[3]")
   	public WebElement fliterByExpiring;
    @FindBy(xpath="(//*[@id='OZ_Filters_Title'])[4]")
   	public WebElement fliterByOfferType;
    @FindBy(xpath="(//*[@id='OZ_Filters_Title'])[5]")
   	public WebElement fliterBySubBrand;
    @FindBy(xpath="(//*[@id='OZ_Filters_Title'])[6]")
   	public WebElement fliterBySubCategory;
    @FindBy(xpath="//*[@id='modal-close-button']")
   	public WebElement closFilter;
    
    
    @FindBy(xpath="(//*[contains(text(),'Fly to')])[1]")
   	public WebElement flyTotext;
    @FindBy(xpath="(//button[contains(text(),'Save')])[1]")
   	public WebElement saveGuestDetails;
    @FindBy(xpath="(//button[contains(text(),'Save')])[1]")
   	public WebElement savePrimaryContactDetails;
    @FindBy(xpath="//button[contains(text(),'Continue To Add-ons')]")
   	public WebElement btnContinueToAdOne;
    @FindBy(xpath="//button[contains(text(),'Continue To Seat')]")
   	public WebElement btnContinueToSeat;
    @FindBy(xpath="//button[contains(text(),'Continue To Pay')]")
   	public WebElement btnContinueToPay;
    @FindBy(xpath="//*[@Class='nsspm-yes-btn']")
   	public WebElement clickOnYes;
    @FindBy(xpath="//*[@id='duplicate-c']/following::div[9]/div[3]/div/div/div/div/img")
   	public List<WebElement> seatToBeSelected;
    @FindBy(xpath="//*[contains(text(),'Total Amount')]/parent::div/div")
   	public WebElement totalAmount;
    @FindBy(xpath="//*[contains(text(),'Payable Balance')]/parent::div/div[2] | //*[contains(text(),'Total Fare')]/parent::div/div")
   	public WebElement payableBalance;
    @FindBy(xpath="//button[contains(text(),'Pay Now')]")
   	public WebElement btnPayNow;
    @FindBy(xpath="//*[contains(text(),'Tata Pay')]")
   	public WebElement TataPayMethod;
    @FindBy(xpath="//*[contains(text(),'Price Summary')]")
   	public WebElement PriceSummary;
    @FindBy(xpath="//*[contains(text(),'Yes')]/parent::button")
   	public WebElement yesButton;
    @FindBy(xpath="(//*[@class='sizeVariation_block'])[2]/div/button")
   	public WebElement selectSizeCliqPwam;
    @FindBy(xpath="//*[contains(text(),'Debit cards')]/following::*[19]") public WebElement checkedcard;
    @FindBy(xpath="//*[normalize-space(text())='Newly Arrived']")
	public WebElement btnnewlyArrived;
    @FindBy(xpath="//*[normalize-space(text())='Relevance']")
	public WebElement btnRelevance;
    
    //Bigbasket
    @FindBy(xpath="//*[contains(text(),'ADD TO BASKET')]/parent::div")
	public WebElement btnAddToBasket;
    
    @FindBy(xpath="//*[contains(text(),'Successfully added')]")
   	public WebElement productAddedText;
    @FindBy(xpath="(//*[contains(text(),'My Basket')])[2]")
   	public WebElement myBasket;
    @FindBy(xpath="//*[contains(text(),'View Basket & Checkout')]")
   	public WebElement viewbasketAndCheckout;
    @FindBy(xpath="//*[contains(text(),'CHECKOUT ')]")
   	public WebElement btnCheckout;
    @FindBy(xpath="//*[@id='finalTotal']")
   	public WebElement finalTotal;
    @FindBy(xpath="//*[contains(text(),'Total Amount Payable')]/following::span[2]")
   	public WebElement totalPayableAmount;
    
    @FindBy(xpath="//*[@title='Replicate offer']")
	public WebElement copyOfferIcon;
    @FindBy(xpath="//*[contains(text(),'Your Booking is confirmed!')]")
   	public WebElement bookingConfText;
    @FindBy(xpath="//*[contains(text(),'Booking Number')]/following::p[1]")
   	public WebElement bookingConPNRNumber;
    
    @FindBy(xpath="//*[@qa='addressBlogCKO']")
   	public WebElement selectAddress;
    @FindBy(xpath="//*[@qa='confirmSlotBtn']")
   	public WebElement proceedToPay;
    @FindBy(xpath="(//*[contains(text(),'Pay with Tata Pay App')])[2]")
   	public WebElement clickOnTataPay;
    @FindBy(xpath="(//*[contains(text(),'Place order & Pay')])[4]")
   	public WebElement placeOrderAndpay;
    @FindBy(xpath="//*[@title='Replicate offer']")
	public WebElement cloneOfferIcon;
    @FindBy(xpath="//*[contains(text(),'Replicate Offer')]")
   	public WebElement cloneOfferPage;
    
    @FindBy(xpath="//*[contains(text(),'Birthday offers')]")
	public WebElement birthdayOfferWidget;
    @FindBy(xpath="(//*[contains(text(),'Birthday')])[2]/parent::div/div/div/div/img")
	public WebElement birthdayOfferSaveIcon;
    @FindBy(xpath="//*[@id='brand_name']/div/div/label/input")
   	public WebElement autofilterStarbucks;
    @FindBy(xpath="//button[contains(text(),'Skip')]")
   	public WebElement skipButton;
    @FindBy(xpath="//*[contains(text(),'Order Summary')]")
   	public WebElement orderSummary;
    @FindBy(xpath="//*[contains(text(),'Net Amount')]/following::td")
   	public WebElement netAmount;
    @FindBy(xpath="//*[contains(text(),'Order Confirmation')]")
   	public WebElement confirmationHeader;
    @FindBy(xpath="//*[contains(text(),'Order ID')]/following::dd[1]")
   	public WebElement orderId;
    @FindBy(xpath="//*[contains(text(),'Payment details')]")
   	public WebElement paymentDetails;
    @FindBy(xpath="//*[contains(text(),'Payment method')]/following::span[1]")
   	public WebElement paymentMethods;
    @FindBy(xpath="//*[contains(text(),'Total Amount')]/following::dd")
   	public WebElement paidAmount;
    @FindBy(xpath="//*[@id='check-button-checked-a']")
   	public WebElement neuCoinsCheckBox;
    @FindBy(xpath="(//*[@style='cursor: pointer;'])[2]")
   	public WebElement clcikNeuPoints;
    @FindBy(xpath="//*[contains(text(),'Pay with Tata Pay')]/parent::div")
   	public WebElement tataPayOption;
    @FindBy(xpath="//*[contains(text(),'Continue')]/parent::div")
   	public WebElement tataPayContinue;
    
    @FindBy(xpath="//*[@qa='userAccount']/span")
   	public WebElement groceryLogin;
    @FindBy(xpath="//*[contains(text(),'Credit cards')]")
   	public WebElement CreditCardName;
    @FindBy(xpath="//*[contains(text(),'Credit cards')]/following::*[1]")
   	public WebElement CreditCardChecked;
    @FindBy(xpath="//*[contains(text(),'Avail now')]") public WebElement tataskyAvailNow;
    @FindBy(xpath="(//div[contains(@id,'backdirection')]/img)[2]") public WebElement backTatasky;
    @FindBy(xpath="//*[@id='OZ_OfferCard_OfferCta']") public WebElement shopNowProd;
    @FindBy(xpath="//*[contains(@src,'jpg')]") public List<WebElement> offerImages;
    @FindBy(xpath="//*[contains(text(),'generating')]") public WebElement couponCodeGeneration;
    @FindBy(xpath="//*[contains(text(),'No promotion')]") public WebElement noPromotionFound;
  
  
    //Aishwrya first may
    @FindBy(xpath="//*[contains(text(),'Exclusive offers')]") public WebElement homepageExclusiveOfferWidget;
    @FindBy(xpath="//*[@id='OZ_OfferCard_Image'][1]") public WebElement OfferCard;
    @FindBy(xpath="(//*[contains(text(),'Rewards')])[1]") public WebElement homepageRewardWidget;
    @FindBy(xpath="//*[contains(text(),'NeuPass exclusives')]") public WebElement ExclusiveOffer;
    @FindBy(xpath="//*[contains(text(),'See All')]") public WebElement ExclusiveSeeAll;
    @FindBy(xpath="//*[contains(text(),'Rewards')]|//*[contains(text(),'Neupass')][1]") public WebElement homepageNeupassWidget;
    @FindBy(xpath="//*[@id='OZ_OfferCard_Image'][1]") public WebElement GroceryOffer;
    @FindBy(xpath="//*[contains(text(),'Tata Shop Share Smile offers')]") public WebElement TataShopShareSmileoffers;
    @FindBy(xpath="//*[contains(text(),'Helios')][1]") public WebElement LogoHelios;
    @FindBy(xpath="(//a[@href='/logout'])[2]") public WebElement Logout;
    
    
    //Aishwrya 7th may
    @FindBy(xpath="//*[contains(text(),'Healthcare')]") public WebElement HealthcareValidation;
    @FindBy(xpath="//*[@id='OZ_Filters_MoreFiltersDiv']") public WebElement FilterCategory;
    @FindBy(xpath="//*[contains(text(),'Expiry date')]") public WebElement ExpiryDate;
    @FindBy(xpath="//*[contains(text(),'Expiring in 2+ weeks')]") public WebElement ExpiryDateValidation;
    @FindBy(xpath="(//*[contains(text(),'Apply')])") public WebElement ApplyButton;
    @FindBy(xpath="//*[@id='OZ_Search_InputContainer']") public WebElement SearchButton;
    @FindBy(xpath="(//*[local-name()='svg'])[4]") public WebElement SortByCategory;
    @FindBy(xpath="//*[contains(text(),'Expiring soon')]") public WebElement ExpiringSoon;
    @FindBy(xpath="//*[@class='style__Icon-sc-jnjagt-0 guShcv'][1]") public WebElement Saveoffer;
    @FindBy(xpath="//*[@id='OZ_Discovery_BookmarkIcon']") public WebElement SavedOffersValidation;
    @FindBy(xpath="(//*[contains(text(),'Active')])[1]") public WebElement Activetab;
    @FindBy(xpath="(//*[contains(text(),'Offers')])[3]") public WebElement ActiveOffersTab;
    @FindBy(xpath="//*[@id='OZ_OfferCard_TrashIconContainer'][1]") public WebElement RemoveOffer;
    //Aishwrya 13th may
    @FindBy(xpath="//*[contains(text(),'Electronics')][1]") public WebElement NavigateSlpElectronics;
    @FindBy(xpath="//*[contains(text(),'Products recommended for you')][1]") public WebElement ProductRecommendedForYou;
    @FindBy(xpath="//*[contains(text(),'From categories you like')][1]") public WebElement CategoriesWidget;
    @FindBy(xpath="//*[contains(text(),'Offers running out soon')][1]") public WebElement OffersOutSoon;
    @FindBy(xpath="//*[contains(text(),'Rainy day offers')][1]") public WebElement RainyOffers;
    @FindBy(xpath="//*[contains(text(),'Products for healthy living')][1]") public WebElement ProductsHealthyLiving;
    @FindBy(xpath="//*[contains(text(),'Grab these Croma exclusives')][1]") public WebElement GrabCromaOffers;
    @FindBy(xpath="//*[contains(text(),'Offers on limited stocks')][1]") public WebElement OffersLimited;
    @FindBy(xpath="//*[contains(text(),'Recommended for you')][1]") public WebElement RecommendedOffer;

    @FindBy(xpath="//*[contains(text(),'Grocery')]") public WebElement NavigateSlpGrocery;
    @FindBy(xpath="//*[contains(text(),'Handpicked offers for you')][1]") public WebElement HandpickedOffers;
    @FindBy(xpath="//*[contains(text(),'Handpicked offers for you')][1]") public WebElement SuperSaverOffers;
    @FindBy(xpath="//*[contains(text(),'Best-sellers corner')][1]") public WebElement BestSellerOffer;
    @FindBy(xpath="//*[contains(text(),'Trending products')][1]") public WebElement TrendingProduct;
    @FindBy(xpath="//*[contains(text(),'Products you love on discount')][1]") public WebElement ProductDiscount;
    @FindBy(xpath="//*[contains(text(),'Popular picks')][1]") public WebElement PopularPicks;

    @FindBy(xpath="//*[contains(text(),'Fashion')][1]") public WebElement NavigateSlpFashion;
    @FindBy(xpath="//*[contains(text(),'Offers for him')][1]") public WebElement OfferForHim;
    @FindBy(xpath="//*[contains(text(),'Offers for her')][1]") public WebElement OfferForHer;
    @FindBy(xpath="//*[contains(text(),'You may also like')][1]") public WebElement YouMayAlsoLike;
    @FindBy(xpath="//*[contains(text(),'From your favourite brands')][1]") public WebElement FavouriteBrands;
    @FindBy(xpath="//*[contains(text(),'Recommended Products based on Brand Affinity')][1]") public WebElement BrandAffinity;
    @FindBy(xpath="//*[contains(text(),'From your favourite categories')][1]") public WebElement FavouriteCategories;
    @FindBy(xpath="//*[contains(text(),'Recommended Products based on Category Affinity')][1]") public WebElement CategoryAffinity;
    @FindBy(xpath="//*[contains(text(),'Lifestyle store')][1]") public WebElement LifestyleStore;
    @FindBy(xpath="//*[contains(text(),'Monsoon must-haves')][1]") public WebElement MonsoonMustHaves;
    @FindBy(xpath="//*[contains(text(),'Fashion sale: min 50% off')][1]") public WebElement FashionSale;
    @FindBy(xpath="//*[contains(text(),'Special price store')][1]") public WebElement SpecialPriceStore;
    @FindBy(xpath="//*[contains(text(),'Westside stories')][1]") public WebElement WestsideStories;
    @FindBy(xpath="//*[contains(text(),'Fashion by Westside')][1]") public WebElement FashionWestside;

    @FindBy(xpath="//*[contains(text(),'Beauty')][1]") public WebElement NavigateSlpBeauty;
    @FindBy(xpath="//*[contains(text(),'Inspired by Browsing History')][1]") public WebElement InspiredHistory;
    @FindBy(xpath="//*[contains(text(),'Products recommended for you')][1]") public WebElement ProductsRecommendedForYou;
    @FindBy(xpath="//*[contains(text(),'Related items')][1]") public WebElement RelatedItems;
    @FindBy(xpath="//*[contains(text(),'From your favourite brands')][1]") public WebElement FromFavouriteBrands;
    @FindBy(xpath="//*[contains(text(),'Offers on beauty brands')][1]") public WebElement OfferBeautyBrands;
    @FindBy(xpath="//*[contains(text(),'From categories you like')][1]") public WebElement CategoriesYouLike;
    @FindBy(xpath="//*[contains(text(),'Best-selling products')][1]") public WebElement BestSellingProducts;
    @FindBy(xpath="//*[contains(text(),'Trending offers')][1]") public WebElement TrendingOffers;
    @FindBy(xpath="//*[contains(text(),'Top grooming offers for him')][1]") public WebElement TopGroomingOffers;
    @FindBy(xpath="//*[contains(text(),'Thoughtful gift sets')][1]") public WebElement ThougthfulGift;

    @FindBy(xpath="//*[contains(text(),'Entertainment')][1]") public WebElement NavigateSlpEntertainment;
    @FindBy(xpath="//*[contains(text(),'Bite-sized stories')][1]") public WebElement BiteSizedStories;
    @FindBy(xpath="//*[contains(text(),'Offers to keep you entertained')][1]") public WebElement OfferEntertained;
    @FindBy(xpath="//*[contains(text(),'Just in')][1]") public WebElement JustIn;

    @FindBy(xpath="//*[contains(text(),'Smartphones')][1]") public WebElement NavigateSlpSmartphone;
    @FindBy(xpath="//*[contains(text(),'New arrivals')][1]") public WebElement NewArrivals;
    @FindBy(xpath="//*[contains(text(),'Hot deals by category')][1]") public WebElement DealsByCategory;
    @FindBy(xpath="//*[contains(text(),'Inspired by Browsing History')][1]") public WebElement BrowsingHistory;
    @FindBy(xpath="//*[contains(text(),'Still looking for these?')][1]") public WebElement LookingForThese;
    @FindBy(xpath="//*[contains(text(),'Accessories for You')][1]") public WebElement AccessoriesForYou;
    @FindBy(xpath="//*[contains(text(),'Shop accessories by type')][1]") public WebElement ShopAccessories;
 
    @FindBy(xpath="//*[contains(text(),'Hotels')][1]") public WebElement NavigateSlpHotels;
    @FindBy(xpath="//*[contains(text(),'Travel inspiration for you')][1]") public WebElement TravelInspiration;
    @FindBy(xpath="//*[contains(text(),'Stays recommended for you')][1]") public WebElement RecommendedForYou;
    @FindBy(xpath="//*[contains(text(),'Offers in spotlight')][1]") public WebElement OffersSpotlight;
    @FindBy(xpath="//*[contains(text(),'You may also like')][1]") public WebElement YouMayLike;
    @FindBy(xpath="//*[contains(text(),'Trending Stays')][1]") public WebElement TrendingStays;
    @FindBy(xpath="//*[contains(text(),'Featured holidays & dining')][1]") public WebElement FeaturedHolidays;
    @FindBy(xpath="//*[contains(text(),'Most booked stays')][1]") public WebElement BookedStays;
    @FindBy(xpath="//*[@data-testid='error-msg']") public WebElement errorMessage;

    
    
}
