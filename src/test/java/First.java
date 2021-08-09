import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lombok.SneakyThrows;
import org.apache.commons.exec.OS;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class First{

    @SneakyThrows
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
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://192.168.1.17:8080/wd/hub").toURL(),
                capabilities
        );


        open("https://tokapizza.ru/");
        $(By.xpath("//a[@href=\"/menu/pizza\"]")).click();
        //$(By.xpath("//div[contains(@class, \"section-title\")]")).shouldHave(Condition.enabled).shouldHave(Condition.exactText("ХУЙ"));
        System.out.println();
    }


}
