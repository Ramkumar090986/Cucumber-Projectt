package org.sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport extends BaseClass {
	
	public static void generateJVMReport(String json) {
		
		File file=new File("D:\\Frameworks\\SampleCucumber\\Cucumber Reports");
		
		Configuration configuration=new Configuration(file, "Facebook");
		
		configuration.addClassifications("Browser", "Chrome");
		
		configuration.addClassifications("Platform", "Windows");
		
		configuration.addClassifications("Version", "10");
		
		configuration.addClassifications("Sprint", "53");
		
		List<String>li=new ArrayList<String>();
		
		li.add(json);
		
		ReportBuilder builder=new ReportBuilder(li, configuration);
		
		builder.generateReports();

	}

}
