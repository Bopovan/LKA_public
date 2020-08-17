package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

public class ОкноПередачиПоказаний {


    @NameTag(name = "Текст (Передача показаний приборов учета)")
    private SelenideElement textSendVal = $(By.xpath("//div[text() = 'Передача показаний приборов учета']/following-sibling::div[text() = 'Выберите приборы для обновления данных и введите текущие показания']"));

    @NameTag(name = "Поле [Показания]")
    public SelenideElement fieldVals = $(By.xpath("//*[text() = 'Показания']/following-sibling::div/input"));

    @NameTag(name = "Кнопка {Отправить показания}")
    private SelenideElement btnSend = $(By.xpath("//div[text() = 'Отправить показания']/.."));

    @NameTag(name = "Текст (Показания отправлены и добавлены в очередь на обработку.)")
    private SelenideElement textSucess = $(By.xpath("//div[text() = 'Показания отправлены и добавлены в очередь на обработку.']"));

    public String getTextVal() {
        String value = fieldVals.shouldBe(Condition.visible).getValue();
        Pattern pattern = Pattern.compile("\\d*");
        assert value != null;
        Matcher matcher = pattern.matcher(value);
        System.out.println(matcher.find() ?
                "I found '" + matcher.group(): "I found nothing!");
        return matcher.group();
    }

}
