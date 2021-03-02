package com.pratian.testclasses;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{
	public void onStart(ITestContext context) { 
		System.out.println("onStart method started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
	}

	public void onTestStart(ITestResult Result)					
	{		
		System.out.println(Result.getName()+" test case started");					
	}	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" test case success");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" testcase is failure");
	} 
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method" +result.getName());
	}

}
