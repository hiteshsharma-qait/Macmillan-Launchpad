package com.qait.automation.MacmillanLaunchpad.TestSuites;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchSuiteTest{

	DataCentralLibrary dsl = new DataCentralLibrary();


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
	public void returnQuestionsThatHaveLearningObjectiveMatchesTc001566() {
		dsl.setUp();
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.openTheResourcesOverlay("Instructor"));
		Assert.assertTrue(dsl.enterLearningObjectiveInTheSearchField("Learning Objectives"));
		dsl.clickOnResourceCloseButton();
	}

	@Test(dependsOnMethods="returnQuestionsThatHaveLearningObjectiveMatchesTc001566")
	public void searchForAvailableContentAndAvailableQuestionsTc001389() {
		Assert.assertTrue(dsl.openTheResourcesOverlayWhenSearchIsEmpty("Instructor"));
		Assert.assertTrue(dsl.userTypesASearchTermIntoTheSearchFieldAndPressesEnter("issues", "Instructor"));
		Assert.assertTrue(dsl.clickOnTheQuestions());
		dsl.copyTheActivatedURLForTheCourse();
		Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
		dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password"));
		//Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.openTheResourcesOverlay("Student"));
		Assert.assertTrue(dsl.userTypesASearchTermIntoTheSearchFieldAndPressesEnter("issues", "Student"));
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
