package org.ual.selenium.hmis;

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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
public class CampusvirtualualTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@Before
	public void setUp() {

		// Using a system property to chose the browser (by jjcanada)
		// Browser as System.property: "browserWebDriver"
		// In maven, call: 
		//    run with firefox: clean test -DbrowserWebDriver=firefox
		//    run with chrome : clean test -DbrowserWebDriver=chrome 

		// System.setProperty("browserWebDriver", "firefox"); 
		String browserProperty = ""; 
		browserProperty= System.getProperty("browserWebDriver");
		
		// run headless: clean test -DbrowserWebDriver=firefox -Dheadless=true
		Boolean headless = false;
		if (System.getProperty("headless").equals("true")) {
			headless = true;
		}

		switch (browserProperty) {
		case "firefox": 
			// Firefox 
			// Descargar geckodriver de https://github.com/mozilla/geckodriver/releases
			// Descomprimir el archivo geckodriver.exe en la carpeta drivers

			// System.setProperty("webdriver.gecko.driver",  "drivers/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (headless) firefoxOptions.setHeadless(headless);
			driver = new FirefoxDriver(firefoxOptions);

			break;
		case "chrome": 
			// Chrome
			// Descargar Chromedriver de https://chromedriver.chromium.org/downloads
			// Descomprimir el archivo chromedriver.exe en la carpeta drivers

			// System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			if (headless) chromeOptions.setHeadless(headless);
			chromeOptions.addArguments("window-size=1920,1080");
			driver = new ChromeDriver(chromeOptions);

			break;

		default:
			fail("Please select a browser");
			break;
		}
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void logincampusualfail() {
		// Test name: login-campus-ual-fail
		// Step # | name | target | value
		// 1 | open | / | 
		driver.get("https://www.ual.es/");
		// 2 | setWindowSize | 842x620 | 
		driver.manage().window().setSize(new Dimension(842, 620));
		// 3 | click | linkText=Campus on-line | 
		driver.findElement(By.linkText("Campus on-line")).click();
		// 4 | click | linkText=Acceso a Campus Virtual | 
		driver.findElement(By.linkText("Acceso a Campus Virtual")).click();
		// 5 | click | linkText=Login | 
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
		driver.findElement(By.linkText("Login")).click();
		// 6 | type | name=ssousername | hola
		driver.findElement(By.name("ssousername")).sendKeys("hola");
		// 7 | type | name=password | hola
		driver.findElement(By.name("password")).sendKeys("hola");
		// 8 | click | css=.btn-primary | 
		driver.findElement(By.cssSelector(".btn-primary")).click();
		// 9 | click | css=.alert | 
		driver.findElement(By.cssSelector(".alert")).click();
		// 10 | click | css=.alert | 
		driver.findElement(By.cssSelector(".alert")).click();
		// 11 | doubleClick | css=.alert | 
		{
			WebElement element = driver.findElement(By.cssSelector(".alert"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		// 12 | assertText | css=.alert | Ha introducido un usuario y password incorrecto
		assertThat(driver.findElement(By.cssSelector(".alert")).getText(), is("Ha introducido un usuario y password incorrecto"));
	}
}
