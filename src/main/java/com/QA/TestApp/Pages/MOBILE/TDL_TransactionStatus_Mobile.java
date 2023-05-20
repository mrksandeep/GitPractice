package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_TransactionStatus_Mobile {
	
	public TDL_TransactionStatus_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPaymentStatus") public MobileElement paynmentSuccessful_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/tvPaymentStatus") public MobileElement payment_success_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/btnDownloadInvoice") public MobileElement Download_invoice_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/imShareIcon") public MobileElement shareIcon_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/btnShare") public MobileElement shareButton_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/clOfferDetail") public MobileElement totalamtlabel_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/ivExpandView") public MobileElement paymentdetailsDropdown_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/btnViewDetails") public MobileElement orderdetailsBtn_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/btnBuyNow") public MobileElement vieworderbtn_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/btnHomePage") public MobileElement bckButton_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/tvTransactionStatus") public MobileElement errorMessageInpayementPage;
    @FindBy(id="com.tatadigital.tcp.dev:id/tvTransactionIdHeader") public MobileElement transactionHeader;
	
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Payment Successful!']") public MobileElement paynmentSuccessful_ios;
	@FindBy(xpath = "") public MobileElement paymentConfirmation_ios;
	@FindBy(xpath = "") public MobileElement successBtn_ios;
	@FindBy(xpath = "") public MobileElement hiddenBtn_ios;
	@FindBy(xpath = "") public MobileElement failureBtn_ios;
	@FindBy(xpath = "") public MobileElement transactionID_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='View Details'])[1]") public MobileElement viewDetails_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Payment Details']") public MobileElement paymentDetails_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='View Order'])[1]") public MobileElement viewOrder_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Back to Homepage']") public MobileElement backToHomepage_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Button']") public MobileElement closeBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Download Invoice']") public MobileElement downloadInvoice_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCP Points']") public MobileElement tcpPoint_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Share']") public MobileElement shareBtn_ios;

	}
