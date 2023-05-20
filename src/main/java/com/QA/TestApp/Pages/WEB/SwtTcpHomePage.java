package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwtTcpHomePage {
	
//	@FindBy(xpath = "//*[@class='Carousel__Item-ebKQpf jfsEXy']")
//	public List<WebElement> herobannerDetails;
	
	@FindBy(xpath = "(//div[@class='Flex__Box-kdyZDI beBEsA Carousel__ControlPanel-eihPqL gQnbC']//*[@fill-rule='evenodd'])[2]")
	public WebElement heroBannerofferClick;
	
	@FindBy(xpath = "//*[contains(text(),'Croma')]/parent::div/following-sibling::div//*[contains(text(),'View Details')]")
	public WebElement cromaHomePage;
	
	@FindBy(xpath = "//*[contains(text(),'Holiday')]/following-sibling::div//*[contains(text(),'View Details')]")
	public WebElement ihclBookHoliday;
	
	@FindBy(xpath = "//*[contains(text(),'Event journey')]/following-sibling::div//*[contains(text(),'View Details')]")
	public WebElement ihclEventJourney;
	
	@FindBy(xpath = "//*[contains(text(),'SHOWCASE')]/following-sibling::div//*[contains(text(),'Buy Now')]")
	public WebElement tataSkyShowcase;
	
	@FindBy(xpath = "//*[contains(text(),'New connection')]/following-sibling::div//*[contains(text(),'Buy Now')]")
	public WebElement tataSkyNewConnection;
	
	@FindBy(xpath = "//*[contains(text(),'Quick Recharge')]/following-sibling::div//*[contains(text(),'View Details')]")
	public WebElement tataSkyQuickRecharge;
	
	@FindBy(xpath = "//*[contains(text(),'F&B')]/following-sibling::div//*[contains(text(),'View Details')]")
	public WebElement ihclFAndBJourney;
	
	@FindBy(xpath = "//a[@href='/vault']") public WebElement vaultLink;
	
	//Croma
	@FindBy(xpath = "//a[@class='logo']") public WebElement cromaheader;
    @FindBy(xpath = "//*[@id='search']") public WebElement searchproduct;

	@FindBy(xpath = "//*[contains(text(),'Enter Pincode')]") public WebElement deliverypincode;
	

	@FindBy(xpath = "//*[contains(@type,'text') and contains(@name,'number')]") public WebElement enterpincode;
	@FindBy(xpath = "//*[contains(text(),'APPLY')]") public WebElement applybtn;
    @FindBy(xpath = "//button[contains(text(),'buy now')]") public WebElement buynowbtn;
    @FindBy(xpath = "//div[text()='Payment Detail']") public WebElement paymentdetailheader;
	@FindBy(xpath = "//*[contains(text(),'CHECKOUT')]") public WebElement checkout;
	@FindBy(xpath = "//*[contains(text(),'CHANGE ADDRESS') and contain	s(@type,'button')]") public WebElement changeaddress;
	@FindBy(xpath = "//*[contains(text(),'ADD ADDRESS') and contains(@type,'button')]") public WebElement addaddress;
	@FindBy(name = "shipFName") public WebElement firstname;
	@FindBy(name = "shipLName") public WebElement lastname;
	@FindBy(name = "shipAddLine1") public WebElement flatno;
	@FindBy(id = "state_id") public WebElement state;
	@FindBy(id = "city_id") public WebElement cityid;
	@FindBy(xpath = "//*[contains(text(),'select payment')]") public WebElement selectpayment;
	@FindBy(name = "shipAddLine2") public WebElement landmark;
	@FindBy(xpath = "//*[contains(text(),'Payment Options')] | //*[contains(text(),'tata digital Options')] | //*[(text()='Payment')]") public WebElement paymentPageHeader; 
	
	// after Hero Banner Croma 
	
	@FindBy(xpath = "//*[contains(text(),'Buy Now')]") public WebElement cromaBuynowbtn;
	
	// after Hero Banner IHCL
	@FindBy(xpath = "//*[contains(text(),'Book Now')]") public WebElement ihclBooknowbtn;
	
	//Croma Card
	
	@FindBy(xpath = "//*[contains(text(),'PAYMENT METHODS')]/parent::div/parent::div/following-sibling::div/div[1]/div//h4[contains(text(),'Croma')]/parent::div/parent::div/parent::div//h4[contains(text(),'View')]") public WebElement cromaViewDetails;
	@FindBy(xpath = "//*[contains(text(),'Shop Now')]") public WebElement cromashopnowbtn;
	@FindBy(xpath = "//*[contains(text(),'We are sorry but the transaction failed.')]") public WebElement paymentFailure;
	
	//IHCL Card	
	@FindBy(xpath = "//*[contains(text(),'PAYMENT METHODS')]/parent::div/parent::div/following-sibling::div/div[1]/div//h4[contains(text(),'IHCL')]/parent::div/parent::div/parent::div//h4[contains(text(),'View')]") public WebElement ihclViewDetails;
	@FindBy(xpath = "//*[contains(text(),'Book Now')]") public WebElement IHCLBookNowBtn;
		
	//IHCL after clicking Book Now in Vault Cards
	//Same tab
    @FindBy(xpath = "//*[@value='self']") public WebElement selfBooking;
    //Akshya
	@FindBy(xpath = "//*[@id='page-scope']/following-sibling::*[@data-dialog-btn='bookAStay']") public WebElement bookAStay;
	//Akshya
	@FindBy(xpath = "//*[@aria-label='search bar']") public WebElement searchHotel;

	@FindBy(xpath = "(//*[contains(text(),'Taj Mahal, Lucknow')])[1]") public WebElement TajMahalLucknow;
		
    @FindBy(xpath = "//*[@id='global-re-direct']//parent::div") public WebElement checkAvailabiltyBtn;
    @FindBy(xpath = "//*[@data-rate-filter-code='STD']") public WebElement standardRates;
    @FindBy(xpath = "//*[@id='header-profile']") public WebElement profileHeader;
    @FindBy(xpath = "(//*[@id='header-profile']/following::span[5])[1]") public WebElement profileHeaderUsername;
    @FindBy(xpath = "//*[@value='others']") public WebElement guestBooking;
    @FindBy(xpath = "//*[@data-view-details='close']") public WebElement viewRates;
    @FindBy(xpath = "//*[@itemprop='name']") public WebElement roomDescription;
    @FindBy(xpath = "//*[@itemprop='price']") public WebElement roomPrice;
    @FindBy(xpath = "//*[@data-room-details='close']") public WebElement roomDetails;
    @FindBy(xpath = "//*[@class='cm-btn-secondary more-rates-select-btn']") public WebElement selectRoom;
    @FindBy(xpath = "(//*[contains(text(),'CONFIRM')])[2]") public WebElement confirmBtn;
    @FindBy(xpath = "//*[@id='bookingGuestTitleSelectBoxIt']") public WebElement guestTitle;
    @FindBy(xpath = "//*[@name='privacyPolicy']//parent::label") public WebElement privacyPolicyCheckBox;
    @FindBy(xpath = "//*[@name='termsAndConditions']//parent::label") public WebElement termsAndConditionsCheckBox;
    @FindBy(xpath = "//*[@id='btn-proceed']") public WebElement proceedBtn;
    @FindBy(xpath = "//*[@id='PAYONLINENOW']/parent::div") public WebElement payNowBtn;
    @FindBy(xpath = "//*[@id='PAYATHOTEL']/parent::div") public WebElement payAtHotelBtn;
    @FindBy(xpath = "//*[contains(text(),'Payment details')]") public WebElement headerPaymentDetails;
    @FindBy(xpath = "//*[@name='nameOnCard']") public WebElement nameOnCard;
    @FindBy(xpath = "//*[@aria-label='Card Number*']") public WebElement cardNumber;
    @FindBy(xpath = "//*[@id='creditCardExpiryDate']") public WebElement cardExpDate;
    @FindBy(xpath = "//*[@id='searchbar-Dining-input']") public WebElement searchBarResturant;
    @FindBy(xpath = "(//*[contains(@href,'varuna')])[4]") public WebElement reserveTable;
    @FindBy(xpath = "//*[contains(text(),'Average')]//following::div[2]/span[2]") public WebElement bookingPage;
    @FindBy(xpath = "//*[@placeholder='Date']") public WebElement selectDate;
    @FindBy(xpath = "//*[@id='mr-reserveTable-number-of-peopleSelectBoxItText']") public WebElement noOfPeople;
    @FindBy(xpath = "//*[@id='mr-reserveTable-meal-typeSelectBoxIt']") public WebElement mealType;
    @FindBy(xpath = "(//*[contains(text(),'Check Availability')])[3]") public WebElement checkAvl;
    @FindBy(xpath = "//*[@name='meal-timing']/parent::div") public List <WebElement> mealTiming;
    @FindBy(xpath = "//*[@name='filterCheckbox']/parent::label") public WebElement filterCheckBox;
    @FindBy(xpath = "(//*[contains(text(),'Submit')])[4]") public WebElement submitBtnDining;
    @FindBy(xpath = "//*[contains(text(),'Confirmed')]") public WebElement bookingConfirmed;
    @FindBy(xpath = "//*[@id='jiva-spa-date']/div/div[1]/table/tbody") public List <WebElement> daysNumber;
    @FindBy(xpath = "//*[contains(text(),'PAYMENT METHODS')]/parent::div/parent::div/following-sibling::div/div[1]/div//h4[contains(text(),'U Points')]/parent::div/parent::div/parent::div//h4[contains(text(),'View')]") public WebElement loyaltyCard;
  
 


	//After cicking IHCL Evnt journey form hero Banner' in new TAB
	//swtich to new tab
    @FindBy(xpath = "//*[contains(text(),'Book Now')]") public WebElement bookNowEvent;
    
    @FindBy(xpath = "//*[(text()='BOOK A HOLIDAY')]") public WebElement bookAHoliday;
    @FindBy(xpath = "//*[@alt='Taj Hotels logo'] | //*[@alt='taj']") public WebElement tajHotelLogo;
    @FindBy(xpath = "//*[@class='taj-image  holidays-logo-image']") public WebElement tajLogoBookingAHoliday;
	
    /* Croma Order COnfirmation PAge*/
    @FindBy(xpath = "//*[(text()='Thank you for shopping with us')]") public WebElement thankYouForShoppingHeader;
    @FindBy(xpath = "//*[@class='order-id-desc']") public WebElement orderId;
    @FindBy(xpath = "//*[contains(text(),'Order Received!')]") public WebElement orderRecvText;
    @FindBy(xpath = "//*[@data-testid='id-view']/div") public WebElement trxnid;
    @FindBy(xpath = "//*[@data-testid='id-view']/div") public WebElement downloadOption;

    
    
    //IHCL
    //Revathi
    @FindBy(xpath = "//*[contains(text(),'Title : Buy 3 for the price of 2')]") public WebElement IHCL_OFFER;
    @FindBy(xpath = "//*[contains(text(),'Book Now')]") public WebElement IHCL_BOOK_NOW;
    @FindBy(xpath = "//button[contains(text(),'Me')]") public WebElement IHCL_ME;
    @FindBy(xpath = "(//*[contains(text(),'Hi,')])[2]") public WebElement IHCL_Home;
  
   
    
  //Manoranjan
    @FindBy(xpath = "//button[@data-testid='shopnow']") public WebElement shopNowCroma;
    @FindBy(xpath = "//input[@id='homeDelivery']/following::span[1]") public WebElement homeDelivery;
    @FindBy(xpath = "//*[contains(text(),'compare')]/following::label") public WebElement ProductIdCroma;
    @FindBy(xpath = "//*[contains(text(),'compare')]/following::h1") public WebElement ProductDescCroma;
    @FindBy(xpath = "//*[contains(text(),'Channels')]/preceding::button") public WebElement BackButton;
    @FindBy(xpath = "//*[contains(text(),'Retry the transaction.')]") public WebElement reTryTrxn;
    @FindBy(xpath = "//*[@id='try-again-button']") public WebElement TryAgainButton;
    @FindBy(xpath = "//*[contains(text(),'No active subscriber')]") public WebElement NoSubscriber;
    @FindBy(xpath = "//*[contains(text(),'Go to Homepage')]") public WebElement NoSubscriberGoToHomePage;
    @FindBy(xpath = "//*[contains(text(),'Active subscriber ID')]") public WebElement activeSubscriber;
    @FindBy(xpath = "//*[contains(text(),'Continue')]") public WebElement continueButton;
    @FindBy(xpath = "//*[contains(text(),'Order')]") public WebElement orderButton;
    @FindBy(xpath = "//*[contains(text(),'Order')]/preceding::h2") public WebElement movieName;
    @FindBy(xpath = "//*[contains(text(),'Order')]/parent::button/parent::div/parent::div/div/div/span") public WebElement moviePrice;
    @FindBy(xpath = "//*[contains(text(),'Select Show Date')]/following::div/span/div/div/div/div") public WebElement movieDate;
    @FindBy(xpath = "//*[contains(text(),'Order Charges:')]/preceding::h2") public WebElement orderConfirmation;
    @FindBy(xpath = "//*[contains(text(),'Order Charges:')]/following::h3") public WebElement movieConfirmation;
    @FindBy(xpath = "//*[contains(text(),'Confirm')]") public WebElement orderConfirm;
    @FindBy(xpath = "//*[@align='center']") public WebElement trxnId;
    @FindBy(xpath = "//*[contains(text(),'Now Showing')]") public WebElement nowShowing;
    @FindBy(xpath = "//*[contains(text(),'Now Showing')]//following::div[2]//div/h5/a") public WebElement nowShowingMovieName;
    @FindBy(xpath = "//*[contains(text(),'Now Showing')]//following::div[2]//div/h6") public WebElement nowShowingMoviePrice;
    @FindBy(xpath = "//*[contains(text(),'Rent')]/preceding::h4[1]/following::div[1]/p") public WebElement tataSkyContentTC;
    @FindBy(xpath = "//*[contains(text(),'Rent')]") public WebElement rentNow;
    @FindBy(xpath = "//*[contains(text(),'Showcase now')]") public WebElement noMovieShowcase;
    @FindBy(xpath = "//*[@id='guest-firstName']") public WebElement guestFirstName;
    @FindBy(xpath = "//*[@id='guest-lastName']") public WebElement guestLastName;
    @FindBy(xpath = "//*[@id='guest-Email']") public WebElement guestEmail;
    @FindBy(xpath = "//*[@id='guest-PhoneNumber']") public WebElement guestPhoneNumber;
    
    @FindBy(xpath = "//*[contains(text(),'Pay with Tata Pay App')]") public WebElement tatapayPaymentOption;
    @FindBy(xpath = "//input[@id='security_code']") public WebElement enterCvv;
    @FindBy(xpath = "//*[@data-testid='handle-submit']") public WebElement payButton;
    @FindBy(xpath = "//div[@id='144']") public WebElement procedToPay;
    @FindBy(xpath = "//*[@data-testid='handle-payments']") public WebElement changeButton;
    @FindBy(xpath = "//*[contains(text(),'Add New')]") public WebElement addNew;
    @FindBy(xpath = "//*[@id='name_on_card']") public WebElement nameOncard;
    @FindBy(xpath = "//*[@id='card_number']") public WebElement cardNumberTcp;
    @FindBy(xpath = "//*[@id='card_exp_month']") public WebElement cardExpMonth;
    @FindBy(xpath = "//*[@id='card_exp_year']") public WebElement cardExYear;
    @FindBy(xpath = "//*[contains(text(),'Successful')]") public WebElement successPayment;
    @FindBy(xpath = "//button[contains(text(),'Sign in with TCP')]") public WebElement signinButton;
    @FindBy(xpath = "//button[@id='modal-close-button']") public WebElement closebTN;
    @FindBy(xpath = "//*[contains(text(),'Order History')]") public WebElement orderHistoryBtn;
    @FindBy(xpath = "//*[contains(text(),'Ok')]") public WebElement okAcknowledgeClick;

  
  
  
  
//oct9 revathi
    @FindBy(xpath = "//*[contains(text(),'Hi,')]") public WebElement signed_in_croma;
    @FindBy(xpath =  "(//*[contains(text(),'Pay On Delivery')])[1]") public WebElement pay_on_delivery_croma;
    @FindBy(xpath =  "((//*[contains(text(),'Pay On Delivery')])[3]/following::img)[3]") public WebElement pay_on_delivery_radio_croma;
    @FindBy(xpath =  "(//*[contains(text(),'Proceed to pay')])[2]") public WebElement proceed_to_pay_croma;
    @FindBy(xpath =  "(//*[contains(text(),'Your order')])[1]") public WebElement Order_confirm_channel_croma;
    @FindBy(xpath =  "(//*[contains(text(),'View Details')])[1]") public WebElement view_details_offer;
    @FindBy(xpath =  "//*[contains(text(),'Browse Products')]") public WebElement Browse_products_offer;

    @FindBy(xpath =  "//*[contains(text(),'Sort by')]") public WebElement products_PLP_offer;
    @FindBy(xpath="(//*[contains(text(),'Add to cart')])[1]") public WebElement croma_Add_to_cart;

 
    /*Tata Sky */
    
    @FindBy(xpath = "//*[text()='First name is mandatory']" )public WebElement msgFnameMandField;
    @FindBy(xpath = "//*[text()='Last name is mandatory']") public WebElement msgLnameMandField;
    @FindBy(xpath = "//*[text()='Phone number is mandatory']") public WebElement msgPhoneMandField;
    @FindBy(xpath = "//*[text()='Email ID is mandatory']") public WebElement msgEmailMandField;

    @FindBy(xpath = "//input[@id='firstName']") public WebElement fnameTextBox;
    @FindBy(xpath = "//input[@id='lastName']") public WebElement lnameTextBox;
    @FindBy(xpath = "//input[@id='phone']") public WebElement phoneTextBox;
    @FindBy(xpath = "//input[@id='email']") public WebElement emailTextBox;
    
    @FindBy(xpath = "(//*[text()='Please enter valid name (Only alphabets)'])[1]") public WebElement msgErrorFname;
    @FindBy(xpath = "(//*[text()='Please enter valid name (Only alphabets)'])[2]") public WebElement msgErrorLname;
    @FindBy(xpath = "//*[text()='Please enter valid phone number (10 digits)']") public WebElement msgErrorPhone;
    @FindBy(xpath = "//*[text()='Please enter a valid email ID']") public WebElement msgErrorEmail;
    @FindBy(xpath = "//*[text()='First name should be less than 25 characters']") public WebElement msgErrorFnameMoreChar;
    @FindBy(xpath = "//*[text()='Last name should be less than 25 characters']") public WebElement msgErrorLnameMoreChar;
    @FindBy(xpath = "//*[text()='Please enter valid phone number (10 digits)']") public WebElement msgErrorPhoneMoreChar;
    @FindBy(xpath = "//*[text()='Payment done!']" )public WebElement paymentDoneConfirm;
    @FindBy(xpath="//a[contains(@class,'pcdc')]") public WebElement opelpayment;
    @FindBy(xpath="//span[text()='Back']") public WebElement backBtn;
    @FindBy(xpath="//*[text()='Select the set top box and proceed'] | //*[text()='Select your Set Top Box to proceed']") public WebElement boxTitleSDBox;
    @FindBy(xpath="//span[text()='No']") public WebElement noBtn;
    
    
  //Payment Wallet
    @FindBy(xpath = "//article[text()='Wallets']" )public WebElement payviaWallet;
    @FindBy(xpath = "//article[text()='Test']" )public WebElement testWallet;
    @FindBy(xpath = "//*[text()='Test']//following::article[text()='Proceed to pay']")public WebElement proceedToPayBtn;
    @FindBy(xpath = "//*[@id='BankStatus']" )public WebElement payDropdown;
    @FindBy(xpath = "//*[text()='Submit']" )public WebElement submitBtn;
    
    
    
//oct14//revathi
    
    @FindBy(xpath =  "//*[contains(text(),'Continue')]") public WebElement upgrade_continue;
   // @FindBy(xpath =  "(//*[contains(text(),'Get')])[1]") public WebElement upgrade_get;
    //@FindBy(xpath =  "(//a[text()='Get'])[1]") public WebElement upgrade_get;
    @FindBy(xpath =  "//*[text()='HD+ Box']//following::a[1]") public WebElement upgrade_get;
  
    @FindBy(xpath =  "//*[contains(text(),'Pay Online')]") public WebElement upgrade_payonline;
    @FindBy(xpath =  "//*[contains(text(),'Cash on Delivery')]") public WebElement upgrade_cash_on_delivery;
    @FindBy(xpath =  "//*[contains(text(),'successful')]") public WebElement upgrade_cod_success;
    @FindBy(xpath =  "(//*[contains(text(),'successful')]/following::div/p)[1]") public WebElement upgrade_transaction_id;
    @FindBy(xpath =  "(//*[contains(text(),'successful')]/following::div/p)[2]") public WebElement upgrade_transaction_time;
    @FindBy(xpath =  "//*[contains(text(),'Opel Payment')]") public WebElement opel_payment;
    @FindBy(xpath = "//*[contains(text(),'Payment Options')] | //*[contains(text(),'tata digital Options')] | //*[(text()='Payment')]") public WebElement paymentPageHeader_tata; 
    @FindBy(xpath = "//*[@id='BankStatus']") public WebElement paymentdropdown_tata; 
    @FindBy(xpath = "//button[contains(text(),'Submit')]") public WebElement paymentsubmit_tata;
    @FindBy(xpath = "(//*[contains(text(),'Proceed to pay')])[3]") public WebElement procced_tata;
    @FindBy(xpath = "//*[contains(text(),'Tata Sky')]//following::button") public WebElement offer_tata;
    @FindBy(xpath = "//*[contains(text(),'Redeem Now')]") public WebElement redeem_tata; 
    
    //oct15//revathi

	@FindBy(xpath = "(//*[contains(text(),'30% off on Croma products')]/following-sibling::div//*[contains(text(),'Shop Now')])[2]")
	public WebElement tataSkyBoxUpgrade;
	@FindBy(xpath = "(//*[contains(text(),'Amount')]/following::input[@id='amount'])[1]")
	public WebElement amount_tata;
	@FindBy(xpath = "//*[contains(text(),'Continue')]") public WebElement continue_tata; 
	@FindBy(xpath = "(//*[contains(text(),'Wallets')])") public WebElement wallets_tata; 
	@FindBy(xpath = "//article[contains(text(),'Test')]") public WebElement wallets_option_tata; 
	@FindBy(xpath = "//article[contains(text(),'Test')]/following::div//article[contains(text(),'Proceed to pay')]") public WebElement wallets_procceed_tata; 
	@FindBy(xpath = "//*[contains(text(),'done')]") public WebElement wallets_option_success; 
	@FindBy(xpath = "//*[contains(text(),'done')]/following::h2") public WebElement wallets_option_id; 
	@FindBy(xpath = "//*[contains(text(),'unsuccessful')]") public WebElement rech_failed; 
	
	//oct16//revathi
	@FindBy(xpath = "//*[contains(text(),'Get This')]") public WebElement get_box_tata; 
	@FindBy(xpath = "//div[@class='collapse show']//span[contains(text(),'Get This Pack')]") public WebElement get_pack_tata; 
	@FindBy(xpath = "(//*[contains(text(),'Select area')]//following::div/div/div/div)[2]") public WebElement select_area_tata;
	@FindBy(xpath = "//*[contains(text(),'Enter OTP')]/following::input") public WebElement OTP_install_tata;
	@FindBy(xpath = "//*[contains(text(),'Place Order')]") public WebElement place_order_install_tata;
	@FindBy(xpath = "(//*[contains(text(),'Installation date')]/following::div)[1]") public WebElement date_install_tata;
	@FindBy(xpath = "//*[contains(text(),'Place Order')]") public WebElement schedule_install_tata;
	@FindBy(xpath = "//*[contains(text(),'connection')]") public WebElement connection_install_tata;
	
	
	//oct19//revathi//IHCL
	@FindBy(xpath = "(//*[@data-dialog-btn='bookAStay'])[2]") public WebElement Book_stay_IHCL;
	@FindBy(xpath = "//*[@id='izMasterDomainFramePerms']") public WebElement Frame_IHCL;
	@FindBy(xpath = "//*[@id='_hjRemoteVarsFrame']") public WebElement Frame2_IHCL;
	@FindBy(xpath = "(//button[contains(text(),'BOOK')])[1]") public WebElement Book_IHCL;
	@FindBy(xpath = "(//a[contains(text(),'Taj Hotel')])[2]") public WebElement search_result_IHCL;
	@FindBy(xpath = "//*[contains(text(),'Oops!')]/following::span") public WebElement close_wrong_IHCL;
	@FindBy(xpath = "//*[contains(text(),'STANDARD RATES')]") public WebElement stand_rates_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'VIEW RATES')])[1]") public WebElement view_rates_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'SELECT')])[1]") public WebElement select_room_IHCL;
	@FindBy(xpath = "(//button[contains(text(),'CONFIRM')])[2]") public WebElement confirm_room_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'Summary')]/following::div)[1]") public WebElement summary_price_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'Total Price')]/following::div/span[2])[1]") public WebElement summary_total_price_IHCL;
	@FindBy(xpath = "//*[@id='bookingGuestTitleSelectBoxIt']") public WebElement title_IHCL;
	@FindBy(xpath = "//*[contains(text(),'Enter details')]") public WebElement details_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'First Name*')]/following::input)[1]") public WebElement Fname_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'Last Name*')]/following::input)[1]") public WebElement Lname_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'Email*')]/following::input)[1]") public WebElement email_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'Title')]/following::div)[1]") public WebElement country_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'Title')]/following::div)[1]") public WebElement number_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'Privacy Policy')]/preceding::label/input)[3]") public WebElement clickPrivacy_IHCL;
	@FindBy(xpath = "(//*[contains(text(),'Privacy')]/following::div/label)[1]") public WebElement termss_IHCL;
	@FindBy(xpath = "//*[contains(text(),'PROCEED')]") public WebElement proceed_IHCL;
	@FindBy(xpath = "//*[contains(text(),'Payment details')]") public WebElement proceed_pay_IHCL;
	@FindBy(xpath = "//button[contains(text(),'CONFIRM')]") public WebElement confirm_pay_IHCL;
	@FindBy(xpath = "//*[contains(text(),'Book Now')]") public WebElement Offer_IHCL;
	@FindBy(xpath = "//button[text()='Someone else']") public WebElement someone_IHCL;
	@FindBy(xpath = "//*[contains(text(),'IHCL')]//following::button | //*[contains(text(),'Croma')]//following::button | //*[contains(text(),'ICICI')]//following::button") public WebElement offer_IHCL_view;

	//ihclBookingDetails
		@FindBy(xpath = "(//input[@class='searchbar-input'])[2]") public WebElement searchBarHotel; 
		@FindBy(xpath = "//a[text()='Taj Mahal,Lucknow']") public WebElement tajMahalLucknow; 
		@FindBy(xpath = "//button[text()='VIEW PACKAGES']") public WebElement viewPackage; 
		@FindBy(xpath = "(//button[text()='Book Now']") public WebElement bookNowPackage; 
		@FindBy(xpath = "//*[@style='cursor: pointer;']") public WebElement offerBackBtn; 
		
	//oct20
		@FindBy(xpath = "(//a[contains(text(),'Back')])[1]") public WebElement  back_IHCL;
		@FindBy(xpath = "//*[contains(text(),'Selected rooms')]") public WebElement  validate_back_IHCL;
		@FindBy(xpath = "//*[@aria-label='Hotel Search Bar']") public WebElement  search_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'REQUEST QUOTE')])[1]") public WebElement  request_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Request')])[1]") public WebElement  det_pg_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Preferred Date')]/following::div/input)[1]") public WebElement  date_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Number of Guests*')]/following::input)[1]") public WebElement  guest_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Full Name*')]/following::input)[1]") public WebElement  fname_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Mobile*')]/following::input)[1]") public WebElement  mobile_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Email*')]/following::input)[1]") public WebElement  Email_Event_IHCL;
		@FindBy(xpath = "//*[contains(text(),'SUBMIT')]") public WebElement  submit_Event_IHCL;
		@FindBy(xpath = "//*[contains(text(),'Thank You')]") public WebElement  Thanks_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Thank You')]/following::div/div)[1]") public WebElement  Thanks_text_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Thank You')]/following::button)[1]") public WebElement  done_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Max Capacity')])[1]") public WebElement  capacity_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Max Capacity')]/following::div/div/div/span[2])[1]") public WebElement  distance_Event_IHCL;
		@FindBy(xpath = "(//*[contains(text(),'Max Capacity')]/following::div/div/div[2]/span[2])[1]") public WebElement  dimension_Event_IHCL;
        //Akshya
		@FindBy(xpath = "(//*[@id='dest-result']//a)[1]") public WebElement  btnNewDelhi;
		@FindBy(xpath = "//*[text()='New Delhi']") public WebElement  textDelhi;
		@FindBy(xpath = "//*[contains(text(),'CONFIRM')]") public WebElement  btnConfirm;
		

}
