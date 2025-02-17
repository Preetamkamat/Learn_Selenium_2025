package qa.com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitConcepts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.get("https://www.facebook.com/r.php?entry_point=login");
        WebElement logInButton = driver.findElement(By.name("websubmits"));
        clickOn(driver, logInButton, 40);
        driver.quit();
    }

    public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(40)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }
}
