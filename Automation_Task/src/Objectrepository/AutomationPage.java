package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationPage {
	
	WebDriver driver;
	
	public AutomationPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By automationScreen =  By.xpath("//*[@id='left-column']");
	By automationText =  By.xpath("//*[@id='primary_content']/div/div[2]/div/h1/span");
	By contactUs =  By.xpath("//*[@id='99a12a58-3899-4fe1-a5c7-b9065fe635b0']/h2");
	
	By firstName = By.id("4ff2ed4d-4861-4914-86eb-87dfa65876d8");
	By lastName =  By.id("11ce8b49-5298-491a-aebe-d0900d6f49a7");
	By email =  By.id("056d8435-4d06-44f3-896a-d7b0bf4d37b2");
	By phone =  By.id("755aa064-7be2-432b-b8a2-805b5f4f9384");
	By country =  By.id("e74d82fb-949d-40e5-8fd2-4a876319c45a");
	By message =  By.id("88459d00-b812-459a-99e4-5dc6eff2aa19");
	By agreeCheckbox =  By.xpath("//*[@id='863a18ee-d748-4591-bb64-ef6eae65910e']/fieldset/label/input");
	By submitBtn =  By.xpath("//*[@id='06838eea-8980-4305-83d0-42236fb4d528']/img");
	By countryDropdown = By.xpath("//*[@id='e74d82fb-949d-40e5-8fd2-4a876319c45a']");
	
	
		

	public WebElement getAutomationScreen() {
		return driver.findElement(automationScreen);
	}

	public WebElement getAutomationText() {
		return driver.findElement(automationText);
	}
	
	public WebElement getContactUs() {
		return driver.findElement(contactUs);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPhoneNummer() {
		return driver.findElement(phone);
	}
	
	public WebElement getCountry() {
		return driver.findElement(country);
	}
	
	public WebElement getMessage() {
		return driver.findElement(message);
	}
	public WebElement getCountryDropdown() {
		return driver.findElement(countryDropdown);
	}

	public WebElement getAgreeCheckbox() {
		return driver.findElement(agreeCheckbox);
	}
	
	public WebElement getSubmitBtn() {
		return driver.findElement(submitBtn);
	}

	

}
