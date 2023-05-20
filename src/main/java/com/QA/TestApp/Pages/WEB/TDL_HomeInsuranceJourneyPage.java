package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_HomeInsuranceJourneyPage {
	
	@FindBy(xpath = "(//*[text()='Know More'])[2]") public WebElement knowMoreHCI;
	@FindBy(xpath = "//div/span[text()='HomeAwaySecure Insurance'] | //div/span[text()='Home Protection While You are Away']") public WebElement hciKnowMoreDetailsTxt;
	
	@FindBy(xpath = "//*[@id='app']//h1[contains(text(),'Activate Home Protection')] | //*[@id='app']//h1[contains(text(),'Safeguard Your Home')] | //*[contains(text(),'Safeguard your Home')]") public WebElement hciPageTitle;
	@FindBy(xpath = "//*[@data-testid='add-address']") public WebElement addAddressBtn;
	
	@FindBy(xpath = "//input[@name='addressFlatNumber']") public WebElement flatNumber;
	@FindBy(xpath = "//input[@name='address1'] | //*[@name='address1']") public WebElement addressLine1;
	@FindBy(xpath = "//input[@name='addressPincode']") public WebElement pinCode;
	@FindBy(xpath = "//input[@id='addressCity']") public WebElement city;
	@FindBy(xpath = "//input[@id='addressState']") public WebElement state;
	@FindBy(xpath = "//*[contains(text(), 'SAVE AS')] | //*[contains(text(),'Save As')]") public WebElement saveAsLabel;
	
	@FindBy(xpath = "//label[contains(text(),'Home')] | //button[contains(text(),'Home')]") public WebElement saveAsHome;
	@FindBy(xpath = "//label[contains(text(),'Work')]") public WebElement saveAsWork;
	@FindBy(xpath = "//label[contains(text(),'Custom')]") public WebElement saveAsCustom;
	@FindBy(xpath = "//*[contains(text(),'is mandatory')]") public WebElement mandatoryErrorMsg;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')] | //button[text()='Next']") public WebElement continueBtn;
	@FindBy(xpath = "//button[contains(text(),'Submit')]") public WebElement SubmitBtn;
	
	@FindBy(xpath = "//*[contains(text(),'office')]/..") public WebElement officeAddress;
	@FindBy(xpath = "//*[contains(text(),'office')]/../../div/div/label/input") public WebElement officeAddressRadioBtn;
	@FindBy(xpath = "//*[contains(text(),'Home')]/../../div[2]") public WebElement homeAddress;
	@FindBy(xpath = "//*[contains(text(),'Home')]/../../div/div/label/input") public WebElement homeAddressRadioBtn;
	
	@FindBy(xpath = "//button[text()='Next']") public WebElement nextBtn;
	
	//R2
	@FindBy(xpath = "//*[contains(text(),'Addresses')]") public WebElement addressTxt;
	@FindBy(xpath = "//*[@id='googleSearchBox']") public WebElement searchBar;
	@FindBy(xpath = "(//*[@class='pac-container pac-logo'][3]/div//following-sibling::*)[2]") public WebElement firstOption;
	//@FindBy(xpath = "//*[@id='googleSearchBox']/../../following-sibling::div[1]") public WebElement firstOption;
	//@FindBy(xpath = "//*[@data-testid='get-current-location']") public WebElement firstOption;

}
