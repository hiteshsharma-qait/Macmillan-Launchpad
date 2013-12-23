package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;


public class GradebookTest{

	DataCentralLibrary dsl = new DataCentralLibrary();


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
	public void instructorEnterIntoCourseAndCreatesQuizAtHomePage(){
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.createSaveAndAssignNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"),Utilities.getYamlValue("users.instructor.Quiz.points"));
	}

	@Test(dependsOnMethods="instructorEnterIntoCourseAndCreatesQuizAtHomePage")
	public void instructorViewsTheCourseCompletionPercentageTc001653(){
		Assert.assertTrue(dsl.clickOnGradebookButtonPresentInsideInstructorConsoleWidget(),"Gradebook page can not be opened from the instructor home");
		Assert.assertTrue(dsl.checkingCompleteButton(),"Check for 'Complete' Button is not executed");
	}

	@Test(dependsOnMethods="instructorViewsTheCourseCompletionPercentageTc001653")
	public void verifyMinutColumnIsEmptyForInstructor(){
		Assert.assertTrue(dsl.clickOnGradebookButtonPresentInsideInstructorConsoleWidget(),"Gradebook page can not be opened from the instructor home");
		Assert.assertTrue(dsl.minuteColumnIsVisible(),"Check for 'Minute' column visible is not executed");
		dsl.navigateBackToTopicPage();
	}

	@Test(dependsOnMethods="verifyMinutColumnIsEmptyForInstructor")
	public void loginAsStudentAndAttemptTheQuiz(){
		Assert.assertTrue(dsl.loginAsStudentAndEnterTheCourse(Utilities.getYamlValue("browser"),Utilities.getYamlValue("users.student.user_name3"),Utilities.getYamlValue("users.student.password")));
		Assert.assertTrue(dsl.clickOnGradebookButtonPresentInsideStudentConsoleWidget(),"Gradebook page can not be opened from the Student home");
		Assert.assertTrue(dsl.isScoreSubmittedDueVisible(),"Score, Submitted and Due is not visible on student gradebook page");

	}



	@Test(dependsOnMethods="loginAsStudentAndAttemptTheQuiz")
	public void enterGradebookButtonPresentInsideStudentConsoleAndVerifyScoreColumnEmpty(){
		Assert.assertTrue(dsl.clickOnGradebookButtonPresentInsideStudentConsoleWidget(),"Gradebook page can not be opened from the Student home");
		Assert.assertTrue(dsl.checkIsscoreColumnEmpty(),"Check for score column is not executed");
	}

	@Test(dependsOnMethods="enterGradebookButtonPresentInsideStudentConsoleAndVerifyScoreColumnEmpty")
	public void studentSubmitQuiz(){
		dsl.studentAttemptsAndSubmitsQuiz();
		dsl.closeBrowser();
	}

	@Test(dependsOnMethods="studentSubmitQuiz")
	public void loginAsInstructorAndEditDisplaySettings(){
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.instructorEditsDisplayOptionSeetings();
	}

	@Test(dependsOnMethods="loginAsInstructorAndEditDisplaySettings")
	public void verifyMinutColumnIsNotEmptyNowForInstructor(){
		Assert.assertTrue(dsl.clickOnGradebookButtonPresentInsideInstructorConsoleWidget(),"Gradebook page can not be opened from the instructor home");
		Assert.assertTrue(dsl.minuteColumnNotEmpty(),"Check for 'Minute' column is not executed");
		dsl.navigateBackToTopicPage();
	}


	@Test(dependsOnMethods="verifyMinutColumnIsNotEmptyNowForInstructor")
	public void exportScoresFromGradebook(){
		Assert.assertTrue(dsl.instructorExportScoresFromApplication(),"Scores are not exported from application");
	}



	@Test(dependsOnMethods="exportScoresFromGradebook")
	public void instructorViewhideAssigmentsTc001587(){
		dsl.createSaveAndAssignNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"),Utilities.getYamlValue("users.instructor.Quiz.points"));
		dsl.createSaveAndAssignNewQuizWithCategory(Utilities.getYamlValue("users.instructor.Quiz.quizName"),Utilities.getYamlValue("users.instructor.Quiz.points"), Utilities.getYamlValue("users.instructor.Quiz.categoryName"));
		Assert.assertTrue(dsl.instructorViewhideAssignments(),"View/Hide of assignments does not take execute under gradebook preferences page");
	}


	@Test(dependsOnMethods="instructorViewhideAssigmentsTc001587")
	public void instructsSetsCategoriesToBeWeightNotweightTc001585(){
		Assert.assertTrue(dsl.instructorUseTheWeightedCategories(),"Execution through weighted categories has not occured under gradebook preferences page");
	}


	@Test(dependsOnMethods="instructsSetsCategoriesToBeWeightNotweightTc001585")
	public void instructorArrangesAssignmentsWithinAcategoryNumericallyTc001590(){
		Assert.assertTrue(dsl.instructorRearrangeTheAssignmentsUnderCategoriesNumerically() ,"Assignments are not rearranged numerically under categories");
	}

//	@Test(dependsOnMethods="instructorArrangesAssignmentsWithinAcategoryNumericallyTc001590")
//	public void instructorArrangesCategoriesInTheListNumericallyTc001589(){
//		Assert.assertTrue(dsl.instructorRearrangeTheCategoriesNumerically() ,"Assignments are not rearranged numerically under categories");
//	}


	@Test(dependsOnMethods="instructorArrangesAssignmentsWithinAcategoryNumericallyTc001590")
	public void instructorSelectsXnumberOfLowestScoresToBeRemovedFromGradeTc001588(){
		dsl.createSaveAndAssignNewQuizWithCategory(Utilities.getYamlValue("users.instructor.Quiz.quizName"),Utilities.getYamlValue("users.instructor.Quiz.points"), Utilities.getYamlValue("users.instructor.Quiz.categoryName"));
		Assert.assertTrue(dsl.clickOnTheViewInstructorConsoleForGradebookPreferences(),"View instructor console page is not opened from instructor home or gradebook preferences page is not opened from instructor console");
		Assert.assertTrue(dsl.enterTheDropLowestValue(),"Drop Lowest value is not set under gradebook preferences");
	}



	@Test(dependsOnMethods="instructorSelectsXnumberOfLowestScoresToBeRemovedFromGradeTc001588")
	public void importScoresFromAnOutsideAssignmentToTheGradebookTc003747(){
		dsl.createAndAssignDropbox(Utilities.getYamlValue("users.instructor.Dropbox.dropboxName"),Utilities.getYamlValue("users.instructor.Quiz.points"));
		Assert.assertTrue(dsl.clickOnGradebookButtonPresentInsideInstructorConsoleWidget(),"Gradebook page can not be opened from the instructor home");
		Assert.assertTrue(dsl.importTheScoresFromOutside(),"Scores are not imported from outside");
	}



//	@Test(dependsOnMethods="importScoresFromAnOutsideAssignmentToTheGradebookTc003747")
//	public void instructorItemsWithPointsShouldOnlyAppearInGradebookOtherShouldNotTc001655(){
//		dsl.addTheNewCategoryFromHomepage2(Utilities.getYamlValue("users.instructor.Quiz.points"),Utilities.getYamlValue("users.instructor.Quiz.categoryName"));
//		dsl.addTheNewCategoryFromHomepage3(Utilities.getYamlValue("users.instructor.Quiz.points"),Utilities.getYamlValue("users.instructor.Quiz.categoryName"));
//		Assert.assertTrue(dsl.clickOnGradebookButtonPresentInsideInstructorConsoleWidget(),"Gradebook page can not be opened from the instructor home");
//		dsl.navigateBackToTopicPage();
//	}



	@Test(dependsOnMethods="importScoresFromAnOutsideAssignmentToTheGradebookTc003747")
	public void pointsUpto2DecimalPageShouldAppearTc001652(){
		dsl.createAndSaveNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		dsl.pointsUpto2DecimalPlaces(3,Utilities.getYamlValue("users.instructor.Quiz.points"));
		Assert.assertTrue(dsl.loginAsStudentAndEnterTheCourse(Utilities.getYamlValue("browser"),Utilities.getYamlValue("users.student.user_name3"),Utilities.getYamlValue("users.student.password")));
		Assert.assertTrue(dsl.studentAnswersAndViewPreviousQuizScore(),"Student does not answers or submit quiz is not executed");
		dsl.logout();
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.instructorViewsTheQuizResults();
	}


	//@AfterClass(alwaysRun = true)
	public void browserClose(ITestResult result){
		dsl.closeBrowserTakeScreenshotOfFailure(result);
	}
}
