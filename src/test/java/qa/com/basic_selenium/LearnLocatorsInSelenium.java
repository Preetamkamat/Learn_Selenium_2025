package qa.com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LearnLocatorsInSelenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Hello, sign in")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("9657854594");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("pk@@2617");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
    }

}
