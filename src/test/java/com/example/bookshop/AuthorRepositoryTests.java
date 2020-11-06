package com.example.bookshop;

import com.example.bookshop.model.Author;
import com.example.bookshop.model.Book;
import com.example.bookshop.model.Genre;
import com.example.bookshop.repository.AuthorRepository;
import com.example.bookshop.repositoryimpl.AuthorRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryTests {

    @TestConfiguration
    static class AuthorContextConfig {
        @Bean
        public  AuthorRepository authorRepository(){
            return new AuthorRepositoryImpl();
        }
    }

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void whenGetAllAuthors_thenReturnList(){
        List<Author> expected = new ArrayList<>();
        Author author = new Author();
        author.setId(1);
        author.setAuthorName("Adam");
        Author author2 = new Author();
        author2.setId(2);
        author2.setAuthorName("Smith");
        Author author3 = new Author();
        author3.setId(3);
        author3.setAuthorName("James");
        expected.add(author);
        expected.add(author2);
        expected.add(author3);

        Assert.assertEquals(expected, authorRepository.getAllAuthors().orElse(new ArrayList<>()));
    }

}
