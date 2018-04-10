package com.example.mail;

import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Test
    public void simpleMail() {
        //简单邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("配置里的邮箱名");
        message.setTo("要发送的邮箱");
        message.setSubject("简单邮件");
        message.setText("简单邮件内容");

        mailSender.send(message);
    }

    @Test
    public void attachmentsMail() throws Exception {
        //带附件邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("配置里的邮箱名");
        helper.setTo("要发送的邮箱");
        helper.setSubject("带附件邮件");
        helper.setText("带附件邮件内容");

        FileSystemResource file = new FileSystemResource(new File("F:\\1.jpg"));
        helper.addAttachment("附件-1.jpg", file);

        mailSender.send(mimeMessage);
    }


    @Test
    public void inlineMail() throws Exception {
        //嵌入静态资源邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("配置里的邮箱名");
        helper.setTo("要发送的邮箱");
        helper.setSubject("嵌入静态资源邮件");
        helper.setText("<html><body><img src=\"cid:fj\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("F:\\1.jpg"));
        helper.addInline("fj", file);

        mailSender.send(mimeMessage);
    }


    @Test
    public void templateMail() throws Exception {
        //模版邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("配置里的邮箱名");
        helper.setTo("要发送的邮箱");
        helper.setSubject("刘德华你好");

        Map<String, Object> model = new HashMap();
        model.put("username", "刘德华");
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        helper.setText(text, true);
        mailSender.send(mimeMessage);
    }
}
