package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_AddressChoosePage {
	@FindBy(xpath = "//*[contains(text(),'Addresses')]") public WebElement adressesHeader;
	@FindBy(xpath="//input[@id='googleSearchBox']") public WebElement googleSearchBox;
	@FindBy(xpath="//html//body//div[6]//div[1]") public WebElement address_SuggetionTab;
	@FindBy(xpath="//*[contains(text(),'Get current location - Use GPS')]") public WebElement getcurrentlocation;
	@FindBy(xpath="//*[contains(text(),'Enter Address Manually')]") public WebElement enteraddressmanually;
	@FindBy(css=".sc-fzoyAV:nth-child(1)") public WebElement searchAddressFirstElement;
	}

//*[contains(text(),'Ok')]