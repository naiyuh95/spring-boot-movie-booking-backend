package com.booking.ny.service;


import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class EmailSendService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
	private String sendTo;

    public void sendEmail(String[] seats, double amount, String movieName, String movielink,String customerName,String email) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        

        Context context = new Context();
        context.setVariable("name",customerName);
        context.setVariable("movieLink",movielink);
        context.setVariable("movieName",movieName);
        context.setVariable("seats",String.join(",", seats));
        context.setVariable("price",amount);

    
        String html = templateEngine.process("template", context);
        helper.setTo(sendTo);
        helper.setText(html, true);
        helper.setSubject("Booking Confirmation");
        helper.setFrom(email);

        emailSender.send(message);
    }

}

