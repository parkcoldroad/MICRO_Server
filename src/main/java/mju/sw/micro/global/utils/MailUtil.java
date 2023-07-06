package mju.sw.micro.global.utils;

import jakarta.mail.Message.RecipientType;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MailUtil {

	@Value("${spring.mail.username}")
	private String senderEmail;
	private final JavaMailSender emailSender;


	public void sendMessage(String recipientEmail, String title, String content, String extra) {
		MimeMessage message = createMessage(recipientEmail, title, content, extra);
		emailSender.send(message);
	}

	private MimeMessage createMessage(String recipientEmail, String title, String content,
		String extra) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			String contents = String.format(content, extra);
			message.addRecipients(RecipientType.TO, recipientEmail); //받는 사람
			message.setSubject(title); //제목
			message.setText(contents, "UTF-8", "html"); //내용
			message.setFrom(new InternetAddress(senderEmail));// 보내는 사람
			return message;
		} catch (MessagingException e) {
			log.info("fail");
			throw new RuntimeException(e);
		}
	}

}