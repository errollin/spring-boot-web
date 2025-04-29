package com.errol.springbootweb.controller;

import com.errol.springbootweb.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors",this.authorService.findAll());
        return "authors";
    }
}
