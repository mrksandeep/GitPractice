package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_LegalPage {
	@FindBy(xpath="//*[contains(@class,'style__PageTitle-hPcZJK hHIFnR') and contains(text(),'Legal')]") public WebElement legalHeader;
	@FindBy(xpath="//*[contains(text(),'NOTICES')]") public WebElement notice;
	@FindBy(xpath="//*[contains(@class,'sc-fzqAui eoGDzK') and contains(text(),'Offers')]") public WebElement offerOpt;
	@FindBy(xpath="//*[contains(@class,'sc-fzqAui eoGDzK') and contains(text(),'Partners')]") public WebElement partnersOpt;
	@FindBy(xpath="//*[contains(@class,'sc-fzqAui eoGDzK') and contains(text(),'Channels')]") public WebElement channelOpt;
	@FindBy(xpath="//*[contains(@class,'sc-fzqAui sc-fzqMdD fZQoNm') and contains(text(),'Payments')]") public WebElement paymentsOpt;
	@FindBy(xpath="//*[@id=\"app\"]/div[2]/p") public WebElement paragraph;
	@FindBy(xpath="//*[@id=\"app\"]/div[2]/p") public WebElement legalopt;
}