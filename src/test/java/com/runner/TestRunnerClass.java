package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.GenerateJVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(tags="@Login or @State or @City or @AddAddress or @UpdateAddress or @GetAddress or @DeleteAddress or @Search or @ChangeProfilePic" ,stepNotifications = true , publish = true , dryRun = false ,monochrome = true ,snippets = SnippetType.CAMELCASE ,plugin = {"pretty","json:target//index.json" , "rerun:src/test/resources/rerun.txt"} ,glue = "com.stepdefinition",features = "src\\test\\resources")
public class TestRunnerClass {

//	@AfterClass
//	public static void afterClass() {
//	GenerateJVMReport.jvmReport("C:\\Users\\arvin\\eclipse-workspace\\OMRBranchGroceryApiAutomation\\target\\index.json","TestRunner1");
//	}
	
}
