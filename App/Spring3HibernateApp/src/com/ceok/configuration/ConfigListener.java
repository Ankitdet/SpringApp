package com.ceok.configuration;

import javax.servlet.ServletContextEvent;


import org.springframework.web.util.Log4jConfigListener;


public class ConfigListener extends Log4jConfigListener{

	public static final String MODULE ="ConfigLister" ;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Logger.logInfo(MODULE, "Entered execute method of " + getClass().getName());
		Logger.logDebug(MODULE,"DETEnjskgnsk");
	}
	
}
