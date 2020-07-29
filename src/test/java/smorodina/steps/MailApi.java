package smorodina.steps;

import io.cucumber.java.en.Then;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class MailApi {


    public void getAllMessage() {
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
            for(Message message : messages){
                System.out.println(message.getSubject());
            }
            inbox.close(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MailApi().getAllMessage();
    }

}
