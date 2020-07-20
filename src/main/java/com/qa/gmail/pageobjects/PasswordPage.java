package com.qa.gmail.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.gmail.base.TestBase;

public class PasswordPage extends TestBase{
	
	@FindBy(xpath = "//span[contains(text(),'Welcome')]")
	WebElement passwordPageHeadingtxt;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//div[@class='VfPpkd-RLmnJb']")
	WebElement passwordNextBtn;
	
	@FindBy(xpath="//span[contains(text(),'Wrong password.')]")
	WebElement invalidErrorLable;
	
	
	public PasswordPage() {
		PageFactory.initElements(driver, this);
	
	}
	
	public boolean passwordHeaderTxt() {
		return passwordPageHeadingtxt.isDisplayed();	
	}

	public boolean verifyInvalidPasswordError() {
		return invalidErrorLable.isDisplayed();	
	}
	
	public HomePage signINwithPassword(String pass) {
		txtPassword.sendKeys(pass);
		passwordNextBtn.click();
		return new HomePage();
		
	}
	

	
	
	
	

}
