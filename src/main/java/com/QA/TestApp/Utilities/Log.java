package com.QA.TestApp.Utilities;

//import org.apache.log4j.Logger;

public class Log extends BaseScript{
	//private static Logger Log = Logger.getLogger(logger.class.getName()); 
	
    
	public void startTestCase(String sTestCaseName){
	//	logger.info("****************************************************************************************");

		log.info("*****************************************************************");

		log.info("******************** STARTING TEST CASE - "+sTestCaseName+ "************************");

		//logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

	//	logger.info("****************************************************************************************");

		log.info("****************************************************************************************");
	}
	public void endTestCase(String sTestCaseName){
		try {
			
		
		String testCaseResult = ExtentTestManager.getTest().getStatus().toString();
		log.info("****************************************************************************************");

		if (testCaseResult.equalsIgnoreCase("Pass")) {
			log.info("********************* TEST CASE PASSED ***************************");

		} else if (testCaseResult.equalsIgnoreCase("Fail")) {
			
			log.severe("********************* TEST CASE FAILED ***************************");

		}
		
		String testStartTime = ExtentTestManager.getTestStatus().getStartTime().toString();
		String testEndTime = ExtentTestManager.getTestStatus().getEndTime().toString();
		
		
		log.info("**** TEST CASE Start Time :: "+testStartTime);
		log.info("**** TEST CASE End Time :: "+testEndTime);
		//log.info("**** TEST CASE Execution Time :: "+ExtentTestManager.getTest().ge);

		log.info("\n*********************** ENDING TEST CASE - "+sTestCaseName+ "****************************\n\n");
 
	//	logger.info("X");

	//	logger.info("X");

	//	logger.info("X");

	//	logger.info("X");
	}catch(Exception e) {
		e.printStackTrace();
	}

	}
	public  void info(String message) {
		log.info(message);
	}
	public  void warn(String message) {
		log.warning(message);
	}
	public  void error(String message) {
		log.severe(message);
	}
	public  void fatal(String message) {
		log.severe(message);
	}
//	public  void debug(String message) {
//		logger.debug(message);
//	}
}
