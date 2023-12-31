package net.codejava;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

@SpringBootTest
@PropertySource("classpath:application.properties") // If you have properties to load
public class SpringEmailTest {
//
//	@Autowired
//	private JavaMailSender mailSender;
//
//	@Test
//	public void testSendEmailWithInlineImage() throws MessagingException {
//		String from = "karnikathilgar001@gmail.com";
//		String to = "anushanil2000@gmail.com";
//
//		MimeMessage message = mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//		helper.setSubject("Here's your pic");
//		helper.setFrom(from);
//		helper.setTo(to);
//
//		helper.setText("<b>Dear guru</b>,<br><i>Please look at this nice picture:.</i><br><img src='cid:image001'/><br><b>Best Regards</b>", true);
//
//		FileSystemResource resource = new FileSystemResource(new File("g:\\MyEbooks\\Freelance for Programmers\\images\\admiration.png"));
//		helper.addInline("image001", resource);
//
//		mailSender.send(message);
//	}
}
