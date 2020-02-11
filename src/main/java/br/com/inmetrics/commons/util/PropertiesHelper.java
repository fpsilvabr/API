package br.com.inmetrics.commons.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesHelper {

	private static Properties propertiesProperties = new Properties();

	public static String getProperties(String propertie) {

		FileInputStream fileProperties;

		try {
			fileProperties = new FileInputStream("src/main/resources/properties/test.properties");
			propertiesProperties.setProperty("path", System.getProperty("user.home"));
			InputStreamReader readerProperties = new InputStreamReader(fileProperties, "UTF-8");
			propertiesProperties.load(readerProperties);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertiesProperties.getProperty(propertie);
	}

	public static String getProperties(String filename, String propertie) {

		FileInputStream fileProperties;

		try {
			fileProperties = new FileInputStream("src/main/resources/properties/" + filename);
			propertiesProperties.setProperty("path", System.getProperty("user.home"));
			InputStreamReader readerProperties = new InputStreamReader(fileProperties, "UTF-8");
			propertiesProperties.load(readerProperties);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertiesProperties.getProperty(propertie);
	}
}