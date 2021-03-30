package TestCases;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objectrepository.SogetiHomepage;

public class TestCase_3 {
	
	WebDriver driver = null;
	WebDriverWait wait = null;

	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bgadeu\\Desktop\\Automation_Task\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.sogeti.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		
		}

	@Test
	public void testCase3() throws InterruptedException {

		SogetiHomepage homePage = new SogetiHomepage(driver);


		wait.until(ExpectedConditions.elementToBeClickable(homePage.getCookies()));
		homePage.getCookies().click();

		homePage.getWorldwide().click();
		List<WebElement> countryList = homePage.getContryList();

		for (WebElement country : countryList) {

			String ville = country.getText();
			Set<String> windows;
			Iterator<String> iteretor;
			String parentId, childId;

			switch (ville) {

			case "BELGIUM":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("Belgium"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "FINLAND":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("Finland"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "FRANCE":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("France"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "GERMANY":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);


				assertTrue(driver.getTitle().contains("Deutschland"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "IRELAND":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("Ireland"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "LUXEMBOURG":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("Luxembourg"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "NETHERLANDS":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("We Make Technology Work"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "NORWAY":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("Norge"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "SPAIN":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("España"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "SWEDEN":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("Sverige"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "UK":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("Sogeti UK"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
				
			case "USA":
				country.click();
				windows = driver.getWindowHandles();
				iteretor = windows.iterator();
				parentId = iteretor.next();
				childId = iteretor.next();
				driver.switchTo().window(childId);

				assertTrue(driver.getTitle().contains("USA"));
				driver.close();
				driver.switchTo().window(parentId);
				break;
			}

		}

	}
	
	@AfterTest
	public void end() {
		
		driver.quit();
		
	}

}
