<<<<<<< HEAD
package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	
	@Test
	public void browserLaunch() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--incognito");
		
//		chromeOptions.addArguments("--disable-infobars");
//		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		
		
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.automationexercise.com/");
		
				
	}
	
	public void signIn() {
		
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")).click();
	}

}
=======
package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	
	@Test
	public void browserLaunch() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--incognito");
		
//		chromeOptions.addArguments("--disable-infobars");
//		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		
		
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.automationexercise.com/");
		
				
	}
	
	public void signIn() {
		
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")).click();
	}

}
>>>>>>> 2dc59acdbce16efba77754286705404a5e54a24f
