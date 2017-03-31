package com.ceok.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
		
	  private static Connection con = null;
	  private static Properties prop = new Properties();
	  private static InputStream input = null;
		
	    public static Connection getConnection() throws IOException,FileNotFoundException {
	        if (con != null)
	            return con;
	        else {
	            try {
	                
	            	input = new FileInputStream("src/com/ceok/db/config.properties");

	    			// load a properties file
	    			prop.load(input);

	                String driver = prop.getProperty("driver");
	                String url = prop.getProperty("url");
	                String user = prop.getProperty("user");
	                String password = prop.getProperty("password");

	                Class.forName(driver);
	                con = DriverManager.getConnection(url, user, password);
	                
	            } catch (ClassNotFoundException cnfe) {
	                System.out.println(cnfe);
	            } catch (SQLException sqe) {
	                System.out.println(sqe);
	            } finally {
	    			if (input != null) {
	    				try {
	    					input.close();
	    				} catch (IOException e) {
	    					e.printStackTrace();
	    				}
	    			}
	    		}
	            return con;
	        }
	    }
}
