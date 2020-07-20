package com.qa.gmail.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.gmail.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//img[@class='gb_Ka gbii']")
	WebElement profileIcon;
	
	@FindBy(xpath = "//div[@class='gb_we']")
	WebElement profleIconContent;
	
	@FindBy(xpath = "//div[@class='gb_tb gb_ub']")
	WebElement userName;
	
	@FindBy(xpath = "//div[@class='gb_vb']")
	WebElement userMailId;	
	
	@FindBy(id = "gb_71")
	WebElement signOutBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyTheProfileIcon() {
		Actions ac = new Actions(driver);	
		ac.moveToElement(profileIcon).build().perform();
		boolean displayed = profileIcon.isDisplayed();
		return displayed;
		
		
	}
	
	public void clickIcon() {
		profileIcon.click();
	}
	
	public String verifyUserNameInProfile() {
		String  userNameContent = userName.getText();
		return userNameContent;
		
	}
	
	public String verifyUserMailInProfile() {
		String  userMailIDContent = userMailId.getText();
		return userMailIDContent;
		
	}
	
	public void clickSignOut() {
		signOutBtn.click();
		
	}
	
	
	

}
