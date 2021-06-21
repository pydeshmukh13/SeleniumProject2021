package com.QA.crmpro.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManagerUtil {
	
	private Properties prop;
	public ChromeOptions co;
	private FirefoxOptions fo;
	
	public OptionManagerUtil(Properties prop) {
		
		this.prop=prop;
	}
	
	

	public  ChromeOptions getChromeOptions() {
		
		co=new ChromeOptions();
		
		if(prop.getProperty("headless").trim().equals(true)) {
			co.addArguments("--headless");
		}
		
		if(prop.getProperty("incongnito").trim().equals(true)) {
			co.addArguments("--incongnito");
		}
			
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo=new FirefoxOptions();
		
		if(prop.getProperty("headless").trim().equals(true)) {
			fo.addArguments("--headless");
		}
		
		if(prop.getProperty("incongnito").trim().equals(co)) {
				fo.addArguments("--incongnito");
		}
			
		return fo;
	}

}
