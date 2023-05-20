package com.QA.TestApp.Testcases.MOBILE;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.QA.TestApp.Pages.MOBILE.CalcPage;
//import com.QA.TestApp.Pages.B2BPage2;
import com.QA.TestApp.Utilities.BaseScript;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//import com.google.common.collect.Table.Cell;
//import com.ibm.icu.impl.InvalidFormatException;

public class Calculator extends BaseScript{
	//public WebDriver driver;
	//public String testCaseName;

@Test
public void calculatorAdd() throws Exception {
	try {
	CalcPage.get().digit2.click();
	fUtil.flogResult("Passed", "Validate the click","Output is correct", 1);
	CalcPage.get().plus.click();
	fUtil.flogResult("Passed", "Validate the click","Output is correct", 1);
	CalcPage.get().digit4.click();
	fUtil.flogResult("Passed", "Validate the click","Output is correct", 1);
	CalcPage.get().equal.click();
	String res=CalcPage.get().result.getText();
	fUtil.flogResult("Passed", "Validate the click-"+res,"Output is correct", 1);
	System.out.println("Result is : "+res);
	String resultExpected=fUtil.fgetDataNew1("result");
	if(res.equals(resultExpected)) {
		fUtil.flogResult("Passed", "Validate the output","Output is correct", 1);
	}else {
		fUtil.flogResult("Failed", "Validate the output","Expected Output is "+resultExpected+" But getting "+res, 1);
	}
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
}
@Test
public void testReport() throws Exception {
	
	
	fUtil.flogResult("Passed", "Calculator Open","Calculator Opened", 1);
}

@Test
public void Logout() throws Exception {
	fUtil.flogResult("Failed", "fail","Text fail", 1);
}





/*	public String[] ReadExcel() throws IOException
	{

		FileInputStream fi=new FileInputStream("C:\\Users\\674190\\Desktop\\MyData.xls");
		HSSFWorkbook wb= new HSSFWorkbook(fi);
		HSSFSheet sheet=wb.getSheetAt(0);
		int rowCount=sheet.getPhysicalNumberOfRows();
		HSSFRow firstRow=sheet.getRow(0);
		HSSFRow SecondRow=sheet.getRow(1);x
		int columnCount= firstRow.getPhysicalNumberOfCells();
		for(int i=0;i<columnCount;i++){
			String headerValue=firstRow.getCell(i).getStringCellValue();
			if(headerValue.equals("TestcaseName")){
				testCaseName=SecondRow.getCell(i).getStringCellValue();
			}
		}
		String []OutText=new String[2];
		OutText[0]  =sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println("TestCase Value is "+OutText[0] );
		OutText[1]=sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Search Value is "+OutText[1] );
		return OutText;

	}*/
	
	
}
