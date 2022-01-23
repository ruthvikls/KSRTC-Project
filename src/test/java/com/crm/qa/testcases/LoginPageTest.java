package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lgnpg;
	HomePage hmpg;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		 lgnpg = new LoginPage();
	}
	@Test(priority=1)
	public void ValidateWebPageTitleTest()
	 {
		String title = lgnpg.validateHomePageTitle();
		 Assert.assertEquals(title, "KSRTC Official Website for Online Bus Ticket Booking - KSRTC.in");
	 }
	@Test(priority=2)
	public void HomePageLogoTest()
	{
		boolean flag = lgnpg.validatehomelogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public HomePage loginPageTest()
	{
		lgnpg.login(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println(driver.getTitle());
		return new HomePage();
		
		
		}
	
	
	
	
@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
