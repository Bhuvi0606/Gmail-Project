package com.qa.gmail.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.gmail.base.TestBase;

public class SignInPage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	WebElement headingTxt;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement txtemailId;
	
	@FindBy(xpath="//div[@class='VfPpkd-RLmnJb']")
	WebElement nextBtn;
	
	@FindBy(xpath = "//div[@class='o6cuMc']")
	WebElement invaildUserNameLabel;
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean signInHeadingText() {
		return headingTxt.isDisplayed();
	}
	
	public void verifyInvalidUserNameError() {
		boolean displayed = invaildUserNameLabel.isDisplayed();
		Assert.assertTrue(displayed);
		String text = invaildUserNameLabel.getText();
		Assert.assertEquals(text, "Enter a valid email or phone number");
	}
	
	public PasswordPage signINwithEmail(String mail) {
		txtemailId.sendKeys(mail);
		nextBtn.click();
		return new PasswordPage();
	}
	
	

}
