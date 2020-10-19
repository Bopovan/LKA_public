package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Not;
import com.codeborne.selenide.conditions.Visible;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import smorodina.Utils.NameTag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ОкноАвторизации {

    Configuration configuration;

    private Configuration getConfiguration() {
        Configuration.browser = "chrome"; //ie //chrome //edje //opera //firefox
        Configuration.timeout = 1000;
        Configuration.driverManagerEnabled = true;
//        Configuration.browserVersion = "73.0.3683.75";
        Configuration.startMaximized = true;
//        Configuration.reopenBrowserOnFail = true;
        Configuration.holdBrowserOpen = false;
        return configuration;
    }

    private final Logger log = LogManager.getLogger(ОкноАвторизации.class);

    @NameTag(name = "Окно_авторизации")
    private final SelenideElement startWindow = $(By.id("View3D"));

    @NameTag(name = "Поле_логин")
    public final SelenideElement
            loginField = $(By.xpath("//input[@placeholder = 'Логин']"));

    @NameTag(name = "Поле_пароль")
    public final SelenideElement
            passwordField = $(By.xpath("//input[@placeholder = 'Пароль']"));

    @NameTag(name = "Кнопка_входа_в_личный_кабинет")
    private final SelenideElement
            enterButton = $(By.xpath("//button[@class = 'abrr-ui-button primary uppercase fullwidth']"));

    @NameTag(name = "Ссылка_<Регистрация>")
    private final SelenideElement
            registrationLink = $(By.xpath("//a[@href = '/login/signup']"));

    @NameTag(name = "Ссылка_<Забыли_пароль?>")
    private final SelenideElement
            forgotPasswordLink = $(By.xpath("//a[@href = '/login/recovery']"));

    @NameTag(name = "Ссылка_<Техническая_поддержка>")
    private final SelenideElement
            supportLink = $(By.xpath("//a[contains(text(), 'Задать вопрос в техническую поддержку')]"));

    @NameTag(name = "Текстовые_ошибки")
    private final SelenideElement
            error = $(By.xpath("//div[@class = 'view-login-error'][contains(text(),'$s')]"));

    private final String errorSQL = "Произошла ошибка обработки запроса, попробуйте еще раз.";


    public void enterWithTestUserAcc(String login, String password) {
        log.debug("\n\n__________________Авторизуемся под учётной записью {} и паролем {}_____________________\n\n", login, password);
        getConfiguration();
        Selenide.open("https://xn--80affam7bifeicf.xn--80ahmohdapg.xn--80asehdb/");
        loginField.shouldBe(Condition.visible).setValue(login);
        passwordField.setValue(password);
        enterButton.shouldBe(Condition.visible).click();
        new ВклЛицевойСчёт(); //ожидаем пока прогурзиться страница с личным кабинетом

    }

    public void openStartPage() {
        log.trace("\n\n_______________________________Открываем стартовую страницу_______________________________\n\n");
        getConfiguration();
        Selenide.open("https://xn--80affam7bifeicf.xn--80ahmohdapg.xn--80asehdb/");
        log.trace("\n\n_______________________________Ожидаем пока прогрузится страница_______________________________\n\n");
        startWindow.waitUntil(Condition.visible, 5000); //Ожидание прогрузки страницы 5 секунд
    }

    public SelenideElement enterBtn = $(By.xpath("//a[text() = 'Войти']"));
    public SelenideElement fieldLogin = $(By.id("login-email")); //bopovan@gmail.com
    public SelenideElement fieldPassword = $(By.id("login-password")); //Dbrnjhbz3005
    public SelenideElement btnEnter = $(By.xpath("//input[@value= 'Войти']"));
    public SelenideElement btn = $(By.xpath("//span[@class='decoder__points']"));


    public void checkStartFormIsDisplay() {
        startWindow.shouldBe(Condition.visible);
    }

    public void pressEnterButton() {
        enterButton.click();
    }

    public static void main(String[] args) throws FileNotFoundException {
        try{
            Configuration conf = new Configuration();
            Selenide.open("https://xn--80awhdgm.xn--80ahmohdapg.xn--80asehdb/");
            int времяОжидания = 5000;

            SelenideElement полеЛогин = $(By.xpath("//*[@placeholder= 'Логин']"));
            SelenideElement полеПароль = $(By.xpath("//*[@placeholder= 'Пароль']"));
            SelenideElement кнопкаВхода = $(By.xpath("//*[@class = \'Entrance__submit\']"));

            SelenideElement текстПриветствия = $(By.xpath("//*[contains(text(),'Здравствуйте, ')]"));
            SelenideElement кнпокаЛКА = $(By.xpath("//*[contains(@href, '/LK/')]"));
            SelenideElement текстСтатистика = $(By.xpath("//*[contains(text(),'Статистика подключенных лицевых счетов')]"));
            SelenideElement кнопкаСоздатьОтчет = $(By.xpath("//span[contains(text(),'Создать отчет')]"));
            SelenideElement текстНовыйОтчет = $(By.xpath("//*[contains(text(),'Новый отчет')]"));
            SelenideElement кнопкаТипОтчета = $(By.xpath("//div[contains(text(),'Список подключенных ЛС за период')]/following-sibling::button"));
            SelenideElement пунктСтатистикаПлатежейЗаПериодПоВсемРГК = $(By.xpath("//div[contains(text(),'Статистика платежей за период по всем РГК')]"));
            SelenideElement кнопкаСформироватьОтчет = $(By.xpath("//*[contains(text(),'Сформировать отчет')]/../../.."));
            SelenideElement текстПодождитеПокаСкачивается = $(By.xpath("//*[contains(text(),'Идет подготовка файла, подождите...')]"));


            полеПароль.waitUntil(Condition.visible, времяОжидания);
            полеЛогин.shouldBe(Condition.visible).setValue("admin");
            полеПароль.shouldBe(Condition.visible).setValue("devv327SeSe");
            кнопкаВхода.click();
            текстПриветствия.waitUntil(Condition.visible, времяОжидания);
            кнпокаЛКА.shouldBe(Condition.visible).click();

            for (int j = 0; j < 200; j++) {
                текстСтатистика.waitUntil(Condition.visible, времяОжидания);
                кнопкаСоздатьОтчет.shouldBe(Condition.visible).click();
                текстНовыйОтчет.waitUntil(Condition.visible, времяОжидания);
                кнопкаТипОтчета.shouldBe(Condition.visible).click();
                пунктСтатистикаПлатежейЗаПериодПоВсемРГК.shouldBe(Condition.visible).click();
                кнопкаСформироватьОтчет.shouldBe(Condition.visible).click();
                текстПодождитеПокаСкачивается.waitUntil(Condition.hidden, 6000000);
                Selenide.sleep(1800000);
            }

        } catch (Exception e) {
            e.printStackTrace();
            main(args);
        }


//        int length = Objects.requireNonNull(new File("../lka-automated-texting/build/downloads/").list()).length;
//        while(length != length + 1){
//            Selenide.sleep(1000);
//            length = Objects.requireNonNull(new File("../lka-automated-texting/build/downloads/").list()).length;
//        }


    }

}
