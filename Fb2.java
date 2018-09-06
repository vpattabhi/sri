package com.srisel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Fb2 {

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
		driver.get("https://wallethub.com/profile/test_insurance_company/");
		System.out.println("Launched browser");
		FileReader reader = new FileReader(new File("sri.properties"));

		Properties prop = new Properties();
		prop.load(reader);		
		WebElement navigation = driver.findElement(By.xpath("//div[@class='wh-rating-notes']"));
		navigation.getTagName();
		navigation.click();
		navigation.getLocation();
		
		navigation = driver.findElement(By.xpath("//div[@class='wh-rating-5stars']"));		
		navigation.click();
		
		Thread.sleep(6000);
		List<WebElement> element = driver.findElements(By.cssSelector("dropdown-list-new"));
	    for (int i = 0; i < element.size(); i++) {
	        String temp = element.get(i).getText();
	        if (temp.equals("Health")) {
	            element.get(i).click();             
	            break;
	        }
	    }
	    navigation = driver.findElement(By.xpath("//div[@class='rating health 5th star']"));
	    navigation.click();
	    Thread.sleep(1000);
	    navigation = driver.findElement(By.xpath("//textarea[@name='review_entry']"));
	    String review = "it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great it was great";
		navigation.sendKeys(review);
		
		navigation = driver.findElement(By.linkText("Submit"));
		navigation.getTagName();
		navigation.click();
		//Thread.sleep(4900);

		//driver.quit();
	

}
}
