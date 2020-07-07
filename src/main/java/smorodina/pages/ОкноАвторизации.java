package smorodina.pages;

import com.codeborne.selenide.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;

public class ОкноАвторизации {

    Configuration configuration;

    private Configuration getConfiguration() {
        Configuration.baseUrl = "https://xn-----6kcfhlebnd4golc4h.xn--80ahmohdapg.xn--80asehdb";
        Configuration.browser = "firefox"; //ie //chrome //edje //opera //firefox
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
        return configuration;
    }

    private Logger log = LogManager.getLogger(ОкноАвторизации.class);

    @NameTag(name = "Окно_авторизации")
    private SelenideElement startWindow = $(By.id("View3D"));

    @NameTag(name = "Поле_логин")
    private SelenideElement loginField = $(By.xpath("//input[@placeholder = 'Логин']"));

    @NameTag(name = "Поле_пароль")
    private SelenideElement passwordField = $(By.xpath("//input[@placeholder = 'Пароль']"));

    @NameTag(name = "Кнопка_входа_в_личный_кабинет")
    private SelenideElement enterButton = $(By.xpath("//button[@class = 'abrr-ui-button primary uppercase fullwidth']"));

    @NameTag(name = "Ссылка_<Регистрация>")
    private SelenideElement registrationLink = $(By.xpath("//a[@href = '/login/signup']"));

    @NameTag(name = "Ссылка_<Забыли_пароль?>")
    private SelenideElement forgotPasswordLink = $(By.xpath("//a[@href = '/login/recovery']"));

    @NameTag(name = "Ссылка_<Техническая_поддержка>")
    private SelenideElement supportLink = $(By.xpath("//a[contains(text(), 'Задать вопрос в техническую поддержку')]"));

    @NameTag(name = "Текстовые_ошибки")
    private SelenideElement error = $(By.xpath("//div[@class = 'view-login-error'][contains(text(),'$s')]"));
    private String errorSQL = "Произошла ошибка обработки запроса, попробуйте еще раз.";



    public void enterWithTestUserAcc(String login, String password) {
        log.debug("\n\n__________________Авторизуемся под учётной записью {} и паролем {}_____________________\n\n",login,password);
        getConfiguration();
        Selenide.open("/login");
        loginField.shouldBe(Condition.visible).setValue(login);
        passwordField.setValue(password);
        enterButton.shouldBe(Condition.visible).click();
    }

    public void openStartPage() {
        log.trace("\n\n_______________________________Открываем стартовую страницу_______________________________\n\n");
        getConfiguration();
        Selenide.open("/login");
        log.trace("\n\n_______________________________Ожидаем пока прогрузится страница_______________________________\n\n");
        startWindow.waitUntil(Condition.visible, 5000); //Ожидание прогрузки страницы 5 секунд
    }

    public void checkStartFormIsDisplay() {
        startWindow.shouldBe(Condition.visible);
    }

    public void pressEnterButton() {
        enterButton.click();
    }

}
