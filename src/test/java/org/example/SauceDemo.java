package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class SauceDemo {

    private static WebDriver driver;

    @BeforeAll
    public static void before(){
        System.out.println("Inside of BeforeAll ######");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
    }

    @AfterAll
    public static void after(){
        System.out.println("Inside of AfterALl #######");
        WebElement hambMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        hambMenuButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logoutButton.click();
        driver.quit();
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
    public void LoginValidCredentials(){
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        Assertions.assertTrue(shoppingCart.isDisplayed());
    }

    @Test
    public void LoginInvalidCredentials(){
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce123");
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assertions.assertTrue(errorElement.isDisplayed());
    }
}
