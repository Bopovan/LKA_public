package smorodina.steps;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import smorodina.pages.МОкноОплатаУслуг;
import smorodina.pages.ОкноАвторизации;
import smorodina.pages.ОкноДетализацияСчёта;
import smorodina.pages.ОкноЭквайринга;

import java.util.regex.Pattern;

public class ШагиМООплатыУслуг {
    private final Logger log = LogManager.getLogger(ШагиМООплатыУслуг.class);
    МОкноОплатаУслуг page = new МОкноОплатаУслуг();
    ОкноЭквайринга page2 = new ОкноЭквайринга();
    ОкноДетализацияСчёта page3 = new ОкноДетализацияСчёта();

    @When("очистить все поля Сумм")
    public void cleanModalSumFields() {
        page.cleanAllSummFields();
    }

    @When("в поле под порядковым номером {int} ввести сумму равную {string}")
    public void typeSumInField(int numberOfField, String sum) {
        page.setFieldSum(numberOfField, sum);
    }

    @When("запомнить номер счёта в переменную transactionNumber")
    public void saveTrNum() {
        page2.saveTransNum();
    }

    @When("во все поля сумм ввести значение = {string}")
    public void setAllsumFields(String sum){
        page.setAllFieldsSumm(sum);
    }

}
