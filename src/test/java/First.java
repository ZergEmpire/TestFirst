import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class First{

    @Test
    public void test(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);;
        //System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\"");


        Selenide.open("https://tokapizza.ru/");
        Selenide.$(By.xpath("//a[@href=\"/menu/pizza\"]")).click();
        //Selenide.$(By.xpath("//div[contains(@class, \"section-title\")]")).shouldHave(Condition.enabled).shouldHave(Condition.exactText("ХУЙ"));

        System.out.println();
    }

}
