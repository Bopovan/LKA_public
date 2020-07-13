package smorodina.pages;

import com.codeborne.selenide.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;
import smorodina.Utils.NameTag;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

public class ОкноАвторизации {

    Configuration configuration;


    private Configuration getConfiguration() {
        Configuration.browser = "firefox"; //ie //chrome //edje //opera
        Configuration.startMaximized = true;
//        Configuration.reopenBrowserOnFail = true;
//        Configuration.holdBrowserOpen = false;
        new WebDriver.Options() {
            @Override
            public void addCookie(Cookie cookie) {

            }

            @Override
            public void deleteCookieNamed(String name) {

            }

            @Override
            public void deleteCookie(Cookie cookie) {

            }

            @Override
            public void deleteAllCookies() {

            }

            @Override
            public Set<Cookie> getCookies() {
                return null;
            }

            @Override
            public Cookie getCookieNamed(String name) {
                return null;
            }

            @Override
            public WebDriver.Timeouts timeouts() {
                return timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }

            @Override
            public WebDriver.ImeHandler ime() {
                return null;
            }

            @Override
            public WebDriver.Window window() {
                return null;
            }

            @Override
            public Logs logs() {
                return null;
            }
        };
        return configuration;
    }

    private final Logger log = LogManager.getLogger(ОкноАвторизации.class);

    @NameTag(name = "Окно_авторизации")
    private final SelenideElement startWindow = $(By.id("View3D"));


    @NameTag(name = "Поле_логин")
    private final SelenideElement loginField = $(By.xpath("//input[@placeholder = 'Логин']"));

    @NameTag(name = "Поле_пароль")
    private final SelenideElement passwordField = $(By.xpath("//input[@placeholder = 'Пароль']"));

    @NameTag(name = "Кнопка_входа_в_личный_кабинет")
    private final SelenideElement enterButton = $(By.xpath("//button[@class = 'abrr-ui-button primary uppercase fullwidth']"));

    @NameTag(name = "Ссылка_<Регистрация>")
    private final SelenideElement registrationLink = $(By.xpath("//a[@href = '/login/signup']"));

    @NameTag(name = "Ссылка_<Забыли_пароль?>")
    private final SelenideElement forgotPasswordLink = $(By.xpath("//a[@href = '/login/recovery']"));

    @NameTag(name = "Ссылка_<Техническая_поддержка>")
    private final SelenideElement supportLink = $(By.xpath("//a[contains(text(), 'Задать вопрос в техническую поддержку')]"));

    @NameTag(name = "Текстовые_ошибки")
    private final SelenideElement error = $(By.xpath("//div[@class = 'view-login-error'][contains(text(),'$s')]"));
    private final String errorSQL = "Произошла ошибка обработки запроса, попробуйте еще раз.";


    public void enterWithTestUserAcc(String login, String password) {
        log.debug("\n\n__________________Авторизуемся под учётной записью {} и паролем {}_____________________\n\n", login, password);
        getConfiguration();
        Selenide.open("https://xn-----6kcfhlebnd4golc4h.xn--80ahmohdapg.xn--80asehdb/login");
        loginField.shouldBe(Condition.visible).setValue(login);
        passwordField.setValue(password);
        enterButton.shouldBe(Condition.visible).click();
        new ВклЛицевойСчёт(); //ожидаем пока прогурзиться страница с личным кабинетом

    }

    public void openStartPage() {
        log.trace("\n\n_______________________________Открываем стартовую страницу_______________________________\n\n");
        getConfiguration();
        Selenide.open("https://xn-----6kcfhlebnd4golc4h.xn--80ahmohdapg.xn--80asehdb/login");
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
