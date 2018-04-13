package com.elucidat.login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by : Lakshmi Nandakumar
 * Created on : 19/05/2017
 * Created at : 16:52
 */
public class ElucidatLoginTest
{
    final String correctUserName = "lakshmi.nandakumar+autotest@elucidat.com";
    final String correctPassword = "€lucid@t";


    static WebDriver driver;

    @Before
    public void startDriver()
    {
        driver = new ChromeDriver();

        final String loginUrl = "https://app.elucidat.com/account/login";
        driver.navigate().to(loginUrl);
    }

    @Test
    public void validLoginTest()
    {
        WebElement usernameField = driver.findElement(By.cssSelector("#login"));
        usernameField.sendKeys(correctUserName);

        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys(correctPassword);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Elucidat | Make a Course in minutes"));
    }

    @After
    public void closeDriver()
    {
        driver.quit();
    }
}
