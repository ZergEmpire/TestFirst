import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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

        Selenide.open("https://tokapizza.ru/");
        Selenide.$(By.xpath("//a[@href=\"/menu/pizza\"]")).click();
        Selenide.$(By.xpath("//div[contains(@class, \"section-title\")]")).shouldHave(Condition.enabled).shouldHave(Condition.exactText("Пицца"));


    }

}