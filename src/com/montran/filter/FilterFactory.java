package com.montran.filter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.montran.filter.exceptions.FilterCreationException;
import com.montran.filter.utils.PropertiesUtil;

public class FilterFactory {
	public static final FilterFactory instance = new FilterFactory();
	private static final Properties CONFIG = PropertiesUtil.getProperties("configuracion.properties");
	private Logger logger = Logger.getLogger(FilterFactory.class.getName());

	// singleton pattern
	private FilterFactory() {
	}

	public static FilterFactory getInstance() {
		return instance;
	}

	public Filter factoryMethod() throws FilterCreationException {
		Filter filter = null;
		Class<?> filterClass = null;
		try {
			filterClass = Class.forName(CONFIG.getProperty("filter.filterClass"));
			Constructor<?> filterContructor = filterClass.getConstructor(getAttributeTypes(filterClass));
			// strategy pattern
			filter = (Filter) filterContructor.newInstance((Object[]) CONFIG.getProperty("filter.param").split(","));

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			logger.log(Level.INFO, "Error during filter creation " + e.getMessage());
			throw new FilterCreationException(e.getMessage(), e);
		}

		return filter;

	}

	private Class<?>[] getAttributeTypes(Class<?> filterClass) {
		Field[] fields = filterClass.getDeclaredFields();
		Class<?>[] types = new Class[fields.length];
		for (int i = 0; i < fields.length; i++) {
			types[i] = fields[i].getType();
		}
		return types;

	}

}
