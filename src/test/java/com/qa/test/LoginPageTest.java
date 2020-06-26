package com.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.page.HomePage;
import com.qa.page.LoginPage;
import com.qa.util.Constants;
import com.qa.util.CredentialsUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest {
	
	BasePage bp;
	LoginPage lp;
	WebDriver driver;
	Properties prop;
	CredentialsUtil cu;
	HomePage hp;
	
    @Epic("Epic-101: create login page features")
    @Feature("US-501: create test for login page on hubspot")
	@BeforeTest
	public void setup()
	{
		bp=new BasePage();
		prop = bp.initializeprop();
		driver=bp.initializedriver();
		lp=new LoginPage(driver);
		cu=new CredentialsUtil(prop.getProperty("username"),prop.getProperty("password"));
		hp=new HomePage(driver);
	}
	
	@Test(priority=1,enabled=true)
	@Description("verify login page Title")
	@Severity(SeverityLevel.NORMAL)
	public void loginpagetitletest()
	{
		String title = lp.loginpagetitle();
		Assert.assertEquals(title,Constants.Login_page_title);
	}
	
	@Test(priority=2,enabled=false)
	@Description("verify logo Test")
	@Severity(SeverityLevel.CRITICAL)
	public void loginpagelogotest()
	{
		Assert.assertTrue(lp.loginpageLogotest());
	}
	
	@Test(priority=3,enabled=false)
	@Description("Verify login Test")
	@Severity(SeverityLevel.BLOCKER)
	public void logintest()
	{
		hp=lp.login(cu);
		Assert.assertTrue(hp.homepageHeader());
	}
	
	@DataProvider
	public Object[][] getloginnagativedata()
	{
		Object str[][]= {{"test12773@gmail.com ","test123"},{"test123@gmail.com"," kokokk"}};
		return str;
	}
	
	@Test(priority=4,dataProvider="getloginnagativedata",enabled=false)
	@Description("Negative testing for login page")
	@Severity(SeverityLevel.CRITICAL)
	public void invalidlogintest(String un,String pwd)
	{
		cu.setAppusername(un);
		cu.setApppassword(pwd);
		lp.login(cu);
		Assert.assertTrue(lp.invalidlogin());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
