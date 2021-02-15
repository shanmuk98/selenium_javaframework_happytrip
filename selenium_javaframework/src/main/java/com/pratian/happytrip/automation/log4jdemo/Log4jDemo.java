package com.pratian.happytrip.automation.log4jdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static Logger logger=LogManager.getLogger(Log4jDemo.class);
	public static void main(String[] args) {
	System.out.println("logger output is seen below ..\n");	
	logger.info("it has info about looger");
	logger.error("it displays error message is exist");
	logger.warn("it displayes warning messages");
	logger.fatal("it displays fatal messages");
	System.out.println("\n completed");
	}
}
