package com.errol.springbootweb.component;

import com.errol.springbootweb.entity.Author;
import com.errol.springbootweb.entity.Book;
import com.errol.springbootweb.entity.Publisher;
import com.errol.springbootweb.repository.AuthorRepository;
import com.errol.springbootweb.repository.BookRepository;
import com.errol.springbootweb.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author errol = new Author();
        errol.setFirstName("Errol");
        errol.setLastName("Lin");

        Book dddBook = new Book();
        dddBook.setTitle("Domain Driven Design");
        dddBook.setIsbn("978-7-302-15584-3");

        Author savedErrol = this.authorRepository.save(errol);
        Book savedDddBook = this.bookRepository.save(dddBook);

        Author violet = new Author();
        violet.setFirstName("Violet");
        violet.setLastName("Evergarden");

        Book seBook = new Book();
        seBook.setTitle("Software Engineering");
        seBook.setIsbn("978-7-302-15583-1");

        Author savedViolet = this.authorRepository.save(violet);
        Book savedSeBook = this.bookRepository.save(seBook);

        savedErrol.getBooks().add(savedDddBook);
        savedViolet.getBooks().add(savedSeBook);
        savedDddBook.getAuthors().add(savedErrol);
        savedSeBook.getAuthors().add(savedViolet);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Errol's Publisher");
        publisher.setAddress("ShangHai");
        Publisher savedPublisher = this.publisherRepository.save(publisher);

        savedDddBook.setPublisher(savedPublisher);
        savedSeBook.setPublisher(savedPublisher);

        this.authorRepository.save(savedErrol);
        this.authorRepository.save(savedViolet);
        this.bookRepository.save(savedDddBook);
        this.bookRepository.save(savedSeBook);

        System.out.println("Initialize data: ");
        System.out.println("Author Count: " + this.authorRepository.count());
        System.out.println("Book Count: " + this.bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
