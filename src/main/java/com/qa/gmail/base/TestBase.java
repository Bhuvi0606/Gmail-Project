package com.qa.gmail.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.qa.gmail.utils.Utils;





public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Bhuvana_Off\\Task\\Gmail\\src\\main\\java\\com\\qa\\gmail\\config\\Config.properties");
					prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		
			System.setProperty("webdriver.chrome.driver", "C:\\Bhuvana_Off\\Task\\Gmail\\driver\\chromedriver.exe");	
			driver = new ChromeDriver(); 
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		driver.navigate().to(prop.getProperty("url"));

}
}