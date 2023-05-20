package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_OrderDetails_Mobile {
	
	public TDL_OrderDetails_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTitleToolbarOrderHistory") public MobileElement myOrderdetailstext_andriod;
	@FindBy(xpath="//android.widget.TextView[@text='QUANTITY']") public MobileElement ProductQuantity_andriod;
	@FindBy(xpath="//android.widget.TextView[@text='AMOUNT']")public MobileElement Amount_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivPaymentDetailsUPICard")public MobileElement card_andriod;
	@FindBy(xpath="//android.widget.TextView[@text='ITEM DESCRIPTION']")public MobileElement  ItemDescription_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvContactSupport")public MobileElement talkToUs_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOrderDetailTxnID")public MobileElement transactionID_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOrderTransaction_Id")public MobileElement orderID_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivExpandView")public MobileElement paymentexpandView_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOrderDateTime")public MobileElement dateTime_andriod;
	//6 nov//
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTitleToolbarRefund")public MobileElement Order_detail_pg_title_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOrderNo")public MobileElement Order_number_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOrderPurchaseDateTime")public MobileElement PurchaseDateTime_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvItemDescHeader")public MobileElement Order_description_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvItemQtyHeader")public MobileElement Order_quantity_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvItemAmtHeader")public MobileElement order_amount_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPaymentDetailsUPICard")public MobileElement card_details_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUPICardAmount")public MobileElement card_amount_trans_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvOrderName")public MobileElement Order_name_andriod;
	@FindBy(id="com.tatadigital.tcp.dev:id/toolbarMain")public MobileElement chat_box_andriod;
	@FindBy(xpath="//android.widget.TextView[@text='Failed']")public MobileElement failed_transaction;
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Details']") public MobileElement paymentDetails_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconChevronDown']") public MobileElement paymentDetailsDropdown_ios;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='QUANTITY'])[1]")	public MobileElement quantity_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Order ID']") public MobileElement orderId_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='AMOUNT'])[1]")	public MobileElement amount_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Ask for help']") public MobileElement talkTous_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Date & Time']") public MobileElement dateTime_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Today']")	public MobileElement bankIcon_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Failed']") public MobileElement transactionSuccess_ios;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Product']")	public MobileElement product_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='iconShare']") public MobileElement iconShare_ios;	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']")	public MobileElement backbutton_ios;
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='ITEM DESCRIPTION'])[1]") public MobileElement itemDescription_ios;	
	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='Order Details'])[1]") public MobileElement orderDetails_ios;	

//nov9//
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Talk To us']") public MobileElement talk_To_us_ios;
	@FindBy(xpath ="//XCUIElementTypeNavigationBar[@name='TCPUIKit.TCPWebView']")public MobileElement chat_box_ios;
}
