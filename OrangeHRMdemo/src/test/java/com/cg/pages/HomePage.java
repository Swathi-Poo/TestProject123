package com.cg.pages;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cg.base.TestBase;

public class HomePage extends TestBase {
	
	//private SoftAssertions sa = new SoftAssertions();
	
	
	private @FindBy(id = "txtUsername") WebElement username;
	private @FindBy(id = "txtPassword") WebElement password;
	private @FindBy(id = "btnLogin") WebElement submit;
	private @FindBy(id = "menu_leave_viewLeaveModule") WebElement LeaveMenu;
	private @FindBy(id = "menu_leave_Reports") WebElement ReportsMenu;
	private @FindBy(id = "menu_leave_viewLeaveBalanceReport") WebElement submenu;
	private @FindBy(id = "leave_balance_report_type") WebElement select;
	private @FindBy(id = "viewBtn") WebElement view;
	private @FindBy(className = "firstLevelMenu") List<WebElement> list;
	//private @FindBy(xpath = "//span[@class='quickLinkText']") List<WebElement> list1;
	//private @FindBy(className = "arrow") List<WebElement> list1;
	

	public HomePage()
	{
		init();
		PageFactory.initElements(driver, this);
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
	
	public void Leave()
	{
		
		action.moveToElement(LeaveMenu).build().perform();
	}
	
	public void SubMenu()
	{
		
		action.moveToElement(ReportsMenu).build().perform();
		submenu.click();
		
	}
	
	public void SelectClass()
	{
		Select dropdown = new Select(select);
		dropdown.selectByIndex(1);
		view.click();
		
	}
	
	public void Links()
	{
		List<WebElement> links = list;
		int i = links.size();
		System.out.println(i);
		
		for(int j=1;j<i;j++)
		{
			System.out.println(links.get(j).getText());
			String openTabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			links.get(j).sendKeys(openTabs);
			
		}
		
		
	}
	
	/*public void Links1()
	{
		List<WebElement> links1 = list1;
		int i = links1.size();
		System.out.println(i);
		
		for(int j=1;j<i;j++)
		{
			System.out.println(links1.get(j).getText());
			String openTabs1 = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			links1.get(j).sendKeys(openTabs1);
			
		}*/
	}
	
	
	
