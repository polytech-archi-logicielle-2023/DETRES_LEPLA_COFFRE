package com.example.demo.dto;
import lombok.*;

@Builder
@Data
public class UserDTO {
    private String name;
    private String email;
}