package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.QA.TestApp.Utilities.BaseScript;

public class NCOM_PDP_Web extends BaseScript {
	@FindBy(xpath="//button[text()='Add to cart']") public WebElement addCartBtn;
	@FindBy(xpath="//*[text()='Go TO cart']") public WebElement goToCartBtn;
	@FindBy(xpath="//*[text()='Buy now']") public WebElement buyNowBtn;
	@FindBy(xpath="//img[@alt='Cart Icon']/preceding::div[1]") public WebElement cartItemCount;
	@FindBy(xpath="//img[@alt='Product']") public List<WebElement> productImages;
	@FindBy(xpath="//div[@p='24px 16px']//*[contains (@class, 'css-1o8poxy')]") public List<WebElement> productsDescriptionInCart;
	@FindBy(xpath= "//*[text()='Order total']//following-sibling::div/span") public WebElement itemsPriceInCart;
	@FindBy(xpath= "//*[text()='Order total']//following-sibling::div/span[2]") public WebElement discountInCart;
	@FindBy(xpath= "//*[text()='Order total']//following-sibling::div[3]/span[2]") public WebElement deliveryPrice;
	@FindBy(xpath= "//*[text()='Cart Total']/parent::div//following-sibling::div/span") public WebElement cartTotal;
	@FindBy(xpath= "//h4") public WebElement productDescriptionPDP;
	@FindBy(xpath= "//h3") public WebElement productPricePDP;
	@FindBy(xpath= "") public WebElement productPriceWithoutDiscountPDP;
	@FindBy(xpath= "") public WebElement productDiscountPercentPDP;
	@FindBy(xpath= "//*[contains(text(),'NeuCoins')]//preceding::span[1]") public WebElement earnNeuCoinsPDP;
	@FindBy(xpath= "(//h4)[2]") public WebElement productOverviewPDP;
	@FindBy(xpath= "(//h4)[3]") public WebElement productKeyFeaturesPDP;
	@FindBy(xpath= "(//h4)[4]") public WebElement productSpecificationsPDP;
	@FindBy(xpath= "//img[@alt='Cart Icon']") public WebElement cartIcon;
}