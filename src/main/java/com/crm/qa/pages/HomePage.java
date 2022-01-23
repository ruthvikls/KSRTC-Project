package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase  {
	
	@FindBy(xpath="//span[text()='Ruthvik']")
	WebElement usernameOnDashBoard;
	
	@FindBy(xpath="//a[text()='PNR Enquiry']")
	WebElement PnrEnquiryLink;
	
	@FindBy(xpath="//a[text()='Booking']")
	WebElement BookingLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTtile()
	{
		return driver.getTitle();
	}
	public PNREnquiryPage clickOnPnrEnquiry()
	{
		PnrEnquiryLink.click();
		return new PNREnquiryPage();
	}

	public BookingPage clickOnBookingPage()
	{
		BookingLink.click();
		return new BookingPage();
	}
	public Boolean verifynameonDashboard()
	{
		Boolean flag = usernameOnDashBoard.isDisplayed();
		return flag;
	}
}
