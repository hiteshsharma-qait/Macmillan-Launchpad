package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;




public class ConfirmationPageUi extends CommonMethods{

	public WebDriver driver;

	@FindBy(className="confirmation-header")
	WebElement confirmationHeader;

	@FindBy(css=".url-bookmark-message a")
	WebElement courseLink;

	public ConfirmationPageUi(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public boolean validateConfirmationMessage(String message){
		waitForElementToLoad(confirmationHeader, waitForElementInMilliSeconds);
		return confirmationHeader.getText().trim().contains(message);
	}

	public void clickCourseLink(){
		click(courseLink);
		waitForSync();
	}

}
