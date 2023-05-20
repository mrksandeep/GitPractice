package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_FSUploadDocPage_Mobile {
	
	public TDL_FSUploadDocPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/*
	 * Android Element locators
	 * 
	 */
	@FindBy(xpath = "//*[contains(@text,'UPLOAD DOCUMENTS')]") public MobileElement uploadDocPageHeader_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvClaimNumber") public MobileElement claimNoUploadPg_android;
	@FindBy(xpath = "//*[contains(@text,'Upload')]") public List<MobileElement> uploadBtns_android;
	@FindBy(id = "android:id/text1") public MobileElement selectFromGallary_android;
	@FindBy(xpath = "//*[contains(@text,'ALLOW')]") public MobileElement allowBtn_android;
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Show roots']") public MobileElement rootFolder_android;
	@FindBy(xpath = "//*[contains(@text,'Images')]") public MobileElement imageFolder_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivAttachmentArrow") public List<MobileElement> attachmentArrows_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvFileName") public MobileElement fileName_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivRemoveFile") public MobileElement removeFileBtn_android;


	/*
	 * ios Element locators
	 * 
	 */

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Upload Documents\"]") public MobileElement uploadDocPageHeader_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Upload']") public List<MobileElement> uploadBtns_ios;
	@FindBy(id = "//XCUIElementTypeButton[@name=\"Gallery\"]") public MobileElement selectFromGallary_ios;
	@FindBy(xpath = "//XCUIElementTypeCell[@name=\"All Photos\"]") public MobileElement imageFolder_ios;
	@FindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther") public MobileElement image_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Add\"]") public MobileElement addBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Submit Claim']") public MobileElement submitClaimbtn_ios;
}
