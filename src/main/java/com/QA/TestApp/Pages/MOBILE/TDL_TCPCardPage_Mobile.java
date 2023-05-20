package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_TCPCardPage_Mobile {

	public TDL_TCPCardPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/brandNameTextView")
	public MobileElement cardNameText_TCP_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/totalPoint")
	public MobileElement totalPoints_TCP_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/expiryDateTextView")
	public MobileElement pointsExpiring_TCP_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/expiryDateValueTextView")
	public MobileElement pointsExpiryDate_TCP_android;

	@FindBy(xpath = "//*[@text='Activity']")
	public MobileElement activityTab_TCP_android;

	@FindBy(xpath = "//*[@text='Points Schedule']")
	public MobileElement pointsScheduleTab_TCP_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/transactionInfoViewPager")
	public MobileElement scrollableSectionUnderTabId_TCP_android;

	@FindBy(className = "androidx.viewpager.widget.ViewPager")
	public MobileElement scrollableSectionUnderTabClassName_TCP_android;

	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[2]")
	public List<MobileElement> pointsActivity_TCP_android;

	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]")
	public List<MobileElement> transcDesc_TCP_android;

	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[3]")
	public List<MobileElement> transcDate_TCP_android;

	@FindBy(id = "com.tatadigital.tcp.dev:id/cancelButtonImageView")
	public MobileElement closeBtn_TCP_android;
	
	/**
	 * Objects for VISA Card
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvMore")
	public MobileElement morebtn_VISA;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvActivities")
	public MobileElement activitiesbtn_VISA;
	@FindBy(id = "om.tatadigital.tcp.dev:id/ivTrash")
	public MobileElement deletebtn_VISA;
	@FindBy(id = " com.tatadigital.tcp.dev:id/rbToday ")
	public MobileElement todaysRbtn;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbLast7Days ")
	public MobileElement last7DaysRbtn;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbThisMonth ")
	public MobileElement thisMonthRbtn;
	@FindBy(id = "com.tatadigital.tcp.dev:id/rbCustom")
	public MobileElement customRbtn;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPdf")
	public MobileElement pdfbtn;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnExcel")
	public MobileElement excelbtn;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivTxnClose ")
	public MobileElement closebtn_VISA;
	@FindBy(id="com.tatadigital.tcp.dev:id/tv")
	public MobileElement cardNumber_VISA;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvExpiry")
	public MobileElement expirydate_VISA;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvCardHolderName")
	public MobileElement cardholderName_VISA;
	/**
	 * Define ios locators
	 * 
	 */
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='U Points']")
	public MobileElement cardNameText_TCP_ios;

	@FindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[3]")
	public MobileElement totalPoints_TCP_ios;

	@FindBy(xpath = "")
	public MobileElement pointsExpiring_TCP_ios;

	@FindBy(xpath = "")
	public MobileElement pointsExpiryDate_TCP_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Activity']")
	public MobileElement activityTab_TCP_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Points Schedule\"]")
	public MobileElement pointsScheduleTab_TCP_ios;

	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"TCP SIT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView")
	public MobileElement scrollableSectionUnderTab_TCP_ios;

	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"TCP SIT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[2]")
	public List<MobileElement> pointsActivity_TCP_ios;

	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"TCP SIT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
	public List<MobileElement> transcDesc_TCP_ios;

	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"TCP SIT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[3]")
	public List<MobileElement> transcDate_TCP_ios;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='loyalty.vault.close']")
	public MobileElement closeBtn_TCP_ios;
}
