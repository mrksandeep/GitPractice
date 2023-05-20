package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_VaultPage {
	
	@FindBy(xpath ="(//*[contains(text(),'Vault')])[1]") public WebElement vaultBtn;

	@FindBy(xpath = "//h4[contains(text(),'U Points')]")
	public WebElement cardName_TCP;
	
	@FindBy(xpath = "//h4[contains(text(),'U Points')]//parent::div//parent::div//parent::div/div[3]/h4")
	public WebElement viewDetailsCTA_TCP;
	
	@FindBy(xpath = "//*[contains(text(),'PAYMENT METHODS')]/parent::div/parent::div/following-sibling::div/div[1]/div//h4[contains(text(),'Croma')]/parent::div/parent::div/parent::div//h4[contains(text(),'View')]")
	public WebElement cardName_Croma;
	
	@FindBy(xpath = "//*[contains(text(),'Croma')]/parent::div/parent::div/parent::div/div[3]/h4 | //*[contains(text(),'Croma')]")
	public WebElement viewDetailsCTA_Croma;
	
	@FindBy(xpath = "//*[contains(text(),'PAYMENT METHODS')]/parent::div/parent::div/following-sibling::div/div[1]/div//h4[contains(text(),'IHCL')]/parent::div/parent::div/parent::div//h4[contains(text(),'View')]")
	public WebElement cardName_IHCL;
	
	@FindBy(xpath = "//*[@class='sc-fzoxKX fuVrJR']/div[@class='Flex__Box-kdyZDI gOUVpC']/div/following-sibling::h4")
	public WebElement viewDetailsCTA_IHCL;	
	@FindBy(xpath = "//div[contains(text(),'Pay')]") public WebElement payTab;
	@FindBy(xpath = "//div[contains(text(),'Cards')]") public WebElement cardTab;
	@FindBy(xpath = "//div[contains(text(),'Saved offers')]") public WebElement offersTab;
	@FindBy(xpath = "//*[contains(text(),'Payment Methods')]") public WebElement paymentMethodHeader;
	@FindBy(xpath = "//*[contains(@class,'sc-fzplgP bHmBtJ') and contains(text(),'BANCODOBRASIL.S.A.')]") public WebElement cardName_BANCODOBRASIL;
	@FindBy(xpath = "//*[contains(@class,'sc-fzplgP bHmBtJ') and contains(text(),'ICICI BANK')]") public WebElement cardName_ICICIBANK;
	@FindBy(xpath = "//*[contains(@class,'sc-fzplgP bHmBtJ') and contains(text(),'BARCLAYS BANK')]") public WebElement cardName_BARCLAYSBANK;
	@FindBy(xpath = "//*[contains(@class,'sc-fzplgP bHmBtJ') and contains(text(),'ALLIEDIRISHBANKSPLC')]") public WebElement cardName_ALLIEDIRISHBANKSPLC;
	@FindBy(xpath = "//*[contains(@class,'sc-fzplgP bHmBtJ') and contains(text(),'Tata capital Credit Line')]") public WebElement cardName_tatacapitalCreditLine;
	@FindBy(xpath = "//*[contains(@class,'sc-fzoi')]") public WebElement addNewCard;
	@FindBy(xpath = "//*[contains(@class,'sc-fzoxnE GqMIW') and contains(text(),'4001-XXXXXXXX-7193')]") public WebElement cardNumber_BANCODOBRASIL;
	@FindBy(xpath = "//*[contains(@class,'sc-fzoxnE GqMIW') and contains(text(),'4375-XXXXXXXX-5671')]") public WebElement cardNumber_ICICIBANK;
	@FindBy(xpath = "//*[contains(@class,'sc-fzoxnE GqMIW') and contains(text(),'2222-XXXXXXXX-8877')]") public WebElement cardNumber_BARCLAYSBANK;
	@FindBy(xpath = "//*[contains(@class,'sc-fzoxnE GqMIW') and contains(text(),'150000')]") public WebElement totalLimit;
	@FindBy(xpath = "//*[contains(@class,'sc-fzqzlV gMJRj') and contains(text(),'05/2023')]") public WebElement expirydate_BANCODOBRASIL;
	@FindBy(xpath = "//*[contains(@class,'sc-fzqzlV sc-fzqLLg kCMTKY') and contains(text(),'Activate Now')]") public WebElement activateNow;
	@FindBy(xpath = "//*[contains(@class,'sc-fzoWqW cdKMsY') and contains(text(),'EXPIRY DATE')]") public WebElement expiryDate;
	@FindBy(xpath = "//*[contains(@class,'sc-fzqzlV sc-fzqLLg kCMTKY') and contains(text(),'View Details')]") public WebElement viewDetails;
	@FindAll({@FindBy(xpath = "//*[contains(@class,'sc-AxhCb sc-AxhUy fxWvvr')]")}) public List<WebElement> viewDetailsbtn;
	@FindAll({@FindBy(xpath = "//*[contains(text(),'PAYMENT METHODS')]/parent::div/parent::div/following-sibling::div/div[1]/div/div/div//h4")}) public List<WebElement> cardHeaders;
	@FindAll({@FindBy(xpath = "//button[@role='tab']")}) public List<WebElement> cardDetailsPage;	
	@FindBy(xpath="//div[@class='sc-fzoKki kzEDNx']//h4[@class='sc-fzoyTs sc-fzoNJl loPePV']") public WebElement viewDetailsbutton_VISA;
	@FindBy(xpath="//button[@class='styles__StyledButton-jZOURz eQnFfF']//div[@class='styles__StyledTab-ilCEIm iYMHbn']") public WebElement activitiesTAB_VISA;
	@FindBy(xpath="//button[@class='styles__StyledButton-jZOURz oEdpr']//div[@class='styles__StyledTab-ilCEIm iYMHbn']") public WebElement moreTAB_VISA;
	@FindBy(xpath="//*[contains(text(),'PAYMENT METHODS')]") public WebElement paymentMethod;
	@FindBy(xpath = "//div[contains(text(),'My Cards')]") public WebElement mycardTab;
	@FindAll({@FindBy(xpath = "//*[contains(text(),'PAYMENT METHODS')]/parent::div/parent::div/following-sibling::div/div[1]/div")}) public List<WebElement> allCards;
	@FindBy(xpath = "//*[@class='modal-content'] | //*[@data-testid='card-container']") public WebElement cardModalBox;
	@FindBy(xpath = "//*[@class='modal-container']/div/button//*[@fill-rule='evenodd'] | //*[@data-testid='card-container']/parent::div/preceding-sibling::span//*[@fill-rule='evenodd']") public WebElement cardModalBoxCloseBtn;
	@FindBy(xpath="//*[contains(text(),'PAYMENT METHODS')]/parent::div/parent::div/following-sibling::div/div[1]/div//h4[contains(text(),'View')]") public List<WebElement> allCardsViewDetailsBtn;

	
	@FindBy(xpath = "//button[contains(text(),'View Details')]") public WebElement First_CTA;
	@FindBy(xpath = "//*[contains(text(),'Buy Now')]") public WebElement Second_CTA;
	@FindBy(xpath = "//*[@id='modal-close-button']") public WebElement close_Button;
	@FindBy(xpath = "//button[contains(text(),'Next')]") public WebElement continue_Button;
	@FindBy(xpath = "//p[contains(text(),'Personal details')]") public WebElement basic_details_text;
	@FindBy(xpath = "//*[@id='firstName']") public WebElement first_name_field;
	@FindBy(xpath = "//*[@id='lastName']") public WebElement last_name_field;
	@FindBy(xpath = "(//*[@fill-rule='nonzero'])[1]") public WebElement back_Button;
	
	@FindBy(xpath = "//*[contains(text(),'Pay Bills')]") public WebElement pay_bills_text;
	@FindBy(xpath = "//*[contains(text(),'With just one tap')]") public WebElement pay_bills_description_text;
	@FindBy(xpath = "//div[contains(text(),'UPI services')]") public WebElement upi_services_text;
	@FindBy(xpath = "(//*[contains(text(),'Cards')])[1]") public WebElement cards_text;
	@FindBy(xpath = "//*[contains(text(),'Add new')]") public WebElement card_add_new_text;
	@FindBy(xpath = "//*[contains(text(),'Download app')]") public WebElement download_App_text;
	
	@FindBy(xpath = "//*[contains(text(),'Pay bills')]") public WebElement bill_payment_text;
	@FindBy(xpath = "//*[contains(text(),'Recharge')]") public WebElement recharges_text;
	@FindBy(xpath = "//*[contains(text(),'Broadband')]") public WebElement bill_payment_Broadband_text;
	@FindBy(xpath = "//*[contains(text(),'Electricity')]") public WebElement bill_payment_Electricity_text;
	@FindBy(xpath = "//*[contains(text(),'Gas')]") public WebElement bill_payment_Gas_text;
	@FindBy(xpath = "//*[contains(text(),'Landline')]") public WebElement bill_payment_Landline_text;
	@FindBy(xpath = "//*[contains(text(),'Mobile Postpaid')]") public WebElement bill_payment_Mobile_Postpaid_text;
	@FindBy(xpath = "//*[contains(text(),'Water')]") public WebElement bill_payment_water_text;
	@FindBy(xpath = "//*[contains(text(),'DTH')]") public WebElement recharges_DTH_text;
	@FindBy(xpath = "//*[contains(text(),'Mobile Prepaid')]") public WebElement recharges_Mobile_Prepaid_text;
	@FindBy(xpath = "//*[@stroke-linecap='round']") public WebElement round_close_button;
	@FindBy(xpath = "//*[contains(text(),'Add New Bill')]") public WebElement Add_new_Bill_text;
	@FindBy(xpath = "//*[contains(text(),'Recent Bills')]") public WebElement recent_bills_text;
	@FindBy(xpath = "//*[contains(text(),'Billers')]") public WebElement Billers_text;
	@FindBy(xpath = "//*[@id='app']/div[2]/div[3]/section[1]") public WebElement first_recent_bills;
	
	@FindBy(xpath = "//*[contains(text(),'Instant Money Transfer')]") public WebElement download_app_First_Text;
	@FindBy(xpath = "//*[contains(text(),'Send and request money directly from your bank account')]") public WebElement download_app_Second_Text;
	@FindBy(xpath = "//*[@data-testid='google_app_download']/div") public WebElement download_app_Third_Text;
	@FindBy(xpath = "//*[@data-testid='apple_app_download']/div") public WebElement download_app_Fourth_Text;
	@FindBy(xpath = "//*[@title='Google Play Logo']") public WebElement google_play_page_icon;
	@FindBy(xpath = "(//*[contains(text(),'App Store')])[2]") public WebElement mac_store_page_icon;
	@FindBy(xpath = "//*[contains(text(),'@tapicici')]") public WebElement self_upi_id;
	@FindBy(xpath = "//div[@class='sc-hmjpBu sc-dSfclH fVlEtO gXLzpE']/div[1]/div[2]/h1") public WebElement first_Card;
	@FindBy(xpath = "//*[@data-testid='history-container']/div[1]") public WebElement card_first_modal_details;
	@FindBy(xpath = "//*[@data-testid='history-container']/div[2]") public WebElement card_second_modal_details;
	@FindBy(xpath = "//*[@data-testid='history-container']/div[3]") public WebElement card_third_modal_details;
	@FindBy(xpath = "(//*[contains(text(),'More')])[1]") public WebElement more_text_card_modal;
	@FindBy(xpath = "//*[contains(text(),'PDF')]") public WebElement pdf_text_card_modal;
	@FindBy(xpath = "//*[contains(text(),'Excel')]") public WebElement excel_text_card_modal;
	@FindBy(xpath = "//*[@data-testid='close-icon']") public WebElement card_modal_close_icon;
	@FindBy(xpath = "(//*[contains(text(),'CARD NUMBER')])[1]") public WebElement first_card_number_text;
	@FindBy(xpath = "//*[@data-testid='handle_Add_Card']") public WebElement Add_new_card_symbol;
	@FindBy(xpath = "//*[@placeholder='Name on the Card']") public WebElement Name_of_the_card_textBox;
	@FindBy(xpath = "//*[@placeholder='Card number']") public WebElement Card_number_textBox;
	@FindBy(xpath = "//*[@placeholder='MM']") public WebElement Month_textBox;
	@FindBy(xpath = "//*[@placeholder='YY']") public WebElement Year_textBox;
	@FindBy(xpath = "//*[contains(text(),'Continue')]") public WebElement continue_button;
	@FindBy(xpath = "(//*[contains(text(),'1111')])[1]") public WebElement card_last_digit_number;
	@FindBy(xpath = "//*[@data-testid='delete-card-icon']") public WebElement delete_card_button;		
	@FindBy(xpath = "(//*[contains(text(),'Confirm')])[1]") public WebElement confirm_button;	
	
}