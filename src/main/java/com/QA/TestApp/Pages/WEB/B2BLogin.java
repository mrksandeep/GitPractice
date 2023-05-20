package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.QA.TestApp.Utilities.BaseScript;

public class B2BLogin extends BaseScript {

	@FindBy(xpath="//*[@name='Username']") public WebElement longinEmailID;
	@FindBy(xpath="//*[@name='Password']") public WebElement password;
	
}
