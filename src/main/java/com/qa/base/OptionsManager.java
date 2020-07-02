package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	ChromeOptions co;
	FirefoxOptions fo;
	Properties prop;
	
	public OptionsManager(Properties prop)
	{
		this.prop=prop;
	}
	
	public ChromeOptions getchromeoptions()
	{
		co=new ChromeOptions();
		if (prop.getProperty("incognito").equals("yes"))
		{
			co.addArguments("--incognito");	
		}
		return co;
	}
	
	public FirefoxOptions getfirefoxoptions()
	{
		fo=new FirefoxOptions();
		if (prop.getProperty("incognito").equals("yes"))
		{
			fo.addArguments("--incognito");	
		}
		return fo;
	}
}
