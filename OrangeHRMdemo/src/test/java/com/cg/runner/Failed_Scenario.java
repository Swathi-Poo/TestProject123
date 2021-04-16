package com.cg.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"@target/failedrerun.txt"},
		glue="com.cg.stepdef",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty",
				"rerun:target/failedrerun.txt"})
public class Failed_Scenario {
	
/*private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass()
	{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature)
	{
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	@DataProvider
	public Object[][] features()
	{
		return testNGCucumberRunner.provideFeatures();
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass()
	{
		testNGCucumberRunner.finish();
	}*/
	

}
