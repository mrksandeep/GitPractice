package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;

public class TDL_ChannelsPage extends BaseScript {

	@FindBy(xpath = "//h1[text()='xxxx']") public WebElement channelPageHeader;
	@FindBy(xpath = "//h1[text()='xxxx']/parent::div/preceding-sibling::button") public WebElement backToHomePageBtn;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div[3]/h4") public WebElement firstWidgetTitle;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div[3]/div/p") public WebElement firstWidgetDescription;
	@FindBy(xpath = "//*[text()='xxxx']/parent::div/parent::a") public WebElement channelLink;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/h4") public WebElement secondWidgetTitle;
	@FindBy(xpath = "//*[@id='topDiv']/following-sibling::div[2]//button") public WebElement secondWidgetMultiChoice;		
	@FindBy(xpath = "//*[@id='topDiv']/following-sibling::div[2]//button/p") public List<WebElement> secondWidgetMultiChoiceList;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[5]/div[3]/h4") public WebElement thirdWidgetKeyBenefit;
	@FindBy(xpath = "//*[text()='Submit']") public WebElement multiChoiceSubmitBtn;
	@FindBy(xpath = "//*[@id='topDiv']/following-sibling::div[2]/following-sibling::div[1]//p") public WebElement multiChoiceSelectedChoicesText;
	@FindBy(xpath = "//*[text()='xxxx']/parent::div/following-sibling::button") public WebElement threeDotsMenu;
	@FindBy(xpath = "//button[text()='Book a Stay']") public WebElement threeDotsMenuBookAStay;
	@FindBy(xpath = "//button[text()='Reserve a Table']") public WebElement threeDotsMenuReserveATable;
	@FindBy(xpath = "//button[text()='Shop Now']") public WebElement threeDotsMenuShopNow;
	@FindBy(xpath = "//button[text()='New Connection']") public WebElement threeDotsMenuNewConnection;
	@FindBy(xpath = "//button[text()='Quick Recharge']") public WebElement threeDotsMenuQuickRecharge;
	@FindBy(xpath = "//div[@id='topDiv']/parent::div") public WebElement channelHomePage;
	@FindBy(xpath = "//div[@id='bottomDiv']") public WebElement channelHomePageBottom;
	@FindBy(xpath = "//button[text()='Me']") public WebElement whoWillStay_Me;
	@FindBy(xpath = "//*[text()='Tata Sky Cross Sell-Content']") public WebElement cromaChannelCrossBrandTsContent;
	@FindBy(xpath = "//*[text()='Tata Sky Cross Sell-Content']/parent::div/parent::div/following-sibling::div[1]//*[text()='Get Tata Sky connection now']") public WebElement cromaChannelCrossBrandTsNewConection;
	
	
	
	
	//Manoranjan
	@FindBy(xpath = "//button[contains(text(),'View all')]") public WebElement viewAllChannelsButton;
	@FindBy(xpath = "//*[@type='search']/following::h2") public List <WebElement> viewAllChannelsList;
	@FindBy(xpath = "//*[contains(text(),'Channels')]/preceding::button") public WebElement backButton;
	@FindBy(xpath = "//*[contains(text(),'Channels')]/preceding::input") public  WebElement searchBar;
	@FindBy(xpath = "//button[contains(text(),'Ok, got it')]") public  WebElement okGotItErrorPopup;
	@FindBy(xpath = "(//*[@type='button']/preceding::h1)[2]") public  WebElement  channelPageName;
	@FindBy(xpath = "//*[@type='search']/following::h2") public  WebElement firstChannel;
	@FindBy(xpath = "//input[@placeholder='Search']/following::button") public  WebElement cancelSearchButton;
	@FindBy(xpath = "//*[@type='search']/preceding::img") public  WebElement magnifyingSearchGlass;
	@FindBy(xpath = "//*[@type='search']/following::h2//parent::div/following::div/span") public  WebElement mostRecentChannel;
	@FindBy(xpath = "//*[@type='search']/following::img") public List <WebElement> viewAllChannelsLogo;
	@FindBy(xpath = "//*[@type='search']/following::p") public List <WebElement> viewAllChannelsGenericMsg;
	@FindBy(xpath = "//*[@type='search']/following::h2//parent::div/following::div/span") public List <WebElement> viewAllChannelsMsgDate;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div[1]") public  WebElement tataCapitalFirstWidget;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div[2]/div/p") public  WebElement tataCapitalFirstWidgetContent;
	@FindBy(xpath = "(//*[@class='_1A2ur'])[1]") public  WebElement tataCapitalFirstWidgetVideoContent;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[4]/div") public  WebElement tataCapitalSecondWidget;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[6]/div[1]") public  WebElement tataCapitalKeybenifitWidget;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[6]/div[2]/h4") public  WebElement tataCapitalKeybenifitWidgetHeader;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[6]/div[2]/div/p") public  WebElement tataCapitalKeybenifitWidgetContent;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[3]/div[1]") public  WebElement airAssiaSecondWidget;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[3]/div[2]/h4") public  WebElement airAssiaSecondWidgetTitle;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[3]/div[2]/div") public  WebElement airAssiaSecondWidgetContentDesc;
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[3]/div/div[2]") public  WebElement airAssiaSecondWidgetDateTimer;
	@FindBy(xpath = "//h1[contains(text(),'Air Asia')]/following::button[1]") public  WebElement airAssiaMenu;
	@FindBy(xpath = "//h1[contains(text(),'Air Asia')]/following::button[1]/following::ul[1]/li[1]") public  WebElement airAssiaFirstMenu;
	@FindBy(xpath = "//h1[contains(text(),'Air Asia')]/following::button[1]/following::ul[1]/li[2]") public  WebElement airAssiaSecondMenu;
	@FindBy(xpath = "//*[@fill='url(#message_icon_gradient)']") public  WebElement channelMenu;
	@FindBy(xpath = "//button[text()='Accept']") public  WebElement accept_payment_CTA;
	@FindBy(xpath = "//button[text()='Decline']") public  WebElement decline_payment_CTA;
	@FindBy(xpath = "//*[@class='style__BackIcon-gbyLkD hQPvPJ']") public  WebElement backBtnPayment;
	@FindBy(xpath = "//button[text()='Yes']") public  WebElement popUpPayment_Yes;
	@FindBy(xpath = "//button[text()='No']") public  WebElement popUpPayment_No;
	@FindBy(xpath = "//div[contains(@class,'ModalDialog')]") public  WebElement popUpPayment_window;
	@FindBy(xpath = "//span[contains(text(),'mins')]") public  WebElement bounceOff_timer;
	@FindBy(xpath = "//span[contains(text(),'Your payment was interrupted')]") public  WebElement bounceOff_widget;
	@FindBy(xpath = "//button[text()='Proceed']") public  WebElement proceed_payment_CTA_BO;
	@FindBy(xpath = "//button[text()='Dismiss']") public  WebElement dismiss_payment_CTA_BO;
	@FindBy(xpath = "//h1[text()='Invoice']") public  WebElement payment_window_element;
	@FindBy(xpath = "//div[contains(@class, 'PopUpContainer')]") public  WebElement dismiss_pop_up_window;
	@FindBy(xpath = "//button[text()='Ok']") public  WebElement dismiss_pop_up_Ok_CTA;



	//dec 01//revathi//
	@FindBy(xpath = "//*[contains(text(),'Channels')]") public WebElement channel;
	@FindBy(xpath = "//*[contains(text(),'Channels')]/following::h2[(text()= 'Tata Pay')]") public WebElement channel_selection;
	@FindBy(xpath = "//*[contains(text(),'MerchantMandate')]") public WebElement merchantmandate;
	@FindBy(xpath = "//*[contains(text(),'MerchantMandate')]/../preceding-sibling::div/div/div[4]") public WebElement merchantmandate_amount;
	@FindBy(xpath = "//*[contains(text(),'MerchantMandate')]/../preceding-sibling::div/div/div[5]") public WebElement merchantmandate_bank_RRN;
	@FindBy(xpath = "//*[contains(text(),'Mandate Expired')]") public WebElement merchantmandate_Expired;
	@FindBy(xpath = "(//*[contains(text(),'Mandate Expired')]//preceding::div/span[(text()= 'MERCHANTMANDATE')])[2]") public WebElement merchantmandate_Expired_widget;
	
	
	//dec02//
	@FindBy(xpath = "//*[contains(text(),'Mandate Declined')]") public WebElement Mandate_Declined;
	@FindBy(xpath = "//*[contains(text(),'Mandate Declined')]/../preceding::div/div/p[(text()= 'Declined')]") public WebElement Mandate_Declined_msg;
	
	//dec03//
	@FindBy(xpath = "//*[contains(text(),'Mandate Created')]") public WebElement Mandate_accepted;
	@FindBy(xpath = "//*[contains(text(),'Mandate Created')]/../preceding::div/div/p[(text()= 'Accepted')]") public WebElement Mandate_accepted_msg;
	@FindBy(xpath = "//*[contains(text(),'Mandate Revoked')]") public WebElement Mandate_accept_revoke;
	@FindBy(xpath = "//*[contains(text(),'Mandate Revoked')]/../preceding::div/div/p[(text()= 'Revoked')]") public WebElement Mandate_accept_revoke_msg;
	@FindBy(xpath="//h1[contains(text(), 'Invoice')]") public WebElement Invoice_pg;
	@FindBy(xpath="//button[contains(text(), 'Pay')]") public WebElement invoice_pay_button;
	@FindBy(xpath="//h1[contains(text(), 'Tata Pay')]") public WebElement Tata_pay_pg;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]") public WebElement cancel_transaction;
	@FindBy(xpath = "//*[contains(text(),'cancel this transaction?')]") public WebElement cancel_transaction_popup;
	@FindBy(xpath = "//*[contains(text(),'Yes')]") public WebElement yes_cancel_popup;
	@FindBy(xpath = "(//*[contains(text(), 'Invoice')]/../div//div/span[1])[1]") public WebElement back_invoice;
	
	
	
	@FindBy(xpath = "//*[contains(text(),'PAYMENT REQUEST')]") public WebElement payment_request;
	@FindBy(xpath = "//*[contains(text(),'Expired')]") public WebElement payment_req_expired;
	@FindBy(xpath = "//*[contains(text(),'PAYMENT REQUEST')]//following::span[3]") public WebElement payment_order;


	//dec11//
	@FindBy(xpath = "//*[contains(text(),'Back To Homepage')]") public WebElement back_to_homepage;
	@FindBy(xpath = "//*[contains(text(),'Channels')]/following::h2[(text()= 'Utilities')]") public WebElement utilities_selection;
	@FindBy(xpath = "//*[contains(text(),'View all')]") public WebElement view_all_homepage;
	@FindBy(xpath = "//*[contains(text(),'Ok, got it')]") public WebElement tour_channel;
	@FindBy(xpath="//*[contains(text(),'Paid')]") public WebElement paid_Succes;
	@FindBy(xpath = "//*[contains(text(),'Order Details')]") public WebElement order_page;
	@FindBy(xpath = "//*[contains(text(),'Order Details')]/preceding::span") public WebElement order_page_back;
	@FindBy(xpath="//*[contains(text(),'Failed')]") public WebElement paid_failed;
	
	
	//deb02//
	@FindBy(xpath = "//*[@href='/channels/tpayPID']") public WebElement tataPay_tab;
	@FindBy(xpath = "//*[@href='/channels/billpayPID']") public WebElement billPay_tab;
	@FindBy(xpath = "//*[@href='/channels/financialsPID']") public WebElement financials_tab;
	@FindBy(xpath = "//*[@href='/channels/othersPID']") public WebElement others_tab;
	
	@FindBy(xpath = "//*[contains(text(),'Alerts')]") public WebElement alertTxt;
	@FindBy(xpath = "(//*[@href='/channels/view'])[1]") public WebElement channelNavigationBtn;
	
	@FindBy(xpath = "(//*[contains(text(),'Tpay')])[1]") public WebElement tataPay_Hdr;
	@FindBy(xpath = "(//*[contains(text(),'Bill Pay')])[1]") public WebElement billPay_Hdr;
	@FindBy(xpath = "(//*[contains(text(),'Financials')])[1]") public WebElement financials_Hdr;
	@FindBy(xpath = "(//*[contains(text(),'Others')])[1]") public WebElement others_Hdr;
	
	@FindBy(xpath = "//*[@href='/channels/tpayPID']/div[2]/h2") public WebElement tataPayTxt;
	@FindBy(xpath = "//*[@href='/channels/billpayPID']/div[2]/h2") public WebElement billPayTxt;
	@FindBy(xpath = "//*[@href='/channels/financialsPID']/div[2]/h2") public WebElement financialsTxt;
	@FindBy(xpath = "//*[@href='/channels/othersPID']/div[2]/h2") public WebElement othersTxt;
	
	@FindBy(xpath = "//*[@data-testid='homenavbar']/../div[3]/div/div[2]/div/h1") public WebElement categoryHdr;
	
	
}
