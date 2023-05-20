package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MultitenderPage {
	@FindBy(xpath = "//*[contains(text(),'PAYMENT METHODS')]") public WebElement paymentMethodTxt;
	@FindBy(xpath = "//span[text()='Change']") public WebElement change;
	@FindBy(xpath = "//*[contain(text(),'UPI')]") public WebElement upi;
	@FindBy(xpath = "//*[contains(text(),'CREDIT CARD')]") public WebElement creditCard;
	@FindBy(xpath = "//*[contains(text(),'DEBIT CARD')]") public WebElement debitCard;
	@FindBy(xpath = "//*[contains(text(),'NETBANKING')]") public WebElement netBanking;
	@FindBy(xpath = "//span[text()='Add New']") public WebElement addNew;
	@FindBy(xpath = "//*[@name='security_code']") public WebElement securityCode;
	@FindBy(xpath = "//button[contains(text(),'Pay')]") public WebElement pay;
	@FindBy(xpath = "//button[contains(text(),'Success')]") public WebElement successbtn;
	@FindBy(xpath = "//img[@src='https://tatadigital-dev.adobecqms.net/content/dam/tcp/app-core/app-content/network-logos/ic_bank_508534.png']") public WebElement icicibank;
	@FindBy(xpath = "//*[contains(@href,'#radio-checked-a')]") public WebElement rediocheckDebit;
	@FindBy(xpath = "//div[contains(text(),'JP MORGAN')]/../../..//*[@fill='none']") public WebElement creditCardRadioBtn;
	@FindBy(xpath = "//div[@data-testid='Main-flex']//div[@class='Flex__Box-kdyZDI beBEsA sc-pRtAn egRkaq']") public List<WebElement> netbankOptions;
	@FindBy(xpath = "//*[@data-testid='send-Bank-Details']") public List<WebElement> netbankLogos;
	@FindBy(xpath = "//div[text()='More Banks']") public WebElement moreBanks;
	@FindBy(xpath ="//div[contains(@class,'Flex__Box-kdyZDI beBEsA sc-pZOBi bNnzrs') and contains(text(),'Other Banks')]") public WebElement otherBanksTxt;
	@FindBy(xpath = "//input[@data-testid='search-Bar']") public WebElement searchBox;
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI beBEsA sc-pbxSd lnZBTG']") public List<WebElement> listOfBanks;
	@FindBy(xpath = "//div[contains(@class,'Flex__Box-kdyZDI beBEsA sc-fzpkqZ fOXUpi') and contains(text(),'points')]") public WebElement tcpPoints;
	@FindBy(xpath = "//span[text()='TCP Points']/..//*[@fill='none']") public WebElement tcpPointsCheckbx;
	@FindBy(xpath = "//span[text()='Edit']") public WebElement editCTA;
	@FindBy(id = "loyaltyPointstxt") public WebElement customTcpPointsInput;
	@FindBy(xpath = "//button[text()='Confirm']") public WebElement confirmBtn;
	@FindBy(xpath = "//p[text()='Info!!!']") public WebElement infoAlert;
	@FindBy(xpath = "//p[text()='Warning']") public WebElement warnAlert;
	@FindBy(xpath = "//button[text()='OK']") public WebElement alertOkBtn;
	@FindBy(xpath = "//button[text()='Cancel']") public WebElement alertCancelBtn;
	@FindBy(xpath = "//h4") public WebElement alertMessage;
	@FindBy(xpath = "//span[@class='sc-fznzOf jxQFAb'] | //span[text()='Change']/preceding-sibling::span") public WebElement defaultPaymentMode;
	@FindBy(xpath = "//div[contains(text(),'ICICI BANK')]") public WebElement searchICICI;
	@FindBy(xpath = "//input[@type='radio']") public List<WebElement> cardRadiobtn;
	@FindBy(xpath = "//div[contains(@class,'sc-fzqyv')]") public List<WebElement> cardlist;
	@FindBy(xpath = "//*[@class='Flex__Box-gYzJRu bdaKbt']/label[2]") public WebElement loyalty_Point_text;
}







//


