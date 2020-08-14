package smorodina.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;

public class МОкноКодПодтверждения {

    private Logger log = LogManager.getLogger(МОкноВыхода.class);

    @NameTag(name = "МОкно с полем для кода подтверждения")
    private SelenideElement windowConfirmationCode = $(By.xpath("//p[contains(.,'В течение нескольких минут Вам придёт письмо с кодом, который необходимо ввести в форму ниже.')]/.."));

    @NameTag(name = "Поле для ввода Кода Подтверждения")
    public SelenideElement fieldConfirmationCode = $(By.xpath("//input[@maxlength]"));

    @NameTag(name = "Кнопка Отправить Код Повторно")
    private SelenideElement btnRepeatSend = $(By.xpath("//button[contains(.,'Отправить код повторно')]"));

    @NameTag(name = "Кнопка Подтвердить")
    private SelenideElement btnSend = $(By.xpath("//button[contains(.,'Подтвердить')]"));

//    @NameTag(name = "Кнопка_Отправить")
//    private SelenideElement  = $(By.xpath("//button[@class='abrr-ui-button primary uppercase fullwidth'][contains(.,'Подтвердить')]"));


}
