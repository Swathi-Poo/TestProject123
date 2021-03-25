package com.cg.stepdef;

import com.cg.pages.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.en.*;

public class LoginStepDef {
	
	LoginPage login;
	
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() {
		
		login = new LoginPage();
		login.getTitle();	    
	}

	@When("^user enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_the_and(String arg1, String arg2) {
		
		login.username(arg1);
		login.password(arg2);
	    
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() {
		
		login.loginButton();
	    
	}

	@Then("^user should remain on login page with error message$")
	public void user_should_remain_on_login_page_with_error_message() {
		
		login.verifyLogin();
	    
	}
	
	@Then("^user should navigate to homepage$")
	public void user_should_navigate_to_homepage() {
		
		login.Verifyhomepage();
	    
	}
	
	@When("^user click on Forgot your password$")
	public void user_click_on_Forgot_your_password() {
		
		login.ForgotPassword();
	    
	}

	@Then("^user enter \"([^\"]*)\"$")
	public void user_enter_username(String arg1) {
		
		login.enterUsername(arg1);
	   
	}

	@Then("^user click on Reset password$")
	public void user_click_on_Reset_password() {
		
		login.ResetPassword();
	    
	}
	
	@Then("^verify the username$")
	public void verify_the_username() {
		
		login.VerifyReset();
	    
	}
	
	@After
	public void tearDown()
	{
		login.driver.close();
	}



}
