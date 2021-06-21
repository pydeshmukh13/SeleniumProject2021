package com.QA.crmpro.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.QA.chmpro.base.BaseTest;
import com.QA.crmpro.utils.Constants;
import com.QA.crmpro.utils.ExcelUtils;

public class CreateContactPageTest extends BaseTest{


	@BeforeClass
	public void CreateNewConatctSetUp() throws InterruptedException {
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		ContactPage=homePage.navigateToContactPage();
		Thread.sleep(5000);
		createcontactPage=ContactPage.navigateToCreateNewContactPage();
		
	}

	@DataProvider
	public Object[][] getDataDP() {
		Object data [][]=ExcelUtils.getTestData(Constants.CreateNewContact_Sheet_Name);
		return data;
	
	}
	
	
	@Test(dataProvider= "getDataDP")
	public void creteNewContactTest(String FirstName,String LastName,String MiddleName,
			String Company,String email,String Tags,String category,String status,String Description)  {
		
		createcontactPage.createNewPage(FirstName,LastName,MiddleName,Company,email,Tags,category,status,Description ) ;

	}

	

}
