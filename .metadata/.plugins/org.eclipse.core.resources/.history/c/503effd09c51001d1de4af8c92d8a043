package br.org.serratec.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	@Autowired
	JavaMailSender javaMailSender;
	
	public void sendMail(String para, String assunto, String texto) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("bulinhauk@gmail.com");
		message.setSubject(assunto);
		message.setText(texto);
		message.setTo(para);
		javaMailSender.send(message);
		
	}

}
