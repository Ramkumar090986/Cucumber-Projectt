package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.sample.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources", glue="org.step",monochrome=true,
plugin= {"pretty","html:D:\\Frameworks\\SampleCucumber\\Cucumber Reports",
		
"json:D:\\Frameworks\\SampleCucumber\\Cucumber Reports\\reportJson.json",
"junit:D:\\Frameworks\\SampleCucumber\\Cucumber Reports\\reportJunit.xml"})

public class TestRunner {
	
	@AfterClass
	
	public static void JVMReportGeneration() {
		
		JVMReport.generateJVMReport("D:\\Frameworks\\SampleCucumber\\Cucumber Reports\\reportJson.json");
		
		

	}

}
