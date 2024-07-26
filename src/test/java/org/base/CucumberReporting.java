package org.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberReporting {
	
	public static void generateJVMReport(String json) {
		
		File file = new File("D:\\JanBatch\\TestingProject\\target");
		Configuration con = new Configuration(file, "27-06-2024");
		// To add additional data to the report
		con.addClassifications("Browser Name", "Chrome");
		con.addClassifications("Platform", "Win-11");
		
		List<String> li = new ArrayList<String>();
		li.add(json);
		
		ReportBuilder build = new ReportBuilder(li, con);
		build.generateReports();
		
	}

}
