package com.QA.crmpro.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.QA.chmpro.base.BaseTest;
import com.QA.crmpro.utils.Constants;

public class SignUpPageTest extends BaseTest{

	@BeforeClass
	public void SignUpSetUp() {
		signUp =loginPage.navigateToSignUpPage();
	}
	
	@Test(priority=1)
	public void VerifyGetPageHeaderTest() {
		String Header=signUp.getPageHeader();
		Assert.assertEquals(Header, Constants.signUp_Header);
	}
	
	
	@Test(priority=2)
	public void VerifyIsLoginLinkExist() {
		Assert.assertTrue(signUp.isLoginLinkAvailable());
	}
	
	@Test(priority=3)
	public void verifyDoSignUpTest() {
		signUp.doSignUp(prop.getProperty("email"), prop.getProperty("phone"));
	}
}
