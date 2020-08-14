package smorodina.steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import smorodina.pages.ВклЛицевойСчёт;

public class ШагиНаВклЛицевойСчёт {
    ВклЛицевойСчёт page = new ВклЛицевойСчёт();

    @When("на вкладке ЛицевойСчёт в строке с текущей датой и суммой в рублях, нажать на кнопку 'Детализировать'")
    public void clickDetail() {
        page.clickDetail();
    }
}
