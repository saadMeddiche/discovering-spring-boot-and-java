package com.discovering.springbootandjava.controllers;

import com.discovering.springbootandjava.entites.Author;
import com.discovering.springbootandjava.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(("/no-return"))
    public ResponseEntity<Void> getAuthorsNoReturn() {

        authorService.getAuthors();

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }


}
