package com.montran.filter;

public class InclusionFilter implements Filter {

	private String filter;
	

	public InclusionFilter(String filter) {
		this.filter = filter;
		
	}

	@Override
	public String execute(String data) {
		System.out.println(
				String.format("Exceute from %s whit parameters: %s", this.getClass().getSimpleName(), this.filter));
		return null;
	}

}
