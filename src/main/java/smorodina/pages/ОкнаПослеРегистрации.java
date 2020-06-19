package smorodina.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;

public class ОкнаПослеРегистрации {
    private Logger log = LogManager.getLogger(МОкноОплатаУслуг.class);

    @NameTag(name = "Окно_с_надписью_ПРИВЕТ")
    private SelenideElement windowHello = $(By.xpath("//div[@class='lk-buddyview-buddy']"));

    @NameTag(name = "Кнопка_Выход")
    private SelenideElement btnExit = $(By.xpath("//i[@class='anticon anticon-arrow-left abrr-ui-button-icon abrr-ui-button-icon-left']/../.."));

    @NameTag(name = "Кнопка_Хорошо")
    private SelenideElement btnFine = $(By.xpath("//button[@class='abrr-ui-button primary lk-buddyview-buddy-button']"));

    @NameTag(name = "Окно_ознакомления_с_условиями")
    private SelenideElement windowWithConditions = $(By.xpath("//div[@class='lk-buddyview-buddy']"));

    @NameTag(name = "Кнопка_открыть_на_весь_экран")
    private SelenideElement btnFullScreen = $(By.xpath("//button[@class='abrr-ui-button smallsize']"));

    @NameTag(name = "Кнопка_я_согласен")
    private SelenideElement btnAccept = $(By.xpath("//button[@class='abrr-ui-button primary lk-buddyview-buddy-button']"));

    @NameTag(name = "Окно_подключить_счет")
    private SelenideElement windowConnectAccount = $(By.xpath("//*[@class='lk-buddyview-buddy'][contains(.,'Теперь Вы можете подключить свой лицевой счет, а если у Вас еще нет лицевого счета, Вы можете создать заявку на подключение к системе газораспределения.')]"));

    @NameTag(name = "Кнопка_Подключить_лицевой_счет")
    private SelenideElement btnConnectFirstAccount = $(By.xpath("//*[@class='abrr-ui-button primary lk-buddyview-buddy-button'][contains(.,'Подключить лицевой счет')]"));

    @NameTag(name = "Кнопка_заявка_на_подключение")
    private SelenideElement btnConnectionApplication = $(By.xpath("//*[@class='abrr-ui-button primary ghost base lk-buddyview-buddy-button'][contains(.,'Создать заявку на техническое присоединение')]"));

    @NameTag(name = "Комбобокс_Выберите_ресурсоснабжающую_организацию")
    private SelenideElement comboboxSelectOrganization = $(By.xpath("//div[@class='ant-select-selection__rendered']"));

    @NameTag(name = "Окно_подключить_счет/Кнопка_отмена")
    private SelenideElement btnCancel = $(By.xpath("//button[@class='abrr-ui-button primary ghost lk-buddyview-buddy-button']"));

    @NameTag(name = "Окно_подключить_счет/Кнопка_продолжить")
    private SelenideElement btnContinue = $(By.xpath("//button[@class='abrr-ui-button primary lk-buddyview-buddy-button']"));

    @NameTag(name = "Окно_подключить_счет/Кнопка_продолжить_заблокированная")
    private SelenideElement btnContinueBlocked = $(By.xpath("//*[@class='abrr-ui-button primary disabled lk-buddyview-buddy-button']"));

    @NameTag(name = "Окно_подключить_счет/Поле_введите_номер_счета")
    private SelenideElement fieldNumberAcc = $(By.xpath("//*[@class= 'abrr-ui-textfield-wrapper']"));

//    @NameTag(name = "Окно_подключить_счет/Поле_введите_номер_счета")
//    private SelenideElement  = $(By.xpath("//*[@type='text']"));












}
