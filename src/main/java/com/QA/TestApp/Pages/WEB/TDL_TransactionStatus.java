package com.QA.TestApp.Pages.WEB;
import com.QA.TestApp.Utilities.BaseScript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_TransactionStatus extends BaseScript {
	

	@FindBy(xpath = "//h3[contains(text(),'Welcome to Razorpay Bank')]") public WebElement paymentConfirmation;
	@FindBy(xpath = "//button[text()='Success']") public WebElement successBtn;
	@FindBy(xpath = "//input[@name='callback_url']") public WebElement hiddenBtn;
	@FindBy(xpath = "//button[text()='Failure']") public WebElement failureBtn;
	@FindBy(xpath = "//div[contains(text(),'Transaction ID')]") public WebElement transactionID;
	@FindBy(xpath = "//span[text()='Payment Successful!']") public WebElement paymentSuccessful;
	@FindBy(xpath = "//h4[@class='sc-fzoCCn lewZOv']") public List<WebElement> paymentMode;
	@FindBy(xpath = "//p[text()='Payment Details']/../..//*[@fill='none']") public WebElement paymentDetailsArrow;
	@FindBy(xpath = "//h4[@class='sc-fzoPby cSPfCG']") public List<WebElement> paidAmt;
	@FindBy(xpath = "//div[contains(text(),'Back To HomePage')]") public WebElement backToHomepage;
	@FindBy(xpath = "//*[@alt='cancel_icon']") public WebElement closeBtn;
	@FindBy(xpath = "//p[contains(@class,'sc-fz')]") public List<WebElement> errPopupobjects;
	@FindBy(xpath = "//button[text()='OK']") public WebElement alertOkBtn;
}
