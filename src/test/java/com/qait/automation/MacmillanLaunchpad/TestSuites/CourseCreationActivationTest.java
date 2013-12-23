/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;


public class CourseCreationActivationTest{

	DataCentralLibrary dsl = new DataCentralLibrary();


	@Test
	public void instructorEntersDetailsAndCreatesCourse() {
		dsl.setUp();
		Assert.assertTrue(dsl.clickOnCreateCourseLink());
		Assert.assertTrue(dsl.clickOnNextButton());
		Assert.assertTrue(dsl.enterTheRequiredDetailsInCreateCourseOverlayAndClickOnCreateButton(Utilities.getYamlValue("users.instructor.courseName")));
	}

	@Test(dependsOnMethods="instructorEntersDetailsAndCreatesCourse")
	public void inteructorEnterIntoExistingCourseAndActivateit(){
		dsl.clickOnAnyCourseAppearingInTheMyCoursePage();
		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.clickOnTheActivateYourCourseLinkFromTheRightHandWidget());
		Assert.assertTrue(dsl.confirmDetailsAndClickOnSubmit());
		Assert.assertTrue(dsl.clickOnOkButton());
	}

	@Test(dependsOnMethods="inteructorEnterIntoExistingCourseAndActivateit")
	public void loginAsStudentAndTakeEnrollment(){
		dsl.copyTheActivatedURLForTheCourse();
		Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
		Assert.assertTrue(dsl.clickOnTheLogInButtonProvidedUnderStdudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password")));
		Assert.assertTrue(dsl.clickOnTheJoinCourse("Congratulations! You have successfully joined"));
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.closeBrowser();
	}



	@Test(dependsOnMethods="loginAsStudentAndTakeEnrollment")
	public void instructorCreatesCourseBasedOnAnExistingCourseTc001274() {
		dsl.setUp();
		Assert.assertTrue(dsl.clickOnCreateCourseLink());
		Assert.assertTrue(dsl.selectYesRadioButton());
		Assert.assertTrue(dsl.userSelectsTheCourseFromWhichToBaseTheNewCourse());
		Assert.assertTrue(dsl.clickOnNextButton());
		dsl.userMadeChangesWithTheFieldsOnTheModalAndClickOnCreateButton(Utilities.getYamlValue("users.instructor.courseName"));
	}


	@Test(dependsOnMethods="instructorCreatesCourseBasedOnAnExistingCourseTc001274")
	public void instructorActivatesCourse(){
		dsl.clickOnAnyCourseAppearingInTheMyCoursePage();
		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.clickOnTheActivateYourCourseLinkFromTheRightHandWidget());
		Assert.assertTrue(dsl.confirmDetailsAndClickOnSubmit());
		Assert.assertTrue(dsl.clickOnOkButton());
		Assert.assertTrue(dsl.chooseViewMyCourseOptionFromTheDropdownPresentOnTheRightHandSideOfTheHomePage());
	}


	@Test(dependsOnMethods="instructorActivatesCourse")
	public void instructorDeactivatesCourse() {
		Assert.assertTrue(dsl.findTheInstructorCreatedCourseAndClickOnDeactivateLink("Deactivate this course?"));
		Assert.assertTrue(dsl.instructorClickOnDeactivateButton());
	}

	@Test(dependsOnMethods="instructorDeactivatesCourse")
	public void instructorDeletesCourseTc001275() {
		Assert.assertTrue(dsl.onMyCoursePageClickOnDeleteLinkForCreatedCourse("Delete this course?"));
		Assert.assertTrue(dsl.instructorClickOnDeleteButton());
		Assert.assertTrue(dsl.instructorAgainClicksDeleteLinkForAnyCourse("Delete this course?"));
		Assert.assertTrue(dsl.instructorClickOnCancelButton());
		dsl.closeBrowser();
	}


	@AfterClass(alwaysRun = true)
	public void browserClose(){
		dsl.exitBrowser();
	}
}
