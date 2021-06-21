package com.QA.chmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.chmpro.base.BasePage;
import com.QA.crmpro.utils.ElementUtils;

public class CreateContactPage extends BasePage{

	public ElementUtils eleUtil;


	private By FirstName=By.name("first_name");
	private By LastName=By.name("last_name");
	private By MiddleName=By.name("middle_name");
	private By Company=By.xpath("//input[@class='search']");
	private By email=By.xpath("(//input[@name='value'])[1]");
	private By Tag=By.xpath("//div[@class='ui fluid multiple search selection dropdown']");
	private By category=By.name("category");
	private By status=By.name("status");
	private By Description=By.name("description");
	private By Savebutton=By.xpath("//button[@class='ui linkedin button']");
	private By ContactMenu=By.xpath("//span[@class='item-text' and text()='Contacts']");
	private By createNewButton=By.xpath("//button[@class='ui linkedin button']/i[@class='edit icon']");
	
	
	public CreateContactPage(WebDriver driver){
		this.driver=driver;
		eleUtil=new ElementUtils(driver);
	}
		

	public void createNewPage(String FirstName,String LastName, String MiddleName, String Company,
								String email,String Tag, String category, String status, String Description ) {

		eleUtil.doSendKeys(this.FirstName, FirstName);
		eleUtil.doSendKeys(this.LastName, LastName);
		eleUtil.doSendKeys(this.MiddleName, MiddleName);
		eleUtil.doSendKeys(this.Company, Company);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.Tag, Tag);
		eleUtil.doSendKeys(this.category, category);
		eleUtil.doSendKeys(this.status, status);
		eleUtil.doSendKeys(this.Description, Description);
	
		eleUtil.doClick(Savebutton);
		//eleUtil.moveToElementAndClick(Savebutton);
		
		eleUtil.moveToElementAndClick(ContactMenu);
		eleUtil.doClick(createNewButton);
		
		
	}
}
