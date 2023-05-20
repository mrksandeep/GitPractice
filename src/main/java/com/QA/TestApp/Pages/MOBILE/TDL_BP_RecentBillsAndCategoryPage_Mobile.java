package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_BP_RecentBillsAndCategoryPage_Mobile {
	
	public TDL_BP_RecentBillsAndCategoryPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	//Android locators
	@FindBy(xpath = "//*[@text='Pay Bills']") public MobileElement recentBillsPgHeader_android;
	@FindBy(xpath = "//*[@text='RECENT BILLS'] | //*[@text='Recent Bills']") public MobileElement recentBillsTab_android;
	@FindBy(xpath = "//*[@text='You haven't added any bills yet']") public MobileElement recentBillsTabMsg_android;
	@FindBy(xpath = "//*[@text='BILLERS']") public MobileElement billersTab_android;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp.dev:id/tvOperatorName']") public List<MobileElement> recentBillsItems_android;
	@FindBy(xpath = "//*[@text='All Bills']") public MobileElement allBillsDropDown_android;
	@FindBy(xpath = "//*[@text='Due Bills']") public MobileElement dueBillsOption_android;
	@FindBy(xpath ="//*[@resource-id='com.tatadigital.tcp.dev:id/tvBillAmount']") public List<MobileElement> dueBillAmounts_android;
	@FindBy(xpath = "//*[@text='Add New Bill']") public MobileElement addNewBillBtn_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_message") public MobileElement allowLocationMsg_android;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button") public MobileElement locationPermission_android;
	
	@FindBy(xpath = "//*[@text='Utilities']") public MobileElement categorySelectionPgHeader_android;
	@FindBy(xpath = "//*[@text='Electricity']") public MobileElement electricity_android;
	@FindBy(xpath = "//*[@text='Water']") public MobileElement water_android;
	@FindBy(xpath = "//*[@text='Gas']") public MobileElement gas_android;
	@FindBy(xpath = "//*[@text='Broadband']") public MobileElement broadband_android;
	@FindBy(xpath = "//*[@text='DTH']") public MobileElement dth_android;
	@FindBy(xpath = "//*[@text='Landline']") public MobileElement landline_android;
	@FindBy(xpath = "//*[@text='Mobile Prepaid']") public MobileElement mobPrepaid_android;
	@FindBy(xpath = "//*[@text='Mobile Postpaid']") public MobileElement mobPostpaid_android;
	
	//recent bill tab
	@FindBy(xpath = "//*[@text='View Details']") public List<MobileElement> viewDetail_list_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvOperatorName") public List<MobileElement> aliasName_onBillDtls_txt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvConsumerNumber") public List<MobileElement> consumerNo_txt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvConsumerName") public List<MobileElement> consumerName_txt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBillNo") public List<MobileElement> billNo_txt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvBillDate") public List<MobileElement> billDate_txt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvDueDate") public List<MobileElement> billDueOn_txt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etRecentBillsAmount") public List<MobileElement> amount_onBillDtlsTab_txt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvLabelAmountDisclaimer") public List<MobileElement> convenienceFee_onBillDtlsTab_txt_android;
	@FindBy(xpath="//*[@text='Hide Details']") public MobileElement hideDetails_Android;
	//Akshya
	@FindBy(xpath="//*[contains(@text, 'Pay Bills')] | //*[contains(@text, 'Pay bills')]") public MobileElement btnpaybills;
	@FindBy(xpath="//*[contains(@text, 'Bill Payment')] | //*[@text='Pay Bills'] | //*[@text='Pay bills'] | //*[contains(@text,'Pay')]") public MobileElement Txtbillpayment;

	@FindBy(id="com.tatadigital.tcp.dev:id/payNewBill") public MobileElement btnAddnewbill;
	@FindBy(id="com.tatadigital.tcp.dev:id/negativeButton") public MobileElement btnClose;
	@FindBy(xpath="//*[@text='ALLOW']") public MobileElement allow_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/cbRecentBill") public List<MobileElement> recentbill_cb_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnProceed") public MobileElement nextbutton_rb_android;
	
	
	@FindBy(xpath="//*[contains(@text,'Vault')]") public MobileElement vaultbtn;
	@FindBy(xpath="(//*[@resource-id='com.tatadigital.tcp.dev:id/top_container'])[1]") public MobileElement paybillbtn;
	@FindBy(id="com.tatadigital.tcp.dev:id/addMoreBillTv") public MobileElement btnAddMoreBills;
	
	@FindBy(xpath = "//*[@text='Dish TV']") public MobileElement dishTv_android;
	@FindBy(id = "(com.tatadigital.tcp.dev:id/input_edit_text)[1]") public MobileElement dishTv_mobileNumber_android;
	@FindBy(id = "(com.tatadigital.tcp.dev:id/input_edit_text)[2]") public MobileElement dishTv_Amount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/fetchBillBt") public MobileElement proceed_Button_android;
	
	//@FindBy(xpath="//*[contains(@text,'Close')]") public MobileElement btnClose;
	
	
	/*
	 * due billdropdown-//*[@text='Due Bills'] paid billoption-//*[@text='Paid
	 * Bills']
	 */	
	
	
	//iOS locators
	@FindBy(xpath = "//XCUIElementTypeOther[@text='Pay Bills']") public MobileElement recentBillsPgHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='paymentKit.repeatUser.recentBill']") public MobileElement recentBillsTab_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='You havent added any bills yet.']") public MobileElement recentBillsTabMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='paymentKit.repeatUser.billers']") public MobileElement billersTab_ios;
	@FindBy(xpath = "//XCUIElementTypeTable[@name='paymentKit.recentBill.table']") public MobileElement recentBillsContainer_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='paymentKit.recentBill.addNewUpper']") public MobileElement addNewBillBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeAlert[@name='Allow TCP SIT to use your location?']") public MobileElement allowLocationMsg_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Allow While Using App\"]") public MobileElement locationPermission_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Allow Once']") public MobileElement allowOnce_ios;
	@FindBy(xpath = "//XCUIElementTypeAlert[@name='Don't Allow']") public MobileElement dontAllow_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Location permission is disabled\"]") public MobileElement disabledLocationPopup_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Utilities\"]") public MobileElement categorySelectionPgHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Electricity\"]") public MobileElement electricity_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Water']") public MobileElement water_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Gas\"]") public MobileElement gas_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Broadband\"]") public MobileElement broadband_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"DTH\"]") public MobileElement dth_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Landline\"]") public MobileElement landline_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile Prepaid\"]]") public MobileElement mobPrepaid_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile Postpaid\"]") public MobileElement mobPostpaid_ios;
	
	//nov 13//

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bill Payment']") public MobileElement category_pg_hdr_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Electricity']") public MobileElement electricity__new_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Water']") public MobileElement water_new_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Gas']") public MobileElement gas_new_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Landline']") public MobileElement Landline_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Broadband']") public MobileElement broadband_new_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='DTH']") public MobileElement DTH_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Postpaid']") public MobileElement mobile_postpaid_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Prepaid']") public MobileElement mobile_prepaid_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Allow While Using App']") public MobileElement allow_location_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Don’t Allow']") public MobileElement dontAllow_location_ios;
	

	@FindBy(xpath = "//XCUIElementTypeButton[@name='paymentKit.recentBill.addNewUpper']") public MobileElement add_new_bill_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='paymentKit.repeatUser.recentBill']") public MobileElement recent_bill_tab_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='paymentKit.repeatUser.billers']") public MobileElement biller_tab_ios;
    @FindBy(xpath = "//XCUIElementTypeButton[@name='All Bills']") public MobileElement all_bill_ios;
    @FindBy(xpath = "//XCUIElementTypeButton[@name='All Bills']") public MobileElement dueBillsOption_ios;
	@FindBy(xpath = "//XCUIElementTypeTable[@name='paymentKit.recentBill.table']/XCUIElementTypeCell") public List<MobileElement> recent_bill_ios;
	@FindBy(xpath = "//XCUIElementTypeTable[@name='paymentKit.recentBill.table']/XCUIElementTypeCell[1]") public MobileElement first_recent_bill_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='TCPPaymentsKit.RecentBills.expandBill']") public List<MobileElement> view_more_recent_bill_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Overdue')]") public List<MobileElement> overdue_bills_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Proceed']") public MobileElement proceed_ios;
	
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@label='Pay Bills'] | (//XCUIElementTypeOther[@name=\"tcpApp.home.TataPayCollectionViewCell.container\"])[2]") public MobileElement btnpaybills_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Bill Payment\"]") public MobileElement Txtbillpayment_ios;

	
}