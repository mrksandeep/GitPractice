package com.QA.TestApp.Utilities;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.model.Test;

public class ExtentTestManager {
    //static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    static ThreadLocal<ExtentTest> testObject=new ThreadLocal<>();
    static ThreadLocal<ExtentHtmlReporter> htmlRepoter=new ThreadLocal<>();
    public static ThreadLocal<Test> testt=new ThreadLocal<>();
    public static ThreadLocal<ExtentReports> extent = new ThreadLocal<>();
   
    public static ExtentTest getTest() {
        //return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    	
    	return testObject.get();
    }
    public static Test getTestStatus() {
    	return testt.get();
    }
    /*public static void endTest() {
        //extent.get().endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    	extent.get().endTest(testObject.get());
    	extent.get().
    }*/
    
    public static void html_Reporter(){
    	
    	htmlRepoter.get().config().setDocumentTitle("Automation Report");
    	
    	htmlRepoter.get().config().setReportName("report");
    	htmlRepoter.get().config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
  
    public static ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }
   
    
    public static ExtentTest startTest(String testName, String desc) {
    	if(BaseScript.ExtentReportingLevel.equalsIgnoreCase("Suite")) {
    		extent.set(BaseScript.report);
    		/*
			 * if(extent.get()==null) { extent.set(new ExtentReports(BaseScript.reportName,
			 * true)); //extent.set(ExtentManager.getInstance()); }
			 */
    		
    	}
    	if(BaseScript.ExtentReportingLevel.equalsIgnoreCase("Test")) {
	        if(extent.get()==null) {
	        //	extent.set(new ExtentReports(BaseScript.reportNameTest.get()));
	        	extent.set(BaseScript.report);
	        	//extent.set(ExtentManager.getInstance());
	        }
    	}
    	ExtentTest test = extent.get().createTest(testName, desc);
    	test.assignCategory(BaseScript.gadGetName.get());
        //extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        testObject.set(test);
        return test;
    }
}