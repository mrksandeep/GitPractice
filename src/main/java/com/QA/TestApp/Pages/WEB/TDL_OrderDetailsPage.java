package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_OrderDetailsPage {
	

	@FindBy(xpath = "//*[contains(text(),'Payment Details')]") public WebElement paymentDetails;
	@FindBy(xpath = "//*[contains(text(),'Transaction Success')]") public WebElement transactionSuccess;
	@FindBy(xpath = " //img[@alt='bank-icon']") public WebElement bankIcon;
	@FindBy(xpath = "//*[@class='sc-pReKu sc-qYIQh cmQliW' and contains(text(),'#')]") public WebElement orderId;
	@FindBy(xpath = "//*[@class='sc-oTBUA sc-pJUVA kxyWmW']") public WebElement dateTime;
	@FindBy(xpath = "//*[contains(text(),'ITEM DESCRIPTION')]") public WebElement itemDescription;
	@FindBy(xpath = "//*[contains(text(),'QUANTITY')]") public WebElement quantity;
	@FindBy(xpath = "//*[contains(text(),'AMOUNT')]") public WebElement amount;
	@FindBy(xpath = "//*[contains(text(),'Talk To us')]") public WebElement talkTous;
	
}
