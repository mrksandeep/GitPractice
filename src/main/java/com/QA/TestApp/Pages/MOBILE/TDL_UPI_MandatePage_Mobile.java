package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_UPI_MandatePage_Mobile {
	
	public TDL_UPI_MandatePage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/ivProfile")}) public List<MobileElement> mandateList_android;
	@FindBy(xpath = "//*[@text='Active']") public MobileElement active_android;
	@FindBy(xpath = "//*[@text='Completed']") public MobileElement completed_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRevoke") public MobileElement revoke_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivMoreInfo") public MobileElement threedot_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPaymentHistory") public MobileElement paymentHistory_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnPositive") public MobileElement revokeYes_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/btnNegative") public MobileElement revokeDecline_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvBlockVpa") public MobileElement ongoingLabel_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvCreatedDate") public MobileElement createdDate_android;
	@FindAll({@FindBy(xpath="//*[@text='Ongoing']")}) public List<MobileElement> ongoingtext_android;	
	@FindAll({@FindBy(xpath="//*[@text='Expired']")}) public List<MobileElement> expiredtext_android;	


	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/ivMoreInfo")}) public List<MobileElement> threedotOption_android;	
	//8-12
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUtrNumber") public MobileElement UTRID_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPayeeName") public MobileElement payeeName_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvPayeeId") public MobileElement payeeId_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvRemarks") public MobileElement remarks_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvTxnId") public MobileElement txnID_android;







	
	
	
	/**
	 * Define ios locators
	 * 
	 */
	
	
}
