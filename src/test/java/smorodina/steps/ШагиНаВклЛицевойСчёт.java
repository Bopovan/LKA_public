package smorodina.steps;

import io.cucumber.java.en.When;
import smorodina.pages.ВклЛицевойСчёт;

public class ШагиНаВклЛицевойСчёт {
    ВклЛицевойСчёт page = new ВклЛицевойСчёт();

    @When("на вкладке ЛицевойСчёт в строке с текущей датой и суммой в рублях = {string}, нажать на кнопку 'Детализировать'")
    public void clickDetail(String rub) {
        page.clickDetail(rub);
    }
}
