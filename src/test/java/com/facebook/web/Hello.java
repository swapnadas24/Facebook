package com.facebook.web;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Hello {

    WebDriver driver;

    @Test
    public void hello() throws InterruptedException {
        driver = new SafariDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='_6ltg']//a[@role='button']")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("abc");
        driver.findElement(By.name("lastname")).sendKeys("das");
        driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("das@gmail.com");
        driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']")).sendKeys("das@gmail.com");
        driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys("12345");

        WebElement x = driver.findElement(By.xpath("//select[@aria-label='Day']"));

        Select dropdown = new Select(x);

        List<WebElement> options = driver.findElements(By.xpath("//select[@aria-label='Day']/option"));

        // Generate a random index within the range of available options
        Random rand = new Random();
        int randomIndex = rand.nextInt(options.size());

        dropdown.selectByIndex(randomIndex);
    }

    @AfterTest
    public void quit() {

        // driver.quit();

    }

}
