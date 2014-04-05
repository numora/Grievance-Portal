package com.grievance.web.healthcare.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtilImpl {
	public void sendMail(String subject) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"grievanceportal@gmail.com", "portal@grievance");
					}
				});

		try {

			// Message message = new MimeMessage(session);
			// message.setContent("Dear Mail Crawler,"
			// +"\n\n No spam to my email, please!");
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress("sujanvanka@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("svankadari@nisum.com"));
			message.setSubject(subject);
			// Send the actual HTML message, as big as you like
			message.setContent("<h1>User is Created the message</h1>",
					"text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
