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

    @NameTag(name = "Поле введите номер счета")
    private SelenideElement fieldNumberAcc = $(By.xpath("//input[@type = 'text']"));



    public void setOrganizationCombobox(String value) {
        comboboxSelectOrganizationClose.click();
        comboboxSelectOrganizationOpen.shouldBe(Condition.visible).setValue(value).pressEnter();
    }

}
