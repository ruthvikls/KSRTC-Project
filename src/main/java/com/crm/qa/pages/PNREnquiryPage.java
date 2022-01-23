package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class PNREnquiryPage extends TestBase {
	@FindBy(xpath = "//h4[text()='PNR Enquiry']")
	WebElement PnrLogo;
	@FindBy(id = "pnrPrefixWithTktNo")
	WebElement PnrNumInput;
	@FindBy(id = "mobileNo")
	WebElement mobileNum;
	@FindBy(id = "searchBtn")
	WebElement submitbtn;
	@FindBy(id = "errorMsg")
	WebElement errorAfterClick;

public PNREnquiryPage() {
	PageFactory.initElements(driver, this);
}
public Boolean PNRlogo() {
	return(PnrLogo.isDisplayed());
}

public Boolean pnrNum(String pnrnum,String mobile) {
	PnrNumInput.sendKeys(pnrnum);
	mobileNum.sendKeys(mobile);
submitbtn.click();
return(errorAfterClick.isDisplayed());

}






}