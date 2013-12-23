package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

public class QuestionEditorPickerTest{

	DataCentralLibrary dsl = new DataCentralLibrary();



	////////////////////////////////////////////////////////////////////////////////////////////////////////

	//@Test(priority=1)
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

	@Test//(dependsOnMethods="instructorCreatesCourse")
	public void addOneQuestionToAnAssessmentTc001345(){
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.createAndSaveNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		Assert.assertTrue(dsl.instructorAddOneQuestionToNewPool(),"Chapter or TestBank is not clicked");
	}
	
	@Test(dependsOnMethods="addOneQuestionToAnAssessmentTc001345")
	public void addQuestionToExistingPoolWithinAquizTc001344(){
		Assert.assertTrue(dsl.instructorAddQuestionsToExistingPool(),"Chapter or TestBank is not clicked");
	}

	@Test(dependsOnMethods="addQuestionToExistingPoolWithinAquizTc001344")
	public void deleteExistingPool(){
		Assert.assertTrue(dsl.instructorRemovePoolFromAnAssessment(),"Chapter or TestBank is not clicked");
	}

	@Test(dependsOnMethods="deleteExistingPool")
	public void addSeveralQuestionsToNewAssessmentUsingTheCheckBoxesTc001340(){
		Assert.assertTrue(dsl.instructorAddSeveralQuestionsUsingCheckBoxes(),"Chapter or TestBank is not clicked");
	}

	@Test(dependsOnMethods="addSeveralQuestionsToNewAssessmentUsingTheCheckBoxesTc001340")
	public void deleteQuestionInTheAssesment(){
		Assert.assertTrue(dsl.instructorRemoveAquestionFromAnAssessment(),"Chapter or TestBank is not clicked");
	}


	



	@Test(dependsOnMethods="deleteQuestionInTheAssesment")
	public void addQuestionToNewPoolWithinAquizTc001343(){
		//Assert.assertTrue(dsl.instructorAddQuestionsToNewPool(),"Chapter or TestBank is not clicked");
	}



	@Test(dependsOnMethods="addQuestionToNewPoolWithinAquizTc001343")
	public void browseAvailableQuestionsFromQuestionBanksTc001338(){
		//Assert.assertTrue(dsl.instructorBrowseAvailableQuestionsFromQuestionBanks(),"Chapter or TestBank is not clicked");
	}

	@Test(dependsOnMethods="browseAvailableQuestionsFromQuestionBanksTc001338")
	public void bulkUploadQuestionsTc002167(){
		dsl.instructorBulkUploadQuestions();
	}

	@Test(dependsOnMethods="bulkUploadQuestionsTc002167")
	public void deselectAllQuestionsFromAquestionBankTc001347(){
		Assert.assertTrue(dsl.instructorDeselectsAllQuestions(),"Chapter or TestBank is not clicked");
	}

	@Test(dependsOnMethods="deselectAllQuestionsFromAquestionBankTc001347")
	public void editApublisherCreatedQuestionTc001277(){
		Assert.assertTrue(dsl.instructorEditApublisherCreatedQuestion(),"Chapter or TestBank is not clicked");
	}

	@Test(dependsOnMethods="editApublisherCreatedQuestionTc001277")
	public void editUserCreatedQuestionTc001279(){
		//Assert.assertTrue(dsl.instructorEditAuserCreatedQuestion(),"Chapter or TestBank is not clicked");

	}

	@Test(dependsOnMethods="editUserCreatedQuestionTc001279")
	public void expandCollapseQuestionsInAquestionBankTc001360(){
		Assert.assertTrue(dsl.instructorExpandCollapseQuestionsInAquestionBank(),"Chapter or TestBank is not clicked");
		dsl.navigateBackToHomePage();
	}


	@Test(dependsOnMethods="expandCollapseQuestionsInAquestionBankTc001360")
	public void previewQuestionInQuestionBanksTc001341(){
		dsl.createAndSaveNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		Assert.assertTrue(dsl.instructorPreviewQuestionInQuestionBanks(),"Chapter or TestBank is not clicked");
	}


	@Test(dependsOnMethods="previewQuestionInQuestionBanksTc001341")
	public void selectAllQuestionsFromAquestionBankToAnAssessmentTc001346(){
		Assert.assertTrue(dsl.instructorSelectAllQuestionsFromAquestionBank(),"Chapter or TestBank is not clicked");
	}

	//@Test(dependsOnMethods="selectAllQuestionsFromAquestionBankToAnAssessmentTc001346")
	public void selectQuestionsUsedInPreviousAssessmentTc001348(){
		Assert.assertTrue(dsl.instructorSelectQuestionsUsedInPreviousAssessment(),"Chapter or TestBank is not clicked");
	}

	//@Test(dependsOnMethods="selectQuestionsUsedInPreviousAssessmentTc001348")
	public void createAndAssignAnAssessmentThatAllowsStudentsToSubmitAndGetFeedbackOnEachQuestionIndependentlyTc002164(){
		dsl.createAndSaveNewHomework(Utilities.getYamlValue("users.instructor.Homework.homeworkName"));
		dsl.studentViewsFeedbackOnEachQuestion(Utilities.getYamlValue("users.instructor.Quiz.points"));
		Assert.assertTrue(dsl.loginAsStudentAndEnterTheCourse(Utilities.getYamlValue("browser"),Utilities.getYamlValue("users.student.user_name3"),Utilities.getYamlValue("users.student.password")));
		Assert.assertTrue(dsl.studentAttemptsAndSubmitHomework(),"Student does not answers or submit homework is not executed");
		dsl.closeBrowser();
	}

	//@Test(dependsOnMethods="createAndAssignAnAssessmentThatAllowsStudentsToSubmitAndGetFeedbackOnEachQuestionIndependentlyTc002164")
	public void createAndAssignAssessmentStudentsCompleteQuestionsInAsingleSubmissionReceiveFeedbackOnAllQuestionsTestTc002163(){
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.instructorAddsNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		dsl.studentCompleteAllQuestionTogether(Utilities.getYamlValue("users.instructor.Quiz.points"));
		Assert.assertTrue(dsl.loginAsStudentAndEnterTheCourse(Utilities.getYamlValue("browser"),Utilities.getYamlValue("users.student.user_name3"),Utilities.getYamlValue("users.student.password")));
		dsl.studentAttemptsAndSubmitsQuiz();
		dsl.closeBrowser();
	}




	//@AfterClass(alwaysRun = true)
	public void browserClose(ITestResult result){
		dsl.closeBrowserTakeScreenshotOfFailure(result);
	}
}
