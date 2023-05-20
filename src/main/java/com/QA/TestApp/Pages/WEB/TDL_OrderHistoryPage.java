package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_OrderHistoryPage {
	@FindBy(xpath = "//*[text()='My Orders']") public WebElement myorderstxt;
	@FindBy(xpath="//*[@id='filter-click'] | //*[contains(text(),'My Orders')]/parent::div/div//*[@fill-rule='evenodd']") public WebElement filterButton;
	@FindBy(xpath="//*[contains(text(),'Credit Card')]") public WebElement creditcard;
	@FindBy(xpath="//*[contains(text(),'Debit Card')]") public WebElement debitcard;
	@FindBy(xpath="//*[contains(text(),'UPI')]") public WebElement upi;
	@FindBy(xpath="//*[contains(text(),'BY INSTRUMENT')]") public WebElement byinstrumnent;
	@FindBy(xpath="//*[contains(text(),'TCP Points')]") public WebElement tcpPoint;
	@FindBy(xpath = "//*[contains(text(),'Tata Capital')]") public WebElement tatacapital;
	@FindBy(xpath="//*[contains(text(),'NetBanking')]") public WebElement netBanking;
	@FindBy(xpath="//*[contains(text(),'BY CATEGORY')]") public WebElement byCtegory;
	@FindBy(xpath="//*[contains(text(),'Bill Payments')]") public WebElement billPayments;
	@FindBy(xpath="//*[contains(text(),'Croma')]") public WebElement croma;
	@FindBy(xpath="//*[contains(text(),'IHCL')]") public WebElement ihcl;
	@FindBy(xpath="//*[contains(text(),'AIG')]") public WebElement aig;
	@FindBy(xpath = "//*[contains(text(),'Tata Sky')]") public WebElement tatasky;
	@FindBy(xpath="//*[contains(text(),'TRANSACTION STATUS')]") public WebElement transactionStatus;
	@FindBy(xpath="//*[contains(text(),'Pending')]") public WebElement pending;
	@FindBy(xpath="//*[contains(text(),'Failed')]") public WebElement failed;
	@FindBy(xpath="//*[@data-value='Refund']") public WebElement refund;
	@FindBy(xpath="//*[contains(text(),'All')]") public WebElement all;
	@FindBy(xpath="//*[contains(text(),'BY DURATION')]") public WebElement byDuration;	
	@FindBy(xpath = "//*[contains(text(),'Today')]") public WebElement today;
	@FindBy(xpath="//*[contains(text(),'Last 7 Days')]") public WebElement last7Days;
	@FindBy(xpath="//*[contains(text(),'This Month')]") public WebElement thisMonth;
	@FindBy(xpath="//*[contains(text(),'Custom')]") public WebElement custom;
	@FindBy(xpath="//*[contains(text(),'Reset')]") public WebElement reset;
	@FindBy(xpath="//*[contains(text(),'Apply')]") public WebElement apply;
	@FindBy(xpath="//*[@id='close-button']") public WebElement closebtn;	
	@FindBy(xpath="//*[@mask='url(#chevron-left-b)'] | //*[contains(text(),'My Orders')]/parent::div/span//*[@fill-rule='evenodd']") public WebElement oderhistorybackbtn;	
	@FindBy(xpath = "//*[contains(text(),'Description')]") public WebElement description;
	@FindBy(xpath="//*[contains(text(),'Order No.')]") public WebElement orderNo;
	@FindBy(xpath="//*[contains(text(),'Price')]") public WebElement price;
	@FindBy(xpath="//*[contains(text(),'Status')]") public WebElement status;
	@FindBy(xpath="//*[contains(text(),'Successful')]") public WebElement statusSuccess;
	@FindBy(xpath="//*[@id='flex-div'][1]") public WebElement selectOrder;
	@FindAll({@FindBy(xpath="//*[@class='sc-fznxsB sc-fznJRM hBpQcB']")}) public List<WebElement> statusList;
	@FindAll({@FindBy(xpath="//img[@alt='logo']")}) public List<WebElement> logo;
	@FindAll({@FindBy(xpath="//*[@class='sc-oUDcU giPnAI']")}) public List<WebElement> orderNoList;
	@FindAll({@FindBy(xpath="//*[contains(text(),'₹')]")}) public List<WebElement> priceList;
	@FindBy(xpath="//input[@name='StartDate']") public WebElement startDate;
	@FindBy(xpath="//input[@name='EndDate']") public WebElement endDate;
	@FindBy(xpath="//*[contains(text(),'BY INSTRUMENT')]/following-sibling::div/button") public List<WebElement> byInstrumnentBtns;
	@FindBy(xpath="//*[contains(text(),'BY CATEGORY')]/following-sibling::div/button") public List<WebElement> byCategoryBtns;
	@FindBy(xpath="//*[contains(text(),'TRANSACTION STATUS')]/following-sibling::div/button") public List<WebElement> transactionStatusBtns;
	@FindBy(xpath="//*[contains(text(),'BY DURATION')]/following-sibling::div/button") public List<WebElement> byDurationBtns;

	@FindBy(xpath="//*[@name='UPI']") public WebElement upi_filter_text;
	@FindBy(xpath="//*[@name='Success']") public WebElement success_filter_text;
	@FindBy(xpath="//*[@data-testid='data-div-container']/div[1]") public WebElement order_container;
	@FindBy(xpath="//*[@data-testid='handle-chatbot']") public WebElement talk_to_us;
	@FindBy(xpath="//*[contains(text(),'Powered by')]") public WebElement powered_By_text;
	@FindBy(xpath="//*[@data-testid='details-container']/div[1]/div[1]/div") public WebElement payer_name_text;
	@FindBy(xpath="//*[@data-testid='details-container']/div[1]/div[2]/div[1]/label[2]") public WebElement payer_id_text;
	@FindBy(xpath="//*[@data-testid='details-container']/div[1]/div[2]/div[2]/div") public WebElement transaction_time_text;
	@FindBy(xpath="//*[@data-testid='details-container']/div[1]/div[1]/label") public WebElement transaction_amount1_text;
	@FindBy(xpath="//*[@data-testid='details-container']/div[2]/div/div[3]/label") public WebElement transaction_id_text;
	@FindBy(xpath="//*[@data-testid='details-container']/div[2]/div/div[3]/div/span/div/label") public WebElement bank_image;
	@FindBy(xpath="//*[@data-testid='details-container']/div[2]/div/div[3]/div/span/div/div/label[1]") public WebElement account_number_text;
	@FindBy(xpath="//*[@data-testid='details-container']/div[2]/div/div[3]/div/span/div/div/label[2]") public WebElement utr_number;
	@FindBy(xpath="//*[@data-testid='details-container']/div[2]/div/div[3]/div/span/div/h4") public WebElement transaction_amount2_text;
	
	
	@FindBy(xpath="//*[@id='order_history_step2']") public WebElement order_tab;
	@FindBy(xpath="(//div[@id='content'])[1]") public WebElement latest_order;
	@FindBy(xpath="//*[contains(text(),'Big Basket')]") public WebElement big_basket_brand_order;
	@FindBy(xpath="//*[contains(text(),'Croma')]") public WebElement croma_brand_order;
	@FindBy(xpath="//*[contains(text(),'IHCL')]") public WebElement ihcl_brand_order;
	@FindBy(xpath="//*[contains(text(),'Air Asia')]") public WebElement air_asia_brand_order;
	@FindBy(xpath="(//*[@title='Bigbasket'])[2]") public WebElement big_basket_web_icon;
	@FindBy(xpath="(//*[@src='https://media.croma.com/image/upload/f_auto,q_auto,d_Croma%20Assets:no-product-image.jpg/v1614192471/Croma%20Assets/UI%20Assets/croma_logo.png'])[1]") public WebElement croma_web_icon;
	@FindBy(xpath="(//*[@src='/content/dam/tajhotels/icons/style-icons/logo--Taj.png'])[1]") public WebElement ihcl_web_icon;
	@FindBy(xpath="//*[@src='/content/dam/air-asia/home-page/Logo.jpg']") public WebElement air_asia_web_icon;
	@FindBy(xpath="//*[contains(text(),'Track all your commerce, across brands in one place')]") public WebElement order_tab_text;
	@FindBy(xpath="//*[@src='/assets/images/tata-sky-logo.png']") public WebElement tata_sky_web_icon;
	@FindBy(xpath="//*[@src='/media/logo_tcm87-366_w1024_n.png']") public WebElement starbucks_web_icon;
	@FindBy(xpath="//*[@class='DesktopHeader__logoHolder']") public WebElement tata_cliq_web_icon;
	@FindBy(xpath="//*[contains(text(),'Tata Sky')]") public WebElement tata_sky_brand_order;
	@FindBy(xpath="//*[contains(text(),'Starbucks')]") public WebElement starbucks_brand_order;
	@FindBy(xpath="//*[contains(text(),'Tata Cliq')]") public WebElement tata_cliq_brand_order;
	
	
}


