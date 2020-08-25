package smorodina.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.passay.PasswordGenerator;
import smorodina.ConnectionSQL;
import smorodina.pages.*;

import javax.mail.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ШагиРегистрации {
    private final Logger log = LogManager.getLogger(ШагиРегистрации.class);

    ConnectionSQL sql = new ConnectionSQL();
    ОкноРегистрации page = new ОкноРегистрации();
    МОкноКодПодтверждения page2 = new МОкноКодПодтверждения();
    ОкноАвторизации page3 = new ОкноАвторизации();
    ВклНастройки page4 = new ВклНастройки();
    ОкноТехПоддержки page5 = new ОкноТехПоддержки();

    private String RANDOMMAIL = "";
    private String RANDOMPASSWORD = "";
    private String SUPPORTNUMBER = "";

    public String getSUPPORTNUMBER() {
        return SUPPORTNUMBER;
    }


    public void setSUPPORTNUMBER() {
        this.SUPPORTNUMBER = page5.getSupportNumberFromForm();
    }

    public String getRANDOMPASSWORD() {
        return RANDOMPASSWORD;
    }


    public void setRANDOMPASSWORD() {
        PasswordGenerator psw = new PasswordGenerator();
        List<String> pswListChars = new LinkedList<>();
        int passwordLength = 6 + (int) (Math.random() * 15);
        String password = new Random().ints(passwordLength, 33, 122)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        this.RANDOMPASSWORD = password;
    }

    public String getRANDOMMAIL() {
        return RANDOMMAIL;
    }


    public void setRANDOMMAIL() {
        String randomMailBody = "lka_gaz_mail"; // тело почтового ящика
        String randomMailEnd = "@bk.ru"; // домен зарегистрированный на mail.ru
        String randomPartOfMail = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_HH_mm_ss"));   // уникальная часть почтового тега, созданная из даты+время - для удобного поиска в ящике
//        sout(randomMailBody + "+" + randomPartOfMail + randomMailEnd);
        this.RANDOMMAIL = randomMailBody + "+" + randomPartOfMail + randomMailEnd; // возвращаем склееный рандомный ящик с уникальным телом
    }

    public String getLastMessageMail() {
        String value = "";
        try {
            Properties props = new Properties();
            String host = "imap.mail.ru";
            String userName = "lka_gaz_mail@bk.ru";
            String password = "91119111iv!";
            String provider = "imaps";

            Session session = Session.getInstance(props);
            Store store = session.getStore(provider);
            store.connect(host, userName, password);

            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            Message message = messages[0];
            message = inbox.getMessage(inbox.getMessageCount());
            Multipart mp = (Multipart) message.getContent();
            String subject = message.getSubject();
            for (int i = 1; i < mp.getCount(); i++) {
                BodyPart bp = mp.getBodyPart(i);
//              System.out.println("\n" + "Тема письма: " + subject + "\n" + "Содержание письма: " + bp.getContent() + "\n");
                String messageBody = (String) bp.getContent();
                Matcher matcher = Pattern.compile("\\d{4}").matcher(messageBody);
                if (matcher.find()) {
                    String s1 = matcher.group();
                    System.out.println(s1);
                    value = s1;
                }
            }
            inbox.close(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public void preSetRegistration() {
        setRANDOMMAIL();
        Assert.assertNotNull(getRANDOMMAIL());
        log.trace("Генерируем случайный почтовый ящик: {}", this::getRANDOMMAIL);
        page.fieldLogin.shouldBe(Condition.visible).setValue(getRANDOMMAIL());
        setRANDOMPASSWORD();
        Assert.assertNotNull(getRANDOMMAIL());
        log.trace("Генерируем случайный пароль: {}", this::getRANDOMPASSWORD);
        page.fieldPassword.shouldBe(Condition.visible).setValue(getRANDOMPASSWORD());
        page.fieldRepeatPassword.shouldBe(Condition.visible).setValue(getRANDOMPASSWORD());
    }

    public void setAccCode() throws SQLException, ClassNotFoundException {
        String sqlV = "SELECT NM_CODE_ACTIVATION FROM LKK_CODE_ACTIVATION lca WHERE NM_ABONENT_LOGIN = ";
        String sqlValue = sql.getCodeActivation(sqlV, getRANDOMMAIL());
        String emailValue = getLastMessageMail();
        int count = 0;
        while (!sqlValue.equals(emailValue) && count < 10) {
            log.trace("Ожидаем 5 секунд и проверяем равны ли показания {} и {} где count = {}", sqlValue, emailValue, count);
            Selenide.sleep(5000);
            count++;
        }
        page2.fieldConfirmationCode.shouldBe(Condition.visible).setValue(emailValue);
    }

    public void checkSupportIsTrue() throws SQLException, ClassNotFoundException {
        String sqlV = "SELECT USER_EMAIL FROM LKK_FEEDBACK_LOG WHERE ID_FEEDBACK = ";
        setSUPPORTNUMBER();
        String sqlValue = sql.getCodeActivation(sqlV, getSUPPORTNUMBER());
        String emailValue = getRANDOMMAIL();
        int count = 0;
        log.trace("проверяем равны ли показания {} и {}", sqlValue, emailValue);
        while (!sqlValue.equals(emailValue) && count < 5) {
            log.trace("Ожидаем 5 секунд и проверяем равны ли показания {} и {} где count = {}", sqlValue, emailValue, count);
            Selenide.sleep(5000);
            count++;
        }
    }

    public void getLastCode() {
        page2.fieldConfirmationCode.shouldBe(Condition.visible).setValue(getLastMessageMail());
    }

    @When("на странице смены логина заполнить поля сгенерированным новым почтовым ящиком и старым паролем")
    public void resetEmail() {
        page4.setNewEmail(getRANDOMMAIL(), getRANDOMPASSWORD());
    }

    @When("на странице смены пароля заполнить поля новым паролем и ввести для подтверждения старый")
    public void resetPassword() {
        log.trace("\n\n_______________________\n\n Вводим текущий старый пароль: {}", this::getRANDOMPASSWORD);
        page4.typeOldPassword(getRANDOMPASSWORD());
        setRANDOMPASSWORD();
        log.trace("\n\n_______________________\n\n Вводим текущий НОВЫЙ пароль: {}", this::getRANDOMPASSWORD);
        page4.typeNewPassword(getRANDOMPASSWORD());
    }

    @When("повторно авторизоваться под сгенерированным пользователем")
    public void reAut() {
        page3.loginField.shouldBe(Condition.visible).setValue(getRANDOMMAIL());
        page3.passwordField.shouldBe(Condition.visible).setValue(getRANDOMPASSWORD());
    }

    @When("сгенерировать новый пароль от 6 до 20 символов") // старые пароли удаляются
    public void genPass() {
        setRANDOMPASSWORD();
    }

    @When("в поле Код подтверждения ввести код из письма")
    public void typeCode() throws SQLException, ClassNotFoundException {
        setAccCode();
    }

    @When("в поле Код ввести последнее значение из письма")
    public void typeLASTCode() {
        getLastCode();
    }

    @When("проверить, что ошибка с текстом {string} отображается")
    public void checkErrorIsDisplayed(String textError) {
        page.isDisplayedErrorWithText(textError).shouldBe(Condition.visible);
    }

    @When("создать тестового пользователя и заполнить поля Регистрации валидными данными")
    public void genNewUser() {
        preSetRegistration();
    }


    @Then("сгенерировать тестовую почту")// старый почтовый ящик затирается
    public void genEmail() {
        setRANDOMMAIL();
    }

    @When("проверить, что в БД в таблице LKK_FEEDBACK_LOG создана запись об обращении")
    public void checkSupportSubmit() throws SQLException, ClassNotFoundException {
        checkSupportIsTrue();
    }
}
