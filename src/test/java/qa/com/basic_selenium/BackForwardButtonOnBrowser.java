package qa.com.basic_selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BackForwardButtonOnBrowser{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.get("https://jqueryui.com/droppable/");
        driver.navigate().to("https://www.amazon.co.in");
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
