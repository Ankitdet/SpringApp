package com.ceok.configuration;

import org.apache.commons.lang.exception.ExceptionUtils;

public class Logger {
   
    private static ILogger logger = new Log4jLogger();

    public static void logError(String strModule, String strMessage) {        
        logger.error("[ "+ strModule +" ] : " + strMessage);
    }
    public static void logDebug(String strModule, String strMessage){ 
        logger.debug("[ "+ strModule +" ] : " + strMessage);
    }
    public static void logInfo(String strModule, String strMessage){
        logger.info("[ "+ strModule +" ] : " + strMessage);
    }
    public static void logWarn(String strModule, String strMessage){
        logger.warn("[ "+ strModule +" ] : "+ strMessage);
    }
    public static void logFatal(String strModule, String strMessage){
        logger.fatal("[ "+ strModule +" ] : "+ strMessage);
    }

    public static void logTrace(String strModule,String strMessage){
        logger.trace("[ "+ strModule +" ] : "+ strMessage);
    }

    public static void logError(String strModule, Object strMessage) {        
        logger.error("[ "+ strModule +" ] : " + strMessage);
    }
    public static void logDebug(String strModule, Object strMessage){
        logger.debug("[ "+ strModule +" ] : " + strMessage);
    }
    public static void logInfo(String strModule, Object strMessage){
        logger.info("[ "+ strModule +" ] : " + strMessage);
    }
    public static void logWarn(String strModule, Object strMessage){
        logger.warn("[ "+ strModule +" ] : "+ strMessage);
    }
    public static void logFatal(String strModule, Object strMessage){
        logger.fatal("[ "+ strModule +" ] : "+ strMessage);
    }

    public static void logTrace(String strModule,Object strMessage){
        logger.trace("[ "+ strModule +" ] : "+ strMessage);
    }

    public static void logTrace(String strModule,Throwable exception){
        logger.trace("[ "+ strModule +" ] : "+"\n"+ getRootCauseStackTraceAsString(exception));
    }

    public static void setLogger(ILogger newlogger) {
        logger = newlogger;
    }

    public static ILogger getLogger(){
        return logger;
    }
    
    public static String  getRootCauseStackTraceAsString(Throwable arg0)
    {
       String [] trace = ExceptionUtils.getRootCauseStackTrace(arg0);
       return trace.toString();
    }
}
