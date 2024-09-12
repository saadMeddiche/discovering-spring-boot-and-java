package com.discovering.springbootandjava.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.UUID;

@Entity
@Setter @Getter
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private Double price;

    @ManyToOne
    //@Fetch(FetchMode.SUBSELECT)
    @JsonIgnoreProperties("books")
    //@JsonBackReference
    private Author author;

}
