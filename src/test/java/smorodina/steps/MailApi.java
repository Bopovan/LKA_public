package smorodina.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.passay.PasswordGenerator;
import javax.mail.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailApi {
    private final Logger log = LogManager.getLogger(MailApi.class);

    private String RANDOMMAIL = "";
    private String RANDOMPASSWORD = "";


    public String getRANDOMPASSWORD() {return RANDOMPASSWORD;}

    @When("сгенерировать новый пароль от 6 до 20 символов") // старые пароли удаляются
    public void setRANDOMPASSWORD() {
        PasswordGenerator psw = new PasswordGenerator();
        List<String> pswListChars = new LinkedList<>();
        int passwordLength = 6 + (int) (Math.random() * 15);
        String password = new Random().ints(passwordLength, 33, 122)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        this.RANDOMPASSWORD = password;
    }

    public String getRANDOMMAIL() {return RANDOMMAIL = setRANDOMMAIL();}

    @Then("сгенерировать тестовую почту") // старый почтовый ящик затирается
    public String setRANDOMMAIL() {
        String randomMailBody = "lka_gaz_mail"; // тело почтового ящика
        String randomMailEnd = "@bk.ru"; // домен зарегистрированный на mail.ru
        String randomPartOfMail = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_HH_mm"));   // уникальная часть почтового тега, созданная из даты+время - для удобного поиска в ящике
//        sout(randomMailBody + "+" + randomPartOfMail + randomMailEnd);
        return (randomMailBody + "+" + randomPartOfMail + randomMailEnd); // возвращаем склееный рандомный ящик с уникальным телом
    }


    public void getLastMessageMail(String userName, String password) {
        try {
            Properties props = new Properties();
            String host = "imap.mail.ru";
//            String userName = "lka_gaz_mail@bk.ru";
//            String password = "91119111iv!";
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
                }
            }
            inbox.close(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("создать тестового пользователя и заполнить поля Регистрации валидными данными")
    public void preSetRegistration(){
        setRANDOMMAIL();
        setRANDOMPASSWORD();
    }


    public static void main(String[] args) {
        new MailApi().setRANDOMPASSWORD();
    }


}
