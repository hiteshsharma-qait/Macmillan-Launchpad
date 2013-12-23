package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;




public class CalendarPageUi extends CommonMethods{

	public WebDriver driver;

	@FindBy(css="[href*=list]")
	WebElement listViewLink;

	@FindBy(css="[href*=month]")
	WebElement monthViewLink;

	String contentsInCalendarxPath = "(//div[contains(@class,'fc-event-inner')])[%]";

	public CalendarPageUi(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

}
