package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;
import com.qa.util.Constants;
import com.qa.util.CredentialsUtil;
import com.qa.util.ElementUtils;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtils eu;
	HomePage hp;
	
	
	By username=By.id("username");
	By password=By.id("password");
	By loginbtn=By.id("loginBtn");
	By logo=By.xpath("//div[@class='auth-box marketing-box']");
	By invalidlogo=By.xpath("//div[@class='private-alert__inner']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eu=new ElementUtils(driver);
	}
	
	public String loginpagetitle()
	{
		eu.waitforvisibitytitle(Constants.Login_page_title);
		return eu.getTitleutil();
	}
	
	public boolean loginpageLogotest()
	{
		return eu.displayCheck(logo);
	}
	
	public HomePage login(CredentialsUtil cu)
	{		
		eu.sendkeysMethod(this.username,cu.getAppusername());
		eu.sendkeysMethod(this.password,cu.getApppassword());
		eu.doclick(loginbtn);
		return new HomePage(driver);
	}
	
	public boolean invalidlogin()
	{
		eu.waitforpresence(invalidlogo);
		return eu.displayCheck(invalidlogo);
	}

	

}
