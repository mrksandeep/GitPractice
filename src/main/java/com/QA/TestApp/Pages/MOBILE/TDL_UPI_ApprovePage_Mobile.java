package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_UPI_ApprovePage_Mobile {
	
	public TDL_UPI_ApprovePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivClose") public MobileElement ivClose_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement tvTitle_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivBack") public MobileElement ivBack_android;
	@FindBy(xpath = "//*[contains(@text, 'Pending')]") public MobileElement pending_android;
	@FindBy(xpath = "//*[contains(@text, 'Expired')]") public MobileElement expired_android;
	@FindBy(xpath = "//*[contains(@text, 'Mandate')]") public MobileElement mandate_android;
	@FindBy(xpath = "//*[contains(@text, 'Collect')]") public MobileElement collect_android;
	@FindBy(xpath = "//*[contains(@text, 'Block')]") public MobileElement block_android;
	@FindBy(xpath = "//*[contains(@text, 'Report')]") public MobileElement report_android;
	@FindBy(xpath = "//*[contains(@text, 'Do you want to block')]") public MobileElement confirmationPage_android;
	@FindBy(xpath = "//*[contains(@text, 'Success')]") public MobileElement successPage_android;
	@FindBy(xpath = "//*[contains(@text, 'Okay')]") public MobileElement okay_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvInitials") public MobileElement tvInitials_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPayerName") public MobileElement tvPayerName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRequestedAmount") public MobileElement tvRequestedAmount_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPayeeVpa") public MobileElement tvPayeeVpa_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvBlockVpa") public MobileElement tvBlockVpa_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRequestedOn") public MobileElement tvRequestedOn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvValidateUpTo") public MobileElement tvValidateUpTo_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDecline") public MobileElement tvDecline_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPay") public MobileElement tvPay_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAlertTitle") public MobileElement alertTitle_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPositive") public MobileElement okbtn_android;
	
//	@FindAll({@FindBy(id="")}) public List<MobileElement> mandateList_android;
	@FindBy(xpath="//*[@text='Approve']") public MobileElement approve_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDecline") public MobileElement decline_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPositive") public MobileElement declineYes_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPositive") public MobileElement declinesuccessfully_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPay") public MobileElement confirm_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMsg") public MobileElement errorMsg_android;
	@FindBy(id="") public MobileElement TryAgain_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnNegative") public MobileElement declineNo_android;

	// Mandate Expired page
	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvBlockVpa") public MobileElement expiredMandate_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMandateName")public MobileElement mandateName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvDesc")public MobileElement desc;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvCustomerName")public MobileElement customerName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPayeeUpiId")public MobileElement payeeUPIid_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvFrequency")public MobileElement frquency_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvValidity")public MobileElement validity_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRefId")public MobileElement refID_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUMN")public MobileElement umn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRRN")public MobileElement rrn_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRemark")public MobileElement remark_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAmount")public MobileElement amount_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAmountRule")public MobileElement amountRule_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvViewDetails") public MobileElement viewDetail_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvViewDetails") public MobileElement hideDetail_android;
	@FindAll({@FindBy(xpath="//*[@text='Decline']")}) public List <MobileElement> declineList_android;
	@FindAll({@FindBy(xpath="//*[@text='Block']")}) public List<MobileElement> BlockvpaList_android;
	
	@FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout[2]/android.widget.TextView[1]") public MobileElement acceptButton;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvmodifyMandate")public MobileElement modifyMandate_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tv_block")}) public List<MobileElement> tvBlockTataPayChannel_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/statusText")}) public List<MobileElement> tvStatusTataPayChannel_android;
	@FindBy(id="com.villevalta.intentlauncher:id/edit_uri") public MobileElement enterUri_android;
	@FindBy(id="com.villevalta.intentlauncher:id/action_launch") public MobileElement actionLaunch_android;
	@FindBy(id="com.villevalta.intentlauncher:id/decor_content_parent") public MobileElement intentLauncherHomePage_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/snackbar_text") public MobileElement errorMessageinApprovePage;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPayeeName") public MobileElement tvPayeeName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPayeeInitials") public MobileElement tvPayeeInitials_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvMandateName") public MobileElement tvMandateName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPayeeUpiId") public MobileElement payeeUpiId_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvValidity") public MobileElement tvValidity_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRefId") public MobileElement tvRefId_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUMN") public MobileElement tvUMN_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRRN") public MobileElement tvRRN_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRemark") public MobileElement tvRemark_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvViewDetails") public MobileElement tvViewDetails_android;

	/**
	 * Define ios locators
	 * 
	 */
	

	@FindBy(xpath ="//XCUIElementTypeNavigationBar[@name='TCPApp.UPICollectRequestView']") public MobileElement approvePageHeader_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Pending']") public MobileElement pendingTab_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Expired']") public MobileElement expiredTab_ios;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='Collect']") public MobileElement collectTab_ios;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='Mandate']") public MobileElement mandateTab_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[contains(@name,'₹')]") public MobileElement collectRequestAmount_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Decline']") public MobileElement declineBtn_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Approve']") public MobileElement approveBtn_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Block']") public MobileElement blockBtn_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Are you sure you want to decline this payment request?']") public MobileElement declinePopupMsg_ios;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='Yes']") public MobileElement declineYesBtn_ios;
	@FindBy(xpath ="//XCUIElementTypeButton[@name='Cancel']") public MobileElement declineCancelBtn_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Transaction rejected']") public MobileElement transactionRejectedPopUpMsg_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Ok']") public MobileElement transactionRejectedPopUpOkBtn_ios;
	@FindBy(xpath ="//XCUIElementTypeNavigationBar[@name='TCPApp.UPICollectRequestView']/XCUIElementTypeButton") public MobileElement approvePageBackBtn_ios;

	@FindBy(xpath ="//XCUIElementTypeStaticText[contains(@name,'Are you sure you want to block or report')]")	 public MobileElement blockUserPopup_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[contains(@name,'Are you sure you want to block or report')]//following-sibling::XCUIElementTypeButton[@name='Block']")	 public MobileElement blockUserPopupBlockBtn_ios;
	@FindBy(xpath ="//XCUIElementTypeStaticText[contains(@label,'We have successfully blocked this contact')]")	 public MobileElement userBlocked_Msg;

	
}
