package com.QA.TestApp.Pages.MOBILE;



import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;

public class TDL_MAPaymentConnectionAddressPage_Mobile {
	@FindBy(xpath="//*[contains(@text, 'Enter your address')]") public MobileElement addressheader_andriod;
    @FindBy(xpath="//android.view.View[2]/android.view.View[5]/android") public MobileElement areadropdown_andriod;
    @FindAll({@FindBy(xpath="//android.view.View[2]/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View")})public List<MobileElement> areadropdownList_andriod;
    @FindBy(xpath="//android.view.View[2]/android.view.View[5]/android.widget.EditText[1]") public MobileElement address_andriod;
    @FindBy(xpath="") public MobileElement landmark_andriod;
    @FindBy(xpath="//*[contains(@text, 'Continue')]") public MobileElement continuebtn_andriod;



}
