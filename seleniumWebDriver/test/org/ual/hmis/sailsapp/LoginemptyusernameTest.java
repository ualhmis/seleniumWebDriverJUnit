package org.ual.hmis.sailsapp;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LoginemptyusernameTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@Before
	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe"); 

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 

		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void loginemptyusername() {
		driver.get("http://localhost:1337/");
		driver.manage().window().setSize(new Dimension(780, 824));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).sendKeys("asfasf");
		driver.findElement(By.cssSelector(".ajax-button")).click();
		driver.findElement(By.cssSelector(".invalid-feedback")).click();
		driver.findElement(By.cssSelector(".invalid-feedback")).click();
		{
			WebElement element = driver.findElement(By.cssSelector(".invalid-feedback"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".invalid-feedback"));
			assert(elements.size() > 0);
		}
	}
}
