package com.QA.crmpro.Tests;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.QA.chmpro.base.BaseTest;
import com.QA.chmpro.pages.CreateContactPage;

public class ContactPageTest extends BaseTest{
	
	

	@BeforeClass
	public void setUpcontPage() {
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		ContactPage=homePage.navigateToContactPage();

	}

	@Test
	public void verifyIsShowbuttonDosplayed() {
		Assert.assertTrue(ContactPage.isShowbuttonAvailable());
	}
	
	
	@Test
	public CreateContactPage NavigatecreatenewcontactTest() {
		createcontactPage=ContactPage.navigateToCreateNewContactPage();
		return new CreateContactPage(driver);
		
	}
}
