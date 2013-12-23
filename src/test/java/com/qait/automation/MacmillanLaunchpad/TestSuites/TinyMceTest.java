package com.qait.automation.MacmillanLaunchpad.TestSuites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qait.automation.MacmillanLaunchpad.CentralLibrary.DataCentralLibrary;

public class TinyMceTest{

	DataCentralLibrary dsl = new DataCentralLibrary();
	
	@BeforeMethod(alwaysRun = true)
	public void common() {
		dsl.setUp();	
	}
	
	public void commonMethods() {
		//setUp();	
		dsl.enterIntoCourseByCourseName("Test Course_19Sep_1342");
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void entersTextIntoTinyMceEditorTest(){
		commonMethods();
		Assert.assertTrue(dsl.enterTextIntoTinyEditor());
		dsl.closeBrowser();
	}

	@Test
	public void UserInsertsAnImageTest(){
		commonMethods();
		Assert.assertTrue(dsl.insertAndEditImage());
		Assert.assertTrue(dsl.changeImageAddedByInstructor());
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.closeBrowser();
	}

	@Test(priority=1)
	public void UserVerifyInsertEditLinkTc001539(){
		commonMethods();
		Assert.assertTrue(dsl.verifyInsertEditLink());
		Assert.assertTrue(dsl.clickEnterCourse());
		dsl.closeBrowser();
	}

    @AfterMethod(alwaysRun = true)
    public void browserClose(ITestResult result){
    dsl.closeBrowserTakeScreenshotOfFailure(result);
}
}
