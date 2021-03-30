package Objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SogetiHomepage {

	WebDriver driver;

	public SogetiHomepage(WebDriver driver) {

		this.driver = driver;

	}

	By acceptCookieBtn = By.className("acceptCookie");
	By servicesBtn = By.xpath("//*[@id='header']/div[1]/nav/ul/li[3]/div[1]/span");
	By servicesBtnSelected = By.xpath("//*[@id='header']/div[1]/nav/ul/li[3]");
	By worldwide = By.xpath("//*[@id='header']/div[1]/div[2]/div[2]/div[2]/span");
	By contryList = By.xpath("//*[@id='header']/div[3]/ul/li");

	
	public WebElement getCookies() {
		return driver.findElement(acceptCookieBtn);
	}

	public WebElement getServices() {
		return driver.findElement(servicesBtn);
	}

	
	public WebElement servicesBtnSelected() {
		return driver.findElement(servicesBtnSelected);
	}
	
	public WebElement getWorldwide() {
		return driver.findElement(worldwide);
	}
	
	public List<WebElement> getContryList() {
		return driver.findElements(contryList);
	}


}
