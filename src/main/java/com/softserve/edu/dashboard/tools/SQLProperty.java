package com.softserve.edu.dashboard.tools;

import java.util.Properties;

public class SQLProperty {

	private static Properties properties;
	static {
		properties = new Properties();
		try {
			 properties.load(SQLProperty.class.getClassLoader().getResourceAsStream("SQL.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(String name) {
		if (properties.containsKey(name)) {
			return properties.getProperty(name);
		}
		throw new RuntimeException("Key not found");
	}
}
