package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Rewards_And_Benifits {
	
	public Rewards_And_Benifits() {
		PageFactory.initElements(new AppiumFieldDecorator(BaseScript.appiumDriver.get()), this);
	}
	
	
//	for Android 
	
	//*[@text='Mobile number']
	@FindBy(xpath ="//*[@text='Mobile number']") public MobileElement MobileNumber;
	@FindBy(xpath = "//*[@text='Get OTP']") public MobileElement getotp;
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"NeuPass\"]") public MobileElement NeuPassButton ;
	@FindBy(xpath ="//*[@text='Available NeuCoins']" ) public MobileElement AvailableNeucoins ;
	@FindBy(xpath = "//*[@text='card background']") public MobileElement CardValidate ;
	@FindBy(xpath = "//*[@text='View details']") public MobileElement ViewDetail;
//	@FindBy(xpath = "//android.view.View [@resource-id=\"expanded-header-section\"]") public MobileElement ViewDetailValidate ;
	@FindBy(xpath = "//*[@text='Know more']") public MobileElement KnowMoreWidget;
	@FindBy(xpath = "//*[@text='Earn min. 5% NeuCoins every time!']") public MobileElement EarnMinfiveNeucoins;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Luxury\"]") public MobileElement LuxurySLPopt;
	@FindBy(xpath ="//*[@text='Search']") public MobileElement LuxurySearch;
	
	@FindBy(xpath ="//android.view.View [@resource-id=\"header\"]") public MobileElement searchContent ;
	//android.view.View [@resource-id="header"]
//	@FindBy(xpath ="") public MobileElement Brooks Brothers Red Fleece Bright Green Baseball Cap;
//	@FindBy(xpath ="") public MobileElement ;
}
