package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_UPI_TransHistoryPage_Mobile {
	
	public TDL_UPI_TransHistoryPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivFilter") public MobileElement filter_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipFilterCredited") public MobileElement chipFilterCredited_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipFilterDebited") public MobileElement chipFilterDebited_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipDurationToday") public MobileElement today_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipDurationWeek") public MobileElement week_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipDurationMonth") public MobileElement month_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipDurationCustom") public MobileElement custom_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etStartDate") public MobileElement startDate_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etEndDate") public MobileElement endDate_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipFormatPdf") public MobileElement pdf_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipFormatExcel") public MobileElement excel_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPerformAction") public MobileElement perforkmAction_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/cbSelection")}) public List<MobileElement> cbSelection_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivFilter") public MobileElement ivFilter_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipDurationToday") public MobileElement chipDurationToday_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipDurationWeek") public MobileElement chipDurationWeek_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipDurationMonth") public MobileElement chipDurationMonth_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipDurationCustom") public MobileElement chipDurationCustom_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etStartDate") public MobileElement etStartDate_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etEndDate") public MobileElement etEndDate_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipFormatPdf") public MobileElement chipFormatPdf_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/chipFormatExcel") public MobileElement chipFormatExcel_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPerformAction") public MobileElement btnPerformAction_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/cbSelection")}) public List<MobileElement> byaccSelection_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/clTransactionContainer")}) public List<MobileElement> clTransactionContainer_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvTransactionDate")}) public List<MobileElement> txnDateList_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvTransactionId")}) public List<MobileElement> txnNumnberList_android;
	@FindBy(id="android:id/prev") public MobileElement previousMon_android;
	@FindBy(id="android:id/button1") public MobileElement okbutton_android;
	
	/**
	 * Define ios locators
	 * 
	 */
	
	
}
