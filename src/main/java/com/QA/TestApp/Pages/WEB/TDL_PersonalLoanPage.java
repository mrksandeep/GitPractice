package com.QA.TestApp.Pages.WEB;
import com.QA.TestApp.Utilities.BaseScript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_PersonalLoanPage extends BaseScript {
	
	@FindBy(xpath = "//*[@data-event='PL : Product detail : Next']")public WebElement personalLoanActivateButton;
	@FindBy(xpath = "//*[@id='panCard']")public WebElement personalLoanDetailsPANCard;
	@FindBy(xpath = "//*[@id='select-button']")public WebElement personalLoanDetailsGender;
	@FindBy(xpath = "//*[@aria-label='select Male']")public WebElement personalLoanDetailsGenderMale;
	@FindBy(xpath = "//*[@aria-label='select Female']")public WebElement personalLoanDetailsGenderFemale;
	@FindBy(xpath = "//*[@aria-label='select Others']")public WebElement personalLoanDetailsGenderOthers;
	@FindBy(xpath = "//*[@id='name']")public WebElement personalLoanDetailsFullName;
	@FindBy(xpath = "//*[@id='dob']")public WebElement personalLoanDetailsDOB;
	
	//*[contains(text(),'Year')]/parent::button/following::section[2]/div/div

}
