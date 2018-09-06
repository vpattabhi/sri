package com.srisel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Fb {

	public static void main (String[] args) throws Exception {

		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile testprofile = profile.getProfile("pchu");
		testprofile.setPreference("dom.webnotifications.enabled", false);
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE, testprofile);
		FirefoxOptions opt = new FirefoxOptions();
		opt.merge(dc);
		WebDriver driver =  new FirefoxDriver(opt);
		
		
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		System.out.println("Launched browser");
		 FileReader reader = new FileReader(new File("sri.properties"));
		
		Properties prop = new Properties();
		prop.load(reader);
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.id("email") );
		email.click();
		email.clear();
		Thread.sleep(1200);
		email.sendKeys(prop.getProperty("fb_id","srilakshmi.30b@gmail.com").toString());
		Thread.sleep(3000);
		WebElement pwd = driver.findElement(By.id("pass"));
		System.out.println("pwd is found");
		pwd.sendKeys(prop.getProperty("fb_pwd","urfool").toString()+ Keys.ENTER);
		Thread.sleep(4900);
	
		//posting on the wall
		//WebElement navigation = driver.findElement(By.id("toolbarContainer"));
		WebElement navigation = driver.findElement(By.xpath("//div[@class='linkWrap noCount']"));
		navigation.click();
		System.out.println("ok till posting");
		//WebElement wr = driver.findElement(By.id("js_4u"));
		
		WebElement wr = null;
		try
		{
			wr = driver.findElement(By.id("js_4"));
		}
		catch(Exception ex)
		{
			wr = null;
		}
		if( wr == null)
		{
			wr = driver.findElement(By.id("clearfix _ikh"));
		}
		wr.click();
		Thread.sleep(1400);
		wr = driver.findElement(By.xpath("//div[@class='_1mf _1mj']"));
		wr.click();
		Thread.sleep(1100);
		wr.sendKeys("Happy Teachers Day");
		//react-composer-post-button
		wr = driver.findElement(By.linkText("Share"));
		wr.click();
		
		//WebElement navigation = driver.findElement(By.id("logoutMenu"));
		//WebElement logout = driver.findElement(By.xpath("//div[@id='u_d_1']/div/div/div/div/div/ul/li[12]/a/span/span"));

		//navigation.click();
		//if (logout.isEnabled() && (logout.isDisplayed()))
		{
			//logout.click();
			//}
			//else {
			//System.out.println("element not found");				
			//}


			WebElement elem = driver.findElement(By.id("pageLoginAnchor"));
			if(elem != null)
			{
				//elem.click();
				System.out.println(elem.getText());
			}
			Thread.sleep(4000);
			driver.findElement(By.linkText("Log out")).click();
			System.out.println("Logout successfully");
			Thread.sleep(2000);
			driver.quit();
		}

	}
}
