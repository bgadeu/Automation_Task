package TestCases;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objectrepository.AutomationPage;
import Objectrepository.ServicesPage;
import Objectrepository.SogetiHomepage;

public class TestCasesRegressionstest {
	
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

		WebDriverWait wait = new WebDriverWait(driver, 5);
		

		action = new Actions(driver);
		homePage = new SogetiHomepage(driver);
		servicesPage = new ServicesPage(driver);
		automationPage = new AutomationPage(driver);
       
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
	
	@Test
	public void testCase2() throws InterruptedException {

		
	
		action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		servicesPage = new ServicesPage(driver);
		automationPage = new AutomationPage(driver);
		
		Random random = new Random();
		String [] firstNames = {"Lewis", "Aaron", "Michael", "Gerd", "Noah"};
		String [] lastNames = {"Müller", "Friedrich", "Knie", "Fischer", "Hamilton"};
		String [] telefonNummers = {"01234567", "02349879", "02349123", "09432123", "0564393"};
		String firstName = null;
		String lastName = null;
		String email = null;
		String message = null;
		String telefonNummer = null;
		
       
//		wait.until(ExpectedConditions.elementToBeClickable(homePage.getCookies()));
//		homePage.getCookies().click();

		action.moveToElement(homePage.getServices()).moveToElement(servicesPage.getAutomation()).click().build().perform();
//		wait.until(ExpectedConditions.visibilityOf(automationPage.getContactUs()));

		
		js.executeScript("arguments[0].scrollIntoView();",automationPage.getContactUs());
		wait.until(ExpectedConditions.visibilityOf(automationPage.getContactUs()));
//		Thread.sleep(3000);
		
		
		firstName = firstNames[random.nextInt(5)];
		lastName = lastNames[random.nextInt(5)];
		telefonNummer= telefonNummers[random.nextInt(5)];		
//		email = firstName + "." + lastName + "@yahoo.de";
		email ="gadeubrice@yahoo.fr";
		message = "message " + firstName + " " + lastName +" "+ telefonNummer;
		
		automationPage.getFirstName().sendKeys(firstName);
		automationPage.getLastName().sendKeys(lastName);
		automationPage.getEmail().sendKeys(email);
		automationPage.getPhoneNummer().sendKeys(telefonNummer);
		
		Select dropdown = new Select(automationPage.getCountryDropdown());
		dropdown.selectByIndex(random.nextInt(5));
		
		automationPage.getMessage().sendKeys(message);
		automationPage.getAgreeCheckbox().click();
		automationPage.getSubmitBtn().click();
		assertTrue(false);
		
//		driver.quit();
		
		// T O D O
		/*WebElement frames = driver.findElement(By.xpath("//*[@id='c0706cb4-c58d-4c20-835a-a327a013a48f']/div/div/div/iframe"));
		driver.switchTo().frame(frames);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'recaptcha-anchor\']/div[1]")).click();		
		driver.switchTo().defaultContent();
		frames = driver.findElement(By.xpath("//*[@id='pageTop']/div[4]/div[4]/iframe"));
		driver.switchTo().frame(frames);		
		Thread.sleep(3000);
		driver.findElement(By.id("recaptcha-audio-button")).click();
		Thread.sleep(3000);
//		driver.switchTo().defaultContent();
//		
//		frames = driver.findElement(By.xpath("//*[@id='pageTop']/div[4]/div[4]/iframe"));		
//		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/button")).click();
		driver.findElement(By.id(":2")).click();
		
		String src = driver.findElement(By.id("audio-source")).getAttribute("src");*/
		
	}
	
	@Test
	public void testCase3() throws InterruptedException {

		homePage = new SogetiHomepage(driver);


//		wait.until(ExpectedConditions.elementToBeClickable(homePage.getCookies()));
//		homePage.getCookies().click();

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
