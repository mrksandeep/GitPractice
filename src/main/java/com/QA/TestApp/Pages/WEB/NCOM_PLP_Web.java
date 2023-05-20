package com.QA.TestApp.Pages.WEB;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.QA.TestApp.Utilities.BaseScript;

public class NCOM_PLP_Web extends BaseScript {

@FindBy(xpath="//input[@name ='q']") public WebElement searchTextArea;

@FindBy(xpath="//img[@alt='Product']") public List<WebElement> productImages;

@FindBy(xpath="//*[text()='Filters']") public WebElement filtersHdr;
@FindBy(xpath="//*[text()='Sort By']") public WebElement sortByHdr;
@FindBy(xpath="//img[@alt='Product']/following::h4/../../../span") public List<WebElement> productDesc;
//*[@class='MuiTypography-root MuiTypography-body-m css-zz11w9']
//img[@alt='Product']/following::h4/../../../span
@FindBy(xpath="//img[@alt='Cart Icon']") public WebElement cart;
@FindBy(xpath="//img[@alt='Cart Icon']/preceding::div[1]") public WebElement cartItemCount;

@FindBy(xpath="//span[contains(text(),'Showing')]/following::h4/following-sibling::span[1]") public List<WebElement> mrp;
@FindBy(xpath="//*[text()='Discount Percentage']") public WebElement discountPercentFilterLabel;
//0th index should be excluded 8-1=7 selection points.
@FindBy(xpath="//*[@id='discount_percentaged-content']/div/div[2]/span/span[@data-index]") public List<WebElement> discountSelector;
@FindBy(xpath="//*[@id='discount_percentaged-content']/div/div/div[2]/span") public WebElement selectedDiscountPercent;
@FindBy(xpath="//span[contains(text(),'Showing')]/following::h4/following-sibling::span[2]") public List<WebElement> discountPercentageValue;

//1,2,3,4 selection points.
@FindBy (xpath="//*[@id='discount_priced-content']/div/div[2]/span/span[@data-index]") public List<WebElement> discountPriceRangeSelector;
@FindBy(xpath="//*[text()='Discount Price']") public WebElement discountPriceFilterLabel;
@FindBy(xpath="//*[@id='discount_priced-content']/div/div/div[2]/span") public WebElement selectedDiscountPriceRange;
@FindBy(xpath="//span[contains(text(),'Showing')]/following::h4") public List<WebElement> discountedPriceOfProducts;

//*[@id='discount_percentaged-content']/div/div[2]/span/span[@data-index]


}