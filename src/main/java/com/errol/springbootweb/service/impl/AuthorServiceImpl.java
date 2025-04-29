package com.errol.springbootweb.service.impl;

import com.errol.springbootweb.entity.Author;
import com.errol.springbootweb.repository.AuthorRepository;
import com.errol.springbootweb.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
