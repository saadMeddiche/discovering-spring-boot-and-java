package com.discovering.springbootandjava.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.util.Set;

@Entity
@Setter @Getter
//@NamedEntityGraph(name = "Author.books",
//        attributeNodes = @NamedAttributeNode("books")
//)
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

    @OneToMany(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY , mappedBy = "author")
    @JsonIgnoreProperties("author")
    //@JsonManagedReference
    private Set<Book> books;
}
