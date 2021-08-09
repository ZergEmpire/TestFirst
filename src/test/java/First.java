import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

public class First{

    @Test
    public void test(){

  /*     *//* if (OS.isFamilyUnix()) *//*//{
            Configuration.headless = true;
            System.setProperty("chromeoptions.args", "\"--no-sandbox\"");
            System.setProperty("chromeoptions.args", "\"--disable-dev-shm-usage\"");
            System.setProperty("chromeoptions.args", "--disable-gpu");
            System.setProperty("chromeoptions.args", "--headless");
            System.setProperty("chromeoptions.args", "--disable-setuid-sandbox");
            System.setProperty("chromeoptions.args", "--test-type");
            System.setProperty("webdriver.chrome.whitelistedIps", "");
        //}*/

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "91.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://192.168.1.17:8080/wd/hub").toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Selenide.open("https://tokapizza.ru/");
        Selenide.$(By.xpath("//a[@href=\"/menu/pizza\"]")).click();
        Selenide.$(By.xpath("//div[contains(@class, \"section-title\")]")).shouldHave(Condition.enabled).shouldHave(Condition.exactText("Пицца"));


    }

}