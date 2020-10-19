package smorodina.steps;

import io.cucumber.java.en.When;
import smorodina.pages.ВклНастройки;

public class ШагиВклНастройки {
    ВклНастройки вклНастройки = new ВклНастройки();

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
        вклНастройки.checkAccInTable(numberAcc, true);
    }

    @When("на вклНастройки в таблице проверить количество подключенных счетов, должно быть: {int}")
    public void checkCountAccInTable(int numberAcc) {
        вклНастройки.checkCountAccInTable(numberAcc);
    }

    @When("на вклНастройки в таблице проверить, что не содержится счёт: {string}")
    public void checkNotContainsInTable(String numberAcc) {
        вклНастройки.checkAccInTable(numberAcc, false);
    }

    @When("на вклНастройки проверить, что привязана карта с последними цифрами: {string}")
    public void checkLastFourNum(String num) {
        вклНастройки.findNeedCard(num);
    }

    @When("на вклНастройки проверить, что карта НЕ отображается, с последними цифрами: {string}")
    public void checkLastFourNumIsNotDiplayed(String num) {
        вклНастройки.cardIsNotDisplayed(num);
    }

    @When("на вклНастройки удалить привязанную карту с последними 4 цифрами:{string}")
    public void deleteCard(String num) {
        вклНастройки.destroyCard(num);
    }

    @When("на вклНастройки отключить Счет: {string}")
    public void deleteAcc(String numAcc) {
        вклНастройки.destroyAcc(numAcc);
    }

    @When("на вклНастройки проверить, что лицевой счет: {string} - НЕ отображается")
    public void checkAccIsNotDiplayed(String numAcc) {
        вклНастройки.cardIsNotDisplayed(numAcc);
    }
}
