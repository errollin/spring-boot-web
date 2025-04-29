package com.errol.springbootweb.service.impl;

import com.errol.springbootweb.entity.Book;
import com.errol.springbootweb.repository.BookRepository;
import com.errol.springbootweb.service.BookService;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return this.bookRepository.findAll();
    }
}
