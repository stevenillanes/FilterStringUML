package com.montran.filter.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class PropertiesUtil {

	private static final String RESOURCE_PATH = "resources";

	public static Properties getProperties(String fileName) {
		
		Path file = Path.of(RESOURCE_PATH);
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(file.resolve(fileName).toFile()));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	public static void main(String[] args) {
		Properties properties = PropertiesUtil.getProperties("configuracion.properties");
		
		System.out.println(properties.get("filter.param"));

	}

}
