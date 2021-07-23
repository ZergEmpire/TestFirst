import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class First{

    @Test
    public void test(){
        Selenide.open("https://tokapizza.ru/");
        Selenide.$(By.xpath("//a[@href=\"/menu/pizza\"]")).click();
        Selenide.$(By.xpath("//div[contains(@class, \"section-title\")]")).shouldHave(Condition.enabled).shouldHave(Condition.exactText("Пицца+1"));

        System.out.println();
    }

}
