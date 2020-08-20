package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ВклНастройки {

    private ОбщиеПроверки commonChecks;
    private Logger log = LogManager.getLogger(МОкноОплатаУслуг.class);


    /*
    Вложенная вкладка ЛИЦЕВЫЕ СЧЕТА
    */



    @NameTag(name = "Кнопка Подключить Лицевой Счет")
    private SelenideElement btnAddAcc = $(By.xpath("//*[contains(text(), 'Подключить лицевой счет')]/.."));

    @NameTag(name = "Кнопка Изменить логин")
    private SelenideElement btnChangeLogin2 = $(By.xpath("//div[contains(text(),'Изменить логин')]/.."));

    @NameTag(name = "Таблица с подключёнными счетами")
    private SelenideElement tableWithAcc = $(By.xpath("//div[@class = 'ant-table-body']"));

    @NameTag(name = "Коллекция строк в таблице")
    private String checkAccInTableIsDisplay = "//tr[contains(.,'%s')]";

    /*
    Вложенная вкладка ПРОФИЛЬ
    */
    @NameTag(name = "вкладка Профиль")
    private SelenideElement tabProfile = $(By.xpath("//div[contains(text(),'Профиль')]/.."));

    @NameTag(name = "Кнопка  {сменить Логин}")
    private SelenideElement btnChangeLogin = $(By.xpath("//*[contains(text(),'Сменить логин')]/.."));

    @NameTag(name = "Поле пароль")
    private SelenideElement fieldPassword = $(By.xpath("//*[contains(text(),'Пароль')]//following-sibling::div/input"));

    @NameTag(name = "Поле Телефон или эл. почта")
    private SelenideElement fieldEmail = $(By.xpath("//*[contains(text(),'Телефон')]//following-sibling::div/input"));

    public void setNewEmail(String newEmail, String oldPassword){
        fieldPassword.shouldBe(Condition.visible).setValue(oldPassword);
        fieldEmail.shouldBe(Condition.visible).setValue(newEmail);
    }

    @NameTag(name = "Кнопка  {сменить Пароль}")
    private SelenideElement btnChangePassword = $(By.xpath("//*[contains(text(),'Сменить пароль')]/.."));

    @NameTag(name = "Поле Введите старый пароль")
    private SelenideElement fieldTypeOldPassword = $(By.xpath("//*[text() = 'Введите старый пароль']/following-sibling::div/input"));

    @NameTag(name = "Поле Введите новый пароль")
    private SelenideElement fieldTypeNewPassword = $(By.xpath("//*[text() = 'Введите новый пароль']/following-sibling::div/input"));

    @NameTag(name = "Поле Введите новый пароль еще раз")
    private SelenideElement fieldTypeNewPasswordAgain = $(By.xpath("//*[text() = 'Введите новый пароль еще раз']/following-sibling::div/input"));

    public void typeOldPassword(String oldPassword){
        fieldTypeOldPassword.shouldBe(Condition.visible).setValue(oldPassword);
    }

    public void typeNewPassword(String newPassword){
        fieldTypeNewPassword.shouldBe(Condition.visible).setValue(newPassword);
        fieldTypeNewPasswordAgain.shouldBe(Condition.visible).setValue(newPassword);
    }

    /*
    Вложенная вкладка КАРТЫ
    */

    @NameTag(name = "Вкладка {Карты}")
    private SelenideElement tabCards = $(By.xpath("//*[contains(text(),'Карты')]"));



    @NameTag(name = "Кнопка-иконка добавить карту")
    private SelenideElement btnAddCards = $(By.xpath("//*[contains(@class ,'abrr-ui-plastic-card-addcard')]"));


    @NameTag(name = "Кнопка Переименовать")
    private String btnRename = "//tr[contains(.,'%s')]/td[3]//*[@class = 'abrr-ui-button primary ghost']";

    @NameTag(name = "Кнопка отключить")
    private String btnOff = "//td//div[contains(text(),'%s')]/../../../../td/div//button[contains(@class,'red')]";

    @NameTag(name = "Всплывающее окно согласия на отключение")
    private String popUpDisAcc = "//div[@class = 'ant-popover-inner-content']/div/div[contains(text(),'Отключить лицевой счет %s?')]";

    @NameTag(name = "Всплывающее окно/ Кнопка отключить")
    private SelenideElement popUpBtnOff = $(By.xpath("//button [@class = 'abrr-ui-button red smallsize']"));

    @NameTag(name = "Всплывающее окно/ Кнопка отмена")
    private SelenideElement popUpBtnCancel = $(By.xpath("//button[@class = 'abrr-ui-button primary ghost smallsize abrr-ui-popconfirm-leftbutton']"));

    @NameTag(name = "Всплывающее окно согласия на отключение")
    private SelenideElement popUpRenameAcc = $(By.xpath("//button[@class = 'abrr-ui-button primary uppercase fullwidth']/../."));

    @NameTag(name = "Номер счёта в окне Переименовать аккаунт")
    private String popNumAcc = "//div[@class = 'abrr-ui-title-subtitle'][contains(text(),'%s')]";

    @NameTag(name = "Поле для ввода Нового имени счёта")
    private SelenideElement fieldRenameAcc = $(By.xpath("//input[@type = 'text']"));

    @NameTag(name = "Всплывающее окно/ Кнопка {Сохранить}")
    private SelenideElement popUpBtnSave = $(By.xpath("//button[@class = 'abrr-ui-button primary uppercase fullwidth']"));

    @NameTag(name = "Всплывающее окно/ Кнопка {Х}")
    private SelenideElement popUpBtnClose = $(By.xpath("//button[@class = 'abrr-ui-modal-closeButton']")); //проверить, эелемент общий? на всех вспылвающих окнах?

    @NameTag(name = "Имя карты в системе")
    private SelenideElement cardName = $(By.xpath("//div[contains(@class,'abrr-ui-title-title small')]"));

    @NameTag(name = "поле для нового имени Карты")
    private SelenideElement fieldNewName = $(By.xpath("//input[@type = 'text']"));

    @NameTag(name = "Кнопка Сохранить после переименования")
    private SelenideElement btnSaveRename = $(By.xpath("//*[contains(text(),'Сохранить')]/.."));

    @NameTag(name = "Кнопка Удалить карту")
    private SelenideElement btnDeleteCard = $(By.xpath("//*[contains(text(),'Удалить карту')]/.."));

    @NameTag(name = "коллекция пркреплённых банковских карт")
    public String addCards = "//div[contains(text(),'%s')]/..";

    @NameTag(name = "коллекция пркреплённых счетов")
    public ElementsCollection addAC = $$(By.xpath("//tbody/tr"));


    public void checkCountAccInTable(int count){
        addAC.shouldHaveSize(count);
    }


    public void findNeedCard(String lastFourNum) {
        log.trace("____________________________________\n\n пробуем найти карту с последними цифрами: {}", lastFourNum);
        SelenideElement element = $(By.xpath(String.format(addCards, lastFourNum)));
        element.shouldBe(Condition.visible);
    }

    public void cardIsNotDisplayed(String lastFourNum) {
        log.trace("____________________________________\n\n пробуем найти карту, которой не должно быть! с последними цифрами: {}", lastFourNum);
        SelenideElement element = $(By.xpath(String.format(addCards, lastFourNum)));
        element.shouldBe(Condition.not(Condition.visible));
    }

    public void accIsNotDisplayed(String accNum) {
        log.trace("____________________________________\n\n пробуем найти счет, которой не должно быть! с цифрами: {}", accNum);
        SelenideElement element = $(By.xpath(String.format(checkAccInTableIsDisplay, accNum)));
        element.shouldBe(Condition.not(Condition.visible));
    }


    public void clickBtnOffAcc(String numberAcc) {
        log.debug("_________________Проверяем, что счёт {} присутствует в таблице___________________", numberAcc);
        SelenideElement checkAccIsDISPL = $(By.xpath(String.format(checkAccInTableIsDisplay, numberAcc))).shouldBe(Condition.visible);
        log.debug("_________________Создаём xpath___________________");
        SelenideElement findBtnOff = $(By.xpath(String.format(btnOff, numberAcc)));
        log.debug("_________________xpath {}___________________", findBtnOff);
        findBtnOff.shouldBe(Condition.visible);
        log.debug("_________________Нажимаем на кнопку {Отключить}, у счёта {}___________________", numberAcc);
        findBtnOff.click();
        log.debug("_________________Создаём xpath___________________");
        SelenideElement popUpWithCurrentAcc = $(By.xpath(String.format(popUpDisAcc, numberAcc))).shouldBe(Condition.visible);
        log.debug("_________________Проверяем, что отображается тот же счёт, который мы отключаем ___________________");
        log.debug("_________________Проверяем, доступна ли кнопка Отмена?___________________");
        log.debug("_________________На всплывающем окне нажимаем кнопку {Отключить} счёт: {}___________________", numberAcc);
        popUpBtnOff.shouldBe(Condition.visible).click();
        log.debug("_________________Проверяем, что счёт {} отсутсвует в таблице___________________", numberAcc);
        checkAccIsDISPL.shouldBe(Condition.hidden);

    }


    public void clickBtnRenameAcc(String numberAcc) {
        SelenideElement findBtnRename = $(By.xpath(String.format(btnRename, numberAcc)));
        log.debug("_________________Создаём xpath {}___________________", findBtnRename);
        findBtnRename.shouldBe(Condition.visible);
        findBtnRename.click();
        log.debug("_________________Нажимаем на кнопку {Переименовать}, у счёта {}___________________", numberAcc);
        popUpRenameAcc.shouldBe(Condition.visible);
        SelenideElement checkRightAccRename = $(By.xpath(String.format(popNumAcc, numberAcc)));
        checkRightAccRename.shouldBe(Condition.visible);
        log.debug("_________________Проверяем, что отображается тот же счёт, что мы выбрали___________________");
        fieldRenameAcc.shouldBe(Condition.visible);
        log.debug("_________________Проверяем, что отображается поле для ввода Нового имени___________________");
        popUpBtnSave.shouldBe(Condition.visible);
        log.debug("_________________Проверяем, что отображается кнопка {Сохранить}___________________");
        popUpBtnClose.shouldBe(Condition.visible);
        log.debug("_________________Проверяем, что отображается кнопка {Х}___________________");
    }

    public void checkAccInTable(String numberAcc, Boolean condition) {
        SelenideElement check = $(By.xpath(String.format(checkAccInTableIsDisplay, numberAcc)));
        log.debug("_________________Создаём xpath {}___________________", check);
        if (condition) {
            check.shouldBe(Condition.visible);
            log.debug("_______________Проверяем ОТОБРАЖАЕТСЯ элемент на странице? значение параметра {}_________________", condition);
        } else {
            check.shouldBe(Condition.hidden);
            log.debug("_______________Проверяем НЕ ОТОБРАЖАЕТСЯ элемент на странице? значение параметра {}_________________", condition);
        }
    }

    public void destroyCard(String numCard) {
        SelenideElement card = $(By.xpath(String.format(addCards, numCard))).shouldBe(Condition.visible);
        card.click();
        btnDeleteCard.shouldBe(Condition.visible).click();
    }

    public void destroyAcc(String fullNumAcc) {
        SelenideElement card = $(By.xpath(String.format(btnOff, fullNumAcc))).shouldBe(Condition.visible);
        card.click();
        popUpBtnCancel.shouldBe(Condition.visible).click();
        card.click();
        popUpBtnOff.shouldBe(Condition.visible).click();
    }

}
