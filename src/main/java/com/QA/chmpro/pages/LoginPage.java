package com.QA.chmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.chmpro.base.BasePage;
import com.QA.crmpro.utils.Constants;
import com.QA.crmpro.utils.ElementUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;


public class LoginPage extends BasePage{

	
	private ElementUtils eleutil;

	private By emailTextField=By.name("email");
	private By passwordTextField=By.name("password");
	private By loginbtn=By.xpath("//div[text()='Login']");
	private By forgetPasswordLink=By.linkText("Forgot your password?");
	private By signUpLink=By.xpath("//a[text()='Sign Up']");

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtils(driver);
	}

	public String getLoginPageTitle() {
		return eleutil.waitForTitlePresent(Constants.Login_Page_Title, 20);

	}

	public boolean isForgetpasswordLinkExist() {
		return eleutil.doIsDisplayed(forgetPasswordLink);
	}

	public SignUpPage navigateToSignUpPage() {
		eleutil.doClick(signUpLink);
		return new SignUpPage(driver);
		
		
	}

	public HomePage doLogin(String userName, String passWord) {
		System.out.println("Login With :"+userName+ "and"+passWord);
		eleutil.doSendKeys(emailTextField, userName);
		eleutil.doSendKeys(passwordTextField, passWord);
		eleutil.doClick(loginbtn);

		return new HomePage(driver);
	}
}
