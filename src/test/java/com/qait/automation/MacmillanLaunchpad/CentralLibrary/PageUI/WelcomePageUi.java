package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI.CommonMethods;

import com.qait.automation.MacmillanLaunchpad.Utils.DateUtil;



public class WelcomePageUi extends CommonMethods {

	public WebDriver driver;
	
	@FindBy(css = ".facePlate-start_welcome_title>div>strong")
	WebElement welcomePageHeading;

	@FindBy(className = "EnterCourse")
	WebElement enterCourseLink;

	@FindBy(id = "add-assignment-btn")
	WebElement addButton;

	@FindBy(id = "CW_ResourcesButton")
	WebElement resourcesButton;

	@FindBy(id = "CW_SettingsButton")
	// .consolebutton #CW_SettingsButton
	WebElement settings;

	// @FindBy(css=".instructor-console-link .link")
	// WebElement editConsoleLinks;

	@FindBy(id = "CW_GradeBookButton")
	WebElement gradebookButton;

	@FindBy(xpath = "(//ul[@id='selResourceType-instructor-console']/li/input[1])[1]")
	WebElement resourcesByChapters;

	@FindBy(id = "fne-unblock-action-home")
	WebElement homeButton;

	@FindBy(className = "editPageStart")
	WebElement editPageLink;

	@FindBy(xpath = "(//a[@class='closeWidgetButton'])[1]")
	WebElement removeLink;

	@FindBy(className = "doneEditing")
	WebElement doneEditingButtonOnWelcomePage;

	@FindBy(xpath = "(//span[@class='grip-icon'])[3]")
	WebElement dragWidgetFrom;

	@FindBy(id = "PX_HOME_FACEPLATE_START_ZONE_RIGHT_Add_")
	WebElement dragWidgetTo;

	@FindBy(className = "navInput-title")
	WebElement inputTitleInNavigation;

	@FindBy(css = "IsLoadStartOnInit")
	WebElement checkboxInsideNavigation;

	@FindBy(linkText = "Return to Welcome screen")
	WebElement returnToWelcomeScreen;

	@FindBy(css = ".widgetContents .widgetBody .facePlate-start_welcome .facePlate-start_welcome_msg")
	WebElement courseEdit;
	@FindBy(xpath = "(//div[@class='widgetContents'])[1]")
	WebElement courseEditHighlighted;
	@FindBy(css = ".blockWidgetUI.blockWidgetUI_ON")
	WebElement courseEditHighlighted1;
	@FindBy(css = ".ui-dialog-buttonset .ui-button-text")
	WebElement saveChanges;
	@FindBy(css = "#Title")
	WebElement pageTitle;
	@FindBy(css = ".ui-dialog-buttonset .linkCancelClass")
	WebElement cancelChanges;

	@FindBy(css = "#widgetBody #more-resources-search-box")
	WebElement searchButton;
	@FindBy(css = "#browseResults #moreResourcesTitleName")
	WebElement resourcesOverlay;
	@FindBy(css = "#RssFeedUrl")
	WebElement rssFeedInput;
	@FindBy(css = "#ErrorText")
	WebElement rssErrorMsz;
	@FindBy(css = ".ui-dialog-buttonset .ui-button-text")
	WebElement rssFeedSaveButton;
	@FindBy(css = ".linkCancelClass")
	WebElement rssFeedCancelButton;
	@FindBy(id = "SectionNumber")
	WebElement sectionNumberTextBox;
	@FindBy(id = "CourseUserName")
	WebElement instructorNameTextBox;

	@FindBy(xpath = "//span[@class='mceIcon mce_media']")
	WebElement embaddedMedia;
	@FindBy(xpath = "//span[@class='mceIcon mce_image']")
	WebElement embaddedImage;
	@FindBy(id = "mce_7_ifr")
	WebElement insertImageAndVideoFrame;
	@FindBy(id = "uploadFile")
	WebElement selectImage;
	@FindBy(id = "btnUpload")
	WebElement uploadButton;
	@FindBy(className = "mceFocus")
	WebElement imageURL;
	@FindBy(id = "previewImg")
	WebElement imagePreviewSection;
	@FindBy(css = "#title")
	WebElement imageTitle;
	@FindBy(id = "insert")
	WebElement insertButton;
	@FindBy(id = "alt")
	WebElement imageDescription;
	@FindBy(id = "create")
	WebElement createNew;
	@FindBy(xpath = "//span[@class='item-title'][contains(text(),'Quiz')]")
	WebElement quiz;
	@FindBy(css = ".savebtn.saveandopen")
	WebElement saveit;
	@FindBy(id = "Contents_ifr")
	WebElement writeContentFrame;
	@FindBy(id = "tinymce")
	WebElement welcomePageContentsTextBox;
	@FindBy(id = "Content_Title")
	WebElement quizTitle;
	@FindBy(id = "Content_SubTitle")
	WebElement quizSubTitle;
	// @FindBy(css="#CW_SettingsButton")
	// WebElement settingsButton;
	@FindBy(css = "[href$=launchpad]")
	WebElement launchpadtab;
	@FindBy(css = "#launchpadItemsLink")
	WebElement removeUnitsLink;
	@FindBy(xpath = "(//span[@class='ui-button-text'])[1]")
	WebElement confirmRemove;
	@FindBy(css = "#submitlaunchPadForm")
	WebElement clickSave;
	@FindBy(css = "#CollapseDueLater")
	WebElement collapseLater;
	@FindBy(css = "#DueLaterDays")
	WebElement setDays;
	@FindBy(css = "#CollapseUnassigned")
	WebElement collapseUnassigned;
	@FindBy(css = "#CategoryName")
	WebElement categoryName;

	@FindBy(css = ".savebtn.saveandopen")
	WebElement saveButton;

	@FindBy(css = "#fne-done")
	WebElement doneEditingButton;

	@FindBy(css = "#fne-item-assign")
	WebElement assignButton;

	@FindBy(xpath = "(//td[@class='']/a/span)[23]")
	WebElement setDateTime;

	@FindBy(css = "#btnAssign")
	WebElement clickAssign;

	@FindBy(css = "#btnSaveChanges")
	WebElement saveChange;

	@FindBy(css = "#fne-unblock-action-home")
	WebElement clickHome;

	@FindBy(xpath = "(//span[@class='lblInUse moreResourcesLabel'][1])[1]")
	WebElement asd;
	@FindBy(css = "#CW_ReturnButton")
	WebElement returnButton;

	@FindBy(className = "openCalendarMonth")
	WebElement calendarIcon;

	@FindBy(css = ".link.active")
	WebElement monthview;

	@FindBy(className = "editPageStart")
	WebElement editPage;

	@FindBy(css = ".blockWidgetUI .blockWidgetUI_OFF")
	WebElement editFurther0;

	@FindBy(css = ".blockWidgetUI.blockWidgetUI_ON")
	WebElement editFurther1;

	// @FindBy(css=".widgetContents .blockWidgetUI_ON")

	@FindBy(css = ".link")
	WebElement listview;

	@FindBy(xpath = "(//a[@class='listView'])[1]")
	WebElement listviewbutton;

	@FindBy(xpath = "(//a[@class='monthView'])[1]")
	WebElement monthviewbutton;

	@FindBy(css = "#next")
	WebElement next;

	@FindBy(css = "#back")
	WebElement back;

	@FindBy(css = ".formbtns.editcontent .savebtn.button.primary.large")
	WebElement saveBtnCopyToCurrentUnit;

	@FindBy(xpath = "//div[@id='browseResultsPanel']/div[@class='close']")
	WebElement crossButton;
	
	@FindBy(css=".mceIcon.mce_link")
	WebElement linkButton;
	
	@FindBy(className="mceFocus")
	WebElement mceFocusTextBox;
	@FindBy(xpath="//div[@class='facePlate-start_welcome_msg']/p/a")
	WebElement addedLink;

	public WelcomePageUi(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean welcomeHeadingContains(String text) {
		waitForElementToLoad(welcomePageHeading, waitForElementInMilliSeconds);
		String[] toMatch = welcomePageHeading.getText().trim().split(" ");
		String expectedText = toMatch[0] + " " + toMatch[1];
		waitForElementToLoad(welcomePageHeading, waitForElementInMilliSeconds);
		return text.matches(expectedText);
	}

	public void clickEnterCourseLink() {
//		waitForSync();
//		waitForElementToLoad(enterCourseLink, waitForElementInMilliSeconds);
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + enterCourseLink.getLocation().y + ")");
		click(enterCourseLink);
	}

	public void editPageToRemoveWidget() {
			//waitForSync();
			assert removeLink.isDisplayed();
			click(removeLink);
			waitForSync();

		}

	public void doneEditing() {
//		waitForSync();
//		try {
			//doneEditingButtonOnWelcomePage.isDisplayed();
		click(doneEditingButtonOnWelcomePage);
//		} catch (Exception e) {
//
//		}
	}

	public boolean verifyInstructorAtWelcomePage() {
		waitForSync();
		return enterCourseLink.isDisplayed();
	}

	public void editPageToAddWidget() {
			((JavascriptExecutor) driver).executeScript("document.getElementById('PX_HOME_FACEPLATE_START_ZONE_LEFT_Choose_').style.display=('block')");

		List<WebElement> listOfWidget = driver.findElements(By.xpath("//*[@id='PX_HOME_FACEPLATE_START_ZONE_LEFT_Choose_']//li[@class='widgetDisplayItem']"));
		// System.out.println(listOfWidget.get(1).getText()); //The Economist
		// RSS Feed
		// System.out.println(listOfWidget.get(2).getText()); //Custom RSS Feed
		// System.out.println(listOfWidget.get(3).getText()); //Upcoming
		// Assignments
		click(listOfWidget.get(3));

	}

	public boolean addRSSFeedArticles() {
		assert editPageLink.isDisplayed();
		click(editPageLink);
		((JavascriptExecutor) driver).executeScript("document.getElementById('PX_HOME_FACEPLATE_START_ZONE_LEFT_Choose_').style.display=('block')");
		waitForSync();

		List<WebElement> listOfWidget = driver.findElements(By.xpath("//*[@id='PX_HOME_FACEPLATE_START_ZONE_LEFT_Choose_']//li[@class='widgetDisplayItem']"));
		click(listOfWidget.get(2));
		click(rssFeedSaveButton);
		assert rssErrorMsz.getText().contains("The specified URL is not a valid RSS feed");
		assert rssFeedCancelButton.isDisplayed();
		click(rssFeedInput);
		rssFeedInput.sendKeys("https://www.facebook.com/");
		waitForSync();
		return enterCourseLink.isDisplayed();
	}

	public void editPageLink() {
//		waitForSync();
//		waitForElementToLoad(editPageLink, waitForElementInMilliSeconds);
		//assert editPageLink.isDisplayed();
		click(editPageLink);
	}

	public void dragAndDropWidget() {
		Actions builder = new Actions(driver);
		org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(dragWidgetFrom).moveToElement(dragWidgetTo).release(dragWidgetTo).build();
		dragAndDrop.perform();

	}

	public boolean courseEditLink() {
		waitForSync(5000);
		//waitForElementToLoad(editPageLink, waitForElementInMilliSeconds);
		click(editPageLink);
		waitForSync(2000);
		courseEditHighlighted.click();
		//click(courseEditHighlighted);
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('facePlate-start_welcome_title')[0].click();");
				
		
		
		
		
		
//		try {
//			waitForSync();
//			waitForElementToEnable(courseEditHighlighted1, 10000);
			//click(courseEditHighlighted1);
//		} catch (Exception e) {
//		}
		
		waitForSync();
		//verify tiny mce editor opens
		return driver.findElement(By.className("ui-dialog-title")).getText().trim().contains("Welcome Message");
	}

	public void changeCourseTitle(String courseTitle) {
		//assert pageTitle.isDisplayed();
		click(pageTitle);
		pageTitle.clear();
		pageTitle.sendKeys(courseTitle + DateUtil.getCurrentDateTime());
		assert saveChanges.isDisplayed();
		assert cancelChanges.isDisplayed();
		//waitForSync();
		click(saveChanges);
		waitForSync();
	}

	// public void contentAndAssignmentList(){
	//
	// List<WebElement> contentAndAssignment=
	// driver.findElements(By.xpath("//div[@id='browseResults']/ul[1]/li"));
	// System.out.println(contentAndAssignment.size());
	// }

	public void returnToWelcomeScreen() {
		click(returnToWelcomeScreen);
	}

	public void readyToPerformActionOnImage() {
		click(embaddedImage);
		waitForSync();
		driver.switchTo().frame(1);
//		waitForElementToLoad(selectImage, waitForElementInMilliSeconds);
//		assert selectImage.isDisplayed();
//		assert uploadButton.isDisplayed();
		waitForSync();

		// insertImage);
		// driver.switchTo().defaultContent();
		// saveChanges);
		// waitForSync();
	}

	public void insertImage() {
		imageDescription.sendKeys("Test");
		click(uploadButton);
		waitForSync();
		assert imagePreviewSection.isDisplayed();

		click(insertButton);
		driver.switchTo().defaultContent();
		click(saveChanges);
	}

	public void changeImage() {

		click(embaddedImage);
		waitForSync();
		driver.switchTo().frame(1);
		imageURL.clear();
		imageURL.sendKeys("http://qa.worthpublishers.com/launchpad/myers10e/116384/Downloads/Document?id=90af730357ac43779e1cd27ff25a43ce&name=Sunset.jpg");
		imageDescription.sendKeys("Sunset");
		waitForSync();
		assert imagePreviewSection.isDisplayed();
		click(insertButton);
		driver.switchTo().defaultContent();
		click(saveChanges);
	}

	public void assignmentCreation() {
		//waitForElementToLoad(addButton, waitForElementInMilliSeconds);
		click(addButton);
		//waitForElementToLoad(createNew, waitForElementInMilliSeconds);
		click(createNew);
		//waitForSync();
		waitForElementToLoad(quiz, waitForElementInMilliSeconds);

	}

	public void quizEditing() {
		click(quiz);
		//waitForSync(5000);
		waitForElementToLoad(saveit, waitForElementInMilliSeconds);
		assert quizTitle.isDisplayed();
		assert quizSubTitle.isDisplayed();
		quizTitle.clear();
		quizTitle.sendKeys("QAIT quiz");
		quizSubTitle.clear();
		quizSubTitle.sendKeys("Automation");
		click(saveit);
		waitForSync();
	}

	public void doneQuizEditing() {
		//waitForSync();
		click(driver.findElement(By.id("fne-done")));
		//waitForSync();
		click(homeButton);
	}

	public void insertEditLink() {
		driver.switchTo().frame(writeContentFrame);
		welcomePageContentsTextBox.sendKeys("QAIT");
		click(welcomePageContentsTextBox);
		waitForSync();

			Robot robo;
			try {
				robo = new Robot();
				robo.keyPress(KeyEvent.VK_CONTROL);
				robo.keyPress(KeyEvent.VK_A);
				robo.keyRelease(KeyEvent.VK_A);
				robo.keyRelease(KeyEvent.VK_CONTROL);
				
				waitForSync();
			} catch (AWTException e) {
				e.printStackTrace();
			}
	}
	
	public void addLink(){
		//((JavascriptExecutor) driver).executeScript("document.getElementById('Contents_link'))");	
		click(linkButton);
		waitForSync();
		mceFocusTextBox.sendKeys("http://www.google.com/");
		click(insertButton);
		click(saveChanges);
	}
	
	public boolean verifyAddedLink(){
		click(addedLink);
		return driver.getTitle().trim().contains("Google");
	}

	/****************************************************************************************************/

	public void clickSettingsButton() {
		//waitForSync();
		click(settings);
		waitForSync();
	}

	public void clickLaunchpadButton() {
		//waitForSync();
		click(launchpadtab);
		waitForSync();
	}

	public void removeUnitsFromCourse() {
		waitForSync();
		click(removeUnitsLink);
		waitForElementToLoad(confirmRemove, waitForElementInMilliSeconds);
	}

	public void confirmRemovalOfItem() {
		click(confirmRemove);
			waitForSync(6000);
		}

	public void clickOnSaveButton() {
		//waitForSync();
		click(saveButton);
		waitForSync();
	}

	public void clickDoneEditingButton() {
		//waitForSync();
		click(doneEditingButton);
		waitForSync();
	}

	// public void setDateTimeField(){
	// waitForSync();
	// setDateTime);
	// waitForSync();
	// }
	public void clickAssignAgain() {
		//waitForSync();
		click(clickAssign);
		waitForSync();
	}

	public void saveAllChanges() {
		//waitForSync();
		click(saveChange);
		waitForSync();
	}

	public void clickHomeButton() {
		//waitForElementToLoad(clickHome, waitForElementInMilliSeconds);
		click(clickHome);
		waitForSync();
	}

	/****************************************************************************************************/

	public void moveToCurrentUnit() {
		List<WebElement> useInList = driver.findElements(By.xpath("(//div[@class='faceplate-move-resource-menu']/ul)[2]/li/a"));
		WebElement moveToCurrentUnit = useInList.get(1);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + moveToCurrentUnit.getLocation().y + ")");
		click(moveToCurrentUnit);
		waitForSync();
	}

	public boolean verifyCopyAddedToCurrentUnit() {
		return driver.findElement(By.xpath("(//div[@class='unit-content-wrapper']/div/div/ul/li/div/span/a[contains(text(),'Qait Test Content')])[1]")).isDisplayed();

	}

	public void checkSortByDueDate() {
		waitForSync(6000);
		waitForElementToLoad(driver.findElement(By.id("SortByDueDate")), waitForElementInMilliSeconds);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("SortByDueDate")));
		waitForSync(500);
		click(driver.findElement(By.id("SortByDueDate")));
		waitForSync();
	}

	public void checkCollapsePastDueDefault() {
		waitForSync();
		if (driver.findElement(By.id("CollapsePastDue")).isSelected()) {
			click(driver.findElement(By.id("CollapsePastDue")));
		}
		waitForSync();
	}

	public void clickSaveButton() {
		//waitForSync();
		click(clickSave);
		waitForSync();
	}

	public void checkOnCollapsePastDueMoreThan(String days) {
		//waitForSync();
		click(collapseLater);
		setDays.clear();
		setDays.sendKeys(days);
		waitForSync();
	}

	public void clickCollapseUnassigned(String catName) {
		//waitForSync();
		click(collapseUnassigned);
		categoryName.clear();
		categoryName.sendKeys(catName);
		waitForSync();
	}

	public boolean clickReturnToWindowButton() {
		//waitForSync();
		//assert returnButton.getText().trim().contains("Return to Welcome screen");
		click(returnButton);
		waitForSync(5000);
		return enterCourseLink.isDisplayed();
	}

	public void clickCalendarIcon() {
		waitForSync();

		try {

			assert calendarIcon.isDisplayed();
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('openCalendarMonth')[0]);");
		}

		catch (Exception e) {

//			click(editPageLink);
//			((JavascriptExecutor) driver).executeScript("document.getElementById('PX_HOME_FACEPLATE_START_ZONE_LEFT_Choose_').style.display=('block')");
//			waitForSync();
//			List<WebElement> listOfWidget = driver.findElements(By.xpath("//*[@id='PX_HOME_FACEPLATE_START_ZONE_LEFT_Choose_']//li[@class='widgetDisplayItem']"));
//			// System.out.println(listOfWidget.get(1).getText()); //The
//			// Economist RSS Feed
//			// System.out.println(listOfWidget.get(2).getText()); //Custom RSS
//			// Feed
//			// System.out.println(listOfWidget.get(3).getText()); //Upcoming
//			// Assignments
//			click(listOfWidget.get(3));
//			doneEditing();
			waitForElementToLoad(editPageLink);
			waitForSync(500);
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('openCalendarMonth')[0].click();");
		}

		waitForSync();
		assert monthview.getText().trim().contains("Month");
		waitForSync();

	}

	public void clickListIcon() {
		waitForSync();
		assert listview.getText().trim().contains("List");

		click(listview);
		click(clickHome);
		waitForSync();
		assert calendarIcon.isDisplayed();
		click(listviewbutton);
		click(clickHome);
		assert calendarIcon.isDisplayed();
		waitForSync();
		assert monthviewbutton.getText().trim().contains("Month view");
		click(monthviewbutton);
		waitForSync();
		assert next.isDisplayed();
		click(next);
		waitForSync();
		assert back.isDisplayed();
		click(back);
		click(clickHome);
		waitForSync();
	}

	public boolean clickEditPage() {
		//waitForSync();
		click(editPageLink);
		waitForSync();
		return courseEditHighlighted.isDisplayed();
	}

	/*
	 * public void clickToEdit(){ waitForSync();
	 * 
	 * Actions actions = new Actions(driver); //
	 * actions.moveToElement(editFurther0);
	 * actions.moveToElement(editFurther0).build().perform();
	 * 
	 * editFurther1); waitForSync(); }
	 */

	public boolean resource() {
		//waitForSync();
		waitForElementToLoad(resourcesButton, waitForElementInMilliSeconds);
		assert resourcesButton.isDisplayed();
		click(resourcesButton);
		waitForSync();
		return searchButton.isDisplayed();

	}

	public void searchBox() {
		searchButton.sendKeys("Assigned");
		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('moreResourceItem')[0].childNodes[3].childNodes[1])");
		waitForSync();
	}

	public void clickAssignButton() {
		try {
			//waitForSync();
			click(assignButton);
			waitForSync();
		} catch (Exception e) {
			//waitForSync();
			// add to unit
			click(driver.findElement(By.id("fne-add")));
			//waitForSync();
			click(assignButton);
			waitForSync();
		}
	}

	public void setDateTimeField() {
		//waitForSync();
		click(setDateTime);
		waitForSync();
	}

	public void clickResourceCloseButton() {
		//waitForSync();
		//waitForElementToLoad(crossButton, waitForElementInMilliSeconds);
		click(crossButton);
	}

	public boolean contentByChapter() {
		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementById('browseResults').childNodes[5].childNodes[3].childNodes[1])");
		// Verify that User is navigated to Content by chapter
		waitForSync();
		assert driver.findElement(By.id("moreResourcesTitleName")).getText().trim().contains("Content by chapter");
		List<WebElement> chapterList = driver.findElements(By.xpath("//div[@id='search-results']/ul/li"));

		waitForSync();
		((JavascriptExecutor) driver).executeScript("document.getElementById('search-results').childNodes[1].childNodes[1].childNodes[1])");

		return driver.findElement(By.id("moreResourcesTitleName")).getText().trim().contains("Chapter 1") && driver.findElement(By.className("resource-count")).getText().trim().contains("available items");

	}

	public void clickOnContentByTypeInUse() {

		try {
			waitForSync();
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + asd.getLocation().y + ")");
			click(asd);
			waitForSync();
		} catch (Exception e) {
			// block add link
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('lblAdd moreResourcesLabel')[0].style.display=('block')");
			// click add link
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('lblAdd moreResourcesLabel')[0])");
			waitForSync(5000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + asd.getLocation().y + ")");
			click(asd);
			waitForSync();

		}
		waitForSync();
	}

	public boolean verifyUseInElements() {
		List<WebElement> useInList = driver.findElements(By.xpath("(//div[@class='faceplate-move-resource-menu']/ul)[2]/li"));

		WebElement removeFromThisUnit = useInList.get(0);
		WebElement moveToCurrentUnit = useInList.get(1);
		WebElement addCopyToCurrentUnit = useInList.get(2);
		return removeFromThisUnit.getText().trim().contains("Remove from this unit") && moveToCurrentUnit.getText().trim().contains("Move to current unit") && addCopyToCurrentUnit.getText().trim().contains("Add copy to current unit");

	}

	public void addCopyToCurrentUnit() {
		List<WebElement> useInList = driver.findElements(By.xpath("(//div[@class='faceplate-move-resource-menu']/ul)[2]/li/a"));
		WebElement addCopyToCurrentUnit = useInList.get(2);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + addCopyToCurrentUnit.getLocation().y + ")");
		click(addCopyToCurrentUnit);
		waitForSync();
		pageTitle.clear();
		pageTitle.sendKeys("Qait Test Automation");
		//waitForSync();
		click(saveBtnCopyToCurrentUnit);
		waitForSync();
	}

	public void clickOnBreadcrumbResource() {
		waitForSync();

		((JavascriptExecutor) driver).executeScript("document.getElementById('resource-list').childNodes[1])");
		waitForSync(7000);
	}

}
