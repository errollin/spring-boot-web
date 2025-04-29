package com.errol.springbootweb.service;

import com.errol.springbootweb.entity.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    Iterable<Book> findAll();
}
