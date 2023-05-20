package com.QA.TestApp.Pages.MOBILE;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_OrderHistory_Mobile {
	
	public TDL_OrderHistory_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose") public MobileElement backBtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTitleToolbarOrderHistory") public MobileElement orderHistoryText_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivOrderBack") public MobileElement orderBackBtn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/icOrderFilter") public MobileElement orderFilter_android;	
	@FindBy(xpath="//*[contains(@text, 'Credit Card')]") public MobileElement creditcard_android;
	@FindBy(xpath="//*[contains(@text, 'Debit Card')]") public MobileElement debitcard_android;	
	@FindBy(xpath="//*[contains(@text, 'UPI')]") public MobileElement upi_android;
	@FindBy(xpath="com.tatadigital.tcp.dev:id/tvByInstrument") public MobileElement byInstrument_android;
	@FindBy(xpath="//*[contains(@text, 'TCP Points')]") public MobileElement tcpPoint_android;
	@FindBy(xpath="//*[contains(@text, 'Tata Capital')]") public MobileElement tataCapital_android;
	@FindBy(xpath="//*[contains(@text, 'NetBanking')]") public MobileElement netBanking_android;	
	@FindBy(xpath="//*[contains(@text, 'Bill Payments')]") public MobileElement billPayments_android;
	@FindBy(xpath="//*[contains(@text, 'Croma')]") public MobileElement croma_android;	
	@FindBy(xpath="//*[contains(@text, 'IHCL')]") public MobileElement ihcl_android;
	@FindBy(xpath="//*[contains(@text, 'AIG')]") public MobileElement aig_android;
	@FindBy(xpath="//*[contains(@text, 'Tata Sky')]") public MobileElement tatasky_android;
	@FindBy(xpath="//*[contains(@text, 'Success')]") public MobileElement success_android;	
	@FindBy(xpath="//*[contains(@text, 'TRANSACTION STATUS')]") public MobileElement transactionStatus_android;
	@FindBy(xpath="//*[contains(@text, 'Failed')]") public MobileElement failed_android;	
	@FindBy(xpath="//*[contains(@text, 'Pending')]") public MobileElement pending_android;
	@FindBy(xpath="//*[contains(@text, 'Refund')]") public MobileElement refund_android;
	@FindBy(xpath="//*[contains(@text, 'All')]") public MobileElement all_android;
	@FindBy(xpath="//*[contains(@text, 'Today')]") public MobileElement today_android;	
	@FindBy(xpath="//*[contains(@text, 'BY DURATION')]") public MobileElement byDuration_android;
	@FindBy(xpath="//*[contains(@text, 'Last 7 days')]") public MobileElement last7Days_android;	
	@FindBy(xpath="//*[contains(@text, 'This month')]") public MobileElement thisMonth_android;

	@FindBy(xpath="//*[contains(@text, 'Custom')]") public MobileElement custom_android;
	@FindBy(xpath="//*[contains(@text, 'Reset')]") public MobileElement reset_android;
	@FindBy(xpath="//*[contains(@text, 'Apply')]") public MobileElement apply_android;	
	@FindBy(xpath="")public WebElement Logo_andriod;
	//@FindBy(xpath="com.tatadigital.tcp.dev:id/rvOrderHistory") public MobileElement selectOrder_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/clOrderHistoryItem") public List <MobileElement> selectOrder_andriod;
	
	//9-12
		@FindBy(id="com.tatadigital.tcp.dev:id/tvTxnId") public MobileElement orderTxnId_android;
		@FindBy(id="com.tatadigital.tcp.dev:id/tvTransactionDate") public MobileElement orderTxnDate_android;
	//	@FindBy(xpath="//*[@text='Order history']") public MobileElement orderHistory_android;
		@FindBy(xpath="//*[@text='My transactions']") public MobileElement orderHistory_android;
		
	//22-1
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvOrderNo")}) public List<MobileElement> orderNo_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOrderStatus") public MobileElement orderTxnStatus_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivArrow") public MobileElement orderTxnDownArrow_android;
	//12-4 Sourav
	@FindBy(id="com.tatadigital.tcp.dev:id/ivExpandView") public MobileElement orderTxnExpandArrow_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOrderDetailTxnID") public MobileElement orderdetailTxnID_android;
		
	@FindBy(xpath="//*[contains(@text, 'Air Asia')]") public MobileElement air_asia_brand_android;
	@FindBy(xpath="//*[contains(@text, 'Big Basket')]") public MobileElement big_basket_brand_android;
	@FindBy(xpath="//*[contains(@text, 'Cliq Luxury')]") public MobileElement cliq_luxury_brand_android;
	@FindBy(xpath="//*[contains(@text, 'Croma')]") public MobileElement croma_brand_android;
	@FindBy(xpath="//*[contains(@text, 'IHCL')]") public MobileElement ihcl_brand_android;
	@FindBy(xpath="//*[contains(@text, 'Qmin')]") public MobileElement qmin_brand_android;
	@FindBy(xpath="//*[contains(@text, 'Starbucks')]") public MobileElement starbucks_brand_android;
	@FindBy(xpath="//*[contains(@text, 'Tata Cliq')]") public MobileElement tata_cliq_brand_android;
	@FindBy(xpath="//*[contains(@text, 'Tata Sky')]") public MobileElement tata_sky_brand_android;
	
	@FindBy(xpath="//android.view.View[@content-desc='Logo']/android.widget.Image aa") public MobileElement air_asia_app_icon;
	@FindBy(xpath="(//*[contains(@text, 'bigbasket')])[2]") public MobileElement big_basket_app_icon;
	@FindBy(xpath="//android.view.View[@content-desc='Luxury Tata CLiQ']/android.view.View") public MobileElement cliq_luxury_app_icon;
	@FindBy(xpath="//android.view.View[@content-desc='Croma Logo']") public MobileElement croma_app_icon;
	@FindBy(xpath="//*[contains(@text, 'Find Your Reservations')]") public MobileElement ihcl_app_icon;
	@FindBy(xpath="//android.view.View[@content-desc='Logo']/android.widget.Image") public MobileElement qmin_app_icon;
	@FindBy(xpath="//android.view.View[@content-desc='Logo']/android.widget.Image") public MobileElement starbucks_app_icon;
	@FindBy(xpath="//android.view.View[@content-desc='goBackIcon']/android.widget.TextView") public MobileElement tata_cliq_app_icon;
	@FindBy(xpath="//android.view.View[@content-desc='Logo']/android.widget.Image") public MobileElement tata_sky_app_icon;
	
	
	@FindBy(xpath="//*[contains(@text, 'Manage My Booking')]") public MobileElement ihcl_Order_text;
	//26-7
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvOrderPurchaseDateTime") public MobileElement tvOrderDateTime_android;
	
	
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath="//XCUIElementTypeButton[@name='Back']") public MobileElement backBtn_ios;	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='My Orders'])[2]") public MobileElement myorderTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconFilter']") public MobileElement iconFilter_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Credit Card']") public MobileElement creditcard_ios;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Debit Card']") public MobileElement debitcard_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPI']") public MobileElement upi_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCP Points']") public MobileElement tcpPoint_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Tata Capital']")	public MobileElement tataCapital_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='NetBanking']") public MobileElement netBanking_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bill Payments']") public MobileElement billPayments_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Croma']")	public MobileElement croma_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='IHCL']") public MobileElement ihcl_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='AIG']") public MobileElement aig_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Tata Sky']") public MobileElement tataSky_ios;	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconCircleCross']") public MobileElement iconCircleCross_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Success']")	public MobileElement success_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='APPLY']") public MobileElement apply_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Custom']")	public MobileElement custom_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='This month']") public MobileElement thismonth_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Last 7 days']") public MobileElement last7days_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Today']")	public MobileElement today_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Failed']") public MobileElement failed_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Pending']") public MobileElement pending_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Refund']") public MobileElement refund_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='All']") public MobileElement all_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='BY CATEGORY']") public MobileElement byCtegory_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='BY DURATION']") public MobileElement byDuration_ios;		
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='TRANSACTION STATUS']") public MobileElement transactionStatus_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='RESET']") public MobileElement reset_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='All']") public MobileElement priceList_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Refund']") public MobileElement selectOrder_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='BY INSTRUMENT']") public MobileElement byInstrument_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Refund']") public MobileElement startDate_ios;	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='BY INSTRUMENT']") public MobileElement endDate_ios;
	@FindAll({@FindBy(xpath="//XCUIElementTypeStaticText")}) public List<MobileElement> lOrderDetails;
	
	//9nov//
	
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@value,'Order history')]") public MobileElement order_History_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='TCP'])[1]") public MobileElement selectOrder_any_ios;	
	@FindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell[1]") public MobileElement latestOrderPlaced_ios;
	@FindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[contains(@name,'UTR:')]") public MobileElement latestOrderUtrId_ios;
	@FindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[contains(@name,'/')]") public MobileElement latestOrderDateTime_ios;
	@FindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[contains(@name,'₹')]") public MobileElement latestOrderTxnAmount_ios;

	@FindBy(xpath="//XCUIElementTypeNavigationBar[@name='TCPApp.OrderHistoryListingView']") public MobileElement orderHistoryPageHeader_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Redirecting to the next page…']") public MobileElement redirectingToNxtPage_ios;
	@FindBy(xpath="//XCUIElementTypeNavigationBar[@name='TCPApp.UPITransactionHistoryDetailView']") public MobileElement orderDetailPageHeader_ios;

	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Air Asia']") public MobileElement air_asia_brand_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Big Basket']") public MobileElement big_basket_brand_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Cliq Luxury']") public MobileElement cliq_luxury_brand_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='Croma'])[1]") public MobileElement croma_brand_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='IHCL']") public MobileElement ihcl_brand_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Qmin']") public MobileElement qmin_brand_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Starbucks']") public MobileElement Starbucks_brand_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Tata Cliq']") public MobileElement Tata_Cliq_brand_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Tata Sky']") public MobileElement Tata_Sky_brand_ios;
	
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Manage My Booking']") public MobileElement ihcl_Order_text_ios;
	
	
	@FindBy(xpath="//XCUIElementTypeOther[@name='AirAsia India � Domestic Flights at Affordable Fares']/XCUIElementTypeOther[12]/XCUIElementTypeLink[1]/XCUIElementTypeImage") public MobileElement air_asia_app_icon_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='bigbasket'])[1]") public MobileElement big_basket_app_icon_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Luxury Tata CLiQ']") public MobileElement cliq_luxury_app_icon_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='bigbasket'])[1]") public MobileElement croma_app_icon_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Luxury Tata CLiQ']") public MobileElement ihcl_app_icon_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='bigbasket'])[1]") public MobileElement qmin_app_icon_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Luxury Tata CLiQ']") public MobileElement Starbucks_app_icon_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='bigbasket'])[1]") public MobileElement Tata_Cliq_app_icon_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Luxury Tata CLiQ']") public MobileElement Tata_Sky_app_icon_ios;
}