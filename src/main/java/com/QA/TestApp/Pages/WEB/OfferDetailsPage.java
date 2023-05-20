package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import com.QA.TestApp.Utilities.BaseScript;

public class OfferDetailsPage extends BaseScript {
	



/*Hero Banner CTA */









/*************** ODP*********/
@FindBy (xpath = "//section[contains(text(),'No stores found')]")
public WebElement nostoreText;

@FindBy (xpath = "//*[contains(text(),'Expiring on')]/preceding::label[2]")
public WebElement offerTitlebrand;

@FindBy (xpath = "//*[contains(text(),'Expiring')]/preceding::label[1]")
public WebElement offerTitle;

//@FindBy (xpath ="//section[@class='sc-fzozJi dteCCc']")
//public WebElement offerexpDate;
@FindBy (xpath ="//*[contains(text(),'Expiring')]")
public WebElement offerexpDate;

@FindBy (xpath = "//*[contains(text(),'Stores') ]  |  //*[contains(text(),'Stores and Online') ]  |  //*[contains(text(),'APP Only') ] | //*[contains(text(),'Online & Stores') ] | //*[contains(text(),'line')]")
public WebElement offerChannel;

@FindBy (xpath ="//*[contains(text(),'Expiring')]/following::section[3]")
public WebElement offerShortDescription;

@FindBy (xpath ="//*[name()='path' and contains(@d,'M-4-2h24v2')]")
public WebElement locationIconForStoresNearMe;

@FindBy (xpath ="//div[@data-testid='viewstores']")
public WebElement  viewbtnStoreNearMeonODP;

@FindBy (xpath = "//div[@class='Flex__Box-kdyZDI beBEsA sc-fznWqX dAkvW']//section[(@class='sc-fzozJi dteCCc')]")
public WebElement storesNearMeAddressDetails;

@FindBy (xpath = "//section[@class='sc-fzplWN hRBsWH']")
public WebElement howToAvailOffer;

@FindBy (xpath ="//*[contains(text(),'Terms & Conditions')]/../following-sibling::section")
public WebElement termsConditions;


@FindBy(xpath = "//button[@data-testid='shopnow']")
public WebElement shopNow;

@FindBy(xpath="//button[@data-testid='addtovault']")
public WebElement addtoVault;
@FindBy(xpath="//*[contains(text(),'Added')]")
public WebElement PromotionSavedSuccessfully; 
@FindBy(xpath="(//*[@src='/etc.clientlibs/tcp-pwa/clientlibs/clientlib-react/resources/assets/bookmarkfilled.svg'])[3]")
public WebElement PromotionSavedTickMark;
@FindBy(xpath="//*[contains(text(),'Saved')]")
public WebElement PromotionSavedText;

@FindBy(xpath = "//button[@type='primary']")
public WebElement addedtoVault;


@FindBy (xpath = "//*[@id='modal-close-button']")
public WebElement closeODP;
// "//*[name()='path' and contains(@d,'M.5 15.5L1')] | //*[@*='button']")

@FindBy (xpath = "//div[contains(@class,'Flex__Box-kdyZDI beBEsA sc-AxheI eXzlnr')]//section//*[local-name()='svg'][1]")
public WebElement shareIconVisiblity;

}
