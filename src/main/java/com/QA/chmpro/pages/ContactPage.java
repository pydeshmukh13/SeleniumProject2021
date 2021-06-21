package com.QA.chmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.chmpro.base.BasePage;
import com.QA.crmpro.utils.ElementUtils;

public class ContactPage extends BasePage {
	
	
	private ElementUtils utils;
	
	
	private By createNewButton=By.xpath("//button[@class='ui linkedin button']/i[@class='edit icon']");
	private By showButton=By.xpath("//button[text()='Show Filters']");
	
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		 utils=new ElementUtils(driver);
		
	}
	
	
	public boolean isShowbuttonAvailable() {
		return utils.doIsDisplayed(showButton);
	}
	
	public CreateContactPage navigateToCreateNewContactPage() {
		utils.doClick(createNewButton);
		return new CreateContactPage(driver);
	}
	
	

}
