package com.qait.automation.MacmillanLaunchpad.TestSuites;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RosterAndGroupTest {

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
		dsl.closeBrowser();
	}

	//	public void createGroupSetUsingRandomAssignmentTc001438() {
	//    	Assert.assertTrue(dsl.clickOnCreateGroupOrGroupSetOption());
	//        dsl.enterGroupPrefixAndSelectRadioButtonForNumberOfGroupsAndEnterValueMoreThen1();
	//        Assert.assertTrue(dsl.selectRandomOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink());
	//        Assert.assertTrue(dsl.clickOnOkButtonAfterSpecifyingAllRequiredFields());
	//    }

	@Test(dependsOnMethods="instructorCreatesCourse")
	public void createSingleGroupTc003122() {
		dsl.setUp();
		dsl.enterIntoCourseByCourseName(dsl.courseName);
		Assert.assertTrue(dsl.clickEnterCourse());
		Assert.assertTrue(dsl.clickOnRosterNGroupsButtonPresentInsideInstructorConsoleWidget());
		Assert.assertTrue(dsl.clickOnCreateGroupOrGroupSetOption());
		dsl.enterGroupPrefix();
		Assert.assertTrue(dsl.selectNoneOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink());
		Assert.assertTrue(dsl.clickOnStudentRadioInTheRowOfTheStudentToAssign());
		Assert.assertTrue(dsl.clickOnOkButtonAfterSpecifyingAllRequiredFields());
	}

	
	
	@Test(dependsOnMethods="createSingleGroupTc003122")
	public void viewListOfGroupSetsCreatedTc001414() {
		Assert.assertTrue(dsl.clickOnAnyGroupSetNameInGroupSetSection());
	}

	@Test(dependsOnMethods="viewListOfGroupSetsCreatedTc001414")
	public void editGroupSetTc001422() {
		dsl.clickOnTheEditOptionOfOneOfTheGroupSetsInTheLefthandNavigationPanel();
		Assert.assertTrue(dsl.editNewGroupSetNameAndClickOK());
	}

	@Test(dependsOnMethods="editGroupSetTc001422")
    public void generateGroupSetUsingRandomAssignment(){
        Assert.assertTrue(dsl.clickOnCreateGroupOrGroupSetOption());
        dsl.enterGroupPrefix();
        Assert.assertTrue(dsl.selectRandomOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink());
        Assert.assertTrue(dsl.clickOnStudentRadioInTheRowOfTheStudentToAssign());
        Assert.assertTrue(dsl.clickOnOkButtonAfterSpecifyingAllRequiredFields());
    }

	@Test(dependsOnMethods="generateGroupSetUsingRandomAssignment")
	public void generateGroupSetByApproximateNoOfUsersInEachGroupTc003123() {
		Assert.assertTrue(dsl.clickOnCreateGroupOrGroupSetOption());
		dsl.enterGroupPrefixAndSelectApproximateNumberOfStudentsPerGroupAndEnterValueMoreThen1();
		Assert.assertTrue(dsl.selectNoneOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink());
		Assert.assertTrue(dsl.clickOnOkButtonAfterSpecifyingAllRequiredFields());
	}

	@Test(dependsOnMethods="generateGroupSetByApproximateNoOfUsersInEachGroupTc003123")
	public void generateGroupSetByNoOfGroupsToBeCreatedTc001412() {
		Assert.assertTrue(dsl.clickOnCreateGroupOrGroupSetOption());
		dsl.enterGroupPrefixAndSelectRadioButtonForNumberOfGroupsAndEnterValueMoreThen1();
		Assert.assertTrue(dsl.selectNoneOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink());
		Assert.assertTrue(dsl.clickOnOkButtonAfterSpecifyingAllRequiredFields());
	}

	@Test(dependsOnMethods="generateGroupSetByNoOfGroupsToBeCreatedTc001412")
	public void removeStudentsFromTheRosterTc003116() {
		dsl.clickOnTheEditOptionOfTheGroupFromWhichTheStudentHasToBeRemoved();
		Assert.assertTrue(dsl.clickOnTheGreenCheckSignInTheRowOfTheStudentWhoHasToBeRemoved());
		Assert.assertTrue(dsl.clickOnOkButtonAndVerifyStudentIsDeleted());
	}

	@Test(dependsOnMethods="removeStudentsFromTheRosterTc003116")
	public void returningToGenerateGroupsFromGroupAssignmentTc003124() {
		Assert.assertTrue(dsl.clickOnCreateGroupOrGroupSetOption());
		dsl.enterGroupPrefixAndSelectRadioButtonForNumberOfGroupsAndEnterValueMoreThen1();
		Assert.assertTrue(dsl.selectRandomOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink());
		Assert.assertTrue(dsl.clickOnGenerateGroupsAtTopRight());
		Assert.assertTrue(dsl.modifyAnyFieldAndClickOnGenerateGroupsLink());
		Assert.assertTrue(dsl.clickOnOkButtonAfterSpecifyingAllRequiredFields());
	}

	@Test(dependsOnMethods="returningToGenerateGroupsFromGroupAssignmentTc003124")
	public void userApplySettingsToIndividualGroupsOrAllGroupsTc003129() {
		dsl.clickOnHomeButton();
		dsl.createAQuizWithQuestions("TestQuizTc003129", 2);
		dsl.clickOnCreatedQuizAssignmentAndClickOnItsSettingTab();
		Assert.assertTrue(dsl.selectTheGroupToApplyTheSettingChangesToAndClickSaveButton());
		dsl.clickOnDoneEditingButton();
		dsl.clickOnHomeButton();
	}

	@Test(dependsOnMethods="userApplySettingsToIndividualGroupsOrAllGroupsTc003129")
	public void userCloneGroupSetTc001420() {
		Assert.assertTrue(dsl.clickOnRosterNGroupsButtonPresentInsideInstructorConsoleWidget());
		dsl.clickOnTheCLONEOptionOfOneOfTheGroupSetsInTheLefthandNavigationPanel();
		Assert.assertTrue(dsl.enterANewGroupSetNameAndClickOK());
	}

	@Test(dependsOnMethods="userCloneGroupSetTc001420")
	public void instructorDeleteGroupTc001439() {
		Assert.assertTrue(dsl.clickOnCreateGroupOrGroupSetOption());
		dsl.enterGroupPrefixAndSelectRadioButtonForNumberOfGroupsAndEnterValueMoreThen1();
		Assert.assertTrue(dsl.selectNoneOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink());
		Assert.assertTrue(dsl.clickOnXIconPresentForAnyColumnAndClickOnYesButtonFromTheConfirmationPopup());
		Assert.assertTrue(dsl.clickOnOkButtonAfterSpecifyingAllRequiredFields());
	}


	@Test(dependsOnMethods="instructorDeleteGroupTc001439")
	public void deleteGroupSetTc001423() {
		Assert.assertTrue(dsl.clickOnCreateGroupOrGroupSetOption());
		dsl.enterGroupPrefixAndSelectRadioButtonForNumberOfGroupsAndEnterValueMoreThen1();
		Assert.assertTrue(dsl.selectNoneOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink());
		Assert.assertTrue(dsl.clickOnStudentRadioInTheRowOfTheStudentToAssign());
		Assert.assertTrue(dsl.clickOnOkButtonAfterSpecifyingAllRequiredFields());
		//createGroupSetUsingRandomAssignmentTc001438
		//createGroupSetUsingRandomAssignmentTc001438();
		Assert.assertTrue(dsl.clickOnTheDELETEOptionOfGroupSetsInTheLefthandNavigationPanelAndClickOKButtonFromTheConfirmationPopup());
		dsl.clickOnHomeButton();
	}


	//@AfterClass
	public void browserClose(){
		dsl.exitBrowser();
	}

}
