package pageobjects;

//import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class statefarmmainpage {

	private WebDriver driver;//intializing webdriver as a class object
	

	@FindBy(how = How.ID,using = "popDropdown")
	private WebElement dropdown;  
	
	@FindBy(how = How.XPATH,using = "/html/body/div[8]/section[1]/div/div[1]/div/div/div/div/form/div/select/option[2]")
	private WebElement dropdownoption2;  
	
	@FindBy(how = How.ID,using = "quote-main-zip-code-input")
	private WebElement zipcodetextbox;

	@FindBy(how = How.ID,using = "quote-main-zip-btn")
	private WebElement quotebutton;
	
	public statefarmmainpage(WebDriver driver) {//Taking the input driver as the functioning driver to be used everytime the class is called

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickondropdown(){//Action-clicking on the category dropdown
		dropdown.click();
	}
	public void clickondropdownoption2() {//Action-clicking on the homeowner option in dropdown
		dropdownoption2.click();
	}
	public void typeinzipcode(String text) {//Action-typing in the zipcode
		zipcodetextbox.sendKeys(text);
	}
	public void getaquotebutton() {//Action-clicking the quote button
		quotebutton.click();
	}
    
}
