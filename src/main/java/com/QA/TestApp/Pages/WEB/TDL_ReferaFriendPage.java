package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_ReferaFriendPage {
	@FindBy(xpath = "//*[contains(text(),'Refer a friend')]") public WebElement referFriendHeader;
	@FindBy(xpath="//*[@id='app']/div[2]/div[2]/button") public WebElement shareBtn;
	@FindBy(xpath="//*[@id=\"refer-friend-modal\"]/div/div/div[3]/div[1]") public WebElement facebook;
	@FindBy(xpath="//*[@id=\"refer-friend-modal\"]/div/div/div[3]/div[2]") public WebElement twitter;
	@FindBy(xpath="//*[@id=\"refer-friend-modal\"]/div/div/div[3]/div[3]") public WebElement email;
	@FindBy(xpath="//*[@id=\"refer-friend-modal\"]/div/div/div[3]/div[4]") public WebElement whatsaap;
	@FindBy(xpath="//*[contains(@class,' close-icon')]") public WebElement closebtn;
	}