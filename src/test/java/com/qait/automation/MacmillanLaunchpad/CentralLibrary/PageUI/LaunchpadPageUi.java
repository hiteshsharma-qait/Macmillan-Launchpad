package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;

import com.qait.automation.MacmillanLaunchpad.Utils.DateUtil;


public class LaunchpadPageUi extends CommonMethods {

	public WebDriver driver;
	static String randomNum;
	@FindBy(className = "my-courses")
	WebElement pageHeading;
	@FindBy(id = "createcourseoption")
	WebElement createCourseLink;
	@FindBy(css = "#CreateDashBoardCourseOptionHeader>h1")
	WebElement createCourseDialogHeading;
	@FindBy(css = "[class$=courseoption-dialog-buttonset]>button:first-child")
	WebElement createCourseFirstDialogNextButton;
	@FindBy(css = "[class$=courseoption-dialog-buttonset]>button:last-child")
	WebElement createCourseFirstDialogCancelButton;
	@FindBy(css = ".pxactivatecourse-dialog-buttonset>button:first-child")
	WebElement activateCourseFirstDialogButton;
	@FindBy(css = "#dashboard-course-item+div button:first-child")
	WebElement dialogOverlayFirstButton;
	@FindBy(css = "#dashboard-course-item+div button:last-child")
	WebElement dialogOverlaySecondButton;
	@FindBy(css = ".dashboardgrid tr:first-child .course-title")
	WebElement firstCourseTitle;
	@FindBy(css = ".dashboardgrid tr:first-child .course-url")
	WebElement firstCourseURL;
	@FindBy(id = "course-title")
	WebElement courseTitleInput;
	@FindBy(id = "school-name")
	WebElement schoolNameInput;
	@FindBy(id = ".ui-corner-all>li:first-child>a")
	WebElement firstSchoolName;
	@FindBy(id = "academicTerm")
	WebElement academicTermInput;
	@FindBy(id = "courseTimeZone")
	WebElement timeZoneInput;
	@FindBy(id = "instructor-name")
	WebElement instructorNameInput;
	@FindBy(id = "instructor-name")
	WebElement instructrNameInput;
	@FindBy(css = ".dashboard-labels[for=instructor-name]")
	WebElement instructorRubric;
	@FindBy(css = ".dashboard-labels[for=course-number]")
	WebElement courseNumberRubric;
	@FindBy(css = ".dashboard-labels[for=section-number]")
	WebElement sectionNumberRubric;
	@FindBy(id = "course-number")
	WebElement courseNumberInput;
	@FindBy(id = "section-number")
	WebElement sectionNumberInput;
	@FindBy(css = ".dashboardgrid tr:first-child .activate-dashboard-course")
	WebElement activateCourseLink;
	@FindBy(css = "#dashboard-course-item h1.pre-activation")
	WebElement activateCoursePreHeading;
	@FindBy(css = "#dashboard-course-item h1.post-activation")
	WebElement activateCoursePostHeading;
	@FindBy(css = "#dashboard-course-item #DeactivateDashBoardCourseHeader>h1")
	WebElement deactivateCourseHeading;
	@FindBy(css = "#dashboard-course-item #DeleteDashBoardCourseHeader>h1")
	WebElement deleteCourseHeading;
	@FindBy(css = "[class$=pxactivatecourse-dialog-buttonset]>button:last-child")
	WebElement activateCourseSecondDialogButton;
	@FindBy(css = ".dashboardgrid tr:first-child  .deactivate-dashboard-course")
	WebElement deactivateCourseLink;
	@FindBy(className = "student-find-course-header")
	WebElement studentFormHeading;
	@FindBy(css = ".dashboardgrid tr:first-child .domain-name")
	WebElement firstCourseSchool;
	@FindBy(css = ".dashboardgrid tr:first-child .semester")
	WebElement firstCourseTerm;
	@FindBy(css = ".dashboardgrid tr:first-child .professor-name")
	WebElement firstCourseInstructor;
	@FindBy(id = "courseoptionyes")
	WebElement radioButtonYes;
	@FindBy(id = "courseoptionno")
	WebElement radioButtonNo;
	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	WebElement logoutButton;
	@FindBy(css = "#CreateCourseOption .dashboardgrid")
	WebElement selectCourseOptionsDashboard;
	@FindBy(css = ".parent-course.selected")
	WebElement courseSelectedOption;
	@FindBy(css = "#CreateCourseOption .dashboardgrid tr:first-child .course-title")
	WebElement courseTitleSelectOverlay;
	@FindBy(css = ".dashboardgrid tr:first-child .delete-dashboard-course")
	WebElement deleteFirstCourseLink;
	String copyCourseOverlayCss = "#dashboard-course-item .course-title";
	String allCOurses = ".dashboardgrid tr .course-title";
	String availableCOursesName = ".dashboardgrid tr:nth-child(%) .course-title";
	String availableCOursesDeleteButton = ".dashboardgrid tr:nth-child(%) .course-title~div  .delete-dashboard-course";
	@FindBy(id = "PX_MENU_ITEM_LAUNCHPAD")
	WebElement menuItemLaunchpad;

	public LaunchpadPageUi(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean urlContains(String title) {
		waitForElementToLoad(pageHeading, waitForElementInMilliSeconds);
		return driver.getCurrentUrl().contains(title);
	}

	public boolean studentEnrollFormHeading(String heading) {
		return studentFormHeading.getText().trim().contains(heading);
	}

	public boolean getHeading(String heading) {
		waitForElementToLoad(pageHeading, waitForElementInMilliSeconds);
		return pageHeading.getText().contains(heading);
	}

	public void clickOnCreateCourse() {
		//waitForSync(50000);
		waitForElementToLoad(createCourseLink, waitForElementInMilliSeconds);
		waitForSync(5000);
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + createCourseLink.getLocation().y + ")");
		click(createCourseLink);
	}

	public boolean createCoursePopUpIsDisplayed() {
		waitForSync();
		return createCourseDialogHeading.getText().trim().equalsIgnoreCase("Create Course");
	}

	public boolean radioButtonOptionsWithNoSelectedAsDefault() {
		return radioButtonYes.isDisplayed() && radioButtonNo.isDisplayed() && radioButtonNo.isSelected();
	}

	public boolean cancelAndNextButtonsDisplayed() {
		return createCourseFirstDialogNextButton.isDisplayed() && createCourseFirstDialogCancelButton.isDisplayed();
	}

	public void selectYesRadioOpton() {
		click(radioButtonYes);
		waitForElementToLoad(selectCourseOptionsDashboard, waitForElementInMilliSeconds);
	}

	public boolean iscourseOptionDisplayed() {
		return selectCourseOptionsDashboard.isDisplayed();
	}

	public boolean isFirstOptionSelected() {
		return courseSelectedOption.isDisplayed();
	}

	public void selectFirstCourse() {
		click(courseTitleSelectOverlay);
	}

	public boolean createCourseOptionsDisplayed() {
		boolean allFields, optionalFields, buttons;
		waitForSync();
		allFields = courseTitleInput.isDisplayed() && schoolNameInput.isDisplayed() && timeZoneInput.isDisplayed() && academicTermInput.isDisplayed() && courseNumberInput.isDisplayed() && sectionNumberInput.isDisplayed() && instructorNameInput.isDisplayed();
		optionalFields = courseNumberRubric.getText().contains("optional") && sectionNumberRubric.getText().contains("optional") && instructorRubric.getText().contains("optional");
		buttons = dialogOverlayFirstButton.isEnabled() && dialogOverlaySecondButton.isEnabled();
		return allFields && optionalFields && buttons;
	}

	public void clickNextButton() {
//		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('ui-button')[0].getElementsByClassName('courseoption-dialog-next')[0]);");
//			((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + createCourseFirstDialogNextButton.getLocation().y + ")");
			click(createCourseFirstDialogNextButton);
	}

	public void enterCourseTitle(String title) {
		
		//workAround************************************
		waitForSync(1000);
		click(driver.findElement(By.id("school-name")));
		waitForSync(500);
		click(driver.findElement(By.xpath("//li[@class='ui-menu-item'][1]/a")));
		waitForSync(500);
		//************************************
		if (!courseTitleInput.isDisplayed()) {
			waitForElementToLoad(courseTitleInput, waitForElementInMilliSeconds);
		}
		randomNum = DateUtil.getCurrentDateTime();
		courseTitleInput.clear();
		waitForSync(500);
		courseTitleInput.sendKeys(title.replace("_DDMMM_HHMM", randomNum));
		waitForSync(4000);
	}

	public void enterSchoolName() {
		schoolNameInput.clear();
		click(schoolNameInput);
		schoolNameInput.sendKeys("Brooklyn Friends School");
		waitForSync();
	}

	public void clickCreateButton() {
		click(activateCourseFirstDialogButton);
		waitForSync();
	}

	public boolean verifyNewCourseIsDisplayedOnDashboard(String courseName) {
		waitForSync();
		setCourseTitle();
		setInstructorName();
		setSchoolName();
		setTerm();
		return firstCourseTitle.getText().trim().equalsIgnoreCase(courseName.replace("_DDMMM_HHMM", randomNum));
	}

	public void clickActivateCourse() {
		driver.navigate().refresh();
		waitForSync();
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activateCourseLink);
//		waitForSync(1000);
		click(activateCourseLink);
	}

	public boolean activateCoursePopUpAppears(String activateCourse) {
		waitForSync();
		return activateCoursePreHeading.getText().trim().equalsIgnoreCase(activateCourse);
	}

	public void clickActivateCourseButton() {
		waitForElementToLoad(dialogOverlayFirstButton, waitForElementInMilliSeconds);
		waitForSync();
		click(dialogOverlayFirstButton);
	}

	public boolean courseActivatedSuccessPopUpAppears(String activateCourse) {
		waitForSync();
		return activateCoursePostHeading.getText().trim().equalsIgnoreCase(activateCourse);
	}

	public void clickDoneButton() {
		click(activateCourseSecondDialogButton);
	}

	public boolean deactivateLinkAppears(String linkText) {
		waitForSync();
		return deactivateCourseLink.isDisplayed() && deactivateCourseLink.getText().trim().equalsIgnoreCase(linkText);
	}

	public void clickDeactivateLink() {
		waitForSync(500);
		click(deactivateCourseLink);
		waitForSync(500);
	}

	public boolean deactivateCourseDialogAppears(String text) {
		return deactivateCourseHeading.getText().equalsIgnoreCase(text) && dialogOverlayFirstButton.isDisplayed() && dialogOverlaySecondButton.isDisplayed();
	}

	public void clickDeactivateDialogButton() {
		click(dialogOverlayFirstButton);
		waitForSync();
	}

	public boolean actiavteCourseLinkAppears() {
		return activateCourseLink.isDisplayed();
	}

	public void clickFirstTitle() {
		// waitForElementToLoad(firstCourseTitle, waitForElementInMilliSeconds);
		waitForSync(5000);
		click(firstCourseTitle);
	}

	public boolean enrollurlContains(String title) {
		waitForElementToLoad(studentFormHeading, waitForElementInMilliSeconds);
		return driver.getCurrentUrl().contains(title);
	}

	public void setCourseTitle() {
		courseValue = firstCourseTitle.getText().trim();
		System.out.println("Created Course Name: " + courseValue);
	}

	public void setCourseUrl() {
		courseURL = firstCourseURL.getText().trim();
		System.out.println("Created Course URL: " + courseURL);
	}

	public void setSchoolName() {
		schoolName = firstCourseSchool.getText().trim();
		System.out.println("Captured School Name: " + schoolName);
	}

	public void setTerm() {
		termValue = firstCourseTerm.getText().trim();
		System.out.println("Captured Term Value: " + termValue);
	}

	public void setInstructorName() {
		try {
			String[] professor = firstCourseInstructor.getText().trim().split(" ");
			instructorName = professor[2] + ", " + professor[0] + " " + professor[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			instructorName = firstCourseInstructor.getText().trim();
		}
		System.out.println("Captured Instructor Name: " + instructorName);
	}

	public void clickLogout() {
		waitForElementToLoad(menuItemLaunchpad, 5000);
		try{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutButton);
			click(logoutButton);
		}
		catch(Exception e){
			//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + logoutButton.getLocation().y + ")");
			((JavascriptExecutor) driver).executeScript("document.getElementById('student-login').childNodes[0].click()");
		}
		
		
		waitForSync();
		// waitForElementToLoad(driver.findElement(By.className("course-title-lable-text")),
		// waitForElementInMilliSeconds);
		// return
		// driver.findElement(By.className("course-title-lable-text")).getText().trim().contains("LaunchPad");
	}

	public String getCourseUrl() {
		System.out.println("\ncurrent:-"+courseURL+"\n");
		if (courseURL != null) {
			System.out.println("\nsec:-"+courseURL+"\n");
			return courseURL;
		} else {
			setCourseUrl();
		}
		return courseURL;
	}

	public void deleteTopCourse() {
		driver.navigate().refresh();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteFirstCourseLink);
		waitForSync();
		click(deleteFirstCourseLink);
		waitForSync();
	}

	public boolean deleteOverlayAppears(String text) {
		waitForElementToLoad(deleteCourseHeading, waitForElementInMilliSeconds);
		return deleteCourseHeading.getText().equalsIgnoreCase(text) && dialogOverlayFirstButton.isEnabled() && dialogOverlaySecondButton.isEnabled();
	}

	public void clickDeleteButton() {
		waitForSync();
		click(driver.findElement(By.xpath("//span[@class='ui-button-text pxdeletecourse-dialog-delete']")));
		waitForSync();
	}

	public boolean verifyCourseIsDeleted() {
		String previousCourseTitle = courseValue;
		return !previousCourseTitle.equalsIgnoreCase(firstCourseURL.getText().trim());
	}

	public void deleteFirstAvailableCourse() {
		int i = 1;
		for (WebElement toDelete : driver.findElements(By.cssSelector(".dashboardgrid tr"))) {
			try {
				if (Integer.parseInt(driver.findElement(By.cssSelector(replaceString(".dashboardgrid tr:nth-child(%)  .enrollment-count-cell .right", i))).getText().split(" students")[0]) == 0) {
					courseValue = driver.findElement(By.cssSelector(replaceString(".dashboardgrid tr:nth-child(%) .course-title", i))).getText().trim();
					driver.findElement(By.cssSelector(replaceString(".dashboardgrid tr:nth-child(%) .delete-dashboard-course", i))).click();
					break;
				}
			} catch (Exception e) {
				i += 1;
			}
			i += 1;
		}
	}

	public void enterFirstCourseEnrolledByStudent() {
		int i = 1;
		waitForElementToLoad(firstCourseTitle, waitForElementInMilliSeconds);
		waitForSync();
		for (WebElement toClick : driver.findElements(By.cssSelector(".dashboardgrid tr"))) {
			try {
				if (Integer.parseInt(driver.findElement(By.cssSelector(replaceString(".dashboardgrid tr:nth-child(%)  .enrollment-count-cell .right", i))).getText().split(" students")[0]) > 0) {
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + driver.findElement(By.cssSelector(replaceString(".dashboardgrid tr:nth-child(%) .course-title", i))).getLocation().y + ")");
					driver.findElement(By.cssSelector(replaceString(".dashboardgrid tr:nth-child(%) .course-title", i))).click();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				i += 1;
			}
			i += 1;
		}
	}

	public void clickCanelButton() {
		click(dialogOverlaySecondButton);
		waitForSync();
	}

	public boolean verifyCourseIsNotDeleted() {
		return driver.findElement(By.linkText(courseValue)).isDisplayed();
	}

	public void enterIntoCourseByCourseName(String coursename) {
		waitForSync();
		waitForElementToLoad(createCourseLink, waitForElementInMilliSeconds);
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,300)");
//		waitForSync();
//		waitForElementToLoad(driver.findElement(By.linkText(coursename)), waitForElementInMilliSeconds);
		waitForSync();
		click(driver.findElement(By.linkText(coursename)));
	}

	public void selectBaseLinceCourseByCourseName(String courseName) {
		for (WebElement course : driver.findElements(By.cssSelector(copyCourseOverlayCss))) {
			if (course.getText().trim().equalsIgnoreCase(courseName)) {
				click(course);
			}
		}
		waitForSync();
	}

	public boolean verifyNewBaseLinedCourseIsDisplayedOnDashboard(String courseName) {
		waitForSync(5000);
		setCourseTitle();
		setInstructorName();
		setSchoolName();
		setTerm();
		setCourseUrl();
		LaunchpadHomeUi lhu = new LaunchpadHomeUi(driver);
		lhu.setCourseUrlNC();
		waitForElementToLoad(firstCourseTitle, waitForElementInMilliSeconds);
		return firstCourseTitle.getText().trim().equalsIgnoreCase(courseName);
	}

	public void deleteCourseByName(String courseName) {
		waitForElementToLoad(createCourseLink, waitForElementInMilliSeconds);
            	waitForSync();
		int noOfCourses = driver.findElements(By.cssSelector(allCOurses)).size();
		for (int i = 1; i <= noOfCourses; i++) {
			if (driver.findElement(By.cssSelector(replaceString(availableCOursesName, i))).getText().trim().equalsIgnoreCase(courseName)) {
				System.out.println(driver.findElement(By.cssSelector(replaceString(availableCOursesDeleteButton, i))).getText());
                                try{
				driver.findElement(By.cssSelector(replaceString(availableCOursesDeleteButton, i))).click();
                                waitForElementToLoad(deleteCourseHeading, 60000);
                                if (!deleteCourseHeading.isDisplayed()){
                                    ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('delete-dashboard-course')["+Integer.toString(i-1)+"].click()");
                                }
                                } catch (Exception e){
                                    ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('delete-dashboard-course')["+Integer.toString(i-1)+"].click()");
                                }
			}
		}
		waitForSync();
	}

	public boolean verifyCourseIsDeleted(String cname) {
		StringBuilder courses = new StringBuilder();
		for (WebElement course : driver.findElements(By.cssSelector(allCOurses))) {
			courses.append(course.getText().trim()).append(" ");
		}
		return courses.toString().toLowerCase().contains(cname.toLowerCase());
	}
}
