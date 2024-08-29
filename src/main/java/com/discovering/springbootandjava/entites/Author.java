package com.discovering.springbootandjava.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.util.Set;

@Entity
@Setter @Getter
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;

    @Transient @Formula("CONCAT(first_name, ' ', last_name)")
    private String fullName;

    @OneToMany(cascade = CascadeType.PERSIST , mappedBy = "author")
    private Set<Book> books;
}
