package smorodina.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import smorodina.Utils.NameTag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

public class ОкноТехПоддержки {


    @NameTag(name = "Поле ФИО")
    private final SelenideElement
            fieldFIO = $(By.xpath("//*[text()='ФИО']/following-sibling::div/input"));

    @NameTag(name = "Номер Обращения в тех. поддержку")
    private final SelenideElement
            fieldSupportNum = $(By.xpath("//div[@class='abrr-ui-modal-final-description']"));

    public String getSupportNumberFromForm() {
        String num = fieldSupportNum.shouldBe(Condition.visible).getText();
        Pattern pattern = Pattern.compile("\\d*$"); // создаём паттерн для поиска при помощи Регекса
        Matcher matcher = pattern.matcher(num); //находим по паттерну в Стринге значение
        if (matcher.find()) { //если в стринге находиться что-то, то возвращаем это "что-то"
            String s1 = matcher.group();
                    System.out.println(s1);
            return s1;
        }
        return null; //или возвращаем null
    }


    @NameTag(name = "Поле E-mail")
    private final SelenideElement
            fieldMail = $(By.xpath("//*[text()='E-mail']/following-sibling::div/input"));

    @NameTag(name = "Поле Cообщение")
    private final SelenideElement
            fieldMessage = $(By.xpath("//*[text()='Cообщение']/following-sibling::div/*"));

    @NameTag(name = "Поле Телефон")
    private final SelenideElement
            fieldTel = $(By.xpath("//*[text()='Телефон']/following-sibling::div/input"));

    @NameTag(name = "Поле Лицевой счет")
    private final SelenideElement
            fieldAcc = $(By.xpath("//*[text()='Лицевой счет']/following-sibling::div/input"));

    @NameTag(name = "Поле для загрузки файлов")
    private final SelenideElement
            fieldAddFile = $(By.xpath("//input[@type='file']"));

    public void addFileForSupport(String fileName) {
        String fileStore = "C:\\Users\\scherbakova\\IdeaProjects\\lka-automated-testing\\src\\main\\resources\\test_Files\\%s";
        fieldAddFile.sendKeys(String.format(fileStore, fileName));
//        fieldAddFile.sendKeys("C:\\Users\\scherbakova\\IdeaProjects\\lka-automated-testing\\src\\main\\resources\\test_Files\\fileForSM_0009_1.png");
//        fieldAddFile.sendKeys("C:\\Users\\scherbakova\\IdeaProjects\\lka-automated-testing\\src\\main\\resources\\test_Files\\fileForSM_0009_2.pdf");
//        fieldAddFile.sendKeys("C:\\Users\\scherbakova\\IdeaProjects\\lka-automated-testing\\src\\main\\resources\\test_Files\\fileForSM_0009_3.jpeg");
    }

    /*
    Вкладка тех-поддержка на боковом меню
     */

    @NameTag(name = "Ссылка Другой вопрос?")
    private final SelenideElement
            textAnotherQuestion = $(By.xpath("//*[text()='Другой вопрос?']"));

    @NameTag(name = "Ссылка Служба поддержки личного кабинета")
    private final SelenideElement
            textSupportLK = $(By.xpath("//*[text()='Служба поддержки личного кабинета']"));

    @NameTag(name = "Ссылка Региональная газовая компания")
    private final SelenideElement
            textSupportRegion = $(By.xpath("//*[text()='Региональная газовая компания']"));

}
