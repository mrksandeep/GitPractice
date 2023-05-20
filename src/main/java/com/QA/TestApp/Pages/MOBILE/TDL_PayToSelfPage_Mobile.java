package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_PayToSelfPage_Mobile {
	
	public TDL_PayToSelfPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement tvTitle_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etBank") public MobileElement ivBack_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnProceed") public MobileElement addAccountBtn_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvCheckBalance")}) public List<MobileElement> checkBalance_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/rbAccountSelector")}) public List<MobileElement> rbAccountSelector_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvAccountNumber")}) public List<MobileElement> tvBankNameAccountNumber_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnAddAccount") public MobileElement btnAddAccount_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnProceed") public MobileElement proceedBtn_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/rbAccountSelector")}) public List<MobileElement> primaryAccountlist_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvBankName")}) public List<MobileElement> tvBankName_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvPopularBank") public MobileElement tvPopularBank_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivDropDown") public MobileElement ivDropDown_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivDropDown") public MobileElement setpin_android;

//lipika//
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivBack") public MobileElement ivBack1_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etBank") public MobileElement searchBank_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvAccountNumber")}) public List<MobileElement> accountlist_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/ivProfile")}) public List<MobileElement> ivProfileList_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvIfsc")}) public List<MobileElement> iifcList_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvName")}) public List<MobileElement> bankNameList_android;
 	@FindBy(id = "com.tatadigital.tcp.dev:id/tvMsg") public MobileElement tvMsg_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPositive") public MobileElement bthOkay_android;
	@FindBy(id="android.miui:id/tv_single_file_name") public MobileElement fileName_android;
	@FindBy(id="android:id/button2") public MobileElement cancelBtn_android;
	
	
	//IFSC Code
		@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvIfsc")}) public List<MobileElement> tvBankIFSC_android;
		//Bank Logo
		@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/ivProfile")}) public List<MobileElement> tvBankLogo_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/btnScanQRCodeFromGallery") public MobileElement scanFromGallery_android;
	@FindBy(xpath="//*[@content-desc='Photos'])[1]") public MobileElement folderPhotos_android;
	@FindBy(xpath="//*[@text='Albums']") public MobileElement folderAlbums_android;
	@FindBy(xpath="//*[@text='Others']") public MobileElement folderOthers_android;
	@FindBy(xpath="//*[@text='UPI']") public MobileElement folderUpicode_android;
	@FindAll({@FindBy(id="com.miui.gallery:id/pick_num_indicator")}) public List<MobileElement> imageList_Android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMsg") public MobileElement permissionMsg_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/llPowered") public MobileElement merchantlist_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUpiInputError") public MobileElement errorMsgdisplyed_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose") public MobileElement closeIcon;
	@FindBy(id="com.tatadigital.tcp.dev:id/touch_outside") public MobileElement touchOutside;
	
	/**
	 * Define ios locators
	 * 
	 */
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Add Account']") public MobileElement addAccountBtn_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='POPULAR BANKS']") public MobileElement popularBankHeader_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='POPULAR BANKS']//following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText[@name='ICICI BANK LIMITED']") public MobileElement iciciBank_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='No accounts were fetched with the selected bank, please select another bank to continue']") public MobileElement noAccountFetchedErrorMsg_ios;
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Please select bank account']") public MobileElement selectBankAccountHeader_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Proceed']") public MobileElement proceedBtn_ios;

	@FindBy(xpath="//XCUIElementTypeButton[@name='RadioUncheck']") public List<MobileElement> noOfBankAccountInPaySelf;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Next']") public MobileElement nextBtn_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='UPI.ScanQR.Gallery']") public MobileElement scanQrFromGalleryBtn_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='Albums']") public MobileElement albumsBtn_ios;
	@FindBy(xpath="//XCUIElementTypeButton[@name='See All']") public MobileElement seeAllAlbumsBtn_ios;
	@FindBy(xpath="//XCUIElementTypeOther[@name='TCP-QR']") public MobileElement qrFolderInIphone_ios;
	@FindBy(xpath="//XCUIElementTypeScrollView//XCUIElementTypeImage") public MobileElement qrcodeImage_ios;


}