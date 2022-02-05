package tests;

import org.openqa.selenium.WebDriver;

import pageobjects.statefarmpersonaldetails;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.statefarmmainpage;

public class statefarm {
	private static WebDriver driver = null;
	//static ExtentTest test;
	//static ExtentReports report;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
	
	ExtentTest test1 = extent.createTest("statefarmtest");
	
	@BeforeTest
	public void setUpTest() {
		
		extent.attachReporter(spark);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void statefarmautoinsurance(){
    	statefarmmainpage mainpage = new statefarmmainpage(driver);
    	test1.log(Status.INFO,"Starting test case");
    	driver.get("https://www.statefarm.com/");
    	test1.pass("Navigated to statefarm.com");
    	mainpage.clickondropdown();
    	test1.pass("Clicked on the dropdown button");
    	mainpage.clickondropdownoption2();
    	test1.pass("Selected the Homeowners drop down option");
    	mainpage.typeinzipcode("55447");
    	test1.pass("Entered the zip code in zipcode textbox");
    	mainpage.getaquotebutton();
    	test1.pass("Clicked on the get quote button");
    	try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
	@AfterTest
	public void tearDownTest() {
		driver.close();
		test1.pass("Closed the browser");
		test1.info("test completed");
		extent.flush();
		System.out.println("test completed");
	}
}
