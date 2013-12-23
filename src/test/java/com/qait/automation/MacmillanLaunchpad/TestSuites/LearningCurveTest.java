/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.MacmillanLaunchpad.TestSuites;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class LearningCurveTest{

	DataCentralLibrary dsl = new DataCentralLibrary();
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test(priority=1)
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
	public void enterInCourseCreatedByInstructor(){
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
	}

   @Test(dependsOnMethods="enterInCourseCreatedByInstructor")
    public void createLearningCurveActivityTc002195() {
        Assert.assertTrue(dsl.clickOnTheAddLinkAppearingAtTheTop());
        Assert.assertTrue(dsl.selectTheCreateNewOption());
        Assert.assertTrue(dsl.selectLearningCurveActivity());
        Assert.assertTrue(dsl.provideATitleAndClickOnSave());
        Assert.assertTrue(dsl.clickOnQuestionsTab());
        Assert.assertTrue(dsl.clickOnAnyChapterAndThenTestBank());
        dsl.selectQuestionsAndThenClickOnAddToNewPoolFromTheAddToPoolDropDown();
        dsl.enterTitleAndClickSaveButton();
        Assert.assertTrue(dsl.clickDoneEditingButtonLearnicgCurveVrification());
    }
    
    @Test(dependsOnMethods="createLearningCurveActivityTc002195")
    public void userChangeTheTargetScoreForLearningCurveActivityTc002168() {
        Assert.assertTrue(dsl.clickOnTheLearningCurveActivity());
        dsl.hoverOverTheEditButtonAndClickOnSettingsOption();
        dsl.uncheckAutoCalculateCheckboxAndEnterTheTargetScore("150");
        Assert.assertTrue(dsl.clickSaveButton());
        dsl.clickDoneEditingButtonAndVerifyEnteredScore("150");
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
