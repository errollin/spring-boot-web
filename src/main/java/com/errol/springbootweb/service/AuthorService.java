package com.errol.springbootweb.service;

import com.errol.springbootweb.entity.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
