package com.discovering.springbootandjava.repositories;

import com.discovering.springbootandjava.entites.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository  extends JpaRepository<Book, UUID> {

//    @EntityGraph(attributePaths = {"author"})
//     List<Book> findAll();
}
