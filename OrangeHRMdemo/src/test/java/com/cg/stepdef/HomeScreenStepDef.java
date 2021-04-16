package com.cg.stepdef;

import java.io.IOException;
import java.util.Map;

import com.cg.Hooks.Hooks;
import com.cg.pages.HomePage;
import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class HomeScreenStepDef  {
	
	HomePage hp;
	
	@Given("^User is on login screen$")
	public void user_is_on_login_screen() throws Exception {
		
			hp = new HomePage();
			    
	}

	@When("^user enter valid credentials$")
	public void user_enter_valid_credentials(DataTable arg1) throws Exception {
		
		Map map = arg1.asMap(String.class, String.class);
	    hp.username(map.get("username")+"");
		hp.password(map.get("password")+"");
		 
	}

	@When("^user click on login$")
	public void user_click_on_login() throws Exception {
		
		hp.loginButton();
	  
	}
	
	@When("^user click on leave menu$")
	public void user_click_on_leave_menu() throws Exception {
		
		hp.Leave();
	    
	}

	@Then("^user click on reports submenu$")
	public void user_click_on_reports_submenu() throws Exception {
		
		hp.SubMenu();
	    
	}


	@Then("^user select generate for$")
	public void user_select_generate_for() throws Exception {
		
		hp.SelectClass();
	    
	}
	
	@When("^user gets all the links$")
	public void user_gets_all_the_links() throws Exception {
		
		hp.Links();
		hp.Links1();
		hp.Links2();
		hp.About();
	   
	}
	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		Hooks.beforeScenario(scenario);
	}

	@After
	public void tearDown(Scenario scn) throws IOException
	{

		Hooks.CaptureScreenshot(scn);
		hp.driver.quit();

	}
	
}
