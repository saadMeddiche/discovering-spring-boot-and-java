package com.discovering.springbootandjava.services;

import com.discovering.springbootandjava.entites.Author;
import com.discovering.springbootandjava.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    //@Cacheable("authors")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
