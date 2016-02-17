package sms;

import play.Logger;

/**
 * SMS Gateway implementation
 *
 * @author corbandalas - created 15.02.2016
 * @since 0.2.0
 */
public class SmsGateway {

    public void sendSms(String phone, String text) {
        Logger.info("SMS message was sent to phone: " + phone);
    }
}
