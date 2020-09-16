package smorodina.pages;

import com.codeborne.selenide.*;
import io.cucumber.java.en.When;
import org.apache.hc.core5.util.Asserts;
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
    ОкноЭквайринга page2;

    private Logger log = LogManager.getLogger(ВклЛицевойСчёт.class);

    public ВклЛицевойСчёт() {
        firstWindow.waitUntil(Condition.visible, 15000);
    }

    @NameTag(name = "Страница Лицевой счёт")
    private final SelenideElement firstWindow = $(By.xpath("//div[@class = 'lk-page-accountview-widget']/../.."));

    @NameTag(name = "Вложенная вкладка Заявки")
    private final SelenideElement subTab6 = $(By.xpath("//div[text()='Заявки']/.."));



    /*
    Элементы карточки Заявки
     */
    @NameTag(name = "текст \'Заявка на перерасчет\'")
    private final SelenideElement textField = $(By.xpath("//div[contains(@class, 'abrr-ui-title-title')]"));

    @NameTag(name = "Кнопка {Заявка на перерасчет}")
    private final SelenideElement btnRePrice = $(By.xpath("//i[contains(@class, 'abrr-ui-button-icon')]//..//../div[text() = 'Заявка на перерасчет']/.."));

    @NameTag(name = "Комбобокс Причина перерасчета")
    private final SelenideElement reasonReValue = $(By.xpath("//div[@role= 'combobox']"));

    @NameTag(name = "Пункт Изменение количества проживаюших")
    private final SelenideElement changeRatioMan = $(By.xpath("//li[text() = 'Изменение количества проживаюших']"));

    @NameTag(name = "Пункт Изменение отапливаемой площади")
    private final SelenideElement changeRoomSize = $(By.xpath("//li[text() = 'Пункт Изменение отапливаемой площади']"));

//    @NameTag(name = "Комбобокс {Причина перерасчета}")
//    private final SelenideElement comboboxReprice = $(By.xpath("//i[contains(@class, 'abrr-ui-button-icon')]//..//../div[text() = 'Заявка на перерасчет']/.."));

    @NameTag(name = "Календарь Дата начала действия перерасчета")
    private final SelenideElement calendarStart = $(By.xpath("//input[@placeholder = 'Дата начала действия перерасчета']"));

    @NameTag(name = "поле для ввода Даты в календаре")
    private final SelenideElement fieldCalendarStart = $(By.xpath("//input[@class = 'ant-calendar-input ']"));

    @NameTag(name = "поле Количество проживающих")
    private final SelenideElement fieldCountNeib = $(By.xpath("//label[text()='Количество проживающих']/following-sibling::div/input"));

    @NameTag(name = "поле Комментарий")
    private final SelenideElement fieldComment = $(By.xpath("//label[text()='Комментарий']/following-sibling::div/textarea"));

    @NameTag(name = "прикерпить Документ, подтверждающий количество лиц")
    private final SelenideElement placeForDoc1 = $(By.xpath("//span[contains(text(),'Документ, подтверждающий количество лиц, проживающих в жилых помещениях многоквартирных домов и жилых домов (справка о составе семьи, домовая книга)')]/following-sibling::div//input"));

    @NameTag(name = "прикерпить Акт обследования")
    private final SelenideElement placeForDoc2 = $(By.xpath("//span[contains(text(),'Акт обследования отсутствия технической возможности установки прибора учета')]/following-sibling::div//input"));

    public void addDocs(){
        placeForDoc1.sendKeys("C:\\Users\\scherbakova\\IdeaProjects\\lka-automated-testing\\src\\main\\resources\\test_Files\\file_forSM0004_1.pdf");
        placeForDoc2.sendKeys("C:\\Users\\scherbakova\\IdeaProjects\\lka-automated-testing\\src\\main\\resources\\test_Files\\file_forSM0004_2.jpeg");
    }

    @NameTag(name = "кнопка Отправить заявление на перерасчет")
    private final SelenideElement btnSendReq = $(By.xpath("//div[text()='Отправить заявление на перерасчет']/.."));


    @NameTag(name = "Окно подтверждения, что заявка создана")
    private final SelenideElement successOrder = $(By.xpath("//h1[text()='Успешно!']/following-sibling::div/div[text()='Ваша заявка успешно отправлена!']"));


    /*
    Элементы карточки УСЛУГИ
     */

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

    /*
    Элементы карточки ПРИБОРЫ УЧЕТА
     */

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
    private SelenideElement fieldCurrentReadings = $(By.xpath("//div[@class = 'lk-page-accountview-widget-counter-value']"));

    @NameTag(name = "Номер счетчика")
    private SelenideElement fieldCounterNumber = $(By.xpath("//div[@class='lk-page-accountview-widget-counter-value']/following-sibling::div[1]"));

    @NameTag(name = "Значение в истории")
    public String checkHistoryParam = "//div[contains(@class,'state')]/preceding-sibling::div[contains(text(),'%s')]";


    /*
    Вкладка платежи
     */

    @NameTag(name = "Кнопка {Детализация}")
    public ElementsCollection btnDetails = $$(By.xpath("//*[contains(text(),'Детализаци')]/.."));

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
//        String rub = page.getValueInAllSumFields();
        String rub = "39";
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
