package com.qait.automation.MacmillanLaunchpad.CentralLibrary;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ExecutionError;
import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.ConfirmationPageUi;
import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.EnrollPageUi;
import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.FandEPageUi;
import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.JoinPageUi;
import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.LaunchpadHomeUi;
import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.LaunchpadPageUi;
import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.LoginPageUi;
import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.TopicPageUi;
import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.WelcomePageUi;
import com.qait.automation.MacmillanLaunchpad.Utils.DateUtil;
import com.qait.automation.MacmillanLaunchpad.Utils.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;

public class DataCentralLibrary  {


	// pageUi objects
	protected  LoginPageUi loginPage;
	protected  LaunchpadPageUi launchpadPage;
	protected  WelcomePageUi welcomePage;
	protected  LaunchpadHomeUi launchpadHome;
	protected  TopicPageUi topicPage;
	protected  EnrollPageUi enrollPage;
	protected  JoinPageUi joinPage;
	protected  ConfirmationPageUi confirmationPage;
	protected  FandEPageUi fandEPageUi;
	protected  CommonMethods common;


	protected  String courseUrlIns;	
	protected  String courseUrlStu=new String();
	protected  String clickedContent;
	protected  String hoveredChapter;
	protected int previousHitCount,latestHitCount;
	public String nextChapterClickedToBeAssigned;
	public String firstUnassignedContentName;
	public  StringBuffer chapterClickedToBeAssigned = new StringBuffer();
	public String assignButtonForNextContentToAssignWhichIsAlreadyAssigned = "#faceplate-unit-subitems-PX_LAUNCHPAD_ASSIGNED_WIDGET>li:nth-child(%) .faceplate-item-assign[value=Assign]:not([style*=none])";
	//public  String Browser;
	//public  String URL;
	public String courseName;

	public String baseCourse;
	public String url;
	public String browser;
	protected  int ajax_timeout=180;
	public static boolean checkBoolean1 , checkBoolean2 , checkBoolean3 , checkBoolean4 , checkBoolean5;
	WebDriver driver;
	public  void initPages(WebDriver driver) {
		loginPage = new LoginPageUi(driver);
		launchpadPage = new LaunchpadPageUi(driver);
		welcomePage = new WelcomePageUi(driver);
		launchpadHome = new LaunchpadHomeUi(driver);
		topicPage = new TopicPageUi(driver);
		enrollPage = new EnrollPageUi(driver);
		joinPage = new JoinPageUi(driver);
		confirmationPage = new ConfirmationPageUi(driver);
		fandEPageUi = new FandEPageUi(driver);
		common  = new CommonMethods(driver);
	}

	public  void checkBrowser(String browser) {
		Capabilities capabilities;
		capabilities = new DesiredCapabilities();
		((DesiredCapabilities) capabilities).setJavascriptEnabled(true);
		if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("IE")){
			File file = new File("IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setJavascriptEnabled(true);
			driver = new InternetExplorerDriver(dc);
		}
		else if (browser.equalsIgnoreCase("Chrome")) {
			((DesiredCapabilities) capabilities).setBrowserName("chrome");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("safari")) {
			((DesiredCapabilities) capabilities).setBrowserName("safari");
			driver = new SafariDriver();
		}

		//driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
	}

	public void browseThePortalURL(String url, String browser, String title) {
		//			Browser = browser;
		//			URL = url;
		checkBrowser(browser);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		//common.waitForSync();
	}

	public  void startBrowser(String url, String browser) {
		//			Browser = browser;
		//			URL = url;
		checkBrowser(browser);
		//driver.manage().timeouts().implicitlyWait(ajax_timeout, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		Dimension dimension = new Dimension(1366, 768);
		driver.manage().window().setSize(dimension);
		driver.manage().deleteAllCookies();
	}

	public DataCentralLibrary() {
		//PageFactory.initElements(driver, this);
		//setUp();
	}

	public void enterEmail(String userName) {
		loginPage.typeUserEmail(userName);

	}

	public void enterPassword(String password) {
		loginPage.typePassword(password);

	}

	public void clickLoginButton() {
		loginPage.clickLoginButton();
	}



	public boolean clickOnTheLogInAppearingForThe(String userType, String title) {
		if (userType.equalsIgnoreCase("instructor")) {
			loginPage.loginAsInstructor();
		} else if (userType.equalsIgnoreCase("student")) {
			loginPage.loginAsStudent();
		}

		return currentTitle().equalsIgnoreCase(title);
	}

	public boolean logInUsingTheValidCredentials(String userName, String password, String heading) {
		enterEmail(userName);
		enterPassword(password);
		clickLoginButton();
		return true;
		//return verifyHeading(heading);
	}

	public boolean logInToThePortalUsingTheSameInstructorCredentialByWhichCourseWasCreated(String userName, String password) {
		loginPage.loginAsInstructor();
		enterEmail(userName);
		enterPassword(password);
		clickLoginButton();
		return welcomePage.welcomeHeadingContains("Welcome to");
	}

	public boolean clickOnTheLogInButtonProvidedUnderStdudentHeading(String userName, String password) {
		loginPage.loginAsStudent();
		enterEmail(userName);
		enterPassword(password);
		clickLoginButton();
		return joinPage.validateCourseGreeting("Please confirm this is the course you wish to join:");
	}

	public void clickLogInButtonProvidedUnderStudentHeading(String userName, String password) {
		loginPage.loginAsStudent();
		enterEmail(userName);
		enterPassword(password);
		clickLoginButton();
	}

	public void clickLogInButtonProvidedUnderInstructorHeading(String userName, String password) {
		loginPage.loginAsInstructor();
		enterEmail(userName);
		enterPassword(password);
		clickLoginButton();
	}



	public void setUp() {
		Utilities.setYamlFilePath("testdata/macmillan_launchpad_test_data.yaml");
		url = Utilities.getYamlValue("portal.environment") + Utilities.getYamlValue("portal.course");
		browser = Utilities.getYamlValue("browser");
		courseName = Utilities.getYamlValue("portal.courseName");
		CommonMethods.waitForElementInMilliSeconds = Integer.parseInt(Utilities.getYamlValue("waitForElementInMilliSeconds"));
		baseCourse = Utilities.getYamlValue("portal.baseCourse");
		//initPages(driver);
		browseThePortalURL(url, browser, Utilities.getYamlValue("pageTitle"));
		initPages(driver);
		clickOnTheLogInAppearingForThe(Utilities.getYamlValue("users.instructor.type"), Utilities.getYamlValue("pageTitle"));
		if((Utilities.getYamlValue("browser")).equalsIgnoreCase("firefox")){
			logInUsingTheValidCredentials(Utilities.getYamlValue("users.instructor.user_name_ff"), Utilities.getYamlValue("users.instructor.password"), Utilities.getYamlValue("users.instructor.pageHeading"));
		}else if((Utilities.getYamlValue("browser")).equalsIgnoreCase("chrome")){
			logInUsingTheValidCredentials(Utilities.getYamlValue("users.instructor.user_name_c"), Utilities.getYamlValue("users.instructor.password"), Utilities.getYamlValue("users.instructor.pageHeading"));
		}else if((Utilities.getYamlValue("browser")).equalsIgnoreCase("ie")){
			logInUsingTheValidCredentials(Utilities.getYamlValue("users.instructor.user_name_ie"), Utilities.getYamlValue("users.instructor.password"), Utilities.getYamlValue("users.instructor.pageHeading"));
		}else{
			logInUsingTheValidCredentials(Utilities.getYamlValue("users.instructor.user_name_safari"), Utilities.getYamlValue("users.instructor.password"), Utilities.getYamlValue("users.instructor.pageHeading"));
		}

		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	public void deleteSampleCourses(String courseName) {
		onMyCoursePageClickOnDeleteLinkForCourseByCourseName(courseName);
		instructorClickOnDeleteButton(courseName);
	}

	public boolean verifyPageURLContains(String title) {
		return launchpadPage.urlContains(title);
	}

	public boolean verifyStudentPageURLContains(String title) {
		return launchpadPage.enrollurlContains(title);
	}

	public boolean verifyHeading(String heading) {
		return launchpadPage.getHeading(heading);
	}

	public boolean verifyEnrollFormHeading(String heading) {
		return launchpadPage.studentEnrollFormHeading(heading);
	}

	public boolean instructorIsLoggedInToTheApplicationWithValidCredentialAndMoveToHomePage(String userName, String password) {
		loginPage.loginAsInstructor();
		enterEmail(userName);
		enterPassword(password);
		clickLoginButton();
		launchpadPage.enterFirstCourseEnrolledByStudent();
		welcomePage.clickEnterCourseLink();
		return launchpadHome.isLaunchPadMenuDisplayed();
	}

	public boolean instructorIsLoggedInToTheCourseWithValidCredentialAndMoveToHomePage(String userName, String password) {
		loginPage.loginAsInstructor();
		enterEmail(userName);
		enterPassword(password);
		clickLoginButton();
		return welcomePage.verifyInstructorAtWelcomePage();
		//return launchpadHome.isLaunchPadMenuDisplayed();
	}

	public boolean clickOnCreateCourseLink() {
		launchpadPage.clickOnCreateCourse();
		return validateCreateCoursePopUpIsDisplayed() && validateRadioAndNavigationsButtonDisplayed();
	}

	public boolean selectYesRadioButton() {
		launchpadPage.selectYesRadioOpton();
		return launchpadPage.iscourseOptionDisplayed();
	}

	public boolean userSelectsTheCourseFromWhichToBaseTheNewCourse() {
		launchpadPage.selectFirstCourse();
		return launchpadPage.isFirstOptionSelected();
	}

	public boolean validateCreateCoursePopUpIsDisplayed() {
		return launchpadPage.createCoursePopUpIsDisplayed();
	}

	public boolean validateRadioAndNavigationsButtonDisplayed() {
		return launchpadPage.radioButtonOptionsWithNoSelectedAsDefault() && launchpadPage.cancelAndNextButtonsDisplayed();
	}

	public void clickNextButton() {
		launchpadPage.clickNextButton();
	}

	public boolean clickOnNextButton() {
		launchpadPage.clickNextButton();
		return launchpadPage.createCourseOptionsDisplayed();
	}

	public boolean userMadeChangesWithTheFieldsOnTheModalAndClickOnCreateButton(String courseName) {
		enterCourseName(courseName);
		clickCreateButton();
		return launchpadPage.verifyNewCourseIsDisplayedOnDashboard(courseName);
	}

	public boolean enterTheRequiredDetailsInCreateCourseOverlayAndClickOnCreateButton(String courseName) {
		enterCourseName(courseName);
		//        launchpadPage.enterSchoolName();
		clickCreateButton();
		try {
			//TODO: workaround for existing bug
			//
			Thread.sleep(500);
			clickCreateButton();
		} catch (InterruptedException ex) {
		} catch (ElementNotVisibleException e) {
		} catch (NoSuchElementException ex) {
		}
		return launchpadPage.verifyNewCourseIsDisplayedOnDashboard(courseName);
	}

	public void enterCourseName(String courseName) {
		launchpadPage.enterCourseTitle(courseName);
	}

	public void clickCreateButton() {
		launchpadPage.clickCreateButton();
	}

	public boolean validateNewCourseIsDisplayedOnDashboard(String courseName) {
		return launchpadPage.verifyNewCourseIsDisplayedOnDashboard(courseName);
	}

	public  String currentTitle(){
		return driver.getTitle().trim();
	}


	public void logoutAndLogin() {
		try {
			launchpadPage.clickLogout();
		} catch (NoSuchElementException e) {
			launchpadHome.clickLogOut();
		} finally {
			driver.close();
		}
	}

	public void getTheCourseURL() {
		courseUrlIns = launchpadPage.getCourseUrl();
	}

	public void logout() {
		try {
			launchpadPage.clickLogout();
		} catch (NoSuchElementException e) {
			launchpadHome.clickLogOut();
		} finally {
			driver.close();
		}
	}


	public boolean logOutAsInstructorAndAgainBrowseTheCopiedURL(String browser) {
		logoutAndLogin();
		System.out.println("Course URL to be launched: " + courseUrlIns);
		startBrowser(courseUrlIns, browser);
		String currentTitle = currentTitle();
		return currentTitle.equalsIgnoreCase("Index");
	}

	public boolean logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(String browser) {
		logoutAndLogin();
		System.out.println("Course URL to be launched: " + courseUrlStu);
		startBrowser(courseUrlStu, browser);
		initPages(driver);
		String currentTitle = currentTitle();
		return currentTitle.equalsIgnoreCase("Index");
	}

	public boolean logOutAsStudentAndAgainBrowseTheCopiedURLForInstructor(String browser) {
		logoutAndLogin();
		System.out.println("Course URL to be launched: " + courseUrlStu);
		startBrowser(courseUrlStu.toString(), browser);
		String currentTitle = currentTitle();
		return currentTitle.equalsIgnoreCase("Index");
	}

	public void clickOnActivateCourseLink() {
		launchpadPage.clickActivateCourse();
	}

	public boolean validateActivateCoursePopUpIsDisplayedWithHeading(String heading) {
		return launchpadPage.activateCoursePopUpAppears(heading);
	}

	public void clickActivateButton() {
		launchpadPage.clickActivateCourseButton();
	}

	public boolean validateCourseSuccessfullyUpdatedPopUpIsDisplayedWithHeading(String heading) {
		return launchpadPage.courseActivatedSuccessPopUpAppears(heading);
	}

	public void clickDoneButton() {
		launchpadPage.clickDoneButton();
	}

	public boolean validateDeactivateLinkIsDisplayedOnceCourseActivates(String linkText) {
		return launchpadPage.deactivateLinkAppears(linkText);
	}

	public void clickOnAnyCourseAppearingInTheMyCoursePage() {
		launchpadPage.clickFirstTitle();
		//return welcomePage.welcomeHeadingContains("Welcome to");
	}

	public void clickOnCourseTitleFromMyCoursesDashboard() {
		launchpadPage.clickFirstTitle();
	}

	public boolean findTheInstructorCreatedCourseAndClickOnDeactivateLink(String text) {
		launchpadPage.clickDeactivateLink();
		return launchpadPage.deactivateCourseDialogAppears(text);
	}

	public boolean instructorClickOnDeactivateButton() {
		launchpadPage.clickDeactivateDialogButton();
		return launchpadPage.actiavteCourseLinkAppears();
	}

	public boolean onMyCoursePageClickOnDeleteLinkForCreatedCourse(String text) {
		launchpadPage.deleteTopCourse();
		return launchpadPage.deleteOverlayAppears(text);
	}

	public boolean instructorClickOnDeleteButton() {
		launchpadPage.clickDeleteButton();
		return launchpadPage.verifyCourseIsDeleted();
	}

	public boolean instructorAgainClicksDeleteLinkForAnyCourse(String text) {
		launchpadPage.deleteFirstAvailableCourse();
		return launchpadPage.deleteOverlayAppears(text);
	}

	public boolean instructorClickOnCancelButton() {
		launchpadPage.clickCanelButton();
		return launchpadPage.verifyCourseIsNotDeleted();
	}

	public boolean validateContinueConfirmationMessageIsDisplayed(String messgae) {
		return joinPage.validateCourseGreeting(messgae);
	}

	public void clickJoinCourse() {
		joinPage.clickJoinButton();
	}

	public boolean clickOnTheJoinCourse(String message) {
		boolean messageDisplayed;
		joinPage.clickJoinButton();
		messageDisplayed = confirmationPage.validateConfirmationMessage(message);
		confirmationPage.clickCourseLink();
		return messageDisplayed;
	}

	public boolean validateSelectedTopicIsDisplayed() {
		return topicPage.getPageTitle();
	}

	public void navigateBackToHomePage() {
		topicPage.clickHomePageLink();
	}

	public boolean validateWelcomePageIsDisplayed(String arg1) {
		//return welcomePage.welcomeHeadingContains(arg1);
		return true;
	}

	public void clickEnterCourseLink() {
		welcomePage.clickEnterCourseLink();
	}

	public boolean clickEnterCourse() {
		welcomePage.clickEnterCourseLink();
		return launchpadHome.isLaunchPadMenuDisplayed();
	}

	public boolean verifyViewInstructorConsole() {
		launchpadHome.viewInstructorConsole();
		fandEPageUi.editConsoleLinkOnHomePageAndSelect();
		//welcomePage.clickHomeButton();
		//fandEPageUi.editConsoleLinkOnHomePageAndDeselect();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean verifyEditPageToRemoveWidget() {
		welcomePage.editPageLink();
		welcomePage.editPageToRemoveWidget();
		welcomePage.doneEditing();
		return welcomePage.verifyInstructorAtWelcomePage();
	}

	public boolean verifyEditPageToAddWidget() {
		welcomePage.editPageLink();
		welcomePage.editPageToAddWidget();
		welcomePage.doneEditing();
		return welcomePage.verifyInstructorAtWelcomePage();
	}

	public boolean dragAndDropWidget() {
		welcomePage.editPageLink();
		welcomePage.dragAndDropWidget();
		welcomePage.doneEditing();
		return welcomePage.verifyInstructorAtWelcomePage();
	}

	public boolean intructorVerifyNavigationSettings() {
		launchpadHome.settings();
		fandEPageUi.navigationSettings();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean verifyWelcomeScreenIsNotAvailable(String courseName) {
		launchpadHome.navigateBackToMyCoursesPage();
		enterIntoCourseByCourseName(courseName);
		return launchpadHome.verifyInstructorIsAtHomePage();
	}
	
	public boolean verifyWelcomeScreenIsAvailable(String courseName) {
		launchpadHome.navigateBackToMyCoursesPage();
		enterIntoCourseByCourseName(courseName);
		welcomePage.clickEnterCourseLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean renameCourse(String courseTitle) {
		welcomePage.courseEditLink();
		welcomePage.changeCourseTitle(courseTitle);
		welcomePage.doneEditing();
		return welcomePage.verifyInstructorAtWelcomePage();
	}

	public boolean verifyResources() {
		launchpadHome.resource();
		launchpadHome.verifyContentAndAssignmentOption();
		launchpadHome.clickResourceCloseButton();
		launchpadHome.viewInstructorConsole();
		welcomePage.clickHomeButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public void verifyEditPageToAddRssfeed() {
		welcomePage.addRSSFeedArticles();
		welcomePage.doneEditing();
	}

	public boolean verifyInstructorEditGeneralPageSettings(String title, String courseNumber, String sectionNumber, String instructorName, String officeHours) {
		launchpadHome.settings();
		fandEPageUi.editGeneralSettings(title, courseNumber, sectionNumber, instructorName, officeHours);
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean insertAndEditImage() {
		welcomePage.courseEditLink();
		welcomePage.readyToPerformActionOnImage();
		fandEPageUi.addImage();
		welcomePage.insertImage();
		welcomePage.doneEditing();
		return welcomePage.verifyInstructorAtWelcomePage();
	}

	public boolean changeImageAddedByInstructor() {
		welcomePage.courseEditLink();
		welcomePage.readyToPerformActionOnImage();
		fandEPageUi.changeTheAddedImage();
		welcomePage.insertImage();
		welcomePage.doneEditing();
		return welcomePage.verifyInstructorAtWelcomePage();
	}


	public boolean enterTextIntoTinyEditor() {
		welcomePage.clickEnterCourseLink();
		welcomePage.assignmentCreation();
		welcomePage.quizEditing();
		welcomePage.doneQuizEditing();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean verifyInsertEditLink() {
		welcomePage.courseEditLink();
		welcomePage.insertEditLink();
		welcomePage.addLink();
		welcomePage.doneEditing();
		return welcomePage.verifyAddedLink();
	}

	public boolean instructorBrowseResourceContents() {
		launchpadHome.resource();
		launchpadHome.verifyQuestionsOption();
		launchpadHome.verifyContentAndAssignmentOption();
		launchpadHome.contentsIHaveCreated();
		launchpadHome.clickResourceCloseButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorBrowseAvailableResourceContents() {
		launchpadHome.resource();
		launchpadHome.verifyContentAndAssignmentOption();
		launchpadHome.contentByType();
		launchpadHome.clickOnBreadcrumbResource();
		launchpadHome.contentByChapter();
		launchpadHome.clickOnBreadcrumbResource();
		launchpadHome.contentsIHaveCreated();
		launchpadHome.clickOnBreadcrumbResource();
		launchpadHome.removedContent();
		launchpadHome.clickOnBreadcrumbResource();
		launchpadHome.clickResourceCloseButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorBrowseQuestionsSection() {
		launchpadHome.resource();
		launchpadHome.verifyQuestionsOption();
		launchpadHome.questionByChapter();
		launchpadHome.clickResourceCloseButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	/**
	 * *******************************************************************************************************
	 */
	public void instructorAddRemoveLaunchpadUnits() {
		welcomePage.clickSettingsButton();
		welcomePage.clickLaunchpadButton();
		welcomePage.removeUnitsFromCourse();
		welcomePage.confirmRemovalOfItem();
	}

	public boolean instructorSelectAssignedAndUnassignedItems(String days, String catName) {
		welcomePage.checkSortByDueDate();
		welcomePage.checkCollapsePastDueDefault();
		welcomePage.checkOnCollapsePastDueMoreThan(days);
		welcomePage.clickCollapseUnassigned(catName);
		welcomePage.clickSaveButton();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	/**
	 * *******************************************************************************************************
	 */
	public boolean assignAndUseResource(String assign, String points) {
		launchpadHome.resource();
		launchpadHome.searchBox(assign);
		fandEPageUi.clickAssignButton();
		launchpadHome.setDateTimeField();
		launchpadHome.setPoints(points);
		welcomePage.clickAssignAgain();
		fandEPageUi.clickDoneEditing();
		//        launchpadHome.unassignedIt();
		//        welcomePage.clickDoneEditingButton();
		welcomePage.clickHomeButton();
		launchpadHome.clickResourceCloseButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean filterOption(String assign) {
		launchpadHome.resource();
		launchpadHome.questionsAtResourceOverlay(assign);
		launchpadHome.clickResourceCloseButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorAddContentItemAfterBrowsingResources() {
		launchpadHome.resource();
		launchpadHome.contentByType();
		welcomePage.clickOnContentByTypeInUse();
		welcomePage.verifyUseInElements();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorBrowseRemovedContents() {
		launchpadHome.resource();
		launchpadHome.removedContent();
		launchpadHome.clickOnBreadcrumbResource();
		launchpadHome.clickResourceCloseButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorCanCopyContents(String copy) {
		launchpadHome.resource();
		launchpadHome.contentByChapter();
		launchpadHome.clickOnContentByTypeInUse();
		launchpadHome.verifyUseInElements();
		launchpadHome.addCopyToCurrentUnit(copy);
		launchpadHome.clickOnBreadcrumbResource();
		launchpadHome.clickResourceCloseButton();
		//welcomePage.verifyCopyAddedToCurrentUnit();
		launchpadHome.clickResourceCloseButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorCanMoveContents() {
		launchpadHome.resource();
		launchpadHome.contentByChapter();
		launchpadHome.clickOnContentByTypeInUse();
		launchpadHome.verifyUseInElements();
		welcomePage.moveToCurrentUnit();
		launchpadHome.clickOnBreadcrumbResource();
		launchpadHome.clickResourceCloseButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorCanRemoveContents() {
		launchpadHome.resource();
		launchpadHome.contentByChapter();
		launchpadHome.clickOnContentByTypeInUse();
		launchpadHome.verifyUseInElements();
		launchpadHome.removeFromThisUnit();
		launchpadHome.clickOnBreadcrumbResource();
		launchpadHome.clickResourceCloseButton();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorAddContentItemUsingContentByType() {
		launchpadHome.verifyInstructorIsAtHomePage();
		launchpadHome.clickOnFirstUnassignedChapterAndReturnChapterName();
		launchpadHome.hoverOverFirstUnassignedContent();
		launchpadHome.clickGearDisplayedForContent();
		launchpadHome.removeLinkButtonFromGearIconAtHomePage();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public void checkOnSortByDueDate() {
		welcomePage.checkSortByDueDate();
	}

	//	public void checkOnCollapsePastDueDefault() {
	//		welcomePage.checkCollapsePastDueDefault();
	//	}

	//	public void checkOnCollapsePastDueMoreThan(String days) {
	//		welcomePage.checkOnCollapsePastDueMoreThan(days);
	//	}

	//	public void clickOnCollapseUnassigned(String catName) {
	//		welcomePage.clickCollapseUnassigned(catName);
	//	}

	public boolean clickOnReturnToWindowButton() {
		return welcomePage.clickReturnToWindowButton();
	}

	public boolean clickOnCalendarIcon() {
		welcomePage.clickCalendarIcon();
		welcomePage.clickListIcon();
		return welcomePage.clickEditPage();
	}

	public void clickHereToEdit() {
		welcomePage.courseEditLink();
	}

	//	public boolean validateUserIsOnLaunchPadHomePage() {
	//		return launchpadHome.isLaunchPadMenuDisplayed();
	//	}
	//
	//	public void clickOnFirstChapter() {
	//		launchpadHome.clickOnFirstUnassignedChapterAndReturnChapterName();
	//	}

	//	public void clickOnFirstUnitAndThenNavigateToFirstSubTopic() {
	//		launchpadHome.clickFirstUnassignedChapterFirstUnit();
	//		launchpadHome.clickFirstUnassignedChapterFirstUnitFirstTopic();
	//	}

	public boolean clickOnTheActivateYourCourseLinkFromTheRightHandWidget() {
		launchpadHome.clickActivateCourse();
		return launchpadHome.activateCoursePopUpAppears("Activate this course?");
	}

	public boolean confirmDetailsAndClickOnSubmit() {
		launchpadHome.clickActivateCourseButton();
		return (launchpadHome.courseActivatedSuccessPopUpAppears("Activated! You're all set.") || launchpadHome.courseActivatedSuccessPopUpAppears("Course Activated!"));
	}

	public boolean clickOnOkButton() {
		launchpadHome.clickDoneButton();
		return !launchpadHome.activateCourseLinkAppears();
	}

	public boolean chooseViewMyCourseOptionFromTheDropdownPresentOnTheRightHandSideOfTheHomePage() {
		launchpadHome.navigateBackToMyCoursesPage();
		return launchpadPage.getHeading("My Courses");
	}

	public void copyTheActivatedURLForTheCourse() {
		courseUrlStu = launchpadHome.getCourseUrl();
	}

	public void copyTheActivatedURLForTheCourseNC() {
		courseUrlStu = launchpadHome.getCourseUrlNC();
	}

	public boolean clickOnRosterNGroupsButtonPresentInsideInstructorConsoleWidget() {
		launchpadHome.clickRosterAndGroupButton();
		return fandEPageUi.isHeaderDisplayed() && (fandEPageUi.isStudentTableDisplayed() || fandEPageUi.verifyStudentTableHeading()) && fandEPageUi.createGroupLinkPresent();
	}

	public void navigateBackToTopicPage() {
		fandEPageUi.clickHomePageLink();
	}

	public boolean clickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage() {
		launchpadHome.clickSettingsButton();
		return fandEPageUi.editTimeZoneIsDisplayedOnFnEPage();
	}

	public void changeTheTimeZoneAndClickSave(String timeZone) {
		fandEPageUi.selectTimeZone(timeZone);
		fandEPageUi.submitFneForm();
		//fandEPageUi.clickHomePageLink();
	}

	public void fromTOCClickOnAnyChapter() {
		launchpadHome.clickOnFirstUnassignedChapterAndReturnChapterName();
	}

	public void fromTOCClickOnAnyChapter(String Chapter) {
		launchpadHome.clickOnFirstUnassignedChapterAndReturnChapterName(Chapter);
	}

	public void assignAnyUnitsItemWithDueDate(String date, String time) {
		hoversOverAContentItemAndClicksTheGear();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		date = DateUtil.getDate(date);
		chapterClickedToBeAssigned.setLength(0);
		//chapterClickedToBeAssigned.append(launchpadHome.clickAssignButtonForFirstUnassignedChapterFirstUnitAndReturnItsName());
		//chapterClickedToBeAssigned=launchpadHome.clickAssignButtonForFirstUnassignedChapterFirstUnitAndReturnItsName();
		assignContent(date, time,"5");
	}

	public void assignAnotherContentWithinSameChapterWithDueDate(String date, String time) {
		date = DateUtil.getDate(date);
		nextChapterClickedToBeAssigned = launchpadHome.hoverOverNextContentOfPreviouslyAssignedContentOpenAssignWindowAndReturnContentName();
		assignContent(date, time, "5");
	}

	public boolean verifyDateRangeIsDisplayed(String startDate, String dueDate, String dueTime, String timeZoneExpected) {
		startDate = DateUtil.getDate(startDate);
		dueDate = DateUtil.getDate(dueDate);
		return launchpadHome.hoverOverDateIconAndRetunIsDateRangeDisplayedForUnit(startDate, dueDate, dueTime, timeZoneExpected);
	}

	public boolean hoverOverTheDueDateIconAppearingAdjacentToContentItem(String assign, String date, String time, String timeZone) {
		date = DateUtil.getDate(date);
		if (assign.equalsIgnoreCase("FirstAssign")) {
			return launchpadHome.hoverOverDateIconAndRetunIsDateDisplayed(chapterClickedToBeAssigned.toString(), date, time, timeZone);
		} else {
			return launchpadHome.hoverOverDateIconAndRetunIsDateDisplayed(nextChapterClickedToBeAssigned, date, time, timeZone);
		}
	}

	public boolean clickAssignedCourseAndHoverOverTheDueDateIconAppearingAdjacentToContentItem(String assign, String date, String time, String timeZone) {
		launchpadHome.studentClickAssignedChapterAndSeeContentAvailable(chapterClickedToBeAssigned.toString());
		date = DateUtil.getDate(date);
		if (assign.equalsIgnoreCase("FirstAssign")) {
			return launchpadHome.hoverOverDateIconAndRetunIsDateDisplayed(chapterClickedToBeAssigned.toString(), date, time, timeZone);
		} else {
			return launchpadHome.hoverOverDateIconAndRetunIsDateDisplayed(nextChapterClickedToBeAssigned, date, time, timeZone);
		}
	}

	public boolean clickOnTheAddLinkAppearingAtTheTop() {
		launchpadHome.addNewItem();
		return launchpadHome.createNewItemAndBrowseItemOptionsDisplayed();
	}

	public boolean selectTheCreateNewOption() {
		launchpadHome.createNewItem();
		return launchpadHome.variousCreateOptionsDisplayed();
	}

	public boolean selectLearningCurveActivity() {
		launchpadHome.addNewLearningCurve();
		return fandEPageUi.createElementOptionsDisplayed();
	}

	public boolean clickOnTheLearningCurveActivity() {
		launchpadHome.clickLearningCurveOption();
		return fandEPageUi.isLearningCurveDisplayed("TestLearningCurve");
	}

	public boolean openTheResourcesOverlay(String user) {
		launchpadHome.clickResourceButton();
		return launchpadHome.resourcesOverlayButtonsDispalyed(user);
	}

	public boolean openTheResourcesOverlayWhenSearchIsEmpty(String user){
		launchpadHome.clickResourceButton();
		return launchpadHome.resourcesOverlayButtonsDispalyedWhenSearchIsEmpty(user);
	}

	public boolean enterLearningObjectiveInTheSearchField(String term) {
		launchpadHome.enterSearchTermForResourceOverlay(term);
		return launchpadHome.isRelevantSearchTermDisplayed(term);
	}

	public boolean userTypesASearchTermIntoTheSearchFieldAndPressesEnter(String term, String user) {
		launchpadHome.enterSearchTermForResourceOverlay(term);
		if (user.equalsIgnoreCase("Instructor")) {
			return launchpadHome.isRelevantSearchTermDisplayed(term) && launchpadHome.resourceSearchDialogOptionDisplayedForInstructor();
		} else if (user.equalsIgnoreCase("Student")) {
			return launchpadHome.isRelevantSearchTermDisplayed(term) && launchpadHome.resourceSearchDialogOptionDisplayedForStudnet();
		} else {
			return launchpadHome.isRelevantSearchTermDisplayed(term);
		}
	}

	public boolean clickOnTheQuestions() {
		launchpadHome.clickQuestionsTab();
		return launchpadHome.questionsListDisplayed();
	}

	public void clickOnContentItem() {
		launchpadHome.clickChapterIntroduction();
	}

	public boolean clickOnTheImagesOrFigureAppearingInFnEWindow() {
		fandEPageUi.clickImageOnFnEpage();
		return fandEPageUi.verifyImageIsDiplayedInNewWindow();
	}

	public void closeDriverAndSwitchToMainWindow() {
		fandEPageUi.mainWindow();
	}

	public void userNavigatedToAnEBookHavingCrossReferences() {
		launchpadHome.clickPartIntroduction();
	}

	public boolean expandAnyChapterAndNavigateToFnEWindowOfAnyContentItem() {
		fromTOCClickOnAnyChapter("1.");
		System.out.println("Control passed to line :-949");
		clickedContent = launchpadHome.clickOnFirstUnassignedChapterSubtopicAndReturnChapterName();
		return fandEPageUi.isHeaderDisplayed();
	}

	public boolean fromTocClickOnChapterThenItsContent(){
		launchpadHome.fromTOCClickOnAnyChapterRandomly();
		clickedContent = launchpadHome.clickOnFirstUnassignedChapterSubtopicAndReturnChapterName();
		return fandEPageUi.isHeaderDisplayed();
	}

	public boolean verifyTheEditedTitleOfContentItem() {
		return launchpadHome.verifyTitleChanged("Title Changed");
	}

	public boolean selectQuizActivity() {
		launchpadHome.addNewQuiz();
		return fandEPageUi.createElementOptionsDisplayed();
	}

	public boolean selectDiscussionBoardActivity() {
		launchpadHome.addNewDiscussionBoard();
		return fandEPageUi.createElementOptionsDisplayed();
	}

	public boolean selectDocumentCollectionActivity() {
		launchpadHome.addNewDocumentCollection();
		return fandEPageUi.createElementOptionsDisplayed();
	}

	public boolean selectHomeWorkActivity() {
		launchpadHome.addNewHomeWork();
		return fandEPageUi.createElementOptionsDisplayed();
	}

	public boolean selectHtmlPageActivity() {
		launchpadHome.addNewHtmlPage();
		return fandEPageUi.createElementOptionsDisplayed();
	}

	public boolean selectDropBoxActivity() {
		launchpadHome.addNewDropBox();
		return fandEPageUi.createElementOptionsDisplayed();
	}

	public void clickResourceBreadcrumb(){
		launchpadHome.clickOnBreadcrumbResource();
	}

	public boolean selectUnitActivity() {
		launchpadHome.addNewUnit();
		return fandEPageUi.elementTitleDisplayed() && launchpadHome.createNewUnitDefaultImageDisplayed();
	}

	public boolean selectLinkCollectionActivity() {
		launchpadHome.addNewLinkCollection();
		return fandEPageUi.createElementOptionsDisplayed();
	}

	public boolean selectLinkActivity() {
		launchpadHome.addNewLink();
		return fandEPageUi.createElementOptionsDisplayed();
	}

	public boolean gotoResourcesContentByChapter() {
		launchpadHome.clickResourceButton();
		launchpadHome.clickResourceContentByChapterOption();
		return launchpadHome.contentByChapterDiplayedInOrder();
	}

	public void clickOnResourceCloseButton(){
		launchpadHome.clickResourceCloseButton();
	}

	public boolean provideATitleAndClickOnSave(String title) {
		fandEPageUi.enterNewElementTitle(title);
		fandEPageUi.clickSaveButtonForNewElement();
		return fandEPageUi.messageFlyerDisplayed("Item has been added to .*");
	}

	public boolean provideATitleAndClickOnSaveFnE(String title) {
		fandEPageUi.enterNewElementTitle(title);
		fandEPageUi.clickSaveButtonForNewElement();
		//fandEPageUi.forQuestioDisplay();
		return fandEPageUi.messageFlyerDisplayed("Item was saved");
	}

	public boolean clickOnTheAddToThisUnitDropDown() {
		launchpadHome.clickOnAddLinkForFirstUnassignedChapter();
		return launchpadHome.createNewItemAndBrowseItemOptionsDisplayed();
	}

	public boolean selectFolderActivity() {
		return selectUnitActivity();
	}

	public void hoverOnChapter() {
		hoveredChapter = launchpadHome.hoverOverFirstUnassignedChapterAndReturnChapterName();
	}

	public void clickOnTheGearMenuIcon() {
		launchpadHome.gearDisplayedForChapter();
	}

	public void selectEditLinkForChapter() {
		launchpadHome.clickEditLinkForChapterOnGearManagementCard();
	}

	public void selectEditLinkForContent() {
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
	}

	public boolean makeChangesWithTheTitleForChapterAndClickSave(String title) {
		launchpadHome.editTitleOfUnitOrFolder(title);
		fandEPageUi.clickSaveButtonForNewElement();
		return launchpadHome.createdItemDisplayed(title);
	}

	public boolean makeChangesWithTheTitleForContentAndClickSave(String title) {
		fandEPageUi.enterNewElementTitle(title);
		fandEPageUi.clickSaveButtonForNewElement();
		return fandEPageUi.messageFlyerDisplayed("Item was saved");
	}

	public void hoverOnTheContentItemAndClickOnTheGearMenuIcon() {
		fromTOCClickOnAnyChapter();
		launchpadHome.hoverOverFirstUnassignedContent();
		launchpadHome.clickGearDisplayedForContent();
	}

	public boolean verifyLastViewedIndicatorIsReflectingPreviousAccessedItem() {
		return launchpadHome.lastViewedItemIsIndicated(clickedContent);
	}

	public boolean clickOnAnyChapter() {
		return launchpadHome.clickOnFirstUnassignedChapterAndReturnClassAttribute().contains("nodeExpanded");
	}

	public boolean clickOnAnyOtherChapter() {
		return launchpadHome.clickOnSecondUnassignedChapterAndReturnClassAttribute().contains("nodeExpanded") && !launchpadHome.returnFirstUnassignedChapterClassAttribute().contains("nodeExpanded");
	}

	public boolean inTheManagementCardClickOnButtonToHideContent(String hideOption) {
		if (hideOption.equalsIgnoreCase("Yes")) {
			return launchpadHome.clickYesToHideContentFromStudent();
		} else if (hideOption.equalsIgnoreCase("No")) {
			return launchpadHome.clickNoToHideContentFromStudent();
		}
		return false;
	}

	public boolean studentObservesAtTheHomePageContentIs(String visibility) {
		if (visibility.equalsIgnoreCase("Hidden")) {
			return !launchpadHome.createdItemDisplayedFullTitle(hoveredChapter);
		} else {
			return launchpadHome.createdItemDisplayedFullTitle(hoveredChapter);
		}
	}

	public void createAQuizAndAssignItToStudents() {
		createAQuizWithQuestions("TestQuizTc001579", 2);
		launchpadHome.hoverOverLastCreatedContent();
		//launchpadHome.clickGearDisplayedForContent();
		launchpadHome.clickOnFirstUserCreatedAssignment();
		assignContent("4:00 PM", "10");
	}

	public void createAQuizAndAssignItToStudents(String time, String timeZone) {
		createAQuizWithQuestions("TestQuizTc001268", 2);
		launchpadHome.hoverOverContentByContentName("TestQuizTc001268");
		launchpadHome.clickOnFirstUserCreatedAssignmentButton();
		//launchpadHome.clickGearDisplayedForContent();
		assignContent(DateUtil.getDate(), DateUtil.getTimeAsPerTimeZone(time, timeZone), "10");
	}

	public boolean openTheQuizLinkFromTheHomePageAndClickResults() {
		launchpadHome.openContentByContentNameCreated();
		// launchpadHome.openContentByContentName("TestQuizTc001579");
		// launchpadHome.openContentByContentNameAppendTime("TestQuizTc001579");
		fandEPageUi.clickResultsOnFneHeader();
		return fandEPageUi.studentSummaryDisplayedOnResultList();
	}

	public void createAQuizWithQuestions(String quizTitle, int noOfQues) {
		clickOnTheAddLinkAppearingAtTheTop();
		selectTheCreateNewOption();
		selectQuizActivity();
		provideATitleAndClickOnSaveFnE(quizTitle);
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public void assignContent(String time, String points) {
		if (launchpadHome.isAssignDateWindowDisplayed()) {
			launchpadHome.enterDueDate(DateUtil.fixedDate());
			launchpadHome.enterGradeBookFieldSetValues(points);
			launchpadHome.enterDueTime(time);	
			launchpadHome.clickSubmitButtonOnAssignForm();
		}
	}

	public void assignContent(String date, String time, String points) {
		launchpadHome.isAssignDateWindowDisplayed();
		launchpadHome.enterDueDate(date);
		launchpadHome.enterDueTime(time);
		launchpadHome.enterGradeBookFieldSetValues(points);
		launchpadHome.clickSubmitButtonOnAssignForm();

	}

	public boolean studentAttemptTheCreatedQuiz() {
		launchpadHome.openContentByContentNameCreated();
		fandEPageUi.clickStartQuiz();
		fandEPageUi.studentAnswersQuiz();
		fandEPageUi.studentSubmitsQuiz();
		return fandEPageUi.gradeTableIsDisplayedForStudent();
	}

	public boolean studentAttemptTheCreatedQuizVerifyQuizExpiredDisplayed(String message) {
		launchpadHome.openContentByContentNameCreated();
		return fandEPageUi.deafaultExpireMessageIsDisplayed(message);
	}

	public void createADropboxAndAssignItToStudents() {
		clickOnTheAddLinkAppearingAtTheTop();
		selectTheCreateNewOption();
		selectDropBoxActivity();
		provideATitleAndClickOnSaveFnE("TestDropbox");
		//fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		//launchpadHome.hoverOverLastCreatedContent();
		//launchpadHome.hoverOverContentByContentName("TestDropbox");
		//launchpadHome.clickGearDisplayedForContent();
		//assignContent("4:00 PM", "10");
		fandEPageUi.assignContent1("4:00 PM", "10");
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();

	}

	public void clickDropboxCreatedAboveAndSubmitAValidFile() {
		previousHitCount = launchpadHome.greeTickMarkHitCount();
		launchpadHome.openContentByContentNameCreated();
		fandEPageUi.clickUploadButtonForDropBox();
		fandEPageUi.enterDescriptionInDropboxTinyMceAndSubmit();
	}

	public void enterDropboxCreated() {
		launchpadHome.openContentByContentNameCreated();
	}

	public boolean clickOnTheAssignedContentItem(String assign, String date, String time) {
		if (assign.equalsIgnoreCase("FirstAssign")) //launchpadHome.openContentByContentName(chapterClickedToBeAssigned);
		{
			launchpadHome.openContentByContentName(chapterClickedToBeAssigned.toString());
		} else {
			launchpadHome.openContentByContentName(nextChapterClickedToBeAssigned);
		}
		date = DateUtil.getDateForFne(date);
		return fandEPageUi.dateInfoMatched(date, time);
	}

	public void moveBackToTheTOCAndClickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage() {
		fandEPageUi.clickHomePageLink();
		clickOnTheSettingsButtonAppearingInWidgetAtRightHandOfHomePage();
	}

	public void hoverOverAnyAssignedContentChapter() {
		launchpadHome.hoverOverExpandedAssignContentAndClickOnGearIconDisplayed();
	}

	public boolean instructorClickOnUnassignButton() {
		return launchpadHome.unassignTheAssignedContent();
	}

	public void hoversOverAContentItemAndClicksTheGear() {
		firstUnassignedContentName = launchpadHome.getFirstUnassignedContentTitle();
		launchpadHome.hoverOverFirstUnassignedContent();
		launchpadHome.clickGearDisplayedForContent();
	}

	public boolean clickOnTheMoveOrCopy() {
		launchpadHome.clickMoveOrCopy();
		return launchpadHome.moveOrCopyWidgetDisplayed();
	}

	public boolean instructorChoosesAUnitOrFolderAndClickMove() {
		//launchpadHome.insructorChoosesAItemWhereToMove();
		launchpadHome.instructorSelectsMoveButton();
		return launchpadHome.isItemMoved(firstUnassignedContentName);
	}

	public boolean instructorChoosesAUnitOrFolderAndClickCopy() {
		launchpadHome.insructorChoosesAItemWhereToCopy();
		launchpadHome.instructorSelectsCopyButton();
		return launchpadHome.copyContentTitleWindowDisplayed();
	}

	public void instructorRenameTheItemAndClickSave() {
		launchpadHome.enterCopiedContentNameAndClickSaveAndReturnIsContentDisplayed();
	}

	public void clickOnTheShowAssignmentCalender() {
	}

	public boolean clickOnGradebookButtonPresentInsideInstructorConsoleWidget() {
		launchpadHome.clickGradebookButton();
		return fandEPageUi.instructorConsoleGradebook();
	}

	public boolean clickOnGradebookButtonPresentInsideStudentConsoleWidget() {
		launchpadHome.clickGradebookButton();
		return fandEPageUi.studentConsoleGradebook();
	}

	public boolean checkIsscoreColumnEmpty() {
		checkBoolean1 = fandEPageUi.isScoreEmpty();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;

	}

	public boolean confirmToRemovalOfItem() {
		return launchpadHome.confirmRemovalOfItem();
	}

	public boolean areUnitsRemoved() {
		return launchpadHome.areunitsremoved();
	}

	public boolean addUnits() {
		return launchpadHome.addunits();
	}

	public boolean confirmAdditionOfItem() {
		return launchpadHome.confirmadditionofitem();
	}

	public void addQuestionsInTheQuizForSinglePage(int noOfQues, String points) {
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.editQuizSettingsForSinglePage();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		fandEPageUi.hoverOverContentByContentNameSecond("TestQuiz");
		launchpadHome.clickGearDisplayedForContent();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		launchpadHome.clickDoneAssigningButton();	
	}

	public void addQuestionsInTheQuizForSeparatePages(int noOfQues, String points) {
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.editQuizSettingsForSeparatePages();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		fandEPageUi.hoverOverContentByContentNameSecond("TestQuiz");
		launchpadHome.clickGearDisplayedForContent();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		launchpadHome.clickDoneAssigningButton();
	}

	public boolean clickOnTheViewInstructorConsoleForBatchDueDateUpdater() {
		launchpadHome.clickOnViewInstructorConsoleForBatchDueDateUpdater();
		return launchpadHome.confirmadditionofitem();
	}

	public boolean clickOnTheViewInstructorConsoleForGradebookPreferences() {
		launchpadHome.clickOnViewInstructorConsoleForGradebookPreferences();
		return fandEPageUi.instructorConsoleGradebook();
	}

	public boolean changeThePassingScore(String passscore) {
		fandEPageUi.changePassingScore(passscore);
		return fandEPageUi.ispassingscorechanged();
	}

	public boolean useTheWeightedCategories() {
		fandEPageUi.useWeightedCategories();
		return fandEPageUi.instructorConsoleGradebook();
	}

	public void assignFromTheAssignmentTab(String contentName) {
		fandEPageUi.assignFromAssignmentTab(contentName);
	}

	public boolean clickViewhideAssignments() {
		fandEPageUi.clickToViewhideAssignments();
		return fandEPageUi.instructorConsoleGradebook();
	}

	public boolean isScoreSubmittedDueVisible() {
		fandEPageUi.scoreSubmittedDueVisible();
		checkBoolean1 = fandEPageUi.studentConsoleGradebook();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public boolean rearrangeTheCategoriesNumerically() {
		fandEPageUi.rearrangeCategoriesNumerically();
		return fandEPageUi.instructorConsoleGradebook();
	}

	public boolean enterTheDropLowestValue() {
		fandEPageUi.enterDropLowestValue();
		checkBoolean1 = fandEPageUi.isdroplowestchanged();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public boolean rearrangeTheAssignmentsUnderCategoriesNumerically() {
		fandEPageUi.rearrangeAssignmentsUnderCategoriesNumerically();
		return fandEPageUi.instructorConsoleGradebook();
	}

	public void addTheNewCategoryFromHomepage1(String points, String category) {
		launchpadHome.addnewcategoryfromhomepage1(points, category);
	}

	public void addTheNewCategoryFromHomepage2(String points, String category) {
		launchpadHome.addnewcategoryfromhomepage2(points, category);
	}

	public void addTheNewCategoryFromHomepage3(String points, String category) {
		launchpadHome.addnewcategoryfromhomepage3(points, category);
	}

	public void pointsUpto2DecimalPlaces(int noOfQues,String points) {
		fandEPageUi.addquestionfromedittab();
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.clickOnAssignmentTab();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.settingsTabLink();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public void addTheQuestionFromEditTab(int noOfQues,String points) {
		fandEPageUi.addquestionfromedittab();
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.clickOnAssignmentTab();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.settingsTabLink();
		fandEPageUi.provideTimeLimitInSettingsTab();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public boolean isTimerVisible() {
		return fandEPageUi.timerVisible();
	}

	public boolean instructorViewsTheQuizResults() {
		checkBoolean1 = fandEPageUi.instructorViewsQuizResults();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public void studentSaveQuiz(int noOfQues,String points) {
		fandEPageUi.addquestionfromedittab();
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.clickOnAssignmentTab();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.settingsTabLink();
		fandEPageUi.checksaveandcontinuebox();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public void studentSubmitQuiz(int noOfQues,String points) {
		fandEPageUi.addquestionfromedittab();
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.clickOnAssignmentTab();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.settingsTabLink();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public void quizIsAutoSubmittedOncePeriodExpires(int noOfQues,String points) {
		fandEPageUi.addquestionfromedittab();
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.clickOnAssignmentTab();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.settingsTabLink();
		fandEPageUi.autoSubmitQuiz();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public boolean previewQuizInStudentView() {
		launchpadHome.studentView();
		//		fandEPageUi.studentAttemptsQuiz();
		//		fandEPageUi.studentAnswersQuiz();
		//		fandEPageUi.studentSubmitsQuiz();
		//checkBoolean1 = fandEPageUi.studentCloseQuiz();
		checkBoolean2 = fandEPageUi.cancelStudentView();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean2 ;
	}

	public boolean printQuizAsItAppearsToStudent(int noOfQues,String points) {
		fandEPageUi.addquestionfromedittab();
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.clickOnAssignmentTab();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.settingsTabLink();
		fandEPageUi.clickDoneEditing();
		checkBoolean1 = launchpadHome.isQuestionContainerVisible();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public void studentCompleteAllQuestionTogether(String points) {
		fandEPageUi.createMultipleAnswerAndAddFeedback();
		fandEPageUi.editQuizSettingsForSinglePage();
		fandEPageUi.clickOnAssignmentTab();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.settingsTabLink();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public boolean instructorStartedCreatingNewItemHomePage() {
		launchpadHome.addNewItem();
		launchpadHome.createNewItemAndBrowseItemOptionsDisplayed();
		launchpadHome.createNewItem();
		return launchpadHome.variousCreateOptionsDisplayed();
	}

	public void selectRequiredFields() {
		try {
			enrollPage.selectSchool();
			enrollPage.selectTerm();
			enrollPage.selectInstructor();
			enrollPage.selectCourse();
		} catch (Exception e) {
			e.printStackTrace();
			enrollPage.selectSchool();
			enrollPage.selectTerm();
			enrollPage.selectInstructor();
			enrollPage.selectCourse();
		}
	}

	public void enterGroupPrefix(){
		fandEPageUi.enterGroupName("Test");
	}

	public void clickContinueButton() {
		enrollPage.clickContinueButton();
	}

	public boolean clickOnCreateGroupOrGroupSetOption() {
		fandEPageUi.clickCreateGroupLink();
		fandEPageUi.switchToFrame();
		return fandEPageUi.generateGroupFrameOptionsPresent();
	}

	public void enterGroupPrefixAndSelectRadioButtonForNumberOfGroupsAndEnterValueMoreThen1() {
		fandEPageUi.enterGroupName("Test");
		fandEPageUi.enterNoOfGroup(2);
	}

	public void enterGroupPrefixAndSelectApproximateNumberOfStudentsPerGroupAndEnterValueMoreThen1() {
		fandEPageUi.enterGroupName("Test");
		fandEPageUi.enterNoOfStudents(2);
	}

	public void clickOnTheEditOptionOfTheGroupFromWhichTheStudentHasToBeRemoved() {
		fandEPageUi.clickGroupWithOneStudentAndReturnGroupName();
	}

	public boolean clickOnTheGreenCheckSignInTheRowOfTheStudentWhoHasToBeRemoved() {
		return fandEPageUi.studentUnassignedFromGroup();
	}

	public boolean clickOnStudentRadioInTheRowOfTheStudentToAssign() {
		return fandEPageUi.studentAssignedToGroup();
	}

	public boolean userClicksOnShowAnswer() {
		return fandEPageUi.clickShowAnswerAndVerifyAnswerBlockDisplayed();
	}

	public boolean userClicksOnAnyOfTheAnimatedFigure() {
		return fandEPageUi.clickCrunchItAndVerifyCrunchItWindowDisplayed();
	}

	public boolean clickOnOkButtonAndVerifyStudentIsDeleted() {
		fandEPageUi.clickOkButtonOnGroupAssignmentWindow();
		return true;
	}

	public boolean selectNoneOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink() {
		fandEPageUi.selectGroupAssignmentAsNone();
		fandEPageUi.generateGroup();
		return fandEPageUi.verifyGeneratedGroupIsDisplayedOnGroupAssignmentWindow("Test");
	}

	public boolean clickOnOkButtonAfterSpecifyingAllRequiredFields() {
		fandEPageUi.clickOkButtonOnGroupAssignmentWindow();
		fandEPageUi.switchToMainWindow();
		return fandEPageUi.createGroupLinkPresent();
	}

	public boolean clickOnGenerateGroupsAtTopRight() {
		fandEPageUi.clickGenerateGroupLinkOnTopRight();
		return fandEPageUi.generateGroupFrameOptionsPresent();
	}

	public boolean modifyAnyFieldAndClickOnGenerateGroupsLink() {
		fandEPageUi.enterGroupName("TestMod");
		fandEPageUi.generateGroup();
		return fandEPageUi.verifyGeneratedGroupIsDisplayedOnGroupAssignmentWindow("TestMod");
	}

	public boolean selectRandomOptionFromGroupAssignmentSectionAndClickOnGenerateGroupsLink() {
		fandEPageUi.selectGroupAssignmentAsRandom();
		fandEPageUi.generateGroup();
		return fandEPageUi.verifyGeneratedGroupIsDisplayedOnGroupAssignmentWindow("Test");
	}

	public boolean clickOnXIconPresentForAnyColumnAndClickOnYesButtonFromTheConfirmationPopup() {
		fandEPageUi.deleteFirstCreatedGroup();
		return !fandEPageUi.verifyGeneratedGroupIsDisplayedOnGroupAssignmentWindow("Test");
	}

	public boolean clickOnAnyGroupSetNameInGroupSetSection() {
		fandEPageUi.clickFirstGroupNameOnFNEpage();
		return fandEPageUi.verifyGoupSetInfo();
	}

	public void clickOnTheCLONEOptionOfOneOfTheGroupSetsInTheLefthandNavigationPanel() {
		fandEPageUi.clickCloneLinkForFirstGroup();
	}

	public void clickOnTheEditOptionOfOneOfTheGroupSetsInTheLefthandNavigationPanel() {
		fandEPageUi.clickEditLinkForFirstGroup();
	}

	public boolean enterANewGroupSetNameAndClickOK() {
		fandEPageUi.enterCloneGroupName("TestClone ");
		fandEPageUi.clickOkButtonOnGroupAssignmentWindow();
		fandEPageUi.switchToMainWindow();
		return fandEPageUi.createGroupLinkPresent() && fandEPageUi.isCreatedGroupPresent("TestClone ");
	}

	public boolean editNewGroupSetNameAndClickOK() {
		fandEPageUi.enterCloneGroupName("TestEdit ");
		fandEPageUi.clickOkButtonOnGroupAssignmentWindow();
		fandEPageUi.switchToMainWindow();
		return fandEPageUi.createGroupLinkPresent() && fandEPageUi.isCreatedGroupPresent("TestEdit ");
	}

	public boolean clickOnTheDELETEOptionOfGroupSetsInTheLefthandNavigationPanelAndClickOKButtonFromTheConfirmationPopup() {
		fandEPageUi.deleteFirstGroupFromFnE();
		return fandEPageUi.createGroupLinkPresent();
	}

	public boolean provideATitleAndClickOnSave() {
		return provideATitleAndClickOnSaveFnE("TestLearningCurve");
	}

	public boolean editTitleAndClickOnSave(String title) {
		fandEPageUi.editElementTitle(title);
		fandEPageUi.clickSaveButtonForEditAction();
		return fandEPageUi.messageFlyerDisplayed("Item was saved");
	}

	public boolean clickOnQuestionsTab() {

		fandEPageUi.clickOnQuestionTab();
		return fandEPageUi.questionBankPageDisplayed();
	}

	public boolean clickOnAnyChapterAndThenTestBank() {
		fandEPageUi.clickOnFirstChapterQuestionBank();
		fandEPageUi.clickFirstTestBank();
		return fandEPageUi.questionsAreDisplayed();
	}

	public boolean clickOnAnyChapterAndThenSecondTestBank() {
		fandEPageUi.clickOnFirstChapterQuestionBank();
		fandEPageUi.clickSecondTestBank();
		return fandEPageUi.questionsAreDisplayed();
	}

	public void selectQuestionsAndThenClickOnAddToNewPoolFromTheAddToPoolDropDown() {
		fandEPageUi.selectQuestions(5);
		fandEPageUi.addToPool();
	}

	public void enterTitleAndClickSaveButton() {
		fandEPageUi.enterPoolName("PoolTitle5", "5");
	}


	public void clickOnDoneEditingButton() {
		fandEPageUi.clickDoneEditing();
	}

	public boolean clickDoneEditingButtonLearnicgCurveVrification() {
		fandEPageUi.clickDoneEditing();
		return fandEPageUi.isLearningCurveDisplayed("TestLearningCurve");
	}

	public void hoverOverTheEditButtonAndClickOnSettingsOption() {
		fandEPageUi.mouseHoverOverEdit();
		fandEPageUi.editFneSettings();
	}

	public boolean selectTheGroupToApplyTheSettingChangesToAndClickSaveButton() {
		fandEPageUi.selectAGroupFromSettingsFor();
		return clickSaveButton();
	}

	public boolean uncheckAutoCalculateCheckboxAndEnterTheTargetScore(String score) {
		fandEPageUi.uncheckAutoScoreOption();
		fandEPageUi.enterUserScore(score);
		return fandEPageUi.isAssignScoreEnabled();
	}

	public boolean clickSaveButton() {
		fandEPageUi.saveChangedSettings();
		return fandEPageUi.messageFlyerDisplayed("Your settings have been saved");
	}

	public boolean clickDoneEditingButtonAndVerifyEnteredScore(String score) {
		fandEPageUi.clickDoneEditing();
		return fandEPageUi.isLearningCurveDisplayed("TestLearningCurve") && fandEPageUi.isUserEnteredScoreDisplayed(score);
	}

	public void userClicksOnTheCrossReferenceSection(String chapter) {
		fandEPageUi.clickOnRefrencedChapterName(chapter);
		//return fandEPageUi.newReferencedChapterDisplayed(chapter);
	}

	public boolean clickOnAnyKeyTermAppearingOnTheFnEWindow() {
		fandEPageUi.clickKeyTerm();
		return fandEPageUi.isGlossaryDefinitionWindowContentDisplayed();
	}

	public boolean clickOnX() {
		fandEPageUi.closePopInGlossaryDefWindow();
		return !fandEPageUi.isGlossaryDefinitionDisplayed();
	}

	public void hoverOverTheEditButtonAndClickOnBasicInfoOption() {
		fandEPageUi.mouseHoverOverEdit();
		fandEPageUi.editFneBasicInfo();
	}

	public boolean editTheFieldsAndClickOnSaveButton() {
		return editTitleAndClickOnSave("Title Changed");
	}

	public boolean clickOnHomeButtonAndVerifyCreatedItemDisplayed(String text) {
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public void userClicksNextNavigationButton() {
		fandEPageUi.switchToDefaultWindow();
		fandEPageUi.clickNextButton();
	}

	public boolean userClickOnNextNavigationButtonTillLastContentItemOfChapterIsAboutToReach() {
		while (fandEPageUi.isNextButtonEnabled()) {
			userClicksNextNavigationButton();
		}
		return !fandEPageUi.isNextButtonEnabled();
	}

	public void userClicksPreviousNavigationButton() {
		fandEPageUi.clickPreviousButton();
	}

	public boolean userClickOnPreviousNavigationButtonTillFirstContentItemOfChapterIsAboutToReach() {
		while (fandEPageUi.isPreviousButtonEnabled()) {
			userClicksPreviousNavigationButton();
		}
		return !fandEPageUi.isPreviousButtonEnabled();
	}

	public boolean provideATitleAndClickOnAttachADocument(String title) {
		fandEPageUi.enterNewElementTitle(title);
		fandEPageUi.clickUplooadDocument();
		return fandEPageUi.uploadDocumentDialogDisplayed();
	}

	public boolean clickAttachALink() {
		fandEPageUi.clickAttachLink();
		return fandEPageUi.addLinkDialogDisplayed();
	}

	public void provideLinkTitleURLAndClickSave(String title, String url) {
		fandEPageUi.addNewLinkCollectionAndClickSave(title, url);
	}

	public void clickOnSave() {
		fandEPageUi.clickSaveButtonForNewElement();
	}

	public boolean provideATitleAndProvideANewValidURLClickOnSave(String title, String url) {
		fandEPageUi.enterNewElementTitle(title);
		fandEPageUi.enterLinkUrl(url);
		fandEPageUi.clickSaveButtonForNewElement();
		return fandEPageUi.messageFlyerDisplayed("Item was saved");
	}

	public boolean verifyFnePageOptions() {
		return fandEPageUi.fneHeaderOptionsDisplayed() && fandEPageUi.getFneTitle().contains(clickedContent);
	}

	public boolean openTheDetailsOfAnyOfTheStudentListedOnResultsPage() {
		return fandEPageUi.individualScoredetailsOfAIndividualIsDisplayed();
	}

	public boolean clickHomeAndVerifyGreenTickMarkIsDisplayed() {
		fandEPageUi.clickHomePageLink();
		latestHitCount = launchpadHome.greeTickMarkHitCount();
		return latestHitCount > previousHitCount;
	}

	public void click1UngradedSubmissionMessage() {
		fandEPageUi.click1UngradedSubmissionMessage();
		//return fandEPageUi.verifyGradeNeededIconIsDisplayed();
	}

	public boolean instructorEditAssignmentScreenSettings() {
		launchpadHome.clickOnFirstUnassignedChapterAndReturnChapterName();
		launchpadHome.clickChapterIntroduction();
		fandEPageUi.fneHeaderOptionsDisplayed();
		return fandEPageUi.assignOption();
	}

	public boolean fillRequiredAssignmentInfoAndAssign(String points, String category) {
		fandEPageUi.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.assignButton();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public void instructorSetsDueDate() {
		launchpadHome.addNewItem();
		launchpadHome.createNewItemAndBrowseItemOptionsDisplayed();
		launchpadHome.createNewItem();
	}

	public boolean addNewItemAndVerifyAllOptions() {
		launchpadHome.addNewItem();
		return launchpadHome.createNewItemAndBrowseItemOptionsDisplayed();
	}

	public boolean verifyTemplatesAndAddQuiz(String quizname) {
		launchpadHome.variousCreateOptionsDisplayed();
		launchpadHome.addNewQuiz();
		launchpadHome.enterQuizDetailsForQuestionPicker(quizname);
		fandEPageUi.clickSaveButton();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.addquestionfromedittab();
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(3);
		fandEPageUi.addQuestions();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorEnterQuizAndChangeTimeLimit() {
		launchpadHome.instructorEnterCreatedQuiz2();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		fandEPageUi.provideTimeLimitInSettingsTab();
		fandEPageUi.saveSettings();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorEnterQuizAndChangeQuizSettingsRandomize() {
		launchpadHome.instructorEnterCreatedQuiz2();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		//launchpadHome.verifyQuizEditOptions();
		launchpadHome.settingsOption();
		fandEPageUi.randomQuizOrderCheckbox();
		fandEPageUi.saveSettings();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorEnterQuizAndChangeQuizAttempts() {
		launchpadHome.instructorEnterCreatedQuiz2();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		launchpadHome.verifyQuizEditOptions();
		launchpadHome.settingsOption();
		fandEPageUi.changeQuizAttampts();
		fandEPageUi.saveSettings();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public void instructorAssignQuiz(String time, String points) {
		fandEPageUi.assignContent1(time, points);
	}

	public boolean instructorSetDueDateQuizEntire(String points) {
		launchpadHome.instructorEnterCreatedQuiz2();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		launchpadHome.verifyQuizEditOptions();
		launchpadHome.assignmentOption();
		launchpadHome.fillAssignmentValues(points);
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}
	
	public boolean instructorAssignAndUnassignQuiz(String points) {
		launchpadHome.instructorEnterCreatedQuiz2();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		launchpadHome.verifyQuizEditOptions();
		launchpadHome.assignmentOption();
		launchpadHome.fillAssignmentValues(points);
		launchpadHome.unassignQuiz();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public boolean instructorEnterQuizAndChangeScoredAttempts() {
		launchpadHome.instructorEnterCreatedQuiz2();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		//launchpadHome.verifyQuizEditOptions();
		launchpadHome.settingsOption();
		fandEPageUi.changeScoredAttampts();
		fandEPageUi.saveSettings();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public void instructorChangeTypeOfScoreInQuiz(String time, String points) {
		launchpadHome.instructorEnterCreatedQuiz2();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		launchpadHome.verifyQuizEditOptions();
		launchpadHome.assignmentOption();
		//launchpadHome.assignmentOption();
		fandEPageUi.assignContent1(time, points);
	}

	public void hideFromStudentChekbox() {
		launchpadHome.instructorEnterCreatedQuiz();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		launchpadHome.verifyQuizEditOptions();
		launchpadHome.settingsOption();
		fandEPageUi.hideFromStudent();
		fandEPageUi.saveSettings();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public void uploadBulkQuestions(){
		fandEPageUi.selectAllFromSelectManu();
		fandEPageUi.verifyQuestionsAdded();
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
	}

	public void previewQuestionInQuestionByChapter() {
		fandEPageUi.previewQuestion();
		fandEPageUi.clickCloseCross();
		fandEPageUi.selectQuestions(2);
		fandEPageUi.addQuestions();
		fandEPageUi.clickOnQuestionBanks();
	}

	public void reviewQuestionByAssessment() {
		launchpadHome.questionsOption();
		fandEPageUi.selectQuestionByAssessment();
		fandEPageUi.selectTestBank();
		fandEPageUi.previewQuestion();
	}

	public void moveFAndEToHomePage() {
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public void browseAvailableQuestionsFromQuestionBank() {
		launchpadHome.instructorEnterCreatedQuiz();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		launchpadHome.verifyQuizEditOptions();
		launchpadHome.questionsOption();
		fandEPageUi.selectQuestionByAssessment();
		fandEPageUi.selectTestBank();
	}

	public boolean clickOnDoneEditingButtonAndVerifyLink() {
		fandEPageUi.clickDoneEditing();
		return fandEPageUi.clickCreatedLinkCollectionAndVerifyNewPageDisplayed();
	}

	public void browseAFileProvideDocumentTitleAndClickUpload(String title) {
		fandEPageUi.enterDescriptionInDropboxTinyMce();
		fandEPageUi.enterUploadDocumentTitleAndClickUpload(title);
	}

	public boolean clickSaveAndFurtherClickOnTheDoneEditing(String title) {
		fandEPageUi.clickSaveButtonForNewElement();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickDoneEditing();
		return fandEPageUi.subittedDocumentDisplayed(title);
	}

	public boolean checkingCompleteButton() {
		fandEPageUi.checkForCompleteVisible();
		checkBoolean1 = fandEPageUi.completeVisible();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public boolean isEnrolledStudentVisible() {
		return fandEPageUi.checkIsEnrolledStudentVisible();
	}

	public boolean visibleColumnsSettings() {
		fandEPageUi.visibleColumns();
		return fandEPageUi.instructorConsoleGradebook();
	}

	public boolean visibleFooterSettings() {
		fandEPageUi.visibleFooter();
		return fandEPageUi.instructorConsoleGradebook();
	}

	public boolean scoreDisplaySettings() {
		fandEPageUi.scoreDisplay();
		return fandEPageUi.instructorConsoleGradebook();
	}

	public boolean writeInTheMceEditor(String text) {
		fandEPageUi.writeInMceEditor(text);
		fandEPageUi.doneEditingButton();
		return fandEPageUi.clickOnHypeLink();
	}

	public boolean verifyInTheMceEditorAgain() {
		fandEPageUi.enterSecondUrl();
		fandEPageUi.doneEditingButton();
		return fandEPageUi.clickOnHypeLinkAgain();
	}

	public boolean writeInTheMceEditorUnderQuiz(String text) {
		fandEPageUi.writeInMceEditorUnderQuiz(text);
		return launchpadHome.confirmadditionofitem();
	}

	public boolean minuteColumnIsVisible() {
		fandEPageUi.minuteColumnVisible();
		return fandEPageUi.minuteVisible();
	}

	public boolean minuteColumnNotEmpty() {
		checkBoolean1 = fandEPageUi.minuteColumnIsNotEmpty();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public boolean importTheScoresFromOutside() {
		fandEPageUi.importTheScores();
		checkBoolean1 = fandEPageUi.instructorConsoleGradebook();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public boolean exportTheScoresFromApplication() {
		return fandEPageUi.exportTheScores();
	}

	public void closeExport() {
		fandEPageUi.closeexport();
	}

	public boolean instructorSetDueDateQuizIndividual(String points) {
		launchpadHome.instructorEnterCreatedQuiz2();
		launchpadHome.clickEditLinkForContentOnGearManagementCard();
		launchpadHome.verifyQuizEditOptions();
		launchpadHome.assignmentOption();
		fandEPageUi.addStudentForSettings();
		launchpadHome.fillAssignmentValues(points);
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public void VerifyTimeLimitOfQuiz() {
		launchpadHome.instructorEnterCreatedQuiz2();
		fandEPageUi.verifyTimeLimit();
		fandEPageUi.clickHomePageLink();
	}

	public void VerifyTypeOfScoreOfQuiz() {
		launchpadHome.instructorEnterCreatedQuiz2();
		fandEPageUi.verifyCountedAttemptType();
		fandEPageUi.clickHomePageLink();
	}

	public void VerifyNumberOfQuizAttempts() {
		launchpadHome.instructorEnterCreatedQuiz2();
		fandEPageUi.numberOfQuizAttempts();
		fandEPageUi.clickHomePageLink();
	}



	public boolean updateAnyNumberOfExistingDueDatesSimultaneouslyUsingTheBatchDueDateUpdater(String QuizName, String points) {
		launchpadHome.clickAddButton();
		launchpadHome.clickCreateButton();
		launchpadHome.clickQuizButton();
		fandEPageUi.enterQuizDetails(QuizName);
		fandEPageUi.clickSaveButton();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickAssignButton();
		launchpadHome.setDateTimeField();
		launchpadHome.setPoints(points);
		launchpadHome.clickAssignAgain();
		fandEPageUi.saveAllChanges();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return launchpadHome.verifyInstructorIsAtHomePage();
	}

	public void clickHomeButton() {
		welcomePage.clickHomeButton();
	}

	public void mouseHoverAndGetText() {
		launchpadHome.resource();
		launchpadHome.contentByChapter();
	}

	public void createSaveAndAssignNewQuiz(String quizname, String points) {
		createAndSaveNewQuiz(quizname);
		fandEPageUi.clickAssignButton();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.addquestionfromedittab();
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(3);
		fandEPageUi.addQuestions();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public void createSaveAndAssignNewQuizWithCategory(String quizname, String points, String category) {
		createAndSaveNewQuiz(quizname);
		fandEPageUi.clickAssignButton();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.setCategory(category);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}

	public void studentViewsFeedbackOnEachQuestion(String points) {
		//////////////////////////// below two lines are workaround to display question by chapter  ////////////////////////////////////////////////////
		fandEPageUi.clickDoneEditing();
		fandEPageUi.addquestionfromedittab();

		fandEPageUi.createMultipleAnswerAndAddFeedback();
		fandEPageUi.clickOnAssignmentTab();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.settingsTabLink();
		fandEPageUi.settingsTabLink();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}


	//	public void selectQuestionsAndThenClickOnAddToExistingPoolFromTheAddToPoolDropDown(int noOfQues) {
	//		fandEPageUi.selectQuestionsToAddInExistingPool(noOfQues);
	//		fandEPageUi.addToExistingPool();
	//	}


	public void addTheQuestionPool() {
		fandEPageUi.addQuestionPool();
		fandEPageUi.enterPoolName("PoolTitle6", "5");
	}

	public void clickOnTheQuestionBanksAndThenSelectQuizNameUnderAssesment() {
		fandEPageUi.clickOnQuestionBanks();
		//launchpadHome.instructorEnterCreatedQuiz();
	}

	public void selectAllQuestionsFromBulkSelectionMenuAndAddToPool() {
		fandEPageUi.selectAllFromBulkSelectionMenu();
		fandEPageUi.verifyQuestionsAdded();
		fandEPageUi.addToPool();
	}

	public void clickOnHomeButton() {
		fandEPageUi.clickHomePageLink();
	}

	public void userNavigatedToSupplementaryExercises() {
		launchpadHome.clickSupplementaryExercises();
	}

	public void clickOnCreatedQuizAssignmentAndClickOnItsSettingTab() {
		launchpadHome.openContentByContentNameCreated();
		fandEPageUi.editSettings();
	}

	public void enterFirstCourseEnrolledByStudent() {
		launchpadPage.enterFirstCourseEnrolledByStudent();
	}

	public void enterIntoCourseByCourseName(String courseName){
		launchpadPage.enterIntoCourseByCourseName(courseName);
	}

	public void userSelectsTheBaseLineCourseFromWhichToBaseTheNewCourse(String course) {
		launchpadPage.selectBaseLinceCourseByCourseName(course);
	}

	public boolean userCreatesNewbaselinedCourse(String courseName) {
		enterCourseName(courseName);
		clickCreateButton();
		return launchpadPage.verifyNewBaseLinedCourseIsDisplayedOnDashboard(courseName);
	}

	public void onMyCoursePageClickOnDeleteLinkForCourseByCourseName(String cname) {
		launchpadPage.deleteCourseByName(cname);
		//return launchpadPage.deleteOverlayAppears(text);
	}

	public boolean instructorClickOnDeleteButton(String cname) {
		launchpadPage.clickDeleteButton();
		return !launchpadPage.verifyCourseIsDeleted(cname);
	}

	public boolean loginAsStudentAndEnterTheCourse(String browser,String userName, String password){
		copyTheActivatedURLForTheCourse();
		logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(browser);
		clickLogInButtonProvidedUnderStudentHeading(userName,password);
		//clickEnterCourse();
		return launchpadHome.isLaunchPadMenuDisplayed();
	}
	public boolean studentAttemptsAndSubmitsQuiz(){
		fandEPageUi.studentAttemptsQuiz();
		fandEPageUi.studentAnswersQuiz();
		checkBoolean1 = fandEPageUi.studentSubmitsQuiz();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}
	public void createAndAssignDropbox(String dropboxName,String points){
		launchpadHome.clickAddButton();
		launchpadHome.clickCreateButton();
		fandEPageUi.dropboxButton(dropboxName);
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickAssignButton();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}
	public boolean instructorExportScoresFromApplication(){
		checkBoolean1 = clickOnGradebookButtonPresentInsideInstructorConsoleWidget();
		checkBoolean2 = fandEPageUi.exportTheScores();
		fandEPageUi.closeexport();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorEditsDisplayOptionSeetings(){
		checkBoolean1 = clickOnGradebookButtonPresentInsideInstructorConsoleWidget();
		checkBoolean2 = fandEPageUi.checkIsEnrolledStudentVisible();
		checkBoolean3 = visibleColumnsSettings();
		checkBoolean4 = visibleFooterSettings();
		checkBoolean5 = scoreDisplaySettings();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2 && checkBoolean3 && checkBoolean4 && checkBoolean5 ;
	}
	public boolean instructorRearrangeTheAssignmentsUnderCategoriesNumerically(){
		checkBoolean1 = clickOnTheViewInstructorConsoleForGradebookPreferences();
		checkBoolean2 = rearrangeTheAssignmentsUnderCategoriesNumerically();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorRearrangeTheCategoriesNumerically(){
		checkBoolean1 = clickOnTheViewInstructorConsoleForGradebookPreferences();
		checkBoolean2 = rearrangeTheCategoriesNumerically();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorChangeThePassingScore(String passScore){
		checkBoolean1 = clickOnTheViewInstructorConsoleForGradebookPreferences();
		checkBoolean2 = changeThePassingScore(passScore);
		fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorViewhideAssignments(){
		checkBoolean1 = clickOnTheViewInstructorConsoleForGradebookPreferences();
		checkBoolean2 = clickViewhideAssignments();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorUseTheWeightedCategories(){
		checkBoolean1 = clickOnTheViewInstructorConsoleForGradebookPreferences();
		checkBoolean2 = useTheWeightedCategories();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean studentAttemptsAndSaveQuiz(){
		fandEPageUi.studentAttemptsQuiz();
		fandEPageUi.studentAnswersQuiz();
		checkBoolean1 =  fandEPageUi.studentSaveQuiz();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public void createAndSaveNewQuiz(String quizname) {
		launchpadHome.clickAddButton();
		launchpadHome.clickCreateButton();
		launchpadHome.clickQuizButton();
		fandEPageUi.enterQuizDetails(quizname);
		fandEPageUi.clickSaveButton();
		fandEPageUi.clickDoneEditing();
	}

	public void instructorAddsNewQuiz(String quizName){
		launchpadHome.clickAddButton();
		launchpadHome.clickCreateButton();
		launchpadHome.clickQuizButton();
		fandEPageUi.enterQuizDetails(quizName);
		fandEPageUi.enterQuizSubtitleAndDirections();
		fandEPageUi.clickSaveButton();
		//////////////////////////// below two lines are workaround to display question by chapter  ////////////////////////////////////////////////////
		fandEPageUi.clickDoneEditing();
		fandEPageUi.addquestionfromedittab();
		//fandEPageUi.forQuestioDisplay();
	}
	public boolean studentAttemptsQuizAndCheckForTimerAvailability(){
		fandEPageUi.studentAttemptsQuiz();
		checkBoolean1 = isTimerVisible();
		fandEPageUi.studentAnswersQuiz();
		fandEPageUi.studentSubmitsQuiz();
		checkBoolean2 =  fandEPageUi.studentCloseQuiz();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean studentAttemptsAndCloseTheQuiz(){
		fandEPageUi.studentAttemptsQuiz();
		fandEPageUi.studentAnswersQuiz();
		fandEPageUi.studentSubmitsQuiz();
		checkBoolean1 = fandEPageUi.studentCloseQuiz();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}
	public void createAndSaveNewHomework(String homeworkName){
		launchpadHome.clickAddButton();
		launchpadHome.clickCreateButton();
		launchpadHome.homeworkButton();
		fandEPageUi.enterQuizDetails(homeworkName);
		fandEPageUi.enterQuizSubtitleAndDirections();
		fandEPageUi.clickSaveButton();
		//fandEPageUi.forQuestioDisplay();

	}
	public boolean studentAttemptsAndSubmitHomework(){
		fandEPageUi.studentAttemptsHomework();
		fandEPageUi.studentAnswersQuiz();
		checkBoolean1 =  fandEPageUi.studentSubmitsQuiz();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}
	public boolean instructorAddOneQuestionToNewPool(){
		moveToQuestionTestBankPage();
		fandEPageUi.selectQuestions(1);
		fandEPageUi.addToPool();
		fandEPageUi.enterPoolName("PoolTitle1", "8");
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	
	public void instructorSaveQuiz(int noOfQues,String points) {
		fandEPageUi.addquestionfromedittab();
		clickOnQuestionsTab();
		clickOnAnyChapterAndThenTestBank();
		fandEPageUi.selectQuestions(noOfQues);
		fandEPageUi.addQuestions();
		fandEPageUi.clickOnAssignmentTab();
		launchpadHome.setDateTimeField();
		fandEPageUi.setPoints(points);
		fandEPageUi.clickAssignAgain();
		fandEPageUi.settingsTabLink();
		fandEPageUi.checksaveandcontinuebox();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
	}
	
	public boolean instructorAddQuestionsToExistingPool(){
		moveToQuestionTestBankPage();
		fandEPageUi.selectQuestions(5);
		//fandEPageUi.addToPool();
		//fandEPageUi.enterPoolName("PoolTitle2", "5");
		//clickOnQuestionsTab();
		//clickOnAnyChapterAndThenTestBank();
		fandEPageUi.addToExistingPool();
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorAddQuestionsToNewPool(){
		moveToQuestionTestBankPage();
		fandEPageUi.selectQuestions(5);
		fandEPageUi.addToPool();
		fandEPageUi.enterPoolName("PoolTitle3", "5");
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorAddSeveralQuestionsUsingCheckBoxes(){
		moveToQuestionTestBankPage();
		fandEPageUi.selectQuestions(2);
		fandEPageUi.addQuestions();
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorBrowseAvailableQuestionsFromQuestionBanks(){
		moveToQuestionTestBankPage();
		clickOnTheQuestionBanksAndThenSelectQuizNameUnderAssesment();
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public void instructorBulkUploadQuestions(){
		moveToQuestionTestBankPage();
		uploadBulkQuestions();
		//return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorDeselectsAllQuestions(){
		fandEPageUi.addquestionfromedittab();
		checkBoolean1 = clickOnQuestionsTab();
		checkBoolean2 = clickOnAnyChapterAndThenSecondTestBank();
		checkBoolean3 = fandEPageUi.deselectAllQuestions();
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2 && checkBoolean3;
	}
	public boolean instructorEditApublisherCreatedQuestion(){
		fandEPageUi.addquestionfromedittab();
		checkBoolean1 = clickOnQuestionsTab();
		checkBoolean2 = clickOnAnyChapterAndThenSecondTestBank();
		fandEPageUi.selectQuestions(1);
		fandEPageUi.addQuestions();
		fandEPageUi.clickEditQuestionInAssesment();
		fandEPageUi.editQuestionInAssesment();
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorEditAuserCreatedQuestion(){
		fandEPageUi.addquestionfromedittab();
		checkBoolean1 = clickOnQuestionsTab();
		fandEPageUi.addMultipleChoiceQuestion();
		fandEPageUi.clickDoneEditing();
		//		fandEPageUi.editQuestionsAnswerFromQuiz();
		//		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public boolean instructorExpandCollapseQuestionsInAquestionBank(){
		moveToQuestionTestBankPage();
		fandEPageUi.clickOnExpandQuestion();
		fandEPageUi.clickOnCollapseQuestion();
//		fandEPageUi.selectQuestions(1);
//		fandEPageUi.addQuestions();
//		clickOnTheQuestionBanksAndThenSelectQuizNameUnderAssesment();
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorPreviewQuestionInQuestionBanks(){
		moveToQuestionTestBankPage();
		previewQuestionInQuestionByChapter();
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	
	public boolean instructorRemovePoolFromAnAssessment(){
		moveToQuestionTestBankPage();
//		fandEPageUi.selectQuestions(3);
//		fandEPageUi.addQuestions();
		fandEPageUi.clickRemovePoolFromRightSide();
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	
	public boolean instructorRemoveAquestionFromAnAssessment(){
		moveToQuestionTestBankPage();
//		fandEPageUi.selectQuestions(3);
//		fandEPageUi.addQuestions();
		fandEPageUi.clickRemoveQuestionFromRightSide();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickRemoveQuestionFromQuiz();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	
	
	
	public boolean instructorSelectAllQuestionsFromAquestionBank(){
		moveToQuestionTestBankPage();
		selectAllQuestionsFromBulkSelectionMenuAndAddToPool();
		fandEPageUi.enterPoolName("PoolTitle4", "5");
		fandEPageUi.clickDoneEditing();
		//fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public boolean instructorSelectQuestionsUsedInPreviousAssessment(){
		moveToQuestionTestBankPage();
		//fandEPageUi.selectQuestionsUsedInPreviousQuizFromBulkSelectionMenu();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1 && checkBoolean2;
	}
	public void moveToQuestionTestBankPage(){
		fandEPageUi.addquestionfromedittab();
		checkBoolean1 = clickOnQuestionsTab();
		checkBoolean2 = clickOnAnyChapterAndThenTestBank();
	}
	public boolean studentAnswersAndViewPreviousQuizScore(){
		fandEPageUi.studentAttemptsQuiz();
		fandEPageUi.studentAnswersQuiz();
		checkBoolean1 =  fandEPageUi.studentSubmitsQuiz();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.clickDoneEditing();
		fandEPageUi.previousScore();
		fandEPageUi.clickHomePageLink();
		return checkBoolean1;
	}

	public void closeBrowser() {
		logout();
		exitBrowser();
	}

	//	/@AfterMethod(alwaysRun = true)
	public void closeBrowserTakeScreenshotOfFailure(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();
		if (!result.isSuccess()) {

			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("target/failsafe-reports/screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".jpg"));
			} catch (Exception e1) {
			}
		}
		driver.quit();
	}

	//	public void tearDown(){
	//	try{
	//		driver.close();
	//		exitBrowser();
	//	} catch (UnreachableBrowserException e){}
	//	catch (SessionNotFoundException e){}
	//}

	public  void exitBrowser() {
		driver.quit();
	}

	//	public void clickAlreadyCreatedQuiz(){
	//		click('');
	//	}
	//    public void createSampleCourses(String courseName) {
	//        Assert.assertTrue(dsl.clickOnCreateCourseLink());
	//        //Assert.assertTrue(dsl.selectYesRadioButton());
	//        //dsl.userSelectsTheBaseLineCourseFromWhichToBaseTheNewCourse(dsl.baseCourse);
	//        Assert.assertTrue(dsl.clickOnNextButton());
	//        dsl.userCreatesNewbaselinedCourse(courseName);
	//        dsl.clickOnActivateCourseLink();
	//        Assert.assertTrue(dsl.validateActivateCoursePopUpIsDisplayedWithHeading("Activate this course?"));
	//        dsl.clickActivateButton();
	//        Assert.assertTrue(dsl.validateCourseSuccessfullyUpdatedPopUpIsDisplayedWithHeading("Course Activated!"));
	//        dsl.clickDoneButton();
	//        Assert.assertTrue(dsl.validateDeactivateLinkIsDisplayedOnceCourseActivates("Deactivate"));
	//        dsl.enterIntoCourseByCourseName(courseName);
	//        Assert.assertTrue(dsl.clickEnterCourse());
	//        dsl.copyTheActivatedURLForTheCourseNC();
	//        Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
	//        Assert.assertTrue(dsl.clickOnTheLogInButtonProvidedUnderStdudentHeading(Utilities.getYamlValue("users.student.user_name3"), Utilities.getYamlValue("users.student.password")));
	//        Assert.assertTrue(dsl.clickOnTheJoinCourse("Congratulations! You have successfully joined"));
	//        Assert.assertTrue(dsl.clickEnterCourse());
	//    }
	//@Test
	//    public void createSampleCOurseOne() {
	//        dsl.setUp();
	//        createSampleCourses(dsl.group1);
	//        dsl.copyTheActivatedURLForTheCourseNC();
	//        Assert.assertTrue(dsl.logOutAsInstructorAndAgainBrowseTheCopiedURLForStudent(Utilities.getYamlValue("browser")));
	//        Assert.assertTrue(dsl.clickOnTheLogInButtonProvidedUnderStdudentHeading(Utilities.getYamlValue("users.student.user_name2"), Utilities.getYamlValue("users.student.password")));
	//        Assert.assertTrue(dsl.clickOnTheJoinCourse("Congratulations! You have successfully joined"));
	//        Assert.assertTrue(dsl.clickEnterCourse());
	//        dsl.closeBrowser();
	//    }
	
	public void dragAndDropQuestionFromTestBankToQuestionsByPublisher(){
		fandEPageUi.dragAndDropQuestion();
		//moveFAndEToHomePage();
	}
	
	public void navigateFromAnotherTab(){
		fandEPageUi.settingsTabLink();
		launchpadHome.clickQuestionsTab();
	}
	
	public boolean verifyQuestionsAdded(){
		return fandEPageUi.verifyAllQuestionAdded();
	}
	
	public void removeDragedQuestion(){
		fandEPageUi.selectCheckBoxToRemoveQuestions();
	}

}