import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyTestJavaSite {
    public static final String HOME_PAGE_URL = "http://java-online.ru/";
    static final String MY_LOGIN = "testworkp0chta@yandex.ru";
    static final String MY_PASSWORD = "Qqqq1111";
    static final WebDriver driver;
    static final WebDriverWait webdriverWaite5sec;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriverWaite5sec = new WebDriverWait(driver, 10);


    }


    @Test
    public void test1() {
        driver.get(HOME_PAGE_URL);
        webdriverWaite5sec.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Войти']"))));
        Assertions.assertTrue(driver.getTitle().equals("Java онлайн для разработчиков"));
    }

    @Test
    public void test2() {
        driver.findElement(By.xpath("//a[text()='Войти']")).click();
        driver.findElement(By.xpath("//a[text()='Войти']")).click();
        webdriverWaite5sec.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='authorization:alogin']"))));
        driver.findElement(By.xpath("//input[@id='authorization:alogin']")).sendKeys(MY_LOGIN);
        driver.findElement(By.id("authorization:apassword")).sendKeys(MY_PASSWORD);
        driver.findElement(By.name("authorization:j_idt35")).click();
        Assertions.assertTrue(driver.getTitle().equals("Личный кабинет"));

    }

    @Test
    public void test3() {
        driver.findElement(By.xpath("//a[text()='Поиск на сайте']")).click();
        Assertions.assertTrue(driver.getTitle().equals("Страница поиска по сайту"));
    }

    @Test
    public void test4() {
        driver.findElement(By.xpath("//input[@id='formFind:findText']")).sendKeys("mysql");
        driver.findElement(By.name("formFind:j_idt30")).click();
        Assertions.assertTrue(driver.findElements(By.xpath("//h4[text()='Результаты поиска']"))!=null);
    }

    @Test
    public void test5() {
        driver.close();
    }


}
