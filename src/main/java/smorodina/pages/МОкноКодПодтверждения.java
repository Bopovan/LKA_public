package smorodina.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;

public class МОкноКодПодтверждения {

    private Logger log = LogManager.getLogger(МОкноВыхода.class);

    @NameTag(name = "МОкно_с_полем_для_кода_подтверждения")
    private SelenideElement windowConfirmationCode = $(By.xpath("//p[contains(.,'В течение нескольких минут Вам придёт письмо с кодом, который необходимо ввести в форму ниже.')]/.."));

    @NameTag(name = "Поле_для_ввода_Кода_Подтверждения")
    private SelenideElement fieldConfirmationCode = $(By.xpath("//*[@class='abrr-ui-button primary uppercase fullwidth']/preceding-sibling::*[1]"));

    @NameTag(name = "Кнопка_Отправить_Код_Повторно")
    private SelenideElement btnRepeatSend = $(By.xpath("//button[@class='abrr-ui-button primary uppercase fullwidth'][contains(.,'Отправить код повторно')]"));

    @NameTag(name = "Кнопка_Отправить")
    private SelenideElement btnSend = $(By.xpath("//button[@class='abrr-ui-button primary uppercase fullwidth'][contains(.,'Подтвердить')]"));

//    @NameTag(name = "Кнопка_Отправить")
//    private SelenideElement  = $(By.xpath("//button[@class='abrr-ui-button primary uppercase fullwidth'][contains(.,'Подтвердить')]"));


}
