package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class TDL_PaymentCards_Mobile {
	
	public TDL_PaymentCards_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	@FindBy(xpath ="//XCUIElementTypeButton[@name='trash']") public MobileElement deleteBtn_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Activities']")
	public MobileElement activities_ios;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='More']")
	public MobileElement moreBtn_ios;
	
	@FindBy(id = "tcpApp.moreView.button.optionOneButton")
	public MobileElement today_ios;
	
	@FindBy(id = "tcpApp.moreView.button.optionTwoButton")
	public MobileElement last7days_ios;
	
	@FindBy(id = "tcpApp.moreView.button.optionThirdButton")
	public MobileElement thismonth_ios;
	
	@FindBy(id = "tcpApp.moreView.button.customButton")
	public MobileElement custom_ios;	
	@FindBy(id = "tcpApp.moreView.button.pdfButton") public MobileElement pdf_ios;
	@FindBy(id = "tcpApp.moreView.button.excelButton") public MobileElement excel_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Confirm']") public MobileElement deleteconfirmBtn_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']") public MobileElement delletecancel_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Done']") public MobileElement dateDone_ios;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Cancel']") public MobileElement datecancel_ios;
	@FindBy(id = "tcpApp.moreView.startDateIcon") public MobileElement startdate_ios;
	@FindBy(id = "tcpApp.moreView.endDateIcon") public MobileElement enddate_ios;
	@FindBy(id = "iconCircleCross ") public MobileElement closeBtn_ios;

	@FindBy(id = "tcpApp.userVault.bankCardName") public MobileElement cardHeader_ios;
	@FindBy(xpath = "//*[contains(@value,'JP MORGAN')]") public MobileElement selectCard_ios;
	@FindBy(xpath = "//*[contains(@value,'BANKOFHAWAII')]") public MobileElement debitCard_ios;
	@FindBy(xpath = "//*[contains(@value,'BANCOMULTIPLEPROMERICADELAREPUBLICADOMINICANA.S.A.')]") public MobileElement creditCard_ios;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Home']") public MobileElement backhome_ios;


}
