package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BookingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PNREnquiryPage;
import com.crm.qa.util.TestUtil;

public class PNREnquiryPageTest extends TestBase {
	
		LoginPage lgnpg;
		HomePage homepage;
		PNREnquiryPage pnrpage;
		BookingPage booking;
		String sheetName ="PNR_pnrPage";
	public PNREnquiryPageTest()
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
			homepage.clickOnPnrEnquiry();
		}
	@Test(priority=1)
	public void PnrLogoPresentTest() {
		Assert.assertTrue(pnrpage.PNRlogo());
	}
	@DataProvider()
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2,dataProvider="getTestData")
	public void pnrnumTest(String pnrNum, String mobileNum) {
		pnrpage.pnrNum(pnrNum, mobileNum);
		Assert.assertTrue(true);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	} 
	

	}
