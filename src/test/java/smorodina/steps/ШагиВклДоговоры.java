package smorodina.steps;

import io.cucumber.java.en.When;
import smorodina.pages.ВклДоговоры;

public class ШагиВклДоговоры {
    ВклДоговоры page = new ВклДоговоры();

    @When("на Вкладке договоры в таблице в строке с номером договора = {int} нажать на кнопку {string}")
    public void clickBtnOnContractWeNeed(String buttonName, int contract) {
        new ВклДоговоры().continueContractWork(contract, buttonName);
    }
}
