package services;

import com.google.inject.Singleton;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.Play;
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

    public void sendBankStatementEmail(String emailFrom, String emailTo, String countryLocale, String name) {

        if (StringUtils.isBlank(emailTo)) {
            return;
        }

        try {

            String subject = "Take a close look";

            String url = "conf/templates/bank_en.html";

            if (countryLocale.equalsIgnoreCase("DK")) {
                url = "conf/templates/bank_dk.html";
                subject = "Bliv klogere";
            }

            String html = new String(Files.readAllBytes(Paths.get(url)));


            if (countryLocale.equalsIgnoreCase("DK")) {

                html = StringUtils.replace(html, "Kære", "Kære " + name);

            } else {
                html = StringUtils.replace(html, "Dear", "Dear " + name);
            }

            try {
                Email email = new Email()
                        .setSubject(subject)
                        .setFrom(emailFrom)
                        .addTo(emailTo)
                        .setBodyHtml(html);
                Logger.info("Sending bank statement email to " + emailTo);

                Play.application().injector().instanceOf(MailerClient.class).send(email);

            } catch (Exception e) {
                Logger.error("Error while sending email", e);
            }

        } catch (IOException e) {
            Logger.error("Mail sending error", e);
        }
    }

    public void sendWelcomeEmail(String emailFrom, String emailTo, String countryLocale, String name, String token) {

        if (StringUtils.isBlank(emailTo)) {
            return;
        }

        try {

            String subject = "WELCOME TO MYSAFEPAY!";

            String url = "conf/templates/welcome_en.html";

            if (countryLocale.equalsIgnoreCase("DK")) {
                url = "conf/templates/welcome_dk.html";
                subject = "VELKOMMEN TIL MYSAFEPAY!";
            }

            String html = new String(Files.readAllBytes(Paths.get(url)));


            if (countryLocale.equalsIgnoreCase("DK")) {

                html = StringUtils.replace(html, "Telefonnummer:", "Telefonnummer: " + name);
                html = StringUtils.replace(html, "Sikkerhedskode:", "Sikkerhedskode: " + token);

            } else {
                html = StringUtils.replace(html, "Phone number:", "Phone number: " + name);
                html = StringUtils.replace(html, "Token number:", "Token number: " + token);
            }

            try {
                Email email = new Email()
                        .setSubject(subject)
                        .setFrom(emailFrom)
                        .addTo(emailTo)
                        .setBodyHtml(html);
                Logger.info("Sending welcome email to " + emailTo);

                Play.application().injector().instanceOf(MailerClient.class).send(email);

            } catch (Exception e) {
                Logger.error("Error while sending email", e);
            }

        } catch (IOException e) {
            Logger.error("Mail sending error", e);
        }
    }

}
