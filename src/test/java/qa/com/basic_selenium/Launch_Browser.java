package qa.com.basic_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch_Browser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Learn\\Learn_Selenium_2025\\src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
    }
}
