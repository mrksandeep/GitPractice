package com.QA.TestApp.Pages.WEB;

import com.QA.TestApp.Utilities.BaseScript;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_UniversalCartPage extends BaseScript {
	

//jan 29//
//PIMLoginPage//
	@FindBy(xpath = "//*[@id='login']/img") public WebElement PIM_LoginPage;
	@FindBy(xpath = "//*[contains(text(),'User Name:')]") public WebElement PIMUserfield;
	@FindBy(xpath = "//*[contains(text(),'Password:')]") public WebElement PIMPasswordfield;
	@FindBy(xpath = "//*[contains(text(),'Keep me signed in')]") public WebElement PIMSignInLabel;
	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]") public WebElement PIMforgotPassword;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]") public WebElement signinButton;
	@FindBy(xpath = "//*[contains(text(),'User Name:')]/following::input[1]") public WebElement PIMUserInput;
	@FindBy(xpath = "//*[contains(text(),'Password:')]/following::input[1]") public WebElement PIMPasswordInput;
	@FindBy(xpath = "//*[contains(text(),'User Id not found')]") public WebElement PIMInvalidUser;
	@FindBy(xpath = "//div[contains(text(),'Password does not match')]") public WebElement PIMInvalidPwd;
	@FindBy(xpath = "//*[contains(text(),'Keep me signed in')]/preceding::input[1]") public WebElement PIMSignInLabelInput;
	//PIMHomePage
	@FindBy(xpath = "//a[contains(text(),'PIM')]") public WebElement PIMHomePage;
	@FindBy(xpath = "(//a[contains(text(),'PIM')]/following::div/img)[1]") public WebElement PIMLogOff;
	@FindBy(xpath = "//*[contains(text(),'Logout')]") public WebElement PIMLogout;
	
	
	//Feb 08//
	//CartOrderPage//
	@FindBy(xpath="(//*[text()='Order Details'])[2]") public WebElement titleOrderDetailCart;
	@FindBy(xpath="(//*[text()='ORDER DETAIL'])[2]") public WebElement OrderNameCart;
	@FindBy(xpath="(//*[text()='ORDER DETAIL'])[2]/following-sibling::p") public WebElement OrderNameTextCart;
	@FindBy(xpath="//*[text()='Order Date']/following-sibling::p") public WebElement OrderDateTextCart;
	@FindBy(xpath="//*[text()='Order Date']") public WebElement OrderDateCart;
	@FindBy(xpath="//*[text()='Order Total']/following-sibling::p") public WebElement OrderTotalTextCart;
	@FindBy(xpath="//*[text()='Order Total']") public WebElement OrderTotalCart;
	@FindBy(xpath="//*[text()='Order Total']") public WebElement ItemdetailCart;
	@FindAll({@FindBy(xpath = "//*[text()='Item Detail']")}) public List<WebElement> ItemDetails;
	@FindAll({@FindBy(xpath = "//*[text()='Item Detail']/following::img[1]")}) public List<WebElement> ItemDetaildropdown;
	@FindAll({@FindBy(xpath = "(//*[text()='Item Detail']/following::div/div[2])[1]")}) public List<WebElement> Itemname;
	@FindBy(xpath="//*[text()='Cancel']") public WebElement CancelCart;
	@FindBy(xpath = "//*[contains(text(),'This will cancel all items in your bundle. Do you want to proceed?')]") public WebElement CancelPopup;
	@FindBy(xpath="//*[contains(text(),'Yes')]") public WebElement YesCancelCart;
	@FindBy(xpath="//*[text()='No']") public WebElement NoCancelCart;
	@FindBy(xpath="//*[text()='Need Help']") public WebElement NeedhelpCart;
	@FindBy(xpath="//*[text()='Chat']") public WebElement ChatboxCart;
	//Feb 16//
	@FindBy(xpath="//*[text()='Catalog']") public WebElement Catalog;
	@FindBy(xpath="//*[text()='Add Catalog']") public WebElement AddCatalog;
	@FindBy(xpath="//*[@class='profilePic']") public WebElement ProfilePic;
	@FindBy(xpath="//*[text()='Recent Partner Catalogs']") public WebElement RecentCatalog;
	@FindBy(xpath="(//*[text()='Add Catalog']/following::div/p)[1]") public WebElement CatalogName;
	@FindBy(xpath="(//*[text()='Add Catalog']/following::div/p)[2]") public WebElement Catalogdate;
	@FindBy(xpath="(//*[text()='Add Catalog']/following::div/p)[3]") public WebElement Skus;
	@FindBy(xpath="//*[@class='addCatalogDialogTitle']") public WebElement AddCataloghdr;
	@FindBy(xpath="//*[text()='Name']/following::input[1]") public WebElement catalogName;
	@FindBy(xpath="//*[text()='Description']/following::input[1]") public WebElement catalogDescription;
	@FindBy(xpath="//*[text()='Confirm']") public WebElement confirm;
	
	//Feb  17//
	@FindBy(xpath="//*[text()='tcp']") public WebElement tcp;
	//feb 22//
	@FindBy(xpath="//*[text()='Actions']/following::button[2]") public WebElement buttonArrow;
	@FindBy(xpath="//*[text()='SKU No.']/following::a[1]") public WebElement sku;
	@FindBy(xpath="//*[text()='Digital Media / Assets']") public WebElement Media;
	@FindBy(xpath="//*[text()='Upload Images']") public WebElement uploadImage;
	@FindBy(xpath="//*[text()='Upload Video']") public WebElement uploadvideo;
	@FindBy(xpath="//*[text()='Product Demo Video Clips']") public WebElement demoClips;
	@FindBy(xpath="//*[text()='Add Folder']") public WebElement addFolderMedia;
	@FindBy(xpath="//*[text()=' Folder name']") public WebElement FolderNameMedia;
	@FindBy(xpath="//*[text()=' Folder name']/following::input") public WebElement addFolderTxtMedia;
	//feb 23//Manage Tab//
	@FindBy(xpath="//*[text()='Manage']") public WebElement Managetab;
	@FindBy(xpath="//*[text()='Manage Users']") public WebElement ManageUser;
	@FindBy(xpath="//*[text()='Manage Roles']") public WebElement ManageRoles;
	@FindBy(xpath="//*[text()='Manage Classification Categories']") public WebElement classifiCategories;
	@FindBy(xpath="//*[text()='Manage Attributes']") public WebElement ManageAttributes;
	@FindBy(xpath="//*[text()='Classification Mapping']") public WebElement ClassificationMapping;
	@FindBy(xpath="//*[text()='Reports']") public WebElement Reports;
	@FindBy(xpath="//*[text()='Manage attributes']") public WebElement ManageAttributesheader;
	@FindBy(xpath="//*[text()='No Attribute is defined']") public WebElement EmptyAttribute;
	@FindBy(xpath="//*[text()='Select Files']") public WebElement selectFiles;
	@FindBy(xpath="//*[text()='Generate with label']") public WebElement headerUpload;
	@FindBy(xpath="//*[text()='Thumnail(155 X 175)']") public WebElement size;
	@FindBy(xpath="//*[text()='Desktop(700 X 250)']") public WebElement size1;
	@FindBy(xpath="//*[text()='Desktop(50 X 50)']") public WebElement size2;
	@FindBy(xpath="//*[text()='Mobile(75 X 75)']") public WebElement size3;
	@FindBy(xpath="//*[text()='First Name']") public WebElement fname;
	@FindBy(xpath="//*[contains(text(),'Validation')]") public WebElement validation;
	@FindBy(xpath="//*[text()='Upload']") public WebElement upload;
	
	//feb 25//
	@FindBy(xpath="//*[text()='Classification Category Description']") public WebElement classCategory;
	@FindBy(xpath="//*[text()='Product Category Description']") public WebElement productCategory;
	@FindAll({@FindBy(xpath = "//*[text()='View Details']")}) public List<WebElement> viewdetailsMap;
	@FindAll({@FindBy(xpath = "//*[@class='IconClassAttributes']")}) public List<WebElement> editdetailsMap;
	@FindBy(xpath="//*[text()='Classification category']") public WebElement classCategoryhdr;
	@FindBy(xpath="//*[text()='Attributes']") public WebElement attributesCategoryhdr;
	@FindBy(xpath="//*[@class='MuiSvgIcon-root']") public WebElement closeview;
	@FindBy(xpath="//*[text()=' Edit Classification Mapping']") public WebElement editHdr;
	@FindBy(xpath="//*[text()='Apply']") public WebElement apply;
	@FindBy(xpath="//*[text()='Types']") public WebElement typesCategoryhdr;
	@FindBy(xpath="//*[text()='Built-In Appliances']") public WebElement appliances;
	@FindBy(xpath="//*[text()='Electronics']") public WebElement Electronics;
	@FindBy(xpath="//*[text()='Mapping Applied successfully']") public WebElement Mapping;
	
	
	//Mar 2//
	@FindBy(xpath="(//*[@class='BtnTCPEdit'])[1]") public WebElement edit;
	@FindBy(xpath="//*[text()='Description']/following::textarea[1]") public WebElement editDescription;
	@FindBy(xpath="//*[text()='Saving']") public WebElement saving;
	//
	@FindBy(xpath="//*[text()='Super Savers']") public WebElement bundleTab;
	@FindBy(xpath="(//label[text()='Offers Zone'])[1] | (//label[text()='Offers zone'])[1] | (//label[text()='Offers'])[1]") public WebElement offerzone;
	@FindBy(xpath="(//label[contains(text(),'Offers zone')])[1] | (//img[@alt='offer-zone-icon'])[2]") public WebElement offerzone_pm;
	@FindBy(xpath="(//*[text()='Offers']/following::p)[1]") public WebElement blp_banner_header;
	@FindBy(xpath="(//*[text()='Offers']/following::p)[2]") public WebElement blp_banner_content;
	@FindBy(xpath="(//img[@alt='bundle banner image']/following::div)[2]") public WebElement bdp_banner_header;
	@FindBy(xpath="(//img[@alt='bundle banner image']/following::div)[3]") public WebElement bdp_banner_content;
	@FindAll({@FindBy(xpath = "//*[text()='View details']")}) public List<WebElement> viewdetails;
	@FindBy(xpath="//*[text()='Add to bundle']") public WebElement addtobundle;
	@FindBy(xpath="//*[text()='Added to bundle']") public WebElement addedtobundle;
	@FindBy(xpath="//button[@type='primary']/following::img | //button[@id='modal-close-button']") public WebElement closebutton;
	@FindBy(xpath=" (//*[contains(text(),'See all')])[2]") public WebElement seeallbutton;
	@FindBy(xpath="(//div[contains(text(),'Neuyear super saver deals')])[2]") public WebElement bundle_bonanza;
	@FindBy(xpath="//img[@alt='hamberger-icon']") public WebElement hamburger_menu;
	@FindBy(xpath="//*[text()='My transactions']") public WebElement orderhistory;
	@FindBy(xpath="//*[text()='Description'] | //*[text()='My transactions']") public WebElement orderhistory_description;
	@FindBy(xpath="//*[text()='Order details']") public WebElement orderdetails;
	@FindBy(xpath = "//*[contains(text(),'TataNeu Bundles')]") public WebElement universalcart_text;
	@FindBy(xpath="//img[@alt='Bundle Icon']/following-sibling::*") public WebElement bundle_name;
	@FindBy(xpath="//*[text()='Order ID']/following-sibling::*") public WebElement order_id;
	@FindBy(xpath="//*[text()='Order Date']/following-sibling::*") public WebElement order_date;
	@FindBy(xpath="(//img[@alt='Bundle Icon']/following::p)[2]") public WebElement order_status;
	@FindBy(xpath="//*[text()='Grand total']/following-sibling::* | //*[text()='Amount paid']/following-sibling::*") public WebElement total_paid_amount;
	@FindBy(xpath="(//*[text()='Paid using']/following::p)[1]") public WebElement paid_using;
	@FindBy(xpath="(//*[text()='Total item cost']/following::p)[1]") public WebElement total_item_cost;		
	
	@FindBy(xpath="//a[contains(text(),'Pick-up where you left off')]") public WebElement pickWhereYouLeft;
	@FindBy(xpath="//*[contains(text(),'Add to cart')]") public WebElement buttonAddToCart;
	@FindBy(xpath="//*[contains(text(),'Save for later')]") public WebElement buttonSaveForLater;
	@FindBy(xpath="//label[contains(text(),'Add New')]") public WebElement addNewAddress;
	@FindBy(xpath="//input[@id='googleSearchBox']") public WebElement addNewAddressSearchArea;
	@FindBy(xpath="//*[contains(text(),'Get current location - Use GPS')]") public WebElement addNewAddressGetCurrentLocation;
	@FindBy(xpath="//input[@name='savedAddresses']") public List<WebElement> savedAddressList;
	@FindBy(xpath="//button[contains(text(),'Proceed')]") public WebElement buttonProceed;
	@FindBy(xpath="//u[contains(text(),'Terms & conditions')]") public WebElement linkTermsAndConditions;
	@FindBy(xpath="//*[@id='modal-close-button']/following::div[3]/ul/li/p") public WebElement linkTermsAndConditionsText;
	@FindBy(xpath="//*[contains(text(),'In stock')]") public WebElement stockCheck;
	@FindBy(xpath="//*[contains(text(),'(Inclusive of all taxes)')]/parent::div/s") public WebElement productPrice;
	@FindBy(xpath="//*[contains(text(),'Key features')]") public WebElement productKeyFeatures;
	@FindBy(xpath="//*[contains(text(),'Overview')]") public WebElement productOverview;
	@FindBy(xpath="//*[contains(text(),'My Cart')]/following::div[6]/label[1] | //*[contains(text(),'My cart')]/following::div[5]/label[1]") public WebElement myCartBundleName;
	@FindBy(xpath="//*[contains(text(),'My Cart')]/following::div[6]/label[1] | //*[contains(text(),'My cart')]/following::div[5]/label[2]") public WebElement myCartBundleDesc;
	@FindBy(xpath="//*[contains(text(),'My Cart')]/following::div[6]/label[1] | //*[contains(text(),'My cart')]/following::div[5]/label[3]") public WebElement myCartNoOfItemsInBundle;
	@FindBy(xpath="//*[contains(text(),'My Cart')]/following::div[6]/label[1] | //*[contains(text(),'My cart')]/following::div[6]/label[1]") public WebElement BundleOriginalPrice;
	@FindBy(xpath="//*[contains(text(),'My Cart')]/following::div[6]/label[1] | //*[contains(text(),'My cart')]/following::div[6]/label[2]") public WebElement BundleDiscountedlPrice;
	//cart summary
	@FindBy(xpath="//*[contains(text(),'Payment summary')]/following::label[1]") public WebElement cartSummaryItemsTotal;
	@FindBy(xpath="//*[contains(text(),'Payment summary')]/following::label[3]") public WebElement cartSummarySubTotal;
	@FindBy(xpath="//*[contains(text(),'Payment summary')]/following::label[5]") public WebElement cartSummaryDiscountApplied;
	@FindBy(xpath="//*[contains(text(),'Payment summary')]/following::label[7]") public WebElement cartSummaryDeliveryCharge;
	@FindBy(xpath="//*[contains(text(),'Payment summary')]/following::label[9]") public WebElement cartSummaryShipiingTo;
	@FindBy(xpath="//*[contains(text(),'Payment summary')]/following::label[10]") public WebElement cartSummaryTotal;
	@FindBy(xpath="//button[contains(text(),'Checkout')]") public WebElement buttonCheckout;
	@FindBy(xpath="//*[contains(text(),'multiple')]") public WebElement shipToMultiPle;
	
	@FindBy(xpath="//*[contains(text(),'Edit')]") public WebElement cartEdit;
	@FindBy(xpath="//*[@id='trash-a'] | //*[contains(text(),'Delete')]") public WebElement cartDelete;
	@FindBy(xpath="//*[contains(text(),'Proceed to pay')]") public WebElement buttonProceedToPay;
	
	@FindBy(xpath="//*[@id='phone']") public WebElement phoneNo;
	@FindBy(xpath="//*[@id='grEmail']") public WebElement email;
	@FindBy(xpath="//*[contains(text(),'Contact information')]") public WebElement contactInfo;
	@FindBy(xpath="//*[contains(text(),'Shipping Details')] | //*[contains(text(),'SHIPPING')]") public WebElement shipingDetails;
	@FindBy(xpath="(//*[contains(text(),'Ship to')])[2]/following::img[1] | //*[contains(text(),'Ship to')]//following::u") public WebElement shipToAddress;
	@FindBy(xpath="//*[contains(text(),'Review order')]") public WebElement multipleAddressPageTitle;
	
	//Invoice Page
	@FindBy(xpath="//*[contains(text(),'Invoice')]") public WebElement invoicePageTitle;
	@FindBy(xpath="//*[contains(text(),'UNIVERSALCART')]") public WebElement componetName;
	@FindBy(xpath="//*[contains(text(),'Order')]") public WebElement OrderNo;
	@FindBy(xpath="//button[contains(text(),'Pay')]") public WebElement buttonPay;
	
//payment confirmation page
	
	@FindBy(xpath="//*[contains(text(),'Payment Complete')]") public WebElement paymentComplete;
	@FindBy(xpath="//*[@data-testid='cross-icon-view']") public WebElement closeIcon;
	@FindBy(xpath="//*[contains(text(),'Download Invoice')] | //*[contains(text(),'Download receipt')]") public WebElement invoiceDownLoad;
	@FindBy(xpath="//*[contains(text(),'PAYMENT DETAILS')]/following::button[1] | //*[contains(text(),'Payment details')]/following::button[1]") public WebElement paymentDetails;
	@FindBy(xpath="//*[contains(text(),'PAYMENT DETAILS')]/following::button[1]/following::h4 | //*[contains(text(),'Payment details')]/following::h4") public WebElement paymentType;
	@FindBy(xpath="//button[@id='backToHomeButton']") public WebElement backtoHomePage;
	@FindBy(xpath="//*[contains(text(),'Transaction ID')] | //*[contains(text(),'Reference ID')]") public WebElement trxnId;
	@FindBy(xpath="//*[contains(text(),'Failed')]") public WebElement paymentfailedstatus;
	
	
	//hero Bundles
	@FindBy(xpath="(//*[contains(text(),'Bundles')])[1]/following::div[16]") public WebElement heroBundle;
	@FindBy(xpath="(//*[contains(text(),'Bundles')])[1]/following::div[17]/p | (//*[contains(text(),'Bundles')])[1]/following::div[15]") public WebElement heroBundleName;
	@FindBy(xpath="(//*[contains(text(),'Bundles')])[1]/following::div[17]/p[2] | (//*[contains(text(),'Bundles')])[1]/following::div[16]") public WebElement heroBundleDesc;
	@FindBy(xpath="(//*[contains(text(),'Bundles')])[1]/following::div[16]/button") public WebElement heroBundleShopNowButton;
	@FindBy(xpath="//*[contains(text(),'Update cart')]") public WebElement buttonUpdate;
	@FindBy(xpath="//*[@style='cursor: pointer;']") public WebElement cartBackButton;
	@FindBy(xpath="//*[@id='modal-close-button']") public WebElement closeButton;
	
	//Address page
	@FindBy(xpath="//*[contains(text(),'ship to')] | //img[@alt='Edit']") public WebElement shipTo;
	@FindBy(xpath="//*[contains(text(),'Proceed')]") public WebElement proceedbutton;
	@FindBy(xpath="(//img[@alt='bundle banner image']/following::span)[3]") public WebElement not_servicable;
	
	//update page
	@FindBy(xpath="//*[contains(text(),'Bundle is already')]") public WebElement alreadyExistsTxt;
	@FindBy(xpath="//*[contains(text(),'Yes')] | //*[contains(text(),'Update')]") public WebElement yesButton;
	@FindBy(xpath="//*[contains(text(),'No')] | //*[contains(text(),'Cancel')]") public WebElement noButtonn;
	
	//
	@FindBy(xpath="//*[@mask='url(#chevron-right-circle-b)'] | /html/body/div[1]/div/div[73]/div[1]/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[3]/svg/g/circle") public WebElement rightArrow;
	@FindBy(xpath="(//*[@fill-rule='evenodd'])[3]") public WebElement rightArrow1;
	@FindBy(xpath="//*[@style='cursor: pointer;']") public WebElement backToBLP;
	@FindBy(xpath="(//*[text()='Bundles'])[1]") public WebElement activeBundles;
	@FindBy(xpath="//*[contains(text(),'BUNDLE')]/following::img[1]") public WebElement removeBundle;
	@FindBy(xpath="//*[contains(text(),'Removed from your bookmarks')]") public WebElement removeBundleNotification;
	@FindBy(xpath="//*[contains(text(),'Offers & Bundles')]/following::img[1]") public WebElement SavedScetionNavigation;
	@FindBy(xpath="//img[contains(@src,'Search')]") public WebElement serachIcon;
	
	@FindBy(xpath="//*[contains(text(),'U Rewards')]") public WebElement URewards;
	@FindBy(xpath="//*[contains(text(),'U Points')]") public WebElement UPoints;
	@FindBy(xpath="//*[contains(text(),'View Details')]") public WebElement upointsViewDetails;
	@FindBy(xpath="//*[contains(text(),'Activity')]") public WebElement Activity;
	@FindBy(xpath="//*[contains(text(),'Unlocking')]") public WebElement unlocking;
	@FindBy(xpath="//*[contains(text(),'Unlocking')]/parent::div/div") public WebElement earnPoints;
	
	//BBAndCliQ
	@FindBy(xpath="(//*[contains(text(),'Ship to')]/following::img)[1]") public WebElement ship_to_diff_address_lineitem;
	@FindBy(xpath="//*[contains(text(),'Browse')]") public WebElement browsebutton;
	@FindBy(xpath="//*[contains(text(),'Email ID')]/following::img[@alt='Edit']") public WebElement email_id_edit_button;
	@FindBy(xpath="//input[@id='grEmail']") public WebElement email_id_field_edit;
	@FindBy(xpath="//*[text()='Wellness box']/following::span[2]") public WebElement plus_button;
	@FindBy(xpath="//*[contains(text(),'from each category')]") public WebElement bundle_addition_error;
	
	@FindBy(xpath="(//img[@alt='thumbnail']/following::u)[1]") public WebElement select_first_product;
	@FindBy(xpath="(//img[@alt='thumbnail']/following::u)[2]") public WebElement select_second_product;
	@FindBy(xpath="(//img[@alt='thumbnail']/following::u)[3]") public WebElement select_third_product;
	@FindBy(xpath="(//img[@alt='thumbnail']/following::u)[4]") public WebElement select_fourth_product;
	@FindBy(xpath="//*[contains(text(),'bbstar Voucher')]/following::u[text()='Edit']") public WebElement email_id_edit_giftcard;
	@FindBy(xpath="//input[@name='SubscriptionEmail']") public WebElement email_id_field_edit_giftcard;
	
	@FindBy(xpath="//*[contains(text(),'Failed')]") public WebElement failure_failed_status;
	@FindBy(xpath="//*[contains(text(),'Pending - transaction initiated')]") public WebElement abort_single_pending_status;
	@FindBy(xpath="//*[contains(text(),'Failure - Timeout')]") public WebElement abort_single_failed_status;
	@FindBy(xpath="//*[contains(text(),'Pending - transaction initiated')]") public WebElement abort_multi_pending_status;
	@FindBy(xpath="//*[contains(text(),'Failure - Reversed')]") public WebElement abort_multi_failed_status;
	@FindBy(xpath="//*[@mask='url(#filter__b)']") public WebElement filter_button;
	@FindBy(xpath="//*[@mask='url(#chevron-bottom-b)']") public WebElement sortby_arrow;
	@FindBy(xpath="//*[contains(text(),'Out of stock')]") public WebElement out_of_stock_message;
	@FindBy(xpath="//*[contains(text(),'Recent')]") public WebElement recent_text;
	@FindBy(xpath="//*[contains(text(),'Trending')]") public WebElement trending_text;
	@FindBy(xpath="//*[contains(text(),'Used')]") public WebElement used_tab;
	
	@FindBy(xpath="//*[contains(text(),'CROMA')]/preceding::span[1]") public WebElement croma_text_description;
	@FindBy(xpath="//*[contains(text(),'CLiQ')]/preceding::span[1]") public WebElement cliq_text_description;
	@FindBy(xpath="//*[contains(text(),'bigbasket')]/preceding::span[1]") public WebElement bb_text_description;
	@FindBy(xpath="//*[contains(text(),'Handpicked offers for you')]") public WebElement handpickoffers_foryou;
	
	@FindBy(xpath="//*[contains(text(),'CROMA')]") public WebElement croma_text;
	@FindBy(xpath="//*[contains(text(),'CLiQ')]") public WebElement cliq_text;
	@FindBy(xpath="//*[contains(text(),'bigbasket')]") public WebElement bb_text;
	@FindBy(xpath="//*[contains(text(),'Delivery')]") public WebElement deliveryDate;
	@FindBy(xpath="//*[contains(text(),'Paid with')]/parent::div/following::div[2]") public WebElement orderHisPaymentInfo;
	@FindBy(xpath="//*[contains(text(),'Ref')]/parent::div/following::div[1]/p/span") public WebElement orderHisAddressInfo;
	@FindBy(xpath="//*[@alt='Offer']") public WebElement youmayLike;
	@FindBy(xpath="//*[@id='OZ_OZComponent7_Icon']") public WebElement savedBunldeIcon;
	
	@FindBy(xpath="(//*[@style='cursor: pointer;'])[2]") public WebElement retrunArrow;
	@FindBy(xpath="//button[contains(text(),'Explore more')]") public WebElement exploreButton;
	@FindBy(xpath="//*[contains(text(),'Amount')]/parent::div/following::span[1]") public WebElement paymentPageTotal;
	@FindBy(xpath="//button[contains(text(),'Cancel')]") public WebElement CancelButton;
	@FindBy(xpath="(//*[@data-testid='flex-status'])[1]/div") public WebElement orderStatus;
	@FindBy(xpath="//*[contains(text(),'Debit cards')]/following::*[5]") public WebElement debitcardRadioButton;
	@FindBy(xpath="//span[contains(text(),'maximum allowed quantity')]") public WebElement ErrorMsg;
	@FindBy(xpath="//button[text()='Okay']") public WebElement Okaybtn;
	@FindBy(xpath="//*[@id='chevron-left-a']") public WebElement BackBtn;
	@FindBy(xpath="//u[text()='Delete']") public WebElement DeleteBtn;
	@FindBy(xpath="//button[contains(text(),'Shop now')]") public WebElement ShopNowBtn;
	@FindBy(xpath="//span[contains(text(),'Error')]") public WebElement ErrorText;
	
	
	
}
