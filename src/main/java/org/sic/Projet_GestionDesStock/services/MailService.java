package org.sic.Projet_GestionDesStock.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Service
public class MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String from,String file, String subject,String personel, String toAddresses,  String body) throws MessagingException, UnsupportedEncodingException {

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(toAddresses);
//        message.setSubject(subject);
//        message.setText(body);

//************Decode Pdf From String64 to Byte
        byte[] decoder = Base64.getDecoder().decode(file);
//        Files.createDirectories(Paths.get("src/main/resources/static/images/products/"+product.getProduct_id()+"/"));
//        BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/test.pdf")));
//        stream.write(decoder);
//        stream.close();


        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
        mimeMessageHelper.setFrom(from,personel);
        mimeMessageHelper.setTo(toAddresses);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body,true);
        mimeMessageHelper.addAttachment("file.pdf",new ByteArrayResource(decoder));



        mailSender.send(message);


        mailSender.send(message);



    }
}
