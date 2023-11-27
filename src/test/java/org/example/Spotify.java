package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class Spotify {
    private static WebDriver driver;
    @BeforeAll
    public static void before(){
        System.out.println("Inside of BeforeAll ######");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://accounts.spotify.com/en-GB/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
    }
    @AfterAll
    public static void after(){
        System.out.println("Inside of AfterALl #######");
        //driver.quit();
    }
    @BeforeEach
    public void setup(){
        System.out.println("Inside of BeforeEach setup method");
    }
    @AfterEach
    public void teardown(){
        System.out.println("Inside AfterEach teardown method");
    }
    @Test
    public void SuccessfulLogin(){
        WebElement username = driver.findElement(By.id("login-username"));
        username.clear();
        username.sendKeys("wibiler209@ksyhtc.com");
        WebElement password = driver.findElement(By.id("login-password"));
        password.clear();
        password.sendKeys("Ilovespotify2");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
}