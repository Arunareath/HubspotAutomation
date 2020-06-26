package com.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.page.ContactsPage;
import com.qa.page.HomePage;
import com.qa.page.LoginPage;
import com.qa.util.CredentialsUtil;
import com.qa.util.ExcelUtil;

public class ContactsPageTest {
	
	BasePage bp;
	LoginPage lp;
	WebDriver driver;
	Properties prop;
	CredentialsUtil cu;
	HomePage hp;
	Object[][] data;
	ExcelUtil excel;
	ContactsPage cp;

	@BeforeTest
	public void setup()
	{
		bp=new BasePage();
		prop = bp.initializeprop();
		driver=bp.initializedriver();
		lp=new LoginPage(driver);
		cu=new CredentialsUtil(prop.getProperty("username"),prop.getProperty("password"));
		hp=lp.login(cu);
		cp=hp.homepagecontact();
	}
	
	@DataProvider
	public Object[][] gettingdatafromexcel()
	{
		return excel.retrivedata("contacts");
	}
	
	
	@Test(dataProvider="gettingdatafromexcel")
	public void createcontact(String email,String fn,String job)
	{
		cp.createnewcontact(email,fn,job);
	}
			
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
