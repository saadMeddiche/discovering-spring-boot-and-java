package com.discovering.springbootandjava.controllers;

import com.discovering.springbootandjava.entites.Author;
import com.discovering.springbootandjava.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<Author>> getAuthors() {

        List<Author> authors = authorService.getAuthors();

        return ResponseEntity.ok(authors);
    }


}
