package com.lti.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.UserController;
import com.lti.model.User;

public class MailTest {

	ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
	UserController controller=context.getBean(UserController.class);
	
	@Test
	public void test() throws IOException {
		
		/* Make a file "myFile.txt" and set its path in userService.buildEmailContent.
		 * This file will be used for fetching email body content.
		 * Give sender email address and sender email password when adding user with
		 * controller.addUserWithCart(_,_,_) method. Give valid mail address for each
		 * user added.*/
		
		User user=new User();
		user.setUserName("Arkadipta");
		user.setUserPassword("arka@1234");
		user.setUserMobile("0123456789");
		user.setUserEmail("<validUserEmail@gmail.com>");
		
		controller.addUserWithCart(user,"<fromEmail@gmail.com>","<emailPassword>");
	}

}
