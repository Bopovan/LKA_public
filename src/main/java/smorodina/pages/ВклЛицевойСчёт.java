package smorodina.pages;

import com.codeborne.selenide.*;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ВклЛицевойСчёт {
    МОкноОплатаУслуг page = new МОкноОплатаУслуг();

    private Logger log = LogManager.getLogger(ВклЛицевойСчёт.class);

    public ВклЛицевойСчёт() {
        firstWindow.waitUntil(Condition.visible, 15000);
    }

    @NameTag(name = "Страница Лицевой счёт")
    private final SelenideElement firstWindow = $(By.xpath("//div[@class = 'lk-page-accountview-widget']/../.."));

    //==============================Элементы карточки УСЛУГИ==============================

    @NameTag(name = "Окно Услуги")
    private SelenideElement tabPersonalAccountWindowServices = $(By.xpath("//div[@class = 'lk-page-accountview-widget'][contains(.,'Услуги')]"));

    @NameTag(name = "Кнопка {Квитанция}")
    private SelenideElement buttonReceipt = $(By.xpath("//button[@class = 'abrr-ui-button primary ghost uppercase'][contains(.,'Квитанция')]"));

    @NameTag(name = "Кнопка Оплатить")
    private SelenideElement buttonPay = $(By.xpath("//button[@class = 'abrr-ui-button green uppercase'][contains(.,'Оплатить')]"));

    @NameTag(name = "Кнопка {Раскрыть список услуг}")
    private SelenideElement tabPAbuttonExpandlistServices = $(By.xpath("//button[@class = 'abrr-ui-button green ghost uppercase base']"));

    @NameTag(name = "Коллекция \"Состояний по услугам\"")
    private ElementsCollection collectionServiceStatus = $$(By.xpath("//*[@class = 'lk-page-accountview-widget-payment-subtitle']"));

    //==============================Элементы карточки ПРИБОРЫ УЧЕТА==============================

    @NameTag(name = "Окно Приборы учета")
    private SelenideElement windowDevices = $(By.xpath("//div[@class = 'lk-page-accountview-widget'][contains(.,'Приборы учета')]"));

    @NameTag(name = "Кнопка {История}")
    private SelenideElement btnHistory = $(By.xpath("//button[@class = 'abrr-ui-button primary ghost uppercase'][contains(.,'История')]"));

    @NameTag(name = "Кнопка {Передать показания}")
    private SelenideElement btnTransmitTestimony = $(By.xpath("//button[@class = 'abrr-ui-button primary uppercase']"));

    @NameTag(name = "Следующая дата поверки (значение)")
    private SelenideElement fieldNextVerificationDate = $(By.xpath("//div[contains(text(),'Следующая дата поверки')]/following-sibling::div"));

    @NameTag(name = "Среднемесячный расход (значение)")
    private SelenideElement fieldAverageMonthlyConsumption = $(By.xpath("//div[contains(text(),'Среднемесячный расход')]/following-sibling::div"));

    @NameTag(name = "Текущие показания")
    private SelenideElement fieldCurrentReadings = $(By.xpath("//div[@class='lk-page-accountview-widget-counter-value']"));

    @NameTag(name = "Номер счетчика")
    private SelenideElement fieldCounterNumber = $(By.xpath("//div[@class='lk-page-accountview-widget-counter-value']/following-sibling::div[1]"));


    //==============================Вкладка платежи==============================

    @NameTag(name = "Кнопка {Детализация}")
    private ElementsCollection btnDetails = $$(By.xpath("//*[contains(text(),'Детализаци')]/.."));

//    @NameTag(name = "Кнопка {Детализация}")
//    private SelenideElement btnDetails = $(By.xpath("//*[contains(text(),'Детализаци')]/.."));

    //локатор Через какого агента была сделана оплата

    private String fieldAgent = "//*[contains(text(),'%s')]/../../..//div[contains(text(),'%s')]";
    //локатор для рублей
    private String fieldRub = "//*[contains(text(),'02 февраля 2020')]/../../..//..//span[text() = '546']";
    //локатор для копеек
    private String fieldCop = "//*[contains(text(),'02 февраля 2020')]/..//*[contains(text(),'13')]";

    public String btnDetailForXpath = "//div[contains(text(),'%s')]/..//*[contains(text(),'%s')]//ancestor::div[contains(@class,'lk-payments-row')]//button";


    public void clickDetail() {
        Date date = new Date();
        String currentDate = String.format("%1$s%2$td %2$tB %2$tY", "", date);
        String rub = page.getValueInAllSumFields();
        System.out.println(rub);
        SelenideElement btnDetail = $(By.xpath(String.format(btnDetailForXpath, currentDate, rub)));
        int count = 0;
        while (!btnDetail.is(Condition.visible) && count < 5) {
            Selenide.refresh();
            btnDetails.shouldHave(CollectionCondition.sizeGreaterThan(0));
            count++;
        }
//                .waitUntil(Condition.visible,10000)
//                .shouldBe(Condition.visible);

        btnDetail.click();
    }


    @NameTag(name = "Номер лицевого счёта")
    private SelenideElement numberOfAcc = $(By.xpath(""));

    public void getValueByLine(String nameLine, String expectedValue) {
        log.trace("\n\n___________________________________________________\n\n  Пробуем получить коллекцию строк в таблице \n\n ___________________________________________________");
        ElementsCollection linesCollection = $$(By.xpath("//tr/td/span"));
        log.trace("\n\n___________________________________________________\n\n  Получили коллекцию строк \n\n ___________________________________________________");
        log.trace("\n\n___________________________________________________\n\n  Получаем линию с нужным нам Наименованием \n\n ___________________________________________________");
        final SelenideElement expectedLine = linesCollection.find(Condition.text(nameLine));
        log.trace("\n\n___________________________________________________\n\n  Из полученной линии достаём текст \n\n ___________________________________________________");
        String value = expectedLine.$x("//../../td[2]").getText();
        log.trace("\n\n___________________________________________________\n\n  такст : {} \n\n ___________________________________________________", value);
        Assert.assertEquals(expectedValue, value);
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


}
