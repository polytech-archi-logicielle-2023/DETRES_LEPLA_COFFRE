
package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import java.util.*;

@Service
public class MessageService {

    private final MessageRepository repository;
    public List<Message> list = new ArrayList<>();
    public Integer id = 1;

    public MessageService(MessageRepository repository) 
    {
        this.repository = repository;
        this.initMessage();
    }

    public List<Message> getAllMessage() {
        return this.repository.findAll();
        
    }

    public void initMessage() {

        Message message1 = new Message();

        message1.setDescription("MON PREMIER MESSAGE !!! OUAAAAAIIIII");
        message1.setIDauteur(1);

        Message message2 = new Message();
        message2.setDescription("MON Deuxieme MESSAGE !!! OUAAAAAIIIII");
        message2.setIDauteur(2);

        this.repository.save(message1);
        this.repository.save(message2);
    }
    
    public Message createMessage(Message message_envoye){
        if (message_envoye.getDescription() != null && message_envoye.getIDauteur() != null){
            return this.repository.save(message_envoye);
        }
        return null;

    }

    public Message getMessageById(Integer id) {

        Optional<Message> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }


}
