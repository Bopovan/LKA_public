package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class МОкноОплатаУслуг {

    private Logger log = LogManager.getLogger(МОкноОплатаУслуг.class);

    private String valueInAllSumFields;



    public String getValueInAllSumFields() {
        return valueInAllSumFields;
    }

    public void setValueInAllSumFields(int valueInAllSumFields) {
        this.valueInAllSumFields = Integer.toString(valueInAllSumFields);
    }

     /*
    Модальное окно оплаты услуг
     */

    @NameTag(name = "Окно (Оплата услуг)")
    private SelenideElement windowPayServices = $(By.xpath("//div[@class = 'abrr-ui-title-title small'][contains(text(),'Оплата услуг')]/../../../../.."));

    @NameTag(name = "Кнопка {К оплате}")
    private SelenideElement btnPay = $(By.xpath("//button[contains(@class, 'abrr-ui-button')][contains(.,'К оплате')]"));

    @NameTag(name = "Кнопка {развернуть} Передача показаний")
    private SelenideElement btnSendOfTestimony = $(By.xpath("//button[@class = 'abrr-ui-button circle base']"));

    @NameTag(name = "Раскрывающийся список банковских карт")
    private SelenideElement bankCardList = $(By.xpath("//button[@class = 'abrr-ui-button base abrr-ui-plasticcardselect']"));

    @NameTag(name = "Список  карт")
    private String listOfCard = "//button[@class='abrr-ui-button base']//div[contains(text(),'%d')]";

    @NameTag(name = "Кнопка ввести на странице банка")
    private SelenideElement btnSetCardOnBankForm = $(By.xpath("//button[@class = 'abrr-ui-button primary']"));


    @NameTag(name = "Коллекция полей Сумма платежа")
    private ElementsCollection fieldsSumm = $$(By.xpath("//input[@type = 'text']"));

    @NameTag(name = "Поле суммы платежа у Поля ОПЛОМБИРОВАНИЕ ПРИБОРОВ ГАЗА")
    private SelenideElement fieldSumm1 = $(By.xpath("//div[contains(text(),'ОПЛОМБИРОВАНИЕ ПРИБОРОВ ГАЗА')]//ancestor::*[contains(@class, 'lk-component-FormServices-item odd')]//*[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле суммы платежа у Поля ВОЗМЕЩЕНИЕ ГОСПОШЛИНЫ")
    private SelenideElement fieldSumm2 = $(By.xpath("//div[contains(text(),'ВОЗМЕЩЕНИЕ ГОСПОШЛИНЫ')]//ancestor::*[contains(@class, 'lk-component-FormServices-item odd')]//*[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле суммы платежа у Поля Газоснабжение природным газом")
    private SelenideElement fieldSumm3 = $(By.xpath("//div[contains(text(),'Газоснабжение природным газом')]//ancestor::*[contains(@class, 'lk-component-FormServices-item odd')]//*[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле суммы платежа у Поля ПЕНЯ")
    private SelenideElement fieldSumm4 = $(By.xpath("//div[contains(text(),'ПЕНЯ')]//ancestor::*[contains(@class, 'lk-component-FormServices-item odd')]//*[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле суммы платежа у Поля ГАЗ")
    private SelenideElement fieldSumm5 = $(By.xpath("//div[contains(text(),'ГАЗ')]//ancestor::*[contains(@class, 'lk-component-FormServices-item odd')]//*[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Услуга ГАЗ")
    private SelenideElement fieldGas = $(By.xpath("//div[contains(text(),'ГАЗ')]//ancestor::*[contains(@class, 'lk-component-FormServices-item odd')]//*[contains(text(),'ГАЗ')]"));

    @NameTag(name = "Xpath для ввода суммы в поле выбрав его по порядковому номеру")
    private String fieldSum = "//div[@class = 'lk-component-FormServices-container']/descendant::input[@type = 'text'][%d]";

    @NameTag(name = "ошибка с текстом Некорректная сумма")
    private SelenideElement textErrorSumMin = $(By.xpath("//div[contains(text(),'Некорректная сумма')]/following-sibling::div[contains(text(),'Сумма не может быть меньше 10 руб.')]"));


    /*
    Модальное окно подтверждения платежа
     */

    @NameTag(name = "иконка подтверждения")
    private SelenideElement iconSuccess = $(By.xpath("//i[contains(@class,'success')]"));

    @NameTag(name = "текст подтверждения оплаты (Оплата успешно выполнена!)")
    private SelenideElement textSuccess = $(By.xpath("//h1[contains(text(),'Оплата успешно выполнена!')]"));

    @NameTag(name = "кнопка Закрыть")
    private SelenideElement btnClose = $(By.xpath("//button[contains(@class,'abrr-ui-modal-final-button')]"));


    public void cleanAllSummFields() {
        for (SelenideElement field : fieldsSumm) {
            log.trace("\n\n_____________________________\n\nНаходим все поля {Суммы}\n\n______________________________");
            field.shouldBe(Condition.visible);
            if (field.getValue().length() >= 0) {
                log.trace("\n\n_____________________________\n\nЗаходим в цикл и определяем длину массива с полями сумм = {}\n\n______________________________", field.getValue().length());
                for (int i = 0; i <= field.getValue().length() + 2; i++) {
                    log.trace("\n\n_____________________________\n\nНажимаем кнопку {BACK_SPACE}\n\n______________________________");
                    field.sendKeys(Keys.BACK_SPACE);
                }
            } else {
                Assert.fail("\n\n_______________________________\n\nОШИБКА!Не получилось вычислить длину значения в поле Суммы\n\n_______________________________");
            }
            log.trace("\n\n_____________________________\n\nПрописываем пустые значения в каждом поле\n\n______________________________");
            field.shouldBe(Condition.visible).setValue("");
        }
    }

    public void setFieldSum(int numberOfElement, String sum) {
        SelenideElement elementFieldSum = $(By.xpath(String.format(fieldSum, numberOfElement)));
        elementFieldSum.shouldBe(Condition.visible).setValue(sum);
    }

    public void setAllFieldsSumm(String sum) {
        for (SelenideElement fieldSum : fieldsSumm) {
            fieldSum.setValue(sum);
        }
        setValueInAllSumFields(Integer.parseInt(sum) * fieldsSumm.size());
    }

    public void clickOnCard(int cardNum) {
        SelenideElement card = $(By.xpath(String.format(listOfCard, cardNum)));
        card.shouldBe(Condition.visible).click();
    }

}
