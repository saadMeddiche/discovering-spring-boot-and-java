package com.discovering.springbootandjava.repositories;

import com.discovering.springbootandjava.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository  extends JpaRepository<Book, UUID> {
}
