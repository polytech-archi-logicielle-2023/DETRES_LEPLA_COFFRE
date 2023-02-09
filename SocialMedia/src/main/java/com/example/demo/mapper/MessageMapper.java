package com.example.demo.mapper;

import com.example.demo.dto.MessageDTO;
import com.example.demo.model.Message;

import java.util.*;

public class MessageMapper {

    public static MessageDTO toMessageDTO(Message message) {
        return MessageDTO.builder()
                        .description(message.getDescription())
                        .IDauteur(message.getIDauteur())
                        .build();
    }

    public static List<MessageDTO> toMessageDTOList(List<Message> list) {
        List<MessageDTO> dtoList = new ArrayList<>();
        for (Message message : list) {
            dtoList.add(toMessageDTO(message));
        }
        return dtoList;
    }
    
    public static Message toMessage(MessageDTO dto) {
        return Message.builder()
                  .description(dto.getDescription())
                  .IDauteur(dto.getIDauteur())
                  .build();
    }

    public static List<Message> toMessageList(List<MessageDTO> list) {
        List<Message> messageList = new ArrayList<>();
        for (MessageDTO dto : list) {
            messageList.add(toMessage(dto));
        }
        return messageList;
    }
    
    
    
}