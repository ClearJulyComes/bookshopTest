package com.example.bookshop.serviceimpl;

import com.example.bookshop.model.Book;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(rollbackFor = Throwable.class)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void update(Book book) {
        Book book1 = getBookById(book.getId());
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getBookById(id).orElseThrow(()->new NoSuchElementException("Book not found."));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks().orElseThrow(()->new NoSuchElementException("Books not found."));
    }
}
