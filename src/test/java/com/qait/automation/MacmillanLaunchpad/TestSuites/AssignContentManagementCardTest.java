package com.qait.automation.MacmillanLaunchpad.TestSuites;


import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignContentManagementCardTest {


	DataCentralLibrary dsl= new DataCentralLibrary();

	public void commonMethod() {
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
	}

	@Test(dependsOnMethods="instructorCreatesCourse")
	public void instructorEnterCourseAndClickOnAnyChapter() {
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.fromTOCClickOnAnyChapter(); 
	}

	@Test(dependsOnMethods="instructorEnterCourseAndClickOnAnyChapter")
	public void instructorMoveOrCopyContent(){
		dsl.hoversOverAContentItemAndClicksTheGear();
		Assert.assertTrue(dsl.clickOnTheMoveOrCopy());
		dsl.instructorChoosesAUnitOrFolderAndClickMove();
		//dsl.closeBrowser();
	}

	@Test(dependsOnMethods="instructorMoveOrCopyContent")
	public void assignUnitFolderOrContentItemTc001311() {

		//commonMethod();
		dsl.fromTOCClickOnAnyChapter();
		dsl.hoversOverAContentItemAndClicksTheGear();
		dsl.assignContent("TomorrowDate", Utilities.getYamlValue("users.instructor.DefaultTime"));
	}

	//@Test(priority=4)
	public void unassignUnitFolderOrContentItemTc001315() {
		commonMethod();
		dsl.hoverOverAnyAssignedContentChapter();
		dsl.instructorClickOnUnassignButton();
		dsl.closeBrowser();
	}

	//@Test(priority=4)
	public void deleteSampleCOurseOne() {
		dsl.setUp();
		dsl.deleteSampleCourses("TestAutomationCourseCreation");
	}

	@AfterClass(alwaysRun = true)
	public void browserClose(){
		dsl.exitBrowser();
	}
}
