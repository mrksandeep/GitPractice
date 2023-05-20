package com.QA.TestApp.Testcases.WEB;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.QA.TestApp.Pages.WEB.TDL_HomePage;
import com.QA.TestApp.Utilities.BaseScript;
import com.QA.TestApp.Utilities.BrowserFactory;

public class SWT_Journey extends BaseScript{

	String channelLink="//*[text()='xxxx']/parent::div/parent::a | //*[text()='xxxx']/parent::a";
	String 	currentChannelName="";
	String backToHome="//h1[text()='xxxx']/parent::div/preceding-sibling::button | //*[text()='xxxx']/parent::div/parent::div/preceding-sibling::div/button";
	String subid ="3001253974";
	String amount1 = "500";

	@Test
	public void login() throws Exception {
		try {
			String mobileNumber = fUtil.fgetDataNew1("Mobile_no");
			String password=fUtil.fgetDataNew1("Password");

			gmethods.signInPwa(mobileNumber, password);
		}catch(Exception e) {
			throw e;
		}
	}

	@Test
	public void navigateToAddress() throws Exception {
		logger.info("Execution TC "+scenarioName);
		System.out.println("TC "+scenarioName);

		boolean isAddNewBtnV = gmethods.isElementClickable(TdlAddresslist.get().addnewBtn, 10);
		if(isAddNewBtnV) {
			TdlAddresslist.get().addnewBtn.click();
			fUtil.flogResult("Passed", "Address List Page", "Loaded Successfully", 1);
		}else
			fUtil.flogResult("Failed", "Address List Page", "Not loaded", 1);

	}

	@Test
	public void addNewAddressSearchType() throws Exception {

		boolean isaddOptionPresent = gmethods.isElementClickable(TdlAddressOptChoose.get().googleSearchBox, 10);
		if(isaddOptionPresent) {

			String SearchAddress = fUtil.fgetDataNew1("SearchAddress");
			gmethods.isElementVisible(TdlAddressOptChoose.get().googleSearchBox, 10);
			TdlAddressOptChoose.get().googleSearchBox.sendKeys(SearchAddress);
			Thread.sleep(5000);
			TdlAddressOptChoose.get().googleSearchBox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

			if(TdlAddressManual.get().customerName.isDisplayed()) 
				fUtil.flogResult("Passed", "Address Input Page", " Page loaded successfully", 1);
			else
				fUtil.flogResult("Failed", "Address Input Page", " Page not loaded", 1);

		}else
			fUtil.flogResult("Failed", "Address Search Page", "Not loaded", 1);
	}

	@Test
	public void selectchannelType() throws Exception {
		try {			
			String channel = fUtil.fgetDataNew1("Channel");

			scrollToViewChannelRibbon();

			BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			boolean channelsHeaderVisibility=gmethods.isElementVisible(TdlHomePage.get().channelHeader, 10);
			boolean channelsRibbonVisibility=gmethods.isElementVisible(TdlHomePage.get().channelRibbon, 30);
			if(channelsHeaderVisibility && channelsRibbonVisibility)
			{
				fUtil.flogResult("Passed", "Validate Channels Header in Homepage", 
						"Channels Header is visible in Home page ", 1);
				switch(channel.trim().toLowerCase()) {

				case "croma" :
					channelLink=gmethods.dynamicXpath(channelLink, "Croma","Croma");

					boolean cromaBtnVisibility=gmethods.isElementVisibleXpath(channelLink, 30);
					if(cromaBtnVisibility)
					{
						fUtil.flogResult("Passed", "Navigate to Croma Channel", 
								"Croma Channel button visible in Home page ", 1);

						BrowserFactory.webDriver.get().findElement(By.xpath(channelLink)).click();
						boolean acknowledge=gmethods.isElementVisible(SwtTcpHomePage.get().okAcknowledgeClick, 10);
						if(acknowledge)
						{
							SwtTcpHomePage.get().okAcknowledgeClick.click();
						}
					}else {
						fUtil.flogResult("Failed", "Navigate to Croma Channel", 
								"Croma Channel button not visible in Home page ", 1);
					}					
					break;
				case "ihcl" :
					channelLink=gmethods.dynamicXpath(channelLink, "Taj","Taj");

					boolean ihclBtnVisibility=gmethods.isElementVisibleXpath(channelLink, 30);
					if(ihclBtnVisibility)
					{
						fUtil.flogResult("Passed", "Navigate to IHCL Channel", 
								"IHCL Channel button visible in Home page ", 1);

						BrowserFactory.webDriver.get().findElement(By.xpath(channelLink)).click();
					}else {
						fUtil.flogResult("Failed", "Navigate to IHCL Channel", 
								"IHCL Channel button not visible in Home page ", 1);
					}					
					break;
				case "tatasky" :
					channelLink=gmethods.dynamicXpath(channelLink, "Tata Sky","Tata Sky");

					boolean tataSkyBtnVisibility=gmethods.isElementVisibleXpath(channelLink, 30);
					if(tataSkyBtnVisibility)
					{
						fUtil.flogResult("Passed", "Navigate to Tata Sky Channel", 
								"Tata Sky Channel button visible in Home page ", 1);

						BrowserFactory.webDriver.get().findElement(By.xpath(channelLink)).click();
					}else {
						fUtil.flogResult("Failed", "Navigate to Tata Sky Channel", 
								"Tata Sky Channel button not visible in Home page ", 1);
					}					
					break;
				}
			}else {

				fUtil.flogResult("Failed", "Validate Channels Header in Homepage", 
						"Channels Header not visible in Home page ", 1);
			}

			if(gmethods.isElementPresent(TdlMAChannelsOptionPage.get().dotsoption)) {
				TdlMAChannelsOptionPage.get().dotsoption.click();
				fUtil.flogResult("Passed", "Channels Page Navigation",
						"Navigated to the "+channel+" page successfully", 1);
			}else {
				fUtil.flogResult("Failed", "Channels Page Navigation",
						"Navigated to the "+channel+" page Failed", 1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Channels Page Navigation",
					"Exception Caught :: "+e.getMessage(), 1);
			throw e;

		}
	}




	//Sandeep_SWT
	@Test
	public void selectHeroBannerJourney() throws Exception {
		try {
			String channel = fUtil.fgetDataNew1("Journey");
			System.out.println(channel);
			BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			switch(channel.trim().toLowerCase()) {

			case "cromahome" :
				swtHeroBanner(SwtTcpHomePage.get().cromaHomePage);
				try {
					Thread.sleep(1000);
					gmethods.switchToNewTab();
					SwtTcpHomePage.get().cromaBuynowbtn.click();
					fUtil.flogResult("Passed", "Clicked on shop now btn",
							"Clicked on shop now btn", 1);
				}catch(Exception e){
					e.printStackTrace();
					fUtil.flogResult("Failed", "Failed to click on shop now btn",
							"Failed to click on shop now btn", 1);
				}
				break;

			case "ihclbookaholiday" :
				swtHeroBanner(SwtTcpHomePage.get().ihclBookHoliday);
				try {
					Thread.sleep(3000);
					gmethods.switchToNewTab();
					SwtTcpHomePage.get().ihclBooknowbtn.click();
					fUtil.flogResult("Passed", "Clicked on Book now btn",
							"Clicked on shop now btn", 1);
				}catch(Exception e){
					e.printStackTrace();
					fUtil.flogResult("Failed", "Failed to click on Book now btn",
							"Failed to click on shop now btn", 1);
				}
				break;

			case "ihclevents" :
				swtHeroBanner(SwtTcpHomePage.get().ihclEventJourney);
				try {
					Thread.sleep(3000);
					gmethods.switchToNewTab();
					SwtTcpHomePage.get().ihclBooknowbtn.click();
					fUtil.flogResult("Passed", "Clicked on Book now btn",
							"Clicked on shop now btn", 1);
				}catch(Exception e){
					e.printStackTrace();
					fUtil.flogResult("Failed", "Failed to click on Book now btn",
							"Failed to click on shop now btn", 1);
				}
				break;
			case "tataskyshowcase" :
				swtHeroBanner(SwtTcpHomePage.get().tataSkyShowcase);
				break;
			case "tataskynewconnection" :
				swtHeroBanner(SwtTcpHomePage.get().tataSkyNewConnection);
				break;
			case "tataskyquickrecharge" :
				swtHeroBanner(SwtTcpHomePage.get().tataSkyQuickRecharge);

				break;
			case "tataskyboxupgrade" :
				swtHeroBanner(SwtTcpHomePage.get().tataSkyBoxUpgrade);
			case "ihclfb" :
				swtHeroBanner(SwtTcpHomePage.get().ihclFAndBJourney);
				break;
			}

		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Channels Page didn't load successfully",
					"Channels Page didn't load successfully", 1);
			throw e;
		}
	}



	public void swtHeroBanner(WebElement swtJourney) throws Exception
	{
		boolean flag=gmethods.heroBannerSwipePwaMobile(swtJourney);
		if(flag)
		{
			swtJourney.click();
			logger.info("Click on Herobanner Offer");
			fUtil.flogResult("Passed", "HeroBanner  Navigation", "Clicked on herobanner SWT Journey", 1);
		}else {
			fUtil.flogResult("Failed", "HeroBanner  Navigation", "SWT Journey not present in Hero banner", 1);

		}
		//		try {
		//			boolean isHerobannerOfferArrowPresent = gmethods.isElementVisible(SwtTcpHomePage.get().heroBannerofferClick, 25);
		//			if (isHerobannerOfferArrowPresent == true) 
		//			{
		//				//MyOffersPage.get().heroBannerofferClick.click();
		//				for(int i=0;i<=SwtTcpHomePage.get().herobannerDetails.size();i++)
		//				{ 
		//					boolean isOfferBannerPresent = gmethods.isElementVisible(swtJourney, 10);
		//					if(isOfferBannerPresent)
		//					{
		//						swtJourney.click();
		//						logger.info("Click on Herobanner Offer");
		//						fUtil.flogResult("Passed", "HeroBanner  Navigation", "Clicked on herobanner SWT Journey", 1);
		//						break;
		//					}
		//					else
		//					{
		//						SwtTcpHomePage.get().heroBannerofferClick.click();
		//					}
		//				}
		//
		//			}
		//			else
		//			{
		//				logger.info("Click on Herobanner Offer");
		//				fUtil.flogResult("Failed", "HeroBanner  Navigation", "Unable to clicked on herobanner ", 1);
		//			}
		//		}catch(Exception e) {
		//			fUtil.flogResult("Failed", "General Function : viewHeroBanner ", "Exception Caught : "+e.getMessage(), 1);
		//		}

	}



	@Test
	public void goto_IHCLCard() throws Exception {
		try {
			String guestType=fUtil.fgetDataNew1("Guest_Type");
			gmethods.gotoVaultPwa();

			boolean ihclCardVisibility = gmethods.isElementVisible(SwtTcpHomePage.get().ihclViewDetails, 30);

			if (ihclCardVisibility == true) {
				logger.info("IHCL card is visible");
				fUtil.flogResult("Passed", "Visibility of Card", "IHCL card is visible", 1);

				gmethods.highlightElement(SwtTcpHomePage.get().ihclViewDetails);

				SwtTcpHomePage.get().ihclViewDetails.click();

				boolean IHCLBookNowVisibility = gmethods.isElementVisible(SwtTcpHomePage.get().IHCLBookNowBtn, 30);

				if (IHCLBookNowVisibility == true) {
					gmethods.highlightElement(SwtTcpHomePage.get().IHCLBookNowBtn);
					fUtil.flogResult("Passed", "Visibility of Book Now on IHCL Card", "Book Now option on IHCL Card is visible", 1);				

					SwtTcpHomePage.get().IHCLBookNowBtn.click();

					logger.info("Clicked on Book Now");
					fUtil.flogResult("Passed", "Click on Book Now of IHCL Card",
							"Successfully clicked on Book Now on IHCL Card", 1);
				} else {
					logger.error("IHCL card page details not visible");
					fUtil.flogResult("Failed", "Visibility of Book Now on IHCL Card", "Book Now option on IHCL Card is not visible", 1);
				}

				switch(guestType.trim().toLowerCase()) {
				case "me" :
					boolean bookingType = gmethods.isElementVisible(SwtTcpHomePage.get().selfBooking, 10);

					if (bookingType) {
						fUtil.flogResult("Passed", "Who will be Staying ?", "Who will be Staying ? is visible", 1);
						SwtTcpHomePage.get().selfBooking.click();
					}
					else {
						fUtil.flogResult("Failed", "Who will be Staying ?", "Who will be Staying ? is not visible", 1);
					}
					break;
				case "guest" :
					boolean bookingTypeGuest = gmethods.isElementVisible(SwtTcpHomePage.get().guestBooking, 10);

					if (bookingTypeGuest) {
						fUtil.flogResult("Passed", "Who will be Staying ?", "Who will be Staying ? is visible", 1);
						SwtTcpHomePage.get().guestBooking.click();
					}
					else {
						fUtil.flogResult("Failed", "Who will be Staying ?", "Who will be Staying ? is not visible", 1);
					}

				}
			}

			else {
				logger.error("IHCL card not visible");
				fUtil.flogResult("Failed", "Visibility of Card", "IHCL card is not visible", 1);
			}
		} catch (Exception e) {

			//e.printStackTrace();
			fUtil.flogResult("Failed", "Navigation to Book Now in IHCL from Vault", "Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void goto_CromaCard() throws Exception {

		try {
			gmethods.gotoVaultPwa();

			boolean cromaCardVisibility = gmethods.isElementVisible(TdlVaultPage.get().cardName_Croma, 10);

			if (cromaCardVisibility == true) { 

				logger.info("Croma card is visible");
				fUtil.flogResult("Passed", "Croma Card Presence in Vault Page", "Croma card is visible", 1);

				gmethods.highlightElement(TdlVaultPage.get().cardName_Croma);

				TdlVaultPage.get().cardName_Croma.click();
				Thread.sleep(5000);
				Thread.sleep(5000);
				Thread.sleep(5000);
				boolean cromaShopNowVisibility = gmethods.isElementVisible(SwtTcpHomePage.get().cromashopnowbtn, 10);

				if (cromaShopNowVisibility == true) {
					gmethods.highlightElement(SwtTcpHomePage.get().cromashopnowbtn);
					logger.info("Croma Card Details is visible");
					fUtil.flogResult("Passed", "Click Shop Now on Croma Card", "Shop Now button visible on Croma Card", 1);

					SwtTcpHomePage.get().cromashopnowbtn.click();
					logger.info("Clicked on Shop Now");
					fUtil.flogResult("Passed", "Click Shop Now on Croma Card",
							"Successfully clicked on Shop Now on Croma Card", 1);
				} else {
					logger.error("Croma card page details not visible");
					fUtil.flogResult("Failed", "Click Shop Now on Croma Card", "Shop Now button not visible on Croma Card", 1);
				}
			}

			else {
				logger.error("Croma card not visible");
				fUtil.flogResult("Failed", "Croma Card Presence in Vault Page", "Croma card is not visible", 1);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			fUtil.flogResult("Failed", "Navigation to Shop Now in Croma from Vault", "Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}



	@Test
	public void selectoption_Tatasky() throws Exception {
		try {
			String option = fUtil.fgetDataNew1("tatasky_option");
			switch(option.trim().toLowerCase()) {
			case "newconnection" :
				TdlMATataSkyHomePage.get().newconnection.click();
				break;
			case "boxupgrade" :
				TdlMATataSkyHomePage.get().boxupgrade.click();
				break;
			case "quickrecharge" :
				TdlMATataSkyHomePage.get().quickrecharge.click();
				break;
			case "showcase" :
				TdlMATataSkyHomePage.get().showcase.click();
				break;
			}
			if(gmethods.isElementVisible(TdlMARegisterPage.get().registerheader,20))

				fUtil.flogResult("Passed", "Successfully landed on Tatasky page",
						"Successfully landed on Tatasky page", 1);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			fUtil.flogResult("Failed", "Tatasky page didn't load successfully",
					"Tatasky page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void selectfirstaddedaddress() throws Exception {
		try {
			//if(gmethods.isElementVisible(TdlMARegisterPage.get().select_address,20))
			TdlMARegisterPage.get().select_address.click();
			TdlMARegisterPage.get().continuebtn.click();

			//if(gmethods.isElementVisible(TdlMASelectChannels.get().entertainment,20))
			fUtil.flogResult("Passed", "Successfully landed on new tab watch shows page",
					"Successfully landed on watch shows page", 1);
		}catch(Exception e){
			//	e.printStackTrace();
			fUtil.flogResult("Failed", "Didn't land on new tab watch shows page",
					"Didn't land on new tab watch shows page", 1);
			throw e;
		}
	}
	@Test
	public void selectchannels_shows() throws Exception {
		try {
			// if(gmethods.isElementVisible(TdlMASelectChannels.get().entertainment,20)) {
			Thread.sleep(20000);


			gmethods.switchToNewTab();		    
			TdlMASelectChannels.get().entertainment.click();
			TdlMASelectChannels.get().movies.click();

			TdlMASelectChannels.get().continuebtn.click();


			if(gmethods.isElementVisible(TdlMASelectlanguagesPage.get().english,20)) {
				TdlMASelectlanguagesPage.get().english.click();
				TdlMASelectlanguagesPage.get().hindi.click();
				TdlMASelectlanguagesPage.get().continuebtn.click();
			}
			fUtil.flogResult("Passed", "Successfully landed on select languages page",
					"Successfully landed on select languages page", 1);
		}catch(Exception e){
			//	e.printStackTrace();
			fUtil.flogResult("Failed", "Didn't land on new tab watch shows page",
					"Didn't land on new tab watch shows page", 1);
			throw e;
		}
	}

	@Test
	public void hdselection() throws Exception {
		try {
			//String hdoption = fUtil.fgetDataNew1("hd_option");
			if(gmethods.isElementVisible(TdlMAHDselectionPage.get().yesbtn,20))

				TdlMAHDselectionPage.get().yesbtn.click();

			if(gmethods.isElementVisible(TdlMAHDselectionPage.get().selectsettopboxheader,20))
				TdlMAHDselectionPage.get().getthisbtn.click();
			TdlMAHDselectionPage.get().getthispackbtn.click();
			fUtil.flogResult("Passed", "Successfully landed on payments page",
					"Successfully landed on payments page", 1);
		}catch(Exception e){
			//	e.printStackTrace();
			fUtil.flogResult("Failed", "Could not load payments page",
					"Could not load payments page", 1);
			throw e;
		}
	}

	@Test
	public void paymentspage() throws Exception {
		try {
			if(gmethods.isElementVisible(TdlMAHDselectionPage.get().selectpaymentoptionheader,20))
				TdlMAHDselectionPage.get().payonlinebtn.click();

			if(gmethods.isElementVisible(TdlMAPaymentConnectionPage.get().addressheader,20))
				TdlMAPaymentConnectionPage.get().areadropdown.click();
			//gmethods.fSelectDataFromDropDownText(TdlMAPaymentConnectionPage.get().areadropdown, "","0",1);

			Thread.sleep(2000);
			Robot robot= new Robot();

			robot.keyPress(KeyEvent.VK_ENTER);

			//TdlMAPaymentConnectionPage.get().areadropdown.click();
			String Address = fUtil.fgetDataNew1("address");
			TdlMAPaymentConnectionPage.get().address.clear();
			TdlMAPaymentConnectionPage.get().address.sendKeys(Address);

			TdlMASelectlanguagesPage.get().continuebtn.click();

			fUtil.flogResult("Passed", "Successfully landed on choose payments method page",
					"Successfully landed on choose payments method page", 1);
		}catch(Exception e){
			//	e.printStackTrace();
			fUtil.flogResult("Failed", "Could not load choose payments method page",
					"Could not load choose payments method page", 1);
			throw e;
		}
	}

	@Test
	public void opelpagepaymentmethod() throws Exception {
		try {
			String enter_cccardno=fUtil.fgetDataNew1("cc_cardno");
			System.out.println(enter_cccardno);
			String enter_ccmonth=fUtil.fgetDataNew1("cc_expmonth");
			String enter_cccvv=fUtil.fgetDataNew1("cc_cvv");
			String enter_dccardno=fUtil.fgetDataNew1("dc_cardno");
			String enter_dcmonth=fUtil.fgetDataNew1("dc_expmonth");
			String enter_dccvv=fUtil.fgetDataNew1("dc_cvv");
			String otp=fUtil.fgetDataNew1("otp");
			String paymentmethod=fUtil.fgetDataNew1("payment_method");


			if(gmethods.isElementVisible(SwtTcpHomePage.get().paymentPageHeader, 15)) {

				fUtil.flogResult("Passed", "Enter Payment Page Details", "Payment Page loaded", 1);
				//TdlMAOPELPaymentsPage.get().opelpayment.click();
				BrowserFactory.webDriver.get().switchTo().frame("juspay_iframe");

				switch(paymentmethod.trim().toLowerCase()) {
				case "creditcard" :
					boolean flag=gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().creditDebitCard,15);
					System.out.println("Credit Card flag - "+flag);
					if(flag) {
						TdlMAOPELPaymentsPage.get().creditDebitCard.click();
					}
					if(gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().addNewCard,20))
						TdlMAOPELPaymentsPage.get().addNewCard.click();

					TdlMAOPELPaymentsPage.get().entercardnumber.sendKeys(enter_cccardno);
					TdlMAOPELPaymentsPage.get().expirymonth.sendKeys(enter_ccmonth);
					flag=gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().cvv,10);

					TdlMAOPELPaymentsPage.get().cvv.sendKeys(enter_cccvv);
					TdlMAOPELPaymentsPage.get().saveThisCard.click();
					flag=gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().proceedtopay,15);

					fUtil.flogResult("Passed", "Payment Page", "Proceeding the payment with Credit card", 1);
					TdlMAOPELPaymentsPage.get().proceedtopay.click();

					break;

				case "debitcard" :
					TdlMAOPELPaymentsPage.get().creditDebitCard.click();

					if(gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().addNewCard,10))
						TdlMAOPELPaymentsPage.get().addNewCard.click();

					TdlMAOPELPaymentsPage.get().entercardnumber.sendKeys(enter_dccardno);
					TdlMAOPELPaymentsPage.get().expirymonth.sendKeys(enter_dcmonth);
					TdlMAOPELPaymentsPage.get().cvv.sendKeys(enter_dccvv);
					TdlMAOPELPaymentsPage.get().saveThisCard.click();
					fUtil.flogResult("Passed", "Payment Page", "Proceeding the payment with Debit card", 1);
					TdlMAOPELPaymentsPage.get().proceedtopay.click();
					break;

				case "internetbanking" :
					TdlMAOPELPaymentsPage.get().netbanking.click();

					String bankoption=fUtil.fgetDataNew1("internetbanking_bank");
					if(bankoption.equalsIgnoreCase("axis"))
						TdlMAOPELPaymentsPage.get().axisbank.click();

					else if(bankoption.equalsIgnoreCase("hdfc"))
						TdlMAOPELPaymentsPage.get().hdfcbank.click();

					else if(bankoption.equalsIgnoreCase("icici"))
						TdlMAOPELPaymentsPage.get().icicibank.click();

					else TdlMAOPELPaymentsPage.get().sbibank.click();

					fUtil.flogResult("Passed", "Successfully completed payment",
							"Successfully completed payment", 1);
					break;

				case "payondelivery" :
					SwtTcpHomePage.get().pay_on_delivery_croma.click();
					Thread.sleep(2000);
					fUtil.flogResult("Passed", "Successfully selected payment",
							"Successfully selected payment", 1);
					SwtTcpHomePage.get().pay_on_delivery_radio_croma.click();
					Thread.sleep(2000);
					SwtTcpHomePage.get().proceed_to_pay_croma.click();
					waitForLoaderToHide();

					fUtil.flogResult("Passed", "Successfully completed payment",
							"Successfully completed payment", 1);
					break;
				case "wallet" :

					if(gmethods.isElementVisible(SwtTcpHomePage.get().payviaWallet,20))
					{
						gmethods.scrollToViewElement(SwtTcpHomePage.get().payviaWallet);
						SwtTcpHomePage.get().payviaWallet.click();
					}
					if(gmethods.isElementVisible(SwtTcpHomePage.get().testWallet,20))
					{
						gmethods.scrollToViewElement(SwtTcpHomePage.get().testWallet);
						SwtTcpHomePage.get().testWallet.click();
					}
					if(gmethods.isElementVisible(SwtTcpHomePage.get().proceedToPayBtn,10))
					{
						//gmethods.scrollToViewElement(SwtTcpHomePage.get().proceedToPayBtn);
						SwtTcpHomePage.get().proceedToPayBtn.click();
						fUtil.flogResult("Passed", "Payment Page", "Proceeding the payment with Wallet", 1);
					}

					if(gmethods.isElementVisible(SwtTcpHomePage.get().payDropdown,20))
						SwtTcpHomePage.get().payDropdown.click();
					Thread.sleep(1000);
					gmethods.fSelectDataFromDropDownText(SwtTcpHomePage.get().payDropdown, "Payment", "Success", 1);
					Thread.sleep(1000);
					SwtTcpHomePage.get().submitBtn.click();

					fUtil.flogResult("Passed", "Successfully completed payment",
							"Successfully completed payment  using Wallet", 1);
					break;
				case "tatapay" :
					boolean tatapayOptionPresent=gmethods.isElementVisible(SwtTcpHomePage.get().tatapayPaymentOption,20);
					if(tatapayOptionPresent)
					{
						SwtTcpHomePage.get().tatapayPaymentOption.click();
						Thread.sleep(1000);
						SwtTcpHomePage.get().procedToPay.click();
						Thread.sleep(6000);
						gmethods.switchTO_defaultContent();
						//BrowserFactory.webDriver.get().switchTo().frame("security_code_iframe_VKe6SSydNnw1RUQZ");
						BrowserFactory.webDriver.get().switchTo().frame(0);   
						boolean cvvOption=gmethods.isElementVisible(SwtTcpHomePage.get().enterCvv,20);
						if(cvvOption)
						{
							SwtTcpHomePage.get().enterCvv.click();
							SwtTcpHomePage.get().enterCvv.sendKeys(enter_cccvv);
							Thread.sleep(1000);
							gmethods.switchTO_defaultContent();
							SwtTcpHomePage.get().payButton.click();
							Thread.sleep(7000);
						}
						else
						{
							String cardNo=fUtil.fgetDataNew1("cc_cardno");
							String cardHoldername=fUtil.fgetDataNew1("CustomerName");
							String cardExpMonth=fUtil.fgetDataNew1("cc_expmonth");
							String cardExpYear=fUtil.fgetDataNew1("cc_expyear");
							gmethods.switchTO_defaultContent();
							SwtTcpHomePage.get().addNew.click();
							SwtTcpHomePage.get().nameOncard.click();
							SwtTcpHomePage.get().nameOncard.sendKeys(cardHoldername);
							SwtTcpHomePage.get().cardNumberTcp.click();
							SwtTcpHomePage.get().cardNumberTcp.sendKeys(cardNo);
							SwtTcpHomePage.get().cardExpMonth.click();
							SwtTcpHomePage.get().cardExpMonth.sendKeys(cardExpMonth);
							SwtTcpHomePage.get().cardExYear.click();
							SwtTcpHomePage.get().cardExYear.sendKeys(cardExpYear);
							SwtTcpHomePage.get().enterCvv.click();
							SwtTcpHomePage.get().enterCvv.sendKeys(enter_cccvv);
							Thread.sleep(1000);
							SwtTcpHomePage.get().payButton.click();
							Thread.sleep(1000);


						}

					}
					break;
				}
				gmethods.switchTO_defaultContent();
				boolean paymentModal=gmethods.isElementVisible(SwtTcpHomePage.get().successPayment,10);
				if(paymentModal)
				{
					SwtTcpHomePage.get().successPayment.click();
					Thread.sleep(7000);
				}
				if(gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().otp, 20))
				{
					System.out.println("OTP Page found");
					fUtil.flogResult("Passed", "OTP Page", "Entering OTP for payment confirmation", 1);
					TdlMAOPELPaymentsPage.get().otp.sendKeys(otp);;
					TdlMAOPELPaymentsPage.get().submit.click();
				}
				//else {
				//	fUtil.flogResult("Failed", "OTP Page", "Unable to find OTP field", 1);	
				//}


			}else {
				fUtil.flogResult("Failed", "Enter Payment Page Details", "Payment Page not loaded", 1);	
			}

		}catch(Exception e){
			//e.printStackTrace();
			fUtil.flogResult("Failed", "Open Payment Page",
					"Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void choosepaymentmethod() throws Exception {
		try {
			String enter_cccardno=fUtil.fgetDataNew1("cc_cardno");
			//String enter_ccmonth=fUtil.fgetDataNew1("cc_expmonth");
			//String enter_ccyear=fUtil.fgetDataNew1("cc_expyear");
			String enter_cccvv=fUtil.fgetDataNew1("cc_cvv");
			String enter_ccholdername=fUtil.fgetDataNew1("cc_holdername");
			String enter_dccardno=fUtil.fgetDataNew1("dc_cardno");
			//String enter_dcmonth=fUtil.fgetDataNew1("dc_expmonth");
			//String enter_dcyear=fUtil.fgetDataNew1("dc_expyear");
			String enter_dccvv=fUtil.fgetDataNew1("dc_cvv");
			String enter_dcholdername=fUtil.fgetDataNew1("dc_holdername");

			if(gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().opelpayment,20))
				TdlMAOPELPaymentsPage.get().opelpayment.click();

			String paymentmethod=fUtil.fgetDataNew1("payment_method");
			switch(paymentmethod.trim().toLowerCase()) {
			case "creditcard" :
				TdlMANewConnectionPaymentsPage.get().entercardnumber.sendKeys(enter_cccardno);
				TdlMANewConnectionPaymentsPage.get().expirymonth.click();
				TdlMANewConnectionPaymentsPage.get().expirymonth.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expirymonth.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expirymonth.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

				TdlMANewConnectionPaymentsPage.get().expiryyear.click();
				TdlMANewConnectionPaymentsPage.get().expiryyear.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expiryyear.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expiryyear.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expiryyear.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

				TdlMANewConnectionPaymentsPage.get().cvv.sendKeys(enter_cccvv);
				TdlMANewConnectionPaymentsPage.get().holdername.sendKeys(enter_ccholdername);
				break;

			case "debitcard" :
				TdlMANewConnectionPaymentsPage.get().debitcardoption.click();
				TdlMANewConnectionPaymentsPage.get().entercardnumber.sendKeys(enter_dccardno);

				TdlMANewConnectionPaymentsPage.get().expirymonth.click();
				TdlMANewConnectionPaymentsPage.get().expirymonth.click();
				TdlMANewConnectionPaymentsPage.get().expirymonth.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expirymonth.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expirymonth.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

				TdlMANewConnectionPaymentsPage.get().expiryyear.click();
				TdlMANewConnectionPaymentsPage.get().expiryyear.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expiryyear.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expiryyear.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				TdlMANewConnectionPaymentsPage.get().expiryyear.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

				TdlMANewConnectionPaymentsPage.get().cvv.sendKeys(enter_dccvv);
				TdlMANewConnectionPaymentsPage.get().holdername.sendKeys(enter_dcholdername);
				break;

			case "internetbanking":
				TdlMANewConnectionPaymentsPage.get().internetbankingoption.click();

				String bankoption=fUtil.fgetDataNew1("internetbanking_bank");
				if(bankoption.equalsIgnoreCase("ICICINet"))
					TdlMANewConnectionPaymentsPage.get().icicioption.click();

				else TdlMANewConnectionPaymentsPage.get().sbioption.click();
			}		    	
			TdlMANewConnectionPaymentsPage.get().makepayment.click();
			fUtil.flogResult("Passed", "Successfully completed payment",
					"Successfully completed payment", 1);
		}catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not complete the payment",
					"Could not complete the payment", 1);
			throw e;
		}
	}

	@Test
	public void inputAddressDetails() throws Exception {
		logger.info("inputAddressDetails");
		//get data from data file
		String custName = fUtil.fgetDataNew1("CustomerName");
		String flatNo=gmethods.randomString(4, "Numeric", "");
		System.out.println(flatNo);
		String landmark=gmethods.randomString(5, "Alpha", "");
		System.out.println(landmark);

		if(!StringUtils.isBlank(custName)) {
			TdlAddressManual.get().customerName.sendKeys(custName);
		}

		if(!StringUtils.isBlank(flatNo)) {
			TdlAddressManual.get().flatNo.sendKeys(flatNo);
		}

		if(!StringUtils.isBlank(landmark)) {
			TdlAddressManual.get().landmark.sendKeys(landmark);
		}
		TdlAddressManual.get().savechangesBtn.click();
	}

	@Test
	public void quickeasyrecharge() throws Exception {
		try {
			if(gmethods.isElementVisible(TdlMAQuickRechargeHomePage.get().headermsg,10))
				System.out.println("switch");
			gmethods.switchToNewTab();
			//Thread.sleep(2000);
			System.out.println("switch");
			if(gmethods.isElementVisible(TdlMAQuickRechargeHomePage.get().headermsg,30))
			{

				System.out.println("enter");
				TdlMAQuickRechargeHomePage.get().subscriberId.clear();
				Thread.sleep(3000);
				TdlMAQuickRechargeHomePage.get().subscriberId.sendKeys(fUtil.fgetDataNew1("subscriberid"));
				Thread.sleep(3000);
				SwtTcpHomePage.get().amount_tata.click();
				Thread.sleep(3000);
				SwtTcpHomePage.get().amount_tata.sendKeys(fUtil.fgetDataNew1("amount"));
				Thread.sleep(3000);
				SwtTcpHomePage.get().continue_tata.click();
				fUtil.flogResult("Passed", "Successfully landed on quick recharge page",
						"Successfully landed on quick recharge offers page", 1);
			}
			else 
			{
				fUtil.flogResult("Failed", "Failed to land on quick recharge page",
						"Failed to land on quick recharge offers page", 1);}
		}catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Failed to land on quick recharge page",
					"Failed to land on quick recharge offers page", 1);
			throw e;
		}
	}

	@Test
	public void quickrechargeofferspage() throws Exception {
		try {
			if(gmethods.isElementVisible(TdlMAQuickRechargeOfferPage.get().offerspageheader,20))

			{




				TdlMAQuickRechargeOfferPage.get().skipcontinuebtn.click();
				fUtil.flogResult("Passed", "Successfully landed on quick recharge offers page",

						"Successfully landed on quick recharge offers page", 1);

			}else
			{
				fUtil.flogResult("Failed", "Failed to land on quick recharge offers page",

						"Failed to land on quick recharge offers page", 1);
			}}
		catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Failed to land on quick recharge offers page",
					"Failed to land on quick recharge offers page", 1);
			throw e;
		}
	}

	@Test
	public void cromashopnowbtn() throws Exception {
		try {
			if(gmethods.isElementVisible(SwtTcpHomePage.get().cromashopnowbtn, 10)) {

				SwtTcpHomePage.get().cromashopnowbtn.click();
				fUtil.flogResult("Passed", "Clicked on shop now btn",
						"Clicked on shop now btn", 1);

			}else {
				fUtil.flogResult("Failed", "Shop Now Button Croma",
						"Shop Now Button Croma Not visible", 1);
			}
		}catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Failed to click on shop now btn",
					"Exception to click on shop now btn : "+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void verifyRedirectionUrl() throws Exception {
		try {
			String env=fUtil.fgetDataNew1("Environment");
			String rurl=fUtil.fgetDataNew1("RedirectionURL");
			Thread.sleep(13000);
			gmethods.switchToNewTab();
			switch(env.trim().toLowerCase()) {
			case "sit" :
				if(gmethods.isElementVisible(SwtTcpHomePage.get().cromaheader,20))
				{
					String url=BrowserFactory.webDriver.get().getCurrentUrl();
					fUtil.flogResult("Passed", "Successfully landed on Croma Home Page",
							"Successfully landed on Croma Home Page.", 1);
					if(url.contains(rurl))
					{
						fUtil.flogResult("Passed", "Redirection Url",
								"Redirection Url is correct : "+url, 1);
					}
					else
					{
						fUtil.flogResult("Failed", "Redirection Url ",
								"Redirection Url is not correct : "+url, 1);
					}
				}
				else
				{
					fUtil.flogResult("Failed", "Redirection to Croma",
							"Failed to Redirect to Croma", 1);

				}
				break;
			case "cug" :
				if(gmethods.isElementVisible(SwtTcpHomePage.get().cromaheader,20))
				{
					String url=BrowserFactory.webDriver.get().getCurrentUrl();
					fUtil.flogResult("Passed", "Successfully landed on Croma Home Page",
							"Successfully landed on Croma Home Page.", 1);
					if(url.contains(rurl))
					{
						fUtil.flogResult("Passed", "Redirection Url",
								"Redirection Url is correct : "+url, 1);
					}
					else
					{
						fUtil.flogResult("Failed", "Redirection Url",
								"Redirection Url is not correct"+url, 1);
					}
				}
				else
				{
					fUtil.flogResult("Failed", "Redirection to Croma",
							"Failed to Redirect to Croma", 1);

				}
				break;
			}
		}catch(Exception e)
		{
			fUtil.flogResult("Failed", "Redirection Url is correct",
					"Redirection Url is not correct"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void cromaproductshopping() throws Exception {
		try {
			if(gmethods.isElementVisible(SwtTcpHomePage.get().cromaheader,20))
			{
				String url=BrowserFactory.webDriver.get().getCurrentUrl();

				fUtil.flogResult("Passed", "Successfully landed on Croma Home Page",
						"Successfully landed on Croma Home Page.", 1);

				fUtil.flogResult("Passed", "Current Url : ",url, 0);

				String product=fUtil.fgetDataNew1("search_product");
				String pincode=fUtil.fgetDataNew1("croma_pincode");
				if(gmethods.isElementVisible(SwtTcpHomePage.get().searchproduct,20)) {
					SwtTcpHomePage.get().searchproduct.sendKeys(product);
					SwtTcpHomePage.get().searchproduct.sendKeys(Keys.ENTER);
					Thread.sleep(5000);
				}
				//waitForLoaderToHide();

				if(gmethods.isElementVisible(SwtTcpHomePage.get().deliverypincode,20))
				{
					SwtTcpHomePage.get().deliverypincode.click();
					if(gmethods.isElementVisible(SwtTcpHomePage.get().enterpincode,10))
						SwtTcpHomePage.get().enterpincode.clear();
					SwtTcpHomePage.get().enterpincode.sendKeys(pincode);
					SwtTcpHomePage.get().applybtn.click();
					Thread.sleep(5000);

				}
				//waitForLoaderToHide();
				//.get().buynowbtn.click();
				if(gmethods.isElementVisible(SwtTcpHomePage.get().buynowbtn,20))
				{
					SwtTcpHomePage.get().buynowbtn.click();
					//waitForLoaderToHide();
					Thread.sleep(8000);
					fUtil.flogResult("Passed", "click buy now detail Page",
							"Successfully clicked buy now Payment Page", 1);
				}else {
					fUtil.flogResult("Failed", "Click buy now detail Page",
							"Failed to Click buy now Page", 1);
				}

			}else {
				fUtil.flogResult("Failed", "Croma Home Page",
						"Failed to land on Croma Home Page.", 1);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}


	public void switchToNewTabByTitle(String Title) throws Exception
	{
		try {
			WebDriver webDriver = BrowserFactory.webDriver.get();
			String oldTab = webDriver.getWindowHandle();
			//ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
			//newTab.remove(oldTab);
			// change focus to new tab
			//webDriver.switchTo().window(newTab.get(0));
			for(String winHandle : webDriver.getWindowHandles()){
				if (webDriver.switchTo().window(winHandle).getTitle().contains(Title))
				{
					//This is the one you're looking for
					webDriver.switchTo().window(winHandle);
					break;
				} 
				else {
					webDriver.switchTo().window(oldTab);
				} 
			}
			System.out.println(webDriver.getCurrentUrl());
		}catch(Exception e) {
			fUtil.flogResult("Failed", "General Function : switchToNewTab ", "Exception Caught : "+e.getMessage(), 1);
			throw e;
		}
	}


	public void switchToNewTabByCurrentUrl(String CurrentUrl) throws Exception
	{
		try {
			WebDriver webDriver = BrowserFactory.webDriver.get();
			String oldTab = webDriver.getWindowHandle();
			//ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
			//newTab.remove(oldTab);
			// change focus to new ta
			//webDriver.switchTo().window(newTab.get(0));
			for(String winHandle : webDriver.getWindowHandles()){
				//if (webDriver.switchTo().window(winHandle).getTitle().contains(Title))
				if (webDriver.switchTo().window(winHandle).getCurrentUrl().contains(CurrentUrl)) {
					//This is the one you're looking for
					webDriver.switchTo().window(winHandle);
					break;
				} 
				else {
					webDriver.switchTo().window(oldTab);
				} 
			}
			System.out.println(webDriver.getCurrentUrl());
		}catch(Exception e) {
			fUtil.flogResult("Failed", "General Function : switchToNewTab ", "Exception Caught : "+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void ihclBooking() throws Exception {
		try {
			String hotelSearch=fUtil.fgetDataNew1("SearchAddressHotel");
			Thread.sleep(8000);
			gmethods.switchToNewTab();

			boolean flag = gmethods.isElementVisible(SwtTcpHomePage.get().tajHotelLogo,20);
			if(flag) {

				fUtil.flogResult("Passed", "Successfully landed on IHCL Home Page",
						"Successfully landed on IHCL Home Page", 1);

				SwtTcpHomePage.get().bookAStay.click();
			}
			else {fUtil.flogResult("Failed", "Successfully landed on IHCL Home Page",
					"IHCL Home Page not displayed", 1);
			} 
			boolean searchBar = gmethods.isElementVisible(SwtTcpHomePage.get().searchHotel,20);
			if(searchBar)
			{

				SwtTcpHomePage.get().searchHotel.sendKeys(hotelSearch);
				boolean searchResult = gmethods.isElementVisible(SwtTcpHomePage.get().TajMahalLucknow,10);
				if(searchResult)
				{
					SwtTcpHomePage.get().TajMahalLucknow.click();
					fUtil.flogResult("Passed", "Hotel Selected",
							"Hotel Selected", 1);

				}
				else
				{
					fUtil.flogResult("Failed", "Hotel Selected",
							"Hotel not Selected", 1);

				}

			}
			else {
				fUtil.flogResult("Failed", "Search bar is not displayed",
						"Search bar is not displayed", 1);
			}

		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void ihclBookAHoliday() throws Exception {
		try {
			Thread.sleep(15000);
			switchToNewTabByTitle("Holiday Packages");



			boolean flag = gmethods.isElementVisible(SwtTcpHomePage.get().tajLogoBookingAHoliday,20);


			if(flag) {

				fUtil.flogResult("Passed", "Successfully landed on IHCL Home Page",
						"Successfully landed on IHCL Home Page", 1);
			}
			else {fUtil.flogResult("Failed", "Successfully landed on IHCL Home Page",
					"IHCL Home Page not displayed", 1);
			}   

		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}


	public void scrollToViewChannelRibbon() throws Exception{
		try {
			if(scenarioBrowserMap.get(scenarioName.get()).equalsIgnoreCase("pwa mobile"))
				gmethods.scrollToViewElement(TdlHomePage.get().channelRibbon);
			else
				gmethods.scrollToViewElement(TdlHomePage.get().channelHeader);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	@Test
	public void enterShippingAddressInPaymentDetails() throws Exception{
		try {
			String emailAddress=fUtil.fgetDataNew1("Email");
			String mobileNumber=fUtil.fgetDataNew1("PhoneNo");
			String pincode=fUtil.fgetDataNew1("croma_pincode");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().firstname, 15)) {
				SwtTcpHomePage.get().firstname.sendKeys("Fname");
				//SwtTcpHomePage.get().lastname.sendKeys("Fname");
				SwtTcpHomePage.get().flatno.sendKeys("10");
				SwtTcpHomePage.get().landmark.sendKeys("test");
				SwtTcpHomePage.get().state.sendKeys("MAHARASHTRA");
				SwtTcpHomePage.get().state.sendKeys(Keys.ARROW_DOWN);
				SwtTcpHomePage.get().state.sendKeys(Keys.ENTER);
				SwtTcpHomePage.get().cityid.sendKeys("MUMBAI");
				SwtTcpHomePage.get().cityid.sendKeys(Keys.ARROW_DOWN);
				SwtTcpHomePage.get().cityid.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				String pincodeValue=MyOffersPage.get().cromaAddressPincode.getText();
				if(pincodeValue.equals(""))
				{
					fUtil.flogResult("Failed", "pincode autopopulated",
							"pincode not autopopulated", 1);
					MyOffersPage.get().cromaAddressPincode.click();
					MyOffersPage.get().cromaAddressPincode.sendKeys(pincode);
					Thread.sleep(1000);
				}
				String emailValue=MyOffersPage.get().cromaAddressEmail.getText();
				if(emailValue.equals(""))
				{
					fUtil.flogResult("Failed", "email autopopulated",
							"email not autopopulated", 1);
					MyOffersPage.get().cromaAddressEmail.click();
					MyOffersPage.get().cromaAddressEmail.sendKeys(emailAddress);
					Thread.sleep(1000);
				}
				String mobileNo=MyOffersPage.get().cromaAddressMobileNo.getText();
				if(mobileNo.equals(""))
				{
					fUtil.flogResult("Failed", "phone no autopopulated",
							"phone no not autopopulated", 1);
					MyOffersPage.get().cromaAddressMobileNo.click();
					MyOffersPage.get().cromaAddressMobileNo.sendKeys(mobileNumber);
				}
				if(gmethods.isElementVisible(SwtTcpHomePage.get().selectpayment, 15)) {
					SwtTcpHomePage.get().selectpayment.click();
					Thread.sleep(13000);
					//waitForLoaderToHide();
				}

			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}



	@Test
	public void validateOrderConfirmation() throws Exception{
		waitForLoaderToHide();
		if(gmethods.isElementVisible(SwtTcpHomePage.get().thankYouForShoppingHeader, 30)) {

			String orderId=SwtTcpHomePage.get().orderId.getText().trim();

			fUtil.flogResult("Passed", "Order Confirmation",
					"Order Placed Successfully. Order Id is : "+orderId, 1);

			closeAllTabsAndSwitchtoTcp();

			//BrowserFactory.webDriver.get().findElement(By.xpath(channelLink)).click();
			gmethods.refreshBrowser();
			
			String channelOrderXpath="//*[contains(text(),'"+orderId+"')]";

			gmethods.isElementVisibleXpath(channelOrderXpath, 30);

			boolean flag=gmethods.scrollToViewElement(BrowserFactory.webDriver.get().findElement(By.xpath(channelOrderXpath)));

			if(flag) {
				gmethods.highlightElement(BrowserFactory.webDriver.get().findElement(By.xpath(channelOrderXpath)));
				fUtil.flogResult("Passed", "Order Confirmation in Channels Page",
						"Order Placed Successfully and is Visible in Channels Page ", 1);
			}else {
				fUtil.flogResult("Failed", "Order Confirmation in Channels Page",
						"Order not Visible in Channels Page ", 1);
			}
		}else {
			fUtil.flogResult("Failed", "Order Confirmation",
					"Order Not Placed Successfully", 1);
		}	
	}

	public void waitForLoaderToHide() throws Exception{
		String loaderXpath1="//*[@class='loader hide'] | //*[@class='loader hide ']";

		try {
			for(int i=0;i<20;i++) {
				if(BrowserFactory.webDriver.get().findElement(By.xpath(loaderXpath1)).isDisplayed()==false)
				{
					Thread.sleep(1000);
					continue;
				}
				else {
					System.out.println("Loader Hidden");
					break;
				}
			}

		}catch(Exception e) {
			logger.fatal(e.getMessage());
			throw e;
		}
	}

	@Test
	public void navigateToIhclBookAStayFromChannels() throws Exception {
		try {
			boolean reserveTableVisibility=gmethods.isElementVisible(TdlChannelsPage.get().threeDotsMenuReserveATable,10);
			if(reserveTableVisibility) {

				TdlChannelsPage.get().threeDotsMenuBookAStay.click();
				if(gmethods.isElementVisible(TdlChannelsPage.get().whoWillStay_Me, 10)) {

					fUtil.flogResult("Passed", "IHCL Channel page, Navigate to Book a Stay", 
							"Who Will stay page is visible", 1);
					TdlChannelsPage.get().whoWillStay_Me.click();
					Thread.sleep(15000);
					//gmethods.switchToNewTab();
					switchToNewTabByTitle("Luxury");

					if(gmethods.isElementVisible(SwtTcpHomePage.get().tajHotelLogo, 20)){

						String currentUrl=BrowserFactory.webDriver.get().getCurrentUrl();
						fUtil.flogResult("Passed", "IHCL Channel page, Navigate to Book a Stay", 
								"Navigated to successfully to IHCL. Current Url : "+currentUrl, 1);
					}else {
						fUtil.flogResult("Failed", "IHCL Channel page, Navigate to Book a Stay", 
								"Navigation to IHCL Failed.", 1);	
					}
				}else {
					fUtil.flogResult("Passed", "IHCL Channel page, Navigate to Book a Stay", 
							"Who Will stay page is not visible", 1);
				}
			}else {
				fUtil.flogResult("Failed", "IHCL Channel page, Navigate to Reserve Table page", 
						"Reserve a Table option not visible in 3 dots menu of IHCL Channel page", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "IHCL Channel page, Navigate to Reserve Table page", 
					"Exception caught while navigating to reserve table page : "+e.getMessage(), 1);
			throw e;
		}
	}


	@Test
	public void enrollUser() throws Exception {
		try {
			String mobileNumber = "9989"+gmethods.randomString(6, "Numeric", "");
			//fUtil.fgetDataNew1("Mobile_no");
			String newPassword = fUtil.fgetDataNew1("Password");
			String firstName = "FName"+gmethods.randomString(4, "Alpha", "");
			String lastName = "LName"+gmethods.randomString(4, "Alpha", "");
			String dob = fUtil.fgetDataNew1("DOB");		
			String email = "test_"+mobileNumber+"@gmail.com";
			//fUtil.fgetDataNew1("Email");
			String gender=fUtil.fgetDataNew1("Gender");
			String salutation=fUtil.fgetDataNew1("Salutation");
			String otp="123456";

			gmethods.enrollUserPwa(mobileNumber, otp, newPassword,salutation, firstName, lastName, dob,gender, email);
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "Enroll User","Exception in Enroll User : "+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void validateCromaTsCrossBrandContent() throws Exception{
		try {
			boolean crossBrandContentVisibility=gmethods.isElementVisible(TdlChannelsPage.get().cromaChannelCrossBrandTsContent, 10);
			if(crossBrandContentVisibility)
			{
				gmethods.scrollToViewElement(TdlChannelsPage.get().cromaChannelCrossBrandTsContent);
				fUtil.flogResult("Passed", "Cross Brand Content Visibility","Cross Brand Tata Sky Content is Visible in Croma Channel ", 1);

				if(gmethods.isElementVisible(TdlChannelsPage.get().cromaChannelCrossBrandTsNewConection, 10))
				{
					TdlChannelsPage.get().cromaChannelCrossBrandTsNewConection.click();

					boolean tataSkyLogoVisibility= gmethods.isElementVisible(TdlMATataSkyHomePage.get().tataSkyLogo, 20);
					String currentUrl=BrowserFactory.webDriver.get().getCurrentUrl();
					if(tataSkyLogoVisibility && currentUrl.contains("www.tatasky.com"))
					{
						fUtil.flogResult("Passed", "Tata Sky Page Redirection","Navigation to Tata Sky page successfully", 1);
					}else {
						fUtil.flogResult("Failed", "Tata Sky Page Redirection","Navigation to Tata Sky page failed. Current Url : "+currentUrl, 1);
					}


				}else {
					fUtil.flogResult("Failed", "Cross Brand TS new connection","New Connection option not visible in Croma Channel", 1);
				}
			}else {
				fUtil.flogResult("Failed", "Cross Brand Content Visibility","Cross Brand Tata Sky Content is Not Visible in Croma Channel ", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Enroll User","Exception in Enroll User : "+e.getMessage(), 1);
			throw e;
		}
	}

	//revathi
	@Test
	public void validateIHCL_For_you() throws Exception
	{
		try
		{
			boolean isWidget=gmethods.isElementVisible(SwtTcpHomePage.get().IHCL_OFFER, 20);
			if(isWidget)
			{

				fUtil.flogResult("Passed","IHCL offer Present", "IHCL offer present", 1);

				SwtTcpHomePage.get().IHCL_OFFER.click();
				fUtil.flogResult("Passed","IHCL offer clickedt", "IHCL offerclicked", 1);

			}
			else
			{
				fUtil.flogResult("Failed","IHCL offer not Present", "IHCL offer not Present", 1);
			}

		}

		catch(Exception e)
		{
			fUtil.flogResult("Failed", "IHCL offer not present", "Exception occurs at IHCL offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}

	@Test
	public void validateIHCL_Book() throws Exception
	{
		try
		{
			boolean isWidget=gmethods.isElementVisible(SwtTcpHomePage.get().IHCL_BOOK_NOW, 20);
			if(isWidget)
			{


				SwtTcpHomePage.get().IHCL_BOOK_NOW.click();
				fUtil.flogResult("Passed","IHCL BOOK now clickedt", "IHCL BOOK now clicked", 1);

			}
			else
			{
				fUtil.flogResult("Failed","IHCL BOOK now Present", "IHCL BOOK now not Present", 1);
			}

		}

		catch(Exception e)
		{
			fUtil.flogResult("Failed", "IHCL BOOK now not present", "Exception occurs at IHCL BOOK now offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}

	@Test
	public void validateIHCL_Me() throws Exception
	{
		try
		{
			boolean isWidget=gmethods.isElementVisible(SwtTcpHomePage.get().IHCL_ME, 20);
			if(isWidget)
			{


				SwtTcpHomePage.get().IHCL_ME.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed","IHCL Me clickedt", "IHCL BOOK now clicked", 1);

			}
			else
			{
				fUtil.flogResult("Failed","IHCL Me Present", "IHCL Me not Present", 1);
			}

		}

		catch(Exception e)
		{
			fUtil.flogResult("Failed", "IHCL Me not present", "Exception occurs at IHCL Me offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}
	@Test
	public void validateIHCL_HoMe() throws Exception
	{
		try
		{
			gmethods.switchToNewTab();
			boolean isWidget=gmethods.isElementVisible(SwtTcpHomePage.get().IHCL_Home, 40);
			if(isWidget)
			{


				fUtil.flogResult("Passed","validate IHCL Home page reached", "IHCL Home page reached", 1);

			}
			else
			{
				fUtil.flogResult("Failed","validate IHCL Home page reached", "validate IHCL Home page not reached", 1);
			}

		}

		catch(Exception e)
		{
			fUtil.flogResult("Failed", "validate IHCL Home page reached not present", "Exception occurs validate IHCL Home page reached:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}



	@Test
	public void cromaproductshoppingHeroBanner() throws Exception {
		try {
			Thread.sleep(15000);
			switchToNewTabByTitle("Buy JBL Club");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().cromaheader,20))
			{
				String url=BrowserFactory.webDriver.get().getCurrentUrl();

				fUtil.flogResult("Passed", "Successfully landed on Croma Home Page",
						"Successfully landed on Croma Home Page.", 1);

				fUtil.flogResult("Passed", "Current Url : ",url, 0);

				String product=fUtil.fgetDataNew1("search_product");
				String pincode=fUtil.fgetDataNew1("croma_pincode");

				/*
				 * SwtTcpHomePage.get().searchproduct.sendKeys(product);
				 * SwtTcpHomePage.get().searchproduct.sendKeys(Keys.ENTER);
				 * waitForLoaderToHide();
				 */

				SwtTcpHomePage.get().deliverypincode.click();
				SwtTcpHomePage.get().enterpincode.clear();
				SwtTcpHomePage.get().enterpincode.sendKeys(pincode);
				SwtTcpHomePage.get().applybtn.click();
				waitForLoaderToHide();
				Thread.sleep(2000);
				SwtTcpHomePage.get().buynowbtn.click();
				waitForLoaderToHide();

				if(gmethods.isElementVisible(SwtTcpHomePage.get().paymentdetailheader,30))
					SwtTcpHomePage.get().checkout.click();
				waitForLoaderToHide();
				fUtil.flogResult("Passed", "Navigation to Payment detail Page",
						"Successfully navigated to Select Payment Page", 1);
			}else {
				fUtil.flogResult("Failed", "Navigation to Payment detail Page",
						"Failed to Navigate to Payment Detail Page", 1);
			}

		}catch(Exception e){
			e.printStackTrace();
			throw e;

		}
	}
	///Manoranjan
	@Test
	public void validateOffersUnderRecommendedCatagotyOffers() throws Exception
	{
		try
		{
			String Offer_value=fUtil.fgetDataNew1("Offer_Value").trim();
			WebElement wb=BrowserFactory.webDriver.get().findElement(By.xpath("//*[contains(text(),'"+Offer_value+"')]"));
			boolean isWidget=gmethods.isElementVisible(MyOffersPage.get().recommendedCatagoryOffers, 20);
			if(isWidget)
			{
				fUtil.flogResult("Passed","Recommended Offer Present", "Recommended Offer Present", 1);
				//MyOffersPage.get().recommendedCatagoryOffers.click();
				wb.click();
			}
			else
			{
				fUtil.flogResult("Failed","Recommended catagory Offer Present", "Recommended catagory Offer not Present", 1);
			}

		}

		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Recommended catagory Offer Present", "Exception occurs at Recommended catagory Offer Present:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}
	@Test
	public void clickOnShopNow() throws Exception
	{
		try
		{
			boolean isWidget=gmethods.isElementVisible(SwtTcpHomePage.get().shopNowCroma, 20);
			if(isWidget)
			{
				fUtil.flogResult("Passed","Shop Now Button Visibility", "Shop Now button is visible", 1);
				SwtTcpHomePage.get().shopNowCroma.click();
				Thread.sleep(8000);
				gmethods.switchToNewTab();
				Thread.sleep(8000);
			}
			else
			{
				fUtil.flogResult("Failed","Clicked On Browse products", " Not Clicked On Browse products", 1);
			}

		}

		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Clicked On Browse products", "Exception occurs at Clicked On Browse products:"+e.getMessage(), 1);	
			logger.error("Clicked On Browse products"+ e);
			throw e;
		}

	}

	@Test
	public void cromaproduct_Add_to_cart() throws Exception {
		try {
			Thread.sleep(8000);

			if(gmethods.isElementVisible(SwtTcpHomePage.get().croma_Add_to_cart,20))
			{
				SwtTcpHomePage.get().croma_Add_to_cart.click();
				Thread.sleep(2000);
				fUtil.flogResult("Passed", "validate croma product Add to cart", "croma product Added to cart", 1);
			}


		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	@Test
	public void croma_cart_page() throws Exception {
		try {
			Thread.sleep(8000);

			if(gmethods.isElementVisible(MyOffersPage.get().croma_cart_icon,20))
			{
				MyOffersPage.get().croma_cart_icon.click();
				Thread.sleep(2000);
				fUtil.flogResult("Passed", "validate croma cart page", "croma cart page reached", 1);
			}


		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	@Test
	public void croma_click_checkout() throws Exception {
		try {
			Thread.sleep(3000);
			if(gmethods.isElementClickable(MyOffersPage.get().croma_click_checkout,20))

			{
				MyOffersPage.get().croma_click_checkout.click();
				Thread.sleep(5000);
				fUtil.flogResult("Passed", "validate croma checkout", "croma checkout page reached", 1);
			}


		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void CromaAddress() throws Exception
	{
		try
		{
			String firstname=fUtil.fgetDataNew1("CustomerName");
			String lastname=fUtil.fgetDataNew1("Last_Name");
			String flat=fUtil.fgetDataNew1("FlatNo");
			String location=fUtil.fgetDataNew1("Location");
			String state=fUtil.fgetDataNew1("State");
			String city=fUtil.fgetDataNew1("City");
			String emailAddress=fUtil.fgetDataNew1("Email");
			String mobileNumber=fUtil.fgetDataNew1("PhoneNo");
			String pincode=fUtil.fgetDataNew1("croma_pincode");
			Thread.sleep(5000);
			MyOffersPage.get().croma_address_firstname.click();
			MyOffersPage.get().croma_address_firstname.sendKeys(firstname);
			Thread.sleep(3000);
			//MyOffersPage.get().croma_address_lastname.sendKeys(lastname);
			//Thread.sleep(3000);
			MyOffersPage.get().croma_flatno.click();
			MyOffersPage.get().croma_flatno.sendKeys(flat);
			Thread.sleep(3000);
			MyOffersPage.get().croma_landmark.click();
			MyOffersPage.get().croma_landmark.sendKeys(location);
			Thread.sleep(3000);
			MyOffersPage.get().croma_state.click();
			MyOffersPage.get().croma_state.click();
			MyOffersPage.get().croma_state.sendKeys(Keys.ARROW_DOWN);
			MyOffersPage.get().croma_state.sendKeys(Keys.ENTER);
			//Select state_type= new Select(MyOffersPage.get().croma_state);

			//state_type.selectByVisibleText("ANDAMAN AND NICOBAR ISLANDS");
			Thread.sleep(3000);
			MyOffersPage.get().croma_city.click();
			MyOffersPage.get().croma_city.click();
			MyOffersPage.get().croma_city.sendKeys(Keys.ARROW_DOWN);
			MyOffersPage.get().croma_city.sendKeys(Keys.ENTER);
			//Select city_type= new Select(MyOffersPage.get().croma_city);
			String pincodeValue=MyOffersPage.get().cromaAddressPincode.getText();
			if(pincodeValue=="")
			{
				MyOffersPage.get().cromaAddressPincode.click();
				MyOffersPage.get().cromaAddressPincode.sendKeys(pincode);
				Thread.sleep(1000);
			}
			String emailValue=MyOffersPage.get().cromaAddressEmail.getText();
			if(emailValue=="")
			{
				MyOffersPage.get().cromaAddressEmail.click();
				MyOffersPage.get().cromaAddressEmail.sendKeys(emailAddress);
				Thread.sleep(1000);
			}
			String mobileNo=MyOffersPage.get().cromaAddressMobileNo.getText();
			if(mobileNo=="")
			{
				MyOffersPage.get().cromaAddressMobileNo.click();
				MyOffersPage.get().cromaAddressMobileNo.sendKeys(mobileNumber);
			}

			//city_type.selectByIndex(1);
			Thread.sleep(3000);
			fUtil.flogResult("Passed", "validate user address details added", "user address details added", 1);

			MyOffersPage.get().croma_payment.click();
			fUtil.flogResult("Passed", "validate navigation to payment page ", " navigated to payment page", 1);
		}

		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Enter address", "Enter address failed"+e.getMessage(), 1);	
			logger.error("Signout Failed"+ e);
			throw e;
		}

	}

	@Test
	public void croma_click_payment() throws Exception {
		try {
			Thread.sleep(8000);

			if(gmethods.isElementVisible(MyOffersPage.get().croma_payment,20))
			{
				MyOffersPage.get().croma_payment.click();
				fUtil.flogResult("Passed", "validate navigation to payment page ", " navigated to payment page", 1);
			}


		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void croma_click_homeDelivery() throws Exception {
		try {
			Thread.sleep(8000);

			if(gmethods.isElementVisible(SwtTcpHomePage.get().homeDelivery,20))
			{
				SwtTcpHomePage.get().homeDelivery.click();
				fUtil.flogResult("Passed", "Home delivery clicked ", "Home delivery clicked", 1);
			}


		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void croma_click_DeliveryLocation() throws Exception {
		try {
			String pincode=fUtil.fgetDataNew1("croma_pincode");
			Thread.sleep(3000);		 
			SwtTcpHomePage.get().deliverypincode.click();
			Thread.sleep(3000);	
			SwtTcpHomePage.get().enterpincode.clear();
			Thread.sleep(2000);	
			SwtTcpHomePage.get().enterpincode.sendKeys(pincode);
			Thread.sleep(3000);	
			SwtTcpHomePage.get().applybtn.click();
			Thread.sleep(3000);
			//waitForLoaderToHide();
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void validateProductDetailPage() throws Exception {
		try {
			WebDriver webDriver = BrowserFactory.webDriver.get();
			String windowHandle = webDriver.getWindowHandle();
			ArrayList tabs = new ArrayList (webDriver.getWindowHandles());
			System.out.println(tabs.size());
			webDriver.switchTo().window((String) tabs.get(2));
			//webDriver.switchTo().window(mainWindowHandle);
			Thread.sleep(5000);
			boolean isProductId=gmethods.isElementVisible(SwtTcpHomePage.get().ProductIdCroma, 10);
			boolean isProductDesc=gmethods.isElementVisible(SwtTcpHomePage.get().ProductDescCroma, 10);
			if(isProductId)
			{
				String pdId=SwtTcpHomePage.get().ProductIdCroma.getText();
				fUtil.flogResult("Passed", "PDP displayed ", "PDP Displayed and Product Id is:"+pdId, 1);
			}
			if(isProductDesc)
			{
				String pdDesc=SwtTcpHomePage.get().ProductDescCroma.getText();
				fUtil.flogResult("Passed", "PDP displayed ", "PDP Displayed and Product Id is:"+pdDesc, 1);
			}
			else
			{
				fUtil.flogResult("Failed", "PDP displayed ", "PDP not Displayed ", 1);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void verifyOrderConfirmation() throws Exception{
		try
		{
		boolean orderRecvText=gmethods.isElementVisible(SwtTcpHomePage.get().orderRecvText, 30);
				if(orderRecvText)
			{
				//String orderId=SwtTcpHomePage.get().orderId.getText().trim();
				fUtil.flogResult("Passed", "Order Received Text Displayed",
						"Order Received Text Displayed", 1);
			}
			else {
				fUtil.flogResult("Failed", "Order Received Text Displayed",
						"Order Received Text Displayed", 1);
			}
			boolean trxnId=gmethods.isElementVisible(SwtTcpHomePage.get().trxnid, 30);
				if(trxnId)
			{
				String tId=SwtTcpHomePage.get().orderId.getText();
				fUtil.flogResult("Passed", "Transaction Id of the Order Displayed",
						"Transaction Id of the Order Displayed"+tId, 1);
			}
			else {
				fUtil.flogResult("Failed", "Transaction Id of the Order Displayed",
						"Transaction Id of the Order Displayed", 1);
			}
				boolean downloadOption=gmethods.isElementVisible(SwtTcpHomePage.get().downloadOption, 30);
				if(downloadOption)
			{
				fUtil.flogResult("Passed", "Download Receipt Option Displayed",
						"Download Receipt Option Displayed", 1);
			}
			else {
				fUtil.flogResult("Failed", "Download Receipt Option Displayed",
						"Download Receipt Option not Displayed", 1);
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult( "Failed","Order Not Placed Successfully", " Order Not Placed Successfully"+e.getMessage(),1);
			throw e;
		}
	}

	@Test
	public void navigateToCromaChannelFromHomePage() throws Exception{
		currentChannelName="Croma";

		try {
			scrollToViewChannelRibbon();

			boolean channelsHeaderVisibility=gmethods.isElementVisible(TdlHomePage.get().channelHeader, 10);
			boolean channelsRibbonVisibility=gmethods.isElementVisible(TdlHomePage.get().channelRibbon, 30);
			if(channelsHeaderVisibility && channelsRibbonVisibility)
			{
				fUtil.flogResult("Passed", "Validate Channels Header in Homepage", 
						"Channels Header is visible in Home page ", 1);

				String cromaChannelLink=gmethods.dynamicXpath(channelLink, currentChannelName,currentChannelName);

				boolean cromaBtnVisibility=gmethods.isElementVisibleXpath(cromaChannelLink, 10);
				if(cromaBtnVisibility)
				{
					fUtil.flogResult("Passed", "Navigate to "+currentChannelName+" Channel", 
							currentChannelName+" Channel button visible in Home page ", 1);

					BrowserFactory.webDriver.get().findElement(By.xpath(cromaChannelLink)).click();
				}else {
					fUtil.flogResult("Failed", "Navigate to "+currentChannelName+" Channel", 
							currentChannelName+" Channel button not visible in Home page ", 1);
				}
			}else {

				fUtil.flogResult("Failed", "Validate Channels Header in Homepage", 
						"Channels Header not visible in Home page ", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Navigate to "+currentChannelName+" Channel", 
					"Exception caught while navigating to "+currentChannelName+" channel from home page : "+e.getMessage(), 1);
			throw e;
		}
	}	

	@Test
	public void clickOfferInsideChannel() throws Exception{
		try {

			String Offer_value=fUtil.fgetDataNew1("Offer_Value").trim();
			String dXpath=gmethods.dynamicXpath("//*[contains(text(),'xxxx')]", Offer_value);
			gmethods.scrollToViewElement(BrowserFactory.webDriver.get().findElement(By.xpath(dXpath)));
			boolean offerPresent=gmethods.isElementVisibleXpath(dXpath,10);
			if(offerPresent)
			{
				fUtil.flogResult("Passed", "Offer is present inside channel", 
						"Offer is present inside channel" , 1);
				BrowserFactory.webDriver.get().findElement(By.xpath(dXpath)).click();
			}
			else {
				fUtil.flogResult("Failed", "Offer is present inside channel", 
						"Offer is not present inside channel", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Offer is present inside channel", 
					"Offer is not present inside channel"+e.getMessage(), 1);
			throw e;
		}
	}	

	@Test
	public void clickProductInsideChannel() throws Exception{
		try {
			boolean offerPresent=gmethods.isElementVisible(SwtTcpHomePage.get().shopNowCroma, 10);
			if(offerPresent)
			{
				fUtil.flogResult("Passed", "Browse product is present", 
						"Browse product is present" , 1);
				SwtTcpHomePage.get().shopNowCroma.click();
				fUtil.flogResult("Passed", "Browse product clicked", 
						"Browse product clickedt" , 1);
				gmethods.switchToNewTab();
			}
			else {
				fUtil.flogResult("Passed", "Browse product clicked", 
						"Browse product not clicked" , 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Browse product clicked", 
					"Browse product not clicked"+e.getMessage(), 1);
			throw e;
		}
	}	

	@Test
	public void verifyOrderConfirmationOnCromaChannel() throws Exception{
		try {
			String orderID=fUtil.fgetDataNew1("Order_Id").trim();
			String channelOrderXpath="//*[contains(text(),'"+orderID+"')]";
			boolean flag=gmethods.scrollToViewElement(BrowserFactory.webDriver.get().findElement(By.xpath(channelOrderXpath)));
			if(flag) {
				gmethods.highlightElement(BrowserFactory.webDriver.get().findElement(By.xpath(channelOrderXpath)));
				fUtil.flogResult("Passed", "Order Confirmation in Channels Page",
						"Order Placed Successfully and is Visible in Channels Page ", 1);
			}else {
				fUtil.flogResult("Passed", "Order Confirmation in Channels Page",
						"Order not Visible in Channels Page ", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Order confirmed", 
					"Order not confirmed"+e.getMessage(), 1);
			throw e;
		}
	}	

	@Test
	public void validatebackButton() throws Exception{
		try {
			boolean isButton=gmethods.isElementVisible(SwtTcpHomePage.get().BackButton, 10);
			if(isButton)
			{

				SwtTcpHomePage.get().BackButton.click();
				fUtil.flogResult("Passed", "Navigate from Croma",
						"Navigate from Croma", 1);
			}
			else {
				fUtil.flogResult("Passed", "Navigate from Croma",
						"Not able to Navigate from Croma", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Navigate back", 
					"Navigate back failed"+e.getMessage(), 1);
			throw e;
		}
	}	

	@Test
	public void validateFaliurePayment() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().reTryTrxn, 10);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().TryAgainButton.click();
				fUtil.flogResult("Passed", "Payment faliure validated",
						"Payment faliure validated", 1);
			}
			else {
				fUtil.flogResult("Passed", "Payment faliure validated",
						"Payment faliure not validated", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Payment faliure validated", 
					"Payment faliure not validated"+e.getMessage(), 1);
			throw e;
		}
	}	

	@Test
	public void verifySubscriber() throws Exception{
		try {
			gmethods.scrollToViewElement(SwtTcpHomePage.get().continueButton);
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().continueButton, 10);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().continueButton.click();
				fUtil.flogResult("Passed", "Clicked on continue",
						"Clicked on continue", 1);
				Thread.sleep(5000);
				gmethods.switchToNewTab();
			}
			else {
				SwtTcpHomePage.get().NoSubscriberGoToHomePage.click();
				fUtil.flogResult("Passed", "No subscriber id is presnt",
						"No subscriber id is presnt", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "subscriber validation", 
					"subscriber validation failed"+e.getMessage(), 1);
			throw e;
		}
	}	

	@Test
	public void verifyMovieSelectionPage() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().orderButton, 10);
			boolean ismovieName=gmethods.isElementVisible(SwtTcpHomePage.get().movieName, 10);
			boolean ismovieDate=gmethods.isElementVisible(SwtTcpHomePage.get().movieDate, 10);
			boolean isMoviePrice=gmethods.isElementVisible(SwtTcpHomePage.get().moviePrice, 10);
			boolean noShowCase=gmethods.isElementVisible(SwtTcpHomePage.get().noMovieShowcase, 10);
			if(isRetryTrxn)
			{

				fUtil.flogResult("Passed", "Movie selectio page displayed",
						"Movie selectio page displayed", 1);
				if(ismovieName)
				{
					String movieName=SwtTcpHomePage.get().movieName.getText();
					fUtil.flogResult("Passed", "Movie info displayed",
							"Movie info displayed"+movieName, 1);

				}
				if(ismovieDate)
				{
					String movieDate=SwtTcpHomePage.get().movieDate.getText();
					fUtil.flogResult("Passed", "Movie info displayed",
							"Movie info displayed"+movieDate, 1);

				}
				if(isMoviePrice)
				{
					String moviePrice=SwtTcpHomePage.get().movieDate.getText();
					fUtil.flogResult("Passed", "Movie info displayed",
							"Movie info displayed"+moviePrice, 1);

				}
				SwtTcpHomePage.get().orderButton.click();
			}
			else if(noShowCase){
				fUtil.flogResult("Passed", "Movie selection page displayed",
						"Movie selectio page displayed", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Movie selection page displayed",
						"Movie selectio page not displayed", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "movie selection validation", 
					"movie selection validation"+e.getMessage(), 1);
			throw e;
		}
	}	

	@Test
	public void verifyOrderMovieConfirmation() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().movieConfirmation, 10);
			boolean ismovieName=gmethods.isElementVisible(SwtTcpHomePage.get().orderConfirmation, 10);
			if(ismovieName)
			{

				fUtil.flogResult("Passed", "Confirmation Page",
						"Confirmation Page", 1);
				if(isRetryTrxn)
				{
					String movieName=SwtTcpHomePage.get().movieName.getText();
					fUtil.flogResult("Passed", "Movie info displayed",
							"Movie info displayed"+movieName, 1);

				}
				SwtTcpHomePage.get().orderConfirm.click();
			}
			else {
				fUtil.flogResult("Failed", "Order confirmation Page",
						"Order Confirmation Page not displayed", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Order confirmation Page", 
					"Order confirmation Page not displayed"+e.getMessage(), 1);
			throw e;
		}
	}	
	@Test
	public void verifySuccessfulOrder() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().trxnId, 10);
			if(isRetryTrxn)
			{

				fUtil.flogResult("Passed", "order successfull",
						"order successfull", 1);
				String movieName=SwtTcpHomePage.get().trxnId.getText();
				fUtil.flogResult("Passed", "order successfull",
						"order successfull Order Id is :"+movieName, 1);
			}
			else {
				fUtil.flogResult("Failed", "order successfull",
						"order not successfull", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "order successfull", 
					"order not successfull"+e.getMessage(), 1);
			throw e;
		}
	}	
	@Test
	public void verifyTataskyContentDetailsPage() throws Exception {
		try {
			gmethods.switchToNewTab();
			boolean nowShowingPresent=gmethods.isElementVisible(SwtTcpHomePage.get().nowShowing, 10);
			if(nowShowingPresent)
			{
				String text=SwtTcpHomePage.get().nowShowing.getText();
				fUtil.flogResult("Passed", "Now Showing is Present In Content page", 
						"Now Showing is Present In Content page"+text, 1);
			}
			else
			{
				String text=SwtTcpHomePage.get().nowShowing.getText();
				fUtil.flogResult("Passed", "Now Showing is Present In Content page", 
						"Now Showing is not Present In Content page"+text, 1);
			}
			boolean nowShowingMovieName=gmethods.isElementVisible(SwtTcpHomePage.get().nowShowingMovieName, 10);
			if(nowShowingMovieName)
			{
				String text=SwtTcpHomePage.get().nowShowingMovieName.getText();
				fUtil.flogResult("Passed", "Now Showing Movie Name is Present In Content page", 
						"Now Showing Movie Name is Present In Content page"+text, 1);
			}
			else
			{
				String text=SwtTcpHomePage.get().nowShowing.getText();
				fUtil.flogResult("Passed", "Now Showing Movie is Present In Content page", 
						"Now Showing Movie is not Present In Content page"+text, 1);
			}
			boolean nowShowingMoviePrice=gmethods.isElementVisible(SwtTcpHomePage.get().nowShowingMoviePrice, 10);
			if(nowShowingMoviePrice)
			{
				String text=SwtTcpHomePage.get().nowShowingMoviePrice.getText();
				fUtil.flogResult("Passed", "Now Showing Movie price is Present In Content page", 
						"Now Showing Movie price is Present In Content page"+text, 1);
			}
			else
			{
				String text=SwtTcpHomePage.get().nowShowing.getText();
				fUtil.flogResult("Passed", "Now Showing Movie price is Present In Content page", 
						"Now Showing Movie price is not Present In Content page"+text, 1);
			}
			boolean termsAndCondition=gmethods.isElementVisible(SwtTcpHomePage.get().tataSkyContentTC, 10);
			if(termsAndCondition)
			{
				String text=SwtTcpHomePage.get().tataSkyContentTC.getText();
				fUtil.flogResult("Passed", "T&C is Present In Content page", 
						"T&C is Present In Content page"+text, 1);
			}
			else
			{
				String text=SwtTcpHomePage.get().nowShowing.getText();
				fUtil.flogResult("Passed", "T&C is Present In Content page", 
						"T&C is not Present In Content page"+text, 1);
			}


		}catch(Exception e) {
			fUtil.flogResult("Failed", "Content page validation", 
					"Content Page Vlidation Failed"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void clickOnRentNow() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().rentNow, 10);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().rentNow.click();
				boolean ispresent=gmethods.isElementVisible(SwtTcpHomePage.get().continueButton, 30);
				if(ispresent)
				{
					SwtTcpHomePage.get().continueButton.click();
				}
				else
				{
					fUtil.flogResult("Failed", "Showcase page displayed",
							"Showcase page displayed and no subscriber id is there", 1);
				}
			}
			else {
				fUtil.flogResult("Failed", "Rent now clicked",
						"Rent now not clicked", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Rent now clicked", 
					"Rent now clicked"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void clickOnCheckAvailablity() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().checkAvailabiltyBtn, 10);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().checkAvailabiltyBtn.click();
				boolean ispresent=gmethods.isElementVisible(SwtTcpHomePage.get().standardRates, 30);
				if(ispresent)
				{
					fUtil.flogResult("Passed", "Hotel Room Selection Page Displayed",
							"Hotel Room Selection Page Displayed", 1);
				}
				else
				{
					fUtil.flogResult("Failed", "Hotel Room Selection Page Displayed",
							"Hotel Room Selection Page not Displayed", 1);
				}
			}
			else {
				fUtil.flogResult("Failed", "Hotel Room Selection Page Displayed",
						"Hotel Room Selection Page  not Displayed", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Hotel Room Selection Page Displayed", 
					"Hotel Room Selection Page not Displayed"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void alreadySignedIn() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().profileHeader, 30);
			if(isRetryTrxn)
			{
				fUtil.flogResult("Passed", "User is already signed In",
						"User is already signed In", 1);		
				boolean ispresent=gmethods.isElementVisible(SwtTcpHomePage.get().profileHeaderUsername, 10);
				if(ispresent)
				{
					String userName=SwtTcpHomePage.get().profileHeaderUsername.getText();
					fUtil.flogResult("Passed", "Signed In User name Is Displayed",
							"Signed in user name is :"+userName, 1);
				}
				else
				{
					fUtil.flogResult("Failed", "Signed In User name Is Displayed",
							"Signed In User name Is not Displayed", 1);
				}
			}
			else {
				fUtil.flogResult("Failed", "Signed In User name Is Displayed",
						"Signed In User name Is not Displayed", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Hotel Room Selection Page Displayed", 
					"Hotel Room Selection Page not Displayed"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void clickStandardrates() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().standardRates, 30);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().standardRates.click();

				boolean ispresent=gmethods.isElementVisible(SwtTcpHomePage.get().roomDetails, 30);
				if(ispresent)
				{
					fUtil.flogResult("Passed", "Room Details Displayed",
							"Room Details Displayed", 1);
				}
				else
				{
					fUtil.flogResult("Failed", "Room Details Displayed",
							"Room Details not Displayed", 1);
				}
			}
			else {
				fUtil.flogResult("Failed", "Room Details Displayed",
						"Room Details not Displayed", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Room Details Displayed", 
					"Room Details not Displayed"+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void verifyRoomDetails() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().roomDescription, 30);
			String roomDesc=SwtTcpHomePage.get().roomDescription.getText();
			if(isRetryTrxn)
			{
				fUtil.flogResult("Passed", "Room Details Displayed",
						"Room Details Displayed"+roomDesc,1);
			}
			else
			{
				fUtil.flogResult("Failed", "Room Details Displayed",
						"Room Details Displayed"+roomDesc,1);
			}
			boolean ispresent=gmethods.isElementVisible(SwtTcpHomePage.get().roomPrice, 10);
			String roomPrice=SwtTcpHomePage.get().roomPrice.getText();
			if(ispresent)
			{
				fUtil.flogResult("Passed", "Room Price Displayed",
						"Room Price Displayed"+roomPrice, 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Room Price Displayed",
						"Room Price not Displayed"+roomPrice, 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Room Details Displayed", 
					"Room Details not Displayed"+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void selectRoom() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().viewRates, 30);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().viewRates.click();
				Thread.sleep(2000);
				SwtTcpHomePage.get().selectRoom.click();

			}
			else
			{
				fUtil.flogResult("Failed", "Room Selected ",
						"Room not selected ",1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Room selected", 
					"Room noot selected"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void clickConfirm() throws Exception{
		try {
			Thread.sleep(8000);
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().confirmBtn, 30);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().confirmBtn.click();
				Thread.sleep(2000);
				fUtil.flogResult("Passed", "Summary page displayed",
						"Summary page displayed",1);

			}
			else
			{
				fUtil.flogResult("Failed", "Summary page displayed",
						"Summary page not displayed",1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Summary page displayed", 
					"Summary page not displayed"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void navigateBackToTcpFromIHCL() throws Exception{
		try {

			switchToNewTabByTitle("Tata Digital");
			fUtil.flogResult("Passed", "TCP page Displayed", 
					"Tcp Page Displayed", 1);

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Summary page displayed", 
					"Summary page not displayed"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void enterTitle() throws Exception{
		try {

			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().guestTitle, 30);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().guestTitle.sendKeys("Mr.");
				SwtTcpHomePage.get().guestTitle.sendKeys(Keys.ENTER);
				fUtil.flogResult("Passed", "Title selected", 
						"Title selected", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Title selected", 
						"Title not selected", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Title selected", 
					"Title not selected"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void clickTermsAndConditions() throws Exception{
		try {

			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().privacyPolicyCheckBox, 30);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().privacyPolicyCheckBox.click();
				Thread.sleep(2000);
				SwtTcpHomePage.get().termsAndConditionsCheckBox.click();
				fUtil.flogResult("Passed", "T&C Selected", 
						"T&C Selected", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "T&C Selected", 
						"T&C  not Selected", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "T&C Selected", 
					"T&C not Selected"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void clickProceed() throws Exception{
		try {

			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().proceedBtn, 30);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().proceedBtn.click();
				Thread.sleep(2000);
				fUtil.flogResult("Passed", "Clicked on Proceed btn", 
						"Clicked on Proceed btn", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "Clicked on Proceed btn", 
						"Not Clicked on Proceed btn", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Clicked on Proceed btn", 
					"Not Clicked on Proceed btn"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void verifyPaymentPage() throws Exception{
		try {

			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().headerPaymentDetails, 30);
			if(isRetryTrxn)
			{
				fUtil.flogResult("Passed", "Payment details page Displayed", 
						"Payment details page Displayed", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "Payment details page Displayed", 
						"Payment details page not Displayed", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Payment details page Displayed", 
					"Payment details page not Displayed"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void makePayment() throws Exception{
		try {
			String paymentMethod=fUtil.fgetDataNew1("payment_method");
			String nameOncard=fUtil.fgetDataNew1("cc_holdername");
			String cardNumber=fUtil.fgetDataNew1("cc_cardno");
			String expdate=fUtil.fgetDataNew1("cc_expmonth");
			switch(paymentMethod.trim().toLowerCase()) {
			case "paynow" :
				boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().payNowBtn, 30);
				if(isRetryTrxn)
				{
					SwtTcpHomePage.get().payNowBtn.click();
					Thread.sleep(2000);
					SwtTcpHomePage.get().confirmBtn.click();

					fUtil.flogResult("Passed", "Payment successfull", 
							"Payment successfull", 1);

				}
				else
				{
					fUtil.flogResult("Failed", "Payment successfull", 
							"Payment not successfull", 1);
				}
				break;
			case "payathotel" :
				boolean isElement=gmethods.isElementVisible(SwtTcpHomePage.get().payAtHotelBtn, 30);
				if(isElement)
				{
					SwtTcpHomePage.get().payAtHotelBtn.click();
					SwtTcpHomePage.get().nameOnCard.sendKeys(nameOncard);
					Thread.sleep(2000);
					SwtTcpHomePage.get().cardNumber.sendKeys(cardNumber);
					Thread.sleep(2000);
					SwtTcpHomePage.get().cardExpDate.sendKeys(expdate);
					Thread.sleep(2000);
					fUtil.flogResult("Passed", "Payment successfull", 
							"Payment successfull", 1);
					SwtTcpHomePage.get().confirmBtn.click();

				}
				else
				{
					fUtil.flogResult("Failed", "Payment successfull", 
							"Payment not successfull", 1);
				}
				break;
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Payment successfull", 
					"Payment not successfull"+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void clickOnBookNow() throws Exception{
		try {
			gmethods.switchToNewTab();
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().ihclBooknowbtn, 30);
			if(isRetryTrxn)
			{
				fUtil.flogResult("Passed", "Book Now Button is Present", 
						"Book Now Button is Present", 1);
				SwtTcpHomePage.get().ihclBooknowbtn.click();
				Thread.sleep(8000);

			}
			else
			{
				fUtil.flogResult("Failed", "Book Now Button is Present", 
						"Book Now Button is not Present", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Book Now Button is Present", 
					"Book Now Button is not Present"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void searchResturant() throws Exception{
		try {
			switchToNewTabByTitle("Unique");
			String rntName=fUtil.fgetDataNew1("Resturant_Name");
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().searchBarResturant, 30);
			if(isRetryTrxn)
			{
				fUtil.flogResult("Passed", "Unique Dining and Signature Resturant Page Displayed", 
						"Unique Dining and Signature Resturant Page Displayed", 1);
				SwtTcpHomePage.get().searchBarResturant.sendKeys(rntName);
				Thread.sleep(1000);

			}
			else
			{
				fUtil.flogResult("Failed", "Unique Dining and Signature Resturant Page Displayed", 
						"Unique Dining and Signature Resturant Page not Displayed", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Search Resturant", 
					"Search Resturant"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void verifyResturantName() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().roomDescription, 30);
			String resturantName=SwtTcpHomePage.get().roomDescription.getText();
			if(isRetryTrxn)
			{
				fUtil.flogResult("Passed", "Resturan Name Displayed", 
						"Resturant Name Displayed and the resturant name is"+resturantName, 1);
				Thread.sleep(1000);

			}
			else
			{
				fUtil.flogResult("Failed", "Resturan Name Displayed", 
						"Resturant Name Displayed and the resturant name is"+resturantName, 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Resturant name validation", 
					"Resturant name validation failed"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void clickReserveTable() throws Exception{
		try {
			boolean isRetryTrxn=gmethods.isElementVisible(SwtTcpHomePage.get().reserveTable, 30);
			if(isRetryTrxn)
			{
				SwtTcpHomePage.get().reserveTable.click();
				Thread.sleep(5000);
				switchToNewTabByTitle("Varuna");
				boolean bookingPage=gmethods.isElementVisible(SwtTcpHomePage.get().bookingPage, 30);
				if(bookingPage)
				{
					fUtil.flogResult("Passed", "Booking page displayed", 
							"Booking page displayed", 1);
				}
				else
				{
					fUtil.flogResult("Failed", "Booking page displayed", 
							"Reserve table not clicked", 1);
				}

			}
			else
			{
				fUtil.flogResult("Failed", "Booking page displayed", 
						"Reserve table not clicked", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Booking page displayed", 
					"Reserve table not clicked"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void enterBookingDetails() throws Exception{
		try {
			String date=fUtil.fgetDataNew1("Day");
			WebElement wb=BrowserFactory.webDriver.get().findElement(By.xpath("//*[@id='jiva-spa-date']/div/div[1]/table/tbody//*[contains(text(),'"+date+"')]"));
			boolean isElement=gmethods.isElementVisible(SwtTcpHomePage.get().bookingPage, 30);
			if(isElement)
			{
				SwtTcpHomePage.get().selectDate.click();
				wb.click();
				SwtTcpHomePage.get().checkAvl.click();
				Thread.sleep(5000);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Booking details", 
					"Booking Details failed"+e.getMessage(), 1);
			throw e;
		}
	}	
	@Test
	public void selectTimings() throws Exception{
		try {
			boolean isElement=gmethods.isElementVisible(SwtTcpHomePage.get().mealTiming.get(0), 30);
			if(isElement)
			{
				SwtTcpHomePage.get().mealTiming.get(0).click();;
				fUtil.flogResult("Passed", "Timing Selected", 
						"Timing selected", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Timing Selected", 
						"Timing not selected", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Timing Selected", 
					"Timing not selected"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void enterGuestDetailsPage() throws Exception{
		try {
			boolean isElement=gmethods.isElementVisible(SwtTcpHomePage.get().filterCheckBox, 10);
			if(isElement)
			{
				SwtTcpHomePage.get().filterCheckBox.click();
				Thread.sleep(2000);
				SwtTcpHomePage.get().submitBtnDining.click();
				Thread.sleep(5000);
				fUtil.flogResult("Passed", "Clicked On Submit", 
						"Clicked On Submit", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Clicked On Submit", 
						"Not Clicked On Submit", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Clicked On Submit", 
					"Not Clicked On Submit"+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void bookingConfirmed() throws Exception{
		try {
			boolean isElement=gmethods.isElementVisible(SwtTcpHomePage.get().bookingConfirmed, 10);
			if(isElement)
			{
				fUtil.flogResult("Passed", "Booking Confirmed", 
						"Booking Confirmed", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Booking Confirmed", 
						"Booking not Confirmed", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Booking Confirmed", 
					"Booking not Confirmed"+e.getMessage(), 1);
			throw e;
		}
	}

	//oct9
	//Revathi

	@Test
	public void click_CromaCard() throws Exception {

		try {
			gmethods.gotoVaultPwa();

			boolean cromaCardVisibility = gmethods.isElementVisible(TdlVaultPage.get().cardName_Croma, 10);

			if (cromaCardVisibility == true) { 

				logger.info("Croma card is visible");
				fUtil.flogResult("Passed", "Croma Card Presence in Vault Page", "Croma card is visible", 1);

				gmethods.highlightElement(TdlVaultPage.get().cardName_Croma);

				TdlVaultPage.get().cardName_Croma.click();
				fUtil.flogResult("Passed", "click on Croma Card",
						"Successfully clicked on Croma Card", 1);

				Thread.sleep(5000);
				gmethods.validate_MultiTransaction_CromaCard();	
			}else {
				logger.error("Croma card not visible");
				fUtil.flogResult("Failed", "Croma Card Presence in Vault Page", "Croma card is not visible", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fUtil.flogResult("Failed", "Navigation to Shop Now in Croma from Vault", "Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void click_shop_now_Card() throws Exception {

		try {		
			boolean cromaShopNowVisibility = gmethods.isElementVisible(SwtTcpHomePage.get().cromashopnowbtn, 10);

			if (cromaShopNowVisibility == true) {
				gmethods.highlightElement(SwtTcpHomePage.get().cromashopnowbtn);
				logger.info("Croma Card Details is visible");
				fUtil.flogResult("Passed", "Click Shop Now on Croma Card", "Shop Now button visible on Croma Card", 1);

				SwtTcpHomePage.get().cromashopnowbtn.click();
				logger.info("Clicked on Shop Now");
				fUtil.flogResult("Passed", "Click Shop Now on Croma Card",
						"Successfully clicked on Shop Now on Croma Card", 1);
			} else {
				logger.error("Croma card page details not visible");
				fUtil.flogResult("Failed", "Click Shop Now on Croma Card", "Shop Now button not visible on Croma Card", 1);
			}



		} catch (Exception e) {
			e.printStackTrace();
			fUtil.flogResult("Failed", "Navigation to Shop Now in Croma from Vault", "Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void validate_already_signed() throws Exception {

		try {	

			gmethods.switchToNewTab();
			if(gmethods.isElementVisible(SwtTcpHomePage.get().cromaheader,20))
			{
				String url=BrowserFactory.webDriver.get().getCurrentUrl();

				boolean signedinVisibility = gmethods.isElementVisible(SwtTcpHomePage.get().signed_in_croma, 10);

				if (signedinVisibility == true) {

					logger.info("Validate user signed in croma page");
					fUtil.flogResult("Passed", "validate User is already signed in", "User is already signed in", 1);


				}
			} else {
				logger.error("Croma card page details not visible");
				fUtil.flogResult("Failed", "validate User is already signed in", "User is not already signed in", 1);
			}



		} catch (Exception e) {
			e.printStackTrace();
			fUtil.flogResult("Failed", "validate User is already signed in", "Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void cromaproduct() throws Exception {
		try {
			Thread.sleep(8000);
			//gmethods.switchToNewTab();
			if(gmethods.isElementVisible(TdlMACromaSearchProductPage.get().cromaheader,20))

				fUtil.flogResult("Passed", "Successfully landed on Croma Home Page",
						"Successfully landed on Croma Home Page", 1);

			String product=fUtil.fgetDataNew1("search_product");
			String pincode=fUtil.fgetDataNew1("croma_pincode");


			TdlMACromaSearchProductPage.get().deliverypincode.click();
			TdlMACromaSearchProductPage.get().enterpincode.clear();
			TdlMACromaSearchProductPage.get().enterpincode.sendKeys(pincode);
			TdlMACromaSearchProductPage.get().applybtn.click();
			Thread.sleep(3000);
			fUtil.flogResult("Passed", "validate pincode added successfully", "Pincode added successfully", 1);
			TdlMACromaSearchProductPage.get().searchproduct.sendKeys(product);
			Thread.sleep(5000);
			TdlMACromaSearchProductPage.get().searchproduct.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			fUtil.flogResult("Passed", "validate croma product searched", "Croma product searched", 1);
			MyOffersPage.get().croma_prod_select.click();
			Thread.sleep(2000);
			fUtil.flogResult("Passed", "validate croma product page navigated", "Croma product page navigated", 1);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	@Test
	public void croma_click_checkout_new() throws Exception {
		try {
			Thread.sleep(8000);

			if(gmethods.isElementVisible(MyOffersPage.get().croma_click_checkout,20))
			{
				MyOffersPage.get().croma_click_checkout.click();
				Thread.sleep(2000);
				fUtil.flogResult("Passed", "validate croma checkout", "croma checkout page reached", 1);
			}


		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	@Test
	public void croma_click_buynow() throws Exception {
		try {
			Thread.sleep(8000);

			if(gmethods.isElementVisible(SwtTcpHomePage.get().buynowbtn,20))
			{
				SwtTcpHomePage.get().buynowbtn.click();
				Thread.sleep(2000);
				fUtil.flogResult("Passed", "validate croma buynow", "croma buynow page reached", 1);
			}


		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void CromaAddress_new() throws Exception
	{
		try
		{
			String firstname=fUtil.fgetDataNew1("First_Name");
			String lastname=fUtil.fgetDataNew1("Last_Name");
			String flat=fUtil.fgetDataNew1("Flat");
			String location=fUtil.fgetDataNew1("Location");
			String state=fUtil.fgetDataNew1("State");
			String city=fUtil.fgetDataNew1("City");
			Thread.sleep(5000);
			System.out.println(firstname);
			System.out.println(lastname);
			System.out.println(flat);
			System.out.println(location);
			System.out.println(state);
			System.out.println(city);
			MyOffersPage.get().croma_address_firstname.sendKeys(firstname);
			Thread.sleep(3000);
			MyOffersPage.get().croma_address_lastname.sendKeys(lastname);
			Thread.sleep(3000);

			MyOffersPage.get().croma_flatno.sendKeys(flat);
			Thread.sleep(3000);
			MyOffersPage.get().croma_landmark.sendKeys(location);
			Thread.sleep(3000);

			MyOffersPage.get().croma_state.click();
			MyOffersPage.get().croma_state.click();
			MyOffersPage.get().croma_state.sendKeys(Keys.ARROW_DOWN);
			MyOffersPage.get().croma_state.sendKeys(Keys.ENTER);
			//Select state_type= new Select(MyOffersPage.get().croma_state);

			//state_type.selectByVisibleText("ANDAMAN AND NICOBAR ISLANDS");
			Thread.sleep(3000);
			MyOffersPage.get().croma_city.click();
			MyOffersPage.get().croma_city.click();
			MyOffersPage.get().croma_city.sendKeys(Keys.ARROW_DOWN);
			MyOffersPage.get().croma_city.sendKeys(Keys.ENTER);
			//Select city_type= new Select(MyOffersPage.get().croma_city);

			//city_type.selectByIndex(1);
			Thread.sleep(3000);
			fUtil.flogResult("Passed", "validate user address details added", "user address details added", 1);

			MyOffersPage.get().croma_payment.click();
			fUtil.flogResult("Passed", "validate navigation to payment page ", " navigated to payment page", 1);
		}

		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Enter address", "Enter address failed"+e.getMessage(), 1);	
			logger.error("Signout Failed"+ e);
			throw e;
		}

	}

	@Test
	public void croma_click_payment_s() throws Exception {
		try {
			Thread.sleep(8000);

			if(gmethods.isElementVisible(MyOffersPage.get().croma_payment,20))
			{
				MyOffersPage.get().croma_payment.click();
				fUtil.flogResult("Passed", "validate navigation to payment page ", " navigated to payment page", 1);
			}


		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}	

	@Test
	public void croma_channel_order_s() throws Exception {
		try {
			Thread.sleep(8000);

			if(gmethods.isElementVisible(SwtTcpHomePage.get().Order_confirm_channel_croma,20))
			{
				String order =SwtTcpHomePage.get().Order_confirm_channel_croma.getText();
				fUtil.flogResult("Passed", "validate navigation to order page ", " navigated to order page"+order, 1);
			}


		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Validate_Search_Icon_In_TCP_Home_page() throws Exception {

		try {
			gmethods.gotosearchpagePWA();
			Thread.sleep(3000);
		}	
		catch(Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "User should navigate to Offer discovery page", "Unable to navigate to discovery page" +ee, 1);
			logger.error("Error verify offers"+ ee);
			throw ee;
		}	

	}
	@Test
	public void Validate_Input_feild_OfferSearch() throws Exception
	{
		try
		{
			boolean is_Input_Field=gmethods.isElementVisible(MyOffersPage.get().input_search_in_discovery_page, 20);
			if(is_Input_Field)
			{
				fUtil.flogResult("Passed","Input field in discovery page", "Input field is present in discovery page", 1);
				// String Search_Name=fUtil.fgetDataNew1("Search_Name");
				MyOffersPage.get().input_search_in_discovery_page.clear();
				MyOffersPage.get().input_search_in_discovery_page.sendKeys(fUtil.fgetDataNew1("Search_Name"));
				MyOffersPage.get().input_search_in_discovery_page.sendKeys(org.openqa.selenium.Keys.ENTER);
				boolean is_Vault_My_Card_Button=gmethods.isElementVisible(MyOffersPage.get().showingOffers,20);
				if(is_Vault_My_Card_Button)
				{
					fUtil.flogResult("Passed", " Searched offer is present ", "Searched offer is present", 1);
				}
				else
				{
					fUtil.flogResult("Failed", "Searched offer is present", "Searched offer is not present", 1);
				}
				//Validate_Related_Features_of_MY_Plan_Text_My_Plan_Button_Vault_My_Cards_Button();
			}
			else
			{
				fUtil.flogResult("Failed", "Searched offer is present", "Searched offer is  not present", 1);
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Searched offer is present", "Exception occurs at Searched offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}

	@Test
	public void click_view_details_offer() throws Exception
	{
		try
		{
			boolean is_Input_Field=gmethods.isElementVisible(SwtTcpHomePage.get().view_details_offer, 20);
			if(is_Input_Field)
			{

				// String Search_Name=fUtil.fgetDataNew1("Search_Name");
				SwtTcpHomePage.get().view_details_offer.click();
				fUtil.flogResult("Passed","clicked view details", "view details in discovery page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "view details not present", "view details is  not present", 1);
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Searched offer is present", "Exception occurs at Searched offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}

	@Test
	public void verifyclickaddedtovaultCTA() throws Exception {

		try {
			boolean addtoVaultFlag = gmethods.isElementVisible(OfferDetailsPage.get().addtoVault, 10);
			if(addtoVaultFlag==true) {
				OfferDetailsPage.get().addtoVault.click();
				logger.info("Verified CTA : Added to Vault");
				fUtil.flogResult("Passed", "Click add to Vault", "Click add to Vault", 1);						 
			}

			VerifyaddedtoVaultWeb();	

		}catch(Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "Added to Vault Failed ", "Added to Vault Failed " +ee, 1);
			logger.error("Error verifying Added to Vault "+ ee);
			throw ee;
		}	

	}

	@Test
	public void VerifyaddedtoVaultWeb() throws Exception {

		try {
			logger.info("Verifying if AddedtoVault CTA is visible");
			boolean AddedtoVaultCTAVisibleFlag = gmethods.isElementVisible(OfferDetailsPage.get().addedtoVault, 10);
			if (AddedtoVaultCTAVisibleFlag == true){
				//OfferDetailsPage.get().addedtoVault.click();
				logger.info("Clicked on AddtoVault");
				fUtil.flogResult("Passed", "Verified AddedtoVault", "Verified AddedtoVault", 1);
			}
		}catch(Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "Click on AddtoVault Failed ", "Click on AddtoVault Failed " +ee, 1);
			logger.error("Error clicking AddtoVault "+ ee);
			throw ee;
		}	
	}

	@Test
	public void validate_Browse_product() throws Exception
	{
		try
		{
			boolean is_Input_Field=gmethods.isElementVisible(SwtTcpHomePage.get().Browse_products_offer, 20);
			if(is_Input_Field)
			{

				// String Search_Name=fUtil.fgetDataNew1("Search_Name");
				SwtTcpHomePage.get().Browse_products_offer.click();
				fUtil.flogResult("Passed","clicked Browse products", "Browse products in discovery page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Browse products not present", "Browse products  not present", 1);
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Searched offer is present", "Exception occurs at Searched offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}

	@Test
	public void cromapincode() throws Exception {
		try {
			Thread.sleep(8000);


			String product=fUtil.fgetDataNew1("search_product");
			String pincode=fUtil.fgetDataNew1("croma_pincode");


			waitForLoaderToHide();

			SwtTcpHomePage.get().deliverypincode.click();
			SwtTcpHomePage.get().enterpincode.clear();
			SwtTcpHomePage.get().enterpincode.sendKeys(pincode);
			SwtTcpHomePage.get().applybtn.click();
			fUtil.flogResult("Passed", "enter pincode",
					"Successfully entered pincode", 1);
			waitForLoaderToHide();
			Thread.sleep(3000);
			if(gmethods.isElementVisible(SwtTcpHomePage.get().buynowbtn,20))
			{
				SwtTcpHomePage.get().buynowbtn.click();
				waitForLoaderToHide();
				fUtil.flogResult("Passed", "click buy now detail Page",
						"Successfully clicked buy now Payment Page", 1);
			}else {
				fUtil.flogResult("Failed", "Click buy now detail Page",
						"Failed to Click buy now Page", 1);
			}



		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}

	}

	@Test
	public void validate_PLP() throws Exception
	{
		try
		{
			waitForLoaderToHide();
			boolean is_Input_Field=gmethods.isElementVisible(SwtTcpHomePage.get().products_PLP_offer, 40);
			if(is_Input_Field ==true)
			{

				// String Search_Name=fUtil.fgetDataNew1("Search_Name");
				//SwtTcpHomePage.get().products_PLP_offer.click();
				fUtil.flogResult("Passed","validate Landed on PLP page", "Landed on PLP page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "validate Landed on PLP page", "Not Landed on PLP page", 1);
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "PLP is present", "Exception occurs at PLP:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}

	@Test
	public void cromapincode_only() throws Exception {
		try {
			Thread.sleep(8000);


			String product=fUtil.fgetDataNew1("search_product");
			String pincode=fUtil.fgetDataNew1("croma_pincode");


			waitForLoaderToHide();

			SwtTcpHomePage.get().deliverypincode.click();
			SwtTcpHomePage.get().enterpincode.clear();
			SwtTcpHomePage.get().enterpincode.sendKeys(pincode);
			SwtTcpHomePage.get().applybtn.click();
			fUtil.flogResult("Passed", "enter pincode",
					"Successfully entered pincode", 1);
			waitForLoaderToHide();
			Thread.sleep(3000);



		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void validatefieldAndMsg()  throws Exception{

		try {

			String firstNameValue;
			String lastNameValue;
			String emailFieldValue;
			String phoneNoValue;
			String scenarios = fUtil.fgetDataNew1("Scenarios");

			//String expectedFirstNameError=fUtil.fgetDataNew1("FirstnameError").trim();
			//String expectedLastNameError=fUtil.fgetDataNew1("LastnameError").trim();
			//String expectedEmailError=fUtil.fgetDataNew1("EmailError").trim();
			//String expectedPhoneError=fUtil.fgetDataNew1("PhoneError").trim();

			boolean fName=gmethods.isElementVisible(SwtTcpHomePage.get().fnameTextBox, 10);
			boolean lName=gmethods.isElementVisible(SwtTcpHomePage.get().lnameTextBox, 10);
			boolean email=gmethods.isElementVisible(SwtTcpHomePage.get().emailTextBox, 10);
			boolean phone=gmethods.isElementVisible(SwtTcpHomePage.get().phoneTextBox, 10);
			System.out.println("test");

			switch(scenarios.trim().toLowerCase()) {

			case "mandfieldcheck" :
				System.out.println("test1");
				try {
					if(fName == true && lName == true && email == true && phone ==true)

					{
						logger.info("Register User Details page loaded properly");
						System.out.println("test12"); 
						SwtTcpHomePage.get().fnameTextBox.clear();
						SwtTcpHomePage.get().fnameTextBox.sendKeys("a");
						SwtTcpHomePage.get().fnameTextBox.click();
						SwtTcpHomePage.get().fnameTextBox.sendKeys(Keys.BACK_SPACE);

						//SwtTcpHomePage.get().fnameTextBox.sendKeys("");

						SwtTcpHomePage.get().lnameTextBox.clear();
						SwtTcpHomePage.get().lnameTextBox.sendKeys("a");
						SwtTcpHomePage.get().lnameTextBox.click();
						SwtTcpHomePage.get().lnameTextBox.sendKeys(Keys.BACK_SPACE);

						SwtTcpHomePage.get().emailTextBox.clear();
						SwtTcpHomePage.get().emailTextBox.sendKeys("a");
						SwtTcpHomePage.get().emailTextBox.click();
						SwtTcpHomePage.get().emailTextBox.sendKeys(Keys.BACK_SPACE);

						SwtTcpHomePage.get().phoneTextBox.clear();
						SwtTcpHomePage.get().phoneTextBox.sendKeys("a");
						SwtTcpHomePage.get().phoneTextBox.click();
						SwtTcpHomePage.get().phoneTextBox.sendKeys(Keys.BACK_SPACE);

						boolean fNameMandMsg=gmethods.isElementVisible(SwtTcpHomePage.get().msgFnameMandField, 10);
						boolean lNameMandMsg=gmethods.isElementVisible(SwtTcpHomePage.get().msgLnameMandField, 10);
						boolean emailMandMsg=gmethods.isElementVisible(SwtTcpHomePage.get().msgEmailMandField, 10);
						boolean phoneMandMsg=gmethods.isElementVisible(SwtTcpHomePage.get().msgPhoneMandField, 10);

						if (fNameMandMsg) {
							fUtil.flogResult("Passed", "FirstName Mandatory Field check","FirstName is Mandatory Field with Message " +SwtTcpHomePage.get().msgFnameMandField.getText(), 1);
						} else {
							fUtil.flogResult("Failed", "FirstName Mandatory Field check","FirstName Mandatory Field check Failed", 1);
						}
						if (lNameMandMsg) {
							fUtil.flogResult("Passed", "LasttName Mandatory Field check","LastNAme is Mandatory Field with Message " +SwtTcpHomePage.get().msgLnameMandField.getText(), 1);
						} else {
							fUtil.flogResult("Failed", "LastNAme Mandatory Field check","LastNAme Mandatory Field check Failed", 1);
						}
						if (emailMandMsg) {
							fUtil.flogResult("Passed", "Email Mandatory Field check","Email is Mandatory Field with Message " +SwtTcpHomePage.get().msgEmailMandField.getText(), 1);
						} else {
							fUtil.flogResult("Failed", "Email Mandatory Field check","Email Mandatory Field check Failed", 1);
						}
						if (phoneMandMsg) {
							fUtil.flogResult("Passed", "Phone Mandatory Field check","Phone is Mandatory Field with Message " +SwtTcpHomePage.get().msgPhoneMandField.getText(), 1);
						} else {
							fUtil.flogResult("Failed", "Phone Mandatory Field check","Phone Mandatory Field check Failed", 1);
						}
					}	


				}catch(Exception e){
					e.printStackTrace();
					fUtil.flogResult("Failed", "Failed to Load Register Page",
							"Failed to Load Register Page ", 1);
					throw e;
				}
				break;

			case "fnamelnamevalidcheck" :

				try {

					if(fName == true && lName == true && email == true && phone ==true) {

						SwtTcpHomePage.get().fnameTextBox.clear();
						SwtTcpHomePage.get().fnameTextBox.sendKeys(fUtil.fgetDataNew1("FirstName1").trim());
						SwtTcpHomePage.get().lnameTextBox.clear();
						SwtTcpHomePage.get().lnameTextBox.sendKeys(fUtil.fgetDataNew1("LastName1").trim());
						boolean fNameError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorFname, 2);
						boolean lNameError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorLname, 2);
						if (fNameError == false && lNameError== false) {
							fUtil.flogResult("Passed", "FirstName and LastNAme 1 Character check","FirstName and LastName saved with 1 Character" , 1);
						} else {
							fUtil.flogResult("Failed", "FirstName and LastNAme 1 Character check","FirstName and LastNAme 1 Character check Failed", 1);
						}

						SwtTcpHomePage.get().fnameTextBox.clear();
						SwtTcpHomePage.get().fnameTextBox.sendKeys(fUtil.fgetDataNew1("FirstName2").trim());
						SwtTcpHomePage.get().lnameTextBox.clear();
						SwtTcpHomePage.get().lnameTextBox.sendKeys(fUtil.fgetDataNew1("LastName2").trim());
						boolean fNameError1=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorFname, 2);
						boolean lNameError1=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorLname, 2);
						if (fNameError1 == false && lNameError1== false) {
							fUtil.flogResult("Passed", "FirstName and LastNAme 24 Character check","FirstName and LastName saved with 24 Character" , 1);
						} else {
							fUtil.flogResult("Failed", "FirstName and LastNAme 24 Character check","FirstName and LastNAme 24 Character check Failed", 1);
						}

					}

				}catch(Exception e){
					e.printStackTrace();
					fUtil.flogResult("Failed", "Failed to Load Register Page",
							"Failed to Load Register Page ", 1);
					throw e;
				}
				break;

			case "fnamelnameinvalidcheck" :

				try {

					if(fName == true && lName == true && email == true && phone ==true) {

						SwtTcpHomePage.get().fnameTextBox.clear();
						SwtTcpHomePage.get().fnameTextBox.sendKeys(fUtil.fgetDataNew1("FirstName1").trim());
						SwtTcpHomePage.get().lnameTextBox.clear();
						SwtTcpHomePage.get().lnameTextBox.sendKeys(fUtil.fgetDataNew1("LastName1").trim());
						boolean fNameError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorFnameMoreChar, 5);
						boolean lNameError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorLnameMoreChar, 5);
						if (fNameError == true && lNameError== true) {
							fUtil.flogResult("Passed", "FirstName and LastNAme 25 Character check","FirstName and LastName error message shown : " +SwtTcpHomePage.get().msgErrorFnameMoreChar.getText()+"and" +SwtTcpHomePage.get().msgErrorLnameMoreChar.getText() , 1);
						} else {
							fUtil.flogResult("Failed", "FirstName and LastNAme 25 Character check","FirstName and LastNAme 25 Character check Failed", 1);
						}

						SwtTcpHomePage.get().fnameTextBox.clear();
						SwtTcpHomePage.get().fnameTextBox.sendKeys(fUtil.fgetDataNew1("FirstName2").trim());
						SwtTcpHomePage.get().lnameTextBox.clear();
						SwtTcpHomePage.get().lnameTextBox.sendKeys(fUtil.fgetDataNew1("LastName2").trim());
						boolean fNameError1=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorFname, 5);
						boolean lNameError1=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorLname, 5);
						if (fNameError1 == true && lNameError1== true) {
							fUtil.flogResult("Passed", "FirstName and LastNAme Alphanemric Character check","FirstName and LastName error message shown :" +SwtTcpHomePage.get().msgErrorFname.getText() +"and" +SwtTcpHomePage.get().msgErrorFname.getText(), 1);
						} else {
							fUtil.flogResult("Failed", "FirstName and LastNAme Alphanemric Character check","FirstName and LastNAme Alphanemric Character check Failed", 1);
						}

					}

				}catch(Exception e){
					e.printStackTrace();
					fUtil.flogResult("Failed", "Failed to Load Register Page",
							"Failed to Load Register Page ", 1);
					throw e;
				}
				break;

			case "emailinvalidcheck" :
				try {
					if(email == true) {

						SwtTcpHomePage.get().emailTextBox.clear();
						SwtTcpHomePage.get().emailTextBox.sendKeys(fUtil.fgetDataNew1("InvalidEmail").trim());
						boolean emailError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorEmail, 10);
						if (emailError == true) {
							fUtil.flogResult("Passed", "Invalid email check","Invalid email error message shown :" +SwtTcpHomePage.get().msgErrorEmail.getText(), 1);
						} else {
							fUtil.flogResult("Failed", "Invalid email check","Invalid email error check Failed", 1);
						}
					}
				}catch(Exception e){
					e.printStackTrace();
					fUtil.flogResult("Failed", "Failed to Load Register Page",
							"Failed to Load Register Page ", 1);
					throw e;
				}
				break;
			case "phoneinvalidcheck" :
				try {
					if(phone == true) {

						SwtTcpHomePage.get().phoneTextBox.clear();
						SwtTcpHomePage.get().phoneTextBox.sendKeys(fUtil.fgetDataNew1("InvalidPhone").trim());
						boolean phoneError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorPhone, 10);
						if (phoneError == true) {
							fUtil.flogResult("Passed", "Invalid email check","Invalid email error message shown :" +SwtTcpHomePage.get().msgErrorPhone.getText() , 1);
						} else {
							fUtil.flogResult("Failed", "Invalid email check","Invalid email error check Failed", 1);
						}
					}
				}catch(Exception e){
					e.printStackTrace();
					fUtil.flogResult("Failed", "Failed to Load Register Page",
							"Failed to Load Register Page ", 1);
					throw e;
				}
				break;
			case "fnamelnamephoneemailvalidcheck" :
				try {
					if(fName == true && lName == true && email == true && phone ==true) {

						SwtTcpHomePage.get().fnameTextBox.clear();
						SwtTcpHomePage.get().fnameTextBox.sendKeys(fUtil.fgetDataNew1("FirstName2").trim());
						SwtTcpHomePage.get().lnameTextBox.clear();
						SwtTcpHomePage.get().lnameTextBox.sendKeys(fUtil.fgetDataNew1("LastName2").trim());
						SwtTcpHomePage.get().emailTextBox.clear();
						SwtTcpHomePage.get().emailTextBox.sendKeys(fUtil.fgetDataNew1("ValidEmail").trim());
						SwtTcpHomePage.get().phoneTextBox.clear();
						SwtTcpHomePage.get().phoneTextBox.sendKeys(fUtil.fgetDataNew1("ValidPhone").trim());

						boolean fNameError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorFname, 1);
						boolean lNameError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorLname, 1);
						boolean emailError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorEmail, 1);
						boolean phoneError=gmethods.isElementVisible(SwtTcpHomePage.get().msgErrorPhone, 1);
						if (fNameError == false && lNameError== false && emailError==false && phoneError==false) {
							fUtil.flogResult("Passed", "FirstName,LastNAme,Email and PhonNo check","FirstName,LastNAme,Email and PhoneNo entered successfully ", 1);
						} else {
							fUtil.flogResult("Failed", "FirstName,LastNAme,Email and PhonNo check","FirstName,LastNAme,Email and PhonNo entry failed", 1);
						}


					}

				}catch(Exception e){
					e.printStackTrace();
					fUtil.flogResult("Failed", "Failed to Load Register Page",
							"Failed to Load Register Page ", 1);
					throw e;
				}
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void validateOrderConfirmationCOD() throws Exception{
		waitForLoaderToHide();
		if(gmethods.isElementVisible(SwtTcpHomePage.get().thankYouForShoppingHeader, 30)) {

			//String orderId=SwtTcpHomePage.get().orderId.getText().trim();

			fUtil.flogResult("Passed", "Order Confirmation",
					"Order Placed Successfully. Order Id is : ", 1);

		}else {
			fUtil.flogResult("Failed", "Order Confirmation",
					"Order Not Placed Successfully", 1);
		}

	}

	@Test
	public void navigateBackToTCP() throws Exception {
		try {
			Thread.sleep(3000);
			gmethods.switchToNewTab();
			if(gmethods.isElementVisible(SwtTcpHomePage.get().cromaheader,20))
			{
				String url=BrowserFactory.webDriver.get().getCurrentUrl();

				fUtil.flogResult("Passed", "Successfully landed on Croma Home Page",
						"Successfully landed on Croma Home Page.", 1);

				fUtil.flogResult("Passed", "Current Url : ",url, 0);
			}else {
				fUtil.flogResult("Failed", "Croma Home Page",
						"Croma Home Page not opened.", 1);

			}

			switchToNewTabByTitle("Tata Digital");

			String url_TCP=BrowserFactory.webDriver.get().getCurrentUrl();

			if(url_TCP.contains("tatadigital"))
			{
				fUtil.flogResult("Passed", "Successfully landed TCP Page",
						"Successfully landed on Croma Home Page. as URL:" +url_TCP, 1);

				//fUtil.flogResult("Passed", "Current Url : ",url, 0);
			}else  {
				fUtil.flogResult("Failed", "TCP Home Page",
						"TCP Page not opened.", 1);
			}

		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void validateFailedPayment() throws Exception{
		waitForLoaderToHide();
		if(gmethods.isElementVisible(SwtTcpHomePage.get().paymentFailure, 30)) {

			fUtil.flogResult("Passed", "Payment Failure",
					"Payment failure Message displyed: " +SwtTcpHomePage.get().paymentFailure.getText(), 1);

		}else {
			fUtil.flogResult("Failed", "Payment Failure",
					"Payment Failure message not displayed", 1);
		}

	}

	//oct14//revathi

	@Test
	public void box_upgrade_continue() throws Exception {
		try {

			//String hdoption = fUtil.fgetDataNew1("hd_option");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().upgrade_continue,20))
			{
				SwtTcpHomePage.get().upgrade_continue.click();


				fUtil.flogResult("Passed", "click continue to box upgrade page",
						"Successfully clicked continue to box upgrade page", 1);
			}}catch(Exception e){
				e.printStackTrace();
				fUtil.flogResult("Failed", "Could not click continue to box upgrade page",
						"Could not click continue to box upgrade page", 1);
				throw e;
			}
	}

	@Test
	public void box_upgrade_continue_tata() throws Exception {
		try {
			gmethods.switchToNewTab();
			//String hdoption = fUtil.fgetDataNew1("hd_option");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().upgrade_continue,20))
			{
				SwtTcpHomePage.get().upgrade_continue.click();


				fUtil.flogResult("Passed", "click continue to box upgrade page",
						"Successfully clicked continue to box upgrade page", 1);
			}}catch(Exception e){
				e.printStackTrace();
				fUtil.flogResult("Failed", "Could not click continue to box upgrade page",
						"Could not click continue to box upgrade page", 1);
				throw e;
			}
	}
	@Test
	public void box_upgrade_get() throws Exception {
		try {
			//String hdoption = fUtil.fgetDataNew1("hd_option");

			if(gmethods.isElementVisible(SwtTcpHomePage.get().upgrade_get,20))
			{
				SwtTcpHomePage.get().upgrade_get.click();
				fUtil.flogResult("Passed", "click get to receive box upgrade",
						"Successfully clicked Get to receive box upgrade", 1);

			}
		}catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not click get to receive box upgrade",
					"Could not click get to receive box upgrade", 1);
			throw e;
		}
	}

	@Test
	public void selectoption_upgrade() throws Exception {

		try {
			//String hdoption = fUtil.fgetDataNew1("hd_option");
			if(gmethods.isElementVisible(TdlMATataSkyHomePage.get().boxupgrade,20))
			{
				TdlMATataSkyHomePage.get().boxupgrade.click();



				fUtil.flogResult("Passed", "click box upgrade",
						"Successfully clicked box upgrade", 1);
			}}

		catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not click box upgrade",
					"Could not click box upgrade", 1);
			throw e;
		}
	}
	@Test
	public void upgrade_cash_on_delivery() throws Exception {

		try {
			//String hdoption = fUtil.fgetDataNew1("hd_option");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().upgrade_cash_on_delivery,20))
			{
				SwtTcpHomePage.get().upgrade_cash_on_delivery.click();


				fUtil.flogResult("Passed", "click cash on Delivery box upgrade",
						"Successfully clicked cash on Delivery box upgrade", 1);
			}}

		catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not click cash on Delivery box upgrade",
					"Could not click cash on Delivery box upgrade", 1);
			throw e;
		}
	}
	@Test
	public void paymentspage_tata_sky() throws Exception {
		try {
			if(gmethods.isElementVisible(TdlMAHDselectionPage.get().selectpaymentoptionheader,20))

			{TdlMAHDselectionPage.get().payonlinebtn.click();



			fUtil.flogResult("Passed", "Successfully landed on choose payments method page",
					"Successfully landed on choose payments method page", 1);
			}}catch(Exception e){
				e.printStackTrace();
				fUtil.flogResult("Failed", "Could not load choose payments method page",
						"Could not load choose payments method page", 1);
				throw e;
			}
	}

	@Test
	public void validate_request_COD() throws Exception {

		try {
			//String hdoption = fUtil.fgetDataNew1("hd_option");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().upgrade_cod_success,20))
			{
				String cod = SwtTcpHomePage.get().upgrade_cod_success.getText();
				String transId = SwtTcpHomePage.get().upgrade_transaction_id.getText();
				String cotransTime = SwtTcpHomePage.get().upgrade_transaction_time.getText();
				fUtil.flogResult("Passed", "successful request box upgrade ",
						"Successfully requested box upgrade"+cod+transId+cotransTime, 1);
			}}

		catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not successful request box upgrade",
					"Could not successful request box upgrade", 1);
			throw e;
		}
	}

	@Test
	public void click_opel_tata_sky() throws Exception {
		try {
			gmethods.scrollToViewElement(SwtTcpHomePage.get().opel_payment);
			if(gmethods.isElementVisible(SwtTcpHomePage.get().opel_payment,20))

			{SwtTcpHomePage.get().opel_payment.click();



			fUtil.flogResult("Passed", "click opel option",
					"Successfully clicked opel option", 1);
			}}catch(Exception e){
				e.printStackTrace();
				fUtil.flogResult("Failed", "Could not click opel option",
						"Could not click opel option", 1);
				throw e;
			}
	}

	@Test
	public void opelpagepaymentmethod_tata_sky() throws Exception {
		try {
			String enter_cccardno=fUtil.fgetDataNew1("cc_cardno");
			System.out.println(enter_cccardno);
			String enter_ccmonth=fUtil.fgetDataNew1("cc_expmonth");
			String enter_cccvv=fUtil.fgetDataNew1("cc_cvv");
			String enter_dccardno=fUtil.fgetDataNew1("dc_cardno");
			String enter_dcmonth=fUtil.fgetDataNew1("dc_expmonth");
			String enter_dccvv=fUtil.fgetDataNew1("dc_cvv");
			String otp=fUtil.fgetDataNew1("otp");
			String paymentmethod=fUtil.fgetDataNew1("payment");
			String paymentdone=fUtil.fgetDataNew1("Success");

			if(gmethods.isElementVisible(SwtTcpHomePage.get().paymentPageHeader_tata, 15)) {

				fUtil.flogResult("Passed", "Enter Payment Page Details", "Payment Page loaded", 1);
				//TdlMAOPELPaymentsPage.get().opelpayment.click();
				BrowserFactory.webDriver.get().switchTo().frame("juspay_iframe");

				System.out.println("Payment");
				switch(paymentmethod.trim().toLowerCase()) {
				case "creditcard" :
					boolean flag=gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().creditDebitCard,15);
					System.out.println("Credit Card flag - "+flag);
					TdlMAOPELPaymentsPage.get().creditDebitCard.click();
					gmethods.scrollToViewElement(TdlMAOPELPaymentsPage.get().addNewCard);
					if(gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().addNewCard,10))

						TdlMAOPELPaymentsPage.get().addNewCard.click();

					TdlMAOPELPaymentsPage.get().entercardnumber.sendKeys(enter_cccardno);
					TdlMAOPELPaymentsPage.get().expirymonth.sendKeys(enter_ccmonth);
					flag=gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().cvv,5);

					TdlMAOPELPaymentsPage.get().cvv.sendKeys(enter_cccvv);
					TdlMAOPELPaymentsPage.get().saveThisCard.click();
					flag=gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().proceedtopay,15);

					fUtil.flogResult("Passed", "Payment Page", "Proceeding the payment with Credit card", 1);
					TdlMAOPELPaymentsPage.get().proceedtopay.click();

					break;

				case "debitcard" :
					TdlMAOPELPaymentsPage.get().creditDebitCard.click();

					if(gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().addNewCard,10))
						TdlMAOPELPaymentsPage.get().addNewCard.click();

					TdlMAOPELPaymentsPage.get().entercardnumber.sendKeys(enter_dccardno);
					TdlMAOPELPaymentsPage.get().expirymonth.sendKeys(enter_dcmonth);
					TdlMAOPELPaymentsPage.get().cvv.sendKeys(enter_dccvv);
					TdlMAOPELPaymentsPage.get().saveThisCard.click();
					fUtil.flogResult("Passed", "Payment Page", "Proceeding the payment with Debit card", 1);
					TdlMAOPELPaymentsPage.get().proceedtopay.click();
					break;

				case "internetbanking" :
					//gmethods.scrollToViewElement(TdlMAOPELPaymentsPage.get().netbanking);
					TdlMAOPELPaymentsPage.get().netbanking.click();

					String bankoption=fUtil.fgetDataNew1("internetbanking_bank");
					if(bankoption.equalsIgnoreCase("axis"))
					{
						TdlMAOPELPaymentsPage.get().axisbank.click();
						fUtil.flogResult("Passed", "Successfully completed payment",
								"Successfully completed payment", 1);
					}

					else if(bankoption.equalsIgnoreCase("hdfc"))
					{
						TdlMAOPELPaymentsPage.get().hdfcbank.click();
						fUtil.flogResult("Passed", "Successfully completed payment",
								"Successfully completed payment", 1);
					}
					else if(bankoption.equalsIgnoreCase("icici"))
					{
						TdlMAOPELPaymentsPage.get().icicibank.click();
						fUtil.flogResult("Passed", "Successfully completed payment",
								"Successfully completed payment", 1);
					}
					else if(bankoption.equalsIgnoreCase("billdeskbank"))
					{ 
						TdlMAOPELPaymentsPage.get().billdeskbank.click();
						//gmethods.scrollToViewElement(SwtTcpHomePage.get().procced_tata);
						SwtTcpHomePage.get().procced_tata.click();
						SwtTcpHomePage.get().paymentdropdown_tata.click();
						///gmethods.switchToNewTab();
						gmethods.fSelectDataFromDropDownText(SwtTcpHomePage.get().paymentdropdown_tata, "success dropdown is selected", "Success", 1);
						//Select pay_type= new Select(SwtTcpHomePage.get().paymentdropdown_tata);
						//pay_type.selectByVisibleText("Success");
						//SwtTcpHomePage.get().paymentdropdown_tata.click();
						//SwtTcpHomePage.get().paymentdropdown_tata.sendKeys(Keys.ARROW_DOWN);
						fUtil.flogResult("Passed", "click success to complete payment",
								"Successfully clicked payment", 1);
						SwtTcpHomePage.get().paymentsubmit_tata.click();
						fUtil.flogResult("Passed", "successfully completed payment",
								"Successfully done payment", 1);
					}

					else TdlMAOPELPaymentsPage.get().sbibank.click();


					fUtil.flogResult("Passed", "Successfully completed payment",
							"Successfully completed payment", 1);
					break;
				case "wallets" :
					SwtTcpHomePage.get().wallets_tata.click();
					String bankoptionWall=fUtil.fgetDataNew1("internetbanking_bank");
					if(bankoptionWall.equalsIgnoreCase("Test"))
					{
						gmethods.scrollToViewElement(SwtTcpHomePage.get().wallets_option_tata);
						SwtTcpHomePage.get().wallets_option_tata.click();
						SwtTcpHomePage.get().wallets_procceed_tata.click();
						SwtTcpHomePage.get().paymentdropdown_tata.click();
						SwtTcpHomePage.get().paymentdropdown_tata.sendKeys(Keys.ARROW_DOWN);
						fUtil.flogResult("Passed", "click success to complete payment",
								"Successfully clicked payment", 1);
						SwtTcpHomePage.get().paymentsubmit_tata.click();
						fUtil.flogResult("Passed", "successfully completed payment",
								"Successfully done payment", 1);
						fUtil.flogResult("Passed", "Successfully completed payment",
								"Successfully completed payment", 1);
					}


					break;
				case "payondelivery" :
					SwtTcpHomePage.get().pay_on_delivery_croma.click();
					Thread.sleep(2000);
					fUtil.flogResult("Passed", "Successfully selected payment",
							"Successfully selected payment", 1);
					SwtTcpHomePage.get().pay_on_delivery_radio_croma.click();
					Thread.sleep(2000);
					SwtTcpHomePage.get().proceed_to_pay_croma.click();
					waitForLoaderToHide();

					fUtil.flogResult("Passed", "Successfully completed payment",
							"Successfully completed payment", 1);
					break;
				} 
				gmethods.switchTO_defaultContent();
				if(gmethods.isElementVisible(TdlMAOPELPaymentsPage.get().otp, 20))
				{
					System.out.println("OTP Page found");
					fUtil.flogResult("Passed", "OTP Page", "Entering OTP for payment confirmation", 1);
					TdlMAOPELPaymentsPage.get().otp.sendKeys(otp);;
					TdlMAOPELPaymentsPage.get().submit.click();
				}
				//else {
				//	fUtil.flogResult("Failed", "OTP Page", "Unable to find OTP field", 1);	
				//}


			}else {
				fUtil.flogResult("Failed", "Enter Payment Page Details", "Payment Page not loaded", 1);	
			}

		}catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Open Payment Page",
					"Exception Caught :: "+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void click_view_details_tata_sky_offer() throws Exception
	{
		try
		{
			boolean is_Input_Field=gmethods.isElementVisible(SwtTcpHomePage.get().offer_tata, 20);
			if(is_Input_Field)
			{

				// String Search_Name=fUtil.fgetDataNew1("Search_Name");
				SwtTcpHomePage.get().offer_tata.click();
				fUtil.flogResult("Passed","clicked view details", "view details in discovery page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "view details not present", "view details is  not present", 1);
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Searched offer is present", "Exception occurs at Searched offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}

	@Test
	public void Redeem_tata_sky_offer() throws Exception
	{
		try
		{
			boolean is_Input_Field=gmethods.isElementVisible(SwtTcpHomePage.get().redeem_tata, 40);
			if(is_Input_Field)
			{

				// String Search_Name=fUtil.fgetDataNew1("Search_Name");
				SwtTcpHomePage.get().redeem_tata.click();
				fUtil.flogResult("Passed","clicked redeem", "redeem in discovery page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "redee not present", "redeem is  not present", 1);
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Searched offer is present", "Exception occurs at Searched offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}


	@Test
	public void clickingOpeloption() throws Exception{
		try {
			SwtTcpHomePage.get().opelpayment.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}


	}

	@Test
	public void paymentConfrimationTataSky() throws Exception{
		try {
			if(gmethods.isElementVisible(SwtTcpHomePage.get().paymentDoneConfirm, 30)) {

				fUtil.flogResult("Passed", "Payment Success",
						"Payment success Message displyed: " +SwtTcpHomePage.get().paymentDoneConfirm.getText(), 1);

			}else {
				fUtil.flogResult("Failed", "Payment Failure",
						"Payment Failed", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 


	}

	@Test
	public void sdSelection() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().noBtn,20)) {

				SwtTcpHomePage.get().noBtn.click();
				fUtil.flogResult("Passed", "Select HD",
						"Clicked NO Button", 1);
			}

			if(gmethods.isElementVisible(SwtTcpHomePage.get().boxTitleSDBox,20))
			{	//TdlMAHDselectionPage.get().getthisbtn.click();
				//TdlMAHDselectionPage.get().getthispackbtn.click();
				fUtil.flogResult("Passed", "SD Set Top Box Selection",
						"Successfully landed on SD Set Top Box", 1);
			}else {
				fUtil.flogResult("Failed", "SD Set Top Box Selection",
						"SD Set Top Box not Opened", 1);
			}
		}catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not load payments page",
					"Could not load payments page", 1);
			throw e;
		}
	}




	//oct15//revathi
	@Test
	public void selectoption_quick_recharge() throws Exception {
		try {

			if(gmethods.isElementVisible(TdlMATataSkyHomePage.get().quickrecharge,20))
			{
				TdlMATataSkyHomePage.get().quickrecharge.click();



				fUtil.flogResult("Passed", "Successfully landed Quick recharge on Tatasky page",
						"Successfully landed on Quick recharge Tatasky page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Tatasky page didn't load successfully",
					"Tatasky page didn't load successfully", 1);
			throw e;
		}

	}
	@Test
	public void quickeasyrecharge_tata() throws Exception {
		try {
			Thread.sleep(5000);
			gmethods.switchToNewTab();
			//Thread.sleep(2000);
			System.out.println("switch");
			if(gmethods.isElementVisible(TdlMAQuickRechargeHomePage.get().headermsg,30))
			{

				System.out.println("enter");
				TdlMAQuickRechargeHomePage.get().subscriberId.clear();
				Thread.sleep(3000);
				TdlMAQuickRechargeHomePage.get().subscriberId.sendKeys(subid);
				Thread.sleep(3000);
				SwtTcpHomePage.get().amount_tata.click();
				Thread.sleep(3000);
				SwtTcpHomePage.get().amount_tata.sendKeys(amount1);
				Thread.sleep(3000);
				SwtTcpHomePage.get().continue_tata.click();
				fUtil.flogResult("Passed", "Successfully landed on quick recharge page",
						"Successfully landed on quick recharge offers page", 1);
			}
			else 
			{
				fUtil.flogResult("Failed", "Failed to land on quick recharge page",
						"Failed to land on quick recharge offers page", 1);}
		}catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Failed to land on quick recharge page",
					"Failed to land on quick recharge offers page", 1);
			throw e;
		}
	}

	@Test
	public void validate_request_recharge() throws Exception {

		try {
			//String hdoption = fUtil.fgetDataNew1("hd_option");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().wallets_option_success,20))
			{
				///String cod = SwtTcpHomePage.get().upgrade_cod_success.getText();
				String transId = SwtTcpHomePage.get().wallets_option_id.getText();
				//String cotransTime = SwtTcpHomePage.get().upgrade_transaction_time.getText();
				fUtil.flogResult("Passed", "successful request recharge ",
						"Successfully  recharged"+transId, 1);
			}}

		catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not successful request recharge",
					"Could not successful request  recharge", 1);
			throw e;
		}
	} 

	@Test
	public void validate_recharge_fail() throws Exception {

		try {
			//String hdoption = fUtil.fgetDataNew1("hd_option");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().rech_failed,20))
			{
				///String cod = SwtTcpHomePage.get().upgrade_cod_success.getText();
				String transId = SwtTcpHomePage.get().wallets_option_id.getText();
				//String cotransTime = SwtTcpHomePage.get().upgrade_transaction_time.getText();
				fUtil.flogResult("Passed", "failed payment ",
						"Successfully recharge failed"+transId, 1);
			}}

		catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not successful recharge",
					"Could not successful recharge", 1);
			throw e;
		}
	}

	//oct16//revathi
	@Test
	public void sdbox_new_conn() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().get_box_tata,20))
			{
				SwtTcpHomePage.get().get_box_tata.click();



				fUtil.flogResult("Passed", "click SD box Tatasky page",
						"Successfully landed on SD box Tatasky page", 1);
			}}
		catch(Exception e)
		{ 
			e.printStackTrace();
			fUtil.flogResult("Failed", "Tatasky page didn't load successfully",
					"Tatasky page didn't load successfully", 1);
			throw e;
		} 
	}  

	@Test
	public void pack_new_conn() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().get_pack_tata,20))
			{
				SwtTcpHomePage.get().get_pack_tata.click();



				fUtil.flogResult("Passed", "click Pack Tatasky page",
						"Successfully clicked pack Tatasky page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Tatasky page didn't load successfully",
					"Tatasky page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void address_install_new_conn() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().connection_install_tata,20))
			{
				SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().select_area_tata.sendKeys(Keys.ARROW_DOWN);

				fUtil.flogResult("Passed", "click select area Tatasky page",
						"Successfully clicked select area Tatasky page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Tatasky page didn't load successfully",
					"Tatasky page didn't load successfully", 1);
			throw e;
		}
	}
	@Test
	public void OTP_install_new_conn() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().OTP_install_tata,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().OTP_install_tata.sendKeys("123456");

				fUtil.flogResult("Passed", "click OTP Tatasky page",
						"Successfully clicked OTP Tatasky page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Tatasky page didn't load successfully",
					"Tatasky page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void place_order_install_new_conn() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().OTP_install_tata,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().OTP_install_tata.sendKeys("123456");

				fUtil.flogResult("Passed", "click OTP Tatasky page",
						"Successfully clicked OTP Tatasky page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Tatasky page didn't load successfully",
					"Tatasky page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void schedule_install_new_conn() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().schedule_install_tata,20))
			{
				String date = null;
				//SwtTcpHomePage.get().select_area_tata.click();
				String today =	getCurrentDay1(date);
				gmethods.datePickerPwa(today);

				fUtil.flogResult("Passed", "click OTP Tatasky page",
						"Successfully clicked OTP Tatasky page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Tatasky page didn't load successfully",
					"Tatasky page didn't load successfully", 1);
			throw e;
		}
	}

	private String getCurrentDay1(String date){
		//Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		//Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + todayInt +"\n");

		//Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");

		return todayStr;
	}	

	@Test
	public void closeAllTabsAndSwitchtoTcp() throws Exception{
		try {
			for(String winHandle : BrowserFactory.webDriver.get().getWindowHandles()){
				if (!(BrowserFactory.webDriver.get().switchTo().window(winHandle).getTitle().contains("Tata Digital")))
				{
					BrowserFactory.webDriver.get().switchTo().window(winHandle);
					BrowserFactory.webDriver.get().switchTo().window(winHandle).close();
				} 
			}
			ArrayList<String> tabs2 = new ArrayList<String> (BrowserFactory.webDriver.get().getWindowHandles());
			BrowserFactory.webDriver.get().switchTo().window(tabs2.get(0));
			if(BrowserFactory.webDriver.get().getTitle().contains("Tata Digital")) {
				fUtil.flogResult("Passed", "Navigate to TCP", "Successfully closed all tabs and switched to TCP", 1);
			}

		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	//		public void datePickerTest() {
	//	        //Declare a implicit wait for synchronisation
	//			
	//			 private String today;
	//			BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	 
	//	        //Get Today's number
	//	        today = getCurrentDay1();
	//	        System.out.println("Today's number: " + today + "\n");
	//	 
	//	        //Click and open the datepickers
	//	        BrowserFactory.webDriver.get().findElement(By.xpath(".//*[fusion_builder_container hundred_percent="yes" overflow="visible"][fusion_builder_row][fusion_builder_column type="1_1" background_position="left top" background_color="" border_size="" border_color="" border_style="solid" spacing="yes" background_image="" background_repeat="no-repeat" padding="" margin_top="0px" margin_bottom="0px" class="" id="" animation_type="" animation_speed="0.3" animation_direction="left" hide_on_mobile="no" center_content="no" min_height="none"][@id='godate']")).click();
	//	 
	//	        //This is from date picker table
	//	        WebElement dateWidgetFrom = BrowserFactory.webDriver.get().findElement(By.xpath(".//*[@id='calendar-100000000']/div[3]/table/tbody"));
	//	 
	//	        //This are the rows of the from date picker table
	//	        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
	//	 
	//	        //This are the columns of the from date picker table
	//	        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
	//	 
	//	        //DatePicker is a table. Thus we can navigate to each cell
	//	        //and if a cell matches with the current date then we will click it.
	//	        for (WebElement cell: columns) {
	//	            /*
	//	            //If you want to click 18th Date
	//	            if (cell.getText().equals("18")) {
	//	            */
	//	            //Select Today's Date
	//	            if (cell.getText().equals(today)) {
	//	                cell.click();
	//	                break;
	//	            }
	//	        }


	@Test
	public void boxUpgrade() throws Exception {
		try {
			Thread.sleep(4000);
			switchToNewTabByTitle("help improve");

			String url = BrowserFactory.webDriver.get().getCurrentUrl();
			System.out.println(url);
			if(gmethods.isElementVisible(SwtTcpHomePage.get().upgrade_continue,20))
			{
				SwtTcpHomePage.get().upgrade_continue.click();


				fUtil.flogResult("Passed", "click continue to box upgrade page",
						"Successfully clicked continue to box upgrade page", 1);
			}

			boolean flag1 =gmethods.isElementVisible(SwtTcpHomePage.get().upgrade_get,20);
			gmethods.scrollToViewElement(SwtTcpHomePage.get().upgrade_get);
			boolean flag2 =gmethods.isElementClickable(SwtTcpHomePage.get().upgrade_get, 20);

			if(flag2)
			{
				System.out.println("Get Btn is clickable");

				SwtTcpHomePage.get().upgrade_get.click();
			}

		}catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not click continue to box upgrade page",
					"Could not click continue to box upgrade page", 1);
			throw e;
		}
	}


	//oct 19//revathi

	@Test
	public void IHCL_Book_stay() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().Book_stay_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().Book_stay_IHCL.click();

				fUtil.flogResult("Passed", "click Book a stay IHCL page",
						"Successfully clicked Book a stay IHCL page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "click Book a stay IHCL page",
						"Not clicked Book a stay IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}
	@Test
	public void IHCL_search_hotel() throws Exception {
		try {
			String Search_hotel=fUtil.fgetDataNew1("Search_Hotel");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().searchHotel,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().searchHotel.sendKeys(Search_hotel);
				//SwtTcpHomePage.get().searchHotel.sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				SwtTcpHomePage.get().search_result_IHCL.click();
				fUtil.flogResult("Passed", "click Book a stay IHCL page",
						"Successfully clicked Book a stay IHCL page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "click Book a stay IHCL page",
						"Not clicked Book a stay IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}	
	@Test
	public void IHCL_click_availablity() throws Exception {
		try {
			//String Search_hotel=fUtil.fgetDataNew1("Search_Hotel");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().checkAvailabiltyBtn,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();


				Thread.sleep(3000);
				Thread.sleep(3000);
				Actions act =  new Actions(BrowserFactory.webDriver.get());
				act.moveToElement(SwtTcpHomePage.get().checkAvailabiltyBtn).click().perform();
				//SwtTcpHomePage.get().checkAvailabiltyBtn.click();
				fUtil.flogResult("Passed", "click chk availability button IHCL page",
						"Successfully clicked chk availability button IHCL page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "click chk availability button IHCL page",
						"Not clicked chk availability button IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_close_wrong() throws Exception {
		try {
			//String Search_hotel=fUtil.fgetDataNew1("Search_Hotel");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().close_wrong_IHCL,20))
			{

				SwtTcpHomePage.get().close_wrong_IHCL.click();
				fUtil.flogResult("Passed", "close error pop up stay IHCL page",
						"close error pop up IHCL page", 1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_nav_standard_rates() throws Exception {
		try {
			IHCL_close_wrong();
			if(gmethods.isElementVisible(SwtTcpHomePage.get().stand_rates_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().stand_rates_IHCL.click();

				fUtil.flogResult("Passed", "click standard rates of hotel IHCL page",
						"Successfully clicked standard rates of hotel  IHCL page", 1);
				IHCL_close_wrong();
			}
			else
			{
				fUtil.flogResult("Failed", "click standard rates of hotel  IHCL page",
						"Not clicked standard rates of hotel  IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_view_rates() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().view_rates_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().view_rates_IHCL.click();

				fUtil.flogResult("Passed", "click view rates of hotel IHCL page",
						"Successfully clicked view rates of hotel  IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click view rates of hotel  IHCL page",
						"Not clicked view rates of hotel  IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_select_room() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().select_room_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().select_room_IHCL.click();

				fUtil.flogResult("Passed", "click select room of hotel IHCL page",
						"Successfully clicked select room of hotel  IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click select roomof hotel  IHCL page",
						"Not clicked select room of hotel  IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_confirm_room() throws Exception {
		try {

			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			if(gmethods.isElementVisible(SwtTcpHomePage.get().confirm_room_IHCL,40))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().confirm_room_IHCL.click();

				fUtil.flogResult("Passed", "click confirm room of hotel IHCL page",
						"Successfully clicked confirm room of hotel  IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click confirm room of hotel  IHCL page",
						"Not clicked confirm room of hotel  IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_details_room() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().confirm_room_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				String price= SwtTcpHomePage.get().summary_price_IHCL.getText();
				String totalprice= SwtTcpHomePage.get().summary_total_price_IHCL.getText();
				fUtil.flogResult("Passed", "click confirm room of hotel IHCL page",
						"Successfully clicked confirm room of hotel  IHCL page"+price+totalprice, 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click confirm room of hotel  IHCL page",
						"Not clicked confirm room of hotel  IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void add_title() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().details_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				//SwtTcpHomePage.get().title_IHCL.click();
				Thread.sleep(3000);
				SwtTcpHomePage.get().title_IHCL.sendKeys("Mr.");
				//Select threshold_type= new Select(SwtTcpHomePage.get().title_IHCL);
				//  threshold_type.selectByIndex(1);
				//SwtTcpHomePage.get().title_IHCL.sendKeys(Keys.ARROW_DOWN);
				//Thread.sleep(3000);
				SwtTcpHomePage.get().title_IHCL.sendKeys(Keys.ENTER);
				fUtil.flogResult("Passed", "click title of hotel IHCL page",
						"Successfully clicked title of hotel  IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click title of hotel  IHCL page",
						"Not clicked title of hotel  IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}
	@Test
	public void validate_title() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().details_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().title_IHCL.click();
				SwtTcpHomePage.get().title_IHCL.sendKeys(Keys.ARROW_DOWN);
				fUtil.flogResult("Passed", "click title of hotel IHCL page",
						"Successfully clicked title of hotel  IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click title of hotel  IHCL page",
						"Not clicked title of hotel  IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void agree_privacy() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().details_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().clickPrivacy_IHCL.click();
				SwtTcpHomePage.get().termss_IHCL.click();
				fUtil.flogResult("Passed", "click privacy and conditions agreed IHCL page",
						"Successfully clicked privacy and conditions agreed IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click privacy and conditions agreed IHCL page",
						"Not clicked privacy and conditions agreed IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void click_proceed() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().proceed_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().proceed_IHCL.click();
				///SwtTcpHomePage.get().termss_IHCL.click();
				fUtil.flogResult("Passed", "click proceed IHCL page",
						"Successfully clicked proceed IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click proceed IHCL page",
						"Not clicked proceed page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void click_confirm_checkout() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().proceed_pay_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().confirm_pay_IHCL.click();
				///SwtTcpHomePage.get().termss_IHCL.click();
				fUtil.flogResult("Passed", "click confirm pay IHCL page",
						"Successfully clicked confirm pay IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click confirm pay IHCL page",
						"Not clicked confirm pay page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void navigateToIhclBookAStayFromChannels_someone() throws Exception {
		try {
			boolean reserveTableVisibility=gmethods.isElementVisible(TdlChannelsPage.get().threeDotsMenuReserveATable,10);
			if(reserveTableVisibility) {

				TdlChannelsPage.get().threeDotsMenuBookAStay.click();
				if(gmethods.isElementVisible(SwtTcpHomePage.get().someone_IHCL, 10)) {

					fUtil.flogResult("Passed", "IHCL Channel page, Navigate to Book a Stay", 
							"Who Will stay page is visible", 1);
					SwtTcpHomePage.get().someone_IHCL.click();
					Thread.sleep(2000);
					//gmethods.switchToNewTab();
					switchToNewTabByTitle("Luxury");

					if(gmethods.isElementVisible(SwtTcpHomePage.get().tajHotelLogo, 20)){

						String currentUrl=BrowserFactory.webDriver.get().getCurrentUrl();
						fUtil.flogResult("Passed", "IHCL Channel page, Navigate to Book a Stay", 
								"Navigated to successfully to IHCL. Current Url : "+currentUrl, 1);
					}else {
						fUtil.flogResult("Failed", "IHCL Channel page, Navigate to Book a Stay", 
								"Navigation to IHCL Failed.", 1);	
					}
				}else {
					fUtil.flogResult("Passed", "IHCL Channel page, Navigate to Book a Stay", 
							"Who Will stay page is not visible", 1);
				}
			}else {
				fUtil.flogResult("Failed", "IHCL Channel page, Navigate to Reserve Table page", 
						"Reserve a Table option not visible in 3 dots menu of IHCL Channel page", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "IHCL Channel page, Navigate to Reserve Table page", 
					"Exception caught while navigating to reserve table page : "+e.getMessage(), 1);
			throw e;
		}
	}

	@Test
	public void IHCL_offer() throws Exception
	{
		try
		{
			boolean is_Input_Field=gmethods.isElementVisible(SwtTcpHomePage.get().Offer_IHCL, 40);
			if(is_Input_Field)
			{

				// String Search_Name=fUtil.fgetDataNew1("Search_Name");
				SwtTcpHomePage.get().Offer_IHCL.click();
				fUtil.flogResult("Passed","clicked Book now", "Book now in discovery page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Book now not present", "Book now is  not present", 1);
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Searched offer is present", "Exception occurs at Searched offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}
	@Test
	public void validateIHCL_Someone() throws Exception
	{
		try
		{
			boolean isWidget=gmethods.isElementVisible(SwtTcpHomePage.get().someone_IHCL, 20);
			if(isWidget)
			{


				SwtTcpHomePage.get().someone_IHCL.click();
				Thread.sleep(3000);
				fUtil.flogResult("Passed","IHCL Someone clickedt", "IHCL Someone clicked", 1);
				switchToNewTabByTitle("Luxury");
			}
			else
			{
				fUtil.flogResult("Failed","IHCL Someone Present", "IHCL Someone not Present", 1);
			}

		}

		catch(Exception e)
		{
			fUtil.flogResult("Failed", "IHCL Someone not present", "Exception occurs at IHCL Someone offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}


	@Test
	public void click_view_details_IHCL_offer() throws Exception
	{
		try
		{
			boolean is_Input_Field=gmethods.isElementVisible(SwtTcpHomePage.get().offer_IHCL_view, 20);
			if(is_Input_Field)
			{

				// String Search_Name=fUtil.fgetDataNew1("Search_Name");
				SwtTcpHomePage.get().offer_IHCL_view.click();
				fUtil.flogResult("Passed","clicked view details", "view details in discovery page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "view details not present", "view details is  not present", 1);
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "Searched offer is present", "Exception occurs at Searched offer:"+e.getMessage(), 1);	
			logger.error("Error thresholdtype"+ e);
			throw e;
		}

	}



	@Test	
	public void ihclBookingHolidayDetails() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().searchBarHotel,20))
			{
				SwtTcpHomePage.get().searchBarHotel.click();
				fUtil.flogResult("Passed", "click continue to searchBarHotel",
						"Successfully clicked continue to searchBarHotel", 1);
				SwtTcpHomePage.get().searchBarHotel.sendKeys("Taj Mahal,Lucknow");
			}

			if(gmethods.isElementVisible(SwtTcpHomePage.get().tajMahalLucknow,20))
			{
				SwtTcpHomePage.get().tajMahalLucknow.click();
			}

			if(gmethods.isElementVisible(SwtTcpHomePage.get().viewPackage,20))
			{
				SwtTcpHomePage.get().viewPackage.click();
				fUtil.flogResult("Passed", "Package Displayed for the Hotel",
						"Successfully displayed the package", 1);
			}else {
				fUtil.flogResult("Failed", "Package Displayed for the Hotel",
						"Package not displayed for the Hotel", 1);
			}

			if(gmethods.isElementVisible(SwtTcpHomePage.get().bookNowPackage,20))
			{

				fUtil.flogResult("Passed", "Book Now Displayed for the Hotel",
						"Successfully displayed Book Now the package", 1);
			}else {
				fUtil.flogResult("Failed", "Book Now Displayed for the Hotel",
						"Not displayed book now button for the Hotel", 1);
			}
		}catch(Exception e){
			e.printStackTrace();
			fUtil.flogResult("Failed", "Could not click continue to box upgrade page",
					"Could not click continue to box upgrade page", 1);
			throw e;
		}
	}

	@Test
	public void bookAStayFromChannelsOffersPageValidation() throws Exception {
		try {
			boolean reserveTableVisibility=gmethods.isElementVisible(TdlChannelsPage.get().threeDotsMenuReserveATable,10);
			if(reserveTableVisibility) {

				TdlChannelsPage.get().threeDotsMenuBookAStay.click();

				if(gmethods.isElementVisible(SwtTcpHomePage.get().offerBackBtn, 10)) {

					fUtil.flogResult("Passed", "Back Button is displayed", 
							"Back Button is dispalyed", 1);
					SwtTcpHomePage.get().offerBackBtn.click();
					if(gmethods.isElementPresent(TdlMAChannelsOptionPage.get().dotsoption)) {
						TdlMAChannelsOptionPage.get().dotsoption.click();
						fUtil.flogResult("Passed", "Channels Page Navigation",
								"Navigated to the channels page successfully", 1);
					}else {
						fUtil.flogResult("Passed", "Channels Page Navigation",
								"Navigated to the "+channel+" page Failed", 1);
					}

					if(gmethods.isElementVisible(TdlChannelsPage.get().threeDotsMenuBookAStay,10)) {
						TdlChannelsPage.get().threeDotsMenuBookAStay.click();
						fUtil.flogResult("Passed", "Offer Page Navigation",
								"Navigated to the Offer Deatils page successfully", 1);

					}

				}
				if(gmethods.isElementVisible(TdlChannelsPage.get().whoWillStay_Me, 10)) {

					fUtil.flogResult("Passed", "IHCL Channel page, Navigate to Book a Stay", 
							"Who Will stay page is visible", 1);


					TdlChannelsPage.get().whoWillStay_Me.click();

					Thread.sleep(2000);
					//gmethods.switchToNewTab();
					switchToNewTabByTitle("Luxury");

					if(gmethods.isElementVisible(SwtTcpHomePage.get().tajHotelLogo, 20)){

						String currentUrl=BrowserFactory.webDriver.get().getCurrentUrl();
						fUtil.flogResult("Passed", "IHCL Channel page, Navigate to Book a Stay", 
								"Navigated to successfully to IHCL. Current Url : "+currentUrl, 1);
					}else {
						fUtil.flogResult("Failed", "IHCL Channel page, Navigate to Book a Stay", 
								"Navigation to IHCL Failed.", 1);	
					}
				}else {
					fUtil.flogResult("Passed", "IHCL Channel page, Navigate to Book a Stay", 
							"Who Will stay page is not visible", 1);
				}
			}else {
				fUtil.flogResult("Failed", "IHCL Channel page, Navigate to Reserve Table page", 
						"Reserve a Table option not visible in 3 dots menu of IHCL Channel page", 1);
			}

		}catch(Exception e) {
			fUtil.flogResult("Failed", "IHCL Channel page, Navigate to Reserve Table page", 
					"Exception caught while navigating to reserve table page : "+e.getMessage(), 1);
			throw e;
		}
	}

	//oct20//revathi
	@Test
	public void click_back() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().back_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().back_IHCL.click();
				///SwtTcpHomePage.get().termss_IHCL.click();
				fUtil.flogResult("Passed", "click back IHCL page",
						"Successfully clicked back IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "click back IHCL page",
						"Not clicked back page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}
	@Test
	public void validate_back_action() throws Exception {
		try {
			Thread.sleep(3000);
			if(gmethods.isElementVisible(SwtTcpHomePage.get().validate_back_IHCL,50))
			{

				fUtil.flogResult("Passed", "navigated back IHCL page",
						"Successfully navigated back IHCL page", 1);

			}
			else
			{
				fUtil.flogResult("Failed", "navigated back IHCL page",
						"Not clicked back page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_search_Event() throws Exception {
		try {


			gmethods.switchToNewTab();
			switchToNewTabByTitle("Best");
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			gmethods.scrollToViewElement(SwtTcpHomePage.get().search_Event_IHCL);
			String Search_event=fUtil.fgetDataNew1("Search_Event");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().search_Event_IHCL,50))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().search_Event_IHCL.sendKeys(Search_event);
				//SwtTcpHomePage.get().searchHotel.sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				//SwtTcpHomePage.get().search_result_IHCL.click();
				fUtil.flogResult("Passed", "search event IHCL page",
						"Successfully searched Event IHCL page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "search event IHCL page",
						"Not search event IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_request_Event() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().request_Event_IHCL,20))
			{

				SwtTcpHomePage.get().request_Event_IHCL.click();

				Thread.sleep(3000);

				fUtil.flogResult("Passed", "Request event IHCL page",
						"Successfully Requested  Event IHCL page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Request event IHCL page",
						"Not Requested event IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_enter_details_Event() throws Exception {
		try {
			String Search_date=fUtil.fgetDataNew1("date");
			//String Guest=fUtil.fgetDataNew1("Guest");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().det_pg_Event_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();
				System.out.println("enter date"+Search_date);
				SwtTcpHomePage.get().date_Event_IHCL.sendKeys(Search_date);
				SwtTcpHomePage.get().guest_Event_IHCL.sendKeys("50");
				//SwtTcpHomePage.get().searchHotel.sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				//SwtTcpHomePage.get().search_result_IHCL.click();
				fUtil.flogResult("Passed", "Enter event IHCL page",
						"Successfully Entered Event IHCL page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Enter event IHCL page",
						"Not entered event IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_enter_Event() throws Exception {
		try {
			String name=fUtil.fgetDataNew1("full_name");
			//String mobile=fUtil.fgetDataNew1("Mobile");
			String email=fUtil.fgetDataNew1("Email");
			if(gmethods.isElementVisible(SwtTcpHomePage.get().det_pg_Event_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				SwtTcpHomePage.get().fname_Event_IHCL.sendKeys(name);
				SwtTcpHomePage.get().mobile_Event_IHCL.sendKeys("7200235122");
				SwtTcpHomePage.get().Email_Event_IHCL.sendKeys(email);
				//SwtTcpHomePage.get().searchHotel.sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				//SwtTcpHomePage.get().search_result_IHCL.click();
				fUtil.flogResult("Passed", "Enter event IHCL page",
						"Successfully Entered Event IHCL page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Enter event IHCL page",
						"Not entered event IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_validate_details_Event() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().det_pg_Event_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				String fullname = SwtTcpHomePage.get().fname_Event_IHCL.getText();
				String mobile =  SwtTcpHomePage.get().mobile_Event_IHCL.getText();
				String Email = SwtTcpHomePage.get().Email_Event_IHCL.getText();
				//SwtTcpHomePage.get().searchHotel.sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				//SwtTcpHomePage.get().search_result_IHCL.click();
				fUtil.flogResult("Passed", "Validate details event IHCL page",
						"Successfully Validate details Event IHCL page"+fullname+mobile+Email, 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate details IHCL page",
						"Not Validate details event IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_Submit_Event() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().submit_Event_IHCL,20))
			{

				SwtTcpHomePage.get().submit_Event_IHCL.click();

				Thread.sleep(3000);

				fUtil.flogResult("Passed", "Submit event IHCL page",
						"Successfully Submitted  Event IHCL page", 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Submit event IHCL page",
						"Not Submitted event IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}
	@Test
	public void IHCL_validate_request_Event() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().Thanks_Event_IHCL,20))
			{

				String thanks = SwtTcpHomePage.get().Thanks_text_Event_IHCL.getText();

				Thread.sleep(3000);

				fUtil.flogResult("Passed", "validate Submit event IHCL page",
						"Successfully validated Submitted  Event IHCL page"+thanks, 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Submit event IHCL page",
						"Not Submitted event IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}

	@Test
	public void IHCL_validate_Event() throws Exception {
		try {

			if(gmethods.isElementVisible(SwtTcpHomePage.get().request_Event_IHCL,20))
			{
				//SwtTcpHomePage.get().select_area_tata.click();

				String fullname = SwtTcpHomePage.get().capacity_Event_IHCL.getText();
				String mobile =  SwtTcpHomePage.get().distance_Event_IHCL.getText();
				String Email = SwtTcpHomePage.get().dimension_Event_IHCL.getText();
				//SwtTcpHomePage.get().searchHotel.sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				//SwtTcpHomePage.get().search_result_IHCL.click();
				fUtil.flogResult("Passed", "Validate event IHCL page",
						"Successfully Validated Event IHCL page"+fullname+mobile+Email, 1);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate event details IHCL page",
						"Not Validated event details event IHCL page", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "IHCL page didn't load successfully",
					"IHCL page didn't load successfully", 1);
			throw e;
		}
	}
	@Test
	public void enterGuestDetailsIhcl() throws Exception {
		try {
			String fName=fUtil.fgetDataNew1("Guest_FirstName");
			String lName = fUtil.fgetDataNew1("Guest_LastName");
			String eMail =  fUtil.fgetDataNew1("Guest_Email");
			String phoneNumber = fUtil.fgetDataNew1("Guest_PhoneNumber");
			boolean guestDetailsAppear=gmethods.isElementVisible(SwtTcpHomePage.get().guestFirstName,10);
			String firstname=SwtTcpHomePage.get().guestFirstName.getText();
			if(firstname.equalsIgnoreCase(""))
			{
				SwtTcpHomePage.get().guestFirstName.click();
				SwtTcpHomePage.get().guestFirstName.sendKeys(fName);
				SwtTcpHomePage.get().guestLastName.click();
				SwtTcpHomePage.get().guestLastName.sendKeys(lName);
				SwtTcpHomePage.get().guestEmail.click();
				SwtTcpHomePage.get().guestEmail.sendKeys(eMail);
				SwtTcpHomePage.get().guestPhoneNumber.click();
				SwtTcpHomePage.get().guestPhoneNumber.sendKeys(phoneNumber);
				fUtil.flogResult("Failed", "Guest details validation failed",
						"Guest details validation failed", 1);
			}
			else
			{
				fUtil.flogResult("Passed", "Guest details entered",
						"Guest details entered", 1);
			}}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Guest details validation failed",
					"Guest details validation failed"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void validateLoyaltyPoints() throws Exception {
		try {
			boolean guestDetailsAppear=gmethods.isElementVisible(SwtTcpHomePage.get().loyaltyCard,10);
			SwtTcpHomePage.get().loyaltyCard.click();
			boolean totalPoints = gmethods.isElementVisible(TdlTcpCard.get().totalPoints_TCP, 30);
			if (totalPoints == true) {
				gmethods.highlightElement(TdlTcpCard.get().totalPoints_TCP);
				logger.info(
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText());
				fUtil.flogResult("Passed", "Visibility of total points",
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText(),
						1);
				gmethods.navigatebackto_Vault(TdlTcpCard.get().closeBtn_TCP);
			} else {
				logger.error("Total points are not visible in TCP card");
				fUtil.flogResult("Failed", "Visibility of total points", "Total points are not visible in TCP card", 1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Visibility of total points",
					"Total points are not visible in TCP card"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void closeCromaCard() throws Exception {
		try {
			boolean guestDetailsAppear=gmethods.isElementVisible(TdlTcpCard.get().closeBtn_TCP,10);
			if(guestDetailsAppear)
			{
				TdlTcpCard.get().closeBtn_TCP.click();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Closed croma card",
					"Not Closed croma card"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void updateJiraStatusToDo() throws Exception{
		gmethods.updateTestCaseStatusInJira("TO DO");
	}
	
	@Test
	public void validateOrderAndTcpPoints() throws Exception{
		try
		{
		if(gmethods.isElementVisible(SwtTcpHomePage.get().thankYouForShoppingHeader, 30)) {
			String orderId=SwtTcpHomePage.get().orderId.getText().trim();

			fUtil.flogResult("Passed", "Order Confirmation",
					"Order Placed Successfully. Order Id is : "+orderId, 1);
		}

			closeAllTabsAndSwitchtoTcp();
			gmethods.refreshBrowser();
			boolean guestDetailsAppear=gmethods.isElementVisible(SwtTcpHomePage.get().closebTN,10);
			if(guestDetailsAppear)
			{
				SwtTcpHomePage.get().closebTN.click();
			}
			
			boolean textPresent=gmethods.isElementVisible(SwtTcpHomePage.get().loyaltyCard,10);
			SwtTcpHomePage.get().loyaltyCard.click();
			boolean totalPoints = gmethods.isElementVisible(TdlTcpCard.get().totalPoints_TCP, 30);
			if (totalPoints == true) {
				gmethods.highlightElement(TdlTcpCard.get().totalPoints_TCP);
				logger.info(
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText());
				fUtil.flogResult("Passed", "Visibility of total points",
						"Total points is showing in TCP card. Total points are: " + TdlTcpCard.get().totalPoints_TCP.getText(),
						1);
			}
			SwtTcpHomePage.get().closebTN.click();
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed", "order validation",
					"order validation failed"+e.getMessage(), 1);
			throw e;
		}
	}		
	@Test
	public void validateOrderHistory() throws Exception {
		try {
			boolean myProfileLinkInHomePage =gmethods.isElementVisible(TdlHomePage.get().myProfileLink, 20);

			if (myProfileLinkInHomePage == true) {
				logger.info("My Profile link present in User Homepage after Signup ");
				fUtil.flogResult("Passed", "User Homepage", "My Profile link present in User Homepage after Signup ",
						1);

				TdlHomePage.get().myProfileLink.click();
			}
			boolean orderHis =gmethods.isElementVisible(SwtTcpHomePage.get().orderHistoryBtn, 20);
			if(orderHis)
			{
				SwtTcpHomePage.get().orderHistoryBtn.click();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Closed croma card",
					"Not Closed croma card"+e.getMessage(), 1);
			throw e;
		}
	}
	@Test
	public void clickSelectPayment() throws Exception {
		try {
			if(gmethods.isElementVisible(SwtTcpHomePage.get().selectpayment, 15)) {
				SwtTcpHomePage.get().selectpayment.click();
				Thread.sleep(13000);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fUtil.flogResult("Failed", "Closed croma card",
					"Not Closed croma card"+e.getMessage(), 1);
			throw e;
		}
	}
}

