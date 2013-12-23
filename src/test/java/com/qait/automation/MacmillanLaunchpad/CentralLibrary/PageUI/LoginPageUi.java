package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;





public class LoginPageUi extends CommonMethods
{
	public WebDriver driver;	

	public LoginPageUi(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}
	//Initialize  Elements
	@FindBy(id="EMail")
	WebElement email;

	@FindBy(id="Password")
	WebElement password;

	@FindBy(id="Bfw_MARS_login_GO")
	WebElement signIn;

	@FindBy(id="logOut")
	WebElement logOut;

	@FindBy(css=".instructor-links .ecom-btns[href$=Login]")
	WebElement instructorLogin;

	@FindBy(xpath=".//*[@id='ecommerce-action-bar']/div/div[1]/a[1]")
	WebElement studentLogin;


	public void loginAsInstructor() {
		click(instructorLogin);
		waitForSync();
	}

	public void loginAsStudent() {
		//waitForSync();
		click(studentLogin);
		waitForSync();
	}

	public void typeUserEmail(String userName) 
	{
		waitForSync();
		email.clear();
		email.sendKeys(userName);
	}

	public void typePassword(String pass) 
	{
		password.clear();
		password.sendKeys(pass);
	}

	public void clickLoginButton() 
	{
		click(signIn);
		waitForSync();
	}

	public void logOut()
	{
		click(logOut);
	}	 



}
