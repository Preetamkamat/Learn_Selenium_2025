package qa.com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ValidateBrokenLinks {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        Thread.sleep(2000);
        driver.get("https://community.ebay.com/t5/Half-com/bd-p/21000000002");
        Thread.sleep(2000);
        //1. get the list of all links
        List<WebElement> linkslist = driver.findElements(By.xpath("//a"));
        linkslist.addAll(driver.findElements(By.xpath("//a")));
        System.out.println("Links contains href" + "--->" + linkslist.size());
        List<String> activeLinks = new ArrayList<>();

        // 2. iterate linklists: exclude all the links - does not have any href  attribute
        for (int i = 0; i < linkslist.size(); i++) {
            if (linkslist.get(i).getDomAttribute("href") != null) {
                activeLinks.add(linkslist.get(i).getDomAttribute("href"));
                System.out.println(activeLinks.get(i));
            }
        }

        //get the size of active links list
        System.out.println("Size of the a tags and href" + activeLinks.size());

        //3. check the href url, with https connection api
        for (int j = 0; j < activeLinks.size(); j++) {
            HttpsURLConnection connection = (HttpsURLConnection) new URL(activeLinks.get(j)).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            System.out.println(activeLinks.get(j) + "---->" + response);
            connection.disconnect();
        }
        driver.quit();
    }
}
