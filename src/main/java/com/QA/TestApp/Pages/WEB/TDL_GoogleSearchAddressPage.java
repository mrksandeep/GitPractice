package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_GoogleSearchAddressPage {
	@FindBy(xpath = "//input[@name='customerName']") public WebElement customerName;
	@FindBy(xpath="//input[@name='countryCode']") public WebElement countryCode;
	@FindBy(xpath="//input[@name='mobileNumber']") public WebElement mobileNumber;
	@FindBy(xpath="//input[@name='flatNo']") public WebElement flatNo;
	@FindBy(xpath="//input[@name='landmark']") public WebElement landmark;
	@FindBy(xpath = "//input[@value='Home']") public WebElement hometag;
	@FindBy(xpath="//input[@value='Work']") public WebElement worktag;
	@FindBy(xpath="//input[@value='Custom']") public WebElement customtag;
	@FindBy(xpath="//input[@name='tagname']") public WebElement label;
	@FindBy(xpath="//*[contains(text(),'*Mandatory Fields')]") public WebElement mandatoryFields;
	@FindBy(xpath="//*[contains(text(),'Save Changes')]") public WebElement savechangesBtn;
}
