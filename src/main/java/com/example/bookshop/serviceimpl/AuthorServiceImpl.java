package com.example.bookshop.serviceimpl;

import com.example.bookshop.model.Author;
import com.example.bookshop.model.Book;
import com.example.bookshop.repository.AuthorRepository;
import com.example.bookshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(rollbackFor = Throwable.class)
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors().orElseThrow(()->new NoSuchElementException("Authors not found."));
    }

    @Override
    public void update(Author author) {
        Author author1 = authorRepository.find(author)
                .orElseThrow(()->new NoSuchElementException("Author not found."));
        authorRepository.save(author);
    }
}
