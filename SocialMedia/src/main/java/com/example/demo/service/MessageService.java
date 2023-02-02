
package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.*;

@Service
public class MessageService {


    public void initMessage() {

        Message message1 = new Message();
        message1.setDescription("MON PREMIER MESSAGE !!! OUAAAAAIIIII");
        message1.setAuteur("AD");

        Message message2 = new Message();
        message2.setDescription("MON Deuxieme MESSAGE !!! OUAAAAAIIIII");
        message2.setAuteur("GUIGUI");

        this.repository.save(message1);
        this.repository.save(message2);
    }
    
}
