import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;

import static com.codeborne.selenide.Selenide.*;

public class First{

    @Test
    public void test(){
        //System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\"");
        //ChromeOptions chrome_options = new ChromeOptions();
        //chrome_options.setHeadless(true);
        //chrome_options.addArguments("--no-sandbox");
        //chrome_options.setBinary("/usr/bin/google-chrome-stable");

        //WebDriver webDriver = new ChromeDriver(chrome_options);

        System.setProperty("webdriver.chrome.driver","/usr/bin/google-chrome-stable");
        open("https://tokapizza.ru/");
        $(By.xpath("//a[@href=\"/menu/pizza\"]")).click();
        //$(By.xpath("//div[contains(@class, \"section-title\")]")).shouldHave(Condition.enabled).shouldHave(Condition.exactText("ХУЙ"));

        webDriver.close();
        System.out.println();
    }


}
