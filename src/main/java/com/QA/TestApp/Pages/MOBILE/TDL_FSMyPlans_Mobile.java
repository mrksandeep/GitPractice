package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_FSMyPlans_Mobile {
	
	public TDL_FSMyPlans_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/*
	 * Android Mobile Elements
	 * 
	 */
	@FindBy(xpath = "//*[contains(@text,'Order History')] | //*[contains(@text,'Order history')]") public MobileElement orderHistoryBtn_android;
	@FindBy(xpath = "//*[contains(@text,'My Orders')]") public MobileElement orderHistoryPageHeader_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clOrderHistoryItem") public List<MobileElement> orderHistoryPageItems_android;
	@FindBy(xpath = "//*[contains(@text,'My Orders')]") public MobileElement myOrderHeader_android;
	@FindBy(xpath = "//*[contains(@text,'FS-Insurance')] | //*[contains(@text,'Insurance')]") public MobileElement insuranceItem_android;
	@FindBy(xpath = "//*[contains(@text,'FS-Insurance')] | //*[contains(@text,'Insurance')]") public List<MobileElement> insuranceDisplayed_android;
	@FindBy(xpath = "//*[contains(@text,'Order Details')]") public MobileElement orderItemDetailsHeader_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etCertificateNumber") public MobileElement insurancePolicyNumber_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/constraint_top_info_layout") public List<MobileElement> planDetails_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/txtInsurancePolicyName") public MobileElement insurancePolicyName_android;
	@FindBy(xpath = "//*[contains(@text,'My Insurance Plans')]") public MobileElement myInsurancePlanLink_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivClose") public MobileElement backBtn_android;
	@FindBy(xpath = "//*[contains(@text,'My Plans')] | //*[contains(@text,'My Insurance Plans')]") public MobileElement mipPageHeader_android;
	@FindBy(xpath = "//*[contains(@text,'PLANS')]") public MobileElement plansTab_android;
	@FindBy(xpath = "//*[contains(@text,'Track Requests')]") public MobileElement trackRequestTab_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvInsuranceType") public List<MobileElement> itemNames_android;
	@FindBy(xpath = "//*[contains(@text,'View Details')]") public MobileElement viewDetailsBtn_android;
	@FindBy(xpath = "//*[contains(@text,'Home Away Secure Plan')]/following-sibling::*[2]") public MobileElement threeDotsHI_android;
	@FindBy(xpath = "//*[contains(@text,'Card Protection Plan')]/following-sibling::*[2] | //*[contains(@text,'Card Fraud Secure Plan')]/following-sibling::*[2]") public MobileElement threeDotsCPP_android;
	
	@FindBy(xpath = "//*[contains(@text,'Success')] | //*[contains(@text,'Cancellation')]") public MobileElement cancelText_android;
	
	/*
	 * iOS Mobile Elements
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Order History']") public MobileElement orderHistoryBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='My Orders']") public MobileElement orderHistoryPageHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']//XCUIElementTypeTable/*") public List<MobileElement> orderHistoryPageItems_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Failed']") public MobileElement failed_ios;
	
	@FindBy(xpath = "//XCUIElementTypeApplication[@name='TCP SIT']//XCUIElementTypeTable/*[1]") public MobileElement insuranceItem_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Order Details']") public MobileElement orderItemDetailsHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Home Insurance Plan' or @name='Card Protection Plan']/following-sibling::*") public List<MobileElement> planDetails_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Home Insurance Plan' or @name='Card Protection Plan']") public MobileElement insurancePolicyName_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Card Protection Plan']") public MobileElement CardPolicyName_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='My Insurance Plans ']") public MobileElement myInsurancePlanLink_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error\"]") public MobileElement errorPopUp_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Retry\"]") public MobileElement retryBtn_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Card Protection Plan\"]") public MobileElement cppPlan_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Card Fraud Secure Plan']//following-sibling::XCUIElementTypeButton[@name='optionIcon']") public MobileElement threeDotsCPP_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Home Away Secure Plan']//following-sibling::XCUIElementTypeButton[@name='optionIcon']") public MobileElement threeDotsHI_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Cancel Policy']") public MobileElement cancelPolicy_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Raise A Claim']") public MobileElement raiseClaimBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Track My Requests']") public MobileElement trackRequestTab_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Home Insurance Plan']//parent::*//XCUIElementTypeStaticText[@name='Cancellation in progress']") public MobileElement cancelText_ios;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']") public MobileElement myPlanBackBtn_ios;

	
	
	
	
	
	
}
