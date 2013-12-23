package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;

import com.qait.automation.MacmillanLaunchpad.Utils.DateUtil;

public class LaunchpadHomeUi extends CommonMethods {

	public WebDriver driver;
	@FindBy(id = "PX_MENU_ITEM_LAUNCHPAD")
	WebElement menuItemLaunchpad;
	String unassignedChapterLink = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) .unitfptitle";
	String unassignedChapterLists = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%)";
	@FindBy(className = "nodeExpanded")
	WebElement expandedAssignedChapter;
	@FindBy(css = ".nodeExpanded .gearbox-icon.pxicon.pxicon-gear")
	WebElement expandedAssignedChapterGearIcon;
	String addLinkForFirstUnassignedChater = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) .btn-wrapper.gradient>a";
	String unassignedChapterSubtopicLink = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET .nodeExpanded+li:nth-child(%) .fptitle>a";
	String unassignedChapterSubtopicText = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) .fptitle";
	String unassignedChapterSubtopicText2 = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET .nodeExpanded+li:nth-child(%) .fptitle";
	String chapterNamexPath = "(//span[text()[contains(.,'%')]])[1]";
	@FindBy(css = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(1) .unitfptitle")
	WebElement firstUnassignedChapterLink;
	@FindBy(css = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(2) .fptitle")
	WebElement firstUnassignedChapterfirstUnitLink;
	@FindBy(css = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(3) a")
	WebElement firstUnassignedChapterFirstUnitFirstTopicLink;
	@FindBy(xpath = "(//input[@class='faceplate-item-assign'])[1]")
	WebElement firstUnassignedChapterFirstUnitAssignButton;
	@FindBy(css = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(2) span[class*=title]:not(.item_subtitle)")
	WebElement firstUnassignedChapterFirstUnitName1;
	@FindBy(css = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(2) span[class*=title]:not(.item_subtitle)>a")
	WebElement firstUnassignedChapterFirstUnitName2;
	String assignButtonForNextContentToAssignWhichIsAlreadyAssigned = "#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) .faceplate-item-assign[value=Assign]:not([style*=none])";
	String nextContentToBeAssigned = "#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%)";
	String firstAssignedContentExpandButton = "#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) .icon.col.collapsed";
	String firstUnAssignedContentExpandButton = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) .icon.col.collapsed";
	@FindBy(className = "FacePlateAsssign")
	WebElement assignCourseDetailWindowDisplayed;
	@FindBy(id = "fne-unblock-action-home")
	WebElement homeButton;
	@FindBy(id = "facePlateAssignDueDate")
	WebElement assignCourseDueDateInput;
	@FindBy(css = "#ConsoleRegion .Title")
	WebElement selectedOption;
	@FindBy(id = "facePlateAssignTime")
	WebElement assignCourseDueTimeInput;
	@FindBy(css = "#widgetBody #more-resources-search-box")
	WebElement searchButton;
	@FindBy(css = "[value=Done]")
	WebElement assignCourseDoneButton;
	@FindBy(xpath = "//div[@id='browseResultsPanel']/div[@class='close']")
	WebElement crossButton;
	@FindBy(id = "fsGradebook")
	WebElement gradeBookFieldSet;
	@FindBy(xpath = "(//span[@class='lblInUse moreResourcesLabel'][1])[2]")
	WebElement asd;
	@FindBy(id = "txtGradePoints")
	WebElement textGradePoints;
	@FindBy(css = "#Title")
	WebElement pageTitle;
	@FindBy(id = "selgradebookweights")
	WebElement gradeBookCategory;
	@FindBy(css = ".formbtns.editcontent .savebtn.button.primary.large")
	WebElement saveBtnCopyToCurrentUnit;
	@FindBy(css = "#student-login>a")
	WebElement logOut;
	@FindBy(id = "lnkActivateCourse")
	WebElement activateCourseLink;
	@FindBy(css = "#dashboard-course-item h1.pre-activation")
	WebElement activateCoursePreHeading;
	@FindBy(css = "#dashboard-course-item+div button:first-child")
	WebElement activateCourseDialogButton;
	@FindBy(css = "#dashboard-course-item+div button:last-child")
	WebElement activateCourseSecondDialogButton;
	@FindBy(css = "#dashboard-course-item h1.post-activation")
	WebElement activateCoursePostHeading;
	@FindBy(id = "accountActionsList")
	WebElement selectDropdownOptions;
	@FindBy(id = "CW_Roster-groupsButton")
	WebElement rosterAndGroupButton;
	//	@FindBy(css="#PX_InstructorConsoleWidget [href*=general]")
	//	WebElement settingsButton;
	@FindBy(css = ".faceplate-nav .btn-wrapper.gradient>a")
	WebElement addButtonLink;
	@FindBy(id = "create")
	WebElement createNewOptionLink;
	@FindBy(id = "browse")
	WebElement browseResourceOptionlink;
	@FindBy(className = "template-list")
	WebElement allNewOptionsList;
	@FindBy(id = "TMP_79e70863484b443b81793043eb5c3a4f")
	WebElement learningCurveOptionLink;
	@FindBy(id = "TMP_88161c2783b949ed805d56fc5a1a1349")
	WebElement quizOptionLink;
	@FindBy(id = "TMP_5639c5e11e83479abbaeff34beb94e16")
	WebElement discussionBoardOptionLink;
	@FindBy(id = "TMP_429ef3606d6a45a695a8dd0225e_unit")
	WebElement unitOptionLink;
	@FindBy(id = "TMP_95f884c8be2e430598f50e43c9058828")
	WebElement linkOptionLink;
	@FindBy(id = "TMP_dcef7cf5ba194495a7c86145b557bc15")
	WebElement homeWorkOptionLink;
	@FindBy(id = "TMP_a9435305a14e472ba2e503653c520538")
	WebElement htmlPageOptionLink;
	@FindBy(id = "TMP_95f884c8be2e430597f50e43c9057727")
	WebElement linkCollectionOptionLink;
	@FindBy(id = "TMP_8fb2fe4aa2f0494c8f6caa62eaabf101")
	WebElement dropboxOptionLink;
	@FindBy(id = "TMP_83a8a14d1cc34a54b84868257ac3f165")
	WebElement documentCollectionOptionLink;
	@FindBy(id = "CW_ResourcesButton")
	WebElement resourceButton;
	@FindBy(xpath = "//*[@id='browseResults']/h2[1]")
	WebElement contentAndAssignmentSection;
	@FindBy(xpath = "//*[@id='browseResults']/h2[2]")
	WebElement questionSection;
	@FindBy(className = "modeQuestions")
	WebElement questionButton;
	@FindBy(id = "more-resources-search-box")
	WebElement resourceSearchInput;
	@FindBy(css = "#search-results div:nth-child(2) .lnkMoreResourceItem")
	WebElement reourceSearchFirstResult;
	@FindBy(className = "question-list")
	WebElement questionList;
	@FindBy(id = "search-results")
	WebElement searchResults;
	@FindBy(xpath = "//a[contains(text(),'Content by chapter')]")
	WebElement resourceContentByChapter;
	@FindBy(css = ".fpimageLarge.unitImage")
	WebElement defaultImageForNewUnit;
	@FindBy(css = ".edit.link.button")
	WebElement editLinkChapterGearWindow;
	@FindBy(id = "fne-edit")
	WebElement editLinkContentGearWindow;
	@FindBy(css = ".formlist #Title")
	WebElement editUnitFolderTitle;
	@FindBy(css = ".last-viewed [class*=title] a")
	WebElement lastViewedTitle;
	@FindBy(className = "managementcard_students_show")
	WebElement showContentToStudent;
	@FindBy(className = "managementcard_students_hide")
	WebElement hideContentFromStudent;
	@FindBy(className = "item-submitted")
	WebElement tickMark;
	@FindBy(className = "management-card-unassign")
	WebElement unassignCourseLink;
	@FindBy(id = "unassign-item")
	WebElement confirmUnassignButton;
	@FindBy(css = ".moveorcopy.link.button")
	WebElement moveOrCopyLink;
	@FindBy(className = "btnMoveItem")
	WebElement confirmMoveButton;
	@FindBy(className = "btnCopyItem")
	WebElement confirmCopyButton;
	@FindBy(css = ".formlist #Title")
	WebElement copyContentTitle;
	@FindBy(css = ".savebtn[value=Save]")
	WebElement saveCopiedContent;
	@FindBy(css = "#faceplate-unit-subitems-PX_LAUNCHPAD_MOVECOPY_WIDGET .nodeExpanded+li")
	WebElement firstChildNodeOfCurrentChapterMoveOverlay;
	@FindBy(css = "#faceplate-unit-subitems-PX_LAUNCHPAD_MOVECOPY_WIDGET .nodeExpanded")
	WebElement currentChapterMoveOverlay;
	@FindBy(id = "faceplate-unit-subitems-PX_LAUNCHPAD_MOVECOPY_WIDGET")
	WebElement moveOrCopyWidget;
	@FindBy(className = "viewAllAssignments")
	WebElement showAssignmentCalendarLink;
	@FindBy(xpath = "//a[contains(./text(),'Start the Homework')]")
	WebElement startHomework;
	@FindBy(className = "start-quiz")
	WebElement startQuizButton;
	@FindBy(css = ".quiz-content .px-default-text")
	WebElement defaultMessageOnFnEPage;
	@FindBy(xpath = "//span[@class='item-title'][contains(text(),'Quiz')]")
	WebElement quiz;
	@FindBy(id = "Content_Title")
	WebElement quizTitle;
	@FindBy(id = "Content_SubTitle")
	WebElement quizSubTitle;
	@FindBy(id = "requireConfirmationQuestions")
	WebElement questionsTabLink;
	@FindBy(css = "a[id$=__1]")
	WebElement chapter1QuestionBankLearningCurve;
	@FindBy(linkText = "Test Bank 1")
	WebElement testBank1Link;
	@FindBy(linkText = "Test Bank")
	WebElement testBankLink;
	@FindBy(className = "add-available-question-at-top")
	WebElement addQuestionButton;
	String questionCheckBoxCss = ".questions>li:nth-child(%) input[type=checkbox]";

	@FindBy(id = "CW_SettingsButton")//.consolebutton #CW_SettingsButton
	WebElement settings;
	@FindBy(id = "#settingsAssignDueDate")
	WebElement assignduedate;
	@FindBy(css = ".instructor-console-link .link")
	WebElement editConsoleLinks;
	@FindBy(id = "#settingsAssignTime")
	WebElement assignduetime;
	@FindBy(id = "CW_Roster-groupsButton")
	WebElement rosterAndGroup;
	@FindBy(css = "[href$=StudentView]")
	WebElement studentview;
	@FindBy(xpath = "//ul[@class='CW_ActionLinks']/li/a/span[contains(text(),'View instructor console')]")
	WebElement viewInstructorConsoleLink;

	@FindBy(css = "#fne-title")
	WebElement resulttitle;

	@FindBy(xpath = "//div/span")
	WebElement score;
	@FindBy(css = "#submitlaunchPadForm")
	WebElement clickSave;
	@FindBy(css = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(1) .unitfptitle")
	WebElement firstChapterLink;
	@FindBy(css = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(2) .fptitle")
	WebElement firstChapterfirstUnitLink;
	@FindBy(css = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(3) a")
	WebElement firstChapterFirstUnitFirstTopicLink;
	//CodeByAyush
	@FindBy(css = "[href*=gradebook]")
	WebElement gradebookButton;
	@FindBy(css = "#add-assignment-btn")
	WebElement addButton;
	@FindBy(css = "#create")
	WebElement createButton;
	@FindBy(css = "#title-text")
	WebElement newassignment;
	@FindBy(css = "#TMP_429ef3606d6a45a695a8dd0225e_unit")
	WebElement unitButton;
	@FindBy(css = "#TMP_5639c5e11e83479abbaeff34beb94e16")
	WebElement discussionBoardButton;
	@FindBy(css = "#TMP_83a8a14d1cc34a54b84868257ac3f165")
	WebElement documentCollectionButton;
	@FindBy(css = "#TMP_95f884c8be2e430598f50e43c9058828")
	WebElement linkButton;
	@FindBy(css = "#TMP_dcef7cf5ba194495a7c86145b557bc15")
	WebElement homeWorkButton;
	@FindBy(css = "#TMP_a9435305a14e472ba2e503653c520538")
	WebElement htmlpageButton;
	@FindBy(css = "#TMP_95f884c8be2e430597f50e43c9057727")
	WebElement linkCollectionButton;
	@FindBy(css = "#TMP_88161c2783b949ed805d56fc5a1a1349")
	WebElement quizButton;
	@FindBy(css = "#TMP_79e70863484b443b81793043eb5c3a4f")
	WebElement learningCurveButton;
	@FindBy(css = "#TMP_8fb2fe4aa2f0494c8f6caa62eaabf101")
	WebElement dropboxButton;
	@FindBy(css = "#requireConfirmationBasicInfo")
	WebElement basicinfo;
	@FindBy(css = "#Content_Title")
	WebElement courseName;
	@FindBy(css = "#Content_SubTitle")
	WebElement coursesubtitle;
	@FindBy(css = ".savebtn.saveandopen")
	WebElement saveButton;
	@FindBy(css = "#fne-done")
	WebElement doneEditingButton;
	@FindBy(id = "fne-item-assign")
	WebElement assignButton;
	@FindBy(xpath = "(//td[@class='']/a/span)[20]")
	WebElement setDateTime;
	@FindBy(css = "#txtGradePoints")
	WebElement setpointsvalue;
	@FindBy(css = "#selgradebookweights")
	WebElement setgradebookcategory;
	@FindBy(xpath = "//select[contains(@class, 'selgradebookweights')]/option[./text()='Uncategorized']")
	WebElement uncategorized;
	@FindBy(xpath = "//select[contains(@class, 'selgradebookweights')]/option[./text()='Create new category']")
	WebElement newcategory;
	@FindBy(css = "#txtaddGBBcategory")
	WebElement categoryname;
	@FindBy(xpath = "(//input[@class='button small'])[2]")
	WebElement clickok;
	@FindBy(css = "#btnAssign")
	WebElement clickAssign;
	@FindBy(css = "#btnSaveChanges")
	WebElement saveChanges;
	@FindBy(css = "#fne-unblock-action-home")
	WebElement clickHome;
	@FindBy(css = "#CW_SettingsButton")
	WebElement settingsButton;
	@FindBy(css = "[href$=launchpad]")
	WebElement launchpadtab;
	@FindBy(css = "#launchpadItemsLink")
	WebElement launchpaditem;
	@FindBy(xpath = "html/body/div[9]/div[3]/div/button[1]")
	WebElement confirmRemove;
	@FindBy(xpath = "//div[contains(./text(),'You have not yet added any content to this unit.')]")
	WebElement unitsremoved;
	@FindBy(xpath = "(//a[contains(@class, 'faux-tree-link')])[1]")
	WebElement clickonquiz;
	@FindBy(css = "#requireConfirmationQuestions")
	WebElement addquestions;
	@FindBy(xpath = ".//*[@id='LOR_psychportal__myers10e__master_Chapter__1']/div/a")
	WebElement chap1;
	@FindBy(css = "//a[contains(@class, 'fne-link linkButton start-quiz faceplatefne')][./text()='Start the Quiz']")
	WebElement startthequiz;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Submit']")
	WebElement submitquiz;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Yes']")
	WebElement confirmsubmit;
	@FindBy(css = "#CW_InstructorConsole")
	WebElement viewinstructorconsole;
	@FindBy(css = "[href$=batchupdater]")
	WebElement batchupdater;
	@FindBy(xpath = "//a[@class='link'][contains(text(),'Gradebook Preferences')]")
	WebElement gradebookpreference;
	@FindBy(css = "#fromDate")
	WebElement fromdate;
	@FindBy(css = "#toDate")
	WebElement todate;
	@FindBy(xpath = "(//td[@class='']/a/span)[16]")
	WebElement setFromDate;
	@FindBy(xpath = "(//td[@class='']/a/span)[22]")
	WebElement setToDate;
	@FindBy(css = "#newDueDate")
	WebElement newduedate;
	@FindBy(xpath = "(//td[@class='']/a/span)[19]")
	WebElement setnewdueDate;
	@FindBy(css = "#btnBatchDueDateUpdate")
	WebElement updatedueDate;
	@FindBy(css = "#passingScore")
	WebElement passingscore;
	@FindBy(css = "#savePassingScore")
	WebElement savepassscore;
	@FindBy(css = "#showAssignments")
	WebElement showassignments;
	@FindBy(xpath = "//td[./text()='Sequence | Title']")
	WebElement sequencetitle;
	@FindBy(xpath = "//td[./text()='//td[./text()='Drop Lowest']")
	WebElement droplowest;
	@FindBy(xpath = "//td[./text()='Weight/Points']")
	WebElement weightpointscolumn;
	@FindBy(xpath = "//td[./text()='% of Total']")
	WebElement percentoftotal;
	@FindBy(xpath = "(//input[@class='removeCategory'])[1]")
	WebElement removecat;

	//@FindBy(xpath="((//a[contains(./text(), 'CHAPTER INTRODUCTION')])[1])//following::input[1]")
	//WebElement assignquiz;


	@FindBy(css = "#requireConfirmationQuestions")
	WebElement clickquestiontab;


	@FindBy(xpath = "(//span[@class='unitfptitle'])[2]")
	WebElement clickchapter1;
	@FindBy(xpath = "(//span[@class='unitfptitle'])[3]")
	WebElement clickchapter2;
	@FindBy(xpath = "(//span[@class='unitfptitle'])[4]")
	WebElement clickchapter3;
	@FindBy(xpath = "(//span[@class='fptitle']/a[@class='faux-tree-link'][contains(./text(), 'INTRODUCTION')])[1]")
	WebElement chapterintro1;
	//@FindBy(xpath = "((//span[@class='unitfptitle'])[3])/following::a[3]")
	@FindBy(xpath = "(//span[@class='fptitle']/a[@class='faux-tree-link'][contains(./text(), 'INTRODUCTION')])[1]")
	WebElement chapterintro2;
	@FindBy(xpath = "((//span[@class='unitfptitle'])[4])/following::a[contains(./text(), 'CHAPTER INTRODUCTION')]")
	//@FindBy(xpath = "(//span[@class='fptitle']/a[@class='faux-tree-link'][contains(./text(), 'CHAPTER INTRODUCTION')])[1]")
	WebElement chapterintro3;
	@FindBy(xpath = "((//span[@class='fptitle']/a[@class='faux-tree-link'][contains(./text(), 'INTRODUCTION')])[1])/following::input[@class='faceplate-item-assign '][1]")
	WebElement assignchapterintro1;
	@FindBy(xpath = "((//span[@class='unitfptitle'])[3])/following::a[contains(./text(), 'INTRODUCTION')]/following::input[1]")
	WebElement assignchapterintro2;
	@FindBy(xpath = "((//span[@class='unitfptitle'])[4])/following::a[contains(./text(), 'INTRODUCTION')]/following::input[1]")
	WebElement assignchapterintro3;
	@FindBy(css = ".collapse-menu.assign-showCalendar-close.button.primary.large")
	WebElement clickdoneassigning;
	//=================================================================

	//	@FindBy(css="#assessmentframebutton_76833a8c517c42e78f542fc5fac4bfcf_2")
	//	WebElement studentSubmitQuizButton;
	String unassignedChaptersGearIcon = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) .gearbox-icon.pxicon.pxicon-gear";
	@FindBy(css = "#tinymce")
	WebElement mceEditor;
	@FindBy(xpath = "//div[@class='new-question-menu']/div[@class='gearbox']")
	WebElement createmenu;
	@FindBy(css = ".multiple-answer>a")
	WebElement multipleanswers;
	@FindBy(xpath = "(//div[@class='x-panel-body x-panel-body-noheader']/textarea)[1]")
	WebElement questionname;
	@FindBy(xpath = "(//div[@class='x-panel-body x-panel-body-noheader']/textarea)[2]")
	WebElement choice1;
	@FindBy(xpath = "(//div[@class='x-panel-body x-panel-body-noheader']/textarea)[3]")
	WebElement choice2;
	@FindBy(xpath = "(//div[@class='x-panel-body x-panel-body-noheader']/textarea)[4]")
	WebElement choice3;
	@FindBy(xpath = "(//div[@class='x-panel-body x-panel-body-noheader']/textarea)[5]")
	WebElement choice4;
	@FindBy(xpath = "(//div[@class='x-panel-body x-panel-body-noheader']//input)[2]")
	WebElement correctanswer;
	@FindBy(id="loadingBlock")
	WebElement loadingBlock;


	@FindBy(xpath = "(//a[contains(./text(),'Cancel')])[1]")
	WebElement cancelstudentview;

	@FindBy(xpath = "(//div[@class='question-container'])[1]")
	WebElement questioncontainer;
	@FindBy(id = "hide_due_later")
	WebElement showDueAssignments;
	@FindBy(id = "collapse_all")
	WebElement showAllUnassigned;
	@FindBy(xpath = "((//div[@class='faceplate-move-resource-menu']/ul)[2]/li/a)[3]")
	WebElement addCopyToCurrentUnit;
	@FindBy(xpath = "((//div[@class='faceplate-move-resource-menu']/ul)[2]/li/a)[1]")
	WebElement removeFromThisUnit;
	@FindBy(xpath="//input[@class='x-form-checkbox x-form-field']")
	WebElement answerCheckBox;
	@FindBy(css = "#useWeightedCategories")
	WebElement useweightedcategories;
	@FindBy(xpath = "(//div[@class='gbg-tip'])[1]")
	WebElement scoreOfAttemptedQuiz;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement studentSubmitQuizButton;
	@FindBy(id="hide_past_due")
	WebElement showPastDueLink;
	@FindBy(xpath="(//ul[@id='faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET']/li/div/span[2][contains(text(),'Developing Through')])")
	WebElement randomlyClickChapter;

	public String clickOnFirstUnassignedChapterAndReturnChapterName() {
		String title = null;
		//		waitForElementToLoad(firstUnassignedChapterLink, waitForElementInMilliSeconds);
		for (int i = 1; i < 90; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, i))).isDisplayed()) {
					title = driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, i))).getText();
					driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, i))).click();
					System.out.println("Chapter title:"+title);
					break;
					
				}
			} catch (NoSuchElementException e) {
			}
		}
		//		firstUnassignedChapterLink);
		waitForSync(6000);
		return title.trim();
	}

	public String clickOnFirstUnassignedChapterAndReturnClassAttribute() {
		String attr = null;
		for (int i = 1; i < 20; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, i))).isDisplayed()) {
					driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, i))).click();
					waitForSync();
					attr = driver.findElement(By.cssSelector(replaceString(unassignedChapterLists, i))).getAttribute("class").toString();
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
		return attr.trim();
	}

	public String returnFirstUnassignedChapterClassAttribute() {
		String attr = null;
		for (int i = 1; i < 20; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, i))).isDisplayed()) {
					attr = driver.findElement(By.cssSelector(replaceString(unassignedChapterLists, i))).getAttribute("class").toString();
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
		return attr.trim();
	}

	public String clickOnSecondUnassignedChapterAndReturnClassAttribute() {
		String attr = null;
		for (int i = 1; i < 20; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, i))).isDisplayed()) {
					for (int j = i + 1; i < 20; j++) {
						try {
							if (driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, j))).isDisplayed()) {
								driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, j))).click();
								waitForSync();
								attr = driver.findElement(By.cssSelector(replaceString(unassignedChapterLists, j))).getAttribute("class").toString();
								break;
							}
						} catch (NoSuchElementException e) {
						}
					}
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
		waitForSync();
		return attr.trim();
	}

	public void clickOnAddLinkForFirstUnassignedChapter() {
		for (int i = 1; i < 20; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(addLinkForFirstUnassignedChater, i))).isDisplayed()) {
					driver.findElement(By.cssSelector(replaceString(addLinkForFirstUnassignedChater, i))).click();
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
	}

	public String clickOnFirstUnassignedChapterSubtopicAndReturnChapterName() {
		String title = null;
		waitForSync(5000);
		for (int i = 1; i < 50; i++) {
			System.out.println("loop counter: "+i);
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicLink, i))).isDisplayed()) {
					title = driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicLink, i))).getText();
					driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicLink, i))).click();
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
		waitForSync();
		System.out.println("Title of chapter:-"+title);
		return title.trim();
	}

	public boolean verifyTitleChanged(String title) {
		boolean matched = false;
		for (int i = 1; i < 20; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicText2, i))).isDisplayed()) {
					matched = driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicText2, i))).getText().contains(title);
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
		return matched;
		
	}

	public String clickOnFirstUnassignedChapterAndReturnChapterName(String chapter) {
		String title = null;
		try {
			waitForSync();
			driver.findElement(By.xpath(replaceString(chapterNamexPath, chapter))).click();
			title = driver.findElement(By.xpath(replaceString(chapterNamexPath, chapter))).getText().trim();
			waitForSync();
			return title.trim();
		} catch (Exception e) {
			scrollElementToView(driver, "unitfptitle", Integer.toString(Integer.parseInt(chapter)));
			waitForSync();
			title = driver.findElement(By.xpath(replaceString(chapterNamexPath, chapter))).getText().trim();
			waitForSync();
			return title.trim();
		}
		//		catch (NoSuchElementException ex){
		//			throw new NoSuchElementException("Element not found");
		//		}
	}

	public void clickFirstUnassignedChapterFirstUnit() {
		//waitForElementToLoad(firstUnassignedChapterfirstUnitLink, waitForElementInMilliSeconds);
		click(firstUnassignedChapterfirstUnitLink);
	}

	public void clickChapterIntroduction() {
		try {
			//waitForElementToLoad(driver.findElement(By.linkText("CHAPTER INTRODUCTION")), waitForElementInMilliSeconds);
			click(driver.findElement(By.linkText("CHAPTER INTRODUCTION")));
		} catch (Exception e) {

			//waitForElementToLoad(driver.findElement(By.xpath("(//a[@class='faux-tree-link'][contains(text(),'INTRODUCTION')])[1]")), waitForElementInMilliSeconds);
			click(driver.findElement(By.xpath("(//a[@class='faux-tree-link'][contains(text(),'INTRODUCTION')])[1]")));
		}
		waitForSync();
	}

	public void clickPartIntroduction() {
		click(driver.findElement(By.linkText("PART INTRODUCTION")));
		waitForSync();
	}

	public void clickSupplementaryExercises() {
		click(driver.findElement(By.linkText("SUPPLEMENTARY EXERCISES")));
		waitForSync();
	}



	public void clickFirstUnassignedChapterFirstUnitFirstTopic() {
		waitForElementToLoad(firstUnassignedChapterFirstUnitFirstTopicLink, waitForElementInMilliSeconds);
		selectedTopic = getTopicName();
		click(firstUnassignedChapterFirstUnitFirstTopicLink);
	}

	public boolean activateCourseLinkAppears() {
		try {
			waitForSync();
			return activateCourseLink.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void navigateBackToMyCoursesPage() {
		Select dropdown = new Select(selectDropdownOptions);
		//        dropdown.selectByVisibleText("View My Courses/Create New...");
		dropdown.selectByVisibleText("Switch/Create New Courses");
		waitForSync();
	}

	public String getCourseUrl() {
		if (courseURL1 != null) {
			return courseURL1;
		} else {
			setCourseUrl();
		}
		return courseURL1;
	}

	public void setCourseUrl() {
		courseURL1 = driver.getCurrentUrl();
		System.out.println("Created Course URL: " + courseURL1+"/Home#/launchpad");
	}

	public void setCourseUrlNC(){
		courseURL1 = courseURL+"/Home#/launchpad";
	}

	public String getCourseUrlNC(){
		if (courseURL1 != null) {
			return courseURL1;
		} else {
			setCourseUrlNC();
		}
		return courseURL1;
	}

	public void clickRosterAndGroupButton() {
		waitForElementToLoad(rosterAndGroupButton, waitForElementInMilliSeconds);
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + rosterAndGroupButton.getLocation().y + ")");
		click(rosterAndGroupButton);
		if (!driver.getCurrentUrl().contains("managegroups")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('CW_Roster-groupsButton').click();");
		}
	}

	public void enterTextPoints(String points) {
		textGradePoints.clear();
		textGradePoints.sendKeys(points);
	}

	public void selectGradeBookCategoryAsUncategorized() {
		Select select = new Select(gradeBookCategory);
		select.selectByVisibleText("Uncategorized");
	}

	public void clickSubmitButtonOnAssignForm() {
		try {
			//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + assignCourseDoneButton.getLocation().y + ")");
			click(assignCourseDoneButton);
			waitForSync();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			alert.accept();
			waitForSync();
		} catch (Exception e) {
		} waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		waitForSync(7000);
	}
	String assignedChapterName1 = "#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) span[class*=title]:not(.item_subtitle)";
	String assignedunitName1 = "#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%).unitrowlevel1 span[class*=title]:not(.item_subtitle)";
	String assignedChapterName2 = "#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) span[class*=title]:not(.item_subtitle)>a";
	String assignedChapter = "#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%)";

	public void waitForLoadingBlockToDisappear(){
		try{
			if (loadingBlock.isDisplayed()){
				waitForSync(500);
			}
		}catch (NoSuchElementException e){
		}catch (StaleElementReferenceException e){
		}
	}
	public boolean hoverOverDateIconAndRetunIsDateDisplayed(String chapterName, String dueDate, String dueTime, String timeZoneExpected) {
		waitForSync(5000);
		waitForLoadingBlockToDisappear();
		String nameToHover = null, date = null, time = null, timeZone = null;
		for (int j = 1; j < driver.findElements(By.cssSelector("#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li")).size(); j++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(assignedChapterName1, j))).getText() != null) {
					nameToHover = driver.findElement(By.cssSelector(replaceString(assignedChapterName1, j))).getText();
				} else {
					nameToHover = driver.findElement(By.cssSelector(replaceString(assignedChapterName2, j))).getText();
				}
				if (nameToHover.equalsIgnoreCase(chapterName)) {
					date = driver.findElement(By.cssSelector(replaceString(assignedChapter, j))).getAttribute("data-ud-due-date");
					time = driver.findElement(By.cssSelector(replaceString(assignedChapter, j))).getAttribute("data-ud-due-time");
					timeZone = driver.findElement(By.id("TimeZoneAbbreviation")).getAttribute("value");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dueDate.equals(date) && dueTime.equals(formatTime(time)) && timeZoneExpected.equalsIgnoreCase(timeZone);
	}

	public boolean hoverOverDateIconAndRetunIsDateRangeDisplayedForUnit(String startDate, String dueDate, String dueTime, String timeZoneExpected) {
		waitForSync(5000);
		waitForLoadingBlockToDisappear();
		String date = null, time = null, timeZone = null, dateStart = null;
		dateStart = driver.findElement(By.cssSelector(".faux-tree-node.unitrowlevel1.nodeExpanded")).getAttribute("data-ud-start-date");
		date = driver.findElement(By.cssSelector(".faux-tree-node.unitrowlevel1.nodeExpanded")).getAttribute("data-ud-due-date");
		time = driver.findElement(By.cssSelector(".faux-tree-node.unitrowlevel1.nodeExpanded")).getAttribute("data-ud-due-time");
		timeZone = driver.findElement(By.id("TimeZoneAbbreviation")).getAttribute("value");
		return dueDate.equals(date) && dueTime.equals(formatTime(time)) && timeZoneExpected.equalsIgnoreCase(timeZone) && startDate.equals(dateStart);
	}

	public String formatTime(String time) {
		String a = time;
		String[] b = a.split(":");
		String c = b[2].split(" ")[1];
		a = b[0] + ":" + b[1] + " " + c;
		return a;
	}

	public void addNewItem() {
		//waitForElementToLoad(addButtonLink, waitForElementInMilliSeconds);
		click(addButtonLink);
		waitForSync(1000);
	}

	public boolean createNewItemAndBrowseItemOptionsDisplayed() {
		waitForElementToLoad(createNewOptionLink, waitForElementInMilliSeconds);
		return createNewOptionLink.isDisplayed() && browseResourceOptionlink.isDisplayed();
	}

	public void createNewItem() {
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createNewOptionLink);
		click(createNewOptionLink);
		waitForSync();
	}

	public boolean variousCreateOptionsDisplayed() {
		waitForElementToLoad(allNewOptionsList, waitForElementInMilliSeconds);
		return allNewOptionsList.isDisplayed();
	}

	public void addNewLearningCurve() {
		click(learningCurveOptionLink);
		waitForSync();
	}

	public void addNewQuiz() {
		click(quizOptionLink);
		waitForSync();
	}

	public void unassignedIt() {
		click(driver.findElement(By.xpath("//span[@class='fne-action-status']/a/div/div/div/span/span")));
		waitForSync();
		click(driver.findElement(By.id("btnUnassign")));
		waitForSync();
	}

	public void addNewDiscussionBoard() {
		click(discussionBoardOptionLink);
		waitForSync();
	}

	public void addNewDocumentCollection() {
		click(documentCollectionOptionLink);
		waitForSync();
	}

	public void addNewUnit() {
		click(unitOptionLink);
		waitForSync();
	}

	public void addNewHomeWork() {
		click(homeWorkOptionLink);
		waitForSync();
	}

	public void addNewLinkCollection() {
		click(linkCollectionOptionLink);
		waitForSync();
	}

	public void addNewLink() {
		click(linkOptionLink);
		waitForSync();
	}

	public void addNewHtmlPage() {
		click(htmlPageOptionLink);
		waitForSync();
	}

	public void addNewDropBox() {
		click(dropboxOptionLink);
		waitForSync();
	}

	public void clickLearningCurveOption() {
		for (WebElement toClick : driver.findElements(By.className("faux-tree-link"))) {
			if (toClick.getText().trim().contains("TestLearningCurve")) {
				toClick.click();
				break;
			}
		}
		waitForSync();
	}

	public void clickResourceButton() {
		//waitForElementToLoad(resourceButton, waitForElementInMilliSeconds);
		waitForSync();
		click(resourceButton);
	}

	public boolean resourcesOverlayButtonsDispalyed(String user) {
		waitForSync();
		//		waitForElementToLoad(contentAndAssignmentSection, waitForElementInMilliSeconds);
		if (user.equalsIgnoreCase("Instructor")) {
			return contentAndAssignmentSection.isDisplayed() && questionSection.isDisplayed();
		} else {
			return contentAndAssignmentSection.isDisplayed();
		}
	}

	public boolean resourcesOverlayButtonsDispalyedWhenSearchIsEmpty(String user) {
		  waitForSync();
		  //  waitForElementToLoad(contentAndAssignmentSection, waitForElementInMilliSeconds);
		  clickOnBreadcrumbResource();
		  if (user.equalsIgnoreCase("Instructor")) {
		   return contentAndAssignmentSection.isDisplayed() && questionSection.isDisplayed();
		  } else {
		   return contentAndAssignmentSection.isDisplayed();
		  }
		 }
	
	public void enterSearchTermForResourceOverlay(String term) {
		resourceSearchInput.clear();
		resourceSearchInput.sendKeys(term);
		waitForSync();
	}

	public boolean isRelevantSearchTermDisplayed(String term) {
		waitForElementToLoad(reourceSearchFirstResult, waitForElementInMilliSeconds);
		StringBuilder sb= new StringBuilder();
		for (WebElement searchtext:driver.findElements(By.cssSelector("#search-results div .lnkMoreResourceItem"))){
			sb.append(searchtext.getText().trim().toLowerCase()).append(" ");
		}
		//        return reourceSearchFirstResult.getText().trim().toLowerCase().contains(term.toLowerCase());
		return sb.toString().contains(term.toLowerCase());
	}

	public boolean questionButtonDisplayed() {
		return questionButton.isDisplayed();
	}

	public boolean searchResultsDisplayed() {
		return searchResults.isDisplayed();
	}

	public boolean resourceSearchDialogOptionDisplayedForInstructor() {
		return searchResultsDisplayed() && questionButtonDisplayed();
	}

	public boolean resourceSearchDialogOptionDisplayedForStudnet() {
		return searchResultsDisplayed();
	}

	public void clickQuestionsTab() {
		click(questionButton);
		waitForSync();
	}

	public boolean questionsListDisplayed() {
		waitForElementToLoad(questionList, waitForElementInMilliSeconds);
		return questionList.isDisplayed();
	}

	public boolean createdItemDisplayed(String text) {
		try {
			return verifyItemCreatedWithLinkText(text);
		} catch (Exception e) {
			return verifyItemCreatedWithText(text);
		}
	}

	public boolean createdItemDisplayedFullTitle(String text) {
		try {
			return verifyItemCreatedWithLinkTextFullTitle(text);
		} catch (NoSuchElementException e) {
			return verifyItemCreatedWithTextFullTitle(text);
		}
	}

	public boolean verifyItemCreatedWithLinkText(String text) {
		waitForElementToLoad(driver.findElement(By.partialLinkText(text + timeCreated)), waitForElementInMilliSeconds);
		return driver.findElement(By.partialLinkText(text + timeCreated)).isDisplayed();
	}

	public boolean verifyItemCreatedWithText(String text) {
		waitForSync(4000);
		for (WebElement a : driver.findElements(By.className("unitfptitle"))) {
			if (a.getText().trim().contains(text + timeCreated)) {
				return true;
			}
		}
		return false;
	}

	public boolean verifyItemCreatedWithLinkTextFullTitle(String text) {
		waitForElementToLoad(driver.findElement(By.partialLinkText(text)), waitForElementInMilliSeconds);
		return driver.findElement(By.partialLinkText(text)).isDisplayed();
	}

	public boolean verifyItemCreatedWithTextFullTitle(String text) {
		for (WebElement a : driver.findElements(By.className("unitfptitle"))) {
			if (a.getText().trim().contains(text)) {
				return true;
			}
		}
		return false;
	}

	public void clickResourceContentByChapterOption() {
		//waitForElementToLoad(resourceContentByChapter, waitForElementInMilliSeconds);
		click(resourceContentByChapter);
		waitForSync();
	}

	public boolean contentByChapterDiplayedInOrder() {
		int a = 0;
		try{
			for (int i = 1; i < 10; i++) {
				if (!driver.findElements(By.cssSelector("#search-results .fptitle>a")).get(i).getText().matches("Chapter [0-9].*")) {
					a += 1;
				}
			}
		}
		catch(IndexOutOfBoundsException e){

		}
		//for chrome and IE
		//return true;
		return (a == 0) ? true : false;
	}

	public boolean createNewUnitDefaultImageDisplayed() {
		return defaultImageForNewUnit.isDisplayed();
	}

	public void clickAssignButtonForFirstUnassignedChapterFirstUnitAndReturnItsName() {
		hoverOverFirstUnassignedContent();
		waitForSync();
		gearDisplayedForChapter();
	}

	public String hoverOverNextContentOfPreviouslyAssignedContentOpenAssignWindowAndReturnContentName() {
		String name = null;
		expandFirstAssignedContentCollapsedContent();
		for (int i = 1; i < 20; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(assignButtonForNextContentToAssignWhichIsAlreadyAssigned, i))).isEnabled()) {
					Actions hoverOver = new Actions(driver);
					hoverOver.moveToElement(driver.findElement(By.cssSelector(replaceString(nextContentToBeAssigned, i)))).build().perform();
					//                    waitForSync(5000);
					driver.findElement(By.cssSelector(replaceString(assignButtonForNextContentToAssignWhichIsAlreadyAssigned, i))).click();
					if (driver.findElement(By.cssSelector(replaceString(assignedChapterName1, i))).getText() != null) {
						name = driver.findElement(By.cssSelector(replaceString(assignedChapterName1, i))).getText();
					} else {
						name = driver.findElement(By.cssSelector(replaceString(assignedChapterName2, i))).getText();
					}
					break;
				}
			} catch (NoSuchElementException e) {
			}
			catch (ElementNotVisibleException e) {
			    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + driver.findElement(By.cssSelector(replaceString(assignButtonForNextContentToAssignWhichIsAlreadyAssigned, i))).getLocation().y + ")");
			   }
		}
		return name;
	}

	public String hoverOverFirstUnassignedChapterAndReturnChapterName() {
		String title = null;
		for (int i = 1; i < 20; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterLists, i))).isDisplayed()) {
					Actions hoverOver = new Actions(driver);
					title = driver.findElement(By.cssSelector(replaceString(unassignedChapterLink, i))).getText().trim();
					hoverOver.moveToElement(driver.findElement(By.cssSelector(replaceString(unassignedChapterLists, i)))).build().perform();
					//					waitForSync(5000);
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
		return title;
	}

	public void openContentByContentNameAppendTime(String contentName) {
		click(driver.findElement(By.linkText(contentName + timeCreated)));
		waitForSync();
	}

	public void openContentByContentName(String contentName) {
		click(driver.findElement(By.linkText(contentName)));
		waitForSync();
	}

	public void openContentByContentNameCreated() {

		try{
			waitForElementToLoad(driver.findElement(By.linkText(itemCreated)), waitForElementInMilliSeconds);
			waitForSync();
			//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + driver.findElement(By.linkText(itemCreated)).getLocation().y + ")");
			click(driver.findElement(By.linkText(itemCreated)));
			waitForSync();
		} catch (NoSuchElementException e){
			click(showPastDueLink);
			click(driver.findElement(By.linkText(itemCreated)));
			waitForSync();
		}
	}

	public String getFirstUnassignedContentTitle() {
		
		for (int i = 1; i < 20; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicText, i))).isDisplayed()) {
					return driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicText, i))).getText().trim();
				}
			} catch (NoSuchElementException e) {
				
			}
		}
		return null;
	}

	public void hoverOverFirstUnassignedContent() {
		waitForSync();
		for (int i = 1; i < 50; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicText, i))).isDisplayed()) {
					driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicText, i))).getText().trim();

					if(driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicText, i))).getText().contains("INTRODUCTION")){
						Actions hoverOver = new Actions(driver);
						hoverOver.moveToElement(driver.findElement(By.cssSelector(replaceString(unassignedChapterSubtopicText, i)))).build().perform();
						break;
					}


					//                    waitForSync(5000);

				}
			} catch (NoSuchElementException e) {
				//String unassignedChapterSubtopicText = "#faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) .fptitle"; 
				
			}
		}
	}

	public void gearDisplayedForChapter() {
		for (int i = 1; i < 50; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(unassignedChapterLists, i))).isDisplayed()) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
							driver.findElement(By.cssSelector(replaceString(unassignedChaptersGearIcon, i))));
					waitForSync(1000);
					driver.findElement(By.cssSelector(replaceString(unassignedChaptersGearIcon, i))).click();
					break;
				}
			} catch (NoSuchElementException e) {
			}
			catch(ElementNotVisibleException ex){
				((JavascriptExecutor)driver).executeScript("document.getElementById('faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET').getElementsByClassName('gearbox-icon pxicon pxicon-gear')[4].click();");
			}
		}
	}

	public void clickEditLinkForChapterOnGearManagementCard() {
		waitForElementToLoad(editLinkChapterGearWindow, waitForElementInMilliSeconds);
		scrollElementToView(driver, "edit", "0");
	}

	public void clickEditLinkForContentOnGearManagementCard() {
		waitForElementToLoad(editLinkContentGearWindow, waitForElementInMilliSeconds);
		scrollElementToView(driver, "fne-edit");
	}

	public boolean verifyQuizEditOptions() {
		waitForSync(3000);
		List<WebElement> editingOptions = driver.findElements(By.xpath("(//ul[@id='content-modes']/li/a)"));
		WebElement basicInfo = editingOptions.get(0);
		WebElement assignment = editingOptions.get(1);
		WebElement settings = editingOptions.get(2);
		WebElement questions = editingOptions.get(3);
		return basicInfo.getText().trim().contains("Basic Info") && assignment.getText().trim().contains("Assignment") && settings.getText().trim().contains("Settings") && questions.getText().trim().contains("Questions");
	}

	public void basicinfoOption() {
		waitForSync();
		List<WebElement> editingOptions = driver.findElements(By.xpath("(//ul[@id='content-modes']/li/a)"));
		WebElement basicInfo = editingOptions.get(0);
		click(basicInfo);
	}

	public void assignmentOption() {
		waitForSync();
		List<WebElement> editingOptions = driver.findElements(By.xpath("(//ul[@id='content-modes']/li/a)"));
		WebElement assignment = editingOptions.get(1);
		click(assignment);
	}

	public void fillAssignmentValues(String points) {

		waitForSync();
		//enterDueDate1(DateUtil.fixedDate());
		setDateTimeField();
		waitForSync();
		//	enterDueTime1(time);
		enterGradeBookFieldSetValues(points);
		waitForSync();
		clickAssignAgain();
		waitForSync();
		driver.navigate().refresh();
		//		waitForSync();

	}
	
	public void unassignQuiz(){
		waitForSync(5000);
		driver.findElement(By.id("btnUnassign")).click();
		waitForSync(4000);
	}

	public void settingsOption() {
		waitForSync(3000);
		List<WebElement> editingOptions = driver.findElements(By.xpath("(//ul[@id='content-modes']/li/a)"));
		WebElement settings = editingOptions.get(2);
		click(settings);
		waitForSync(4000);
	}

	public void questionsOption() {
		waitForSync();
		List<WebElement> editingOptions = driver.findElements(By.xpath("(//ul[@id='content-modes']/li/a)"));
		WebElement questions = editingOptions.get(3);
		click(questions);
	}

	public void editTitleOfUnitOrFolder(String title) {
		waitForElementToLoad(editUnitFolderTitle, waitForElementInMilliSeconds);
		editUnitFolderTitle.clear();
		editUnitFolderTitle.sendKeys(title + timeCreated);
	}

	public boolean lastViewedItemIsIndicated(String title) {
		return lastViewedTitle.getText().trim().contains(title);
	}

	public void hoverOverLastCreatedContent() {
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(lastViewedTitle).build().perform();
		waitForSync();
	}

	public boolean clickYesToHideContentFromStudent() {
		waitForElementToLoad(showContentToStudent, waitForElementInMilliSeconds);
		if (showContentToStudent.isDisplayed()) {
			scrollElementToView(driver, "managementcard_students_show", "0");
			FandEPageUi fandEPageUi = new FandEPageUi(driver);
			return fandEPageUi.messageFlyerDisplayed(".* has been made invisible to students.");
		}
		if (hideContentFromStudent.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickNoToHideContentFromStudent() {
		waitForElementToLoad(hideContentFromStudent, waitForElementInMilliSeconds);
		if (hideContentFromStudent.isDisplayed()) {
			scrollElementToView(driver, "managementcard_students_hide", "0");
			FandEPageUi fandEPageUi = new FandEPageUi(driver);
			return fandEPageUi.messageFlyerDisplayed(".* has been made visible to students.");
		}
		if (showContentToStudent.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean greeTickMarkIsDisplayed() {
		return tickMark.isDisplayed();
	}

	public int greeTickMarkHitCount() {
		return driver.findElements(By.className("item-submitted")).size();
	}

	public void expandFirstAssignedContentCollapsedContent() {
		for (int i = 1; i < 10; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(firstAssignedContentExpandButton, i))).isDisplayed()) {
					driver.findElement(By.cssSelector(replaceString(firstAssignedContentExpandButton, i))).click();
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
	}

	public void expandFirstUnAssignedContentCollapsedContent() {
		for (int i = 1; i < 10; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(firstUnAssignedContentExpandButton, i))).isDisplayed()) {
					driver.findElement(By.cssSelector(replaceString(firstUnAssignedContentExpandButton, i))).click();
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
	}

	public void studentClickAssignedChapterAndSeeContentAvailable(String chName) {
		for (int i = 1; i < 500; i++) {
			try {
				driver.findElement(By.cssSelector(replaceString(assignedunitName1, i))).click();
				waitForSync(5000);
				{
					if (driver.findElement(By.linkText(chName)).isDisplayed()) {
					}
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	int prevAssignedContentsCount, latestAssignedContentsCount;

	public void hoverOverExpandedAssignContentAndClickOnGearIconDisplayed() {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,50)");
		prevAssignedContentsCount = driver.findElements(By.cssSelector("#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li.unitrowlevel1")).size();
		waitForElementToLoad(expandedAssignedChapter, waitForElementInMilliSeconds);
		Actions hover = new Actions(driver);
		hover.moveToElement(expandedAssignedChapter).build().perform();
		waitForSync();
		click(expandedAssignedChapterGearIcon);
	}

	public boolean unassignTheAssignedContent() {
		waitForElementToLoad(unassignCourseLink, waitForElementInMilliSeconds);
		click(unassignCourseLink);
		click(confirmUnassignButton);
		waitForSync(5000);
		latestAssignedContentsCount = driver.findElements(By.cssSelector("#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li.unitrowlevel1")).size();
		return latestAssignedContentsCount < prevAssignedContentsCount;
	}

	public void clickMoveOrCopy() {
		waitForElementToLoad(moveOrCopyLink, waitForElementInMilliSeconds);
		scrollElementToView(driver, "moveorcopy", "0");
		try {
			click(moveOrCopyLink);
		} catch (Exception e) {
		}
		waitForSync(5000);
	}

	public void insructorChoosesAItemWhereToMove() {
		waitForElementToLoad(firstChildNodeOfCurrentChapterMoveOverlay, waitForElementInMilliSeconds);
		//        waitForSync(5000); //used as move target doesn't display on webdriver window
		//        scrollElementToView(driver, "nodeExpanded", "1");
		//        firstChildNodeOfCurrentChapterMoveOverlay);
		//        waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementById('faceplate-unit-subitems-PX_LAUNCHPAD_MOVECOPY_WIDGET').children[0].nextSibling.children[1].click();");
	}

	public void insructorChoosesAItemWhereToCopy() {
		waitForElementToLoad(currentChapterMoveOverlay, waitForElementInMilliSeconds);
		if (currentChapterMoveOverlay.isDisplayed()){
			//TODO: hardWaitAsApplicationIsClickingSomeElseElement
			waitForSync(5000);
		} else {
			throw new ElementNotVisibleException("Current SelectionNot Expanded");
		}
	}

	public boolean moveOrCopyWidgetDisplayed() {
		waitForElementToLoad(moveOrCopyWidget, waitForElementInMilliSeconds);
		return moveOrCopyWidget.isDisplayed();
	}

	public void instructorSelectsMoveButton() {
		click(confirmMoveButton);
	}

	public void instructorSelectsCopyButton() {
		click(confirmCopyButton);
	}

	public boolean isItemMoved(String title) {
		boolean a;
		a = !title.equalsIgnoreCase(getFirstUnassignedContentTitle());
		driver.navigate().refresh();
		return a;
	}

	public boolean copyContentTitleWindowDisplayed() {
		waitForElementToLoad(copyContentTitle, waitForElementInMilliSeconds);
		return copyContentTitle.isDisplayed() && copyContentTitle.getAttribute("value").contains("copy");
	}

	public void enterCopiedContentNameAndClickSaveAndReturnIsContentDisplayed() {
		String linkText = "CopiedContent" + timeCreated;
		copyContentTitle.clear();
		copyContentTitle.sendKeys(linkText);
		click(saveCopiedContent);
		waitForSync();
		//return driver.findElement(By.linkText(linkText)).isDisplayed();
	}

	//CodeByAyush
	public void dropboxButton() {
		waitForSync();
		click(dropboxButton);
		waitForSync();
	}

	public void instructorEnterCreatedQuiz() {
		waitForSync();
		click(driver.findElement(By.linkText("TestQuiz" + timeCreated1)));
		waitForSync();
	}


	public void instructorEnterCreatedQuiz2() {
		waitForSync();
		System.out.println("\n\n"+timeCreated1+"\n\n");
		click(driver.findElement(By.linkText("Qait" + timeCreated1)));
		//waitForElementToLoad(homeButton, waitForElementInMilliSeconds);
		waitForSync(4000);
	}

	public void enterQuizDetailsForQuestionPicker(String quizname) {
		waitForElementToLoad(courseName, waitForElementInMilliSeconds);
		waitForSync();
		courseName.clear();
		waitForSync();
		timeCreated1 = DateUtil.getCurrentDateTime();
		courseName.sendKeys(quizname + timeCreated1);
		waitForSync();
	}
	public static String timeCreated1 = "";
	public static String a = "";
	String studnetAnswersQuestion = "(//*[@class='examQuestionTable']//*[@title='Choice %'])[#]";
	//===================================================================

	public LaunchpadHomeUi(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isLaunchPadMenuDisplayed() {
		waitForElementToLoad(menuItemLaunchpad, waitForElementInMilliSeconds);
		return menuItemLaunchpad.isDisplayed();
	}

	public String getTopicName() {
		return firstChapterFirstUnitFirstTopicLink.getText().trim();
	}

	public void clickOnFirstChapter() {
		click(firstChapterLink);
	}

	public void clickFirstChapterFirstUnit() {
		//waitForElementToLoad(firstChapterfirstUnitLink, waitForElementInMilliSeconds);
		click(firstChapterfirstUnitLink);
	}

	public void clickFirstChapterFirstUnitFirstTopic() {
		waitForElementToLoad(firstChapterFirstUnitFirstTopicLink, waitForElementInMilliSeconds);
		selectedTopic = getTopicName();
		click(firstChapterFirstUnitFirstTopicLink);
	}

	public void clickLogOut() {
		try {
			waitForSync();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logOut);
			scrollElementToView(driver, "student-login");
			click(logOut);
			driver.manage().deleteAllCookies();
			waitForSync(3000);
		} catch (WebDriverException e) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('logout-button').click();");
		}
	}

	public void clickActivateCourse() {
		waitForSync();
		click(activateCourseLink);
	}

	public boolean activateCoursePopUpAppears(String activateCourse) {
		waitForSync();
		return activateCoursePreHeading.getText().trim().equalsIgnoreCase(activateCourse);
	}

	public void clickActivateCourseButton() {
		click(activateCourseDialogButton);
	}

	public boolean courseActivatedSuccessPopUpAppears(String activateCourse) {
		waitForSync();
		return activateCoursePostHeading.getText().trim().equalsIgnoreCase(activateCourse);
	}

	public void clickDoneButton() {
		click(activateCourseSecondDialogButton);
	}

	//CodeByAyush
	public void clickGradebookButton() {
		waitForSync();
		waitForElementToLoad(gradebookButton, waitForElementInMilliSeconds);
		assert gradebookButton.getText().trim().contains("Gradebook");
		click(gradebookButton);
		waitForSync();
	}

	public void clickAddButton() {
		waitForSync(5000);
		assert addButton.getText().trim().contains("Add");
		click(addButton);
		waitForSync();
	}

	public void clickCreateButton() {
		waitForSync();
		assert createButton.getText().trim().contains("Create new");
		click(createButton);
		waitForSync();
		waitForElementToLoad(newassignment, waitForElementInMilliSeconds);
		waitForSync();
	}

	public void unitButton() {
		waitForSync();
		click(unitButton);
		waitForSync();
	}

	public void discussionboardButton() {
		waitForSync();
		click(discussionBoardButton);
		waitForSync();
	}

	public void documentcollectionButton() {
		waitForSync();
		click(documentCollectionButton);
		waitForSync();
	}

	public void linkButton() {
		waitForSync();
		click(linkButton);
		waitForSync();
	}

	public void homeworkButton() {
		waitForSync();
		click(homeWorkButton);
		waitForSync(5000);
	}

	public void htmlpageButton() {
		waitForSync();
		click(htmlpageButton);
		waitForSync();
	}

	public void linkcollectionButton() {
		waitForSync();
		click(linkCollectionButton);
		waitForSync();
	}

	public void clickQuizButton() {
		waitForSync();
		click(quizButton);
		waitForSync(5000);
	}

	public void learningcurveButton() {
		waitForSync();
		click(learningCurveButton);
		waitForSync();
	}

	public void clickSettingsButton() {
		waitForSync();
		click(settingsButton);
		waitForSync();
	}

	public void clickLaunchpadButton() {
		waitForSync();
		click(launchpadtab);
		waitForSync();
	}

	public void clickLaunchpadItem() {
		waitForSync();
		click(launchpaditem);
		waitForSync();
	}
	public void setDateTimeField() {
		waitForSync(6000);
		for (int i = 0; i < 3; i++) {
			click(driver.findElement(By.className("datepickerGoNext")));
			//driver.findElement(By.cssSelector(".datepickerGoNext>a>span")).click();
			waitForSync();
		}
		click(setDateTime);
		waitForSync();
	}

	public void setPoints(String points) {
		waitForSync();
		click(setpointsvalue);
		setpointsvalue.sendKeys(points);
		waitForSync();
	}

	public void setCategory(String category){
		waitForSync();
		setpointsvalue.sendKeys(Keys.TAB);
		waitForSync();
		setgradebookcategory.sendKeys(Keys.ARROW_UP);
		waitForSync();
		setgradebookcategory.sendKeys(Keys.TAB);

		waitForElementToLoad(clickok, waitForElementInMilliSeconds);
		String randomNum = DateUtil.getCurrentDateTime();
		try{
			waitForElementToLoad(categoryname,20000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", categoryname);
			click(categoryname);
			waitForSync();
		}catch (Exception e){
			((JavascriptExecutor)driver).executeScript("document.getElementById('txtaddGBBcategory'));");
		}
		categoryname.sendKeys(category.replace("_DDMMM_HHMM", randomNum ));
		waitForSync();
		click(clickok);
	}

	public void clickAssignAgain() {
		try{
			waitForElementToLoad(clickAssign,10000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickAssign);
			click(clickAssign);
			waitForSync();
		}catch (Exception e){
			((JavascriptExecutor)driver).executeScript("document.getElementById('btnAssign'));");
		}
		waitForSync();
	}

	public boolean confirmRemovalOfItem() {
		waitForSync();
		click(confirmRemove);
		waitForSync();
		driver.navigate().refresh();
		waitForSync();
		return launchpaditem.getText().trim().contains("Add these units to your course?");
	}

	public boolean areunitsremoved() {
		waitForSync();
		return addButton.isDisplayed();
	}

	public boolean addunits() {
		waitForSync();
		click(launchpaditem);
		waitForSync();
		click(clickSave);
		waitForSync();
		return launchpaditem.getText().trim().contains("Remove these units from your course?");
	}

	public boolean confirmadditionofitem() {
		waitForSync();
		return clickchapter1.isDisplayed();
	}


	public void hoverOverContentByContentName(String contentName) {
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(driver.findElement(By.linkText(contentName + timeCreated))).build().perform();
		waitForSync();
	}

	public void clickGearDisplayedForContent() {
		waitForSync();
		for (int i = 0; i < 50; i++) {
			try {
				if(driver.findElement(By.cssSelector(replaceString(unassignedChaptersGearIcon, i))).isDisplayed()){
					driver.findElement(By.cssSelector(replaceString(unassignedChaptersGearIcon, i))).click();

					break;
				}
			} catch (Exception et) {
				((JavascriptExecutor)driver).executeScript("document.getElementById('faceplate-unit-subitems-unassigned-PX_LAUNCHPAD_ASSIGNED_WIDGET').getElementsByClassName('gearbox-icon pxicon pxicon-gear')[4].click();");
			}
		}


	}

	public void assignContent(String time, String points) {
		if (isAssignDateWindowDisplayed()) {
			enterDueDate(DateUtil.fixedDate());
			enterDueTime(time);
			enterGradeBookFieldSetValues(points);
			// clickSubmitButtonOnAssignForm();

			click(clickdoneassigning);
			waitForSync(3000);

		}
	}

	public boolean isAssignDateWindowDisplayed() {
		waitForElementToLoad(assignCourseDetailWindowDisplayed, waitForElementInMilliSeconds);
		return assignCourseDetailWindowDisplayed.isDisplayed();
	}

	public void enterDueDate(String duedate) {
		assignCourseDueDateInput.clear();
		waitForSync();
		assignCourseDueDateInput.sendKeys(duedate);
	}

	public void enterDueTime(String dueTime) {
		assignCourseDueTimeInput.clear();
		assignCourseDueTimeInput.sendKeys(dueTime);
	}

	public void enterGradeBookFieldSetValues(String points) {
		try {
			if (gradeBookFieldSet.isDisplayed()) {
				setPoints(points);
				// clickSubmitButtonOnAssignForm();
			}
		} catch (NoSuchElementException e) {
		}
	}
	public void clickOnViewInstructorConsoleForBatchDueDateUpdater() {
		waitForSync();
		assert viewinstructorconsole.getText().trim().contains("View instructor console...");
		click(viewinstructorconsole);
		waitForSync();
		assert batchupdater.getText().trim().contains("Batch Due Date Updater");
		click(batchupdater);
		waitForSync();
		assert fromdate.isDisplayed();
		click(fromdate);
		waitForSync();
		click(setFromDate);
		waitForSync();
		assert todate.isDisplayed();
		click(todate);
		waitForSync();
		click(setToDate);
		waitForSync();
		assert newduedate.isDisplayed();
		click(newduedate);
		waitForSync();
		click(setnewdueDate);
		waitForSync();
		click(updatedueDate);
		waitForSync();
		click(clickHome);
	}

	public void clickOnViewInstructorConsoleForGradebookPreferences() {
		waitForSync();
		waitForElementToLoad(viewinstructorconsole, waitForElementInMilliSeconds);
		assert viewinstructorconsole.getText().trim().contains("View instructor console...");
		click(viewinstructorconsole);
		waitForSync(5000);
		waitForElementToLoad(gradebookpreference, waitForElementInMilliSeconds);
		click(gradebookpreference);
		click(passingscore);
		waitForSync();
		assert passingscore.isDisplayed();
		assert useweightedcategories.isDisplayed();
		assert showassignments.isDisplayed();
		assert sequencetitle.isDisplayed();
		//assert droplowest.isDisplayed();
		assert weightpointscolumn.isDisplayed();
		assert percentoftotal.isDisplayed();
		assert removecat.isDisplayed();

	}

	public void addnewcategoryfromhomepage1(String points, String category){
		waitForSync();
		click(clickchapter1);
		waitForSync(3000);
		Actions builder = new Actions(driver);
		builder.moveToElement(chapterintro1).build().perform();
		waitForSync(3000);
		click(assignchapterintro1);
		waitForSync();
		setDateTimeField();
		waitForSync();
		setPoints(points);
		waitForSync();
		setCategory(category);
		waitForSync(3000);
		click(clickdoneassigning);
		waitForSync(3000);
	}
	public void addnewcategoryfromhomepage2(String points, String category){
		waitForSync(3000);
		click(clickchapter2);
		waitForSync(500);
//		Actions builder = new Actions(driver);
//		builder.moveToElement(chapterintro2).build().perform();
//		waitForSync(3000);
		waitForElementToLoad(assignchapterintro2, waitForElementInMilliSeconds);
		click(assignchapterintro2);
		waitForSync();
		setDateTimeField();
		waitForSync();
		setPoints(points);
		waitForSync();
		setCategory(category);
		waitForSync();
		click(clickdoneassigning);
		waitForSync(3000);
	}
	public void addnewcategoryfromhomepage3(String points, String category){
		waitForSync(3000);
		click(clickchapter3);
		waitForSync(5000);
		Actions builder = new Actions(driver);
		builder.moveToElement(chapterintro3).build().perform();
		waitForSync(3000);
		click(assignchapterintro3);
		waitForSync();
		setDateTimeField();
		waitForSync();
		setPoints(points);
		waitForSync();
		setCategory(category+"1");
		waitForSync();
		click(clickdoneassigning);
		waitForSync(4000);
	}

	public void enterDueDate1(String duedate) {
		assignduedate.clear();
		assignduedate.sendKeys(duedate);
	}

	public void enterDueTime1(String dueTime) {
		assignduetime.clear();
		assignduetime.sendKeys(dueTime);
	}

	public void studentView() {
		waitForElementToLoad(studentview, waitForElementInMilliSeconds);
		assert studentview.isDisplayed();
		click(studentview);
		waitForElementToLoad(cancelstudentview, waitForElementInMilliSeconds);
	}




	//================================EditingForPageobjects=================================================
	public boolean isQuestionContainerVisible() {
		waitForElementToLoad(questioncontainer, waitForElementInMilliSeconds);
		return questioncontainer.isDisplayed();
	}

	public boolean viewInstructorConsole() {
		waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		assert viewInstructorConsoleLink.isDisplayed();
		click(viewInstructorConsoleLink);
		waitForElementToLoad(resourceButton, waitForElementInMilliSeconds);
		waitForSync();
		return resourceButton.isDisplayed() && rosterAndGroup.isDisplayed() && settings.isDisplayed()  && gradebookButton.isDisplayed();
	}

	public boolean verifyInstructorIsAtHomePage() {
		waitForSync();
		waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		return addButton.isDisplayed();
	}

	public boolean settings() {
		waitForSync(6000);
		//waitForElementToLoad(settings, waitForElementInMilliSeconds);
		click(settings);
		waitForElementToLoad(selectedOption, waitForElementInMilliSeconds);
		waitForSync();
		return selectedOption.isDisplayed() && driver.findElement(By.xpath("(//div[@class='settingNav-links']/ul/li/a)[1]")).getText().contains("Navigation") && driver.findElement(By.xpath("(//div[@class='settingNav-links']/ul/li/a)[2]")).getText().contains("Launch Pad");
	}

	public boolean resource() {
		waitForSync();
		waitForElementToLoad(resourceButton, waitForElementInMilliSeconds);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resourceButton);
		click(resourceButton);
		waitForSync();
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButton);
//		return searchButton.isDisplayed();
		return true;
	}

	public boolean verifyContentAndAssignmentOption() {
		List<WebElement> contentAndAssignmentOptions = driver.findElements(By.xpath("(//div[@id='browseResults']/ul[1]/li)"));
		WebElement a = contentAndAssignmentOptions.get(0);
		WebElement b = contentAndAssignmentOptions.get(1);
		WebElement c = contentAndAssignmentOptions.get(2);
		WebElement d = contentAndAssignmentOptions.get(3);
		return a.getText().trim().equals("Content by type") && b.getText().trim().equals("Content by chapter") && c.getText().trim().equals("Content I've created") && d.getText().trim().equals("Removed content");
	}

	public void contentByType() {
		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementById('browseResults').childNodes[5].childNodes[1].childNodes[1].click()");
		waitForSync();
		//Verify that User is navigated to Content by type: A list of chapters is displayed.
		assert driver.findElement(By.id("moreResourcesTitleName")).getText().trim().contains("Content by type");

		List<WebElement> typeList = driver.findElements(By.xpath("//div[@id='search-results']/ul[1]/li"));

		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementById('search-results').childNodes[7].childNodes[3].childNodes[1].click()");

		//			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('resource-count')[0].firstChild.data.contains('available items')");
		//			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('lnkMoreResourceItem')[0].firstChild.data.contains('Animation')");

	}

	public void contentByChapter() {
		waitForSync(4000);
		((JavascriptExecutor) driver).executeScript("document.getElementById('browseResults').childNodes[5].childNodes[3].childNodes[1].click()");
		//document.getElementById('browseResults').childNodes[5].childNodes[1].childNodes[1].childNodes[1])
		//Verify that User is navigated to Content by chapter
		waitForSync();
		assert driver.findElement(By.id("moreResourcesTitleName")).getText().trim().contains("Content by chapter");
		List<WebElement> chapterList = driver.findElements(By.xpath("//div[@id='search-results']/ul/li"));

		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementById('search-results').childNodes[1].childNodes[1].childNodes[1].click()");
		waitForSync();
		//assert driver.findElement(By.xpath("//div[@id='moreResourcesTitleName']")).getText().trim().contains("Chapter");
		//assert driver.findElement(By.className("resource-count")).getText().trim().contains("available item");

	}

	public void contentsIHaveCreated() {
		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementById('browseResults').childNodes[5].childNodes[5].childNodes[1].click()");
		waitForSync(10000);

		assert driver.findElement(By.id("moreResourcesTitleName")).getText().trim().contains("Content I've created");
		//assert driver.findElement(By.className("resource-count")).getText().trim().contains("available item");
	}

	public void removedContent() {
		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementById('browseResults').childNodes[5].childNodes[7].childNodes[1].click()");
		waitForSync();
		//((JavascriptExecutor) driver).executeScript("document.getElementById('browseResults').childNodes[3].textContent.contains('Removed Content')");
	}

	public void removeLinkButtonFromGearIconAtHomePage() {
		waitForSync(8000);
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + (driver.findElement(By.xpath("//a[@class='remove link button']"))).getLocation().y + ")");
		click(driver.findElement(By.xpath("//a[@class='remove link button']")));
		waitForSync();
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("remove")));
		click(driver.findElement(By.xpath("(//input[@class='remove'])")));

	}

	public void clickOnBreadcrumbResource() {
		waitForSync();

		((JavascriptExecutor) driver).executeScript("document.getElementById('resource-list').childNodes[1].click()");
		waitForSync(7000);
	}

	public void verifyQuestionsOption() {
		List<WebElement> questions = driver.findElements(By.xpath("(//div[@id='browseResults']/ul[2]/li)"));
		WebElement a = questions.get(0);
		WebElement b = questions.get(1);
		WebElement c = questions.get(2);
		assert a.getText().trim().equals("Questions by chapter") && b.getText().trim().equals("Questions by assessment") && c.getText().trim().equals("Questions I've created or edited");
	}

	public void questionByChapter() {
		waitForSync();
		//click on question
		((JavascriptExecutor) driver).executeScript("document.getElementById('browseResults').childNodes[9].childNodes[1].childNodes[1].click()");
		waitForSync();
		List<WebElement> chapterQuestionList = driver.findElements(By.xpath("(//ul[@class='quiz-item-links'])[1]/li"));
		waitForSync();
		//click on chapter 1
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('click-target')[1].childNodes[1].click()");
		//click on test bank
		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('click-target')[2].childNodes[1].click()");

	}

	public boolean contentIhaveCreated() {
		List<WebElement> contentAndAssignmentOptions = driver.findElements(By.xpath("(//div[@id='browseResults']/ul[1]/li)"));
		return contentAndAssignmentOptions.get(1).getText().trim().contains("Content I've created");
	}

	public void clickResourceCloseButton() {
		waitForSync(7000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + crossButton.getLocation().y + ")");
		waitForElementToLoad(crossButton, waitForElementInMilliSeconds);
		//crossButton);
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('close')[1].click()");
	}

	public void searchBox(String assign) {
		searchButton.sendKeys(assign);
		waitForSync(4000);
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('lnkMoreResourceItem')[6].click()");
		waitForSync();
	}

	public void clickOnContentByTypeInUse() {

		try {
			//waitForSync();
			//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + asd.getLocation().y + ")");
			click(asd);
			waitForSync();
		} catch (Exception e) {
			//block add link
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('lblAdd moreResourcesLabel')[0].style.display=('block')");
			//click add link
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('lblAdd moreResourcesLabel')[0].click()");
			waitForSync(5000);
			//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + asd.getLocation().y + ")");
			click(asd);
			waitForSync();

		}
		waitForSync();
	}

	public void verifyUseInElements() {
		try {
			//used in written on dropdown
			assert driver.findElement(By.id("spanInUse")).isDisplayed();
			//chapter name
			assert driver.findElement(By.id("lblInUseDescription")).isDisplayed();
		} catch (Exception e) {
		}


		List<WebElement> useInList = driver.findElements(By.xpath("(//div[@class='faceplate-move-resource-menu']/ul)[2]/li/a"));

		WebElement removeFromThisUnit = useInList.get(0);
		WebElement moveToCurrentUnit = useInList.get(1);
		WebElement addCopyToCurrentUnit = useInList.get(2);
		assert removeFromThisUnit.getText().trim().contains("Remove from this unit") && moveToCurrentUnit.getText().trim().contains("Move to current unit") && addCopyToCurrentUnit.getText().trim().contains("Add copy to current unit");

	}

	public void removeFromThisUnit() {
		waitForSync();

		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + removeFromThisUnit.getLocation().y + ")");
		click(removeFromThisUnit);
		waitForSync();
		click(driver.findElement(By.xpath("//input[@class='remove']")));
		waitForSync();

	}

	public void addCopyToCurrentUnit(String copy) {
		waitForSync();
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + addCopyToCurrentUnit.getLocation().y + ")");
		click(addCopyToCurrentUnit);
		waitForSync();
		pageTitle.clear();
		pageTitle.sendKeys(copy);
		waitForSync();
		click(saveBtnCopyToCurrentUnit);
		waitForSync();
	}

	public void questionsAtResourceOverlay(String assign) {
		waitForSync();
		searchButton.sendKeys(assign);
		waitForSync(10000);
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('modeQuestions')[0].click();");
		waitForSync(10000);
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('show-filter-available-question')[0].click();");
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('select2-choices')[0].childNodes[1].click();");

	}
	public void clickOnQuiz() {
		waitForSync();
		click(clickonquiz);
		waitForSync();
		//((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('fne-link linkButton start-quiz faceplatefne')[0])");		
		//	waitForSync(10000);
		clickStartQuiz();
		//	studentAnswersQuiz();
		studentSubmitsQuiz();
	}
	public void clickStartQuiz() {
		waitForElementToLoad(startQuizButton, waitForElementInMilliSeconds);
		assert startQuizButton.isDisplayed();
		click(startQuizButton);
		waitForSync(20000);
	}
	public boolean studentSubmitsQuiz() {
		waitForSync();
		click(studentSubmitQuizButton);
		waitForSync();
		click(confirmsubmit);
		waitForSync();
		switchToMainWindow();
		return doneEditingButton.isDisplayed();
	}
	public void switchToMainWindow() {
		driver.switchTo().window(currentWindowHandle);
	}
	public void clickDoneAssigningButton(){
		//waitForElementToLoad(clickdoneassigning, waitForElementInMilliSeconds);
		click(clickdoneassigning);
		waitForSync(4000);
	}

	public void clickOnFirstUserCreatedAssignment(){
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('gearbox-icon pxicon pxicon-gear')[0].click()");

	}
	
	public void clickOnFirstUserCreatedAssignmentButton(){
		  ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('faceplate-item-assign')[2].click()");

		 }
	
	public void fromTOCClickOnAnyChapterRandomly(){
		click(randomlyClickChapter);
	}
}
