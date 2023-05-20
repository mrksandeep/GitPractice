package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_EnterAddressManuallyPage {
	@FindBy(xpath = "//input[@name='customerName']") public WebElement customerName;
	@FindBy(xpath="//input[@name='countryCode']") public WebElement countryCode;
	@FindBy(xpath="//input[@name='mobileNumber']") public WebElement mobileNumber;
	@FindBy(xpath="//input[@name='flatNo']") public WebElement flatNo;
	@FindBy(xpath="//input[@name='landmark']") public WebElement landmark;
	@FindBy(xpath = "//input[@name='address']") public WebElement address;
	@FindBy(xpath="//input[@name='country']") public WebElement country;
	@FindBy(xpath="//input[@name='state']") public WebElement state;
	@FindBy(xpath="//input[@name='city']") public WebElement city;
	@FindBy(xpath="//input[@name='pincode']") public WebElement pincode;
	@FindBy(xpath="//input[@name='tagname']") public WebElement label;
	@FindBy(xpath = "//span[text()='Home']") public WebElement hometag;
	@FindBy(xpath="//span[text()='Work']") public WebElement worktag;
	@FindBy(xpath="//span[text()='Custom']") public WebElement customtag;
	@FindAll({@FindBy(xpath="//label[contains(@class,'sc-pcJja jsQOlJ')]")}) public List<WebElement> addresstags;
	@FindBy(xpath="//*[contains(text(),'*Mandatory Fields')]") public WebElement mandatoryFields;
	@FindBy(xpath="//*[contains(text(),'Save Changes')] | //*[contains(text(),'Save changes')]") public WebElement savechangesBtn;
	@FindAll({@FindBy(xpath="//span[contains(@class,'style__ErrorStyled-ldbNHK fQFPpx')] | //span[contains(@class,'Error')]")}) public List<WebElement> allErrorElementsInProfilePage;
}