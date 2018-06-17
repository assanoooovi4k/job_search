package by.prostrmk.model.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;


public class MailUtil {

    private String username;
    private String password;
    private Properties properties;

    public MailUtil(String username, String password){
        this.username = username;
        this.password = password;
        properties = new Properties();
        try {
            properties.load(MailUtil.class.getClassLoader().getResourceAsStream("mail.properties"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void send(String subject, String text, String toEmail) throws MessagingException {
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("brinkpool"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject(subject);
        message.setText(text);

        Transport transport = session.getTransport();
        transport.connect(username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public String token() {
        char[]  alphabet = "zxcvbnmasdfghjklqwertyuiop1234567890ZXCVBNMASDFGHJKLQWERTYUIOP".toCharArray();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            stringBuilder.append(alphabet[random.nextInt(alphabet.length - 1)]);
        }
        return stringBuilder.toString();
    }


}
