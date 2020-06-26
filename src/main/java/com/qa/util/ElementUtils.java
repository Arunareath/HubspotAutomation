package com.qa.util;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class ElementUtils extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtils js;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Constants.time);
		js=new JavaScriptUtils(driver);
	}
	
	public String getTitleutil()
	{
		return driver.getTitle();
	}
	
	public boolean displayCheck(By locator)
	{
		return getElelocator(locator).isDisplayed();
	}
	
	public void doclick(By locator)
	{
		 getElelocator(locator).click();
	}
	
	public WebElement getElelocator(By locator)
	{
		WebElement ele = driver.findElement(locator);
		if(header)
		{
			js.flash(ele);
		}
		return ele;
	}
	
	public void sendkeysMethod(By locator,String value)
	{
		WebElement ele = getElelocator(locator);
		ele.clear();
		ele.sendKeys(value);
	}
	
	public void waitforpresence(By locator)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitforvisibility(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitforvisibitytitle(String title)
	{
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	
}
