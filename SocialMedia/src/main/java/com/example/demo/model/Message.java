package com.example.demo.model;

import lombok.*;
import javax.persistence.*; // import persistance library

@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message") // name of database table
public class Message {

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;
    
    @Column(name = "description", nullable = false, length = 120) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String description;

    @Column(name = "auteur", nullable = false, length = 45) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private Integer IDauteur;
}
