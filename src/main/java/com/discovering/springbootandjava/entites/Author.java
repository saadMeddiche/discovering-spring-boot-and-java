package com.discovering.springbootandjava.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.util.Set;

@Entity
@Setter @Getter
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "author_seq")
    @SequenceGenerator(
            name = "author_seq",
            allocationSize = 1,
            initialValue = 100
    )
    private Long id;

    private String firstName;

    private String lastName;

    @Formula("CONCAT(first_name, ' ', last_name)")
    private String fullName;

    @OneToMany(cascade = CascadeType.PERSIST , mappedBy = "author")
    @JsonIgnoreProperties("author")
    private Set<Book> books;
}
