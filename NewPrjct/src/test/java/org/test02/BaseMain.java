<<<<<<< HEAD
package org.test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMain {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromiumdriver().setup();
		
		WebDriver d = new ChromeDriver();
		
		d.get("https://mim-preprod.telebright.com/");
		
		d.manage().window().maximize();
		
		d.findElement(By.id("validation-email")).sendKeys("seyauser");
		d.findElement(By.id("validation-password")).sendKeys("Test_123");
		d.findElement(By.id("login-button")).click();
		
//		WebElement Text = d.findElement(By.xpath("//*[contains(@style='Seya')]"));
//		
//		String LogUid = Text.getText();
//		System.out.println(LogUid);
		
	}
=======
package org.test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMain {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromiumdriver().setup();
		
		WebDriver d = new ChromeDriver();
		
		d.get("https://mim-preprod.telebright.com/");
		
		d.manage().window().maximize();
		
		d.findElement(By.id("validation-email")).sendKeys("seyauser");
		d.findElement(By.id("validation-password")).sendKeys("Test_123");
		d.findElement(By.id("login-button")).click();
		
//		WebElement Text = d.findElement(By.xpath("//*[contains(@style='Seya')]"));
//		
//		String LogUid = Text.getText();
//		System.out.println(LogUid);
		
	}
>>>>>>> 2dc59acdbce16efba77754286705404a5e54a24f
}