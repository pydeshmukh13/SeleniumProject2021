package com.QA.chmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.chmpro.base.BasePage;
import com.QA.crmpro.utils.Constants;
import com.QA.crmpro.utils.ElementUtils;

public class HomePage extends BasePage {

	private ElementUtils eleutil;

	private By AccName=By.xpath("//span[@class='user-display']");
	private By settingIcon=By.xpath("//i[@class='settings icon']");
	private By dealheader=By.xpath("//div[text()='Deals']");
	private By Logo=By.xpath("//div[@class='header item']");
	private By subscribeIcon=By.xpath("//div[@class='onesignal-bell-launcher-button']");
	private By ContactMenu=By.xpath("//span[@class='item-text' and text()='Contacts']");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		eleutil =new ElementUtils(driver);
	}

	public String getHomePageTitle() {
		return eleutil.waitForTitlePresent(Constants.Home_Page_Title, 10);
	}

	public boolean getHeaderValue() {
		return eleutil.doIsDisplayed(dealheader);
	}

	public boolean isSettingIconExist() {
		return eleutil.doIsDisplayed(settingIcon);
	}

	public boolean isAccountNameExist() {
		return eleutil.doIsDisplayed(AccName);
	}
	public boolean IsLogoDisplayed() {
		return eleutil.doIsDisplayed(Logo);

	}
	
	public boolean isSubScribeLogoIsExist() {
		return eleutil.doIsDisplayed(subscribeIcon);
	}
	
	public ContactPage navigateToContactPage() {
		eleutil.moveToElementAndClick(ContactMenu);
		return new ContactPage(driver);
	}

	
	
	
	
}
