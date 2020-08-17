package smorodina.steps;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import smorodina.pages.БоковаяПанель;

public class ШагиНаБоковойПанели {
    БоковаяПанель page = new БоковаяПанель();

    @When("выбрать счёт {string} в боковой панели")
    public void setAcc(String numAcc) {
        page.findNeededAcc(numAcc).scrollTo().waitUntil(Condition.visible,5000).click();
    }

}
