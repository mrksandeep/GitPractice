package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TDL_HomePage {
	@FindBy(xpath = "(//*[contains(text(),'Vault')])[1]") public WebElement vaultLink;
	@FindBy(xpath = "//*[@data-event='tcp.myProfile.myProfileClick'] | //div[@data-testid='homenavbar']/div/div[1]/div/div | //div[@data-testid='homenavbar']/div/div[2]/div/div | //*[@class='Avatar__StyleAvatar-llvwXb hikXk']/label") public WebElement myProfileLink;
	@FindBy(xpath = "//a[@href='/my-profile']") public WebElement profileButton;
	@FindBy(xpath = "//*[contains(text(),'Sign out')]") public WebElement signOutLink;
	@FindBy(xpath = "//*[contains(text(),'Me at a glance')]") public WebElement myProfileBasicDetails;
	@FindBy(xpath = "//*[@id='signout-modal']") public WebElement signOutPopup;
	@FindBy(xpath = "//button[contains(text(),'Sign Out')] | //*[@id='signout-modal']//button[2]") public WebElement signOutButtonOnPopup;
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI beBEsA Carousel__ControlPanel-eihPqL gQnbC']") public WebElement FlagNextPrevButton;
	@FindBy(xpath = "//*[@id='firstName']") public WebElement basicDetailFirstName;
	@FindBy(xpath = "//*[@id='lastName']") public WebElement basicDetailLastName;
	@FindBy(xpath = "//*[@id='email']") public WebElement basicDetailEmail;
	@FindBy(xpath = "//*[@id='dob']") public WebElement basicDetailDob;
	@FindBy(xpath = "//*[@id='phone']") public WebElement basicDetailMobileNumber;
	@FindBy(xpath = "//h1[contains(text(),'Profile')]/..//*[@fill-rule='nonzero']") public WebElement backProfileButton;
	@FindBy(xpath = "//label[contains(text(),'Profile')]") public WebElement profileLink;
	@FindBy(xpath = "//a[@href='/discovery']") public WebElement searchIcon;
	@FindBy(xpath = "//*[@id='main-content']/div[1]/div/div[1]/div/div | //a[@href='/discovery']/parent::div/div[1]/div/div") public WebElement myAccountIcon;
	@FindBy(xpath = "//p[contains(text(),'Self Transfer')]") public WebElement selfTransferLink;
	@FindBy(xpath = "//*[text()='FOR YOU'] | //*[text()='Channels'] | //*[@id='homepage_tour_step_1']") public WebElement forYouLabel;
	@FindBy(xpath = "//div[@data-testid='homenavbar']/following-sibling::div[1]/div/div//li | //*[@class='slick-dots']/li/button") public List<WebElement> heroBannerPages;
	@FindBy(xpath = "//*[text()='Channels']") public WebElement channelHeader;
	@FindBy(xpath = "//h1[text()='Channels']/parent::div/parent::div") public WebElement channelRibbon;
	@FindBy(xpath = "//*[text()='xxxx']/parent::div/parent::a") public WebElement channelLink;
	@FindBy(xpath = "//div[@data-testid='homenavbar']/following-sibling::div[1]/div/div/div//*[local-name() = 'svg'][1]") public WebElement heroBannerLeftArrow;
	@FindBy(xpath = "//div[@data-testid='homenavbar']/following-sibling::div[1]/div/div/div//*[local-name() = 'svg'][2]") public WebElement heroBannerRightArrow;
	@FindBy(xpath = "//*[text()='Shop Now']") public List<WebElement> heroBannerShopNow;
	@FindBy(xpath = "//*[contains(text(),'Recommended Offers')]/parent::div/following-sibling::div/div[1]") public WebElement homePageRecommendedOffers;
	@FindBy(xpath = "//button[text()='Skip Tour'] | //*[contains(text(),'Skip Demo')]") public WebElement skipTourTextView;
	@FindBy(xpath = "//button[text()='Next']") public WebElement nextBtn;
	@FindBy(xpath = "//button[text()='Ok, got it']") public WebElement okGotIt;
	@FindBy(xpath = "//button[text()='Next']/parent::div/parent::div/h3") public WebElement appTourWidgetName;
	@FindBy(xpath = "//button[text()='Ok, got it']/parent::span/parent::div/parent::div/h3") public WebElement appTourLastWidgetName;
	@FindBy(xpath = "//*[contains(text(),'NOTICES')]/..//*[@fill-rule='evenodd']") public WebElement legalPage3Dots;
	@FindBy(xpath = "//*[@id='consentCheckbox']/div[2]/div//input") public List<WebElement> legalPageConsentCheckbox;
	@FindBy(xpath = "//*[contains(text(),'Save Changes')]") public WebElement legalPageConsentSaveChanges;
	@FindBy(xpath = "(//a[@href='/'])[2]") public WebElement homeBtn;
	@FindBy(xpath = "(//a[@href='/channels/view-all'])[1]") public WebElement channelsBtn;
	@FindBy(xpath = "(//a[@href='/apps'])[1]") public WebElement appsBtn;
	@FindBy(xpath = "(//a[@href='/cart'])[1]") public WebElement cartBtn;
	@FindBy(xpath = "(//a[@href='/discovery'])[1]") public WebElement discoveryBtn;
	@FindBy(xpath = "//*[contains(text(),'Netbanking')]") public WebElement vaultNetbankingOption;
	
	//paybill
	@FindBy(xpath = "//*[@data-testid='homenavbar']//*[contains(@class,'Avatar')]")
	public WebElement AvtarInSitHomepage;
	@FindBy(xpath = "//*[(text()='Order history')]")
	public WebElement Order_History;
	@FindBy(xpath = "//*[text()='REFUND STATUS']/following-sibling::*")
	public WebElement txtRefundstatus;
	@FindAll({@FindBy(xpath="//div[@class='slick-slider heroBannerSlider slick-initialized']/div[@class='slick-list']/div/div[@class='slick-slide' or contains(@class,'slick-active')]")}) public List<WebElement> heroBannerJourneyCTARotate;

}
