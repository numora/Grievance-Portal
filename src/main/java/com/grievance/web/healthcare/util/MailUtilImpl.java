package com.grievance.web.healthcare.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtilImpl {

	public void sendProfileActivateMail(String subject, String email,
			int activateId) throws MalformedURLException {
		sendMail(subject, email, activateId);
	}

	public void sendPasswordRecoveryMail(String subject, String email)
			throws MalformedURLException {
		sendMail(subject, email, 0);
	}

	public void sendMail(String subject, String email, int activateId)
			throws MalformedURLException {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		StringBuffer content = new StringBuffer();
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"grievanceportal@gmail.com", "portal@grievance");
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress("grievanceportal@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject(subject);
			if (subject.contains("Forgot Password")) {
				content.append("Please click on below link to recover your password");
				content.append("<br>");
				URL url = new URL("http", "localhost", 8080,
						"/grievance/grievance/passwordRecovery?email=" + email);
				content.append("<br>");
				content.append(url.toString());

			} else if (subject.contains("Profile Created") && activateId != 0) {
				content.append("Please click on below link to activate your profile");
				content.append("<br>");
				URL url = new URL("http", "localhost", 8080,
						"/grievance/grievance/activateProfile?email=" + email
								+ "&activateId=" + activateId);
				content.append("<br>");
				content.append(url.toString());

			}
			message.setContent(content.toString(), "text/html");
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
