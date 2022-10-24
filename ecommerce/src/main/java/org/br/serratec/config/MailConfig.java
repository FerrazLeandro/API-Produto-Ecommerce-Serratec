package org.br.serratec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class MailConfig {
	@Autowired
	JavaMailSender javaMailSender;
	
	@Async
	public void sendMail(String para, String assunto, String texto) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("bulinhauk@gmail.com");
		message.setSubject(assunto);
		message.setText(texto);
		message.setTo(para);
		javaMailSender.send(message);
		
	}

}
