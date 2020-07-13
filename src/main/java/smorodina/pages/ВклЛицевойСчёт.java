package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ВклЛицевойСчёт {

    private Logger log = LogManager.getLogger(ВклЛицевойСчёт.class);

    ВклЛицевойСчёт() {
        firstWindow.waitUntil(Condition.visible,15000);
    }

    @NameTag(name = "Страница Лицевой счёт")
    private final SelenideElement firstWindow = $(By.xpath("//div[@class = 'lk-page-accountview-widget']/../.."));

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

    //==============================Вкладка платежи==============================

    @NameTag(name = "Кнопка {Детализация}")
    private SelenideElement btnDetails = $(By.xpath("//*[contains(text(),'Детализаци')]/.."));

//    @NameTag(name = "Кнопка {Детализация}")
//    private SelenideElement btnDetails = $(By.xpath("//*[contains(text(),'Детализаци')]/.."));

    //локатор Через какого агента была сделана оплата

    private String fieldAgent = "//*[contains(text(),'%s')]/../../..//div[contains(text(),'%s')]";
    //локатор для рублей
    private String fieldRub = "//*[contains(text(),'02 февраля 2020')]/../../..//..//span[text() = '546']";
    //локатор для копеек
    private String fieldCop = "//*[contains(text(),'02 февраля 2020')]/..//*[contains(text(),'13')]";


    //==============================Вкладка Абонента==============================
    //__________Таблица Карточка абонента__________
    @NameTag(name = "Номер лицевого счёта")
    private SelenideElement numberOfAcc = $(By.xpath(""));

    public void getValueByLine(String nameLine, String expectedValue) {
        log.trace("___________________________________________________\n\n  Пробуем получить коллекцию строк в таблице \n\n ___________________________________________________");
        ElementsCollection linesCollection = $$(By.xpath("//tr/td/span"));
        log.trace("___________________________________________________\n\n  Получили коллекцию строк \n\n ___________________________________________________");
        log.trace("___________________________________________________\n\n  Получаем линию с нужным нам Наименованием \n\n ___________________________________________________");
        final SelenideElement expectedLine = linesCollection.find(Condition.text(nameLine));
        log.trace("___________________________________________________\n\n  Из полученной линии достаём текст \n\n ___________________________________________________");
        String value = expectedLine.$x("//../../td[2]").getText();
        log.trace("___________________________________________________\n\n  такст : {} \n\n ___________________________________________________", value);
        Assert.assertEquals(expectedValue, value);
    }


    public void checkPayments(String checkedDay, boolean money) {

    }

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

    public void checkWindowDevicesIsDisplayed() {
        log.trace("Проверяем, отображается ли окно Приборы учета ");
        windowDevices.shouldBe(Condition.visible);
    }
}
