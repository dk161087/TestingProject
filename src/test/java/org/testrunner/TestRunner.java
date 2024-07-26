package org.testrunner;

import org.base.CucumberReporting;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\resources\\facebook.feature"}, 
				 glue = {"org.test.step"}, 
				 dryRun = true, 
				 plugin = { "pretty", "html:D:\\JanBatch\\TestingProject\\target\\test.html",
									  "json:D:\\JanBatch\\TestingProject\\target\\test.json",
									  "junit:D:\\JanBatch\\TestingProject\\target\\test.xml" },
				 snippets=SnippetType.CAMELCASE,
				 tags = "@F1")

public class TestRunner {
	
	
	@AfterClass
	public static void reportGeneration() {
		
		CucumberReporting.generateJVMReport("D:\\JanBatch\\TestingProject\\target\\test.json");
		
	}

}
