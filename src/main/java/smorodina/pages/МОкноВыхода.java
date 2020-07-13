package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import static com.codeborne.selenide.Selenide.$;

public class МОкноВыхода {

    private Logger log = LogManager.getLogger(МОкноВыхода.class);

    private БоковаяПанель sideBar = new БоковаяПанель();

    @NameTag(name = "Модальное_окно_выхода")
    private SelenideElement quitWindow = $(By.xpath("//div[@class = '']"));

    @NameTag(name = "кнопка_Выход")
    private SelenideElement quitButtonOnWindowQuit = $(By.xpath("//*[text()='Выйти']/.."));

    @NameTag(name = "кнопка_Отмена")
    private SelenideElement cancelButtonOnWindowQuit = $(By.xpath("//button[@class = 'abrr-ui-button primary ghost uppercase'][contains(.,'Отмена')]"));


    public void elementaryExit() {
        sideBar.quitButton.shouldBe(Condition.visible).click();
        quitWindow.shouldBe(Condition.visible);
        quitButtonOnWindowQuit.shouldBe(Condition.visible).click();
    }


    public void pressQuitButtonPopUp() {
        quitButtonOnWindowQuit.shouldBe(Condition.visible).click();
    }

    public SelenideElement quitPopUpWindowIsDisplay() {
        return quitWindow.shouldBe(Condition.visible);
    }

    //.............................................................................
}


