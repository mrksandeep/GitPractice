package com.QA.TestApp.Testcases.WEB;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.TabableView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.QA.TestApp.Utilities.BaseScript;
import com.QA.TestApp.Utilities.BrowserFactory;

public class NCOM_Web extends BaseScript {
	public static double totalCartAmount = 0.0;
	private static double expectedEarnPromisedPoints;
	WebDriver driver = BrowserFactory.webDriver.get();

	@Test
	public void LoginWithPWADesktop() throws Exception {
		try {

			BrowserFactory.webDriver.get().navigate().refresh();
			Thread.sleep(5000);
			String Mobile_no = fUtil.fgetDataNew1("Mobile_no").trim();
			gmethods.loginPwaDesktop(Mobile_no);

		} catch (Exception ee) {
			fUtil.flogResult("Failed", "API Response Validation failed",
					"API Response failed due to business error" + ee.getMessage(), 0);
		}
	}

	@Test
	public void fcEntry() throws Exception {
		try {

			scrollToBottom();
			Thread.sleep(2000);

			if (gmethods.isElementVisible(NCOM_HomePage_Web.get().getFCEntryFromHomepage(), 10)) {
				NCOM_HomePage_Web.get().getFCEntryFromHomepage().click();
			} else {
				BrowserFactory.webDriver.get().get("https://aem-sit-r2.tatadigital.com/v2/flash-commerce");
			}

			Thread.sleep(3000);

		} catch (Exception ee) {
			fUtil.flogResult("Failed", "API Response Validation failed",
					"API Response failed due to business error" + ee.getMessage(), 0);
		}
	}

	@Test
	public void heroBannerNavigation() throws Exception {
		try {

			WebDriver driver = BrowserFactory.webDriver.get();
			int BannersSize = NCOM_HomePage_Web.get().heroBannerdash.size();
			System.out.print("Dots: " + BannersSize);
			boolean desc = true;
			String description;

			fUtil.flogResult("Pass", "Number of Hero Banners", "Total Count is :" + BannersSize, 0);

			// for (int i = 0; i < BannersSize; i++) {
			NCOM_HomePage_Web.get().heroBannerdash.get(1).click();
			fUtil.flogResult("Pass", "Click HeroBanner", "Clicked on Hero Banner No. :" + (1 + 1), 1);
			Thread.sleep(1000);
			String currentPage = driver.getCurrentUrl();
			// NCOM_HomePage_Web.get().currentBanner.click();
			clickUsingJS(NCOM_HomePage_Web.get().currentBanner);
			Thread.sleep(10000);
			Set<String> handles = BrowserFactory.webDriver.get().getWindowHandles();
			if (handles.size() >= 2) {
				switchToNewTab();
				fUtil.flogResult("Passed", "Validate redirection", "Redirected to Poduct details page", 1);
			} else {
				if (currentPage.equals(driver.getCurrentUrl()))
					fUtil.flogResult("Failed", "Validate redirection", "Not redirected to PLP", 1);

			}
			// }

		} catch (Exception e) {
			fUtil.flogResult("Failed", "heroBannerSelection ",
					"Exception while selecting in Hero banner page " + e.getMessage(), 1);
		}
	}

	@Test
	public void productSelection() throws Exception {
		try {
			boolean fiterHdr = gmethods.isElementVisible(NCOM_PLP_Web.get().filtersHdr, 20);
			boolean sortHdr = gmethods.isElementVisible(NCOM_PLP_Web.get().sortByHdr, 20);
			if (fiterHdr && sortHdr) {

				int countOfProducts = NCOM_PLP_Web.get().productImages.size();
				if (countOfProducts > 0) {
					fUtil.flogResult("Passed", "Product visibility",
							"Products are visible and the itemcount is " + countOfProducts, 1);
					// Select a Product from PLP
					String product1 = NCOM_PLP_Web.get().productDesc.get(1).getText();
					clickUsingJS(NCOM_PLP_Web.get().productDesc.get(1));
					fUtil.flogResult("Passed", "Product Selection", "Product " + product1 + " is selected", 1);

				} else {
					fUtil.flogResult("Failed", "Product visibility",
							"Products are not visible and the itemcount is " + countOfProducts, 1);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			fUtil.flogResult("Failed", "Product visibility",
					"Products are not visible in PLP due to the exception : " + e.getMessage(), 1);
		}
	}

	@Test
	public void clickAddCart() throws Exception {
		try {

			Thread.sleep(3000);
			boolean BuyNow = gmethods.isElementVisible(NCOM_PDP_Web.get().addCartBtn, 10);
			if (BuyNow == true) {
				NCOM_PDP_Web.get().addCartBtn.click();
				fUtil.flogResult("Passed", "Click Add to Bag in PDP page", "Clicked Add to cart  successfully", 1);

				if (gmethods.isElementVisible(NCOM_PDP_Web.get().goToCartBtn, 10)) {
					fUtil.flogResult("Passed", "Add to Cart Check", "Item added to the cart successfully", 1);
				} else {
					fUtil.flogResult("Failed", "Add to Cart Check", "Item not added to the bag", 1);
				}
				String itemCount = NCOM_PDP_Web.get().cartItemCount.getAttribute("innerText");
				// NCOM_PDP_Web.get().cartItemCount.click();
				clickUsingJS(NCOM_PDP_Web.get().cartItemCount);
				fUtil.flogResult("Passed", "Item added to Cart",
						"Item added to the cart successfully with item count " + itemCount, 1);

			} else if (gmethods.isElementVisible(NCOM_PDP_Web.get().goToCartBtn, 10)) {
				String itemCount = NCOM_PDP_Web.get().cartItemCount.getAttribute("innerText");
				// NCOM_PDP_Web.get().cartItemCount.click();
				clickUsingJS(NCOM_PDP_Web.get().cartItemCount);
				fUtil.flogResult("Passed", "Item added to Cart",
						"Item added to the cart successfully with item count " + itemCount, 1);
			} else {
				fUtil.flogResult("Failed", "Click Add to Bag ", "Not Clicked Add to Bag in ", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Click Add to Bag ",
					"Not Clicked Add to Bag in pdp page failed due to:" + e.getMessage(), 1);
		}
	}

	@Test
	public void clickPincode() throws Exception {
		try {
			boolean Pincode = gmethods.isElementVisible(TdlCromaCard.get().pincodeBox, 10);
			if (Pincode == true) {
				String PincodeEx = fUtil.fgetDataNew1("Pincode");
				PincodeEx = PincodeEx.substring(1);
				TdlCromaCard.get().pincodeBox.clear();
				Thread.sleep(1000);
				TdlCromaCard.get().pincodeBox.sendKeys("400096");
				fUtil.flogResult("Passed", "Enter Pincode in croma page", "Entered Pincode successfully", 1);
				Thread.sleep(2000);
				TdlCromaCard.get().pincodeApplyBtn.click();
				fUtil.flogResult("Passed", "Apply Pincode in croma page", "Applied Pincode successfully", 1);
			} else {
				fUtil.flogResult("Failed", "Enter Pincode in croma page", "Not Entered Pincode in croma page", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Enter Pincode in croma page",
					"Not Entered Pincode in croma page failed due to:" + e.getMessage(), 1);
		}
	}

	// Click Checkout
	@Test
	public void clickCheckout() throws Exception {
		try {
			Thread.sleep(8000);
			boolean checkout = gmethods.isElementVisible(NCOM_Electronics_CLP_Web.get().checkOutBtn, 25);
			if (checkout == true) {
				// NCOM_Electronics_CLP_Web.get().checkOutBtn.click();
				clickUsingJS(NCOM_Electronics_CLP_Web.get().checkOutBtn);
				fUtil.flogResult("Passed", "Click Checkout ", "Clicked Checkout  successfully", 1);
			} else {
				fUtil.flogResult("Failed", "Click Checkout in croma page", "Not Clicked Checkout in croma page", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Click Checkout in croma page",
					"Not Clicked Checkout in croma page failed due to:" + e.getMessage(), 1);
		}
	}

	// Click payment//
	@Test
	public void clickPayment() throws Exception {
		try {

			boolean pay = gmethods.isElementVisible(NCOM_Electronics_CLP_Web.get().proceedToPayBtn, 10);
			if (pay == true) {
				// NCOM_Electronics_CLP_Web.get().proceedToPayBtn.click();
				clickUsingJS(NCOM_Electronics_CLP_Web.get().proceedToPayBtn);
				fUtil.flogResult("Passed", "Click proceedToPayBtn", "clicked proceedToPayBtn successfully", 1);

			}

			else {
				fUtil.flogResult("Failed", "Click proceedToPayBtn", "Not able clicked proceedToPayBtn", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "click pay in croma page",
					"Not clicked pay in croma page failed due to:" + e.getMessage(), 1);
		}
	}

	// Method for TPM page Payments//
	@Test
	public void TPMpaymentmethod() throws Exception {
		try {
			String paymentmethod = fUtil.fgetDataNew1("payment_method");
			String paymentType = fUtil.fgetDataNew1("payment_type");
			String LoyaltyPoints = fUtil.fgetDataNew1("Tcppoints_cutoff");

			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().PAymentMethod_TPM, 15)) {

				if (gmethods.isElementVisible(TdlCromaCard.get().totalCartAmt, 30)) {

					String totalTransactionAmount = TdlCromaCard.get().totalCartAmt.getText().replace("\u20B9", "")
							.trim();
					totalCartAmount = DecimalFormat.getNumberInstance().parse(totalTransactionAmount).doubleValue();
					System.out.println(totalCartAmount);
					fUtil.flogResult("Passed", "Enter Payment Page Details in TPM  ",
							"Payment Page loaded in TPM successfully and Total Cart Amount is " + totalCartAmount, 1);

				}

				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().PAymentchangeTPM, 15)) {
					TDL_SLPElectronicsPage.get().PAymentchangeTPM.click();
					Thread.sleep(8000);
				}
				/*
				 * else if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().view_TPM,
				 * 15)) { TDL_SLPElectronicsPage.get().view_TPM.click(); }
				 */
				switch (paymentmethod.trim().toLowerCase()) {
				case "creditcard":

					validateCreditCardPayment();
					break;

				case "debitcard":
					validateDebitCardPayment();

					break;

				case "internetbanking":
					validateInternetBanking();
					break;
				case "UPI":

					validateUPI();

					break;

				case "Multitender":
					validateLoyalty();
					clicKchange();
					validateInternetBanking();
					break;
				case "TCPPoints":
					validateLoyalty();

					clickPay();
					break;

				default:

				{
					logger.info("Payment not selected in TPM");
					fUtil.flogResult("Failed", "Validate TPM payment ", "TPM payment not successful", 1);

				}

				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			fUtil.flogResult("Failed", "Open Payment Page", "Exception Caught :: " + e.getMessage(), 1);
			throw e;
		}
	}

	// Method for Creditcard//
	@Test
	public void validateCreditCardPayment() throws Exception {
		try {
			String paymentType = fUtil.fgetDataNew1("payment_type");
			String brand = fUtil.fgetDataNew1("SLP");
			if (gmethods.isElementVisible(TdlCromaCard.get().cardsSelection, 10)) {
				TdlCromaCard.get().cardsSelection.click();
				Thread.sleep(2000);
			}
			if (gmethods.isElementVisible(TdlCromaCard.get().creditcard, 20)) {

				if (gmethods.isElementVisible(TdlCromaCard.get().creditCardRadioBtn, 20)) {
					TdlCromaCard.get().creditCardRadioBtn.click();
					if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().chnagePayment, 5)) {
						TDL_SLPElectronicsPage.get().chnagePayment.click();
					}
					// if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cvvCode, 10)) {
					BrowserFactory.webDriver.get().switchTo().frame(BrowserFactory.webDriver.get()
							.findElement(By.xpath("//iframe[contains(@name,'security_code')]")));
					// Thread.sleep(10000);
					//
					TdlCromaCard.get().enterCVV.click();
					TdlCromaCard.get().enterCVV.sendKeys("123");
					// TDL_SLPElectronicsPage.get().cvvCode.click();
					// TDL_SLPElectronicsPage.get().cvvCode.sendKeys("123");
					BrowserFactory.webDriver.get().switchTo().defaultContent();
					Thread.sleep(5000);
					Thread.sleep(5000);
					// }
				}

				if (paymentType.equalsIgnoreCase("Success")) {
					TDL_SLPElectronicsPage.get().payBtnnew.click();
					Thread.sleep(3000);
					// ClickRazorpayCroma();
					ClickAxisPasswordCroma();
					// TdlBPPayments_Mobile.get().successBtn_android.click();
					// Thread.sleep(10000);

					fUtil.flogResult("Passed", "Successfully completed payment using credit card",
							"Successfully completed payment using credit card ", 1);
				} else {
					TDL_SLPElectronicsPage.get().payBtnnew.click();
					TDL_SLPElectronicsPage.get().failPayment.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed Failure payment credit card using credit card",
							"Successfully completed payment on failure case using credit card", 1);
				}
			} else {
				fUtil.flogResult("Failed", "Validate Credit card payment", "Credit card payment failed", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	// Method for Debitcard//
	@Test
	public void validateDebitCardPayment() throws Exception {
		try {
			String paymentType = fUtil.fgetDataNew1("payment_type");
			String brand = fUtil.fgetDataNew1("SLP");

			// scroll(300);
			if (!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cardsSelection, 5)) {
				scrollToBottom();
			}
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cardsSelection, 20)) {
				TDL_SLPElectronicsPage.get().cardsSelection.click();
				Thread.sleep(5000);
			}
			if (gmethods.isElementVisible(TdlCromaCard.get().debitcard1, 20)) {
				if (gmethods.isElementVisible(TdlCromaCard.get().debitCardRadioBtn, 20)) {
					TdlCromaCard.get().debitCardRadioBtn.click();
					if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().chnagePayment, 5))
						TDL_SLPElectronicsPage.get().chnagePayment.click();
					if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cvvCode, 10)) {
						// TDL_SLPElectronicsPage.get().cvvCode.click();
						// TDL_SLPElectronicsPage.get().cvvCode.sendKeys("123");
						// BrowserFactory.webDriver.get().switchTo().frame(0);
						// BrowserFactory.webDriver.get().switchTo().frame(BrowserFactory.webDriver.get().findElement(By.xpath("//iframe[contains(@name,'security_code_iframe')]")));
						// Thread.sleep(10000);
						TDL_SLPElectronicsPage.get().cvvCode.click();
//									TDL_SLPElectronicsPage.get().cvvCode.click();
						TDL_SLPElectronicsPage.get().cvvCode.sendKeys("123");
						// BrowserFactory.webDriver.get().switchTo().defaultContent();
						Thread.sleep(5000);
						Thread.sleep(5000);
					}
				}
				// TDL_SLPElectronicsPage.get().debitcard.click();

				if (paymentType.equalsIgnoreCase("Success")) {
					int i = 1;
					while (!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().payBtnnew, 5) && i < 3) {
						gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().payBtnnew);
						i++;
					}
					TDL_SLPElectronicsPage.get().payBtnnew.click();
					Thread.sleep(3000);
					// Enter OTP on Payment Screen
					ClickAxisPasswordCroma();

					// Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed payment using Debit card",
							"Successfully completed payment using Debit card ", 1);
				} else {
					TDL_SLPElectronicsPage.get().payBtnnew.click();
					TDL_SLPElectronicsPage.get().failPayment.click();
					Thread.sleep(3000);
					fUtil.flogResult("Passed", "Successfully completed Failure payment Debit card using credit card",
							"Successfully completed payment on failure case using Debit card", 1);
				}
			} else {
				fUtil.flogResult("Failed", "Validate Debit card payment", "Debit card payment failed", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	// Method for InternetBanking//
	@Test
	public void validateInternetBanking() throws Exception {
		try {
			String paymentType = fUtil.fgetDataNew1("payment_type");
			String brand = fUtil.fgetDataNew1("SLP");
			int i = 1;
			while (!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().NetBanking_TPM, 5) && i < 3) {
				gmethods.scrollToViewElement(TDL_SLPElectronicsPage.get().NetBanking_TPM);
				i++;
			}

			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().NetBanking_TPM, 15)) {
				TDL_SLPElectronicsPage.get().NetBanking_TPM.click();
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().chnagePayment, 5))
					TDL_SLPElectronicsPage.get().chnagePayment.click();
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().netbanking_first_bank, 10)) {
					JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.webDriver.get();
					js.executeScript("arguments[0].click();", TDL_SLPElectronicsPage.get().netbanking_first_bank);
//								TDL_SLPElectronicsPage.get().netbanking_first_bank.click();
					Thread.sleep(3000);
					if (paymentType.equalsIgnoreCase("Success")) {
						if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().NetBankingSucces_TPM, 40)) {
							TDL_SLPElectronicsPage.get().NetBankingSucces_TPM.click();
							// Thread.sleep(10000);

							fUtil.flogResult("Passed", "Successfully completed payment",
									"Successfully completed payment", 1);
						}

					} else if (paymentType.equalsIgnoreCase("Abort")) {
						// String url = fUtil.fgetDataNew1("URL").trim();
						browserFactory.get().getDriver()
								.get("https://aem-sit-r2.tatadigital.com/payment/order-history");

						if (gmethods.isElementVisible(TdlOrderHistoryPage.get().order_tab, 20)) {
							logger.info("Navigated to Order History Page");
							fUtil.flogResult("Passed", "Navigate to Order History Page", "Navigated Succesfully", 1);
						}

						else {
							logger.info(
									"Order tab is not available as not navigation to Order History page is unsuccessfull");
							fUtil.flogResult("Failed", "Navigate to Order History Page", "Order tab is not identified",
									1);
						}
					} else {
						TDL_SLPElectronicsPage.get().failPayment.click();
						Thread.sleep(3000);
						fUtil.flogResult("Passed", "Successfully completed Failure payment",
								"Successfully completed payment on failure case", 1);
					}
				} else
					fUtil.flogResult("Failed", "Validate Internet Banking",
							"No banks available under Internet Banking failed", 1);
			} else
				fUtil.flogResult("Failed", "Validate Internet Banking", "Internet Banking failed", 1);
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	// Method for UPI payment//
	@Test
	public void validateUPI() throws Exception {
		try {
			String paymentType = fUtil.fgetDataNew1("payment_type");

			JavascriptExecutor jse1 = (JavascriptExecutor) browserFactory.get().getDriver();
			WebElement shadowRoot = (WebElement) jse1.executeScript(
					"return document.querySelector('#app > div.Flex__Box-gYjQok.hsKFna > div > section.sc-bxDcbH.jvTPEt > div:nth-child(2) > label > svg > g > g > g > path')");

			if (gmethods.isElementVisible(shadowRoot, 20)) {
				shadowRoot.click();
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().payBtn, 20)) {
					logger.info("upi pay btn is actvated");
					fUtil.flogResult("Passed", "pay btn",
							"activated, which is : " + TDL_SLPElectronicsPage.get().payBtn.getText().trim(), 1);
					TDL_SLPElectronicsPage.get().payBtn.click();
					fUtil.flogResult("Passed", "Validate payment successs in UPI",
							"Successfully completed payment  using UPI", 1);
				}
			} else
				fUtil.flogResult("Failed", "Validate UPI payment", "UPI payment failed", 1);
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	// Method for Loyalty//
	@Test
	public void validateLoyalty() throws Exception {
		try {
			String LoyaltyPoints = fUtil.fgetDataNew1("Tcppoints_cutoff");
//						String paymentType=fUtil.fgetDataNew1("payment_type");
			Thread.sleep(10000);
			Thread.sleep(10000);
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().PAymentMethod_TPM, 15)) {

				if (gmethods.isElementVisible(TdlCromaCard.get().totalCartAmt, 30)) {

					String totalTransactionAmount = TdlCromaCard.get().totalCartAmt.getText().replace("\u20B9", "")
							.trim();
					totalCartAmount = DecimalFormat.getNumberInstance().parse(totalTransactionAmount).doubleValue();
					System.out.println(totalCartAmount);
					fUtil.flogResult("Passed", "Enter Payment Page Details in TPM  ",
							"Payment Page loaded in TPM successfully and Total Cart Amount is " + totalCartAmount, 1);

				}
			}
			if (gmethods.isElementVisible(TdlCromaCard.get().tcpPoints_checkbox, 30)) {
				clickUsingActionsClass(TdlCromaCard.get().tcpPoints_checkbox);
//							TDL_SLPElectronicsPage.get().tcpPoints_checkbox.click();
				Thread.sleep(1000);
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().edit_tcpPoints, 30)) {
					TDL_SLPElectronicsPage.get().edit_tcpPoints.click();
					fUtil.flogResult("Passed", "Edit Tcp Points page is present", "Edit Tcp Points page is present", 1);
				}
				Thread.sleep(4000);
				TDL_SLPElectronicsPage.get().tcpLoyalityAmount.click();
				Thread.sleep(4000);
				TDL_SLPElectronicsPage.get().tcpLoyalityAmount.clear();
				Thread.sleep(4000);
				TDL_SLPElectronicsPage.get().tcpLoyalityAmount.sendKeys(LoyaltyPoints);
				Thread.sleep(4000);
				TDL_SLPElectronicsPage.get().tcpLoyalitybutton.click();
				Thread.sleep(4000);
			} else
				fUtil.flogResult("Failed", "Validate TCP Point payment", "TCP Point payment failed", 1);

		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	public void clickUsingJS(WebElement e) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.webDriver.get();
		js.executeScript("arguments[0].click();", e);
	}

	public void clickUsingActionsClass(WebElement e) throws Exception {
		Actions action = new Actions(BrowserFactory.webDriver.get());
		action.moveToElement(e).click().build().perform();
	}

	@Test
	public void clickPay() throws Exception {
		try {

			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().payBtn, 20)) {
				TDL_SLPElectronicsPage.get().payBtn.click();
				fUtil.flogResult("Passed", "click pay in TPM page", "clicked pay in TPM page", 1);
			} else {
				fUtil.flogResult("Failed", "click pay in TPM page", "Not clicked pay in TPM page", 1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	// click change in TPM page//
	@Test
	public void clicKchange() throws Exception {
		try {

			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().PAymentchangeTPM, 5)) {
				TDL_SLPElectronicsPage.get().PAymentchangeTPM.click();
				fUtil.flogResult("Passed", "click pay in TPM page", "clicked pay in TPM page", 1);
			}
			/*
			 * else { fUtil.flogResult("Failed", "click pay in TPM page",
			 * "Not clicked pay in TPM page", 1); }
			 */
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	@Test
	public void ClickAxisPasswordCroma() throws Exception {
		try {

			boolean pay = gmethods.isElementVisible(TDL_SLPElectronicsPage.get().Password, 20);
			if (pay == true) {
				TDL_SLPElectronicsPage.get().Password.sendKeys("123456");
				Thread.sleep(2000);
				TDL_SLPElectronicsPage.get().Pay.click();
				fUtil.flogResult("Passed", "click pay in Axis simulator croma page",
						"clicked pay in Axis simulator croma page successfully", 1);
				Thread.sleep(10000);
			} else if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().successPayment, 40)) {
				TDL_SLPElectronicsPage.get().successPayment.click();
				fUtil.flogResult("Passed", "click pay in Axis simulator croma page",
						"clicked pay in Axis simulator croma page successfully", 1);
			} else {
				fUtil.flogResult("Failed", "click pay in Axis simulator croma page",
						"Not clicked pay Axis simulator in croma page", 1);
			}
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			DateFormat dateformat = new SimpleDateFormat("dd/MM/yy | hh:mm aa");
			String currentTimeStamp = dateformat.format(timestamp);
			System.out.println("TimeStamp in Axis Simulator: " + currentTimeStamp);

		} catch (Exception e) {
			fUtil.flogResult("Failed", "click pay in Axis simulator croma page",
					"Not clicked pay in Axis simulator croma page failed due to:" + e.getMessage(), 1);
		}
	}

	public void switchToNewTab() throws Exception {
		try {
			Thread.sleep(5000);
			Set<String> handles = BrowserFactory.webDriver.get().getWindowHandles();
			int tabNumber = handles.size() - 1;
			if (handles.size() > tabNumber) {
				BrowserFactory.webDriver.get().switchTo().window((String) handles.toArray()[tabNumber]);
				System.out.println("Switched to Tab " + tabNumber);
			} else {
				fUtil.flogResult("Failed", "Validate switching to Tab: " + (tabNumber + 1), "Tab not present", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Switching Tab", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	public boolean scrollToBottom() throws Exception {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.webDriver.get();
			executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// My Orders
	@Test
	public void navigateToMyOrder() throws Exception {
		try {

			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().hamburger, 30)) {
				TDL_SLPElectronicsPage.get().hamburger.click();
				fUtil.flogResult("Passed", "click hamburger icon", "clicked hamburger icon", 1);
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().myOrders, 20)) {
					TDL_SLPElectronicsPage.get().myOrders.click();
					fUtil.flogResult("Passed", "click My Orders", "clicked My Orders", 1);
				} else {
					fUtil.flogResult("Failed", "click My Orders", "No My Orders", 1);
				}
			} else {
				fUtil.flogResult("Failed", "click hamburger icon", "Not navigated to homepage", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "click My Orders", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void getOrderIDFromMyOrders() throws Exception {
		try {
			String SLP = fUtil.fgetDataNew1("SLP");
			Thread.sleep(5000);
			String xpath = "//*[contains(text(),'" + SLP + "')]";
			WebElement element = driver.findElement(By.xpath(xpath));
			if (gmethods.isElementVisible(element, 10)) {
				gmethods.highlightElement(element);
				fUtil.flogResult("Passed", "Validate Orders Section from My Orders",
						"Clicked Order Section: " + element.getText(), 1);
				element.click();
				// First Order ID
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().myOrdersFirstOrderID, 20)) {
					String orderID = TDL_SLPElectronicsPage.get().myOrdersFirstOrderID.getText();
					gmethods.highlightElement(TDL_SLPElectronicsPage.get().myOrdersFirstOrderID);
					fUtil.flogResult("Passed", "Get First Order ID from My orders",
							"My Orders, first order ID: " + orderID, 1);
				}
			} else
				fUtil.flogResult("Failed", "Validate Orders Section from My Orders", "NO Order Section: " + SLP, 1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void plpPageVisibilityOfProductImages() throws Exception {
		try {

			List<WebElement> productList = NCOM_HomePage_Web.get().productImages;
			for (WebElement p : productList) {
				if (gmethods.isElementVisible(p, 10)) {
					gmethods.scrollToViewElement(p);

					fUtil.flogResult("Passed", "Products Should be Visible", "Product is Visible ", 1);
				} else
					fUtil.flogResult("Failed", "Products Should be Visible", "Product is not Visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Visibility of All Products on PLP Page",
					"Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void plp_Page_Validation_Of_price_By_SortFun_Descending() throws Exception {
		try {
			// before applying filter Capture the prices and make them in the ascending
			// order
			List<WebElement> beforeSortPrice = NCOM_HomePage_Web.get().price_web;
			// remove the rupees symbol from the price and convert the string into double
			List<Double> beforeSortPriceList = new ArrayList<>();
			for (WebElement p : beforeSortPrice) {
				beforeSortPriceList.add(Double.valueOf(p.getText().replace("\u20B9", "").replace(",", "")));
			}

			// sort the values in ascending order
			Collections.sort(beforeSortPriceList);

			Collections.reverse(beforeSortPriceList);// descending Order
			fUtil.flogResult("Passed", "Prices in Desce Order", "Prices in Desce Order are :" + beforeSortPriceList, 1);

			// click Sort By Button
			if (gmethods.isElementVisible(NCOM_HomePage_Web.get().sortByButton_web, 10)) {

				clickUsingJS(NCOM_HomePage_Web.get().sortByButton_web);

				// NCOM_HomePage_Web.get().sortByButton_web.click();

				fUtil.flogResult("Passed", "Sort By Button Should be click", "Sort By button is Clicked ", 1);
			} else
				fUtil.flogResult("Failed", "Sort By Button Should be click", "Sort By button is not Clicked", 1);

			// click Highest First Button
			if (gmethods.isElementVisible(NCOM_HomePage_Web.get().highestFirst_web, 10)) {

				clickUsingJS(NCOM_HomePage_Web.get().highestFirst_web);

				// NCOM_HomePage_Web.get().highestFirst_web.click();

				Thread.sleep(3000);

				fUtil.flogResult("Passed", "Highest First Button Should be click", "Highest First button is Clicked ",
						1);
			} else
				fUtil.flogResult("Failed", "Highest First Button Should be click",
						"Highest First button is not Clicked", 1);

			// After Filter Capture the prices
			List<WebElement> afterSortPrice = NCOM_HomePage_Web.get().price_web;

			// remove the rupees symbol from the price and conver the string into double
			List<Double> afterSortPriceList = new ArrayList<>();
			for (WebElement p : afterSortPrice) {
				afterSortPriceList.add(Double.valueOf(p.getText().replace("\u20B9", "").replace(",", "")));
			}

			fUtil.flogResult("Passed", "Prices After Sort", "Prices After Sort are :" + afterSortPriceList, 1);

			if (beforeSortPriceList.equals(afterSortPriceList)) {
				logger.info("Prices after and before prices are matched");
				fUtil.flogResult("Passed", "Prices are as per the Sort", "Prices should be as per the Sort", 1);

			} else {
				logger.info("Prices after and before Sort are not matched");
				fUtil.flogResult("Failed", "Prices are not as per the Sort", "Prices should be as per the Sort", 1);

			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Sort By Fun on PLP Page", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void plp_Page_Validation_Of_price_By_SortFun_Ascending() throws Exception {
		try {
			// before applying filter Capture the prices and make them in the ascending
			// order
			List<WebElement> beforeSortPrice = NCOM_HomePage_Web.get().price_web;
			// remove the rupees symbol from the price and convert the string into double
			List<Double> beforeSortPriceList = new ArrayList<>();
			for (WebElement p : beforeSortPrice) {
				beforeSortPriceList.add(Double.valueOf(p.getText().replace("\u20B9", "").replace(",", "")));
			}

			// sort the values in ascending order

			Collections.sort(beforeSortPriceList);
			fUtil.flogResult("Passed", "Prices in Asce order", "Prices in Asce order are :" + beforeSortPriceList, 1);
			Collections.sort(beforeSortPriceList);
			fUtil.flogResult("Passed", "Prices in Asce order", "Prices in Asce order are :" + beforeSortPriceList, 1);

			// click Sort By Button
			if (gmethods.isElementVisible(NCOM_HomePage_Web.get().sortByButton_web, 10)) {

				clickUsingJS(NCOM_HomePage_Web.get().sortByButton_web);

				// NCOM_HomePage_Web.get().sortByButton_web.click();

				fUtil.flogResult("Passed", "Sort By Button Should be click", "Sort By button is Clicked ", 1);
			} else
				fUtil.flogResult("Failed", "Sort By Button Should be click", "Sort By button is not Clicked", 1);

			// click lowestFirst_web Button
			if (gmethods.isElementVisible(NCOM_HomePage_Web.get().lowestFirst_web, 10)) {

				clickUsingJS(NCOM_HomePage_Web.get().lowestFirst_web);

				// NCOM_HomePage_Web.get().lowestFirst_web.click();

				Thread.sleep(3000);

				fUtil.flogResult("Passed", "Lowest First Button Should be click", "Lowest First button is Clicked ", 1);
			} else
				fUtil.flogResult("Failed", "Lowest First Button Should be click", "Lowest First button is not Clicked",
						1);

			// After Filter Capture the prices
			List<WebElement> afterSortPrice = NCOM_HomePage_Web.get().price_web;

			// remove the rupees symbol from the price and conver the string into double
			List<Double> afterSortPriceList = new ArrayList<>();
			for (WebElement p : afterSortPrice) {
				afterSortPriceList.add(Double.valueOf(p.getText().replace("\u20B9", "").replace(",", "")));
			}

			fUtil.flogResult("Passed", "Prices After Sort", "Prices After Sort are :" + afterSortPriceList, 1);

			if (beforeSortPriceList.equals(afterSortPriceList)) {
				logger.info("Prices after and before prices are matched");
				fUtil.flogResult("Passed", "Prices are as per the Sort", "Prices should be as per the Sort", 1);

			} else {
				logger.info("Prices after and before Sort are not matched");
				fUtil.flogResult("Failed", "Prices are not as per the Sort", "Prices should be as per the Sort", 1);

			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Sort By Fun on PLP Page", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	private static String readData(String input) {
		try {
			return fUtil.fgetDataNew1(input);
		} catch (Exception e) {
			return "";
		}
	}

	@Test
	public void promisedCoinsEarn() throws Exception {
		try {
			String paymentmethod = fUtil.fgetDataNew1("payment_method");
			String tcpPoints = readData("Tcppoints_cutoff").trim();
			double pointsUsed = 0;

			if (paymentmethod.equalsIgnoreCase("TCPPoints")) {
				expectedEarnPromisedPoints = 0.0;
				fUtil.flogResult("Passed", "Earned promised Neucoins Calculation ",
						"Expected Neucoins for Tender mode as NEUCOINS only is:" + expectedEarnPromisedPoints, 1);
			} else {
				pointsUsed = Double.parseDouble(tcpPoints);
				double expectedPoints = (totalCartAmount - pointsUsed) * 0.05;
				expectedEarnPromisedPoints = Math.round(expectedPoints);
				if (pointsUsed == 0) {
					fUtil.flogResult("Passed", "Earned promised Neucoins Calculation ",
							"Expected Neucoins for the Single eligible Tender mode " + paymentmethod.toUpperCase()
									+ " is:" + expectedEarnPromisedPoints,
							1);
				} else {
					fUtil.flogResult("Passed", "Earned promised Neucoins Calculation ",
							"Expected Neucoins for the MultiTender mode NEUCOINS and " + paymentmethod.toUpperCase()
									+ " is:" + expectedEarnPromisedPoints,
							1);
				}

			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Function : expectedPointsEarn ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	@Test
	public void visibilityOfProductName() throws Exception {
		try {
			List<WebElement> productNames = NCOM_HomePage_Web.get().productDesc;
			for (WebElement p : productNames) {
				if (gmethods.isElementVisible(p, 10)) {
					gmethods.scrollToViewElement(p);

					fUtil.flogResult("Passed", "Product Name Should be Visible", "Product Name is Visible ", 1);
				} else
					fUtil.flogResult("Failed", "Product Name Should be Visible", "Product Name is not Visible", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void visibilityOfMRP() throws Exception {
		try {
			List<WebElement> MRP = NCOM_HomePage_Web.get().price_web;
			for (WebElement p : MRP) {
				if (gmethods.isElementVisible(p, 10)) {
					gmethods.scrollToViewElement(p);

					fUtil.flogResult("Passed", "MRP Should be Visible", "MRP is Visible ", 1);
				} else
					fUtil.flogResult("Failed", "MRP Should be Visible", "MRP is not Visible", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void visibilityOfNeuCoins() throws Exception {
		try {
			List<WebElement> Neucoins = NCOM_HomePage_Web.get().neuCoins;
			for (WebElement p : Neucoins) {
				if (gmethods.isElementVisible(p, 10)) {
					gmethods.scrollToViewElement(p);

					fUtil.flogResult("Passed", "Neucoins Should be Visible", "Neucoins is Visible ", 1);
				} else
					fUtil.flogResult("Failed", "Neucoins Should be Visible", "Neucoins is not Visible", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void visibilityOfBackBtn() throws Exception {
		try {
			if (gmethods.isElementVisible(NCOM_HomePage_Web.get().backBtn, 10)) {

				fUtil.flogResult("Passed", "Back button should be visible", "Back button is visible", 1);
				Thread.sleep(5000);
			} else {
				fUtil.flogResult("Failed", "Validate visibility of back button ", "Back button  not found", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void visibilityOfAddressIcon() throws Exception {
		try {
			if (gmethods.isElementVisible(NCOM_HomePage_Web.get().addressicon, 10)) {

				fUtil.flogResult("Passed", "addressicon  should be visible", "addressicon is visible", 1);
				Thread.sleep(5000);
			} else {
				fUtil.flogResult("Failed", "Validate visibility of addressicon ", "addressicon  not found", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void Cart_Product_Verification() throws Exception { 
		clickUsingJS(NCOM_PDP_Web.get().goToCartBtn);
		List<WebElement> items = NCOM_PDP_Web.get().productImages;
		for (WebElement p : items) {
			if (gmethods.isElementVisible(p, 10)) {
				fUtil.flogResult("Passed", "Product is visible in the cart", "Product should be visible if added", 1);
			} else {
				fUtil.flogResult("Failed", "Product is not visible in the cart", "Product should be visible if added",
						1);
			}
			List<WebElement> products = NCOM_PDP_Web.get().productsDescriptionInCart;
			for (WebElement product : products) {
				if (!(product.getText() == null)) {
					fUtil.flogResult("Passed", "Product name is proper visible", "Product name should be visible", 1);
				} else {
					fUtil.flogResult("Failed", "Product name is not visible", "Product name should be visible", 1);
				}
			}
		}
	}

	@Test
	public void Cart_Total_Amount_Validation() throws Exception {
		// Removing Rs. sign and conversion of string to int
		clickUsingJS(NCOM_PDP_Web.get().cartIcon);
		if (gmethods.isElementVisible(NCOM_PDP_Web.get().productImages.get(0), 10)) {
			fUtil.flogResult("Passed", "Actual price and cart total is equal",
					"cart total and difference between order" + " total and discount should be match ", 1);
		}else {
			fUtil.flogResult("Failed", "Actual price and cart total is equal",
					"cart total and difference between order" + " total and discount should be match ", 1);
		}
		String stringPrice = NCOM_PDP_Web.get().itemsPriceInCart.getText().replace("\u20B9", "").replace(",", "");
		int intPrice = Integer.parseInt(stringPrice);
		String stringDiscount = NCOM_PDP_Web.get().discountInCart.getText().replace("\u20B9", "").replace(",", "");
		int intDiscount = Integer.parseInt(stringDiscount);
		String stringCartTotal = NCOM_PDP_Web.get().cartTotal.getText().replace("\u20B9", "").replace(",", "");
		int intCartTotal = Integer.parseInt(stringCartTotal);
		String stringDeliveryPrice = NCOM_PDP_Web.get().deliveryPrice.getText().replace("\u20B9", "").replace(",", "");
		int intDeliveryPrice = Integer.parseInt(stringDeliveryPrice);
		

		// Verify total price-discount=cart total
		if (stringDeliveryPrice == "Free") {
			int actualPrice = intPrice - intDiscount;
			if (actualPrice == intCartTotal) {
				fUtil.flogResult("Passed", "Actual price and cart total is equal",
						"cart total and difference between order" + " total and discount should be match ", 1);
			} else {
				fUtil.flogResult("Failed", "Actual price and cart total is not equal",
						"cart total and difference between order" + " total and discount should be match ", 1);
			}
		} else {

			int intCartTotalAmount = intPrice - intDiscount + intDeliveryPrice;
			logger.info("Total amount of cart is: " + intCartTotalAmount);

		}

	}

	@Test
	public void calculatePercentage() throws Exception {
		try {

			Thread.sleep(3000);
			NCOM_HomePage_Web.get().changeIcon.click();
			NCOM_HomePage_Web.get().default1.click();
			Thread.sleep(5000);

			if (gmethods.isElementVisible(NCOM_HomePage_Web.get().retry, 10)) {
				NCOM_HomePage_Web.get().retry.click();

				Thread.sleep(5000);
			} else {
				fUtil.flogResult("Failed", "Validate visibility of retry button ", "retry  not found", 1);
			}

			Thread.sleep(5000);
			List<WebElement> actualPrice = NCOM_HomePage_Web.get().price_web;
			List<Double> actualPriceList = new ArrayList<>();
			for (WebElement p : actualPrice) {
				if (gmethods.isElementVisible(p, 10)) {
					actualPriceList.add(Double.valueOf(p.getText().replace("\u20B9", "").replace(",", "")));
					System.out.println(actualPriceList);

					fUtil.flogResult("Passed", "actualPrice Should be Visible", "actualPrice is Visible ", 1);
				} else
					fUtil.flogResult("Failed", "actualPrice Should be Visible", "actualPrice is not Visible", 1);

			}

			Thread.sleep(5000);
			List<WebElement> mrpPrice = NCOM_HomePage_Web.get().mrp;
			List<Double> mrpPriceList = new ArrayList<>();
			for (WebElement p : mrpPrice) {
				if (gmethods.isElementVisible(p, 10)) {
					mrpPriceList.add(Double.valueOf(p.getText().replace("\u20B9", "").replace(",", "")));

					System.out.println(mrpPriceList);
					fUtil.flogResult("Passed", "mrpPrice Should be Visible", "mrpPrice is Visible ", 1);
				} else
					fUtil.flogResult("Failed", "mrpPrice Should be Visible", "mrpPrice is not Visible", 1);
			}

			Thread.sleep(5000);
			List<WebElement> percent = NCOM_HomePage_Web.get().percentage;
			List<Double> percentList = new ArrayList<>();
			for (WebElement p : percent) {
				if (gmethods.isElementVisible(p, 10)) {
					percentList.add(Double.valueOf(p.getText().replace("%", "").replace("off", "").replace("(", "")
							.replace(")", "").replace(" ", "")));

					System.out.println(percentList);
					fUtil.flogResult("Passed", "percent Should be Visible", "percent is Visible ", 1);
				} else
					fUtil.flogResult("Failed", "percent Should be Visible", "percent is not Visible", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Visibility of All Products on PLP Page",
					"Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void product_Verification_PDP() throws Exception {
		// click on first product of PLP
		clickUsingJS(NCOM_PLP_Web.get().productImages.get(0));
		try {
			boolean productDescription = gmethods.isElementVisible(NCOM_PDP_Web.get().productDescriptionPDP, 10);
			boolean productOverview = gmethods.isElementVisible(NCOM_PDP_Web.get().productOverviewPDP, 10);
			boolean productKeyFeatures = gmethods.isElementVisible(NCOM_PDP_Web.get().productKeyFeaturesPDP, 10);
			boolean productSpecifications = gmethods.isElementVisible(NCOM_PDP_Web.get().productSpecificationsPDP, 10);

			if (productDescription && productOverview && productKeyFeatures && productSpecifications == true) {
				fUtil.flogResult("Passed", "Product information i.e. description, overview, Key features, "
						+ "specifications properly present", "Product information should properly present", 1);
			} else {
				fUtil.flogResult("Failed", "Product information is not displyed properly",
						"Product information should properly present", 1);
			}

			// Product price validation with discount
			int intPrice = Integer.parseInt(NCOM_PDP_Web.get().productPricePDP.getText().replace("\u20B9", "").replace(",", ""));
			int intWithoutDiscountPercent = Integer.parseInt(NCOM_PDP_Web.get().
					productDiscountPercentPDP.getText().replace("%", "").replace("off", "").replace("(", "")
					.replace(")", ""));
			int intWithoutDiscountPrice = Integer.parseInt(NCOM_PDP_Web.get().productPriceWithoutDiscountPDP.getText()
					.replace("\u20B9", "").replace(",", ""));
			float percentage = (float)((intWithoutDiscountPrice/intPrice) * 100);
			int i = (int) percentage;
			
			if(intWithoutDiscountPercent == i) {
				fUtil.flogResult("Passed", "Discounted price is displayed as per given percentage", 
						"Discounted price should be display according to given discount", 1);
			}else {
				fUtil.flogResult("Failed", "Discounted price is not displayed as per given percentage", 
						"Discounted price should be display according to given discount", 1);
			}
			
			
			// NeuCoins Validation
			boolean neuCoins = gmethods.isElementVisible(NCOM_PDP_Web.get().earnNeuCoinsPDP, 10);

			if (neuCoins == true) {
				int intNeucoins = Integer.parseInt(NCOM_PDP_Web.get().earnNeuCoinsPDP.getText());
				if (intNeucoins == (intPrice * 5) / 100) {
					fUtil.flogResult("Passed", "Earn NeuCoins are 5% of product price",
							"Earn Neucoins value should be 5% of product price", 1);
				} else {
					fUtil.flogResult("Failed", "Earn NeuCoins are not 5% of product price",
							"Earn Neucoins value should be 5% of product price", 1);
				}

			} else {
				fUtil.flogResult("Failed", "NeuCoins are not present", "NeuCoins should be present", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Something is missing in product description",
					"Product information should properly present", 1);
		}

	}
	
	 @Test
		public void prcentageDiscountFilter() throws Exception {
			try {
				int filteredDiscount=0;
				if (gmethods.isElementVisible(NCOM_PLP_Web.get().filtersHdr, 10)) {
					fUtil.flogResult("Passed", "Fiters Header", "Fiters Header is visible", 1);
					if (gmethods.isElementVisible(NCOM_PLP_Web.get().discountPercentFilterLabel, 10)) {
						fUtil.flogResult("Passed", "Discount PercentageFilter", "Discount Percentage Filter is  visible",
								1);
						// Clicking Discount
						clickUsingJS(NCOM_PLP_Web.get().discountPercentFilterLabel);
						if (gmethods.isElementVisible(NCOM_PLP_Web.get().selectedDiscountPercent, 10)) {
							fUtil.flogResult("Passed", "Discount PercentageFilter",
									"Discount Percentage Filter is  visible and default selection is "
											+ NCOM_PLP_Web.get().selectedDiscountPercent.getText(),
									1);
							// Checking percentage discount filter
							int selectionPoints = NCOM_PLP_Web.get().discountSelector.size() - 1;
							for (int i = 1; i < selectionPoints; i++) {
								String xpath = "//span[text()='Discount Percentage']/following::span[@data-index=" + i
										+ "]";
								WebElement element = BrowserFactory.webDriver.get().findElement(By.xpath(xpath));
								if (gmethods.isElementVisible(element, 10)) {
									element.click();
									//clickUsingJS(element);
									//clickUsingActionsClass(element);
								}
								boolean flag = false;
								try {
									// String
									// dis=NCOM_PLP_Web.get().selectedDiscountPercent.getText().split("%")[0].trim();
									int selectedDiscountPercent = Integer.parseInt(
											NCOM_PLP_Web.get().selectedDiscountPercent.getText().split("%")[0].trim());
									for (WebElement p : NCOM_PLP_Web.get().discountPercentageValue) {
										filteredDiscount = Integer
												.parseInt(p.getText().split("%")[0].replace("(", "").trim());
										if (filteredDiscount >= selectedDiscountPercent) {
											System.out.println("Filter is correctly applied");
										} else {
											flag = true;
											System.err.println("Filter is not correctly applied");
											fUtil.flogResult("Failed", "Discount PercentageFilter",
													"Discount Percentage Filter is not applied correctly as selected filter is "
															+ selectedDiscountPercent
															+ " and filtered discount for product is " + filteredDiscount,
													1);
											break;
										}
									}

								} catch (Exception e) {
									flag = true;
									fUtil.flogResult("Failed", "Discount PercentageFilter",
											"Discount Percentage Filter is not applied correctly for selected filter "
													+ NCOM_PLP_Web.get().selectedDiscountPercent.getText(),
											1);
								}
								if (flag == false) {
									fUtil.flogResult("Passed", "Discount PercentageFilter",
											"Discount Percentage Filter is  applied correctly for selected filter "
													+ NCOM_PLP_Web.get().selectedDiscountPercent.getText(),
											1);
								}

							}

						}

					} else {
						fUtil.flogResult("Failed", "Discount PercentageFilter", "Discount Percentage Filter is not visible",
								1);
					}
				} else {
					fUtil.flogResult("Failed", "Fiters Header", "Fiters Header is not visible", 1);
				}

			} catch (Exception e) {
				fUtil.flogResult("Failed", "Discount PercentageFilter",
						"Discount Percentage Filter check failed due to an exception " + e, 1);
			}

		}
	    //Need to Unit Test
	    @Test
	   	public void priceRangeDiscountFilter() throws Exception {
	   		try {
	   			int filteredDiscount=0;
	   			if (gmethods.isElementVisible(NCOM_PLP_Web.get().filtersHdr, 10)) {
	   				fUtil.flogResult("Passed", "Fiters Header", "Fiters Header is visible", 1);
	   				if (gmethods.isElementVisible(NCOM_PLP_Web.get().discountPriceFilterLabel, 10)) {
	   					fUtil.flogResult("Passed", "Discount Price Filter", "Discount Price Filter is  visible",
	   							1);
	   					// Clicking Discount
	   					clickUsingJS(NCOM_PLP_Web.get().discountPriceFilterLabel);
	   					if (gmethods.isElementVisible(NCOM_PLP_Web.get().selectedDiscountPriceRange, 10)) {
	   						fUtil.flogResult("Passed", "Discount Price Filter",
	   								"Discount Price Filter is  visible and default selection is "
	   										+ NCOM_PLP_Web.get().selectedDiscountPriceRange.getText(),
	   								1);
	   						// Checking percentage discount filter
	   						int selectionPoints = NCOM_PLP_Web.get().discountSelector.size() - 4;
	   						for (int i = 2; i < selectionPoints; i++) {
	   							String xpath = "//span[text()='Discount Price']/following::span[@data-index=" + i
	   									+ "]";
	   							WebElement element = BrowserFactory.webDriver.get().findElement(By.xpath(xpath));
	   							if (gmethods.isElementVisible(element, 10)) {
	   								element.click();
	   								//clickUsingJS(element);
	   								//clickUsingActionsClass(element);
	   							}
	   							boolean flag = false;
	   							try {
	   								// String
	   								// dis=NCOM_PLP_Web.get().selectedDiscountPercent.getText().split("%")[0].trim();
	   								int selectedDiscountPercent = Integer.parseInt(
	   										NCOM_PLP_Web.get().selectedDiscountPercent.getText().split("%")[0].trim());
	   								for (WebElement p : NCOM_PLP_Web.get().discountPercentageValue) {
	   									filteredDiscount = Integer
	   											.parseInt(p.getText().split("%")[0].replace("(", "").trim());
	   									if (filteredDiscount >= selectedDiscountPercent) {
	   										System.out.println("Filter is correctly applied");
	   									} else {
	   										flag = true;
	   										System.err.println("Filter is not correctly applied");
	   										fUtil.flogResult("Failed", "Discount PercentageFilter",
	   												"Discount Percentage Filter is not applied correctly as selected filter is "
	   														+ selectedDiscountPercent
	   														+ " and filtered discount for product is " + filteredDiscount,
	   												1);
	   										break;
	   									}
	   								}

	   							} catch (Exception e) {
	   								flag = true;
	   								fUtil.flogResult("Failed", "Discount PercentageFilter",
	   										"Discount Percentage Filter is not applied correctly for selected filter "
	   												+ NCOM_PLP_Web.get().selectedDiscountPercent.getText(),
	   										1);
	   							}
	   							if (flag == false) {
	   								fUtil.flogResult("Passed", "Discount PercentageFilter",
	   										"Discount Percentage Filter is  applied correctly for selected filter "
	   												+ NCOM_PLP_Web.get().selectedDiscountPercent.getText(),
	   										1);
	   							}

	   						}

	   					}

	   				} else {
	   					fUtil.flogResult("Failed", "Discount PercentageFilter", "Discount Percentage Filter is not visible",
	   							1);
	   				}
	   			} else {
	   				fUtil.flogResult("Failed", "Fiters Header", "Fiters Header is not visible", 1);
	   			}

	   		} catch (Exception e) {
	   			fUtil.flogResult("Failed", "Discount PercentageFilter",
	   					"Discount Percentage Filter check failed due to an exception " + e, 1);
	   		}

	   	}

}
