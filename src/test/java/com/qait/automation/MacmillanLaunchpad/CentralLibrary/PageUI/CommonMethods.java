package com.qait.automation.MacmillanLaunchpad.CentralLibrary.PageUI;

import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonMethods{



	public static int waitForElementInMilliSeconds;
	public static String schoolName = "SN Barnard College (New York, NY)";
	public static String termValue = "Fall 2012";
	public static String instructorName = "Instructor, Joe Test";
	public static String courseValue = "Test Course_12Jun_214";
	public static String courseURL;
	public  String courseURL1;
	public static String currentWindowHandle;
	public String timeCreated;
	public static String itemCreated = "TestQuizTc001579_11Jul_1230";
	public static String selectedTopic;
	//Driver initialization
	public WebDriver driver;

	public CommonMethods(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void log() {
		System.out.println("RUNNING TESTS ON " + this.getClass());
	}

	//	public void loginAs(String userType) {
	//		driver.navigate().to("http://pr.whfreeman.com/beta/hillis1e/portal");
	//		if (userType.equalsIgnoreCase("instructor")) {
	//			loginPage.loginAsInstructor();
	//		} else if (userType.equalsIgnoreCase("student")) {
	//			loginPage.loginAsStudent();
	//		}
	//	}





	public void waitForSync(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForSync() {
		waitForSync(2000);
	}

	public void waitForElementToLoad(WebElement seleniumFindExpression, int waitInMilliSeconds) {
		waitInMilliSeconds=100000;
		long now = new Date().getTime();
		long endTime = now + waitInMilliSeconds;
		while (now < endTime) {
			try {
				seleniumFindExpression.isDisplayed();
			} catch (NoSuchElementException e) {
				now = new Date().getTime();
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
				continue;
			} catch (ElementNotVisibleException e){
				now = new Date().getTime();
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
				continue;
			}
			break;
		}
		if (now > endTime) {
			throw new IllegalStateException("could not find element "
					+ seleniumFindExpression.toString() + " within "
					+ waitInMilliSeconds + "ms.");
		}
	}

	public void waitForElementToEnable(WebElement seleniumFindExpression, int waitInMilliSeconds) {
		long now = new Date().getTime();
		long endTime = now + waitInMilliSeconds;
		while (now < endTime) {
			try {
				seleniumFindExpression.isEnabled();
			} catch (NoSuchElementException e) {
				now = new Date().getTime();
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
				continue;
			}
			break;
		}
		if (now > endTime) {
			throw new IllegalStateException("could not find element "
					+ seleniumFindExpression.toString() + " within "
					+ waitInMilliSeconds + "ms.");
		}
	}
	
	public void waitForElementToLoad(WebElement seleniumFindExpression) {
		int waitInMilliSeconds=100000;
		long now = new Date().getTime();
		long endTime = now + waitInMilliSeconds;
		while (now < endTime) {
			try {
				seleniumFindExpression.isDisplayed();
			} catch (NoSuchElementException e) {
				now = new Date().getTime();
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
				continue;
			} catch (ElementNotVisibleException e){
				now = new Date().getTime();
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
				continue;
			}
			break;
		}
		if (now > endTime) {
			throw new IllegalStateException("could not find element "
					+ seleniumFindExpression.toString() + " within "
					+ waitInMilliSeconds + "ms.");
		}
	}


	

	public void click(WebElement seleniumFindExpression){
		waitForElementToLoad(seleniumFindExpression);
		for(int i = 0; i<30; i++){
			try{
				if(driver.findElement(By.cssSelector(".toast.toast-success")).isDisplayed()|
						driver.findElement(By.className("ui-widget-overlay")).isDisplayed()|
						driver.findElement(By.id("loadingBlockResources")).isDisplayed())
				waitForSync(500);
			}
			catch(NoSuchElementException e){
				break;
			}
			
		}
		try{
			seleniumFindExpression.click();
		}
		catch(Exception w){
			//waitForElementToLoad(seleniumFindExpression);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seleniumFindExpression);
			waitForSync(1000);
			seleniumFindExpression.click();
		}
	}

	public String replaceString(String str, int with) {
		return str.replace("%", Integer.toString(with));
	}

	public String replaceString(String str, String with) {
		return str.replace("%", with);
	}

	public String replaceString(String str, String toReplacePercentile, String toReplaceHash) {
		return str.replace("%", toReplacePercentile).replace("#", toReplaceHash);
	}

	public void scrollElementToView(WebDriver driver,String className, String index) {
		String toExecute = "var elem = document.getElementsByClassName('"+className+"')["+index+"];if( document.createEvent ) { var evObj = document.createEvent('MouseEvents');evObj.initEvent( 'click', true, false );elem.dispatchEvent(evObj);} else if( document.createEventObject ) {elem.fireEvent('onclick');}";
		((JavascriptExecutor) driver)
		.executeScript(toExecute);
	}

	public void scrollElementToView(WebDriver driver,String id) {
		String toExecute = "var elem = document.getElementById('"+id+"');if( document.createEvent ) { var evObj = document.createEvent('MouseEvents');evObj.initEvent( 'click', true, false );elem.dispatchEvent(evObj);} else if( document.createEventObject ) {elem.fireEvent('onclick');}";
		((JavascriptExecutor) driver)
		.executeScript(toExecute);
	}

	public void scrollForChrome(WebElement we){
		((JavascriptExecutor) 
				driver).executeScript("arguments[0].scrollIntoView();", we); 
	}

	public String randomNo(int min, int max){
		return Integer.toString(((int)(Math.random() * (max - min) + min)));
	}

	public void waitForSpinerToDisapper(){
		for(int i=0;i<10;i++){
			try{
				((JavascriptExecutor) driver).executeScript("(document.getElementById('loadingBlockResources').style.display==('block'))" );
				waitForSync();
			}
			catch(Exception e){
				break;
			}
		}
	}

	public WebElement waitForElementDisplayed(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 30 );
		return wait.until(ExpectedConditions.visibilityOf(element));
	}


	boolean clickOnElement(WebElement webElement){

		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", webElement);
		} catch (Exception e) {

		}

		webElement.click();
		return true;
	}





	//	public void tearDown(){
	//		try{
	//			driver.close();
	//			exitBrowser();
	//		} catch (UnreachableBrowserException e){}
	//		catch (SessionNotFoundException e){}
	//	}




	//	public  boolean browseThePortalURL(String url, String browser,String title) {
	//		Browser = browser;
	//		URL = url;
	//		checkBrowser(browser);
	//		driver.manage().window().maximize();
	//		driver.get(url);
	//		return currentTitle().equalsIgnoreCase(title);
	//	}





	public  void exitBrowser() {
		driver.quit();
	}

	public void closeBrowser(){
		driver.close();
	}


	//	public  String currentTitle(){
	//		return driver.getTitle().trim();
	//	}

}
