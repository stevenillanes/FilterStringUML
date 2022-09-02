package com.montran.app;

import com.montran.filter.Filter;
import com.montran.filter.FilterFactory;
import com.montran.filter.exceptions.FilterCreationException;

public class MainFilter {
	public static void main(String[] args) {
		Filter filter;
		try {
			filter = FilterFactory.getInstance().factoryMethod();
			filter.execute();
		} catch (FilterCreationException e) {
			e.printStackTrace();
		}
	}
}
