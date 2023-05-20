package com.QA.TestApp.Pages.MOBILE;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;

public class TDL_MyQRPage_Mobile {
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvTitle") public MobileElement myQR_header_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivQRCode") public MobileElement myQR_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvVpa") public MobileElement customervpa_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivShare") public MobileElement sharebtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivBack") public MobileElement backbtn_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/ivSelection") public MobileElement setQRlimitcheck_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvSetAmount") public MobileElement setQRLimitText_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvSetAmount") public MobileElement changeQRLimitText_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/tvAmount") public MobileElement youcanrequesttext_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/etAmount") public MobileElement inputQRlimit_android;
	@FindBy(id = "com.tatadigital.tcp.dev:id/btnConfirm") public MobileElement confirmbtn_android;
	@FindBy(id = "vivo:id/resolver_slide") public MobileElement sharewithapp_android;

}
