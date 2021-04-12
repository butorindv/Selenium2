import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CRMTest {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";

    private static final WebDriver driver;
    private static final WebDriverWait webdriverWaite5sec;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriverWaite5sec = new WebDriverWait(driver, 5);

    }

    public static void main(String[] args) {
        driver.get(LOGIN_PAGE_URL);
        webdriverWaite5sec.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[text()='Логин']"))));
        driver.findElement(By.id("prependedInput")).sendKeys(STUDENT_LOGIN);
        driver.findElement(By.id("prependedInput2")).sendKeys(STUDENT_PASSWORD);
        driver.findElement(By.xpath("//button[@id='_submit']")).click();

        driver.close();

    }

}
