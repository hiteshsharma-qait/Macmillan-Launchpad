package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

public class QuestionPlayerTest{

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
	public void inProgressQuizAttemptIsAutosubmittedOnceDueDateAndGracePeriodExpiresTc001597(){
		dsl.setUp();
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.createAndSaveNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		dsl.quizIsAutoSubmittedOncePeriodExpires(2,Utilities.getYamlValue("users.instructor.Quiz.points"));
		//Assert.assertTrue(dsl.studentAttemptsAndSaveQuiz(),"Student does not answers or save quiz is not executed");
	}

	@Test(dependsOnMethods="inProgressQuizAttemptIsAutosubmittedOnceDueDateAndGracePeriodExpiresTc001597")
	public void saveProgressOnCurrentQuizAttemptTc001595(){
		dsl.createAndSaveNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		dsl.instructorSaveQuiz(2,Utilities.getYamlValue("users.instructor.Quiz.points"));
	}

	@Test(dependsOnMethods="saveProgressOnCurrentQuizAttemptTc001595")
	public void quizDisplaysEachQuestionOnSeparatePagesTc001593(){
		
		dsl.instructorAddsNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		dsl.addQuestionsInTheQuizForSeparatePages(1,Utilities.getYamlValue("users.instructor.Quiz.points"));
	}

	@Test(dependsOnMethods="quizDisplaysEachQuestionOnSeparatePagesTc001593")
	public void quizDisplaysAllQuestionsOnAsinglePageTc001592(){
		dsl.instructorAddsNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		dsl.addQuestionsInTheQuizForSinglePage(2,Utilities.getYamlValue("users.instructor.Quiz.points"));
		Assert.assertTrue(dsl.loginAsStudentAndEnterTheCourse(Utilities.getYamlValue("browser"),Utilities.getYamlValue("users.student.user_name3"),Utilities.getYamlValue("users.student.password")));
		Assert.assertTrue(dsl.studentAttemptsAndSaveQuiz(),"Student does not answers or save quiz is not executed");
		dsl.closeBrowser();
	}



	@Test(dependsOnMethods="quizDisplaysAllQuestionsOnAsinglePageTc001592")
	public void previewHomeworkQuizInStudentViewTc001599(){
		commonMethods();
		
		Assert.assertTrue(dsl.previewQuizInStudentView(),"Execution Failed when instructor attempts quiz in student view");
	}

//	@Test(dependsOnMethods="previewHomeworkQuizInStudentViewTc001599")
//	public void printQuizAsItWillAppearsToStudent(){
//		dsl.createAndSaveNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
//		Assert.assertTrue(dsl.printQuizAsItAppearsToStudent(2,Utilities.getYamlValue("users.instructor.Quiz.points")),"Printing of quiz is not executed");
//	}



	@Test(dependsOnMethods="previewHomeworkQuizInStudentViewTc001599")
	public void QuizTimerDisplaysShouldDisplayInPlayerTc001594(){

		dsl.createAndSaveNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		dsl.addTheQuestionFromEditTab(2,Utilities.getYamlValue("users.instructor.Quiz.points"));
		Assert.assertTrue(dsl.loginAsStudentAndEnterTheCourse(Utilities.getYamlValue("browser"),Utilities.getYamlValue("users.student.user_name3"),Utilities.getYamlValue("users.student.password")));
		Assert.assertTrue(dsl.studentAttemptsQuizAndCheckForTimerAvailability(),"Student does not answers or submit quiz is not executed");
		dsl.navigateBackToTopicPage();
		dsl.closeBrowser();
	}


	public void userIsNavigatedToTheNextQuestionInTheHomeworkTc001598(){
		//covered in question editor Picker
	}


	//@AfterClass(alwaysRun = true)
	public void browserClose(){
		dsl.exitBrowser();
	}
}
