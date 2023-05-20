package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_Channels_Mobile {

	public TDL_Channels_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tv_headerName']") public MobileElement channelPageHeader_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[1]") public MobileElement firstWidget_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[1]//*[@resource-id='com.tatadigital.tcp.dev:id/tv_title']") public MobileElement firstWidgetTitle_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[1]//*[@resource-id='com.tatadigital.tcp.dev:id/tv_description']") public MobileElement firstWidgetDescription_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/iv_back']") public MobileElement backToHomePageBtn_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[2]//*[@resource-id='com.tatadigital.tcp.dev:id/tv_title']") public MobileElement secondWidgetTitle_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[2]/../*[@resource-id='com.tatadigital.tcp.dev:id/multi_layout'] | //*[@resource-id='com.tatadigital.tcp.dev:id/multi_layout']") public MobileElement secondWidgetMultiChoice_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/submit_view']") public MobileElement multiChoiceSubmitBtn_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tv_msg']") public MobileElement multiChoiceSelectedChoicesText_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/multi_layout']/android.widget.TextView") public List<MobileElement> multiChoices_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/iv_menu']") public MobileElement threeDots_android;
	@FindBy(xpath = "//*[@text='Shop Now']") public MobileElement threeDotsShopNow_android;
	@FindBy(xpath = "//*[@text='Quick Recharge']") public MobileElement threeDotsQuickRecharge_android;
	@FindBy(xpath = "//*[@text='NewConnection']") public MobileElement threeDotsNewConnection_android;
	@FindBy(xpath = "//*[@text='Book a Stay']") public MobileElement threeDotsBookAStay_android;
	@FindBy(xpath = "//*[@text='Reserve a Table']") public MobileElement threeDotsReserveATable_android;
	@FindBy(xpath = "//*[contains(@text, 'Let�s stay connected')]") public MobileElement thirdWidgetKeyBenefits_android;
	@FindBy(xpath = "//*[@content-desc='preprod2-pwa.croma']") public MobileElement cromaPage_android;
	@FindBy(xpath = "//*[contains(@text, 'Taj Hotels logo')]") public MobileElement ihclPage_android;
	@FindBy(xpath = "//*[contains(@text, 'Tata Sky')]") public MobileElement tataSkyPage_android;	
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/search_tv']") public MobileElement search_channel_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/cross_iv']") public MobileElement cross_search_android;
	@FindBy(xpath = "//*[@text='Tata Pay']") public MobileElement chnl_tata_pay_android;
	@FindBy(xpath = "//*[@text='Tata Capital']") public MobileElement chnl_tata_capital_android;
	@FindBy(xpath = "//*[@text='Air Asia']") public MobileElement chnl_air_asia_android;
	@FindBy(xpath = "//*[@text='Utilities']") public MobileElement chnl_utilities_android;
	@FindBy(xpath = "//*[@text='Starbucks']") public MobileElement chnl_starbucks_android;
	@FindBy(xpath = "//*[@text='Croma']") public MobileElement chnl_croma_android;
	@FindBy(xpath = "//*[@text='IHCL']") public MobileElement chnl_ihcl_android;
	@FindBy(xpath = "//*[@text='Tata Sky']") public MobileElement chnl_tata_sky_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/recycler_view']") public MobileElement view_all_page_android;
	@FindBy(xpath = "//*[@text='Channels']") public MobileElement channelsHeaderViewAll_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/parentLayout']") public List<MobileElement> allchannelvisibility_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/parentLayout'])[1]") public MobileElement firstListViewChannel_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/search_iv']") public MobileElement searchIcon_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/got_it_tv']") public MobileElement spotlightChannel_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/tv_time'])[1]") public MobileElement first_channel_timer_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/message']") public List<MobileElement> channel_description_android;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/thumbnailContainer']/*[@resource-id='com.tatadigital.tcp.dev:id/notification_counter'])[1]") public MobileElement messageCounter_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/thumbnailContainer']/*[@resource-id='com.tatadigital.tcp.dev:id/notification_counter']") public MobileElement readMessageCounter_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tv_time']") public List<MobileElement> last_widget_DandT_android;
	@FindBy(xpath = "//android.widget.TextView[@text='Accept']") public  MobileElement accept_payment_CTA_android;
	@FindBy(xpath = "//android.widget.TextView[@text='Decline']") public  MobileElement decline_payment_CTA_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ivBack']") public  MobileElement backBtnPayment_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/positiveButton']") public  MobileElement popUpPayment_Yes_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/negativeButton']") public  MobileElement popUpPayment_No_android;
	@FindBy(xpath = "//*[@text='Warning']") public  MobileElement popUpPayment_window_android;
	@FindBy(xpath = "//*[contains(@resource-id, 'tv_mins')]") public  MobileElement bounceOff_timer_android;
	@FindBy(xpath = "//*[contains(@text,'Your payment was interrupted')]") public  MobileElement bounceOff_widget_android;
	@FindBy(xpath = "//*[@text='Proceed']") public  MobileElement proceed_payment_CTA_BO_android;
	@FindBy(xpath = "//*[@text='Dismiss']") public  MobileElement dismiss_payment_CTA_BO_android;
	@FindBy(xpath = "//*[contains(@text, 'Invoice')]") public  MobileElement payment_window_element_android;
	@FindBy(xpath = "//*[contains(@text, 'Cancel Payment')]") public  MobileElement dismiss_pop_up_window_android;
	@FindBy(xpath = "//*[contains(@resource-id, 'positiveButton')]") public  MobileElement dismiss_pop_up_Ok_CTA_android;
	
	/**
	 * Define iOS locators
	 * 
	 */


	@FindBy(xpath = "(//XCUIElementTypeTable)[1]/XCUIElementTypeCell[1]") public MobileElement firstWidget_ios;
	@FindBy(xpath = "(//XCUIElementTypeTable)[1]/XCUIElementTypeCell[1]//XCUIElementTypeStaticText[3]") public MobileElement firstWidgetTitle_ios;
	@FindBy(xpath = "(//XCUIElementTypeTable)[1]/XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1]") public MobileElement firstWidgetDescription_ios;
	@FindBy(xpath = "(//XCUIElementTypeTable)[1]/XCUIElementTypeCell[2]/XCUIElementTypeTable") public MobileElement secondWidgetMultiChoice_ios;
	@FindBy(xpath = "(//XCUIElementTypeTable)[1]/XCUIElementTypeCell[2]/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText") public List<MobileElement> multiChoices_ios;
	@FindBy(xpath = "(//XCUIElementTypeTable)[1]/XCUIElementTypeCell[3]//XCUIElementTypeStaticText[1]") public MobileElement multiChoiceSelectedChoicesText_ios;
	@FindBy(xpath = "//*[@name='Let’s stay connected']") public MobileElement thirdWidgetKeyBenefits_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='more']") public MobileElement threeDots_ios;
	@FindBy(xpath = "(//XCUIElementTypeTable)[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[1]") public MobileElement secondWidgetTitle_ios;
	@FindBy(xpath = "(//XCUIElementTypeTable)[1]/XCUIElementTypeCell[2]//XCUIElementTypeButton[@name='Submit']") public MobileElement multiChoiceSubmitBtn_ios;
	

	@FindBy(xpath = "//*[@name='Shop Now']") public MobileElement threeDotsShopNow_ios;
	@FindBy(xpath = "//*[@name='Quick Recharge']") public MobileElement threeDotsQuickRecharge_ios;
	@FindBy(xpath = "//*[@name='New Connection']") public MobileElement threeDotsNewConnection_ios;
	@FindBy(xpath = "//*[@name='Book a Stay']") public MobileElement threeDotsBookAStay_ios;
	@FindBy(xpath = "//*[@name='Reserve a Table']") public MobileElement threeDotsReserveATable_ios;

	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]") public MobileElement cromaPage_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]") public MobileElement ihclPage_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']/XCUIElementTypeWindow[1]") public MobileElement tataSkyPage_ios;
	@FindBy(name = "channels.backButton") public MobileElement channelBackBtn_ios;
	@FindBy(name = "channels.ribbon.imageView") public List<MobileElement> channelsInHomePage_ios;
	@FindBy(xpath = "//*[@name='channels.backButton']/following-sibling::XCUIElementTypeStaticText[1]") public MobileElement channelPageName_ios;
	@FindBy(name = "share") public MobileElement shareinWidget_ios;
	@FindBy(name = "like unfilled") public MobileElement likeinWidget_ios;
	@FindBy(xpath = "//*[@name='Would you like to see your upcoming bills?']") public MobileElement upcoming_bill_popup_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Okay']") public MobileElement upcomingBillPopup_Okay_ios;
	@FindBy(xpath = "//*[@name='Add Bill']") public MobileElement addBillBtn_ios;
	@FindBy(xpath = "//*[@name='Clear your headspace']") public MobileElement popup_add_more_bill_ios;
	@FindBy(xpath = "//*[@name='Add later']") public MobileElement add_later_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='ReviewBillViewController']") public MobileElement payment_details_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@label='Pay Now']") public MobileElement pay_now_ios;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.MultiTender']") public MobileElement multitender_landing_ios;
	@FindBy(xpath = "//XCUIElementTypeSecureTextField") public MobileElement enter_cvv_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[contains(@label,'Pay')]") public MobileElement pay_btn_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Razorpay Bank']") public MobileElement payment_landing_bank_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Success']") public MobileElement success_payment_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Failure']") public MobileElement failure_payment_ios;
	
	
	//Manoranjan
	@FindBy(xpath = "//*[@name='View All']") public MobileElement viewAllChannels_ios;
	@FindBy(xpath = "//*[@name='Channels' or @name='ChannelsSDK.SearchChannelVC']") public MobileElement channelsHeader_ios;
	@FindBy(xpath = "//*[@name='Tata Capital']") public MobileElement firstChannelName_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP Dev']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField") public MobileElement searchBar_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP Dev]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell") public List<MobileElement> channelsList_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Tata Capital']/preceding::XCUIElementTypeOther/XCUIElementTypeOther") public MobileElement messageCounter_ios;
	@FindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[2]") public List<MobileElement> channel_description_ios;
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]") public MobileElement firstListViewChannel_ios;
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]") public MobileElement first_channel_timer_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Ok, got it']") public MobileElement spotlightChannel_ios;
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[3]") public List<MobileElement> channelsListData_ios;
	@FindBy(xpath = "//*[@name='5 things you must know before availing a credit line']") public MobileElement secondWidget_ios;
	@FindBy(xpath = "(//*[contains(@text, 'Welcome')])[1]") public MobileElement welcomeWidgetTextAndroid;
	@FindBy(xpath = "(//*[contains(@text, 'Welcome')])[1]/parent::android.view.ViewGroup[1]") public MobileElement welcomeWidgetAndroid;
	@FindBy(xpath = "(//*[contains(@text, 'Welcome')])[1]/parent::android.view.ViewGroup[1]/android.widget.TextView[2]") public MobileElement welcomeWidgetTitleAndroid;
	@FindBy(xpath = "(//*[contains(@text, 'Welcome')])[1]/parent::android.view.ViewGroup[1]/android.widget.TextView[1]") public MobileElement welcomeWidgetDateTimeAndroid;
	@FindBy(xpath = "(//*[contains(@text, 'Welcome')])[1]/parent::android.view.ViewGroup[1]/android.widget.TextView[3]") public MobileElement welcomeWidgetContentAndroid;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[2]") public MobileElement secondWidgetAndroid;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[2]/android.widget.TextView[1]") public MobileElement secondWidgetDateTimeAndroid;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[2]/android.widget.TextView[2]") public MobileElement secondWidgetTitleAndroid;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[2]/android.widget.TextView[3]") public MobileElement secondWidgetContentAndroid;
	@FindBy(xpath = "//*[contains(@text,'Key Benefits')]") public MobileElement keyBenefitsAndroid;
	@FindBy(xpath = "//*[contains(@text,'Hello')]") public MobileElement helloMsgAndroid;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[1]/android.widget.TextView[1]") public MobileElement welcomeWidgetDateTimeTCAndroid;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[1]/android.widget.TextView[2]") public MobileElement welcomeWidgetTitleTCAndroid;;
	@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/headingSource'])[1]/android.widget.TextView[3]") public MobileElement welcomeWidgetContentTCAndroid;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/parentLayout']/android.widget.TextView[1]") public MobileElement searchResultAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/channelAlertLayout") public MobileElement homePageChannelMenuButton;
	@FindBy(id = "com.tatadigital.tcp.dev:id/iv_menu") public MobileElement airAssiaMenuButton;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ChannelContainer']/android.widget.RelativeLayout[1]") public MobileElement airAssiaFirstMenu;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/ChannelContainer']/android.widget.RelativeLayout[2]") public MobileElement airAssiaSecondMenu;
	@FindBy(xpath = "//*[@text='Alerts']") public MobileElement alertsTab_android;
	@FindBy(xpath = "//*[@content-desc='Tpay']") public MobileElement tPayalertsTab_android;
	@FindBy(xpath = "//*[@content-desc='Bill Pay']") public MobileElement billPayalertsTab_android;
	@FindBy(xpath = "//*[@content-desc='Financials']") public MobileElement financialsalertsTab_android;
	@FindBy(xpath = "//*[@content-desc='Others']") public MobileElement othersalertsTab_android;
	

	@FindBy(xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[2]") public MobileElement navBar_channel_ios;
	
//dec 7// Android//
	@FindBy(xpath = "com.tatadigital.tcp.dev:id/tv_channel") public MobileElement channel_android;
	@FindBy(xpath = "//*[@text='Declined']") public MobileElement Mandate_Declined_android;
	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.tatadigital.tcp.dev:id/dateTime']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@text='Blocked']") public MobileElement mandate_Blocked_msg_android;
	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.tatadigital.tcp.dev:id/payment_status_block']//android.widget.TextView[@text='Blocked']") public MobileElement mandate_Blocked_android;
	@FindBy(xpath = "//*[normalize-space(@text) = 'Mandate Declined']") public MobileElement Mandate_Declined_msg_android;
	@FindBy(xpath = "//*[@text='MerchantMandate']") public MobileElement merchantmandate_android;
	@FindBy(xpath = "") public MobileElement merchantmandate_amount_android;
	@FindBy(xpath = "") public MobileElement merchantmandate_bank_RRN_android;
	@FindBy(xpath = "//*[contains(@text,'Expired')]/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[contains(@text,'MERCHANTMANDATE')]") public MobileElement merchantmandate_Expired_android;
	@FindBy(xpath = "(//*[@text='Mandate Expired']/../preceding::android.widget.LinearLayout)[1]") public MobileElement merchantmandate_Expired_widget_android;
	@FindBy(xpath = "//*[normalize-space(@text) = 'Mandate Created']") public MobileElement Mandate_accepted_android;
	@FindBy(xpath = "//*[@text='Accepted']") public MobileElement Mandate_accepted_msg_android;
	@FindBy(xpath = "") public MobileElement Mandate_accept_revoke_android;
	@FindBy(xpath = "") public MobileElement Mandate_accept_revoke_msg_android;
	@FindBy(xpath = "//*[@text='Accept']") public MobileElement Mandate_accept_button_android;
	@FindBy(xpath = "//*[@text='Decline']") public MobileElement Mandate_Declined_button_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button") public MobileElement allow_android;
	@FindBy(xpath = "//*[contains(@text, 'SIM 1')]") public MobileElement select_sim_android;
	@FindBy(xpath = "//*[@text='Confirm']") public MobileElement Mandate_accept_confirm_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivClose") public MobileElement close_android;
	@FindBy(xpath = "//*[@text='Revoke']") public MobileElement Mandate_Revoke_button_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivMoreInfo") public MobileElement more_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement btn_positive_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnNegative") public MobileElement btn_negative_android;
	@FindBy(xpath = "//*[@text='Tata Pay']") public MobileElement channel_tatapay_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/inc_upi_link_registration_layout") public MobileElement upi_regn_page_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clMandateDetails") public MobileElement confirm_mandate_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionStatus") public MobileElement response_page_android;
	@FindBy(xpath = "//*[@text='Transaction Initiated']") public MobileElement mandate_success_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAlertTitle") public MobileElement mandate_decline_popup_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvVerify") public MobileElement verify_user_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAlertTitle") public MobileElement verify_user_popup_android;
	@FindBy(xpath = "//*[@text='Requested']") public MobileElement requested_widget_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tv_mins']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView") public MobileElement push_request_widget_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clPaymentView") public MobileElement confirm_payment_page_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPaytovpa") public MobileElement pay_btn_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/clDetail']") public MobileElement payment_success_raise_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/clPayeeContainer']") public MobileElement payment_success_payee_details_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvFavourite']") public MobileElement favorite_contact_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/clRoot']") public MobileElement select_contact_android;
	
	//dec 8//Android
		@FindBy(id = "com.tatadigital.tcp.dev:id/ivDefaultProfilePic") 
		public MobileElement profilebuttonclick;
		
		@FindBy(xpath = "//*[@text='Others']") 
		public MobileElement othersbutton;
		
		@FindBy(xpath = "//*[@text='Merchant Acquiring']") 
		public MobileElement merchantacquringbutton;
		
		@FindBy(id = "com.tatadigital.tcp.dev:id/etOrderId") 
		public MobileElement orderidenter;
		
		@FindBy(xpath = "//*[@text='PAY']") 
		public MobileElement paybutton;
		
		@FindBy(xpath = "//*[@text='Invoice']") 
		public MobileElement invoicetext;
		
		@FindBy(id = "com.tatadigital.tcp.dev:id/iv_back") 
		public MobileElement backbutton;
		
		@FindBy(xpath = "//*[@text='Warning']") 
		public MobileElement warningpopup;
		
		@FindBy(id = "com.tatadigital.tcp.dev:id/positiveButton") 
		public MobileElement buttonpositive;
		
		@FindBy(xpath = "(//*[@text='Proceed']/../preceding-sibling::*)[1]") 
		public MobileElement interruptedwidget;
		
		@FindBy(xpath = "//*[@text='Proceed']") 
		public MobileElement proceedbutton;
		
		@FindBy(xpath = "//*[@text='Tata Pay']") 
		public MobileElement tatapaytext;
		
		
		//dec 09//
		@FindBy(xpath = "//*[@text='Back to HomePage']") public MobileElement navigate_home_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/bottom_home") public MobileElement navigate_home;
		@FindBy(id = "com.tatadigital.tcp.dev:id/etAmount") public MobileElement selectAmount_android;
		@FindBy(xpath = "(//*[@text='Request'])[2]") public MobileElement request_android;
		
		@FindAll({@FindBy(xpath = "com.tatadigital.tcp.dev:id/payment_status_block")})
		public List<MobileElement> request_widget_android;
		
		@FindBy(xpath = "//*[@text='Transaction Details']") 
		public MobileElement request_pg_redirected_android;
		
		@FindBy(xpath = "//*[@text='Pay']") public MobileElement send_money_android;
		@FindBy(xpath = "//*[@text='Paid']") public List <MobileElement> send_money_widget_android;
		@FindBy(xpath = "//*[@text='PAYMENT REQUEST']") public MobileElement payment_request_android;
		@FindBy(xpath = "//*[@text='Expired']") public MobileElement payment_request_expiredandroid;
		
		@FindBy(xpath = "//*[contains(text(),'Requested')]") public List<WebElement> request_widget_PWA;
		@FindBy(xpath = "//*[contains(text(),'Paid')]") public List<WebElement> send_widget_PWA;
		@FindBy(id = "com.tatadigital.tcp.dev:id/tvTransactionIdHeader") public MobileElement transaction_header_android;
		@FindBy(xpath = "//*[contains(@text, 'SIM 1')]") public MobileElement payment_order_android;
		

		
		
		//dec 10//
		@FindBy(xpath = "//*[@text='Block']") public MobileElement Block_android;
		@FindBy(id = "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement Block_android_popup;
		@FindAll({@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/statusText']/../*[@text='Blocked']")})
		public List<MobileElement> Block_android_Widget;
		
		@FindAll({@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tv_msg']/../*[@text='Blocked']")}) 
		public List<MobileElement>Block_android_Widget_message;
		
		@FindAll({@FindBy(xpath = "//span[contains(text(),'Blocked')]")}) 
		public List<MobileElement> Block_android_Widget_PWA;
		
		@FindAll({@FindBy(xpath = "//p[contains(text(),'Blocked')]")})
		public List<MobileElement> Block_android_Widget_message_PWA;
		
		@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/utr_container1']//following::android.widget.TextView)[1]") 
		public MobileElement payment_request_order_android;
		
		@FindBy(xpath = "//*[@text='Unblock']") 
		public MobileElement Unblock_android;
		
		//dec 14.12.20
		@FindBy(xpath="//*[@text='PAYMENT METHODS']/../following-sibling::*/*[@text='CREDIT CARD']")
		public MobileElement availablePayMthd_android;
		
		@FindBy(xpath = "//*[@text='View All']") 
		public MobileElement viewall_button;
		
		@FindBy(xpath = "//*[@text='Utilities']") 
		public MobileElement utilitiesbutton;
		
		@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/action_button'])[1]") public MobileElement likeinWidget_android;
		@FindBy(xpath = "(//*[@resource-id='com.tatadigital.tcp.dev:id/action_button'])[2]") public MobileElement shareinWidget_android;

        //ios
		
		@FindBy(xpath = "//XCUIElementTypeTabBar[@name='Tab Bar']/XCUIElementTypeButton[2]") public MobileElement channelNavigationBtn_ios;
		@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='ChannelsSDK.ChannelTabView']") public MobileElement alertTxt_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Tpay']") public MobileElement tataPaytab_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bill Pay']") public MobileElement billPaytab_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Financials']") public MobileElement financialstab_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Others']") public MobileElement otherstab_ios;
		@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='ChannelsSDK.ChannelTabView']//following-sibling::XCUIElementTypeOther//XCUIElementTypeTable/XCUIElementTypeCell") public List<MobileElement> tataPayAlertsMsgs_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'@')]") public MobileElement tataPayAlertsTxnDetailUpiId_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Rejected']") public MobileElement tataPayAlertsTxnDetailRejectedMsg_ios;
		@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'₹')]") public MobileElement tataPayAlertsTxnDetailAmount_ios;

}

