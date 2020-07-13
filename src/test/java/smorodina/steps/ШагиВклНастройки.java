package smorodina.steps;

import io.cucumber.java.en.When;
import smorodina.pages.ВклНастройки;

public class ШагиВклНастройки {
    ВклНастройки вклНастройки;

    @When("на вклНастройки в таблице нажать на кнопку \"Отключить\" у счёта {string}")
    public void clickOffBtn(String numberAcc) {
        вклНастройки.clickBtnOffAcc(numberAcc);
    }

    @When("на вклНастройки в таблице нажать на кнопку \"Переименовать\" у счёта {string}")
    public void clickRenameBtn(String numberAcc) {
        вклНастройки.clickBtnRenameAcc(numberAcc);
    }

    @When("на вклНастройки в таблице проверить, что содержится счёт: {string}")
    public void checkContainsInTable(String numberAcc) {
        вклНастройки.checkAccInTable(numberAcc,true);
    }

    @When("на вклНастройки в таблице проверить, что не содержится счёт: {string}")
    public void checkNotContainsInTable(String numberAcc) {
        вклНастройки.checkAccInTable(numberAcc,false);
    }

}
