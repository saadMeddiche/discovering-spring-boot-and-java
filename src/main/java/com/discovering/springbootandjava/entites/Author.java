package com.discovering.springbootandjava.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

import java.util.List;
import java.util.Set;

@Entity
@Setter @Getter
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @OneToMany(cascade = {CascadeType.PERSIST , CascadeType.REMOVE} , fetch = FetchType.EAGER, mappedBy = "author")
    //@Fetch(FetchMode.SUBSELECT)
    @JsonIgnoreProperties("author")
    //@JsonManagedReference
    private Set<Book> books;
}
