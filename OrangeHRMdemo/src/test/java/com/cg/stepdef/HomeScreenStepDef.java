package com.cg.stepdef;

import java.util.Map;

import com.cg.pages.HomePage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.*;

public class HomeScreenStepDef {
	
	HomePage hp;
	
	@Given("^User is on login screen$")
	public void user_is_on_login_screen()  {
		
		hp = new HomePage();
		    
	}

	@When("^user enter valid credentials$")
	public void user_enter_valid_credentials(DataTable arg1)  {
		
		Map map = arg1.asMap(String.class, String.class);
	    hp.username(map.get("username")+"");
		hp.password(map.get("password")+"");
		 
	}

	@When("^user click on login$")
	public void user_click_on_login()  {
		
		hp.loginButton();
	  
	}
	
	@When("^user click on leave menu$")
	public void user_click_on_leave_menu()  {
		
		hp.Leave();
	    
	}

	@Then("^user click on reports submenu$")
	public void user_click_on_reports_submenu()  {
		
		hp.SubMenu();
	    
	}


	@Then("^user select generate for$")
	public void user_select_generate_for()  {
		
		hp.SelectClass();
	    
	}
	
	@When("^user gets all the links$")
	public void user_gets_all_the_links() {
		
		hp.Links();
		//hp.Links1();
	   
	}
	
	
	@After
	public void tearDown()
	{
		hp.driver.quit();
	}

}
