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
	//initializing driver for class
	private static WebDriver driver = null;
	//Crearing a new extent report
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
	
	ExtentTest test1 = extent.createTest("statefarmtest");
	
	@BeforeTest
	public void setUpTest() {
		//Setting up chrome driver
		extent.attachReporter(spark);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void statefarmautoinsurance(){
		 //Creating object for statefarmmainpage class
		statefarmmainpage mainpage = new statefarmmainpage(driver);
		test1.log(Status.INFO,"Starting test case");
		//Opening statefarm.com in browser
    	        driver.get("https://www.statefarm.com/");
    	        test1.pass("Navigated to statefarm.com");
                //Clicking on category dropdown
    	        mainpage.clickondropdown(); 
    	        test1.pass("Clicked on the dropdown button");
		//Clicking on the Homeowners drop down option
    	        mainpage.clickondropdownoption2();
    	        test1.pass("Selected the Homeowners drop down option");
		//Entering the zip code in zipcode textbox
    	        mainpage.typeinzipcode("55447");
    	        test1.pass("Entered the zip code in zipcode textbox");
		//Clicking on the get quote button
    	        mainpage.getaquotebutton();
    	        test1.pass("Clicked on the get quote button");
    	       
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
