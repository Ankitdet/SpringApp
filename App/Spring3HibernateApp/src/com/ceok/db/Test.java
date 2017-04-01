package com.ceok.db;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		
	/*	List<Map<String, Object>> data = dbOperation.select("select usename from users_details", null);

		if (data.size() > 0) {
			String name = getString(data.get(0).get("username"));
			
		}*/
		
	}
	private static String getString(Object object) {
		if (object == null)
			return "";
		return String.valueOf(object);
	}
}
