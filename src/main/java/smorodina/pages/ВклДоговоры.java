package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.*;

public class ВклДоговоры {
    private Logger log = LogManager.getLogger(МОкноОплатаУслуг.class);

    @NameTag(name = "Содержимое вкладки Договоры")
    private SelenideElement tabContracts = $(By.xpath("//div[@class = 'lk-box']/../../.."));

    @NameTag(name = "Радиокопка {Скрыть черновики}")
    private SelenideElement radioBtnHiddenList = $(By.xpath("//div/*[contains(@class, 'ant-switch')]"));

    @NameTag(name = "Кнопка {Залючение нового договора}")
    private SelenideElement btnNewContract = $(By.xpath("//button[@class='abrr-ui-button primary uppercase']"));

    @NameTag(name = "Строчка в таблице")
    private String tableWithName = "//table//*/tr[contains(.,'%s')]"; // можно на точное совпадение, а можно сделать по номеру договора (#321)

//    @NameTag(name = "Кнопка {Продолжить заполонение} в строчке с нужным договором")
//    private String btnContinue = "//table//*/tr[contains(.,'%d')]//button[@class = 'abrr-ui-button primary uppercase smallsize']";

    @NameTag(name = "Строка в таблице с нужным договором")
    private String lineWithContract = "//table//*/tr[contains(.,'%d')]";


    @NameTag(name = "Кнопка {Удалить} в строчке с нужным договором")
    private String btnDelete = "//table//*/tr[contains(.,'Договор на поставку газа')]//button[@class = 'abrr-ui-button ghost uppercase smallsize']";


    //===========================================Окно Персональная информация=============================================================

    @NameTag(name = "Окно Заключение договоров")
    private SelenideElement windowNewContracts = $(By.xpath("//div[@class = 'abrr-ui-title-title']/../../../../.."));

    //--------------------------------------------------Поля Заказчик-------------------------------------------------------------------

    @NameTag(name = "Поле Фамилия")
    private SelenideElement fieldSurName = $(By.xpath("//*[contains(.,'Фамилия')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Имя")
    private SelenideElement fieldName = $(By.xpath("//*[contains(.,'Имя')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Отчество")
    private SelenideElement fieldMiddleName = $(By.xpath("//*[contains(.,'Отчество')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    //--------------------------------------------------Поля Место жительства-------------------------------------------------------------------
//______________________________________!!Универсальные поля, для всех шагов создания нового Договора!!_____________________________________
    @NameTag(name = "Поле Регион")
    private SelenideElement fieldRegion = $(By.xpath("//*[contains(.,'Регион')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Район")
    private SelenideElement fieldArea = $(By.xpath("//*[contains(.,'Район')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Город")
    private SelenideElement fieldCity = $(By.xpath("//*[contains(.,'Город')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Улица")
    private SelenideElement fieldStreet = $(By.xpath("//*[contains(.,'Улица')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Дом")
    private SelenideElement fieldHouse = $(By.xpath("//*[contains(.,'Дом')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Корпус")
    private SelenideElement fieldHousing = $(By.xpath("//*[contains(.,'Корпус')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Квартира")
    private SelenideElement fieldFlat = $(By.xpath("//*[contains(.,'Квартира')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

//--------------------------------------------------Поля Документ удостоверяющий личность----------------------------------------------------------

    @NameTag(name = "Поле Тип Документа")
    private SelenideElement fieldTypeOfDocument = $(By.xpath("//div[@role = 'combobox']//*[text()='Тип документа']/../.."));

    @NameTag(name = "Комбобокс Тип документа")
    private SelenideElement comboboxTypeDoc = $(By.xpath("//div[@class = 'ant-select-selection__rendered']"));
//            ("//ul[@class = 'ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']\n"));

    @NameTag(name = "Календарь-поле дата выдачи")
    private SelenideElement calendar = $(By.xpath("//input[contains(@class,'ant-calendar-picker-input')]"));

    @NameTag(name = "Календарь-поле дата выдачи / поле для ввода даты")
    private SelenideElement fieldDate = $(By.xpath("//input[@class = 'ant-calendar-input ']"));

    @NameTag(name = "Поле Серия")
    private SelenideElement fieldSeries = $(By.xpath("//*[contains(.,'Серия')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Номер")
    private SelenideElement fieldNumber = $(By.xpath("//*[contains(.,'Номер')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    @NameTag(name = "Поле Кем выдан")
    private SelenideElement fieldIssuedBy = $(By.xpath("//*[contains(.,'Кем выдан')]/div[@class = 'abrr-ui-textfield-wrapper']/input"));

    //-----------------------------Общие Кнопки Сохранить черновик, Продолжить заполнение и Назад-----------------------------

    @NameTag(name = "Кнопка {Сохранить черновик}")
    private SelenideElement btnSaveList = $(By.xpath("//div[text()= 'СОХРАНИТЬ ЧЕРНОВИК']/.."));

    @NameTag(name = "Кнопка {Продолжить заполнение}")
    private SelenideElement btnContinueFilling = $(By.xpath("//div[text()= 'ПРОДОЛЖИТЬ ЗАПОЛНЕНИЕ']/.."));

    @NameTag(name = "Кнопка {Назад}")
    private SelenideElement btnBack = $(By.xpath("//div[text()= 'Назад']/.."));

    //==========================================================Окно Информация об объекте=============================================================

    @NameTag(name = "Окно Информация об объекте")
    private SelenideElement windowObjectInformation = $(By.xpath("//div[contains(@class, 'lk-page-contracts-steps-template')]"));

    //---------------------------------Поля Объект газификации--------------------------------------------

    @NameTag(name = "Поле Тип объекта газификации")
    private SelenideElement fieldTypeOfObject = $(By.xpath("//*[contains(.,'Тип объекта газификации')]/div/input"));

    @NameTag(name = "Комбобокс Тип объекта газификации")
    private SelenideElement comboboxTypeOfObject = $(By.xpath("//div[contains(text(),'Тип документа на собственность')]/.."));

    @NameTag(name = "Поле серия/номер")
    private SelenideElement fieldSerialAndNumber = $(By.xpath("//*[contains(.,'Серия / Номер')]/div/input"));

    @NameTag(name = "Комбобокс Принадлежность объекта")
    private SelenideElement comboboxObjectOwnership = $(By.xpath("//div[text()='Принадлежность объекта']/.."));

    @NameTag(name = "Календарь-поле Дата документа")
    private SelenideElement calendarDocumentDate = $(By.xpath("//*[contains(@placeholder,'Дата документа')]"));

    @NameTag(name = "Поле кем Зарегистрирован")
    private SelenideElement fieldRegistration = $(By.xpath("//*[contains(.,'Кем зарегистрирован')]/div/input"));

    //---------------------------------Поля Адрес объекта газификации--------------------------------------------

    //элементы и xpath в точности дублирует поля с шага 1 (Поля Место жительства)

    //---------------------------------Поля Газовое оборудование--------------------------------------------

    @NameTag(name = "Кнопка {Добавить оборудование}")
    private SelenideElement btnAddEquipment = $(By.xpath("//button[@class='abrr-ui-button primary'][contains(.,'Добавить оборудование')]"));

    @NameTag(name = "Кнопка {Удалить оборудование}")
    private String btnDeleteEquipment = "//button[contains(.,'Добавить оборудование')]/following-sibling::div[%d]//i/..";

    @NameTag(name = "Комбобокс Тип оборудования")
    private String comboboxTypeEquipment = "//button[contains(.,'Добавить оборудование')]/following-sibling::div[%d]//div[@role = 'combobox']";

    @NameTag(name = "Поле Наименование оборудования")
    private String fieldNameEquipment = "//button[contains(.,'Добавить оборудование')]/following-sibling::div[1]//label [contains(.,'Наименование')]/following-sibling::div/input";

    @NameTag(name = "Поле Модель оборудования")
    private String fieldModelEquipment = "//button[contains(.,'Добавить оборудование')]/following-sibling::div[1]//label [contains(.,'Модель')]/following-sibling::div/input";

    //---------------------------------Поля Прибор учета--------------------------------------------

    @NameTag(name = "Комбобокс Тип установленного прибора учета газа ")
    private SelenideElement comboboxTypeAddEquipment = $(By.xpath("//div/div/div[contains(text(),'Тип установленного прибора учета газа')]/.."));

    @NameTag(name = "Комбобокс Место присоединения прибора учета газа")
    private SelenideElement comboboxLocationAddEquipment1 = $(By.xpath("//div/div/div[contains(text(),'Место присоединения прибора учета газа')]/.."));


//    public void continueContractWork(int numAcc) {
//        SelenideElement expectedBtn = $(By.xpath(String.format(btnContinue, numAcc))).waitUntil(Condition.visible, 5000);
//        expectedBtn.click();
//    }

    public void continueContractWork(int numAcc, String btn) {
        log.debug("________________________________________________________\n\n    Находим нужную строку с договором: :{}. \n\n________________________________________________________", numAcc);
        SelenideElement expectedLine = $(By.xpath(String.format(lineWithContract, numAcc))).waitUntil(Condition.visible, 5000);
        log.debug("________________________________________________________\n\n    В нужной нам строчке нажимаем на кнпоку :{}. \n\n________________________________________________________", btn);
        expectedLine.find(By.xpath(String.format("//*[contains(text() , '%s')]/..", btn))).click();
    }


}
