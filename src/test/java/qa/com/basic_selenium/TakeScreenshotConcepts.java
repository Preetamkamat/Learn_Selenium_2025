package qa.com.basic_selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshotConcepts {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.get("https://jqueryui.com/droppable/");
        WebElement textElement = driver.findElement(By.xpath("//p[@class='desc']"));
        File source = textElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./src/test/java/qa/com/screenshots/google.png"));
        Thread.sleep(5000);
        driver.quit();
    }
}
