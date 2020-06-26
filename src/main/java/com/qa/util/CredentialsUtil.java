package com.qa.util;

public class CredentialsUtil {
	
	String appusername;
	String apppassword;
	
	public CredentialsUtil(String appusername,String apppassword)
	{
		this.appusername=appusername;
		this.apppassword=apppassword;
	}

	public String getAppusername() {
		return appusername;
	}

	public void setAppusername(String appusername) {
		this.appusername = appusername;
	}

	public String getApppassword() {
		return apppassword;
	}

	public void setApppassword(String apppassword) {
		this.apppassword = apppassword;
	}

}
