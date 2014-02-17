package com.ist413.aauapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import android.os.AsyncTask;

public class Authentication {

	private static String loggedUser = null;
	private static String loggedPass = null;
	
	private String userCheck;
	private String passCheck;
	
	private static boolean isAuthorized = false;

	public enum AuthGroup{ADMINISTRATOR, CONTRIBUTOR, GENERAL}

	public Authentication() {
	
	}
	
	public Authentication(String user, String pass) throws MalformedURLException{
		this.userCheck = user;
		this.passCheck = pass;
		new AuthRetriever().execute(new URL("http://www.mythicacraft.com/ist413/authtest.json"));
	}
	
	public static boolean isAuthorized(){
		return isAuthorized;
	}

	public static void isAuthorized(boolean bool){
		Authentication.isAuthorized = bool;
	}
	
	public static void setLoggedUser(String loggedUser) {
		Authentication.loggedUser = loggedUser;
	}
	
	public static String getLoggedUser() {
		return loggedUser;
	}

	public static String getLoggedPass() {
		return loggedPass;
	}

	public static void setLoggedPass(String loggedPass) {
		Authentication.loggedPass = loggedPass;
	}
	
	/*
	 * thread for checking accounts against
	 * json 
	 * 
	 */
	
	private class AuthRetriever extends AsyncTask<URL, Integer, Void>{

		Object obj;
		
		@Override
		protected Void doInBackground(URL... url) {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(url[0].openStream()));
				String line = in.readLine();
				JSONParser parser = new JSONParser();
				obj = parser.parse(line);
			} catch (Exception e) {	}
			
			JSONObject result = (JSONObject) obj;
			
			JSONObject contrib = (JSONObject) result.get("contributor");
			JSONObject admin = (JSONObject) result.get("administrator");
			
			if(contrib.containsKey(userCheck)){
				JSONObject pass = (JSONObject) contrib.get(userCheck);
				String authPass = (String) pass.get("password");
				if(authPass.equalsIgnoreCase(passCheck))
					isAuthorized(true);
			}
			if(admin.containsKey(userCheck)){
				JSONObject pass = (JSONObject) admin.get(userCheck);
				String authPass = (String) pass.get("password");
				if(authPass.equalsIgnoreCase(passCheck))
					isAuthorized(true);
			}
			isAuthorized(false);
			return null;
		}
	}
}
