package com.in28minutes.rest.webservices.restful_web_services.versioning;

public class Name {
	private String firstName;
	private String astName;
	public Name(String firstName, String astName) {
		super();
		this.firstName = firstName;
		this.astName = astName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAstName() {
		return astName;
	}
	public void setAstName(String astName) {
		this.astName = astName;
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", astName=" + astName + "]";
	}
	
}
