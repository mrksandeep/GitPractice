package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_FSDocUploadPage {
	
		@FindBy(xpath = "(//*[contains(text(),'Upload documents')])[2] | //*[contains(text(),'UPLOAD DOCUMENTS')]") public WebElement uploadDocTxt;
		@FindBy(xpath = "//input[@type='file']") public List<WebElement> uploadBtns;
		@FindBy(xpath = "//button[contains(text(),'Submit Claim')]") public WebElement submitClaimbtn;
		@FindBy(xpath = "//button[contains(text(),'Track Claim')]") public WebElement trackClaimbtn;
		@FindBy(xpath = "//input[@name='FIR copy'][@type='file']/../label") public WebElement firUploadBtn;
		@FindBy(xpath = "//input[@name='Bank Statement For Loss Of Cash'][@type='file']") public WebElement bankStmntUploadBtn;
		@FindBy(xpath = "//input[@name='Self Survey Photos'][@type='file']") public WebElement photographCardUploadBtn;
		@FindBy(xpath = "//input[@name='Cancelled Cheque'][@type='file']") public WebElement cancelChequeUploadBtn;
		@FindBy(xpath = "//input[@name='CLAIM SETTLEMENT FROM BANK'][@type='file']") public WebElement claimSettlmntUploadBtn;
		@FindBy(xpath = "//input[@name='DISPUTE LETTER'][@type='file']") public WebElement disputeLetterUploadBtn;
		@FindBy(xpath = "//input[@name='Pan Card'][@type='file']") public WebElement panCardUploadBtn;

}
