package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_MAChannelsOptionPage {
	@FindAll({@FindBy(xpath="//*[contains(@class,'_3YgZN')]")}) public List<WebElement> channeltypes;
    @FindBy(xpath="//*[contains(text(),'Channels')]") public WebElement channels;
	@FindBy(xpath="//h2[text()='Tata Sky']")public WebElement tataskyoption;
	@FindBy(xpath="//h2[text()='Croma']")public WebElement cromaoption;
	@FindBy(xpath="//h2[text()='Croma']")public WebElement ihcloption;
    @FindBy(xpath="//*[contains(@class,'_2o5tv _1onny')]") public WebElement dotsoption;

}
