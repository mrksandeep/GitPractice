package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_SearchPage {
	@FindBy(xpath = "//*[@*='search']") public WebElement searchHeader;
}