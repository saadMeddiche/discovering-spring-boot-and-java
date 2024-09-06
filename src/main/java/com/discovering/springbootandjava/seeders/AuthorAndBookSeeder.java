package com.discovering.springbootandjava.seeders;

import com.discovering.springbootandjava.conditions.SeederEnabledCondition;
import com.discovering.springbootandjava.configurations.SeederConfig;
import com.discovering.springbootandjava.entites.Author;
import com.discovering.springbootandjava.entites.Book;
import com.discovering.springbootandjava.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashSet;
import java.util.Set;

@Profile("local") @Configuration
@RequiredArgsConstructor @Conditional(SeederEnabledCondition.class)
public class AuthorAndBookSeeder {

    private final SeederConfig seederConfig;

    private final AuthorRepository authorRepository;

    @Bean
    public CommandLineRunner seedData(AuthorRepository authorRepository) {
        return _ -> {
            Faker faker = new Faker();

            for (int i = 0; i < seederConfig.getAuthorCount(); i++) { // Create 10 authors
                Author author = new Author();
                author.setFirstName(faker.name().firstName());
                author.setLastName(faker.name().lastName());

                Set<Book> books = new HashSet<>();
                for (int j = 0; j < seederConfig.getBookForEachAuthor(); j++) { // Each author has 5 books
                    Book book = new Book();
                    book.setTitle(faker.book().title());
                    book.setPrice(faker.number().randomDouble(2, 10, 100)); // Random price between 10 and 100
                    book.setAuthor(author);
                    books.add(book);
                }

                author.setBooks(books);
                authorRepository.save(author); // CascadeType.PERSIST will save books as well
            }
        };
    }
}
