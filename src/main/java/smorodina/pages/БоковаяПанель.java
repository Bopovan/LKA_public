package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class БоковаяПанель {

    @NameTag(name = "Кнопка Выход на главном экране")
    public SelenideElement quitButton = $(By.xpath("//button[@class='abrr-ui-button circle base lk-mainframe-header-exit']"));

    @NameTag(name = "Поле с именем пользователя")
    private SelenideElement nameField = $(By.xpath("//button[@class = 'abrr-ui-button circle base lk-mainframe-header-exit']/../div[1]"));

    @NameTag(name = "Кнопка разворачивание подключенных счетов")
    private SelenideElement openAllAccounts = $(By.xpath("//*[contains(@class,'anticon-down-circle-o')]/../.."));

    @NameTag(name = "Номер активного счёта")
    private SelenideElement activeAccountNumber = $(By.xpath("//*[@class = 'anticon anticon-solution lk-mainframe-nav-accountselect-personicon']/preceding-sibling::div/div[1]"));

    @NameTag(name = "Описание активного счёта")
    private SelenideElement DescriptionOfActiveAccount = $(By.xpath("//*[@class = 'anticon anticon-solution lk-mainframe-nav-accountselect-personicon']/preceding-sibling::div/div[2]/."));

    @NameTag(name = "Коллекция подключенных счетов")
    private String collectionConnectedAccounts = "//div[contains(@class, 'lk-mainframe-accountlist')]//button//div[contains(text(),'%s')]/../../../..";

    @NameTag(name = "Кнопка {Добавить лицевой счет}")
    private SelenideElement buttonAddPersonalAccount = $(By.xpath("//button[@class = 'abrr-ui-button base lk-mainframe-nav-accountselect-add']"));

    @NameTag(name = "Вкладка Лицевой счёт")
    private SelenideElement personalAccountTab = $(By.xpath("//div[contains(text(), 'Лицевой счет')]/../.."));

    @NameTag(name = "Вкладка Карта отделений")
    private SelenideElement branchMapTab = $(By.xpath("//div[contains(text(), 'Карта отделений')]/../.."));

    @NameTag(name = "Вкладка Договоры")
    private SelenideElement contractsTab = $(By.xpath("//*[@class = 'anticon anticon-form']/../.."));

    @NameTag(name = "Вкладка Настройки")
    private SelenideElement settingTab = $(By.xpath("//div[contains(text(),'Настройки')]/../.."));

    @NameTag(name = "Вкладка Техническая поддержка")
    private SelenideElement technicalSupportTab = $(By.xpath("//div[contains(text(),'Техническая поддержка')]/../.."));

    @NameTag(name = "Коллекция пунктов меню")
    private ElementsCollection collectionMenuElements = $$(By.xpath("//div[contains(@class,'lk-mainframe-nav-menu-item-label')]"));



    public boolean sideBarIsVisible() {
        boolean sideBarISVisible = false;
        SelenideElement elementMenu = collectionMenuElements.get((int) (Math.random() * collectionMenuElements.size()));
        if (elementMenu.is(Condition.visible)) {
            return sideBarISVisible = true;
        } else {
            return sideBarISVisible;
        }
    }

    public SelenideElement findNeededAcc(String numAcc) {
        return $(By.xpath(String.format(collectionConnectedAccounts,numAcc)));
    }

}
