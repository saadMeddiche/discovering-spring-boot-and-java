package com.discovering.springbootandjava.entites;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.Set;

@Entity
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;

    @Transient @Formula("CONCAT(first_name, ' ', last_name)")
    private String fullName;

    @OneToMany
    private Set<Book> books;
}
