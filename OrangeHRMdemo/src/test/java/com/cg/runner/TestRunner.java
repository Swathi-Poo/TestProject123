package com.cg.runner;

import java.io.File;

import org.junit.*;
import org.junit.runner.RunWith;

import com.cg.base.TestBase;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",
		glue="com.cg.stepdef",
		dryRun = false,
		monochrome = true,
		plugin = {"html:target/cucumber-html-report",
				"json:target/cucumber-reports/cucumber.json",
				"junit:target/cucumber-reports/cucumber.xml",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Extentreport.html",
				"rerun:target/failedrerun.txt"},
		tags = "@login")
		
public class TestRunner {
	
	@AfterClass
	public static void writeExtentReport() {
		//Reporter.loadXMLConfig(new File(TestBase.getReportConfigPath()));
		Reporter.loadXMLConfig(new File("Config//extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + " 64 Bit");
		
	}

}
