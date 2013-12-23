package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

public class ContentTocTest{

	DataCentralLibrary dsl = new DataCentralLibrary();


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
	}

	@Test(dependsOnMethods="instructorCreatesCourse")
	public void enterInCourseCreatedByInstructor(){
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
	}


	@Test(dependsOnMethods="enterInCourseCreatedByInstructor")
	public void instructorCreatesDiscussionBoardAtHomePage(){
		Assert.assertTrue(clickAddNewLinkAndSelectCreateNew());
		Assert.assertTrue(dsl.selectDiscussionBoardActivity());
		Assert.assertTrue(addAItemAndVerifyItIsDisplayed("Add Discussion Board"));
	}

	@Test(dependsOnMethods="instructorCreatesDiscussionBoardAtHomePage")
	public void instructorCreatesLinkActivityAtHomePage(){
		Assert.assertTrue(clickAddNewLinkAndSelectCreateNew());
		Assert.assertTrue(dsl.selectLinkActivity());
		Assert.assertTrue(dsl.provideATitleAndProvideANewValidURLClickOnSave("Add Link", "http://google.com/"));
		dsl.clickOnDoneEditingButton();
		Assert.assertTrue(dsl.clickOnHomeButtonAndVerifyCreatedItemDisplayed("Add Link"));
	}



	@Test(dependsOnMethods="instructorCreatesLinkActivityAtHomePage")
	public void instructorCreatesHtmlPageAtHomePage(){
		Assert.assertTrue(clickAddNewLinkAndSelectCreateNew());
		Assert.assertTrue(dsl.selectHtmlPageActivity());
		Assert.assertTrue(addAItemAndVerifyItIsDisplayed("Add HTML Page"));
	}

	@Test(dependsOnMethods="instructorCreatesHtmlPageAtHomePage")
	public void instructorCreatesLearningCurveAtHomePage(){
		Assert.assertTrue(clickAddNewLinkAndSelectCreateNew());
		Assert.assertTrue(dsl.selectLearningCurveActivity());
		Assert.assertTrue(addAItemAndVerifyItIsDisplayed("Add Learning Curve"));
	}

	@Test(dependsOnMethods="instructorCreatesLearningCurveAtHomePage")
	public void instructorCreatesDropboxAtHomePage(){
		Assert.assertTrue(clickAddNewLinkAndSelectCreateNew());
		Assert.assertTrue(dsl.selectDropBoxActivity());
		Assert.assertTrue(addAItemAndVerifyItIsDisplayed("Add Dropbox"));
	}

	@Test(dependsOnMethods="instructorCreatesDropboxAtHomePage")
	public void instructorCreatesLinkCollectionAtHomePage(){
		Assert.assertTrue(clickAddNewLinkAndSelectCreateNew());
		Assert.assertTrue(dsl.selectLinkCollectionActivity());
		Assert.assertTrue(dsl.provideATitleAndClickOnSaveFnE("Add linkCollection"));
		dsl.clickAttachALink();
		dsl.provideLinkTitleURLAndClickSave("MacMillanHome", "http://www.macmillan.com/");
		dsl.clickOnSave();
		dsl.clickOnDoneEditingButton();
		Assert.assertTrue(dsl.clickOnHomeButtonAndVerifyCreatedItemDisplayed("Add linkCollection"));
	}

	@Test(dependsOnMethods="instructorCreatesLinkCollectionAtHomePage")
	public void instructorCreatesNewUnitAtHomePage() {
		Assert.assertTrue(clickAddNewLinkAndSelectCreateNew());
		dsl.selectUnitActivity();
		Assert.assertTrue(dsl.provideATitleAndClickOnSave("Add unit"));
	}

	/*@Test(dependsOnMethods="instructorCreatesNewUnitAtHomePage")
	public void attachDocumentToDocumentCollectionTc001370() {
		Assert.assertTrue(dsl.clickOnTheAddLinkAppearingAtTheTop());
		Assert.assertTrue(dsl.selectTheCreateNewOption());
		Assert.assertTrue(dsl.selectDocumentCollectionActivity());
		Assert.assertTrue(dsl.provideATitleAndClickOnAttachADocument(Utilities.getYamlValue("users.instructor.document.documentCollection")));
		dsl.browseAFileProvideDocumentTitleAndClickUpload(Utilities.getYamlValue("users.instructor.document.newDocument"));
		Assert.assertTrue(dsl.clickSaveAndFurtherClickOnTheDoneEditing(Utilities.getYamlValue("users.instructor.document.newDocument")));
		Assert.assertTrue(dsl.clickOnHomeButtonAndVerifyCreatedItemDisplayed(Utilities.getYamlValue("users.instructor.document.documentCollection")));
	}
	
	@Test(dependsOnMethods="attachDocumentToDocumentCollectionTc001370")
	public void instructorBrowseContentInFneModeTc001165() {
		dsl.fromTocClickOnChapterThenItsContent();
		dsl.clickHomeButton();
	}

	@Test(dependsOnMethods="instructorBrowseContentInFneModeTc001165")
	public void instructorBrowseExistingContentByChapterTc001159() {
		Assert.assertTrue(dsl.gotoResourcesContentByChapter());
		dsl.clickOnResourceCloseButton();
	}
	
	@Test(dependsOnMethods="instructorBrowseExistingContentByChapterTc001159")
	public void instructorEditsTitleAndDirectionsOfExistingContentTc001166() {
		dsl.hoverOnChapter();
		//dsl.fromTOCClickOnAnyChapter();
		dsl.clickOnTheGearMenuIcon();
		dsl.selectEditLinkForChapter();
		Assert.assertTrue(dsl.makeChangesWithTheTitleForChapterAndClickSave(Utilities.getYamlValue("users.instructor.editPageSettings.changeUnitTitle")));
	}*/
	
//	@Test(dependsOnMethods="instructorEditsTitleAndDirectionsOfExistingContentTc001166")
//	public void instructorBrowseTheTocTc001164() {
//		Assert.assertTrue(dsl.clickOnAnyChapter());
//		Assert.assertTrue(dsl.clickOnAnyOtherChapter());
//	}
//
//
//
//
//	@Test(dependsOnMethods="instructorBrowseTheTocTc001164")
//	public void instructorCreatesNewQuizInsideChapter() {
//		//dsl.fromTOCClickOnAnyChapter();
//		Assert.assertTrue(clickAddNewLinkAndSelectCreateNewInChapter());
//		Assert.assertTrue(dsl.selectQuizActivity());
//		Assert.assertTrue(addAItemAndVerifyItIsDisplayed("Add Quiz"));
//	}






	private boolean addAItemAndVerifyItIsDisplayed(String itemName) {
		boolean createItem, verifyItem;
		createItem = dsl.provideATitleAndClickOnSaveFnE(itemName);
		dsl.clickOnDoneEditingButton();
		verifyItem = dsl.clickOnHomeButtonAndVerifyCreatedItemDisplayed(itemName);
		return createItem && verifyItem;
	}

	private boolean clickAddNewLinkAndSelectCreateNewInChapter() {
		boolean newLinkAppears, newOptionsDisplayed;
		newLinkAppears = dsl.clickOnTheAddToThisUnitDropDown();
		newOptionsDisplayed = dsl.selectTheCreateNewOption();
		return newLinkAppears && newOptionsDisplayed;
	}

	private boolean clickAddNewLinkAndSelectCreateNew() {
		boolean newLinkAppears, newOptionsDisplayed;
		newLinkAppears = dsl.clickOnTheAddLinkAppearingAtTheTop();
		newOptionsDisplayed = dsl.selectTheCreateNewOption();
		return newLinkAppears && newOptionsDisplayed;
	}








	@AfterClass(alwaysRun = true)
	public void browserClose(){
		dsl.exitBrowser();
	}
}
