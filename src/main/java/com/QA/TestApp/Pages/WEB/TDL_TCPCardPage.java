package com.QA.TestApp.Pages.WEB;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_TCPCardPage {

	@FindBy(xpath = "//div[@class='sc-fzoMdx uYzkI']/div/label | //div[@class='sc-fznMnq biVOqy']/div/label | //label[contains(text(),'U Points')]")
	public WebElement cardNameText_TCP;

	@FindBy(xpath = "//label[text()='POINT STATUS']//following-sibling::label | //*[@id='app']/div/div/section/section/div[1]/label[2]")
	public WebElement totalPoints_TCP;

	@FindBy(xpath = "")
	public WebElement pointsExpiring_TCP;

	@FindBy(xpath = "")
	public WebElement pointsExpiryDate_TCP;

	@FindBy(xpath = "//div[@class='sc-fzoydu ctZjfV']/button[@data-event='Activity'] | //button[contains(text(),'Activity')]")
	public WebElement activityTab_TCP;

	@FindBy(xpath = "//label[text()='POINT STATUS']/following-sibling::label")
	public WebElement pointStatus_TCP;

	@FindBy(xpath = "//div[@class='sc-fzoydu ctZjfV']/button[@data-event='Points Schedule'] //button[contains(text(),'Points Schedule')]")
	public WebElement pointsScheduleTab_TCP;

	@FindBy(xpath = "//div[@class='sc-fzpkJw kmfXod']/div/following-sibling::div/div | //div[@id='app']/div/div[@data-index='0']/div")
	public WebElement scrollableSectionUnderTab_TCP;

	@FindBy(xpath = "//div[@class='sc-AxhUy fxWvvr'] | //button[contains(text(),'Activity')]//parent::div/following-sibling::div/div/div/div/div/div[1]/div[2]")
	public List<WebElement> pointsActivity_TCP;

	@FindBy(xpath = "//div[@class='sc-AxhUy fxWvvr'] | //button[contains(text(),'Activity')]//parent::div/following-sibling::div/div/div/div/div/div[1]/div[1]/div[1]")
	public List<WebElement> transcDesc_TCP;

	@FindBy(xpath = "//div[@class='sc-AxhUy fxWvvr'] | //button[contains(text(),'Activity')]//parent::div/following-sibling::div/div/div/div/div/div[1]/div[1]/div[2]")
	public List<WebElement> transcDate_TCP;

	@FindBy(xpath = "//div[@class='style__Overlay-hszLzv kjyES modal-overlay']/button | //div[@class='sc-fzoMdx uYzkI']/div[@class='sc-fzoWqW cdKMsY']/following-sibling::button | //div[@class='sc-fznMnq biVOqy']/button | //label[contains(text(),'U Points')]//parent::div//following-sibling::button")
	public WebElement closeBtn_TCP;

	@FindBy(xpath = "//button[@class='styles__StyledButton-jZOURz eQnFfF']//div[@class='styles__StyledTab-ilCEIm iYMHbn']")
	public WebElement activitiesTAB_VISA;

	@FindBy(xpath = "//button[@class='styles__StyledButton-jZOURz oEdpr']//div[@class='styles__StyledTab-ilCEIm iYMHbn']")
	public WebElement moreTAB_VISA;
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI dCEvmk sc-pJwpB cGhijZ']//div[1]//label[1]")
	public WebElement todays_choicebtn_VISA;
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI dCEvmk sc-pJwpB cGhijZ']//div[2]//label[1]")
	public WebElement Last7days_choicebtn_VISA;
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI dCEvmk sc-pJwpB cGhijZ']//div[3]//label[1]")
	public WebElement Thismonth_choicebtn_VISA;
	@FindBy(xpath = "//div[@class='Flex__Box-kdyZDI dCEvmk sc-pJwpB cGhijZ']//div[4]//label[1]")
	public WebElement custome_choicebtn_VISA;
	
	@FindBy(xpath="//span[@class='sc-pAYXY hUbdZh']//button[@class='SmallButton__SmallButtonStyled-enCeDd dLltwW sc-qQlgh dnZKXh']")
	public WebElement PDF_button_VISAcard;
	@FindBy(xpath="//span[@class='sc-pAYXY dyyLUl']//button[@class='SmallButton__SmallButtonStyled-enCeDd dLltwW sc-qQlgh dnZKXh']")
	public WebElement Excel_button_VISAcard;
	@FindBy(xpath="//span[@class='sc-oTzgz nnuJi']//*[local-name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='g' and contains(@fill,'#FFF')]//*[name()='path' and contains(@d,'M-2-2h24v2')]")
	public WebElement delete_button_VISAcard;
	
}
