package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

public class EbookSuiteTest {

	DataCentralLibrary dsl = new DataCentralLibrary();

//	public void commonMethods() {
//		dsl.setUp();	
//		dsl.enterIntoCourseByCourseName(dsl.courseName);
//		Assert.assertTrue(dsl.clickEnterCourse());
//	}

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
	public void accessOtherInteractiveElementsTc002995() {
		dsl.setUp();	
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.fromTOCClickOnAnyChapter(Utilities.getYamlValue("users.instructor.ebook.clickChapterInteractiveElem"));
		dsl.clickOnContentItem();
		dsl.userClicksNextNavigationButton();
		Assert.assertTrue(dsl.userClicksOnShowAnswer());
		dsl.clickOnHomeButton();
	}


	@Test(dependsOnMethods="accessOtherInteractiveElementsTc002995")
	public void accessCrossReferencedSectionsThroughLinksOnTheEbookPageTc002160() {
		//dsl.userClicksNextNavigationButton();
		dsl.userClicksOnTheCrossReferenceSection(Utilities.getYamlValue("users.instructor.ebook.crossRefSection"));
		dsl.clickOnHomeButton();
	}



	@Test(dependsOnMethods="accessCrossReferencedSectionsThroughLinksOnTheEbookPageTc002160")
	public void instructorCanEditInformationRelatedToPublisherCreatedItemThroughBasicInfTabTc001630() {
		Assert.assertTrue(dsl.expandAnyChapterAndNavigateToFnEWindowOfAnyContentItem());
		dsl.hoverOverTheEditButtonAndClickOnBasicInfoOption();
		Assert.assertTrue(dsl.editTheFieldsAndClickOnSaveButton());
		dsl.clickOnDoneEditingButton();
		dsl.clickHomeButton();
		Assert.assertTrue(dsl.verifyTheEditedTitleOfContentItem());
	}

	@Test(dependsOnMethods="instructorCanEditInformationRelatedToPublisherCreatedItemThroughBasicInfTabTc001630")
	public void navigateTheEbookContentUsingNextButtonForInstructor() {
		Assert.assertTrue(dsl.expandAnyChapterAndNavigateToFnEWindowOfAnyContentItem());
		dsl.userClicksNextNavigationButton();
		Assert.assertTrue(dsl.userClickOnNextNavigationButtonTillLastContentItemOfChapterIsAboutToReach());
	}

	@Test(dependsOnMethods="navigateTheEbookContentUsingNextButtonForInstructor")
	public void navigateTheEbookContentUsingPreviousButtonForInstructor() {
		dsl.userClicksPreviousNavigationButton();
		Assert.assertTrue(dsl.userClickOnPreviousNavigationButtonTillFirstContentItemOfChapterIsAboutToReach());
		dsl.clickHomeButton();
	}

	@Test(dependsOnMethods="navigateTheEbookContentUsingPreviousButtonForInstructor")
	public void loginAsStudentAndEnterCourse(){
		dsl.copyTheActivatedURLForTheCourse();
		Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
		dsl.clickLogInButtonProvidedUnderStudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password"));
		Assert.assertTrue(dsl.clickEnterCourse());
	}

	@Test(dependsOnMethods="loginAsStudentAndEnterCourse")
	public void navigateTheEbookContentUsingNextButtonForStudent() {
		Assert.assertTrue(dsl.expandAnyChapterAndNavigateToFnEWindowOfAnyContentItem());
		dsl.userClicksNextNavigationButton();
		Assert.assertTrue(dsl.userClickOnNextNavigationButtonTillLastContentItemOfChapterIsAboutToReach());
	}

	@Test(dependsOnMethods="navigateTheEbookContentUsingNextButtonForStudent")
	public void navigateTheEbookContentUsingPreviousButtonForStudent() {
		dsl.userClicksPreviousNavigationButton();
		Assert.assertTrue(dsl.userClickOnPreviousNavigationButtonTillFirstContentItemOfChapterIsAboutToReach());
		dsl.clickOnHomeButton();
	}


	@Test(dependsOnMethods="navigateTheEbookContentUsingPreviousButtonForStudent")
	public void openEnlargedFiguresAndPhotosInNewWindowTc002159() {
		dsl.fromTOCClickOnAnyChapter();
		dsl.clickOnContentItem();
		Assert.assertTrue(dsl.clickOnTheImagesOrFigureAppearingInFnEWindow());
		dsl.clickOnHomeButton();
	}

	@Test(dependsOnMethods="openEnlargedFiguresAndPhotosInNewWindowTc002159")
	public void openGlossaryForDefinedWordsTc002161() {
		dsl.fromTOCClickOnAnyChapter();
		dsl.clickOnContentItem();
		Assert.assertTrue(dsl.clickOnAnyKeyTermAppearingOnTheFnEWindow());
		Assert.assertTrue(dsl.clickOnX());
		dsl.clickOnHomeButton();
	}


	//@AfterClass(alwaysRun = true)
	public void browserClose(ITestResult result){
		dsl.closeBrowserTakeScreenshotOfFailure(result);
	}
}
