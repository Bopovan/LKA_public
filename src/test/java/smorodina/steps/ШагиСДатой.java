package smorodina.steps;

import com.codeborne.selenide.SelenideElement;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import smorodina.pages.ВклДоговоры;

import static com.codeborne.selenide.Selenide.$;
import static smorodina.Utils.PageElement.getElement;

public class ШагиСДатой {

    SelenideElement showYear = $(By.id("//a[@title = 'Выбрать год']"));
    SelenideElement btnForward = $(By.id("//a[@class= 'ant-calendar-next-year-btn']"));
    SelenideElement btnBack = $(By.id("//a[@class= 'ant-calendar-prev-year-btn']"));
    String dateIncalendar = "//*[@class='ant-calendar-tbody']/tr/td[not(@class='ant-calendar-cell ant-calendar-last-month-cell')][not(@class = 'ant-calendar-cell ant-calendar-last-month-cell ant-calendar-last-day-of-month')]/div[contains(text(),'31')]"
    String dateIncalendar = "//*[@class=\"ant-calendar-cell\"]/*[@class=\"ant-calendar-date\"][text()=\"30\"]";


    DatePicker datePicker = new DatePicker;


}
