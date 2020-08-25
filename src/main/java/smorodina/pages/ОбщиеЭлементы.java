package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;

public class ОбщиеЭлементы {

//========================Модальное окно с текстом Какая региональная газовая компания Вас обслуживает?======================

    @NameTag(name = "Комбобокс_Выберите_ресурсоснабжающую_организацию_ЗАКРЫТЫЙ")
    private SelenideElement comboboxSelectOrganizationClose = $(By.xpath("//*[@role= 'combobox']"));

    @NameTag(name = "Комбобокс_Выберите_ресурсоснабжающую_организацию_РАЗВЁРНУТЫЙ")
    private SelenideElement comboboxSelectOrganizationOpen = $(By.xpath("//input[@class= 'ant-select-search__field']"));

    @NameTag(name = "Кнопка продолжить")
    private SelenideElement btnContinue = $(By.xpath("//button[@class='abrr-ui-button primary lk-buddyview-buddy-button']"));

    @NameTag(name = "Кнопка {X}")
    private SelenideElement btnX = $(By.xpath("//i[contains(@class,'anticon-close')]/.."));

    @NameTag(name = "Поле введите номер счета")
    private SelenideElement fieldNumberAcc = $(By.xpath("//input[@type = 'text']"));

//    @NameTag(name = "Кнопка {Отмена}")
//    private SelenideElement btnCancel = $(By.xpath("//button[@class = 'abrr-ui-button primary ghost uppercase'][contains(.,'Отмена')]"));

    @NameTag(name = "Кнопка {Отмена}")
    private SelenideElement btnCancel = $(By.xpath("//div[contains(text(),'Отмена')]/.."));

    @NameTag(name = "Кнопка {Отправить}")
    private SelenideElement btnSend = $(By.xpath("//div[contains(text(),'Отправить')]/.."));

    @NameTag(name = "кнопка {Закрыть}")
    private SelenideElement btnCloseModal = $(By.xpath("//div[contains(text(),'Закрыть')]/.."));

    @NameTag(name = "кнопка {Сохранить}")
    private SelenideElement btnSaveModal = $(By.xpath("//div[contains(text(),'Сохранить')]/.."));


    public void setOrganizationCombobox(String value) {
        comboboxSelectOrganizationClose.click();
        comboboxSelectOrganizationOpen.shouldBe(Condition.visible).setValue(value).pressEnter();
    }

}
