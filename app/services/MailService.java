package services;

import com.google.inject.Inject;
import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;

/**
 * Mail Service
 *
 * @author ra created 05.09.2018.
 * @since 0.5.0
 */
public class MailService {

    @Inject
    MailerClient mailerClient;

    public void sendEMail(String emailFrom, String emailTo, String text) {
        Email email = new Email()
                .setSubject("Test email")
                .setFrom(emailFrom)
                .addTo(emailTo)
//                .addAttachment("attachment.pdf", new File("/some/path/attachment.pdf"))
//                .addAttachment("data.txt", "data".getBytes(), "text/plain", "Simple data", EmailAttachment.INLINE)
//                .addAttachment("image.jpg", new File("/some/path/image.jpg"), cid)
                .setBodyText(text)
//                .setBodyHtml("<html><body><p>An <b>html</b> message with cid <img src=\"cid:" + cid + "\"></p></body></html>")
            ;
        mailerClient.send(email);
    }
}
