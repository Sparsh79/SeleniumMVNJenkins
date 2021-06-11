package com.knoldus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Test1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/");
    }

    @Test(testName = "LOGIN", priority = 1)
    public void login() throws InterruptedException {

        //send email address
        driver.findElement(By.cssSelector("#identifierId")).click();
        driver.findElement(By.cssSelector("#identifierId")).sendKeys("email");

    }
}