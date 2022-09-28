package stepdefination;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginhrm {
	WebDriver driver;
	
	
	
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium_Batch\\cucumberpratice.demo\\src\\test\\java\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Given("Hit Url")
	public void hit_url() {
	    
	}
	@When("I enter Valid username {string}")
	public void i_enter_valid_username(String uname){
		WebDriverWait w= new  WebDriverWait(driver, Duration.ofSeconds(50));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		WebElement username= driver.findElement(By.name("username"));
	username.sendKeys(uname);
	}
	@When("I enter Valid password {string}")
	public void i_enter_valid_password(String pass) {
		WebElement password= driver.findElement(By.name("password"));
		password.sendKeys(pass);
	}
	@When("hit enter button")
	public void hit_enter_button() {
		WebElement enter= driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		enter.click();
	}
	@Then("login should be sucessfull")
	public void login_should_be_sucessfull() {
		if(driver.getTitle().equals("OrangeHRM")) {
			assertEquals(true, true);
		}
		else
		{
			assertEquals(false, true);
		}
	}

	
	@Then("login should not be sucessfull")
	public void login_should_not_be_sucessfull() {
		if(driver.getTitle().equals("OrangeHRM")) {
			assertEquals(false, false);
		}
		else
		{
			assertEquals(true, false);
		}
	}
	

}
