package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

public class SmokeTest {
	
	DataCentralLibrary dsl = new DataCentralLibrary();
	
	@Test
	public void instructorCreatesCourseOnDashBoardAndActivateIt(){
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
	}
	
	@Test(dependsOnMethods="instructorCreatesCourseOnDashBoardAndActivateIt")
	public void instructorCreateQuizAtHomePageAndAddQuestionsToTheSameQuiz(){
		Assert.assertTrue(dsl.instructorStartedCreatingNewItemHomePage());
		Assert.assertTrue(dsl.verifyTemplatesAndAddQuiz(Utilities.getYamlValue("users.instructor.Quiz.otherQuiz")));
	}
	
	@Test(dependsOnMethods="instructorCreateQuizAtHomePageAndAddQuestionsToTheSameQuiz")
	public void instructorSetDueDateForEntire(){
		Assert.assertTrue(dsl.instructorSetDueDateQuizEntire(Utilities.getYamlValue("users.instructor.Quiz.dueDate")));
	}
	
	@Test(dependsOnMethods="instructorSetDueDateForEntire")
	public void loginAsStudentAndJoinCourse(){
		dsl.copyTheActivatedURLForTheCourseNC();
		Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
		Assert.assertTrue(dsl.clickOnTheLogInButtonProvidedUnderStdudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password")));
		Assert.assertTrue(dsl.clickOnTheJoinCourse("Congratulations! You have successfully joined"));
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.closeBrowser();
	}

}
