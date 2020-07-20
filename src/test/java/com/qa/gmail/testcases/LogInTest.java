package com.qa.gmail.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gmail.base.TestBase;
import com.qa.gmail.pageobjects.HomePage;
import com.qa.gmail.pageobjects.PasswordPage;
import com.qa.gmail.pageobjects.SignInPage;

public class LogInTest extends TestBase {
	

SignInPage signInPage;



@BeforeMethod
public void runner(){
	initialization();
	signInPage = new SignInPage();	
}

@Test (priority =1 )
public void  verifyLogin() throws InterruptedException  {
	System.out.println("**Verify Login in Gmail**");
	boolean heading = signInPage.signInHeadingText();
	Assert.assertTrue(heading, "Heading is not match");	
	signInPage.signINwithEmail(prop.getProperty("email"));
	PasswordPage passwordPage = new PasswordPage();
	Thread.sleep(3000);
	boolean passwordHeaderText = passwordPage.passwordHeaderTxt();
	Assert.assertTrue(passwordHeaderText, "Heading is not match");	
	passwordPage.signINwithPassword(prop.getProperty("password"));
	HomePage homePage = new HomePage();
	String title = homePage.homePageTitle();
	Assert.assertEquals(title, "Gmail");
	boolean verifyTheProfileIcon = homePage.verifyTheProfileIcon();
	Assert.assertTrue(verifyTheProfileIcon, "Profile Icon is not displayed");
	homePage.clickIcon();
	String verifyUserNameInProfile = homePage.verifyUserNameInProfile();
	Assert.assertEquals(verifyUserNameInProfile, "Test 111");
	String verifyUserMailInProfile = homePage.verifyUserMailInProfile();
	Assert.assertEquals(verifyUserMailInProfile, "newtester47@gmail.com");
	homePage.clickSignOut();
	
	}

@Test(priority = 2 )
public void verifyInvalidPassword() throws InterruptedException {
	System.out.println("**Verify Enter Invalid Password and validate the Error Message**");
	boolean heading = signInPage.signInHeadingText();
	Assert.assertTrue(heading, "Heading is not match");	
	signInPage.signINwithEmail(prop.getProperty("email"));
	PasswordPage passwordPage = new PasswordPage();
	Thread.sleep(3000);
	boolean passwordHeaderText = passwordPage.passwordHeaderTxt();
	Assert.assertTrue(passwordHeaderText, "Heading is not match");	
	passwordPage.signINwithPassword(prop.getProperty("invalidPassword"));
	boolean invalidPasswordError = passwordPage.verifyInvalidPasswordError();
	Assert.assertTrue(invalidPasswordError);
}

@Test(priority = 3)
public void verifyInvaildUsername() {
	System.out.println("**Verify Enter Invalid Username and Validate the error message**");
	boolean heading = signInPage.signInHeadingText();
	Assert.assertTrue(heading, "Heading is not match");	
	signInPage.signINwithEmail(prop.getProperty("invaildUsername"));
	signInPage.verifyInvalidUserNameError();
	
	
}


	@AfterMethod
	public void close() {
	driver.quit();
	}

}