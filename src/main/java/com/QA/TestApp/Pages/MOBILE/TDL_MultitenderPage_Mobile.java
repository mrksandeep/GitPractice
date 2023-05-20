package com.QA.TestApp.Pages.MOBILE;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_MultitenderPage_Mobile {
	
	public TDL_MultitenderPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAddPaymentOption") public MobileElement change_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/edCvv") public MobileElement cvv_android;
	@FindBy(xpath = "//button[contains(text(), 'Pay')]") public MobileElement payBtn_android;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View") public MobileElement enterOTPTxt_android;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.EditText") public MobileElement otpField_android;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.Button") public MobileElement submitBtn_android;
	//@FindBy(xpath = "//*[contains(text(),'Submit')]/../../input") public WebElement otpField_android;
	@FindBy(xpath = "//*[contains(text(),'Payment Complete')]") public MobileElement paymentSuccessTxt_android;
	@FindBy(xpath = "//*[contains(@text,'Welcome to Razorpay')]") public MobileElement razorPay_android;
	@FindBy(xpath = "//*[contains(@text,'Success')]") public MobileElement success_android;
	
	
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvPaymentsMethods") public MobileElement paymentsMethodsTxt_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/btnPayMultitender") public MobileElement payMultitender_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAddNewCard") public MobileElement addNewCard_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTotalAmountHeader") public MobileElement totalAmountHeaderCredit_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvTotalAmountHeaderDebit") public MobileElement totalAmountHeaderDebit_android;
	@FindBy(id ="com.tatadigital.tcp.dev:id/tvNetBanking") public MobileElement netBanking_android;
	@FindBy(xpath ="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.cardview.widget.CardView") public MobileElement icici_android;
	@FindBy(xpath ="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.cardview.widget.CardView") public MobileElement hdfc_android;
	@FindBy(xpath ="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.cardview.widget.CardView/android.widget.ImageView") public MobileElement axis_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/cbTcpPoints") public MobileElement tcpPointsCheckbx_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/tvEditTataOnePoint") public MobileElement editTcppts_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/etLoyalityAmount") public MobileElement tcpPointstextbx_android;
    @FindBy(id="com.tatadigital.tcp.dev:id/buttonLoyalityModel")public MobileElement confrimbtnTcppts_andrid;
    @FindBy()public MobileElement allErrorElementsInMultitenderPage_android;


 
     

	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Change']") public MobileElement change_ios;
	@FindBy(xpath = "//XCUIElementTypeSecureTextField[contains(@value,'Enter CVV')]") public MobileElement cvv_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='TOTAL AMOUNT']") public MobileElement paymentsMethodsTxt_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[contains(@name,'Pay')]") public MobileElement payMultitender_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add New']") public MobileElement addNewCard_ios;
	@FindBy(xpath = "//XCUIElementTypeOther[@name='CREDIT CARD']") public MobileElement totalAmountHeaderCredit_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='DEBIT CARD']") public MobileElement totalAmountHeaderDebit_ios;
	@FindBy(xpath ="(//XCUIElementTypeButton[@name='unselectedCheckbox'])[2]") public MobileElement loyaltypointunselectedCheckbox_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TCP Points']") public MobileElement tcpPoints_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Methods X: ']") public MobileElement paymentMethodTxt_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='TOTAL AMOUNT']") public MobileElement totalAmountTxt_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='â‚¹ 1']") public MobileElement rs_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='back']") public MobileElement backbtn_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Credit Card, Debit Card, Tata Pay UPI']") public MobileElement debit_credit_upi_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='View']") public MobileElement viewBtn_ios;
	public MobileElement moreBanks_ios;
	public MobileElement  otherBanksTxt_ios;
	public MobileElement searchBox_ios;
	@FindBy(xpath ="(//XCUIElementTypeButton[@name='unselectedCheckbox])[2]") public MobileElement tcpPointsCheckbx_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Edit']") public MobileElement editCTA_ios;
	@FindBy(xpath ="//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]") public MobileElement confirmBtn_ios;
	public MobileElement customTcpPointsInput_ios;
	@FindBy(xpath ="(//XCUIElementTypeButton[@name='radioButtonUnselected'])[1]") public MobileElement  firstcreditcard_ios;
	@FindBy(xpath ="(//XCUIElementTypeButton[@name='radioButtonUnselected'])[2]") public MobileElement  secondcreditcard_ios;
	@FindBy(xpath ="(//XCUIElementTypeButton[@name='radioButtonUnselected'])[3]") public MobileElement  thirdcreditcard_ios;
	@FindBy(xpath ="(//XCUIElementTypeButton[@name='radioButtonUnselected'])[4]") public MobileElement  fourthcreditcard_ios;
	@FindBy(xpath ="(//XCUIElementTypeButton[@name='radioButtonUnselected'])[5]") public MobileElement  fifthcreditcard_ios;
	@FindBy(xpath ="(//XCUIElementTypeButton[@name='radioButtonUnselected'])[6]") public MobileElement  sixthcreditcard_ios;

}












