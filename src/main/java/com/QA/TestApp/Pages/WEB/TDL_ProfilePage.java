package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;

public class TDL_ProfilePage {
	@FindBy(xpath = "//*[contains(@class,'style__PageTitle-hPcZJK hHIFnR') and contains(text(),'Profile')]") public WebElement profileHeader;
	@FindBy(xpath="//*[contains(text(),'BASIC DETAILS')]") public WebElement basicdetails;
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/form/div[1]/div/div[2]/div/div/div") public WebElement profilepic;
	@FindBy(xpath="//*[contains(text(),'Open Camera')]") public WebElement openCamera;
	@FindBy(xpath="//*[contains(text(),'Upload Photo')]") public WebElement uploadPhoto;
	@FindBy(xpath="//button[@aria-labelledby='select-box-label']") public WebElement selectTitle;
	@FindBy(xpath="//*[text()='Mr']") public WebElement select_mr;
	@FindBy(xpath="//*[text()='Mrs']") public WebElement select_mrs;
	@FindBy(xpath="//*[text()='Miss']") public WebElement select_miss;
	@FindBy(xpath="//*[text()='Dr']") public WebElement select_Dr;
	@FindBy(xpath="//*[text()='Ms']") public WebElement select_ms;
	@FindBy(xpath="//*[text()='Prof.']") public WebElement select_prof;
	@FindBy(xpath="//input[@name='firstName']") public WebElement firstName;
	@FindBy(xpath="//input[@name='middleName']") public WebElement middleName;	
	@FindBy(xpath = "//input[@name='lastName']") public WebElement lastName;
	@FindBy(xpath="//input[@name='anniversaryDate']") public WebElement anniversaryDate;
	@FindBy(xpath="//input[@name='phone']") public WebElement phone;
	@FindBy(xpath="//input[@name='email']") public WebElement email;
	@FindBy(xpath="//*[contains(text(),'Save Changes')]") public WebElement saveChangesBtn;
	@FindBy(xpath="//*[contains(text(),'*Mandatory Fields')]") public WebElement mandatoryFields;
	@FindBy(xpath="/html/body/div/div/div/div[2]/form/div[2]/div/div[7]/div[2]/button") public WebElement select_maritalStatus;
	@FindBy(xpath = "//input[@name='dob']") public WebElement dob;
	@FindBy(xpath="/html/body/div/div/div/div[2]/form/div[2]/div/div[5]/div[2]/button") public WebElement select_gender;
	@FindAll({@FindBy(xpath="//span[contains(@class,'style__ErrorStyled-ldbNHK fQFPpx')]")}) public List<WebElement> allErrorElementsInProfilePage;
	@FindAll({@FindBy(xpath="//button[@aria-labelledby='select-box-label']")}) public List<WebElement> profileDropDown;
	@FindBy(xpath="//*[text()='Year']") public WebElement datepickerYearTab;
	@FindBy(id="date-left-icon") public WebElement previousYearPageBtn;
	@FindBy(xpath="//*[contains(@class,'style__Label-hJrwMT gnCDrj')]") public WebElement fullDateDatePickerModal;
	@FindBy(xpath="//*[text()='Month']") public WebElement datepickerMonthTab;
	@FindBy(xpath="//*[text()='Date']") public WebElement datepickerDateTab;
	@FindAll({@FindBy(xpath="//*[contains(@class,'styles__SwipeView-dzOlkT jRgdFB')]")}) public List<WebElement> monthList;
	@FindAll({@FindBy(xpath="//*[contains(@class,'style__DateSpan-kBqtwZ eeBjRS value undefined')]")}) public List<WebElement> dayList;
	@FindBy(xpath="//*[contains(@id,'2012')]/span") public WebElement firstyeartab;
	@FindAll({@FindBy(xpath="//div[contains(@aria-label,'year ')]")}) public List<WebElement> yearList;
	@FindBy(xpath="//*[text()='Title']/parent::div/following-sibling::div//span") public WebElement salutationValue;
}
