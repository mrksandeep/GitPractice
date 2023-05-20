package com.QA.TestApp.Pages.WEB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.QA.TestApp.Utilities.BaseScript;

public class B2BPage2 extends BaseScript {

@FindBy(xpath="//input[@name ='q']") public WebElement searchTextArea;
@FindBy(xpath=" //*[@id='travelCreateQuoteId']") public WebElement travelCreateQuoteId;
@FindBy(xpath=" //*[@id='typeOfBusinessCASH']") public WebElement typeOfBusinessCASH;
@FindBy(xpath=" //*[@id='totalFigureLbl']//label") public WebElement TotalPremium;
@FindBy(xpath=" //*[@id='incptDt']") public WebElement incptDt;
@FindBy(xpath=" //*[@id='NextBtn']") public WebElement NextBtn;
@FindBy(xpath=" //*[@id='searchBtn']") public WebElement searchBtn;
//*[@name='VATRegistered']//option[text()='No']

//check push

@FindBy(xpath=" //*[@id='SaveRecalBtn']") public WebElement SaveAndCalcBtn;
@FindBy(xpath="//*[@id='savedetails']") public WebElement SaveBtn;
@FindBy(xpath=" //*[@id='next']") public WebElement Next;
@FindBy(xpath=" //*[@id='lnkApprApplication']") public WebElement ProceedBtn;
@FindBy(xpath=" //*[@id='quoteStatusLbl']") public WebElement quoteStatus;
@FindBy(xpath=" //*[@id='QtNumberLbl']") public WebElement quoteNumber;
//*[text()='Tax']/following-sibling::td[2]
@FindBy(xpath="//*[text()='Tax']/following-sibling::td[2]") public WebElement Tax;
@FindBy(xpath="//*[text()='Total']/following-sibling::td[2]") public WebElement Total;
@FindBy(xpath="//a[text()='Status']//parent::th/../../following-sibling::tbody") public WebElement Table;
//a[text()='Status']//parent::th/../../following-sibling::tbody/tr[2]/td[5]
//------------------------------
@FindBy(xpath="//*[@id='labeldataGeographical']") public WebElement Geographical;
@FindBy(xpath="//*[@id='labeldataInseptionDate']") public WebElement dataInseptionDate;
@FindBy(xpath="//*[@id='labeldataLengthOfCover']") public WebElement labeldataLengthOfCover;
@FindBy(xpath="//*[@id='labeldataExpires']") public WebElement labeldataExpires;
@FindBy(xpath="//*[@id='titleLblData']") public WebElement title;
@FindBy(xpath="//*[@id='firstNameLblData']") public WebElement firstName;
@FindBy(xpath="//*[@id='genderLblData']") public WebElement gender;
@FindBy(xpath="//*[@id='nationalityLblData']") public WebElement nationality;
@FindBy(xpath="//*[@id='DateOfBrth5LblData']") public WebElement dob;
@FindBy(xpath="//*[@id='countryResDiv']") public WebElement Residence;
@FindBy(xpath="//*[@id='VATreg']") public WebElement VATreg;
@FindBy(xpath="//*[@id='idtypeDiv']//span//label") public WebElement idtype;
@FindBy(xpath="//*[@id='passIdLblData']") public WebElement idnum;
@FindBy(xpath=" //*[@id='passExpireLblData']") public WebElement idexp;
@FindBy(xpath="//*[@id='address1Div']//span//label") public WebElement address1;
@FindBy(xpath="//*[@id='poBoxLblData']") public WebElement poBox;
@FindBy(xpath=" //*[@id='emirateLblData']") public WebElement emirate;
@FindBy(xpath="//*[@id='cityLblData']") public WebElement city;
@FindBy(xpath="//*[@id='emailLblData']") public WebElement email;
@FindBy(xpath="//*[@id='mobileLblData']") public WebElement mobile;
@FindBy(xpath="//*[@id='countryLblData']") public WebElement country;
//28-08-2019
@FindBy(xpath="//*[text()='Travel Easy Annual Multi Trip Individual']")public static WebElement TravelEasy;
//29-08-2019
@FindBy(xpath="//*[@id='lifeCreateQuoteId']")public static WebElement PersonalAccidentCreate;
@FindBy(xpath="//*[@id='agcc-yes']")public static WebElement agccyes;
@FindBy(xpath="//*[@id='dob']")public static WebElement dobPersonal;
@FindBy(xpath="//*[text()='Life Easy Gold Plan']")public static WebElement LifeEasyGoldPlanPackage;
@FindBy(xpath="//*[@id='inception']")public static WebElement inceptionDatePersonalacc;
@FindBy(xpath="//*[text()='NEXT']//parent::a")public static WebElement nextbtn;
@FindBy(xpath="//*[text()='SAVE']//parent::a")public static WebElement savebtn;
@FindBy(xpath="//*[text()='SAVE & CALCULATE']//parent::a")public static WebElement SAVECALCULATE;
@FindBy(xpath="//*[@id='quoteNumLbl']")public static WebElement QuoteNumberPersonalAccident;
@FindBy(xpath="//*[@id='expiryDateLbl']")public static WebElement expiryDatePersonalAccident;
@FindBy(xpath="(//label[text()='Passive War and Terrorism'])[2]/../../strong/div/span")public static WebElement CheckBoxOptional;
//-----------------
@FindBy(xpath="//*[@id='priBeneficiaryTitle']")public static WebElement BeneficiaryTitle;
@FindBy(xpath="//*[@id='priBenFirstNameTextfield']")public static WebElement BenFirstNameTextfield;
@FindBy(xpath="//*[@id='priBenLastNameTextfield']")public static WebElement BenLastNameTextfield;
@FindBy(xpath="//*[@id='priBeneficiaryGender']")public static WebElement BeneficiaryGender;
@FindBy(xpath="//*[@id='priBeneficiaryNationality']")public static WebElement BeneficiaryNationality;
@FindBy(xpath="//*[@id='priBeneficiaryType']")public static WebElement BeneficiaryType;
@FindBy(xpath="//*[@id='priBenefitPercentage']")public static WebElement BenefitPercentage;
@FindBy(xpath="//*[@id='benefiRelation']")public static WebElement benefiRelation;
@FindBy(xpath="//*[@id='addBeneficiary']")public static WebElement addBeneficiary;
@FindBy(xpath="//*[@id='passExpiry']")public static WebElement IdExpiryDate;
@FindBy(xpath="//*[@id='passNumber']")public static WebElement IdNumber;
@FindBy(xpath="//*[@id='poBox']")public static WebElement poBox1;
@FindBy(xpath="//*[@id='address1']")public static WebElement address11;
@FindBy(xpath="//*[@id='country']")public static WebElement countryy;
//-------------------------------------------
@FindBy(xpath="//*[@id='policytype']//parent::label")public static WebElement policytypeDisplayed;
@FindBy(xpath="//*[@for='inceptiondate']//following-sibling::label[1]")public static WebElement inceptiondateDisplayed;
@FindBy(xpath="//*[@for='expirydate']//following-sibling::label[1]")public static WebElement expirydateDisplayed;
@FindBy(xpath="//*[@for='residentofagcc']/following-sibling::label[1]")public static WebElement agccDisplayed;
@FindBy(xpath="//*[@id='titleTextDiv']//span//label")public static WebElement titleDisplayed;
@FindBy(xpath="//*[@id='firstNameTextDiv']//span//label")public static WebElement firstNameDisplayed;
@FindBy(xpath="//*[@id='lastNameTextDiv']//span//label")public static WebElement lastNameDisplayed;
@FindBy(xpath=" //*[@id='genderTextDiv']//span//label")public static WebElement genderDisplayed;
@FindBy(xpath="//*[@id='natinalityTextDiv']//span//label")public static WebElement nationalityDisplayed;
@FindBy(xpath="//*[@id='dateOfBirthDiv']//span//label")public static WebElement dobDisplayed;
@FindBy(xpath="//*[@id='countryResDiv']//span//label")public static WebElement ResidenceDisplayed ;
@FindBy(xpath="//*[@id='VATreg']")public static WebElement VATregDisplayed;
@FindBy(xpath="//*[@id='VATregN']")public static WebElement VATregNDisplayed;
@FindBy(xpath="//*[@id='idtypeDiv']//span//label[1]")public static WebElement idTypeDisplayed;
@FindBy(xpath="//*[@id='passportIdTextDiv']//span//label[1]")public static WebElement idNumberDisplayed;
@FindBy(xpath="//*[@id='passportExpTextDiv']//span//label[1]")public static WebElement idExpiryDisplayed;
@FindBy(xpath="//*[@id='address1Div']//span//label[1]")public static WebElement addressDisplayed;
@FindBy(xpath="//*[@id='poBoxTextDiv']//span//label[1]")public static WebElement poBoxDisplayed;
@FindBy(xpath=" //*[@id='countryTextDiv']//span//label[1]")public static WebElement countryDisplayed;
@FindBy(xpath="//*[@id='emirateTextDiv']")public static WebElement emirateDisplayed;
@FindBy(xpath="//*[@id='cityTextDiv']//span//label[1]")public static WebElement cityDisplayed;
@FindBy(xpath="//*[@id='mobileTextDiv']//span//label[1]")public static WebElement mobileDisplayed;
@FindBy(xpath="//*[@id='mailTextDiv']//span//label[1]")public static WebElement emailDisplayed;
@FindBy(xpath="//*[@id='proposalAuto']")public static WebElement quotenoFieldBancs;
@FindBy(xpath="//*[@id='table-SEC-RKLST']//tbody//tr[2]//td[2]//a")public static WebElement riskDetailsSerial;
@FindBy(xpath="SEC-RSKPRP1Insured NameNew")public static WebElement insuredName;
@FindBy(xpath="SEC-RSKPRP1Leading Cover")public static WebElement LeadingCover;
@FindBy(xpath="//*[text()='Risk Details']")public static WebElement RiskDetaisTab;
@FindBy(xpath="//*[@id='pcFlag']")public static WebElement PrivilageClubMotor;
@FindBy(xpath="//*[@id='indvlLblcompany']")public static WebElement VehicleOwnerShipCompany;
@FindBy(xpath="//*[@id='customerId']")public static WebElement customerId;
@FindBy(xpath="//*[@id='business']")public static WebElement businessName;
@FindBy(xpath="//*[@id='landCodeText']")public static WebElement landCodeText;
@FindBy(xpath="//*[@id='landline']")public static WebElement landline;
@FindBy(xpath="//*[@id='referReasonErrorMsg']//br")public static WebElement referReasonErrorMsg;
@FindBy(xpath="//*[@id='referReasonErrorOK']")public static WebElement referReasonErrorOK;
@FindBy(xpath="//*[@id='quoteNumberLbl']")public static WebElement quoteNumberMotor;
//td[text()='Sub-Status:']//following-sibling::td[1]
@FindBy(xpath="//td[text()='Sub-Status:']//following-sibling::td[1]")public static WebElement bancsSubStatus;
@FindBy(xpath="//*[@id='idDocumentExpTextfield']")public static WebElement idDocumentExp;
@FindBy(xpath="//*[@id='employeeNum']")public static WebElement NumberOfEmployee;
@FindBy(xpath="//*[@id='indType']")public static WebElement TypeOfOrganisation;
@FindBy(xpath="//*[@id='countryOfResidence']")public static WebElement countryOfResidence;
@FindBy(xpath="//*[@id='authorizedSignatoryTextfield']")public static WebElement authorizedSignator;
@FindBy(xpath="//*[@id='authorisedSignatoryIDScanAttachment']")public static WebElement authorisedSignatoryIDScan;
@FindBy(xpath="//*[@id='country']")public static WebElement countrye;
@FindBy(xpath="//*[@id='businessType']")public static WebElement businessType;
@FindBy(xpath="//*[@id='modifiedOrNonGCC']")public static WebElement modifiedOrNonGCC;
@FindBy(xpath="//*[@id='empDiscount']")public static WebElement empDiscount;
}