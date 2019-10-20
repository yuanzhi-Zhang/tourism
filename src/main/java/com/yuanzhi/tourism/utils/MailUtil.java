package com.yuanzhi.tourism.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/11 13:50
 */
public class MailUtil {

    private static String smtp_host = "smtp.qq.com";
    private static String username = "2625221623@qq.com";//邮箱账号
    private static String password = "vurfssraemgvdjhi";//授权码
    private static String from = "2625221623@qq.com";
    public static String activeUrl = "http://localhost:8088/rwx/";

    public static void sendMail(String subject, String content, String to) {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", smtp_host);
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(props);
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.setRecipient(RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(content,"text/html;charset=utf-8");
            Transport transport = session.getTransport();
            transport.connect(smtp_host, username, password);
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("邮件发送失败...");
        }
    }

}
