package com.montran.filter;

import java.util.List;

public class CompositeFilter implements Filter {

	private List<Filter> filters;

	public CompositeFilter(List<Filter> filters) {
		this.filters = filters;
	}

	@Override
	public String execute(String data) {
		System.out.println(String.format("Exceute from %s ", this.getClass().getSimpleName()));
		return null;
	}

}
