package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;

public class ОкноДетализацияСчёта {

    private Logger log = LogManager.getLogger(ОкноАвторизации.class);

    @NameTag(name = "Окно Детализации счёта")
    private SelenideElement detailWindow = $(By.xpath("//div[@class='lk-paymentdocument']"));

    @NameTag(name = "текст 'Детали платежа'")
    private SelenideElement textDetailPay = $(By.xpath("//div[text() = 'Детали платежа']"));

    @NameTag(name = "поле с именем МРГ")
    private SelenideElement fieldMRG = $(By.xpath("//div[@class = 'lk-paymentdocument-header'][1]"));

    @NameTag(name = "поле с номером счёта для оплаты")
    private String fieldNumAcc = "//div[contains(@class,'lk-paymentdocument-total')]//..//div[text() = '5300309475']";


    public void checkAreIsDisplay(int номерЛС) {
        SelenideElement element = $(By.xpath(String.format(fieldNumAcc,номерЛС))).shouldBe(Condition.visible);
    }


}
