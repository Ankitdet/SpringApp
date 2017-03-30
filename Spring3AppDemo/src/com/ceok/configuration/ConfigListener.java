package com.ceok.configuration;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.util.Log4jConfigListener;

public class ConfigListener extends Log4jConfigListener{

	private static Logger logger = LogManager.getLogger(ConfigListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		final Logger logger = Logger.getLogger(ConfigListener.class);
		BasicConfigurator.configure();

	    logger.debug("Hello this is an debug message");
	    logger.info("Hello this is an info message");
	}
	
}
