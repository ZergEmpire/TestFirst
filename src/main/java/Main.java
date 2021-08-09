import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureResultsWriter;
import org.openqa.selenium.By;

public class Main {
    public static void main(String[] args){
        Selenide.open("https://tokapizza.ru/");
        Selenide.$(By.xpath("//a[@href=\"/menu/pizza\"]")).click();

        //Selenide.$(By.xpath("//div[contains(@class, \"section-title\")]")).shouldHave(Condition.enabled).shouldHave(Condition.exactText("ХУЙ"));
        System.out.println();
    }
}
