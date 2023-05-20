package com.QA.TestApp.Utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.*;
import javax.imageio.ImageIO;

import org.apache.commons.lang3.time.StopWatch;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.QA.TestApp.Pages.MOBILE.TDL_Signup_Mobile;
import com.QA.TestApp.Testcases.API.ExecuteAPI;
import com.google.common.collect.ImmutableList;
import com.itextpdf.text.log.SysoCounter;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GeneralFunctions extends BaseScript {

	String totalTime;
	// public static WebDriver d = BrowserFactory.webDriver.get();
	public static double startTime=0, endTime=0;
	public static String currentPlatform = "";
	public static String parentWindowHandle="";
	public static StopWatch elementLoadTime = new StopWatch();
	public static int totalTestCaseExecuted=0,totalPassedTestCase=0,totalFailedTestCase=0;
	public static float passPercentage=0;
	public static HashMap<String, String> testCaseNameWithResult = new HashMap<String, String>();

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fEnterDatatoEdtBox .
	 *Description: Enter data into an edit box
	 *Arguments : obj (Edit box Web element), step (step name to be displayed in the execution log), data (string to be entered in the edit box), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean fEnterDatatoEdtBox(WebElement obj, String step, String data, int ScreenShot) throws Exception {

		WaitForObject(obj);
		boolean flag = false;
		try {
				obj.clear();
				if (obj.isEnabled()) {
				obj.sendKeys(data);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
				// d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					if (!obj.getAttribute("value").equals("")) {
						fUtil.flogResult("Passed", step, "Successfully Entered :" + data, ScreenShot);
						flag = true;
					} else {
						fUtil.flogResult("Failed", step, "Failed to Enter", ScreenShot);
					}
				} catch (Exception e) {
					fUtil.flogResult("Failed", step, "Failed to Enter", ScreenShot);
				}
			} else {
				fUtil.flogResult("Failed", step, "Object not present", ScreenShot);
				return false;
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, e.getMessage(), ScreenShot);
		}
		return flag;
	}

	/**
	 * Method to scroll to a particular element in mobile and stay at that screen
	 * 
	 * @param selector
	 * @param resourceIdof_Scrollable_Container
	 * @param className
	 */
	public void scrollToElement_Mobile(String selector, String resourceIdof_Scrollable_Container, String className) {
		try {
			appiumDriver.get()
					.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().getChildByText("
							+ "new UiSelector().className(\"" + className + "\"),\"" + selector + "\")"));
			// appiumDriver.get().findElement(MobileBy.AndroidUIAutomator(
			// "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""
			// + selector + "\"));"));
			appiumDriver.get().runAppInBackground(Duration.ofSeconds(3));
			try {
				((StartsActivity) appiumDriver).currentActivity();
			} catch (Exception e) {

			}

		} catch (Exception e) {

		}

	}

	// Sadia
	/*
	 * This Method is to scroll/Swipe until the MobileElement is visible Right Swipe
	 * will be done at the upper part of the screen Scroll for Mobile Element param:
	 * MobileElement param: "Direction"
	 */
	public boolean scroll(MobileElement element, String direction) throws Exception {
		Dimension dm = appiumDriver.get().manage().window().getSize();
		Boolean flag = false;
		int x;
		int startX;
		int endX;
		int y;
		int startY;
		int endY;
		double pointer;
		TouchAction action = new TouchAction(appiumDriver.get());
		switch (direction) {
		case "Down":
			x = dm.getWidth() / 2;
			// System.out.println(x);
			pointer = 0.9;
			startY = (int) (dm.getHeight() * 0.9);
			// System.out.println(startY);
			endY = startY;
			while (endY > 0) {
				endY = (int) (dm.getHeight() * (pointer - 0.2));
				// System.out.println(endY);
				action.longPress(PointOption.point(x, startY)).moveTo(PointOption.point(x, endY)).release().perform();
				Thread.sleep(2000);
				action.perform();
				if (isElementVisible_mobile(element, 10)) {
					endY = (int) (dm.getHeight() * (pointer - 0.2));
					// System.out.println(endY);
					action.longPress(PointOption.point(x, startY)).moveTo(PointOption.point(x, endY)).release()
							.perform();
					Thread.sleep(2000);
					action.perform();

					endY = (int) (dm.getHeight() * (pointer - 0.2));
					// System.out.println(endY);
					action.longPress(PointOption.point(x, startY)).moveTo(PointOption.point(x, endY)).release()
							.perform();
					Thread.sleep(2000);
					action.perform();

					flag = true;
					break;
				}
				System.out.println("ssssss");
			}
			break;
		case "Up":
			x = dm.getWidth() / 2;
			System.out.println(x);
			pointer = 0.1;
			startY = (int) (dm.getHeight() * 0.1);
			System.out.println(startY);
			endY = startY;
			while (endY < dm.getHeight() * 0.9) {
				endY = (int) (dm.getHeight() * (pointer + 0.2));
				System.out.println(endY);
				action.longPress(PointOption.point(x, startY)).moveTo(PointOption.point(x, endY)).release().perform();
				Thread.sleep(2000);
				action.perform();
				if (isElementClickable(element, 5)) {
					flag = true;
					break;
				}
				System.out.println("ssssss");
				break;
			}
			break;
		case "Right":
			y = dm.getHeight() / 4;
			System.out.println(y);
			pointer = 0.9;
			startX = (int) (dm.getWidth() * 0.9);
			System.out.println(startX);
			endX = startX;
			while (endX > 0) {
				endX = (int) (dm.getWidth() * (pointer - 0.2));
				System.out.println(endX);
				action.longPress(PointOption.point(startX, y)).moveTo(PointOption.point(endX, y)).release().perform();
				Thread.sleep(2000);
				action.perform();
				if (isElementVisible(element, 5)) {
					System.out.println("Required element is visible");
					flag = true;
					break;
				}
				System.out.println("ssssss");
			}
			break;
		case "Left":
			y = dm.getHeight() / 2;
			System.out.println(y);
			pointer = 0.1;
			startX = (int) (dm.getWidth() * 0.1);
			System.out.println(startX);
			endX = startX;
			while (endX < dm.getWidth() * 0.9) {
				endX = (int) (dm.getWidth() * (pointer + 0.2));
				System.out.println(endX);
				action.longPress(PointOption.point(startX, y)).moveTo(PointOption.point(endX, y)).release().perform();
				Thread.sleep(2000);
				action.perform();
				if (isElementClickable(element, 5)) {
					flag = true;
					break;
				}
				System.out.println("ssssss");
				break;
			}
		}
		return flag;
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fEnterDatatoEdtBox_mobile .
	 *Description: Enter data into an edit box
	 *Arguments : obj (Edit box Mobile element), step (step name to be displayed in the execution log), data (string to be entered in the edit box), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean fEnterDatatoEdtBox_mobile(MobileElement obj, String step, String data, int ScreenShot)
			throws Exception {

		boolean flag = false;
		try {
			if (obj.isEnabled()) {
				obj.clear();
				obj.sendKeys(data);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
				// d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					if (!obj.getAttribute("value").equals("")) {
						fUtil.flogResult("Passed", step, "Successfully Entered :" + data, ScreenShot);
						flag = true;
					} else {
						fUtil.flogResult("Failed", step, "Failed to Enter", ScreenShot);
					}
				} catch (Exception e) {
					fUtil.flogResult("Failed", step, "Failed to Enter", ScreenShot);
				}
			} else {
				fUtil.flogResult("Failed", step, "Object not present", ScreenShot);
				return false;
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, e.getMessage(), ScreenShot);
		}
		return flag;
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fClickOnButton
	 *Description: Clicking a button
	 *Arguments : obj (Button Web element), step (step name to be displayed in the execution log), data (Button Name), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean fClickOnButton(WebElement obj, String step, String btnName, int ScreenShot) throws Exception {

		boolean flag = false;
		WaitForObject(obj);
		try {
			if (obj.isEnabled()) {

				JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.webDriver.get();
				executor.executeScript("arguments[0].click();", obj);
				BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				fUtil.flogResult("Passed", step, "Successfully Clicked :" + btnName, ScreenShot);
				flag = true;
			} else {
				fUtil.flogResult("Failed", step, "Object not present", ScreenShot);
				return false;
			}
		} catch (JavascriptException ee) {
			fUtil.flogResult("Passed", step, "Successfully Clicked :" + btnName, ScreenShot);
		} catch (ScriptTimeoutException eee) {
			fUtil.flogResult("Passed", step, "Successfully Clicked :" + btnName, ScreenShot);
		} catch (Exception e) {
			// if(e.)
			fUtil.flogResult("Failed", step, "Object not present/Exception :" + e, ScreenShot);
		}
		return flag;
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fClickOnButton
	 *Description: Clicking a button
	 *Arguments : obj (Button Web element), step (step name to be displayed in the execution log), data (Button Name), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public String fGetValueRiskDetail(String ID, String step, String fieldName, int ScreenShot) throws Exception {

		String flag = null;
		// WaitForObject(obj);
		try {
			// if(obj.isDisplayed())
			// {

			// highlightElement(obj);
			// Actions actions = new Actions(BrowserFactory.webDriver.get());
			// actions.moveToElement(obj).build().perform();
			// BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(10,
			// TimeUnit.SECONDS);
			JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.webDriver.get();
			String IdVal = ID;
			String Script = "return document.getElementById('" + ID + "').value";
			flag = executor.executeScript(Script).toString();
			BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			fUtil.flogResult("Passed", step, "Successfully Clicked :" + fieldName, ScreenShot);
			return flag;
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, "Object not present/Exception :" + e, ScreenShot);
		}
		return flag;
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fSelectCheckBox .
	 *Description: To select a Check box
	 *Arguments : obj (Check box Web element), step (step name to be displayed in the execution log), data (Check box name), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean fSelectCheckBox(WebElement obj, String step, String data, int ScreenShot) throws Exception {

		boolean flag = false;
		try {
			WebDriver d = BrowserFactory.webDriver.get();

			WaitForObject(obj);
			if (!obj.isSelected()) {

				highlightElement(obj);
				JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.webDriver.get();
				executor.executeScript("arguments[0].click();", obj);
				d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				fUtil.flogResult("Passed", step, "Successfully Checked :" + data, ScreenShot);
				// obj.click();
			} else {
				fUtil.flogResult("Failed", step, "Object not present", ScreenShot);
				return false;
			}
			return flag;
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, e.getMessage(), ScreenShot);
			return flag;
		}
	}

	/**
	 * --------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: TypeInDateField Description: To enter data in a date format
	 * Arguments : obj (Edit box Web element), step (step name to be displayed in
	 * the execution log), data (Edit box name), Screenshot (yes/no) Author :Tcs
	 * --------------------------------------------------------------------------------------------------------------------------------------
	 */

	public void TypeInDateField(WebElement obj, String step, String data, int ScreenShot) throws Exception {
		try {
			String val = data;
			if (obj.isDisplayed()) {

				obj.clear();
				obj.click();
				for (int i = 0; i < val.length(); i++) {
					char c = val.charAt(i);
					String s = new StringBuilder().append(c).toString();
					if (!s.equals("/")) {
						obj.sendKeys(s);
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				fUtil.flogResult("Passed", step, "Successfully Entered :" + data, ScreenShot);
			} else {
				fUtil.flogResult("Failed", step, "Object not present", ScreenShot);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, e.getMessage(), ScreenShot);
		}

	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fUploadFile
	 *Description: To upload a file
	 *Arguments : obj (Edit box Web element), step (step name to be displayed in the execution log), data (Path to be uploaded), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean fUploadFile(WebElement obj, String step, String filePath, int ScreenShot) throws Exception {
		boolean flag = false;
		try {
			WaitForObject(obj);
			if (obj.isDisplayed()) {

				highlightElement(obj);
				obj.sendKeys(filePath);
				fUtil.flogResult("Passed", step, "Successfully Entered Path :" + filePath, ScreenShot);
				// obj.click();
			} else {
				fUtil.flogResult("Failed", step, "Object not present", ScreenShot);
				return false;
			}
			return flag;
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, e.getMessage(), ScreenShot);
			return flag;
		}

	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fSelectDataFromDropDown
	 *Description: To select a drop down value
	 *Arguments : obj (Drop down Web element), step (step name to be displayed in the execution log), data (Value to be selected in drop down), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean fSelectDataFromDropDown(WebElement obj, String step, String data, int ScreenShot) throws Exception {
		boolean flag = false;
		WaitForObject(obj);
		try {
			if (obj.isDisplayed()) {
				// highlightElement(obj);
				obj.click();
				Select select = new Select(obj);
				select.selectByValue(data);

				// select.selectByVisibleText(data);
				fUtil.flogResult("Passed", step, "Successfully Selected :" + data, ScreenShot);
			} else {
				fUtil.flogResult("Failed", step, "Object not present", ScreenShot);
				return false;
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, e.toString(), ScreenShot);
		}
		return flag;
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fSelectDataFromDropDowntext
	 *Description: To select a drop down value
	 *Arguments : obj (Drop down Web element), step (step name to be displayed in the execution log), data (Value to be selected in drop down), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean fSelectDataFromDropDownText(WebElement obj, String step, String data, int ScreenShot)
			throws Exception {
		boolean flag = false;
		WaitForObject(obj);
		try {
			// if(obj.isDisplayed())
			{
				// highlightElement(obj);
				// obj.click();
				Select select = new Select(obj);
				// select.selectByValue(data);
				select.selectByVisibleText(data);
				fUtil.flogResult("Passed", step, "Successfully Selected :" + data, ScreenShot);
			}
			// else
			/*
			 * { fUtil.flogResult("Failed",step,"Object not present",ScreenShot); return
			 * false; }
			 */
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, e.toString(), ScreenShot);
		}
		return flag;
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fGetSelectedDataFromDropDown
	 *Description: To get the selected value from a drop down value
	 *Arguments : obj (Drop down Web element), step (step name to be displayed in the execution log), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public String fGetSelectedDataFromDropDown(WebElement obj, String step, int ScreenShot) throws Exception {
		String strCurrentValue = null;
		WaitForObject(obj);
		try {
			// if(gmethodes.isElementVisible(obj, 30))
			{
				// highlightElement(obj);
				// obj.click();
				Select select = new Select(obj);

				// select.selectByVisibleText(data);
				strCurrentValue = select.getFirstSelectedOption().getText();
				fUtil.flogResult("Passed", step, "Successfully Selected :", ScreenShot);

				// return strCurrentValue;
				// }
				// else
				/*
				 * { fUtil.flogResult("Failed",step,"Object not present",ScreenShot); }
				 */
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, e.toString(), ScreenShot);
		}
		return strCurrentValue;
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fSelectDataFromDropDownIndex
	 *Description: To select a drop down value
	 *Arguments : obj (Drop down Web element), step (step name to be displayed in the execution log), data (Value to be selected in drop down), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean fSelectDataFromDropDownIndex(WebElement obj, String step, String data, int ScreenShot)
			throws Exception {
		boolean flag = false;
		WaitForObject(obj);
		try {
			if (gmethods.isElementVisible(obj, 30)) {
				// highlightElement(obj);
				int k = 0;
				int i = 0;
				// obj.click();
				Select select = new Select(obj);
				List<WebElement> dropDwonElements = select.getOptions();
				String[] dropDownText = new String[dropDwonElements.size()];
				for (WebElement e : dropDwonElements) {
					dropDownText[i] = e.getText().trim();
					i++;
				}
				for (String f : dropDownText) {
					if (f.equalsIgnoreCase(data)) {
						select.selectByIndex(k);
						break;
					}
					k++;
				}
				// select.selectByValue(data);
				// select.selectByVisibleText(data);
				fUtil.flogResult("Passed", step, "Successfully Selected :" + data, ScreenShot);
			} else {
				fUtil.flogResult("Failed", step, "Object not present", ScreenShot);
				return false;
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", step, e.toString(), ScreenShot);
		}
		return flag;
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: highlightElement
	 *Description: To highlight a web element
	 *Arguments : element(Web element)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/

	public void highlightElement(WebElement element) {
		WebDriver d = BrowserFactory.webDriver.get();
		try {

			WaitForObject(element);
			JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.webDriver.get();
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: black; border: 4px solid red;");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// js.executeScript("arguments[0].setAttribute('style','border: solid 2px
			// white')",element);
		} catch (Exception e) {

		}

	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: WaitForObject
	 *Description: To wait for object dynamically
	 *Arguments : How (type of locator), value (locator_string)
	 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/
	public void WaitForObject(WebElement ee) {

	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: setObject
	 *Description: To set object dynamically
	 *Arguments : How (type of locator), value (locator_string)
	 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/

	public WebElement waitForObject(String How, String value) throws Exception {
		WebElement myDynamicElement = null;
		try {

			switch (How) {
			case "id":
				// myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(),
				// 100)).until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
				myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				break;
			case "xpath":
				// myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(),
				// 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
				myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				break;
			case "name":
				// myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(),
				// 100)).until(ExpectedConditions.presenceOfElementLocated(By.name(value)));
				myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				break;
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Object with " + How + "=" + value + "Creation Failed", e.toString(), 1);
			return myDynamicElement;
		}

		return myDynamicElement;

	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: verifyObjectExistance
	 *Description: To verify if an object exists or not
	 *Arguments : How (type of locator), value (locator_string)
	 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean verifyObjectExistance(String How, String value) throws Exception {
		WebElement myDynamicElement = null;
		try {
			switch (How) {
			case "id":
				myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				break;
			case "xpath":
				myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				break;
			case "name":
				myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				break;
			case "css":
				myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				break;
			}
			return myDynamicElement.isDisplayed();
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Object with : " + How + "=" + value + " : Creation Failed", e.toString(), 1);
			return false;
		}

	}

	public String GetTextFromObject(WebElement ee, String attribute) throws Exception {
		try {
			return ee.getAttribute(attribute);
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Get the value from Element",
					"Failed to get the value due to exception:" + e.toString(), 1);
			return "null";
		}
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: WaitUnitlObjectDisappear
	 *Description: To set wait until object disappear
	 *Arguments : How (type of locator), value (locator string)
	 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean WaitUnitlObjectDisappear(String How, String value) {
		boolean Status = false;
		try {

			switch (How) {
			case "id":
				Status = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.invisibilityOfElementLocated(By.id(value)));
				break;
			case "xpath":
				Status = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(value)));
				break;
			case "name":
				Status = (new WebDriverWait(BrowserFactory.webDriver.get(), 50))
						.until(ExpectedConditions.invisibilityOfElementLocated(By.name(value)));
				break;
			}
			return Status;
		} catch (NoSuchElementException e) {
			return true;
		} catch (StaleElementReferenceException e) {
			return true;
		}

	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: isElementClickable
	 *Description: To check a web element is clickable
	 *Arguments : element(Web element), time (wait duration)
	 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean isElementClickable(WebElement element, int time) {
		try {
			if (isElementPresent(element) == false || element.isEnabled() == false) {
				WebDriverWait wt = new WebDriverWait(BrowserFactory.webDriver.get(), time);
				wt.until(ExpectedConditions.elementToBeClickable(element));

				return element.isEnabled();
			} else {
				return true;
			}
		}

		catch (Exception e) {
			// fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
			return false;

		}

	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: isElementClickable_mobile
	 *Description: To check a mobile element is clickable
	 *Arguments : element(Mobile element), time (wait duration)
	 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean isElementClickable(MobileElement element, int time) {
		try {
			if (isElementPresent(element) == false || element.isEnabled() == false) {
				WebDriverWait wt = new WebDriverWait(BrowserFactory.webDriver.get(), time);
				wt.until(ExpectedConditions.elementToBeClickable(element));

				return element.isEnabled();
			} else {
				return true;
			}
		}

		catch (Exception e) {
			// fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
			return false;

		}

	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: isElementVisible
	 *Description: to check if a web element is visible
	 *Arguments : element (Web element), time (wait duration)
	 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean isElementVisible(WebElement element, int time) {
		boolean flag;
		try {
//			totalTime = 0;
//			elementLoadTime.start();
			if (isElementPresent(element) == false) {
				WebDriverWait wt = new WebDriverWait(BrowserFactory.webDriver.get(), time);
				wt.until(ExpectedConditions.visibilityOf(element));
				flag = element.isDisplayed();
//				elementLoadTime.stop();
//				totalTime = elementLoadTime.getTime(TimeUnit.SECONDS);
				// return flag;
			} else {
				flag = true;
			}
			return flag;

		} catch (Exception e) {
			//logger.fatal("Element not visible after conditional wait");
			return false;
		}
	}

	public boolean isElementPresent(String xpath, int time) {
		boolean flag;
		try {
			WebDriverWait wt = new WebDriverWait(BrowserFactory.webDriver.get(), time);
			wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			flag = BrowserFactory.webDriver.get().findElement(By.xpath(xpath)).isDisplayed();

			return flag;

		} catch (Exception e) {
			//logger.fatal("Element not visible after conditional wait");
			return false;
		}
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: isElementVisible_mobile
	 *Description: to check if a web element is visible in mobile UI
	 *Arguments : element (Web element), time (wait duration)
	 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/
	public boolean isElementVisible_mobile(MobileElement element, int time) {
		try {
		//	StopWatch elementLoadTime = new StopWatch();
		//	elementLoadTime.start();
			if (isElementPresent(element) == false) {
				WebDriverWait wt = new WebDriverWait(appiumDriver.get(), time);
				wt.until(ExpectedConditions.visibilityOf(element));

				boolean flag = element.isDisplayed();

			//	elementLoadTime.stop();
				//totalTime = elementLoadTime.getTime(TimeUnit.SECONDS);
				return flag;
			} else {
				return true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			//logger.fatal("Expected elemnt not visible");
			return false;
		}

	}

	public boolean isElementDisappeared(By by, int time) {

		if (isElementPresent(BrowserFactory.webDriver.get().findElement(by))) {
			WebDriverWait wt = new WebDriverWait(BrowserFactory.webDriver.get(), time);
			wt.until(ExpectedConditions.invisibilityOfElementLocated(by));

			if (BrowserFactory.webDriver.get().findElement(by).isDisplayed())
				return false;
			else
				return true;
		}

		else {
			return true;
		}

	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: isElementPresent
	 *Description: to check if a web element is present
	 *Arguments : element (Web element)
	 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean isElementPresent(WebElement element) {

		try {
			if (element.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		}

		catch (Exception e) {
			// fUtil.flogResult("Failed","Object Not Present",e.toString(),"Yes");
			return false;

		}

	}

	public boolean isElementPresent(String xpath) {

		try {
			BrowserFactory.getInstance().getDriver().findElement(By.xpath(xpath));
			return true;

		}

		catch (Exception e) {

			return false;

		}

	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: isElementPresent
	 *Description: to check if a web element is present
	 *Arguments : element (Web element)
	 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/

	public boolean isElementPresent_mobile(MobileElement element) {

		try {
			if (element.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		}

		catch (Exception e) {
			//logger.fatal("Expected element not displayed with out conditional wait");
			return false;

		}

	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: dynamicXpath
	 *Description: to create dynamic xpath
	 *Arguments : element (String), argument (String)
	 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/

	public String dynamicXpath(String element, String argument) {
		// String str = element.toString();
		String[] a = element.split("xxxx");
		return a[0] + argument + a[1];
	}

	public String dynamicXpath(String element, String argument1, String argument2) {
		// String str = element.toString();
		String[] a = element.split("xxxx");
		return a[0] + argument1 + a[1] + argument2 + a[2];
	}

	public boolean loaderTimeOut() {
		// String str = element.toString();
		boolean loaderimage = gmethods.isElementDisappeared(By.xpath("//div[@id='loaderImage']"), 180);
		return loaderimage;
	}

	public boolean loaderTimeOut_uploadDoc() throws Exception {
		try {
			// String str = element.toString();
			boolean loaderimage = gmethods.isElementDisappeared(By.xpath("//div[@class='lds-eclipse']/div"), 180);
			return loaderimage;
		} catch (Exception e) {
			Thread.sleep(20000);
			return false;
		}
	}

	public boolean isElementPresentAndEnable(String xpath) {
		String btnStatus;

		try {
			btnStatus = BrowserFactory.webDriver.get().findElement(By.xpath(xpath)).getAttribute("class");
			System.out.println("Btn available");
		} catch (Exception e) {
			System.out.println("Btn not available");
			return false;
		}
		// WebElement wb= BrowserFactory.webDriver.get().findElement(By.xpath(xpath));
		// try
		// {
		if (btnStatus.equalsIgnoreCase("disableButton")) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isElementPresentAndEnableWE(WebElement element) {
		String btnStatus;

		try {
			btnStatus = element.getAttribute("class");

			System.out.println("Btn available");
		} catch (Exception e) {
			System.out.println("Btn not available");
			return false;
		}
		// WebElement wb= BrowserFactory.webDriver.get().findElement(By.xpath(xpath));
		// try
		// {
		if (btnStatus.equalsIgnoreCase("disableButton")) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isElementVisibleXpath(String xpath, int time) {

		try {
			Thread.sleep(2000);
			WebDriverWait wt = new WebDriverWait(BrowserFactory.webDriver.get(), time);
			wt.until(ExpectedConditions.visibilityOf(BrowserFactory.webDriver.get().findElement(By.xpath(xpath))));
		}

		catch (Exception e) {
			return false;
		}

		return true;
	}

	public void pageLoadStatusCheckDisplayed(WebElement element, String PageName, String formattedDateInput)
			throws Exception {
		ArrayList<Long> timeValues = new ArrayList<Long>();
		try {
			// int i=0;
			boolean found = false;
			for (int i = 0; i < 900; i++) {
				if (element.isDisplayed() == false) {

					// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
					// wt.until(ExpectedConditions.elementToBeClickable(element));
					Thread.sleep(1000);
					i++;

					// return element.isEnabled();
				} else {
					// return true;
					found = true;
					Calendar cal = Calendar.getInstance();
					Date date = cal.getTime();
					System.out.println(date);
					DateFormat df = new SimpleDateFormat("HH:mm:ss");
					String formattedDate = df.format(date);
					// String f2="14:15:45";
					System.out.println(formattedDate);

					Date time2 = df.parse(formattedDate);
					Date time1 = df.parse(formattedDateInput);
					long timeTest = time2.getTime() - time1.getTime();
					System.out.println(timeTest);
					long timeInSec = timeTest / 1000 % 60;
					long timeInMin = timeTest / (60 * 1000) % 60;
					// timeValues.add(timeInMin);
					// timeValues.add(timeInSec);
					System.out.println(timeInMin);
					fUtil.flogResult("Passed", "Check the Page load time of " + PageName,
							"Page Load time(MM:SS) - " + timeInMin + ":" + timeInSec, 0);
					break;

				}
			}
			if (found == false) {
				fUtil.flogResult("Failed", "Check the Page load of " + PageName, "Page not loaded within 15 minutes",
						1);
			}
			// return timeValues;
		}

		catch (Exception e) {
			// fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
			// return false;
			fUtil.flogResult("Failed", "Check the Page load of " + PageName,
					"Page not loaded due to exception" + e.getMessage(), 1);
		}

	}

	public void windowLoadTimeTrack(Set<String> windowArray, String windowName, String formattedDateInput,
			long timeDiffTest) throws Exception {
		ArrayList<Long> timeValues = new ArrayList<Long>();
		try {
			// int i=0;
			boolean found = false;
			for (int i = 0; i < 900; i++) {
				if (windowArray.size() == 1) {

					// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
					// wt.until(ExpectedConditions.elementToBeClickable(element));
					Thread.sleep(1000);
					i++;

					// return element.isEnabled();
				} else {
					found = true;
					// return true;
					Calendar cal = Calendar.getInstance();
					Date date = cal.getTime();
					System.out.println(date);
					DateFormat df = new SimpleDateFormat("HH:mm:ss");
					String formattedDate = df.format(date);
					// String f2="14:15:45";
					System.out.println(formattedDate);
					System.out.println("In side Window load");

					Date time1 = df.parse(formattedDate);
					Date time2 = df.parse(formattedDateInput);
					long timeTest = time1.getTime() - time2.getTime();
					long timeDiff = timeTest - timeDiffTest;
					System.out.println(timeDiff);
					long timeInSec = timeDiff / 1000 % 60;
					long timeInMin = timeDiff / (60 * 1000) % 60;
					// timeValues.add(timeInMin);
					// timeValues.add(timeInSec);
					System.out.println(timeInMin);
					fUtil.flogResult("Passed", "Check the Window load time of " + windowName,
							"Window Load time(MM:SS) - " + timeInMin + ":" + timeInSec, 0);
					break;

				}
			}
			if (found == false) {

				fUtil.flogResult("Failed", "Check the Window load of " + windowName,
						"Window not loaded within 15 minutes", 1);
			}
			// return timeValues;
		}

		catch (Exception e) {
			// fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
			// return false;
			fUtil.flogResult("Failed", "Check the Page load of " + windowName,
					"Page not loaded due to exception" + e.getMessage(), 1);
		}

	}

	// Robot
	// ___________________________
	public void rbSendKeys(Robot robot, String keys) {
		for (char c : keys.toCharArray()) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
				throw new RuntimeException("Key code not found for character '" + c + "'");
			}
			robot.keyPress(keyCode);
			robot.delay(100);
			robot.keyRelease(keyCode);
			robot.delay(100);
		}
	}

	/*
	 * put the below lines in module class and pass formattedDate in to the function
	 * Calendar cal=Calendar.getInstance(); Date date=cal.getTime();
	 * System.out.println(date); DateFormat df= new SimpleDateFormat("HH:mm:ss");
	 * String formattedDateInput= df.format(date);
	 * 
	 * 
	 */

	public String getSystemTime() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		System.out.println(date);
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String formattedDateInput = df.format(date);
		return formattedDateInput;
	}

	public long pageLoadStatusCheckEnabled(WebElement element, String PageName, String formattedDateInput,
			long timeDiffTest) throws Exception {
		ArrayList<Long> timeValues = new ArrayList<Long>();
		long timeDiff = 0;
		try {
			// int i=0;
			for (int i = 0; i < 900; i++) {
				if (element.isEnabled() == false) {

					// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
					// wt.until(ExpectedConditions.elementToBeClickable(element));
					Thread.sleep(1000);
					i++;

					// return element.isEnabled();
				} else {
					// return true;
					Calendar cal = Calendar.getInstance();
					Date date = cal.getTime();
					System.out.println(date);
					DateFormat df = new SimpleDateFormat("HH:mm:ss");
					String formattedDate = df.format(date);
					// String f2="14:15:45";
					System.out.println(formattedDate);
					System.out.println("In side page load");

					Date time1 = df.parse(formattedDate);
					Date time2 = df.parse(formattedDateInput);
					long timeTest = time1.getTime() - time2.getTime();
					timeDiff = timeTest - timeDiffTest;
					System.out.println(timeDiff);
					long timeInSec = timeDiff / 1000 % 60;
					long timeInMin = timeDiff / (60 * 1000) % 60;
					// timeValues.add(timeInMin);
					// timeValues.add(timeInSec);
					System.out.println(timeInMin);
					fUtil.flogResult("Passed", "Check the Page load time of " + PageName,
							"Page Load time(MM:SS) - " + timeInMin + ":" + timeInSec, 0);
					break;

				}
			}
			// return timeValues;
			return timeDiff;
		}

		catch (Exception e) {
			// fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
			// return false;

			fUtil.flogResult("Failed", "Check the Page load of " + PageName,
					"Page not loaded due to exception" + e.getMessage(), 1);
			return timeDiff;
		}

	}

	public void pageLoadStatusCheckEnabled1(WebElement element, String PageName, String formattedDateInput,
			long timeDiffTest) throws Exception {
		ArrayList<Long> timeValues = new ArrayList<Long>();
		// long timeDiff=0;
		try {
			// int i=0;
			for (int i = 0; i < 900; i++) {
				if (element.isEnabled() == false) {

					// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
					// wt.until(ExpectedConditions.elementToBeClickable(element));
					Thread.sleep(1000);
					i++;

					// return element.isEnabled();
				} else {
					// return true;
					Calendar cal = Calendar.getInstance();
					Date date = cal.getTime();
					System.out.println(date);
					DateFormat df = new SimpleDateFormat("HH:mm:ss");
					String formattedDate = df.format(date);
					// String f2="14:15:45";
					System.out.println(formattedDate);
					System.out.println("In side page load");

					Date time1 = df.parse(formattedDate);
					Date time2 = df.parse(formattedDateInput);
					long timeTest = time1.getTime() - time2.getTime();
					long timeDiff = timeTest - timeDiffTest;
					System.out.println(timeDiff);
					long timeInSec = timeDiff / 1000 % 60;
					long timeInMin = timeDiff / (60 * 1000) % 60;
					// timeValues.add(timeInMin);
					// timeValues.add(timeInSec);
					System.out.println(timeInMin);
					fUtil.flogResult("Passed", "Check the Page load time of " + PageName,
							"Page Load time(MM:SS) - " + timeInMin + ":" + timeInSec, 0);
					break;

				}
			}
			// return timeValues;
			// return timeDiff;
		}

		catch (Exception e) {
			// fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
			// return false;

			fUtil.flogResult("Failed", "Check the Page load of " + PageName,
					"Page not loaded due to exception" + e.getMessage(), 1);
			// return timeDiff;
		}

	}

	public void pageLoadStatusCheckDisplayed(WebElement element, String PageName, String formattedDateInput,
			long timeDiffTest) throws Exception {
		// ArrayList<Long> timeValues = new ArrayList<Long>();
		try {
			// int i=0;
			for (int i = 0; i < 900; i++) {
				if (element.isDisplayed() == false) {

					// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
					// wt.until(ExpectedConditions.elementToBeClickable(element));
					Thread.sleep(1000);
					i++;

					// return element.isEnabled();
				} else {
					// return true;
					Calendar cal = Calendar.getInstance();
					Date date = cal.getTime();
					System.out.println(date);
					DateFormat df = new SimpleDateFormat("HH:mm:ss");
					String formattedDate = df.format(date);
					// String f2="14:15:45";
					System.out.println(formattedDate);
					System.out.println("In side page load");

					Date time1 = df.parse(formattedDate);
					Date time2 = df.parse(formattedDateInput);
					long timeTest = time1.getTime() - time2.getTime();
					long timeDiff = timeTest - timeDiffTest;
					System.out.println(timeDiff);
					long timeInSec = timeDiff / 1000 % 60;
					long timeInMin = timeDiff / (60 * 1000) % 60;
					// timeValues.add(timeInMin);
					// timeValues.add(timeInSec);
					System.out.println(timeInMin);
					fUtil.flogResult("Passed", "Check the Page load time of " + PageName,
							"Page Load time(MM:SS) - " + timeInMin + ":" + timeInSec, 0);
					break;

				}
			}
			// return timeValues;
		}

		catch (Exception e) {
			// fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
			// return false;
			fUtil.flogResult("Failed", "Check the Page load of " + PageName,
					"Page not loaded due to exception" + e.getMessage(), 1);
		}

	}

	public void pageLoadStatusCheckValueCheck(WebElement element, String PageName, String formattedDateInput,
			long timeDiffTest) throws Exception {
		ArrayList<Long> timeValues = new ArrayList<Long>();
		try {
			// int i=0;
			boolean found = false;
			for (int i = 0; i < 900; i++) {
				if (element.isDisplayed() == false) {

					// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
					// wt.until(ExpectedConditions.elementToBeClickable(element));
					Thread.sleep(1000);
					i++;

					// return element.isEnabled();
				} else {
					// return true;
					if (element.getAttribute("value").isEmpty()) {
						Thread.sleep(1000);
						i++;
					} else {
						found = true;
						Calendar cal = Calendar.getInstance();
						Date date = cal.getTime();
						System.out.println(date);
						DateFormat df = new SimpleDateFormat("HH:mm:ss");
						String formattedDate = df.format(date);
						// String f2="14:15:45";
						System.out.println(formattedDate);
						System.out.println("In side page load");

						Date time1 = df.parse(formattedDate);
						Date time2 = df.parse(formattedDateInput);
						long timeTest = time1.getTime() - time2.getTime();
						long timeDiff = timeTest - timeDiffTest;
						System.out.println(timeDiff);
						long timeInSec = timeDiff / 1000 % 60;
						long timeInMin = timeDiff / (60 * 1000) % 60;
						// timeValues.add(timeInMin);
						// timeValues.add(timeInSec);
						System.out.println(timeInMin);
						fUtil.flogResult("Passed", "Check the Page load time of " + PageName,
								"Page Load time(MM:SS) - " + timeInMin + ":" + timeInSec, 0);
						break;
					}
				}
			}
			if (found == false) {
				fUtil.flogResult("Failed", "Check the Page load of " + PageName, "Page not loaded within 15 minutes",
						1);
			}
			// return timeValues;
		}

		catch (Exception e) {
			// fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
			// return false;
			fUtil.flogResult("Failed", "Check the Page load of " + PageName,
					"Page not loaded due to exception" + e.getMessage(), 1);
		}

	}

	public boolean isImagePresent(String image) {
		boolean status = false;
		Screen scr = new Screen();
		try {
			scr.find(image);
			status = true;
		} catch (FindFailed ee) {
			ee.getMessage();
		}
		return status;
	}

	public void waitForImage(String image, int time) throws InterruptedException {
		for (int i = 0; i < time; i++) {
			if (isImagePresent(image)) {
				break;
			} else {
				Thread.sleep(1000);
			}
		}
	}

	public boolean isElementEnabled(WebElement elementToCheck) {

		if (elementToCheck.isEnabled())
			return true;
		else
			return false;
	}

	public boolean fScrollInto(WebElement obj, String step, String btnName, int ScreenShot) throws Exception {

		boolean flag = false;
		WaitForObject(obj);
		try {
			JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.webDriver.get();
			executor.executeScript("arguments[0].click();", obj);
			BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			fUtil.flogResult("Passed", step, "Successfully Clicked :" + btnName, ScreenShot);
			flag = true;

		} catch (Exception e) {
			fUtil.flogResult("Failed", step, "Object not present/Exception :" + e, ScreenShot);
		}
		return flag;
	}

	// ------------------method
	public String current_timestamp() {
		String stimestamp = "";

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		stimestamp = timestamp.toString().substring(0, timestamp.toString().length() - 4);

		return stimestamp;

	}

	public String randomnumber() {
		String random5Digts = UUID.randomUUID().toString().substring(0, 5);
		String randomNumber = "ORDERSSRSS" + random5Digts;
		StringBuilder sb = new StringBuilder(randomNumber);

		for (int index = 0; index < sb.length(); index++) {
			char c = sb.charAt(index);
			if (Character.isLowerCase(c)) {
				sb.setCharAt(index, Character.toUpperCase(c));
			}
		}

		System.out.println("Random number is " + sb.toString());
		String number = sb.toString();
		System.out.println(number);

		return number;
	}

	public String randommerchantname() {
		String random2Digts = UUID.randomUUID().toString().substring(0, 2);
		String randomNumber = "Croma" + random2Digts;
		StringBuilder sb = new StringBuilder(randomNumber);

		for (int index = 0; index < sb.length(); index++) {
			char c = sb.charAt(index);
			if (Character.isLowerCase(c)) {
				sb.setCharAt(index, Character.toUpperCase(c));
			}
		}

		System.out.println("Random number is " + sb.toString());
		String number = sb.toString();
		System.out.println(number);

		return number;
	}

	public String randomemail() {
		String random5Digts = UUID.randomUUID().toString().substring(0, 5);
		String randomNumber = random5Digts + "@gmail.com";
		StringBuilder sb = new StringBuilder(randomNumber);

		for (int index = 0; index < sb.length(); index++) {
			char c = sb.charAt(index);
			if (Character.isLowerCase(c)) {
				sb.setCharAt(index, Character.toUpperCase(c));
			}
		}

		System.out.println("Random number is " + sb.toString());
		String number = sb.toString();
		System.out.println(number);

		return number;
	}

	public String randomphonenumber() {

		int leftLimit = 0; // numeral '0'
		int rightLimit = 0;
		int targetStringLength = 0;
		Random random = new Random();
		String generatedString = "";

		leftLimit = 48; // numeral '0'
		rightLimit = 57;
		targetStringLength = 9;
		// String generatedString ="";
		generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		String randomNumber = "9" + generatedString;
		return randomNumber;

	}

	public String randomString(int stringLength, String stringPattern, String PrefixString) {

		/*
		 * Owner: Pratik Chavan Use: This Method Will generate a random
		 * AlphaNumeric,Numeric,Alpha,AlphaNumericWithPrefix,NumericWithPrefix,
		 * AlphaWithPrefix string Arguments (int stringLength = length of the string ,
		 * String stringPattern
		 * (AlphaNumeric,Numeric,Alpha,AlphaNumericWithPrefix,NumericWithPrefix,
		 * AlphaWithPrefix) ,String PrefixString = Prefix before string)
		 *
		 */

		int leftLimit = 0; // numeral '0'
		int rightLimit = 0;
		int targetStringLength = 0;
		Random random = new Random();
		String generatedString = "";

		switch (stringPattern) {

		case "Numeric":

			leftLimit = 48; // numeral '0'
			rightLimit = 57;
			targetStringLength = stringLength;
			// String generatedString ="";
			generatedString = random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

			break;
		case "AlphaNumeric":

			leftLimit = 48; // numeral '0'
			rightLimit = 90;
			targetStringLength = stringLength;

			// String generatedString ="";
			generatedString = random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

			break;
		case "Alpha":

			leftLimit = 65; // numeral '0'
			rightLimit = 90;
			targetStringLength = stringLength;

			// String generatedString ="";
			generatedString = random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

			break;
		case "NumericWithPrefix":

			leftLimit = 48; // numeral '0'
			rightLimit = 57;
			targetStringLength = stringLength;
			// String generatedString ="";
			generatedString = PrefixString + random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

			break;
		case "AlphaNumericWithPrefix":

			leftLimit = 48; // numeral '0'
			rightLimit = 90;
			targetStringLength = stringLength;

			// String generatedString ="";
			generatedString = PrefixString + random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

			break;
		case "AlphaWithPrefix":

			leftLimit = 65; // numeral '0'
			rightLimit = 90;
			targetStringLength = stringLength;

			// String generatedString ="";
			generatedString = PrefixString + random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

			break;

		default:
			System.err.println("Invalid Pattern Input");
		}

		return generatedString;

	}

	public String randomMobileNumber(int stringLength, String stringPattern, String PrefixString) {
		int leftLimit = 0; // numeral '0'
		int rightLimit = 0;
		int targetStringLength = 0;
		Random random = new Random();
		String generatedString = "";
		switch (stringPattern) {

		case "Numeric":

			leftLimit = 48; // numeral '0'
			rightLimit = 57;
			targetStringLength = stringLength;
			// String generatedString ="";
			generatedString = random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

			break;

		default:
			System.err.println("Invalid Pattern Input");
		}
		String randomNumber = "9" + generatedString;
		return randomNumber;

	}

	/*
	 * Function name : enrollUserPwa This function will enroll a new user in TDL PWA
	 * Input required : Unregistered Mobile number, OTP, First Name, Last name, Date
	 * of birth, Email
	 */
	public void enrollUserPwa(String mobileNumber, String otp, String newPassword, String salutation, String firstName,
			String lastName, String dob, String gender, String email) throws Exception {
		try {
			validateAndClickSignInButtonPwa();
			validateMobileNumberBoxAndEnterMobileNoPwa(mobileNumber);
			validateOtpPageAndEnterOtpPwa(otp);
			validateNewPasswordBoxAndEnterNewPasswordPwa(newPassword);
			validateRegistrationFormAndEnterDetailsPwa(salutation, firstName, lastName, dob, gender, email);
			validateInterestPageAndContinueToHomePagePwa();
			skipTourPageMobilePwa();
			validateVaultLinkInUserHomePage();
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : enrollUserPwa", "Exception Caught : " + e.getMessage(), 0);
		}
	}

	/*
	 * Function name : validateAndClickSignInButtonPwa This function will Validate
	 * the Sign in button presence and click on it in TDL PWA
	 * 
	 */
	public void validateAndClickSignInButtonPwa() throws Exception {
		try {
			boolean signInButtonPresence = isElementVisible(TdlSignUp.get().signinButton, 20);
			if (signInButtonPresence == true) {
				//logger.info("Sign In Button present in Homepage\n");
				fUtil.flogResult("Passed", "Sign in button presence", "Sign In Button present in Homepage", 1);

				TdlSignUp.get().signinButton.click();
			} else {
				//logger.error("Sign In Button not present in Homepage");
				fUtil.flogResult("Failed", "Sign in button presence", "Sign In Button not present in Homepage", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateAndClickSignInButtonPwa ",
					"Exception Caught : " + e.getMessage(), 0);
		}

	}

	/*
	 * Function name : validateMobileNumberBoxAndEnterMobileNoPwa This function will
	 * Validate the Mobile number Textbox in presence in Sign in page and Enter the
	 * mobile number in TDL PWA Input Required : Mobile Number
	 * 
	 */
	public String validateMobileNumberBoxAndEnterMobileNoPwa(String mobileNumber) throws Exception {
		String mobileNumberError = "";
		try {
			if (mobileNumber.startsWith("~"))
				mobileNumber = mobileNumber.substring(1);
			waitForTcpPageLoaderDisappeared();
			boolean mobileNumberBoxPresence = isElementVisible(TdlSignUp.get().mobileNoTextBox, 10);

			if (mobileNumberBoxPresence == true) {
				//logger.info("Mobile Number Textbox present in Login Page");
				fUtil.flogResult("Passed", "Mobile Number Textbox presence",
						"Mobile Number Textbox present in Login Page", 1);

				TdlSignUp.get().mobileNoTextBox.sendKeys(mobileNumber);

				TdlSignUp.get().confirmButton.click();

				if (isElementVisible(TdlSignUp.get().mobileNumberErrorMsg, 5)) {
					mobileNumberError = TdlSignUp.get().mobileNumberErrorMsg.getText();
				}
			} else {
				//logger.error("Mobile Number Textbox not  present in Homepage");
				fUtil.flogResult("Failed", "Mobile Number Textbox presence",
						"Mobile Number Textbox not present in Login Page", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateMobileNumberBoxAndEnterMobileNoPwa ",
					"Exception Caught : " + e.getMessage(), 0);
		}
		return mobileNumberError;
	}

	/*
	 * Function name : validateOtpPageAndEnterOtpPwa This function will Validate the
	 * OTP Textbox in presence in Sign in page and Enter the OTP in TDL PWA Input
	 * Required : OTP
	 * 
	 */
	public void validateOtpPageAndEnterOtpPwa(String otp) throws Exception {
		try {
			boolean otpTextboxPresence = isElementVisible(TdlSignUp.get().enterOtpScreen, 10);
			if (otpTextboxPresence) {
				//logger.info("OTP Page Loaded properly");
				fUtil.flogResult("Passed", "OTP Page Validation", "OTP Header and Textbox present", 1);
				TdlSignUp.get().enterOtpTextbox.sendKeys(otp);
				waitForTcpPageLoaderDisappeared();
			} else {
				//logger.error("OTP Page not Loaded properly");
				fUtil.flogResult("Failed", "OTP Page Validation", "OTP Header and Textbox not present", 1);
			}
		} catch (Exception e) {

			fUtil.flogResult("Failed", "General Function : validateOtpPageAndEnterOtpPwa ",
					"Exception Caught : " + e.getMessage(), 0);
		}
	}

	/*
	 * Function name : validateNewPasswordBoxAndEnterNewPasswordPwa This function
	 * will Validate the New Password Textbox in presence in Sign up page and Enter
	 * the new and confirm password Input Required : New Password
	 * 
	 */
	public void validateNewPasswordBoxAndEnterNewPasswordPwa(String newPassword) throws Exception {
		try {
			boolean toastMsgFlag = isElementVisible(TdlSignUp.get().toastMessageError, 10);

			String toastMsg = "";

			if (toastMsgFlag) {
				toastMsg = TdlSignUp.get().toastMessageError.getText();
				//logger.info("Toaster message present : " + toastMsg);
				fUtil.flogResult("Failed", "Toaster message",
						"Unexpected Toaster message present with message : " + toastMsg, 1);
			}

			boolean setNewPasswordHeader = isElementVisible(TdlSignUp.get().setNewPasswordHeader, 20);
			boolean newPasswordTextbox = isElementVisible(TdlSignUp.get().newPasswordTextbox, 10);
			boolean confirmPasswordTextbox = isElementVisible(TdlSignUp.get().confirmPasswordTextbox, 5);

			if (newPasswordTextbox == true && confirmPasswordTextbox == true) {
				//logger.info("Set New Password page loaded properly");

				TdlSignUp.get().newPasswordTextbox.clear();
				TdlSignUp.get().newPasswordTextbox.sendKeys(newPassword);
				TdlSignUp.get().confirmPasswordTextbox.clear();
				TdlSignUp.get().confirmPasswordTextbox.sendKeys(newPassword);

				fUtil.flogResult("Passed", "Set New Password page Validation",
						"Enter the Password and Confirm Password Successfully", 1);

				TdlSignUp.get().confirmButton.click();
			} else {
				//logger.error("Set New Password page not loaded properly");
				fUtil.flogResult("Failed", "Set New Password page Validation",
						"Set New Password page not loaded properly", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateNewPasswordBoxAndEnterNewPasswordPwa ",
					"Exception Caught : " + e.getMessage(), 0);
		}
	}

	/*
	 * Function name : validateRegistrationFormAndEnterDetailsPwa This function will
	 * Validate the Registration form page and enter the required information Input
	 * Required : First name, last name, DOB, Email
	 * 
	 */
	public void validateRegistrationFormAndEnterDetailsPwa(String salutation, String firstName, String lastName,
			String dob, String gender, String email) throws Exception {
		try {
			if (dob.startsWith("~"))
				dob = dob.substring(1);

			boolean fName = isElementVisible(TdlSignUp.get().firstNameTextbox, 20);
			boolean lName = isElementVisible(TdlSignUp.get().lastNameTextbox, 10);
			boolean submitButton = isElementVisible(TdlSignUp.get().confirmButton, 10);

			if (fName == true && lName == true && submitButton == true) {
				//logger.info("User Details page loaded properly");

				TdlSignUp.get().firstNameTextbox.clear();
				TdlSignUp.get().firstNameTextbox.sendKeys(firstName);
				TdlSignUp.get().lastNameTextbox.clear();
				TdlSignUp.get().lastNameTextbox.sendKeys(lastName);

				datePickerPwa(dob);

				TdlSignUp.get().emailTextbox.clear();
				// TdlSignUp.get().emailTextbox.click();
				TdlSignUp.get().emailTextbox.sendKeys(email);

				selectSalutation(salutation);

				TdlSignUp.get().genderDropdown.click();
				if (gender.equalsIgnoreCase("male"))
					TdlSignUp.get().genderMale.click();
				else if (gender.equalsIgnoreCase("female"))
					TdlSignUp.get().genderFemale.click();

				if (isElementVisible(TdlSignUp.get().genderDropdownCloseArrow, 5))
					TdlSignUp.get().lastNameTextbox.click();

				try {
					scrollToViewElement(TdlSignUp.get().termsAndConditionCheckbox);
				} catch (Exception e) {

				}
				TdlSignUp.get().termsAndConditionCheckbox.click();

				fUtil.flogResult("Passed", "User Details page Validation", "User Details page Filled Successfully", 1);

				TdlSignUp.get().confirmButton.click();

				if (isElementVisible(TdlSignUp.get().toastMessageError, 5)) {
					String error = TdlSignUp.get().toastMessageError.getText();
					//logger.error("Error on User Details page " + error);
					fUtil.flogResult("Failed", "User Details page Validation", "Error on User Details page : " + error,
							1);
				}

			} else {
				//logger.error("User Details page not loaded properly");
				fUtil.flogResult("Failed", "User Details page Validation", "User Details page not loaded properly", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateRegistrationFormAndEnterDetailsPwa ",
					"Exception Caught : " + e.getMessage(), 0);
		}
	}

	/*
	 * Function name : validateInterestPageAndContinuePwa This function will
	 * Validate the Interest page after Signup and proceed to home page in TDL
	 * 
	 */
	public void validateInterestPageAndContinueToHomePagePwa() throws Exception {
		try {
			boolean toastMsgFlag = isElementVisible(TdlSignUp.get().toastMessageError, 5);
			String toastMsg = "";

			if (toastMsgFlag) {
				toastMsg = TdlSignUp.get().toastMessageError.getText();
				//logger.info("Toaster error message present : " + toastMsg);
				fUtil.flogResult("Failed", "Toaster message",
						"Toaster error message present with message : " + toastMsg, 1);
			} else {
				//logger.error("Toaster error message not present");
				fUtil.flogResult("Passed", "Toaster message", "Toaster error message not present ", 1);
			}

			boolean continueButtonFlag = isElementVisible(TdlSignUp.get().continueButton, 20);

			if (!continueButtonFlag)
				validateErrorInPagePwa();

			boolean skipInterestFlag = isElementClickable(TdlSignUp.get().skipButton, 10);

			if (skipInterestFlag == true) {
				//logger.info("Skip button present in Interest details page");
				fUtil.flogResult("Passed", "Interest Details page Validation",
						"Skip button present in Interest details page", 1);
				TdlSignUp.get().skipButton.click();
				BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} else {
				//logger.error("Skip button not present in Interest details page");
				fUtil.flogResult("Failed", "Interest Details page Validation",
						"Skip button not present in Interest details page", 1);
			}

			boolean continueBrandRelationFlag = isElementVisible(TdlSignUp.get().continueButton, 20);

			if (!continueBrandRelationFlag)
				validateErrorInPagePwa();

			boolean skipFlag = isElementClickable(TdlSignUp.get().skipButton, 10);
			if (skipFlag == true) {
				//logger.info("Skip button present in Brand Relation page");
				fUtil.flogResult("Passed", "Brand Relation Page", "Skip button present in Brand Relation page", 1);
				TdlSignUp.get().skipButton.click();
				BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} else {
				//logger.error("Skip button not present in Brand Relation page");
				fUtil.flogResult("Failed", "Brand Relation Page", "Skip button not present in Brand Relation page", 1);
			}

			// commented the code as App tour page is now hidden in application
			/*
			 * boolean continueAppTourFlag = isElementVisible(TdlSignUp.get().nextButton,
			 * 20);
			 * 
			 * if(!continueAppTourFlag) validateErrorInPagePwa();
			 * 
			 * boolean skipAppTourFlag = isElementClickable(TdlSignUp.get().skipButton, 10);
			 * if(skipAppTourFlag==true) {
			 * //logger.info("Skip button present in App Tour page");
			 * fUtil.flogResult("Passed", "App Tour Page",
			 * "Skip button present in App Tour page", 1);
			 * TdlSignUp.get().skipButton.click();
			 * BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(10,
			 * TimeUnit.SECONDS); } else {
			 * //logger.error("Continue button not present in Interest details page");
			 * fUtil.flogResult("Failed", "App Tour Page",
			 * "Skip button not present in App Tour page", 1); }
			 */
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateInterestPageAndContinueToHomePagePwa ",
					"Exception Caught : " + e.getMessage(), 0);
		}
	}

	/*
	 * Function name : validateVaultLinkInUserHomePage This function will Validate
	 * the Vault link presence after Signin / Signup
	 * 
	 */
	public void validateVaultLinkInUserHomePage() throws Exception {
		try {
			skipTourPageMobilePwa();
			waitForTcpPageLoaderDisappeared();

			boolean homePageLoad = isElementVisible(TdlHomePage.get().forYouLabel, 50);
			if (homePageLoad) {
				fUtil.flogResult("Passed", "User Homepage", "Home Page loaded properly ", 1);
				validateWidgetsInUserHomePage();
				// boolean vaultLinkInHomePage = isElementVisible(TdlHomePage.get().vaultLink,
				// 10);
				//
				// if (vaultLinkInHomePage == true) {
				// //logger.info("Vault link present in User Homepage after Signup / Signin");
				// fUtil.flogResult("Passed", "User Homepage",
				// "Vault link present in User Homepage after Signup / Signin ", 1);
				// } else {
				// //logger.error("Vault link not present in User Homepage after Signup /
				// Signin");
				// fUtil.flogResult("Failed", "User Homepage",
				// "Vault link not present in User Homepage after Signup / Signin", 1);
				// }
			} else {
				//logger.error("User Homepage loading failed !");
				fUtil.flogResult("Failed", "User Homepage", "Error in Homepage / Home Page didn't load properly. ", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateVaultLinkInUserHomePage ",
					"Exception Caught : " + e.getMessage(), 0);
		}
	}

	/*
	 * Function name : signOutPwa This function will Signout the user
	 * 
	 */
	public void signOutPwa() throws Exception {
		try {
			isElementVisible(TdlHomePage.get().forYouLabel, 30);
			boolean myProfileLinkInHomePage = isElementVisible(TdlHomePage.get().myProfileLink, 20);

			if (myProfileLinkInHomePage == true) {
				//logger.info("My Profile link present in User Homepage after Signup ");
				fUtil.flogResult("Passed", "User Homepage", "My Profile link present in User Homepage after Signup ",
						1);

				TdlHomePage.get().myProfileLink.click();

				if (isElementVisible(TdlHomePage.get().signOutLink, 20)
						&& isElementClickable(TdlHomePage.get().signOutLink, 20)) {
					fUtil.flogResult("Passed", "User Homepage", "Signout button visible", 1);

					TdlHomePage.get().signOutLink.click();

					if (isElementVisible(TdlHomePage.get().signOutPopup, 10)) {
						fUtil.flogResult("Passed", "Signout", "Signout Popup visible", 1);

						TdlHomePage.get().signOutButtonOnPopup.click();
					}

				} else {
					fUtil.flogResult("Failed", "User Homepage", "Signout button not visible", 1);
				}

			} else {
				//logger.error("My Profile link not present in User Homepage after Signup ");
				fUtil.flogResult("Failed", "User Homepage",
						"My Profile link not present in User Homepage after Signup ", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : signOutPwa ", "Exception Caught : " + e.getMessage(), 0);
		}
	}

	/*
	 * Function name : signInPwa This function will Signin the user in PWA Input
	 * Required : Registered Mobile number and Password
	 * 
	 */
	public void signInPwa(String mobileNumber, String password) throws Exception {
		try {
			validateAndClickSignInButtonPwa();
			validateMobileNumberBoxAndEnterMobileNoPwa(mobileNumber);

			if (isElementVisible(TdlSignUp.get().loginPasswordBox, 10)) {
				//logger.info("Password Textbox present in Login Page");
				fUtil.flogResult("Passed", "Password Textbox presence", "Password Textbox present in Login Page", 1);
				TdlSignUp.get().loginPasswordBox.sendKeys(password);

				TdlSignUp.get().confirmButton.click();
				waitForTcpPageLoaderDisappeared();
				if (isElementPresent(TdlSignUp.get().passwordErrorMsg1)) {
					//logger.error("Error at password " + TdlSignUp.get().passwordErrorMsg1.getText());
					fUtil.flogResult("Failed", "Error on password while login",
							TdlSignUp.get().passwordErrorMsg1.getText(), 1);
				} else {
					skipTourPageMobilePwa();
					validateVaultLinkInUserHomePage();
				}
			} else {
				//logger.error("Password Textbox not present in Login Page");
				fUtil.flogResult("Failed", "Password Textbox presence", "Password Textbox not present in Login Page",
						1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : signInPwa ", "Exception Caught : " + e.getMessage(), 0);
		}
	}

	/*
	 * Function name : iOSAllowinitialalerts This function will check for alert in
	 * iOS Device and accept if present Input required : alert element
	 * 
	 */
	public void iOSAllowinitialalerts(MobileElement alertElement) throws Exception {
		try {
			boolean alert = isElementVisible_mobile(alertElement, 10);
			if (alert == true) {
				fUtil.flogResult("Passed", "Mobile Alert ", "Alert Present", 1);
				//logger.info("Accepting alert");
				alertElement.click();
				fUtil.flogResult("Passed", "Mobile Alert ", "Alert Clicked Successfully", 1);
			}
		} catch (Exception e) {
			//logger.info("No Alert present : " + e.getMessage());
			// fUtil.flogResult("Failed", "Mobile Alert ", "Alert Clicked Failed :" +
			// e.toString(), 1);
		}
	}

	/*
	 * Function name : selectDateMobile This function will select date in
	 * IOS/Android device from the date Calendar Input required : Date in format of
	 * D-MMM-YYYY (eg: 1-Jan-1990)
	 * 
	 */
	public void selectDateMobile(String date) throws Exception {
		try {
			if (date.startsWith("~"))
				date = date.substring(1);

			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			System.out.println("Environment :: " + environment);

			String xpathPart1 = "";
			String xpathPart2 = "']";
			String nextButtonXpath = "", saveButtonXpath = "";
			String previousYearPageBtn = "";

			if (environment.equalsIgnoreCase("ios")) {
				xpathPart1 = "//XCUIElementTypeStaticText[@name='";
				nextButtonXpath = "//*[@name='Next']";
				saveButtonXpath = "//*[@name='Save']";
				previousYearPageBtn = xpathPart1 + "<" + xpathPart2
						+ " | //XCUIElementTypeStaticText[@name='Date']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]";
			} else if (environment.equalsIgnoreCase("android")) {
				xpathPart1 = "//android.view.View[@text='";
				nextButtonXpath = "//*[contains(@text,'Next')]";
				saveButtonXpath = "//*[contains(@text,'Save')]";
				previousYearPageBtn = xpathPart1 + "<" + xpathPart2
						+ " | //*[@resource-id='leftArrow']/parent::android.view.View";
			}
			// Workaround for ios for 2 calendars // Commented the below code as defect is
			// fixed
			/*
			 * if(environment.equalsIgnoreCase("ios")) {
			 * if(isElementVisible_mobile(TdlSignUpMobile.get().keyboardDone_ios, 10))
			 * TdlSignUpMobile.get().keyboardDone_ios.click(); }
			 */

			String[] dob = null;

			if (date.contains("-"))
				dob = date.split("-");
			else if (date.contains("/"))
				dob = date.split("/");

			String day = dob[0];
			String month = dob[1];
			String year = dob[2];

			/*
			 * TdlSignUpMobile.get().dayPicker.sendKeys(day);
			 * TdlSignUpMobile.get().monthPicker.sendKeys(month);
			 * TdlSignUpMobile.get().yearPicker.sendKeys(year);
			 */
			String calendarYearTab = xpathPart1 + "Year" + xpathPart2;

			if (isElementVisible_mobile(By.xpath(calendarYearTab), 20)) {
				appiumDriver.get().findElement(By.xpath(calendarYearTab)).click();

				boolean yearVisible = isElementVisible_mobile(By.xpath(xpathPart1 + year + xpathPart2), 10);
				while (!yearVisible) {
					boolean prevYearBtnVisibility = isElementVisible_mobile(By.xpath(previousYearPageBtn), 10);
					if (prevYearBtnVisibility) {
						appiumDriver.get().findElement(By.xpath(previousYearPageBtn)).click();
					} else {
						fUtil.flogResult("Failed", "Select date", "Previous year navigation button not visible" + date,
								1);
					}

					yearVisible = isElementVisible_mobile(By.xpath(xpathPart1 + year + xpathPart2), 10);
				}

				if (yearVisible) {
					appiumDriver.get().findElement(By.xpath(xpathPart1 + year + xpathPart2)).click();
					// appiumDriver.get().findElement(By.xpath(nextButtonXpath)).click();

					boolean monthVisible = isElementVisible_mobile(By.xpath(xpathPart1 + month + xpathPart2), 10);
					if (monthVisible) {
						appiumDriver.get().findElement(By.xpath(xpathPart1 + month + xpathPart2)).click();
						// appiumDriver.get().findElement(By.xpath(nextButtonXpath)).click();

						boolean dayVisible = isElementVisible_mobile(By.xpath(xpathPart1 + day + xpathPart2), 10);
						if (dayVisible) {
							appiumDriver.get().findElement(By.xpath(xpathPart1 + day + xpathPart2)).click();

							// appiumDriver.get().findElement(By.xpath(saveButtonXpath)).click();
							fUtil.flogResult("Passed", "Select date", "Selected the given date : " + date, 1);
						} else {
							fUtil.flogResult("Failed", "Select date", "Day not visible", 1);
						}
					} else {
						fUtil.flogResult("Failed", "Select date", "Month not visible", 1);
					}
				} else {
					fUtil.flogResult("Failed", "Select date", "Year not visible", 1);
				}
			} else {
				fUtil.flogResult("Failed", "Select date", "Calnedar not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : selectDateMobile ", "Exception Caught : " + e.getMessage(),
					1);
		}
	}

	/*
	 * Function name : enrollUserIos This function will enroll a new user in TDL PWA
	 * Input required : Unregistered Mobile number, OTP, First Name, Last name, Date
	 * of birth, Email
	 */
	public void enrollUserIos(MobileElement signInButton, MobileElement mobileTextBox, MobileElement confirmButton,
			MobileElement otpBox, MobileElement newPasswordBox, MobileElement oldPasswordBox,
			MobileElement interestSkipButton, MobileElement interestContinueBtn, MobileElement vaultLink,
			String mobileNumber, String otp, String newPassword, String firstName, String lastName, String dob,
			String gender, String email) throws Exception {
		try {
			validateAndClickSignInButtonMobile(signInButton);
			validateMobileNumberBoxAndEnterMobileNoMobile(mobileTextBox, confirmButton, mobileNumber);
			validateOtpPageAndEnterOtpMobile(otpBox, otp);
			validateNewPasswordBoxAndEnterNewPasswordMobile(newPasswordBox, oldPasswordBox, confirmButton, newPassword);
			validateRegistrationFormAndEnterDetailsIos(firstName, lastName, dob, gender, email);
			validateInterestPageAndContinueMobile(interestSkipButton, interestContinueBtn);
			validateVaultLinkInUserHomePageMobile(vaultLink);
			validateErrorInUserHomePageMobile();
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : enrollUserIos ", "Exception Caught : " + e.getMessage(), 1);
		}

	}

	/*
	 * Function name : validateAndClickSignInButtonIos This function will Validate
	 * the Sign in button presence and click on it in TDL PWA
	 * 
	 * Note: this is the "Welcome to TCP APP" page where Sign In button is changed
	 * into "Great! Let's Start" button Input -
	 * signinButton_android/signinButton_ios element for different platform from
	 * "TDL_Signup_Mobile" Page.. MaintainedBy - Sourish
	 * 
	 */
	public void validateAndClickSignInButtonMobile(MobileElement signinButton) throws Exception {
		try {
			// checkAppStateAndLaunchAppIfNotRunning();

			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			if (environment.equalsIgnoreCase("ios"))
				iOSAllowinitialalerts(TdlSignUpMobile.get().allowAlert);

			// isElementVisible_mobile(signinButton, 10);

			boolean signInButtonPresence = isElementVisible_mobile(signinButton, 20);
			if (signInButtonPresence == true) {
				//logger.info("Great! Let's Start, Button present on the TCP APP Welcome Page");
				fUtil.flogResult("Passed", "Great! Let's Start, button presence", "Great! Let's Start, Button present in TCP APP Welcome Page",
						1);

				signinButton.click();
				//logger.info("Clicked on Great! Let's Start, button");
				googleTermsServices_Mobile();
				
				//logger.info("Dismiss available mobile number selection screen for phone having SIM Card and available Number");
				if(gmethods.isElementVisible_mobile(TdlSignUpMobile.get().autoMobNoSelection_dismiss_android, 5)) {
					//logger.info("Automatic Mobile number selection screen is available. Dismissing the selection");
					TdlSignUpMobile.get().autoMobNoSelection_dismiss_android.click();
				}

				if (environment.equalsIgnoreCase("ios"))
					iOSAllowinitialalerts(TdlSignUpMobile.get().continueAlert);
			} 
			/*
			 * else if (gmethods.isElementVisible_mobile(TdlSignUpMobile.get().
			 * mobileNoTextBox_android,20)) { fUtil.flogResult("Passed",
			 * "Sign in button presence", "Sign In Button present in TCP APP Welcome Page",
			 * 1); }
			 */
			else {
				fUtil.flogResult("Failed", "Great! Let's Start, button presence on Welcome to TCP APP page",
						"Great! Let's Start, Button not present in TCP APP Welcome Page", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateAndClickSignInButtonMobile ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : validateMobileNumberBoxAndEnterMobileNoMobile This function
	 * will Validate the Mobile number Textbox in presence in Sign in page and Enter
	 * the mobile number in TDL Mobile App Input Required : Mobile_No Textbox
	 * element, Confirm btn element, Mobile Number
	 * 
	 */
	public void validateMobileNumberBoxAndEnterMobileNoMobile(MobileElement mobileNoTextBoxelement,
			MobileElement confirmButton, String mobileNumber) throws Exception {
		try {
			if (gmethods.isElementVisible(TdlSignUpMobile.get().none_of_above_mobile_number_android, 5)) {
				TdlSignUpMobile.get().none_of_above_mobile_number_android.click();
				System.out.println("object clicked");
				Thread.sleep(2000);
				} 
			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			if (mobileNumber.startsWith("~"))
				mobileNumber = mobileNumber.substring(1);

			boolean mobileNumberBoxPresence = isElementVisible_mobile(mobileNoTextBoxelement, 10);

			if (mobileNumberBoxPresence == true) {
				scrollDirectionMobile("up");
				//logger.info("Mobile Number Textbox present in Login Page\n");
				fUtil.flogResult("Passed", "Mobile Number Textbox presence",
						"Mobile Number Textbox present in Login Page", 1);

				mobileNoTextBoxelement.click();
				mobileNoTextBoxelement.clear();
				mobileNoTextBoxelement.sendKeys(mobileNumber);

				fUtil.flogResult("Passed", "Mobile Number Entered", "Mobile Number Entered", 1);

				//logger.info("Mobile Number Entered :" + mobileNumber + "\n");

				hideKeyboardMobile();
				// if (environment.equalsIgnoreCase("ios"))
				// TdlSignUpMobile.get().keyboardDone_ios.click();
				// else if (environment.equalsIgnoreCase("android"))
				// appiumDriver.get().hideKeyboard();

				boolean confirmButtonPresence = isElementVisible_mobile(confirmButton, 10);

				if (confirmButtonPresence) {
					confirmButton.click();
				}
			} else {
				fUtil.flogResult("Failed", "Mobile Number Textbox presence",
						"Mobile Number Textbox Not Present in Sign In Page", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateMobileNumberBoxAndEnterMobileNoMobile ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : validateOtpPageAndEnterOtpMobile This function will Validate
	 * the OTP Textbox in presence in Sign in page and Enter the OTP in TDL PWA
	 * Input Required : OTP
	 * 
	 */
	public void validateOtpPageAndEnterOtpMobile(MobileElement otpBox, String otp) throws Exception {
		try {
			//Thread.sleep(10000);
			boolean otpBoxPresence = isElementVisible_mobile(otpBox, 10);
			
			if (otp.startsWith("~"))
				otp = otp.substring(1);
			
			
			if (otpBoxPresence == true) {
				fUtil.flogResult("Passed", "OTP Header", "Otp header present", 1);
				//otpBox.click();
				otpBox.sendKeys(otp);
				fUtil.flogResult("Passed", "OTP PAGE", "Entered OTP", 1);

			} else {
				fUtil.flogResult("Failed", "OTP Page", "OTP Not Present ", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateOtpPageAndEnterOtpMobile ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : validateNewPasswordBoxAndEnterNewPasswordMobile This function
	 * will Validate the New Password Textbox in presence in Sign up page and Enter
	 * the new and confirm password Input Required : New Password
	 * 
	 */
	public void validateNewPasswordBoxAndEnterNewPasswordMobile(MobileElement newPasswordTextbox,
			MobileElement confirmPasswordTextbox, MobileElement confirmbtn, String newPassword) throws Exception {
		try {
			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			boolean passwordpage = isElementVisible_mobile(newPasswordTextbox, 3000);
			if (passwordpage == true) {
				fUtil.flogResult("Passed", "Password page Header", "Password header present", 1);

				newPasswordTextbox.clear();
				newPasswordTextbox.sendKeys(newPassword.trim());

				confirmPasswordTextbox.clear();
				confirmPasswordTextbox.sendKeys(newPassword.trim());

				if (environment.equalsIgnoreCase("ios"))
					TdlSignUpMobile.get().keyboardDone_ios.click();
				else if (environment.equalsIgnoreCase("android"))
					appiumDriver.get().hideKeyboard();

				boolean confirmButton = isElementVisible_mobile(confirmbtn, 10);

				if (confirmButton) {
					confirmbtn.click();
				}
			} else {
				fUtil.flogResult("Failed", "Password Page presence", "Password page not loaded", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateOtpPageAndEnterOtpMobile ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : validateRegistrationFormAndEnterDetailsIos This function will
	 * Validate the Registration form page and enter the required information Input
	 * Required : First name, last name, DOB, Email
	 * 
	 */
	public void validateRegistrationFormAndEnterDetailsIos(String firstName, String lastName, String dob, String gender,
			String email) throws Exception {
		try {
			boolean registrationPage = isElementVisible_mobile(TdlSignUpMobile.get().firstNameTextbox_ios, 20);

			if (registrationPage) {
				fUtil.flogResult("Passed", "Registration Page", "Registration page loaded properly", 1);

				selectSalutation("Mr");

				TdlSignUpMobile.get().firstNameTextbox_ios.clear();
				TdlSignUpMobile.get().firstNameTextbox_ios.sendKeys(firstName);

				TdlSignUpMobile.get().lastNameTextbox_ios.clear();
				TdlSignUpMobile.get().lastNameTextbox_ios.sendKeys(lastName);

				TdlSignUpMobile.get().dobTextbox_ios.click();
				selectDateMobile(dob);

				TdlSignUpMobile.get().genderDropdown_ios.click();
				isElementVisible_mobile(TdlSignUpMobile.get().genderMale_ios, 10);

				if (gender.equalsIgnoreCase("male"))
					TdlSignUpMobile.get().genderMale_ios.click();
				else if (gender.equalsIgnoreCase("female"))
					TdlSignUpMobile.get().genderFemale_ios.click();

				TdlSignUpMobile.get().emailTextbox_ios.sendKeys(email);

				TdlSignUpMobile.get().termsAndConditionCheckbox_ios.click();

				boolean submitButtonRegistrationpage = isElementVisible_mobile(TdlSignUpMobile.get().submitButton_ios,
						10);

				if (submitButtonRegistrationpage) {
					//logger.info("Clicking Submit button after filling registration details");
					TdlSignUpMobile.get().submitButton_ios.click();

					fUtil.flogResult("Passed", "Registration Page",
							"Clicked Submit button after filling registration details", 1);

				} else {
					fUtil.flogResult("Failed", "Registration Page", " Submit button  not present", 1);
				}
			} else {
				fUtil.flogResult("Failed", "Registration Page presence", "Registration page not loaded", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateRegistrationFormAndEnterDetailsIos ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : validateInterestPageAndContinueMobile This function will
	 * Validate the Interest page after Signup and proceed to home page in TDL
	 * 
	 */
	public void validateInterestPageAndContinueMobile(MobileElement skipInterestButton, MobileElement continueButton)
			throws Exception {
		try {
			boolean skipButtonInterestpage = isElementVisible_mobile(skipInterestButton, 100);

			if (skipButtonInterestpage) {
				//logger.info("Clicking Skip button in Interest page");
				fUtil.flogResult("Passed", "Interest page", "Skip button on Interest page present. ", 1);

				skipInterestButton.click();

				boolean continueButtonRelationpage = isElementVisible_mobile(continueButton, 30);

				if (continueButtonRelationpage) {
					//logger.info("Clicking continue button in relation page");
					fUtil.flogResult("Passed", "Relation page", "Clicking continue button in relation page", 1);

					continueButton.click();

					// boolean skipButton = isElementVisible_mobile(skipInterestButton, 30);
					// if(skipButton)
					// {
					// //logger.info("Clicking skip button in app tour page");
					// fUtil.flogResult("Passed", "App Tour page",
					// "Clicking skip button in App Tour page", 1);
					//
					// skipInterestButton.click();
					// }else{
					// fUtil.flogResult("Failed", "App Tour Page",
					// " Skip button in App Tour page not present", 1);
					// }
				} else {
					fUtil.flogResult("Failed", "Relation Page", " Continue button in relation page not present", 1);
				}
			} else {
				fUtil.flogResult("Failed", "Interest Page", " Skip button in Interest page not visible .", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateInterestPageAndContinueMobile ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : checkForErrorToastMessagePwa This function will Check for any
	 * toast message in PWA in TDL
	 * 
	 */
	public String checkForToastMessagePwa() throws Exception {
		String toastMsg = "";
		try {
			boolean toastMsgFlag = isElementVisible(TdlSignUp.get().toastMessageError, 10);

			if (toastMsgFlag) {
				toastMsg = TdlSignUp.get().toastMessageError.getText();
				//logger.info("Toaster message present : " + toastMsg);
				fUtil.flogResult("Passed", "Toaster message", "Toaster message present with message : " + toastMsg, 1);
			} else {
				//logger.error("Toaster message not present");
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : checkForToastMessagePwa ",
					"Exception Caught : " + e.getMessage(), 1);
		}
		return toastMsg;
	}

	/*
	 * Function name : signInIos This function will Signin the user in iOS Input
	 * Required : Registered Mobile number and Password
	 * 
	 */
	public void signInIosUsingPassword(MobileElement signinButton, MobileElement mobileNoTextBoxelement,
			MobileElement loginPasswordBox, MobileElement vaultLink, MobileElement confirmButton, String mobileNumber,
			String password) throws Exception {
		try {
			//logger.info("Login in User in iOS Device");

			validateAndClickSignInButtonMobile(signinButton);
			validateMobileNumberBoxAndEnterMobileNoMobile(mobileNoTextBoxelement, confirmButton, mobileNumber);

			if (isElementVisible_mobile(loginPasswordBox, 10)) {
				//logger.info("Password Textbox present in Login Page");
				fUtil.flogResult("Passed", "Password Textbox presence", "Password Textbox present in Login Page", 1);

				loginPasswordBox.click();
				loginPasswordBox.clear();
				loginPasswordBox.sendKeys(password.trim());

				hideKeyboardMobile();

				if (isElementVisible_mobile(TdlSignUpMobile.get().confirmButton_ios, 30)) {
					TdlSignUpMobile.get().confirmButton_ios.click();
				}

				iOSAllowinitialalerts(TdlSignUpMobile.get().okAlert);
				// skipTourPageMobilePwa();
				validateVaultLinkInUserHomePageMobile(vaultLink);
				validateErrorInUserHomePageMobile();

			} else{
				//logger.error("Mobile Number Textbox not  present in Homepage");
				fUtil.flogResult("Failed", "Mobile Number Textbox presence",
						"Mobile Number Textbox not present in Login Page", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : signInIos ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : validateVaultLinkInUserHomePageMobile This function will
	 * Validate the Vault link presence in iOS after Signin / Signup
	 * 
	 */
	public void validateVaultLinkInUserHomePageMobile(MobileElement vaultLink) throws Exception {
		try {
			boolean vaultLinkInHomePage = isElementVisible_mobile(vaultLink, 30);

			if (vaultLinkInHomePage == true) {
				//logger.info("Vault link present in User Homepage after Signup / Signin");
				fUtil.flogResult("Passed", "User Homepage",
						"Vault link present in User Homepage after Signup / Signin ", 1);
			} else {
				//logger.error("Vault link not present in User Homepage after Signup / Signin");
				fUtil.flogResult("Failed", "User Homepage",
						"Vault link not present in User Homepage after Signup / Signin", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateVaultLinkInUserHomePageMobile ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : signInAndroid This function will sign in user in TCP App
	 * Android required : SignInbutton element, OtpBox element, MobileNumber, otp
	 * 
	 * Note: signinButton_android, enterOtpTextbox_android element locators are
	 * present in TdlSignupMobile page.
	 * 
	 */
	public void signInAndroid(MobileElement signInButton, MobileElement otpBox, String mobileNumber, String otp)
			throws Exception {

		try {
			String password = fUtil.fgetDataNew1("Password");
			String Logintype=  fUtil.readInput("LoginUsing");
			
			//logger.info("Login to Android TCP App");
			
			if(isElementVisible_mobile(TdlSignUpMobile.get().closeContentBtn_android, 10)) {
				//logger.info("Welcome to TCP APP page navigated where user is asked to enter Name");
				//logger.info("Skipping this page to proceed");
				TdlSignUpMobile.get().closeContentBtn_android.click();
			}
			
if(gmethods.isElementVisible_mobile(TdlHomeMobile.get().profileButton_android, 10)) {
	//logger.info("No need to login");
	  fUtil.flogResult("Passed", "Logged in already",
	  "Login passed", 1);
}

else {
			validateAndClickSignInButtonMobile(signInButton);
			validateMobileNumberBoxAndEnterMobileNo_Android(mobileNumber);
			
			/*
			 * if(gmethods.isElementVisible_mobile(TdlSignUpMobile.get().
			 * btnLoginwithpassword, 30)) {
			 * TdlSignUpMobile.get().btnLoginwithpassword.click(); }
			 * isElementVisible_mobile(TdlSignUpMobile.get().passwordBox_android, 20);
			 */
			
			hideKeyboardMobile();
			if(Logintype.equalsIgnoreCase("OTP"))
			{
			validateOtpPageAndEnterOtpMobile(otpBox, otp);
			}
			else if(Logintype.equalsIgnoreCase("password"))
			{
				isElementVisible_mobile(TdlHomeMobile.get().pwd_android, 10);
				TdlHomeMobile.get().pwd_android.click();
				isElementVisible_mobile(TdlHomeMobile.get().pwdedt_android, 10);
				TdlHomeMobile.get().pwdedt_android.click();
				TdlHomeMobile.get().pwdedt_android.sendKeys(password);
				 fUtil.flogResult("Passed", "Enter password",
						  "password entered", 1);
				isElementVisible_mobile(TdlHomeMobile.get().pwdeconfirm_android, 10);
				TdlHomeMobile.get().pwdeconfirm_android.click();
				  fUtil.flogResult("Passed", "click confirm",
						  "clicked confirm", 1);
				
			}
			
			if(isElementVisible_mobile(TdlSignUpMobile.get().closeContentBtn_android, 20)) {
				//logger.info("Welcome to TCP APP page navigated where user is asked to enter Name");
				//logger.info("Skipping this page to proceed");
				TdlSignUpMobile.get().closeContentBtn_android.click();
			}
			
			if(isElementVisible_mobile(TdlSignUpMobile.get().allow_button_android, 5)) {
				//logger.info("Welcome to TCP APP page navigated where user is asked to enter Name");
				//logger.info("Skipping this page to proceed");
				TdlSignUpMobile.get().allow_button_android.click();
			}
			
			
			
			
			
			
//			if(isElementVisible_mobile(TdlSignUpMobile.get().skipBtn_android, 40)) {
//				//logger.info("Welcome to TCP APP page navigated where user is asked to enter Name");
//				//logger.info("Skipping this page to proceed");
//				TdlSignUpMobile.get().skipBtn_android.click();
//			}
//			if(isElementVisible_mobile(TdlSignUpMobile.get().allow_button_android, 10)) {
//				//logger.info("Allow the location to the APP");
//				TdlSignUpMobile.get().allow_button_android.click();
//				Thread.sleep(3000);
//			}
//			
//			skipTourPageMobilePwa();
			//boolean passwordBoxVisibility = isElementVisible_mobile(TdlSignUpMobile.get().passwordBox_android, 20);

			/*
			 * 
			 * if (passwordBoxVisibility) {
			 * 
			 * //logger.info("Password Textbox present in Login Page");
			 * fUtil.flogResult("Passed", "Password Textbox presence",
			 * "Password Textbox present in Login Page", 1);
			 * 
			 * TdlSignUpMobile.get().passwordBox_android.sendKeys(password);
			 * hideKeyboardMobile();
			 * 
			 * boolean confirmButtonPresence =
			 * gmethods.isElementClickable(TdlSignUpMobile.get().confirmButton_android, 10);
			 * 
			 * if (confirmButtonPresence) {
			 * TdlSignUpMobile.get().confirmButton_android.click(); } else {
			 * fUtil.flogResult("Failed", "Confirm Button presence",
			 * "Confirm Button not present Password Page", 1); }
			 * 
			 * skipTourPageMobilePwa(); validateVaultLinkInUserHomePageMobile(vaultLink);
			 * validateErrorInUserHomePageMobile();
			 * 
			 * } else { //logger.error("Password Textbox not  present in Homepage");
			 * fUtil.flogResult("Failed", "Password Textbox presence",
			 * "Password Textbox not visible in Login Page", 1); }
			 * 
			 */
}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : signInAndroid ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : validateMobileNumberBoxAndEnterMobileNo_Android This function
	 * will Validate the Mobile number Textbox in presence in Sign in page and Enter
	 * the mobile number Input Required : Mobile Number
	 * 
	 */
	public void validateMobileNumberBoxAndEnterMobileNo_Android(String mobileNumber) throws Exception {
		try {
			if (gmethods.isElementVisible(TdlSignUpMobile.get().none_of_above_mobile_number_android, 5)) {
				TdlSignUpMobile.get().none_of_above_mobile_number_android.click();
				System.out.println("object clicked");
				Thread.sleep(2000);
				} 
			boolean mobileNumberBoxPresence = gmethods
					.isElementVisible_mobile(TdlSignUpMobile.get().mobileNoTextBox_android, 10);

			if (mobileNumber.startsWith("~"))
				mobileNumber = mobileNumber.substring(1);

			if (mobileNumberBoxPresence == true) {
				fUtil.flogResult("Passed", "Mobile Number Textbox presence",
						"Mobile Number Textbox present in Login Page", 1);

				TdlSignUpMobile.get().mobileNoTextBox_android.clear();
				TdlSignUpMobile.get().mobileNoTextBox_android.sendKeys(mobileNumber);

				hideKeyboardMobile();

				boolean confirmButtonPresence = gmethods.isElementClickable(TdlSignUpMobile.get().confirmButton_android,
						10);

				if (confirmButtonPresence) {
					TdlSignUpMobile.get().confirmButton_android.click();
				} else {
					fUtil.flogResult("Failed", "Confirm Button presence", "Confirm Button not present in Login Page",
							1);
				}
			} else {
				fUtil.flogResult("Failed", "Mobile Number Textbox presence",
						"Mobile Number Textbox not present in Login Page", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateMobileNumberBoxAndEnterMobileNo_Android ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : validateNewPasswordBoxAndEnterNewPassword_Android This
	 * function will Validate the New Password Textbox in presence in Sign up page
	 * and Enter the new and confirm password Input Required : New Password and
	 * Confirm Password
	 * 
	 */

	public void validateNewPasswordBoxAndEnterNewPassword_Android(String newPassword, String confirmPassword)
			throws Exception {
		try {
			// boolean setNewPasswordHeader =
			// gmethods.isElementVisible_mobile(TdlSignUpMobile.get().setNewPasswordHeader_android,30);
			boolean newPasswordTextbox = gmethods
					.isElementVisible_mobile(TdlSignUpMobile.get().newPasswordTextbox_android, 30);
			boolean confirmPasswordTextbox = gmethods
					.isElementVisible_mobile(TdlSignUpMobile.get().confirmPasswordTextbox_android, 30);

			if (newPasswordTextbox == true && confirmPasswordTextbox == true) {
				//logger.info("Set New Password page loaded properly");
				fUtil.flogResult("Passed", "Set Password page Validation", "Set New Password page loaded properly", 1);

				TdlSignUpMobile.get().newPasswordTextbox_android.clear();
				;
				TdlSignUpMobile.get().newPasswordTextbox_android.sendKeys(newPassword.trim());

				TdlSignUpMobile.get().confirmPasswordTextbox_android.clear();
				TdlSignUpMobile.get().confirmPasswordTextbox_android.sendKeys(confirmPassword.trim());

				hideKeyboardMobile();

				fUtil.flogResult("Passed", "Set Password page Validation", "Entered New and Confirm Password", 1);

				TdlSignUpMobile.get().confirmButton_android.click();
			} else {
				//logger.error("Set New Password page not loaded properly");
				fUtil.flogResult("Failed", "Set New Password page Validation",
						"Set New Password page not loaded properly", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateNewPasswordBoxAndEnterNewPassword_Android ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : validateRegistrationFormAndEnterDetails_Android This function
	 * will Validate the Registration form page and enter the required information
	 * Input Required : First name, last name, Email
	 * 
	 */
	public void validateRegistrationFormAndEnterDetails_Android(String firstName, String lastName, String dob,
			String gender, String email) throws Exception {
		try {
			boolean fName = gmethods.isElementVisible_mobile(TdlSignUpMobile.get().firstNameTextbox_android, 10);
			boolean lName = gmethods.isElementVisible_mobile(TdlSignUpMobile.get().lastNameTextbox_android, 10);
			boolean submitButton = gmethods.isElementVisible_mobile(TdlSignUpMobile.get().submitButton_android, 10);

			if (fName == true && lName == true && submitButton == true) {
				//logger.info("User Details page loaded properly");
				fUtil.flogResult("Passed", "User Details page Validation", "User Details page loaded properly", 1);

				selectSalutation("Mr");

				TdlSignUpMobile.get().firstNameTextbox_android.sendKeys(firstName);
				TdlSignUpMobile.get().lastNameTextbox_android.sendKeys(lastName);

				isElementVisible_mobile(TdlSignUpMobile.get().dobTextbox_android, 20);
				TdlSignUpMobile.get().dobTextbox_android.click();

				selectDateMobile(dob);

				isElementVisible_mobile(TdlSignUpMobile.get().genderDropdown_android, 15);
				TdlSignUpMobile.get().genderDropdown_android.click();

				isElementVisible_mobile(TdlSignUpMobile.get().genderMale_android, 10);

				if (gender.equalsIgnoreCase("male"))
					TdlSignUpMobile.get().genderMale_android.click();
				else if (gender.equalsIgnoreCase("female"))
					TdlSignUpMobile.get().genderFemale_android.click();

				TdlSignUpMobile.get().emailTextbox_android.sendKeys(email);

				TdlSignUpMobile.get().termsAndConditionCheckbox_android.click();

				TdlSignUpMobile.get().submitButton_android.click();

				// //logger.info("Signed up successfully");
				// fUtil.flogResult("Passed", "Sign up validation", "Sign up is successful", 1);
			} else {
				fUtil.flogResult("Failed", "User Details page Validation", "User Details page not loaded properly", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateNewPasswordBoxAndEnterNewPassword_Android ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : enrollUserAndroid This function will enroll a new user in
	 * Android TCP App Input required : Unregistered Mobile number, OTP, First Name,
	 * Last name, Email, gender, dob
	 */

	public void enrollUserAndroid(MobileElement signInButton, MobileElement otpBox, MobileElement interestSkipButton,
			MobileElement interestContinueBtn, String mobileNumber, String otp, String newPassword,
			String confirmPassword, String firstName, String lastName, String dob, String gender, String email)
			throws Exception {

		try {
			validateAndClickSignInButtonMobile(signInButton);
			validateMobileNumberBoxAndEnterMobileNo_Android(mobileNumber);
			validateOtpPageAndEnterOtpMobile(otpBox, otp);
			validateNewPasswordBoxAndEnterNewPassword_Android(newPassword, confirmPassword);
			validateRegistrationFormAndEnterDetails_Android(firstName, lastName, dob, gender, email);
			validateInterestPageAndContinueMobile(interestSkipButton, interestContinueBtn);
			validateErrorInUserHomePageMobile();

		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : enrollUserAndroid ", "Exception Caught : " + e.getMessage(),
					1);
		}
	}

	/* Manoranjan Generic method */
	/*
	 * Function name : switchToNewTab This function will switch to new tab when user
	 * redirect to a third party url that opens in new tab
	 * 
	 */
	public void switchToNewTab() throws Exception {
		try {
			
			WebDriver webDriver = BrowserFactory.webDriver.get();
			logger.info("Number of Windows Opened : "+webDriver.getWindowHandles().size());

			parentWindowHandle = webDriver.getWindowHandle();
			ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
			newTab.remove(parentWindowHandle);
			// change focus to new tab
			webDriver.switchTo().window(newTab.get(0));
			
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : switchToNewTab ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : switchBackToNewTab This function will switch back to original
	 * tab when user redirect to a third party url that opens in new tab
	 * 
	 */
	public void switchBackToParentTab() throws Exception {
		try {
			WebDriver webDriver = BrowserFactory.webDriver.get();
			String oldTab = webDriver.getWindowHandle();
			// webDriver.close();
			// change focus back to old tab
			webDriver.switchTo().window(oldTab);
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : switchBackToParentTab ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : shareOfferFaceBook This function will share offer in facbook
	 * input required: user name and password
	 */
	public void shareOfferFaceBook(String userName, String password) throws Exception {
		try {
			boolean isFacebookIconPresent = gmethods.isElementVisible(MyOffersPage.get().clickFBIcon, 15);
			if (isFacebookIconPresent == true) {
				refreshBrowser();
				MyOffersPage.get().clickFBIcon.click();
				gmethods.switchToNewTab();
				MyOffersPage.get().fbUserName.sendKeys(userName);
				MyOffersPage.get().fbPassword.sendKeys(password);
				MyOffersPage.get().fbLogin.click();
				fUtil.flogResult("Passed", "Share Offer Facebook", "Offer shared successfully", 1);
				gmethods.switchBackToParentTab();
			} else {
				fUtil.flogResult("Failed", "Share offer facebook", "Facebook icon not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : shareOfferFaceBook ", "Exception Caught : " + e.getMessage(),
					1);
		}
	}

	/*
	 * Function name : shareOfferTwiter This function will share offer in Twiter
	 * input required: user name and password
	 */
	public void shareOfferTwiter(String userName, String password) throws Exception {
		try {
			boolean isTwiterIconPresent = gmethods.isElementVisible(MyOffersPage.get().clickTwiterIcon, 15);
			if (isTwiterIconPresent == true) {
				boolean isTwiterIconClickable = gmethods.isElementClickable(MyOffersPage.get().clickTwiterIcon, 5);
				if (isTwiterIconClickable) {
					MyOffersPage.get().clickTwiterIcon.click();
					fUtil.flogResult("Passed", "Share Offer Twitter", "Offer shared successfully", 1);
				} else {
					//logger.info("Not able to shared in twiter");
					fUtil.flogResult("Failed", "shared offer twiter", "Not able to shared", 1);
				}
			} else {
				fUtil.flogResult("Failed", "Share offer Twitter", "Twitter icon not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : shareOfferTwiter ", "Exception Caught : " + e.getMessage(),
					1);
		}
	}

	/*
	 * Function name : shareOfferWhatsApp This function will share offer in whatsapp
	 */
	public void shareOfferWhatsApp() throws Exception {
		try {
			boolean isWPIconPresent = gmethods.isElementVisible(MyOffersPage.get().clickWhatsAppIcon, 15);
			if (isWPIconPresent == true) {
				boolean isWPIconClickable = gmethods.isElementClickable(MyOffersPage.get().clickWhatsAppIcon, 5);
				if (isWPIconClickable) {
					MyOffersPage.get().clickWhatsAppIcon.click();
				} else {
					//logger.info("Not able to shared in twiter");
					fUtil.flogResult("Failed", "shared offer whatsapp", "Not able to shared", 1);
				}
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : shareOfferWhatsApp ", "Exception Caught : " + e.getMessage(),
					1);
		}
	}

	/*
	 * Function name : shareOfferEmail This function will share offer in Email input
	 * required: email id
	 */
	public void shareOfferEmail() throws Exception {
		try {
			boolean isEailIconPresent = gmethods.isElementVisible(MyOffersPage.get().clickEmailIcon, 15);
			if (isEailIconPresent == true) {
				boolean isEmailIconClickable = gmethods.isElementClickable(MyOffersPage.get().clickEmailIcon, 5);
				if (isEmailIconClickable) {
					MyOffersPage.get().clickEmailIcon.click();
				} else {
					//logger.info("Not able to shared in twiter");
					fUtil.flogResult("Failed", "shared offer twiter", "Not able to shared", 1);
				}
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : shareOfferEmail ", "Exception Caught : " + e.getMessage(),
					1);
		}
	}

	/*
	 * Function name : viewNearBy This function will display the near by store
	 * locations input required: email id
	 */
	public void viewNearBy() throws Exception {
		try {
			scrollToViewElement(MyOffersPage.get().clickNearByOption);
			boolean isNearByOptionPresent = gmethods.isElementVisible(MyOffersPage.get().clickNearByOption, 15);
			if (isNearByOptionPresent) {
				MyOffersPage.get().clickNearByOption.click();
				Thread.sleep(3000);
			}
			else
			{
				fUtil.flogResult("Failed", "store near me page displayed", "Store near me page not displayed" , 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Error in discovery page", "Exception Caught : " + e.getMessage(), 1);
			throw e;
		}
	}

	/*
	 * Function name : viewHeroBannerOffer This function will display the hero
	 * banner offer and click on it input required:
	 */
	public void viewHeroBannerOffer(WebElement offerId) throws Exception {
		try {
			boolean isHerobannerOfferArrowPresent = gmethods.isElementVisible(MyOffersPage.get().heroBannerofferClick,
					25);
			if (isHerobannerOfferArrowPresent == true) {
				// MyOffersPage.get().heroBannerofferClick.click();
				for (int i = 0; i <= MyOffersPage.get().herobannerOffers.size(); i++) {
					boolean isOfferBannerPresent = gmethods.isElementVisible(offerId, 10);
					if (isOfferBannerPresent) {
						offerId.click();
						//logger.info("Click on Herobanner Offer");
						fUtil.flogResult("Passed", "HeroBanner Offer Navigation", "Clicked on herobanner offer", 1);
						break;
					} else {
						MyOffersPage.get().heroBannerofferClick.click();
					}
				}

			} else {
				//logger.info("Click on Herobanner Offer");
				fUtil.flogResult("Failed", "HeroBanner Offer Navigation", "Not able to clicked on herobanner offer", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : viewHeroBannerOffer ",
					"Exception Caught : " + e.getMessage(), 1);
		}

	}

	/*
	 * Function name : openUsedOffers This function will redirect used offer tab
	 * input required:
	 */
	public void openUsedOffers() throws Exception {
		try {
			boolean isOfferTabPresent = gmethods.isElementVisible(MyOffersPage.get().offerTabClick, 10);
			if (isOfferTabPresent == true) {
				MyOffersPage.get().offerTabClick.click();
				boolean isoffer_count = gmethods.isElementVisible(MyOffersPage.get().countOffers, 30);
				MyOffersPage.get().clickUsedTab.click();
				//logger.info("Navigating to Used Offer Tab");
				fUtil.flogResult("Passed", "Used Offer Tab Click", "Used offer Tab displayed", 1);
			} else {
				//logger.info("Navigating to Used Offer Tab");
				fUtil.flogResult("Failed", "Used Offer Tab Click", "Not able to navigate", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : openUsedOffers ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : openActiveOffers This function will redirect active offer tab
	 * input required:
	 */
	public void openActiveOffers() throws Exception {
		try {

			boolean isOfferTabPresent = gmethods.isElementVisible(MyOffersPage.get().offerTabClick, 30);
			if (isOfferTabPresent == true) {
				boolean isOfferTabClickable = gmethods.isElementClickable(MyOffersPage.get().offerTabClick, 30);
				if (isOfferTabClickable) {
					MyOffersPage.get().offerTabClick.click();
					boolean isoffer_count = gmethods.isElementVisible(MyOffersPage.get().countOffers, 20);
					MyOffersPage.get().clickActiveButton.click();
					//logger.info("Navigating to Active Offer Tab");
					fUtil.flogResult("Passed", "Active Offer Tab Click", "Active Offer Displayed", 1);
				}
			} else {
				//logger.info("Navigating to Active Offer Tab");
				fUtil.flogResult("Failed", "Active Offer Tab Click", "Not able to navigate", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : openActiveOffers ", "Exception Caught : " + e.getMessage(),
					1);
		}
	}

	/*
	 * Function name : searchOfferUsingText This function will search offer using
	 * custom search input required:String text (Offer description)
	 */
	public void searchOfferUsingText(String text) throws Exception {
		try {
			boolean isTextBoxPresent = gmethods.isElementVisible(MyOffersPage.get().searchOfferTextBox, 15);
			if (isTextBoxPresent == true) {
				MyOffersPage.get().searchOfferTextBox.click();
				MyOffersPage.get().searchOfferTextBox.sendKeys(text);
				//logger.info("Search text entered");
				fUtil.flogResult("Passed", "Search Offer using text", "Offer search successful", 1);
			} else {
				//logger.info("Search text entered");
				fUtil.flogResult("Failed", "Search Offer using text", "Offer search Unsuccessful", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : searchOfferUsingText ",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : filterByBrand This function will search filter using Brand
	 * input required:String text (Offer description)
	 */
	public void filterByBrand(String brandName) throws Exception {
		try {
			boolean isFilterOptionPresent = gmethods.isElementVisible(MyOffersPage.get().filterByBrand, 15);
			if (isFilterOptionPresent == true) {
				MyOffersPage.get().filterByBrand.click();
				for (int i = 0; i <= MyOffersPage.get().brandNames.size(); i++) {
					String value = MyOffersPage.get().brandNames.get(i).getAttribute("value");
					System.out.println(value);
					if (value.equalsIgnoreCase(brandName)) {
						MyOffersPage.get().brandNames.get(i).click();
						MyOffersPage.get().applyButton.click();
						break;
					}

				}
				//logger.info("Filter By Brand");
				fUtil.flogResult("Passed", "Filter using Brand", "Brand filter selected", 1);
			} else {
				//logger.info("Filter By Brand");
				fUtil.flogResult("Failed", "Filter using Brand", "Brand filter not selected", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : filterByBrand ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : filterByCatagory This function will search filter using
	 * Category input required:String text (Offer description)
	 */
	public void filterByCatagory(String catagoryName) throws Exception {
		try {
			boolean isFilterOptionPresent = gmethods.isElementVisible(MyOffersPage.get().filterByCatagory, 15);
			if (isFilterOptionPresent == true) {
				MyOffersPage.get().filterByCatagory.click();
				for (int i = 0; i <= MyOffersPage.get().catagoryNames.size(); i++) {
					String value = MyOffersPage.get().catagoryNames.get(i).getAttribute("value");
					System.out.println(value);
					if (value.equalsIgnoreCase(catagoryName)) {
						MyOffersPage.get().catagoryNames.get(i).click();
						MyOffersPage.get().applyButton.click();
						break;
					}

				}
				//logger.info("Filter By Catagory");
				fUtil.flogResult("Passed", "Filter using Catagory", "Catagory filter selected", 1);
			} else {
				//logger.info("Filter By Brand");
				fUtil.flogResult("Failed", "Filter using Brand", "Brand filter not selected", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : filterByCatagory ", "Exception Caught : " + e.getMessage(),
					1);
		}
	}

	/*
	 * Function name : viewNearBy This function will locate nearby stores for mobile
	 * input required:Mobile elements are present in MyOffers_Mobile class
	 */
	public void viewNearBy(MobileElement nearByIcon, MobileElement noOfStore) throws Exception {
		try {
			boolean isNearByOptionPresent = gmethods.isElementVisible_mobile(nearByIcon, 15);
			if (isNearByOptionPresent == true) {
				nearByIcon.click();
				boolean isStoreResultDisplayed = gmethods.isElementVisible_mobile(noOfStore, 15);
				if (isStoreResultDisplayed == true) {
					//logger.info("View Nearby Stores");
					fUtil.flogResult("Passed", "View nearby store", "Near by store details are displayed", 1);
				} else {
					//logger.info("View Nearby Stores");
					fUtil.flogResult("Failed", "View nearby store", "Near by store details are not displayed", 1);
				}

			} else {
				//logger.info("View Nearby Stores");
				fUtil.flogResult("Failed", "View nearby store", "Near by store details are not displayed", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : viewNearBy ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * Function name : VerifyDirection This function will verify the direction CTA
	 * and click on it in mobile input required:Mobile elements are present in
	 * MyOffers_Mobile class
	 */
	public void verifyDirection(MobileElement directionCTA, MobileElement nearByIcon, MobileElement noOfStore)
			throws Exception {
		try {
			boolean isDirectionCTADisplayed = gmethods.isElementVisible_mobile(directionCTA, 15);
			if (isDirectionCTADisplayed == true) {
				directionCTA.click();
				//logger.info("Direction CTA displyed");
				fUtil.flogResult("Passed", "Direction CTA displyed", "Direction CTA displyed", 1);
			} else {
				//logger.info("Direction CTA displyed");
				fUtil.flogResult("Failed", "Direction CTA displyed", "Direction CTA not displyed", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : verifyDirection ", "Exception Caught : " + e.getMessage(),
					1);
		}

	}

	/*
	 * Function name : VerifyDirection This function will verify the direction CTA
	 * in pwa and click on it input required:
	 */
	public void verifyDirection() throws Exception {
		// gmethods.viewNearBy();
		try {
			boolean isDirectionCTADisplayed = gmethods.isElementVisible(MyOffersPage.get().directionCTA, 15);
			if (isDirectionCTADisplayed == true) {
				MyOffersPage.get().directionCTA.click();
				Thread.sleep(5000);
				gmethods.switchToNewTab();
				boolean isDirectionStartingPoint = gmethods.isElementVisible(MyOffersPage.get().directionStartingPoint,
						15);
				String startingAddress = MyOffersPage.get().directionStartingPoint.getText();
				if (isDirectionStartingPoint == true && !startingAddress.isEmpty())
					//logger.info("Direction CTA Verified");
				fUtil.flogResult("Passed", "Google Map Displayed", "Google Map Displayed", 1);
			} else {
				//logger.info("Direction CTA not Verified");
				fUtil.flogResult("Failed", "Google Map Displayed", "Google Map not Displayed", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : Click on direction", "Exception Caught : " + e.getMessage(),
					1);
		}

	}

	/*
	 * Function name : verifyCall This function will verify the call option and
	 * click on it input required:
	 */
	public void verifyCall(MobileElement callDialer, MobileElement nearByIcon, MobileElement noOfStore)
			throws Exception {
		try {
			gmethods.viewNearBy(nearByIcon, noOfStore);
			boolean isDialerDisplayed = gmethods.isElementVisible(callDialer, 15);
			if (isDialerDisplayed == true) {
				callDialer.click();
				//logger.info("Click on Call");
				fUtil.flogResult("Passed", "Call Option Displayed", "Call Option Displayed", 1);
			} else {
				//logger.info("Click on Call");
				fUtil.flogResult("Failed", "Call Option Displayed", "Call Option not Displayed", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : shareOfferWhatsApp ", "Exception Caught : " + e.getMessage(),
					1);
		}

	}
	// 74 code ends here//

	/**
	 * Function Name: goto_TCPCard Function will navigate to TCP Card page from
	 * Vault page Input Required: MobileElement viewDetailsCTA - android/ios
	 * Parameter taken from class : TDL_VaultPage_Mobile Parameter details :
	 * cardName - cardName_TCP_android/cardName_TCP_ios, viewDetailsCTA -
	 * viewDetailsCTA_android/viewDetailsCTA_ios
	 */
	public void goto_TCPCard(MobileElement cardName, MobileElement viewDetailsCTA) throws Exception {

		try {
			boolean tcpCardVisibility = gmethods.isElementVisible_mobile(viewDetailsCTA, 20);
			if (tcpCardVisibility == true) {
				//logger.info("TCP card is visible");
				fUtil.flogResult("Passed", "Visibility of Card", "TCP card is visible", 1);

				boolean tcpCardViewDetailsVisibility = gmethods.isElementVisible_mobile(viewDetailsCTA, 10);
				if (tcpCardViewDetailsVisibility == true) {
					//logger.info("Clicking on View Details CTA");
					viewDetailsCTA.click();
					//logger.info("Clicked View Details CTA");
					fUtil.flogResult("Passed", "Click on View Details of TCP Card",
							"Successfully clicked on View Details CTA and navigated to TCP card view page", 1);
				} else {

					//logger.error("View Details not visible and card name also not tappable");
					fUtil.flogResult("Failed", "Visibility of view details",
							"view details is not visible and card name also not tappable", 1);
				}

				// cardName.click();
				// fUtil.flogResult("Passed", "navigate tcp card", "navigated to tcp card", 1);
			} else {
				//logger.error("TCP card not visible");
				fUtil.flogResult("Failed", "Visibility of Card", "TCP card is not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : goto_TCPCard ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/**
	 * Function Name: goto_TCPCard Function will navigate to TCP Card page from
	 * Vault page for pwa Input required: none
	 */
	public void goto_TCPCard() throws Exception {

		try {
			boolean tcpCardVisibility = gmethods.isElementVisible(TdlVaultPage.get().cardName_TCP, 10);
			if (tcpCardVisibility == true) {
				gmethods.highlightElement(TdlVaultPage.get().cardName_TCP);
				//logger.info("TCP card is visible");
				fUtil.flogResult("Passed", "Visibility of Card", "TCP card is visible", 1);
				boolean tcpCardViewDetailsVisibility = gmethods.isElementVisible(TdlVaultPage.get().viewDetailsCTA_TCP,
						10);
				if (tcpCardViewDetailsVisibility == true) {
					gmethods.highlightElement(TdlVaultPage.get().viewDetailsCTA_TCP);
					//logger.info("View Details CTA is visible");
					fUtil.flogResult("Passed", "Visibility of View Details CTA", "View Details CTA is visible", 1);
					// Thread.sleep(1000);
					//logger.info("Clicking on View Details CTA");
					TdlVaultPage.get().viewDetailsCTA_TCP.click();
					//logger.info("Clicked View Details CTA");
					fUtil.flogResult("Passed", "Click on View Details of TCP Card",
							"Successfully clicked on View Details CTA and navigated to TCP card view page", 1);
				} else {
					//logger.error("view details not visible");
					fUtil.flogResult("Failed", "Visibility of view details", "view details is not visible", 1);
				}
			} else {
				//logger.error("TCP card not visible");
				fUtil.flogResult("Failed", "Visibility of Card", "TCP card is not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : goto_TCPCard ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/**
	 * Function Name: validate_TCPCard Function will validate if inside TCP Card
	 * page Input Required: MobileElement cardName - android/ios Parameter taken
	 * from class : TDL_TCPCardPage_Mobile Parameter details : cardName -
	 * cardNameText_TCP_android/cardNameText_TCP_ios
	 */
	public void validate_TCPCard(MobileElement cardName) throws Exception {

		try {
			boolean insideTCPCardPage = gmethods.isElementVisible_mobile(cardName, 40);
			if (insideTCPCardPage == true) {
				//logger.info("Inside TCP Card Page");
				fUtil.flogResult("Passed", "Verify if navigated to TCP Card page", "Inside TCP Card Page", 1);
			} else {
				//logger.error("Navigation to TCP Card page failed");
				fUtil.flogResult("Failed", "Verify if navigated to TCP Card page", "Navigation to TCP Card page failed",
						1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validate_TCPCard ", "Exception Caught : " + e.getMessage(),
					1);
		}

	}

	/**
	 * Function Name: validate_TCPCard Function will validate if inside TCP Card
	 * page for pwa Input required: none Author:Shanjana
	 */
	public void validate_TCPCard() throws Exception {

		try {
			boolean insideTCPCardPage = gmethods.isElementVisible(TdlTcpCard.get().cardNameText_TCP, 10);
			if (insideTCPCardPage == true) {
				gmethods.highlightElement(TdlTcpCard.get().cardNameText_TCP);
				//logger.info("Inside TCP Card Page");
				fUtil.flogResult("Passed", "Verify if navigated to TCP Card page", "Inside TCP Card Page", 1);
			} else {
				//logger.error("Navigation to TCP Card page failed");
				fUtil.flogResult("Failed", "Verify if navigated to TCP Card page", "Navigation to TCP Card page failed",
						1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validate_TCPCard ", "Exception Caught : " + e.getMessage(),
					1);
		}
	}

	/**
	 * Function Name: navigatebackto_Vault Function will navigate back to Vault page
	 * from Tcp/Brand Card page Input Required: MobileElement closeBtn - android/ios
	 * Parameter taken from class : take whichever card page you are working on For
	 * TCP card - TDL_TCPCardPage_Mobile For Croma card - TDL_CromaCardPage_Mobile
	 * For IHCL card: TDL_IHCLCardPage_Mobile Parameter details : take whichever
	 * card element you are working on For TCP card: cardName -
	 * closeBtn_TCP_android/closeBtn_TCP_ios For Croma Card: cardName -
	 * closeBtn_Croma_android/closeBtn_Croma_ios For IHCL card:
	 * closeBtn_IHCL_android/closeBtn_IHCL_ios
	 */
	public void navigatebackto_Vault(MobileElement closeBtn) throws Exception {

		try {
			boolean closeBtnVisibility = gmethods.isElementVisible_mobile(closeBtn, 10);
			if (closeBtnVisibility == true) {
				//logger.info("Clicking on Close button");
				closeBtn.click();
				//logger.info("Clicked Close button");
				fUtil.flogResult("Passed", "Click on Close button",
						"Successfully clicked on Close button and navigated back to vault page", 1);
			} else {
				//logger.error("Close button not visible");
				fUtil.flogResult("Failed", "Visibility of Close button", "Close button is not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : navigatebackto_Vault ",
					"Exception Caught : " + e.getMessage(), 1);
		}

	}

	/**
	 * Function Name: navigatebackto_Vault Function will navigate back to Vault page
	 * from Tcp/Brand Card page Input Required: WebElement closeBtn Parameter taken
	 * from class : take whichever card page you are working on For TCP card:
	 * TDL_TCPCardPage For Croma Card: TDL_CromaCardPage For IHCL Card:
	 * TDL_IHCLCardPage Parameter details : take whichever card element you are
	 * working on For TCP card: cardName - closeBtn_TCP For Croma Card: cardName -
	 * closeBtn_Croma For IHCL Card: closeBtn_IHCL
	 */
	public void navigatebackto_Vault(WebElement closeBtn) throws Exception {

		try {
			boolean closeBtnVisibility = gmethods.isElementVisible(closeBtn, 10);
			if (closeBtnVisibility == true) {
				gmethods.highlightElement(closeBtn);
				//logger.info("Close button is visible");
				fUtil.flogResult("Passed", "Visibility of Close button", "Close button is visible", 1);
				closeBtn.click();
				//logger.info("Clicked Close button");
				if (gmethods.isElementVisible(TdlVaultPage.get().vaultBtn, 10)) {
					gmethods.highlightElement(TdlVaultPage.get().vaultBtn);
					System.out.println("Navigated back to vault successfully");
					fUtil.flogResult("Passed", "Click on Close button",
							"Successfully clicked on Close button and navigated back to vault page", 1);
				} else {
					//logger.error("Navigation to Vault failed after clicking on close button");
					fUtil.flogResult("Failed", "Navigation back to vault",
							"Navigation to Vault failed after clicking on close button", 1);
				}
			} else {
				//logger.error("Close button not visible");
				fUtil.flogResult("Failed", "Visibility of Close button", "Close button is not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : navigatebackto_Vault ",
					"Exception Caught : " + e.getMessage(), 1);
		}

	}

	/**
	 * Function Name: goto_CromaCard Function will navigate to Croma Card page from
	 * Vault page Input Required: MobileElement cardName, MobileElement
	 * viewDetailsCTA - android/ios Parameter taken from class :
	 * TDL_VaultPage_Mobile Parameter details : cardName -
	 * cardName_Croma_android/cardName_Croma_ios, viewDetailsCTA -
	 * viewDetailsCTA_android/viewDetailsCTA_ios
	 */
	public void goto_CromaCard(MobileElement cardName, MobileElement viewDetailsCTA) throws Exception {

		try {
			boolean tcpCardVisibility = gmethods.isElementVisible_mobile(cardName, 20);
			if (tcpCardVisibility == true) {
				//logger.info("Croma card is visible");
				fUtil.flogResult("Passed", "Visibility of Card", "Croma card is visible", 1);
				//logger.info("Croma card selected");
				cardName.click();
				fUtil.flogResult("Passed", "Is Croma card selected", "Croma card selected", 1);
				boolean cromaCardViewDetailsVisibility = gmethods.isElementVisible_mobile(viewDetailsCTA, 20);
				if (cromaCardViewDetailsVisibility == true) {
					//logger.info("Clicking on View Details CTA");
					viewDetailsCTA.click();
					//logger.info("Clicked View Details CTA");
					fUtil.flogResult("Passed", "Click on View Details of Croma Card",
							"Successfully clicked on View Details CTA and navigated to Croma card view page", 1);
				}

			} else {
				//logger.error("Croma card not visible");
				fUtil.flogResult("Failed", "Visibility of Card", "Croma card is not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : goto_CromaCard ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/**
	 * Function Name: goto_CromaCard Function will navigate to Croma Card page from
	 * Vault page for pwa Input required: none
	 */
	public void goto_CromaCard() throws Exception {

		try {
			boolean tcpCardVisibility = gmethods.isElementVisible(TdlVaultPage.get().cardName_Croma, 10);
			if (tcpCardVisibility == true) {
				//logger.info("Croma card is visible");
				fUtil.flogResult("Passed", "Visibility of Card", "Croma card is visible", 1);
				gmethods.highlightElement(TdlVaultPage.get().cardName_Croma);
				TdlVaultPage.get().cardName_Croma.click();
				//logger.info("Croma card selected");
				fUtil.flogResult("Passed", "Is Croma card selected", "Croma card selected", 1);
				boolean tcpCardViewDetailsVisibility = gmethods
						.isElementVisible(TdlVaultPage.get().viewDetailsCTA_Croma, 10);
				if (tcpCardViewDetailsVisibility == true) {
					gmethods.highlightElement(TdlVaultPage.get().viewDetailsCTA_Croma);
					//logger.info("View Details CTA is visible");
					fUtil.flogResult("Passed", "Visibility of View Details CTA", "View Details CTA is visible", 1);
					// Thread.sleep(1000);
					//logger.info("Clicking on View Details CTA");
					TdlVaultPage.get().viewDetailsCTA_Croma.click();
					//logger.info("Clicked View Details CTA");
					fUtil.flogResult("Passed", "Click on View Details of Croma Card",
							"Successfully clicked on View Details CTA and navigated to Croma card view page", 1);
				} else {
					//logger.error("view details not visible");
					fUtil.flogResult("Failed", "Visibility of view details", "view details is not visible", 1);
				}
			} else {
				//logger.error("Croma card not visible");
				fUtil.flogResult("Failed", "Visibility of Card", "Croma card is not visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : goto_CromaCard ", "Exception Caught : " + e.getMessage(), 1);
		}
	}

	/**
	 * Function Name: validate_CromaCard Function will validate if inside Croma Card
	 * page Input Required: MobileElement cardName - android/ios Parameter taken
	 * from class : TDL_CromaCardPage_Mobile Parameter details : cardName -
	 * cardNameText_Croma_android/cardNameText_Croma_ios
	 */
	public void validate_CromaCard(MobileElement cardName) throws Exception {

		try {
			boolean insideCromaCardPage = gmethods.isElementVisible_mobile(cardName, 10);
			if (insideCromaCardPage == true) {
				//logger.info("Inside Croma Card Page");
				fUtil.flogResult("Passed", "Verify if navigated to Croma Card page", "Inside Croma Card Page", 1);
			} else {
				//logger.error("Navigation to Croma Card page failed");
				fUtil.flogResult("Failed", "Verify if navigated to Croma Card page",
						"Navigation to Croma Card page failed", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validate_CromaCard ", "Exception Caught : " + e.getMessage(),
					0);
			e.printStackTrace();
		}

	}

	/**
	 * Function Name: validate_CromaCard Function will validate if inside Croma Card
	 * page for pwa Input required: none
	 */
	public void validate_CromaCard() {

		try {

			boolean insideCromaCardPage = gmethods.isElementVisible(TdlCromaCard.get().cardNameText_Croma, 20);
			gmethods.highlightElement(TdlCromaCard.get().cardNameText_Croma);
			if (insideCromaCardPage == true) {
				//logger.info("Inside Croma Card Page");
				fUtil.flogResult("Passed", "Verify if navigated to Croma Card page", "Inside Croma Card Page", 1);
			} else {
				//logger.error("Navigation to Croma Card page failed");
				fUtil.flogResult("Failed", "Verify if navigated to Croma Card page",
						"Navigation to Croma Card page failed", 1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Function Name: goto_IHCLCard Function will navigate to IHCL Card page from
	 * Vault page Input Required: MobileElement viewDetailsCTA - android/ios
	 * Parameter taken from class : TDL_VaultPage_Mobile Parameter details :
	 * cardName - cardName_IHCL_android/cardName_IHCL_ios, viewDetailsCTA -
	 * viewDetailsCTA_android/viewDetailsCTA_ios
	 */
	public void goto_IHCLCard(MobileElement cardName, MobileElement viewDetailsCTA) {

		try {
			boolean tcpCardVisibility = gmethods.isElementVisible_mobile(cardName, 10);
			if (tcpCardVisibility == true) {
				//logger.info("IHCL card is visible");
				fUtil.flogResult("Passed", "Visibility of Card", "IHCL card is visible", 1);
				cardName.click();
				//logger.info("IHCL card selected");
				fUtil.flogResult("Passed", "Is IHCL card selected", "IHCL card selected", 1);
				boolean tcpCardViewDetailsVisibility = gmethods.isElementVisible_mobile(viewDetailsCTA, 10);
				if (tcpCardViewDetailsVisibility == true) {
					//logger.info("Clicking on View Details CTA");
					viewDetailsCTA.click();
					//logger.info("Clicked View Details CTA");
					fUtil.flogResult("Passed", "Click on View Details of IHCL Card",
							"Successfully clicked on View Details CTA and navigated to IHCL card view page", 1);
				} else {
					//logger.error("view details not visible");
					fUtil.flogResult("Failed", "Visibility of view details", "view details is not visible", 1);
				}
			} else {
				//logger.error("IHCL card not visible");
				fUtil.flogResult("Failed", "Visibility of Card", "IHCL card is not visible", 1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Function Name: goto_IHCLCard Function will navigate to IHCL Card page from
	 * Vault page for pwa Input Required: None
	 */
	public void goto_IHCLCard() {

		try {
			boolean tcpCardVisibility = gmethods.isElementVisible(TdlVaultPage.get().cardName_IHCL, 10);
			if (tcpCardVisibility == true) {
				//logger.info("IHCL card is visible");
				fUtil.flogResult("Passed", "Visibility of Card", "IHCL card is visible", 1);
				gmethods.highlightElement(TdlVaultPage.get().cardName_IHCL);
				//logger.info("IHCL card selected");
				fUtil.flogResult("Passed", "Is IHCL card selected", "IHCL card selected", 1);
				boolean tcpCardViewDetailsVisibility = gmethods.isElementVisible(TdlVaultPage.get().viewDetailsCTA_IHCL,
						10);
				if (tcpCardViewDetailsVisibility == true) {
					gmethods.highlightElement(TdlVaultPage.get().viewDetailsCTA_IHCL);
					//logger.info("View Details CTA is visible");
					fUtil.flogResult("Passed", "Visibility of View Details CTA", "View Details CTA is visible", 1);
					Thread.sleep(1000);
					//logger.info("Clicking on View Details CTA");
					TdlVaultPage.get().viewDetailsCTA_IHCL.click();
					//logger.info("Clicked View Details CTA");
					fUtil.flogResult("Passed", "Click on View Details of IHCL Card",
							"Successfully clicked on View Details CTA", 1);
				} else {
					//logger.error("view details not visible");
					fUtil.flogResult("Failed", "Visibility of view details", "view details is not visible", 1);
				}
			} else {
				//logger.error("IHCL card not visible");
				fUtil.flogResult("Failed", "Visibility of Card", "IHCL card is not visible", 1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * Function Name: validate_IHCLCard Function will validate if inside IHCL Card
	 * page Input Required: MobileElement cardName - android/ios Parameter taken
	 * from class : TDL_IHCLCardPage_Mobile Parameter details : cardName -
	 * cardNameText_IHCL_android/cardNameText_IHCL_ios
	 */
	public void validate_IHCLCard(MobileElement cardName) {

		try {
			boolean insideCromaCardPage = gmethods.isElementVisible_mobile(cardName, 10);
			if (insideCromaCardPage == true) {
				//logger.info("Inside IHCL Card Page");
				fUtil.flogResult("Passed", "Verify if navigated to IHCL Card page", "Inside IHCL Card Page", 1);
			} else {
				//logger.error("Navigation to IHCL Card page failed");
				fUtil.flogResult("Failed", "Verify if navigated to IHCL Card page",
						"Navigation to IHCL Card page failed", 1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Function Name: validate_IHCLCard Function will validate if inside IHCL Card
	 * page for pwa
	 */
	public void validate_IHCLCard() {

		try {
			boolean insideCromaCardPage = gmethods.isElementVisible(TdlIhclCard.get().cardNameText_IHCL, 10);
			if (insideCromaCardPage == true) {
				gmethods.highlightElement(TdlIhclCard.get().cardNameText_IHCL);
				//logger.info("Inside IHCL Card Page");
				fUtil.flogResult("Passed", "Verify if navigated to IHCL Card page", "Inside IHCL Card Page", 1);
			} else {
				//logger.error("Navigation to IHCL Card page failed");
				fUtil.flogResult("Failed", "Verify if navigated to IHCL Card page",
						"Navigation to IHCL Card page failed", 1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Function Name: click_ShopNowCTA Function will validate if inside Brand Card
	 * page Input Required: MobileElement shopNowCTA - android/ios Parameter taken
	 * from class : take whichever card page you are working on For Croma Card:
	 * TDL_CromaCardPage_Mobile Parameter details : take whichever card element you
	 * are working on For Croma Card: cardName -
	 * shopNowCTA_Croma_android/shopNowCTA_Croma_ios
	 */
	public void click_ShopNowCTA(MobileElement shopNowCTA) {

		try {
			boolean shopNowCTAVisibility = gmethods.isElementVisible_mobile(shopNowCTA, 10);
			if (shopNowCTAVisibility == true) {
				//logger.info("Shop Now CTA is visible");
				fUtil.flogResult("Passed", "Show Now CTA visibilty", "Shop Now CTA is visible", 1);
				shopNowCTA.click();
				//logger.info("Clicked on Shop Now CTA");
				fUtil.flogResult("Passed", "Shop now button clicking validation",
						"Shop Now button is Clicked successfully!", 1);
			} else {
				//logger.error("Shop Now CTA is not visible");
				fUtil.flogResult("Failed", "Show Now CTA visibilt", "Shop Now CTA is not visible", 1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Function Name: click_ShopNowCTA Function will validate if inside Brand Card
	 * page Input Required: WebElement shopNowCTA - pwa Parameter taken from class :
	 * take whichever card page you are working on For Croma Card: TDL_CromaCardPage
	 * Parameter details : take whichever card element you are working on For Croma
	 * Card: cardName - shopNowCTA_Croma
	 */
	public void click_ShopNowCTA(WebElement shopNowCTA) {

		try {
			boolean shopNowCTAVisibility = gmethods.isElementVisible(shopNowCTA, 10);
			if (shopNowCTAVisibility == true) {
				gmethods.highlightElement(shopNowCTA);
				//logger.info("Shop Now CTA is visible");
				fUtil.flogResult("Passed", "Shop Now CTA visibility", "Shop Now CTA is visible", 1);
				Thread.sleep(1000);
				shopNowCTA.click();
				//logger.info("Clicked on Shop Now CTA");
				fUtil.flogResult("Passed", "Shop now button clicking validation",
						"Shop Now button is Clicked successfully!", 1);
			} else {
				//logger.error("Shop Now CTA is not visible");
				fUtil.flogResult("Failed", "Shop Now CTA visibility", "Shop Now CTA is not visible", 1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Function Name: verifyHerobannerOffer Function will validate herobanner offer
	 * and click on it in mobile Input Required: MobileElement - heroBannerMain
	 */
	public void viewHerobannerOffer(MobileElement heroBannerMain) {

		try {
			boolean isHeroBannerMainVisible = gmethods.isElementVisible_mobile(heroBannerMain, 30);
			if (isHeroBannerMainVisible == true) {
				boolean isshopNowCTAPresent = gmethods.isElementVisible_mobile(MyOffers_Mobile.get().andShopNow, 20);
				if (isshopNowCTAPresent) {
					MyOffers_Mobile.get().andShopNow.click();
					//logger.info("Herobanner Present");
					fUtil.flogResult("Passed", "Verify if herobanner offer is present", "Hero banner offer present", 1);
				}
			} else {
				//logger.error("Herobanner not Present");
				fUtil.flogResult("Failed", "Verify if herobanner offer is present",
						"Verify if herobanner offer is present", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function Name: clickAddtoVaultWeb Function will collect offer and add it to
	 * vault Input Required: WebElement addtoVault - pwa present in OfferDetailsPage
	 */
	public void clickAddtoVaultWeb(WebElement addtoVault) throws Exception {
		try {
			//logger.info("Verifying if AddtoVault CTA is visible");
			boolean AddtoVaultCTAVisibleFlag = gmethods.isElementVisible(addtoVault, 10);
			if (AddtoVaultCTAVisibleFlag == true) {
				addtoVault.click();
				//logger.info("Clicked on AddtoVault");
				fUtil.flogResult("Passed", "Click on AddtoVault", "Click on AddtoVault", 1);
			} else {
				//logger.error("Click on AddtoVault is unsuccessful");
				fUtil.flogResult("Failed", "Click on AddtoVault Failed", "Click on AddtoVault Failed", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function Name: clickAddtoVault Function will collect offer and add it to
	 * vault Input Required: WebElement addtoVault - mobile present in
	 * MyOffers_Mobile class
	 */
	public void clickAddtoVault(MobileElement addtoVault) throws Exception {
		try {
			//logger.info("Verifying if AddtoVault CTA is visible");
			boolean AddtoVaultCTAVisibleFlag = gmethods.isElementVisible_mobile(addtoVault, 10);
			if (AddtoVaultCTAVisibleFlag == true) {
				addtoVault.click();
				//logger.info("Clicked on AddtoVault");
				fUtil.flogResult("Passed", "Click on AddtoVault", "Click on AddtoVault", 1);
			} else {
				//logger.error("Click on AddtoVault is unsuccessful");
				fUtil.flogResult("Failed", "Click on AddtoVault Failed", "Click on AddtoVault Failed", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function Name: Function will open active offers in mobile Input Required:
	 * WebElement offerTab & activeTab- mobile present in MyOffers_Mobile class
	 */
	public void openActiveOffers(MobileElement offerTab, MobileElement activeTab) throws Exception {
		try {
			boolean offerTabVisibleFlag = gmethods.isElementVisible_mobile(offerTab, 10);
			if (offerTabVisibleFlag) {
				offerTab.click();
				boolean activeTabVisible = gmethods.isElementVisible_mobile(activeTab, 30);
				activeTab.click();
				//logger.info("Open Active Offer");
				fUtil.flogResult("Passed", "Validate the click on add to Active", "Output is correct", 1);

			} else {
				//logger.info("Open Active Offer unsuccessful");
				fUtil.flogResult("Failed", "Validate the click on add to Active", "Output is not correct", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function Name: openUsedOffers Function will open used offers in mobile Input
	 * Required: WebElement offerTab & activeTab- mobile present in MyOffers_Mobile
	 * class
	 */
	public void openUsedOffers(MobileElement offerTab, MobileElement usedTab) throws Exception {
		try {
			boolean offerTabVisibleFlag = gmethods.isElementVisible_mobile(offerTab, 10);
			if (offerTabVisibleFlag) {
				offerTab.click();
				boolean usedTabVisible = gmethods.isElementVisible_mobile(usedTab, 30);
				usedTab.click();
				//logger.info("Open Used Offer");
				fUtil.flogResult("Passed", "Open used offer", "Output is correct", 1);

			} else {
				//logger.info("Open used Offer unsuccessful");
				fUtil.flogResult("Failed", "Used offer", "used Offers validation failed ", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : gotoVaultPwa This function will click on vault on PWA TCP App
	 * Input required : NA
	 */

	public void gotoVaultPwa() throws Exception {

		try {
			boolean vaulticon = gmethods.isElementPresent(TdlHomePage.get().vaultLink);

			if (vaulticon) {
				//logger.info("Homepage loaded and vault icon visible");
				fUtil.flogResult("Passed", "Homepage Validation", "Homepage loaded properly", 1);
				TdlHomePage.get().vaultLink.click();
				isElementVisibleXpath(
						"//*[contains(text(),'PAYMENT METHODS')]/parent::div/parent::div/following-sibling::div/div[1]/div",
						15);
			} else {
				//logger.error("Homepage not loaded properly");
				fUtil.flogResult("Failed", "Homepage Validation", "Homepage not loaded properly", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : gotovaultPWA This function will Validate the vault button is
	 * present in Homepage, Click on Vault button and verify user land on vault
	 * page. Input Required : NA
	 * 
	 */
	public void gotovaultPWA() throws Exception {
		try {
			boolean vaultBtn = isElementVisible(TdlHomePage.get().vaultLink, 20);
			if (vaultBtn == true) {
				//logger.info("Vault button present in Home Page");
				fUtil.flogResult("Passed", "Vault button presence", "Vault button present in Home Page", 1);
				TdlHomePage.get().vaultLink.click();
				boolean payTab = isElementVisible(TdlVaultPage.get().offersTab, 10);
				if (payTab == true) {
					//logger.info("Pay tab present in vault page");
					fUtil.flogResult("Passed", "Pay tab presence", "Pay tab present in vault page", 1);
				} else {
					//logger.error("Pay tab not present in vault page");
					fUtil.flogResult("Failed", "Pay tab presence", "Pay tab not present in vault page", 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : gotomyaccountPWA This function will Validate the My account
	 * icon is present in Homepage, Click on My account icon and verify sidebar is
	 * expanded. Input Required : NA
	 * 
	 */
	public void gotomyaccountPWA() throws Exception {
		try {
			boolean myaccount = isElementVisible(TdlHomePage.get().myAccountIcon, 30);
			if (myaccount == true) {
				//logger.info("My account icon present in Home Page");
				fUtil.flogResult("Passed", "My account icon presence", "My account icon present in Home Page", 1);
				System.out.println("clicked");
				TdlHomePage.get().myAccountIcon.click();
				boolean sidebarExpanded = isElementVisible(TdlAccountListPage.get().profileOpt, 15);
				if (sidebarExpanded == true) {
					//logger.info("Sidebar expanded on account list page\n");
					fUtil.flogResult("Passed", "Sidebar expanded", "Sidebar expanded on account list page", 1);
				} else {
					//logger.error("Sidebar not expanded on account list page");
					fUtil.flogResult("Failed", "Sidebar expanded", "Sidebar not expanded on account list page", 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : gotosearchpagePWA This function will Validate the search Icon
	 * is present in Homepage, Click on search Icon and verify User land on offer
	 * page. Input Required : NA
	 * 
	 */
	public void gotosearchpagePWA() throws Exception {
		try {
			boolean searchIcon = isElementPresent(TdlHomePage.get().searchIcon);
			if (searchIcon == true) {
				//logger.info("Search Icon present in Home Page\n");
				fUtil.flogResult("Passed", "Search Icon presence", "Search Icon present in Home Page", 1);

				TdlHomePage.get().searchIcon.click();
				boolean searchTextbox = isElementVisible(TdlSearchPage.get().searchHeader, 10);
				if (searchTextbox == true) {
					//logger.info("Search textbox present in search page\n");
					fUtil.flogResult("Passed", "Search textbox presence", "Search textbox present in search page", 1);
				} else {
					//logger.error("Search textbox not present in search page");
					fUtil.flogResult("Failed", "Search textbox presence", "Search textbox not present in search page",
							1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : gotosecurityPWA This function will Validate security option
	 * is present in account list, Click on security option and verify security
	 * option is expanded. Input Required : NA
	 * 
	 */
	public void gotosecurityPWA() throws Exception {
		try {
			boolean securityOpt = isElementPresent(TdlAccountListPage.get().securityOpt);
			if (securityOpt == true) {
				//logger.info("Security option present in accountList Page\n");
				fUtil.flogResult("Passed", "Security option presence", "Security option present in accountList Page\\n",
						1);

				TdlAccountListPage.get().securityOpt.click();
				boolean SignOutOfAllDevicesLinkedApps = isElementVisible(
						TdlAccountListPage.get().SignOutOfAllDevicesLinkedApps, 10);
				if (SignOutOfAllDevicesLinkedApps == true) {
					//logger.info("Security option is expanded");
					fUtil.flogResult("Passed", "SignOutOfAllDevicesLinkedApps presence", "Security option is expanded",
							1);
				} else {
					//logger.error("Security option is expanded");
					fUtil.flogResult("Failed", "SignOutOfAllDevicesLinkedApps presence",
							"Security option is not expanded", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : signoutallaccountPWA This function will Validate
	 * SignOutOfAllDevicesLinkedApps option is present in account list, Click on
	 * SignOutOfAllDevicesLinkedApps option and verify user able to land on login
	 * page. Input Required : NA
	 * 
	 */
	public void signoutallaccountPWA() throws Exception {
		try {
			boolean signOutOfAllDevicesLinkedApps = isElementPresent(
					TdlAccountListPage.get().SignOutOfAllDevicesLinkedApps);
			if (signOutOfAllDevicesLinkedApps == true) {
				//logger.info("SignOutOfAllDevicesLinkedApps option present in accountlist Page\n");
				fUtil.flogResult("Passed", "SignOutOfAllDevicesLinkedApps option presence",
						"SignOutOfAllDevicesLinkedApps option present in accountlist Page", 1);

				TdlAccountListPage.get().SignOutOfAllDevicesLinkedApps.click();
				TdlAccountListPage.get().yesbtn.click();
				boolean signInBtn = isElementVisible(TdlSignUp.get().signinButton, 10);
				if (signInBtn == true) {
					//logger.info("SignIn button present");
					fUtil.flogResult("Passed", "SignIn button presence", "SignIn button present", 1);
				} else {
					//logger.error("SignIn Btn not presen");
					fUtil.flogResult("Failed", "SignIn button presence", "SignIn button not present", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : gotovaultAndroid This function will Validate the vault button
	 * is present in Homepage, Click on Vault button and verify user land on vault
	 * page. Input Required : NA
	 * 
	 */
	public void gotovaultAndroid() throws Exception {
		try {
			boolean vaultBtn = isElementPresent(TdlHomeMobile.get().vaultButton_android);
			if (vaultBtn == true) {
				//logger.info("Vault button present in Home Page\n");
				fUtil.flogResult("Passed", "Vault button presence", "Vault button present in Home Page", 1);

				TdlHomeMobile.get().vaultButton_android.click();
				boolean cardTab = isElementVisible(TdlVaultMobile.get().cardTab_android, 10);
				if (cardTab == true) {
					//logger.info("Card tab present in vault page\n");
					fUtil.flogResult("Passed", "Card tab presence", "Card tab present in vault page", 1);
				} else {
					//logger.error("Card tab not present in vault page");
					fUtil.flogResult("Failed", "Card tab presence", "Card tab not present in vault page", 1);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/*
	 * Function name : gotomyaccountAndroid This function will Validate the profile
	 * pic CTA is present in Homepage, Click on profile pic CTA and verify user land
	 * on account list page. Input Required : NA
	 * 
	 */
	public void gotomyaccountAndroid() throws Exception {
		try {
			boolean myaccounticon = isElementVisible_mobile(TdlHomeMobile.get().profileButton_android, 10);

			if (myaccounticon == true) {
				//logger.info("My account icon present in Home Page\n");
				fUtil.flogResult("Passed", "My account icon presence", "My account icon present in Home Page", 1);

				TdlHomeMobile.get().profileButton_android.click();
				boolean profileOption = isElementVisible_mobile(TdlAccountListPage_Mobile.get().profileOpt_android, 10);
				if (profileOption == true) {
					//logger.info("Profile option present in account list page\n");
					fUtil.flogResult("Passed", "Profile option presence",
							"Profile option present in account list page\\n", 1);
				} else {
					//logger.error("Profile option not present in account list page\\n");
					fUtil.flogResult("Failed", "Profile option presence",
							"Profile option not present in account list page\\n", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : gotosearchpageAndroid This function will Validate the search
	 * Icon is present in Homepage, Click on search Icon and verify User land on
	 * offer page. Input Required : NA
	 * 
	 */
	public void gotosearchpageAndroid() throws Exception {
		try {
			boolean searchIcon = isElementPresent(TdlHomeMobile.get().searchButton_android);
			if (searchIcon == true) {
				//logger.info("Search Icon present in Home Page\n");
				fUtil.flogResult("Passed", "Search Icon presence", "Search Icon present in Home Page", 1);

				TdlHomeMobile.get().searchButton_android.click();
				boolean searchTextbox = isElementVisible(TdlSearchPage_Mobile.get().searchTextbox_android, 10);
				if (searchTextbox == true) {
					//logger.info("Search textbox present in search page\n");
					fUtil.flogResult("Passed", "Search textbox presence", "Search textbox present in search page", 1);
				} else {
					//logger.error("search textbox not present in search page");
					fUtil.flogResult("Failed", "Search textbox presence", "Search textbox not present in search page",
							1);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/*
	 * Function name : signoutAndroid This function will Validate security option is
	 * present in account list, Click on security option and verify security option
	 * is expanded. Input Required : NA
	 * 
	 */
	public void gotosecurityAndroid() throws Exception {
		try {
			boolean securityOpt = isElementVisible_mobile(TdlAccountListPage_Mobile.get().securityOpt_android, 10);
			if (securityOpt == true) {
				//logger.info("Security option present in accountList Page\n");
				fUtil.flogResult("Passed", "Security option presence", "security option present in accountList Page\\n",
						1);

				TdlAccountListPage_Mobile.get().securityOpt_android.click();
				boolean signOutOfAllDevicesLinkedApps = isElementVisible_mobile(
						TdlAccountListPage_Mobile.get().SignOutOfAllDevicesLinkedAppsOpt_android, 10);
				if (signOutOfAllDevicesLinkedApps == true) {
					//logger.info("Security option is expanded");
					fUtil.flogResult("Passed", "SignOutOfAllDevicesLinkedApps presence", "Security option is expanded",
							1);
				} else {
					//logger.error("Security option is expanded");
					fUtil.flogResult("Failed", "SignOutOfAllDevicesLinkedApps presence",
							"Security option is not expanded", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : signoutAndroid This function will Validate SignOut option is
	 * present in account list, Click on SignOut option and verify user able to land
	 * on login page. Input Required : NA
	 * 
	 */
	public void signoutAndroid() throws Exception {
		try {
			boolean signoutOpt = isElementVisible_mobile(TdlAccountListPage_Mobile.get().signOutOpt_android, 10);
			if (signoutOpt == true) {
				//logger.info("SignOut option present in Home Page");
				fUtil.flogResult("Passed", "SignOut option presence", "SignOut option present in Home Page", 1);

				TdlAccountListPage_Mobile.get().signOutOpt_android.click();
				if (isElementVisible_mobile(TdlAccountListPage_Mobile.get().signoutButton_android, 10)) {
					TdlAccountListPage_Mobile.get().signoutButton_android.click();
					boolean signInBtn = isElementVisible_mobile(TdlSignUpMobile.get().signinButton_android, 10);
					if (signInBtn == true) {
						//logger.info("SignIn button present");
						fUtil.flogResult("Passed", "SignIn button presence", "SignIn button present", 1);
					} else {
						//logger.error("signIn button not presen");
						fUtil.flogResult("Failed", "SignIn Button presence", "SignIn button is not present", 1);
					}
				} else {
					//logger.error("signout popup not present");
					fUtil.flogResult("Failed", "Signout popup presence", "Signout popup not present", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : signoutallaccountAndroid This function will Validate
	 * SignOutOfAllDevicesLinkedApps option is present in account list, Click on
	 * SignOutOfAllDevicesLinkedApps option and verify user able to land on login
	 * page. Input Required : NA
	 * 
	 */
	public void signoutallaccountAndroid() throws Exception {
		try {
			boolean SignOutOfAllDevicesLinkedApps = isElementVisible_mobile(
					TdlAccountListPage_Mobile.get().SignOutOfAllDevicesLinkedAppsOpt_android, 20);
			if (SignOutOfAllDevicesLinkedApps == true) {
				//logger.info("SignOutOfAllDevicesLinkedApps option present in accountlist Page\n");
				fUtil.flogResult("Passed", "SignOutOfAllDevicesLinkedApps option presence",
						"SignOutOfAllDevicesLinkedApps option present in accountlist Page", 1);
				TdlAccountListPage_Mobile.get().SignOutOfAllDevicesLinkedAppsOpt_android.click();

				if (isElementVisible_mobile(TdlAccountListPage_Mobile.get().yesButton_android, 10)) {
					TdlAccountListPage_Mobile.get().yesButton_android.click();
					boolean signInBtn = isElementVisible_mobile(TdlSignUpMobile.get().signinButton_android, 10);
					if (signInBtn == true) {
						//logger.info("SignIn button present");
						fUtil.flogResult("Passed", "SignIn Button presence", "signIn button present", 1);
					} else {
						//logger.error("SignIn button not presen");
						fUtil.flogResult("Failed", "SignIn button presence", "SignIn button is not present", 1);
					}
				} else {
					//logger.error("Signout popup not presen");
					fUtil.flogResult("Failed", "Signout popup presence", "Signout popup is not present", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : gotovaultios This function will Validate the vault button is
	 * present in Homepage, Click on Vault button and verify user land on vault
	 * page. Input Required : NA
	 * 
	 */
	public void gotovaultios() throws Exception {
		try {
			boolean vaultBtn = isElementPresent(TdlHomeMobile.get().vaultBtn_ios);
			if (vaultBtn == true) {
				//logger.info("Vault button present in Home Page");
				fUtil.flogResult("Passed", "Vault button presence", "Vault button present in Home Page", 1);

				TdlHomeMobile.get().vaultBtn_ios.click();
				boolean cardTab = isElementVisible(TdlVaultMobile.get().cardTab_ios, 10);
				if (cardTab == true) {
					//logger.info("Card tab present in vault page");
					fUtil.flogResult("Passed", "Card tab presence", "Card tab present in vault page", 1);
				} else {
					//logger.error("Card tab not present in vault page");
					fUtil.flogResult("Failed", "Card tab presence", "Card tab not present in vault page", 1);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/*
	 * Function name : gotomyaccountios This function will Validate the profile pic
	 * CTA is present in Homepage, Click on profile pic CTA and verify user land on
	 * account list page. Input Required : NA
	 * 
	 */
	public void gotomyaccountios() throws Exception {
		try {
			boolean vaultIcon = isElementVisible_mobile(TdlHomeMobile.get().myAccountIcon_ios_, 20);
			if (vaultIcon == true) {
				//logger.info("Vault button present in Home Page");
				fUtil.flogResult("Passed", "Vault button presence", "Vault button present in Home Page", 1);
				TdlHomeMobile.get().myAccountIcon_ios_.click();

				boolean profileOption = isElementVisible_mobile(TdlAccountListPage_Mobile.get().profileOpt_ios, 20);
				if (profileOption == true) {
					//logger.info("Profile option present in account list page");
					fUtil.flogResult("Passed", "Profile option presence", "Profile option present in account list page",
							1);
				} else {
					//logger.error("Profile option not present in account list page");
					fUtil.flogResult("Failed", "Profile option presence",
							"Profile option not present in account list page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : gotosearchpageios This function will Validate the search Icon
	 * is present in Homepage, Click on search Icon and verify User land on offer
	 * page. Input Required : NA
	 * 
	 */
	public void gotosearchpageios() throws Exception {
		try {
			boolean searchIcon = isElementPresent(TdlHomeMobile.get().searchIcon_ios);
			if (searchIcon == true) {
				//logger.info("Search Icon present in Home Page\n");
				fUtil.flogResult("Passed", "Search Icon presence", "Search Icon present in Home Page", 1);
				TdlHomeMobile.get().searchIcon_ios.click();
				boolean searchTextbox = isElementVisible(TdlSearchPage_Mobile.get().SearchTextbox_ios, 10);
				if (searchTextbox == true) {
					//logger.info("Search textbox present in search page");
					fUtil.flogResult("Passed", "Search textbox presence", "Search textbox present in search page", 1);
				} else {
					//logger.error("Search textbox not present in search page");
					fUtil.flogResult("Failed", "Search textbox presence", "Search textbox not present in search page",
							1);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/*
	 * Function name : gotosecurityios This function will Validate security option
	 * is present in account list, Click on security option and verify security
	 * option is expanded. Input Required : NA
	 * 
	 */
	public void gotosecurityios() throws Exception {
		try {
			boolean securityOpt = isElementVisible_mobile(TdlAccountListPage_Mobile.get().securityOpt_ios, 10);
			if (securityOpt == true) {
				//logger.info("Security option present in accountList Page\n");
				fUtil.flogResult("Passed", "Security option presence", "Security option present in accountList Page\\n",
						1);

				TdlAccountListPage_Mobile.get().securityOpt_ios.click();
				boolean SignOutOfAllDevicesLinkedApps = isElementVisible_mobile(
						TdlAccountListPage_Mobile.get().signOutOfAllDevicesLinkedAppsOpt_ios, 10);
				if (SignOutOfAllDevicesLinkedApps == true) {
					//logger.info("Security option is expanded");
					fUtil.flogResult("Passed", "SignOutOfAllDevicesLinkedApps presence", "Security option is expanded",
							1);
				} else {
					//logger.error("Security option is expanded");
					fUtil.flogResult("Failed", "SignOutOfAllDevicesLinkedApps presence",
							"Security option is not expanded", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : signoutios This function will Validate SignOut option is
	 * present in account list, Click on SignOut option and verify user able to land
	 * on login page. Input Required : NA
	 * 
	 */
	public void signoutios() throws Exception {
		try {
			boolean signoutOpt = isElementVisible_mobile(TdlAccountListPage_Mobile.get().signOutOpt_ios, 10);
			if (signoutOpt == true) {
				//logger.info("SignOut option present in Home Page\n");
				fUtil.flogResult("Passed", "SignOut option presence", "SignOut option present in Home Page", 1);

				TdlAccountListPage_Mobile.get().signOutOpt_ios.click();
				if (isElementVisible_mobile(TdlAccountListPage_Mobile.get().signOutButton_ios, 10)) {
					TdlAccountListPage_Mobile.get().signOutButton_ios.click();
					boolean signInBtn = isElementVisible_mobile(TdlSignUpMobile.get().signinButton_ios, 10);
					if (signInBtn == true) {
						//logger.info("SignIn button present");
						fUtil.flogResult("Passed", "SignIn button presence", "SignIn button present", 1);
					} else {
						//logger.error("SignIn button not present");
						fUtil.flogResult("Failed", "SignIn button presence", "SignIn button not present", 1);
					}
				} else {
					//logger.error("Signout popup not present");
					fUtil.flogResult("Failed", "Signout popup presence", "Signout popup not present", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : signoutallaccountios This function will Validate
	 * SignOutOfAllDevicesLinkedApps option is present in account list, Click on
	 * SignOutOfAllDevicesLinkedApps option and verify user able to land on login
	 * page. Input Required : NA
	 * 
	 */
	public void signoutallaccountios() throws Exception {
		try {
			boolean signOutOfAllDevicesLinkedApps = isElementVisible_mobile(
					TdlAccountListPage_Mobile.get().signOutOfAllDevicesLinkedAppsOpt_ios, 10);
			if (signOutOfAllDevicesLinkedApps == true) {
				//logger.info("SignOutOfAllDevicesLinkedApps option present in accountlist Page\n");
				fUtil.flogResult("Passed", "SignOutOfAllDevicesLinkedApps option presence",
						"SignOutOfAllDevicesLinkedApps option present in accountlist Page", 1);

				TdlAccountListPage_Mobile.get().signOutOfAllDevicesLinkedAppsOpt_ios.click();
				if (isElementVisible_mobile(TdlAccountListPage_Mobile.get().yesButton_ios, 10)) {
					TdlAccountListPage_Mobile.get().yesButton_ios.click();
					boolean signInBtn = isElementVisible_mobile(TdlSignUpMobile.get().signinButton_ios, 10);
					if (signInBtn == true) {
						//logger.info("SignIn Btn present");
						fUtil.flogResult("Passed", "SignIn button presence", "SignIn button present", 1);
					} else {
						//logger.error("SignIn button not present");
						fUtil.flogResult("Failed", "SignIn button presence", "SignIn button not present", 1);
					}
				} else {
					//logger.error("Signout popup not present");
					fUtil.flogResult("Failed", "Signout popup presence", "Signout popup not present", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : openForYou This function will Validate offer for that
	 * particular user and click on it Input Required : WebElement forYouOffer is
	 * present in MyOffersPage class
	 * 
	 */
	public void openForYou(WebElement forYouOffer) throws Exception {
		try {
			boolean isOpenForYouOfferPresent = gmethods.isElementVisible(forYouOffer, 15);
			if (isOpenForYouOfferPresent == true) {
				//logger.info("For you offer is present");
				fUtil.flogResult("Passed", "For you offer is present", "For you offer is present", 1);
				forYouOffer.click();
			} else {
				//logger.error("For you offer is not present");
				fUtil.flogResult("Passed", "For you offer is present", "For you offer is not present", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Function name : openForYou<Mobile> This function will Validate offer for that
	 * particular user and click on it Input Required : WebElement forYouOffer is
	 * present in MyOffers_Mobile class
	 * 
	 */
	public void openForYou(MobileElement forYouOffer) throws Exception {
		try {
			boolean isOpenForYouOfferPresent = gmethods.isElementVisible_mobile(forYouOffer, 15);
			if (isOpenForYouOfferPresent == true) {
				//logger.info("For you offer is present");
				fUtil.flogResult("Passed", "For you offer is present", "For you offer is present", 1);
				forYouOffer.click();
			} else {
				//logger.error("For you offer is not present");
				fUtil.flogResult("Passed", "For you offer is present", "For you offer is not present", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Function name : shareUlimitedOffer<Mobile> This function will Validate offer
	 * for that particular user and click on it Input Required : WebElement
	 * forYouOffer is present in MyOffers_Mobile class
	 * 
	 */
	public void shareUnlimitedOffer(MobileElement shareIcon, MobileElement shareOption) throws Exception {
		try {
			boolean isShareIconPresent = gmethods.isElementVisible_mobile(shareIcon, 15);
			if (isShareIconPresent == true) {
				shareIcon.click();
				boolean isShareOptionPresent = gmethods.isElementVisible_mobile(shareOption, 15);
				if (isShareOptionPresent) {
					//logger.info("Share Option present");
					fUtil.flogResult("Passed", "Offer shared", "Offer shared", 1);
				} else {
					//logger.info("Share Option present");
					fUtil.flogResult("Failed", "Offer shared", "Offer is not shared", 1);
				}
			} else {
				//logger.error("Share Option present");
				fUtil.flogResult("Failed", "Offer shared", "Offer could not shared", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Function name: validate_TCPCard_earnpointsCroma This function will validate
	 * if the Croma earn point is showing for a customer Input required:
	 * List<MobileElement> transDesc, List<MobileElement> earnPoint - android/ios
	 * Parameter taken from class : TDL_TCPCardPage_Mobile Parameter details :
	 * cardName - cardNameText_TCP_android/cardNameText_TCP_ios transDesc -
	 * transcDesc_TCP_android/transcDesc_TCP_ios earnPoint -
	 * pointsActivity_TCP_android/pointsActivity_TCP_ios
	 * 
	 * @param earnPoint
	 * @throws Exception
	 */
	public void validate_TCPCard_earnpointsCroma(MobileElement cardName, List<MobileElement> transDesc,
			List<MobileElement> earnPoint, String resouce_id, String className) throws Exception {
		try {
			gmethods.validate_TCPCard(cardName);
			//logger.info("Verifying points activity");
			// Thread.sleep(3000);
			// List<MobileElement> myDynamicElement = (new WebDriverWait(appiumDriver,
			// 100)).until(ExpectedConditions.visibilityOfAllElements(TdlTCPCardMobile.get().pointsActivity_TCP_android));
			MobileElement elem1 = earnPoint.get(0);
			boolean pointsEarnedVisibility = gmethods.isElementVisible_mobile(elem1, 20);
			if (pointsEarnedVisibility == true) {
				//logger.info("Verifying earn points in TCP card is present and is showing as +");
				Iterator<MobileElement> itr1 = transDesc.iterator();
				Iterator<MobileElement> itr2 = earnPoint.iterator();
				while (itr1.hasNext()) {
					MobileElement trans = itr1.next();
					MobileElement earn = itr2.next();
					if (trans.getText().contains("Croma") && earn.getText().contains("+")) {
						System.out.println(trans.getText());
						System.out.println(earn.getText());
						//logger.info("Customer has earned points for croma: " + trans.getText() + "  " + earn.getText());
						fUtil.flogResult("Passed", "Line item earn point verification",
								"Customer has earned points for croma :" + trans.getText() + "  " + earn.getText(), 1);
						break;
					} else if (!(trans.getText().contains("Croma") && earn.getText().contains("+"))) {
						gmethods.scrollToElement_Mobile("+", resouce_id, className);
						if (trans.getText().contains("Croma") && earn.getText().contains("+")) {
							System.out.println(trans.getText());
							System.out.println(earn.getText());
							//logger.info(
							//		"Customer has earned points for croma: " + trans.getText() + "  " + earn.getText());
							fUtil.flogResult("Passed", "Line item earn point verification",
									"Customer has earned points for croma :" + trans.getText() + "  " + earn.getText(),
									1);
							break;
						}
					} else {
						//logger.fatal("Customer has no transaction for croma");
						fUtil.flogResult("Failed", "Line item earn point verification",
								"Customer has no transaction for croma", 1);
						break;
					}
				}
			} else {
				//logger.fatal("Customer has no points");
				fUtil.flogResult("Failed", "Line item earn point verification", "Customer has no points", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function name: validate_TCPCard_earnpointsIHCL This function will validate if
	 * the IHCL earn point is showing for a customer Input required:
	 * List<MobileElement> transDesc, List<MobileElement> earnPoint - android/ios
	 * Parameter taken from class : TDL_TCPCardPage_Mobile Parameter details :
	 * cardName - cardNameText_TCP_android/cardNameText_TCP_ios transDesc -
	 * transcDesc_TCP_android/transcDesc_TCP_ios earnPoint -
	 * pointsActivity_TCP_android/pointsActivity_TCP_ios
	 * 
	 * @param earnPoint
	 * @throws Exception
	 */
	public void validate_TCPCard_earnpointsIHCL(MobileElement cardName, List<MobileElement> transDesc,
			List<MobileElement> earnPoint, String resouce_id, String className) throws Exception {
		try {
			gmethods.validate_TCPCard(cardName);
			//logger.info("Verifying points activity");
			// Thread.sleep(3000);
			// List<MobileElement> myDynamicElement = (new WebDriverWait(appiumDriver,
			// 100)).until(ExpectedConditions.visibilityOfAllElements(TdlTCPCardMobile.get().pointsActivity_TCP_android));
			MobileElement elem1 = earnPoint.get(0);
			boolean pointsEarnedVisibility = gmethods.isElementVisible_mobile(elem1, 20);
			if (pointsEarnedVisibility == true) {
				//logger.info("Verifying earn points in TCP card is present and is showing as +");
				Iterator<MobileElement> itr1 = transDesc.iterator();
				Iterator<MobileElement> itr2 = earnPoint.iterator();
				while (itr1.hasNext()) {
					MobileElement trans = itr1.next();
					MobileElement earn = itr2.next();
					if (trans.getText().contains("IHCL") && earn.getText().contains("+")) {
						System.out.println(trans.getText());
						System.out.println(earn.getText());
						//logger.info("Customer has earned points for IHCL: " + trans.getText() + "  " + earn.getText());
						fUtil.flogResult("Passed", "Line item earn point verification",
								"Customer has earned points for IHCL :" + trans.getText() + "  " + earn.getText(), 1);
						break;
					} else if (!(trans.getText().contains("IHCL") && earn.getText().contains("+"))) {
						gmethods.scrollToElement_Mobile("+", resouce_id, className);
						if (trans.getText().contains("IHCL") && earn.getText().contains("+")) {
							System.out.println(trans.getText());
							System.out.println(earn.getText());
							//logger.info(
							//		"Customer has earned points for IHCL: " + trans.getText() + "  " + earn.getText());
							fUtil.flogResult("Passed", "Line item earn point verification",
									"Customer has earned points for IHCL :" + trans.getText() + "  " + earn.getText(),
									1);
							break;
						}
					} else {
						//logger.fatal("Customer has no transaction for IHCL");
						fUtil.flogResult("Failed", "Line item earn point verification",
								"Customer has no transaction for IHCL", 1);
						break;
					}
				}
			} else {
				//logger.fatal("Customer has no points");
				fUtil.flogResult("Failed", "Line item earn point verification", "Customer has no points", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function name: validate_TCPCard_earnpoints This function will validate if the
	 * earn point is showing for a customer Input required: none
	 * 
	 * @param earnPoint
	 * @throws Exception
	 */
	public void validate_TCPCard_earnpoints() throws Exception {
		try {
			gmethods.validate_TCPCard();
			//logger.info("Verifying points activity");
			List<WebElement> myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 100))
					.until(ExpectedConditions.visibilityOfAllElements(TdlTcpCard.get().pointsActivity_TCP));
			boolean pointsEarnedVisibility = gmethods.isElementVisible(myDynamicElement.get(0), 20);
			if (pointsEarnedVisibility == true) {
				//logger.info("Verifying earn points in TCP card is present and is showing as +");
				Iterator<WebElement> itr1 = TdlTcpCard.get().transcDesc_TCP.iterator();
				Iterator<WebElement> itr2 = TdlTcpCard.get().pointsActivity_TCP.iterator();
				while (itr1.hasNext()) {
					WebElement trans = itr1.next();
					WebElement earn = itr2.next();
					if (trans.getText().contains("Croma") && earn.getText().contains("+")) {
						gmethods.highlightElement(trans);
						gmethods.highlightElement(earn);
						System.out.println(trans.getText());
						System.out.println(earn.getText());
						//logger.info("Customer has earned points for croma: " + trans.getText() + "  " + earn.getText());
						fUtil.flogResult("Passed", "Line item earn point verification",
								"Customer has earned points for croma :" + trans.getText() + "  " + earn.getText(), 1);
						break;
					} else if (!(trans.getText().contains("Croma"))) {
						//logger.fatal("Customer has no transaction for croma");
						fUtil.flogResult("Failed", "Line item earn point verification",
								"Customer has no transaction for croma", 1);
						break;
					}
				}
				while (itr1.hasNext()) {
					WebElement trans = itr1.next();
					WebElement earn = itr2.next();
					if (trans.getText().contains("IHCL") && earn.getText().contains("+")) {
						System.out.println(trans);
						System.out.println(earn);
						//logger.info("Customer has earned points for IHCL: " + trans + "  " + earn);
						fUtil.flogResult("Passed", "Line item earn point verification",
								"Customer has earned points for IHCL :" + trans + "  " + earn, 1);
						break;
					} else if (!(trans.getText().contains("IHCL"))) {
						//logger.fatal("Customer has no transaction for IHCL: " + trans + "  " + earn);
						fUtil.flogResult("Failed", "Line item earn point verification",
								"Customer has no transaction for IHCL :", 1);
						break;
					}

				}
			} else {
				//logger.fatal("Customer has no earned points for IHCL/croma");
				fUtil.flogResult("Failed", "Line item earn point verification",
						"Customer has no earned points for IHCL/croma", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : shareUlimitedOffer<Mobile> This function will Validate offer
	 * for that particular user and click on it Input Required : WebElement
	 * forYouOffer is present in MyOffers_Mobile class
	 * 
	 */
	public void findStore() throws Exception {
		try {
			boolean isViewstoreCTAPresent = gmethods.isElementVisible(MyOffersPage.get().viewStoreCTA, 10);
			if (isViewstoreCTAPresent == true) {
				MyOffersPage.get().viewStoreCTA.click();

				boolean noStore = gmethods.isElementVisible(OfferDetailsPage.get().nostoreText, 10);
				if (noStore == true) {
					OfferDetailsPage.get().nostoreText.getText();
					//logger.error("No Store found");
					fUtil.flogResult("Passed", "No Stores found", "No Store found" + noStore, 1);
				}

			} else {

				//logger.error("Store not found");
				fUtil.flogResult("Failed", "Stores found", "Stores not found", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Function name : shareUlimitedOffer<Mobile> This function will Validate offer
	 * for that particular user and click on it Input Required : WebElement
	 * forYouOffer is present in MyOffers_Mobile class
	 * 
	 */
	public void findStore(MobileElement viewStoreCTA, MobileElement storeResult) throws Exception {
		try {
			boolean isViewstoreCTAPresent = gmethods.isElementVisible_mobile(viewStoreCTA, 15);
			if (isViewstoreCTAPresent == true) {
				viewStoreCTA.click();
				boolean isViewStoreDirectionCTA = gmethods.isElementVisible_mobile(storeResult, 15);
				if (isViewStoreDirectionCTA == true) {
					//logger.info("Store found");
					fUtil.flogResult("Passed", "Stores found", "Stores found", 1);
				}
			} else {
				storeResult.getText();
				//logger.error("Store not found");
				fUtil.flogResult("Passed", "Stores found status", "Stores not found here", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void limitedShareOffer(MobileElement shareIcon) throws Exception {
		try {
			boolean isShareIconLimited = gmethods.isElementVisible_mobile(shareIcon, 25);
			if (isShareIconLimited == true) {
				boolean isShareIconLimitedClickable = gmethods.isElementClickable(shareIcon, 10);
				if (isShareIconLimitedClickable == true) {
					shareIcon.click();

				} else {
					//logger.info("Limited Share icon is not available");
					fUtil.flogResult("Failed", "Limited Share icon not available",
							"Limited Share icon is not available", 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Function name : gotopaymentpagePWA This function will Validate payment header
	 * present in payments page, fill the coustmer Details and verify payment method
	 * text present in multitender page. Input Required : OrderID.
	 * 
	 */
	public void gotopaymentpagePWA(String OrderID) throws Exception {
		try {
			boolean paymentHeader = isElementPresent(TdlPaymentsPage.get().paymentHeader);
			if (paymentHeader == true) {
				//logger.info("Payment header present in payments page");
				fUtil.flogResult("Passed", "Payment header presence", "Payment header present in payments page", 1);

				TdlPaymentsPage.get().orderID.clear();
				TdlPaymentsPage.get().orderID.sendKeys(OrderID);
				TdlPaymentsPage.get().next.click();
				boolean paymentMethodTxt = isElementVisible(TdlMultitenderPage.get().paymentMethodTxt, 10);
				if (paymentMethodTxt == true) {
					//logger.info("Payment method text present in multitender page");
					fUtil.flogResult("Passed", "Payment method text presence",
							"Payment method text is present in multitender page", 1);
				} else {
					//logger.error("Payment method text is present in multitender Page");
					fUtil.flogResult("Failed", "Payment method text presence",
							"Payment method text is not present in multitender Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : changepaymenttypePWA This function will Validate Payment
	 * method text present in multitender page, Click on change button and verify
	 * payment types are present in multitender page. Input Required : NA
	 */
	public void changepaymenttypePWA() throws Exception {
		try {
			Robot robot = new Robot();
			boolean changeTxt = isElementVisible(TdlMultitenderPage.get().change, 10);
			if (changeTxt == true) {
				//logger.info("Payment method text present in multitender page");
				fUtil.flogResult("Passed", "Change CTA presence", "Change CTA is present in multitender page", 1);

				TdlMultitenderPage.get().change.click();

				// boolean upi =isElementVisible(TdlMultitenderPage.get().upi, 20);
				boolean creditCard = isElementVisible(TdlMultitenderPage.get().creditCard, 10);
				boolean debitCard = isElementVisible(TdlMultitenderPage.get().debitCard, 10);
				boolean netbanking = isElementVisible(TdlMultitenderPage.get().netBanking, 10);
				if (creditCard == true && debitCard == true && netbanking == true) {
					robot.keyPress(KeyEvent.VK_PAGE_UP);
					robot.keyRelease(KeyEvent.VK_PAGE_UP);
					fUtil.flogResult("Passed", "Payment types check1",
							"Payment types - credit card, debit card and netbanking are present in multitender page",
							1);
					robot.keyPress(KeyEvent.VK_PAGE_DOWN);
					robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
					fUtil.flogResult("Passed", "Payment types check2",
							"Payment types -credit card, debit card and netbanking are present in multitender page", 1);
				} else {
					//logger.error("Payment types are not present in multitender page");
					fUtil.flogResult("Failed", "Payment types are presence",
							"Payment types are not present in multitender page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : addpaymentmethodPWA This function will Validate Payment
	 * method text present in multitender Page, add new card,validate new card added
	 * successfully. Input Required :
	 * alias,nameOnCard,cardNumber,cardExpMonth,cardExpYear
	 * 
	 */
	public void addpaymentmethodPWA(String alias, String nameOnCard, String cardNumber, String cardExpMonth,
			String cardExpYear) throws Exception {
		try {
			boolean addnew = isElementVisible(TdlMultitenderPage.get().addNew, 1000);
			if (addnew == true) {
				fUtil.flogResult("Passed", "Add new button presence", "Add new button is present in multitender Page",
						1);
				TdlMultitenderPage.get().addNew.click();
				isElementVisible(TdlAddCardPage.get().nameOnCard, 10);

				TdlAddCardPage.get().nameOnCard.click();
				TdlAddCardPage.get().nameOnCard.sendKeys(nameOnCard);
				TdlAddCardPage.get().cardNumber.sendKeys(cardNumber);
				TdlAddCardPage.get().cardExpMonth.sendKeys(cardExpMonth);
				TdlAddCardPage.get().cardExpYear.sendKeys(cardExpYear);

				TdlAddCardPage.get().continueBtn.click();
				System.out.println("button clicked");
				boolean securityCode = isElementVisible(TdlMultitenderPage.get().securityCode, 10);
				if (securityCode == true) {
					//logger.info("Security code present in multitender Page");
					fUtil.flogResult("Passed", "Security code presence", "Security code is present in multitender Page",
							1);
				} else {
					//logger.error("Security code is not present in multitender Page");
					fUtil.flogResult("Failed", "Security code is presence",
							"Security code is not present in multitender Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paybycreditcardPWA This function will Validate Payment method
	 * text present in multitender Page, select payment method as credit card pay
	 * using credit card,after complete payment its show Tranction status page,Pass
	 * / fail. Input Required : cvv,Password. Author: Neha Dhuri (Quality Kiosk)
	 */

	public void paybycreditcardPWA(String CVV, String cardname) {
		try {
			String xpath = "//div[contains(text(),'" + cardname.toUpperCase() + "')]/../../..//*[@fill='none']";

			if (BrowserFactory.webDriver.get().findElement(By.xpath(xpath)).isDisplayed()) {

				BrowserFactory.webDriver.get().findElement(By.xpath(xpath)).click();
				fUtil.flogResult("Passed", "Check credit card for user", "Credit card given in data is selected", 1);
				browserFactory.get().getDriver().switchTo().frame(0);
				TdlMultitenderPage.get().securityCode.sendKeys(CVV);
				BrowserFactory.webDriver.get().switchTo().defaultContent();
				if (isElementEnabled(TdlMultitenderPage.get().pay))
					TdlMultitenderPage.get().pay.click();
				else
					fUtil.flogResult("Failed", "Pay by credeit card", "Pay button disabled", 1);

				if (TdlTransactionStatus.get().errPopupobjects.isEmpty())
					paymentConfirmationForSuccessfulPaymentPWA();
				else {
					fUtil.flogResult("Failed", "Check transaction success", "Unexpected popup occure with message "
							+ TdlTransactionStatus.get().errPopupobjects.get(2).getText(), 1);
					TdlTransactionStatus.get().alertOkBtn.click();
				}
			} else {
				fUtil.flogResult("Failed", "Check credit card for user", "Credit card section not loaded", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : paybydebitcardPWA This function will Validate Payment method
	 * text present in multitender Page, select payment method as credit card,after
	 * complete payment its show Tranction status page,Pass / fail. Input Required :
	 * cvv,Password.
	 * 
	 */
	public void paybydebitcardPWA(String CVV, String Password) throws Exception {
		try {
			boolean debitcard = isElementVisible(TdlMultitenderPage.get().debitCard, 10);
			if (debitcard == true) {
				//logger.info("Debit card text present in multitender Page");
				fUtil.flogResult("Passed", "Debit card text presence", "Debit card text is present in multitender Page",
						1);

				// TdlMultitenderPage.get().rediocheckDebit.click();
				TdlMultitenderPage.get().securityCode.click();
				TdlMultitenderPage.get().securityCode.sendKeys(CVV);
				TdlMultitenderPage.get().pay.click();
				TdlMultitenderPage.get().successbtn.click();
				boolean paymentConfirmation = isElementVisible(TdlTransactionStatus.get().paymentConfirmation, 10);
				if (paymentConfirmation == true) {
					//logger.info("Paynment successful message present in transaction status Page");
					fUtil.flogResult("Passed", "Security code presence",
							"Paynment successful message present in transaction status Page", 1);
				} else {
					//logger.error("Paynment successful message is not present in transaction status Page");
					fUtil.flogResult("Failed", "Paynment successful message is presence",
							"Paynment successful message is not present in transaction status Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paybynetbankingPWA This function will Validate Payment method
	 * text present in multitender Page, select payment method as netbanking,after
	 * complete payment its show Tranction status page,Pass / fail. Input Required :
	 * cvv,Password. Author: Neha Dhuri (Quality Kiosk)
	 */
	public void paybynetbankingPWA(String bankname) throws Exception {
		try {
			if (!TdlMultitenderPage.get().netbankOptions.isEmpty()) {

				for (WebElement banknm : TdlMultitenderPage.get().netbankOptions) {
					if (banknm.getText().equalsIgnoreCase(bankname)) {
						banknm.click();
						break;
					}
				}

				boolean warnAlert = isElementVisible(TdlMultitenderPage.get().warnAlert, 10);
				if (warnAlert) {
					fUtil.flogResult("Failed", "Warning popup while doing payment using netbanking",
							"Netbanking payment failed with message " + TdlMultitenderPage.get().alertMessage.getText(),
							1);
				} else {
					boolean infoAlert = isElementVisible(TdlMultitenderPage.get().infoAlert, 10);
					if (infoAlert) {
						fUtil.flogResult("Passed", "Verify loyalty popup when user used tcp points with netbanking",
								"Loyalty popup is displayed", 1);
						TdlMultitenderPage.get().alertOkBtn.click();
					}
					paymentConfirmationForSuccessfulPaymentPWA();
				}

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : gotoOtherpageAndroid This function will Validate other option
	 * present in payments page and verify continue button is present in multitender
	 * Page. Input Required : NA.
	 * 
	 */
	public void gotoOtherpageAndroid() throws Exception {
		try {
			boolean otherOpt = isElementVisible_mobile(TdlAccountListPage_Mobile.get().otherOpt_android, 10);
			if (otherOpt == true) {
				//logger.info("Other option is present on account list page");
				fUtil.flogResult("Passed", "Other option presence", "Other option is present on account list page", 1);
				TdlAccountListPage_Mobile.get().otherOpt_android.click();
				Thread.sleep(3000);
				gmethods.scrollDirectionMobile("DOWN");
				gmethods.scrollDirectionMobile("DOWN");
				isElementVisible_mobile(TdlOtherPage_Mobile.get().paymentsOpt_android, 10);
				TdlOtherPage_Mobile.get().paymentsOpt_android.click();
				boolean continuebtn = isElementVisible_mobile(TdlPaymentsPage_Mobile.get().continueBtn_android, 10);
				if (continuebtn == true) {
					//logger.info("Continue button present in payments page");
					fUtil.flogResult("Passed", "Continue button presence", "Continue button present in payments page",
							1);
				} else {
					//logger.error("Continue button not present in payments page");
					fUtil.flogResult("Failed", "Continue button presence",
							"Continue button not present in payments page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : gotopaymentpageAndroid This function will Validate contimue
	 * button present in payments page, fill the coustmer Details and verify payment
	 * method text present in multitender page. Input Required : OrderID.
	 * 
	 */
	public void gotopaymentpageAndroid(String OrderID) throws Exception {
		try {
			boolean continuebtn = isElementVisible_mobile(TdlPaymentsPage_Mobile.get().continueBtn_android, 10);
			if (continuebtn == true) {
				//logger.info("Continue button present in payments page");
				fUtil.flogResult("Passed", "Continue button presence", "Continue button present in payments page", 1);

				TdlPaymentsPage_Mobile.get().orderId_android.clear();
				TdlPaymentsPage_Mobile.get().orderId_android.sendKeys(OrderID);
				TdlPaymentsPage_Mobile.get().continueBtn_android.click();
				boolean paymentMethodTxt = isElementVisible_mobile(
						TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_android, 10);
				if (paymentMethodTxt == true) {
					//logger.info("Payment method text present in multitender page");
					fUtil.flogResult("Passed", "Payment method text presence",
							"Payment method text is present in multitender page", 1);
				} else {
					//logger.error("Payment method text is present in multitender Page");
					fUtil.flogResult("Failed", "Payment method text presence",
							"Payment method text is not present in multitender Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : changepaymenttypeAndroid This function will Validate Payment
	 * method text present in multitender page, Click on change button and verify
	 * payment types are present in multitender page. Input Required : NA
	 * 
	 */
	public void changepaymenttypeAndroid() throws Exception {
		try {
			boolean paymentMethodTxt = isElementVisible_mobile(
					TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_android, 30);
			if (paymentMethodTxt == true) {
				//logger.info("Payment method text present in multitender page");
				fUtil.flogResult("Passed", "Payment method text presence",
						"Payment method text is present in multitender page", 1);
				Thread.sleep(10000);
				TdlMultitenderPage_Mobile.get().change_android.click();
				boolean netbanking = isElementVisible_mobile(TdlMultitenderPage_Mobile.get().netBanking_android, 10);
				boolean creditCard = isElementVisible_mobile(
						TdlMultitenderPage_Mobile.get().totalAmountHeaderCredit_android, 10);
				boolean debitCard = isElementVisible_mobile(
						TdlMultitenderPage_Mobile.get().totalAmountHeaderDebit_android, 10);
				if (netbanking == true && creditCard == true && debitCard == true) {
					//logger.info("Payment types are present in multitender page");
					fUtil.flogResult("Passed", "Payment types are presence",
							"Payment types are present in multitender page", 1);
				} else {
					//logger.error("Payment types are present in multitender page");
					fUtil.flogResult("Failed", "Payment types are presence",
							"Payment types are not present in multitender page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : addpaymentmethodAndroid This function will Validate Payment
	 * method text present in multitender Page, add new card,validate new card added
	 * successfully. Input Required :
	 * alias,nameOnCard,cardNumber,cardExpMonth,cardExpYear
	 * 
	 */
	public void addpaymentmethodAndroid(String alias, String nameOnCard, String cardNumber, String cardExpMonth,
			String cardExpYear) throws Exception {
		try {
			boolean paymentMethodTxt = isElementPresent(TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_android);
			if (paymentMethodTxt == true) {
				//logger.info("Payment method text present in multitender Page");
				fUtil.flogResult("Passed", "Payment method text presence",
						"Payment method text is present in multitender Page", 1);

				TdlMultitenderPage_Mobile.get().addNewCard_android.click();
				TdlAddCardPage_Mobile.get().nameOnCard_android.sendKeys(nameOnCard);
				TdlAddCardPage_Mobile.get().cardNumber_android.sendKeys(cardNumber);
				TdlAddCardPage_Mobile.get().cardExpMonth_android.sendKeys(cardExpMonth);
				TdlAddCardPage_Mobile.get().cardExpYear_android.sendKeys(cardExpYear);
				TdlAddCardPage_Mobile.get().alias_android.sendKeys(alias);
				TdlAddCardPage_Mobile.get().continueBtn_android.click();
				boolean securityCode = isElementVisible(TdlMultitenderPage_Mobile.get().cvv_android, 10);
				if (securityCode == true) {
					//logger.info("Security code present in multitender Page");
					fUtil.flogResult("Passed", "Security code presence", "Security code is present in multitender Page",
							1);
				} else {
					//logger.error("Security code is present in multitender Page");
					fUtil.flogResult("Failed", "Security code is presence",
							"Security code is not present in multitender Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paybycreditcardAndroid This function will Validate Payment
	 * method text present in multitender Page, select payment method as credit card
	 * pay using credit card,after complete payment its show Tranction status
	 * page,Pass / fail. Input Required : cvv,Password.
	 * 
	 */

	public void paybycreditcardAndroid(String CVV, String password) throws Exception {
		try {
			boolean paymentMethodTxt = isElementPresent(TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_android);
			if (paymentMethodTxt == true) {
				//logger.info("Payment method text present in multitender Page");
				fUtil.flogResult("Passed", "Payment method text presence",
						"Payment method text is present in multitender Page", 1);

				TdlMultitenderPage_Mobile.get().cvv_android.sendKeys(CVV);
				TdlMultitenderPage_Mobile.get().payMultitender_android.click();
				TdlSecurePage_Mobile.get().txtPassword_android.sendKeys(password);
				TdlSecurePage_Mobile.get().cmdSubmit_android.click();
				boolean paynmentSuccessful = isElementVisible(
						TdlTransactionStatus_Mobile.get().paynmentSuccessful_android, 10);
				if (paynmentSuccessful == true) {
					//logger.info("Paynment successful message present in transaction status Page");
					fUtil.flogResult("Passed", "Security code presence",
							"Paynment successful message present in transaction status Page", 1);
				} else {
					//logger.error("Paynment successful message is not present in transaction status Page");
					fUtil.flogResult("Failed", "Paynment successful message is presence",
							"Paynment successful message is not present in transaction status Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paybydebitcardAndroid This function will Validate Payment
	 * method text present in multitender Page, select payment method as credit
	 * card,after complete payment its show Tranction status page,Pass / fail. Input
	 * Required : cvv,Password.
	 * 
	 */
	public void paybydebitcardAndroid(String CVV, String password) throws Exception {
		try {
			boolean paymentMethodTxt = isElementPresent_mobile(
					TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_android);
			if (paymentMethodTxt == true) {
				//logger.info("Payment method text present in multitender Page");
				fUtil.flogResult("Passed", "Payment method text presence",
						"Payment method text is present in multitender Page", 1);

				TdlMultitenderPage_Mobile.get().cvv_android.sendKeys(CVV);
				TdlMultitenderPage_Mobile.get().payMultitender_android.click();
				TdlSecurePage_Mobile.get().txtPassword_android.sendKeys(password);
				TdlSecurePage_Mobile.get().cmdSubmit_android.click();
				boolean paynmentSuccessful = isElementVisible_mobile(
						TdlTransactionStatus_Mobile.get().paynmentSuccessful_android, 10);
				if (paynmentSuccessful == true) {
					//logger.info("Paynment successful message present in transaction status Page");
					fUtil.flogResult("Passed", "Security code presence",
							"Paynment successful message present in transaction status Page", 1);
				} else {
					//logger.error("Paynment successful message is not present in transaction status Page");
					fUtil.flogResult("Failed", "Paynment successful message is presence",
							"Paynment successful message is not present in transaction status Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paybynetbankingAndroid This function will Validate Payment
	 * method text present in multitender Page, select payment method as
	 * netbanking,after complete payment its show Tranction status page,Pass / fail.
	 * Input Required : cvv,Password.
	 * 
	 */
	public void paybynetbankingAndroid(String CVV, String password) throws Exception {
		try {
			boolean paymentMethodTxt = isElementPresent_mobile(
					TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_android);
			if (paymentMethodTxt == true) {
				//logger.info("Payment method text present in multitender Page");
				fUtil.flogResult("Passed", "Payment method text presence",
						"Payment method text is present in multitender Page", 1);

				TdlMultitenderPage_Mobile.get().icici_android.click();
				TdlSecurePage_Mobile.get().txtPassword_android.sendKeys(password);
				TdlSecurePage_Mobile.get().cmdSubmit_android.click();
				boolean paynmentSuccessful = isElementVisible_mobile(
						TdlTransactionStatus_Mobile.get().paynmentSuccessful_android, 10);
				if (paynmentSuccessful == true) {
					//logger.info("Paynment successful message present in transaction status Page");
					fUtil.flogResult("Passed", "Security code presence",
							"Paynment successful message present in transaction status Page", 1);
				} else {
					//logger.error("Paynment successful message is not present in transaction status Page");
					fUtil.flogResult("Failed", "Paynment successful message is presence",
							"Paynment successful message is not present in transaction status Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : gotoOtherpageios This function will Validate other option
	 * present in payments page, verify user land on payment page. Input Required :
	 * NA.
	 * 
	 */
	public void gotoOtherpageios() throws Exception {
		try {
			boolean otherOpt = isElementPresent_mobile(TdlAccountListPage_Mobile.get().otherOpt_ios);
			if (otherOpt == true) {
				//logger.info("Other option is present on account list page");
				fUtil.flogResult("Passed", "Other option presence", "Other option is present on account list page", 1);
				TdlOtherPage_Mobile.get().paymentsOpt_ios.click();
				TdlPaymentsPage_Mobile.get().gotopayment_ios.click();
				boolean paymentsOption = isElementVisible_mobile(TdlOtherPage_Mobile.get().paymentsOpt_ios, 10);
				if (paymentsOption == true) {
					//logger.info("Continue button present in payments page");
					fUtil.flogResult("Passed", "Payment option presence",
							"Payment option is present in multitender page", 1);
				} else {
					//logger.error("Payment option is present in multitender Page");
					fUtil.flogResult("Failed", "Payment option presence",
							"Payment option is not present in multitender Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : gotopaymentpageios This function will Validate next button
	 * present in payments page, fill the coustmer Details and verify payment method
	 * text present in multitender page. Input Required : OrderID.
	 * 
	 */
	public void gotopaymentpageios(String OrderID) throws Exception {
		try {
			boolean nextbtn = isElementPresent_mobile(TdlPaymentsPage_Mobile.get().nextBtn_ios);
			if (nextbtn == true) {
				//logger.info("Next button present in payments page");
				fUtil.flogResult("Passed", "Next button presence", "Next button present in payments page", 1);

				TdlPaymentsPage_Mobile.get().orderId_ios.clear();
				TdlPaymentsPage_Mobile.get().orderId_ios.sendKeys(OrderID);
				TdlPaymentsPage_Mobile.get().nextBtn_ios.click();
				boolean paymentMethodTxt = isElementVisible_mobile(
						TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_ios, 10);
				if (paymentMethodTxt == true) {
					//logger.info("Payment method text present in multitender page");
					fUtil.flogResult("Passed", "Payment method text presence",
							"Payment method text is present in multitender page", 1);
				} else {
					//logger.error("Payment method text is present in multitender Page");
					fUtil.flogResult("Failed", "Payment method text presence",
							"Payment method text is not present in multitender Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : changepaymenttypeios This function will Validate Payment
	 * method text present in multitender page, Click on change button and verify
	 * payment types are present in multitender page. Input Required : NA
	 * 
	 */
	public void changepaymenttypeios() throws Exception {
		try {
			boolean paymentMethodTxt = isElementPresent_mobile(TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_ios);
			if (paymentMethodTxt == true) {
				//logger.info("Payment method text present in multitender page");
				fUtil.flogResult("Passed", "Payment method text presence",
						"Payment method text is present in multitender page", 1);

				TdlMultitenderPage_Mobile.get().change_ios.click();
				boolean creditCard = isElementVisible_mobile(
						TdlMultitenderPage_Mobile.get().totalAmountHeaderCredit_ios, 10);
				boolean debitCard = isElementVisible_mobile(TdlMultitenderPage_Mobile.get().totalAmountHeaderDebit_ios,
						10);
				if (creditCard == true && debitCard == true) {
					//logger.info("Payment types are present in multitender page");
					fUtil.flogResult("Passed", "Payment types are presence",
							"Payment types are present in multitender page", 1);
				} else {
					//logger.error("Payment types are present in multitender page");
					fUtil.flogResult("Failed", "Payment types are presence",
							"Payment types are not present in multitender page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : addpaymentmethodios This function will Validate Payment
	 * method text present in multitender Page, add new card,validate new card added
	 * successfully. Input Required :
	 * alias,nameOnCard,cardNumber,cardExpMonth,cardExpYear
	 * 
	 */
	public void addpaymentmethodios(String alias, String nameOnCard, String cardNumber, String cardExpMonth,
			String cardExpYear) throws Exception {
		try {
			boolean paymentMethodTxt = isElementPresent_mobile(TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_ios);
			if (paymentMethodTxt == true) {
				//logger.info("Payment method text present in multitender Page");
				fUtil.flogResult("Passed", "Payment method text presence",
						"Payment method text is present in multitender Page", 1);

				TdlMultitenderPage_Mobile.get().addNewCard_ios.click();
				TdlAddCardPage_Mobile.get().nameOnCard_ios.sendKeys(nameOnCard);
				TdlAddCardPage_Mobile.get().cardNumber_ios.sendKeys(cardNumber);
				TdlAddCardPage_Mobile.get().cardExpMonth_ios.sendKeys(cardExpMonth);
				TdlAddCardPage_Mobile.get().cardExpYear_ios.sendKeys(cardExpYear);
				TdlAddCardPage_Mobile.get().alias_ios.sendKeys(alias);
				TdlAddCardPage_Mobile.get().continueBtn_ios.click();
				boolean securityCode = isElementVisible_mobile(TdlMultitenderPage_Mobile.get().cvv_ios, 10);
				if (securityCode == true) {
					//logger.info("Security code present in multitender Page");
					fUtil.flogResult("Passed", "Security code presence", "Security code is present in multitender Page",
							1);
				} else {
					//logger.error("Security code is present in multitender Page");
					fUtil.flogResult("Failed", "Security code is presence",
							"Security code is not present in multitender Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paybycreditcardios This function will Validate Payment method
	 * text present in multitender Page, select payment method as credit card pay
	 * using credit card,after complete payment its show Tranction status page,Pass
	 * / fail. Input Required : cvv,Password.
	 * 
	 */

	public void paybycreditcardios(String CVV, String Password) throws Exception {
		try {
			boolean paymentMethodTxt = isElementPresent_mobile(TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_ios);
			if (paymentMethodTxt == true) {
				//logger.info("Payment method text present in multitender Page");
				fUtil.flogResult("Passed", "Payment method text presence",
						"Payment method text is present in multitender Page", 1);

				TdlMultitenderPage_Mobile.get().cvv_ios.sendKeys(CVV);
				TdlMultitenderPage_Mobile.get().payMultitender_ios.click();
				TdlSecurePage_Mobile.get().txtPassword_ios.sendKeys(Password);
				TdlSecurePage_Mobile.get().cmdSubmit_ios.click();
				boolean paynmentSuccessful = isElementVisible_mobile(
						TdlTransactionStatus_Mobile.get().paynmentSuccessful_ios, 10);
				if (paynmentSuccessful == true) {
					//logger.info("Paynment successful message present in transaction status Page");
					fUtil.flogResult("Passed", "Security code presence",
							"Paynment successful message present in transaction status Page", 1);
				} else {
					//logger.error("Paynment successful message is not present in transaction status Page");
					fUtil.flogResult("Failed", "Paynment successful message is presence",
							"Paynment successful message is not present in transaction status Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paybydebitcardios This function will Validate debit card text
	 * present in multitender Page, select payment method as credit card,after
	 * complete payment its show Tranction status page,Pass / fail. Input Required :
	 * cvv,Password.
	 * 
	 */
	public void paybydebitcardios(String CVV, String Password) throws Exception {
		try {
			boolean debitcard = isElementPresent_mobile(TdlMultitenderPage_Mobile.get().totalAmountHeaderDebit_ios);
			if (debitcard == true) {
				//logger.info("Debit card text present in multitender Page");
				fUtil.flogResult("Passed", "Debit card  text presence",
						"Debit card  text is present in multitender Page", 1);

				TdlMultitenderPage_Mobile.get().cvv_ios.sendKeys(CVV);
				TdlMultitenderPage_Mobile.get().payMultitender_ios.click();
				TdlSecurePage_Mobile.get().txtPassword_ios.sendKeys(Password);
				TdlSecurePage_Mobile.get().cmdSubmit_ios.click();
				boolean paynmentSuccessful = isElementVisible_mobile(
						TdlTransactionStatus_Mobile.get().paynmentSuccessful_android, 10);
				if (paynmentSuccessful == true) {
					//logger.info("Paynment successful message present in transaction status Page");
					fUtil.flogResult("Passed", "Security code presence",
							"Paynment successful message present in transaction status Page", 1);
				} else {
					//logger.error("Paynment successful message is not present in transaction status Page");
					fUtil.flogResult("Failed", "Paynment successful message is presence",
							"Paynment successful message is not present in transaction status Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paybynetbankingios This function will Validate Payment method
	 * text present in multitender Page, select payment method as netbanking,after
	 * complete payment its show Tranction status page,Pass / fail. Input Required :
	 * cvv,Password.
	 * 
	 */
	public void paybynetbankingios(String cvv) throws Exception {
		try {
			boolean paymentMethodTxt = isElementPresent_mobile(TdlMultitenderPage_Mobile.get().paymentsMethodsTxt_ios);
			if (paymentMethodTxt == true) {
				//logger.info("Payment method text present in multitender Page");
				fUtil.flogResult("Passed", "Payment method text presence",
						"Payment method text is present in multitender Page", 1);
				TdlMultitenderPage_Mobile.get().payMultitender_ios.click();
				boolean paynmentSuccessful = isElementVisible_mobile(
						TdlTransactionStatus_Mobile.get().paynmentSuccessful_ios, 10);
				if (paynmentSuccessful == true) {
					//logger.info("Paynment successful message present in transaction status Page");
					fUtil.flogResult("Passed", "Security code presence",
							"Paynment successful message present in transaction status Page", 1);
				} else {
					//logger.error("Paynment successful message is not present in transaction status Page");
					fUtil.flogResult("Failed", "Paynment successful message is presence",
							"Paynment successful message is not present in transaction status Page", 1);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paybytcppointsPWA This function will check total tcp points
	 * present in multitender Page and select payment method as TCP points if points
	 * available. Also it proceeds remaining payment with credit card or netbanking
	 * if sufficient tcp points are not available. Input Required : Amount, CVV,
	 * tcpCutOff, pay_by Author: Neha Dhuri (Quality Kiosk)
	 */

	public void paybytcppointsPWA(String amount, String CVV, String tcpCutoff, String pay_by, String bankname,
			String card) throws Exception {
		try {
			Robot robot = new Robot();
			if (isElementVisible(TdlMultitenderPage.get().tcpPoints, 10)) {
				String Points1[] = TdlMultitenderPage.get().tcpPoints.getText().split(" ");
				double availablePoints = Double.parseDouble(Points1[0]);
				TdlMultitenderPage.get().tcpPointsCheckbx.click();
				String Points2[] = TdlMultitenderPage.get().tcpPoints.getText().split("/");
				double selectedPoints = Double.parseDouble(Points2[0]);
				String rAmount[] = TdlMultitenderPage.get().pay.getText().split(" ");
				double remainingAmount = Double.parseDouble(rAmount[2].replace(",", ""));
				if (Double.parseDouble(amount) < availablePoints && Double.parseDouble(amount) <= selectedPoints
						&& Double.parseDouble(tcpCutoff) == 0) {
					TdlMultitenderPage.get().pay.click();
					if (isElementVisible(TdlTransactionStatus.get().paymentSuccessful, 10)) {
						TdlTransactionStatus.get().paymentDetailsArrow.click();
						robot.keyPress(KeyEvent.VK_PAGE_DOWN);
						robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
						fUtil.flogResult("Passed", "Payment successful by tcp points",
								"Payment successful Page is displayed", 1);
					} else {
						fUtil.flogResult("Failed", "Payment successful by tcp points",
								"Payment is not completed with successful payment", 1);
					}
				} else if (Double.parseDouble(amount) >= selectedPoints && Double.parseDouble(tcpCutoff) == 0) {
					if (remainingAmount == Double.parseDouble(amount) - selectedPoints) {
						fUtil.flogResult("Passed", "Verify remainig amount displayed on Pay button",
								"Accurate amount is displayed. So, proceeding for payment", 1);
						changepaymenttypePWA();
						paybycreditcardPWA(CVV, card);
						Double paidAmount = Double
								.parseDouble(TdlTransactionStatus.get().paidAmt.get(0).getText().replace("₹", ""))
								+ Double.parseDouble(
										TdlTransactionStatus.get().paidAmt.get(1).getText().replace("₹", ""));
						if (TdlTransactionStatus.get().paymentMode.get(0).getText().toUpperCase().contains("TCP")
								&& paidAmount == Double.parseDouble(amount)) {
							fUtil.flogResult("Passed",
									"Verify fractional/non-fractional amount payment is processed with loyalty points and credit card.",
									"Fractional/non-fractional amount payment is processed with loyalty points and credit card. Payment done by TCP: "
											+ Double.parseDouble(TdlTransactionStatus.get().paidAmt.get(0).getText()
													.replace("₹", ""))
											+ " Payment done by credit card: "
											+ Double.parseDouble(TdlTransactionStatus.get().paidAmt.get(1).getText()
													.replace("₹", "")),
									1);
						} else {
							fUtil.flogResult("Passed",
									"Verify fractional/non-fractional amount payment is processed with loyalty points and credit card.",
									"Fractional/non-fractional amount payment is not processed with loyalty points and credit card.",
									1);
						}

					}
				} else if (Double.parseDouble(tcpCutoff) > 0 && Double.parseDouble(tcpCutoff) <= selectedPoints) {
					TdlMultitenderPage.get().editCTA.click();
					TdlMultitenderPage.get().customTcpPointsInput.clear();
					TdlMultitenderPage.get().customTcpPointsInput.sendKeys(tcpCutoff);
					TdlMultitenderPage.get().confirmBtn.click();
					String Points3[] = TdlMultitenderPage.get().tcpPoints.getText().split("/");
					double editedPoints = Double.parseDouble(Points3[0]);
					String rAmount1[] = TdlMultitenderPage.get().pay.getText().split(" ");
					remainingAmount = Double.parseDouble(rAmount1[2].replace(",", ""));
					if (remainingAmount == Double.parseDouble(amount) - editedPoints) {
						fUtil.flogResult("Passed", "Verify anount remainig amount displayed on Pay button",
								"Accurate amount is displayed. So, proceeding for payments", 1);
						changepaymenttypePWA();
						switch (pay_by) {
						case "Tcp_points_and_netbanking":
							paybynetbankingPWA(bankname);
							Double paidByNetbanking = Double.parseDouble(
									TdlTransactionStatus.get().paidAmt.get(0).getText().replace("₹", ""));
							if (TdlTransactionStatus.get().paymentMode.get(0).getText().contains("NetBanking")
									&& paidByNetbanking == Double.parseDouble(amount)) {
								fUtil.flogResult("Passed",
										"To verify system does not allow user to use loyalty point plus net banking",
										"Whole amount is paid by netbanking transaction", 1);
							} else {
								fUtil.flogResult("Failed",
										"To verify system does not allow user to use loyalty point plus net banking",
										"Whole amount is not paid by netbanking transaction", 1);
							}
							break;
						default:
							paybycreditcardPWA(CVV, card);
							break;
						}
					} else {
						fUtil.flogResult("Failed", "Verify remainig amount displayed on Pay button",
								"Entered amount is not matched with remaining amount. So, payment is not proceeded", 1);
					}
				}

			} else {
				fUtil.flogResult("Failed", "Verify TCP points are available", "TCP points are not available", 1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paymentConfirmationForSuccessfulPaymentPWA This function
	 * confirms payment for successful payment and verifies that payment successful
	 * page is displayed Author: Neha Dhuri (Quality Kiosk)
	 */
	public void paymentConfirmationForSuccessfulPaymentPWA() throws Exception {
		try {
			Robot robot = new Robot();
			boolean paymentConfirmation = isElementVisible(TdlTransactionStatus.get().paymentConfirmation, 10);
			if (paymentConfirmation == true) {
				fUtil.flogResult("Passed", "Verify payment confirmation page", "Payment confirmation page is displayed",
						1);
				TdlTransactionStatus.get().successBtn.click();
				if (isElementVisible(TdlTransactionStatus.get().paymentSuccessful, 10)) {
					TdlTransactionStatus.get().paymentDetailsArrow.click();
					robot.keyPress(KeyEvent.VK_PAGE_DOWN);
					robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
					Thread.sleep(1000);
					fUtil.flogResult("Passed", "Payment successful", "Payment successful Page is displayed", 1);
				} else
					fUtil.flogResult("Failed", "Payment successful", "Payment is not completed with successful payment",
							1);

			} else {
				fUtil.flogResult("Failed", "Verify payment confirmation page",
						"Payment confirmation page is not displayed", 1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : validateUserIsOnHomePage This function will Validate wheather
	 * user land on homepage or not after any back navigation on pwa
	 * Modified for : SIT CYCLE1
	 * 
	 */
	public void validateUserIsOnHomePage() throws Exception {
		try {
			boolean vaultLinkInHomePage = isElementVisible(tcpHomePageMyAccount.get().vaultBtn, 20);

			if (vaultLinkInHomePage == true) {
				//logger.info("User land on homepage");
				fUtil.flogResult("Passed", "User Homepage", "User land on homepage", 1);
			} else {
				//logger.error("User Homepage loading failed !");
				fUtil.flogResult("Failed", "User Homepage", "User Homepage loading failed", 1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : validateUserIsOnHomePage_android This function will Validate
	 * wheather user land on account list page or not after any back navigation on
	 * mobile.
	 *
	 */
	public void validateUserIsOnAccountList(MobileElement prfileopt) throws Exception {
		try {
			boolean profileOpt = isElementVisible(prfileopt, 50);

			if (profileOpt == true) {
				//logger.info("User land on account list page");
				fUtil.flogResult("Passed", "User account list", "User land on homepage", 1);
			} else {
				//logger.error("User account list page loading failed !");
				fUtil.flogResult("Failed", "User account list", "User account list page loading failed", 1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Function name: validate_TCPCard_burnpointsCroma This function will validate
	 * if the Croma burn point is showing for a customer Input required:
	 * List<MobileElement> transDesc, List<MobileElement> earnPoint - android/ios
	 * Parameter taken from class : TDL_TCPCardPage_Mobile Parameter details :
	 * cardName - cardNameText_TCP_android/cardNameText_TCP_ios transDesc -
	 * transcDesc_TCP_android/transcDesc_TCP_ios burnPoint -
	 * pointsActivity_TCP_android/pointsActivity_TCP_ios
	 * 
	 * @param burnPoint
	 * @throws Exception
	 */
	public void validate_TCPCard_burnpointsCroma(MobileElement cardName, List<MobileElement> transDesc,
			List<MobileElement> burnPoint, String resource_id, String className) throws Exception {
		try {
			gmethods.validate_TCPCard(cardName);
			//logger.info("Verifying burn points activity for croma");
			// Thread.sleep(3000);
			// List<MobileElement> myDynamicElement = (new WebDriverWait(appiumDriver,
			// 100)).until(ExpectedConditions.visibilityOfAllElements(TdlTCPCardMobile.get().pointsActivity_TCP_android));
			MobileElement elem1 = burnPoint.get(0);
			boolean pointsEarnedVisibility = gmethods.isElementVisible_mobile(elem1, 20);
			if (pointsEarnedVisibility == true) {
				//logger.info("Verifying if burn points in TCP card is present for croma and is showing as -");
				Iterator<MobileElement> itr1 = transDesc.iterator();
				Iterator<MobileElement> itr2 = burnPoint.iterator();
				while (itr1.hasNext()) {
					MobileElement trans = itr1.next();
					MobileElement burn = itr2.next();
					if (trans.getText().contains("Croma") && burn.getText().contains("-")) {
						System.out.println(trans.getText());
						System.out.println(burn.getText());
						//logger.info("Customer has burned points for croma: " + trans.getText() + "  " + burn.getText());
						fUtil.flogResult("Passed", "Line item burn point verification for croma",
								"Customer has burned points for croma :" + trans.getText() + "  " + burn.getText(), 1);
						break;
					} else if (!(trans.getText().contains("Croma") && burn.getText().contains("-"))) {
						gmethods.scrollToElement_Mobile("+", resource_id, className);
						if (trans.getText().contains("Croma") && burn.getText().contains("-")) {
							System.out.println(trans.getText());
							System.out.println(burn.getText());
							//logger.info(
							//		"Customer has burned points for croma: " + trans.getText() + "  " + burn.getText());
							fUtil.flogResult("Passed", "Line item burn point verification for croma",
									"Customer has burned points for croma :" + trans.getText() + "  " + burn.getText(),
									1);
							break;
						}
					} else {
						//logger.fatal("Customer has no transaction for croma");
						fUtil.flogResult("Failed", "Line item earn point verification for croma",
								"Customer has no transaction for croma", 1);
						break;
					}
				}
			} else {
				//logger.fatal("Customer has no points");
				fUtil.flogResult("Failed", "Line item burn point verification", "Customer has no points", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function name: validate_TCPCard_burnpointsIHCL This function will validate if
	 * the IHCL earn point is showing for a customer Input required:
	 * List<MobileElement> transDesc, List<MobileElement> earnPoint - android/ios
	 * Parameter taken from class : TDL_TCPCardPage_Mobile Parameter details :
	 * cardName - cardNameText_TCP_android/cardNameText_TCP_ios transDesc -
	 * transcDesc_TCP_android/transcDesc_TCP_ios burnPoint -
	 * pointsActivity_TCP_android/pointsActivity_TCP_ios
	 * 
	 * @param burnPoint
	 * @throws Exception
	 */
	public void validate_TCPCard_burnpointsIHCL(MobileElement cardName, List<MobileElement> transDesc,
			List<MobileElement> burnPoint, String resource_id, String className) throws Exception {
		try {
			gmethods.validate_TCPCard(cardName);
			//logger.info("Verifying burn points activity for IHCL");
			// Thread.sleep(3000);
			// List<MobileElement> myDynamicElement = (new WebDriverWait(appiumDriver,
			// 100)).until(ExpectedConditions.visibilityOfAllElements(TdlTCPCardMobile.get().pointsActivity_TCP_android));
			MobileElement elem1 = burnPoint.get(0);
			boolean pointsBurnedVisibility = gmethods.isElementVisible_mobile(elem1, 20);
			if (pointsBurnedVisibility == true) {
				//logger.info("Verifying if burn points in TCP card is present for IHCL and is showing as -");
				Iterator<MobileElement> itr1 = transDesc.iterator();
				Iterator<MobileElement> itr2 = burnPoint.iterator();
				while (itr1.hasNext()) {
					MobileElement trans = itr1.next();
					MobileElement burn = itr2.next();
					if (trans.getText().contains("IHCL") && burn.getText().contains("-")) {
						System.out.println(trans.getText());
						System.out.println(burn.getText());
						//logger.info("Customer has burned points for IHCL: " + trans.getText() + "  " + burn.getText());
						fUtil.flogResult("Passed", "Line item burn point verification for IHCL",
								"Customer has burned points for IHCL :" + trans.getText() + "  " + burn.getText(), 1);
						break;
					} else if (!(trans.getText().contains("IHCL") && burn.getText().contains("-"))) {
						gmethods.scrollToElement_Mobile("+", resource_id, className);
						if (trans.getText().contains("IHCL") && burn.getText().contains("+")) {
							System.out.println(trans.getText());
							System.out.println(burn.getText());
							//logger.info(
							//		"Customer has burned points for IHCL: " + trans.getText() + "  " + burn.getText());
							fUtil.flogResult("Passed", "Line item burn point verification for IHCL",
									"Customer has burned points for IHCL :" + trans.getText() + "  " + burn.getText(),
									1);
							break;
						}
					} else {
						//logger.fatal("Customer has no transaction for IHCL");
						fUtil.flogResult("Failed", "Line item burn point verification for IHCL",
								"Customer has no transaction for IHCL", 1);
						break;
					}
				}
			} else {
				//logger.fatal("Customer has no points");
				fUtil.flogResult("Failed", "Line item burn point verification", "Customer has no points", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function name: validate_TCPCard_burnpoints This function will validate if the
	 * burn point is showing for a customer Input required: none
	 */
	public void validate_TCPCard_burnpoints() throws Exception {
		try {
			gmethods.validate_TCPCard();
			//logger.info("Verifying points activity");
			List<WebElement> myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 100))
					.until(ExpectedConditions.visibilityOfAllElements(TdlTcpCard.get().pointsActivity_TCP));
			boolean pointsEarnedVisibility = gmethods.isElementVisible(myDynamicElement.get(0), 20);
			if (pointsEarnedVisibility == true) {
				//logger.info("Verifying burn points in TCP card is present and is showing as -");
				Iterator<WebElement> itr1 = TdlTcpCard.get().transcDesc_TCP.iterator();
				Iterator<WebElement> itr2 = TdlTcpCard.get().pointsActivity_TCP.iterator();
				while (itr1.hasNext()) {
					WebElement trans = itr1.next();
					WebElement burn = itr2.next();
					if (trans.getText().contains("Croma") && burn.getText().contains("-")) {
						gmethods.highlightElement(trans);
						gmethods.highlightElement(burn);
						System.out.println(trans.getText());
						System.out.println(burn.getText());
						//logger.info("Customer has burned points for croma: " + trans.getText() + "  " + burn.getText());
						fUtil.flogResult("Passed", "Line item burn point verification",
								"Customer has burned points for croma :" + trans.getText() + "  " + burn.getText(), 1);
						break;
					} else if (!(trans.getText().contains("Croma"))) {
						//logger.fatal("Customer has no transaction for croma");
						fUtil.flogResult("Passed", "Line item burn point verification",
								"Customer has no transaction for croma", 1);
						break;
					}
				}
				while (itr1.hasNext()) {
					WebElement trans = itr1.next();
					WebElement burn = itr2.next();
					if (trans.getText().contains("IHCL") && burn.getText().contains("-")) {
						System.out.println(trans);
						System.out.println(burn);
						//logger.info("Customer has burned points for IHCL: " + trans + "  " + burn);
						fUtil.flogResult("Passed", "Line item burn point verification",
								"Customer has burned points for IHCL :" + trans + "  " + burn, 1);
						break;
					} else if (!(trans.getText().contains("IHCL"))) {
						//logger.fatal("Customer has no transaction for IHCL: " + trans + "  " + burn);
						fUtil.flogResult("Passed", "Line item burn point verification",
								"Customer has no transaction for IHCL :", 1);
						break;
					}

				}
			} else {
				//logger.fatal("Customer has no burned points for IHCL/croma");
				fUtil.flogResult("Failed", "Line item burn point verification",
						"Customer has no burned points for IHCL/croma", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This Function is to select date from registration page of PWA Input : Date (
	 * Format : 01/Jan/1990 or 01-Jan-1990) Owner : Anil - TCS
	 */
	public void datePickerPwa(String date) throws Exception {
		try {
			if (date.startsWith("~"))
				date = date.substring(1);

			String[] dob = null;

			if (date.contains("-"))
				dob = date.split("-");
			else if (date.contains("/"))
				dob = date.split("/");

			String userDate = dob[0];
			String userMonth = dob[1];
			Integer userYear = Integer.parseInt(dob[2].trim());
			String fullDate = "";

			TdlSignUp.get().dobTextbox.click();

			if (isElementVisible(TdlSignUp.get().datepickerYearTab, 20)) {
				TdlSignUp.get().datepickerYearTab.click();

				String activeYearTab = TdlSignUp.get().datepickerYearTab.getAttribute("class");

				if (activeYearTab.contains("active")) {

					//logger.info("Year Tab Selected from date picker");

					Integer firstVisibleYear = Integer.parseInt(TdlSignUp.get().yearTabFirstYear.getText().trim());

					while (userYear < firstVisibleYear) {
						TdlSignUp.get().previousYearPageBtn.click();
						firstVisibleYear = Integer.parseInt(TdlSignUp.get().yearTabFirstYear.getText().trim());

					}
					BrowserFactory.webDriver.get()
							.findElement(
									By.xpath("//*[@id='year-body']/tr/td/span[contains(text(),'" + userYear + "')]"))
							.click();

					fullDate = TdlSignUp.get().fullDateDatePickerModal.getText();

					if (fullDate.endsWith(userYear.toString())) {
						//logger.info("Year Selected from date picker");

						// TdlSignUp.get().nextBtnYearTab.click();

						String activeMonthTab = TdlSignUp.get().datepickerMonthTab.getAttribute("class");

						if (activeMonthTab.contains("active")) {
							//logger.info("Month Tab Selected from date picker");

							BrowserFactory.webDriver.get()
									.findElement(By.xpath(
											"//*[@id='months-body']/tr/td/span[contains(text(),'" + userMonth + "')]"))
									.click();

							String activeMonth = BrowserFactory.webDriver.get().findElement(By.xpath(
									"//*[@id='months-body']/tr/td/span[contains(text(),'" + userMonth + "')]/.."))
									.getAttribute("class");

							if (activeMonth.contains("active")) {

								//logger.info("Month Selected from date picker");
								// TdlSignUp.get().nextBtnMonthTab.click();

								String activeDayTab = TdlSignUp.get().datepickerDateTab.getAttribute("class");
								if (activeDayTab.contains("active")) {
									//logger.info("Day Tab Selected from date picker");
									BrowserFactory.webDriver.get()
											.findElement(By.xpath(
													"//*[@id='calendar-body']/tr/td/span[text()='" + userDate + "']"))
											.click();

									/*
									 * String activeDay=BrowserFactory.webDriver.get().findElement(By.xpath(
									 * "//*[@id='calendar-body']/tr/td/span[text()='"+userDate+"']/..")).
									 * getAttribute("class"); if(activeDay.contains("active")) {
									 * 
									 * //logger.info("Day Selected from date picker");
									 * 
									 * if(isElementVisible(TdlSignUp.get().saveDate, 15)) {
									 * TdlSignUp.get().saveDate.click(); fUtil.flogResult("Passed", "Date of birth",
									 * "DOB Entered", 1); } } else {
									 * //logger.fatal("Day Not Selected from date picker"); fUtil.flogResult("Failed",
									 * "Date Of Birth", "Day Not Selected from date picker", 1); }
									 */
								} else {
									//logger.fatal("Day Tab Not Selected from date picker");
									fUtil.flogResult("Failed", "Date Of Birth", "Day Tab Not Selected from date picker",
											1);
								}
							} else {
								//logger.fatal("Month Not Selected from date picker");
								fUtil.flogResult("Failed", "Date Of Birth", "Month Not Selected from date picker", 1);
							}
						} else {
							//logger.fatal("Month Tab Not Selected from date picker");
							fUtil.flogResult("Failed", "Date Of Birth", "Month Tab Not Selected from date picker", 1);
						}
					} else {
						//logger.fatal("Year Not Selected from date picker");
						fUtil.flogResult("Failed", "Date Of Birth", "Year Not Selected from date picker", 1);
					}
				} else {
					//logger.fatal("Year Tab Not Selected from date picker");
					fUtil.flogResult("Failed", "Date Of Birth", "Year Tab Not Selected from date picker", 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isElementVisible_mobile(By by, int time) {
		try {
			if (isElementPresent(appiumDriver.get().findElement(by)) == false) {
				WebDriverWait wt = new WebDriverWait(appiumDriver.get(), time);
				wt.until(ExpectedConditions.visibilityOf(appiumDriver.get().findElement(by)));

				if (appiumDriver.get().findElement(by).isDisplayed())
					return true;
				else
					return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//logger.fatal("Expected elemnt not visible");
			return false;
		}
	}

	/**
	 * Function name: validate_SingleTransaction_CromaCard This function validates
	 * if Croma card has any transactions Input required: List<MobileElement>
	 * transDesc, List<MobileElement> earnPoint - android/ios Parameter taken from
	 * class : TDL_TCPCardPage_Mobile Parameter details : cardName -
	 * cardNameText_TCP_android/cardNameText_TCP_ios transDesc -
	 * transcDesc_TCP_android/transcDesc_TCP_ios burnPoint -
	 * pointsActivity_TCP_android/pointsActivity_TCP_ios
	 * 
	 * @throws Exception
	 */

	public void validate_SingleTransaction_CromaCard() throws Exception {
		try {
			gmethods.validate_CromaCard();
			//logger.info("Verifying transaction activity");
			List<WebElement> myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 100))
					.until(ExpectedConditions.visibilityOfAllElements(TdlCromaCard.get().transcActivity_Croma));
			WebElement element = myDynamicElement.get(0);
			boolean transactionVisibility = gmethods.isElementVisible(element, 20);
			if (transactionVisibility == true) {
				String transDesc = TdlCromaCard.get().transcDesc_Croma.get(0).getText();
				gmethods.highlightElement(TdlCromaCard.get().transcDesc_Croma.get(0));
				String transDate = TdlCromaCard.get().transcDate_Croma.get(0).getText();
				gmethods.highlightElement(TdlCromaCard.get().transcDate_Croma.get(0));
				String transAmt = TdlCromaCard.get().transcActivity_Croma.get(0).getText();
				gmethods.highlightElement(TdlCromaCard.get().transcActivity_Croma.get(0));
				System.out
						.println("Transaction line item is: " + transDesc + " done on " + transDate + " : " + transAmt);
				//logger.info("Transaction " + " : " + transDesc + " done on " + transDate + " : " + transAmt);
				fUtil.flogResult("Passed", "Trnsaction details",
						"Transaction " + " : " + transDesc + " done on " + transDate + " : " + transAmt, 1);
			} else {
				//logger.error("Transaction is not visible");
				fUtil.flogResult("Failed", "Trnsaction details", "Transaction is not visible", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function name: validate_SingleTransaction_CromaCard This function validates
	 * if Croma card has any transactions Input required: List<MobileElement>
	 * transDesc, List<MobileElement> earnPoint - android/ios Parameter taken from
	 * class : TDL_TCPCardPage_Mobile Parameter details : cardName -
	 * cardNameText_TCP_android/cardNameText_TCP_ios transDesc -
	 * transcDesc_TCP_android/transcDesc_TCP_ios burnPoint -
	 * pointsActivity_TCP_android/pointsActivity_TCP_ios
	 * 
	 * @throws Exception
	 */

	public void validate_MultiTransaction_CromaCard() throws Exception {
		try {
			gmethods.validate_CromaCard();

			System.out.println("validatepoints");
			//logger.info("Verifying transaction activity");
			List<WebElement> myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 100))
					.until(ExpectedConditions.visibilityOfAllElements(TdlCromaCard.get().transcActivity_Croma));
			WebElement element = myDynamicElement.get(0);
			boolean transactionVisibility = gmethods.isElementVisible(element, 20);
			if (transactionVisibility == true) {
				int noOfTransactions = TdlCromaCard.get().transcActivity_Croma.size();

				// int itr = Integer.parseInt(noOfTransactions);
				for (int i = 0; i < noOfTransactions; i++) {
					String transDesc = TdlCromaCard.get().transcDesc_Croma.get(i).getText();
					gmethods.highlightElement(TdlCromaCard.get().transcDesc_Croma.get(i));
					String transDate = TdlCromaCard.get().transcDate_Croma.get(i).getText();
					gmethods.highlightElement(TdlCromaCard.get().transcDate_Croma.get(i));
					String transAmt = TdlCromaCard.get().transcActivity_Croma.get(i).getText();
					gmethods.highlightElement(TdlCromaCard.get().transcActivity_Croma.get(i));
					System.out.println("Transaction line item " + i + " is: " + transDesc + " done on " + transDate
							+ " : " + transAmt);
					//logger.info("Transaction " + i + " : " + transDesc + " done on " + transDate + " : " + transAmt);
					fUtil.flogResult("Passed", "Trnsaction details",
							"Transaction " + i + " : " + transDesc + " done on " + transDate + " : " + transAmt, 1);
				}
			} else {
				//logger.error("Transaction is not visible");
				fUtil.flogResult("Failed", "Trnsaction details", "Transaction is not visible", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function name: scrollToViewElementMobile Parameter details :
	 * 
	 * @author@niren
	 */

	public boolean scrollToViewElementMobile(MobileElement obj) throws Exception {
		boolean flag = false;
		try {
			WaitForObject(obj);
			JavascriptExecutor executor = (JavascriptExecutor) appiumDriver.get();
			executor.executeScript("arguments[0].scrollIntoView();", obj);
			appiumDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean scrollToViewElement(WebElement obj) throws Exception {
		boolean flag = false;
		try {
			WaitForObject(obj);
			JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.webDriver.get();
			executor.executeScript("arguments[0].scrollIntoView();", obj);
			BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void scrollmethod() throws Exception {

		try {
			TouchAction ts = new TouchAction(appiumDriver.get());
			ts.press(PointOption.point(543, 1766)).moveTo(PointOption.point(499, 1475)).release().perform();
		} catch (Exception e) {
			//logger.error("Exception thrown: " + e.getMessage());
			fUtil.flogResult("Failed", "Code is throwing exception", e.getMessage(), 0);
		}
	}

	/*
	 * Function name : validateErrorInUserHomePageMobile This function will Validate
	 * if error page is displayed in Mobile device
	 * 
	 */
	public void validateErrorInUserHomePageMobile() throws Exception {
		try {
			boolean forYouLabelPresence = isElementVisible_mobile(TdlHomeMobile.get().forYouLabel_ios_android, 20);
			if (forYouLabelPresence) {
				fUtil.flogResult("Passed", "User Homepage", "Home page loaded properly. ", 1);
			} else {
				fUtil.flogResult("Failed", "User Homepage",
						"Home page not loaded properly. Error in the Home page or Page not loaded completely .", 1);
			}
			/*
			 * boolean errorInHomePage=isElementVisible_mobile(TdlHomeMobile.get().
			 * ErrorHomePage_ios_android,10); boolean
			 * retryBtnErrorInHomePage=isElementVisible_mobile(TdlHomeMobile.get().
			 * ErrorPageRetryBtn_ios_android,10);
			 * 
			 * if (errorInHomePage == true || retryBtnErrorInHomePage == true ) {
			 * //logger.error("Error in Homepage"); fUtil.flogResult("Failed",
			 * "User Homepage", "Home page not loaded properly. Error in the Home page", 1);
			 * } else { fUtil.flogResult("Passed", "User Homepage",
			 * "Home page loaded properly", 1); }
			 */
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateErrorInUserHomePageMobile",
					"Exception Caught :" + e.getMessage(), 0);
		}
	}

	/**
	 * Function name: validate_MultiTransaction_CromaCard This function validates if
	 * Croma card has any transactions Input required: MobileElement cardName,
	 * List<MobileElement> transDescr,List<MobileElement> transDater,
	 * List<MobileElement> transActivity - android/ios Parameter taken from class :
	 * TDL_CromaCardPage_Mobile Parameter details : transDesc -
	 * transcDesc_Croma_android/transcDesc_Croma_ios transActivity -
	 * pointsActivity_Croma_android/pointsActivity_Croma_ios
	 * 
	 * @throws Exception
	 */
	public void validate_MultiTransaction_CromaCard(MobileElement cardName, List<MobileElement> transDescr,
			List<MobileElement> transDater, List<MobileElement> transActivity) throws Exception {
		try {
			gmethods.validate_CromaCard(cardName);
			//logger.info("Verifying transaction activity");
			Thread.sleep(5000);
			MobileElement element = TdlTCPCardMobile.get().pointsActivity_TCP_ios.get(0);
			boolean transactionVisibility = gmethods.isElementVisible_mobile(element, 20);
			if (transactionVisibility == true) {
				String noOfTransactions = fUtil.fgetDataNew1("Trans_no");
				int itr = Integer.parseInt(noOfTransactions);
				for (int i = 0; i < itr; i++) {
					String transDesc = transDescr.get(i).getText();
					String transDate = transDater.get(i).getText();
					String transAmt = transActivity.get(i).getText();
					System.out.println(
							"1st transaction line item is: " + transDesc + " done on " + transDate + " : " + transAmt);
					//logger.info("Transaction " + i + " : " + transDesc + " done on " + transDate + " : " + transAmt);
					fUtil.flogResult("Passed", "Trnsaction details",
							"Transaction " + i + " : " + transDesc + " done on " + transDate + " : " + transAmt, 1);
				}
			} else {
				//logger.error("Transaction is not visible");
				fUtil.flogResult("Failed", "Trnsaction details", "Transaction is not visible", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function name: validate_SingleTransaction_CromaCard This function validates
	 * if Croma card has any transactions Input required: MobileElement cardName,
	 * List<MobileElement> transDescr,List<MobileElement> transDater,
	 * List<MobileElement> transActivity - android/ios Parameter taken from class :
	 * TDL_CromaCardPage_Mobile Parameter details : transDesc -
	 * transcDesc_Croma_android/transcDesc_Croma_ios transActivity -
	 * pointsActivity_Croma_android/pointsActivity_Croma_ios
	 * 
	 * @throws Exception
	 */
	public void validate_SingleTransaction_CromaCard(MobileElement cardName, List<MobileElement> transDescr,
			List<MobileElement> transDater, List<MobileElement> transActivity) throws Exception {
		try {
			gmethods.validate_CromaCard(cardName);
			//logger.info("Verifying transaction activity");
			Thread.sleep(5000);
			MobileElement element = transActivity.get(0);
			boolean transactionVisibility = gmethods.isElementVisible_mobile(element, 20);
			if (transactionVisibility == true) {
				String transDesc = TdlCromaCardMobile.get().transcDesc_Croma_ios.get(0).getText();
				String transDate = TdlCromaCardMobile.get().transcDate_Croma_ios.get(0).getText();
				String transAmt = TdlCromaCardMobile.get().pointsActivity_Croma_ios.get(0).getText();
				System.out.println(
						"1st transaction line item is: " + transDesc + " done on " + transDate + " : " + transAmt);
				//logger.info("Transaction " + " : " + transDesc + " done on " + transDate + " : " + transAmt);
				fUtil.flogResult("Passed", "Trnsaction details",
						"Transaction " + " : " + transDesc + " done on " + transDate + " : " + transAmt, 1);
			} else {
				//logger.error("Transaction is not visible");
				fUtil.flogResult("Failed", "Trnsaction details", "Transaction is not visible", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : Validate_Near_by_Popular_Offers_More_Filters_ButtonsMobile
	 * This function will Validate Near by, Popular Offers, More Filters buttons in
	 * Mobile
	 * 
	 */
	public void Validate_Near_by_Popular_Offers_More_Filters_ButtonsMobile(MobileElement clickNearByOption,
			MobileElement brand_Filter_Button, MobileElement popular_offers_Text, MobileElement more_Filter_Button,
			MobileElement categoryFilter) throws Exception {

		try {
			boolean Near_by = gmethods.isElementPresent(clickNearByOption);
			if (Near_by == true) {
				//logger.info("Near by button in discover page\n");
				fUtil.flogResult("Passed", "Near By button in Discover page",
						"Near By button is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Near By Button should visible in the discover page",
						"Near by button is not visible in the discovery page", 1);
			}

			boolean brandFlag = gmethods.isElementPresent(brand_Filter_Button);
			if (brandFlag == true) {
				//logger.info("Popular Offers button in discover page\n");
				fUtil.flogResult("Passed", "Popular Offers button in Discover page",
						"Popular Offers button is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Popular Offers Button should visible in the discover page",
						"Popular Offers button is not visible in the discovery page", 1);
			}

			boolean Popular_offers_flag = gmethods.isElementPresent(popular_offers_Text);
			if (Popular_offers_flag == true) {
				//logger.info("Popular Offers Text in discover page\n");
				fUtil.flogResult("Passed", "Popular Offers Text in Discover page",
						"Popular Offers Text is present in Discover page", 1);
			} else {
				fUtil.flogResult("Failed", "Popular Offers Button should visible in the discover page",
						"Popular Offers button is not visible in the discovery page", 1);
			}

			boolean morefilterFlag = gmethods.isElementPresent(more_Filter_Button);
			if (morefilterFlag == true) {
				//logger.info("Popular Offers button in discover page\n");
				fUtil.flogResult("Passed", "Popular Offers button in Discover page",
						"Popular Offers button is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Popular Offers Button should visible in the discover page",
						"Popular Offers button is not visible in the discovery page", 1);
			}
			boolean categoryFlag = gmethods.isElementPresent(categoryFilter);
			if (categoryFlag == true) {
				//logger.info("Popular Offers Text in discover page\n");
				fUtil.flogResult("Passed", "Popular Offers Text in Discover page",
						"Popular Offers Text is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Popular Offers Text should visible in the discover page",
						"Popular Offers Text is not visible in the discovery page", 1);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "User should navigate to Offer discovery page",
					"Unable to navigate to discovery page" + ee, 1);
			//logger.error("Error verify offers" + ee);
		}

	}
	/*
	 * Function name : Click_And_Validate_FilterByBrand_ButtonAndroidMobile This
	 * function will click and validate FilterBy Brand Button And Mobile
	 * 
	 */

	public void Click_And_Validate_FilterByBrand_ButtonAndroidMobile(MobileElement filterByBrand) throws Exception {

		try {
			boolean Brand_Filter = gmethods.isElementVisible(filterByBrand, 20);
			if (Brand_Filter) {
				filterByBrand.click();
				fUtil.flogResult("Passed", "Visibilty of brand Filter", "Brand Filter is visible in Discovery page", 1);
			} else {
				fUtil.flogResult("Failed", "Visibilty of brand Filter", "Brand Filter is not visible in Discovery page",
						1);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "User should navigate to Offer discovery page",
					"Unable to navigate to discovery page" + ee, 1);
			//logger.error("Error verify offers" + ee);
		}

	}
	/*
	 * Function name : Click_On_Offers_Under_Recomended_Offers This function will
	 * click on offers under Recomended Offers
	 * 
	 */

	public void Click_On_Offers_Under_Recomended_Offers() {
		try {
			gmethods.scrollToViewElement(MyOffersPage.get().Recomended_Offers);
			String Offer_value = fUtil.fgetDataNew1("Offer_Value");
			String xapth = "(//*[normalize-space(text())='" + Offer_value + "'])[1]";
			WebElement wb = BrowserFactory.webDriver.get().findElement(By.xpath(xapth));
			boolean Is_Offer_Present = gmethods.isElementVisible(wb, 30);
			if (Is_Offer_Present) {
				gmethods.fClickOnButton(wb, "Click on one Recoended Offer", "Recomended offer", 1);
				gmethods.switchToNewTab();
				gmethods.fClickOnButton(MyOffersPage.get().btn_More_Information, "Click on More information",
						"More information", 1);
				boolean is_header_present = gmethods.isElementVisible(MyOffersPage.get().img_logo, 30);
				if (is_header_present) {
					fUtil.flogResult("Passed", "Click on more information button",
							"More information button is working as expected", 1);
				} else {
					fUtil.flogResult("Failed", "Click on more information button",
							"More information button is not working as expected", 1);
				}
			} else {
				boolean is_header_present = false;
				int count = 1;
				for (int i = 1; i <= count; i++) {
					gmethods.fClickOnButton(MyOffersPage.get().btn_Img_Icon, "Click on right image icon", "Image Icon",
							1);
					is_header_present = gmethods.isElementVisible(MyOffersPage.get().img_logo, 10);
					count++;
				}
				if (is_header_present) {
					fUtil.flogResult("Passed", "Click on more information button",
							"More information button is working as expected", 1);
				} else {
					fUtil.flogResult("Failed", "Click on more information button",
							"More information button is not working as expected", 1);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//logger.error("Error verify offers" + e);
		}
	}

	/*
	 * Function name : Click_On_Offers_Under_Offers_Expiring_Soons This function
	 * will click on offers under Offers Expiring Soons
	 * 
	 */
	public void Click_On_Offers_Under_Offers_Expiring_Soons() {
		try {
			gmethods.scrollToViewElement(MyOffersPage.get().Offers_Expiring_Soon_Txt);
			String Offer_value = fUtil.fgetDataNew1("Offer_Value").trim();
			String xapth = "//*[normalize-space(text())='Offers Expiring Soon']/following::*[normalize-space(text())='"
					+ Offer_value + "']";
			WebElement wb = BrowserFactory.webDriver.get().findElement(By.xpath(xapth));
			boolean Is_Offer_Present = gmethods.isElementVisible(wb, 30);
			if (Is_Offer_Present) {
				gmethods.fClickOnButton(wb, "Click on one Offers Expiring soon", "Offers Expiring soon", 1);
				gmethods.switchToNewTab();
			} else {
				boolean is_header_present = false;
				int count = 1;
				for (int i = 1; i <= count; i++) {
					gmethods.fClickOnButton(MyOffersPage.get().btn_Img_Icon, "Click on right image icon", "Image Icon",
							1);
					is_header_present = gmethods.isElementVisible(MyOffersPage.get().img_logo, 10);
					count++;
				}
				if (is_header_present) {
					fUtil.flogResult("Passed", "Click on more information button",
							"More information button is working as expected", 1);
				} else {
					fUtil.flogResult("Failed", "Click on more information button",
							"More information button is not working as expected", 1);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//logger.error("Error verify offers" + e);
		}
	}

	/*
	 * Function name : Click_On_Offers_Under_Offers_Expiring_Soons_Mobile This
	 * function will click on offers under Offers Expiring Soons Mobile
	 * 
	 */
	public void Click_On_Offers_Under_Offers_Expiring_Soons_Mobile(MobileElement offers_Expiring_Soon_Txt,
			MobileElement btn_More_Information, MobileElement img_logo, MobileElement btn_Img_Icon) {
		try {
			gmethods.scrollToViewElement(offers_Expiring_Soon_Txt);
			String Offer_value = fUtil.fgetDataNew1("Offer_Value");
			String xapth = "(//*[normalize-space(text())='" + Offer_value + "'])[11]";
			MobileElement mb = appiumDriver.get().findElement(By.xpath(xapth));
			boolean Is_Offer_Present = gmethods.isElementVisible(mb, 30);
			if (Is_Offer_Present) {
				gmethods.fClickOnButton(mb, "Click on one Offers Expiring soon", "Offers Expiring soon", 1);
				gmethods.switchToNewTab();
				gmethods.fClickOnButton(btn_More_Information, "Click on More information", "More information", 1);
				boolean is_header_present = gmethods.isElementVisible(img_logo, 30);
				if (is_header_present) {
					fUtil.flogResult("Passed", "Click on more information button",
							"More information button is working as expected", 1);
				} else {
					fUtil.flogResult("Failed", "Click on more information button",
							"More information button is not working as expected", 1);
				}
			} else {
				boolean is_header_present = false;
				int count = 1;
				for (int i = 1; i <= count; i++) {
					gmethods.fClickOnButton(btn_Img_Icon, "Click on right image icon", "Image Icon", 1);
					is_header_present = gmethods.isElementVisible(img_logo, 10);
					count++;
				}
				if (is_header_present) {
					fUtil.flogResult("Passed", "Click on more information button",
							"More information button is working as expected", 1);
				} else {
					fUtil.flogResult("Failed", "Click on more information button",
							"More information button is not working as expected", 1);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//logger.error("Error verify offers" + e);
		}
	}

	/*
	 * Function name :
	 * Validate_Input_Field_Near_by_Brands_Filters_More_Filter_Popular_Offers This
	 * function will
	 * Validate_Input_Field_Near_by_Brands_Filters_More_Filter_Popular_Offers
	 * 
	 */
	public void Validate_Input_Field_Near_by_Brands_Filters_More_Filter_Popular_Offers() throws Exception {

		try {
			boolean is_Input_Field = gmethods.isElementVisible(MyOffersPage.get().input_search_in_discovery_page, 20);
			if (is_Input_Field) {
				//logger.info("Input field in discovery page");
				fUtil.flogResult("Passed", "Input field in discovery page", "Input field is present in discovery page",
						1);
			} else {
				fUtil.flogResult("Failed", "Input field in discovery page",
						"Input field should present in the discovery page", 1);
			}
			boolean Near_by = gmethods.isElementPresent(MyOffersPage.get().clickNearByOption);
			if (Near_by == true) {
				//logger.info("Near by button in discover page\n");
				fUtil.flogResult("Passed", "Near By button in Discover page",
						"Near By button is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Near By Button should visible in the discover page",
						"Near by button is not visible in the discovery page", 1);
			}
			/*
			 * boolean is_brand_filter =
			 * gmethods.isElementVisible(MyOffersPage.get().Brands_filter,20); if
			 * (is_brand_filter == true) {
			 * //logger.info("Brand Filter button in discover page\n");
			 * fUtil.flogResult("Passed", "Brand Filter button in Discover page",
			 * "Brand filter button is present in Discover page", 1);
			 * 
			 * }else { fUtil.flogResult("Failed",
			 * "Brand filter Button should visible in the discover page",
			 * "Brand filter button is not visible in the discovery page", 1); } boolean
			 * is_filter = gmethods.isElementVisible(MyOffersPage.get().filter,10); if
			 * (is_filter == true) { //logger.info("Filter button in discover page\n");
			 * fUtil.flogResult("Passed", "Category Filter button in Discover page",
			 * "Category Filter button is present in Discover page", 1);
			 * 
			 * }else { fUtil.flogResult("Failed",
			 * "Filter Button should visible in the discover page",
			 * "Filter button is not visible in the discovery page", 1); } boolean
			 * More_Filters =
			 * gmethods.isElementVisible(MyOffersPage.get().More_Filter_Button,10); if
			 * (More_Filters == true) {
			 * //logger.info("More Filter button in discover page\n");
			 * fUtil.flogResult("Passed", "More Filter button in Discover page",
			 * "More Filter button is present in Discover page", 1);
			 * 
			 * }else { fUtil.flogResult("Failed",
			 * "More Filters Button should visible in the discover page",
			 * "More Filters button is not visible in the discovery page", 1); }
			 */
			boolean Popular_offers_Text = gmethods.isElementVisible(MyOffersPage.get().Popular_offers_Text, 10);
			if (Popular_offers_Text == true) {
				//logger.info("Popular Offers Text in discover page\n");
				fUtil.flogResult("Passed", "Popular Offers Text in Discover page",
						"Popular Offers Text is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Popular Offers Text should visible in the discover page",
						"Popular Offers Text is not visible in the discovery page", 1);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "User should navigate to Offer discovery page",
					"Unable to navigate to discovery page" + ee, 1);
			//logger.error("Error verify offers" + ee);
		}
	}
	/*
	 * Function name :
	 * Validate_Input_Field_Near_by_Brands_Filters_More_Filter_Popular_OffersMobile
	 * This function will
	 * Validate_Input_Field_Near_by_Brands_Filters_More_Filter_Popular_OffersMobile
	 * 
	 */

	public void Validate_Input_Field_Near_by_Brands_Filters_More_Filter_Popular_OffersMobile(MobileElement input_search,
			MobileElement clickNearByOption, MobileElement brands_filter, MobileElement category_filter)
			throws Exception {

		try {
			boolean is_Input_Field = gmethods.isElementVisible(input_search, 20);
			if (is_Input_Field) {
				//logger.info("Input field in discovery page");
				fUtil.flogResult("Passed", "Input field in discovery page", "Input field is present in discovery page",
						1);
			} else {
				fUtil.flogResult("Failed", "Input field in discovery page",
						"Input field should present in the discovery page", 1);
			}
			boolean Near_by = gmethods.isElementPresent(clickNearByOption);
			if (Near_by == true) {
				//logger.info("Near by button in discover page\n");
				fUtil.flogResult("Passed", "Near By button in Discover page",
						"Near By button is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Near By Button should visible in the discover page",
						"Near by button is not visible in the discovery page", 1);
			}
			boolean is_brand_filter = gmethods.isElementPresent(brands_filter);
			if (is_brand_filter == true) {
				//logger.info("Brand Filter button in discover page\n");
				fUtil.flogResult("Passed", "Brand Filter button in Discover page",
						"Brand filter button is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Brand filter Button should visible in the discover page",
						"Brand filter button is not visible in the discovery page", 1);
			}
			boolean is_filter = gmethods.isElementPresent(category_filter);
			if (is_filter == true) {
				//logger.info("Filter button in discover page\n");
				fUtil.flogResult("Passed", "Category Filter button in Discover page",
						"Category Filter button is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Filter Button should visible in the discover page",
						"Filter button is not visible in the discovery page", 1);
			}
			boolean More_Filters = gmethods.isElementPresent(MyOffersPage.get().More_Filter_Button);
			if (More_Filters == true) {
				//logger.info("More Filter button in discover page\n");
				fUtil.flogResult("Passed", "More Filter button in Discover page",
						"More Filter button is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "More Filters Button should visible in the discover page",
						"More Filters button is not visible in the discovery page", 1);
			}
			boolean Popular_offers_Text = gmethods.isElementPresent(MyOffersPage.get().Popular_offers_Text);
			if (Popular_offers_Text == true) {
				//logger.info("Popular Offers Text in discover page\n");
				fUtil.flogResult("Passed", "Popular Offers Text in Discover page",
						"Popular Offers Text is present in Discover page", 1);

			} else {
				fUtil.flogResult("Failed", "Popular Offers Text should visible in the discover page",
						"Popular Offers Text is not visible in the discovery page", 1);
			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "User should navigate to Offer discovery page",
					"Unable to navigate to discovery page" + ee, 1);
			//logger.error("Error verify offers" + ee);
		}
	}

	/*
	 * Function name : validateVaultLinkInUserHomePageIos This function will
	 * Validate if error page is displayed in Mobile device
	 * 
	 */
	public void validateErrorInPagePwa() throws Exception {
		try {
			boolean errorInHomePage = isElementVisible(TdlSignUp.get().ErrorHomePage_pwa, 5);

			if (errorInHomePage == true) {
				//logger.error("Error in Page");
				fUtil.flogResult("Failed", "Error Page", "Error in Page is Present", 1);
			} else {
				//logger.info("No Error in Page");
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateErrorInPagePwa",
					"Exception Caught : " + e.getMessage(), 1);
		}
	}

	/*
	 * This Function is to select date from registration page of PWA Input : Date (
	 * Format : 01/Jan/1990 or 01-Jan-1990)s
	 */
	public void datePickerPwa(String date, WebElement oDate) throws Exception {
		try {

			if (date.startsWith("~"))
				date = date.substring(1);

			String[] dob = null;

			if (date.contains("-"))
				dob = date.split("-");
			else if (date.contains("/"))
				dob = date.split("/");

			String userDate = dob[0];
			String userMonth = dob[1];
			Integer userYear = Integer.parseInt(dob[2].trim());
			String fullDate = "";
			if (userDate.startsWith("0"))
				userDate = userDate.replace("0", "");

			oDate.click();

			if (isElementVisible(TdlPaymentCardPWA.get().datepickerYearTab, 20)) {
				TdlPaymentCardPWA.get().datepickerYearTab.click();

				//logger.info("Year  Tab Selected from date picker");

				List<WebElement> allYrList = TdlPaymentCardPWA.get().allYearlist;

				Integer firstVisibleYear = Integer.parseInt(allYrList.get(0).getText().trim());
				Integer lastVisibleYear = Integer.parseInt(allYrList.get(allYrList.size() - 1).getText().trim());

				while (userYear < firstVisibleYear) {
					TdlPaymentCardPWA.get().previousYearPageBtn.click();
					firstVisibleYear = Integer.parseInt(TdlPaymentCardPWA.get().allYearlist.get(0).getText().trim());
				}

				if (userYear > lastVisibleYear) {
					TdlPaymentCardPWA.get().nextYearPageBtn.click();
					allYrList = TdlPaymentCardPWA.get().allYearlist;
					lastVisibleYear = Integer.parseInt(allYrList.get(allYrList.size() - 1).getText().trim());
				}

				isElementVisible(BrowserFactory.webDriver.get()
						.findElement(By.xpath("//div[contains(@id,'" + userYear + "')]//span")), 10);
				BrowserFactory.webDriver.get().findElement(By.xpath("//div[contains(@id,'" + userYear + "')]//span"))
						.click();

				// label[contains(text(),2014)]

				fullDate = browserFactory.get().getDriver()
						.findElement(By.xpath("//label[contains(text(),'" + userYear + "')]")).getText();

				if (fullDate.endsWith(userYear.toString())) {
					//logger.info("Year Selected from date picker");

					isElementVisible(BrowserFactory.webDriver.get()
							.findElement(By.xpath("//div[contains(@id,'" + userMonth + "')]//span")), 10);
					BrowserFactory.webDriver.get()
							.findElement(By.xpath("//div[contains(@id,'" + userMonth + "')]//span")).click();

					//logger.info("Month Selected from date picker");

					isElementVisible(
							BrowserFactory.webDriver.get().findElement(By.xpath("//div[@id='" + userDate + "']")), 20);
					BrowserFactory.webDriver.get().findElement(By.xpath("//div[@id='" + userDate + "']//span")).click();

					//logger.info("Day Selected from date picker");

					if (isElementVisible(oDate, 10)) {
						fUtil.flogResult("Passed", "Date Entered", "Date entered successfully", 1);
					} else {
						//logger.fatal("Day Not Selected from date picker");
						fUtil.flogResult("Failed", "Date Of Birth", "Day Not Selected from date picker", 1);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * paybytcppointsonlyPWA Pay complete amount with tcp points only
	 * 
	 */
	public void paybytcppointsonlyPWA(String amount) throws Exception {
		try {
			boolean tcpPointCheckBox = isElementVisible(TdlMultitenderPage.get().tcpPointsCheckbx, 10);

			Robot robot = new Robot();

			if (isElementVisible(TdlMultitenderPage.get().tcpPointsCheckbx, 10)) {
				TdlMultitenderPage.get().tcpPointsCheckbx.click();
				String rAmount[] = TdlMultitenderPage.get().pay.getText().split(" ");
				double remainingAmount = Double.parseDouble(rAmount[2].replace(",", ""));

				if (remainingAmount == 0.0) {
					if (TdlMultitenderPage.get().pay.isEnabled()) {
						TdlMultitenderPage.get().pay.click();

						if (TdlTransactionStatus.get().errPopupobjects.isEmpty()) {
							if (isElementVisible(TdlTransactionStatus.get().paymentSuccessful, 10)) {
								TdlTransactionStatus.get().paymentDetailsArrow.click();
								robot.keyPress(KeyEvent.VK_PAGE_DOWN);
								robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
								fUtil.flogResult("Passed", "Payment successful by tcp points",
										"Payment successful Page is displayed", 1);
							} else {
								fUtil.flogResult("Failed", "Check transaction success",
										"Transaction success papage not loaded", 1);
							}
						} else {
							fUtil.flogResult("Failed", "Check transaction success",
									"Unexpected popup occure with message "
											+ TdlTransactionStatus.get().errPopupobjects.get(2).getText(),
									1);
							TdlTransactionStatus.get().alertOkBtn.click();
						}

					} else {
						fUtil.flogResult("Failed", "Click on pay button",
								"Payment is not completed | Pay button is disabled", 1);
					}
				} else {
					if (rAmount[2].replace(",", "").split(".")[1].equalsIgnoreCase("0")
							|| rAmount[2].replace(",", "").split(".")[1].equalsIgnoreCase("00"))
						fUtil.flogResult("Failed", "Payment through tcp point failed",
								"Payment amount is more | Can not be paid using tcp points only", 1);
					else
						fUtil.flogResult("Failed", "Payment through tcp point failed",
								"Payment amount is in fraction | Can not be paid using tcp points only", 1);
				}

			} else {
				fUtil.flogResult("Failed", "Payment through tcp point failed",
						"Payment page not showing tcp points of customer", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Gmethods - Pay By TCP Points",
					"Exception during payment by tcp points : " + e.getMessage(), 1);
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paymentbytcppoint_ios To pay complete amount by tcp points
	 * only
	 */

	public void paymentbytcppoint_ios() throws Exception {
		try {
			if (isElementVisible_mobile(TdlMultitenderPage_Mobile.get().paymentMethodTxt_ios, 10)) {
				TdlMultitenderPage_Mobile.get().tcpPointsCheckbx_ios.click();

				if (isElementVisible_mobile(TdlMultitenderPage_Mobile.get().payMultitender_ios, 10)) {
					TdlMultitenderPage_Mobile.get().payMultitender_ios.click();
				} else
					fUtil.flogResult("Passed", "Successfully pay by tcp point", "Successfully pay by tcp point", 1);
			} else {
				fUtil.flogResult("Failed", "Pay button is disable", "Pay button is disable", 1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : paymentConfirmationForSuccessfulPayment_ios This function
	 * confirms payment for successful payment and verifies that payment successful
	 * page is displayed Author: Pranita Dabholkar (Quality Kiosk)
	 */
	public void paymentConfirmationForSuccessfulPayment_ios() throws Exception {
		if (isElementVisible(TdlTransactionStatus_Mobile.get().paynmentSuccessful_ios, 10)) {
			TdlTransactionStatus_Mobile.get().paymentDetails_ios.click();
			Thread.sleep(1000);
			fUtil.flogResult("Passed", "Payment successful", "Payment successful Page is displayed", 1);
		} else
			fUtil.flogResult("Failed", "Payment successful", "Payment is not completed with successful payment", 1);
	}

	/*
	 * Function name : loyalityPointandcreditCard_ios To pay amount by loaylty
	 * points and credit card - multi tender
	 */
	public void loyalityPointandcreditCard_ios() throws Exception {
		try {
			String cvv = fUtil.fgetDataNew1("CVV");
			if (isElementVisible_mobile(TdlMultitenderPage_Mobile.get().paymentMethodTxt_ios, 10)) {
				fUtil.flogResult("Passed", "Verify Mulitender page ", "Multitender page loaded", 1);
			}
			TdlMultitenderPage_Mobile.get().tcpPointsCheckbx_ios.click();
			TdlMultitenderPage_Mobile.get().cvv_ios.sendKeys(cvv);
			TdlMultitenderPage_Mobile.get().payMultitender_ios.click();

			if (isElementVisible_mobile(TdlTransactionStatus_Mobile.get().paynmentSuccessful_ios, 10)) {
				fUtil.flogResult("Passed", "Transaction successfull", "Screen capture", 1);
			} else {
				fUtil.flogResult("Failed", "Transaction Failed", "Screen capture", 1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Function name : updateCountryCodePwas Input : Country code This Function will
	 * Clear and update the country code in PWA Author : Anil Kumar Kedia (TCS)
	 */
	public void updateCountryCodePwa(String countryCode) throws Exception {
		try {
			boolean countryCodeVisibility = isElementVisible(TdlSignUp.get().countryCodeTextBox, 20);

			if (countryCodeVisibility) {
				TdlSignUp.get().countryCodeTextBox.click();
				TdlSignUp.get().countryCodeTextBox.clear();
				TdlSignUp.get().countryCodeTextBox.sendKeys(countryCode);
			} else {
				fUtil.flogResult("Failed", "Country Code", "Country Code Field Not Visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Country Code", "Exception while Updating Country Code :: " + e.getMessage(), 1);
			throw e;
		}
	}

	/*
	 * Function name : refreshBrowser This Function will refresh the browser page
	 */
	public void refreshBrowser() throws Exception {
		try {
			browserFactory.get().getDriver().navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : updateCountryCodePwas Input : Country code This Function will
	 * Clear and update the country code in Mobile Author : Anil Kumar Kedia (TCS)
	 */
	public void updateCountryCodeMobile(MobileElement countryCodeElement, String countryCode) throws Exception {
		try {
			if (countryCode.startsWith("~"))
				countryCode = countryCode.substring(1);

			boolean countryCodeVisibility = isElementVisible_mobile(countryCodeElement, 20);

			if (countryCodeVisibility) {
				countryCodeElement.clear();
				countryCodeElement.clear();
				countryCodeElement.clear();
				countryCodeElement.click();
				countryCodeElement.sendKeys(countryCode);
			} else {
				fUtil.flogResult("Failed", "Country Code", "Country Code Field Not Visible", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Country Code", "Exception while Updating Country Code :: " + e.getMessage(), 1);
			throw e;
		}
	}

	/*
	 * Function name : updateCountryCodePwas This Function will hide the keyboard
	 * which is displayed on screen in mobile app
	 */
	public void hideKeyboardMobile() {
		try {
			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			if (environment.equalsIgnoreCase("ios")) {
				if (isElementVisible_mobile(TdlSignUpMobile.get().keyboardDone_ios, 3))
					TdlSignUpMobile.get().keyboardDone_ios.click();
				else if (isElementVisible_mobile(TdlSignUpMobile.get().keyboardOk_ios, 3))
					TdlSignUpMobile.get().keyboardOk_ios.click();
			

			} else if (environment.equalsIgnoreCase("android"))
				appiumDriver.get().hideKeyboard();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Function name : closeApp This Function will Close the app without
	 * uninstalling the app
	 */
	public void closeApp() {
		try {
			appiumDriver.get().closeApp();
			appiumDriver.get().runAppInBackground(Duration.ofSeconds(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : launchApp This Function will Relaunch the app
	 */
	public void launchApp() {
		try {
			//Thread.sleep(5000);
			//appiumDriver.get().launchApp();
			checkAppStateAndLaunchAppIfNotRunning();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : SwipeScreen This Function will Swipe the screen based on the
	 * direction Input : Element to swipe and Direction (up,down,right,left)
	 */
	public void SwipeScreen(MobileElement element, String direction) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) appiumDriver.get();
			Map<String, Object> params = new HashMap<>();
			params.put("direction", direction);
			params.put("element", element);
			js.executeScript("mobile: swipe", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This Function will return the window size of a particular mobile device
	 */
	public Dimension getWindowSize() {
		Dimension windowSize = null;
		try {
			if (windowSize == null) {
				windowSize = appiumDriver.get().manage().window().getSize();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return windowSize;
	}

	public void swipe(Point start, Point end, Duration duration) throws Exception {
		try {
			int ANDROID_SCROLL_DIVISOR = 2;

			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			PointerInput input = new PointerInput(Kind.TOUCH, "finger1");
			Sequence swipe = new Sequence(input, 0);
			swipe.addAction(input.createPointerMove(Duration.ZERO, Origin.viewport(), start.x, start.y));
			swipe.addAction(input.createPointerDown(MouseButton.LEFT.asArg()));
			if (environment.equalsIgnoreCase("android")) {
				duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
				// duration=Duration.ZERO;
			} else {
				swipe.addAction(new Pause(input, duration));
				duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
				// duration = Duration.ZERO;
			}
			swipe.addAction(input.createPointerMove(duration, Origin.viewport(), end.x, end.y));
			swipe.addAction(input.createPointerUp(MouseButton.LEFT.asArg()));
			appiumDriver.get().perform(ImmutableList.of(swipe));
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Swipe screen",
					"Exception caught while swiping screen using start and end point", 0);

		}
	}

	public void swipe(double startXPct, double startYPct, double endXPct, double endYPct, Duration duration)
			throws Exception {
		try {
			Dimension size = getWindowSize();
			Point start = new Point((int) (size.width * startXPct), (int) (size.height * startYPct));
			Point end = new Point((int) (size.width * endXPct), (int) (size.height * endYPct));
			swipe(start, end, duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This Function will scroll in the mobile device in any direction Inputs :
	 * Direction(DOWN, UP, LEFT, RIGHT) and distance ( >0 & <1)
	 */
	public void scroll(String direction, double distance) throws Exception {
		try {
			Duration SCROLL_DUR = Duration.ofMillis(1000);

			if (distance < 0 || distance > 1) {
				throw new Error("Scroll distance must be between 0 and 1");
			}
			Dimension size = getWindowSize();
			Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
			int top = midPoint.y - (int) ((size.height * distance) * 0.5);
			int bottom = midPoint.y + (int) ((size.height * distance) * 0.5);
			int left = midPoint.x - (int) ((size.width * distance) * 0.5);
			int right = midPoint.x + (int) ((size.width * distance) * 0.5);
			if (direction.equalsIgnoreCase("UP")) {
				swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
			} else if (direction.equalsIgnoreCase("DOWN")) {
				swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
			} else if (direction.equalsIgnoreCase("LEFT")) {
				swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
			} else if (direction.equalsIgnoreCase("RIGHT")) {
				swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : Scroll", "Exception caught :" + e.getMessage(), 0);
			e.printStackTrace();
		}
	}

	/*
	 * This Function will Scroll the screen in mobile any any direction Input :
	 * DOWN, UP, LEFT, RIGHT (Input is not case sensitive)
	 */
	public void scrollDirectionMobile(String direction) throws Exception {
		try {
			double SCROLL_RATIO = 0.4;
			scroll(direction, SCROLL_RATIO);
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : scrollDirectionMobile",
					"Exception caught :" + e.getMessage(), 0);
		}
	}

	/*
	 * Function name : signInOfferConfiguratorWeb This function will Signin the user
	 * in Offer Configurator Web Input Required : Registered Mobile number and
	 * Password
	 * 
	 */
	public void signInOfferConfiguratorWeb(String User_Name, String password) throws Exception {
		try {
			boolean user_name = isElementVisible(MyOffersPage.get().User_Name_input, 10);
			if (user_name) {
				MyOffersPage.get().User_Name_input.sendKeys(User_Name);
				if (isElementVisible(MyOffersPage.get().Password, 10)) {
					MyOffersPage.get().Password.sendKeys(password);
				}
				if (isElementVisible(MyOffersPage.get().Sign_In_Button, 10)) {
					fClickOnButton(MyOffersPage.get().Sign_In_Button, "Clicked on Sign in button", "Sign In", 1);
					Thread.sleep(5000);
					boolean Is_offer_configurator = isElementVisible(MyOffersPage.get().Offer_Configurator_In_sideBar,
							20);
					if (Is_offer_configurator) {
						fUtil.flogResult("Passed", "Login successfull", "Login successfull", 1);
					}
				}
			} else {
				fUtil.flogResult("Failed", "Visibilty of user name", "User name is not visible in sign in page", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : switchToFrameByID This function will switch to new tab when
	 * user redirect to a third party url that opens in new tab
	 * 
	 */
	public void switchToFrameByID(WebElement wb) {
		try {
			WebDriver webDriver = BrowserFactory.webDriver.get();
			webDriver.switchTo().frame(wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : expire This function will add expire time in offers
	 * configurator for different cases like hours,days,months
	 * 
	 */

	public void expire(String expire_value) {
		try {
			String expire_time = fUtil.fgetDataNew1("Expiretill").trim();

			if (expire_value.equalsIgnoreCase("Months")) {
				boolean is_expire_on_code = gmethods.isElementVisible(MyOffersPage.get().OfferCreation_expire_months,
						10);
				if (is_expire_on_code == true) {

					MyOffersPage.get().OfferCreation_expire_months.sendKeys(expire_time);
					fUtil.flogResult("Passed", "entered expire time", "selected expire", 1);
				} else {
					fUtil.flogResult("Failed", "enter expire time", "not able to enter expire time", 1);
				}
			} else if (expire_value.equalsIgnoreCase("Days")) {
				boolean is_expire_on_code = gmethods.isElementVisible(MyOffersPage.get().OfferCreation_expire_days, 10);
				if (is_expire_on_code == true) {

					MyOffersPage.get().OfferCreation_expire_days.sendKeys(expire_time);
					fUtil.flogResult("Passed", "entered expire time", "selected expire", 1);
				} else {
					fUtil.flogResult("Failed", "enter expire time", "not able to enter expire time", 1);
				}
			} else if (expire_value.equalsIgnoreCase("Hours")) {
				boolean is_expire_on_code = gmethods.isElementVisible(MyOffersPage.get().OfferCreation_expire_hours,
						10);
				if (is_expire_on_code == true) {

					MyOffersPage.get().OfferCreation_expire_hours.sendKeys(expire_time);
					fUtil.flogResult("Passed", "entered expire time", "selected expire", 1);
				} else {
					fUtil.flogResult("Failed", "enter expire time", "not able to enter expire time", 1);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//logger.error("Error thresholdtype" + e);
		}
	}

	/*
	 * Function name : select_price_Modification_Method_code This function will
	 * select price Modification Method in offers configurator
	 * 
	 */
	public void select_price_Modification_Method_code(WebElement wb) {
		try {

			boolean is_price_Modification_Method_code = gmethods.isElementVisible(wb, 20);
			if (is_price_Modification_Method_code == true) {
				String price_Modification = fUtil.fgetDataNew1("price_modification_method").trim();
				Select benefit_type = new Select(wb);
				benefit_type.selectByIndex(1);
				fUtil.flogResult("Passed", "Visbility and selection of price_modification type",
						"selected price_modificationtype" + price_Modification, 1);
			} else {
				fUtil.flogResult("Failed", "Visbility of price_modification type button",
						"create price_modification type is not visible", 1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//logger.error("Error thresholdtype" + e);
		}
	}

	/*
	 * Shubhada
	 * 
	 * Function name : clearFieldPWA This function will read text or value of text
	 * field and click on backspace to clear data on that field
	 * 
	 */

	public void clearFieldPWA(WebElement field) throws Exception {
		try {
			int len1 = field.getAttribute("value").length();
			int len2 = field.getText().length();

			if (len1 != 0 || len2 != 0) {
				int len;

				if (len1 > len2)
					len = len1;
				else
					len = len2;

				for (int t = 0; t <= len; t++) {
					field.sendKeys(Keys.BACK_SPACE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : switch to parent frame This function will switch to parent
	 * frame
	 * 
	 */

	public void switchTO_parentFrame() {
		try {
			WebDriver webDriver = BrowserFactory.webDriver.get();
			webDriver.switchTo().parentFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name : switch to defaultContent This function will switch to parent
	 * frame
	 * 
	 */

	public void switchTO_defaultContent() {
		try {
			WebDriver webDriver = BrowserFactory.webDriver.get();
			webDriver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This function will scroll in window till the element visibility
	 * 
	 */
	public void scroll_web(WebElement element) {
		try {
			WebDriver webDriver = BrowserFactory.webDriver.get();
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			gmethods.highlightElement(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This function will select the salutation from the user registration page in
	 * PWA / Mobile Input - Salutation - Mr, Mrs, Miss, Dr, Ms, Prof.
	 */
	public void selectSalutation(String salutation) throws Exception {
		try {
			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			String[] expectedSalutation = { "Mr", "Mrs", "Miss", "Dr", "Ms", "Prof." };
			boolean salutationFlag = false;
			for (int i = 0; i < expectedSalutation.length; i++) {
				if (salutation.equals(expectedSalutation[i])) {
					salutationFlag = true;
					salutation = salutation.trim();
					if (!salutation.equals("Mr")) {
						salutation = " " + salutation;
					}
					break;
				}
			}
			if (salutationFlag) {
				if ((!(environment.equalsIgnoreCase("ios")) && !(environment.equalsIgnoreCase("android")))) {
					TdlSignUp.get().salutationDropdown.click();
					boolean flag = isElementVisibleXpath("//li[text()='" + salutation.trim() + "']", 10);

					BrowserFactory.webDriver.get().findElement(By.xpath("//li[text()='" + salutation.trim() + "']"))
							.click();
					Thread.sleep(3000);
					// if(isElementVisible(TdlSignUp.get().salutationDropdownCloseArrow, 5))
					// {
					// TdlSignUp.get().salutationDropdownCloseArrow.click();
					// Thread.sleep(3000);
					// }

				} else if (environment.equalsIgnoreCase("ios")) {
					scrollDirectionMobile("UP");
					hideKeyboardMobile();
					TdlSignUpMobile.get().salutationDropdown_ios.click();
					appiumDriver.get().findElement(By.xpath("//*[@name='" + salutation.trim() + "']")).click();
				} else if (environment.equalsIgnoreCase("android")) {
					scrollDirectionMobile("UP");
					hideKeyboardMobile();
					TdlSignUpMobile.get().salutationDropdown_android.click();
					appiumDriver.get().findElement(By.xpath("//*[@text='" + salutation.trim() + "']")).click();
				}
			} else {
				fUtil.flogResult("Failed", "Salutation in User Registration",
						"User input is not matching with options present on screen" + "User input :: " + salutation
								+ " Expected Input :: Mr or Mrs or Miss or Dr or Ms or Prof.",
						1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This function is to swipe the hero banner in PWA mobile to land on the
	 * desired page on Hero banner Input : Expected element of the page on hero
	 * banner
	 */
	public boolean heroBannerSwipePwaMobile(WebElement element) throws Exception {
		boolean herobannerVisibility = false;
		try {
			List<WebElement> listOfElements = TdlHomePage.get().heroBannerPages;
			if (!isElementVisible(element, 5)) {
				for (WebElement e : listOfElements) {
					e.click();

					if (isElementVisible(element, 5)) {
						herobannerVisibility = true;
						fUtil.flogResult("Passed", "Hero Banner In Home Page", "Swiped successfully in Hero Banner", 1);
						break;
					} else {
						continue;
					}
				}
			} else {
				herobannerVisibility = true;
				fUtil.flogResult("Passed", "Hero Banner In Home Page", "Swiped successfully in Hero Banner", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : heroBannerSwipePwaMobile ",
					"Exception while swiping in Hero banner page in PWA Mobile" + e.getMessage(), 1);
		}
		return herobannerVisibility;
	}

	/*
	 * This Function is to select date from ios datepicker wheel Input : Date (
	 * Format : 01/Jan/1990 or 01-Jan-1990)s
	 */
	public void datePickeriosWheel(String date, WebElement oDate) throws Exception {
		try {

			if (date.startsWith("~"))
				date = date.substring(1);

			String[] dob = null;

			if (date.contains("-"))
				dob = date.split("-");
			else if (date.contains("/"))
				dob = date.split("/");

			String userDate = dob[0];
			String userMonth = monthConvert(dob[1].trim(), "long");
			String userYear = dob[2].trim();

			oDate.click();

			if (!TdlProfilePage_Mobile.get().datepickerwheel_ios.isEmpty()) {
				// select year
				TdlProfilePage_Mobile.get().datepickerwheel_ios.get(2).setValue(userYear);
				// select month
				TdlProfilePage_Mobile.get().datepickerwheel_ios.get(1).setValue(userMonth);
				// select month
				TdlProfilePage_Mobile.get().datepickerwheel_ios.get(0).setValue(userDate);
				fUtil.flogResult("Passed", "Date select from picker wheel", "Given date selected in wheel", 1);
				TdlProfilePage_Mobile.get().dateDone_ios.click();

			} else {
				fUtil.flogResult("Failed", "General Function : DatePickerios - Datewheel ",
						"Date picker wheel not opened", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			fUtil.flogResult("Failed", "General Function : DatePickerios ",
					"Exception while selecting date DatePickerios" + e.getMessage(), 1);
		}
	}

	/*
	 * This function convert MMM month into MMMM format eg Mar to March
	 */
	public String monthConvert(String month, String conversionType) {
		String rmonth = "";
		Date date;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM");
		try {
			switch (conversionType.toLowerCase()) {
			case "long":
				date = simpleDateFormat.parse(month);
				simpleDateFormat = new SimpleDateFormat("MMMM");
				// System.out.println(simpleDateFormat.format(date));
				rmonth = simpleDateFormat.format(date);
				break;
			case "short":
				date = simpleDateFormat.parse(month);
				simpleDateFormat = new SimpleDateFormat("MMM");
				// System.out.println(simpleDateFormat.format(date));
				rmonth = simpleDateFormat.format(date);
				break;
			case "number":
				date = simpleDateFormat.parse(month);
				simpleDateFormat = new SimpleDateFormat("M");
				// System.out.println(simpleDateFormat.format(date));
				rmonth = simpleDateFormat.format(date);
				break;
			default:
				date = simpleDateFormat.parse(month);
				simpleDateFormat = new SimpleDateFormat("MMMM");
				// System.out.println(simpleDateFormat.format(date));
				rmonth = simpleDateFormat.format(date);
				break;
			}

		} catch (Exception ex) {
			System.out.println("Exception " + ex);
		}
		return rmonth;
	}

	/*
	 * This Function is to select date from android default datepicker Input : Date
	 * ( Format : 01/Jan/1990 or 01-Jan-1990)s
	 */
	public void datePickerandroid(String date, MobileElement oDate) throws Exception {
		try {
			if (date.startsWith("~"))
				date = date.substring(1);

			String[] dob = null;

			if (date.contains("-"))
				dob = date.split("-");
			else if (date.contains("/"))
				dob = date.split("/");

			String userDate = dob[0].trim();
			String userMonth = monthConvert(dob[1].trim(), "long");
			Integer iuserMonth = Integer.parseInt(monthConvert(dob[1].trim(), "number"));
			String userYear = dob[2].trim();
			Integer iuserYear = Integer.parseInt(dob[2].trim());
			String yearXpath = "//*[@text='" + userYear + "']";
			String dateXpath = "//android.view.View[@content-desc='" + userDate + " " + userMonth + " " + userYear
					+ "']"; //// android.view.View[@content-desc="01 January 1980"]
			String monthXpath = "//android.view.View[contains(@content-desc, '" + userYear + "')]";

			oDate.click();

			if (isElementVisible_mobile(TdlProfilePage_Mobile.get().date_picker_header_year_android, 10)) {
				// select year
				TdlProfilePage_Mobile.get().date_picker_header_year_android.click();

				if (!TdlProfilePage_Mobile.get().yearList_andriod.isEmpty()) {

					Integer yearcount = TdlProfilePage_Mobile.get().yearList_andriod.size();
					Integer firstYear = Integer.parseInt(TdlProfilePage_Mobile.get().yearList_andriod.get(0).getText());
					Integer lastYear = Integer
							.parseInt(TdlProfilePage_Mobile.get().yearList_andriod.get(yearcount - 1).getText());
					if (firstYear <= iuserYear && lastYear >= iuserYear) {
						// create xpath and click
						appiumDriver.get().findElement(By.xpath(yearXpath)).click();

					} else if (firstYear > iuserYear) {
						// scroll down
						//scrollDirectionMobile("Down"); 
						SwipeScreen(TdlProfilePage_Mobile.get().date_picker_yearscroll_android,"Down");
						
						while (!isElementVisible_mobile(appiumDriver.get().findElement(By.xpath(yearXpath)), 10)) {
							SwipeScreen(TdlProfilePage_Mobile.get().date_picker_yearscroll_android, "Down");
							//scrollDirectionMobile("Down");
						}
						appiumDriver.get().findElement(By.xpath(yearXpath)).click();

					} else {
						// scoll up
						scrollDirectionMobile("Up");
						// SwipeScreen(TdlProfilePage_Mobile.get().date_picker_yearscroll_android,
						// "Up");
						while (!isElementVisible_mobile(appiumDriver.get().findElement(By.xpath(yearXpath)), 10)) {
							// SwipeScreen(TdlProfilePage_Mobile.get().date_picker_yearscroll_android,
							// "Up");
							scrollDirectionMobile("Up");
						}
						appiumDriver.get().findElement(By.xpath(yearXpath)).click();
					}
				} else {
					fUtil.flogResult("Failed", "General Function : Date select android - Calender ",
							"Click on year failed", 1);
				}

				// select month
				// *[contains(@content-desc, '1980')]
				if (!appiumDriver.get().findElements(By.xpath(monthXpath)).isEmpty()) {
					String sfirstdate = appiumDriver.get().findElements(By.xpath(monthXpath)).get(0)
							.getAttribute("content-desc");
					Integer currmonth = Integer.parseInt(monthConvert(sfirstdate.split(" ")[1], "number"));

					if (currmonth > iuserMonth) {
						Integer diff = currmonth - iuserMonth;
						for (int i = 0; i < diff; i++) {
							// prev arrow
							TdlProfilePage_Mobile.get().previousMonth_android.click();
						}

					} else if (currmonth < iuserMonth) {
						Integer diff = iuserMonth - currmonth;
						for (int i = 0; i < diff; i++) {
							// next arrow
							TdlProfilePage_Mobile.get().nextMonth_android.click();
						}
					}

					// check if date displayed
					if (isElementVisible_mobile(appiumDriver.get().findElement(By.xpath(dateXpath)), 10)) {
						appiumDriver.get().findElement(By.xpath(dateXpath)).click();
						if (gmethods.isElementVisible_mobile(TdlProfilePage_Mobile.get().okBtnCalender_android, 10)) {
							TdlProfilePage_Mobile.get().okBtnCalender_android.click();
							fUtil.flogResult("Passed", "General Function : Date select android - Calender",
									"Date selected", 1);
						} else {
							fUtil.flogResult("Failed", "General Function : Date select android - Calender",
									"Month not get selected", 1);
						}
						fUtil.flogResult("Passed", "General Function : Date select android - Calender", "Date selected",
								1);
					} else {
						fUtil.flogResult("Failed", "General Function : Date select android - Calender",
								"Month not get selected", 1);
					}

				} else {
					fUtil.flogResult("Failed", "General Function : Date select android - Calender - Month",
							"Date picker year not selected", 1);
				}

			} else {
				fUtil.flogResult("Failed", "General Function : Date select android - Calender ",
						"Date picker wheel not opened", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			fUtil.flogResult("Failed", "General Function : Date select android - Calender ",
					"Exception while selecting date" + e.getMessage(), 1);
		}
	}

	public static String generateAccessTokenForJira() throws Exception {

		String bearerToken = "";
		try {
			/* ============== AuthCode Generation====================== */
			String auth_Code = "";

			RestAssured.baseURI = "https://xray.cloud.xpand-it.com/api/v1/authenticate";

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");

			JSONObject json = new JSONObject();
			json.put("client_id", "D3CC30FB835045F890F917C1AECC508C"); // Sandeep Kumar Client id
			json.put("client_secret", "76dd07ae4f560a757fb0d8b948420ce287c9330009947767e18883ca03f46b47"); // Sandeep
			// Kumar
			// Client
			// secret

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			// System.out.println("Response Body is:" + responseBody);

			auth_Code = responseBody.replaceAll("\"", " ").trim();
			// System.out.println("AuthCode is : "+auth_Code);

			String tokenType = "Bearer";
			bearerToken = tokenType + " " + auth_Code;

		} catch (Exception ee) {
			System.out.println("GenerateAccessToken Failed and the message is : " + ee.getMessage());
		}
		return bearerToken;
	}

	/*
	 * This Function will Update the results in JIRA
	 */
	public void updateResultInJira() throws Exception {
		try {
		//	String bearerToken = generateAccessTokenForJira();
			String bearerToken="test";

			String status = ExtentTestManager.getTest().getStatus().toString();
			String status2 = ExtentTestManager.getTestStatus().getStatus().toString();
			String startTime = ExtentTestManager.getTestStatus().getStartTime().toString();
			String endTime = ExtentTestManager.getTestStatus().getEndTime().toString();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+05:50");
			SimpleDateFormat output = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

			Date d = output.parse(startTime);
			String formattedStartTime = sdf.format(d);
			System.out.println(formattedStartTime);

			Date d1 = output.parse(endTime);
			String formattedEndTime = sdf.format(d1);
			String testCaseKeys = fUtil.fgetDataNew1("TestCaseKeys");
			String testExecKey = fUtil.fgetDataNew1("TestExecKey");
			String[] testCases = testCaseKeys.split(",");
			String testEnv = "";
			Response response;

			// switch(channel) {
			// case "Web":
			// testEnv="SIT-Web";
			// break;
			// case "Mobile":
			// switch(strEnvironment) {
			// case "Android":
			// testEnv="SIT-Android";
			// break;
			// case "ios":
			// testEnv="SIT-iOS";
			// break;
			// }
			// case "API":
			// testEnv="SIT-API";
			// break;
			// }

			if (status.equalsIgnoreCase("Pass")) {

				RestAssured.baseURI = "https://xray.cloud.xpand-it.com/api/v1/import/execution?projectKey=ES";

				RequestSpecification request = RestAssured.given();

				request.header("Content-Type", "application/json");
				request.header("Authorization", bearerToken);

				JSONObject json = new JSONObject();

				// HashMap<Object , Object> mapInfo = new HashMap<Object , Object>();
				// JSONArray infoArray = new JSONArray();
				// infoArray.add(testEnv);
				// mapInfo.put("testEnvironments", infoArray);
				// json.put("info", mapInfo);

				json.put("testExecutionKey", testExecKey);
				List<HashMap<Object, Object>> test = new ArrayList<HashMap<Object, Object>>();

				JSONArray test1 = new JSONArray();
				for (int i = 0; i < testCases.length; i++) {

					System.out.println("Updating Results in " + testCases[i]);
					HashMap<Object, Object> map = new HashMap<Object, Object>();
					map.put("testKey", testCases[i]);
					map.put("start", formattedStartTime);
					map.put("finish", formattedEndTime);

					if (channel.equalsIgnoreCase("web")) {
						map.put("comment",
								"Result Updated via API.The test case is mapped to " + scenarioName.get()
										+ " in Automation. The channel is " + channel + ". The Script was tested on : "
										+ fUtil.fgetDataNew1("URL"));
					} else {
						map.put("comment", "Result Updated via API.The test case is mapped to " + scenarioName.get()
								+ " in Automation. The channel is " + channel);
					}

					map.put("status", "PASSED");

					HashMap<Object, Object> mapEvidences = new HashMap<Object, Object>();
					mapEvidences.put("data", encodedBase64.get());
					mapEvidences.put("filename", scenarioName.get() + ".zip");
					mapEvidences.put("contentType", "applications" + "/" + "zip");
					JSONArray evidencesArray = new JSONArray();
					evidencesArray.add(mapEvidences);

					map.put("evidences", evidencesArray);

					test.add(i, map);
					// System.out.println("tests: "+test.get(0));
					test1.add(i, test.get(i));
				}

				json.put("tests", test1);
				// System.out.println("Json Body is" +json.toJSONString());
				request.body(json.toJSONString());

				response = request.post();

			} else {
				RestAssured.baseURI = "https://xray.cloud.xpand-it.com/api/v1/import/execution?projectKey=ES";

				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json");
				request.header("Authorization", bearerToken);

				JSONObject json = new JSONObject();

				// HashMap<Object , Object> mapInfo = new HashMap<Object , Object>();
				// JSONArray infoArray = new JSONArray();
				// infoArray.add(testEnv);
				// mapInfo.put("testEnvironments", infoArray);
				// json.put("info", mapInfo);

				json.put("testExecutionKey", testExecKey);
				List<HashMap<Object, Object>> test = new ArrayList<HashMap<Object, Object>>();

				JSONArray test1 = new JSONArray();
				for (int i = 0; i < testCases.length; i++) {

					System.out.println("Updating Results in " + testCases[i]);
					HashMap<Object, Object> map = new HashMap<Object, Object>();
					map.put("testKey", testCases[i]);
					map.put("start", formattedStartTime);
					map.put("finish", formattedEndTime);

					if (channel.equalsIgnoreCase("web")) {
						map.put("comment",
								"Result Updated via API.The test case is mapped to " + scenarioName.get()
										+ " in Automation. The channel is " + channel + ". The Script was tested on : "
										+ fUtil.fgetDataNew1("URL"));
					} else {
						map.put("comment", "Result Updated via API.The test case is mapped to " + scenarioName.get()
								+ " in Automation. The channel is " + channel);
					}

					map.put("status", "FAILED");

					HashMap<Object, Object> mapEvidences = new HashMap<Object, Object>();
					mapEvidences.put("data", encodedBase64.get());
					mapEvidences.put("filename", scenarioName.get() + ".zip");
					mapEvidences.put("contentType", "applications" + "/" + "zip");
					JSONArray evidencesArray = new JSONArray();
					evidencesArray.add(mapEvidences);

					map.put("evidences", evidencesArray);
					test.add(i, map);
					// System.out.println("tests: "+test.get(0));
					test1.add(i, test.get(i));
				}

				json.put("tests", test1);
				// System.out.println("Json Body is" +json.toJSONString());
				request.body(json.toJSONString());
				response = request.post();
			}

			System.out.println("response :: " + response.getBody().asString());

			int statusCode = response.getStatusCode();
			if (statusCode == 200) {
				System.out.println("Updated results successfully in JIRA");
			} else {
				System.out.println("Results not updated in Jira");
			}

		} catch (Exception e) {
			System.out.println("Exception in Updating Result Jira : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void waitForPageLoad() {

		Wait<WebDriver> wait = new WebDriverWait(BrowserFactory.webDriver.get(), 20);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	/*
	 * Function Name: regExValidation for Android channel This method will validate
	 * whether customer details entered to fetch the bill is throwing any error
	 * 
	 */
	public boolean regExValidation_android() throws Exception {
		boolean regEx = isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().errorMessage_android, 5);
		return regEx;
	}

	/*
	 * Function name: skipTourPageMobilePwa This function will validate after sign
	 * in, whether Tour Page is available if so, then will Skip the tour to proceed
	 * to Home page for Mobile devices Arguments: NA
	 * 
	 */
	public void skipTourPageMobilePwa() {
		try {
			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			boolean flag = false;

			if (environment.equalsIgnoreCase("chrome") || environment.equalsIgnoreCase("firefox")
					|| environment.equalsIgnoreCase("opera") || environment.equalsIgnoreCase("edge")) {
				environment = "pwa";
			}

			switch (environment.toLowerCase()) {
			case "pwa":
				flag = isElementVisible(TdlHomePage.get().skipTourTextView, 10);
				if (flag) {
					//logger.info("Tour Page is visible to user");
					//logger.info("Skipping tour page to proceed further");
					TdlHomePage.get().skipTourTextView.click();
				} else {
					//logger.info("Tour page is not visible to user");
				}
				break;
			case "pwa mobile":
				flag = isElementVisible(TdlHomePage.get().skipTourTextView, 10);
				if (flag) {
					//logger.info("Tour Page is visible to user");
					//logger.info("Skipping tour page to proceed further");
					TdlHomePage.get().skipTourTextView.click();
				} else {
					//logger.info("Tour page is not visible to user");
				}
				break;
			case "android":
				flag = isElementVisible_mobile(TdlHomeMobile.get().skipTourTextView_android, 10);
				if (flag) {
					//logger.info("Tour Page is visible to user");
					//logger.info("Skipping tour page to proceed further");
					TdlHomeMobile.get().skipTourTextView_android.click();
				} else {
					//logger.info("Tour page is not visible to user");
				}
				break;
			case "ios":
				flag = isElementVisible_mobile(TdlHomeMobile.get().skipTourTextView_ios, 10);
				if (flag) {
					//logger.info("Tour Page is visible to user");
					//logger.info("Skipping tour page to proceed further");
					TdlHomeMobile.get().skipTourTextView_ios.click();
				} else {
					//logger.info("Tour page is not visible to user");
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This function is to wait for a tcp web page to load
	 */
	public void waitForTcpPageLoaderDisappeared() {
		String loaderXpath = "//*[@id='loaderWrapper']";
		String loaderXpath1 = "//*[@class='loading-overlay']";

		try {
			for (int i = 0; i < 100; i++) {
				if (BrowserFactory.webDriver.get().findElement(By.xpath(loaderXpath1)).isDisplayed()) {
					System.out.println("Present");
					Thread.sleep(2000);
					continue;
				} else
					break;
			}

		} catch (Exception e) {
			//logger.fatal(e.getMessage());
		}

		try {
			for (int i = 0; i < 100; i++) {
				String styleAttribute = BrowserFactory.webDriver.get().findElement(By.xpath(loaderXpath))
						.getAttribute("style");
				if (styleAttribute.contains("block")) {
					Thread.sleep(2000);
					continue;
				} else
					break;
			}
		} catch (Exception e) {
			//logger.fatal(e.getMessage());

		}
	}

	/*
	 * This function is to swipe the hero banner in mobile (Android/iOS) to land on
	 * the desired page on Hero banner Input : Expected element of the page on hero
	 * banner Author : Anil
	 */
	public boolean heroBannerSwipeMobile(MobileElement element) throws Exception {

		boolean herobannerVisibility = false;
		String environment = "";
		if (currentPlatform.isEmpty())
			environment = BaseScript.platform;
		else
			environment = currentPlatform;

		try {

			if (!isElementVisible_mobile(element, 5)) {
				if (environment.toLowerCase().equals("android"))
					SwipeScreen(TdlHomeMobile.get().heroBannerImage_android, "left");
				else if (environment.toLowerCase().equals("ios"))
					// SwipeScreen(TdlHomeMobile.get().heroBannerImage_ios, "left");

					while (true) {
						if (isElementVisible_mobile(element, 5)) {
							herobannerVisibility = true;
							fUtil.flogResult("Passed", "Hero Banner In Home Page", "Swiped successfully in Hero Banner",
									1);
							break;
						} else {
							continue;
						}
					}
			} else {
				herobannerVisibility = true;
				fUtil.flogResult("Passed", "Hero Banner In Home Page", "Swiped successfully in Hero Banner", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : heroBannerSwipeMobile ",
					"Exception while swiping in Hero banner page in Mobile" + e.getMessage(), 1);
		}
		return herobannerVisibility;
	}

	/*
	 * this function is dedicated to Insurance IOS
	 */
	public void scroll_insurance_ios(String direction, double distance) throws Exception {
		try {
			Duration SCROLL_DUR = Duration.ofMillis(1000);

			if (distance < 0 || distance > 1) {
				throw new Error("Scroll distance must be between 0 and 1");
			}
			Dimension size = getWindowSize();
			Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
			int top = midPoint.y - (int) ((size.height * distance) * 0.5);
			int bottom = midPoint.y + (int) ((size.height * distance) * 0.5);
			int left = midPoint.x - (int) ((size.width * distance) * 0.5);
			int right = midPoint.x + (int) ((size.width * distance) * 0.5);
			if (direction.equalsIgnoreCase("UP")) {
				swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
			} else if (direction.equalsIgnoreCase("DOWN")) {
				swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
			} else if (direction.equalsIgnoreCase("LEFT")) {
				swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
			} else if (direction.equalsIgnoreCase("RIGHT")) {
				swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : Scroll", "Exception caught :" + e.getMessage(), 0);
			e.printStackTrace();
		}
	}

	/*
	 * This function is dedicated to Insurance IOS
	 */
	public void scrollDirectionMobile_insurance_ios(String direction) throws Exception {
		try {
			double SCROLL_RATIO = 0.8;
			scroll(direction, SCROLL_RATIO);
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : scrollDirectionMobile",
					"Exception caught :" + e.getMessage(), 0);
		}
	}

	/*
	 * This Function will return and validate the Digital data Input : Field name
	 * (eVar<number>:fieldName) , Expected data
	 */
	public void fetchAndValidateDigitalData(String digitalField, String fieldName, String expectedData)
			throws Exception {
		String digitalData;
		try {
			switch (digitalField.toLowerCase()) {

			case "pagename":
				digitalData = ((JavascriptExecutor) browserFactory.get().getDriver())
						.executeScript("return digitalData.pageInfo.pageName").toString();
				if (!digitalData.isEmpty()) {
					if (digitalData.trim().contains(expectedData)) {
						fUtil.flogResult("Passed", "Fetch Digital data of " + fieldName,
								"Fetched successfully : " + digitalData, 0);
					} else {
						fUtil.flogResult("Failed", "Fetch Digital data of " + fieldName, "Failed. Expected Data- "
								+ fieldName + "=" + expectedData + " :: Found : " + digitalData, 0);
					}
				} else {
					fUtil.flogResult("Failed", "Digital Data for Page Name", "Failed to fetch data for Page Name", 0);

				}
				break;

			case "category":
				digitalData = ((JavascriptExecutor) browserFactory.get().getDriver())
						.executeScript("return digitalData.pageInfo.category").toString();
				if (!digitalData.isEmpty()) {
					if (digitalData.trim().contains(expectedData)) {
						fUtil.flogResult("Passed", "Fetch Digital data of " + fieldName,
								"Fetched successfully : " + digitalData, 0);
					} else {
						fUtil.flogResult("Failed", "Fetch Digital data of " + fieldName, "Failed. Expected Data- "
								+ fieldName + "=" + expectedData + " :: Found : " + digitalData, 0);
					}
				} else {
					fUtil.flogResult("Failed", "Digital Data for Category", "Failed to fetch data for Category", 0);

				}

				break;

			case "href":
				digitalData = ((JavascriptExecutor) browserFactory.get().getDriver())
						.executeScript("return window.location.href").toString();
				if (!digitalData.isEmpty()) {
					// if(digitalData.trim().contains(expectedData)) {
					fUtil.flogResult("Passed", "Fetch Digital data of " + fieldName,
							"Fetched successfully : " + digitalData, 0);
					// }
					// else {
					// fUtil.flogResult("Failed", "Fetch Digital data of "+fieldName, "Failed.
					// Expected Data- "+fieldName+"="+expectedData+ " :: Found : "+digitalData, 0);
					// }
				} else {
					fUtil.flogResult("Failed", "Digital Data for Href", "Failed to fetch data for Href", 0);

				}

				break;

			case "platform":
				digitalData = ((JavascriptExecutor) browserFactory.get().getDriver())
						.executeScript("return digitalData.pageInfo.platform").toString();
				if (!digitalData.isEmpty()) {
					if (digitalData.trim().contains(expectedData)) {
						fUtil.flogResult("Passed", "Fetch Digital data of " + fieldName,
								"Fetched successfully : " + digitalData, 0);
					} else {
						fUtil.flogResult("Failed", "Fetch Digital data of " + fieldName, "Failed. Expected Data- "
								+ fieldName + "=" + expectedData + " :: Found : " + digitalData, 0);
					}
				} else {
					fUtil.flogResult("Failed", "Digital Data for Platform", "Failed to fetch data for Platform", 0);

				}
				break;

			case "tcpid":
				digitalData = ((JavascriptExecutor) browserFactory.get().getDriver())
						.executeScript("return digitalData.customer.tcpId").toString();
				if (!digitalData.isEmpty()) {
					// if(digitalData.trim().contains(expectedData)) {
					fUtil.flogResult("Passed", "Fetch Digital data of " + fieldName,
							"Fetched successfully : " + digitalData, 0);
					// }
					// else {
					// fUtil.flogResult("Failed", "Fetch Digital data of "+fieldName, "Failed.
					// Expected Data- "+fieldName+"="+expectedData+ " :: Found : "+digitalData, 0);
					// }
				} else {
					fUtil.flogResult("Failed", "Digital Data for TCP id", "Failed to fetch data for TCP id", 0);

				}
				break;

			case "clientid":
				digitalData = ((JavascriptExecutor) browserFactory.get().getDriver())
						.executeScript("return window.digitalData.clientID").toString();
				if (!digitalData.isEmpty()) {
					if (digitalData.trim().contains(expectedData)) {
						fUtil.flogResult("Passed", "Fetch Digital data of " + fieldName,
								"Fetched successfully : " + digitalData, 0);
					} else {
						fUtil.flogResult("Failed", "Fetch Digital data of " + fieldName, "Failed. Expected Data- "
								+ fieldName + "=" + expectedData + " :: Found : " + digitalData, 0);
					}
				} else {
					fUtil.flogResult("Failed", "Digital Data for Client id", "Failed to fetch data for client id", 0);

				}
				break;

			case "other":
				digitalData = ((JavascriptExecutor) browserFactory.get().getDriver())
						.executeScript("return window.digitalData.events").toString();
				System.out.println(digitalData);
				String[] splitDigitalData = digitalData.split(", ");
				String dataFound = "";

				boolean DataCheck = false;

				for (int i = 0; i < splitDigitalData.length; i++) {

					if (splitDigitalData[i].contains(fieldName.split(":")[1] + "=")) {
						String[] dataDigital = splitDigitalData[i].split(", ");

						for (int j = 0; j < dataDigital.length; j++) {
							if (dataDigital[j].contains(fieldName.split(":")[1])) {

								try {
									dataDigital[j] = dataDigital[j]
											.substring(dataDigital[j].indexOf(fieldName.split(":")[1]));
									int index = dataDigital[j].split(fieldName.split(":")[1] + "=").length - 1;
									if (index < 0)
										index = 0;
									dataFound = dataFound + " , "
											+ dataDigital[j].split(fieldName.split(":")[1] + "=")[index]
													.replace("}", "").replace("{", "");
								} catch (Exception e) {
									if (dataFound.length() < 1)
										dataFound = "";
								}

								System.out.println(dataFound);
								DataCheck = true;
								// break;
							}

						}
					}
				}
				// removing the first index of , from the fetched data
				if (dataFound.startsWith(" , "))
					dataFound = dataFound.substring(3, dataFound.length()).trim();

				if (DataCheck) {
					if (expectedData.equals("-") && dataFound.trim().length() >= 1) {
						fUtil.flogResult("Passed", "Fetch Digital data of " + fieldName,
								"Fetched successfully : " + dataFound, 0);
					} else if (expectedData.equals("-")
							&& (dataFound.trim().length() < 1 || dataFound.trim().equals(","))) {
						fUtil.flogResult("Failed", "Fetch Digital data of " + fieldName, "No Data Found : " + dataFound,
								0);

					} else {
						if (dataFound.contains(expectedData)) {
							fUtil.flogResult("Passed", "Fetch Digital data of " + fieldName,
									"Expected Data and Fetched data matched successfully . Expected Data : "
											+ dataFound,
									0);
						} else {
							fUtil.flogResult("Failed", "Fetch Digital data of " + fieldName, "Failed. Expected Data- "
									+ fieldName + "=" + expectedData + " :: Found : " + dataFound, 0);
						}
					}
				} else {
					fUtil.flogResult("Failed", "Digital Data Not found", "Failed to Fetch Data for " + fieldName, 0);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This Function will return the Digital data for events in the PWA web page
	 * Input : Field name (eVar<number>:fieldName) , Expected data
	 */
	// public void fetchDigitalData(String fieldName, String expectedData) throws
	// Exception {
	//
	// String digitalData =
	// ((JavascriptExecutor)browserFactory.get().getDriver()).executeScript("return
	// window.digitalData.events").toString();
	// System.out.println(digitalData);
	//
	// String[] splitDigitalData = digitalData.split(",");
	// String dataFound="";
	//
	// boolean DataCheck = false;
	//
	// for(int i=0;i<splitDigitalData.length;i++) {
	//
	// if(splitDigitalData[i].contains(fieldName.split(":")[1])) {
	// String[] dataDigital = splitDigitalData[i].split(",");
	//
	// for(int j=0;j<dataDigital.length;j++) {
	// if(dataDigital[j].trim().contains(fieldName.split(":")[1])) {
	// System.out.println(dataDigital[j]);
	// dataFound=dataDigital[j];
	// DataCheck=true;
	// break;
	// }
	//
	// }
	//
	// if(DataCheck) {
	// if(dataFound.contains(expectedData))
	// {
	// fUtil.flogResult("Passed", "Fetch Digital data of "+fieldName, "Fetched
	// successfully : "+dataFound, 0);
	// }else {
	// fUtil.flogResult("Failed", "Fetch Digital data of "+fieldName, "Failed.
	// Expected Data- "+fieldName+"="+expectedData+ " :: Found : "+dataFound, 0);
	//
	// }
	// }else {
	// fUtil.flogResult("Failed", "Digital Data Not found", "failed to fetch data",
	// 0);
	//
	// }
	// }
	// }
	// }

	// BillPayment General Functions*****************

	/*
	 * This method will validate RECENT BILLS tab and all the bills present in this
	 * tab Starting point: Recent Bills page Validation: If any bills are present in
	 * the tab, if yes then get the details Input : NA
	 * 
	 */
	public void recentBillsValidations_android() throws Exception {
		try {
			if (gmethods.isElementVisible_mobile(TdlRecentBillsAndCategoryPage_Mobile.get().recentBillsTab_android,
					10)) {
				//logger.info("Recent Bills tab is available and navigated successfully");
				fUtil.flogResult("Passed", "Recent Bills Tab", "Navigated successfully", 1);

				// Validation of First Time User or Repeat User
				if (gmethods.isElementVisible_mobile(
						TdlRecentBillsAndCategoryPage_Mobile.get().recentBillsTabMsg_android, 5)) {
					//logger.info("Customer hasn't added any bills yet, hence customer is a First Time User");
					fUtil.flogResult("Passed", "First Time User :",
							TdlRecentBillsAndCategoryPage_Mobile.get().recentBillsTabMsg_android.getText(), 1);
				} else {
					int allBillItemsNo = TdlRecentBillsAndCategoryPage_Mobile.get().recentBillsItems_android.size();
					//logger.info("Customer has added bills which are present in the recent bills tab	");
					fUtil.flogResult("Passed", "Repeate User", "Number of bills available :" + allBillItemsNo, 1);
				}

				// Validation of Due Bills availability if any
				//logger.info("Changing the displayed Bill type as Due Bills");
				TdlRecentBillsAndCategoryPage_Mobile.get().allBillsDropDown_android.click();
				TdlRecentBillsAndCategoryPage_Mobile.get().dueBillsOption_android.click();

				int dueBillItemsNo = TdlRecentBillsAndCategoryPage_Mobile.get().recentBillsItems_android.size();
				if (dueBillItemsNo == 0) {
					//logger.info("No due bill items are available yet");
					fUtil.flogResult("Passed", "Due Bill Items : ", "Not yet available", 1);
				} else {
					//logger.info("Due bill items are available");
					fUtil.flogResult("Passed", "Due Bill Items", "Available, Count : " + dueBillItemsNo, 1);
					int i = 0;
					for (MobileElement elm : TdlRecentBillsAndCategoryPage_Mobile.get().dueBillAmounts_android) {
						i++;
						System.out.println("individual Due Bill Amount are : ");
						System.out.println("\n" + i + ". " + elm.getText());
					}
				}
			} else {
				//logger.info("Recent Bills tab is not available as not navigated successfully");
				fUtil.flogResult("Failed", "Recent Bills Tab", "Not navigated successfully", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method will be called if customer wants to add a new Bill to proceed
	 * further Starting point: Recent Bills tab and if Add Bill icon is visible
	 * Location pop up will also be handled in this method End Point: Utilities
	 * Landing Page having all the categories available
	 * 
	 */
	public void addNewBill_android() throws Exception {
		try {
			if (gmethods.isElementVisible_mobile(TdlRecentBillsAndCategoryPage_Mobile.get().addNewBillBtn_android,
					10)) {
				//logger.info("Add New Bill button is available for the customer");
				fUtil.flogResult("Passed", "Add New Bill button", "Available for selection", 1);
				//logger.info("Clicking on add new button");
				TdlRecentBillsAndCategoryPage_Mobile.get().addNewBillBtn_android.click();

				if (gmethods.isElementVisible_mobile(
						TdlRecentBillsAndCategoryPage_Mobile.get().allowLocationMsg_android, 5)) {
					//logger.info("Allow Location of the device premission message has been displayed");
					TdlRecentBillsAndCategoryPage_Mobile.get().locationPermission_android.click();
				} else {
					//logger.info("Location premission message is not displayed");
				}

				if (gmethods.isElementVisible_mobile(
						TdlRecentBillsAndCategoryPage_Mobile.get().categorySelectionPgHeader_android, 10)) {
					//logger.info("Category Selection Page has been navigated successfully");
					fUtil.flogResult("Passed", "Category selection page", "Navigated successfully", 1);
				} else {
					//logger.info("Category Selection Page has not been navigated successfully");
					fUtil.flogResult("Failed", "Category selection page", "Not navigated successfully", 1);
				}
			} else {
				//logger.info("Add New Bill button is not available for the customer");
				fUtil.flogResult("Failed", "Add New Bill button", "Not available for selection", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method needs to be called to select any particular category to start the
	 * journey Starting Point: Utilities landing page Inputs: categoryName as
	 * String, taken from data sheet End point: Corresponding page of any particular
	 * category after clicking on it Input : String category name which needs to be
	 * selected to start the journey
	 * 
	 */
	public void categorySelection_android(String categoryName) throws Exception {
		try {
			// String categoryName = fUtil.fgetDataNew1("FirstBill_Category").toUpperCase();

			if (gmethods.isElementVisible_mobile(TdlRecentBillsAndCategoryPage_Mobile.get().Txtbillpayment, 10)) {
				//logger.info("Category Selection page is navigated to initiate BillPayment journey");
				fUtil.flogResult("Passed", "validating Category Selection Page is displayed",
						"Available, Category which needs to be selected : " + categoryName, 1);
				categoryName = categoryName.toUpperCase();
				//logger.info("Selecting required category as directed by user");

				switch (categoryName) {
				case "ELECTRICITY":
					TdlRecentBillsAndCategoryPage_Mobile.get().electricity_android.click();
					break;
				case "GAS":
					TdlRecentBillsAndCategoryPage_Mobile.get().gas_android.click();
					break;
				case "WATER":
					TdlRecentBillsAndCategoryPage_Mobile.get().water_android.click();
					break;
				case "DTH":
					TdlRecentBillsAndCategoryPage_Mobile.get().dth_android.click();
					break;
				case "BROADBAND":
					TdlRecentBillsAndCategoryPage_Mobile.get().broadband_android.click();
					break;
				case "LANDLINE":
					TdlRecentBillsAndCategoryPage_Mobile.get().landline_android.click();
					break;
				case "PREPAID":
					TdlRecentBillsAndCategoryPage_Mobile.get().mobPrepaid_android.click();
					break;
				case "POSTPAID":
					TdlRecentBillsAndCategoryPage_Mobile.get().mobPostpaid_android.click();
					break;
				}
			} else {
				//logger.info("Category Selection page is not navigated successfully to initiate BillPayment journey");
				fUtil.flogResult("Failed", "Category Selection Page", "Not available", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * State selection method for ELECTRICITY category only This method will be
	 * executed only if category is Electricity Input: String category name, String
	 * State name
	 * 
	 */
	public void selectState_android(String category, String requiredState) throws Exception {
		try {
			// String category = fUtil.fgetDataNew1("FirstBill_Category").toUpperCase();
			// String requiredState = fUtil.fgetDataNew1("FirstBill_State");

			if (category.equalsIgnoreCase("ELECTRICITY")) {
				//logger.info("Electricity category is selected. Hence Entering State Selection Method");

				if (gmethods.isElementVisible_mobile(
						TdlFetchBillAndBillersPage_Mobile.get().stateFieldElectricity_android, 10)) {
					//logger.info("State Field is available for selection");
					fUtil.flogResult("Passed", "State Field",
							"Available, State which needs to be selected :" + requiredState, 1);

					String selectedState = TdlFetchBillAndBillersPage_Mobile.get().stateFieldElectricity_android
							.getText();
					if (requiredState.equalsIgnoreCase(selectedState)) {
						//logger.info("AutoPopulated state is: " + selectedState
						//		+ " Which is also customer's choice of state");
						fUtil.flogResult("Passed", "Selected State: ", selectedState, 1);
					} else {
						//logger.info("Customer wants to select state: " + requiredState
						//		+ " but currently selected state is: " + selectedState);
						//logger.info("Click on State field to search for the required state");
						TdlFetchBillAndBillersPage_Mobile.get().stateFieldElectricity_android.click();
						TdlFetchBillAndBillersPage_Mobile.get().searchField_android.sendKeys(requiredState);
						TdlFetchBillAndBillersPage_Mobile.get().availableSearchItem1_android.click();

						// Get the selected state and match if selected and required state are same
						String stateSelected = TdlFetchBillAndBillersPage_Mobile.get().stateFieldElectricity_android
								.getText().trim();
						if (stateSelected.equalsIgnoreCase(requiredState)) {
							//logger.info("Selected State and Required State are same");
							fUtil.flogResult("Passed", "State Selection",
									"Done successfully, Selected State :" + stateSelected, 1);
						} else {
							//logger.info("Selected State and Required State are not same");
							fUtil.flogResult("Failed", "State Selection", "Not done successfully ;" + "Selected State :"
									+ stateSelected + " Required State :" + requiredState, 1);
						}
					}
				} else {
					//logger.info("State Field is not available for selection");
					fUtil.flogResult("Failed", "State Field", "Not available for selection", 1);
				}
			} else {
				//logger.info("Category is not Electricity, hence skipping State Selection Method");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method will be called to select Board for ELECTRICITY, WATER and to
	 * select Operator for GAS, BROADBAND, LANDLINE, DTH Starting Point: Select
	 * Board header, Get the board name from data sheet search it and select from
	 * the list End Point: get the text and validate if the expected board is same
	 * Input: String Board/Operator name, String category
	 * 
	 */
	public void selectBoardOrOperator_android(String requiredBoard, String category) throws Exception {
		try {
			// String requiredBoard = fUtil.fgetDataNew1("FirstBill_Board");
			// String category = fUtil.fgetDataNew1("FirstBill_Category");

			if (category.equalsIgnoreCase("electricity")) {
				if (gmethods.isElementVisible_mobile(
						TdlFetchBillAndBillersPage_Mobile.get().boardFieldElectricity_android, 10)) {
					//logger.info("Board selection field is available, hence clicking on it to select");
					fUtil.flogResult("Passed", "Board Field", "Available, Board to be selected : " + requiredBoard, 1);
					TdlFetchBillAndBillersPage_Mobile.get().boardFieldElectricity_android.click();
					TdlFetchBillAndBillersPage_Mobile.get().searchFieldElectricity_android.sendKeys(requiredBoard);
					TdlFetchBillAndBillersPage_Mobile.get().availableSearchItemElec_android.click();

					// Get the selected board and match if selected and required board are same
					String boardSelected = TdlFetchBillAndBillersPage_Mobile.get().boardFieldElectricity_android
							.getText().trim();
					if (boardSelected.contains(requiredBoard)) {
						//logger.info("Board selection is successful");
						fUtil.flogResult("Passed", "Board Selected :" + boardSelected, "Successful", 1);
					} else {
						//logger.info("Board selection is not successful");
						fUtil.flogResult("Failed", "Board Selected :" + boardSelected
								+ " but Required electricity board :" + requiredBoard, "Not successful", 1);
					}
				} else {
					//logger.info("Board selection field is not available");
					fUtil.flogResult("Failed", "Board Selection field", "Not available", 1);
				}
			} else {
				if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().searchField_android, 10)) {
					//logger.info("Board or Operator selection field is available");
					fUtil.flogResult("Passed", "Board/Operator field",
							"Available, Board/Operator which needs to be selected :" + requiredBoard, 1);
					TdlFetchBillAndBillersPage_Mobile.get().searchField_android.click();
					TdlFetchBillAndBillersPage_Mobile.get().searchField_android.sendKeys(requiredBoard);
					TdlFetchBillAndBillersPage_Mobile.get().availableSearchItem_android.click();

					// Get the selected board and match if selected and required board are same
					Thread.sleep(3000);
					String boardSelected = TdlFetchBillAndBillersPage_Mobile.get().selectedBoardOrOperator_android
							.getText().trim();
					if (boardSelected.equalsIgnoreCase(requiredBoard)) {
						//logger.info("Board or Operator selection is successful");
						fUtil.flogResult("Passed", "Board Selected :" + boardSelected, "Successful", 1);
					} else {
						//logger.info("Board or Operator selection is not successful");
						fUtil.flogResult("Failed", "Board Selected :" + boardSelected
								+ " but Required board :" + requiredBoard, "Not successful", 1);
					}
				} else {
					//logger.info("Board selection field is not available");
					fUtil.flogResult("Failed", "Board Selection field", "Not available", 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Enter customer id/consumer no./K no. etc in the input text field for ELEC,
	 * GAS, WATER, BROADBAND, DTH, LANDLINE this method will be called after
	 * selecting state and board and before clicking on Fetch Bill button Input:
	 * String Customer Details 1, 2, 3 if applicable and also in exact order the
	 * details need to be entered to fetch/pay the bill
	 * 
	 */
	public void enterCustomerDetails_android(String customerDtls1, String customerDtls2, String customerDtls3)
			throws Exception {
		try {
			// String customerDtls1 = fUtil.fgetDataNew1("FirstBill_CustDtls1");
			// String customerDtls2 = fUtil.fgetDataNew1("FirstBill_CustDtls2");
			// String customerDtls3 = fUtil.fgetDataNew1("FirstBill_CustDtls3");

			if (customerDtls1.startsWith("~")) {
				customerDtls1 = customerDtls1.substring(1);
			}

			if (customerDtls2.startsWith("~")) {
				customerDtls2 = customerDtls2.substring(1);
			}

			if (customerDtls3.startsWith("~")) {
				customerDtls3 = customerDtls3.substring(1);
			}

			if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().first_inputTxtFld_android,
					5)) {
				//logger.info("First Input Text field available for selection");
				fUtil.flogResult("Passed", "First Input Text Field", "Available for the customer", 1);
				//logger.info("Entering customer details");
				TdlFetchBillAndBillersPage_Mobile.get().first_inputTxtFld_android.sendKeys(customerDtls1);
				//logger.info("RegEx valition");
				boolean errorFlag1 = gmethods.regExValidation_android();
				boolean flag1 = gmethods
						.isElementClickable(TdlFetchBillAndBillersPage_Mobile.get().fetchBillOrQuickPayBtn_android, 5);

				if ((gmethods
						.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().second_inputTxtFld_android, 5))
						&& flag1 == false && errorFlag1 == false) {
					//logger.info("Second Input Text field available for selection");
					fUtil.flogResult("Passed", "Second Input Text Field", "Available for the customer", 1);
					//logger.info("Entering customer details");
					TdlFetchBillAndBillersPage_Mobile.get().second_inputTxtFld_android.sendKeys(customerDtls2);
					//logger.info("RegEx valition");
					boolean errorFlag2 = gmethods.regExValidation_android();
					boolean flag2 = gmethods.isElementClickable(
							TdlFetchBillAndBillersPage_Mobile.get().fetchBillOrQuickPayBtn_android, 5);

					if ((gmethods.isElementVisible_mobile(
							TdlFetchBillAndBillersPage_Mobile.get().third_inputTxtFld_android, 5)) && flag2 == false
							&& errorFlag2 == false) {
						//logger.info("Third Input Text field available for selection");
						fUtil.flogResult("Passed", "Third Input Text Field", "Available for the customer", 1);
						//logger.info("Entering customer details");
						TdlFetchBillAndBillersPage_Mobile.get().third_inputTxtFld_android.sendKeys(customerDtls3);
						//logger.info("RegEx valition");

					} else {
						//logger.info("Third Input Text field is not available for selection");
						fUtil.flogResult("Passed", "Second Input Text Field", "Not required for bill fetch", 1);
					}
				} else {
					//logger.info("Second Input Text field is not available for selection");
					fUtil.flogResult("Passed", "Second Input Text Field", "Not required for bill fetch", 1);
				}
			} else {
				//logger.info("First Input Text field is not available for selection");
				fUtil.flogResult("Failed", "Input Text Field", "Not available to the customer", 1);
			}

			boolean errorFlag3 = gmethods.regExValidation_android();
			boolean flag3 = gmethods
					.isElementClickable(TdlFetchBillAndBillersPage_Mobile.get().fetchBillOrQuickPayBtn_android, 3);
			if (errorFlag3 == false && flag3 == true) {
				//logger.info("No error message displayed and also Fetch Bill button is enabled");
				fUtil.flogResult("Passed", "Customer details entry and Fetch Bill button activation", "Successful", 1);
			} else {
				//logger.info("Error message displayed and also Fetch Bill button is not enabled");
				fUtil.flogResult("Failed", "Customer details entry and Fetch Bill button activation", "Not successful",
						1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method will validate whether Fetch Bill button is enabled and Consent is
	 * available or not for the customer or Proceed button is enabled for Quick Pay
	 * billers where there will be no consent needs to be given by the customer -
	 * for all category and all billers Input: String consent given by customer
	 * 
	 */
	public void fetchBillAndConsentOrQuickPay_android(String consent) throws Exception {
		try {
			// String consent = fUtil.fgetDataNew1("FirstBill_Consent").toUpperCase();

			if (gmethods.isElementClickable(TdlFetchBillAndBillersPage_Mobile.get().fetchBillOrQuickPayBtn_android,
					10)) {
				//logger.info("Fetch Bill or Quick Pay button is enabled after successfully entering customer details");
				fUtil.flogResult("Passed", "Fetch Bill or Quick Pay button", "Activated", 1);
				//logger.info("Clicking on fetch Bill to fetch bill details or Proceed button for Quick Pay billers");
				TdlFetchBillAndBillersPage_Mobile.get().fetchBillOrQuickPayBtn_android.click();

				if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().consentMessage_android,
						5)) {
					//logger.info(
						//	"Consent Pop up displayed for Fetch Bill billers as the same has not been given by customer before");
					fUtil.flogResult("Passed", "Customer Consent",
							"Required and displayed. Consent Needs to be given as : " + consent, 1);

					switch (consent) {
					case "YES":
						System.out.println("Consent is given as - Yes");
						TdlFetchBillAndBillersPage_Mobile.get().yesOption_android.click();
						break;

					case "NO":
						System.out.println("Consent is given as - No");
						TdlFetchBillAndBillersPage_Mobile.get().noOption_android.click();
						break;

					default:
						System.out.println("Consent is No by default");
						TdlFetchBillAndBillersPage_Mobile.get().noOption_android.click();
					}
				} else {
					//logger.info(
					//		"Consent has already provided by the customer for Fetch Bill billers or not available for Quick Pay billers");
					fUtil.flogResult("Passed", "Customer Consent", "Not available as already given", 1);
				}
			} else {
				//logger.info("Neither Fetch Bill button nor Proceed button is enabled to proceed further");
				fUtil.flogResult("Failed", "Fetch Bill button or Quick Pay button", "Not enabled", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Fetched bill details validation for all those billers which will be fetching
	 * bill details this method will also validate Partial payment and change the
	 * amount if required Input: String "Partial Pay availability", String
	 * "Partial Pay Amount"
	 * 
	 */
	public void fetchedBillDetailsAndPartialPayment_android(String isPartialPayAvailable, String partialPayAmount)
			throws Exception {
		try {
			// String isPartialPayAvailable =
			// fUtil.fgetDataNew1("FirstBill_IsPartialPayAvailable").toUpperCase();

			gmethods.hideKeyboardMobile();
			if (gmethods.isElementVisible_mobile(
					TdlFetchBillAndBillersPage_Mobile.get().fetchedBillDetailsContainer_android, 10)) {
				//logger.info("Bill has been fetched successfully");
				fUtil.flogResult("Passed", "Bill Fetch", "Successful", 1);

				// To get biller name and other details
				//logger.info("Getting Biller name and other details");
				for (MobileElement elm : TdlFetchBillAndBillersPage_Mobile.get().billerDtlsOnFetchedBillPg_android) {
					System.out.println("\nBill details : " + elm.getAttribute("value"));
				}

				// Consumer Name Validation -->
				gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().consumerName_android, 30);
				//logger.info("Consumer Name Validation");
				System.out.println("Consumer Name : "
						+ TdlFetchBillAndBillersPage_Mobile.get().consumerName_android.getText().trim());
				if(!(TdlFetchBillAndBillersPage_Mobile.get().consumerName_android.getText().contains("Prepaid"))) {
				if (TdlFetchBillAndBillersPage_Mobile.get().consumerName_android.getText().trim()
						.equalsIgnoreCase("Bill No")) {
					//logger.info("Consumer Name is not displayed");
					fUtil.flogResult("Failed", "Consumer Name", "Not displayed", 1);
				} else {
					//logger.info("Consumer Name is displayed");
					fUtil.flogResult("Passed", "Consumer Name : ",
							TdlFetchBillAndBillersPage_Mobile.get().consumerName_android.getText().trim(), 1);
				}
				//logger.info("Bill Date Validation");
				System.out.println(
						"Bill Date : " + TdlFetchBillAndBillersPage_Mobile.get().billDate_android.getText().trim());

				//logger.info("Bill Due Date Validation");
				System.out.println(
						"Bill Due Date : " + TdlFetchBillAndBillersPage_Mobile.get().dueDate_android.getText().trim());

				//logger.info("Amount and Convenience Fee Validation");
				System.out.println(
						"Bill Amount : " + TdlFetchBillAndBillersPage_Mobile.get().amount_android.getText().trim()
								+ "\n" + "Convenience fee details : "
								+ TdlFetchBillAndBillersPage_Mobile.get().amount_android.getText().trim());

				// Partial Payment Validation
				if (isPartialPayAvailable.equalsIgnoreCase("YES")) {
					// String partialPayAmount = fUtil.fgetDataNew1("FirstBill_PartialPayAmnt");

					if (partialPayAmount.startsWith("~")) {
						partialPayAmount = partialPayAmount.substring(1);
					}
					//logger.info("Partial Payment is available for the biller");
					boolean editAmount = gmethods
							.isElementClickable(TdlFetchBillAndBillersPage_Mobile.get().amount_android, 5);
					if (editAmount == true) {
						//logger.info("Amount field is editable, hence Partial Payment is enabled for this biller");
						fUtil.flogResult("Passed", "Partial Payment",
								"Enabled, Payment amount field is clickable to amend", 1);
						//logger.info("Changing amount as per the requirement");
						TdlFetchBillAndBillersPage_Mobile.get().amount_android.click();
						TdlFetchBillAndBillersPage_Mobile.get().amount_android.clear();
						TdlFetchBillAndBillersPage_Mobile.get().amount_android.sendKeys(partialPayAmount);

					} else {
						//logger.info(
						//		"Amount field is not editable, hence Partial Payment is not enabled for this biller");
						fUtil.flogResult("Failed", "Partial Payment Field", "Not clickable to edit", 1);
					}
				} 
				else {
					//logger.info("Partial Payment is not available for this biller");
					fUtil.flogResult("Passed", "Partial Payment", "Not available for this biller", 1);
				}
//				String convenienceFeeMsg = TdlFetchBillAndBillersPage_Mobile.get().amountMsg_android.getText().trim();
//				if (convenienceFeeMsg.startsWith("Convenience")) {
//					//logger.info("Amount has been changed Successfully");
//					//logger.info("Convenience Fee details : " + convenienceFeeMsg);
//					fUtil.flogResult("Passed", "Amount update for Partial Payment", "Changed Amount: "
//							+ TdlFetchBillAndBillersPage_Mobile.get().amount_android.getText().trim(), 1);
//				} else {
//					//logger.info("Amount has not been changed succesfully as error message displayed : "
//							+ convenienceFeeMsg);
//					fUtil.flogResult("Failed", "Amount update for Partial Payment",
//							"Not done. Error Message displayed : " + convenienceFeeMsg, 1);
//				}
				}
			} else {
				//logger.info("Bill has not been fetched successfully");
				fUtil.flogResult("Failed", "Bill Fetch", "not successful", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method will validate Save As and depending on the journey type click on
	 * Add Bill to add multiple bills or Not Now to proceed to Review Page
	 * 
	 */
	public void saveAsAndAddBill_android(String saveAs, String addAnotherBill) throws Exception {
		try {
			// String saveAs = fUtil.fgetDataNew1("FirstBill_SaveAs");
			// String proceedToPayment =
			// fUtil.fgetDataNew1("FirstBill_ProceedToPay").toUpperCase();

			addAnotherBill = addAnotherBill.toUpperCase();
			gmethods.hideKeyboardMobile();
			/*if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().saveAsField_android, 10)) {
				TdlFetchBillAndBillersPage_Mobile.get().saveAsField_android.click();
				//logger.info("Save As option is available to the customer");
				fUtil.flogResult("Passed", "Save As option", "Available", 1);
				//logger.info("Available Save As options are : ");
				for (MobileElement elm : TdlFetchBillAndBillersPage_Mobile.get().saveAsOptions_android) {
					System.out.println("Available Save As Options are : ");
					System.out.println("\n" + elm.getText().trim());
				}
				// Save As selection & Validation
				String selectedOption = TdlFetchBillAndBillersPage_Mobile.get().saveAsField_android.getText().trim();
				if (selectedOption == null) {
					//logger.info("Save As is already selected. Selected Option is : " + selectedOption);
					fUtil.flogResult("Passed", "Save As Option", "Selected as : " + selectedOption, 1);
				} else {
					TdlFetchBillAndBillersPage_Mobile.get().saveAsField_android.click();
					
					  String xpath = "//*[@text='"+saveAs+"']";
					 appiumDriver.get().findElement(By.xpath(xpath)).click();
					
					String selectedSaveAs = TdlFetchBillAndBillersPage_Mobile.get().saveAsField_android.getText()
							.trim();
					if (selectedSaveAs.equalsIgnoreCase(saveAs)) {
						//logger.info("Save As option is selected successfully and matched with the expected value");
						fUtil.flogResult("Passed", "Save As Selection", "Matched with expected value", 1);
					} else {
						//logger.info(
								"Save As option is not selected successfully and not matched with the expected value");
						fUtil.flogResult("Failed", "Save As Selection", "Not matched with expected value"
								+ "Expected Value : " + saveAs + " Selected Value: " + selectedSaveAs, 1);
					}
				}*/
				// Add Bill
				if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().addBillBtn_android, 30)) {
					//logger.info("Add Bill button is available");
					fUtil.flogResult("Passed", "Add Bill", "Available to proceed further", 1);
					//logger.info("Clicking on Add bill button");
					TdlFetchBillAndBillersPage_Mobile.get().addBillBtn_android.click();

					if (gmethods.isElementVisible_mobile(
							TdlFetchBillAndBillersPage_Mobile.get().addBillAlertHdr_android, 30)) {
						//logger.info("Add Bill Alert pop up displayed");
						fUtil.flogResult("Passed", "Add Bill Alert Pop Up", "Displayed", 1);

						switch (addAnotherBill) {
						case "YES":
							//logger.info("Customer opted for adding another bill");
							//logger.info("Clicking on Add Bill button to navigate to category Selection Page");
							if(gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().yesOption_android, 20))
							TdlFetchBillAndBillersPage_Mobile.get().yesOption_android.click();
							break;

						case "NO":
							//logger.info("Customer opted for proceeding to Payment page");
							//logger.info("Clicking on Not Now button to navigate to Review Page");
							if(gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().notNowBtn_android, 20))
							TdlFetchBillAndBillersPage_Mobile.get().notNowBtn_android.click();
							break;

						default:
							//logger.info("By Defaut customer will be navigated to Payment page");
							//logger.info("Clicking on Not Now button");
							if(gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().notNowBtn_android, 20))
							TdlFetchBillAndBillersPage_Mobile.get().notNowBtn_android.click();
						}
					} 
					else {
						//logger.info("Add Bill Alert pop up not displayed");
						fUtil.flogResult("Failed", "Add Bill Alert Pop Up", "Not displayed", 1);
					}

				} 
				else {
					//logger.info("Add Bill alert pop up not displayed");
					fUtil.flogResult("Failed", "Add Bill", "not available to proceed further", 1);
				}
				/*
				 * } else { //logger.info("Save As option is not available");
				 * fUtil.flogResult("Failed", "Save As option", "Not available", 1); }
				 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * Function name : generateAccessToken This function will generate accesstoken.
	 * Input required : baseUriAuth, baseUriToken, clientId Name,
	 * secretKey,code_challenge,countryCode,mobileNumber,password
	 * 
	 */

	public String generateAccessToken(String baseUriAuth, String baseUriToken, String h_clientId, String h_secretKey,
			String code_challenge, String countryCode, String mobileNumber, String password) throws Exception {

		String bearerToken = "";
		try {

			/*
			 * ============================================ AuthCode
			 * Generation===========================================
			 */
			String auth_Code = "";

			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);
			request.header("client_secret", h_secretKey);

			JSONObject json = new JSONObject();
			json.put("countryCode", countryCode);
			json.put("phone", mobileNumber);
			json.put("password", password);
			json.put("codeChallenge", code_challenge);
			json.put("redirectUrl", "https://cug.tatadigital.com");

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);

			auth_Code = response.jsonPath().get("authCode");
			System.out.println("AuthCode is : " + auth_Code);

			String baseUri_accessToken = baseUriToken + "/" + auth_Code;
			System.out.println("baseUri_accessToken is : " + baseUri_accessToken);

			/*
			 * ====================================Access Token Generation
			 * ============================================
			 */
			RestAssured.baseURI = baseUri_accessToken;

			RequestSpecification requestToken = RestAssured.given();

			requestToken.header("Content-Type", "application/json");
			requestToken.header("client_id", h_clientId);
			requestToken.header("client_secret", h_secretKey);

			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", "codeVerifier");

			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();

			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);

			String accessToken = responseToken.jsonPath().get("accessToken");

			System.out.println("Access token  is : " + accessToken);

			// JsonPath path = response.jsonPath();
			// String tokenKey = path.getString("token");
			String tokenType = "Bearer";
			bearerToken = tokenType + " " + accessToken;

		} catch (Exception ee) {
			System.out.println("Failed and the message is : " + ee.getMessage());
		}
		return bearerToken;

	}

	/*
	 * Function name : generateRefreshToken This function will generate accesstoken.
	 * Input required : baseUriAuth, baseUriToken, clientId Name,
	 * secretKey,code_challenge,countryCode,mobileNumber,password
	 * 
	 */

	public String generateRefreshToken(String baseUriAuth, String baseUriToken, String h_clientId, String h_secretKey,
			String code_challenge, String countryCode, String mobileNumber, String password) throws Exception {

		String refreshToken = "";
		try {

			/*
			 * ============================================ AuthCode
			 * Generation===========================================
			 */
			String auth_Code = "";

			RestAssured.baseURI = baseUriAuth;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);
			request.header("client_secret", h_secretKey);

			JSONObject json = new JSONObject();
			json.put("countryCode", countryCode);
			json.put("phone", mobileNumber);
			json.put("password", password);
			json.put("codeChallenge", code_challenge);

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);

			auth_Code = response.jsonPath().get("authCode");
			System.out.println("AuthCode is : " + auth_Code);

			String baseUri_accessToken = baseUriToken + "/" + auth_Code;
			System.out.println("baseUri_accessToken is : " + baseUri_accessToken);

			/*
			 * ====================================Access Token Generation
			 * ============================================
			 */
			RestAssured.baseURI = baseUri_accessToken;

			RequestSpecification requestToken = RestAssured.given();

			requestToken.header("Content-Type", "application/json");
			requestToken.header("client_id", h_clientId);
			requestToken.header("client_secret", h_secretKey);

			JSONObject jsonToken = new JSONObject();
			jsonToken.put("codeVerifier", "Superman");

			requestToken.body(jsonToken.toJSONString());
			Response responseToken = requestToken.post();

			String responseBodyToken = responseToken.getBody().asString();
			System.out.println("Response Body is:" + responseBodyToken);

			refreshToken = responseToken.jsonPath().get("refreshToken");

			System.out.println("Refresh token  is : " + refreshToken);

		} catch (Exception ee) {
			System.out.println("Failed and the message is : " + ee.getMessage());
		}
		return refreshToken;

	}

	/*
	 * Function name : genrateOtp This function will generate Otp. Input required :
	 * baseUri, baseUriToken, clientId Name,
	 * secretKey,code_challenge,countryCode,mobileNumber,password
	 * 
	 */

	public String genrateOtp(String baseUri, String h_clientId, String countryCode, String mobileNumber)
			throws Exception {

		String otp = "";
		try {
			System.out.println("OTP Generation");
			// RestAssured.baseURI = "https://dapi.tatadigital.com/api/v1/gr/generateotp";

			RestAssured.baseURI = baseUri;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);
			// request.header("secret_key", h_secretKey);
			// request.header("Ocp-Apim-Subscription-Key", h_Ocp_Apim_Subscription_Key);

			JSONObject json = new JSONObject();
			json.put("countryCode", countryCode);
			json.put("mobileNumber", mobileNumber);
			// json.put("event",event);

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);

			otp = response.jsonPath().get("otp");
			System.out.println("OTP : " + otp);

		} catch (Exception ee) {
			System.out.println("Failed and the message is : " + ee.getMessage());
		}
		return otp;

	}

	/*
	 * Function name : genrateEnrollmentOtp This function will generate Otp. Input
	 * required : baseUri, baseUriToken, clientId Name,countryCode,mobileNumber
	 * 
	 */

	public String generateEnrollmentOtp(String baseUri, String h_clientId, String countryCode, String mobileNumber)
			throws Exception {

		String otp = "";
		try {

			RestAssured.baseURI = baseUri;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);

			JSONObject json = new JSONObject();
			json.put("countryCode", "+91");
			json.put("mobileNumber", mobileNumber);
			json.put("programId", "tcp");
			json.put("event", "enrollment_OTP");

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);

			otp = response.jsonPath().get("otp");
			System.out.println("OTP : " + otp);

		} catch (Exception ee) {
			System.out.println("Failed and the message is : " + ee.getMessage());
		}
		return otp;

	}

	/*
	 * Function name : genrateRefid This function will generate GR Otp. Input
	 * required : baseUri, baseUriToken, clientId Name,
	 * secretKey,countryCode,mobileNumber
	 * 
	 */

	public static List<String> genrateRefId(String baseUri, String h_clientId, String countryCode, String mobileNumber)
			throws Exception {

		String refId = "";
		String otp = "";
		try {

			RestAssured.baseURI = baseUri;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);

			JSONObject json = new JSONObject();
			json.put("countryCode", countryCode);
			json.put("mobileNumber", mobileNumber);
			json.put("programId", "tcp");
			json.put("event", "enrollment_OTP");

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);

			otp = response.jsonPath().get("otp");
			System.out.println("RefID is : " + otp);

			refId = response.jsonPath().get("id");
			System.out.println("RefID is : " + refId);

		} catch (Exception ee) {
			System.out.println("Failed and the message is : " + ee.getMessage());
		}
		return Arrays.asList(otp, refId);

	}

	/*
	 * Function name : genrateRefid This function will generate Otp for USER API .
	 * Input required : baseUri, baseUriToken, clientId Name,
	 * secretKey,countryCode,mobileNumber
	 * 
	 */
	public static List<String> reactivateUserOtp(String baseUri, String h_clientId, String countryCode,
			String mobileNumber) throws Exception {

		String refId = "";
		String otp = "";
		try {

			RestAssured.baseURI = baseUri;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);

			JSONObject json = new JSONObject();
			json.put("countryCode", countryCode);
			json.put("mobileNumber", mobileNumber);

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);

			otp = response.jsonPath().get("otp");
			System.out.println("RefID is : " + otp);

			refId = response.jsonPath().get("id");
			System.out.println("RefID is : " + refId);

		} catch (Exception ee) {
			System.out.println("Failed and the message is : " + ee.getMessage());
		}
		return Arrays.asList(otp, refId);

	}

	/*
	 * Function name : genrateRefid This function will generate GR Otp. Input
	 * required : baseUri, baseUriToken, clientId Name,
	 * secretKey,countryCode,mobileNumber
	 * 
	 */

	public static List<String> genratePOSOtp(String baseUri, String h_clientId, String secretKey, String countryCode,
			String mobileNumber) throws Exception {

		String refId = "";
		String otp = "";
		try {

			RestAssured.baseURI = baseUri;

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("client_id", h_clientId);
			request.header("Authorization", secretKey);

			JSONObject json = new JSONObject();
			json.put("countryCode", countryCode);
			json.put("mobileNumber", mobileNumber);
			json.put("programId", "tcp");
			json.put("event", "enrollment_OTP");

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);

			otp = response.jsonPath().get("otp");
			System.out.println("RefID is : " + otp);

			refId = response.jsonPath().get("id");
			System.out.println("RefID is : " + refId);

		} catch (Exception ee) {
			System.out.println("Failed and the message is : " + ee.getMessage());
		}
		return Arrays.asList(otp, refId);

	}

	/*
	 * This Function will close all the open tabs except the parent tab (TCP tab)
	 */
	public void closeAllTabsAndSwitchtoTcp() throws Exception {
		try {
			for (String winHandle : BrowserFactory.webDriver.get().getWindowHandles()) {
				if (!(winHandle.equals(parentWindowHandle))) {
					BrowserFactory.webDriver.get().switchTo().window(winHandle);
					BrowserFactory.webDriver.get().switchTo().window(winHandle).close();
				}	
			}
//			for (String winHandle : BrowserFactory.webDriver.get().getWindowHandles()) {
//				if (!(BrowserFactory.webDriver.get().switchTo().window(winHandle).getTitle()
//						.contains("TataNeu"))) {
//					BrowserFactory.webDriver.get().switchTo().window(winHandle);
//					BrowserFactory.webDriver.get().switchTo().window(winHandle).close();
//				}
//			}
			
			//ArrayList<String> tabs2 = new ArrayList<String>(BrowserFactory.webDriver.get().getWindowHandles());
			BrowserFactory.webDriver.get().switchTo().window(parentWindowHandle);
			if (BrowserFactory.webDriver.get().getWindowHandle().equals(parentWindowHandle)) {
				fUtil.flogResult("Passed", "Navigate to TataNeu Tab", "Successfully closed all tabs and switched to TataNeu", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Switch to TCP tab ", "Exception caught in General function : " + e.getMessage(),
					1);
		}
	}


	/*
	 * This Function will Get the height and Width of a Mobile Element along with
	 * the RGB details Input : MobileElement
	 */
	public void getColorAndSizeDetailsOfMobileElement(MobileElement element) throws Exception {
		try {
			fUtil.flogResult("Passed", "UI / UX", "Getting the Size and Color details ", 1);
			
			// MobileElement element = (MobileElement)
			// appiumDriver.get().findElementByAccessibilityId("SomeAccessibilityID");
			Dimension elementSize = element.getSize();
			String height = Integer.toString(elementSize.height);
			String width = Integer.toString(elementSize.width);
			
			fUtil.flogResult("Passed", "Element Hieght : ", height, 0);
			fUtil.flogResult("Passed", "Element Width : ", width, 0);
			
			System.out.println("Element height :" + elementSize.getHeight());
			System.out.println("Element Width : " + elementSize.getWidth());
			
			Point point = element.getCenter();
			int centerx = point.getX();
			int centerY = point.getY();
			
			File scrFile = ((TakesScreenshot) appiumDriver.get()).getScreenshotAs(OutputType.FILE);
			
			BufferedImage image = ImageIO.read(scrFile);
			// Getting pixel color by position x and y
			int clr = image.getRGB(centerx, centerY);
			int red = (clr & 0x00ff0000) >> 16;
							int green = (clr & 0x0000ff00) >> 8;
						int blue = clr & 0x000000ff;
						
						fUtil.flogResult("Passed", "RGB Color. ", "Red Color value = " + red, 0);
						fUtil.flogResult("Passed", "RGB Color. ", "Green Color value = " + green, 0);
						fUtil.flogResult("Passed", "RGB Color. ", "Blue Color value = " + blue, 0);
						
						System.out.println("Red Color value = " + red);
						System.out.println("Green Color value = " + green);
						System.out.println("Blue Color value = " + blue);
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Get Size and Color details of Mobile Element",
					"Exception caught in General function : " + e.getMessage(), 1);
			
		}
		
	}
	/*
	 * This Function will Update the testcase status to EXECUTING in JIRA input -
	 * Jira Status ( "EXECUTING", "TO DO")
	 */
	public void updateTestCaseStatusInJira(String jiraStatus) throws Exception {
		try {
			String bearerToken = generateAccessTokenForJira();

			String startTime = ExtentTestManager.getTestStatus().getStartTime().toString();
			// String endTime = ExtentTestManager.getTest().getEndedTime().toString();

			// SimpleDateFormat sdf = new
			// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00:01");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			SimpleDateFormat output = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
			Date d = output.parse(startTime);
			String formattedStartTime = sdf.format(d);
			System.out.println(formattedStartTime);

			// Date d1 = output.parse(endTime);
			// String formattedEndTime = sdf.format(d1);
			String testCaseKeys = fUtil.fgetDataNew1("TestCaseKeys");
			String testExecKey = fUtil.fgetDataNew1("TestExecKey");
			String[] testCases = testCaseKeys.split(",");
			// String testEnv="";
			Response response;

			RestAssured.baseURI = "https://xray.cloud.xpand-it.com/api/v1/import/execution?projectKey=ES";

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("Authorization", bearerToken);

			JSONObject json = new JSONObject();

			json.put("testExecutionKey", testExecKey);
			List<HashMap<Object, Object>> test = new ArrayList<HashMap<Object, Object>>();

			JSONArray test1 = new JSONArray();
			for (int i = 0; i < testCases.length; i++) {

				HashMap<Object, Object> map = new HashMap<Object, Object>();
				map.put("testKey", testCases[i]);
				map.put("start", formattedStartTime);
				map.put("finish", formattedStartTime);
				map.put("comment", "Updated the Status to " + jiraStatus + " - " + scenarioName.get()
						+ " in Automation. The channel is " + channel);
				map.put("status", jiraStatus);

				test.add(i, map);
				test1.add(i, test.get(i));
			}

			json.put("tests", test1);
			request.body(json.toJSONString());

			response = request.post();

			System.out.println("response :: " + response.getBody().asString());

			int statusCode = response.getStatusCode();
			if (statusCode == 200) {
				System.out.println("Updated the Status to " + jiraStatus + " successfully in JIRA");
			} else {
				System.out.println("Results not updated in Jira");
			}

		} catch (Exception e) {
			System.out.println("Exception in Updating Result Jira : " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * Mobile number entry for PREPAID
	 * 
	 */

	public void customerDetailsEntry_Prepaid_android(String mobileNoToRchrg) throws Exception {
		try {
			// String mobileNoToRchrg = "9163572010"; //
			// fUtil.fgetDataNew1("FirstBill_CustDtls1");

			if (mobileNoToRchrg.startsWith("~")) {
				mobileNoToRchrg = mobileNoToRchrg.substring(1);
			}

			// gmethods.categorySelection_android("PREPAID");

			if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().mobilePgHdrTxt_android, 10)) {
				//logger.info("Mobile Page navigated successfully");
				fUtil.flogResult("Passed", "Page Navigated : ",
						TdlFetchBillAndBillersPage_Mobile.get().mobilePgHdrTxt_android.getText().trim(), 1);

				// validating mobile number to recharge as per the data given by user

				String defaultMobNo = TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.getAttribute("text")
						.trim();
				if (defaultMobNo != null && defaultMobNo.contentEquals(mobileNoToRchrg)) {
					//logger.info("Mobile number which needs to be recharged populated by default");
					fUtil.flogResult("Passed", "Mobile Number field", "Autopopulated", 1);
					Thread.sleep(5000);

				} else if (defaultMobNo != null && !(defaultMobNo.contentEquals(mobileNoToRchrg))) {
					//logger.info("Recharge mobile number is not same as default mobile number");
					//logger.info("Changing mobile number");
					TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.click();
					TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.clear();
					TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.sendKeys(mobileNoToRchrg);
					Thread.sleep(5000);
					gmethods.hideKeyboardMobile();
				} else {
					//logger.info("Mobile number field has not been autopopulated");
					fUtil.flogResult("Failed", "Mobile Number", "Not autopopulated", 1);
				}

				// entered mobile no is same as mobile no tho recharge

				String enteredMoNum = TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.getText();
				if (enteredMoNum.contentEquals(mobileNoToRchrg)) {
					//logger.info("Mobile number changed successfully");
					fUtil.flogResult("Passed", "Mobile Number update", "Successful", 1);
					TdlFetchBillAndBillersPage_Mobile.get().proceedBtn_android.click();
					Thread.sleep(3000);
				} else {
					//logger.info("Mobile number not changed successfully");
					fUtil.flogResult("Failed", "Mobile Number update", "Not successful", 1);
				}

			} else {
				//logger.info("Mobile page not navigated successfully");
				fUtil.flogResult("Failed", "Page navigation", "Not successful", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Plan selection for PREPAID
	 * 
	 */

	public void planSelection_Prepaid_android(String mobileNoToRchrg, String operatorValidation, String amount)
			throws Exception {
		try {

			operatorValidation = operatorValidation.toUpperCase();

			// String mobileNoToRchrg = "9163572010"; //
			// fUtil.fgetDataNew1("FirstBill_CustDtls1");
			// String operatorValidation = "AIRTEL"; // fUtil.fgetDataNew1("Operator");
			// String amount = "97"; // fUtil.fgetDataNew1("Recharge_Amount");

			if (mobileNoToRchrg.startsWith("~")) {
				mobileNoToRchrg = mobileNoToRchrg.substring(1);
			}

			if (amount.startsWith("~")) {
				amount = amount.substring(1);
			}

			if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().prepaidHdr_android, 10)) {
				//logger.info("Mobile Page navigated successfully");
				fUtil.flogResult("Passed", "Page Navigated : ",
						TdlFetchBillAndBillersPage_Mobile.get().prepaidHdr_android.getText().trim(), 1);

				String moNumDisplayed = TdlFetchBillAndBillersPage_Mobile.get().prepaidNo_android.getAttribute("text");
				if (moNumDisplayed.contentEquals(mobileNoToRchrg)) {
					//logger.info("Mobile number changed successfully");
					fUtil.flogResult("Passed", "Mobile Number update", "Successful", 1);

					String operatorDisplayed = TdlFetchBillAndBillersPage_Mobile.get().operator_android
							.getAttribute("text").toUpperCase();
					System.out.println(operatorDisplayed);

					if (operatorDisplayed.contains(operatorValidation)) {
						//logger.info("proper operator displayed");
						fUtil.flogResult("Passed", "operator displayed", "Successful", 1);
						TdlFetchBillAndBillersPage_Mobile.get().amtFeild_android.sendKeys(amount);
						Thread.sleep(5000);
						fUtil.flogResult("Passed", "amount entered", "Successful", 1);

						if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().amtError_android,
								10)) {

							//logger.info("plan doesnot exist");
							fUtil.flogResult("Passed", "recommended plans displayed", "Successful", 1);
							// TdlFetchBillAndBillersPage_Mobile.get().viewPlans_android.click();
							// Thread.sleep(3000);
							TdlFetchBillAndBillersPage_Mobile.get().firstPlan_android.click();
							Thread.sleep(3000);
							fUtil.flogResult("Passed", "Plan Selected : ",
									TdlFetchBillAndBillersPage_Mobile.get().planDetail_android.getText().trim(), 1);

						} else if (gmethods.isElementVisible_mobile(
								TdlFetchBillAndBillersPage_Mobile.get().planDetail_android, 10)) {

							//logger.info("plan detail displayed successfully");
							fUtil.flogResult("Passed", "Plan Selected : ",
									TdlFetchBillAndBillersPage_Mobile.get().planDetail_android.getText().trim(), 1);

							// if
							// (gmethods.isElementClickable(TdlFetchBillAndBillersPage_Mobile.get().proceedBtn_android,
							// 10)) {
							//
							// //logger.info("procced button is enabled and clickable");
							//
							// gmethods.fetchBillAndConsentOrQuickPay_android("NO");
							// gmethods.fetchedBillDetailsAndPartialPayment_android("NO", "Not Required");
							// gmethods.saveAsAndAddBill_android("Father", "NO");
							//
							// } else {
							// //logger.info("proceed button is not enabled");
							// fUtil.flogResult("Failed", "proceed button", "Not clickable", 1);
							//
							// }
						} else {
							//logger.info("plan detail not displayed successfully");
							fUtil.flogResult("Failed", "plans detail", "Not displayede", 1);
						}

					} else {
						//logger.info("proper operator is not displayed");
						fUtil.flogResult("Failed", "proper Operator", "Not displayed", 1);
					}
				} else {
					//logger.info("proper Mobile number not displayed");
					fUtil.flogResult("Failed", "Updated mobile number", "Not displayed", 1);
				}

			} else {
				//logger.info("Mobile page not navigated successfully");
				fUtil.flogResult("Failed", "Page navigation", "Not successful", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * IN PWA This method needs to be called to select any particular category to
	 * start the journey Starting Point: Utilities landing page Inputs: categoryName
	 * as String, taken from data sheet End point: Corresponding page of any
	 * particular category after clicking on it Input : String category name which
	 * needs to be selected to start the journey
	 * 
	 */
	public void categorySelection_PWA(String categoryName) throws Exception {
		try {
			// String categoryName = fUtil.fgetDataNew1("FirstBill_Category").toUpperCase();

			if (gmethods.isElementVisible(tdlPayBill.get().hdrbillPayment, 10)) {
				//logger.info("Category Selection page is navigated to initiate BillPayment journey");
				fUtil.flogResult("Passed", "validating Category Selection Page is displayed",
						"Available, Category which needs to be selected : " + categoryName, 1);
				categoryName = categoryName.toUpperCase();
				//logger.info("Selecting required category as directed by user");

				switch (categoryName) {
				case "ELECTRICITY":
					tdlPayBill.get().Electricity.click();
					break;
				case "GAS":
					tdlPayBill.get().Gas.click();
					break;
				case "WATER":
					tdlPayBill.get().Water.click();
					break;
				case "DTH":
					tdlPayBill.get().DTH.click();
					break;
				case "BROADBAND":
					tdlPayBill.get().Broadband.click();
					break;
				case "LANDLINE":
					tdlPayBill.get().Landline.click();
					break;
				case "PREPAID":
					tdlPayBill.get().Mobile_Prepaid.click();
					break;
				case "POSTPAID":
					tdlPayBill.get().Mobile_Postpaid.click();
					break;
				case "FASTAG":
					tdlPayBill.get().FASTag.click();
					break;	
				}
			} else {
				//logger.info("Category Selection page is not navigated successfully to initiate BillPayment journey");
				fUtil.flogResult("Failed", "Category Selection Page is not displayed", "Not available", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * State selection method for ELECTRICITY category only This method will be
	 * executed only if category is Electricity Input: String category name, String
	 * State name
	 * 
	 */
	public void selectState_PWA(String category, String requiredState) throws Exception {
		try {
			// String category = fUtil.fgetDataNew1("FirstBill_Category").toUpperCase();
			// String requiredState = fUtil.fgetDataNew1("FirstBill_State");
			System.out.println(requiredState);
			if (category.equalsIgnoreCase("ELECTRICITY")) {
				//logger.info("Electricity category is selected. Hence Entering State Selection Method");
				Thread.sleep(5000);

				if (gmethods.isElementVisible(tdlPayBill.get().state_electricity, 10)) {
					// String expire=fUtil.fgetDataNew1("Expire").trim();
					// Select expire_type= new
					// Select(MyOffersPage.get().offerscreation_collection_time);
					// expire_type.selectByVisibleText(expire);
					Thread.sleep(3000);
					tdlPayBill.get().state_electricity.click();
					//logger.info("State Field is available for selection");
					fUtil.flogResult("Passed", "validating State Field is available",
							"Available, State which needs to be selected :" + requiredState, 1);

					String selectedState = tdlPayBill.get().state_electricity.getText();
					if (requiredState.contains(selectedState)) {
						//logger.info("AutoPopulated state is: " + selectedState
						//		+ " Which is also customer's choice of state");
						fUtil.flogResult("Passed", "State selected is: ", selectedState, 1);
					} else {
						//logger.info("Customer wants to select state: " + requiredState
						//		+ " but currently selected state is: " + selectedState);
						//logger.info("Click on State field to search for the required state");
						tdlPayBill.get().state_electricity.click();
						tdlPayBill.get().state_electricity.click();
						// String elexpath="//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ',
						// 'abcdefghijklmnopqrstuvwxyz') , '"+requiredState.toLowerCase()+"')]";
						String elexpath = "//*[contains(text(), '" + requiredState + "')]";
						gmethods.waitForObject("xpath", elexpath).click();
						System.out.println(elexpath);
						//logger.info("Click on State: '" + requiredState + "' successful");
						// Select expire_type= new Select(tdlPayBill.get().state_electricity);
						// expire_type.selectByVisibleText(requiredState);
						// TdlFetchBillAndBillersPage_Mobile.get().searchField_android.sendKeys(requiredState);
						// TdlFetchBillAndBillersPage_Mobile.get().availableSearchItem1_android.click();

						// Get the selected state and match if selected and required state are same
						String stateSelected = tdlPayBill.get().state_electricity.getText().trim();
						if (stateSelected.equalsIgnoreCase(requiredState)) {
							//logger.info("Selected State and Required State are same");
							fUtil.flogResult("Passed", "validating State Selection is done",
									"Done successfully, Selected State :" + stateSelected, 1);
						} else {
							//logger.info("Selected State and Required State are not same");
							fUtil.flogResult("Failed", "State Selection", "Not done successfully ;" + "Selected State :"
									+ stateSelected + " Required State :" + requiredState, 1);
						}
					}
				} else {
					//logger.info("State Field is not available for selection");
					fUtil.flogResult("Failed", "validating State Field is available or not",
							"Not available for selection", 1);
				}
			} else {
				//logger.info("Category is not Electricity, hence skipping State Selection Method");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * In PWA This method will be called to select Board for ELECTRICITY, WATER and
	 * to select Operator for GAS, BROADBAND, LANDLINE, DTH Starting Point: Select
	 * Board header, Get the board name from data sheet search it and select from
	 * the list End Point: get the text and validate if the expected board is same
	 * Input: String Board/Operator name, String category
	 * 
	 */
	public void selectBoardOrOperator_PWA(String requiredBoard, String category) throws Exception {
		try {
			 //String requiredBoard = fUtil.fgetDataNew1("FirstBill_Board");
			// String category = fUtil.fgetDataNew1("FirstBill_Category");

			if (category.equalsIgnoreCase("electricity")) {
				if (gmethods.isElementVisible(tdlPayBill.get().Operator, 10)) {
					//logger.info("Board selection field is available, hence clicking on it to select");
					fUtil.flogResult("Passed", "validate Board Field is available for selection",
							"Available, Board to be selected : " + requiredBoard, 1);
					// tdlPayBill.get().Operator.click();
					Thread.sleep(5000);
					String elexpath = "(//div[text()='"+ requiredBoard +"'])[1]";
					gmethods.waitForObject("xpath", elexpath).click();
					System.out.println(elexpath);
					// tdlPayBill.get().searchFieldElectricity_android.sendKeys(requiredBoard);
					// tdlPayBill.get().availableSearchItemElec_android.click();

					// Get the selected board and match if selected and required board are same
					String boardSelected = tdlPayBill.get().Operator.getAttribute("div").trim();
					if (boardSelected.matches(requiredBoard)) {
						//logger.info("Board selection is successful");
						fUtil.flogResult("Passed", "Board Selected is :" + boardSelected, "Successful", 1);
					} else {
						//logger.info("Board selection is not successful");
						fUtil.flogResult("Failed", "Board Selected is not same as board required :" + boardSelected
								+ " but Required electricity board :" + requiredBoard, "Not successful", 1);
					}
				} else {
					//logger.info("Board selection field is not available");
					fUtil.flogResult("Failed", "validating Board Selection field available or not", "Not available", 1);
				}
			} else {
				
				if (category.equalsIgnoreCase("gas | electricity | water | broadband | landline | dth"))
				{
				
				if (gmethods.isElementVisible(tdlPayBill.get().Operator, 10)) {
					//logger.info("Board or Operator selection field is available");
					fUtil.flogResult("Passed", "validating Board/Operator field is displayed",
							"Available, Board/Operator which needs to be selected :" + requiredBoard, 1);
			  		//tdlPayBill.get().Operator.click();
					//tdlPayBill.get().Operator.click();

					String elexpath = "(//div[contains(text(),'" + requiredBoard + "')])[1]";
					System.out.println(elexpath);
					gmethods.waitForObject("xpath", elexpath).click();
					System.out.println(elexpath);

					// Get the selected board and match if selected and required board are same
					String boardSelected = tdlPayBill.get().Operator.getAttribute("value").trim();
					if (boardSelected.equalsIgnoreCase(requiredBoard)) {
						//logger.info("Board or Operator selection is successful");
						fUtil.flogResult("Passed", "Board Selected is:" + boardSelected, "Successful", 1);
					} else {
						//logger.info("Board or Operator selection is not successful");
						fUtil.flogResult("Failed", "Board Selected :" + boardSelected
								+ " but Required electricity board :" + requiredBoard, "Not successful", 1);
					}
				} else {
					//logger.info("Board selection field is not available");
					
					fUtil.flogResult("Failed", "validating Board Selection field is available or not", "Not available",
							1);
				}
				}
				else {
					if (category.equalsIgnoreCase("fastag"))
					{
						if (gmethods.isElementVisible(tdlPayBill.get().FASTagBnak, 10)) {
							fUtil.flogResult("Passed", "validating Fasttag bank field is displayed",
									"Available, Fasttag bank which needs to be selected :" + requiredBoard, 1);
							String elexpath = "//div[contains(text(),'" + requiredBoard + "')]";
							System.out.println(elexpath);
							gmethods.waitForObject("xpath", elexpath).click();
							System.out.println(elexpath);
							
						}
					}
					else {
						fUtil.flogResult("Failed", "Validating Biller",
								"Not Available, This is not listed in the biller", 1);
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * In PWA Enter customer id/consumer no./K no. etc in the input text field for
	 * ELEC, GAS, WATER, BROADBAND, DTH, LANDLINE this method will be called after
	 * selecting state and board and before clicking on Fetch Bill button Input:
	 * String Customer Details 1, 2, 3 if applicable and also in exact order the
	 * details need to be entered to fetch/pay the bill
	 * 
	 */
	public void enterCustomerDetails_PWA(String customerDtls1, String customerDtls2, String customerDtls3)
			throws Exception {
		try {
			// String customerDtls1 = fUtil.fgetDataNew1("FirstBill_CustDtls1");
			// String customerDtls2 = fUtil.fgetDataNew1("FirstBill_CustDtls2");
			// String customerDtls3 = fUtil.fgetDataNew1("FirstBill_CustDtls3");

			if (customerDtls1.startsWith("~")) {
				customerDtls1 = customerDtls1.substring(1);
			}

			if (customerDtls2.startsWith("~")) {
				customerDtls2 = customerDtls2.substring(1);
			}

			if (customerDtls3.startsWith("~")) {
				customerDtls3 = customerDtls3.substring(1);
			}

			if (gmethods.isElementVisible(tdlPayBill.get().consumer_id, 5)) {
				//logger.info("First Input Text field available for selection");
				fUtil.flogResult("Passed", "validating First Input Text Field is displayed",
						"Available for the customer", 1);
				//logger.info("Entering customer details");
				System.out.println(customerDtls1);
				try {
					  Thread.sleep(2000);
				      tdlPayBill.get().consumer_id.click();
				      Thread.sleep(2000);
				      tdlPayBill.get().consumer_id.clear();
				      tdlPayBill.get().consumer_id.sendKeys(customerDtls1);
				      fUtil.flogResult("Passed", "Validate consumer id inserted", "Consumer id is inserted successfully", 1);
				      if(gmethods.isElementVisible(tdlPayBill.get().Nextbtn, 5)) 
						{
							
							 tdlPayBill.get().Nextbtn.click();
					    }
				}
				
				catch(Exception e) {
					fUtil.flogResult("Failed", "Validate consumer id inserted", "Consumer id is not inserted successfully", a);
				}
				try {
					if(gmethods.isElementVisible(tdlPayBill.get().MobilePrePostpaid, 30))
					{
					if (gmethods.isElementVisible(tdlPayBill.get().billAmount, 30)) {
						//logger.info("Proceed button is available and navigated successfully");
						fUtil.flogResult("Passed", "validating Proceed button is navigated", "Navigated successfully", 1);
						tdlPayBill.get().billAmount.click();
						tdlPayBill.get().billAmount.sendKeys("100");
						if (gmethods.isElementVisible(tdlPayBill.get().Proceedbtn, 30)) {
							
							tdlPayBill.get().Proceedbtn.click();
							
						} else {
							//logger.info("Proceed button not displayed");
							fUtil.flogResult("Failed", "Proceed button", "Not Displayed", 1);
						}
					} else {
						//logger.info("Proceed button is not available as not navigated successfully");
						fUtil.flogResult("Failed", "validating Proceed button is navigated or not",
								"Not navigated successfully", 1);
					}
			}	
				} catch (Exception e) {
					e.printStackTrace();
					//logger.info("Click on Proceed button unsuccessful");
					fUtil.flogResult("Failed", "Click on Proceed", e.getMessage(), 1);

				}
				//logger.info("RegEx valition");
				boolean errorFlag1 = regExValidation_PWA();
				boolean flag1 = gmethods.isElementClickable(tdlPayBill.get().btnFetchBill, 5);

				if ((gmethods.isElementVisible(tdlPayBill.get().addres_am_id, 5)) && flag1 == false
						&& errorFlag1 == false) {
					//logger.info("Second Input Text field available for selection");
					fUtil.flogResult("Passed", "validating Second Input Text Field is displayed",
							"Available for the customer", 1);
					//logger.info("Entering customer details");
					tdlPayBill.get().addres_am_id.sendKeys(customerDtls2);
					//logger.info("RegEx valition");
					boolean errorFlag2 = regExValidation_PWA();
					boolean flag2 = gmethods.isElementClickable(tdlPayBill.get().btnFetchBill, 5);

					if ((gmethods.isElementVisible(tdlPayBill.get().telephone_id, 5)) && flag2 == false
							&& errorFlag2 == false) {
						//logger.info("Third Input Text field available for selection");
						fUtil.flogResult("Passed", "validating Third Input Text Field is displayed",
								"Available for the customer", 1);
						//logger.info("Entering customer details");
						tdlPayBill.get().telephone_id.sendKeys(customerDtls3);
						//logger.info("RegEx valition");

					} else {
						//logger.info("Third Input Text field is not available for selection");
						fUtil.flogResult("Passed", "third Input Text Field", "Not required for bill fetch", 1);
					}
				} else {
					//logger.info("Second Input Text field is not available for selection");
					fUtil.flogResult("Passed", "Second Input Text Field", "Not required for bill fetch", 1);
				}
			} else {
				//logger.info("First Input Text field is not available for selection");
				fUtil.flogResult("Failed", "Input Text Field", "Not available to the customer", 1);
			}

			boolean errorFlag3 = regExValidation_PWA();
			boolean flag3 = gmethods.isElementClickable(tdlPayBill.get().btnFetchBill, 3);
			if (errorFlag3 == false && flag3 == true) {
				//logger.info("No error message displayed and also Fetch Bill button is enabled");
				fUtil.flogResult("Passed", "validating Customer details entry and Fetch Bill button is activated",
						"Successful", 1);
			} else {
				//logger.info("Error message displayed and also Fetch Bill button is not enabled");
				fUtil.flogResult("Failed", "validating Customer details entry and Fetch Bill button is actvated",
						"Not successful", 1);
				
		} 
			
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	}		

	/*
	 * In PWA This method will validate whether Fetch Bill button is enabled and
	 * Consent is available or not for the customer or Proceed button is enabled for
	 * Quick Pay billers where there will be no consent needs to be given by the
	 * customer - for all category and all billers Input: String consent given by
	 * customer
	 * 
	 */
	public void fetchBillAndConsentOrQuickPay_PWA(String consent,String saveAs) throws Exception {
		try {
			// String consent = fUtil.fgetDataNew1("FirstBill_Consent").toUpperCase();

			if (gmethods.isElementClickable(tdlPayBill.get().btnFetchBill, 10)) {
				//logger.info("Fetch Bill or Quick Pay button is enabled after successfully entering customer details");
				fUtil.flogResult("Passed", "validating Fetch Bill or Quick Pay button is activated", "Activated", 1);
				//logger.info("Clicking on fetch Bill to fetch bill details or Proceed button for Quick Pay billers");
				tdlPayBill.get().btnFetchBill.click();

				/*if (gmethods.isElementVisible(tdlPayBill.get().consent, 5)) {
					//logger.info(
						//	"Consent Pop up displayed for Fetch Bill billers as the same has not been given by customer before");
					fUtil.flogResult("Passed", "Customer Consent popup is displayed",
							"Required and displayed. Consent Needs to be given as : " + consent, 1);

					switch (consent) {
					case "YES":
						System.out.println("Consent is given as - Yes");
						tdlPayBill.get().yes_option.click();
						break;

					case "NO":
						System.out.println("Consent is given as - No");
						tdlPayBill.get().No_option.click();
						break;

					default:
						System.out.println("Consent is No by default");
						tdlPayBill.get().No_option.click();
					}
				} else {
					//logger.info(
					//		"Consent has already provided by the customer for Fetch Bill billers or not available for Quick Pay billers");
					fUtil.flogResult("Passed", "validating Customer Consent displayed or not",
							"Not available as already given", 1);
				}*/
			}
			else {
				//logger.info("Neither Fetch Bill button nor Proceed button is enabled to proceed further");
				fUtil.flogResult("Failed", "validating Fetch Bill button or Quick Pay button is enabled or not",
						"Not enabled", 1);
			}
				if(gmethods.isElementVisible(tdlPayBill.get().labelField, 5)) {
					
					fUtil.flogResult("Passed", "Validating Label Field displayed or not",
							"Label field available", 1);
					tdlPayBill.get().labelField.click();
					tdlPayBill.get().labelField.sendKeys(saveAs+Keys.SPACE);	
				}
				else {
					fUtil.flogResult("Failed", "Validating Label Field displayed or not",
							"Label field is not available", 1);
				}
				if(gmethods.isElementVisible(tdlPayBill.get().addbilltocart, 5)) {
					
					fUtil.flogResult("Passed", "Validating Add Bill to cart button displayed or not",
							"Add Bill to cart available", 1);
					tdlPayBill.get().addbilltocart.click();	
				}
				else {
					fUtil.flogResult("Failed", "Validating Add Bill to cart button displayed or not",
							"Add Bill to cart is not available", 1);
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean regExValidation_PWA() throws Exception {
		boolean regEx = gmethods.isElementVisible(tdlPayBill.get().msgError, 5);
		return regEx;
	}

	/*
	 * In PWA Fetched bill details validation for all those billers which will be
	 * fetching bill details this method will also validate Partial payment and
	 * change the amount if required Input: String "Partial Pay availability",
	 * String "Partial Pay Amount"
	 * 
	 */
	public void fetchedBillDetailsAndPartialPayment_PWA(String isPartialPayAvailable, String partialPayAmount,
			String category) throws Exception {
		try {
			// String isPartialPayAvailable =
			// fUtil.fgetDataNew1("FirstBill_IsPartialPayAvailable").toUpperCase();

			// gmethods.hideKeyboardMobile();
			if (gmethods.isElementVisible(tdlPayBill.get().total_amo_text, 10)) {
				//logger.info("Bill has been fetched successfully");
				fUtil.flogResult("Passed", "validating Bill Fetch status", "Successful", 1);

				// To get biller name and other details
				// //logger.info("Getting Biller name and other details");
				// for (WebElement elm : tdlPayBill.get().billerDtlsOnFetchedBillPg_android) {
				// System.out.println("\nBill details : " + elm.getAttribute("value"));
				// }

				// Consumer Name Validation -->
				// //logger.info("Consumer Name Validation");
				// System.out.println("Consumer Name : "
				// + tdlPayBill.get().consumer_name.getText().trim());
				// if (tdlPayBill.get().consumer_name.getText().trim()
				// .equalsIgnoreCase("Bill No")) {
				// //logger.info("Consumer Name is not displayed");
				// fUtil.flogResult("Failed", "Consumer Name", "Not displayed", 1);
				// } else {
				// //logger.info("Consumer Name is displayed");
				// fUtil.flogResult("Failed", "Consumer Name : ",
				// tdlPayBill.get().consumer_name.getText().trim(), 1);
				// }
				if (category.equalsIgnoreCase("DTH")) {
					//logger.info("Bill Date Validation");
					System.out.println("Bill Date : " + tdlPayBill.get().bill_date.getText().trim());

					//logger.info("Bill Due Date Validation");
					System.out.println("Bill Due Date : " + tdlPayBill.get().due_date.getText().trim());
				}
				//logger.info("Amount and Convenience Fee Validation");
				System.out.println("Bill Amount : " + tdlPayBill.get().total_Amount.getText().trim() + "\n"
						+ "Convenience fee details : " + tdlPayBill.get().convenience_fee_amount.getText().trim());

				// Partial Payment Validation
				if (isPartialPayAvailable.equalsIgnoreCase("YES")) {
					// String partialPayAmount = fUtil.fgetDataNew1("FirstBill_PartialPayAmnt");

					if (partialPayAmount.startsWith("~")) {
						partialPayAmount = partialPayAmount.substring(1);
					}
					//logger.info("Partial Payment is available for the biller");
					boolean editAmount = gmethods.isElementClickable(tdlPayBill.get().bill_amount, 5);
					if (editAmount == true) {
						//logger.info("Amount field is editable, hence Partial Payment is enabled for this biller");
						fUtil.flogResult("Passed", "validating Partial Payment is displayed",
								"Enabled, Payment amount field is clickable to amend", 1);
						//logger.info("Changing amount as per the requirement");
						tdlPayBill.get().bill_amount.click();
						tdlPayBill.get().bill_amount.clear();
						tdlPayBill.get().bill_amount.sendKeys(partialPayAmount);

					} else {
						//logger.info(
						//		"Amount field is not editable, hence Partial Payment is not enabled for this biller");
						fUtil.flogResult("Failed", "validating Partial Payment Field detail", "Not clickable to edit",
								1);
					}
				} else {
					//logger.info("Partial Payment is not available for this biller");
					fUtil.flogResult("Passed", "validating Partial Payment is available or not",
							"Not available for this biller", 1);
				}
				String convenienceFeeMsg = tdlPayBill.get().convenience.getText().trim().toLowerCase();
				if (convenienceFeeMsg.contains("convenience")) {
					//logger.info("Amount has been changed Successfully");
					//logger.info("Convenience Fee details : " + convenienceFeeMsg);
					fUtil.flogResult("Passed", "validating Amount got update for Partial Payment",
							"Changed Amount: " + tdlPayBill.get().convenience_fee_amount.getText().trim(), 1);
				} else {
					//logger.info("Amount has not been changed succesfully as error message displayed : "
						//	+ convenienceFeeMsg);
					fUtil.flogResult("Failed", "Amount update for Partial Payment",
							"Not done. Error Message displayed : " + convenienceFeeMsg, 1);
				}
			} else {
				//logger.info("Bill has not been fetched successfully");
				fUtil.flogResult("Failed", "validating Bill Fetch status", "not successful", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * In PWA This method will validate Save As and depending on the journey type
	 * click on Add Bill to add multiple bills or Not Now to proceed to Review Page
	 * 
	 */
	public void saveAsAndAddBill_PWA(String saveAs, String addAnotherBill) throws Exception {
		try {
			// String saveAs = fUtil.fgetDataNew1("FirstBill_SaveAs");
			// String proceedToPayment =
			// fUtil.fgetDataNew1("FirstBill_ProceedToPay").toUpperCase();

			addAnotherBill = addAnotherBill.toUpperCase();
			// gmethods.hideKeyboardMobile();
			// if (gmethods.isElementVisible(tdlPayBill.get().save_text_bill, 10)) {
			// //logger.info("Save As option is available to the customer");
			// fUtil.flogResult("Passed", "Save As option", "Available", 1);
			// //logger.info("Available Save As options are : ");
			// tdlPayBill.get().save_text_bill.click();
			// for (WebElement elm : tdlPayBill.get().saveas_options) {
			// System.out.println("Available Save As Options are : ");
			// System.out.println("\n" + elm.getText().trim());
			// }
			// // Save As selection & Validation
			//
			// tdlPayBill.get().saveas_field.click();
			// try {
			// String selectedOption =
			// tdlPayBill.get().save_text_bill.getAttribute("innertext");
			// String selectedOption2 = tdlPayBill.get().saveas_field.getAttribute("value");
			// if (!(selectedOption.equalsIgnoreCase("null")) |
			// !(selectedOption2.equalsIgnoreCase("null"))) {
			//
			// //logger.info("Save As is already selected. Selected Option is : " +
			// selectedOption);
			// fUtil.flogResult("Passed", "Save As Option",
			// "Selected as : " + tdlPayBill.get().save_text_bill.getText(), 1);
			// }
			// } catch(Exception ee){
			// //logger.info("Save As field is Null, hence selecting as per data sheet");
			// tdlPayBill.get().save_text_bill.click();
			// tdlPayBill.get().save_text_bill.sendKeys(saveAs);
			// String selectedSaveAs =
			// tdlPayBill.get().save_text_bill.getAttribute("value").trim();
			// if (selectedSaveAs.equalsIgnoreCase(saveAs)) {
			// //logger.info("Save As option is selected successfully and matched with the
			// expected value");
			// fUtil.flogResult("Passed", "Save As Selection", "Matched with expected
			// value", 1);
			// } else {
			// //logger.info(
			// "Save As option is not selected successfully and not matched with the
			// expected value");
			// fUtil.flogResult("Failed", "Save As Selection", "Not matched with expected
			// value"
			// + "Expected Value : " + saveAs + " Selected Value: " + selectedSaveAs, 1);
			// }
			// }
			//

			// Add Bill
			if (gmethods.isElementVisible(tdlPayBill.get().add_bill, 10)) {
				//logger.info("Add Bill button is available");
				fUtil.flogResult("Passed", "validating Add Bill popup is available", "Available to proceed further", 1);
				//logger.info("Clicking on Add bill button");
				//tdlPayBill.get().add_bill.click();

				if (gmethods.isElementVisible(tdlPayBill.get().add_bill, 10)) {
					//logger.info("Add Bill Alert pop up displayed");
					fUtil.flogResult("Passed", "validating Add Bill Alert Pop Up is displayed", "Displayed", 1);

					switch (addAnotherBill) {
					case "YES":
						//logger.info("Customer opted for adding another bill");
						//logger.info("Clicking on Add Bill button to navigate to category Selection Page");
						tdlPayBill.get().add_bill.click();
						break;

					case "NO":
						//logger.info("Customer opted for proceeding to Payment page");
						//logger.info("Clicking on Not Now button to navigate to Review Page");
						tdlPayBill.get().Proceedbtn.click();
						break;

					default:
						//logger.info("By Defaut customer will be navigated to Payment page");
						//logger.info("Clicking on Not Now button");
						tdlPayBill.get().not_now.click();
					}
				} else {
					//logger.info("Add Bill Alert pop up not displayed");
					fUtil.flogResult("Failed", "Add Bill Alert Pop Up status", "Not displayed", 1);
				}

			} else {
				//logger.info("Add Bill alert pop up not displayed");
				fUtil.flogResult("Failed", "Add Bill alert pop up status", "Not displayed", 1);
			}
			// } else {
			// //logger.info("Save As option is not available");
			// fUtil.flogResult("Failed", "Save As option", "Not available", 1);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This Function will accept the Terms and conditions which get displayed in
	 * Android app after clicking on the Signin button
	 */

	public void googleTermsServices_Mobile() throws Exception {
		try {
			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			System.out.println("Environment :: " + environment);
			if (environment.equalsIgnoreCase("android")) {
				if (gmethods.isElementVisible_mobile(TdlSignUpMobile.get().acceptChromeTerms_android, 10)) {

					//logger.info("google terms ans services page is displayed");
					TdlSignUpMobile.get().acceptChromeTerms_android.click();

					if (gmethods.isElementVisible_mobile(TdlSignUpMobile.get().nextbtn_android, 10)) {

						//logger.info("next page after terms and services page is displayed");
						TdlSignUpMobile.get().nextbtn_android.click();

					} else {
						//logger.info("next page after chrome header page is not displayed");
					}

					if (gmethods.isElementVisible_mobile(TdlSignUpMobile.get().signInChrome_android, 10)) {

						//logger.info("final page to sign in to chrome is displayed");
						TdlSignUpMobile.get().negativeBtn_android.click();

					} else {
						//logger.info("final signin page is not displayed");
					}

				} else {
					//logger.info("chrome header page is not displayed to accept terms and services");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This Function will toggle Wifi On/Off in Real Android Device Input : udid of
	 * the the device flag = true for Enabling, False for Enabling
	 * 
	 */
	public synchronized boolean toggleWifiAndroidRealDevice(String udid, boolean flag) {
		synchronized (this) {
			String flgEnabled = (flag) ? "enable" : "disable";
			boolean osFlag = true;

			if (oSystem.toLowerCase().contains("mac")) {
				osFlag = false;
			}

			List<String> output = Console.runProcess(osFlag,
					"adb -s " + udid + " shell am broadcast -a io.appium.settings.wifi --es setstatus " + flgEnabled);
			for (String line : output) {
				System.err.println(line);
				if (line.equalsIgnoreCase("Broadcast completed: result=-1"))
					return true;
			}
			return false;
		}
	}

	/*
	 * This Function will toggle MobileData On/Off in Real Android Device Input :
	 * udid of the the device flag = true for Enabling, False for Enabling
	 * 
	 */
	public synchronized boolean toggleMobileDataAndroidRealDevice(String udid, boolean flag) {
		synchronized (this) {
			String flgEnabled = (flag) ? "enable" : "disable";
			boolean osFlag = true;

			if (oSystem.toLowerCase().contains("mac")) {
				osFlag = false;
			}

			List<String> output = Console.runProcess(osFlag, "adb -s " + udid
					+ " shell am broadcast -a io.appium.settings.data_connection --es setstatus " + flgEnabled);
			for (String line : output) {
				System.err.println(line);
				if (line.equalsIgnoreCase("Broadcast completed: result=-1"))
					return true;
			}
			return false;
		}
	}

	public static class Console {
		private final static String[] WIN_RUNTIME = { "cmd.exe", "/C" };
		private final static String[] OS_LINUX_RUNTIME = { "/bin/bash", "-l", "-c" };

		private Console() {

		}

		private static <T> T[] concat(T[] first, T[] second) {
			T[] result = Arrays.copyOf(first, first.length + second.length);
			System.arraycopy(second, 0, result, first.length, second.length);
			return result;
		}

		public static List<String> runProcess(boolean isWin, String... command) {
			String[] allCommand = null;
			try {
				if (isWin) {
					allCommand = concat(WIN_RUNTIME, command);
				} else {
					allCommand = concat(OS_LINUX_RUNTIME, command);
				}
				ProcessBuilder pb = new ProcessBuilder(allCommand);
				pb.redirectErrorStream(true);
				Process p = pb.start();
				p.waitFor();
				BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String _temp = null;
				List<String> line = new ArrayList<String>();
				while ((_temp = in.readLine()) != null) {
					line.add(_temp);
				}
				return line;

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	/*
	 * This Function will toggle the Wifi to On/Off Input - boolean value - true :
	 * to switch on the Wifi Input - boolean value - false : to switch off the Wifi
	 */
	public void pCloudyToggleWifiAndroid(boolean flag) {
		try {
			appiumDriver.get().executeScript("pCloudy_enableWifi", flag);
		} catch (Exception e) {
			//logger.error("Exception caught while toggling Wifi in pCloudy for Android device : " + e.getMessage());
		}
	}

	/*
	 * postpaid mobile number validation
	 */

	public void customerDetailsEntry_Postpaid_android(String mobileNoToRchrg) throws Exception {
		try {
			// String mobileNoToRchrg = "9163572010"; //
			// fUtil.fgetDataNew1("FirstBill_CustDtls1");

			if (mobileNoToRchrg.startsWith("~")) {
				mobileNoToRchrg = mobileNoToRchrg.substring(1);
			}

			// gmethods.categorySelection_android("POSTPAID");

			if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().mobilePgHdrTxt_android, 10)) {
				//logger.info("Mobile Page navigated successfully");
				fUtil.flogResult("Passed", "Page Navigated : ",
						TdlFetchBillAndBillersPage_Mobile.get().mobilePgHdrTxt_android.getText().trim(), 1);

				// validating mobile number to recharge as per the data given by user

				String defaultMobNo = TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.getAttribute("text")
						.trim();
				if (defaultMobNo != null && defaultMobNo.contentEquals(mobileNoToRchrg)) {
					//logger.info("Mobile number which needs to be recharged populated by default");
					fUtil.flogResult("Passed", "Mobile Number field", "Autopopulated", 1);
					Thread.sleep(5000);

				} else if (defaultMobNo != null && !(defaultMobNo.contentEquals(mobileNoToRchrg))) {
					//logger.info("Recharge mobile number is not same as default mobile number");
					//logger.info("Changing mobile number");
					TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.click();
					TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.clear();
					TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.sendKeys(mobileNoToRchrg);
					Thread.sleep(5000);
				} else {
					//logger.info("Mobile number field has not been autopopulated");
					fUtil.flogResult("Failed", "Mobile Number", "Not autopopulated", 1);
				}

				// entered mobile no is same as mobile no tho recharge

				String enteredMoNum = TdlFetchBillAndBillersPage_Mobile.get().mobileNoField_android.getText();
				if (enteredMoNum.contentEquals(mobileNoToRchrg)) {
					//logger.info("Mobile number changed successfully");
					fUtil.flogResult("Passed", "Mobile Number update", "Successful", 1);

					Thread.sleep(3000);
				} else {
					//logger.info("Mobile number not changed successfully");
					fUtil.flogResult("Failed", "Mobile Number update", "Not successful", 1);
				}

			} else {
				//logger.info("Mobile page not navigated successfully");
				fUtil.flogResult("Failed", "Page navigation", "Not successful", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * operator validation in postpaid in bill payment
	 * 
	 */

	public void operatorValidation_Postpaid_android(String operator, String consent) throws Exception {

		try {

			if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().addBillBtn_android, 10)) {

				//logger.info("fetch bill page is displayed");
				fUtil.flogResult("Passed", "Fetch Bill Page", "navigated successfully", 1);
				TdlFetchBillAndBillersPage_Mobile.get().addBillBtn_android.click();
				// } else if (gmethods
				// .isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().operatorChangeAlert_android,
				// 10)) {
				// //logger.info("operator displayed need to be changed");
				// TdlFetchBillAndBillersPage_Mobile.get().okBtnPostpaid_android.click();
				// fUtil.flogResult("Passed", "change operator", "displayed successfully", 1);
				// TdlFetchBillAndBillersPage_Mobile.get().changeOperator_android.click();

				/*
				 * if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().
				 * operatorPgHdr_android, 10)) {
				 * 
				 * //logger.info("operator page displayed");
				 * TdlFetchBillAndBillersPage_Mobile.get().searchField_android.click();
				 * fUtil.flogResult("Passed", "select opertor", "displayed successfully", 1);
				 * TdlFetchBillAndBillersPage_Mobile.get().searchField_android.sendKeys(operator
				 * ); Thread.sleep(5000);
				 * TdlFetchBillAndBillersPage_Mobile.get().availableSearchItem1_android.click();
				 */

					// consent selection
					if (gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().consentMessage_android,
							5)) {
						//logger.info(
						//		"Consent Pop up displayed for Fetch Bill billers as the same has not been given by customer before");
						fUtil.flogResult("Passed", "Customer Consent",
								"Required and displayed. Consent Needs to be given as : " + consent, 1);

						switch (consent) {
						case "YES":
							System.out.println("Consent is given as - Yes");
							TdlFetchBillAndBillersPage_Mobile.get().btnAddnow.click();
							break;

						case "NO":
							System.out.println("Consent is given as - No");
							TdlFetchBillAndBillersPage_Mobile.get().btnAddLater.click();
							break;

						default:
							System.out.println("Consent is No by default");
							TdlFetchBillAndBillersPage_Mobile.get().btnAddLater.click();
						}
					} else {
						//logger.info(
						//		"Consent has already provided by the customer for Fetch Bill billers or not available for Quick Pay billers");
						fUtil.flogResult("Passed", "Customer Consent", "Not available as already given", 1);
					}

				/*} else {
					//logger.info("operator page not displayed");
					fUtil.flogResult("Failed", "select opertor", "not displayed successfully", 1);
				}*/
			} else {
				//logger.info("operator change is not possible");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/*
	 * This function will Connect to Mobile Device in Between the Execution of
	 * testcase using which user can switch from Web to Mobile App and Vice Vers
	 * Input - Platform (ios / Android) Author - Anil Kumar Kedia (679167)
	 * 
	 */
	public void connectMyDevice(String platform) throws Exception {
		currentPlatform = platform;
		channel = "Mobile";

		try {
			if (fUtil.readInput("ConnectRealDevice").equalsIgnoreCase("yes")
					&& fUtil.readInput("ConnectAnyDeviceInPcloudy").equalsIgnoreCase("no")) {
				// connectRealAndroidDevice();
				connectRealDevice(platform);
			} else if (fUtil.readInput("ConnectAnyDeviceInPcloudy").equalsIgnoreCase("yes")
					&& fUtil.readInput("ConnectRealDevice").equalsIgnoreCase("no")) {
				connectAnyAvailableDeviceInPcloudy(platform);
			} else if (fUtil.readInput("ConnectAnyDeviceInPcloudy").equalsIgnoreCase("no")
					&& fUtil.readInput("ConnectRealDevice").equalsIgnoreCase("no")) {
				connectSpecificDeviceInPcloudy(platform);
			} else {
				System.out.println("\n\n**** NO PROPER SETTINGS IN CONFIG FILE ****");
				System.out.println("**** PLEASE SET THE PROPERTIES PROPERLY **** \n\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This function shift the channel back to original input which user has
	 * specified in the Test Plan Author - Anil Kumar Kedia (679167)
	 */
	public void backToWeb() throws Exception {
		try {
			channel = scenarioChannelMap.get(scenarioName.get());
			fUtil.flogResult("Passed", "Switching to Web", "Successfully Switched", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function name: skipTourPageMobilePwa This function will validate after sign
	 * in, whether Tour Page is available if so, then will Skip the tour to proceed
	 * to Home page for Mobile devices Arguments: NA
	 * 
	 */
	public void appTourMobilePwa() {
		try {
			String environment = "";
			if (currentPlatform.isEmpty())
				environment = BaseScript.platform;
			else
				environment = currentPlatform;

			boolean skipFlag = false;
			boolean nextBtnFlag = false;

			if (environment.equalsIgnoreCase("chrome") || environment.equalsIgnoreCase("firefox")
					|| environment.equalsIgnoreCase("opera") || environment.equalsIgnoreCase("edge")) {
				environment = "pwa";
			}

			switch (environment.toLowerCase()) {
			case "pwa":
				skipFlag = isElementVisible(TdlHomePage.get().skipTourTextView, 10);
				nextBtnFlag = isElementVisible(TdlHomePage.get().nextBtn, 10);

				if (skipFlag && nextBtnFlag) {
					// //logger.info("Tour Page is visible to user");
					// //logger.info("Skipping tour page to proceed further");
					// TdlHomePage.get().skipTourTextView.click();
					while (isElementVisible(TdlHomePage.get().nextBtn, 10)) {
						String appName = TdlHomePage.get().appTourWidgetName.getText();
						fUtil.flogResult("Passed", "App Tour Navigation", "Navigated to " + appName, 1);
						TdlHomePage.get().nextBtn.click();
					}
					if (isElementVisible(TdlHomePage.get().okGotIt, 10)) {
						String appName = TdlHomePage.get().appTourLastWidgetName.getText();
						fUtil.flogResult("Passed", "App Tour Navigation", "Navigated to " + appName, 1);
						TdlHomePage.get().okGotIt.click();
					}
				} else {
					//logger.info("Skip Tour page is not visible to user");
				}
				break;
			case "pwa mobile":
				skipFlag = isElementVisible(TdlHomePage.get().skipTourTextView, 10);
				nextBtnFlag = isElementVisible(TdlHomePage.get().nextBtn, 10);

				if (skipFlag) {
					//logger.info("Tour Page is visible to user");
					//logger.info("Skipping tour page to proceed further");
					TdlHomePage.get().skipTourTextView.click();
				} else {
					//logger.info("Tour page is not visible to user");
				}
				break;
			case "android":
				skipFlag = isElementVisible_mobile(TdlHomeMobile.get().skipTourTextView_android, 10);
				if (skipFlag) {
					//logger.info("Tour Page is visible to user");
					//logger.info("Skipping tour page to proceed further");
					TdlHomeMobile.get().skipTourTextView_android.click();
				} else {
					//logger.info("Tour page is not visible to user");
				}
				break;
			case "ios":
				skipFlag = isElementVisible_mobile(TdlHomeMobile.get().skipTourTextView_ios, 10);
				if (skipFlag) {
					//logger.info("Tour Page is visible to user");
					//logger.info("Skipping tour page to proceed further");
					TdlHomeMobile.get().skipTourTextView_ios.click();
				} else {
					//logger.info("Tour page is not visible to user");
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Function Name : validateWidgetsInUserHomePage Author : Anil Kumar Kedia - TCS
	 * (679167) This Function will validate all the widgets like Home Button,
	 * Channels button, Apps Button, Vault Button, Cart Button, Discovery btn,
	 * Channels Ribbon in R2 Home Page
	 */
	public void validateWidgetsInUserHomePage() throws Exception {
		try {

			boolean homeBtn = isElementVisible(TdlHomePage.get().homeBtn, 10);
			if (homeBtn) {
				highlightElement(TdlHomePage.get().homeBtn);
				fUtil.flogResult("Passed", "User Homepage", "Home Button loaded properly ", 1);
			} else {
				//logger.error("User Homepage loading failed !");
				fUtil.flogResult("Failed", "User Homepage", "Home Button not Visible in Home page ", 1);
			}
/*
			boolean channelBtn = isElementVisible(TdlHomePage.get().channelsBtn, 10);
			if (channelBtn) {
				highlightElement(TdlHomePage.get().channelsBtn);
				fUtil.flogResult("Passed", "User Homepage", "Channel Button loaded properly ", 1);
			} else {
				//logger.error("User Homepage loading failed !");
				fUtil.flogResult("Failed", "User Homepage", "Channel Button not Visible in Home page ", 1);
			}
*/
			// boolean appBtn = isElementVisible(TdlHomePage.get().appsBtn, 10);
			// if (appBtn) {
			// highlightElement(TdlHomePage.get().appsBtn);
			// fUtil.flogResult("Passed", "User Homepage", "App Button loaded properly ",
			// 1);
			// } else {
			// //logger.error("User Homepage loading failed !");
			// fUtil.flogResult("Failed", "User Homepage", "App Button not Visible in Home
			// page ", 1);
			// }

			boolean vaultBtn = isElementVisible(TdlHomePage.get().vaultLink, 10);
			if (vaultBtn) {
				highlightElement(TdlHomePage.get().vaultLink);
				fUtil.flogResult("Passed", "User Homepage", "Vault Button loaded properly ", 1);
			} else {
				//logger.error("User Homepage loading failed !");
				fUtil.flogResult("Failed", "User Homepage", "Vault Button not Visible in Home page ", 1);
			}

			// boolean cartBtn = isElementVisible(TdlHomePage.get().cartBtn, 10);
			// if (cartBtn) {
			// highlightElement(TdlHomePage.get().cartBtn);
			// fUtil.flogResult("Passed", "User Homepage", "Cart Button loaded properly ",
			// 1);
			// } else {
			// //logger.error("User Homepage loading failed !");
			// fUtil.flogResult("Failed", "User Homepage", "Cart Button not Visible in Home
			// page ", 1);
			// }

			boolean discoveryBtn = isElementVisible(TdlHomePage.get().discoveryBtn, 10);
			if (discoveryBtn) {
				highlightElement(TdlHomePage.get().discoveryBtn);
				fUtil.flogResult("Passed", "User Homepage", "Discovery Button loaded properly ", 1);
			} else {
				//logger.error("User Homepage loading failed !");
				fUtil.flogResult("Failed", "User Homepage", "Discovery Button not Visible in Home page ", 1);
			}
/*
			boolean channelRibbon = isElementVisible(TdlHomePage.get().channelRibbon, 20);
			if (channelRibbon) {
				scrollToViewElement(TdlHomePage.get().channelRibbon);
				highlightElement(TdlHomePage.get().channelRibbon);
				fUtil.flogResult("Passed", "User Homepage", "Channels Ribbon loaded properly ", 1);
			} else {
				//logger.error("User Homepage loading failed !");
				fUtil.flogResult("Failed", "User Homepage", "Channels Ribbon not Visible in Home page ", 1);
			}
			*/
		} catch (Exception e) {
			fUtil.flogResult("Failed", "General Function : validateVaultLinkInUserHomePage ",
					"Exception Caught : " + e.getMessage(), 0);
		}
	}

	/*
	 * Function Name : checkAppStateAndLaunchAppIfNotRunning This Function will
	 * check if the app installed is running in Background or Foreground If Running
	 * in Background, then it will launch the app and run it in foreground Author :
	 * Anil Kumar Kedia - TCS (679167)
	 */
	public void checkAppStateAndLaunchAppIfNotRunning() throws Exception {
		Thread.sleep(5000);

		String appRunningState = appiumDriver.get().queryAppState("com.tatadigital.tcp.dev").toString();
		System.out.println(appRunningState);

		if (appRunningState.equals("RUNNING_IN_BACKGROUND")
				|| appRunningState.equals("RUNNING_IN_BACKGROUND_SUSPENDED")) {
			launchApp();
			Thread.sleep(10000);
			appRunningState = appiumDriver.get().queryAppState("com.tatadigital.tcp.dev").toString();
			System.out.println(appRunningState);

			if (appRunningState.equals("RUNNING_IN_FOREGROUND")) {
				System.out.println("App Running in Foreground Successfully");
			} else {
				fUtil.flogResult("Fail", "App Running State",
						"App Not running in foreground. Current Running State : " + appRunningState, 1);
			}
		} else {
			System.out.println("App Running in Foreground Successfully");
		}
	}

	/*
	 * operator and circle selection for PREPAID
	 * 
	 */

	public void operatorsPrepaid_Android(String requiredOperator, String requiredCircle) throws Exception {
		try {

			if (gmethods.isElementVisible(TdlFetchBillAndBillersPage_Mobile.get().prepaidOperatorHdr_android, 10)) {
				//logger.info("Mobile Page navigated successfully");
				fUtil.flogResult("Passed", "Page Navigated : ",
						TdlFetchBillAndBillersPage_Mobile.get().prepaidOperatorHdr_android.getText().trim(), 1);
				TdlFetchBillAndBillersPage_Mobile.get().prepaidOperatorHdr_android.click();
				TdlFetchBillAndBillersPage_Mobile.get().searchField_android.sendKeys(requiredOperator);
				
				gmethods.isElementVisible_mobile(TdlFetchBillAndBillersPage_Mobile.get().availableSearchItem_android, 40);
				TdlFetchBillAndBillersPage_Mobile.get().availableSearchItem_android.click();

				if (gmethods.isElementVisible(TdlFetchBillAndBillersPage_Mobile.get().prepaidCircleHdr_android, 10)) {

					//logger.info("select circle page is displayed");
					fUtil.flogResult("Passed", "circle page displayed", "Successful", 1);

					TdlFetchBillAndBillersPage_Mobile.get().searchField_android.sendKeys(requiredCircle);

					TdlFetchBillAndBillersPage_Mobile.get().circleoption_android.click();

					fUtil.flogResult("Passed", "operator and circle selected", "Successful", 1);

					fUtil.flogResult("Passed", "plan selection page navigated", "Successful", 1);

				} else {
					//logger.info("Mobile prepaid circle not displayed");
					fUtil.flogResult("Failed", "circle", "Not displayed", 1);
				}

			} else {
				//logger.info("Mobile prepaid operator page not navigated successfully");
				fUtil.flogResult("Failed", "operator page navigation", "Not successful", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String randomnumberUniversalCart() {

		int leftLimit = 0; // numeral '0'
		int rightLimit = 0;
		int targetStringLength = 0;
		Random random = new Random();
		String generatedString = "";

		leftLimit = 48; // numeral '0'
		rightLimit = 57;
		targetStringLength = 5;
		// String generatedString ="";
		generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		String randomNumber = "TCP_000" + generatedString;
		return randomNumber;

	}

	// JIRA Defect creation//

	public String bugLogging() throws Exception {
		String bugID = "";
		try {

			String defectCategory = fUtil.fgetDataNew1("DefectCategory");
			String defectSeverity = fUtil.fgetDataNew1("Severity");
			String platform = fUtil.fgetDataNew1("Platform");

			RestAssured.baseURI = fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("Authorization", fUtil.fgetDataNew1("Authorizationbug"));

			JSONObject json = new JSONObject();

			HashMap<Object, Object> mapFields = new HashMap<Object, Object>();
			HashMap<Object, Object> mapProject = new HashMap<Object, Object>();
			mapProject.put("key", fUtil.fgetDataNew1("key"));
			mapFields.put("project", mapProject);

			mapFields.put("summary", fUtil.fgetDataNew1("summary"));
			mapFields.put("description", fUtil.fgetDataNew1("description"));

			HashMap<Object, Object> mapComponents = new HashMap<Object, Object>();
			mapComponents.put("name", fUtil.fgetDataNew1("components"));
			JSONArray componentsA = new JSONArray();
			componentsA.add(0, mapComponents);
			mapFields.put("components", componentsA);

			HashMap<Object, Object> mapFixVersions = new HashMap<Object, Object>();
			mapFixVersions.put("name", fUtil.fgetDataNew1("fixVersions"));
			JSONArray fixVersionsA = new JSONArray();
			fixVersionsA.add(0, mapFixVersions);
			mapFields.put("fixVersions", fixVersionsA);

			// Defect Category
			HashMap<Object, Object> mapCustomfield_10040 = new HashMap<Object, Object>();
			mapCustomfield_10040.put("id", defectCategory);
			mapFields.put("customfield_10040", mapCustomfield_10040);

			// Defect Severity
			HashMap<Object, Object> mapCustomfield_10041 = new HashMap<Object, Object>();
			mapCustomfield_10041.put("id", defectSeverity);
			mapFields.put("customfield_10041", mapCustomfield_10041);

			// Defect Platform
			HashMap<Object, Object> mapCustomfield_10037 = new HashMap<Object, Object>();
			mapCustomfield_10037.put("id", platform);
			mapFields.put("customfield_10037", mapCustomfield_10037);

			HashMap<Object, Object> mapVersions = new HashMap<Object, Object>();
			mapVersions.put("id", fUtil.fgetDataNew1("versions"));
			JSONArray versionsA = new JSONArray();
			versionsA.add(0, mapVersions);
			mapFields.put("versions", versionsA);

			HashMap<Object, Object> mapIssuetype = new HashMap<Object, Object>();
			mapIssuetype.put("name", "Bug");
			mapIssuetype.put("id", fUtil.fgetDataNew1("issuetype"));
			mapFields.put("issuetype", mapIssuetype);

			json.put("fields", mapFields);

			System.out.println("JSON is generated --" + json.toJSONString());

			request.body(json.toJSONString());
			Response response = request.post();

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			fUtil.flogResult("Passed", "Generation of response body for fetch customer",
					"Response is :  " + responseBody, 0);
			int statusCode = response.getStatusCode();
			System.out.println("Status code is: " + statusCode);

			if (statusCode == 201) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode, 0);
				bugID = response.jsonPath().get("key");
				fUtil.flogResult("Passed", "Bug Creation Check", "Bug Id: " + bugID, 0);

			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode, 0);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			fUtil.flogResult("Failed", "API Response failed", "API Response failed for -" + e.getMessage(), 0);
		}

		return bugID;
	}

	public void publishAttachmentJIRA(String bugID, String path) throws Exception {
		try {

			String value = "https://tatadigital.atlassian.net/rest/api/2/issue/" + bugID + "/attachments";
			RestAssured.baseURI = value;
			RequestSpecification request2 = RestAssured.given();
			request2.header("Content-Type", "multipart/form-data");
			request2.header("Content-Disposition", "form-data");
			request2.header("Authorization", fUtil.fgetDataNew1("Authorization"));
			request2.header("X-Atlassian-Token", "no-check");
			// String file = fUtil.fgetDataNew1("file");
			request2.multiPart("file", new File(path));

			Response response2 = request2.post();
			// Response response2=request2.get("/"+purchaseOrder);
			String responseBody2 = response2.getBody().asString();
			System.out.println("response: " + responseBody2);

			fUtil.flogResult("Passed", "Adding attachments ", "Adding attachments successfully" + responseBody2, 0);

			int statusCode2 = response2.getStatusCode();
			System.out.println("Status code is: " + statusCode2);
			if (statusCode2 == 200) {
				fUtil.flogResult("Passed", "Validate the Status Code", "Status Code is " + statusCode2, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Code",
						"Expected Status Code is 200 but it is " + statusCode2, 0);
			}
			// status line verification
			String statusLine2 = response2.getStatusLine();
			System.out.println("Status line is:" + statusLine2);
			if (statusLine2.contains("HTTP/1.1 200")) {
				fUtil.flogResult("Passed", "Validate the Status Line", "Status Line is " + statusLine2, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line",
						"Expected Status Line is HTTP/1.1 200 Created but it is " + statusLine2, 0);
			}
			// split("success")[1].split(",")[0]
			String filename = responseBody2.split("filename")[1].split(",")[0];
			System.out.println("file namee:" + filename);
			if (responseBody2.contains("filename")) {
				fUtil.flogResult("Passed", "Validate file added successfully",
						"file" + filename + " added successfully ", 0);
			} else {
				fUtil.flogResult("Failed", "Validate file added successfully",
						"file not added successfully " + filename, 0);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fUtil.flogResult("Failed", "API Response failed", "API Response failed for -" + e.getMessage(), 0);
		}
	}

	public void publishDefectInJIRA(String path) throws Exception {
		try {
			String bug = bugLogging();
			publishAttachmentJIRA(bug, path);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fUtil.flogResult("Failed", "API Response failed", "API Response failed for -" + e.getMessage(), 0);
		}
	}

	public String readOtpFromEmail(String expectedSenderName, String expectedSubject, String currentTimeStamp)
			throws Exception {
		String otpInEmail = "";
		WebDriver driver = BrowserFactory.webDriver.get();
		String oldTab = driver.getWindowHandle();
		try {
			// Open in new tab
			driver.manage().window().maximize();
			String a = "window.open('https://www.google.com/','_blank');";
			((JavascriptExecutor) driver).executeScript(a);
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));
			browserFactory.get().getDriver().navigate().to(
					"https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/");

			if (isElementVisible(gmailPage.get().emailTextBox, 20)) {
				gmailPage.get().emailTextBox.sendKeys(fUtil.fgetDataNew1("gmail").toString()); // change mail id
				gmailPage.get().nextBtn.click();

				if (isElementVisible(gmailPage.get().passwordTextBox, 20)) {
					gmailPage.get().passwordTextBox.sendKeys(fUtil.fgetDataNew1("gmailPwd").toString()); // change
																											// password
					gmailPage.get().nextBtn.click();

					if (isElementVisible(gmailPage.get().inboxBtn, 30)) {
						gmailPage.get().inboxBtn.click();
						// isElementVisible(gmailPage.get().refreshBtn,10);
						// gmailPage.get().refreshBtn.click();
						if (isElementVisible(gmailPage.get().firstEmailSenderName, 30)) {
							String firstEmailSenderName = gmailPage.get().firstEmailSenderName.getText().trim();
							String firstEmailSubject = gmailPage.get().firstEmailSubject.getText().trim();
							String mailRecievedTimeStamp = gmailPage.get().firstEmailRevievedDateTime
									.getAttribute("title").trim();

							// Validation
							// 1. sender name and subject
							if (expectedSenderName.equalsIgnoreCase(firstEmailSenderName)
									&& expectedSubject.equalsIgnoreCase(firstEmailSubject)) {
								// Modified readOtp method with validation of TimeStamp,SenderName,Subject
								fUtil.flogResult("Passed", "Validate Sender Name and Subject of Mail Recieved",
										"Sender Name and Subject of Mail Recieved is same as arguments passed with Mail Subject: "
												+ firstEmailSubject + " Sender Name: " + firstEmailSenderName,
										0);
								System.out.println(firstEmailSenderName);
								System.out.println(firstEmailSubject);
								System.out.println(mailRecievedTimeStamp);
								boolean checkDateTime = mailRecievedTimeStamp.contains(currentTimeStamp);
								if (!checkDateTime) {
									int len = currentTimeStamp.length();
									String currentDate = currentTimeStamp.substring(0, len - 8);
									String mailRecievedDate = mailRecievedTimeStamp.substring(0, len - 8);
									String currentTime = currentTimeStamp.substring(len - 8).trim();
									String mailRecievedTime = mailRecievedTimeStamp.substring(len - 8).trim();
									checkDateTime = mailRecievedDate.contains(currentDate);
									String currentAMPM = currentTime.split(" ")[1];
									String mailAMPM = mailRecievedTime.split(" ")[1];
									checkDateTime = checkDateTime && currentAMPM.equals(mailAMPM);
									String currentT = currentTime.split(" ")[0].replace(":", "");
									String mailT = mailRecievedTime.split(" ")[0].replace(":", "");
									int timedifference = Integer.parseInt(mailT) - Integer.parseInt(currentT);
									if ((timedifference <= 2 || (timedifference >= 41 && timedifference <= 42))
											&& checkDateTime) {
										checkDateTime = true;
									} else {
										checkDateTime = false;
									}
								}
								if (checkDateTime) {
									fUtil.flogResult("Passed",
											"Validate Current Date and Mail Recieved Date Same or in difference of 3 min",
											"Current Date and Mail Recieved Date are same or in difference of 3 min with CurrentTimeStamp: "
													+ currentTimeStamp + " Mail recieved Time stamp: "
													+ mailRecievedTimeStamp,
											0);
									gmailPage.get().firstEmailSubject.click();
									Thread.sleep(5000);
									int size = gmailPage.get().otpTextInEmail.size();
									int n = size - 1;
									if (isElementVisible(gmailPage.get().otpTextInEmail.get(n), 10)) {
										String mailContent = gmailPage.get().otpTextInEmail.get(n).getText();
										if (mailContent.contains("OTP")) {
											otpInEmail = mailContent.split("OTP")[1].trim().replace(".", "");
											if (!otpInEmail.matches(".*\\d.*")) {
												Pattern p = Pattern.compile("(\\d{6})");
												Matcher m = p.matcher(mailContent);
												if (m.find()) {
													otpInEmail = m.group(0);
												} else
													System.out.print("No 6 digit number available");

											}
											System.out.println(otpInEmail);
											deleteAllEmailsFromGmailAccount();
										}

									}
								} else {
									fUtil.flogResult("Failed",
											"Validate Current Date and Mail Recieved Date Same or in difference of 3 min",
											"Current Date and Mail Recieved Date are not same or in difference of 3 min with CurrentTimeStamp: "
													+ currentTimeStamp + " Mail recieved Time stamp: "
													+ mailRecievedTimeStamp,
											0);
								}
							} else
								fUtil.flogResult("Failed", "Validate Sender Name and Subject of Mail Recieved",
										"Sender Name and Subject of Mail Recieved is not same as arguments passed with Mail Subject: "
												+ firstEmailSubject + " Sender Name: " + firstEmailSenderName,
										0);
						} else
							fUtil.flogResult("Failed", "Validate Inbox is not empty", "Inbox is found empty ", 0);
					}
				}
			}
		} catch (Exception e) {
			driver.switchTo().window(oldTab);
			System.out.println(e.getMessage());
			fUtil.flogResult("Failed", "Read Otp from Email", "Read Otp from Email -" + e.getMessage(), 0);
		}
		driver.switchTo().window(oldTab);
		return otpInEmail.substring(0, 6);
	}

	public void deleteAllEmailsFromGmailAccount() {
		if (isElementVisible(gmailPage.get().inboxBtn, 30)) {
			gmailPage.get().inboxBtn.click();
			if (isElementVisible(gmailPage.get().selectAllCheckbox, 10)) {
				gmailPage.get().selectAllCheckbox.click();
				if (isElementVisible(gmailPage.get().deleteMailBtn, 10)) {
					gmailPage.get().deleteMailBtn.click();

					if (isElementVisible(gmailPage.get().emptyInboxMsg, 10)) {
						//logger.info("Inbox is Empty Now");
						System.out.println("Inbox is Empty Now");
					} else {
						//logger.error("Failed to delete all the emails");
						System.out.println("Failed to delete all the emails");
					}
				} else {
					//logger.error("Delete mail Button not visible ");
					System.out.println("Delete mail Button not visible");
				}

			} else {
				//logger.error("Select All Email Button not visible ");
				System.out.println("Select All mail Button not visible");
			}
		} else {
			//logger.error("Inbox Button not visible ");
			System.out.println("Inbox Button not visible");
		}
	}

	/*
	 * Function Name : switchContextMobile() Input required : native or web
	 * Developed by : Anil Kumar Kedia - 679167
	 */
	public void switchContextMobile(String Context) throws Exception {
		try {
			Thread.sleep(30000);

			Set<String> contextNames = appiumDriver.get().getContextHandles();

			switch (Context.toLowerCase()) {

			case "native":
				for (String context : contextNames) {
					System.out.println(context);
					if (context.toLowerCase().contains("native")) {
						appiumDriver.get().context(context);
						System.out.println("Switched to Native App Context");
					}
				}
				break;

			case "web":
				for (String context : contextNames) {
					System.out.println(context);

					if (context.toLowerCase().contains("web")) {
						appiumDriver.get().context(context);
						System.out.println("Switched to Web View Context");
					}
				}
				break;
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Exception Caught in Switch Context Mobile", "Exception is : " + e.getMessage(),
					1);
			e.printStackTrace();
			throw e;
		}
	}

	// ***general method to select any widget any SLP PWA**//
	public void selectWidget(List<WebElement> widjetList, String widget, String widgetTitle) throws Exception {
		try {

			int size = widjetList.size();
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				if (gmethods.isElementVisible(widjetList.get(i), 5)) {
					String widgetTitleUI = widjetList.get(i).getText();

					fUtil.flogResult("Passed", "validate" + widget + "contains" + widgetTitle,
							"validated" + widget + "contains" + widgetTitleUI, 1);

					if (widgetTitleUI.equalsIgnoreCase(widgetTitle)) {
						widjetList.get(i).click();
						fUtil.flogResult("Passed", "validate" + widget + "contains" + widgetTitle + "and click",
								"validated" + widget + "contains" + widgetTitleUI + "and clicked", 1);
						flag = true;
						break;
					}
				} else {
					fUtil.flogResult("Failed", "validate" + widget + "contains" + widgetTitle, "No widget is visible ",
							1);
				}

			}
			if (flag == true) {
				fUtil.flogResult("Passed", "validate click widget", "clicked Widget successfully", 1);
			} else {
				fUtil.flogResult("Failed", "validate click widget", "clicked Widget not successful", 1);
			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "select widget", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	// **general method to navigate to fetch all widget and get title any SLP**//

//	public void fetchWidget(List<WebElement> widjetList, String widget, String widgetTitle) throws Exception {
//		try {
//
//			int size = widjetList.size();
//			for (int i = 0; i < size; i++) {
//				if (gmethods.isElementVisible(widjetList.get(i), 5)) {
//					String widgetTitleUI = widjetList.get(i).getText();
//
//					fUtil.flogResult("Passed", "validate" + widget + "contains" + widgetTitle,
//							"validated" + widget + "contains" + widgetTitleUI, 1);
//
//					System.out.println(widgetTitleUI);
//				} else {
//					fUtil.flogResult("Failed", "validate" + widget + "contains" + widgetTitle, "No widget is visible ",
//							1);
//				}
//
//			}
//			fUtil.flogResult("Passed", "Total widget" + widget, "Total widget present for" + widget + "is" + size, 1);
//		} catch (Exception e) {
//			fUtil.flogResult("Failed", "count widget", "Error occured: " + e.getMessage(), 1);
//			e.printStackTrace();
//			throw e;
//		}
//	}
	
	

	// **general method to navigate to widget and chk if widget present for any
	// SLP**//
	public void validatewidgetPresent(WebElement widgetsearch, String widget, String SLP) throws Exception {
		try {
			gmethods.scrollToViewElement(widgetsearch);
			if (gmethods.isElementVisible(widgetsearch, 5)) {
				fUtil.flogResult("Passed", "Validate SLP" + SLP + "page" + widget,
						"SLP" + SLP + "page" + widget + "widget present", 1);
				// clickFeaturedOfferWidgetHotel();

			} else {
				fUtil.flogResult("Failed", "Validate SLP" + SLP + "page" + widget, "SLP" + SLP + " widget not present",
						1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP" + SLP + "page" + widget, "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	// **general method to click widget without title**//
	public void clickWidgetNoTitle(List<WebElement> widjetList, String widget, int number) throws Exception {
		try {
			int i = number - 1;
			if (gmethods.isElementVisible(widjetList.get(i), 5)) {

				widjetList.get(i).click();
				fUtil.flogResult("Passed", "click widget" + widget, "clicked" + widget + "widget", 1);

			} else {
				fUtil.flogResult("Failed", "click widget" + widget, "widget not clicked ", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "click widget", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	public void PassFailCount() {
		HashMap<String, String> capitalCities = new HashMap<String, String>();
		int passCount = 0;
		int failtCOunt = 0;
		for (int i = 0; i < 10; i++) {
			passCount++;
			failtCOunt++;
		}
		capitalCities.put("PassCount", String.valueOf(passCount));
		capitalCities.put("Failed", String.valueOf(failtCOunt));
		System.out.println(capitalCities.get("PassCount"));
		System.out.println(capitalCities.get("Failed"));

	}

	public void getTestCounts() throws Exception {
		try {
			/*
			String testCaseResult = ExtentTestManager.getTest().getRunStatus().toString();
			testCaseNameWithResult.put(ExtentTestManager.getTest().getTest().getName().split("-")[1], testCaseResult+"            "+ExtentTestManager.getTest().getTest().getRunDuration());
			if (testCaseResult.equalsIgnoreCase("Pass")) {
				totalTestCaseExecuted = totalTestCaseExecuted + 1;
				totalPassedTestCase = totalPassedTestCase + 1;
			} else if (testCaseResult.equalsIgnoreCase("Fail")) {
				totalTestCaseExecuted = totalTestCaseExecuted + 1;
				totalFailedTestCase = totalFailedTestCase + 1;
			}
			createAndWriteToFile();*/
			System.out.println("getTestCounts method");
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createAndWriteToFile() throws Exception {
		try {
			String fileName = "TestExecutionSummary.txt";
			
			File myObj = new File(fileName);
			if (myObj.delete()) {
				System.out.println("Deleted the file: " + myObj.getName());
			} else {
				System.out.println("Failed to delete the file.");
			}

			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}

			FileWriter myWriter = new FileWriter(myObj.getName());
			myWriter.write("TotalTestCasesExecuted=" + totalTestCaseExecuted);
			myWriter.write("\nTotalPassedTestCases=" + totalPassedTestCase);
			myWriter.write("\nTotalFailedTestCases=" + totalFailedTestCase);

			passPercentage = (float) (((float) totalPassedTestCase / (float) totalTestCaseExecuted) * 100);

			myWriter.write("\nPassPercentage=" + passPercentage + "%");
			myWriter.write("\n\n#####################################\n\n");
			myWriter.write("TestCase Name                            Result      Run Duration\n");
			myWriter.write("--------------------------------------------------------------------\n");

			 if(!testCaseNameWithResult.isEmpty()) {
		         Iterator it = testCaseNameWithResult.entrySet().iterator();
		         while(it.hasNext()) {
		            Map.Entry obj = (Entry)it.next();
		            myWriter.write(obj.getKey()+"                              "+obj.getValue()+"\n");
		         }
		      }
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	


	/*
	 * TCP APP login Starting Page before Enter login button
	 * 
	 */
	
	/*
	 * Method to select widget mobile
	 * 
	 */
	
	public void selectWidgetMobile( List<MobileElement> widjetList,List<MobileElement> widjetTitle, String widget,String widgetTitle) throws Exception{
		try {
			
			int size = widjetList.size();
			boolean flag = false;
			for(int i=0;i<size ; i++)
			{
			if(gmethods.isElementVisible_mobile(widjetList.get(i),5)) {
				String widgetTitleUI = widjetTitle.get(i).getText();
				
				fUtil.flogResult("Passed","validate"+widget+ "contains" +widgetTitle, "validated"+widget+ "contains" +widgetTitleUI ,1);
			
				if(widgetTitleUI.equalsIgnoreCase(widgetTitle))
				{
					widjetList.get(i).click();
					fUtil.flogResult("Passed","validate"+widget+ "contains" +widgetTitle+ "and click", "validated"+widget+ "contains" +widgetTitleUI+ "and clicked" ,1);
					flag = true;
					break;
				}
			}else {
				fUtil.flogResult("Failed","validate"+widget+ "contains" +widgetTitle, "No widget is visible ",1);
			}
			
			}
			if(flag == true)
			{fUtil.flogResult("Passed","validate click widget", "clicked Widget successfully" ,1);
			}
			else
			{
				fUtil.flogResult("Failed","validate click widget", "clicked Widget not successful" ,1);
			}
		}catch (Exception e) {
			fUtil.flogResult("Failed", "select widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	
	/*
	 * Method to fetch widget mobile
	 * 
	 */
	public void fetchWidgetMobile( List<MobileElement> widjetList, List<MobileElement> widjetTitle,String widget,String widgetTitle) throws Exception{
		try {
			
			int size = widjetList.size();
			for(int i=0;i<size ; i++)
			{
			if(gmethods.isElementVisible_mobile(widjetList.get(i),5)) {
				String widgetTitleUI = widjetTitle.get(i).getText();
				
				fUtil.flogResult("Passed","validate"+widget+ "contains" +widgetTitle, "validated"+widget+ "contains" +widgetTitleUI ,1);
			
			System.out.println(widgetTitleUI);
			}else {
				fUtil.flogResult("Failed","validate"+widget+ "contains" +widgetTitle, "No widget is visible ",1);
			}
			
			}
			fUtil.flogResult("Passed","Total widget"+widget, "Total widget present for"+widget+ "is" +size ,1);
		}catch (Exception e) {
			fUtil.flogResult("Failed", "count widget", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	/*
	 * Method to Validate widget Present mobile
	 * 
	 */
	public void validatewidgetPresentMobile(MobileElement widgetsearch,String widget,String SLP) throws Exception{
		try {
			
			while (!(gmethods.isElementVisible_mobile(widgetsearch, 10))) {
				scrollDirectionMobile_SLP("DOWN");
				fUtil.flogResult("Passed", "search SLP ,scroll", "SLP scrolled", 1);	
				
			}
			
			if(gmethods.isElementVisible_mobile(widgetsearch,5)) {
				fUtil.flogResult("Passed","Validate SLP" +SLP+"page" +widget, "SLP" +SLP+"page" +widget+ "widget present",1);
				//clickFeaturedOfferWidgetHotel();
				
			}else {
				fUtil.flogResult("Failed","Validate SLP" +SLP+"page" +widget, "SLP"+SLP+" widget not present",1);
			}
				
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate SLP" +SLP+"page" +widget, "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	public void scrollDirectionMobile_SLP(String direction) throws Exception {
		try {
			double SCROLL_RATIO = 0.3;
			gmethods.scroll(direction, SCROLL_RATIO);
		}catch(Exception e) {
			fUtil.flogResult("Failed", "General Function : scrollDirectionMobile", "Exception caught :"+e.getMessage(), 0);
		}
	}

	/*
	 * Method to click a standalone widget Mobile
	 * 
	 */
		
  public void validateclickWidgetMobile(MobileElement widjetxpath, String widget) throws Exception{
      try {
		while (!(gmethods.isElementVisible_mobile(widjetxpath, 10))) {
			scrollDirectionMobile_SLP("DOWN");
			fUtil.flogResult("Passed", "search SLP ,scroll", "SLP scrolled", 1);	
						
			}
		if(gmethods.isElementVisible_mobile(widjetxpath,5)) {
			String buttonUI= widjetxpath.getText().trim();
	           widjetxpath.click();
			fUtil.flogResult("Passed","click"+widget+"widget", "clicked"+widget+ "widget",1);

			}else {
			fUtil.flogResult("Failed","click"+widget+"widget", "Not clicked"+widget+ "widget",1);
				}
						
		}catch (Exception e) {
					fUtil.flogResult("Failed", "click"+widget+"widget", "Error occured: "+e.getMessage(), 1);
					e.printStackTrace();
					throw e;
				}
			}

  
    /*
	 Method to scroll Mobile Element to Center
	 * 
	 */
      
	public void scrollElementfromBottomtoCenter(MobileElement element) throws Exception{
		try {
			Point elementLoc = element.getLocation();
			Dimension size = gmethods.getWindowSize();
			Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
			Duration SCROLL_DUR = Duration.ofMillis(1000);
			gmethods.swipe(elementLoc, new Point(elementLoc.getX(),midPoint.getY()), SCROLL_DUR);
			System.out.println("Element scrolled from bottom to center");
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Scroll Widget Bottom to Center", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	
	/*
	 * Method to select and click Widget based on Widget Number by swiping Right 
	 * Tiles- Total no. of widget present
	 * Journey- Widget no. to be selected 
	 * 
	 */
	public void selectJourney_RightSwipeWidget(MobileElement element,String widgetName,String journey,String tiles) throws Exception{
		try {
			int i=1;
			if(gmethods.isElementVisible_mobile(element, 20)) {
				while(i<=Integer.parseInt(tiles)) {
					String desc=element.getText();
					System.out.println("Tiles "+i+" Content found: "+desc);
					if(Integer.parseInt(journey)==i) {
						element.click();
						if(desc.isEmpty())
							fUtil.flogResult("Passed", "Validate Click on Tiles: "+journey+" under Widget: "+widgetName, "Clicked successfully on Tiles: "+journey+" with no description present"+" under Widget: "+widgetName, 1);
						else
							fUtil.flogResult("Passed", "Validate Click on Tiles: "+journey+" under Widget: "+widgetName, "Clicked successfully on Tiles: "+journey+" with Description: "+desc+" under Widget: "+widgetName, 1);
						break;
					}
					gmethods.scrollDirectionMobile("RIGHT");
					i++;
				}
				if(i>=Integer.parseInt(tiles)+1)
					fUtil.flogResult("Failed","Validate Click on Tiles: "+journey+" under Widget: "+widgetName, "No such journey found as number of Tiles is "+tiles, 1);
			}
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Scroll Widget Right", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	
	/*
	 * Method to To scroll elements to last element position
	 * Tiles- Total no. of widget present
	 * direction - (RIGHT,LEFT,UP,DOWN)
	 * 
	 */
	public void scrollWidgetTillLastinDirection(MobileElement element,String tiles,String direction) throws Exception{
		try {
			int i=1;
			if(gmethods.isElementVisible_mobile(element, 20)) {
				while(i<=Integer.parseInt(tiles)) {
					System.out.println("Tiles "+i+" Content found: "+element.getText());
					gmethods.scrollDirectionMobile(direction);
					fUtil.flogResult("Passed", "Validate element scrolled: "+direction,"Element scrolled "+direction+" successfully",1);
					i++;
				}
				fUtil.flogResult("Passed", "Validate Scroll Widget in "+direction.toLowerCase()+"most element", "No more "+direction.toLowerCase()+" scrolling", 1);
			}
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Scroll Widget Left Right", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}

	
	/*
	 * Function Name : SignInMobileUsingOTP
	 * This will login user in Android / iOS with Mobile and OTP
	 */
	public void signInMobileWithOtp(MobileElement letsStartBtn, MobileElement mobileNoTextBoxelement,
			MobileElement confirmButton,MobileElement otpTextBoxElement, MobileElement skipTourElement,
			MobileElement vaultLink,  String mobileNumber,
			String otp) throws Exception {
		try {
			if (mobileNumber.startsWith("~"))
				mobileNumber = mobileNumber.substring(1);
			
			if(isElementVisible_mobile(letsStartBtn,10)) {
				letsStartBtn.click();
			}

			if(isElementVisible_mobile(mobileNoTextBoxelement,10)) {

				mobileNoTextBoxelement.sendKeys(mobileNumber);

				appiumDriver.get().hideKeyboard();
				fUtil.flogResult("Passed", "Mobile No. Text Box Visibility", "Mobile No. Text Box is visible. Enter Mobile No. Successfully", 1);

				if(isElementVisible_mobile(confirmButton,10)) {
					fUtil.flogResult("Passed", "Get OTP in Mobile No. Page", "Get OTP visible. Clicking Get OTP ", 1);

					confirmButton.click();

					if(isElementVisible_mobile(otpTextBoxElement,10)) {
						fUtil.flogResult("Passed", "Enter OTP", "OTP box visible. Entering OTP ", 1);

						otpTextBoxElement.click();
						otpTextBoxElement.sendKeys(otp);

						iOSAllowinitialalerts(TdlSignUpMobile.get().allowAlert);

						if(isElementVisible_mobile(skipTourElement,10)) {
							skipTourElement.click();
						}
						
						iOSAllowinitialalerts(TdlSignUpMobile.get().allowAlert);
						iOSAllowinitialalerts(TdlSignUpMobile.get().okAlert);
						
						if(isElementVisible_mobile(vaultLink,20)) {
							fUtil.flogResult("Passed", "Vault Link in Home Page", "Vault Link present in Home Page", 1);
						}else {
							fUtil.flogResult("Failed", "Vault Link in Home Page", "Navigation to Home Page failed. Vault Link not visible", 1);
						}

					}else {
						fUtil.flogResult("Failed", "Enter OTP", "OTP box not visible", 1);
					}
				}else {
					fUtil.flogResult("Failed", "Confirm Button in Mobile No. Page", "Confirm Button Not visible.", 1);
				}
			}else {
				fUtil.flogResult("Failed", "Mobile No. Text Box Visibility", "Mobile No. Text Box is not visible.", 1);
			}
		}catch(Exception e) {
			fUtil.flogResult("Failed", "SignIn Mobile using OTP", "Exception Caught : "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;

		}
	}
	
	/*
	 * Enable iOS Location for TCP App
	 */
	public void enableLocationForTCPiOS() throws Exception{
		try {
			appiumDriver.get().activateApp("com.apple.Preferences");

			if(gmethods.isElementVisible(TdlAddressChoosePage_Mobile.get().tcpAppios, 10)) {
				TdlAddressChoosePage_Mobile.get().tcpAppios.click();
			}else {
				appiumDriver.get().navigate().back();
				TdlAddressChoosePage_Mobile.get().tcpAppios.click();
			}

			gmethods.scrollDirectionMobile("up");

			if(gmethods.isElementVisible(TdlAddressChoosePage_Mobile.get().locationios, 10)) {
				TdlAddressChoosePage_Mobile.get().locationios.click();
			}
			
			if(gmethods.isElementVisible(TdlAddressChoosePage_Mobile.get().locationoptionios, 10)) {
				TdlAddressChoosePage_Mobile.get().locationoptionios.click();
				fUtil.flogResult("Passed", "Enable iOS Location for TCP", "Enable Successfully", 1);
			}
			if(gmethods.isElementVisible(TdlAddressChoosePage_Mobile.get().tcpAppios, 10)) {
				TdlAddressChoosePage_Mobile.get().tcpAppios.click();
			}
			
			appiumDriver.get().terminateApp("com.apple.Preferences");
			appiumDriver.get().activateApp("com.tatadigital.tcp.dev");
		}catch(Exception e) {
			fUtil.flogResult("Failed", "Enable iOS Location for TCP", "Exception Caught : "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void startAppiumServer() throws Exception {
//		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//	            .usingDriverExecutable(new File("/usr/local/Cellar/node/15.6.0/bin/node"))
//	            .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
//	            .usingPort(4723).withIPAddress("127.0.0.1"));
//	    service.start();
//	    Thread.sleep(5000);
//	    System.out.println("\n\n*****************************************");
//	    System.out.println("******** APPIUM SERVER STARTED **********");
//	    System.out.println("*****************************************\n\n");
//	    //logger.info(service.getUrl().toString());
	}
	
	public static void stopAppiumServer() throws Exception {
//		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//	            .usingDriverExecutable(new File("/usr/local/Cellar/node/15.6.0/bin/node"))
//	            .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
//	            .usingPort(4723).withIPAddress("127.0.0.1"));
//	    service.stop();
//	    Thread.sleep(5000);
//	    System.out.println("\n\n*****************************************");
//	    System.out.println("******** APPIUM SERVER STOPPED *********");
//	    System.out.println("*****************************************\n\n");
	}
	

//Login With PWA Desktop 
public void loginPwaDesktop(String mobileno) throws Exception {
	try {
		String loginToProd = fUtil.readInput("LoginToProd");
		String otp = "192837";
		String password = fUtil.fgetDataNew1("Password");
		String Logintype=  fUtil.readInput("LoginUsing");
		if (mobileno.startsWith("~"))
			mobileno = mobileno.substring(1);
		if(loginToProd.equalsIgnoreCase("Yes")) {
			mobileno=fUtil.readInput("ProdLoginPhoneNumber").trim(); 
		}
		WebDriverWait wait = new WebDriverWait(BrowserFactory.webDriver.get(), 20);
		Thread.sleep(3000);
		BrowserFactory.webDriver.get().navigate().refresh();
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-testid='phone-number-input']")));
		} catch (Exception e) {
			// TODO: handle exception
			BrowserFactory.webDriver.get().navigate().refresh();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-testid='phone-number-input']")));
		}
		
		if (gmethods.isElementVisible(tcpHomePageMyAccount.get().mobileNoTextBox, 20)) {
			tcpHomePageMyAccount.get().mobileNoTextBox.sendKeys(mobileno);
			fUtil.flogResult("Passed", "Enter Phone Number", "Entered Number is : "+mobileno, 1);
			if (gmethods.isElementVisible(tcpHomePageMyAccount.get().confirmBtn, 20)) {
				tcpHomePageMyAccount.get().confirmBtn.click();
				if(loginToProd.equalsIgnoreCase("Yes")) {
					otp = getOtpForProd();
				}
				if (gmethods.isElementVisible(Tdl_SSO.get().otpPageHdr, 30)) {
					Actions action = new Actions(browserFactory.get().getDriver());
					action.moveToElement(browserFactory.get().getDriver()
							.findElement(By.xpath("//input[@name='otp-input' and @type='number']")));

					Thread.sleep(2000);
					if(Logintype.equalsIgnoreCase("password"))
					{
					Tdl_SSO.get().passwrdOption.click();
					gmethods.isElementVisible(Tdl_SSO.get().enterPwd, 10);
					Tdl_SSO.get().enterPwd.sendKeys(password);
					Tdl_SSO.get().enterPwd.sendKeys(Keys.DOWN);
					 fUtil.flogResult("Passed", "Enter password",
							  "password entered", 1);
					 gmethods.isElementVisible(Tdl_SSO.get().submit, 10);
						Tdl_SSO.get().submit.click();
					if(gmethods.isElementVisible(Tdl_SSO.get().submit, 10));
					{
						
				System.out.println(BaseScript.platform);
					Tdl_SSO.get().submit.click();
					 
					 }
					fUtil.flogResult("Passed", "click confirm",
							  "clicked confirm", 1);
					}
					
					else if(Logintype.equalsIgnoreCase("OTP"))
					{
						//Thread.sleep(10000);
					Tdl_SSO.get().otpField.sendKeys(otp);
					Thread.sleep(2000);
					fUtil.flogResult("Passed", "Enter OTP",
							"Entered OTP Successfully", 1);
					}

//					if (gmethods.isElementVisible(Tdl_SSO.get().skipBtn, 10)) {
//						//logger.info("User Details page is present, hence skipping it");
//						Tdl_SSO.get().skipBtn.click();
//					}
					wait = new WebDriverWait(BrowserFactory.webDriver.get(), 20);
					try {
						wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("*[id='hamberger-icon']")));
					} catch (Exception e) {
						// TODO: handle exception
						BrowserFactory.webDriver.get().navigate().refresh();
						wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("*[id='hamberger-icon']")));
					}
					
					
					if (gmethods.isElementVisible(tcpHomePageMyAccount.get().hamburgerMenuBtn, 20)) {
						fUtil.flogResult("Passed", "HomePage Navigation",
								"hamburgerMenuBtn present in Home Page, hence homePage navigated successfully", 1);
						System.out.println("User Logged in successfully");
					} else {
						fUtil.flogResult("Failed", "hamburgerMenuBtn in Home Page",
								"hamburgerMenuBtn not present in Home Page / Login Failed", 1);
						BrowserFactory.webDriver.get().quit();
						taskKill("chromedriver.exe");
						taskKill("chrome.exe");
					}
				} else {
					fUtil.flogResult("Failed", "Enter OTP", "OTP box not visible", 1);
					taskKill("chromedriver.exe");
					taskKill("chrome.exe");
				}
			} else {
				fUtil.flogResult("Failed", "Confirm/Get OTP Button in Mobile No. Page", "Confirm/Get OTP Button Not visible.", 1);
			}
		} else {
			fUtil.flogResult("Failed", "Mobile No. Text Box Visibility", "Mobile No. Text Box is not visible..", 1);
			taskKill("chromedriver.exe");
			taskKill("chrome.exe");
		}

	} catch (Exception e) {
		fUtil.flogResult("Failed", "Login PWA ", "Login Failed :: "+e.getMessage(), 1);
		BrowserFactory.webDriver.get().quit();
		taskKill("chromedriver.exe");
		taskKill("chrome.exe");
		e.getStackTrace();
		e.printStackTrace();
		e.getMessage();
	}
}

/*
 * Scroll Method for WebPage
 * args[] - WebElement locator, String Direction  
 * 
 */
public void scrollTillElmVisible_Web(WebElement elm, String direction) {
	try {
		
		int scrollCount = 0;
		while((!isElementVisible(elm, 5)) && scrollCount<5) {
		
		if(direction.equalsIgnoreCase("down")) {	
			JavascriptExecutor js = (JavascriptExecutor) browserFactory.get().getDriver();
			js.executeScript("window.scrollBy(0,350)", "");
			scrollCount++;
		
		} else if(direction.equalsIgnoreCase("up")) {
			JavascriptExecutor js = (JavascriptExecutor) browserFactory.get().getDriver();
			js.executeScript("window.scrollBy(0,-350)", "");
			scrollCount++;
		
		} else if(direction.equalsIgnoreCase("left") || direction.equalsIgnoreCase("right")) {
			JavascriptExecutor js = (JavascriptExecutor) browserFactory.get().getDriver();
			js.executeScript("arguments[0].scrollIntoView();", elm);
			scrollCount++;
		}
			
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
		
}

//**general method to navigate to fetch all widget and get title any SLP**//
	//by clicking arrow as well//
	public void fetchWidget(List<WebElement> widjetList, String widget, String widgetTitle) throws Exception {
		try {
int counter = 0;
			int size = widjetList.size();
			for (int i = 0; i < size; i++) {
				boolean widgetvisible = (gmethods.isElementVisible(widjetList.get(i), 5));
				if (widgetvisible == true) {
					String widgetTitleUI = widjetList.get(i).getText();
					System.out.println(widgetTitleUI);
					fUtil.flogResult("Passed", "validate  " + widget + "  contains " + widgetTitle,
							"validated  " + widget + "  contains " + widgetTitleUI, 1);

				} //validate list after arrow and click widget after that//
				else if(widgetvisible == false)
				{
					
					//click arrow validation
					String xpath = "//*[contains(text(),'"+widget+"')]/following-sibling::div//div[@class='slick-arrow slick-next']"+ " | "+"//*[contains(text(),'"+widget+"')]/../following-sibling::div//div[@class='slick-arrow slick-next']" + " | "+"//*[contains(text(),'"+widget+"')]/../../following-sibling::div//div[@class='slick-arrow slick-next']";
							

					boolean isWidgetpresent = gmethods
							.isElementVisible(BrowserFactory.getInstance().getDriver().findElement(By.xpath(xpath)), 20);
					if(isWidgetpresent==true) {
						BrowserFactory.getInstance().getDriver().findElement(By.xpath(xpath)).click();
						counter = counter + 1;
						System.out.println("counter"+counter);
						String widgetTitleUI = widjetList.get(i).getText();
						System.out.println(widgetTitleUI);
						fUtil.flogResult("Passed", "validate  " + widget + "contains  " + widgetTitle,
								"validated  " + widget + " contains " + widgetTitleUI, 1);
					}
					else {
						fUtil.flogResult("Failed", "validate click next arrow present", "next arrow not present but next widget is available ",
								1);
					
					}
					if(i==size - 1)
					{
						for (int j = 0; j < counter; j++)
						{
					String xpathnew = "//*[contains(text(),'"+widget+"')]/following-sibling::div//div[@class='slick-arrow slick-prev']"+ " | "+"//*[contains(text(),'"+widget+"')]/../following-sibling::div//div[@class='slick-arrow slick-prev']"+ " | "+"//*[contains(text(),'"+widget+"')]/../../following-sibling::div//div[@class='slick-arrow slick-prev']";
					boolean isWidgetpresentlast = gmethods
							.isElementVisible(BrowserFactory.getInstance().getDriver().findElement(By.xpath(xpathnew)), 20);
					
					//last arrow not visible validation	 and click previous arrow
				if(isWidgetpresentlast == true)
				{
					
					BrowserFactory.getInstance().getDriver().findElement(By.xpath(xpathnew)).click();
					System.out.println("clicked previous arrow");
					Thread.sleep(3000);
//					isWidgetpresentlast = gmethods
//							.isElementVisible(BrowserFactory.getInstance().getDriver().findElement(By.xpath(xpathnew)), 10);
				}
				else {
					fUtil.flogResult("Failed", "validate click previous arrow present", "previous arrow not present ",
							1);
					}
				}
				
				}
					}
					else {
					fUtil.flogResult("Failed", "validate " + widget + " contains " + widgetTitle, "No widget is visible ",
							1);
				}

			}
			fUtil.flogResult("Passed", "Total widget" + widget, " Total widget present for " + widget + "is" + size, 1);
		} catch (Exception e) {
			fUtil.flogResult("Failed", "count widget", "Error occured: " + e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
	}
	public boolean fClickOnButtonMobile(MobileElement obj, String step, String btnName, int ScreenShot) throws Exception {

		boolean flag = false;
		WaitForObject(obj);
		try {
			if (obj.isEnabled()) {

				JavascriptExecutor executor = (JavascriptExecutor) appiumDriver.get();
				executor.executeScript("arguments[0].click();", obj);
				BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				fUtil.flogResult("Passed", step, "Successfully Clicked :" + btnName, ScreenShot);
				flag = true;
			} else {
				fUtil.flogResult("Failed", step, "Object not present", ScreenShot);
				return false;
			}
		} catch (JavascriptException ee) {
			fUtil.flogResult("Passed", step, "Successfully Clicked :" + btnName, ScreenShot);
		} catch (ScriptTimeoutException eee) {
			fUtil.flogResult("Passed", step, "Successfully Clicked :" + btnName, ScreenShot);
		} catch (Exception e) {
			// if(e.)
			fUtil.flogResult("Failed", step, "Object not present/Exception :" + e, ScreenShot);
		}
		return flag;
	}
	
	/*
	 * This Function is to GET OTP For PROD PWA using API
	 * 
	 */
	
	public String getOtpForProd() throws Exception {
		String otp="";
		try {
			Thread.sleep(5000);
//			RestAssured.baseURI = "https://api.tatadigital.com/api/v2/sso/otp-suite"; //fUtil.fgetDataNew1("Base_URI");
			RestAssured.baseURI = "https://api-partner.tatadigital.com/api/v2/sso/otp-suite"; //fUtil.fgetDataNew1("Base_URI");

			RequestSpecification request = RestAssured.given();
			// 9
			request.header("Content-Type", "application/json");
			request.header("client_id", "TCP-WEB-APP"); //fUtil.fgetDataNew1("ClientId"));
			request.header("Authorization", "Z4JbCFEgU9TIEVaeuijY29xrty"); //fUtil.fgetDataNew1("SecretKey"));

			String MobNum=fUtil.readInput("ProdLoginPhoneNumber").trim(); //"1112565874"; //fUtil.fgetDataNew1("mobileNumber").replace("`", "");
			JSONObject json_otp = new JSONObject();

			json_otp.put("countryCode", "91");
			json_otp.put("phone", MobNum);
			json_otp.put("sendOtp","true");

			request.body(json_otp.toJSONString());
			System.out.println("JSON Body : "+json_otp.toJSONString());
			Response response_Otp = request.post();

			System.out.println("----Getting Response Body -----");
			String responseBody1 = response_Otp.getBody().asString();
			System.out.println("Response Body for Fetch Otp is:" + responseBody1);
			fUtil.flogResult("Passed", "Generation of response body Get OTP", "Response is :  " + responseBody1,
					0);

			otp = response_Otp.jsonPath().get("OTP");
			System.out.println("OTP is: " + otp);

			
			String statusLine = response_Otp.getStatusLine();
			System.out.println("Status line is:" + statusLine);
			if (statusLine.contains("HTTP/1.1 200 OK")) {
				fUtil.flogResult("Passed", "Validate the Status Line Authcode Generation",
						"Status Line is " + statusLine, 0);
			} else {
				fUtil.flogResult("Failed", "Validate the Status Line Authcode Generation",
						"Expected Status Line is HTTP/1.1 200 OK but it is " + statusLine, 0);
			}

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
			fUtil.flogResult("Failed", "API Response for Get OTP",
					"API Response for Get OTP failed-" + ee.getMessage(), 0);

		}
		return otp;
	}

	public void performanceTiming(String pageName) throws Exception {
		try {
			JavascriptExecutor j = (JavascriptExecutor)browserFactory.get().getDriver();
			//get the performance timings from performance timing library
			long navigationStarttime = Long.parseLong(j.executeScript("return window.performance.timing.navigationStart;").toString());
			long responseStarttime = Long.parseLong(j.executeScript("return window.performance.timing.responseStart;").toString());
			long loadEventEndtime = Long.parseLong(j.executeScript("return window.performance.timing.loadEventEnd;").toString());
			float firstBytetime = (float)(responseStarttime - navigationStarttime)/1000;
			float endUserResponseTime = (float)(loadEventEndtime - navigationStarttime)/1000;

			//Log to extent report
			fUtil.flogResult("Passed", "First Byte Time",
					pageName+" - First Byte Time = "+firstBytetime, 0);

			//Log to extent report
			fUtil.flogResult("Passed", "End User Response Time",
					pageName+" - End User Response Time = "+endUserResponseTime, 0);
		}
		catch(Exception e) {
			fUtil.flogResult("Failed", "Performance Timing",
					"Exception caught : "+e.getMessage(), 0);
		}
	}
	
	/*
	 * This Function will Get the height and Width of a PWA Element
	 * Input : WebElement
	 */
	public void getSizeOfElementPwa(WebElement element) throws Exception {
		try {

			// MobileElement element = (MobileElement)
			// appiumDriver.get().findElementByAccessibilityId("SomeAccessibilityID");
			Dimension elementSize = element.getSize();
			String height = Integer.toString(elementSize.height);
			String width = Integer.toString(elementSize.width);
			
			highlightElement(element);
			fUtil.flogResult("Passed", "Getting Hieght & Width of the Element","",  1);
			fUtil.flogResult("Passed", "Element Hieght : ", height, 1);
			fUtil.flogResult("Passed", "Element Width : ", width, 1);

			System.out.println("Element height :" + elementSize.getHeight());
			System.out.println("Element Width : " + elementSize.getWidth());

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Get Size details of Mobile Element",
					"Exception caught in General function : " + e.getMessage(), 1);
		}
	}
	
	/*
	 * This Function will Get the height and Width of all the Images of a Page in PWA
	 * Input : String pageName
	 */
	public void getImageSizeinPage(String pageName)
	{
		WebDriver driver=BrowserFactory.webDriver.get();
		System.out.println("Getting image sizes in - "+pageName);
		System.out.println("-----------------------------------");
		System.out.println("-----------------------------------");
		//do a scroll till the last of the page slowly with 300px down at each interval
		keepSCrollingLazyLOad(driver);

		//Get a list of all div elements with embedeed background image and image elements for icons
		List<WebElement> listImgeDivlements = driver.findElements(By.cssSelector("div[style*='url']"));
		List<WebElement> listImgelements = driver.findElements(By.cssSelector("img"));

		//loop through all the div elements for image size
		for (WebElement webElement : listImgeDivlements) {

			//get the parent element to have its text
			String imgName = webElement.findElement(By.xpath("./..")).getAttribute("innerText").trim().replaceAll("[\\t\\n\\r]", "");
			if (imgName.equals("") || imgName.equals(null))
			{
				imgName = webElement.getAttribute("style").split("/")[webElement.getAttribute("style").split("/").length-1].split("[.]")[0].trim().replaceAll("[\\t\\n\\r]", "");

			}
			//log image name and size
			System.out.println(imgName+" - Size - (W X H) "+webElement.getCssValue("width")+" X "+webElement.getCssValue("height"));
			try {
				fUtil.flogResult("Passed", "Get Image Size", imgName+" - Size - (W X H) "+webElement.getCssValue("width")+" X "+webElement.getCssValue("height"), 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("for images");
		System.out.println("_____________________________________");

		//loop through all the image elements for size
		for (WebElement webElement : listImgelements) {
			WebElement labelElement = null;
			String imgName = "";
			try {
				//get the parent element for image text
				labelElement = webElement.findElement(By.xpath(".//.."));
				imgName = labelElement.getAttribute("innerText").trim().replaceAll("[\\t\\n\\r]", "").replace("\\u20B9", "Rs");

				if (imgName.equals("") || imgName.equals("blank") || imgName.equals(null))
				{
					labelElement = webElement.findElement(By.xpath(".//..//.."));
					imgName = labelElement.getAttribute("innerText").trim().replaceAll("[\\t\\n\\r]", "").replace("\\u20B9", "Rs");
				}

				if (imgName.equals("") || imgName.equals("blank") || imgName.equals(null))
				{
					//get the src to get the image filename

					imgName =URLDecoder.decode(webElement.getAttribute("src").split("/")[webElement.getAttribute("src").split("/").length-1].split("[.]")[0].replaceAll("[\\t\\n\\r]", ""), "UTF-8");
					if (imgName.equals("") || imgName.equals("blank") || imgName.equals(null)) {
						if (!webElement.getAttribute("alt").equals("") || !webElement.getAttribute("alt").equals("blank") || !webElement.getAttribute("alt").equals(null))
						{
							imgName = webElement.getAttribute("alt").trim().replaceAll("[\\t\\n\\r]", "");
						}
						else
						{
							imgName = webElement.getAttribute("class").trim().replaceAll("[\\t\\n\\r]", "");
						}
					}

				}


			} catch (Exception e) {

				//get the image filename from src
				imgName = webElement.getAttribute("src").split("/")[webElement.getAttribute("src").split("/").length-1].split("[.]")[0].replaceAll("[\\t\\n\\r]", "");

			}

			//log image name and its size
			System.out.println(imgName+" - Size - (W X H) "+webElement.getCssValue("width")+" X "+webElement.getCssValue("height"));
			// System.out.println("_____________________________________");
			try {
				fUtil.flogResult("Passed", "Get Image Size", imgName+" - Size - (W X H) "+webElement.getCssValue("width")+" X "+webElement.getCssValue("height"), 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/*
	 * This Function will do a scroll till the last of the page slowly with 300px down at each interval
	 * Input : WebDriver driver
	 */
	public void keepSCrollingLazyLOad(WebDriver driver)
	{
		try {
			//get scrollheight of DOM
			long documentscrollHeight = Long.parseLong(((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight;").toString());


			long scrollIntervalHeight = 300;
			long startHeight = 0;
			long alreadyScrolledHeight = 0;
			while (documentscrollHeight > alreadyScrolledHeight)
			{
				//scroll through the length of the page gradually with 300 px interval
				((JavascriptExecutor)driver).executeScript("window.scrollTo(arguments[0], arguments[1]);", startHeight, (alreadyScrolledHeight+scrollIntervalHeight));
				Thread.sleep(1000);
				alreadyScrolledHeight += scrollIntervalHeight;
				startHeight = alreadyScrolledHeight;
				documentscrollHeight = Long.parseLong(((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight;").toString());
			}

			//scroll to the top
			((JavascriptExecutor)driver).executeScript("window.scrollTo(0, 0);");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to scroll the page");
		}

	}
	
	@Test
	public void PrepaidPayment_PWA(String customerDtls1) throws Exception {
		try {
			if (customerDtls1.startsWith("~")) {
				customerDtls1 = customerDtls1.substring(1);
			}
			if (gmethods.isElementVisible(tdlPayBill.get().mobNumber, 30)) {
				//logger.info("Mobile number space is available and navigated successfully");
				fUtil.flogResult("Passed", "validating Mobile number is navigated", "Navigated successfully", 1);

				if (gmethods.isElementVisible(tdlPayBill.get().mobNumber, 30)) {
					//logger.info("Click on Mobile Number");
					tdlPayBill.get().mobNumber.click();
					tdlPayBill.get().mobNumber.clear();
					tdlPayBill.get().mobNumber.sendKeys(customerDtls1);

				} else {
					//logger.info("Mobile number not displayed");
					fUtil.flogResult("Failed", "Mobile number", "Not Displayed", 1);
				}
			} else {
				//logger.info("Mobile number is not available as not navigated successfully");
				fUtil.flogResult("Failed", "validating Mobile number is navigated or not",
						"Not navigated successfully", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//logger.info("Click on Mobile number unsuccessful");
			fUtil.flogResult("Failed", "Click on Mobile number", e.getMessage(), 1);
		}
	
		try {
			if (gmethods.isElementVisible(tdlPayBill.get().Nextbtn, 30)) {
				//logger.info("Next button is available and navigated successfully");
				fUtil.flogResult("Passed", "validating Next button is navigated", "Navigated successfully", 1);

				if (gmethods.isElementVisible(tdlPayBill.get().Nextbtn, 30)) {
					//logger.info("Click on Next button");
					tdlPayBill.get().Nextbtn.click();
					
				} else {
					//logger.info("Next button not displayed");
					fUtil.flogResult("Failed", "Next button", "Not Displayed", 1);
				}
			} else {
				//logger.info("Next button is not available as not navigated successfully");
				fUtil.flogResult("Failed", "validating Next button is navigated or not",
						"Not navigated successfully", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//logger.info("Click on Next button unsuccessful");
			fUtil.flogResult("Failed", "Click on Next", e.getMessage(), 1);

		}
		
		try {
			if (gmethods.isElementVisible(tdlPayBill.get().billAmount, 30)) {
				//logger.info("Proceed button is available and navigated successfully");
				fUtil.flogResult("Passed", "validating Proceed button is navigated", "Navigated successfully", 1);

				if (gmethods.isElementVisible(tdlPayBill.get().Proceedbtn, 30)) {
					//logger.info("Click on Proceed button");
					tdlPayBill.get().billAmount.click();
					tdlPayBill.get().billAmount.sendKeys("Recharge_Amount");
					tdlPayBill.get().Proceedbtn.click();
					
				} else {
					//logger.info("Proceed button not displayed");
					fUtil.flogResult("Failed", "Proceed button", "Not Displayed", 1);
				}
			} else {
				//logger.info("Proceed button is not available as not navigated successfully");
				fUtil.flogResult("Failed", "validating Proceed button is navigated or not",
						"Not navigated successfully", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//logger.info("Click on Proceed button unsuccessful");
			fUtil.flogResult("Failed", "Click on Proceed", e.getMessage(), 1);

		}
		
		try {
			if (gmethods.isElementVisible(tdlPayBill.get().addlabel, 30)) {
				//logger.info("Label is available and navigated successfully");
				fUtil.flogResult("Passed", "validating Add Label is navigated", "Navigated successfully", 1);

				if (gmethods.isElementVisible(tdlPayBill.get().addlabel, 30)) {
					//logger.info("Click on Add Level");
					tdlPayBill.get().addlabel.click();

				} else {
					//logger.info("Add label not displayed");
					fUtil.flogResult("Failed", "Add Label", "Not Displayed", 1);
				}
			} else {
				//logger.info("Add Label is not available as not navigated successfully");
				fUtil.flogResult("Failed", "validating Add Label is navigated or not",
						"Not navigated successfully", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//logger.info("Click on Add Label unsuccessful");
			fUtil.flogResult("Failed", "Click on Add Label", e.getMessage(), 1);
		}
		
		try {
			if (gmethods.isElementVisible(tdlPayBill.get().addtocartbtn, 30)) {
				//logger.info("Add to cart button is available and navigated successfully");
				fUtil.flogResult("Passed", "validating Add to cart button is navigated", "Navigated successfully", 1);

				if (gmethods.isElementVisible(tdlPayBill.get().addtocartbtn, 30)) {
					//logger.info("Click on add to cart button");
					tdlPayBill.get().addtocartbtn.click();
					Thread.sleep(3000);
					tdlPayBill.get().Proceedbtn.click();

				} else {
					//logger.info("Add to cart not displayed");
					fUtil.flogResult("Failed", "Add to cart", "Not Displayed", 1);
				}
			} else {
				//logger.info("Add to cart is not available as not navigated successfully");
				fUtil.flogResult("Failed", "validating Add to cart is navigated or not",
						"Not navigated successfully", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//logger.info("Click on Add to cart unsuccessful");
			fUtil.flogResult("Failed", "Click on Add to cart", e.getMessage(), 1);
		}
		
		try {
			if(gmethods.isElementVisible(tdlPayBill.get().enter_CVV, 30)) {
				
				BrowserFactory.webDriver.get().switchTo().frame("security_code");
				System.out.println("Switched to Enter CVV Frame");
			}else
				System.out.println("No Enter CVV frame present");
		}catch (Exception e) {
			fUtil.flogResult("Failed", "Validate Switch to Enter CVV frame", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
		}
		
		try {
			if (gmethods.isElementVisible(tdlPayBill.get().debitcreditcardname, 30)) {
				//logger.info("Debit card is available and navigated successfully");
				fUtil.flogResult("Passed", "validating Debit card/Credit card is navigated", "Navigated successfully", 1);
				
				if (gmethods.isElementVisible(tdlPayBill.get().enter_CVV, 10)) {
					Thread.sleep(5000);
					Thread.sleep(5000);
					Thread.sleep(5000);
					tdlPayBill.get().enter_CVV.click();
					tdlPayBill.get().enter_CVV.sendKeys("123");
					Thread.sleep(5000);
					Thread.sleep(5000);
					tdlPayBill.get().invoice_pay_button.click();

				} else {
					//logger.info("CVV Code not displayed");
					fUtil.flogResult("Failed", "CVV Code", "Not Displayed", 1);
				}
			} else {
				//logger.info("CVV Code is not available as not navigated successfully");
				fUtil.flogResult("Failed", "validating CVV Code is navigated or not",
						"Not navigated successfully", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//logger.info("Click on CVV Code unsuccessful");
			fUtil.flogResult("Failed", "Click on CVV Code", e.getMessage(), 1);
		}
	}
	
	/*
	 * This Function will validate SSO auto Login for brand page with switching to New Tab and after validation closing all Brand Tab
	 */
	public void validateSSOLoginInBrandPage() throws Exception{
		try {
			switchToNewTab();
			Thread.sleep(10000);
			WebDriver driver=BrowserFactory.webDriver.get();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//			String url = (String)((JavascriptExecutor)BrowserFactory.webDriver.get()).executeScript("return document.URL;");
//			System.out.println("\n"+url+"\n");
			String currentUrl=(String)((JavascriptExecutor)BrowserFactory.webDriver.get()).executeScript("return document.URL;");
					//driver.getCurrentUrl();
			fUtil.flogResult("Pass", "Switched Tab URL ", "Current URL is : "+currentUrl, 0);
			if(currentUrl.toLowerCase().contains("croma"))
			{
				//SSO Login validation code for CROMA
				UserLoginCroma();
			}else if(currentUrl.toLowerCase().contains("bigbasket")) {
				//SSO Login validation code for BB
				bbloggedInPD();
			}else if(currentUrl.toLowerCase().contains("tajhotels")) {
				//SSO Login validation code for Taj
				UserLoginIhcl();
			}else if(currentUrl.toLowerCase().contains("luxury.tatacliq")) {
				//SSO Login validation code for Tata Cliq Luxury
				UserLoginTataCliqLuxury();
			}else if(currentUrl.toLowerCase().contains("tatacliq")) {
				//SSO Login validation code for Tata Cliq
				UserLoginTataCliq();
				((JavascriptExecutor)BrowserFactory.webDriver.get()).executeScript("window.self.close();");

			}else if(currentUrl.toLowerCase().contains("westside")) {
				//SSO Login validation code for WestSide
				UserLoginWestside();
				((JavascriptExecutor)BrowserFactory.webDriver.get()).executeScript("window.self.close();");

			}else if(currentUrl.toLowerCase().contains("airasia")) {
				validateAutologInFlight();
			}
			else if(currentUrl.toLowerCase().contains("amastays")) {
				Thread.sleep(10000);
				UserLoginIhclAmaStaysAndOtherHotels();
			}
			else if(currentUrl.toLowerCase().contains("hotels")) {
				UserLoginIhclAmaStaysAndOtherHotels();
			}
			else if(currentUrl.toLowerCase().contains("qmin")){
				UserLoginQmin();
			}
		
			closeAllTabsAndSwitchtoTcp();
			wait(3);
		}catch(Exception e) {
			//fUtil.flogResult("Failed", "Exception while Validating SSO Login in Brand Page", "Exception Caught : "+e.getMessage(), 1);
			String title = (String)((JavascriptExecutor)BrowserFactory.webDriver.get()).executeScript("return document.title;");
			String url = (String)((JavascriptExecutor)BrowserFactory.webDriver.get()).executeScript("return document.URL;");
			System.out.println(title);
			System.out.println(url);
			if(url.toLowerCase().contains("luxury.tatacliq"))
			{
				gmethods.performanceTiming("Luxury Homepage");

				fUtil.flogResult("Fail", "Brand SSO Login", "Load Time Issue - Luxury", 1);
			}
			else if(url.toLowerCase().contains("tatacliq"))
			{
				performanceTiming("Tata Cliq Homepage");

				fUtil.flogResult("Fail", "Brand SSO Login", "Load Time Issue - TataCliq", 1);
			}else if(url.toLowerCase().contains("westside")) {
				//SSO Login validation code for WestSide
				performanceTiming("West Side Homepage");

				fUtil.flogResult("Fail", "Brand SSO Login", "Load Time Issue - Westside", 1);
			}else if(url.toLowerCase().contains("qmin")) {
				//SSO Login validation code for WestSide
				performanceTiming("QMIN Homepage");

				fUtil.flogResult("Fail", "Brand SSO Login", "Load Time Issue - QMIN", 1);
			}
			((JavascriptExecutor)BrowserFactory.webDriver.get()).executeScript("window.self.close();");
			
			closeAllTabsAndSwitchtoTcp();
			wait(3);

		}
	}
	


	
	/*
	 * This Function will validate SSO auto Login for brand Croma
	 */
	public void UserLoginCroma() throws Exception {
		try {
			WebDriver driver=BrowserFactory.webDriver.get();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			refreshPage(driver, By.xpath("//*[@class='logged-in-user'] | //*[@class='DesktopHeader__nameSpan'] | //*[text()='MY ACCOUNT']"));
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().LogedCroma, 30)) {
				fUtil.flogResult("Passed", "Validate User Auto Logged in Croma", "User Auto Logged in Croma successfully", 1);

//				String log = TDL_SLPElectronicsPage.get().LogedCroma.getText().toLowerCase();
//				if (log.contains("Orders") | log.contains("hi") | log.contains("my account") ) {
//					fUtil.flogResult("Passed", "Validate User Auto Logged in Croma", "User Auto Logged in Croma successfully", 1);
//				} else {
//					fUtil.flogResult("Failed", "Validate User Auto Logged in Croma", "User not Auto Logged in Croma", 1);
//				}
			} else {
				fUtil.flogResult("Failed", "Validate User Auto Logged in Croma", "User not Auto Logged in Croma", 1);
			}
//			endExecutionTime();
//			System.out.println("Time Taken : "+totalTime);
//			fUtil.flogResult("Passed", "Time Taken to Navigate to Croma Page", "Total Time : "+totalTime+" seconds", 1);

			gmethods.performanceTiming("Croma Homepage");
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().ErrorPDP, 5)) {

				fUtil.flogResult("Failed", "Validate no Error msg in PDP Croma", "Error msg in PDP Croma", 1);

			}
			else if (!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().cromaLogo, 5)) {

				fUtil.flogResult("Failed", "Validate no Error msg displayed in PDP Croma", "Redirected to blank page in Croma", 1);

			}else {
				fUtil.flogResult("Passed", "Validate no Error msg displayed in PDP Croma", "No Error msg is displayed in PDP Croma", 1);
			}

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Croma page", "Exception Caught . User Login Croma Validation failed due to: " + e.getMessage(), 1);
		}
	}
	
	/*
	 * This Function will validate SSO auto Login for brand Tata Cliq
	 */
	@Test
	public void UserLoginTataCliq() throws Exception {
		try {
		Thread.sleep(5000);


			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().Loged, 20)) {
				String log = TDL_SLPElectronicsPage.get().Loged.getText();
				if (!log.equalsIgnoreCase("Sign in / Sign Up")) {
					fUtil.flogResult("Passed", "Validate User Auto Logged in Tata Cliq", "User Auto Logged in Tata Cliq", 1);
				} else {
					fUtil.flogResult("Failed", "Validate User Auto Logged in Tata Cliq", "User not Auto Logged in Tata Cliq", 1);
				}
			} else {
				 
				fUtil.flogResult("Failed", "Validate User Auto Logged in Tata Cliq", "User not Auto Logged in Tata Cliq", 1);
			}
//			endExecutionTime();
//			System.out.println("Time Taken : "+totalTime);
//			fUtil.flogResult("Passed", "Time Taken to Navigate to Tata CliQ Page", "Total Time : "+totalTime+" seconds", 1);

			gmethods.performanceTiming("Tata Cliq Homepage");
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().productCliq, 10))
			
				fUtil.flogResult("Passed", "Validate redirected to PLP Page Tata Cliq", "Redirected to PLP page Tata Cliq successfully", 1);
			
			else 
				fUtil.flogResult("Failed", "Validate redirected to PDP Page Tata Cliq", "Redirected to PDP page Tata Cliq not successfull", 1);

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Login tata cliq page", "issue in tata cliq page:" + e.getMessage(), 1);
		}
	}
	
	/*
	 * This Function will validate SSO auto Login for brand WestSide
	 */
	public void UserLoginWestside() throws Exception {
		try {
			Thread.sleep(5000);
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().LogedWestside, 15)) {
				String log = TDL_SLPElectronicsPage.get().LogedWestside.getText();
				if (!log.equalsIgnoreCase("sign in")) {
					fUtil.flogResult("Passed", "Validate User Auto Logged in WestSide", "User Auto Logged in WestSide", 1);
				} else {
					fUtil.flogResult("Failed", "Validate User Auto Logged in WestSide", "User not Auto Logged in WestSide", 1);
				}
			} else {
				fUtil.flogResult("Failed", "Validate User User Logged in WestSide", "User not Auto Logged in WestSide", 1);
			}
//			endExecutionTime();
//			System.out.println("Time Taken : "+totalTime);
//			fUtil.flogResult("Passed", "Time Taken to Navigate to WestSide Page", "Total Time : "+totalTime+" seconds", 1);

			gmethods.performanceTiming("Westside Homepage");
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().ErrorPDPCliq, 5)) 
				fUtil.flogResult("Failed", "Validate redirected to PLP/PDP Page WestSide", "Redirected to Error page WestSide", 1);
			 else if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().productWestside, 5)) 
				fUtil.flogResult("Passed", "Validate redirected to PLP Page WestSide", "Redirected to PLP page WestSide successfully", 1);
			else if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().searchButtonWestside, 5))
				fUtil.flogResult("Passed", "Validate redirected to PDP Page WestSide", "Redirected to PDP page WestSide successfully", 1);
			else 
				fUtil.flogResult("Failed", "Validate redirected to PDP Page WestSide", "Redirected to PDP page WestSide not successfull", 1);

		} catch (Exception e) {
			fUtil.flogResult("Failed", "Login WestSide page", "issue in WestSide page:" + e.getMessage(), 1);
		}
	}
	
	/*
	 * This Function will validate SSO auto Login for brand Taj Hotels
	 */
	public void UserLoginIhcl() throws Exception {
		try {
			if (!platform.equalsIgnoreCase("pwa mobile")) {
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().LogedIHCL, 30)) {
					String log = TDL_SLPElectronicsPage.get().LogedIHCL.getText();
					if (log.contains("Hi") | log.contains("hi") | log.contains("My Account") ) {
						fUtil.flogResult("Passed", "Validate User Auto Logged in Taj Hotels", "User Auto Logged in Taj Hotels", 1);
					} else {
						fUtil.flogResult("Failed", "Validate User Auto Logged in Taj Hotels", "User not Auto Logged in Taj Hotels", 1);
					}
				} else {
					fUtil.flogResult("Failed", "Validate User Auto Logged in Taj Hotels", "User not Auto Logged in Taj Hotels", 1);
				}
				
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to IHCL Page", "Total Time : "+totalTime+" seconds", 1);
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().ErrorPDP, 10)) {
					fUtil.flogResult("Failed", "Validate no Error msg in PDP", "Error msg in PDP", 1);
				} else {
				fUtil.flogResult("Passed", "Validate no Error msg in PDP", "No Error msg in PDP", 1);
				}

			}
			else {
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().LogedIHCL_toggler, 30)) {
					fUtil.flogResult("Passed", "Validate User click on toggler", "Validate User clicked on toggler", 1);
				} else {
					fUtil.flogResult("Failed", "Validate User click on toggler", "Validate User clicked on toggler", 1);
				}
				TDL_SLPElectronicsPage.get().LogedIHCL_toggler.click();
				Thread.sleep(5000);
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().LogedIHCL_mobile, 10)) {
					String log = TDL_SLPElectronicsPage.get().LogedIHCL_mobile.getText();
					if (log.contains("Hi") | log.contains("hi") | log.contains("My Account") ) {
						fUtil.flogResult("Passed", "Validate User Auto Logged in Taj Hotels", "User Auto Logged in Taj Hotels", 1);
					} else {
						fUtil.flogResult("Failed", "Validate User Auto Logged in Taj Hotels", "User not Auto Logged in Taj Hotels", 1);
					}
				} else {
					fUtil.flogResult("Failed", "Validate User Auto Logged in Taj Hotels", "User not Auto Logged in Taj Hotels", 1);
				}
				
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().ErrorPDP, 10)) {
					fUtil.flogResult("Failed", "Validate no Error msg in PDP", "Error msg in PDP", 1);
				} else {
				fUtil.flogResult("Passed", "Validate no Error msg in PDP", "No Error msg in PDP", 1);
				}
				TDL_SLPElectronicsPage.get().LogedIHCL_toggler_backButton.click();
				Thread.sleep(5000);	
			}
			
			gmethods.performanceTiming("IHCL Homepage");
		} catch (Exception e) {
			fUtil.flogResult("Failed", "User Auto Logged in", "User Auto Logged in ihcl failed due to:" + e.getMessage(), 1);
		}
	}
	
	/*
	 * This Function will validate SSO auto Login for brand Air Asia
	 */
	public void validateAutologInFlight() throws Exception {
		try {
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().airAsisAutoLogin, 20)){
				String log = TDL_SLPElectronicsPage.get().airAsisAutoLogin.getText();
				if (!log.isEmpty()) {
					fUtil.flogResult("Passed", "Validate User Auto Logged in Air Asia", "User is Auto Logged in Air Asia", 1);
				} else {
					fUtil.flogResult("Failed", "Validate User Auto Logged in Air Asia", " User not Auto Logged in Air Asia", 1);
				}
			}else {
				fUtil.flogResult("Failed", "Validate User Auto Logged in Air Asia", " User not Auto Logged in Air Asia", 1);
			}
//			endExecutionTime();
//			System.out.println("Time Taken : "+totalTime);
//			fUtil.flogResult("Passed", "Time Taken to Navigate to Air Asia Page", "Total Time : "+totalTime+" seconds", 1);

			gmethods.performanceTiming("Air Asia Homepage");
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Validate User Auto Logged in Air Asia", " in Air Asia failed due to:" + e.getMessage(), 1);
		}
	}
	
	/*
	 * This Function will validate SSO auto Login for brand Big Basket
	 */
	public void bbloggedInPD() throws Exception {
		try {
			WebDriver driver=BrowserFactory.webDriver.get();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//Thread.sleep(10000);
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().bbUnservicableOK,20)) {
				TDL_SLPElectronicsPage.get().bbUnservicableOK.click();
			}
			refreshPage(driver,By.xpath("//span[contains(@ng-bind,'memberinfo')] | //div[contains(@class,'MemberDropdown')]"));
			if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().bbloggedin1PD,30) ||
					gmethods.isElementVisible(TDL_SLPElectronicsPage.get().bbloggedinPD,10) ||
					gmethods.isElementVisible(TDL_SLPElectronicsPage.get().bbloginThirdPD,10)) {
				Thread.sleep(2000);
				fUtil.flogResult("Passed", "Validate user auto login Big Basket",
						"user is auto-logged in Big Basket", 1);
			}
			else if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().bbloginSecPD,10)) {
				Thread.sleep(2000);
				fUtil.flogResult("Failed", "Validate user auto login Big Basket",
						"user is not auto-logged in Big Basket", 1);
			}
			else {
				fUtil.flogResult("Failed", "Validate user auto login Big Basket",
						"user did not land on BB page", 1);
			}
//			endExecutionTime();
//			System.out.println("Time Taken : "+totalTime);
//			fUtil.flogResult("Passed", "Time Taken to Navigate to Big Basket Page", "Total Time : "+totalTime+" seconds", 1);

			gmethods.performanceTiming("Big Basket Homepage");
		}	catch (Exception e) {
			fUtil.flogResult("Failed", "Validate user auto login Big Basket", "Error occured: "+e.getMessage(), 1);
			e.printStackTrace();
			throw e;
			}
		}
	
	public void validateBrandSSOLogin(WebDriver driver, String parentWindowHandle) throws Exception
	{
		wait(15);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
		String brandName = "";
		try {
			if (driver.getCurrentUrl().contains("croma"))
			{
				brandName = "Croma";
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".croma-desktop-logo")));
				performanceTiming(brandName);
				try {
					System.out.println("Switching to brand window - "+brandName);
					System.out.println("Brand URL - "+ driver.getCurrentUrl());
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pincode")));
					fUtil.flogResult("Pass", "Brand SSO Login", "Login to Croma successful", 1);
					fUtil.flogResult("Pass", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Auto SSO not happening in - "+brandName);

					fUtil.flogResult("Fail", "Brand SSO Login", "Login to Croma failed", 1);
					fUtil.flogResult("Fail", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				}
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to Croma Page", "Total Time : "+totalTime+" seconds", 1);

			}
			if (driver.getCurrentUrl().contains("bigbasket"))
			{
				brandName = "BB";
				new WebDriverWait(driver, 30).until(ExpectedConditions.urlMatches("^(https://www.bigbasket.com)"));
				performanceTiming(brandName);
				try {
					System.out.println("Switching to brand window - "+brandName);
					System.out.println("Brand URL - "+ driver.getCurrentUrl());
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@qa='userAccount'] | //i[@class[contains(.,'icon svg-header svg-basket')]] | //*[text()='TechOps'] | //*[@id='mainHeader']/div/div[1]/div[3]/div/span[2] | //*[text()='SyntheticMonitoringThirty'] ")));
					System.out.println("Autologin successful in brand - "+brandName);
					fUtil.flogResult("Pass", "Brand SSO Login", "Login to Big Basket successful", 1);
					fUtil.flogResult("Pass", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Auto SSO not happening in - "+brandName);
					fUtil.flogResult("Fail", "Brand SSO Login", "Login to BB failed", 1);
					fUtil.flogResult("Fail", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				}
				
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to Big Basket Page", "Total Time : "+totalTime+" seconds", 1);

			}
			if (driver.getCurrentUrl().contains("westside"))
			{
				brandName = "westside";
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='logo-img'])[2]")));
				performanceTiming(brandName);
				try {
					System.out.println("Switching to brand window - "+brandName);
					System.out.println("Brand URL - "+ driver.getCurrentUrl());
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='customer-links custom ']|//a[@class='acc-links acc-title custom']")));
					fUtil.flogResult("Pass", "Brand SSO Login", "Login to Westside successful", 1);
					fUtil.flogResult("Pass", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Auto SSO not happening in - "+brandName);
					fUtil.flogResult("Fail", "Brand SSO Login", "Login to Westside failed", 1);
					fUtil.flogResult("Fail", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				}
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to West Side Page", "Total Time : "+totalTime+" seconds", 1);

			}
			if (driver.getCurrentUrl().contains("tatacliq"))
			{
				brandName = "Cliq";
				//				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				long start_time = System.currentTimeMillis();
				long wait_time = 15000;
				long end_time = start_time + wait_time;
				boolean flag = false;
				while (System.currentTimeMillis() < end_time) {
					if (!driver.getCurrentUrl().contains("tatadigital.com"))
					{
						flag = true;
						break;
					}
				}

				if (!flag)
				{
					System.out.println("Auto SSO not happening in - "+brandName);
					System.out.println("Brand URL - "+ driver.getCurrentUrl());
					fUtil.flogResult("Fail", "Brand SSO Login", "Login to Cliq Failed - Unable to load page (check manually once)", 1);
				}
				else {
					new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".DesktopHeader__logoHolder")));
					performanceTiming(brandName);
					try {

						System.out.println("Switching to brand window (Cliq) - "+brandName);
						System.out.println("Brand URL - "+ driver.getCurrentUrl());
						new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.DesktopHeader__nameSpan")));
						fUtil.flogResult("Pass", "Brand SSO Login", "Login to Cliq successful", 1);
						fUtil.flogResult("Pass", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Auto SSO not happening in - "+brandName);
						fUtil.flogResult("Fail", "Brand SSO Login", "Login to Cliq successful", 1);
						fUtil.flogResult("Fail", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
					}
				}
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to Tata CLiQ Page", "Total Time : "+totalTime+" seconds", 1);

			}
			if (driver.getCurrentUrl().contains("tajhotels"))
			{
				brandName = "taj";
				System.out.println("Switching to brand window - "+brandName);
				System.out.println("Brand URL - "+ driver.getCurrentUrl());
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img.taj-image")));
				performanceTiming(brandName);

				try {
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='profile-username'])[2]")));
					System.out.println("Auto SSO successful in - "+brandName);
					fUtil.flogResult("Pass", "Brand SSO Login", "Login to Taj Hotels successful", 1);
					fUtil.flogResult("Pass", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Auto SSO not happening in - "+brandName);
					fUtil.flogResult("Fail", "Brand SSO Login", "Login to Taj Hotels failed", 1);
					fUtil.flogResult("Fail", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				}
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to IHCL Page", "Total Time : "+totalTime+" seconds", 1);

			}
			if (driver.getCurrentUrl().contains("amastay"))
			{
				brandName = "ama";
				System.out.println("Switching to brand window - "+brandName);
				System.out.println("Brand URL - "+ driver.getCurrentUrl());
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src[contains(.,'Logo/group-3')]]")));
				performanceTiming(brandName);

				try {
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='profile-username'])[2]")));
					System.out.println("Auto SSO successful in - "+brandName);
					fUtil.flogResult("Pass", "Brand SSO Login", "Login to AMA successful", 1);
					fUtil.flogResult("Pass", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Auto SSO not happening in - "+brandName);
					fUtil.flogResult("Fail", "Brand SSO Login", "Login to AMA failed", 1);
					fUtil.flogResult("Fail", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				}
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to Amastay Page", "Total Time : "+totalTime+" seconds", 1);

			}
			if (driver.getCurrentUrl().contains("airasia"))
			{
				brandName = "AirAsia";
				System.out.println("Switching to brand window - "+brandName);
				System.out.println("Brand URL - "+ driver.getCurrentUrl());
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".img-logo")));
				performanceTiming(brandName);

				try {
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.miniprofile-dropdown-toggle")));
					System.out.println("Auto SSO successful in - "+brandName);
					fUtil.flogResult("Pass", "Brand SSO Login", "Login to Air Asia successful", 1);
					fUtil.flogResult("Pass", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Auto SSO not happening in - "+brandName);
					fUtil.flogResult("Fail", "Brand SSO Login", "Login to Air Asia failed", 1);
					fUtil.flogResult("Fail", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				}
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to Air Asia Page", "Total Time : "+totalTime+" seconds", 1);


			}
			if (driver.getCurrentUrl().contains("qmin") && !(driver.getCurrentUrl().startsWith("https://www.tatadigital.com")))
			{
				brandName = "qmin";
				System.out.println("Switching to brand window - "+brandName);
				System.out.println("Brand URL - "+ driver.getCurrentUrl());
				wait(5);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				try {
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='signature sig-text']")));
					performanceTiming(brandName);
					System.out.println("Navigated to Qmin");
					fUtil.flogResult("Pass", "Brand SSO Login", "Login to Qmin successful", 1);
					fUtil.flogResult("Pass", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Auto SSO not happening in - "+brandName);
					fUtil.flogResult("Fail", "Brand SSO Login", "Login to Qmin failed", 1);
					fUtil.flogResult("Fail", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				}
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to QMIN Page", "Total Time : "+totalTime+" seconds", 1);

			}
			if (driver.getCurrentUrl().contains("qmin") && (driver.getCurrentUrl().startsWith("https://www.tatadigital.com")))
			{
				brandName = "Qmin CDP";

				try {
					new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='facebook-share-desktop'] |  //*[@id='bookmarkHeader2']")));
					performanceTiming(brandName);
					System.out.println("Navigated to Qmin");
					fUtil.flogResult("Pass", "QMIN CDP Page, URL", driver.getCurrentUrl(), 1);

				}catch(Exception e) {
					fUtil.flogResult("Fail", "QMIN CDP Page, URL", driver.getCurrentUrl(), 1);
				}

			}


			//close the brand window
			driver.close();

			driver.switchTo().window(parentWindowHandle);
			wait(3);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Page load timeout");
			//logger.info("Page load timeout");
			try {
				fUtil.flogResult("Fail", "Brand SSO Login", "Load Time Issue", 1);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			String title = (String)((JavascriptExecutor)driver).executeScript("return document.title;");
			String url = (String)((JavascriptExecutor)driver).executeScript("return document.URL;");
			System.out.println(title);
			System.out.println(url);
			if (url.contains("qmin"))
			{
				System.out.println("Page LOad not successful in QMIN");
				try {
					fUtil.flogResult("Fail", "Brand SSO Login", "Load Time Issue - Qmin", 1);
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

			if(url.contains("tatacliq"))
			{
				System.out.println("Page load not successful for TataCliq");
				try {
					fUtil.flogResult("Fail", "Brand SSO Login", "Load Time Issue - Cliq", 1);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			((JavascriptExecutor)driver).executeScript("window.self.close();");
			//			driver.close();
			driver.switchTo().window(parentWindowHandle);
			wait(2);
		}
	}
	
	public void wait(int s)
	{
		try {
			Thread.sleep(s * 1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void refreshPage(WebDriver driver, By by)
	{
		boolean flag = true;
		int count=0;
		while (flag || count>=4)
		{
			try {
				new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(by));
				flag = false;
			} catch (Exception e) {
				// TODO: handle exception
				driver.navigate().refresh();
				count++;
				if(count>4)
				{
					break;
				}
				logger.info("Refreshing Page due to loading issue...");
			}
		}
	}
	
	public void keepSCrollingLazyLoad(WebDriver driver) 
	{
		try {
			//get scrollheight of DOM
			long documentscrollHeight = Long.parseLong(((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight;").toString());

			long scrollIntervalHeight = 300;
			long startHeight = 0;
			long alreadyScrolledHeight = 0;
			while (documentscrollHeight > alreadyScrolledHeight)
			{
				//scroll through the length of the page gradually with 300 px interval
				((JavascriptExecutor)driver).executeScript("window.scrollTo(arguments[0], arguments[1]);", startHeight, (alreadyScrolledHeight+scrollIntervalHeight));
				Thread.sleep(1000);
				alreadyScrolledHeight += scrollIntervalHeight;
				startHeight = alreadyScrolledHeight;
				documentscrollHeight = Long.parseLong(((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight;").toString());
			}

			//scroll to the top
			((JavascriptExecutor)driver).executeScript("window.scrollTo(0, 0);");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to scroll the page");
		}


	}
	
	/*
	 * This Function will validate SSO auto Login for brand Ama Stays and Other Hotels
	 */
	public void UserLoginIhclAmaStaysAndOtherHotels() throws Exception {
		try {
			
			if (!platform.equalsIgnoreCase("pwa mobile")) {
				
				if (!gmethods.isElementVisible(TDL_SLPElectronicsPage.get().LogedIHCLAma, 20)) {
					System.out.println("Refreshing Page");
					BrowserFactory.webDriver.get().navigate().refresh();
				}

				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().LogedIHCLAma, 20)) {
					String log = TDL_SLPElectronicsPage.get().LogedIHCLAma.getText();
					if (!log.isEmpty() ) {
						fUtil.flogResult("Passed", "Validate User Auto Logged in Ama Stays/Other Hotels", "User Auto Logged in Ama Stays/Other Hotels", 1);
					} else {
						fUtil.flogResult("Failed", "Validate User Auto Logged in Ama Stays/Other Hotels", "User not Auto Logged in Ama Stays/Other Hotels", 1);
					}
				} else {
					fUtil.flogResult("Failed", "Validate User Auto Logged in Ama Stays/Other Hotels", "User not Auto Logged in Ama Stays/Other Hotels", 1);
				}
				if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().ErrorPDP, 5)) {
					fUtil.flogResult("Failed", "Validate no Error msg in PDP", "Error msg in PDP", 1);
				} else {
				fUtil.flogResult("Passed", "Validate no Error msg in PDP", "No Error msg in PDP", 1);
				}

			}	
			gmethods.performanceTiming("IHCL Homepage");
		} catch (Exception e) {
			fUtil.flogResult("Failed", "User Auto Logged in", "User Auto Logged in ihcl failed due to:" + e.getMessage(), 1);
		}
	}
	
	/*
	 * This Function will validate SSO auto Login for brand Tata Cliq luxury
	 */
	@Test
	public void UserLoginTataCliqLuxury() throws Exception{
		try {
			Thread.sleep(5000);
			if(gmethods.isElementVisible(TdlCromaCard.get().Luxurymyaccounticon,30))
			{
				Thread.sleep(5000);
				TdlCromaCard.get().Luxurymyaccounticon.click();
				if(gmethods.isElementVisible(TDL_SLPElectronicsPage.get().autoLogInCliq_android, 10))
					fUtil.flogResult("Failed", "Validate User Auto Logged in Tata Cliq luxury","User not Auto Logged in Tata Cliq luxury",1);
				else
					fUtil.flogResult("Passed", "Validate User Auto Logged in Tata Cliq luxury","User Auto Logged in Tata Cliq luxury",1);
			}
			else
			{
				fUtil.flogResult("Failed", "Validate User Auto Logged in Tata Cliq luxury", 
						"Validate User not Auto Logged in Tata Cliq luxury",1);
			}
			gmethods.performanceTiming("Tata Cliq Luxury Homepage");

		}catch(Exception e) {
			fUtil.flogResult("Failed", "Validate User Auto Logged in", 
					"Validate User not Auto Logged in failed due to:"+e.getMessage(), 1);
		}
	}
	
	public void endExecutionTime() {
		try {
			endTime=new Date().getTime();
		//	totalTime=(endTime-startTime)/1000;
		    DecimalFormat f = new DecimalFormat("##.00");
		    totalTime=f.format((endTime-startTime)/1000);
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void UserLoginWestSide() throws Exception {
		try {
		Thread.sleep(5000);


			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().Loged, 20)) 
			{
				String log = TDL_SLPElectronicsPage.get().Loged.getText();
				if (!log.equalsIgnoreCase("Sign in / Sign Up")) {
					fUtil.flogResult("Passed", "Validate User Auto Logged in Tata Cliq", "User Auto Logged in Tata Cliq", 1);
				} else {
					fUtil.flogResult("Failed", "Validate User Auto Logged in Tata Cliq", "User not Auto Logged in Tata Cliq", 1);
				}
			} else 
			{
				 
				fUtil.flogResult("Failed", "Validate User Auto Logged in Tata Cliq", "User not Auto Logged in Tata Cliq", 1);
			}
			
//			endExecutionTime();
//			System.out.println("Time Taken : "+totalTime);
//			fUtil.flogResult("Passed", "Time Taken to Navigate to WestSide store Page", "Total Time : "+totalTime+" seconds", 1);

			gmethods.performanceTiming("Tata Cliq Homepage");
			if (gmethods.isElementVisible(TDL_SLPElectronicsPage.get().westside, 10))
			
				fUtil.flogResult("Passed", "Validate redirected to PLP Page Tata Cliq", "Redirected to PLP page Tata Cliq successfully", 1);
			
			else 
				fUtil.flogResult("Failed", "Validate redirected to PDP Page Tata Cliq", "Redirected to PDP page Tata Cliq not successfull", 1);

		} catch (Exception e)
		{
			fUtil.flogResult("Failed", "Login west side store page", "issue in west side store page:" + e.getMessage(), 1);
		}

	}
	
	public void deleteFilesOlderThanNdays(String dirWay) {
		try {
			int nDaysOld=25;
			File directory = new File(dirWay);
			if(directory.exists()){

				File[] listFiles = directory.listFiles();            
				long purgeTime = System.currentTimeMillis() - (nDaysOld * 24 * 60 * 60 * 1000);
				for(File listFile : listFiles) {
					if(listFile.lastModified() < purgeTime) {
						if(!listFile.delete()) {
							System.err.println("Unable to delete file: " + listFile);
						}
					}
				}
			} else {
				System.err.println(dirWay+" directory doesn't exist !");	    
			}
		}catch(Exception e) {
			System.err.println("Error while deleting files older than N days : "+e.getMessage());
		}
	}
	
	public void validateErrorAndKillDriver(String errorDescription) {
		try {
			if(errorDescription.contains("java.net.ConnectException")) {
				BaseScript.taskKill("chromedriver.exe");
				logger.error("Exception Caught ! Killed The Chrome Instance .");
			}
		}catch(Exception e) {
			
		}
	}
	
	public void clickUsingJS(WebElement e) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.webDriver.get();
		js.executeScript("arguments[0].click();", e);
	}
	
	public void UserLoginQmin() throws Exception {
		try {
			WebDriver driver=BrowserFactory.webDriver.get();
			wait(15);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
			String brandName = "";
			
			if (driver.getCurrentUrl().contains("qmin") && !(driver.getCurrentUrl().startsWith("https://www.tatadigital.com")))
			{
				brandName = "qmin";
				System.out.println("Switching to brand window - "+brandName);
				System.out.println("Brand URL - "+ driver.getCurrentUrl());
				wait(5);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				try {
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='signature sig-text']")));
					performanceTiming(brandName);
					System.out.println("Navigated to Qmin");
					fUtil.flogResult("Pass", "Brand SSO Login", "Login to Qmin successful", 1);
					fUtil.flogResult("Pass", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Auto SSO not happening in - "+brandName);
					fUtil.flogResult("Fail", "Brand SSO Login", "Login to Qmin failed", 1);
					fUtil.flogResult("Fail", "Brand SSO Login - "+brandName+" URL", driver.getCurrentUrl(), 0);
				}
//				endExecutionTime();
//				System.out.println("Time Taken : "+totalTime);
//				fUtil.flogResult("Passed", "Time Taken to Navigate to QMIN Page", "Total Time : "+totalTime+" seconds", 1);

			}
			if (driver.getCurrentUrl().contains("qmin") && (driver.getCurrentUrl().startsWith("https://www.tatadigital.com")))
			{
				brandName = "Qmin CDP";

				try {
					new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='facebook-share-desktop'] |  //*[@id='bookmarkHeader2']")));
					performanceTiming(brandName);
					System.out.println("Navigated to Qmin");
					fUtil.flogResult("Pass", "QMIN CDP Page, URL", driver.getCurrentUrl(), 1);

				}catch(Exception e) {
					fUtil.flogResult("Fail", "QMIN CDP Page, URL", driver.getCurrentUrl(), 1);
				}

			}
		} catch (Exception e) {
			fUtil.flogResult("Failed", "Qmin page", "Exception Caught . User Login Qmin Validation failed due to: " + e.getMessage(), 1);
		}
	}
}
//verify if an element is highlighted
//wait for object----change the logic
//test1

