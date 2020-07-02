package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	public static boolean header;
	OptionsManager om;

	public static ThreadLocal<WebDriver> thread=new ThreadLocal<WebDriver>();
	public static synchronized WebDriver getdriver()
	{
		return thread.get();
	}
	public WebDriver initializedriver()
	{	
		header = prop.getProperty("highlight").equals("yes");
		om=new OptionsManager(prop);

		if(prop.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();	
			//driver=new ChromeDriver(om.getchromeoptions());
			thread.set(new ChromeDriver(om.getchromeoptions()));
			getdriver().manage().deleteAllCookies();
			getdriver().manage().timeouts().implicitlyWait(Constants.time, TimeUnit.SECONDS);
			getdriver().get(prop.getProperty("url"));	


		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();	
			thread.set(new FirefoxDriver());
			getdriver().manage().deleteAllCookies();
			getdriver().manage().timeouts().implicitlyWait(Constants.time, TimeUnit.SECONDS);
			getdriver().get(prop.getProperty("url"));		
		}
		return getdriver();
	}

	public Properties initializeprop()
	{
		prop=new Properties();
		String path=null;
		String env=null;

		try
		{
			env=System.getProperty("env");

			if (env.equals(null))
			{
				path=".\\src\\main\\java\\com\\qa\\properties\\qa.properties";
			}
			else
			{
				if(env.equals("config"))
				{
					path=".\\src\\main\\java\\com\\qa\\properties\\config.properties";

				}else if(env.equals("qa"))
				{
					path=".\\src\\main\\java\\com\\qa\\properties\\qa.properties";

				}

			}
		}catch(Exception e)
		{
			System.out.println("no such path");
		}


		try
		{
			FileInputStream ip=new FileInputStream(".\\src\\main\\java\\com\\qa\\properties\\config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getScreenshot() throws IOException
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File dest=new File(path);
		FileUtils.copyFile(src,dest);
		return path;
	}

}
