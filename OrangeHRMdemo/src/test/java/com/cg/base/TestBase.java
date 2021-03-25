package com.cg.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class TestBase {
	
	public static WebDriver driver;
	Properties prop;
	protected Actions action;
	
	
	public TestBase()
	{
		prop = new Properties();
		try {
			prop.load(new FileInputStream("config\\config.properties"));
			String browser = prop.getProperty("browser");
			if(browser.equalsIgnoreCase("CHROME"))
			{
				System.setProperty("webdriver.chrome.driver","drivers\\chromedriver\\chromedriver.exe" );
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver","drivers\\geckodriver\\geckodriver.exe" );
				driver = new FirefoxDriver();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void init()
	{
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		action = new Actions(driver);
		
	}
	

}
