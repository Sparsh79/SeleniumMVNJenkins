package com.knoldus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Otp {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        String URL = "https://accounts.google.com/";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void fetchOTP(){
        RestAssured.baseURI ="https://kvdb.io/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","text/plain");
        Response response = httpRequest.request(Method.GET,"Q8nDDaDMsN1Ney6kVysVxM/9997180989");
        String responseBody = response.asPrettyString();
        System.out.println(responseBody);
        int status = response.getStatusCode();
        Assert.assertEquals(status, 200);
        String otp = responseBody.replaceAll("[^0-9]", "");
        System.out.println(otp);
    }

    @Test
    public void loginTest() throws InterruptedException {
        //email
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("sparsh.bhardwaj@knoldus.com");
        driver.findElement(By.cssSelector("button[class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")).click();
        //password
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("sparsh10!");
        driver.findElement(By.cssSelector("button[class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")).click();
        // 2FA, select sms option
        Thread.sleep(5000);
//        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-dgl2Hf ksBjEc lKxP2d uRo0Xe TrZEUc lw1w4b"))).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-dgl2Hf ksBjEc lKxP2d uRo0Xe TrZEUc lw1w4b']")));
//        driver.findElement(By.cssSelector("button[class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-dgl2Hf ksBjEc lKxP2d uRo0Xe TrZEUc lw1w4b']")).click();
//        driver.findElement(By.cssSelector("div[class='R1xbyb']")).click();
    }

}
