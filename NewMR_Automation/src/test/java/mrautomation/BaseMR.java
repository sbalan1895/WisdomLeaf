<<<<<<< HEAD
package mrautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMR {

	WebDriver driver;


	@Test(priority=1)
	public void LoginMR() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mim-preprod.telebright.com/");
		driver.manage().window().maximize();
	}

	@Test(priority=2)

	public void enterCredentails() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("preprodtest");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("seya123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

//	@Test(priority=3)
//
//	public void downloadTasks() {
//
//
//		WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(3));
//		WebElement untilMenu = waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='cat__menu-left__icon fa fa-angle-down'])[1]")));
//		untilMenu.click();
//
//		driver.findElement(By.xpath("(//ul[@class='cat__menu-left__list'])[1]")).click();
//		driver.findElement(By.xpath("//li[@data-menu='download-task']")).click();
//
//		//		//li[@data-menu='download-task']
//		//		driver.findElement(By.xpath("/html/body/app-start/app-root/cat-menu-left/nav/div[2]/div/div[1]/ul/li[1]/a/text()")).click();
//
//		System.out.println("DownloadTasks page navigated successfully");
//
//
//	}
	
	@Test(priority=3)
	public void enterCustomer() throws InterruptedException {
			
//		WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement untilClear = waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='clear']")));
//		untilClear.click();
		
		driver.navigate().to(driver.getCurrentUrl());

		driver.findElement(By.xpath("//button[@name='refresh']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='clear']")).click();
		
		WebElement enterCustomer = driver.findElement(By.xpath("//span[@class='ng-tns-c67-5 p-dropdown-label p-inputtext p-placeholder ng-star-inserted']"));
		Select selectCustomer = new Select(enterCustomer);
		selectCustomer.selectByValue("//li[@aria-label='APi Group']");
		
	}

}


//	
//	ChromeOptions chromeOptions = new ChromeOptions();
//	chromeOptions.setExperimentalOption("exculdeSwitches", new String[] {"enable-automation"});
//	
//	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//	
//	chromeOptions.merge(desiredCapabilities);
=======
package mrautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMR {

	WebDriver driver;


	@Test(priority=1)
	public void LoginMR() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mim-preprod.telebright.com/");
		driver.manage().window().maximize();
	}

	@Test(priority=2)

	public void enterCredentails() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("preprodtest");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("seya123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

//	@Test(priority=3)
//
//	public void downloadTasks() {
//
//
//		WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(3));
//		WebElement untilMenu = waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='cat__menu-left__icon fa fa-angle-down'])[1]")));
//		untilMenu.click();
//
//		driver.findElement(By.xpath("(//ul[@class='cat__menu-left__list'])[1]")).click();
//		driver.findElement(By.xpath("//li[@data-menu='download-task']")).click();
//
//		//		//li[@data-menu='download-task']
//		//		driver.findElement(By.xpath("/html/body/app-start/app-root/cat-menu-left/nav/div[2]/div/div[1]/ul/li[1]/a/text()")).click();
//
//		System.out.println("DownloadTasks page navigated successfully");
//
//
//	}
	
	@Test(priority=3)
	public void enterCustomer() throws InterruptedException {
			
//		WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement untilClear = waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='clear']")));
//		untilClear.click();
		
		driver.navigate().to(driver.getCurrentUrl());

		driver.findElement(By.xpath("//button[@name='refresh']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='clear']")).click();
		
		WebElement enterCustomer = driver.findElement(By.xpath("//span[@class='ng-tns-c67-5 p-dropdown-label p-inputtext p-placeholder ng-star-inserted']"));
		Select selectCustomer = new Select(enterCustomer);
		selectCustomer.selectByValue("//li[@aria-label='APi Group']");
		
	}

}


//	
//	ChromeOptions chromeOptions = new ChromeOptions();
//	chromeOptions.setExperimentalOption("exculdeSwitches", new String[] {"enable-automation"});
//	
//	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//	
//	chromeOptions.merge(desiredCapabilities);
>>>>>>> 2dc59acdbce16efba77754286705404a5e54a24f
