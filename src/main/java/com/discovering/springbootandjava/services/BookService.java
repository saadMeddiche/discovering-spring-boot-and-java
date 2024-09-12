package com.discovering.springbootandjava.services;

import com.discovering.springbootandjava.entites.Book;
import com.discovering.springbootandjava.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
