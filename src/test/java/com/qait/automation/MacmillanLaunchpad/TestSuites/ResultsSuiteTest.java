package com.qait.automation.MacmillanLaunchpad.TestSuites;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResultsSuiteTest{

	DataCentralLibrary dsl = new DataCentralLibrary();
	
	public void commonMethods() {
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test(priority=1)
	public void instructotCreatesCourse(){
		dsl.setUp();	
        Assert.assertTrue(dsl.clickOnCreateCourseLink());
        //Assert.assertTrue(dsl.selectYesRadioButton());
        //dsl.userSelectsTheBaseLineCourseFromWhichToBaseTheNewCourse(dsl.baseCourse);
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
        dsl.copyTheActivatedURLForTheCourseNC();
        Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
        Assert.assertTrue(dsl.clickOnTheLogInButtonProvidedUnderStdudentHeading(Utilities.getYamlValue("users.student.user_name2"), Utilities.getYamlValue("users.student.password")));
        Assert.assertTrue(dsl.clickOnTheJoinCourse("Congratulations! You have successfully joined"));
        Assert.assertTrue(dsl.clickEnterCourse());
	}

    @Test(priority=2)
    public void scoringForParticularStudentTc001761() {
        commonMethods();
        dsl.createAQuizAndAssignItToStudents();
        dsl.copyTheActivatedURLForTheCourse();
        Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
        dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password"));
        Assert.assertTrue(dsl.clickEnterCourse());
        Assert.assertTrue(dsl.studentAttemptTheCreatedQuiz());
        Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
        dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name2"), Utilities.getYamlValue("users.student.password"));
        Assert.assertTrue(dsl.clickEnterCourse());
        Assert.assertTrue(dsl.studentAttemptTheCreatedQuiz());
        Assert.assertTrue(dsl.logOutAsStudentAndAgainBrowseTheCopiedURLForInstructor(Utilities.getYamlValue("browser")));
        dsl.clickLogInButtonProvidedUnderInstructorHeading(Utilities.getYamlValue("users.instructor.user_name3"), Utilities.getYamlValue("users.instructor.password"));
        Assert.assertTrue(dsl.clickEnterCourse());
        Assert.assertTrue(dsl.openTheQuizLinkFromTheHomePageAndClickResults());
        Assert.assertTrue(dsl.openTheDetailsOfAnyOfTheStudentListedOnResultsPage());
        dsl.closeBrowser();
    }
    
    @Test(priority=3)
    public void submitDropboxActivityAsStudentTc001762() {
        commonMethods();
        dsl.createADropboxAndAssignItToStudents();
        dsl.copyTheActivatedURLForTheCourse();
        Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
        dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password"));
        Assert.assertTrue(dsl.clickEnterCourse());
        dsl.clickDropboxCreatedAboveAndSubmitAValidFile();
        Assert.assertTrue(dsl.clickHomeAndVerifyGreenTickMarkIsDisplayed());
        dsl.closeBrowser();
    }
    
    @Test(priority=4)
    public void viewItemSummaryTc001757() {
        commonMethods();
        dsl.createAQuizAndAssignItToStudents();
        Assert.assertTrue(dsl.openTheQuizLinkFromTheHomePageAndClickResults());
        dsl.closeBrowser();
    }
    
    @Test(priority=5)
    public void viewSubmissionForDropboxActivityTc001763() {
        commonMethods();
        dsl.createADropboxAndAssignItToStudents();
        dsl.copyTheActivatedURLForTheCourse();
        Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
        dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name3"),Utilities.getYamlValue("users.student.password"));
        Assert.assertTrue(dsl.clickEnterCourse());
        dsl.clickDropboxCreatedAboveAndSubmitAValidFile();
        dsl.clickOnHomeButton();
        Assert.assertTrue(dsl.logOutAsStudentAndAgainBrowseTheCopiedURLForInstructor(Utilities.getYamlValue("browser")));
        if((Utilities.getYamlValue("browser")).equalsIgnoreCase("firefox")){
        dsl.clickLogInButtonProvidedUnderInstructorHeading(Utilities.getYamlValue("users.instructor.user_name_ff"), Utilities.getYamlValue("users.instructor.password"));
        }else if((Utilities.getYamlValue("browser")).equalsIgnoreCase("chrome")){
            dsl.clickLogInButtonProvidedUnderInstructorHeading(Utilities.getYamlValue("users.instructor.user_name_c"), Utilities.getYamlValue("users.instructor.password"));
        }else if((Utilities.getYamlValue("browser")).equalsIgnoreCase("ie")){
            dsl.clickLogInButtonProvidedUnderInstructorHeading(Utilities.getYamlValue("users.instructor.user_name_ie"), Utilities.getYamlValue("users.instructor.password"));
        }else{
            dsl.clickLogInButtonProvidedUnderInstructorHeading(Utilities.getYamlValue("users.instructor.user_name_safari"), Utilities.getYamlValue("users.instructor.password"));
        }
        Assert.assertTrue(dsl.clickEnterCourse());
        dsl.enterDropboxCreated();
        dsl.click1UngradedSubmissionMessage();
        dsl.closeBrowser();
    }
    
    //@Test(priority=6)
    public void deleteSampleCOurseOne() {
        dsl.setUp();
        dsl.deleteSampleCourses("TestAutomationCourseCreation");
    }
    
    @AfterMethod(alwaysRun = true)
    public void browserClose(ITestResult result){
    dsl.closeBrowserTakeScreenshotOfFailure(result);
}

}
