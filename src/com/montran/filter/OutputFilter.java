package com.montran.filter;

public class OutputFilter implements Filter {

	private String stringToReplace;
	private String stringForReplace;

	public OutputFilter(String stringToReplace, String stringForReplace) {
		this.stringToReplace = stringToReplace;
		this.stringForReplace = stringForReplace;
	}

	@Override
	public String execute(String data) {
		System.out.println(String.format("Exceute from %s whit parameter %s, %s", this.getClass().getSimpleName(),
				this.stringForReplace, this.stringToReplace));
		return null;
	}

}
