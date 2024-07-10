package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class GenerateJVMReport {
	
	public static void jvmReport(String jsonFile,String targetName) {
	File file = new File("C:\\Users\\arvin\\eclipse-workspace\\OMRBranchGroceryApiAutomation\\target"+targetName);
	
	Configuration configuration= new Configuration(file, "OMR Branch Grocery API Automation Project");
	
	configuration.addClassifications("Browser", "Chrome");
	configuration.addClassifications("BrowserVersion", "144");
	configuration.addClassifications("OS", "Win 11");
	configuration.addClassifications("Sprint", "34");
	
	List<String> jsonFiles = new ArrayList<> ();
	jsonFiles.add(jsonFile);
	
	ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
	
	builder.generateReports();
}
}