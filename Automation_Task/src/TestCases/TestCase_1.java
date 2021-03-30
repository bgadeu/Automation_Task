package TestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objectrepository.AutomationPage;
import Objectrepository.ServicesPage;
import Objectrepository.SogetiHomepage;

public class TestCase_1 {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	Actions action = null;
	SogetiHomepage homePage = null;
	ServicesPage servicesPage = null;
	AutomationPage automationPage = null;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bgadeu\\Desktop\\Automation_Task\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.sogeti.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		}

	@Test
	public void testCase1() throws InterruptedException {

		
		Actions action = new Actions(driver);
		SogetiHomepage homePage = new SogetiHomepage(driver);
		ServicesPage servicesPage = new ServicesPage(driver);
		AutomationPage automationPage = new AutomationPage(driver);
       
		wait.until(ExpectedConditions.elementToBeClickable(homePage.getCookies()));
		homePage.getCookies().click();

		action.moveToElement(homePage.getServices()).moveToElement(servicesPage.getAutomation()).click().build().perform();

		assertTrue(automationPage.getAutomationScreen().isDisplayed());
		assertTrue(automationPage.getAutomationText().getText().equals("Automation"));

		action.moveToElement(homePage.getServices()).build().perform();

		if (homePage.servicesBtnSelected().getAttribute("class").contains("selected")
				&& (servicesPage.getAutomationBtnSelected().getAttribute("class").contains("selected"))) {

			assertTrue(true);

		} else {
			
			assertTrue(false);
			
		}

	}
	
	@AfterTest
	public void end() {
		
		driver.quit();
		
	}
	
}
