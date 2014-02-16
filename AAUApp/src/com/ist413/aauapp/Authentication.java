package com.ist413.aauapp;

public class Authentication {

	private static String loggedUser = null;
	private static String loggedPass = null;
	
	public enum AuthGroup{ADMINISTRATOR, CONTRIBUTOR, GENERAL}

	public Authentication() {
	
	}
	
	public Authentication(String user, String pass){
		
	}
	
	public boolean isAuthorized(){
		
		return false;
	}
	
	
	/*
	 * thread for checking accounts against
	 * json 
	 * 
	 */
}
