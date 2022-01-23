package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BookingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PNREnquiryPage;

public class HomePageTest extends TestBase {
	LoginPage lgnpg;
	HomePage homepage;
	PNREnquiryPage pnrpage;
	BookingPage booking;
	
public HomePageTest()
{
super();	
}

@BeforeMethod
public void SetUp()
{
	initialization();
	lgnpg = new LoginPage();
 homepage = new HomePage();
	 pnrpage = new PNREnquiryPage();
 booking = new BookingPage();
	homepage = lgnpg.login(prop.getProperty("username"),prop.getProperty("password"));
}
@Test(priority = 1)
public void verifyHomepageTtileTest()
{
	String homepageTtile = homepage.verifyHomepageTtile();
	Assert.assertEquals(homepageTtile, "KSRTC Official Website for Online Bus Ticket Booking - KSRTC.in","Home Page title is not matching");
	}
@Test(priority = 2)
public void verifyUserNameOnHomePageTest() {
	
	Assert.assertTrue(homepage.verifynameonDashboard());
	}
@Test (priority = 3)
public void clickOnPnrEngquiryPageTest() {
	pnrpage = homepage.clickOnPnrEnquiry();
	}
@Test (priority = 4)
public void clickOnBookingPageTest() {
	booking = homepage.clickOnBookingPage();
	}

@AfterMethod
public void tearDown() {
	driver.close();
} 
}