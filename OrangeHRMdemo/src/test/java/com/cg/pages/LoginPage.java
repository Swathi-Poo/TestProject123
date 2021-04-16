package com.cg.pages;

import static org.junit.Assert.assertEquals;

import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cg.base.TestBase;

public class LoginPage extends TestBase{

	@Rule
	public ErrorCollector error = new ErrorCollector();

	private SoftAssertions sa = new SoftAssertions();

	private @FindBy(id = "txtUsername") WebElement username;
	private @FindBy(id = "txtPassword") WebElement password;
	private @FindBy(id = "btnLogin") WebElement submit;
	private @FindBy(xpath = "//span[@id='spanMessage']") WebElement errorMessage;
	private @FindBy(id = "welcome") WebElement homeScreen;
	private @FindBy(linkText = "Forgot your password?") WebElement ForgotPassword;
	private @FindBy(id = "securityAuthentication_userName") WebElement Username;
	private @FindBy(id = "btnSearchValues") WebElement ResetButton;
	private @FindBy(xpath = "//div[@class='message warning fadable']") WebElement message;

	public LoginPage()
	{
		init();
		PageFactory.initElements(driver, this);

	}

	public String getTitle()
	{

		System.out.println(driver.getTitle());
		String expectedResult="OrangeHRM";
		assertEquals(expectedResult,driver.getTitle());
		sa.assertAll();
		return driver.getTitle();

	}
	public void username(String UN)
	{
		username.sendKeys(UN);
	}

	public void password(String PN)
	{
		password.sendKeys(PN);
	}

	public void loginButton()
	{
		submit.click();
	}

	public void verifyLogin()
	{
		String actualResult;
		String expectedResult="Invalid credentials";

		actualResult = errorMessage.getText();

		System.out.println(actualResult);

		if(expectedResult.equals(actualResult))
		{
			System.out.println("Assertion Passed");
		}
		else
		{
			System.out.println("Assertion Failed");
		}
		assertEquals(expectedResult, actualResult);
		sa.assertAll();
	}

	public void Verifyhomepage() 
	{
		String actualResult1;
		String expectedResult1 = "Welcome";

		actualResult1 = homeScreen.toString();
		System.out.println(actualResult1);

		try {
			if(expectedResult1.equals(actualResult1))
			{
				System.out.println("Assertion Passed");
				
			}
		}catch( NoSuchElementException e)
		{
			System.out.println("Assertion Failed");
		}
		assertEquals(expectedResult1, actualResult1);
		sa.assertAll();

	}

	public void ForgotPassword()
	{
		ForgotPassword.click();

	}

	public void enterUsername(String un)
	{
		Username.sendKeys(un);
	}

	public void ResetPassword()
	{
		ResetButton.click();
	}

	public void VerifyReset()
	{

		String expectedResult = "Instructions for resetting your password have been sent to paul1@osohrm.com";

		String actualResult = message.getText();

		if(actualResult.equals(expectedResult))
		{
			System.out.println("Assertion Passed");
		}
		else
		{
			System.out.println("Assertion Failed");
		}
		assertEquals(expectedResult, actualResult);
		sa.assertAll();
	}


}
