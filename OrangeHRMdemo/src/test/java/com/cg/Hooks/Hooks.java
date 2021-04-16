package com.cg.Hooks;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cg.base.TestBase;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.*;

public class Hooks extends TestBase {
	static int a=0;
	
	@Before
	public static void beforeScenario(Scenario scenario) {
	 Reporter.assignAuthor("Swathi Poojary");
	}
	
	@After
	public static void CaptureScreenshot(Scenario scn) throws IOException {
		
		if(scn.isFailed())
		{
		TakesScreenshot shot=(TakesScreenshot) driver;
		File srcPath =shot.getScreenshotAs(OutputType.FILE);
		File destPath = new File("Screenshots//ssc"+a+".png");
		try {
			FileUtils.copyFile(srcPath, destPath);
			Reporter.addScreenCaptureFromPath(destPath.getAbsolutePath());
			a++;
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		if (scn.isFailed()) {
		// This takes a screenshot from the driver at save it to the specified location
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		scn.embed(screenshot, "image/png");
	}
	}


	}
		
		



