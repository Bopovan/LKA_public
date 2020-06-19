package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;

public class ОкноРегистрации {

    private Logger log = LogManager.getLogger(ОкноАвторизации.class);

    @NameTag(name = "Окно_Регистрации")
    private SelenideElement startWindow = $(By.xpath("//div[@class = 'view-login-form']"));

    @NameTag(name = "Ссылка_Войти_в_личный_кабинет")
    private SelenideElement hrefBackInToYourAccount = $(By.xpath("//a[@href = '/login']"));

    @NameTag(name = "Поле_Логин_Телефон/Эл.почта")
    private SelenideElement fieldLogin = $(By.xpath("//input[@placeholder = 'Логин (Телефон/Эл.почта)']"));

    @NameTag(name = "Поле_Пароль")
    private SelenideElement fieldPassword = $(By.xpath("//input[@placeholder = 'Пароль']"));

    @NameTag(name = "Поле_Повторите_пароль")
    private SelenideElement fieldRepeatPassword = $(By.xpath("//input[@placeholder = 'Повторите пароль']"));

    @NameTag(name = "Кнопка_Зарегистрироваться")
    private SelenideElement btnRegistration = $(By.xpath("//button[@class = 'abrr-ui-button primary uppercase fullwidth']"));

    @NameTag(name = "Ссылка_Задать_вопрос_в_техническую_поддержку")
    private SelenideElement hrefSupport = $(By.xpath("//a[contains(text(),'Задать вопрос в техническую поддержку')]"));


    public void backInAccount () {
        log.trace("\n\n_______________________________Нажимаем на ссылку <Войти в личный кабинет>_______________________________\n\n");
        hrefBackInToYourAccount.shouldBe(Condition.visible).click();
    }

}
