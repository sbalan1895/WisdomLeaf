<<<<<<< HEAD
package manageright_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MR_Login {
	
	WebDriver driver;

	@Test(priority=1)

	public void enterCredentails() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--incognito");
		
		chromeOptions.addArguments("--disable-infobars");
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		driver = new ChromeDriver(chromeOptions);
		driver.get("https://manageright-preprod-4.telebright.com/manageright/AdminServlet");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//input[@id='signInFormUsername'])[2]")).sendKeys("preproduser");
		driver.findElement(By.xpath("(//input[@id='signInFormPassword'])[2]")).sendKeys("tele_123");
		driver.findElement(By.xpath("(//input[@name='signInSubmitButton'])[2]")).click();

	}
	

}
=======
package manageright_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MR_Login {
	
	WebDriver driver;

	@Test(priority=1)

	public void enterCredentails() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--incognito");
		
		chromeOptions.addArguments("--disable-infobars");
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		driver = new ChromeDriver(chromeOptions);
		driver.get("https://manageright-preprod-4.telebright.com/manageright/AdminServlet");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//input[@id='signInFormUsername'])[2]")).sendKeys("preproduser");
		driver.findElement(By.xpath("(//input[@id='signInFormPassword'])[2]")).sendKeys("tele_123");
		driver.findElement(By.xpath("(//input[@name='signInSubmitButton'])[2]")).click();

	}
	

}
>>>>>>> 2dc59acdbce16efba77754286705404a5e54a24f
