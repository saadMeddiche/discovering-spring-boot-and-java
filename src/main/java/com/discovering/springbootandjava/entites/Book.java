package com.discovering.springbootandjava.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter @Getter
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private Double price;

    @ManyToOne
    private Author author;

}
