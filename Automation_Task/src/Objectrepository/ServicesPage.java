package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ServicesPage {
	
	WebDriver driver;

	public ServicesPage(WebDriver driver) {

		this.driver = driver;

	}
	
	By automationBtn = By.xpath("//*[@id='header']/div[1]/nav/ul/li[3]/div[2]/ul/li[4]/a");
	By automationBtnSelected = By.xpath("//*[@id='header']/div[1]/nav/ul/li[3]/div[2]/ul/li[4]");
	
	public WebElement getAutomation() {
		return driver.findElement(automationBtn);
	}
	
	public WebElement getAutomationBtnSelected() {
		return driver.findElement(automationBtnSelected);
	}
	
}
