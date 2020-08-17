package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

public class ОкноЭквайринга {

    private String transactionNumber = "";

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }


    /*
    Страница регистрации
     */

    @NameTag(name = "Поле номер карты при регистрации")
    private SelenideElement cardNumber = $(By.id("pan"));

    @NameTag(name = "Поле месяц")
    private SelenideElement monthSelect = $(By.id("expMon"));

    @NameTag(name = "Поле год")
    private SelenideElement yearSelect = $(By.id("expYear"));

    @NameTag(name = "Поле имя на карте")
    private SelenideElement cardholder = $(By.id("cardholder"));

    @NameTag(name = "Поле cvv2")
    private SelenideElement cvv2 = $(By.id("cvv2"));

    @NameTag(name = "чек-бокс Оферты")
    private SelenideElement checkBoxOffer = $(By.id("checkbox-offer"));

    @NameTag(name = "кнопка Зарегистрировать")
    private SelenideElement btnReg = $(By.id("send"));

    @NameTag(name = "кнопка Вернуться")
    private SelenideElement btnBack = $(By.id("cancel"));

    /*
   Страница успешной операции
    */

    @NameTag(name = "подтверждение регистрации карты")
    private SelenideElement registrSucess = $(By.xpath("//div[contains(text(),'Карта успешно зарегистрирована')]"));

    @NameTag(name = "надпись Регистрация карты")
    private SelenideElement nameModalWindow = $(By.xpath("//span[contains(text(),'Регистрация карты')]"));

     /*
   Страница ошибки регистрации карты
    */

    @NameTag(name = "ошибка регистрации карты")
    private SelenideElement registrError = $(By.xpath("//*[contains(text(),'Карта не зарегистрирована')]"));

    @NameTag(name = "причина ошибки регистрации карты")
    private SelenideElement explainErrorRegCard = $(By.xpath("//*[contains(text(),'Причина:Карта клиента имеет неправильный статус')]"));

     /*
    Страница оплаты
     */

    @NameTag(name = "Поле номер карты при оплате")
    private SelenideElement payNumOfCard = $(By.id("cp-pan-decor"));

    @NameTag(name = "Поле месяц/год")
    private SelenideElement payMonthYear = $(By.id("cp-expiration-date"));

    @NameTag(name = "Поле владелец карты")
    private SelenideElement payOwnerCard = $(By.id("cp-full-name"));

    @NameTag(name = "Поле cvv2")
    private SelenideElement payCVV2 = $(By.id("cvv2"));

    @NameTag(name = "чек-бокс Зарегистрировать карту")
    private SelenideElement payRegCard = $(By.id("registerCard"));

    @NameTag(name = "кнопка ОК")
    private SelenideElement payBtnOK = $(By.id("OK"));

    @NameTag(name = "кнопка Отмена")
    private SelenideElement payBtnCancle = $(By.xpath("//button[contains(text(),'Отмена')]"));

    @NameTag(name = "текст Номер транзакции")
    private SelenideElement transactionNumberOnCheck = $(By.xpath("//td[text() = 'Номер чека']/following-sibling::td"));

    @NameTag(name = "текст Сумма")
    private SelenideElement sumNumberOnCheck = $(By.xpath("//td[text() = 'Сумма']/following-sibling::td"));

    public void saveTransNum() {
        setTransactionNumber(transactionNumberOnCheck.shouldBe(Condition.visible).getText());
    }
}
