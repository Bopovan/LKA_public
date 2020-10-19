package smorodina.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import smorodina.pages.ВклЛицевойСчёт;
import smorodina.pages.ОкноПередачиПоказаний;

import static com.codeborne.selenide.Selenide.$;

public class ШагиПередачиПоказаний {
    private Logger log = LogManager.getLogger(ШагиПередачиПоказаний.class);
    ОкноПередачиПоказаний page = new ОкноПередачиПоказаний();
    ВклЛицевойСчёт page2 = new ВклЛицевойСчёт();

    /*
        Глоабльная переменная
    */

    private String value2 = "";

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @When("К текущему показанию добавить {string}")
    public void addCurrentVAlueNew(String value) {

        int valueFromForm = Integer.parseInt(page.getTextVal());
        int summ = valueFromForm + Integer.parseInt(value);
        while (page.getTextVal().length() > 0) {
            page.fieldVals.sendKeys(Keys.BACK_SPACE);
        }
        page.fieldVals.setValue(Integer.toString(summ));
        setValue2(Integer.toString(summ));
    }

    @When("К текущему показанию уменьшить {string}")
    public void currentVAlueNew(String value) {

        int valueFromForm = Integer.parseInt(page.getTextVal());
        int summ = valueFromForm - Integer.parseInt(value);
        while (page.getTextVal().length() > 0) {
            page.fieldVals.sendKeys(Keys.BACK_SPACE);
        }
        page.fieldVals.setValue(Integer.toString(summ));
    }

    @When("в истории показаний проверить, что последний платёж был зарегистрирован _связанный шаг_")
    public void checkLastInHistory(){
        log.trace("проверяем, что в истории отображается: {}" , getValue2());
        SelenideElement element = $(By.xpath(String.format(page2.checkHistoryParam,getValue2())))
                .shouldBe(Condition.visible);
    }
}
