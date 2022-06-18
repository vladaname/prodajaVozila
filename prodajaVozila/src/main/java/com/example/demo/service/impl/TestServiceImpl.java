package com.example.demo.service.impl;

import com.example.demo.controllers.Test;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;
import javax.mail.Message;
import com.example.demo.util.*;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String SlanjeMejla() {
        try {

            Message message = ConfigureMessage.message("vladaname@gmail.com","", "", "Change password");


            Map paramMap = new HashMap();
            //paramMap.put("baseUrl", Constants.baseUrl+"changePassword/?userHash="+u.getUserHash());
            paramMap.put("test", "testiranje");
            paramMap.put("date", String.valueOf(Calendar.getInstance().getTime()));


            boolean b = ConfigureTemplate.template(message, Test.class, "mail.ftl", paramMap);

            if(b){
                System.out.print("Success");
                return "uspesno";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "greska";
        }
        return null;
    }
}
