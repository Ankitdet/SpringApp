package com.ceok.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		DBOperation dbOperation = new DBOperation();
		List<Map<String, Object>> data = dbOperation.select("select state from subscriber", null);

		if (data.size() > 0) {
			String name = getString(data.get(0).get("STATE"));
			
		}
	}
	private static String getString(Object object) {
		if (object == null)
			return "";
		return String.valueOf(object);
	}
}
