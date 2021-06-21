package com.QA.crmpro.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.QA.chmpro.base.BaseTest;
import com.QA.crmpro.utils.Constants;

public class LoginPageTest extends BaseTest{

	@Test(priority=1)
	public void VerifyTheTitleOfLoginPageTest() {
		String Title=loginPage.getLoginPageTitle();
		Assert.assertEquals(Title, Constants.Login_Page_Title);
	}

	@Test(priority=2)
	public void VerifyTheForgorLinkTest() {

		boolean link=loginPage.isForgetpasswordLinkExist();
		Assert.assertTrue(link);
	}

	@Test(priority=3)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
