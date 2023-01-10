package com.ewizsaas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegistrationPage {

	@Test
	public void veriifyRegistrationField() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/java software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://beta.ewizsaas.com/Customer/Register");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("IndividualDetailsFirstName")).sendKeys("Rohit");
		driver.findElement(By.id("IndividualDetailsLastName")).sendKeys("Gomase");
		driver.findElement(By.id("IndividualDetailsEmailAddress")).sendKeys("rohit@gmail.com");
		driver.findElement(By.id("IndividualUserName")).sendKeys("rohitgomase2");
		driver.findElement(By.xpath("//input[@id='IndividualDetailsPhone']")).sendKeys("1234567890");
		driver.findElement(By.id("IndExtensionNo")).sendKeys("1234");
		driver.findElement(By.id("IndividualDetailsFax")).sendKeys("4561237892");

		Select sc = new Select(driver.findElement(By.id("Gender")));
		sc.selectByValue("Male");

		driver.findElement(By.xpath("//button[@id='btnSubmitIndividual']")).click();

		String popup = driver.findElement(By.className("modal-content")).getText();
		System.out.println(popup);

		String val_msg = driver.findElement(By.className("modal-body")).getText();
		System.out.println(val_msg);

		driver.findElement(By.xpath("//span[normalize-space()='Ok']")).click();
		Thread.sleep(2000);
		driver.close();

	}
}
