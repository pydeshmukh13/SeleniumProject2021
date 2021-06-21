package com.QA.crmpro.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.QA.chmpro.base.BaseTest;
import com.QA.crmpro.utils.Constants;

public class HomePageTest extends BaseTest {

	@BeforeClass
	public void homePageSetUp() {
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title=homePage.getHomePageTitle();
		System.out.println("Home Page Title Is "+title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}

	@Test(priority=2)
	public void VerifyTheGetHeaderValueTest() {
		Assert.assertTrue(homePage.getHeaderValue());
	}

	@Test(priority=6)
	public void VerifyIsAccountExistTest() {
		Assert.assertTrue(homePage.isAccountNameExist());
	}

	@Test(priority=3)
	public void VerifyIsSettingIconExistTest() {
		Assert.assertTrue(homePage.isSettingIconExist());
	}


	@Test(priority=4)
	public void VerifyLogoIsDisplayedTest() {
		Assert.assertTrue(homePage.IsLogoDisplayed());
	}

	@Test(priority=5)
	public void VerifyisSubscribeOptionAvaialableTest() {
		Assert.assertTrue(homePage.isSubScribeLogoIsExist());
	}

}
