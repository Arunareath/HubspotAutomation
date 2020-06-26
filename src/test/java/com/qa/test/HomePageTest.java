package com.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.page.HomePage;
import com.qa.page.LoginPage;
import com.qa.util.Constants;
import com.qa.util.CredentialsUtil;
public class HomePageTest {
	
	BasePage bp;
	LoginPage lp;
	WebDriver driver;
	Properties prop;
	CredentialsUtil cu;
	HomePage hp;
	
	
	@BeforeTest
	public void setup()
	{
		bp=new BasePage();
		prop = bp.initializeprop();
		driver=bp.initializedriver();
		lp=new LoginPage(driver);
		cu=new CredentialsUtil(prop.getProperty("username"),prop.getProperty("password"));
		hp=lp.login(cu);
		
	}
	
	@Test(priority=1)
	public void homepagetitleTest()
	{
		Assert.assertEquals(hp.hompageTitle(),Constants.Home_page_title);
	}
	

	@Test(priority=2)
	public void homepageheaderTest()
	{
		Assert.assertTrue(hp.homepageHeader());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
