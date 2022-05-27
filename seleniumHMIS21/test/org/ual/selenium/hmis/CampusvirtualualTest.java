package org.ual.selenium.hmis;

// Generated by Selenium IDE

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.MatcherAssert.assertThat;

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
import java.time.Duration;
public class CampusvirtualualTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@BeforeEach
	public void setUp() {

		// Browser selector 
		int browser= 0; // 0: firefox, 1: chrome,...
		Boolean headless = false;

		switch (browser) {
		case 0:  // firefox
			// Firefox 
			// Descargar geckodriver de https://github.com/mozilla/geckodriver/releases
			// Descomprimir el archivo geckodriver.exe en la carpeta drivers

			System.setProperty("webdriver.gecko.driver",  "drivers/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (headless) firefoxOptions.setHeadless(headless);
			driver = new FirefoxDriver(firefoxOptions);

			break;
		case 1: // chrome
			// Chrome
			// Descargar Chromedriver de https://chromedriver.chromium.org/downloads
			// Descomprimir el archivo chromedriver.exe en la carpeta drivers

			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
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
	@AfterEach
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void logincampusualfail() {
		// Test name: login-campus-ual-fail
		// Step # | name | target | value
		// 1 | open | / | 
		driver.get("https://www.ual.es/");
	    // 2 | setWindowSize | 1251x740 | 
	    driver.manage().window().setSize(new Dimension(1251, 740));
	    
	    // Bloque de pulsar a boton aceptar, por si aparece 
	    try {
	        Thread.sleep(1000);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    
	    // | storeXpathCount | xpath=//button[contains(.,'Guardar')] | botonGuardar
	    vars.put("botonGuardar", driver.findElements(By.xpath("//button[contains(.,\'Guardar\')]")).size());
	    // | echo | boton ${botonGuardar} | 
	    System.out.println("boton "+ vars.get("botonGuardar").toString());
	    // | if | ${botonGuardar}>0 | 
	    if ((Boolean) js.executeScript("return (arguments[0]>0)", vars.get("botonGuardar"))) {
	      // | click | css=.btn-accept | 
	      driver.findElement(By.cssSelector(".btn-accept")).click();
	      // | end |  | 
	    }

		// 3 | click | linkText=Campus on-line | 
		driver.findElement(By.linkText("Campus on-line")).click();
		// 4 | click | linkText=Acceso a Campus Virtual | 
		driver.findElement(By.linkText("Acceso a Campus Virtual")).click();
		// 5 | click | linkText=Login | 
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
