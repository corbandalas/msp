package services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import play.Logger;
import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Mail Service
 *
 * @author corbandalas created 05.09.2018.
 * @since 0.5.0
 */

@Singleton
public class MailService {

//    @Inject
//    MailerClient mailerClient;

    public void sendBankStatementEmail(String emailFrom, String emailTo, String countryLocale, String name) {
        try {

            String url = "conf/templates/bank_en.html";

            if (countryLocale.equalsIgnoreCase("DK")) {
                url = "conf/templates/bank_dk.html";
            }

            String html = new String(Files.readAllBytes(Paths.get(url)));
            send(emailFrom, emailTo, html, "Bank statement");

        } catch (IOException e) {
            Logger.error("Mail sending error", e);
        }
    }

    public void sendWelcomeEmail(String emailFrom, String emailTo, String countryLocale, String name, String token) {
        try {

            String url = "conf/templates/welcome_en.html";

            if (countryLocale.equalsIgnoreCase("DK")) {
                url = "conf/templates/welcome_dk.html";
            }

            String html = new String(Files.readAllBytes(Paths.get(url)));
            send(emailFrom, emailTo, html, "Welcome");

        } catch (IOException e) {
            Logger.error("Mail sending error", e);
        }
    }

    private void send(String emailFrom, String emailTo, String textHtml, String subject) {
        try {
            Email email = new Email()
                    .setSubject(subject)
                    .setFrom(emailFrom)
                    .addTo(emailTo)
//                .addAttachment("attachment.pdf", new File("/some/path/attachment.pdf"))
//                .addAttachment("data.txt", "data".getBytes(), "text/plain", "Simple data", EmailAttachment.INLINE)
//                .addAttachment("image.jpg", new File("/some/path/image.jpg"), cid)
//                .setBodyText(text)
//                .setBodyHtml("<html><body><p>An <b>html</b> message with cid <img src=\"cid:" + cid + "\"></p></body></html>")
                    .setBodyHtml(textHtml)
                    ;
//            mailerClient.send(email);
        } catch (Exception e) {
            Logger.error("Error while sending email", e);
        }

    }
}
