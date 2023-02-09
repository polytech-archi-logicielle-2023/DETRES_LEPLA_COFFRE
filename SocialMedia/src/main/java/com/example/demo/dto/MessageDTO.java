package com.example.demo.dto;
import lombok.*;

@Builder
@Data
public class MessageDTO {
    private String description;
    private Integer IDauteur;
}