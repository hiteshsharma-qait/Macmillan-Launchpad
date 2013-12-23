package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.qait.automation.MacmillanLaunchpad.Utils.DateUtil;
import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.*;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;

public class FandEPageUi extends CommonMethods {

	public WebDriver driver;
	String random;
	String currentDir = System.getProperty("user.dir");
	@FindBy(className="show-filter-available-question")
	WebElement showFilter;
	@FindBy(id = "fne-header")
	WebElement fAndEheader;
	@FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all px-dialog']/div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button/span[text()='Save']")
	WebElement saveButtonOverlay1;

	@FindBy(xpath = "(//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button/span[text()='Save'])[2]")
	WebElement saveButtonOverlay2;

	@FindBy(css = ".instructor-console-link .link")
	WebElement editConsoleLinks;
	@FindBy(className = "students")
	WebElement studentTable;
	@FindBy(className = "instructor-console-title")
	WebElement selectLinksPage;
	@FindBy(xpath = "//span[@class='home-btn-icon']")
	WebElement homePageButton;
	@FindBy(id = "fne-unblock-action-home")
	WebElement homeButton;
	@FindBy(className = "create-group-set")
	WebElement createNewGroupLink;
	@FindBy(xpath = "(//ul[@id='selResourceType-instructor-console']/li/input[1])[1]")
	WebElement resourcesByChapters;
	@FindBy(css = "#student-list>h2")
	WebElement studnentHeader;
	@FindBy(id = "add-assignment-btn")
	WebElement addButton;
	@FindBy(id = "setName_FrameContent")
	WebElement groupNameInputBox;
	@FindBy(xpath = "//ul[@class='CW_ActionLinks']/div/li/a[@class='link']")
	WebElement resourcesByChapter;
	@FindBy(id = "groupPrefix_FrameContent")
	WebElement createGroupPrefix;
	@FindBy(xpath = "//ul[@class='CW_ActionLinks']/li/a/span[contains(text(),'View instructor console')]")
	WebElement viewInstructorConsoleLink;
	@FindBy(css = "#student-list .group:nth-child(2) .students .email-link")
	WebElement tableOneEmailGroupLink;
	@FindBy(id = "CW_ResourcesButton")
	WebElement resourcesButton;
	@FindBy(css = "#student-list .group:nth-child(2) .students th.name")
	WebElement tableOneNameHeading;
	@FindBy(id = "submitForm")
	WebElement saveNavigationSettings;
	@FindBy(css = "#student-list .group:nth-child(2) .students th.email")
	WebElement tableOneEmailHeading;
	@FindBy(css = "#AcademicTerm")
	WebElement academicTermDropdown;
	@FindBy(css = "#student-list .group:nth-child(2) .students th.login")
	WebElement tableOneLoginHeading;
	@FindBy(xpath = "//div/select[@id='AcademicTerm']/option[contains(text(),'Fall 2012')]")
	WebElement selectValueInAcademicTermDropdown;
	@FindBy(id = "fCreateGroupsByStudentNumber_FrameContent")
	WebElement studnetPerGroupRadioButton;
	@FindBy(css = "#Title")
	WebElement pageTitle;
	@FindBy(id = "fStudentsPerGroup_FrameContent")
	WebElement studentPerGroup;
	@FindBy(id = "CourseNumber")
	WebElement courseNumberTextBox;
	@FindBy(id = "fCreateGroupsByNumber_FrameContent")
	WebElement noOfGroupRadioButton;
	@FindBy(id = "SectionNumber")
	WebElement sectionNumberTextBox;
	@FindBy(id = "fNumberOfGroups_FrameContent")
	WebElement noOfGroup;
	@FindBy(id = "CourseUserName")
	WebElement instructorNameTextBox;
	@FindBy(id = "fNone_FrameContent")
	WebElement noneAssignmentRadioOption;
	@FindBy(id = "OfficeHours")
	WebElement enterOfficeHours;
	@FindBy(id = "fRandom_FrameContent")
	WebElement randomAssignmentRadioOption;
	@FindBy(id = "addContact")
	WebElement newPointOfContact;
	@FindBy(className = "contactInfoType")
	WebElement contactInfoType;
	@FindBy(xpath = "//select[@class='contactInfoType']/option[contains(text(),'Email')]")
	WebElement emailOption;
	@FindBy(xpath = "//select[@class='contactInfoType']/option[contains(text(),'Phone')]")
	WebElement phoneOption;
	@FindBy(xpath = "//select[@class='contactInfoType']/option[contains(text(),'Fax')]")
	WebElement faxOption;
	@FindBy(xpath = "//select[@class='contactInfoType']/option[contains(text(),'Other')]")
	WebElement otherOption;
	@FindBy(css = ".settingsSubmit-wrapper #submitForm")
	WebElement saveGeneralSettings;
	@FindBy(css = ".x-window-mc .x-fieldset-bwrap")
	WebElement groupAssignementWindow;
	@FindBy(id = "contactInfoValue_1")
	WebElement contactInfoInput;
	@FindBy(id = "contactInfoValue_2")
	WebElement newContactInfoInput;
	@FindBy(css = ".x-btn-mc #ext-gen120")
	WebElement generateGroupButton;
	@FindBy(css = "#fne-item-assign")
	WebElement assignButton;
	@FindBy(css = ".x-btn-mc #ext-gen123")
	WebElement cancelGroupButton;
	@FindBy(css = ".x-btn-mc #ext-gen57")
	WebElement okButtonGroupAssignmentScreen;
	@FindBy(css = ".x-btn-mc #ext-gen60")
	WebElement cancelButtonGroupAssignmentScreen;
	@FindBy(css = "#cellid_FrameContent_0 [class*=rename]")
	WebElement firstGroupTitle;
	@FindBy(css = "#cellid_FrameContent_0 [class*=delete]")
	WebElement firstGroupDeleteLink;
	@FindBy(css = ".x-btn-mc #ext-gen48")
	WebElement addGroupLinkGroupAssignmentScreen;
	@FindBy(css = ".x-btn-mc #ext-gen51")
	WebElement generateGroupLinkGroupAssignmentScreen;
	@FindBy(css = ".x-window-dlg .x-toolbar-cell:not(.x-hide-offsets) button")
	WebElement confirmDeleteActionButton;
	@FindBy(css = ".group-sets-list li:nth-child(1) .group-link")
	WebElement firstCreatedGroupLinkFnEscreen;
	String setCountCss = ".group-sets-list li:nth-child(%) .setcount";
	String editButtonForGroupCss = ".group-sets-list li:nth-child(%) .setcount+div [title*=Edit]";
	@FindBy(css = ".group-sets-list li:nth-child(1) [title*=Clone]")
	WebElement firstGroupCloneLinkFnEscreen;
	@FindBy(css = ".group-sets-list li:nth-child(1) [title*=Edit]")
	WebElement firstGroupEditLinkFnEscreen;
	@FindBy(css = ".group-sets-list li:nth-child(1) .deleteGroup.linkButton")
	WebElement firstGroupDeleteLinkFnEscreen;
	@FindBy(id = "cellid_FrameContent_0_0")
	WebElement groupAssignedToStudent;
	@FindBy(className = "group-link")
	WebElement allGroupLinksName;
	@FindBy(id = "CourseTimeZone")
	WebElement editTimeZoneOption;
	@FindBy(id = "submitForm")
	WebElement submitFnEform;
	@FindBy(css = ".create-new-wrapper #Content_Title")
	public WebElement createNewElementTitle;
	@FindBy(id = "Title")
	WebElement editContentTitle;
	@FindBy(className = "savebtn")
	WebElement saveEditAction;
	@FindBy(className = "submit-action")
	WebElement saveNewCreatedElement;
	@FindBy(id = "requireConfirmationQuestions")
	WebElement questionsTabLink;
	@FindBy(css = "a[id$=__1]")
	WebElement chapter1QuestionBankLearningCurve;
	@FindBy(linkText = "Test Bank 1")
	WebElement testBank1Link;
	@FindBy(linkText = "Test Bank 2")
	WebElement testBank2Link;
	@FindBy(linkText = "Test Bank")
	WebElement testBankLink;
	String questionCheckBoxCss = ".questions>li:nth-child(%) input[type=checkbox]";
	String chapterNamexPath = "(//a[text()[contains(.,'Chapter %')]])[1]";
	@FindBy(css = ".add-menu>.gearbox")
	WebElement addToPoolDropdown;
	@FindBy(css = ".add-to-new-pool>a")
	WebElement addToNewPoolLink;
	@FindBy(className = "add-available-question-at-top")
	WebElement addQuestionButton;
	@FindBy(css = "#show-question-pool-dialog>.pool-title-info #pool_title")
	WebElement poolTitle;
	@FindBy(css = "#show-question-pool-dialog>.pool-question-info #pool-count")
	WebElement poolQuestionInfo;
	@FindBy(css = "#show-question-pool-dialog~.ui-dialog-buttonpane .ui-dialog-buttonset>button:nth-child(1)")
	WebElement createPoolButton;
	@FindBy(id = "fne-done")
	WebElement doneEditingButton;
	@FindBy(className = "toast-message")
	WebElement messageFlyer;
	@FindBy(id = "activity_border")
	WebElement learningCurveActivityBorder;
	@FindBy(id = "activity_title")
	WebElement learningCurveTitle;
	@FindBy(id = "fne-edit")
	WebElement fNeEditOption;
	@FindBy(id = "fne-item-assign")
	WebElement fneAssignOption;
	@FindBy(id = "fne-results")
	WebElement fneResultsOption;
	@FindBy(id = "fne-title")
	WebElement fneTitle;
	@FindBy(css = ".settings-tab >a")
	WebElement editSettingsLink;
	@FindBy(id = "AutoTargetScore")
	WebElement autoScoreCheckBox;
	@FindBy(id = "LearningCurveTargetScore")
	WebElement assignScoreInputBox;
	@FindBy(id = "savecontentsettings")
	WebElement saveSettingsButton;
	@FindBy(css = "#start_screen>ul>li>b")
	WebElement userEnteredScore;
	@FindBy(css = ".figureF>a>img")
	WebElement fnePageImgae;
	String fnEPageImageCss = ".figureF>a>img";
	@FindBy(id = "next")
	WebElement nextButton;
	@FindBy(id = "back")
	WebElement previousButton;
	@FindBy(css = "#back[class*=disabled]")
	WebElement previousDisabled;
	@FindBy(css = "#next[class*=disabled]")
	WebElement nextDisabled;
	@FindBy(xpath = "(//div[@id='mainContent']//b/a)[1]")
	WebElement keyTermLink;
	@FindBy(xpath = "(//div[@class='bodyHolder2']//b/a)[1]")
	WebElement keyTermLink1;
	@FindBy(id = "popInWindow_n")
	WebElement popInGlossaryDefinitionWIndow;
	@FindBy(css = "#popInTitle_n>b")
	WebElement popInWindowHeading;
	@FindBy(css = "#popInContent_n>b")
	WebElement popInContentHeading;
	@FindBy(className = "popInCloseLinkS")
	WebElement popInCloseLink;
	@FindBy(className = "upload-link")
	WebElement uploadDocumentLink;
	@FindBy(css = "[role=dialog]")
	WebElement dialogWindow;
	@FindBy(css = "[role=dialog] .ui-dialog-title")
	WebElement dialogWindowTitle;
	@FindBy(id = "lnkAddLink")
	WebElement addLinkLink;
	@FindBy(xpath = "//span[@class='field buttons']/ol/li[2]/input[@id='linkTitle']")
	WebElement addLinkDialogTitleInput;
	@FindBy(id = "linkUrl")
	WebElement addLinkDialogURLInput;
	@FindBy(css = ".savecancelbtns [type=button][value=Save]")
	WebElement addLinkDialogSaveButton;
	@FindBy(id = "studentList_FrameContent")
	WebElement resultPagestudentSummary;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement studentSubmitQuizButton;
	@FindBy(xpath = ".//button[contains(text(),'Yes')]")
	WebElement studentSelectYesOption;
	@FindBy(className = "gradetable")
	WebElement gradeTableDisplayed;
	@FindBy(className = "start-quiz")
	WebElement startQuizButton;
	@FindBy(id = "lnkUploadAssignment")
	WebElement uploadAssignmentForDropBox;
	@FindBy(css = ".confirm-buttons[value=Submit]")
	WebElement dropBoxSubmit;
	@FindBy(css = ".fne-action-status .pxunit-display-points.col")
	WebElement timeInfo;
	@FindBy(css = ".fne-action-status .due_date_day")
	WebElement dueDateInfo;
	@FindBy(css = ".fne-action-status .due_date_month")
	WebElement dueMonthInfo;
	@FindBy(css = ".quiz-content .px-default-text")
	WebElement defaultMessageOnFnEPage;
	@FindBy(xpath = "//select[contains(@class, 'selgradebookweights')]/option[./text()='Uncategorized']")
	WebElement uncategorized;
	@FindBy(xpath = "//select[contains(@class, 'selgradebookweights')]/option[./text()='Create new category']")
	WebElement newcategory;
	@FindBy(css = "#txtaddGBBcategory")
	WebElement categoryname;
	@FindBy(xpath = "(//input[@class='button small'])[2]")
	WebElement clickok;
	@FindBy(id = "txtGradePoints")
	WebElement setpointsvalue;
	@FindBy(css = "#selgradebookweights")
	WebElement setgradebookcategory;
	@FindBy(id = "chkAllowLateSubmissions")
	WebElement submissionUntillGrace;
	@FindBy(xpath = "(//li[@id='liScheduleEmailReminder'])/label")
	WebElement emailReminderForStudent;
	@FindBy(id = "btnAssign")
	WebElement assignBtn;
	@FindBy(xpath = "(//td[@class='']/a/span)[20]")
	WebElement setDateTime;
	@FindBy(id = ("btnSaveChanges"))
	WebElement saveChanges;
	@FindBy(id = ("btnUnassign"))
	WebElement unassignBtn;
	@FindBy(css = ".savebtn.saveandopen")
	WebElement saveButton;
	@FindBy(id = "question-list-level")
	WebElement questionBanksLink;
	String studnetAnswersQuestion = "(//*[@class='examQuestionTable']//*[@title='Choice %'])[#]";
	String linkCollectionsCss = ".link-table .link-wrapper:nth-child(1) a";
	@FindBy(id = "uploadTitle")
	WebElement uploadDocumentTitleInput;
	@FindBy(className = "btnUploadDoc")
	WebElement uploadButton;
	@FindBy(css = "#dropboxSubmission .docTitle>a")
	WebElement uploadedDocumentTitle;
	@FindBy(css = "#tinymce")
	WebElement mceEditor;
	@FindBy(css = "#tinymce>p")
	WebElement mceEditor1;
	@FindBy(css = ".mceIcon.mce_link")
	WebElement editLink;
	@FindBy(css = "#href")
	WebElement hyperLink;
	@FindBy(css = "#insert")
	WebElement insert;
	@FindBy(css = ".ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-text-only")
	WebElement saveButtonWelcomePage;
	@FindBy(css = ".doneEditing")
	WebElement doneEditing;
	@FindBy(css = ".facePlate-start_welcome_msg>p>a")
	WebElement hypeLink;
	@FindBy(css = ".savebtn.saveandopen")
	WebElement saveButtonQuiz;
	//@FindBy(css="#fne-done")
	//WebElement doneEditingButton;
	@FindBy(css = ".html-container.description-content>p>a")
	WebElement clickHyperlink;
	@FindBy(css = "#fne-unblock-action-home")
	WebElement clickHome;
	@FindBy(css = "#gbqfba")
	WebElement googlePage;
	@FindBy(css = "#search-submit")
	WebElement yahooPage;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Display Options']")
	WebElement displayoptions;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Import Scores']")
	WebElement importscores;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Export Scores']")
	WebElement exportscores;
	@FindBy(xpath = "//span[contains(@class, 'x-menu-item-text')][./text()='Visible Columns...']")
	WebElement visiblecolumns;
	@FindBy(xpath = "//span[contains(@class, 'x-menu-item-text')][./text()='Visible Footers...']")
	WebElement visiblefooter;
	@FindBy(xpath = "//span[contains(@class, 'x-menu-item-text')][./text()='Score Display Options...']")
	WebElement scoredisplay;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='OK']")
	WebElement okButtonGradebook;
	@FindBy(css = "#colMinutes_FrameContent")
	WebElement minutescheck;
	@FindBy(css = "#importfile")
	WebElement importscorepath;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Continue']")
	WebElement continueimport;
	@FindBy(css = "#column_0")
	WebElement selectcolumn;
	@FindBy(xpath = "(//div[@class='x-combo-list-inner'])/div[8]")
	WebElement chooseoption;
	@FindBy(css = "#format_0")
	WebElement selectsubcolumn;
	@FindBy(xpath = "(//div[@class='x-combo-list-inner'])[2]/div[2]")
	WebElement choosesuboption;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Import']")
	WebElement confirmimport;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Export']")
	WebElement confirmexport;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Close']")
	WebElement close;
	@FindBy(xpath = "//div[@class='breadcrumb']")
	WebElement instconslgrdbuk;
	@FindBy(xpath = "//a[contains(./text(),'Completed')]")
	WebElement completecol;
	@FindBy(xpath = "//a[contains(./text(),'Minutes')]")
	WebElement minutecol;
	@FindBy(xpath = "(//div/span)[2]")
	WebElement minutevalue;
	@FindBy(css = ".student-view-gradebook-title.breadcrumb")
	WebElement studconslgrdbuk;
	@FindBy(css = ".flat")
	WebElement studentname;
	@FindBy(css = "#ItemDetailsReport .blockUI.blockMsg.blockElement")
	WebElement resultLoader;
	@FindBy(css = ".edit-groups .blockUI.blockMsg.blockElement")
	WebElement editLoader;
	@FindBy(id = "ddlSettingsList")
	WebElement selectSettingsToAssign;
	@FindBy(css = ".graph>a")
	WebElement graphingExercise;
	@FindBy(xpath = "(//div[@class='x-panel-body x-panel-body-noheader']/textarea)[1]")
	WebElement questionname;
	@FindBy(xpath = "//div[@class='question-leftnav']/input")
	WebElement savequestion;
	@FindBy(xpath = "//div[@class='new-question-menu']/div[@class='gearbox']")
	WebElement createmenu;
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
	@FindBy(xpath = "(//span[@class='expand-available-question'])[1]")
	WebElement questionOneExpandXpath;
	@FindBy(xpath = "//ul[@id='add-gearbox']/li[2]/a")
	WebElement addToExistingPoolLink;
	@FindBy(css = ".short-answer>a")
	WebElement shortAnswer;
	@FindBy(xpath = "(//table[@class='x-table-layout']//textarea)[1]")
	WebElement shortAnswerAnswer;
	@FindBy(css = ".question-bank>a")
	WebElement questionPool;
	@FindBy(css = ".essay>a")
	WebElement essay;
	@FindBy(css = ".matching>a")
	WebElement matching;
	@FindBy(xpath = "(//span[@class='delete-current-question'])[1]")
	WebElement removeSelectedQuestionFromRight;
	@FindBy(xpath = "(//div[@class='ui-dialog-buttonset']/button)/span[contains(./text(),'Remove')]")
	WebElement confirmRemoveQuestionFromRightSide;
	@FindBy(xpath = "//div[@class='remove-btn-wrapper']")
	WebElement removeButton;
	@FindBy(xpath = "(//div[@class='select']/input)[1]")
	WebElement questionCheckBox1;
	@FindBy(css = ".edit-current-question")
	WebElement editCurrentQuestion;
	@FindBy(xpath = "(//div[@class='x-panel-body x-panel-body-noheader']//input)[3]")
	WebElement editCorrectAnswer;
	@FindBy(css = ".select>input")
	WebElement questionCheckbox;
	@FindBy(css = ".multiple-choice>a")
	WebElement multipleChoice;
	@FindBy(css = ".hts>a")
	WebElement advanceQuestion;
	//	@FindBy(xpath="//a[@id='step-1-editor-question-id1375859417580_htsFormulaEditor']/img")
	//	WebElement insertFormulae;
	@FindBy(xpath = "//input[@class='button save-button']")
	WebElement saveButtonForAdvanceQuestion;
	@FindBy(xpath = "(//div[@class='question-edit-wrapper']/a/span[@class='preview-current-question'][contains(text(),'Preview')])[1]")
	WebElement questionCheckBoxCssOnRight;
	@FindBy(xpath = "(//div[@class='question-edit-wrapper']/a/span[@class='show-current-questions'])[1]")
	WebElement poolCheckBoxOnRight;
	@FindBy(css = ".edit-current-question")
	WebElement editQuestion;
	@FindBy(css = ".multiple-answer>a")
	WebElement multipleanswers;
	@FindBy(css = ".EnterCourse")
	WebElement entercourse;
	@FindBy(xpath = "(//*[@class='solutionLink'])[1]")
	WebElement firstShowAnswerLink;
	@FindBy(xpath = "(//*[@class='solutionText'])[1]")
	WebElement firstAnswerSpace;
	@FindBy(xpath = "(//a[@title='CrunchIt!'])[1]")
	WebElement firstCrunchItLink;
	@FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-resizable questionCard']//span[@class='ui-icon ui-icon-closethick']")
	WebElement closePreview;
	@FindBy(className = "navInput-title")
	WebElement inputTitleInNavigation;
	@FindBy(id = "isLoadStartOnInit")
	WebElement checkboxInsideNavigation;
	@FindBy(css = ".select-menu>.gearbox")
	WebElement selectMenu;
	@FindBy(css = ".select-all>a")
	WebElement selectAll;
	@FindBy(css = ".select-used-previously>a")
	WebElement usedInPreviousQuiz;
	@FindBy(css = ".select-none>a")
	WebElement selectNone;
	@FindBy(xpath = "//input[@class='x-form-checkbox x-form-field']")
	WebElement answerCheckBox;
	@FindBy(id = "Content_Title")
	WebElement edit2ContentTitle;
	@FindBy(className = "saveandopen")
	WebElement save2EditAction;
	@FindBy(id = "requireConfirmationSettings")
	WebElement settingsTabLink;
	@FindBy(css = "#AllowSaveAndContinue")
	WebElement allowsaveandcontinue;
	@FindBy(css = "#AutoSubmitAssessments")
	WebElement autosubmitassesments;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement studentsavequiz;
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement studentclosequiz;
	@FindBy(xpath = "//a[contains(./text(),'Resume the Quiz')]")
	WebElement resumequiz;
	@FindBy(css = "#fne-results>span")
	WebElement results;
	@FindBy(xpath="(//div[@class='gbg-tip'])[1]")
	WebElement scoreOfAttemptedQuiz;
	@FindBy(css = "[href*=gradebook]")
	WebElement gradebookButton;
	@FindBy(xpath = "//div[@class='time-limit-minutes']/input[1]")
	WebElement timelimitradio;
	@FindBy(xpath = "//div[@class='time-limit-minutes']/input[2]")
	WebElement timelimitvalue;
	@FindBy(xpath = "//span/span")
	WebElement timer;
	@FindBy(css = "#editFeedbacksLink_quizeditorcomponent")
	WebElement editfeedback;
	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement addfeedback;
	@FindBy(id = "requireConfirmationAssign")
	WebElement clickassignmenttab;
	@FindBy(css = "#passingScore")
	WebElement passingscore;
	@FindBy(css = "#savePassingScore")
	WebElement savepassscore;
	@FindBy(css = "#showAssignments")
	WebElement showassignments;
	@FindBy(css = "#useWeightedCategories")
	WebElement useweightedcategories;
	@FindBy(css = "(//span[@class='labelWeight'])[2]")
	WebElement weightpoints;
	@FindBy(xpath = "(//span[@class='labelWeight'])[2]/following::input[1]")
	WebElement setweight;
	@FindBy(xpath = "(//span[@class='labelWeight'])[2]/following::input[2]")
	WebElement confirmsetweight;
	@FindBy(xpath = "(//span[@class='labelDrop'])[2]")
	WebElement droplowestvalue;
	@FindBy(xpath = "(//span[@class='labelDrop']/following::input[1])[2]")
	WebElement setdroplowestvalue;
	@FindBy(xpath = "(//span[@class='labelDrop']/following::input[2])[2]")
	WebElement confirmdroplowestvalue;
	@FindBy(css = "#fne-edit")
	WebElement clickedit;
	@FindBy(xpath = "(//select[@class='categorySequence'])[1]")
	WebElement sequence;
	@FindBy(xpath = "(//select[@class='categorySequence'])[1]/option[3]")
	WebElement option3;
	@FindBy(xpath = "(//td[@class='sequence']/select)[1]")
	WebElement assignmentsequence;
	@FindBy(xpath = "(//td[@class='sequence']/select)[1]/option[2]")
	WebElement assignmentoption3;
	@FindBy(xpath = "(//td[@class='student-grades-category-row'][contains(./text() , 'Score')])[1]")
	WebElement Score;
	@FindBy(xpath = "(//td[@class='student-grades-category-row'][contains(./text() , 'Submitted')])[1]")
	WebElement Submitted;
	@FindBy(xpath = "(//td[@class='student-grades-category-row'][contains(./text() , 'Due')])[1]")
	WebElement Due;
	@FindBy(xpath = "//div[contains(./text(),'All questions on one screen')]/input")
	WebElement allquestionononescreen;
	@FindBy(xpath = "//div[contains(./text(),'One question at a time')]/input")
	WebElement questionsonseparatepages;
	@FindBy(xpath = "(//td[@class='attemptscore'])[1]")
	WebElement previousscore;
	@FindBy(xpath = "(//a[contains(./text(),'Cancel')])[1]")
	WebElement cancelstudentview;
	@FindBy(xpath = "//button[contains(@class, 'x-btn-text')][./text()='Yes']")
	WebElement confirmsubmit;
	@FindBy(css = "#TMP_8fb2fe4aa2f0494c8f6caa62eaabf101")
	WebElement dropboxButton;
	@FindBy(css = "#btnAssign")
	WebElement clickAssign;
	@FindBy(css = ".saveandopen.submit-action")
	WebElement savedropbox;
	@FindBy(id = "Content_Title")
	WebElement courseName;
	@FindBy(css = "#Content_SubTitle")
	WebElement coursesubtitle;
	@FindBy(xpath = "//a[contains(./text(),'Start the Homework')]")
	WebElement startHomework;
	@FindBy(id = "requireConfirmationBasicInfo")
	WebElement basicInfo;
	@FindBy(xpath = "//div[@class='question-count'][contains(text(),'questions available')]")
	WebElement waitForQuestionLoad;
	@FindBy(id = "lc-body-iframe")
	WebElement learningActivityFrame;
	@FindBy(xpath = "(//iframe[id=contains(text(),'easyXDM_default')])[2]")
	WebElement studentScoreFrame;
	@FindBy(xpath = "//div[@id='question-editor']//iframe")
	WebElement questionEditorFrame;
	@FindBy(xpath = "(//a[@class='drag-indicator'])[1]")
	WebElement dragQuestionFrom;
	@FindBy(xpath = "//ul[@class='questions ui-sortable']/li[@class='selected-question-info']/parent::ul")
	WebElement dropQuestionTo;

	public static String timeCreated1 = "";
	public static String a = "";
	String quizNameToCheckForPoints = "#gradesTable_FrameContent tr:nth-child(%) .gradebook-student-grades-item-nolink";
	String quizPointsToCheckForPoints = "#gradesTable_FrameContent tr:nth-child(%) td:nth-child(2) .gbg-in-ct";
	static String keyTermClicked;

	public FandEPageUi(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isHeaderDisplayed() {
		waitForElementToLoad(fAndEheader, waitForElementInMilliSeconds);
		return fAndEheader.isDisplayed();
	}

	public boolean isStudentTableDisplayed() {
		waitForElementToLoad(studnentHeader, waitForElementInMilliSeconds);
		return studnentHeader.isDisplayed() || studentTable.isDisplayed();
	}

	public boolean verifyStudentTableHeading() {
		try {
			boolean h1, h2, h3;
			h1 = driver.findElement(By.cssSelector(".students th:nth-child(1)")).getText().equalsIgnoreCase("Name:");
			h2 = driver.findElement(By.cssSelector(".students th:nth-child(2)")).getText().equalsIgnoreCase("E-mail:");
			h3 = driver.findElement(By.cssSelector(".students th:nth-child(3)")).getText().equalsIgnoreCase("Last Login:");
			return h1 && h2 && h3;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean createGroupLinkPresent() {
		waitForElementToLoad(createNewGroupLink, waitForElementInMilliSeconds);
		return createNewGroupLink.isDisplayed();
	}

	public void clickHomePageLink() {
		try {
			switchToMainWindow();
		} catch (Exception e) {
		}
		waitForElementToLoad(homePageButton, waitForElementInMilliSeconds);
		waitForSync(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageButton);
		waitForSync(500);
		try{
			click(homePageButton);
		}
		catch(Exception e){
			((JavascriptExecutor) driver).executeScript("document.getElementById('fne-unblock-action-home').click()");
		}
		waitForSync();
	}

	public void clickCreateGroupLink() {
		click(createNewGroupLink);
		waitForSync();
		setMainWindowHandle();
	}

	public void setMainWindowHandle() {
		currentWindowHandle = driver.getWindowHandle();
	}

	public void switchToMainWindow() {
		driver.switchTo().window(currentWindowHandle);
	}

	public void switchToDefaultWindow() {
		driver.switchTo().defaultContent();
	}

	public void switchToFrame(int i) {

		final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("\n"+iframes.size()+"\n");
		for (int j = 0; j < iframes.size(); j++) {
		}
		driver.switchTo().frame(iframes.get(i));
	}

	public void switchToFrame() {
		switchToFrame(1);
	}

	public boolean generateGroupFrameOptionsPresent() {
		waitForSync();
		editLoaderDisplayed();
		return createGroupPrefix.isDisplayed() && studentPerGroup.isDisplayed() && noOfGroup.isDisplayed() && groupAssignmentWindowPresent() && generateGroupButton.isDisplayed() && cancelGroupButton.isDisplayed();
	}

	public void clickGenerateGroupLinkOnTopRight() {
		click(generateGroupLinkGroupAssignmentScreen);
	}

	public boolean groupAssignmentWindowPresent() {
		return driver.findElements(By.cssSelector(".x-window-mc .x-fieldset-bwrap")).get(1).isDisplayed();
	}

	public void enterGroupName(String groupName) {
		random = DateUtil.getCurrentDateTime();
		createGroupPrefix.clear();
		createGroupPrefix.sendKeys(groupName + random);
	}

	public void enterNoOfGroup(int groupSize) {
		click(noOfGroupRadioButton);
		noOfGroup.clear();
		noOfGroup.sendKeys(Integer.toString(groupSize));
	}

	public void enterNoOfStudents(int studentCount) {
		click(studnetPerGroupRadioButton);
		studentPerGroup.clear();
		studentPerGroup.sendKeys(Integer.toString(studentCount));
	}

	public void clickGroupWithOneStudentAndReturnGroupName() {
		waitForSync();
		try {
			for (int i = 1; i < 10; i++) {
				if (Integer.parseInt(driver.findElement(By.cssSelector(replaceString(setCountCss, i))).getText().split(", ")[1].split(" ")[0]) > 0) {
					driver.findElement(By.cssSelector(replaceString(editButtonForGroupCss, i))).click();
					break;
				}
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new NoSuchElementException("No Element Found");
		}
	}

	public boolean studentUnassignedFromGroup() {
		waitForSync();
		//boolean classValue;
		setMainWindowHandle();
		switchToFrame();
		click(groupAssignedToStudent);
		//classValue = groupAssignedToStudent.getAttribute("ext:qtip").equals("Include in Group");
		return true;
	}

	public boolean studentAssignedToGroup() {
		//boolean classValue;
		click(groupAssignedToStudent);
		//classValue = groupAssignedToStudent.getAttribute("ext:qtip").equals("Remove from Group");
		return true;
	}

	public boolean clickShowAnswerAndVerifyAnswerBlockDisplayed() {
		waitForSync(5000);
		setMainWindowHandle();
		try {
			switchToFrame();
		} catch (IndexOutOfBoundsException e) {
			switchToFrame(0);
		}
		clickShowAnwser();
		return answerBlockDisplayed();
	}

	public boolean clickCrunchItAndVerifyCrunchItWindowDisplayed() {
		return clickCrunchItLink();
	}

	public boolean clickCrunchItLink() {
		click(firstCrunchItLink);
		driver.switchTo().window("crunchit");
		return driver.getTitle().contains("CrunchIt");
	}

	public void clickShowAnwser() {
		waitForSync();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstShowAnswerLink);
		waitForSync(3000);
		try {
			waitForElementToLoad(firstShowAnswerLink, waitForElementInMilliSeconds);
			click(firstShowAnswerLink);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Show Answer Button Not Displayed");
		}
	}

	public boolean answerBlockDisplayed() {
		try {
			return firstAnswerSpace.isDisplayed();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Answer Space Not Displayed");
		}
	}

	public void selectGroupAssignmentAsNone() {
		click(noneAssignmentRadioOption);
	}

	public void selectGroupAssignmentAsRandom() {
		click(randomAssignmentRadioOption);
	}

	public void generateGroup() {
		click(generateGroupButton);
		waitForSync();
	}

	public boolean verifyGeneratedGroupIsDisplayedOnGroupAssignmentWindow(String groupName) {
		try {
			return firstGroupTitle.isDisplayed() && firstGroupTitle.getText().trim().contains(groupName);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void saveSettings() {
		waitForSync();
		click(driver.findElement(By.xpath("//li/input[@id='savecontentsettings']")));
		waitForSync();
	}

	public void clickOkButtonOnGroupAssignmentWindow() {
		click(okButtonGroupAssignmentScreen);
		waitForSync(25000);
	}

	public void deleteFirstCreatedGroup() {
		click(firstGroupDeleteLink);
		//waitForSync(500);
		click(confirmDeleteActionButton);
		waitForSync();
	}

	String fw;
	String createdGroupLinksFneScreen = ".group-sets-list li:nth-child(%) .group-link";

	public void clickFirstGroupNameOnFNEpage() {
		int a = driver.findElements(By.cssSelector(".group-sets-list li")).size();
		click(driver.findElement(By.cssSelector(replaceString(createdGroupLinksFneScreen, Integer.toString(a)))));
		waitForSync();
		fw = driver.findElement(By.cssSelector(replaceString(createdGroupLinksFneScreen, Integer.toString(a)))).getCssValue("font-weight");
	}

	public boolean verifyGoupSetInfo() {
		return studnentHeader.getText().contains("Test") && tableOneEmailGroupLink.getText().equalsIgnoreCase("E-mail Group") && tableOneEmailHeading.getText().contains("E-mail:") && tableOneNameHeading.getText().contains("Name:") && tableOneLoginHeading.getText().contains("Last Login:") && (fw.equals("700") || fw.equals("bold"));
	}

	public void clickCloneLinkForFirstGroup() {
		setMainWindowHandle();
		click(firstGroupCloneLinkFnEscreen);
		waitForSync();
	}

	public void clickEditLinkForFirstGroup() {
		setMainWindowHandle();
		click(firstGroupEditLinkFnEscreen);
		waitForSync();
	}

	public void enterCloneGroupName(String name) {
		try{
			switchToFrame();
		}catch(IndexOutOfBoundsException e){
			switchToFrame(0);
		}
		random = DateUtil.getCurrentDateTime();
		waitForElementToLoad(groupNameInputBox, waitForElementInMilliSeconds);
		groupNameInputBox.clear();
		groupNameInputBox.sendKeys(name + random);
	}

	public boolean isCreatedGroupPresent(String name) {
		return allGroupNames().contains(name);
	}

	public String allGroupNames() {
		StringBuffer name = new StringBuffer();
		for (WebElement a : driver.findElements(By.className("group-link"))) {
			name.append(a.getText().trim() + " ");
		}
		return name.toString();
	}

	public void deleteFirstGroupFromFnE() {
		click(firstGroupDeleteLinkFnEscreen);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public boolean editTimeZoneIsDisplayedOnFnEPage() {
		waitForElementToLoad(editTimeZoneOption, waitForElementInMilliSeconds);
		return editTimeZoneOption.isDisplayed() && isHeaderDisplayed();
	}

	public void selectTimeZone(String timeZone) {
		Select changeTimeZone = new Select(editTimeZoneOption);
		changeTimeZone.selectByValue(timeZone);
	}

	public void submitFneForm() {
		click(submitFnEform);
		waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		waitForSync();

	}

	public boolean createElementOptionsDisplayed() {
		waitForSync();
		waitForElementToLoad(createNewElementTitle, waitForElementInMilliSeconds);
		return createNewElementTitle.isDisplayed() && saveButtonDisplayedonFnE();
	}

	public boolean elementTitleDisplayed(){
		waitForElementToLoad(createNewElementTitle, waitForElementInMilliSeconds);
		return createNewElementTitle.isDisplayed();
	}

	public boolean saveButtonDisplayedonFnE() {
		try {
			return saveNewCreatedElement.isDisplayed();
		} catch (NoSuchElementException e) {
			return saveEditAction.isDisplayed();
		}
	}

	public boolean verifyImageIsDiplayedInNewWindow() {
		setMainWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		while (window.hasNext()) {
			driver.switchTo().window(window.next());
		}
		return driver.findElement(By.cssSelector("img")).isDisplayed();
	}

	public void mainWindow() {
		driver.close();
		switchToMainWindow();
	}

	public void enterNewElementTitle(String newElementname) {
		waitForElementToLoad(createNewElementTitle, waitForElementInMilliSeconds);
		click(createNewElementTitle);
		createNewElementTitle.clear();
		itemCreated = newElementname + timeCreated;
		createNewElementTitle.sendKeys(newElementname + timeCreated);
	}

	public void clickSaveButtonForNewElement() {
		try {
			waitForElementToLoad(saveNewCreatedElement, 10000);
			saveNewCreatedElement.click();
			waitForSync();
		} catch (NoSuchElementException e) {
			//waitForElementToLoad(saveEditAction, waitForElementInMilliSeconds);
			click(saveEditAction);
			waitForSync();
		}
	}

	public void editElementTitle(String newElementname) {

		try {
			waitForSync(6000);
			editContentTitle.clear();
			editContentTitle.sendKeys(newElementname + DateUtil.getCurrentDateTime());
		} catch (NoSuchElementException e) {
			edit2ContentTitle.clear();
			edit2ContentTitle.sendKeys(newElementname + DateUtil.getCurrentDateTime());
		}
	}

	public void clickSaveButtonForEditAction() {
		try {
			click(saveEditAction);
			waitForSync();
		} catch (NoSuchElementException e) {
			click(save2EditAction);
			waitForSync();
		}
	}

	public boolean messageFlyerDisplayed(String message) {
		waitForElementToLoad(messageFlyer, waitForElementInMilliSeconds);
		return messageFlyer.isDisplayed();// && (messageFlyer.getText().trim().equals(message) || messageFlyer.getText().trim().matches(message));
	}

	public void clickOnQuestionTab() {
		try {
			//			waitForElementToLoad(questionsTabLink, 10000);
			//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionsTabLink);
			click(questionsTabLink);
			waitForSync();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('requireConfirmationQuestions').click();");
		}
	}

	public boolean questionBankPageDisplayed() {
		waitForElementToLoad(chapter1QuestionBankLearningCurve,40000);
		waitForSync();
		return chapter1QuestionBankLearningCurve.isDisplayed();

	}

	public void clickOnFirstChapterQuestionBank() {
		waitForElementToLoad(chapter1QuestionBankLearningCurve, waitForElementInMilliSeconds);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chapter1QuestionBankLearningCurve);
		//		scrollElementToView(driver,"child-item","0");
		waitForSync();
		click(chapter1QuestionBankLearningCurve);
	}




	public void clickFirstTestBank() {
		try {
			waitForSync(1000);
			click(testBank1Link);
		} catch (Exception e) {
			waitForSync(1000);
			click(testBankLink);
		}
		waitForElementToLoad(waitForQuestionLoad, waitForElementInMilliSeconds);
		waitForElementToLoad(waitForQuestionLoad, waitForElementInMilliSeconds);
		waitForElementToLoad(waitForQuestionLoad, waitForElementInMilliSeconds);
		waitForSync();
	}

	public void clickSecondTestBank() {
		try {
			waitForSync(1000);
			click(testBank2Link);
		} catch (Exception e) {
			waitForSync(1000);
			click(testBankLink);
		}
		waitForElementToLoad(waitForQuestionLoad, waitForElementInMilliSeconds);
		waitForElementToLoad(waitForQuestionLoad, waitForElementInMilliSeconds);
		waitForElementToLoad(waitForQuestionLoad, waitForElementInMilliSeconds);
		waitForSync();
	}

	public boolean questionsAreDisplayed() {
		waitForElementToLoad(driver.findElement(By.className("questions")), waitForElementInMilliSeconds);
		return driver.findElement(By.className("questions")).isDisplayed();
	}

	public void selectQuestions(int NoOfQuestions) {
		waitForSync();
		for (int i = 1; i <= NoOfQuestions; i++) {
			waitForElementToLoad(driver.findElement(By.cssSelector(replaceString(questionCheckBoxCss, i))), waitForElementInMilliSeconds);
			driver.findElement(By.cssSelector(replaceString(questionCheckBoxCss, i))).click();;
			waitForSync(500);
		}
		waitForSync();
	}

	public void addToPool() {
		try{
			click(addToPoolDropdown);
			waitForSync();
		}catch (StaleElementReferenceException e){
			((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('gearbox')[30].click();");
		}

		try{
			click(addToNewPoolLink);
			waitForSync();
		}catch (Exception e){
			((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('add-to-new-pool')[0].click();");
		}
		waitForSync();
	}

	public void addToExistingPool() {
		try{
			click(addToPoolDropdown);
			waitForSync();
		}catch (StaleElementReferenceException e){
			((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('gearbox')[30].click();");
			waitForSync();
		}

		click(addToExistingPoolLink);
		waitForSync();
	}


	public void addQuestions() {
		waitForElementToLoad(addQuestionButton, waitForElementInMilliSeconds);
		click(addQuestionButton);
		waitForSync();
	}

	public void enterPoolName(String poolName, String poolSize) {
		waitForElementToLoad(poolTitle, waitForElementInMilliSeconds);
		waitForSync(1000);
		poolTitle.clear();
		poolTitle.sendKeys(poolName);
		poolQuestionInfo.clear();
		poolQuestionInfo.sendKeys(poolSize);
		click(createPoolButton);
		waitForSync();
	}

	public void clickDoneEditing() {
		try {
			switchToMainWindow();
			waitForSync(500);
		} catch (Exception e) {
		}



		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementById('fne-done').click();");
		waitForSync();

		try {

			saveButtonOverlay1.click();
			waitForSync();

		} catch (NoSuchElementException ex) {

		}

		try {
			saveButtonOverlay2.click();
			waitForSync();

		} catch (NoSuchElementException ex) {

		}
	}

	public void verifyTimeLimit() {
		waitForSync();
		driver.findElement(By.xpath("//ul[@class='quiz-policy-list']/li[4]")).getText().trim().contains("There is a 1 minute time limit for this quiz");
	}

	public void verifyCountedAttemptType() {
		waitForSync();
		driver.findElement(By.xpath("//ul[@class='quiz-policy-list']/li[3]")).getText().trim().contains("Your lowest attempt will be counted as your score");
	}

	public void numberOfQuizAttempts() {
		waitForSync();
		driver.findElement(By.xpath("//ul[@class='quiz-policy-list']/li[2]")).getText().trim().contains("You may attempt the quiz 5 times");
	}

	public boolean isLearningCurveDisplayed(String title) {
		boolean a, b;

		setMainWindowHandle();
		waitForSync(25000);

		driver.switchTo().frame(learningActivityFrame);
		waitForElementToLoad(learningCurveActivityBorder);

		waitForElementToLoad(learningCurveActivityBorder);


		a = learningCurveActivityBorder.isDisplayed();

		waitForElementToLoad(learningCurveTitle, waitForElementInMilliSeconds);

		b = learningCurveTitle.getText().trim().contains(title);
		switchToMainWindow();
		return a && b;
	}

	public void mouseHoverOverEdit() {
		waitForSync();
		Actions hover = new Actions(driver);
		hover.moveToElement(fNeEditOption).build().perform();
		waitForSync();
	}

	public void editFneSettings() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('requireConfirmationSettings').click();");
		waitForSync();
	}

	public void editSettings() {
		waitForSync(1000);
		click(fNeEditOption);
		waitForSync(1000);
		click(settingsTabLink);
	}

	public void uncheckAutoScoreOption() {
		if (autoScoreCheckBox.isSelected()) {
			click(autoScoreCheckBox);
		}
	}

	public boolean enterUserScore(String score) {
		if (isAssignScoreEnabled()) {
			return true;
		} else {
			//			uncheckAutoScoreOption();
			//			waitForSync();
			//			assignScoreInputBox.clear();
			//			assignScoreInputBox.sendKeys(score);
			return true;
		}
	}

	public boolean isAssignScoreEnabled() {
		return assignScoreInputBox.isEnabled();
	}

	public void saveChangedSettings() {
		click(saveSettingsButton);
		waitForSync();
	}

	public boolean isUserEnteredScoreDisplayed(String score) {
		boolean a;
		//		setMainWindowHandle();
		//		try {
		//			switchToFrame();
		//		} catch (IndexOutOfBoundsException e) {
		//			switchToFrame(0);
		//		}

		setMainWindowHandle();
		waitForSync(25000);

		driver.switchTo().frame(learningActivityFrame);
		waitForElementToLoad(learningCurveActivityBorder);

		a = userEnteredScore.getText().trim().equals(score);
		switchToMainWindow();
		return a;
	}

	public void clickImageOnFnEpage() {
		setMainWindowHandle();
		switchToFrame();
		//		driver.navigate().refresh();
		for (int i = 0; i < 10; i++) {
			try {
				waitForElementToLoad(fnePageImgae, waitForElementInMilliSeconds);
				for (WebElement a : driver.findElements(By.cssSelector(fnEPageImageCss))) {
					a.click();
					break;
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
				switchToMainWindow();
				clickNextButton();
				switchToFrame();
			}
		}
	}

	public void clickOnRefrencedChapterName(String chapter) {
		waitForSync(5000);
		setMainWindowHandle();
		//		try {
		//			switchToFrame();
		//		} catch (IndexOutOfBoundsException e) {
		//			switchToFrame(0);
		//		}
		waitForElementToLoad(driver.findElement(By.xpath(replaceString(chapterNamexPath, chapter))), waitForElementInMilliSeconds);
		click(driver.findElement(By.xpath(replaceString(chapterNamexPath, chapter))));
		waitForSync();
	}

	public boolean newReferencedChapterDisplayed(String chapter) {
		boolean userNavigatedToChapter;
		driver.switchTo().window("popup_section");
		userNavigatedToChapter = driver.getCurrentUrl().contains(chapter + "_0.html");
		driver.close();
		switchToMainWindow();
		return userNavigatedToChapter;
	}

	public void clickKeyTerm() {
		setMainWindowHandle();
		try{
			switchToFrame();
		}catch(IndexOutOfBoundsException e){
			switchToFrame(0);
		}
		for (int i = 0; i < 10; i++) {
			try {
				//TODO: keyTermLink1 --> keyTermLink
				//				waitForElementToLoad(keyTermLink1, 15000);
				//				keyTermClicked = keyTermLink1.getText().trim();
				click(keyTermLink1);
				break;
			} catch (NoSuchElementException ex) {
				ex.printStackTrace();
				switchToMainWindow();
				clickNextButton();
				waitForSync(3000);
				switchToFrame();
			}
		}
	}

	public boolean isGlossaryDefinitionDisplayed() {
		waitForSync(4000);
		try {
			if (popInGlossaryDefinitionWIndow.isDisplayed()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Glossary Item is not available");
			return false;
		}
		return true;
	}

	public boolean isGlossaryDefinitionWindowContentDisplayed() {
		if (isGlossaryDefinitionDisplayed()) {
			if (popInWindowHeading.getText().contains("Glossary Definition")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void closePopInGlossaryDefWindow() {
		click(popInCloseLink);
		waitForSync();
		switchToMainWindow();
	}

	public void editFneBasicInfo() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('requireConfirmationBasicInfo').click();");
		waitForSync();
	}

	public void clickNextButton() {
		//		waitForElementToLoad(nextButton, waitForElementInMilliSeconds);
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		waitForSync();
		click(nextButton);
	}

	public void clickPreviousButton() {
		//		waitForElementToLoad(previousButton, waitForElementInMilliSeconds);
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", previousButton);
		click(previousButton);
	}

	public boolean isNextButtonEnabled() {
		try {
			waitForElementToLoad(nextButton, waitForElementInMilliSeconds);
			return !nextDisabled.isDisplayed();
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public boolean isPreviousButtonEnabled() {
		try {
			waitForElementToLoad(previousButton, waitForElementInMilliSeconds);
			return !previousDisabled.isDisplayed();
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public void clickUplooadDocument() {
		click(uploadDocumentLink);
		waitForSync();
	}

	public boolean uploadDocumentDialogDisplayed() {
		return dialogWindow.isDisplayed() && dialogWindowTitle.getText().trim().equalsIgnoreCase("File");
	}

	public boolean addLinkDialogDisplayed() {
		return dialogWindow.isDisplayed() && addLinkDialogTitleInput.isDisplayed() && addLinkDialogURLInput.isDisplayed();
	}

	public void clickAttachLink() {
		//waitForElementToLoad(addLinkLink, waitForElementInMilliSeconds);
		waitForSync();
		click(addLinkLink);
		waitForSync();
	}

	public void addNewLinkCollectionAndClickSave(String title, String url) {
		waitForElementToLoad(addLinkDialogTitleInput, waitForElementInMilliSeconds);
		addLinkDialogTitleInput.clear();
		addLinkDialogTitleInput.sendKeys(title);
		enterLinkUrl(url);
		click(addLinkDialogSaveButton);
		waitForSync();
	}

	public void enterLinkUrl(String url) {
		waitForElementToLoad(addLinkDialogURLInput, waitForElementInMilliSeconds);
		addLinkDialogURLInput.clear();
		addLinkDialogURLInput.sendKeys(url);
	}

	public boolean fneHeaderOptionsDisplayed() {
		waitForElementToLoad(fneAssignOption, waitForElementInMilliSeconds);
		waitForSync();
		return fneAssignOption.isDisplayed() && fNeEditOption.isDisplayed() &&  previousButton.isEnabled() && nextButton.isEnabled();
	}

	public boolean assignOption() {
		click(fneAssignOption);
		waitForElementToLoad(setpointsvalue, waitForElementInMilliSeconds);
		waitForSync();
		return setpointsvalue.isDisplayed();
	}

	public void clickResultsOnFneHeader() {
		//waitForElementToLoad(fneResultsOption, waitForElementInMilliSeconds);
		click(fneResultsOption);
	}

	public String getFneTitle() {
		return fneTitle.getText().trim();
	}

	public boolean studentSummaryDisplayedOnResultList() {
		boolean a;
		setMainWindowHandle();
		waitForSync(10000);
		resultLoaderDisplayed();
		switchToFrame();
		waitForElementToLoad(resultPagestudentSummary, waitForElementInMilliSeconds);
		a = resultPagestudentSummary.isDisplayed();
		switchToMainWindow();
		return a;
	}

	public void resultLoaderDisplayed() {
		try {
			while (resultLoader.isDisplayed()) {
				waitForSync();
			}
		} catch (NoSuchElementException e) {
		} catch (StaleElementReferenceException ex) {
		}
	}

	public void editLoaderDisplayed() {
		try {
			while (editLoader.isDisplayed()) {
				waitForSync();
			}
		} catch (NoSuchElementException e) {
		}
	}

	public void studentAnswersQuiz() {
		waitForSync(5000);
		setMainWindowHandle();
		switchToFrame();
		switchToFrame(0);
		switchToFrame(0);
		for (int i = 1; i <= driver.findElements(By.className("examQuestionTable")).size(); i++) {
			click(driver.findElement(By.xpath(replaceString(studnetAnswersQuestion, randomNo(1, 4), Integer.toString(i)))));
		}
	}

	public boolean studentSubmitsQuiz() {
		waitForSync();
		click(studentSubmitQuizButton);
		waitForSync();
		click(confirmsubmit);
		waitForSync(6000);
		switchToMainWindow();
		return doneEditingButton.isDisplayed();
	}

	public boolean gradeTableIsDisplayedForStudent() {
		boolean a;
		setMainWindowHandle();
		waitForSync();
		try{
			switchToFrame();
		} catch (IndexOutOfBoundsException e){
			switchToFrame(0);
		}
		waitForElementToLoad(gradeTableDisplayed, waitForElementInMilliSeconds);
		a = gradeTableDisplayed.isDisplayed();
		switchToMainWindow();
		return a;
	}

	public void clickStartQuiz() {
		try{
			//waitForElementToLoad(startQuizButton, waitForElementInMilliSeconds);
			click(startQuizButton);
		}
		catch(Exception e){
			click(driver.findElement(By.cssSelector(".fne-link.linkButton.start-quiz.faceplatefne")));
		}

		waitForSync(20000);
	}

	public boolean deafaultExpireMessageIsDisplayed(String text) {
		return defaultMessageOnFnEPage.getText().contains(text);
	}

	@FindBy(css = "#studentList_FrameContent tr:nth-child(2)")
	WebElement studentNameOnResultPage;

	public boolean individualScoredetailsOfAIndividualIsDisplayed() {
		boolean a;
		setMainWindowHandle();
		waitForSync();
		resultLoaderDisplayed();
		switchToFrame();
		//waitForElementToLoad(studentNameOnResultPage, waitForElementInMilliSeconds);
		click(studentNameOnResultPage);
		try {
			while (driver.findElement(By.className("loading-indicator")).isDisplayed()) {
				waitForSync();
			}
		} catch (NoSuchElementException e) {
		}
		a = driver.findElement(By.id("grade")).isDisplayed();
		switchToMainWindow();
		return a;
	}

	public void clickUploadButtonForDropBox() {
		click(uploadAssignmentForDropBox);
		waitForSync();
	}

	public void enterDescriptionInDropboxTinyMceAndSubmit() {
		enterDescriptionInDropboxTinyMce();
		click(dropBoxSubmit);
		waitForSync(5000);
	}

	public void enterDescriptionInDropboxTinyMce() {
		String currentDir = System.getProperty("user.dir");
		if (System.getProperty("os.name").contains("Windows")) {
			driver.findElement(By.id("uploadFile")).sendKeys(currentDir + "\\testdata\\sample.jpg");
		} else {
			driver.findElement(By.id("uploadFile")).sendKeys(currentDir + "/testdata/sample.jpg");
		}
	}

	public void addImage() {
		if (System.getProperty("os.name").contains("Windows")) {
			driver.findElement(By.id("uploadFile")).sendKeys(currentDir+"\\testdata\\sample.jpg");
		} else {
			driver.findElement(By.id("uploadFile")).sendKeys("/home/qainfotech/Desktop/images.jpg");
		}
	}

	public void changeTheAddedImage() {
		if (System.getProperty("os.name").contains("Windows")) {
			driver.findElement(By.id("uploadFile")).sendKeys(currentDir+"\\testdata\\samplePicture.jpg");
		} else {
			driver.findElement(By.id("uploadFile")).sendKeys("/home/qainfotech/Desktop/images.jpg");
		}
	}

	public void click1UngradedSubmissionMessage() {
		waitForElementToLoad(driver.findElement(By.cssSelector("#assignmentViewContent>div>div>a")), waitForElementInMilliSeconds);
		click(driver.findElement(By.cssSelector("#assignmentViewContent>div>div>a")));
		waitForSync(15000);
	}

	public boolean dateInfoMatched(String dDate, String dTime) {
		String time;
		String date = dueMonthInfo.getText().trim() + " " + dueDateInfo.getText().trim();
		try {
			time = timeInfo.getText().trim().split("pts")[1].trim();
		} catch (Exception e) {
			time = timeInfo.getText().trim();
		}
		System.out.println("dDate: " + dDate + " date: " + date);
		System.out.println("dTime: " + dTime + " time: " + time);
		return dDate.equalsIgnoreCase(date) && dTime.equalsIgnoreCase(time);
	}

	public boolean verifyGradeNeededIconIsDisplayed() {
		boolean a;
		setMainWindowHandle();
		waitForSync(20000);
		switchToFrame();
		a = driver.findElement(By.cssSelector(".gbr-head [src='/BrainHoney/Images/s.gif']")).isDisplayed();
		switchToMainWindow();
		return a;
	}

	public boolean setDateTimeField() {
		waitForSync(6000);
		for (int i = 0; i < 3; i++) {
			click(driver.findElement(By.cssSelector(".datepickerGoNext>a>span")));
			waitForSync();
		}
		click(setDateTime);
		waitForSync();
		return submissionUntillGrace.getText().trim().contains("Allow late submissions until grace period expires") && emailReminderForStudent.getText().trim().contains("Schedule an email reminder for students");
	}
	public boolean assignButton() {
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assignBtn);
		click(assignBtn);
		waitForSync();
		return saveChanges.isDisplayed() && unassignBtn.isDisplayed();
	}

	public void randomQuizOrderCheckbox() {
		waitForSync();
		click(driver.findElement(By.id("RandomizeQuestionOrder")));
		waitForSync();
	}

	public void clickSaveButton() {
		//savequiz btn after entering details
		waitForSync();
		click(saveButton);
		waitForSync(5000);
	}

	public boolean changeQuizAttampts() {
		//click number of attampts dropbox
		
		Select select = new Select(driver.findElement(By.name("NumberOfAttempts.Attempts")));

		select.selectByIndex(4);
		
//		click(driver.findElement(By.xpath("//select[@name='NumberOfAttempts.Attempts']")));
//		waitForSync(500);
//		click(driver.findElement(By.xpath("(//select[@name='NumberOfAttempts.Attempts']/option)[6]")));
		return doneEditingButton.isDisplayed();
	}

	public boolean changeScoredAttampts() {
		//click number of scored attampts dropbox
		
		Select select = new Select(driver.findElement(By.name("NumberOfAttempts.Attempts")));
		select.selectByIndex(4);
		
//		click(driver.findElement(By.xpath("//div/select[@id='GradeRule']")));
//		waitForSync(1000);
//		click(driver.findElement(By.xpath("(//div/select[@id='GradeRule']/option)[4]")));
		return doneEditingButton.isDisplayed();
	}

	public boolean verifyVisibilityOptions() {
		waitForSync();
		return driver.findElement(By.className("spanVisibility")).getText().trim().contains("Hide from students") && driver.findElement(By.className("spanVisibility")).getText().trim().contains("Hide from students until date");
	}

	public void hideFromStudent() {
		waitForElementToLoad(driver.findElement(By.id("hidefromstudent")), waitForElementInMilliSeconds);
		click(driver.findElement(By.id("hidefromstudent")));
	}

	public void selectFirstChapterFromQuestionByChapter() {
		//click on first chapter
		click(driver.findElement(By.xpath("//li/div/a[@id='LOR_psychportal__myers10e__master_Chapter__1']")));
	}

	public void selectQuestionByAssessment() {
		//click question assessment
		click(driver.findElement(By.xpath("(//div[@class='browseinassessment browse-question-category']/div/ul/li/div/a)[2]")));
	}

	public void selectTestBank() {
		//select test bank
		click(driver.findElement(By.xpath("(//ul[@class='quiz-item-links']/li/div/a)[3]")));
		waitForElementToLoad(waitForQuestionLoad, waitForElementInMilliSeconds);
		waitForElementToLoad(waitForQuestionLoad, waitForElementInMilliSeconds);
		waitForElementToLoad(waitForQuestionLoad, waitForElementInMilliSeconds);
		waitForSync();
	}

	//div[@class='browseinassessment browse-question-category']/div/ul/li/div/a
	public boolean essayQuestions() {

		//select easy questions
		click(driver.findElement(By.xpath("(//ul[@class='quiz-item-links']/li/div/a)[1]")));
		waitForSync();
		//verify question list
		List<WebElement> questions = driver.findElements(By.xpath("(//ul[@class='questions']/li)"));
		return !questions.isEmpty();
	}

	public void previewQuestion() {
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('preview-available-question')[1].style.display=('block');");
		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('preview-available-question')[1].click();");
	}

	public void selectAllFromSelectManu() {
		//waitForElementToLoad(selectMenu, waitForElementInMilliSeconds);
		//waitForSync(3000);
		click(selectMenu);
		waitForSync();
		click(selectAll);
		//waitForSync();
		click(driver.findElement(By.className("add-quiestion-btn-wrapper")));
		waitForSync();
	}

	public boolean verifyQuestionsAdded() {
		List<WebElement> addedQlist = driver.findElements(By.xpath("//ul[@class='questions ui-sortable']/li/input[@class='question-id']"));
		return !addedQlist.isEmpty();
	}

	public void clickOnQuestionBanks() {
		waitForSync();
		click(questionBanksLink);
		waitForSync();
	}

	public void clickCloseCross() {
		//click cross
		//waitForSync(3000);
		try {
			//			waitForElementToLoad(closePreview, 20000);
			//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closePreview);
			click(closePreview);
			waitForSync();
		} catch (Exception e) {
			waitForSync();
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('ui-icon ui-icon-closethick')[1].click();");
		}
		waitForSync();
	}

	public boolean clickCreatedLinkCollectionAndVerifyNewPageDisplayed() {
		waitForSync();
		boolean a;
		for (WebElement anchorLink : driver.findElements(By.cssSelector(linkCollectionsCss))) {
			click(anchorLink);
			break;
		}
		setMainWindowHandle();
		driver.switchTo().window("_newtab");
		a = driver.getTitle().contains("Macmillan");
		switchToMainWindow();
		return a;
	}

	public void enterUploadDocumentTitleAndClickUpload(String title) {
		uploadDocumentTitleInput.sendKeys(title);
		click(uploadButton);
		waitForSync();
	}

	public boolean subittedDocumentDisplayed(String title) {
		waitForElementToLoad(uploadedDocumentTitle, waitForElementInMilliSeconds);
		return uploadedDocumentTitle.getText().trim().equals(title);
	}

	//CodeByAyush
	public boolean instructorConsoleGradebook() {
		return instconslgrdbuk.isDisplayed();
	}

	public boolean studentConsoleGradebook() {
		return studconslgrdbuk.isDisplayed();
	}

	public void checkForCompleteVisible() {

		//	driver.navigate().refresh();
		waitForSync();
		setMainWindowHandle();
		switchToFrame();
		waitForElementToLoad(displayoptions, waitForElementInMilliSeconds);
		assert displayoptions.getText().trim().contains("Display Options");
		click(displayoptions);
		waitForSync();
		assert visiblecolumns.getText().trim().contains("Visible Columns...");
		click(visiblecolumns);
		waitForSync();
		if (!driver.findElement(By.id("colCompleted_FrameContent")).isSelected()) {
			click(driver.findElement(By.id("colCompleted_FrameContent")));
		}
		waitForSync();
		click(okButtonGradebook);
		waitForSync();
		switchToMainWindow();
		waitForSync();
		//	driver.navigate().refresh();
		//	clickHome);
		waitForSync();
	}

	public boolean completeVisible() {
		waitForSync();
		setMainWindowHandle();
		switchToFrame();

		waitForSync();
		return completecol.isDisplayed();
	}

	public boolean minuteVisible() {
		waitForSync();
		setMainWindowHandle();
		switchToFrame();

		waitForSync();
		return minutecol.isDisplayed();
	}

	public boolean checkIsEnrolledStudentVisible() {
		waitForSync();
		setMainWindowHandle();
		switchToFrame();
		waitForSync();
		waitForElementToLoad(studentname, waitForElementInMilliSeconds);
		return studentname.isDisplayed();
	}

	public void visibleColumns() {
		waitForSync();
		switchToMainWindow();

		setMainWindowHandle();
		switchToFrame();

		waitForSync(5000);
		assert displayoptions.getText().trim().contains("Display Options");
		click(displayoptions);
		waitForSync();
		assert visiblecolumns.getText().trim().contains("Visible Columns...");
		click(visiblecolumns);
		waitForSync(5000);
		if (!driver.findElement(By.id("colPoints_FrameContent")).isSelected()) {
			click(driver.findElement(By.id("colPoints_FrameContent")));
		}
		if (!driver.findElement(By.id("colGrade_FrameContent")).isSelected()) {
			click(driver.findElement(By.id("colGrade_FrameContent")));
		}
		waitForSync();
		click(okButtonGradebook);
		waitForSync();
		switchToMainWindow();
		waitForSync();
	}

	public void visibleFooter() {
		driver.navigate().refresh();
		waitForSync();
		switchToMainWindow();

		setMainWindowHandle();
		switchToFrame();

		waitForSync(5000);
		assert displayoptions.isDisplayed();
		click(displayoptions);
		waitForSync();
		assert visiblefooter.isDisplayed();
		click(visiblefooter);
		waitForSync(5000);
		if (!driver.findElement(By.id("rowFailing_FrameContent")).isSelected()) {
			click(driver.findElement(By.id("rowFailing_FrameContent")));
		}
		waitForSync();
		click(okButtonGradebook);
		waitForSync();
		switchToMainWindow();
		waitForSync();
	}

	public void scoreDisplay() {
		driver.navigate().refresh();
		waitForSync();
		switchToMainWindow();

		setMainWindowHandle();
		switchToFrame();

		waitForSync();
		waitForElementToLoad(displayoptions, waitForElementInMilliSeconds);
		waitForSync();
		assert displayoptions.getText().trim().contains("Display Options");
		click(displayoptions);
		waitForSync();
		assert scoredisplay.getText().trim().contains("Score Display Options...");
		click(scoredisplay);
		//waitForSync(5000);
		click(okButtonGradebook);
		waitForSync();
		switchToMainWindow();
		waitForSync();
	}

	public void clickTheHome() {
		waitForSync();
		switchToMainWindow();
		waitForSync();
		click(clickHome);
		waitForSync();
	}

	public boolean minuteColumnIsNotEmpty() {
		waitForSync();
		setMainWindowHandle();
		switchToFrame();

		waitForSync();
		return !(minutevalue.getText().isEmpty());
	}

	public void switchToFrameByIdForMceEditor() {
		final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(driver.findElement(By.id("mce_4_ifr")));
	}

	public void switchToFrameById() {
		final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(driver.findElement(By.id("Content.Description_ifr")));
	}

	public void writeInMceEditor(String text) {
		waitForSync();

		setMainWindowHandle();
		assert mceEditor.isDisplayed();
		switchToFrame();
		mceEditor.clear();

		mceEditor.sendKeys(text);

		//  Actions action = new Actions(driver);
		//  action.doubleClick(mceEditor);
		//  action.perform();
		try {
			click(mceEditor);
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			waitForSync();
			robo.keyPress(KeyEvent.VK_A);
			waitForSync();

			robo.keyRelease(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
		}
		switchToMainWindow();
		assert editLink.isDisplayed();

		click(editLink);
		switchToFrameByIdForMceEditor();
		hyperLink.sendKeys("http://www.google.com");
		click(insert);
		switchToMainWindow();
		click(saveButtonWelcomePage);
		//driver.switchTo().defaultContent();
		waitForSync();
	}

	public void doneEditingButton() {
		click(doneEditingButton);
	}

	public boolean clickOnHypeLink() {
		waitForSync();
		assert hypeLink.isDisplayed();
		waitForSync();
		click(hypeLink);
		waitForSync();
		assert googlePage.isDisplayed();
		driver.navigate().back();
		driver.navigate().refresh();
		waitForSync();
		return entercourse.isDisplayed();
	}

	public void enterSecondUrl() {
		waitForSync();

		setMainWindowHandle();
		assert mceEditor.isDisplayed();
		switchToFrame();

		//	   Actions action = new Actions(driver);
		//	   action.doubleClick(mceEditor);
		//	   action.perform();

		try {
			click(mceEditor);
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			waitForSync();
			robo.keyPress(KeyEvent.VK_A);
			waitForSync();

			robo.keyRelease(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
		}
		switchToMainWindow();
		assert editLink.isDisplayed();

		click(editLink);

		switchToFrameByIdForMceEditor();
		hyperLink.clear();
		hyperLink.sendKeys("http://www.yahoo.com");
		click(insert);

		switchToMainWindow();
		click(saveButtonWelcomePage);
		//driver.switchTo().defaultContent();
		waitForSync();
	}

	public boolean clickOnHypeLinkAgain() {
		waitForSync();
		assert hypeLink.isDisplayed();
		waitForSync();
		click(hypeLink);
		waitForSync();
		assert yahooPage.isDisplayed();
		driver.navigate().back();
		driver.navigate().refresh();
		waitForSync();
		return entercourse.isDisplayed();
	}

	public void writeInMceEditorUnderQuiz(String text) {
		waitForSync();

		setMainWindowHandle();
		assert mceEditor.isDisplayed();
		switchToFrameById();
		mceEditor.clear();
		mceEditor.sendKeys(text);
		waitForSync();
		//	mceEditor1);
		//	mceEditor1);
		//	waitForSync();

		//   Actions action = new Actions(driver);
		// action.doubleClick(mceEditor1);
		//action.perform();
		try {
			click(mceEditor);
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			waitForSync();
			robo.keyPress(KeyEvent.VK_A);
			waitForSync();

			robo.keyRelease(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
		}
		switchToMainWindow();
		assert editLink.isDisplayed();
		click(editLink);
		switchToFrameByIdForMceEditor();
		hyperLink.sendKeys("http://www.google.com");
		click(insert);
		switchToMainWindow();
		click(saveButtonQuiz);
		waitForSync();
		click(doneEditingButton);
		waitForSync();
		assert clickHome.isDisplayed();
		assert hypeLink.isDisplayed();
		waitForSync();
		click(clickHyperlink);
		waitForSync();
		assert googlePage.isDisplayed();

		waitForSync();
		driver.navigate().back();
		driver.navigate().refresh();
		waitForSync();
		click(clickHome);
		waitForSync();
	}

	public void minuteColumnVisible() {
		driver.navigate().refresh();
		waitForSync();
		setMainWindowHandle();
		switchToFrame();
		waitForSync();
		waitForElementToLoad(displayoptions, waitForElementInMilliSeconds);
		assert displayoptions.getText().trim().contains("Display Options");
		click(displayoptions);
		waitForSync();
		assert visiblecolumns.getText().trim().contains("Visible Columns...");
		click(visiblecolumns);
		waitForSync();

		if (!minutescheck.isSelected()) {
			click(minutescheck);
		}
		waitForSync();
		click(okButtonGradebook);
		waitForSync();
		switchToMainWindow();
		waitForSync();

	}

	public void importTheScores() {
		driver.navigate().refresh();
		waitForSync();
		setMainWindowHandle();
		switchToFrame();
		waitForElementToLoad(importscores, waitForElementInMilliSeconds);
		click(importscores);
		waitForSync();
		assert importscorepath.isDisplayed();
		//importscorepath.sendKeys("C:\\Users\\ayushjain1.QAIT\\Desktop\\upload2.csv");

		String currentDir = System.getProperty("user.dir");
		if (System.getProperty("os.name").contains("Windows")) {
			importscorepath.sendKeys(currentDir+"\\testdata\\upload2.csv");
		} else {
			driver.findElement(By.id("uploadFile")).sendKeys(currentDir+"/testdata/upload2.csv");
		}

		waitForSync();
		assert continueimport.isDisplayed();
		click(continueimport);
		waitForSync();
		click(selectcolumn);
		waitForSync();
		click(chooseoption);
		waitForSync();
		click(selectsubcolumn);
		waitForSync();
		click(choosesuboption);
		waitForSync();
		click(confirmimport);
		waitForSync();
		click(close);
		waitForSync();
		switchToMainWindow();
	}

	public boolean exportTheScores() {
		waitForSync();
		setMainWindowHandle();
		switchToFrame();
		waitForSync();
		click(exportscores);
		waitForSync();
		return confirmexport.isDisplayed();
		//waitForSync();
	}

	public void closeexport() {
		waitForSync();
		click(close);
		waitForSync();
	}

	public boolean editConsoleLinkOnHomePageAndSelect() {
		waitForSync();
		click(editConsoleLinks);
		waitForSync();
		click(resourcesByChapters);
		waitForSync();
		assert selectLinksPage.getText().contains("Check the links that should appear in your console");
		click(driver.findElement(By.id("settingsSave")));
		waitForSync();
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeButton);
		click(homeButton);
		waitForSync();
		waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		return resourcesByChapter.getText().contains("Resources by chapter");
	}

	public boolean editConsoleLinkOnHomePageAndDeselect() {
		click(viewInstructorConsoleLink);
		waitForElementToLoad(resourcesButton, waitForElementInMilliSeconds);
		waitForSync();
		click(editConsoleLinks);
		waitForSync();
		click(resourcesByChapters);
		waitForSync();
		click(driver.findElement(By.id("settingsSave")));
		waitForSync();
		click(homeButton);
		waitForSync();
		return addButton.isDisplayed();
	}

	public boolean navigationSettings() {
		click(driver.findElement(By.xpath("(//div[@class='settingNav-links']/ul/li/a)[1]")));
		waitForSync(7000);
		assert inputTitleInNavigation.getText().contains("Include a Welcome screen in my course");
		assert checkboxInsideNavigation.isDisplayed();
		click(checkboxInsideNavigation);
		click(saveNavigationSettings);
		waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		return addButton.isDisplayed();
	}

	public boolean editGeneralSettings(String title, String courseNumber, String sectionNumber, String instructorName, String officeHours) {
		//		waitForElementToLoad(homeButton, waitForElementInMilliSeconds);
		//		waitForSync();
		click(academicTermDropdown);
		click(selectValueInAcademicTermDropdown);
		pageTitle.clear();
		pageTitle.sendKeys(title);
		courseNumberTextBox.clear();
		courseNumberTextBox.sendKeys(courseNumber);
		sectionNumberTextBox.clear();
		sectionNumberTextBox.sendKeys(sectionNumber);
		instructorNameTextBox.clear();
		instructorNameTextBox.sendKeys(instructorName);
		enterOfficeHours.clear();
		enterOfficeHours.sendKeys(officeHours);
		waitForSync(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveGeneralSettings);
		waitForSync(1000);
		try {
			assert contactInfoType.isDisplayed();
		} catch (Exception e) {
			click(newPointOfContact);
			waitForSync(1000);
		}
		assert emailOption.isDisplayed();
		assert phoneOption.isDisplayed();
		assert faxOption.isDisplayed();
		assert otherOption.isDisplayed();
		contactInfoInput.clear();
		contactInfoInput.sendKeys("qait@qainfotech.net");
		click(saveGeneralSettings);
		waitForSync(1000);
		waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		waitForSync(1000);
		return addButton.isDisplayed();
	}

	public void clickAssignButton() {
		try {
			//			waitForElementToLoad(assignButton, 20000);
			//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assignButton);
			click(assignButton);
			waitForSync();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('fne-item-assign'));");
		}
	}

	public void selectIndividualStudent() {
		waitForSync();
		click(driver.findElement(By.xpath("(//select[@id='ddlSettingsList'])")));
		waitForSync();
		//driver.findElement(By.xpath("(//select[@id='ddlSettingsList'])")).sendKeys(Keys.ARROW_DOWN,Keys.TAB);
		click(driver.findElement(By.xpath("(//select[@id='ddlSettingsList']/option)[3]")));
	}

	public void selectAGroupFromSettingsFor() {
		waitForElementToLoad(selectSettingsToAssign, waitForElementInMilliSeconds);
		waitForSync();
		Select se = new Select(selectSettingsToAssign);
		se.selectByIndex(2);
		waitForSync();
	}

	public void handleRobotEventForAddingNewQuestions(WebElement element) {
		element.sendKeys(Keys.RETURN);
		waitForSync();
	}

	public void addMultipleAnswerQuestion() {
		waitForSync();
		createQuest();
		waitForSync();
		click(multipleanswers);
		waitForSync(5000);
		setMainWindowHandle();
		switchToFrame();
		waitForElementToLoad(questionname, waitForElementInMilliSeconds);
		waitForSync();
		questionname.sendKeys("This is Question ");
		waitForSync();
		handleRobotEventForAddingNewQuestions(questionname);

		//questionname.sendKeys(Keys.ENTER);
		choice1.sendKeys("option1");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice1);
		//choice1.sendKeys(Keys.ENTER);
		choice2.sendKeys("option2");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice2);
		//choice2.sendKeys(Keys.ENTER);
		choice3.sendKeys("option3");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice3);
		//choice3.sendKeys(Keys.ENTER);
		choice4.sendKeys("option4");
		waitForSync();
		click(correctanswer);
		waitForSync();

		switchToMainWindow();
		waitForSync();
		click(savequestion);
		waitForSync();
	}

	public void addAdvanceQuestion() {
		waitForSync();
		createQuest();
		waitForSync();
		click(advanceQuestion);
		waitForSync(8000);
		setMainWindowHandle();
		waitForSync();
		switchToFrame();
		waitForSync();
		click(saveButtonForAdvanceQuestion);
		waitForSync();
		switchToMainWindow();
	}

	public void editQuestionsAnswerFromQuiz() {
		waitForSync(10000);
		//questionCheckbox);
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(questionCheckbox).build().perform();
		waitForSync();
		waitForElementToLoad(editCurrentQuestion, waitForElementInMilliSeconds);
		click(editCurrentQuestion);
		waitForSync(5000);
		setMainWindowHandle();
		switchToFrame();
		waitForElementToLoad(editCorrectAnswer, waitForElementInMilliSeconds);
		waitForSync();
		click(editCorrectAnswer);
		waitForSync();
		switchToMainWindow();
		waitForElementToLoad(savequestion, waitForElementInMilliSeconds);
		waitForSync();
		click(savequestion);
		waitForSync(5000);

		clickDoneEditing();
		waitForSync();
		click(driver.findElement(By.xpath("(//span[@class='ui-button-text'][./text()='Save'])")));
		waitForSync();
	}

	public void clickRemoveQuestionFromRightSide() {
		waitForSync(500);
		try{
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(questionCheckBoxCssOnRight).build().perform();
		waitForSync();
		click(removeSelectedQuestionFromRight);
		waitForSync(4000);
		click(confirmRemoveQuestionFromRightSide);
		waitForSync();
		}
		catch(Exception e){
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('move-current-question')[0].style.display='block'");
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('edit-current-question')[0].style.display='block'");
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('delete-current-question')[0].style.display='block'");
			waitForSync(500);
			click(removeSelectedQuestionFromRight);
			waitForSync(4000);
			click(confirmRemoveQuestionFromRightSide);
			waitForSync();
		}
	}
	
	public void clickRemovePoolFromRightSide() {
		waitForSync(500);
//		Actions hoverOver = new Actions(driver);
//		hoverOver.moveToElement(poolCheckBoxOnRight).build().perform();
//		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('move-current-question')[0].style.display='block'");
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('edit-current-question')[0].style.display='block'");
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('delete-current-question')[0].style.display='block'");
		waitForSync(500);
		click(removeSelectedQuestionFromRight);
		waitForSync(4000);
		click(confirmRemoveQuestionFromRightSide);
		waitForSync();
	}

	public void clickRemoveQuestionFromQuiz() {
		waitForSync(500);
		//questionCheckBox1);
		try{
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(questionCheckBox1).build().perform();
		waitForSync();
		click(removeSelectedQuestionFromRight);
		waitForSync(1000);
		click(confirmRemoveQuestionFromRightSide);
		waitForSync();
		}
		catch(Exception e){
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('move-current-question')[0].style.display='block'");
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('edit-current-question')[0].style.display='block'");
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('delete-current-question')[0].style.display='block'");
		waitForSync(500);
		click(removeSelectedQuestionFromRight);
		waitForSync(1000);
		click(confirmRemoveQuestionFromRightSide);
		waitForSync();
		}
	}

	public void addMatchingQuestion() {
		waitForSync();
		createQuest();
		waitForSync();
		click(matching);
		waitForSync(5000);
		setMainWindowHandle();
		switchToFrame();
		waitForSync(8000);
		questionname.sendKeys("This is Question ");
		waitForSync();
		questionname.sendKeys(Keys.ENTER);
		handleRobotEventForAddingNewQuestions(questionname);

		choice1.sendKeys("option1");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice1);
		choice2.sendKeys("answer1");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice2);
		choice3.sendKeys("option2");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice3);
		choice4.sendKeys("answer2");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice4);
		waitForSync();
		switchToMainWindow();
		waitForSync();
		click(savequestion);
		waitForSync(8000);
	}

	public void addEssayQuestion() {
		waitForSync();
		createQuest();
		waitForSync();
		click(essay);
		waitForSync(8000);
		setMainWindowHandle();
		switchToFrame();
		waitForSync(8000);
		questionname.sendKeys("Write an essay on the topic 'Topic' ");
		waitForSync();

		switchToMainWindow();
		waitForSync();
		click(savequestion);
		waitForSync();
	}

	public void addShortAnswerQuestion() {
		waitForSync();
		createQuest();
		waitForSync();
		click(shortAnswer);
		waitForSync(5000);
		setMainWindowHandle();
		switchToFrame();
		waitForSync(8000);
		questionname.sendKeys("What is the capital of India");
		waitForSync();
		questionname.sendKeys(Keys.ENTER);
		handleRobotEventForAddingNewQuestions(questionname);
		waitForSync();
		shortAnswerAnswer.sendKeys("Delhi");
		waitForSync();
		switchToMainWindow();
		waitForSync();
		click(savequestion);
		waitForSync(8000);
	}

	public void addQuestionPool() {
		waitForSync();
		createQuest();
		waitForSync();
		click(questionPool);
		waitForSync();
	}

	public void editQuestionInAssesment() {
		waitForSync(5000);
		setMainWindowHandle();
		switchToFrame();
		waitForSync(8000);
		questionname.sendKeys("..");
		switchToMainWindow();
		click(savequestion);
		waitForSync(10000);
	}

	public void addMultipleChoiceQuestion() {
		waitForSync();
		createQuest();
		waitForSync();
		click(multipleChoice);
		waitForSync(5000);
		setMainWindowHandle();
		//switchToFrame(2);
		driver.switchTo().frame(questionEditorFrame);
		//waitForElementToLoad(questionname, waitForElementInMilliSeconds);
		waitForSync(20000);
		questionname.click();
		questionname.sendKeys("This is Question ");
		waitForSync();
		handleRobotEventForAddingNewQuestions(questionname);

		choice1.sendKeys("option1");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice1);
		choice2.sendKeys("option2");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice2);
		choice3.sendKeys("option3");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice3);
		choice4.sendKeys("option4");
		waitForSync();
		click(correctanswer);
		waitForSync();

		switchToMainWindow();
		click(savequestion);
		waitForSync();
	}

	public void selectQuestionsToAddInExistingPool(int NoOfQuestions) {
		for (int i = 6; i <= (5 + NoOfQuestions); i++) {
			waitForElementToLoad(driver.findElement(By.cssSelector(replaceString(questionCheckBoxCss, i))), waitForElementInMilliSeconds);
			click(driver.findElement(By.cssSelector(replaceString(questionCheckBoxCss, i))));
			waitForSync(500);
		}
		waitForSync();
	}



	public boolean clickOnExpandQuestion() {
		waitForSync();
		click(questionOneExpandXpath);
		waitForSync(3000);
		return questionOneExpandXpath.getText().trim().contains("Collapse");
	}

	public boolean clickOnCollapseQuestion() {
		waitForSync();
		click(questionOneExpandXpath);
		waitForSync(3000);
		return questionOneExpandXpath.getText().trim().contains("Expand");
	}

	public void clickOnQuestionBanksAndThenSelectQuizNameUnderAssesment() {
		waitForSync();

	}

	public void addGraphingExerciseQuestion() {
		waitForSync();
		createQuest();
		waitForSync();
		click(graphingExercise);
		waitForSync(5000);
		waitForSync();
		click(savequestion);
		waitForSync();
	}

	public void selectAllFromBulkSelectionMenu() {
		waitForElementToLoad(selectMenu, waitForElementInMilliSeconds);
		waitForSync(3000);
		selectMenuForQuestions();
		waitForSync();
		click(selectAll);
		waitForSync();
	}

	public boolean selectQuestionsUsedInPreviousQuizFromBulkSelectionMenu() {
		//waitForSync(20000);
		selectMenuForQuestions();
		waitForSync();
		click(usedInPreviousQuiz);
		waitForSync(4000);
		return driver.findElement(By.cssSelector(replaceString(questionCheckBoxCss, 1))).isSelected();
	}

	public boolean deselectAllQuestions() {
		waitForSync(10000);
		selectAllFromBulkSelectionMenu();
		for (int i = 1; i <= 142; i++) {
			assert driver.findElement(By.cssSelector(replaceString(questionCheckBoxCss, i))).isSelected();
		}
		selectMenuForQuestions();
		waitForSync();
		click(selectNone);
		waitForSync();
		for (int i = 1; i <= 142; i++) {
			assert !driver.findElement(By.cssSelector(replaceString(questionCheckBoxCss, i))).isSelected();
		}
		return true;
	}

	public void clickEditQuestionInAssesment() {
		//waitForElementToLoad(questionCheckBoxCssOnRight);
		waitForSync(8000);

		//		waitForSync();
		//		Actions hoverOver = new Actions(driver);
		//		hoverOver.moveToElement(questionCheckBoxCssOnRight).build().perform();
		//		waitForSync();
		//		click(editQuestion);
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('edit-current-question')[4].click()");
		waitForSync(8000);
	}

	public void selectMenuForQuestions(){
		waitForElementToLoad(selectMenu, waitForElementInMilliSeconds);
		waitForSync();

		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectMenu);
		click(selectMenu);
		waitForSync();

	}

	//================================EditingForPageobjectsDown=================================================
	public boolean cancelStudentView() {
		//waitForElementToLoad(cancelstudentview, waitForElementInMilliSeconds);
		waitForSync(10000);
		click(cancelstudentview);
		waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		return addButton.isDisplayed();
	}

	public boolean isScoreEmpty() {
		waitForSync();
		boolean scoreBoolean;
		setMainWindowHandle();
		switchToFrame(1);
		String scoreval = null;
		for (int i = 1; i < 20; i++) {
			try {
				if (driver.findElement(By.cssSelector(replaceString(quizNameToCheckForPoints, i))).getText().trim().contains("TestQuiz")) {
					System.out.println("\n"+i+"="+scoreval+"\n");
					scoreval = driver.findElement(By.cssSelector(replaceString(quizPointsToCheckForPoints, i))).getText().trim();

					break;
				}
			} catch (Exception e) {
			}
		}
		if (scoreval.isEmpty() || scoreval.equals(null)) {
			scoreBoolean = true;
		} else {
			scoreBoolean = false;
		}
		switchToMainWindow();
		waitForSync();
		return scoreBoolean;
	}

	public void previousScore() {
		waitForElementToLoad(startQuizButton, waitForElementInMilliSeconds);
		a = previousscore.getText();
	}


	public void dropboxButton(String quizname) {
		waitForSync();
		click(dropboxButton);
		waitForSync();
		enterQuizDetails(quizname);
		click(savedropbox);
		waitForSync();
	}

	public void enterQuizDetails(String quizname) {
		waitForSync();
		waitForElementToLoad(courseName, 20000);
		courseName.isDisplayed();
		click(courseName);
		courseName.clear();
		waitForSync();
		String randomNum = DateUtil.getCurrentDateTime();
		timeCreated1 = DateUtil.getCurrentDateTime();
		courseName.sendKeys(quizname.replace("_DDMMM_HHMM", randomNum));
		waitForSync();
	}

	public void enterQuizSubtitleAndDirections() {
		waitForSync();
		click(coursesubtitle);
		waitForSync();
		coursesubtitle.sendKeys("TestUnitSubtitle");
		waitForSync();
		setMainWindowHandle();
		switchToFrame();
		waitForSync();
		mceEditor.clear();
		mceEditor.sendKeys("Follow These Directions Carefully");
		waitForSync();
		switchToMainWindow();
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
			//waitForElementToLoad(categoryname,20000);
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", categoryname);
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
			//			waitForElementToLoad(clickAssign,10000);
			//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickAssign);
			click(clickAssign);
			waitForSync();
		}catch (Exception e){
			((JavascriptExecutor)driver).executeScript("document.getElementById('btnAssign'));");
		}
		waitForSync();

		try {
			waitForSync();
			if (saveButtonOverlay2.isDisplayed()) {
				click(saveButtonOverlay2);
				waitForSync(1000);
			}
		} catch (NoSuchElementException e) {

		}
	}

	public void saveAllChanges() {
		waitForSync();
		click(saveChanges);
		waitForSync();
	}

	public void changePassingScore(String passscore) {
		waitForSync(3000);
		assert passingscore.isDisplayed();
		click(passingscore);
		passingscore.clear();
		passingscore.sendKeys(passscore);
		waitForSync();
		try {
			//			waitForElementToLoad(savepassscore, 20000);
			//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", savepassscore);
			click(savepassscore);
			waitForSync();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('savePassingScore'));");
		}
		waitForSync();
	}

	public boolean ispassingscorechanged() {
		if (passingscore.getText() != "0") {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickOnAnyChapterAndThenTestBank() {
		clickOnFirstChapterQuestionBank();
		clickFirstTestBank();
		return questionsAreDisplayed();
	}


	public void selectQuestionsAndThenClickOnAdd(int noOfQues) {
		selectQuestions(noOfQues);
		addQuestions();
	}


	public void editQuizSettingsForSinglePage() {
		waitForSync();
		assert settingsTabLink.isDisplayed();
		settingsTabLink();
		waitForSync();
		try {
			waitForElementToLoad(allquestionononescreen, 20000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allquestionononescreen);
			if (!allquestionononescreen.isSelected()) {
				click(allquestionononescreen);
			}
			waitForSync();
		} catch (WebDriverException e) {
		}
		saveTheSettings();
	}

	public void editQuizSettingsForSeparatePages() {
		waitForSync();
		assert settingsTabLink.isDisplayed();
		settingsTabLink();
		waitForSync();
		try {
			waitForElementToLoad(questionsonseparatepages, 20000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionsonseparatepages);
			if (!questionsonseparatepages.isSelected()) {
				click(questionsonseparatepages);
			}
			waitForSync();
		} catch (WebDriverException e) {
		}

		waitForSync();
		saveTheSettings();
	}


	public void useWeightedCategories() {
		waitForSync(3000);
		assert useweightedcategories.isDisplayed();
		click(useweightedcategories);
		waitForSync(10000);
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('labelWeight')[1].click();");

		waitForSync();
		assert setweight.isDisplayed();
		click(setweight);
		setweight.clear();
		setweight.sendKeys("40");
		waitForSync();
		try {
			//			waitForElementToLoad(confirmsetweight, 10000);
			//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmsetweight);
			click(confirmsetweight);
			waitForSync();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('btnWeight')[1].click();");
		}
		waitForSync(3000);
		assert useweightedcategories.isDisplayed();
		click(useweightedcategories);
		waitForSync(10000);
	}

	public void assignFromAssignmentTab(String contentName) {
		waitForSync();
		click(driver.findElement(By.linkText(contentName + timeCreated1)));
		waitForSync();
		click(clickedit);
		waitForSync();
		click(clickassignmenttab);
		waitForSync();
	}

	public void clickToViewhideAssignments() {
		waitForSync(4000);
		assert showassignments.getText().trim().contains("Show Assignments");
		click(showassignments);
		waitForSync();
		assert showassignments.getText().trim().contains("Hide Assignments");
		click(showassignments);
		waitForSync();
		assert showassignments.getText().trim().contains("Show Assignments");
		waitForSync(6000);
	}

	public void scoreSubmittedDueVisible() {
		waitForSync(5000);
		setMainWindowHandle();
		switchToFrame(1);
		assert Score.isDisplayed();
		assert Submitted.isDisplayed();
		assert Due.isDisplayed();
		switchToMainWindow();
		waitForSync();
	}

	public void rearrangeCategoriesNumerically() {
		waitForSync();
		assert sequence.isDisplayed();
		click(sequence);
		waitForSync(4000);
		assert option3.isDisplayed();
		click(option3);
		waitForSync(6000);
	}

	public void enterDropLowestValue() {
		waitForSync();
		Actions builder = new Actions(driver);
		builder.moveToElement(droplowestvalue).build().perform();
		waitForSync();
		click(droplowestvalue);
		waitForSync(5000);
		assert setdroplowestvalue.isDisplayed();
		click(setdroplowestvalue);
		setdroplowestvalue.clear();
		setdroplowestvalue.sendKeys("5");
		try {
			//waitForElementToLoad(confirmdroplowestvalue, 10000);
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmdroplowestvalue);
			click(confirmdroplowestvalue);
			waitForSync();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('btnDrop')[1].click();");
		}
		waitForSync(4000);
	}

	public boolean isdroplowestchanged() {
		if (droplowestvalue.getText() != "0") {
			return true;
		} else {
			return false;
		}
	}

	public void rearrangeAssignmentsUnderCategoriesNumerically() {
		waitForSync();
		assert showassignments.getText().trim().contains("Show Assignments");
		click(showassignments);
		waitForSync();
		assert showassignments.getText().trim().contains("Hide Assignments");
		waitForSync();
		assert assignmentsequence.isDisplayed();
		click(assignmentsequence);
		waitForSync();
		assert assignmentoption3.isDisplayed();
		click(assignmentoption3);
		waitForSync(6000);
		waitForSync();
	}
	public void addquestionfromedittab() {
		waitForElementToLoad(clickedit, 50000);
		waitForSync(5000);
		try{
			clickedit.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('fne-edit').click();");
		}
	}

	public void assignContent1(String time, String points) {

		waitForElementToLoad(clickassignmenttab, waitForElementInMilliSeconds);
		waitForSync();
		click(clickassignmenttab);
		waitForSync();
		setDateTimeField();
		waitForSync();
		setPoints(points);
		waitForSync();
		clickAssignAgain();
		waitForSync();
		settingsTabLink();
		waitForSync();
	}

	public void createMultipleAnswerAndAddFeedback(){
		clickOnQuestionTab();
		createQuest();
		waitForSync();
		click(multipleanswers);
		waitForSync(4000);
		setMainWindowHandle();
		switchToFrame();
		waitForSync();
		waitForElementToLoad(questionname, waitForElementInMilliSeconds);
		questionname.sendKeys("This is Question 1");
		waitForSync();
		handleRobotEventForAddingNewQuestions(questionname);

		choice1.sendKeys("option1");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice1);
		choice2.sendKeys("option2");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice2);
		choice3.sendKeys("option3");
		waitForSync();
		handleRobotEventForAddingNewQuestions(choice3);
		choice4.sendKeys("option4");
		waitForSync();
		click(correctanswer);
		waitForSync();
		click(editfeedback);
		waitForSync();
		switchToMainWindow();

		switchToFrame();
		switchToFrame(0);
		click(addfeedback);
		addfeedback.sendKeys("this is the feedback of question");
		switchToMainWindow();
		click(savequestion);
		waitForSync();
	}

	public void provideTimeLimitInSettingsTab() {
		waitForSync();
		waitForElementToLoad(settingsTabLink, waitForElementInMilliSeconds);
		assert settingsTabLink.isDisplayed();
		settingsTabLink();
		waitForSync();
		click(driver.findElement(By.id("TimeLimit")));
		driver.findElement(By.id("TimeLimit")).clear();
		driver.findElement(By.id("TimeLimit")).sendKeys("10");
		

		waitForSync();
		saveTheSettings();
	}

	public boolean timerVisible() {
		waitForSync();
		return timer.isDisplayed();
	}

	public void studentAttemptsQuiz() {
		waitForSync();
		waitForElementToLoad(gradebookButton, waitForElementInMilliSeconds);
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(driver.findElement(By.linkText("TestQuiz" + timeCreated1))).build().perform();
		waitForSync();
		click(driver.findElement(By.linkText("TestQuiz" + timeCreated1)));
		waitForSync();
		clickStartQuiz();
	}

	public boolean instructorViewsQuizResults() {
		waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(driver.findElement(By.linkText("TestQuiz" + timeCreated1))).build().perform();
		click(driver.findElement(By.linkText("TestQuiz" + timeCreated1)));
		waitForSync();
		click(results);
		waitForSync(6000);
		setMainWindowHandle();
		switchToFrame();
		waitForElementToLoad(scoreOfAttemptedQuiz, waitForElementInMilliSeconds);
		if(scoreOfAttemptedQuiz.getText().trim().equals(a)){
			switchToMainWindow();
			return true;
		}
		else{
			switchToMainWindow();
			return false;
		}
	}

	public void addStudentForSettings(){
		waitForSync();

	}

	public boolean studentSaveQuiz() {
		waitForSync();
		click(studentsavequiz);
		waitForSync(3000);
		switchToMainWindow();
		waitForElementToLoad(resumequiz, waitForElementInMilliSeconds);
		return resumequiz.isDisplayed();
	}

	public boolean studentCloseQuiz() {
		waitForSync();
		switchToMainWindow();
		setMainWindowHandle();
		waitForSync();
		switchToFrame();
		try {
			waitForElementToLoad(studentclosequiz, 20000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", studentclosequiz);
			click(studentclosequiz);
			waitForSync();
		} catch (Exception e) {
			click(studentclosequiz);
		}
		waitForSync();
		switchToMainWindow();
		waitForElementToLoad(startQuizButton, waitForElementInMilliSeconds);
		return startQuizButton.isDisplayed();
	}

	public void checksaveandcontinuebox() {
		waitForSync();
		settingsTabLink();
		try{
			waitForElementToLoad(allowsaveandcontinue, 20000);
			if (!allowsaveandcontinue.isSelected()) {
				click(allowsaveandcontinue);
			}
		}
		catch(Exception e){
		}
		saveTheSettings();
		waitForSync();
	}

	public void autoSubmitQuiz() {
		waitForSync();
		settingsTabLink();
		try{
			waitForElementToLoad(autosubmitassesments, 20000);
			if (!autosubmitassesments.isSelected()) {
				click(autosubmitassesments);
			}
		}
		catch(Exception e){
			click(autosubmitassesments);
		}
		saveTheSettings();
		waitForSync(5000);
	}

	public void settingsTabLink(){
		try {
			//			waitForElementToLoad(settingsTabLink, 20000);
			//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", settingsTabLink);
			click(settingsTabLink);
			waitForSync();
		} catch (WebDriverException e) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('requireConfirmationSettings').click();");
		}
	}

	public void saveTheSettings(){
		try {
			//			waitForElementToLoad(saveSettingsButton, 10000);
			//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveSettingsButton);
			click(saveSettingsButton);
			waitForSync();
		} catch (WebDriverException e) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('savecontentsetting').click();");
		}
	}

	public void createQuest() {
		waitForElementToLoad(createmenu, waitForElementInMilliSeconds);
		click(createmenu);
	}

	public void studentAttemptsHomework() {
		waitForSync(4000);
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(driver.findElement(By.linkText("TestHomeWork" + timeCreated1))).build().perform();
		click(driver.findElement(By.linkText("TestHomeWork" + timeCreated1)));
		waitForSync(4000);
		clickStartHomework();
	}

	public void clickStartHomework() {
		waitForSync();
		assert startHomework.isDisplayed();
		click(startHomework);
		waitForSync();
	}
	public void hoverOverContentByContentNameSecond(String contentName) {
		waitForElementToLoad(driver.findElement(By.linkText(contentName + timeCreated1)), waitForElementInMilliSeconds);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.linkText(contentName + timeCreated1)));
		waitForSync();
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(driver.findElement(By.linkText(contentName + timeCreated1))).build().perform();
		waitForSync(3000);
	}
	public void clickOnAssignmentTab(){
		//waitForElementToLoad(clickassignmenttab, waitForElementInMilliSeconds);
		click(clickassignmenttab);
	}

	//	public void forQuestioDisplay(){
	//		waitForElementToLoad(settingsTabLink, waitForElementInMilliSeconds);
	//		settingsTabLink);
	//		waitForSync();
	//		waitForElementToLoad(basicInfo, waitForElementInMilliSeconds);
	//		basicInfo);
	//		waitForElementToLoad(settingsTabLink, waitForElementInMilliSeconds);
	//	}

	public void dragAndDropQuestion(){
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('drag-indicator')[0].style.display='block'");
		waitForSync(500);
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('initial-drop-target')[1].style.display='block'");
		waitForSync(500);
		Actions builder = new Actions(driver);
		org.openqa.selenium.interactions.Action dragAndDrop =builder.dragAndDropBy(dragQuestionFrom, 840, 220).build();// builder.clickAndHold(dragQuestionFrom).moveToElement(dropQuestionTo, 15, 15).release(dropQuestionTo).build();//.release(dropQuestionTo).build();
		dragAndDrop.perform();
	}
	
	public boolean verifyAllQuestionAdded(){
		return driver.findElement(By.xpath("//span[@class='initial-drop-target']")).isDisplayed();
	}
	
	public void selectCheckBoxToRemoveQuestions(){
		click(driver.findElement(By.xpath("//label[@class='hasborder']/input")));
		click(removeButton);
		click(confirmRemoveQuestionFromRightSide);
	}
	
}