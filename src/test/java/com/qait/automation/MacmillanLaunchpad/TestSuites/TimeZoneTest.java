package com.qait.automation.MacmillanLaunchpad.TestSuites;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TimeZoneTest{

	DataCentralLibrary dsl = new DataCentralLibrary();

	public void commonMethods() {
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void instructorCreatesCourse(){
		dsl.setUp();
		Assert.assertTrue(dsl.clickOnCreateCourseLink());
        Assert.assertTrue(dsl.clickOnNextButton());
        dsl.userCreatesNewbaselinedCourse(dsl.courseName);
        dsl.clickOnActivateCourseLink();
        Assert.assertTrue(dsl.validateActivateCoursePopUpIsDisplayedWithHeading("Activate this course?"));
        dsl.clickActivateButton();
        Assert.assertTrue(dsl.validateCourseSuccessfullyUpdatedPopUpIsDisplayedWithHeading("Course Activated!"));
        dsl.clickDoneButton();
        Assert.assertTrue(dsl.validateDeactivateLinkIsDisplayedOnceCourseActivates("Deactivate"));
        dsl.enterIntoCourseByCourseName(dsl.courseName);
        Assert.assertTrue(dsl.clickEnterCourse());
        dsl.copyTheActivatedURLForTheCourseNC();
        Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
        Assert.assertTrue(dsl.clickOnTheLogInButtonProvidedUnderStdudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password")));
        Assert.assertTrue(dsl.clickOnTheJoinCourse("Congratulations! You have successfully joined"));
        Assert.assertTrue(dsl.clickEnterCourse());
        dsl.closeBrowser();
	}

	@Test(dependsOnMethods="instructorCreatesCourse")
	public void changeTheTimeZoneOnCourseTc001579() {
		dsl.setUp();
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.clickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage());
		dsl.changeTheTimeZoneAndClickSave(Utilities.getYamlValue("users.instructor.TimeZoneOneAssignment"));
		dsl.fromTOCClickOnAnyChapter();
		dsl.assignAnyUnitsItemWithDueDate("TomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"));
		dsl.hoverOverTheDueDateIconAppearingAdjacentToContentItem("FirstAssign", "TomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"), Utilities.getYamlValue("users.instructor.TimeZoneOneVerify"));
		dsl.assignAnotherContentWithinSameChapterWithDueDate("DayAfterTomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"));
		dsl.verifyDateRangeIsDisplayed("TomorrowDate", "DayAfterTomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"), Utilities.getYamlValue("users.instructor.TimeZoneOneVerify"));
		dsl.clickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage();
		dsl.changeTheTimeZoneAndClickSave(Utilities.getYamlValue("users.instructor.TimeZoneTwoAssignment"));
		dsl.hoverOverTheDueDateIconAppearingAdjacentToContentItem("NextAssign", "DayToDayAfterTomorrowDate", Utilities.getYamlValue("users.instructor.ChangedTime"), Utilities.getYamlValue("users.instructor.TimeZoneTwoVerify"));
	}

	@Test(dependsOnMethods="changeTheTimeZoneOnCourseTc001579")
	public void ensureSubmissionTimeDisplayedShowsTheRightTimezoneTc001268() {
		Assert.assertTrue(dsl.clickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage());
		dsl.changeTheTimeZoneAndClickSave(Utilities.getYamlValue("users.instructor.TimeZoneThreeAssignment"));
		dsl.createAQuizAndAssignItToStudents("CurrentTimePlusMinutes2", Utilities.getYamlValue("users.instructor.TimeZoneThreeVerify"));
		dsl.copyTheActivatedURLForTheCourse();
		Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
		dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password"));
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.studentAttemptTheCreatedQuizVerifyQuizExpiredDisplayed(Utilities.getYamlValue("users.student.timeOutMessage"));
		dsl.closeBrowser();
	}

	//@Test(dependsOnMethods="ensureSubmissionTimeDisplayedShowsTheRightTimezoneTc001268")
	public void instructorAssignsDueDatesInSpecificTimeZoneTc001267() {
		dsl.setUp();
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.clickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage());
		dsl.changeTheTimeZoneAndClickSave(Utilities.getYamlValue("users.instructor.TimeZoneOneAssignment"));
		dsl.fromTOCClickOnAnyChapter();
		dsl.assignAnyUnitsItemWithDueDate("TomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"));
		Assert.assertTrue(dsl.hoverOverTheDueDateIconAppearingAdjacentToContentItem("FirstAssign", "TomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"), Utilities.getYamlValue("users.instructor.TimeZoneOneVerify")));
		dsl.assignAnotherContentWithinSameChapterWithDueDate("DayAfterTomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"));
		Assert.assertTrue(dsl.verifyDateRangeIsDisplayed("TomorrowDate", "DayAfterTomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"), Utilities.getYamlValue("users.instructor.TimeZoneOneVerify")));
		Assert.assertTrue(dsl.clickOnTheAssignedContentItem("NextAssign", "DayAfterTomorrowDate", Utilities.getYamlValue("users.instructor.FnEDefaultTimeVerifyPST")));
		dsl.moveBackToTheTOCAndClickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage();
		dsl.changeTheTimeZoneAndClickSave(Utilities.getYamlValue("users.instructor.TimeZoneTwoAssignment"));
		Assert.assertTrue(dsl.hoverOverTheDueDateIconAppearingAdjacentToContentItem("NextAssign", "DayToDayAfterTomorrowDate", Utilities.getYamlValue("users.instructor.ChangedTime"), Utilities.getYamlValue("users.instructor.TimeZoneTwoVerify")));
		Assert.assertTrue(dsl.clickOnTheAssignedContentItem("NextAssign", "DayToDayAfterTomorrowDate", Utilities.getYamlValue("users.instructor.FnEDefaultTimeVerifyIST")));
		
	}

	//@Test(dependsOnMethods="instructorAssignsDueDatesInSpecificTimeZoneTc001267")
	public void studentViewAssignmentsWithNewTimezoneTc001580() {
		commonMethods();
		Assert.assertTrue(dsl.clickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage());
		dsl.changeTheTimeZoneAndClickSave(Utilities.getYamlValue("users.instructor.TimeZoneOneAssignment"));
		dsl.fromTOCClickOnAnyChapter();
		dsl.assignAnyUnitsItemWithDueDate("TomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"));
		dsl.hoverOverTheDueDateIconAppearingAdjacentToContentItem("FirstAssign", "TomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"), Utilities.getYamlValue("users.instructor.TimeZoneOneVerify"));
		dsl.copyTheActivatedURLForTheCourse();
		Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
		dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password"));
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.clickAssignedCourseAndHoverOverTheDueDateIconAppearingAdjacentToContentItem("FirstAssign", "TomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"), Utilities.getYamlValue("users.instructor.TimeZoneOneVerify"));
		Assert.assertTrue(dsl.logOutAsStudentAndAgainBrowseTheCopiedURLForInstructor(Utilities.getYamlValue("browser")));
		if((Utilities.getYamlValue("browser")).equalsIgnoreCase("firefox")){
			dsl.clickLogInButtonProvidedUnderInstructorHeading(Utilities.getYamlValue("users.instructor.user_name_ff"), Utilities.getYamlValue("users.instructor.password"));
		}else if((Utilities.getYamlValue("browser")).equalsIgnoreCase("chrome")){
			dsl.clickLogInButtonProvidedUnderInstructorHeading(Utilities.getYamlValue("users.instructor.user_name_c"), Utilities.getYamlValue("users.instructor.password"));
		}else if((Utilities.getYamlValue("browser")).equalsIgnoreCase("ie")){
			dsl.clickLogInButtonProvidedUnderInstructorHeading(Utilities.getYamlValue("users.instructor.user_name_ie"), Utilities.getYamlValue("users.instructor.password"));
		}else{
			dsl.clickLogInButtonProvidedUnderInstructorHeading(Utilities.getYamlValue("users.instructor.user_name_safari"), Utilities.getYamlValue("users.instructor.password"));
		}

		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.clickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage());
		dsl.changeTheTimeZoneAndClickSave(Utilities.getYamlValue("users.instructor.TimeZoneTwoAssignment"));
		Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
		dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password"));
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.clickAssignedCourseAndHoverOverTheDueDateIconAppearingAdjacentToContentItem("FirstAssign", "DayAfterTomorrowDate", Utilities.getYamlValue("users.instructor.ChangedTime"), Utilities.getYamlValue("users.instructor.TimeZoneTwoVerify"));
		dsl.closeBrowser();
	}
	
    //@Test(priority=4)
    public void deleteSampleCOurseOne() {
        dsl.setUp();
        dsl.deleteSampleCourses("TestAutomationCourseCreation");
    }

	//@AfterClass
	public void browserClose(ITestResult result){
		dsl.closeBrowserTakeScreenshotOfFailure(result);
	}

}
