package smorodina.steps;

import io.cucumber.java.en.When;
import smorodina.pages.ОбщиеЭлементы;

public class ШагиОбщМодОкна {
    ОбщиеЭлементы общиеЭлементы;



    @When("В комбобоксе Выберите_ресурсоснабжающую_организацию выбрать значение {string}")
    public void setValueCombobox(String value) {
        общиеЭлементы.setOrganizationCombobox(value);
    }



    @When("проверить, что платёж успешно проведён и отображается на вкладке Лицевой счет")
    public void checkSaveAndExpectVal(){

    }

}

