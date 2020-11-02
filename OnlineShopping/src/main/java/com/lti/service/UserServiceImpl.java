package com.lti.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.model.Order;
import com.lti.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public int updateUser(User user) {

		return userDao.updateUser(user);
	}

	public User findUser(int userId) {

		return userDao.findUser(userId);
	}

	public int addUserWithCart(User user, String fromEmail, String fromPassword) throws IOException {
		int userId = userDao.addUserWithCart(user);
		if (userId > 0) {
			sendEmailToUser(user, fromEmail, fromPassword);
		}
		return userId;
	}

	public boolean loginUser(String userEmail, String password) {
		/*
		 * if(userDao.loginUser(userEmail, password)) { //open logged in homepage }
		 */
		return userDao.loginUser(userEmail, password);
	}

	public long placeOrder(Order order) {

		return userDao.placeOrder(order);
	}

	public void sendEmailToUser(User user, String fromEmail, String fromPassword) throws IOException {
		String content = buildEmailContent(user);
		final String from = fromEmail;
		final String password = fromPassword;
		System.out.println(content);

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// Get Session
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// Compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getUserEmail()));
			message.setSubject("Just a test!");
			message.setText(content);
			// Send email
			Transport.send(message);
			System.out.println("Email sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public String buildEmailContent(User user) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("D:/LTI_ProjectNotes/myFile.txt"));
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Hi " + user.getUserName() + ",\n\n");
		String line = null;
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		// delete the last new line separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		reader.close();
		return stringBuilder.toString();
	}
}
