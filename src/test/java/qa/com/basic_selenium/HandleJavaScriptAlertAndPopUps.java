package qa.com.basic_selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class HandleJavaScriptAlertAndPopUps {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.xpath("//input[@name='proceed']")).click();
        Alert alert = driver.switchTo().alert();
        String alerttext = alert.getText();
        System.out.println(alerttext);
        Assert.assertEquals(alerttext,"Please enter a valid user name");
        alert.accept();
        driver.quit();
    }
}
