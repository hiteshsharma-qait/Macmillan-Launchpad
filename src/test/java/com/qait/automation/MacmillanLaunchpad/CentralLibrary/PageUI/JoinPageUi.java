package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;




public class JoinPageUi extends CommonMethods{

	public WebDriver driver;

	@FindBy(className="course-greeting-header")
	WebElement courseGreeting;

	@FindBy(id="join-course-confirmation")
	WebElement joinCourseButton;

	public JoinPageUi(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public boolean validateCourseGreeting(String greeting){
		waitForElementToLoad(courseGreeting, waitForElementInMilliSeconds);
		return courseGreeting.getText().trim().contains(greeting);
	}

	public void clickJoinButton(){
		click(joinCourseButton);
	}



}
