package com.example.demo.util;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.util.*;

import com.example.demo.service.impl.TestServiceImpl;
import freemarker.template.*;
import java.io.*;


public class ConfigureTemplate {
    public static boolean template (Message message, Class classForTemplateLoading, String templateName, Map paramMap){
        try{
            Configuration cfg = new Configuration();
            //Assume that the template is available under /src/main/resources/templates
            cfg.setClassForTemplateLoading(TestServiceImpl.class, "/templates/");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template template = cfg.getTemplate(templateName);

            //Pass custom param values
//          Map paramMap = new HashMap();
//          paramMap.put("name", "Bala");
//          paramMap.put("date", String.valueOf(Calendar.getInstance().getTime()));
            Writer out = new StringWriter();

            template.process(paramMap, out);
            BodyPart body = new MimeBodyPart();
            body.setContent(out.toString(), "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(body);
            message.setContent(multipart);
            Transport.send(message);
        }catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

