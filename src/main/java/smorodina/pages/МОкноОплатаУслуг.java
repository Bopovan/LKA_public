package smorodina.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class МОкноОплатаУслуг {
    private Logger log = LogManager.getLogger(МОкноОплатаУслуг.class);

    @NameTag(name = "Вкладка Лицевой счёт / Окно (Оплата услуг)")
    private SelenideElement windowPayServices = $(By.xpath("//div[@class = 'abrr-ui-title-title small'][contains(text(),'Оплата услуг')]/../../../../.."));

    @NameTag(name = "Вкладка Лицевой счёт / Окно (Оплата услуг) / Коллекция полей для ввода 'Сумма платежа'")
    private ElementsCollection collectionOfInputFieldsAmountOfPayment = $$(By.xpath("//div[@class = 'abrr-ui-textfield-wrapper']"));

    @NameTag(name = "Вкладка Лицевой счёт / Окно (Оплата услуг) / Кнопка {К оплате }")
    private SelenideElement btnPay = $(By.xpath("//button[@class = 'abrr-ui-button green uppercase'][contains(.,'К оплате')]"));

    @NameTag(name = "Вкладка Лицевой счёт / Окно (Оплата услуг) / Кнопка {развернуть} Передача показаний")
    private SelenideElement btnSendOfTestimony = $(By.xpath("//button[@class = 'abrr-ui-button circle base']"));

    @NameTag(name = "Вкладка Лицевой счёт / Окно (Оплата услуг) / Кнопка {Отмена}")
    private SelenideElement btnCancel = $(By.xpath("//button[@class = 'abrr-ui-button primary ghost uppercase'][contains(.,'Отмена')]"));

    @NameTag(name = "Вкладка Лицевой счёт / Окно (Оплата услуг) / Раскрывающийся список банковских карт")
    private SelenideElement bankCardList = $(By.xpath("//button[@class = 'abrr-ui-button base abrr-ui-plasticcardselect']"));
}
