package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.QA.TestApp.Utilities.BaseScript;

public class TDL_SLPCultFit extends BaseScript {
	@FindBy(xpath="//img[@alt='user_profile_picture']") public WebElement profileicon;
	@FindBy(xpath="//*[contains(text(),'Fitness')]") public WebElement fitnessSlp;
	@FindBy(xpath="//label[contains(text(),'Offers')]") public WebElement offers;
	@FindBy(xpath="//label[contains(text(),'Fitness')]") public WebElement offerzonefitnesstile;
	@FindBy(xpath="//label[contains(text(),'NeuPass')]") public WebElement neupass;
	@FindBy(xpath="//h4[contains(text(),'cult.fit')]") public WebElement cultunderneupass;
	@FindBy(xpath="//*[contains(@id,'expanded-partner-points-contact-us')]") public WebElement shopnowbadge;
	@FindBy(xpath="//*[contains(@alt,'location_pin')]") public WebElement locationicon;
	@FindBy(xpath="//*[@id='hamberger-icon']") public WebElement hambergericon;
	@FindBy(xpath="//label[contains(text(),'My orders')]") public WebElement Myorders;
	@FindBy(xpath="//*[contains(text(),'Fitness')]") public WebElement fitnessunderMyorders;
	@FindBy(xpath="//span[contains(text(),'View all')]") public WebElement viewallunderneupass;
	@FindBy(xpath="//img[@alt='offer-img']") public WebElement offercard;
	@FindBy(xpath="//p[contains(text(),'Grocery')]") public WebElement fitnessIcon;
	@FindBy(xpath="//h4[contains(text(),'Westside')]") public WebElement westsideunderneupass;
	@FindBy(xpath="//span[contains(text(),'Shop now')][1]") public WebElement cultunderoffer;	
	@FindBy(xpath="//h3[text()='cultpass membership']") public WebElement cultPassMembership;
	@FindBy(xpath="(//a[text()='BUY NOW'])[1]") public WebElement eliteBuyNow;
	@FindBy(xpath="//div[text()='BUY NOW']/..") public WebElement finalBuy;
	@FindBy(xpath="(//a[text()='SELECT CENTER'])[1]") public WebElement selectCenter;
	@FindBy(xpath="//input[@type='tel']") public WebElement debitCVV;
	@FindBy(xpath="//button[@type='light' and @width='auto']") public WebElement payButton;
	@FindBy(xpath="//span[text()='Awesome! Payment Complete']") public WebElement paymentSuccess;
	@FindBy(xpath="//h5[contains(text(),'CULTSPORT')]") public WebElement Onthesports;
	@FindBy(xpath="//div[contains(text(),'Add to Cart')]") public WebElement Addtocart;
	@FindBy(xpath="//div[contains(text(),'View Cart (1)')]") public WebElement cart;
	@FindBy(xpath="//div[contains(text(),'BUY NOW')]") public WebElement buynow;
	@FindBy(xpath="//button[contains(text(),'Select Address')]") public WebElement Address;
	@FindBy(xpath="(//*[@class='checkout-address-icon'])[2]") public WebElement ChooseAddress;
	@FindBy(xpath="(//*[@class='checkout-button-container']") public WebElement paytatapay;
	@FindBy(xpath="(//div[contains(text(),'Preferred payment mode')]") public WebElement cardpay;
	@FindBy(xpath="(//input[@id='security_code']") public WebElement security;
	@FindBy(xpath="(//button[@data-testid='handle-submit']") public WebElement payingButton;
	@FindBy(xpath="(//*[contains(text(),'Awesome! Payment Complete')]") public WebElement paymentpage;
	@FindBy(xpath="//div[contains(text(),'Netbanking')] | //div[id='3']") public WebElement bankingpay;
	@FindBy(xpath="//image[@alt='Axis Bank'] | //*[contains(text(),'Axis Bank')]") public WebElement selectbank;
	@FindBy(xpath="//button[contains(text(),'Success')]") public WebElement Success;
	@FindBy(xpath="//*[contains(text(),'Awesome! Payment Complete')]") public WebElement validatepayment;
	@FindBy(xpath="//p[contains(text(),'Grocery')]") public WebElement fitnesstile;
	@FindBy(xpath="//*[text()='Electronics'] | (//div[@class='component11']//p)[2]") public WebElement SLPElectronics;
	@FindBy(xpath="//p[contains(text(),'Electronics')]") public WebElement electronicSlp;
	@FindBy(xpath="//div[contains(@class,'dropdown__text')]/span") public WebElement clickdropdown;
	@FindBy(xpath="//div[contains(text(),'Fitness')]") public WebElement dropdownfitness;
	@FindBy(xpath="//div[@id='coinsText-4']") public WebElement electronicWidget;
	//Raza(17/05/22)
	//CultPass
	@FindBy(xpath="//*[text()='YES, ACTIVATE']") public WebElement activateNeuPass;
	@FindBy(xpath="//h5[text()='CULTPASS']") public WebElement cultPass;
	@FindBy(xpath="(//div[text()='BUY'])[3]") public WebElement eliteBuy;
	@FindBy(xpath="//*[text()='Pick a start date']") public WebElement pickStartDate;
	@FindBy(xpath="//div[@role='option' and text()='10']") public WebElement selectDate;
	@FindBy(xpath="//p[text()='Get pack']") public WebElement getPackButton;
	@FindBy(xpath="//button[text()='Pay with Tata Pay']") public WebElement payWithTP;
	
//Raza(17/05/22)
	//CultPass
	@FindBy(xpath="//img[@alt='location_pin']")public WebElement locationPin;
	@FindBy(xpath="//div[text()='Mumbai']")public WebElement selectLocation;
	//CultSport	
	@FindBy(xpath="//h5[text()='CULTSPORT']") public WebElement cultSport;
	@FindBy(xpath="(//div[@tabindex='-1'])[6]") public WebElement product;
	@FindBy(xpath="//div[text()='Buy Now']") public WebElement buyNow;
	@FindBy(xpath="//button[text()='Select Address']") public WebElement selectAddress;
	@FindBy(xpath="//div[@class='address-type']/..") public WebElement addAddress;
	@FindBy(xpath="//div[text()='My transactions']") public WebElement myTransactions;
	@FindBy(xpath="(//span[text()='Cult.fit'])[1]") public WebElement cultFitBrand;
	
	
//TPM
	@FindBy(xpath="//div[@id='2' and text()='Card payments']") public WebElement cardPayments;
	@FindBy(xpath="//*[text()='Transaction ID']/following-sibling::span") public WebElement txnID_MTP;
	@FindBy(xpath="(//input[@type='radio' and @name='payment'])[1]/following-sibling::label") public WebElement selectCreditCard;
	@FindBy(xpath="(//input[@type='radio' and @name='payment'])[2]/following-sibling::label") public WebElement selectDebitCard;
	@FindBy(xpath="//input[@placeholder='CVV'] | //input[@name='CVV']") public WebElement CVV;
	@FindBy(xpath="(//button[contains(text(),'Pay')])[2]") public WebElement pay;
	@FindBy(xpath="//input[@placeholder='OTP']") public WebElement OTP;
	@FindBy(xpath="//button[@type='submit']") public WebElement submitButton;
	@FindBy(xpath="//div[@id='3' and text()='Netbanking']") public WebElement netBanking;
	@FindBy(xpath="//span[text()='Awesome! Payment Complete']") public WebElement paymentComplete;
	@FindBy(xpath="//*[text()='NETBANKING'] | //*[text()='Netbanking']") public WebElement NetBanking_TPM;
	@FindBy(xpath="(//*[text()='Netbanking']/following::div/div[contains(text(),'Axis Bank')][1])") public WebElement netbanking_first_bank;
	@FindBy(xpath="//*[text()='Successful'] | //*[text()='Success']") public WebElement NetBankingSucces_TPM;
	@FindBy(xpath="//*[text()='Failure']") public WebElement failPayment;
	@FindBy(xpath ="(//*[@data-testid='data-div-container']//following::div/div[1])[1]") public WebElement firstOrder;
	@FindAll({@FindBy(xpath="//div[@id='content']/div[1]")}) public List<WebElement> myTxnIDList;
	@FindAll({@FindBy(xpath="//*[@data-testid='flex-status']//div[1]")}) public List<WebElement> myTxnStatusList;

}
