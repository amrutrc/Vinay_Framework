package com.signzy.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignzyLogger 

{


	//public static final Logger log = LogManager.getRootLogger();
	static Logger log = LogManager.getLogger();


	/*private NoonAcademyLogger Log=null;

	public static NoonAcademyLogger getLogger() {
		if(Log==null) {
			Log = new NoonAcademyLogger();
		}
		return Log;
	}*/

	public void debug(String message) {
		log.info(String.format("****************** Logging for %s ***************", getMethodName()));
		log.info(message);		
	}

	public static void info(String message) {
		log.info(String.format("****************** Logging for %s ***************", getMethodName()));
		log.info(message);		

	}

	public void error(String message) {
		log.info(String.format("****************** Logging for %s ***************", getMethodName()));
		log.info(message);		

	}

	public void fatal(String message) {
		log.info(String.format("****************** Logging for %s ***************", getMethodName()));
		log.info(message);		

	}
	public void error(String message, Throwable error) {
		log.info(String.format("****************** Logging for %s ***************", getMethodName()));
		log.error(message + " ErrorMessage=" + error.getMessage(), error);
	}
	public static String getMethodName() {
		StackTraceElement[] stacktraceelemnts = Thread.currentThread().getStackTrace();
		String[] cName = stacktraceelemnts[3].getClassName().split("\\.");
		String className = cName[cName.length-1];
		return className.concat("::"+stacktraceelemnts[3].getMethodName());
	}


} 





