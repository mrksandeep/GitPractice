package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.QA.TestApp.Utilities.BaseScript;

public class TDL_Capillary_API_Page extends BaseScript{
	//===========================================================================
		//Capillary Validation
		@FindBy( xpath="//input[@id='login_user']")
		public WebElement enteremail;
		
		@FindBy( xpath="//input[@id='login_cred']")
		public WebElement enterpassword;
		
		@FindBy( xpath="//input[@id='c-login-btn']")
		public WebElement signinbuttonclick;
		
		@FindBy( xpath="//img[@class='intouch-nav-user-icon']")
		public WebElement avtaricon;
		
		@FindBy( xpath="//*[text()='Workbench']//preceding-sibling::*")
		public WebElement menuclick;
		
		@FindBy( xpath="//*[contains(text(),'Member Care')]")
		public WebElement membercareoption;
		
		@FindBy( xpath="//input[@id='customer_search__customer_identifier']")
		public WebElement searchboxcap;
		
		@FindBy( xpath="//*[@id='box-table-a']")
		public WebElement searchresultcap;
		
		@FindBy( xpath="//*[text()='Name']")
		public WebElement textname;
		
		@FindBy( xpath="//*[@id='mlp-program-id']")
		public WebElement programdropdown;
		
		@FindBy( xpath="//option[text()='Tata IHCL Loyalty']")
		public WebElement optionclick;
		
		@FindBy( xpath="//*[@id='currentPoints']")
		public WebElement currentpoints;
		
		@FindBy( xpath="//*[@id='slabName']")
		public WebElement tierSlab;
		
		@FindBy( xpath="//td[contains(text(),'Epicure Membership')]/following-sibling::td[1]")
		public WebElement epicureMembershipFlag;  //0 =false and 1=true
		
		@FindBy( xpath="//table[@id='table_linked_partner_program']/tbody/tr[1]/td[1]")
		public WebElement partnerLinkedProgName;
		
		
		@FindBy( xpath="//*[@id='slabExpiryDate']")
		public WebElement slabExpiryDate;
		
		@FindBy( xpath="//*[contains(text(),'More Information')]")
		public WebElement moreInfoSection;
		
		@FindBy( xpath="//*[contains(text(),'ORDERSSRSS5095C')]/parent::td//following-sibling::td[3]")
		public WebElement issuedPointsCapillary;
		
		@FindBy( xpath="//*[contains(text(),'Logout')]")
		public WebElement btnLogout;
		
		@FindBy( xpath="//*[@id='slabName']")
		public WebElement airasiaslab;
		
		@FindBy( xpath="//*[contains(text(),'Show Linked Partner Program')]")
		public WebElement showLinkedPartnerProgWidget;
		
		@FindBy( xpath="//*[contains(text(),'Epicure_Silver')]")
		public WebElement Epicure_SilverLinkedPartner;
		
		@FindBy( xpath="//*[contains(text(),'Epicure_Gold')]")
		public WebElement Epicure_GoldLinkedPartner;
		
		@FindBy( xpath="//*[contains(text(),'Global_Chambers')]")
		public WebElement Global_ChambersLinkedPartner;
		
		@FindBy( xpath="//*[contains(text(),'Local_Chambers')]")
		public WebElement Local_ChambersLinkedPartner;
		
		@FindBy( xpath="//*[contains(text(),'Shangri-La-IHCL')]")
		public WebElement ShangriLaIHCLLinkedPartner;
		
		@FindBy( xpath="//a[contains(@href,'points')]")
		public WebElement pointstab;
		
		@FindBy( xpath="//*[@class='edit_program']/parent::td[1]//preceding-sibling::td[6]")
		public WebElement vouchercode;
		
		@FindBy( xpath="//a[contains(text(),'Extended Fields')]")
		public WebElement extendedfields;
		
		@FindBy( xpath="//*[contains(text(),'room_nights_count')]//following::*")
		public WebElement nightcount;
		
		@FindBy( xpath="//*[contains(text(),'checkin_date')]//following::*")
		public WebElement startdate;
		
		@FindBy( xpath="//*[contains(text(),'checkout_date')]//following::*")
		public WebElement enddate;
		
		@FindBy( xpath="//a[text()='Redemptions']")
		public WebElement redemptiontab;
		
		@FindBy( xpath="//*[@class='edit_program']//preceding::td[5]")
		public WebElement pointsredeemed;
		
		@FindBy( xpath="//a[text()='Expiry schedule']")
		public WebElement expiryscheduletab;
		
		@FindBy( xpath="//*[@id='table_customer_points']/tbody/tr/td[1]")
		public WebElement expirypointdate;
		
		@FindBy( xpath="//*[text()='MEMBER STATUS']/following::label[1]")
		public WebElement memberstatustcp;
		
		@FindBy( xpath="//button[text()='Activity']/following::div[8]")
		public WebElement programnametcp;
		
		@FindBys(@FindBy( xpath="//*[text()='REGULAR']/following::td[7]"))
		public List<WebElement> points;
		
		@FindBys(@FindBy( xpath="//*[text()='REGULAR']/following::td[1]"))
		public List<WebElement> itemCode;
		
		@FindBy( xpath="//a[@id='redemptions-tab']")
		public WebElement pointsRedemptiontab;
		
		@FindBy( xpath="//a[contains(text(),'Tenders')]")
		public WebElement tendersTab;
		
		@FindBy( xpath="//td[contains(text(),'Cash')]//following::td[1]")
		public WebElement cashTender;
		
		@FindBy( xpath="//td[contains(text(),'Loyalty Points Redemption')]//following::td[1]")
		public WebElement pointsTender;
		
		@FindBy( xpath="//*[@id='cumulativePurchases']")
		public WebElement lifeTimePurchase;
		
		@FindBy( xpath="//*[@id='delayedPoints']")
		public WebElement promisedPoints;
		
		@FindBy( xpath="//*[@id='currentPoints']")
		public WebElement currentPoints;
		
		@FindBy( xpath="//a[@id='returns-tab']")
		public WebElement returnsTab;
		
		@FindBys(@FindBy( xpath="//*[text()='REGULAR']/following::td[8]"))
		public List<WebElement> pointsPromisedLineItems;
		
		@FindBys(@FindBy( xpath="//a[@href='#dt-table_promotional_points_table']"))
		public WebElement promortionalPointsTable;
		
		@FindBys(@FindBy( xpath="//*[@id='table_promotional_points_table']/tbody/tr"))
		public List<WebElement> promortionalPointsTableRows;
		
}
