package com.knoldus;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Test1 {
    WebDriver driver;
//WebDriver driver = new HtmlUnitDriver();

    Faker faker = new Faker();
    Date date = new Date();

    public static int randomBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public String dob() {
        GregorianCalendar calender = new GregorianCalendar();
        int year = randomBetween(1960, 2000);
        calender.set(Calendar.YEAR, year);
        int dayOfYear = randomBetween(1, calender.getActualMaximum(Calendar.DAY_OF_YEAR));
        calender.set(Calendar.DAY_OF_YEAR, dayOfYear);
        if ((calender.get(Calendar.MONTH)) <= 9) {
            return (calender.get(calender.YEAR) + "-0" + (calender.get(Calendar.MONTH) + 1) + "-" + calender.get(Calendar.DAY_OF_MONTH));
        } else if ((calender.get(Calendar.MONTH)) == 10 || (calender.get(Calendar.MONTH)) == 11 || (calender.get(Calendar.MONTH)) == 12) {
            return (calender.get(calender.YEAR) + "-" + (calender.get(calender.MONTH) + 1) + "-" + calender.get(Calendar.DAY_OF_MONTH));
        } else
            throw new RuntimeException("Invalid Date");
    }

    public int random5DigitNumber() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_linux64/chromedriver");
//         WebDriver driver = new HtmlUnitDriver();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("–-headless");
        option.setHeadless(true);
        driver = new ChromeDriver(option);

        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/");
    }

    @Test(testName = "LOGIN", priority = 1, invocationCount = 2)
    public void login() {
        String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(dob());
        System.out.println(random5DigitNumber());
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        System.out.println(firstName + " " + lastName);
        System.out.println(modifiedDate);

        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("accounts.google.com"));

//        driver.quit();
    }
}