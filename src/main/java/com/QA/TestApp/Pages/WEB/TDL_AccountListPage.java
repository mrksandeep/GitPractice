package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_AccountListPage {
	@FindBy(xpath="//*[contains(text(),'Security')]") public WebElement securityOpt;
	@FindBy(xpath="//*[contains(text(),'Addresses')]") public WebElement addressesOpt;
	@FindBy(xpath="//a[@href='/my-profile']") public WebElement profileOpt;	
	@FindBy(xpath="//*[contains(text(),'Sign out')]") public WebElement signOutOpt;
	@FindBy(xpath="//*[@id='signout-modal']/div/div/div[4]/button[2]") public WebElement yesbtn;
	@FindBy(xpath="//html/body/div[2]/div/div/div/div/div[4]/button[2]") public WebElement signoutBtn;
	@FindBy(xpath="//*[contains(text(),'Sign out of all devices & linked apps')]") public WebElement SignOutOfAllDevicesLinkedApps;
	@FindBy(xpath="//*[contains(text(),'Change Password')]") public WebElement changePassword;
	@FindBy(xpath="//*[contains(text(),'Refer a friend')]") public WebElement referafriendOpt;
	@FindBy(xpath="//label[contains(text(),'Legal')]") public WebElement legalOpt;
	@FindBy(xpath="//label[contains(text(),'Help')]") public WebElement helpOpt;
	@FindBy(xpath="//label[contains(text(),'Order History')]") public WebElement orderHistoryOpt;

}
