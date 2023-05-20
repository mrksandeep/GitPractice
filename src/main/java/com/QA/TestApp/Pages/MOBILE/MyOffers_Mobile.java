package com.QA.TestApp.Pages.MOBILE;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyOffers_Mobile extends BaseScript {


	public MyOffers_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	//for android element add "and" as prefix and for ios add "ios"

	//	Android Only


	@FindBy(id="com.tatadigital.tcp.dev:id/tvSharesLeft")public MobileElement andShareCount;

	@FindBy(className ="android.widget.ScrollView")public MobileElement andODPclassscroll;
	@FindBy(id="com.tatadigital.tcp.dev:id/llMainFrame")public MobileElement andFrametoScroll;

	@FindBy(xpath="//*[@text='Offers']") public MobileElement andOffersWidget;
	@FindBy(xpath="//*[@text='My Offers']") public MobileElement andMyOffers;
	@FindBy(xpath="//*[@text='USED']") public MobileElement andUsedOffersTab;
	@FindBy(xpath="//*[@text='ACTIVE']") public MobileElement andActiveOffersTab;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSavedOffersListTitle") public MobileElement andCountOffers;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferName") public List <MobileElement> andOffersShortDesc;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivSavedOffersImage") public List <MobileElement> andOffersImage;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnAddToVault") public MobileElement andAddtoVault;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnAddToVault") public MobileElement andAddedtoVault;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnCTAOne") public List<MobileElement> andViewDetail;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivVault") public MobileElement andVaultIcon;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvBrandName") public MobileElement andRedemOfferBrand;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferName") public MobileElement andRedemOfferTitle;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDateValue") public MobileElement andRedemOfferDate;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSavingsValue") public MobileElement andRedemOfferSaving;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnClose") public MobileElement andRedemOfferBtnClose;
	@FindBy(xpath="//*[@text='Please add vault if you wish to save the offer and view it later']") public MobileElement andMessageAddToVault;
	@FindBy(xpath="//*[@text='OK']") public MobileElement andOKbtn;
	@FindBy(xpath="//*[@text='Home']") public MobileElement andHomeWidget;
	@FindBy(id="com.tatadigital.tcp.dev:id/txtTitle") public MobileElement andOffersRunningOnSavedCardsTitle ;
	@FindBy(xpath="//*[@text='View All']") public MobileElement andViewAllOffersRunningOnSavedCards ;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferOnSavedCardTitle") public MobileElement andOfferTitleSavedCard;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferOnSavedCardDescription") public MobileElement andOfferShortDescSavedCard;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvNumberOfRunningOffer") public MobileElement andCountOffersSavedCard ;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnShare") public MobileElement andShareBtn;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivShareProgress")public MobileElement andSharedBtn;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnAddToVault") public MobileElement andAddToVault;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvShopNow") public MobileElement andShopNow;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferAvailContent") public MobileElement andHowToAvailContent;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferDetailsTAC") public MobileElement andTACDetail;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferChannel") public MobileElement andOfferChannel;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvCouponCode") public MobileElement andCouponCode;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMilestoneTitle") public MobileElement andMilestoneTitle;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMilestoneSubtitle") public MobileElement andMilestoneSubtitle;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMilestonesDescription") public MobileElement andMilestoneDesc;

	@FindBy(xpath="//*[@text='Added to Vault']") public MobileElement andAddedToVaultText;
	@FindBy(xpath="//*[@text='Add to Vault']") public MobileElement andAddToVaultText;
	@FindBy(xpath="//*[@text='offline']") public MobileElement andOffline;
	@FindBy(xpath="//*[@text='Near You']") public MobileElement andNearYou;
	@FindBy(xpath="com.tatadigital.tcp.dev:id/offerSearchView")public MobileElement andSearchText;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/btMyLocation']") public MobileElement andMyLocation;
	@FindBy(xpath="//*[@id='places_autocomplete_search_button']") public MobileElement andAutocompletePlacesSearch;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/places_autocomplete_search_input']") public MobileElement andAutocompletePlacesInput;
	@FindBy(xpath="//*[@text='USE MY CURRENT LOCATION']") public MobileElement andMYCurrentLocation;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/buttonSaveLocation']") public MobileElement andSaveLocation;
	@FindBy(xpath="//*[@contentDescription='My Location']") public MobileElement andMYLocation;
	@FindBy(xpath="//*[@id='back']") public MobileElement andPressBack;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvMessageNoStore']") public MobileElement andMessageNoStoreNearBy;
	//@FindBy(xpath=//*[@id='nearMeBrandContainer' and ./*[@text='Croma']])
	@FindBy(xpath="//*[@id='btnQrCode']")  public MobileElement andClickQRCodeBtn;
	@FindBy(xpath="//*[@text='ALLOW']") public MobileElement andAllowPermission;
	@FindBy(xpath="//*[@text='DENY']") public MobileElement andDenyPermission;

	@FindBy(id="com.tatadigital.tcp.dev:id/ivDiscovery") public MobileElement searchIconAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDiscoveryToolbarTitle") public MobileElement searchTextBoxAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivNearBy") public MobileElement nearByIcon_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDirectionBtn") public MobileElement directionCTA_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvCallBtn") public MobileElement callDialer_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvNoOfStores") public MobileElement noOfStore_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivBanner") public MobileElement heroBannerMain_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/titleTextView") public MobileElement openForYouOffer_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/shareCtaButton") public MobileElement shareIcon_Android;
	@FindBy(id="android:id/title") public MobileElement shareOption_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvViewOfferStores") public MobileElement viewAllStoreCTA_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/imgDirection']") public MobileElement viewAllStoreResult_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnAddToVault") public MobileElement addedToVault_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferDescription") public MobileElement offerDescription_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSingleOfferDuration") public MobileElement offerexpDate_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferChannel") public MobileElement offerChannel_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferStoreType") public MobileElement offerStoreType_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferAdditionalDescription") public MobileElement offerAdditionalDescription_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAvailPlaceholder") public MobileElement howToAvailOffer_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferDetailsTAC") public MobileElement offerDetailsTAC_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/img_single_offer_item") public MobileElement offerDetailsImg_Android;
	@FindBy(xpath="//*[@text='Transaction Details']") public List <MobileElement> transactionDetailsCTA_Android;
	@FindBy(xpath="//*[@text='View Details']") public List<MobileElement> viewDetailsCTA_Android;
	@FindBy(xpath="//*[@text='SAVING']") public List <MobileElement> savings_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnClose") public MobileElement closeBtn_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/etSearchContacts") public MobileElement searchContacts_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/shareToolbar") public MobileElement shareToolbar_Android;
	@FindBy(xpath="//*[@text='Share']") public MobileElement shareToMobile_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/viewGroupShareStatus") public MobileElement shareicon_Android;
	@FindBy(xpath="//*[contains(@text,'Brand')]")public MobileElement filterBrand_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPopularOffers")public MobileElement popular_offers_Text_Android;
	@FindBy(xpath="//*[normalize-space(text())='More Filter']")public MobileElement more_Filter_Button_Android;
	@FindBy(xpath="//*[contains(@text,'Category')]")public MobileElement categoryFilter_Android;
	@FindBy(xpath="//*[contains(@text,'Croma')]")public MobileElement brandNames_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnApply")public MobileElement applyButton_Android;
	@FindBy(id="com.google.android.dialer:id/digits")public MobileElement callDigits_Android;
	@FindBy(id="com.google.android.apps.maps:id/directions_startpoint_textbox")public MobileElement googleMapStartPont_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvStoreName']")public MobileElement storeName_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvAddress']")public MobileElement storeAddress_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvStoreDistance']")public MobileElement storeDistance_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/tvStoreTime']")public MobileElement storeOpenTime_Android;
	@FindBy(xpath="//*[contains(@text,'Others')]")public MobileElement profileOtherOption_Android;
	@FindBy(xpath="//*[contains(@text,'Offers')]")public MobileElement myAccountOffers_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/etOfferId")public MobileElement myAccountOfferId_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnOfferIdSubmit")public MobileElement myAccountOfferIdSubmit_Android;
	@FindBy(xpath="//*[contains(@text,'Offers Expiring Soon')]")public MobileElement expiringSoonOffers_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/template5ItemMain")public MobileElement expiringSoonOffersId_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/brandImageView']")public MobileElement expiringSoonOffersProduct_Android;
	@FindBy(xpath="//*[contains(@text,'Saved Card Offers')]")public MobileElement savedCardHome_Android;
	@FindBy(xpath="//*[contains(@text,'MTMB')]")public MobileElement savedCardOffer_Android;
	@FindBy(xpath="//*[contains(@text,'My Plans')]")public MobileElement featureListPlan_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/positiveButton")public MobileElement errorOkBtn_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose")public MobileElement InsuranceBackBtn_Android;
	@FindBy(xpath="//*[@content-desc='Saved Offers']")public MobileElement SavedOfferTab_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvBrandName") public MobileElement offerBrandName_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTitle")public  List <MobileElement> search_feature_result_Android;
	@FindBy(xpath="(//*[@resource-id='com.tatadigital.tcp.dev:id/btnCTAOne'])[2]")public  MobileElement limitedShareOffer_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivMoveToContent") public MobileElement searchResultIcon_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/layoutNoResultFound") public MobileElement noResult_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/cardViewMain']")public  MobileElement aggregateBannerHome_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/btnViewDetails']")public  MobileElement aggregateBannerViewDetails_Android;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='offers.discovery.offerEmptyTableViewCell']") public MobileElement aggregateBannerHome_IOS;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='View Details'])[1]") public MobileElement aggregateBannerViewDetail_IOS;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[contains(@value,'Found')])[1]") public MobileElement aggregateBannerOfferCount_IOS;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvChangeLocation")public MobileElement change_loc_label_Android;
	@FindBy(xpath = "//*[contains(@text,'DENY')]")public MobileElement deny_GPS_Android;
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")public MobileElement allow_GPS_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/locationSearchView")public MobileElement search_location_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/discoverySearchView")public MobileElement search_offer_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTitle")public  MobileElement search_offers_result_Android;	
	@FindBy(id="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")public List <MobileElement> search_results_location_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/recyclerViewAddress']") public MobileElement search_results_label_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/changeLocationBtn")public MobileElement change_loc_button_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/message")public MobileElement sry_no_str_message_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/changeLocationBtn")public MobileElement changeLocationBtn_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPopularOffers")public MobileElement showing_offerAndroid;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivBack']")public MobileElement back_page_Android;	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvYourLocation")public MobileElement your_location_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAddress")public MobileElement selected_location_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvStoreName")public MobileElement selected_store_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvNoOfStores")public MobileElement total_store_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvCallBtn")public MobileElement call_icon_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnViewDetails")public MobileElement view_details_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferTitle")public MobileElement offer_desc_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDiscoveryToolbarTitle")public MobileElement search_title_offer_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/recyclerViewAddress']/android.view.ViewGroup")public List <MobileElement> search_result_Android;
	@FindBy(xpath = "//*[contains(@name,'OFFERS')]")public MobileElement view_all_offer_page_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOfferDescription")public MobileElement offer_res_subdesc_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvViewAllOffers")public MobileElement view_alloffers_Android;
	@FindBy(xpath = "//*[contains(@name,'Find offers near your location')]")public MobileElement find_offers_nearby_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTitleName")public List <MobileElement> search_nearby_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnCTAOne")public MobileElement transaction_button_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDialogTitle")public MobileElement redeemtion_title_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTotalSavings")public MobileElement redeemtion_total_savings_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSavedOffersListTitle")public MobileElement saved_offer_count_Android;	
	@FindBy(id="com.tatadigital.tcp.dev:id/offerSearchView")public MobileElement search_offer_box_Android;
	@FindBy(xpath="//*[contains(@text,'Home')]")public MobileElement categoryNames_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/removeFromVaultButton']") public MobileElement removeVaultIcon_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivSavedOffersImage']")public MobileElement savedOfferndBundle_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivSavedOffersImage']/parent::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")public MobileElement savedOfferndBundleExpire_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivSavedOffersImage']/parent::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")public MobileElement savedOfferndBundleName_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/btnCTAOne']")public MobileElement savedOfferndBundleCTA_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/numOfOffers") public MobileElement savedOfferAndBundleCount_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/bottom_vault") public MobileElement vaultAndroid;
	// ios Only 	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=Used']") public MobileElement andUsedOffersTab_IOS;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=Active']") public MobileElement andActiveOffersTab_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add to vault']") public MobileElement addToVault_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Nearby']") public MobileElement nearByIcon_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Shop Now']") public MobileElement shopnow_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='My Offers']") public MobileElement offers_tab_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Active']") public MobileElement Active_tab_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='View Details']") public List <MobileElement> view_details_actve_offer_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Save']") public MobileElement add_vault_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Promotion saved successfully.']") public MobileElement promotion_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.brandNameLabel']") public MobileElement offer_title_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.productNameLabel']") public MobileElement offer_description_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.expiryLabel']") public MobileElement offer_expiry_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Stores Only'] | //XCUIElementTypeStaticText[@name='APP Only'] | //XCUIElementTypeStaticText[@name='Stores and Online']") public MobileElement offer_channel_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.OfferDetail.cancelButton']") public MobileElement close_offer_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.TermsAndConditionTableViewCell.termsAndConditionLabel']") public MobileElement TAC_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.TermsAndConditionTableViewCell.howToAvail']") public MobileElement howtoavail_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.OfferInfoTableViewCell.shareButton']") public MobileElement share_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='tcpApp.findAddress.searchTextField']") public MobileElement search_box_limited_share_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='chevronLeft']") public MobileElement close_limited_share_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='app.contactsViewController.shareButton']") public MobileElement limited_share_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Left')]") public MobileElement limited_share_count_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='Mail']/XCUIElementTypeOther/XCUIElementTypeImage") public MobileElement Ulimited_share_mail_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='Messages']/XCUIElementTypeOther/XCUIElementTypeImage") public MobileElement Ulimited_share_message_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='AirDrop']/XCUIElementTypeOther/XCUIElementTypeImage") public MobileElement Ulimited_share_airdrop_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.home.scanButton']") public MobileElement search_icon_IOS;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField") public MobileElement search_box_text;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Brand')]") public MobileElement brand_label;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.discoveryFilter.filterCatecotyLabel']") public MobileElement click_brand;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'croma')]") public MobileElement select_brand;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='offers.discoveryFilter.filterResetButton']") public MobileElement reset;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='offers.discoveryFilter.filterApplyButton']") public MobileElement apply;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Showing')]") public MobileElement showing;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Category')]") public MobileElement category_label;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.discoveryFilter.filterCatecotyLabel']") public MobileElement click_category;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Cameras')]") public MobileElement select_category;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Offer Type')]") public MobileElement more_filter_label;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='offers.discoveryFilter.filterCatecotyLabel'])[3]") public MobileElement click_more_filter;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'MTMB')]") public MobileElement select_more_filter;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconCircleCross']") public MobileElement dismiss_filter;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.changeLocation.navigationTitleLabel']") public MobileElement near_by_change_location_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField") public MobileElement search_location_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='SEARCH RESULTS']") public MobileElement Search_results_ios;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.changeLocation.placesPredictionTableViewCellTitleLabel']") public List <MobileElement> search_results_location_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.allOffersOnSelectedLocation.yourLocationLabel']") public MobileElement yourLocation_label_ios;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.allOffersOnSelectedLocation.selectedLocationLabel']") public MobileElement selectedLocation_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'STORES FOUND')]") public MobileElement selectedtotal_stores_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Change']") public MobileElement change;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='offers.discovery.changeLocation']") public MobileElement change_location;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='My location']") public MobileElement mylocation;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='NO STORES FOUND']") public MobileElement no_store;	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='offers.discoverySearch.recentAndTrendingSearchLabel'])[1]") public MobileElement near_by_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'POPULAR OFFERS')]") public MobileElement popular_offers;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='backLarge']") public MobileElement back_icon_search_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.discoverySearch.searchTitleLabel']") public MobileElement search_offers_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[contains(@value='Search')]") public MobileElement search_box_enter_text;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TRENDING']") public MobileElement trending_search_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'View Details')]") public MobileElement view_details_search_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='callIcon']") public MobileElement callIcon_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.allOffersOnSelectedLocation.storeAddressLabel']") public MobileElement AddressLabel_search_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='directionIcon']") public MobileElement directionIcon_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='offers.allOffersOnSelectedLocation.allOffersTableViewCell']") public MobileElement view_all_offers_button;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.StoreNearMeTitleTableViewCell.storeNearMeLabel']") public MobileElement store_near_me_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.HTMLSupplimentaryDetailTableViewCell.supplimentaryLabel']") public MobileElement supplimentaryLabel_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Additional Details']") public MobileElement Additional_details__ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='offers.allOffersOnSelectedLocation.offerSubtitleLabel'])[1]") public MobileElement search_offer_subtitle__ios;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.allOffersOnSelectedLocation.offerSubtitleLabel']") public MobileElement search_offer_subtitle_third_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.SavedOfferCardTableViewCell.viewDetailsButton']") public List <MobileElement> transaction_details_button_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Used']") public MobileElement used_offer_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'OFFER')]") public MobileElement used_offer_count_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.RedemtionDetailsViewController.redemtionDetailLabel']") public MobileElement redeemtion_label_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.RedemtionDetailsViewController.brandDescriptionLabel']") public MobileElement redeemtion_brand_descriptionlabel_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.RedemtionDetailTableViewCell.savingLabel']") public MobileElement redeemtion_savinglabel_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.RedemtionDetailTableViewCell.dateLabel']") public MobileElement redeemtion_datelabel_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.RedemtionDetailsViewController.okButton']") public MobileElement redeemtion_ok_button_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.RedemtionDetailsViewController.brandNameLabel']") public MobileElement redeemtion_brand_name_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='TCPApp.RedemtionDetailsViewController.brandNameLabel'])[2]") public MobileElement redeemtion_total_savings_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='offers.discoverySearch.discoverySearchBar']") public MobileElement edit_search_box_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='RECENT SEARCH']") public MobileElement recent_search_ios;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.SavedOfferCardTableViewCell.titleLabel']") public List <MobileElement> vault_offer_expiry_title_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Browse Products'] | //XCUIElementTypeStaticText[@name='Buy Now'] | //XCUIElementTypeStaticText[@name='Book Now']") public MobileElement button_vault_offer_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='FOR YOU']") public MobileElement for_you_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Offers Expiring Soon')]") public MobileElement home_page_offer_expiring_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='tcpApp.home.templateSixBrandName']") public MobileElement swipe_offer_home_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='tcpApp.home.templateSixBrandName']") public List <MobileElement> expire_offer_ios;
	//XCUIElementTypeStaticText[@name="tcpApp.home.templateSixBrandName"]
	@FindBy(xpath = "//XCUIElementTypeImage[@name='TCPApp.OfferInfoTableViewCell.addToVaultImage']") public MobileElement added_vault_IOS;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='tcpApp.home.myAccountView']") public MobileElement account_profile_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Others']") public MobileElement others_profile_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Offers']") public MobileElement offers_profile_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField") public MobileElement textbox_profile_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='View Details']") public MobileElement offers_profile_view_details_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.StoreNearMeTitleTableViewCell.storeNearMeLabel']") public MobileElement offers_stores_near_me_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='View']") public MobileElement offers_stores_near_me_view_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='tcpApp.home.templateSixCell']") public MobileElement swipe_offer_homepage;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='backLarge']") public MobileElement close_search_page_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='offers.discoverySearch.backButton']") public MobileElement close_search_discovery_page_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']") public MobileElement close_search_feature_page_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Plans']") public MobileElement search_feature_page_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='OK']") public MobileElement search_feature_page_OK_IOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Cancel']") public MobileElement call_cancel_IOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='offers.selectedStoreOffers.callTextButton']") public MobileElement callIcon_viewpage_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='offers.selectedStoreOffers.directionButton']") public MobileElement directionIcon_viewpage_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='tcpApp.home.templateSixBrandName']") public MobileElement saved_offer_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Saved Card Offers')]") public MobileElement home_page_saved_offer_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.selectedStoreOffers.offersStoreAddressLabel']") public MobileElement AddressLabel_viewall_search_ios;
	@FindBy(id = "com.tatadigital.tcp.dev:id/filterBrand") public MobileElement Near_Me_Offer;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPopularOffers") public MobileElement Near_Me_Offer_Search_Text;
	@FindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Description\"])[3]") public MobileElement My_pan_cursor;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnViewDetails") public MobileElement View_Details_For_Tending_Today;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnViewDetails") public MobileElement Plan_Under_Recent_Search;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement Profile_page_Button;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBasicDetails") public MobileElement Me_at_a_Glance_in_profile_Page;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvRowTitle") public MobileElement Payment_Methods_In_header;
	//Akshya
	@FindBy(xpath="//*[contains(@text,'Recommended Category Offers')]")public MobileElement RecomendeCategorydOffers_Android;
	@FindBy(xpath="//*[contains(@text,'Recommended Brand Offers')]")public MobileElement RecomendeBranddOffers_Android;
	@FindBy(xpath="//*[contains(@text,'Recommended Offers')]")public MobileElement Recomended_Offers_Android;
	@FindBy(xpath="//*[contains(@text,'Offers You May Like')]")public MobileElement OfferYouMAyLike_Android;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Recommended Brand Offers')]") public MobileElement home_page_Recommend_brand_offer_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Recommended Offers')]") public MobileElement home_page_Recommended_offer_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Offers You May Like')]") public MobileElement home_page_Offers_You_May_Like_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Recommended Category Offers')]") public MobileElement home_page_Recommended_Category_Offers_ios;
	@FindBy(xpath="//*[contains(@text,'Offer Type')]")public MobileElement More_Filter_Button_Android;
	@FindBy(xpath="//*[contains(@text,'MTMB')]")public MobileElement Offer_type_Android;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/ivOfferBigImage']")public List<MobileElement> OfferTypes_Android;
	@FindBy(xpath="//*[contains(@text,'Look!')]")public MobileElement look_offer_Android;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Look!')]") public MobileElement Look_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='offers.discoveryFilter.filterCatecotyLabel'])[3]") public MobileElement catrgory_more_filter_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='tcpApp.home.templateSixMainTitle'])[1]") public MobileElement Top_widget_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='filterIcon']") public MobileElement Filter_ios;
	@FindBy(id = "com.tatadigital.tcp.dev:id/filterIcon") public MobileElement Filter_Android;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Iâ€™ll leave')]") public MobileElement sign_out_yes_ios;
	@FindBy(xpath="//*[contains(@text,'Iâ€™ll leave')]")public MobileElement sign_out_yes_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/positiveButton") public MobileElement signoutButton_android;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Sign Out')]") public MobileElement Sign_out_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='TCPApp.SavedOfferCardTableViewCell.deleteButton'])[1]") public MobileElement removeVault_Ios;

	//Offer CatagoryLandingPage Android
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPageTitle") public MobileElement CategoryLandingPagePageTitleAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/backButton") public MobileElement CategoryLandingPageBackButtonAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/bookmarkIcon") public MobileElement CategoryLandingPageBookMarkIconAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/searchIcon") public MobileElement CategoryLandingPageSearchIconAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/sortByButton") public MobileElement CategoryLandingPageSortAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/filterButton") public MobileElement CategoryLandingPageFilterAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivCrossButton") public MobileElement CategoryLandingPageCloseFilterAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/sortRadioGroup']/android.widget.RadioButton[1]")public MobileElement sortByRelevanceAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/sortRadioGroup']/android.widget.RadioButton[2]")public MobileElement sortByPopularityAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/sortRadioGroup']/android.widget.RadioButton[3]")public MobileElement sortByNewlyArrivedAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/sortRadioGroup']/android.widget.RadioButton[4]")public MobileElement sortByExpiringAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/likeDislikeCtaButton']")public MobileElement categoryBasedOfferLikeDislikeButtonAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/offerCardImageView']")public MobileElement categoryBasedOfferCardImageAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/offerExpiryTextView']")public MobileElement categoryBasedOfferExpiryTextViewAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/offerTitleTextView']")public MobileElement categoryBasedOfferTitleTextViewAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/mainCtaButton']")public MobileElement categoryBasedOfferGetCouponCTAAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/shareCtaButton']")public MobileElement categoryBasedOfferShareCTAAndroid;

	//Offers & Bundles Page Android

	@FindBy(id = "com.tatadigital.tcp.dev:id/btnSavedOffers") public MobileElement OffersAndBundlesPageSavedOfferButtonAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnBackOfferZone") public MobileElement OffersAndBundlesPageBackButtonAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvOfferZoneTitle") public MobileElement OffersAndBundlesPageTitleAndroid;
	@FindBy(xpath = "//*[@content-desc='Offers']")public MobileElement OffersAndBundlesPageOffersTabAndroid;
	@FindBy(xpath = "//*[@content-desc='Bundles'] | //*[@text='Bundles']")public MobileElement OffersAndBundlesPageBundlesTabAndroid;
	@FindBy(xpath = "//*[@content-desc='See all']")public MobileElement OffersAndBundlesPageSeeAllButtonAndroid;
	@FindBy(xpath = "//*[@content-desc='Electronics']")public MobileElement OffersAndBundlesPageCategoryElectronicsAndroid;
	@FindBy(xpath = "//*[@content-desc='Travel']")public MobileElement OffersAndBundlesPageCategoryTravelAndroid;
	@FindBy(xpath = "//*[@content-desc='Grocery']")public MobileElement OffersAndBundlesPageCategoryEssentialsAndroid;
	@FindBy(xpath = "//*[@content-desc='Fashion']")public MobileElement OffersAndBundlesPageCategoryFashionAndroid;
	@FindBy(xpath = "//*[@content-desc='Beauty']")public MobileElement OffersAndBundlesPageCategoryBeautyAndroid;
	@FindBy(xpath = "//*[@content-desc='Sports']")public MobileElement OffersAndBundlesPageCategorySportsAndroid;
	@FindBy(xpath = "//*[@content-desc='Hotels']")public MobileElement OffersAndBundlesPageCategoryHotelsAndroid;
	@FindBy(xpath = "//*[@content-desc='Flights']")public MobileElement OffersAndBundlesPageCategoryFlightsAndroid;
	@FindBy(xpath = "//*[@content-desc='F&B']")public MobileElement OffersAndBundlesPageCategoryFnBAndroid;
	@FindBy(xpath = "//*[@resource-id='spa-root']/android.view.View[3]/android.view.View[1]")public MobileElement OffersAndBundlesPageHeroBannerOfferAndroid;
	@FindBy(xpath = "//*[@resource-id='spa-root']/android.view.View[3]/android.view.View[2]")public MobileElement OffersAndBundlesPageHeroBannerSwipeDot1Android;
	@FindBy(xpath = "//*[@resource-id='spa-root']/android.view.View[3]/android.view.View[3]")public MobileElement OffersAndBundlesPageHeroBannerOfferSwipeDot2Android;
	@FindBy(xpath = "//*[@resource-id='spa-root']/android.view.View[3]/android.view.View[1]/android.view.View/android.view.View")public MobileElement OffersAndBundlesPageClickOfferCardAndroid;
	@FindBy(xpath = "//*[contains(@text,'Popular')]")
	public MobileElement OffersAndBundlesPagePopularOfferWidgetAndroid;
	@FindBy(xpath = "//*[contains(@text,'Popular')]/following::android.view.View[1]")
	public MobileElement OffersAndBundlesPagePopularOfferWidgetSeeAllAndroid;
	@FindBy(xpath = "//*[contains(@text,'Recommended')]")
	public MobileElement OffersAndBundlesPageRecommendedOfferWidgetAndroid;
	@FindBy(xpath = "//*[contains(@text,'Recommended')]/following::android.view.View[1]")
	public MobileElement OffersAndBundlesPageRecommendedOfferWidgetSeeAllAndroid;
	@FindBy(xpath = "//*[contains(@text,'Expiring soon')]")
	public MobileElement OffersAndBundlesPageExpOfferWidgetAndroid;
	@FindBy(xpath = "//*[contains(@text,'Expiring soon')]/following::android.view.View[1]")
	public MobileElement OffersAndBundlesPageExpOfferWidgetSeeAllAndroid;
	//Near By Offers
	@FindBy(xpath = "//android.view.View[@content-desc='Explore offers near you']")public MobileElement offersAndBundlesPageNearByButtonAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvDiscoveryToolbarTitle']")public MobileElement offersAndBundlesPageNearByPageHeaderAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/offerZoneBtn") public MobileElement backFromNearByPageAndroid;

	//Brand Page
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")public MobileElement BrandPageNavigateUpIconAndroid;
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']/following::android.widget.TextView[1]")public MobileElement BrandPageTCPHeaderAndroid;
	//Home Page Android
	@FindBy(xpath = "//*[@content-desc='Home']")public MobileElement HomePageHomeIconAndroid;

	@FindBy(xpath = "//*[@content-desc='Offer Zone'] | //*[@text='Offer zone'] | //*[@resource-id='com.tatadigital.tcp.dev:id/bottom_offers'] | //*[@text='Offers']")public MobileElement HomePageOfferZoneIconAndroid;

	//		@FindBy(xpath = "//*[@content-desc='Offer Zone'] | //*[@text='Offer zone']")public MobileElement HomePageOfferZoneIconAndroid;

	@FindBy(xpath = "//*[@content-desc='Search']")public MobileElement HomePageSearchIconAndroid;
	@FindBy(xpath = "//*[@content-desc='UMag']")public MobileElement HomePageUMagIconAndroid;
	@FindBy(xpath = "//*[@content-desc='Vault']")public MobileElement HomePageVaultIconAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivHamburgerMenu") public MobileElement HomePageMenuButtonAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnChannelAlert") public MobileElement HomePageChannelAlertButtonAndroid;

	//Search Page Android
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement SearchPageTitleAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivClose") public MobileElement SearchPageCloseButtonAndroid;

	//Welcome Page Android
	@FindBy(id = "com.tatadigital.tcp.dev:id/txtLetsStart") public MobileElement WelcomePageLetsStartButtonAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/mobileNumberEditText") public MobileElement WelcomePagePhoneNumberFieldAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/otpPinView") public MobileElement WelcomePageOTPFieldAndroid;
	@FindBy(id = "com.android.packageinstaller:id/permission_deny_button") public MobileElement WelcomePageLocationDenyAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/skipTourTextView']")public MobileElement WelcomePageSkipTourAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/mobileConfirmButton") public MobileElement WelcomePageConfirmButtonAndroid;
	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button") public MobileElement WelcomePageLocationAllowAndroid;
	@FindBy(id = "com.google.android.gms:id/cancel") public MobileElement WelcomePageAutoPopupNopAndroid;

	//Search offer Page Android
	@FindBy(id = "com.tatadigital.tcp.dev:id/etSearchOffers") public MobileElement searchBarAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnBack") public MobileElement navigateBackFromSearchPageAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/layoutNoResultFound") public MobileElement searchPageNoResultFoundAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvNoResultFound") public MobileElement searchPageNoResultFoundTextAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvNoFindKeyword") public MobileElement searchPageNoResultFoundTextKeyWordAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/offerHeaderTitleTextView") public MobileElement searchPageResultFoundAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clearCTALink") public MobileElement searchPageClearCTAAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvHeaderTitle']") public MobileElement searchPageTrendingTitleAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/trendingChipGroup']/android.widget.Button") public List <MobileElement> searchPageTrendingItemsAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/splCard']") public MobileElement searchPageQRCodeScanAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/splCard']") public MobileElement searchPagesuggestedOffersAndroid;


	// Saved Offers & Bundles Page Android
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnBackSavedOffers") public MobileElement backButtonOfSavedOfferAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvSavedOffersTitle") public MobileElement SavedOfferPageTitleAndroid;
	@FindBy(xpath = "//*[@content-desc='Active']")public MobileElement savedOfferPageActiveTabAndroid;
	@FindBy(xpath = "//*[@content-desc='Used']")public MobileElement savedOfferPageUsedTabAndroid;
	@FindBy(xpath = "//*[@content-desc='All']")public MobileElement savedOfferPageAllTabAndroid;
	@FindBy(xpath = "//*[@content-desc='Offers']")public MobileElement savedOfferPageOffersTabAndroid;
	@FindBy(xpath = "//*[@content-desc='Bundles']")public MobileElement savedOfferPageBundlesTabAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnUndo") public MobileElement OfSavedOfferUndoButtonAndroid;
	//Home Page IOS
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Offer Zone'] | //XCUIElementTypeButton[@name='Offers']") public MobileElement HomePageOfferZoneIconIos;
	//Offers And Bundles Page IOS
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.selectedStoreOffers.navigationBarTitleLabel']") public MobileElement OffersAndBundlesPageTitleIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='unfilledBookmark']") public MobileElement OffersAndBundlesPageSavedOfferIconIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Offers']") 
	public MobileElement OffersAndBundlesPageOffersTabIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Bundles']") 
	public MobileElement OffersAndBundlesPageBundlesTabIos;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Electronics']") 
	public MobileElement OffersAndBundlesPageFilterByCategoryElectronicsIos;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Travel']") 
	public MobileElement OffersAndBundlesPageFilterByCategoryTravelIos;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Essentials']") 
	public MobileElement OffersAndBundlesPageFilterByCategoryEssentialsIos;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Fashion']") 
	public MobileElement OffersAndBundlesPageFilterByCategoryFashionIos;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Beauty']") 
	public MobileElement OffersAndBundlesPageFilterByCategoryBeautyIos;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Sports']") 
	public MobileElement OffersAndBundlesPageFilterByCategorySportsIos;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Hotels']") 
	public MobileElement OffersAndBundlesPageFilterByCategoryHotelsIos;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Flights']") 
	public MobileElement OffersAndBundlesPageFilterByCategoryFlightsIos;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='F&B']") 
	public MobileElement OffersAndBundlesPageFilterByCategoryFnBIos;


	//Category landing page
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Electronics']") 
	public MobileElement CLPageTitleIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='backLarge']") 
	public MobileElement CLPageBackButtonIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='unfilledBookmark']") 
	public MobileElement CLPageSavedToVaultIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='searchIcon']") 
	public MobileElement CLPageSearchIconIos;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='offers.discoverySearch.discoverySearchBar']") 
	public MobileElement CLPageSearchBar;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='offers.discoverySearch.userSearchResultTableViewCell']") 
	public MobileElement CLPageAutoSuggestOffer;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='backLarge']/parent::XCUIElementTypeOther[1]/following::XCUIElementTypeTable/XCUIElementTypeOther[1]") 
	public MobileElement CLPSearchResultIOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='backLarge']/parent::XCUIElementTypeOther[1]/following::XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[3]") 
	public MobileElement CLPSearchResultOfferClickIOS;
	//Offers Details Page
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.OfferDetail.cancelButton']") 
	public MobileElement ODPCloseButtonIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.productNameLabel']") 
	public MobileElement ODPProductNameIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.brandNameLabel']") 
	public MobileElement ODPBrandNameIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.expiryLabel']") 
	public MobileElement ODPExpiringDetilsIOS;

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Sort By')]") 
	public MobileElement CLPageSortIconIos;
	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Filter')]") 
	public MobileElement CLPageFilterIconIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='searchIcon']/parent::XCUIElementTypeOther[1]/following::XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeImage[1]") 
	public MobileElement CLPageOfferImageIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='searchIcon']/parent::XCUIElementTypeOther[1]/following::XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[2]") 
	public MobileElement CLPageSaveOfferToVaultIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='searchIcon']/parent::XCUIElementTypeOther[1]/following::XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]") 
	public MobileElement CLPageOfferExpireIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='searchIcon']/parent::XCUIElementTypeOther[1]/following::XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]") 
	public MobileElement CLPageOfferBenifitTypeIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='searchIcon']/parent::XCUIElementTypeOther[1]/following::XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[2]") 
	public MobileElement CLPageGetCouponButtonIos;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sort By']/following::XCUIElementTypeTable/XCUIElementTypeCell[1]") 
	public MobileElement CLPageSortByRelevanceIos;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sort By']/following::XCUIElementTypeTable/XCUIElementTypeCell[2]") 
	public MobileElement CLPageSortByPopularityIos;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sort By']/following::XCUIElementTypeTable/XCUIElementTypeCell[3]") 
	public MobileElement CLPageSortByNewlyArrivedIos;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sort By']/following::XCUIElementTypeTable/XCUIElementTypeCell[4]") 
	public MobileElement CLPageSortByExpiringSoonIos;
	//Saved Offers and Bundles Page
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Undo']") 
	public MobileElement savedOfferAndBundlesPageUndoButtonIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='offers.selectedStoreOffers.backButton']") 
	public MobileElement savedOfferAndBundlesPageBackButtonIos;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.selectedStoreOffers.navigationBarTitleLabel']") 
	public MobileElement savedOfferAndBundlesPageTitleIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Active']") 
	public MobileElement savedOfferAndBundlesPageActiveTabIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Used']") 
	public MobileElement savedOfferAndBundlesPageUsedTabIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='All']") 
	public MobileElement savedOfferAndBundlesPageAllTabIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Offers']") 
	public MobileElement savedOfferAndBundlesPageOffersTabIos;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Bundles']") 
	public MobileElement savedOfferAndBundlesPageBundlesTabIos;
	@FindBy(xpath = "//XCUIElementTypeTable[@name='TCPApp.SavedOffersViewController.tableView']/XCUIElementTypeCell") 
	public MobileElement savedOfferAndBundlesPageOffersCountIos;
	@FindBy(xpath = "//XCUIElementTypeTable[@name='TCPApp.SavedOffersViewController.tableView']/XCUIElementTypeCell[1]/XCUIElementTypeImage") 
	public MobileElement savedOfferAndBundlesPageOffersImageIos;
	@FindBy(xpath = "//XCUIElementTypeTable[@name='TCPApp.SavedOffersViewController.tableView']/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]") 
	public MobileElement savedOfferAndBundlesPageOffersExpireIos;
	@FindBy(xpath = "//XCUIElementTypeTable[@name='TCPApp.SavedOffersViewController.tableView']/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]") 
	public MobileElement savedOfferAndBundlesPageOffersBenifitTypeIos;
	@FindBy(xpath = "//XCUIElementTypeTable[@name='TCPApp.SavedOffersViewController.tableView']/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]") 
	public MobileElement savedOfferAndBundlesPageOffersBuyNowIos;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='iconTrash'])[1]") 
	public MobileElement savedOfferAndBundlesPageRemoveOfferIos;

	//22nd Mar
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Expiring soon']") 
	public MobileElement OffersAndBundlesPageExpiringSoonWidgetIOS;


	//30Mar//Croma Android//
	@FindBy(xpath = "//*[contains(@text,'Buy Now')]") 
	public MobileElement BuyNowAnd;
	@FindBy(xpath = "//*[contains(@text,'BUY NOW')] | (//*[contains(text(),'buy now')])[1] | //*[@text='BUY NOW']") 
	public MobileElement BuyNowCromaAnd;
	@FindBy(xpath = "//*[contains(@text,'Enter a Pincode')]") 
	public MobileElement PincodeAnd;
	@FindBy(xpath = "//*[contains(@text,'Enter a Pincode')]/following::android.widget.EditText") 
	public MobileElement PincodeEditAnd;
	@FindBy(xpath = "//*[contains(@text,'APPLY')]") 
	public MobileElement PincodeApplyAnd;
	@FindBy(xpath = "//*[contains(@text,'CHECKOUT')] | //*[contains(text(),'CHECKOUT')]") 
	public MobileElement checkoutAnd;
	@FindBy(xpath = "//*[@resource-id='phoneInputLogin-phone']") 
	public MobileElement enternumAnd;
	@FindBy(xpath = "(//*[contains(@text,'Continue')])[1]") 
	public MobileElement continueAnd;
	@FindBy(xpath = "//*[@resource-id='enter-password']") 
	public MobileElement clickPasswrdSign;
	@FindBy(xpath = "//*[@resource-id='password-box']") 
	public MobileElement EnterPasswrdSign;
	@FindBy(xpath = "//*[contains(@text,'Login')]") 
	public MobileElement Login;
	@FindBy(xpath = "(//*[contains(@text,'Full name')]/following::android.widget.EditText)[1] | (//*[contains(text(),'Full name')])[1]/following-sibling::input") 
	public MobileElement firstname;
	@FindBy(xpath = "(//*[contains(@text,'Full name')]/following::android.widget.EditText)[2] | //*[@placeholder='Flat no./Building Name/Society/Road']") 
	public MobileElement flat;
	@FindBy(xpath = "(//*[contains(@text,'Full name')]/following::android.widget.EditText)[3] | (//*[@placeholder='Landmark/Locality/Area'])[1]") 
	public MobileElement Landmark;
	@FindBy(xpath = "(//*[contains(@text,'State')]/following::android.widget.EditText)[1] | (//*[@placeholder='Select your state'])[1]") 
	public MobileElement state;

	@FindBy(id = "//*[@resource-id='state_id-popup'] | //*[@id='state_id-option-0']") 
	public MobileElement statelist;
	@FindBy(xpath = "(//*[contains(@text,'City')]/following::android.widget.EditText)[1] | //*[@id='city_id']") 
	public MobileElement city;
	@FindBy(xpath = "//*[@resource-id='city_id-option-0'] | //*[@id='city_id-option-0']") 
	public MobileElement citylist;
	@FindBy(xpath = "//*[contains(@text,'SHIPPING ADDRESS')] | //*[text()='SHIPPING ADDRESS']") 
	public MobileElement shipAddress;
	@FindBy(xpath = "//android.widget.EditText[@resource-id='password-box']") 
	public MobileElement OTP;
	@FindBy(xpath = "//*[contains(@text,'SELECT PAYMENT')] | //*[text()='select payment']") 
	public MobileElement selectPayment;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='offers.selectedStoreOffers.backButton']") 
	public MobileElement BackSavedIOS;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnBackSavedOffers") 
	public MobileElement BackSavedAnd;
	@FindBy(xpath = "//*[contains(@text,'View Details')] | //android.view.View[@text='View Details']") 
	public MobileElement viewDetailsAnd;
	@FindBy(xpath = "//*[contains(@text,'Payment Details')] | //*[contains(@text,'Order Summary')]") 
	public MobileElement Paymentdetails;
	@FindBy(xpath = "//*[contains(@text,'Choose a payment method')] | //*[contains(text(),'Choose a payment method')]") 
	public MobileElement Paymentmethod;
	@FindBy(xpath = "//*[@text='Payment Method'] | (//*[text()='Payment Method'])[2]") 
	public MobileElement PaymentmethodSel;
	@FindBy(xpath = "//*[@text='Add new card']") 
	public MobileElement AddCard;
	@FindBy(xpath = "//*[@text='Card Number']/following::android.widget.EditText[1]") 
	public MobileElement CardNumber;
	@FindBy(xpath = "//*[@text='Expiry']/following::android.widget.EditText[1]") 
	public MobileElement CardExpiry;
	@FindBy(xpath = "//*[@text='CVV']/following::android.widget.EditText[1]") 
	public MobileElement CardCVV;
	@FindBy(xpath = "//*[@text='Credit/Debit Cards']") 
	public MobileElement creditCard;
	@FindBy(xpath = "//*[@text='Proceed to Pay'] | //*[@text='Proceed to pay'] | //*[@text='PROCEED'] |(//*[text()='Proceed to pay'])[1]") 
	public MobileElement ProceedPay;
	@FindBy(xpath = "//*[@resource-id='password'] | //*[@resource-id='otpForm']//android.widget.EditText") 
	public MobileElement Password;
	@FindBy(xpath = "//*[@resource-id='submitBtn'] | //*[@resource-id='submit-action'] | //*[@id='onusOtpBtn']") 
	public MobileElement Pay;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Home']") public MobileElement HomeNav_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='homeBurgerMenu']") public MobileElement Homburger_ios;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivHamburgerMenu") public MobileElement HamburgerMenu;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'View Details')]") 
	public MobileElement viewDetailsIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Save')]") 
	public MobileElement saveOfferIOS;



	@FindBy(xpath = "//android.view.View[@content-desc='See all']/following::android.view.View[2]")
	public MobileElement OffersAndBundlesPageExpOfferFirstOffer;
	@FindBy(xpath = "//android.view.View[@content-desc='See all']/following::android.view.View[3]")
	public MobileElement OffersAndBundlesPageExpOfferFirstOfferValidityDate;
	@FindBy(xpath = "//*[contains(@text,'Get coupon')]")
	public MobileElement getCouponButton;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/copyCouponCodeButton']") 
	public MobileElement copyCoupon;
	@FindBy(xpath = "//*[contains(@text,'Buy Now')]")
	public MobileElement buyNowButton;
	@FindBy(xpath = "(//*[contains(@text,'APPLY')])[1]") 
	public MobileElement ApplyCouponAnd;
	@FindBy(xpath = "(//*[contains(@text,'APPLY')])[1]/parent::android.view.View//android.widget.EditText") 
	public MobileElement ApplyCouponText;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp:id/copyCouponCodeButton']") 
	public MobileElement copyCouponCode;
	@FindBy(xpath = "//*[@resource-id='container']//android.view.View[3]/android.view.View/android.view.View[2]/android.view.View[3]") 
	public MobileElement PaymentPageOffer;
	@FindBy(xpath = "//*[@resource-id='1000178']") 
	public MobileElement netBanking;
	@FindBy(xpath = "//*[@resource-id='1000321']") 
	public MobileElement netBankingICICI;


	@FindBy(xpath = "//*[@name='iconShare']") 
	public MobileElement sharebutton_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Close']") 
	public MobileElement sharemodal_ios;

	@FindBy(xpath = "((//XCUIElementTypeButton[@name=\"Buy Now\"])[3]/following::XCUIElementTypeButton)[2]") 
	public MobileElement limitedshare_ios;

	@FindBy(xpath = "//*[@name='ON TCP']") 
	public MobileElement tcpcustomer_ios;

	@FindBy(xpath = "//*[@name='NOT ON TCP']") 
	public MobileElement nontcpcustomer_ios;

	//8/4/21 Android	
	@FindBy(xpath = "(//*[@text='Order ID:']/following::*)[1]") 
	public MobileElement orderid_android;

	@FindBy(xpath = "(//*[contains(@text,'Order Details')]/following::*)[1]") 
	public MobileElement orderdetails_android;

	@FindBy(xpath = "//*[@text='DELIVERY ADDRESS']/following::android.view.View[3]") 
	public MobileElement deliveryadd_android;

	@FindBy(xpath = "//*[@text='BILLING ADDRESS']/following::android.view.View[3]") 
	public MobileElement billingadd_android;

	@FindBy(xpath = "//*[@text='SHIPPING DETAILS']/following::*[1]") 
	public MobileElement orderdate_android;

	@FindBy(xpath = "//*[@text='SHIPPING DETAILS']/following::*[2]") 
	public MobileElement shippingmode_android;

	@FindBy(xpath = "//*[@text='Item Subtotal']/following::*[1]") 
	public MobileElement subtotal_android;

	@FindBy(xpath = "//*[@text='Discount']/following::*[1]") 
	public MobileElement discount_android;

	@FindBy(xpath = "//*[@text='Total price']/following::*[1]") 
	public MobileElement totalprice_android;

	@FindBy(xpath = "//*[contains(@text,'Thank you')]") 
	public MobileElement ordersuccessmsg_android;



	//
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Explore Offers near you']")public MobileElement offersAndBundlesPageNearByButtonIOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Allow Once']")public MobileElement offersAndBundlesPageAllowPopupIOS;
	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Change')] | //XCUIElementTypeButton[contains(@label,'Change')]")public MobileElement changeLocationIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.changeLocation.navigationTitleLabel']")public MobileElement changeLocationLabelIOS;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='offers.changeLocation.navigationBarView']/following-sibling::XCUIElementTypeTextField")public MobileElement changeLocationTextFieldIOS;
	@FindBy(xpath = "//XCUIElementTypeCell[@name='offers.changeLocation.placesPredictionTableViewCell']")public List<MobileElement> resultsIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='offers.allOffersOnSelectedLocation.selectedLocationLabel']")public MobileElement locationLabelIOS;
	@FindBy(xpath = "//XCUIElementTypeTable[@name='offers.allOffersOnSelectedLocation.allOffersTableView']/XCUIElementTypeOther")public MobileElement storeFoundTextIOS;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='offers.allOffersOnSelectedLocation.storeNameLabel'])[1]")public MobileElement storeNameIOS;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='offers.allOffersOnSelectedLocation.storeAddressLabel'])[1]")public MobileElement storeAddressIOS;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='offers.allOffersOnSelectedLocation.storeTimingsLabel'])[1]")public MobileElement storeTimeIOS;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='offers.allOffersOnSelectedLocation.shopNowButton'])[1]")public MobileElement offerviewDetailsIOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Save']")public MobileElement saveOfferButtonIOS;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPApp.OfferDetail.cancelButton']")public MobileElement saveOfferCloseButtonIOS;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='callIcon'])[1]")public MobileElement callIcon;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='directionIcon'])[1]")public MobileElement directionIcon;


	@FindBy(id ="com.tatadigital.tcp.dev:id/tvStoresNearMePlaceholder") public MobileElement offlineStoresNearMeHeaderAdroid;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvViewOfferStores") public MobileElement ViewCTAAdroid;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvStoreTitle") public MobileElement storeTitle;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvStoreDistance") public MobileElement StoreDistance;
	@FindBy(id ="com.tatadigital.tcp.dev:id/imgDirection") public MobileElement StoreDirectionCTA;
	@FindBy(id ="com.tatadigital.tcp.dev:id/imgPhone") public MobileElement StorePhone;
	@FindBy(xpath="//*[@text='View Details']") public MobileElement viewDetails_Android;
	@FindBy(xpath = "//*[@text='View Details'] | //*[contains(@text,'Buy Now')] | //*[contains(@text,'Get coupon')]")public MobileElement shopNowAndroid;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Get Coupon']") 
	public MobileElement getCouponButtonIOS;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='No results found']") 
	public MobileElement noResultFoundIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Brand ']") 
	public MobileElement filterByBrandIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Category ']") 
	public MobileElement filterByCategoryIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Expiring Offers ']") 
	public MobileElement filterByExpiringOffersIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Offer Type ']") 
	public MobileElement filterByOfferTypeIOS;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sub Brand ']") 
	public MobileElement filterBySubBrandIOS;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Sub Category ']") 
	public MobileElement filterBySubCtegoryIOS;
	@FindBy(xpath ="//XCUIElementTypeImage[@name='selectedCheckboxV2']") 
	public MobileElement selectCheckBoxIOS;
	@FindBy(xpath ="//XCUIElementTypeImage[@name='unselectedCheckbox']") 
	public MobileElement unselectCheckBoxIOS;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='offers.discoveryFilter.filterApplyButton']") 
	public MobileElement filterApplyButtonIOS;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='offers.discoveryFilter.filterResetButton']") 
	public MobileElement filterResetButtonIOS;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='offers.discoveryFilter.dismissButton']") 
	public MobileElement filterCloseButtonIOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.brandNameLabel']") public MobileElement offerBrandName_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.productNameLabel']") public MobileElement offerDesc_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.onlineLabel']") public MobileElement offerChannel_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.OfferInfoTableViewCell.expiryLabel']") public MobileElement offerExpiry_IOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.TermsAndConditionTableViewCell.termsAndConditionLabel']") public MobileElement offerDetailTC_IOS;

	@FindBy(xpath="//XCUIElementTypeButton[@name='TCPApp.StoreNearMeTitleTableViewCell.closeButton']") public MobileElement viewStoreCTAIOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.NoStoreNearMeInfoTableViewCell.title']") public MobileElement noStoreText;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.TermsAndConditionTableViewCell.termsAndConditionLabel']") public MobileElement storeTitleIOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.TermsAndConditionTableViewCell.termsAndConditionLabel']") public MobileElement storeDistanceIOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.TermsAndConditionTableViewCell.termsAndConditionLabel']") public MobileElement storeDirectionIOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TCPApp.TermsAndConditionTableViewCell.termsAndConditionLabel']") public MobileElement storePhoneIOS;
	@FindBy(xpath="//XCUIElementTypeImage[@name='TCPApp.OfferInfoTableViewCell.addToVaultImage']") public MobileElement promotionAlreadySavedIOS;
	@FindBy(xpath="//XCUIElementTypeButton[@name='iconCircleCross']") public MobileElement closeCouponIOS;
	//16/04/21		
	@FindBy(xpath="//*[@text='F&B']")
	public MobileElement food_beverage_android;

	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='tcpApp.home.GridTypeTableViewCell.headerTitle'])[2]") public MobileElement selectService;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='tcpApp.home.GridTypeCollectionViewCell.title'])[10]") public MobileElement selectFoodIOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Food & Beverage']") public MobileElement FnBPageTitleIOS;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Starbucks Offers']") public MobileElement FnBPageStarBucksOfferWidgetIOS;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='See All'])[1]") public MobileElement FnBPageStarBucksAllOfferIOS;

	@FindBy(xpath="//*[@text='Offers on coffee & more']")
	public MobileElement starbucks_offer_android;

	@FindBy(xpath="//*[@text='Offers on gourmet meals']")
	public MobileElement qmin_offers_android;

	@FindBy(xpath="//*[@text='See all']")
	public MobileElement seeall_android;

	@FindBy(xpath="//*[@text='F&B']")
	public MobileElement fandb_android;

	@FindBy(id="com.tatadigital.tcp.dev:id/btnClose")
	public MobileElement closebutton_android;

	@FindBy(id="com.tatadigital.tcp.dev:id/btnAddToVault")
	public MobileElement savebutton_android;

	@FindBy(id="com.tatadigital.tcp.dev:id/imgSavedToVaultTick")
	public MobileElement savedbutton_android;

	@FindBy(id="com.tatadigital.tcp.dev:id/bookmarkIcon")
	public MobileElement savedoffers_android;

	@FindBy(id="com.tatadigital.tcp.dev:id/tvPageTitle")
	public MobileElement savedofferpagetitle_android;

	@FindBy(xpath="//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Offers\"]/android.widget.TextView")
	public MobileElement offerstab_android;

	@FindBy(xpath="//*[@text='Undo']")
	public MobileElement undo_button_android;

	@FindAll({@FindBy(id ="com.tatadigital.tcp.dev:id/offerTitleTextView")})
	public List<MobileElement> offertext_android;

	@FindBy(xpath="//*[@text='2 Bonus Stars on bill of ₹1,200']")
	public MobileElement floatingbutton_android;

	@FindBy(xpath="//*[@text='FILTERS']")
	public MobileElement filtertext_android;

	@FindAll({@FindBy(id ="com.tatadigital.tcp.dev:id/tvHeader")})
	public List<MobileElement> allfilters_android;

	@FindBy(xpath="//*[contains(@text,'Trending')]")
	public MobileElement widgetTrendingOffers;
	@FindBy(xpath="//*[contains(@text,'Handpicked')]")
	public MobileElement widgetHandpickedOffers;
	@FindBy(xpath="//*[contains(@text,'disappearing')]")
	public MobileElement widgetDisappearingOffers;
	@FindBy(xpath="//*[contains(@text,'Filter')]")
	public MobileElement filterbyCategories;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/buttonShopNow']|//*[@resource-id='com.tatadigital.tcp:id/buttonShopNow']")
	public MobileElement shopNowButton;
	@FindBy(xpath = "//*[@text='My Account']") public MobileElement loggedinUser;
	@FindBy(xpath = "//android.view.View[@content-desc='4F White Cotton T-Shirt']") public MobileElement selectProdctCliq;

	//bigbasket
	@FindBy(xpath="//*[contains(@text,'ADD TO BASKET')]")
	public MobileElement btnAddToBasket;
	@FindBy(xpath="//*[contains(@text,'FREQUENTLY BOUGHT WITH THIS PRODUCT')]")
	public MobileElement productAddtoBasketText;
	@FindBy(xpath="//*[@resource-id='pwa-header']/android.view.View/android.view.View[4]")
	public MobileElement myBasketAndroid;
	@FindBy(xpath="//*[contains(@text,'CHECKOUT')]")
	public MobileElement btnCheckout;
	@FindBy(xpath="//*[contains(@text,'Delivery Options')]")
	public MobileElement deliveryOptions;
	@FindBy(xpath="//*[contains(@text,'PROCEED TO PAY')]")
	public MobileElement proceedToPay;
	@FindBy(xpath="//*[contains(@text,'Payment')]")
	public MobileElement paymentPageHeader;
	@FindBy(xpath="//*[contains(@text,'Total Amount Payable')]/following::android.view.View[1]")
	public MobileElement TotalAmountPayable;
	@FindBy(xpath="//*[contains(@text,'Pay with Tata Pay App')]")
	public MobileElement paywithTataPay;
	@FindBy(xpath="//*[contains(@text,'Place order & Pay')]")
	public MobileElement placeOrderAndPay;
	@FindBy(xpath="//*[contains(@text,'Continue')]")
	public MobileElement continueBtn;
	@FindBy(xpath="//*[contains(@text,'Download receipt')]")
	public MobileElement downloadReceipt;

	@FindBy(xpath = "//*[contains(@text,'Starbucks')]")
	public MobileElement autofilterAnd;
	@FindBy(xpath = "//android.view.View[@content-desc='Guess Marciano Woman Eau de Parfum 100ml']") public MobileElement selectProdctBeauty;

	///Prod herobanner
	@FindBy(xpath = "//*[@resource-id='OZ_OZBanner_CarouselContainer']/android.view.View/android.view.View[1]/following-sibling::android.view.View")
	public List<MobileElement> heroBannerDotOZ;
	@FindBy(xpath = "//*[@resource-id='OZ_OZBanner_CarouselContainer']/android.view.View/android.view.View[1]")
	public MobileElement heroBannerImageOZ;
	@FindBy(xpath = "//android.view.View[@content-desc='searchIcon']/following-sibling::android.widget.Button")
	public MobileElement cliqBasketIcon;
	@FindBy(xpath = "//*[contains(@text,'CONTINUE SHOPPING')]|//*[contains(@text,'Continue Shopping')]")
	public MobileElement cliqContinueShopping;
	@FindBy(xpath = "//*[@resource-id='app']/android.view.View[1]/android.view.View[1]/android.view.View[2]//android.widget.TextView")
	public MobileElement cliqWelcomeHeader;
	@FindBy(xpath = "//android.view.View[@content-desc='Basket']/android.widget.TextView")
	public MobileElement bigbasketThreeLines;
	@FindBy(xpath = "//*[contains(@text,'My Account')]")
	public MobileElement bigbasketMyAccount;
	@FindBy(xpath = "//android.view.View[@content-desc='profile-update']")
	public MobileElement bigbasketProfileUpdate;
	@FindBy(xpath = "(//android.view.View[@content-desc='Navigate to Home Page']/preceding::android.widget.Button)[2]")
	public MobileElement TajMenu;
	@FindBy(xpath = "//android.view.View[@content-desc='Edit Profile']/android.widget.TextView|(//*[contains(@text,'Hi')])[1]")
	public MobileElement tajEditProfile;
	@FindBy(xpath = "//android.view.View[@content-desc='searchIcon']/following-sibling::android.widget.Button|//android.view.View[@content-desc='Basket']/android.widget.TextView|//*[@resource-id='loginActive']//following::android.view.View[1]/android.view.View[1]")
	public MobileElement brandPageIcon;
	@FindBy(xpath = "//android.view.View[@content-desc='My Account']")
	public MobileElement cliqMyAcct;
	@FindBy(xpath = "//*[contains(@text,'My reviews')]")
	public MobileElement cliqMyReviews;
	@FindBy(xpath = "//android.view.View[@content-desc='Menu Mobile Icon']|//*[@resource-id='dropdown-custom-components']|(//android.view.View[@content-desc='Navigate to Home Page']/preceding::android.widget.Button)[2]")
	public MobileElement brandPageIcon1;
	@FindBy(xpath = "//android.view.View[@content-desc='Menu Mobile Icon']")
	public MobileElement westsideMenuBar;
	@FindBy(xpath = "(//*[contains(@text,'Hi')])[1]")
	public MobileElement westsideLoginCheck;
	@FindBy(xpath = "//*[@resource-id='loginActive']//following::android.view.View[1]/android.view.View[1]")
	public MobileElement cromaLoginCheck;
	@FindBy(xpath = "//*[@resource-id='dropdown-custom-components']")
	public MobileElement airAsiaLoginCheck;
	@FindBy(xpath = "//*[@resource-id='st-trigger-effects']/following-sibling::android.view.View[4]|//android.view.View[@content-desc='basket']")
	public MobileElement bbBrandIcon;
	@FindBy(xpath = "//*[@resource-id='pwa-header']/android.view.View[1]/android.widget.TextView[1]")
	public MobileElement bbmenuIcon;
	@FindBy(xpath = "//*[@resource-id='OZ_OZMSD_Container']//*[@resource-id='OZ_OfferCard_CardContainer']")
	public List<MobileElement> offerImageContainer;
	@FindBy(xpath = "//*[contains(@text,'Exclusive offers')]")
	public MobileElement widgetExclusiveOffers;
	@FindBy(xpath = "(//android.view.View[@content-desc='Login'])[1]")
	public MobileElement bbLoginCheck;
	@FindBy(xpath = "//*[contains(@text,'My Ratings & Reviews')]")
	public MobileElement bbLoginReviews;
	@FindBy(xpath = "//android.view.View[@content-desc='basket']")
	public MobileElement bbLoginCheck1;
	@FindBy(xpath = "//*[@resource-id='OZ_OfferContainer_showAsCarouselContainer']/android.view.View/android.view.View")
	public MobileElement handpickedOfferContainer;
	@FindBy(xpath = "//*[@resource-id='OZ_OfferContainer_showAsCarouselContainer']/android.view.View/android.widget.ListView/android.view.View")
	public List<MobileElement> handpickedDots;
	@FindBy(xpath = "//*[@resource-id='OZ_OfferContainer_showAsCarouselContainer']/android.view.View/android.widget.ListView/android.view.View")
	public MobileElement handpickedDots1;


	@FindBy(xpath = "//*[contains(@text,'Tata Shop Share Smile offers')]")
	public MobileElement TataShopShareSmileOffers;

	//Aishwarya 24th May
	@FindBy(xpath = "//*[@text='Offers']")
	public MobileElement OffersIcon;
	@FindBy(xpath = "//*[@text='Exclusive offers']")
	public MobileElement ExclusiveOffers;
	@FindBy(xpath = "//*[@text='See all']")
	public MobileElement ExclusiveOffersSeeAll;
	@FindBy(xpath = "//*[@content-desc='NeuPass']")
	public MobileElement NeupassIcon;
	@FindBy(xpath = "//*[@text='NeuPass exclusives']")
	public MobileElement NeupassExclusive;
	@FindBy(xpath = "//*[@text='See All']")
	public MobileElement NeupassExclusiveSeeAll;
	@FindBy(xpath = "//android.view.View[@content-desc='Top offers on grocery']")
	public MobileElement GroceryOffers;
	@FindBy(xpath = "//*[@text='Tata Shop Share Smile offers']")
	public MobileElement TSSSOffers;
	@FindBy(xpath = "//*[@text='Helios']")
	public MobileElement LoginHelios;
	@FindBy(xpath = "//*[@text='Hi A']")
	public MobileElement AutologinTSSS;
	@FindBy(xpath = "//android.view.View[@content-desc='Logout']")
	public MobileElement LogoutHelios;
	@FindBy(xpath = "//*[@content-desc='Grocery']")
	public MobileElement GroceryWidget;
	@FindBy(xpath = "//*[@content-desc='Beauty store']")
	public MobileElement BeautyStore;
	@FindBy(xpath = "(//*[@index='1'])[6]")
	public MobileElement EnjoyStroiesFromUs;
	@FindBy(xpath = "//*[@content-desc='Trending products']")
	public MobileElement TrendingProducts;
	@FindBy(xpath = "//*[@content-desc='Products you love on discount']")
	public MobileElement ProductsDiscount;
	@FindBy(xpath = "(//*[@index='1'])[5]")
	public MobileElement EatOrganic;
	@FindBy(xpath = "//*[@text='Filter by category']")
	public MobileElement FilterByCategory;
	@FindBy(xpath = "//*[@text='Healthcare']")
	public MobileElement HealthcareOffer;
	@FindBy(xpath = "//*[@text='Sort by']")
	public MobileElement SortBy;
	@FindBy(xpath = "//*[@text='Expiring Soon']")
	public MobileElement ExpiringSoon;
	@FindBy(xpath = "//*[@text='Filter']")
	public MobileElement FilterBy;
	@FindBy(xpath = "//*[@text='Expiry date']")
	public MobileElement ExpiryDate;
	@FindBy(xpath = "//*[@text='Expiring in 2+ weeks (1)']") 
	public MobileElement ExpiringDate;
	@FindBy(xpath = " //*[@text='Apply']")
	public MobileElement Apply;
	@FindBy(xpath = "(//*[@content-desc='Description'])[3]")
	public MobileElement SearchIcon;
	@FindBy(xpath = "//android.widget.EditText[@text='Search']")
	public MobileElement Search;
	@FindBy(xpath = "(//*[@content-desc='Description'])[1]")
	public MobileElement BackButtton;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/likeDislikeCtaButton']")
	public MobileElement LikeTab;
	@FindBy(xpath = "//*[@text='Shop now']")
	public MobileElement ShopNow;
	@FindBy(xpath = "//*[@content-desc='Navigate up']")
	public MobileElement NaviagteUpButton;
	@FindBy(xpath = "(//*[@content-desc='Description'])[2]")
	public MobileElement BookmarkIcon;
	@FindBy(xpath = "//android.widget.TextView[@text='Active']")
	public MobileElement ActiveIcon;
	@FindBy(xpath = "//*[@text='Offers']")
	public MobileElement OffersTab;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/removeFromVaultButton'])[1]")
	public MobileElement RemoveTab;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Electronics']")
	public MobileElement ElectronicsWidget;
	@FindBy(xpath = "//android.view.View[@content-desc='Microwave & OTG']")
	public MobileElement MicrowaveOTG;
	@FindBy(xpath = "//android.view.View[@content-desc='Products recommended for you']")
	public MobileElement ProductRecommendedYou;
	@FindBy(xpath = "//android.view.View[@content-desc='From categories you like']")
	public MobileElement CategoriesYouLike;
	@FindBy(xpath = "//android.view.View[@content-desc='Computer accessories']")
	public MobileElement ComputerAccesories;
	@FindBy(xpath = "//android.view.View[@content-desc='Still looking for these?']")
	public MobileElement StillLoking;
	@FindBy(xpath = "//android.view.View[@content-desc='Products you love on discount']")
	public MobileElement ProductOnDsicount;
	@FindBy(xpath = "//android.view.View[@content-desc='Inspired by products you viewed']")
	public MobileElement InspiredProducts;
	@FindBy(xpath = "//android.view.View[@content-desc='Accessories for You']")
	public MobileElement AccessoriesForYou;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Smartphones']")
	public MobileElement SmartPhoneWidget;
	@FindBy(xpath = "//android.view.View[@content-desc='Accessories']")
	public MobileElement Accessories;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Fashion']")
	public MobileElement FashoinWidget;
	@FindBy(xpath = "//android.view.View[@content-desc='Summer ready picks for women']")
	public MobileElement SummerForWomen;
	@FindBy(xpath = "//android.view.View[@content-desc='Exclusive Offers']")
	public MobileElement Exclusive;
	@FindBy(xpath = "//android.view.View[@content-desc='Your summer accessories fix']")
	public MobileElement AccessoriesFix;
	@FindBy(xpath = "//android.view.View[@content-desc='Casual comfort for the stylish man']")
	public MobileElement CasualComfort;
	@FindBy(xpath = "//android.view.View[@content-desc='Trend alert by Westside: Holiday essentials']")
	public MobileElement HolidayEssentials;
	@FindBy(xpath = "//android.view.View[@content-desc='Top brands on offer']")
	public MobileElement TopBrandsOffers;
	@FindBy(xpath = "//android.view.View[@content-desc='Comfort footwear for women']")
	public MobileElement FootWearForWomen;
	@FindBy(xpath = "//android.view.View[@content-desc='Comfort footwear for men']")
	public MobileElement FootWearForMen;
	@FindBy(xpath = "//android.view.View[@content-desc='Sport these epic brands']")
	public MobileElement SportsBrands;
	@FindBy(xpath = "//android.view.View[@content-desc='Ensembles for kids']")
	public MobileElement EnsemblesForKids;
	@FindBy(xpath = "//android.view.View[@content-desc='Kids brands by Westside']")
	public MobileElement KidsWestside;
	@FindBy(xpath = "//android.view.View[@content-desc='Athleisure']")
	public MobileElement Athleisure;
	@FindBy(xpath = "//android.view.View[@content-desc='Your fit kit']")
	public MobileElement FitKit;
	@FindBy(xpath = "//android.view.View[@content-desc='Decorate your dream home']")
	public MobileElement DecorateHome;
	@FindBy(xpath = "//android.view.View[@content-desc='Enjoy the latest stories from us']")
	public MobileElement LatestStories;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Hotels']")
	public MobileElement HotelsWidget;
	@FindBy(xpath = "//android.view.View[@content-desc='Offers in Spotlight']")
	public MobileElement Spotlight;
	@FindBy(xpath = "//android.view.View[@content-desc='Stays recommended for you'")
	public MobileElement StayRecommended;
	@FindBy(xpath = "//android.view.View[@content-desc='Picturesque Beach resorts']")
	public MobileElement BeachResorts;
	@FindBy(xpath = "//android.view.View[@content-desc='Most booked stays']")
	public MobileElement BookedStays;
	@FindBy(xpath = "//android.view.View[@content-desc='City Landmarks']")
	public MobileElement CityLandmarks;
	@FindBy(xpath = "//android.view.View[@content-desc='Divinity trails']")
	public MobileElement Divinitytrails;
	@FindBy(xpath = "//android.view.View[@content-desc='Hill Retreats']")
	public MobileElement HillRetreats;
	@FindBy(xpath = "//android.view.View[@content-desc='Themes for your next vacation'")
	public MobileElement ThemesVacation;
	@FindBy(xpath = "//android.view.View[@content-desc='Living royal Palaces']")
	public MobileElement RoyalPalaces;
	@FindBy(xpath = "//android.view.View[@content-desc='Unexplored jungle safaris']")
	public MobileElement JungleSafaris;
	@FindBy(xpath = "//android.view.View[@content-desc='Private Villas And Bungalows']")
	public MobileElement VillasAndBunglows;
	@FindBy(xpath = "//android.view.View[@content-desc='Backwater Escapes']")
	public MobileElement BackwardEscapes;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Beauty']")
	public MobileElement BeautyWidget;
	@FindBy(xpath = "//android.view.View[@content-desc='Top brands']")
	public MobileElement TopBrands;
	@FindBy(xpath = "//android.view.View[@content-desc='Brands to Covet']")
	public MobileElement BrandsCovet;
	@FindBy(xpath = "//android.view.View[@content-desc='The fragrance boutique']")
	public MobileElement FragranceBoutique;
	@FindBy(xpath = "//*[@content-desc='Browse by skin type']")
	public MobileElement SkinType;
	@FindBy(xpath = "//*[@content-desc='Best of skincare']")
	public MobileElement SkinCare;
	@FindBy(xpath = "//*[@content-desc='Special price store']")
	public MobileElement PriceStore;
	@FindBy(xpath = "//*[@content-desc='Haircare heroes']")
	public MobileElement HaircareHeros;
	@FindBy(xpath = "//*[@content-desc='Bath and body basics']")
	public MobileElement BodyBasics;
	@FindBy(xpath = "//*[@content-desc='The fragrance family']")
	public MobileElement FragranceFamily;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Entertainment']")
	public MobileElement EnterTainmentWidget;
	@FindBy(xpath = "//*[@content-desc='Offers to keep you entertained']")
	public MobileElement OffersEntertained;
	@FindBy(xpath = "//*[@content-desc='Bite-sized videos']")
	public MobileElement BiteSizedVideos;
	@FindBy(xpath = "//*[@content-desc='Just in']")
	public MobileElement JustIn;


}
