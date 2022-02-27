package com.framework.commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	public static final String CURRENTDIR = System.getProperty("user.dir");
			
	public static String getPropertyValue(String propetiesFileName, String key) {

		try (InputStream input = new FileInputStream(CURRENTDIR +propetiesFileName)) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
