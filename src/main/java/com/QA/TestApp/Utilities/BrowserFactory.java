package com.QA.TestApp.Utilities;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.log.Logger;
import com.ssts.pcloudy.Connector;
import com.ssts.pcloudy.Version;
import com.ssts.pcloudy.dto.device.MobileDevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	private static BrowserFactory instance = null;
	public static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<>();
	public FrameWorkUtility FUtil = new FrameWorkUtility();
	String oSystem=System.getProperty("os.name").trim();
	int browserInitCount=0;

	//WebDriver driver;
	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	@SuppressWarnings("deprecation")
	public void setDriver(String browser) throws Exception {
		try {
			DesiredCapabilities caps = null;
			String testPlanName=FUtil.readInput("TestPlan").trim();

			switch (browser.toLowerCase()) {
			case "chrome":
				browserInitCount++;
				if((testPlanName.contains("WarmUpScriptsPlan") || testPlanName.contains("WarmUpScripts") || testPlanName.contains("ProdWidgetScripts")) && browserInitCount>1)
					//Thread.sleep(300000);
					{
					//BaseScript.logger.info("Waiting for 3 Minutes before starting Next Test....");
					//TimeUnit.MINUTES.sleep(3);
					}
			//	caps = DesiredCapabilities.chrome();
				ChromeOptions chOptions = new ChromeOptions();
				Map<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("credentials_enable_service", false);
				//Pass the argument 1 to allow and 2 to block

				JSONObject jsonObject = new JSONObject();
				//jsonObject.put("profile.default_content_settings.geolocation", 1);
			//	jsonObject.put("profile.default_content_setting_values.notifications", 2);
				chromePrefs.put("prefs", jsonObject);
				chromePrefs.put("profile.default_content_setting_values.notifications", 2);
				//chromePrefs.put("profile.default_content_setting_values.notifications", 1);
				chromePrefs.put("profile.default_content_setting_values.geolocation", 1);

				chOptions.setExperimentalOption("prefs", chromePrefs);
				chOptions.addArguments("--disable-plugins", "--disable-extensions",
						"--disable-popup-blocking");
				String headlessExecutionFlag=FUtil.readInput("HeadlessExecution");
				if(headlessExecutionFlag.equalsIgnoreCase("true")) {
					chOptions.addArguments("--headless");
					chOptions.addArguments("--window-size=1325x744");

				}
				
//				caps.setCapability(ChromeOptions.CAPABILITY, chOptions);
//				caps.setCapability("applicationCacheEnabled", false);
				System.out.println(oSystem);
				if(!oSystem.toLowerCase().contains("mac")) {
					System.setProperty("webdriver.chrome.driver",FUtil.readInput("ChromeDriver"));
				//		WebDriverManager.chromedriver().setup();
				
				}

				webDriver.set(new ChromeDriver(chOptions));
				webDriver.get().manage().window().maximize();
				FUtil.flogResult("Passed", "Browser Description : ", webDriver.get().getCapabilities().getBrowserName()+"-"+webDriver.get().getCapabilities().getVersion(), 0);

				break;

			case "firefox":


				FirefoxProfile profile = new FirefoxProfile();
				//			Pass the argument 1 to allow and 2 to block
				profile.setPreference("permissions.default.desktop-notification", 1);
				profile.setPreference("geo.enabled", true);
				profile.setPreference("geo.provider.use_corelocation", true);
				profile.setPreference("geo.prompt.testing", true);
				profile.setPreference("geo.prompt.testing.allow", true);
				caps = DesiredCapabilities.firefox();
				FirefoxOptions ffOptions = new FirefoxOptions();
				ffOptions.addArguments("--disable-plugins", "--disable-extensions",
						"--disable-popup-blocking");
				ffOptions.addArguments("--disable-notifications");
				caps.setCapability(FirefoxDriver.PROFILE, profile);
				caps.setCapability("applicationCacheEnabled", false);

				if(!oSystem.toLowerCase().contains("mac")) {
				//	System.setProperty("webdriver.gecko.driver",FUtil.readInput("GeckoDriver"));
					WebDriverManager.firefoxdriver().setup();
					File pathBinary = new File(FUtil.readInput("FireFoxPath"));
					FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
					caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, ffOptions.setBinary(firefoxBinary));

				}
				ffOptions.merge(caps);
				webDriver.set(new FirefoxDriver(ffOptions));			
				webDriver.get().manage().window().maximize();
				FUtil.flogResult("Passed", "Browser Description : ", webDriver.get().getCapabilities().getBrowserName()+"-"+webDriver.get().getCapabilities().getVersion(), 0);

				break;

			case "edge":
				caps = DesiredCapabilities.edge();
				EdgeOptions eOptions = new EdgeOptions();
				caps.setCapability("applicationCacheEnabled", false);
				eOptions.merge(caps);
			//	System.setProperty("webdriver.chrome.driver",
			//			FUtil.readInput("EdgeDriver"));
				WebDriverManager.edgedriver().setup();
				webDriver.set(new ChromeDriver(eOptions));
				webDriver.get().manage().window().maximize();
				FUtil.flogResult("Passed", "Browser Description : ", webDriver.get().getCapabilities().getBrowserName()+"-"+webDriver.get().getCapabilities().getVersion(), 0);

				break;

			case "opera":
				caps = DesiredCapabilities.opera();
				OperaOptions oOptions = new OperaOptions();
				Map<String, Object> opPrefs = new HashMap<String, Object>();
				opPrefs.put("credentials_enable_service", false);
				//Pass the argument 1 to allow and 2 to block
				opPrefs.put("profile.default_content_setting_values.notifications", 1);
				oOptions.setExperimentalOption("prefs", opPrefs);
				oOptions.addArguments("--disable-plugins", "--disable-extensions",
						"--disable-popup-blocking");
				oOptions.addArguments("--disable-notifications");
				oOptions.merge(caps);
				caps.setCapability("applicationCacheEnabled", false);
			//	System.setProperty("webdriver.opera.driver",
			//			FUtil.readInput("OperaDriver"));
				WebDriverManager.operadriver().setup();
				oOptions.setBinary(FUtil.readInput("OperaPath"));        
				webDriver.set(new OperaDriver(oOptions));
				webDriver.get().manage().window().maximize();
				FUtil.flogResult("Passed", "Browser Description : ", webDriver.get().getCapabilities().getBrowserName()+"-"+webDriver.get().getCapabilities().getVersion(), 0);

				break;

			case "IE":
				try {
					caps=DesiredCapabilities.internetExplorer();
					caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					System.out.println("Inside IE");
				//	System.setProperty("webdriver.ie.driver", FUtil.readInput("IEDriver"));
					WebDriverManager.iedriver().setup();
					webDriver.set(new InternetExplorerDriver(caps)); 
					webDriver.get().manage().window().maximize();
				}
				catch(SessionNotCreatedException ee) {
					webDriver.get().findElement(By.xpath("//html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
					webDriver.get().findElement(By.xpath("//html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				}

				break;

			case "pwa mobile1":
				caps = DesiredCapabilities.chrome();
				Map<String, String> mobileEmulation = new HashMap<>();
				mobileEmulation.put("deviceName", FUtil.fgetDataNew1("DeviceName"));
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
				chromeOptions.addArguments("--disable-plugins", "--disable-extensions",
						"--disable-popup-blocking");
				caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				caps.setCapability("applicationCacheEnabled", false);

				if(!oSystem.toLowerCase().contains("mac")) {
			//		System.setProperty("webdriver.chrome.driver",
			//				FUtil.readInput("ChromeDriver"));
					WebDriverManager.chromedriver().setup();
				}
				//			System.setProperty("webdriver.chrome.driver",
				//					FUtil.readInput("ChromeDriver"));
				webDriver.set(new ChromeDriver(chromeOptions));
				webDriver.get().manage().window().maximize();
				FUtil.flogResult("Passed", "Environment Description : ", "Browser : "+webDriver.get().getCapabilities().getBrowserName()+" -Device : "+mobileEmulation.get("deviceName"), 0);

				break;

			case "safari":
				caps = DesiredCapabilities.safari();

				webDriver.set(new SafariDriver()); 

				webDriver.get().manage().window().maximize();
				FUtil.flogResult("Passed", "Browser Description : ", webDriver.get().getCapabilities().getBrowserName()+"-"+webDriver.get().getCapabilities().getVersion(), 0);

				break;
			case "pwa mobile":

				String platform=FUtil.readInput("PwaMobilePlatform").toLowerCase().trim();

				if(FUtil.readInput("ConnectRealDevice").equalsIgnoreCase("yes") && FUtil.readInput("ConnectAnyDeviceInPcloudy").equalsIgnoreCase("no"))
				{
					caps = new DesiredCapabilities();

					System.out.println(platform);
					if(platform.equalsIgnoreCase("Android")) {
						String androidDeviceUdid=FUtil.readInput("AndroidDeviceUdid");
						String version=FUtil.readInput("DeviceAndroidVersion");

						caps.setCapability("deviceName", androidDeviceUdid);//device name is the phone model number(Setting-> About phone)
						caps.setCapability("platformName", "Android");
						caps.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
						caps.setCapability(CapabilityType.VERSION,version);

					}else if(platform.equalsIgnoreCase("ios")){
						String iOSDeviceName=FUtil.readInput("iOSDeviceName");

						caps.setCapability("deviceName", iOSDeviceName);
						caps.setCapability("platformName", "iOS");
						caps.setCapability(CapabilityType.BROWSER_NAME,"safari");
						caps.setCapability("automationName", "XCUITest");
					}


					URL url1= new URL("http://127.0.0.1:4723/wd/hub");//default URL of the appium server

					webDriver.set(new RemoteWebDriver(url1, caps)); 
				}
				else if(FUtil.readInput("ConnectAnyDeviceInPcloudy").equalsIgnoreCase("yes") && FUtil.readInput("ConnectRealDevice").equalsIgnoreCase("no"))
				{
					connectAnyAvailableDeviceInPcloudyForPwaMobile(platform);
					//				}else if(FUtil.readInput("ConnectAnyDeviceInPcloudy").equalsIgnoreCase("no") && FUtil.readInput("ConnectRealDevice").equalsIgnoreCase("no")) {
					//					connectSpecificDeviceInPcloudy(sOS);
					//					break;
				}else {
					System.out.println("\n\n**** NO PROPER SETTINGS IN CONFIG FILE ****");
					System.out.println("**** PLEASE SET THE PROPERTIES PROPERLY **** \n\n");
				}


				break;
			}
		}catch(Exception e) {
			e.printStackTrace();

		}
	}

	public WebDriver getDriver() {
		return webDriver.get();
	}

	public void connectAnyAvailableDeviceInPcloudyForPwaMobile(String sOS) throws Exception{
		List<MobileDevice> deviceName = null;
		BaseScript.con.set(new Connector("https://device.pcloudy.com/api/"));
		String authToken = BaseScript.con.get().authenticateUser(FUtil.fgetDataNew1("pCloudy_Username"), FUtil.fgetDataNew1("pCloudy_ApiKey"));
		if(sOS.equalsIgnoreCase("ios")) {
			while(true) {
				deviceName = BaseScript.con.get().chooseDevices(authToken, "iOS", new Version("13.*.*"), new Version("14.*.*"), 1);

				String connectedDevice = deviceName.get(0).full_name;
				if(!connectedDevice.toLowerCase().contains("ipad")) {
					break;
				}
			}
		}
		else {
			while(true) {
				deviceName = BaseScript.con.get().chooseDevices(authToken, "android", new Version("9.*.*"), new Version("11.*.*"), 1);
				String connectedDevice = deviceName.get(0).full_name;
				if(!connectedDevice.toLowerCase().contains("tab") && !connectedDevice.toLowerCase().contains("Xiaomi")) {
					break;
				}
			}
		}
		String device = deviceName.get(0).full_name;
		String platformVersion = deviceName.get(0).version;
		try {
			webDriver.set(new AppiumDriver<MobileElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), deviceConnection(device, platformVersion, sOS)));


			FUtil.flogResult("Passed", "Device Connection", "Device Connected : "+device, 0);
			FUtil.flogResult("Passed", "Browser Description : ", webDriver.get().getCapabilities().getBrowserName().toUpperCase(), 0);

			System.out.println("\n\n**** Device Connected : "+device+" **** \n\n");

			//break;
		}
		catch(Exception e) {
			FUtil.flogResult("Failed", "Device Connection", "Failed to Connect to Device in pCloudy  : "+e.getMessage(), 0);
			System.out.println("\n\n Failed to Connect to Device in pCloudy  "+e.getMessage());
			throw e;
		}

	}

	public Capabilities deviceConnection(String device, String platformVersion, String platform) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("pCloudy_Username", FUtil.fgetDataNew1("pCloudy_Username"));
		capabilities.setCapability("pCloudy_ApiKey", FUtil.fgetDataNew1("pCloudy_ApiKey"));
		capabilities.setCapability("pCloudy_DurationInMinutes", 10);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("adbExecTimeout", 90000);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("pCloudy_DeviceVersion", platformVersion);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("autoGrantPermissions", true);
		if(device.isEmpty() || device == "") {
			capabilities.setCapability("pCloudyDeviceManafacturer", FUtil.fgetDataNew1("pCloudyDeviceManafacturer"));
		}
		else {
			capabilities.setCapability("pCloudy_DeviceFullName", device);
		}

		if(platform.equalsIgnoreCase("ios")) {
			capabilities.setCapability("platformName", "ios");
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability(CapabilityType.BROWSER_NAME,"safari");

		}
		else if(platform.equalsIgnoreCase("android")){
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
			//capabilities.setCapability("automationName", "uiautomator2");								
		}
		return capabilities;
	}
}
