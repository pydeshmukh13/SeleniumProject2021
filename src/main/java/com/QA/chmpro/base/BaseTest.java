package com.QA.chmpro.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.QA.chmpro.pages.ContactPage;
import com.QA.chmpro.pages.CreateContactPage;
import com.QA.chmpro.pages.HomePage;
import com.QA.chmpro.pages.LoginPage;
import com.QA.chmpro.pages.SignUpPage;

public class BaseTest {

	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public SignUpPage signUp;
	public ContactPage ContactPage;
	public CreateContactPage createcontactPage;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {

		basePage=new BasePage();
		prop=basePage.init_prop();
		String browser=prop.getProperty("browser");
		
		if(browserName!=null) {
			browser=browserName;
		}
		
		driver=basePage.init_driver(browser);
		loginPage=new LoginPage(driver);
		driver.get(prop.getProperty("url"));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
