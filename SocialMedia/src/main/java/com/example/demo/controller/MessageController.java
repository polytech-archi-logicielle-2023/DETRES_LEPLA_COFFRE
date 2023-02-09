package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.http.*;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

import java.util.*;

@RequestMapping("/message")
@Controller
public class MessageController {


    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("")
    public ResponseEntity<List<MessageDTO>> getAllMessage() {

        List<Message> message = messageService.getAllMessage();
        List<MessageDTO> messageDtos = MessageMapper.toMessageDTOList(message);

        return ResponseEntity.ok(messageDtos);
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable Integer messageId) {

        Message message = messageService.getMessageById(messageId);

        if (message == null) {
            return ResponseEntity.notFound().build();
        } 
        MessageDTO dto = MessageMapper.toMessageDTO(message);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<MessageDTO> createMessageUse(@RequestBody MessageDTO dto) {
        Message fromDto = MessageMapper.toMessage(dto);
        Message createdMessage = messageService.createMessage(fromDto);
        if (createdMessage == null) {
            return ResponseEntity.badRequest().build();
        }
        MessageDTO createdMessageDto = MessageMapper.toMessageDTO(createdMessage);
        return ResponseEntity.ok(createdMessageDto);
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<Message> deleteMessageById(@PathVariable Integer messageId) {

        Message message = messageService.getMessageById(messageId);

        if (message == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        messageService.deleteMessage(message);
        return ResponseEntity.ok(message);
    }
    
}



