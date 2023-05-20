package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_LendingPage {

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(),'Tata Capital Credit Line')]") public WebElement tataCapitalBannerHdr;
	@FindBy(xpath = "//*[contains(text(),'Avail Now')]") public WebElement availNowBtn;
	@FindBy(xpath = "(//*[contains(text(),'EMI Card')])[1]") public WebElement activatePageHdr;
	@FindBy(id = "tnc-link") public WebElement termncondLink;
	@FindBy(xpath = "//button[text()='Activate Now']") public WebElement activateNowBtn;
	@FindBy(xpath = "//*[contains(text(),'credit line')]") public WebElement activationStatus;
	@FindBy(xpath = "//*[contains(text(),'Congratulations')]") public WebElement cogratulationTxt;
	@FindBy(id = "Remind-Later") public WebElement remindBtn;
	@FindBy(xpath = "//*[contains(text(),'Channels')]") public WebElement channelsHdr;
	@FindBy(xpath = "//*[contains(text(),'Tata Pay')]") public WebElement tataPayLink;
	@FindBy(xpath = "//button[contains(text(),'Accept')]") public WebElement acceptBtn;
	
	//Vault page
	
	@FindBy(xpath = "//*[contains(text(),'Tata capital Credit...')] | //*[contains(text(),'Tata capita...')]") public WebElement tataCapitalCard;
	@FindBy(xpath = "//*[contains(text(),'AVAILABLE BALANCE')]/following-sibling::*") public WebElement availableBalance;
	@FindBy(xpath = "//*[contains(text(),'AVAILABLE BALANCE')]/../following-sibling::*") public WebElement buttonDisplayed;
	
	//View detail page
	@FindBy(xpath = "//*[contains(text(),'View Details')]") public WebElement viewdetailHdr;
	
	//Detail Section in Tata Capital Credit line
	@FindBy(xpath ="//*[@id='panCard']") public WebElement PanCard_Input_field;
	@FindBy(xpath ="//*[@id='select-button']") public WebElement Gender_button;
	@FindBy(xpath ="//*[@id='name']") public WebElement Full_Name_Input_Field;
	@FindBy(xpath ="//*[@id='pinCode']") public WebElement PinCode;
	
}
