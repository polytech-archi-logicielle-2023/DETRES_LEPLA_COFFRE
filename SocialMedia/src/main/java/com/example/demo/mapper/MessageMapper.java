package com.example.demo.mapper;

import com.example.demo.dto.MessageDTO;
import com.example.demo.model.User;

import java.util.*;

public class MessageMapper {

    public static MessageDTO toUserDTO(Message message) {
        return MessageDTO.builder()
                        .name(message.getName())
                        .email(message.getEmail())
                        .build();
    }

    public static List<MessageDTO> toUserDTOList(List<User> list) {
        List<MessageDTO> dtoList = new ArrayList<>();
        for (User user : list) {
            dtoList.add(toMessageDTO(user));
        }
        return dtoList;
    }
    
    public static User toUser(MessageDTO dto) {
        return User.builder()
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .build();
    }

    public static List<User> toUserList(List<MessageDTO> list) {
        List<User> userList = new ArrayList<>();
        for (MessageDTO dto : list) {
            userList.add(toUser(dto));
        }
        return userList;
    }
    
    
}