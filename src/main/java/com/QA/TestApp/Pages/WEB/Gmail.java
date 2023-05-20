package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Gmail {
	@FindBy(xpath = "//input[@id='identifierId'][@type='email']") public WebElement emailTextBox;
	@FindBy(xpath="//span[text()='Next']/preceding-sibling::div/parent::button") public WebElement nextBtn;
	@FindBy(xpath="//input[@name='password'][@type='password']") public WebElement passwordTextBox;
	@FindBy(xpath="//a[text()='Inbox']") public WebElement inboxBtn;
	@FindBy(xpath="//div[@aria-label='Refresh'][@role='button']") public WebElement refreshBtn;
	@FindBy(xpath="(//div[@role='tabpanel']//table)[2]/tbody/tr[1]//td[@role='gridcell'][1]//div[2]/span/span") public WebElement firstEmailSenderName;
	@FindBy(xpath="(//div[@role='tabpanel']//table)[2]/tbody/tr[1]//td[@role='gridcell'][2]//div[2]/span/span") public WebElement firstEmailSubject;
	@FindBy(xpath="(//div[@role='tabpanel']//table)[2]/tbody/tr[1]//td[@role='gridcell'][4]/span") public WebElement firstEmailRevievedDateTime;
	@FindBy(xpath="(//div[@role='tabpanel']//table)[2]/tbody/tr[1]//td[@role='gridcell'][1]/div[1]") public WebElement firstEmailReadStatus;
//	@FindBy(xpath="//strong//parent::span") public WebElement otpTextInEmail;
	@FindBy(xpath="//div[@data-tooltip='Select']//span") public WebElement selectAllCheckbox;
	@FindBy(xpath="//div[@data-tooltip='Delete']")public WebElement deleteMailBtn;
	@FindAll({@FindBy(xpath="//strong//parent::span")}) public List<WebElement> otpTextInEmail;
	@FindBy(xpath="//div[@data-tooltip='Back to Inbox']")public WebElement backArrowToMailBtn;
	@FindBy(xpath="//div[contains(text(),'Your Primary tab is empty')]") public WebElement emptyInboxMsg;
}
