package com.QA.TestApp.Pages.MOBILE;


import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_UniversalCart_Mobile_Page extends BaseScript {


	public TDL_UniversalCart_Mobile_Page() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	//for android element add "and" as prefix and for ios add "ios"

	// ios Only 
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Used']") public MobileElement andUsedOffersTab_IOS;	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bundle']") public MobileElement Bundle_ios;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.BundleHomeView']") public MobileElement AllBundle_hdr_ios;

	@FindBy(xpath = "//XCUIElementTypeScrollView[@name='tcpApp.bundleHomeViewController.scrollView'] | //XCUIElementTypeButton[@label='Check it out']") public MobileElement chk_out_button_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Terms & Conditions']") public MobileElement Terms_condition_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Terms And Conditions']/following::XCUIElementTypeTextView") public MobileElement Terms_condition_text_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconCloseCircleFilled']") public MobileElement Terms_condition_close_ios;
	@FindAll({@FindBy(xpath = "//XCUIElementTypeStaticText[@name='View details']/../following-sibling::XCUIElementTypeStaticText[1]")})public List<MobileElement> bundle_title;
	@FindAll({@FindBy(xpath = "//XCUIElementTypeStaticText[@name='View details']/../following-sibling::XCUIElementTypeStaticText[2]")})public List<MobileElement> bundle_amount;
	//Dec 18 shailendra
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TOTAL']/following-sibling::XCUIElementTypeStaticText") public MobileElement totalamount;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Time to avail offer']/following-sibling::XCUIElementTypeStaticText[1]") public MobileElement timetoavailoffer;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Add to cart']") public MobileElement addtocart;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Save for later']") public MobileElement saveforlater;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Your Bundle']") public MobileElement cart_text;
	//Dec 15//
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"tcpApp.bundleHomeViewController.bannerTitle\"]") public MobileElement Hero_ban_list_pg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"tcpApp.bundleHomeViewController.bannerDesc\"]") public MobileElement Hero_ban_list_pg_desc_ios;
	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='TCPApp.BundleDetailView']") public MobileElement Bundle_detail_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailViewController.bannerTitle\"]") public MobileElement Hero_ban_detail_pg_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailViewController.bannerDesc\"]") public MobileElement Hero_ban_detail_pg_desc_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Supriyo2 Kitchen Bundle(Test) 20% off']") public MobileElement Bundle_subscription_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconCloseCircleFilled']") public MobileElement Bundle_subscription_close_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='TATA Sky']") public MobileElement Bundle_subscription_hdr_ios;
	@FindAll({@FindBy(xpath = "//XCUIElementTypeStaticText[@name='EXPLORE ALL BUNDLES']/following::XCUIElementTypeCell")}) public List<MobileElement> bundle_list;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='EXPLORE ALL BUNDLES']") public MobileElement explore_bundles_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='EXPLORE ALL BUNDLES']/following::XCUIElementTypeCell//XCUIElementTypeStaticText") public MobileElement bundle_list_title_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='EXPLORE ALL BUNDLES']/following::XCUIElementTypeCell//XCUIElementTypeButton[@name='iconEnterArrow']") public MobileElement bundle_list_tick_arrow_ios;
	//Dec 16//
	@FindAll({@FindBy(xpath = "//XCUIElementTypeStaticText[@name='View details']")}) public List<MobileElement> Product_details_View_Details_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.bundleProductDetailViewController.button']") public MobileElement Product_details_Model_close_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add to bundle']") public MobileElement Product_Details_Model_AddToBundle_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Added to bundle'] | //XCUIElementTypeStaticText[@name='Added to bundle']") public MobileElement Product_Details_Model_AddedToBundle_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='iconCloseCircleFilled']//following::XCUIElementTypeCell//XCUIElementTypeStaticText[1]") public MobileElement Product_Details_Product_Title;
	//Dec 18//
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Deliver to']//following::XCUIElementTypeButton[1]") public MobileElement Pincode_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='DELIVERY ADDRESS']") public MobileElement delivery_addres_ios;
	@FindAll({@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Your saved address']//following::XCUIElementTypeCell")})public List<MobileElement> address_list;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add new']") public MobileElement AddNew_ios;
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='tcpApp.findAddress.searchTextField']") public MobileElement AddressSearch_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.address.findAddressCell'])[1]") public MobileElement AddressSearchResult_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Name*']//following::XCUIElementTypeTextField[1]") public MobileElement AddressName_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Flat/ House No., Block, Building*']//following::XCUIElementTypeTextField[1]") public MobileElement AddressFlat_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Landmark']//following::XCUIElementTypeTextField[1]") public MobileElement AddressLandmark_ios;
	@FindBy(xpath = "(//XCUIElementTypeCell[@name='tcpApp.formVC.enrollmentMultiTextfieldCell'])[3]/XCUIElementTypeTextField[1]") public MobileElement AddressPincode_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='tcpApp.formVC.saveChanges']") public MobileElement SaveChanges_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='SAVE AS']") public MobileElement Saveas_header_ios;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='Home'])[1]") public MobileElement Saveas_option_home_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Office']") public MobileElement Saveas_option_Office_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Custom']") public MobileElement Saveas_option_custom_ios;
	//Dec 19//
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Universal Cart']") public MobileElement Universal_cart_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='MY CART']") public MobileElement cart_pg_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Shipping to different address click here']") public MobileElement shipping_address_ios;
	@FindAll({@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Ship to']/following::XCUIElementTypeButton")}) public List<MobileElement> edit_shipping_address_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Ship to']/preceding-sibling::XCUIElementTypeStaticText[1])[1]") public MobileElement bundle_shipping_ios ;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Ship to']/preceding-sibling::XCUIElementTypeStaticText[2])[1]") public MobileElement bundle_est_delivery_ios;
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Ship to']/preceding-sibling::XCUIElementTypeStaticText[3])[1]") public MobileElement bundle_title_ios;
	//Dec21//
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Universal Cart']") public MobileElement UniversalCart_Button_ios;
	@FindBy(xpath= "//XCUIElementTypeOther//XCUIElementTypeStaticText[@name[contains(.,'Total Savings')]]") public MobileElement Total_Savings_IOS;
	@FindBy(xpath= "//XCUIElementTypeOther//XCUIElementTypeStaticText[@name[contains(.,'Total Savings')]]/following::XCUIElementTypeStaticText[1]") public MobileElement Total_Number_Items;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Subtotal']") public MobileElement Sub_Total_Amount_IOS;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Total Savings']/following::XCUIElementTypeOther[3]//XCUIElementTypeStaticText[2]") public MobileElement Sub_Total_Amount;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Discount applied']") public MobileElement Discount_Amount_IOS;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Total Savings']/following::XCUIElementTypeOther[3]//XCUIElementTypeStaticText[3]") public MobileElement Discount_Amount;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Delivering To ']") public MobileElement Delivering_To_IOS;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Total Savings']/following::XCUIElementTypeOther[3]//XCUIElementTypeStaticText[4]") public MobileElement Delivering_To;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='TOTAL']") public MobileElement Total_Amount_IOS;    
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='TOTAL']/following::XCUIElementTypeStaticText[1]") public MobileElement Total_Amount_ded;
	@FindAll({@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Your saved address']/following::XCUIElementTypeCell")}) public List<MobileElement> alternate_address_ios;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Confirm']") public MobileElement confirm_IOS; 
	//Dec22//

	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='MY CART'] | //XCUIElementTypeStaticText[@name='My cart']") public MobileElement  My_Cart_IOS;  

	@FindBy(xpath= "//XCUIElementTypeButton[@name='Start Checkout']") public MobileElement  Start_Checkout_IOS;
	//Dec23//
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Not Serviceable']") public MobileElement Non_Serviceable_Bundle_IOS;
	@FindBy(xpath= "(//XCUIElementTypeStaticText[@name='Not Serviceable']//preceding-sibling::XCUIElementTypeButton[@name='View details'])[1]") public MobileElement Related_View_Details_IOS; 
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Add to bundle']") public MobileElement AddToBundle_Button_ios;
	//jan22	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Saved to vault']/following::XCUIElementTypeButton[@name='Check it out']") public MobileElement savedToVault_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Seen']/following::XCUIElementTypeButton[@name='Check it out']") public MobileElement seenBDP_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']") public MobileElement BDPPAge_Back_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Saved To Vault']") public MobileElement savedToVaultButton_ios;
	//Feb17//	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Deliver to']/following::XCUIElementTypeButton[1]") public MobileElement PincodeBDP_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Key features']") public MobileElement KeyFea_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Key features']/following::XCUIElementTypeStaticText[1]") public MobileElement KeyFeaTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Overview']") public MobileElement Overview_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Overview']/following::XCUIElementTypeStaticText[1]") public MobileElement OverviewTxt_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Buy now'] | //XCUIElementTypeButton[@label='Buy now']") public MobileElement Buynow_ios;

	//feb25//
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Time to avail offer']") public MobileElement timeToavail_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Time to avail offer']/following::XCUIElementTypeStaticText[1]") public MobileElement timeToavailTxt_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Save for later']") public MobileElement saveLaterBDP_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Saved To Vault']") public MobileElement savedVaultBDP_ios;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='TOTAL']/following::XCUIElementTypeStaticText[1]") public MobileElement Total_Amount;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Pick-up where you left off']") public MobileElement PickFromLeft;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='offers.selectedStoreOffers.navigationBarTitleLabel']") public MobileElement savedBundle;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Active']") public MobileElement Activetab;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Buy Now']/preceding::XCUIElementTypeStaticText[1]") public MobileElement BundlesavedTitle;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Buy Now']/preceding::XCUIElementTypeStaticText[2]") public MobileElement Bundlesavedexpiry;

	//19th Mar
	
//	@FindBy(xpath= "(//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailHeaderView.titleLabel\"])[1]/following::XCUIElementTypeStaticText[1]") public MobileElement displayedCategory0ProductViewDetails;
//	
//	@FindBy(xpath= "(//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailHeaderView.titleLabel\"])[2]") public MobileElement displayedCategory1;
//	@FindBy(xpath= "(//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailHeaderView.titleLabel\"])[2]/following::XCUIElementTypeStaticText[1]") public MobileElement displayedCategory1ProductViewDetails;
//	
//	@FindBy(xpath= "(//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailHeaderView.titleLabel\"])[3]") public MobileElement displayedCategory2;
//	@FindBy(xpath= "(//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailHeaderView.titleLabel\"])[3]/following::XCUIElementTypeStaticText[1]") public MobileElement displayedCategory2ProductViewDetails;
	

	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[1] | //*[@label='Please Select Group0'] | (//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailHeaderView.titleLabel\"])[1]") public MobileElement displayedCategory0;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[2] | //XCUIElementTypeOther[@name='Please Select Group0']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[1] | (//XCUIElementTypeStaticText[@name=\"View details\"])[1]") public MobileElement displayedCategory0ProductViewDetails;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[3] | //*[@label='Please Select Group1'] | (//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailHeaderView.titleLabel\"])[2]") public MobileElement displayedCategory1;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[3]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[2] | //XCUIElementTypeOther[@name='Please Select Group1']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[1] | (//XCUIElementTypeStaticText[@name=\"View details\"])[2]") public MobileElement displayedCategory1ProductViewDetails;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[5] | //*[@label='Please Select Group2'] | (//XCUIElementTypeStaticText[@name=\"tcpApp.bundleDetailHeaderView.titleLabel\"])[3]") public MobileElement displayedCategory2;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[5]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[2] | //XCUIElementTypeOther[@name='Please Select Group2']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[1] | (//XCUIElementTypeStaticText[@name=\"View details\"])[4]") public MobileElement displayedCategory2ProductViewDetails;
	

	
//
//	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[1] | //XCUIElementTypeCell[1]") public MobileElement displayedCategory0;
//	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[2] | (//XCUIElementTypeCell[1]/*//*[@name='View details'])[1]") public MobileElement displayedCategory0ProductViewDetails;
//	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[3] | //XCUIElementTypeCell[2]") public MobileElement displayedCategory1;
//	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[3]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[2] | (//XCUIElementTypeCell[2]/*//*[@name='View details'])[1]") public MobileElement displayedCategory1ProductViewDetails;
//	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[5] | //XCUIElementTypeCell[3]") public MobileElement displayedCategory2;
//	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[5]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[2] | (//XCUIElementTypeCell[3]/*//*[@name='View details'])[1]") public MobileElement displayedCategory2ProductViewDetails;

	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[5]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[1]") public MobileElement displayedCategory2ProductPlusicon;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[5]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[4]") public MobileElement displayedCategory2Product2ViewDetails;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='tcpApp.bundleDetailViewController.addToCartButton']") public MobileElement addToCart;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Shipping address']") public MobileElement shippingAddressPopup;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Ok']") public MobileElement shippingAddressPopupOk;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Proceed']") public MobileElement shippingAddressProcedButton;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Do you want update the bundle in the cart with these changes ?']") public MobileElement updateCartPopupText;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='No']") public MobileElement UpdateCartNoButton;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Yes']") public MobileElement UpdateCartYesButton;

	@FindBy(xpath= "//XCUIElementTypeButton[@name='iconTrash'] | //XCUIElementTypeButton[@label='iconTrash']") public MobileElement cartPageRemoveIcon;

	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Edit']") public MobileElement cartPageEditIcon;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Back']") public MobileElement backButton;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Update Cart']") public MobileElement updateCart;
	
	@FindBy(xpath= "(//XCUIElementTypeButton[@name='tcpApp.ucCart.checkoutButton'])[1]") public MobileElement procedFromCartPage;

	
	//5-4 Sourav
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Button']") public MobileElement paymentstatusclose_ios;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='Back to Homepage']") public MobileElement backtohome_ios;
	@FindBy(xpath= "//XCUIElementTypeStaticText[contains(@name,'Your cart is empty')]") public MobileElement cartemptytext_ios;
	
	@FindAll({@FindBy(xpath= "//XCUIElementTypeButton[@name='iconTrash'] | //XCUIElementTypeButton[@label='iconTrash']")}) public List<MobileElement> cartPageRemoveIconList_ios;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[1] | //*[@label='Please select Group0']") public MobileElement displayedCategory0TCP25;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[2] | //XCUIElementTypeOther[@name='Please select Group0']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[1]") public MobileElement displayedCategory0ProductViewDetailsTCP25;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[3] | //*[@label='Please select Group1']") public MobileElement displayedCategory1TCP25;
	@FindBy(xpath= "//XCUIElementTypeTable[@name='tcpApp.bundleDetailViewController.tableView']/XCUIElementTypeOther[3]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[2] | //XCUIElementTypeOther[@name='Please select Group1']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[1]") public MobileElement displayedCategory1ProductViewDetailsTCP25;
	

//	@FindBy(xpath= "//XCUIElementTypeButton[@name='tcpApp.ucCart.checkoutButton']") public MobileElement procedFromCartPage;

	@FindBy(xpath= "//XCUIElementTypeButton[@name='tcpApp.CarouselCollectionViewCell.checkOutButton']") public MobileElement checkOutCTABtn;
	@FindBy(name = "tcpApp.bundleProductDetailViewController.inventoryLabel") public MobileElement stockInfo;
	@FindBy(name = "homeBurgerMenu") public MobileElement hamburgerMenu;
	@FindBy(name = "Order history") public MobileElement orderHistory;
	@FindBy(name = "TCPApp.OrderHistoryListingView") public MobileElement orderHistoryLanding;
	@FindBy(name = "iconFilter") public MobileElement filterOrderHistory;
	@FindBy(xpath = "//XCUIElementTypeCollectionView") public MobileElement filterSelectionView;
	@FindBy(name = "Bundles") public MobileElement bundleSelection;
	@FindBy(name = "tcpApp.filter.applyButton") public MobileElement applyCTAfilter;
	@FindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[1]") public MobileElement selectOrderbundle;
	@FindBy(name = "TCPApp.BundleOrderDetailView") public MobileElement orderDetailPage;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Need Help? Chat with us']") public MobileElement chatbotInvocation;
	@FindBy(name = "TCPUIKit.TCPWebView") public MobileElement chatbotLandingPage;
	
	
		//	Android Only


	@FindBy(id="com.tatadigital.tcp.dev:id/tvSharesLeft")public MobileElement andShareCount;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvSharesLeft")public MobileElement dataCount;
	//Dec 17//Android
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivDefaultProfilePic") public MobileElement profilebuttonclick;
	@FindBy(xpath = "//*[@text='Others']") public MobileElement othersbutton;
	@FindBy(xpath = "//*[@text='Allbundle']") public MobileElement Allbundles_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/imgHeroBanner") public MobileElement herobannerandroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/imgTitle") public MobileElement herobannertitle;
	@FindBy(id = "com.tatadigital.tcp.dev:id/imgDiscription") public MobileElement herobannerdesc;
	@FindBy(id = "com.tatadigital.tcp.dev:id/checkItOutButton") public MobileElement chk_out_button_android;
	@FindAll({@FindBy(id = "com.tatadigital.tcp.dev:id/ivallBundles")}) public List<MobileElement> bundle_list_android;
	//Dec 22//Android//
	@FindBy(id="com.tatadigital.tcp.dev:id/appBarToolbar") public MobileElement cart_pg;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvTotalSavings") public MobileElement Total_Savings_Android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvTotalItemInCart") public MobileElement Total_Number_Items_Android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvSubTotalText") public MobileElement Sub_Total_Amount_Android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvSubTotalValue") public MobileElement Sub_Total_Amount_val_Android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvDiscountText") public MobileElement Discount_Amount_Android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvDiscountValue") public MobileElement Discount_Amount_value;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvDeliveryToText") public MobileElement Delivering_To_Android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvDeliveryToValue") public MobileElement Delivering_To_value;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvTotalText") public MobileElement Total_Amount_Android;    
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvTotalValue") public MobileElement Total_Amount_value;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvStartCheckOut")public MobileElement checkout_CTA;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/llSelectDeliveryAddress")}) public List<MobileElement> shiptooption;
	@FindAll({@FindBy(xpath="//*[@text='Your saved address']/following::android.widget.RadioButton")}) public List<MobileElement> alternate_address;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvAddressHeadLine")})public List<MobileElement> optionselection;
	@FindBy(xpath="//*[@text='Add New']")public MobileElement addnewbutton;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtSearchAddress")public MobileElement searchpincode;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtCustomName")public MobileElement entername;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtFlatNo")public MobileElement enterflatnumber;
	@FindBy(id="com.tatadigital.tcp.dev:id/edtLandmark")public MobileElement enterlandmark;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvLabelOffice")public MobileElement addresstype;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnSaveChanges")public MobileElement savechanges;
	//Dec 21 shailendra
	@FindBy(xpath="//*[@text='cart']")public MobileElement cartbutton;
	@FindBy(xpath="//*[@text='BROWSE NOW']")public MobileElement browsenowbutton;
	@FindBy(xpath="//*[@text='cart']")public MobileElement offersbundlewidget;
	@FindBy(xpath="//*[@text='Start Checkout']")public MobileElement startcheckoutbutton;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvEditAndReviewShipping")public MobileElement differentshipping;
	//Android//Jan 18//Revathi//
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTandC") public MobileElement TCAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTermsandConditions") public MobileElement TCTextAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/closeButton") public MobileElement TCCloseAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/toolbarTitleTextView") public MobileElement BundleDetailsAndroid;
	//jan 20//
	@FindBy(id="com.tatadigital.tcp.dev:id/YourBundle") public MobileElement yourBundleTxtAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/TotalList") public MobileElement totalAmountTxtAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTotalPrice") public MobileElement totalAmountAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/timeToAvilOffer") public MobileElement timeToAvailTxtAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/time_date_bundle") public MobileElement timeToAvailAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/YourBundle") public MobileElement yourbundleAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/buttonsavelater") public MobileElement saveForLaterAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnAddToBundle") public MobileElement addBundleAndroid;
	@FindAll({@FindBy(id = "com.tatadigital.tcp.dev:id/tvView")}) public List<MobileElement> viewDetails;
	@FindAll({@FindBy(xpath = "//*[@text='View details']/preceding::android.widget.TextView[1]")}) public List<MobileElement> BDP_price;
	@FindAll({@FindBy(xpath = "//*[@text='View details']/preceding::android.widget.TextView[3]")}) public List<MobileElement> BDP_title;
	@FindBy(xpath="//*[@resource-id='com.tatadigital.tcp.dev:id/imgTitle'] | //*[@resource-id='com.tatadigital.tcp.dev:id/tvTitle']") public MobileElement BDPHeroBannerTitleAndroid;
	@FindBy(id="com.tatadigital.tcp.dev:id/imgDiscription") public MobileElement BDPHeroBannerTitleDescAndroid;
	//jan21//
	@FindBy(id= "com.tatadigital.tcp.dev:id/backImageView") public MobileElement BDP_BackAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/seen") public MobileElement Bundle_SeenAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvSavedToVaultMsg") public MobileElement savedToVaultAndroid;
	@FindBy(xpath = "//*[@text='Saved to Vault']") public MobileElement savedToVaultBDPAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/ivPdpClose") public MobileElement BDP_Modal_closeAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvPdpProductTitle") public MobileElement BDP_Modal_TitleAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvPdpDescription") public MobileElement BDP_Modal_TitleDescAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvServiceability") public MobileElement BDP_Modal_serviceabilityAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvPdpPincode") public MobileElement BDP_Modal_pincodeAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvPdpPrice") public MobileElement BDP_Modal_priceAndroid;
	@FindBy(xpath = "//*[@text='Seen']/following::android.widget.Button") public MobileElement Bundle_Seen_newAndroid;
	@FindBy(xpath = "//*[@text='Saved to vault']/following::android.widget.Button") public MobileElement saveforLate_newAndroid;
	@FindBy(xpath = "//*[@text='Added to bundle']") public MobileElement addedBundleAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnAddToBundle") public MobileElement addBundleModalAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvinstock") public MobileElement BDP_Modal_instockAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvPdpTitle") public MobileElement BDP_Modal_headTitlekAndroid;
	@FindAll({@FindBy(xpath = "//*[@text='View details']")}) public List<MobileElement> viewdetails_BDPandroid;
	//jan25//
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvPincode") public MobileElement Pincode_BundleAndroid;
	@FindBy(xpath= "//*[@text='Select address']") public MobileElement selectAddressBundleAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvAddNewAddress") public MobileElement addAddressAndroid;
	//jan27//
	@FindBy(id= "com.tatadigital.tcp.dev:id/btnProceed") public MobileElement proceedAddressAndroid;
	@FindAll({@FindBy(xpath = "//*[@text='DELIVERY ADDRESS']/following::android.widget.FrameLayout")}) public List<MobileElement> AddressList;
	@FindBy(xpath= "//*[contains(@text,'Saved addresses')]") public MobileElement AddressAndroid;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvUseCurrentLocation") public MobileElement GpsAndroid;
	//feb1
	@FindBy(xpath= "//*[@text='Saved to vault']") public MobileElement savedtovaultAndroid;
	@FindBy(xpath= "//*[@text='Save for later']") public MobileElement saveforLaterTxtAndroid;

	//feb2//sms validation//
	@FindBy(xpath = "//android.widget.ListView[@resource-id='android:id/list']//android.view.ViewGroup[1]") public MobileElement FirstSMSMessageAndroid;
	@FindBy(xpath = "(//*[@resource-id='com.android.mms:id/date'])[1]") public MobileElement FirstSMStimeAndroid;
	@FindBy(xpath = "(//*[@resource-id='com.android.mms:id/from'])[1]") public MobileElement FirstSMSFromAndroid;
	@FindAll({@FindBy(xpath = "//*[contains(@text,'BK-IHCLHT')]")}) public List<MobileElement> SMSMessageAndroid;
	@FindAll({@FindBy(xpath = "//*[contains(@text,'Dear Guest')]")}) public List<MobileElement> SMSMessageOTPAndroid;
	@FindBy(xpath = "//*[@text='Not now']") public MobileElement NotNowSMSFromAndroid;
	@FindBy(xpath = "//*[@text='Allow']") public MobileElement AllowSMSFromAndroid;
	@FindBy(xpath = "//*[@text='Ignore']") public MobileElement IgnoreSMSFromAndroid;
	//feb 22//
	@FindBy(id = "com.tatadigital.tcp.dev:id/keyFeatures") public MobileElement KeyFeaturesAnd;
	@FindBy(id = "com.tatadigital.tcp.dev:id/showDetail") public MobileElement KeyFeaturesArrowAnd;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvKeyFeatures") public MobileElement KeyFeaturesTxtAnd;
	@FindBy(id = "com.tatadigital.tcp.dev:id/overViewDetail") public MobileElement OverviewAnd;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivOverviewDown") public MobileElement OverviewArrowAnd;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvOverview") public MobileElement OverviewTxtAnd;

	//23rd March Sandeep
	@FindBy(xpath = "//XCUIElementTypeButton[@class='Ship to multiple addresses? Click here']") public MobileElement shipToOtherAddress;
	@FindBy(xpath= "(//XCUIElementTypeButton[@class='Office'])[0]") public MobileElement addressChangBtn;
	@FindBy(xpath= "(//*[@text='View details'])[1]") public MobileElement viewdetails1_android;
	@FindBy(xpath= "(//*[@text='View details'])[2]") public MobileElement viewdetails2_android;
	@FindBy(xpath= "(//*[@text='View details'])[3]") public MobileElement viewdetails3_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/edtEmailId") public MobileElement emailidAnd;
	@FindBy(id = "com.tatadigital.tcp.dev:id/edtPhoneNum") public MobileElement phonenumberAnd;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvProceedToPay") public MobileElement proceedtopayAnd;
	
	
	
	
	
	
	

	//Sailndra
	// Commented by Anil to resolve conflicts. Please check and update if required
		@FindBy(xpath= "//*[contains(@text,'Group0')] | (//*[contains(@text,'below product')])[1]") public MobileElement displayedCategory0_android;
		@FindBy(xpath= "(//*[@text='View details'])[1]") public MobileElement displayedCategory0ProductViewDetails_android;
		@FindBy(xpath= "//*[contains(@text,'Group1')] | //*[contains(@text,'any one from below')]") public MobileElement displayedCategory1_android;
		@FindBy(xpath= "(//*[@text='View details'])[2]") public MobileElement displayedCategory1ProductViewDetails_android;
		@FindBy(xpath= "//*[contains(@text,'Group2')] | //*[contains(@text,'below product')]") public MobileElement displayedCategory2_android;
		@FindBy(xpath= "//*[contains(@text,'Group2')]/following::android.widget.TextView[3] | //*[contains(@text,'below product')]/following::android.widget.TextView[3]") public MobileElement displayedCategory2ProductViewDetails_android;
	//	@FindBy(xpath = "//*[@text='Add to cart']") public MobileElement Addtocart;
//	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/recyclerViewVertical']/android.view.ViewGroup[1]/android.widget.TextView") public MobileElement displayedCategory0_android;
//	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/recyclerViewVertical']/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[4]") public MobileElement displayedCategory0ProductViewDetails_android;
//	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/recyclerViewVertical']/android.view.ViewGroup[2]/android.widget.TextView") public MobileElement displayedCategory1_android;
//	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/recyclerViewVertical']/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[4]") public MobileElement displayedCategory1ProductViewDetails_android;
//	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/recyclerViewVertical']/android.view.ViewGroup[3]/android.widget.TextView") public MobileElement displayedCategory2_android;
    //@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/recyclerViewVertical']/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[4]") public MobileElement displayedCategory2ProductViewDetails_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/addToBundle") public MobileElement Addtocart;

	@FindBy(xpath= "//*[@text='Office']/preceding::android.widget.RadioButton") public MobileElement selectoffice;
	@FindBy(xpath= "//*[@text='Home']/preceding::android.widget.RadioButton") public MobileElement selecthome;
	@FindBy(xpath= "//*[contains(@text,'Ship to multiple addresses')]") public MobileElement selectdiffaddress;
	@FindBy(id= "com.tatadigital.tcp.dev:id/llSelectDeliveryAddress") public MobileElement selectbundleaddress;

	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='DELIVERY ADDRESS']") public MobileElement DeliveryAddress;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Your saved address']") public MobileElement SavedAddress;

	@FindBy(id= "com.tatadigital.tcp.dev:id/btnBuyNow") public MobileElement shopnowherobanner;
	@FindBy(xpath= "//*[@text='My cart'] | //*[@text='Cart']") public MobileElement mycart_android;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/tvCartBundleDelete']") public MobileElement deleteBundle_android;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/flEmptyCart']") public MobileElement emptyCart;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/flEmptyCart']/android.widget.TextView") public MobileElement emptyCartTetx;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/tvBackButton'] | //*[@resource-id='com.tatadigital.tcp.dev:id/backImageView']") public MobileElement cartbackbutton_android;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/tvBackButton'] | //*[@resource-id='com.tatadigital.tcp.dev:id/backImageView']") public MobileElement BDPbackbutton_android;
	@FindBy(xpath= "//*[contains(@text,'Bundle is already in your cart')]") public MobileElement alreadyaddedbundlepopup_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/positiveButton") public MobileElement yesbutton_android;

	@FindBy(id= "com.tatadigital.tcp.dev:id/tvSubTotalValue") public MobileElement subtotal_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvDiscountValue") public MobileElement discount_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvTotalValue") public MobileElement total_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement bundle_details_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvContentCountDetail") public MobileElement no_of_bundles_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/btnDownloadInvoice") public MobileElement downloadinvoice_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/btnShare") public MobileElement shareinvoice_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvTotalAmountValue") public MobileElement amountotal_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/btnHomePage") public MobileElement backtohome_android;
	@FindBy(xpath= "//*[@text='Order history']") public MobileElement orderhistory_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvTransactionDateTime") public MobileElement transactiondatetime_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvCartBundleEdit") public MobileElement editbutton_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement herobannertext_android;
	@FindBy(xpath= "//*[@text='Update Cart']") public MobileElement updatecart_android;
	@FindBy(xpath= "//*[@text='My orders']") public MobileElement myorders_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/backImageView") public MobileElement bundlebackbutton_android;
	@FindAll({@FindBy(xpath = "//*[@text='UniversalCart']")}) public List<MobileElement> uc_oders_android;
	@FindBy(xpath= "//*[@text='Order ID']") public MobileElement orderid_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/bundleClickDown") public MobileElement bundleclickdown_android;
	@FindBy(xpath= "//*[contains(@text,'Payment details')]") public MobileElement paymentclickdown_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvHeader") public MobileElement paidusingclickdown_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/productText") public MobileElement producttext_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/clPaymentDetails") public MobileElement paymenttext_android;
	//26 March
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/tab_layout']/following::android.widget.TextView[2]") public MobileElement stockFinder_android;
	//30 March
	@FindBy(id= "com.tatadigital.tcp.dev:id/imCloseIcon") public MobileElement paymentstatusclose_android;
	@FindBy(xpath= "//*[contains(@text,'cart is empty')]") public MobileElement cartemptytext_android;
	//31 March
	@FindBy(xpath= "//*[@text='Not servicable']") public MobileElement notservicable_android;
	@FindBy(xpath= "(//*[@text='temple']/preceding::android.widget.RadioButton)[2]") public MobileElement customaddress_android;
	//01 April
	@FindBy(id= "com.tatadigital.tcp.dev:id/chatHelp") public MobileElement invokechatbot_android;
	@FindBy(xpath= "//*[@text='Chat']") public MobileElement chatpage_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/ivPdpClose") public MobileElement modalclose_android;
	@FindBy(xpath = "(//XCUIElementTypeImage[@name=\"tickMark\"]/following::XCUIElementTypeStaticText)[1]") public MobileElement payment_status_ios;
	@FindBy(xpath = "(//XCUIElementTypeImage[@name=\"tickMark\"]/following::XCUIElementTypeStaticText)[2]") public MobileElement transaction_id_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Do you want update the bundle in the cart with these changes ?\"]/following::XCUIElementTypeButton[2]") public MobileElement yes_button_ios;
	@FindBy(xpath = "(//XCUIElementTypeImage[@name=\"smallNudgeOverlay\"])[1] | //XCUIElementTypeImage[@name='tcpApp.home.MultiTypeNudgeCell.backgroundImageview']") public MobileElement nudgehomepage_ios;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='Edit']") public MobileElement editbutton_ios;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.tatadigital.tcp.dev:id/btnNudgeRightCta']") public MobileElement nudgehomepage_android;
	@FindBy(xpath= "//*[contains(@text,'Bundles')]/parent::android.view.ViewGroup//*[@resource-id='com.tatadigital.tcp.dev:id/tvSeeAll']") public MobileElement seeall_bundle_bonanza_android;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='See All'] | (//*[@label='Bundle bonanza']/following::XCUIElementTypeStaticText)[4]") public MobileElement seeall_bundle_bonanza_ios;
	@FindBy(id= "com.tatadigital.tcp.dev:id/ivallBundles") public MobileElement allbundles_android;
	@FindAll({@FindBy(xpath = "//*[@name='UniversalCart']")}) public List<MobileElement> uc_oders_ios;
	@FindBy(xpath= "//*[@name='Order ID']") public MobileElement orderid_ios;
	@FindBy(xpath= "(//XCUIElementTypeButton[@name=\"iconChevronUp\"])[1]") public MobileElement bundleclickdown_ios;
	@FindBy(xpath= "(//XCUIElementTypeButton[@name=\"iconChevronDown\"])[1]") public MobileElement paymentclickdown_ios;
	@FindBy(xpath= "(//XCUIElementTypeStaticText[@name=\"Shipping to\"])[1]") public MobileElement producttext_ios;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name=\"Total amount\"]") public MobileElement paymenttext_ios;
	@FindBy(xpath= "//*[contains(@text,'Everyday')]") public MobileElement bundlesbonanzadirect_android;
	@FindBy(xpath= "//*[@label='Bundle bonanza']") public MobileElement bundlesbonanza;
	@FindBy(xpath= "//XCUIElementTypeImage[@name='tcpApp.home.MultiTypeCarouselCell.backgroundImageView']") public MobileElement bundlesbonanzadirect_ios;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvOutOfStock") public MobileElement outofstcok_android;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='tcpApp.bundleHomeViewController.searchButton']") public MobileElement searchbutton_ios;
	@FindBy(xpath= "//XCUIElementTypeTextField[@name='offers.discoverySearch.discoverySearchBar']") public MobileElement searchtextbox_ios;
	@FindBy(xpath= "//XCUIElementTypeStaticText[@name='offers.discoverySearch.searchTitleLabel']") public MobileElement searchresult_ios;
	@FindBy(xpath= "(//XCUIElementTypeTextField[@name='offers.discoverySearch.discoverySearchBar']/following::XCUIElementTypeImage)[1]") public MobileElement offerimagebundles_ios;
	@FindBy(xpath= "(//XCUIElementTypeButton[@name='Buy Now'])[1]") public MobileElement buynowbundles_ios;
	
	@FindBy(id= "com.tatadigital.tcp.dev:id/search_button") public MobileElement searchbutton_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/etSearchOffers") public MobileElement searchtextbox_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvHeaderTitle") public MobileElement searchresult_android;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/offerCardImageView']") public MobileElement offerimagebundles_android;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/offerCardImageView']/following::android.widget.Button") public MobileElement buynowbundles_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvCartBundleSaveForLater") public MobileElement saveforlatercart_android;
	@FindBy(xpath= "//*[contains(@text,'moved to saved bundles')]") public MobileElement saveforlatercartvalidation_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/btnSavedOffers") public MobileElement savedoffersicon_android;
	@FindBy(xpath= "(//*[contains(@text,'Bundles')])[2]") public MobileElement savedbundlestab_android;
	@FindBy(xpath= "//*[contains(@text,'Removed')]") public MobileElement deletemessage_android;
	@FindBy(xpath= "//*[contains(@text,'Ship to')]/following::android.widget.ImageView") public MobileElement ship_to_diff_address_lineitem;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/rbSelectedAddress']") public MobileElement select_address_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/ivEditIcon") public MobileElement email_id_edit_icon_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/edtEmailId") public MobileElement email__edit_field_android;
	
	@FindBy(xpath= "((//*[@resource-id='com.tatadigital.tcp.dev:id/ivBackgroundImageView'])[1]/following::android.widget.TextView)[4]") public MobileElement select_first_product_android;
	@FindBy(xpath= "((//*[@resource-id='com.tatadigital.tcp.dev:id/ivBackgroundImageView'])[2]/following::android.widget.TextView)[4]") public MobileElement select_second_product_android;
	@FindBy(xpath= "((//*[@resource-id='com.tatadigital.tcp.dev:id/ivBackgroundImageView'])[3]/following::android.widget.TextView)[4]") public MobileElement select_third_product_android;
	@FindBy(xpath= "((//*[@resource-id='com.tatadigital.tcp.dev:id/ivBackgroundImageView'])[4]/following::android.widget.TextView)[4]") public MobileElement select_fourth_product_android;
	
	@FindBy(xpath= "//*[contains(@text,'Browse')]") public MobileElement browse_button_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/tvEditEmailAddress") public MobileElement email_id_edit_giftcard_android;
	@FindBy(id= "com.tatadigital.tcp.dev:id/edtEmailId") public MobileElement email__edit_field_giftcard_android;
	@FindBy(xpath= "//*[contains(@text,'Contact')]") public MobileElement contactinfo_button_android;
	
	@FindBy(xpath= "//*[contains(@name,'Update')]") public MobileElement updatecart_ios;
	@FindBy(xpath= "//*[contains(@name,'already in your cart')]") public MobileElement updatemsg_ios;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='unfilledBookmarkV2']") public MobileElement savedvaulticon_ios;
	@FindBy(xpath= "//XCUIElementTypeButton[@name='iconTrash']") public MobileElement deletebundle_ios;
	@FindBy(xpath= "//XCUIElementTypeButton[@name=\"chevronLeftV2\"]") public MobileElement back_button_search_page_ios;
	
	@FindBy(xpath= "//*[contains(@text,'Failed')]") public MobileElement failure_failed_status;
	@FindBy(xpath= "//*[contains(@text,'Pending - transaction initiated')]") public MobileElement abort_single_pending_status;
	@FindBy(xpath= "//*[contains(@text,'Failure - Timeout')]") public MobileElement abort_single_failed_status;
	@FindBy(xpath= "//*[contains(@text,'Pending - transaction initiated')]") public MobileElement abort_multi_pending_status;
	@FindBy(xpath= "//*[contains(@text,'Failure - Reversed')]") public MobileElement abort_multi_failed_status;
	
	@FindBy(xpath= "//*[contains(@text,'Sort')]") public MobileElement sortby_arrow;
	@FindBy(xpath= "//*[contains(@text,'Filter')]") public MobileElement filter_button;
	@FindBy(xpath= "//*[contains(@text,'Recent')]") public MobileElement recent_text;
	@FindBy(xpath= "//*[contains(@text,'Trending')]") public MobileElement trending_text;
	@FindBy(id= "com.tatadigital.tcp.dev:id/ivCrossButton") public MobileElement close_button;
	@FindBy(xpath= "//*[contains(@text,'Used')]") public MobileElement used_tab;
	@FindBy(id= "com.tatadigital.tcp.dev:id/btnBackSavedOffers") public MobileElement savedoffersback_button;
	@FindBy(id= "com.tatadigital.tcp.dev:id/bottom_home") public MobileElement bottomhome_button;
	@FindBy(id= "com.tatadigital.tcp.dev:id/bottom_home") public MobileElement bdp_banner_header;
	@FindBy(id= "com.tatadigital.tcp.dev:id/bottom_home") public MobileElement bdp_banner_content;
	
	@FindBy(xpath= "(//*[contains(@text,'CROMA')]/preceding::android.widget.TextView)[1]") public MobileElement croma_text_description;
	@FindBy(xpath= "(//*[contains(@text,'CLiQ')]/preceding::android.widget.TextView)[1]") public MobileElement cliq_text_description;
	@FindBy(xpath= "(//*[contains(@text,'bigbasket')]/preceding::android.widget.TextView)[1]") public MobileElement bb_text_description;
	//16th Aug
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/include_fabIcon']") public MobileElement cartIconBLPAnd;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/include_fabIcon_bdp']") public MobileElement cartIconBDPAnd;
	@FindBy(xpath= "//*[@resource-id='com.tatadigital.tcp.dev:id/positiveButton']") public MobileElement backGrooundAllowAccessAndroid;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnBrowseNow") public MobileElement emptyCartAndroid;
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvEdd") public MobileElement deliveryDateAnd;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp:id/backImageView']") public MobileElement backIconBDP;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp:id/imgHeroBanner']/parent::android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button") public MobileElement herobannerBuyNow;
	@FindBy(xpath = "//*[@resource-id='com.tatadigital.tcp:id/ivallBundles']") public List<MobileElement> bundlesImages;
	
	
	
	
}