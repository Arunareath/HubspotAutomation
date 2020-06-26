package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsManager {

	ChromeOptions co;
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
}
