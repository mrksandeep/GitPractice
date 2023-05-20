package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.QA.TestApp.Utilities.BaseScript;

public class NCOM_HomePage_Web extends BaseScript {

@FindBy(xpath="//input[@name ='q']") public WebElement searchTextArea;
@FindBy(xpath="//*[@id=\"spa-root\"]/div/div[3]/div[1]/div/div[1]/div[7]/div[1]/div[43]/div[1]/div/div") private WebElement FCEntryFromHomepage;
@FindBy(xpath="//*[text()='Deliver to']/following::span[1]") public WebElement defaultPincode;
@FindBy(xpath="//span[text()='Change']") public WebElement changePincode;
@FindAll({@FindBy(xpath="//*[@class='slick-slider slick-initialized']//following::li")}) public List<WebElement> heroBannerdash;
@FindBy(xpath="//*[@class='slick-slide slick-active slick-current']//img") public WebElement currentBanner;
@FindBy(xpath="//img[@alt='Product']") public List<WebElement> productImages;
@FindBy(xpath="//*[@class='MuiTypography-root MuiTypography-body-m css-zz11w9']") public List<WebElement> productDesc;
@FindBy(xpath="//img[@alt='Cart Icon']") public WebElement cart;
@FindBy(xpath="//img[@alt='Cart Icon']/preceding::div[1]") public WebElement cartItemCount;
//img[@alt='Product']

@FindBy(xpath="//h4[@class='MuiTypography-root MuiTypography-heading-s css-d9ionv']") public List<WebElement> price_web;

@FindBy(xpath="//*[contains(text(),'Sort By')]") public WebElement sortByButton_web;
@FindBy(xpath="//*[contains(text(),'Price (highest first)')]") public WebElement highestFirst_web;
@FindBy(xpath="//*[contains(text(),'Price (lowest first)')]") public WebElement lowestFirst_web;

@FindBy(xpath="//div[@class='MuiBox-root css-1q8ldi9']") public List<WebElement> neuCoins;
@FindBy(xpath="//div[@class='MuiBox-root css-hboir5']") public WebElement backBtn;
@FindBy(xpath="(//div[@class='MuiBox-root css-k008qs'])[1]") public WebElement addressicon;

@FindBy(xpath="(//div[@class='MuiBox-root css-k008qs'])[1]") public WebElement changeIcon;
@FindBy(xpath="//div[@defaultaddress='1']") public WebElement default1;
@FindBy(xpath="//span[@class='MuiTypography-root MuiTypography-body-m css-auxjft']") public List<WebElement> mrp;
@FindBy(xpath="//button[text()='Retry']") public WebElement retry;
@FindBy(xpath="//span[@class='MuiTypography-root MuiTypography-body-m css-171p52c']") public List<WebElement> percentage;
public WebElement getFCEntryFromHomepage() {
	return FCEntryFromHomepage;
}
public void setFCEntryFromHomepage(WebElement fCEntryFromHomepage) {
	FCEntryFromHomepage = fCEntryFromHomepage;
}






}