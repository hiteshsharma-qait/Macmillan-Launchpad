package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

public class ResourcesPageTest{

	DataCentralLibrary dsl= new DataCentralLibrary();

	public void commonMethods() {
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test(priority=1)
	public void aCourseCreation(){
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
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test(priority=4)
	public void AddOrRemoveContentItemsToLpUnitsTc001577(){
		commonMethods();
		Assert.assertTrue(dsl.instructorAddContentItemUsingContentByType());
		//closeBrowser();
		dsl.closeBrowser();
	}

	@Test(priority=3)
	public void AssignInUseContentAfterBrowsingResourcesTc002188(){
		commonMethods();
		Assert.assertTrue(dsl.assignAndUseResource(Utilities.getYamlValue("users.instructor.resources.contentByName"),Utilities.getYamlValue("users.instructor.Quiz.points")));
		//closeBrowser();
		dsl.closeBrowser();
	}

	@Test(priority=5)
	public void browseContentThatHasBeenRemovedByInstructorTc002189(){
		commonMethods();
		Assert.assertTrue(dsl.instructorBrowseRemovedContents());
		//closeBrowser();
		dsl.closeBrowser();
	}

	@Test(priority=6)
	public void browseContentThatInstructorHasCreatedUnderResourcesPageTc001365(){
		commonMethods();
		Assert.assertTrue(dsl.instructorBrowseResourceContents());
		//closeBrowser();
		dsl.closeBrowser();
	}

	@Test(priority=7)
	public void browseQuestionsUnderResourcesTc001220(){
		commonMethods();
		Assert.assertTrue(dsl.instructorBrowseQuestionsSection());
		//closeBrowser();
		dsl.closeBrowser();
	}

	@Test(priority=2)
	public void FilterQuestionsByTypeTc001568() {
		commonMethods();
		Assert.assertTrue(dsl.filterOption(Utilities.getYamlValue("users.instructor.resources.contentByName")));
		//closeBrowser();
		dsl.closeBrowser();
	}

	//@Test		can not automate
	public void HoverOvercontentItemAndSeeFullTitleInTooltipTc001576(){
		commonMethods();
		dsl.mouseHoverAndGetText();
		//closeBrowser();
		dsl.closeBrowser();
	}

	@Test(priority=8)
	public void InstructorAddsContentItemToLaunchPadAfterTheyHaveBrowsedContentTc001366(){
		commonMethods();
		Assert.assertTrue(dsl.instructorAddContentItemAfterBrowsingResources());
		//closeBrowser();
		dsl.closeBrowser();
	}

	@Test(priority=9)
	public void InstructorBrowseAvailableContentFromTheResourcesPageTc001364(){
		commonMethods();
		Assert.assertTrue(dsl.instructorBrowseAvailableResourceContents());
		//closeBrowser();
		dsl.closeBrowser();
	}

	@Test(priority=10)
	public void InstructorCanMoveOrCopyContentFromResourcesTc001313(){
		commonMethods();
		Assert.assertTrue(dsl.instructorCanCopyContents(Utilities.getYamlValue("users.instructor.resources.copyContent")));
		dsl.closeBrowser();
	}

	@Test(priority=11)
	public void InstructorRemovesContentFromLaunchPadViaResourceOverlayTc001367(){
		commonMethods();
		Assert.assertTrue(dsl.instructorCanRemoveContents());
		//closeBrowser();
		dsl.closeBrowser();
	}
	
    //@Test(priority=12)
    public void deleteSampleCOurseOne() {
        dsl.setUp();
        dsl.deleteSampleCourses("TestAutomationCourseCreation");
    }
	
    @AfterMethod(alwaysRun = true)
    public void browserClose(ITestResult result){
    dsl.closeBrowserTakeScreenshotOfFailure(result);
}


}
