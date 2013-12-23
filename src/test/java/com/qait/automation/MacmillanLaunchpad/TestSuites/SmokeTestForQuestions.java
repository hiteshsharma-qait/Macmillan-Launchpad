package com.qait.automation.MacmillanLaunchpad.TestSuites;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

public class SmokeTestForQuestions {

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
		}
	
	@Test(dependsOnMethods="instructorCreatesCourse")
	public void createAndSaveNewQuiz(){
		dsl.createAndSaveNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
	}
	
	@Test(dependsOnMethods="createAndSaveNewQuiz")
	public void navigateToQuestionsInQuestionBank(){
		dsl.moveToQuestionTestBankPage();
		
	}
	
	@Test(dependsOnMethods="navigateToQuestionsInQuestionBank")
	public void dragAndDropQuestion(){
		dsl.dragAndDropQuestionFromTestBankToQuestionsByPublisher();
		dsl.removeDragedQuestion();
	}
	
	@Test(dependsOnMethods="dragAndDropQuestion")
	public void SelectAllQuestions(){
		dsl.createAndSaveNewQuiz(Utilities.getYamlValue("users.instructor.Quiz.quizName"));
		dsl.instructorBulkUploadQuestions();
	}

	@Test(dependsOnMethods="SelectAllQuestions")
	public void clickAnotherTab(){
		dsl.navigateFromAnotherTab();
	}
	
	
	@Test(dependsOnMethods="clickAnotherTab")
	public void verifyAllQuestionAddedToQuiz(){
		Assert.assertTrue(dsl.verifyQuestionsAdded());
		dsl.moveFAndEToHomePage();
	}

	
}