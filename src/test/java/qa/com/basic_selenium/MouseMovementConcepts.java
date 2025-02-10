package qa.com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseMovementConcepts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.get("https://www.unishivaji.ac.in/");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='MenuBar']/ul/li[5]/a")))
                .moveToElement(driver.findElement(By.xpath("//*[@id='MenuBar']/ul/li[5]/ul/li[2]/a")))
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"MenuBar\"]/ul/li[5]/ul/li[2]/ul/li[1]/a")))
                .build().perform();
        Thread.sleep(500000);
        driver.quit();
    }
}
