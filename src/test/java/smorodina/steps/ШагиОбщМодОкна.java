package smorodina.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import smorodina.pages.ОбщиеЭлементы;

public class ШагиОбщМодОкна {
    @Steps
    ОбщиеЭлементы общиеЭлементы;

    @When("В комбобоксе Выберите_ресурсоснабжающую_организацию выбрать значение \"$значение\"")
    @Then("В комбобоксе Выберите_ресурсоснабжающую_организацию выбрать значение \"$значение\"")
    public void setValueCombobox(String value) {
        общиеЭлементы.setOrganizationCombobox(value);
    }

}
