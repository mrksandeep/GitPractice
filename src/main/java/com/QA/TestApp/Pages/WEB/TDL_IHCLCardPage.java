package com.QA.TestApp.Pages.WEB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TDL_IHCLCardPage {
	
	@FindBy(xpath = "//*[@class='sc-fzoWqW cdKMsY']/label")
	public WebElement cardNameText_IHCL;

	@FindBy(xpath = "//*[@class='sc-fznYue kyOvTV']/button[contains(text(),'Activity')]")
	public WebElement activityTab_IHCL;

	@FindBy(xpath = "//*[@class='sc-fznYue kyOvTV']/button[contains(text(),'My Benefits')]")
	public WebElement myBenefitsTab_IHCL;
	
	@FindBy(xpath = "//*[@class='sc-fznYue kyOvTV']/button[contains(text(),'All Tiers')]")
	public WebElement allTiers_IHCL;

	@FindBy(xpath = "//*[@class='Flex__Box-kdyZDI iESIzA']/button[contains(text(),'Book Now')]")
	public WebElement shopNowCTA_IHCL;

	@FindBy(xpath = "//div[@class='sc-fzoMdx uYzkI']/div[@class='sc-fzoWqW cdKMsY']/following-sibling::button")
	public WebElement closeBtn_IHCL;

}
