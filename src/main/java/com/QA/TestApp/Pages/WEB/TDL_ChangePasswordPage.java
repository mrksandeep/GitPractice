package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_ChangePasswordPage {
	@FindBy(xpath="//*[contains(text(),'Change Password')]") public WebElement changePasswordHeader;
	@FindBy(xpath="//input[@name='oldPassword']") public WebElement oldPassword;
	@FindBy(xpath="//input[@name='newPassword']") public WebElement newPassword;
	@FindBy(xpath="//input[@name='confirmNewPassword'] | //input[@name='confirmPassword']") public WebElement confirmNewPassword;
	@FindBy(xpath="//*[contains(text(),'Update Password')]") public WebElement updatePassword;
	@FindBy(xpath="//*[contains(text(),'Invalid input')]") public WebElement invalidInputErrorMsg;
	@FindBy(xpath="//*[contains(text(),'New password cannot be the same as Old password')]") public WebElement newPasswordErrorMsg;
	@FindBy(xpath="//*[contains(text(),'New password does not match with the confirm new password')]") public WebElement confirmNewPasswordErrorMsg;
//	@FindBy(xpath="//span[contains(@class,'style__ErrorStyled-ldbNHK fQFPpx')]") public WebElement allErrorElementsInProfilePage;
	@FindBy(xpath="//span[contains(@class,'style__BackIcon')]") public WebElement backbutton;
	@FindAll({@FindBy(xpath="//span[contains(@class,'style__ErrorStyled-ldbNHK fQFPpx')]")}) public List<WebElement> allErrorElementsInProfilePage;

}

