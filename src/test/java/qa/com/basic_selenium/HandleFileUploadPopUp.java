package qa.com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleFileUploadPopUp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://html.com/input-type-file/");
        driver.findElement(By.xpath("//input[@name='fileupload']")).sendKeys("C:\\Users\\preet\\OneDrive\\Desktop\\Ankur warikoo - Time management.png");
        driver.quit();
    }
}
