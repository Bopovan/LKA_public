package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ВклЛицевойСчёт {

    private Logger log = LogManager.getLogger(ВклЛицевойСчёт.class);

    //==============================Элементы карточки УСЛУГИ==============================
    @NameTag(name = "Окно Услуги")
    private SelenideElement tabPersonalAccountWindowServices = $(By.xpath("//div[@class = 'lk-page-accountview-widget'][contains(.,'Услуги')]"));

    @NameTag(name = "Вкладка Лицевой счёт / Кнопка {Квитанция}")
    private SelenideElement buttonReceipt = $(By.xpath("//button[@class = 'abrr-ui-button primary ghost uppercase'][contains(.,'Квитанция')]"));

    @NameTag(name = "Вкладка Лицевой счёт / Кнопка {Оплатить}")
    private SelenideElement buttonPay = $(By.xpath("//button[@class = 'abrr-ui-button green uppercase'][contains(.,'Оплатить')]"));

    @NameTag(name = "Вкладка Лицевой счёт / Кнопка {Раскрыть список услуг}")
    private SelenideElement tabPAbuttonExpandlistServices = $(By.xpath("//button[@class = 'abrr-ui-button green ghost uppercase base']"));


    @NameTag(name = "Вкладка Лицевой счёт / Коллекция \"Состояний по услугам\"")
    private ElementsCollection collectionServiceStatus = $$(By.xpath("//*[@class = 'lk-page-accountview-widget-payment-subtitle']"));


    //==============================Элементы карточки ПРИБОРЫ УЧЕТА==============================

    @NameTag(name = "Окно Приборы учета")
    private SelenideElement windowDevices = $(By.xpath("//div[@class = 'lk-page-accountview-widget'][contains(.,'Приборы учета')]"));

    @NameTag(name = "Вкладка Лицевой счёт / Кнопка {История}")
    private SelenideElement btnHistory = $(By.xpath("//button[@class = 'abrr-ui-button primary ghost uppercase'][contains(.,'История')]"));

    @NameTag(name = "Вкладка Лицевой счёт / Кнопка {Передать показания}")
    private SelenideElement btnTransmitTestimony = $(By.xpath("//button[@class = 'abrr-ui-button primary uppercase']"));

    @NameTag(name = "Вкладка Лицевой счёт / Следующая дата поверки (значение)")
    private SelenideElement fieldNextVerificationDate = $(By.xpath("//div[contains(text(),'Следующая дата поверки')]/following-sibling::div"));

    @NameTag(name = "Вкладка Лицевой счёт / Среднемесячный расход (значение)")
    private SelenideElement fieldAverageMonthlyConsumption = $(By.xpath("//div[contains(text(),'Среднемесячный расход')]/following-sibling::div"));

    @NameTag(name = "Вкладка Лицевой счёт / Текущие показания")
    private SelenideElement fieldCurrentReadings = $(By.xpath("//div[@class='lk-page-accountview-widget-counter-value']"));

    @NameTag(name = "Вкладка Лицевой счёт / Номер счетчика")
    private SelenideElement fieldCounterNumber = $(By.xpath("//div[@class='lk-page-accountview-widget-counter-value']/following-sibling::div[1]"));


    public void pressBtnReceipt() {
        log.trace("Нажимаем на кнопку {Квитанция}");
        buttonReceipt.shouldBe(Condition.visible).click();
    }

    public void pressBtnPay() {
        log.trace("Нажимаем на кнопку {Оплатить}");
        buttonPay.shouldBe(Condition.visible).click();
    }

    public void pressButtonExpandlistServices() {
        log.trace("Нажимаем на кнопку {Раскрыть список услуг}");
        tabPAbuttonExpandlistServices.shouldBe(Condition.visible).click();
    }

    public String getByNumberServiceStatus(int number) {
        log.trace("Получаем имя Услуги по номеру " + number);
        String value = collectionServiceStatus.get(number + 1).getValue();
        Matcher compactMatcher = Pattern.compile("\"(\\W+)\"").matcher(value);
        if (compactMatcher.find()) {
            return compactMatcher.group(1);
        } else {
            log.error("Под номером " + number + " услуга отсутствует!");
            return null;
        }
    }

    public void checkWindowDevicesIsDisplayed () {
        log.trace("Проверяем, отображается ли окно Приборы учета ");
        windowDevices.shouldBe(Condition.visible);
    }
}
