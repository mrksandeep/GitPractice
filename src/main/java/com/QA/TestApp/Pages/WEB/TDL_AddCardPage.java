package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_AddCardPage {
	@FindBy(xpath = "//input[@id='name_on_card']") public WebElement nameOnCard;
	@FindBy(id = "card_number") public WebElement cardNumber;
	@FindBy(id = "card_exp_month") public WebElement cardExpMonth;
	@FindBy(id = "card_exp_year") public WebElement cardExpYear;
	@FindBy(id = "cardAlias") public WebElement alias;
	@FindBy(xpath = "//button[contains(text(),'Continue')]") public WebElement continueBtn;
	@FindAll({@FindBy(xpath="//*[contains(@class,'sc-pzXPE lhhXeF')]")}) public List<WebElement> allError;
	@FindBy(xpath = "//*[@id='payment_form_addcard']") public WebElement addCardForm;
}





