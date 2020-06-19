package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.*;

public class ОбщиеПроверки {

//Проверка, что элемент доступен для взаимодействия. Метод создан для ускорения прохождения тест кейсов, без переоткрывания форм.
    public void checkConditionElement(SelenideElement element) {
        Assert.assertTrue("Элемент " + element + " недоступен для взаимодействия", element.is(not(Condition
                .or("Кнопка доступна для редактирования", readonly, disabled))));
    }


}
