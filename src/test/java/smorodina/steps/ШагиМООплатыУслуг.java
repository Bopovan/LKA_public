package smorodina.steps;

import io.cucumber.java.en.When;
import smorodina.pages.МОкноОплатаУслуг;

public class ШагиМООплатыУслуг {
    МОкноОплатаУслуг page = new МОкноОплатаУслуг();

    @When("очистить все поля Сумм")
    public void cleanModalSumFields() {
        page.cleanAllSummFields();
    }

    @When("в поле под порядковым номером {int} ввести сумму равную {string}")
    public void typeSumInField(int numberOfField, String sum) {
        page.setFieldSum(numberOfField,sum);
    }


}
