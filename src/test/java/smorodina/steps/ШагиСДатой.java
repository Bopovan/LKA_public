package smorodina.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.util.Assert;
import smorodina.pages.ВклДоговоры;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ШагиСДатой {
    private Logger log = LogManager.getLogger(ШагиСДатой.class);
    ВклДоговоры pageContracts;

    @Then("на ВклДоговоры в календаре Календарь-поле дата выдачи выбрать значение \"$ДД\" \"$месяц\" \"$ГГГГ\"")
    @When("на ВклДоговоры в календаре Календарь-поле дата выдачи выбрать значение \"$ДД\" \"$месяц\" \"$ГГГГ\"")
    public void stepSetDateInCalendar(int date, String month, int year) {
        setCalendarDate(date, month, year);
    }


    private SelenideElement fieldCalendar = $(By.xpath("//input[contains(@class, 'ant-calendar-picker-input')]"));
    private SelenideElement windowCalendar = $(By.className("ant-calendar-header"));

    private SelenideElement showYear = $(By.xpath("//a[@title = 'Выбрать год']"));
    private SelenideElement btnForward = $(By.xpath("//*[@class= 'ant-calendar-next-year-btn']"));
    private SelenideElement btnBack = $(By.xpath("//*[@class= 'ant-calendar-prev-year-btn']"));


    //год в строке (кликаем, затем ищем нужный год)
    private SelenideElement checkSelectedYear = $(By.xpath("//*[@title = 'Выбрать год']"));
    //после нажатия на календарь мы получаем коллекцию годов:
    private ElementsCollection collectionYears = $$(By.xpath("//table[@class='ant-calendar-year-panel-table']//td"));
    private String yearFormat = "//*[@class='ant-calendar-year-panel-tbody']/tr//a[contains(text(),'%d')]";
    private SelenideElement checkDisplayedYears = $(By.xpath("//*[@class = 'ant-calendar-year-panel-decade-select-content']"));

    //месяц в строке
    private SelenideElement checkSelectedMonth = $(By.xpath("//*[@title = 'Выбрать месяц']"));
    private SelenideElement btnSelectedMonth = $(By.xpath("//a[@class = 'ant-calendar-next-month-btn']"));
    //после нажатия на календарь мы получаем коллекцию месяцев:
    private ElementsCollection collectionMonths = $$(By.xpath("//*[@class='ant-calendar-month-panel-tbody']//td"));

    // далее выбираем дату в календаре по цифре
    private String dateInСalendar = "//*[contains(@class,\"ant-calendar-cell\") and not(contains(@class,'ant-calendar-next-month-btn-day'))]/*[text()='%d']";


    private void setCalendarDate(int day, String month, int year) {

        log.debug("\n\n_____________проверяем отображаение поля календаря и кликаем на него______________\n\n");
        fieldCalendar.shouldBe(Condition.visible).click();
        log.debug("\n\n_____________проверяем какой год указан в окне календаря и запоминаем его в переменную______________\n\n");
        boolean yearInBound = false;
        boolean monthInBound = false;
        Actions action = new Actions(getWebDriver());

        Map<String, String> monthsMap = new HashMap<>();
        monthsMap.put("января", "янв.");
        monthsMap.put("февраля", "февр.");
        monthsMap.put("марта", "март");
        monthsMap.put("мая", "май");
        monthsMap.put("апреля", "апр.");
        monthsMap.put("июня", "июнь");
        monthsMap.put("июля", "июль");
        monthsMap.put("августа", "авг.");
        monthsMap.put("сентября", "сент.");
        monthsMap.put("октября", "окт.");
        monthsMap.put("ноября", "нояб.");
        monthsMap.put("декабря", "дек.");

        while (!monthInBound) {
            log.debug("\n____________________________________________________________\n Пробуем выбрать месяц на форме \n____________________________________________________________");
            Assert.notNull(monthsMap.get(month), "\n______________________________________________________________\n\n   Такого месяца не существует: \"" + month + "\".  \n______________________________________________________________\n");
            if (monthsMap.get(month).equals(checkSelectedMonth.getText())) {
                monthInBound = true;
            } else {
                btnSelectedMonth.click();
                log.debug("\n____________________________________________________________\n Получаем месяц, который отображается на форме = \"{}\" \n____________________________________________________________", checkSelectedMonth.getText());
            }
        }
        while (!yearInBound) {
            int yearInForm = Integer.parseInt(Objects.requireNonNull(showYear.shouldBe(Condition.visible).getText()));
            log.debug("\n\n_____________ год полученый из окна yearsInForm = {}______________\n\n", yearInForm);
            if (year == yearInForm) {
                yearInBound = true;
            } else if (year < yearInForm) {
                action.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.CONTROL).perform();
            } else {
                action.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_RIGHT).keyUp(Keys.CONTROL).perform();
            }
        }

        SelenideElement dayInMetod = $(By.xpath(String.format(dateInСalendar, day)));
        dayInMetod.shouldBe(Condition.visible);
        dayInMetod.click();

        String resultDate = day + " " + month + " " + year;
        fieldCalendar.shouldHave(Condition.value(resultDate));
        System.out.println(resultDate);


    }
}



