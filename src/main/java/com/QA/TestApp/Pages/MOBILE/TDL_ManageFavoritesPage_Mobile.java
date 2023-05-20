package com.QA.TestApp.Pages.MOBILE;

import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.TestApp.Utilities.BaseScript;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TDL_ManageFavoritesPage_Mobile {
	
	public TDL_ManageFavoritesPage_Mobile() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}

	/**
	 * Define Android locators
	 * 
	 */
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivAdd") public MobileElement ivAddButton_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivAdd") public MobileElement ivAdd_android;
	@FindBy(xpath = "//*[contains(@text, 'Manage favourites')]") public MobileElement manageFavoriteTxt_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivBack") public MobileElement ivBack_android;
	@FindBy(xpath = "//*[contains(@text, 'Add Contact')]") public MobileElement addContact_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etSearch") public MobileElement searchTab_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clRoot") public MobileElement selectContact_android;
	@FindBy(id = "") public MobileElement blockAccountHeader_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvDelete") public MobileElement remove_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement yes_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnNegative") public MobileElement no_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement tvTitle_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/clRoot") public MobileElement presentContact_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/clRoot")}) public List<MobileElement> contactList_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvMsg") public MobileElement tvMsg_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvDelete")}) public List<MobileElement> removeList_android;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvAlertTitle") public MobileElement alertTitle_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivClose") public MobileElement close_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/tvUpiID") public MobileElement upiId_android;
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvSettingsTitle")}) public List<MobileElement> settingsTitle_android;
	//@FindBy(id = "com.tatadigital.tcp.dev:id/clRoot") public MobileElement noContactTxt_android;
	
	//oct27
	@FindAll({@FindBy(id="com.tatadigital.tcp.dev:id/tvDelete")}) public List<MobileElement> deleteList_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement yes_delete_android;	
	 	
	//oct30
	@FindBy(xpath="//*[contains(@text, 'Yes')]") public MobileElement upi_deregister_yes_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnPositive") public MobileElement upi_deregister_OK_android;
	@FindBy(xpath="//*[contains(@text, 'Create UPI')]") public MobileElement create_UPI_android;
	
	@FindAll({@FindBy(xpath = "//android.widget.CheckBox")}) public List<MobileElement> checkbox_android;
	@FindBy(id="com.tatadigital.tcp.dev:id/ivDeleteButton") public MobileElement ivDeleteButton;
	
	@FindBy(id="com.tatadigital.tcp.dev:id/tvNoDataFound") public MobileElement tvNoDataFound_android;
	
	/**
	 * Define ios locators
	 * 
	 */
	
	
	@FindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell") public List<MobileElement> beneficiaryList_ios;

	
	
}
