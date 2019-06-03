
package com.clc;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jExample {

	static{
		init();
	}
	
	private final static Logger logger = Logger.getLogger(Log4jExample.class);
	
	public static void main(String[] args) {

		logger.debug("My Debug Log");
		logger.info("My Info Log");
		logger.warn("My Warn Log");
		logger.error("My error log");
		logger.fatal("My fatal log");
		
		MathUtils.add(4,5);
		MathUtils.add(40,50);
		MathUtils.add(1,5);
		
	}

	/**
	 * method to init log4j configurations
	 */
	private static void init() {
		DOMConfigurator.configure("log4j.xml");
	}

}
 class MathUtils {

	private static final Logger logger = Logger.getLogger(MathUtils.class);
	
	public static int add(int x, int y){
		logger.debug("inputs are:"+x+", "+y);
		return x+y;
	}
}