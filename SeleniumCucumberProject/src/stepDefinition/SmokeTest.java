package stepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	
	WebDriver driver;
	
	
	@Given("^Open browser and start application$")
	public void Open_browser_and_start_application() throws Throwable {
			
		Properties prop = new Properties();		
		prop.load(new FileInputStream(System.getProperty("user.dir")+"//config.properties"));
		
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//drivers//geckodriver.exe");
			driver=new ChromeDriver();           
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
			driver=new ChromeDriver();           
		}
				
		String url=prop.getProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void I_enter_valid_username_and_valid_password(String username,String password) throws Throwable {
	   driver.findElement(By.id("email")).sendKeys(username);
	   driver.findElement(By.id("pass")).sendKeys(password);

	}
	
	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
		  driver.findElement(By.id("loginbutton")).click();
	}	
}
