package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;

public class TDL_CardProtectionJourneyPage {
	
	//TDL_Homepage-
	
	@FindBy(xpath = "(//*[contains(text(),'Card Fraud Secure Plan ')]//following::*[@*='knowMore-cta'])[1]") public WebElement knowMoreBtn;
	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(),'FS- Card Insurace')]") public WebElement cppWdgt;
	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(),'FS Home Insurance')]") public WebElement hciWdgt;
	@FindBy(xpath = "//*[@id='main-content']/div[2]/div/div[1]/div[1]/child::*/following-sibling::*[1]") public WebElement navigationBtn;
	
	@FindBy(xpath = "//div/span[(text()='Card Fraud Secure Insurance')] | //div/span[(text()='Guard against credit card fraud')] | //*[contains(text(),'Card Fraud Secure Plan')]") public WebElement cppKnowMoredetailsTxt;
	@FindBy(xpath = "//button[contains(text(),'Buy Now')]") public WebElement buyNowBtn;
	@FindBy(xpath = "//div[@class='modal-content']") public WebElement addCardPopup;
	@FindBy(xpath = "//div[@class='modal-content']/div/child::div[3]") public WebElement addcardPopupDetails;
	@FindBy(xpath = "//div[@class='modal-content']//button[contains(text(), 'Add Card')]") public WebElement addCardBtnOnPopup;
	@FindBy(xpath = "//div[@class='modal-content']//button[contains(text(), 'Home Page')]") public WebElement homePageBtnOnPopup;
	@FindBy(xpath = "//*[text()='Proceed']") public WebElement btnProceed;
	
	
	//Basic details Page Elements during CPP Journey
	@FindBy(xpath = "//*[@id='app']//h1") public WebElement pageTitle;
	@FindBy(xpath = "//*[contains(text(),'Title')]/following::div/button") public WebElement cppBasicDetailsTitle;
	@FindBy(xpath = "(//*[contains(text(),'Mr')])[2]") public WebElement mrTitle;
	@FindBy(xpath = "//*[contains(text(),'Mrs')]") public WebElement mrsTitle;
	@FindBy(xpath = "//*[contains(text(),'Ms')]") public WebElement msTitle;
	@FindBy(xpath = "//*[contains(text(),'Dr')]") public WebElement drTitle;
	@FindBy(xpath = "//*[contains(text(),'Prof.')]") public WebElement profTitle;
	@FindBy(xpath = "//input[@name='firstName']") public WebElement cppBasicDetailsFirstName;
	@FindBy(xpath = "//input[@name='middleName']") public WebElement cppBasicDetailsMiddleName;
	@FindBy(xpath = "//input[@name='lastName']") public WebElement cppBasicDetailsLastName;
	@FindBy(xpath = "//*[contains(text(),'Gender')]/following::div/button") public WebElement cppBasicDetailsGender;
	@FindBy(xpath = "(//*[contains(text(),'Male')])[2]") public WebElement maleGender;
	@FindBy(xpath = "//*[contains(text(),'Female')]") public WebElement femaleGender;
	@FindBy(xpath = "//input[@name='dob']") public WebElement cppBasicDetailsDOB;
	@FindBy(xpath = "//input[@name='emailId']") public WebElement cppBasicDetailsEmailId;
	@FindBy(xpath = "//input[@name='mobileNumber']") public WebElement cppBasicDetailsMobile;
	@FindBy(xpath = "//button[contains(text(), 'Continue') or contains(text(), 'Next' )]") public WebElement cppBasicDetailsNextBtn;
	@FindBy(xpath = "//button[contains(text(), 'Continue')]") public WebElement cppBasicDetailContinueBtn;
	@FindBy(xpath = "//div[@*='modal-content']") public WebElement cppBasicDetailsConfrmPage;	
	@FindBy(xpath = "//input[@type='checkbox']") public WebElement cppBasicDetailsTermsChkbox;
	@FindBy(xpath = "//button[contains(text(),'Pay now')]") public WebElement cppBasicDetailsPayNowBtn;
	
	@FindBy(xpath = "//*[@id='app']/div[3]/div[5]/preceding-sibling::div") public WebElement allbasicDetailsFields;
	
	//Purchase Journey pop up Elements during CPP Journey
	@FindBy(xpath = "//button[contains(text(), 'My Plans')]/ancestor::div[2]") public WebElement purchaseJourneyPopup;
	@FindBy(xpath = "//button[contains(text(), 'My Plans')]") public WebElement myPlansBtn;
	
	//Payments page Elements
	@FindBy(xpath = "//*[@id='app']//h1[contains(text(),'Payments')]") public WebElement paymntPg;
	@FindBy(xpath = "//div[@id=\"root\"]//span[contains(text(),'TOTAL AMOUNT')]/parent::div") public WebElement totalAmntDtls;
	@FindBy(xpath = "//*[@id='app']//*[contains(text(),'DEBIT CARD') or contains(text(), 'Credit Card')]") public WebElement cardType;
	@FindBy(xpath = "//input[@id='security_code'] | //input[@placeholder='CVV']") public WebElement enterCVV;
	@FindBy(xpath = "//button[contains(text(), 'Pay')]") public WebElement payBtn;
	@FindBy(xpath = "//*[contains(text(), 'Change')]") public WebElement btnChange;
	//razorpay page Elements
	//page title should match with "Razorpay Bank"
	@FindBy(xpath = "//button[contains(text(),'Success')]") public WebElement successBtn;
	@FindBy(xpath = "//button[contains(text(),'Failure')]") public WebElement failureBtn;
	@FindBy(xpath = "//*[text()='Enter OTP']") public WebElement enterOTPTxt;
	@FindBy(xpath = "//*[contains(text(),'Submit')]/../../input") public WebElement otpField;
	@FindBy(xpath = "//*[contains(text(),'Submit')]") public WebElement submitBtn;
	@FindBy(xpath = "//*[contains(text(),'Payment Complete')]") public WebElement paymentSuccessTxt;
	
	
	//MyPlan Page
	@FindBy(xpath = "//*[contains(text(),'Manage Plans')]") public WebElement myplanBtn;
	@FindBy(xpath = "//*[contains(text(),'My Insurance Plans')]") public WebElement myPlanHeader;
	@FindBy(xpath = "//*[contains(text(),'Card Protection Plan')] | //*[contains(text(),'Card Fraud Secure Plan')]") public WebElement cardProtectionTxt;
	@FindBy(xpath = "//*[contains(text(),'Home Insurance Plan')] | //*[contains(text(),'Home Away Secure Plan')]") public WebElement homeInsuranceTxt;
	@FindBy(xpath = "//*[contains(text(),'View Details')]") public WebElement viewDetailsbtn;
	@FindBy(xpath = "//*[contains(text(),'Protection Plan')]") public WebElement protectionPage;
	@FindBy(xpath = "//*[@id='app']/div[2]/div[2]/div/div[2]/section/section[2]/div[1]/div/div/p") public WebElement emergencyHotelBill;
	@FindBy(xpath = "//*[contains(text(),'Raise A Claim')]") public WebElement raiseClaimbtn;
	@FindBy(xpath = "//*[contains(text(),'Home Away Secure Plan')]/following-sibling::*") public WebElement threeDotHCIbtn;
	@FindBy(xpath = "//*[contains(text(),'Card Protection Plan')]/following-sibling::* | //*[contains(text(),'Card Fraud Secure Plan')]/following-sibling::*") public WebElement threeDotCPPbtn;
	@FindBy(xpath = "//*[contains(text(),'Home Intimation - Raise Claim')]") public WebElement homeIntimationTxt;
	@FindBy(xpath = "//*[@id='claimAmount']") public WebElement fraudAmt;
	@FindBy(xpath = "//*[@id='timeOfFraud']") public WebElement lossTime;
	@FindBy(xpath = "//*[@id='dateOfFraud']") public WebElement fraudDt;
	@FindBy(xpath = "//button[contains(text(),'Continue')]") public WebElement continueBtn;
	@FindBy(xpath = "//*[contains(text(),'Brief note')]") public WebElement briefNoteTxt;
	@FindBy(xpath = "//*[@id='incidentdetails-text-area']") public WebElement briefIncidentTxt;
	@FindBy(xpath = "//*[@id='aboutlossdetails-text-area']") public WebElement lossDetailTxt;
	@FindBy(xpath = "//button[contains(text(),'Next')]") public WebElement nextBtn;
	@FindBy(xpath = "//*[contains(text(),'Check Your Details')]") public WebElement reviewTxt;
	@FindBy(xpath = "//input[@type='checkbox']") public WebElement reviewChkbox;
	@FindBy(xpath = "//*[contains(text(),'Terms & Conditions')]") public WebElement tAndcLink;
	@FindBy(xpath = "//button[contains(text(),'Proceed')]") public WebElement proceedBtn;
	@FindBy(xpath = "//*[contains(text(),'Card Fraud Secure Claim')]") public WebElement cardRaiseClaim;
	@FindBy(xpath = "//*[contains(text(),'SELECT CARD')]/../div[2]//input[@type='radio']") public WebElement cardRadioBtn;
	@FindBy(xpath = "//*[contains(text(),'SELECT CARD')]/../div[1]//input[@type='radio']") public WebElement cardRadio;
	@FindBy(xpath = "//*[contains(text(),'SELECT CARD')]/..//input[@type='radio']") public List<WebElement> radioBtns ;
	@FindBy(xpath = "//*[contains(text(),'Online')]") public WebElement onlineTxt;
	@FindBy(xpath = "//*[contains(text(),'ATM')]") public WebElement aTMTxt;
	@FindBy(xpath = "//*[contains(text(),'POS/Offline')]") public WebElement offlineTxt;
	@FindBy(xpath = "//*[contains(text(),'Location of Fraud')] | //*[contains(text(),'Was it used in India or outside India?')]") public WebElement fraudLocationTxt;
	@FindBy(xpath = "//*[@id='Location of Fraud']/div[2]/div[1]/label/label") public WebElement indiaTxt;
	@FindBy(xpath = "//*[contains(text(),'Outside India')]") public WebElement outsideTxt;
	@FindBy(xpath = "//input[@name='locationAtTimeofFraud']") public WebElement locationTxt;
	@FindBy(xpath = "//*[@id='claim-amount']") public WebElement amountTxt;
	@FindBy(xpath = "//*[@id='timeOfFraud']") public WebElement timeFraudTxt;
	@FindBy(xpath = "//*[@id='dateOfFraud']") public WebElement dateFraudTxt;
	@FindBy(xpath = "//*[@id='Did you have the card at the time of fraud?']/div[1] | //*[@id='Was the card with you when it was used?']/div[1]") public WebElement cardPresent;
	@FindBy(xpath = "//*[@id='Was the card with you when it was used?']/div[2]/div[1]/label/label") public WebElement cardPresentYes;
	@FindBy(xpath = "//*[@id='Was the card with you when it was used?']/div[2]/div[2]/label/label") public WebElement cardPresentNo;
	@FindBy(xpath = "//*[@id='Did you share your card’s PIN or OTP with anyone?']/div[1]") public WebElement pINTxt;
	@FindBy(xpath = "//*[@id='Did you share your card’s PIN or OTP with anyone?']/div[2]/div[1]/label/label") public WebElement pINYes;
	@FindBy(xpath = "//*[@id='Did you share your card’s PIN or OTP with anyone?']/div[2]/div[2]/label/label") public WebElement pINNo;
	@FindBy(xpath = "//*[@id='Have you intimated to the bank?']/div[1]") public WebElement intimatedBankTxt;
	@FindBy(xpath = "//*[@id='Have you reported the fraud to police?']/div[1]") public WebElement reportedFraudTxt;
	@FindBy(xpath = "//*[@id='Have you intimated to the bank?']/div[2]/div[1]/label/label") public WebElement bankYes;
	@FindBy(xpath = "//*[@id='Have you intimated to the bank?']/div[2]/div[2]/label/label") public WebElement bankNo;
	@FindBy(xpath = "//*[@id='Have you reported the fraud to police?']/div[2]/div[1]/label/label") public WebElement policeYes;
	@FindBy(xpath = "//*[@id='Have you reported the fraud to police?']/div[2]/div[2]/label/label") public WebElement policeNo;
	@FindBy(xpath = "//*[contains(text(),'Details of merchant/ Narration & location')]/following-sibling::*") public WebElement merchantDetails;
	@FindBy(xpath = "//input[@name='otherDetails']") public WebElement otherDetails;
	@FindBy(xpath = "//*[contains(text(),'Card & type of transaction')]/ancestor::*[3]") public List<WebElement> reviewDetails;
	@FindBy(xpath = "//*[contains(text(),'Select City')]/../../following-sibling::*/input") public WebElement enterCity;
	@FindBy(xpath = "//*[contains(text(),'Select City')]/../../following-sibling::*[2]") public WebElement selectcity;
	@FindBy(xpath = "//*[contains(text(),'Purchase Journey')]") public WebElement purchase;
	@FindBy(xpath = "//*[contains(text(),'successfully raised')]") public WebElement successText;
	
	//Track Claim
	@FindBy(xpath = "//*[contains(text(),'Track My Request')]/../../following-sibling::*/section/section[2]/div/div") public  List<WebElement> trackStatusItems;
	@FindBy(xpath = "//*[contains(text(),'Track Claim')] | //*[contains(text(),'Track My Requests')]") public WebElement trackClaim;
	@FindBy(xpath = "//*[contains(text(),'Claim Initiated')]") public List<WebElement> claimInitiated;
	@FindBy(xpath = "//*[contains(text(),'CLAIM_SUBMITTED')]") public WebElement claimSubmited;
	@FindBy(xpath = "//*[contains(text(),'Date & Time of Fraud')]") public WebElement dateTimeFraud;
	@FindBy(xpath = "//*[contains(text(),'Date & Time of Fraud')]/following-sibling::*") public WebElement fraudtimeTxt;
	@FindBy(xpath = "//*[contains(text(),'Claim Successfully recorded')]") public WebElement claimRecorded;
	@FindBy(xpath = "//*[contains(text(),'Claim Successfully recorded')]/following-sibling::*") public WebElement claimRecordedDate;
	@FindBy(xpath = "//*[contains(text(),'Submit Documents')]") public WebElement submitDoc;
	@FindBy(xpath = "//*[contains(text(),'Upload')]") public WebElement uploaddoc;
	@FindBy(xpath = "//*[contains(text(),'Claim Closed')]") public WebElement claimStatus;
	@FindBy(xpath = "//*[contains(text(),'Claim Initiated')]/../../../following-sibling::*") public List<WebElement> initiatedarrowbtn;
	@FindBy(xpath = "//*[contains(text(),'CLAIM_SUBMITTED')]/../../../following-sibling::*") public WebElement submitteddarrowbtn;
	@FindBy(xpath = "//*[contains(text(),'Document Submitted')]") public WebElement docSubmitted;
	@FindBy(xpath = "//*[contains(text(),'CLAIM_INITIATED')]/../../div/div[2]/div[2] | //*[contains(text(),'CLAIM_SUBMITTED')]/../../div/div[2]/div[2]") public WebElement cardClaim;
	@FindBy(xpath = "//*[contains(text(),'CLAIM_SUBMITTED')]/../../div/div[2]/div[2]") public WebElement cardNO_Submitted;

	//Cancel policy
	@FindBy(xpath = "//button[contains(text(),'Cancel')]") public WebElement cancelbtn;
	@FindBy(xpath = "//button[contains(text(),'Yes')]") public WebElement yesbtn;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]") public WebElement cancelConfirmbtn;
	
	@FindBy(xpath = "//button[contains(text(),'No')]") public WebElement nobtn;
	@FindBy(xpath = "//*[contains(text(),'Cancel My Card Fraud Secure Plan')]") public WebElement cancel_popup;
	@FindBy(xpath = "//*[contains(text(),'Are you sure')]") public WebElement confirmtxt;
	@FindBy(xpath = "//*[contains(text(),'It was too expensive')]") public WebElement cancelstmnt;
	@FindBy(xpath = "//input[@value='It was too expensive']") public WebElement cancelreason_radiobtn;
	@FindBy(xpath = "//button[contains(text(),'Submit')]") public WebElement cancelSubmitbtn;
	@FindBy(xpath = "//*[contains(text(),'We are sorry to see you go.')]") public WebElement cancelProgress;
	@FindBy(xpath = "//button[contains(text(),'Ok')]") public WebElement donebtn;
	@FindBy(xpath = "//*[contains(text(),'Card Fraud Secure Plan')]/../following-sibling::*") public WebElement cancelStatus;

	//Order History page
	@FindBy(xpath = "//h1[contains(text(),'My Orders')]") public WebElement myOrderHeader;
	@FindBy(xpath = "//*[contains(text(),'Order History')] | //*[contains(text(),'Order history')]") public WebElement orderHistoryBtn;
	@FindBy(xpath = "//*[contains(text(),'Description')]") public WebElement orderDescription;
	@FindBy(xpath = "//*[contains(text(),'Success')] | //span[contains(text(),'FS-Insurance')]/../following-sibling::div/span[2]") public List<WebElement> SuccessStatus;
	@FindBy(xpath = "//*[contains(text(),'Policy certificate number')]/following-sibling::*") public WebElement policyCertificateNo;
	@FindBy(xpath = "//*[@id='app']/div[1]/div/div/span") public WebElement backArrow;
	@FindBy(xpath = "//*[contains(text(),'My Insurance Plans')]") public WebElement myInsurancePlanLink;
	@FindBy(xpath = "//p[contains(text(),'Know more')] | //*[contains(text(),'Know more')]") public WebElement btnFinace;
	@FindBy(xpath = "(//*[contains(text(),'Insurance')])[1]") public WebElement btnInsurance;
	
	
}

