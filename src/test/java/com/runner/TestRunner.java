package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cirqueBaseClass.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\surya\\eclipse-workspace\\Cirque\\src\\test\\java\\com\\featureFile\\Cirque.feature",
glue ="com.stepDefinition",
dryRun = !true,
monochrome = true,
plugin = {"pretty",
		"html:Reports/Cirque.html",
		"json:Reports/Cirque.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

//, tags = "not @Add"
 		  
)

public class TestRunner extends BaseClass {
		
	public static WebDriver driver;
	
	@BeforeClass
	public static void open() {
	     driver = browserLaunch("chrome");
	}
	
	@AfterClass
	public static void tearDown() {
		//close();
	}
		
}
