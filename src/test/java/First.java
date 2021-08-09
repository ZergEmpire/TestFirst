import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import lombok.SneakyThrows;
import org.apache.commons.exec.OS;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class First{

    @Test
    public void test(){
        //Проперти так как нет Иксов на сервере
        //ЧТО ТО ИЗ ЭТОГО ПИЗДЕЦ КАК ВАЖНО
        //=== --- === --- === --- === --- === --- === --- === --- === --- === --- === --- === ---
        /*if (OS.isFamilyUnix()) {
            Configuration.headless = true;
            System.setProperty("chromeoptions.args", "\"--no-sandbox\"");
            System.setProperty("chromeoptions.args", "\"--disable-dev-shm-usage\"");
            System.setProperty("chromeoptions.args", "--disable-gpu");
            System.setProperty("chromeoptions.args", "--headless");
            System.setProperty("chromeoptions.args", "--disable-setuid-sandbox");
            System.setProperty("chromeoptions.args", "--test-type");
            System.setProperty("webdriver.chrome.whitelistedIps", "");
        }*/
        //=== --- === --- === --- === --- === --- === --- === --- === --- === --- === --- === ---
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "91.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    new URL("http://192.168.1.17:8080/wd/hub"),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        WebDriverRunner.setWebDriver(driver);

        //driver.get("https://tokapizza.ru/");
        open("https://tokapizza.ru/");
        $(By.xpath("//a[@href=\"/menu/pizza\"]")).click();
        //JavascriptExecutor je = (JavascriptExecutor) driver;
        //WebElement element = driver.findElement(By.xpath("//div[contains(@class, \"productBox\")]"));
        //je.executeScript("arguments[0].scrollIntoView(true);",element);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [contains(@class, \"productBox\" )]//div[contains(@class, \"image\" )]")));
        //isElementByDisplayed(By.xpath("//div [contains(@class, \"productBox\" )]//div[contains(@class, \"image\" )]"));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [contains(@class, \"productBox\" )]//div[contains(@class, \"bottom\" )]")));
        //isElementByDisplayed(By.xpath("//div [contains(@class, \"productBox\" )]//div[contains(@class, \"bottom\" )]"));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [contains(@class, \"productBox\" )]//div[contains(@class, \"bottom\" )]//div[contains(@class, \"price\" )]")));
        //isElementByDisplayed(By.xpath("//div [contains(@class, \"productBox\" )]//div[contains(@class, \"bottom\" )]//div[contains(@class, \"price\" )]"));
       // return this;


        //driver.open("https://tokapizza.ru/");
        //driver.$(By.xpath("//a[@href=\"/menu/pizza\"]")).click();
        $(By.xpath("//div[contains(@class, \"section-title\")]")).shouldHave(Condition.enabled).shouldHave(Condition.exactText("Пицца"));

        System.out.println();
    }

}
