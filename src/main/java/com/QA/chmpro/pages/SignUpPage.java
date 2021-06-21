package com.QA.chmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.chmpro.base.BasePage;
import com.QA.crmpro.utils.ElementUtils;

public class SignUpPage extends BasePage{
	
	
	private ElementUtils eutil;
	
	private By Email=By.name("email");
	private By Phone=By.name("phone");
	private By checkbox=By.xpath("//input[@type='checkbox']");
	//private By robocheckbox=By.xpath("//div[@class='recaptcha-checkbox-border']");
	private By sighUpbtn=By.name("action");
	private By header=By.xpath("//h2[@class='ui blue header' and text()='Register']");
	private By loginLink=By.linkText("Got an account? Log in here");
	
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		eutil=new ElementUtils(driver);
	}
	
	
	public String getPageHeader() {
		return eutil.doGetText(header);
		
	}
	
	public boolean isLoginLinkAvailable() {
		return eutil.doIsDisplayed(loginLink);
		}
	
	public void doSignUp(String email, String phone) {
		
		eutil.doSendKeys(Email, email);
		eutil.doSendKeys(Phone, phone);
		eutil.doClick(checkbox);
		eutil.doClick(sighUpbtn);
		
		//driver.findElement(robocheckbox).click();
		
	}

}
