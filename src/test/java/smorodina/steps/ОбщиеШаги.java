package smorodina.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import smorodina.pages.БоковаяПанель;
import smorodina.pages.МОкноВыхода;
import smorodina.pages.ОкноАвторизации;


import static smorodina.Utils.PageElement.*;

public class ОбщиеШаги {
    //________________________________________________________________________________________________
    public int implicityWait = 5000; // - ожидание отображения элемента или срабатывание кнопки
    //________________________________________________________________________________________________


    private final Logger log = LogManager.getLogger(ОкноАвторизации.class);

    @When("на {string} нажать на {string}")
    public void pressBtn(String page, String element) throws Exception {
        log.debug("\n\n_______________________На странице {} нажимаем на элемент {}_______________\n\n", page, element);
        getElement(page, element).waitUntil(Condition.visible, implicityWait).click();
    }

    @When("на {string} в комбобоксе {string} выбрать значение {string}")
    public void pressBtn(String page, String element, String value) throws Exception {
        log.debug("\n\n_______________________На странице {} в комбобоксе {} выбираем занчение {}_______________\n\n", page, element, value);
        getElement(page, element).waitUntil(Condition.visible, implicityWait).selectOption(value);
    }

    @When("на {string} активировать чек-бокс {string}")
    public void pressCheckBox(String page, String checkBox) throws Exception {
        log.debug("\n\n_______________________На странице {} активируем чек-бокс {}_______________\n\n", page, checkBox);
        SelenideElement checkBoxInStep = getElement(page, checkBox);
        if(!checkBoxInStep.isSelected()) {
            checkBoxInStep.setSelected(true);
        }


    }


    @When("на {string} в поле {string} ввести текст {string}")
    public void enterText(String page, String field, String value) throws Exception {
        log.debug("\n\n_______________________На странице {} нажимаем на элемент {}, вводим значение \"{}\"_______________\n\n", page, field, value);
        getElement(page, field).waitUntil(Condition.visible, implicityWait).setValue(value);
    }

    @When("на {string} проверить, что элемент {string} отображается")
    public void checkWindowIsDisplayed(String page, String window) throws Exception {
        log.debug("\n\n_______________________На странице {} проверяем, что элемент {} отображается_______________\n\n", page, window);
        getElement(page, window).waitUntil(Condition.visible, implicityWait);
    }

    @When("на {string} проверить, что в поле {string}, отображается значение {string}")
    public void checkValueInField(String page, String field, String value) throws Exception {
        log.debug("\n\n_______________________На странице {} проверяем, что в поле {} отображается значение \"{}\"_______________\n\n", page, field, value);
        String value2 = getElement(page, field).waitUntil(Condition.visible, implicityWait).getValue();
        Assert.assertEquals(value, value2);
    }

    @Then("на {string} в календаре {string} выбрать дату в формате {string}")
    public void setCalendarDate(String page, String calendar, String date) throws IllegalAccessException, ClassNotFoundException {
        ШагиСДатой dateSteps = new ШагиСДатой();
//        SelenideElement calendarElement = getElement(page, calendar);
    }

    @Then("ожидать {int} секунд")
    public void wait(int time) {
        Selenide.sleep(time * 1000);
    }

    @Then("переключиться на модальное окно под номером {int}")
    public void switchToNewWindow(int numWindow) {
        Selenide.sleep(3000);
        Selenide.switchTo().window(numWindow);
    }

    @When("выйти из системы")
    public void exit() {
        new МОкноВыхода().elementaryExit();
    }

}
