package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;




public class TopicPageUi extends CommonMethods{

	public WebDriver driver;

	@FindBy(id="fne-unblock-action-home")
	WebElement homePageButton;

	public TopicPageUi(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public boolean getPageTitle(){
		waitForSync();
		return driver.getTitle().trim().equals(selectedTopic);
	}

	public void clickHomePageLink(){
		click(homePageButton);
	}

}
