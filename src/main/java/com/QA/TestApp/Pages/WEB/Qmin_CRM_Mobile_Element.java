package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Qmin_CRM_Mobile_Element extends BaseScript {

	public Qmin_CRM_Mobile_Element() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	@FindBy(id = "com.tatadigital.qmin:id/edtMobileNumber")
	public MobileElement Enter_phone;

	@FindBy(id = "com.tatadigital.qmin:id/imgRightArrow")
	public MobileElement Proceed_arrow;

	@FindBy(id = "com.tatadigital.qmin:id/edtOtp")
	public MobileElement Enter_otp;

	@FindBy(id = "com.tatadigital.qmin:id/edtPinCode")
	public MobileElement Enter_pincode;
	//Food Order    
	@FindBy(id = "com.tatadigital.qmin:id/btnAdd")
	public MobileElement AddtoCart_button;

	@FindBy(xpath = "//android.widget.TextView[(@text='ADD')]")
	public MobileElement Add_button;

	@FindBy(id = "com.tatadigital.qmin:id/chkTimeSlots")
	public MobileElement Time_Solt;

	@FindBy(id = "com.tatadigital.qmin:id/tvPayNow")
	public MobileElement Order_button;

	@FindBy(xpath = "//android.widget.EditText[@text='Add a special request']")
	public MobileElement Special_request;

	@FindBy(id = "com.tatadigital.qmin:id/txtShow")
	public MobileElement Show_offer;

	@FindBy(id = "com.tatadigital.qmin:id/edtCouponCode")
	public MobileElement coupon_code;

	@FindAll({@FindBy(id = "com.tatadigital.qmin:id/tvApply")})
	public List<MobileElement> apply_offer;

	@FindBy( id= "com.tatadigital.qmin:id/imgCutleryCheck")
	public MobileElement Add_cutlery;

	@FindBy( id= "com.tatadigital.qmin:id/tvPayNow")
	public MobileElement Pay_now;

	@FindBy( className= "android.widget.RadioButton")
	public MobileElement card_select;

	@FindBy( xpath= "//*[@class='android.widget.EditText']")
	public MobileElement Cvv_number;

	@FindBy( xpath= "//android.view.View[@content-desc=\"Cancel\"]/preceding-sibling::android.view.View[1]")
	public MobileElement make_paymet;

	@FindBy( className= "android.widget.Button")
	public MobileElement return_to_site;
	//Raise Ticket
	@FindBy( id= "com.tatadigital.qmin:id/clHome")
	public MobileElement Profile;

	@FindBy( id= "com.tatadigital.qmin:id/tvCustomerSupport")
	public MobileElement customer_support;

	@FindBy( id= "com.tatadigital.qmin:id/imgRemoveOrder")
	public MobileElement Order_select;

	@FindBy( id= "com.tatadigital.qmin:id/tvSubmit")
	public MobileElement Submit;

	@FindBy( id= "com.tatadigital.qmin:id/tvDescription")
	public MobileElement Success_message;

	@FindBy( id= "com.tatadigital.qmin:id/tvPositive")
	public MobileElement Click_Ok;

	@FindBy( id= "com.tatadigital.qmin:id/tvOrderPlaced")
	public MobileElement Order_success;

	@FindBy( id= "com.tatadigital.qmin:id/tvSeeDetails")
	public MobileElement see_details;

	@FindBy( id= "com.tatadigital.qmin:id/imgBack")
	public MobileElement back_button;

	@FindAll({@FindBy( xpath="//android.widget.GridView//android.view.View/android.view.View")})
	public List<MobileElement> membershipDetailslist;

	@FindBy( id= "com.tatadigital.qmin:id/nestedScrollView")
	public MobileElement Scrollable_element;

	@FindBy( id= "com.tatadigital.qmin:id/clIssueWithMyOrder")
	public MobileElement Issue;

	@FindBy( id= "com.tatadigital.qmin:id/constraintMain")
	public MobileElement order_type;

	@FindBy( xpath= "//android.widget.TextView[@text='Schedule an Order']")
	public MobileElement schedule_order;

	@FindBy( xpath= "//android.widget.TextView[@text='Order Now']")
	public MobileElement order_now;

	@FindBy( id= "com.tatadigital.qmin:id/tvRestaurantName")
	public MobileElement restraunt_name;

	@FindBy( id= "com.tatadigital.qmin:id/imgAdd")
	public MobileElement add_more ;

	@FindBy( xpath= "(//*[contains(@text,'Order')])[1]")
	public MobileElement order_number;

	@FindBy( id= "com.tatadigital.qmin:id/tvOrderAmount")
	public MobileElement billamount;

	//15.12.2020
	@FindBy( id= "com.tatadigital.qmin:id/imgDish")
	public MobileElement dishimage;

	@FindBy( xpath= "//*[@text='Select time slot']")
	public MobileElement select_time_slot;

	@FindBy( id= "com.tatadigital.qmin:id/tvOtherRestaurant")
	public MobileElement other_restaurant;

	@FindAll({@FindBy(id="com.tatadigital.qmin:id/imgCheck")})
	public List<MobileElement> select_radio_button;

	//Tcp Sit xpaths
	/*Android        
	 * 
	 */
	@FindBy( id="com.tatadigital.tcp.dev:id/ivDefaultProfilePic")
	public MobileElement ProfilepicAvtar;

	@FindBy( xpath="//*[contains(@text, 'Order history')]")
	public MobileElement btnorderHistory;

	@FindBy( id="com.tatadigital.tcp.dev:id/tvStoreName")
	public MobileElement firstUserName;

	@FindBy( id="com.tatadigital.tcp.dev:id/tvContactSupport")
	public MobileElement talkToUs;

	@FindBy( xpath="//android.widget.RadioButton[@resource-id= 'joe-radio-1']/parent::android.view.View")
	public MobileElement btnYes;

	@FindBy( xpath="//*[contains(@text,'need further help')]/following::android.view.View[3]")
	public MobileElement btnNo;

	@FindBy( id="com.tatadigital.tcp.dev:id/tvOrderStatus")
	public MobileElement orderStatus;

	@FindBy( xpath="//*[contains(@text, 'What else can I help you with')]")
	public MobileElement txtyesIdo;

	@FindBy( xpath="//*[@class='android.widget.EditText']")
	public MobileElement EditTextField;

	@FindBy( xpath="//*[@class='android.widget.EditText']/following::*")
	public MobileElement cusorbtn;

	@FindBy( xpath="//*[contains(@text, 'Hi')]")
	public MobileElement hiMesg;

	@FindAll({@FindBy( xpath="//*[contains(@text,'UTR')]")})
	public List<MobileElement>utrnos;

	@FindAll({@FindBy( id="com.tatadigital.tcp.dev:id/tv_block")})
	public List<MobileElement>block_buttons;

	@FindBy(id="com.tatadigital.tcp.dev:id/iv_back")
	public MobileElement backbutton;

	@FindBy(id="com.tatadigital.tcp.dev:id/btnBookNow")
	public MobileElement talktousclick;

	@FindBy(xpath="//android.widget.EditText")
	public MobileElement queryinputFieldAndroid;

	@FindBy(xpath="//*[contains(@text, 'ago')]")
	public MobileElement agoText;

	@FindBy(xpath="//*[contains(@text, 'not right here')]")
	public MobileElement errMessage;

	@FindBy(xpath="//*[contains(@text, 'You want to transfer')]")
	public MobileElement confirmationMesg;

	@FindBy(xpath="//*[contains(@text, 'I have raised a ticket')]")
	public MobileElement getTicketNo;

	@FindBy( xpath="//*[contains(@text,'Anything else that')]/following::android.widget.RadioButton[2]")
	public MobileElement exitChatMesg;

	@FindBy( xpath="//*[contains(@text,'like to proceed further')]/following::android.widget.RadioButton[1]")
	public MobileElement yesclick1;

	@FindBy( xpath="//*[contains(@text,'Would you like to initiate transfer')]/following::android.widget.RadioButton[1]")
	public MobileElement yesclick2;

	@FindBy(xpath="//*[contains(@text, 'Feedback')]")
	public MobileElement feedbackMesg;

	@FindBy(xpath="//*[contains(@text, 'Help')]")
	public MobileElement btnHelp;

	@FindBy(xpath="//*[@resource-id='support-search-input']")
	public MobileElement querySearchinputField;

	@FindBy(xpath="(//*[contains(@text, '?UPI')])[2]")
	public MobileElement firstsearchedresult;

	@FindBy(xpath="//*[contains(@text, 'Click here')]")
	public MobileElement btnclickhere;

	@FindBy(xpath="//*[contains(@text, 'I am your TCP virtual assistant')]")
	public MobileElement greetingMesg;

	@FindBy(xpath="//*[contains(@text, 'Yes')]")
	public MobileElement btnYesPlease;

	@FindBy(xpath="//*[contains(@text, 'Please wait')]|//*[contains(@text,'How would you rate')]")
	public MobileElement btnYesvalidation;

	@FindBy(xpath="//*[contains(@text, 'No')]")
	public MobileElement btnNoThanks;

	@FindBy(xpath="//android.widget.EditText/following::*[1]")
	public MobileElement sendbutton_click;

	@FindBy(xpath="//*[contains(@text,'Please check')]/following::android.view.View[3]")
	public MobileElement mobile_re_enter;

	@FindBy(xpath="//*[contains(@text,'Would you like to')]/following::android.view.View[4]")
	public MobileElement last_no_click;

	@FindBy(xpath="//*[contains(@text,'Anything else')]/following::android.view.View[4]")
	public MobileElement chat_end_message;

	@FindBy(xpath="//*[contains(@text,'Would you like to')]/following::android.view.View[3]")
	public MobileElement last_yes_click;

	@FindBy(xpath="//*[contains(@text, 'let me connect you to a customer support')]")
	public MobileElement support_message;

	@FindBy(xpath="//*[contains(@text,'Sorry')]")
	public MobileElement emailmessage;

	//Akshya
	@FindBy(xpath="//*[@resource-id='joe-radio-2']/parent::*")
	public MobileElement btnMobilenoenteredCorrect;

	@FindBy(xpath="//*[contains(@text, 'You need to register on TCP app')]")
	public MobileElement Txtvaliadation;

	@FindBy(xpath="//android.widget.EditText/following::*[1]")
	public MobileElement arrowbtnclick;

	@FindBy(xpath="//*[contains(@text, 'inactive')]")
	public MobileElement inactiveTxt;

	@FindBy(xpath="//*[contains(@text, 'Email id')]")
	public MobileElement firstWrongEamilidTxt;

	@FindBy(xpath="//*[contains(@text, 'customer support executive')] | //*[contains(@text, 'Our agents have clocked out for the day')]" )
	public MobileElement secandwrongEmailidtxt;
	
	@FindBy(xpath="//*[contains(@text,'105311152264')]")
	public MobileElement order_status;
	
	@FindBy(xpath="//*[@text='My Orders']")
	public MobileElement my_orders;
	
	@FindBy(xpath="//*[@class='android.widget.EditText']/following::*[4]")
	public MobileElement query_click;
	
	@FindBy(xpath="//*[contains(@text,'look into this')]/following::android.view.View[3]")
	public MobileElement receiver_check_yes;
	
	@FindBy(xpath="//*[contains(@text,'look into this')]/following::android.view.View[4]")
	public MobileElement receiver_check_no;
	
	@FindBy(xpath="//*[contains(@text,'raise a ticket')]/following::android.view.View[5]")
	public MobileElement ticket_raise_yes;
	
	@FindBy(xpath="//*[contains(@text,'raise a ticket')]/following::android.view.View[6]")
	public MobileElement ticket_raise_no;
	
	@FindBy(xpath="//*[contains(@text,'raised a ticket')]")
	public MobileElement get_ticket_no;
	
	
	
	//=======================================IOS========================================//
	@FindBy(xpath="//XCUIElementTypeOther[@name='Help']")
	public MobileElement helpbuttonios;

	@FindBy(xpath="//XCUIElementTypeStaticText[@name='View all']")
	public MobileElement viewallbuttonios;

	@FindBy(xpath="//XCUIElementTypeStaticText[@name='What is UPI?']")
	public MobileElement queryios;

	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Click here']")
	public MobileElement moreassitclick;

	@FindBy(xpath="//*[contains(@name, 'Looks like this')]")
	public MobileElement chatendmessage;
}
