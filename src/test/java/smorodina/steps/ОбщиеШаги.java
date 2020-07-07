package smorodina.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Waiter;
import com.sun.xml.bind.v2.TODO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.joda.time.Seconds;
import org.junit.Assert;
import smorodina.pages.ОкноАвторизации;

import static smorodina.Utils.PageElement.*;

public class ОбщиеШаги {

    private Logger log = LogManager.getLogger(ОкноАвторизации.class);

    @When("на \"$странице\" нажать на \"$кнопку\"")
    @Then("на \"$странице\" нажать на \"$кнопку\"")
    public void pressBtn(String page, String element) throws Exception {
        log.debug("\n\n_______________________На странице {} нажимаем на элемент {}_______________\n\n", page, element);
        getElement(page, element).shouldBe(Condition.visible).click();
    }

    @When("на \"$странице\" в поле \"$поле\" ввести текст \"$текст\"")
    @Then("на \"$странице\" в поле \"$поле\" ввести текст \"$текст\"")
    public void enterText(String page, String field, String value) throws Exception {
        log.debug("\n\n_______________________На странице {} нажимаем на элемент {}, вводим значение \"{}\"_______________\n\n", page, field, value);
        getElement(page, field).shouldBe(Condition.visible).setValue(value);
    }

    @When("на \"$странице\" проверить, что элемент \"$элемент\" отображается")
    @Then("на \"$странице\" проверить, что элемент \"$элемент\" отображается")
    public void checkWindowIsDisplayed(String page, String window) throws Exception {
        log.debug("\n\n_______________________На странице {} проверяем, что элемент {} отображается_______________\n\n", page, window);
        getElement(page, window).shouldBe(Condition.visible);
    }

    @When("на \"$странице\" проверить, что в поле \"$поле\", отображается значение \"$значение\"")
    @Then("на \"$странице\" проверить, что в поле \"$поле\", отображается значение \"$значение\"")
    public void checkValueInField(String page, String field, String value) throws Exception {
        log.debug("\n\n_______________________На странице {} проверяем, что в поле {} отображается значение \"{}\"_______________\n\n", page, field, value);
        String value2 = getElement(page, field).shouldBe(Condition.visible).getValue();
        Assert.assertEquals(value, value2);
    }

//    @Then("на \"$странице\" в календаре \"$календарь\" выбрать дату в формате \"$Дата\"")
////    @When("на \"$странице\" в календаре \"$календарь\" выбрать дату в формате \"$ДД ММММ ГГГГ\"")
//    public void setCalendarDate(String page, String calendar, String date) throws IllegalAccessException, ClassNotFoundException {
//        ШагиСДатой dateSteps = new ШагиСДатой();
//        SelenideElement calendarElement = getElement(page, calendar);
////        dateSteps.setDateByName(calendarElement, date);
//    }


//_______//шаг реализован для DeBUG и проверке отработки системы (Временный шаг!), не использовать в системе явные ожидания без причины!___________
    @Then("ожидать \"$секунд\"")
    @When("ожидать \"$секунд\"")
    public void wait(int time) throws InterruptedException {
        Thread thread = new Thread();
        Thread.sleep(time);
    }
//_____________________________________________________________________________________________________________________________________________


//#TODO из-за Boostrap и возможных проблем с дальнейшей автоматизацией работы с Комбобоксами, пока логика работы с комбобоксами реализуется внутри странц (СтраницаШаги)-проблема с xpath(свёртсано на Div элементах, стандартные методы Selenide не выбирают элемент из комбобокса)
//    @When("на \"$странице\" в комбобоксе \"$поле\" выбрать значение \"$текст\"")
//    @Then("на \"$странице\" в комбобоксе \"$поле\" выбрать значение \"$текст\"")
//    public void setValueCombobox(String page, String field, String value) throws IllegalAccessException, ClassNotFoundException {
//        getElement(page, field).shouldBe(Condition.visible).click();
//        getElement(page, field).setValue(value);
//        log.debug("\n\n______________________На странице {} в комбобоксе {}, выбираем значение {}________________________\n\n", page, field, value);
//    }


}
