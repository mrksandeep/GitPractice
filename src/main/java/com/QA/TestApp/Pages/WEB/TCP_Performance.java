package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;

public class TCP_Performance {

	
	
	@FindBy(xpath = "//button[@class='lego-control md-button md-data-studio-theme md-ink-ripple']")
	public WebElement date_dropdown;
	
	@FindBy(xpath = "//md-select-value[contains(@id,'select_value_label_')]")
	public WebElement monthToDate_Dropdown;
		
	@FindBy(xpath = "//div[contains(text(),'Today')]//parent::md-option")
	public WebElement today_option;
	
	@FindBy(xpath = "//button[contains(text(),'APPLY')]")
	public WebElement apply_Button;
	
	@FindBy(xpath = "//div[@title='Date']")
	public WebElement dateCol_Table;
	
	@FindBy(xpath = "(//button[@role='menuitem'])[3]")
	public WebElement export_Button;
	
	@FindBy(xpath = "//input[contains(@id,'mat-input-')]")
	public WebElement fileName_Textbox;
	
	@FindBy(xpath = "(//span[@class='mat-radio-inner-circle'])[2]")
	public WebElement csvExcel_Option;
	
	@FindBy(xpath = "//button/span[contains(text(),'Export')]")
	public WebElement download_Button;
	
	@FindBy(xpath = "//span[@class='mat-mdc-button-touch-target']")
	public WebElement left_Arrow;
	
	
	
}