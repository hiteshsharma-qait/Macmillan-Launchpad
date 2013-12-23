package com.qait.automation.MacmillanLaunchpad.TestSuites;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

import com.qait.automation.report.ResultsIT;

public class TestNgExecution {
	
	ResultsIT results= new ResultsIT();
	
	@Test
    public void startTestcaseExecution() {
        List<String> file = new ArrayList<String>();
        file.add("TestNG.xml");
        TestNG testNG = new TestNG();
        testNG.setTestSuites(file);
        testNG.run();
    }
	
}
