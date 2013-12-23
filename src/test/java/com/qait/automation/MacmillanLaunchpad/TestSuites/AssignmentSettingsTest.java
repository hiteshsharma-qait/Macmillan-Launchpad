package com.qait.automation.MacmillanLaunchpad.TestSuites;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentSettingsTest {


	DataCentralLibrary dsl = new DataCentralLibrary();


	////////////////////////////////////////////////////////////////////////////////////////////////////////

	//@Test
	public void instructorCreatesCourseOnDashBoard(){
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



	@Test//(dependsOnMethods="instructorCreatesCourseOnDashBoard")
	public void assignmentScreenSettingsTc001314(){
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.instructorEditAssignmentScreenSettings());
		Assert.assertTrue(dsl.fillRequiredAssignmentInfoAndAssign(Utilities.getYamlValue("users.instructor.Quiz.points"),Utilities.getYamlValue("users.instructor.Quiz.points")));
		dsl.closeBrowser();
	}	



	@Test(dependsOnMethods="assignmentScreenSettingsTc001314")
	public void instructorEnterIntoCourseAndCreatesQuizAtHomePage(){
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.instructorStartedCreatingNewItemHomePage());
		Assert.assertTrue(dsl.verifyTemplatesAndAddQuiz(Utilities.getYamlValue("users.instructor.Quiz.otherQuiz")));
	}

	@Test(dependsOnMethods="instructorEnterIntoCourseAndCreatesQuizAtHomePage")
	public void instructorEnterIntoQuizAndChangeTimeLimit(){
		Assert.assertTrue(dsl.instructorEnterQuizAndChangeTimeLimit());
	}

	@Test(dependsOnMethods="instructorEnterIntoQuizAndChangeTimeLimit")
	public void instructorEnterIntoQuizAndChangeQuizAttempts(){
		Assert.assertTrue(dsl.instructorEnterQuizAndChangeQuizAttempts());
	}

	@Test(dependsOnMethods="instructorEnterIntoQuizAndChangeQuizAttempts")
	public void instructorEnterIntoQuizAndChangeScoredAttempts(){
		Assert.assertTrue(dsl.instructorEnterQuizAndChangeScoredAttempts());
	}

	@Test(dependsOnMethods="instructorEnterIntoQuizAndChangeScoredAttempts")
	public void instructorEnterIntoQuizAndChangeQuizSettingsRandomize(){
		Assert.assertTrue(dsl.instructorEnterQuizAndChangeQuizSettingsRandomize());
	}


	@Test(dependsOnMethods="instructorEnterIntoQuizAndChangeQuizSettingsRandomize")
	public void instructorSetDueDateForEntire(){
		Assert.assertTrue(dsl.instructorSetDueDateQuizEntire(Utilities.getYamlValue("users.instructor.Quiz.dueDate")));
	}
	
	@Test(dependsOnMethods="instructorSetDueDateForEntire")
	public void instructorUnassignQuiz(){
		Assert.assertTrue(dsl.instructorStartedCreatingNewItemHomePage());
		Assert.assertTrue(dsl.verifyTemplatesAndAddQuiz(Utilities.getYamlValue("users.instructor.Quiz.otherQuiz")));
		Assert.assertTrue(dsl.instructorAssignAndUnassignQuiz(Utilities.getYamlValue("users.instructor.Quiz.dueDate")));
		Assert.assertTrue(dsl.instructorSetDueDateQuizEntire(Utilities.getYamlValue("users.instructor.Quiz.dueDate")));
	}
	

	@Test(dependsOnMethods="instructorUnassignQuiz")
	public void enterTheSameCourseAsAStudent(){
		dsl.copyTheActivatedURLForTheCourse();
		Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")),"Browser does not load for student login after instructor logs out");
		dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name3"),Utilities.getYamlValue("users.student.password"));
		//Assert.assertTrue(dsl.clickEnterCourse(),"Enter course is not executed");
	}


	@Test(dependsOnMethods="enterTheSameCourseAsAStudent")
	public void studentVerifyTheLimitsAssignedByInstructor() {
		dsl.VerifyTimeLimitOfQuiz();
		dsl.VerifyNumberOfQuizAttempts();
		dsl.VerifyTypeOfScoreOfQuiz();
	}



	//@AfterClass(alwaysRun = true)
	public void browserClose(){
		dsl.exitBrowser();
	}

}
