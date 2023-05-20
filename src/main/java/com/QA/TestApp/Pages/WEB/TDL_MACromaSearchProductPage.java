package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_MACromaSearchProductPage {
	
	@FindBy(xpath = "//a[@class='logo']") public WebElement cromaheader;
    @FindBy(xpath = "//*[@id='search']") public WebElement searchproduct;
	@FindBy(xpath = "//*[contains(text(),'Delivering To')]") public WebElement deliverypincode;
	@FindBy(xpath = "//*[contains(@type,'text') and contains(@name,'number')]") public WebElement enterpincode;
	@FindBy(xpath = "//*[contains(text(),'APPLY')]") public WebElement applybtn;
    @FindBy(xpath = "//*[contains(text(),'buy now')]") public WebElement buynowbtn;
    @FindBy(xpath = "//div[text()='Payment Detail']") public WebElement paymentdetailheader;
	@FindBy(xpath = "//*[contains(text(),'CHECKOUT') and contains(@type,'button')]") public WebElement checkout;
	@FindBy(xpath = "//*[contains(text(),'CHANGE ADDRESS') and contain	s(@type,'button')]") public WebElement changeaddress;
	@FindBy(xpath = "//*[contains(text(),'ADD ADDRESS') and contains(@type,'button')]") public WebElement addaddress;
	@FindBy(name = "shipFName") public WebElement firstname;
	@FindBy(name = "shipLName") public WebElement lastname;
	@FindBy(name = "shipAddLine1") public WebElement flatno;
	@FindBy(id = "state_id") public WebElement state;
	@FindBy(name = "city_id") public WebElement cityid;
	@FindBy(xpath = "//*[contains(text(),'select payment')]") public WebElement selectpayment;
	@FindBy(name = "shipAddLine2") public WebElement landmark;

	
}
