package com.montran.filter;

public class ExclusionFilter implements Filter {

	private String filter;

	public ExclusionFilter(String filter) {
		this.filter = filter;
	}

	@Override
	public String execute(String data) {
		System.out.println(
				String.format("Exceute from %s whit parameter %s", this.getClass().getSimpleName(), this.filter));
		return null;
	}

}
