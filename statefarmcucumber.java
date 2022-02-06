package annotation;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



public class statefarmcucumber {
	WebDriver driver = null;

	@Given("I am on state farm main page")
	public void i_am_on_state_farm_main_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.statefarm.com/");

	}
	@When("I click on the dropdown menu")
	public void i_click_on_the_dropdown_menu() {
		driver.findElement(By.id("popDropdown")).click();

	}
	@When("Assert the dropdown values")
	public void assert_the_dropdown_values() throws IOException {        
		WebElement originaldropdown = driver.findElement(By.id("popDropdown"));
		originaldropdown.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String[] originalL ;
		originalL = new String[9];

		originalL[0] = driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[1]")).getAttribute("value").trim();
		originalL[1] = driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[2]")).getAttribute("value").trim();
		originalL[2] = driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[3]")).getAttribute("value").trim();
		originalL[3] = driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[4]")).getAttribute("value").trim();
		originalL[4] = driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[5]")).getAttribute("value").trim();
		originalL[5] = driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[6]")).getAttribute("value").trim();
		originalL[6] = driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[7]")).getAttribute("value").trim();
		originalL[7] = driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[8]")).getAttribute("value").trim();
		originalL[8] = driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[9]")).getAttribute("value").trim();
     
		String[] targetList;
		targetList = new String[9];
		targetList[0]="Auto";
		targetList[1]="Homeowners";
	    targetList[2]="Condo";
		targetList[3]="Renters";
		targetList[4]="Small Business";
		targetList[5]="Life";
		targetList[6]="MedicareSupplement";
		targetList[7]="HospitalIncome";
		targetList[8]="PetInsurance";
		for (String element:targetList) {
			System.out.println(element);
		}
		FileWriter writer = new FileWriter("output.txt"); 
		for(String str:targetList) {
		  writer.write(str + System.lineSeparator());
		}
		for(String str:originalL) {
			  writer.write(str + System.lineSeparator());
			}
		writer.close();
		
	}

	@When("choose the second option in dropdown")
	public void choose_the_second_option_in_dropdown() {
		driver.findElement(By.xpath("/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[2]")).click();

	}
	@When("Enters the zipcode")
	public void enters_the_zipcode() {
		driver.findElement(By.id("quote-main-zip-code-input")).sendKeys("30024");

	}

}


