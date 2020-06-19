package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;

public class ВклНастройки {
    private ОбщиеПроверки commonChecks;
    private Logger log = LogManager.getLogger(МОкноОплатаУслуг.class);

    @NameTag(name = "Таблица с подключёнными счетами")
    private SelenideElement tableWithAcc = $(By.xpath("//div[@class = 'ant-table-body']"));

    @NameTag(name = "Кнопка Подключить Лицевой счёт")
    private SelenideElement btnAddAcc = $(By.xpath("//button[@class = 'abrr-ui-button primary uppercase']"));

    @NameTag(name = "Коллекция строк в таблице")
//    private SelenideElement collectionAccInTable = $(By.xpath("//table/tbody"));
    private String checkAccInTableIsDisplay = "//tr[contains(.,'%s')]";

    @NameTag(name = "Кнопка Переименовать")
    private String btnRename = "//tr[contains(.,'%s')]/td[3]//*[@class = 'abrr-ui-button primary ghost']";

    @NameTag(name = "Кнопка отключить")
    private String btnOff = "//tr[contains(.,'%s')]/td[3]//*[@class = 'abrr-ui-button red ghost']";
    //-------------------------------------------------------------Всплывающее окно согласия на отключение---------------------------------
    @NameTag(name = "Всплывающее окно согласия на отключение")
    private String popUpDisAcc = "//div[@class = 'ant-popover-inner-content']/div/div[contains(text(),'Отключить лицевой счет %s?')]";

    @NameTag(name = "Всплывающее окно/ Кнопка отключить")
    private SelenideElement popUpBtnOff = $(By.xpath("//button [@class = 'abrr-ui-button red smallsize']"));

    @NameTag(name = "Всплывающее окно/ Кнопка отмена")
    private SelenideElement popUpBtnCancel = $(By.xpath("//button[@class = 'abrr-ui-button primary ghost smallsize abrr-ui-popconfirm-leftbutton']"));
    //-------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------Всплывающее окно Переименования----------------------------------------
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
    //-------------------------------------------------------------------------------------------------------------------------------------

    public void clickBtnOffAcc(String numberAcc) {
        log.debug("_________________Проверяем, что счёт {} присутствует в таблице___________________", numberAcc);
        SelenideElement checkAccIsDISPL = $(By.xpath(String.format(checkAccInTableIsDisplay,numberAcc))).shouldBe(Condition.visible);
        log.debug("_________________Создаём xpath___________________");
        SelenideElement findBtnOff = $(By.xpath(String.format(btnOff,numberAcc)));
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

}
