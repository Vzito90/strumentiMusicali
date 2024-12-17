package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);  // Usa la porta 587 per TLS

        mailSender.setUsername("");
        mailSender.setPassword("");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Abilita STARTTLS per TLS
        props.put("mail.debug", "true");

        // Aggiungi il trust per SSL/TLS (se necessario)
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // Se il problema persiste, usa anche la seguente configurazione per forzare la connessione SSL
        // props.put("mail.smtp.ssl.enable", "true");  // Abilitare SSL diretto (opzionale)
       
        //IMPORTANTISSIMO!!!!!!!!!!!!!!!!!!!
        props.put("mail.smtp.ssl.trust", "*");
        return mailSender;
    }
}
