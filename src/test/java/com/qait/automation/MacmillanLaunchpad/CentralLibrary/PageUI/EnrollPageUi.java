package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;




public class EnrollPageUi extends CommonMethods{

	public WebDriver driver;

	@FindBy(id="domain")
	WebElement schoolDropdown;

	@FindBy(id="terms")
	WebElement academicTermDropdown;

	@FindBy(id="instructors")
	WebElement instructorDropdown;

	@FindBy(id="courses")
	WebElement courseSelectBox;

	@FindBy(id="find-continue-button")
	WebElement continueButton;

	public EnrollPageUi(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public void selectSchool(){
		waitForSync();
		Select school = new Select(schoolDropdown);
		school.selectByVisibleText(getSchoolValue());
	}

	public void selectTerm(){
		waitForSync();
		waitForElementToEnable(academicTermDropdown, 10000);
		Select term = new Select(academicTermDropdown);
		term.selectByVisibleText(getTermValue());
	}

	public void selectInstructor(){
		waitForSync();
		waitForElementToEnable(instructorDropdown, 10000);
		Select instructor = new Select(instructorDropdown);
		instructor.selectByVisibleText(getInstructorName());
	}

	public void selectCourse(){
		waitForSync();
		waitForElementToEnable(courseSelectBox, 10000);
		Select course = new Select(courseSelectBox);
		course.selectByVisibleText(getCourseName());
	}

	public void clickContinueButton(){
		continueButton.click();
	}

	private String getSchoolValue() {
		System.out.println("\nSelected school name by student: "+schoolName);
		return schoolName;
	}

	private String getTermValue() {
		System.out.println("Selected term value by student: "+termValue);
		return termValue;
	}

	private String getInstructorName() {
		System.out.println("Selected instructor name by student: "+instructorName);
		return instructorName;
	}

	private String getCourseName() {
		System.out.println("Selected course value by student: "+courseValue);
		return courseValue;
	}

}
