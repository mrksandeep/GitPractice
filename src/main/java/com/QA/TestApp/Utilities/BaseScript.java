package com.QA.TestApp.Utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
//import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.zeroturnaround.zip.ZipUtil;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.aventstack.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentReports;=========================================================
//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ssts.pcloudy.Connector;
import com.ssts.pcloudy.Version;
import com.ssts.pcloudy.dto.device.MobileDevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseScript extends PageInitiation{
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	public static FileInputStream file;
	public static String strScenarioName;
	public static String strTestSetName;
	public static String strTestcaseName;
	public static String strGadgetName;
	public static String strEnvironment;
	public static String strUserID;
	public static String strParallelFlag;
	public static String strServiceManager;
	public static String strPWD;
	public static String decryptedPassword; 
	public static String strTCDesc;
	public static String intTCIteration;
	public static double intIteration;
	//public static WebDriver Driver;
	public static ThreadLocal<AppiumDriver<MobileElement>> appiumDriver = new ThreadLocal<>();
	public static AndroidDriver<WebElement> andriodDriver = null;
	public static ThreadLocal<BrowserFactory> browserFactory = new ThreadLocal<>();
	public static int intIterationNum;
	public static ThreadLocal<Integer> iterationValue = new ThreadLocal<>();
	public static double iterationTotalCount;
	public static ThreadLocal<String> scenarioName = new ThreadLocal<>();
	public static ThreadLocal<String> testSetName = new ThreadLocal<>();
	public static ThreadLocal<String> gadGetName = new ThreadLocal<>();
	public static int testcaseCountPerSet=0;
	public static String Browser;
	public static String URL;	
	public static FrameWorkUtility fUtil=new FrameWorkUtility();
	public static Log logger=new Log();
	public static GeneralFunctions gmethods=new GeneralFunctions();
	public static List<String> testCaseNames=new ArrayList<String>();
	public static List<String> moduleNames=new ArrayList<String>();
	public static List<String> environmentNames=new ArrayList<String>();
	public static ThreadLocal<Connector> con = new ThreadLocal<>();
	public static String oSystem=System.getProperty("os.name").trim();
	public static String platform;
	public static String testStartTime="";
	public static String testEndTime="";
	public static Logger log = Logger.getLogger("MyLog");  
	public static FileHandler fh; 
	
	//public SearchPollicyNo SearchPollicyNoBancs;
	//public static String xx;
	public static ThreadLocal<String> encodedBase64 = new ThreadLocal<>();
	public static ThreadLocal<String> ResultLocation = new ThreadLocal<String>()
	{
		@Override public String initialValue() {
			String reportPath=System.getProperty("user.dir")+File.separator+"ExecutionReports";
			return reportPath;			
		}
	};
	//public static String ResultLocation="C:\\Results\\Test"; 
	public static String businessReportingFlag= null;
	public static String ExtentReportingLevel=null;

	public static Map<String, String> scenarioGadgetMap;
	public static Map<String, Integer> scenarioIterationMap;	
	public static Map<String, String> scenarioBrowserMap;
	public static Map<String, String> scenarioURLMap;
	public static Map<String, String> scenarioLOBMap;
	public static Map<String, String> scenarioAppMap;
	public static Map<String, String> scenarioModuleMap;
	public static Map<String, String> scenarioChannelMap;

	public static ThreadLocal<FileInputStream> TestDataFile = new ThreadLocal<>();
	public static String Data = null;
	public static ThreadLocal<HSSFWorkbook> workbookData = new ThreadLocal<>();
	public static ThreadLocal<HSSFSheet> worksheet = new ThreadLocal<>();


	public static String reportName;
	public static ThreadLocal<String> reportNameTest=new ThreadLocal<>();
	public static String pdfReportName;
	public static String businessReportName;
	public int a;
	public static String cancellationTestCaseName;

	public static String channelName=null;
	public static String channel;
	//Reporting Extent Variables
	public static ExtentHtmlReporter reporterHtml;
	public static ExtentReports report;
	public static String isPDFReporting=null; 
	public static FileOutputStream fos;
	public static Document doc;
	//public static String channel=null;
	//public AppiumDriverLocalService appiumService;	

	public static String getReportNameTestNG()
	{
		fUtil.fCreateFolder(ResultLocation.get()+File.separator+"Suite_Execution_Report"+gmethods.current_timestamp());
		fUtil.fCreateFolder (ResultLocation.get()+File.separator+"Suite_Execution_Report"+File.separator+"Images1");
		System.out.println(testSetName.get());
		
		//fUtil.fCreateFolder(ResultLocation.get());
		//fUtil.fCreateFolder (ResultLocation.get()+File.separator+"Images1");
		String reportName1=ResultLocation.get()+File.separator+"Suite_Execution_Report"+File.separator+"ExecutionReport_"+fUtil.fGetRandomNumUsingTime()+".html";
		return reportName1;	
	}

	public static String getPDFReportNameTestNG()
	{
		fUtil.fCreateFolder(ResultLocation.get());
		fUtil.fCreateFolder (ResultLocation.get()+File.separator+"Images1");
		String reportName2=ResultLocation.get()+File.separator+"ExecutionReport"+fUtil.fGetRandomNumUsingTime()+".pdf";
		return reportName2;

	}

	public static String getBusinessReportNameTestNG()
	{
		fUtil.fCreateFolder(ResultLocation.get());
		fUtil.fCreateFolder (ResultLocation.get()+File.separator+"Images1");
		String reportName1=ResultLocation.get()+File.separator+"ExecutionReport"+fUtil.fGetRandomNumUsingTime()+".xls";
		return reportName1;
	}
	//Added by Akash-Kill process logic
	public static void taskKill(String processName) throws Exception
	{
		Process listTasksProcess = Runtime.getRuntime().exec("tasklist");
		BufferedReader tasksListReader = new BufferedReader(
				new InputStreamReader(listTasksProcess.getInputStream()));

		String tasksLine;

		while ((tasksLine = tasksListReader.readLine()) != null)
		{
			if (tasksLine.contains(processName))
			{
				Runtime.getRuntime().exec("taskkill /F /IM " + processName);
				break;
			}
		}
	}
	//@SuppressWarnings("unused")
	private String encodeFileToBase64Binary(String fileName) throws IOException {

		File file = new File(fileName);
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.encodeBase64(bytes);
		encodedBase64.set(new String(encoded));
		return encodedBase64.get();
	}

	@SuppressWarnings("resource")
	private static byte[] loadFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}
		byte[] bytes = new byte[(int)length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "+file.getName());
		}

		is.close();
		return bytes;
	}
	public static String getDateTime() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    System.out.println(timestamp);
	   return testStartTime=timestamp.toString();
	}

	public static void main(String[] args) throws IOException {
		
		testStartTime=getDateTime();
	    
		String logger1 = fUtil.readInput("Logger");
		if(logger1.equalsIgnoreCase("Yes")) {
			/*Added new code to create logs-- Starts*/
			fh = new FileHandler("logfile.log");  
			log.addHandler(fh);
			log.setUseParentHandlers(false);

	       // SimpleFormatter formatter = new SimpleFormatter();  
	       // fh.setFormatter(formatter);  
	        fh.setFormatter(new SimpleFormatter() {
	            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

	            @Override
	            public synchronized String format(LogRecord lr) {
	                return String.format(format,
	                        new Date(lr.getMillis()),
	                        lr.getLevel().getLocalizedName(),
	                        lr.getMessage()
	                );
	            }
	        });
	       // log.info("test");
	        /*Added new code to create logs -- Ends*/
			//DOMConfigurator.configure("log4j.xml");
		}		
		businessReportingFlag=fUtil.readInput("BusinessReportingFlag");
		ExtentReportingLevel=fUtil.readInput("ExtentReportingLevel");
		isPDFReporting=fUtil.readInput("PDFReporting");

		scenarioGadgetMap = new HashMap<String, String>();
		scenarioIterationMap=new HashMap<String, Integer>();
		scenarioBrowserMap=new HashMap<String, String>();
		scenarioURLMap=new HashMap<String, String>();


		scenarioLOBMap=new HashMap<String, String>();
		scenarioAppMap=new HashMap<String, String>();
		scenarioModuleMap=new HashMap<String, String>();
		scenarioChannelMap=new HashMap<String, String>();

		ArrayList<String> listeners = new ArrayList<String>();
		listeners.add("com.QA.TestApp.Utilities.PriorityInterceptor");
		//BaseScript bs=new BaseScript();


		XmlSuite xmlSuite=new XmlSuite();
		xmlSuite.setName("Suite1");
		xmlSuite.setListeners(listeners);
		String parallelFlag = fUtil.readInput("Parallel");
		String threadCount = fUtil.readInput("Threadcount");
		if(parallelFlag.equalsIgnoreCase("true")) {
			xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
			xmlSuite.setThreadCount(Integer.parseInt(threadCount));
		}
		xmlSuite.setVerbose(1);

		List<String> TCNames=new ArrayList<String>();
		try
		{

			file= new FileInputStream(new File(fUtil.readInput("TestPlan")));
			workbook = new HSSFWorkbook(file);		  		  
			sheet = workbook.getSheet("ExecuteScript");
			int intRowNum = sheet.getPhysicalNumberOfRows();
			int executableTCCount=0;
			for(int i =1;i<intRowNum;i++){
				HSSFRow Exlrow = sheet.getRow(i);
				String flag = Exlrow.getCell(8).getStringCellValue();			  
				if (Exlrow.getCell(9) != null) {
					intIteration = Exlrow.getCell(9).getNumericCellValue();

				}				  
				if(flag.equals("Y"))
				{

					/*String test=sheet.getRow(i+1).getCell(6).getStringCellValue();
					  i++;
					  String test1=sheet.getRow(i+1).getCell(6).getStringCellValue();
					  System.out.println(test1);
					  if(test.equals(""))
					  {
						  System.out.println("aaaa");
					  }*/
					testCaseNames.clear();
					moduleNames.clear();
					environmentNames.clear();
					for(int iterator=1;iterator<=intIteration;iterator++)
					{
						testcaseCountPerSet=0;
						String strtestSetName = Exlrow.getCell(1).getStringCellValue();
						String testCaseName=Exlrow.getCell(3).getStringCellValue();

						// cancellationTestCaseName = Exlrow.getCell(3).getStringCellValue();
						channelName = Exlrow.getCell(4).getStringCellValue();
						String application = Exlrow.getCell(5).getStringCellValue();
						String envName = Exlrow.getCell(6).getStringCellValue();
						String moduleName = Exlrow.getCell(7).getStringCellValue();
						String applicationName = Exlrow.getCell(10).getStringCellValue();
						String LOBName = Exlrow.getCell(11).getStringCellValue();
						String moduleTestName = Exlrow.getCell(12).getStringCellValue();
						scenarioAppMap.put(strtestSetName, applicationName);
						scenarioLOBMap.put(strtestSetName, LOBName);
						scenarioModuleMap.put(strtestSetName, moduleTestName);
						scenarioChannelMap.put(testCaseName, channelName);

						testCaseNames.add(testCaseName);
						moduleNames.add(moduleName);
						environmentNames.add(envName);

						int y=i;
						while(y<intRowNum-1 && sheet.getRow(y+1).getCell(8).getStringCellValue().equals("")){
							testcaseCountPerSet=testcaseCountPerSet+1;
							String testCase=(sheet.getRow(y+1)).getCell(3).getStringCellValue();
							String module=(sheet.getRow(y+1)).getCell(7).getStringCellValue();
							String env=(sheet.getRow(y+1)).getCell(6).getStringCellValue();
							testCaseNames.add(testCase);
							moduleNames.add(module);
							environmentNames.add(env);
							//Added by Akash- For multi data set TestSet run
							scenarioChannelMap.put(testCase, channelName);
							System.out.println(testcaseCountPerSet);
							y++;
						}
						/*if(sheet.getRow(i+1).getCell(6).getStringCellValue().equals(""))
						  {

						  }*/
						for(int iTest=0;iTest<=testcaseCountPerSet;iTest++) {
							executableTCCount=executableTCCount+1;
							strScenarioName = testCaseNames.get(iTest);
							strTestSetName = Exlrow.getCell(1).getStringCellValue();
							strGadgetName = moduleNames.get(iTest);
							strEnvironment = environmentNames.get(iTest);
							strTCDesc = Exlrow.getCell(2).getStringCellValue(); 	
							String strScenarioNameIteration=strTestSetName+"_TS_"+strScenarioName+"Dataset"+iterator;
							TCNames.add(strScenarioNameIteration);
							scenarioIterationMap.put(strScenarioNameIteration, iterator);
							scenarioGadgetMap.put(strScenarioName,strGadgetName);
							Browser=envName;
							scenarioBrowserMap.put(strScenarioName, Browser);
							XmlTest xmlTest=new XmlTest(xmlSuite);
							xmlTest.setName(TCNames.get(executableTCCount-1));
							XmlClass test1Class=null;
							if(channelName.equalsIgnoreCase("Web")) {
								test1Class=new XmlClass(Class.forName("com.QA.TestApp.Testcases."+"WEB"+"."+strGadgetName));
								List<XmlClass> listClass=new ArrayList<XmlClass>();
								listClass.add(test1Class);
								xmlTest.setXmlClasses(listClass);
								System.out.println(strtestSetName);
								ArrayList<String> Keywords = fUtil.fGetKeywords(fUtil.readInput("ScenarioWeb")+strtestSetName+".xls","Sheet1",strScenarioName);

								ArrayList<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();
								for (int KCount = 0; KCount < Keywords.size(); KCount++) { 		       
									methodsToRun.add(new XmlInclude(Keywords.get(KCount)));
								} 
								listClass.get(0).setIncludedMethods(methodsToRun);
							}else if(channelName.equalsIgnoreCase("API")){
								test1Class=new XmlClass(Class.forName("com.QA.TestApp.Testcases."+"API"+"."+strGadgetName));
								List<XmlClass> listClass=new ArrayList<XmlClass>();
								listClass.add(test1Class);
								xmlTest.setXmlClasses(listClass);
								//ArrayList<String> Keywords = fUtil.fGetKeywords(fUtil.readInput("Scenario"),strGadgetName,strScenarioName);
								ArrayList<String> Keywords = fUtil.fGetKeywords(fUtil.readInput("ScenarioAPI")+strtestSetName+".xls","Sheet1",strScenarioName);

								ArrayList<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();
								for (int KCount = 0; KCount < Keywords.size(); KCount++) { 		       
									methodsToRun.add(new XmlInclude(Keywords.get(KCount)));
								} 
								listClass.get(0).setIncludedMethods(methodsToRun);
							}else if(channelName.equalsIgnoreCase("Mobile")){
								test1Class=new XmlClass(Class.forName("com.QA.TestApp.Testcases."+"MOBILE"+"."+strGadgetName));
								List<XmlClass> listClass=new ArrayList<XmlClass>();
								listClass.add(test1Class);
								xmlTest.setXmlClasses(listClass);
								//ArrayList<String> Keywords = fUtil.fGetKeywords(fUtil.readInput("Scenario"),strGadgetName,strScenarioName);
								ArrayList<String> Keywords = fUtil.fGetKeywords(fUtil.readInput("ScenarioMobile")+strtestSetName+".xls","Sheet1",strScenarioName);

								ArrayList<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();
								for (int KCount = 0; KCount < Keywords.size(); KCount++) { 		       
									methodsToRun.add(new XmlInclude(Keywords.get(KCount)));
								} 
								listClass.get(0).setIncludedMethods(methodsToRun);
							}

						}
					}
					// report.endTest(test);
					// report.flush();
				}
			}

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception eew)
		{
			eew.printStackTrace();
		}

		TestNG testNG=new TestNG();

		List<XmlSuite> listSuite=new ArrayList<XmlSuite>();
		listSuite.add(xmlSuite);
		testNG.setXmlSuites(listSuite);
		System.out.println (listSuite.get(0).toXml());
		testNG.run();

	}

	@BeforeSuite
	public void reportingSetup() throws IOException, DocumentException
	{

		//System.out.println("Before Suite");	
		//ResultLocation = "C:\\Result";
		// fUtil.fCreateFolder(ResultLocation);
		// fUtil.fCreateFolder (ResultLocation+"\\Images");
		// xx=ResultLocation+"\\ExecutionReport"+fUtil.fGetRandomNumUsingTime()+".html";
		//report = new ExtentReports(xx, true); //,DisplayOrder.NEWEST_FIRST
		if(ExtentReportingLevel.equalsIgnoreCase("Suite")) {
			
			reportName= getReportNameTestNG();
			if (report == null) {
				System.out.println("Inside report manager Suite");
				reporterHtml=new ExtentHtmlReporter(reportName);
				report=new ExtentReports();
				report.attachReporter(reporterHtml);

			}
			if(isPDFReporting.equalsIgnoreCase("Yes")) {
				pdfReportName=getPDFReportNameTestNG();
				fos = new FileOutputStream(pdfReportName);
				doc = new Document();
				PdfWriter.getInstance(doc, fos);
				doc.open();
				doc.addTitle("TestCase");
			}
		}
		if(businessReportingFlag.equalsIgnoreCase("Yes")) {
			businessReportName=getBusinessReportNameTestNG();
			fUtil.fCopyReportFile(fUtil.readInput("Report"), businessReportName);
			try {
				File file = File.createTempFile("realhowDelete",".vbs");
				file.deleteOnExit();
				FileWriter fw = new java.io.FileWriter(file);

				String vbs = "Set objExcel = CreateObject(\"Excel.Application\") \n"
						+ "Set objWB = objExcel.Workbooks.Open(\""+businessReportName+"\") \n" 
						+ "objExcel.Visible = True \n"
						+ "\n"
						+ "Set ws = objWB.Sheets(1) \n"
						+ "ws.Rows(\"2:1000\").EntireRow.Delete \n"
						+ "objWB.Save \n"
						+ "objWB.Close True \n"
						+ "objExcel.Quit \n";
				//+ "msgbox \"End Of Suite Execution";
				fw.write(vbs);
				fw.close();
				Runtime.getRuntime().exec("wscript " + file.getPath());
			}
			catch( IOException e ) {
				System.out.println(e);
				System.exit(0);
			}


		}
	}


	@AfterSuite
	public void reportingEnd() throws Exception
	{
		//report.flush();
		//System.out.println("In After Suite");
		//if(ExtentReportingLevel.equalsIgnoreCase("Suite")) {
		//ExtentReports ex=ExtentManager.getInstance();
		//ex.flush();
		//ExtentTestManager.extent.get().flush();
		//}
		if(isPDFReporting.equalsIgnoreCase("Yes")) {
			if(doc.isOpen()) {
				doc.close();
			}
		}
		if(businessReportingFlag.equalsIgnoreCase("Yes")) {
			try {
				File file = File.createTempFile("realhowto",".vbs");
				file.deleteOnExit();
				FileWriter fw = new java.io.FileWriter(file);

				String vbs = "Set objExcel = CreateObject(\"Excel.Application\") \n"
						+ "Set objWB = objExcel.Workbooks.Open(\""+businessReportName+"\") \n" 
						+ "objExcel.Visible = True \n"
						+ "\n"
						+ "for each ws in objwb.worksheets \n"
						+ "     for each pt in ws.pivottables \n"
						+ "     pt.refreshtable \n"
						+ "     next \n"
						+ "next \n"
						+ "objWB.Close True \n"
						+ "objExcel.Quit \n";
				//+ "msgbox \"End Of Suite Execution";

				fw.write(vbs);
				fw.close();
				Runtime.getRuntime().exec("wscript " + file.getPath());

			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		//Added by- Case for proper driver close
		try {
			
			//FileUtils.deleteDirectory(new File(ResultLocation.get()+File.separator+"Suite_Execution_Report"+".zip"));
		//			File sourceFile=new File(ResultLocation.get()+File.separator+"Suite_Execution_Report"+".zip");
//			File destFile=new File( "C:"+File.separator+"ExecutionReports"+File.separator+"Suite_Execution_Report"+".zip");


			log.info("\n\n*****************************************************************"
					+ "\n**********************EXECUTION SUMMARY**************************"
					+ "\n*****************************************************************"
					+ "\n\n>>> TotalTestCasesExecuted=" + gmethods.totalTestCaseExecuted
					+ "\n>>> TotalPassedTestCases=" + gmethods.totalPassedTestCase
					+ "\n>>> TotalFailedTestCases=" + gmethods.totalFailedTestCase
					+ "\n>>> PassPercentage=" + gmethods.passPercentage + "%"
					+ "\n\n*****************************************************************");
			System.out.println("\n\n*****************************************************************"
					+ "\n**********************EXECUTION SUMMARY**************************"
					+ "\n*****************************************************************"
					+ "\n\n>>> TotalTestCasesExecuted=" + gmethods.totalTestCaseExecuted
					+ "\n>>> TotalPassedTestCases=" + gmethods.totalPassedTestCase
					+ "\n>>> TotalFailedTestCases=" + gmethods.totalFailedTestCase
					+ "\n>>> PassPercentage=" + gmethods.passPercentage + "%"
					+ "\n\n*****************************************************************");
			
			System.out.println("TestCase Name                            Result      Run Duration\n");
			System.out.println("--------------------------------------------------------------------\n");

			 if(!gmethods.testCaseNameWithResult.isEmpty()) {
		         Iterator it = gmethods.testCaseNameWithResult.entrySet().iterator();
		         while(it.hasNext()) {
		            Map.Entry obj = (Entry)it.next();
		            System.out.println(obj.getKey()+"                              "+obj.getValue());
		         }
		      }
			
			switch(channel) {
			case "Web":
				browserFactory.get().getDriver().quit();
				//BrowserFactory.webDriver.get().quit();
//				if(platform.equalsIgnoreCase("pwa mobile"))	
//					browserFactory.get().getDriver().quit();
				break;
			case "Mobile":
				gmethods.stopAppiumServer();
				appiumDriver.get().quit();
				break;

			}
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			//	MyScreenRecorder.stopRecording();
			
			fh.close();
			
			fUtil.copyfile(System.getProperty("user.dir")+File.separator+"logfile.log",ResultLocation.get()+File.separator+"Suite_Execution_Report"+File.separator+"logfile.log");

			File f= new File(ResultLocation.get()+File.separator+"Suite_Execution_Report"+".zip");           //file to be delete  
			if(f.delete())  {
			}

			ZipUtil.pack(new File(ResultLocation.get()+File.separator+"Suite_Execution_Report"), new File(ResultLocation.get()+File.separator+"Suite_Execution_Report"+".zip"));
			FileUtils.deleteDirectory(new File(ResultLocation.get()+File.separator+"Suite_Execution_Report"));

			if(!oSystem.toLowerCase().contains("mac")) {
				File directory = new File("C:\\ExecutionReports");
				if (! directory.exists()){
					directory.mkdir();
					// If you require it to make the entire directory path including parents,
					// use directory.mkdirs(); here instead.
				}
			}

			fUtil.copyfile(ResultLocation.get()+File.separator+"Suite_Execution_Report"+".zip","C:\\ExecutionReports"+File.separator+"Suite_Execution_Report-"+(Timestamp.from(Instant.now()).toString().replace(" ","_").replace(".", "-").replace(":", "-"))+".zip");

		//	gmethods.deleteFilesOlderThanNdays("C:\\ExecutionReports");
			
			taskKill("chromedriver.exe");
			taskKill("geckodriver.exe");
			taskKill("operadriver.exe");
			taskKill("msedgedriver.exe");

			//			if(fUtil.readInput("Threadcount").equals("1")) {
			//				taskKill("chrome.exe");
			//				taskKill("firefox.exe");
			//				taskKill("MicrosoftEdge.exe");
			//				taskKill("opera.exe");
			//			}

			//	gmethods.getTestCounts();

		}


		/*		String port=fUtil.fgetDataNew1("port");
		int port1=Integer.parseInt(port);
		try {
			System.out.println("checking existing server instance");
			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port1);
				serverSocket.close();
			} catch (IOException e) {
				//If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}

			if(!(isServerRunning)){
				System.out.println("starting server");
				File dir = new File(".\\");
				ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "Start","AppiumServerStop.bat");
				//  ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C","node appium -a 127.0.0.1 -p 4722");
				// pb.directory(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules"));
				Process p = pb.start();
				Thread.sleep(15000);
				try {
					serverSocket = new ServerSocket(port1);
					serverSocket.close();
				} catch (IOException e) {
					//If control comes here, then it means that the port is in use
					isServerRunning = true;

				}

			}
		} catch (IOException e) {
			e.printStackTrace();

		}  */
	}

	@BeforeTest
	public void setup(ITestContext testContext) throws Exception
	{
		testStartTime=getDateTime();
		try
		{


			String scenarioNameTest=testContext.getName();
			System.out.println(scenarioNameTest);
			String[] strArray=scenarioNameTest.split("Dataset");
			String strArrayData="Dataset"+strArray[1];
			String[] sceArray=strArray[0].split("_TS_");
			testSetName.set(sceArray[0]);		

			//Scenario name is my test case name
			scenarioName.set(sceArray[1]);
			logger.startTestCase(testSetName.get()+"-"+scenarioName.get());

			if(ExtentReportingLevel.equalsIgnoreCase("Test")) {
				//reportName= getReportNameTestNG();
				fUtil.fCreateFolder(ResultLocation.get()+File.separator+testSetName.get()+"_"+scenarioName.get());
				fUtil.fCreateFolder (ResultLocation.get()+File.separator+testSetName.get()+"_"+scenarioName.get()+File.separator+"Images1");
				System.out.println(testSetName.get());
				reportNameTest.set(ResultLocation.get()+File.separator+testSetName.get()+"_"+scenarioName.get()+File.separator+"ExecutionReport_"+testSetName.get()+"-"+scenarioName.get()+"-"+strArrayData+fUtil.fGetRandomNumUsingTime()+".html");
				String reportName=reportNameTest.get();
				System.out.println(reportNameTest.get());
				
					System.out.println("Inside report manager Suite");
					reporterHtml=new ExtentHtmlReporter(reportName);
					report=new ExtentReports();
					report.attachReporter(reporterHtml);

				
			}
			iterationTotalCount=intIteration;
			gadGetName.set(scenarioGadgetMap.get(scenarioName.get()));
			iterationValue.set(scenarioIterationMap.get(scenarioNameTest));
			
			if(testSetName.get().equals(scenarioName.get())){
				ExtentTestManager.startTest(scenarioName.get()+strArrayData);
			}
			else{
				//ExtentTestManager.startTest(testSetName.get()+"-"+scenarioName.get());
				ExtentTestManager.startTest(testSetName.get()+"-"+scenarioName.get()+"-"+strArrayData);
			}
			channel=scenarioChannelMap.get(scenarioName.get());
			switch(channel){
			case "Web":
				String brwsr=scenarioBrowserMap.get(scenarioName.get());
				platform = brwsr;
				browserFactory.set(BrowserFactory.getInstance());
				//browserFactory.get().setDriver(brwsr);
				//initialisePageObjects(browserFactory.get());
				//fUtil.setLocalDriver(browserFactory.get().getDriver());
				TestDataFile.set(new FileInputStream(new File(fUtil.readInput("DataWeb")+testSetName.get()+".xls")));
				workbookData.set(new HSSFWorkbook(TestDataFile.get()));
				worksheet.set(workbookData.get().getSheet("Sheet1"));
				browserFactory.get().setDriver(brwsr);
				initialisePageObjects(browserFactory.get());
				fUtil.setLocalDriver(browserFactory.get().getDriver());
				String url=fUtil.fgetDataNew1("URL");
				//MyScreenRecorder.startRecording();
				browserFactory.get().getDriver().get(url);
				fUtil.flogResult("Passed", "Script Execution Environment", "The Script is being tested on : "+url, 0);

				break;
			case "API":
				TestDataFile.set(new FileInputStream(new File(fUtil.readInput("DataAPI")+testSetName.get()+".xls")));
				workbookData.set(new HSSFWorkbook(TestDataFile.get()));
				worksheet.set(workbookData.get().getSheet("Sheet1"));
				String ss=fUtil.readInput("DataAPI")+testSetName.get()+".xls";
				System.out.println(ss);
				break;
			case "Mobile":
				TestDataFile.set(new FileInputStream(new File(fUtil.readInput("DataMobile")+testSetName.get()+".xls")));
				workbookData.set(new HSSFWorkbook(TestDataFile.get()));
				worksheet.set(workbookData.get().getSheet("Sheet1"));
				String sOS=scenarioBrowserMap.get(scenarioName.get());
				platform=sOS;
				/*				String port=fUtil.fgetDataNew1("port");
				int port1=Integer.parseInt(port);
				try {
					System.out.println("checking existing server instance");
					boolean isServerRunning = false;
					ServerSocket serverSocket;
					try {
						serverSocket = new ServerSocket(port1);
						serverSocket.close();
					} catch (IOException e) {
						//If control comes here, then it means that the port is in use
						isServerRunning = true;
					} finally {
						serverSocket = null;
					}

					if(!(isServerRunning)){
						System.out.println("starting server");
						File dir = new File(".\\");
						ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "Start","AppiumServerStart.bat");
						Process p = pb.start();
						Thread.sleep(15000);
						try {
							serverSocket = new ServerSocket(port1);
							serverSocket.close();
						} catch (IOException e) {
							//If control comes here, then it means that the port is in use
							isServerRunning = true;

						}

					}
				} catch (IOException e) {
					e.printStackTrace();

				}  

				String deviceName=fUtil.fgetDataNew1("DeviceName");
				String udid=fUtil.fgetDataNew1("udid");
				String platformName=fUtil.fgetDataNew1("PlatformName");
				String platformVersion=fUtil.fgetDataNew1("PlatformVersion");
				String appPackage=fUtil.fgetDataNew1("AppPackage");
				String appActivity=fUtil.fgetDataNew1("AppActivity");
				String urlAppium=fUtil.fgetDataNew1("UrlAppium");	 
				DesiredCapabilities cap= new DesiredCapabilities();
				cap.setCapability("deviceName", "OnePlus 7 Pro");//device name is the phone model number(Setting-> About phone)
				cap.setCapability("udid", "567231cd");//in cmd enter command "adb devices" to find the udid number of your device
				cap.setCapability("platformName", "Android");//in case it is a andriod device
				cap.setCapability("platformVersion", "10.0.0");//setting->About phone-> Android version
				cap.setCapability("appPackage", "com.oneplus.calculator");//install apk info in your mobile device and you can get the apk information
				cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");//from apk info you can get this
				URL url1= new URL("http://127.0.0.1:4723/wd/hub");//default URL of the appium server
				appiumDriver= new AppiumDriver<MobileElement>(url1, cap);*/

				if(fUtil.readInput("ConnectRealDevice").equalsIgnoreCase("yes") && fUtil.readInput("ConnectAnyDeviceInPcloudy").equalsIgnoreCase("no"))
				{
					connectRealDevice(sOS);
					//connectRealAndroidDevice();
					break;
				}
				else if(fUtil.readInput("ConnectAnyDeviceInPcloudy").equalsIgnoreCase("yes") && fUtil.readInput("ConnectRealDevice").equalsIgnoreCase("no"))
				{
					connectAnyAvailableDeviceInPcloudy(sOS);
					break;
				}else if(fUtil.readInput("ConnectAnyDeviceInPcloudy").equalsIgnoreCase("no") && fUtil.readInput("ConnectRealDevice").equalsIgnoreCase("no")) {
					connectSpecificDeviceInPcloudy(sOS);
					break;
				}else {
					System.out.println("\n\n**** NO PROPER SETTINGS IN CONFIG FILE ****");
					System.out.println("**** PLEASE SET THE PROPERTIES PROPERLY **** \n\n");
					break;
				}

			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
			System.out.println(E.getMessage());
			fUtil.flogResult("Failed", "Error Received for Session Creation", "Error Message-"+E.getMessage(), 1);
			throw E;
		}
		finally {
			if((fUtil.readInput("TestPlan").contains("RegressionSuite") && !scenarioName.get().contains("UpdateJiraStatusToDo"))
					|| fUtil.readInput("TestPlan").contains("TcpApiSuite"))
			{
				//gmethods.updateTestCaseStatusInJira("EXECUTING");
			}
		}
	}

	public void connectSpecificDeviceInPcloudy(String sOS) throws Exception{
		String[] deviceList = null;
		String[] platformVersionArray = null;
		try {
			String deviceListCombinedArray = fUtil.fgetDataNew1("pCloudy_DeviceFullName");
			deviceList = deviceListCombinedArray.split(",");
			String platformVersionCombined = fUtil.fgetDataNew1("platformVersion");
			platformVersionArray = platformVersionCombined.split(",");
			logger.info("Connecting via Device full name");
		}
		catch(Exception e) {
			logger.error("Connecting via Device manufacturer");
		}
		int i = 0;
		for (String device : deviceList) {
			try {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("pCloudy_Username", fUtil.fgetDataNew1("pCloudy_Username"));
				capabilities.setCapability("pCloudy_ApiKey", fUtil.fgetDataNew1("pCloudy_ApiKey"));
				capabilities.setCapability("pCloudy_DurationInMinutes", 10);
				capabilities.setCapability("newCommandTimeout", 600);
				capabilities.setCapability("launchTimeout", 90000);
				capabilities.setCapability("adbExecTimeout", 90000);
				if(device.isEmpty() || device == "") {
					capabilities.setCapability("pCloudy_DeviceManafacturer", fUtil.fgetDataNew1("pCloudyDeviceManafacturer"));
				}
				else {
					capabilities.setCapability("pCloudy_DeviceFullName", device);
				}
				//	capabilities.setCapability("platformVersion", platformVersionArray[i]);
				//	capabilities.setCapability("pCloudy_DeviceVersion", platformVersionArray[i]);
				capabilities.setCapability("pCloudy_ApplicationName", fUtil.fgetDataNew1("ios_pCloudy_ApplicationName"));
				capabilities.setCapability("noReset", true);
				capabilities.setCapability("autoGrantPermissions", true);
				//check if env is ios or android and accordingly add capability
				if(sOS.equalsIgnoreCase("ios")) {
					capabilities.setCapability("platformName", "ios");
					capabilities.setCapability("automationName", "XCUITest");
					capabilities.setCapability("bundleId", fUtil.fgetDataNew1("ios_bundleId"));
					capabilities.setCapability("autoAcceptAlerts", true);
				}
				else {
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("automationName", "uiautomator2");
					capabilities.setCapability("appPackage", fUtil.fgetDataNew1("and_appPackage"));
					capabilities.setCapability("appActivity", fUtil.fgetDataNew1("and_appActivity"));						
				}
				appiumDriver.set(new AppiumDriver<MobileElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities));
				gmethods.launchApp();
				fUtil.flogResult("Passed", "Device Connection", "Device Connected : "+device+" :: Application detail : "+fUtil.fgetDataNew1("ios_pCloudy_ApplicationName"), 0);
				System.out.println("\n\n**** Device Connected Successfully **** \n\n");
				initialisePageObjects();
				break;
			}
			catch(Exception e) {
				try {
					appiumDriver.get().quit();
				}
				catch(Exception e1) {

				}
				i++;
				if(i<=deviceList.length-1) {
					continue;
				}
				else {
					throw e;
				}

			}
		}
	}


	public void connectAnyAvailableDeviceInPcloudy(String sOS) throws Exception{
		List<MobileDevice> deviceName = null;
		con.set(new Connector("https://device.pcloudy.com/api/"));
		String authToken = con.get().authenticateUser(fUtil.fgetDataNew1("pCloudy_Username"), fUtil.fgetDataNew1("pCloudy_ApiKey"));
		if(sOS.equalsIgnoreCase("ios")) {
			while(true) {
				deviceName = con.get().chooseDevices(authToken, "iOS", new Version("12.*.*"), new Version("14.*.*"), 1);

				String connectedDevice = deviceName.get(0).full_name;
				if(!connectedDevice.toLowerCase().contains("ipad")) {
					break;
				}
			}
		}
		else {
			while(true) {
				deviceName = con.get().chooseDevices(authToken, "android", new Version("9.*.*"), new Version("10.*.*"), 1);
				String connectedDevice = deviceName.get(0).full_name;
				if(!connectedDevice.toLowerCase().contains("tab") && !connectedDevice.toLowerCase().contains("Xiaomi")) {
					break;
				}
			}
		}
		String device = deviceName.get(0).full_name;
		String platformVersion = deviceName.get(0).version;
		try {
			appiumDriver.set(new AppiumDriver<MobileElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), deviceConnection(device, platformVersion, sOS)));

			gmethods.launchApp();

			fUtil.flogResult("Passed", "pCloudy Device Connection", "Device Connected : "+device+" :: Application detail : "+fUtil.fgetDataNew1("ios_pCloudy_ApplicationName"), 0);
			System.out.println("\n\n**** Device Connected : "+device+" **** \n\n");

			initialisePageObjects();
			//break;
		}
		catch(Exception e) {
			try {
				//appiumDriver.get().quit();
			}catch(Exception e1) {
				System.out.println("\n\n Unable to Connect to Device in pCloudy : "+e1.getMessage());
				System.out.println("\n\n Trying Again to connect ...\n\n");

			}
			try {
				con.set(new Connector("https://device.pcloudy.com/api/"));

				//	appiumDriver.get().quit();
				List<MobileDevice> deviceNameCatch = null;
				if(sOS.equalsIgnoreCase("ios")) {
					while(true) {
						deviceNameCatch = con.get().chooseDevices(authToken, "iOS", new Version("12.*.*"), new Version("14.*.*"), 1);

						String connectedDevice = deviceNameCatch.get(0).full_name;
						if(!connectedDevice.toLowerCase().contains("ipad")) {
							break;
						}
					}
					//	deviceNameCatch = con.get().chooseDevices(authToken, "iOS", new Version("12.*.*"), new Version("14.*.*"), 1);
				}
				else {
					while(true) {
						deviceNameCatch = con.get().chooseDevices(authToken, "android", new Version("9.*.*"), new Version("10.*.*"), 1);
						String connectedDevice = deviceNameCatch.get(0).full_name;
						if(!connectedDevice.toLowerCase().contains("tab")) {
							break;
						}
					}
				}
				String deviceCatch = deviceNameCatch.get(0).full_name;
				String platformVersionCatch = deviceNameCatch.get(0).version;
				System.out.println(deviceCatch);
				System.out.println(platformVersionCatch);

				appiumDriver.set(new AppiumDriver<MobileElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), deviceConnection(deviceCatch, platformVersionCatch, sOS)));

				gmethods.launchApp();

				fUtil.flogResult("Passed", "Device Connection", "Device Connected : "+device+" :: Application detail : "+fUtil.fgetDataNew1("ios_pCloudy_ApplicationName"), 0);
				System.out.println("\n\n**** Device Connected : "+device+" **** \n\n");
				initialisePageObjects();
				//break;

			}
			catch(Exception e1) {
				System.out.println("\n\n Failed to Connect to Device in pCloudy in Second try also : "+e1.getMessage());
			}
			throw e;
		}

	}

	public static Capabilities deviceConnection(String device, String platformVersion, String sOS) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("pCloudy_Username", fUtil.fgetDataNew1("pCloudy_Username"));
		capabilities.setCapability("pCloudy_ApiKey", fUtil.fgetDataNew1("pCloudy_ApiKey"));
		capabilities.setCapability("pCloudy_DurationInMinutes", 10);
		capabilities.setCapability("pCloudy_EnableVideo", true);
		capabilities.setCapability("pCloudy_EnablePerformanceData", true);
		capabilities.setCapability("pCloudy_EnableDeviceLogs", true);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("adbExecTimeout", 90000);
		if(device.isEmpty() || device == "") {
			capabilities.setCapability("pCloudyDeviceManafacturer", fUtil.fgetDataNew1("pCloudyDeviceManafacturer"));
		}
		else {
			capabilities.setCapability("pCloudy_DeviceFullName", device);
		}
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("pCloudy_DeviceVersion", platformVersion);
		capabilities.setCapability("pCloudy_ApplicationName", fUtil.fgetDataNew1("ios_pCloudy_ApplicationName"));
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("autoGrantPermissions", true);
		if(sOS.equalsIgnoreCase("ios")) {
			capabilities.setCapability("platformName", "ios");
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("bundleId", fUtil.fgetDataNew1("ios_bundleId"));
			capabilities.setCapability("autoAcceptAlerts", true);
		}
		else {
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("automationName", "uiautomator2");
			capabilities.setCapability("appPackage", fUtil.fgetDataNew1("and_appPackage"));
			capabilities.setCapability("appActivity", fUtil.fgetDataNew1("and_appActivity"));						
		}
		return capabilities;
	}

/*	public void connectRealAndroidDevice() throws Exception{
		try {
			String deviceName=fUtil.readInput("DeviceName");
			String udid=fUtil.readInput("DeviceUdid");
			String platformVersion=fUtil.readInput("DeviceAndroidVersion");
			String apkPath=fUtil.readInput("ApkPath");

			System.out.println(apkPath);
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setCapability("deviceName", deviceName);//device name is the phone model number(Setting-> About phone)
			cap.setCapability("udid", udid);//in cmd enter command "adb devices" to find the udid number of your device
			cap.setCapability("platformName", "Android");//in case it is a android device
			cap.setCapability("platformVersion", platformVersion);//setting->About phone-> Android version
			cap.setCapability("automationName", "uiautomator2");
			cap.setCapability("noReset", "true");
			cap.setCapability("fullReset", "false");
			cap.setCapability("appPackage", fUtil.fgetDataNew1("and_appPackage"));
			cap.setCapability("appActivity", fUtil.fgetDataNew1("and_appActivity"));	
			cap.setCapability(MobileCapabilityType.APP, apkPath);

			URL url1= new URL("http://127.0.0.1:4723/wd/hub");//default URL of the appium server

			appiumDriver.set(new AppiumDriver<MobileElement>(url1, cap));

			initialisePageObjects();

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
*/
	public void connectRealDevice(String platform) throws Exception{
		try {
			DesiredCapabilities cap= new DesiredCapabilities();
			
			cap.setCapability("noReset", fUtil.readInput("noReset"));
			cap.setCapability("fullReset", fUtil.readInput("fullReset"));
			
			switch (platform.toLowerCase()) {
			case "android":
				String deviceName=fUtil.readInput("AndroidDeviceName");
				String udid=fUtil.readInput("AndroidDeviceUdid");
				String platformVersion=fUtil.readInput("DeviceAndroidVersion");
				String apkPath=fUtil.readInput("ApkPath");

				cap.setCapability("newCommandTimeout", 600);
				cap.setCapability("adbExecTimeout", 90000);
				cap.setCapability("deviceName", deviceName);//device name is the phone model number(Setting-> About phone)
				cap.setCapability("udid", udid);//in cmd enter command "adb devices" to find the udid number of your device
				cap.setCapability("platformName", "Android");//in case it is a android device
				cap.setCapability("platformVersion", platformVersion);//setting->About phone-> Android version
				cap.setCapability("automationName", "uiautomator2");
				
				cap.setCapability("appPackage", fUtil.fgetDataNew1("and_appPackage"));
				cap.setCapability("appActivity", fUtil.fgetDataNew1("and_appActivity"));	
				cap.setCapability(MobileCapabilityType.APP, apkPath);

				break;
			case "ios":
				gmethods.startAppiumServer();
				String iOSDeviceName=fUtil.readInput("iOSDeviceName"); //"Anil's iPhone";
				String iOSUdid=fUtil.readInput("iOSDeviceUdid");//"9df922243eb22d498c9118b17fc898d50f15dd33";
				String iOSPlatformVersion=fUtil.readInput("iOSPlatformVersion");//"14.4";
				String ipaPath=fUtil.readInput("iOSiPaPath");//"/Users/anilkedia/Downloads/TCPApp-SIT.ipa";
				System.out.println(ipaPath);

				cap.setCapability("deviceName", iOSDeviceName);//device name is the phone model number(Setting-> About phone)
				cap.setCapability("udid", iOSUdid);
				cap.setCapability("platformName", "iOS");
				cap.setCapability("platformVersion", iOSPlatformVersion);//setting->About phone-> Software version
				cap.setCapability("automationName", "XCUITest");
				cap.setCapability("app", ipaPath);
				break;

			default:
				break;
			}

			URL url1= new URL("http://127.0.0.1:4723/wd/hub");//default URL of the appium server

			appiumDriver.set(new AppiumDriver<MobileElement>(url1, cap));

			initialisePageObjects();

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@AfterTest
	public void endTestReport(ITestContext testContext) throws Exception
	{
         testEndTime=getDateTime();
		//report.endTest(test);
		//System.out.println("In After Test");
		try {
			if(businessReportingFlag.equalsIgnoreCase("Yes")) {
				String scenarioNameTest=testContext.getName();
				String[] strArray=scenarioNameTest.split("Dataset");
				String[] sceArray=strArray[0].split("_TS_");
				testSetName.set(sceArray[0]);		
				scenarioName.set(sceArray[1]);
			//	String scenarioStatus=ExtentTestManager.getTest().getRunStatus().toString();
				String scenarioStatus=ExtentTestManager.getTest().getStatus().toString();
				System.out.println("status: "+scenarioStatus);


				//String businessReportpath=reportName

				fUtil.fWriteBusinessData(scenarioLOBMap.get(scenarioName.get()), scenarioAppMap.get(scenarioName.get()), scenarioModuleMap.get(scenarioName.get()), testSetName.get(), scenarioName.get(), scenarioStatus, businessReportName);
			}

			try{
				//ExtentTestManager.endTest();	
				TestDataFile.get().close(); 
				if(ExtentReportingLevel.equalsIgnoreCase("Test")) {
					//new ExtentReports(BaseScript.reportName, true).flush();
					//(new ExtentReports(BaseScript.reportName, true))=null;
					ExtentTestManager.extent.get().flush();
					ExtentTestManager.extent.remove();
					 testEndTime=getDateTime();
					/* byte[] buffer = new byte[1024];
			    ByteArrayOutputStream baos = new ByteArrayOutputStream();
			    try (ZipOutputStream zos = new ZipOutputStream(baos)) {
			            try (FileInputStream fis = new FileInputStream(new File(ResultLocation+"\\"+testSetName.get()+"_"+testSetName.get()))) {
			                zos.putNextEntry(new ZipEntry((ResultLocation+"\\"+testSetName.get()+"_"+testSetName.get())));
			                int length;
			                while ((length = fis.read(buffer)) > 0) {
			                    zos.write(buffer, 0, length);
			                }
			                zos.closeEntry();
			            }
			    }
			    byte[] bytes = baos.toByteArray();
			    String Base64Zip = Base64.getEncoder().encodeToString(bytes);*/
					ZipUtil.pack(new File(ResultLocation.get()+File.separator+testSetName.get()+"_"+scenarioName.get()), new File(ResultLocation.get()+File.separator+testSetName.get()+"_"+scenarioName.get()+".zip"));
					FileUtils.deleteDirectory(new File(ResultLocation.get()+File.separator+testSetName.get()+"_"+scenarioName.get()));
					//File originalFile = new File(ResultLocation.get()+"\\"+testSetName.get()+"_"+scenarioName.get()+".zip");
					encodeFileToBase64Binary(ResultLocation.get()+File.separator+testSetName.get()+"_"+scenarioName.get()+".zip");

				}else {
					ExtentTestManager.extent.get().flush();		
				}
			}
			catch(Exception e) {
				System.out.println("End Test report exception:"+e.getMessage());
			}
			try {
				switch(channel) {
				case "Web":
					//BrowserFactory.webDriver.get().close();
					browserFactory.get().getDriver().quit();
//					if(platform.equalsIgnoreCase("pwa mobile"))	
//						browserFactory.get().getDriver().quit();

					//taskKill("chromedriver.exe");
					//taskKill("chrome.exe");
					break;
				case "Mobile":
					gmethods.stopAppiumServer();
					appiumDriver.get().quit();
					break;

				}
			//	Sandeep to uncomment after fixing error logger.endTestCase(testSetName.get()+"-"+scenarioName.get());

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("End Test driver exception:"+e.getMessage());
			}
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			System.out.println("End Test Final exception:"+e.getMessage());
		}
		finally {
			//MyScreenRecorder.stopRecording();
			
			
				gmethods.getTestCounts();

			//	gmethods.updateResultInJira();
				//gmethods.publishDefectInJIRA(ResultLocation.get()+File.separator+testSetName.get()+"_"+scenarioName.get()+".zip");


			taskKill("chromedriver.exe");
			taskKill("geckodriver.exe");
			taskKill("operadriver.exe");
			taskKill("msedgedriver.exe");

//			if(fUtil.readInput("Threadcount").equals("1")) {
//				taskKill("chrome.exe");
//				taskKill("firefox.exe");
//				taskKill("MicrosoftEdge.exe");
//				taskKill("opera.exe");
//			}
		}
	}

	public File takeScreenshot()
	{
		return ((TakesScreenshot) browserFactory.get().getDriver()).getScreenshotAs(OutputType.FILE);

	}

	

}
