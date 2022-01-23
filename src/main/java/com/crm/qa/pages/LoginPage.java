package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//a[text()=' Sign In']")
	WebElement signInBtnOnHomePage;
	
	@FindBy(id="userName")
	WebElement usertextbox;
	
	@FindBy(id="password")
	WebElement passwordtextbox;
	
	@FindBy(xpath="//label[contains(@class,'custom-control')]")
	WebElement checkbox;
	
	@FindBy(id="submitBtn")
	WebElement signinBtn;
	
	@FindBy(xpath="//div[@class='logo_img']")
	WebElement homelogo;

	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public Boolean validatehomelogo()
	{
		return homelogo.isDisplayed();
	}
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	public HomePage login(String uN,String pwd)
	{
		signInBtnOnHomePage.click();
		usertextbox.sendKeys(uN);
		passwordtextbox.sendKeys(pwd);
	
		signinBtn.click();
		
		return new HomePage();
	}
	
	
}
