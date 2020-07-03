package smorodina.steps;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ШагиСДатой {

    SelenideElement showYear = $(By.id("//a[@title = 'Выбрать год']"));
    SelenideElement btnForward = $(By.id("//a[@class= 'ant-calendar-next-year-btn']"));
    SelenideElement btnBack = $(By.id("//a[@class= 'ant-calendar-prev-year-btn']"));
    String dateIncalendar = "//*[@class='ant-calendar-tbody']/tr/td[not(@class='ant-calendar-cell ant-calendar-last-month-cell')][not(@class = 'ant-calendar-cell ant-calendar-last-month-cell ant-calendar-last-day-of-month')]/div[contains(text(),'31')]";
    String dateIncalendar1 = "//*[@class=\"ant-calendar-cell\"]/*[@class=\"ant-calendar-date\"][text()=\"30\"]";


}
