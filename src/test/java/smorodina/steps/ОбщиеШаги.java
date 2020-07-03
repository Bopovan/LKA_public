package smorodina.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import smorodina.pages.ОкноАвторизации;


import static smorodina.Utils.PageElement.*;

public class ОбщиеШаги {

    private final Logger log = LogManager.getLogger(ОкноАвторизации.class);

    @When("на {string} нажать на {string}")
    public void pressBtn(String page, String element) throws Exception {
        log.debug("\n\n_______________________На странице {} нажимаем на элемент {}_______________\n\n", page, element);
        getElement(page, element).shouldBe(Condition.visible).click();
    }

    
    @When("на {string} в поле {string} ввести текст {string}")
    public void enterText(String page, String field, String value) throws Exception {
        log.debug("\n\n_______________________На странице {} нажимаем на элемент {}, вводим значение \"{}\"_______________\n\n", page, field, value);
        getElement(page, field).shouldBe(Condition.visible).setValue(value);
    }

    @When("на {string} проверить, что элемент {string} отображается")
    public void checkWindowIsDisplayed(String page, String window) throws Exception {
        log.debug("\n\n_______________________На странице {} проверяем, что элемент {} отображается_______________\n\n", page, window);
        getElement(page, window).shouldBe(Condition.visible);
    }

    @When("на {string} проверить, что в поле {string}, отображается значение {string}")
    public void checkValueInField(String page, String field, String value) throws Exception {
        log.debug("\n\n_______________________На странице {} проверяем, что в поле {} отображается значение \"{}\"_______________\n\n", page, field, value);
        String value2 = getElement(page, field).shouldBe(Condition.visible).getValue();
        Assert.assertEquals(value, value2);
    }

    @Then("на {string} в календаре {string} выбрать дату в формате {string}")
//    @When("на {странице} в календаре {календарь} выбрать дату в формате {ДД ММММ ГГГГ}")
    public void setCalendarDate(String page, String calendar, String date) throws IllegalAccessException, ClassNotFoundException {
        ШагиСДатой dateSteps = new ШагиСДатой();
        SelenideElement calendarElement = getElement(page, calendar);
//        dateSteps.setDateByName(calendarElement, date);
    }

    @Then("ожидать {int} секунд")
    public void wait(int time) {
        Selenide.sleep(time * 1000);

    }

//    @When("на {string} в комбобоксе {string} выбрать значение {string}")
//    @Then("на {string} в комбобоксе {string} выбрать значение {string}")
//    public void setValueCombobox(String page, String field, String value) throws IllegalAccessException, ClassNotFoundException {
////        getElement(page, field).shouldBe(Condition.visible).click();
//        getElement(page, field).setValue(value);
//
//        log.debug("\n\n______________________На странице {} в комбобоксе {}, выбираем значение {}________________________\n\n", page, field, value);
//    }

}
