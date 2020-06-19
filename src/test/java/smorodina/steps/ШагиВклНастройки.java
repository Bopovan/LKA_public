package smorodina.steps;

import com.codeborne.selenide.Condition;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import smorodina.pages.ВклНастройки;

public class ШагиВклНастройки {
    @Steps
    ВклНастройки вклНастройки;

    @When("на вклНастройки в таблице нажать на кнопку {Отключить} у счёта '$номерСчёта'")
    @Then("на вклНастройки в таблице нажать на кнопку {Отключить} у счёта '$номерСчёта'")
    public void clickOffBtn(String numberAcc) {
        вклНастройки.clickBtnOffAcc(numberAcc);
    }

    @When("на вклНастройки в таблице нажать на кнопку {Переименовать} у счёта '$номерСчёта'")
    @Then("на вклНастройки в таблице нажать на кнопку {Переименовать} у счёта '$номерСчёта'")
    public void clickRenameBtn(String numberAcc) {
        вклНастройки.clickBtnRenameAcc(numberAcc);
    }

    @When("на вклНастройки в таблице проверить, что содержится счёт: '$номерСчёта'")
    @Then("на вклНастройки в таблице проверить, что содержится счёт: '$номерСчёта'")
    public void checkContainsInTable(String numberAcc) {
        вклНастройки.checkAccInTable(numberAcc,true);
    }

    @When("на вклНастройки в таблице проверить, что не содержится счёт: '$номерСчёта'")
    @Then("на вклНастройки в таблице проверить, что не содержится счёт: '$номерСчёта'")
    public void checkNotContainsInTable(String numberAcc) {
        вклНастройки.checkAccInTable(numberAcc,false);
    }

}
