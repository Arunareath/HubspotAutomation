package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtils;

public class ContactsPage {
	
	WebDriver driver;
	ElementUtils eu;

	By Email=By.id("UIFormControl-34");
	By Ln=By.id("UIFormControl-40");
	By jobtitle=By.id("UIFormControl-48");
	By createclick=By.xpath("//span[.='Create contact']");
	
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		eu=new ElementUtils(driver);
		
	}
	
	public void createnewcontact(String value1,String value2,String value3)
	{
		eu.sendkeysMethod(Email,value1);
		eu.sendkeysMethod(Ln,value2);
		eu.sendkeysMethod(jobtitle,value3);
		eu.doclick(createclick);
	}
}
