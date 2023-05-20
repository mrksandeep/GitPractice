package com.QA.TestApp.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

public class PriorityInterceptor extends FrameWorkUtility implements IMethodInterceptor {
	//@Override
	
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		  List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		  int counterMethonds=0;
		  int countPush=0;
		  //String scenario=context.getName();
		  String module=scenarioGadgetMap.get(scenarioName.get());
		  ArrayList<String> KeywordsFetched=null;
		try {
			//Changed Channel name to Channel
			if(channel.equalsIgnoreCase("Web")) {
				KeywordsFetched = fUtil.fGetKeywords(fUtil.readInput("ScenarioWeb")+testSetName.get()+".xls","Sheet1",scenarioName.get());
			}else if(channel.equalsIgnoreCase("API")) {
				KeywordsFetched = fUtil.fGetKeywords(fUtil.readInput("ScenarioAPI")+testSetName.get()+".xls","Sheet1",scenarioName.get());
			}
			else if(channel.equalsIgnoreCase("Mobile")) {
				KeywordsFetched = fUtil.fGetKeywords(fUtil.readInput("ScenarioMobile")+testSetName.get()+".xls","Sheet1",scenarioName.get());
			}
			
			
			//KeywordsFetched = fUtil.fGetKeywords(fUtil.readInput("Scenario"),module,scenarioName);
			for (String xx : KeywordsFetched) {
				  
				   // Test test = m.getMethod().getConstructorOrMethod().getAnnotation(Test.class);
				   // Set<String> groups = new HashSet<String>();
				   // for (String group : test.groups()) {
				    //  groups.add(group);
				   // }
				   // if (groups.contains("fast")) {
					  for (IMethodInstance m : methods) {
						  //String mName=m.toString();
						  ITestNGMethod cc=m.getMethod();
						  String abc=cc.getQualifiedName();
						  String[] mArray=abc.split("\\.");
						  String mName=mArray[mArray.length-1];
						  System.out.println(mName);
						  System.out.println(abc);
						 
						 // String mNameScenario=KeywordsFetched.get(counterMethonds);
						  if(mName.equalsIgnoreCase(xx))
						  {
							  result.add(countPush, m);
							  //counterMethonds=counterMethonds+1;
							  countPush=countPush+1;
						  }	  
						  
					  }
					  
				   // }
				   // else {
				     // result.add(m);
				    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  //}
		  return result;
		}

}



