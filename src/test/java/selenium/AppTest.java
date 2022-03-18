package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.Keys;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Iniciando Pruebas...");
    }

    @After
    public void tearDown() 
    {
      driver.quit();
    }

    @Test
    public void google()
    {
        String book = "HandBook Devop";
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(934, 695));
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys(book);
        searchbox.submit();       
        driver.findElement(By.linkText("Shopping")).click();
        assertNotEquals(-1, driver.getTitle().indexOf(book));
        driver.findElement(By.linkText("Imágenes")).click();
        assertNotEquals(-1, driver.getTitle().indexOf(book));
    }

    @Test
    public void amazon()
    {
        driver.get("https://www.amazon.com/");
        driver.manage().window().setSize(new Dimension(934, 695));
        driver.findElement(By.id("twotabsearchtextbox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("the phoenix project");
    }
}
