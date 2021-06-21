package com.QA.chmpro.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.QA.crmpro.utils.OptionManagerUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public OptionManagerUtil optionmanager;

	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize the browser
	 * @param browser
	 * @return This method return webDriver driver.
	 */
	public WebDriver init_driver(String browser) {

		optionmanager=new OptionManagerUtil(prop);

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			if(Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			}
			else{		
				//driver=new ChromeDriver();
				tldriver.set(new ChromeDriver(optionmanager.getChromeOptions()));
			}
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			if(Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox");
			}
			else{		
				//driver=new ChromeDriver();
				tldriver.set(new FirefoxDriver(optionmanager.getFirefoxOptions()));
			}
			//driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("Safari")) {
			//driver=new SafariDriver();
			tldriver.set(new SafariDriver());
		}
		else
		{
			System.out.println("Please Pass The Correct Browser Value..."+browser);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return getDriver();
	}

	private void init_remoteDriver(String browser) {
		
		System.out.println("Test cases Run on Remote....");
		
		if(browser.equals("chrome")) {
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, optionmanager.getChromeOptions());
			
			try {
				tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(browser.equals("firefox")) {
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionmanager.getFirefoxOptions());
			
			try {
				tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 

	}

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}


	/**
	 * This method is used to load properties from config.properties file
	 * @return it return properties prop reference
	 */

	public Properties  init_prop() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/main/java/com/QA/crmpro/config/config.properties file");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	/**
	 * This method is used to take the Screenshot
	 * @return It will return the Path of the Screenshot
	 */

	public String getScreenShot() {
		File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+ "/screenshot/" +System.currentTimeMillis() + ".png";
		File destination=new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;	
	}
}
