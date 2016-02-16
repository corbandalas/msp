package sms;

/**
 * SMS Gateway interface
 *
 * @author corbandalas - created 15.02.2016
 * @since 0.2.0
 */
public interface SmsGateway {
    void sendSms(String phone, String text);
}
