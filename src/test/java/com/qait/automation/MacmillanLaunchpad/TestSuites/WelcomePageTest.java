package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;



public class WelcomePageTest {

	DataCentralLibrary dsl= new DataCentralLibrary();


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
	}
	

	@Test(dependsOnMethods="instructorCreatesCourse")
	public void instructorAddsNewWidgetTc001150() {
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.verifyEditPageToAddWidget());
	}


	@Test(dependsOnMethods="instructorAddsNewWidgetTc001150")
	public void InstructordragAndDropWidget() {
		Assert.assertTrue(dsl.dragAndDropWidget());
	}


	@Test(dependsOnMethods="InstructordragAndDropWidget")
	public void instructorEditsWelcomePageTc001149() {
		Assert.assertTrue(dsl.renameCourse(Utilities.getYamlValue("portal.courseGroup4")));
	}

	
	@Test(dependsOnMethods="instructorEditsWelcomePageTc001149")
	public void instructorRemovesExistingWidgetTc001152(){
		Assert.assertTrue(dsl.verifyEditPageToRemoveWidget());
	}


	@Test(dependsOnMethods="instructorRemovesExistingWidgetTc001152")
	public void instructorNavigatesToBrowseMoreResourcesFromTheInstructorTc001336() {
		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.verifyViewInstructorConsole());
	}

	
	@Test(dependsOnMethods="instructorNavigatesToBrowseMoreResourcesFromTheInstructorTc001336")
	public void instructorEditsLaunchPadSettingsTc001208() {
		dsl.instructorAddRemoveLaunchpadUnits();
		Assert.assertTrue(dsl.instructorSelectAssignedAndUnassignedItems(Utilities.getYamlValue("users.instructor.editPageSettings.days"),Utilities.getYamlValue("users.instructor.editPageSettings.Category")));
	}

	
	//@Test(dependsOnMethods="instructorEditsLaunchPadSettingsTc001208")
	public void instructorOpensCalendarFromWelcomePageTc001153(){
		Assert.assertTrue(dsl.clickOnReturnToWindowButton());
		Assert.assertTrue(dsl.clickOnCalendarIcon());
		Assert.assertTrue(dsl.clickEnterCourse());
	}
	
	
	//@Test(dependsOnMethods="instructorOpensCalendarFromWelcomePageTc001153")
	public void updateAnyNumberOfExistingDueDatesSimultaneouslyUsingTheBatchDueDateUpdaterTc001575(){
		Assert.assertTrue(dsl.updateAnyNumberOfExistingDueDatesSimultaneouslyUsingTheBatchDueDateUpdater(Utilities.getYamlValue("users.instructor.Quiz.quizName"),Utilities.getYamlValue("users.instructor.Quiz.points")));
	}
	

	@Test(dependsOnMethods="instructorEditsLaunchPadSettingsTc001208")
	public void instructorBrowseResources(){
		Assert.assertTrue(dsl.verifyResources());
	}


	@Test(dependsOnMethods="instructorBrowseResources")
	public void welcomeInstructorEditANavigationSettings() {
		//Assert.assertTrue(dsl.verifyWelcomeScreenIsAvailable(dsl.courseName));
		Assert.assertTrue(dsl.intructorVerifyNavigationSettings());
		Assert.assertTrue(dsl.verifyWelcomeScreenIsNotAvailable(dsl.courseName));
	}
	

	@Test(dependsOnMethods="welcomeInstructorEditANavigationSettings")
	public void welcomeInstructorEditGeneralSettingsTc001206(){
		Assert.assertTrue(dsl.verifyInstructorEditGeneralPageSettings(Utilities.getYamlValue("portal.courseGroup4"),
				Utilities.getYamlValue("users.instructor.editPageSettings.courseNumber"),
				Utilities.getYamlValue("users.instructor.editPageSettings.sectionNumber"),
				Utilities.getYamlValue("users.instructor.editPageSettings.instructorName"),
				Utilities.getYamlValue("users.instructor.editPageSettings.officeHours")));
	}



	//@AfterClass(alwaysRun = true)
	public void browserClose(ITestResult result){
		dsl.closeBrowserTakeScreenshotOfFailure(result);
	}

}
