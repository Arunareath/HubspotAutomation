package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.Constants;
import com.qa.util.ElementUtils;
import com.qa.util.ExcelUtil;
import com.qa.util.JavaScriptUtils;

public class HomePage {
	
	WebDriver driver;
	ElementUtils eu;
	ExcelUtil excel;
	JavaScriptUtils js;
	
	By title=By.xpath("//i18n-string[.='Thanks for choosing HubSpot']");
	By clickcontact=By.id("nav-primary-contacts-branch");
	By subcontact=By.id("nav-secondary-contacts");
	By createclick=By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=1]");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eu=new ElementUtils(driver);
		excel=new ExcelUtil();
		js=new JavaScriptUtils(driver);
	}
	
	
	public String hompageTitle()
	{
		eu.waitforvisibitytitle(Constants.Home_page_title);
		return eu.getTitleutil();
	}
	
	public boolean homepageHeader()
	{
		return eu.displayCheck(title);
	}
	
	public ContactsPage homepagecontact()
	{
		eu.doclick(clickcontact);
		eu.doclick(subcontact);
		eu.doclick(createclick);
		return new ContactsPage(driver);
	}
	

}
